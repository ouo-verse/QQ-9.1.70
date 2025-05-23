package com.tencent.mobileqq.troop.troopcreate.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.mobileqq.troop.troopcreate.event.TroopCreateDoneEvent;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troop.TroopListRepo;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopCreateServiceImpl implements ITroopCreateService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TroopCreateServiceImpl";
    protected static final String TROOP_CREATE_LOG_TAG = "TroopCreate_Log";
    private AppInterface mApp;
    private ITroopCreateInfoService.a mCreateCallback;
    private TroopCreateInfo mTroopCreateInfo;
    private ITroopCreateInfoService mTroopCreateInfoService;
    com.tencent.mobileqq.troop.api.observer.e mTroopInfoObserver;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopCreateServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetTroopInfoResultAfterCreate(boolean z16, TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), troopInfo);
            } else {
                TroopCreateServiceImpl.this.jumpToAioAfterCreated(troopInfo.troopuin, troopInfo.getTroopDisplayName(), false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a();
    }

    public TroopCreateServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mTroopInfoObserver = new a();
        }
    }

    private void inviteToGroupWithNonFriends(final String str, final List<TroopCreateInfo.a> list, @NonNull final b bVar) {
        if (list != null && list.size() != 0) {
            final ArrayList arrayList = new ArrayList();
            Iterator<TroopCreateInfo.a> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().f294787a);
            }
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).fetchUin2UidMap(arrayList, true, true, new IRelationNTUinAndUidApi.c() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.c
                @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.c
                public final void a(Map map) {
                    TroopCreateServiceImpl.this.lambda$inviteToGroupWithNonFriends$8(str, bVar, arrayList, list, map);
                }
            });
            return;
        }
        QLog.e(TAG, 1, "[inviteToGroupWithNonFriends] no invite member");
        this.mCreateCallback = null;
        bVar.a();
    }

    private void jumpToAioAfterInvited() {
        if (!this.mTroopCreateInfo.isJumpAio) {
            return;
        }
        if (com.tencent.mobileqq.troop.trooptodo.a.a("jumpAioRunnable")) {
            QLog.w(TAG, 1, "[run] ignore jumpAio. fast click");
        } else {
            TroopCreateInfo troopCreateInfo = this.mTroopCreateInfo;
            jumpToAioAfterCreated(troopCreateInfo.troopUin, troopCreateInfo.name, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createTroop$1(List list, HashMap hashMap, final Activity activity, Map map) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = (String) map.get(str);
            TroopCreateInfo.a aVar = (TroopCreateInfo.a) hashMap.get(str);
            if (!TextUtils.isEmpty(str2) && aVar != null) {
                aVar.f294788b = str2;
            }
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.i
            @Override // java.lang.Runnable
            public final void run() {
                TroopCreateServiceImpl.this.lambda$createTroop$0(activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteToGroupWithNonFriends$6(String str, boolean z16, int i3, b bVar) {
        onInviteComplete(str, z16, i3);
        bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteToGroupWithNonFriends$7(final String str, final b bVar, final boolean z16, final int i3, String str2) {
        QLog.i(TAG, 1, "[inviteToGroupWithNonFriends] suc:" + z16 + ",res:" + i3 + ",errMsg:" + str2);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                TroopCreateServiceImpl.this.lambda$inviteToGroupWithNonFriends$6(str, z16, i3, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$inviteToGroupWithNonFriends$8(final String str, final b bVar, List list, List list2, Map map) {
        if (map.size() == 0) {
            onInviteComplete(str, false, -1);
            QLog.e(TAG, 1, "[inviteToGroupWithNonFriends] uidList is empty!");
            bVar.a();
            return;
        }
        if (map.size() != list.size()) {
            QLog.e(TAG, 1, "[inviteToGroupWithNonFriends] uinSize:" + list.size() + ", uidSize:" + map.size());
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            TroopCreateInfo.a aVar = (TroopCreateInfo.a) it.next();
            aVar.f294788b = (String) map.get(aVar.f294787a);
        }
        ((ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class)).inviteMembersToGroup(str, list2, null, TAG, new com.tencent.qqnt.troop.i() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.b
            @Override // com.tencent.qqnt.troop.i
            public final void onResult(boolean z16, int i3, String str2) {
                TroopCreateServiceImpl.this.lambda$inviteToGroupWithNonFriends$7(str, bVar, z16, i3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetTroopCreate$4(String str, TroopInfo troopInfo, int i3) {
        int i16;
        int i17;
        TroopInfoRepo.INSTANCE.fetchTroopBasicInfoWithExt(str, TAG, null, null);
        TroopListRepo.INSTANCE.fetchTroopLevelInfo(str, true);
        TroopInfo findTroopInfo = ((ITroopInfoService) this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo == null) {
            findTroopInfo = troopInfo;
        }
        com.tencent.qqnt.inner.compator.troopinfo.b bVar = new com.tencent.qqnt.inner.compator.troopinfo.b();
        bVar.c(findTroopInfo);
        TroopCreateInfo troopCreateInfo = this.mTroopCreateInfo;
        findTroopInfo.dwGroupClassExt = troopCreateInfo.classify;
        findTroopInfo.mRichFingerMemo = com.tencent.mobileqq.troop.util.a.c(troopCreateInfo.introduction);
        String[] split = this.mTroopCreateInfo.location.split("\\|");
        if (split.length == 4) {
            i17 = (int) (Float.valueOf(split[1]).floatValue() * 1000000.0f);
            i16 = (int) (Float.valueOf(split[2]).floatValue() * 1000000.0f);
        } else {
            i16 = 0;
            i17 = 0;
        }
        findTroopInfo.troopLat = i17;
        findTroopInfo.troopLon = i16;
        findTroopInfo.isNewTroop = true;
        findTroopInfo.hasSetNewTroopHead = false;
        findTroopInfo.hasSetNewTroopName = false;
        findTroopInfo.wMemberNum = i3;
        findTroopInfo.setMemberNumClient(i3);
        findTroopInfo.troopowneruin = this.mApp.getCurrentAccountUin();
        findTroopInfo.troopCreateTime = System.currentTimeMillis() / 1000;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetTroopCreate memberNumClient:" + findTroopInfo.getMemberNumClient() + "  wMemberNum:" + findTroopInfo.wMemberNum + " troopUin:" + findTroopInfo.troopuin);
        }
        troopInfo.memberRole = MemberRole.OWNER;
        bVar.b(findTroopInfo).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onGetTroopCreate$5(int i3, String str) {
        jumpToAioAfterInvited();
        ITroopCreateInfoService.a aVar = this.mCreateCallback;
        if (aVar != null) {
            aVar.onCreateTroopCompletely(i3, str, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startCreateTroop$3(final boolean z16, final int i3, final String str, final String str2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.h
            @Override // java.lang.Runnable
            public final void run() {
                TroopCreateServiceImpl.this.lambda$startCreateTroop$2(z16, i3, str, str2);
            }
        });
    }

    private void onInviteComplete(String str, boolean z16, int i3) {
        QLog.i(TAG, 1, "[onInviteComplete] result:" + i3 + ",isSuccess:" + z16);
        if (z16) {
            ITroopCreateInfoService.a aVar = this.mCreateCallback;
            if (aVar != null) {
                aVar.onInviteComplete(0, str);
            }
            ((ITroopCreateGrayMsg) this.mApp.getRuntimeService(ITroopCreateGrayMsg.class, "")).addCreateNewTroopGrayTips(str, true, "");
            ((ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class)).fetchNewTroopHeadUinList(str);
            return;
        }
        ITroopCreateInfoService.a aVar2 = this.mCreateCallback;
        if (aVar2 != null) {
            aVar2.onInviteComplete(i3, "");
            this.mCreateCallback = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startCreateTroop, reason: merged with bridge method [inline-methods] */
    public void lambda$createTroop$0(Activity activity) {
        QLog.i(TAG, 1, "[startCreateTroop] ");
        com.tencent.qqnt.bean.a aVar = new com.tencent.qqnt.bean.a();
        aVar.a(this.mTroopCreateInfo);
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).createGroupV2(aVar, null, TAG, new WeakReference<>(activity), new com.tencent.qqnt.troop.b() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.g
            @Override // com.tencent.qqnt.troop.b
            public final void a(boolean z16, int i3, String str, String str2) {
                TroopCreateServiceImpl.this.lambda$startCreateTroop$3(z16, i3, str, str2);
            }
        });
        com.tencent.mobileqq.troop.troopcreate.a.j(activity, HardCodeUtil.qqStr(R.string.udh));
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void createTroop(ITroopCreateInfoService.a aVar, final Activity activity, List<TroopCreateInfo.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, aVar, activity, list);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f171139ci4, 0).show();
            terminateLogic();
            return;
        }
        QLog.i(TAG, 1, "[createTroop] start");
        if (this.mTroopCreateInfo == null) {
            terminateLogic();
            return;
        }
        if (list != null) {
            com.tencent.mobileqq.troop.troopcreate.a.b(this.mApp, list);
            if (list.size() > 0) {
                TroopCreateInfo troopCreateInfo = this.mTroopCreateInfo;
                if (troopCreateInfo.inviteMembers != list) {
                    troopCreateInfo.inviteMembers = Collections.synchronizedList(list);
                }
            }
        }
        this.mCreateCallback = aVar;
        final HashMap hashMap = new HashMap();
        final ArrayList arrayList = new ArrayList();
        for (TroopCreateInfo.a aVar2 : this.mTroopCreateInfo.inviteMembers) {
            if (TextUtils.isEmpty(aVar2.f294788b)) {
                arrayList.add(aVar2.f294787a);
                hashMap.put(aVar2.f294787a, aVar2);
            }
        }
        if (!arrayList.isEmpty()) {
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).fetchUin2UidMap(arrayList, true, true, new IRelationNTUinAndUidApi.c() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.f
                @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.c
                public final void a(Map map) {
                    TroopCreateServiceImpl.this.lambda$createTroop$1(arrayList, hashMap, activity, map);
                }
            });
        } else {
            lambda$createTroop$0(activity);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void jumpToAioAfterCreated(String str, String str2, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, str, str2, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        QLog.i(TAG, 1, "jumpToAioAfterCreated: createScene=" + this.mTroopCreateInfo.createScene + ", isReuse=" + z16 + ", fromWebCreation=" + z17);
        if (!TextUtils.isEmpty(this.mTroopCreateInfo.createScene) && !"".equals(this.mTroopCreateInfo.createScene)) {
            SimpleEventBus.getInstance().dispatchEvent(new TroopCreateDoneEvent(z16));
        } else {
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = BaseApplication.getContext();
            }
            if (str2 == null) {
                str2 = this.mTroopCreateInfo.name;
            }
            com.tencent.mobileqq.troop.troopcreate.a.h(context, str, str2, z17);
        }
        TroopCreateInfo.b bVar = this.mTroopCreateInfo.sceneCallback;
        if (bVar != null) {
            bVar.a(str, z16);
            this.mTroopCreateInfo.sceneCallback = null;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime instanceof AppInterface) {
            this.mApp = (AppInterface) appRuntime;
        } else {
            this.mApp = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        ITroopCreateInfoService iTroopCreateInfoService = (ITroopCreateInfoService) this.mApp.getRuntimeService(ITroopCreateInfoService.class, "");
        this.mTroopCreateInfoService = iTroopCreateInfoService;
        this.mTroopCreateInfo = iTroopCreateInfoService.getTroopCreateInfo();
        this.mApp.addObserver(this.mTroopInfoObserver);
        QLog.i(TAG, 1, "onCreate");
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            terminateLogic();
            this.mApp.removeObserver(this.mTroopInfoObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: onGetTroopCreate, reason: merged with bridge method [inline-methods] */
    public void lambda$startCreateTroop$2(boolean z16, int i3, String str, String str2) {
        final int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
            return;
        }
        if (this.mCreateCallback == null) {
            com.tencent.mobileqq.troop.troopcreate.a.e();
            return;
        }
        if (!z16) {
            QLog.i(TAG, 1, "onGetTroopCreate retCode:" + i3 + "  currentUin:" + this.mApp.getCurrentUin());
            com.tencent.mobileqq.troop.troopcreate.a.e();
            this.mCreateCallback.onCreateTroopCompletely(i3, "", str);
            return;
        }
        final TroopInfo troopInfo = new TroopInfo(str2);
        final String str3 = troopInfo.troopuin;
        if (TextUtils.isEmpty(str3)) {
            QLog.i(TAG, 1, "onGetTroopCreate troopUin:" + str3);
            com.tencent.mobileqq.troop.troopcreate.a.e();
            this.mCreateCallback.onCreateTroopCompletely(-1, "", null);
            this.mCreateCallback = null;
            return;
        }
        this.mTroopCreateInfo.troopUin = str3;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", "ev_group_create");
        hashMap.put("eid", "ev_group_create");
        hashMap.put("group_id", str3);
        hashMap.put("group_owner_uin", this.mApp.getCurrentAccountUin());
        hashMap.put("group_first_level", "0");
        hashMap.put("group_second_level", "0");
        hashMap.put("source", Integer.valueOf(this.mTroopCreateInfo.newCreateFrom));
        VideoReport.reportEvent("ev_group_create", hashMap);
        ReportController.o(this.mApp, "P_CliOper", "Grp_create", "", "new_create", "number", 0, 0, str3, Integer.toString(this.mTroopCreateInfo.classify), "", "");
        List<TroopCreateInfo.a> list = this.mTroopCreateInfo.inviteMembers;
        if (list == null) {
            size = 1;
        } else {
            size = list.size();
        }
        ReportController.o(this.mApp, "dc00899", "Grp_create_new", "", "suc_create", "person_create", 0, 0, str3, "" + this.mTroopCreateInfo.createFrom, "" + size, "");
        QLog.i(TAG, 1, "onGetTroopCreate success troopUin:" + str3 + " number:" + size + "  createFrom:" + this.mTroopCreateInfo.createFrom);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopCreateServiceImpl.this.lambda$onGetTroopCreate$4(str3, troopInfo, size);
            }
        }, 16, null, true);
        final int i16 = 0;
        inviteToGroupWithNonFriends(str3, this.mTroopCreateInfo.inviteMembers, new b() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.e
            @Override // com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.b
            public final void a() {
                TroopCreateServiceImpl.this.lambda$onGetTroopCreate$5(i16, str3);
            }
        });
        com.tencent.mobileqq.troop.troopcreate.a.e();
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void onReuseTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        ITroopCreateInfoService.a aVar = this.mCreateCallback;
        if (aVar != null) {
            aVar.onReusedTroop(str);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void releaseCreateCallback(ITroopCreateInfoService.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else if (this.mCreateCallback == aVar) {
            this.mCreateCallback = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void startCreateTroopSession(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            startCreateTroopSession(activity, i3, "DEFAULT");
        } else {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void terminateLogic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.troopcreate.a.e();
        this.mCreateCallback = null;
        TroopCreateInfo troopCreateInfo = this.mTroopCreateInfo;
        if (troopCreateInfo != null) {
            troopCreateInfo.reset();
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TROOP_CREATE, 2, "terminateLogic");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void startCreateTroopSession(Activity activity, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, Integer.valueOf(i3), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TROOP_CREATE, 2, "startCreateTroopSession: from=" + i3 + ", type=" + str);
        }
        terminateLogic();
        com.tencent.mobileqq.troop.troopcreate.a.f(activity);
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void startCreateTroop(ITroopCreateInfoService.a aVar, Activity activity, ArrayList<ResultRecord> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, aVar, activity, arrayList);
            return;
        }
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        QLog.i(TAG, 1, "[startCreateTroop] ");
        ArrayList arrayList2 = new ArrayList();
        Iterator<ResultRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            if (!next.uin.equals(this.mApp.getCurrentAccountUin())) {
                ITroopCreateService.a aVar2 = new ITroopCreateService.a();
                String str = next.name;
                aVar2.f299975d = str;
                aVar2.f299976e = ChnToSpell.d(str, 2);
                arrayList2.add(aVar2);
            }
        }
        Collections.sort(arrayList2);
        com.tencent.mobileqq.troop.troopcreate.a.a(this.mApp, arrayList);
        ITroopSearchService iTroopSearchService = (ITroopSearchService) this.mApp.getRuntimeService(ITroopSearchService.class, "");
        this.mCreateCallback = aVar;
        this.mTroopCreateInfo.inviteMembers = Collections.synchronizedList(com.tencent.mobileqq.troop.troopcreate.a.c(arrayList));
        com.tencent.mobileqq.troop.troopcreate.a.j(activity, HardCodeUtil.qqStr(R.string.udi));
        iTroopSearchService.search(arrayList, true, new ITroopSearchService.b(arrayList2, activity, aVar, arrayList) { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ArrayList f299983a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Activity f299984b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ ITroopCreateInfoService.a f299985c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f299986d;

            {
                this.f299983a = arrayList2;
                this.f299984b = activity;
                this.f299985c = aVar;
                this.f299986d = arrayList;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopCreateServiceImpl.this, arrayList2, activity, aVar, arrayList);
                }
            }

            @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService.b
            public void onResult(ArrayList<ITroopSearchService.a> arrayList3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) arrayList3);
                    return;
                }
                QLog.i(TroopCreateServiceImpl.TAG, 1, "[startCreateTroop onResult] ");
                if (arrayList3.size() > 0) {
                    ArrayList<String> arrayList4 = new ArrayList<>();
                    Iterator it5 = this.f299983a.iterator();
                    while (it5.hasNext()) {
                        arrayList4.add(((ITroopCreateService.a) it5.next()).f299975d);
                    }
                    TroopCreateServiceImpl.this.mTroopCreateInfo.disPlayTroopName = ((ITroopNameHelperService) TroopCreateServiceImpl.this.mApp.getRuntimeService(ITroopNameHelperService.class, "")).getNewName(arrayList4);
                    new Handler(Looper.getMainLooper()).post(new Runnable(arrayList3) { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ ArrayList f299988d;

                        {
                            this.f299988d = arrayList3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) arrayList3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            com.tencent.mobileqq.troop.troopcreate.a.e();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            com.tencent.mobileqq.troop.troopcreate.ui.b bVar = new com.tencent.mobileqq.troop.troopcreate.ui.b(anonymousClass1.f299984b, anonymousClass1.f299985c);
                            bVar.n0(this.f299988d);
                            bVar.show();
                        }
                    });
                    return;
                }
                TroopCreateServiceImpl.this.mApp.getHandler(ITroopSearchService.class).post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopcreate.api.impl.TroopCreateServiceImpl.1.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        } else {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            TroopCreateServiceImpl.this.createTroop(anonymousClass1.f299985c, anonymousClass1.f299984b, com.tencent.mobileqq.troop.troopcreate.a.c(anonymousClass1.f299986d));
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService
    public void createTroop(Activity activity, ITroopCreateInfoService.a aVar) {
        List<TroopCreateInfo.a> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) activity, (Object) aVar);
            return;
        }
        this.mCreateCallback = aVar;
        if (activity == null) {
            terminateLogic();
            return;
        }
        TroopCreateInfo troopCreateInfo = this.mTroopCreateInfo;
        if (troopCreateInfo != null && (list = troopCreateInfo.inviteMembers) != null && aVar != null) {
            createTroop(aVar, activity, list);
        } else {
            terminateLogic();
        }
    }
}
