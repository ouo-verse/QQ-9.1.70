package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface DatabaseView {
    String value() default "";

    String viewName() default "";
}
