package com.tencent.ecommerce.biz.register.refactoring.utils;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/utils/ECRegisterReportScene;", "", "sceneType", "", "(Ljava/lang/String;II)V", "INTRO_PAGE_GO_ON_BTN_CLK", "SEND_CAPTCHA", "GET_PS_KEY", "REAL_NAME_VERIFY", "FACE_VERIFY", "REGISTER", "SEND_SMS_CODE_BY_SESSION", "REGISTER_BY_SESSION", "INTRO_PAGE_EXP", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECRegisterReportScene {
    INTRO_PAGE_GO_ON_BTN_CLK(0),
    SEND_CAPTCHA(1),
    GET_PS_KEY(2),
    REAL_NAME_VERIFY(3),
    FACE_VERIFY(4),
    REGISTER(5),
    SEND_SMS_CODE_BY_SESSION(6),
    REGISTER_BY_SESSION(7),
    INTRO_PAGE_EXP(8);

    public final int sceneType;

    ECRegisterReportScene(int i3) {
        this.sceneType = i3;
    }
}
