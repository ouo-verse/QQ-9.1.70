package com.tencent.mtt.hippy.a.a.a;

import com.tencent.mtt.hippy.HippyEngineContext;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends c {

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.mtt.hippy.a.a.b.a f336911b;

    public a(com.tencent.mtt.hippy.a.a.a aVar) {
        super(aVar);
        this.f336911b = new com.tencent.mtt.hippy.a.a.b.a();
    }

    private void b(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336911b.c(hippyEngineContext, jSONObject.optInt("nodeId")));
    }

    private void c(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336911b.b(hippyEngineContext, jSONObject.optInt("nodeId")));
    }

    private void d(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336911b.a(hippyEngineContext, jSONObject.optJSONArray("edits"), this));
    }

    public String a() {
        return "CSS";
    }

    private void a(HippyEngineContext hippyEngineContext, int i3, JSONObject jSONObject) {
        a(i3, this.f336911b.a(hippyEngineContext, jSONObject.optInt("nodeId")));
    }

    public void a(boolean z16) {
        WeakReference<com.tencent.mtt.hippy.a.a.a> weakReference = this.f336913a;
        if (weakReference == null) {
            return;
        }
        weakReference.get().a(z16);
    }

    @Override // com.tencent.mtt.hippy.a.a.a.c
    public boolean a(HippyEngineContext hippyEngineContext, String str, int i3, JSONObject jSONObject) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1310365795:
                if (str.equals("getComputedStyleForNode")) {
                    c16 = 0;
                    break;
                }
                break;
            case 319154650:
                if (str.equals("getInlineStylesForNode")) {
                    c16 = 1;
                    break;
                }
                break;
            case 605896631:
                if (str.equals("setStyleTexts")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1954749659:
                if (str.equals("getMatchedStylesForNode")) {
                    c16 = 3;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                b(hippyEngineContext, i3, jSONObject);
                return true;
            case 1:
                c(hippyEngineContext, i3, jSONObject);
                return true;
            case 2:
                d(hippyEngineContext, i3, jSONObject);
                return true;
            case 3:
                a(hippyEngineContext, i3, jSONObject);
                return true;
            default:
                return false;
        }
    }
}
