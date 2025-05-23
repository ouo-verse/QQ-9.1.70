package com.gcloudsdk.apollo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.raft.raftframework.sla.SLAReporter;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/* compiled from: P */
/* loaded from: classes2.dex */
class MsgWorker implements Runnable {
    private static String LOGTAG = "NetInterfaceHelper";
    private Context mContext;
    private boolean mPermissionGranted = false;
    private HashMap<String, Network> mNetworks = new HashMap<>();
    private Vector<EventMsg> mMsgQueue = new Vector<>(128);
    private Vector<String> mDomains = new Vector<>(128);

    public MsgWorker(Context context) {
        this.mContext = context;
    }

    private void dealBind(int i3, String str, int i16) {
        Network network;
        Log.i(LOGTAG, "dealBind:" + str + " for " + i3);
        if (!this.mPermissionGranted) {
            Log.e(LOGTAG, "mPermissionGranted is false");
            return;
        }
        FileDescriptor fileDescriptor = new FileDescriptor();
        try {
            Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            try {
                declaredField.setInt(fileDescriptor, i3);
                synchronized (this) {
                    network = this.mNetworks.get(str);
                }
                if (network == null) {
                    bindCallback(str, i3, 1, i16);
                    return;
                }
                try {
                    network.bindSocket(fileDescriptor);
                    bindCallback(str, i3, 0, i16);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    bindCallback(str, i3, -2, i16);
                }
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
                bindCallback(str, i3, -1, i16);
            }
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            bindCallback(str, i3, -1, i16);
        }
    }

    private void dealWarm(String str) {
        HashMap hashMap;
        Log.i(LOGTAG, "dealWarm:" + str);
        if (!this.mPermissionGranted) {
            Log.e(LOGTAG, "mPermissionGranted is false");
            return;
        }
        synchronized (this) {
            this.mDomains.add(str);
            hashMap = (HashMap) this.mNetworks.clone();
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            try {
                dnsQueryCallback(str, (String) entry.getKey(), ((Network) entry.getValue()).getByName(str).getHostAddress(), 4);
            } catch (UnknownHostException e16) {
                e16.printStackTrace();
            }
        }
    }

    private String ifname(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "unknown";
                    }
                    return "vpn";
                }
                return "ethernet";
            }
            return "wifi";
        }
        return "cellular";
    }

    public native void bindCallback(String str, int i3, int i16, int i17);

    public boolean checkManifestPermission() {
        if (this.mContext == null) {
            Log.i(LOGTAG, "checkManifestPermission mContext == null");
            return false;
        }
        try {
            String[] strArr = {SLAReporter.PERMISSION_NET, "android.permission.CHANGE_NETWORK_STATE", "android.permission.ACCESS_NETWORK_STATE"};
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 3; i3++) {
                if (ContextCompat.checkSelfPermission(this.mContext, strArr[i3]) != 0) {
                    arrayList.add(strArr[i3]);
                    Log.i(LOGTAG, "checkManifestPermission:" + strArr[i3] + " has no permission");
                }
            }
            if (arrayList.isEmpty()) {
                this.mPermissionGranted = true;
            } else {
                this.mPermissionGranted = false;
            }
            return false;
        } catch (Exception unused) {
            this.mPermissionGranted = false;
            return false;
        }
    }

    public native void dnsQueryCallback(String str, String str2, String str3, int i3);

    public void initCM() {
        Log.i(LOGTAG, "initCM");
        checkManifestPermission();
        if (!this.mPermissionGranted) {
            Log.e(LOGTAG, "mPermissionGranted is false");
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(1, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i3) {
                MsgWorker.this.setNetwork(1, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(1, null);
            }
        };
        NetworkRequest build2 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.2
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(0, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i3) {
                MsgWorker.this.setNetwork(0, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(0, null);
            }
        };
        NetworkRequest build3 = new NetworkRequest.Builder().addTransportType(3).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback3 = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.3
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(3, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i3) {
                MsgWorker.this.setNetwork(3, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(3, null);
            }
        };
        NetworkRequest build4 = new NetworkRequest.Builder().addTransportType(4).addCapability(12).build();
        ConnectivityManager.NetworkCallback networkCallback4 = new ConnectivityManager.NetworkCallback() { // from class: com.gcloudsdk.apollo.MsgWorker.4
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                MsgWorker.this.setNetwork(4, network);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLosing(Network network, int i3) {
                MsgWorker.this.setNetwork(4, null);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                MsgWorker.this.setNetwork(4, null);
            }
        };
        connectivityManager.requestNetwork(build, networkCallback);
        connectivityManager.requestNetwork(build2, networkCallback2);
        connectivityManager.requestNetwork(build3, networkCallback3);
        connectivityManager.requestNetwork(build4, networkCallback4);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            if (this.mMsgQueue.isEmpty()) {
                try {
                    LockMethodProxy.sleep(20L);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                try {
                    EventMsg firstElement = this.mMsgQueue.firstElement();
                    this.mMsgQueue.remove(0);
                    int i3 = firstElement.cmd;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 255) {
                                initCM();
                            }
                        } else {
                            dealBind(firstElement.arg1, firstElement.strarg, firstElement.arg2);
                        }
                    } else {
                        dealWarm(firstElement.strarg);
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    public void sendMessage(EventMsg eventMsg) {
        this.mMsgQueue.add(eventMsg);
    }

    public void setNetwork(int i3, Network network) {
        String ifname = ifname(i3);
        synchronized (this) {
            if (network == null) {
                Log.i(LOGTAG, "remove net:" + i3);
                this.mNetworks.remove(ifname);
                return;
            }
            Log.i(LOGTAG, "setNetwork  net:" + i3 + " network:" + network.toString());
            this.mNetworks.put(ifname, network);
            for (Object obj : this.mDomains.toArray()) {
                String str = (String) obj;
                try {
                    dnsQueryCallback(str, ifname, network.getByName(str).getHostAddress(), 4);
                } catch (UnknownHostException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
