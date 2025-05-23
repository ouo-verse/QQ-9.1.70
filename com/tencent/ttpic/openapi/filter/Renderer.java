package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.internal.Frame;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Renderer {
    Frame process(Frame frame);

    void release();
}
