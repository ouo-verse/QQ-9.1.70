package com.tencent.kuikly.core.render.android.css.ktx;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.ArrayMap;
import android.util.DisplayMetrics;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.KGestureDetector;
import com.tencent.kuikly.core.render.android.css.animation.KRCSSAnimation;
import com.tencent.kuikly.core.render.android.css.animation.n;
import com.tencent.kuikly.core.render.android.css.decoration.KRViewDecoration;
import com.tencent.kuikly.core.render.android.css.gesture.KRCSSGestureListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import d01.w;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\u001a\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000\u001a\u001a\u0010\b\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0012\u0010\f\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\n\u001a\u00020\t\u001a\u0012\u0010\r\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\n\u001a\u00020\t\u001a\u0012\u0010\u000f\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0001\u001a\f\u0010\u0010\u001a\u00020\u000b*\u00020\u0003H\u0002\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\u0003H\u0002\u001a\u0012\u0010\u0014\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012\u001a\u0014\u0010\u0015\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0012H\u0002\u001aX\u0010\u001b\u001a!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u0016j\u0002`\u0019*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012%\u0010\u001a\u001a!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u0016j\u0002`\u0019\u001a\n\u0010\u001c\u001a\u00020\u000b*\u00020\u0003\u001a\u0012\u0010\u001d\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0001\u001a\f\u0010\u001e\u001a\u00020\u000b*\u00020\u0003H\u0002\u001a\f\u0010\u001f\u001a\u00020\u000b*\u00020\u0003H\u0002\u001a;\u0010%\u001a\u00020\u000b*\u00020\u00032\u0006\u0010!\u001a\u00020 2'\u0010$\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000b0\u0016j\u0002`#\u001a\n\u0010&\u001a\u00020\u000b*\u00020\u0003\u001a\u001c\u0010'\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0016\u0010)\u001a\u00020\u000b*\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010,\u001a\u00020\u000b*\u00020\u00032\u0006\u0010+\u001a\u00020*H\u0002\u001a\u0014\u0010-\u001a\u00020\u000b*\u00020\u00032\u0006\u0010+\u001a\u00020*H\u0000\u001a\f\u0010.\u001a\u00020\u000b*\u00020\u0003H\u0000\u001a\u0014\u00100\u001a\u00020\u000b*\u00020\u00032\u0006\u0010/\u001a\u00020\u0005H\u0002\u001a3\u00101\u001a!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u0016j\u0002`\u0019*\u00020\u00032\u0006\u0010/\u001a\u00020\u0005H\u0002\u001a\f\u00102\u001a\u00020\u000b*\u00020\u0003H\u0002\u001a!\u00104\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u00103*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\u0004\b4\u00105\u001a\u001a\u00106\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005\u001a!\u00107\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u00103*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u00a2\u0006\u0004\b7\u00105\u001a\f\u00109\u001a\u000208*\u0004\u0018\u00010\u0001\u001a\u0014\u0010;\u001a\u00020\u000b*\u00020\u00032\u0006\u0010:\u001a\u00020\u0005H\u0002\u001a\u000e\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020<\u001a\u0014\u0010@\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0000\"\u0016\u0010B\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\u001f\"\u0016\u0010C\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001f\"\u0016\u0010E\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010D\"(\u0010J\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00078@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\",\u0010O\u001a\u0004\u0018\u00010 *\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010 8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\"(\u0010R\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00078@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\bP\u0010G\"\u0004\bQ\u0010I\",\u0010U\u001a\u0004\u0018\u00010 *\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010 8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\bS\u0010L\"\u0004\bT\u0010N\"(\u0010[\u001a\u00020V*\u00020\u00032\u0006\u0010\u0006\u001a\u00020V8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z\"(\u0010^\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00078B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\\\u0010G\"\u0004\b]\u0010I\"(\u0010a\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b_\u0010G\"\u0004\b`\u0010I\",\u0010d\u001a\u0004\u0018\u00010 *\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010 8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\bb\u0010L\"\u0004\bc\u0010N\",\u0010i\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\be\u0010f\"\u0004\bg\u0010h\",\u0010l\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bj\u0010f\"\u0004\bk\u0010h\",\u0010o\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bm\u0010f\"\u0004\bn\u0010h\",\u0010q\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\bp\u0010f\"\u0004\b3\u0010h\",\u0010w\u001a\u0004\u0018\u00010r*\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010r8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\bs\u0010t\"\u0004\bu\u0010v\"\u0018\u0010y\u001a\u00020\u0007*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bx\u0010G\",\u0010\u007f\u001a\u0004\u0018\u00010z*\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010z8A@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~\"\u001a\u0010\u0081\u0001\u001a\u00020\u0007*\u00020\u00038@X\u0080\u0004\u00a2\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010G\"0\u0010+\u001a\u0004\u0018\u00010**\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010*8B@BX\u0082\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001\"w\u0010\u008a\u0001\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016j\u0004\u0018\u0001`#*\u00020\u00032+\u0010\u0006\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016j\u0004\u0018\u0001`#8B@BX\u0082\u000e\u00a2\u0006\u0010\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0018\u0010\u008d\u0001\u001a\u00020 *\u00020<8G\u00a2\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u001b\u0010\u008f\u0001\u001a\u00020 *\u00020<8AX\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008c\u0001\"\u001b\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u0001*\u00020<8F\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0018\u0010\u0096\u0001\u001a\u00020\u0001*\u00020<8F\u00a2\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0014\u0010\u0099\u0001\u001a\u00020\u00078F\u00a2\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0017\u0010\u009b\u0001\u001a\u00020\u00078@X\u0080\u0004\u00a2\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u0098\u0001*A\u0010\u009c\u0001\"\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u00162\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u0016\u00a8\u0006\u009d\u0001"}, d2 = {"", "", "e", "Landroid/view/View;", "key", "", "value", "", "V", "Landroid/graphics/Canvas;", PM.CANVAS, "", "g", h.F, "propKey", "J", "N", "L", "Landroid/graphics/Rect;", AIInput.KEY_FRAME, "f", "m0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/kuikly/core/render/android/css/ktx/OnSetFrameBlock;", "onSetFrameBlock", "B", "G", UserInfo.SEX_FEMALE, "M", "I", "", "type", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "b", "K", "l0", "animation", "Y", "Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSAnimation;", "hrAnimation", "c", "E", "j0", "transform", "d", BdhLogUtil.LogTag.Tag_Conn, "O", "T", "w", "(Landroid/view/View;Ljava/lang/String;)Ljava/lang/Object;", "D", "H", "Lorg/json/JSONObject;", "k0", "propValue", "P", "Landroid/content/Context;", "context", "Landroid/util/Size;", "k", "X", "a", "innerStatusBarHeight", "innerNavigationBarHeight", "Ljava/lang/String;", "innerVersionName", "getTurboDisplayAutoUpdateEnable", "(Landroid/view/View;)Z", "h0", "(Landroid/view/View;Z)V", "turboDisplayAutoUpdateEnable", "getScrollIndex", "(Landroid/view/View;)Ljava/lang/Integer;", "g0", "(Landroid/view/View;Ljava/lang/Integer;)V", "scrollIndex", "l", "W", "forceNotReuse", "r", "d0", "minimumPanTouches", "", "getOpacity", "(Landroid/view/View;)F", "e0", "(Landroid/view/View;F)V", "opacity", "t", "f0", "overflow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hadSetFrame", "p", "b0", "hrBackgroundColor", "getBackgroundLinearGradient", "(Landroid/view/View;)Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Req, "(Landroid/view/View;Ljava/lang/String;)V", "backgroundLinearGradient", "getBoxShadow", "U", "boxShadow", "getBorderRadius", ExifInterface.LATITUDE_SOUTH, NodeProps.BORDER_RADIUS, "getBorderStyle", NodeProps.BORDER_STYLES, "Lcom/tencent/kuikly/core/render/android/css/decoration/KRViewDecoration;", HippyTKDListViewAdapter.X, "(Landroid/view/View;)Lcom/tencent/kuikly/core/render/android/css/decoration/KRViewDecoration;", "i0", "(Landroid/view/View;Lcom/tencent/kuikly/core/render/android/css/decoration/KRViewDecoration;)V", "viewDecorator", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isBorderRadiusAllEqual", "Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/view/View;)Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;", "c0", "(Landroid/view/View;Lcom/tencent/kuikly/core/render/android/css/gesture/KRCSSGestureListener;)V", "hrGestureListener", DomainData.DOMAIN_NAME, "hasPinGesture", "o", "(Landroid/view/View;)Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSAnimation;", "a0", "(Landroid/view/View;Lcom/tencent/kuikly/core/render/android/css/animation/KRCSSAnimation;)V", "j", "(Landroid/view/View;)Lkotlin/jvm/functions/Function1;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "animationCompletionBlock", "u", "(Landroid/content/Context;)I", "statusBarHeight", ReportConstant.COSTREPORT_PREFIX, "navigationBarHeight", "Landroid/app/Activity;", "i", "(Landroid/content/Context;)Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "v", "(Landroid/content/Context;)Ljava/lang/String;", "versionName", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Z", "isBeforeM", "y", "isBeforeAndroid11", "OnSetFrameBlock", "core-render-android_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRCSSViewExtensionKt {

    /* renamed from: a, reason: collision with root package name */
    private static int f117699a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f117700b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static String f117701c = "-1";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.kuikly.core.render.android.css.gesture.a f117702d;

        a(com.tencent.kuikly.core.render.android.css.gesture.a aVar) {
            this.f117702d = aVar;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent event) {
            com.tencent.kuikly.core.render.android.css.gesture.a aVar = this.f117702d;
            Intrinsics.checkNotNullExpressionValue(event, "event");
            return aVar.n(event);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/kuikly/core/render/android/css/ktx/KRCSSViewExtensionKt$b", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f117703a;

        b(String str) {
            this.f117703a = str;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@Nullable View host, @Nullable AccessibilityNodeInfo info) {
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (info != null) {
                info.setClassName(this.f117703a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R5\u0010\u000b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/kuikly/core/render/android/css/ktx/KRCSSViewExtensionKt$c", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "a", "d", "Lkotlin/jvm/functions/Function1;", "hrClickCallback", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c implements Function1<Object, Unit> {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Function1<Object, Unit> hrClickCallback;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f117705e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f117706f;

        c(View view, Object obj) {
            this.f117705e = view;
            this.f117706f = obj;
            if (obj != null) {
                this.hrClickCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
        }

        public void a(@Nullable Object result) {
            Function1 function1 = (Function1) KRCSSViewExtensionKt.w(this.f117705e, "preClick");
            if (function1 != null) {
            }
            this.hrClickCallback.invoke(result);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    private static final boolean A(View view) {
        KRViewDecoration kRViewDecoration = (KRViewDecoration) w(view, "viewDecorator");
        if (kRViewDecoration == null || kRViewDecoration.getBorderRadiusF() == -1.0f) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final Function1<Rect, Unit> B(@NotNull View observeOnSetFrame, @NotNull String propKey, @NotNull Function1<? super Rect, Unit> onSetFrameBlock) {
        Intrinsics.checkNotNullParameter(observeOnSetFrame, "$this$observeOnSetFrame");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(onSetFrameBlock, "onSetFrameBlock");
        Map map = (Map) w(observeOnSetFrame, "onSetFrameBlockObservers");
        if (map == null) {
            map = new LinkedHashMap();
            D(observeOnSetFrame, "onSetFrameBlockObservers", map);
        }
        map.put(propKey, onSetFrameBlock);
        return onSetFrameBlock;
    }

    private static final Function1<Rect, Unit> C(final View view, final Object obj) {
        return B(view, "transform", new Function1<Rect, Unit>() { // from class: com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt$observeTransformBlock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                invoke2(rect);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Rect it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object obj2 = obj;
                if (obj2 instanceof String) {
                    new n((String) obj, view).b();
                } else if (obj2 instanceof n) {
                    ((n) obj2).b();
                }
            }
        });
    }

    public static final void D(@NotNull View putViewData, @NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(putViewData, "$this$putViewData");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Object context = putViewData.getContext();
        if (!(context instanceof com.tencent.kuikly.core.render.android.a)) {
            context = null;
        }
        com.tencent.kuikly.core.render.android.a aVar = (com.tencent.kuikly.core.render.android.a) context;
        if (aVar != null) {
            aVar.N0(putViewData, key, value);
        }
    }

    public static final void E(@NotNull View removeHRAnimation, @NotNull KRCSSAnimation hrAnimation) {
        Intrinsics.checkNotNullParameter(removeHRAnimation, "$this$removeHRAnimation");
        Intrinsics.checkNotNullParameter(hrAnimation, "hrAnimation");
        ArrayMap arrayMap = (ArrayMap) w(removeHRAnimation, "animationQueue");
        if (arrayMap != null) {
            arrayMap.remove(Integer.valueOf(hrAnimation.hashCode()));
            if (arrayMap.isEmpty()) {
                H(removeHRAnimation, "animationQueue");
            }
        }
    }

    public static final void F(@NotNull View removeOnSetFrameObserver, @NotNull String propKey) {
        Intrinsics.checkNotNullParameter(removeOnSetFrameObserver, "$this$removeOnSetFrameObserver");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Map map = (Map) w(removeOnSetFrameObserver, "onSetFrameBlockObservers");
        if (map != null) {
            map.remove(propKey);
            if (map.isEmpty()) {
                H(removeOnSetFrameObserver, "onSetFrameBlockObservers");
            }
        }
    }

    public static final void G(@NotNull View removeOnSetFrameObservers) {
        Intrinsics.checkNotNullParameter(removeOnSetFrameObservers, "$this$removeOnSetFrameObservers");
        H(removeOnSetFrameObservers, "onSetFrameBlockObservers");
    }

    @Nullable
    public static final <T> T H(@NotNull View removeViewData, @NotNull String key) {
        Intrinsics.checkNotNullParameter(removeViewData, "$this$removeViewData");
        Intrinsics.checkNotNullParameter(key, "key");
        Object context = removeViewData.getContext();
        if (!(context instanceof com.tencent.kuikly.core.render.android.a)) {
            context = null;
        }
        com.tencent.kuikly.core.render.android.a aVar = (com.tencent.kuikly.core.render.android.a) context;
        if (aVar == null) {
            return null;
        }
        return (T) aVar.Q0(removeViewData, key);
    }

    private static final void I(View view) {
        i0(view, null);
        if (!z()) {
            view.setForeground(null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean J(@NotNull View resetCommonProp, @NotNull String propKey) {
        Intrinsics.checkNotNullParameter(resetCommonProp, "$this$resetCommonProp");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        switch (propKey.hashCode()) {
            case -1643834313:
                if (propKey.equals("doubleClick")) {
                    K(resetCommonProp);
                    return true;
                }
                return false;
            case -1383304148:
                if (propKey.equals("border")) {
                    I(resetCommonProp);
                    return true;
                }
                return false;
            case -1267206133:
                if (propKey.equals("opacity")) {
                    e0(resetCommonProp, 1.0f);
                    return true;
                }
                return false;
            case -731417480:
                if (propKey.equals(NodeProps.Z_INDEX)) {
                    resetCommonProp.setZ(0.0f);
                    return true;
                }
                return false;
            case -604457090:
                if (propKey.equals("minimumPanTouches")) {
                    d0(resetCommonProp, null);
                    return true;
                }
                return false;
            case -213139122:
                if (propKey.equals("accessibility")) {
                    resetCommonProp.setContentDescription(null);
                    resetCommonProp.setImportantForAccessibility(0);
                    return true;
                }
                return false;
            case -198433922:
                if (propKey.equals("debugName")) {
                    resetCommonProp.setContentDescription(null);
                    return true;
                }
                return false;
            case -101359900:
                if (propKey.equals("accessibilityRole")) {
                    resetCommonProp.setAccessibilityDelegate(null);
                }
                return false;
            case -33499294:
                if (propKey.equals("panDirection")) {
                    K(resetCommonProp);
                }
                return false;
            case 110749:
                if (propKey.equals("pan")) {
                    K(resetCommonProp);
                }
                return false;
            case 94750088:
                if (propKey.equals("click")) {
                    K(resetCommonProp);
                    return true;
                }
                return false;
            case 97692013:
                if (propKey.equals(AIInput.KEY_FRAME)) {
                    L(resetCommonProp);
                    return true;
                }
                return false;
            case 114203431:
                if (propKey.equals("longPress")) {
                    K(resetCommonProp);
                    return true;
                }
                return false;
            case 399627231:
                if (propKey.equals("turboDisplayAutoUpdateEnable")) {
                    H(resetCommonProp, "turboDisplayAutoUpdateEnable");
                    return true;
                }
                return false;
            case 529642498:
                if (propKey.equals("overflow")) {
                    N(resetCommonProp);
                    return true;
                }
                return false;
            case 743055051:
                if (propKey.equals("boxShadow")) {
                    M(resetCommonProp);
                    return true;
                }
                return false;
            case 1052666732:
                if (propKey.equals("transform")) {
                    O(resetCommonProp);
                    return true;
                }
                return false;
            case 1118509956:
                if (propKey.equals("animation")) {
                    Y(resetCommonProp, null);
                    return true;
                }
                return false;
            case 1280722338:
                if (propKey.equals("touchEnable")) {
                    resetCommonProp.setEnabled(true);
                    return true;
                }
                return false;
            case 1287124693:
                if (propKey.equals("backgroundColor")) {
                    M(resetCommonProp);
                    return true;
                }
                return false;
            case 1292595405:
                if (propKey.equals("backgroundImage")) {
                    M(resetCommonProp);
                    return true;
                }
                return false;
            case 1349188574:
                if (propKey.equals(NodeProps.BORDER_RADIUS)) {
                    M(resetCommonProp);
                    return true;
                }
                return false;
            case 1681999488:
                if (propKey.equals("animationCompletion")) {
                    Q(resetCommonProp, null);
                    return true;
                }
                return false;
            case 1941332754:
                if (propKey.equals("visibility")) {
                    resetCommonProp.setVisibility(0);
                    return true;
                }
                return false;
            case 2044955141:
                if (propKey.equals("scrollIndex")) {
                    g0(resetCommonProp, null);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static final void K(@NotNull View resetEventListener) {
        Intrinsics.checkNotNullParameter(resetEventListener, "$this$resetEventListener");
        resetEventListener.setOnTouchListener(null);
        c0(resetEventListener, null);
    }

    private static final void L(View view) {
        G(view);
        com.tencent.kuikly.core.render.android.css.ktx.b.p(view, new Rect());
        Z(view, false);
    }

    private static final void M(View view) {
        view.setBackground(null);
        i0(view, null);
    }

    private static final void N(View view) {
        view.setClipBounds(null);
        H(view, "overflow");
    }

    private static final void O(View view) {
        new n(null, view).o();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static final void P(View view, Object obj) {
        String str;
        if (obj != null) {
            String str2 = (String) obj;
            switch (str2.hashCode()) {
                case -1377687758:
                    if (str2.equals("button")) {
                        str = Button.class.getName();
                        break;
                    }
                    str = "";
                    break;
                case -906336856:
                    if (str2.equals("search")) {
                        str = EditText.class.getName();
                        break;
                    }
                    str = "";
                    break;
                case 3556653:
                    if (str2.equals("text")) {
                        str = TextView.class.getName();
                        break;
                    }
                    str = "";
                    break;
                case 100313435:
                    if (str2.equals("image")) {
                        str = ImageView.class.getName();
                        break;
                    }
                    str = "";
                    break;
                case 1536891843:
                    if (str2.equals(TuxQuestionType.QUESTION_OPTION_CHECKBOX)) {
                        str = CheckBox.class.getName();
                        break;
                    }
                    str = "";
                    break;
                default:
                    str = "";
                    break;
            }
            view.setAccessibilityDelegate(new b(str));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private static final void Q(View view, Function1<Object, Unit> function1) {
        if (function1 != null) {
            D(view, "animationCompletion", function1);
        } else {
            H(view, "animationCompletion");
        }
    }

    private static final void R(View view, String str) {
        KRViewDecoration x16 = x(view);
        if (x16 != null) {
            if (str == null) {
                str = "";
            }
            x16.u(str);
        }
    }

    private static final void S(View view, String str) {
        KRViewDecoration x16 = x(view);
        if (x16 != null) {
            if (str == null) {
                str = "";
            }
            x16.v(str);
        }
        view.invalidate();
    }

    private static final void T(View view, String str) {
        KRViewDecoration x16 = x(view);
        if (x16 != null) {
            if (str == null) {
                str = "";
            }
            x16.w(str);
        }
    }

    private static final void U(View view, String str) {
        KRViewDecoration x16 = x(view);
        if (x16 != null) {
            if (str == null) {
                str = "";
            }
            x16.x(str);
        }
    }

    public static final boolean V(@NotNull View setCommonProp, @NotNull String key, @NotNull Object value) {
        int i3;
        Intrinsics.checkNotNullParameter(setCommonProp, "$this$setCommonProp");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (l0(setCommonProp, key, value)) {
            return true;
        }
        boolean z16 = false;
        int i16 = 0;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        int i17 = 0;
        switch (key.hashCode()) {
            case -1904297048:
                if (key.equals("autoDarkEnable")) {
                    if (Build.VERSION.SDK_INT < 29) {
                        return true;
                    }
                    if (((Integer) value).intValue() == 1) {
                        z16 = true;
                    }
                    setCommonProp.setForceDarkAllowed(z16);
                    return true;
                }
                break;
            case -1643834313:
                if (key.equals("doubleClick")) {
                    b(setCommonProp, 2, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1));
                    return true;
                }
                break;
            case -1383304148:
                if (key.equals("border")) {
                    T(setCommonProp, (String) value);
                    return true;
                }
                break;
            case -1267206133:
                if (key.equals("opacity")) {
                    e0(setCommonProp, ((Number) value).floatValue());
                    return true;
                }
                break;
            case -731417480:
                if (key.equals(NodeProps.Z_INDEX)) {
                    setCommonProp.setZ(com.tencent.kuikly.core.render.android.css.ktx.b.H(value));
                    return true;
                }
                break;
            case -604457090:
                if (key.equals("minimumPanTouches")) {
                    int intValue = ((Integer) value).intValue();
                    d0(setCommonProp, Integer.valueOf(intValue));
                    KRCSSGestureListener q16 = q(setCommonProp);
                    if (q16 == null) {
                        return true;
                    }
                    q16.A(intValue);
                    return true;
                }
                break;
            case -213139122:
                if (key.equals("accessibility")) {
                    String str = (String) value;
                    setCommonProp.setContentDescription(str);
                    if (str.length() == 0) {
                        i17 = 1;
                    }
                    setCommonProp.setImportantForAccessibility(i17 ^ 1);
                    setCommonProp.setFocusable(true);
                    return true;
                }
                break;
            case -198433922:
                if (key.equals("debugName")) {
                    setCommonProp.setContentDescription((String) value);
                    return true;
                }
                break;
            case -101359900:
                if (key.equals("accessibilityRole")) {
                    P(setCommonProp, value);
                    return true;
                }
                break;
            case -33499294:
                if (key.equals("panDirection")) {
                    int intValue2 = ((Integer) value).intValue();
                    KRCSSGestureListener q17 = q(setCommonProp);
                    if (q17 == null) {
                        return true;
                    }
                    q17.B(KGestureDetector.ScrollDirection.INSTANCE.a(intValue2));
                    return true;
                }
                break;
            case 110749:
                if (key.equals("pan")) {
                    b(setCommonProp, 4, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1));
                    KRCSSGestureListener q18 = q(setCommonProp);
                    if (q18 != null) {
                        Integer r16 = r(setCommonProp);
                        if (r16 != null) {
                            i3 = r16.intValue();
                        } else {
                            i3 = 1;
                        }
                        q18.A(i3);
                    }
                    if (q18 == null) {
                        return true;
                    }
                    q18.v(true);
                    return true;
                }
                break;
            case 94750088:
                if (key.equals("click")) {
                    b(setCommonProp, 1, new c(setCommonProp, value));
                    return true;
                }
                break;
            case 97692013:
                if (key.equals(AIInput.KEY_FRAME)) {
                    Rect rect = (Rect) value;
                    com.tencent.kuikly.core.render.android.css.ktx.b.p(setCommonProp, rect);
                    Z(setCommonProp, true);
                    m0(setCommonProp, rect);
                    f(setCommonProp, rect);
                    return true;
                }
                break;
            case 114203431:
                if (key.equals("longPress")) {
                    KRCSSGestureListener q19 = q(setCommonProp);
                    if (q19 != null) {
                        q19.z(true);
                    }
                    b(setCommonProp, 3, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1));
                    return true;
                }
                break;
            case 399627231:
                if (key.equals("turboDisplayAutoUpdateEnable")) {
                    if (((Integer) value).intValue() == 1) {
                        z19 = true;
                    }
                    h0(setCommonProp, z19);
                    return true;
                }
                break;
            case 529642498:
                if (key.equals("overflow")) {
                    if (((Integer) value).intValue() == 1) {
                        z18 = true;
                    }
                    f0(setCommonProp, z18);
                    return true;
                }
                break;
            case 743055051:
                if (key.equals("boxShadow")) {
                    U(setCommonProp, (String) value);
                    return true;
                }
                break;
            case 1052666732:
                if (key.equals("transform")) {
                    d(setCommonProp, value);
                    return true;
                }
                break;
            case 1118509956:
                if (key.equals("animation")) {
                    Y(setCommonProp, (String) value);
                    W(setCommonProp, true);
                    return true;
                }
                break;
            case 1280722338:
                if (key.equals("touchEnable")) {
                    if (((Integer) value).intValue() == 1) {
                        z17 = true;
                    }
                    setCommonProp.setEnabled(z17);
                    return true;
                }
                break;
            case 1287124693:
                if (key.equals("backgroundColor")) {
                    b0(setCommonProp, Integer.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.w((String) value)));
                    return true;
                }
                break;
            case 1292595405:
                if (key.equals("backgroundImage")) {
                    R(setCommonProp, (String) value);
                    return true;
                }
                break;
            case 1349188574:
                if (key.equals(NodeProps.BORDER_RADIUS)) {
                    S(setCommonProp, (String) value);
                    return true;
                }
                break;
            case 1681999488:
                if (key.equals("animationCompletion")) {
                    Q(setCommonProp, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value, 1));
                    return true;
                }
                break;
            case 1941332754:
                if (key.equals("visibility")) {
                    if (((Integer) value).intValue() == 0) {
                        i16 = 8;
                    }
                    setCommonProp.setVisibility(i16);
                    return true;
                }
                break;
            case 2044955141:
                if (key.equals("scrollIndex")) {
                    g0(setCommonProp, (Integer) value);
                    return true;
                }
                break;
        }
        return false;
    }

    public static final void W(@NotNull View forceNotReuse, boolean z16) {
        Intrinsics.checkNotNullParameter(forceNotReuse, "$this$forceNotReuse");
        D(forceNotReuse, "VIEW_KEY_FORCE_NOT_REUSE", Boolean.valueOf(z16));
    }

    public static final void X(@NotNull View setFrameForAndroidM, @NotNull Rect frame) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(setFrameForAndroidM, "$this$setFrameForAndroidM");
        Intrinsics.checkNotNullParameter(frame, "frame");
        ViewGroup.LayoutParams layoutParams2 = setFrameForAndroidM.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
            marginLayoutParams.leftMargin = frame.left;
            marginLayoutParams.topMargin = frame.top;
            layoutParams = layoutParams2;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(0, 0);
            layoutParams3.leftMargin = frame.left;
            layoutParams3.topMargin = frame.top;
            layoutParams = layoutParams3;
        }
        layoutParams.width = frame.right;
        layoutParams.height = frame.bottom;
        setFrameForAndroidM.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        r4 = kotlin.collections.MapsKt__MapsKt.toMap(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        r4 = kotlin.collections.MapsKt__MapsKt.toMap(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Y(final View view, String str) {
        Map map;
        List<String> list;
        Map map2;
        boolean z16 = true;
        Object obj = null;
        if (str == null) {
            ArrayMap arrayMap = (ArrayMap) w(view, "animationQueue");
            if (arrayMap != null && map2 != null) {
                Iterator it = map2.entrySet().iterator();
                while (it.hasNext()) {
                    KRCSSAnimation kRCSSAnimation = (KRCSSAnimation) ((Map.Entry) it.next()).getValue();
                    KRCSSAnimation.g(kRCSSAnimation, null, 1, null);
                    kRCSSAnimation.m();
                }
                return;
            }
            return;
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            KRCSSAnimation o16 = o(view);
            a0(view, null);
            ArrayMap arrayMap2 = (ArrayMap) w(view, "animationQueue");
            if (arrayMap2 != null && map != null) {
                Iterator it5 = map.entrySet().iterator();
                while (it5.hasNext()) {
                    KRCSSAnimation kRCSSAnimation2 = (KRCSSAnimation) ((Map.Entry) it5.next()).getValue();
                    if (kRCSSAnimation2.k()) {
                        if (o16 != null) {
                            list = o16.e();
                        } else {
                            list = null;
                        }
                        kRCSSAnimation2.f(list);
                        kRCSSAnimation2.m();
                    } else {
                        kRCSSAnimation2.h();
                    }
                }
                return;
            }
            return;
        }
        Context context = view.getContext();
        if (context instanceof com.tencent.kuikly.core.render.android.a) {
            obj = context;
        }
        KRCSSAnimation kRCSSAnimation3 = new KRCSSAnimation(str, view, (com.tencent.kuikly.core.render.android.a) obj);
        kRCSSAnimation3.n(new Function4<KRCSSAnimation, Boolean, String, String, Unit>() { // from class: com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt$setHRAnimation$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(KRCSSAnimation kRCSSAnimation4, Boolean bool, String str2, String str3) {
                invoke(kRCSSAnimation4, bool.booleanValue(), str2, str3);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull KRCSSAnimation hrAnimation, boolean z17, @NotNull String propKey, @NotNull String animationKey) {
                Function1 j3;
                Map mapOf;
                Intrinsics.checkNotNullParameter(hrAnimation, "hrAnimation");
                Intrinsics.checkNotNullParameter(propKey, "propKey");
                Intrinsics.checkNotNullParameter(animationKey, "animationKey");
                j3 = KRCSSViewExtensionKt.j(view);
                if (j3 != null) {
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("finish", Integer.valueOf(z17 ? 1 : 0)), TuplesKt.to("attr", propKey), TuplesKt.to("animationKey", animationKey));
                }
                hrAnimation.m();
            }
        });
        a0(view, kRCSSAnimation3);
        c(view, kRCSSAnimation3);
    }

    public static final void Z(@NotNull View hadSetFrame, boolean z16) {
        Intrinsics.checkNotNullParameter(hadSetFrame, "$this$hadSetFrame");
        if (z16) {
            D(hadSetFrame, "hadSetFrame", Boolean.TRUE);
        } else {
            H(hadSetFrame, "hadSetFrame");
        }
    }

    private static final void a0(View view, KRCSSAnimation kRCSSAnimation) {
        if (Intrinsics.areEqual(kRCSSAnimation, o(view))) {
            return;
        }
        if (kRCSSAnimation == null) {
        } else {
            D(view, "animation", kRCSSAnimation);
        }
    }

    public static final void b(@NotNull View addEventListener, int i3, @NotNull Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(addEventListener, "$this$addEventListener");
        Intrinsics.checkNotNullParameter(callback, "callback");
        KRCSSGestureListener q16 = q(addEventListener);
        if (q16 != null) {
            q16.a(i3, callback);
        }
    }

    public static final void b0(@NotNull View hrBackgroundColor, @Nullable Integer num) {
        int i3;
        Intrinsics.checkNotNullParameter(hrBackgroundColor, "$this$hrBackgroundColor");
        KRViewDecoration x16 = x(hrBackgroundColor);
        if (x16 != null) {
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            x16.t(i3);
        }
    }

    private static final void c(View view, KRCSSAnimation kRCSSAnimation) {
        ArrayMap arrayMap = (ArrayMap) w(view, "animationQueue");
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            D(view, "animationQueue", arrayMap);
        }
        arrayMap.put(Integer.valueOf(kRCSSAnimation.hashCode()), kRCSSAnimation);
    }

    public static final void c0(@NotNull View hrGestureListener, @Nullable KRCSSGestureListener kRCSSGestureListener) {
        Intrinsics.checkNotNullParameter(hrGestureListener, "$this$hrGestureListener");
        if (kRCSSGestureListener == null) {
            H(hrGestureListener, "hr_gesture_tag");
        } else {
            D(hrGestureListener, "hr_gesture_tag", kRCSSGestureListener);
        }
    }

    private static final void d(View view, Object obj) {
        Function1<Rect, Unit> C = C(view, obj);
        if (m(view)) {
            C.invoke(com.tencent.kuikly.core.render.android.css.ktx.b.f(view));
        }
    }

    public static final void d0(@NotNull View minimumPanTouches, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(minimumPanTouches, "$this$minimumPanTouches");
        if (num == null) {
            H(minimumPanTouches, "minimumPanTouches");
        } else {
            D(minimumPanTouches, "minimumPanTouches", num);
        }
    }

    @NotNull
    public static final Set<String> e() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"opacity", "visibility", "overflow", "backgroundColor", "touchEnable", "transform", "backgroundImage", "boxShadow", NodeProps.BORDER_RADIUS, "border", "click", "doubleClick", "longPress", "animation", AIInput.KEY_FRAME, NodeProps.Z_INDEX, "pan", "animationCompletion", "accessibility", "debugName", "autoDarkEnable", "scrollIndex", "turboDisplayAutoUpdateEnable", "accessibilityRole", "minimumPanTouches", "panDirection"});
        return of5;
    }

    private static final void e0(View view, float f16) {
        view.setAlpha(f16);
    }

    public static final void f(@NotNull View dispatchOnSetFrame, @NotNull Rect frame) {
        Intrinsics.checkNotNullParameter(dispatchOnSetFrame, "$this$dispatchOnSetFrame");
        Intrinsics.checkNotNullParameter(frame, "frame");
        Map map = (Map) w(dispatchOnSetFrame, "onSetFrameBlockObservers");
        if (map != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                ((Function1) ((Map.Entry) it.next()).getValue()).invoke(frame);
            }
        }
    }

    private static final void f0(final View view, boolean z16) {
        if (!(view instanceof ViewGroup) || t(view) == z16) {
            return;
        }
        D(view, "overflow", Boolean.valueOf(z16));
        if (!z16) {
            ((ViewGroup) view).setClipBounds(null);
            F(view, "overflow");
        } else {
            Function1<Rect, Unit> B = B(view, "overflow", new Function1<Rect, Unit>() { // from class: com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt$overflow$onSetFrameBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                    invoke2(rect);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Rect it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!Intrinsics.areEqual(new Rect(0, 0, it.right, it.bottom), ((ViewGroup) view).getClipBounds())) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        Rect rect = new Rect();
                        rect.left = 0;
                        rect.top = 0;
                        rect.right = b.f(view).right;
                        rect.bottom = b.f(view).bottom;
                        Unit unit = Unit.INSTANCE;
                        viewGroup.setClipBounds(rect);
                    }
                }
            });
            if (m(view)) {
                B.invoke(com.tencent.kuikly.core.render.android.css.ktx.b.f(view));
            }
        }
    }

    public static final void g(@NotNull View drawCommonDecoration, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(drawCommonDecoration, "$this$drawCommonDecoration");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        KRViewDecoration kRViewDecoration = (KRViewDecoration) w(drawCommonDecoration, "viewDecorator");
        if (kRViewDecoration != null) {
            kRViewDecoration.g(com.tencent.kuikly.core.render.android.css.ktx.b.h(drawCommonDecoration), com.tencent.kuikly.core.render.android.css.ktx.b.g(drawCommonDecoration), canvas);
        }
    }

    public static final void g0(@NotNull View scrollIndex, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(scrollIndex, "$this$scrollIndex");
        if (num == null) {
            H(scrollIndex, "scrollIndex");
        } else {
            D(scrollIndex, "scrollIndex", num);
        }
    }

    public static final void h(@NotNull View drawCommonForegroundDecoration, @NotNull Canvas canvas) {
        KRViewDecoration kRViewDecoration;
        Intrinsics.checkNotNullParameter(drawCommonForegroundDecoration, "$this$drawCommonForegroundDecoration");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (z() && (kRViewDecoration = (KRViewDecoration) w(drawCommonForegroundDecoration, "viewDecorator")) != null) {
            kRViewDecoration.h(com.tencent.kuikly.core.render.android.css.ktx.b.h(drawCommonForegroundDecoration), com.tencent.kuikly.core.render.android.css.ktx.b.g(drawCommonForegroundDecoration), canvas);
        }
    }

    public static final void h0(@NotNull View turboDisplayAutoUpdateEnable, boolean z16) {
        Intrinsics.checkNotNullParameter(turboDisplayAutoUpdateEnable, "$this$turboDisplayAutoUpdateEnable");
        D(turboDisplayAutoUpdateEnable, "turboDisplayAutoUpdateEnable", Boolean.valueOf(z16));
    }

    @Nullable
    public static final Activity i(@NotNull Context activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$activity");
        if (activity instanceof Activity) {
            return (Activity) activity;
        }
        while (activity instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) activity;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                Context baseContext = contextWrapper.getBaseContext();
                if (baseContext != null) {
                    return (Activity) baseContext;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            activity = contextWrapper.getBaseContext();
            Intrinsics.checkNotNullExpressionValue(activity, "context.baseContext");
        }
        return null;
    }

    public static final void i0(@NotNull View viewDecorator, @Nullable KRViewDecoration kRViewDecoration) {
        Intrinsics.checkNotNullParameter(viewDecorator, "$this$viewDecorator");
        if (kRViewDecoration == null) {
            H(viewDecorator, "viewDecorator");
            if (viewDecorator.getOutlineProvider() != null) {
                viewDecorator.setOutlineProvider(null);
                viewDecorator.setClipToOutline(false);
                return;
            }
            return;
        }
        D(viewDecorator, "viewDecorator", kRViewDecoration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Object, Unit> j(View view) {
        return (Function1) w(view, "animationCompletion");
    }

    public static final void j0(@NotNull View stopAnimations) {
        Collection<KRCSSAnimation> values;
        Intrinsics.checkNotNullParameter(stopAnimations, "$this$stopAnimations");
        ArrayMap arrayMap = (ArrayMap) w(stopAnimations, "animationQueue");
        if (arrayMap != null && (values = arrayMap.values()) != null) {
            for (KRCSSAnimation kRCSSAnimation : values) {
                if (kRCSSAnimation != null && kRCSSAnimation.k()) {
                    KRCSSAnimation.g(kRCSSAnimation, null, 1, null);
                }
            }
        }
    }

    @NotNull
    public static final Size k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        if (systemService != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
            return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @NotNull
    public static final JSONObject k0(@Nullable String str) {
        if (str == null) {
            str = "{}";
        }
        return new JSONObject(str);
    }

    public static final boolean l(@NotNull View forceNotReuse) {
        Intrinsics.checkNotNullParameter(forceNotReuse, "$this$forceNotReuse");
        Boolean bool = (Boolean) w(forceNotReuse, "VIEW_KEY_FORCE_NOT_REUSE");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final boolean l0(View view, String str, Object obj) {
        KRCSSAnimation o16 = o(view);
        if (o16 != null && o16.p(str)) {
            o16.d(str, obj);
            return true;
        }
        return false;
    }

    public static final boolean m(@NotNull View hadSetFrame) {
        Intrinsics.checkNotNullParameter(hadSetFrame, "$this$hadSetFrame");
        Boolean bool = (Boolean) w(hadSetFrame, "hadSetFrame");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private static final void m0(View view, Rect rect) {
        KRViewDecoration x16;
        Object context = view.getContext();
        if (!(context instanceof com.tencent.kuikly.core.render.android.a)) {
            context = null;
        }
        com.tencent.kuikly.core.render.android.a aVar = (com.tencent.kuikly.core.render.android.a) context;
        if (aVar != null && A(view) && (x16 = x(view)) != null) {
            float min = Math.min(com.tencent.kuikly.core.render.android.css.ktx.b.j(rect), com.tencent.kuikly.core.render.android.css.ktx.b.i(rect)) / 2.0f;
            if (min < x16.getBorderRadiusF()) {
                float x17 = com.tencent.kuikly.core.render.android.css.ktx.b.x(aVar, min);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(Locale.ENGLISH, "%.2f,%.2f,%.2f,%.2f", Arrays.copyOf(new Object[]{Float.valueOf(x17), Float.valueOf(x17), Float.valueOf(x17), Float.valueOf(x17)}, 4));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                x16.v(format);
            }
        }
    }

    public static final boolean n(@NotNull View hasPinGesture) {
        Intrinsics.checkNotNullParameter(hasPinGesture, "$this$hasPinGesture");
        KRCSSGestureListener kRCSSGestureListener = (KRCSSGestureListener) w(hasPinGesture, "hr_gesture_tag");
        if (kRCSSGestureListener != null && kRCSSGestureListener.l()) {
            return true;
        }
        return false;
    }

    private static final KRCSSAnimation o(View view) {
        return (KRCSSAnimation) w(view, "animation");
    }

    @Nullable
    public static final Integer p(@NotNull View hrBackgroundColor) {
        Intrinsics.checkNotNullParameter(hrBackgroundColor, "$this$hrBackgroundColor");
        KRViewDecoration x16 = x(hrBackgroundColor);
        if (x16 != null) {
            return Integer.valueOf(x16.getBackgroundColor());
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    @Nullable
    public static final KRCSSGestureListener q(@NotNull View hrGestureListener) {
        Intrinsics.checkNotNullParameter(hrGestureListener, "$this$hrGestureListener");
        KRCSSGestureListener kRCSSGestureListener = (KRCSSGestureListener) w(hrGestureListener, "hr_gesture_tag");
        if (kRCSSGestureListener == null) {
            Object context = hrGestureListener.getContext();
            if (!(context instanceof com.tencent.kuikly.core.render.android.a)) {
                context = null;
            }
            kRCSSGestureListener = new KRCSSGestureListener((com.tencent.kuikly.core.render.android.a) context);
            D(hrGestureListener, "hr_gesture_tag", kRCSSGestureListener);
            Context context2 = hrGestureListener.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            com.tencent.kuikly.core.render.android.css.gesture.a aVar = new com.tencent.kuikly.core.render.android.css.gesture.a(context2, hrGestureListener, kRCSSGestureListener);
            kRCSSGestureListener.y(aVar);
            kRCSSGestureListener.z(false);
            hrGestureListener.setOnTouchListener(new a(aVar));
        }
        return kRCSSGestureListener;
    }

    @Nullable
    public static final Integer r(@NotNull View minimumPanTouches) {
        Intrinsics.checkNotNullParameter(minimumPanTouches, "$this$minimumPanTouches");
        return (Integer) w(minimumPanTouches, "minimumPanTouches");
    }

    @SuppressLint({"InternalInsetResource"})
    public static final int s(@NotNull Context navigationBarHeight) {
        Intrinsics.checkNotNullParameter(navigationBarHeight, "$this$navigationBarHeight");
        if (f117700b == -1) {
            try {
                Resources resources = navigationBarHeight.getResources();
                if (resources != null) {
                    f117700b = navigationBarHeight.getResources().getDimensionPixelSize(Integer.valueOf(resources.getIdentifier("navigation_bar_height", "dimen", "android")).intValue());
                }
            } catch (Throwable th5) {
                w.f392617a.c("KRCssViewExt", "getNavigationBarHeightError: " + th5);
            }
        }
        return f117700b;
    }

    private static final boolean t(View view) {
        Boolean bool = (Boolean) w(view, "overflow");
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @SuppressLint({"InternalInsetResource"})
    public static final int u(@NotNull Context statusBarHeight) {
        Intrinsics.checkNotNullParameter(statusBarHeight, "$this$statusBarHeight");
        if (f117699a == -1) {
            try {
                Resources resources = statusBarHeight.getResources();
                if (resources != null) {
                    f117699a = statusBarHeight.getResources().getDimensionPixelSize(Integer.valueOf(resources.getIdentifier("status_bar_height", "dimen", "android")).intValue());
                }
            } catch (Resources.NotFoundException e16) {
                w.f392617a.c("KRCssViewExt", "getStatusBarError: " + e16);
            }
        }
        return f117699a;
    }

    @NotNull
    public static final String v(@NotNull Context versionName) {
        Intrinsics.checkNotNullParameter(versionName, "$this$versionName");
        if (Intrinsics.areEqual(f117701c, "-1")) {
            try {
                String str = InstalledAppListMonitor.getPackageInfo(versionName.getPackageManager(), versionName.getPackageName(), 0).versionName;
                if (str == null) {
                    str = f117701c;
                }
                f117701c = str;
            } catch (Throwable th5) {
                w.f392617a.b("KRCSSViewExtension", "versionName error: " + th5);
            }
        }
        return f117701c;
    }

    @Nullable
    public static final <T> T w(@NotNull View getViewData, @NotNull String key) {
        Intrinsics.checkNotNullParameter(getViewData, "$this$getViewData");
        Intrinsics.checkNotNullParameter(key, "key");
        Object context = getViewData.getContext();
        if (!(context instanceof com.tencent.kuikly.core.render.android.a)) {
            context = null;
        }
        com.tencent.kuikly.core.render.android.a aVar = (com.tencent.kuikly.core.render.android.a) context;
        if (aVar == null) {
            return null;
        }
        return (T) aVar.P0(getViewData, key);
    }

    @Nullable
    public static final KRViewDecoration x(@NotNull View viewDecorator) {
        Intrinsics.checkNotNullParameter(viewDecorator, "$this$viewDecorator");
        KRViewDecoration kRViewDecoration = (KRViewDecoration) w(viewDecorator, "viewDecorator");
        if (kRViewDecoration == null) {
            KRViewDecoration kRViewDecoration2 = new KRViewDecoration(viewDecorator);
            D(viewDecorator, "viewDecorator", kRViewDecoration2);
            return kRViewDecoration2;
        }
        return kRViewDecoration;
    }

    public static final boolean y() {
        if (Build.VERSION.SDK_INT < 30) {
            return true;
        }
        return false;
    }

    public static final boolean z() {
        if (Build.VERSION.SDK_INT <= 23) {
            return true;
        }
        return false;
    }
}
