package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface JavaArrayAnnotationArgument extends JavaAnnotationArgument {
    @NotNull
    List<JavaAnnotationArgument> getElements();
}
