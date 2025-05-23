package com.qzone.feed.utils;

import NS_MOBILE_OPERATION.PhotoInformation;
import NS_MOBILE_OPERATION.PicInfo;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.fragment.app.Fragment;
import com.qq.taf.jce.JceOutputStream;
import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.FeedActionPanelActivity;
import com.qzone.common.activities.base.ch;
import com.qzone.common.activities.base.k;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.feed.utils.e;
import com.qzone.misc.web.QZoneTranslucentActivity2;
import com.qzone.preview.BasePictureViewer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelParams;
import com.qzone.util.ToastUtil;
import com.qzone.util.am;
import com.qzone.util.image.NetImageInfo;
import com.qzone.util.l;
import com.qzone.widget.EditPositionBag;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.sharpP.SharpPUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.Lbs.QzoneLbsConstant;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MediaUtil;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZonePermission;
import d5.n;
import ho.i;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import n5.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneFeedUtil {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static HashMap<String, BusinessFeedData> f47421a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f47422b = false;

    /* renamed from: c, reason: collision with root package name */
    public static int f47423c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f47424d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static Handler f47425e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f47426f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                ToastUtil.o(R.string.gkh, 4);
                return;
            }
            if (i3 != 2) {
                if (i3 != 3) {
                    return;
                }
                ToastUtil.o(R.string.gkk, 4);
                return;
            }
            if (!QZoneFeedUtil.f47426f) {
                Object obj = message.obj;
                if (obj != null && (obj instanceof String)) {
                    File file = new File((String) obj);
                    if (file.exists()) {
                        MediaUtil.scanFile(BaseApplication.getContext(), file);
                    }
                }
                ToastUtil.o(R.string.gki, 5);
                return;
            }
            Object obj2 = message.obj;
            if (obj2 == null || !(obj2 instanceof String)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(QzoneIPCModule.PIC_PATH, (String) obj2);
            int i16 = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_SAVE_CUSTOMEMOTION, bundle).data.getInt(QzoneIPCModule.RESULT_CODE);
            if (i16 != 0) {
                if (i16 == 2) {
                    ToastUtil.o(R.string.f170070f0, 4);
                } else {
                    ToastUtil.o(R.string.cwa, 4);
                }
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneFeedUtil", "resultcode:" + i16);
            }
        }
    }

    public static String A(BusinessFeedData businessFeedData) {
        int x16 = x(businessFeedData);
        if (w(businessFeedData) || x16 == 3) {
            return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_MEDIA_FILE_DIALOG_ONLY_VIDEO_MSG, QzoneConfig.DEFAULT_DEL_MEDIA_FILE_DIALOG_ONLY_VIDEO_MSG);
        }
        if (x16 == 2) {
            return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_MEDIA_FILE_DIALOG_ONLY_PIC_MSG, QzoneConfig.DEFAULT_DEL_MEDIA_FILE_DIALOG_ONLY_PIC_MSG);
        }
        if (x16 == 1) {
            return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_MEDIA_FILE_DIALOG_MIX_VIDEO_PIC_MSG, QzoneConfig.DEFAULT_DEL_MEDIA_FILE_DIALOG_MIX_VIDEO_PIC_MSG);
        }
        return "";
    }

    public static String C(BusinessFeedData businessFeedData, boolean z16) {
        return (businessFeedData == null || z16) ? BaseApplication.getContext().getString(R.string.gdo) : B(businessFeedData);
    }

    public static String E(PictureItem pictureItem) {
        String str;
        if (pictureItem == null) {
            QZLog.w("QZoneFeedUtil", "---getDowndloadUrlForGif:photoInfo is null.");
            return "";
        }
        if (!TextUtils.isEmpty(pictureItem.originUrl.url)) {
            str = pictureItem.originUrl.url;
        } else if (!TextUtils.isEmpty(pictureItem.bigUrl.url)) {
            str = pictureItem.bigUrl.url;
        } else {
            str = pictureItem.currentUrl.url;
        }
        if (!TextUtils.isEmpty(str) && SharpPUtils.isSharpP(str)) {
            File imageFile = ImageLoader.getInstance().getImageFile(str);
            if (imageFile == null || SharpPUtils.isSharpP(imageFile)) {
                str = str.replace("&t=6", "").replace("t=6", "").replace("ek=1", "sharpp=1&ek=1");
                if (QZLog.isColorLevel()) {
                    QZLog.w("QZoneFeedUtil", "---getDowndloadUrlForGif--downloadUrl:" + str);
                }
            }
        } else {
            QZLog.w("QZoneFeedUtil", "---getDowndloadUrlForGif:url is empty.");
        }
        return str;
    }

    public static Intent F(Context context, e.a aVar, Serializable serializable, Parcelable parcelable, EditPositionBag editPositionBag, boolean z16, int i3) {
        e.a a16 = e.a.a(aVar);
        a16.f47473f = false;
        return G(context, a16, serializable, parcelable, editPositionBag, z16, i3, null, false, FeedActionPanelActivity.L1);
    }

    public static Intent H(Context context, e.a aVar, Serializable serializable, Parcelable parcelable, EditPositionBag editPositionBag, boolean z16, int i3, String str, boolean z17, int i16, Map<String, Object> map) {
        Object obj;
        w5.b.a("QZoneFeedUtil", 2, aVar.toString() + ", useRapidComment = " + z16 + ", refer = " + i3 + ", feedsKey = " + str + ", enableQuickComment = " + z17 + ", showPicComment = " + i16);
        Intent intent = new Intent(context, (Class<?>) FeedActionPanelActivity.class);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.AUTOSAVE_STORAGE_KEY, aVar.f47477j);
        intent.putExtra("extraRequestCode", aVar.f47476i);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_KEY_ICON, aVar.f47475h);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SHOW_PICCOMMENT, i16);
        intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.SHOW_FONT_ICON, aVar.f47472e);
        intent.putExtra("show_barrage_effect_icon", aVar.f47473f);
        intent.putExtra("refer", i3);
        intent.putExtra("enable_quick_comment_recommend", z17);
        intent.putExtra("action_show_font_gif", aVar.f47482o);
        intent.putExtra("extra_sqDynamicFeedsKey", aVar.f47484q);
        intent.putExtra("extra_cell_operation_busiparam", V(aVar.f47483p));
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("cache_feedkey", str);
        }
        String str2 = aVar.f47470c;
        if (str2 != null) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_COMMENT_ID, str2);
        }
        String str3 = aVar.f47471d;
        if (str3 != null) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_REPLY_ID, str3);
        }
        if (serializable != null) {
            intent.putExtra("extraIntentKey", serializable);
        }
        String str4 = aVar.f47469b;
        if (str4 != null) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_AUTOFILL_INTENT_KEY, str4);
        }
        if (parcelable != null && M(parcelable)) {
            Object data = parcelable instanceof ParcelableWrapper ? ((ParcelableWrapper) parcelable).getData() : parcelable;
            if (data instanceof BusinessFeedData) {
                BusinessFeedData businessFeedData = (BusinessFeedData) data;
                intent.putExtra("extra_key_cur_like_key", businessFeedData.getFeedCommInfo().curlikekey);
                intent.putExtra("extra_key_ugc_key", businessFeedData.getFeedCommInfo().ugckey);
                intent.putExtra("extra_key_is_op_comment_poke_like", businessFeedData.isCommentPokeLike());
                if (QZoneApiProxy.isInQZoneEnvironment()) {
                    intent.putExtra("cache_feeddata", "open_action_panel_ahare_to_qzone_key");
                    f47421a.put("open_action_panel_ahare_to_qzone_key", businessFeedData);
                } else if (N()) {
                    intent.putExtra("extraIntentKeyParcelable", parcelable);
                }
            }
        } else {
            intent.putExtra("extraIntentKeyParcelable", parcelable);
            if (map != null) {
                String str5 = (String) map.get("extra_key_cur_like_key");
                if (!TextUtils.isEmpty(str5)) {
                    intent.putExtra("extra_key_cur_like_key", str5);
                }
                String str6 = (String) map.get("extra_key_ugc_key");
                if (!TextUtils.isEmpty(str6)) {
                    intent.putExtra("extra_key_ugc_key", str6);
                }
                Object obj2 = map.get("extra_key_is_op_comment_poke_like");
                if (obj2 != null) {
                    intent.putExtra("extra_key_is_op_comment_poke_like", (Boolean) obj2);
                }
            }
        }
        String str7 = aVar.f47468a;
        int i17 = aVar.f47476i;
        if (1206 == i17 || 1205 == i17) {
            if (str7 == null) {
                str7 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ForwardReason", "\u8f6c\u53d1\u5230QQ\u7a7a\u95f4");
            }
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_IS_SHARE, true);
        }
        if (str7 != null) {
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.FEED_TEXT_HINT_INTENT_KEY, str7);
        }
        if (editPositionBag != null) {
            intent.putExtra(QZoneHelper.Constants.KEY_DETAIL_EPBAG, editPositionBag.j());
            if (!QZoneApiProxy.isInQZoneEnvironment()) {
                intent.putExtra("exoticPositionBagKey", editPositionBag.j());
            }
        }
        intent.putExtra("extrauserapidcomment", z16);
        intent.putExtra("show_favorites_emoticon", aVar.f47481n);
        intent.putExtra("show_sharepanel", j(y(parcelable), aVar.f47476i));
        if (map != null && (obj = map.get("action_area_open_from")) != null && (obj instanceof Integer)) {
            intent.putExtra("action_area_open_from", (Integer) obj);
        }
        return intent;
    }

    public static Intent I(Context context, e.a aVar, Serializable serializable, Parcelable parcelable, EditPositionBag editPositionBag, boolean z16, int i3, Map<String, Object> map) {
        e.a a16 = e.a.a(aVar);
        a16.f47473f = false;
        return H(context, a16, serializable, parcelable, editPositionBag, z16, i3, null, false, FeedActionPanelActivity.L1, map);
    }

    public static int K(int i3) {
        if (i3 != 311 && i3 != 6100) {
            return 1205;
        }
        return 1206;
    }

    public static String L(String str) {
        if (TextUtils.isEmpty(str)) {
            return "null";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
            return "null";
        }
    }

    public static boolean M(Parcelable parcelable) {
        boolean z16 = parcelable instanceof ParcelableWrapper;
        Object obj = parcelable;
        if (z16) {
            obj = ((ParcelableWrapper) parcelable).getData();
        }
        return obj instanceof BusinessFeedData;
    }

    public static boolean N() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_EXPLICIT_OUT_SHARE_ENABLE, 1) == 1;
    }

    public static boolean P() {
        long K = u5.b.K("key_memory_seal_bar_last_close_time", 0L, LoginData.getInstance().getUin());
        return K != 0 && (System.currentTimeMillis() - K) / 86400000 < 30;
    }

    public static boolean Q() {
        long K = u5.b.K("KEY_PRIVATE_SPACE_BAR_LAST_CLOSE_TIME", 0L, LoginData.getInstance().getUin());
        return K != 0 && (System.currentTimeMillis() - K) / 86400000 < 30;
    }

    public static boolean R(BusinessFeedData businessFeedData) {
        return false;
    }

    public static boolean S() {
        if (f47423c == -1) {
            f47423c = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin());
        }
        return (f47423c & 256) != 0;
    }

    public static boolean T() {
        return true;
    }

    public static byte[] V(Map<Integer, String> map) {
        JceOutputStream jceOutputStream = new JceOutputStream();
        jceOutputStream.write((Map) map, 1);
        return jceOutputStream.toByteArray();
    }

    public static void W(BusinessFeedData businessFeedData, int i3, e eVar) {
        LpReportInfo_dc00321.report(15, i3, 1, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
        if (m(businessFeedData)) {
            a0(businessFeedData, eVar);
        } else if (eVar instanceof QZoneTranslucentActivity2) {
            ((QZoneTranslucentActivity2) eVar).finish();
        }
    }

    public static void a0(BusinessFeedData businessFeedData, e eVar) {
        Pair<CellPictureInfo, Boolean> m3;
        Object obj;
        String config = businessFeedData.isRegisterAnniversaryFeed() ? QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "AniversayFeedShareReason", "\u5206\u4eab\u7406\u7531") : null;
        int i3 = businessFeedData.getFeedCommInfo().appid;
        f47422b = true;
        f47421a.put("current_forward_key", businessFeedData);
        f47421a.put("open_action_panel_ahare_to_qzone_key", businessFeedData);
        e.a aVar = new e.a();
        aVar.f47468a = config;
        aVar.f47469b = "";
        aVar.f47470c = null;
        aVar.f47471d = null;
        aVar.f47472e = 0;
        aVar.f47473f = false;
        aVar.f47475h = FeedActionPanelActivity.I1;
        aVar.f47478k = false;
        aVar.f47480m = false;
        if (i3 != 311 && i3 != 6100) {
            if (i3 == 4 && (obj = (m3 = com.qzone.proxy.feedcomponent.util.d.m(businessFeedData)).first) != null && ((CellPictureInfo) obj).pics != null && !((CellPictureInfo) obj).pics.isEmpty()) {
                String str = ((CellPictureInfo) m3.first).pics.get(0).lloc;
            }
            if (!QZoneApiProxy.isInQZoneEnvironment()) {
                f47421a.put("activity_result_ahare_to_qzone_key", businessFeedData);
            }
            boolean l3 = l(businessFeedData, 17);
            aVar.f47476i = 1205;
            aVar.f47477j = businessFeedData.getFeedCommInfo().ugckey;
            aVar.f47481n = l3;
            eVar.x0(aVar, 0, ParcelableWrapper.obtain(businessFeedData), null);
            return;
        }
        boolean l16 = l(businessFeedData, 17);
        aVar.f47476i = 1206;
        aVar.f47477j = null;
        aVar.f47481n = l16;
        if (!N()) {
            businessFeedData = new BusinessFeedData();
        }
        eVar.x0(aVar, 0, ParcelableWrapper.obtain(businessFeedData), null);
    }

    public static void b0(Context context, String str, int i3, int i16) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.QZONE_UGC_PERMISSION_USERS_LIST_URL, "https://h5.qzone.qq.com/auth/list/{ugcid}/authlist?uin={uin}&appid={appid}&platform={platform}&type={type}&_wv=1027&_proxy=1");
        if (TextUtils.isEmpty(config)) {
            return;
        }
        yo.d.d(yo.f.i(yo.f.i(yo.f.i(yo.f.w(yo.f.j(config, "{ugcid}", str), LoginData.getInstance().getUin()), "{appid}", i16), "{type}", i3 == 16 ? 0 : 1), "{platform}", 0L), context, null);
    }

    public static String c(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null) {
            return "";
        }
        if (i3 != 4) {
            if (i3 != 202) {
                return "";
            }
            return businessFeedData.getIdInfo().cellId;
        }
        if (businessFeedData.getVideoInfo() != null) {
            return businessFeedData.getOperationInfoV2().busiParam.get(12);
        }
        if (businessFeedData.getPictureInfo() != null) {
            if (businessFeedData.getPictureInfo().pics.size() == 1) {
                return businessFeedData.getPictureInfo().albumid;
            }
            return businessFeedData.getPictureInfo().albumid + ":" + businessFeedData.getIdInfo().subId;
        }
        if (businessFeedData.getOriginalInfo() == null) {
            return "";
        }
        return c(businessFeedData.getOriginalInfo(), i3);
    }

    public static boolean d() {
        if (f47423c == -1) {
            f47423c = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, LoginData.getInstance().getUin());
            w5.b.i("QZoneFeedUtil", 1, "[polyPraise] canAutoShowPolyPraise, grayOperateMask = " + f47423c);
        }
        boolean z16 = (f47423c & 16) != 0;
        w5.b.a("QZoneFeedUtil", 2, "[polyPraise] canAutoShowPolyPraise, grayOperateMask: " + f47423c + ", result = " + z16);
        return z16;
    }

    public static void j0(long j3) {
        u5.b.u0("key_memory_seal_bar_last_close_time", j3, LoginData.getInstance().getUin());
    }

    public static void k0(long j3) {
        u5.b.u0("KEY_PRIVATE_SPACE_BAR_LAST_CLOSE_TIME", j3, LoginData.getInstance().getUin());
    }

    public static boolean m(BusinessFeedData businessFeedData) {
        int i3 = businessFeedData.getFeedCommInfo().appid;
        int i16 = businessFeedData.getFeedCommInfo().ugcRight;
        if (QZLog.isColorLevel()) {
            QZLog.d("share", 2, "share qzone, appid=" + i3 + ", ugcRight=" + i16);
        }
        boolean z16 = k(businessFeedData, 2) || (businessFeedData.getCellCanvas() != null) || QZoneAdFeedDataExtKt.isNativeAd(businessFeedData);
        boolean k3 = k(businessFeedData, 1);
        if (businessFeedData.getVideoInfo() != null && (businessFeedData.getVideoInfo().videoStatus == 7 || businessFeedData.getVideoInfo().videoStatus == 4)) {
            if (businessFeedData.getPermissionInfoV2() != null && !am.h(businessFeedData.getPermissionInfoV2().permission_tips)) {
                ToastUtil.s(businessFeedData.getPermissionInfoV2().permission_tips, 4);
            } else {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNotForwad", "\u6682\u4e0d\u53ef\u8f6c\u53d1"), 4);
            }
            AccManager.reportForward(AccManager.RESULT_CODE_FORWARD_REPORT);
            return false;
        }
        if ((O(businessFeedData) && i16 != 1 && i3 == 311) || (!z16 && !k3)) {
            String str = businessFeedData.getPermissionInfo().permission_tips;
            if (TextUtils.isEmpty(str)) {
                int i17 = businessFeedData.getFeedCommInfo().operatemask;
                if (businessFeedData.isDeleteOnTimeFeed()) {
                    str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastWillBeDeletedNotForward", "\u8be5\u5185\u5bb9\u4e3a\u5b9a\u65f6\u5220\u9664\u5185\u5bb9\uff0c\u65e0\u6cd5\u8f6c\u53d1");
                } else {
                    str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastContentForwardDisable", "\u6b64\u7c7b\u578b\u6682\u65f6\u4e0d\u652f\u6301\u8f6c\u53d1");
                }
            }
            ToastUtil.s(str, 4);
            AccManager.reportForward(AccManager.RESULT_CODE_FORWARD_REPORT);
            return false;
        }
        if (NetworkState.isNetSupport()) {
            return true;
        }
        ToastUtil.n(R.string.ghi);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x024d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void t(BusinessFeedData businessFeedData, String str, int i3, String str2, String str3, Handler handler, boolean z16, int i16, boolean z17, boolean z18) {
        ArrayList<String> arrayList;
        String str4;
        ArrayList<String> arrayList2;
        ArrayList<String> arrayList3;
        CellPictureInfo cellPictureInfo;
        String str5;
        int i17;
        int i18;
        Map<String, String> map;
        String str6;
        String str7;
        String str8;
        String str9;
        if (businessFeedData == null) {
            return;
        }
        int i19 = businessFeedData.getFeedCommInfo().appid;
        if (businessFeedData.getOperationInfo().busiParam == null) {
            businessFeedData.getOperationInfo().busiParam = new HashMap();
        }
        String str10 = businessFeedData.getOperationInfo().busiParam.get(4);
        if (i19 != 4 && i19 != 202) {
            String str11 = businessFeedData.getIdInfo().cellId;
            if (businessFeedData.getPictureInfo() == null || businessFeedData.getPictureInfo().pics == null || businessFeedData.getPictureInfo().pics.size() <= 0) {
                str4 = str11;
                arrayList2 = null;
                arrayList3 = null;
            } else {
                ArrayList<String> arrayList4 = new ArrayList<>();
                int size = businessFeedData.getPictureInfo().pics.size();
                for (int i26 = 0; i26 < size; i26++) {
                    if (businessFeedData.getPictureInfo().pics.get(i26).bigUrl.url != null) {
                        arrayList4.add(businessFeedData.getPictureInfo().pics.get(i26).bigUrl.url);
                    }
                }
                str4 = str11;
                arrayList3 = null;
                arrayList2 = arrayList4;
            }
        } else {
            String c16 = c(businessFeedData, i19);
            if (i3 == 2 || (cellPictureInfo = (CellPictureInfo) com.qzone.proxy.feedcomponent.util.d.m(businessFeedData).first) == null || cellPictureInfo.pics.get(0) == null || cellPictureInfo.pics.get(0).lloc == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(cellPictureInfo.pics.get(0).lloc);
            }
            str4 = c16;
            arrayList2 = null;
            arrayList3 = arrayList;
        }
        String str12 = businessFeedData.getCellSummary().summary == null ? "" : businessFeedData.getCellSummary().summary;
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "MobileBlog", "\u624b\u673a\u65e5\u5fd7");
        if (businessFeedData.isRegisterAnniversaryFeed()) {
            com.qzone.publish.ui.model.c cVar = new com.qzone.publish.ui.model.c();
            cVar.f51959u = 1;
            cVar.f51956r = 0;
            cVar.I = "shuoshuoOther";
            cVar.H = 23;
            cVar.f51934b = str;
            HashMap hashMap = new HashMap();
            cVar.f51954p = hashMap;
            hashMap.put("video_uploaded", "1");
            cVar.f51954p.put("content_cache_key", TextUtils.isEmpty(str3) ? "content_cache_key_default_value" : str3);
            cVar.f51954p.put("has_video", "1");
            cVar.f51954p.put("all_upload_done", "1");
            cVar.f51954p.put("shuoshuo_priv", "1");
            cVar.f51954p.put("is_reg_anniversary", "1");
            CellGuiding cellGuiding = businessFeedData.getCellGuiding();
            if (cellGuiding != null) {
                map = cellGuiding.extendInfo;
                if (map != null) {
                    r2 = map.get("video_vid");
                    str6 = map.get("video_url");
                    str7 = map.get("video_cover_url");
                    str8 = map.get("video_duration");
                    str9 = map.get("video_size");
                    try {
                        i17 = Integer.parseInt(map.get("video_cover_width"));
                    } catch (Exception unused) {
                        i17 = 0;
                    }
                    try {
                        i18 = Integer.parseInt(map.get("video_cover_height"));
                    } catch (Exception unused2) {
                        i18 = 0;
                        if (!TextUtils.isEmpty(r2)) {
                        }
                        QZLog.e("QZoneFeedUtil", "Publish RegisterAnniversaryFeed params error!!" + map);
                        PicInfo picInfo = new PicInfo();
                        picInfo.ishd = true;
                        picInfo.hdwidth = i17;
                        picInfo.hdheight = i18;
                        picInfo.pic_url = str7;
                        picInfo.picwidth = i17;
                        picInfo.picheight = i18;
                        picInfo.video_id = r2;
                        HashMap hashMap2 = new HashMap();
                        picInfo.mapWaterMarkParams = hashMap2;
                        hashMap2.put("mix_subtype", "2");
                        picInfo.mapWaterMarkParams.put("mix_pub_route", "1");
                        picInfo.mapWaterMarkParams.put(FSUploadConst.KEY_CLIENT_UPLOOAD_COVER, "1");
                        picInfo.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_FEED, "1");
                        picInfo.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_ORIGIN_VIDEO, "0");
                        picInfo.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_TIME, str8);
                        if (!TextUtils.isEmpty(str9)) {
                        }
                        picInfo.mapWaterMarkParams.put("mix_who", "6");
                        picInfo.mapWaterMarkParams.put("mix_playurl", str6);
                        cVar.N = picInfo;
                        cVar.W = false;
                        QZoneWriteOperationService.v0().O1(cVar);
                        LpReportInfo_pf00064.allReport(109, 3, 1);
                        if (businessFeedData.getFeedCommInfo().isFamousRecommAdvFeed()) {
                        }
                        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(22, 1, 17);
                        lpReportInfo_pf00064.info = businessFeedData.getFeedCommInfo().feedskey + "_" + businessFeedData.getFeedCommInfo().getTime();
                        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064);
                    }
                    if (!TextUtils.isEmpty(r2) || TextUtils.isEmpty(str6) || TextUtils.isEmpty(str7) || TextUtils.isEmpty(str8) || (i17 <= 0 && i18 <= 0)) {
                        QZLog.e("QZoneFeedUtil", "Publish RegisterAnniversaryFeed params error!!" + map);
                    }
                    PicInfo picInfo2 = new PicInfo();
                    picInfo2.ishd = true;
                    picInfo2.hdwidth = i17;
                    picInfo2.hdheight = i18;
                    picInfo2.pic_url = str7;
                    picInfo2.picwidth = i17;
                    picInfo2.picheight = i18;
                    picInfo2.video_id = r2;
                    HashMap hashMap22 = new HashMap();
                    picInfo2.mapWaterMarkParams = hashMap22;
                    hashMap22.put("mix_subtype", "2");
                    picInfo2.mapWaterMarkParams.put("mix_pub_route", "1");
                    picInfo2.mapWaterMarkParams.put(FSUploadConst.KEY_CLIENT_UPLOOAD_COVER, "1");
                    picInfo2.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_FEED, "1");
                    picInfo2.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_ORIGIN_VIDEO, "0");
                    picInfo2.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_TIME, str8);
                    if (!TextUtils.isEmpty(str9)) {
                        picInfo2.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_VIDEO_SIZE, str9);
                    }
                    picInfo2.mapWaterMarkParams.put("mix_who", "6");
                    picInfo2.mapWaterMarkParams.put("mix_playurl", str6);
                    cVar.N = picInfo2;
                    cVar.W = false;
                    QZoneWriteOperationService.v0().O1(cVar);
                    LpReportInfo_pf00064.allReport(109, 3, 1);
                } else {
                    i17 = 0;
                    i18 = 0;
                    str6 = null;
                }
            } else {
                i17 = 0;
                i18 = 0;
                map = null;
                str6 = null;
            }
            str7 = str6;
            str8 = str7;
            str9 = str8;
            if (!TextUtils.isEmpty(r2)) {
            }
            QZLog.e("QZoneFeedUtil", "Publish RegisterAnniversaryFeed params error!!" + map);
            PicInfo picInfo22 = new PicInfo();
            picInfo22.ishd = true;
            picInfo22.hdwidth = i17;
            picInfo22.hdheight = i18;
            picInfo22.pic_url = str7;
            picInfo22.picwidth = i17;
            picInfo22.picheight = i18;
            picInfo22.video_id = r2;
            HashMap hashMap222 = new HashMap();
            picInfo22.mapWaterMarkParams = hashMap222;
            hashMap222.put("mix_subtype", "2");
            picInfo22.mapWaterMarkParams.put("mix_pub_route", "1");
            picInfo22.mapWaterMarkParams.put(FSUploadConst.KEY_CLIENT_UPLOOAD_COVER, "1");
            picInfo22.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_FEED, "1");
            picInfo22.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_ORIGIN_VIDEO, "0");
            picInfo22.mapWaterMarkParams.put(FSUploadConst.KEY_MIX_TIME, str8);
            if (!TextUtils.isEmpty(str9)) {
            }
            picInfo22.mapWaterMarkParams.put("mix_who", "6");
            picInfo22.mapWaterMarkParams.put("mix_playurl", str6);
            cVar.N = picInfo22;
            cVar.W = false;
            QZoneWriteOperationService.v0().O1(cVar);
            LpReportInfo_pf00064.allReport(109, 3, 1);
        } else if (businessFeedData.getFeedCommInfo().isVideoAdv()) {
            ArrayList<String> arrayList5 = new ArrayList<>();
            arrayList5.add(businessFeedData.getVideoInfo().coverUrl.url);
            QZoneWriteOperationService.v0().t0(businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getUser().nickName, businessFeedData.getOperationInfo().qqUrl, QZoneShareManager.THIRD_PART_SHARE_APPID, LoginData.getInstance().getUin(), businessFeedData.getOperationInfo().shareData.sTitle, businessFeedData.getOperationInfo().shareData.sSummary, str, arrayList5, handler, str3, i16, z17);
        } else if (!businessFeedData.getFeedCommInfo().isBizRecomFeeds() || businessFeedData.getFeedCommInfo().recomtype == 7) {
            if (7062 == i19) {
                if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().shareData != null) {
                    DetailDataOutShare detailDataOutShare = businessFeedData.getOperationInfoV2().shareData;
                    ArrayList<String> arrayList6 = new ArrayList<>();
                    if (!TextUtils.isEmpty(ch.c(detailDataOutShare.mapPhotoUrl))) {
                        arrayList6.add(J(detailDataOutShare.mapPhotoUrl));
                    }
                    QZoneWriteOperationService.v0().i0(null, businessFeedData.getOperationInfoV2().genericUrl, QZoneShareManager.THIRD_PART_SHARE_APPID, LoginData.getInstance().getUin(), detailDataOutShare.sTitle, detailDataOutShare.sSummary, str, arrayList6, str3, handler);
                }
            } else if (6600 == i19) {
                if (businessFeedData.getOperationInfoV2() != null) {
                    String str13 = businessFeedData.getOperationInfoV2().qqUrl;
                    if (businessFeedData.getOperationInfoV2().shareData != null) {
                        String str14 = businessFeedData.getOperationInfoV2().shareData.sTitle;
                        str12 = businessFeedData.getOperationInfoV2().shareData.sSummary;
                        if (businessFeedData.isGDTAdvFeed() && businessFeedData.getOperationInfoV2().shareData.mapPhotoUrl != null && businessFeedData.getOperationInfoV2().shareData.mapPhotoUrl.get(11) != null && arrayList2 == null) {
                            arrayList2 = new ArrayList<>();
                            arrayList2.add(businessFeedData.getOperationInfoV2().shareData.mapPhotoUrl.get(11).url);
                        }
                        str10 = str14;
                    }
                    if (businessFeedData.getOperationInfoV2().actionType == 46 && businessFeedData.isCanvasAd() && businessFeedData.getOperationInfoV2().cookie != null && businessFeedData.isGDTAdvFeed()) {
                        businessFeedData.getOperationInfoV2().busiParam.put(157, "46");
                        businessFeedData.getOperationInfoV2().busiParam.put(158, businessFeedData.getOperationInfoV2().cookie.get(3));
                        businessFeedData.getOperationInfoV2().busiParam.put(159, businessFeedData.getOperationInfoV2().cookie.get(1));
                        businessFeedData.getOperationInfoV2().busiParam.put(160, businessFeedData.getOperationInfoV2().cookie.get(1));
                        businessFeedData.getOperationInfoV2().busiParam.put(161, businessFeedData.getCellCanvas().canvasData);
                    }
                    str5 = str13;
                } else {
                    str5 = str4;
                }
                ArrayList<String> arrayList7 = arrayList2;
                QZoneWriteOperationService.v0().r0(businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getOriginalInfo() != null ? businessFeedData.getOriginalInfo().getFeedCommInfo().ugckey : null, QZoneShareManager.THIRD_PART_SHARE_APPID, businessFeedData.getFeedCommInfo().subid, businessFeedData.getUser().uin, str5, arrayList3, str, str10, str12, arrayList7, arrayList7 != null ? arrayList7.size() : 0, 0, 0, config, i3, str2, !TextUtils.isEmpty(str2) ? -1 : 1, businessFeedData.getOperationInfo().busiParam, handler, str3, businessFeedData.getFeedCommInfo().isTodayInHistoryFeed(), z16, null, i16, z17, z18, null);
            } else {
                QZoneWriteOperationService.v0().r0(businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getOriginalInfo() != null ? businessFeedData.getOriginalInfo().getFeedCommInfo().ugckey : null, i19, businessFeedData.getFeedCommInfo().subid, businessFeedData.getUser().uin, str4, arrayList3, str, str10, str12, arrayList2, arrayList2 != null ? arrayList2.size() : 0, 0, 0, config, i3, str2, !TextUtils.isEmpty(str2) ? -1 : 1, businessFeedData.getOperationInfo().busiParam, handler, str3, businessFeedData.getFeedCommInfo().isTodayInHistoryFeed(), z16, null, i16, z17, z18, businessFeedData);
            }
        } else if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().shareData != null) {
            DetailDataOutShare detailDataOutShare2 = businessFeedData.getOperationInfoV2().shareData;
            ArrayList<String> arrayList8 = new ArrayList<>();
            if (!TextUtils.isEmpty(ch.c(detailDataOutShare2.mapPhotoUrl))) {
                arrayList8.add(ch.c(detailDataOutShare2.mapPhotoUrl));
            }
            QZoneWriteOperationService.v0().i0(null, businessFeedData.getOperationInfoV2().qqUrl, QZoneShareManager.THIRD_PART_SHARE_APPID, LoginData.getInstance().getUin(), detailDataOutShare2.sTitle, detailDataOutShare2.sSummary, str, arrayList8, str3, handler);
        }
        if (!businessFeedData.getFeedCommInfo().isFamousRecommAdvFeed() || businessFeedData.getFeedCommInfo().isHotRecommFeed()) {
            LpReportInfo_pf00064 lpReportInfo_pf000642 = new LpReportInfo_pf00064(22, 1, 17);
            lpReportInfo_pf000642.info = businessFeedData.getFeedCommInfo().feedskey + "_" + businessFeedData.getFeedCommInfo().getTime();
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf000642);
        }
    }

    private static BusinessFeedData y(Parcelable parcelable) {
        boolean z16 = parcelable instanceof ParcelableWrapper;
        Object obj = parcelable;
        if (z16) {
            obj = ((ParcelableWrapper) parcelable).getData();
        }
        if (obj instanceof BusinessFeedData) {
            return (BusinessFeedData) obj;
        }
        return null;
    }

    public static boolean z() {
        return u5.b.E("key_last_checked_state_del_media_file", false, LoginData.getInstance().getUin()) || QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_MEDIA_FILE_WHEN_DEL_FEED, 0) == 1;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f47436d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PictureItem f47437e;

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a extends QQPermission.BasePermissionsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f47438a;

            a(int i3) {
                this.f47438a = i3;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                super.onAllGranted();
                b bVar = b.this;
                bVar.b(this.f47438a, bVar.f47437e);
            }
        }

        b(Context context, PictureItem pictureItem) {
            this.f47436d = context;
            this.f47437e = pictureItem;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (QZonePermission.requestPermissions(this.f47436d, QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM, new a(i3))) {
                b(i3, this.f47437e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i3, PictureItem pictureItem) {
            if (i3 == 0) {
                QZoneFeedUtil.d0(pictureItem);
            } else if (i3 == 1) {
                QZoneFeedUtil.e0(pictureItem, true);
            }
        }
    }

    protected static void d0(PictureItem pictureItem) {
        e0(pictureItem, false);
    }

    public static String J(Map<Integer, PictureUrl> map) {
        if (map != null) {
            Iterator<Integer> it = map.keySet().iterator();
            String str = null;
            String str2 = null;
            String str3 = null;
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                PictureUrl pictureUrl = map.get(Integer.valueOf(intValue));
                String str4 = pictureUrl.url;
                if (str4 != null && str4.length() != 0) {
                    try {
                        pictureUrl.url = URLDecoder.decode(pictureUrl.url, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    } catch (Exception unused2) {
                        return null;
                    } catch (OutOfMemoryError unused3) {
                        QZLog.e("FeedDataConvertHelper", "url is too long for URLDecoder");
                        return null;
                    }
                    if (intValue == 0) {
                        str3 = pictureUrl.url;
                    } else if (intValue == 1) {
                        str2 = pictureUrl.url;
                    } else if (intValue == 11) {
                        str = pictureUrl.url;
                    }
                    if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
                        return str;
                    }
                }
            }
            return "";
        }
        return "";
    }

    public static void Y(BusinessFeedData businessFeedData, Handler handler, String str, int i3) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        QZoneWriteOperationService.v0().Y(handler, businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().feedskey, businessFeedData.getFeedCommInfo().clientkey, businessFeedData.getFeedCommInfo().appid, businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().feedsType, businessFeedData.getFeedCommInfo().getTime(), businessFeedData.getOperationInfo().busiParam);
    }

    public static void c0(Context context, CellPictureInfo cellPictureInfo, User user, int i3, CellIdInfo cellIdInfo, d.g gVar, int i16) {
        if (cellPictureInfo != null) {
            if (cellPictureInfo.allow_share == 0 && i3 != 311) {
                ToastUtil.o(R.string.f173018gi2, 4);
                return;
            }
            ArrayList<PictureItem> arrayList = cellPictureInfo.pics;
            ArrayList<NetImageInfo> arrayList2 = new ArrayList<>();
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<PictureItem> it = arrayList.iterator();
                int i17 = 0;
                while (it.hasNext()) {
                    PictureItem next = it.next();
                    if (next != null && !next.isCover) {
                        NetImageInfo netImageInfo = new NetImageInfo();
                        netImageInfo.lloc = next.lloc;
                        if (i3 == 311) {
                            netImageInfo.mAlbumId = next.albumId;
                        } else {
                            netImageInfo.mAlbumId = cellPictureInfo.albumid;
                        }
                        netImageInfo.index = i17;
                        netImageInfo.mSmallPath = next.getCurrentUrl().url;
                        netImageInfo.mBigPath = next.bigUrl.url;
                        netImageInfo.type = next.type;
                        arrayList2.add(netImageInfo);
                        i17++;
                    }
                }
            }
            n5.d.l().s(i16);
            n5.d.l().r(gVar);
            n5.d.l().u(new n5.c());
            n5.d.l().o(context, arrayList2, i3, user.uin, cellIdInfo);
        }
    }

    public static boolean f(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return false;
        }
        return com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask, 17);
    }

    public static boolean i(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return false;
        }
        return !businessFeedData.getFeedCommInfo().isQbossAdvFeeds();
    }

    public static boolean O(BusinessFeedData businessFeedData) {
        return (businessFeedData == null || businessFeedData.getUser() == null || businessFeedData.getUser().uin == LoginData.getInstance().getUin()) ? false : true;
    }

    public static boolean U(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || businessFeedData.isForwardFeed()) {
            return false;
        }
        if (businessFeedData.getFeedCommInfo().appid == 311 && !w(businessFeedData) && x(businessFeedData) == -1) {
            return false;
        }
        if (businessFeedData.getFeedCommInfo().appid == 4) {
            return true;
        }
        return businessFeedData.getFeedCommInfo().appid == 311 && businessFeedData.getCellLuckyMoney() == null && !businessFeedData.isDynamicAlbumFeed();
    }

    public static void X(BusinessFeedData businessFeedData, Fragment fragment, boolean z16, String str) {
        String str2;
        if (businessFeedData == null) {
            QLog.i("QZoneFeedUtil", 1, "[onClickForwardNew] feedData is null");
            return;
        }
        String str3 = businessFeedData.getFeedCommInfo().feedskey;
        if (z16) {
            str3 = str3 + "_YEAR_TODAY";
            str2 = com.qzone.reborn.configx.g.f53821a.a().o();
        } else {
            str2 = "";
        }
        int K = K(businessFeedData.getFeedCommInfo().appid);
        QZoneCommentPanelParams params = cd.c.d(businessFeedData, K).y(K).g(str3).d(str2).A(-1).p(str).getParams();
        i.c().s(params, fragment, businessFeedData);
        LpReportInfo_dc00321.report(15, params.getRefer(), 1, com.qzone.business.lbsv2.business.c.g(QzoneLbsConstant.BUSINESS_ID_QZONE_FOR_REPORT).c());
    }

    public static void Z(BusinessFeedData businessFeedData, Handler handler) {
        if (businessFeedData == null) {
            return;
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        int i16 = businessFeedData.getFeedCommInfo().ugcRight;
        if (QZLog.isColorLevel()) {
            QZLog.d("share", 2, "share qzone, appid=" + i3 + ", ugcRight=" + i16);
        }
        boolean k3 = k(businessFeedData, 2);
        boolean k16 = k(businessFeedData, 1);
        if (businessFeedData.getVideoInfo() != null && (businessFeedData.getVideoInfo().videoStatus == 7 || businessFeedData.getVideoInfo().videoStatus == 4)) {
            if (businessFeedData.getPermissionInfoV2() != null && !am.h(businessFeedData.getPermissionInfoV2().permission_tips)) {
                ToastUtil.s(businessFeedData.getPermissionInfoV2().permission_tips, 4);
            } else {
                ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNotForwad", "\u6682\u4e0d\u53ef\u8f6c\u53d1"), 4);
            }
            AccManager.reportForward(AccManager.RESULT_CODE_FORWARD_REPORT);
            return;
        }
        if (!(O(businessFeedData) && i16 != 1 && i3 == 311) && (k3 || k16)) {
            if (k16) {
                s(businessFeedData, "", 1, null, null, handler, false, 0, true);
                return;
            } else {
                if (k3) {
                    r(businessFeedData, "", 2, null, null, handler, false, 0);
                    return;
                }
                return;
            }
        }
        String str = businessFeedData.getPermissionInfo().permission_tips;
        if (TextUtils.isEmpty(str)) {
            int i17 = businessFeedData.getFeedCommInfo().operatemask;
            str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNotPermissionToForwad", "\u8be5\u5185\u5bb9\u6709\u6743\u9650\uff0c\u4e0d\u5141\u8bb8\u8f6c\u53d1") + ", operatemask: " + i17;
        }
        ToastUtil.s(str, 4);
        AccManager.reportForward(AccManager.RESULT_CODE_FORWARD_REPORT);
    }

    public static boolean e(BusinessFeedData businessFeedData) {
        int i3;
        return (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || (i3 = businessFeedData.getFeedCommInfo().actiontype) == 6 || i3 == 52) ? false : true;
    }

    public static boolean g(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return false;
        }
        boolean z16 = com.qzone.proxy.feedcomponent.util.d.j((long) businessFeedData.getFeedCommInfo().operatemask, 5) || com.qzone.proxy.feedcomponent.util.d.j((long) businessFeedData.getFeedCommInfo().operatemask, 6) || com.qzone.proxy.feedcomponent.util.d.j((long) businessFeedData.getFeedCommInfo().operatemask, 3) || com.qzone.proxy.feedcomponent.util.d.j((long) businessFeedData.getFeedCommInfo().operatemask, 4);
        String str = businessFeedData.getGiftInfo() != null ? businessFeedData.getGiftInfo().giftType : null;
        if (str == null && businessFeedData.getOriginalInfoSafe().getGiftInfo() != null) {
            str = businessFeedData.getOriginalInfoSafe().getGiftInfo().giftType;
        }
        if (TextUtils.isEmpty(str)) {
            return z16;
        }
        return false;
    }

    public static boolean h(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return false;
        }
        String str = businessFeedData.getGiftInfo() != null ? businessFeedData.getGiftInfo().giftType : null;
        if (str == null && businessFeedData.getOriginalInfoSafe().getGiftInfo() != null) {
            str = businessFeedData.getOriginalInfoSafe().getGiftInfo().giftType;
        }
        return !TextUtils.isEmpty(str) && com.qzone.proxy.feedcomponent.util.d.j((long) businessFeedData.getFeedCommInfo().operatemask, 8);
    }

    public static boolean j(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData != null && !businessFeedData.isGDTAdvFeed()) {
            businessFeedData.isAdFeeds();
        }
        return false;
    }

    public static boolean k(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            r0 = (businessFeedData.getFeedCommInfo().operatemask & (1 << i3)) != 0;
            if (QZLog.isDevelopLevel()) {
                QZLog.d("QZoneSharePanel", 4, "checkActionEnabled actiontype: " + i3 + ",result: " + r0);
            }
        }
        return r0;
    }

    public static boolean l(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            r0 = (businessFeedData.getFeedCommInfo().operatemask2 & (1 << i3)) != 0;
            if (QZLog.isColorLevel()) {
                QZLog.d("QZoneFeedUtil", 4, "checkActionEnabledForOperatemask2 actiontype: " + i3 + ", operatemask2: " + businessFeedData.getFeedCommInfo().operatemask2 + ", result: " + r0);
            }
        }
        return r0;
    }

    public static String n(Comment comment) {
        QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo;
        if (comment != null) {
            if (comment.getFontType(false) != 0) {
                return "font";
            }
            if (comment.getSuperFontInfo(false) != null) {
                return "colorFont";
            }
            if (comment.getBarrageEffectInfo(false) != null && (barrageEffectInfo = comment.getBarrageEffectInfo(false)) != null && barrageEffectInfo.f51896id > 0) {
                return "message";
            }
            return "default";
        }
        return "default";
    }

    public static String o(Reply reply) {
        if (reply != null) {
            if (reply.getFontType(false) != 0) {
                return "font";
            }
            if (reply.getSuperFontInfo(false) != null) {
                return "colorFont";
            }
            return "default";
        }
        return "default";
    }

    public static void u(BusinessFeedData businessFeedData) {
        String j3;
        String replace;
        if (businessFeedData == null) {
            return;
        }
        String config = QzoneConfig.getInstance().getConfig("H5Url", "Report", "https://jubao.qq.com/uniform_impeach/impeach_entry?system={system}&version={qua}&uintype=1&eviluin={eviluin}&appname={appname}&appid={appid}&scene={scene}&subapp={subapp}&srv_para={srv_para}");
        String qua3 = QUA.getQUA3();
        String j16 = yo.f.j(yo.f.j(yo.f.j(yo.f.j(yo.f.j(config, "{system}", "android"), "{qua}", qua3), "{QUA}", qua3), "{appname}", "mqzone"), "{appid}", "2400003");
        String str = "pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}";
        if (businessFeedData.getCellUserInfo() != null && businessFeedData.getCellUserInfo().getUser() != null) {
            j16 = yo.f.j(j16, "{eviluin}", String.valueOf(businessFeedData.getCellUserInfo().getUser().uin));
            str = "pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}".replace("{own_uin}", String.valueOf(businessFeedData.getCellUserInfo().getUser().uin));
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 202) {
                    if (i3 == 311) {
                        j3 = yo.f.j(yo.f.j(j16, "{subapp}", LpReportInfoConfig.RESERVE_DELETE_FEED_TYPE_SHUOSHUO), "{scene}", "1301");
                        replace = str.replace("{pid}", "0").replace("{qzone_appid}", "311");
                        if (businessFeedData.getIdInfo() != null) {
                            replace = replace.replace("{cid}", L(businessFeedData.getIdInfo().cellId));
                        }
                    } else if (i3 == 334) {
                        j3 = yo.f.j(yo.f.j(j16, "{subapp}", "guestbook"), "{scene}", "1304");
                        replace = str.replace("{pid}", "0").replace("{qzone_appid}", "334");
                        if (businessFeedData.getIdInfo() != null) {
                            replace = replace.replace("{cid}", L(businessFeedData.getIdInfo().cellId));
                        }
                    } else if (i3 == 406) {
                        j3 = yo.f.j(yo.f.j(j16, "{subapp}", "qzone_story"), "{scene}", "1311");
                        replace = str.replace("{pid}", "0").replace("{qzone_appid}", PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE);
                        if (businessFeedData.getIdInfo() != null) {
                            replace = replace.replace("{cid}", L(businessFeedData.getIdInfo().cellId));
                        }
                    } else if (i3 != 6100 && i3 != 2020014) {
                        if (i3 != 422 && i3 != 423) {
                            j3 = yo.f.j(yo.f.j(j16, "{subapp}", "other"), "{scene}", "1399");
                            replace = str.replace("{pid}", "0");
                            if (businessFeedData.getFeedCommInfo() != null) {
                                replace = replace.replace("{qzone_appid}", String.valueOf(businessFeedData.getFeedCommInfo().appid));
                            }
                            if (businessFeedData.getIdInfo() != null) {
                                replace = replace.replace("{cid}", L(businessFeedData.getIdInfo().cellId));
                            }
                        }
                    }
                }
                j3 = yo.f.j(yo.f.j(j16, "{subapp}", "share"), "{scene}", "1303");
                replace = str.replace("{pid}", "0").replace("{qzone_appid}", ThemeReporter.FROM_NIGHT);
                if (businessFeedData.getIdInfo() != null) {
                    replace = replace.replace("{cid}", L(businessFeedData.getIdInfo().cellId));
                }
            }
            j3 = yo.f.j(yo.f.j(j16, "{subapp}", "photo"), "{scene}", "1305");
            replace = str.replace("{qzone_appid}", "4");
            if (businessFeedData.getPictureInfo() != null) {
                String replace2 = replace.replace("{pid}", L(businessFeedData.getPictureInfo().albumid));
                StringBuilder sb5 = new StringBuilder("");
                if (businessFeedData.getPictureInfo().pics != null) {
                    sb5.append("{");
                    Iterator<PictureItem> it = businessFeedData.getPictureInfo().pics.iterator();
                    while (it.hasNext()) {
                        PictureItem next = it.next();
                        if (!TextUtils.isEmpty(next.sloc)) {
                            sb5.append(next.sloc);
                            sb5.append(",");
                        } else {
                            sb5.append(next.lloc);
                            sb5.append(",");
                        }
                    }
                    sb5.deleteCharAt(sb5.length() - 1);
                    sb5.append("}");
                }
                replace = replace2.replace("{cid}", sb5.toString());
            }
        } else {
            j3 = yo.f.j(yo.f.j(j16, "{subapp}", "blog"), "{scene}", "1302");
            replace = str.replace("{pid}", "0").replace("{qzone_appid}", "2");
            if (businessFeedData.getIdInfo() != null) {
                replace = replace.replace("{cid}", L(businessFeedData.getIdInfo().cellId));
            }
        }
        yo.d.d(yo.f.j(j3, "{srv_para}", replace), BaseApplication.getContext(), null);
    }

    public static boolean w(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            return businessFeedData.getVideoInfo() != null || (businessFeedData.getLeftThumb() != null && businessFeedData.getLeftThumb().getMediaType() == 3);
        }
        return false;
    }

    public static int x(BusinessFeedData businessFeedData) {
        ArrayList<PictureItem> arrayList;
        if (businessFeedData == null || businessFeedData.getPictureInfo() == null || (arrayList = businessFeedData.getPictureInfo().pics) == null || arrayList.size() <= 0) {
            return -1;
        }
        Iterator<PictureItem> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            PictureItem next = it.next();
            if (next != null && next.videoflag == 1) {
                i3++;
            }
        }
        if (i3 == 0) {
            return 2;
        }
        return i3 == arrayList.size() ? 3 : 1;
    }

    public static boolean i0(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return false;
        }
        if (businessFeedData.getFeedCommInfo().appid == 311 || businessFeedData.getFeedCommInfo().appid == 4) {
            return businessFeedData.getFeedCommInfo().extendInfo == null || !"1".equals(businessFeedData.getFeedCommInfo().extendInfo.get("is_feeds_long_pics_browsing_mode"));
        }
        return false;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements QzoneFavoriteService.d {
        a() {
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            if (z16) {
                ToastUtil.o(R.string.gex, 4);
            } else {
                ToastUtil.o(R.string.ger, 4);
            }
        }
    }

    public static String B(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            if (w(businessFeedData)) {
                return BaseApplication.getContext().getString(R.string.gf8);
            }
            int i3 = businessFeedData.getFeedCommInfo().appid;
            if (i3 == 2) {
                return BaseApplication.getContext().getString(R.string.gez);
            }
            if (i3 == 4) {
                if ((businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().uploadnum > 1) || (businessFeedData.getOriginalInfoSafe().getPictureInfo() != null && businessFeedData.getOriginalInfoSafe().getPictureInfo().uploadnum > 1)) {
                    return BaseApplication.getContext().getString(R.string.f173007gf3);
                }
                if (LoginData.getInstance().isQzoneVip()) {
                    return BaseApplication.getContext().getString(R.string.gf5);
                }
                return BaseApplication.getContext().getString(R.string.f173008gf4);
            }
            if (i3 == 51) {
                return BaseApplication.getContext().getString(R.string.f173006gf2);
            }
            if (i3 == 202) {
                return BaseApplication.getContext().getString(R.string.gf6);
            }
            if (i3 != 311) {
                return BaseApplication.getContext().getString(R.string.gey);
            }
            if (businessFeedData.isDynamicAlbumFeed()) {
                return BaseApplication.getContext().getString(R.string.f173004gf0);
            }
            if (businessFeedData.getCellLuckyMoney() != null) {
                return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG, QzoneConfig.DEFAULT_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG);
            }
            return BaseApplication.getContext().getString(R.string.gf7);
        }
        return BaseApplication.getContext().getString(R.string.gey);
    }

    public static String D(BusinessFeedData businessFeedData) {
        if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
            int i3 = businessFeedData.getFeedCommInfo().appid;
            if (i3 != 4 && w(businessFeedData)) {
                return BaseApplication.getContext().getString(R.string.gf8);
            }
            if (i3 == 2) {
                return BaseApplication.getContext().getString(R.string.gez);
            }
            if (i3 == 4) {
                if (w(businessFeedData)) {
                    return BaseApplication.getContext().getString(R.string.gf9);
                }
                if (businessFeedData.isMixVideoPic()) {
                    return BaseApplication.getContext().getString(R.string.f173005gf1);
                }
                return BaseApplication.getContext().getString(R.string.f173007gf3);
            }
            if (i3 == 51) {
                return BaseApplication.getContext().getString(R.string.f173006gf2);
            }
            if (i3 == 202) {
                return BaseApplication.getContext().getString(R.string.gf6);
            }
            if (i3 != 311) {
                if (i3 != 330) {
                    return BaseApplication.getContext().getString(R.string.gey);
                }
                return BaseApplication.getContext().getString(R.string.gnn);
            }
            if (businessFeedData.isDynamicAlbumFeed()) {
                return BaseApplication.getContext().getString(R.string.f173004gf0);
            }
            if (businessFeedData.getCellLuckyMoney() != null) {
                return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG, QzoneConfig.DEFAULT_FEED_REDPOCKET_SHUOSHUO_DELETE_MSG);
            }
            return BaseApplication.getContext().getString(R.string.gf7);
        }
        return BaseApplication.getContext().getString(R.string.gey);
    }

    protected static void e0(final PictureItem pictureItem, boolean z16) {
        if (z16) {
            LpReportInfo_pf00064.allReport(134, 1, 1);
        } else {
            LpReportInfo_pf00064.allReport(134, 2, 1);
        }
        f47426f = z16;
        if (f47425e == null) {
            f47425e = new c();
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.6
            @Override // java.lang.Runnable
            public void run() {
                QZoneFeedUtil.p(PictureItem.this, AppConstants.SDCARD_IMG_SAVE, QZoneFeedUtil.f47425e);
            }
        });
    }

    public static void g0(Context context, PictureItem pictureItem) {
        if (pictureItem == null || context == null) {
            return;
        }
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setItems(new String[]{l.a(R.string.f172543rw2), l.a(R.string.rvk)}, new b(context, pictureItem));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            try {
                create.show();
            } catch (Exception e16) {
                e16.printStackTrace();
                QZLog.e("DialogUtils", e16.toString());
            }
        } catch (Exception e17) {
            e17.printStackTrace();
            QZLog.e("DialogUtils.showAlert", e17.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01a4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0133 A[Catch: OutOfMemoryError -> 0x019d, TryCatch #3 {OutOfMemoryError -> 0x019d, blocks: (B:53:0x012d, B:55:0x0133, B:57:0x014a, B:69:0x013c), top: B:52:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x014a A[Catch: OutOfMemoryError -> 0x019d, TRY_LEAVE, TryCatch #3 {OutOfMemoryError -> 0x019d, blocks: (B:53:0x012d, B:55:0x0133, B:57:0x014a, B:69:0x013c), top: B:52:0x012d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013c A[Catch: OutOfMemoryError -> 0x019d, TryCatch #3 {OutOfMemoryError -> 0x019d, blocks: (B:53:0x012d, B:55:0x0133, B:57:0x014a, B:69:0x013c), top: B:52:0x012d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void p(PictureItem pictureItem, String str, Handler handler) {
        Bitmap bitmap;
        String str2;
        String str3;
        boolean z16;
        boolean z17;
        Bitmap a16;
        String str4;
        Message obtain = Message.obtain();
        if (pictureItem == null) {
            obtain.what = 1;
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-save error photoInfo == null");
            handler.sendMessage(obtain);
            return;
        }
        if (!CacheManager.isExternalAvailable()) {
            obtain.what = 3;
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-save error sd is not writeable");
            handler.sendMessage(obtain);
            return;
        }
        ImageLoader imageLoader = ImageLoader.getInstance();
        File imageFile = !TextUtils.isEmpty(pictureItem.originUrl.url) ? imageLoader.getImageFile(pictureItem.originUrl.url) : null;
        if ((imageFile == null || !imageFile.exists()) && !TextUtils.isEmpty(pictureItem.downloadUrl.url)) {
            imageFile = imageLoader.getImageFile(pictureItem.downloadUrl.url);
        }
        if ((imageFile == null || !imageFile.exists()) && pictureItem.type == 2) {
            imageFile = imageLoader.getImageFile(E(pictureItem));
        }
        if (imageFile == null || !imageFile.exists()) {
            imageFile = imageLoader.getImageFile(pictureItem.bigUrl.url);
        }
        if (imageFile == null) {
            imageFile = imageLoader.getImageFile(pictureItem.currentUrl.url);
        }
        if (imageFile != null && imageFile.exists()) {
            String p46 = BasePictureViewer.p4(imageFile.getAbsolutePath());
            if (p46 == null) {
                obtain.what = 1;
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-save error postfix == null");
                handler.sendMessage(obtain);
                return;
            }
            boolean equals = p46.equals("webp");
            if (equals) {
                try {
                    Bitmap decodeFile = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                    if (decodeFile != null) {
                        str2 = str + (String.valueOf(System.currentTimeMillis()) + ".jpeg");
                        try {
                            z17 = com.qzone.util.image.c.V(decodeFile, str2, Bitmap.CompressFormat.JPEG, 90, true);
                        } catch (OutOfMemoryError e16) {
                            e = e16;
                            QZLog.w("QZoneFeedUtil", "Out of Memory ", e);
                            str3 = str2;
                            z16 = false;
                            if (!p46.equals("sharpp")) {
                            }
                            QZLog.i("QZoneFeedUtil", "sharpp file");
                            try {
                                if (!p46.equals("sharpp")) {
                                }
                                if (a16 != null) {
                                }
                            } catch (OutOfMemoryError e17) {
                                e = e17;
                            }
                            str4 = str3;
                            if (!equals) {
                            }
                            if (equals) {
                            }
                            handler.sendMessage(obtain);
                            return;
                        }
                    } else {
                        z17 = false;
                        str2 = null;
                    }
                    str3 = str2;
                    z16 = z17;
                } catch (OutOfMemoryError e18) {
                    e = e18;
                    str2 = null;
                }
            } else {
                z16 = false;
                str3 = null;
            }
            if (!p46.equals("sharpp") || p46.equals("avif")) {
                QZLog.i("QZoneFeedUtil", "sharpp file");
                if (!p46.equals("sharpp")) {
                    a16 = SharpPUtils.decodeSharpP(imageFile.getAbsolutePath());
                } else {
                    a16 = com.tencent.qzone.image.api.a.c().a(imageFile, pictureItem.bigUrl.url, 0, 0);
                }
                if (a16 != null) {
                    String str5 = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    String str6 = str + str5;
                    try {
                        if (com.qzone.util.image.c.V(a16, str6, Bitmap.CompressFormat.JPEG, 90, true)) {
                            obtain.what = 2;
                            obtain.obj = str6;
                            handler.sendMessage(obtain);
                            QZLog.i("QZoneFeedUtil", "------sharpp file save success:" + str5);
                            return;
                        }
                        str3 = str6;
                    } catch (OutOfMemoryError e19) {
                        e = e19;
                        str3 = str6;
                        QZLog.w("QZoneFeedUtil", "Out of Memory ", e);
                        str4 = str3;
                        if (!equals) {
                        }
                        if (equals) {
                            obtain.what = 2;
                            obtain.obj = str4;
                        }
                        handler.sendMessage(obtain);
                        return;
                    }
                }
            }
            str4 = str3;
            if ((!equals && !z16) || !equals) {
                String str7 = str + (String.valueOf(System.currentTimeMillis()) + "." + p46);
                FileUtils.copyFiles(new File(imageFile.getAbsolutePath()), new File(str7));
                obtain.what = 2;
                obtain.obj = str7;
            } else if (equals && z16) {
                obtain.what = 2;
                obtain.obj = str4;
            }
            handler.sendMessage(obtain);
            return;
        }
        obtain.what = 1;
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-save error file == null");
        Drawable imageByUrlInMemory = ImageManager.getInstance().getImageByUrlInMemory(pictureItem.bigUrl.url);
        if ((imageByUrlInMemory instanceof ImageDrawable) && (bitmap = ((ImageDrawable) imageByUrlInMemory).getBitmapRef().getBitmap()) != null && !bitmap.isRecycled()) {
            String str8 = str + (String.valueOf(System.currentTimeMillis()) + ".jpeg");
            boolean V = com.qzone.util.image.c.V(bitmap, str8, Bitmap.CompressFormat.JPEG, 90, false);
            obtain.what = V ? 2 : 1;
            if (V) {
                QZLog.i(QZLog.TO_DEVICE_TAG, 1, "copyPictrue-loadBitmap saveSuccess");
                obtain.obj = str8;
            }
        }
        handler.sendMessage(obtain);
    }

    public static void q(BusinessFeedData businessFeedData, String str, int i3, String str2, String str3, Handler handler, boolean z16) {
        r(businessFeedData, str, i3, str2, str3, handler, z16, -1);
    }

    public static void f0(int i3, BusinessFeedData businessFeedData, Handler handler, n<BusinessFeedData> nVar) {
        String str;
        String str2;
        HashMap<String, String> hashMap;
        ArrayList<PhotoInformation> arrayList;
        Object obj;
        PictureItem pictureItem;
        String str3;
        String str4;
        if (businessFeedData == null) {
            return;
        }
        if (!NetworkState.isNetSupport()) {
            QzoneFavoriteService.M().Q(new a(), businessFeedData.getFeedCommInfo().ugckey);
            return;
        }
        if (nVar == null || !nVar.Lc()) {
            return;
        }
        if (i3 != 3585) {
            if (i3 != 3586) {
                return;
            }
            nVar.b9(new k(businessFeedData));
            return;
        }
        String str5 = businessFeedData.getIdInfo().cellId;
        String str6 = businessFeedData.getIdInfo().subId;
        Pair<CellPictureInfo, Boolean> m3 = com.qzone.proxy.feedcomponent.util.d.m(businessFeedData);
        if (businessFeedData.getFeedCommInfo().appid != 4 || (obj = m3.first) == null || ((CellPictureInfo) obj).pics == null || ((CellPictureInfo) obj).pics.size() > 1 || (pictureItem = ((CellPictureInfo) m3.first).pics.get(0)) == null) {
            str = str5;
            str2 = str6;
            hashMap = null;
            arrayList = null;
        } else {
            ArrayList<PhotoInformation> arrayList2 = new ArrayList<>();
            PhotoInformation photoInformation = new PhotoInformation();
            PictureUrl pictureUrl = pictureItem.bigUrl;
            if (pictureUrl == null) {
                str3 = "";
            } else {
                str3 = pictureUrl.url;
            }
            photoInformation.sUrl = str3;
            photoInformation.iPhotoType = pictureItem.type;
            arrayList2.add(photoInformation);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("albumsID", ((CellPictureInfo) m3.first).albumid);
            PictureUrl pictureUrl2 = pictureItem.bigUrl;
            if (pictureUrl2 == null) {
                str4 = "";
            } else {
                str4 = pictureUrl2.url;
            }
            hashMap2.put("url", str4);
            hashMap2.put(PhotoCategorySinglePicInfo.SLOC, pictureItem.sloc);
            hashMap2.put("lloc", pictureItem.lloc);
            hashMap2.put(s4.c.UGCKEY, businessFeedData.getFeedCommInfo().ugckey);
            arrayList = arrayList2;
            hashMap = hashMap2;
            str = "";
            str2 = str;
        }
        nVar.F7();
        QzoneFavoriteService.M().E(businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().appid, businessFeedData.getFeedCommInfo().subid, str, str2, businessFeedData.getFeedCommInfo().ugckey, hashMap, arrayList, handler);
    }

    public static void r(BusinessFeedData businessFeedData, String str, int i3, String str2, String str3, Handler handler, boolean z16, int i16) {
        s(businessFeedData, str, i3, str2, str3, handler, z16, i16, false);
    }

    public static void s(BusinessFeedData businessFeedData, String str, int i3, String str2, String str3, Handler handler, boolean z16, int i16, boolean z17) {
        t(businessFeedData, str, i3, str2, str3, handler, z16, i16, z17, false);
    }

    public static void v(final Activity activity, BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        String str;
        String str2;
        String o16;
        String str3;
        String str4;
        boolean z16;
        String str5;
        String str6;
        String o17;
        String str7;
        String str8;
        String str9;
        Map<Integer, String> map;
        Reply reply2;
        String str10;
        Comment comment2 = comment;
        if (activity == null || businessFeedData == null || comment2 == null) {
            return;
        }
        if (!comment2.isCanJubao) {
            String o18 = yo.f.o(yo.f.o(yo.f.o(yo.f.o(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_COMMENT_REPLY_REPORT, "https://jubao.qq.com/uniform_impeach/impeach_entry?system={system}&version={qua}&uintype=1&eviluin={eviluin}&appname={appname}&appid={appid}&scene={scene}&subapp={subapp}&srv_para={srv_para}"), "{system}", "android"), "{qua}", QUA.getQUA3()), "{appname}", "mqzone"), "{appid}", "1000311");
            String n3 = yo.f.n(yo.f.n(yo.f.n(yo.f.n("pid:{pid}|cid:{cid}|qzone_appid:{qzone_appid}|own_uin:{own_uin}|comment_id:{comment_id}|reply_uin:{reply_uin}|msgtype:{msgtype}", "{pid}", 0L), "{qzone_appid}", 1000311L), "{msgtype}", 101L), "{reply_uin}", 0L);
            if (businessFeedData.getCellUserInfo() != null && businessFeedData.getCellUserInfo().getUser() != null) {
                User user = businessFeedData.getCellUserInfo().getUser();
                n3 = yo.f.n(n3, "{own_uin}", user.uin);
                o18 = yo.f.n(o18, "{eviluin}", user.uin);
            }
            String o19 = yo.f.o(n3, "{comment_id}", comment2.commentid);
            if (businessFeedData.getIdInfo() != null) {
                o19 = yo.f.o(o19, "{cid}", L(businessFeedData.getIdInfo().cellId));
            }
            final String replaceAll = yo.f.o(yo.f.o(yo.f.o(o18, "{subapp}", "nss_comment"), "{scene}", "25045"), "{srv_para}", o19.replaceAll("\\{[\\w_]+\\}", "")).replaceAll("\\{[\\w_]+\\}", "");
            activity.runOnUiThread(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    yo.d.d(replaceAll, BaseApplication.getContext(), null);
                }
            });
            return;
        }
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_COMMENT_REPLY_REPORT, "https://jubao.qq.com/uniform_impeach/impeach_entry?system={system}&version={qua}&uintype=1&eviluin={eviluin}&appname={appname}&appid={appid}&scene={scene}&subapp={subapp}&text_evidence={text_evidence}&img_evidence={img_evidence}&url_evidence={url_evidence}&video_evidence={video_evidence}&file_evidence={file_evidence}&audio_evidence={audio_evidence}&user_input_param={user_input_param}&srv_para={srv_para}");
        final String qua3 = QUA.getQUA3();
        final String str11 = "android";
        String o26 = yo.f.o(yo.f.o(yo.f.o(yo.f.o(config, "{system}", "android"), "{qua}", qua3), "{appname}", "mqzone"), "{appid}", "2400003");
        String str12 = "qzoneUin:{qzoneUin}|comment_uin:{comment_uin}||tid:{tid}|commentId:{commentId}|reply_id:{reply_id}|lloc:{lloc}|batch_id:{batch_id}";
        if (businessFeedData.getCellUserInfo() != null && businessFeedData.getCellUserInfo().getUser() != null) {
            str12 = yo.f.n("qzoneUin:{qzoneUin}|comment_uin:{comment_uin}||tid:{tid}|commentId:{commentId}|reply_id:{reply_id}|lloc:{lloc}|batch_id:{batch_id}", "{qzoneUin}", businessFeedData.getCellUserInfo().getUser().uin);
        }
        User user2 = comment2.user;
        if (user2 != null) {
            str12 = yo.f.n(str12, "{comment_uin}", user2.uin);
        }
        String o27 = yo.f.o(str12, "{commentId}", comment2.commentid);
        if (reply != null) {
            String o28 = yo.f.o(o27, "{reply_id}", reply.replyId);
            User user3 = reply.user;
            if (user3 != null) {
                String valueOf = String.valueOf(user3.uin);
                o26 = yo.f.o(o26, "{eviluin}", valueOf);
                reply2 = reply;
                o27 = yo.f.n(o28, "comment_uin", reply2.user.uin);
                str10 = valueOf;
            } else {
                reply2 = reply;
                o27 = o28;
                str10 = null;
            }
            String str13 = reply2.content;
            o16 = yo.f.o(o26, "{text_evidence}", str13);
            str2 = str13;
            str3 = null;
            str = str10;
        } else {
            User user4 = comment2.user;
            if (user4 != null) {
                str = String.valueOf(user4.uin);
                o26 = yo.f.o(o26, "{eviluin}", str);
            } else {
                str = null;
            }
            str2 = comment2.comment;
            o16 = yo.f.o(o26, "{text_evidence}", str2);
            ArrayList<PictureItem> arrayList = comment2.commentPictureItems;
            if (arrayList == null || arrayList.size() <= 0) {
                str3 = null;
            } else {
                String o29 = yo.f.o(o27, "{lloc}", comment2.commentPictureItems.get(0).lloc);
                StringBuilder sb5 = new StringBuilder("");
                int size = comment2.commentPictureItems.size() - 1;
                while (size >= 0) {
                    PictureUrl currentUrl = comment2.commentPictureItems.get(size).getCurrentUrl();
                    if (currentUrl == null || (str5 = currentUrl.url) == null) {
                        str4 = o29;
                        z16 = false;
                    } else {
                        int indexOf = str5.indexOf(38);
                        str4 = o29;
                        z16 = false;
                        if (indexOf >= 0) {
                            str5 = str5.substring(0, indexOf);
                        }
                        if (size != 0) {
                            sb5.append(str5);
                            sb5.append("|");
                        } else {
                            sb5.append(str5);
                        }
                    }
                    size--;
                    comment2 = comment;
                    o29 = str4;
                }
                String sb6 = sb5.toString();
                o16 = yo.f.o(o16, "{img_evidence}", sb6);
                str3 = sb6;
                o27 = o29;
            }
        }
        CellOperationInfo operationInfoV2 = businessFeedData.getOperationInfoV2();
        if (operationInfoV2 != null && (map = operationInfoV2.busiParam) != null) {
            o27 = yo.f.o(o27, "{batch_id}", map.get(21));
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        if (i3 != 2) {
            if (i3 != 4) {
                if (i3 != 202) {
                    if (i3 == 311) {
                        String o36 = yo.f.o(o16, "{subapp}", "shuoshuo_comment_reply");
                        str6 = "2125";
                        o17 = yo.f.o(o36, "{scene}", "2125");
                        if (businessFeedData.getIdInfo() != null) {
                            o27 = yo.f.o(o27, "{tid}", L(businessFeedData.getIdInfo().cellId));
                        }
                    } else if (i3 != 6100 && i3 != 2020014) {
                        if (i3 != 422 && i3 != 423) {
                            str7 = null;
                            final String replaceAll2 = o27.replaceAll("\\{[\\w_]+\\}", "");
                            final String replaceAll3 = yo.f.o(o16, "{srv_para}", replaceAll2).replaceAll("\\{[\\w_]+\\}", "");
                            final String str14 = str7;
                            final String str15 = str;
                            final String str16 = str2;
                            final String str17 = str3;
                            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    final String str18 = replaceAll3 + "&cryptograph=" + com.qzone.feed.utils.a.b(BaseApplication.getContext(), str11, qua3, str14, str15, replaceAll2, str16, str17, null, null, null, null);
                                    if (QZLog.isColorLevel()) {
                                        QZLog.i("QZoneFeedUtil", 2, "[doInformCommentReply] url = " + str18);
                                    }
                                    activity.runOnUiThread(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.3.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            yo.d.d(str18, BaseApplication.getContext(), null);
                                        }
                                    });
                                }
                            });
                        }
                    }
                }
                String o37 = yo.f.o(o16, "{subapp}", "share_comment_reply");
                str6 = "2127";
                o17 = yo.f.o(o37, "{scene}", "2127");
                if (businessFeedData.getIdInfo() != null) {
                    o27 = yo.f.o(o27, "{tid}", L(businessFeedData.getIdInfo().cellId));
                }
            }
            String o38 = yo.f.o(o16, "{subapp}", "photo_comment_reply");
            String str18 = "2128";
            String o39 = yo.f.o(o38, "{scene}", "2128");
            if (businessFeedData.getPictureInfo() == null) {
                str8 = o39;
                str9 = "2128";
            } else {
                StringBuilder sb7 = new StringBuilder("");
                if (businessFeedData.getPictureInfo().pics == null) {
                    str8 = o39;
                    str9 = "2128";
                } else {
                    sb7.append("{");
                    Iterator<PictureItem> it = businessFeedData.getPictureInfo().pics.iterator();
                    while (it.hasNext()) {
                        PictureItem next = it.next();
                        String str19 = o39;
                        String str20 = str18;
                        if (!TextUtils.isEmpty(next.sloc)) {
                            sb7.append(next.sloc);
                            sb7.append(",");
                        } else {
                            sb7.append(next.lloc);
                            sb7.append(",");
                        }
                        o39 = str19;
                        str18 = str20;
                    }
                    str8 = o39;
                    str9 = str18;
                    sb7.deleteCharAt(sb7.length() - 1);
                    sb7.append("}");
                }
                o27 = yo.f.o(o27, "{tid}", sb7.toString());
            }
            o16 = str8;
            str7 = str9;
            final String replaceAll22 = o27.replaceAll("\\{[\\w_]+\\}", "");
            final String replaceAll32 = yo.f.o(o16, "{srv_para}", replaceAll22).replaceAll("\\{[\\w_]+\\}", "");
            final String str142 = str7;
            final String str152 = str;
            final String str162 = str2;
            final String str172 = str3;
            ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.3
                @Override // java.lang.Runnable
                public void run() {
                    final String str182 = replaceAll32 + "&cryptograph=" + com.qzone.feed.utils.a.b(BaseApplication.getContext(), str11, qua3, str142, str152, replaceAll22, str162, str172, null, null, null, null);
                    if (QZLog.isColorLevel()) {
                        QZLog.i("QZoneFeedUtil", 2, "[doInformCommentReply] url = " + str182);
                    }
                    activity.runOnUiThread(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            yo.d.d(str182, BaseApplication.getContext(), null);
                        }
                    });
                }
            });
        }
        String o46 = yo.f.o(o16, "{subapp}", "blog_comment_reply");
        str6 = "2126";
        o17 = yo.f.o(o46, "{scene}", "2126");
        if (businessFeedData.getIdInfo() != null) {
            o27 = yo.f.o(o27, "{tid}", L(businessFeedData.getIdInfo().cellId));
        }
        str7 = str6;
        o16 = o17;
        final String replaceAll222 = o27.replaceAll("\\{[\\w_]+\\}", "");
        final String replaceAll322 = yo.f.o(o16, "{srv_para}", replaceAll222).replaceAll("\\{[\\w_]+\\}", "");
        final String str1422 = str7;
        final String str1522 = str;
        final String str1622 = str2;
        final String str1722 = str3;
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.3
            @Override // java.lang.Runnable
            public void run() {
                final String str182 = replaceAll322 + "&cryptograph=" + com.qzone.feed.utils.a.b(BaseApplication.getContext(), str11, qua3, str1422, str1522, replaceAll222, str1622, str1722, null, null, null, null);
                if (QZLog.isColorLevel()) {
                    QZLog.i("QZoneFeedUtil", 2, "[doInformCommentReply] url = " + str182);
                }
                activity.runOnUiThread(new Runnable() { // from class: com.qzone.feed.utils.QZoneFeedUtil.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        yo.d.d(str182, BaseApplication.getContext(), null);
                    }
                });
            }
        });
    }

    public static Intent G(Context context, e.a aVar, Serializable serializable, Parcelable parcelable, EditPositionBag editPositionBag, boolean z16, int i3, String str, boolean z17, int i16) {
        return H(context, aVar, serializable, parcelable, editPositionBag, z16, i3, str, z17, i16, null);
    }

    public static void h0(Context context, String str, boolean z16) {
    }
}
