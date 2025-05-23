package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProElemType implements Serializable {
    public static final int ELEM_TYPE_AT = 6;
    public static final int ELEM_TYPE_CHANNEL = 7;
    public static final int ELEM_TYPE_EMOJI = 5;
    public static final int ELEM_TYPE_GROUP = 9;
    public static final int ELEM_TYPE_IMAGE = 2;
    public static final int ELEM_TYPE_LINEBREAK = 10;
    public static final int ELEM_TYPE_RESERVE = 0;
    public static final int ELEM_TYPE_TEXT = 1;
    public static final int ELEM_TYPE_TOPIC = 8;
    public static final int ELEM_TYPE_URL = 4;
    public static final int ELEM_TYPE_VIDEO = 3;
    long serialVersionUID = 1;

    public String toString() {
        return "GProElemType{}";
    }
}
