package com.tencent.mobileqq.troopAddFrd;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.troop.utils.x;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f302669a;

    /* renamed from: b, reason: collision with root package name */
    public int f302670b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f302671c;

    /* renamed from: d, reason: collision with root package name */
    public long f302672d;

    /* renamed from: e, reason: collision with root package name */
    public String f302673e;

    /* renamed from: f, reason: collision with root package name */
    public String f302674f;

    /* renamed from: g, reason: collision with root package name */
    public int f302675g;

    /* renamed from: h, reason: collision with root package name */
    public int f302676h;

    /* renamed from: i, reason: collision with root package name */
    public List<String> f302677i;

    /* renamed from: j, reason: collision with root package name */
    private a f302678j;

    /* renamed from: k, reason: collision with root package name */
    private QQAppInterface f302679k;

    /* renamed from: l, reason: collision with root package name */
    private List<TroopMemberInfo> f302680l;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(d dVar);

        void b(d dVar);
    }

    public d(QQAppInterface qQAppInterface, String str, int i3, a aVar, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, str, Integer.valueOf(i3), aVar, list);
            return;
        }
        this.f302670b = 0;
        this.f302671c = 0;
        this.f302675g = 0;
        this.f302680l = new ArrayList();
        this.f302679k = qQAppInterface;
        this.f302669a = str;
        this.f302670b = i3;
        this.f302678j = aVar;
        this.f302677i = list;
        this.f302672d = System.currentTimeMillis();
    }

    public static boolean e(QQAppInterface qQAppInterface, String str, int i3) {
        boolean g16;
        if (i3 == 1) {
            g16 = f(qQAppInterface, str, i3);
        } else {
            g16 = g(qQAppInterface, str, i3);
        }
        QLog.isColorLevel();
        return g16;
    }

    public static boolean f(QQAppInterface qQAppInterface, String str, int i3) {
        TroopInfo k3;
        if (qQAppInterface == null || TextUtils.isEmpty(str) || (k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str)) == null) {
            return false;
        }
        o(qQAppInterface, false, k3);
        return false;
    }

    public static boolean g(QQAppInterface qQAppInterface, String str, int i3) {
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("checkCommCondition");
        sb5.append(" ");
        sb5.append(str);
        sb5.append("_");
        sb5.append(i3);
        TroopInfo k3 = ((TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        if (k3 == null) {
            sb5.append(" ");
            sb5.append("err:");
            sb5.append("troopinfo is null");
            if (QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.Scene", 2, sb5.toString());
            }
            return false;
        }
        o(qQAppInterface, false, k3);
        return false;
    }

    private boolean l() {
        boolean z16;
        Object[] p16 = p(this.f302679k, this.f302669a);
        if (p16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V1 data=null");
            }
            return false;
        }
        int intValue = ((Integer) p16[0]).intValue();
        int intValue2 = ((Integer) p16[1]).intValue();
        int intValue3 = ((Integer) p16[2]).intValue();
        com.tencent.mobileqq.relationx.batchAdd.c o16 = ((TroopManager) this.f302679k.getManager(QQManagerFactory.TROOP_MANAGER)).o();
        float f16 = intValue;
        int i3 = (int) (o16.commonFrdPropLimit * f16);
        int i16 = (int) (o16.nonFrdPropLimit * f16);
        if (intValue2 >= i3 && intValue3 >= i16 && intValue3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.Scene", 2, String.format("checkTipCondition_V1 nComFrdCnt_limit_nNonFrdCnt_limit_check=%d_%d_%d_%d_%b", Integer.valueOf(intValue2), Integer.valueOf(i3), Integer.valueOf(intValue3), Integer.valueOf(i16), Boolean.valueOf(z16)));
        }
        if (z16) {
            return true;
        }
        if (intValue2 < i3 && intValue != 0) {
            String format = String.format(Locale.getDefault(), "%.3f", Float.valueOf(intValue2 / f16));
            ReportController.o(this.f302679k, "dc00899", "Grp_addFrd", "", "nonGreyTip", "commonFrd", 0, 0, this.f302669a, "", format.substring(0, format.length() - 1), "");
        }
        if (intValue3 < i16 && intValue != 0) {
            String format2 = String.format(Locale.getDefault(), "%.2f", Float.valueOf(intValue3 / f16));
            ReportController.o(this.f302679k, "dc00899", "Grp_addFrd", "", "nonGreyTip", "nonFrd", 0, 0, this.f302669a, "", format2.substring(0, format2.length() - 1), "");
        }
        return false;
    }

    private boolean m() {
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) this.f302679k.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
        List<TroopMemberInfo> q16 = q();
        if (q16 != null && q16.size() != 0) {
            this.f302673e = null;
            this.f302674f = null;
            this.f302676h = q16.size();
            for (int i3 = 0; i3 < q16.size(); i3++) {
                TroopMemberInfo troopMemberInfo = q16.get(i3);
                if (troopBatchAddFriendMgr.G(troopMemberInfo.memberuin, this.f302670b) && troopMemberInfo.getCommonFrdCnt() > this.f302675g) {
                    this.f302675g = troopMemberInfo.getCommonFrdCnt();
                }
            }
            if (!TextUtils.isEmpty(this.f302673e) && !TextUtils.isEmpty(this.f302674f)) {
                if (QLog.isColorLevel()) {
                    QLog.d("troopBatchAddFrd.Scene", 2, "recommend " + this.f302673e);
                    return true;
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 already recommended");
            }
            d(q16);
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.Scene", 2, "checkTipCondition_V2 notFrdMems not match");
        }
        return false;
    }

    public static boolean n(int i3) {
        if (i3 > 0 && i3 < 7) {
            return true;
        }
        return false;
    }

    public static void o(QQAppInterface qQAppInterface, boolean z16, TroopInfo troopInfo) {
        boolean z17;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(qQAppInterface.getApp());
        long j3 = defaultSharedPreferences.getLong(String.format(Locale.getDefault(), "%s_%s_%s", "sp_baf_data_check_flag_members", qQAppInterface.getCurrentAccountUin(), troopInfo.troopuin), 0L);
        if (j3 > 0 && j3 - System.currentTimeMillis() > 86400000) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("troopBatchAddFrd.Scene", 2, String.format("dealWithOldTip force_troopUin_invalid=%b_%s_%b seq1_seq2=%d_0", Boolean.valueOf(z16), troopInfo.troopuin, Boolean.valueOf(z17), Long.valueOf(troopInfo.extDBInfo.lastBAFTipMsgUniSeq)));
        }
        if (z17 || z16) {
            if (troopInfo.extDBInfo.lastBAFTipMsgUniSeq != 0) {
                ArrayList<Long> arrayList = new ArrayList<>();
                arrayList.add(Long.valueOf(troopInfo.extDBInfo.lastBAFTipMsgUniSeq));
                ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(2, troopInfo.troopuin, ""), arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.troopAddFrd.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        d.y(i3, str);
                    }
                });
                ITroopExtInfoDBApi iTroopExtInfoDBApi = (ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class);
                String troopUin = troopInfo.getTroopUin();
                TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
                iTroopExtInfoDBApi.updateBatchAddFriendData(troopUin, troopExtDBInfo.lastInsertBAFTipTime, troopExtDBInfo.insertBAFTipCount, 0L);
            }
            if (z17) {
                defaultSharedPreferences.edit().putInt(String.format(Locale.getDefault(), "%s_%s_%s", "sp_baf_security_check_flag", qQAppInterface.getCurrentAccountUin(), troopInfo.troopuin), 0).apply();
            }
        }
    }

    private Object[] p(AppInterface appInterface, String str) {
        String str2;
        String str3;
        FriendsManager friendsManager = (FriendsManager) appInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        TroopInfo k3 = ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
        TroopMemberInfo troopMemberInfo = null;
        if (k3 == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("troopBatchAddFrd.Scene", 4, String.format(Locale.getDefault(), "getFrdCntInfosWithRecommand troopInfo is null! troopUin: %s", str));
            }
            return null;
        }
        String account = appInterface.getAccount();
        ITroopRobotService iTroopRobotService = (ITroopRobotService) appInterface.getRuntimeService(ITroopRobotService.class, "all");
        TroopMemberInfo troopMemberInfo2 = null;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        for (TroopMemberInfo troopMemberInfo3 : this.f302680l) {
            if (Utils.M(troopMemberInfo3.memberuin) && !Utils.I(troopMemberInfo3.memberuin) && !TextUtils.equals(troopMemberInfo3.memberuin, account) && (iTroopRobotService == null || !iTroopRobotService.isRobotUin(troopMemberInfo3.memberuin))) {
                if (!friendsManager.c0(troopMemberInfo3.memberuin)) {
                    i17++;
                    if (troopMemberInfo3.getCommonFrdCnt() > 0) {
                        i16++;
                    }
                    if (troopMemberInfo3.getCommonFrdCnt() > 0) {
                        if (troopMemberInfo == null || troopMemberInfo.getCommonFrdCnt() < troopMemberInfo3.getCommonFrdCnt()) {
                            troopMemberInfo = troopMemberInfo3;
                        }
                    } else if (troopMemberInfo2 == null) {
                        troopMemberInfo2 = troopMemberInfo3;
                    }
                }
            } else {
                i3++;
            }
        }
        if (troopMemberInfo != null) {
            str2 = u(troopMemberInfo);
            str3 = troopMemberInfo.memberuin;
            if (QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.Scene", 2, "getFrdCntInfosWithRecommand use:member_withComFrdNoRemark frdUin=" + str3);
            }
        } else if (troopMemberInfo2 != null) {
            str2 = u(troopMemberInfo2);
            str3 = troopMemberInfo2.memberuin;
            if (QLog.isColorLevel()) {
                QLog.i("troopBatchAddFrd.Scene", 2, "getFrdCntInfosWithRecommand use:member_noComFrdNoRemark frdUin=" + str3);
            }
        } else {
            str2 = "";
            str3 = "";
        }
        return new Object[]{Integer.valueOf(k3.wMemberNum - i3), Integer.valueOf(i16), Integer.valueOf(i17), str3, str2};
    }

    private List<TroopMemberInfo> r(QQAppInterface qQAppInterface, String str, List<String> list, boolean z16) {
        ArrayList<TroopMemberInfo> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (TroopMemberInfo troopMemberInfo : this.f302680l) {
                if (list.contains(troopMemberInfo.memberuin)) {
                    arrayList.add(troopMemberInfo);
                }
            }
        } else {
            arrayList.addAll(this.f302680l);
        }
        int size = arrayList.size();
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        String account = qQAppInterface.getAccount();
        ArrayList arrayList2 = new ArrayList();
        for (TroopMemberInfo troopMemberInfo2 : arrayList) {
            if (!friendsManager.c0(troopMemberInfo2.memberuin) && Utils.M(troopMemberInfo2.memberuin) && !TextUtils.equals(troopMemberInfo2.memberuin, account) && !k.l(qQAppInterface, troopMemberInfo2.memberuin)) {
                arrayList2.add(troopMemberInfo2);
            }
        }
        if (z16) {
            Collections.sort(arrayList2, new Comparator() { // from class: com.tencent.mobileqq.troopAddFrd.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int z17;
                    z17 = d.z((TroopMemberInfo) obj, (TroopMemberInfo) obj2);
                    return z17;
                }
            });
        }
        QLog.i("troopBatchAddFrd.Scene", 1, String.format("[getNotFrdsList] troopUin_cNotFrdsSize=%s_%d total=%d", str, Integer.valueOf(arrayList.size()), Integer.valueOf(size)));
        return arrayList2;
    }

    public static int s(int i3) {
        if (i3 != 1) {
            if (i3 == 2) {
                return 1;
            }
            if (i3 != 4) {
                return -1;
            }
            return 3;
        }
        return 0;
    }

    public static int t(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return 60;
                }
                return 8;
            }
            return 55;
        }
        return 5;
    }

    private String u(TroopMemberInfo troopMemberInfo) {
        String str;
        if (troopMemberInfo == null) {
            return "";
        }
        if (TextUtils.isEmpty(troopMemberInfo.troopnick)) {
            str = troopMemberInfo.friendnick;
        } else {
            str = troopMemberInfo.troopnick;
        }
        if (TextUtils.isEmpty(str)) {
            return troopMemberInfo.memberuin;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(boolean z16, List list) {
        QLog.i("troopBatchAddFrd.Scene", 1, "[checkDataTroopMemberList] fetchTroopMemberListFromDB isSuccess:" + z16);
        F(new ArrayList(list));
        B(z16, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(int i3, String str) {
        QLog.i("troopBatchAddFrd.Scene", 1, "batchAddFrd_deleteMsg, result=" + i3 + ", msg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int z(TroopMemberInfo troopMemberInfo, TroopMemberInfo troopMemberInfo2) {
        return troopMemberInfo2.getCommonFrdCnt() - troopMemberInfo.getCommonFrdCnt();
    }

    public void A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
            return;
        }
        this.f302671c = -1;
        if (QLog.isColorLevel()) {
            QLog.i("troopBatchAddFrd.Scene", 2, String.format("onErr %s", str));
        }
        a aVar = this.f302678j;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void B(boolean z16, int i3) {
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        QLog.i("troopBatchAddFrd.Scene", 1, String.format("onStepAndNext troopUin_type_ts_suc_step=%s_%d_%d_%b_%d", this.f302669a, Integer.valueOf(this.f302670b), Long.valueOf(this.f302672d), Boolean.valueOf(z16), Integer.valueOf(i3)));
        if (z16) {
            i16 = i3;
        } else {
            i16 = -1;
        }
        this.f302671c = i16;
        QLog.i("troopBatchAddFrd.Scene", 2, "[onStepAndNext] do check in state: " + this.f302671c);
        if (this.f302671c == 0) {
            i17 = j();
        } else if (this.f302671c == 1) {
            i17 = i();
        } else if (this.f302671c == 2) {
            i17 = h();
        } else if (this.f302671c == 3) {
            i17 = k();
        } else if (this.f302671c == 4) {
            C();
            return;
        } else {
            if (this.f302671c == 5) {
                v();
                return;
            }
            i17 = -1;
        }
        QLog.i("troopBatchAddFrd.Scene", 2, "[onStepAndNext] result of check-state:" + this.f302671c + " is " + i17);
        if (i17 != -1) {
            if (i17 == 1) {
                B(true, this.f302671c + 1);
                return;
            }
            return;
        }
        A(String.format("onStepAndNext err %s_%d_%d_%b_%d", this.f302669a, Integer.valueOf(this.f302670b), Long.valueOf(this.f302672d), Boolean.valueOf(z16), Integer.valueOf(i3)));
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("troopBatchAddFrd.Scene", 2, "onSuc troopUin = " + this.f302669a + ",type = " + this.f302670b + ",ts=" + this.f302672d);
        }
        a aVar = this.f302678j;
        if (aVar != null) {
            aVar.b(this);
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.f302671c == 4) {
            QLog.i("troopBatchAddFrd.Scene", 2, "[startCheck] already ready. invoke onSuc directly");
            C();
        }
        if (this.f302671c != 0) {
            QLog.i("troopBatchAddFrd.Scene", 2, "[startCheck] already has task. state: " + this.f302671c);
            return;
        }
        B(true, 0);
    }

    public void E(HashMap<String, Integer> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) hashMap);
            return;
        }
        for (int i3 = 0; i3 < this.f302680l.size(); i3++) {
            TroopMemberInfo troopMemberInfo = this.f302680l.get(i3);
            Integer num = hashMap.get(troopMemberInfo.memberuin);
            if (num != null) {
                troopMemberInfo.setCommonFrdCnt(num.intValue());
            }
        }
    }

    public void F(List<TroopMemberInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        } else {
            this.f302680l = list;
        }
    }

    void d(List<TroopMemberInfo> list) {
        boolean z16;
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) this.f302679k.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
        int i3 = 0;
        if (list != null && list.size() > 0) {
            Iterator<TroopMemberInfo> it = list.iterator();
            while (it.hasNext()) {
                if (troopBatchAddFriendMgr.x(it.next().memberuin) < 0) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (z16) {
            TroopInfo k3 = ((TroopManager) this.f302679k.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f302669a);
            if (k3 != null) {
                i3 = k3.wMemberNum;
            }
            ReportController.o(this.f302679k, "dc00899", "Grp_addFrd", "", "nonGreyTip", "UinNum_total", 0, 0, this.f302669a, Integer.toString(s(this.f302670b)), Integer.toString(i3), "");
        }
    }

    public int h() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        long j3 = PreferenceManager.getDefaultSharedPreferences(this.f302679k.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", "sp_baf_data_check_flag_cmnfrds", this.f302679k.getCurrentAccountUin(), this.f302669a), 0L);
        com.tencent.mobileqq.relationx.batchAdd.c o16 = ((TroopManager) this.f302679k.getManager(QQManagerFactory.TROOP_MANAGER)).o();
        if (j3 != 0 && System.currentTimeMillis() - j3 <= o16.cacheTimeCmnFrdCntData * 60 * 60 * 1000) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.d("troopBatchAddFrd.Scene", 1, String.format(Locale.getDefault(), "checkDataCmnFrdCntList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s", Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(this.f302670b), this.f302669a));
        if (!z16 && this.f302670b != 4) {
            return 1;
        }
        int S = ((ITroopBatchAddFriendService) this.f302679k.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().S(this.f302669a, j3, this.f302670b, !z16, this.f302677i, this.f302680l);
        QLog.i("troopBatchAddFrd.Scene", 2, "[checkDataCmnFrdCntList] startReqCmnFrdCntList result: " + S);
        if (S == 0) {
            return 0;
        }
        if (S == 1) {
            return 1;
        }
        return -1;
    }

    public int i() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        long j3 = PreferenceManager.getDefaultSharedPreferences(this.f302679k.getApp()).getLong(String.format(Locale.getDefault(), "%s_%s_%s", "sp_baf_data_check_flag_members", this.f302679k.getCurrentAccountUin(), this.f302669a), 0L);
        if (j3 != 0 && System.currentTimeMillis() - j3 <= 86400000) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("troopBatchAddFrd.Scene", 2, String.format(Locale.getDefault(), "checkDataTroopMemberList cacheInvalid_ts_type_troopUin=%b_%d_%d_%s, isValid=%b", Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(this.f302670b), this.f302669a, Boolean.valueOf(z16)));
        }
        if (z16) {
            int T = ((ITroopBatchAddFriendService) this.f302679k.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().T(this.f302669a, j3, this.f302670b);
            QLog.i("troopBatchAddFrd.Scene", 2, "[checkDataTroopMemberList] startReqTroopMemberList result: " + T);
            if (T == 0) {
                return 0;
            }
            if (T == 1) {
                return 1;
            }
            return -1;
        }
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberListWithExtInfo(this.f302669a, null, false, "troopBatchAddFrd.Scene", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.troopAddFrd.b
            @Override // com.tencent.qqnt.troopmemberlist.f
            public final void a(boolean z17, List list) {
                d.this.x(z17, list);
            }
        });
        return 0;
    }

    public int j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        TroopInfo k3 = ((TroopManager) this.f302679k.getManager(QQManagerFactory.TROOP_MANAGER)).k(this.f302669a);
        if (k3 == null) {
            return -1;
        }
        int i3 = PreferenceManager.getDefaultSharedPreferences(this.f302679k.getApp()).getInt(String.format(Locale.getDefault(), "%s_%s_%s", "sp_baf_security_check_flag", this.f302679k.getCurrentAccountUin(), this.f302669a), 0);
        if (i3 == 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("troopBatchAddFrd.Scene", 2, "checkSecurity need execute security check!");
            }
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                if (QLog.isColorLevel()) {
                    QLog.i("troopBatchAddFrd.Scene", 2, String.format("checkSecurity return %s. net connect err", k3.troopuin));
                }
                return -1;
            }
            ((com.tencent.mobileqq.troop.api.handler.a) this.f302679k.getBusinessHandler(BusinessHandlerFactory.TROOP_ADD_FRIEND_HANDLER)).b0(k3.troopuin, k3.troopcode, this.f302672d, this.f302670b);
            return 0;
        }
        if (i3 != 1) {
            if (QLog.isColorLevel()) {
                QLog.d("troopBatchAddFrd.Scene", 2, String.format(Locale.getDefault(), "checkSecurity fail value: %s", Integer.valueOf(i3)));
            }
            return -1;
        }
        QLog.i("troopBatchAddFrd.Scene", 2, String.format(Locale.getDefault(), "[checkSecurity] success. value: %d", Integer.valueOf(i3)));
        return 1;
    }

    public int k() {
        boolean z16;
        boolean m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        boolean z17 = false;
        if (this.f302670b == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        TroopManager troopManager = (TroopManager) this.f302679k.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            if (troopManager.o().mJoinTroopStrategy == com.tencent.mobileqq.relationx.batchAdd.c.L) {
                z17 = true;
            }
            z16 &= z17;
        }
        if (z16) {
            m3 = l();
        } else {
            m3 = m();
        }
        QLog.isColorLevel();
        if (m3) {
            return 1;
        }
        return -1;
    }

    List<TroopMemberInfo> q() {
        List<TroopMemberInfo> r16;
        TroopManager troopManager = (TroopManager) this.f302679k.getManager(QQManagerFactory.TROOP_MANAGER);
        com.tencent.mobileqq.relationx.batchAdd.c o16 = troopManager.o();
        TroopInfo k3 = troopManager.k(this.f302669a);
        int a16 = o16.a(this.f302670b);
        int i3 = this.f302670b;
        boolean z16 = true;
        int i16 = 0;
        if (i3 != 1) {
            r16 = null;
            if (i3 != 2) {
                if (i3 == 4) {
                    r16 = new ArrayList<>();
                    List<TroopMemberInfo> r17 = r(this.f302679k, this.f302669a, this.f302677i, false);
                    for (int i17 = 0; i17 < r17.size(); i17++) {
                        TroopMemberInfo troopMemberInfo = r17.get(i17);
                        if (troopMemberInfo.noCommonFrdCnt()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("troopBatchAddFrd.Scene", 2, "commonFrdCnt org:" + troopMemberInfo.getCommonFrdCnt());
                            }
                            troopMemberInfo.setCommonFrdCnt(0);
                        }
                        if (troopMemberInfo.getCommonFrdCnt() >= a16) {
                            r16.add(troopMemberInfo);
                        }
                    }
                    if (r16.size() == 0) {
                        QQAppInterface qQAppInterface = this.f302679k;
                        String str = this.f302669a;
                        if (r17.size() != 0) {
                            i16 = r17.get(0).getCommonFrdCnt();
                        }
                        ReportController.o(qQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "new_res", 0, 0, str, Integer.toString(i16), "", "");
                    }
                }
            } else {
                ArrayList arrayList = new ArrayList();
                List<TroopMemberInfo> r18 = r(this.f302679k, this.f302669a, this.f302677i, true);
                int i18 = 0;
                for (int i19 = 0; i19 < r18.size(); i19++) {
                    TroopMemberInfo troopMemberInfo2 = r18.get(i19);
                    troopMemberInfo2.setCommonFrdCnt(Math.max(0, troopMemberInfo2.getCommonFrdCnt()));
                    if (troopMemberInfo2.getCommonFrdCnt() > 0) {
                        i18++;
                    }
                    if (troopMemberInfo2.getCommonFrdCnt() > a16) {
                        arrayList.add(troopMemberInfo2);
                    }
                }
                if (i18 < a16) {
                    QQAppInterface qQAppInterface2 = this.f302679k;
                    String str2 = this.f302669a;
                    String num = Integer.toString(i18);
                    if (k3 != null) {
                        i16 = k3.wMemberNum;
                    }
                    ReportController.o(qQAppInterface2, "dc00899", "Grp_addFrd", "", "nonGreyTip", "actvie-res", 0, 0, str2, num, Integer.toString(i16), "");
                } else {
                    r16 = arrayList;
                }
                if (r16 != null) {
                    QLog.i("troopBatchAddFrd.Scene", 1, "[getMembersWithRequiredCommonFriendsCount] TYPE_ACTIVE notFrdMems.size = " + r16.size());
                }
            }
        } else {
            if (o16.mJoinTroopStrategy != com.tencent.mobileqq.relationx.batchAdd.c.L) {
                z16 = false;
            }
            r16 = r(this.f302679k, this.f302669a, this.f302677i, z16);
            if (QLog.isDevelopLevel()) {
                QLog.d("troopBatchAddFrd.Scene", 4, "Scene.TYPE_JOIN getNotFrdsList size=" + r16.size());
            }
        }
        return r16;
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        x troopBatchAddFriendMgr = ((ITroopBatchAddFriendService) this.f302679k.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
        if (troopBatchAddFriendMgr != null) {
            troopBatchAddFriendMgr.F(this.f302673e, this.f302670b);
        }
    }

    public boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f302671c != -1 && this.f302671c != 5) {
            return true;
        }
        return false;
    }
}
