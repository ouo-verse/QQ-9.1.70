package com.tencent.raft.raftannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes25.dex */
public @interface RaftMethod {
    RaftArg[] args() default {};

    String name() default "";
}
