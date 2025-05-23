package com.tencent.mobileqq.gamecenter.kuikly.module;

import android.content.ComponentCallbacks2;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002JI\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/module/t;", "Li01/e;", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "Landroidx/lifecycle/LifecycleOwner;", "c", "", "method", "call", "<init>", "()V", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class t extends i01.e {
    private final LifecycleOwner c() {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof LifecycleOwner) {
            return (LifecycleOwner) activity;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void d(Object params, final Function1<Object, Unit> callback) {
        if (params != null && (params instanceof String)) {
            try {
                JSONObject jSONObject = new JSONObject((String) params);
                String string = jSONObject.getString("troopUin");
                ArrayList arrayList = new ArrayList();
                for (Object obj : com.tencent.kuikly.core.render.android.css.ktx.b.F(new JSONArray(jSONObject.getString("gameIdList")))) {
                    if (obj instanceof Integer) {
                        arrayList.add(obj);
                    }
                }
                ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopSelectedGameId(c(), string, arrayList, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.s
                    @Override // com.tencent.qqnt.troop.e
                    public final void onResult(boolean z16, int i3, String str) {
                        t.g(Function1.this, z16, i3, str);
                    }
                });
                return;
            } catch (Exception e16) {
                if (callback != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", -2);
                    jSONObject2.put("msg", "Exception is happened: " + e16.getMessage());
                    callback.invoke(jSONObject2);
                    return;
                }
                return;
            }
        }
        if (callback != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("result", -1);
            jSONObject3.put("msg", "params is invalid");
            callback.invoke(jSONObject3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 function1, boolean z16, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (function1 != null) {
            JSONObject jSONObject = new JSONObject();
            if (z16) {
                i3 = 0;
            }
            jSONObject.put("result", i3);
            jSONObject.put("msg", errMsg);
            function1.invoke(jSONObject);
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "setTroopSelectedGameId")) {
            d(params, callback);
        }
        return Unit.INSTANCE;
    }
}
