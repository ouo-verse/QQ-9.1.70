package com.qq.wx.voice.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ManagerDeviceInfo {

    /* renamed from: b, reason: collision with root package name */
    private int f41109b;

    /* renamed from: c, reason: collision with root package name */
    private int f41110c;

    /* renamed from: d, reason: collision with root package name */
    private String f41111d;

    /* renamed from: e, reason: collision with root package name */
    private String f41112e;

    /* renamed from: f, reason: collision with root package name */
    private String f41113f;

    /* renamed from: g, reason: collision with root package name */
    private String f41114g;

    /* renamed from: h, reason: collision with root package name */
    private String f41115h;

    /* renamed from: i, reason: collision with root package name */
    private int f41116i;

    /* renamed from: j, reason: collision with root package name */
    private String f41117j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f41118k;

    /* renamed from: l, reason: collision with root package name */
    private String f41119l;

    /* renamed from: n, reason: collision with root package name */
    private String f41121n;

    /* renamed from: a, reason: collision with root package name */
    private Context f41108a = null;

    /* renamed from: m, reason: collision with root package name */
    private int f41120m = 0;

    private String a(String str) {
        try {
            String a16 = a((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(InstalledAppListMonitor.getPackageInfo(this.f41108a.getPackageManager(), str, 64).signatures[0].toByteArray())));
            StringBuffer stringBuffer = new StringBuffer();
            for (int i3 = 0; i3 < a16.length(); i3++) {
                stringBuffer.append(a16.charAt(i3));
            }
            return stringBuffer.toString();
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (CertificateException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public String getAndroid_package_name() {
        return this.f41113f;
    }

    public String getAndroid_signature() {
        return this.f41112e;
    }

    public String getDeviceInfo() {
        return this.f41117j;
    }

    public String getGuid() {
        return this.f41114g;
    }

    public String getIP() {
        return this.f41121n;
    }

    public boolean getIsWap() {
        return this.f41118k;
    }

    public String getNetType() {
        return this.f41115h;
    }

    public int getNetTypeNum() {
        String str = this.f41115h;
        if (str == QADNetStatus.G_2) {
            return 1;
        }
        if (str == "ct3g") {
            return 2;
        }
        if (str == "cu3g") {
            return 3;
        }
        if (str == "wifi") {
            return 4;
        }
        return 0;
    }

    public int getOs() {
        return this.f41109b;
    }

    public int getOsver() {
        return this.f41110c;
    }

    public String getSigInfo() {
        return this.f41111d;
    }

    public String getWapProxyIP() {
        String str = this.f41119l;
        if (str != null) {
            return str;
        }
        return null;
    }

    public int getWapProxyPort() {
        return this.f41120m;
    }

    public int init(Context context) {
        this.f41108a = context;
        this.f41109b = 2;
        setOSver();
        setGuid();
        setDeviceInfo();
        return setSigInfo();
    }

    public void setAndroid_package_name(String str) {
        this.f41113f = str;
    }

    public void setAndroid_signature(String str) {
        this.f41112e = str;
    }

    public void setDeviceInfo() {
        this.f41117j = DeviceInfoMonitor.getModel();
    }

    public void setGuid() {
        if (this.f41108a != null) {
            this.f41114g = "Guid";
        }
    }

    public void setGuidNeedService() {
        Context context = this.f41108a;
        if (context != null) {
            String deviceId = DeviceInfoMonitor.getDeviceId((TelephonyManager) context.getSystemService("phone"));
            this.f41114g = deviceId;
            this.f41114g = String.valueOf(deviceId) + "-";
            this.f41114g = String.valueOf(this.f41114g) + NetworkMonitor.getMacAddress(LocationMonitor.getConnectionInfo((WifiManager) this.f41108a.getSystemService("wifi")));
        }
    }

    public void setIpAddr() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterfaces.nextElement());
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        this.f41121n = nextElement.getHostAddress();
                    }
                }
            }
        } catch (SocketException e16) {
            e16.printStackTrace();
        }
        this.f41121n = null;
    }

    public void setNetType(String str) {
        this.f41115h = str;
    }

    public void setOSver() {
        this.f41110c = Build.VERSION.SDK_INT;
    }

    public int setSigInfo() {
        String packageName = this.f41108a.getPackageName();
        setAndroid_package_name(packageName);
        String a16 = a(packageName);
        setAndroid_signature(a16);
        if (packageName != null && a16 != null) {
            this.f41111d = packageName + ";" + a16;
            return 0;
        }
        return -1;
    }

    public void setWap() {
        int defaultPort;
        this.f41118k = false;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f41108a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && NetworkMonitor.getType(activeNetworkInfo) == 0) {
            this.f41118k = true;
            if (Proxy.getDefaultPort() == -1) {
                defaultPort = 80;
            } else {
                defaultPort = Proxy.getDefaultPort();
            }
            this.f41120m = defaultPort;
            this.f41119l = Proxy.getDefaultHost();
        }
    }

    public int setNetType() {
        Context context = this.f41108a;
        if (context == null) {
            return -101;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -201;
        }
        int type = NetworkMonitor.getType(activeNetworkInfo);
        if (type == 0) {
            this.f41115h = NetworkMonitor.netGetExInfo(activeNetworkInfo);
            int subtype = NetworkMonitor.getSubtype(activeNetworkInfo);
            this.f41116i = subtype;
            switch (subtype) {
                case 1:
                    this.f41115h = QADNetStatus.G_2;
                    break;
                case 2:
                    this.f41115h = QADNetStatus.G_2;
                    break;
                case 3:
                    this.f41115h = "cu3g";
                    break;
                case 4:
                    this.f41115h = QADNetStatus.G_2;
                    break;
                case 5:
                case 7:
                case 14:
                default:
                    this.f41115h = "other";
                    break;
                case 6:
                    this.f41115h = "ct3g";
                    break;
                case 8:
                    this.f41115h = "cu3g";
                    break;
                case 9:
                    this.f41115h = "other";
                    break;
                case 10:
                    this.f41115h = "other";
                    break;
                case 11:
                    this.f41115h = "other";
                    break;
                case 12:
                    this.f41115h = "ct3g";
                    break;
                case 13:
                    this.f41115h = "other";
                    break;
                case 15:
                    this.f41115h = "other";
                    break;
            }
        } else if (type == 1) {
            this.f41115h = "wifi";
        }
        this.f41115h = "wifi";
        return 0;
    }

    private static String a(X509Certificate x509Certificate) {
        try {
            return Hex.encode(Hex.generateMD5(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
