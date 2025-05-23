package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProSchemeConfig implements Serializable {
    long serialVersionUID = 1;
    public String schema = "";
    public String text = "";

    public String getSchema() {
        return this.schema;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProSchemeConfig{schema=" + this.schema + ",text=" + this.text + ",}";
    }
}
