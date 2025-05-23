package com.tencent.qqlive.module.videoreport.sample.samplenode;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class SampleNode {
    public static final String EMPTY_CHARACTER = "";
    public static final String WILDCARD_CHARACTER = "*";
    private final List<SampleNode> children = new ArrayList();

    public SampleNode addChildren(SampleNode sampleNode) {
        for (SampleNode sampleNode2 : this.children) {
            if (sampleNode2.equals(sampleNode)) {
                return sampleNode2;
            }
        }
        if (sampleNode instanceof SampleRateNode) {
            this.children.clear();
            this.children.add(sampleNode);
        } else {
            this.children.add(sampleNode);
        }
        return sampleNode;
    }

    public List<SampleNode> children() {
        return this.children;
    }

    public boolean matched(String str) {
        return false;
    }

    public boolean matched(String str, String str2) {
        return false;
    }
}
