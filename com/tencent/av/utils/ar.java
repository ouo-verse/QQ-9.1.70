package com.tencent.av.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x1172.cmd0x1172$Cmd0x1172Response;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ar {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f77023a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f77024b = "";

    public static void b(final AppInterface appInterface, final String str, final int i3, final String str2, final String str3, final Pair<Integer, Integer> pair, final int i16) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.av.utils.aq
            @Override // java.lang.Runnable
            public final void run() {
                ar.h(AppInterface.this, str, i3, str2, str3, pair, i16);
            }
        }, 16, null, false, 300L);
    }

    private static Pair<Integer, Integer> c(String str, String str2) {
        int indexOf = str.indexOf(str2);
        return new Pair<>(Integer.valueOf(indexOf), Integer.valueOf(str2.length() + indexOf));
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str) || str.split("\\?").length <= 1) {
            return "";
        }
        String[] split = str.split("\\?")[1].split("and");
        if (split.length < 3) {
            return "";
        }
        return split[1];
    }

    public static int e(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ScoreManager", 2, "getVideoType sessionType:" + i3);
        }
        int i16 = 1;
        if (i3 != 1) {
            i16 = 3;
            if (i3 != 2) {
                if (i3 == 3) {
                    return 2;
                }
                if (i3 == 4) {
                    return 4;
                }
                return 0;
            }
        }
        return i16;
    }

    public static boolean f(String str, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return z16;
        }
        return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(str, z16);
    }

    public static boolean g() {
        boolean f16 = f("qav_video_score_switch", false);
        QLog.i("ScoreManager", 2, "isUseNewStyle feature switch:" + f16);
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(AppInterface appInterface, String str, int i3, String str2, String str3, Pair pair, int i16) {
        long j3;
        String str4;
        LocalGrayTip m3;
        if ((appInterface instanceof QQAppInterface) && !TextUtils.isEmpty(str)) {
            int l3 = com.tencent.nt.adapter.session.c.l(i3);
            if (l3 == 1) {
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str2);
                ReportController.o(null, "dc00898", "", "", "0X800C2CE", "0X800C2CE", 1, 0, "", "", d(str3), "");
                j3 = 2021;
                str4 = uidFromUin;
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800C2CE", "0X800C2CE", 2, 0, "", "", d(str3), "");
                j3 = 2022;
                str4 = str2;
            }
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(str4, l3, j3, 1, true, true, null);
            if (((Integer) pair.first).intValue() != -1 && ((Integer) pair.second).intValue() != -1) {
                String substring = str.substring(0, ((Integer) pair.first).intValue());
                m3 = localGrayTipBuilder.g(substring, 1).h(str.substring(((Integer) pair.first).intValue(), ((Integer) pair.second).intValue()), new jv.a(i3, str2, str3, i16, NetConnInfoCenter.getServerTime()), 3).g(str.substring(((Integer) pair.second).intValue()), 1).m();
            } else {
                m3 = localGrayTipBuilder.g(str, 1).m();
            }
            ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(appInterface, m3, null);
            return;
        }
        QLog.i("ScoreManager", 1, "addTips error");
    }

    public static void i(AppInterface appInterface, cmd0x1172$Cmd0x1172Response cmd0x1172_cmd0x1172response, ToServiceMsg toServiceMsg) {
        boolean z16;
        String str;
        String str2;
        String str3;
        int i3;
        if (cmd0x1172_cmd0x1172response.should_issue.has()) {
            z16 = cmd0x1172_cmd0x1172response.should_issue.get();
        } else {
            z16 = false;
        }
        if (!cmd0x1172_cmd0x1172response.url.has()) {
            str = "";
        } else {
            str = cmd0x1172_cmd0x1172response.url.get();
        }
        if (!cmd0x1172_cmd0x1172response.brief.has()) {
            str2 = "";
        } else {
            str2 = cmd0x1172_cmd0x1172response.brief.get();
        }
        if (!cmd0x1172_cmd0x1172response.link_part.has()) {
            str3 = "";
        } else {
            str3 = cmd0x1172_cmd0x1172response.link_part.get();
        }
        if (cmd0x1172_cmd0x1172response.effect_time.has()) {
            i3 = cmd0x1172_cmd0x1172response.effect_time.get();
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ScoreManager", 2, "handleGetVideoCallQualityInfo, shouldIssue: " + z16 + ", url: " + str + ", brief = " + str2 + ", linkPart = " + str3 + ", effectTime = " + i3);
        }
        if (!z16) {
            return;
        }
        int i16 = toServiceMsg.extraData.getInt("uinType", 0);
        String string = toServiceMsg.extraData.getString("peerUin", "");
        Pair<Integer, Integer> c16 = c(str2, str3);
        if (QLog.isColorLevel()) {
            QLog.i("ScoreManager", 2, "handleGetVideoCallQualityInfo, linkPartPair.first: " + c16.first + " linkPartPair.second: " + c16.second);
        }
        if (j(appInterface.getCurrentAccountUin())) {
            b(appInterface, str2, i16, string, str, c16, i3);
        }
    }

    public static boolean j(String str) {
        if (f77023a == null || !f77024b.equals(str)) {
            f77023a = Boolean.valueOf(g());
            f77024b = str;
        }
        return f77023a.booleanValue();
    }
}
