package com.tencent.kuikly.core.reactive;

import c01.b;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000  *\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0011B\u0019\u0012\u0006\u0010\t\u001a\u00028\u0000\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\u0007\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0004J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0004R\"\u0010\t\u001a\u00028\u00008\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/reactive/a;", "V", "Lkotlin/properties/ReadWriteProperty;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", HippyTextInputController.COMMAND_getValue, "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "", HippyTextInputController.COMMAND_setValue, "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "", "propertyName", "f", "g", "a", "Ljava/lang/Object;", "e", "()Ljava/lang/Object;", h.F, "(Ljava/lang/Object;)V", "Lc01/b;", "b", "Lc01/b;", "handler", "c", "Ljava/lang/String;", "propertyOwnerId", "<init>", "(Ljava/lang/Object;Lc01/b;)V", "d", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class a<V> implements ReadWriteProperty<Object, V> {

    /* renamed from: e, reason: collision with root package name */
    private static int f117471e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private V value;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final b handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String propertyOwnerId;

    public a(V v3, b bVar) {
        this.value = v3;
        this.handler = bVar;
        int i3 = f117471e;
        f117471e = i3 + 1;
        this.propertyOwnerId = String.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final V e() {
        return this.value;
    }

    protected final void f(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        b bVar = this.handler;
        if (bVar != null) {
            bVar.b(this.propertyOwnerId, propertyName);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(String propertyName) {
        Intrinsics.checkNotNullParameter(propertyName, "propertyName");
        b bVar = this.handler;
        if (bVar != null) {
            bVar.a(this.propertyOwnerId, propertyName);
        }
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(Object thisRef, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        f(property.getName());
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(V v3) {
        this.value = v3;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object thisRef, KProperty<?> property, V value) {
        Intrinsics.checkNotNullParameter(property, "property");
        if (Intrinsics.areEqual(this.value, value)) {
            return;
        }
        this.value = value;
        g(property.getName());
    }
}
