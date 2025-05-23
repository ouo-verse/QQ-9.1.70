package com.qzone.misc.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.app.ResourcePreloader;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.common.business.model.AvatarCacheData;
import com.qzone.common.event.EventCenter;
import com.qzone.homepage.diy.util.QzoneDIYService;
import com.qzone.homepage.ui.Facade.h;
import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.personalize.model.CustomFriendNaviData;
import com.qzone.personalize.model.CustomPlayerData;
import com.qzone.publish.service.QzoneBarrageEffectService;
import com.qzone.publish.service.QzoneNewCardSkinService;
import com.qzone.reborn.albumx.qzonex.bean.upload.QZAlbumxUploadAlbumInitBean;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.vip.manager.MonitorManager;
import ho.i;
import java.util.HashMap;
import p6.b;
import yo.d;

/* loaded from: classes39.dex */
public class QZoneWebPluginHandler {

    /* renamed from: a, reason: collision with root package name */
    private static final String f48611a = "com.qzone.misc.web.QZoneWebPluginHandler";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f48613a;

        b(String str) {
            this.f48613a = str;
        }

        @Override // p6.b.c
        public void a(String str) {
            if (QZLog.isColorLevel()) {
                QZLog.i(QZoneWebPluginHandler.f48611a, 2, "onFileFailed|sendToJsResForAvatarDownload");
            }
            QZoneWebPluginHandler.o(1, null);
        }

        @Override // p6.b.c
        public void b(String str) {
            if (QZLog.isColorLevel()) {
                QZLog.i(QZoneWebPluginHandler.f48611a, 2, "onFileCanceled|sendToJsResForAvatarDownload");
            }
            QZoneWebPluginHandler.o(1, null);
        }

