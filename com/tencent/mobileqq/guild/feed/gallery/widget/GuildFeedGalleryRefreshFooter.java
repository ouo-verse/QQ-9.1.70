package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshKernel;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.constant.RefreshState;
import com.tencent.richframework.widget.refresh.layout.constant.SpinnerStyle;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import com.tencent.util.LoadingUtil;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001CB'\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0006\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J \u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\n \u000e*\u0004\u0018\u00010\r0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0016J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J0\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J \u0010#\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J \u0010$\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J \u0010(\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0016J\u0014\u0010-\u001a\u00020\u00032\n\u0010,\u001a\u00020+\"\u00020\u0006H\u0016J\u0010\u00100\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010.R\u0018\u00103\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryRefreshFooter;", "Landroid/widget/FrameLayout;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "", "c", "e", "", "duration", "", "dragRate", "", "animationOnly", "autoOpen", "Lcom/tencent/richframework/widget/refresh/layout/constant/SpinnerStyle;", "kotlin.jvm.PlatformType", "getSpinnerStyle", "b", "isSupportHorizontalDrag", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshLayout;", "refreshLayout", "success", "onFinish", "percentX", "offsetX", "offsetMax", "onHorizontalDrag", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshKernel;", "kernel", "height", "maxDragHeight", "onInitialized", "isDragging", "percent", "offset", "onMoving", "onReleased", "onStartAnimator", "Lcom/tencent/richframework/widget/refresh/layout/constant/RefreshState;", "oldState", "newState", "onStateChanged", "noMoreData", "setNoMoreData", "", NodeProps.COLORS, "setPrimaryColors", "Lcom/tencent/richframework/widget/refresh/layout/listener/OnLoadMoreListener;", "callback", "setOnLoadMoreFinishListener", "d", "Lcom/tencent/richframework/widget/refresh/layout/listener/OnLoadMoreListener;", "outLoadMoreCallback", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "innerLoadingView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "innerLoadingTips", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"RestrictedApi"})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryRefreshFooter extends FrameLayout implements IRefreshFooter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private OnLoadMoreListener outLoadMoreCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView innerLoadingView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView innerLoadingTips;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f219840a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.PullUpToLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshState.ReleaseToRefresh.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RefreshState.Refreshing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f219840a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryRefreshFooter(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        this.innerLoadingView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(boolean z16, GuildFeedGalleryRefreshFooter this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        this$0.innerLoadingTips.setVisibility(i3);
        this$0.innerLoadingView.setVisibility(i3);
    }

    private final void e() {
        this.innerLoadingView.setImageResource(R.drawable.guild_loading_white);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean autoOpen(int duration, float dragRate, boolean animationOnly) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild_Feed_GAL_GuildFeedGalleryRefreshFooter", 2, "autoOpen(" + duration + ", " + dragRate + ", " + animationOnly + ")");
            return false;
        }
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    /* renamed from: getSpinnerStyle */
    public SpinnerStyle getFooterSpinnerStyle() {
        return SpinnerStyle.FixedBehind;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public int onFinish(@NotNull IRefreshLayout refreshLayout, boolean success) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryRefreshFooter", 1, "onFinish " + refreshLayout + ", " + success);
        e();
        return 0;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryRefreshFooter", 1, "onHorizontalDrag " + percentX + ", " + offsetX + ", " + offsetMax);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onInitialized(@NotNull IRefreshKernel kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryRefreshFooter", 1, "onInitialized " + kernel + ", " + height + ", " + maxDragHeight);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onReleased(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryRefreshFooter", 1, "onReleased " + refreshLayout + ", " + height + ", " + maxDragHeight);
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onStartAnimator(@NotNull IRefreshLayout refreshLayout, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Logger.f235387a.d().d("Guild_Feed_GAL_GuildFeedGalleryRefreshFooter", 1, "onStartAnimator " + refreshLayout + ", " + height + ", " + maxDragHeight);
        c();
    }

    @Override // com.tencent.richframework.widget.refresh.layout.listener.OnStateChangedListener
    public void onStateChanged(@NotNull IRefreshLayout refreshLayout, @NotNull RefreshState oldState, @NotNull RefreshState newState) {
        OnLoadMoreListener onLoadMoreListener;
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild_Feed_GAL_GuildFeedGalleryRefreshFooter", 2, "onStateChanged " + refreshLayout + ", " + oldState + ", " + newState);
        }
        int i3 = b.f219840a[newState.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4) {
                c();
            }
        } else {
            e();
        }
        if (oldState == RefreshState.LoadFinish && newState == RefreshState.None && (onLoadMoreListener = this.outLoadMoreCallback) != null) {
            onLoadMoreListener.onLoadMore(refreshLayout);
        }
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter
    public boolean setNoMoreData(final boolean noMoreData) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryRefreshFooter.d(noMoreData, this);
            }
        });
        return true;
    }

    public final void setOnLoadMoreFinishListener(@Nullable OnLoadMoreListener callback) {
        this.outLoadMoreCallback = callback;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void setPrimaryColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildFeedGalleryRefreshFooter(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryRefreshFooter(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.eoe, this);
        View findViewById = findViewById(R.id.v2l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.feed_gallery_refresh_loading)");
        this.innerLoadingView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.v2m);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_gallery_refresh_tips)");
        this.innerLoadingTips = (TextView) findViewById2;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public GuildFeedGalleryRefreshFooter getView() {
        return this;
    }

    @Override // com.tencent.richframework.widget.refresh.layout.api.IRefreshComponent
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
    }
}
