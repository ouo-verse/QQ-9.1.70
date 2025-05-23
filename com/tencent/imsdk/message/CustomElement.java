package com.tencent.imsdk.message;

/* compiled from: P */
/* loaded from: classes7.dex */
public class CustomElement extends MessageBaseElement {
    private byte[] data;
    private String description;
    private byte[] extension;
    private byte[] sound;

    public CustomElement() {
        setElementType(2);
    }

    public byte[] getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    public byte[] getExtension() {
        return this.extension;
    }

    public byte[] getSound() {
        return this.sound;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setExtension(byte[] bArr) {
        this.extension = bArr;
    }

    public void setSound(byte[] bArr) {
        this.sound = bArr;
    }
}
