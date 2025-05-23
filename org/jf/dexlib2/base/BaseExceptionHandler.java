package org.jf.dexlib2.base;

import com.google.common.base.g;
import java.util.Comparator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.base.reference.BaseTypeReference;
import org.jf.dexlib2.iface.ExceptionHandler;
import org.jf.dexlib2.iface.reference.TypeReference;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseExceptionHandler implements ExceptionHandler {
    public static final Comparator<ExceptionHandler> BY_EXCEPTION = new Comparator<ExceptionHandler>() { // from class: org.jf.dexlib2.base.BaseExceptionHandler.2
        @Override // java.util.Comparator
        public int compare(ExceptionHandler exceptionHandler, ExceptionHandler exceptionHandler2) {
            String exceptionType = exceptionHandler.getExceptionType();
            if (exceptionType == null) {
                return exceptionHandler2.getExceptionType() != null ? 1 : 0;
            }
            if (exceptionHandler2.getExceptionType() == null) {
                return -1;
            }
            return exceptionType.compareTo(exceptionHandler2.getExceptionType());
        }
    };

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ExceptionHandler)) {
            return false;
        }
        ExceptionHandler exceptionHandler = (ExceptionHandler) obj;
        if (!g.a(getExceptionType(), exceptionHandler.getExceptionType()) || getHandlerCodeAddress() != exceptionHandler.getHandlerCodeAddress()) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    @Nullable
    public TypeReference getExceptionTypeReference() {
        final String exceptionType = getExceptionType();
        if (exceptionType == null) {
            return null;
        }
        return new BaseTypeReference() { // from class: org.jf.dexlib2.base.BaseExceptionHandler.1
            @Override // org.jf.dexlib2.iface.reference.TypeReference, org.jf.dexlib2.iface.ClassDef
            @Nonnull
            public String getType() {
                return exceptionType;
            }
        };
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler
    public int hashCode() {
        int hashCode;
        String exceptionType = getExceptionType();
        if (exceptionType == null) {
            hashCode = 0;
        } else {
            hashCode = exceptionType.hashCode();
        }
        return (hashCode * 31) + getHandlerCodeAddress();
    }

    @Override // org.jf.dexlib2.iface.ExceptionHandler, java.lang.Comparable
    public int compareTo(@Nonnull ExceptionHandler exceptionHandler) {
        String exceptionType = getExceptionType();
        if (exceptionType == null) {
            if (exceptionHandler.getExceptionType() != null) {
                return 1;
            }
        } else {
            if (exceptionHandler.getExceptionType() == null) {
                return -1;
            }
            int compareTo = exceptionType.compareTo(exceptionHandler.getExceptionType());
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return c.a(getHandlerCodeAddress(), exceptionHandler.getHandlerCodeAddress());
    }
}
