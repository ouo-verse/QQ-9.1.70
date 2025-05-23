package com.tencent.mobileqq.guild.inbox.centerpanel.income;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.bo;
import vh2.bu;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\b\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000f\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u001c\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\rJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\rJ\u0006\u0010\u0013\u001a\u00020\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\rJ\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017R*\u0010\u001c\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00100\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u0002008F\u00a2\u0006\u0006\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/f;", "Lef1/b;", "", "isForce", "", "d2", "Lvh2/bu;", "b2", "com/tencent/mobileqq/guild/inbox/centerpanel/income/f$b", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/guild/inbox/centerpanel/income/f$b;", "initData", FeedManager.LOAD_MORE, "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "Lkotlin/collections/ArrayList;", "e2", "f2", "i2", "j2", "addListener", "removeListener", "", "value", "l2", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "mGuildIncomeLiveData", "D", "mIsLoadingLiveData", "E", "mIsNoDisturb", UserInfo.SEX_FEMALE, "mNotifyIncome", "G", "Z", "mIsEnd", "H", "I", "mNextPullOffset", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "mInboxRedService", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "J", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "mListener", "Landroidx/lifecycle/LiveData;", "g2", "()Landroidx/lifecycle/LiveData;", "notifyIncome", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends ef1.b {

    @NotNull
    private static final Comparator<co> L = new Comparator() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int k26;
            k26 = f.k2((co) obj, (co) obj2);
            return k26;
        }
    };

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<co>> mGuildIncomeLiveData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mIsLoadingLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mIsNoDisturb;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> mNotifyIncome;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsEnd;

    /* renamed from: H, reason: from kotlin metadata */
    private int mNextPullOffset;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IGuildInboxRedService mInboxRedService;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final IGuildInboxRedService.a mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/income/f$b", "Lvh2/bo;", "", "result", "", "errMsg", "", "needResetList", "listOffset", "isEnd", "", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "noticeList", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements bo {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // vh2.bo
        public void a(int result, @NotNull String errMsg, boolean needResetList, int listOffset, boolean isEnd, @NotNull List<? extends co> noticeList) {
            ArrayList<co> arrayList;
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(noticeList, "noticeList");
            boolean z16 = true;
            if (result == 0) {
                f.this.mIsEnd = isEnd;
                f.this.mNextPullOffset = listOffset;
                if (!noticeList.isEmpty() && (noticeList instanceof ArrayList)) {
                    arrayList = (ArrayList) noticeList;
                } else {
                    arrayList = new ArrayList();
                }
                ArrayList arrayList2 = (ArrayList) f.this.mGuildIncomeLiveData.getValue();
                if (!needResetList) {
                    if (arrayList2 != null && !arrayList2.isEmpty()) {
                        z16 = false;
                    }
                    if (!z16) {
                        if (!arrayList2.containsAll(arrayList)) {
                            for (co coVar : arrayList) {
                                if (!arrayList2.contains(coVar)) {
                                    arrayList2.add(coVar);
                                }
                            }
                            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, f.L);
                            f.this.mGuildIncomeLiveData.setValue(arrayList2);
                        }
                        f.this.mIsLoadingLiveData.setValue(Boolean.FALSE);
                        Logger logger = Logger.f235387a;
                        if (QLog.isColorLevel()) {
                            logger.d().d("Guild.C2C.GuildIncomeNoticeViewModel", 2, "onGetMoreGuildNoticeList needResetList=" + needResetList + " listOffset=" + listOffset + " isEnd=" + isEnd + " data size=" + arrayList2.size());
                            return;
                        }
                        return;
                    }
                }
                CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, f.L);
                f.this.mGuildIncomeLiveData.setValue(arrayList);
                f.this.mIsLoadingLiveData.setValue(Boolean.FALSE);
                Logger logger2 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger2.d().d("Guild.C2C.GuildIncomeNoticeViewModel", 2, "onGetMoreGuildNoticeList needResetList=" + needResetList + " listOffset=" + listOffset + " isEnd=" + isEnd + " data size=" + arrayList.size());
                    return;
                }
                return;
            }
            Logger logger3 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "getMoreHelperNoticeList error, nResult" + result + ", errMsg" + errMsg;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.C2C.GuildIncomeNoticeViewModel", 1, (String) it.next(), null);
            }
            f.this.mIsLoadingLiveData.setValue(Boolean.FALSE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/income/f$c", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$b;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cq;", "redPointList", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends IGuildInboxRedService.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.b, com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void b(@NotNull List<? extends cq> redPointList) {
            boolean z16;
            Intrinsics.checkNotNullParameter(redPointList, "redPointList");
            if (QLog.isColorLevel()) {
                QLog.d("Guild.C2C.GuildIncomeNoticeViewModel", 1, "onNoticeGroupListUpdate " + redPointList);
            }
            for (cq cqVar : redPointList) {
                if (cqVar.f265931a == 5) {
                    MutableLiveData mutableLiveData = f.this.mIsNoDisturb;
                    if (cqVar.f265934d != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    mutableLiveData.setValue(Boolean.valueOf(z16));
                }
            }
        }
    }

    public f() {
        Boolean bool = Boolean.FALSE;
        this.mIsLoadingLiveData = new MutableLiveData<>(bool);
        this.mIsNoDisturb = new MutableLiveData<>(bool);
        this.mNotifyIncome = new MutableLiveData<>(Boolean.TRUE);
        IRuntimeService S0 = ch.S0(IGuildInboxRedService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.mInboxRedService = (IGuildInboxRedService) S0;
        this.mListener = new c();
    }

    private final b a2() {
        return new b();
    }

    private final bu b2() {
        return new bu() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.d
            @Override // vh2.bu
            public final void a(int i3, String str, int i16, boolean z16, int i17, List list) {
                f.c2(f.this, i3, str, i16, z16, i17, list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(f this$0, int i3, String str, int i16, boolean z16, int i17, List list) {
        boolean z17;
        ArrayList<co> arrayList;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildIncomeNoticeViewModel", 2, "initGetHelperNoticeList error, nRefreshResult" + i3 + ", refreshErrMsg" + str);
            }
        }
        this$0.mIsEnd = z16;
        this$0.mNextPullOffset = i16;
        List list2 = list;
        boolean z18 = false;
        if (list2 != null && !list2.isEmpty()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17 && (list instanceof ArrayList)) {
            arrayList = (ArrayList) list;
        } else {
            arrayList = new ArrayList<>();
        }
        ArrayList<co> value = this$0.mGuildIncomeLiveData.getValue();
        if (value == null || value.isEmpty()) {
            z18 = true;
        }
        if (z18 || !value.containsAll(arrayList)) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, L);
            this$0.mGuildIncomeLiveData.setValue(arrayList);
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.C2C.GuildIncomeNoticeViewModel", 2, "onInitGetGuildNoticeList list update");
            }
        }
        this$0.mIsLoadingLiveData.setValue(Boolean.FALSE);
        Logger logger3 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger3.d().d("Guild.C2C.GuildIncomeNoticeViewModel", 2, "onInitGetGuildNoticeList listOffset=" + i16 + " isEnd=" + z16 + " data size=" + arrayList.size());
        }
    }

    private final void d2(boolean isForce) {
        ((IGPSService) ch.R0(IGPSService.class)).initGetNoticeList(5, "", isForce, b2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(f this$0, int i3, String str, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Integer num = (Integer) hashMap.get(101);
        boolean z16 = true;
        if (i3 == 0 && num != null) {
            QLog.i("Guild.C2C.GuildIncomeNoticeViewModel", 2, "getGuildHelperNotifySwitch success -- switchValue=" + num);
            MutableLiveData<Boolean> mutableLiveData = this$0.mNotifyIncome;
            if (num.intValue() != 0) {
                z16 = false;
            }
            mutableLiveData.postValue(Boolean.valueOf(z16));
            return;
        }
        QLog.e("Guild.C2C.GuildIncomeNoticeViewModel", 1, "getGuildHelperNotifySwitch err:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k2(co coVar, co coVar2) {
        return (int) (coVar2.f265887c - coVar.f265887c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(f this$0, int i3, int i16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d("Guild.C2C.GuildIncomeNoticeViewModel", 1, "res " + i16 + ", err " + str);
        if (i16 == 0) {
            MutableLiveData<Boolean> mutableLiveData = this$0.mNotifyIncome;
            if (i3 != 0) {
                z16 = false;
            }
            mutableLiveData.postValue(Boolean.valueOf(z16));
        }
    }

    public final void addListener() {
        this.mInboxRedService.addNoticeRedUpdateListener(this.mListener);
    }

    @NotNull
    public final MutableLiveData<ArrayList<co>> e2() {
        return this.mGuildIncomeLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> f2() {
        return this.mIsLoadingLiveData;
    }

    @NotNull
    public final LiveData<Boolean> g2() {
        return this.mNotifyIncome;
    }

    /* renamed from: i2, reason: from getter */
    public final boolean getMIsEnd() {
        return this.mIsEnd;
    }

    public final void initData() {
        boolean z16;
        AppInterface appInterface;
        uh2.c gProGuildMsgService;
        boolean z17 = false;
        this.mNextPullOffset = 0;
        cq noticeRedPoint = this.mInboxRedService.getNoticeRedPoint(5);
        Intrinsics.checkNotNullExpressionValue(noticeRedPoint, "mInboxRedService.getNoti\u2026nt(INoticeMsgType.INCOME)");
        ArrayList<co> value = this.mGuildIncomeLiveData.getValue();
        if (value != null && !value.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || noticeRedPoint.f265932b > 0) {
            z17 = true;
        }
        d2(z17);
        this.mIsNoDisturb.setValue(Boolean.valueOf(noticeRedPoint.a()));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        if (iGProSession != null && (gProGuildMsgService = iGProSession.getGProGuildMsgService()) != null) {
            gProGuildMsgService.getGuildHelperNotifySwitch(new IGuildHelperNotifySwitchOperateCallback() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildHelperNotifySwitchOperateCallback
                public final void onResult(int i3, String str, HashMap hashMap) {
                    f.h2(f.this, i3, str, hashMap);
                }
            });
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildIncomeNoticeViewModel", 2, "initData");
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> j2() {
        return this.mIsNoDisturb;
    }

    public final void l2(final int value) {
        AppInterface appInterface;
        uh2.c gProGuildMsgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProSession.class, "");
        }
        IGProSession iGProSession = (IGProSession) iRuntimeService;
        if (iGProSession != null && (gProGuildMsgService = iGProSession.getGProGuildMsgService()) != null) {
            gProGuildMsgService.setGuildHelperNotifySwitch(101, value, new IGuildOperateCallback() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.income.e
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildOperateCallback
                public final void onResult(int i3, String str) {
                    f.m2(f.this, value, i3, str);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void loadMore() {
        Integer num;
        Boolean value = this.mIsLoadingLiveData.getValue();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(value, bool)) {
            return;
        }
        this.mIsLoadingLiveData.setValue(bool);
        ((IGPSService) ch.R0(IGPSService.class)).getMoreNoticeList(5, "", this.mNextPullOffset, a2());
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            int i3 = this.mNextPullOffset;
            ArrayList arrayList = (ArrayList) this.mGuildIncomeLiveData.getValue();
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            d16.d("Guild.C2C.GuildIncomeNoticeViewModel", 2, "getMoreHelperNoticeList begin Offset=" + i3 + ", size=" + num);
        }
    }

    public final void removeListener() {
        this.mInboxRedService.removeNoticeRedUpdateListener(this.mListener);
    }
}
