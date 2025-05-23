package javax.annotation.meta;

import java.lang.annotation.Annotation;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes28.dex */
public interface TypeQualifierValidator<A extends Annotation> {
    @Nonnull
    When forConstantValue(@Nonnull A a16, Object obj);
}
