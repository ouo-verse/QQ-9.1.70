package com.tencent.raft.standard.net;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface IRNetwork {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class HttpMethod {
        private static final /* synthetic */ HttpMethod[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final HttpMethod CONNECT;
        public static final HttpMethod DELETE;
        public static final HttpMethod GET;
        public static final HttpMethod HEAD;
        public static final HttpMethod OPTIONS;
        public static final HttpMethod POST;
        public static final HttpMethod PUT;
        public static final HttpMethod TRACE;
        private final int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9352);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            HttpMethod httpMethod = new HttpMethod(HttpOptions.METHOD_NAME, 0, 0);
            OPTIONS = httpMethod;
            HttpMethod httpMethod2 = new HttpMethod("HEAD", 1, 1);
            HEAD = httpMethod2;
            HttpMethod httpMethod3 = new HttpMethod("GET", 2, 2);
            GET = httpMethod3;
            HttpMethod httpMethod4 = new HttpMethod("POST", 3, 3);
            POST = httpMethod4;
            HttpMethod httpMethod5 = new HttpMethod(HttpPut.METHOD_NAME, 4, 4);
            PUT = httpMethod5;
            HttpMethod httpMethod6 = new HttpMethod("DELETE", 5, 5);
            DELETE = httpMethod6;
            HttpMethod httpMethod7 = new HttpMethod("TRACE", 6, 6);
            TRACE = httpMethod7;
            HttpMethod httpMethod8 = new HttpMethod("CONNECT", 7, 7);
            CONNECT = httpMethod8;
            $VALUES = new HttpMethod[]{httpMethod, httpMethod2, httpMethod3, httpMethod4, httpMethod5, httpMethod6, httpMethod7, httpMethod8};
        }

        HttpMethod(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static HttpMethod valueOf(String str) {
            return (HttpMethod) Enum.valueOf(HttpMethod.class, str);
        }

        public static HttpMethod[] values() {
            return (HttpMethod[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface INetworkResult {
        void onFail(@NotNull ResultInfo resultInfo);

        void onSuccess(@NotNull Object obj);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class NetworkStatus {
        private static final /* synthetic */ NetworkStatus[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final NetworkStatus MOBILE_2G;
        public static final NetworkStatus MOBILE_3G;
        public static final NetworkStatus MOBILE_4G;
        public static final NetworkStatus MOBILE_5G;
        public static final NetworkStatus MOBILE_UNKNOWN;
        public static final NetworkStatus NO_NETWORK;
        public static final NetworkStatus UNKNOWN;
        public static final NetworkStatus WIFI;
        private final int value;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9394);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            NetworkStatus networkStatus = new NetworkStatus("UNKNOWN", 0, -1);
            UNKNOWN = networkStatus;
            NetworkStatus networkStatus2 = new NetworkStatus("NO_NETWORK", 1, 0);
            NO_NETWORK = networkStatus2;
            NetworkStatus networkStatus3 = new NetworkStatus("MOBILE_2G", 2, 1);
            MOBILE_2G = networkStatus3;
            NetworkStatus networkStatus4 = new NetworkStatus("MOBILE_3G", 3, 2);
            MOBILE_3G = networkStatus4;
            NetworkStatus networkStatus5 = new NetworkStatus("MOBILE_4G", 4, 3);
            MOBILE_4G = networkStatus5;
            NetworkStatus networkStatus6 = new NetworkStatus("MOBILE_5G", 5, 4);
            MOBILE_5G = networkStatus6;
            NetworkStatus networkStatus7 = new NetworkStatus("MOBILE_UNKNOWN", 6, 9);
            MOBILE_UNKNOWN = networkStatus7;
            NetworkStatus networkStatus8 = new NetworkStatus(Global.TRACKING_WIFI, 7, 10);
            WIFI = networkStatus8;
            $VALUES = new NetworkStatus[]{networkStatus, networkStatus2, networkStatus3, networkStatus4, networkStatus5, networkStatus6, networkStatus7, networkStatus8};
        }

        NetworkStatus(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.value = i16;
            }
        }

        public static NetworkStatus valueOf(String str) {
            return (NetworkStatus) Enum.valueOf(NetworkStatus.class, str);
        }

        public static NetworkStatus[] values() {
            return (NetworkStatus[]) $VALUES.clone();
        }

        public final int getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.value;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static final class ResultInfo {
        static IPatchRedirector $redirector_;

        @Nullable
        private Integer errorCode;

        @Nullable
        private String errorMessage;

        @Nullable
        private ErrorType errorType;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* compiled from: P */
        /* loaded from: classes25.dex */
        public static final class ErrorType {
            private static final /* synthetic */ ErrorType[] $VALUES;
            static IPatchRedirector $redirector_;
            public static final ErrorType CANCELLED;
            public static final ErrorType HTTP_ERROR;
            public static final ErrorType OTHER_ERROR;
            public static final ErrorType SUCCESS;
            private final int value;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9484);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 3)) {
                    redirector.redirect((short) 3);
                    return;
                }
                ErrorType errorType = new ErrorType("SUCCESS", 0, 0);
                SUCCESS = errorType;
                ErrorType errorType2 = new ErrorType("HTTP_ERROR", 1, 1);
                HTTP_ERROR = errorType2;
                ErrorType errorType3 = new ErrorType("OTHER_ERROR", 2, 2);
                OTHER_ERROR = errorType3;
                ErrorType errorType4 = new ErrorType("CANCELLED", 3, 3);
                CANCELLED = errorType4;
                $VALUES = new ErrorType[]{errorType, errorType2, errorType3, errorType4};
            }

            ErrorType(String str, int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                } else {
                    this.value = i16;
                }
            }

            public static ErrorType valueOf(String str) {
                return (ErrorType) Enum.valueOf(ErrorType.class, str);
            }

            public static ErrorType[] values() {
                return (ErrorType[]) $VALUES.clone();
            }

            public final int getValue() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
                }
                return this.value;
            }
        }

        public ResultInfo() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this);
            } else {
                this.errorType = ErrorType.SUCCESS;
            }
        }

        @Nullable
        public final Integer getErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.errorCode;
        }

        @Nullable
        public final String getErrorMessage() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.errorMessage;
        }

        @Nullable
        public final ErrorType getErrorType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (ErrorType) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.errorType;
        }

        public final boolean isCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (this.errorType == ErrorType.CANCELLED) {
                return true;
            }
            return false;
        }

        public final boolean isHttpError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            if (this.errorType == ErrorType.HTTP_ERROR) {
                return true;
            }
            return false;
        }

        public final boolean isOtherError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
            }
            if (this.errorType == ErrorType.OTHER_ERROR) {
                return true;
            }
            return false;
        }

        public final boolean isSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            if (this.errorType == ErrorType.SUCCESS) {
                return true;
            }
            return false;
        }

        public final void setErrorCode(@Nullable Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) num);
            } else {
                this.errorCode = num;
            }
        }

        public final void setErrorMessage(@Nullable String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            } else {
                this.errorMessage = str;
            }
        }

        public final void setErrorType(@Nullable ErrorType errorType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) errorType);
            } else {
                this.errorType = errorType;
            }
        }
    }

    NetworkStatus getNetworkStatus();

    void requestWithMethod(@NotNull HttpMethod httpMethod, @NotNull String str, @NotNull Map<String, String> map, @NotNull Map<String, String> map2, @Nullable Object obj, @Nullable INetworkResult iNetworkResult);
}
