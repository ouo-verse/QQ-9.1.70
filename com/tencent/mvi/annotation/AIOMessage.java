package com.tencent.mvi.annotation;

import com.tencent.mvi.base.route.MsgIntent;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
/* loaded from: classes21.dex */
public @interface AIOMessage {
    Class<? extends MsgIntent>[] value();
}
