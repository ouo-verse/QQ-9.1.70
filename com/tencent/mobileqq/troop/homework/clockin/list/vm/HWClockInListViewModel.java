package com.tencent.mobileqq.troop.homework.clockin.list.vm;

import android.os.Bundle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.list.event.HWClockInListUpdateEvent;
import com.tencent.mobileqq.troop.homework.clockin.list.vm.a;
import com.tencent.mobileqq.troop.homework.clockin.list.vm.b;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeUtils;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskListCallback;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskRsp;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001?B\u000f\u0012\u0006\u0010;\u001a\u00020:\u00a2\u0006\u0004\b<\u0010=J\b\u0010\b\u001a\u00020\u0007H\u0002J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u001cH\u0016J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001f0\u001eH\u0016J\b\u0010!\u001a\u00020\u0007H\u0014R\u001a\u0010&\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00130,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/HWClockInListViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskListCallback;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "O1", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskRsp;", "rsp", "", "troopNameListStr", "T1", "clockInId", "S1", "", "Lcom/tencent/mobileqq/troop/homework/clockin/list/data/a;", "N1", "userIntent", "R1", "event", "onReceiveEvent", "", "errCode", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskListRsp;", "onResult", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/b;", "P1", "()Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/b;", "mNoneValueIntent", "D", "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "troopUin", "", "E", "Ljava/util/List;", "clockInList", "", UserInfo.SEX_FEMALE, "Z", "isRequesting", "G", "isEnd", "", "H", "J", "pageTime", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "I", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInListViewModel extends BaseViewModel<a, b> implements IGetGroupSchoolTaskListCallback, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mNoneValueIntent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.homework.clockin.list.data.a> clockInList;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isEnd;

    /* renamed from: H, reason: from kotlin metadata */
    private long pageTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/list/vm/HWClockInListViewModel$a;", "", "", "PAGE_SIZE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.list.vm.HWClockInListViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43182);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInListViewModel(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.mNoneValueIntent = b.C8713b.f296458a;
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWClockInArgKey.TROOP_UIN, \"\")");
        this.troopUin = string;
        this.clockInList = new ArrayList();
        SimpleEventBus.getInstance().registerReceiver(this);
        HWNoticeUtils.a(string, true, AnonymousClass1.INSTANCE);
    }

    private final List<com.tencent.mobileqq.troop.homework.clockin.list.data.a> N1() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.tencent.mobileqq.troop.homework.clockin.list.data.a> it = this.clockInList.iterator();
        while (it.hasNext()) {
            arrayList.add(com.tencent.mobileqq.troop.homework.clockin.list.data.a.b(it.next(), 0L, null, null, null, null, null, null, null, 255, null));
        }
        return arrayList;
    }

    private final void O1() {
        Long longOrNull;
        long j3;
        if (!this.isEnd && !this.isRequesting) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.troopUin);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            GroupSchoolTaskListReq groupSchoolTaskListReq = new GroupSchoolTaskListReq(j3, this.pageTime, 30);
            r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
            if (groupSchoolService != null) {
                groupSchoolService.getGroupSchoolTaskList(groupSchoolTaskListReq, this);
            }
        }
    }

    private final void S1(String clockInId) {
        Iterator<com.tencent.mobileqq.troop.homework.clockin.list.data.a> it = this.clockInList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (Intrinsics.areEqual(it.next().c(), clockInId)) {
                it.remove();
                break;
            }
        }
        obtainUiState().setValue(new a.C8712a(N1(), this.isEnd));
    }

    private final void T1(PublishGroupSchoolTaskReq req, PublishGroupSchoolTaskRsp rsp, String troopNameListStr) {
        com.tencent.mobileqq.troop.homework.clockin.list.data.a aVar = new com.tencent.mobileqq.troop.homework.clockin.list.data.a(0L, null, null, null, null, null, null, null, 255, null);
        aVar.o(req, rsp, troopNameListStr);
        this.clockInList.add(0, aVar);
        obtainUiState().setValue(new a.C8712a(N1(), this.isEnd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(SimpleBaseEvent simpleBaseEvent, HWClockInListViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (simpleBaseEvent instanceof HWClockInListUpdateEvent.ClockInPublished) {
            HWClockInListUpdateEvent.ClockInPublished clockInPublished = (HWClockInListUpdateEvent.ClockInPublished) simpleBaseEvent;
            this$0.T1(clockInPublished.getReq(), clockInPublished.getRsp(), clockInPublished.getTroopNameListStr());
        } else if (simpleBaseEvent instanceof HWClockInListUpdateEvent.ClockInDeleted) {
            this$0.S1(((HWClockInListUpdateEvent.ClockInDeleted) simpleBaseEvent).getClockInId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(int i3, GroupSchoolTaskListRsp groupSchoolTaskListRsp, HWClockInListViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (groupSchoolTaskListRsp != null) {
                Iterator<GroupSchoolTaskData> it = groupSchoolTaskListRsp.datas.iterator();
                long j3 = 0;
                while (it.hasNext()) {
                    GroupSchoolTaskData data = it.next();
                    List<com.tencent.mobileqq.troop.homework.clockin.list.data.a> list = this$0.clockInList;
                    com.tencent.mobileqq.troop.homework.clockin.list.data.a aVar = new com.tencent.mobileqq.troop.homework.clockin.list.data.a(0L, null, null, null, null, null, null, null, 255, null);
                    Intrinsics.checkNotNullExpressionValue(data, "data");
                    aVar.n(data);
                    list.add(aVar);
                    j3 = data.publishTime;
                }
                this$0.isEnd = groupSchoolTaskListRsp.isEnd;
                this$0.pageTime = j3;
                this$0.obtainUiState().setValue(new a.C8712a(this$0.N1(), this$0.isEnd));
            }
        } else {
            String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(i3);
            if (a16 == null) {
                a16 = "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
            }
            QQToastUtil.showQQToastInUiThread(1, a16);
            this$0.obtainUiState().setValue(new a.b(i3));
        }
        this$0.isRequesting = false;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: P1, reason: merged with bridge method [inline-methods] */
    public b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @NotNull
    public final String Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: R1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (Intrinsics.areEqual(userIntent, b.a.f296457a)) {
            O1();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWClockInListUpdateEvent.ClockInPublished.class, HWClockInListUpdateEvent.ClockInDeleted.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onCleared();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
        } else {
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.clockin.list.vm.d
                @Override // java.lang.Runnable
                public final void run() {
                    HWClockInListViewModel.U1(SimpleBaseEvent.this, this);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskListCallback
    public void onResult(final int errCode, @Nullable String errMsg, @Nullable final GroupSchoolTaskListRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(errCode), errMsg, rsp);
        } else {
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.clockin.list.vm.c
                @Override // java.lang.Runnable
                public final void run() {
                    HWClockInListViewModel.W1(errCode, rsp, this);
                }
            });
        }
    }
}
