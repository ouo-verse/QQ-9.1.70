package com.tencent.now.linkpkanchorplay.entrance;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.component.core.log.LogUtil;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import u0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0002\u001a\u0018B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\"\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0006R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/entrance/b;", "", "Landroid/widget/ImageView;", "imageView", "Landroid/view/animation/Animation$AnimationListener;", "listener", "", "e", "", "size", "c", "", "url", "", "numPlays", "Lv0/a;", "apngListener", "f", "g", "Lcom/tencent/now/linkpkanchorplay/entrance/b$b;", "callback", h.F, "", "d", "b", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "a", "Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "getHeadView", "()Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;", "headView", "Landroid/widget/ImageView;", "getAnimView", "()Landroid/widget/ImageView;", "animView", "Lcom/tencent/now/linkpkanchorplay/entrance/a;", "Lcom/tencent/now/linkpkanchorplay/entrance/a;", "apngResLoader", "Z", "matchSuccessAnimDone", "<init>", "(Lcom/tencent/now/linkpkanchorplay/base/LinkPKHeadImageView;Landroid/widget/ImageView;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkPKHeadImageView headView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView animView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a apngResLoader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean matchSuccessAnimDone;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/entrance/b$b;", "", "", "a", "onAnimEnd", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.entrance.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC9243b {
        void a();

        void onAnimEnd();
    }

    public b(@NotNull LinkPKHeadImageView headView, @NotNull ImageView animView) {
        List<String> mutableListOf;
        Intrinsics.checkNotNullParameter(headView, "headView");
        Intrinsics.checkNotNullParameter(animView, "animView");
        this.headView = headView;
        this.animView = animView;
        a aVar = new a();
        this.apngResLoader = aVar;
        this.matchSuccessAnimDone = true;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDc1vPvVma2qLqIfhlwwtWxq8Fvic7Gtb6lDWATIwKGe5A/");
        aVar.a(mutableListOf);
        aVar.c();
    }

    private final void c(ImageView imageView, float size) {
        int dip2px = AppUtils.UI.dip2px(size);
        imageView.getLayoutParams().width = dip2px;
        imageView.getLayoutParams().height = dip2px;
        imageView.setVisibility(0);
        LogUtil.i("LinkBtnAnimModel", "width: " + dip2px, new Object[0]);
    }

    private final void e(ImageView imageView, Animation.AnimationListener listener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setStartOffset(300L);
        scaleAnimation2.setDuration(200L);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        animationSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(listener);
        imageView.startAnimation(animationSet);
    }

    private final void f(String url, int numPlays, v0.a apngListener) {
        this.animView.clearAnimation();
        u0.a.h().e(url, this.animView, new a.c(numPlays, true, true), apngListener);
    }

    public final void b() {
        u0.a.h().cancelDisplayTask(this.animView);
        this.animView.clearAnimation();
        this.headView.clearAnimation();
    }

    /* renamed from: d, reason: from getter */
    public final boolean getMatchSuccessAnimDone() {
        return this.matchSuccessAnimDone;
    }

    public final void g(@NotNull v0.a apngListener) {
        Intrinsics.checkNotNullParameter(apngListener, "apngListener");
        LogUtil.i("LinkBtnAnimModel", "showAnimInMatching", new Object[0]);
        c(this.animView, 50.0f);
        f("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDc1vPvVma2qLqIfhlwwtWxq8Fvic7Gtb6lDWATIwKGe5A/", 0, apngListener);
    }

    public final void h(@Nullable InterfaceC9243b callback) {
        LogUtil.i("LinkBtnAnimModel", "showMatchSuccessAnim", new Object[0]);
        this.matchSuccessAnimDone = false;
        e(this.headView, new c(callback, this));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/now/linkpkanchorplay/entrance/b$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC9243b f338170d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f338171e;

        c(InterfaceC9243b interfaceC9243b, b bVar) {
            this.f338170d = interfaceC9243b;
            this.f338171e = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            InterfaceC9243b interfaceC9243b = this.f338170d;
            if (interfaceC9243b != null) {
                interfaceC9243b.onAnimEnd();
            }
            this.f338171e.matchSuccessAnimDone = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
            InterfaceC9243b interfaceC9243b = this.f338170d;
            if (interfaceC9243b != null) {
                interfaceC9243b.a();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }
    }
}
