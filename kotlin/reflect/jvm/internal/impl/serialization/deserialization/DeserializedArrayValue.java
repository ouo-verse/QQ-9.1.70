package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class DeserializedArrayValue extends ArrayValue {

    @NotNull
    private final KotlinType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedArrayValue(@NotNull List<? extends ConstantValue<?>> value, @NotNull final KotlinType type) {
        super(value, new Function1<ModuleDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final KotlinType invoke(@NotNull ModuleDescriptor it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return KotlinType.this;
            }
        });
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
    }

    @NotNull
    public final KotlinType getType() {
        return this.type;
    }
}
