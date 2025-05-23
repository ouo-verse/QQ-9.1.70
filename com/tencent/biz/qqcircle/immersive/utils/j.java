package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.RoomMasterTable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleAdClickEvent;
import com.tencent.biz.qqcircle.utils.bx;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoDeclare;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.common.data.MaskAdvName;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StFeedAdv;
import feedcloud.FeedCloudRead$StGetCommtListAdInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tencent.gdt.access;
import tencent.gdt.creatorReader;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bj\u0010kJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0015J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010!\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0004J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010&\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010(\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0002J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010\u00012\b\u0010,\u001a\u0004\u0018\u00010+J4\u00104\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u0004J>\u00106\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u0002J4\u00107\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u0004J>\u00108\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u0002J4\u00109\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00103\u001a\u00020\u0004JF\u0010<\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u00100\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00112\b\u0010;\u001a\u0004\u0018\u00010\u00022\b\u00105\u001a\u0004\u0018\u00010\u0002J\u001a\u0010?\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u00010.2\b\u0010>\u001a\u0004\u0018\u00010=J\u0016\u0010A\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0004J\u0018\u0010B\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u00010\u0002J\u0010\u0010D\u001a\u00020\u00112\b\u0010C\u001a\u0004\u0018\u00010\u0002J\u0016\u0010F\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\tJ\u0018\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010I\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010K\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020\u0002J\u000e\u0010L\u001a\u00020\u00112\u0006\u0010J\u001a\u00020\u0002J\u0006\u0010M\u001a\u00020\u0011J\b\u0010N\u001a\u0004\u0018\u00010=R\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\"\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR*\u0010\\\u001a\u0016\u0012\u0004\u0012\u00020X\u0018\u00010Wj\n\u0012\u0004\u0012\u00020X\u0018\u0001`Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010aR2\u0010f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`d8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010eR2\u0010g\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`d8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010eR2\u0010i\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`d8\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010e\u00a8\u0006l"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/utils/j;", "", "", QZoneDTLoginReporter.SCHEMA, "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "Ltencent/gdt/access$AdGetReq;", "g", "adCount", "", "feedUin", "feedId", tl.h.F, "key", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "view", "", UserInfo.SEX_FEMALE, "Ltencent/gdt/qq_ad_get$QQAdGet$PositionInfo;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/pb/ByteStringMicro;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Lcooperation/qqcircle/report/QCircleReportBean;", "reportBean", "", "O", "D", "j", "k", "source", "l", "pageId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "v", "w", "o", "posId", "p", "Lfeedcloud/FeedCloudMeta$StFeed;", "sourceData", "P", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "feedPosition", "Lcom/tencent/biz/qqcircle/beans/QCircleExtraTypeInfo;", "extraTypeInfo", "areaId", "I", "antiSpamParams", "J", "K", "L", BdhLogUtil.LogTag.Tag_Conn, "needVideoCell", "widthHeightRatioOfVideoCeiling", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/content/Context;", "context", "M", "url", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "traceId", "f", "aid", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfeedcloud/FeedCloudRead$StGetCommtListAdInfo;", "r", "u", "uin", "T", "H", "G", "t", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "b", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "mDeviceInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "mExposedAdMap", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "mMaskAdCacheInfo", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "e", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mCheckerCallback", "Ljava/lang/String;", "mShareAdSourceFrom", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mSrcPosIds", "mPageIdTypes", "i", "mSrcTypes", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static qq_ad_get.QQAdGet.DeviceInfo mDeviceInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static AdExposureChecker.ExposureCallback mCheckerCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @QAutoDeclare(configPath = "AutoInjectYml/Business/Ad/Inject_qfs_ad_pos_id_config.yml", version = 1)
    @NotNull
    private static HashMap<String, String> mSrcPosIds;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @QAutoDeclare(configPath = "AutoInjectYml/Business/Ad/Inject_qfs_ad_type_config.yml", version = 1)
    @NotNull
    private static HashMap<String, String> mPageIdTypes;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @QAutoDeclare(configPath = "AutoInjectYml/Business/Ad/Inject_qfs_ad_src_config.yml", version = 1)
    @NotNull
    private static HashMap<String, String> mSrcTypes;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f90213a = new j();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, Long> mExposedAdMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ArrayList<JSONObject> mMaskAdCacheInfo = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.QFS_PUB);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static volatile String mShareAdSourceFrom = "";

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        mSrcPosIds = hashMap;
        hashMap.put("50", "1093912648503847");
        mSrcPosIds.put("48", "6035937783693251");
        mSrcPosIds.put("47", "9065344400302993");
        mSrcPosIds.put("46", "7025132829821006");
        mSrcPosIds.put("44", "8015428787185186");
        mSrcPosIds.put("43", "9095728787087741");
        mSrcPosIds.put(RoomMasterTable.DEFAULT_ID, "9065124787483257");
        mSrcPosIds.put("41", "7045620767386188");
        mSrcPosIds.put("40", "2005529797544305");
        mSrcPosIds.put("39", "5095818098883588");
        mSrcPosIds.put("38", "3055903952854163");
        mSrcPosIds.put("37", "9085219024427846");
        mSrcPosIds.put("35", "6004074325309381");
        mSrcPosIds.put(WadlProxyConsts.OPER_TYPE_APK_SIGN, "4034258734621553");
        mSrcPosIds.put("32", "7024346959921368");
        mSrcPosIds.put("31", "3064923816472173");
        mSrcPosIds.put("26", "6043469981436145");
        mSrcPosIds.put("23", "3073335280629598");
        mSrcPosIds.put("19", "2042245781653539");
        HashMap<String, String> hashMap2 = new HashMap<>();
        mPageIdTypes = hashMap2;
        hashMap2.put(QCircleDaTongConstant.PageId.PG_XSJ_SHARE_MID_PAGE, "46");
        mPageIdTypes.put(QCircleDaTongConstant.PageId.PG_XSJ_QZEON_VIDEO_UGC_MID_PAG, "43");
        mPageIdTypes.put(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_VIDEO_TAB_MID_PAGE, RoomMasterTable.DEFAULT_ID);
        mPageIdTypes.put(QCircleDaTongConstant.PageId.PG_XSJ_QZONE_MID_PAGE, "41");
        mPageIdTypes.put("pg_xsj_qzone_friend_video_mid_page", "40");
        mPageIdTypes.put("pg_xsj_qqshopping_feed_ground_mid_page", "31");
        HashMap<String, String> hashMap3 = new HashMap<>();
        mSrcTypes = hashMap3;
        hashMap3.put("1002", "38");
        mSrcTypes.put("1001", "35");
        mSrcTypes.put("88", "47");
        mSrcTypes.put("85", "37");
        mSrcTypes.put("76", "39");
        mSrcTypes.put("74", "32");
        mSrcTypes.put("61", "26");
        mSrcTypes.put("47", WadlProxyConsts.OPER_TYPE_APK_SIGN);
    }

    j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(GdtAd gdtAd, String str, WeakReference weakReference) {
        String str2;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo;
        PBStringField pBStringField;
        String str3;
        QLog.d("QFSAdUtils", 1, "exposure callback success");
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = null;
        if (gdtAd != null && (adInfo = gdtAd.info) != null && (reportInfo = adInfo.report_info) != null && (pBStringField = reportInfo.exposure_url) != null && (str3 = pBStringField.get()) != null) {
            str2 = f90213a.R(str3, GdtAntiSpamReportHelper.getAdAntiSpamExpoFromClickParams(str));
        } else {
            str2 = null;
        }
        if (str2 != null) {
            d.f90201a.d(str2);
        }
        GdtThirdProcessorProxy gdtThirdProcessorProxy = new GdtThirdProcessorProxy();
        if (gdtAd != null) {
            adInfo2 = gdtAd.info;
        }
        gdtThirdProcessorProxy.c2sReportAsync(0, 4, adInfo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E() {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(RFWApplication.getApplication(), new InitGdtContextParams());
        mDeviceInfo = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.d();
    }

    private final boolean F(View view) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (view != null && view.getId() == R.id.f38571_b) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (view != null && view.getId() == R.id.f38721_q) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        if (view != null && view.getId() == R.id.f374817d) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            return true;
        }
        if (view != null && view.getId() == R.id.f42301je) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Context context, GdtAd gdtAd) {
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(context, gdtAd);
    }

    private final access.AdGetReq g(String schema, int busiType) {
        return h(schema, busiType, 2, 0L, "");
    }

    private final access.AdGetReq h(String schema, int busiType, int adCount, long feedUin, String feedId) {
        String v3;
        access.AdGetReq adGetReq = new access.AdGetReq();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            adGetReq.busi_type.set(busiType);
            adGetReq.client_mod.set(com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.f());
            adGetReq.schema_source.set(schema);
            if (!TextUtils.isEmpty(feedId)) {
                access.VideoFeedInfo videoFeedInfo = new access.VideoFeedInfo();
                videoFeedInfo.feed_id.set(feedId);
                adGetReq.video_feed_info.set(videoFeedInfo);
            }
            qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
            PBStringField pBStringField = positionInfo.pos_id;
            if (busiType == 39) {
                v3 = w(schema);
            } else {
                v3 = v(String.valueOf(busiType));
            }
            pBStringField.set(v3);
            positionInfo.ad_count.set(adCount);
            qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
            positionExt.deep_link_version.set(1);
            positionInfo.pos_ext.set(positionExt);
            qQAdGet.position_info.add(positionInfo);
            String c16 = bx.c();
            if (!TextUtils.isEmpty(c16)) {
                qq_ad_get.QQAdGet.UserInfo userInfo = new qq_ad_get.QQAdGet.UserInfo();
                userInfo.ams_qq_openid.set(c16);
                qQAdGet.user_info.set(userInfo);
            }
            if (busiType == 32) {
                qQAdGet.position_info.add(x());
            }
            qq_ad_get.QQAdGet.DeviceInfo deviceInfo = mDeviceInfo;
            if (deviceInfo != null) {
                qQAdGet.device_info.set(deviceInfo);
            }
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.e
                @Override // java.lang.Runnable
                public final void run() {
                    j.i();
                }
            });
            qQAdGet.support_https.set(true);
            if (feedUin != 0) {
                qq_ad_get.QQAdGet.ContextInfo contextInfo = new qq_ad_get.QQAdGet.ContextInfo();
                contextInfo.public_id.set(feedUin);
                contextInfo.article_id.set(feedUin);
                if (!TextUtils.isEmpty(mShareAdSourceFrom)) {
                    contextInfo.str_source_from.set(mShareAdSourceFrom);
                    mShareAdSourceFrom = "";
                }
                qQAdGet.context_info.set(contextInfo);
            }
        } catch (Throwable th5) {
            QLog.e("QFSAdUtils", 1, "create ad req failed", th5);
        }
        adGetReq.qq_ad_get.set(qQAdGet);
        return adGetReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        mDeviceInfo = com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.d();
    }

    private final ByteStringMicro s(String feedUin, String feedId) {
        long j3;
        try {
            j3 = Long.parseLong(feedUin);
        } catch (NumberFormatException e16) {
            QLog.e("QFSAdUtils", 1, "getCommentListAdInfo parse feedUin error:", e16);
            j3 = 0;
        }
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(h("", 50, 1, j3, feedId).toByteArray());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(\n            cr\u2026).toByteArray()\n        )");
        return copyFrom;
    }

    private final qq_ad_get.QQAdGet.PositionInfo x() {
        qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
        positionInfo.pos_id.set("5005607931217942");
        positionInfo.ad_count.set(2);
        qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
        positionExt.deep_link_version.set(1);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.i
            @Override // java.lang.Runnable
            public final void run() {
                j.y();
            }
        });
        ArrayList<JSONObject> arrayList = mMaskAdCacheInfo;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<JSONObject> it = arrayList.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem specifiedAdsItem = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.SpecifiedAdsItem();
                specifiedAdsItem.aid.set(next.optLong("aid", 0L));
                specifiedAdsItem.creative_id.set(next.optLong("creative_id", 0L));
                PBUInt64Field pBUInt64Field = specifiedAdsItem.version;
                String optString = next.optString("version", "0");
                Intrinsics.checkNotNullExpressionValue(optString, "adJson.optString(RES_VERSION, \"0\")");
                pBUInt64Field.set(Long.parseLong(optString));
                arrayList2.add(specifiedAdsItem);
            }
            positionExt.specified_ads.set(arrayList2);
        }
        positionInfo.pos_ext.set(positionExt);
        return positionInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y() {
        mMaskAdCacheInfo = ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).getMaskAdInfoList(MaskAdvName.QFS_PUB);
    }

    private final String z(String schema, String key) {
        try {
            Uri parse = Uri.parse(schema);
            if (parse.getQueryParameter(key) == null) {
                return "";
            }
            return parse.getQueryParameter(key);
        } catch (Exception e16) {
            QLog.e("QFSAdUtils", 1, "parseSchema error, schema: " + schema + ", key: " + key, e16);
            return "";
        }
    }

    public final void A(@Nullable final GdtAd gdtAd, @Nullable View view, int feedPosition, int areaId, boolean needVideoCell, @Nullable String widthHeightRatioOfVideoCeiling, @Nullable final String antiSpamParams) {
        Context context;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo;
        String str;
        GdtAd gdtAd2;
        String str2;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = null;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        GdtHandler.Params params = new GdtHandler.Params();
        if (gdtAd != null) {
            adInfo = gdtAd.info;
        } else {
            adInfo = null;
        }
        params.f108486ad = new GdtAd(adInfo);
        if (gdtAd != null) {
            str = gdtAd.getTraceId();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && (gdtAd2 = params.f108486ad) != null) {
            if (gdtAd != null) {
                str2 = gdtAd.getTraceId();
            } else {
                str2 = null;
            }
            long a16 = com.tencent.biz.qqcircle.immersive.feed.ad.v.a(str2);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a16);
            gdtAd2.replaceUrlForClick("__VIDEO_PLAY_TIME__", sb5.toString());
        }
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        params.activity = new WeakReference<>((Activity) context);
        Bundle bundle = new Bundle();
        params.extra = bundle;
        params.componentID = areaId;
        if (needVideoCell) {
            params.directPlay = true;
            params.videoCeilingSupportedIfNotInstalled = true;
            params.widthHeightRatioOfVideoCeiling = widthHeightRatioOfVideoCeiling;
        }
        params.antiSpamParams = antiSpamParams;
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_ads_xsj");
        mCheckerCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.biz.qqcircle.immersive.utils.f
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                j.B(GdtAd.this, antiSpamParams, weakReference);
            }
        };
        AdExposureChecker.onClick(context, gdtAd, new WeakReference(mCheckerCallback));
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        GdtThirdProcessorProxy gdtThirdProcessorProxy = new GdtThirdProcessorProxy();
        if (gdtAd != null) {
            adInfo2 = gdtAd.info;
        }
        gdtThirdProcessorProxy.c2sReportAsync(1, 4, adInfo2);
        if (gdtAd != null) {
            d.f90201a.f(gdtAd, 1, feedPosition);
        }
    }

    public final void C(@Nullable GdtAd gdtAd, @Nullable View view, int feedPosition, @Nullable QCircleExtraTypeInfo extraTypeInfo, int areaId) {
        if (gdtAd != null && gdtAd.isValid()) {
            A(gdtAd, view, feedPosition, areaId, false, null, null);
            d.f90201a.h(400, 2, extraTypeInfo, 2);
        } else {
            QLog.d("QFSAdUtils", 1, "ad is inValid, cancel open landing page");
        }
    }

    public final void D() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.g
            @Override // java.lang.Runnable
            public final void run() {
                j.E();
            }
        });
    }

    public final boolean G() {
        return false;
    }

    public final boolean H(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        MMKVOptionEntity from = QMMKV.from(t(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        String decodeString = from.decodeString("key_share_ad_uin_from_personal_layer", "");
        if (TextUtils.isEmpty(decodeString)) {
            return false;
        }
        return TextUtils.equals(uin, decodeString);
    }

    public final void I(@Nullable GdtAd gdtAd, @Nullable View view, int feedPosition, @Nullable QCircleExtraTypeInfo extraTypeInfo, int areaId) {
        J(gdtAd, view, feedPosition, extraTypeInfo, areaId, null);
    }

    public final void J(@Nullable GdtAd gdtAd, @Nullable View view, int feedPosition, @Nullable QCircleExtraTypeInfo extraTypeInfo, int areaId, @Nullable String antiSpamParams) {
        if (fb0.a.b("QFSAdUtils" + areaId, 500L)) {
            QLog.d("QFSAdUtils", 1, "[openLandingPage] fastDoubleClick.");
            return;
        }
        if (gdtAd != null && gdtAd.isValid()) {
            if (gdtAd.getClickMode() != 10 && !F(view)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QFSAdUtils", 1, "click model limited, cancel open landing page");
                    return;
                }
                return;
            }
            L(gdtAd, view, feedPosition, extraTypeInfo, areaId, antiSpamParams);
            return;
        }
        QLog.d("QFSAdUtils", 1, "ad is inValid, cancel open landing page");
    }

    public final void K(@Nullable GdtAd gdtAd, @Nullable View view, int feedPosition, @Nullable QCircleExtraTypeInfo extraTypeInfo, int areaId) {
        L(gdtAd, view, feedPosition, extraTypeInfo, areaId, null);
    }

    public final void L(@Nullable GdtAd gdtAd, @Nullable View view, int feedPosition, @Nullable QCircleExtraTypeInfo extraTypeInfo, int areaId, @Nullable String antiSpamParams) {
        if (gdtAd != null && gdtAd.isValid()) {
            d dVar = d.f90201a;
            dVar.h(400, 2, extraTypeInfo, 1);
            A(gdtAd, view, feedPosition, areaId, true, "16:9", antiSpamParams);
            SimpleEventBus.getInstance().dispatchEvent(new QCircleAdClickEvent(gdtAd.getTraceId()));
            dVar.m(gdtAd.getTraceId(), "click_pos", String.valueOf(areaId));
            dVar.m(gdtAd.getTraceId(), "action", "1");
            return;
        }
        QLog.e("QFSAdUtils", 1, "[openLandingPageWithoutClickMode] error, ad is invalid");
    }

    public final void M(@Nullable final GdtAd gdtAd, @Nullable final Context context) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.h
            @Override // java.lang.Runnable
            public final void run() {
                j.N(context, gdtAd);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:32:0x004d, B:15:0x0056, B:17:0x005c, B:18:0x0062, B:20:0x0068, B:21:0x006e, B:23:0x0074), top: B:31:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0068 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:32:0x004d, B:15:0x0056, B:17:0x005c, B:18:0x0062, B:20:0x0068, B:21:0x006e, B:23:0x0074), top: B:31:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:32:0x004d, B:15:0x0056, B:17:0x005c, B:18:0x0062, B:20:0x0068, B:21:0x006e, B:23:0x0074), top: B:31:0x004d }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O(@Nullable QCircleInitBean initBean, @Nullable QCircleReportBean reportBean) {
        int i3;
        String str;
        String str2;
        String str3 = "";
        if (initBean != null) {
            QCircleExtraTypeInfo extraTypeInfo = initBean.getExtraTypeInfo();
            if (extraTypeInfo != null) {
                Intrinsics.checkNotNullExpressionValue(extraTypeInfo, "extraTypeInfo");
                i3 = extraTypeInfo.sourceType;
            } else {
                i3 = 0;
            }
            HashMap<String, String> schemeAttrs = initBean.getSchemeAttrs();
            if (schemeAttrs != null) {
                Intrinsics.checkNotNullExpressionValue(schemeAttrs, "schemeAttrs");
                if (schemeAttrs.containsKey("xsj_main_entrance")) {
                    str = String.valueOf(schemeAttrs.get("xsj_main_entrance"));
                    if (reportBean != null) {
                        str2 = "";
                    } else {
                        str3 = reportBean.getDtPageId();
                        str2 = reportBean.getDtFromPageId();
                    }
                    JSONObject jSONObject = new JSONObject();
                    if (i3 != 0) {
                        try {
                            jSONObject.put("feedSource", i3);
                        } catch (Throwable th5) {
                            QLog.e("QFSAdUtils", 1, "getStrSourceFrom error:", th5);
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("entranceSource", str);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("dtPageId", str3);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("dtFromPageId", str2);
                    }
                    String jSONObject2 = jSONObject.toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "sourceFromJson.toString()");
                    mShareAdSourceFrom = jSONObject2;
                    QLog.d("QFSAdUtils", 2, "getStrSourceFrom:", mShareAdSourceFrom);
                }
            }
        } else {
            i3 = 0;
        }
        str = "";
        if (reportBean != null) {
        }
        JSONObject jSONObject3 = new JSONObject();
        if (i3 != 0) {
        }
        if (!TextUtils.isEmpty(str)) {
        }
        if (!TextUtils.isEmpty(str3)) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        String jSONObject22 = jSONObject3.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject22, "sourceFromJson.toString()");
        mShareAdSourceFrom = jSONObject22;
        QLog.d("QFSAdUtils", 2, "getStrSourceFrom:", mShareAdSourceFrom);
    }

    @Nullable
    public final Object P(@Nullable FeedCloudMeta$StFeed sourceData) {
        FeedCloudMeta$StFeedAdv feedCloudMeta$StFeedAdv;
        byte[] bArr;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        if (sourceData != null) {
            feedCloudMeta$StFeedAdv = sourceData.advInfo;
        } else {
            feedCloudMeta$StFeedAdv = null;
        }
        if (feedCloudMeta$StFeedAdv != null && sourceData.advInfo.jobID.get() != 0) {
            try {
                creatorReader.CreatorAD creatorAD = new creatorReader.CreatorAD();
                FeedCloudMeta$StFeedAdv feedCloudMeta$StFeedAdv2 = sourceData.advInfo;
                if (feedCloudMeta$StFeedAdv2 != null && (pBBytesField = feedCloudMeta$StFeedAdv2.advData) != null && (byteStringMicro = pBBytesField.get()) != null) {
                    bArr = byteStringMicro.toByteArray();
                } else {
                    bArr = null;
                }
                creatorAD.mergeFrom(bArr);
                return creatorAD;
            } catch (Exception e16) {
                QLog.e("QFSAdUtils", 1, "transAdInfo failed, error is " + e16);
            }
        }
        return null;
    }

    public final void Q(@NotNull String traceId, long aid) {
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (mExposedAdMap.size() > 200) {
            mExposedAdMap.clear();
        }
        mExposedAdMap.put(traceId, Long.valueOf(aid));
    }

    @NotNull
    public final String R(@NotNull String url, @Nullable String antiSpamParams) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (TextUtils.isEmpty(antiSpamParams)) {
            return url;
        }
        return url + "&s=" + antiSpamParams;
    }

    @NotNull
    public final String S(@NotNull String url, int feedPosition) {
        Intrinsics.checkNotNullParameter(url, "url");
        return url + "&slot=" + feedPosition;
    }

    public final void T(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        MMKVOptionEntity from = QMMKV.from(t(), QMMKVFile.FILE_AD);
        Intrinsics.checkNotNullExpressionValue(from, "from(getContext(), QMMKVFile.FILE_AD)");
        from.encodeString("key_share_ad_uin_from_personal_layer", uin);
        QLog.d("QFSAdUtils", 1, "updateShareAdUinFromPersonalLayer:", uin);
    }

    public final boolean f(@Nullable String traceId) {
        return mExposedAdMap.containsKey(traceId);
    }

    @NotNull
    public final ByteStringMicro j() {
        return k("");
    }

    @NotNull
    public final ByteStringMicro k(@NotNull String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(g(schema, 19).toByteArray());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(createAdReq(sch\u2026VIDEO_ADV).toByteArray())");
        return copyFrom;
    }

    @NotNull
    public final ByteStringMicro l(@NotNull String schema, int source) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(g(schema, n(schema, source)).toByteArray());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(\n            cr\u2026).toByteArray()\n        )");
        return copyFrom;
    }

    @NotNull
    public final ByteStringMicro m(@NotNull String schema, @Nullable String pageId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(schema, "schema");
        if (pageId != null && pageId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            pageId = z(schema, "xsj_custom_pgid");
        }
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(g(schema, o(pageId)).toByteArray());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(\n              \u2026).toByteArray()\n        )");
        return copyFrom;
    }

    public final int n(@NotNull String schema, int source) {
        boolean equals$default;
        Intrinsics.checkNotNullParameter(schema, "schema");
        equals$default = StringsKt__StringsJVMKt.equals$default(z(schema, "xsj_main_entrance"), QCircleDaTongConstant.ElementParamValue.QQ_SHOPPING, false, 2, null);
        if (equals$default) {
            return 31;
        }
        return q(source);
    }

    public final int o(@Nullable String pageId) {
        boolean z16;
        String str = mPageIdTypes.get(pageId);
        QLog.d("QFSAdUtils", 2, "pageid: " + pageId + " BusiType " + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 44;
        }
        return Integer.parseInt(str);
    }

    public final int p(@NotNull String posId) {
        Object first;
        Intrinsics.checkNotNullParameter(posId, "posId");
        HashMap<String, String> hashMap = mSrcPosIds;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (Intrinsics.areEqual(posId, entry.getValue())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        if (!keySet.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first(keySet);
            return Integer.parseInt((String) first);
        }
        return 19;
    }

    public final int q(int source) {
        boolean z16;
        String str = mSrcTypes.get(String.valueOf(source));
        QLog.d("QFSAdUtils", 2, "src: " + source + " BusiType " + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 19;
        }
        return Integer.parseInt(str);
    }

    @Nullable
    public final FeedCloudRead$StGetCommtListAdInfo r(@NotNull String feedUin, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(feedUin, "feedUin");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        FeedCloudRead$StGetCommtListAdInfo feedCloudRead$StGetCommtListAdInfo = new FeedCloudRead$StGetCommtListAdInfo();
        if (!com.tencent.biz.qqcircle.immersive.utils.ad.a.f90082a.j() && H(feedUin)) {
            QLog.d("QFSAdUtils", 1, "getCommentListAdInfo: share ad personal layer");
        } else {
            feedCloudRead$StGetCommtListAdInfo.is_need_pull_ad.set(1);
            feedCloudRead$StGetCommtListAdInfo.ad_trans_req.set(s(feedUin, feedId));
        }
        return feedCloudRead$StGetCommtListAdInfo;
    }

    @Nullable
    public final Context t() {
        return MobileQQ.sMobileQQ.getApplicationContext();
    }

    @NotNull
    public final ByteStringMicro u(@NotNull String feedUin, @NotNull String feedId) {
        long j3;
        Intrinsics.checkNotNullParameter(feedUin, "feedUin");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        try {
            j3 = Long.parseLong(feedUin);
        } catch (NumberFormatException e16) {
            QLog.e("QFSAdUtils", 1, "getCommentListAdInfo parse feedUin error:", e16);
            j3 = 0;
        }
        ByteStringMicro copyFrom = ByteStringMicro.copyFrom(h("", 48, 1, j3, feedId).toByteArray());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(\n            cr\u2026).toByteArray()\n        )");
        return copyFrom;
    }

    @NotNull
    public final String v(@NotNull String busiType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(busiType, "busiType");
        String str = mSrcPosIds.get(busiType);
        QLog.d("QFSAdUtils", 2, "busiType " + busiType + "targetPosId " + str);
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "2042245781653539";
        }
        return str;
    }

    @NotNull
    public final String w(@NotNull String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        String z16 = z(schema, "from");
        if (z16 == null) {
            return "5095818098883588";
        }
        if (Intrinsics.areEqual(z16, "2")) {
            return "2065383172828444";
        }
        if (!Intrinsics.areEqual(z16, "8")) {
            return "5095818098883588";
        }
        return "5005383162623516";
    }
}
