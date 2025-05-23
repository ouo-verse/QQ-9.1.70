package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.parts.QQSettingMeProfileMaskPartV3;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.de;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurView;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0003J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0017J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0017J\u001c\u0010\u001b\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00107\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010-R\u0018\u0010:\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeProfileMaskPartV3;", "Lcom/tencent/mobileqq/part/a;", "", LocaleUtils.L_JAPANESE, "la", "S9", "", "V9", "ga", "Landroid/graphics/Rect;", "U9", "Y9", "ia", "aa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartResume", "onPartDestroy", "Landroid/graphics/drawable/GradientDrawable;", "W9", "onPostThemeChanged", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "blurCardView", "Lcom/tencent/qui/quiblurview/QQBlurView;", tl.h.F, "Lcom/tencent/qui/quiblurview/QQBlurView;", "blurView", "i", "Landroid/graphics/drawable/GradientDrawable;", "overLayDrawable", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "zPlanOffset", "", BdhLogUtil.LogTag.Tag_Conn, "I", "screenHeight", "Lcom/tencent/image/URLDrawable;", "D", "Lcom/tencent/image/URLDrawable;", "zPlanStaticDrawable", "Ljava/util/concurrent/atomic/AtomicBoolean;", "E", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasUpdated", "topOffset", "G", "Landroid/view/View;", "topHasCoverMask", "H", "topNoImgMask", "Ljava/lang/Runnable;", "Lkotlin/Lazy;", "X9", "()Ljava/lang/Runnable;", "runnable", "<init>", "()V", "J", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQSettingMeProfileMaskPartV3 extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int screenHeight;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private URLDrawable zPlanStaticDrawable;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private AtomicBoolean hasUpdated;

    /* renamed from: F, reason: from kotlin metadata */
    private int topOffset;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View topHasCoverMask;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private View topNoImgMask;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy runnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup blurCardView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQBlurView blurView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GradientDrawable overLayDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float zPlanOffset;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeProfileMaskPartV3$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeProfileMaskPartV3$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/parts/QQSettingMeProfileMaskPartV3$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileMaskPartV3.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(QQSettingMeProfileMaskPartV3 this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.ja();
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
            } else {
                QLog.e("QQSettingMeProfileMaskPartV3", 1, "updateZPlanStaticDrawable onLoadCanceled");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) drawable, (Object) cause);
            } else {
                QLog.e("QQSettingMeProfileMaskPartV3", 1, "updateZPlanStaticDrawable onLoadFialed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable, progress);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) drawable);
                return;
            }
            QLog.i("QQSettingMeProfileMaskPartV3", 1, "updateZPlanStaticDrawable onLoadSuccessed");
            final QQSettingMeProfileMaskPartV3 qQSettingMeProfileMaskPartV3 = QQSettingMeProfileMaskPartV3.this;
            qQSettingMeProfileMaskPartV3.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.parts.at
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeProfileMaskPartV3.b.b(QQSettingMeProfileMaskPartV3.this);
                }
            });
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28102);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeProfileMaskPartV3() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.hasUpdated = new AtomicBoolean();
        lazy = LazyKt__LazyJVMKt.lazy(new QQSettingMeProfileMaskPartV3$runnable$2(this));
        this.runnable = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.parts.ao
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeProfileMaskPartV3.T9(QQSettingMeProfileMaskPartV3.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(QQSettingMeProfileMaskPartV3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.la();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect U9() {
        int realWidth = ScreenUtil.getRealWidth(getActivity());
        int i3 = this.screenHeight;
        int i16 = this.topOffset;
        return new Rect(0, i16, realWidth, i3 + i16);
    }

    private final boolean V9() {
        if (Intrinsics.areEqual(((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).R1().getValue(), Boolean.TRUE)) {
            com.tencent.qui.quiblurview.c cVar = com.tencent.qui.quiblurview.c.f363628c;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            if (cVar.b(activity)) {
                return true;
            }
        }
        return false;
    }

    private final Runnable X9() {
        return (Runnable) this.runnable.getValue();
    }

    private final void Y9() {
        ViewGroup viewGroup;
        KeyEvent.Callback callback;
        View partRootView = getPartRootView();
        QQBlurView qQBlurView = null;
        if (partRootView != null) {
            viewGroup = (ViewGroup) partRootView.findViewById(R.id.f164621t94);
        } else {
            viewGroup = null;
        }
        this.blurCardView = viewGroup;
        if (viewGroup != null) {
            callback = viewGroup.getChildAt(0);
        } else {
            callback = null;
        }
        if (callback instanceof QQBlurView) {
            qQBlurView = (QQBlurView) callback;
        }
        this.blurView = qQBlurView;
        if (qQBlurView != null) {
            qQBlurView.l(12);
        }
        QQBlurView qQBlurView2 = this.blurView;
        if (qQBlurView2 != null) {
            qQBlurView2.m(qQBlurView2);
        }
        QQBlurView qQBlurView3 = this.blurView;
        if (qQBlurView3 != null) {
            qQBlurView3.j(getPartRootView());
        }
        QQBlurView qQBlurView4 = this.blurView;
        if (qQBlurView4 != null) {
            qQBlurView4.setDisableBlurDrawable(ex.c(R.drawable.qui_common_bg_bottom_standard_bg));
        }
        QQBlurView qQBlurView5 = this.blurView;
        if (qQBlurView5 != null) {
            qQBlurView5.y(true);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.parts.ap
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeProfileMaskPartV3.Z9(QQSettingMeProfileMaskPartV3.this);
            }
        });
        QQBlurView qQBlurView6 = this.blurView;
        if (qQBlurView6 != null) {
            qQBlurView6.setEnableBlur(false);
        }
        QQBlurView qQBlurView7 = this.blurView;
        if (qQBlurView7 != null) {
            qQBlurView7.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QQSettingMeProfileMaskPartV3 this$0) {
        int a16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (je0.a.a(this$0.getActivity())) {
            a16 = ex.a(R.color.cec);
        } else {
            a16 = ex.a(R.color.qui_common_fill_light_tertiary);
        }
        int a17 = ex.a(R.color.qui_common_bg_bottom_standard);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{a16, a17, a17});
        this$0.overLayDrawable = gradientDrawable;
        QQBlurView qQBlurView = this$0.blurView;
        if (qQBlurView != null) {
            qQBlurView.z(gradientDrawable);
        }
    }

    private final boolean aa() {
        de deVar = de.f307628a;
        if (deVar.c() && deVar.a()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ea(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @RequiresApi(29)
    @SuppressLint({"ResourceType"})
    private final void ga() {
        View view;
        View findViewById;
        View findViewById2;
        View partRootView = getPartRootView();
        View view2 = null;
        if (partRootView != null && (view = partRootView.findViewById(R.id.tns)) != null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{getContext().getColor(R.color.qui_button_bg_secondary_default), getContext().getColor(R.color.qui_common_bg_bottom_light)});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            view.setBackground(gradientDrawable);
            view.setVisibility(8);
        } else {
            view = null;
        }
        this.topHasCoverMask = view;
        View partRootView2 = getPartRootView();
        if (partRootView2 != null && (findViewById2 = partRootView2.findViewById(R.id.f99975r9)) != null) {
            findViewById2.setBackground(W9());
            view2 = findViewById2;
        }
        this.topNoImgMask = view2;
        if (view2 != null) {
            final QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.parts.aq
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QQSettingMeProfileMaskPartV3.ha(QQSettingMeViewModel.this, view3);
                }
            });
        }
        View partRootView3 = getPartRootView();
        if (partRootView3 != null && (findViewById = partRootView3.findViewById(R.id.tnr)) != null) {
            findViewById.setBackground(getContext().getDrawable(R.drawable.qui_common_bg_bottom_light_bg));
            findViewById.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ha(QQSettingMeViewModel qQSettingMeViewModel, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!FastClickUtils.isFastDoubleClick("QQSettingMeProfileMaskPartV3")) {
            qQSettingMeViewModel.N1("d_nickname").onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia() {
        View view;
        Window window;
        URLDrawable uRLDrawable;
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (aa()) {
            View partRootView = getPartRootView();
            View view2 = null;
            if (partRootView != null) {
                view = partRootView.findViewById(R.id.yg7);
            } else {
                view = null;
            }
            com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
            Activity activity = getActivity();
            if (activity != null) {
                window = activity.getWindow();
            } else {
                window = null;
            }
            if (bVar.j(window)) {
                if (view != null) {
                    obj = view.getParent();
                } else {
                    obj = null;
                }
                if (obj instanceof View) {
                    view2 = (View) obj;
                }
                if (view2 != null) {
                    arrayList.add(view2.getBackground());
                }
            } else if (view != null) {
                arrayList.add(view.getBackground());
            }
            if (this.zPlanOffset < this.screenHeight / 3 && (uRLDrawable = this.zPlanStaticDrawable) != null) {
                arrayList.add(uRLDrawable);
            }
            QQBlurView qQBlurView = this.blurView;
            if (qQBlurView != null) {
                qQBlurView.setBlurSource(arrayList);
            }
        } else {
            arrayList.add(getPartRootView());
            QQBlurView qQBlurView2 = this.blurView;
            if (qQBlurView2 != null) {
                qQBlurView2.setBlurSource(arrayList);
            }
        }
        QQBlurView qQBlurView3 = this.blurView;
        if (qQBlurView3 != null) {
            qQBlurView3.setEnableBlur(V9());
        }
        QQBlurView qQBlurView4 = this.blurView;
        if (qQBlurView4 != null) {
            qQBlurView4.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ja() {
        if (this.hasUpdated.compareAndSet(false, true)) {
            URLDrawable uRLDrawable = this.zPlanStaticDrawable;
            if (uRLDrawable != null) {
                uRLDrawable.setBounds(U9());
            }
            ia();
        }
    }

    private final void la() {
        QLog.i("QQSettingMeProfileMaskPartV3", 1, "updateZPlanStaticDrawable");
        this.hasUpdated.set(false);
        String g16 = DrawerUtils.f306948a.g();
        if (new File(g16).exists()) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = new ColorDrawable(0);
            obtain.mFailedDrawable = new ColorDrawable(0);
            URLDrawable fileDrawable = URLDrawable.getFileDrawable(g16, obtain);
            this.zPlanStaticDrawable = fileDrawable;
            if (fileDrawable != null) {
                fileDrawable.setURLDrawableListener(new b());
            }
        }
        runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.parts.ar
            @Override // java.lang.Runnable
            public final void run() {
                QQSettingMeProfileMaskPartV3.ma(QQSettingMeProfileMaskPartV3.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(QQSettingMeProfileMaskPartV3 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ja();
    }

    @RequiresApi(29)
    @NotNull
    public final GradientDrawable W9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (GradientDrawable) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int color = ContextCompat.getColor(getContext(), R.color.bew);
        if (QQTheme.isNowThemeIsNight()) {
            color = ContextCompat.getColor(getContext(), R.color.bex);
        }
        int color2 = getContext().getColor(R.color.qui_common_bg_bottom_light);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        if (Build.VERSION.SDK_INT > 28) {
            gradientDrawable.setColors(new int[]{color, color2, color2}, new float[]{0.0f, 0.1f, 1.0f});
        } else {
            QLog.i("QQSettingMeProfileMaskPartV3", 1, "gradientDrawable set color is below 9 --");
            gradientDrawable.setColor(color2);
        }
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @RequiresApi(29)
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        this.screenHeight = ScreenUtil.getRealHeight(getActivity());
        Y9();
        ga();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<Boolean> R1 = qQSettingMeViewModel.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileMaskPartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileMaskPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeProfileMaskPartV3.this.ia();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                }
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileMaskPartV3.da(Function1.this, obj);
            }
        });
        MutableLiveData<Float> T1 = qQSettingMeViewModel.T1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Float, Unit> function12 = new Function1<Float, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileMaskPartV3$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileMaskPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f16) {
                invoke2(f16);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Float it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileMaskPartV3 qQSettingMeProfileMaskPartV3 = QQSettingMeProfileMaskPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileMaskPartV3.zPlanOffset = it.floatValue();
                QQSettingMeProfileMaskPartV3.this.ia();
            }
        };
        T1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileMaskPartV3.ea(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData = qQSettingMeViewModel.W;
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileMaskPartV3$onPartCreate$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileMaskPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileMaskPartV3 qQSettingMeProfileMaskPartV3 = QQSettingMeProfileMaskPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileMaskPartV3.topOffset = it.intValue();
                QQSettingMeProfileMaskPartV3.this.S9();
            }
        };
        mutableLiveData.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.parts.am
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileMaskPartV3.ba(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData2 = qQSettingMeViewModel.X;
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeProfileMaskPartV3$onPartCreate$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeProfileMaskPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                URLDrawable uRLDrawable;
                Rect U9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeProfileMaskPartV3 qQSettingMeProfileMaskPartV3 = QQSettingMeProfileMaskPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeProfileMaskPartV3.topOffset = it.intValue();
                uRLDrawable = QQSettingMeProfileMaskPartV3.this.zPlanStaticDrawable;
                if (uRLDrawable == null) {
                    return;
                }
                U9 = QQSettingMeProfileMaskPartV3.this.U9();
                uRLDrawable.setBounds(U9);
            }
        };
        mutableLiveData2.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.parts.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeProfileMaskPartV3.ca(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            ThreadManagerV2.getUIHandlerV2().postDelayed(X9(), 500L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        S9();
        ia();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(X9());
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView != null) {
            qQBlurView.onResume();
        }
        if (Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312699h0.getValue())) {
            View view = this.topNoImgMask;
            if (view != null) {
                view.setVisibility(8);
            }
            QLog.i("QQSettingMeProfileMaskPartV3", 1, "topNoImgMask?.visibility = View.GONE");
            return;
        }
        View view2 = this.topNoImgMask;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        QLog.i("QQSettingMeProfileMaskPartV3", 1, "topNoImgMask?.visibility = View.Visible ");
    }

    @Override // com.tencent.mobileqq.part.a
    @RequiresApi(29)
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        int color = ContextCompat.getColor(getActivity(), R.color.qui_common_fill_light_tertiary);
        if (je0.a.a(getActivity())) {
            color = ContextCompat.getColor(getActivity(), R.color.cec);
        }
        GradientDrawable gradientDrawable = this.overLayDrawable;
        if (gradientDrawable != null) {
            gradientDrawable.setColors(new int[]{color, ContextCompat.getColor(getActivity(), R.color.qui_common_bg_bottom_standard), ContextCompat.getColor(getActivity(), R.color.qui_common_bg_bottom_standard)});
        }
        ia();
        ga();
        QQBlurView qQBlurView = this.blurView;
        if (qQBlurView != null) {
            qQBlurView.invalidate();
        }
    }
}
