package com.tencent.mtt.hippy.a.a.a;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected WeakReference<com.tencent.mtt.hippy.a.a.a> f336913a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f336914b;

    public c(com.tencent.mtt.hippy.a.a.a aVar) {
        this.f336913a = new WeakReference<>(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i3, JSONObject jSONObject) {
        com.tencent.mtt.hippy.a.a.a aVar = this.f336913a.get();
        if (aVar != null) {
            aVar.a(i3, jSONObject);
        }
    }

    protected abstract boolean a(HippyEngineContext hippyEngineContext, String str, int i3, JSONObject jSONObject);

    public boolean b(HippyEngineContext hippyEngineContext, String str, int i3, JSONObject jSONObject) {
        String str2;
        WeakReference<com.tencent.mtt.hippy.a.a.a> weakReference = this.f336913a;
        if (weakReference == null) {
            str2 = "handleRequestFromBackend, mInspectorRef null";
        } else {
            com.tencent.mtt.hippy.a.a.a aVar = weakReference.get();
            if (aVar == null) {
                str2 = "handleRequestFromBackend, inspector null";
            } else {
                if ("enable".equals(str)) {
                    this.f336914b = true;
                } else if ("disable".equals(str)) {
                    this.f336914b = false;
                } else {
                    return a(hippyEngineContext, str, i3, jSONObject);
                }
                aVar.a(i3, (JSONObject) null);
                return true;
            }
        }
        LogUtils.e("InspectorDomain", str2);
        return false;
    }

    public void a(HippyEngineContext hippyEngineContext) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.tencent.mtt.hippy.a.a.b.c cVar) {
        com.tencent.mtt.hippy.a.a.a aVar = this.f336913a.get();
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    public void c() {
    }
}
