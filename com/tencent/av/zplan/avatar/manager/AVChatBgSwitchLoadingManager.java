package com.tencent.av.zplan.avatar.manager;

import android.animation.Animator;
import android.widget.ImageView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieResult;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.zplan.avatar.utils.f;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00072\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0011\u0010$\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b \u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/av/zplan/avatar/manager/AVChatBgSwitchLoadingManager;", "Landroid/animation/Animator$AnimatorListener;", "", "l", "", "j", "", "i", "Lcom/tencent/av/zplan/avatar/manager/a;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "view", "f", "g", "k", "Landroid/animation/Animator;", "animation", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "mLoadingViewRef", "Lcom/airbnb/lottie/LottieDrawable;", "e", "Lcom/airbnb/lottie/LottieDrawable;", "mLottieLoading", "mLoadingListener", h.F, "Z", "mIsLoadingShowing", "()Z", "hasAnimationView", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AVChatBgSwitchLoadingManager implements Animator.AnimatorListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<ImageView> mLoadingViewRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mLottieLoading;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<a> mLoadingListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsLoadingShowing;

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        VideoAppInterface videoAppInterface;
        com.tencent.av.business.manager.a aVar;
        ku.b bVar;
        ku.a aVar2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof VideoAppInterface) {
            videoAppInterface = (VideoAppInterface) peekAppRuntime;
        } else {
            videoAppInterface = null;
        }
        if (videoAppInterface != null) {
            aVar = videoAppInterface.B(19);
        } else {
            aVar = null;
        }
        if (aVar instanceof ku.b) {
            bVar = (ku.b) aVar;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            aVar2 = bVar.w("video_zplan_background_spring_festival");
        } else {
            aVar2 = null;
        }
        if (aVar2 == null || !aVar2.isUsable()) {
            return null;
        }
        return bVar.y(aVar2) + "video_zplan_background_spring_festival";
    }

    private final void j() {
        ImageView imageView;
        a aVar;
        WeakReference<a> weakReference = this.mLoadingListener;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.a();
        }
        WeakReference<ImageView> weakReference2 = this.mLoadingViewRef;
        ImageView imageView2 = null;
        if (weakReference2 != null && (imageView = weakReference2.get()) != null) {
            imageView.setImageDrawable(null);
        }
        WeakReference<ImageView> weakReference3 = this.mLoadingViewRef;
        if (weakReference3 != null) {
            imageView2 = weakReference3.get();
        }
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        this.mIsLoadingShowing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l() {
        return f.h(new Function0<Unit>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatBgSwitchLoadingManager$playAnimation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WeakReference weakReference;
                ImageView imageView;
                LottieDrawable lottieDrawable;
                LottieDrawable lottieDrawable2;
                LottieDrawable lottieDrawable3;
                weakReference = AVChatBgSwitchLoadingManager.this.mLoadingViewRef;
                if (weakReference == null || (imageView = (ImageView) weakReference.get()) == null) {
                    return;
                }
                lottieDrawable = AVChatBgSwitchLoadingManager.this.mLottieLoading;
                imageView.setImageDrawable(lottieDrawable);
                imageView.setVisibility(0);
                lottieDrawable2 = AVChatBgSwitchLoadingManager.this.mLottieLoading;
                if (lottieDrawable2 != null) {
                    lottieDrawable2.setProgress(0.0f);
                }
                lottieDrawable3 = AVChatBgSwitchLoadingManager.this.mLottieLoading;
                if (lottieDrawable3 != null) {
                    lottieDrawable3.playAnimation();
                }
                ReportController.o(null, "dc00898", "", "", "0X800C467", "0X800C467", 0, 0, "", "", "", "");
            }
        });
    }

    public final void f(@Nullable ImageView view) {
        this.mLoadingViewRef = new WeakReference<>(view);
    }

    public final void g() {
        this.mLoadingViewRef = null;
    }

    public final boolean h() {
        ImageView imageView;
        WeakReference<ImageView> weakReference = this.mLoadingViewRef;
        if (weakReference != null) {
            imageView = weakReference.get();
        } else {
            imageView = null;
        }
        if (imageView != null) {
            return true;
        }
        return false;
    }

    public final void k() {
        ImageView imageView;
        ImageView imageView2;
        WeakReference<ImageView> weakReference = this.mLoadingViewRef;
        if (weakReference != null && (imageView2 = weakReference.get()) != null) {
            imageView2.setImageDrawable(null);
        }
        WeakReference<ImageView> weakReference2 = this.mLoadingViewRef;
        if (weakReference2 != null) {
            imageView = weakReference2.get();
        } else {
            imageView = null;
        }
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        LottieDrawable lottieDrawable = this.mLottieLoading;
        if (lottieDrawable != null) {
            lottieDrawable.cancelAnimation();
        }
        LottieDrawable lottieDrawable2 = this.mLottieLoading;
        if (lottieDrawable2 != null) {
            lottieDrawable2.removeAnimatorListener(this);
        }
        this.mLottieLoading = null;
    }

    public final void m(@Nullable a listener) {
        this.mLoadingListener = new WeakReference<>(listener);
    }

    public final void n() {
        ImageView imageView;
        if (this.mIsLoadingShowing) {
            return;
        }
        WeakReference<ImageView> weakReference = this.mLoadingViewRef;
        if (weakReference != null) {
            imageView = weakReference.get();
        } else {
            imageView = null;
        }
        if (imageView == null) {
            return;
        }
        if (this.mLottieLoading != null) {
            l();
        } else {
            f.d(new Function0<Unit>() { // from class: com.tencent.av.zplan.avatar.manager.AVChatBgSwitchLoadingManager$showLoading$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String i3;
                    FileInputStream fileInputStream;
                    LottieDrawable lottieDrawable;
                    LottieDrawable lottieDrawable2;
                    LottieDrawable lottieDrawable3;
                    i3 = AVChatBgSwitchLoadingManager.this.i();
                    if (i3 == null || i3.length() == 0) {
                        QLog.e("AVChatBgSwitchLoadingManager", 1, "res is not ready!!!");
                        return;
                    }
                    String str = i3 + File.separator + "cutscene.json";
                    if (!new File(str).exists()) {
                        QLog.e("AVChatBgSwitchLoadingManager", 1, str + " not found!!!");
                        return;
                    }
                    try {
                        QLog.d("AVChatBgSwitchLoadingManager", 1, "load file: " + str);
                        fileInputStream = new FileInputStream(str);
                    } catch (Exception e16) {
                        QLog.e("AVChatBgSwitchLoadingManager", 1, "open file failed\n", e16);
                        fileInputStream = null;
                    }
                    if (fileInputStream == null) {
                        return;
                    }
                    LottieResult<LottieComposition> fromJsonInputStreamSync = LottieCompositionFactory.fromJsonInputStreamSync(fileInputStream, "cutscene.json");
                    if (fromJsonInputStreamSync.getValue() == null) {
                        QLog.e("AVChatBgSwitchLoadingManager", 1, "load lottie failed!\n", fromJsonInputStreamSync.getException());
                        return;
                    }
                    LottieComposition value = fromJsonInputStreamSync.getValue();
                    Intrinsics.checkNotNull(value);
                    LottieComposition lottieComposition = value;
                    AVChatBgSwitchLoadingManager.this.mLottieLoading = new LottieDrawable();
                    lottieDrawable = AVChatBgSwitchLoadingManager.this.mLottieLoading;
                    if (lottieDrawable != null) {
                        lottieDrawable.setRepeatCount(0);
                    }
                    lottieDrawable2 = AVChatBgSwitchLoadingManager.this.mLottieLoading;
                    if (lottieDrawable2 != null) {
                        lottieDrawable2.setComposition(lottieComposition);
                    }
                    lottieDrawable3 = AVChatBgSwitchLoadingManager.this.mLottieLoading;
                    if (lottieDrawable3 != null) {
                        lottieDrawable3.addAnimatorListener(AVChatBgSwitchLoadingManager.this);
                    }
                    AVChatBgSwitchLoadingManager.this.l();
                }
            });
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@Nullable Animator animation) {
        j();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@Nullable Animator animation) {
        j();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@Nullable Animator animation) {
        a aVar;
        this.mIsLoadingShowing = true;
        WeakReference<a> weakReference = this.mLoadingListener;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            aVar.onLoadingStart();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@Nullable Animator animation) {
    }
}
