package com.tencent.kuikly.core.directives;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.ab;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/directives/a;", "Lcom/tencent/kuikly/core/base/ab;", "Lcom/tencent/kuikly/core/base/m;", "Lcom/tencent/kuikly/core/base/event/Event;", "j", "createEvent", "l", "()Lcom/tencent/kuikly/core/directives/a;", "prevDirectivesView", "k", "nextDirectivesView", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class a extends ab<m, Event> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public Event createEvent() {
        return new Event();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public m createAttr() {
        return new m();
    }

    public final a k() {
        int indexOf;
        int lastIndex;
        ViewContainer<?, ?> parent = getParent();
        if (!(parent instanceof ViewContainer)) {
            parent = null;
        }
        List<DeclarativeBaseView<?, ?>> templateChildren = parent != null ? parent.templateChildren() : null;
        if (templateChildren != null && !templateChildren.isEmpty() && (indexOf = templateChildren.indexOf(this)) >= 0) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(templateChildren);
            if (indexOf != lastIndex) {
                DeclarativeBaseView<?, ?> declarativeBaseView = templateChildren.get(indexOf + 1);
                if (declarativeBaseView instanceof a) {
                    return (a) declarativeBaseView;
                }
            }
        }
        return null;
    }

    public final a l() {
        int indexOf;
        ViewContainer<?, ?> parent = getParent();
        if (!(parent instanceof ViewContainer)) {
            parent = null;
        }
        List<DeclarativeBaseView<?, ?>> templateChildren = parent != null ? parent.templateChildren() : null;
        if (templateChildren == null || templateChildren.isEmpty() || templateChildren.indexOf(this) - 1 < 0) {
            return null;
        }
        DeclarativeBaseView<?, ?> declarativeBaseView = templateChildren.get(indexOf);
        if (declarativeBaseView instanceof a) {
            return (a) declarativeBaseView;
        }
        return null;
    }
}
