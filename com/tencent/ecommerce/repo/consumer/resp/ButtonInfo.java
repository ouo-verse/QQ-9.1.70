package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import java.util.ArrayList;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/ButtonInfo;", "", "()V", "buttonBgColor", "", "getButtonBgColor", "()Ljava/lang/String;", "buttonText", "getButtonText", "jumpInfoArray", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/consumer/resp/JumpInfo;", "Lkotlin/collections/ArrayList;", "getJumpInfoArray", "()Ljava/util/ArrayList;", "useGameCustomButton", "", "getUseGameCustomButton", "()Z", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ButtonInfo {

    @SerializedName("use_game_custom_button")
    private final boolean useGameCustomButton;

    @SerializedName(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT)
    private final String buttonText = "";

    @SerializedName("button_bg_color")
    private final String buttonBgColor = "";

    @SerializedName("jump_info")
    private final ArrayList<JumpInfo> jumpInfoArray = new ArrayList<>();

    public final String getButtonBgColor() {
        return this.buttonBgColor;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final ArrayList<JumpInfo> getJumpInfoArray() {
        return this.jumpInfoArray;
    }

    public final boolean getUseGameCustomButton() {
        return this.useGameCustomButton;
    }
}
