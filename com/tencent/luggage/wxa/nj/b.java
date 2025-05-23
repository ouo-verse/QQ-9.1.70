package com.tencent.luggage.wxa.nj;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b extends d {
    @Override // com.tencent.luggage.wxa.nj.d
    public void a(com.tencent.luggage.wxa.c5.e runtime, String scene) {
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Intrinsics.checkNotNullParameter(scene, "scene");
        super.a((com.tencent.luggage.wxa.ic.g) runtime, scene);
        int hashCode = scene.hashCode();
        if (hashCode == -1128437284) {
            if (scene.equals("scene_actionbar_back")) {
                com.tencent.luggage.wxa.yf.a.f145629a.a(runtime, 3);
            }
        } else if (hashCode == 13653565) {
            if (scene.equals("scene_back_key_pressed")) {
                com.tencent.luggage.wxa.yf.a.f145629a.a(runtime, 2);
            }
        } else if (hashCode == 298295391) {
            if (scene.equals("scene_swipe_back")) {
                com.tencent.luggage.wxa.yf.a.f145629a.a(runtime, 1);
            }
        } else if (hashCode == 560038708 && scene.equals("scene_jsapi_navigate_back")) {
            com.tencent.luggage.wxa.yf.a.f145629a.a(runtime, 4);
        }
    }
}
