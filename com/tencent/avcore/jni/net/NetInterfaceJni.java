package com.tencent.avcore.jni.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
@RequiresApi(21)
/* loaded from: classes3.dex */
public class NetInterfaceJni {
    static IPatchRedirector $redirector_ = null;
    private static final int PROTOCOL_IPV4 = 0;
    private static final int PROTOCOL_IPV6 = 1;
    private static final int REQUEST_NETWORK_TIMEOUT_MS = 100;
    private static final String TAG = "NetInterfaceJni";
    private static volatile NetInterfaceJni sInstance;
    private Context mContext;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16077);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            sInstance = null;
        }
    }

    NetInterfaceJni() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bindNetwork(Network network, int i3) {
        if (network == null) {
            return false;
        }
        try {
            FileDescriptor fileDescriptor = new FileDescriptor();
            Field declaredField = FileDescriptor.class.getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            declaredField.setInt(fileDescriptor, i3);
            network.bindSocket(fileDescriptor);
            AVCoreLog.e(TAG, "bind cellular network success, network[" + network.getNetworkHandle() + "]");
            return true;
        } catch (Exception unused) {
            AVCoreLog.e(TAG, "bind cellular network failed, network[" + network.getNetworkHandle() + "]");
            return false;
        }
    }

    private void callBackStartRoomAccelerate() {
        NetworkAccelerationAdapterProxy.getInstance().startRoomAccelerate();
    }

    private boolean callbackBindCellularNetwork(int i3) {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            boolean[] zArr = {false};
            if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                return bindNetwork(connectivityManager.getActiveNetwork(), i3);
            }
            if (isMobileDataEnabled()) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                builder.addTransportType(0);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(zArr, i3, countDownLatch) { // from class: com.tencent.avcore.jni.net.NetInterfaceJni.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CountDownLatch val$countDownLatch;
                    final /* synthetic */ int val$fd;
                    final /* synthetic */ boolean[] val$isSuccess;

                    {
                        this.val$isSuccess = zArr;
                        this.val$fd = i3;
                        this.val$countDownLatch = countDownLatch;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, NetInterfaceJni.this, zArr, Integer.valueOf(i3), countDownLatch);
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
                            return;
                        }
                        AVCoreLog.e(NetInterfaceJni.TAG, "callbackBindCellularNetwork, cellular onAvailable");
                        this.val$isSuccess[0] = NetInterfaceJni.this.bindNetwork(network, this.val$fd);
                        this.val$countDownLatch.countDown();
                    }
                };
                try {
                    connectivityManager.requestNetwork(builder.build(), networkCallback);
                    countDownLatch.await(100L, TimeUnit.MILLISECONDS);
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                } catch (InterruptedException unused) {
                    AVCoreLog.e(TAG, "callbackBindCellularNetwork, request cellular network timeout 100ms");
                } catch (RuntimeException e16) {
                    AVCoreLog.e(TAG, "callbackBindCellularNetwork, request cellular network RuntimeException[" + e16.getMessage() + "]");
                } catch (Exception e17) {
                    AVCoreLog.e(TAG, "callbackBindCellularNetwork, bind cellular socket exception[" + e17.getMessage() + "]");
                }
            }
            return zArr[0];
        }
        AVCoreLog.e(TAG, "callbackBindCellularNetwork, cellular network unAvailable");
        return false;
    }

    private void callbackBindUDPSocket(int i3, int i16, String str, int i17, String str2, int i18, int i19) {
        SocketInfo socketInfo = new SocketInfo();
        socketInfo.destIP = new String(str2);
        socketInfo.destPort = i18;
        socketInfo.srcIP = new String(str);
        socketInfo.srcPort = i17;
        socketInfo.f77483fd = i19;
        socketInfo.f77484protocol = i3;
        socketInfo.chnType = i16;
        NetworkAccelerationAdapterProxy.getInstance().bindToNetInterface(socketInfo);
    }

    private NicIpAddress callbackGetNicIpAddress(int i3) {
        if (i3 == 1) {
            return getWifiIpAddress();
        }
        if (i3 == 0) {
            return tryGetCellularIpAddress();
        }
        return null;
    }

    private String callbackGetSimOperator() {
        Context context = this.mContext;
        if (context == null) {
            return "";
        }
        return DeviceInfoMonitor.getSimOperator((TelephonyManager) context.getSystemService("phone"));
    }

    private void callbackStopRoomAccelerate() {
        NetworkAccelerationAdapterProxy.getInstance().stopRoomAccelerate();
    }

    private void callbackUnbindUDPSocket(int i3, int i16, String str, int i17, String str2, int i18, int i19) {
        SocketInfo socketInfo = new SocketInfo();
        socketInfo.destIP = new String(str2);
        socketInfo.destPort = i18;
        socketInfo.srcIP = new String(str);
        socketInfo.srcPort = i17;
        socketInfo.f77483fd = i19;
        socketInfo.f77484protocol = i3;
        socketInfo.chnType = i16;
        NetworkAccelerationAdapterProxy.getInstance().unBindToNetInterface(socketInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NicIpAddress getCellularIpAddress() {
        NicIpAddress nicIpAddress = new NicIpAddress();
        try {
            Iterator it = Collections.list(NetworkMonitor.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.getName().startsWith("rmnet") || networkInterface.getName().startsWith("ccmni")) {
                    Iterator it5 = Collections.list(NetworkMonitor.getInetAddresses(networkInterface)).iterator();
                    boolean z16 = false;
                    boolean z17 = false;
                    while (it5.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it5.next();
                        if (!inetAddress.isLoopbackAddress()) {
                            if ((inetAddress instanceof Inet4Address) && !z16) {
                                nicIpAddress.ipv4Address = inetAddress.getHostAddress();
                                z16 = true;
                            } else if ((inetAddress instanceof Inet6Address) && !z17) {
                                nicIpAddress.ipv6Address = inetAddress.getHostAddress();
                                z17 = true;
                            }
                        }
                    }
                    if (z16 || z17) {
                        break;
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        AVCoreLog.e(TAG, "cellular, ipv4[" + nicIpAddress.ipv4Address + "], ipv6[" + nicIpAddress.ipv6Address + "]");
        return nicIpAddress;
    }

    public static NetInterfaceJni getInstance() {
        synchronized (NetInterfaceJni.class) {
            if (sInstance == null) {
                synchronized (NetInterfaceJni.class) {
                    sInstance = new NetInterfaceJni();
                }
            }
        }
        return sInstance;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r3.hasNext() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0042, code lost:
    
        r5 = (java.net.InetAddress) r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
    
        if (r5.isLoopbackAddress() != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if ((r5 instanceof java.net.Inet4Address) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
    
        if ((r5 instanceof java.net.Inet6Address) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0086, code lost:
    
        r2.ipv6Address = r5.getHostAddress();
        com.tencent.avcore.util.AVCoreLog.i(com.tencent.avcore.jni.net.NetInterfaceJni.TAG, "wifi network available name[" + r4.getName() + "], addr[" + r5.getHostAddress() + "]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r2.ipv4Address = r5.getHostAddress();
        com.tencent.avcore.util.AVCoreLog.i(com.tencent.avcore.jni.net.NetInterfaceJni.TAG, "wifi network available name[" + r4.getName() + "], addr[" + r5.getHostAddress() + "]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
    
        r3 = java.util.Collections.list(com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getInetAddresses(r4)).iterator();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private NicIpAddress getWifiIpAddress() {
        NicIpAddress nicIpAddress = new NicIpAddress();
        try {
            Iterator it = Collections.list(NetworkMonitor.getNetworkInterfaces()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.getName().startsWith("wlan0")) {
                    break;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        AVCoreLog.e(TAG, "wifi, ipv4[" + nicIpAddress.ipv4Address + "], ipv6[" + nicIpAddress.ipv6Address + "]");
        return nicIpAddress;
    }

    private boolean isMobileDataEnabled() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            AVCoreLog.e(TAG, "isMobileDataEnabled failed");
            return false;
        }
    }

    private native void nativeInit();

    private NicIpAddress tryGetCellularIpAddress() {
        NicIpAddress nicIpAddress = new NicIpAddress();
        NicIpAddress[] nicIpAddressArr = {nicIpAddress};
        Context context = this.mContext;
        if (context == null) {
            return nicIpAddress;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (NetworkMonitor.getType(activeNetworkInfo) == 0) {
                nicIpAddressArr[0] = getCellularIpAddress();
            } else if (isMobileDataEnabled()) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                builder.addTransportType(0);
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback(nicIpAddressArr, countDownLatch) { // from class: com.tencent.avcore.jni.net.NetInterfaceJni.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CountDownLatch val$countDownLatch;
                    final /* synthetic */ NicIpAddress[] val$nicIpAddress;

                    {
                        this.val$nicIpAddress = nicIpAddressArr;
                        this.val$countDownLatch = countDownLatch;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, NetInterfaceJni.this, nicIpAddressArr, countDownLatch);
                        }
                    }

                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onAvailable(Network network) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
                            return;
                        }
                        AVCoreLog.e(NetInterfaceJni.TAG, "tryGetCellularIpAddress, cellular onAvailable");
                        this.val$nicIpAddress[0] = NetInterfaceJni.this.getCellularIpAddress();
                        this.val$countDownLatch.countDown();
                    }
                };
                try {
                    connectivityManager.requestNetwork(builder.build(), networkCallback);
                    countDownLatch.await(100L, TimeUnit.MILLISECONDS);
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                } catch (InterruptedException unused) {
                    AVCoreLog.e(TAG, "tryGetCellularIpAddress, request cellular network timeout 100ms");
                } catch (RuntimeException e16) {
                    AVCoreLog.e(TAG, "tryGetCellularIpAddress, request cellular network RuntimeException[" + e16.getMessage() + "]");
                } catch (Exception e17) {
                    AVCoreLog.e(TAG, "tryGetCellularIpAddress, get cellular ip exception[" + e17.getMessage() + "]");
                }
            }
            return nicIpAddressArr[0];
        }
        AVCoreLog.e(TAG, "tryGetCellularIpAddress, cellular network unAvailable");
        return nicIpAddressArr[0];
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        } else {
            this.mContext = context;
            nativeInit();
        }
    }

    public native void nativeUnInit();

    public void unInit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            nativeUnInit();
            this.mContext = null;
        }
    }
}
