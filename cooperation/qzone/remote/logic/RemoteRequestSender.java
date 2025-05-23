package cooperation.qzone.remote.logic;

import NS_QMALL_COVER.AlbumThemeSkin;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.service.message.s;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.model.DiscoverTab;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RemoteRequestSender implements RemoteHandleConst {
    private static final String TAG = "cooperation.qzone.remote.logic.RemoteRequestSender";
    private RemoteHandleManager manager;

    public RemoteRequestSender(RemoteHandleManager remoteHandleManager) {
        this.manager = remoteHandleManager;
    }

    public int UpdatePloymorphicPraise(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_PLOYMORPHIC_PRAISE_DATA, str);
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_UPDATE_PLOYMORPHIC_PRAISE, bundle, false);
    }

    public void cancelAllupload() {
        this.manager.sendData(RemoteHandleConst.CMD_CANCEL_PRELOAD, new Bundle(), true);
    }

    public void cancelDownloadTroopPhoto(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, str);
        this.manager.sendData(RemoteHandleConst.CMD_TROOP_CANCEL_DOWNLOAD_PHOTO, bundle, false);
    }

    public void deletePrePostDynamicAlbum() {
        this.manager.sendData(RemoteHandleConst.CMD_DELETE_PREPOST_DYNAMIC_ALBUM, new Bundle(), true);
    }

    public void deleteTempVideo(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_RECORD_TEMP_VIDEO_PATH, str);
        this.manager.sendData(RemoteHandleConst.CMD_VIDEO_DELETE_TEMP_VIDEO, bundle, false);
    }

    public void deleteTimerShuoShuo() {
        this.manager.sendData(RemoteHandleConst.CMD_DELETE_TIMER_SHUOSHUO, null, false);
    }

    public void downloadGift(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTID, str);
        bundle.putString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTURL, str2);
        bundle.putString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTMD5, str3);
        this.manager.sendData(RemoteHandleConst.CMD_DOWNLOADGIFT, bundle, true);
    }

    public void downloadPassivePraise(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTID, str);
        bundle.putString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTURL, str2);
        this.manager.sendData(RemoteHandleConst.CMD_DOWNLOAD_PASSIVE_PRAISE, bundle, true);
    }

    public void downloadTroopPhoto(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, str);
        this.manager.sendData(RemoteHandleConst.CMD_TROOP_DOWNLOAD_PHOTO, bundle, true);
    }

    public void downloadVideo(String str) {
        downloadVideo(str, new Bundle());
    }

    public void enableFirstDynamicPreUpload() {
        this.manager.sendData(RemoteHandleConst.CMD_ENABLE_UPLOAD_FIRST_DYNAMIC_PHOTO, new Bundle(), true);
    }

    public void gdtAdvReportFromWebViewPlug(Map<Integer, String> map, int i3, int i16, long j3, long j16) {
        final Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        bundle.putSerializable(RemoteHandleConst.PARAM_FEED_DATA_COOKIE, arrayList);
        bundle.putInt(RemoteHandleConst.PARAM_REPORT_POSITION, i3);
        bundle.putInt(RemoteHandleConst.PARAM_ACTION_EXPECTATION, i16);
        bundle.putLong("costTime", j3);
        bundle.putLong("error_code", j16);
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.remote.logic.RemoteRequestSender.1
            @Override // java.lang.Runnable
            public void run() {
                RemoteRequestSender.this.manager.sendData(RemoteHandleConst.CMD_WEBVIEW_GDT_REPORT, bundle, false);
            }
        }, 2, null, false);
    }

    public void getCloudPhotoDynamic(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_CLOUD_DYNAMIC_CMD, str);
        this.manager.sendData(RemoteHandleConst.CMD_GET_DYNAMIC_CLOUD_PHOTO, bundle, true);
    }

    public void getDeviceInfos() {
        this.manager.sendData(RemoteHandleConst.CMD_GET_DEVICE_INFOS, null, true);
    }

    public void getDynamicPhoto(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_DYNAMIC_CMD, str);
        this.manager.sendData(RemoteHandleConst.CMD_GET_DYNAMIC_PHOTO, bundle, true);
    }

    public void getDynamicselNum(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_DYNAMIC_CMD, str);
        this.manager.sendData(RemoteHandleConst.CMD_GET_DYNAMIC_SELNUM, bundle, true);
    }

    public void getFakeFeedVideoCover(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_VIDEO_CLIENT_KEY, str);
        this.manager.sendData(RemoteHandleConst.CMD_VIDEO_GET_FAKE_FEED_COVER, bundle, true);
    }

    public void getHistoryEventTag() {
        this.manager.sendData(RemoteHandleConst.CMD_GET_HISTORY_EVENT_TAG, null, true);
    }

    public void getLivingInfo() {
        this.manager.sendData(RemoteHandleConst.CMD_GET_LIVING_INFO, null, true);
    }

    public void getPlayMode() {
        this.manager.sendData(RemoteHandleConst.CMD_GET_PLAY_MODE, null, true);
    }

    public void getPlayingSong() {
        this.manager.sendData(RemoteHandleConst.CMD_GET_PLAYING_SONG, null, true);
    }

    public void getQuickMakeDynamicStatus() {
        this.manager.sendData(RemoteHandleConst.CDM_GET_QUICK_MAKE_DYNAMIC_STATUS, null, true);
    }

    public void getVideoLocalProxyUrl(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(RemoteHandleConst.PARAM_VIDEO_REMOTE_URLS, arrayList);
        bundle.putStringArrayList(RemoteHandleConst.PARAM_VIDEO_ID, arrayList2);
        this.manager.sendData(RemoteHandleConst.CMD_VIDEO_GET_LOCAL_PROXY_URL, bundle, true);
    }

    public void getWnsProxyData(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("web_hash_code", i3);
        this.manager.sendData(RemoteHandleConst.CMD_WEBVIEW_GET_PROXY_DATA, bundle, true);
    }

    public int handleUpdateFontList() {
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_UPDATE_FONT_LIST, new Bundle(), false);
    }

    public void initUserInfo() {
        this.manager.sendData(RemoteHandleConst.CMD_INIT_USERINFO, null, false);
    }

    public int notifyBarrageEffectChanged(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z16);
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_BARRAG_EEFFECT_CHANGED, bundle, false);
    }

    public int notifyCustomBrowserChanged(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z16);
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_UPDATE_CUSTOM_BROWSER_INFO, bundle, false);
    }

    public int notifyFeedSkinSwitchChagned() {
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_FEED_SKIN_SWITCH_CHANGED, null, false);
    }

    public int notifyFontChanged(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z16);
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_FONT_CHANGED, bundle, false);
    }

    public void notifyPlayListChange() {
        this.manager.sendData(RemoteHandleConst.CMD_NOTIFY_PLAYLIST_CHANGE, null, false);
    }

    public int notifySuperFontChanged(boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("value", z16);
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_SUPERFONT_CHANGED, bundle, false);
    }

    public void onDynamicPageDestroy() {
        this.manager.sendData(RemoteHandleConst.CMD_DYNAMIC_DESTORY, null, true);
    }

    public void onShowDiscoverTab(DiscoverTab discoverTab) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("tab", discoverTab);
        this.manager.sendData(RemoteHandleConst.CMD_DISCOVER_SHOW_TAB, bundle, false);
    }

    public void pausePlay() {
        this.manager.sendData(RemoteHandleConst.CMD_PAUSE_PLAY, null, false);
    }

    public void playAudioList(long j3, int i3, int i16, ArrayList<SongInfo> arrayList, int i17) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putInt(RemoteHandleConst.PARAM_PALY_ORIGIN, i3);
        bundle.putInt("param.index", i16);
        bundle.putSerializable(RemoteHandleConst.PARAM_SONG_LIST, arrayList);
        bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE, i17);
        this.manager.sendData(RemoteHandleConst.CMD_PLAY_AUDIO_LIST, bundle, false);
    }

    public void playFmBroadCastList(long j3, int i3, int i16, ArrayList<SongInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putInt(RemoteHandleConst.PARAM_PALY_ORIGIN, i3);
        bundle.putInt("param.index", i16);
        bundle.putSerializable(RemoteHandleConst.PARAM_SONG_LIST, arrayList);
        this.manager.sendData(RemoteHandleConst.CMD_PLAY_FM_BROADCAST_LIST, bundle, false);
    }

    public void playMusicList(long j3, int i3, int i16, ArrayList<SongInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putInt(RemoteHandleConst.PARAM_PALY_ORIGIN, i3);
        bundle.putInt("param.index", i16);
        bundle.putSerializable(RemoteHandleConst.PARAM_SONG_LIST, arrayList);
        this.manager.sendData(RemoteHandleConst.CMD_PLAY_MUSIC_LIST, bundle, false);
    }

    public int pregetPassiveFeeds(long j3) {
        Bundle bundle = new Bundle();
        bundle.putLong("uin", j3);
        return this.manager.sendData(RemoteHandleConst.CMD_PRE_GET_PASSIVE_FEEDS, bundle, true);
    }

    public void refreshPassiveFeeds() {
        this.manager.sendData(RemoteHandleConst.CMD_REFRESH_PASSIVE_FEEDS, null, false);
    }

    public void refreshWeishiMedalStatus(long j3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putLong("uin", j3);
        bundle.putInt("isHide", i3);
        this.manager.sendData(RemoteHandleConst.CMD_REFRESH_WEISHI_MEDAL_STATUS, bundle, false);
    }

    public void resumePlay() {
        this.manager.sendData(RemoteHandleConst.CMD_RESUME_PLAY, null, false);
    }

    public void selectEventTag(Bundle bundle) {
        this.manager.sendData(RemoteHandleConst.CMD_SELECT_EVENT_TAG, bundle, false);
    }

    public void sendCloudDynmicPhotoSuccess(ArrayList<QzonePhotoInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST, arrayList);
        this.manager.sendData(RemoteHandleConst.CMD_DYNAMIC_CLOUD_PHOTO_SEND_SUCCESS, bundle, true);
    }

    public void setAlbumTheme(long j3, AlbumThemeSkin albumThemeSkin) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putSerializable(RemoteHandleConst.PARAM_ALBUM_THEME_DATA_RANDOM, albumThemeSkin);
        this.manager.sendData(RemoteHandleConst.CMD_ALUMB_THEME, bundle, false);
    }

    public void setHistoryEventTagData(Bundle bundle) {
        if (bundle != null) {
            this.manager.sendData(RemoteHandleConst.CMD_SET_HISTORY_EVENT_TAG, bundle, false);
        } else {
            this.manager.sendData(RemoteHandleConst.CMD_SET_HISTORY_EVENT_TAG, null, false);
        }
    }

    public void setPlayMode(long j3, int i3, int i16, int i17) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, i3);
        bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_AUTO, i16);
        bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_LOOP, i17);
        this.manager.sendData(RemoteHandleConst.CMD_SAVE_PLAY_MODE, bundle, false);
    }

    public void setQuickMakeDynamicStatus(Bundle bundle) {
        this.manager.sendData(RemoteHandleConst.CDM_SET_QUICK_MAKE_DYNAMIC_STATUS, bundle, false);
    }

    public void setUserTail(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_DEVICESTRDIYDEMO, str);
        bundle.putString(RemoteHandleConst.PARAM_DEVICESTRDEVICETAIL, str2);
        bundle.putString(RemoteHandleConst.PARAM_DEVICESTRDEVICEICON, str3);
        bundle.putString(RemoteHandleConst.PARAM_DEVICESTRIDENTIFYSQUA, str4);
        this.manager.sendData(RemoteHandleConst.CMD_SET_USER_TAIL, bundle, true);
    }

    public void setVideoState(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(RemoteHandleConst.PARAM_VIDEO_REMOTE_URLS, arrayList);
        bundle.putStringArrayList(RemoteHandleConst.PARAM_VIDEO_STATES, arrayList2);
        this.manager.sendData(RemoteHandleConst.CMD_VIDEO_SET_STATE, bundle, false);
    }

    public void startWnsProxyRequestWithCheck(DiscoverTab discoverTab) {
        QLog.d("QZoneDiscoverActivity", 2, "startWebSoRequestWithCheck name:" + discoverTab.name);
        Bundle bundle = new Bundle();
        bundle.putParcelable("tab", discoverTab);
        this.manager.sendData(RemoteHandleConst.CMD_DISCOVER_START_WNS_PROXY_RERQUEST, bundle, false);
    }

    public void stopAllVideo() {
        this.manager.sendData(RemoteHandleConst.CMD_VIDEO_STOP_ALL, null, false);
    }

    public void stopPlay() {
        this.manager.sendData(RemoteHandleConst.CMD_STOP_PLAY, null, false);
    }

    public void syncWithSignIn(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_TEXT_CONTENT, str);
        bundle.putString(RemoteHandleConst.PARAM_SIGNIN_PICTURE_URL, str2);
        bundle.putString(RemoteHandleConst.PARAM_FONT_ID, str3);
        bundle.putString(RemoteHandleConst.PARAM_FONT_URL, str4);
        this.manager.sendData(RemoteHandleConst.CMD_SYNC_WECHAT_WITH_SIGNIN, bundle, false);
    }

    public int updateCustomPraise(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_CUSTOM_PRAISE_DATA, str);
        return this.manager.sendData(RemoteHandleConst.CMD_QZONE_UPDATE_CUSTOM_PRAISE, bundle, false);
    }

    public void updateDynamicAlbumInfo(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString("music_id", str);
        bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID, str2);
        bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START, str3);
        bundle.putString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE, str4);
        this.manager.sendData(RemoteHandleConst.CMD_UPDATE_DYNAMIC_ALBUM_INFO, bundle, true);
    }

    public void updateFriendSetting(String str, String str2, long j3) {
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        bundle.putString("value", str2);
        bundle.putLong("uin", j3);
        this.manager.sendData(RemoteHandleConst.CMD_UPDATE_FRIEND_SETTING, bundle, false);
    }

    public void updateSchoolCertificate(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        try {
            if (new JSONObject(str).optInt("certificateResult") == 1) {
                if (str2.equals("notifyCampusFriendCertificateResult")) {
                    LocalMultiProcConfig.putInt4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_VERFYSTATUS, 2, Long.valueOf(str3).longValue());
                } else if (str2.equals("notifyUploadSutudentIDResult")) {
                    LocalMultiProcConfig.putInt4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_VERFYSTATUS, 1, Long.valueOf(str3).longValue());
                }
            }
        } catch (JSONException e16) {
            QLog.i(TAG, 1, "updateSchoolCertificate exception", e16);
        }
    }

    public void updateSchoolinfo(Bundle bundle, String str) {
        if (!TextUtils.isEmpty(str)) {
            LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOLNAME, bundle.getString("name"), Long.valueOf(str).longValue());
            LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOL_ID, bundle.getString("schoolid"), Long.valueOf(str).longValue());
            LocalMultiProcConfig.putString4Uin(LocalMultiProcConfig.QZONE_CAMPUSINFO_SCHOOL_IDX, bundle.getString("idx"), Long.valueOf(str).longValue());
        }
    }

    public void uploadFirstDynamicPhoto(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_FIRST_DYNAMIC_PHOTO_PATH, str);
        bundle.putInt(RemoteHandleConst.PARAM_DYNAMIC_TOTAL_PHOTO_SIZE, i3);
        this.manager.sendData(RemoteHandleConst.CMD_UPLOAD_FIRST_DYNAMIC_PHOTO, bundle, true);
    }

    public int uploadTroopPhotos(String str, String str2, String str3, String str4, String str5, int i3, ArrayList<String> arrayList, Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString(QZoneHelper.Constants.KEY_QUN_ID, str2);
        bundle.putString(QZoneHelper.Constants.KEY_QUN_NAME, str3);
        bundle.putString("UploadPhoto.key_album_id", str4);
        bundle.putString("UploadPhoto.key_album_name", str5);
        bundle.putString("refer", "mqqChat");
        if (i3 != 0) {
            if (i3 == 2) {
                i3 = 3;
            }
        } else {
            i3 = 0;
        }
        bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", arrayList);
        bundle.putInt(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY, i3);
        String valueOf = String.valueOf(s.a());
        bundle.putString(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY, valueOf);
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = str;
        bundle.putString("qzone_uin", str);
        bundle.putString("nickname", userInfo.nickname);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY, valueOf);
        return this.manager.sendData(RemoteHandleConst.CMD_UPLOAD_TROOP_PHOTOS, bundle, true);
    }

    public void uploadVideoForH5(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_VIDEO_FOR_H5_JSON, str);
        this.manager.sendData(RemoteHandleConst.CMD_VIDEO_UPLOAD_FOR_H5, bundle, false);
    }

    public void downloadVideo(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(RemoteHandleConst.PARAM_VIDEO_REMOTE_URLS, str);
        this.manager.sendData(RemoteHandleConst.CMD_VIDEO_DOWNLOAD, bundle, true);
    }

    public void uploadFirstDynamicPhoto(String str, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST_ALBUMID, str);
        bundle.putString(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST_LLOC, str2);
        bundle.putString(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST, str3);
        bundle.putBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_ALBUM, true);
        bundle.putInt(RemoteHandleConst.PARAM_DYNAMIC_TOTAL_PHOTO_SIZE, i3);
        this.manager.sendData(RemoteHandleConst.CMD_UPLOAD_FIRST_DYNAMIC_PHOTO, bundle, true);
    }
}
