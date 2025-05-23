package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016\u00a2\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {

    @NotNull
    private final Caller<M> caller;

    @NotNull
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0086\u0002\u00a2\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0086\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    private static final class BoxUnboxData {

        @NotNull
        private final IntRange argumentRange;

        @Nullable
        private final Method box;

        @NotNull
        private final Method[] unbox;

        public BoxUnboxData(@NotNull IntRange argumentRange, @NotNull Method[] unbox, @Nullable Method method) {
            Intrinsics.checkNotNullParameter(argumentRange, "argumentRange");
            Intrinsics.checkNotNullParameter(unbox, "unbox");
            this.argumentRange = argumentRange;
            this.unbox = unbox;
            this.box = method;
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final IntRange getArgumentRange() {
            return this.argumentRange;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final Method[] getUnbox() {
            return this.unbox;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Method getBox() {
            return this.box;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
    
        if ((r12 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InlineClassAwareCaller(@NotNull CallableMemberDescriptor descriptor, @NotNull Caller<? extends M> caller, boolean z16) {
        Method method;
        KotlinType kotlinType;
        int i3;
        int i16;
        IntRange until;
        BoxUnboxData boxUnboxData;
        boolean z17;
        Method method2;
        Class<?> inlineClass;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(caller, "caller");
        this.caller = caller;
        this.isDefault = z16;
        KotlinType returnType = descriptor.getReturnType();
        Intrinsics.checkNotNull(returnType);
        Class<?> inlineClass2 = InlineClassAwareCallerKt.toInlineClass(returnType);
        if (inlineClass2 != null) {
            method = InlineClassAwareCallerKt.getBoxMethod(inlineClass2, descriptor);
        } else {
            method = null;
        }
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(descriptor)) {
            boxUnboxData = new BoxUnboxData(IntRange.INSTANCE.getEMPTY(), new Method[0], method);
        } else {
            int i17 = -1;
            if (!(caller instanceof CallerImpl.Method.BoundStatic)) {
                if (!(descriptor instanceof ConstructorDescriptor)) {
                    if (descriptor.getDispatchReceiverParameter() != null && !(caller instanceof BoundCaller)) {
                        DeclarationDescriptor containingDeclaration = descriptor.getContainingDeclaration();
                        Intrinsics.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
                        if (!InlineClassesUtilsKt.isInlineClass(containingDeclaration)) {
                            i17 = 1;
                        }
                    }
                    i17 = 0;
                }
            }
            ArrayList arrayList = new ArrayList();
            ReceiverParameterDescriptor extensionReceiverParameter = descriptor.getExtensionReceiverParameter();
            if (extensionReceiverParameter != null) {
                kotlinType = extensionReceiverParameter.getType();
            } else {
                kotlinType = null;
            }
            if (kotlinType != null) {
                arrayList.add(kotlinType);
            } else if (descriptor instanceof ConstructorDescriptor) {
                ClassDescriptor constructedClass = ((ConstructorDescriptor) descriptor).getConstructedClass();
                Intrinsics.checkNotNullExpressionValue(constructedClass, "descriptor.constructedClass");
                if (constructedClass.isInner()) {
                    DeclarationDescriptor containingDeclaration2 = constructedClass.getContainingDeclaration();
                    Intrinsics.checkNotNull(containingDeclaration2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    arrayList.add(((ClassDescriptor) containingDeclaration2).getDefaultType());
                }
            } else {
                DeclarationDescriptor containingDeclaration3 = descriptor.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration3, "descriptor.containingDeclaration");
                if ((containingDeclaration3 instanceof ClassDescriptor) && InlineClassesUtilsKt.isInlineClass(containingDeclaration3)) {
                    arrayList.add(((ClassDescriptor) containingDeclaration3).getDefaultType());
                }
            }
            List<ValueParameterDescriptor> valueParameters = descriptor.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "descriptor.valueParameters");
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                arrayList.add(((ValueParameterDescriptor) it.next()).getType());
            }
            if (this.isDefault) {
                i3 = (((arrayList.size() + 32) - 1) / 32) + 1;
            } else {
                i3 = 0;
            }
            if ((descriptor instanceof FunctionDescriptor) && ((FunctionDescriptor) descriptor).isSuspend()) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            int size = arrayList.size() + i17 + i3 + i16;
            if (CallerKt.getArity(this) == size) {
                until = RangesKt___RangesKt.until(Math.max(i17, 0), arrayList.size() + i17);
                Method[] methodArr = new Method[size];
                for (int i18 = 0; i18 < size; i18++) {
                    int first = until.getFirst();
                    if (i18 <= until.getLast() && first <= i18) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17 && (inlineClass = InlineClassAwareCallerKt.toInlineClass((KotlinType) arrayList.get(i18 - i17))) != null) {
                        method2 = InlineClassAwareCallerKt.getUnboxMethod(inlineClass, descriptor);
                    } else {
                        method2 = null;
                    }
                    methodArr[i18] = method2;
                }
                boxUnboxData = new BoxUnboxData(until, methodArr, method);
            } else {
                throw new KotlinReflectionInternalError("Inconsistent number of parameters in the descriptor and Java reflection object: " + CallerKt.getArity(this) + " != " + size + "\nCalling: " + descriptor + "\nParameter types: " + getParameterTypes() + ")\nDefault: " + this.isDefault);
            }
        }
        this.data = boxUnboxData;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @Nullable
    public Object call(@NotNull Object[] args) {
        Object invoke;
        Intrinsics.checkNotNullParameter(args, "args");
        BoxUnboxData boxUnboxData = this.data;
        IntRange argumentRange = boxUnboxData.getArgumentRange();
        Method[] unbox = boxUnboxData.getUnbox();
        Method box = boxUnboxData.getBox();
        Object[] copyOf = Arrays.copyOf(args, args.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        Intrinsics.checkNotNull(copyOf, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        int first = argumentRange.getFirst();
        int last = argumentRange.getLast();
        if (first <= last) {
            while (true) {
                Method method = unbox[first];
                Object obj = args[first];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        Intrinsics.checkNotNullExpressionValue(returnType, "method.returnType");
                        obj = UtilKt.defaultPrimitiveValue(returnType);
                    }
                }
                copyOf[first] = obj;
                if (first == last) {
                    break;
                }
                first++;
            }
        }
        Object call = this.caller.call(copyOf);
        if (box != null && (invoke = box.invoke(null, call)) != null) {
            return invoke;
        }
        return call;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    /* renamed from: getMember */
    public M mo1771getMember() {
        return this.caller.mo1771getMember();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public Type getReturnType() {
        return this.caller.getReturnType();
    }
}
