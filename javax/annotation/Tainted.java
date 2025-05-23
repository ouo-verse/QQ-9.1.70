package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;

/* compiled from: P */
@TypeQualifierNickname
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Untainted(when = When.MAYBE)
/* loaded from: classes28.dex */
public @interface Tainted {
}
