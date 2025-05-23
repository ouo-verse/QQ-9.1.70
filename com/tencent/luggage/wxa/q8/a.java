package com.tencent.luggage.wxa.q8;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.q8.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6638a {
        public static /* synthetic */ void a(a aVar, int i3, int i16, int i17, Surface surface, Function1 function1, Function1 function12, int i18, Object obj) {
            if (obj == null) {
                if ((i18 & 32) != 0) {
                    function12 = null;
                }
                aVar.a(i3, i16, i17, surface, function1, function12);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: registerSurface");
        }
    }

    void a(int i3);

    void a(int i3, int i16, int i17, Surface surface, Function1 function1, Function1 function12);

    void a(int i3, SurfaceTexture surfaceTexture);

    void b(int i3);
}
