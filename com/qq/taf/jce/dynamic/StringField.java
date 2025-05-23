package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public class StringField extends JceField {
    private String data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringField(String str, int i3) {
        super(i3);
        this.data = str;
    }

    public String get() {
        return this.data;
    }

    public void set(String str) {
        this.data = str;
    }
}
