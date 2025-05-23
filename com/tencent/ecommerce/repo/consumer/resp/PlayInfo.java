package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "", "()V", "playPlan", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlan;", "getPlayPlan", "()Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlan;", SensorJsPlugin.SENSOR_INTERVAL_UI, "Lcom/tencent/ecommerce/repo/consumer/resp/PlayUI;", "getUi", "()Lcom/tencent/ecommerce/repo/consumer/resp/PlayUI;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class PlayInfo {

    @SerializedName("play_plan")
    private final PlayPlan playPlan = new PlayPlan();
    private final PlayUI ui = new PlayUI();

    public final PlayPlan getPlayPlan() {
        return this.playPlan;
    }

    public final PlayUI getUi() {
        return this.ui;
    }
}
