package com.tencent.mtt.hippy.a;

import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyRootView;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes20.dex */
public class m implements n {

    /* renamed from: a, reason: collision with root package name */
    final k f336992a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(HippyGlobalConfigs hippyGlobalConfigs, String str) {
        this.f336992a = new k(hippyGlobalConfigs, str, null);
    }

    @Override // com.tencent.mtt.hippy.a.n
    public String a(String str) {
        return null;
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void b() {
    }

    @Override // com.tencent.mtt.hippy.a.n
    public String a(String str, String str2, String str3) {
        return null;
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void b(HippyRootView hippyRootView) {
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void a(HippyRootView hippyRootView) {
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void a(h hVar) {
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void a(String str, final h hVar) {
        this.f336992a.a(new a() { // from class: com.tencent.mtt.hippy.a.m.1
            @Override // com.tencent.mtt.hippy.a.a
            public void a(InputStream inputStream) {
                h hVar2 = hVar;
                if (hVar2 != null) {
                    hVar2.onDevBundleLoadReady(inputStream);
                }
            }

            @Override // com.tencent.mtt.hippy.a.a
            public void a(Exception exc) {
                h hVar2 = hVar;
                if (hVar2 != null) {
                    hVar2.onInitDevError(exc);
                }
            }
        }, str);
    }

    @Override // com.tencent.mtt.hippy.a.n
    public void a(Throwable th5) {
    }
}
