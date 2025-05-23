package com.tencent.mobileqq.guild.feed.detail.guidebar;

import android.os.Bundle;
import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleOwner;
import co1.k;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.detail.guidebar.FeedDetailWebPageGuideBarDependencyImpl;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.base.GuideBarGuildInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI;
import com.tencent.mobileqq.guild.ipc.methods.aj;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.util.y;
import com.tencent.mobileqq.guild.webview.methods.AddGuildMethod;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import tl1.e;
import wk1.g;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007\u00a2\u0006\u0004\b3\u00104J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00138\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010&\u001a\u0004\u0018\u00010\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010)\u001a\u00020'8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010(R\u0014\u0010*\u001a\u00020\u00138VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0016R\u0014\u0010.\u001a\u00020+8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/detail/guidebar/FeedDetailWebPageGuideBarDependencyImpl;", "Lwk1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "o", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "a", "Landroidx/core/util/Supplier;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedDetailInitBean;", "f", "Landroidx/core/util/Supplier;", "beanProvider", "Landroidx/lifecycle/LifecycleOwner;", h.F, "viewLifecycleOwnerProvider", "Lwk1/g$a;", "i", "Lwk1/g$a;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "()Z", "isMemberSync", "Lwk1/g;", BdhLogUtil.LogTag.Tag_Conn, "Lwk1/g;", "d", "()Lwk1/g;", "guildOperationDelegate", "Lco1/k;", "D", "Lkotlin/Lazy;", "e", "()Lco1/k;", "reportDelegate", "g", "()Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "", "()I", "sourceBusinessType", "isExperiment", "", "c", "()Ljava/lang/String;", "guildId", "", "p", "()Ljava/lang/Void;", "colorConfig", "<init>", "(Landroidx/core/util/Supplier;Landroidx/core/util/Supplier;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedDetailWebPageGuideBarDependencyImpl extends wk1.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final g guildOperationDelegate;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy reportDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<GuildFeedDetailInitBean> beanProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<LifecycleOwner> viewLifecycleOwnerProvider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g.a callback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final boolean isMemberSync;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Leipc/EIPCResult;", "kotlin.jvm.PlatformType", "onCallback"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<GuideBarGuildInfo> f218488d;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super GuideBarGuildInfo> cancellableContinuation) {
            this.f218488d = cancellableContinuation;
        }

        @Override // eipc.EIPCResultCallback
        public final void onCallback(EIPCResult eIPCResult) {
            CancellableContinuation<GuideBarGuildInfo> cancellableContinuation = this.f218488d;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m476constructorimpl(eIPCResult.data.getParcelable("guild_guide_bar_info")));
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/detail/guidebar/FeedDetailWebPageGuideBarDependencyImpl$b", "Lwk1/g;", "", "result", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityInfo", "", "e", "Lwk1/g$a;", "callback", "c", "b", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements g {
        b() {
        }

        private final void e(int result, IGProSecurityResult securityInfo) {
            g.a aVar;
            if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(result, securityInfo) && (aVar = FeedDetailWebPageGuideBarDependencyImpl.this.callback) != null) {
                aVar.f((short) 1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(FeedDetailWebPageGuideBarDependencyImpl this$0, b this$1, EIPCResult eIPCResult) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (Intrinsics.areEqual(eIPCResult.data.getString("guildId"), this$0.c())) {
                Bundle bundle = eIPCResult.data;
                if (bundle == null) {
                    bundle = Bundle.EMPTY;
                }
                AddGuildMethod.AddGuildResult fromIpcResult = AddGuildMethod.AddGuildResult.fromIpcResult(bundle);
                this$1.e(fromIpcResult.result, SecurityTipHelperKt.f(fromIpcResult.strPrompt, fromIpcResult.strDetail, fromIpcResult.actionCode));
            }
        }

        @Override // wk1.g
        public void a() {
            JumpGuildParam.JoinInfoParam joinInfoParam = ((GuildFeedDetailInitBean) FeedDetailWebPageGuideBarDependencyImpl.this.beanProvider.get()).getJoinInfoParam();
            if (joinInfoParam == null) {
                QLog.e("BottomGuideBar", 1, "openGuild but missing joinInfoParam");
            } else {
                y.g(aj.class, 0, new JumpGuildParam(FeedDetailWebPageGuideBarDependencyImpl.this.c(), "", joinInfoParam));
            }
        }

        @Override // wk1.g
        public void b() {
            JumpGuildParam.JoinInfoParam joinInfoParam = ((GuildFeedDetailInitBean) FeedDetailWebPageGuideBarDependencyImpl.this.beanProvider.get()).getJoinInfoParam();
            if (joinInfoParam == null) {
                QLog.e("BottomGuideBar", 1, "joinGuild but missing joinInfoParam");
            } else {
                final FeedDetailWebPageGuideBarDependencyImpl feedDetailWebPageGuideBarDependencyImpl = FeedDetailWebPageGuideBarDependencyImpl.this;
                y.b(com.tencent.mobileqq.guild.ipc.methods.b.class, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.feed.detail.guidebar.a
                    @Override // eipc.EIPCResultCallback
                    public final void onCallback(EIPCResult eIPCResult) {
                        FeedDetailWebPageGuideBarDependencyImpl.b.f(FeedDetailWebPageGuideBarDependencyImpl.this, this, eIPCResult);
                    }
                }, FeedDetailWebPageGuideBarDependencyImpl.this.c(), joinInfoParam.getJoinSignature(), joinInfoParam.getMainSource(), joinInfoParam.getSubSource(), Integer.valueOf(joinInfoParam.getPageEntranceId()));
            }
        }

        @Override // wk1.g
        public void c(@Nullable g.a callback) {
            FeedDetailWebPageGuideBarDependencyImpl.this.callback = callback;
        }
    }

    public FeedDetailWebPageGuideBarDependencyImpl(@NotNull Supplier<GuildFeedDetailInitBean> beanProvider, @NotNull Supplier<LifecycleOwner> viewLifecycleOwnerProvider) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(beanProvider, "beanProvider");
        Intrinsics.checkNotNullParameter(viewLifecycleOwnerProvider, "viewLifecycleOwnerProvider");
        this.beanProvider = beanProvider;
        this.viewLifecycleOwnerProvider = viewLifecycleOwnerProvider;
        this.guildOperationDelegate = new b();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<k>() { // from class: com.tencent.mobileqq.guild.feed.detail.guidebar.FeedDetailWebPageGuideBarDependencyImpl$reportDelegate$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                return NavigatorUI.INSTANCE.a();
            }
        });
        this.reportDelegate = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object o(Continuation<? super GuideBarGuildInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).asyncCallGetSimpleDataMethod("get_guild_guide_bar_info", new a(cancellableContinuationImpl), c());
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // wk1.a
    @NotNull
    public Flow<GuideBarGuildInfo> a() {
        return FlowKt.callbackFlow(new FeedDetailWebPageGuideBarDependencyImpl$fetchGuildInfoModels$1(this, null));
    }

    @Override // wk1.a
    public /* bridge */ /* synthetic */ int[] b() {
        return (int[]) p();
    }

    @Override // wk1.a
    @NotNull
    public String c() {
        String guildId = this.beanProvider.get().getGuildId();
        if (guildId == null) {
            return "";
        }
        return guildId;
    }

    @Override // wk1.a
    @NotNull
    /* renamed from: d, reason: from getter */
    public g getGuildOperationDelegate() {
        return this.guildOperationDelegate;
    }

    @Override // wk1.a
    @NotNull
    public k e() {
        return (k) this.reportDelegate.getValue();
    }

    @Override // wk1.a
    public int f() {
        return this.beanProvider.get().getBusinessType();
    }

    @Override // wk1.a
    @Nullable
    public LifecycleOwner g() {
        return this.viewLifecycleOwnerProvider.get();
    }

    @Override // wk1.a
    public boolean h() {
        return e.f436522a.a(true)[0];
    }

    @Override // wk1.a
    /* renamed from: i, reason: from getter */
    public boolean getIsMemberSync() {
        return this.isMemberSync;
    }

    @Nullable
    public Void p() {
        return null;
    }
}
