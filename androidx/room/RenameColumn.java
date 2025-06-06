package androidx.room;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Repeatable(Entries.class)
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes.dex */
public @interface RenameColumn {

    /* compiled from: P */
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface Entries {
        RenameColumn[] value();
    }

    String fromColumnName();

    String tableName();

    String toColumnName();
}
