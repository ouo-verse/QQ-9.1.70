package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$dataReportManage$2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kn1.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl1.g;
import wk1.e;
import wk1.l;
import yl1.n;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\t*\u0002@E\b\u0016\u0018\u0000 K2\u00020\u0001:\u0001LB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\u001a\u001a\u0004\u0018\u00010\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010$R\"\u00101\u001a\u00020*8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001b\u0010?\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010<\u001a\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "O9", "initData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "M9", "", "args", "K9", "H9", "I9", "id", "J9", "L9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onInitView", "", "action", "handleBroadcastMessage", "getMessage", "Lwk1/d;", "d", "Lwk1/d;", "externalEventCooperateMediatorProvider", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "root", "f", "Ljava/lang/String;", "feedId", tl.h.F, "guildId", "i", "channelId", "Lal1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lal1/a;", "F9", "()Lal1/a;", "P9", "(Lal1/a;)V", "inputLayout", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "curSpeakPermission", "Lwk1/c;", "D", "Lwk1/c;", "externalEventCooperateMediator", "Lwk1/l;", "E", "Lkotlin/Lazy;", "G9", "()Lwk1/l;", "inputMessageDelegate", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart$dataReportManage$2$a", UserInfo.SEX_FEMALE, "E9", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart$dataReportManage$2$a;", "dataReportManage", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart$inputContextProvider$1", "G", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart$inputContextProvider$1;", "inputContextProvider", "<init>", "(Lwk1/d;)V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class BottomInteractivePart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private SpeakPermissionType curSpeakPermission;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private wk1.c externalEventCooperateMediator;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputMessageDelegate;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy dataReportManage;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final BottomInteractivePart$inputContextProvider$1 inputContextProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final wk1.d externalEventCooperateMediatorProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup root;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String feedId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String guildId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String channelId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected al1.a inputLayout;

    public BottomInteractivePart(@NotNull wk1.d externalEventCooperateMediatorProvider) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(externalEventCooperateMediatorProvider, "externalEventCooperateMediatorProvider");
        this.externalEventCooperateMediatorProvider = externalEventCooperateMediatorProvider;
        this.curSpeakPermission = SpeakPermissionType.PERMISSION_TYPE_INVALID;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$inputMessageDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                return new l(BottomInteractivePart.this);
            }
        });
        this.inputMessageDelegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<BottomInteractivePart$dataReportManage$2.a>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$dataReportManage$2

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart$dataReportManage$2$a", "Lwk1/e;", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements wk1.e {
                a() {
                }

                @Override // wk1.e
                public boolean a() {
                    return true;
                }

                @Override // wk1.e
                @Nullable
                public HashMap<String, Object> b() {
                    return e.a.a(this);
                }

                @Override // wk1.e
                public void c(@NotNull View view, int i3, @Nullable Bundle bundle) {
                    e.a.b(this, view, i3, bundle);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.dataReportManage = lazy2;
        this.inputContextProvider = new BottomInteractivePart$inputContextProvider$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BottomInteractivePart$dataReportManage$2.a E9() {
        return (BottomInteractivePart$dataReportManage$2.a) this.dataReportManage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l G9() {
        return (l) this.inputMessageDelegate.getValue();
    }

    private final void H9(Object args) {
        if (!(args instanceof qj1.b)) {
            return;
        }
        QLog.i("BottomInteractivePart", 1, "handleBottomInteractiveDataChanged");
        F9().E7((qj1.b) args);
    }

    private final void I9(Object args) {
        F9().lh("message_on_do_execute_like", null);
    }

    private final View J9(Object id5) {
        ViewGroup viewGroup = null;
        if (!(id5 instanceof Integer)) {
            return null;
        }
        ViewGroup viewGroup2 = this.root;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            viewGroup = viewGroup2;
        }
        return viewGroup.findViewById(((Number) id5).intValue());
    }

    private final void K9(Object args) {
        g.OnLoadMainCompletedMessage onLoadMainCompletedMessage;
        ViewGroup viewGroup = null;
        if (args instanceof g.OnLoadMainCompletedMessage) {
            onLoadMainCompletedMessage = (g.OnLoadMainCompletedMessage) args;
        } else {
            onLoadMainCompletedMessage = null;
        }
        if (onLoadMainCompletedMessage == null) {
            return;
        }
        QLog.i("BottomInteractivePart", 1, "handleLoadMainDataCompleted isSuccess=" + onLoadMainCompletedMessage.getIsSuccess() + " errorCode=" + onLoadMainCompletedMessage.getErrorCode() + ", isDb=" + onLoadMainCompletedMessage.getIsDbCache());
        if (!onLoadMainCompletedMessage.getIsDbCache()) {
            if (onLoadMainCompletedMessage.getIsSuccess()) {
                ViewGroup viewGroup2 = this.root;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                } else {
                    viewGroup = viewGroup2;
                }
                viewGroup.setVisibility(0);
                return;
            }
            ViewGroup viewGroup3 = this.root;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
            } else {
                viewGroup = viewGroup3;
            }
            viewGroup.setVisibility(8);
        }
    }

    private final void L9(Object args) {
        boolean z16 = true;
        if (!(args instanceof a.OnSpeakPermissionChangedMessage)) {
            QLog.e("BottomInteractivePart", 1, "handleSpeakPermissionChangedMessage args error!");
            return;
        }
        a.OnSpeakPermissionChangedMessage onSpeakPermissionChangedMessage = (a.OnSpeakPermissionChangedMessage) args;
        QLog.i("BottomInteractivePart", 1, "OnSpeakPermissionChanged " + onSpeakPermissionChangedMessage.getNewSpeakPermission());
        this.curSpeakPermission = onSpeakPermissionChangedMessage.getNewSpeakPermission();
        ViewGroup viewGroup = null;
        if (F9().N4(this.curSpeakPermission)) {
            al1.a F9 = F9();
            ViewGroup viewGroup2 = this.root;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
            } else {
                viewGroup = viewGroup2;
            }
            F9.D5(viewGroup, this.curSpeakPermission);
            al1.a F92 = F9();
            GuildFeedPublishInfo q16 = n.q(GuildSplitViewUtils.f235370a.h(getPartHost()));
            if (q16 != null) {
                z16 = com.tencent.mobileqq.guild.feed.feedsquare.data.g.d(q16);
            }
            F92.u1(z16);
            return;
        }
        al1.a F93 = F9();
        ViewGroup viewGroup3 = this.root;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
        } else {
            viewGroup = viewGroup3;
        }
        F93.zc(viewGroup, this.curSpeakPermission);
    }

    private final void M9(View rootView) {
        if (rootView == null) {
            return;
        }
        View findViewById = rootView.findViewById(R.id.v1n);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BottomInteractivePart.N9(view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026h upwardly */ }\n        }");
        this.root = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O9() {
        final String mainTaskId;
        GuildFeedPublishInfo q16 = n.q(GuildSplitViewUtils.f235370a.h(getPartHost()));
        if (q16 != null && (mainTaskId = q16.getMainTaskId()) != null) {
            final Flow<a.FeedPublishFinish> publishEndFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishEndFlow();
            FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishFinish>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$onFeedPublishObserve$lambda$1$$inlined$filter$1

                @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
                /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$onFeedPublishObserve$lambda$1$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishFinish> {

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ FlowCollector f220620d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f220621e;

                    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                    @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$onFeedPublishObserve$lambda$1$$inlined$filter$1$2", f = "BottomInteractivePart.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart$onFeedPublishObserve$lambda$1$$inlined$filter$1$2$1, reason: invalid class name */
                    /* loaded from: classes13.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, String str) {
                        this.f220620d = flowCollector;
                        this.f220621e = str;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    @Nullable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public Object emit(a.FeedPublishFinish feedPublishFinish, @NotNull Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        Object coroutine_suspended;
                        int i3;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i16 = anonymousClass1.label;
                            if ((i16 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                                Object obj = anonymousClass1.result;
                                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i3 = anonymousClass1.label;
                                if (i3 == 0) {
                                    if (i3 == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    FlowCollector flowCollector = this.f220620d;
                                    if (Intrinsics.areEqual(feedPublishFinish.getState().getTaskId(), this.f220621e)) {
                                        anonymousClass1.label = 1;
                                        if (flowCollector.emit(feedPublishFinish, anonymousClass1) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj2 = anonymousClass1.result;
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i3 = anonymousClass1.label;
                        if (i3 == 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                @Nullable
                public Object collect(@NotNull FlowCollector<? super a.FeedPublishFinish> flowCollector, @NotNull Continuation continuation) {
                    Object coroutine_suspended;
                    Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, mainTaskId), continuation);
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (collect == coroutine_suspended) {
                        return collect;
                    }
                    return Unit.INSTANCE;
                }
            }, new BottomInteractivePart$onFeedPublishObserve$1$2(this, null)), com.tencent.mobileqq.guild.feed.part.a.d(this));
        }
    }

    private final void initData() {
        Bundle h16 = GuildSplitViewUtils.f235370a.h(getPartHost());
        String str = "";
        String string = h16.getString("feed_id", "");
        if (string == null) {
            string = "";
        }
        this.feedId = string;
        String string2 = h16.getString("guild_id", "");
        if (string2 == null) {
            string2 = "";
        }
        this.guildId = string2;
        String string3 = h16.getString("channel_id", "");
        if (string3 != null) {
            str = string3;
        }
        this.channelId = str;
        P9(new bl1.c(this.inputContextProvider));
        F9().V4();
        this.externalEventCooperateMediator = this.externalEventCooperateMediatorProvider.a(this.inputContextProvider);
        Lifecycle lifecycle = getPartHost().getLifecycleOwner().getLifecycle();
        wk1.c cVar = this.externalEventCooperateMediator;
        Intrinsics.checkNotNull(cVar);
        lifecycle.addObserver(cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final al1.a F9() {
        al1.a aVar = this.inputLayout;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputLayout");
        return null;
    }

    protected final void P9(@NotNull al1.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.inputLayout = aVar;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "message_find_view_by_id")) {
            return J9(args);
        }
        if (Intrinsics.areEqual(action, "message_get_join_guild_sign")) {
            return GuildSplitViewUtils.f235370a.h(getPartHost()).getParcelable("join_info_param");
        }
        return super.getMessage(action, args);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r3.equals("message_on_main_reload_complete") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        if (r3.equals("message_on_load_main_completed") == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002c, code lost:
    
        K9(r4);
     */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        wk1.c cVar;
        if (action != null) {
            switch (action.hashCode()) {
                case -1805329813:
                    if (action.equals("message_on_bottom_interactive_changed")) {
                        H9(args);
                        break;
                    }
                    break;
                case 69131257:
                    if (action.equals("message_on_speak_permission_changed")) {
                        L9(args);
                        break;
                    }
                    break;
                case 149718143:
                    if (action.equals("message_update_hint_when_dismiss")) {
                        F9().lh("message_update_hint_when_dismiss", args);
                        break;
                    }
                    break;
                case 159204545:
                    break;
                case 226038317:
                    if (action.equals("message_on_do_execute_like")) {
                        I9(args);
                        break;
                    }
                    break;
                case 329916566:
                    break;
            }
        }
        if (action != null && (cVar = this.externalEventCooperateMediator) != null) {
            cVar.c(action, args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initData();
        M9(rootView);
        O9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this.inputContextProvider, wk1.h.class);
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this.inputContextProvider.getDelegate(), wk1.i.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), wk1.h.class);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), wk1.i.class);
    }
}
