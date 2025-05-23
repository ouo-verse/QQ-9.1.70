package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProParagraph implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProElem> elems = new ArrayList<>();
    public GProParagraphProps props = new GProParagraphProps();

    public ArrayList<GProElem> getElems() {
        return this.elems;
    }

    public GProParagraphProps getProps() {
        return this.props;
    }

    public String toString() {
        return "GProParagraph{elems=" + this.elems + ",props=" + this.props + ",}";
    }
}
