package com.tencent.hlyyb.common.a;

import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f114336a;

    /* renamed from: b, reason: collision with root package name */
    public String f114337b;

    public e(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            return;
        }
        this.f114337b = "";
        this.f114336a = i3;
        this.f114337b = TextUtils.isEmpty(str) ? "" : str;
    }

    public static int a(String str, int i3, boolean z16) {
        int i16 = ("HLConnEvent".equals(str) || "HLSecurityEvent".equals(str) || "HLDisconnEvent".equals(str) || "HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str) || "HLHttpDirect".equals(str) || "HLPushEvent".equals(str) || "B_DLSDK_Result".equals(str) || "HLDownTiny".equals(str)) ? 0 : -1;
        if (i16 == 0) {
            return 100;
        }
        return i16;
    }

    public static long b() {
        try {
            String absolutePath = com.tencent.hlyyb.common.a.a().getFilesDir().getAbsolutePath();
            new StatFs(absolutePath).restat(absolutePath);
            return r1.getAvailableBlocks() * r1.getBlockSize();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -1L;
        }
    }

    public static String c(String str, String str2) {
        String str3;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf > 0 && str.length() > lastIndexOf + 1) {
            String substring = str.substring(0, lastIndexOf);
            str3 = str.substring(lastIndexOf);
            str = substring;
        } else {
            str3 = "";
        }
        return str + str2 + str3;
    }

    public static long a() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            return statFs.getBlockSize() * statFs.getAvailableBlocks();
        } catch (Throwable th5) {
            th5.printStackTrace();
            return -1L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000f, B:8:0x0014, B:10:0x001d, B:12:0x0027, B:13:0x002d, B:15:0x0033), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, String str2) {
        String str3;
        int lastIndexOf;
        try {
            String decode = Uri.decode(str);
            if (decode != null) {
                int indexOf = decode.indexOf(63);
                if (indexOf > 0) {
                    decode = decode.substring(0, indexOf);
                }
                if (!decode.endsWith("/") && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
                    str3 = decode.substring(lastIndexOf);
                    if (TextUtils.isEmpty(str3)) {
                        return c(str3, str2);
                    }
                    return null;
                }
            }
            str3 = null;
            if (TextUtils.isEmpty(str3)) {
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) {
        int indexOf;
        try {
            if (TextUtils.isEmpty(str) || -1 == (indexOf = str.indexOf("filename="))) {
                return null;
            }
            int i3 = indexOf + 9;
            int indexOf2 = str.indexOf(";", i3);
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            String substring = str.substring(i3, indexOf2);
            try {
                try {
                    substring = URLDecoder.decode(substring, "utf-8");
                } catch (UnsupportedEncodingException unused) {
                    substring = URLDecoder.decode(substring, "gbk");
                }
            } catch (UnsupportedEncodingException unused2) {
            }
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            int lastIndexOf = substring.lastIndexOf("/") + 1;
            String substring2 = lastIndexOf > 0 ? substring.substring(lastIndexOf) : substring;
            return !TextUtils.isEmpty(substring2) ? c(substring, str2) : substring2;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static boolean b(String str, boolean z16, Map<String, String> map) {
        try {
            return UserAction.onUserAction(str, z16, 0L, 0L, map, true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(String str, String str2, String str3, String str4) {
        String str5;
        String a16 = a(str3, str4);
        if (a16 == null && (a16 = b(str, str4)) == null) {
            str5 = "downloadfile" + str4;
            if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase("application/vnd.android.package-archive")) {
                str5 = str5 + ".apk";
            }
        } else {
            str5 = a16;
        }
        return !TextUtils.isEmpty(str5) ? str5.replace(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, "").replace("*", "").replace(":", "").replace("\\", "").replace("/", "").replace("\"", "").replace("<", "").replace(">", "").replace("|", "") : str5;
    }

    public static boolean a(int i3) {
        if (i3 <= 0 || i3 >= 100) {
            if (i3 != -1 && i3 != 100) {
                return false;
            }
        } else if (new Random().nextInt(100) > i3) {
            return false;
        }
        return true;
    }

    public static boolean a(Exception exc) {
        String message;
        if (!(exc instanceof IOException) || (message = exc.getMessage()) == null) {
            return false;
        }
        return message.contains("ENOSPC") || message.contains("No space left on device");
    }

    public static boolean a(String str, int i3, int i16) {
        Socket socket;
        boolean z16;
        try {
            socket = new Socket();
        } catch (Throwable th5) {
            th = th5;
            socket = null;
        }
        try {
            socket.connect(new InetSocketAddress(str, 80), 5000);
            z16 = socket.isConnected();
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                z16 = false;
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
            }
        }
        return z16;
    }

    public static boolean a(String str, boolean z16, Map<String, String> map) {
        try {
            return b(str, z16, map);
        } catch (Throwable unused) {
            return false;
        }
    }
}
