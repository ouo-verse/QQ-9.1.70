package com.tencent.rdelivery.net;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"com/tencent/rdelivery/net/BaseProto$BizSystemID", "", "Lcom/tencent/rdelivery/net/BaseProto$BizSystemID;", "", "value", "Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DEFAULT", "RES_HUB", "TAB", "GRAY_PKG", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public enum BaseProto$BizSystemID {
    DEFAULT(HippyQQConstants.HIPPY_CHANNEL),
    RES_HUB("10010"),
    TAB("10013"),
    GRAY_PKG("10016");


    @NotNull
    private final String value;

    BaseProto$BizSystemID(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
