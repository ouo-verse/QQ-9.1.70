package com.tencent.rdelivery.net;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/rdelivery/net/BaseProto$PullTarget", "", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "PROJECT", GrsBaseInfo.CountryCodeSource.APP, "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public enum BaseProto$PullTarget {
    PROJECT(0),
    APP(1);

    private final int value;

    BaseProto$PullTarget(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
