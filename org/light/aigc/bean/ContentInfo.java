package org.light.aigc.bean;

import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ContentInfo {
    public byte[] byteData;
    public String extra;
    public MediaScene scene;
    public String stringData;
    public MediaType type;

    public String toString() {
        return "ContentInfo{type=" + this.type + ", byteData=" + Arrays.toString(this.byteData) + ", stringData='" + this.stringData + "', scene=" + this.scene + ", extra='" + this.extra + "'}";
    }
}
