package com.tencent.qqlive.module.videoreport.sample.samplenode;

import java.util.Objects;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleVMatchNode extends SampleNode {
    private final String value;

    public SampleVMatchNode(String str) {
        this.value = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.value, ((SampleVMatchNode) obj).value);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.value);
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode
    public boolean matched(String str) {
        String str2 = this.value;
        if (str2 != null) {
            return str2.equals(str);
        }
        return false;
    }

    public String value() {
        return this.value;
    }
}
