package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LongField extends NumberField {
    private long data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LongField(long j3, int i3) {
        super(i3);
        this.data = j3;
    }

    public long get() {
        return this.data;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        return Long.valueOf(this.data);
    }

    public void set(long j3) {
        this.data = j3;
    }
}
