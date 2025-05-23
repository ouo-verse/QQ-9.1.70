package com.tencent.mobileqq.service.qzone;

import NS_UNDEAL_COUNT.stMomentInfo;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZonePadApi;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import uq3.k;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    private static boolean a(HashMap<Integer, QZoneCountInfo> hashMap) {
        if (hashMap == null || !hashMap.containsKey(67) || !r(hashMap.get(67))) {
            return false;
        }
        QLog.d("QZoneMomentInfoManager", 1, "delete old moment active red count id is 67");
        hashMap.remove(67);
        return true;
    }

    private static boolean b(HashMap<Integer, QZoneCountInfo> hashMap) {
        if (hashMap == null || !hashMap.containsKey(66) || !q(hashMap.get(66), 66)) {
            return false;
        }
        QLog.d("QZoneMomentInfoManager", 1, "delete old moment passive red count id is 66");
        hashMap.remove(66);
        return true;
    }

    public static long c() {
        return k.a().f("moment_red_count_67_timestamp", 0L);
    }

    public static long d() {
        return k.a().f("moment_red_count_67_uin", 0L);
    }

    public static int e() {
        int e16 = k.a().e("moment_tian_shu_ad_id", 0);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneMomentInfoManager", 2, "entrance adId is :" + e16);
        }
        return e16;
    }

    public static String f() {
        String h16 = k.a().h("moment_tian_shu_TRACE_INFO", "");
        if (QLog.isColorLevel()) {
            QLog.i("QZoneMomentInfoManager", 2, "entrance ad trace info is :" + h16);
        }
        return h16;
    }

    public static String g() {
        return k.a().h("moment_entrance_root_is_show", "");
    }

    public static String h() {
        String h16 = k.a().h("moment_entrance_text", "\u6b64\u523b\u4f60\u5728\u505a\u4ec0\u4e48?");
        if (QLog.isColorLevel()) {
            QLog.i("QZoneMomentInfoManager", 2, "entrance text is :" + h16);
        }
        return h16;
    }

    public static int i() {
        int e16 = k.a().e("moment_is_showed_tian_shu_ad_id", 0);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneMomentInfoManager", 2, "entrance is showed adId is :" + e16);
        }
        return e16;
    }

    public static long j(int i3) {
        if (i3 != 66) {
            return 0L;
        }
        return k.a().f("moment_red_count_66_timestamp", 0L);
    }

    public static long k(int i3) {
        if (i3 != 66) {
            return 0L;
        }
        return k.a().f("moment_red_count_66_ucount", 0L);
    }

    public static String l() {
        String h16 = k.a().h("not_allow_send_moment_tips", "\u4f11\u606f\u4e00\u4e0b\uff0c1\u5c0f\u65f6\u5185\u53ea\u80fd\u53d11\u6761");
        if (QLog.isColorLevel()) {
            QLog.i("QZoneMomentInfoManager", 2, "not allow send moment tips is :" + h16);
        }
        if (TextUtils.isEmpty(h16)) {
            return "\u4f11\u606f\u4e00\u4e0b\uff0c1\u5c0f\u65f6\u5185\u53ea\u80fd\u53d11\u6761";
        }
        return h16;
    }

    public static void m(stMomentInfo stmomentinfo, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QZoneMomentInfoManager", 1, "uin is null");
        } else if (stmomentinfo == null) {
            QLog.e("QZoneMomentInfoManager", 2, "momentInfo is null, return");
        } else {
            u(stmomentinfo);
        }
    }

    public static boolean n(HashMap<Integer, QZoneCountInfo> hashMap) {
        if (hashMap == null) {
            return false;
        }
        if (!b(hashMap) && !a(hashMap)) {
            return false;
        }
        return true;
    }

    public static boolean o(int i3) {
        if (i3 == 67) {
            return true;
        }
        return false;
    }

    public static boolean p(int i3) {
        if (i3 == 66) {
            return true;
        }
        return false;
    }

    public static boolean q(QZoneCountInfo qZoneCountInfo, int i3) {
        if (((IQZonePadApi) QRoute.api(IQZonePadApi.class)).isMomentSwitchClosed()) {
            QLog.d("QZoneMomentInfoManager", 1, "is pad, not show moment red count");
            return true;
        }
        if (qZoneCountInfo != null && qZoneCountInfo.cTime < j(i3) && qZoneCountInfo.uCount != k(i3)) {
            QLog.d("QZoneMomentInfoManager", 1, "count info cTime is " + qZoneCountInfo.cTime + " uCount is " + qZoneCountInfo.uCount + " cache time is " + j(i3) + "cache uCount is " + k(i3));
            return true;
        }
        return false;
    }

    public static boolean r(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            return false;
        }
        if (((IQZonePadApi) QRoute.api(IQZonePadApi.class)).isMomentSwitchClosed()) {
            QLog.d("QZoneMomentInfoManager", 1, "is pad, not show moment red count");
            return true;
        }
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<QZoneCountUserInfo> arrayList2 = qZoneCountInfo.friendList;
            QZoneCountUserInfo qZoneCountUserInfo = arrayList2.get(arrayList2.size() - 1);
            if (qZoneCountInfo.cTime > c() || !TextUtils.equals(String.valueOf(qZoneCountUserInfo.uin), String.valueOf(d()))) {
                return false;
            }
            RFWLog.d("QZoneMomentInfoManager", RFWLog.USR, "count info cTime is " + qZoneCountInfo.cTime + " uCount is " + qZoneCountInfo.uCount + " uCount uin is " + qZoneCountUserInfo.uin + "  " + d() + " last enter qzone time is " + c());
            return true;
        }
        RFWLog.e("QZoneMomentInfoManager", RFWLog.USR, "friend list is empty");
        return true;
    }

    public static boolean s() {
        if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
            return true;
        }
        long f16 = k.a().f("next_publish_timestamp", 0L);
        QLog.i("QZoneMomentInfoManager", 1, "reachNextPublishTimeStamp nextPublishTime is :" + f16 + " -> dataStr = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000 * f16)));
        if (NetConnInfoCenter.getServerTime() > f16) {
            return true;
        }
        return false;
    }

    public static void t(QZoneCountInfo qZoneCountInfo) {
        if (qZoneCountInfo == null) {
            return;
        }
        k.a().n("moment_red_count_67_timestamp", qZoneCountInfo.cTime);
        ArrayList<QZoneCountUserInfo> arrayList = qZoneCountInfo.friendList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<QZoneCountUserInfo> arrayList2 = qZoneCountInfo.friendList;
            QZoneCountUserInfo qZoneCountUserInfo = arrayList2.get(arrayList2.size() - 1);
            if (qZoneCountUserInfo == null) {
                RFWLog.e("QZoneMomentInfoManager", RFWLog.USR, "qZoneCountUserInfo is null");
                return;
            } else {
                k.a().n("moment_red_count_67_uin", qZoneCountUserInfo.uin);
                return;
            }
        }
        RFWLog.e("QZoneMomentInfoManager", RFWLog.USR, "friend list is empty");
    }

    private static void u(stMomentInfo stmomentinfo) {
        if (stmomentinfo == null) {
            QLog.e("QZoneMomentInfoManager", 1, "[saveMomentInfo] uin is null");
            return;
        }
        int i3 = stmomentinfo.allowSendMomentTimestamp;
        String str = stmomentinfo.entranceDecs;
        String str2 = stmomentinfo.notAllowSendMomentFeedDecs;
        int i16 = stmomentinfo.iAdID;
        String str3 = stmomentinfo.traceInfo;
        if (i3 == -1) {
            QLog.d("QZoneMomentInfoManager", 1, "not update moment info this time");
            return;
        }
        z(i3);
        k.a().p("moment_entrance_text", str);
        k.a().p("not_allow_send_moment_tips", str2);
        k.a().m("moment_tian_shu_ad_id", i16);
        k.a().p("moment_tian_shu_TRACE_INFO", str3);
    }

    public static void v(String str) {
        k.a().p("moment_entrance_root_is_show", str);
    }

    public static void w(int i3) {
        k.a().m("moment_is_showed_tian_shu_ad_id", i3);
    }

    public static void x(int i3, long j3) {
        if (i3 == 66) {
            k.a().n("moment_red_count_66_timestamp", j3);
        }
    }

    public static void y(int i3, long j3) {
        if (i3 == 66) {
            k.a().n("moment_red_count_66_ucount", j3);
        }
    }

    public static void z(long j3) {
        if (j3 < 0) {
            return;
        }
        QLog.i("QZoneMomentInfoManager", 1, "saveNextPublishTimeStamp: " + j3 + " -> dataStr = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000 * j3)));
        k.a().n("next_publish_timestamp", j3);
    }
}
