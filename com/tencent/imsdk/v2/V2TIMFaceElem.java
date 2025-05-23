package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.FaceElement;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMFaceElem extends V2TIMElem {
    private byte[] data;
    private int index = 0;

    public byte[] getData() {
        if (getElement() == null) {
            return this.data;
        }
        return ((FaceElement) getElement()).getFaceData();
    }

    public int getIndex() {
        if (getElement() == null) {
            return this.index;
        }
        return ((FaceElement) getElement()).getFaceIndex();
    }

    public void setData(byte[] bArr) {
        if (getElement() == null) {
            this.data = bArr;
        } else {
            ((FaceElement) getElement()).setFaceData(bArr);
        }
    }

    public void setIndex(int i3) {
        if (getElement() == null) {
            this.index = i3;
        } else {
            ((FaceElement) getElement()).setFaceIndex(i3);
        }
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("V2TIMFaceElem--->");
        sb5.append("index:");
        sb5.append(getIndex());
        sb5.append(", has data:");
        if (getData() == null) {
            str = "false";
        } else {
            str = "true";
        }
        sb5.append(str);
        return sb5.toString();
    }
}
