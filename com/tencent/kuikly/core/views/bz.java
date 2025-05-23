package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.ViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/views/bz;", "Lcom/tencent/kuikly/core/base/ViewContainer;", "Lcom/tencent/kuikly/core/views/bw;", "Lcom/tencent/kuikly/core/views/bx;", tl.h.F, "i", "", "viewName", "Lcom/tencent/kuikly/core/views/bz$a;", "a", "Lcom/tencent/kuikly/core/views/bz$a;", "j", "()Lcom/tencent/kuikly/core/views/bz$a;", "setState$core_release", "(Lcom/tencent/kuikly/core/views/bz$a;)V", "state", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class bz extends ViewContainer<bw, bx> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private a state = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR+\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/views/bz$a;", "", "", "<set-?>", "a", "Lkotlin/properties/ReadWriteProperty;", "()Z", "b", "(Z)V", "selected", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f118427b = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(a.class, "selected", "getSelected()Z", 0))};

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final ReadWriteProperty selected = c01.c.a(Boolean.FALSE);

        public final boolean a() {
            return ((Boolean) this.selected.getValue(this, f118427b[0])).booleanValue();
        }

        public final void b(boolean z16) {
            this.selected.setValue(this, f118427b[0], Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public bw createAttr() {
        return new bw();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public bx createEvent() {
        return new bx();
    }

    /* renamed from: j, reason: from getter */
    public final a getState() {
        return this.state;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRView";
    }
}
