package com.tencent.robot.adelie.homepage.mine.part;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.adelie.homepage.utils.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001/B'\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u001c\u00a2\u0006\u0004\b,\u0010-J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0004R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u00060"}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterBannerView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/robot/adelie/homepage/mine/part/h;", "j", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "banner", "k", "i", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "bannerIconView", "e", "jumpArrowView", "Landroid/widget/ViewFlipper;", "f", "Landroid/widget/ViewFlipper;", "bannerViewFlipper", "", tl.h.F, "J", "duration", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "flipperCurrentItem", "", "I", "bannerIndex", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/adelie/homepage/mine/part/h;", "currentItem", "D", "Landroid/widget/RelativeLayout;", "E", "Ljava/util/List;", "bannerData", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieCreateCenterBannerView extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private CreateCenterBannerItem currentItem;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout banner;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<CreateCenterBannerItem> bannerData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView bannerIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView jumpArrowView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewFlipper bannerViewFlipper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long duration;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView flipperCurrentItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int bannerIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterBannerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieCreateCenterBannerView this$0, Context context, View view) {
        CreateCenterBannerItem createCenterBannerItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (!u64.g.f438512a.g() && (createCenterBannerItem = this$0.currentItem) != null) {
            QLog.i("AdelieCreateCenterBannerView", 1, "current item = " + createCenterBannerItem);
            n.f366680a.f(context, createCenterBannerItem.getUrl());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CreateCenterBannerItem j() {
        if (this.bannerIndex >= this.bannerData.size()) {
            this.bannerIndex = 0;
        }
        if (this.bannerIndex >= this.bannerData.size()) {
            return null;
        }
        return this.bannerData.get(this.bannerIndex);
    }

    private final void l() {
        Drawable o16 = ie0.a.f().o(getContext(), R.drawable.qui_chevron_right, R.color.qui_common_icon_secondary, 1000);
        ImageView imageView = this.jumpArrowView;
        if (imageView != null) {
            imageView.setImageDrawable(o16);
        }
    }

    private final void m() {
        Drawable o16 = ie0.a.f().o(getContext(), R.drawable.qui_voice_high, R.color.qui_common_brand_standard, 1000);
        ImageView imageView = this.bannerIconView;
        if (imageView != null) {
            imageView.setImageDrawable(o16);
        }
    }

    public final void i() {
        ViewFlipper viewFlipper = this.bannerViewFlipper;
        if (viewFlipper != null) {
            viewFlipper.stopFlipping();
        }
    }

    public final void k(@NotNull List<CreateCenterBannerItem> banner) {
        ViewFlipper viewFlipper;
        TextView textView;
        Intrinsics.checkNotNullParameter(banner, "banner");
        if (banner.isEmpty()) {
            return;
        }
        this.bannerData = new ArrayList(banner);
        CreateCenterBannerItem j3 = j();
        this.currentItem = j3;
        if (j3 != null && (textView = this.flipperCurrentItem) != null) {
            textView.setText(j3.getTitle());
        }
        if (this.bannerData.size() > 1 && (viewFlipper = this.bannerViewFlipper) != null) {
            viewFlipper.startFlipping();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieCreateCenterBannerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterBannerView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        List<CreateCenterBannerItem> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        this.duration = 1000L;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.bannerData = emptyList;
        View.inflate(context, R.layout.ds8, this);
        this.bannerIconView = (ImageView) findViewById(R.id.t3x);
        this.bannerViewFlipper = (ViewFlipper) findViewById(R.id.t3w);
        this.jumpArrowView = (ImageView) findViewById(R.id.dzo);
        this.flipperCurrentItem = (TextView) findViewById(R.id.vaq);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.a58);
        this.banner = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.adelie.homepage.mine.part.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdelieCreateCenterBannerView.b(AdelieCreateCenterBannerView.this, context, view);
                }
            });
        }
        m();
        l();
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f154524mq);
        loadAnimation.setAnimationListener(new b());
        ViewFlipper viewFlipper = this.bannerViewFlipper;
        if (viewFlipper != null) {
            viewFlipper.setFlipInterval(4000);
        }
        ViewFlipper viewFlipper2 = this.bannerViewFlipper;
        if (viewFlipper2 != null) {
            viewFlipper2.setInAnimation(loadAnimation);
        }
        ViewFlipper viewFlipper3 = this.bannerViewFlipper;
        if (viewFlipper3 == null) {
            return;
        }
        viewFlipper3.setOutAnimation(AnimationUtils.loadAnimation(context, R.anim.f154525mr));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterBannerView$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            View view;
            ViewFlipper viewFlipper = AdelieCreateCenterBannerView.this.bannerViewFlipper;
            TextView textView = null;
            if (viewFlipper != null) {
                view = viewFlipper.getCurrentView();
            } else {
                view = null;
            }
            if (view instanceof TextView) {
                textView = (TextView) view;
            }
            AdelieCreateCenterBannerView.this.bannerIndex++;
            AdelieCreateCenterBannerView adelieCreateCenterBannerView = AdelieCreateCenterBannerView.this;
            adelieCreateCenterBannerView.currentItem = adelieCreateCenterBannerView.j();
            CreateCenterBannerItem createCenterBannerItem = AdelieCreateCenterBannerView.this.currentItem;
            if (createCenterBannerItem != null && textView != null) {
                textView.setText(createCenterBannerItem.getTitle());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }
    }
}
