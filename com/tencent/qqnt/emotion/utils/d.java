package com.tencent.qqnt.emotion.utils;

import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;

/* compiled from: P */
/* loaded from: classes24.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static boolean a(EmoticonPackage emoticonPackage) {
        if (emoticonPackage != null && emoticonPackage.status == 2 && (emoticonPackage.updateFlag & 1) == 1) {
            return true;
        }
        return false;
    }

    public static String b(String str) {
        int e16 = e(str);
        if (e16 == -1) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("https://i.gtimg.cn/club/item/parcel/" + (e16 % 10) + "/" + str + "_android.json");
        return com.tencent.qqnt.emotion.emosm.b.p("VIP_emosm", sb5.toString());
    }

    public static int c(int i3) {
        if (i3 == -1) {
            return 4;
        }
        int parseInt = Integer.parseInt(e.b(i3));
        if (parseInt != 0) {
            if (parseInt == 2) {
                return 3;
            }
            if (parseInt != 3) {
                return 4;
            }
            return 2;
        }
        return 1;
    }

    public static String d(int i3) {
        if (i3 == 11000) {
            return "qzone";
        }
        int parseInt = Integer.parseInt(e.b(i3));
        if (parseInt != 0) {
            if (parseInt != 1) {
                if (parseInt != 2) {
                    if (parseInt != 3) {
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

    public static int e(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -1;
        }
    }
}
