package com.tencent.aelight.camera.ae.flashshow.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0003VWXB\u0011\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PB\u001b\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u00a2\u0006\u0004\bO\u0010SB#\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\u0006\u0010T\u001a\u00020,\u00a2\u0006\u0004\bO\u0010UJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0003J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u001b\u001a\u00020\u0004J<\u0010!\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010#\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\"\u001a\u00020\u001cJ&\u0010$\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010 \u001a\u00020\u0016H\u0007J\b\u0010%\u001a\u00020\u0016H\u0016J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u0010\u0010*\u001a\u00020\u00162\b\u0010)\u001a\u0004\u0018\u00010(J\u0006\u0010+\u001a\u00020\u0004R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010$\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00104R\u0016\u00108\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010=\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010BR\"\u0010H\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u00107\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0014\u0010J\u001a\u00020,8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010/R\u0011\u0010L\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\bK\u0010E\u00a8\u0006Y"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/AEAbsBottomPanal;", "Ljava/lang/Runnable;", "callback", "", "r", "w", UserInfo.SEX_FEMALE, "G", "t", "K", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "listener", "setMaterialPanelListener", "Llq/b;", "capturePartManager", "setPartManager", "Lcom/tencent/aelight/camera/ae/camera/ui/c;", "controller", "setCaptureController", "B", "", "withAnim", "f", "withAnimation", ReportConstant.COSTREPORT_PREFIX, "E", "", "categoryName", "itemId", "openSpecific", "hideOtherTab", "u", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "L", "I", "g", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", "info", HippyTKDListViewAdapter.X, "M", "", "e", "getTranslationY", "()I", "setTranslationY", "(I)V", "translationY", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialProviderView;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialProviderView;", "mContentView", tl.h.F, "Z", "isOpenAnimating", "i", "isCloseAnimating", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/camera/ui/c;", "mController", "Llq/b;", "mVideoStoryCaptureManger", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "mMaterialPanelListener", "Ljava/lang/Runnable;", "broadCastRunnable", "y", "()Z", "setOpen", "(Z)V", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "v", "openedHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isPanelOpened", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "c", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialPanel extends AEAbsBottomPanal {

    /* renamed from: C, reason: from kotlin metadata */
    private lq.b mVideoStoryCaptureManger;

    /* renamed from: D, reason: from kotlin metadata */
    private a mMaterialPanelListener;

    /* renamed from: E, reason: from kotlin metadata */
    private Runnable broadCastRunnable;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isOpen;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int translationY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AEFlashShowMaterialProviderView mContentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isOpenAnimating;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isCloseAnimating;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aelight.camera.ae.camera.ui.c mController;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "", "Lcom/tencent/aelight/camera/struct/camera/material/AEMaterialMetaData;", WadlProxyConsts.KEY_MATERIAL, "", "a", "c", "b", "d", "f", "", "success", "e", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface a {
        void a(AEMaterialMetaData material);

        void b();

        void c();

        void d();

        void e(AEMaterialMetaData material, boolean success);

        void f(AEMaterialMetaData material);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$d", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d extends com.tencent.mobileqq.widget.f {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f64581e;

        d(Runnable runnable) {
            this.f64581e = runnable;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AEFlashShowMaterialPanel.this.isCloseAnimating = false;
            AEFlashShowMaterialPanel.this.setOpen(false);
            a aVar = AEFlashShowMaterialPanel.this.mMaterialPanelListener;
            if (aVar != null) {
                aVar.d();
            }
            Runnable runnable = this.f64581e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AEFlashShowMaterialPanel.this.isCloseAnimating = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$e", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = AEFlashShowMaterialPanel.this.mContentView;
            if (aEFlashShowMaterialProviderView != null) {
                aEFlashShowMaterialProviderView.setAlpha(1.0f);
            }
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView2 = AEFlashShowMaterialPanel.this.mContentView;
            if (aEFlashShowMaterialProviderView2 == null) {
                return;
            }
            aEFlashShowMaterialProviderView2.setVisibility(8);
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$f", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class f extends com.tencent.mobileqq.widget.f {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ms.a.c("AEFlashShowMaterialPanel", "[openWithAnimation] translationY - onAnimationCancel");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$g", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class g implements Animation.AnimationListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Runnable f64584e;

        g(Runnable runnable) {
            this.f64584e = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AEFlashShowMaterialPanel.this.isOpenAnimating = false;
            AEFlashShowMaterialPanel.this.setOpen(true);
            a aVar = AEFlashShowMaterialPanel.this.mMaterialPanelListener;
            if (aVar != null) {
                aVar.b();
            }
            Runnable runnable = this.f64584e;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            AEFlashShowMaterialPanel.this.isOpenAnimating = true;
            if (AEFlashShowMaterialPanel.this.mContentView != null) {
                AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = AEFlashShowMaterialPanel.this.mContentView;
                if (aEFlashShowMaterialProviderView != null) {
                    aEFlashShowMaterialProviderView.setAlpha(1.0f);
                }
                AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView2 = AEFlashShowMaterialPanel.this.mContentView;
                if (aEFlashShowMaterialProviderView2 == null) {
                    return;
                }
                aEFlashShowMaterialProviderView2.setVisibility(0);
                return;
            }
            ms.a.c("AEFlashShowMaterialPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialPanel(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.translationY = v();
    }

    private final void F(Runnable callback) {
        if (this.mContentView == null) {
            A();
        }
        setTranslationY(0.0f);
        this.isOpenAnimating = true;
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
        if (aEFlashShowMaterialProviderView != null) {
            if (aEFlashShowMaterialProviderView != null) {
                aEFlashShowMaterialProviderView.setAlpha(1.0f);
            }
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView2 = this.mContentView;
            if (aEFlashShowMaterialProviderView2 != null) {
                aEFlashShowMaterialProviderView2.setVisibility(0);
            }
        } else {
            ms.a.c("AEFlashShowMaterialPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
        }
        this.isOpenAnimating = false;
        this.isOpen = true;
        a aVar = this.mMaterialPanelListener;
        if (aVar != null) {
            aVar.b();
        }
        if (callback != null) {
            callback.run();
        }
    }

    private final void G(Runnable callback) {
        if (this.mContentView == null) {
            A();
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this, "translationY", this.translationY, 0.0f));
        animatorSet.addListener(new f());
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.mContentView, 0.0f, 1.0f);
        b16.setStartOffset(200L);
        b16.setDuration(100L);
        b16.setAnimationListener(new g(callback));
        startAnimation(b16);
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (gq.a.r(((Activity) context).getIntent())) {
                com.tencent.aelight.camera.aebase.c.c(5, null);
            }
        }
    }

    private final void K() {
        lq.b bVar = this.mVideoStoryCaptureManger;
        if (bVar != null) {
            bVar.q(131075, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intent intent = new Intent();
        intent.setAction("ae_editor_bottom_tab_show_hide");
        intent.putExtra("is_show", true);
        activity.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(AEFlashShowMaterialPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K();
    }

    private final void r(Runnable callback) {
        w();
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
        if (aEFlashShowMaterialProviderView != null) {
            aEFlashShowMaterialProviderView.setVisibility(8);
        }
        if (callback != null) {
            callback.run();
        }
    }

    private final void t(Runnable callback) {
        ms.a.a("AEFlashShowMaterialPanel", "in close panel animation.");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", 0.0f, this.translationY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.addListener(new d(callback));
        animatorSet.setDuration(300L).start();
        Animation b16 = com.tencent.aelight.camera.aioeditor.capture.util.g.b(this.mContentView, 1.0f, 0.0f);
        b16.setStartOffset(0L);
        b16.setDuration(100L);
        b16.setAnimationListener(new e());
        startAnimation(b16);
    }

    private final int v() {
        return com.tencent.aelight.camera.ae.camera.ui.gallery.t.e(getContext());
    }

    private final void w() {
        setTranslationY(v());
        setVisibility(8);
    }

    public final void A() {
        if (this.mContentView == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            layoutParams.height = v();
            setLayoutParams(layoutParams);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = new AEFlashShowMaterialProviderView(context, this.mMaterialPanelListener);
            this.mContentView = aEFlashShowMaterialProviderView;
            addView(aEFlashShowMaterialProviderView);
        }
    }

    public final void B() {
        if (ms.a.g()) {
            ms.a.f("AEFlashShowMaterialPanel", "onDestroy()");
        }
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
        if (aEFlashShowMaterialProviderView != null) {
            aEFlashShowMaterialProviderView.l();
        }
        this.mContentView = null;
        if (this.broadCastRunnable != null) {
            ThreadManager.getUIHandler().removeCallbacks(this.broadCastRunnable);
        }
    }

    public final void C() {
        AEFlashShowMaterialManager mTemplateManager;
        AEFlashShowMaterialManager mTemplateManager2;
        AEMaterialMetaData c16 = AEFlashShowMaterialManager.INSTANCE.c();
        if (c16 != null) {
            if (x(c16)) {
                AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
                if (aEFlashShowMaterialProviderView == null || (mTemplateManager2 = aEFlashShowMaterialProviderView.getMTemplateManager()) == null) {
                    return;
                }
                mTemplateManager2.e0(c16);
                return;
            }
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView2 = this.mContentView;
            QQToast.makeText(aEFlashShowMaterialProviderView2 != null ? aEFlashShowMaterialProviderView2.getContext() : null, R.string.ylx, 0).show();
            AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView3 = this.mContentView;
            if (aEFlashShowMaterialProviderView3 == null || (mTemplateManager = aEFlashShowMaterialProviderView3.getMTemplateManager()) == null) {
                return;
            }
            mTemplateManager.q(c16);
        }
    }

    public final void D() {
        AEMaterialMetaData c16 = AEFlashShowMaterialManager.INSTANCE.c();
        if (c16 != null) {
            if (x(c16)) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$1(this, c16, null), 3, null);
            } else {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AEFlashShowMaterialPanel$onFavoriteClickEventToServer$1$2(this, c16, null), 3, null);
            }
        }
    }

    public final void E() {
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
        if (aEFlashShowMaterialProviderView != null) {
            aEFlashShowMaterialProviderView.m();
        }
    }

    public final void I(String categoryName, String materialId, boolean hideOtherTab) {
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView;
        ms.a.f("CircleTakeSame", "positionSpecificMaterialItem---" + categoryName + ", " + materialId + ", hideOtherTab = " + hideOtherTab + ", mContentView=" + this.mContentView);
        if (hideOtherTab && categoryName != null && (aEFlashShowMaterialProviderView = this.mContentView) != null) {
            aEFlashShowMaterialProviderView.h(categoryName);
        }
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView2 = this.mContentView;
        if (aEFlashShowMaterialProviderView2 != null) {
            if (materialId == null) {
                materialId = "";
            }
            aEFlashShowMaterialProviderView2.n(categoryName, materialId, false);
        }
    }

    public final void L(String categoryName, String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
        if (aEFlashShowMaterialProviderView != null) {
            aEFlashShowMaterialProviderView.n(categoryName, materialId, true);
        }
    }

    public final void M() {
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
        if (aEFlashShowMaterialProviderView != null) {
            aEFlashShowMaterialProviderView.r();
        }
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public void f(boolean withAnim) {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            final Activity activity = (Activity) context;
            if (gq.a.r(activity.getIntent()) && z()) {
                MqqHandler uIHandler = ThreadManager.getUIHandler();
                Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bl
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEFlashShowMaterialPanel.p(activity);
                    }
                };
                this.broadCastRunnable = runnable;
                uIHandler.postDelayed(runnable, 300L);
            }
        }
        s(withAnim, new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bm
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowMaterialPanel.q(AEFlashShowMaterialPanel.this);
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal
    public boolean g() {
        return !z();
    }

    public final void s(boolean withAnimation, Runnable callback) {
        if (z()) {
            if (withAnimation) {
                t(callback);
            } else {
                r(callback);
            }
            lq.b bVar = this.mVideoStoryCaptureManger;
            if (bVar != null) {
                bVar.q(196613, new Object[0]);
            }
            if (ms.a.g()) {
                ms.a.a("AEFlashShowMaterialPanel", "panel closed");
            }
        }
    }

    public final void setCaptureController(com.tencent.aelight.camera.ae.camera.ui.c controller) {
        this.mController = controller;
    }

    public final void setMaterialPanelListener(a listener) {
        this.mMaterialPanelListener = listener;
    }

    public final void setOpen(boolean z16) {
        this.isOpen = z16;
    }

    public final void setPartManager(lq.b capturePartManager) {
        this.mVideoStoryCaptureManger = capturePartManager;
    }

    public final void setTranslationY(int i3) {
        this.translationY = i3;
    }

    public final boolean x(AEMaterialMetaData info) {
        AEFlashShowMaterialManager mTemplateManager;
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView = this.mContentView;
        if (aEFlashShowMaterialProviderView == null || (mTemplateManager = aEFlashShowMaterialProviderView.getMTemplateManager()) == null) {
            return false;
        }
        return mTemplateManager.K(info);
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsOpen() {
        return this.isOpen;
    }

    public final boolean z() {
        AEFlashShowMaterialProviderView aEFlashShowMaterialProviderView;
        return (getVisibility() == 8 || (aEFlashShowMaterialProviderView = this.mContentView) == null || aEFlashShowMaterialProviderView == null || aEFlashShowMaterialProviderView.getVisibility() != 0) ? false : true;
    }

    public final void u(String categoryName, String itemId, boolean openSpecific, boolean withAnimation, boolean hideOtherTab, Runnable callback) {
        setVisibility(0);
        if (withAnimation) {
            G(callback);
        } else {
            F(callback);
        }
        if (openSpecific) {
            if (itemId == null && categoryName == null) {
                return;
            }
            I(categoryName, itemId, hideOtherTab);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.translationY = v();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.translationY = v();
    }

    public static /* synthetic */ void J(AEFlashShowMaterialPanel aEFlashShowMaterialPanel, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        aEFlashShowMaterialPanel.I(str, str2, z16);
    }

    public final void H(String str, String str2) {
        J(this, str, str2, false, 4, null);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$b;", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMaterialPanel$a;", "", "b", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static class b implements a {
        @Override // com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialPanel.a
        public void b() {
        }
    }
}
