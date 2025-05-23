package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import com.tencent.qqlive.module.videoreport.dtreport.stdevent.PlayParamConst;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlan;", "", "()V", "playPlanFixedTime", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlanFixedTime;", "getPlayPlanFixedTime", "()Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlanFixedTime;", "playPlanPercentage", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlanPercentage;", "getPlayPlanPercentage", "()Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlanPercentage;", "playPlanTopView", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlanTopView;", "getPlayPlanTopView", "()Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlanTopView;", TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE, "", "getPlayType", "()I", "PlayType", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class PlayPlan {

    @SerializedName("play_plan_fixed_time")
    private final PlayPlanFixedTime playPlanFixedTime = new PlayPlanFixedTime();

    @SerializedName("play_plan_percentage")
    private final PlayPlanPercentage playPlanPercentage = new PlayPlanPercentage();

    @SerializedName("play_plan_top_view")
    private final PlayPlanTopView playPlanTopView = new PlayPlanTopView();

    @SerializedName(PlayParamConst.ParamKey.PLAY_TYPE)
    private final int playType;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/PlayPlan$PlayType;", "", "()V", "PLAY_TYPE_FALL_BACK", "", "PLAY_TYPE_FIXED_TIME", "PLAY_TYPE_PERCENTAGE", "PLAY_TYPE_TOP_VIEW", "PLAY_TYPE_UNKNOWN", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class PlayType {
        public static final PlayType INSTANCE = new PlayType();
        public static final int PLAY_TYPE_FALL_BACK = 4;
        public static final int PLAY_TYPE_FIXED_TIME = 1;
        public static final int PLAY_TYPE_PERCENTAGE = 2;
        public static final int PLAY_TYPE_TOP_VIEW = 3;
        public static final int PLAY_TYPE_UNKNOWN = 0;

        PlayType() {
        }
    }

    public final PlayPlanFixedTime getPlayPlanFixedTime() {
        return this.playPlanFixedTime;
    }

    public final PlayPlanPercentage getPlayPlanPercentage() {
        return this.playPlanPercentage;
    }

    public final PlayPlanTopView getPlayPlanTopView() {
        return this.playPlanTopView;
    }

    public final int getPlayType() {
        return this.playType;
    }
}
