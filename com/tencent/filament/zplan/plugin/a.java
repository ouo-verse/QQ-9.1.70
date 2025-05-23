package com.tencent.filament.zplan.plugin;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.filament.js.annotation.JsFilamentEvent;
import com.tencent.filament.js.annotation.JsFilamentPlugin;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@JsFilamentPlugin
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/filament/zplan/plugin/a;", "", "Lcom/tencent/filament/zplan/engine/js/a;", "req", "", "downloadUrl", "<init>", "()V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J6\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/filament/zplan/plugin/a$a", "Lgl0/a;", "", "errorMsg", "", "b", "filePath", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "", "rspHeader", "a", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.filament.zplan.plugin.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1115a implements gl0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.filament.zplan.engine.js.a f105776a;

        C1115a(com.tencent.filament.zplan.engine.js.a aVar) {
            this.f105776a = aVar;
        }

        @Override // gl0.a
        public void a(@Nullable String filePath, int statusCode, @Nullable Map<String, ? extends List<String>> rspHeader) {
            JSONObject jSONObject = new JSONObject();
            if (filePath == null) {
                filePath = "";
            }
            jSONObject.put("fileSavePath", filePath);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, statusCode);
            jSONObject.put("httpResponse", jSONObject2);
            this.f105776a.g(jSONObject);
        }

        @Override // gl0.a
        public void b(@NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.f105776a.b(errorMsg);
        }
    }

    @JsFilamentEvent({"downloadUrl"})
    @NotNull
    public final String downloadUrl(@NotNull com.tencent.filament.zplan.engine.js.a req) {
        Intrinsics.checkNotNullParameter(req, "req");
        String url = new JSONObject(req.getJsonParams()).optString("url");
        dl0.b bVar = (dl0.b) fl0.a.f399763a.a(dl0.b.class);
        if (bVar == null) {
            req.b("no proxy");
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        bVar.a(url, null, new C1115a(req));
        return "";
    }
}
