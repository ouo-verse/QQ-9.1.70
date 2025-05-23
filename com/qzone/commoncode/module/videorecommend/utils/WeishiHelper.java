package com.qzone.commoncode.module.videorecommend.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.l;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.File;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import yo.b;
import yo.d;
import yo.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class WeishiHelper {
    private static final String DOWNLOAD_TYPE_H5 = "type_h5";
    private static final String TAG = "WeiShiHelper";
    private static DownloadInfo sCachedWeiShiDownInfo;
    private static String sCachedWeiShiDownJsonStringHash;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface OnWeishiDownloadListener {
        void onGetIconText(int i3, String str);
    }

    public static void dealWeishicheme(Context context, String str, Map map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle e16 = f.e(str);
        String string = e16.getString(QZoneDTLoginReporter.SCHEMA);
        String string2 = e16.getString("weishi_schema");
        if (!TextUtils.isEmpty(string) && str.startsWith("mqzone://arouse/weishi") && isSchemeAvailable(context, string)) {
            jumpToWeishi(context, string);
            return;
        }
        if (!TextUtils.isEmpty(string2)) {
            d.e(string2, context, null, map);
            return;
        }
        final String string3 = e16.getString("url");
        String h5Url = getH5Url(string3);
        if (!TextUtils.isEmpty(h5Url)) {
            d.e(h5Url, context, null, map);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.commoncode.module.videorecommend.utils.WeishiHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    WeishiHelper.downloadWeishiAPK(string3);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void downloadWeishiAPK(String str) {
        boolean z16;
        final DownloadInfo donwloadInfo = getDonwloadInfo(str);
        if (donwloadInfo == null) {
            return;
        }
        DownloadInfo w3 = DownloadManager.C().w(donwloadInfo.f341184e);
        if (w3 != null) {
            int f16 = w3.f();
            if (f16 != 20 && f16 != 2) {
                if (f16 == 4 && !new File(donwloadInfo.L).exists()) {
                    z16 = true;
                    DownloadManager.C().g(donwloadInfo.f341184e, "", true);
                    if (!z16) {
                        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.qzone.commoncode.module.videorecommend.utils.WeishiHelper.2
                            @Override // java.lang.Runnable
                            public void run() {
                                DownloadManager.C().d0(DownloadInfo.this);
                            }
                        });
                        return;
                    } else {
                        DownloadManager.C().d0(donwloadInfo);
                        return;
                    }
                }
            } else {
                DownloadManager.C().Q(donwloadInfo.f341184e);
                return;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    protected static DownloadInfo getDonwloadInfo(String str) {
        int i3;
        DownloadInfo downloadInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (String.valueOf(str.hashCode()).equals(sCachedWeiShiDownJsonStringHash) && (downloadInfo = sCachedWeiShiDownInfo) != null) {
            return downloadInfo;
        }
        DownloadInfo downloadInfo2 = new DownloadInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("isH5");
            if (!TextUtils.isEmpty(optString) && optString.equals("1")) {
                downloadInfo2.f341181c0 = DOWNLOAD_TYPE_H5;
            } else {
                String string = jSONObject.getString("appid");
                downloadInfo2.f341184e = string;
                if (!TextUtils.isEmpty(string)) {
                    downloadInfo2.f341184e = downloadInfo2.f341184e.trim();
                }
                downloadInfo2.f341186f = jSONObject.getString("url");
                downloadInfo2.f341189h = jSONObject.getString("packageName");
                downloadInfo2.C = jSONObject.getString("via");
                downloadInfo2.T = true;
                downloadInfo2.f341183d0 = true;
                downloadInfo2.Z = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
                String string2 = jSONObject.getString("isAutoInstall");
                if (string2 != null) {
                    downloadInfo2.T = string2.equals("1");
                }
                String string3 = jSONObject.getString(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK);
                if (string3 != null) {
                    downloadInfo2.f341183d0 = string3.equals("1");
                }
                String string4 = jSONObject.getString("isShowNotification");
                if (string4 != null) {
                    if (string4.equals("1")) {
                        i3 = TMAssistantDownloadConst.SHOW_NOTIFICATION_TRUE;
                    } else {
                        i3 = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
                    }
                    downloadInfo2.Z = i3;
                }
                downloadInfo2.X = true;
                downloadInfo2.M = "biz_src_jc_qzone";
                downloadInfo2.f341191i = jSONObject.getString("appName");
            }
            sCachedWeiShiDownInfo = downloadInfo2;
            sCachedWeiShiDownJsonStringHash = String.valueOf(str.hashCode());
            downloadInfo2.M = "biz_src_jc_qzone";
            return downloadInfo2;
        } catch (JSONException e16) {
            j.c(TAG, "getDonwloadInfo, json err:" + str + "," + e16.getMessage());
            return null;
        }
    }

    protected static String getH5Url(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("isH5");
            if (TextUtils.isEmpty(optString) || !optString.equals("1")) {
                return null;
            }
            return jSONObject.optString("url");
        } catch (JSONException e16) {
            j.c(TAG, "getH5Url, json err:" + str + "," + e16.getMessage());
            return null;
        }
    }

    public static String getWeiIconText(String str) {
        if (!isWeishiScheme(str)) {
            return "";
        }
        Bundle e16 = f.e(str);
        if (isSchemeAvailable(e16.getString(QZoneDTLoginReporter.SCHEMA))) {
            return l.a(R.string.vkm);
        }
        DownloadInfo donwloadInfo = getDonwloadInfo(e16.getString("url"));
        if (donwloadInfo == null) {
            return "";
        }
        if (DOWNLOAD_TYPE_H5.equals(donwloadInfo.f341181c0)) {
            return l.a(R.string.vkk);
        }
        String a16 = l.a(R.string.vkh);
        DownloadInfo w3 = DownloadManager.C().w(donwloadInfo.f341184e);
        return w3 != null ? getButtonTextByState(w3.f(), true) : a16;
    }

    public static String getWeishiFeedSid(String str) {
        if (isWeishiScheme(str)) {
            return parseUrlParams(f.e(str).getString(QZoneDTLoginReporter.SCHEMA)).getString("feed_id", "");
        }
        return null;
    }

    public static boolean isLandscapevideolayerSchema(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/landscapevideolayer");
    }

    public static boolean isSchemeAvailable(String str) {
        return isSchemeAvailable(BaseApplication.getContext(), str);
    }

    public static boolean isVerticalNormalVideoLayerSchema(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/normalvideolayer");
    }

    public static boolean isWeishiInstall(String str) {
        if (isWeishiScheme(str)) {
            return isSchemeAvailable(f.e(str).getString(QZoneDTLoginReporter.SCHEMA));
        }
        return false;
    }

    public static boolean isWeishiScheme(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/weishi");
    }

    public static boolean isWeishiVideoLayerScheme(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/weishivideolayer");
    }

    public static void log(String str) {
        j.f(TAG, str);
    }

    private static Bundle parseUrlParams(String str) {
        int indexOf;
        int i3;
        String[] split;
        Bundle bundle = new Bundle();
        if (str != null && (indexOf = str.indexOf(63)) >= 0 && (i3 = indexOf + 1) < str.length()) {
            String substring = str.substring(i3);
            if (!TextUtils.isEmpty(substring) && (split = substring.split(ContainerUtils.FIELD_DELIMITER)) != null) {
                for (String str2 : split) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2 != null && split2.length == 2) {
                        bundle.putString(split2[0], split2[1]);
                    }
                }
            }
        }
        return bundle;
    }

    public static void reportWeishiVideoExposure(int i3, int i16, int i17, String str) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        String weishiFeedSid = getWeishiFeedSid(str);
        if (!TextUtils.isEmpty(weishiFeedSid)) {
            lpReportInfo_pf00064.reserves3 = weishiFeedSid;
        }
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    protected static boolean isSchemeAvailable(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(str));
        return isIntentAvailable(context, intent);
    }

    public static String getButtonTextByState(int i3, boolean z16) {
        String a16 = l.a(R.string.vki);
        if (i3 != -2) {
            if (i3 != 6 && i3 != 13) {
                if (i3 != 20) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    if (z16) {
                                        return l.a(R.string.vke);
                                    }
                                    return l.a(R.string.vkj);
                                }
                                if (i3 == 9) {
                                    return l.a(R.string.vkg);
                                }
                                if (i3 != 10) {
                                    return a16;
                                }
                            }
                        }
                    }
                }
                return l.a(R.string.vkf);
            }
            return l.a(R.string.vkl);
        }
        return l.a(R.string.vkn);
    }

    public static void jumpToWeishi(Context context, String str) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(str));
        b.a(intent);
        if (isIntentAvailable(context, intent)) {
            try {
                context.startActivity(intent);
            } catch (Exception e16) {
                j.d(TAG, "jumpToWeishi error scheme = " + str, e16);
            }
        }
    }

    public static void reportWeiShiPicMediaView(int i3, int i16, int i17, BusinessFeedData businessFeedData) {
        String str;
        if (businessFeedData == null) {
            return;
        }
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = i3;
        lpReportInfo_pf00064.subactionType = i16;
        lpReportInfo_pf00064.reserves = i17;
        String str2 = "";
        if (businessFeedData.getCommentInfoV2() == null) {
            str = "";
        } else {
            str = businessFeedData.getCommentInfoV2().feedkey;
        }
        int i18 = 2;
        int i19 = businessFeedData.getFeedCommInfo().isBizRecomFeeds() ? 2 : 1;
        long j3 = businessFeedData.getCellUserInfo().user != null ? businessFeedData.getCellUserInfo().user.uin : -1L;
        if (businessFeedData.getVideoInfo() == null) {
            i18 = -1;
        } else if (!businessFeedData.getVideoInfo().isUgcVideo()) {
            i18 = 1;
        }
        if (businessFeedData.getVideoInfo() != null) {
            str2 = businessFeedData.getVideoInfo().videoId;
        }
        lpReportInfo_pf00064.reserves3 = str;
        lpReportInfo_pf00064.reserves4 = String.valueOf(i19);
        if (j3 > 0) {
            lpReportInfo_pf00064.reserves5 = String.valueOf(j3);
        }
        if (i18 > 0) {
            lpReportInfo_pf00064.reserves6 = String.valueOf(i18);
        }
        if (!TextUtils.isEmpty(str2)) {
            lpReportInfo_pf00064.reserves8 = str2;
        }
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        return (context == null || intent == null || InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 65536).size() <= 0) ? false : true;
    }
}
