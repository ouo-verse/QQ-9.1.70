package dd1;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.kuikly.core.render.android.d;
import com.tencent.mobileqq.gamecenter.kuikly.GuildBizCardKuiklyView;
import com.tencent.qphone.base.util.QLog;
import i01.e;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00162\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002JI\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\t2+\u0010\u000f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nj\u0004\u0018\u0001`\u000eH\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Ldd1/a;", "Li01/e;", "Lcom/tencent/mobileqq/gamecenter/kuikly/GuildBizCardKuiklyView;", "c", "", "params", "", "a", "method", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "d", "Lcom/tencent/mobileqq/gamecenter/kuikly/GuildBizCardKuiklyView;", "kuiklyLayout", "<init>", "()V", "e", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildBizCardKuiklyView kuiklyLayout;

    private final void a(String params) {
        JSONObject jSONObject;
        Iterator keys;
        boolean z16;
        if (params != null) {
            if (params.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                params = "{}";
            }
            try {
                jSONObject = new JSONObject(params);
            } catch (Exception e16) {
                QLog.e("GuildDTReportModule", 1, "dtReport e" + e16);
                jSONObject = new JSONObject();
            }
        } else {
            jSONObject = null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null && (keys = jSONObject.keys()) != null) {
            while (keys.hasNext()) {
                String key = (String) keys.next();
                Intrinsics.checkNotNullExpressionValue(key, "key");
                String optString = jSONObject.optString(key);
                Intrinsics.checkNotNullExpressionValue(optString, "paramsJson.optString(key)");
                hashMap.put(key, optString);
            }
        }
        GuildBizCardKuiklyView c16 = c();
        if (c16 != null) {
            c16.c(hashMap);
        }
    }

    private final GuildBizCardKuiklyView c() {
        com.tencent.kuikly.core.render.android.a aVar;
        d O0;
        ViewGroup view;
        if (this.kuiklyLayout == null && (aVar = get_kuiklyRenderContext()) != null && (O0 = aVar.O0()) != null && (view = O0.getView()) != null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent instanceof GuildBizCardKuiklyView) {
                    this.kuiklyLayout = (GuildBizCardKuiklyView) parent;
                    break;
                }
                parent = parent.getParent();
            }
        }
        return this.kuiklyLayout;
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("GuildDTReportModule", 1, "call method=" + method + ", params=" + params);
        if (Intrinsics.areEqual(method, "dtReport")) {
            a((String) params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
