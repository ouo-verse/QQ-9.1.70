package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i3, KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(i3, CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i3, Class cls, String str, String str2, int i16) {
        super(i3, CallableReference.NO_RECEIVER, cls, str, str2, i16);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i3, Object obj, Class cls, String str, String str2, int i16) {
        super(i3, obj, cls, str, str2, i16);
    }
}
