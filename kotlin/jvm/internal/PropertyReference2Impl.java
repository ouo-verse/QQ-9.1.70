package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: classes28.dex */
public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty2
    public Object get(Object obj, Object obj2) {
        return getGetter().call(obj, obj2);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference2Impl(Class cls, String str, String str2, int i3) {
        super(cls, str, str2, i3);
    }
}
