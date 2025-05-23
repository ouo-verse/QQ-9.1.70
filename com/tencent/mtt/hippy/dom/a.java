package com.tencent.mtt.hippy.dom;

import android.view.Choreographer;
import com.tencent.mtt.hippy.dom.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f337219a = true;

    /* renamed from: b, reason: collision with root package name */
    private static a f337220b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<e.a, Choreographer.FrameCallback> f337221c = new HashMap();

    a() {
    }

    public static a a() {
        if (f337220b == null) {
            f337220b = new a();
        }
        return f337220b;
    }

    public void b(e.a aVar) {
        if (f337219a) {
            Choreographer.FrameCallback frameCallback = this.f337221c.get(aVar);
            if (frameCallback != null) {
                this.f337221c.remove(aVar);
                Choreographer.getInstance().removeFrameCallback(frameCallback);
                return;
            }
            return;
        }
        f.a().b(aVar);
    }

    public void a(final e.a aVar) {
        if (!f337219a) {
            f.a().a(aVar);
            return;
        }
        Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: com.tencent.mtt.hippy.dom.a.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j3) {
                e.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(j3);
                }
            }
        };
        this.f337221c.put(aVar, frameCallback);
        Choreographer.getInstance().postFrameCallback(frameCallback);
    }
}
