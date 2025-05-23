package com.tencent.robot.adelie.homepage.share;

import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/share/ShareSource;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "FRIEND", "CHANNEL", "WECHAT", "WECHAT_CIRCLE", "QZONE", "QR", Global.TRACKING_URL, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public enum ShareSource {
    FRIEND(1),
    CHANNEL(2),
    WECHAT(3),
    WECHAT_CIRCLE(4),
    QZONE(5),
    QR(6),
    URL(7);

    private final int value;

    ShareSource(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
