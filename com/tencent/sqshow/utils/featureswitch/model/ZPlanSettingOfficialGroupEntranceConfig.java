package com.tencent.sqshow.utils.featureswitch.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0004H\u0016R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/sqshow/utils/featureswitch/model/ZPlanSettingOfficialGroupEntranceConfig;", "", "()V", "entranceName", "", "getEntranceName", "()Ljava/lang/String;", "showEntrance", "", "getShowEntrance", "()I", "url", "getUrl", "toString", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanSettingOfficialGroupEntranceConfig {

    @SerializedName("showEntrance")
    private final int showEntrance;

    @SerializedName("entranceName")
    private final String entranceName = "";

    @SerializedName("url")
    private final String url = "";

    public final String getEntranceName() {
        return this.entranceName;
    }

    public final int getShowEntrance() {
        return this.showEntrance;
    }

    public final String getUrl() {
        return this.url;
    }

    public String toString() {
        return "showEntrance=" + this.showEntrance + ", entranceName=" + this.entranceName + ", url=" + this.url;
    }
}
