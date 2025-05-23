package com.tencent.sqshow.zootopia.operation.facead;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.CheckBox;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.operation.facead.h;
import com.tencent.sqshow.zootopia.operation.facead.report.ZootopiaFaceAdReport;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 T2\u00020\u0001:\u0002UVB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J:\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001a\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020\u0016H\u0002J\u001a\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00162\b\b\u0002\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010%\u001a\u00020\u0007H\u0002J\b\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0014\u0010/\u001a\u00060.R\u00020\u00002\u0006\u0010-\u001a\u00020,H\u0002R\u0016\u00102\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00109R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010:R\u001c\u0010=\u001a\b\u0018\u00010.R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010P\u00a8\u0006W"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/h;", "Lcom/tencent/sqshow/zootopia/operation/facead/b;", "", "U8", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnw4/h;", "faceAdInfo", "", "y", "Lcom/tencent/sqshow/zootopia/operation/facead/a;", "faceAdListener", "Landroid/view/ViewGroup;", "parentContainer", HippyTKDListViewAdapter.X, "M8", "Landroid/content/res/Configuration;", "newConfig", ReportConstant.COSTREPORT_PREFIX, "u", "v", "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "isFirstShown", "fragmentContainer", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "p", "Landroid/view/View;", "clickedView", "r", "isError", "isClickJump", DomainData.DOMAIN_NAME, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "w", "l", "k", "isMax", "B", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/operation/facead/h$b;", "i", "d", "Ljava/lang/String;", "faceAdId", "e", "Lnw4/h;", "f", "Lcom/tencent/sqshow/zootopia/operation/facead/a;", tl.h.F, "Landroid/view/ViewGroup;", "Landroid/os/Bundle;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/operation/facead/h$b;", "viewHolder", "D", "Z", "isPausing", "E", "isShowing", UserInfo.SEX_FEMALE, "needClearViewCache", "", "G", "J", "autoHideStartTime", "H", "autoHidePreCountTime", "Landroid/os/Handler;", "I", "Landroid/os/Handler;", "handler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "autoHideRunnable", "<init>", "()V", "K", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class h implements com.tencent.sqshow.zootopia.operation.facead.b {

    /* renamed from: K, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private b viewHolder;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isPausing;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isShowing;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean needClearViewCache;

    /* renamed from: G, reason: from kotlin metadata */
    private long autoHideStartTime;

    /* renamed from: H, reason: from kotlin metadata */
    private long autoHidePreCountTime;

    /* renamed from: I, reason: from kotlin metadata */
    private Handler handler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private nw4.h faceAdInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private a faceAdListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewGroup parentContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Bundle arguments;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource sourceCurrent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String faceAdId = "";

    /* renamed from: J, reason: from kotlin metadata */
    private final Runnable autoHideRunnable = new Runnable() { // from class: com.tencent.sqshow.zootopia.operation.facead.g
        @Override // java.lang.Runnable
        public final void run() {
            h.h(h.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\u00020\u0005*\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u0014\u0010\u0007\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/h$a;", "", "Landroid/animation/ValueAnimator;", "", "info", "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.operation.facead.h$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(ValueAnimator valueAnimator, String str) {
            if (valueAnimator != null) {
                QLog.d("ZplanFaceAdNativeHandler", 1, "destroy " + str);
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.end();
                valueAnimator.cancel();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bY\u0010ZJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0014\u001a\u00020\u0002J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aR$\u0010#\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010'\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00103\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010*\u001a\u0004\b1\u0010,\"\u0004\b2\u0010.R$\u00107\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001e\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010M\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010Q\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010H\u001a\u0004\bO\u0010J\"\u0004\bP\u0010LR$\u0010U\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010H\u001a\u0004\bS\u0010J\"\u0004\bT\u0010LR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010W\u00a8\u0006["}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/h$b;", "", "", "isClickJump", "", "B", "", "startTime", "isFirstShown", "u", "t", BdhLogUtil.LogTag.Tag_Conn, "E", "Landroid/view/View;", "view", "isMainImg", "D", "o", "k", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lnw4/h;", "faceAdInfo", "H", ReportConstant.COSTREPORT_PREFIX, "r", "Landroid/animation/Animator$AnimatorListener;", "animationListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "Landroid/view/View;", "v", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "b", "getBg", "setBg", VasProfileTemplatePreloadHelper.BACKGROUND, "Lcom/tencent/image/URLImageView;", "c", "Lcom/tencent/image/URLImageView;", "getMainImg", "()Lcom/tencent/image/URLImageView;", "setMainImg", "(Lcom/tencent/image/URLImageView;)V", "mainImg", "d", "getActionButtonImg", "setActionButtonImg", "actionButtonImg", "e", "getCloseView", "setCloseView", "closeView", "Landroid/widget/CheckBox;", "f", "Landroid/widget/CheckBox;", "getNoMoreShown", "()Landroid/widget/CheckBox;", "setNoMoreShown", "(Landroid/widget/CheckBox;)V", "noMoreShown", "g", "Lnw4/h;", "getFaceAdInfo", "()Lnw4/h;", "setFaceAdInfo", "(Lnw4/h;)V", "Landroid/animation/ValueAnimator;", tl.h.F, "Landroid/animation/ValueAnimator;", "getInfiniteScaleAnimator", "()Landroid/animation/ValueAnimator;", "setInfiniteScaleAnimator", "(Landroid/animation/ValueAnimator;)V", "infiniteScaleAnimator", "i", "getFaceAdShowAnimator", "G", "faceAdShowAnimator", "j", "getFaceAdHidenAnimator", UserInfo.SEX_FEMALE, "faceAdHidenAnimator", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "dtViewReporter", "<init>", "(Lcom/tencent/sqshow/zootopia/operation/facead/h;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private View contentView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private View bg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private URLImageView mainImg;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private URLImageView actionButtonImg;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private View closeView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private CheckBox noMoreShown;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private nw4.h faceAdInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private ValueAnimator infiniteScaleAnimator;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private ValueAnimator faceAdShowAnimator;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private ValueAnimator faceAdHidenAnimator;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final ZplanViewReportHelper dtViewReporter = new ZplanViewReportHelper();

        /* compiled from: P */
        @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/h$b$c", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "p0", "Lcom/tencent/image/URLDrawable;", "p1", "", "onLoadSuccessed", "", "p2", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "onLoadInterrupted", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class c implements URLDrawableDownListener {
            c() {
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadCancelled(View p06, URLDrawable p16) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "actionButtonImg#onLoadCancelled - " + p16);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadFailed(View p06, URLDrawable p16, Throwable p26) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "actionButtonImg#onLoadFailed - " + p16);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadInterrupted(View p06, URLDrawable p16, InterruptedException p26) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "actionButtonImg#onLoadInterrupted - " + p16);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadProgressed(View p06, URLDrawable p16, int p26) {
                QLog.i("ZplanFaceAdNativeHandler", 1, "actionButtonImg#onLoadProgressed - " + p16 + " -- " + p26);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadSuccessed(View p06, URLDrawable p16) {
                QLog.i("ZplanFaceAdNativeHandler", 1, "actionButtonImg#onLoadSuccessed - " + p16);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/h$b$d", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "p0", "Lcom/tencent/image/URLDrawable;", "p1", "", "onLoadSuccessed", "", "p2", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "onLoadInterrupted", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class d implements URLDrawableDownListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f372170d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ b f372171e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f372172f;

            d(long j3, b bVar, boolean z16) {
                this.f372170d = j3;
                this.f372171e = bVar;
                this.f372172f = z16;
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadCancelled(View p06, URLDrawable p16) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "mainImg#onLoadCancelled - " + p16);
                this.f372171e.t(this.f372170d);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadFailed(View p06, URLDrawable p16, Throwable p26) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "mainImg#onLoadFailed - " + p16);
                this.f372171e.t(this.f372170d);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadInterrupted(View p06, URLDrawable p16, InterruptedException p26) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "mainImg#onLoadInterrupted - " + p16);
                this.f372171e.t(this.f372170d);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadProgressed(View p06, URLDrawable p16, int p26) {
                QLog.i("ZplanFaceAdNativeHandler", 1, "mainImg#onLoadProgressed - " + p16 + " -- " + p26);
            }

            @Override // com.tencent.image.URLDrawableDownListener
            public void onLoadSuccessed(View p06, URLDrawable p16) {
                QLog.i("ZplanFaceAdNativeHandler", 1, "mainImg#onLoadSuccessed - " + p16 + " - costTime= " + (System.currentTimeMillis() - this.f372170d) + "ms");
                this.f372171e.u(this.f372170d, this.f372172f);
            }
        }

        public b() {
        }

        private final void B(boolean isClickJump) {
            CheckBox checkBox = this.noMoreShown;
            QLog.i("ZplanFaceAdNativeHandler", 1, "manualDismissSelf, noMoreShown: " + (checkBox != null ? Boolean.valueOf(checkBox.isChecked()) : null));
            h.this.n(false, isClickJump);
        }

        private final void C() {
            String str;
            View view = this.contentView;
            if (view != null) {
                h hVar = h.this;
                HashMap hashMap = new HashMap();
                nw4.h hVar2 = this.faceAdInfo;
                if (hVar2 != null) {
                    ZootopiaSource zootopiaSource = hVar.sourceCurrent;
                    if (zootopiaSource == null || (str = ah.b(zootopiaSource)) == null) {
                        str = "";
                    }
                    hashMap.put("zplan_activity_entrance", str);
                    String str2 = hVar2.f421494m;
                    Intrinsics.checkNotNullExpressionValue(str2, "it.activityId");
                    hashMap.put("zplan_poster_id", str2);
                    String str3 = hVar2.f421496o;
                    Intrinsics.checkNotNullExpressionValue(str3, "it.zplanActId");
                    hashMap.put("zplan_act_id", str3);
                }
                new id3.d(null, 1, null).k(view, "pg_zplan_poster", hashMap);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
        
            if (r1.isChecked() == true) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void D(View view, boolean isMainImg) {
            int i3;
            String str;
            String l3;
            HashMap hashMap = new HashMap();
            CheckBox checkBox = this.noMoreShown;
            if (checkBox != null) {
                i3 = 1;
            }
            i3 = 0;
            hashMap.put(SquareReportConst.Key.KEY_IS_TICK, Integer.valueOf(i3));
            if (isMainImg) {
                nw4.h hVar = this.faceAdInfo;
                hashMap.put("zplan_jump_type", Integer.valueOf(hVar != null ? hVar.f421487f : 0));
            }
            ZplanViewReportHelper zplanViewReportHelper = this.dtViewReporter;
            if (isMainImg) {
                str = "em_zplan_jump_area";
            } else {
                str = "em_zplan_close";
            }
            zplanViewReportHelper.e(view, str, hashMap);
            nw4.h hVar2 = this.faceAdInfo;
            if (hVar2 == null || (l3 = Long.valueOf(hVar2.f421482a).toString()) == null) {
                return;
            }
            ab4.b bVar = ab4.b.f25786a;
            ab4.b.k(bVar, bVar.c(), l3, null, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k() {
            h.INSTANCE.b(this.infiniteScaleAnimator, "infiniteScaleAnimator");
            QLog.d("ZplanFaceAdNativeHandler", 1, "new infiniteScaleAnimator");
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(1340L);
            ofFloat.setRepeatCount(-1);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.operation.facead.o
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    h.b.l(h.b.this, valueAnimator);
                }
            });
            ofFloat.start();
            this.infiniteScaleAnimator = ofFloat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(b this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            float f16 = floatValue <= 0.5f ? 1 + ((floatValue / 0.5f) * 0.13f) : 1.13f - (((floatValue - 0.5f) / 0.5f) * 0.13f);
            URLImageView uRLImageView = this$0.actionButtonImg;
            if (uRLImageView != null) {
                uRLImageView.setScaleX(f16);
                uRLImageView.setScaleY(f16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(b this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            View view = this$0.contentView;
            if (view == null) {
                return;
            }
            view.setAlpha(floatValue);
        }

        private final void o(boolean isFirstShown) {
            Context context;
            Resources resources;
            URLImageView uRLImageView = this.mainImg;
            if (uRLImageView == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.faceAdShowAnimator = ofFloat;
            ofFloat.addListener(new C9832b());
            if (!isFirstShown) {
                ofFloat.setDuration(250L);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.operation.facead.m
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        h.b.q(h.b.this, valueAnimator);
                    }
                });
            } else {
                final int c16 = u.INSTANCE.c(uRLImageView.getContext());
                URLImageView uRLImageView2 = this.actionButtonImg;
                final int dimensionPixelSize = (uRLImageView2 == null || (context = uRLImageView2.getContext()) == null || (resources = context.getResources()) == null) ? 0 : resources.getDimensionPixelSize(R.dimen.f12116l);
                QLog.i("ZplanFaceAdNativeHandler", 1, "animationShown screenWidth:" + c16 + ", actionButtonWidth:" + dimensionPixelSize + "  -- " + uRLImageView.getContext());
                ofFloat.setDuration(430L);
                final OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
                final AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
                final DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.operation.facead.n
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        h.b.p(accelerateInterpolator, decelerateInterpolator, overshootInterpolator, this, c16, dimensionPixelSize, valueAnimator);
                    }
                });
            }
            ofFloat.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(AccelerateInterpolator scaleInterpolator, DecelerateInterpolator translateInterpolator, OvershootInterpolator overShootInterpolator, b this$0, int i3, int i16, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(scaleInterpolator, "$scaleInterpolator");
            Intrinsics.checkNotNullParameter(translateInterpolator, "$translateInterpolator");
            Intrinsics.checkNotNullParameter(overShootInterpolator, "$overShootInterpolator");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            float f16 = floatValue <= 0.7209302f ? floatValue / 0.7209302f : 1.0f;
            float f17 = floatValue <= 0.5f ? 0.0f : (floatValue - 0.5f) / 0.5f;
            float interpolation = scaleInterpolator.getInterpolation(f16);
            float interpolation2 = translateInterpolator.getInterpolation(f16);
            float interpolation3 = overShootInterpolator.getInterpolation(floatValue);
            URLImageView uRLImageView = this$0.mainImg;
            if (uRLImageView != null) {
                float f18 = 2.0f - interpolation;
                uRLImageView.setScaleX(f18);
                uRLImageView.setScaleY(f18);
                uRLImageView.setX(i3 * (1 - interpolation2));
                float f19 = 36;
                uRLImageView.setRotationY((f19 * interpolation3) - f19);
            }
            URLImageView uRLImageView2 = this$0.actionButtonImg;
            if (uRLImageView2 != null) {
                float f26 = 2.0f - interpolation;
                uRLImageView2.setScaleX(f26);
                uRLImageView2.setScaleY(f26);
                uRLImageView2.setX((i3 * (1 - interpolation2)) + (((i3 - i16) / 2) * interpolation2));
                float f27 = 36;
                uRLImageView2.setRotationY((interpolation3 * f27) - f27);
            }
            View view = this$0.bg;
            if (view != null) {
                view.setAlpha(interpolation2);
            }
            View view2 = this$0.closeView;
            if (view2 != null) {
                view2.setAlpha(f17);
            }
            CheckBox checkBox = this$0.noMoreShown;
            if (checkBox == null) {
                return;
            }
            checkBox.setAlpha(f17);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(b this$0, ValueAnimator valueAnimator) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            View view = this$0.contentView;
            if (view == null) {
                return;
            }
            view.setAlpha(floatValue);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t(long startTime) {
            h.this.k();
            ZootopiaFaceAdReport.f372190a.e(h.this.arguments, (int) (System.currentTimeMillis() - startTime), 0, "", true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u(long startTime, boolean isFirstShown) {
            h.this.l();
            o(isFirstShown);
            ZootopiaFaceAdReport.f372190a.e(h.this.arguments, (int) (System.currentTimeMillis() - startTime), 1, "", true);
            E();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(b this$0, View it) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.D(it, false);
            this$0.B(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(b this$0, h this$1, View clickedView) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            nw4.h hVar = this$0.faceAdInfo;
            QLog.i("ZplanFaceAdNativeHandler", 1, "faceAd clicked, launchScheme: " + (hVar != null ? hVar.f421488g : null));
            Intrinsics.checkNotNullExpressionValue(clickedView, "clickedView");
            this$0.D(clickedView, true);
            this$1.r(clickedView);
            this$0.B(true);
        }

        public final boolean A() {
            CheckBox checkBox = this.noMoreShown;
            if (checkBox != null) {
                return checkBox.isChecked();
            }
            return false;
        }

        public final void F(ValueAnimator valueAnimator) {
            this.faceAdHidenAnimator = valueAnimator;
        }

        public final void G(ValueAnimator valueAnimator) {
            this.faceAdShowAnimator = valueAnimator;
        }

        public final void H(nw4.h faceAdInfo, boolean isFirstShown) {
            URLDrawable uRLDrawable;
            URLDrawable uRLDrawable2;
            Intrinsics.checkNotNullParameter(faceAdInfo, "faceAdInfo");
            this.faceAdInfo = faceAdInfo;
            CheckBox checkBox = this.noMoreShown;
            if (checkBox != null) {
                checkBox.setVisibility(faceAdInfo.f421497p ? 8 : 0);
            }
            CheckBox checkBox2 = this.noMoreShown;
            if (checkBox2 != null) {
                checkBox2.setChecked(false);
            }
            C();
            ab4.b bVar = ab4.b.f25786a;
            ab4.b.k(bVar, bVar.e(), String.valueOf(faceAdInfo.f421482a), null, 4, null);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                URLImageView uRLImageView = this.mainImg;
                if (uRLImageView != null) {
                    String str = faceAdInfo.f421486e;
                    Intrinsics.checkNotNullExpressionValue(str, "faceAdInfo.firstEnterImg");
                    uRLDrawable2 = CommonExKt.t(uRLImageView, str, null, new d(currentTimeMillis, this, isFirstShown));
                } else {
                    uRLDrawable2 = null;
                }
                QLog.i("ZplanFaceAdNativeHandler", 1, "showFaceAd BEGIN -- loadMainImg " + (uRLDrawable2 != null ? Integer.valueOf(uRLDrawable2.getStatus()) : null) + " --" + uRLDrawable2);
            } catch (OutOfMemoryError e16) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "loadMainImg OutOfMemoryError", e16);
                t(currentTimeMillis);
            }
            URLImageView uRLImageView2 = this.actionButtonImg;
            if (uRLImageView2 != null) {
                String str2 = faceAdInfo.f421495n;
                Intrinsics.checkNotNullExpressionValue(str2, "faceAdInfo.btnIcon");
                uRLDrawable = CommonExKt.t(uRLImageView2, str2, null, new c());
            } else {
                uRLDrawable = null;
            }
            QLog.i("ZplanFaceAdNativeHandler", 1, "BEGIN -- loadButtonImg " + (uRLDrawable != null ? Integer.valueOf(uRLDrawable.getStatus()) : null) + " --" + uRLDrawable);
        }

        public final void m(Animator.AnimatorListener animationListener) {
            Intrinsics.checkNotNullParameter(animationListener, "animationListener");
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.faceAdHidenAnimator = ofFloat;
            ofFloat.addListener(animationListener);
            ofFloat.setDuration(150L);
            ofFloat.addListener(new a());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.sqshow.zootopia.operation.facead.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    h.b.n(h.b.this, valueAnimator);
                }
            });
            ofFloat.start();
        }

        public final void s() {
            URLImageView uRLImageView = this.mainImg;
            if (uRLImageView != null) {
                uRLImageView.setImageDrawable(null);
            }
            URLImageView uRLImageView2 = this.actionButtonImg;
            if (uRLImageView2 != null) {
                uRLImageView2.setImageDrawable(null);
            }
            Companion companion = h.INSTANCE;
            companion.b(this.infiniteScaleAnimator, "infiniteScaleAnimator");
            ValueAnimator valueAnimator = this.faceAdShowAnimator;
            if (valueAnimator != null) {
                this.faceAdShowAnimator = null;
                companion.b(valueAnimator, "faceAdShowAnimator");
            }
            ValueAnimator valueAnimator2 = this.faceAdHidenAnimator;
            if (valueAnimator2 != null) {
                this.faceAdHidenAnimator = null;
                companion.b(valueAnimator2, "faceAdHidenAnimator");
            }
        }

        /* renamed from: v, reason: from getter */
        public final View getContentView() {
            return this.contentView;
        }

        public final void w(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.contentView = view;
            this.bg = view.findViewById(R.id.ptm);
            this.mainImg = (URLImageView) view.findViewById(R.id.ptp);
            this.actionButtonImg = (URLImageView) view.findViewById(R.id.ptl);
            this.closeView = view.findViewById(R.id.ptn);
            this.noMoreShown = (CheckBox) view.findViewById(R.id.ptq);
            View view2 = this.closeView;
            if (view2 != null) {
                aa.d(view2, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.operation.facead.j
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        h.b.x(h.b.this, view3);
                    }
                });
            }
            View view3 = this.contentView;
            if (view3 != null) {
                aa.d(view3, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.operation.facead.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        h.b.y(view4);
                    }
                });
            }
            URLImageView uRLImageView = this.mainImg;
            if (uRLImageView != null) {
                final h hVar = h.this;
                aa.d(uRLImageView, new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.operation.facead.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        h.b.z(h.b.this, hVar, view4);
                    }
                });
            }
        }

        public final void r() {
            QLog.i("ZplanFaceAdNativeHandler", 1, "clearViewHolderCache");
            s();
            this.mainImg = null;
            this.actionButtonImg = null;
            this.infiniteScaleAnimator = null;
            this.noMoreShown = null;
            this.contentView = null;
            this.bg = null;
            this.closeView = null;
        }

        private final void E() {
            URLImageView uRLImageView = this.mainImg;
            if (uRLImageView != null) {
                this.dtViewReporter.g(uRLImageView, "em_zplan_jump_area", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
            View view = this.closeView;
            if (view != null) {
                this.dtViewReporter.g(view, "em_zplan_close", (r16 & 4) != 0 ? null : new LinkedHashMap(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/h$b$a", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements Animator.AnimatorListener {
            a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ValueAnimator valueAnimator = animation instanceof ValueAnimator ? (ValueAnimator) animation : null;
                if (valueAnimator != null) {
                    valueAnimator.removeAllUpdateListeners();
                }
                b.this.F(null);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/h$b$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.sqshow.zootopia.operation.facead.h$b$b, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9832b implements Animator.AnimatorListener {
            C9832b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ValueAnimator valueAnimator = animation instanceof ValueAnimator ? (ValueAnimator) animation : null;
                if (valueAnimator != null) {
                    valueAnimator.removeAllUpdateListeners();
                }
                b.this.G(null);
                b.this.k();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(View view) {
        }
    }

    private final void A() {
        w();
        if ((this.faceAdInfo != null ? r0.f421491j : 0) * 1000 <= 0 || !this.isShowing || this.autoHideStartTime <= 0) {
            return;
        }
        long currentTimeMillis = this.autoHidePreCountTime + (System.currentTimeMillis() - this.autoHideStartTime);
        this.autoHidePreCountTime = currentTimeMillis;
        QLog.i("ZplanFaceAdNativeHandler", 1, "trySaveAutoHideTime autoHidePreCountTime=" + currentTimeMillis);
        this.autoHideStartTime = 0L;
    }

    private final void B(boolean isMax) {
        ViewGroup viewGroup = this.parentContainer;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            int i3 = isMax ? -1 : 1;
            if (layoutParams.width == i3 && layoutParams.height == i3) {
                return;
            }
            layoutParams.width = i3;
            layoutParams.height = i3;
            QLog.i("ZplanFaceAdNativeHandler", 1, "update lp for parentContainer - " + isMax);
            viewGroup.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("ZplanFaceAdNativeHandler", 1, "autoHideRunnable run isShowing=" + this$0.isShowing);
        if (this$0.isShowing) {
            o(this$0, false, false, 2, null);
        }
    }

    private final b i(Context context) {
        View adView = LayoutInflater.from(context).inflate(R.layout.dby, (ViewGroup) null, false);
        b bVar = new b();
        Intrinsics.checkNotNullExpressionValue(adView, "adView");
        bVar.w(adView);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        QLog.e("ZplanFaceAdNativeHandler", 1, "finalShowError");
        B(false);
        o(this, true, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        QLog.i("ZplanFaceAdNativeHandler", 1, "finalShown");
        this.isShowing = true;
        B(true);
        a aVar = this.faceAdListener;
        if (aVar != null) {
            aVar.a(this);
        }
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final void n(boolean isError, boolean isClickJump) {
        Unit unit;
        a aVar;
        b bVar = this.viewHolder;
        ?? A = bVar != null ? bVar.A() : 0;
        QLog.e("ZplanFaceAdNativeHandler", 1, "handleDismissSelf - isError= " + isError + ", isClickJump= " + isClickJump + ", needClearViewCache= " + this.needClearViewCache + ", isNoMoreShown= " + ((boolean) A));
        b bVar2 = this.viewHolder;
        if (bVar2 != null) {
            bVar2.m(new c(isError, isClickJump));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e("ZplanFaceAdNativeHandler", 1, "ERROR! handleDismissSelf viewHolder is null");
            j(isError, isClickJump);
        }
        if (isError) {
            return;
        }
        if (A != 0 && (aVar = this.faceAdListener) != null) {
            String faceAdId = getFaceAdId();
            nw4.h hVar = this.faceAdInfo;
            aVar.d(faceAdId, hVar != null ? Long.valueOf(hVar.f421482a) : null);
        }
        ZootopiaFaceAdReport.f372190a.b(this.arguments, A, "");
    }

    private final void w() {
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.autoHideRunnable);
        }
    }

    private final void z() {
        long j3 = (this.faceAdInfo != null ? r0.f421491j : 0) * 1000;
        if (j3 <= 0 || !this.isShowing) {
            return;
        }
        if (!this.isPausing) {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            this.autoHideStartTime = System.currentTimeMillis();
            QLog.i("ZplanFaceAdNativeHandler", 1, "tryPostAutoHideRunnable showTime=" + j3 + ", autoHidePreCountTime=" + this.autoHidePreCountTime);
            Handler handler = this.handler;
            if (handler != null) {
                handler.postDelayed(this.autoHideRunnable, j3 - this.autoHidePreCountTime);
                return;
            }
            return;
        }
        QLog.e("ZplanFaceAdNativeHandler", 1, "tryPostAutoHideRunnable showTime=" + j3 + ", but isPausing");
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.b
    /* renamed from: U8, reason: from getter */
    public String getFaceAdId() {
        return this.faceAdId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String m() {
        nw4.h hVar = this.faceAdInfo;
        if (hVar != null) {
            return hVar.f421488g;
        }
        return null;
    }

    public final void p(boolean isFirstShown, nw4.h faceAdInfo, ViewGroup fragmentContainer, Bundle arguments, ZootopiaSource sourceCurrent, a faceAdListener) {
        View contentView;
        Intrinsics.checkNotNullParameter(faceAdInfo, "faceAdInfo");
        Intrinsics.checkNotNullParameter(fragmentContainer, "fragmentContainer");
        Intrinsics.checkNotNullParameter(faceAdListener, "faceAdListener");
        QLog.i("ZplanFaceAdNativeHandler", 1, "handleFaceAd, viewHolder= " + this.viewHolder);
        y(faceAdInfo);
        x(faceAdListener, fragmentContainer);
        this.arguments = arguments;
        this.sourceCurrent = sourceCurrent;
        if (this.viewHolder == null) {
            Context context = fragmentContainer.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "fragmentContainer.context");
            this.viewHolder = i(context);
        }
        b bVar = this.viewHolder;
        ViewParent parent = (bVar == null || (contentView = bVar.getContentView()) == null) ? null : contentView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        boolean z16 = false;
        if (viewGroup != null) {
            if (Intrinsics.areEqual(viewGroup, fragmentContainer)) {
                z16 = true;
            } else {
                b bVar2 = this.viewHolder;
                viewGroup.removeView(bVar2 != null ? bVar2.getContentView() : null);
            }
        }
        if (!z16) {
            try {
                b bVar3 = this.viewHolder;
                fragmentContainer.addView(bVar3 != null ? bVar3.getContentView() : null, new ViewGroup.LayoutParams(-1, -1));
            } catch (Throwable th5) {
                QLog.e("ZplanFaceAdNativeHandler", 1, "addView crash t:" + th5);
            }
        }
        b bVar4 = this.viewHolder;
        if (bVar4 != null) {
            bVar4.H(faceAdInfo, isFirstShown);
        }
    }

    public void r(View clickedView) {
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        QLog.i("ZplanFaceAdNativeHandler", 1, "onAction: " + this.faceAdInfo);
        String m3 = m();
        if (m3 != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = clickedView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "clickedView.context");
            iSchemeApi.launchScheme(context, m3);
        }
    }

    public final void s(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QLog.i("ZplanFaceAdNativeHandler", 1, "onConfigurationChanged - viewHolder= " + this.viewHolder);
        if (this.viewHolder != null) {
            this.needClearViewCache = true;
        }
    }

    public final void u() {
        QLog.i("ZplanFaceAdNativeHandler", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        this.isPausing = true;
        A();
    }

    public void x(a faceAdListener, ViewGroup parentContainer) {
        Intrinsics.checkNotNullParameter(faceAdListener, "faceAdListener");
        Intrinsics.checkNotNullParameter(parentContainer, "parentContainer");
        this.faceAdListener = faceAdListener;
        this.parentContainer = parentContainer;
    }

    public void y(nw4.h faceAdInfo) {
        Intrinsics.checkNotNullParameter(faceAdInfo, "faceAdInfo");
        this.faceAdInfo = faceAdInfo;
        String str = faceAdInfo.f421494m;
        Intrinsics.checkNotNullExpressionValue(str, "faceAdInfo.activityId");
        this.faceAdId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(boolean isError, boolean isClickJump) {
        QLog.i("ZplanFaceAdNativeHandler", 1, "finalRealDismissSelf");
        this.isShowing = false;
        b bVar = this.viewHolder;
        if (bVar != null) {
            bVar.s();
        }
        if (this.needClearViewCache) {
            b bVar2 = this.viewHolder;
            if (bVar2 != null) {
                bVar2.r();
            }
            this.viewHolder = null;
        }
        ViewGroup viewGroup = this.parentContainer;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        B(false);
        this.faceAdInfo = null;
        this.faceAdId = "";
        this.arguments = null;
        this.sourceCurrent = null;
        this.parentContainer = null;
        w();
        this.autoHidePreCountTime = 0L;
        this.autoHideStartTime = 0L;
        if (isError) {
            a aVar = this.faceAdListener;
            if (aVar != null) {
                aVar.b();
            }
        } else {
            a aVar2 = this.faceAdListener;
            if (aVar2 != null) {
                aVar2.c(isClickJump);
            }
        }
        if (this.isShowing) {
            return;
        }
        this.faceAdListener = null;
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.b
    public void M8() {
        QLog.i("ZplanFaceAdNativeHandler", 1, "dismissSelf");
        o(this, false, false, 2, null);
    }

    public final void q() {
        QLog.i("ZplanFaceAdNativeHandler", 1, "notifyAllHandled");
        this.handler = null;
        b bVar = this.viewHolder;
        if (bVar != null) {
            bVar.r();
        }
        this.viewHolder = null;
    }

    public final void t() {
        QLog.i("ZplanFaceAdNativeHandler", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        b bVar = this.viewHolder;
        if (bVar != null) {
            bVar.s();
        }
        w();
        this.faceAdListener = null;
        this.parentContainer = null;
    }

    public final void v() {
        QLog.i("ZplanFaceAdNativeHandler", 1, "onResume");
        this.isPausing = false;
        z();
    }

    static /* synthetic */ void o(h hVar, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z17 = false;
            }
            hVar.n(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleDismissSelf");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/h$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements Animator.AnimatorListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f372174e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f372175f;

        c(boolean z16, boolean z17) {
            this.f372174e = z16;
            this.f372175f = z17;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            h.this.j(this.f372174e, this.f372175f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
