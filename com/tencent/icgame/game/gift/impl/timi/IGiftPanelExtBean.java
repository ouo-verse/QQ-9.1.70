package com.tencent.icgame.game.gift.impl.timi;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/icgame/game/gift/impl/timi/IGiftPanelExtBean;", "Ljava/io/Serializable;", "getKey", "", HippyTextInputController.COMMAND_getValue, "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public interface IGiftPanelExtBean extends Serializable {
    @NotNull
    String getKey();

    @NotNull
    String getValue();
}
