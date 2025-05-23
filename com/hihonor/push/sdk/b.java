package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.ipc.HonorApiAvailability$PackageStates;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.Closeable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    public static String a(byte[] bArr) {
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                sb5.append('0');
            }
            sb5.append(hexString);
        }
        return sb5.toString();
    }

    public static int b(Context context) {
        HonorApiAvailability$PackageStates honorApiAvailability$PackageStates;
        if (context != null) {
            RemoteServiceBean a16 = a(context);
            String packageName = a16.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
            } else {
                try {
                    if (context.getPackageManager().getApplicationInfo(packageName, 0).enabled) {
                        honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.ENABLED;
                    } else {
                        honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.DISABLED;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    honorApiAvailability$PackageStates = HonorApiAvailability$PackageStates.NOT_INSTALLED;
                }
            }
            if (HonorApiAvailability$PackageStates.NOT_INSTALLED.equals(honorApiAvailability$PackageStates)) {
                Log.i("HonorApiAvailability", "push service is not installed");
                return 8002008;
            }
            if (HonorApiAvailability$PackageStates.DISABLED.equals(honorApiAvailability$PackageStates)) {
                Log.i("HonorApiAvailability", "push service is disabled");
                return 8002007;
            }
            if (TextUtils.equals(packageName, "android") && !TextUtils.isEmpty(a16.getPackageSignature())) {
                return HonorPushErrorEnum.SUCCESS.statusCode;
            }
            return 8002006;
        }
        throw new NullPointerException("context must not be null.");
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        int length = upperCase.length() / 2;
        byte[] bArr = new byte[length];
        try {
            byte[] bytes = upperCase.getBytes(StandardCharsets.UTF_8);
            for (int i3 = 0; i3 < length; i3++) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(RelationNTPushServiceImpl.PRE_HEX_STRING);
                int i16 = i3 * 2;
                sb5.append(new String(new byte[]{bytes[i16]}, StandardCharsets.UTF_8));
                bArr[i3] = (byte) (((byte) (Byte.decode(sb5.toString()).byteValue() << 4)) ^ Byte.decode(RelationNTPushServiceImpl.PRE_HEX_STRING + new String(new byte[]{bytes[i16 + 1]}, StandardCharsets.UTF_8)).byteValue());
            }
        } catch (NumberFormatException e16) {
            e16.getMessage();
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, int i3) {
        if (bArr == null) {
            return bArr;
        }
        for (int i16 = 0; i16 < bArr.length; i16++) {
            if (i3 < 0) {
                bArr[i16] = (byte) (bArr[i16] << (-i3));
            } else {
                bArr[i16] = (byte) (bArr[i16] >> i3);
            }
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        if (bArr != null) {
            int length = bArr.length;
            if (bArr2.length != length) {
                return null;
            }
            bArr3 = new byte[length];
            for (int i3 = 0; i3 < length; i3++) {
                bArr3[i3] = (byte) (bArr[i3] ^ bArr2[i3]);
            }
        }
        return bArr3;
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e16) {
            c.a("DeflateUtil", "close", e16);
        }
    }

    public static <TResult> a1<TResult> a(Callable<TResult> callable) {
        ExecutorService executorService = o0.f36415c.f36417b;
        n0 n0Var = new n0();
        try {
            executorService.execute(new z0(n0Var, callable));
        } catch (Exception e16) {
            n0Var.a(e16);
        }
        return n0Var.f36413a;
    }

    public static void a(Handler handler) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException("Must be called on the handler thread");
        }
    }

    public static <TResult> TResult a(a1<TResult> a1Var) throws ExecutionException, InterruptedException {
        boolean z16;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            synchronized (a1Var.f36352a) {
                z16 = a1Var.f36353b;
            }
            if (!z16) {
                y0 y0Var = new y0();
                o0 o0Var = o0.f36415c;
                a1Var.a(new x0(o0Var.f36416a, y0Var)).a(new v0(o0Var.f36416a, y0Var)).a(new r0(o0Var.f36416a, y0Var));
                y0Var.f36459a.await();
            }
            if (a1Var.e()) {
                return a1Var.c();
            }
            throw new ExecutionException(a1Var.b());
        }
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    public static RequestHeader a() throws ApiException {
        String string;
        Context a16 = l.f36402e.a();
        String str = null;
        try {
            Object obj = a16.getPackageManager().getApplicationInfo(a16.getPackageName(), 128).metaData.get("com.hihonor.push.app_id");
            if (obj != null) {
                str = String.valueOf(obj);
            }
        } catch (PackageManager.NameNotFoundException e16) {
            c.a("ConfigUtils", "getPushAppId", e16);
        }
        if (!TextUtils.isEmpty(str)) {
            String a17 = a(a16, a16.getPackageName());
            if (!TextUtils.isEmpty(a17)) {
                RequestHeader requestHeader = new RequestHeader();
                requestHeader.setPackageName(a16.getPackageName());
                requestHeader.setAppId(str);
                requestHeader.setCertificateFingerprint(a17);
                d dVar = d.f36363b;
                requestHeader.setPushToken(dVar.b(a16));
                synchronized (dVar) {
                    dVar.a(a16);
                    SharedPreferences sharedPreferences = d.f36362a.f36393a;
                    string = sharedPreferences != null ? sharedPreferences.getString("key_aaid", "") : "";
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString().replace("-", "");
                        d.f36362a.a("key_aaid", string);
                    }
                }
                requestHeader.setAAID(string);
                requestHeader.setSdkVersion(70061302);
                return requestHeader;
            }
            c.a("checkPushConfig Parameter is missing.");
            throw HonorPushErrorEnum.ERROR_CERT_FINGERPRINT_EMPTY.toApiException();
        }
        c.a("checkPushConfig Parameter is missing");
        throw HonorPushErrorEnum.ERROR_NO_APPID.toApiException();
    }

    public static ApiException a(Exception exc) {
        if (exc.getCause() instanceof ApiException) {
            return (ApiException) exc.getCause();
        }
        if (exc instanceof ApiException) {
            return (ApiException) exc;
        }
        return new ApiException(-1, exc.getMessage());
    }

    public static RemoteServiceBean a(Context context) {
        RemoteServiceBean remoteServiceBean = new RemoteServiceBean();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("android", "com.hihonor.android.pushagentproxy.HiPushService"));
        List<ResolveInfo> queryIntentServices = InstalledAppListMonitor.queryIntentServices(context.getPackageManager(), intent, 128);
        if (queryIntentServices.size() > 0) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                String str = next.serviceInfo.applicationInfo.packageName;
                String a16 = a(context, str);
                remoteServiceBean.setPackageName(str);
                remoteServiceBean.setPackageServiceName(next.serviceInfo.name);
                remoteServiceBean.setPackageSignature(a16);
            }
        }
        return remoteServiceBean;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        r11 = r11.signingInfo;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0039 -> B:12:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, String str) {
        Signature[] signatureArr;
        String str2;
        SigningInfo signingInfo;
        boolean hasMultipleSigners;
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 30) {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 134217728);
            if (packageInfo != null && signingInfo != null) {
                hasMultipleSigners = signingInfo.hasMultipleSigners();
                signatureArr = hasMultipleSigners ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            }
            signatureArr = null;
        } else {
            PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, str, 64);
            if (packageInfo2 != null) {
                signatureArr = packageInfo2.signatures;
            }
            signatureArr = null;
        }
        if (signatureArr != null && signatureArr.length > 0) {
            int length = signatureArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                try {
                    byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[i3].toByteArray());
                    StringBuilder sb5 = new StringBuilder();
                    for (byte b16 : digest) {
                        String upperCase = Integer.toHexString(b16 & 255).toUpperCase(Locale.ENGLISH);
                        if (upperCase.length() == 1) {
                            sb5.append("0");
                        }
                        sb5.append(upperCase);
                    }
                    str2 = sb5.toString();
                } catch (NoSuchAlgorithmException unused) {
                    str2 = null;
                }
                if (str2 != null) {
                    arrayList.add(str2);
                    break;
                }
                i3++;
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (String) arrayList.get(0);
    }
}
