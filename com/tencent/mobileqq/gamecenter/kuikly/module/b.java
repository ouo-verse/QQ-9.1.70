package com.tencent.mobileqq.gamecenter.kuikly.module;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameCenterKuiklyApi;
import com.tencent.mobileqq.gamecenter.ui.GameCenterKuiklyFloatDialog;
import com.tencent.mobileqq.gamecenter.ui.aa;
import com.tencent.mobileqq.gamecenter.ui.ab;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00032\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002JI\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\u0011\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fj\u0004\u0018\u0001`\u0010H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/module/b;", "Li01/e;", "Lcom/tencent/mobileqq/gamecenter/ui/GameCenterKuiklyFloatDialog;", "d", "", "params", "", "g", "c", "j", "", "method", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends i01.e {
    private final void c() {
        try {
            GameCenterKuiklyFloatDialog d16 = d();
            if (d16 != null) {
                d16.U();
                QLog.d("GameCenterKuiklyFloatModule", 1, "closeFloat");
            }
        } catch (Throwable th5) {
            QLog.e("GameCenterKuiklyFloatModule", 1, th5, new Object[0]);
        }
    }

    private final GameCenterKuiklyFloatDialog d() {
        com.tencent.kuikly.core.render.android.d O0;
        ViewGroup view;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null && (view = O0.getView()) != null) {
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof View) {
                    View view2 = (View) parent;
                    if (view2.getTag() instanceof GameCenterKuiklyFloatDialog) {
                        Object tag = view2.getTag();
                        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.gamecenter.ui.GameCenterKuiklyFloatDialog");
                        return (GameCenterKuiklyFloatDialog) tag;
                    }
                }
            }
            return null;
        }
        return null;
    }

    private final void g(Object params) {
        String obj;
        if (params != null && (obj = params.toString()) != null) {
            try {
                final aa c16 = ab.c(nf2.a.e(new JSONObject(obj)));
                if (c16 == null) {
                    QLog.e("GameCenterKuiklyFloatModule", 1, "resize params are invalid");
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.i(b.this, c16);
                        }
                    });
                }
            } catch (JSONException e16) {
                QLog.e("GameCenterKuiklyFloatModule", 1, "resize e:", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b this$0, aa aaVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GameCenterKuiklyFloatDialog d16 = this$0.d();
        if (d16 != null && d16.isShowing()) {
            Intrinsics.checkNotNull(aaVar);
            d16.W(aaVar);
        }
    }

    private final void j(Object params) {
        JSONObject jSONObject;
        String obj;
        try {
            IGameCenterKuiklyApi iGameCenterKuiklyApi = (IGameCenterKuiklyApi) QRoute.api(IGameCenterKuiklyApi.class);
            Activity activity = getActivity();
            if (params != null && (obj = params.toString()) != null) {
                jSONObject = new JSONObject(obj);
            } else {
                jSONObject = null;
            }
            iGameCenterKuiklyApi.openKuiklyFloatDialog(activity, jSONObject);
        } catch (Throwable th5) {
            QLog.e("GameCenterKuiklyFloatModule", 1, th5, new Object[0]);
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("GameCenterKuiklyFloatModule", 1, "call method=" + method + ", params=" + params);
        int hashCode = method.hashCode();
        if (hashCode != -934437708) {
            if (hashCode != 3529469) {
                if (hashCode == 94756344 && method.equals("close")) {
                    c();
                    return Unit.INSTANCE;
                }
            } else if (method.equals("show")) {
                j(params);
                return Unit.INSTANCE;
            }
        } else if (method.equals("resize")) {
            g(params);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
