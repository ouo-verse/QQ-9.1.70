package kotlin.reflect.full;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a9\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0016H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"extensionReceiverParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getExtensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "instanceParameter", "getInstanceParameter$annotations", "getInstanceParameter", "valueParameters", "", "getValueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "callSuspend", BdhLogUtil.LogTag.Tag_Req, "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findParameterByName", "name", "", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
@JvmName(name = "KCallables")
/* loaded from: classes28.dex */
public final class KCallables {
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @SinceKotlin(version = "1.3")
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspend(@NotNull KCallable<? extends R> kCallable, @NotNull Object[] objArr, @NotNull Continuation<? super R> continuation) {
        KCallables$callSuspend$1 kCallables$callSuspend$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        Object coroutine_suspended2;
        if (continuation instanceof KCallables$callSuspend$1) {
            kCallables$callSuspend$1 = (KCallables$callSuspend$1) continuation;
            int i16 = kCallables$callSuspend$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspend$1.label = i16 - Integer.MIN_VALUE;
                obj = kCallables$callSuspend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = kCallables$callSuspend$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        kCallable = (KCallable) kCallables$callSuspend$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.call(Arrays.copyOf(objArr, objArr.length));
                    }
                    if (kCallable instanceof KFunction) {
                        kCallables$callSuspend$1.L$0 = kCallable;
                        kCallables$callSuspend$1.L$1 = objArr;
                        kCallables$callSuspend$1.label = 1;
                        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                        spreadBuilder.addSpread(objArr);
                        spreadBuilder.add(kCallables$callSuspend$1);
                        obj = kCallable.call(spreadBuilder.toArray(new Object[spreadBuilder.size()]));
                        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (obj == coroutine_suspended2) {
                            DebugProbes.probeCoroutineSuspended(kCallables$callSuspend$1);
                        }
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspend on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                }
                if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) && !kCallable.getReturnType().isMarkedNullable()) {
                    return Unit.INSTANCE;
                }
                return obj;
            }
        }
        kCallables$callSuspend$1 = new KCallables$callSuspend$1(continuation);
        obj = kCallables$callSuspend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = kCallables$callSuspend$1.label;
        if (i3 == 0) {
        }
        if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @SinceKotlin(version = "1.3")
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object callSuspendBy(@NotNull KCallable<? extends R> kCallable, @NotNull Map<KParameter, ? extends Object> map, @NotNull Continuation<? super R> continuation) {
        KCallables$callSuspendBy$1 kCallables$callSuspendBy$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        Object coroutine_suspended2;
        if (continuation instanceof KCallables$callSuspendBy$1) {
            kCallables$callSuspendBy$1 = (KCallables$callSuspendBy$1) continuation;
            int i16 = kCallables$callSuspendBy$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                kCallables$callSuspendBy$1.label = i16 - Integer.MIN_VALUE;
                obj = kCallables$callSuspendBy$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = kCallables$callSuspendBy$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        kCallable = (KCallable) kCallables$callSuspendBy$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (!kCallable.isSuspend()) {
                        return kCallable.callBy(map);
                    }
                    if (kCallable instanceof KFunction) {
                        KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
                        if (asKCallableImpl != null) {
                            kCallables$callSuspendBy$1.L$0 = kCallable;
                            kCallables$callSuspendBy$1.L$1 = map;
                            kCallables$callSuspendBy$1.L$2 = asKCallableImpl;
                            kCallables$callSuspendBy$1.label = 1;
                            obj = asKCallableImpl.callDefaultMethod$kotlin_reflection(map, kCallables$callSuspendBy$1);
                            coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (obj == coroutine_suspended2) {
                                DebugProbes.probeCoroutineSuspended(kCallables$callSuspendBy$1);
                            }
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            throw new KotlinReflectionInternalError("This callable does not support a default call: " + kCallable);
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot callSuspendBy on a property " + kCallable + ": suspend properties are not supported yet");
                    }
                }
                if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class)) && !kCallable.getReturnType().isMarkedNullable()) {
                    return Unit.INSTANCE;
                }
                return obj;
            }
        }
        kCallables$callSuspendBy$1 = new KCallables$callSuspendBy$1(continuation);
        obj = kCallables$callSuspendBy$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = kCallables$callSuspendBy$1.label;
        if (i3 == 0) {
        }
        if (!Intrinsics.areEqual(kCallable.getReturnType().getClassifier(), Reflection.getOrCreateKotlinClass(Unit.class))) {
        }
        return obj;
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final KParameter findParameterByName(@NotNull KCallable<?> kCallable, @NotNull String name) {
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        boolean z16 = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (Intrinsics.areEqual(((KParameter) next).getName(), name)) {
                    if (z16) {
                        break;
                    }
                    z16 = true;
                    obj2 = next;
                }
            } else if (z16) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @Nullable
    public static final KParameter getExtensionReceiverParameter(@NotNull KCallable<?> kCallable) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z17 = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.EXTENSION_RECEIVER) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (z17) {
                        break;
                    }
                    obj2 = next;
                    z17 = true;
                }
            } else if (z17) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @Nullable
    public static final KParameter getInstanceParameter(@NotNull KCallable<?> kCallable) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        Iterator<T> it = kCallable.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z17 = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).getKind() == KParameter.Kind.INSTANCE) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (z17) {
                        break;
                    }
                    obj2 = next;
                    z17 = true;
                }
            } else if (z17) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @NotNull
    public static final List<KParameter> getValueParameters(@NotNull KCallable<?> kCallable) {
        boolean z16;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        List<KParameter> parameters = kCallable.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).getKind() == KParameter.Kind.VALUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getExtensionReceiverParameter$annotations(KCallable kCallable) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getInstanceParameter$annotations(KCallable kCallable) {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void getValueParameters$annotations(KCallable kCallable) {
    }
}
