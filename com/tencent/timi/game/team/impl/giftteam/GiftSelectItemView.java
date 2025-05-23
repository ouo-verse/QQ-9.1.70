package com.tencent.timi.game.team.impl.giftteam;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.team.impl.giftteam.GiftSelectItemView;
import com.tencent.timi.game.team.impl.giftteam.GiftSelectView;
import com.tencent.timi.game.ui.ViewWrapper;
import com.tencent.timi.game.utils.l;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nr2.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import um4.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u00015\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0002ABB'\b\u0007\u0012\u0006\u0010:\u001a\u000209\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;\u0012\b\b\u0002\u0010=\u001a\u00020\u0018\u00a2\u0006\u0004\b>\u0010?J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013J\u0010\u0010\u0017\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0016J$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001b\u001a\u00020\u0007H\u0016R\u001c\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u0012\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010%R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010%R\u0014\u0010(\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010\u001dR\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006C"}, d2 = {"Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView;", "Landroid/widget/FrameLayout;", "", "", "withAnim", "Lcom/tencent/mobileqq/widget/f;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "l", "Lcom/tencent/image/URLImageView;", "igv", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "i", "j", "k", "g", "f", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView$b;", "data", "setData", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$a;", "setNumChangeListener", "", "state", "setState", h.F, "d", "I", "getMState$annotations", "()V", "mState", "e", "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectView$b;", "mData", "Lcom/tencent/timi/game/ui/ViewWrapper;", "Lcom/tencent/timi/game/ui/ViewWrapper;", "giftIconWrapper", "topMarginWrapper", "giftNumOptAreaWrapper", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "defaultColorDrawable", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$a;", "mGiftNumChangeListener", "D", "mLastMaterialId", "Lnr2/z;", "E", "Lnr2/z;", "binding", "com/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$d", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$d;", "mGiftResCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GiftSelectItemView extends FrameLayout {
    private static final int H = com.tencent.timi.game.utils.b.a(16);
    private static final int I = com.tencent.timi.game.utils.b.a(10);
    private static final int J = com.tencent.timi.game.utils.b.a(36);
    private static final int K = com.tencent.timi.game.utils.b.a(54);
    private static final int L = com.tencent.timi.game.utils.b.a(24);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a mGiftNumChangeListener;

    /* renamed from: D, reason: from kotlin metadata */
    private int mLastMaterialId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final z binding;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final d mGiftResCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GiftSelectView.GiftServerDataEx mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewWrapper giftIconWrapper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewWrapper topMarginWrapper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewWrapper giftNumOptAreaWrapper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorDrawable defaultColorDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$a;", "", "", "newNum", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(int newNum);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$b", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f379501d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GiftSelectItemView f379502e;

        b(f fVar, GiftSelectItemView giftSelectItemView) {
            this.f379501d = fVar;
            this.f379502e = giftSelectItemView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            f fVar = this.f379501d;
            if (fVar != null) {
                fVar.onAnimationCancel(animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            f fVar = this.f379501d;
            if (fVar != null) {
                fVar.onAnimationEnd(animation);
            }
            this.f379502e.binding.f421170c.setBackgroundResource(R.drawable.lrr);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            f fVar = this.f379501d;
            if (fVar != null) {
                fVar.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f379503d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GiftSelectItemView f379504e;

        c(f fVar, GiftSelectItemView giftSelectItemView) {
            this.f379503d = fVar;
            this.f379504e = giftSelectItemView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            f fVar = this.f379503d;
            if (fVar != null) {
                fVar.onAnimationCancel(animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            f fVar = this.f379503d;
            if (fVar != null) {
                fVar.onAnimationEnd(animation);
            }
            this.f379504e.binding.f421170c.setBackgroundResource(R.drawable.lrs);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            f fVar = this.f379503d;
            if (fVar != null) {
                fVar.onAnimationRepeat(animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/team/impl/giftteam/GiftSelectItemView$d", "Lqh2/f;", "", "id", "errorCode", "httpCode", "", "errorMessage", "", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements qh2.f {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GiftSelectItemView this$0, QQGiftPanelResource qQGiftPanelResource) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            URLImageView uRLImageView = this$0.binding.f421171d;
            um4.a aVar = um4.a.f439223a;
            String str = qQGiftPanelResource.f265002b;
            Intrinsics.checkNotNullExpressionValue(str, "panelResource.thumbPath");
            URLImageView uRLImageView2 = this$0.binding.f421171d;
            Intrinsics.checkNotNullExpressionValue(uRLImageView2, "binding.giftIcon");
            uRLImageView.setBackgroundDrawable(aVar.a(str, this$0.i(uRLImageView2)));
        }

        @Override // qh2.f
        public void c(int id5, @Nullable final QQGiftPanelResource panelResource) {
            l.h("GiftSelectItemView_", 1, "onLoadSuccess panelResource:" + panelResource + ", id:" + id5 + ", mData.data.materialID:" + GiftSelectItemView.this.mData.getData().C);
            if (panelResource == null || id5 != GiftSelectItemView.this.mData.getData().C) {
                return;
            }
            final GiftSelectItemView giftSelectItemView = GiftSelectItemView.this;
            giftSelectItemView.post(new Runnable() { // from class: um4.d
                @Override // java.lang.Runnable
                public final void run() {
                    GiftSelectItemView.d.b(GiftSelectItemView.this, panelResource);
                }
            });
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
            l.c("GiftSelectItemView_", 1, "onLoadFail id:" + id5 + ", errorCode:" + errorCode + " httpCode:" + httpCode + ", errorMessage:" + errorMessage);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftSelectItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void f(f listener) {
        l.b("GiftSelectItemView_", "animToNormal");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.topMarginWrapper, "height", I, H);
        ofInt.setDuration(200L);
        ofInt.addListener(new b(listener, this));
        animatorSet.play(ofInt);
        ViewWrapper viewWrapper = this.giftIconWrapper;
        int i3 = J;
        int i16 = K;
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(viewWrapper, "width", i3, i16);
        ofInt2.setDuration(200L);
        animatorSet.play(ofInt2);
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.giftIconWrapper, "height", i3, i16);
        ofInt3.setDuration(200L);
        animatorSet.play(ofInt3);
        ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this.giftNumOptAreaWrapper, "height", L, 0);
        ofInt4.setDuration(200L);
        animatorSet.play(ofInt4);
        animatorSet.start();
    }

    private final void g(f listener) {
        l.b("GiftSelectItemView_", "animToSelected");
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.topMarginWrapper, "height", H, I);
        ofInt.setDuration(200L);
        ofInt.addListener(new c(listener, this));
        animatorSet.play(ofInt);
        ViewWrapper viewWrapper = this.giftIconWrapper;
        int i3 = K;
        int i16 = J;
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(viewWrapper, "width", i3, i16);
        ofInt2.setDuration(200L);
        animatorSet.play(ofInt2);
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(this.giftIconWrapper, "height", i3, i16);
        ofInt3.setDuration(200L);
        animatorSet.play(ofInt3);
        ObjectAnimator ofInt4 = ObjectAnimator.ofInt(this.giftNumOptAreaWrapper, "height", 0, L);
        ofInt4.setDuration(200L);
        animatorSet.play(ofInt4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URLDrawable.URLDrawableOptions i(URLImageView igv) {
        Drawable drawable;
        Drawable drawable2;
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        if (igv.getDrawable() != null) {
            drawable = igv.getDrawable();
        } else {
            drawable = this.defaultColorDrawable;
        }
        options.mLoadingDrawable = drawable;
        if (igv.getDrawable() != null) {
            drawable2 = igv.getDrawable();
        } else {
            drawable2 = this.defaultColorDrawable;
        }
        options.mFailedDrawable = drawable2;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    private final void j() {
        l.b("GiftSelectItemView_", "setViewsToNormal");
        this.topMarginWrapper.setHeight(H);
        ViewWrapper viewWrapper = this.giftIconWrapper;
        int i3 = K;
        viewWrapper.setWidth(i3);
        this.giftIconWrapper.setHeight(i3);
        this.giftNumOptAreaWrapper.setHeight(0);
        this.binding.f421170c.setBackgroundResource(R.drawable.lrr);
    }

    private final void k() {
        l.b("GiftSelectItemView_", "setViewsToSelected");
        this.topMarginWrapper.setHeight(I);
        ViewWrapper viewWrapper = this.giftIconWrapper;
        int i3 = J;
        viewWrapper.setWidth(i3);
        this.giftIconWrapper.setHeight(i3);
        this.giftNumOptAreaWrapper.setHeight(L);
        this.binding.f421170c.setBackgroundResource(R.drawable.lrs);
    }

    private final void l() {
        if (this.mData.getSelectCount() <= 1) {
            this.mData.c(1);
            this.binding.f421177j.setImageResource(R.drawable.o7w);
        } else {
            this.binding.f421177j.setImageResource(R.drawable.o7v);
        }
        if (this.mData.getSelectCount() >= 99) {
            this.mData.c(99);
            this.binding.f421169b.setImageResource(R.drawable.o7u);
        } else {
            this.binding.f421169b.setImageResource(R.drawable.o7t);
        }
        this.binding.f421176i.setText(String.valueOf(this.mData.getSelectCount()));
        a aVar = this.mGiftNumChangeListener;
        if (aVar != null) {
            aVar.a(this.mData.getSelectCount());
        }
    }

    private final void m(boolean withAnim, f listener) {
        l.b("GiftSelectItemView_", "updateState withAnim:" + withAnim);
        if (!withAnim) {
            int i3 = this.mState;
            if (i3 != 1) {
                if (i3 == 2) {
                    k();
                    return;
                }
                return;
            }
            j();
            return;
        }
        requestLayout();
        int i16 = this.mState;
        if (i16 != 1) {
            if (i16 == 2) {
                j();
                g(listener);
                return;
            }
            return;
        }
        k();
        f(listener);
    }

    private final void n() {
        this.binding.f421173f.setText(this.mData.getData().f264876e);
        if (this.mData.getData().C != this.mLastMaterialId) {
            this.mLastMaterialId = this.mData.getData().C;
            this.binding.f421171d.setBackgroundDrawable(this.defaultColorDrawable);
        }
        nh2.c d16 = k.f439239a.d();
        if (d16 == null) {
            l.e("GiftSelectItemView_", "updateUI giftSdk is null");
        } else {
            l.i("GiftSelectItemView_", "updateUI begin request gift res. mData.data.materialID: " + this.mData.getData().C);
            d16.b().e(this.mData.getData().C, this.mGiftResCallback);
        }
        this.binding.f421175h.setText(this.mData.getData().f264878f + "\u91d1\u5e01");
        this.binding.f421176i.setText(String.valueOf(this.mData.getSelectCount()));
        this.binding.f421177j.setOnClickListener(new View.OnClickListener() { // from class: um4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftSelectItemView.o(GiftSelectItemView.this, view);
            }
        });
        this.binding.f421169b.setOnClickListener(new View.OnClickListener() { // from class: um4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GiftSelectItemView.p(GiftSelectItemView.this, view);
            }
        });
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        this.mData.getData().getClass();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GiftSelectItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mData.c(r0.getSelectCount() - 1);
        this$0.l();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GiftSelectItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GiftSelectView.GiftServerDataEx giftServerDataEx = this$0.mData;
        giftServerDataEx.c(giftServerDataEx.getSelectCount() + 1);
        this$0.l();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void setState$default(GiftSelectItemView giftSelectItemView, int i3, boolean z16, f fVar, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            fVar = null;
        }
        giftSelectItemView.setState(i3, z16, fVar);
    }

    public void h() {
        if (k.f439239a.d() == null) {
            l.e("GiftSelectItemView_", "destroy giftSdk is null");
            return;
        }
        l.i("GiftSelectItemView_", "destroy begin request gift res. mData.data.materialID: " + this.mData.getData().C);
    }

    public final void setData(@NotNull GiftSelectView.GiftServerDataEx data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        n();
    }

    public final void setNumChangeListener(@Nullable a l3) {
        this.mGiftNumChangeListener = l3;
    }

    public final void setState(int state, boolean withAnim, @Nullable f listener) {
        l.b("GiftSelectItemView_", "setState state:" + state + ", mState\uff1a" + this.mState + ", withAnim:" + withAnim);
        if (state == this.mState) {
            if (listener != null) {
                listener.onAnimationEnd(ValueAnimator.ofFloat(0.0f, 1.0f));
            }
        } else {
            this.mState = state;
            m(withAnim, listener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftSelectItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GiftSelectItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GiftSelectItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mData = new GiftSelectView.GiftServerDataEx(null, 0, false, 0, 15, null);
        this.defaultColorDrawable = new ColorDrawable(Color.parseColor("#D8D8D8"));
        z f16 = z.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.mGiftResCallback = new d();
        URLImageView uRLImageView = f16.f421171d;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.giftIcon");
        this.giftIconWrapper = new ViewWrapper(uRLImageView);
        View view = f16.f421178k;
        Intrinsics.checkNotNullExpressionValue(view, "binding.topMarginView");
        this.topMarginWrapper = new ViewWrapper(view);
        RelativeLayout relativeLayout = f16.f421174g;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.giftNumOptArea");
        this.giftNumOptAreaWrapper = new ViewWrapper(relativeLayout);
    }
}
