package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface SuperCallReceiverValue extends ReceiverValue {
    @NotNull
    KotlinType getThisType();
}
