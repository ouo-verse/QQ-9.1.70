package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface AutoMigration {
    int from();

    Class<?> spec() default Object.class;

    int to();
}
