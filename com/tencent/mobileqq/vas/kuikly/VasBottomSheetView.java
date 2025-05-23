package com.tencent.mobileqq.vas.kuikly;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.UiThread;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\rB\u000f\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016JI\u0010\u0016\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2+\u0010\u0015\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u0014H\u0016J\"\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010-\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010 R\u0016\u0010/\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010(R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R;\u00105\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R;\u00107\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R;\u00109\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R;\u0010;\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R;\u0010=\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010j\u0004\u0018\u0001`\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasBottomSheetView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Li01/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "g0", "Landroid/graphics/Bitmap;", "f0", "", "propKey", "", "propValue", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "s0", UserInfo.SEX_FEMALE, "mDefaultHeight", "t0", "mMaxHeight", "u0", "mMinHeight", "", "v0", "I", "initState", "w0", "mHeight", "x0", "mWidth", "y0", "mShowMode", "z0", "Ljava/lang/String;", "mContentColor", "A0", "Lkotlin/jvm/functions/Function1;", "callOnDismissCallback", "B0", "callOnDismissStartCallback", "C0", "callOnDefaultShowEventCallback", "D0", "callOnMinShowEventCallback", "E0", "callOnTotalShowEventCallback", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "F0", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "mKuiklyRenderView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "G0", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasBottomSheetView extends QUSHalfScreenFloatingView implements i01.c, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: A0, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnDismissCallback;

    /* renamed from: B0, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnDismissStartCallback;

    /* renamed from: C0, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnDefaultShowEventCallback;

    /* renamed from: D0, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnMinShowEventCallback;

    /* renamed from: E0, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnTotalShowEventCallback;

    /* renamed from: F0, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g mKuiklyRenderView;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private float mDefaultHeight;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private float mMaxHeight;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private float mMinHeight;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private int initState;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private float mHeight;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private float mWidth;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private int mShowMode;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mContentColor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasBottomSheetView$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", NodeProps.MAX_HEIGHT, NodeProps.MIN_HEIGHT, "defaultHeight", "initState", "showMode", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        public View createContentView() {
            Object obj = VasBottomSheetView.this.mKuiklyRenderView;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            return (View) obj;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            return (int) com.tencent.kuikly.core.render.android.css.ktx.b.I(VasBottomSheetView.this.get_kuiklyRenderContext(), VasBottomSheetView.this.mDefaultHeight);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return VasBottomSheetView.this.initState;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return (int) com.tencent.kuikly.core.render.android.css.ktx.b.I(VasBottomSheetView.this.get_kuiklyRenderContext(), VasBottomSheetView.this.mMaxHeight);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            return (int) com.tencent.kuikly.core.render.android.css.ktx.b.I(VasBottomSheetView.this.get_kuiklyRenderContext(), VasBottomSheetView.this.mMinHeight);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return VasBottomSheetView.this.mShowMode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasBottomSheetView$d", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d implements com.tencent.kuikly.core.render.android.c {
        d() {
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            VasBottomSheetView.this.mKuiklyRenderView.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasBottomSheetView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mDefaultHeight = 36.0f;
        this.mMaxHeight = 36.0f;
        this.mMinHeight = 36.0f;
        this.initState = 2;
        this.mShowMode = 1;
        this.mContentColor = "";
        this.mKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(context, this);
        setOnDismissStartListener(new QUSBaseHalfScreenFloatingView.m() { // from class: com.tencent.mobileqq.vas.kuikly.i
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.m
            public final void a() {
                VasBottomSheetView.U(VasBottomSheetView.this);
            }
        });
        setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.vas.kuikly.j
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                VasBottomSheetView.V(VasBottomSheetView.this);
            }
        });
        j(new a());
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(VasBottomSheetView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnDismissStartCallback;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(VasBottomSheetView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnDismissCallback;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    private final Bitmap f0() {
        try {
            if (TextUtils.isEmpty(this.mContentColor)) {
                return null;
            }
            int parseColor = Color.parseColor(this.mContentColor);
            int screenWidth = ViewUtils.getScreenWidth();
            int screenHeight = ViewUtils.getScreenHeight() / 2;
            Bitmap createBitmap = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            float a16 = com.tencent.qqnt.base.utils.c.f353052a.a(8.0f);
            Paint paint = new Paint();
            paint.setColor(parseColor);
            paint.setAntiAlias(true);
            float f16 = screenWidth;
            float f17 = screenHeight;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            float f18 = 2 * a16;
            float f19 = f18 + 0.0f;
            path.arcTo(new RectF(0.0f, 0.0f, f19, f19), 180.0f, 90.0f);
            path.lineTo(f16 - a16, 0.0f);
            path.arcTo(new RectF(f16 - f18, 0.0f, f16, f19), -90.0f, 90.0f);
            path.lineTo(f16, f17);
            path.lineTo(0.0f, f17);
            path.close();
            canvas.drawPath(path, paint);
            return createBitmap;
        } catch (Exception e16) {
            QLog.e("VasBottomSheetView", 1, "createBg Error " + e16);
            return null;
        }
    }

    private final void g0() {
        Bitmap f06;
        ViewGroup viewGroup = this.P;
        if (viewGroup != null && (f06 = f0()) != null) {
            viewGroup.setBackground(new BitmapDrawable(f06));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0014. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        int i3 = 0;
        switch (propKey.hashCode()) {
            case -2092909433:
                if (propKey.equals("ignoreHorizontalMove")) {
                    setIgnoreHorizontalMove(((Boolean) propValue).booleanValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1944411352:
                if (propKey.equals("onShowTotal")) {
                    this.callOnTotalShowEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1906134153:
                if (propKey.equals("onDismissStart")) {
                    this.callOnDismissStartCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1882901211:
                if (propKey.equals("onShowDefault")) {
                    this.callOnDefaultShowEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1349701436:
                if (propKey.equals("themeId")) {
                    setThemeId(((Integer) propValue).intValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1287015509:
                if (propKey.equals("onDismiss")) {
                    this.callOnDismissCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1081777049:
                if (propKey.equals("setContentBgColor")) {
                    try {
                        this.mContentColor = (String) propValue;
                    } catch (Exception unused) {
                        QLog.e("VasBottomSheetView", 1, "parse to Int err");
                    }
                    g0();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -906066005:
                if (propKey.equals(NodeProps.MAX_HEIGHT)) {
                    this.mMaxHeight = ((Float) propValue).floatValue() + 36.0f;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -891414730:
                if (propKey.equals("onShowMin")) {
                    this.callOnMinShowEventCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -378432203:
                if (propKey.equals("enableMaskAnimation")) {
                    v(((Boolean) propValue).booleanValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -339033536:
                if (propKey.equals("showMode")) {
                    if (((Integer) propValue).intValue() != 0) {
                        i3 = 1;
                    }
                    this.mShowMode = i3;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -304480883:
                if (propKey.equals("draggable")) {
                    setDraggable(((Boolean) propValue).booleanValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -268756639:
                if (propKey.equals("initState")) {
                    int intValue = ((Integer) propValue).intValue();
                    if (intValue != 0) {
                        if (intValue != 1) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                    }
                    this.initState = i3;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -133587431:
                if (propKey.equals(NodeProps.MIN_HEIGHT)) {
                    this.mMinHeight = ((Float) propValue).floatValue() + 36.0f;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -115612003:
                if (propKey.equals("outSideTouchEnable")) {
                    setOutSideTouchEnable(((Boolean) propValue).booleanValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 310413598:
                if (propKey.equals("isHeightWrapContent")) {
                    setIsHeightWrapContent(((Boolean) propValue).booleanValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 644734664:
                if (propKey.equals("defaultHeight")) {
                    this.mDefaultHeight = ((Float) propValue).floatValue() + 36.0f;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 859271610:
                if (propKey.equals("pageName")) {
                    this.mKuiklyRenderView.d((String) propValue, new Size((int) com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), this.mWidth), (int) com.tencent.kuikly.core.render.android.css.ktx.b.I(get_kuiklyRenderContext(), this.mHeight)));
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 876158071:
                if (propKey.equals("pageWidth")) {
                    this.mWidth = ((Float) propValue).floatValue();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 958101654:
                if (propKey.equals("pageHeight")) {
                    this.mHeight = ((Float) propValue).floatValue();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1814421780:
                if (propKey.equals("contentDraggable")) {
                    setIsContentDraggable(!((Boolean) propValue).booleanValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
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

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        this.mKuiklyRenderView.onDetach();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        com.tencent.kuikly.core.render.android.d O0;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null) {
            O0.g(new d());
        }
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1354815177:
                if (method.equals("commit")) {
                    setQUSDragFloatController(new c());
                    return Unit.INSTANCE;
                }
                break;
            case -774901860:
                if (method.equals("showMinHeight")) {
                    O(0);
                    return Unit.INSTANCE;
                }
                break;
            case 702133963:
                if (method.equals("showDefaultHeight")) {
                    N(0);
                    return Unit.INSTANCE;
                }
                break;
            case 1107546702:
                if (method.equals("showTotalHeight")) {
                    P(0);
                    return Unit.INSTANCE;
                }
                break;
            case 2062841588:
                if (method.equals("dismissWithAnimation")) {
                    t();
                    return Unit.INSTANCE;
                }
                break;
        }
        return c.a.b(this, method, params, callback);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/VasBottomSheetView$a", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$p;", "", "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "onShowMinStart", "onShowMin", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements QUSBaseHalfScreenFloatingView.p {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
            Function1 function1 = VasBottomSheetView.this.callOnDefaultShowEventCallback;
            if (function1 != null) {
                function1.invoke(null);
            }
            QLog.i("VasBottomSheetView", 1, "onShowDefault action");
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
            Function1 function1 = VasBottomSheetView.this.callOnMinShowEventCallback;
            if (function1 != null) {
                function1.invoke(null);
            }
            QLog.i("VasBottomSheetView", 1, "onShowMin action");
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            Function1 function1 = VasBottomSheetView.this.callOnTotalShowEventCallback;
            if (function1 != null) {
                function1.invoke(null);
            }
            QLog.i("VasBottomSheetView", 1, "onShowTotal action");
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
        }
    }
}
