package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaField extends JavaMember {
    boolean getHasConstantNotNullInitializer();

    @NotNull
    JavaType getType();

    boolean isEnumEntry();
}
