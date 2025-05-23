package com.eclipsesource.mmv8.utils;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class SingleTypeAdapter implements TypeAdapter {
    private int typeToAdapt;

    public SingleTypeAdapter(int i3) {
        this.typeToAdapt = i3;
    }

    @Override // com.eclipsesource.mmv8.utils.TypeAdapter
    public Object adapt(int i3, Object obj) {
        if (i3 == this.typeToAdapt) {
            return adapt(obj);
        }
        return TypeAdapter.DEFAULT;
    }

    public abstract Object adapt(Object obj);
}
