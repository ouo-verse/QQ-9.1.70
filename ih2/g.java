package ih2;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002JG\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002JM\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0002JI\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004j\u0004\u0018\u0001`\tH\u0016\u00a8\u0006\u0017"}, d2 = {"Lih2/g;", "Li01/e;", "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "", "method", "c", "", "code", "msg", "callBackResult", "call", "<init>", "()V", "d", "qqgamepubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g extends i01.e {
    private final void a(Object params, Function1<Object, Unit> callback) {
        com.tencent.kuikly.core.render.android.d O0;
        ViewGroup view;
        jh2.b bVar;
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null && (view = O0.getView()) != null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (parent != null) {
                    if (parent instanceof jh2.b) {
                        bVar = (jh2.b) parent;
                        break;
                    }
                    parent = parent.getParent();
                } else {
                    bVar = null;
                    break;
                }
            }
            QLog.d("QZoneKuiklyGameAdModule", 1, "closeAd hashCode=" + hashCode() + ",dstView=" + bVar);
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r0 == true) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c(String method, Object params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        boolean z16;
        String str = null;
        if (params instanceof String) {
            jSONObject = new JSONObject((String) params);
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
        }
        boolean z17 = true;
        QLog.d("QZoneKuiklyGameAdModule", 1, "jump jumpUrl=" + str);
        if (str != null) {
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        z17 = false;
        if (z17) {
            GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, str);
            callBackResult(method, 0, "", callback);
        } else {
            callBackResult(method, -2, "params invalid", callback);
        }
    }

    private final void callBackResult(String method, int code, String msg2, Function1<Object, Unit> callback) {
        if (callback == null) {
            return;
        }
        if (code < 0) {
            QLog.w("QZoneKuiklyGameAdModule", 1, method + " call failed, code=" + code + ", msg=" + msg2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", code);
            jSONObject.put("msg", msg2);
            callback.invoke(jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("QZoneKuiklyGameAdModule", 1, "callBackFail: exception=", e16.getMessage());
        }
    }

    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.d("QZoneKuiklyGameAdModule", 1, "call method=" + method + ", params=" + params);
        if (Intrinsics.areEqual(method, "closeAd")) {
            a(params, callback);
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "jump")) {
            c(method, params, callback);
            return Unit.INSTANCE;
        }
        return super.call(method, params, callback);
    }
}
