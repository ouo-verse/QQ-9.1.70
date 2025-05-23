package com.tencent.kuikly.core.render.android.expand.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SizeF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.kuikly.core.render.android.expand.component.blur.l;
import com.tencent.kuikly.core.render.android.expand.module.j;
import com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import d01.HRImageLoadOption;
import d01.w;
import f01.b;
import i01.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0002\u0084\u0001B\u0013\u0012\b\u0010\u0081\u0001\u001a\u00030\u0080\u0001\u00a2\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001bH\u0002J\b\u0010#\u001a\u00020\u000fH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u0005H\u0002J\b\u0010.\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u001bH\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001bH\u0002J\u0010\u00105\u001a\u0002042\u0006\u00103\u001a\u00020\u001bH\u0002J*\u0010:\u001a\u00020\u000f2\u0006\u00106\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001bH\u0002J\u0012\u0010<\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001bH\u0002J\u0012\u0010=\u001a\u0004\u0018\u00010\u00032\u0006\u0010;\u001a\u00020\u001bH\u0002J\u001a\u0010>\u001a\u00020\u000f2\u0006\u0010/\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010?\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u001b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010@\u001a\u00020\u000fH\u0002J\b\u0010A\u001a\u00020\u000fH\u0002J\u0016\u0010D\u001a\u00020\u000f2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020\u000f0BH\u0002J\u0012\u0010E\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010F\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010G\u001a\u00020\u000f2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001bH\u0002J\b\u0010H\u001a\u00020\u000fH\u0002J_\u0010N\u001a\u00020\u000f2\u0006\u0010I\u001a\u0002042M\u0010M\u001aI\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u001107\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(9\u0012\u0004\u0012\u00020\u000f0JH\u0002J\u0018\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u001bH\u0016J\u0010\u0010T\u001a\u00020\u000f2\u0006\u0010S\u001a\u00020RH\u0016J\u0010\u0010W\u001a\u00020\u000f2\u0006\u0010V\u001a\u00020UH\u0015J\u0012\u0010X\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010Y\u001a\u00020\u000fH\u0016J1\u0010Z\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010/\u001a\u00020\u001b2\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u001bH\u0000\u00a2\u0006\u0004\bZ\u0010[R\u001e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u00103\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010)R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010\u0014R\u0018\u0010e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010`R\u0018\u0010h\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010`R;\u0010n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u000f\u0018\u00010jj\u0004\u0018\u0001`l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010mR;\u0010o\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u000f\u0018\u00010jj\u0004\u0018\u0001`l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010mR;\u0010p\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\bK\u0012\b\bL\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020\u000f\u0018\u00010jj\u0004\u0018\u0001`l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010mR\u0016\u0010q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010)R\u0018\u0010s\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010rR\u0018\u0010v\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010uR\u0016\u0010y\u001a\u00020w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010xR\u0016\u0010z\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010)R\u0018\u0010{\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010`R\u0018\u0010|\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010`R\u0014\u0010\u007f\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b}\u0010~\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;", "Landroid/widget/ImageView;", "Li01/c;", "", "propValue", "", "Y", "j0", "X", "O", "H", BdhLogUtil.LogTag.Tag_Req, "G", "Landroid/graphics/drawable/Drawable;", "drawable", "", "n0", "m0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", UserInfo.SEX_FEMALE, "N", "J", "I", "M", "L", "K", "", "resize", "g0", "", "blurRadius", "U", "maskGradient", "e0", "o0", "d0", "c0", "b0", "f0", "a0", "Z", "url", "i0", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "tempSrc", "B", "imageSrcKey", BdhLogUtil.LogTag.Tag_Conn, "src", "Ld01/a;", "p", "requestSrc", "", "errorCode", "errorMsg", "h0", "key", HippyTKDListViewAdapter.X, "y", "T", "V", "E", "W", "Lkotlin/Function0;", "task", ExifInterface.LATITUDE_SOUTH, "w", "v", "u", "l0", "imageLoadOption", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "callback", "t", "propKey", "b", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "setImageDrawable", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "D", "(Landroid/graphics/drawable/Drawable;Ljava/lang/String;ILjava/lang/String;)V", "d", "Lkotlin/jvm/functions/Function0;", "setSrcLazyTask", "e", "Ljava/lang/String;", "f", "isNinePatchDrawable", tl.h.F, "i", "maskLinearGradient", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Integer;", "tintColor", CustomAnimation.KeyPath.COLOR_FILTER, "Lkotlin/Function1;", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "Lkotlin/jvm/functions/Function1;", "loadSuccessCallback", "loadResolutionCallback", "loadFailureCallback", "needLoadFailure", "Landroid/graphics/drawable/Drawable;", "originDrawable", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paintMaskGradient", "Landroid/util/SizeF;", "Landroid/util/SizeF;", "maskLinearGradientSize", "needReCreatePaintMaskGradient", "httpHeaders", "customCacheKey", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class KRImageView extends ImageView implements i01.c {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String colorFilter;

    /* renamed from: D, reason: from kotlin metadata */
    private Function1<Object, Unit> loadSuccessCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private Function1<Object, Unit> loadResolutionCallback;

    /* renamed from: F, reason: from kotlin metadata */
    private Function1<Object, Unit> loadFailureCallback;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean needLoadFailure;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable originDrawable;

    /* renamed from: I, reason: from kotlin metadata */
    private Paint paintMaskGradient;

    /* renamed from: J, reason: from kotlin metadata */
    private SizeF maskLinearGradientSize;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean needReCreatePaintMaskGradient;

    /* renamed from: L, reason: from kotlin metadata */
    private String httpHeaders;

    /* renamed from: M, reason: from kotlin metadata */
    private String customCacheKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> setSrcLazyTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String src;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isNinePatchDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float blurRadius;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String maskLinearGradient;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Integer tintColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\bR\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0004\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView$a;", "", "", "BASE64_IMAGE_PREFIX", "Ljava/lang/String;", "BYTE_ARRAY_IMAGE_PREFIX", "", "ERROR_CODE_LOAD_BY_BYTE_ARRAY_ERROR", "I", "IMAGE_HEIGHT", "IMAGE_WIDTH", "PROP_BLUR_RADIUS", "PROP_COLOR_FILTER", "PROP_CUSTOM_CACHE_KEY", "PROP_DOT_NINE_IMAGE", "PROP_EVENT_LOAD_FAILURE", "PROP_EVENT_LOAD_RESOLUTION", "PROP_EVENT_LOAD_SUCCESS", "PROP_HTTP_HEADERS", "PROP_MASK_LINEAR_GRADIENT", "PROP_NEED_LOAD_FAILURE", "PROP_RESIZE", "PROP_SRC", "PROP_TINT_COLOR", "RESIZE_MODE_CONTAIN", "RESIZE_MODE_COVER", "RESIZE_MODE_STRETCH", "TYPE_NINE_DOT_DRAWABLE", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRImageView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.src = "";
        this.maskLinearGradientSize = new SizeF(0.0f, 0.0f);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private final boolean A() {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.src, "byte_array:", false, 2, null);
        return startsWith$default;
    }

    private final void B(final String tempSrc) {
        Object x16 = x(this.src);
        if (x16 instanceof Drawable) {
            setImageDrawable((Drawable) x16);
        } else {
            if (x16 == null) {
                return;
            }
            boolean z16 = x16 instanceof String;
            t(p((String) x16), new Function3<Drawable, Integer, String, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$loadBase64Image$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable, Integer num, String str) {
                    invoke(drawable, num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable final Drawable drawable, final int i3, @NotNull final String errorMsg) {
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    KRImageView.this.S(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$loadBase64Image$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                            KRImageView$loadBase64Image$1 kRImageView$loadBase64Image$1 = KRImageView$loadBase64Image$1.this;
                            KRImageView.this.h0(tempSrc, drawable, i3, errorMsg);
                            KRImageView$loadBase64Image$1 kRImageView$loadBase64Image$12 = KRImageView$loadBase64Image$1.this;
                            KRImageView.this.T(tempSrc, drawable);
                        }
                    });
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, android.graphics.drawable.Drawable] */
    private final void C(final String imageSrcKey) {
        final Object y16 = y(imageSrcKey);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        if (y16 instanceof byte[]) {
            KRSubThreadScheduler.f118174c.d(0L, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$loadByteArrayImage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    Object obj = y16;
                    final Bitmap decodeByteArray = BitmapFactory.decodeByteArray((byte[]) obj, 0, ((byte[]) obj).length);
                    KRImageView.this.S(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$loadByteArrayImage$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r1v0, types: [T, android.graphics.drawable.BitmapDrawable] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            objectRef.element = new BitmapDrawable(KRImageView.this.getResources(), decodeByteArray);
                            KRImageView$loadByteArrayImage$1 kRImageView$loadByteArrayImage$1 = KRImageView$loadByteArrayImage$1.this;
                            KRImageView.this.setImageDrawable((Drawable) objectRef.element);
                            KRImageView$loadByteArrayImage$1 kRImageView$loadByteArrayImage$12 = KRImageView$loadByteArrayImage$1.this;
                            KRImageView.this.V(imageSrcKey, (Drawable) objectRef.element);
                        }
                    });
                }
            });
        } else {
            if (y16 instanceof Drawable) {
                ?? r06 = (Drawable) y16;
                objectRef.element = r06;
                setImageDrawable(r06);
                return;
            }
            u(-20000, "load by byte array error");
        }
    }

    private final void E() {
        if (this.setSrcLazyTask != null && com.tencent.kuikly.core.render.android.css.ktx.b.h(this) > 0 && com.tencent.kuikly.core.render.android.css.ktx.b.g(this) > 0) {
            Function0<Unit> function0 = this.setSrcLazyTask;
            if (function0 != null) {
                function0.invoke();
            }
            this.setSrcLazyTask = null;
        }
    }

    private final boolean F() {
        this.blurRadius = 0.0f;
        return true;
    }

    private final boolean G() {
        this.colorFilter = null;
        return true;
    }

    private final boolean H() {
        this.customCacheKey = null;
        return true;
    }

    private final boolean I() {
        this.httpHeaders = null;
        return true;
    }

    private final boolean J() {
        this.isNinePatchDrawable = false;
        return true;
    }

    private final boolean K() {
        this.loadFailureCallback = null;
        return true;
    }

    private final boolean L() {
        this.loadResolutionCallback = null;
        return true;
    }

    private final boolean M() {
        this.loadSuccessCallback = null;
        return true;
    }

    private final boolean N() {
        this.maskLinearGradient = null;
        this.paintMaskGradient = null;
        return true;
    }

    private final boolean O() {
        this.needLoadFailure = false;
        return true;
    }

    private final boolean P() {
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        return true;
    }

    private final boolean Q() {
        this.src = "";
        l0();
        setImageDrawable(null);
        setClipBounds(null);
        return true;
    }

    private final boolean R() {
        this.tintColor = null;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.tencent.kuikly.core.render.android.expand.component.KRImageViewKt$sam$java_lang_Runnable$0] */
    public final void S(final Function0<Unit> task) {
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
        if (Intrinsics.areEqual(currentThread, mainLooper.getThread())) {
            task.invoke();
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        if (task != null) {
            task = new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageViewKt$sam$java_lang_Runnable$0
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Intrinsics.checkNotNullExpressionValue(Function0.this.invoke(), "invoke(...)");
                }
            };
        }
        handler.post((Runnable) task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(String tempSrc, Drawable drawable) {
        boolean z16;
        com.tencent.kuikly.core.render.android.a aVar;
        j jVar;
        if (tempSrc.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && drawable != null && (aVar = get_kuiklyRenderContext()) != null && (jVar = (j) aVar.a("KRMemoryCacheModule")) != null) {
            jVar.l(tempSrc, drawable);
        }
    }

    private final boolean U(float blurRadius) {
        this.blurRadius = blurRadius;
        n0(this.originDrawable);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(String imageSrcKey, Drawable drawable) {
        boolean z16;
        com.tencent.kuikly.core.render.android.a aVar;
        j jVar;
        if (imageSrcKey.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && drawable != null && (aVar = get_kuiklyRenderContext()) != null && (jVar = (j) aVar.a("KRMemoryCacheModule")) != null) {
            jVar.l(imageSrcKey, drawable);
        }
    }

    private final void W() {
        if (com.tencent.kuikly.core.render.android.css.ktx.b.h(this) > 0 && com.tencent.kuikly.core.render.android.css.ktx.b.g(this) > 0) {
            setClipBounds(new Rect(0, 0, com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(this)));
        }
    }

    private final boolean X(Object propValue) {
        if (!(propValue instanceof String)) {
            propValue = null;
        }
        this.colorFilter = (String) propValue;
        n0(this.originDrawable);
        return true;
    }

    private final boolean Y(Object propValue) {
        if (propValue != null) {
            this.customCacheKey = (String) propValue;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean Z(Object propValue) {
        if (propValue != null) {
            this.httpHeaders = (String) propValue;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean a0(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.isNinePatchDrawable = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean b0(Object propValue) {
        if (propValue != null) {
            this.loadFailureCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean c0(Object propValue) {
        if (propValue != null) {
            this.loadResolutionCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean d0(Object propValue) {
        if (propValue != null) {
            this.loadSuccessCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            w(getDrawable());
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean e0(String maskGradient) {
        this.maskLinearGradient = maskGradient;
        this.needReCreatePaintMaskGradient = true;
        invalidate();
        return true;
    }

    private final boolean f0(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.needLoadFailure = z16;
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean g0(String resize) {
        ImageView.ScaleType scaleType;
        int hashCode = resize.hashCode();
        if (hashCode != -1881872635) {
            if (hashCode != 94852023) {
                if (hashCode == 951526612 && resize.equals(HVideoConstants.ResizeType.RESIZE_CONTAIN)) {
                    scaleType = ImageView.ScaleType.FIT_CENTER;
                }
                scaleType = ImageView.ScaleType.CENTER_CROP;
            } else {
                if (resize.equals("cover")) {
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                scaleType = ImageView.ScaleType.CENTER_CROP;
            }
        } else {
            if (resize.equals("stretch")) {
                scaleType = ImageView.ScaleType.FIT_XY;
            }
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        setScaleType(scaleType);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h0(String requestSrc, Drawable drawable, int errorCode, String errorMsg) {
        if (!Intrinsics.areEqual(requestSrc, this.src)) {
            return;
        }
        if (drawable == null) {
            u(errorCode, errorMsg);
            return;
        }
        if (this.isNinePatchDrawable && (drawable instanceof BitmapDrawable)) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
            drawable = new h(resources, bitmap).a(1).b(1).c();
        }
        setImageDrawable(drawable);
    }

    private final boolean i0(String url) {
        if (Intrinsics.areEqual(this.src, url)) {
            return true;
        }
        this.src = url;
        setImageDrawable(null);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$setSrc$setSrcTask$1
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
                KRImageView.this.k0();
            }
        };
        if (com.tencent.kuikly.core.render.android.css.ktx.b.h(this) > 0 && com.tencent.kuikly.core.render.android.css.ktx.b.g(this) > 0) {
            function0.invoke();
        } else {
            this.setSrcLazyTask = function0;
        }
        return true;
    }

    private final boolean j0(Object propValue) {
        boolean z16;
        if (propValue != null) {
            String str = (String) propValue;
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.tintColor = Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.w(str));
            } else {
                this.tintColor = null;
            }
            n0(this.originDrawable);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        String str = this.src;
        if (z()) {
            B(str);
        } else if (A()) {
            C(str);
        } else {
            t(p(str), new a(this, str));
        }
    }

    private final void l0() {
        Object drawable = getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void m0(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
        w(drawable);
        v(drawable);
    }

    private final void n0(final Drawable drawable) {
        String str;
        List split$default;
        int collectionSizeOrDefault;
        float[] floatArray;
        if (drawable != null && this.tintColor != null) {
            final Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                final Integer num = this.tintColor;
                final String str2 = this.src;
                KRSubThreadScheduler.f118174c.d(0L, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$updateDrawableImage$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        final Drawable mutate = constantState.newDrawable().mutate();
                        Intrinsics.checkNotNullExpressionValue(mutate, "constantState.newDrawable().mutate()");
                        KRImageView.this.S(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$updateDrawableImage$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                String str3;
                                Integer num2;
                                Integer num3;
                                KRImageView$updateDrawableImage$1 kRImageView$updateDrawableImage$1 = KRImageView$updateDrawableImage$1.this;
                                String str4 = str2;
                                str3 = KRImageView.this.src;
                                if (Intrinsics.areEqual(str4, str3)) {
                                    KRImageView$updateDrawableImage$1 kRImageView$updateDrawableImage$12 = KRImageView$updateDrawableImage$1.this;
                                    Integer num4 = num;
                                    num2 = KRImageView.this.tintColor;
                                    if (Intrinsics.areEqual(num4, num2)) {
                                        Drawable drawable2 = mutate;
                                        num3 = KRImageView.this.tintColor;
                                        if (num3 != null) {
                                            drawable2.setTint(num3.intValue());
                                            KRImageView.this.m0(mutate);
                                            return;
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                                    }
                                }
                            }
                        });
                    }
                });
                return;
            }
            m0(drawable);
            return;
        }
        if (drawable != null && (str = this.colorFilter) != null) {
            Intrinsics.checkNotNull(str);
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"|"}, false, 0, 6, (Object) null);
            List list = split$default;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Float.valueOf(Float.parseFloat((String) it.next())));
            }
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList);
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.set(floatArray);
            drawable.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            m0(drawable);
            return;
        }
        if (drawable != null) {
            final float f16 = this.blurRadius;
            if (f16 > 0.0f) {
                final String str3 = this.src;
                KRSubThreadScheduler.f118174c.d(0L, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$updateDrawableImage$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        l.Companion companion = l.INSTANCE;
                        Drawable drawable2 = drawable;
                        Context context = KRImageView.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        final Drawable a16 = companion.a(drawable2, context, f16);
                        KRImageView.this.S(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$updateDrawableImage$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                String str4;
                                float f17;
                                drawable.setTintList(null);
                                str4 = KRImageView.this.src;
                                if (Intrinsics.areEqual(str4, str3)) {
                                    KRImageView$updateDrawableImage$2 kRImageView$updateDrawableImage$2 = KRImageView$updateDrawableImage$2.this;
                                    float f18 = f16;
                                    f17 = KRImageView.this.blurRadius;
                                    if (f18 == f17) {
                                        KRImageView.this.m0(a16);
                                    }
                                }
                            }
                        });
                    }
                });
                return;
            }
        }
        if (drawable != null) {
            drawable.setTintList(null);
        }
        m0(drawable);
    }

    private final void o0() {
        boolean z16;
        String str = this.maskLinearGradient;
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && this.originDrawable != null) {
                SizeF sizeF = new SizeF(com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(this));
                if (this.needReCreatePaintMaskGradient || (!Intrinsics.areEqual(sizeF, this.maskLinearGradientSize)) || this.paintMaskGradient == null) {
                    this.maskLinearGradientSize = sizeF;
                    Paint paint = new Paint(1);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                    b.Companion companion = f01.b.INSTANCE;
                    String str2 = this.maskLinearGradient;
                    if (str2 == null) {
                        str2 = "";
                    }
                    paint.setShader(companion.d(str2, this.maskLinearGradientSize, Shader.TileMode.CLAMP));
                    this.paintMaskGradient = paint;
                }
                this.needReCreatePaintMaskGradient = false;
                return;
            }
        }
        this.paintMaskGradient = null;
    }

    private final HRImageLoadOption p(String src) {
        LinkedHashMap linkedHashMap;
        boolean z16;
        String str = this.httpHeaders;
        if (str != null) {
            linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("headers", str);
            Unit unit = Unit.INSTANCE;
        } else {
            linkedHashMap = null;
        }
        String str2 = this.customCacheKey;
        if (str2 != null) {
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put("custom_cache_key", str2);
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        int h16 = com.tencent.kuikly.core.render.android.css.ktx.b.h(this);
        int g16 = com.tencent.kuikly.core.render.android.css.ktx.b.g(this);
        if (!this.isNinePatchDrawable && this.loadResolutionCallback == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageView.ScaleType scaleType = getScaleType();
        Intrinsics.checkNotNullExpressionValue(scaleType, "scaleType");
        return new HRImageLoadOption(src, h16, g16, z16, scaleType, linkedHashMap2);
    }

    private final void t(final HRImageLoadOption imageLoadOption, final Function3<? super Drawable, ? super Integer, ? super String, Unit> callback) {
        com.tencent.kuikly.core.render.android.d dVar;
        g01.a c16;
        com.tencent.kuikly.core.render.android.d O0;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null) {
            dVar = aVar.O0();
        } else {
            dVar = null;
        }
        if (dVar != null) {
            com.tencent.kuikly.core.render.android.a aVar2 = get_kuiklyRenderContext();
            if (aVar2 != null && (O0 = aVar2.O0()) != null) {
                O0.c(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$fetchDrawable$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        g01.a c17;
                        com.tencent.kuikly.core.render.android.a aVar3 = KRImageView.this.get_kuiklyRenderContext();
                        if (aVar3 == null || (c17 = aVar3.c()) == null) {
                            return;
                        }
                        c17.b(KRImageView.this.getContext(), imageLoadOption, callback);
                    }
                });
                return;
            }
            return;
        }
        com.tencent.kuikly.core.render.android.a aVar3 = get_kuiklyRenderContext();
        if (aVar3 != null && (c16 = aVar3.c()) != null) {
            c16.b(getContext(), imageLoadOption, callback);
        }
    }

    private final void u(int errorCode, String errorMsg) {
        Function1<Object, Unit> function1;
        Map mapOf;
        if (this.needLoadFailure && (function1 = this.loadFailureCallback) != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("src", this.src), TuplesKt.to("errorMsg", errorMsg), TuplesKt.to("errorCode", Integer.valueOf(errorCode)));
            function1.invoke(mapOf);
        }
    }

    private final void v(Drawable drawable) {
        Function1<Object, Unit> function1;
        Map mapOf;
        if (drawable != null && (function1 = this.loadResolutionCallback) != null) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            float f16 = resources.getDisplayMetrics().density;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("imageWidth", Float.valueOf(drawable.getIntrinsicWidth() * f16)), TuplesKt.to("imageHeight", Float.valueOf(drawable.getIntrinsicHeight() * f16)));
            function1.invoke(mapOf);
        }
    }

    private final void w(Drawable drawable) {
        Function1<Object, Unit> function1;
        Map mapOf;
        if (drawable != null && (function1 = this.loadSuccessCallback) != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("src", this.src));
            function1.invoke(mapOf);
        }
    }

    private final Object x(String key) {
        j jVar;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (jVar = (j) aVar.a("KRMemoryCacheModule")) != null) {
            return jVar.g(key);
        }
        return null;
    }

    private final Object y(String key) {
        j jVar;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (jVar = (j) aVar.a("KRMemoryCacheModule")) != null) {
            return jVar.g(key);
        }
        return null;
    }

    private final boolean z() {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.src, "data:image", false, 2, null);
        return startsWith$default;
    }

    public final void D(@Nullable final Drawable drawable, @NotNull final String tempSrc, final int errorCode, @NotNull final String errorMsg) {
        Intrinsics.checkNotNullParameter(tempSrc, "tempSrc");
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        S(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRImageView$onImageCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                KRImageView.this.h0(tempSrc, drawable, errorCode, errorMsg);
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0010. Please report as an issue. */
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    return b0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1428201511:
                if (propKey.equals("blurRadius")) {
                    return U(((Float) propValue).floatValue());
                }
                return c.a.p(this, propKey, propValue);
            case -1285866623:
                if (propKey.equals("maskLinearGradient")) {
                    return e0((String) propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -934437708:
                if (propKey.equals("resize")) {
                    return g0((String) propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -671884466:
                if (propKey.equals("needLoadFailure")) {
                    return f0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -545672654:
                if (propKey.equals("loadResolution")) {
                    return c0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 114148:
                if (propKey.equals("src")) {
                    return i0((String) propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 599691451:
                if (propKey.equals(CustomAnimation.KeyPath.COLOR_FILTER)) {
                    return X(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1041505806:
                if (propKey.equals("customCacheKey")) {
                    return Y(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1327599912:
                if (propKey.equals("tintColor")) {
                    return j0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1649792478:
                if (propKey.equals("httpHeaders")) {
                    return Z(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    return d0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1971928192:
                if (propKey.equals("dotNineImage")) {
                    return a0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.a(this, method, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.l(this, parent);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    /* renamed from: k */
    public boolean getReusable() {
        return true;
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.i(this, parent);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        l0();
    }

    @Override // android.widget.ImageView, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        int i3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        o0();
        if (this.paintMaskGradient != null) {
            i3 = canvas.saveLayer(0.0f, 0.0f, com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(this), null);
        } else {
            i3 = 0;
        }
        q(com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(this), canvas);
        try {
            super.onDraw(canvas);
        } catch (Throwable th5) {
            w.f392617a.b("KRImageView", "[KRImageView.onDraw]: " + th5);
        }
        r(com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(this), canvas);
        Paint paint = this.paintMaskGradient;
        if (paint != null) {
            canvas.drawRect(0.0f, 0.0f, com.tencent.kuikly.core.render.android.css.ktx.b.h(this), com.tencent.kuikly.core.render.android.css.ktx.b.g(this), paint);
            canvas.restoreToCount(i3);
        }
    }

    public void q(int i3, int i16, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        c.a.c(this, i3, i16, canvas);
    }

    public void r(int i3, int i16, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        c.a.d(this, i3, i16, canvas);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    @Override // i01.c
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        this.setSrcLazyTask = null;
        switch (propKey.hashCode()) {
            case -1599351356:
                if (propKey.equals("loadFailure")) {
                    return K();
                }
                return c.a.m(this, propKey);
            case -1428201511:
                if (propKey.equals("blurRadius")) {
                    return F();
                }
                return c.a.m(this, propKey);
            case -1285866623:
                if (propKey.equals("maskLinearGradient")) {
                    return N();
                }
                return c.a.m(this, propKey);
            case -934437708:
                if (propKey.equals("resize")) {
                    return P();
                }
                return c.a.m(this, propKey);
            case -671884466:
                if (propKey.equals("needLoadFailure")) {
                    return O();
                }
                return c.a.m(this, propKey);
            case -545672654:
                if (propKey.equals("loadResolution")) {
                    return L();
                }
                return c.a.m(this, propKey);
            case 114148:
                if (propKey.equals("src")) {
                    return Q();
                }
                return c.a.m(this, propKey);
            case 599691451:
                if (propKey.equals(CustomAnimation.KeyPath.COLOR_FILTER)) {
                    return G();
                }
                return c.a.m(this, propKey);
            case 1041505806:
                if (propKey.equals("customCacheKey")) {
                    return H();
                }
                return c.a.m(this, propKey);
            case 1327599912:
                if (propKey.equals("tintColor")) {
                    return R();
                }
                return c.a.m(this, propKey);
            case 1649792478:
                if (propKey.equals("httpHeaders")) {
                    return I();
                }
                return c.a.m(this, propKey);
            case 1915020349:
                if (propKey.equals("loadSuccess")) {
                    return M();
                }
                return c.a.m(this, propKey);
            case 1971928192:
                if (propKey.equals("dotNineImage")) {
                    return J();
                }
                return c.a.m(this, propKey);
            default:
                return c.a.m(this, propKey);
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable drawable) {
        this.originDrawable = drawable;
        n0(drawable);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // android.view.View
    public void setLayoutParams(@NotNull ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        super.setLayoutParams(params);
        E();
        W();
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String str, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.b(this, method, str, function1);
    }
}
