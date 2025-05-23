package com.tencent.sqshow.zootopia.data;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.sqshow.zootopia.mapstatus.b;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u00a2\u0006\u0004\br\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\bH\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\"\u0010#\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010&\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001b\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\"\u0010)\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R2\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\f0,j\b\u0012\u0004\u0012\u00020\f`-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u001b\u001a\u0004\b5\u0010\u001d\"\u0004\b6\u0010\u001fR\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0012\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\"\u0010A\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001b\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u001fR\"\u0010D\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010\u001b\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010\u001fR\"\u0010G\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010\u0012\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010\u001b\u001a\u0004\bQ\u0010\u001d\"\u0004\bR\u0010\u001fR\"\u0010S\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\u001b\u001a\u0004\bT\u0010\u001d\"\u0004\bU\u0010\u001fR\"\u0010V\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u001b\u001a\u0004\bW\u0010\u001d\"\u0004\bX\u0010\u001fR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010g\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR$\u0010h\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010\u001b\u001a\u0004\bi\u0010\u001d\"\u0004\bj\u0010\u001fR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q\u00a8\u0006s"}, d2 = {"Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "Ljava/io/Serializable;", "", "isGameType", "Lcom/tencent/sqshow/zootopia/mapstatus/b$b;", "mapServerStatusResult", "", "updateDataFromMapServerStatusResult", "", "component1", IZootopiaShareArkService.ARK_MAP_ID, "copy", "", "toString", "hashCode", "", "other", "equals", "I", "getMapID", "()I", "setMapID", "(I)V", "type", "getType", "setType", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "setTypeName", "(Ljava/lang/String;)V", "name", "getName", "setName", "desc", "getDesc", "setDesc", "background", "getBackground", "setBackground", "backgroundType", "getBackgroundType", "setBackgroundType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "labels", "Ljava/util/ArrayList;", "getLabels", "()Ljava/util/ArrayList;", "setLabels", "(Ljava/util/ArrayList;)V", "button", "getButton", "setButton", "Lcom/tencent/sqshow/zootopia/data/ZootopiaSimpleVerInfo;", "simpleVerInfo", "Lcom/tencent/sqshow/zootopia/data/ZootopiaSimpleVerInfo;", "getSimpleVerInfo", "()Lcom/tencent/sqshow/zootopia/data/ZootopiaSimpleVerInfo;", "setSimpleVerInfo", "(Lcom/tencent/sqshow/zootopia/data/ZootopiaSimpleVerInfo;)V", "showOrder", "getShowOrder", "setShowOrder", "mapProjName", "getMapProjName", "setMapProjName", "barPic", "getBarPic", "setBarPic", "sceneType", "getSceneType", "setSceneType", "showGameHealthyLoading", "Z", "getShowGameHealthyLoading", "()Z", "setShowGameHealthyLoading", "(Z)V", "typeIcon", "getTypeIcon", "setTypeIcon", "backColor", "getBackColor", "setBackColor", AppConstants.Key.KEY_QZONE_VIDEO_URL, "getVideoUrl", "setVideoUrl", "Lcom/tencent/sqshow/zootopia/data/ZootopiaButtonState;", "downloadState", "Lcom/tencent/sqshow/zootopia/data/ZootopiaButtonState;", "getDownloadState", "()Lcom/tencent/sqshow/zootopia/data/ZootopiaButtonState;", "setDownloadState", "(Lcom/tencent/sqshow/zootopia/data/ZootopiaButtonState;)V", "Lpv4/j;", "d", "Lpv4/j;", "getReserveItem", "()Lpv4/j;", "setReserveItem", "(Lpv4/j;)V", "reserveItem", "beforeOnlineToast", "getBeforeOnlineToast", "setBeforeOnlineToast", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "loadingParams", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "getLoadingParams", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;", "setLoadingParams", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaMapLoadingParams;)V", "<init>", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final /* data */ class ZootopiaMapSimpleInfo implements Serializable {
    private String backColor;
    private String background;
    private int backgroundType;
    private String barPic;
    private String beforeOnlineToast;
    private String button;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private transient pv4.j reserveItem;
    private String desc;
    private ZootopiaButtonState downloadState;
    private ArrayList<String> labels;
    private ZootopiaMapLoadingParams loadingParams;
    private int mapID;
    private String mapProjName;
    private String name;
    private int sceneType;
    private boolean showGameHealthyLoading;
    private int showOrder;
    private ZootopiaSimpleVerInfo simpleVerInfo;
    private int type;
    private String typeIcon;
    private String typeName;
    private String videoUrl;

    public ZootopiaMapSimpleInfo() {
        this(0, 1, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMapID() {
        return this.mapID;
    }

    public final ZootopiaMapSimpleInfo copy(int mapID) {
        return new ZootopiaMapSimpleInfo(mapID);
    }

    public final String getBackColor() {
        return this.backColor;
    }

    public final String getBackground() {
        return this.background;
    }

    public final int getBackgroundType() {
        return this.backgroundType;
    }

    public final String getBarPic() {
        return this.barPic;
    }

    public final String getBeforeOnlineToast() {
        return this.beforeOnlineToast;
    }

    public final String getButton() {
        return this.button;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final ZootopiaButtonState getDownloadState() {
        return this.downloadState;
    }

    public final ArrayList<String> getLabels() {
        return this.labels;
    }

    public final ZootopiaMapLoadingParams getLoadingParams() {
        return this.loadingParams;
    }

    public final int getMapID() {
        return this.mapID;
    }

    public final String getMapProjName() {
        return this.mapProjName;
    }

    public final String getName() {
        return this.name;
    }

    public final pv4.j getReserveItem() {
        return this.reserveItem;
    }

    public final int getSceneType() {
        return this.sceneType;
    }

    public final boolean getShowGameHealthyLoading() {
        return this.showGameHealthyLoading;
    }

    public final int getShowOrder() {
        return this.showOrder;
    }

    public final ZootopiaSimpleVerInfo getSimpleVerInfo() {
        return this.simpleVerInfo;
    }

    public final int getType() {
        return this.type;
    }

    public final String getTypeIcon() {
        return this.typeIcon;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        return this.mapID;
    }

    public final boolean isGameType() {
        return this.type == 2;
    }

    public final void setBackColor(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backColor = str;
    }

    public final void setBackground(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.background = str;
    }

    public final void setBackgroundType(int i3) {
        this.backgroundType = i3;
    }

    public final void setBarPic(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.barPic = str;
    }

    public final void setBeforeOnlineToast(String str) {
        this.beforeOnlineToast = str;
    }

    public final void setButton(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.button = str;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void setDownloadState(ZootopiaButtonState zootopiaButtonState) {
        Intrinsics.checkNotNullParameter(zootopiaButtonState, "<set-?>");
        this.downloadState = zootopiaButtonState;
    }

    public final void setLabels(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.labels = arrayList;
    }

    public final void setLoadingParams(ZootopiaMapLoadingParams zootopiaMapLoadingParams) {
        this.loadingParams = zootopiaMapLoadingParams;
    }

    public final void setMapID(int i3) {
        this.mapID = i3;
    }

    public final void setMapProjName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mapProjName = str;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void setReserveItem(pv4.j jVar) {
        this.reserveItem = jVar;
    }

    public final void setSceneType(int i3) {
        this.sceneType = i3;
    }

    public final void setShowGameHealthyLoading(boolean z16) {
        this.showGameHealthyLoading = z16;
    }

    public final void setShowOrder(int i3) {
        this.showOrder = i3;
    }

    public final void setSimpleVerInfo(ZootopiaSimpleVerInfo zootopiaSimpleVerInfo) {
        Intrinsics.checkNotNullParameter(zootopiaSimpleVerInfo, "<set-?>");
        this.simpleVerInfo = zootopiaSimpleVerInfo;
    }

    public final void setType(int i3) {
        this.type = i3;
    }

    public final void setTypeIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.typeIcon = str;
    }

    public final void setTypeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.typeName = str;
    }

    public final void setVideoUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoUrl = str;
    }

    public String toString() {
        return "ZootopiaMapSimpleInfo(mapID=" + this.mapID + ")";
    }

    public final void updateDataFromMapServerStatusResult(b.MapServerStatusResult mapServerStatusResult) {
        Intrinsics.checkNotNullParameter(mapServerStatusResult, "mapServerStatusResult");
        this.simpleVerInfo.setModVersionSimpleData(mapServerStatusResult.getModVersionSimpleData());
        this.simpleVerInfo.setMapStatus(mapServerStatusResult.getMapStatus());
        this.simpleVerInfo.setQqVerTip(mapServerStatusResult.getQqVerStatus());
        this.simpleVerInfo.setMapVerTip(mapServerStatusResult.getMapVerStatus());
        this.simpleVerInfo.setDiffPatchInfo(mapServerStatusResult.getDiffPatchInfo());
    }

    public ZootopiaMapSimpleInfo(int i3) {
        this.mapID = i3;
        this.typeName = "";
        this.name = "";
        this.desc = "";
        this.background = "";
        this.labels = new ArrayList<>();
        this.button = "";
        this.simpleVerInfo = new ZootopiaSimpleVerInfo(0, 1, null);
        this.mapProjName = "";
        this.barPic = "";
        this.typeIcon = "";
        this.backColor = "";
        this.videoUrl = "";
        this.downloadState = new ZootopiaButtonState();
    }

    public static /* synthetic */ ZootopiaMapSimpleInfo copy$default(ZootopiaMapSimpleInfo zootopiaMapSimpleInfo, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = zootopiaMapSimpleInfo.mapID;
        }
        return zootopiaMapSimpleInfo.copy(i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ZootopiaMapSimpleInfo) && this.mapID == ((ZootopiaMapSimpleInfo) other).mapID;
    }

    public /* synthetic */ ZootopiaMapSimpleInfo(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }
}
