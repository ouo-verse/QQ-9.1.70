package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes28.dex */
public interface JavaTypeParameter extends JavaClassifier {
    @NotNull
    Collection<JavaClassifierType> getUpperBounds();
}
