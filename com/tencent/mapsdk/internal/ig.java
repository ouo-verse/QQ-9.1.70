package com.tencent.mapsdk.internal;

import java.util.ArrayList;
import java.util.Iterator;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class ig extends ie {

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<ie> f148785g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ig(ie... ieVarArr) {
        super(0L);
        long j3 = 0;
        this.f148785g = new ArrayList<>();
        for (int i3 = 0; i3 < ieVarArr.length; i3++) {
            this.f148785g.add(ieVarArr[i3]);
            j3 = Math.max(j3, ieVarArr[i3].a());
        }
        this.f148778e = j3;
    }

    @Override // com.tencent.mapsdk.internal.ie
    protected final void a(GL10 gl10, long j3) {
        ArrayList<ie> arrayList = this.f148785g;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ie> it = this.f148785g.iterator();
            while (it.hasNext()) {
                ie next = it.next();
                if (!next.c()) {
                    next.a(gl10);
                }
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.ie
    public final void b() {
        super.b();
        Iterator<ie> it = this.f148785g.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mapsdk.internal.ie
    public final void d() {
        super.d();
        Iterator<ie> it = this.f148785g.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }
}
