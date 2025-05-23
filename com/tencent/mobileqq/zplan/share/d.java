package com.tencent.mobileqq.zplan.share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.transit.MasterInfo;
import com.tencent.mobileqq.vas.transit.TransitPageConfig;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.vas.transit.VisitorInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZplanShareArkInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b1\u00102J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ \u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ \u0010\"\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J(\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\u00062\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010&J(\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\u00062\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010&J\u001e\u0010*\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010+\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J*\u0010.\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,J\u0012\u0010/\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0012\u00100\u001a\u0004\u0018\u00010\f2\b\u0010$\u001a\u0004\u0018\u00010\u0006\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/d;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "uinType", "", "uin", "Lcom/tencent/mobileqq/zplan/share/e;", "shareParam", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/graphics/Bitmap;", "thumb", "t", "subDirName", "Ljava/io/File;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "l", "shareChannel", tl.h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "k", "o", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", IProfileProtocolConst.PARAM_IS_FRIEND, "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "listener", "u", "showBackDialog", "v", "r", "path", "f", "", "shareExtraParams", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "d", "e", "Lcom/tencent/mobileqq/vas/transit/TransitPageConfig;", DownloadInfo.spKey_Config, "i", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f335534a = new d();

    d() {
    }

    private final void A(Activity activity, int uinType, String uin, ZPlanShareParam shareParam) {
        ZplanShareArkInfo zplanShareArkInfo = new ZplanShareArkInfo(shareParam.j());
        sd3.f fVar = sd3.f.f433689a;
        if (uin == null) {
            uin = "";
        }
        fVar.h(activity, zplanShareArkInfo, uinType, uin, "", false, shareParam.getRequestCode());
    }

    private final String h(Activity activity, int shareChannel, ZPlanShareLaunchParam launchParam) {
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        ZootopiaSource k3 = k(shareChannel, launchParam);
        Bundle bundle = new Bundle();
        bundle.putBoolean("openDetailNotReady", true);
        bundle.putBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, true);
        Unit unit = Unit.INSTANCE;
        return iSchemeApi.buildMapScheme(k3, AdMetricID.Click.SUCCESS, bundle);
    }

    private final ZootopiaSource k(int shareChannel, ZPlanShareLaunchParam launchParam) {
        if (launchParam.getShareType() != 1) {
            return launchParam.getSource();
        }
        if (shareChannel == 1) {
            return ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.H5, "em_zplan_entrance_qqspace_feed", null, 4, null);
        }
        if (shareChannel != 2) {
            return ZootopiaSource.INSTANCE.a(Source.H5);
        }
        return ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.H5, "em_zplan_entrance_xsj_share", null, 4, null);
    }

    private final File n(String subDirName) {
        File file = new File(BaseApplication.context.getCacheDir(), subDirName);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private final String o() {
        List listOf;
        String joinToString$default;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"template", "filter", QQWinkConstants.TAB_TEXT_STICKER, "sticker", QQWinkConstants.TAB_ENHANCE, QQWinkConstants.TAB_EFFECT, QQWinkConstants.TAB_CROP, QQWinkConstants.TAB_SUBTITLE});
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listOf, ",", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZPlanShareParam shareParam) {
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(BaseApplication.context, shareParam.getPath());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final ZPlanShareParam shareParam, final Activity activity, final String str, final int i3) {
        Intent intent;
        int roundToInt;
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        File file = new File(shareParam.getPath());
        if (file.exists()) {
            if (shareParam.getContentType() == 1) {
                intent = new Intent();
                intent.putExtra("forward_type", 21);
                intent.putExtra("file_send_path", shareParam.getPath());
                intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, shareParam.getPath());
                intent.putExtra(ShortVideoConstants.FILE_SEND_SIZE, file.length());
                intent.putExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5, HexUtil.bytes2HexStr(FileManagerUtil.getMd5(shareParam.getPath())));
                intent.putExtra("file_name", file.getName());
                roundToInt = MathKt__MathJVMKt.roundToInt(shareParam.getDuration() / 1000.0f);
                intent.putExtra(ShortVideoConstants.FILE_SEND_DURATION, roundToInt);
                intent.putExtra(ShortVideoConstants.FILE_WIDTH, shareParam.getWidth());
                intent.putExtra(ShortVideoConstants.FILE_HEIGHT, shareParam.getHeight());
                String thumbPath = shareParam.getThumbPath();
                if (!(thumbPath == null || thumbPath.length() == 0)) {
                    QLog.i("ZPlanSameStyle", 1, "video thumbnail exists: " + shareParam.getThumbPath());
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(shareParam.getThumbPath(), options);
                    if (options.outWidth > 0 && options.outHeight > 0) {
                        intent.putExtra(AppConstants.Key.FORWARD_THUMB, shareParam.getThumbPath());
                        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, shareParam.getThumbPath());
                        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, options.outWidth);
                        intent.putExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, options.outHeight);
                        intent.putExtra(ShortVideoConstants.THUMBFILE_MD5, HexUtil.bytes2HexStr(FileManagerUtil.getMd5(shareParam.getThumbPath())));
                    }
                }
            } else {
                intent = new Intent();
                intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
                intent.putExtra("forward_type", 1);
                intent.setData(Uri.parse(shareParam.getPath()));
            }
            final Intent intent2 = intent;
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.y(intent2, str, activity, shareParam, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(Intent intent, String str, Activity activity, ZPlanShareParam shareParam, int i3) {
        String str2;
        Intrinsics.checkNotNullParameter(intent, "$intent");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(shareParam, "$shareParam");
        intent.putExtra(ShortVideoConstants.FROM_UIN, BaseApplicationImpl.getApplication().getRuntime().getAccount());
        intent.putExtra(AppConstants.Key.FORWARD_NEED_SENDMSG, true);
        intent.putExtra("caller_name", activity.getClass().getSimpleName());
        intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_LEBA_MORE);
        intent.putExtra("forward_source_sub_business_type", "");
        intent.putExtra("key_allow_multiple_forward_from_limit", false);
        intent.putExtra("is_need_show_toast", false);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        boolean z16 = !(str == null || str.length() == 0);
        if (z16) {
            Bundle bundle = new Bundle();
            bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            bundle.putInt("key_direct_show_uin_type", i3);
            bundle.putString("key_direct_show_uin", str);
            intent.putExtras(bundle);
        }
        if (z16) {
            str2 = RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS;
        } else {
            str2 = RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT;
        }
        RouteUtils.startActivityForResult(activity, intent, str2, shareParam.getRequestCode());
    }

    public final void d(Activity activity, ZPlanShareParam shareParam, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        if (launchParam.getShareType() == 1) {
            Map<String, Object> j3 = shareParam.j();
            HashMap hashMap = j3 instanceof HashMap ? (HashMap) j3 : null;
            if (hashMap != null) {
                if (!hashMap.containsKey("taskid")) {
                    QLog.d("ZPlanSameStyle", 1, "appendParamsForLittleWorld, taskId");
                    hashMap.put("taskid", "zplan-0003");
                }
                if (!hashMap.containsKey("tag")) {
                    String encode = URLEncoder.encode(f335534a.l(activity, launchParam), "UTF-8");
                    QLog.d("ZPlanSameStyle", 1, "appendParamsForLittleWorld, tag:" + encode);
                    hashMap.put("tag", encode);
                }
                if (hashMap.containsKey("task_jump_url")) {
                    return;
                }
                String encode2 = URLEncoder.encode(j(f335534a, activity, 2, launchParam, null, 8, null), "UTF-8");
                QLog.d("ZPlanSameStyle", 1, "appendParamsForLittleWorld, url:" + encode2);
                hashMap.put("task_jump_url", encode2);
            }
        }
    }

    public final void e(Activity activity, ZPlanShareParam shareParam, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        if (launchParam.getShareType() == 1) {
            Map<String, Object> j3 = shareParam.j();
            HashMap hashMap = j3 instanceof HashMap ? (HashMap) j3 : null;
            if (hashMap != null) {
                if (!hashMap.containsKey(QZoneShareManager.QZONE_SHARE_HULIAN_APPID)) {
                    QLog.d("ZPlanSameStyle", 1, "appendParamsForQZone, appid");
                    hashMap.put(QZoneShareManager.QZONE_SHARE_HULIAN_APPID, "1000001");
                }
                if (hashMap.containsKey(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL)) {
                    return;
                }
                d dVar = f335534a;
                TransitPageConfig transitPageConfig = new TransitPageConfig();
                transitPageConfig.setUiStyle(1);
                Unit unit = Unit.INSTANCE;
                String i3 = dVar.i(activity, 1, launchParam, transitPageConfig);
                QLog.d("ZPlanSameStyle", 1, "appendParamsForQZone, url:" + i3);
                hashMap.put(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, i3);
            }
        }
    }

    public final ZPlanShareParam f(String path, ZPlanShareLaunchParam launchParam) {
        Map<String, Object> hashMap;
        Intrinsics.checkNotNullParameter(path, "path");
        boolean z16 = false;
        if (launchParam != null && launchParam.getContentType() == 3) {
            z16 = true;
        }
        int i3 = z16 ? 3 : 2;
        if (launchParam == null || (hashMap = launchParam.getShareExtraParams()) == null) {
            hashMap = new HashMap<>();
        }
        return new ZPlanShareParam(i3, path, 0, 0, 0, 0, "", null, null, null, hashMap, 896, null);
    }

    public final String p(ZPlanShareLaunchParam launchParam) {
        String optString;
        if (launchParam == null || launchParam.getShareType() != 1) {
            return null;
        }
        try {
            Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
            Object obj = bizExtraParams != null ? bizExtraParams.get(ZPlanShareLaunchParam.KEY_BIZ_SMALL_HOME_EXT) : null;
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                str = "";
            }
            optString = new JSONObject(str).optString("BackgroundUrl", "");
        } catch (Throwable th5) {
            QLog.e("ZPlanSameStyle", 1, "getSmallHomeBackgroundUrl err.", th5);
        }
        if (new File(optString).exists()) {
            return optString;
        }
        QLog.e("ZPlanSameStyle", 1, "background file not exists: " + optString);
        return null;
    }

    public final Bitmap q(String path) {
        if (path == null) {
            return null;
        }
        try {
            File file = new File(path);
            if (!file.exists()) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            return com.tencent.mobileqq.util.j.d(file.getAbsolutePath(), options);
        } catch (OutOfMemoryError e16) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ZPlanSameStyle", 2, "makeShareBitmap", e16);
            return null;
        } catch (Throwable th5) {
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("ZPlanSameStyle", 2, "makeShareBitmap", th5);
            return null;
        }
    }

    public final void r(final ZPlanShareParam shareParam) {
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.c
            @Override // java.lang.Runnable
            public final void run() {
                d.s(ZPlanShareParam.this);
            }
        });
    }

    public final void u(ZPlanShareParam shareParam, boolean isFriend, WXShareHelper.a listener) {
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        int i3 = !isFriend ? 1 : 0;
        if (listener != null) {
            WXShareHelper.b0().A(listener);
        }
        WXShareHelper.b0().u0(shareParam.getPath(), q(shareParam.getPath()), i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(Activity activity, ZPlanShareParam shareParam, boolean showBackDialog) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        String str = "mqqapi://qcircle/openqqpublish?mediaPath=" + shareParam.getPath() + "&target=3&exit_dialog=" + (showBackDialog ? 1 : 0);
        Map<String, Object> j3 = shareParam.j();
        if (j3 != null && (r0 = j3.entrySet().iterator()) != null) {
            for (Map.Entry<String, Object> entry : j3.entrySet()) {
                String key = entry.getKey();
                str = ((Object) str) + ContainerUtils.FIELD_DELIMITER + ((Object) key) + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
            }
        }
        Map<String, Object> j16 = shareParam.j();
        boolean z16 = false;
        if ((j16 != null && j16.containsKey("taskid")) == false) {
            str = ((Object) str) + "&taskid=zplan-default";
        }
        Map<String, Object> j17 = shareParam.j();
        if (j17 != null && j17.containsKey("tag")) {
            z16 = true;
        }
        if (!z16) {
            str = ((Object) str) + "&tag=" + URLEncoder.encode(activity.getString(R.string.xhs), "utf-8");
        }
        String str2 = ((Object) str) + "&editor_toolbar_item=" + o();
        QLog.i("ZPlanSameStyle", 1, "shareToLittleWorld schemeUrl:" + ((Object) str2));
        QCircleSchemeLauncher.d(activity, str2);
    }

    public final void w(final Activity activity, final int uinType, final String uin, final ZPlanShareParam shareParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        if (shareParam.n()) {
            A(activity, uinType, uin, shareParam);
        } else {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.share.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.x(ZPlanShareParam.this, activity, uin, uinType);
                }
            });
        }
    }

    public final void z(Activity activity, ZPlanShareParam shareParam) {
        ArrayList<String> arrayListOf;
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(shareParam, "shareParam");
        if (shareParam.getContentType() == 0) {
            Bundle bundle = new Bundle();
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(shareParam.getPath());
            bundle.putStringArrayList("images", arrayListOf);
            Map<String, Object> j3 = shareParam.j();
            if (j3 != null && (r1 = j3.entrySet().iterator()) != null) {
                for (Map.Entry<String, Object> entry : j3.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (value == null || (str = value.toString()) == null) {
                        str = "";
                    }
                    bundle.putString(key, str);
                }
            }
            QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
            AppRuntime appRuntime = qBaseActivity != null ? qBaseActivity.getAppRuntime() : null;
            AppInterface appInterface = appRuntime instanceof AppInterface ? (AppInterface) appRuntime : null;
            if (appInterface == null) {
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                appInterface = (AppInterface) waitAppRuntime;
            }
            QZoneShareManager.publishToQzone(appInterface, activity, bundle, null, shareParam.getRequestCode());
            return;
        }
        if (shareParam.getContentType() == 1) {
            QZoneHelper.forwardToPublishMood(activity, QZoneHelper.UserInfo.getInstance(), shareParam.getPath(), shareParam.getRequestCode());
        }
    }

    public final ZPlanShareParam g(String path, Map<String, ? extends Object> shareExtraParams) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            i3 = options.outWidth;
            try {
                i17 = i3;
                i16 = options.outHeight;
            } catch (Exception e16) {
                e = e16;
                QLog.e("ZPlanSameStyle", 1, e, new Object[0]);
                int i18 = i3;
                i16 = 0;
                i17 = i18;
                if (i17 <= 0) {
                }
                QLog.e("ZPlanSameStyle", 1, "decode image failed, width = " + i17 + ", height = " + i16);
                return null;
            }
        } catch (Exception e17) {
            e = e17;
            i3 = 0;
        }
        if (i17 <= 0 && i16 > 0) {
            return new ZPlanShareParam(0, path, i17, i16, 0, 0, null, null, null, null, shareExtraParams == null ? new HashMap() : shareExtraParams, 928, null);
        }
        QLog.e("ZPlanSameStyle", 1, "decode image failed, width = " + i17 + ", height = " + i16);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0096 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ZPlanShareParam m(String path, Map<String, ? extends Object> shareExtraParams) {
        int i3;
        int i16;
        int i17;
        Bitmap bitmap;
        int i18;
        MediaMetadataRetriever mediaMetadataRetriever;
        Intrinsics.checkNotNullParameter(path, "path");
        QLog.i("ZPlanSameStyle", 1, "start share video: " + path);
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(path);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
            Intrinsics.checkNotNull(extractMetadata);
            i3 = Integer.parseInt(extractMetadata);
            try {
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                Intrinsics.checkNotNull(extractMetadata2);
                i16 = Integer.parseInt(extractMetadata2);
                try {
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                    Intrinsics.checkNotNull(extractMetadata3);
                    i17 = Integer.parseInt(extractMetadata3);
                } catch (Exception e16) {
                    e = e16;
                    i17 = 0;
                }
            } catch (Exception e17) {
                e = e17;
                i16 = 0;
                i17 = i16;
                bitmap = null;
                QLog.e("ZPlanSameStyle", 1, e, new Object[0]);
                i18 = i3;
                int i19 = i17;
                if (i18 > 0) {
                }
                return null;
            }
        } catch (Exception e18) {
            e = e18;
            i3 = 0;
            i16 = 0;
        }
        try {
            bitmap = mediaMetadataRetriever.getFrameAtTime();
            try {
                QLog.i("ZPlanSameStyle", 1, "parse video info: width = " + i3 + ", height = " + i16 + ", duration = " + i17);
            } catch (Exception e19) {
                e = e19;
                QLog.e("ZPlanSameStyle", 1, e, new Object[0]);
                i18 = i3;
                int i192 = i17;
                if (i18 > 0) {
                }
                return null;
            }
        } catch (Exception e26) {
            e = e26;
            bitmap = null;
            QLog.e("ZPlanSameStyle", 1, e, new Object[0]);
            i18 = i3;
            int i1922 = i17;
            if (i18 > 0) {
            }
            return null;
        }
        i18 = i3;
        int i19222 = i17;
        if (i18 > 0 || i16 <= 0 || i19222 <= 0) {
            return null;
        }
        return new ZPlanShareParam(1, path, i18, i16, i19222, 0, t(bitmap), null, null, null, shareExtraParams == null ? new HashMap() : shareExtraParams, 928, null);
    }

    private final String l(Activity activity, ZPlanShareLaunchParam launchParam) {
        String string = activity.getString(R.string.xht);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026rld_share_tag_small_home)");
        try {
            Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
            Object obj = bizExtraParams != null ? bizExtraParams.get(ZPlanShareLaunchParam.KEY_BIZ_SMALL_HOME_EXT) : null;
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                str = "";
            }
            String optString = new JSONObject(str).optString("Tag");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"Tag\")");
            return optString.length() == 0 ? string : optString;
        } catch (JSONException e16) {
            QLog.e("ZPlanSameStyle", 1, "buildSmallHomeTag err.", e16);
            return string;
        }
    }

    private final String t(Bitmap thumb) {
        if (thumb == null) {
            return null;
        }
        File file = new File(n("cmshow/share/thumbnail"), "video_thumb_" + System.currentTimeMillis() + ".png");
        if (file.exists()) {
            file.delete();
        }
        QLog.i("ZPlanSameStyle", 1, "thumbnail name = " + file.getAbsolutePath());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            thumb.compress(Bitmap.CompressFormat.PNG, 50, fileOutputStream);
            CloseableKt.closeFinally(fileOutputStream, null);
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            return null;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(fileOutputStream, th5);
                throw th6;
            }
        }
    }

    public static /* synthetic */ String j(d dVar, Activity activity, int i3, ZPlanShareLaunchParam zPlanShareLaunchParam, TransitPageConfig transitPageConfig, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            transitPageConfig = null;
        }
        return dVar.i(activity, i3, zPlanShareLaunchParam, transitPageConfig);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059 A[Catch: JSONException -> 0x00e6, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00e6, blocks: (B:3:0x0015, B:5:0x001c, B:6:0x0025, B:8:0x0029, B:11:0x0031, B:13:0x004d, B:18:0x0059, B:21:0x0070, B:24:0x00a6, B:26:0x00c1, B:27:0x00ca), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[Catch: JSONException -> 0x00e6, TRY_ENTER, TryCatch #0 {JSONException -> 0x00e6, blocks: (B:3:0x0015, B:5:0x001c, B:6:0x0025, B:8:0x0029, B:11:0x0031, B:13:0x004d, B:18:0x0059, B:21:0x0070, B:24:0x00a6, B:26:0x00c1, B:27:0x00ca), top: B:2:0x0015 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6 A[Catch: JSONException -> 0x00e6, TryCatch #0 {JSONException -> 0x00e6, blocks: (B:3:0x0015, B:5:0x001c, B:6:0x0025, B:8:0x0029, B:11:0x0031, B:13:0x004d, B:18:0x0059, B:21:0x0070, B:24:0x00a6, B:26:0x00c1, B:27:0x00ca), top: B:2:0x0015 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String i(Activity activity, int shareChannel, ZPlanShareLaunchParam launchParam, TransitPageConfig config) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        try {
            Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
            Object obj = bizExtraParams != null ? bizExtraParams.get(ZPlanShareLaunchParam.KEY_BIZ_SMALL_HOME_EXT) : null;
            String str = obj instanceof String ? (String) obj : null;
            if (str == null) {
                str = "";
            }
            JSONObject jSONObject = new JSONObject(str);
            boolean equals = TextUtils.equals("1", jSONObject.optString("IsPublicArea"));
            String optString = jSONObject.optString("Uin");
            if (optString != null && optString.length() != 0) {
                z16 = false;
                if (z16) {
                    optString = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
                }
                if (!equals) {
                    ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                    ZootopiaSource k3 = k(shareChannel, launchParam);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("openDetailNotReady", true);
                    bundle.putBoolean(FavEmoConstant.ROAMING_TYPE_PANEL, true);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("ExtContent", str);
                    bundle2.putString("SceneType", "5");
                    Unit unit = Unit.INSTANCE;
                    bundle.putBundle("ueParams", bundle2);
                    return iSchemeApi.buildMapScheme(k3, AdMetricID.Click.SUCCESS, bundle);
                }
                ISchemeApi iSchemeApi2 = (ISchemeApi) QRoute.api(ISchemeApi.class);
                ZootopiaSource k16 = k(shareChannel, launchParam);
                MasterInfo masterInfo = new MasterInfo();
                masterInfo.setUin(optString);
                Unit unit2 = Unit.INSTANCE;
                TransitPageInfo transitPageInfo = new TransitPageInfo(masterInfo, new VisitorInfo(), config == null ? new TransitPageConfig() : config, null, 8, null);
                Bundle bundle3 = new Bundle();
                bundle3.putString("ExtContent", str);
                bundle3.putString("SceneType", "5");
                return iSchemeApi2.buildTransitPageScheme(k16, transitPageInfo, bundle3);
            }
            z16 = true;
            if (z16) {
            }
            if (!equals) {
            }
        } catch (JSONException e16) {
            QLog.e("ZPlanSameStyle", 1, "buildSmallHomeTag err.", e16);
            return h(activity, shareChannel, launchParam);
        }
    }
}
