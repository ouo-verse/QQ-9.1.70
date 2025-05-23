package com.tencent.filament.zplan.scene.xwconnect.data;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplan/scene/xwconnect/data/CoinType;", "", "Lcom/tencent/filament/zplan/scene/xwconnect/data/h;", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "FREE", "GOLD", "SILVER", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public enum CoinType implements h {
    FREE(0),
    GOLD(1),
    SILVER(2);

    private final int value;

    CoinType(int i3) {
        this.value = i3;
    }

    @Override // com.tencent.filament.zplan.scene.xwconnect.data.h
    public int getValue() {
        return this.value;
    }
}
