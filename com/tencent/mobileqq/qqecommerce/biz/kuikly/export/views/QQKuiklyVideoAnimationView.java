package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.vpng.view.VPNGImageView;
import com.tencent.qphone.base.util.QLog;
import cooperation.liveroom.LiveRoomGiftCallback;
import i01.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001-B\u000f\u0012\u0006\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016JI\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052+\u0010\u0014\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\u0004\u0018\u0001`\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0012H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR;\u0010#\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000ej\u0004\u0018\u0001`\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQKuiklyVideoAnimationView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "intType", "", "c", "propKey", "", "propValue", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "videoPath", "isLoop", "i", "g", "j", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "d", "Lcom/tencent/mobileqq/vpng/view/VPNGImageView;", "mVPNGImageView", "e", "Lkotlin/jvm/functions/Function1;", "mKuiklyCallback", "Lcooperation/liveroom/LiveRoomGiftCallback;", "f", "Lcooperation/liveroom/LiveRoomGiftCallback;", "mCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", tl.h.F, "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyVideoAnimationView extends FrameLayout implements i01.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private VPNGImageView mVPNGImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> mKuiklyCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LiveRoomGiftCallback mCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyVideoAnimationView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mVPNGImageView = new VPNGImageView(context);
        this.mCallback = new LiveRoomGiftCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views.i
            @Override // cooperation.liveroom.LiveRoomGiftCallback
            public final void onCall(int i3, String str) {
                QQKuiklyVideoAnimationView.d(QQKuiklyVideoAnimationView.this, i3, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QQKuiklyVideoAnimationView this$0, int i3, String str) {
        Function1<Object, Unit> function1;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String c16 = this$0.c(i3);
        if (c16 == null || (function1 = this$0.mKuiklyCallback) == null) {
            return;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("state", c16));
        function1.invoke(mapOf);
    }

    @Override // i01.c
    public boolean b(String propKey, Object propValue) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "onStateChange")) {
            Function1<Object, Unit> function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
            this.mKuiklyCallback = function1;
            if (function1 == null) {
                return true;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("state", "onReady"));
            function1.invoke(mapOf);
            return true;
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    public Object call(String str, Object obj, Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    public void h() {
        c.a.n(this);
    }

    public final void i(String videoPath, boolean isLoop) {
        QLog.d("QQKuiklyVideoAnimationView", 1, "playVideo videoPath" + videoPath + ",isLoop:" + isLoop);
        if (this.mVPNGImageView.getParent() == null) {
            addView(this.mVPNGImageView, new ViewGroup.LayoutParams(-1, -1));
            this.mVPNGImageView.setRenderWidth(getMeasuredWidth());
            this.mVPNGImageView.setRenderHeight(getMeasuredHeight());
        }
        this.mVPNGImageView.setVideo(videoPath, isLoop, 0, this.mCallback);
        this.mVPNGImageView.onResume();
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
        QLog.d("QQKuiklyVideoAnimationView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        l();
    }

    @Override // i01.c
    public boolean s(String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    public void setShadow(i01.b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -1886160473:
                if (method.equals("playVideo") && params != null) {
                    JSONObject jSONObject = new JSONObject(params);
                    i(jSONObject.optString("url"), jSONObject.optBoolean("isLoop"));
                    break;
                }
                break;
            case -934426579:
                if (method.equals("resume")) {
                    j();
                    break;
                }
                break;
            case 3540994:
                if (method.equals("stop")) {
                    l();
                    break;
                }
                break;
            case 106440182:
                if (method.equals("pause")) {
                    g();
                    break;
                }
                break;
        }
        return c.a.b(this, method, params, callback);
    }

    public final void g() {
        QLog.d("QQKuiklyVideoAnimationView", 1, "pause");
        this.mVPNGImageView.onPause();
    }

    public final void j() {
        QLog.d("QQKuiklyVideoAnimationView", 1, "resume");
        this.mVPNGImageView.onResume();
    }

    public final void l() {
        QLog.d("QQKuiklyVideoAnimationView", 1, "stop");
        this.mVPNGImageView.onRelease();
    }

    private final String c(int intType) {
        if (intType == 2) {
            return "onError";
        }
        if (intType == 4) {
            return "onStart";
        }
        if (intType != 7) {
            return null;
        }
        return "onEnd";
    }
}
