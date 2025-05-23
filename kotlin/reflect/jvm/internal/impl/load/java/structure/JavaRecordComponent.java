package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaRecordComponent extends JavaMember {
    @NotNull
    JavaType getType();

    boolean isVararg();
}
