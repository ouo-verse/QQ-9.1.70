package fb;

import aa.e;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCacheData;
import com.qzone.album.data.model.PhotoPoiArea;
import com.qzone.album.data.model.PoiInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonActiveAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumAccessPermission;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumOpInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfoBanner;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.common.convert.bean.CommonEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonFamilyAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonLoverAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsArea;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList;
import com.qzone.reborn.albumx.common.convert.bean.CommonMemoryInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonMemoryVideo;
import com.qzone.reborn.albumx.common.convert.bean.CommonPageEndMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonRecommendMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareOutside;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareToArk;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareToQzone;
import com.qzone.reborn.albumx.common.convert.bean.CommonShareWXMiniApp;
import com.qzone.reborn.albumx.common.convert.bean.CommonStFeedCellVisitor;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLBS;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStShare;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.convert.bean.CommonTimeEvent;
import com.qzone.reborn.albumx.common.convert.bean.CommonTimeEventOp;
import com.qzone.reborn.albumx.common.convert.bean.CommonTravelAlbumMeta;
import com.qzone.reborn.albumx.common.convert.bean.CommonUinAttr;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.ActiveAlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumAccessPermission;
import com.tencent.qqnt.kernel.nativeinterface.AlbumOpInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchInfoBanner;
import com.tencent.qqnt.kernel.nativeinterface.ClientAttr;
import com.tencent.qqnt.kernel.nativeinterface.FamilyAlbumMeta;
import com.tencent.qqnt.kernel.nativeinterface.LoverAlbumMeta;
import com.tencent.qqnt.kernel.nativeinterface.MediaLbsArea;
import com.tencent.qqnt.kernel.nativeinterface.MediaLbsAreaList;
import com.tencent.qqnt.kernel.nativeinterface.MemoryInfo;
import com.tencent.qqnt.kernel.nativeinterface.MemoryVideo;
import com.tencent.qqnt.kernel.nativeinterface.PageEndMsg;
import com.tencent.qqnt.kernel.nativeinterface.RecommendMedia;
import com.tencent.qqnt.kernel.nativeinterface.ShareAlbumMeta;
import com.tencent.qqnt.kernel.nativeinterface.ShareOutside;
import com.tencent.qqnt.kernel.nativeinterface.ShareToArk;
import com.tencent.qqnt.kernel.nativeinterface.ShareToQzone;
import com.tencent.qqnt.kernel.nativeinterface.StFeedCellVisitor;
import com.tencent.qqnt.kernel.nativeinterface.StGPS;
import com.tencent.qqnt.kernel.nativeinterface.StLBS;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.qqnt.kernel.nativeinterface.StShare;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.qqnt.kernel.nativeinterface.TimeEvent;
import com.tencent.qqnt.kernel.nativeinterface.TimeEventOp;
import com.tencent.qqnt.kernel.nativeinterface.TravelAlbumMeta;
import com.tencent.qqnt.kernel.nativeinterface.UinAttr;
import cooperation.qzone.LbsDataV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tl.h;
import xh.g;
import xh.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0000*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0004\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\n\u001a\u00020\t*\u00020\b\u001a\n\u0010\u000b\u001a\u00020\b*\u00020\t\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\f\u001a\n\u0010\u000f\u001a\u00020\f*\u00020\r\u001a\n\u0010\u0012\u001a\u00020\u0011*\u00020\u0010\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0016\u001a\u00020\u0015*\u00020\u0014\u001a\n\u0010\u0017\u001a\u00020\u0014*\u00020\u0015\u001a\n\u0010\u001a\u001a\u00020\u0019*\u00020\u0018\u001a\n\u0010\u001b\u001a\u00020\u0018*\u00020\u0019\u001a\n\u0010\u001e\u001a\u00020\u001d*\u00020\u001c\u001a\n\u0010\u001f\u001a\u00020\u001c*\u00020\u001d\u001a\n\u0010\"\u001a\u00020!*\u00020 \u001a\n\u0010#\u001a\u00020 *\u00020!\u001a\n\u0010&\u001a\u00020%*\u00020$\u001a\n\u0010'\u001a\u00020$*\u00020%\u001a\n\u0010*\u001a\u00020)*\u00020(\u001a\n\u0010-\u001a\u00020,*\u00020+\u001a\n\u00100\u001a\u00020/*\u00020.\u001a\n\u00103\u001a\u000202*\u000201\u001a\n\u00106\u001a\u000205*\u000204\u001a\n\u00109\u001a\u000208*\u000207\u001a\n\u0010<\u001a\u00020;*\u00020:\u001a\n\u0010>\u001a\u00020=*\u00020;\u001a\n\u0010?\u001a\u00020:*\u00020=\u001a\n\u0010B\u001a\u00020A*\u00020@\u001a\n\u0010D\u001a\u00020:*\u00020C\u001a\n\u0010G\u001a\u00020F*\u00020E\u001a\n\u0010J\u001a\u00020I*\u00020H\u001a\n\u0010M\u001a\u00020L*\u00020K\u001a\n\u0010P\u001a\u00020O*\u00020N\u001a\n\u0010Q\u001a\u00020N*\u00020O\u001a\n\u0010T\u001a\u00020S*\u00020R\u001a\n\u0010W\u001a\u00020V*\u00020U\u001a\n\u0010Z\u001a\u00020Y*\u00020X\u001a\n\u0010[\u001a\u00020R*\u00020S\u00a8\u0006\\"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/AlbumAccessPermission;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumAccessPermission;", "b", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernel/nativeinterface/ShareAlbumMeta;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareAlbumMeta;", DomainData.DOMAIN_NAME, UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/kernel/nativeinterface/ClientAttr;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "e", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/UinAttr;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonUinAttr;", "w", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/FamilyAlbumMeta;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonFamilyAlbumMeta;", "f", "D", "Lcom/tencent/qqnt/kernel/nativeinterface/LoverAlbumMeta;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonLoverAlbumMeta;", "g", "E", "Lcom/tencent/qqnt/kernel/nativeinterface/TimeEventOp;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonTimeEventOp;", "u", "I", "Lcom/tencent/qqnt/kernel/nativeinterface/TimeEvent;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonTimeEvent;", "t", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/TravelAlbumMeta;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonTravelAlbumMeta;", "v", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeedCellVisitor;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStFeedCellVisitor;", "r", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/PageEndMsg;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/StShare;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStShare;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/ShareToQzone;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToQzone;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/kernel/nativeinterface/ShareToArk;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareToArk;", "p", "Lcom/tencent/qqnt/kernel/nativeinterface/ShareOutside;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonShareOutside;", "o", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaLbsAreaList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaLbsArea;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsArea;", h.F, "Lcom/qzone/album/data/model/PhotoPoiArea;", "M", HippyTKDListViewAdapter.X, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "Lcom/qzone/album/data/model/PoiInfo;", "N", "Lcooperation/qzone/LbsDataV2$PoiInfo;", "y", "Lcom/tencent/qqnt/kernel/nativeinterface/RecommendMedia;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lcom/qzone/album/data/model/PhotoCacheData;", "L", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchInfoBanner;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfoBanner;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumOpInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumOpInfo;", "c", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/ActiveAlbumInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonActiveAlbumInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MemoryInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryInfo;", "j", "Lcom/tencent/qqnt/kernel/nativeinterface/MemoryVideo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMemoryVideo;", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final AlbumAccessPermission A(CommonAlbumAccessPermission commonAlbumAccessPermission) {
        Intrinsics.checkNotNullParameter(commonAlbumAccessPermission, "<this>");
        AlbumAccessPermission albumAccessPermission = new AlbumAccessPermission();
        albumAccessPermission.permissionType = commonAlbumAccessPermission.getPermissionType();
        albumAccessPermission.answer = commonAlbumAccessPermission.getAnswer();
        albumAccessPermission.question = commonAlbumAccessPermission.getQuestion();
        Iterator<T> it = commonAlbumAccessPermission.e().iterator();
        while (it.hasNext()) {
            albumAccessPermission.whiteList.add(i.b((CommonStUser) it.next()));
        }
        return albumAccessPermission;
    }

    public static final AlbumOpInfo B(CommonAlbumOpInfo commonAlbumOpInfo) {
        Intrinsics.checkNotNullParameter(commonAlbumOpInfo, "<this>");
        AlbumOpInfo albumOpInfo = new AlbumOpInfo();
        albumOpInfo.lastDeleteTime = commonAlbumOpInfo.getLastDeleteTime();
        albumOpInfo.lastDeleteCount = commonAlbumOpInfo.getLastDeleteCount();
        albumOpInfo.recentlyUpdated = commonAlbumOpInfo.getRecentlyUpdated();
        albumOpInfo.prohibitModifyAlbumType = commonAlbumOpInfo.getProhibitModifyAlbumType();
        return albumOpInfo;
    }

    public static final ClientAttr C(CommonClientAttr commonClientAttr) {
        Intrinsics.checkNotNullParameter(commonClientAttr, "<this>");
        ClientAttr clientAttr = new ClientAttr();
        clientAttr.user = i.b(commonClientAttr.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String());
        clientAttr.attr = K(commonClientAttr.getAttr());
        return clientAttr;
    }

    public static final FamilyAlbumMeta D(CommonFamilyAlbumMeta commonFamilyAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonFamilyAlbumMeta, "<this>");
        FamilyAlbumMeta familyAlbumMeta = new FamilyAlbumMeta();
        familyAlbumMeta.birthTime = commonFamilyAlbumMeta.getBirthTime();
        return familyAlbumMeta;
    }

    public static final LoverAlbumMeta E(CommonLoverAlbumMeta commonLoverAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonLoverAlbumMeta, "<this>");
        LoverAlbumMeta loverAlbumMeta = new LoverAlbumMeta();
        loverAlbumMeta.fallInLoveTime = commonLoverAlbumMeta.getFallInLoveTime();
        loverAlbumMeta.loveValue = commonLoverAlbumMeta.getLoveValue();
        Iterator<T> it = commonLoverAlbumMeta.c().iterator();
        while (it.hasNext()) {
            loverAlbumMeta.loverEvents.add(I((CommonTimeEventOp) it.next()));
        }
        return loverAlbumMeta;
    }

    public static final ShareAlbumMeta F(CommonShareAlbumMeta commonShareAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonShareAlbumMeta, "<this>");
        ShareAlbumMeta shareAlbumMeta = new ShareAlbumMeta();
        shareAlbumMeta.owner = i.b(commonShareAlbumMeta.getOwner());
        shareAlbumMeta.shareNums = commonShareAlbumMeta.getShareNums();
        shareAlbumMeta.autoJoin = commonShareAlbumMeta.getAutoJoin();
        Iterator<T> it = commonShareAlbumMeta.e().iterator();
        while (it.hasNext()) {
            shareAlbumMeta.shareattrs.add(C((CommonClientAttr) it.next()));
        }
        return shareAlbumMeta;
    }

    public static final StFeedCellVisitor G(CommonStFeedCellVisitor commonStFeedCellVisitor) {
        Intrinsics.checkNotNullParameter(commonStFeedCellVisitor, "<this>");
        StFeedCellVisitor stFeedCellVisitor = new StFeedCellVisitor();
        stFeedCellVisitor.visitorNum = commonStFeedCellVisitor.getVisitorNum();
        stFeedCellVisitor.viewNum = commonStFeedCellVisitor.getViewNum();
        Iterator<T> it = commonStFeedCellVisitor.c().iterator();
        while (it.hasNext()) {
            stFeedCellVisitor.visitors.add(i.b((CommonStUser) it.next()));
        }
        return stFeedCellVisitor;
    }

    public static final TimeEvent H(CommonTimeEvent commonTimeEvent) {
        Intrinsics.checkNotNullParameter(commonTimeEvent, "<this>");
        TimeEvent timeEvent = new TimeEvent();
        timeEvent.time = commonTimeEvent.getTime();
        timeEvent.content = commonTimeEvent.getContent();
        timeEvent.type = commonTimeEvent.getType();
        timeEvent.copywriter = commonTimeEvent.getCopywriter();
        return timeEvent;
    }

    public static final TimeEventOp I(CommonTimeEventOp commonTimeEventOp) {
        Intrinsics.checkNotNullParameter(commonTimeEventOp, "<this>");
        TimeEventOp timeEventOp = new TimeEventOp();
        timeEventOp.events = H(commonTimeEventOp.getCom.tencent.ams.dynamicwidget.report.LinkReportConstant$GlobalKey.EVENTS java.lang.String());
        timeEventOp.action = commonTimeEventOp.getAction();
        return timeEventOp;
    }

    public static final TravelAlbumMeta J(CommonTravelAlbumMeta commonTravelAlbumMeta) {
        Intrinsics.checkNotNullParameter(commonTravelAlbumMeta, "<this>");
        TravelAlbumMeta travelAlbumMeta = new TravelAlbumMeta();
        travelAlbumMeta.travelDay = commonTravelAlbumMeta.getTravelDay();
        travelAlbumMeta.locationCount = commonTravelAlbumMeta.getLocationCount();
        return travelAlbumMeta;
    }

    public static final UinAttr K(CommonUinAttr commonUinAttr) {
        Intrinsics.checkNotNullParameter(commonUinAttr, "<this>");
        UinAttr uinAttr = new UinAttr();
        uinAttr.status = commonUinAttr.getStatus();
        uinAttr.nick = commonUinAttr.getNick();
        uinAttr.addTime = commonUinAttr.getAddTime();
        uinAttr.familyRole = commonUinAttr.getFamilyRole();
        uinAttr.joinTime = commonUinAttr.getJoinTime();
        uinAttr.priv = commonUinAttr.getPriv();
        uinAttr.f359234qa = commonUinAttr.getQa();
        uinAttr.shareAlbumid = commonUinAttr.getShareAlbumid();
        uinAttr.total = commonUinAttr.getTotal();
        return uinAttr;
    }

    public static final PhotoCacheData L(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<this>");
        PhotoCacheData photoCacheData = new PhotoCacheData();
        if (commonStMedia.u()) {
            photoCacheData.videoflag = 1;
            VideoInfo videoInfo = new VideoInfo();
            photoCacheData.videodata = videoInfo;
            videoInfo.videoUrl = new VideoUrl();
            photoCacheData.videodata.videoUrl.url = commonStMedia.getVideo().getUrl();
        } else {
            photoCacheData.picItem = new PictureItem();
            CommonStPicUrl a16 = e.a(commonStMedia.getImage().e());
            photoCacheData.picItem.currentUrl = new PictureUrl();
            photoCacheData.picItem.currentUrl.url = a16 != null ? a16.getUrl() : null;
            photoCacheData.picItem.currentUrl.width = a16 != null ? a16.getWidth() : 0;
            photoCacheData.picItem.currentUrl.height = a16 != null ? a16.getHeight() : 0;
        }
        return photoCacheData;
    }

    public static final PhotoPoiArea M(CommonMediaLbsArea commonMediaLbsArea) {
        CharSequence trim;
        Intrinsics.checkNotNullParameter(commonMediaLbsArea, "<this>");
        PhotoPoiArea photoPoiArea = new PhotoPoiArea();
        photoPoiArea.photoNum = commonMediaLbsArea.getPhotoNum();
        photoPoiArea.startShootTime = commonMediaLbsArea.getStartShootTime();
        photoPoiArea.endShootTime = commonMediaLbsArea.getEndShootTime();
        photoPoiArea.poiInfo = N(commonMediaLbsArea.getLbsInfo());
        trim = StringsKt__StringsKt.trim((CharSequence) commonMediaLbsArea.getSceneryName());
        photoPoiArea.sceneryName = trim.toString();
        photoPoiArea.poiPhotoNum = commonMediaLbsArea.getLbsPhotoNum();
        photoPoiArea.description = commonMediaLbsArea.getDesc();
        return photoPoiArea;
    }

    public static final PoiInfo N(CommonStLBS commonStLBS) {
        Intrinsics.checkNotNullParameter(commonStLBS, "<this>");
        PoiInfo poiInfo = new PoiInfo();
        poiInfo.poiId = commonStLBS.getLbsId();
        poiInfo.poiName = commonStLBS.getLocation();
        poiInfo.poiAddress = commonStLBS.getAddress();
        poiInfo.poiX = String.valueOf(commonStLBS.getGps().getLon() / 1000000.0d);
        poiInfo.poiY = String.valueOf(commonStLBS.getGps().getCom.tencent.biz.qqcircle.QCircleSchemeAttr.Polymerize.LAT java.lang.String() / 1000000.0d);
        return poiInfo;
    }

    public static final CommonActiveAlbumInfo a(ActiveAlbumInfo activeAlbumInfo) {
        Intrinsics.checkNotNullParameter(activeAlbumInfo, "<this>");
        CommonActiveAlbumInfo commonActiveAlbumInfo = new CommonActiveAlbumInfo();
        commonActiveAlbumInfo.c(activeAlbumInfo.isActiveAlbum);
        String str = activeAlbumInfo.jumpUrl;
        Intrinsics.checkNotNullExpressionValue(str, "this.jumpUrl");
        commonActiveAlbumInfo.e(str);
        return commonActiveAlbumInfo;
    }

    public static final CommonAlbumAccessPermission b(AlbumAccessPermission albumAccessPermission) {
        Intrinsics.checkNotNullParameter(albumAccessPermission, "<this>");
        CommonAlbumAccessPermission commonAlbumAccessPermission = new CommonAlbumAccessPermission();
        commonAlbumAccessPermission.g(albumAccessPermission.permissionType);
        String str = albumAccessPermission.answer;
        Intrinsics.checkNotNullExpressionValue(str, "this.answer");
        commonAlbumAccessPermission.f(str);
        String str2 = albumAccessPermission.question;
        Intrinsics.checkNotNullExpressionValue(str2, "this.question");
        commonAlbumAccessPermission.j(str2);
        ArrayList<StUser> arrayList = albumAccessPermission.whiteList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.whiteList");
        for (StUser it : arrayList) {
            List<CommonStUser> e16 = commonAlbumAccessPermission.e();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            e16.add(i.a(it));
        }
        return commonAlbumAccessPermission;
    }

    public static final CommonAlbumOpInfo c(AlbumOpInfo albumOpInfo) {
        Intrinsics.checkNotNullParameter(albumOpInfo, "<this>");
        CommonAlbumOpInfo commonAlbumOpInfo = new CommonAlbumOpInfo();
        commonAlbumOpInfo.g(albumOpInfo.lastDeleteTime);
        commonAlbumOpInfo.f(albumOpInfo.lastDeleteCount);
        commonAlbumOpInfo.k(albumOpInfo.recentlyUpdated);
        commonAlbumOpInfo.j(albumOpInfo.prohibitModifyAlbumType);
        return commonAlbumOpInfo;
    }

    public static final CommonBatchInfoBanner d(BatchInfoBanner batchInfoBanner) {
        Intrinsics.checkNotNullParameter(batchInfoBanner, "<this>");
        CommonBatchInfoBanner commonBatchInfoBanner = new CommonBatchInfoBanner();
        commonBatchInfoBanner.f(batchInfoBanner.material);
        String str = batchInfoBanner.content;
        Intrinsics.checkNotNullExpressionValue(str, "this.content");
        commonBatchInfoBanner.e(str);
        return commonBatchInfoBanner;
    }

    public static final CommonClientAttr e(ClientAttr clientAttr) {
        Intrinsics.checkNotNullParameter(clientAttr, "<this>");
        CommonClientAttr commonClientAttr = new CommonClientAttr();
        StUser stUser = clientAttr.user;
        Intrinsics.checkNotNullExpressionValue(stUser, "this.user");
        commonClientAttr.e(i.a(stUser));
        UinAttr uinAttr = clientAttr.attr;
        Intrinsics.checkNotNullExpressionValue(uinAttr, "this.attr");
        commonClientAttr.c(w(uinAttr));
        return commonClientAttr;
    }

    public static final CommonFamilyAlbumMeta f(FamilyAlbumMeta familyAlbumMeta) {
        Intrinsics.checkNotNullParameter(familyAlbumMeta, "<this>");
        CommonFamilyAlbumMeta commonFamilyAlbumMeta = new CommonFamilyAlbumMeta();
        String str = familyAlbumMeta.birthTime;
        Intrinsics.checkNotNullExpressionValue(str, "this.birthTime");
        commonFamilyAlbumMeta.b(str);
        return commonFamilyAlbumMeta;
    }

    public static final CommonLoverAlbumMeta g(LoverAlbumMeta loverAlbumMeta) {
        Intrinsics.checkNotNullParameter(loverAlbumMeta, "<this>");
        CommonLoverAlbumMeta commonLoverAlbumMeta = new CommonLoverAlbumMeta();
        String str = loverAlbumMeta.fallInLoveTime;
        Intrinsics.checkNotNullExpressionValue(str, "this.fallInLoveTime");
        commonLoverAlbumMeta.e(str);
        commonLoverAlbumMeta.f(loverAlbumMeta.loveValue);
        ArrayList<TimeEventOp> arrayList = loverAlbumMeta.loverEvents;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.loverEvents");
        for (TimeEventOp it : arrayList) {
            List<CommonTimeEventOp> c16 = commonLoverAlbumMeta.c();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            c16.add(u(it));
        }
        return commonLoverAlbumMeta;
    }

    public static final CommonMediaLbsArea h(MediaLbsArea mediaLbsArea) {
        Intrinsics.checkNotNullParameter(mediaLbsArea, "<this>");
        CommonMediaLbsArea commonMediaLbsArea = new CommonMediaLbsArea();
        StLBS stLBS = mediaLbsArea.lbsInfo;
        Intrinsics.checkNotNullExpressionValue(stLBS, "this.lbsInfo");
        commonMediaLbsArea.n(g.a(stLBS));
        commonMediaLbsArea.p(mediaLbsArea.photoNum);
        commonMediaLbsArea.o(mediaLbsArea.lbsPhotoNum);
        commonMediaLbsArea.r(mediaLbsArea.startShootTime);
        commonMediaLbsArea.m(mediaLbsArea.endShootTime);
        String str = mediaLbsArea.desc;
        Intrinsics.checkNotNullExpressionValue(str, "this.desc");
        commonMediaLbsArea.l(str);
        String str2 = mediaLbsArea.sceneryName;
        Intrinsics.checkNotNullExpressionValue(str2, "this.sceneryName");
        commonMediaLbsArea.q(str2);
        commonMediaLbsArea.s(mediaLbsArea.userConfirmed);
        return commonMediaLbsArea;
    }

    public static final CommonMediaLbsAreaList i(MediaLbsAreaList mediaLbsAreaList) {
        Intrinsics.checkNotNullParameter(mediaLbsAreaList, "<this>");
        CommonMediaLbsAreaList commonMediaLbsAreaList = new CommonMediaLbsAreaList();
        MediaLbsArea mediaLbsArea = mediaLbsAreaList.albumLbs;
        Intrinsics.checkNotNullExpressionValue(mediaLbsArea, "this.albumLbs");
        commonMediaLbsAreaList.b(h(mediaLbsArea));
        String str = mediaLbsAreaList.startDescription;
        Intrinsics.checkNotNullExpressionValue(str, "this.startDescription");
        commonMediaLbsAreaList.e(str);
        String str2 = mediaLbsAreaList.endDescription;
        Intrinsics.checkNotNullExpressionValue(str2, "this.endDescription");
        commonMediaLbsAreaList.c(str2);
        ArrayList<MediaLbsArea> arrayList = mediaLbsAreaList.lbsAreas;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.lbsAreas");
        for (MediaLbsArea it : arrayList) {
            ArrayList<CommonMediaLbsArea> a16 = commonMediaLbsAreaList.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            a16.add(h(it));
        }
        commonMediaLbsAreaList.f(mediaLbsAreaList.startShootTime);
        return commonMediaLbsAreaList;
    }

    public static final CommonMemoryInfo j(MemoryInfo memoryInfo) {
        Intrinsics.checkNotNullParameter(memoryInfo, "<this>");
        CommonMemoryInfo commonMemoryInfo = new CommonMemoryInfo();
        ArrayList<MemoryVideo> arrayList = memoryInfo.memoryList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.memoryList");
        for (MemoryVideo it : arrayList) {
            List<CommonMemoryVideo> b16 = commonMemoryInfo.b();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            b16.add(k(it));
        }
        String str = memoryInfo.aggregationPageUrl;
        Intrinsics.checkNotNullExpressionValue(str, "this.aggregationPageUrl");
        commonMemoryInfo.c(str);
        return commonMemoryInfo;
    }

    public static final CommonMemoryVideo k(MemoryVideo memoryVideo) {
        Intrinsics.checkNotNullParameter(memoryVideo, "<this>");
        CommonMemoryVideo commonMemoryVideo = new CommonMemoryVideo();
        String str = memoryVideo.templateId;
        Intrinsics.checkNotNullExpressionValue(str, "this.templateId");
        commonMemoryVideo.j(str);
        String str2 = memoryVideo.videoId;
        Intrinsics.checkNotNullExpressionValue(str2, "this.videoId");
        commonMemoryVideo.l(str2);
        String str3 = memoryVideo.coverUrl;
        Intrinsics.checkNotNullExpressionValue(str3, "this.coverUrl");
        commonMemoryVideo.e(str3);
        commonMemoryVideo.m(memoryVideo.viewed);
        String str4 = memoryVideo.jumpUrl;
        Intrinsics.checkNotNullExpressionValue(str4, "this.jumpUrl");
        commonMemoryVideo.f(str4);
        String str5 = memoryVideo.title;
        Intrinsics.checkNotNullExpressionValue(str5, "this.title");
        commonMemoryVideo.k(str5);
        String str6 = memoryVideo.subTitle;
        Intrinsics.checkNotNullExpressionValue(str6, "this.subTitle");
        commonMemoryVideo.g(str6);
        return commonMemoryVideo;
    }

    public static final CommonPageEndMsg l(PageEndMsg pageEndMsg) {
        Intrinsics.checkNotNullParameter(pageEndMsg, "<this>");
        CommonPageEndMsg commonPageEndMsg = new CommonPageEndMsg();
        commonPageEndMsg.e(pageEndMsg.code);
        String str = pageEndMsg.content;
        Intrinsics.checkNotNullExpressionValue(str, "this.content");
        commonPageEndMsg.f(str);
        String str2 = pageEndMsg.desc;
        Intrinsics.checkNotNullExpressionValue(str2, "this.desc");
        commonPageEndMsg.g(str2);
        return commonPageEndMsg;
    }

    public static final CommonRecommendMedia m(RecommendMedia recommendMedia) {
        Intrinsics.checkNotNullParameter(recommendMedia, "<this>");
        CommonRecommendMedia commonRecommendMedia = new CommonRecommendMedia();
        String str = recommendMedia.recommendId;
        Intrinsics.checkNotNullExpressionValue(str, "this.recommendId");
        commonRecommendMedia.c(str);
        ArrayList<StMedia> arrayList = recommendMedia.medias;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.medias");
        for (StMedia it : arrayList) {
            List<CommonStMedia> a16 = commonRecommendMedia.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            a16.add(xh.h.b(it));
        }
        return commonRecommendMedia;
    }

    public static final CommonShareAlbumMeta n(ShareAlbumMeta shareAlbumMeta) {
        Intrinsics.checkNotNullParameter(shareAlbumMeta, "<this>");
        CommonShareAlbumMeta commonShareAlbumMeta = new CommonShareAlbumMeta();
        StUser stUser = shareAlbumMeta.owner;
        Intrinsics.checkNotNullExpressionValue(stUser, "this.owner");
        commonShareAlbumMeta.g(i.a(stUser));
        commonShareAlbumMeta.j(shareAlbumMeta.shareNums);
        commonShareAlbumMeta.f(shareAlbumMeta.autoJoin);
        ArrayList<ClientAttr> arrayList = shareAlbumMeta.shareattrs;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.shareattrs");
        for (ClientAttr it : arrayList) {
            List<CommonClientAttr> e16 = commonShareAlbumMeta.e();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            e16.add(e(it));
        }
        return commonShareAlbumMeta;
    }

    public static final CommonShareOutside o(ShareOutside shareOutside) {
        Intrinsics.checkNotNullParameter(shareOutside, "<this>");
        CommonShareOutside commonShareOutside = new CommonShareOutside();
        String jumpUrl = shareOutside.jumpUrl;
        Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
        commonShareOutside.c(jumpUrl);
        CommonShareWXMiniApp commonShareWXMiniApp = new CommonShareWXMiniApp();
        String str = shareOutside.wxMiniapp.appName;
        Intrinsics.checkNotNullExpressionValue(str, "wxMiniapp.appName");
        commonShareWXMiniApp.c(str);
        String str2 = shareOutside.wxMiniapp.path;
        Intrinsics.checkNotNullExpressionValue(str2, "wxMiniapp.path");
        commonShareWXMiniApp.e(str2);
        commonShareOutside.e(commonShareWXMiniApp);
        return commonShareOutside;
    }

    public static final CommonShareToArk p(ShareToArk shareToArk) {
        Intrinsics.checkNotNullParameter(shareToArk, "<this>");
        CommonShareToArk commonShareToArk = new CommonShareToArk();
        String jsonArk = shareToArk.jsonArk;
        Intrinsics.checkNotNullExpressionValue(jsonArk, "jsonArk");
        commonShareToArk.f(jsonArk);
        String arkId = shareToArk.arkId;
        Intrinsics.checkNotNullExpressionValue(arkId, "arkId");
        commonShareToArk.e(arkId);
        String viewId = shareToArk.viewId;
        Intrinsics.checkNotNullExpressionValue(viewId, "viewId");
        commonShareToArk.g(viewId);
        return commonShareToArk;
    }

    public static final CommonShareToQzone q(ShareToQzone shareToQzone) {
        Intrinsics.checkNotNullParameter(shareToQzone, "<this>");
        CommonShareToQzone commonShareToQzone = new CommonShareToQzone();
        CommonEntry commonEntry = new CommonEntry();
        String str = shareToQzone.ext.key;
        Intrinsics.checkNotNullExpressionValue(str, "this@toCommonShareToQzone.ext.key");
        commonEntry.c(str);
        String str2 = shareToQzone.ext.value;
        Intrinsics.checkNotNullExpressionValue(str2, "this@toCommonShareToQzone.ext.value");
        commonEntry.f(str2);
        commonShareToQzone.a(commonEntry);
        return commonShareToQzone;
    }

    public static final CommonStFeedCellVisitor r(StFeedCellVisitor stFeedCellVisitor) {
        Intrinsics.checkNotNullParameter(stFeedCellVisitor, "<this>");
        CommonStFeedCellVisitor commonStFeedCellVisitor = new CommonStFeedCellVisitor();
        commonStFeedCellVisitor.f(stFeedCellVisitor.visitorNum);
        commonStFeedCellVisitor.e(stFeedCellVisitor.viewNum);
        ArrayList<StUser> arrayList = stFeedCellVisitor.visitors;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.visitors");
        for (StUser it : arrayList) {
            List<CommonStUser> c16 = commonStFeedCellVisitor.c();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            c16.add(i.a(it));
        }
        return commonStFeedCellVisitor;
    }

    public static final CommonStShare s(StShare stShare) {
        Intrinsics.checkNotNullParameter(stShare, "<this>");
        CommonStShare commonStShare = new CommonStShare();
        ShareToQzone shareToQzone = stShare.f359226qzone;
        Intrinsics.checkNotNullExpressionValue(shareToQzone, "this.qzone");
        commonStShare.j(q(shareToQzone));
        ShareToArk shareToArk = stShare.ark;
        Intrinsics.checkNotNullExpressionValue(shareToArk, "this.ark");
        commonStShare.f(p(shareToArk));
        ShareOutside shareOutside = stShare.outside;
        Intrinsics.checkNotNullExpressionValue(shareOutside, "this.outside");
        commonStShare.g(o(shareOutside));
        String str = stShare.title;
        Intrinsics.checkNotNullExpressionValue(str, "this.title");
        commonStShare.m(str);
        String str2 = stShare.summary;
        Intrinsics.checkNotNullExpressionValue(str2, "this.summary");
        commonStShare.l(str2);
        String str3 = stShare.shareKey;
        Intrinsics.checkNotNullExpressionValue(str3, "this.shareKey");
        commonStShare.k(str3);
        return commonStShare;
    }

    public static final CommonTimeEvent t(TimeEvent timeEvent) {
        Intrinsics.checkNotNullParameter(timeEvent, "<this>");
        CommonTimeEvent commonTimeEvent = new CommonTimeEvent();
        commonTimeEvent.g(timeEvent.time);
        String str = timeEvent.content;
        Intrinsics.checkNotNullExpressionValue(str, "this.content");
        commonTimeEvent.e(str);
        commonTimeEvent.j(timeEvent.type);
        String str2 = timeEvent.copywriter;
        Intrinsics.checkNotNullExpressionValue(str2, "this.copywriter");
        commonTimeEvent.f(str2);
        return commonTimeEvent;
    }

    public static final CommonTimeEventOp u(TimeEventOp timeEventOp) {
        Intrinsics.checkNotNullParameter(timeEventOp, "<this>");
        CommonTimeEventOp commonTimeEventOp = new CommonTimeEventOp();
        TimeEvent timeEvent = timeEventOp.events;
        Intrinsics.checkNotNullExpressionValue(timeEvent, "this.events");
        commonTimeEventOp.e(t(timeEvent));
        commonTimeEventOp.c(timeEventOp.action);
        return commonTimeEventOp;
    }

    public static final CommonTravelAlbumMeta v(TravelAlbumMeta travelAlbumMeta) {
        Intrinsics.checkNotNullParameter(travelAlbumMeta, "<this>");
        CommonTravelAlbumMeta commonTravelAlbumMeta = new CommonTravelAlbumMeta();
        commonTravelAlbumMeta.e(travelAlbumMeta.travelDay);
        commonTravelAlbumMeta.c(travelAlbumMeta.locationCount);
        return commonTravelAlbumMeta;
    }

    public static final CommonUinAttr w(UinAttr uinAttr) {
        Intrinsics.checkNotNullParameter(uinAttr, "<this>");
        CommonUinAttr commonUinAttr = new CommonUinAttr();
        commonUinAttr.t(uinAttr.status);
        String str = uinAttr.nick;
        Intrinsics.checkNotNullExpressionValue(str, "this.nick");
        commonUinAttr.p(str);
        commonUinAttr.m(uinAttr.addTime);
        commonUinAttr.n(uinAttr.familyRole);
        commonUinAttr.o(uinAttr.joinTime);
        commonUinAttr.q(uinAttr.priv);
        String str2 = uinAttr.f359234qa;
        Intrinsics.checkNotNullExpressionValue(str2, "this.qa");
        commonUinAttr.r(str2);
        String str3 = uinAttr.shareAlbumid;
        Intrinsics.checkNotNullExpressionValue(str3, "this.shareAlbumid");
        commonUinAttr.s(str3);
        commonUinAttr.u(uinAttr.total);
        return commonUinAttr;
    }

    public static final MediaLbsArea x(PhotoPoiArea photoPoiArea) {
        Intrinsics.checkNotNullParameter(photoPoiArea, "<this>");
        MediaLbsArea mediaLbsArea = new MediaLbsArea();
        StLBS stLBS = new StLBS();
        PoiInfo poiInfo = photoPoiArea.poiInfo;
        stLBS.address = poiInfo.poiAddress;
        stLBS.lbsId = poiInfo.poiId;
        stLBS.location = poiInfo.poiName;
        mediaLbsArea.lbsInfo = stLBS;
        mediaLbsArea.photoNum = (int) photoPoiArea.photoNum;
        mediaLbsArea.lbsPhotoNum = (int) photoPoiArea.poiPhotoNum;
        mediaLbsArea.desc = photoPoiArea.description;
        mediaLbsArea.sceneryName = photoPoiArea.sceneryName;
        return mediaLbsArea;
    }

    public static final MediaLbsArea y(LbsDataV2.PoiInfo poiInfo) {
        Intrinsics.checkNotNullParameter(poiInfo, "<this>");
        MediaLbsArea mediaLbsArea = new MediaLbsArea();
        StGPS stGPS = new StGPS();
        LbsDataV2.GpsInfo gpsInfo = poiInfo.gpsInfo;
        stGPS.lat = gpsInfo.lat;
        stGPS.alt = gpsInfo.alt;
        stGPS.lon = gpsInfo.lon;
        stGPS.eType = gpsInfo.gpsType;
        StLBS stLBS = new StLBS();
        stLBS.gps = stGPS;
        stLBS.address = poiInfo.address;
        stLBS.lbsId = poiInfo.poiId;
        stLBS.location = poiInfo.poiName;
        mediaLbsArea.lbsInfo = stLBS;
        return mediaLbsArea;
    }

    public static final ActiveAlbumInfo z(CommonActiveAlbumInfo commonActiveAlbumInfo) {
        Intrinsics.checkNotNullParameter(commonActiveAlbumInfo, "<this>");
        ActiveAlbumInfo activeAlbumInfo = new ActiveAlbumInfo();
        activeAlbumInfo.isActiveAlbum = commonActiveAlbumInfo.getIsActiveAlbum();
        activeAlbumInfo.jumpUrl = commonActiveAlbumInfo.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        return activeAlbumInfo;
    }
}
