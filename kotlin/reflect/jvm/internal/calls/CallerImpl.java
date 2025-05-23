package kotlin.reflect.jvm.internal.calls;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u001e*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\b\u001b\u001c\u001d\u001e\u001f !\"B3\b\u0004\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0004R\u0017\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0001\u0007#$%&'()\u00a8\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "member", "returnType", "Ljava/lang/reflect/Type;", "instanceClass", "Ljava/lang/Class;", "valueParameterTypes", "", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "getInstanceClass", "()Ljava/lang/Class;", "getMember", "()Ljava/lang/reflect/Member;", "Ljava/lang/reflect/Member;", "parameterTypes", "", "getParameterTypes", "()Ljava/util/List;", "getReturnType", "()Ljava/lang/reflect/Type;", "checkObjectInstance", "", "obj", "", "AccessorForHiddenBoundConstructor", "AccessorForHiddenConstructor", "BoundConstructor", "Companion", "Constructor", "FieldGetter", "FieldSetter", "Method", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public abstract class CallerImpl<M extends Member> implements Caller<M> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final Class<?> instanceClass;

    @NotNull
    private final M member;

    @NotNull
    private final List<Type> parameterTypes;

    @NotNull
    private final Type returnType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u0003B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenBoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class AccessorForHiddenBoundConstructor extends CallerImpl<java.lang.reflect.Constructor<?>> implements BoundCaller {

        @Nullable
        private final Object boundReceiver;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccessorForHiddenBoundConstructor(@NotNull java.lang.reflect.Constructor<?> constructor, @Nullable Object obj) {
            super(constructor, r3, r4, (Type[]) r0, null);
            Object[] copyOfRange;
            Object[] objArr;
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Class cls = null;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length > 2) {
                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length - 1);
                Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirstAndLast>");
                objArr = copyOfRange;
            } else {
                objArr = new Type[0];
            }
            this.boundReceiver = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            java.lang.reflect.Constructor<?> mo1771getMember = mo1771getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add(this.boundReceiver);
            spreadBuilder.addSpread(args);
            spreadBuilder.add(null);
            return mo1771getMember.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$AccessorForHiddenConstructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class AccessorForHiddenConstructor extends CallerImpl<java.lang.reflect.Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public AccessorForHiddenConstructor(@NotNull java.lang.reflect.Constructor<?> constructor) {
            super(constructor, r3, r4, (Type[]) r0, null);
            Object[] copyOfRange;
            Object[] objArr;
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Class cls = null;
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            if (genericParameterTypes.length > 1) {
                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(genericParameterTypes, 0, genericParameterTypes.length - 1);
                Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropLast>");
                objArr = copyOfRange;
            } else {
                objArr = new Type[0];
            }
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            java.lang.reflect.Constructor<?> mo1771getMember = mo1771getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(args);
            spreadBuilder.add(null);
            return mo1771getMember.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$BoundConstructor;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "boundReceiver", "", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class BoundConstructor extends CallerImpl<java.lang.reflect.Constructor<?>> implements BoundCaller {

        @Nullable
        private final Object boundReceiver;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public BoundConstructor(@NotNull java.lang.reflect.Constructor<?> constructor, @Nullable Object obj) {
            super(constructor, r3, null, r5, null);
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
            this.boundReceiver = obj;
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            java.lang.reflect.Constructor<?> mo1771getMember = mo1771getMember();
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(this.boundReceiver);
            spreadBuilder.addSpread(args);
            return mo1771getMember.newInstance(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0006J(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0006\b\u0001\u0010\u0005\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u0002H\u00050\u0004H\u0086\b\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Companion;", "", "()V", "dropFirst", "", "T", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstAndLast", "dropLast", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0011\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Constructor;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "constructor", "(Ljava/lang/reflect/Constructor;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static final class Constructor extends CallerImpl<java.lang.reflect.Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Constructor(@NotNull java.lang.reflect.Constructor<?> constructor) {
            super(constructor, r3, r4, r5, null);
            Class<?> cls;
            Intrinsics.checkNotNullParameter(constructor, "constructor");
            Class<?> declaringClass = constructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "constructor.declaringClass");
            Class<?> declaringClass2 = constructor.getDeclaringClass();
            Class<?> declaringClass3 = declaringClass2.getDeclaringClass();
            if (declaringClass3 != null && !Modifier.isStatic(declaringClass2.getModifiers())) {
                cls = declaringClass3;
            } else {
                cls = null;
            }
            Type[] genericParameterTypes = constructor.getGenericParameterTypes();
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "constructor.genericParameterTypes");
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            return mo1771getMember().newInstance(Arrays.copyOf(args, args.length));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\f\r\u000e\u000f\u0010B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u0082\u0001\u0005\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "requiresInstance", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static abstract class FieldGetter extends CallerImpl<Field> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "boundReceiver", "", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class BoundInstance extends FieldGetter implements BoundCaller {

            @Nullable
            private final Object boundReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundInstance(@NotNull Field field, @Nullable Object obj) {
                super(field, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter, kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return mo1771getMember().get(this.boundReceiver);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class BoundJvmStaticInObject extends FieldGetter implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundJvmStaticInObject(@NotNull Field field) {
                super(field, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class Instance extends FieldGetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Instance(@NotNull Field field) {
                super(field, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class JvmStaticInObject extends FieldGetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JvmStaticInObject(@NotNull Field field) {
                super(field, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl
            public void checkArguments(@NotNull Object[] args) {
                Object firstOrNull;
                Intrinsics.checkNotNullParameter(args, "args");
                super.checkArguments(args);
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
                checkObjectInstance(firstOrNull);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldGetter;", "field", "Ljava/lang/reflect/Field;", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class Static extends FieldGetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Static(@NotNull Field field) {
                super(field, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        public /* synthetic */ FieldGetter(Field field, boolean z16, DefaultConstructorMarker defaultConstructorMarker) {
            this(field, z16);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] args) {
            Object obj;
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            Field mo1771getMember = mo1771getMember();
            if (getInstanceClass() != null) {
                obj = ArraysKt___ArraysKt.first(args);
            } else {
                obj = null;
            }
            return mo1771getMember.get(obj);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        FieldGetter(Field field, boolean z16) {
            super(field, r2, z16 ? field.getDeclaringClass() : null, new Type[0], null);
            Type genericType = field.getGenericType();
            Intrinsics.checkNotNullExpressionValue(genericType, "field.genericType");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\u001f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0001\u0005\u0015\u0016\u0017\u0018\u0019\u00a8\u0006\u001a"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static abstract class FieldSetter extends CallerImpl<Field> {
        private final boolean notNull;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0016\u00a2\u0006\u0002\u0010\rR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class BoundInstance extends FieldSetter implements BoundCaller {

            @Nullable
            private final Object boundReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundInstance(@NotNull Field field, boolean z16, @Nullable Object obj) {
                super(field, z16, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.Caller
            @NotNull
            public Object call(@NotNull Object[] args) {
                Object first;
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                Field mo1771getMember = mo1771getMember();
                Object obj = this.boundReceiver;
                first = ArraysKt___ArraysKt.first(args);
                mo1771getMember.set(obj, first);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0016\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class BoundJvmStaticInObject extends FieldSetter implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundJvmStaticInObject(@NotNull Field field, boolean z16) {
                super(field, z16, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.Caller
            @NotNull
            public Object call(@NotNull Object[] args) {
                Object last;
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                Field mo1771getMember = mo1771getMember();
                last = ArraysKt___ArraysKt.last(args);
                mo1771getMember.set(null, last);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class Instance extends FieldSetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Instance(@NotNull Field field, boolean z16) {
                super(field, z16, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class JvmStaticInObject extends FieldSetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JvmStaticInObject(@NotNull Field field, boolean z16) {
                super(field, z16, true, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter, kotlin.reflect.jvm.internal.calls.CallerImpl
            public void checkArguments(@NotNull Object[] args) {
                Object firstOrNull;
                Intrinsics.checkNotNullParameter(args, "args");
                super.checkArguments(args);
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
                checkObjectInstance(firstOrNull);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class Static extends FieldSetter {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Static(@NotNull Field field, boolean z16) {
                super(field, z16, false, null);
                Intrinsics.checkNotNullParameter(field, "field");
            }
        }

        public /* synthetic */ FieldSetter(Field field, boolean z16, boolean z17, DefaultConstructorMarker defaultConstructorMarker) {
            this(field, z16, z17);
        }

        @Override // kotlin.reflect.jvm.internal.calls.Caller
        @Nullable
        public Object call(@NotNull Object[] args) {
            Object obj;
            Object last;
            Intrinsics.checkNotNullParameter(args, "args");
            checkArguments(args);
            Field mo1771getMember = mo1771getMember();
            if (getInstanceClass() != null) {
                obj = ArraysKt___ArraysKt.first(args);
            } else {
                obj = null;
            }
            last = ArraysKt___ArraysKt.last(args);
            mo1771getMember.set(obj, last);
            return Unit.INSTANCE;
        }

        @Override // kotlin.reflect.jvm.internal.calls.CallerImpl
        public void checkArguments(@NotNull Object[] args) {
            Object last;
            Intrinsics.checkNotNullParameter(args, "args");
            super.checkArguments(args);
            if (this.notNull) {
                last = ArraysKt___ArraysKt.last(args);
                if (last == null) {
                    throw new IllegalArgumentException("null is not allowed as a value for this property.");
                }
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        FieldSetter(Field field, boolean z16, boolean z17) {
            super(field, TYPE, r3, new Type[]{r9}, null);
            Class TYPE = Void.TYPE;
            Intrinsics.checkNotNullExpressionValue(TYPE, "TYPE");
            Class<?> declaringClass = z17 ? field.getDeclaringClass() : null;
            Type genericType = field.getGenericType();
            Intrinsics.checkNotNullExpressionValue(genericType, "field.genericType");
            this.notNull = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0010\u0011\u0012\u0013\u0014\u0015B)\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ%\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0004\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0001\u0006\u0016\u0017\u0018\u0019\u001a\u001b\u00a8\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Method;", "method", "requiresInstance", "", "parameterTypes", "", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "isVoidMethod", "callMethod", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "args", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "BoundInstance", "BoundJvmStaticInObject", "BoundStatic", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes28.dex */
    public static abstract class Method extends CallerImpl<java.lang.reflect.Method> {
        private final boolean isVoidMethod;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class BoundInstance extends Method implements BoundCaller {

            @Nullable
            private final Object boundReceiver;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundInstance(@NotNull java.lang.reflect.Method method, @Nullable Object obj) {
                super(method, false, null, 4, null);
                Intrinsics.checkNotNullParameter(method, "method");
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return callMethod(this.boundReceiver, args);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundJvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class BoundJvmStaticInObject extends Method implements BoundCaller {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public BoundJvmStaticInObject(@NotNull java.lang.reflect.Method method) {
                super(method, false, null, 4, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return callMethod(null, args);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016\u00a2\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class BoundStatic extends Method implements BoundCaller {

            @Nullable
            private final Object boundReceiver;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public BoundStatic(@NotNull java.lang.reflect.Method method, @Nullable Object obj) {
                super(method, r2, (Type[]) r0, null);
                Object copyOfRange;
                Intrinsics.checkNotNullParameter(method, "method");
                Type[] genericParameterTypes = method.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "method.genericParameterTypes");
                boolean z16 = false;
                if (genericParameterTypes.length > 1) {
                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
                    Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                } else {
                    copyOfRange = new Type[0];
                }
                this.boundReceiver = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(this.boundReceiver);
                spreadBuilder.addSpread(args);
                return callMethod(null, spreadBuilder.toArray(new Object[spreadBuilder.size()]));
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class Instance extends Method {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Instance(@NotNull java.lang.reflect.Method method) {
                super(method, false, null, 6, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] args) {
                Object[] copyOfRange;
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                Object obj = args[0];
                if (args.length > 1) {
                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(args, 1, args.length);
                    Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                } else {
                    copyOfRange = new Object[0];
                }
                return callMethod(obj, copyOfRange);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class JvmStaticInObject extends Method {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public JvmStaticInObject(@NotNull java.lang.reflect.Method method) {
                super(method, true, null, 4, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] args) {
                Object firstOrNull;
                Object[] copyOfRange;
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
                checkObjectInstance(firstOrNull);
                if (args.length > 1) {
                    copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(args, 1, args.length);
                    Intrinsics.checkNotNull(copyOfRange, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
                } else {
                    copyOfRange = new Object[0];
                }
                return callMethod(null, copyOfRange);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes28.dex */
        public static final class Static extends Method {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Static(@NotNull java.lang.reflect.Method method) {
                super(method, false, null, 6, null);
                Intrinsics.checkNotNullParameter(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.Caller
            @Nullable
            public Object call(@NotNull Object[] args) {
                Intrinsics.checkNotNullParameter(args, "args");
                checkArguments(args);
                return callMethod(null, args);
            }
        }

        public /* synthetic */ Method(java.lang.reflect.Method method, boolean z16, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
            this(method, z16, typeArr);
        }

        @Nullable
        protected final Object callMethod(@Nullable Object instance, @NotNull Object[] args) {
            Intrinsics.checkNotNullParameter(args, "args");
            Object invoke = mo1771getMember().invoke(instance, Arrays.copyOf(args, args.length));
            if (this.isVoidMethod) {
                return Unit.INSTANCE;
            }
            return invoke;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Method(java.lang.reflect.Method method, boolean z16, Type[] typeArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(method, z16, typeArr, null);
            z16 = (i3 & 2) != 0 ? !Modifier.isStatic(method.getModifiers()) : z16;
            if ((i3 & 4) != 0) {
                typeArr = method.getGenericParameterTypes();
                Intrinsics.checkNotNullExpressionValue(typeArr, "method.genericParameterTypes");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Method(java.lang.reflect.Method method, boolean z16, Type[] typeArr) {
            super(method, r2, z16 ? method.getDeclaringClass() : null, typeArr, null);
            Type genericReturnType = method.getGenericReturnType();
            Intrinsics.checkNotNullExpressionValue(genericReturnType, "method.genericReturnType");
            this.isVoidMethod = Intrinsics.areEqual(getReturnType(), Void.TYPE);
        }
    }

    public /* synthetic */ CallerImpl(Member member, Type type, Class cls, Type[] typeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(member, type, cls, typeArr);
    }

    public void checkArguments(@NotNull Object[] objArr) {
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    protected final void checkObjectInstance(@Nullable Object obj) {
        if (obj != null && this.member.getDeclaringClass().isInstance(obj)) {
        } else {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Nullable
    public final Class<?> getInstanceClass() {
        return this.instanceClass;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    /* renamed from: getMember */
    public final M mo1771getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @Override // kotlin.reflect.jvm.internal.calls.Caller
    @NotNull
    public final Type getReturnType() {
        return this.returnType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0025, code lost:
    
        if (r1 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    CallerImpl(M m3, Type type, Class<?> cls, Type[] typeArr) {
        List<Type> list;
        this.member = m3;
        this.returnType = type;
        this.instanceClass = cls;
        if (cls != null) {
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.add(cls);
            spreadBuilder.addSpread(typeArr);
            list = CollectionsKt__CollectionsKt.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
        }
        list = ArraysKt___ArraysKt.toList(typeArr);
        this.parameterTypes = list;
    }
}
