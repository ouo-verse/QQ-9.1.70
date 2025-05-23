package com.tencent.kuikly.core.base.event;

import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/kuikly/core/base/event/EventName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", MyNearbyProBizScene.CLICK, "DOUBLE_CLICK", "LONG_PRESS", "PAN", "TOUCH_DOWN", "TOUCH_UP", "TOUCH_MOVE", "TOUCH_CANCEL", "ANIMATION_COMPLETE", "SCREEN_FRAME", "HIT_TEST_SELF", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public enum EventName {
    CLICK("click"),
    DOUBLE_CLICK("doubleClick"),
    LONG_PRESS("longPress"),
    PAN("pan"),
    TOUCH_DOWN("touchDown"),
    TOUCH_UP("touchUp"),
    TOUCH_MOVE("touchMove"),
    TOUCH_CANCEL("touchCancel"),
    ANIMATION_COMPLETE("animationCompletion"),
    SCREEN_FRAME("screenFrame"),
    HIT_TEST_SELF("hitTestSelf");

    private final String value;

    EventName(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
