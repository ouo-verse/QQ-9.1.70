package kotlin.reflect.jvm;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.EmptyContainerForLocal;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmNameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u00a8\u0006\u0004"}, d2 = {"reflect", "Lkotlin/reflect/KFunction;", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class ReflectLambdaKt {
    @ExperimentalReflectionOnLambdas
    @Nullable
    public static final <R> KFunction<R> reflect(@NotNull Function<? extends R> function) {
        boolean z16;
        Intrinsics.checkNotNullParameter(function, "<this>");
        Metadata metadata = (Metadata) function.getClass().getAnnotation(Metadata.class);
        if (metadata == null) {
            return null;
        }
        String[] d16 = metadata.d1();
        boolean z17 = true;
        if (d16.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d16 = null;
        }
        if (d16 == null) {
            return null;
        }
        Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom = JvmProtoBufUtil.readFunctionDataFrom(d16, metadata.d2());
        JvmNameResolver component1 = readFunctionDataFrom.component1();
        ProtoBuf.Function component2 = readFunctionDataFrom.component2();
        int[] mv5 = metadata.mv();
        if ((metadata.xi() & 8) == 0) {
            z17 = false;
        }
        JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(mv5, z17);
        Class<?> cls = function.getClass();
        ProtoBuf.TypeTable typeTable = component2.getTypeTable();
        Intrinsics.checkNotNullExpressionValue(typeTable, "proto.typeTable");
        return new KFunctionImpl(EmptyContainerForLocal.INSTANCE, (SimpleFunctionDescriptor) UtilKt.deserializeToDescriptor(cls, component2, component1, new TypeTable(typeTable), jvmMetadataVersion, ReflectLambdaKt$reflect$descriptor$1.INSTANCE));
    }
}
