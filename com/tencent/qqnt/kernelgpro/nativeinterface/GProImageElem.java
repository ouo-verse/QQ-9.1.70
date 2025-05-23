package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProImageElem implements Serializable {
    long serialVersionUID = 1;
    public GProStImage image = new GProStImage();
    public GProImageProps props = new GProImageProps();

    public GProStImage getImage() {
        return this.image;
    }

    public GProImageProps getProps() {
        return this.props;
    }

    public String toString() {
        return "GProImageElem{image=" + this.image + ",props=" + this.props + ",}";
    }
}
