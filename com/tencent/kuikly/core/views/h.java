package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/views/h;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/f;", "Lcom/tencent/kuikly/core/views/g;", "", "didInit", tl.h.F, "i", "", "viewName", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class h extends DeclarativeBaseView<f, g> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        ((f) getAttr()).size(20.0f, 20.0f);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public f createAttr() {
        return new f();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public g createEvent() {
        return new g();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRActivityIndicatorView";
    }
}
