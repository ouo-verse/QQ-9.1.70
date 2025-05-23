package com.tencent.state.template.data;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.state.data.Image;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0005H\u00c6\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\fH\u00c6\u0003J\t\u00100\u001a\u00020\u000eH\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\t\u00102\u001a\u00020\u0012H\u00c6\u0003J\t\u00103\u001a\u00020\u0012H\u00c6\u0003J\u0089\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0005H\u00c6\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\n0\u0005J\t\u00109\u001a\u00020\u0012H\u00d6\u0001J\u0006\u0010:\u001a\u000206J\b\u0010;\u001a\u00020<H\u0016R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010!\"\u0004\b$\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010'R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010%\u00a8\u0006="}, d2 = {"Lcom/tencent/state/template/data/CommonRoomInfo;", "", "id", "", "stalls", "", "Lcom/tencent/state/template/data/Stall;", "tables", "Lcom/tencent/state/template/data/Table;", "users", "Lcom/tencent/state/template/data/User;", "background", "Lcom/tencent/state/data/Image;", DownloadInfo.spKey_Config, "Lcom/tencent/state/template/data/RoomConfig;", "theme", "Lcom/tencent/state/template/data/RoomThemeData;", "appId", "", "maxPeople", "operationAdSlots", "Lcom/tencent/state/template/data/OperationAd;", "(JLjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/tencent/state/data/Image;Lcom/tencent/state/template/data/RoomConfig;Lcom/tencent/state/template/data/RoomThemeData;IILjava/util/List;)V", "getAppId", "()I", "getBackground", "()Lcom/tencent/state/data/Image;", "getConfig", "()Lcom/tencent/state/template/data/RoomConfig;", "getId", "()J", "getMaxPeople", "getOperationAdSlots", "()Ljava/util/List;", "getStalls", "getTables", "setTables", "(Ljava/util/List;)V", "getTheme", "()Lcom/tencent/state/template/data/RoomThemeData;", "getUsers", "setUsers", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getSitUsers", "hashCode", "isSupportFlexTable", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class CommonRoomInfo {
    private final int appId;
    private final Image background;
    private final RoomConfig config;
    private final long id;
    private final int maxPeople;
    private final List<OperationAd> operationAdSlots;
    private final List<Stall> stalls;
    private List<Table> tables;
    private final RoomThemeData theme;
    private List<User> users;

    public CommonRoomInfo(long j3, List<Stall> stalls, List<Table> tables, List<User> users, Image background, RoomConfig config, RoomThemeData roomThemeData, int i3, int i16, List<OperationAd> list) {
        Intrinsics.checkNotNullParameter(stalls, "stalls");
        Intrinsics.checkNotNullParameter(tables, "tables");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(config, "config");
        this.id = j3;
        this.stalls = stalls;
        this.tables = tables;
        this.users = users;
        this.background = background;
        this.config = config;
        this.theme = roomThemeData;
        this.appId = i3;
        this.maxPeople = i16;
        this.operationAdSlots = list;
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<OperationAd> component10() {
        return this.operationAdSlots;
    }

    public final List<Stall> component2() {
        return this.stalls;
    }

    public final List<Table> component3() {
        return this.tables;
    }

    public final List<User> component4() {
        return this.users;
    }

    /* renamed from: component5, reason: from getter */
    public final Image getBackground() {
        return this.background;
    }

    /* renamed from: component6, reason: from getter */
    public final RoomConfig getConfig() {
        return this.config;
    }

    /* renamed from: component7, reason: from getter */
    public final RoomThemeData getTheme() {
        return this.theme;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAppId() {
        return this.appId;
    }

    /* renamed from: component9, reason: from getter */
    public final int getMaxPeople() {
        return this.maxPeople;
    }

    public final CommonRoomInfo copy(long id5, List<Stall> stalls, List<Table> tables, List<User> users, Image background, RoomConfig config, RoomThemeData theme, int appId, int maxPeople, List<OperationAd> operationAdSlots) {
        Intrinsics.checkNotNullParameter(stalls, "stalls");
        Intrinsics.checkNotNullParameter(tables, "tables");
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(background, "background");
        Intrinsics.checkNotNullParameter(config, "config");
        return new CommonRoomInfo(id5, stalls, tables, users, background, config, theme, appId, maxPeople, operationAdSlots);
    }

    public final int getAppId() {
        return this.appId;
    }

    public final Image getBackground() {
        return this.background;
    }

    public final RoomConfig getConfig() {
        return this.config;
    }

    public final long getId() {
        return this.id;
    }

    public final int getMaxPeople() {
        return this.maxPeople;
    }

    public final List<OperationAd> getOperationAdSlots() {
        return this.operationAdSlots;
    }

    public final List<User> getSitUsers() {
        List<User> list = this.users;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((User) obj).getStatus() == UserStatus.SIT_DOWN) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final List<Stall> getStalls() {
        return this.stalls;
    }

    public final List<Table> getTables() {
        return this.tables;
    }

    public final RoomThemeData getTheme() {
        return this.theme;
    }

    public final List<User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        int a16 = c.a(this.id) * 31;
        List<Stall> list = this.stalls;
        int hashCode = (a16 + (list != null ? list.hashCode() : 0)) * 31;
        List<Table> list2 = this.tables;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<User> list3 = this.users;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Image image = this.background;
        int hashCode4 = (hashCode3 + (image != null ? image.hashCode() : 0)) * 31;
        RoomConfig roomConfig = this.config;
        int hashCode5 = (hashCode4 + (roomConfig != null ? roomConfig.hashCode() : 0)) * 31;
        RoomThemeData roomThemeData = this.theme;
        int hashCode6 = (((((hashCode5 + (roomThemeData != null ? roomThemeData.hashCode() : 0)) * 31) + this.appId) * 31) + this.maxPeople) * 31;
        List<OperationAd> list4 = this.operationAdSlots;
        return hashCode6 + (list4 != null ? list4.hashCode() : 0);
    }

    public final boolean isSupportFlexTable() {
        return this.maxPeople > this.tables.size();
    }

    public final void setTables(List<Table> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tables = list;
    }

    public final void setUsers(List<User> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.users = list;
    }

    public String toString() {
        return "CommonRoomInfo(id=" + this.id + ", background=" + this.background + ')';
    }

    public /* synthetic */ CommonRoomInfo(long j3, List list, List list2, List list3, Image image, RoomConfig roomConfig, RoomThemeData roomThemeData, int i3, int i16, List list4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, list, list2, list3, image, roomConfig, (i17 & 64) != 0 ? null : roomThemeData, (i17 & 128) != 0 ? 0 : i3, i16, (i17 & 512) != 0 ? null : list4);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonRoomInfo)) {
            return false;
        }
        CommonRoomInfo commonRoomInfo = (CommonRoomInfo) other;
        return this.id == commonRoomInfo.id && Intrinsics.areEqual(this.stalls, commonRoomInfo.stalls) && Intrinsics.areEqual(this.tables, commonRoomInfo.tables) && Intrinsics.areEqual(this.users, commonRoomInfo.users) && Intrinsics.areEqual(this.background, commonRoomInfo.background) && Intrinsics.areEqual(this.config, commonRoomInfo.config) && Intrinsics.areEqual(this.theme, commonRoomInfo.theme) && this.appId == commonRoomInfo.appId && this.maxPeople == commonRoomInfo.maxPeople && Intrinsics.areEqual(this.operationAdSlots, commonRoomInfo.operationAdSlots);
    }
}
