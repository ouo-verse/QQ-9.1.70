package com.tencent.qimei.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresPermission;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.common.PackageConstants;
import com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qimei.ag.e;
import com.tencent.qimei.ag.h;
import com.tencent.qimei.f.d;
import com.tencent.qimei.uin.U;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Map;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f343257a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f343258b;

    /* renamed from: c, reason: collision with root package name */
    public static String f343259c;

    /* compiled from: P */
    /* renamed from: com.tencent.qimei.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9318a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final String f343260a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f343261b;

        public C9318a(String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Boolean.valueOf(z16));
            } else {
                this.f343260a = str;
                this.f343261b = z16;
            }
        }
    }

    public static Object a(String str, Object obj, String str2) {
        try {
            Field declaredField = Class.forName(str).getDeclaredField(str2);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException unused) {
            return null;
        }
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f343259c)) {
            f343259c = String.format("file://%s/jsfile/tun-cos-1258344701.html", context.getFilesDir().getAbsolutePath());
        }
        return f343259c;
    }

    public static String c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", str);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public static String a(String str) {
        StringBuilder sb5 = new StringBuilder(str);
        for (int length = sb5.length(); length < 16; length++) {
            sb5.append("0");
        }
        return sb5.toString().substring(0, 16);
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static boolean b() {
        ConnectivityManager connectivityManager;
        boolean z16;
        Context e16 = com.tencent.qimei.ap.d.c().e();
        boolean z17 = false;
        if (e16 == null || (connectivityManager = (ConnectivityManager) e16.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            z16 = a(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()));
            if (!z16) {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                } catch (SecurityException e17) {
                    e = e17;
                    e.printStackTrace();
                    com.tencent.qimei.ad.c.a("NET", "No network status query permission, please add in AndroidManifest file  <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />", new Object[0]);
                    return z16;
                } catch (Exception e18) {
                    e = e18;
                    z17 = z16;
                    com.tencent.qimei.ad.c.a(e);
                    return z17;
                }
            }
        } catch (SecurityException e19) {
            e = e19;
            z16 = false;
        } catch (Exception e26) {
            e = e26;
        }
        return z16;
    }

    public static String c(Context context) {
        boolean z16;
        if (context == null) {
            return "0";
        }
        String d16 = com.tencent.qimei.u.a.d();
        String[] split = context.getFilesDir().getAbsolutePath().split("/");
        int i3 = 0;
        if (split.length >= 5) {
            String str = split[3];
            String str2 = split[4];
            try {
                Integer.parseInt(str);
                z16 = true;
            } catch (NumberFormatException unused) {
                z16 = false;
            }
            if (z16 && !str.equals("0")) {
                i3 = 1;
            } else if (!str2.equals(d16)) {
                i3 = 2;
            }
        }
        return String.valueOf(i3);
    }

    public static String a(HttpURLConnection httpURLConnection) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        InputStream inputStream = httpURLConnection.getInputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
                com.tencent.qimei.ab.a.a(byteArrayOutputStream);
                com.tencent.qimei.ab.a.a(inputStream);
                return byteArrayOutputStream2;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static void b(String str, String str2) {
        h a16 = h.a();
        a16.getClass();
        e eVar = new e();
        eVar.f342975a.put("6", "1010");
        eVar.f342975a.put("7", str2);
        a16.a(eVar, "v2", str);
    }

    public static HttpURLConnection a(String str, String str2, Map<String, String> map) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setInstanceFollowRedirects(true);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        httpURLConnection.setDoInput(true);
        if (str2.compareTo("POST") == 0) {
            httpURLConnection.setDoOutput(true);
        }
        httpURLConnection.setUseCaches(false);
        httpURLConnection.connect();
        return httpURLConnection;
    }

    public static void a(String str, String str2, @Nullable Bundle bundle) {
        Context e16 = com.tencent.qimei.ap.d.c().e();
        if (e16 == null) {
            return;
        }
        Intent intent = new Intent(str);
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        e16.sendBroadcast(intent);
    }

    public static boolean a(int i3, int i16) {
        return (i16 & i3) == i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x01a3, code lost:
    
        if (r9 == false) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str) throws Exception {
        Pair pair;
        byte[] bArr;
        short s16;
        int i3;
        if (str == null) {
            return "";
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        int length = (int) randomAccessFile.length();
        if (length < 22) {
            com.tencent.qimei.ab.a.a(randomAccessFile);
            return "";
        }
        Pair<ByteBuffer, Long> a16 = a(randomAccessFile, length, 0);
        if (a16 == null) {
            a16 = a(randomAccessFile, length, 65535);
        }
        if (a16 == null) {
            com.tencent.qimei.ab.a.a(randomAccessFile);
            return "";
        }
        ByteBuffer byteBuffer = (ByteBuffer) a16.first;
        Long l3 = (Long) a16.second;
        if (l3.longValue() >= 20) {
            randomAccessFile.seek(l3.longValue() - 20);
            if (randomAccessFile.readInt() == Integer.reverse(117853008)) {
                com.tencent.qimei.ab.a.a(randomAccessFile);
                return "";
            }
        }
        long j3 = byteBuffer.getInt(byteBuffer.position() + 16) & 4294967295L;
        if (j3 >= l3.longValue()) {
            com.tencent.qimei.ab.a.a(randomAccessFile);
            return "";
        }
        if ((4294967295L & byteBuffer.getInt(byteBuffer.position() + 12)) + j3 != l3.longValue()) {
            com.tencent.qimei.ab.a.a(randomAccessFile);
            return "";
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        allocate.order(byteOrder);
        randomAccessFile.seek(j3 - allocate.capacity());
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_LO && allocate.getLong(16) == ApkSignatureSchemeV2Verifier.APK_SIG_BLOCK_MAGIC_HI) {
            long j16 = allocate.getLong(0);
            if (j16 >= allocate.capacity() && j16 <= 2147483639) {
                long j17 = j16 + 8;
                long j18 = j3 - j17;
                if (j18 >= 0) {
                    ByteBuffer allocate2 = ByteBuffer.allocate((int) j17);
                    allocate2.order(byteOrder);
                    randomAccessFile.seek(j18);
                    randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
                    if (allocate2.getLong(0) == j17 - 8) {
                        pair = Pair.create(allocate2, Long.valueOf(j18));
                        if (pair != null) {
                            ByteBuffer byteBuffer2 = (ByteBuffer) pair.first;
                            byteBuffer2.position(0);
                            byteBuffer2.getLong();
                            int capacity = byteBuffer2.capacity() - 24;
                            boolean z16 = false;
                            boolean z17 = false;
                            byte[] bArr2 = null;
                            while (byteBuffer2.position() < capacity - 8) {
                                long j19 = byteBuffer2.getLong();
                                if (j19 < 4 || j19 > TTL.MAX_VALUE || j19 > capacity - byteBuffer2.position()) {
                                    break;
                                }
                                int i16 = (int) j19;
                                int position = byteBuffer2.position() + i16;
                                int i17 = byteBuffer2.getInt();
                                if (i17 == 1896449818) {
                                    z16 = true;
                                } else if (i17 == -262969152) {
                                    z17 = true;
                                } else if (i17 == 1903261812) {
                                    int i18 = i16 - 4;
                                    bArr2 = new byte[i18];
                                    byteBuffer2.get(bArr2, 0, i18);
                                }
                                if ((z16 || z17) && bArr2 != null) {
                                    break;
                                }
                                byteBuffer2.position(position);
                            }
                            bArr = bArr2;
                            if (bArr == null && (i3 = byteBuffer.getShort(byteBuffer.position() + 20) & 65535) > 0 && i3 < byteBuffer.position() + byteBuffer.remaining()) {
                                bArr = new byte[i3];
                                byteBuffer.position(byteBuffer.position() + 22);
                                byteBuffer.get(bArr, 0, i3);
                            }
                            com.tencent.qimei.ab.a.a(randomAccessFile);
                            if (bArr != null && bArr.length > 4) {
                                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                                wrap.order(ByteOrder.LITTLE_ENDIAN);
                                if (wrap.getShort() != -26886 || (s16 = wrap.getShort()) < 0 || s16 > wrap.remaining()) {
                                    return "";
                                }
                                Properties properties = new Properties();
                                properties.load(new InputStreamReader(new ByteArrayInputStream(bArr, 4, s16), "UTF-8"));
                                return properties.getProperty("channelId");
                            }
                        }
                        bArr = null;
                        if (bArr == null) {
                            bArr = new byte[i3];
                            byteBuffer.position(byteBuffer.position() + 22);
                            byteBuffer.get(bArr, 0, i3);
                        }
                        com.tencent.qimei.ab.a.a(randomAccessFile);
                        return bArr != null ? "" : "";
                    }
                }
            }
        }
        pair = null;
        if (pair != null) {
        }
        bArr = null;
        if (bArr == null) {
        }
        com.tencent.qimei.ab.a.a(randomAccessFile);
        if (bArr != null) {
        }
    }

    public static Object[] c() {
        com.tencent.qimei.p.a aVar = new com.tencent.qimei.p.a();
        aVar.a("k1", com.tencent.qimei.q.c.class);
        aVar.a("k2", com.tencent.qimei.q.b.class);
        aVar.a("k3", com.tencent.qimei.o.a.class);
        aVar.a("k4", com.tencent.qimei.x.d.class);
        aVar.a("k5", com.tencent.qimei.x.b.class);
        aVar.a("k6", com.tencent.qimei.x.a.class);
        aVar.a("k7", com.tencent.qimei.t.e.class);
        return aVar.f343356a.toArray();
    }

    public static boolean a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        int i3 = Build.VERSION.SDK_INT;
        boolean z16 = NetworkMonitor.hasTransport(networkCapabilities, 0) || NetworkMonitor.hasTransport(networkCapabilities, 1) || NetworkMonitor.hasTransport(networkCapabilities, 2) || NetworkMonitor.hasTransport(networkCapabilities, 3) || NetworkMonitor.hasTransport(networkCapabilities, 4);
        if (i3 >= 26) {
            z16 = z16 || NetworkMonitor.hasTransport(networkCapabilities, 5);
        }
        return i3 >= 27 ? z16 || NetworkMonitor.hasTransport(networkCapabilities, 6) : z16;
    }

    public static boolean a(HttpURLConnection httpURLConnection, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[1024];
            InputStream inputStream = httpURLConnection.getInputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    com.tencent.qimei.ab.a.a(fileOutputStream);
                    com.tencent.qimei.ab.a.a(inputStream);
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public static String a(String str, String str2) throws Exception {
        return new String(a(Base64.decode(str, 2), str2.getBytes("UTF-8"), 2), "UTF-8").trim();
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, int i3) throws Exception {
        byte[] b16 = U.b(i3, bArr2, bArr2, bArr);
        if (b16 != null) {
            return b16;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, KeyPropertiesCompact.KEY_ALGORITHM_AES);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(i3, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C9318a a(Context context) {
        String str;
        d c9319a;
        String str2 = "com.huawei.hwid.tv";
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.tencent.qimei.ad.b.a("Cannot be called from the main thread");
            return null;
        }
        try {
            if (!a(context, "com.huawei.hwid")) {
                if (a(context, PackageConstants.SERVICES_PACKAGE_ALL_SCENE)) {
                    str2 = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
                } else if (a(context, "com.huawei.hwid.tv")) {
                }
                if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str2, 128) != null) {
                    return null;
                }
                b bVar = new b();
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage(str2);
                if (!context.bindService(intent, bVar, 1)) {
                    com.tencent.qimei.ad.b.a("bind failed");
                    return null;
                }
                com.tencent.qimei.ad.b.b("bind ok");
                try {
                    if (bVar.f343262a) {
                        try {
                            context.unbindService(bVar);
                        } catch (Throwable unused) {
                        }
                        return null;
                    }
                    bVar.f343262a = true;
                    IBinder take = bVar.f343263b.take();
                    int i3 = d.a.f343272a;
                    if (take == null) {
                        c9319a = null;
                    } else {
                        IInterface queryLocalInterface = take.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                        c9319a = (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new d.a.C9319a(take) : (d) queryLocalInterface;
                    }
                    C9318a c9318a = new C9318a(c9319a.m(), c9319a.j());
                    try {
                        context.unbindService(bVar);
                    } catch (Throwable unused2) {
                    }
                    return c9318a;
                } catch (RemoteException unused3) {
                    str = "bind hms service RemoteException";
                    try {
                        com.tencent.qimei.ad.b.a(str);
                        try {
                            return null;
                        } catch (Throwable unused4) {
                            return null;
                        }
                    } finally {
                        try {
                            context.unbindService(bVar);
                        } catch (Throwable unused5) {
                        }
                    }
                } catch (Throwable unused6) {
                    str = "bind hms service InterruptedException";
                    com.tencent.qimei.ad.b.a(str);
                    return null;
                }
            }
            str2 = "com.huawei.hwid";
            if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str2, 128) != null) {
            }
        } catch (Throwable unused7) {
            com.tencent.qimei.ad.b.a("pkg not found");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        if (com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.getType(r2) == 7) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a() {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        String str;
        Network activeNetwork;
        Context e16 = com.tencent.qimei.ap.d.c().e();
        if (e16 == null || (connectivityManager = (ConnectivityManager) e16.getSystemService("connectivity")) == null) {
            return "unknown";
        }
        int i3 = 0;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                activeNetwork = connectivityManager.getActiveNetwork();
            } catch (Exception e17) {
                com.tencent.qimei.ad.c.a(e17);
                networkCapabilities = null;
            }
            if (activeNetwork == null) {
                str = "unknown";
            } else {
                networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    if (!NetworkMonitor.hasTransport(networkCapabilities, 1)) {
                        if (!NetworkMonitor.hasTransport(networkCapabilities, 0)) {
                            if (!NetworkMonitor.hasTransport(networkCapabilities, 4)) {
                                if (!NetworkMonitor.hasTransport(networkCapabilities, 2)) {
                                    if (NetworkMonitor.hasTransport(networkCapabilities, 6)) {
                                        str = "lowpan";
                                    } else if (NetworkMonitor.hasTransport(networkCapabilities, 5)) {
                                        str = "wifi_aware";
                                    }
                                }
                                str = QQPermissionConstants.Permission.BLUE_TOOTH_GROUP;
                            }
                            str = "vpn";
                        }
                        str = DeviceType.DeviceCategory.MOBILE;
                    }
                    str = "wifi";
                }
                str = "unknown";
            }
        } else {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (NetworkMonitor.getType(activeNetworkInfo) != 1) {
                        if (NetworkMonitor.getType(activeNetworkInfo) != 0) {
                            if (NetworkMonitor.getType(activeNetworkInfo) != 17) {
                                if (NetworkMonitor.getType(activeNetworkInfo) == 9) {
                                    str = "ethernet";
                                } else if (NetworkMonitor.getType(activeNetworkInfo) == 6) {
                                    str = "wimax";
                                }
                            }
                            str = "vpn";
                        }
                        str = DeviceType.DeviceCategory.MOBILE;
                    }
                    str = "wifi";
                }
            } catch (Exception e18) {
                com.tencent.qimei.ad.c.a(e18);
            }
            str = "unknown";
        }
        if (!str.equals(DeviceType.DeviceCategory.MOBILE)) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) e16.getSystemService("phone");
        if (telephonyManager == null) {
            return "unknown";
        }
        try {
            i3 = Build.VERSION.SDK_INT < 30 ? NetworkMonitor.getNetworkType(telephonyManager) : NetworkMonitor.getDataNetworkType(telephonyManager);
        } catch (Exception e19) {
            com.tencent.qimei.ad.c.a(e19);
        }
        switch (i3) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "unknown_" + i3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 128);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                str2 = "getPackageInfo NameNotFoundException";
                com.tencent.qimei.ad.b.a(str2);
                if (packageInfo != null) {
                }
            } catch (Throwable unused2) {
                str2 = "getPackageInfo Exception";
                com.tencent.qimei.ad.b.a(str2);
                if (packageInfo != null) {
                }
            }
        }
        return packageInfo != null;
    }

    public static Object a(ClassLoader classLoader, String str, String str2, Class[] clsArr, Object[] objArr) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (Exception unused) {
            cls = null;
        }
        try {
            return cls.getMethod(str2, clsArr).invoke(null, objArr);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static void a(String str, byte b16) {
        h a16 = h.a();
        a16.getClass();
        e eVar = new e();
        eVar.f342975a.put("6", String.valueOf((int) b16));
        a16.a(eVar, "v6", str);
    }

    public static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i3, int i16) {
        Pair pair;
        int i17;
        if (i16 >= 0 && i16 <= 65535) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate(Math.min(i16, i3 - 22) + 22);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                long capacity = i3 - allocate.capacity();
                randomAccessFile.seek(capacity);
                randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                int capacity2 = allocate.capacity() - 22;
                int min = Math.min(capacity2, 65535);
                int i18 = 0;
                while (true) {
                    if (i18 >= min) {
                        pair = null;
                        break;
                    }
                    int i19 = capacity2 - i18;
                    if (allocate.getInt(i19) == 101010256 && (i17 = allocate.getShort(i19 + 20) & 65535) == i18) {
                        pair = Pair.create(Integer.valueOf(i19), Integer.valueOf(i17 + 22));
                        break;
                    }
                    i18++;
                }
                if (pair == null) {
                    return null;
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(((Integer) pair.second).intValue());
                allocate2.order(ByteOrder.LITTLE_ENDIAN);
                allocate.position(((Integer) pair.first).intValue());
                allocate.get(allocate2.array(), allocate2.position(), allocate2.capacity());
                return Pair.create(allocate2, Long.valueOf(capacity + ((Integer) pair.first).intValue()));
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
