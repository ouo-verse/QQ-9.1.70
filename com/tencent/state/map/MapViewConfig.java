package com.tencent.state.map;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/state/map/MapViewConfig;", "", "viewPortWidth", "", "viewPortHeight", "isZoomEnabled", "", "mapWidth", "mapHeight", "mapBackground", "", "avatarConfig", "Lcom/tencent/state/map/AvatarLocationConfig;", "(IIZIILjava/lang/String;Lcom/tencent/state/map/AvatarLocationConfig;)V", "getAvatarConfig", "()Lcom/tencent/state/map/AvatarLocationConfig;", "setAvatarConfig", "(Lcom/tencent/state/map/AvatarLocationConfig;)V", "()Z", "setZoomEnabled", "(Z)V", "getMapBackground", "()Ljava/lang/String;", "setMapBackground", "(Ljava/lang/String;)V", "getMapHeight", "()I", "setMapHeight", "(I)V", "getMapWidth", "setMapWidth", "getViewPortHeight", "getViewPortWidth", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class MapViewConfig {
    private AvatarLocationConfig avatarConfig;
    private boolean isZoomEnabled;
    private String mapBackground;
    private int mapHeight;
    private int mapWidth;
    private final int viewPortHeight;
    private final int viewPortWidth;

    public MapViewConfig(int i3, int i16, boolean z16, int i17, int i18, String str, AvatarLocationConfig avatarConfig) {
        Intrinsics.checkNotNullParameter(avatarConfig, "avatarConfig");
        this.viewPortWidth = i3;
        this.viewPortHeight = i16;
        this.isZoomEnabled = z16;
        this.mapWidth = i17;
        this.mapHeight = i18;
        this.mapBackground = str;
        this.avatarConfig = avatarConfig;
    }

    public final AvatarLocationConfig getAvatarConfig() {
        return this.avatarConfig;
    }

    public final String getMapBackground() {
        return this.mapBackground;
    }

    public final int getMapHeight() {
        return this.mapHeight;
    }

    public final int getMapWidth() {
        return this.mapWidth;
    }

    public final int getViewPortHeight() {
        return this.viewPortHeight;
    }

    public final int getViewPortWidth() {
        return this.viewPortWidth;
    }

    /* renamed from: isZoomEnabled, reason: from getter */
    public final boolean getIsZoomEnabled() {
        return this.isZoomEnabled;
    }

    public final void setAvatarConfig(AvatarLocationConfig avatarLocationConfig) {
        Intrinsics.checkNotNullParameter(avatarLocationConfig, "<set-?>");
        this.avatarConfig = avatarLocationConfig;
    }

    public final void setMapBackground(String str) {
        this.mapBackground = str;
    }

    public final void setMapHeight(int i3) {
        this.mapHeight = i3;
    }

    public final void setMapWidth(int i3) {
        this.mapWidth = i3;
    }

    public final void setZoomEnabled(boolean z16) {
        this.isZoomEnabled = z16;
    }

    public /* synthetic */ MapViewConfig(int i3, int i16, boolean z16, int i17, int i18, String str, AvatarLocationConfig avatarLocationConfig, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, (i19 & 4) != 0 ? true : z16, (i19 & 8) != 0 ? 0 : i17, (i19 & 16) != 0 ? 0 : i18, (i19 & 32) != 0 ? null : str, (i19 & 64) != 0 ? MapViewConfigKt.defaultDetailAvatarConfig() : avatarLocationConfig);
    }
}
