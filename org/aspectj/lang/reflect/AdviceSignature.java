package org.aspectj.lang.reflect;

import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface AdviceSignature extends CodeSignature {
    Method getAdvice();

    Class getReturnType();
}
