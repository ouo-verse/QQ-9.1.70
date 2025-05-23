package com.tencent.mobileqq.troop.guild.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.guild.widget.AioTopGuildTab;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u0001:B\u001d\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fR\u001c\u0010\u001e\u001a\n \u001b*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\"\u001a\n \u001b*\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010$\u001a\n \u001b*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u001c\u0010%\u001a\n \u001b*\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010!R\u001c\u0010(\u001a\n \u001b*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'R\u001c\u0010)\u001a\n \u001b*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001dR\u0018\u0010,\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/troop/guild/widget/AioTopGuildTab;", "Landroid/widget/RelativeLayout;", "", h.F, "Landroid/view/View;", "target", "", "scaleFrom", "scaleTo", "", "duration", "Landroid/animation/AnimatorSet;", "g", "", "j", "Landroid/graphics/drawable/Drawable;", "drawable", "i", "l", "show", DomainData.DOMAIN_NAME, "isAvatar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "setImg", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "tabIv", "f", "avatarLayout", "avatar", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "redDotWithContent", "redDotPure", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", "nextImage", "D", "Z", "isShowImg", "E", "Landroid/animation/AnimatorSet;", "imageAnim", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", UserInfo.SEX_FEMALE, "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AioTopGuildTab extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private Drawable nextImage;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isShowImg;

    /* renamed from: E, reason: from kotlin metadata */
    private AnimatorSet imageAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View mRootView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView tabIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View avatarLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ImageView avatar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final TextView redDotWithContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View redDotPure;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AioTopGuildTab(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void h() {
        AnimatorSet animatorSet = new AnimatorSet();
        ImageView tabIv = this.tabIv;
        Intrinsics.checkNotNullExpressionValue(tabIv, "tabIv");
        AnimatorSet g16 = g(tabIv, 1.0f, 0.01f, 130L);
        g16.addListener(new b());
        ImageView tabIv2 = this.tabIv;
        Intrinsics.checkNotNullExpressionValue(tabIv2, "tabIv");
        AnimatorSet g17 = g(tabIv2, 0.01f, 1.1f, 160L);
        ImageView tabIv3 = this.tabIv;
        Intrinsics.checkNotNullExpressionValue(tabIv3, "tabIv");
        animatorSet.playSequentially(g16, g17, g(tabIv3, 1.1f, 1.0f, 130L));
        this.imageAnim = animatorSet;
    }

    private final void i(Drawable drawable) {
        if (j()) {
            return;
        }
        this.nextImage = drawable;
        if (this.imageAnim == null) {
            h();
        }
        AnimatorSet animatorSet = this.imageAnim;
        if (animatorSet != null) {
            animatorSet.start();
        }
        this.isShowImg = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        return this.redDotWithContent.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AioTopGuildTab this$0, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        this$0.i(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Drawable drawable) {
        if (j()) {
            return;
        }
        m(true);
        this.avatar.setImageDrawable(drawable);
        this.avatarLayout.setVisibility(0);
        if (this.avatar.getMeasuredWidth() != this.tabIv.getMeasuredWidth()) {
            ViewGroup.LayoutParams layoutParams = this.avatar.getLayoutParams();
            layoutParams.width = this.tabIv.getMeasuredWidth();
            layoutParams.height = this.tabIv.getMeasuredHeight();
            this.avatar.requestLayout();
        }
    }

    private final void m(boolean isAvatar) {
        ViewGroup.LayoutParams layoutParams = this.redDotPure.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (isAvatar) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.addRule(6, R.id.f185339);
                layoutParams2.addRule(7, R.id.f185339);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.topMargin = -ViewUtils.dip2px(3.0f);
                layoutParams3.rightMargin = -ViewUtils.dip2px(5.0f);
                layoutParams3.addRule(6, R.id.f185137);
                layoutParams3.addRule(7, R.id.f185137);
            }
            this.redDotPure.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean show) {
        this.tabIv.setVisibility(show ? 0 : 4);
    }

    public final void setImg(final Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (isAttachedToWindow()) {
            i(drawable);
        } else {
            post(new Runnable() { // from class: ps2.a
                @Override // java.lang.Runnable
                public final void run() {
                    AioTopGuildTab.k(AioTopGuildTab.this, drawable);
                }
            });
        }
    }

    public /* synthetic */ AioTopGuildTab(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final AnimatorSet g(View target, float scaleFrom, float scaleTo, long duration) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(target, BasicAnimation.KeyPath.SCALE_X, scaleFrom, scaleTo);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(target, BasicAnimation.KeyPath.SCALE_Y, scaleFrom, scaleTo);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(duration);
        return animatorSet;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AioTopGuildTab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = View.inflate(context, R.layout.f127320c, this);
        this.mRootView = inflate;
        this.tabIv = (ImageView) inflate.findViewById(R.id.f185137);
        this.avatarLayout = inflate.findViewById(R.id.f185339);
        this.avatar = (ImageView) inflate.findViewById(R.id.f185238);
        this.redDotWithContent = (TextView) inflate.findViewById(R.id.f185036);
        this.redDotPure = inflate.findViewById(R.id.f184935);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        Integer valueOf = ev5 != null ? Integer.valueOf(ev5.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            ImageView imageView = this.tabIv;
            if (imageView != null) {
                imageView.setAlpha(0.5f);
            }
            View view = this.avatarLayout;
            if (view != null) {
                view.setAlpha(0.5f);
            }
        } else {
            boolean z16 = true;
            if ((valueOf == null || valueOf.intValue() != 1) && (valueOf == null || valueOf.intValue() != 3)) {
                z16 = false;
            }
            if (z16) {
                ImageView imageView2 = this.tabIv;
                if (imageView2 != null) {
                    imageView2.setAlpha(1.0f);
                }
                View view2 = this.avatarLayout;
                if (view2 != null) {
                    view2.setAlpha(1.0f);
                }
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/guild/widget/AioTopGuildTab$b", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends f {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (AioTopGuildTab.this.nextImage != null) {
                if (!AioTopGuildTab.this.j()) {
                    AioTopGuildTab aioTopGuildTab = AioTopGuildTab.this;
                    Drawable drawable = aioTopGuildTab.nextImage;
                    Intrinsics.checkNotNull(drawable);
                    aioTopGuildTab.l(drawable);
                    AioTopGuildTab.this.n(false);
                } else {
                    Logger.f235387a.d().i("AioTopGuildTab", 1, "skip by red num show");
                }
                AioTopGuildTab.this.nextImage = null;
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("nextImage is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("AioTopGuildTab", 1, (String) it.next(), null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }
}
