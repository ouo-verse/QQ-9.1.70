package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QZoneRequestEncoder;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0007\u0010\u0084\u0001\u001a\u00020\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001a\u00103\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\f\"\u0004\b5\u0010\u000eR\u001a\u00106\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0012\"\u0004\b=\u0010\u0014R\u001a\u0010>\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010\u0014R\u001a\u0010@\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010'\"\u0004\bB\u0010)R\u001a\u0010C\u001a\u00020DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010'\"\u0004\bQ\u0010)R\u001a\u0010R\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\f\"\u0004\bT\u0010\u000eR\u001a\u0010U\u001a\u00020VX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u001a\u0010[\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\f\"\u0004\b]\u0010\u000eR\u001a\u0010^\u001a\u00020_X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010!\"\u0004\bf\u0010#R\u001a\u0010g\u001a\u00020hX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\b=\u0010kR\u001a\u0010l\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010!\"\u0004\bn\u0010#R\u001a\u0010o\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010!\"\u0004\bq\u0010#R\u001a\u0010r\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010'\"\u0004\bt\u0010)R\u001a\u0010u\u001a\u00020vX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001a\u0010{\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b|\u0010'\"\u0004\b}\u0010)R\u001e\u0010~\u001a\u00020\u007fX\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001\u00a8\u0006\u0085\u0001"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "", "()V", "activeAlbumInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonActiveAlbumInfo;", "getActiveAlbumInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonActiveAlbumInfo;", "setActiveAlbumInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonActiveAlbumInfo;)V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "allowShare", "", "getAllowShare", "()Z", "setAllowShare", "(Z)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "getBitmap", "setBitmap", "cover", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", QZoneRequestEncoder.KEY_COVER_REQ, "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "setCover", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;)V", "coverType", "", "getCoverType", "()I", "setCoverType", "(I)V", WadlProxyConsts.CREATE_TIME, "", "getCreateTime", "()J", "setCreateTime", "(J)V", "creator", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "getCreator", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;", "setCreator", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStUser;)V", "defaultDesc", "getDefaultDesc", "setDefaultDesc", "desc", "getDesc", "setDesc", "familyAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonFamilyAlbumMeta;", "getFamilyAlbum", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonFamilyAlbumMeta;", "setFamilyAlbum", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonFamilyAlbumMeta;)V", "isShareAlbum", "setShareAlbum", "isSubscribe", "setSubscribe", "lastUploadTime", "getLastUploadTime", "setLastUploadTime", "loverAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonLoverAlbumMeta;", "getLoverAlbum", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonLoverAlbumMeta;", "setLoverAlbum", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonLoverAlbumMeta;)V", "memoryInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMemoryInfo;", "getMemoryInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMemoryInfo;", "setMemoryInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMemoryInfo;)V", "modifyTime", "getModifyTime", "setModifyTime", "name", "getName", "setName", "opInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumOpInfo;", "getOpInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumOpInfo;", "setOpInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumOpInfo;)V", "owner", "getOwner", "setOwner", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumAccessPermission;", "getPermission", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumAccessPermission;", "setPermission", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumAccessPermission;)V", "qzAlbumType", "getQzAlbumType", "setQzAlbumType", "shareAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareAlbumMeta;", "getShareAlbum", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareAlbumMeta;", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareAlbumMeta;)V", "sortType", "getSortType", "setSortType", "status", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "setStatus", "topFlag", "getTopFlag", "setTopFlag", "travelAlbum", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonTravelAlbumMeta;", "getTravelAlbum", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonTravelAlbumMeta;", "setTravelAlbum", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonTravelAlbumMeta;)V", "uploadNumber", "getUploadNumber", "setUploadNumber", "visitorInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStFeedCellVisitor;", "getVisitorInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStFeedCellVisitor;", "setVisitorInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStFeedCellVisitor;)V", "copy", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonAlbumInfo {
    public static final int $stable = 8;
    private boolean allowShare;
    private int coverType;
    private long createTime;
    private boolean isShareAlbum;
    private boolean isSubscribe;
    private long lastUploadTime;
    private long modifyTime;
    private int qzAlbumType;
    private int sortType;
    private int status;
    private long topFlag;
    private long uploadNumber;
    private String albumId = "";
    private String owner = "";
    private String name = "";
    private String desc = "";
    private CommonStMedia cover = new CommonStMedia();
    private CommonStUser creator = new CommonStUser();
    private CommonAlbumAccessPermission permission = new CommonAlbumAccessPermission();
    private String bitmap = "";
    private CommonShareAlbumMeta shareAlbum = new CommonShareAlbumMeta();
    private CommonFamilyAlbumMeta familyAlbum = new CommonFamilyAlbumMeta();
    private CommonLoverAlbumMeta loverAlbum = new CommonLoverAlbumMeta();
    private CommonTravelAlbumMeta travelAlbum = new CommonTravelAlbumMeta();
    private CommonStFeedCellVisitor visitorInfo = new CommonStFeedCellVisitor();
    private String defaultDesc = "";
    private CommonAlbumOpInfo opInfo = new CommonAlbumOpInfo();
    private CommonActiveAlbumInfo activeAlbumInfo = new CommonActiveAlbumInfo();
    private CommonMemoryInfo memoryInfo = new CommonMemoryInfo();

    public final CommonAlbumInfo copy() {
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        commonAlbumInfo.albumId = this.albumId;
        commonAlbumInfo.owner = this.owner;
        commonAlbumInfo.name = this.name;
        commonAlbumInfo.desc = this.desc;
        commonAlbumInfo.createTime = this.createTime;
        commonAlbumInfo.modifyTime = this.modifyTime;
        commonAlbumInfo.lastUploadTime = this.lastUploadTime;
        commonAlbumInfo.uploadNumber = this.uploadNumber;
        commonAlbumInfo.cover = this.cover;
        commonAlbumInfo.creator = this.creator;
        commonAlbumInfo.topFlag = this.topFlag;
        commonAlbumInfo.status = this.status;
        commonAlbumInfo.permission = this.permission;
        commonAlbumInfo.allowShare = this.allowShare;
        commonAlbumInfo.isSubscribe = this.isSubscribe;
        commonAlbumInfo.bitmap = this.bitmap;
        commonAlbumInfo.isShareAlbum = this.isShareAlbum;
        commonAlbumInfo.shareAlbum = this.shareAlbum;
        commonAlbumInfo.qzAlbumType = this.qzAlbumType;
        commonAlbumInfo.familyAlbum = this.familyAlbum;
        commonAlbumInfo.loverAlbum = this.loverAlbum;
        commonAlbumInfo.coverType = this.coverType;
        commonAlbumInfo.travelAlbum = this.travelAlbum;
        commonAlbumInfo.visitorInfo = this.visitorInfo;
        commonAlbumInfo.defaultDesc = this.defaultDesc;
        commonAlbumInfo.opInfo = this.opInfo;
        commonAlbumInfo.activeAlbumInfo = this.activeAlbumInfo;
        commonAlbumInfo.memoryInfo = this.memoryInfo;
        commonAlbumInfo.sortType = this.sortType;
        return commonAlbumInfo;
    }

    public final CommonActiveAlbumInfo getActiveAlbumInfo() {
        return this.activeAlbumInfo;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final boolean getAllowShare() {
        return this.allowShare;
    }

    public final String getBitmap() {
        return this.bitmap;
    }

    public final CommonStMedia getCover() {
        return this.cover;
    }

    public final int getCoverType() {
        return this.coverType;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final CommonStUser getCreator() {
        return this.creator;
    }

    public final String getDefaultDesc() {
        return this.defaultDesc;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final CommonFamilyAlbumMeta getFamilyAlbum() {
        return this.familyAlbum;
    }

    public final long getLastUploadTime() {
        return this.lastUploadTime;
    }

    public final CommonLoverAlbumMeta getLoverAlbum() {
        return this.loverAlbum;
    }

    public final CommonMemoryInfo getMemoryInfo() {
        return this.memoryInfo;
    }

    public final long getModifyTime() {
        return this.modifyTime;
    }

    public final String getName() {
        return this.name;
    }

    public final CommonAlbumOpInfo getOpInfo() {
        return this.opInfo;
    }

    public final String getOwner() {
        return this.owner;
    }

    public final CommonAlbumAccessPermission getPermission() {
        return this.permission;
    }

    public final int getQzAlbumType() {
        return this.qzAlbumType;
    }

    public final CommonShareAlbumMeta getShareAlbum() {
        return this.shareAlbum;
    }

    public final int getSortType() {
        return this.sortType;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTopFlag() {
        return this.topFlag;
    }

    public final CommonTravelAlbumMeta getTravelAlbum() {
        return this.travelAlbum;
    }

    public final long getUploadNumber() {
        return this.uploadNumber;
    }

    public final CommonStFeedCellVisitor getVisitorInfo() {
        return this.visitorInfo;
    }

    /* renamed from: isShareAlbum, reason: from getter */
    public final boolean getIsShareAlbum() {
        return this.isShareAlbum;
    }

    /* renamed from: isSubscribe, reason: from getter */
    public final boolean getIsSubscribe() {
        return this.isSubscribe;
    }

    public final void setActiveAlbumInfo(CommonActiveAlbumInfo commonActiveAlbumInfo) {
        this.activeAlbumInfo = commonActiveAlbumInfo;
    }

    public final void setAlbumId(String str) {
        this.albumId = str;
    }

    public final void setAllowShare(boolean z16) {
        this.allowShare = z16;
    }

    public final void setBitmap(String str) {
        this.bitmap = str;
    }

    public final void setCover(CommonStMedia commonStMedia) {
        this.cover = commonStMedia;
    }

    public final void setCoverType(int i3) {
        this.coverType = i3;
    }

    public final void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public final void setCreator(CommonStUser commonStUser) {
        this.creator = commonStUser;
    }

    public final void setDefaultDesc(String str) {
        this.defaultDesc = str;
    }

    public final void setDesc(String str) {
        this.desc = str;
    }

    public final void setFamilyAlbum(CommonFamilyAlbumMeta commonFamilyAlbumMeta) {
        this.familyAlbum = commonFamilyAlbumMeta;
    }

    public final void setLastUploadTime(long j3) {
        this.lastUploadTime = j3;
    }

    public final void setLoverAlbum(CommonLoverAlbumMeta commonLoverAlbumMeta) {
        this.loverAlbum = commonLoverAlbumMeta;
    }

    public final void setMemoryInfo(CommonMemoryInfo commonMemoryInfo) {
        this.memoryInfo = commonMemoryInfo;
    }

    public final void setModifyTime(long j3) {
        this.modifyTime = j3;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOpInfo(CommonAlbumOpInfo commonAlbumOpInfo) {
        this.opInfo = commonAlbumOpInfo;
    }

    public final void setOwner(String str) {
        this.owner = str;
    }

    public final void setPermission(CommonAlbumAccessPermission commonAlbumAccessPermission) {
        this.permission = commonAlbumAccessPermission;
    }

    public final void setQzAlbumType(int i3) {
        this.qzAlbumType = i3;
    }

    public final void setShareAlbum(boolean z16) {
        this.isShareAlbum = z16;
    }

    public final void setSortType(int i3) {
        this.sortType = i3;
    }

    public final void setStatus(int i3) {
        this.status = i3;
    }

    public final void setSubscribe(boolean z16) {
        this.isSubscribe = z16;
    }

    public final void setTopFlag(long j3) {
        this.topFlag = j3;
    }

    public final void setTravelAlbum(CommonTravelAlbumMeta commonTravelAlbumMeta) {
        this.travelAlbum = commonTravelAlbumMeta;
    }

    public final void setUploadNumber(long j3) {
        this.uploadNumber = j3;
    }

    public final void setVisitorInfo(CommonStFeedCellVisitor commonStFeedCellVisitor) {
        this.visitorInfo = commonStFeedCellVisitor;
    }

    public final void setShareAlbum(CommonShareAlbumMeta commonShareAlbumMeta) {
        this.shareAlbum = commonShareAlbumMeta;
    }
}
