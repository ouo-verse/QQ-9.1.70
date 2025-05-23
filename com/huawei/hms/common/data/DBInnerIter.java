package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes2.dex */
public class DBInnerIter<O> implements Iterator<O> {
    protected final DataBuffer<O> dataBuffer;
    protected int index = -1;

    public DBInnerIter(DataBuffer<O> dataBuffer) {
        Preconditions.checkNotNull(dataBuffer, "dataBuffer cannot be null");
        this.dataBuffer = dataBuffer;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index + 1 < this.dataBuffer.getCount()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public O next() {
        if (hasNext()) {
            DataBuffer<O> dataBuffer = this.dataBuffer;
            int i3 = this.index + 1;
            this.index = i3;
            return dataBuffer.get(i3);
        }
        return null;
    }
}
