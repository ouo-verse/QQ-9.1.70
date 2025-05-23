package com.tencent.qqlive.module.videoreport.sample.samplenode;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.sample.model.SampleConfig;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleKVMatchNode extends SampleNode {
    private final SampleConfig.Param[] params;

    public SampleKVMatchNode(SampleConfig.Param[] paramArr) {
        this.params = paramArr;
    }

    private boolean valueMatched(String str, String[] strArr) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Arrays.equals(this.params, ((SampleKVMatchNode) obj).params);
        }
        return false;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + Arrays.hashCode(this.params);
    }

    @Override // com.tencent.qqlive.module.videoreport.sample.samplenode.SampleNode
    public boolean matched(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (SampleConfig.Param param : this.params) {
            if (str.equals(param.key)) {
                return valueMatched(str2, param.values);
            }
        }
        return false;
    }

    public SampleConfig.Param[] params() {
        return this.params;
    }
}
