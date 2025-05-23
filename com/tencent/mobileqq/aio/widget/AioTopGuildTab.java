package com.tencent.mobileqq.aio.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Z2\u00020\u0001:\u0001[B\u001d\b\u0007\u0012\u0006\u0010U\u001a\u00020T\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010V\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J\u0012\u0010#\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0016\u0010&\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0002J\u0006\u0010*\u001a\u00020\u0002J\u0006\u0010+\u001a\u00020\u0002J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010-\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010.\u001a\u00020\u0004J\u000e\u00100\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0012J\u0006\u00101\u001a\u00020\u0002J\u0006\u00102\u001a\u00020\u0012J\u0006\u00103\u001a\u00020\u0002J\u0012\u00106\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104H\u0016R\u001c\u0010:\u001a\n 7*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\n 7*\u0004\u0018\u00010;0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010@\u001a\n 7*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u00109R\u001c\u0010B\u001a\n 7*\u0004\u0018\u00010;0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010=R\u001c\u0010E\u001a\n 7*\u0004\u0018\u00010C0C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010DR\u001c\u0010F\u001a\n 7*\u0004\u0018\u00010\t0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u00109R\u0016\u0010I\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010J\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010KR\u0016\u0010N\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010MR\u0016\u0010O\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010S\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010Q\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/AioTopGuildTab;", "Landroid/widget/RelativeLayout;", "", "k", "", "wh", "", "headUrl", "w", "Landroid/view/View;", "target", "", "scaleFrom", "scaleTo", "", "duration", "Landroid/animation/AnimatorSet;", "j", "", "t", "u", "Landroid/graphics/drawable/Drawable;", "drawable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", "resId", "D", "show", "G", "p", "isAvatar", UserInfo.SEX_FEMALE, "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "unselectRes", "selectRes", "l", "str", "B", ReportConstant.COSTREPORT_PREFIX, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "r", "setImg", "setHeadImg", DomainData.DOMAIN_NAME, "activeAnim", "v", "E", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "onInitializeAccessibilityNodeInfo", "kotlin.jvm.PlatformType", "d", "Landroid/view/View;", "mRootView", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "tabIv", "f", "avatarLayout", tl.h.F, "avatar", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "redDotWithContent", "redDotPure", BdhLogUtil.LogTag.Tag_Conn, "I", "tabIvUnselectRes", "tabIvSelectRes", "Landroid/graphics/drawable/Drawable;", "nextImage", "Z", "isShowImg", "isSelect", "H", "Landroid/animation/AnimatorSet;", "clickAnim", "imageAnim", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AioTopGuildTab extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int tabIvUnselectRes;

    /* renamed from: D, reason: from kotlin metadata */
    private int tabIvSelectRes;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable nextImage;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isShowImg;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isSelect;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet clickAnim;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/widget/AioTopGuildTab$a;", "", "", "STATE_IMG", "I", "STATE_IMG_AND_DOT_PURE", "STATE_IMG_AND_DOT_WITH_CONTENT", "STATE_NONE", "STATE_RED_DOT_PURE", "STATE_RED_DOT_WITH_CONTENT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.widget.AioTopGuildTab$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/widget/AioTopGuildTab$b", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AioTopGuildTab.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            if (AioTopGuildTab.this.nextImage != null) {
                if (!AioTopGuildTab.this.u()) {
                    AioTopGuildTab aioTopGuildTab = AioTopGuildTab.this;
                    Drawable drawable = aioTopGuildTab.nextImage;
                    Intrinsics.checkNotNull(drawable);
                    aioTopGuildTab.z(drawable);
                    AioTopGuildTab.this.G(false);
                }
                AioTopGuildTab.this.nextImage = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65331);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AioTopGuildTab(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(AioTopGuildTab this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = this$0.redDotWithContent.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (this$0.tabIv.getMeasuredWidth() / 2) - this$0.redDotWithContent.getMeasuredWidth();
            this$0.redDotWithContent.requestLayout();
        }
    }

    private final void D(int resId) {
        this.tabIv.setImageResource(resId);
        G(true);
        p();
        F(false);
    }

    private final void F(boolean isAvatar) {
        ViewGroup.LayoutParams layoutParams = this.redDotPure.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            if (isAvatar) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.addRule(6, R.id.f917055w);
                layoutParams2.addRule(7, R.id.f917055w);
            } else {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams3.topMargin = -ViewUtils.dip2px(3.0f);
                layoutParams3.rightMargin = -ViewUtils.dip2px(5.0f);
                layoutParams3.addRule(6, R.id.f916855u);
                layoutParams3.addRule(7, R.id.f916855u);
            }
            this.redDotPure.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(boolean show) {
        int i3;
        ImageView imageView = this.tabIv;
        if (show) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        imageView.setVisibility(i3);
    }

    private final void i() {
        this.redDotPure.setVisibility(8);
    }

    private final AnimatorSet j(View target, float scaleFrom, float scaleTo, long duration) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(target, BasicAnimation.KeyPath.SCALE_X, scaleFrom, scaleTo);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(target, BasicAnimation.KeyPath.SCALE_Y, scaleFrom, scaleTo);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(duration);
        return animatorSet;
    }

    private final void k() {
        AnimatorSet animatorSet = new AnimatorSet();
        ImageView tabIv = this.tabIv;
        Intrinsics.checkNotNullExpressionValue(tabIv, "tabIv");
        AnimatorSet j3 = j(tabIv, 1.0f, 0.01f, 130L);
        j3.addListener(new b());
        ImageView tabIv2 = this.tabIv;
        Intrinsics.checkNotNullExpressionValue(tabIv2, "tabIv");
        AnimatorSet j16 = j(tabIv2, 0.01f, 1.1f, 160L);
        ImageView tabIv3 = this.tabIv;
        Intrinsics.checkNotNullExpressionValue(tabIv3, "tabIv");
        animatorSet.playSequentially(j3, j16, j(tabIv3, 1.1f, 1.0f, 130L));
        this.imageAnim = animatorSet;
    }

    private final void m(Drawable drawable) {
        if (u()) {
            return;
        }
        this.nextImage = drawable;
        if (this.imageAnim == null) {
            k();
        }
        AnimatorSet animatorSet = this.imageAnim;
        if (animatorSet != null) {
            animatorSet.start();
        }
        this.isShowImg = true;
    }

    private final void p() {
        this.avatarLayout.setVisibility(8);
    }

    private final boolean t() {
        if (this.redDotPure.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean u() {
        if (this.redDotWithContent.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    private final void w(int wh5, String headUrl) {
        Drawable avatarDrawable = ((IGuildTroopApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildTroopApi.class)).getAvatarDrawable(headUrl, wh5, wh5);
        if (avatarDrawable != null) {
            setImg(avatarDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Ref.IntRef wh5, AioTopGuildTab this$0, String str) {
        Intrinsics.checkNotNullParameter(wh5, "$wh");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int measuredWidth = this$0.getMeasuredWidth();
        wh5.element = measuredWidth;
        this$0.w(measuredWidth, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(AioTopGuildTab this$0, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        this$0.m(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(Drawable drawable) {
        if (u()) {
            return;
        }
        F(true);
        this.avatar.setImageDrawable(drawable);
        this.avatarLayout.setVisibility(0);
        if (this.avatar.getMeasuredWidth() != this.tabIv.getMeasuredWidth()) {
            ViewGroup.LayoutParams layoutParams = this.avatar.getLayoutParams();
            layoutParams.width = this.tabIv.getMeasuredWidth();
            layoutParams.height = this.tabIv.getMeasuredHeight();
            this.avatar.requestLayout();
        }
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (u()) {
                return;
            }
            this.redDotPure.setVisibility(0);
        }
    }

    public final void B(@NotNull String str) {
        boolean z16;
        AnimatorSet animatorSet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        Intrinsics.checkNotNullParameter(str, "str");
        AnimatorSet animatorSet2 = this.imageAnim;
        if (animatorSet2 != null && animatorSet2.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (animatorSet = this.imageAnim) != null) {
            animatorSet.cancel();
        }
        this.redDotWithContent.setVisibility(0);
        this.redDotWithContent.setText(str);
        this.redDotWithContent.post(new Runnable() { // from class: com.tencent.mobileqq.aio.widget.k
            @Override // java.lang.Runnable
            public final void run() {
                AioTopGuildTab.C(AioTopGuildTab.this);
            }
        });
        r();
        p();
        G(true);
    }

    public final void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.isSelect = false;
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            setSelected(false);
        }
        D(this.tabIvUnselectRes);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) ev5)).booleanValue();
        }
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
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
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
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

    public final void l(int unselectRes, int selectRes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(unselectRes), Integer.valueOf(selectRes));
            return;
        }
        this.tabIvUnselectRes = unselectRes;
        D(unselectRes);
        this.avatar.setImageResource(unselectRes);
        this.tabIvSelectRes = selectRes;
    }

    public final int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (!t() && !u() && !this.isShowImg) {
            return 0;
        }
        if (t() && !u() && !this.isShowImg) {
            return 1;
        }
        if (!t() && u() && !this.isShowImg) {
            return 2;
        }
        if (!t() && !u() && this.isShowImg) {
            return 3;
        }
        if (t() && !u() && this.isShowImg) {
            return 4;
        }
        if (t() || !u() || !this.isShowImg) {
            return 0;
        }
        return 5;
    }

    public final boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.isSelect;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@Nullable AccessibilityNodeInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) info);
            return;
        }
        super.onInitializeAccessibilityNodeInfo(info);
        if (info != null) {
            info.setClassName(Button.class.getName());
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            G(true);
            p();
        }
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.redDotPure.setVisibility(8);
        }
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.redDotWithContent.setVisibility(8);
        }
    }

    public final void setHeadImg(@Nullable final String headUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) headUrl);
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int measuredWidth = getMeasuredWidth();
        intRef.element = measuredWidth;
        if (headUrl != null) {
            if (measuredWidth > 0) {
                w(measuredWidth, headUrl);
            } else {
                post(new Runnable() { // from class: com.tencent.mobileqq.aio.widget.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        AioTopGuildTab.x(Ref.IntRef.this, this, headUrl);
                    }
                });
            }
        }
    }

    public final void setImg(@NotNull final Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
            return;
        }
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (isAttachedToWindow()) {
            m(drawable);
        } else {
            post(new Runnable() { // from class: com.tencent.mobileqq.aio.widget.l
                @Override // java.lang.Runnable
                public final void run() {
                    AioTopGuildTab.y(AioTopGuildTab.this, drawable);
                }
            });
        }
    }

    public final void v(boolean activeAnim) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, activeAnim);
            return;
        }
        if (!this.isSelect) {
            this.isSelect = true;
            if (this.clickAnim == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                ImageView tabIv = this.tabIv;
                Intrinsics.checkNotNullExpressionValue(tabIv, "tabIv");
                AnimatorSet j3 = j(tabIv, 1.0f, 0.6f, 130L);
                ImageView tabIv2 = this.tabIv;
                Intrinsics.checkNotNullExpressionValue(tabIv2, "tabIv");
                AnimatorSet j16 = j(tabIv2, 0.6f, 1.2f, 160L);
                ImageView tabIv3 = this.tabIv;
                Intrinsics.checkNotNullExpressionValue(tabIv3, "tabIv");
                animatorSet.playSequentially(j3, j16, j(tabIv3, 1.2f, 1.0f, 130L));
                this.clickAnim = animatorSet;
            }
            if (activeAnim) {
                if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
                    setSelected(true);
                }
                AnimatorSet animatorSet2 = this.clickAnim;
                Intrinsics.checkNotNull(animatorSet2);
                animatorSet2.start();
            }
        }
        this.isShowImg = false;
        i();
        D(this.tabIvSelectRes);
    }

    public /* synthetic */ AioTopGuildTab(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AioTopGuildTab(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        View inflate = View.inflate(context, R.layout.fq_, this);
        this.mRootView = inflate;
        this.tabIv = (ImageView) inflate.findViewById(R.id.f916855u);
        this.avatarLayout = inflate.findViewById(R.id.f917055w);
        this.avatar = (ImageView) inflate.findViewById(R.id.f916955v);
        this.redDotWithContent = (TextView) inflate.findViewById(R.id.f72083pw);
        this.redDotPure = inflate.findViewById(R.id.f72063pu);
    }
}
