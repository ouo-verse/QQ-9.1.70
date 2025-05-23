package com.tencent.mobileqq.matchfriend.reborn.content;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.bean.c;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J8\u0010\u000e\u001a\u00020\u00042\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f0\bj\b\u0012\u0004\u0012\u00020\f`\nH\u0002J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017`\nH\u0016R\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/QQStrangerProfileUpdatePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "A9", "C9", "B9", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "z9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "d", "Lkotlin/jvm/functions/Function1;", "recentContactListener", "<init>", "()V", "e", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerProfileUpdatePart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<? super RecentContactListChangedInfo, Unit> recentContactListener = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.QQStrangerProfileUpdatePart$recentContactListener$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
            invoke2(recentContactListChangedInfo);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RecentContactListChangedInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
            QQStrangerProfileUpdatePart qQStrangerProfileUpdatePart = QQStrangerProfileUpdatePart.this;
            ArrayList<Long> arrayList = it.sortedContactList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "it.sortedContactList");
            ArrayList<RecentContactInfo> arrayList2 = it.changedList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "it.changedList");
            qQStrangerProfileUpdatePart.z9(arrayList, arrayList2);
        }
    };

    private final void A9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        ((IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).preLoad();
    }

    private final void B9() {
        aa recentContactService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || (recentContactService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "all")).getRecentContactService()) == null) {
            return;
        }
        recentContactService.m(8, this.recentContactListener);
    }

    private final void C9() {
        aa recentContactService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || (recentContactService = ((IKernelService) appInterface.getRuntimeService(IKernelService.class, "all")).getRecentContactService()) == null) {
            return;
        }
        recentContactService.g0(8, this.recentContactListener);
        aa.b.a(recentContactService, new AnchorPointContactInfo(), true, 8, 0, null, 24, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z9(ArrayList<Long> sortedContactList, ArrayList<RecentContactInfo> changedList) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026essConstant.ALL\n        )");
        IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) runtimeService;
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<RecentContactInfo> arrayList3 = new ArrayList();
        for (Object obj : changedList) {
            if (sortedContactList.contains(Long.valueOf(((RecentContactInfo) obj).contactId))) {
                arrayList3.add(obj);
            }
        }
        for (RecentContactInfo recentContactInfo : arrayList3) {
            arrayList2.add(recentContactInfo.peerUid);
            int i3 = recentContactInfo.chatType;
            String str = recentContactInfo.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "it.peerUid");
            c cVar = new c(i3, Long.parseLong(str), "");
            if (iQQStrangerUserInfoMgr.getUserInfo(cVar) == null) {
                arrayList.add(cVar);
            }
        }
        ((IQQStrangerInteractiveMarkService) appInterface.getRuntimeService(IQQStrangerInteractiveMarkService.class, "all")).batchGetInteractiveMark(104, arrayList2);
        IQQStrangerUserInfoMgr.a.a(iQQStrangerUserInfoMgr, arrayList, null, 2, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        C9();
        A9();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        B9();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if ((event instanceof QQStrangerKuiklyEvent) && Intrinsics.areEqual(((QQStrangerKuiklyEvent) event).getEventName(), "JIEBAN_SELF_USERINFO_CHANGED_EVENT")) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface == null) {
                QLog.i("QQStrangerProfileUpdatePart", 1, "onReceive JIEBAN_SELF_USERINFO_CHANGED_EVENT app is null");
                return;
            }
            IRuntimeService runtimeService = appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026ava, ProcessConstant.ALL)");
            final IQQStrangerUserInfoMgr iQQStrangerUserInfoMgr = (IQQStrangerUserInfoMgr) runtimeService;
            QQStrangerUserInfo selfUserInfo = iQQStrangerUserInfoMgr.getSelfUserInfo();
            String str = selfUserInfo != null ? selfUserInfo.openId : null;
            if (str == null || str.length() == 0) {
                QLog.i("QQStrangerProfileUpdatePart", 1, "onReceive JIEBAN_SELF_USERINFO_CHANGED_EVENT self open id is empty.");
            } else {
                ((IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).reqUserInfo(new c(104, 0L, str), new Function1<QQStrangerUserInfo, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.QQStrangerProfileUpdatePart$onReceiveEvent$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(QQStrangerUserInfo qQStrangerUserInfo) {
                        invoke2(qQStrangerUserInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(QQStrangerUserInfo qQStrangerUserInfo) {
                        if (qQStrangerUserInfo != null) {
                            IQQStrangerUserInfoMgr.this.setSelfUserInfo(qQStrangerUserInfo);
                        } else {
                            QLog.e("QQStrangerProfileUpdatePart", 1, "onReceive userInfo invalid.");
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerKuiklyEvent.class);
        return arrayListOf;
    }
}
