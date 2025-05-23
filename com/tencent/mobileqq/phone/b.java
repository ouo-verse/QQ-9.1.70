package com.tencent.mobileqq.phone;

import android.text.TextUtils;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.luggage.wxa.gf.j0;
import com.tencent.luggage.wxa.rf.d;
import com.tencent.luggage.wxa.rf.f;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.luggage.wxa.rf.h;
import com.tencent.luggage.wxa.se.c;
import com.tencent.luggage.wxa.yf.x;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.reminder.util.QQConstants;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static List<Integer> f258340a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73528);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f258340a = new ArrayList(Arrays.asList(86, 852, 1, 7, 20, 27, 30, 32, 33, 34, 36, 39, 40, 41, 43, 44, 45, 46, 47, 48, 49, 51, 52, 53, 54, 55, 56, 57, 58, 60, 61, 62, 63, 65, 66, 81, 82, 84, 90, 91, 92, 93, 94, 95, 98, 213, 216, 218, 220, 221, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 239, 241, 242, 243, 244, 247, 248, 249, 251, 252, 253, 254, 255, 256, 257, 258, 260, 261, 262, 263, 264, 265, 266, 267, 268, 297, Integer.valueOf(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID), 351, Integer.valueOf(g.CTRL_INDEX), Integer.valueOf(h.CTRL_INDEX), Integer.valueOf(f.CTRL_INDEX), 356, 357, Integer.valueOf(d.CTRL_INDEX), 359, 370, 371, Integer.valueOf(com.tencent.luggage.wxa.se.b.CTRL_INDEX), Integer.valueOf(c.CTRL_INDEX), 374, Integer.valueOf(QidPagView.DESIGN_PAG_WIDTH), 376, Integer.valueOf(NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END), Integer.valueOf(NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN), Integer.valueOf(LpReportInfoConfig.ACTION_HOMEPAGE_NOT_RIGHT), 386, 420, 421, 423, 501, 502, 503, 504, 506, 507, 509, 591, Integer.valueOf(com.tencent.luggage.wxa.v6.d.CTRL_INDEX), Integer.valueOf(LpReportInfoConfig.ACTION_TYPE_COMMON_SETTING), 594, 596, 597, 598, 673, 674, 675, 676, 677, 679, 682, 685, 689, 853, 855, 856, Integer.valueOf(x.CTRL_INDEX), Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_LEBA_NEARBY_TROOPS), 960, 961, 962, 963, 964, 965, 966, 967, 971, 972, 973, Integer.valueOf(QQConstants.REMINDER_POS_ID), 975, 992, Integer.valueOf(j0.CTRL_INDEX), 994, 995, 996, 998, Integer.valueOf(SubAccountBindActivity.ERROR_ACCOUNT_LOCK), 1246, Integer.valueOf(InitSkin.COLOR_COUNT), 1268, 1345, 1441, 1473, 1671, 1684, 1758, 1784, 1787, 1868, 1876, 1890));
        }
    }

    public static ArrayList<String> a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace(" ", "");
            if (replace.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                Iterator<Integer> it = f258340a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int intValue = it.next().intValue();
                    if (replace.startsWith(Marker.ANY_NON_NULL_MARKER + intValue)) {
                        arrayList.add(String.valueOf(intValue));
                        arrayList.add(replace.replace(Marker.ANY_NON_NULL_MARKER + intValue, ""));
                        break;
                    }
                }
            } else if (replace.startsWith("00")) {
                Iterator<Integer> it5 = f258340a.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    int intValue2 = it5.next().intValue();
                    if (replace.startsWith("00" + intValue2)) {
                        arrayList.add(String.valueOf(intValue2));
                        arrayList.add(replace.replace("00" + intValue2, ""));
                        break;
                    }
                }
            } else {
                int indexOf = replace.indexOf("-");
                if (indexOf > 0) {
                    arrayList.add(replace.substring(0, indexOf));
                    arrayList.add(replace.substring(indexOf + 1, replace.length()));
                } else {
                    arrayList.add("");
                    arrayList.add(replace);
                }
            }
            if (arrayList.size() < 2) {
                arrayList.add("");
                arrayList.add(replace);
            }
        } else {
            arrayList.add("");
            arrayList.add("");
        }
        return arrayList;
    }

    public static a b(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            str3 = str2;
        } else {
            ArrayList<String> a16 = a(str);
            str3 = a16.get(0);
            str2 = a16.get(1);
        }
        return new a(str3, "", str2);
    }
}
