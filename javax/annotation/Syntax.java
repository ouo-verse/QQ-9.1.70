package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.When;

/* compiled from: P */
@TypeQualifier(applicableTo = CharSequence.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes28.dex */
public @interface Syntax {
    String value();

    When when() default When.ALWAYS;
}
