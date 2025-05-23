package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class MirrorInfo {
    public boolean isHorizontal;
    public boolean isVertical;

    public MirrorInfo() {
        this.isHorizontal = false;
        this.isVertical = false;
    }

    public MirrorInfo(boolean z16, boolean z17) {
        this.isHorizontal = z16;
        this.isVertical = z17;
    }
}
