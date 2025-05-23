package com.tencent.rdelivery.net;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"com/tencent/rdelivery/net/BaseProto$Platform", "", "Lcom/tencent/rdelivery/net/BaseProto$Platform;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "UNKNOWN", "COMMON", "ANDROID", "IOS", "WEB", "SERVER", "MICROAPP", "IPAD", "APAD", "WINDOWS", Global.TRACKING_MAC, "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public enum BaseProto$Platform {
    UNKNOWN(0),
    COMMON(1),
    ANDROID(2),
    IOS(3),
    WEB(4),
    SERVER(5),
    MICROAPP(6),
    IPAD(7),
    APAD(8),
    WINDOWS(9),
    MAC(10);

    private final int value;

    BaseProto$Platform(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
