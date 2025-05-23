package com.tencent.gcloud.netinterface;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.raft.raftframework.sla.SLAReporter;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public class MsgWorker implements Runnable {
    static IPatchRedirector $redirector_;
    private static String LOGTAG;
    private Context mContext;
    private Vector<String> mDomains;
    private boolean mInit;
    private Vector<EventMsg> mMsgQueue;
    private HashMap<String, Network> mNetworks;
    private boolean mPermissionGranted;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            LOGTAG = "NetInterfaceHelper";
        }
    }

    public MsgWorker(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
            return;
        }
        this.mPermissionGranted = false;
        this.mInit = false;
        this.mContext = context;
        this.mNetworks = new HashMap<>();
        this.mMsgQueue = new Vector<>(128);
        this.mDomains = new Vector<>(128);
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
                    bindCallback(str, i3, -1006, i16);
                    return;
                }
                try {
                    network.bindSocket(fileDescriptor);
                    bindCallback(str, i3, 0, i16);
                } catch (IOException e16) {
                    e16.printStackTrace();
                    bindCallback(str, i3, -1004, i16);
                }
            } catch (IllegalAccessException e17) {
                e17.printStackTrace();
                bindCallback(str, i3, -1002, i16);
            }
        } catch (NoSuchFieldException e18) {
            e18.printStackTrace();
            bindCallback(str, i3, -1001, i16);
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
                dnsQueryCallback(str, (String) entry.getKey(), "UnknownHostException", -1);
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

    public static boolean isWiFiEnable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable() || NetworkMonitor.getType(activeNetworkInfo) != 1) {
            return false;
        }
        return true;
    }

    public native void bindCallback(String str, int i3, int i16, int i17);

    public boolean checkManifestPermission() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (this.mContext == null) {
            return false;
        }
        try {
            String[] strArr = {SLAReporter.PERMISSION_NET, "android.permission.CHANGE_NETWORK_STATE", "android.permission.ACCESS_NETWORK_STATE"};
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 3; i3++) {
                if (ContextCompat.checkSelfPermission(this.mContext, strArr[i3]) != 0) {
                    Log.e(LOGTAG, "Permission " + strArr[i3] + " is not granted");
                    arrayList.add(strArr[i3]);
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

    public native void connectivityManagerException(String str);

    public native void dnsQueryCallback(String str, String str2, String str3, int i3);

    public int getNetStatus(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).intValue();
        }
        if (context == null) {
            return 0;
        }
        boolean isWiFiEnable = isWiFiEnable(context);
        if (isMobileEnable(context)) {
            return (isWiFiEnable ? 1 : 0) | 16;
        }
        return isWiFiEnable ? 1 : 0;
    }

    public void initCM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (this.mInit) {
            return;
        }
        this.mInit = true;
        Log.i(LOGTAG, "initCM");
        setNetworkStatus(getNetStatus(this.mContext));
        versionAvailable(true);
        checkManifestPermission();
        if (!this.mPermissionGranted) {
            Log.e(LOGTAG, "mPermissionGranted is false");
            permissionGranted(false);
            return;
        }
        permissionGranted(true);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            NetworkRequest build = new NetworkRequest.Builder().addTransportType(1).addCapability(12).build();
            ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.gcloud.netinterface.MsgWorker.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgWorker.this);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(1, network);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLosing(Network network, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) network, i3);
                    } else {
                        MsgWorker.this.setNetwork(1, null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(1, null);
                    }
                }
            };
            NetworkRequest build2 = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
            ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.gcloud.netinterface.MsgWorker.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgWorker.this);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(0, network);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLosing(Network network, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) network, i3);
                    } else {
                        MsgWorker.this.setNetwork(0, null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(0, null);
                    }
                }
            };
            NetworkRequest build3 = new NetworkRequest.Builder().addTransportType(3).addCapability(12).build();
            ConnectivityManager.NetworkCallback networkCallback3 = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.gcloud.netinterface.MsgWorker.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgWorker.this);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(3, network);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLosing(Network network, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) network, i3);
                    } else {
                        MsgWorker.this.setNetwork(3, null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(3, null);
                    }
                }
            };
            NetworkRequest build4 = new NetworkRequest.Builder().addTransportType(4).addCapability(12).build();
            ConnectivityManager.NetworkCallback networkCallback4 = new ConnectivityManager.NetworkCallback() { // from class: com.tencent.gcloud.netinterface.MsgWorker.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgWorker.this);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(4, network);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLosing(Network network, int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, (Object) network, i3);
                    } else {
                        MsgWorker.this.setNetwork(4, null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) network);
                    } else {
                        MsgWorker.this.setNetwork(4, null);
                    }
                }
            };
            connectivityManager.requestNetwork(build, networkCallback);
            connectivityManager.requestNetwork(build2, networkCallback2);
            connectivityManager.requestNetwork(build3, networkCallback3);
            connectivityManager.requestNetwork(build4, networkCallback4);
        } catch (Exception e16) {
            connectivityManagerException("");
            e16.printStackTrace();
        }
    }

    public boolean isMobileEnable(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context)).booleanValue();
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public native void permissionGranted(boolean z16);

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        while (true) {
            if (this.mMsgQueue.isEmpty()) {
                try {
                    LockMethodProxy.sleep(100L);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else {
                try {
                    EventMsg firstElement = this.mMsgQueue.firstElement();
                    this.mMsgQueue.remove(0);
                    int i3 = firstElement.cmd;
                    if (i3 != 1) {
                        if (i3 == 2) {
                            dealBind(firstElement.arg1, firstElement.strarg, firstElement.arg2);
                        }
                    } else {
                        initCM();
                        dealWarm(firstElement.strarg);
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    public void sendMessage(EventMsg eventMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) eventMsg);
        } else {
            this.mMsgQueue.add(eventMsg);
        }
    }

    public native void setInterfaces(String str);

    public void setNetwork(int i3, Network network) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3, (Object) network);
            return;
        }
        String ifname = ifname(i3);
        String str = "";
        synchronized (this) {
            if (network == null) {
                Log.i(LOGTAG, "remove net:" + i3);
                this.mNetworks.remove(ifname);
                return;
            }
            Log.i(LOGTAG, "setNetwork  net:" + i3 + " network:" + network.toString());
            this.mNetworks.put(ifname, network);
            Object[] array = this.mDomains.toArray();
            String str2 = "";
            Iterator<String> it = this.mNetworks.keySet().iterator();
            while (it.hasNext()) {
                str = str + str2 + it.next();
                str2 = "-";
            }
            setInterfaces(str);
            for (Object obj : array) {
                String str3 = (String) obj;
                try {
                    dnsQueryCallback(str3, ifname, network.getByName(str3).getHostAddress(), 4);
                } catch (UnknownHostException e16) {
                    dnsQueryCallback(str3, ifname, "UnknownHostException", -1);
                    e16.printStackTrace();
                } catch (Exception e17) {
                    dnsQueryCallback(str3, ifname, "Exception", -2);
                    e17.printStackTrace();
                }
            }
        }
    }

    public native void setNetworkStatus(int i3);

    public native void versionAvailable(boolean z16);
}
