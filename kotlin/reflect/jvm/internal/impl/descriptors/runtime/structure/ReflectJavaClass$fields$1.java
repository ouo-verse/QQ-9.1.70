package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes28.dex */
public /* synthetic */ class ReflectJavaClass$fields$1 extends FunctionReference implements Function1<Member, Boolean> {
    public static final ReflectJavaClass$fields$1 INSTANCE = new ReflectJavaClass$fields$1();

    ReflectJavaClass$fields$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    @NotNull
    public final String getName() {
        return "isSynthetic";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(Member.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public final String getSignature() {
        return "isSynthetic()Z";
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull Member p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return Boolean.valueOf(p06.isSynthetic());
    }
}
