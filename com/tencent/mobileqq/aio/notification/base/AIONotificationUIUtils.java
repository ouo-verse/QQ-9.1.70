package com.tencent.mobileqq.aio.notification.base;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.viewbinding.ViewBinding;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.notification.AIONotificationBusiId;
import com.tencent.mobileqq.aio.notification.IAIONotificationUIModel;
import com.tencent.mobileqq.aio.notification.base.d;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.util.TokenResUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bY\u0010ZJ,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J<\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J4\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\fJ\u001a\u0010\u001b\u001a\u00020\u001a*\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0017J\u0014\u0010\u001e\u001a\u00020\u001a*\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ\u0014\u0010\u001f\u001a\u00020\u001a*\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ(\u0010#\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!0 J(\u0010$\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!0 J\u0016\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010/\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010)\u001a\u00020'2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010-J\u0016\u00100\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u00101\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u00103\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0005J\u0016\u00104\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0005J\u000e\u00105\u001a\u00020\u00052\u0006\u0010+\u001a\u00020*J7\u0010:\u001a\u00020\u001a2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000\u00a2\u0006\u0004\b:\u0010;J7\u0010<\u001a\u00020\u001a2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000\u00a2\u0006\u0004\b<\u0010;J\u001f\u0010?\u001a\u00020>2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u0017H\u0000\u00a2\u0006\u0004\b?\u0010@J\u001f\u0010D\u001a\u00020\u001a2\u0006\u00107\u001a\u00020A2\u0006\u0010C\u001a\u00020BH\u0000\u00a2\u0006\u0004\bD\u0010EJ7\u0010H\u001a\u00020\u001a2\u0006\u00107\u001a\u00020A2\u0006\u0010G\u001a\u00020F2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0000\u00a2\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020J2\u0006\u0010\r\u001a\u00020\fH\u0000\u00a2\u0006\u0004\bK\u0010LJ\u001f\u0010N\u001a\u00020J2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010M\u001a\u00020JH\u0000\u00a2\u0006\u0004\bN\u0010OJ\u0012\u0010Q\u001a\u00020\u001a*\u00020\u00192\u0006\u0010P\u001a\u00020\u0017J\u0012\u0010R\u001a\u00020\u001a*\u00020\u00192\u0006\u0010P\u001a\u00020\u0017J\u0018\u0010U\u001a\u00020S*\u00020S2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001a0-J\u0018\u0010W\u001a\u00020V*\u00020V2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001a0-J\u0014\u0010X\u001a\u00020\u001a2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001a0-\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/aio/notification/base/AIONotificationUIUtils;", "", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;", "uiModel", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "v", "clickPos", "afterClickState", "t", "r", "Landroid/content/Context;", "context", "", "B", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", ReportConstant.COSTREPORT_PREFIX, "y", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "", "X", "", "duration", "V", BdhLogUtil.LogTag.Tag_Conn, "", "", "notifications", "i", "j", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroidx/viewbinding/ViewBinding;", "k", "viewBinding", "", "isExpandDialogState", "isMultiFoldMode", "Lkotlin/Function0;", "onClickRoot", UserInfo.SEX_FEMALE, "J", "K", com.tencent.luggage.wxa.c8.c.G, "I", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/TextView;", "view", "text", "textColor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Landroid/widget/TextView;Ljava/lang/String;ILcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;Z)V", "T", "colorRes", "Landroid/content/res/ColorStateList;", "E", "(Landroid/content/Context;I)Landroid/content/res/ColorStateList;", "Landroid/widget/ImageView;", "Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;", "busiId", ExifInterface.LATITUDE_SOUTH, "(Landroid/widget/ImageView;Lcom/tencent/mobileqq/aio/notification/AIONotificationBusiId;)V", "Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;", "actionIcon", "N", "(Landroid/widget/ImageView;Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel$ActionIcon;Lcom/tencent/mobileqq/aio/notification/IAIONotificationUIModel;ZZ)V", "Landroid/graphics/drawable/Drawable;", DomainData.DOMAIN_NAME, "(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "drawable", "u", "(Landroid/content/Context;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "height", "Z", "a0", "Landroid/animation/Animator;", "callback", "l", "Landroid/view/ViewPropertyAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONotificationUIUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AIONotificationUIUtils f192828a;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192829a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53561);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[IAIONotificationUIModel.ActionIcon.values().length];
            try {
                iArr[IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IAIONotificationUIModel.ActionIcon.ARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IAIONotificationUIModel.ActionIcon.CLOSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f192829a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/notification/base/AIONotificationUIUtils$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f192830d;

        b(Function0<Unit> function0) {
            this.f192830d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                this.f192830d.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                this.f192830d.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/notification/base/AIONotificationUIUtils$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f192831d;

        c(Function0<Unit> function0) {
            this.f192831d = function0;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                this.f192831d.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            } else {
                this.f192831d.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53568);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            f192828a = new AIONotificationUIUtils();
        }
    }

    AIONotificationUIUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void D(AIONotificationUIUtils aIONotificationUIUtils, View view, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 200;
        }
        aIONotificationUIUtils.C(view, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Function0 function0, IAIONotificationUIModel uiModel, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(uiModel, "$uiModel");
        boolean z17 = false;
        if (function0 != null && ((Boolean) function0.invoke()).booleanValue()) {
            z17 = true;
        }
        if (!z17) {
            Function2<IAIONotificationUIModel, Integer, Unit> eventCallback = uiModel.getEventCallback();
            if (eventCallback != null) {
                eventCallback.invoke(uiModel, 1);
            }
            f192828a.I(z16, uiModel, "1");
        } else {
            f192828a.H(uiModel, "3");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(IAIONotificationUIModel uiModel, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(uiModel, "$uiModel");
        Function2<IAIONotificationUIModel, Integer, Unit> eventCallback = uiModel.getEventCallback();
        if (eventCallback != null) {
            eventCallback.invoke(uiModel, 2);
        }
        f192828a.I(z16, uiModel, "2");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(IAIONotificationUIModel uiModel, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(uiModel, "$uiModel");
        Function2<IAIONotificationUIModel, Integer, Unit> eventCallback = uiModel.getEventCallback();
        if (eventCallback != null) {
            eventCallback.invoke(uiModel, 2);
        }
        f192828a.I(z16, uiModel, "2");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(IAIONotificationUIModel uiModel, boolean z16, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(uiModel, "$uiModel");
        Function2<IAIONotificationUIModel, Integer, Unit> eventCallback = uiModel.getEventCallback();
        if (eventCallback != null) {
            eventCallback.invoke(uiModel, 3);
        }
        f192828a.I(z16, uiModel, "1");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(IAIONotificationUIModel uiModel, boolean z16, String text, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(uiModel, "$uiModel");
        Intrinsics.checkNotNullParameter(text, "$text");
        Function2<IAIONotificationUIModel, Integer, Unit> eventCallback = uiModel.getEventCallback();
        if (eventCallback != null) {
            eventCallback.invoke(uiModel, 3);
        }
        if (z16) {
            f192828a.I(true, uiModel, "3");
        } else if (Intrinsics.areEqual(text, "\u5b8c\u6210")) {
            f192828a.I(false, uiModel, "4");
        } else {
            f192828a.I(false, uiModel, "1");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void W(AIONotificationUIUtils aIONotificationUIUtils, View view, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 200;
        }
        aIONotificationUIUtils.V(view, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(int i3, int i16, int i17, int i18, int i19, int i26, View this_smoothScrollTo, ValueAnimator valueAnimator) {
        Number valueOf;
        Number valueOf2;
        Intrinsics.checkNotNullParameter(this_smoothScrollTo, "$this_smoothScrollTo");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        if (i3 != i16) {
            valueOf = Float.valueOf(i3 + (i17 * floatValue));
        } else {
            valueOf = Integer.valueOf(i3);
        }
        if (i18 != i19) {
            valueOf2 = Float.valueOf(i18 + (i26 * floatValue));
        } else {
            valueOf2 = Integer.valueOf(i18);
        }
        this_smoothScrollTo.scrollTo(valueOf.intValue(), valueOf2.intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(View this_updateLayoutHeightWithAnim, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this_updateLayoutHeightWithAnim, "$this_updateLayoutHeightWithAnim");
        AIONotificationUIUtils aIONotificationUIUtils = f192828a;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        aIONotificationUIUtils.Z(this_updateLayoutHeightWithAnim, ((Integer) animatedValue).intValue());
    }

    private final HashMap<String, String> r(IAIONotificationUIModel uiModel, String clickPos) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("buss_id", String.valueOf(uiModel.b().getId())), new Pair("click_pos", clickPos));
        return hashMapOf;
    }

    private final HashMap<String, String> t(IAIONotificationUIModel uiModel, String clickPos, String afterClickState) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("buss_id", String.valueOf(uiModel.b().getId())), new Pair("click_pos", clickPos), new Pair("after_click_state", afterClickState));
        return hashMapOf;
    }

    private final HashMap<String, String> v(IAIONotificationUIModel uiModel) {
        HashMap<String, String> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("buss_id", String.valueOf(uiModel.b().getId())), new Pair("click_pos", "1"), new Pair("after_click_state", "1"));
        return hashMapOf;
    }

    public final float A(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Float) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimension(R.dimen.f158728ni);
    }

    public final float B(@NotNull Context context, @NotNull IAIONotificationUIModel uiModel) {
        com.tencent.mobileqq.aio.notification.render.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) uiModel)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        d.a aVar = d.f192838a.a().get(uiModel.b());
        if (aVar != null && (d16 = aVar.d()) != null) {
            return d16.c(context);
        }
        return 0.0f;
    }

    public final void C(@NotNull final View view, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, view, Long.valueOf(j3));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() != 0) {
            z16 = false;
        }
        if (!z16 || view.hasTransientState()) {
            return;
        }
        view.setVisibility(0);
        ViewPropertyAnimator duration = view.animate().withLayer().alpha(0.0f).setDuration(j3);
        Intrinsics.checkNotNullExpressionValue(duration, "this.animate()\n         \u2026   .setDuration(duration)");
        m(duration, new Function0<Unit>(view) { // from class: com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils$hideWithAlphaAnim$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $view;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$view = view;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) view);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    this.$view.setAlpha(1.0f);
                    this.$view.setVisibility(8);
                }
            }
        }).start();
    }

    @NotNull
    public final ColorStateList E(@NotNull Context context, int colorRes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context, colorRes);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ColorStateList colorStateList = context.getResources().getColorStateList(colorRes);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.resources.getColorStateList(colorRes)");
        return colorStateList;
    }

    public final void F(@NotNull final IAIONotificationUIModel uiModel, @NotNull ViewBinding viewBinding, final boolean isExpandDialogState, boolean isMultiFoldMode, @Nullable final Function0<Boolean> onClickRoot) {
        com.tencent.mobileqq.aio.notification.render.d d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, uiModel, viewBinding, Boolean.valueOf(isExpandDialogState), Boolean.valueOf(isMultiFoldMode), onClickRoot);
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        d.a aVar = d.f192838a.a().get(uiModel.b());
        if (aVar != null && (d16 = aVar.d()) != null) {
            d16.a(uiModel, viewBinding, isExpandDialogState, isMultiFoldMode);
        }
        viewBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.base.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIONotificationUIUtils.G(Function0.this, uiModel, isExpandDialogState, view);
            }
        });
    }

    public final void H(@NotNull IAIONotificationUIModel uiModel, @NotNull String pos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) uiModel, (Object) pos);
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        Intrinsics.checkNotNullParameter(pos, "pos");
        com.tencent.mobileqq.aio.utils.b.l(q(false), t(uiModel, pos, "2"));
    }

    public final void I(boolean isExpandDialogState, @NotNull IAIONotificationUIModel uiModel, @NotNull String pos) {
        HashMap<String, String> t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(isExpandDialogState), uiModel, pos);
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        Intrinsics.checkNotNullParameter(pos, "pos");
        String q16 = q(isExpandDialogState);
        if (isExpandDialogState) {
            t16 = r(uiModel, pos);
        } else {
            t16 = t(uiModel, pos, "1");
        }
        com.tencent.mobileqq.aio.utils.b.l(q16, t16);
    }

    public final void J(boolean isExpandDialogState, @NotNull IAIONotificationUIModel uiModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Boolean.valueOf(isExpandDialogState), uiModel);
        } else {
            Intrinsics.checkNotNullParameter(uiModel, "uiModel");
            com.tencent.mobileqq.aio.utils.b.q(q(isExpandDialogState), v(uiModel));
        }
    }

    public final void K(boolean isExpandDialogState, @NotNull IAIONotificationUIModel uiModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(isExpandDialogState), uiModel);
        } else {
            Intrinsics.checkNotNullParameter(uiModel, "uiModel");
            com.tencent.mobileqq.aio.utils.b.t(q(isExpandDialogState), v(uiModel));
        }
    }

    public final void L(@NotNull final Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            callback.invoke();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.base.e
                @Override // java.lang.Runnable
                public final void run() {
                    AIONotificationUIUtils.M(Function0.this);
                }
            });
        }
    }

    public final void N(@NotNull ImageView view, @NotNull IAIONotificationUIModel.ActionIcon actionIcon, @NotNull final IAIONotificationUIModel uiModel, final boolean isExpandDialogState, boolean isMultiFoldMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, view, actionIcon, uiModel, Boolean.valueOf(isExpandDialogState), Boolean.valueOf(isMultiFoldMode));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(actionIcon, "actionIcon");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        view.setVisibility(0);
        if (actionIcon != IAIONotificationUIModel.ActionIcon.NONE) {
            int i3 = a.f192829a[actionIcon.ordinal()];
            if (i3 != 1 && i3 != 2) {
                if (i3 == 3) {
                    view.setContentDescription(view.getContext().getString(R.string.ys6));
                    view.setImportantForAccessibility(0);
                    view.setImageResource(R.drawable.qui_close_icon_secondary_01_selector);
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.base.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            AIONotificationUIUtils.P(IAIONotificationUIModel.this, isExpandDialogState, view2);
                        }
                    });
                    return;
                }
                return;
            }
            if (actionIcon == IAIONotificationUIModel.ActionIcon.CLICKABLE_ARROW) {
                view.setContentDescription(view.getContext().getString(R.string.ys5));
                view.setImportantForAccessibility(0);
                view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.base.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        AIONotificationUIUtils.O(IAIONotificationUIModel.this, isExpandDialogState, view2);
                    }
                });
            } else {
                view.setImportantForAccessibility(2);
                view.setOnClickListener(null);
            }
            if (isMultiFoldMode) {
                view.setVisibility(4);
                return;
            }
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view.setImageDrawable(n(context));
            view.setVisibility(0);
            return;
        }
        view.setImageDrawable(null);
        view.setOnClickListener(null);
        view.setVisibility(4);
    }

    public final void Q(@NotNull TextView view, @NotNull String text, int textColor, @NotNull final IAIONotificationUIModel uiModel, final boolean isExpandDialogState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, view, text, Integer.valueOf(textColor), uiModel, Boolean.valueOf(isExpandDialogState));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        view.setText(text);
        if (textColor != 0) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            view.setTextColor(E(context, textColor));
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.base.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AIONotificationUIUtils.R(IAIONotificationUIModel.this, isExpandDialogState, view2);
            }
        });
    }

    public final void S(@NotNull ImageView view, @NotNull AIONotificationBusiId busiId) {
        com.tencent.mobileqq.aio.notification.render.a aVar;
        Drawable mutate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view, (Object) busiId);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(busiId, "busiId");
        d.a aVar2 = d.f192838a.a().get(busiId);
        if (aVar2 != null) {
            aVar = aVar2.b();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if (QQTheme.isNowSimpleUI() && aVar.b() > 0) {
                Drawable drawable = ContextCompat.getDrawable(BaseApplication.context, aVar.b());
                if (drawable != null && (mutate = drawable.mutate()) != null) {
                    mutate.setColorFilter(new PorterDuffColorFilter(ResourcesCompat.getColor(BaseApplication.context.getResources(), R.color.qui_common_text_primary, null), PorterDuff.Mode.SRC_ATOP));
                    view.setImageDrawable(mutate);
                    return;
                }
                return;
            }
            if (aVar.a() > 0) {
                view.setImageResource(aVar.a());
                return;
            } else {
                view.setImageDrawable(null);
                return;
            }
        }
        view.setImageDrawable(null);
    }

    public final void T(@NotNull TextView view, @NotNull final String text, int textColor, @NotNull final IAIONotificationUIModel uiModel, final boolean isExpandDialogState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, view, text, Integer.valueOf(textColor), uiModel, Boolean.valueOf(isExpandDialogState));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        Q(view, text, textColor, uiModel, isExpandDialogState);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.notification.base.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AIONotificationUIUtils.U(IAIONotificationUIModel.this, isExpandDialogState, text, view2);
            }
        });
    }

    public final void V(@NotNull View view, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, view, Long.valueOf(j3));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() != 0) {
            z16 = false;
        }
        if (z16 || view.hasTransientState()) {
            return;
        }
        view.setVisibility(0);
        view.setAlpha(0.0f);
        view.animate().withLayer().alpha(1.0f).setDuration(j3).setListener(null).start();
    }

    public final void X(@NotNull final View view, final int i3, final int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        final int scrollX = view.getScrollX();
        final int scrollY = view.getScrollY();
        final int i17 = i3 - scrollX;
        final int i18 = i16 - scrollY;
        if (i17 == 0 && i18 == 0) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.notification.base.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AIONotificationUIUtils.Y(scrollX, i3, i17, scrollY, i16, i18, view, valueAnimator);
            }
        });
        ofFloat.start();
    }

    public final void Z(@NotNull View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) view, i3);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i3;
        view.setLayoutParams(layoutParams);
    }

    public final void a0(@NotNull final View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) view, i3);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "<this>");
        int height = view.getHeight();
        if (height != i3) {
            ValueAnimator ofInt = ValueAnimator.ofInt(height, i3);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.notification.base.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AIONotificationUIUtils.b0(view, valueAnimator);
                }
            });
            ofInt.setDuration(200L);
            ofInt.start();
        }
    }

    public final float i(@NotNull Context context, @NotNull Map<Integer, ? extends List<? extends IAIONotificationUIModel>> notifications) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this, (Object) context, (Object) notifications)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notifications, "notifications");
        float w3 = w(context);
        Iterator<Map.Entry<Integer, ? extends List<? extends IAIONotificationUIModel>>> it = notifications.entrySet().iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            Iterator<? extends IAIONotificationUIModel> it5 = it.next().getValue().iterator();
            while (it5.hasNext()) {
                f16 = f16 + B(context, it5.next()) + w3;
            }
        }
        return Math.max(f16, 0.0f);
    }

    public final float j(@NotNull Context context, @NotNull Map<Integer, ? extends List<? extends IAIONotificationUIModel>> notifications) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this, (Object) context, (Object) notifications)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notifications, "notifications");
        float w3 = w(context);
        float A = A(context);
        Iterator<Map.Entry<Integer, ? extends List<? extends IAIONotificationUIModel>>> it = notifications.entrySet().iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            List<? extends IAIONotificationUIModel> value = it.next().getValue();
            if (!value.isEmpty()) {
                f16 = f16 + B(context, value.get(0)) + A + w3;
            }
        }
        return Math.max(f16, 0.0f);
    }

    @NotNull
    public final ViewBinding k(@NotNull ViewGroup container, @NotNull IAIONotificationUIModel uiModel) {
        com.tencent.mobileqq.aio.notification.render.d d16;
        ViewBinding b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ViewBinding) iPatchRedirector.redirect((short) 16, (Object) this, (Object) container, (Object) uiModel);
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        d.a aVar = d.f192838a.a().get(uiModel.b());
        if (aVar == null || (d16 = aVar.d()) == null || (b16 = d16.b(container)) == null) {
            p81.h g16 = p81.h.g(LayoutInflater.from(container.getContext()), container, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026iner, false\n            )");
            return g16;
        }
        return b16;
    }

    @NotNull
    public final Animator l(@NotNull Animator animator, @NotNull Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (Animator) iPatchRedirector.redirect((short) 32, (Object) this, (Object) animator, (Object) callback);
        }
        Intrinsics.checkNotNullParameter(animator, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        animator.addListener(new b(callback));
        return animator;
    }

    @NotNull
    public final ViewPropertyAnimator m(@NotNull ViewPropertyAnimator viewPropertyAnimator, @NotNull Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (ViewPropertyAnimator) iPatchRedirector.redirect((short) 33, (Object) this, (Object) viewPropertyAnimator, (Object) callback);
        }
        Intrinsics.checkNotNullParameter(viewPropertyAnimator, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        viewPropertyAnimator.setListener(new c(callback));
        return viewPropertyAnimator;
    }

    @NotNull
    public final Drawable n(@NotNull Context context) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (Drawable) iPatchRedirector.redirect((short) 28, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if (TokenResUtils.useTokenIcon()) {
            Drawable drawable2 = resources.getDrawable(R.drawable.qui_chevron_right_icon_secondary_01);
            Intrinsics.checkNotNullExpressionValue(drawable2, "res.getDrawable(com.tenc\u2026_right_icon_secondary_01)");
            return drawable2;
        }
        if (QQTheme.isThemeSimpleUI(QQTheme.getCurrentThemeId())) {
            drawable = resources.getDrawable(R.drawable.mr9);
            Intrinsics.checkNotNullExpressionValue(drawable, "{\n                res.ge\u2026row_simple)\n            }");
        } else {
            drawable = resources.getDrawable(R.drawable.mr8);
            Intrinsics.checkNotNullExpressionValue(drawable, "{\n                res.ge\u2026row_normal)\n            }");
        }
        return u(context, drawable);
    }

    public final float o(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimension(R.dimen.f158721nb);
    }

    public final float p(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimension(R.dimen.f158721nb);
    }

    @NotNull
    public final String q(boolean isExpandDialogState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, isExpandDialogState);
        }
        if (isExpandDialogState) {
            return "em_bas_aio_asynchronous_msg_pop";
        }
        return "em_bas_aio_asynchronous_msg";
    }

    public final float s(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Float) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimension(R.dimen.f158715n5);
    }

    @NotNull
    public final Drawable u(@NotNull Context context, @NotNull Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (Drawable) iPatchRedirector.redirect((short) 29, (Object) this, (Object) context, (Object) drawable);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        Resources resources = context.getResources();
        if (resources == null) {
            return drawable;
        }
        if (bitmap != null && createBitmap == null) {
            createBitmap = bitmap;
        } else if (bitmap == null && createBitmap == null) {
            return drawable;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(resources, createBitmap);
        bitmapDrawable2.setAlpha(127);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, bitmapDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, bitmapDrawable);
        stateListDrawable.addState(new int[0], bitmapDrawable);
        return stateListDrawable;
    }

    public final float w(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimension(R.dimen.f158728ni);
    }

    public final int x(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) context.getResources().getDimension(R.dimen.c_n);
    }

    public final float y(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ViewUtils viewUtils = ViewUtils.f352270a;
        if (viewUtils.d() < com.tencent.qqnt.aio.utils.l.b(640)) {
            return viewUtils.d() - com.tencent.qqnt.aio.utils.l.b(128);
        }
        return com.tencent.qqnt.aio.utils.l.b(512);
    }

    public final float z(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this, (Object) context)).floatValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return y(context) - p(context);
    }
}
