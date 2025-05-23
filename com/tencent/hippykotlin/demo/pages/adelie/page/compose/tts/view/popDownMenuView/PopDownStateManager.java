package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView;

import com.tencent.hippykotlin.demo.pages.adelie.common.compose.util.StateHolder;
import kotlin.jvm.internal.Intrinsics;
import yo3.Offset;

/* loaded from: classes31.dex */
public final class PopDownStateManager {
    public String chosenTtsId;
    public Offset chosenTtsOffset;
    public StateHolder<Boolean> isDeleteDialog;
    public StateHolder<Boolean> isPopDownMenu;
    public StateHolder<Boolean> isRenameDialog;
    public StateHolder<Boolean> shadowState;

    public PopDownStateManager() {
        Boolean bool = Boolean.FALSE;
        this.isPopDownMenu = new StateHolder<>(bool);
        this.isRenameDialog = new StateHolder<>(bool);
        this.isDeleteDialog = new StateHolder<>(bool);
        this.shadowState = new StateHolder<>(bool);
        this.chosenTtsId = "";
        this.chosenTtsOffset = new Offset(0.0f, 0.0f);
    }

    public final void popDownMenuDisappear() {
        this.isPopDownMenu._state.setValue(Boolean.valueOf(!Intrinsics.areEqual(r0._state.getValue(), Boolean.TRUE)));
    }
}
