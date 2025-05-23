package com.tencent.kuikly.core.render.android.expand.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.gesture.KRCSSGestureListener;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import d01.w;
import i01.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0002b9B\u000f\u0012\u0006\u0010_\u001a\u00020^\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00142\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J5\u0010\u001c\u001a\u00020\u00052+\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\u0004\u0018\u0001`\u001aH\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020\nH\u0002J \u0010'\u001a\u00020\n2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010&\u001a\u00020%H\u0016J(\u0010,\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\"2\u0006\u0010(\u001a\u00020%2\u0006\u0010)\u001a\u00020%2\u0006\u0010+\u001a\u00020*H\u0016J \u00100\u001a\u00020\n2\u0006\u0010$\u001a\u00020\"2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-H\u0016J \u00105\u001a\u00020\n2\u0006\u00102\u001a\u0002012\u0006\u0010#\u001a\u00020\"2\u0006\u00104\u001a\u000203H\u0014J\u0010\u00107\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0003H\u0016J\u0018\u00109\u001a\u00020\n2\u0006\u00108\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010:\u001a\u00020\n2\u0006\u00108\u001a\u00020\u000fH\u0016J\u0012\u0010=\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010>\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010?\u001a\u00020\u00052\u0006\u00102\u001a\u000201H\u0016J\b\u0010@\u001a\u00020\u0005H\u0016R;\u0010C\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR;\u0010E\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010BR;\u0010G\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010BR$\u0010I\u001a\u0010\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010BR\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR;\u0010N\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010BR\u0018\u0010P\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010OR\u0016\u0010Q\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0018\u0010S\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010RR$\u0010Z\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0014\u0010]\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b[\u0010\\\u00a8\u0006c"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Landroid/view/MotionEvent;", "event", "", "B", "", "propValue", "D", "", "H", "E", "motionEvent", UserInfo.SEX_FEMALE, "", AdMetricTag.EVENT_NAME, "isCancel", "I", "G", "", "w", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/Choreographer;", "v", "y", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "child", "target", "", "nestedScrollAxes", "onStartNestedScroll", "dx", "dy", "", "consumed", "onNestedPreScroll", "", "velocityX", "velocityY", "onNestedPreFling", "Landroid/graphics/Canvas;", PM.CANVAS, "", "drawingTime", "drawChild", "ev", "dispatchTouchEvent", "propKey", "b", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View$OnTouchListener;", "l", "setOnTouchListener", "onTouchEvent", "draw", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lkotlin/jvm/functions/Function1;", "touchDownCallback", "e", "touchMoveCallback", "f", "touchUpCallback", tl.h.F, "screenFrameCallback", "i", "Z", "screenFramePause", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hitTestSelfCallback", "Landroid/view/View$OnTouchListener;", "touchListenerProxy", "currentActionState", "Ljava/lang/Integer;", "hitTestMode", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "getNestedScrollDelegate", "()Landroid/view/ViewGroup;", "setNestedScrollDelegate", "(Landroid/view/ViewGroup;)V", "nestedScrollDelegate", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public class KRView extends FrameLayout implements i01.c {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View.OnTouchListener touchListenerProxy;

    /* renamed from: D, reason: from kotlin metadata */
    private int currentActionState;

    /* renamed from: E, reason: from kotlin metadata */
    private Integer hitTestMode;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ViewGroup nestedScrollDelegate;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> touchDownCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> touchMoveCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> touchUpCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function1<? super Long, Unit> screenFrameCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean screenFramePause;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> hitTestSelfCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRView$a;", "", "", "EVENT_ACTION", "Ljava/lang/String;", "EVENT_HIT_TEST_SELF", "EVENT_SCREEN_FRAME", "EVENT_TOUCH_CANCEL", "EVENT_TOUCH_DOWN", "EVENT_TOUCH_MOVE", "EVENT_TOUCH_UP", "HIT_TEST_MODE", "", "HIT_TEST_MODE_PIXEL_TRANSPARENT", "I", "HIT_TEST_MODE_SHARE_BASE_TOUCH", "PAGE_X", "PAGE_Y", "SCREEN_FRAME_PAUSE", "TOUCHES", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRView$b;", "Landroid/graphics/Canvas;", "", "a", UserInfo.SEX_FEMALE, "()F", "hitTestX", "b", "hitTestY", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(FFLandroid/graphics/Bitmap;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends Canvas {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final float hitTestX;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final float hitTestY;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(float f16, float f17, @NotNull Bitmap bitmap) {
            super(bitmap);
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.hitTestX = f16;
            this.hitTestY = f17;
        }

        /* renamed from: a, reason: from getter */
        public final float getHitTestX() {
            return this.hitTestX;
        }

        /* renamed from: b, reason: from getter */
        public final float getHitTestY() {
            return this.hitTestY;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/KRView$c", "Landroid/view/View$OnTouchListener;", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "onTouch", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c implements View.OnTouchListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View.OnTouchListener f117792e;

        c(View.OnTouchListener onTouchListener) {
            this.f117792e = onTouchListener;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NotNull View v3, @NotNull MotionEvent event) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            KRView.this.currentActionState = event.getAction();
            KRView.this.H(event);
            View.OnTouchListener onTouchListener = this.f117792e;
            if (onTouchListener != null) {
                return onTouchListener.onTouch(v3, event);
            }
            return false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentActionState = -1;
        E();
    }

    private final void B(final MotionEvent event) {
        final KRCSSGestureListener kRCSSGestureListener;
        if (z()) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof View) {
                    View view = (View) parent;
                    if (KRCSSViewExtensionKt.n(view)) {
                        kRCSSGestureListener = KRCSSViewExtensionKt.q(view);
                        break;
                    }
                }
            }
        }
        kRCSSGestureListener = null;
        if (kRCSSGestureListener != null) {
            KRCSSGestureListener.x(kRCSSGestureListener, false, 1, null);
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                final ViewGroup viewGroup = (ViewGroup) parent2;
                final MotionEvent k3 = l01.b.k(this, event);
                l01.b.c(viewGroup, new Function1<View, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRView$setParentForcePinchGestureIfNeed$$inlined$also$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                        invoke2(view2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull View subView) {
                        Intrinsics.checkNotNullParameter(subView, "subView");
                        if (subView == this || !l01.b.e(k3.getX(), k3.getY(), subView, viewGroup)) {
                            return;
                        }
                        kRCSSGestureListener.C(subView);
                    }
                });
                k3.recycle();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.kuikly.core.render.android.expand.component.f] */
    private final void C(final Function1<Object, Unit> callback) {
        Choreographer v3;
        Function1<? super Long, Unit> function1 = this.screenFrameCallback;
        if (function1 != null && (v3 = v()) != null) {
            v3.removeFrameCallback(new g(function1));
        }
        if (callback != null) {
            this.screenFrameCallback = new Function1<Long, Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRView$setScreenFrameCallback$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
                
                    r2 = r1.this$0.v();
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.kuikly.core.render.android.expand.component.f] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(long j3) {
                    boolean z16;
                    Function1 function12;
                    Choreographer v16;
                    Function1 function13;
                    z16 = KRView.this.screenFramePause;
                    if (!z16) {
                        function12 = KRView.this.screenFrameCallback;
                        if (function12 != null && v16 != null) {
                            function13 = KRView.this.screenFrameCallback;
                            if (function13 != null) {
                                function13 = new f(function13);
                            }
                            v16.postFrameCallback((Choreographer.FrameCallback) function13);
                        }
                    }
                    callback.invoke(null);
                }
            };
            Choreographer v16 = v();
            if (v16 != null) {
                Function1<? super Long, Unit> function12 = this.screenFrameCallback;
                if (function12 != null) {
                    function12 = new f(function12);
                }
                v16.postFrameCallback((Choreographer.FrameCallback) function12);
                return;
            }
            return;
        }
        this.screenFrameCallback = null;
    }

    private final void D(Object propValue) {
        boolean areEqual = Intrinsics.areEqual(propValue, (Object) 1);
        if (areEqual != this.screenFramePause) {
            this.screenFramePause = areEqual;
            if (areEqual) {
                Function1<? super Long, Unit> function1 = this.screenFrameCallback;
                if (function1 != null) {
                    Choreographer.getInstance().removeFrameCallback(new g(function1));
                    return;
                }
                return;
            }
            Function1<? super Long, Unit> function12 = this.screenFrameCallback;
            if (function12 != null) {
                Choreographer.getInstance().postFrameCallback(new g(function12));
            }
        }
    }

    private final void E() {
        setWillNotDraw(false);
    }

    private final boolean F(MotionEvent motionEvent) {
        Function1<Object, Unit> function1 = this.touchDownCallback;
        if (function1 != null) {
            function1.invoke(w(motionEvent, "touchDown"));
            return true;
        }
        return false;
    }

    private final boolean G(MotionEvent motionEvent) {
        Function1<Object, Unit> function1 = this.touchMoveCallback;
        if (function1 != null) {
            function1.invoke(w(motionEvent, "touchMove"));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H(MotionEvent event) {
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                    return I(event, "touchCancel", true);
                }
                return G(event);
            }
            return J(this, event, "touchUp", false, 4, null);
        }
        B(event);
        return F(event);
    }

    private final boolean I(MotionEvent motionEvent, String eventName, boolean isCancel) {
        Map mutableMap;
        Function1<Object, Unit> function1 = this.touchUpCallback;
        if (function1 != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(w(motionEvent, eventName));
            mutableMap.put("cancel", Integer.valueOf(isCancel ? 1 : 0));
            function1.invoke(mutableMap);
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean J(KRView kRView, MotionEvent motionEvent, String str, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            return kRView.I(motionEvent, str, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryFireUpEvent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Choreographer v() {
        try {
            return Choreographer.getInstance();
        } catch (Throwable th5) {
            w.f392617a.b("KRView", "get Choreographer.getInstance exception:" + th5);
            return null;
        }
    }

    private final Map<String, Object> w(MotionEvent motionEvent, String eventName) {
        Map<String, Object> emptyMap;
        Object first;
        Map<String, Object> mutableMap;
        Map mapOf;
        emptyMap = MapsKt__MapsKt.emptyMap();
        ViewGroup A = A();
        if (A != null) {
            A.getLocationOnScreen(new int[2]);
            getLocationOnScreen(new int[2]);
            motionEvent.getX();
            motionEvent.getY();
            ArrayList arrayList = new ArrayList();
            int pointerCount = motionEvent.getPointerCount();
            for (int i3 = 0; i3 < pointerCount; i3++) {
                motionEvent.getPointerId(i3);
                float x16 = motionEvent.getX(i3);
                float y16 = motionEvent.getY(i3);
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(HippyTKDListViewAdapter.X, Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), x16))), TuplesKt.to("y", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), y16))), TuplesKt.to("pageX", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), (r2[0] - r3[0]) + x16))), TuplesKt.to("pageY", Float.valueOf(com.tencent.kuikly.core.render.android.css.ktx.b.x(get_kuiklyRenderContext(), (r2[1] - r3[1]) + y16))));
                arrayList.add(mapOf);
            }
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
            Map map = (Map) first;
            if (map == null) {
                map = MapsKt__MapsKt.emptyMap();
            }
            mutableMap = MapsKt__MapsKt.toMutableMap(map);
            mutableMap.put("touches", arrayList);
            mutableMap.put("action", eventName);
            return mutableMap;
        }
        return emptyMap;
    }

    private final boolean x() {
        Integer num = this.hitTestMode;
        if (num != null && num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    private final boolean y(MotionEvent event) {
        Bitmap bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
        float x16 = event.getX();
        float y16 = event.getY();
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        b bVar = new b(x16, y16, bitmap);
        bVar.translate(-event.getX(), -event.getY());
        draw(bVar);
        if (Color.alpha(bitmap.getPixel(0, 0)) < 1) {
            return true;
        }
        return false;
    }

    private final boolean z() {
        Integer num = this.hitTestMode;
        if (num != null && num.intValue() == 2) {
            return true;
        }
        return false;
    }

    @Nullable
    public ViewGroup A() {
        return c.a.h(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1652093432:
                if (propKey.equals("hitTestMode")) {
                    this.hitTestMode = (Integer) propValue;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1651924047:
                if (propKey.equals("hitTestSelf")) {
                    this.hitTestSelfCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1134815686:
                if (propKey.equals("touchUp")) {
                    this.touchUpCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -66233247:
                if (propKey.equals("screenFrame")) {
                    if (!TypeIntrinsics.isFunctionOfArity(propValue, 1)) {
                        propValue = null;
                    }
                    C((Function1) propValue);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 363315329:
                if (propKey.equals("touchDown")) {
                    this.touchDownCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 363583408:
                if (propKey.equals("touchMove")) {
                    this.touchMoveCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 738684437:
                if (propKey.equals("screenFramePause")) {
                    D(propValue);
                    return true;
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        Function1<Object, Unit> function1;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (!isEnabled()) {
            return false;
        }
        if (x() && ev5.getAction() == 0 && y(ev5)) {
            return false;
        }
        if (ev5.getAction() == 0 && (function1 = this.hitTestSelfCallback) != null && function1 != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            function1.invoke(emptyMap);
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        KRCSSViewExtensionKt.g(this, canvas);
        super.draw(canvas);
        KRCSSViewExtensionKt.h(this, canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean drawChild(@NotNull Canvas canvas, @NotNull View child, long drawingTime) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(child, "child");
        if (canvas instanceof b) {
            Rect rect = new Rect();
            child.getHitRect(rect);
            b bVar = (b) canvas;
            if (!rect.contains((int) bVar.getHitTestX(), (int) bVar.getHitTestY())) {
                return true;
            }
        }
        return super.drawChild(canvas, child, drawingTime);
    }

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

    @UiThread
    public void h() {
        c.a.n(this);
    }

    /* renamed from: k */
    public boolean getReusable() {
        return true;
    }

    public void n(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        c.a.i(this, parent);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    public void onDestroy() {
        c.a.k(this);
        C(null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(@NotNull View target, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(target, "target");
        ViewGroup viewGroup = this.nestedScrollDelegate;
        if (viewGroup != null) {
            return viewGroup.onNestedPreFling(target, velocityX, velocityY);
        }
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        ViewGroup viewGroup = this.nestedScrollDelegate;
        if (viewGroup != null) {
            viewGroup.onNestedPreScroll(target, dx5, dy5, consumed);
        } else {
            super.onNestedPreScroll(target, dx5, dy5, consumed);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int nestedScrollAxes) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (this.nestedScrollDelegate != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onTouchEvent = super.onTouchEvent(event);
        this.currentActionState = event.getAction();
        boolean H = H(event);
        if (!onTouchEvent && !H) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0013. Please report as an issue. */
    @Override // i01.c
    public boolean s(@NotNull String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        this.nestedScrollDelegate = null;
        this.touchListenerProxy = null;
        this.currentActionState = -1;
        switch (propKey.hashCode()) {
            case -1652093432:
                if (propKey.equals("hitTestMode")) {
                    this.hitTestMode = null;
                    return true;
                }
                return c.a.m(this, propKey);
            case -1651924047:
                if (propKey.equals("hitTestSelf")) {
                    this.hitTestSelfCallback = null;
                    return true;
                }
                return c.a.m(this, propKey);
            case -1134815686:
                if (propKey.equals("touchUp")) {
                    this.touchUpCallback = null;
                    return true;
                }
                return c.a.m(this, propKey);
            case -66233247:
                if (propKey.equals("screenFrame")) {
                    C(null);
                    return true;
                }
                return c.a.m(this, propKey);
            case 363315329:
                if (propKey.equals("touchDown")) {
                    this.touchDownCallback = null;
                    return true;
                }
                return c.a.m(this, propKey);
            case 363583408:
                if (propKey.equals("touchMove")) {
                    this.touchMoveCallback = null;
                    return true;
                }
                return c.a.m(this, propKey);
            case 738684437:
                if (propKey.equals("screenFramePause")) {
                    this.screenFramePause = false;
                    return true;
                }
                return c.a.m(this, propKey);
            default:
                return c.a.m(this, propKey);
        }
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    public final void setNestedScrollDelegate(@Nullable ViewGroup viewGroup) {
        this.nestedScrollDelegate = viewGroup;
    }

    @Override // android.view.View
    public void setOnTouchListener(@Nullable View.OnTouchListener l3) {
        c cVar = new c(l3);
        this.touchListenerProxy = cVar;
        super.setOnTouchListener(cVar);
    }

    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    @Nullable
    public Object call(@NotNull String method, @Nullable String str, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(method, "method");
        return c.a.b(this, method, str, function1);
    }
}
