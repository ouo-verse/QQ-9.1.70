package gh;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.qzone.album.util.QZoneAlbumUtil;
import com.qzone.common.account.LoginData;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.commoncode.module.videorecommend.utils.WeishiHelper;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.e;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import ho.h;
import java.net.URLDecoder;
import java.util.HashMap;
import r6.a;
import yo.d;
import yo.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {
    protected static void b(Context context, BusinessFeedData businessFeedData) {
        new a.C11115a();
        d.d("mqzone://arouse/album?albumid=" + businessFeedData.getPictureInfo().albumid + "&version=1&source=tafrefer&uin=" + businessFeedData.getPictureInfo().uin + "&albumtype=" + QZoneAlbumUtil.t(businessFeedData.getPictureInfo().anonymity) + "&syncuin=" + LoginData.getInstance().getUin() + "&individualalbum=" + (businessFeedData.getPictureInfo().individualAlbum ? 1 : 0), context, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Activity activity, BusinessFeedData businessFeedData, e eVar) {
        String str;
        String str2;
        HashMap hashMap;
        if (businessFeedData != null && businessFeedData.getFeedCommInfo().isOperationFeed()) {
            MiscReportUtils.o(businessFeedData.getOperationInfo().getOprationFeedTraceInfo());
        }
        if (eVar != null) {
            str = eVar.c();
            str2 = eVar.b();
        } else {
            str = null;
            str2 = null;
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("mqzone:%2F%2Farouse%2Fupdateqzonedesc")) {
            str = URLDecoder.decode(str);
        }
        boolean z16 = true;
        if (!TextUtils.isEmpty(str) && str.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP) && str.contains("qzone_feeds_lover_tail")) {
            if (businessFeedData != null) {
                long j3 = businessFeedData.owner_uin;
                if (j3 == 0) {
                    j3 = businessFeedData.getUser().uin;
                }
                hashMap = new HashMap();
                hashMap.put("uin", Long.valueOf(j3));
                if (str == null && str.startsWith("mqzone://arouse/album") && businessFeedData != null && (businessFeedData.isBabyAlbumFeed() || businessFeedData.isTravelAlbumFeed() || businessFeedData.isIndividualAlbumData() || businessFeedData.isLoverAlbumData() || businessFeedData.isMultiAlbumData())) {
                    b(activity, businessFeedData);
                    return;
                }
                if (str == null && WeishiHelper.isWeishiScheme(str)) {
                    d.d(str, activity, null);
                    return;
                }
                if (str == null && str.contains("mqzone://arouse/readschema")) {
                    return;
                }
                if (str == null && str.contains("mqzone://arouse/eventtagpage")) {
                    d.d(str, activity, null);
                    return;
                }
                if (str == null && str.startsWith("mqzone://arouse/album") && businessFeedData != null && businessFeedData.getVideoInfo() != null) {
                    yo.c.w(activity, str, businessFeedData);
                    return;
                }
                if (str == null && str.startsWith("mqzone://arouse/album") && businessFeedData != null && businessFeedData.getFeedCommInfo().appid == 202) {
                    yo.c.v(activity, str);
                    return;
                }
                if (str == null && str.startsWith(QZoneHelper.SCHEME_OPEN_HOME_PAGE)) {
                    return;
                }
                if (businessFeedData == null && businessFeedData.isCanvasAd()) {
                    a(activity, businessFeedData, new Object[0]);
                    return;
                }
                if (str == null && str.startsWith("mqqapi://qcircle")) {
                    d.d(str, activity, null);
                    return;
                }
                if (TextUtils.isEmpty(str) && str.startsWith("mqqapi://dating/")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QZoneBaseFeedActivity", 2, "handle dating jump .url = " + str);
                    }
                    Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
                    QZoneHelper.openWebSecurityVerify(intent);
                    intent.putExtra("fromQZone", true);
                    intent.putExtra("url", str);
                    yo.b.a(intent);
                    activity.startActivity(intent);
                } else {
                    if (!TextUtils.isEmpty(str) && str.startsWith("https") && str.contains("is_famous_space=1")) {
                        d.d(str, activity, null);
                    }
                    z16 = false;
                }
                if (z16) {
                    if (businessFeedData != null) {
                        businessFeedData.getFeedCommInfo().needAdvReport();
                    }
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty("") && !str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                    }
                    if (!TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/app") && !str.contains("from") && businessFeedData != null && businessFeedData.getReferInfoV2() != null) {
                        str = str + "&from=feeds&appname=" + businessFeedData.getReferInfoV2().appName;
                    }
                    if (businessFeedData != null && businessFeedData.isHasHighFive()) {
                        LpReportInfo_pf00064.allReport(302, 74, 4);
                    }
                    if ((businessFeedData == null || businessFeedData.isGDTAdvFeed()) && businessFeedData != null) {
                        return;
                    }
                    if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
                        int a16 = eVar != null ? eVar.a() : -1;
                        QZLog.i("QZoneURLHelper", " Miniapp: feedPos " + a16 + "  url:" + str);
                        if (businessFeedData != null && (businessFeedData.isFriendPlayingFeed() || businessFeedData.isFriendPlayingFeedV2() || businessFeedData.isFriendPlayingRecomm())) {
                            if (a16 == 3) {
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, 2090, null);
                                return;
                            } else if (a16 == 9 || a16 == 10) {
                                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, str, 2092, null);
                                return;
                            }
                        }
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put("expandFrom", "3");
                    d.e(str, activity, str2, hashMap);
                    return;
                }
                return;
            }
            QLog.e("QZoneBaseFeedActivity", 1, "feedData is null");
        }
        hashMap = null;
        if (str == null) {
        }
        if (str == null) {
        }
        if (str == null) {
        }
        if (str == null) {
        }
        if (str == null) {
        }
        if (str == null) {
        }
        if (str == null) {
        }
        if (businessFeedData == null) {
        }
        if (str == null) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        if (!TextUtils.isEmpty(str)) {
            d.d(str, activity, null);
        }
        z16 = false;
        if (z16) {
        }
    }

    public static int a(Activity activity, BusinessFeedData businessFeedData, Object... objArr) {
        String str;
        Object obj;
        BusinessFeedData businessFeedData2;
        if (businessFeedData == null || businessFeedData.getOperationInfo().actionType == 0) {
            return 0;
        }
        if (businessFeedData.getOperationInfo().actionType == 5) {
            long j3 = businessFeedData.getUser().uin;
            if (j3 <= 0 && (businessFeedData2 = businessFeedData.parentFeedData) != null) {
                j3 = businessFeedData2.getUser().uin;
            }
            h.b(activity, j3);
        } else if (businessFeedData.getOperationInfo().actionType != 21) {
            String str2 = null;
            if (businessFeedData.getOperationInfo().actionType == 23) {
                if (businessFeedData.getOperationInfo().userPost == 1 && !TextUtils.isEmpty(businessFeedData.getOperationInfo().postParams)) {
                    str2 = businessFeedData.getOperationInfo().postParams;
                }
                g gVar = new g(businessFeedData.getOperationInfo().schemaPageUrl, str2);
                HashMap hashMap = new HashMap();
                hashMap.put("key1", businessFeedData.getOperationInfo().downloadUrl);
                hashMap.put("key2", businessFeedData.getOperationInfo().click_stream_report);
                hashMap.put("key3", businessFeedData);
                gVar.f450714g = hashMap;
                d.e(businessFeedData.getOperationInfo().schemaPageUrl, activity, str2, hashMap);
            } else if (businessFeedData.getOperationInfo().actionType == 2) {
                if (businessFeedData.getOperationInfo().userPost == 1 && !TextUtils.isEmpty(businessFeedData.getOperationInfo().postParams)) {
                    str2 = businessFeedData.getOperationInfo().postParams;
                }
                if (businessFeedData.getFeedCommInfo().needAdvReport() && businessFeedData.getOperationInfo().downloadUrl != null && objArr != null && objArr.length > 0 && (obj = objArr[0]) != null && (obj instanceof View)) {
                    str = c6.a.d((View) obj);
                    if (!TextUtils.isEmpty(str)) {
                        str = "&s=" + str;
                    }
                } else {
                    str = "";
                }
                String str3 = businessFeedData.getOperationInfo().downloadUrl;
                if (str3 != null && !str3.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str3 = str3 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("businessFeedData", businessFeedData);
                if (!businessFeedData.isGDTAdvFeed()) {
                    d.e(str3 + str, activity, str2, hashMap2);
                }
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "send click report,gdtfeed_feedkey:" + businessFeedData.getFeedCommInfo().feedskey + " gdtfeed_content:" + businessFeedData.getCellSummary().summary + " url=" + businessFeedData.getOperationInfo().downloadUrl + str);
            }
        }
        return businessFeedData.getOperationInfo().actionType;
    }
}
