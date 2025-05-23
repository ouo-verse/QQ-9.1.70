package com.tencent.imsdk.message;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageBaseElement implements Serializable {
    public static int UUID_TYPE_AUDIO = 3;
    public static int UUID_TYPE_FILE = 1;
    public static int UUID_TYPE_VIDEO = 2;
    public static int UUID_TYPE_VIDEO_THUMB;
    protected int elementType;

    public int getElementType() {
        return this.elementType;
    }

    public void setElementType(int i3) {
        this.elementType = i3;
    }

    public boolean update(MessageBaseElement messageBaseElement) {
        return false;
    }
}
