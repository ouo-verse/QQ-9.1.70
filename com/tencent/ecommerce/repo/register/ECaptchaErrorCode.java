package com.tencent.ecommerce.repo.register;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/repo/register/ECaptchaErrorCode;", "", "errorCode", "", "(Ljava/lang/String;II)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "DEFAULT", "JS_LOAD_ERROR", "SHOW_TIMEOUT", "MIDDLE_JS_LOAD_TIMEOUT", "MIDDLE_JS_LOAD_ERROR", "MIDDLE_JS_RUN_ERROR", "CAPTCHA_CONFIG_ERROR_OR_TIMEOUT", "IFRAME_LOAD_TIMEOUT", "IFRAME_LOAD_ERROR", "JQUERY_LOAD_ERROR", "SLIDER_JS_LOAD_ERROR", "SLIDER_JS_RUN_ERROR", "REFRESH_ERROR_OVER_TIMES", "NETWORK_ERROR_OVER_TIMES", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECaptchaErrorCode {
    DEFAULT(0),
    JS_LOAD_ERROR(1001),
    SHOW_TIMEOUT(1002),
    MIDDLE_JS_LOAD_TIMEOUT(1003),
    MIDDLE_JS_LOAD_ERROR(1004),
    MIDDLE_JS_RUN_ERROR(1005),
    CAPTCHA_CONFIG_ERROR_OR_TIMEOUT(1006),
    IFRAME_LOAD_TIMEOUT(1007),
    IFRAME_LOAD_ERROR(1008),
    JQUERY_LOAD_ERROR(1009),
    SLIDER_JS_LOAD_ERROR(1010),
    SLIDER_JS_RUN_ERROR(1011),
    REFRESH_ERROR_OVER_TIMES(1012),
    NETWORK_ERROR_OVER_TIMES(1013);

    private int errorCode;

    ECaptchaErrorCode(int i3) {
        this.errorCode = i3;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i3) {
        this.errorCode = i3;
    }
}
