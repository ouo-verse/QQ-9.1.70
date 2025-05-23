package com.tencent.mobileqq.troop.honor.util;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.troop.honor.troop_honor$GroupUserCardHonor;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static byte a(PBUInt32Field pBUInt32Field) {
        int i3;
        if (pBUInt32Field.has()) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = -96;
        }
        return (byte) i3;
    }

    public static String b(List<Integer> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb5.append(list.get(i3));
                if (i3 != list.size() - 1) {
                    sb5.append("|");
                }
            }
        }
        return sb5.toString();
    }

    public static String c(List<com.tencent.mobileqq.troop.honor.config.a> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb5.append(list.get(i3).f297511d);
                if (i3 != list.size() - 1) {
                    sb5.append("|");
                }
            }
            return sb5.toString();
        }
        return "";
    }

    public static List<Integer> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = str.split("\\|");
        if (split.length > 0) {
            for (String str2 : split) {
                try {
                    arrayList.add(Integer.valueOf(str2));
                } catch (NumberFormatException e16) {
                    QLog.d("TroopHonor.utils", 1, "convertStrToHonorList", e16);
                }
            }
        }
        return arrayList;
    }

    public static String e(List<com.tencent.mobileqq.troop.honor.config.a> list) {
        StringBuilder sb5 = new StringBuilder();
        if (list != null && list.size() > 0) {
            Iterator<com.tencent.mobileqq.troop.honor.config.a> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().f297512e);
            }
        }
        return sb5.toString();
    }

    public static boolean f(long j3, long j16) {
        if (j3 != 1) {
            return false;
        }
        if (j16 != Constant.FROM_ID_START_ACTIVITY && j16 != 1004 && j16 != Constant.FROM_ID_STOP_SERVICE && j16 != 1006 && j16 != 1021) {
            return false;
        }
        return true;
    }

    public static String g(int i3, int i16) {
        return "https://static-res.qq.com/static-res/groupInteract/vas/a/" + i3 + "_" + i16 + ".png";
    }

    public static int h(int i3, byte b16) {
        int i16;
        if (b16 == 0) {
            return 0;
        }
        if (i3 != 1) {
            if (i3 != 2 && i3 != 3) {
                if (i3 != 4) {
                    return 0;
                }
                i16 = b16 >> 4;
            } else {
                i16 = b16 >> 2;
            }
        } else {
            i16 = b16 >> 0;
        }
        return i16 & 3;
    }

    public static String i(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            List<Integer> list = null;
            try {
                troop_honor$GroupUserCardHonor troop_honor_groupusercardhonor = new troop_honor$GroupUserCardHonor();
                troop_honor_groupusercardhonor.mergeFrom(bArr);
                if (troop_honor_groupusercardhonor.f436061id.has()) {
                    list = troop_honor_groupusercardhonor.f436061id.get();
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                QLog.d("TroopHonor.utils", 1, "parseRspToHonorList", e16);
            }
            return b(list);
        }
        return "";
    }
}
