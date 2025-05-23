package com.tencent.biz.qqcircle.publish.plusentry.composer.bubble;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.utils.ap;
import com.tencent.biz.qqcircle.immersive.viewmodel.wink.QFSPublishFeedViewModel;
import com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer;
import com.tencent.biz.qqcircle.widgets.QFSPublishFeedBubble;
import com.tencent.biz.qqcircle.widgets.QFSPublishPagBubble;
import com.tencent.biz.qqcircle.wink.DTBubbleInfo;
import com.tencent.biz.qqcircle.wink.e;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import e40.QFSFeedBubbleInfo;
import java.util.LinkedHashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import ma0.BubbleUIData;
import oa0.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020\r\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010#\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/bubble/PlusEntryBubbleComposer;", "Lcom/tencent/biz/qqcircle/publish/plusentry/composer/BasePlusEntryComposer;", "", "w", "Le40/a;", "bubbleInfo", HippyTKDListViewAdapter.X, "", "u", "b", "a", ReportConstant.COSTREPORT_PREFIX, "t", "Landroid/view/View;", "f", "Landroid/view/View;", "anchorView", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble;", "g", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishPagBubble;", "newUserTip", "Lcom/tencent/biz/qqcircle/widgets/QFSPublishFeedBubble;", h.F, "Lcom/tencent/biz/qqcircle/widgets/QFSPublishFeedBubble;", "publishTip", "Landroidx/lifecycle/Observer;", "Loa0/a;", "Lma0/a;", "i", "Landroidx/lifecycle/Observer;", "newUserTipObserver", "j", "publishTipObserver", "v", "()Z", "isEnable", "", "d", "()Ljava/lang/String;", "logTag", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "plusEntryLayout", "<init>", "(Lcom/tencent/biz/richframework/part/interfaces/IPartHost;Landroid/view/View;)V", "k", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class PlusEntryBubbleComposer extends BasePlusEntryComposer {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static String f91693l = "";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View anchorView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPublishPagBubble newUserTip;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSPublishFeedBubble publishTip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Observer<oa0.a<BubbleUIData>> newUserTipObserver;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Observer<oa0.a<BubbleUIData>> publishTipObserver;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/biz/qqcircle/publish/plusentry/composer/bubble/PlusEntryBubbleComposer$a;", "", "", "bubbleAdId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "", "PUBLISH_TIP_DURATION_MS", "J", "TAG", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return PlusEntryBubbleComposer.f91693l;
        }

        public final void b(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            PlusEntryBubbleComposer.f91693l = str;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlusEntryBubbleComposer(@NotNull IPartHost partHost, @NotNull View plusEntryLayout) {
        super(partHost, plusEntryLayout);
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(plusEntryLayout, "plusEntryLayout");
        this.anchorView = plusEntryLayout.findViewById(R.id.f500524c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        return QCirclePanelStateEvent.isAnyPanelShowing();
    }

    private final boolean v() {
        if (this.anchorView != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        if (!v()) {
            QLog.d(d(), 1, "showNewUserTip, is not enable ");
            return;
        }
        if (u()) {
            QLog.d(d(), 1, "showNewUserTip, other panel is showing");
            return;
        }
        QLog.d(d(), 1, "showNewUserTip ");
        if (this.anchorView != null) {
            QFSPublishPagBubble.Companion companion = QFSPublishPagBubble.INSTANCE;
            Context context = c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            QFSPublishFeedViewModel viewModel = g();
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
            this.newUserTip = companion.c(context, ap.f(viewModel), null, new Function1<QFSPublishPagBubble, Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$showNewUserTip$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QFSPublishPagBubble qFSPublishPagBubble) {
                    invoke2(qFSPublishPagBubble);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QFSPublishPagBubble bubble) {
                    boolean h16;
                    boolean u16;
                    QFSPublishFeedViewModel viewModel2;
                    QFSPublishFeedViewModel viewModel3;
                    View view;
                    Intrinsics.checkNotNullParameter(bubble, "bubble");
                    QLog.d(PlusEntryBubbleComposer.this.d(), 1, "showNewUserTip, onSuccess callback ");
                    h16 = PlusEntryBubbleComposer.this.h();
                    if (h16) {
                        u16 = PlusEntryBubbleComposer.this.u();
                        if (!u16) {
                            viewModel2 = PlusEntryBubbleComposer.this.g();
                            Intrinsics.checkNotNullExpressionValue(viewModel2, "viewModel");
                            int[] e16 = ap.e(viewModel2);
                            viewModel3 = PlusEntryBubbleComposer.this.g();
                            Intrinsics.checkNotNullExpressionValue(viewModel3, "viewModel");
                            int[] d16 = ap.d(viewModel3);
                            view = PlusEntryBubbleComposer.this.anchorView;
                            bubble.d(view, e16[0], e16[1], d16[0], d16[1]);
                            return;
                        }
                        QLog.d(PlusEntryBubbleComposer.this.d(), 1, "showNewUserTip, onSuccess callback, other panel is showing ");
                        return;
                    }
                    QLog.d(PlusEntryBubbleComposer.this.d(), 1, "showNewUserTip, onSuccess callback, part is not resume ");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void x(final QFSFeedBubbleInfo bubbleInfo) {
        if (!v()) {
            QLog.d(d(), 1, "showPublishTip, is not enable ");
            return;
        }
        QLog.d(d(), 1, "showPublishTip, bubbleInfo: " + bubbleInfo);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (this.anchorView != null) {
            QFSPublishFeedBubble.Companion companion = QFSPublishFeedBubble.INSTANCE;
            Context context = c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ap apVar = ap.f90138a;
            QFSPublishFeedViewModel viewModel = g();
            Intrinsics.checkNotNullExpressionValue(viewModel, "viewModel");
            QFSPublishFeedBubble a16 = companion.a(context, bubbleInfo, apVar.a(viewModel), new Function1<QFSPublishFeedBubble, Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$showPublishTip$1$1

                /* JADX INFO: Access modifiers changed from: package-private */
                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$showPublishTip$1$1$1", f = "PlusEntryBubbleComposer.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$showPublishTip$1$1$1, reason: invalid class name */
                /* loaded from: classes4.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ PlusEntryBubbleComposer this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(PlusEntryBubbleComposer plusEntryBubbleComposer, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = plusEntryBubbleComposer;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        Object coroutine_suspended;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i3 = this.label;
                        if (i3 != 0) {
                            if (i3 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        this.this$0.t();
                        return Unit.INSTANCE;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QFSPublishFeedBubble qFSPublishFeedBubble) {
                    invoke2(qFSPublishFeedBubble);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r0v9, types: [T, kotlinx.coroutines.Job] */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QFSPublishFeedBubble bubble) {
                    boolean h16;
                    QFSPublishFeedViewModel viewModel2;
                    QFSPublishFeedViewModel viewModel3;
                    View view;
                    ?? launch$default;
                    Intrinsics.checkNotNullParameter(bubble, "bubble");
                    QLog.d(PlusEntryBubbleComposer.this.d(), 1, "showPublishTip, onSuccess callback ");
                    h16 = PlusEntryBubbleComposer.this.h();
                    if (h16) {
                        ap apVar2 = ap.f90138a;
                        viewModel2 = PlusEntryBubbleComposer.this.g();
                        Intrinsics.checkNotNullExpressionValue(viewModel2, "viewModel");
                        int[] c16 = apVar2.c(viewModel2);
                        viewModel3 = PlusEntryBubbleComposer.this.g();
                        Intrinsics.checkNotNullExpressionValue(viewModel3, "viewModel");
                        int[] b16 = apVar2.b(viewModel3, bubbleInfo.getShowType());
                        view = PlusEntryBubbleComposer.this.anchorView;
                        bubble.d(view, c16[0], c16[1], b16[0], b16[1]);
                        Ref.ObjectRef<Job> objectRef2 = objectRef;
                        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass1(PlusEntryBubbleComposer.this, null), 3, null);
                        objectRef2.element = launch$default;
                        e eVar = e.f93946a;
                        eVar.B(101, bubbleInfo.getAdId(), bubbleInfo.getTraceInfo());
                        eVar.k(new DTBubbleInfo(bubbleInfo.getTitle(), bubbleInfo.getAdId(), ""));
                        PlusEntryBubbleComposer.INSTANCE.b(bubbleInfo.getAdId());
                    }
                }
            }, new Function0<Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$showPublishTip$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    QFSPublishFeedViewModel g16;
                    Context context2;
                    QFSPublishFeedViewModel g17;
                    QLog.d(PlusEntryBubbleComposer.this.d(), 1, "showPublishTip, onBubbleClick callback ");
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    QFSFeedBubbleInfo qFSFeedBubbleInfo = bubbleInfo;
                    linkedHashMap.put("xsj_resource_type", "2");
                    linkedHashMap.put("xsj_guide_text", qFSFeedBubbleInfo.getTitle());
                    linkedHashMap.put("xsj_tianshu_task_id", qFSFeedBubbleInfo.getAdId());
                    g16 = PlusEntryBubbleComposer.this.g();
                    context2 = PlusEntryBubbleComposer.this.c();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    String jumpUrl = bubbleInfo.getJumpUrl();
                    g17 = PlusEntryBubbleComposer.this.g();
                    g16.h2(context2, jumpUrl, g17.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String(), linkedHashMap);
                    e eVar = e.f93946a;
                    eVar.B(102, bubbleInfo.getAdId(), bubbleInfo.getTraceInfo());
                    eVar.j(new DTBubbleInfo(bubbleInfo.getTitle(), bubbleInfo.getAdId(), ""));
                }
            });
            a16.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.a
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    PlusEntryBubbleComposer.y(Ref.ObjectRef.this, this);
                }
            });
            this.publishTip = a16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Ref.ObjectRef job, PlusEntryBubbleComposer this$0) {
        Intrinsics.checkNotNullParameter(job, "$job");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Job job2 = (Job) job.element;
        if (job2 != null && job2.isActive()) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this$0.g().I2(false);
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void a() {
        super.a();
        Observer<oa0.a<BubbleUIData>> observer = this.newUserTipObserver;
        if (observer != null) {
            g().c2().removeObserver(observer);
        }
        Observer<oa0.a<BubbleUIData>> observer2 = this.publishTipObserver;
        if (observer2 != null) {
            g().f2().removeObserver(observer2);
        }
        s();
        t();
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer, com.tencent.biz.qqcircle.publish.plusentry.composer.a
    public void b() {
        super.b();
        LiveData<oa0.a<BubbleUIData>> c26 = g().c2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        b bVar = new b(new Function1<BubbleUIData, Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$startInit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull BubbleUIData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QLog.d(PlusEntryBubbleComposer.this.d(), 1, "newUserTipLiveData data changed, it:" + it);
                if (it.getShow()) {
                    PlusEntryBubbleComposer.this.s();
                    PlusEntryBubbleComposer.this.w();
                } else {
                    PlusEntryBubbleComposer.this.s();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BubbleUIData bubbleUIData) {
                invoke2(bubbleUIData);
                return Unit.INSTANCE;
            }
        });
        this.newUserTipObserver = bVar;
        Unit unit = Unit.INSTANCE;
        c26.observe(lifecycleOwner, bVar);
        LiveData<oa0.a<BubbleUIData>> f26 = g().f2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        b bVar2 = new b(new Function1<BubbleUIData, Unit>() { // from class: com.tencent.biz.qqcircle.publish.plusentry.composer.bubble.PlusEntryBubbleComposer$startInit$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull BubbleUIData it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QLog.d(PlusEntryBubbleComposer.this.d(), 1, "publishTipLiveData data changed, it:" + it);
                if (it.getShow()) {
                    PlusEntryBubbleComposer.this.t();
                    PlusEntryBubbleComposer.this.x(it.getBubbleInfo());
                } else {
                    PlusEntryBubbleComposer.this.t();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BubbleUIData bubbleUIData) {
                invoke2(bubbleUIData);
                return Unit.INSTANCE;
            }
        });
        this.publishTipObserver = bVar2;
        f26.observe(lifecycleOwner2, bVar2);
    }

    @Override // com.tencent.biz.qqcircle.publish.plusentry.composer.BasePlusEntryComposer
    @NotNull
    public String d() {
        return "PlusEntry-PlusEntryBubbleComposer";
    }

    public final void s() {
        if (!v()) {
            QLog.d(d(), 1, "hideNewUserTip, is not enable ");
            return;
        }
        QLog.d(d(), 1, "hideNewUserTip ");
        QFSPublishPagBubble qFSPublishPagBubble = this.newUserTip;
        if (qFSPublishPagBubble != null && qFSPublishPagBubble.isShowing()) {
            qFSPublishPagBubble.dismiss();
        }
    }

    public final void t() {
        if (!v()) {
            QLog.d(d(), 1, "hidePublishTip, is not enable ");
            return;
        }
        QLog.d(d(), 1, "hidePublishTip ");
        QFSPublishFeedBubble qFSPublishFeedBubble = this.publishTip;
        if (qFSPublishFeedBubble != null && qFSPublishFeedBubble.isShowing()) {
            qFSPublishFeedBubble.dismiss();
        }
        f91693l = "";
    }
}
