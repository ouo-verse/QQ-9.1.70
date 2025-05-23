package com.tencent.mobileqq.guild.feed.video;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.video.GuidePopBuilder;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/g;", "Lcom/tencent/mobileqq/guild/feed/video/f;", "", "contentStr", "Lcom/tencent/mobileqq/widget/tip/a;", "e", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder$ArrowDirect;", "arrowDirect", "", "i", "Landroid/view/View;", tl.h.F, "f", "Landroid/content/Context;", "context", "", "d", "", QZoneImageUtils.KEY_MATCH, "b", "a", "dismiss", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder;", "Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder;", "g", "()Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/widget/tip/a;", "bubbleTip", "<init>", "(Lcom/tencent/mobileqq/guild/feed/video/GuidePopBuilder;)V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuidePopBuilder config;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.tip.a bubbleTip;

    public g(@NotNull GuidePopBuilder config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Context context) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setText((ClipboardManager) systemService, null);
    }

    private final com.tencent.mobileqq.widget.tip.a e(String contentStr) {
        Context context;
        this.config.m(contentStr);
        View view = this.config.getPosInfo().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String();
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        com.tencent.mobileqq.widget.tip.a R = com.tencent.mobileqq.widget.tip.a.r(context).S(this.config.getPosInfo().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String()).c0(true).e0(true).a0(h()).k0(i(this.config.getArrowDirect())).b0(-1L).j0(10.0f, 10.0f, 10.0f, 10.0f).W(f()).R(0);
        Intrinsics.checkNotNullExpressionValue(R, "from(config.posInfo.pare\u2026p.Alignment.ALIGN_CENTER)");
        return R;
    }

    private final int f() {
        Resources resources = BaseApplication.context.getResources();
        if (resources != null) {
            return resources.getColor(R.color.qui_common_bg_top_light);
        }
        return -1;
    }

    private final View h() {
        Context context;
        View view = this.config.getPosInfo().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String();
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        x12.b g16 = x12.b.g(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
        g16.f446885b.setText(this.config.getContent());
        g16.f446885b.setMaxWidth(this.config.getBubbleMaxWidth());
        g16.f446886c.setText(this.config.getDsc());
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final int i(GuidePopBuilder.ArrowDirect arrowDirect) {
        if (arrowDirect == GuidePopBuilder.ArrowDirect.OnTop) {
            return 1;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.video.f
    public void a(@NotNull String contentStr) {
        Intrinsics.checkNotNullParameter(contentStr, "contentStr");
        if (this.config.getPosInfo().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String() == null) {
            QLog.e("VideoInsertBubbleTip", 1, "not specified parentView");
            return;
        }
        com.tencent.mobileqq.widget.tip.a e16 = e(contentStr);
        this.bubbleTip = e16;
        if (e16 != null) {
            e16.g0(false);
        }
        com.tencent.mobileqq.widget.tip.a aVar = this.bubbleTip;
        if (aVar != null) {
            aVar.f(new b());
        }
        com.tencent.mobileqq.widget.tip.a aVar2 = this.bubbleTip;
        if (aVar2 != null) {
            aVar2.s0();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.video.f
    @NotNull
    public String b(@NotNull String contentStr) {
        String invoke;
        Intrinsics.checkNotNullParameter(contentStr, "contentStr");
        Function1<String, String> i3 = this.config.i();
        if (i3 != null && (invoke = i3.invoke(contentStr)) != null) {
            return invoke;
        }
        return contentStr;
    }

    @Override // com.tencent.mobileqq.guild.feed.video.f
    public void dismiss() {
        com.tencent.mobileqq.widget.tip.a aVar = this.bubbleTip;
        if (aVar != null) {
            aVar.o();
        }
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final GuidePopBuilder getConfig() {
        return this.config;
    }

    @Override // com.tencent.mobileqq.guild.feed.video.f
    public boolean match(@NotNull String contentStr) {
        Intrinsics.checkNotNullParameter(contentStr, "contentStr");
        Function1<String, Boolean> g16 = this.config.g();
        if (g16 != null) {
            return g16.invoke(contentStr).booleanValue();
        }
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/video/g$b", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements a.b {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onClick(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            l53.d.a(this, v3);
            GuidePopBuilder.b clickCallback = g.this.getConfig().getClickCallback();
            if (clickCallback != null) {
                clickCallback.G0(g.this.getConfig().getContent());
            }
            g gVar = g.this;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            gVar.d(context);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* synthetic */ void onDismiss() {
            l53.d.b(this);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
        }
    }
}
