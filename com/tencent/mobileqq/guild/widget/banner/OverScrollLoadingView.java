package com.tencent.mobileqq.guild.widget.banner;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001:B\u0011\b\u0016\u0012\u0006\u00102\u001a\u000201\u00a2\u0006\u0004\b3\u00104B\u001b\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b3\u00107B#\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00108\u001a\u00020\u0005\u00a2\u0006\u0004\b3\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0002R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010\"\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010#R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010#\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView;", "Landroid/widget/ImageView;", "", "g", "l", "", "loadingDistance", "setLoadingDistance", "setDynamicImageDrawable", "setStaticImageDrawable", "i", "offset", tl.h.F, "colorType", "", "hasGuildCover", "setLoadingColorType", "shouldShow", "setShouldShowLoadingView", "Lcom/tencent/mobileqq/guild/widget/banner/h;", "callback", "setCallBack", "", Element.ELEMENT_NAME_DISTANCE, "k", "j", "Landroid/animation/ObjectAnimator;", "d", "Landroid/animation/ObjectAnimator;", "mShowLoadingViewAni", "e", "mHideLoadingViewAni", "f", UserInfo.SEX_FEMALE, "mAnimatorDistance", "Z", "mIsLoadingAnimatorPlaying", "mShouldShowLoadingView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mGuildId", BdhLogUtil.LogTag.Tag_Conn, "I", "mGuildFontColorType", "D", "mLoadingOverscrollDistance", "E", "mVibrateOnAnimatorStart", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes14.dex */
public final class OverScrollLoadingView extends ImageView {

    /* renamed from: C, reason: from kotlin metadata */
    private int mGuildFontColorType;

