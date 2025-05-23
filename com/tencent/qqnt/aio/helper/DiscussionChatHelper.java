package com.tencent.qqnt.aio.helper;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.JsonGrayElement;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.util.TokenResUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0013\u0010\t\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0013\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0002H\u0002J\u0016\u0010\u0010\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u001b\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\nJ\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001cH\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/aio/helper/DiscussionChatHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "w", "B", "u", "Landroidx/fragment/app/FragmentActivity;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ReportConstant.COSTREPORT_PREFIX, "v", "Lkotlin/Function0;", "confirmCallback", HippyTKDListViewAdapter.X, "t", "", "uin", "o", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getTag", "", "getId", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "e", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Lcom/tencent/mvi/base/route/a;", "f", "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", tl.h.F, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class DiscussionChatHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Contact contact;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1 = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052*\u0010\u0007\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "result", "", "msg", "", "kotlin.jvm.PlatformType", TabPreloadItem.TAB_NAME_MESSAGE, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class c implements IMsgOperateCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f350329a;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f350329a = cancellableContinuation;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
        public final void onResult(int i3, String str, ArrayList<MsgRecord> arrayList) {
            GrayTipElement grayTipElement;
            JsonGrayElement jsonGrayElement;
            if (i3 == 0 && arrayList != null && arrayList.size() != 0) {
                for (MsgRecord msgRecord : arrayList) {
                    QLog.d("DiscussionChatHelper", 1, "isGrayTipExists msgId = " + msgRecord.msgId + " msgSeq = " + msgRecord.msgSeq);
                }
                MsgRecord msgRecord2 = arrayList.get(0);
                if (msgRecord2.msgType == 5) {
                    ArrayList<MsgElement> arrayList2 = msgRecord2.elements;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "mr.elements");
                    Iterator<T> it = arrayList2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((MsgElement) next).elementType == 8) {
                            r0 = next;
                            break;
                        }
                    }
                    MsgElement msgElement = (MsgElement) r0;
                    if (msgElement != null && (grayTipElement = msgElement.grayTipElement) != null && (jsonGrayElement = grayTipElement.jsonGrayTipElement) != null) {
                        CancellableContinuation<Boolean> cancellableContinuation = this.f350329a;
                        if (cancellableContinuation.isActive()) {
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.valueOf(jsonGrayElement.busiId == 2603)));
                        }
                    }
                }
            } else {
                QLog.d("DiscussionChatHelper", 1, "isGrayTipExists r:" + i3 + " s:" + (arrayList != null ? Integer.valueOf(arrayList.size()) : null) + ", msg:" + str);
            }
            if (this.f350329a.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation2 = this.f350329a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/DiscussionChatHelper$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (QLog.isColorLevel()) {
                QLog.i("DiscussionChatHelper", 2, "[mAction1] call:" + i3);
            }
            if (i3 instanceof AIOTitleEvent.Right1IvClickEvent) {
                DiscussionChatHelper.this.v();
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(MMKVOptionEntity entity, String peerUid, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        entity.encodeBool("discussion_unavailable_tips_showed_" + peerUid, true).commitAsync();
    }

    private final void B() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().b(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right1IvClickEvent.class)), this.mAction1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(String str, Continuation<? super Boolean> continuation) {
        DiscussionChatHelper$deleteDiscuss$1 discussionChatHelper$deleteDiscuss$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof DiscussionChatHelper$deleteDiscuss$1) {
            discussionChatHelper$deleteDiscuss$1 = (DiscussionChatHelper$deleteDiscuss$1) continuation;
            int i16 = discussionChatHelper$deleteDiscuss$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                discussionChatHelper$deleteDiscuss$1.label = i16 - Integer.MIN_VALUE;
                DiscussionChatHelper$deleteDiscuss$1 discussionChatHelper$deleteDiscuss$12 = discussionChatHelper$deleteDiscuss$1;
                Object obj = discussionChatHelper$deleteDiscuss$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = discussionChatHelper$deleteDiscuss$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        return Boxing.boxBoolean(false);
                    }
                    Manager manager = peekAppRuntime.getManager(QQManagerFactory.DISCUSSION_MANAGER);
                    Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.DiscussionManager");
                    QLog.i("DiscussionChatHelper", 1, "deleteDiscuss , uin=" + str);
                    i.c cVar = i.c.f261781e;
                    DiscussionChatHelper$deleteDiscuss$2 discussionChatHelper$deleteDiscuss$2 = new DiscussionChatHelper$deleteDiscuss$2((com.tencent.mobileqq.app.n) manager, str, null);
                    discussionChatHelper$deleteDiscuss$12.label = 1;
                    obj = CorountineFunKt.i(cVar, "DiscussionChatHelper-deleteDiscuss", null, discussionChatHelper$deleteDiscuss$2, discussionChatHelper$deleteDiscuss$12, 4, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Boolean bool = (Boolean) obj;
                return Boxing.boxBoolean(bool != null ? bool.booleanValue() : false);
            }
        }
        discussionChatHelper$deleteDiscuss$1 = new DiscussionChatHelper$deleteDiscuss$1(this, continuation);
        DiscussionChatHelper$deleteDiscuss$1 discussionChatHelper$deleteDiscuss$122 = discussionChatHelper$deleteDiscuss$1;
        Object obj2 = discussionChatHelper$deleteDiscuss$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = discussionChatHelper$deleteDiscuss$122.label;
        if (i3 != 0) {
        }
        Boolean bool2 = (Boolean) obj2;
        return Boxing.boxBoolean(bool2 != null ? bool2.booleanValue() : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object result;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        if (app != null) {
            Intrinsics.checkNotNullExpressionValue(app, "app");
            com.tencent.qqnt.kernel.api.w msgService = ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getMsgService();
            com.tencent.qqnt.kernel.api.aa recentContactService = ((IKernelService) app.getRuntimeService(IKernelService.class, "")).getRecentContactService();
            if (msgService != null && recentContactService != null) {
                Contact contact = this.contact;
                if (contact == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contact");
                    contact = null;
                }
                msgService.clearMsgRecords(contact, new b(recentContactService, cancellableContinuationImpl));
                result = cancellableContinuationImpl.getResult();
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (result == coroutine_suspended) {
                    DebugProbes.probeCoroutineSuspended(continuation);
                }
                return result;
            }
            QLog.d("DiscussionChatHelper", 1, "deleteMsgHistory msgService or recentContactService null return");
        }
        if (cancellableContinuationImpl.isActive()) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(Boxing.boxBoolean(false)));
        }
        result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentActivity q() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        FragmentActivity requireActivity = aVar.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "aioContext.fragment.requireActivity()");
        return requireActivity;
    }

    private final Object s(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        Contact contact = this.contact;
        if (contact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contact");
            contact = null;
        }
        iMsgService.getMsgs(contact, 0L, 1, true, new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "aioContext.lifecycleOwner.lifecycle");
        CorountineFunKt.e(LifecycleKt.getCoroutineScope(lifecycle), "DiscussionChatHelper_onCreate", Boolean.TRUE, null, null, new DiscussionChatHelper$onConfirmDeleteMsgHistory$1(this, null), 12, null);
    }

    private final void u() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "aioContext.lifecycleOwner.lifecycle");
        CorountineFunKt.e(LifecycleKt.getCoroutineScope(lifecycle), "DiscussionChatHelper_onCreate", Boolean.TRUE, null, null, new DiscussionChatHelper$onDelayLoad$1(this, null), 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        x(new DiscussionChatHelper$onRight1IvClick$1(this));
    }

    private final void w() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().d(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right1IvClickEvent.class)), this.mAction1);
    }

    private final void x(final Function0<Unit> confirmCallback) {
        Dialog createDialog = ActionSheetHelper.createDialog(q(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(R.string.zrw);
        actionSheet.addButton(q().getString(R.string.b5u), 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.ar
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                DiscussionChatHelper.y(Function0.this, actionSheet, view, i3);
            }
        });
        if (actionSheet.isShowing()) {
            return;
        }
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Function0 confirmCallback, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(confirmCallback, "$confirmCallback");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            confirmCallback.invoke();
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        final MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        final String j3 = aVar.g().r().c().j();
        if (QLog.isColorLevel()) {
            QLog.d("DiscussionChatHelper", 2, "showDiscussionUnavailableDialog " + j3);
        }
        if (from.decodeBool("discussion_unavailable_tips_showed_" + j3, false)) {
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(q(), 230, (String) null, q().getString(R.string.zrx), (String) null, q().getString(R.string.f1380608j), new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.aq
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DiscussionChatHelper.A(MMKVOptionEntity.this, j3, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.K0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "DiscussionChatHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        String j3 = a16.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar2 = null;
        }
        this.contact = new Contact(aVar2.g().r().c().e(), j3, "");
        int tokenRes = TokenResUtils.getTokenRes(R.drawable.b4o, R.drawable.qui_chat_settings_icon_navigation_01);
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar3;
        }
        aVar.e().h(new AIOTitleEvent.UpdateRight1IvEvent(false, true, q().getDrawable(tokenRes), 4, null));
        w();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "r", "", "msg", "", "kotlin.jvm.PlatformType", "<anonymous parameter 2>", "", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class b implements IClearMsgRecordsCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.kernel.api.aa f350326b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Boolean> f350327c;

        /* JADX WARN: Multi-variable type inference failed */
        b(com.tencent.qqnt.kernel.api.aa aaVar, CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.f350326b = aaVar;
            this.f350327c = cancellableContinuation;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "r", "", "msg", "", "kotlin.jvm.PlatformType", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes34.dex */
        static final class a implements IOperateCallback {

            /* renamed from: a, reason: collision with root package name */
            public static final a f350328a = new a();

            a() {
            }

            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                if (i3 != 0) {
                    QLog.d("DiscussionChatHelper", 1, "deleteRecentContacts fail: " + i3, ", msg: " + str);
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback
        public final void onResult(int i3, String str, long j3) {
            ArrayList<RecentContactInfo> arrayListOf;
            if (i3 != 0) {
                QLog.d("DiscussionChatHelper", 1, "deleteMsgHistory fail: ", Integer.valueOf(i3), ", msg: ", str);
            } else {
                RecentContactInfo recentContactInfo = new RecentContactInfo();
                Contact contact = DiscussionChatHelper.this.contact;
                Contact contact2 = null;
                if (contact == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contact");
                    contact = null;
                }
                recentContactInfo.peerUid = contact.peerUid;
                Contact contact3 = DiscussionChatHelper.this.contact;
                if (contact3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contact");
                } else {
                    contact2 = contact3;
                }
                recentContactInfo.chatType = contact2.chatType;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(recentContactInfo);
                this.f350326b.deleteRecentContacts(arrayListOf, a.f350328a);
                if (this.f350327c.isActive()) {
                    CancellableContinuation<Boolean> cancellableContinuation = this.f350327c;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                }
            }
            if (this.f350327c.isActive()) {
                CancellableContinuation<Boolean> cancellableContinuation2 = this.f350327c;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 4) {
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r(Continuation<? super Unit> continuation) {
        DiscussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1 discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1;
        Object coroutine_suspended;
        int i3;
        AppRuntime appRuntime;
        DiscussionChatHelper discussionChatHelper;
        boolean booleanValue;
        if (continuation instanceof DiscussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1) {
            discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1 = (DiscussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1) continuation;
            int i16 = discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.label = i16 - Integer.MIN_VALUE;
                Object obj = discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        return Unit.INSTANCE;
                    }
                    discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.L$0 = this;
                    discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.L$1 = peekAppRuntime;
                    discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.label = 1;
                    Object s16 = s(discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1);
                    if (s16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    appRuntime = peekAppRuntime;
                    obj = s16;
                    discussionChatHelper = this;
                } else if (i3 == 1) {
                    AppRuntime appRuntime2 = (AppRuntime) discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.L$1;
                    discussionChatHelper = (DiscussionChatHelper) discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    appRuntime = appRuntime2;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanValue = ((Boolean) obj).booleanValue();
                QLog.d("DiscussionChatHelper", 1, "grayTip exists: " + booleanValue + " ");
                if (!booleanValue) {
                    return Unit.INSTANCE;
                }
                com.tencent.aio.api.runtime.a aVar = discussionChatHelper.aioContext;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar = null;
                }
                String j3 = aVar.g().r().c().j();
                com.tencent.aio.api.runtime.a aVar2 = discussionChatHelper.aioContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                    aVar2 = null;
                }
                LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(j3, aVar2.g().r().c().e(), 2603L, 0, false, false, null, 120, null);
                String string = discussionChatHelper.q().getString(R.string.zry);
                Intrinsics.checkNotNullExpressionValue(string, "getActivity().getString(\u2026scussion_unavailable_tip)");
                LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, string, 0, 2, null);
                QRouteApi api = QRoute.api(INtGrayTipApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
                INtGrayTipApi.a.a((INtGrayTipApi) api, appRuntime, localGrayTipBuilder.m(), null, 4, null);
                return Unit.INSTANCE;
            }
        }
        discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1 = new DiscussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1(this, continuation);
        Object obj2 = discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = discussionChatHelper$insertDiscussionUnavailableGrayTipIfNeed$1.label;
        if (i3 != 0) {
        }
        booleanValue = ((Boolean) obj2).booleanValue();
        QLog.d("DiscussionChatHelper", 1, "grayTip exists: " + booleanValue + " ");
        if (!booleanValue) {
        }
    }
}
