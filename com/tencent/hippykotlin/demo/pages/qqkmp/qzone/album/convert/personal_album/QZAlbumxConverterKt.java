package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonActiveAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumAccessPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumOpInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonBatchInfoBanner;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonClientAttr;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonFamilyAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonLoverAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonMediaLbsArea;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonMediaLbsAreaList;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonPageEndMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonRecommendMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonShareAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonShareToArk;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonShareToQzone;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStFeedCellVisitor;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStShare;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonTimeEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonTimeEventOp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonTravelAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonUinAttr;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.base.share_album_meta.ClientAttr;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.base.share_album_meta.UinAttr;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.media_commreader.media_commreader.RecommendMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ActiveAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumAccessPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.AlbumOpInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfoBanner;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.FamilyAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.LoverAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MediaLbsArea;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.MediaLbsAreaList;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.PageEndMsg;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ShareAlbumMeta;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ShareToArk;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.ShareToQzone;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellVisitor;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StShare;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.TimeEvent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.TimeEventOp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.TravelAlbumMeta;
import java.util.Iterator;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00cc\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0017\u001a\n\u0010\u0018\u001a\u00020\u0019*\u00020\u001a\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\u001d\u001a\n\u0010\u001e\u001a\u00020\u001f*\u00020 \u001a\n\u0010!\u001a\u00020\"*\u00020#\u001a\n\u0010$\u001a\u00020%*\u00020&\u001a\n\u0010'\u001a\u00020(*\u00020)\u001a\n\u0010*\u001a\u00020+*\u00020,\u001a\n\u0010-\u001a\u00020.*\u00020/\u001a\n\u00100\u001a\u000201*\u000202\u001a\n\u00103\u001a\u000204*\u000205\u001a\n\u00106\u001a\u000207*\u000208\u001a\n\u00109\u001a\u00020:*\u00020;\u001a\n\u0010<\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010=\u001a\u00020\u0005*\u00020\u0004\u001a\n\u0010>\u001a\u00020\b*\u00020\u0007\u001a\n\u0010?\u001a\u00020\u000e*\u00020\r\u001a\n\u0010@\u001a\u00020\u0011*\u00020\u0010\u001a\n\u0010A\u001a\u00020\u0014*\u00020\u0013\u001a\n\u0010B\u001a\u00020#*\u00020\"\u001a\n\u0010C\u001a\u00020,*\u00020+\u001a\n\u0010D\u001a\u000202*\u000201\u001a\n\u0010E\u001a\u000205*\u000204\u001a\n\u0010F\u001a\u000208*\u000207\u001a\n\u0010G\u001a\u00020;*\u00020:\u00a8\u0006H"}, d2 = {"toCommonActiveAlbumInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonActiveAlbumInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ActiveAlbumInfo;", "toCommonAlbumAccessPermission", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumAccessPermission;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumAccessPermission;", "toCommonAlbumOpInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonAlbumOpInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/AlbumOpInfo;", "toCommonBatchInfoBanner", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfoBanner;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfoBanner;", "toCommonClientAttr", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonClientAttr;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/base/share_album_meta/ClientAttr;", "toCommonFamilyAlbumMeta", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonFamilyAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/FamilyAlbumMeta;", "toCommonLoverAlbumMeta", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonLoverAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/LoverAlbumMeta;", "toCommonMediaLbsArea", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsArea;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaLbsArea;", "toCommonMediaLbsAreaList", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonMediaLbsAreaList;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/MediaLbsAreaList;", "toCommonPageEndMsg", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonPageEndMsg;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/PageEndMsg;", "toCommonRecommendMedia", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonRecommendMedia;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/media_commreader/media_commreader/RecommendMedia;", "toCommonShareAlbumMeta", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ShareAlbumMeta;", "toCommonShareToArk", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToArk;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ShareToArk;", "toCommonShareToQzone", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonShareToQzone;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/ShareToQzone;", "toCommonStFeedCellVisitor", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStFeedCellVisitor;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;", "toCommonStShare", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStShare;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StShare;", "toCommonTimeEvent", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonTimeEvent;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TimeEvent;", "toCommonTimeEventOp", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonTimeEventOp;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TimeEventOp;", "toCommonTravelAlbumMeta", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonTravelAlbumMeta;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/TravelAlbumMeta;", "toCommonUinAttr", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonUinAttr;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/base/share_album_meta/UinAttr;", "toNTActiveAlbumInfo", "toNTAlbumAccessPermission", "toNTAlbumOpInfo", "toNTClientAttr", "toNTFamilyAlbumMeta", "toNTLoverAlbumMeta", "toNTShareAlbumMeta", "toNTStFeedCellVisitor", "toNTTimeEvent", "toNTTimeEventOp", "toNTTravelAlbumMeta", "toNTUinAttr", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZAlbumxConverterKt {
    public static final CommonActiveAlbumInfo toCommonActiveAlbumInfo(ActiveAlbumInfo activeAlbumInfo) {
        CommonActiveAlbumInfo commonActiveAlbumInfo = new CommonActiveAlbumInfo();
        Boolean bool = activeAlbumInfo.isActiveAlbum;
        commonActiveAlbumInfo.setActiveAlbum(bool != null ? bool.booleanValue() : false);
        String str = activeAlbumInfo.jumpUrl;
        if (str == null) {
            str = "";
        }
        commonActiveAlbumInfo.setJumpUrl(str);
        return commonActiveAlbumInfo;
    }

    public static final CommonAlbumAccessPermission toCommonAlbumAccessPermission(AlbumAccessPermission albumAccessPermission) {
        CommonAlbumAccessPermission commonAlbumAccessPermission = new CommonAlbumAccessPermission();
        Integer num = albumAccessPermission.permissionType;
        commonAlbumAccessPermission.setPermissionType(num != null ? num.intValue() : 0);
        String str = albumAccessPermission.answer;
        if (str == null) {
            str = "";
        }
        commonAlbumAccessPermission.setAnswer(str);
        String str2 = albumAccessPermission.question;
        commonAlbumAccessPermission.setQuestion(str2 != null ? str2 : "");
        Iterator<T> it = albumAccessPermission.whiteList.iterator();
        while (it.hasNext()) {
            commonAlbumAccessPermission.getWhiteList().add(AlbumStUserConverterKt.toCommonStUser((StUser) it.next()));
        }
        return commonAlbumAccessPermission;
    }

    public static final CommonAlbumOpInfo toCommonAlbumOpInfo(AlbumOpInfo albumOpInfo) {
        CommonAlbumOpInfo commonAlbumOpInfo = new CommonAlbumOpInfo();
        Integer num = albumOpInfo.lastDeleteTime;
        commonAlbumOpInfo.setLastDeleteTime(num != null ? num.intValue() : 0);
        Integer num2 = albumOpInfo.lastDeleteCount;
        commonAlbumOpInfo.setLastDeleteCount(num2 != null ? num2.intValue() : 0);
        Boolean bool = albumOpInfo.recentlyUpdated;
        commonAlbumOpInfo.setRecentlyUpdated(bool != null ? bool.booleanValue() : false);
        Boolean bool2 = albumOpInfo.prohibitModifyAlbumType;
        commonAlbumOpInfo.setProhibitModifyAlbumType(bool2 != null ? bool2.booleanValue() : false);
        return commonAlbumOpInfo;
    }

    public static final CommonBatchInfoBanner toCommonBatchInfoBanner(BatchInfoBanner batchInfoBanner) {
        CommonBatchInfoBanner commonBatchInfoBanner = new CommonBatchInfoBanner();
        Integer num = batchInfoBanner.material;
        commonBatchInfoBanner.setMaterial(num != null ? num.intValue() : 0);
        String str = batchInfoBanner.content;
        if (str == null) {
            str = "";
        }
        commonBatchInfoBanner.setContent(str);
        return commonBatchInfoBanner;
    }

    public static final CommonClientAttr toCommonClientAttr(ClientAttr clientAttr) {
        CommonStUser commonStUser;
        CommonUinAttr commonUinAttr;
        CommonClientAttr commonClientAttr = new CommonClientAttr();
        StUser stUser = clientAttr.user;
        if (stUser == null || (commonStUser = AlbumStUserConverterKt.toCommonStUser(stUser)) == null) {
            commonStUser = new CommonStUser();
        }
        commonClientAttr.setUser(commonStUser);
        UinAttr uinAttr = clientAttr.attr;
        if (uinAttr == null || (commonUinAttr = toCommonUinAttr(uinAttr)) == null) {
            commonUinAttr = new CommonUinAttr();
        }
        commonClientAttr.setAttr(commonUinAttr);
        return commonClientAttr;
    }

    public static final CommonFamilyAlbumMeta toCommonFamilyAlbumMeta(FamilyAlbumMeta familyAlbumMeta) {
        CommonFamilyAlbumMeta commonFamilyAlbumMeta = new CommonFamilyAlbumMeta();
        String str = familyAlbumMeta.brithTime;
        if (str == null) {
            str = "";
        }
        commonFamilyAlbumMeta.setBirthTime(str);
        return commonFamilyAlbumMeta;
    }

    public static final CommonLoverAlbumMeta toCommonLoverAlbumMeta(LoverAlbumMeta loverAlbumMeta) {
        CommonLoverAlbumMeta commonLoverAlbumMeta = new CommonLoverAlbumMeta();
        String str = loverAlbumMeta.fallInLoveTime;
        if (str == null) {
            str = "";
        }
        commonLoverAlbumMeta.setFallInLoveTime(str);
        Integer num = loverAlbumMeta.loveValue;
        commonLoverAlbumMeta.setLoveValue(num != null ? num.intValue() : 0);
        Iterator<T> it = loverAlbumMeta.loverEvents.iterator();
        while (it.hasNext()) {
            commonLoverAlbumMeta.getLoverEvents().add(toCommonTimeEventOp((TimeEventOp) it.next()));
        }
        return commonLoverAlbumMeta;
    }

    public static final CommonMediaLbsArea toCommonMediaLbsArea(MediaLbsArea mediaLbsArea) {
        CommonStLBS commonStLBS;
        CommonMediaLbsArea commonMediaLbsArea = new CommonMediaLbsArea();
        StLBS stLBS = mediaLbsArea.lbsInfo;
        if (stLBS == null || (commonStLBS = AlbumStLBSConverterKt.toCommonStLBS(stLBS)) == null) {
            commonStLBS = new CommonStLBS();
        }
        commonMediaLbsArea.setLbsInfo(commonStLBS);
        Integer num = mediaLbsArea.photoNum;
        commonMediaLbsArea.setPhotoNum(num != null ? num.intValue() : 0);
        Integer num2 = mediaLbsArea.lbsPhotoNum;
        commonMediaLbsArea.setLbsPhotoNum(num2 != null ? num2.intValue() : 0);
        Long l3 = mediaLbsArea.startShootTime;
        commonMediaLbsArea.setStartShootTime(l3 != null ? l3.longValue() : 0L);
        Long l16 = mediaLbsArea.endShootTime;
        commonMediaLbsArea.setEndShootTime(l16 != null ? l16.longValue() : 0L);
        String str = mediaLbsArea.description;
        if (str == null) {
            str = "";
        }
        commonMediaLbsArea.setDesc(str);
        String str2 = mediaLbsArea.sceneryName;
        commonMediaLbsArea.setSceneryName(str2 != null ? str2 : "");
        Boolean bool = mediaLbsArea.userConfirmed;
        commonMediaLbsArea.setUserConfirmed(bool != null ? bool.booleanValue() : false);
        return commonMediaLbsArea;
    }

    public static final CommonMediaLbsAreaList toCommonMediaLbsAreaList(MediaLbsAreaList mediaLbsAreaList) {
        CommonMediaLbsArea commonMediaLbsArea;
        CommonMediaLbsAreaList commonMediaLbsAreaList = new CommonMediaLbsAreaList();
        MediaLbsArea mediaLbsArea = mediaLbsAreaList.albumLbs;
        if (mediaLbsArea == null || (commonMediaLbsArea = toCommonMediaLbsArea(mediaLbsArea)) == null) {
            commonMediaLbsArea = new CommonMediaLbsArea();
        }
        commonMediaLbsAreaList.setAlbumLbs(commonMediaLbsArea);
        String str = mediaLbsAreaList.startDescription;
        if (str == null) {
            str = "";
        }
        commonMediaLbsAreaList.setStartDescription(str);
        String str2 = mediaLbsAreaList.endDescription;
        commonMediaLbsAreaList.setEndDescription(str2 != null ? str2 : "");
        Iterator<T> it = mediaLbsAreaList.lbsAreas.iterator();
        while (it.hasNext()) {
            commonMediaLbsAreaList.getLbsAreas().add(toCommonMediaLbsArea((MediaLbsArea) it.next()));
        }
        Long l3 = mediaLbsAreaList.startShootTime;
        commonMediaLbsAreaList.setStartShootTime(l3 != null ? l3.longValue() : 0L);
        return commonMediaLbsAreaList;
    }

    public static final CommonPageEndMsg toCommonPageEndMsg(PageEndMsg pageEndMsg) {
        CommonPageEndMsg commonPageEndMsg = new CommonPageEndMsg();
        Integer num = pageEndMsg.code;
        commonPageEndMsg.setCode(num != null ? num.intValue() : 0);
        String str = pageEndMsg.content;
        if (str == null) {
            str = "";
        }
        commonPageEndMsg.setContent(str);
        String str2 = pageEndMsg.desc;
        commonPageEndMsg.setDesc(str2 != null ? str2 : "");
        return commonPageEndMsg;
    }

    public static final CommonRecommendMedia toCommonRecommendMedia(RecommendMedia recommendMedia) {
        CommonRecommendMedia commonRecommendMedia = new CommonRecommendMedia();
        String str = recommendMedia.recommendId;
        if (str == null) {
            str = "";
        }
        commonRecommendMedia.setRecommendId(str);
        Iterator<T> it = recommendMedia.medias.iterator();
        while (it.hasNext()) {
            commonRecommendMedia.getMedias().add(AlbumStMediaConverterKt.toCommonStMedia((StMedia) it.next()));
        }
        return commonRecommendMedia;
    }

    public static final CommonShareAlbumMeta toCommonShareAlbumMeta(ShareAlbumMeta shareAlbumMeta) {
        CommonStUser commonStUser;
        CommonShareAlbumMeta commonShareAlbumMeta = new CommonShareAlbumMeta();
        StUser stUser = shareAlbumMeta.owner;
        if (stUser == null || (commonStUser = AlbumStUserConverterKt.toCommonStUser(stUser)) == null) {
            commonStUser = new CommonStUser();
        }
        commonShareAlbumMeta.setOwner(commonStUser);
        Integer num = shareAlbumMeta.shareNums;
        commonShareAlbumMeta.setShareNums(num != null ? num.intValue() : 0);
        Boolean bool = shareAlbumMeta.autoJoin;
        commonShareAlbumMeta.setAutoJoin(bool != null ? bool.booleanValue() : false);
        Iterator<T> it = shareAlbumMeta.shareattrs.iterator();
        while (it.hasNext()) {
            commonShareAlbumMeta.getShareattrs().add(toCommonClientAttr((ClientAttr) it.next()));
        }
        return commonShareAlbumMeta;
    }

    public static final CommonShareToArk toCommonShareToArk(ShareToArk shareToArk) {
        CommonShareToArk commonShareToArk = new CommonShareToArk();
        String str = shareToArk.jsonArk;
        if (str == null) {
            str = "";
        }
        commonShareToArk.setJsonArk(str);
        String str2 = shareToArk.arkId;
        if (str2 == null) {
            str2 = "";
        }
        commonShareToArk.setArkId(str2);
        String str3 = shareToArk.viewId;
        commonShareToArk.setViewId(str3 != null ? str3 : "");
        return commonShareToArk;
    }

    public static final CommonShareToQzone toCommonShareToQzone(ShareToQzone shareToQzone) {
        String str;
        String str2;
        CommonShareToQzone commonShareToQzone = new CommonShareToQzone();
        CommonEntry commonEntry = new CommonEntry();
        Entry entry = shareToQzone.ext;
        String str3 = "";
        if (entry == null || (str = entry.key) == null) {
            str = "";
        }
        commonEntry.setKey(str);
        Entry entry2 = shareToQzone.ext;
        if (entry2 != null && (str2 = entry2.value) != null) {
            str3 = str2;
        }
        commonEntry.setValue(str3);
        commonShareToQzone.setExt(commonEntry);
        return commonShareToQzone;
    }

    public static final CommonStFeedCellVisitor toCommonStFeedCellVisitor(StFeedCellVisitor stFeedCellVisitor) {
        CommonStFeedCellVisitor commonStFeedCellVisitor = new CommonStFeedCellVisitor();
        Integer num = stFeedCellVisitor.visitorNum;
        commonStFeedCellVisitor.setVisitorNum(num != null ? num.intValue() : 0);
        Integer num2 = stFeedCellVisitor.viewNum;
        commonStFeedCellVisitor.setViewNum(num2 != null ? num2.intValue() : 0);
        Iterator<T> it = stFeedCellVisitor.visitors.iterator();
        while (it.hasNext()) {
            commonStFeedCellVisitor.getVisitors().add(AlbumStUserConverterKt.toCommonStUser((StUser) it.next()));
        }
        return commonStFeedCellVisitor;
    }

    public static final CommonStShare toCommonStShare(StShare stShare) {
        CommonShareToQzone commonShareToQzone;
        CommonShareToArk commonShareToArk;
        CommonStShare commonStShare = new CommonStShare();
        ShareToQzone shareToQzone = stShare.qzone;
        if (shareToQzone == null || (commonShareToQzone = toCommonShareToQzone(shareToQzone)) == null) {
            commonShareToQzone = new CommonShareToQzone();
        }
        commonStShare.setQzone(commonShareToQzone);
        ShareToArk shareToArk = stShare.ark;
        if (shareToArk == null || (commonShareToArk = toCommonShareToArk(shareToArk)) == null) {
            commonShareToArk = new CommonShareToArk();
        }
        commonStShare.setArk(commonShareToArk);
        String str = stShare.title;
        if (str == null) {
            str = "";
        }
        commonStShare.setTitle(str);
        String str2 = stShare.summary;
        if (str2 == null) {
            str2 = "";
        }
        commonStShare.setSummary(str2);
        String str3 = stShare.shareKey;
        commonStShare.setShareKey(str3 != null ? str3 : "");
        return commonStShare;
    }

    public static final CommonTimeEvent toCommonTimeEvent(TimeEvent timeEvent) {
        CommonTimeEvent commonTimeEvent = new CommonTimeEvent();
        Long l3 = timeEvent.time;
        commonTimeEvent.setTime(l3 != null ? l3.longValue() : 0L);
        String str = timeEvent.content;
        if (str == null) {
            str = "";
        }
        commonTimeEvent.setContent(str);
        Integer num = timeEvent.type;
        commonTimeEvent.setType(num != null ? num.intValue() : 0);
        String str2 = timeEvent.copywriter;
        commonTimeEvent.setCopywriter(str2 != null ? str2 : "");
        return commonTimeEvent;
    }

    public static final CommonTimeEventOp toCommonTimeEventOp(TimeEventOp timeEventOp) {
        CommonTimeEvent commonTimeEvent;
        CommonTimeEventOp commonTimeEventOp = new CommonTimeEventOp();
        TimeEvent timeEvent = timeEventOp.events;
        if (timeEvent == null || (commonTimeEvent = toCommonTimeEvent(timeEvent)) == null) {
            commonTimeEvent = new CommonTimeEvent();
        }
        commonTimeEventOp.setEvents(commonTimeEvent);
        Integer num = timeEventOp.action;
        commonTimeEventOp.setAction(num != null ? num.intValue() : 0);
        return commonTimeEventOp;
    }

    public static final CommonTravelAlbumMeta toCommonTravelAlbumMeta(TravelAlbumMeta travelAlbumMeta) {
        CommonTravelAlbumMeta commonTravelAlbumMeta = new CommonTravelAlbumMeta();
        Long l3 = travelAlbumMeta.travelDay;
        commonTravelAlbumMeta.setTravelDay(l3 != null ? l3.longValue() : 0L);
        Long l16 = travelAlbumMeta.locationCount;
        commonTravelAlbumMeta.setLocationCount(l16 != null ? l16.longValue() : 0L);
        return commonTravelAlbumMeta;
    }

    public static final CommonUinAttr toCommonUinAttr(UinAttr uinAttr) {
        CommonUinAttr commonUinAttr = new CommonUinAttr();
        Integer num = uinAttr.status;
        commonUinAttr.setStatus(num != null ? num.intValue() : 0);
        String str = uinAttr.nick;
        if (str == null) {
            str = "";
        }
        commonUinAttr.setNick(str);
        Long l3 = uinAttr.addTime;
        commonUinAttr.setAddTime(l3 != null ? l3.longValue() : 0L);
        Integer num2 = uinAttr.familyRole;
        commonUinAttr.setFamilyRole(num2 != null ? num2.intValue() : 0);
        Long l16 = uinAttr.joinTime;
        commonUinAttr.setJoinTime(l16 != null ? l16.longValue() : 0L);
        Integer num3 = uinAttr.priv;
        commonUinAttr.setPriv(num3 != null ? num3.intValue() : 0);
        String str2 = uinAttr.qa;
        if (str2 == null) {
            str2 = "";
        }
        commonUinAttr.setQa(str2);
        String str3 = uinAttr.shareAlbumid;
        commonUinAttr.setShareAlbumid(str3 != null ? str3 : "");
        Integer num4 = uinAttr.total;
        commonUinAttr.setTotal(num4 != null ? num4.intValue() : 0);
        return commonUinAttr;
    }

    public static final ActiveAlbumInfo toNTActiveAlbumInfo(CommonActiveAlbumInfo commonActiveAlbumInfo) {
        ActiveAlbumInfo activeAlbumInfo = new ActiveAlbumInfo(null, null, 3, null);
        activeAlbumInfo.isActiveAlbum = Boolean.valueOf(commonActiveAlbumInfo.getIsActiveAlbum());
        activeAlbumInfo.jumpUrl = commonActiveAlbumInfo.getJumpUrl();
        return activeAlbumInfo;
    }

    public static final AlbumAccessPermission toNTAlbumAccessPermission(CommonAlbumAccessPermission commonAlbumAccessPermission) {
        AlbumAccessPermission albumAccessPermission = new AlbumAccessPermission(null, null, null, null, 15, null);
        albumAccessPermission.permissionType = Integer.valueOf(commonAlbumAccessPermission.getPermissionType());
        albumAccessPermission.answer = commonAlbumAccessPermission.getAnswer();
        albumAccessPermission.question = commonAlbumAccessPermission.getQuestion();
        Iterator<T> it = commonAlbumAccessPermission.getWhiteList().iterator();
        while (it.hasNext()) {
            albumAccessPermission.whiteList.add(AlbumStUserConverterKt.toStUser((CommonStUser) it.next()));
        }
        return albumAccessPermission;
    }

    public static final AlbumOpInfo toNTAlbumOpInfo(CommonAlbumOpInfo commonAlbumOpInfo) {
        AlbumOpInfo albumOpInfo = new AlbumOpInfo(null, null, null, null, 15, null);
        albumOpInfo.lastDeleteTime = Integer.valueOf(commonAlbumOpInfo.getLastDeleteTime());
        albumOpInfo.lastDeleteCount = Integer.valueOf(commonAlbumOpInfo.getLastDeleteCount());
        albumOpInfo.recentlyUpdated = Boolean.valueOf(commonAlbumOpInfo.getRecentlyUpdated());
        albumOpInfo.prohibitModifyAlbumType = Boolean.valueOf(commonAlbumOpInfo.getProhibitModifyAlbumType());
        return albumOpInfo;
    }

    public static final ClientAttr toNTClientAttr(CommonClientAttr commonClientAttr) {
        ClientAttr clientAttr = new ClientAttr(null, null, 3, null);
        clientAttr.user = AlbumStUserConverterKt.toStUser(commonClientAttr.getUser());
        clientAttr.attr = toNTUinAttr(commonClientAttr.getAttr());
        return clientAttr;
    }

    public static final FamilyAlbumMeta toNTFamilyAlbumMeta(CommonFamilyAlbumMeta commonFamilyAlbumMeta) {
        FamilyAlbumMeta familyAlbumMeta = new FamilyAlbumMeta(null, 1, null);
        familyAlbumMeta.brithTime = commonFamilyAlbumMeta.getBirthTime();
        return familyAlbumMeta;
    }

    public static final LoverAlbumMeta toNTLoverAlbumMeta(CommonLoverAlbumMeta commonLoverAlbumMeta) {
        LoverAlbumMeta loverAlbumMeta = new LoverAlbumMeta(null, null, null, 7, null);
        loverAlbumMeta.fallInLoveTime = commonLoverAlbumMeta.getFallInLoveTime();
        loverAlbumMeta.loveValue = Integer.valueOf(commonLoverAlbumMeta.getLoveValue());
        Iterator<T> it = commonLoverAlbumMeta.getLoverEvents().iterator();
        while (it.hasNext()) {
            loverAlbumMeta.loverEvents.add(toNTTimeEventOp((CommonTimeEventOp) it.next()));
        }
        return loverAlbumMeta;
    }

    public static final ShareAlbumMeta toNTShareAlbumMeta(CommonShareAlbumMeta commonShareAlbumMeta) {
        ShareAlbumMeta shareAlbumMeta = new ShareAlbumMeta(null, null, null, null, 15, null);
        shareAlbumMeta.owner = AlbumStUserConverterKt.toStUser(commonShareAlbumMeta.getOwner());
        shareAlbumMeta.shareNums = Integer.valueOf(commonShareAlbumMeta.getShareNums());
        shareAlbumMeta.autoJoin = Boolean.valueOf(commonShareAlbumMeta.getAutoJoin());
        Iterator<T> it = commonShareAlbumMeta.getShareattrs().iterator();
        while (it.hasNext()) {
            shareAlbumMeta.shareattrs.add(toNTClientAttr((CommonClientAttr) it.next()));
        }
        return shareAlbumMeta;
    }

    public static final StFeedCellVisitor toNTStFeedCellVisitor(CommonStFeedCellVisitor commonStFeedCellVisitor) {
        StFeedCellVisitor stFeedCellVisitor = new StFeedCellVisitor(null, null, null, null, 15, null);
        stFeedCellVisitor.visitorNum = Integer.valueOf(commonStFeedCellVisitor.getVisitorNum());
        stFeedCellVisitor.viewNum = Integer.valueOf(commonStFeedCellVisitor.getViewNum());
        Iterator<T> it = commonStFeedCellVisitor.getVisitors().iterator();
        while (it.hasNext()) {
            stFeedCellVisitor.visitors.add(AlbumStUserConverterKt.toStUser((CommonStUser) it.next()));
        }
        return stFeedCellVisitor;
    }

    public static final TimeEvent toNTTimeEvent(CommonTimeEvent commonTimeEvent) {
        TimeEvent timeEvent = new TimeEvent(null, null, null, null, 15, null);
        timeEvent.time = Long.valueOf(commonTimeEvent.getTime());
        timeEvent.content = commonTimeEvent.getContent();
        timeEvent.type = Integer.valueOf(commonTimeEvent.getType());
        timeEvent.copywriter = commonTimeEvent.getCopywriter();
        return timeEvent;
    }

    public static final TimeEventOp toNTTimeEventOp(CommonTimeEventOp commonTimeEventOp) {
        TimeEventOp timeEventOp = new TimeEventOp(null, null, 3, null);
        timeEventOp.events = toNTTimeEvent(commonTimeEventOp.getEvents());
        timeEventOp.action = Integer.valueOf(commonTimeEventOp.getAction());
        return timeEventOp;
    }

    public static final TravelAlbumMeta toNTTravelAlbumMeta(CommonTravelAlbumMeta commonTravelAlbumMeta) {
        TravelAlbumMeta travelAlbumMeta = new TravelAlbumMeta(null, null, 3, null);
        travelAlbumMeta.travelDay = Long.valueOf(commonTravelAlbumMeta.getTravelDay());
        travelAlbumMeta.locationCount = Long.valueOf(commonTravelAlbumMeta.getLocationCount());
        return travelAlbumMeta;
    }

    public static final UinAttr toNTUinAttr(CommonUinAttr commonUinAttr) {
        UinAttr uinAttr = new UinAttr(null, null, null, null, null, null, null, null, null, 511, null);
        uinAttr.status = Integer.valueOf(commonUinAttr.getStatus());
        uinAttr.nick = commonUinAttr.getNick();
        uinAttr.addTime = Long.valueOf(commonUinAttr.getAddTime());
        uinAttr.familyRole = Integer.valueOf(commonUinAttr.getFamilyRole());
        uinAttr.joinTime = Long.valueOf(commonUinAttr.getJoinTime());
        uinAttr.priv = Integer.valueOf(commonUinAttr.getPriv());
        uinAttr.qa = commonUinAttr.getQa();
        uinAttr.shareAlbumid = commonUinAttr.getShareAlbumid();
        uinAttr.total = Integer.valueOf(commonUinAttr.getTotal());
        return uinAttr;
    }
}
