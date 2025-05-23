package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class URL implements Serializable {
    long serialVersionUID = 1;
    public Specification spec = Specification.values()[0];
    public String url = "";

    public Specification getSpec() {
        return this.spec;
    }

    public String getUrl() {
        return this.url;
    }

    public void setSpec(Specification specification) {
        this.spec = specification;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
