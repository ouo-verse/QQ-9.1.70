package com.tencent.mobileqq.guild.feed.gallery.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001)B\u001d\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0012H\u0016J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryPageContentView;", "Landroid/widget/FrameLayout;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "callback", "", "e", "Lfk1/b;", "adapter", "setViewPagerAdapter", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f", "", "d", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "smoothScroll", "setViewPagerCurrentItem", "Landroid/view/MotionEvent;", NodeProps.ON_INTERCEPT_TOUCH_EVENT, NodeProps.VISIBLE, "setPageMaskVisible", "setViewPagerFakeCurrentItem", "Landroidx/viewpager2/widget/ViewPager2;", "c", "Landroid/view/View;", "Landroid/view/View;", "mRootView", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "mMaskLayout", tl.h.F, "Lfk1/b;", "mAdapter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryPageContentView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewPager2 viewPager2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mMaskLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private fk1.b mAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryPageContentView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Ref.IntRef preValue, GuildFeedGalleryPageContentView this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(preValue, "$preValue");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.viewPager2.fakeDragBy(preValue.element - intValue);
        preValue.element = intValue;
    }

    public static /* synthetic */ void setViewPagerCurrentItem$default(GuildFeedGalleryPageContentView guildFeedGalleryPageContentView, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        guildFeedGalleryPageContentView.setViewPagerCurrentItem(i3, z16);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final ViewPager2 getViewPager2() {
        return this.viewPager2;
    }

    public final int d() {
        return this.viewPager2.getCurrentItem();
    }

    public final void e(@NotNull ViewPager2.OnPageChangeCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.viewPager2.setOffscreenPageLimit(1);
        this.viewPager2.setOrientation(1);
        this.viewPager2.setPageTransformer(new CompositePageTransformer());
        this.viewPager2.registerOnPageChangeCallback(callback);
    }

    public final void f(@Nullable Activity activity) {
        this.viewPager2.setAdapter(null);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        return super.onInterceptTouchEvent(e16);
    }

    public final void setPageMaskVisible(int visible) {
        this.mMaskLayout.setVisibility(visible);
    }

    public final void setViewPagerAdapter(@NotNull fk1.b adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mAdapter = adapter;
        this.viewPager2.setAdapter(adapter);
    }

    public final void setViewPagerCurrentItem(int item, boolean smoothScroll) {
        this.viewPager2.setCurrentItem(item, smoothScroll);
    }

    public final void setViewPagerFakeCurrentItem() {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.viewPager2.getHeight() / 2);
        final Ref.IntRef intRef = new Ref.IntRef();
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.gallery.widget.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildFeedGalleryPageContentView.g(Ref.IntRef.this, this, valueAnimator);
            }
        });
        ofInt.addListener(new b());
        ofInt.setInterpolator(new com.tencent.mobileqq.widget.g());
        ofInt.setDuration(200L);
        ofInt.start();
    }

    public /* synthetic */ GuildFeedGalleryPageContentView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildFeedGalleryPageContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.eoc, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(context, R.layou\u2026y_page_view_layout, this)");
        this.mRootView = inflate;
        View findViewById = inflate.findViewById(R.id.w9o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026.guild_feed_gallery_list)");
        this.viewPager2 = (ViewPager2) findViewById;
        View findViewById2 = inflate.findViewById(R.id.w9_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026feed_gallery_bottom_mask)");
        this.mMaskLayout = findViewById2;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedGalleryPageContentView$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildFeedGalleryPageContentView.this.viewPager2.endFakeDrag();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            GuildFeedGalleryPageContentView.this.viewPager2.beginFakeDrag();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }
    }
}
