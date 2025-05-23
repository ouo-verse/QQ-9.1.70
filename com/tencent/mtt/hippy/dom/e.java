package com.tencent.mtt.hippy.dom;

import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayDeque;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {

    /* renamed from: d, reason: collision with root package name */
    private static e f337305d;

    /* renamed from: b, reason: collision with root package name */
    int f337307b = 0;

    /* renamed from: c, reason: collision with root package name */
    boolean f337308c = false;

    /* renamed from: e, reason: collision with root package name */
    private final b f337309e = new b();

    /* renamed from: a, reason: collision with root package name */
    final ArrayDeque<a> f337306a = new ArrayDeque<>();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(long j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements a {
        b() {
        }

        @Override // com.tencent.mtt.hippy.dom.e.a
        public void a(long j3) {
            e eVar = e.this;
            eVar.f337308c = false;
            int size = eVar.f337306a.size();
            for (int i3 = 0; i3 < size; i3++) {
                e.this.f337306a.removeFirst().a(j3);
                e eVar2 = e.this;
                eVar2.f337307b--;
            }
            e.this.b();
        }
    }

    e() {
    }

    public static e a() {
        if (f337305d == null) {
            f337305d = new e();
        }
        return f337305d;
    }

    void b() {
        if (this.f337307b == 0 && this.f337308c) {
            com.tencent.mtt.hippy.dom.a.a().b(this.f337309e);
            this.f337308c = false;
        }
    }

    public void a(a aVar) {
        if (this.f337306a.contains(aVar)) {
            return;
        }
        this.f337306a.addLast(aVar);
        this.f337307b++;
        if (this.f337308c) {
            return;
        }
        try {
            com.tencent.mtt.hippy.dom.a.a().a(this.f337309e);
            this.f337308c = true;
        } catch (Exception e16) {
            LogUtils.d("HippyChoreographer", "postFrameCallback: " + e16.getMessage());
        }
    }

    public void b(a aVar) {
        if (this.f337306a.removeFirstOccurrence(aVar)) {
            this.f337307b--;
            b();
        }
    }
}
