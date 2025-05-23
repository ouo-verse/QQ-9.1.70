package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.util.FeedUnclassifiedUtilsKt;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorRestoreContentUseCase;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.e;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCancelTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildCreateTaskOperationEvent;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import java.util.HashSet;
import java.util.Set;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import lm1.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0001SB\u001f\u0012\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202\u0012\u0002\b\u000300\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0004\u001a\u00020\u0003H\u0003J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0003H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J'\u0010%\u001a!\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00140\u001fj\u0002`$H\u0002J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020\u0003H\u0002J\"\u0010,\u001a\u00020\u00032\u0010\u0010*\u001a\f\u0012\u0004\u0012\u00020\u00110(j\u0002`)2\u0006\u0010+\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020\u0003H\u0016J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020.H\u0016R$\u00105\u001a\u0012\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202\u0012\u0002\b\u0003008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R9\u00108\u001a%\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001fj\u0004\u0018\u0001`$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u00109R*\u0010B\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001b\u0010F\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010GR\u0016\u0010I\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010GR\u0016\u0010J\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010GR\u0016\u0010L\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010KR\u0014\u0010P\u001a\u00020M8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u0010O\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorInitUseCaseVMDelegate;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStart", BdhLogUtil.LogTag.Tag_Conn, "G", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$OnDraftResponseMsgIntent;", "event", "w", "k", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildFeedDraft;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorDraftModel;", "draft", DomainData.DOMAIN_NAME, "u", "H", "Lzl1/a;", "param", "K", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "B", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UserInfo.SEX_FEMALE, HippyTKDListViewAdapter.X, "l", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "eventKey", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/PendingTask;", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "Lcom/tencent/base/api/runtime/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalUIState;", h.F, "Lcom/tencent/mvi/mvvm/BaseVM;", "vm", "i", "Lkotlin/jvm/functions/Function1;", "draftEventPendingTask", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseMsgIntent$OnDraftResponseMsgIntent;", "draftResponseEvent", "Lkotlin/Function0;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/FeedEditorRestoreContentUseCase;", "Lkotlin/jvm/functions/Function0;", ReportConstant.COSTREPORT_PREFIX, "()Lkotlin/jvm/functions/Function0;", "setRestoreContentUseCaseConstructor", "(Lkotlin/jvm/functions/Function0;)V", "restoreContentUseCaseConstructor", "Lkotlin/Lazy;", "r", "()Lcom/tencent/mobileqq/guild/feed/nativepublish/usecase/FeedEditorRestoreContentUseCase;", "restoreContentUseCase", "Z", "isTaskInitialized", "isDraftRestored", "isReadyToConsumeDraftEvent", "I", "restoreToolType", "", "p", "()Ljava/lang/String;", "logTag", "<init>", "(Lcom/tencent/mvi/mvvm/BaseVM;)V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorInitUseCaseVMDelegate extends com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a implements LifecycleObserver {

    @NotNull
    private static final a I = new a(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function0<FeedEditorRestoreContentUseCase> restoreContentUseCaseConstructor;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy restoreContentUseCase;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isTaskInitialized;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isDraftRestored;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isReadyToConsumeDraftEvent;

    /* renamed from: H, reason: from kotlin metadata */
    private int restoreToolType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseVM<FeedEditorGlobalIntent, FeedEditorGlobalUIState, ?> vm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Integer, Boolean> draftEventPendingTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent draftResponseEvent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorInitUseCaseVMDelegate$a;", "", "", "ON_DISCARD_RESTORE_DRAFT", "I", "ON_GET_NO_DRAFT", "ON_RESTORE_DRAFT", "ON_USER_DISMISS_DIALOG_NEUTRALLY", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorInitUseCaseVMDelegate(@NotNull BaseVM<FeedEditorGlobalIntent, FeedEditorGlobalUIState, ?> vm5) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.vm = vm5;
        this.restoreContentUseCase = FeedUnclassifiedUtilsKt.d(new Function0<FeedEditorRestoreContentUseCase>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorInitUseCaseVMDelegate$restoreContentUseCase$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FeedEditorRestoreContentUseCase invoke() {
                FeedEditorRestoreContentUseCase invoke;
                Function0<FeedEditorRestoreContentUseCase> s16 = FeedEditorInitUseCaseVMDelegate.this.s();
                return (s16 == null || (invoke = s16.invoke()) == null) ? new FeedEditorRestoreContentUseCase(null, null, 3, null) : invoke;
            }
        });
        this.restoreToolType = 2;
    }

    private final void A() {
        zl1.a param = c().h();
        param.I(com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.a());
        this.restoreToolType = 1;
        Intrinsics.checkNotNullExpressionValue(param, "param");
        K(param);
    }

    private final void B() {
        A();
    }

    private final void C() {
        in1.d b16 = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.b(c());
        if (b16 != null && b16.getStage() == 1) {
            b16.c(0);
        }
    }

    private final Function1<Integer, Boolean> D() {
        return new Function1<Integer, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorInitUseCaseVMDelegate$preparePendingTaskOfNewPublish$1

            /* JADX INFO: Access modifiers changed from: package-private */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorInitUseCaseVMDelegate$preparePendingTaskOfNewPublish$1$1, reason: invalid class name */
            /* loaded from: classes13.dex */
            public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<CoroutineScope> {
                AnonymousClass1(Object obj) {
                    super(0, obj, BaseVM.class, "vmScope", "vmScope()Lkotlinx/coroutines/CoroutineScope;", 0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final CoroutineScope invoke() {
                    return ((BaseVM) this.receiver).vmScope();
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }

            @NotNull
            public final Boolean invoke(int i3) {
                FeedEditorRestoreContentUseCase r16;
                boolean z16;
                FeedEditorRestoreContentUseCase r17;
                FeedEditorRestoreContentUseCase r18;
                BaseVM baseVM;
                if (i3 == 2) {
                    r16 = FeedEditorInitUseCaseVMDelegate.this.r();
                    r16.i(FeedEditorInitUseCaseVMDelegate.this.c());
                    FeedEditorInitUseCaseVMDelegate.this.o();
                    return Boolean.TRUE;
                }
                if (i3 == 3 || i3 == 4) {
                    z16 = FeedEditorInitUseCaseVMDelegate.this.isDraftRestored;
                    if (z16) {
                        return Boolean.TRUE;
                    }
                }
                if (FeedEditorInitUseCaseVMDelegate.this.c().h().getIsJsonFeedPresetFormat()) {
                    r18 = FeedEditorInitUseCaseVMDelegate.this.r();
                    com.tencent.base.api.runtime.a<zl1.a> c16 = FeedEditorInitUseCaseVMDelegate.this.c();
                    baseVM = FeedEditorInitUseCaseVMDelegate.this.vm;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(baseVM);
                    final FeedEditorInitUseCaseVMDelegate feedEditorInitUseCaseVMDelegate = FeedEditorInitUseCaseVMDelegate.this;
                    r18.o(c16, anonymousClass1, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorInitUseCaseVMDelegate$preparePendingTaskOfNewPublish$1.2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            FeedEditorInitUseCaseVMDelegate.this.o();
                        }
                    });
                    return Boolean.TRUE;
                }
                r17 = FeedEditorInitUseCaseVMDelegate.this.r();
                r17.i(FeedEditorInitUseCaseVMDelegate.this.c());
                FeedEditorInitUseCaseVMDelegate.this.o();
                return Boolean.TRUE;
            }
        };
    }

    private final void F(zl1.a param) {
        String stackTraceToString;
        if (TextUtils.isEmpty(param.getJsonFeed())) {
            return;
        }
        try {
            r().m(new FeedEditorInitUseCaseVMDelegate$restoreContentAndShowKeyboard$1(this.vm), c(), this.restoreToolType, param.getJsonFeed(), true, new Function1<j, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorInitUseCaseVMDelegate$restoreContentAndShowKeyboard$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(j jVar) {
                    invoke2(jVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull j restoreContentAndShowKeyboard) {
                    Intrinsics.checkNotNullParameter(restoreContentAndShowKeyboard, "$this$restoreContentAndShowKeyboard");
                    FeedEditorInitUseCaseVMDelegate.this.o();
                }
            });
        } catch (Exception e16) {
            String p16 = p();
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e16);
            QLog.d(p16, 1, "[handleReEditFailedPublish]: " + stackTraceToString + " ");
        }
    }

    private final void G() {
        if (!b.a(this).getIsTriggerPost() && c().h().getConfiguration().getIsDisableDraft()) {
            bl c16 = bl.c();
            String a16 = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(c());
            zl1.a h16 = c().h();
            Intrinsics.checkNotNullExpressionValue(h16, "context.baseParam");
            GuildCancelTaskOperationEvent guildCancelTaskOperationEvent = new GuildCancelTaskOperationEvent(2, a16, zl1.b.j(h16));
            guildCancelTaskOperationEvent.setActionType(GuildCancelTaskOperationEvent.ACTION_TYPE_USER_OPERATION);
            c16.a(guildCancelTaskOperationEvent);
        }
    }

    private final void H() {
        e.QueryLastDraftResult queryLastDraftResult;
        if (c().h().getConfiguration().getIsDisableDraft()) {
            m(1);
            return;
        }
        k k3 = c().e().k(FeedEditorDraftUseCaseMsgIntent.QueryLastDraftMsgIntent.f222392d);
        if (k3 instanceof e.QueryLastDraftResult) {
            queryLastDraftResult = (e.QueryLastDraftResult) k3;
        } else {
            queryLastDraftResult = null;
        }
        if (queryLastDraftResult == null) {
            QLog.w(p(), 1, "[tryRecoverDraft]: taskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(c()) + ", something went wrong");
            return;
        }
        if (queryLastDraftResult.getCacheHit()) {
            n(queryLastDraftResult.getDraft());
        }
    }

    private final void K(zl1.a param) {
        if (q()) {
            return;
        }
        F(param);
    }

    private final void k() {
        GProGuildFeedDraft gProGuildFeedDraft;
        if (!this.isReadyToConsumeDraftEvent) {
            return;
        }
        this.isReadyToConsumeDraftEvent = false;
        FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent onDraftResponseMsgIntent = this.draftResponseEvent;
        if (onDraftResponseMsgIntent != null) {
            gProGuildFeedDraft = onDraftResponseMsgIntent.getDraft();
        } else {
            gProGuildFeedDraft = null;
        }
        if (gProGuildFeedDraft == null) {
            zl1.a h16 = c().h();
            Intrinsics.checkNotNullExpressionValue(h16, "context.baseParam");
            F(h16);
        } else {
            FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent onDraftResponseMsgIntent2 = this.draftResponseEvent;
            Intrinsics.checkNotNull(onDraftResponseMsgIntent2);
            n(onDraftResponseMsgIntent2.getDraft());
        }
    }

    private final void l() {
        int i3;
        zl1.a param = c().h();
        GuildFeedBaseInitBean initBean = param.getInitBean();
        if (initBean != null) {
            i3 = initBean.getBusinessType();
        } else {
            i3 = 0;
        }
        int i16 = i3;
        QLog.d(p(), 1, "[createOrReuseTask]: taskId=" + param.m() + ", sceneType=" + param.getSceneType() + ", ");
        bl c16 = bl.c();
        String m3 = param.m();
        String h16 = param.h();
        String a16 = param.a();
        boolean isFeedBeingEditedPublished = param.getIsFeedBeingEditedPublished();
        GuildFeedReportSourceInfo c17 = com.tencent.mobileqq.guild.feed.nativepublish.utils.k.c(1, initBean);
        Intrinsics.checkNotNullExpressionValue(param, "param");
        c16.a(new GuildCreateTaskOperationEvent(m3, h16, a16, isFeedBeingEditedPublished, i16, c17, zl1.b.j(param) ? 1 : 0));
        in1.d b16 = com.tencent.mobileqq.guild.feed.nativepublish.utils.a.b(c());
        if (b16 != null) {
            b16.c(1);
        }
    }

    private final void m(int eventKey) {
        Function1<? super Integer, Boolean> function1 = this.draftEventPendingTask;
        boolean z16 = false;
        if (function1 != null && function1.invoke(Integer.valueOf(eventKey)).booleanValue()) {
            z16 = true;
        }
        if (z16) {
            QLog.d(p(), 1, "[execPendingTask]: eventKey=" + eventKey);
            this.draftEventPendingTask = null;
        }
    }

    private final void n(GProGuildFeedDraft draft) {
        if (draft != null) {
            r().g(c(), draft);
            this.isDraftRestored = true;
            m(2);
            return;
        }
        m(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        if (c().e().k(new FeedEditorRootMsgIntent.FocusSearchMsgIntent(true)) != a.C10733a.f415002a) {
            c().e().h(new FeedEditorRootMsgIntent.ShowInputMethod(true));
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onStart() {
        if (this.isTaskInitialized) {
            return;
        }
        u();
        this.isTaskInitialized = true;
    }

    private final boolean q() {
        e.QueryLastDraftResult queryLastDraftResult;
        if (!c().h().getConfiguration().getIsDisableDraft() && !TextUtils.isEmpty(c().h().getDraftKey())) {
            k k3 = c().e().k(FeedEditorDraftUseCaseMsgIntent.QueryLastDraftMsgIntent.f222392d);
            if (k3 instanceof e.QueryLastDraftResult) {
                queryLastDraftResult = (e.QueryLastDraftResult) k3;
            } else {
                queryLastDraftResult = null;
            }
            if (queryLastDraftResult == null) {
                QLog.w(p(), 1, "[tryRecoverDraft]: taskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(c()) + ", something went wrong");
                return false;
            }
            if (queryLastDraftResult.getCacheHit() && queryLastDraftResult.getDraft() != null) {
                n(queryLastDraftResult.getDraft());
                return true;
            }
            if (!queryLastDraftResult.getCacheHit()) {
                this.draftResponseEvent = null;
                this.isReadyToConsumeDraftEvent = true;
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FeedEditorRestoreContentUseCase r() {
        return (FeedEditorRestoreContentUseCase) this.restoreContentUseCase.getValue();
    }

    private final void t() {
        A();
    }

    private final void u() {
        zl1.a param = c().h();
        int sceneType = c().h().getSceneType();
        QLog.d(p(), 1, "[initTask]: sceneType: " + sceneType + ", mainTaskId=" + param.m() + ", feedId=" + param.getFeedId() + ", current contact=" + param.getContact());
        switch (sceneType) {
            case 1:
                v();
                break;
            case 2:
                t();
                break;
            case 3:
                Intrinsics.checkNotNullExpressionValue(param, "param");
                z(param);
                break;
            case 4:
                Intrinsics.checkNotNullExpressionValue(param, "param");
                y(param);
                break;
            case 5:
                B();
                break;
            case 6:
                x();
                break;
        }
        l();
    }

    private final void v() {
        c().h().I(com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.a());
        o();
        this.draftEventPendingTask = D();
        H();
    }

    private final void w(FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent event) {
        this.draftResponseEvent = event;
        k();
    }

    private final void x() {
        boolean z16;
        zl1.a h16 = c().h();
        if (h16.m().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h16.I(com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.a());
        }
        if (!h16.getIsEdition()) {
            this.draftEventPendingTask = D();
            H();
        } else {
            r().m(new FeedEditorInitUseCaseVMDelegate$handlePublishNewFeedBeyondGuild$1(this.vm), c(), 1, h16.getJsonFeed(), false, new Function1<j, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorInitUseCaseVMDelegate$handlePublishNewFeedBeyondGuild$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(j jVar) {
                    invoke2(jVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull j restoreContentAndShowKeyboard) {
                    Intrinsics.checkNotNullParameter(restoreContentAndShowKeyboard, "$this$restoreContentAndShowKeyboard");
                    FeedEditorInitUseCaseVMDelegate.this.o();
                }
            });
        }
    }

    private final void y(zl1.a param) {
        this.restoreToolType = 2;
        K(param);
    }

    private final void z(zl1.a param) {
        this.restoreToolType = 2;
        K(param);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent) {
            w((FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent) event);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    /* renamed from: e */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.b(context, reuse);
        context.d().getLifecycle().addObserver(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        super.onDestroy();
        c().d().getLifecycle().removeObserver(this);
        if (!b.a(this).getIsTriggerPost()) {
            km1.a.f412694a.h(com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(c()), 0);
        }
        C();
        G();
    }

    @NotNull
    protected String p() {
        return "FeedEditor.InitTaskUseCase";
    }

    @Nullable
    public final Function0<FeedEditorRestoreContentUseCase> s() {
        return this.restoreContentUseCaseConstructor;
    }
}
