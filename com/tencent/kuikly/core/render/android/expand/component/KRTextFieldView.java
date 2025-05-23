package com.tencent.kuikly.core.render.android.expand.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.SizeF;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.UiThread;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.expand.module.s;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import d01.m;
import d01.u;
import d01.w;
import d01.y;
import h01.a;
import i01.c;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0091\u0001B\u001e\u0012\b\u0010\u008e\u0001\u001a\u00030\u008d\u0001\u0012\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J5\u0010)\u001a\u00020\u000b2+\u0010(\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'H\u0002J\u0012\u0010*\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\u0014\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\r02H\u0002J\b\u00104\u001a\u00020\u000bH\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u000bH\u0002J\u0010\u00107\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0002J\b\u00108\u001a\u00020\u000bH\u0002J\b\u00109\u001a\u00020\u000bH\u0002J\b\u0010:\u001a\u00020\u000bH\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\u0018\u0010?\u001a\u00020\u00182\u0006\u0010<\u001a\u00020\u00072\u0006\u0010>\u001a\u00020=H\u0002J\u0018\u0010A\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\rH\u0016JI\u0010C\u001a\u0004\u0018\u00010\r2\u0006\u0010B\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2+\u0010(\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'H\u0016J\b\u0010D\u001a\u00020\u000bH\u0016J\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020EH\u0014J\u0010\u0010I\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u0018H\u0016J*\u0010O\u001a\u00020\u000b2\b\u0010K\u001a\u0004\u0018\u00010J2\u0006\u0010L\u001a\u00020\u00182\u0006\u0010M\u001a\u00020\u00182\u0006\u0010N\u001a\u00020\u0018H\u0014J\u0018\u0010R\u001a\u00020\u000b2\u0006\u0010P\u001a\u00020\u00182\u0006\u0010Q\u001a\u00020\u0018H\u0014J\u0018\u0010U\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u00182\u0006\u0010T\u001a\u00020\u0018H\u0014J\u0010\u0010W\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u0007H\u0016J\"\u0010\\\u001a\u00020\u000b2\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00182\b\u0010[\u001a\u0004\u0018\u00010ZH\u0014J\u0010\u0010_\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020]H\u0016J\u001a\u0010d\u001a\u00020b2\b\u0010a\u001a\u0004\u0018\u00010`2\u0006\u0010c\u001a\u00020bH\u0016J\b\u0010e\u001a\u00020\u000bH\u0014R;\u0010h\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR;\u0010j\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010gR;\u0010l\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010gR;\u0010n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010gR;\u0010p\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010gR;\u0010r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010gR\u0018\u0010u\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010tR;\u0010v\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010gR;\u0010w\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u000b\u0018\u00010#j\u0004\u0018\u0001`'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010gR\u0016\u0010x\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\bR\"\u0010}\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0014\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0016\u0010~\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010\u007f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u0014R\u001b\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b1\u0010\u0081\u0001R\u0017\u0010\u0083\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0014R\u0017\u0010\u0084\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b/\u0010\u0085\u0001R\u0017\u0010\u0087\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010,R\u0017\u0010\u0088\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010,R\u0017\u0010\u0089\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010,R\u0017\u0010\u008a\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010,R\u0017\u0010\u008b\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010,R\u0018\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u000f\u0010\u0085\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRTextFieldView;", "Landroid/widget/EditText;", "Li01/c;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "", "scrollX", "scrollY", "", UserInfo.SEX_FEMALE, "", "params", "", "Y", "", "value", "T", "a0", "f0", "d0", "propValue", "Z", "b0", "c0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "color", BdhLogUtil.LogTag.Tag_Req, "g0", "e0", "i0", "V", "W", "U", "k0", "P", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.LATITUDE_SOUTH, "K", "I", "H", "G", "M", "L", "J", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "j0", "B", "h0", "X", "N", "l0", "E", "showingKeyboard", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "D", "propKey", "b", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "index", "setSelection", "", "text", "start", "lengthBefore", "lengthAfter", "onTextChanged", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "selStart", "selEnd", "onSelectionChanged", "hasWindowFocus", "onWindowFocusChanged", "focused", "direction", "Landroid/graphics/Rect;", "previouslyFocusedRect", "onFocusChanged", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, DomainData.DOMAIN_NAME, "Landroid/view/View;", "v", "Landroidx/core/view/WindowInsetsCompat;", "insets", "onApplyWindowInsets", NodeProps.ON_ATTACHED_TO_WINDOW, "d", "Lkotlin/jvm/functions/Function1;", "textDidChangeCallback", "e", "inputFocusCallback", "f", "inputBlurCallback", tl.h.F, "textLengthBeyondLimitCallback", "i", "keyboardHeightChangeCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "textContentSizeChangedCallback", "Lcom/tencent/kuikly/core/render/android/expand/module/s;", "Lcom/tencent/kuikly/core/render/android/expand/module/s;", "keyboardStatusListener", "inputReturnCallBack", "imeActionCallBack", "fontSize", "getUseDpFontSizeDim", "()Z", "setUseDpFontSizeDim", "(Z)V", "useDpFontSizeDim", "cursorIndex", "hadSetEditorFactory", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "textProps", "pendingFocus", "currentKeyboardHeight", "Ljava/lang/Integer;", "maxTextLength", "currentTextLength", "bottomInset", "lastContentWidth", "lastContentHeight", "fontColor", "softInputMode", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/Integer;)V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class KRTextFieldView extends EditText implements i01.c, OnApplyWindowInsetsListener {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private s keyboardStatusListener;

    /* renamed from: D, reason: from kotlin metadata */
    private Function1<Object, Unit> inputReturnCallBack;

    /* renamed from: E, reason: from kotlin metadata */
    private Function1<Object, Unit> imeActionCallBack;

    /* renamed from: F, reason: from kotlin metadata */
    private float fontSize;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean useDpFontSizeDim;

    /* renamed from: H, reason: from kotlin metadata */
    private int cursorIndex;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean hadSetEditorFactory;

    /* renamed from: J, reason: from kotlin metadata */
    private com.tencent.kuikly.core.render.android.expand.component.d textProps;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean pendingFocus;

    /* renamed from: L, reason: from kotlin metadata */
    private int currentKeyboardHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private Integer maxTextLength;

    /* renamed from: N, reason: from kotlin metadata */
    private int currentTextLength;

    /* renamed from: P, reason: from kotlin metadata */
    private int bottomInset;

    /* renamed from: Q, reason: from kotlin metadata */
    private int lastContentWidth;

    /* renamed from: R, reason: from kotlin metadata */
    private int lastContentHeight;

    /* renamed from: S, reason: from kotlin metadata */
    private int fontColor;

    /* renamed from: T, reason: from kotlin metadata */
    private final Integer softInputMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> textDidChangeCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> inputFocusCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> inputBlurCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> textLengthBeyondLimitCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> keyboardHeightChangeCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> textContentSizeChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0004R\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0004\u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRTextFieldView$a;", "", "", "COLOR", "Ljava/lang/String;", "", "DEFAULT_KEYBOARD_CHANGED_ANIMATION_DURATION", "D", "EDITABLE", "FONT_SIZE", "FONT_WEIGHT", "IME_ACTION", "INPUT_BLUR", "INPUT_FOCUS", "INPUT_RETURN", "KEYBOARD_HEIGHT_CHANGE", "KEYBOARD_TYPE", "KEY_CURVE", "KEY_KEYBOARD_CHANGED_DURATION", "MAX_TEXT_LENGTH", "METHOD_BLUR", "METHOD_FOCUS", "METHOD_GET_CURSOR_INDEX", "METHOD_SET_CURSOR_INDEX", "METHOD_SET_TEXT", "PLACE_HOLDER", "PLACE_HOLDER_COLOR", "RETURN_KEY_TYPE", "TEXT", "TEXT_ALIGN", "TEXT_CONTENT_SIZE_CHANGED", "TEXT_DID_CHANGE", "TEXT_LENGTH_BEYOND_LIMIT", "TINT_COLOR", "", "TYPE_ENABLE_EDIT", "I", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", WSPublicAccReport.SOP_NAME_FOCUS, "", "onFocusChange"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b implements View.OnFocusChangeListener {
        b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z16) {
            if (z16) {
                Function1 function1 = KRTextFieldView.this.inputFocusCallback;
                if (function1 != null) {
                    return;
                }
                return;
            }
            Function1 function12 = KRTextFieldView.this.inputBlurCallback;
            if (function12 != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c implements TextView.OnEditorActionListener {
        c() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            String str;
            Map mapOf;
            switch (i3) {
                case 2:
                    str = ResourceAttributes.TelemetrySdkLanguageValues.GO;
                    break;
                case 3:
                    str = "search";
                    break;
                case 4:
                    str = "send";
                    break;
                case 5:
                    str = "next";
                    break;
                case 6:
                    str = "done";
                    break;
                case 7:
                    str = "previous";
                    break;
                default:
                    str = "";
                    break;
            }
            Function1 function1 = KRTextFieldView.this.imeActionCallBack;
            if (function1 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("ime_action", str));
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n\u00a2\u0006\u0002\b\t"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class d implements TextView.OnEditorActionListener {
        d() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            Function1 function1;
            if (i3 == 3 && (function1 = KRTextFieldView.this.inputReturnCallBack) != null) {
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/KRTextFieldView$e", "Lcom/tencent/kuikly/core/render/android/expand/module/s;", "", "height", "", "duration", "curveType", "", "a", "(ILjava/lang/Float;Ljava/lang/Integer;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class e implements s {
        e() {
        }

        @Override // com.tencent.kuikly.core.render.android.expand.module.s
        public void a(int height, @Nullable Float duration, @Nullable Integer curveType) {
            Map mapOf;
            if (height != KRTextFieldView.this.currentKeyboardHeight) {
                KRTextFieldView.this.currentKeyboardHeight = height;
                Function1 function1 = KRTextFieldView.this.keyboardHeightChangeCallback;
                if (function1 != null) {
                    Pair[] pairArr = new Pair[3];
                    int i3 = 0;
                    pairArr[0] = TuplesKt.to("height", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(KRTextFieldView.this.get_kuiklyRenderContext(), height)));
                    Object obj = duration;
                    if (duration == null) {
                        obj = Double.valueOf(0.2d);
                    }
                    pairArr[1] = TuplesKt.to("duration", obj);
                    if (curveType != null) {
                        i3 = curveType.intValue();
                    }
                    pairArr[2] = TuplesKt.to("curve", Integer.valueOf(i3));
                    mapOf = MapsKt__MapsKt.mapOf(pairArr);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/KRTextFieldView$g", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class g extends Editable.Factory {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ m f117781b;

        g(m mVar) {
            this.f117781b = mVar;
        }

        @Override // android.text.Editable.Factory
        @NotNull
        public Editable newEditable(@Nullable CharSequence source) {
            if (source != null) {
                com.tencent.kuikly.core.render.android.expand.component.d dVar = KRTextFieldView.this.textProps;
                if (dVar != null) {
                    CharSequence text = this.f117781b.a(KRTextFieldView.this.get_kuiklyRenderContext(), new y("input", source, dVar)).getText();
                    if (text instanceof Editable) {
                        return (Editable) text;
                    }
                    return new SpannableStringBuilder();
                }
                return new SpannableStringBuilder();
            }
            return new SpannableStringBuilder();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/KRTextFieldView$h", "Landroidx/core/view/WindowInsetsAnimationCompat$Callback;", "Landroidx/core/view/WindowInsetsAnimationCompat;", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "onStart", "Landroidx/core/view/WindowInsetsCompat;", "insets", "", "runningAnimations", "onProgress", "", "onEnd", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class h extends WindowInsetsAnimationCompat.Callback {
        h(int i3) {
            super(i3);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(@NotNull WindowInsetsAnimationCompat animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onEnd(animation);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
            Intrinsics.checkNotNullParameter(insets, "insets");
            Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
            return insets;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        @NotNull
        public WindowInsetsAnimationCompat.BoundsCompat onStart(@NotNull WindowInsetsAnimationCompat animation, @NotNull WindowInsetsAnimationCompat.BoundsCompat bounds) {
            int i3;
            boolean z16;
            Intrinsics.checkNotNullParameter(animation, "animation");
            Intrinsics.checkNotNullParameter(bounds, "bounds");
            if (!KRTextFieldView.this.E()) {
                i3 = KRTextFieldView.this.bottomInset;
            } else {
                KRTextFieldView kRTextFieldView = KRTextFieldView.this;
                WindowInsets rootWindowInsets = kRTextFieldView.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    z16 = rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime());
                } else {
                    z16 = false;
                }
                i3 = kRTextFieldView.D(z16, bounds);
            }
            com.tencent.kuikly.core.render.android.css.animation.e.INSTANCE.a(animation.getInterpolator());
            s sVar = KRTextFieldView.this.keyboardStatusListener;
            if (sVar != null) {
                sVar.a(i3, Float.valueOf(((float) animation.getDurationMillis()) / 1000.0f), 7);
            }
            WindowInsetsAnimationCompat.BoundsCompat onStart = super.onStart(animation, bounds);
            Intrinsics.checkNotNullExpressionValue(onStart, "super.onStart(animation, bounds)");
            return onStart;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRTextFieldView(@NotNull Context context, @Nullable Integer num) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.softInputMode = num;
        this.fontSize = -1.0f;
        this.fontColor = -16777216;
        O();
        B();
        setSingleLine();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> A() {
        Map<String, Object> mapOf;
        a.Companion companion = h01.a.INSTANCE;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("text", getText().toString()), TuplesKt.to("length", Integer.valueOf(companion.e(companion.c(getText().toString(), get_kuiklyRenderContext(), this.fontSize)))));
        return mapOf;
    }

    private final void B() {
        setFocusableInTouchMode(true);
        setFocusable(true);
    }

    private final void C(Function1<Object, Unit> callback) {
        Map mapOf;
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("cursorIndex", Integer.valueOf(this.cursorIndex)));
            callback.invoke(mapOf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r4 = r4.getInsets(androidx.core.view.WindowInsetsCompat.Type.systemBars());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int D(boolean showingKeyboard, WindowInsetsAnimationCompat.BoundsCompat bounds) {
        Insets insets;
        int i3 = 0;
        if (!showingKeyboard) {
            return 0;
        }
        int i16 = bounds.getUpperBound().bottom;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar == null || !aVar.getIsImmersiveEnable()) {
            WindowInsets rootWindowInsets = getRootWindowInsets();
            if (rootWindowInsets != null && insets != null) {
                i3 = insets.bottom;
            }
            return i16 - i3;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean E() {
        return Intrinsics.areEqual(DeviceInfoMonitor.getModel(), "Pixel 7 Pro");
    }

    private final boolean F(float scrollX, float scrollY) {
        if (scrollX == 0.0f && scrollY == 0.0f) {
            return false;
        }
        return true;
    }

    private final boolean G() {
        if (getOnFocusChangeListener() != null) {
            return true;
        }
        setOnFocusChangeListener(new b());
        return true;
    }

    private final boolean H(Object propValue) {
        if (propValue != null) {
            this.imeActionCallBack = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            setOnEditorActionListener(new c());
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean I(Object propValue) {
        if (propValue != null) {
            this.inputReturnCallBack = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            setOnEditorActionListener(new d());
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean J(Object propValue) {
        com.tencent.kuikly.core.render.android.a aVar;
        com.tencent.kuikly.core.render.android.expand.module.h hVar;
        Window window;
        if (this.keyboardHeightChangeCallback != null) {
            return true;
        }
        Integer num = this.softInputMode;
        if (num != null) {
            num.intValue();
            Activity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                window.setSoftInputMode(this.softInputMode.intValue());
            } else {
                return false;
            }
        }
        if (propValue != null) {
            this.keyboardHeightChangeCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            e eVar = new e();
            this.keyboardStatusListener = eVar;
            if (KRCSSViewExtensionKt.y() && (aVar = get_kuiklyRenderContext()) != null && (hVar = (com.tencent.kuikly.core.render.android.expand.module.h) aVar.a("KRKeyboardModule")) != null) {
                hVar.a(eVar);
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean K(Object propValue) {
        if (propValue != null) {
            this.textDidChangeCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            addTextChangedListener(new f());
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean L(Object propValue) {
        if (propValue != null) {
            this.textContentSizeChangedCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final boolean M(Object propValue) {
        if (propValue != null) {
            this.textLengthBeyondLimitCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.render.android.export.KuiklyRenderCallback /* = (result: kotlin.Any?) -> kotlin.Unit */");
    }

    private final void N() {
        int i3;
        setText(getText());
        Editable text = getText();
        if (text != null) {
            i3 = text.length();
        } else {
            i3 = 0;
        }
        setSelection(i3);
    }

    private final void O() {
        setPadding(0, 0, 0, 0);
        setBackground(null);
        setGravity(19);
    }

    private final void P() {
        clearFocus();
        post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView$setBlur$1
            @Override // java.lang.Runnable
            public final void run() {
                Object systemService = KRTextFieldView.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (systemService != null) {
                    ((InputMethodManager) systemService).hideSoftInputFromWindow(KRTextFieldView.this.getWindowToken(), 0);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        });
    }

    private final boolean Q(Object propValue) {
        if (propValue != null) {
            int w3 = com.tencent.kuikly.core.render.android.css.ktx.b.w((String) propValue);
            this.fontColor = w3;
            setTextColor(w3);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void R(int color) {
        if (Build.VERSION.SDK_INT >= 29) {
            Drawable textCursorDrawable = getTextCursorDrawable();
            if (textCursorDrawable instanceof InsetDrawable) {
                textCursorDrawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
                return;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable();
            Paint paint = shapeDrawable.getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            paint.setColor(color);
            shapeDrawable.setIntrinsicWidth(com.tencent.kuikly.core.render.android.css.ktx.b.K(get_kuiklyRenderContext(), 2.0f));
            Unit unit = Unit.INSTANCE;
            setTextCursorDrawable(shapeDrawable);
            return;
        }
        try {
            Field fCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
            Intrinsics.checkNotNullExpressionValue(fCursorDrawableRes, "fCursorDrawableRes");
            fCursorDrawableRes.setAccessible(true);
            int i3 = fCursorDrawableRes.getInt(this);
            Field fEditor = TextView.class.getDeclaredField("mEditor");
            Intrinsics.checkNotNullExpressionValue(fEditor, "fEditor");
            fEditor.setAccessible(true);
            Object obj = fEditor.get(this);
            Field fCursorDrawable = obj.getClass().getDeclaredField("mCursorDrawable");
            Intrinsics.checkNotNullExpressionValue(fCursorDrawable, "fCursorDrawable");
            fCursorDrawable.setAccessible(true);
            Drawable drawable = getResources().getDrawable(i3);
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            fCursorDrawable.set(obj, new Drawable[]{drawable, drawable});
        } catch (Exception e16) {
            w.f392617a.b("KRListView", "set mCursorDrawable error, " + e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void S(String params) {
        Integer intOrNull;
        if (params != null && intOrNull != null) {
            setSelection(intOrNull.intValue());
        }
    }

    private final boolean T(Object value) {
        boolean z16;
        if (value != null) {
            if (((Integer) value).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            setFocusable(z16);
            setFocusableInTouchMode(z16);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final void U() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        post(new Runnable() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView$setFocus$1
            @Override // java.lang.Runnable
            public final void run() {
                if (!KRTextFieldView.this.hasWindowFocus() || !KRTextFieldView.this.hasFocus()) {
                    KRTextFieldView.this.pendingFocus = true;
                } else {
                    KRTextFieldView.this.k0();
                }
            }
        });
    }

    private final boolean V(Object propValue) {
        float s16;
        if (propValue != null) {
            float floatValue = ((Number) propValue).floatValue();
            this.fontSize = floatValue;
            if (this.useDpFontSizeDim) {
                s16 = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), floatValue);
            } else {
                s16 = com.tencent.kuikly.core.render.android.css.ktx.b.s(get_kuiklyRenderContext(), floatValue);
            }
            setTextSize(0, s16);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Number");
    }

    private final boolean W(Object propValue) {
        if (propValue != null) {
            com.tencent.kuikly.core.render.android.expand.component.text.b bVar = new com.tencent.kuikly.core.render.android.expand.component.text.b((String) propValue, 0, 2, null);
            TextPaint paint = getPaint();
            Intrinsics.checkNotNullExpressionValue(paint, "paint");
            bVar.updateDrawState(paint);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void X() {
        m j3 = u.f392615m.j();
        if (j3 == null || this.hadSetEditorFactory) {
            return;
        }
        this.hadSetEditorFactory = true;
        setEditableFactory(new g(j3));
    }

    private final void Y(String params) {
        if (params == null) {
            params = "";
        }
        setText(params);
        setSelection(params.length());
    }

    private final boolean Z(Object propValue) {
        int i3;
        if (propValue != null) {
            String str = (String) propValue;
            int hashCode = str.hashCode();
            if (hashCode != -1034364087) {
                if (hashCode != 96619420) {
                    if (hashCode == 1216985755 && str.equals(NotificationActivity.PASSWORD)) {
                        i3 = 129;
                    }
                    i3 = 1;
                } else {
                    if (str.equals("email")) {
                        i3 = 33;
                    }
                    i3 = 1;
                }
            } else {
                if (str.equals("number")) {
                    i3 = 2;
                }
                i3 = 1;
            }
            setInputType(i3);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean a0(Object value) {
        if (value != null) {
            this.maxTextLength = (Integer) value;
            setFilters(new InputFilter[]{new h01.a(((Number) value).intValue(), get_kuiklyRenderContext(), new Function0<Float>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView$setMaxTextLength$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Float invoke() {
                    return Float.valueOf(invoke2());
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final float invoke2() {
                    float f16;
                    f16 = KRTextFieldView.this.fontSize;
                    return f16;
                }
            }, new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView$setMaxTextLength$2
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
                    Function1 function1;
                    function1 = KRTextFieldView.this.textLengthBeyondLimitCallback;
                    if (function1 != null) {
                    }
                }
            })});
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean b0(Object propValue) {
        if (propValue != null) {
            setHint((String) propValue);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean c0(Object propValue) {
        if (propValue != null) {
            setHintTextColor(com.tencent.kuikly.core.render.android.css.ktx.b.w((String) propValue));
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final boolean d0(Object value) {
        int i3;
        if (value != null) {
            String str = (String) value;
            switch (str.hashCode()) {
                case -906336856:
                    if (str.equals("search")) {
                        i3 = 3;
                        break;
                    }
                    i3 = 0;
                    break;
                case 3304:
                    if (str.equals(ResourceAttributes.TelemetrySdkLanguageValues.GO)) {
                        i3 = 2;
                        break;
                    }
                    i3 = 0;
                    break;
                case 3089282:
                    if (str.equals("done")) {
                        i3 = 6;
                        break;
                    }
                    i3 = 0;
                    break;
                case 3377907:
                    if (str.equals("next")) {
                        i3 = 5;
                        break;
                    }
                    i3 = 0;
                    break;
                case 3526536:
                    if (str.equals("send")) {
                        i3 = 4;
                        break;
                    }
                    i3 = 0;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            setImeOptions(i3);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean e0(Object propValue) {
        if (!(propValue instanceof String)) {
            propValue = null;
        }
        String str = (String) propValue;
        if (str == null) {
            str = "";
        }
        Y(str);
        return true;
    }

    private final boolean f0(Object value) {
        if (value != null) {
            String str = (String) value;
            int hashCode = str.hashCode();
            if (hashCode != -1364013995) {
                if (hashCode != 3317767) {
                    if (hashCode == 108511772 && str.equals("right")) {
                        setTextAlignment(3);
                        N();
                        return true;
                    }
                    return true;
                }
                if (str.equals("left")) {
                    setTextAlignment(2);
                    N();
                    return true;
                }
                return true;
            }
            if (str.equals("center")) {
                setTextAlignment(4);
                N();
                return true;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean g0(Object propValue) {
        if (propValue != null) {
            R(com.tencent.kuikly.core.render.android.css.ktx.b.w((String) propValue));
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final boolean h0(Object propValue) {
        boolean z16;
        if (propValue != null) {
            if (((Integer) propValue).intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            float f16 = this.fontSize;
            if (f16 != -1.0f && this.useDpFontSizeDim != z16) {
                this.useDpFontSizeDim = z16;
                V(Float.valueOf(f16));
            } else {
                this.useDpFontSizeDim = z16;
            }
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final boolean i0(Object propValue) {
        com.tencent.kuikly.core.render.android.expand.component.d dVar = new com.tencent.kuikly.core.render.android.expand.component.d(get_kuiklyRenderContext());
        dVar.A(this.fontColor);
        this.textProps = dVar;
        dVar.D("values", propValue);
        SpannableStringBuilder a16 = new com.tencent.kuikly.core.render.android.expand.component.text.e(get_kuiklyRenderContext()).a(dVar, new ArrayList(), new Function0<SizeF>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView$setValues$text$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SizeF invoke() {
                return new SizeF(0.0f, 0.0f);
            }
        });
        X();
        int selectionStart = getSelectionStart();
        setText(a16);
        setSelection(selectionStart);
        return true;
    }

    private final void j0() {
        if (KRCSSViewExtensionKt.y()) {
            return;
        }
        ViewCompat.setWindowInsetsAnimationCallback(getRootView(), new h(0));
        ViewCompat.setOnApplyWindowInsetsListener(this, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        Object systemService = getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService != null) {
            ((InputMethodManager) systemService).showSoftInput(this, 1);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        Layout layout;
        Map mapOf;
        Function1<Object, Unit> function1 = this.textContentSizeChangedCallback;
        if (function1 != null && (layout = getLayout()) != null) {
            int width = layout.getWidth();
            int height = layout.getHeight();
            if (this.lastContentWidth == width && this.lastContentHeight == height) {
                return;
            }
            this.lastContentWidth = width;
            this.lastContentHeight = height;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("contentWidth", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), width))), TuplesKt.to("contentHeight", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), height))));
            function1.invoke(mapOf);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -2147056007:
                if (propKey.equals("textLengthBeyondLimit")) {
                    return M(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -2093329081:
                if (propKey.equals("textContentSizeChanged")) {
                    return L(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1798639867:
                if (propKey.equals("useDpFontSizeDim")) {
                    return h0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1576785488:
                if (propKey.equals("placeholderColor")) {
                    return c0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1197193630:
                if (propKey.equals("textDidChange")) {
                    return K(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1089536706:
                if (propKey.equals("keyboardHeightChange")) {
                    return J(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -1065511464:
                if (propKey.equals("textAlign")) {
                    return f0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -823812830:
                if (propKey.equals("values")) {
                    return i0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -734428249:
                if (propKey.equals("fontWeight")) {
                    return W(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case -348388966:
                if (propKey.equals("inputReturn")) {
                    return I(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 3556653:
                if (propKey.equals("text")) {
                    return e0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 94842723:
                if (propKey.equals("color")) {
                    return Q(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 208939969:
                if (propKey.equals("keyboardType")) {
                    return Z(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 365601008:
                if (propKey.equals("fontSize")) {
                    return V(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 465119991:
                if (propKey.equals("maxTextLength")) {
                    return a0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 598246771:
                if (propKey.equals("placeholder")) {
                    return b0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 947486441:
                if (propKey.equals("returnKeyType")) {
                    return d0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1327599912:
                if (propKey.equals("tintColor")) {
                    return g0(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1363434286:
                if (propKey.equals("inputFocus")) {
                    this.inputFocusCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return G();
                }
                return c.a.p(this, propKey, propValue);
            case 1583050071:
                if (propKey.equals("imeAction")) {
                    return H(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1602416228:
                if (propKey.equals("editable")) {
                    return T(propValue);
                }
                return c.a.p(this, propKey, propValue);
            case 1706428241:
                if (propKey.equals("inputBlur")) {
                    this.inputBlurCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return G();
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

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.i(this, parent);
        if (Build.VERSION.SDK_INT <= 27) {
            parent.setFocusable(true);
            parent.setFocusableInTouchMode(true);
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    @NotNull
    public WindowInsetsCompat onApplyWindowInsets(@Nullable View v3, @NotNull WindowInsetsCompat insets) {
        Integer num;
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (KRCSSViewExtensionKt.y()) {
            return insets;
        }
        androidx.core.graphics.Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.ime());
        if (insets2 != null) {
            num = Integer.valueOf(insets2.bottom);
        } else {
            num = null;
        }
        this.bottomInset = num.intValue();
        return insets;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j0();
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        com.tencent.kuikly.core.render.android.a aVar;
        com.tencent.kuikly.core.render.android.expand.module.h hVar;
        c.a.k(this);
        s sVar = this.keyboardStatusListener;
        if (sVar != null && (aVar = get_kuiklyRenderContext()) != null && (hVar = (com.tencent.kuikly.core.render.android.expand.module.h) aVar.a("KRKeyboardModule")) != null) {
            hVar.c(sVar);
        }
        this.keyboardStatusListener = null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float scrollX = getScrollX();
        float scrollY = getScrollY();
        boolean F = F(scrollX, scrollY);
        if (F) {
            canvas.translate(scrollX, scrollY);
        }
        KRCSSViewExtensionKt.g(this, canvas);
        if (F) {
            canvas.translate(-scrollX, -scrollY);
        }
        super.onDraw(canvas);
        KRCSSViewExtensionKt.h(this, canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean focused, int direction, @Nullable Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (this.pendingFocus && focused && hasWindowFocus()) {
            k0();
            this.pendingFocus = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Layout layout = getLayout();
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Layout layout2 = getLayout();
        if (this.textContentSizeChangedCallback != null && layout == null && layout2 != null) {
            l0();
            setText(getText());
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int selStart, int selEnd) {
        super.onSelectionChanged(selStart, selEnd);
        this.cursorIndex = selStart;
    }

    @Override // android.widget.TextView
    protected void onTextChanged(@Nullable CharSequence text, int start, int lengthBefore, int lengthAfter) {
        int i3;
        if (text != null) {
            i3 = text.length();
        } else {
            i3 = 0;
        }
        this.currentTextLength = i3;
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (this.pendingFocus && hasWindowFocus && hasFocus()) {
            k0();
            this.pendingFocus = false;
        }
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        return c.a.m(this, propKey);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // android.widget.EditText
    public void setSelection(int index) {
        int i3 = this.currentTextLength;
        if (i3 <= index) {
            super.setSelection(i3);
        } else {
            super.setSelection(index);
        }
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    public final void setUseDpFontSizeDim(boolean z16) {
        this.useDpFontSizeDim = z16;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case 3027047:
                if (method.equals("blur")) {
                    P();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 97604824:
                if (method.equals(WSPublicAccReport.SOP_NAME_FOCUS)) {
                    U();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 292717914:
                if (method.equals("setCursorIndex")) {
                    S(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 1984984239:
                if (method.equals(IECSearchBar.METHOD_SET_TEXT)) {
                    Y(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 2064454118:
                if (method.equals("getCursorIndex")) {
                    C(callback);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            default:
                return c.a.b(this, method, params, callback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/KRTextFieldView$f", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class f implements TextWatcher {
        public f() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            Function1 function1 = KRTextFieldView.this.textDidChangeCallback;
            if (function1 != null) {
            }
            KRTextFieldView.this.l0();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
