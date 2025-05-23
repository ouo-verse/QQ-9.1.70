package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.gdtad.IGdtActivityHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J?\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J=\u0010\u0013\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002JI\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/kuikly/cardad/b;", "Li01/e;", "", "c", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "l", "g", "i", "d", "j", "errMsg", "a", "method", "call", "Lcom/tencent/kuikly/core/render/android/c;", "Lcom/tencent/kuikly/core/render/android/c;", "mRenderLifecycleCallback", "<init>", "()V", "e", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.kuikly.core.render.android.c mRenderLifecycleCallback = new C8899b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/adv/kuikly/cardad/b$b", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.kuikly.cardad.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C8899b implements com.tencent.kuikly.core.render.android.c {
        C8899b() {
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            ((IGdtActivityHandler) QRoute.api(IGdtActivityHandler.class)).onActivityResult(new WeakReference<>(b.this.getActivity()), requestCode, resultCode, data);
        }
    }

    private final void a(Function1<Object, Unit> callback, String errMsg) {
        QLog.e("QQKuiklyAdDataModule", 1, "callbackError", errMsg);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errMsg", errMsg);
        if (callback != null) {
            callback.invoke(jSONObject);
        }
    }

    private final void c() {
        QLog.d("QQKuiklyAdDataModule", 1, "checkAdVisibility");
        VasKuiklyCardAdManager.n(VasKuiklyCardAdManager.f308031a, 5, 0, null, 6, null);
    }

    private final void d(String params) {
        String str;
        if (!TextUtils.isEmpty(params)) {
            str = new JSONObject(params).optString("pageName");
            Intrinsics.checkNotNullExpressionValue(str, "paramJson.optString(PAGE_NAME)");
        } else {
            str = "";
        }
        String str2 = str;
        QLog.d("QQKuiklyAdDataModule", 1, "onPageAppear:", str2);
        VasKuiklyCardAdManager.n(VasKuiklyCardAdManager.f308031a, 3, 0, str2, 2, null);
    }

    private final void g(String params) {
        String str;
        if (!TextUtils.isEmpty(params)) {
            str = new JSONObject(params).optString("pageName");
            Intrinsics.checkNotNullExpressionValue(str, "paramJson.optString(PAGE_NAME)");
        } else {
            str = "";
        }
        String str2 = str;
        QLog.d("QQKuiklyAdDataModule", 1, "onPageCreate:", str2);
        VasKuiklyCardAdManager.n(VasKuiklyCardAdManager.f308031a, 1, 0, str2, 2, null);
        addKuiklyRenderLifecycleCallback(this.mRenderLifecycleCallback);
    }

    private final void i(String params) {
        String str;
        if (!TextUtils.isEmpty(params)) {
            str = new JSONObject(params).optString("pageName");
            Intrinsics.checkNotNullExpressionValue(str, "paramJson.optString(PAGE_NAME)");
        } else {
            str = "";
        }
        String str2 = str;
        QLog.d("QQKuiklyAdDataModule", 1, "onPageDestroy:", str2);
        VasKuiklyCardAdManager.n(VasKuiklyCardAdManager.f308031a, 2, 0, str2, 2, null);
        removeKuiklyRenderLifeCycleCallback(this.mRenderLifecycleCallback);
    }

    private final void j() {
        QLog.d("QQKuiklyAdDataModule", 1, "onPageDisappear");
        VasKuiklyCardAdManager.n(VasKuiklyCardAdManager.f308031a, 4, 0, null, 6, null);
    }

    private final void l(String params, Function1<Object, Unit> callback) {
        QLog.d("QQKuiklyAdDataModule", 1, "refreshAdData");
        if (TextUtils.isEmpty(params)) {
            a(callback, "refreshAdData error, params is empty");
            return;
        }
        int optInt = new JSONObject(params).optInt("adIndex", -1);
        if (optInt < 0) {
            a(callback, "refreshAdData error, adIndex error:" + optInt);
            return;
        }
        VasKuiklyCardAdManager.n(VasKuiklyCardAdManager.f308031a, 6, optInt, null, 4, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -186313661:
                if (method.equals("onPageAppear")) {
                    d(params);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -127539286:
                if (method.equals("onPageCreate")) {
                    g(params);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 747192885:
                if (method.equals("onPageDisappear")) {
                    j();
                }
                return Unit.INSTANCE;
            case 870067980:
                if (method.equals("onPageDestroy")) {
                    i(params);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1510320317:
                if (method.equals("checkAdVisibility")) {
                    c();
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1987990824:
                if (method.equals("refreshAdData")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                return Unit.INSTANCE;
        }
    }
}
