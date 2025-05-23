package org.aspectj.lang.reflect;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface DeclareSoft {
    AjType getDeclaringType();

    PointcutExpression getPointcutExpression();

    AjType getSoftenedExceptionType() throws ClassNotFoundException;
}
