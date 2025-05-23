package com.tencent.mobileqq.guild.feed.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 32\u00020\u0001:\u00014B)\b\u0007\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\t\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0002R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/GuildFeedTopItemLayout;", "Landroid/widget/RelativeLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "g", DomainData.DOMAIN_NAME, "Lij1/h;", "feedTopData", "", "position", "size", "", "isFold", tl.h.F, "f", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "itemGroupTag", "Lcom/airbnb/lottie/LottieAnimationView;", "e", "Lcom/airbnb/lottie/LottieAnimationView;", "itemGroupAminView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "itemLabel", "itemTitle", "i", "itemArrow", "Lsn1/b;", "Lsn1/b;", "getOnItemClickListener", "()Lsn1/b;", "setOnItemClickListener", "(Lsn1/b;)V", "onItemClickListener", BdhLogUtil.LogTag.Tag_Conn, "Z", "getAnimRepeat", "()Z", "setAnimRepeat", "(Z)V", "animRepeat", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedTopItemLayout extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean animRepeat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView itemGroupTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView itemGroupAminView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView itemLabel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView itemTitle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView itemArrow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private sn1.b onItemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/widget/GuildFeedTopItemLayout$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            LottieAnimationView lottieAnimationView = GuildFeedTopItemLayout.this.itemGroupAminView;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(8);
            ImageView imageView2 = GuildFeedTopItemLayout.this.itemGroupTag;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupTag");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            LottieAnimationView lottieAnimationView = GuildFeedTopItemLayout.this.itemGroupAminView;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(8);
            ImageView imageView2 = GuildFeedTopItemLayout.this.itemGroupTag;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupTag");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @JvmOverloads
    public GuildFeedTopItemLayout(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    private final void g() {
        TextView textView = this.itemArrow;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
            textView = null;
        }
        com.tencent.mobileqq.guild.feed.report.d.d(textView, "em_sgrp_forum_toppost_pulldown", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_ALL, EndExposurePolicy.REPORT_ALL, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(GuildFeedTopItemLayout this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        sn1.b bVar = this$0.onItemClickListener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.a(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildFeedTopItemLayout this$0, ij1.h feedTopData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feedTopData, "$feedTopData");
        sn1.b bVar = this$0.onItemClickListener;
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            bVar.b(view, feedTopData);
        }
        this$0.n();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k() {
        LottieAnimationView lottieAnimationView = this.itemGroupAminView;
        LottieAnimationView lottieAnimationView2 = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setAnimation("guild_feed/feed_top/announcement.json");
        LottieAnimationView lottieAnimationView3 = this.itemGroupAminView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
            lottieAnimationView3 = null;
        }
        lottieAnimationView3.addAnimatorListener(new b());
        LottieAnimationView lottieAnimationView4 = this.itemGroupAminView;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
        } else {
            lottieAnimationView2 = lottieAnimationView4;
        }
        lottieAnimationView2.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.feed.widget.k
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildFeedTopItemLayout.l(GuildFeedTopItemLayout.this, valueAnimator);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildFeedTopItemLayout this$0, ValueAnimator valueAnimator) {
        Float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.animRepeat && valueAnimator != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            LottieAnimationView lottieAnimationView = null;
            if (animatedValue instanceof Float) {
                f16 = (Float) animatedValue;
            } else {
                f16 = null;
            }
            if (f16 != null && f16.floatValue() > 0.64f) {
                this$0.animRepeat = false;
                LottieAnimationView lottieAnimationView2 = this$0.itemGroupAminView;
                if (lottieAnimationView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
                } else {
                    lottieAnimationView = lottieAnimationView2;
                }
                lottieAnimationView.setProgress(0.0f);
            }
        }
    }

    private final void m() {
        LayoutInflater.from(getContext()).inflate(R.layout.f9_, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.v3x);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.feed_top_item_group_tag)");
        this.itemGroupTag = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.v3w);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.feed_top_item_group_anim_view)");
        this.itemGroupAminView = (LottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R.id.v3y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.feed_top_item_label)");
        this.itemLabel = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.f165192v41);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.feed_top_item_title)");
        this.itemTitle = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.v3z);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.feed_top_item_num_arrow)");
        this.itemArrow = (TextView) findViewById5;
        setBackgroundResource(R.drawable.guild_feed_top_item_bg_selector);
        k();
    }

    private final void n() {
        LottieAnimationView lottieAnimationView = this.itemGroupAminView;
        ImageView imageView = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
            lottieAnimationView = null;
        }
        if (lottieAnimationView.isAnimating()) {
            LottieAnimationView lottieAnimationView2 = this.itemGroupAminView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.cancelAnimation();
            LottieAnimationView lottieAnimationView3 = this.itemGroupAminView;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
                lottieAnimationView3 = null;
            }
            lottieAnimationView3.setVisibility(8);
            ImageView imageView2 = this.itemGroupTag;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupTag");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
        }
    }

    public final void f() {
        LottieAnimationView lottieAnimationView = this.itemGroupAminView;
        ImageView imageView = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
            lottieAnimationView = null;
        }
        if (lottieAnimationView.isAnimating()) {
            LottieAnimationView lottieAnimationView2 = this.itemGroupAminView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.cancelAnimation();
        }
        this.animRepeat = true;
        LottieAnimationView lottieAnimationView3 = this.itemGroupAminView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
            lottieAnimationView3 = null;
        }
        lottieAnimationView3.playAnimation();
        LottieAnimationView lottieAnimationView4 = this.itemGroupAminView;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupAminView");
            lottieAnimationView4 = null;
        }
        lottieAnimationView4.setVisibility(0);
        ImageView imageView2 = this.itemGroupTag;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemGroupTag");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    public final void h(@NotNull final ij1.h feedTopData, int position, int size, boolean isFold) {
        String string;
        Intrinsics.checkNotNullParameter(feedTopData, "feedTopData");
        TextView textView = this.itemLabel;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemLabel");
            textView = null;
        }
        if (!TextUtils.isEmpty(feedTopData.P)) {
            string = feedTopData.P;
        } else {
            string = getContext().getString(R.string.f145720s9);
        }
        textView.setText(string);
        TextView textView3 = this.itemTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTitle");
            textView3 = null;
        }
        textView3.setText(getContext().getString(R.string.f145630s0, feedTopData.C));
        TextView textView4 = this.itemArrow;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
            textView4 = null;
        }
        textView4.setOnClickListener(null);
        if (size > 1) {
            TextView textView5 = this.itemArrow;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
                textView5 = null;
            }
            textView5.setVisibility(4);
        } else {
            TextView textView6 = this.itemArrow;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
                textView6 = null;
            }
            textView6.setVisibility(8);
        }
        if (position == 0 && size > 1) {
            TextView textView7 = this.itemArrow;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
                textView7 = null;
            }
            textView7.setVisibility(0);
            if (isFold) {
                TextView textView8 = this.itemArrow;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
                    textView8 = null;
                }
                textView8.setText(String.valueOf(size));
                TextView textView9 = this.itemArrow;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
                    textView9 = null;
                }
                textView9.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.guild_icon_arrow_down, 0);
            } else {
                TextView textView10 = this.itemArrow;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
                    textView10 = null;
                }
                textView10.setText("");
                TextView textView11 = this.itemArrow;
                if (textView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
                    textView11 = null;
                }
                textView11.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.guild_icon_arrow_up, 0);
            }
            TextView textView12 = this.itemArrow;
            if (textView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemArrow");
            } else {
                textView2 = textView12;
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.widget.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildFeedTopItemLayout.i(GuildFeedTopItemLayout.this, view);
                }
            });
            g();
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.widget.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildFeedTopItemLayout.j(GuildFeedTopItemLayout.this, feedTopData, view);
            }
        });
    }

    public final void setAnimRepeat(boolean z16) {
        this.animRepeat = z16;
    }

    public final void setOnItemClickListener(@Nullable sn1.b bVar) {
        this.onItemClickListener = bVar;
    }

    @JvmOverloads
    public GuildFeedTopItemLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ GuildFeedTopItemLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @JvmOverloads
    public GuildFeedTopItemLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        m();
    }
}
