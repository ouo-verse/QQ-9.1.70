package com.tencent.luggage.wxa.kj;

import android.util.SparseIntArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k0 extends SparseIntArray {
    public boolean a(v vVar) {
        int indexOfKey;
        if (vVar == null || (indexOfKey = super.indexOfKey(vVar.getComponentId())) < 0) {
            return false;
        }
        super.removeAt(indexOfKey);
        return true;
    }

    public boolean b(v vVar) {
        if (vVar == null || super.indexOfKey(vVar.getComponentId()) >= 0) {
            return false;
        }
        super.put(vVar.getComponentId(), vVar.getComponentId());
        return true;
    }
}
