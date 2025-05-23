package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

/* compiled from: P */
@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes28.dex */
public @interface Nonnull {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Checker implements TypeQualifierValidator<Nonnull> {
        @Override // javax.annotation.meta.TypeQualifierValidator
        public When forConstantValue(Nonnull nonnull, Object obj) {
            if (obj == null) {
                return When.NEVER;
            }
            return When.ALWAYS;
        }
    }

    When when() default When.ALWAYS;
}
