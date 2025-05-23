package com.tencent.biz.qqcircle.sensor;

import com.heytap.databaseengine.apiv2.health.HeytapHealthParams;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/sensor/PostureType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "UNKNOWN", "LYING_STILL", "OTHER_STILL", HeytapHealthParams.SPORT, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public enum PostureType {
    UNKNOWN(0),
    LYING_STILL(1),
    OTHER_STILL(2),
    SPORT(3);

    private final int value;

    PostureType(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
