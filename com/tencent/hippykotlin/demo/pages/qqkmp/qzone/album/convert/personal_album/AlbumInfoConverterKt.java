package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonActiveAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumAccessPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumOpInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonFamilyAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonLoverAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonShareAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStFeedCellVisitor;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonTravelAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ActiveAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumAccessPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumOpInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.FamilyAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.LoverAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ShareAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellVisitor;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.TravelAlbumMeta;
import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"toAlbumInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumInfo;", "toCommonAlbumInfo", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class AlbumInfoConverterKt {
    public static final AlbumInfo toAlbumInfo(CommonAlbumInfo commonAlbumInfo) {
        Boolean bool = null;
        AlbumInfo albumInfo = new AlbumInfo(null, null, null, null, null, null, null, null, null, null, null, null, null, null, bool, bool, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null);
        albumInfo.albumId = commonAlbumInfo.getAlbumId();
        albumInfo.owner = commonAlbumInfo.getOwner();
        albumInfo.name = commonAlbumInfo.getName();
        albumInfo.desc = commonAlbumInfo.getDesc();
        albumInfo.modifyTime = Long.valueOf(commonAlbumInfo.getModifyTime());
        albumInfo.lastUploadTime = Long.valueOf(commonAlbumInfo.getLastUploadTime());
        albumInfo.createTime = Long.valueOf(commonAlbumInfo.getCreateTime());
        albumInfo.uploadNumber = Long.valueOf(commonAlbumInfo.getUploadNumber());
        albumInfo.cover = AlbumStMediaConverterKt.toStMedia(commonAlbumInfo.getCover());
        albumInfo.creator = AlbumStUserConverterKt.toStUser(commonAlbumInfo.getCreator());
        albumInfo.topFlag = Long.valueOf(commonAlbumInfo.getTopFlag());
        albumInfo.status = Integer.valueOf(commonAlbumInfo.getStatus());
        albumInfo.permission = QZAlbumxConverterKt.toNTAlbumAccessPermission(commonAlbumInfo.getPermission());
        albumInfo.allowShare = Boolean.valueOf(commonAlbumInfo.getAllowShare());
        albumInfo.isSubscribe = Boolean.valueOf(commonAlbumInfo.getIsSubscribe());
        albumInfo.bitmap = commonAlbumInfo.getBitmap();
        albumInfo.isShareAlbum = Boolean.valueOf(commonAlbumInfo.getIsShareAlbum());
        albumInfo.qzAlbumType = Integer.valueOf(commonAlbumInfo.getQzAlbumType());
        albumInfo.shareAlbum = QZAlbumxConverterKt.toNTShareAlbumMeta(commonAlbumInfo.getShareAlbum());
        albumInfo.familyAlbum = QZAlbumxConverterKt.toNTFamilyAlbumMeta(commonAlbumInfo.getFamilyAlbum());
        albumInfo.loverAlbum = QZAlbumxConverterKt.toNTLoverAlbumMeta(commonAlbumInfo.getLoverAlbum());
        albumInfo.travelAlbum = QZAlbumxConverterKt.toNTTravelAlbumMeta(commonAlbumInfo.getTravelAlbum());
        albumInfo.visitorInfo = QZAlbumxConverterKt.toNTStFeedCellVisitor(commonAlbumInfo.getVisitorInfo());
        albumInfo.coverType = Integer.valueOf(commonAlbumInfo.getCoverType());
        albumInfo.defaultDesc = commonAlbumInfo.getDefaultDesc();
        albumInfo.opInfo = QZAlbumxConverterKt.toNTAlbumOpInfo(commonAlbumInfo.getOpInfo());
        albumInfo.activeAlbum = QZAlbumxConverterKt.toNTActiveAlbumInfo(commonAlbumInfo.getActiveAlbumInfo());
        albumInfo.sortType = Integer.valueOf(commonAlbumInfo.getSortType());
        return albumInfo;
    }

    public static final CommonAlbumInfo toCommonAlbumInfo(AlbumInfo albumInfo) {
        CommonStMedia commonStMedia;
        CommonStUser commonStUser;
        CommonAlbumAccessPermission commonAlbumAccessPermission;
        CommonShareAlbumMeta commonShareAlbumMeta;
        CommonFamilyAlbumMeta commonFamilyAlbumMeta;
        CommonLoverAlbumMeta commonLoverAlbumMeta;
        CommonTravelAlbumMeta commonTravelAlbumMeta;
        CommonStFeedCellVisitor commonStFeedCellVisitor;
        CommonAlbumOpInfo commonAlbumOpInfo;
        CommonActiveAlbumInfo commonActiveAlbumInfo;
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        String str = albumInfo.albumId;
        if (str == null) {
            str = "";
        }
        commonAlbumInfo.setAlbumId(str);
        String str2 = albumInfo.owner;
        if (str2 == null) {
            str2 = "";
        }
        commonAlbumInfo.setOwner(str2);
        String str3 = albumInfo.name;
        if (str3 == null) {
            str3 = "";
        }
        commonAlbumInfo.setName(str3);
        String str4 = albumInfo.desc;
        if (str4 == null) {
            str4 = "";
        }
        commonAlbumInfo.setDesc(str4);
        Long l3 = albumInfo.createTime;
        commonAlbumInfo.setCreateTime(l3 != null ? l3.longValue() : 0L);
        Long l16 = albumInfo.modifyTime;
        commonAlbumInfo.setModifyTime(l16 != null ? l16.longValue() : 0L);
        Long l17 = albumInfo.lastUploadTime;
        commonAlbumInfo.setLastUploadTime(l17 != null ? l17.longValue() : 0L);
        Long l18 = albumInfo.uploadNumber;
        commonAlbumInfo.setUploadNumber(l18 != null ? l18.longValue() : 0L);
        StMedia stMedia = albumInfo.cover;
        if (stMedia == null || (commonStMedia = AlbumStMediaConverterKt.toCommonStMedia(stMedia)) == null) {
            commonStMedia = new CommonStMedia();
        }
        commonAlbumInfo.setCover(commonStMedia);
        StUser stUser = albumInfo.creator;
        if (stUser == null || (commonStUser = AlbumStUserConverterKt.toCommonStUser(stUser)) == null) {
            commonStUser = new CommonStUser();
        }
        commonAlbumInfo.setCreator(commonStUser);
        Long l19 = albumInfo.topFlag;
        commonAlbumInfo.setTopFlag(l19 != null ? l19.longValue() : 0L);
        Integer num = albumInfo.status;
        commonAlbumInfo.setStatus(num != null ? num.intValue() : 0);
        AlbumAccessPermission albumAccessPermission = albumInfo.permission;
        if (albumAccessPermission == null || (commonAlbumAccessPermission = QZAlbumxConverterKt.toCommonAlbumAccessPermission(albumAccessPermission)) == null) {
            commonAlbumAccessPermission = new CommonAlbumAccessPermission();
        }
        commonAlbumInfo.setPermission(commonAlbumAccessPermission);
        Boolean bool = albumInfo.allowShare;
        commonAlbumInfo.setAllowShare(bool != null ? bool.booleanValue() : false);
        Boolean bool2 = albumInfo.isSubscribe;
        commonAlbumInfo.setSubscribe(bool2 != null ? bool2.booleanValue() : false);
        String str5 = albumInfo.bitmap;
        if (str5 == null) {
            str5 = "";
        }
        commonAlbumInfo.setBitmap(str5);
        Boolean bool3 = albumInfo.isShareAlbum;
        commonAlbumInfo.setShareAlbum(bool3 != null ? bool3.booleanValue() : false);
        Integer num2 = albumInfo.qzAlbumType;
        commonAlbumInfo.setQzAlbumType(num2 != null ? num2.intValue() : 0);
        ShareAlbumMeta shareAlbumMeta = albumInfo.shareAlbum;
        if (shareAlbumMeta == null || (commonShareAlbumMeta = QZAlbumxConverterKt.toCommonShareAlbumMeta(shareAlbumMeta)) == null) {
            commonShareAlbumMeta = new CommonShareAlbumMeta();
        }
        commonAlbumInfo.setShareAlbum(commonShareAlbumMeta);
        FamilyAlbumMeta familyAlbumMeta = albumInfo.familyAlbum;
        if (familyAlbumMeta == null || (commonFamilyAlbumMeta = QZAlbumxConverterKt.toCommonFamilyAlbumMeta(familyAlbumMeta)) == null) {
            commonFamilyAlbumMeta = new CommonFamilyAlbumMeta();
        }
        commonAlbumInfo.setFamilyAlbum(commonFamilyAlbumMeta);
        LoverAlbumMeta loverAlbumMeta = albumInfo.loverAlbum;
        if (loverAlbumMeta == null || (commonLoverAlbumMeta = QZAlbumxConverterKt.toCommonLoverAlbumMeta(loverAlbumMeta)) == null) {
            commonLoverAlbumMeta = new CommonLoverAlbumMeta();
        }
        commonAlbumInfo.setLoverAlbum(commonLoverAlbumMeta);
        Integer num3 = albumInfo.coverType;
        commonAlbumInfo.setCoverType(num3 != null ? num3.intValue() : 0);
        TravelAlbumMeta travelAlbumMeta = albumInfo.travelAlbum;
        if (travelAlbumMeta == null || (commonTravelAlbumMeta = QZAlbumxConverterKt.toCommonTravelAlbumMeta(travelAlbumMeta)) == null) {
            commonTravelAlbumMeta = new CommonTravelAlbumMeta();
        }
        commonAlbumInfo.setTravelAlbum(commonTravelAlbumMeta);
        StFeedCellVisitor stFeedCellVisitor = albumInfo.visitorInfo;
        if (stFeedCellVisitor == null || (commonStFeedCellVisitor = QZAlbumxConverterKt.toCommonStFeedCellVisitor(stFeedCellVisitor)) == null) {
            commonStFeedCellVisitor = new CommonStFeedCellVisitor();
        }
        commonAlbumInfo.setVisitorInfo(commonStFeedCellVisitor);
        String str6 = albumInfo.defaultDesc;
        commonAlbumInfo.setDefaultDesc(str6 != null ? str6 : "");
        AlbumOpInfo albumOpInfo = albumInfo.opInfo;
        if (albumOpInfo == null || (commonAlbumOpInfo = QZAlbumxConverterKt.toCommonAlbumOpInfo(albumOpInfo)) == null) {
            commonAlbumOpInfo = new CommonAlbumOpInfo();
        }
        commonAlbumInfo.setOpInfo(commonAlbumOpInfo);
        ActiveAlbumInfo activeAlbumInfo = albumInfo.activeAlbum;
        if (activeAlbumInfo == null || (commonActiveAlbumInfo = QZAlbumxConverterKt.toCommonActiveAlbumInfo(activeAlbumInfo)) == null) {
            commonActiveAlbumInfo = new CommonActiveAlbumInfo();
        }
        commonAlbumInfo.setActiveAlbumInfo(commonActiveAlbumInfo);
        Integer num4 = albumInfo.sortType;
        commonAlbumInfo.setSortType(num4 != null ? num4.intValue() : 0);
        return commonAlbumInfo;
    }
}
