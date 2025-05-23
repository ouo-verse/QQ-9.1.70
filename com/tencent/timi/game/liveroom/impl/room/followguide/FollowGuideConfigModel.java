package com.tencent.timi.game.liveroom.impl.room.followguide;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/followguide/FollowGuideConfigModel;", "Ljava/io/Serializable;", "", "toString", "", "featureOn", "Z", "getFeatureOn", "()Z", "setFeatureOn", "(Z)V", "", "stayDismissDuration", "I", "getStayDismissDuration", "()I", "setStayDismissDuration", "(I)V", "maxCountWeekly", "getMaxCountWeekly", "setMaxCountWeekly", "maxCountDailyRoom", "getMaxCountDailyRoom", "setMaxCountDailyRoom", "showInterval", "getShowInterval", "setShowInterval", "<init>", "()V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FollowGuideConfigModel implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private boolean featureOn;
    private int stayDismissDuration = 5;
    private int maxCountWeekly = 2;
    private int maxCountDailyRoom = 3;
    private int showInterval = 10;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/followguide/FollowGuideConfigModel$a;", "", "Lcom/tencent/timi/game/liveroom/impl/room/followguide/FollowGuideConfigModel;", "a", "", "CONFIG_ID", "Ljava/lang/String;", "", "DEFAULT_MAX_COUNT_DAILY_ROOM", "I", "DEFAULT_MAX_COUNT_WEEKLY", "DEFAULT_SHOW_INTERVAL", "DEFAULT_STAY_DISMISS_DURATION", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.followguide.FollowGuideConfigModel$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FollowGuideConfigModel a() {
            boolean z16;
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102541", "");
            FollowGuideConfigModel followGuideConfigModel = new FollowGuideConfigModel();
            boolean z17 = false;
            if (loadAsString.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                try {
                    JSONObject jSONObject = new JSONObject(loadAsString);
                    if (jSONObject.optInt("featureOn") == 1) {
                        z17 = true;
                    }
                    followGuideConfigModel.setFeatureOn(z17);
                    followGuideConfigModel.setMaxCountDailyRoom(jSONObject.optInt("maxCountDailyRoom", 3));
                    followGuideConfigModel.setMaxCountWeekly(jSONObject.optInt("maxCountWeekly", 2));
                    followGuideConfigModel.setShowInterval(jSONObject.optInt("showInterval", 10));
                    followGuideConfigModel.setStayDismissDuration(jSONObject.optInt("stayDismissDuration", 5));
                } catch (Exception e16) {
                    QLog.e("FollowGuideConfigModel", 1, "getServiceConfig parse config exception:", e16);
                }
            }
            QLog.d("FollowGuideConfigModel", 1, "getServiceConfig model:" + followGuideConfigModel);
            return followGuideConfigModel;
        }

        Companion() {
        }
    }

    public final boolean getFeatureOn() {
        return this.featureOn;
    }

    public final int getMaxCountDailyRoom() {
        return this.maxCountDailyRoom;
    }

    public final int getMaxCountWeekly() {
        return this.maxCountWeekly;
    }

    public final int getShowInterval() {
        return this.showInterval;
    }

    public final int getStayDismissDuration() {
        return this.stayDismissDuration;
    }

    public final void setFeatureOn(boolean z16) {
        this.featureOn = z16;
    }

    public final void setMaxCountDailyRoom(int i3) {
        this.maxCountDailyRoom = i3;
    }

    public final void setMaxCountWeekly(int i3) {
        this.maxCountWeekly = i3;
    }

    public final void setShowInterval(int i3) {
        this.showInterval = i3;
    }

    public final void setStayDismissDuration(int i3) {
        this.stayDismissDuration = i3;
    }

    @NotNull
    public String toString() {
        return "FollowGuideConfigModel(featureOn=" + this.featureOn + ", stayDismissDuration=" + this.stayDismissDuration + ", maxCountWeekly=" + this.maxCountWeekly + ", maxCountDailyRoom=" + this.maxCountDailyRoom + ", showInterval=" + this.showInterval + ")";
    }
}
