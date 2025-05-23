package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/FlowerOpType;", "", "Lcom/tencent/filament/zplan/scene/xwconnect/data/h;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "INVALID_OP", "PLANT", "REMOVE", "REVIVE", "REPLACE", "WATER", "REMOVE_BUGS", "ADD_BUGS", "WATCH_AD", "SUPPORT", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum FlowerOpType implements h {
    INVALID_OP(0),
    PLANT(1),
    REMOVE(2),
    REVIVE(3),
    REPLACE(4),
    WATER(5),
    REMOVE_BUGS(6),
    ADD_BUGS(7),
    WATCH_AD(8),
    SUPPORT(9);

    private final int value;

    FlowerOpType(int i3) {
        this.value = i3;
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.data.h
    public int getValue() {
        return this.value;
    }
}
