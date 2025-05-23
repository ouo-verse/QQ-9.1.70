package b25;

import android.content.Context;
import android.os.Handler;
import c25.b;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import java.util.Vector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class m implements c25.b {

    /* renamed from: a, reason: collision with root package name */
    private Object f27784a;

    /* renamed from: b, reason: collision with root package name */
    private Handler.Callback f27785b = null;

    /* renamed from: c, reason: collision with root package name */
    private Vector f27786c = new Vector();

    public m(Object obj) {
        this.f27784a = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c25.f d(Object obj) {
        c25.f fVar = new c25.f();
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            fVar.f30242a = jSONObject.optInt("kingcard", 0);
            fVar.f30244c = jSONObject.optString("phoneNum", null);
            fVar.f30249h = jSONObject.optString("activationUrl", null);
            fVar.f30245d = jSONObject.optInt(JsonRuleKey.OPERATOR, 0);
            fVar.f30243b = jSONObject.optInt("product", 0);
            fVar.f30246e = jSONObject.optInt("errorCode");
            fVar.f30247f = jSONObject.optInt("subErrorCode");
            fVar.f30248g = jSONObject.optString("extra");
        } catch (Throwable th5) {
            p.b(th5);
        }
        return fVar;
    }

    @Override // c25.b
    public c25.a a(Context context) {
        return new l(q.b(this.f27784a, Object.class, q.c(this.f27784a, "generateActivationView", Context.class), context));
    }

    @Override // c25.b
    public void b(b.a aVar) {
        synchronized (this.f27786c) {
            if (this.f27786c.contains(aVar)) {
                return;
            }
            this.f27786c.add(aVar);
            if (this.f27785b != null) {
                return;
            }
            this.f27785b = new n(this);
            q.b(this.f27784a, null, q.c(this.f27784a, "registerShellOnChangeListener", Handler.Callback.class), this.f27785b);
        }
    }

    @Override // c25.b
    public c25.f getResult() {
        Object b16 = q.b(this.f27784a, Object.class, q.c(this.f27784a, "getResult", new Class[0]), new Object[0]);
        c25.f fVar = new c25.f();
        if (b16 != null) {
            fVar.f30249h = (String) q.a(b16, String.class, "activationUrl");
            fVar.f30242a = ((Integer) q.a(b16, Integer.class, "kingcard")).intValue();
            fVar.f30243b = ((Integer) q.a(b16, Integer.class, "product")).intValue();
            fVar.f30244c = (String) q.a(b16, String.class, "phoneNum");
            fVar.f30245d = ((Integer) q.a(b16, Integer.class, JsonRuleKey.OPERATOR)).intValue();
        }
        return fVar;
    }
}
