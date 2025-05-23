package com.tenpay.sdk.net.utils;

import com.tenpay.sdk.net.core.comm.CGIErrorCode;
import cooperation.qzone.util.QZoneImageUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tenpay/sdk/net/utils/SocketErrorFormatter;", "", "()V", "ERR_CODE_LIST", "", "Lcom/tenpay/sdk/net/utils/SocketErrorFormatter$ErrorCodeMatcher;", "[Lcom/tenpay/sdk/net/utils/SocketErrorFormatter$ErrorCodeMatcher;", "getSocketExceptionErrorCode", "", "throwable", "", "defaultCode", "obtainExceptionMsg", "", "ErrorCodeMatcher", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class SocketErrorFormatter {

    @NotNull
    public static final SocketErrorFormatter INSTANCE = new SocketErrorFormatter();

    @NotNull
    private static final ErrorCodeMatcher[] ERR_CODE_LIST = {new ErrorCodeMatcher(-1202, "ETIMEDOUT", "Connection timed out"), new ErrorCodeMatcher(-1203, "EPIPE", "Broken pipe"), new ErrorCodeMatcher(-1204, "EHOSTUNREACH", "No route to host"), new ErrorCodeMatcher(-1205, "EACCES", "Permission denied"), new ErrorCodeMatcher(-1206, "ECONNREFUSED", "Connection refused"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_ENETUNREACH, "ENETUNREACH", "Network is unreachable"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_SOFTWARE_ABORT, "Software caused connection abort"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_NOT_ALLOWED_BY_ALI_PERMISSION, "Socket is not allowed by AliPermission"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_EIO, "EIO", "I/O error"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_ENOTSOCK, "ENOTSOCK", "Socket operation on non-socket"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_ERRNO_ZERO, "errno 0"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_ECONNRESET, "ECONNRESET", "Connection reset by peer"), new ErrorCodeMatcher(CGIErrorCode.NETWORK_ENOSPC, "No space left on device")};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/net/utils/SocketErrorFormatter$ErrorCodeMatcher;", "", "errCode", "", "matchParams", "", "", "(I[Ljava/lang/String;)V", "getErrCode", "()I", "setErrCode", "(I)V", "matchMsgSet", "[Ljava/lang/String;", QZoneImageUtils.KEY_MATCH, "", "msgDetail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static class ErrorCodeMatcher {
        private int errCode;

        @NotNull
        private final String[] matchMsgSet;

        public ErrorCodeMatcher(int i3, @NotNull String... matchParams) {
            Intrinsics.checkNotNullParameter(matchParams, "matchParams");
            this.errCode = i3;
            this.matchMsgSet = matchParams;
        }

        public final int getErrCode() {
            return this.errCode;
        }

        public final boolean match(@NotNull String msgDetail) {
            String str;
            boolean contains$default;
            Intrinsics.checkNotNullParameter(msgDetail, "msgDetail");
            String[] strArr = this.matchMsgSet;
            int length = strArr.length;
            int i3 = 0;
            while (true) {
                str = null;
                if (i3 >= length) {
                    break;
                }
                String str2 = strArr[i3];
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) msgDetail, (CharSequence) str2, false, 2, (Object) null);
                if (contains$default) {
                    str = str2;
                    break;
                }
                i3++;
            }
            if (str == null) {
                return false;
            }
            return true;
        }

        public final void setErrCode(int i3) {
            this.errCode = i3;
        }
    }

    SocketErrorFormatter() {
    }

    private final String obtainExceptionMsg(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(128);
        sb5.append(throwable.toString());
        for (Throwable cause = throwable.getCause(); cause != null; cause = cause.getCause()) {
            sb5.append(" Caused by: ");
            sb5.append(cause.getLocalizedMessage());
            if (Intrinsics.areEqual(cause.getCause(), cause)) {
                break;
            }
        }
        return sb5.toString();
    }

    public final int getSocketExceptionErrorCode(@Nullable Throwable throwable, int defaultCode) {
        ErrorCodeMatcher errorCodeMatcher;
        while (throwable != null) {
            String obtainExceptionMsg = obtainExceptionMsg(throwable);
            if (obtainExceptionMsg == null) {
                return defaultCode;
            }
            ErrorCodeMatcher[] errorCodeMatcherArr = ERR_CODE_LIST;
            int length = errorCodeMatcherArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    errorCodeMatcher = errorCodeMatcherArr[i3];
                    if (errorCodeMatcher.match(obtainExceptionMsg)) {
                        break;
                    }
                    i3++;
                } else {
                    errorCodeMatcher = null;
                    break;
                }
            }
            if (errorCodeMatcher != null) {
                return errorCodeMatcher.getErrCode();
            }
            throwable = throwable.getCause();
        }
        return defaultCode;
    }
}
