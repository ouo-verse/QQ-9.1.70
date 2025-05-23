package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.views.internal.GroupView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/kuikly/core/views/v;", "Lcom/tencent/kuikly/core/views/internal/GroupView;", "Lcom/tencent/kuikly/core/views/t;", "Lcom/tencent/kuikly/core/views/u;", tl.h.F, "i", "", "viewName", "", "isRenderView", "", "bringToFront", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class v extends GroupView<t, u> {
    @Override // com.tencent.kuikly.core.views.internal.GroupView
    public void bringToFront() {
        super.bringToFront();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public t createAttr() {
        return new t();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public u createEvent() {
        return new u();
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public boolean isRenderView() {
        return isRenderViewForFlatLayer$core_release();
    }

    @Override // com.tencent.kuikly.core.views.internal.GroupView, com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }
}
