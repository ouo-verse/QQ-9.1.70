package com.tencent.biz.qqcircle.immersive.personal.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class i extends b {

    /* renamed from: b, reason: collision with root package name */
    protected final ConcurrentHashMap<Integer, Boolean> f88545b = new ConcurrentHashMap<>();

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String a() {
        return "QFSMainBusiOpMaskInfo";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public String b() {
        return "update_version_op_mask";
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.data.b
    public boolean e(a aVar, a aVar2) {
        if (aVar2.e().opMask.has()) {
            aVar.e().opMask.set(aVar2.e().opMask.get());
            return true;
        }
        boolean z16 = false;
        for (Map.Entry<Integer, Boolean> entry : aVar2.i().entrySet()) {
            int intValue = entry.getKey().intValue();
            boolean booleanValue = entry.getValue().booleanValue();
            boolean contains = aVar.e().opMask.get().contains(Integer.valueOf(intValue));
            if (booleanValue && !contains) {
                aVar.e().opMask.get().add(Integer.valueOf(intValue));
            } else if (contains) {
                aVar.e().opMask.get().remove(Integer.valueOf(intValue));
            }
            z16 = true;
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3) {
        this.f88545b.put(Integer.valueOf(i3), Boolean.TRUE);
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(int i3) {
        this.f88545b.put(Integer.valueOf(i3), Boolean.FALSE);
        f();
    }
}
