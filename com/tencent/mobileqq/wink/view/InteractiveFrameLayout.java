package com.tencent.mobileqq.wink.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.wink.view.MenuLayout;
import com.tencent.mobileqq.wink.view.p;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00b0\u00012\u00020\u0001:\u0007\u00b1\u0001\u00b2\u0001\u00b3\u00018B.\b\u0007\u0012\b\u0010\u00aa\u0001\u001a\u00030\u00a9\u0001\u0012\f\b\u0002\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u00ab\u0001\u0012\t\b\u0002\u0010\u00ad\u0001\u001a\u00020\"\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J(\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J(\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u0002H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u000e\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)J\u0016\u0010-\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0014J\u0006\u0010.\u001a\u00020\u0004J\u0010\u0010/\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0017J&\u00106\u001a\u00020\u00042\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`22\u0006\u00105\u001a\u000204J\b\u00107\u001a\u0004\u0018\u00010\u0007R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00109R\u0016\u0010E\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010DR\u0016\u0010G\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010DR\u0016\u0010H\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00109R\u0014\u0010J\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010\u000bR\u0014\u0010K\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010\u000bR\u0014\u0010L\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00109R\u0014\u0010N\u001a\u00020M8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\fR\u0014\u0010O\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u000bR\u0014\u0010Q\u001a\u00020M8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bP\u0010\fR\u0016\u0010R\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010DR\u0016\u0010S\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010DR\u0016\u0010U\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010DR\u0016\u0010V\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010DR\u0014\u0010W\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00109R\u0014\u0010X\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00109R\u0014\u0010Y\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00109R\u0014\u0010Z\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u00109R\u0016\u0010[\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\\\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0016\u0010]\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0016\u0010^\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u000bR\u0016\u0010`\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u00109R\u0016\u0010b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u00109R\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u00109R\u0016\u0010f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u00109R\u0016\u0010h\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u00109R\u0016\u0010j\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u00109R\u0016\u0010l\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u00109R\u0016\u0010n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u00109R\u0016\u0010p\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010DR\u0016\u0010r\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010DR\u0016\u0010t\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010\fR\u0016\u0010v\u001a\u00020M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010\fR\u0018\u0010y\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010|\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0016\u0010\u007f\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0085\u0001\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0084\u0001\u0010~R\u0016\u0010\u0087\u0001\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0086\u0001\u0010~R\u001a\u0010\u008b\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001a\u0010\u008d\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u008a\u0001R\u001a\u0010\u0091\u0001\u001a\u00030\u008e\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\"\u0010\u0096\u0001\u001a\r \u0093\u0001*\u0005\u0018\u00010\u0092\u00010\u0092\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\"\u0010\u0098\u0001\u001a\r \u0093\u0001*\u0005\u0018\u00010\u0092\u00010\u0092\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0097\u0001\u0010\u0095\u0001R\"\u0010\u009c\u0001\u001a\r \u0093\u0001*\u0005\u0018\u00010\u0099\u00010\u0099\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001a\u0010\u00a0\u0001\u001a\u00030\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0018\u0010\u00a4\u0001\u001a\u00030\u00a1\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0018\u0010\u00a8\u0001\u001a\u00030\u00a5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u00a7\u0001\u00a8\u0006\u00b4\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout;", "Landroid/widget/FrameLayout;", "", "scale", "", ExifInterface.LATITUDE_SOUTH, "y", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "model", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "U", "I", "J", "V", "a0", "X", "W", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/MotionEvent;", "event", "", BdhLogUtil.LogTag.Tag_Req, "N", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "O", "E", "x1", "y1", "x2", "y2", BdhLogUtil.LogTag.Tag_Conn, "D", "M", Element.ELEMENT_NAME_DISTANCE, "", "B", "Y", "T", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout$d;", "click", "setOnCenterViewClick", "Landroid/view/View;", "view", "K", "isEdit", "b0", "G", "onTouchEvent", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/view/MenuLayout$a;", "Lkotlin/collections/ArrayList;", "popupMenuItems", "Lcom/tencent/mobileqq/wink/view/MenuLayout$b;", "popupMenuClickListener", "setMenuItems", "H", "d", UserInfo.SEX_FEMALE, "dX", "e", "dY", "f", "startRawX", tl.h.F, "startRawY", "i", "initialAngle", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "lastActionWasScalingOrRotating", "isRotating", "isDragging", "iconWH", "linePadding", "gradientThreshold", "touchDistance", "borderStroke", "", "clickThreshold", "clickDistanceThreshold", "L", "longClickThreshold", "leftLineTouched", "topLineTouched", "P", "rightLineTouched", "bottomLineTouched", "leftLinePx", "topLinePx", "rightLineMarginRightPx", "bottomLineMarginBottomPx", "leftLineAlpha", "topLineAlpha", "rightLineAlpha", "bottomLineAlpha", "c0", "leftDistance", "d0", "topDistance", "e0", "rightDistance", "f0", "bottomDistance", "g0", "initialTouchX", "h0", "initialTouchY", "i0", "initialDistance", "j0", "maxScale", "k0", "hasShownJoinNumsView", "l0", "isEditModel", "m0", "lastClickTime", "n0", "lastStartClickTime", "o0", "Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout$d;", "onCenterViewClick", "p0", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "interactiveModel", "q0", "Landroid/view/View;", "centerView", "Lcom/tencent/mobileqq/wink/view/MenuLayout;", "r0", "Lcom/tencent/mobileqq/wink/view/MenuLayout;", "menuLayout", "s0", "borderView", "t0", "borderLineView", "Landroid/widget/ImageView;", "u0", "Landroid/widget/ImageView;", "leftTopView", "v0", "rightBottomView", "Landroid/widget/TextView;", "w0", "Landroid/widget/TextView;", "joinNumbersView", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "x0", "Landroid/graphics/Bitmap;", "bmpZoom", "y0", "bmpDelete", "Landroid/os/Handler;", "z0", "Landroid/os/Handler;", "longPressHandler", "Ljava/lang/Runnable;", "A0", "Ljava/lang/Runnable;", "longPressRunnable", "Lcom/tencent/mobileqq/wink/view/p;", "B0", "Lcom/tencent/mobileqq/wink/view/p;", "rotationGestureDetector", "Landroid/view/ScaleGestureDetector;", "C0", "Landroid/view/ScaleGestureDetector;", "scaleGestureDetector", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D0", "a", "b", "c", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class InteractiveFrameLayout extends FrameLayout {

    /* renamed from: A0, reason: from kotlin metadata */
    @NotNull
    private Runnable longPressRunnable;

    /* renamed from: B0, reason: from kotlin metadata */
    @NotNull
    private final p rotationGestureDetector;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isRotating;

    /* renamed from: C0, reason: from kotlin metadata */
    @NotNull
    private final ScaleGestureDetector scaleGestureDetector;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isDragging;

    /* renamed from: E, reason: from kotlin metadata */
    private int iconWH;

    /* renamed from: F, reason: from kotlin metadata */
    private float linePadding;

    /* renamed from: G, reason: from kotlin metadata */
    private final int gradientThreshold;

    /* renamed from: H, reason: from kotlin metadata */
    private final int touchDistance;

    /* renamed from: I, reason: from kotlin metadata */
    private final float borderStroke;

    /* renamed from: J, reason: from kotlin metadata */
    private final long clickThreshold;

    /* renamed from: K, reason: from kotlin metadata */
    private final int clickDistanceThreshold;

    /* renamed from: L, reason: from kotlin metadata */
    private final long longClickThreshold;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean leftLineTouched;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean topLineTouched;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean rightLineTouched;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean bottomLineTouched;

    /* renamed from: R, reason: from kotlin metadata */
    private final float leftLinePx;

    /* renamed from: S, reason: from kotlin metadata */
    private final float topLinePx;

    /* renamed from: T, reason: from kotlin metadata */
    private final float rightLineMarginRightPx;

    /* renamed from: U, reason: from kotlin metadata */
    private final float bottomLineMarginBottomPx;

    /* renamed from: V, reason: from kotlin metadata */
    private int leftLineAlpha;

    /* renamed from: W, reason: from kotlin metadata */
    private int topLineAlpha;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int rightLineAlpha;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int bottomLineAlpha;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private float leftDistance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float dX;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private float topDistance;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float dY;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private float rightDistance;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float startRawX;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private float bottomDistance;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private float initialTouchX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float startRawY;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private float initialTouchY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float initialAngle;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private float initialDistance;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private float maxScale;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean hasShownJoinNumsView;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean isEditModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean lastActionWasScalingOrRotating;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private long lastStartClickTime;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d onCenterViewClick;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InteractiveModel interactiveModel;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private View centerView;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MenuLayout menuLayout;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View borderView;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View borderLineView;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView leftTopView;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView rightBottomView;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private TextView joinNumbersView;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private final Bitmap bmpZoom;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private final Bitmap bmpDelete;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private final Handler longPressHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout$a;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "paint", "<init>", "(Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout;)V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private final class a extends Drawable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Paint paint;

        public a() {
            Paint paint = new Paint();
            paint.setColor(InteractiveFrameLayout.this.getContext().getColor(R.color.cke));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(2.0f);
            this.paint = paint;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            RectF rectF = new RectF(getBounds());
            rectF.inset(InteractiveFrameLayout.this.linePadding, InteractiveFrameLayout.this.linePadding);
            canvas.drawRect(rectF, this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.paint.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout$b;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "paint", "<init>", "(Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout;)V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    private final class b extends Drawable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Paint paint;

        public b() {
            Paint paint = new Paint();
            paint.setColor(InteractiveFrameLayout.this.getContext().getColor(R.color.cke));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(InteractiveFrameLayout.this.borderStroke);
            this.paint = paint;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NotNull Canvas canvas) {
            int i3;
            int i16;
            int i17;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            int parseColor = Color.parseColor("#0099ff");
            if (InteractiveFrameLayout.this.leftLineAlpha > 0) {
                if (InteractiveFrameLayout.this.leftLineTouched) {
                    i17 = parseColor;
                } else {
                    i17 = -1;
                }
                this.paint.setColor(Color.argb(InteractiveFrameLayout.this.leftLineAlpha, Color.red(i17), Color.green(i17), Color.blue(i17)));
                canvas.drawLine(InteractiveFrameLayout.this.leftLinePx, 0.0f, InteractiveFrameLayout.this.leftLinePx, InteractiveFrameLayout.this.getHeight(), this.paint);
            }
            if (InteractiveFrameLayout.this.topLineAlpha > 0) {
                if (InteractiveFrameLayout.this.topLineTouched) {
                    i16 = parseColor;
                } else {
                    i16 = -1;
                }
                this.paint.setColor(Color.argb(InteractiveFrameLayout.this.topLineAlpha, Color.red(i16), Color.green(i16), Color.blue(i16)));
                canvas.drawLine(0.0f, InteractiveFrameLayout.this.topLinePx, InteractiveFrameLayout.this.getWidth(), InteractiveFrameLayout.this.topLinePx, this.paint);
            }
            if (InteractiveFrameLayout.this.rightLineAlpha > 0) {
                if (InteractiveFrameLayout.this.rightLineTouched) {
                    i3 = parseColor;
                } else {
                    i3 = -1;
                }
                this.paint.setColor(Color.argb(InteractiveFrameLayout.this.rightLineAlpha, Color.red(i3), Color.green(i3), Color.blue(i3)));
                float width = InteractiveFrameLayout.this.getWidth() - InteractiveFrameLayout.this.rightLineMarginRightPx;
                canvas.drawLine(width, 0.0f, width, InteractiveFrameLayout.this.getHeight(), this.paint);
            }
            if (InteractiveFrameLayout.this.bottomLineAlpha > 0) {
                if (!InteractiveFrameLayout.this.bottomLineTouched) {
                    parseColor = -1;
                }
                this.paint.setColor(Color.argb(InteractiveFrameLayout.this.bottomLineAlpha, Color.red(parseColor), Color.green(parseColor), Color.blue(parseColor)));
                float height = InteractiveFrameLayout.this.getHeight() - InteractiveFrameLayout.this.bottomLineMarginBottomPx;
                canvas.drawLine(0.0f, height, InteractiveFrameLayout.this.getWidth(), height, this.paint);
            }
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.paint.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/view/InteractiveFrameLayout$e", "Lcom/tencent/mobileqq/wink/view/p$a;", "", "rotationDegreesDelta", "", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements p.a {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.view.p.a
        public void a(float rotationDegreesDelta) {
            View view = InteractiveFrameLayout.this.centerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view = null;
            }
            view.setRotation(view.getRotation() + rotationDegreesDelta);
            InteractiveFrameLayout.this.V();
            InteractiveFrameLayout.this.E();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/view/InteractiveFrameLayout$f", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "Landroid/view/ScaleGestureDetector;", "detector", "", "onScale", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        f() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@NotNull ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            InteractiveFrameLayout.this.S(detector.getScaleFactor());
            InteractiveFrameLayout.this.V();
            InteractiveFrameLayout.this.E();
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveFrameLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(InteractiveModel model) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_challenge_topic", Float.valueOf(model.getXAxisPercentage()));
        VideoReport.setElementId(this.leftTopView, WinkDaTongReportConstant.ElementId.EM_XSJ_TOPIC_CHALLENGE_DELECT);
        VideoReport.setElementParams(this.leftTopView, params);
        VideoReport.setElementClickPolicy(this.leftTopView, ClickPolicy.REPORT_ALL);
    }

    private final int B(float distance) {
        int i3 = this.gradientThreshold;
        if (distance <= i3) {
            return Math.min(255, (int) ((1.0f - (distance / i3)) * 255));
        }
        return 0;
    }

    private final float C(float x16, float y16, float x26, float y26) {
        float degrees = (float) Math.toDegrees(Math.atan2(y26 - y16, x26 - x16));
        if (degrees < 0.0f) {
            return degrees + 360;
        }
        return degrees;
    }

    private final float D(float x16, float y16, float x26, float y26) {
        float f16 = x26 - x16;
        float f17 = y26 - y16;
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        View view = this.centerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        float x16 = view.getX();
        View view3 = this.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view3 = null;
        }
        float y16 = view3.getY();
        View view4 = this.centerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view2 = view4;
        }
        ViewPropertyAnimator animate = view2.animate();
        float f16 = this.leftDistance;
        if (f16 < 0.0f) {
            animate.x(x16 - f16);
        } else {
            float f17 = this.rightDistance;
            if (f17 < 0.0f) {
                animate.x(x16 + f17);
            } else {
                animate.x(x16 + 0.0f);
            }
        }
        float f18 = this.topDistance;
        if (f18 < 0.0f) {
            animate.y(y16 - f18);
        } else {
            float f19 = this.bottomDistance;
            if (f19 < 0.0f) {
                animate.y(y16 + f19);
            } else {
                animate.y(y16 + 0.0f);
            }
        }
        animate.setDuration(100L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.wink.view.h
            @Override // java.lang.Runnable
            public final void run() {
                InteractiveFrameLayout.F(InteractiveFrameLayout.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(InteractiveFrameLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V();
        this$0.leftDistance = 0.0f;
        this$0.rightDistance = 0.0f;
        this$0.topDistance = 0.0f;
        this$0.bottomDistance = 0.0f;
    }

    private final void I() {
        this.borderView.setVisibility(8);
        this.leftTopView.setVisibility(8);
        this.rightBottomView.setVisibility(8);
        this.menuLayout.setVisibility(8);
    }

    private final void J() {
        this.menuLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(InteractiveFrameLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.onCenterViewClick;
        if (dVar != null) {
            dVar.c(this$0.interactiveModel);
        }
        this$0.G();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean M(MotionEvent event) {
        View view = null;
        if (!this.isDragging) {
            Rect rect = new Rect();
            View view2 = this.centerView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view2 = null;
            }
            view2.getHitRect(rect);
            if (!rect.contains((int) event.getX(), (int) event.getY())) {
                return false;
            }
        }
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2 || !this.isDragging) {
                    return false;
                }
                float rawX = event.getRawX() + this.dX;
                float rawY = event.getRawY() + this.dY;
                View view3 = this.centerView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                } else {
                    view = view3;
                }
                view.animate().x(rawX).y(rawY).setDuration(0L).start();
                V();
                I();
                this.borderLineView.setVisibility(0);
            } else {
                this.isDragging = false;
                float abs = Math.abs(event.getRawX() - this.startRawX);
                float abs2 = Math.abs(event.getRawY() - this.startRawY);
                int i3 = this.touchDistance;
                if (abs < i3 && abs2 < i3) {
                    U();
                    d dVar = this.onCenterViewClick;
                    if (dVar != null) {
                        dVar.b(this.interactiveModel);
                    }
                }
                this.borderLineView.setVisibility(8);
                E();
            }
        } else {
            this.startRawX = event.getRawX();
            this.startRawY = event.getRawY();
            View view4 = this.centerView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view4 = null;
            }
            this.dX = view4.getX() - event.getRawX();
            View view5 = this.centerView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
            } else {
                view = view5;
            }
            this.dY = view.getY() - event.getRawY();
            this.isDragging = true;
        }
        return true;
    }

    private final boolean N(MotionEvent event) {
        Matrix matrix = new Matrix();
        View view = this.centerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        view.getMatrix().invert(matrix);
        float[] fArr = {event.getX(), event.getY()};
        matrix.mapPoints(fArr);
        View view3 = this.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view3 = null;
        }
        float width = view3.getWidth();
        View view4 = this.centerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view4 = null;
        }
        RectF rectF = new RectF(0.0f, 0.0f, width, view4.getHeight());
        if (rectF.contains(fArr[0], fArr[1])) {
            return true;
        }
        float x16 = event.getX();
        float y16 = event.getY();
        float rawX = event.getRawX();
        float rawY = event.getRawY();
        float f16 = fArr[0];
        float f17 = fArr[1];
        View view5 = this.centerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view5 = null;
        }
        float x17 = view5.getX();
        View view6 = this.centerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view2 = view6;
        }
        QLog.d("InteractiveFrameLayout", 2, "onTouchEventForView... !rect.contains rect:" + rectF + " event:(" + x16 + "," + y16 + ") (" + rawX + "," + rawY + ") touchPoint:(" + f16 + "," + f17 + ") centerView:(" + x17 + "," + view2.getY() + ")");
        return false;
    }

    private final boolean O(MotionEvent event) {
        if (!this.isRotating) {
            Rect rect = new Rect();
            this.rightBottomView.getHitRect(rect);
            if (!rect.contains((int) event.getX(), (int) event.getY())) {
                return false;
            }
        }
        int action = event.getAction();
        View view = null;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    if (!this.isRotating) {
                        return false;
                    }
                    View view2 = this.centerView;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("centerView");
                        view2 = null;
                    }
                    float x16 = view2.getX();
                    View view3 = this.centerView;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("centerView");
                        view3 = null;
                    }
                    float D = D(x16, view3.getY(), event.getX(), event.getY());
                    S(D / this.initialDistance);
                    View view4 = this.centerView;
                    if (view4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("centerView");
                        view4 = null;
                    }
                    float x17 = view4.getX();
                    View view5 = this.centerView;
                    if (view5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("centerView");
                        view5 = null;
                    }
                    float C = C(x17, view5.getY(), event.getX(), event.getY());
                    float f16 = C - this.initialAngle;
                    View view6 = this.centerView;
                    if (view6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    } else {
                        view = view6;
                    }
                    view.setRotation(view.getRotation() + f16);
                    V();
                    this.initialAngle = C;
                    this.initialDistance = D;
                    this.borderLineView.setVisibility(0);
                }
            }
            this.isRotating = false;
            this.borderLineView.setVisibility(8);
            E();
        } else {
            this.initialTouchX = event.getX();
            this.initialTouchY = event.getY();
            View view7 = this.centerView;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view7 = null;
            }
            float x18 = view7.getX();
            View view8 = this.centerView;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view8 = null;
            }
            this.initialDistance = D(x18, view8.getY(), event.getX(), event.getY());
            View view9 = this.centerView;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view9 = null;
            }
            float x19 = view9.getX();
            View view10 = this.centerView;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
            } else {
                view = view10;
            }
            this.initialAngle = C(x19, view.getY(), event.getX(), event.getY());
            this.isRotating = true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(InteractiveFrameLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        d dVar = this$0.onCenterViewClick;
        if (dVar != null) {
            dVar.d(this$0.interactiveModel);
        }
        this$0.lastClickTime = System.currentTimeMillis();
    }

    private final boolean Q(MotionEvent event) {
        this.scaleGestureDetector.onTouchEvent(event);
        this.rotationGestureDetector.c(event);
        if (!this.scaleGestureDetector.isInProgress() && !this.rotationGestureDetector.getIsInProgress()) {
            if (this.lastActionWasScalingOrRotating) {
                if (event.getAction() == 1 || event.getAction() == 3) {
                    this.lastActionWasScalingOrRotating = false;
                    this.borderLineView.setVisibility(8);
                    Log.d("InteractiveFrameLayout", "onTouchEvent: lastActionWasScalingOrRotating");
                }
                return true;
            }
            boolean M = M(event);
            boolean O = O(event);
            if (!M && !O) {
                I();
            } else if (O) {
                J();
            }
            if (!M && !O) {
                return false;
            }
            return true;
        }
        Log.d("InteractiveFrameLayout", "scaleHandled:" + this.scaleGestureDetector.isInProgress() + " rotateHandled:" + this.rotationGestureDetector.getIsInProgress());
        this.lastActionWasScalingOrRotating = true;
        this.borderLineView.setVisibility(0);
        J();
        return true;
    }

    private final boolean R(MotionEvent event) {
        d dVar;
        if (!N(event)) {
            return false;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    this.longPressHandler.removeCallbacks(this.longPressRunnable);
                    return false;
                }
                float abs = Math.abs(event.getRawX() - this.startRawX);
                float abs2 = Math.abs(event.getRawY() - this.startRawY);
                int i3 = this.clickDistanceThreshold;
                if (abs >= i3 || abs2 >= i3) {
                    this.longPressHandler.removeCallbacks(this.longPressRunnable);
                    d dVar2 = this.onCenterViewClick;
                    if (dVar2 != null) {
                        dVar2.a();
                    }
                }
            } else {
                this.longPressHandler.removeCallbacks(this.longPressRunnable);
                long currentTimeMillis = System.currentTimeMillis();
                float abs3 = Math.abs(event.getRawX() - this.startRawX);
                float abs4 = Math.abs(event.getRawY() - this.startRawY);
                int i16 = this.clickDistanceThreshold;
                if (abs3 < i16 && abs4 < i16 && currentTimeMillis - this.lastClickTime > this.clickThreshold) {
                    if (currentTimeMillis - this.lastStartClickTime <= this.longClickThreshold && (dVar = this.onCenterViewClick) != null) {
                        dVar.b(this.interactiveModel);
                    }
                    this.lastClickTime = System.currentTimeMillis();
                }
            }
        } else {
            this.startRawX = event.getRawX();
            this.startRawY = event.getRawY();
            View view = this.centerView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view = null;
            }
            this.dX = view.getX() - event.getRawX();
            View view3 = this.centerView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
            } else {
                view2 = view3;
            }
            this.dY = view2.getY() - event.getRawY();
            this.lastStartClickTime = System.currentTimeMillis();
            this.longPressHandler.postDelayed(this.longPressRunnable, this.longClickThreshold);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(float scale) {
        View view = this.centerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        view.setScaleX(view.getScaleX() * scale);
        View view3 = this.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view3 = null;
        }
        View view4 = this.centerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view4 = null;
        }
        float scaleX = view4.getScaleX();
        float f16 = this.maxScale;
        if (scaleX <= f16) {
            View view5 = this.centerView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view5 = null;
            }
            if (view5.getScaleX() < 0.5d) {
                f16 = 0.5f;
            } else {
                View view6 = this.centerView;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view6 = null;
                }
                f16 = view6.getScaleX();
            }
        }
        view3.setScaleX(f16);
        View view7 = this.centerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view7 = null;
        }
        View view8 = this.centerView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view2 = view8;
        }
        view7.setScaleY(view2.getScaleX());
    }

    private final void T() {
        long j3;
        String valueOf;
        InteractiveModel interactiveModel = this.interactiveModel;
        if (interactiveModel != null) {
            j3 = interactiveModel.getJoinNums();
        } else {
            j3 = 0;
        }
        if (j3 >= 10000) {
            double d16 = j3 / 10000.0d;
            if (d16 > 9999.0d) {
                valueOf = "9999\u4e07";
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                valueOf = String.format("%.1f\u4e07", Arrays.copyOf(new Object[]{Double.valueOf(d16)}, 1));
                Intrinsics.checkNotNullExpressionValue(valueOf, "format(format, *args)");
            }
        } else {
            valueOf = String.valueOf(j3);
        }
        TextView textView = this.joinNumbersView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
            textView = null;
        }
        textView.setText("\u5f53\u524d\u5df2\u6709" + valueOf + "\u4eba\u53c2\u4e0e");
    }

    private final void U() {
        View view = this.centerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        view.setVisibility(0);
        this.borderView.setVisibility(0);
        this.leftTopView.setVisibility(0);
        this.rightBottomView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V() {
        View view = this.borderView;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        View view2 = this.centerView;
        View view3 = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view2 = null;
        }
        layoutParams.width = view2.getWidth() + 100 + this.iconWH;
        View view4 = this.centerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view4 = null;
        }
        layoutParams.height = view4.getHeight() + 100 + this.iconWH;
        view.setLayoutParams(layoutParams);
        View view5 = this.borderView;
        View view6 = this.centerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view6 = null;
        }
        float f16 = 50;
        view5.setX((view6.getX() - f16) - (this.iconWH / 2));
        View view7 = this.borderView;
        View view8 = this.centerView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view8 = null;
        }
        view7.setY((view8.getY() - f16) - (this.iconWH / 2));
        View view9 = this.borderView;
        View view10 = this.centerView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view10 = null;
        }
        view9.setRotation(view10.getRotation());
        View view11 = this.borderView;
        View view12 = this.centerView;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view12 = null;
        }
        view11.setScaleX(view12.getScaleX());
        View view13 = this.borderView;
        View view14 = this.centerView;
        if (view14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view3 = view14;
        }
        view13.setScaleY(view3.getScaleY());
        if (this.isEditModel) {
            W();
            X();
            a0();
            Y();
        }
    }

    private final void W() {
        boolean z16;
        boolean z17;
        boolean z18;
        View view = this.centerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        float x16 = view.getX();
        View view3 = this.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view3 = null;
        }
        float y16 = view3.getY();
        View view4 = this.centerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view4 = null;
        }
        float x17 = view4.getX();
        View view5 = this.centerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view5 = null;
        }
        float width = x17 + view5.getWidth();
        View view6 = this.centerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view6 = null;
        }
        float y17 = view6.getY();
        View view7 = this.centerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view7 = null;
        }
        RectF rectF = new RectF(x16, y16, width, y17 + view7.getHeight());
        Matrix matrix = new Matrix();
        View view8 = this.centerView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view8 = null;
        }
        float rotation = view8.getRotation();
        View view9 = this.centerView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view9 = null;
        }
        float x18 = view9.getX();
        View view10 = this.centerView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view10 = null;
        }
        float width2 = x18 + (view10.getWidth() / 2);
        View view11 = this.centerView;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view11 = null;
        }
        float y18 = view11.getY();
        View view12 = this.centerView;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view12 = null;
        }
        matrix.setRotate(rotation, width2, y18 + (view12.getHeight() / 2));
        View view13 = this.centerView;
        if (view13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view13 = null;
        }
        float scaleX = view13.getScaleX();
        View view14 = this.centerView;
        if (view14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view14 = null;
        }
        float scaleY = view14.getScaleY();
        View view15 = this.centerView;
        if (view15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view15 = null;
        }
        float x19 = view15.getX();
        View view16 = this.centerView;
        if (view16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view16 = null;
        }
        float width3 = x19 + (view16.getWidth() / 2);
        View view17 = this.centerView;
        if (view17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view17 = null;
        }
        float y19 = view17.getY();
        View view18 = this.centerView;
        if (view18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view2 = view18;
        }
        matrix.postScale(scaleX, scaleY, width3, y19 + (view2.getHeight() / 2));
        matrix.mapRect(rectF);
        float f16 = rectF.left;
        float f17 = this.leftLinePx;
        float f18 = f16 - f17;
        boolean z19 = true;
        if (f16 <= f17) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.leftLineTouched = z16;
        this.leftDistance = f18;
        float f19 = rectF.top;
        float f26 = this.topLinePx;
        float f27 = f19 - f26;
        if (f19 <= f26) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.topLineTouched = z17;
        this.topDistance = f27;
        float width4 = getWidth() - this.rightLineMarginRightPx;
        float f28 = rectF.right;
        float f29 = width4 - f28;
        if (f28 >= getWidth() - this.rightLineMarginRightPx) {
            z18 = true;
        } else {
            z18 = false;
        }
        this.rightLineTouched = z18;
        this.rightDistance = f29;
        float height = getHeight() - this.bottomLineMarginBottomPx;
        float f36 = rectF.bottom;
        float f37 = height - f36;
        if (f36 < getHeight() - this.bottomLineMarginBottomPx) {
            z19 = false;
        }
        this.bottomLineTouched = z19;
        this.bottomDistance = f37;
        this.leftLineAlpha = B(this.leftDistance);
        this.topLineAlpha = B(this.topDistance);
        this.rightLineAlpha = B(this.rightDistance);
        this.bottomLineAlpha = B(this.bottomDistance);
        this.borderLineView.invalidate();
    }

    private final void X() {
        float f16 = this.linePadding;
        Matrix matrix = new Matrix();
        View view = this.centerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        float rotation = view.getRotation();
        View view3 = this.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view3 = null;
        }
        float x16 = view3.getX();
        View view4 = this.centerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view4 = null;
        }
        float width = x16 + (view4.getWidth() / 2);
        View view5 = this.centerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view5 = null;
        }
        float y16 = view5.getY();
        View view6 = this.centerView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view6 = null;
        }
        matrix.setRotate(rotation, width, y16 + (view6.getHeight() / 2));
        View view7 = this.centerView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view7 = null;
        }
        float scaleX = view7.getScaleX();
        View view8 = this.centerView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view8 = null;
        }
        float scaleY = view8.getScaleY();
        View view9 = this.centerView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view9 = null;
        }
        float x17 = view9.getX();
        View view10 = this.centerView;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view10 = null;
        }
        float width2 = x17 + (view10.getWidth() / 2);
        View view11 = this.centerView;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view11 = null;
        }
        float y17 = view11.getY();
        View view12 = this.centerView;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view2 = view12;
        }
        matrix.postScale(scaleX, scaleY, width2, y17 + (view2.getHeight() / 2));
        ImageView imageView = this.leftTopView;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int i3 = this.iconWH;
        layoutParams.width = i3;
        layoutParams.height = i3;
        imageView.setLayoutParams(layoutParams);
        float[] fArr = {this.borderView.getX() + f16, this.borderView.getY() + f16};
        matrix.mapPoints(fArr);
        this.leftTopView.setX(fArr[0] - (this.iconWH / 2));
        this.leftTopView.setY(fArr[1] - (this.iconWH / 2));
        ImageView imageView2 = this.rightBottomView;
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        int i16 = this.iconWH;
        layoutParams2.width = i16;
        layoutParams2.height = i16;
        imageView2.setLayoutParams(layoutParams2);
        float[] fArr2 = {(this.borderView.getX() + this.borderView.getLayoutParams().width) - f16, (this.borderView.getY() + this.borderView.getLayoutParams().height) - f16};
        matrix.mapPoints(fArr2);
        this.rightBottomView.setX(fArr2[0] - (this.iconWH / 2));
        this.rightBottomView.setY(fArr2[1] - (this.iconWH / 2));
    }

    private final void Y() {
        boolean z16;
        if (!this.hasShownJoinNumsView) {
            InteractiveModel interactiveModel = this.interactiveModel;
            if (interactiveModel != null && interactiveModel.getJoinNums() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                T();
                Matrix matrix = new Matrix();
                View view = this.centerView;
                View view2 = null;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view = null;
                }
                float rotation = view.getRotation();
                View view3 = this.centerView;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view3 = null;
                }
                float x16 = view3.getX();
                View view4 = this.centerView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view4 = null;
                }
                float width = x16 + (view4.getWidth() / 2);
                View view5 = this.centerView;
                if (view5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view5 = null;
                }
                float y16 = view5.getY();
                View view6 = this.centerView;
                if (view6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view6 = null;
                }
                matrix.setRotate(rotation, width, y16 + (view6.getHeight() / 2));
                View view7 = this.centerView;
                if (view7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view7 = null;
                }
                float scaleX = view7.getScaleX();
                View view8 = this.centerView;
                if (view8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view8 = null;
                }
                float scaleY = view8.getScaleY();
                View view9 = this.centerView;
                if (view9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view9 = null;
                }
                float x17 = view9.getX();
                View view10 = this.centerView;
                if (view10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view10 = null;
                }
                float width2 = x17 + (view10.getWidth() / 2);
                View view11 = this.centerView;
                if (view11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view11 = null;
                }
                float y17 = view11.getY();
                View view12 = this.centerView;
                if (view12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view12 = null;
                }
                matrix.postScale(scaleX, scaleY, width2, y17 + (view12.getHeight() / 2));
                TextView textView = this.joinNumbersView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                    textView = null;
                }
                TextPaint paint = textView.getPaint();
                TextView textView2 = this.joinNumbersView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                    textView2 = null;
                }
                float measureText = paint.measureText(textView2.getText().toString());
                TextView textView3 = this.joinNumbersView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                    textView3 = null;
                }
                float descent = textView3.getPaint().descent();
                TextView textView4 = this.joinNumbersView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                    textView4 = null;
                }
                float ascent = descent - textView4.getPaint().ascent();
                View view13 = this.centerView;
                if (view13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view13 = null;
                }
                float x18 = view13.getX();
                View view14 = this.centerView;
                if (view14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view14 = null;
                }
                float width3 = x18 + (view14.getWidth() / 2);
                View view15 = this.centerView;
                if (view15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view15 = null;
                }
                float y18 = view15.getY();
                View view16 = this.centerView;
                if (view16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view16 = null;
                }
                float[] fArr = {width3, y18 + view16.getHeight() + e83.a.b(10) + (ascent / 2)};
                matrix.mapPoints(fArr);
                TextView textView5 = this.joinNumbersView;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                    textView5 = null;
                }
                ViewGroup.LayoutParams layoutParams = textView5.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = ((int) fArr[0]) - (((int) measureText) / 2);
                layoutParams2.topMargin = ((int) fArr[1]) - (((int) ascent) / 2);
                TextView textView6 = this.joinNumbersView;
                if (textView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                    textView6 = null;
                }
                textView6.setLayoutParams(layoutParams2);
                TextView textView7 = this.joinNumbersView;
                if (textView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                    textView7 = null;
                }
                View view17 = this.centerView;
                if (view17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    view17 = null;
                }
                textView7.setRotation(view17.getRotation());
                if (!this.hasShownJoinNumsView) {
                    TextView textView8 = this.joinNumbersView;
                    if (textView8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
                        textView8 = null;
                    }
                    textView8.setVisibility(0);
                    View view18 = this.centerView;
                    if (view18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("centerView");
                    } else {
                        view2 = view18;
                    }
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.view.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            InteractiveFrameLayout.Z(InteractiveFrameLayout.this);
                        }
                    }, 5000L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(InteractiveFrameLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hasShownJoinNumsView = true;
        TextView textView = this$0.joinNumbersView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
            textView = null;
        }
        textView.setVisibility(8);
    }

    private final void a0() {
        this.menuLayout.d(this.borderView, getWidth(), getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(final InteractiveFrameLayout this$0, boolean z16, InteractiveModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        this$0.isEditModel = z16;
        this$0.z(model);
        View view = this$0.centerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        view.setVisibility(0);
        View view3 = this$0.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view2 = view3;
        }
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.l
            @Override // java.lang.Runnable
            public final void run() {
                InteractiveFrameLayout.d0(InteractiveFrameLayout.this);
            }
        });
        this$0.A(model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(InteractiveFrameLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float width = (this$0.getWidth() - this$0.rightLineMarginRightPx) - this$0.leftLinePx;
        View view = this$0.centerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        this$0.maxScale = Math.min(width / view.getWidth(), 1.48f);
        this$0.V();
    }

    private final void y() {
        if (this.joinNumbersView == null) {
            TextView textView = new TextView(getContext());
            textView.setTextSize(12.0f);
            textView.setTextColor(-1);
            textView.setShadowLayer(4.0f, 2.0f, 2.0f, Color.argb(63, 0, 0, 0));
            textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            textView.setVisibility(8);
            this.joinNumbersView = textView;
        }
        TextView textView2 = this.joinNumbersView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
            textView2 = null;
        }
        addView(textView2);
    }

    private final void z(InteractiveModel model) {
        this.interactiveModel = model;
        View view = this.centerView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        view.setX(Math.max(this.leftLinePx, model.getXAxisPercentage() * getWidth()));
        view.setY(Math.max(this.topLinePx, model.getYAxisPercentage() * getHeight()));
        view.setRotation(model.getRotation());
        view.setScaleX(model.getScale());
        view.setScaleY(model.getScale());
        float width = (getWidth() - this.rightLineMarginRightPx) - this.leftLinePx;
        View view3 = this.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view2 = view3;
        }
        TextView textView = (TextView) view2.findViewById(R.id.f164762tr2);
        textView.setText(model.getTagName());
        this.hasShownJoinNumsView = false;
        textView.setMaxWidth(((int) width) / 2);
    }

    public final void G() {
        I();
        View view = this.centerView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        view.setVisibility(8);
        TextView textView = this.joinNumbersView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinNumbersView");
            textView = null;
        }
        textView.setVisibility(8);
        this.leftLineAlpha = 0;
        this.rightLineAlpha = 0;
        this.topLineAlpha = 0;
        this.bottomLineAlpha = 0;
        this.interactiveModel = null;
        setVisibility(8);
    }

    @Nullable
    public final InteractiveModel H() {
        View view = null;
        if (this.interactiveModel == null) {
            return null;
        }
        View view2 = this.centerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view2 = null;
        }
        float x16 = view2.getX() / getWidth();
        View view3 = this.centerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view3 = null;
        }
        float y16 = view3.getY() / getHeight();
        View view4 = this.centerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view4 = null;
        }
        float rotation = view4.getRotation();
        View view5 = this.centerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
        } else {
            view = view5;
        }
        float scaleX = view.getScaleX();
        InteractiveModel interactiveModel = this.interactiveModel;
        Intrinsics.checkNotNull(interactiveModel);
        String tagName = interactiveModel.getTagName();
        InteractiveModel interactiveModel2 = this.interactiveModel;
        Intrinsics.checkNotNull(interactiveModel2);
        InteractiveModel interactiveModel3 = new InteractiveModel(x16, y16, rotation, scaleX, tagName, interactiveModel2.getJoinNums());
        QLog.d("InteractiveFrameLayout", 1, "getCenterViewPosition model:" + interactiveModel3 + " (" + getWidth() + ", " + getHeight() + ")");
        return interactiveModel3;
    }

    public final void K(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View view2 = this.centerView;
        if (view2 != null) {
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("centerView");
                view2 = null;
            }
            removeView(view2);
        }
        this.centerView = view;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("centerView");
            view = null;
        }
        addView(view);
        addView(this.menuLayout, new FrameLayout.LayoutParams(-2, -2));
        y();
        J();
        this.leftTopView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                InteractiveFrameLayout.L(InteractiveFrameLayout.this, view3);
            }
        });
    }

    public final void b0(@NotNull final InteractiveModel model, final boolean isEdit) {
        Intrinsics.checkNotNullParameter(model, "model");
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.view.k
            @Override // java.lang.Runnable
            public final void run() {
                InteractiveFrameLayout.c0(InteractiveFrameLayout.this, isEdit, model);
            }
        });
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.isEditModel) {
            return Q(event);
        }
        return R(event);
    }

    public final void setMenuItems(@NotNull ArrayList<MenuLayout.MenuItem> popupMenuItems, @NotNull MenuLayout.b popupMenuClickListener) {
        Intrinsics.checkNotNullParameter(popupMenuItems, "popupMenuItems");
        Intrinsics.checkNotNullParameter(popupMenuClickListener, "popupMenuClickListener");
        this.menuLayout.setMenuItems(popupMenuItems);
        this.menuLayout.setPopupMenuClickListener(popupMenuClickListener);
    }

    public final void setOnCenterViewClick(@NotNull d click) {
        Intrinsics.checkNotNullParameter(click, "click");
        this.onCenterViewClick = click;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ InteractiveFrameLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InteractiveFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gradientThreshold = e83.a.b(10);
        this.touchDistance = e83.a.b(5);
        this.borderStroke = e83.a.b(2);
        this.clickThreshold = 1500L;
        this.clickDistanceThreshold = e83.a.b(5);
        this.longClickThreshold = 500L;
        this.leftLinePx = e83.a.b(16);
        this.topLinePx = e83.a.b(114);
        this.rightLineMarginRightPx = e83.a.b(64);
        this.bottomLineMarginBottomPx = e83.a.b(168);
        this.maxScale = 1.48f;
        this.menuLayout = new MenuLayout(context, null, 2, 0 == true ? 1 : 0);
        View view = new View(context);
        view.setBackground(new a());
        view.setVisibility(8);
        this.borderView = view;
        View view2 = new View(context);
        view2.setBackground(new b());
        view2.setVisibility(8);
        this.borderLineView = view2;
        ImageView imageView = new ImageView(context);
        imageView.setVisibility(8);
        this.leftTopView = imageView;
        ImageView imageView2 = new ImageView(context);
        imageView2.setVisibility(8);
        this.rightBottomView = imageView2;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.oeq);
        this.rightBottomView.setImageBitmap(decodeResource);
        this.bmpZoom = decodeResource;
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.oep);
        this.leftTopView.setImageBitmap(decodeResource2);
        this.bmpDelete = decodeResource2;
        this.longPressHandler = ThreadManagerV2.getUIHandlerV2();
        this.longPressRunnable = new Runnable() { // from class: com.tencent.mobileqq.wink.view.g
            @Override // java.lang.Runnable
            public final void run() {
                InteractiveFrameLayout.P(InteractiveFrameLayout.this);
            }
        };
        addView(view, new FrameLayout.LayoutParams(-2, -2));
        addView(view2, new FrameLayout.LayoutParams(-1, -1));
        addView(this.leftTopView, new FrameLayout.LayoutParams(-2, -2));
        addView(this.rightBottomView, new FrameLayout.LayoutParams(-2, -2));
        this.iconWH = decodeResource2.getWidth();
        this.linePadding = (r6 / 2) + 2.0f;
        this.rotationGestureDetector = new p(new e());
        this.scaleGestureDetector = new ScaleGestureDetector(context, new f());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/view/InteractiveFrameLayout$d;", "", "Lcom/tencent/mobileqq/wink/model/InteractiveModel;", "model", "", "b", "c", "d", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface d {
        void a();

        void b(@Nullable InteractiveModel model);

        void c(@Nullable InteractiveModel model);

        void d(@Nullable InteractiveModel model);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes21.dex */
        public static final class a {
            public static void a(@NotNull d dVar) {
            }

            public static void b(@NotNull d dVar, @Nullable InteractiveModel interactiveModel) {
            }
        }
    }
}
