package ih;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t\u00a8\u0006\u0010"}, d2 = {"Lih/i;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdFeedData$GestureStageInfo;", "c", "Landroid/view/View;", "view", "", "duration", "", "d", "g", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f407634a = new i();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"ih/i$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f407635d;

        a(View view) {
            this.f407635d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f407635d.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"ih/i$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f407636d;

        b(View view) {
            this.f407636d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f407636d.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, AlphaAnimation alphaAnimation) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(alphaAnimation, "$alphaAnimation");
        view.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View view, AlphaAnimation alphaAnimation) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(alphaAnimation, "$alphaAnimation");
        view.startAnimation(alphaAnimation);
    }

    public final List<QZoneAdFeedData.GestureStageInfo> c(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        QZoneAdFeedDataExtKt.parseGestureStageInfo(feedData);
        return QZoneAdFeedDataExtKt.getGestureStageInfo(feedData);
    }

    public final void d(final View view, long duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        final AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setAnimationListener(new a(view));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ih.h
            @Override // java.lang.Runnable
            public final void run() {
                i.f(view, alphaAnimation);
            }
        });
    }

    public final void g(final View view, long duration) {
        Intrinsics.checkNotNullParameter(view, "view");
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setAnimationListener(new b(view));
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ih.g
            @Override // java.lang.Runnable
            public final void run() {
                i.i(view, alphaAnimation);
            }
        });
    }

    public static /* synthetic */ void e(i iVar, View view, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 100;
        }
        iVar.d(view, j3);
    }

    public static /* synthetic */ void h(i iVar, View view, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = 300;
        }
        iVar.g(view, j3);
    }
}
