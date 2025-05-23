package com.tencent.mobileqq.utils;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.av.ManageConfig.QAVConfig;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cp {

    /* renamed from: a, reason: collision with root package name */
    private static a f307545a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f307546a = 0;

        /* renamed from: b, reason: collision with root package name */
        HashMap<String, d> f307547b = new HashMap<>();

        /* renamed from: c, reason: collision with root package name */
        int f307548c = 40;

        /* renamed from: d, reason: collision with root package name */
        int f307549d = 9;

        /* renamed from: e, reason: collision with root package name */
        int f307550e = 9;

        /* renamed from: f, reason: collision with root package name */
        int f307551f = 20;

        static a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a();
                    aVar.f307546a = jSONObject.optInt("task_id");
                    if (jSONObject.has("max_gaudio_member")) {
                        aVar.f307548c = jSONObject.optInt("max_gaudio_member");
                    }
                    if (jSONObject.has("max_select_num")) {
                        aVar.f307549d = jSONObject.optInt("max_select_num");
                    }
                    if (jSONObject.has("show_invite_box")) {
                        aVar.f307551f = jSONObject.optInt("show_invite_box");
                    }
                    if (jSONObject.has("auto_select_num")) {
                        aVar.f307550e = jSONObject.optInt("auto_select_num");
                    }
                    return aVar;
                } catch (Exception e16) {
                    QLog.d("QAVGroupConfig", 1, "parseJson, Exception", e16);
                }
            }
            return new a();
        }

        public d a(String str) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Map.Entry<String, d>> it = this.f307547b.entrySet().iterator();
            d dVar = null;
            while (it.hasNext()) {
                Map.Entry<String, d> next = it.next();
                String key = next.getKey();
                d value = next.getValue();
                if (currentTimeMillis > value.f307554a) {
                    it.remove();
                } else if (dVar == null && TextUtils.equals(str, key)) {
                    dVar = value;
                }
            }
            return dVar;
        }

        public void c(String str, String str2, String str3) {
            long j3;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (QQAudioHelper.f()) {
                    j3 = 60000;
                } else {
                    j3 = 600000;
                }
                d dVar = new d();
                dVar.f307554a = System.currentTimeMillis() + j3;
                dVar.f307555b = str2;
                dVar.f307556c = str3;
                this.f307547b.put(str, dVar);
            }
        }

        public String toString() {
            return "task_id[" + this.f307546a + "], max_gaudio_member[" + this.f307548c + "], max_select_num[" + this.f307549d + "], show_invite_box[" + this.f307551f + "], auto_select_num[" + this.f307550e + "]";
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f307552a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f307553b;

        public static b a(Bundle bundle) {
            b bVar = new b();
            bVar.f307552a = bundle.getString("uin");
            bVar.f307553b = bundle.getBoolean("enableInvite");
            return bVar;
        }

        public static void b(String str, QQAppInterface qQAppInterface, String str2) {
            boolean g16 = cp.g(str, qQAppInterface, str2);
            Intent intent = new Intent();
            intent.setAction("tencent.video.q2v.GroupInfoChanged");
            intent.putExtra("uin", str2);
            intent.putExtra("enableInvite", g16);
            intent.setPackage(qQAppInterface.getApplication().getPackageName());
            qQAppInterface.getApp().sendBroadcast(intent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c {
        public static void a(GroupMsgMask groupMsgMask) {
            if (groupMsgMask == GroupMsgMask.RECEIVE) {
                j("0X8009187");
            } else if (groupMsgMask == GroupMsgMask.ASSISTANT) {
                j("0X8009188");
            }
        }

        public static void b() {
            j("0X8008CC5");
        }

        public static void c(boolean z16) {
            if (z16) {
                j("0X8008CC7");
            } else {
                j("0X8008CC8");
            }
        }

        public static void d(boolean z16) {
            if (z16) {
                j("0X8008E7D");
            } else {
                j("0X8008E7E");
            }
        }

        public static void e(boolean z16) {
            if (z16) {
                j("0X8008CBA");
            } else {
                j("0X8008CB5");
            }
        }

        public static void f() {
            j("0X8008CC4");
        }

        public static void g() {
            j("0X8008CC6");
        }

        public static void h() {
            j("0X8008CC3");
        }

        public static void i(int i3, boolean z16) {
            if (QLog.isDevelopLevel()) {
                QLog.w("QAVGroupConfig", 1, "reportAVGroupNum, num[" + i3 + "], isVideo[" + z16 + "]");
            }
            if (z16) {
                HashMap hashMap = new HashMap();
                hashMap.put(WidgetCacheConstellationData.NUM, String.valueOf(i3));
                UserAction.onUserAction("reportAVGroupNum_video", true, -1L, -1L, hashMap, true);
            } else {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(WidgetCacheConstellationData.NUM, String.valueOf(i3));
                UserAction.onUserAction("reportAVGroupNum_audio", true, -1L, -1L, hashMap2, true);
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put(BaseProfileQZoneComponent.KEY_IS_VIDEO, String.valueOf(z16));
            hashMap3.put(WidgetCacheConstellationData.NUM, String.valueOf(i3));
            UserAction.onUserAction("reportAVGroupNum", true, -1L, -1L, hashMap3, true);
        }

        public static void j(String str) {
            if (QLog.isDevelopLevel()) {
                QLog.w("QAVGroupConfig", 1, "reportClickEvent, key[" + str + "]");
            }
            ReportController.o(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        long f307554a;

        /* renamed from: b, reason: collision with root package name */
        public String f307555b;

        /* renamed from: c, reason: collision with root package name */
        public String f307556c;
    }

    public static boolean c(VideoAppInterface videoAppInterface, long j3, boolean z16) {
        GroupMsgMask groupMsgMask;
        int i3;
        if (z16) {
            return true;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uin", String.valueOf(j3));
        Bundle s06 = videoAppInterface.s0(6, 0, 0, bundle, null);
        GroupMsgMask groupMsgMask2 = GroupMsgMask.NOTIFY;
        if (s06 != null) {
            groupMsgMask = TroopInfo.convertTroopMask(s06.getInt("mask", groupMsgMask2.ordinal()));
            i3 = s06.getInt(WidgetCacheConstellationData.NUM);
            if (QLog.isColorLevel()) {
                QLog.i("QAVGroupConfig", 2, "canShowInviteBox, mask[" + groupMsgMask + "], num[" + i3 + "]");
            }
        } else {
            groupMsgMask = groupMsgMask2;
            i3 = 0;
        }
        if (groupMsgMask2 == groupMsgMask) {
            if (QQAudioHelper.f()) {
                int c16 = QQAudioHelper.c(6);
                if (c16 == 1) {
                    return true;
                }
                if (c16 == 0) {
                    return false;
                }
            }
            a h16 = h();
            if (i3 <= h16.f307551f) {
                return true;
            }
            QLog.w("QAVGroupConfig", 1, "onGAudioInvite, \u6210\u5458\u592a\u591a, relationId[" + j3 + "], show_invite_box[" + h16.f307551f + "], MemberNum[" + i3 + "]");
            return false;
        }
        c.a(groupMsgMask);
        return false;
    }

    public static boolean d(QQAppInterface qQAppInterface, String str) {
        boolean z16;
        com.tencent.mobileqq.troop.utils.aj ajVar = (com.tencent.mobileqq.troop.utils.aj) qQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        boolean d16 = ajVar.d(str);
        boolean f16 = ajVar.f(str);
        if (!d16 && !f16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (1 == QQAudioHelper.c(7)) {
            QQAudioHelper.w(HardCodeUtil.qqStr(R.string.pqg));
            return true;
        }
        return z16;
    }

    @Deprecated
    private static List<TroopMemberInfo> e(String str) {
        final ArrayList arrayList = new ArrayList();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(str, null, false, "QAVGroupConfig", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.utils.cn
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z16, List list) {
                cp.r(arrayList, countDownLatch, z16, list);
            }
        });
        try {
            countDownLatch.await(500L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e16) {
            QLog.e("QAVGroupConfig", 1, "[getAllTroopMembers] ", e16);
        }
        return arrayList;
    }

    public static int f() {
        return h().f307550e;
    }

    public static boolean g(String str, QQAppInterface qQAppInterface, String str2) {
        String str3;
        String str4;
        boolean z16;
        boolean z17;
        TroopInfo B = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str2);
        boolean z18 = false;
        if (B != null) {
            boolean isOwner = B.isOwner();
            boolean isAdmin = B.isAdmin();
            int p16 = p(B);
            long j3 = B.troopPrivilegeFlag;
            long j16 = 0;
            if ((101711872 & j3) == 0) {
                str4 = HardCodeUtil.qqStr(R.string.pqd);
                z16 = true;
            } else if ((j3 & 33554432) == 33554432) {
                if (p16 > 50) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                str4 = HardCodeUtil.qqStr(R.string.pqe);
            } else if ((j3 & 67108864) == 67108864) {
                if (p16 > 100) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                str4 = HardCodeUtil.qqStr(R.string.pqf);
            } else {
                if ((j3 & 1048576) == 1048576) {
                    str3 = HardCodeUtil.qqStr(R.string.pqj);
                } else {
                    str3 = "";
                }
                str4 = str3;
                z16 = false;
            }
            if (z16 && B.isOwnerOrAdmin()) {
                str4 = str4 + HardCodeUtil.qqStr(R.string.pqi);
                z16 = false;
            }
            int memNumForAutoInviteIntoGroup = B.getMemNumForAutoInviteIntoGroup(qQAppInterface.getCurrentUin());
            if (memNumForAutoInviteIntoGroup >= 0) {
                if (p16 >= memNumForAutoInviteIntoGroup) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    str4 = str4 + HardCodeUtil.qqStr(R.string.pqh);
                }
            } else {
                z17 = false;
            }
            if (!z16 && !z17) {
                z18 = true;
            }
            com.tencent.mobileqq.troop.troopgag.data.e b16 = ((com.tencent.mobileqq.troop.utils.aj) qQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).b(str2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getCanAutoInviteMemIntoTroop[");
            sb5.append(str);
            sb5.append("], groupUin[");
            sb5.append(str2);
            sb5.append("][");
            sb5.append(B.troopname);
            sb5.append("], \n\u7fa4\u7981\u8a00\u65f6\u95f4\u6233[");
            sb5.append(B.dwGagTimeStamp);
            sb5.append("], \n\u7fa4\u7981\u8a00[");
            if (b16 != null) {
                j16 = b16.f300239b;
            }
            sb5.append(j16);
            sb5.append("], \n\u88ab\u7981\u8a00\u5230\u671f\u65f6\u95f4\u6233[");
            sb5.append(B.dwGagTimeStamp_me);
            sb5.append("], \n\u7fa4\u6210\u5458\u6570\u91cf[");
            sb5.append(B.wMemberNum);
            sb5.append("], \n\u7fa4\u6210\u5458\u6570\u91cfClient[");
            sb5.append(B.getMemberNumClient());
            sb5.append("], \n\u6700\u5927\u7684\u9080\u8bf7\u81ea\u52a8\u5165\u7fa4\u4eba\u6570[");
            sb5.append(B.maxInviteMemNum);
            sb5.append("|");
            sb5.append(memNumForAutoInviteIntoGroup);
            sb5.append("], \n\u540e\u53f0\u914d\u7f6e_\u6bcf\u6b21\u9009\u4eba\u4e0a\u9650[");
            sb5.append(n());
            sb5.append("], \n\u540e\u53f0\u914d\u7f6e_\u901a\u8bdd\u6210\u5458\u9080\u8bf7\u4e0a\u9650[");
            sb5.append(m());
            sb5.append("], \nmMemberInvitingFlag[");
            sb5.append(B.mMemberInvitingFlag);
            sb5.append("], \nisOnlyTroopMemberInviteOption[");
            sb5.append(B.isOnlyTroopMemberInviteOption());
            sb5.append("], \n\u7fa4\u80fd\u529b\u6807\u8bb0\u4f4dtroopPrivilegeFlag[");
            sb5.append(B.troopPrivilegeFlag);
            sb5.append("], \n\u7fa4\u6807\u8bb0\u4f4ddwGroupFlagExt3[");
            sb5.append(B.dwGroupFlagExt3);
            sb5.append("], \n\u7fa4\u7684\u52a0\u5165\u65b9\u5f0fcGroupOption[");
            sb5.append((int) B.cGroupOption);
            sb5.append("], \nneedAdminCheck[");
            sb5.append(z16);
            sb5.append("], \nneedAgree[");
            sb5.append(z17);
            sb5.append("], \nbOwner[");
            sb5.append(isOwner);
            sb5.append("], \nbAdmin[");
            sb5.append(isAdmin);
            sb5.append("], \nisAdmin[");
            sb5.append(B.isOwnerOrAdmin());
            sb5.append("], \nlog[");
            sb5.append(str4);
            sb5.append("], \n\u53ef\u4ee5\u9080\u8bf7[");
            sb5.append(z18);
            sb5.append("]");
            QLog.w("QAVGroupConfig", 1, sb5.toString());
        }
        return z18;
    }

    public static a h() {
        if (f307545a == null) {
            synchronized (a.class) {
                if (f307545a == null) {
                    f307545a = a.b(QAVConfig.e(276).f448490b);
                }
            }
        }
        return f307545a;
    }

    public static void i(String str, final QQAppInterface qQAppInterface, String str2) {
        long j3;
        final boolean z16;
        try {
            j3 = Long.parseLong(str2);
        } catch (Exception unused) {
            j3 = 0;
        }
        if (j3 == 0) {
            return;
        }
        final String str3 = str + "_" + QQAudioHelper.b();
        final String valueOf = String.valueOf(j3);
        int i3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str2).maxInviteMemNum;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(valueOf, "QAVGroupConfig", null, new Function2() { // from class: com.tencent.mobileqq.utils.co
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit s16;
                s16 = cp.s(valueOf, str3, qQAppInterface, z16, (Boolean) obj, (TroopInfo) obj2);
                return s16;
            }
        });
        QLog.w("QAVGroupConfig", 1, "getGroupInfo[" + str3 + "], troopuin[" + j3 + "], maxInviteMemNum[" + i3 + "]");
    }

    public static Bundle j(QQAppInterface qQAppInterface, String str) {
        int i3;
        com.tencent.mobileqq.troop.utils.aj ajVar = (com.tencent.mobileqq.troop.utils.aj) qQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        boolean e16 = ajVar.e(str);
        boolean d16 = ajVar.d(str);
        boolean f16 = ajVar.f(str);
        com.tencent.mobileqq.troop.troopgag.data.e b16 = ajVar.b(str);
        boolean z16 = true;
        if (!f16 && e16) {
            i3 = R.string.ded;
        } else if (!d16 && b16 != null && b16.f300239b != 0) {
            i3 = R.string.dec;
        } else {
            z16 = false;
            i3 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isAdmin", d16);
        bundle.putBoolean("isOwner", f16);
        bundle.putBoolean("forceDisableInviteBox", z16);
        bundle.putInt("errId", i3);
        return bundle;
    }

    public static Bundle k(QQAppInterface qQAppInterface, String str) {
        int i3;
        boolean z16;
        int o16 = o(qQAppInterface, true, str);
        GroupMsgMask troopMask = qQAppInterface.getTroopMask(str);
        com.tencent.mobileqq.troop.utils.aj ajVar = (com.tencent.mobileqq.troop.utils.aj) qQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
        boolean e16 = ajVar.e(str);
        boolean d16 = ajVar.d(str);
        boolean f16 = ajVar.f(str);
        com.tencent.mobileqq.troop.troopgag.data.e b16 = ajVar.b(str);
        boolean z17 = false;
        if (!f16 && e16) {
            i3 = R.string.ded;
        } else if (!d16 && b16 != null && b16.f300239b != 0) {
            i3 = R.string.dec;
        } else {
            i3 = 0;
            z16 = false;
            Bundle bundle = new Bundle();
            bundle.putInt("mask", troopMask.ordinal());
            bundle.putInt(WidgetCacheConstellationData.NUM, o16);
            bundle.putBoolean("isAdmin", d16);
            bundle.putBoolean("isOwner", f16);
            bundle.putBoolean("forceDisableInviteBox", z16);
            bundle.putInt("errId", i3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getGroupMask, troopUin[");
            sb5.append(str);
            sb5.append("], mask[");
            sb5.append(troopMask.ordinal());
            sb5.append("], num[");
            sb5.append(o16);
            sb5.append("], isOwner[");
            sb5.append(f16);
            sb5.append("], isMemberGaged[");
            sb5.append(e16);
            sb5.append("], isAdmin[");
            sb5.append(d16);
            sb5.append("], gagTimeStamp[");
            if (b16 != null && b16.f300239b != 0) {
                z17 = true;
            }
            sb5.append(z17);
            sb5.append("], forceDisableInviteBox[");
            sb5.append(z16);
            sb5.append("]");
            QLog.w("QAVGroupConfig", 1, sb5.toString());
            return bundle;
        }
        z16 = true;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("mask", troopMask.ordinal());
        bundle2.putInt(WidgetCacheConstellationData.NUM, o16);
        bundle2.putBoolean("isAdmin", d16);
        bundle2.putBoolean("isOwner", f16);
        bundle2.putBoolean("forceDisableInviteBox", z16);
        bundle2.putInt("errId", i3);
        StringBuilder sb52 = new StringBuilder();
        sb52.append("getGroupMask, troopUin[");
        sb52.append(str);
        sb52.append("], mask[");
        sb52.append(troopMask.ordinal());
        sb52.append("], num[");
        sb52.append(o16);
        sb52.append("], isOwner[");
        sb52.append(f16);
        sb52.append("], isMemberGaged[");
        sb52.append(e16);
        sb52.append("], isAdmin[");
        sb52.append(d16);
        sb52.append("], gagTimeStamp[");
        if (b16 != null) {
            z17 = true;
        }
        sb52.append(z17);
        sb52.append("], forceDisableInviteBox[");
        sb52.append(z16);
        sb52.append("]");
        QLog.w("QAVGroupConfig", 1, sb52.toString());
        return bundle2;
    }

    public static int l(QQAppInterface qQAppInterface, String str) {
        List<TroopMemberInfo> e16;
        int p16 = p(((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).B(str));
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "getGroupMemberNum, groupUin[" + str + "], memberCount[" + p16 + "]";
        int i3 = 0;
        if (p16 - 10 < m() && (e16 = e(String.valueOf(str))) != null) {
            ITroopRobotService iTroopRobotService = (ITroopRobotService) qQAppInterface.getRuntimeService(ITroopRobotService.class, "all");
            QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
            for (TroopMemberInfo troopMemberInfo : e16) {
                if (!iTroopRobotService.isRobotUin(troopMemberInfo.memberuin) && !qidianManager.R(troopMemberInfo.memberuin)) {
                    i3++;
                } else {
                    str2 = str2 + "\nisRobotUin[" + troopMemberInfo.memberuin + "]";
                }
            }
            str2 = str2 + "\nCalcCount[" + i3 + "]";
        }
        if (i3 != 0) {
            p16 = i3;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w("QAVGroupConfig", 1, "" + str2 + ", time[" + (System.currentTimeMillis() - currentTimeMillis) + "]");
        }
        return p16;
    }

    public static int m() {
        return h().f307548c;
    }

    public static int n() {
        return h().f307549d;
    }

    public static int o(QQAppInterface qQAppInterface, boolean z16, String str) {
        if (qQAppInterface != null) {
            if (z16) {
                return l(qQAppInterface, str);
            }
            return ((com.tencent.mobileqq.app.n) qQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).q(str);
        }
        return 0;
    }

    static int p(TroopInfo troopInfo) {
        int memberNumClient = troopInfo.getMemberNumClient();
        if (QQAudioHelper.j()) {
            QLog.w("QAVGroupConfig", 1, "getMemberNum, troopuin[" + troopInfo.troopuin + "], memberNumClient[" + troopInfo.getMemberNumClient() + "], wMemberNum[" + troopInfo.wMemberNum + "], troopcode[" + troopInfo.troopcode + "]");
        }
        return memberNumClient;
    }

    public static void q(String str) {
        a b16 = a.b(str);
        synchronized (a.class) {
            f307545a = b16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(List list, CountDownLatch countDownLatch, boolean z16, List list2) {
        list.addAll(list2);
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit s(String str, String str2, QQAppInterface qQAppInterface, boolean z16, Boolean bool, TroopInfo troopInfo) {
        if (!TextUtils.equals(str, troopInfo.getTroopUin())) {
            return null;
        }
        QLog.w("QAVGroupConfig", 1, "getTroopInfoCallback[" + str2 + "], troopuin[" + str + "], isSuc[" + bool + "]");
        if (!bool.booleanValue()) {
            return null;
        }
        b.b(str2 + ".onGetTroopInfoForSetJoinTypeRet", qQAppInterface, str);
        if (z16) {
            b.b(str2 + ".onGetTroopInfoResult", qQAppInterface, str);
        }
        return null;
    }
}
