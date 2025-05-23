package ef3;

import com.tencent.mobileqq.zplan.avatar.api.hippy.BaseHippyUeActionHandler;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import ff3.b;
import ff3.c;
import ff3.d;
import ff3.e;
import ff3.f;
import ff3.g;
import ff3.h;
import ff3.i;
import ff3.j;
import ff3.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lef3/a;", "", "Lorg/json/JSONObject;", "params", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "Lcom/tencent/mobileqq/zplan/avatar/api/hippy/BaseHippyUeActionHandler;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396227a = new a();

    a() {
    }

    public final BaseHippyUeActionHandler a(JSONObject params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        QLog.i("HippyUeActionProvider_", 1, "params:" + params);
        int optInt = params.optInt("actionType", 0);
        JSONObject optJSONObject = params.optJSONObject("actionParam");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        switch (optInt) {
            case 1:
                return new d(optInt, optJSONObject, promise);
            case 2:
                return new k(optInt, optJSONObject, promise);
            case 3:
                return new b(optInt, optJSONObject, promise);
            case 4:
                return new j(optInt, optJSONObject, promise);
            case 5:
                return new c(optInt, optJSONObject, promise);
            case 6:
                return new f(optInt, optJSONObject, promise);
            case 7:
                return new g(optInt, optJSONObject, promise);
            case 8:
                return new i(optInt, optJSONObject, promise);
            case 9:
                return new h(optInt, optJSONObject, promise);
            case 10:
                return new e(optInt, optJSONObject, promise);
            default:
                return null;
        }
    }
}
