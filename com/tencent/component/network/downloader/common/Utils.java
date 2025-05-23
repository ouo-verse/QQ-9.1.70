package com.tencent.component.network.downloader.common;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.Base64;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes5.dex */
public class Utils {
    public static boolean checkUrl(String str) {
        if (!TextUtils.isEmpty(str) && NetworkUtils.isNetworkUrl(str)) {
            return true;
        }
        return false;
    }

    public static Object convertToObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ObjectInputStream(new ByteArrayInputStream(Base64.decode(str.getBytes(), 0))).readObject();
        } catch (StreamCorruptedException e16) {
            QDLog.e("Utils", "", e16);
            return null;
        } catch (IOException e17) {
            QDLog.e("Utils", "", e17);
            return null;
        } catch (ClassNotFoundException e18) {
            QDLog.e("Utils", "", e18);
            return null;
        }
    }

    public static String convertToString(Object obj) {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new String(Base64.encode(byteArrayOutputStream.toByteArray(), 0));
        } catch (IOException e16) {
            QDLog.e("Utils", "", e16);
            return null;
        }
    }

    public static int count(String str, char c16) {
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            if (c16 == str.charAt(i16)) {
                i3++;
            }
        }
        return i3;
    }

    public static String getCurrentProcessName(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return null;
        }
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getDomin(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String authority = new URL(str).getAuthority();
            if (!TextUtils.isEmpty(authority) && (indexOf = authority.indexOf(":")) >= 0 && indexOf < authority.length()) {
                return authority.substring(0, indexOf);
            }
            return authority;
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static String getDominWithPort(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str).getAuthority();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static int getPort(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            String authority = new URL(str).getAuthority();
            if (TextUtils.isEmpty(authority) || (indexOf = authority.indexOf(":")) < 0) {
                return -1;
            }
            if (indexOf >= authority.length()) {
                return -1;
            }
            return Integer.valueOf(authority.substring(indexOf + 1)).intValue();
        } catch (MalformedURLException | Exception unused) {
            return -1;
        }
    }

    public static boolean isMainProcess(Context context) {
        String currentProcessName = getCurrentProcessName(context);
        if (currentProcessName == null || !currentProcessName.contains(":")) {
            return true;
        }
        return false;
    }

    public static boolean isPortValid(int i3) {
        if (i3 > 0 && i3 <= 65535) {
            return true;
        }
        return false;
    }

    public static byte[] marshall(Parcelable parcelable) {
        byte[] bArr = null;
        if (parcelable == null) {
            return null;
        }
        try {
            Parcel obtain = Parcel.obtain();
            parcelable.writeToParcel(obtain, 0);
            bArr = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            return bArr;
        } catch (Exception unused) {
            return bArr;
        }
    }

    public static boolean match(Pattern pattern, String str) {
        if (pattern == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return pattern.matcher(str).matches();
        } catch (Exception e16) {
            QDLog.e("Utils", "", e16);
            return false;
        }
    }

    public static Parcel unmarshall(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        if (bArr == null) {
            return obtain;
        }
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
        } catch (Exception unused) {
        }
        return obtain;
    }
}
