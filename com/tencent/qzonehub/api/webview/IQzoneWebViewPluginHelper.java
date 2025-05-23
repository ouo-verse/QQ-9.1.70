package com.tencent.qzonehub.api.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.model.Size;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelperCallBack;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import java.io.File;
import java.util.Map;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQzoneWebViewPluginHelper extends QRouteApi {
    public static final String ACTION_HANDLE_QUN_DETAIL_DELETE = "cooperation.qzone.webviewplugin.QzoneQunFeedJsPlugin.handleQunDetailDelete";
    public static final String ACTION_NOTIFY_ADV_PLAY = "QZONE.ACTION_NOTIFY_ADV_PLAY";
    public static final String ACTION_OPEN_KAPU_HOST_MESSAGE_SETTING = "QzoneUserHome.ACTION_openKapuHostMsg";
    public static final String ACTION_OPEN_MESSAGE_BOARD = "QzoneUserHome.ACTION_openMsgBoard";
    public static final String ACTION_PICK_GAME_MATES = "qzone.pickgamemates";
    public static final String ACTION_VIDEO_COVER_SETTING = "com.tencent.mobileqq.action.ACTION_VIDEO_COVER_SETTING";
    public static final String AVATAR_SP_KEY = "key_personalize_prefix_19";
    public static final String BROADCAST_PERMISSION = "com.tencent.msg.permission.pushnotify";
    public static final String CARDDECORATE_SP_KEY = "key_personalize_prefix_18";
    public static final String CUSTOM_VIP_KEY = "key_personalize_prefix_23";
    public static final String DYNAMIC_ALBUM_LOCAL_IMAGE = "https://www.dynamicalbumlocalimage.com";
    public static final String EXTRA_FAMOUS_IS_FOLLOWED = "is_followed";
    public static final String EXTRA_FAMOUS_SHARE_BACKGROUND_URL = "background_url";
    public static final String EXTRA_FAMOUS_SHARE_DESCPTION = "descption";
    public static final String EXTRA_FAMOUS_SHARE_DETAIL_URL = "detail_url";
    public static final String EXTRA_FAMOUS_SHARE_FANS_COUNT = "fans_count";
    public static final String EXTRA_FAMOUS_SHARE_H5_DETAIL_URL = "h5_detail_url";
    public static final String EXTRA_FAMOUS_SHARE_NICKNAME = "nick_name";
    public static final String EXTRA_FAMOUS_SHARE_QRCODE_URL = "qrcode_url";
    public static final String EXTRA_FAMOUS_SHARE_SCHEMA_DETAIL_URL = "schema_detail_url";
    public static final String EXTRA_FAMOUS_SHARE_SUMMARY = "summary";
    public static final String EXTRA_FAMOUS_SHARE_THUMB_PHOTO_URL = "thumb_photo_url";
    public static final String EXTRA_FAMOUS_SHARE_TITLE = "title";
    public static final String EXTRA_FAMOUS_SHARE_VISITOR_COUNT = "visitor_count";
    public static final String EXTRA_FAMOUS_SHOW_REPORT_MENU = "show_report";
    public static final String EXTRA_FAMOUS_UIN = "famous_uin";
    public static final String FACADE_SP_KEY = "key_personalize_prefix_20";
    public static final String FLOATOBJECT_SP_KEY = "key_personalize_prefix_21";
    public static final String KEY_CALLBACK = "callback";
    public static final String KEY_KAPU_HOST_MESSAGE_SETTING = "text";
    public static final String KEY_OPEN_MESSAGE_BOARD = "openMsgBoard";
    public static final String KEY_PERSONALIZE_PREFIX = "key_personalize_prefix";
    public static final String KEY_RECOMM_CHAT_CACHE_PHOTO = "recommendChatCachePhoto_on";
    public static final String KEY_RESULT = "ret";
    public static final String KEY_UPDATE_MESSAGE_BOARD = "updateMsgBoard";
    public static final String KEY_WEB_PICTURE_ATTACHINFO = "mood_web_pic_attachinfo";
    public static final String KEY_WEB_PICTURE_HEIGHT = "mood_web_pic_height";
    public static final String KEY_WEB_PICTURE_ID = "mood_web_pic_id";
    public static final String KEY_WEB_PICTURE_SOURCEID = "mood_web_pic_sourceid";
    public static final String KEY_WEB_PICTURE_URL = "mood_web_pic_url";
    public static final String KEY_WEB_PICTURE_WIDTH = "mood_web_pic_width";
    public static final String MUSIC_METHOD_NAMESPACE = "QzMoodSelectPicture";
    public static final String NAVIDECO_SP_KEY = "key_personalize_prefix_22";
    public static final int OPEN_WHAT_MOBILE_ALUBM = 0;
    public static final int OPEN_WHAT_QZONE_ALBUM = 1;
    public static final int OPEN_WHAT_QZONE_VIDEO = 5;
    public static final int OPEN_WHAT_SET_COVER = 4;
    public static final int OPEN_WHAT_SET_LOCAL_COVER = 6;
    public static final int OPEN_WHAT_SET_NAVI_DECO = 7;
    public static final int OPEN_WHAT_SET_WIDGET_ENABLE = 3;
    public static final int OPEN_WHAT_SET_WIDGET_ID = 2;
    public static final String PERMISSION = "com.tencent.msg.permission.pushnotify";
    public static final int RESULT_OK = -1;
    public static final String STR_GAMEMATES = "gamemates";
    public static final int UPDATE_MSG_COUNT = 1;
    public static final int UPDATE_MSG_COUNT_AND_BULLET_SCREEN = 2;
    public static final int mAvatarId = 19;
    public static final int mCardId = 18;
    public static final int mCustomVip = 23;
    public static final int mFacadeId = 20;
    public static final int mFloatObjectId = 21;
    public static final int mNaviDeco = 22;
    public static final String select_picture_func_name = "selectPicture";

    boolean checkOfflineUrl(String str);

    File downLoadFileIfNeeded(AppInterface appInterface, String str, QzoneOfflineCacheHelperCallBack qzoneOfflineCacheHelperCallBack, boolean z16, String str2);

    String encodeBase64File(String str, int i3, int i16);

    Size getBitmapSize(String str);

    Map<Integer, Long> getCTime(Long l3);

    Object getQzoneWebViewBaseBuilder(Context context, Activity activity, Intent intent, AppInterface appInterface, boolean z16, WebView webView);

    Object getQzoneWebViewOfflinePlugin();

    Object getQzoneWebViewPlugin();

    double getRatio(Context context, int i3, Size size);

    IWebviewWrapper getWebviewWrapper(Context context);

    void notifyWebviewStartAnimation(WebView webView);

    void savePayActionResult(WebViewProvider webViewProvider, String str);

    void updateCTime(Integer num, Long l3);
}
