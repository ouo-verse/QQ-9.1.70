package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/views/ax;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/av;", "Lcom/tencent/kuikly/core/views/aw;", tl.h.F, "i", "", "viewName", "", "willInit", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ax extends DeclarativeBaseView<av, aw> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public av createAttr() {
        return new av();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public aw createEvent() {
        return new aw();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRLottieView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        ((av) getViewAttr()).h(true);
        ((av) getViewAttr()).autoPlay(true);
    }
}
