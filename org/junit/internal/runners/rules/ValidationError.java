package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import org.junit.runners.model.FrameworkMember;

/* compiled from: P */
/* loaded from: classes29.dex */
class ValidationError extends Exception {
    public ValidationError(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, String str) {
        super(String.format("The @%s '%s' %s", cls.getSimpleName(), frameworkMember.getName(), str));
    }
}
