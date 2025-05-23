package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface Index {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Order {
        ASC,
        DESC
    }

    String name() default "";

    Order[] orders() default {};

    boolean unique() default false;

    String[] value();
}
