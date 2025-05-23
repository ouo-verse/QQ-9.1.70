package com.tencent.kuikly.core.views;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\nJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u000f\u0010\t\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/views/cm;", "Lcom/tencent/kuikly/core/views/aq;", "Lcom/tencent/kuikly/core/views/ck;", "Lcom/tencent/kuikly/core/views/cl;", "Lcom/tencent/kuikly/core/views/ScrollerContentView;", "createContentView", tl.h.F, "i", "", "j", "()V", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class cm extends aq<ck, cl> {
    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView
    public ScrollerContentView createContentView() {
        return new WaterfallContentView();
    }

    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ck createAttr() {
        return new ck();
    }

    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public cl createEvent() {
        return new cl();
    }

    public final void j() {
        if (getLastFrameSize() != null) {
            ScrollerContentView contentView = getContentView();
            WaterfallContentView waterfallContentView = contentView instanceof WaterfallContentView ? (WaterfallContentView) contentView : null;
            if (waterfallContentView != null) {
                waterfallContentView.A();
            }
        }
    }
}
