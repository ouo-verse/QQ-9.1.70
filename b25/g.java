package b25;

import android.os.Message;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qphone.base.BaseConstants;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class g extends e {
    public g(o oVar) {
        super(oVar);
    }

    private void c(c25.d dVar, Message message) {
        JSONObject jSONObject = (JSONObject) message.obj;
        dVar.c(jSONObject.optLong(MiniAppGetGameTaskTicketServlet.KEY_TASKID), jSONObject.optLong("taskSeqno"), jSONObject.optInt("cmdId"), jSONObject.optInt("conchSeqno"), jSONObject.optInt("phase"), jSONObject.optInt("result"));
    }

    private void d(c25.d dVar, Message message) {
        dVar.h(message.arg1, new h(this, message.obj));
    }

    private void e(c25.d dVar, Message message) {
        JSONObject jSONObject = (JSONObject) message.obj;
        dVar.d(jSONObject.optInt("scSashimiSeqNo"), jSONObject.optLong(BaseConstants.EXTRA_PUSHID), jSONObject.optInt("cmdId"), (byte[]) jSONObject.opt("pushResult"));
    }

    private void f(c25.d dVar, Message message) {
        dVar.g(message.arg1, message.arg2, new i(this, message.obj));
    }

    private void g(c25.d dVar, Message message) {
        JSONObject jSONObject = (JSONObject) message.obj;
        dVar.i(jSONObject.optInt("cmdId"), (byte[]) jSONObject.opt("req"), jSONObject.optInt("flag"), new j(this, jSONObject.opt("callback")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // b25.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(c25.d dVar, Message message) {
        switch (message.what) {
            case 1:
                message.obj = dVar.getGuid();
                return true;
            case 2:
                message.obj = dVar.a();
                return true;
            case 3:
                g(dVar, message);
                return true;
            case 4:
                f(dVar, message);
                return true;
            case 5:
                dVar.e(message.arg1);
                return true;
            case 6:
                e(dVar, message);
                return true;
            case 7:
                d(dVar, message);
                return true;
            case 8:
                dVar.b(message.arg1);
                return true;
            case 9:
                c(dVar, message);
                return true;
            case 10:
                dVar.f(message.arg1);
                return true;
            default:
                return false;
        }
    }
}
