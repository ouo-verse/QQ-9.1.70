package com.tencent.state.template.data;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.state.data.Image;
import com.tencent.state.map.Location;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u0091\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u000204H\u00d6\u0001J\t\u00105\u001a\u000206H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017\u00a8\u00067"}, d2 = {"Lcom/tencent/state/template/data/RoomConfig;", "", "background", "Lcom/tencent/state/data/Image;", DownloadInfo.spKey_Config, "Lcom/tencent/state/template/data/CommonConfig;", "roomDecorators", "", "Lcom/tencent/state/template/data/Decorator;", "buildings", "Lcom/tencent/state/template/data/BuildingDecorator;", "tableBrand", "tableExpect", "tableExpectWithShare", "tableExpectWithEdit", "backgroundLocation", "Lcom/tencent/state/map/Location;", "refreshPanel", "themeRefreshPanel", "(Lcom/tencent/state/data/Image;Lcom/tencent/state/template/data/CommonConfig;Ljava/util/List;Ljava/util/List;Lcom/tencent/state/template/data/Decorator;Lcom/tencent/state/template/data/Decorator;Lcom/tencent/state/template/data/Decorator;Lcom/tencent/state/template/data/Decorator;Lcom/tencent/state/map/Location;Lcom/tencent/state/template/data/Decorator;Lcom/tencent/state/map/Location;)V", "getBackground", "()Lcom/tencent/state/data/Image;", "getBackgroundLocation", "()Lcom/tencent/state/map/Location;", "getBuildings", "()Ljava/util/List;", "getConfig", "()Lcom/tencent/state/template/data/CommonConfig;", "getRefreshPanel", "()Lcom/tencent/state/template/data/Decorator;", "getRoomDecorators", "getTableBrand", "getTableExpect", "getTableExpectWithEdit", "getTableExpectWithShare", "getThemeRefreshPanel", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class RoomConfig {
    private final Image background;
    private final Location backgroundLocation;
    private final List<BuildingDecorator> buildings;
    private final CommonConfig config;
    private final Decorator refreshPanel;
    private final List<Decorator> roomDecorators;
    private final Decorator tableBrand;
    private final Decorator tableExpect;
    private final Decorator tableExpectWithEdit;
    private final Decorator tableExpectWithShare;
    private final Location themeRefreshPanel;

    /* JADX WARN: Multi-variable type inference failed */
    public RoomConfig(Image background, CommonConfig config, List<? extends Decorator> roomDecorators, List<BuildingDecorator> buildings, Decorator decorator, Decorator decorator2, Decorator decorator3, Decorator decorator4, Location location, Decorator decorator5, Location location2) {
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(roomDecorators, "roomDecorators");
        Intrinsics.checkNotNullParameter(buildings, "buildings");
        this.background = background;
        this.config = config;
        this.roomDecorators = roomDecorators;
        this.buildings = buildings;
        this.tableBrand = decorator;
        this.tableExpect = decorator2;
        this.tableExpectWithShare = decorator3;
        this.tableExpectWithEdit = decorator4;
        this.backgroundLocation = location;
        this.refreshPanel = decorator5;
        this.themeRefreshPanel = location2;
    }

    /* renamed from: component1, reason: from getter */
    public final Image getBackground() {
        return this.background;
    }

    /* renamed from: component10, reason: from getter */
    public final Decorator getRefreshPanel() {
        return this.refreshPanel;
    }

    /* renamed from: component11, reason: from getter */
    public final Location getThemeRefreshPanel() {
        return this.themeRefreshPanel;
    }

    /* renamed from: component2, reason: from getter */
    public final CommonConfig getConfig() {
        return this.config;
    }

    public final List<Decorator> component3() {
        return this.roomDecorators;
    }

    public final List<BuildingDecorator> component4() {
        return this.buildings;
    }

    /* renamed from: component5, reason: from getter */
    public final Decorator getTableBrand() {
        return this.tableBrand;
    }

    /* renamed from: component6, reason: from getter */
    public final Decorator getTableExpect() {
        return this.tableExpect;
    }

    /* renamed from: component7, reason: from getter */
    public final Decorator getTableExpectWithShare() {
        return this.tableExpectWithShare;
    }

    /* renamed from: component8, reason: from getter */
    public final Decorator getTableExpectWithEdit() {
        return this.tableExpectWithEdit;
    }

    /* renamed from: component9, reason: from getter */
    public final Location getBackgroundLocation() {
        return this.backgroundLocation;
    }

    public final RoomConfig copy(Image background, CommonConfig config, List<? extends Decorator> roomDecorators, List<BuildingDecorator> buildings, Decorator tableBrand, Decorator tableExpect, Decorator tableExpectWithShare, Decorator tableExpectWithEdit, Location backgroundLocation, Decorator refreshPanel, Location themeRefreshPanel) {
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(roomDecorators, "roomDecorators");
        Intrinsics.checkNotNullParameter(buildings, "buildings");
        return new RoomConfig(background, config, roomDecorators, buildings, tableBrand, tableExpect, tableExpectWithShare, tableExpectWithEdit, backgroundLocation, refreshPanel, themeRefreshPanel);
    }

    public final Image getBackground() {
        return this.background;
    }

    public final Location getBackgroundLocation() {
        return this.backgroundLocation;
    }

    public final List<BuildingDecorator> getBuildings() {
        return this.buildings;
    }

    public final CommonConfig getConfig() {
        return this.config;
    }

    public final Decorator getRefreshPanel() {
        return this.refreshPanel;
    }

    public final List<Decorator> getRoomDecorators() {
        return this.roomDecorators;
    }

    public final Decorator getTableBrand() {
        return this.tableBrand;
    }

    public final Decorator getTableExpect() {
        return this.tableExpect;
    }

    public final Decorator getTableExpectWithEdit() {
        return this.tableExpectWithEdit;
    }

    public final Decorator getTableExpectWithShare() {
        return this.tableExpectWithShare;
    }

    public final Location getThemeRefreshPanel() {
        return this.themeRefreshPanel;
    }

    public int hashCode() {
        Image image = this.background;
        int hashCode = (image != null ? image.hashCode() : 0) * 31;
        CommonConfig commonConfig = this.config;
        int hashCode2 = (hashCode + (commonConfig != null ? commonConfig.hashCode() : 0)) * 31;
        List<Decorator> list = this.roomDecorators;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        List<BuildingDecorator> list2 = this.buildings;
        int hashCode4 = (hashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Decorator decorator = this.tableBrand;
        int hashCode5 = (hashCode4 + (decorator != null ? decorator.hashCode() : 0)) * 31;
        Decorator decorator2 = this.tableExpect;
        int hashCode6 = (hashCode5 + (decorator2 != null ? decorator2.hashCode() : 0)) * 31;
        Decorator decorator3 = this.tableExpectWithShare;
        int hashCode7 = (hashCode6 + (decorator3 != null ? decorator3.hashCode() : 0)) * 31;
        Decorator decorator4 = this.tableExpectWithEdit;
        int hashCode8 = (hashCode7 + (decorator4 != null ? decorator4.hashCode() : 0)) * 31;
        Location location = this.backgroundLocation;
        int hashCode9 = (hashCode8 + (location != null ? location.hashCode() : 0)) * 31;
        Decorator decorator5 = this.refreshPanel;
        int hashCode10 = (hashCode9 + (decorator5 != null ? decorator5.hashCode() : 0)) * 31;
        Location location2 = this.themeRefreshPanel;
        return hashCode10 + (location2 != null ? location2.hashCode() : 0);
    }

    public String toString() {
        return "RoomConfig(background=" + this.background + ", config=" + this.config + ", roomDecorators=" + this.roomDecorators + ", buildings=" + this.buildings + ", tableBrand=" + this.tableBrand + ", tableExpect=" + this.tableExpect + ", tableExpectWithShare=" + this.tableExpectWithShare + ", tableExpectWithEdit=" + this.tableExpectWithEdit + ", backgroundLocation=" + this.backgroundLocation + ", refreshPanel=" + this.refreshPanel + ", themeRefreshPanel=" + this.themeRefreshPanel + ")";
    }

    public /* synthetic */ RoomConfig(Image image, CommonConfig commonConfig, List list, List list2, Decorator decorator, Decorator decorator2, Decorator decorator3, Decorator decorator4, Location location, Decorator decorator5, Location location2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(image, commonConfig, list, list2, decorator, decorator2, decorator3, decorator4, location, decorator5, (i3 & 1024) != 0 ? null : location2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoomConfig)) {
            return false;
        }
        RoomConfig roomConfig = (RoomConfig) other;
        return Intrinsics.areEqual(this.background, roomConfig.background) && Intrinsics.areEqual(this.config, roomConfig.config) && Intrinsics.areEqual(this.roomDecorators, roomConfig.roomDecorators) && Intrinsics.areEqual(this.buildings, roomConfig.buildings) && Intrinsics.areEqual(this.tableBrand, roomConfig.tableBrand) && Intrinsics.areEqual(this.tableExpect, roomConfig.tableExpect) && Intrinsics.areEqual(this.tableExpectWithShare, roomConfig.tableExpectWithShare) && Intrinsics.areEqual(this.tableExpectWithEdit, roomConfig.tableExpectWithEdit) && Intrinsics.areEqual(this.backgroundLocation, roomConfig.backgroundLocation) && Intrinsics.areEqual(this.refreshPanel, roomConfig.refreshPanel) && Intrinsics.areEqual(this.themeRefreshPanel, roomConfig.themeRefreshPanel);
    }
}
