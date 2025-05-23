package com.tencent.mobileqq.zplan.meme;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/ZPlanRecordScene;", "", "Lcom/tencent/zplan/record/a;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "NONE", "SQUARE", "EMOTICON", "HEAD_PORTRAIT", "QZONE", "EMOTICON_PRE_RECORD", "EMOTICON_TAB_ICON", "SPRING_FESTIVAL", "EASTER_EGG", "EMOTICON_DETAIL", "BIRTHDAY_CARE", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum ZPlanRecordScene implements com.tencent.zplan.record.a {
    NONE(0),
    SQUARE(1),
    EMOTICON(2),
    HEAD_PORTRAIT(3),
    QZONE(4),
    EMOTICON_PRE_RECORD(5),
    EMOTICON_TAB_ICON(6),
    SPRING_FESTIVAL(7),
    EASTER_EGG(8),
    EMOTICON_DETAIL(9),
    BIRTHDAY_CARE(10);

    private final int value;

    ZPlanRecordScene(int i3) {
        this.value = i3;
    }

    @Override // com.tencent.zplan.record.a
    public int getValue() {
        return this.value;
    }
}
