package com.tencent.mobileqq.troop.homework.notice.list.viewmodel;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.notice.HWNoticeCons$HWNoticeListType;
import com.tencent.mobileqq.troop.homework.notice.list.event.HWNoticeListUpdateEvent;
import com.tencent.mobileqq.troop.homework.notice.list.event.a;
import com.tencent.mobileqq.troop.homework.notice.list.event.b;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeListReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeData;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeIndex;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 52\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001?B\u0017\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010*\u001a\u00020\t\u00a2\u0006\u0004\b=\u0010>J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060!0 H\u0016J\b\u0010#\u001a\u00020\u0007H\u0014R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001a\u0010/\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u0013008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/viewmodel/c;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/a;", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeListCallback;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "P1", "", "noticeId", "R1", "S1", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeReq;", "noticeReq", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeRsp;", "noticeRsp", "T1", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeData;", "noticeList", "N1", "userIntent", "Q1", "event", "onReceiveEvent", "", "errCode", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeListRsp;", "rsp", "onResult", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onCleared", "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;", "listType", "D", "Ljava/lang/String;", "troopUin", "E", "Lcom/tencent/mobileqq/troop/homework/notice/list/event/b;", "O1", "()Lcom/tencent/mobileqq/troop/homework/notice/list/event/b;", "mNoneValueIntent", "", UserInfo.SEX_FEMALE, "Ljava/util/List;", "", "G", "J", "lastPublishTime", "", "H", "Z", "isRequesting", "I", "isEnd", "<init>", "(Lcom/tencent/mobileqq/troop/homework/notice/HWNoticeCons$HWNoticeListType;Ljava/lang/String;)V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends BaseViewModel<com.tencent.mobileqq.troop.homework.notice.list.event.a, com.tencent.mobileqq.troop.homework.notice.list.event.b> implements IGetGroupSchoolNoticeListCallback, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HWNoticeCons$HWNoticeListType listType;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.notice.list.event.b mNoneValueIntent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<GroupSchoolNoticeData> noticeList;

    /* renamed from: G, reason: from kotlin metadata */
    private long lastPublishTime;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isEnd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/list/viewmodel/c$a;", "", "", "REQUEST_LIST_PAGE_SIZE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.list.viewmodel.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53450);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull HWNoticeCons$HWNoticeListType listType, @NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(listType, "listType");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listType, (Object) troopUin);
            return;
        }
        this.listType = listType;
        this.troopUin = troopUin;
        this.mNoneValueIntent = b.C8746b.f297270a;
        this.noticeList = new ArrayList();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final List<GroupSchoolNoticeData> N1(List<GroupSchoolNoticeData> noticeList) {
        ArrayList arrayList = new ArrayList();
        for (GroupSchoolNoticeData groupSchoolNoticeData : noticeList) {
            arrayList.add(new GroupSchoolNoticeData(groupSchoolNoticeData.noticeId, groupSchoolNoticeData.authorUin, groupSchoolNoticeData.content, groupSchoolNoticeData.state, groupSchoolNoticeData.publishTime, groupSchoolNoticeData.isConfirm, groupSchoolNoticeData.total, groupSchoolNoticeData.confirmedCount));
        }
        return arrayList;
    }

    private final void P1() {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        GetGroupSchoolNoticeListReq getGroupSchoolNoticeListReq = new GetGroupSchoolNoticeListReq(this.listType.getValue(), Long.parseLong(this.troopUin), this.lastPublishTime, 20);
        r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
        if (groupSchoolService != null) {
            groupSchoolService.getGroupSchoolNoticeList(getGroupSchoolNoticeListReq, this);
        }
    }

    private final void R1(String noticeId) {
        ListIterator<GroupSchoolNoticeData> listIterator = this.noticeList.listIterator();
        boolean z16 = false;
        while (listIterator.hasNext()) {
            GroupSchoolNoticeData next = listIterator.next();
            if (Intrinsics.areEqual(next.noticeId, noticeId)) {
                if (this.listType == HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_NO_CONFIRM) {
                    listIterator.remove();
                } else {
                    listIterator.set(new GroupSchoolNoticeData(next.noticeId, next.authorUin, next.content, next.state, next.publishTime, true, next.total, next.confirmedCount));
                }
                getMUiState().setValue(new a.b(N1(this.noticeList), this.isEnd));
            } else {
                z16 = true;
            }
        }
        if (!z16) {
            getMUiState().setValue(a.C8745a.f297266a);
        }
    }

    private final void S1(String noticeId) {
        ListIterator<GroupSchoolNoticeData> listIterator = this.noticeList.listIterator();
        while (listIterator.hasNext()) {
            if (Intrinsics.areEqual(listIterator.next().noticeId, noticeId)) {
                listIterator.remove();
                getMUiState().setValue(new a.b(N1(this.noticeList), this.isEnd));
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T1(PublishGroupSchoolNoticeReq noticeReq, PublishGroupSchoolNoticeRsp noticeRsp) {
        String str;
        PublishGroupSchoolNoticeReq publishGroupSchoolNoticeReq;
        long j3;
        List list;
        long j16;
        boolean z16;
        String account;
        String account2;
        Iterator<GroupSchoolNoticeIndex> it = noticeRsp.notices.iterator();
        while (true) {
            if (it.hasNext()) {
                GroupSchoolNoticeIndex next = it.next();
                if (Intrinsics.areEqual(String.valueOf(next.groupCode), this.troopUin)) {
                    str = next.noticeId;
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        String str2 = str;
        if (str2 != null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (account2 = peekAppRuntime.getAccount()) != null) {
                j3 = Long.parseLong(account2);
                publishGroupSchoolNoticeReq = noticeReq;
            } else {
                publishGroupSchoolNoticeReq = noticeReq;
                j3 = 0;
            }
            this.noticeList.add(0, new GroupSchoolNoticeData(str2, j3, publishGroupSchoolNoticeReq.content, 0, currentTimeMillis, false, noticeRsp.total, noticeRsp.confirmedCount));
            if (this.listType == HWNoticeCons$HWNoticeListType.NOTICE_LIST_TYPE_NO_CONFIRM) {
                List<GroupSchoolNoticeData> list2 = this.noticeList;
                list = new ArrayList();
                for (Object obj : list2) {
                    long j17 = ((GroupSchoolNoticeData) obj).authorUin;
                    AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime2 != null && (account = peekAppRuntime2.getAccount()) != null) {
                        Intrinsics.checkNotNullExpressionValue(account, "account");
                        j16 = Long.parseLong(account);
                    } else {
                        j16 = 0;
                    }
                    if (j17 == j16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        list.add(obj);
                    }
                }
            } else {
                list = this.noticeList;
            }
            getMUiState().setValue(new a.b(N1(list), this.isEnd));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(SimpleBaseEvent simpleBaseEvent, c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (simpleBaseEvent instanceof HWNoticeListUpdateEvent.NoticePublished) {
            HWNoticeListUpdateEvent.NoticePublished noticePublished = (HWNoticeListUpdateEvent.NoticePublished) simpleBaseEvent;
            this$0.T1(noticePublished.getPublishReq(), noticePublished.getPublishRsp());
        } else if (simpleBaseEvent instanceof HWNoticeListUpdateEvent.NoticeDeleted) {
            this$0.S1(((HWNoticeListUpdateEvent.NoticeDeleted) simpleBaseEvent).getNoticeId());
        } else if (simpleBaseEvent instanceof HWNoticeListUpdateEvent.NoticeConfirmed) {
            this$0.R1(((HWNoticeListUpdateEvent.NoticeConfirmed) simpleBaseEvent).getNoticeId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(c this$0, GetGroupSchoolNoticeListRsp it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.isEnd = it.isEnd;
        this$0.getMUiState().setValue(new a.b(this$0.N1(this$0.noticeList), it.isEnd));
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.homework.notice.list.event.b getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.notice.list.event.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    /* renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.troop.homework.notice.list.event.b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.a) {
            P1();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWNoticeListUpdateEvent.NoticePublished.class, HWNoticeListUpdateEvent.NoticeDeleted.class, HWNoticeListUpdateEvent.NoticeConfirmed.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onCleared();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
        } else {
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.list.viewmodel.a
                @Override // java.lang.Runnable
                public final void run() {
                    c.U1(SimpleBaseEvent.this, this);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeListCallback
    public void onResult(int errCode, @Nullable String errMsg, @Nullable final GetGroupSchoolNoticeListRsp rsp) {
        Object lastOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(errCode), errMsg, rsp);
            return;
        }
        if (errCode == 0 && rsp != null) {
            ArrayList<GroupSchoolNoticeData> datas = rsp.datas;
            if (datas != null) {
                Intrinsics.checkNotNullExpressionValue(datas, "datas");
                if (!datas.isEmpty()) {
                    this.noticeList.addAll(datas);
                    lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) datas);
                    GroupSchoolNoticeData groupSchoolNoticeData = (GroupSchoolNoticeData) lastOrNull;
                    if (groupSchoolNoticeData != null) {
                        j3 = groupSchoolNoticeData.publishTime;
                    } else {
                        j3 = this.lastPublishTime;
                    }
                    this.lastPublishTime = j3;
                }
            }
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.list.viewmodel.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.W1(c.this, rsp);
                }
            });
        }
        this.isRequesting = false;
    }
}
