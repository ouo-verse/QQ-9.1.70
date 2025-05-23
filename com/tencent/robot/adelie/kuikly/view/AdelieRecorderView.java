package com.tencent.robot.adelie.kuikly.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.kuikly.core.render.android.j;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.kuikly.module.AdelieTtsRecordParam;
import com.tencent.robot.adelie.kuikly.module.KuiklyRenderCallbackData;
import com.tencent.robot.adelie.kuikly.module.p;
import com.tencent.robot.adelie.kuikly.view.record.AdelieAudioContainerView;
import com.tencent.robot.adelie.kuikly.view.record.d;
import com.tencent.robot.adelie.kuikly.view.record.f;
import i01.b;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u0001 B\u000f\u0012\u0006\u00101\u001a\u000200\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J?\u0010\u0011\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J?\u0010\u0012\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J5\u0010\u0013\u001a\u00020\u000e2+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J?\u0010\u0014\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J5\u0010\u0015\u001a\u00020\u000e2+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0002J=\u0010\u0017\u001a\u00020\u000e*'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016JI\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2+\u0010\u0010\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000fH\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\bH\u0016JC\u0010#\u001a\u00020\u000e*'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000f2\u0006\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\bR\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%RC\u0010*\u001a/\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000f\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)RC\u0010,\u001a/\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\nj\u0004\u0018\u0001`\u000f\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010/\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/AdelieRecorderView;", "Landroid/widget/FrameLayout;", "Li01/c;", "Lcom/tencent/robot/adelie/kuikly/view/record/f;", "", "propValue", "", "o", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "p", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "data", "d", "propKey", "b", "method", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "errCode", "errMsg", "a", "success", "errorMsg", "g", "Lcom/tencent/robot/adelie/kuikly/view/record/AdelieAudioContainerView;", "Lcom/tencent/robot/adelie/kuikly/view/record/AdelieAudioContainerView;", "audioView", "Lmqq/util/WeakReference;", "e", "Lmqq/util/WeakReference;", "weakKuiklyCallback", "f", "weakRecordErrorCallback", h.F, "I", "recordState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieRecorderView extends FrameLayout implements c, f {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdelieAudioContainerView audioView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Function1<Object, Unit>> weakKuiklyCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<Function1<Object, Unit>> weakRecordErrorCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int recordState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieRecorderView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        AdelieAudioContainerView adelieAudioContainerView = new AdelieAudioContainerView(context, null, 0, 6, null);
        this.audioView = adelieAudioContainerView;
        this.recordState = 2;
        addView(adelieAudioContainerView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private final void d(Function1<Object, Unit> function1, String str) {
        if (function1 != null) {
            function1.invoke(new Gson().toJson(new KuiklyRenderCallbackData(true, str, null, 4, null)));
        }
    }

    public static /* synthetic */ void i(AdelieRecorderView adelieRecorderView, Function1 function1, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        adelieRecorderView.g(function1, z16, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0018, code lost:
    
        if (r16.length() == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(String params, Function1<Object, Unit> callback) {
        if (this.recordState != 2) {
            return;
        }
        boolean z16 = false;
        this.recordState = 0;
        Object obj = null;
        this.weakKuiklyCallback = null;
        if (params != null) {
            try {
            } catch (Exception unused) {
                return;
            }
        }
        z16 = true;
        if (z16) {
            if (callback != null) {
                i(this, callback, false, null, 2, null);
                return;
            }
            return;
        }
        AdelieTtsRecordParam adelieTtsRecordParam = new AdelieTtsRecordParam(0.0f, 0, 0, null, 15, null);
        p.Companion companion = p.INSTANCE;
        try {
            obj = new Gson().fromJson(params, (Class<Object>) AdelieTtsRecordParam.class);
        } catch (Exception e16) {
            QLog.e("AdelieModuleData", 1, "AdelieModuleData fromJson exception = " + e16);
        }
        AdelieTtsRecordParam adelieTtsRecordParam2 = (AdelieTtsRecordParam) obj;
        if (adelieTtsRecordParam2 != null) {
            adelieTtsRecordParam = adelieTtsRecordParam2;
        }
        this.audioView.setAbnormalCallback(this);
        this.weakKuiklyCallback = new WeakReference<>(callback);
        this.audioView.e(adelieTtsRecordParam);
        if (callback != null) {
            i(this, callback, true, null, 2, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:18:0x000d, B:9:0x0019, B:11:0x001d, B:13:0x002b), top: B:17:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: Exception -> 0x002f, TryCatch #0 {Exception -> 0x002f, blocks: (B:18:0x000d, B:9:0x0019, B:11:0x001d, B:13:0x002b), top: B:17:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l(String params, Function1<Object, Unit> callback) {
        boolean z16;
        if (this.recordState != 0) {
            return;
        }
        this.recordState = 1;
        this.weakKuiklyCallback = null;
        if (params != null) {
            if (params.length() != 0) {
                z16 = false;
                if (!z16) {
                    q(callback);
                    return;
                }
                if (new JSONObject(params).optInt("isCancel") == 1) {
                    q(callback);
                    return;
                }
                this.recordState = 2;
                this.audioView.f(callback);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final void m(Function1<Object, Unit> callback) {
        this.weakRecordErrorCallback = new WeakReference<>(callback);
    }

    private final boolean o(Object propValue) {
        return true;
    }

    private final void p(final String params, final Function1<Object, Unit> callback) {
        j jVar;
        Object obj;
        Context context = getContext();
        Activity activity = null;
        if (context instanceof j) {
            jVar = (j) context;
        } else {
            jVar = null;
        }
        if (jVar != null) {
            obj = jVar.getBaseContext();
        } else {
            obj = null;
        }
        if (obj instanceof Activity) {
            activity = (Activity) obj;
        }
        if (activity != null) {
            d.f366806a.a(activity, new Function0<Unit>() { // from class: com.tencent.robot.adelie.kuikly.view.AdelieRecorderView$startRecording$1$1
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
                    AdelieRecorderView.this.j(params, callback);
                }
            }, new Function0<Unit>() { // from class: com.tencent.robot.adelie.kuikly.view.AdelieRecorderView$startRecording$1$2
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
                    Function1<Object, Unit> function1 = callback;
                    if (function1 != null) {
                        AdelieRecorderView.i(this, function1, false, null, 2, null);
                    }
                }
            });
        }
    }

    private final void q(Function1<Object, Unit> callback) {
        this.recordState = 2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("filePath", "");
        jSONObject.put("duration", 0);
        d(callback, jSONObject.toString());
    }

    @Override // com.tencent.robot.adelie.kuikly.view.record.f
    public void a(int errCode, @NotNull String errMsg) {
        Function1<Object, Unit> function1;
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.recordState = 2;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("code", errCode);
        WeakReference<Function1<Object, Unit>> weakReference = this.weakRecordErrorCallback;
        if (weakReference != null && (function1 = weakReference.get()) != null) {
            d(function1, jSONObject.toString());
        }
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "scene")) {
            return o(propValue);
        }
        return c.a.p(this, propKey, propValue);
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

    public final void g(@Nullable Function1<Object, Unit> function1, boolean z16, @Nullable String str) {
        if (function1 != null) {
            function1.invoke(new Gson().toJson(new KuiklyRenderCallbackData(z16, null, str, 2, null)));
        }
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
        this.audioView.d();
        this.weakKuiklyCallback = null;
        this.weakRecordErrorCallback = null;
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
    public void setShadow(@NotNull b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        int hashCode = method.hashCode();
        if (hashCode != 582343510) {
            if (hashCode != 597498454) {
                if (hashCode == 639215535 && method.equals("startRecording")) {
                    p(params, callback);
                    return Unit.INSTANCE;
                }
            } else if (method.equals("onRecordingError")) {
                m(callback);
                return Unit.INSTANCE;
            }
        } else if (method.equals("endRecording")) {
            l(params, callback);
            return Unit.INSTANCE;
        }
        return c.a.b(this, method, params, callback);
    }
}