        @Override // p6.b.c
        public void c(AnimationDrawable animationDrawable, String str, String str2) {
            if (QZLog.isColorLevel()) {
                QZLog.i(QZoneWebPluginHandler.f48611a, 2, "onFileLoaded|sendToJsResForAvatarDownload");
            }
            QZoneWebPluginHandler.o(0, p6.b.x(this.f48613a, str2));
        }
    }

    private static int c(Bundle bundle, String str, int i3) {
        return bundle.getInt(str, i3);
    }

    private static long d(Bundle bundle, String str, long j3) {
        return bundle.getLong(str, j3);
    }

    private static String e(Bundle bundle, String str, String str2) {
        String string = bundle.getString(str);
        return string != null ? string : str2;
    }

    private static void g(Bundle bundle) {
        CustomFriendNaviData customFriendNaviData = new CustomFriendNaviData();
        customFriendNaviData.iItemId = c(bundle, "itemId", -1);
        customFriendNaviData.strFriendNaviDecoUrl = e(bundle, "friendNaviDecoUrl", "");
        customFriendNaviData.stTextColor = e(bundle, "textColor", "");
        com.qzone.personalize.business.b.n().s(customFriendNaviData);
        EventCenter.getInstance().post("Personalize", 22, customFriendNaviData);
    }

    private static void h(int i3, long j3, String str) {
        CustomPlayerData customPlayerData = new CustomPlayerData();
        customPlayerData.iItemId = i3;
        customPlayerData.uin = LoginData.getInstance().getUin();
        customPlayerData.lTextColor = j3;
        customPlayerData.strPlayerDecoUrl = str;
        com.qzone.personalize.business.b.n().v(customPlayerData);
    }

    private static void i(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String e16 = e(extras, "cmd", "");
        if (QZLog.isColorLevel()) {
            QZLog.i(f48611a, 2, "receive broacast action=" + intent.getAction() + "|method:" + e16);
        }
        if (e16.equals(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_DOWNLOAD)) {
            String e17 = e(extras, "avatarId", "");
            String e18 = e(extras, PhotoCategorySummaryInfo.AVATAR_URL, "");
            String e19 = e(extras, "type", "");
            if (TextUtils.isEmpty(e18)) {
                return;
            }
            if (e19.equals("static")) {
                if (ImageLoader.getInstance().loadImage(e18, new a()) != null) {
                    if (QZLog.isColorLevel()) {
                        QZLog.i(f48611a, 2, "ACTION_FACADE_JS_TO_QZONE| image has download");
                    }
                    o(0, null);
                    return;
                }
                return;
            }
            if (e19.equals(TabPreloadItem.TAB_NAME_DYNAMIC)) {
                String i3 = p6.b.w().i(e18, e17, new b(e17));
                if (TextUtils.isEmpty(i3)) {
                    return;
                }
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "ACTION_FACADE_JS_TO_QZONE| File has download");
                }
                o(0, p6.b.x(e17, i3));
                return;
            }
            return;
        }
        if (e16.equals(QZoneJsConstants.QZonePersonalizeJsConstants.AVATAR_METHOD_SETAVATAR)) {
            EventCenter.getInstance().post("Personalize", 4, (Object[]) null);
        }
    }

    private static void j(Activity activity, Bundle bundle) {
        EventCenter.getInstance().post("Feed", 18, (Object[]) null);
    }

    private static void k(Context context, Intent intent) {
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(17);
    }

    private static void l() {
        MonitorManager.f().j(1, 5, "\u9ec4\u94bb\u652f\u4ed8\u6210\u529f", "\u91cd\u65b0\u8bf7\u6c42\u540e\u53f0\u6700\u65b0\u7528\u6237\u4fe1\u606f");
        new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: com.qzone.misc.web.QZoneWebPluginHandler.2
            @Override // java.lang.Runnable
            public void run() {
                z5.a.f().q(LoginData.getInstance().getUin(), null);
            }
        }, 1500L);
    }

    private static void m(Context context, Intent intent) {
        int i3;
        int i16;
        int i17;
        Bundle extras = intent.getExtras();
        String e16 = e(extras, "cmd", "");
        if (e16.equals(QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_SETCARDFINISH)) {
            String e17 = e(extras, "sSkinId", "");
            long uin = LoginData.getInstance().getUin();
            String e18 = e(extras, "sPicUrl", "");
            long j3 = extras.getLong("lTime", System.currentTimeMillis() / 1000);
            String e19 = e(extras, "desc", "");
            String e26 = e(extras, "title", "");
            int i18 = extras.getInt(FacadeCacheData.f47632VIP, 0);
            String e27 = e(extras, AvatarCacheData.STRTRACEINFO, "");
            int i19 = extras.getInt("sSkinType", 364);
            String e28 = e(extras, "musicurl", "");
            String e29 = e(extras, "bgColor", "");
            String e36 = e(extras, "gradientColorBegin", "");
            String e37 = e(extras, "gradientColorEnd", "");
            String e38 = e(extras, "strFrameZip", "");
            int c16 = c(extras, "iFrameRate", 0);
            int i26 = extras.getInt("isAfter785", 0);
            QZLog.i("@newcard", 1, "CARD_METHOD_SETCARDFINISH, newcard id:" + e17 + " iNewFeedSkin:" + i26);
            if (TextUtils.isEmpty(e17)) {
                return;
            }
            com.qzone.personalize.business.a.b().f(true);
            FeedSkinData feedSkinData = new FeedSkinData(e17, uin, e18, j3, e19, e26, i18, e27, i19, e28);
            feedSkinData.strBgColor = e29;
            feedSkinData.strGradientColorBegin = e36;
            feedSkinData.strGradientColorEnd = e37;
            feedSkinData.strFrameZip = e38;
            feedSkinData.iFrameRate = c16;
            QzoneNewCardSkinService.F().X(true);
            if (i26 == 1) {
                VasLogReporter.getQzoneFeedsCard().report("H5 set feeds card to:" + feedSkinData.sSkinId);
                QzoneNewCardSkinService.F().Z(uin, feedSkinData, 0);
                QzoneNewCardSkinService.F().J(LoginData.getInstance().getUin(), null);
            }
            EventCenter.getInstance().post("Feed", 16, (Object[]) null);
            EventCenter.getInstance().post("Detail", 4, (Object[]) null);
            return;
        }
        if (e16.equals(QZoneJsConstants.QZonePersonalizeJsConstants.CARD_METHOD_DOWNLOADCARD)) {
            String string = extras.getString("cardDownloadUrl");
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneCardLogic" + f48611a, 2, "QZoneAppInterface prepare to download cardjs give cardDownloadUrl:" + string);
            }
            ResourcePreloader.b().l(string);
            return;
        }
        if (e16.equals(QZoneJsConstants.QZonePersonalizeJsConstants.PERSONALIZE_SWITCH_FINISHED)) {
            int i27 = extras.getInt("facade");
            int i28 = extras.getInt("feedskin");
            int i29 = extras.getInt("avatar");
            int i36 = extras.getInt("floatObject");
            int i37 = extras.getInt("naviDeco");
            int i38 = extras.getInt("customvip");
            int i39 = extras.getInt("praise");
            int i46 = extras.getInt("player");
            int i47 = extras.getInt("isAfter785", 0);
            int i48 = extras.getInt(QZoneJsConstants.METHOD_CLEAR_DIY);
            if (i27 != -1) {
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "set facade = " + i27);
                }
                i3 = i46;
                LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_20", i27, LoginData.getInstance().getUin());
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.misc.web.QZoneWebPluginHandler.3
                    @Override // java.lang.Runnable
                    public void run() {
                        h.l().y();
                    }
                });
            } else {
                i3 = i46;
            }
            int i49 = -1;
            if (i28 != -1) {
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "set feedskin = " + i28);
                }
                FeedSkinData feedSkinData2 = new FeedSkinData(1);
                if (i47 == 1) {
                    QZLog.i(f48611a, 1, "PERSONALIZE_SWITCH_FINISHED set feedskin = " + i28);
                    QzoneNewCardSkinService.F().J(LoginData.getInstance().getUin(), null);
                    QzoneNewCardSkinService.F().Q(LoginData.getInstance().getUin(), feedSkinData2);
                    VasLogReporter.getQzoneFeedsCard().report("H5 reset feeds card to :" + i28);
                }
                LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_18", i28, LoginData.getInstance().getUin());
                VasLogReporter.getQzoneFeedsCard().report("CARDDECORATE_SP_KEY switch close, value is id:" + i28);
                EventCenter.getInstance().post("Feed", 16, (Object[]) null);
                EventCenter.getInstance().post("Detail", 4, (Object[]) null);
                i49 = -1;
            }
            if (i29 != i49) {
                if (QZLog.isColorLevel()) {
                    i17 = 2;
                    QZLog.i(f48611a, 2, "set avatar = " + i29);
                } else {
                    i17 = 2;
                }
                LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_19", i29, LoginData.getInstance().getUin());
                EventCenter.getInstance().post("Personalize", i17, (Object[]) null);
                i49 = -1;
            }
            if (i36 != i49) {
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "set floatObject = " + i36);
                }
                LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_21", i36, LoginData.getInstance().getUin());
                EventCenter.getInstance().post("Personalize", 11, (Object[]) null);
                i49 = -1;
            }
            if (i37 != i49) {
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "set naviDeco = " + i37);
                }
                LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_22", i36, LoginData.getInstance().getUin());
                EventCenter.getInstance().post("Personalize", 15, (Object[]) null);
                i49 = -1;
            }
            if (i38 != i49) {
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "set customvip = " + i38);
                }
                LocalMultiProcConfig.putInt4Uin("key_personalize_prefix_23", i38, LoginData.getInstance().getUin());
                EventCenter.getInstance().post("Personalize", 18, (Object[]) null);
                i49 = -1;
            }
            if (i39 != i49) {
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "set customPraise = " + i38);
                }
                EventCenter.getInstance().post("Personalize", 19, (Object[]) null);
                i49 = -1;
            }
            if (i3 != i49) {
                if (QZLog.isColorLevel()) {
                    QZLog.i(f48611a, 2, "set customPlayer = " + i3);
                }
                i16 = -1;
                h(-1, -1L, null);
            } else {
                i16 = i49;
            }
            if (i48 == i16 || !QZLog.isColorLevel()) {
                return;
            }
            QZLog.i(f48611a, 2, "set diy home = " + i48);
            QzoneDIYService.L().H(LoginData.getInstance().getUin());
            return;
        }
        if (e16.equals("SetFacade")) {
            if (c(extras, "showonfridyn", 0) != 0) {
                h.l().w(false);
                h.l().u(true, true);
            }
            h.l().x(null);
            EventCenter.getInstance().post("Personalize", 2, (Object[]) null);
            return;
        }
        if (e16.equals(QZoneJsConstants.QZonePersonalizeJsConstants.CUSTOM_VIP_SETTING)) {
            EventCenter.getInstance().post("Personalize", 17, Integer.valueOf(c(extras, "CustomVipId", -1)), e(extras, "zipUrl", ""));
        } else {
            if (QZoneJsConstants.QZonePersonalizeJsConstants.CUSTOM_PLAYER_SETTING.equals(e16)) {
                h(c(extras, "itemId", -1), d(extras, "textColor", 1L), e(extras, "playerDecoUrl", ""));
                return;
            }
            if (QZoneJsConstants.METHOD_SETFRIENDNAVIDECO.equals(e16)) {
                g(extras);
            } else if (QZoneJsConstants.METHOD_REFRESH_FEED.equals(e16)) {
                n();
            } else if (QZoneJsConstants.QZonePersonalizeJsConstants.REFRESH_COMMOM_LIST.equals(e16)) {
                QzoneBarrageEffectService.G().F(LoginData.getInstance().getUin(), null);
            }
        }
    }

    private static void n() {
        RFWLog.d(f48611a, RFWLog.USR, "refreshFeed: EVENT_PERSONAL_FEED_REFRESH");
        EventCenter.getInstance().post("Personalize", 23, (Object[]) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(int i3, String[] strArr) {
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "sendToJsResForAvatarDownload|ret:" + i3);
        }
        Intent intent = new Intent(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_FACADE_QZONE_TO_JS);
        Bundle bundle = new Bundle();
        bundle.putInt("ret", i3);
        if (strArr != null && strArr.length == 2) {
            bundle.putString("imgDir", strArr[0]);
            bundle.putString("imgNameList", strArr[1]);
        }
        intent.putExtras(bundle);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void f(Activity activity, Intent intent) {
        int i3;
        String str;
        int i16;
        if (intent == null) {
            return;
        }
        if (intent.getAction() != null) {
            if (intent.getAction().equals(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_PERSONALIZE_JS_TO_QZONE)) {
                m(activity, intent);
                return;
            }
            if (intent.getAction().equals(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_FACADE_JS_TO_QZONE)) {
                i(activity, intent);
                return;
            }
            if (intent.getAction().equals(QZoneJsConstants.QZonePersonalizeJsConstants.ACTION_WEB_JS_TO_QZONE)) {
                Bundle extras = intent.getExtras();
                String e16 = e(extras, "cmd", "");
                if ("Schema".equalsIgnoreCase(e16)) {
                    String e17 = e(extras, QZoneDTLoginReporter.SCHEMA, "");
                    QLog.i(f48611a, 1, "schema is " + e17);
                    d.d(e17, activity, null);
                    return;
                }
                if (e16.equals(QZoneJsConstants.QZonePersonalizeJsConstants.ZEBARALBUM_METHOD_CLEANZEBRANUM)) {
                    k(activity, intent);
                    return;
                }
                if (QZoneJsConstants.METHOD_WRITEBLOGSUCCESS.equalsIgnoreCase(e16)) {
                    j(activity, extras);
                    return;
                }
                if (QZoneJsConstants.METHOD_H5PAY_SUCESS.equalsIgnoreCase(e16)) {
                    l();
                    return;
                } else {
                    if (QZoneJsConstants.QZonePersonalizeJsConstants.FLOAT_METHOD_SETFLOAT.equalsIgnoreCase(e16)) {
                        final String e18 = e(extras, "data", "");
                        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.misc.web.QZoneWebPluginHandler.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.qzone.personalize.business.b.n().x(LoginData.getInstance().getUin(), e18);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            return;
        }
        Bundle extras2 = intent.getExtras();
        String e19 = e(extras2, "cmd", "");
        if ("Schema".equalsIgnoreCase(e19)) {
            d.e(e(extras2, QZoneDTLoginReporter.SCHEMA, ""), activity, null, new HashMap());
            return;
        }
        if (QZoneJsConstants.METHOD_TROOP_ALBUM_PICK_QZONE_ALBUM.equals(e19)) {
            if (!CacheManager.isExternalAvailable()) {
                ToastUtil.n(R.string.gp_);
                return;
            }
            String e26 = e(extras2, "troopId", "");
            int i17 = extras2.getInt("type");
            String str2 = "qunGetFeeds";
            if (i17 == 4) {
                i3 = 3;
            } else {
                if (i17 == 1) {
                    str = "qunGetFeeds";
                    i16 = 1;
                    Intent E = ak.E(activity, i16, e26, null, str, 14);
                    E.putExtra("IsBack", true);
                    E.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, i17);
                    if (!lc.b.d()) {
                        i.x().l(activity, new QZAlbumxUploadAlbumInitBean(LoginData.getInstance().getUinString(), 0, true, null, 0), E);
                        return;
                    } else {
                        com.qzone.feed.utils.b.d(activity, E);
                        return;
                    }
                }
                i3 = 0;
                str2 = "4";
            }
            i16 = i3;
            str = str2;
            Intent E2 = ak.E(activity, i16, e26, null, str, 14);
            E2.putExtra("IsBack", true);
            E2.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_TYPE, i17);
            if (!lc.b.d()) {
            }
        } else if (QZoneJsConstants.METHOD_FAMOUST_SHOW_DIALOG.equals(e19)) {
            new QZoneFamousShareHandler(activity, intent).H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            if (QZLog.isColorLevel()) {
                QZLog.i(QZoneWebPluginHandler.f48611a, 2, "onImageCanceled|sendToJsResForAvatarDownload");
            }
            QZoneWebPluginHandler.o(1, null);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            if (QZLog.isColorLevel()) {
                QZLog.i(QZoneWebPluginHandler.f48611a, 2, "onImageFailed|sendToJsResForAvatarDownload");
            }
            QZoneWebPluginHandler.o(1, null);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            boolean n3 = p6.b.n(str);
            if (QZLog.isColorLevel()) {
                QZLog.i(QZoneWebPluginHandler.f48611a, 2, "onImageLoaded|sendToJsResForAvatarDownload|createStaticFile is " + n3);
            }
            QZoneWebPluginHandler.o(0, null);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
