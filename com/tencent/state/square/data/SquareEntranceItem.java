package com.tencent.state.square.data;

import android.graphics.Point;
import android.graphics.Rect;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.EntranceLink;
import com.tencent.zplan.common.utils.d;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010<\u001a\u00020-2\u0006\u0010=\u001a\u00020\u0001H\u0016J\u0006\u0010>\u001a\u00020\u0003J\b\u0010?\u001a\u00020@H\u0016R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020-X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010.R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00104\"\u0004\b8\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00104R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&\u00a8\u0006A"}, d2 = {"Lcom/tencent/state/square/data/SquareEntranceItem;", "Lcom/tencent/state/map/MapItem;", "uin", "", "name", "showUrl", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "Lcom/tencent/state/square/EntranceLink;", "location", "Lcom/tencent/state/map/Location;", "entranceBubble", "Lcom/tencent/state/square/data/EntranceBubble;", "entranceType", "", "entranceId", "styleId", "bubbleCoordinate", "Landroid/graphics/Point;", "bubbles", "", "Lcom/tencent/state/square/data/BuildingBubble;", "anchorEntry", "Lcom/tencent/state/square/data/SquareAnchorEntrance;", "extraBubble", "smallIcon", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/EntranceLink;Lcom/tencent/state/map/Location;Lcom/tencent/state/square/data/EntranceBubble;IIILandroid/graphics/Point;Ljava/util/List;Ljava/util/List;Lcom/tencent/state/square/data/BuildingBubble;Ljava/lang/String;)V", "getAnchorEntry", "()Ljava/util/List;", "getBubbleCoordinate", "()Landroid/graphics/Point;", "getBubbles", "setBubbles", "(Ljava/util/List;)V", "getEntranceBubble", "()Lcom/tencent/state/square/data/EntranceBubble;", "getEntranceId", "()I", "setEntranceId", "(I)V", "getEntranceType", "getExtraBubble", "()Lcom/tencent/state/square/data/BuildingBubble;", "setExtraBubble", "(Lcom/tencent/state/square/data/BuildingBubble;)V", "isFixed", "", "()Z", "getLink", "()Lcom/tencent/state/square/EntranceLink;", "setLink", "(Lcom/tencent/state/square/EntranceLink;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getShowUrl", "setShowUrl", "getSmallIcon", "getStyleId", "setStyleId", "canUpdate", "newItem", "getImageUrl", "getItemViewLocation", "Landroid/graphics/Rect;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public class SquareEntranceItem extends MapItem {
    private final List<SquareAnchorEntrance> anchorEntry;
    private final Point bubbleCoordinate;
    private List<BuildingBubble> bubbles;
    private final EntranceBubble entranceBubble;
    private int entranceId;
    private final int entranceType;
    private BuildingBubble extraBubble;
    private final boolean isFixed;
    private EntranceLink link;
    private String name;
    private String showUrl;
    private final String smallIcon;
    private int styleId;

    public /* synthetic */ SquareEntranceItem(String str, String str2, String str3, EntranceLink entranceLink, Location location, EntranceBubble entranceBubble, int i3, int i16, int i17, Point point, List list, List list2, BuildingBubble buildingBubble, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, entranceLink, location, entranceBubble, i3, i16, i17, (i18 & 512) != 0 ? new Point(0, 0) : point, (i18 & 1024) != 0 ? null : list, (i18 & 2048) != 0 ? new ArrayList() : list2, (i18 & 4096) != 0 ? null : buildingBubble, (i18 & 8192) != 0 ? null : str4);
    }

    @Override // com.tencent.state.map.MapItem
    public boolean canUpdate(MapItem newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof SquareEntranceItem)) {
            newItem = null;
        }
        SquareEntranceItem squareEntranceItem = (SquareEntranceItem) newItem;
        if (squareEntranceItem != null) {
            return (Intrinsics.areEqual(getLocation().toString(), squareEntranceItem.getLocation().toString()) ^ true) || (Intrinsics.areEqual(this.name, squareEntranceItem.name) ^ true) || (Intrinsics.areEqual(this.showUrl, squareEntranceItem.showUrl) ^ true) || (Intrinsics.areEqual(this.link.toString(), squareEntranceItem.link.toString()) ^ true);
        }
        return false;
    }

    public final List<SquareAnchorEntrance> getAnchorEntry() {
        return this.anchorEntry;
    }

    public final Point getBubbleCoordinate() {
        return this.bubbleCoordinate;
    }

    public final List<BuildingBubble> getBubbles() {
        return this.bubbles;
    }

    public final EntranceBubble getEntranceBubble() {
        return this.entranceBubble;
    }

    public final int getEntranceId() {
        return this.entranceId;
    }

    public final int getEntranceType() {
        return this.entranceType;
    }

    public final BuildingBubble getExtraBubble() {
        return this.extraBubble;
    }

    public final String getImageUrl() {
        boolean contains$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.showUrl);
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.showUrl, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        } else {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        sb5.append("uin=" + getUin() + "&md5=" + d.c(this.showUrl));
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    @Override // com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        return new Rect(getLocation().getX(), getLocation().getY(), getLocation().getX() + getLocation().getWidth(), getLocation().getY() + getLocation().getHeight());
    }

    public final EntranceLink getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final String getShowUrl() {
        return this.showUrl;
    }

    public final String getSmallIcon() {
        return this.smallIcon;
    }

    public final int getStyleId() {
        return this.styleId;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    public final void setBubbles(List<BuildingBubble> list) {
        this.bubbles = list;
    }

    public final void setEntranceId(int i3) {
        this.entranceId = i3;
    }

    public final void setExtraBubble(BuildingBubble buildingBubble) {
        this.extraBubble = buildingBubble;
    }

    public final void setLink(EntranceLink entranceLink) {
        Intrinsics.checkNotNullParameter(entranceLink, "<set-?>");
        this.link = entranceLink;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setShowUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.showUrl = str;
    }

    public final void setStyleId(int i3) {
        this.styleId = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareEntranceItem(String uin, String name, String showUrl, EntranceLink link, Location location, EntranceBubble entranceBubble, int i3, int i16, int i17, Point bubbleCoordinate, List<BuildingBubble> list, List<SquareAnchorEntrance> anchorEntry, BuildingBubble buildingBubble, String str) {
        super(6, uin, false, location);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(showUrl, "showUrl");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(entranceBubble, "entranceBubble");
        Intrinsics.checkNotNullParameter(bubbleCoordinate, "bubbleCoordinate");
        Intrinsics.checkNotNullParameter(anchorEntry, "anchorEntry");
        this.name = name;
        this.showUrl = showUrl;
        this.link = link;
        this.entranceBubble = entranceBubble;
        this.entranceType = i3;
        this.entranceId = i16;
        this.styleId = i17;
        this.bubbleCoordinate = bubbleCoordinate;
        this.bubbles = list;
        this.anchorEntry = anchorEntry;
        this.extraBubble = buildingBubble;
        this.smallIcon = str;
        this.isFixed = true;
    }
}
