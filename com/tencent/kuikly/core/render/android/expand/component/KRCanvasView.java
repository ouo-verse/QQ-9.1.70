package com.tencent.kuikly.core.render.android.expand.component;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.kuikly.core.render.android.expand.module.j;
import com.tencent.kuikly.core.render.android.scheduler.KRSubThreadScheduler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001BB\u000f\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0016\u0010\u001f\u001a\u00020\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dH\u0002JI\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010 \u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\t2+\u0010&\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010!j\u0004\u0018\u0001`%H\u0016J\u0012\u0010)\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010,\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0003H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0014R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u001cR\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u0017R\u0016\u0010:\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u0017R\u0016\u0010<\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u0017\u00a8\u0006C"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRCanvasView;", "Landroid/widget/ImageView;", "Li01/c;", "", "params", "", "b0", "", "U", "", "X", "Y", "a0", "W", "H", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "G", "J", "P", "N", "K", "T", "I", "V", BdhLogUtil.LogTag.Tag_Req, "c0", "O", "Z", "Lkotlin/Function0;", "task", UserInfo.SEX_FEMALE, "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Landroid/view/ViewGroup$LayoutParams;", "setLayoutParams", "propKey", "propValue", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Lcom/tencent/kuikly/core/render/android/expand/component/RenderingController;", "d", "Lcom/tencent/kuikly/core/render/android/expand/component/RenderingController;", "renderingController", "e", "needDrawCanvas", "", "f", "drawCancelFlag", tl.h.F, "lastWidth", "i", "lastHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "D", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class KRCanvasView extends ImageView implements i01.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final RenderingController renderingController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needDrawCanvas;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile int drawCancelFlag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastHeight;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final PorterDuffXfermode f117737m = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);

    @NotNull
    private static final PorterDuffXfermode C = new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000bR\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000bR\u0014\u0010\u001b\u001a\u00020\t8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000bR\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000bR\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000bR\u0014\u0010\u001e\u001a\u00020\t8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000bR\u0014\u0010\u001f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000bR\u0014\u0010 \u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u000bR\u0014\u0010!\u001a\u00020\t8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b!\u0010\u000bR\u0014\u0010#\u001a\u00020\"8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u000bR\u0014\u0010&\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u000bR\u0014\u0010'\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u000b\u00a8\u0006*"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/KRCanvasView$a;", "", "Landroid/graphics/PorterDuffXfermode;", "BLEND_MODE_CLEAR", "Landroid/graphics/PorterDuffXfermode;", "a", "()Landroid/graphics/PorterDuffXfermode;", "BLEND_MODE_OVER", "b", "", "ARC", "Ljava/lang/String;", "BEGIN_PATH", "BEZIER_CURVE_TO", "CLOSE_PATH", "COUNTER_CLOCKWISE", "CREATE_LINEAR_GRADIENT", "DRAW_IMAGE", "END_ANGLE", "FILL", "FILL_STYLE", "LINE_CAP", "LINE_TO", "LINE_WIDTH", "MARK_UNDO_INDEX", "MOVE_TO", "QUADRATIC_CURVE_TO", "RADIUS", "RESET", "SET_CLEAR_BLEND_MODE", "START_ANGLE", "STROKE", "STROKE_STYLE", "STYLE", "", "TYPE_COUNTER_CLOCKWISE", "I", "UNDO_ENABLE", "UNDO_TO_INDEX", "VIEW_NAME", "<init>", "()V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.KRCanvasView$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        Companion() {
        }

        @NotNull
        public final PorterDuffXfermode a() {
            return KRCanvasView.f117737m;
        }

        @NotNull
        public final PorterDuffXfermode b() {
            return KRCanvasView.C;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KRCanvasView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.renderingController = new RenderingController(new Function0<com.tencent.kuikly.core.render.android.a>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRCanvasView$renderingController$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.kuikly.core.render.android.a invoke() {
                return KRCanvasView.this.get_kuiklyRenderContext();
            }
        });
        this.lastWidth = -1;
        this.lastHeight = -1;
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private final void F(Function0<Unit> task) {
        if (this.renderingController.getIsDiffPatchDrawMode()) {
            KRSubThreadScheduler.f118174c.e(task);
        } else {
            task.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(String params) {
        this.renderingController.r(params, get_kuiklyRenderContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        this.renderingController.s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String params) {
        this.renderingController.t(params, get_kuiklyRenderContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        this.renderingController.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        this.renderingController.y();
    }

    private final void O(String params) {
        j jVar;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (jVar = (j) aVar.a("KRMemoryCacheModule")) != null) {
            JSONObject k06 = KRCSSViewExtensionKt.k0(params);
            String base64ImageKey = k06.optString("image");
            float I = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble(HippyTKDListViewAdapter.X));
            float I2 = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble("y"));
            float I3 = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble("width"));
            float I4 = com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), (float) k06.optDouble("height"));
            Intrinsics.checkNotNullExpressionValue(base64ImageKey, "base64ImageKey");
            F(new KRCanvasView$drawImage$1(this, jVar.g(base64ImageKey), jVar, base64ImageKey, I, I2, I3, I4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        this.renderingController.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String params) {
        this.renderingController.J(params, get_kuiklyRenderContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(String params) {
        this.renderingController.K(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(String params) {
        this.renderingController.L(params, get_kuiklyRenderContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(String params) {
        this.renderingController.N(params, get_kuiklyRenderContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U() {
        this.renderingController.O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(String params) {
        this.renderingController.P(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(String params) {
        this.renderingController.Q(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(String params) {
        this.renderingController.R(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(String params) {
        this.renderingController.T(params, get_kuiklyRenderContext());
    }

    private final void Z() {
        if (!this.needDrawCanvas) {
            this.needDrawCanvas = true;
            post(new KRCanvasView$setNeedDrawCanvas$1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(String params) {
        this.renderingController.U(params);
    }

    private final boolean b0(Object params) {
        this.renderingController.X(params);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String params) {
        this.renderingController.Y(params);
    }

    public void L(int i3, int i16, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        c.a.c(this, i3, i16, canvas);
    }

    public void M(int i3, int i16, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        c.a.d(this, i3, i16, canvas);
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (propKey.hashCode() == 1522249607 && propKey.equals("undoEnable")) {
            return b0(propValue);
        }
        return c.a.p(this, propKey, propValue);
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
    public boolean k() {
        return c.a.g(this);
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
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        L(getWidth(), getHeight(), canvas);
        super.onDraw(canvas);
        M(getWidth(), getHeight(), canvas);
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

    @Override // android.view.View
    public void setLayoutParams(@Nullable ViewGroup.LayoutParams params) {
        int i3;
        int i16;
        int i17;
        super.setLayoutParams(params);
        if (params != null) {
            int i18 = this.lastWidth;
            if (i18 != -1 && (i3 = this.lastHeight) != -1 && i18 != (i16 = params.width) && i3 != (i17 = params.height) && i16 > 0 && i17 > 0) {
                Z();
            }
            this.lastWidth = params.width;
            this.lastHeight = params.height;
        }
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        c.a.q(this, shadow);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull final String method, @Nullable final String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, CanvasView.ACTION_DRAWIMAGE)) {
            O(params);
        } else {
            F(new Function0<Unit>() { // from class: com.tencent.kuikly.core.render.android.expand.component.KRCanvasView$call$task$1
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
                    String str = method;
                    switch (str.hashCode()) {
                        case -1904667246:
                            if (str.equals(CanvasView.ACTION_QUADRATIC_CURVETO)) {
                                KRCanvasView.this.T(params);
                                return;
                            }
                            return;
                        case -1803786702:
                            if (str.equals("lineWidth")) {
                                KRCanvasView.this.Y(params);
                                return;
                            }
                            return;
                        case -1746918711:
                            if (str.equals("setClearBlendMode")) {
                                KRCanvasView.this.V(params);
                                return;
                            }
                            return;
                        case -1126944274:
                            if (str.equals("fillStyle")) {
                                KRCanvasView.this.W(params);
                                return;
                            }
                            return;
                        case -1102672497:
                            if (str.equals(CanvasView.ACTION_LINETO)) {
                                KRCanvasView.this.Q(params);
                                return;
                            }
                            return;
                        case -1072966546:
                            if (str.equals("beginPath")) {
                                KRCanvasView.this.H();
                                return;
                            }
                            return;
                        case -1068263892:
                            if (str.equals(CanvasView.ACTION_MOVETO)) {
                                KRCanvasView.this.S(params);
                                return;
                            }
                            return;
                        case -891980232:
                            if (str.equals("stroke")) {
                                KRCanvasView.this.P();
                                return;
                            }
                            return;
                        case -482608579:
                            if (str.equals(CanvasView.ACTION_CLOSEPATH)) {
                                KRCanvasView.this.J();
                                return;
                            }
                            return;
                        case -435733525:
                            if (str.equals(CanvasView.ACTION_QBEZIER_CURVETO)) {
                                KRCanvasView.this.I(params);
                                return;
                            }
                            return;
                        case 96850:
                            if (str.equals(CanvasView.ACTION_ARC)) {
                                KRCanvasView.this.G(params);
                                return;
                            }
                            return;
                        case 3143043:
                            if (str.equals(CanvasView.CUSTOM_ACTION_FILL)) {
                                KRCanvasView.this.N();
                                return;
                            }
                            return;
                        case 108404047:
                            if (str.equals("reset")) {
                                KRCanvasView.this.U();
                                return;
                            }
                            return;
                        case 176874302:
                            if (str.equals("lineCap")) {
                                KRCanvasView.this.X(params);
                                return;
                            }
                            return;
                        case 379565459:
                            if (str.equals("undoToIndex")) {
                                KRCanvasView.this.c0(params);
                                return;
                            }
                            return;
                        case 699317761:
                            if (str.equals("markUndoIndex")) {
                                KRCanvasView.this.R(params);
                                return;
                            }
                            return;
                        case 1920719449:
                            if (str.equals("strokeStyle")) {
                                KRCanvasView.this.a0(params);
                                return;
                            }
                            return;
                        case 2125396369:
                            if (str.equals("createLinearGradient")) {
                                KRCanvasView.this.K(params);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        Z();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(String params) {
    }
}
