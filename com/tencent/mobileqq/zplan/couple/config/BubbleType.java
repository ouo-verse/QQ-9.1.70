package com.tencent.mobileqq.zplan.couple.config;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/config/BubbleType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "INVALID_BUBBLE_TYPE", "AVATAR_GUIDE_BUBBLE_TYPE", "AVATAR_MESSAGE_BUBBLE_TYPE", "SETTING_OPERATION_BUBBLE_TYPE", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public enum BubbleType {
    INVALID_BUBBLE_TYPE(0),
    AVATAR_GUIDE_BUBBLE_TYPE(1),
    AVATAR_MESSAGE_BUBBLE_TYPE(2),
    SETTING_OPERATION_BUBBLE_TYPE(3);

    private final int value;

    BubbleType(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
