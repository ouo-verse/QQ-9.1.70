package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface BuiltInTypeConverters {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum State {
        ENABLED,
        DISABLED,
        INHERITED
    }

    State enums() default State.INHERITED;

    State uuid() default State.INHERITED;
}
