package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.kuikly.core.base.v;
import com.tencent.kuikly.core.base.w;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQComposeMarkdownViewShadow extends v {
    public boolean calculateFromCache;
    public boolean isDirty;
    public Float lastHeight;
    public w lastSize;
    public Float lastWidth;

    public QQComposeMarkdownViewShadow(String str, int i3) {
        super(str, i3, "QQComposeMarkdownView");
        this.isDirty = true;
    }

    @Override // com.tencent.kuikly.core.base.v
    public final w calculateRenderViewSize(float f16, float f17) {
        w wVar;
        if (!this.isDirty && Intrinsics.areEqual(this.lastWidth, f16) && Intrinsics.areEqual(this.lastHeight, f17) && (wVar = this.lastSize) != null) {
            this.calculateFromCache = true;
            Intrinsics.checkNotNull(wVar);
            return wVar;
        }
        this.calculateFromCache = false;
        w calculateRenderViewSize = super.calculateRenderViewSize(f16, f17);
        this.isDirty = false;
        this.lastWidth = Float.valueOf(f16);
        this.lastHeight = Float.valueOf(f17);
        this.lastSize = calculateRenderViewSize;
        return calculateRenderViewSize;
    }

    @Override // com.tencent.kuikly.core.base.v
    public final void setProp(String str, Object obj) {
        super.setProp(str, obj);
        if (this.isDirty) {
            return;
        }
        this.isDirty = true;
        this.lastSize = null;
    }
}
