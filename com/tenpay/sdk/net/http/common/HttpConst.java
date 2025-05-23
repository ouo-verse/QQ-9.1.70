package com.tenpay.sdk.net.http.common;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tenpay/sdk/net/http/common/HttpConst;", "", "HEADER", "MethodType", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public interface HttpConst {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tenpay/sdk/net/http/common/HttpConst$HEADER;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "Host", "X_ONLINE_HOST", "LAST_MODIFIED", "RANGE", "CONTENT_RANGE", "CONTENT_LENGTH", "CONTENT_TYPE", "KEEP_ALIVE", "CONNECTION", "USER_AGENT", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum HEADER {
        Host("Host"),
        X_ONLINE_HOST("x-online-host"),
        LAST_MODIFIED("Last-Modified"),
        RANGE(DownloaderConstant.KEY_RANGE),
        CONTENT_RANGE("Content-Range"),
        CONTENT_LENGTH("Content-Length"),
        CONTENT_TYPE("Content-Type"),
        KEEP_ALIVE("Keep-Alive"),
        CONNECTION("Connection"),
        USER_AGENT("user-agent");


        @NotNull
        private final String value;

        HEADER(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/sdk/net/http/common/HttpConst$MethodType;", "", "(Ljava/lang/String;I)V", "GET", "POST", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum MethodType {
        GET,
        POST
    }
}