    /* renamed from: D, reason: from kotlin metadata */
    private int mLoadingOverscrollDistance;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mVibrateOnAnimatorStart;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator mShowLoadingViewAni;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ObjectAnimator mHideLoadingViewAni;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mAnimatorDistance;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLoadingAnimatorPlaying;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mShouldShowLoadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mGuildId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            OverScrollLoadingView.this.setVisibility(0);
            OverScrollLoadingView.this.l();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView$c", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animator", "", "onAnimationUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@Nullable ValueAnimator animator) {
            if (animator == null) {
                return;
            }
            OverScrollLoadingView.d(OverScrollLoadingView.this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/widget/banner/OverScrollLoadingView$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            OverScrollLoadingView.this.setVisibility(8);
            OverScrollLoadingView.this.mIsLoadingAnimatorPlaying = false;
            OverScrollLoadingView.d(OverScrollLoadingView.this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverScrollLoadingView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ h d(OverScrollLoadingView overScrollLoadingView) {
        overScrollLoadingView.getClass();
        return null;
    }

    private final void g() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<OverScrollLoadingView, Float>) View.TRANSLATION_Y, -this.mAnimatorDistance, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(this, View.TRANS\u2026, -mAnimatorDistance, 0f)");
        this.mShowLoadingViewAni = ofFloat;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<OverScrollLoadingView, Float>) View.TRANSLATION_Y, 0.0f, -this.mAnimatorDistance);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(this, View.TRANS\u2026eInterpolator()\n        }");
        this.mHideLoadingViewAni = ofFloat2;
        ObjectAnimator objectAnimator = this.mShowLoadingViewAni;
        ObjectAnimator objectAnimator2 = null;
        if (objectAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowLoadingViewAni");
            objectAnimator = null;
        }
        objectAnimator.setDuration(150L);
        ObjectAnimator objectAnimator3 = this.mHideLoadingViewAni;
        if (objectAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideLoadingViewAni");
            objectAnimator3 = null;
        }
        objectAnimator3.setDuration(150L);
        ObjectAnimator objectAnimator4 = this.mShowLoadingViewAni;
        if (objectAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowLoadingViewAni");
            objectAnimator4 = null;
        }
        objectAnimator4.addListener(new b());
        ObjectAnimator objectAnimator5 = this.mHideLoadingViewAni;
        if (objectAnimator5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideLoadingViewAni");
            objectAnimator5 = null;
        }
        objectAnimator5.addUpdateListener(new c());
        ObjectAnimator objectAnimator6 = this.mHideLoadingViewAni;
        if (objectAnimator6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideLoadingViewAni");
        } else {
            objectAnimator2 = objectAnimator6;
        }
        objectAnimator2.addListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        setStaticImageDrawable();
        if (this.mVibrateOnAnimatorStart) {
            QQGuildUIUtil.T(20L);
        }
    }

    public final void h(int offset) {
        boolean z16;
        Logger logger = Logger.f235387a;
        boolean z17 = true;
        if (QLog.isDevelopLevel()) {
            boolean z18 = this.mShouldShowLoadingView;
            boolean z19 = this.mIsLoadingAnimatorPlaying;
            int i3 = this.mLoadingOverscrollDistance;
            if (getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Log.d("OverScrollLoadingView", "onListViewOffsetChange " + offset + " " + z18 + " " + z19 + " " + i3 + " " + z16);
        }
        if (!this.mShouldShowLoadingView) {
            return;
        }
        if (this.mIsLoadingAnimatorPlaying) {
            if (offset < 0) {
                i();
            }
        } else {
            if (offset < this.mLoadingOverscrollDistance) {
                i();
                return;
            }
            if (getVisibility() != 0) {
                z17 = false;
            }
            if (!z17) {
                j();
            }
            setRotation((offset * 3) % 360);
        }
    }

    public final void i() {
        boolean z16;
        ObjectAnimator objectAnimator = this.mHideLoadingViewAni;
        ObjectAnimator objectAnimator2 = null;
        if (objectAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideLoadingViewAni");
            objectAnimator = null;
        }
        if (!objectAnimator.isRunning()) {
            if (getVisibility() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ObjectAnimator objectAnimator3 = this.mHideLoadingViewAni;
                if (objectAnimator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHideLoadingViewAni");
                } else {
                    objectAnimator2 = objectAnimator3;
                }
                objectAnimator2.start();
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("OverScrollLoadingView", "playHideAnimation is start");
                }
            }
        }
    }

    public final void j() {
        ObjectAnimator objectAnimator = this.mShowLoadingViewAni;
        ObjectAnimator objectAnimator2 = null;
        if (objectAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowLoadingViewAni");
            objectAnimator = null;
        }
        if (!objectAnimator.isRunning()) {
            ObjectAnimator objectAnimator3 = this.mShowLoadingViewAni;
            if (objectAnimator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShowLoadingViewAni");
            } else {
                objectAnimator2 = objectAnimator3;
            }
            objectAnimator2.start();
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("OverScrollLoadingView", "playShowAnimation is start");
            }
        }
    }

    public final void k(float distance) {
        this.mAnimatorDistance = distance;
        g();
    }

    public final void setCallBack(@NotNull h callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final void setDynamicImageDrawable() {
        int i3;
        if (this.mGuildFontColorType == 0) {
            i3 = 1;
        } else {
            i3 = 3;
        }
        setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), i3));
        this.mIsLoadingAnimatorPlaying = true;
    }

    public final void setLoadingColorType(int colorType, boolean hasGuildCover) {
        if (!hasGuildCover) {
            if (GuildThemeManager.f235286a.b()) {
                colorType = 0;
            } else {
                colorType = 1;
            }
        }
        this.mGuildFontColorType = colorType;
    }

    public final void setLoadingDistance(int loadingDistance) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("OverScrollLoadingView", "setLoadingDistance(" + loadingDistance + ")");
        }
        this.mLoadingOverscrollDistance = loadingDistance;
    }

    public final void setShouldShowLoadingView(boolean shouldShow) {
        this.mShouldShowLoadingView = shouldShow;
    }

    public final void setStaticImageDrawable() {
        int i3;
        if (this.mGuildFontColorType == 0) {
            i3 = R.drawable.guild_loading_white;
        } else {
            i3 = R.drawable.guild_loading_black;
        }
        setImageResource(i3);
        this.mIsLoadingAnimatorPlaying = false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OverScrollLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverScrollLoadingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAnimatorDistance = QQGuildUIUtil.f(25.0f);
        this.mShouldShowLoadingView = true;
        this.mGuildId = "";
        this.mLoadingOverscrollDistance = QQGuildUIUtil.f(32.0f);
        this.mVibrateOnAnimatorStart = true;
        setStaticImageDrawable();
        g();
    }
}
