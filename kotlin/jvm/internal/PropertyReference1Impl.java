package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* loaded from: classes28.dex */
public class PropertyReference1Impl extends PropertyReference1 {
    public PropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference1Impl(Class cls, String str, String str2, int i3) {
        super(CallableReference.NO_RECEIVER, cls, str, str2, i3);
    }

    @SinceKotlin(version = "1.4")
    public PropertyReference1Impl(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, i3);
    }
}
