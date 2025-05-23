package java.com.tencent.tdf.channel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes28.dex */
public @interface Channel {
    public static final long hostObjectRef = 0;

    String name();

    String[] names() default {};
}
