package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AlbumInfo {
    public ActiveAlbumInfo activeAlbum;
    public String albumId;
    public boolean allowShare;
    public String bitmap;
    public int busiType;
    public StMedia cover;
    public int coverType;
    public long createTime;
    public StUser creator;
    public String defaultDesc;
    public String desc;
    public FamilyAlbumMeta familyAlbum;
    public boolean isShareAlbum;
    public boolean isSubscribe;
    public long lastUploadTime;
    public LoverAlbumMeta loverAlbum;
    public MemoryInfo memoryInfo;
    public long modifyTime;
    public String name;
    public AlbumOpInfo opInfo;
    public String owner;
    public AlbumAccessPermission permission;
    public int qzAlbumType;
    public ShareAlbumMeta shareAlbum;
    public int sortType;
    public int status;
    public long topFlag;
    public TravelAlbumMeta travelAlbum;
    public long uploadNumber;
    public StFeedCellVisitor visitorInfo;

    public AlbumInfo() {
        this.albumId = "";
        this.owner = "";
        this.name = "";
        this.desc = "";
        this.cover = new StMedia();
        this.creator = new StUser();
        this.permission = new AlbumAccessPermission();
        this.bitmap = "";
        this.shareAlbum = new ShareAlbumMeta();
        this.familyAlbum = new FamilyAlbumMeta();
        this.loverAlbum = new LoverAlbumMeta();
        this.travelAlbum = new TravelAlbumMeta();
        this.visitorInfo = new StFeedCellVisitor();
        this.defaultDesc = "";
        this.opInfo = new AlbumOpInfo();
        this.activeAlbum = new ActiveAlbumInfo();
        this.memoryInfo = new MemoryInfo();
    }

    public ActiveAlbumInfo getActiveAlbum() {
        return this.activeAlbum;
    }

    public String getAlbumId() {
        return this.albumId;
    }

    public boolean getAllowShare() {
        return this.allowShare;
    }

    public String getBitmap() {
        return this.bitmap;
    }

    public int getBusiType() {
        return this.busiType;
    }

    public StMedia getCover() {
        return this.cover;
    }

    public int getCoverType() {
        return this.coverType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public StUser getCreator() {
        return this.creator;
    }

    public String getDefaultDesc() {
        return this.defaultDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public FamilyAlbumMeta getFamilyAlbum() {
        return this.familyAlbum;
    }

    public boolean getIsShareAlbum() {
        return this.isShareAlbum;
    }

    public boolean getIsSubscribe() {
        return this.isSubscribe;
    }

    public long getLastUploadTime() {
        return this.lastUploadTime;
    }

    public LoverAlbumMeta getLoverAlbum() {
        return this.loverAlbum;
    }

    public MemoryInfo getMemoryInfo() {
        return this.memoryInfo;
    }

    public long getModifyTime() {
        return this.modifyTime;
    }

    public String getName() {
        return this.name;
    }

    public AlbumOpInfo getOpInfo() {
        return this.opInfo;
    }

    public String getOwner() {
        return this.owner;
    }

    public AlbumAccessPermission getPermission() {
        return this.permission;
    }

    public int getQzAlbumType() {
        return this.qzAlbumType;
    }

    public ShareAlbumMeta getShareAlbum() {
        return this.shareAlbum;
    }

    public int getSortType() {
        return this.sortType;
    }

    public int getStatus() {
        return this.status;
    }

    public long getTopFlag() {
        return this.topFlag;
    }

    public TravelAlbumMeta getTravelAlbum() {
        return this.travelAlbum;
    }

    public long getUploadNumber() {
        return this.uploadNumber;
    }

    public StFeedCellVisitor getVisitorInfo() {
        return this.visitorInfo;
    }

    public void setActiveAlbum(ActiveAlbumInfo activeAlbumInfo) {
        this.activeAlbum = activeAlbumInfo;
    }

    public void setAlbumId(String str) {
        this.albumId = str;
    }

    public void setAllowShare(boolean z16) {
        this.allowShare = z16;
    }

    public void setBitmap(String str) {
        this.bitmap = str;
    }

    public void setBusiType(int i3) {
        this.busiType = i3;
    }

    public void setCover(StMedia stMedia) {
        this.cover = stMedia;
    }

    public void setCoverType(int i3) {
        this.coverType = i3;
    }

    public void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public void setCreator(StUser stUser) {
        this.creator = stUser;
    }

    public void setDefaultDesc(String str) {
        this.defaultDesc = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setFamilyAlbum(FamilyAlbumMeta familyAlbumMeta) {
        this.familyAlbum = familyAlbumMeta;
    }

    public void setIsShareAlbum(boolean z16) {
        this.isShareAlbum = z16;
    }

    public void setIsSubscribe(boolean z16) {
        this.isSubscribe = z16;
    }

    public void setLastUploadTime(long j3) {
        this.lastUploadTime = j3;
    }

    public void setLoverAlbum(LoverAlbumMeta loverAlbumMeta) {
        this.loverAlbum = loverAlbumMeta;
    }

    public void setMemoryInfo(MemoryInfo memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public void setModifyTime(long j3) {
        this.modifyTime = j3;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpInfo(AlbumOpInfo albumOpInfo) {
        this.opInfo = albumOpInfo;
    }

    public void setOwner(String str) {
        this.owner = str;
    }

    public void setPermission(AlbumAccessPermission albumAccessPermission) {
        this.permission = albumAccessPermission;
    }

    public void setQzAlbumType(int i3) {
        this.qzAlbumType = i3;
    }

    public void setShareAlbum(ShareAlbumMeta shareAlbumMeta) {
        this.shareAlbum = shareAlbumMeta;
    }

    public void setSortType(int i3) {
        this.sortType = i3;
    }

    public void setStatus(int i3) {
        this.status = i3;
    }

    public void setTopFlag(long j3) {
        this.topFlag = j3;
    }

    public void setTravelAlbum(TravelAlbumMeta travelAlbumMeta) {
        this.travelAlbum = travelAlbumMeta;
    }

    public void setUploadNumber(long j3) {
        this.uploadNumber = j3;
    }

    public void setVisitorInfo(StFeedCellVisitor stFeedCellVisitor) {
        this.visitorInfo = stFeedCellVisitor;
    }

    public AlbumInfo(String str, String str2, String str3, String str4, long j3, long j16, long j17, long j18, StMedia stMedia, StUser stUser, long j19, int i3, int i16, AlbumAccessPermission albumAccessPermission, boolean z16, boolean z17, String str5, boolean z18, ShareAlbumMeta shareAlbumMeta, int i17, FamilyAlbumMeta familyAlbumMeta, LoverAlbumMeta loverAlbumMeta, int i18, TravelAlbumMeta travelAlbumMeta, StFeedCellVisitor stFeedCellVisitor, String str6, AlbumOpInfo albumOpInfo, ActiveAlbumInfo activeAlbumInfo) {
        this.albumId = "";
        this.owner = "";
        this.name = "";
        this.desc = "";
        this.cover = new StMedia();
        this.creator = new StUser();
        this.permission = new AlbumAccessPermission();
        this.bitmap = "";
        this.shareAlbum = new ShareAlbumMeta();
        this.familyAlbum = new FamilyAlbumMeta();
        this.loverAlbum = new LoverAlbumMeta();
        this.travelAlbum = new TravelAlbumMeta();
        this.visitorInfo = new StFeedCellVisitor();
        this.defaultDesc = "";
        this.opInfo = new AlbumOpInfo();
        this.activeAlbum = new ActiveAlbumInfo();
        this.memoryInfo = new MemoryInfo();
        this.albumId = str;
        this.owner = str2;
        this.name = str3;
        this.desc = str4;
        this.createTime = j3;
        this.modifyTime = j16;
        this.lastUploadTime = j17;
        this.uploadNumber = j18;
        this.cover = stMedia;
        this.creator = stUser;
        this.topFlag = j19;
        this.busiType = i3;
        this.status = i16;
        this.permission = albumAccessPermission;
        this.allowShare = z16;
        this.isSubscribe = z17;
        this.bitmap = str5;
        this.isShareAlbum = z18;
        this.shareAlbum = shareAlbumMeta;
        this.qzAlbumType = i17;
        this.familyAlbum = familyAlbumMeta;
        this.loverAlbum = loverAlbumMeta;
        this.coverType = i18;
        this.travelAlbum = travelAlbumMeta;
        this.visitorInfo = stFeedCellVisitor;
        this.defaultDesc = str6;
        this.opInfo = albumOpInfo;
        this.activeAlbum = activeAlbumInfo;
    }
}
