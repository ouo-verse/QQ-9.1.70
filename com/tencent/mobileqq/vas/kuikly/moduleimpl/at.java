package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasReaderApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0016JG\u0010\u000e\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0016R\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/at;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "", "params", "c", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Reader;", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Reader;", "b", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Reader;", "reader", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class at {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Reader reader = new Reader();

    public void a(@Nullable Activity activity, @Nullable Function1<Object, Unit> callback) {
        float deviceBrightness = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).getDeviceBrightness(activity);
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", Float.valueOf(deviceBrightness));
            callback.invoke(jSONObject.toString());
        }
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public Reader getReader() {
        return this.reader;
    }

    public void c(@Nullable Activity activity, @NotNull String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        int deviceBrightness = ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).setDeviceBrightness(activity, au.a(new JSONObject(params).opt("brightness")));
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", deviceBrightness);
            callback.invoke(jSONObject.toString());
        }
    }
}
