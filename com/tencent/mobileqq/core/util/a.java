package com.tencent.mobileqq.core.util;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.emoticon.EmoticonReportUtil;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static boolean a(int i3, int i16) {
        if (i3 == 2 && (i16 & 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean b(EmoticonPackage emoticonPackage) {
        if (emoticonPackage != null && emoticonPackage.status == 2 && (emoticonPackage.updateFlag & 1) == 1) {
            return true;
        }
        return false;
    }

    public static String c(String str) {
        int m3 = m(str);
        if (m3 == -1) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("https://i.gtimg.cn/club/item/parcel/" + (m3 % 10) + "/" + str + "_android.json");
        return e.A("VIP_emosm", sb5.toString());
    }

    public static IEmoticonManagerService d() {
        try {
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (appInterface != null) {
                return (IEmoticonManagerService) appInterface.getRuntimeService(IEmoticonManagerService.class, "");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }

    public static String e(int i3) {
        if (i3 == 11000) {
            return "qzone";
        }
        int intValue = Integer.valueOf(EmoticonReportUtil.getAioMoreFlag(i3)).intValue();
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 3) {
                        return "other";
                    }
                    return VipFunCallConstants.KEY_GROUP;
                }
                return "discuss";
            }
            return FaceUtil.IMG_TEMP;
        }
        return "c2c";
    }

    public static boolean f(MessageRecord messageRecord) {
        PicMessageExtraData picMessageExtraData;
        if ((messageRecord instanceof MessageForPic) && (picMessageExtraData = ((MessageForPic) messageRecord).picExtraData) != null && picMessageExtraData.isCustomFace()) {
            return true;
        }
        return false;
    }

    public static boolean g(int i3) {
        if ((i3 & 2) == 2) {
            return true;
        }
        return false;
    }

    public static boolean h(int i3) {
        if ((i3 & 1) == 1) {
            return true;
        }
        return false;
    }

    public static boolean i(MessageRecord messageRecord) {
        PicMessageExtraData picMessageExtraData;
        if ((messageRecord instanceof MessageForPic) && (picMessageExtraData = ((MessageForPic) messageRecord).picExtraData) != null && picMessageExtraData.isSelfieFace()) {
            return true;
        }
        return false;
    }

    public static boolean j() {
        if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 1) {
            return true;
        }
        return false;
    }

    public static boolean k() {
        int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
        if (systemNetwork == 1 || systemNetwork == 3 || systemNetwork == 4) {
            return true;
        }
        return false;
    }

    public static boolean l() {
        BaseApplication context = BaseApplication.getContext();
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        boolean readValue = SettingCloneUtil.readValue((Context) context, (String) null, context.getString(R.string.f209315f3), AppConstants.QQSETTING_AUTO_RECEIVE_MAGIC_FACE_KEY, true);
        if ((systemNetwork == 3 || systemNetwork == 4) && !readValue) {
            return true;
        }
        return false;
    }

    public static int m(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static boolean n(int i3) {
        if (i3 == 0 || i3 == 1 || i3 == 3000 || i3 == 99999 || i3 == 10014) {
            return true;
        }
        return false;
    }

    public static boolean o(int i3, int i16) {
        if (i3 == 0 || i3 == 1 || i3 == 3000 || i3 == 1000 || i3 == 10014 || i3 == 10016 || i3 == 1046) {
            return true;
        }
        if (i3 == 10021 && i16 == 119) {
            return true;
        }
        return false;
    }

    public static byte[] p(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = i3 * 2;
            bArr[i3] = Integer.valueOf(str.substring(i16, i16 + 2), 16).byteValue();
        }
        return bArr;
    }
}
