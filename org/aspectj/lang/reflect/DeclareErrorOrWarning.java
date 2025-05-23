package org.aspectj.lang.reflect;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface DeclareErrorOrWarning {
    AjType getDeclaringType();

    String getMessage();

    PointcutExpression getPointcutExpression();

    boolean isError();
}
