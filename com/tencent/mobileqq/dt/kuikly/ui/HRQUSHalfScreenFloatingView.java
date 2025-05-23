package com.tencent.mobileqq.dt.kuikly.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.dt.kuikly.ui.HRQUSHalfScreenFloatingView;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyFactory;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.UpdateType;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import i01.b;
import i01.c;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0014B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J0\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0014J\b\u0010!\u001a\u00020\u0004H\u0016R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010#R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u00105\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010(\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010;\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010#\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/dt/kuikly/ui/HRQUSHalfScreenFloatingView;", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "Li01/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "", "B", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "D", "", "enable", "setEnableDefault", "", "propKey", "", "propValue", "b", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "changed", "left", "top", "right", "bottom", "onLayout", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "s0", "I", "mDefaultHeight", "t0", "mMaxHeight", "u0", "Ljava/lang/String;", "mPostData", "v0", "mInitState", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "w0", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "mKuiklyRenderView", "x0", "getMCallbackId", "()Ljava/lang/String;", "setMCallbackId", "(Ljava/lang/String;)V", "mCallbackId", "y0", "getMReportStatus", "()I", "setMReportStatus", "(I)V", "mReportStatus", "<init>", "(Landroid/content/Context;)V", "z0", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class HRQUSHalfScreenFloatingView extends QUSHalfScreenFloatingView implements i01.c, h {

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private int mDefaultHeight;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private int mMaxHeight;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mPostData;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private int mInitState;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mKuiklyRenderView;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCallbackId;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private int mReportStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/dt/kuikly/ui/HRQUSHalfScreenFloatingView$c", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements com.tencent.kuikly.core.render.android.c {
        c() {
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            HRQUSHalfScreenFloatingView.this.mKuiklyRenderView.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/dt/kuikly/ui/HRQUSHalfScreenFloatingView$d", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", NodeProps.MAX_HEIGHT, NodeProps.MIN_HEIGHT, "defaultHeight", "initState", "showMode", "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class d extends e {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF58528d() {
            Object obj = HRQUSHalfScreenFloatingView.this.mKuiklyRenderView;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            return (View) obj;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int defaultHeight() {
            return (int) Utils.o(HRQUSHalfScreenFloatingView.this.mDefaultHeight, HRQUSHalfScreenFloatingView.this.getContext().getResources());
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int initState() {
            return HRQUSHalfScreenFloatingView.this.mInitState;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return HRQUSHalfScreenFloatingView.this.mMaxHeight;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HRQUSHalfScreenFloatingView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPostData = "";
        this.mInitState = 2;
        this.mCallbackId = "";
        setId(R.id.yak);
        this.mKuiklyRenderView = ((IQQKuiklyFactory) QRoute.api(IQQKuiklyFactory.class)).createKuiklyRenderView(context, this);
        setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: hb1.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                HRQUSHalfScreenFloatingView.U(HRQUSHalfScreenFloatingView.this);
            }
        });
        setOnOutsideClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(HRQUSHalfScreenFloatingView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(HRQUSHalfScreenFloatingView this$0, Object propValue, KuiklyLaunchParams params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(propValue, "$propValue");
        Intrinsics.checkNotNullParameter(params, "$params");
        QLog.i("HRQUSHalfScreenFloatingView", 1, "expectMaxH " + this$0.mMaxHeight + " containerH " + this$0.f317218i + " minMarginTop " + this$0.f317216h);
        if (this$0.mMaxHeight > this$0.f317218i - this$0.f317216h) {
            QLog.i("HRQUSHalfScreenFloatingView", 1, "change expectMaxH");
            this$0.mMaxHeight = this$0.f317218i - this$0.f317216h;
        }
        g gVar = this$0.mKuiklyRenderView;
        String str = (String) propValue;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Bundle bundle = params.toBundle();
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "bundle.keySet()");
        for (String it : keySet) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object obj = bundle.get(it);
            if (obj == null) {
                obj = "";
            }
            Intrinsics.checkNotNullExpressionValue(obj, "bundle.get(it) ?: \"\"");
            linkedHashMap.put(it, obj);
        }
        Unit unit = Unit.INSTANCE;
        gVar.b(str, linkedHashMap, new Size(-1, this$0.mMaxHeight));
    }

    @Override // com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView, com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    protected void B() {
        this.P = new FrameLayout(getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView
    public void D(@NotNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.D(context, attrs, defStyleAttr);
        setContentViewBackgroundResource(R.color.qui_common_bg_top_light);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull final Object propValue) {
        Intent intent;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -906066005:
                if (propKey.equals(NodeProps.MAX_HEIGHT)) {
                    this.mMaxHeight = (int) Utils.o(((Integer) propValue).intValue(), getContext().getResources());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -268756639:
                if (propKey.equals("initState")) {
                    if (((Integer) propValue).intValue() != 0) {
                        return true;
                    }
                    this.mInitState = 1;
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 644734664:
                if (propKey.equals("defaultHeight")) {
                    this.mDefaultHeight = ((Integer) propValue).intValue();
                    setQUSDragFloatController(new d());
                    ViewGroup viewGroup = this.P;
                    Object obj = this.mKuiklyRenderView;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                    viewGroup.removeView((View) obj);
                    ViewGroup viewGroup2 = this.P;
                    Object obj2 = this.mKuiklyRenderView;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.view.View");
                    viewGroup2.addView((View) obj2, 0);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 756526186:
                if (propKey.equals("postData")) {
                    this.mPostData = (String) propValue;
                    Activity activity = getActivity();
                    if (activity == null || (intent = activity.getIntent()) == null) {
                        return true;
                    }
                    intent.putExtra("safePostData", this.mPostData);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 859271610:
                if (propKey.equals("pageName")) {
                    final KuiklyLaunchParams kuiklyLaunchParams = new KuiklyLaunchParams();
                    kuiklyLaunchParams.getExtMap().put("jubaoModel", this.mPostData);
                    kuiklyLaunchParams.setResId("o3");
                    kuiklyLaunchParams.setUpdateType(UpdateType.TYPE_USE_LOCAL_PRIORITY);
                    post(new Runnable() { // from class: hb1.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            HRQUSHalfScreenFloatingView.Z(HRQUSHalfScreenFloatingView.this, propValue, kuiklyLaunchParams);
                        }
                    });
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
        com.tencent.mobileqq.dt.report.c.c(this.mCallbackId, this.mReportStatus);
        com.tencent.mobileqq.dt.report.c.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        if (this.f317218i != getMeasuredHeight()) {
            L();
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, @Nullable ErrorReason errorReason, @NotNull KuiklyRenderCoreExecuteMode executeMode) {
        com.tencent.kuikly.core.render.android.d O0;
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null) {
            O0.g(new c());
        }
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    public final void setEnableDefault(boolean enable) {
        this.f317210d0 = enable;
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    public final void setMCallbackId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mCallbackId = str;
    }

    public final void setMReportStatus(int i3) {
        this.mReportStatus = i3;
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull b bVar) {
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
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/dt/kuikly/ui/HRQUSHalfScreenFloatingView$a", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "qq-devicetoken-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class a implements QUSBaseHalfScreenFloatingView.o {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(@Nullable View v3) {
            HRQUSHalfScreenFloatingView.this.t();
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
        }
    }
}
