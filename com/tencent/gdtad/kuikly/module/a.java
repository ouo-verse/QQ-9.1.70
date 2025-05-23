package com.tencent.gdtad.kuikly.module;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b$\u0010%JG\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JI\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/gdtad/kuikly/module/a;", "Li01/e;", "", "method", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "Lcom/tencent/gdtad/kuikly/module/h;", "a", "call", "Lcom/tencent/gdtad/kuikly/module/GdtKuiklyModuleDeviceInfoHandler;", "d", "Lcom/tencent/gdtad/kuikly/module/GdtKuiklyModuleDeviceInfoHandler;", "mDeviceInfoHandler", "Lcom/tencent/gdtad/kuikly/module/b;", "e", "Lcom/tencent/gdtad/kuikly/module/b;", "mClickHandler", "Lcom/tencent/gdtad/kuikly/module/d;", "f", "Lcom/tencent/gdtad/kuikly/module/d;", "mFeedbackHandler", "Lcom/tencent/gdtad/kuikly/module/g;", tl.h.F, "Lcom/tencent/gdtad/kuikly/module/g;", "mWebViewHandler", "Lcom/tencent/gdtad/kuikly/module/f;", "i", "Lcom/tencent/gdtad/kuikly/module/f;", "mLoadAdDemoHandler", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GdtKuiklyModuleDeviceInfoHandler mDeviceInfoHandler = new GdtKuiklyModuleDeviceInfoHandler();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.gdtad.kuikly.module.b mClickHandler = new com.tencent.gdtad.kuikly.module.b();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mFeedbackHandler = new d();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mWebViewHandler = new g();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mLoadAdDemoHandler = new f();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/gdtad/kuikly/module/a$b", "Lcom/tencent/gdtad/kuikly/module/h;", "", "result", "", "invoke", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f109304a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f109305b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f109306c;

        b(Function1<Object, Unit> function1, String str, Object obj) {
            this.f109304a = function1;
            this.f109305b = str;
            this.f109306c = obj;
        }

        @Override // com.tencent.gdtad.kuikly.module.h
        public void invoke(@Nullable Object result) {
            try {
                Function1<Object, Unit> function1 = this.f109304a;
                if (function1 != null) {
                    function1.invoke(result);
                }
                QLog.i("GdtKuiklyModule", 1, "[invoke] method:" + this.f109305b + " params:" + this.f109306c + " result:" + result);
            } catch (Throwable th5) {
                QLog.e("GdtKuiklyModule", 1, "[invoke] method:" + this.f109305b + " params:" + this.f109306c + " result:" + result, th5);
            }
        }
    }

    private final h a(String method, Object params, Function1<Object, Unit> callback) {
        return new b(callback, method, params);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0044. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i("GdtKuiklyModule", 1, "[call] method:" + method + " params:" + params);
        e eVar = new e();
        eVar.f109310a = getActivity();
        eVar.f109311b = a(method, params, callback);
        eVar.f109312c = method;
        eVar.f109313d = params;
        switch (method.hashCode()) {
            case -1043472990:
                if (method.equals("showFeedback")) {
                    this.mFeedbackHandler.e(eVar);
                    return Unit.INSTANCE;
                }
                QLog.e("GdtKuiklyModule", 1, "[call] error, unknown method, method:" + method + " params:" + params);
                return Unit.INSTANCE;
            case -747265748:
                if (method.equals("loadAdDemo")) {
                    QLog.e("GdtKuiklyModule", 1, "[call] error, unknown method, method:" + method + " params:" + params);
                    return Unit.INSTANCE;
                }
                QLog.e("GdtKuiklyModule", 1, "[call] error, unknown method, method:" + method + " params:" + params);
                return Unit.INSTANCE;
            case 483103770:
                if (method.equals("getDeviceInfo")) {
                    this.mDeviceInfoHandler.c(eVar);
                    return Unit.INSTANCE;
                }
                QLog.e("GdtKuiklyModule", 1, "[call] error, unknown method, method:" + method + " params:" + params);
                return Unit.INSTANCE;
            case 1026644591:
                if (method.equals("openWebView")) {
                    this.mWebViewHandler.b(eVar);
                    return Unit.INSTANCE;
                }
                QLog.e("GdtKuiklyModule", 1, "[call] error, unknown method, method:" + method + " params:" + params);
                return Unit.INSTANCE;
            default:
                QLog.e("GdtKuiklyModule", 1, "[call] error, unknown method, method:" + method + " params:" + params);
                return Unit.INSTANCE;
        }
    }
}
