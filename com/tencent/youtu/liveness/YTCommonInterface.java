package com.tencent.youtu.liveness;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.youtu.liveness.YTFetchLicenseHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YTCommonInterface {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f385186a;

    /* renamed from: b, reason: collision with root package name */
    public static int f385187b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ boolean f385188c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f385188c = true;
        f385186a = SoLoadConstants.SONAME_YTCOMMON;
        f385187b = 1;
    }

    public YTCommonInterface() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getDeviceInfo(Context context, YTDeviceInfo yTDeviceInfo) {
        return nativeGetDeviceInfo(yTDeviceInfo);
    }

    public static native long getEndTime();

    public static native int[] getSDKList();

    public static native String getSDKNameByID(int i3);

    public static native String getVersion();

    public static int initAuthByAssets(String str, String str2) {
        if (!f385188c && str == null) {
            throw new AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        return nativeInitAuthByAssets(str, str2);
    }

    public static int initAuthByFilePath(String str, String str2) {
        if (!f385188c && str == null) {
            throw new AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[2048];
                int read = fileInputStream.read(bArr);
                fileInputStream.close();
                if (read < 2048) {
                    return nativeInitAuthByString(Base64.encodeToString(bArr, 0, read, 2).toString(), str2);
                }
                if (f385187b != 0) {
                    Log.e(f385186a, "license length oversize.");
                    return -2;
                }
                return -2;
            } catch (FileNotFoundException e16) {
                if (f385187b != 0) {
                    Log.e(f385186a, "file not found: " + str);
                    e16.printStackTrace();
                    Log.e(SoLoadConstants.SONAME_YTCOMMON, "\u4f18\u56fe\u9274\u6743\uff1a\u8bfb\u53d6\u6587\u4ef6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5APP\u662f\u5426\u62e5\u6709READ_EXTERNAL_STORAGE\u6743\u9650\u3002");
                }
                return -10;
            } catch (IOException e17) {
                if (f385187b != 0) {
                    Log.e(f385186a, "io error: " + str);
                    e17.printStackTrace();
                    return -4;
                }
                return -4;
            }
        }
        if (f385187b != 0) {
            Log.e(f385186a, "file not exists: " + str);
        }
        return -10;
    }

    public static int initAuthByString(String str, String str2) {
        if (!f385188c && str == null) {
            throw new AssertionError();
        }
        if (str2 == null) {
            str2 = "";
        }
        return nativeInitAuthByString(str, str2);
    }

    public static int initAuthForQQ() {
        return nativeInitAuthForQQ();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int initAuthOnlineWithCache(Context context, String str, String str2, String str3, String str4, boolean z16) {
        int i3;
        boolean z17;
        YTDeviceInfo yTDeviceInfo;
        int i16;
        boolean z18;
        File file = new File(str2);
        if (file.exists()) {
            if (f385187b != 0) {
                Log.d(f385186a, "license cache found: " + str2);
            }
            i3 = initAuthByFilePath(str2, str4);
            if (i3 == 0) {
                long endTime = ((getEndTime() - (System.currentTimeMillis() / 1000)) / 24) / 3600;
                if (endTime >= 0 && endTime <= 7) {
                    if (f385187b != 0) {
                        Log.i(f385186a, "youtu auth will expire in " + endTime + " days");
                    }
                } else {
                    z17 = false;
                    if (z17) {
                        if (f385187b != 0) {
                            Log.i(f385186a, "youtu fetchLicenseOnline");
                        }
                        if (z16) {
                            yTDeviceInfo = new YTDeviceInfo();
                            int deviceInfo = getDeviceInfo(context, yTDeviceInfo);
                            if (deviceInfo != 0) {
                                if (f385187b != 0) {
                                    Log.e(f385186a, "getDeviceInfo failed: " + deviceInfo);
                                }
                                return deviceInfo;
                            }
                        } else {
                            yTDeviceInfo = null;
                        }
                        YTFetchLicenseHelper.FetchLicenseResult fetchLicenseOnline = new YTFetchLicenseHelper().fetchLicenseOnline(context, str, str3, str4, yTDeviceInfo);
                        if (fetchLicenseOnline.error_code == 0) {
                            i16 = initAuthByString(fetchLicenseOnline.license, str4);
                            if (fetchLicenseOnline.auth_type.equals("test") && fetchLicenseOnline.bind_type.equals(GrsBaseInfo.CountryCodeSource.APP)) {
                                if (f385187b != 0) {
                                    Log.i(f385186a, "youtu test license will not cache");
                                }
                            } else if (i16 == 0) {
                                i3 = i16;
                                z18 = true;
                                if (z18) {
                                    try {
                                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                                        fileOutputStream.write(Base64.decode(fetchLicenseOnline.license, 0));
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                        return 0;
                                    } catch (FileNotFoundException e16) {
                                        if (f385187b != 0) {
                                            Log.e(f385186a, "cache file not found: " + str2);
                                            e16.printStackTrace();
                                            Log.e(SoLoadConstants.SONAME_YTCOMMON, "\u4f18\u56fe\u9274\u6743\uff1a\u8bfb\u53d6\u6587\u4ef6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5APP\u662f\u5426\u62e5\u6709READ_EXTERNAL_STORAGE\u6743\u9650\u3002");
                                            return -10;
                                        }
                                        return -10;
                                    } catch (IOException e17) {
                                        if (f385187b != 0) {
                                            Log.e(f385186a, "io error: " + str2);
                                            e17.printStackTrace();
                                            return -4;
                                        }
                                        return -4;
                                    }
                                }
                            }
                        } else {
                            if (f385187b != 0) {
                                Log.e(f385186a, "fetch license failed: http_status: " + fetchLicenseOnline.http_status + " error_code: " + fetchLicenseOnline.error_code + " error_msg: " + fetchLicenseOnline.error_msg);
                            }
                            i16 = fetchLicenseOnline.error_code;
                            if (f385187b != 0) {
                                nativePrintAuthResult(i16);
                            }
                        }
                        i3 = i16;
                        z18 = false;
                        if (z18) {
                        }
                    }
                    return i3;
                }
            }
        } else {
            i3 = 1002;
        }
        z17 = true;
        if (z17) {
        }
        return i3;
    }

    private static native int nativeGetDeviceInfo(YTDeviceInfo yTDeviceInfo);

    private static native int nativeInitAuthByAssets(String str, String str2);

    private static native int nativeInitAuthByString(String str, String str2);

    private static native int nativeInitAuthForQQ();

    private static native void nativePrintAuthResult(int i3);

    private static native void nativeSetEnableLog(int i3);

    public static void setEnableLog(int i3) {
        nativeSetEnableLog(i3);
        f385187b = i3;
    }
}
