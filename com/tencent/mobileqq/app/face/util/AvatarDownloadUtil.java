package com.tencent.mobileqq.app.face.util;

import AvatarInfo.QQHeadInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.avatar.utils.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class AvatarDownloadUtil {
    static IPatchRedirector $redirector_;

    public AvatarDownloadUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String get1080QQHeadDownLoadUrl(String str, byte b16) {
        return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).get1080QQHeadDownLoadUrl(str, b16);
    }

    public static int getFaceImageSize() {
        BaseApplication context = BaseApplication.getContext();
        int min = Math.min(context.getResources().getDisplayMetrics().widthPixels, context.getResources().getDisplayMetrics().heightPixels);
        return (min <= 720 && min < 640) ? 40 : 140;
    }

    private static byte getImageIndex(int i3) {
        if (i3 != 40) {
            if (i3 != 100) {
                if (i3 == 140 || i3 != 640) {
                    return (byte) 3;
                }
                return (byte) 4;
            }
            return (byte) 2;
        }
        return (byte) 0;
    }

    public static String getIp(String str, boolean z16) {
        return ((IQQAvatarUtilApi) QRoute.api(IQQAvatarUtilApi.class)).getIp(str, z16);
    }

    public static String getQQAvatarDownLoadUrl(String str, byte b16, byte b17, int i3) {
        return getQQAvatarDownLoadUrl(str, b16, b17, i3, false, (byte) 0);
    }

    public static int getQQHeadImageSize(byte b16) {
        return getQQHeadImageSize(b16, 0);
    }

    public static int getZplanAvatarUrlSize(int i3, byte b16) {
        if (b16 <= 0) {
            return 140;
        }
        ArrayList<Integer> arrayList = new ArrayList(4);
        if ((b16 & 1) > 0) {
            arrayList.add(100);
        }
        if ((b16 & 2) > 0) {
            arrayList.add(140);
        }
        if ((b16 & 4) > 0) {
            arrayList.add(640);
        }
        if ((b16 & 8) > 0) {
            arrayList.add(0);
        }
        for (Integer num : arrayList) {
            if (i3 <= num.intValue()) {
                return num.intValue();
            }
            if (num.intValue() == 0) {
                return 0;
            }
        }
        return 140;
    }

    public static String getQQAvatarDownLoadUrl(String str, byte b16, byte b17, int i3, boolean z16, byte b18) {
        int qQHeadImageSize;
        String str2;
        String str3 = "p.qlogo.cn";
        if (b17 != 32 ? b17 != 16 && b17 != 4 && b17 != 8 : i3 == 1 || i3 != 32) {
            str3 = "q.qlogo.cn";
        }
        String ip5 = getIp(str3, z16);
        StringBuilder sb5 = new StringBuilder("https://");
        if (!TextUtils.isEmpty(ip5)) {
            sb5.append(ip5);
        } else {
            sb5.append(str3);
        }
        int indexOf = str.indexOf("/", 8);
        if (indexOf > 8) {
            sb5.append(str.substring(indexOf));
            str = sb5.toString();
        }
        int i16 = 140;
        if (b17 == 32) {
            qQHeadImageSize = i3 == 1 ? getQQHeadImageSize(b16) : 140;
        } else {
            qQHeadImageSize = b17 == 16 ? 224 : getQQHeadImageSize(b16);
        }
        if (b17 != 1 || b18 <= 0) {
            i16 = qQHeadImageSize;
            str2 = "";
        } else {
            str2 = "a";
        }
        return str + i16 + str2;
    }

    public static int getQQHeadImageSize(byte b16, int i3) {
        boolean z16;
        int faceImageSize = getFaceImageSize(i3);
        byte imageIndex = getImageIndex(faceImageSize);
        boolean z17 = true;
        if (b16 == 0) {
            b16 = 1;
        }
        int i16 = 1 << imageIndex;
        if ((i16 & b16) == i16) {
            return faceImageSize;
        }
        int i17 = imageIndex - 1;
        while (true) {
            if (i17 < 0) {
                z16 = false;
                break;
            }
            byte b17 = (byte) (1 << i17);
            if ((b17 & b16) == b17) {
                z16 = true;
                break;
            }
            i17--;
        }
        if (!z16) {
            i17 = imageIndex + 1;
            while (i17 < 8) {
                byte b18 = (byte) (1 << i17);
                if ((b18 & b16) == b18) {
                    break;
                }
                i17++;
            }
        }
        z17 = z16;
        if (!z17) {
            return 140;
        }
        if (i17 == 0) {
            return 40;
        }
        if (i17 != 2) {
            return i17 != 4 ? 140 : 640;
        }
        return 100;
    }

    public static int getFaceImageSize(int i3) {
        if (i3 != 100 && i3 != 140) {
            if (i3 == 200) {
                return 640;
            }
            if (i3 != 640) {
                return getFaceImageSize();
            }
        }
        return i3;
    }

    public static String getQQAvatarDownLoadUrl(QQHeadInfo qQHeadInfo, boolean z16) {
        int qQHeadImageSize;
        int qQHeadImageSize2;
        byte b16;
        byte b17;
        String str = qQHeadInfo.downLoadUrl;
        byte b18 = qQHeadInfo.dwFaceFlgas;
        byte b19 = qQHeadInfo.dstUsrType;
        int i3 = qQHeadInfo.originUsrType;
        String str2 = "p.qlogo.cn";
        if (b19 != 32 ? b19 != 16 && b19 != 4 && b19 != 8 : i3 == 1 || i3 != 32) {
            str2 = "q.qlogo.cn";
        }
        String ip5 = getIp(str2, z16);
        StringBuilder sb5 = new StringBuilder("https://");
        if (!TextUtils.isEmpty(ip5)) {
            sb5.append(ip5);
        } else {
            sb5.append(str2);
        }
        int indexOf = str.indexOf("/", 8);
        if (indexOf > 8) {
            sb5.append(str.substring(indexOf));
            str = sb5.toString();
        }
        String str3 = "";
        if (b19 == 32) {
            qQHeadImageSize = i3 == 1 ? getQQHeadImageSize(b18) : 140;
        } else if (b19 == 16) {
            qQHeadImageSize = 224;
        } else if (b19 == 1) {
            if (qQHeadInfo.enableZplanOutbound && (b17 = qQHeadInfo.staticZplanFaceFlag) > 0) {
                qQHeadImageSize2 = getZplanAvatarUrlSize(qQHeadInfo.sizeType, b17);
                str3 = "sz";
            } else if (c.q()) {
                qQHeadImageSize2 = getQQHeadImageSize(b18, qQHeadInfo.sizeType);
            } else {
                qQHeadImageSize2 = getQQHeadImageSize(b18, 0);
            }
            if (!TextUtils.isEmpty(str3) || (b16 = qQHeadInfo.apngFaceFlag) <= 0) {
                qQHeadImageSize = qQHeadImageSize2;
            } else {
                qQHeadImageSize = getQQHeadImageSize(b16);
                str3 = "a";
            }
        } else {
            qQHeadImageSize = getQQHeadImageSize(b18);
        }
        return str + qQHeadImageSize + str3;
    }
}
