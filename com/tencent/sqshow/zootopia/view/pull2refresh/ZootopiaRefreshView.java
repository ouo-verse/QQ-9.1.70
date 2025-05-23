package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0002+,B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0004J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0016R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaRefreshView;", "Landroid/widget/ImageView;", "", "e", "", WadlProxyConsts.PARAM_FILENAME, "f", "j", "k", "l", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "speed", "setSpeed", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaRefreshView$b;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/airbnb/lottie/LottieDrawable;", "d", "Lcom/airbnb/lottie/LottieDrawable;", "mEllipsisDrawable", "Ljava/lang/String;", "mDirName", "mJsonName", tl.h.F, "mNightJsonName", "", "i", "Z", "getNeedNightStyle", "()Z", "setNeedNightStyle", "(Z)V", "needNightStyle", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ZootopiaRefreshView extends ImageView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LottieDrawable mEllipsisDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String mDirName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String mJsonName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String mNightJsonName;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needNightStyle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaRefreshView$b;", "", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaRefreshView$c", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/ValueAnimator;", "animation", "", "onAnimationUpdate", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        c(b bVar) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Intrinsics.checkNotNull(ZootopiaRefreshView.this.mEllipsisDrawable);
            if (Math.abs(r5.getProgress() - 0.5d) < 0.008333334f) {
                LottieDrawable lottieDrawable = ZootopiaRefreshView.this.mEllipsisDrawable;
                if (lottieDrawable != null) {
                    lottieDrawable.stop();
                }
                LottieDrawable lottieDrawable2 = ZootopiaRefreshView.this.mEllipsisDrawable;
                if (lottieDrawable2 != null) {
                    lottieDrawable2.removeAnimatorUpdateListener(this);
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaRefreshView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final ZootopiaRefreshView this$0, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieComposition.Factory.fromAssetFileName(this$0.getContext(), str, new OnCompositionLoadedListener() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.g
            @Override // com.airbnb.lottie.OnCompositionLoadedListener
            public final void onCompositionLoaded(LottieComposition lottieComposition) {
                ZootopiaRefreshView.h(str, this$0, lottieComposition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(String str, final ZootopiaRefreshView this$0, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("ZootopiaRefreshView", 1, "OnCompositionLoadedListener + " + str);
        if (lottieComposition == null) {
            QLog.e("ZootopiaRefreshView", 1, "onCompositionLoaded lottieComposition is null");
            return;
        }
        LottieDrawable lottieDrawable = new LottieDrawable();
        lottieDrawable.setComposition(lottieComposition);
        lottieDrawable.loop(true);
        this$0.mEllipsisDrawable = lottieDrawable;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.h
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaRefreshView.i(ZootopiaRefreshView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ZootopiaRefreshView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setImageDrawable(this$0.mEllipsisDrawable);
    }

    protected final void e() {
        if (this.needNightStyle) {
            f(this.mDirName + this.mNightJsonName);
            return;
        }
        f(this.mDirName + this.mJsonName);
    }

    protected final void f(final String fileName) {
        try {
            l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.view.pull2refresh.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaRefreshView.g(ZootopiaRefreshView.this, fileName);
                }
            });
        } catch (Exception e16) {
            QLog.e("ZootopiaRefreshView", 1, "loadEllipsisAnimation fail.", e16);
        }
    }

    public final void j() {
        e();
    }

    public final void k() {
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.resumeAnimation();
        }
    }

    public final void l() {
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.endAnimation();
        }
    }

    public final void m(b listener) {
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable == null || lottieDrawable == null) {
            return;
        }
        lottieDrawable.addAnimatorUpdateListener(new c(listener));
    }

    public final void setNeedNightStyle(boolean z16) {
        this.needNightStyle = z16;
    }

    public final void setProgress(float progress) {
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.setProgress(progress);
    }

    public final void setSpeed(float speed) {
        LottieDrawable lottieDrawable = this.mEllipsisDrawable;
        if (lottieDrawable == null) {
            return;
        }
        lottieDrawable.setSpeed(speed);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaRefreshView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaRefreshView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaRefreshView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDirName = "refresh_lottie/";
        this.mJsonName = "zootopia_refresh.json";
        this.mNightJsonName = "zootopia_refresh_night.json";
        e();
    }
}
