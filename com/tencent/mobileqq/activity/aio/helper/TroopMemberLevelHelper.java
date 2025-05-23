package com.tencent.mobileqq.activity.aio.helper;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.helper.TroopMemberLevelHelper;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberSpecialTitleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberLevelService;
import com.tencent.mobileqq.troop.uniquetitle.api.IUniqueTitleService;
import com.tencent.mobileqq.troop.utils.bf;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtInfoRepoApi;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.state.utils.TimeFormatUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001\"\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0011H\u0016R\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/TroopMemberLevelHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", tl.h.F, "Lmqq/app/AppRuntime;", "appRuntime", DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "troopMemberList", "o", "titleInfoList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "info", "", "g", "j", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "mTroopUin", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "com/tencent/mobileqq/activity/aio/helper/TroopMemberLevelHelper$mTroopObserver$1", "f", "Lcom/tencent/mobileqq/activity/aio/helper/TroopMemberLevelHelper$mTroopObserver$1;", "mTroopObserver", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class TroopMemberLevelHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopMemberLevelHelper$mTroopObserver$1 mTroopObserver = new com.tencent.mobileqq.troop.api.observer.e() { // from class: com.tencent.mobileqq.activity.aio.helper.TroopMemberLevelHelper$mTroopObserver$1
        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopMemberLevelGlobalChanged(boolean isSuccess) {
            if (isSuccess) {
                ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(com.tencent.qqnt.bus.event.m.f353225a);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onTroopMemberLevelInfoChanged(boolean isSuccess, @Nullable String troopUin) {
            com.tencent.aio.api.runtime.a aVar;
            if (troopUin != null) {
                aVar = TroopMemberLevelHelper.this.mAIOContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    aVar = null;
                }
                if (!Intrinsics.areEqual(troopUin, aVar.g().r().c().j())) {
                    troopUin = null;
                }
                if (troopUin != null) {
                    ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new com.tencent.qqnt.bus.event.l(troopUin));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.troop.api.observer.e
        public void onTroopMemberLevelSingleChanged(boolean isSuccess, @Nullable String troopUin, @Nullable String memberUin) {
            boolean z16;
            com.tencent.aio.api.runtime.a aVar;
            super.onTroopMemberLevelSingleChanged(isSuccess, troopUin, memberUin);
            boolean z17 = false;
            if (troopUin != null && troopUin.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                if (memberUin == null || memberUin.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    aVar = TroopMemberLevelHelper.this.mAIOContext;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                        aVar = null;
                    }
                    LifecycleOwner d16 = aVar.d();
                    Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
                    CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "TroopMemberLevelHelperonTroopMemberLevelSingleChanged", Boolean.FALSE, null, null, new TroopMemberLevelHelper$mTroopObserver$1$onTroopMemberLevelSingleChanged$1(troopUin, memberUin, null), 12, null);
                }
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onUpdateTroopList(boolean isSuccess) {
            ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(com.tencent.qqnt.bus.event.m.f353225a);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002<\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ\u001f\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/activity/aio/helper/TroopMemberLevelHelper$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberSpecialTitleInfo;", "titleInfoList", "", "Lcom/tencent/qqnt/troopmemberlist/FetchTroopMemberSpecialTitleInfoCallback;", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements Function2<Boolean, List<? extends TroopMemberSpecialTitleInfo>, Unit> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(TroopMemberLevelHelper this$0, List titleInfoList) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(titleInfoList, "$titleInfoList");
            this$0.m(titleInfoList);
        }

        public void b(boolean isSuccess, @NotNull final List<TroopMemberSpecialTitleInfo> titleInfoList) {
            Intrinsics.checkNotNullParameter(titleInfoList, "titleInfoList");
            if (isSuccess) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                final TroopMemberLevelHelper troopMemberLevelHelper = TroopMemberLevelHelper.this;
                uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.at
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopMemberLevelHelper.b.c(TroopMemberLevelHelper.this, titleInfoList);
                    }
                });
                return;
            }
            QLog.e("TroopMemberLevelHelper", 2, "updateTroopMemberUniqueTitle: fetch false");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends TroopMemberSpecialTitleInfo> list) {
            b(bool.booleanValue(), list);
            return Unit.INSTANCE;
        }
    }

    private final String g(TroopMemberSpecialTitleInfo info) {
        int expireTimeSec = (((int) (info.getExpireTimeSec() - NetConnInfoCenter.getServerTime())) / 86400) + 1;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[7];
        objArr[0] = info.getFriendNick();
        objArr[1] = info.getUin();
        objArr[2] = info.getSpecialTitle();
        objArr[3] = Integer.valueOf(expireTimeSec);
        String str = this.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        objArr[4] = str;
        objArr[5] = info.getSpecialTitle();
        objArr[6] = Integer.valueOf(info.getExpireTimeSec());
        String format = String.format("<{\"text\":\"%1$s\", \"cmd\": \"5\", \"data\":\"%2$s\"}>\u4e13\u5c5e\u5934\u8854\"%3$s\"\u5c06\u5728%4$d\u5929\u540e\u5230\u671f\uff0c<{\"text\":\"\u70b9\u51fb\u7eed\u671f\", \"cmd\": \"3\", \"data_a\":\"mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.troop.EditUniqueTitleActivity&troopUin=%5$s&memberUin=%2$s&uniqueTitle=%6$s&uniqueTitleExpire=%7$d&from=2\"}>", Arrays.copyOf(objArr, 7));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final void h() {
        AppInterface appInterface;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(this.mTroopObserver);
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        String str2 = this.mTroopUin;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str2 = null;
        }
        TroopInfo findTroopInfo = iTroopInfoService.findTroopInfo(str2);
        if (findTroopInfo == null) {
            return;
        }
        if (findTroopInfo.isTroopOwner(peekAppRuntime.getCurrentAccountUin())) {
            long serverTime = NetConnInfoCenter.getServerTime();
            IUniqueTitleService iUniqueTitleService = (IUniqueTitleService) peekAppRuntime.getRuntimeService(IUniqueTitleService.class, "");
            String str3 = this.mTroopUin;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                str3 = null;
            }
            long oldestUniqueTitleExpireTime = iUniqueTitleService.getOldestUniqueTitleExpireTime(str3);
            final long j3 = oldestUniqueTitleExpireTime - serverTime;
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberLevelHelper", 2, "onLifeCycleCreate: expireTime=" + oldestUniqueTitleExpireTime + ", remainTime=" + j3 + ", soon_time=259200");
            }
            if (j3 < 259200) {
                TroopMemberListRepo troopMemberListRepo = TroopMemberListRepo.INSTANCE;
                String str4 = this.mTroopUin;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                    str = null;
                } else {
                    str = str4;
                }
                com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar = aVar2;
                }
                troopMemberListRepo.fetchTroopMemberList(str, aVar.d(), false, "TroopMemberLevelHelper", new com.tencent.qqnt.troopmemberlist.f() { // from class: com.tencent.mobileqq.activity.aio.helper.ar
                    @Override // com.tencent.qqnt.troopmemberlist.f
                    public final void a(boolean z16, List list) {
                        TroopMemberLevelHelper.i(j3, this, z16, list);
                    }
                });
            }
        }
        n(peekAppRuntime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(long j3, TroopMemberLevelHelper this$0, boolean z16, List troopMemberList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        ArrayList arrayList = new ArrayList();
        Iterator it = troopMemberList.iterator();
        while (it.hasNext()) {
            TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = ((TroopMemberInfo) it.next()).specialTitleInfo;
            if (troopMemberSpecialTitleInfo != null) {
                arrayList.add(troopMemberSpecialTitleInfo);
            }
        }
        if (j3 <= 0) {
            this$0.o(arrayList);
        } else {
            this$0.m(arrayList);
        }
    }

    private final void j() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.mTroopObserver);
        }
        ((ITroopMemberLevelService) peekAppRuntime.getRuntimeService(ITroopMemberLevelService.class, "")).clearNeedRefreshTroopFlag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TroopMemberLevelHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(List<TroopMemberSpecialTitleInfo> titleInfoList) {
        TroopManager troopManager;
        TroopManager troopManager2;
        TroopManager troopManager3;
        long j3;
        String str;
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER);
        if (manager instanceof TroopManager) {
            troopManager = (TroopManager) manager;
        } else {
            troopManager = null;
        }
        if (troopManager == null) {
            return;
        }
        long serverTime = NetConnInfoCenter.getServerTime() + TimeFormatUtils.ONE_MONTH;
        long j16 = serverTime;
        for (TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo : titleInfoList) {
            if (troopMemberSpecialTitleInfo.isExpiredSoon()) {
                String str3 = this.mTroopUin;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                    str3 = null;
                }
                if (!troopManager.O(str3, troopMemberSpecialTitleInfo.getUin())) {
                    Manager manager2 = peekAppRuntime.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
                    Intrinsics.checkNotNull(manager2, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr");
                    bf bfVar = (bf) manager2;
                    String str4 = this.mTroopUin;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                        str = null;
                    } else {
                        str = str4;
                    }
                    bfVar.g(str, g(troopMemberSpecialTitleInfo), NetConnInfoCenter.getServerTime(), troopMemberSpecialTitleInfo.getExpireTimeSec(), 0, 1);
                    String str5 = this.mTroopUin;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                        str5 = null;
                    }
                    troopManager.z0(str5, troopMemberSpecialTitleInfo.getUin(), true);
                    String str6 = this.mTroopUin;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                        str2 = null;
                    } else {
                        str2 = str6;
                    }
                    troopManager3 = troopManager;
                    j3 = j16;
                    ReportController.o(peekAppRuntime, "P_CliOper", "Grp_manage", "", "grp_aio", "exp_expire", 0, 0, str2, "", "", "");
                    j16 = j3;
                    troopManager = troopManager3;
                }
            }
            troopManager3 = troopManager;
            j3 = j16;
            if (troopMemberSpecialTitleInfo.getExpireTimeSec() != 0 && troopMemberSpecialTitleInfo.getExpireTimeSec() != -1 && troopMemberSpecialTitleInfo.getExpireTimeSec() < j3) {
                j16 = troopMemberSpecialTitleInfo.getExpireTimeSec();
                troopManager = troopManager3;
            }
            j16 = j3;
            troopManager = troopManager3;
        }
        TroopManager troopManager4 = troopManager;
        long j17 = j16;
        String str7 = this.mTroopUin;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            troopManager2 = troopManager4;
            str7 = null;
        } else {
            troopManager2 = troopManager4;
        }
        troopManager2.n0(str7, j17);
    }

    private final void n(AppRuntime appRuntime) {
        IRuntimeService runtimeService = appRuntime.getRuntimeService(ITroopMemberLevelService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        if (((ITroopMemberLevelService) runtimeService).isNeedRefreshTroopAIO()) {
            IBusManager iBusManager = (IBusManager) QRoute.api(IBusManager.class);
            String str = this.mTroopUin;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                str = null;
            }
            iBusManager.sendEvent(new com.tencent.qqnt.bus.event.l(str));
        }
    }

    private final void o(List<TroopMemberSpecialTitleInfo> troopMemberList) {
        com.tencent.aio.api.runtime.a aVar;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = troopMemberList.iterator();
        while (true) {
            aVar = null;
            String str = null;
            if (!it.hasNext()) {
                break;
            }
            TroopMemberSpecialTitleInfo troopMemberSpecialTitleInfo = (TroopMemberSpecialTitleInfo) it.next();
            if (!troopMemberSpecialTitleInfo.isExpiredSoon()) {
                str = troopMemberSpecialTitleInfo.getUin();
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            ITroopMemberExtInfoRepoApi iTroopMemberExtInfoRepoApi = (ITroopMemberExtInfoRepoApi) QRoute.api(ITroopMemberExtInfoRepoApi.class);
            String str2 = this.mTroopUin;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                str2 = null;
            }
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            } else {
                aVar = aVar2;
            }
            iTroopMemberExtInfoRepoApi.fetchTroopMemberSpecialTitle(str2, arrayList, aVar.d(), new b());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.T;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopMemberLevelHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state == 12) {
                j();
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.helper.aq
            @Override // java.lang.Runnable
            public final void run() {
                TroopMemberLevelHelper.k(TroopMemberLevelHelper.this);
            }
        }, 16, null, false);
    }
}
