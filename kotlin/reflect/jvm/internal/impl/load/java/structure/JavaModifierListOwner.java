package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaModifierListOwner extends JavaElement {
    @NotNull
    Visibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isStatic();
}
