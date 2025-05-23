package com.tencent.mtt.hippy.a.a.a;

import com.tencent.mtt.hippy.HippyEngineContext;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends c {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mtt.hippy.a.a.b.b f336912b;

    public b(com.tencent.mtt.hippy.a.a.a aVar) {
        super(aVar);
        this.f336912b = new com.tencent.mtt.hippy.a.a.b.b();
    }

    private void c(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336912b.c(hippyEngineContext, jSONObject));
    }

    private void d(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336912b.d(hippyEngineContext, jSONObject));
    }

    private void e(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336912b.e(hippyEngineContext, jSONObject));
    }

    public String a() {
        return "DOM";
    }

    public void b() {
        a(new com.tencent.mtt.hippy.a.a.b.c("DOM.documentUpdated", new JSONObject()));
    }

    private void a(HippyEngineContext hippyEngineContext, int i3) {
        a(i3, this.f336912b.a(hippyEngineContext));
    }

    private void b(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336912b.b(hippyEngineContext, jSONObject));
    }

    private void a(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336912b.a(hippyEngineContext, jSONObject));
    }

    @Override // com.tencent.mtt.hippy.a.a.a.c
    public boolean a(HippyEngineContext hippyEngineContext, String str, int i3, JSONObject jSONObject) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1970442989:
                if (str.equals("setInspectedNode")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1355346287:
                if (str.equals("getDocument")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1038283258:
                if (str.equals("getNodeForLocation")) {
                    c16 = 2;
                    break;
                }
                break;
            case -872849339:
                if (str.equals("pushNodeByPathToFrontend")) {
                    c16 = 3;
                    break;
                }
                break;
            case 18330004:
                if (str.equals("getBoxModel")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1815853023:
                if (str.equals("pushNodesByBackendIdsToFrontend")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                c(hippyEngineContext, i3, jSONObject);
                return true;
            case 1:
                a(hippyEngineContext, i3);
                return true;
            case 2:
                b(hippyEngineContext, i3, jSONObject);
                return true;
            case 3:
                d(hippyEngineContext, i3, jSONObject);
                return true;
            case 4:
                a(hippyEngineContext, i3, jSONObject);
                return true;
            case 5:
                e(hippyEngineContext, i3, jSONObject);
                return true;
            default:
                return false;
        }
    }
}
