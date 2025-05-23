package com.tencent.mtt.hippy.modules.nativemodules.animation;

import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final int f337448a;

    /* renamed from: b, reason: collision with root package name */
    private final HippyRootView f337449b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<a> f337450c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private HippyMap f337451d;

    public b(int i3, HippyRootView hippyRootView) {
        this.f337448a = i3;
        this.f337449b = hippyRootView;
    }

    public int a() {
        return this.f337448a;
    }

    public HippyRootView b() {
        return this.f337449b;
    }

    public HippyMap c() {
        return this.f337451d;
    }

    public ArrayList<a> d() {
        return this.f337450c;
    }

    public void a(HippyMap hippyMap) {
        this.f337451d = hippyMap;
    }

    public void a(a aVar) {
        if (this.f337450c.contains(aVar)) {
            return;
        }
        this.f337450c.add(aVar);
    }
}
