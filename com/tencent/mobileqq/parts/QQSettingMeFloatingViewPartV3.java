package com.tencent.mobileqq.parts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.DrawerUtils;
import com.tencent.mobileqq.utils.de;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010&R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010&\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeFloatingViewPartV3;", "Lcom/tencent/mobileqq/part/a;", "", "zPlanMenuHeight", "", "ha", "X9", "ea", "", "hasCover", "W9", "Lcom/tencent/mobileqq/widget/QQSettingMeFloatingViewV3$e;", "V9", "ga", "showCorner", "ia", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "z9", "onPostThemeChanged", "Lcom/tencent/mobileqq/widget/QQSettingMeFloatingViewV3;", "f", "Lcom/tencent/mobileqq/widget/QQSettingMeFloatingViewV3;", "drawerContentFloatingView", tl.h.F, "Landroid/view/View;", "contentView", "i", "drawerScrollView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "navigationBarHeight", BdhLogUtil.LogTag.Tag_Conn, "drawerMinHeight", "D", "E", "currentMode", UserInfo.SEX_FEMALE, "Z", "isMenuRootBgValid", "G", "isResume", "", "H", "Ljava/lang/String;", "pageId", "topZplanMargin", "<init>", "()V", "J", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QQSettingMeFloatingViewPartV3 extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int drawerMinHeight;

    /* renamed from: D, reason: from kotlin metadata */
    private int zPlanMenuHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private int currentMode;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isMenuRootBgValid;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isResume;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String pageId;

    /* renamed from: I, reason: from kotlin metadata */
    private int topZplanMargin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQSettingMeFloatingViewV3 drawerContentFloatingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View drawerScrollView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int navigationBarHeight;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/parts/QQSettingMeFloatingViewPartV3$a;", "", "", "NORMAL_MENU_MIN_HEIGHT", UserInfo.SEX_FEMALE, "SCALE_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.QQSettingMeFloatingViewPartV3$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ&\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/parts/QQSettingMeFloatingViewPartV3$b", "Lcom/tencent/mobileqq/widget/QQSettingMeFloatingViewV3$e;", "Landroid/animation/AnimatorSet;", "down", "", "e", "Landroid/view/View;", "contentView", "", "targetY", "", "isMoveToMin", "", "animaDuration", "Lcom/tencent/mobileqq/widget/QQSettingMeFloatingViewV3$f;", "helper", "a", "c", "d", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements QQSettingMeFloatingViewV3.e {
        static IPatchRedirector $redirector_;

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/parts/QQSettingMeFloatingViewPartV3$b$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "isReverse", "", "onAnimationEnd", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class a extends AnimatorListenerAdapter {
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ AnimatorSet f257300e;

            a(AnimatorSet animatorSet) {
                this.f257300e = animatorSet;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) animatorSet);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(@NotNull Animator animation, boolean isReverse) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, animation, Boolean.valueOf(isReverse));
                } else {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    b.this.e(this.f257300e);
                }
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeFloatingViewPartV3.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(AnimatorSet down) {
            down.start();
            ((QQSettingMeViewModel) QQSettingMeFloatingViewPartV3.this.getViewModel(QQSettingMeViewModel.class)).f312693b0.postValue(1);
        }

        @Override // com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3.e
        public void a(@NotNull View contentView, float targetY, boolean isMoveToMin, long animaDuration, @NotNull QQSettingMeFloatingViewV3.f helper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, contentView, Float.valueOf(targetY), Boolean.valueOf(isMoveToMin), Long.valueOf(animaDuration), helper);
                return;
            }
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            Intrinsics.checkNotNullParameter(helper, "helper");
            QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
            if (qQSettingMeFloatingViewV3 != null) {
                qQSettingMeFloatingViewV3.setForbidTouchEvent(true);
                if (isMoveToMin) {
                    c(contentView, targetY, animaDuration, helper);
                } else {
                    d(contentView, targetY, animaDuration, helper);
                }
            }
        }

        public final void c(@NotNull View contentView, float targetY, long animaDuration, @NotNull QQSettingMeFloatingViewV3.f helper) {
            int i3;
            int i16;
            boolean z16;
            ObjectAnimator translationY2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, contentView, Float.valueOf(targetY), Long.valueOf(animaDuration), helper);
                return;
            }
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            Intrinsics.checkNotNullParameter(helper, "helper");
            float y16 = contentView.getY();
            QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
            if (qQSettingMeFloatingViewV3 != null) {
                i3 = qQSettingMeFloatingViewV3.o();
            } else {
                i3 = 0;
            }
            QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
            if (qQSettingMeFloatingViewV32 != null) {
                i16 = qQSettingMeFloatingViewV32.p();
            } else {
                i16 = 0;
            }
            if (y16 > (i16 + i3) * 0.27f && de.f307628a.c()) {
                z16 = true;
            } else {
                z16 = false;
            }
            ObjectAnimator translationY = ObjectAnimator.ofFloat(contentView, "y", y16, y16 - ex.d(5));
            AnimatorSet animatorSet = new AnimatorSet();
            if (z16) {
                translationY2 = ObjectAnimator.ofFloat(contentView, "y", y16 - ex.d(5), y16 - ex.d(15), targetY);
            } else {
                translationY2 = ObjectAnimator.ofFloat(contentView, "y", y16, targetY);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(contentView, BasicAnimation.KeyPath.SCALE_X, 1.0f, 0.9f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(contentView, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.9f);
            animatorSet.setDuration(animaDuration);
            animatorSet.playTogether(translationY2, ofFloat, ofFloat2);
            translationY.addListener(new a(animatorSet));
            translationY.setInterpolator(new DecelerateInterpolator(0.5f));
            animatorSet.setInterpolator(new DecelerateInterpolator(0.5f));
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(translationY, "translationY");
            arrayList.add(translationY);
            Intrinsics.checkNotNullExpressionValue(translationY2, "translationY2");
            arrayList.add(translationY2);
            helper.a(animatorSet, arrayList, true);
            if (z16) {
                translationY.setDuration(50L).start();
            } else {
                e(animatorSet);
            }
        }

        public final void d(@NotNull View contentView, float targetY, long animaDuration, @NotNull QQSettingMeFloatingViewV3.f helper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, contentView, Float.valueOf(targetY), Long.valueOf(animaDuration), helper);
                return;
            }
            Intrinsics.checkNotNullParameter(contentView, "contentView");
            Intrinsics.checkNotNullParameter(helper, "helper");
            ObjectAnimator translationY = ObjectAnimator.ofFloat(contentView, "y", contentView.getY(), targetY);
            ArrayList arrayList = new ArrayList();
            arrayList.add(translationY);
            float scaleX = contentView.getScaleX();
            if (scaleX < 1.0f) {
                arrayList.add(ObjectAnimator.ofFloat(contentView, BasicAnimation.KeyPath.SCALE_X, scaleX, 1.0f));
            }
            float scaleY = contentView.getScaleY();
            if (scaleY < 1.0f) {
                arrayList.add(ObjectAnimator.ofFloat(contentView, BasicAnimation.KeyPath.SCALE_Y, scaleY, 1.0f));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            int size = arrayList.size();
            Animator[] animatorArr = new Animator[size];
            arrayList.toArray(animatorArr);
            animatorSet.playTogether((Animator[]) Arrays.copyOf(animatorArr, size));
            translationY.setInterpolator(new DecelerateInterpolator(0.5f));
            ArrayList arrayList2 = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(translationY, "translationY");
            arrayList2.add(translationY);
            helper.a(translationY, arrayList2, false);
            animatorSet.setDuration(animaDuration).start();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/parts/QQSettingMeFloatingViewPartV3$c", "Lcom/tencent/mobileqq/widget/QQSettingMeFloatingViewV3$h;", "", "onShowDefault", "onShowMin", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c implements QQSettingMeFloatingViewV3.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeFloatingViewPartV3.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3.h
        public void onShowDefault() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("QQSettingMeFloatingViewPartV3", 2, "onShowDefault: drawer");
            QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
            if (qQSettingMeFloatingViewV3 != null) {
                qQSettingMeFloatingViewV3.setForbidTouchEvent(false);
            }
            ((QQSettingMeViewModel) QQSettingMeFloatingViewPartV3.this.getViewModel(QQSettingMeViewModel.class)).V.postValue(0);
            if (QQSettingMeFloatingViewPartV3.this.isResume && !Intrinsics.areEqual(QQSettingMeFloatingViewPartV3.this.pageId, "pg_bas_drawer")) {
                QQSettingMeFloatingViewPartV3.this.pageId = "pg_bas_drawer";
                VideoReport.setPageId(QQSettingMeFloatingViewPartV3.this.getPartRootView(), QQSettingMeFloatingViewPartV3.this.pageId);
                VideoReport.reportEvent("dt_pgin", QQSettingMeFloatingViewPartV3.this.getPartRootView(), null);
            }
        }

        @Override // com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3.h
        public void onShowMin() {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.i("QQSettingMeFloatingViewPartV3", 2, "onShowMin: drawer");
            QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
            if (qQSettingMeFloatingViewV3 != null) {
                qQSettingMeFloatingViewV3.setForbidTouchEvent(true);
            }
            if (QQSettingMeFloatingViewPartV3.this.currentMode == 2) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            ((QQSettingMeViewModel) QQSettingMeFloatingViewPartV3.this.getViewModel(QQSettingMeViewModel.class)).V.postValue(Integer.valueOf(i3));
            QUIImmersiveHelper.s(QQSettingMeFloatingViewPartV3.this.getActivity(), false, true);
            if (QQSettingMeFloatingViewPartV3.this.currentMode != 2 && QQSettingMeFloatingViewPartV3.this.isResume && !Intrinsics.areEqual(QQSettingMeFloatingViewPartV3.this.pageId, "pg_drawer_zplan_manage")) {
                QQSettingMeFloatingViewPartV3.this.pageId = "pg_drawer_zplan_manage";
                VideoReport.setPageId(QQSettingMeFloatingViewPartV3.this.getPartRootView(), QQSettingMeFloatingViewPartV3.this.pageId);
                VideoReport.reportEvent("dt_pgin", QQSettingMeFloatingViewPartV3.this.getPartRootView(), null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/parts/QQSettingMeFloatingViewPartV3$d", "Lcom/tencent/mobileqq/widget/au;", "Landroid/view/ViewGroup;", "viewGroup", "Landroid/view/View;", "b", "", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d implements com.tencent.mobileqq.widget.au {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeFloatingViewPartV3.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.au
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return QQSettingMeFloatingViewPartV3.this.W9(false);
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        @Override // com.tencent.mobileqq.widget.au
        @Nullable
        public View b(@Nullable ViewGroup viewGroup) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
            }
            QQSettingMeFloatingViewPartV3 qQSettingMeFloatingViewPartV3 = QQSettingMeFloatingViewPartV3.this;
            qQSettingMeFloatingViewPartV3.contentView = LayoutInflater.from(qQSettingMeFloatingViewPartV3.getActivity()).inflate(R.layout.h48, viewGroup, false);
            return QQSettingMeFloatingViewPartV3.this.contentView;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27843);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeFloatingViewPartV3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isMenuRootBgValid = true;
            this.pageId = "pg_bas_drawer";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQSettingMeFloatingViewV3.e V9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int W9(boolean hasCover) {
        if (hasCover) {
            int i3 = this.topZplanMargin;
            if (i3 <= 0) {
                return com.tencent.mobileqq.activity.qqsettingme.utils.b.b();
            }
            return i3;
        }
        return com.tencent.mobileqq.activity.qqsettingme.utils.b.b() - 1;
    }

    private final void X9() {
        if (this.drawerContentFloatingView == null) {
            return;
        }
        ea();
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV3 != null) {
            qQSettingMeFloatingViewV3.setOutSideTouchEnable(false);
        }
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV32 != null) {
            qQSettingMeFloatingViewV32.setOnShowEventListener(new c());
        }
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV33 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV33 != null) {
            qQSettingMeFloatingViewV33.setTopUpdateObserver(getPartHost().getLifecycleOwner(), new QQSettingMeFloatingViewV3.g() { // from class: com.tencent.mobileqq.parts.r
                @Override // com.tencent.mobileqq.widget.QQSettingMeFloatingViewV3.g
                public final void a(float f16) {
                    QQSettingMeFloatingViewPartV3.Y9(QQSettingMeFloatingViewPartV3.this, f16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(QQSettingMeFloatingViewPartV3 this$0, float f16) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class);
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = this$0.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV3 != null) {
            i3 = qQSettingMeFloatingViewV3.n();
        } else {
            i3 = 0;
        }
        qQSettingMeViewModel.f312702j0 = i3;
        ((QQSettingMeViewModel) this$0.getViewModel(QQSettingMeViewModel.class)).T1().postValue(Float.valueOf(f16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
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

    private final void ea() {
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV3 != null) {
            qQSettingMeFloatingViewV3.A();
        }
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV32 != null) {
            qQSettingMeFloatingViewV32.setController(new d());
        }
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312693b0.postValue(2);
    }

    private final void ga() {
        if (!this.isMenuRootBgValid) {
            View view = this.contentView;
            if (view != null) {
                view.setBackground(DrawerUtils.f306948a.d(ex.d(108)));
                return;
            }
            return;
        }
        View view2 = this.contentView;
        if (view2 != null) {
            view2.setBackground(ex.c(R.drawable.kx8));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(int zPlanMenuHeight) {
        if (this.zPlanMenuHeight == zPlanMenuHeight) {
            return;
        }
        this.zPlanMenuHeight = zPlanMenuHeight;
        int d16 = ((int) (zPlanMenuHeight / 0.9f)) + ex.d(Float.valueOf(24.0f));
        this.drawerMinHeight = d16;
        if (d16 > 0) {
            QLog.i("QQSettingMeFloatingViewPartV3", 2, "minHeight ZPlan: " + this.drawerMinHeight);
        } else {
            this.drawerMinHeight = (int) (((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).Q1() * 0.4f);
            QLog.i("QQSettingMeFloatingViewPartV3", 2, "minHeight default: " + this.drawerMinHeight);
        }
        if (this.currentMode == 1) {
            QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = this.drawerContentFloatingView;
            if (qQSettingMeFloatingViewV3 != null) {
                qQSettingMeFloatingViewV3.setMinHeight(this.drawerMinHeight);
                return;
            }
            return;
        }
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV32 != null) {
            qQSettingMeFloatingViewV32.setMinHeight(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(boolean showCorner) {
        if (showCorner) {
            View view = this.drawerScrollView;
            if (view != null) {
                view.setBackground(null);
                return;
            }
            return;
        }
        View view2 = this.drawerScrollView;
        if (view2 != null) {
            view2.setBackground(DrawerUtils.f306948a.d(0));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        Drawable drawable = null;
        if (rootView != null) {
            qQSettingMeFloatingViewV3 = (QQSettingMeFloatingViewV3) rootView.findViewById(R.id.f166016ye4);
        } else {
            qQSettingMeFloatingViewV3 = null;
        }
        this.drawerContentFloatingView = qQSettingMeFloatingViewV3;
        this.navigationBarHeight = ex.d(48) + ImmersiveUtils.getStatusBarHeight(getActivity());
        X9();
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV32 != null) {
            view = qQSettingMeFloatingViewV32.findViewById(R.id.un8);
        } else {
            view = null;
        }
        this.drawerScrollView = view;
        DrawerUtils drawerUtils = DrawerUtils.f306948a;
        View view2 = this.contentView;
        if (view2 != null) {
            drawable = view2.getBackground();
        }
        this.isMenuRootBgValid = drawerUtils.a(drawable);
        ga();
        ia(Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).R1().getValue()));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        QQSettingMeViewModel qQSettingMeViewModel = (QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class);
        MutableLiveData<Integer> mutableLiveData = qQSettingMeViewModel.f312693b0;
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeFloatingViewPartV3$onPartCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeFloatingViewPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                if (num != null && num.intValue() == 2) {
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV32 != null) {
                        qQSettingMeFloatingViewV32.C();
                        return;
                    }
                    return;
                }
                if (num == null || num.intValue() != 3 || (qQSettingMeFloatingViewV3 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView) == null) {
                    return;
                }
                qQSettingMeFloatingViewV3.E();
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.parts.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeFloatingViewPartV3.Z9(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData2 = qQSettingMeViewModel.f312695d0;
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function12 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeFloatingViewPartV3$onPartCreate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeFloatingViewPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer it) {
                int i3;
                QQSettingMeFloatingViewV3.e V9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                if (qQSettingMeFloatingViewV3 != null) {
                    qQSettingMeFloatingViewV3.C();
                }
                QQSettingMeFloatingViewPartV3 qQSettingMeFloatingViewPartV3 = QQSettingMeFloatingViewPartV3.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qQSettingMeFloatingViewPartV3.currentMode = it.intValue();
                if (it.intValue() == 0) {
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV32 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV32 != null) {
                        qQSettingMeFloatingViewV32.setEnableMoveToMin(false);
                    }
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV33 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV33 != null) {
                        qQSettingMeFloatingViewV33.setEnableMoveToHalf(true);
                        return;
                    }
                    return;
                }
                if (it.intValue() == 1) {
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV34 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV34 != null) {
                        qQSettingMeFloatingViewV34.setEnableMoveToMin(true);
                    }
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV35 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV35 != null) {
                        V9 = QQSettingMeFloatingViewPartV3.this.V9();
                        qQSettingMeFloatingViewV35.setCustomMoveAnimator(V9);
                    }
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV36 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV36 != null) {
                        i3 = QQSettingMeFloatingViewPartV3.this.drawerMinHeight;
                        qQSettingMeFloatingViewV36.setMinHeight(i3);
                    }
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV37 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV37 != null) {
                        qQSettingMeFloatingViewV37.setEnableMoveToHalf(false);
                        return;
                    }
                    return;
                }
                if (it.intValue() == 2) {
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV38 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV38 != null) {
                        qQSettingMeFloatingViewV38.setEnableMoveToMin(true);
                    }
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV39 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV39 != null) {
                        qQSettingMeFloatingViewV39.setCustomMoveAnimator(null);
                    }
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV310 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV310 != null) {
                        qQSettingMeFloatingViewV310.setMinHeight(0);
                    }
                    QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV311 = QQSettingMeFloatingViewPartV3.this.drawerContentFloatingView;
                    if (qQSettingMeFloatingViewV311 != null) {
                        qQSettingMeFloatingViewV311.setEnableMoveToHalf(false);
                    }
                }
            }
        };
        mutableLiveData2.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.parts.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeFloatingViewPartV3.aa(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> S1 = qQSettingMeViewModel.S1();
        LifecycleOwner lifecycleOwner3 = getPartHost().getLifecycleOwner();
        final QQSettingMeFloatingViewPartV3$onPartCreate$3 qQSettingMeFloatingViewPartV3$onPartCreate$3 = new QQSettingMeFloatingViewPartV3$onPartCreate$3(this, qQSettingMeViewModel);
        S1.observe(lifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.parts.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeFloatingViewPartV3.ba(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> R1 = qQSettingMeViewModel.R1();
        LifecycleOwner lifecycleOwner4 = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeFloatingViewPartV3$onPartCreate$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeFloatingViewPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean isShowCorner) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) isShowCorner);
                    return;
                }
                QQSettingMeFloatingViewPartV3 qQSettingMeFloatingViewPartV3 = QQSettingMeFloatingViewPartV3.this;
                Intrinsics.checkNotNullExpressionValue(isShowCorner, "isShowCorner");
                qQSettingMeFloatingViewPartV3.ia(isShowCorner.booleanValue());
            }
        };
        R1.observe(lifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.parts.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeFloatingViewPartV3.ca(Function1.this, obj);
            }
        });
        MutableLiveData<Integer> mutableLiveData3 = qQSettingMeViewModel.f312701i0;
        LifecycleOwner lifecycleOwner5 = getPartHost().getLifecycleOwner();
        final Function1<Integer, Unit> function14 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.parts.QQSettingMeFloatingViewPartV3$onPartCreate$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeFloatingViewPartV3.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer zPlanMenuHeight) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) zPlanMenuHeight);
                    return;
                }
                QQSettingMeFloatingViewPartV3 qQSettingMeFloatingViewPartV3 = QQSettingMeFloatingViewPartV3.this;
                Intrinsics.checkNotNullExpressionValue(zPlanMenuHeight, "zPlanMenuHeight");
                qQSettingMeFloatingViewPartV3.ha(zPlanMenuHeight.intValue());
            }
        };
        mutableLiveData3.observe(lifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.parts.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeFloatingViewPartV3.da(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartPause(activity);
            this.isResume = false;
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
        this.isResume = true;
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV3 != null) {
            qQSettingMeFloatingViewV3.C();
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        ia(Intrinsics.areEqual(Boolean.TRUE, ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).R1().getValue()));
        ga();
        QQSettingMeFloatingViewV3 qQSettingMeFloatingViewV3 = this.drawerContentFloatingView;
        if (qQSettingMeFloatingViewV3 != null) {
            qQSettingMeFloatingViewV3.z();
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void z9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.z9();
        ((QQSettingMeViewModel) getViewModel(QQSettingMeViewModel.class)).f312693b0.postValue(2);
        View view = this.drawerScrollView;
        if (view != null) {
            view.scrollTo(0, 0);
        }
    }
}
