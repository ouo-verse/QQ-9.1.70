package com.tencent.state.square.data;

import android.graphics.Rect;
import com.tencent.state.map.Location;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapPlayableItem;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u0010\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020\u0003H\u0016J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\u0005H\u0016J\u0010\u0010C\u001a\u00020>2\u0006\u0010,\u001a\u00020\u000eH\u0016R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0011\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u0005X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010&R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010+R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010$\"\u0004\b1\u0010+R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010$\"\u0004\b3\u0010+R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010+\u00a8\u0006D"}, d2 = {"Lcom/tencent/state/square/data/SquareTroopItem;", "Lcom/tencent/state/map/MapPlayableItem;", "troopUin", "", "isCenter", "", "location", "Lcom/tencent/state/map/Location;", "troopName", "troopIcon", "lastMsg", "Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "ownerUin", "ownerResource", "Lcom/tencent/state/square/data/Resource;", "tentResource", "tentStaticResource", "isBaned", "extra", "Lcom/tencent/state/square/data/SquareExtraTroopInfo;", "(Ljava/lang/String;ZLcom/tencent/state/map/Location;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/api/SquareTroopMessageRecord;Ljava/lang/String;Lcom/tencent/state/square/data/Resource;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/state/square/data/SquareExtraTroopInfo;)V", "getExtra", "()Lcom/tencent/state/square/data/SquareExtraTroopInfo;", "setExtra", "(Lcom/tencent/state/square/data/SquareExtraTroopInfo;)V", "()Z", "setBaned", "(Z)V", "isFixed", "isGenderMale", "getLastMsg", "()Lcom/tencent/state/square/api/SquareTroopMessageRecord;", "setLastMsg", "(Lcom/tencent/state/square/api/SquareTroopMessageRecord;)V", "name", "getName", "()Ljava/lang/String;", "getOwnerResource", "()Lcom/tencent/state/square/data/Resource;", "setOwnerResource", "(Lcom/tencent/state/square/data/Resource;)V", "getOwnerUin", "setOwnerUin", "(Ljava/lang/String;)V", "resource", "getResource", "getTentResource", "setTentResource", "getTentStaticResource", "setTentStaticResource", "getTroopIcon", "setTroopIcon", "getTroopName", "setTroopName", "canUpdate", "newItem", "Lcom/tencent/state/map/MapItem;", "getItemViewLocation", "Landroid/graphics/Rect;", "getUnitType", "", "resetDefault", "", "updateDressKey", "dressKey", "updateGender", "isMale", "updateResource", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareTroopItem extends MapPlayableItem {
    private SquareExtraTroopInfo extra;
    private boolean isBaned;
    private final boolean isFixed;
    private final boolean isGenderMale;
    private SquareTroopMessageRecord lastMsg;
    private Resource ownerResource;
    private String ownerUin;
    private String tentResource;
    private String tentStaticResource;
    private String troopIcon;
    private String troopName;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SquareTroopItem(String str, boolean z16, Location location, String str2, String str3, SquareTroopMessageRecord squareTroopMessageRecord, String str4, Resource resource, String str5, String str6, boolean z17, SquareExtraTroopInfo squareExtraTroopInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z16, location, r7, r8, r9, (i3 & 64) != 0 ? "" : str4, (i3 & 128) != 0 ? null : resource, (i3 & 256) != 0 ? "" : str5, (i3 & 512) != 0 ? "" : str6, (i3 & 1024) != 0 ? false : z17, (i3 & 2048) != 0 ? new SquareExtraTroopInfo(false, false, false, null, 15, null) : squareExtraTroopInfo);
        SquareTroopMessageRecord squareTroopMessageRecord2;
        String str7 = (i3 & 8) != 0 ? "" : str2;
        String str8 = (i3 & 16) != 0 ? "" : str3;
        MessageRecordType messageRecordType = null;
        byte b16 = 0;
        if ((i3 & 32) != 0) {
            squareTroopMessageRecord2 = new SquareTroopMessageRecord(str, messageRecordType, 2, b16 == true ? 1 : 0);
        } else {
            squareTroopMessageRecord2 = squareTroopMessageRecord;
        }
    }

    @Override // com.tencent.state.map.MapItem
    public boolean canUpdate(MapItem newItem) {
        FilamentResource filament;
        FilamentResource filament2;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        DressKeys dressKeys = null;
        if (!(newItem instanceof SquareTroopItem)) {
            newItem = null;
        }
        SquareTroopItem squareTroopItem = (SquareTroopItem) newItem;
        if (squareTroopItem == null) {
            return false;
        }
        if (!(!Intrinsics.areEqual(this.ownerUin, squareTroopItem.ownerUin))) {
            Resource resource = this.ownerResource;
            DressKeys userDressKey = (resource == null || (filament2 = resource.getFilament()) == null) ? null : filament2.getUserDressKey();
            Resource resource2 = squareTroopItem.ownerResource;
            if (resource2 != null && (filament = resource2.getFilament()) != null) {
                dressKeys = filament.getUserDressKey();
            }
            if (!(!Intrinsics.areEqual(userDressKey, dressKeys)) && !(!Intrinsics.areEqual(getTroopName(), squareTroopItem.getTroopName())) && !(!Intrinsics.areEqual(this.lastMsg.getLastMsg(), squareTroopItem.lastMsg.getLastMsg())) && this.lastMsg.isTroop() == squareTroopItem.lastMsg.isTroop() && !(!Intrinsics.areEqual(this.lastMsg.getSummaryData().getMsgText(), squareTroopItem.lastMsg.getSummaryData().getMsgText())) && !(!Intrinsics.areEqual(this.tentStaticResource, squareTroopItem.tentStaticResource)) && !(!Intrinsics.areEqual(this.troopName, squareTroopItem.troopName)) && !(!Intrinsics.areEqual(getLocation().toString(), squareTroopItem.getLocation().toString()))) {
                return false;
            }
        }
        return true;
    }

    public final SquareExtraTroopInfo getExtra() {
        return this.extra;
    }

    @Override // com.tencent.state.map.MapItem
    public Rect getItemViewLocation() {
        Rect troopViewLocation;
        troopViewLocation = SquareTroopItemKt.toTroopViewLocation(getLocation());
        return troopViewLocation;
    }

    public final SquareTroopMessageRecord getLastMsg() {
        return this.lastMsg;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: getName, reason: from getter */
    public String getTroopName() {
        return this.troopName;
    }

    public final Resource getOwnerResource() {
        return this.ownerResource;
    }

    public final String getOwnerUin() {
        return this.ownerUin;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: getResource */
    public Resource getUserResource() {
        return this.ownerResource;
    }

    public final String getTentResource() {
        return this.tentResource;
    }

    public final String getTentStaticResource() {
        return this.tentStaticResource;
    }

    public final String getTroopIcon() {
        return this.troopIcon;
    }

    public final String getTroopName() {
        return this.troopName;
    }

    @Override // com.tencent.state.map.MapItem
    public int getUnitType() {
        return 1;
    }

    /* renamed from: isBaned, reason: from getter */
    public final boolean getIsBaned() {
        return this.isBaned;
    }

    @Override // com.tencent.state.map.MapItem
    /* renamed from: isFixed, reason: from getter */
    public boolean getIsFixed() {
        return this.isFixed;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    /* renamed from: isGenderMale, reason: from getter */
    public boolean getIsGenderMale() {
        return this.isGenderMale;
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
    
        r0 = com.tencent.state.square.data.SquareItemKt.copyResource(r0, (r21 & 1) != 0 ? r0.getActionId() : 0, (r21 & 2) != 0 ? r0.getDynamic() : null, (r21 & 4) != 0 ? r0.getStatic() : null, (r21 & 8) != 0 ? r0.getShowSize() : null, (r21 & 16) != 0 ? r0.getRecordSize() : null, (r21 & 32) != 0 ? r0.getIsDefault() : false, (r21 & 64) != 0 ? r0.getBubbleCoordinate() : null, (r21 & 128) != 0 ? r0.getActionType() : 0, (r21 & 256) != 0 ? r0.getActionStyle() : 0, (r21 & 512) != 0 ? r0.getFilament() : null);
     */
    @Override // com.tencent.state.map.MapPlayableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void resetDefault() {
        Resource copyResource;
        Resource resource = this.ownerResource;
        Resource resetDefault = (resource == null || copyResource == null) ? null : copyResource.resetDefault();
        this.ownerResource = resetDefault;
    }

    public final void setBaned(boolean z16) {
        this.isBaned = z16;
    }

    public final void setExtra(SquareExtraTroopInfo squareExtraTroopInfo) {
        Intrinsics.checkNotNullParameter(squareExtraTroopInfo, "<set-?>");
        this.extra = squareExtraTroopInfo;
    }

    public final void setLastMsg(SquareTroopMessageRecord squareTroopMessageRecord) {
        Intrinsics.checkNotNullParameter(squareTroopMessageRecord, "<set-?>");
        this.lastMsg = squareTroopMessageRecord;
    }

    public final void setOwnerResource(Resource resource) {
        this.ownerResource = resource;
    }

    public final void setOwnerUin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ownerUin = str;
    }

    public final void setTentResource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tentResource = str;
    }

    public final void setTentStaticResource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tentStaticResource = str;
    }

    public final void setTroopIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.troopIcon = str;
    }

    public final void setTroopName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.troopName = str;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateDressKey(String dressKey) {
        Intrinsics.checkNotNullParameter(dressKey, "dressKey");
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateResource(Resource resource) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.ownerResource = resource;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareTroopItem(String troopUin, boolean z16, Location location, String troopName, String troopIcon, SquareTroopMessageRecord lastMsg, String ownerUin, Resource resource, String tentResource, String tentStaticResource, boolean z17, SquareExtraTroopInfo extra) {
        super(4, troopUin, z16, location);
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(troopIcon, "troopIcon");
        Intrinsics.checkNotNullParameter(lastMsg, "lastMsg");
        Intrinsics.checkNotNullParameter(ownerUin, "ownerUin");
        Intrinsics.checkNotNullParameter(tentResource, "tentResource");
        Intrinsics.checkNotNullParameter(tentStaticResource, "tentStaticResource");
        Intrinsics.checkNotNullParameter(extra, "extra");
        this.troopName = troopName;
        this.troopIcon = troopIcon;
        this.lastMsg = lastMsg;
        this.ownerUin = ownerUin;
        this.ownerResource = resource;
        this.tentResource = tentResource;
        this.tentStaticResource = tentStaticResource;
        this.isBaned = z17;
        this.extra = extra;
        this.isFixed = true;
    }

    @Override // com.tencent.state.map.MapPlayableItem
    public void updateGender(boolean isMale) {
    }
}
