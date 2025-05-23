package org.aspectj.internal.lang.reflect;

import com.tencent.component.media.image.ProgressTracer;
import org.aspectj.lang.reflect.AjType;
import org.aspectj.lang.reflect.DeclareErrorOrWarning;
import org.aspectj.lang.reflect.PointcutExpression;

/* compiled from: P */
/* loaded from: classes29.dex */
public class DeclareErrorOrWarningImpl implements DeclareErrorOrWarning {
    private AjType declaringType;
    private boolean isError;

    /* renamed from: msg, reason: collision with root package name */
    private String f423552msg;

    /* renamed from: pc, reason: collision with root package name */
    private PointcutExpression f423553pc;

    public DeclareErrorOrWarningImpl(String str, String str2, boolean z16, AjType ajType) {
        this.f423553pc = new PointcutExpressionImpl(str);
        this.f423552msg = str2;
        this.isError = z16;
        this.declaringType = ajType;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public AjType getDeclaringType() {
        return this.declaringType;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public String getMessage() {
        return this.f423552msg;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public PointcutExpression getPointcutExpression() {
        return this.f423553pc;
    }

    @Override // org.aspectj.lang.reflect.DeclareErrorOrWarning
    public boolean isError() {
        return this.isError;
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("declare ");
        if (isError()) {
            str = "error : ";
        } else {
            str = "warning : ";
        }
        stringBuffer.append(str);
        stringBuffer.append(getPointcutExpression().asString());
        stringBuffer.append(ProgressTracer.SEPARATOR);
        stringBuffer.append("\"");
        stringBuffer.append(getMessage());
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }
}
