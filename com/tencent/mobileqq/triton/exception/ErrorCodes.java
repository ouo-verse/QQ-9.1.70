package com.tencent.mobileqq.triton.exception;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'SUCCESS' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/triton/exception/ErrorCodes;", "", "category", "Lcom/tencent/mobileqq/triton/exception/ErrorCategory;", "severity", "Lcom/tencent/mobileqq/triton/exception/ErrorSeverity;", "(Ljava/lang/String;ILcom/tencent/mobileqq/triton/exception/ErrorCategory;Lcom/tencent/mobileqq/triton/exception/ErrorSeverity;)V", "getCategory", "()Lcom/tencent/mobileqq/triton/exception/ErrorCategory;", "getSeverity", "()Lcom/tencent/mobileqq/triton/exception/ErrorSeverity;", "success", "", "getSuccess", "()Z", "toString", "", "SUCCESS", "UNKNOWN", "INITIALIZE", "SCRIPT_LOAD_FAIL", "SCRIPT_PLUGIN_CALL_FAIL", "RENDER_INIT_FAIL", "RENDER_BLACK_SCREEN", "NATIVE_LOAD_LIBRARY", "NATIVE_FUNCTION_CALL", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class ErrorCodes {
    private static final /* synthetic */ ErrorCodes[] $VALUES;
    public static final ErrorCodes INITIALIZE;
    public static final ErrorCodes NATIVE_FUNCTION_CALL;
    public static final ErrorCodes NATIVE_LOAD_LIBRARY;
    public static final ErrorCodes RENDER_BLACK_SCREEN;
    public static final ErrorCodes RENDER_INIT_FAIL;
    public static final ErrorCodes SCRIPT_LOAD_FAIL;
    public static final ErrorCodes SCRIPT_PLUGIN_CALL_FAIL;
    public static final ErrorCodes SUCCESS;
    public static final ErrorCodes UNKNOWN;

    @NotNull
    private final ErrorCategory category;

    @NotNull
    private final ErrorSeverity severity;

    static {
        ErrorCategory errorCategory = ErrorCategory.UNKNOWN;
        ErrorCodes errorCodes = new ErrorCodes("SUCCESS", 0, errorCategory, ErrorSeverity.NONE);
        SUCCESS = errorCodes;
        ErrorSeverity errorSeverity = ErrorSeverity.MODERATE;
        ErrorCodes errorCodes2 = new ErrorCodes("UNKNOWN", 1, errorCategory, errorSeverity);
        UNKNOWN = errorCodes2;
        ErrorCategory errorCategory2 = ErrorCategory.INITIALIZE;
        ErrorSeverity errorSeverity2 = ErrorSeverity.SEVER;
        ErrorCodes errorCodes3 = new ErrorCodes("INITIALIZE", 2, errorCategory2, errorSeverity2);
        INITIALIZE = errorCodes3;
        ErrorCategory errorCategory3 = ErrorCategory.SCRIPT;
        ErrorCodes errorCodes4 = new ErrorCodes("SCRIPT_LOAD_FAIL", 3, errorCategory3, errorSeverity2);
        SCRIPT_LOAD_FAIL = errorCodes4;
        ErrorCodes errorCodes5 = new ErrorCodes("SCRIPT_PLUGIN_CALL_FAIL", 4, errorCategory3, errorSeverity);
        SCRIPT_PLUGIN_CALL_FAIL = errorCodes5;
        ErrorCategory errorCategory4 = ErrorCategory.RENDER;
        ErrorCodes errorCodes6 = new ErrorCodes("RENDER_INIT_FAIL", 5, errorCategory4, errorSeverity2);
        RENDER_INIT_FAIL = errorCodes6;
        ErrorCodes errorCodes7 = new ErrorCodes("RENDER_BLACK_SCREEN", 6, errorCategory4, errorSeverity);
        RENDER_BLACK_SCREEN = errorCodes7;
        ErrorCategory errorCategory5 = ErrorCategory.NATIVE;
        ErrorCodes errorCodes8 = new ErrorCodes("NATIVE_LOAD_LIBRARY", 7, errorCategory5, errorSeverity2);
        NATIVE_LOAD_LIBRARY = errorCodes8;
        ErrorCodes errorCodes9 = new ErrorCodes("NATIVE_FUNCTION_CALL", 8, errorCategory5, errorSeverity2);
        NATIVE_FUNCTION_CALL = errorCodes9;
        $VALUES = new ErrorCodes[]{errorCodes, errorCodes2, errorCodes3, errorCodes4, errorCodes5, errorCodes6, errorCodes7, errorCodes8, errorCodes9};
    }

    ErrorCodes(String str, int i3, ErrorCategory errorCategory, ErrorSeverity errorSeverity) {
        this.category = errorCategory;
        this.severity = errorSeverity;
    }

    public static ErrorCodes valueOf(String str) {
        return (ErrorCodes) Enum.valueOf(ErrorCodes.class, str);
    }

    public static ErrorCodes[] values() {
        return (ErrorCodes[]) $VALUES.clone();
    }

    @NotNull
    public final ErrorCategory getCategory() {
        return this.category;
    }

    @NotNull
    public final ErrorSeverity getSeverity() {
        return this.severity;
    }

    public final boolean getSuccess() {
        if (this == SUCCESS) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return name() + "(category = " + this.category + ", severity = " + this.severity + ')';
    }
}
