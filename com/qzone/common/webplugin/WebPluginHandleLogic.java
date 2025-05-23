package com.qzone.common.webplugin;

import FACADE_DIY.UserFacadeInfo;
import NS_QMALL_COVER.AlbumThemeSkin;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import com.heytap.databaseengine.apiv3.data.Element;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.album.protocol.QzoneDeleteDynamicAlbumRequest;
import com.qzone.app.QZoneAppInterface;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.business.gift.business.service.QzoneGiftDownloadService;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.homepage.diy.protocol.QzoneDIYData;
import com.qzone.homepage.diy.util.QzoneDIYService;
import com.qzone.misc.network.downloader.i;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.business.QzoneZipDownloadService;
import com.qzone.personalize.model.CustomHighFiveData;
import com.qzone.personalize.music.ui.HomepageMusicPlayerBar;
import com.qzone.preview.service.ServiceCmd;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.service.QzonePolymorphicPraiseService;
import com.qzone.proxy.feedcomponent.text.QzoneFontManager;
import com.qzone.proxy.feedcomponent.text.font.FontManager;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.qzone.publish.business.publishqueue.PublishQueueService;
import com.qzone.publish.business.publishqueue.QZonePreUploadInfo;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.QZoneUploadFirstDynamicPhotoTask;
import com.qzone.publish.business.task.QZoneUploadH5VideoTask;
import com.qzone.publish.service.PersonalFontService;
import com.qzone.publish.service.QzoneSuperPersonalFontService;
import com.qzone.publish.utils.a;
import com.qzone.util.ToastUtil;
import com.qzone.util.ag;
import com.qzone.util.image.ImageInfo;
import com.qzone.util.l;
import com.qzone.video.service.QzoneVideoPerfReport;
import com.tencent.ark.ark;
import com.tencent.biz.richframework.util.RFWSaveUtil;
import com.tencent.biz.richframework.util.bean.RFWSaveMediaResultBean;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.video.BaseVideoManager;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.open.base.MD5Utils;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.qzonehub.api.IQzoneShareApi;
import com.tencent.qzonehub.api.font.IFontManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.album.QzonePhotoInfo;
import cooperation.qzone.cache.QZoneFilePath;
import cooperation.qzone.font.DefaultFontInfo;
import cooperation.qzone.font.DefaultSuperFontInfo;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.model.DiscoverTab;
import cooperation.qzone.remote.SendMsg;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVerticalVideoTopicInfo;
import cooperation.qzone.webviewplugin.QZoneEventTagJsPlugin;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.widget.RedTouchExtendButton;
import e8.e;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tk.h;

/* loaded from: classes39.dex */
public class WebPluginHandleLogic implements RemoteHandleConst {
    public static final int AIO_UP_WAY = 41;
    private static final int MAX_INPUT_SIZE = 10000;
    private static final String TAG = "WebPluginHandleLogic";
    private static final int UPLOAD_ENTRANCE_CAMERA = 35;
    private static final int UPLOAD_ENTRANCE_PERSONAL_SIGNATURE = 29;
    private HashMap<String, com.qzone.misc.web.a> downLoadStateHashMap = new HashMap<>();
    Handler innerHandler;

    /* loaded from: classes39.dex */
    class a implements QzoneFontManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f46138a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f46139b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f46140c;

        /* renamed from: com.qzone.common.webplugin.WebPluginHandleLogic$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class C0371a implements a.b {
            C0371a() {
            }

            @Override // com.qzone.publish.utils.a.b
            public void a(Bitmap bitmap) {
                String str = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                StringBuilder sb5 = new StringBuilder();
                String str2 = IQzoneShareApi.PHOTO_PATH;
                sb5.append(str2);
                sb5.append(str);
                String sb6 = sb5.toString();
                try {
                    File file = new File(str2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } catch (Throwable th5) {
                    QZLog.e(WebPluginHandleLogic.TAG, th5.getMessage());
                }
                com.qzone.util.image.c.V(bitmap, sb6, Bitmap.CompressFormat.JPEG, 100, true);
                ((IQzoneShareApi) QRoute.api(IQzoneShareApi.class)).shareImage(BaseApplication.getContext(), sb6, null, 1);
            }
        }

        a(String str, Map map, String str2) {
            this.f46138a = str;
            this.f46139b = map;
            this.f46140c = str2;
        }

        @Override // com.qzone.proxy.feedcomponent.text.QzoneFontManager.b
        public void a(Typeface typeface) {
            new com.qzone.publish.utils.a(BaseApplication.getContext(), this.f46138a, "", this.f46139b).d(this.f46140c, new C0371a());
        }
    }

    /* loaded from: classes39.dex */
    class b implements IQZoneServiceListener {
        b() {
        }

        @Override // com.qzone.common.business.IQZoneServiceListener
        public void onTaskResponse(QZoneTask qZoneTask) {
        }
    }

    /* loaded from: classes39.dex */
    class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f46144a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f46145b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SendMsg f46146c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Looper looper, int i3, Handler handler, SendMsg sendMsg) {
            super(looper);
            this.f46144a = i3;
            this.f46145b = handler;
            this.f46146c = sendMsg;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 203) {
                QZoneResult unpack = QZoneResult.unpack(message);
                Bundle bundle = new Bundle(unpack.getBundle());
                bundle.putInt("web_hash_code", this.f46144a);
                bundle.putBoolean("wns_html_success", unpack.getSucceed());
                if (QZLog.isColorLevel()) {
                    QZLog.d(QZLog.WNS_HTML, 2, "WebPluginHandleLogic handleMessage susscess:" + unpack.getSucceed() + " url:" + bundle.getString("url"));
                }
                Message obtain = Message.obtain(this.f46145b, this.f46146c.getRequestId());
                obtain.obj = bundle;
                obtain.sendToTarget();
            }
        }
    }

    /* loaded from: classes39.dex */
    class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f46148a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SendMsg f46149b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f46150c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Looper looper, Handler handler, SendMsg sendMsg, String str) {
            super(looper);
            this.f46148a = handler;
            this.f46149b = sendMsg;
            this.f46150c = str;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Message obtain = Message.obtain(this.f46148a, this.f46149b.getRequestId());
            obtain.obj = message.obj;
            obtain.sendToTarget();
            WebPluginHandleLogic.this.downLoadStateHashMap.remove(this.f46150c);
        }
    }

    /* loaded from: classes39.dex */
    class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SendMsg f46152a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f46153b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Looper looper, SendMsg sendMsg, Handler handler) {
            super(looper);
            this.f46152a = sendMsg;
            this.f46153b = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 999911) {
                Bundle bundle = new Bundle();
                bundle.putInt(RemoteHandleConst.PARAM_PRE_GET_SUCCESS, message.arg1);
                Object obj = message.obj;
                if (obj != null && (obj instanceof Long)) {
                    bundle.putLong(RemoteHandleConst.PARAM_PRE_GET_UNDEALCOUNT, Long.valueOf(obj.toString()).longValue());
                }
                QZLog.i(WebPluginHandleLogic.TAG, 1, "pregetPassiveFeeds:restult:" + message.arg1 + ",undealcount:" + message.obj);
                bundle.putInt(RemoteHandleConst.PARAM_PRE_GET_SEQID, this.f46152a.getRequestId());
                Message obtain = Message.obtain(this.f46153b, this.f46152a.getRequestId());
                obtain.obj = bundle;
                obtain.sendToTarget();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoDownloadFailed(SendMsg sendMsg, Handler handler, String str, int i3, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("code", i3);
        bundle.putString("msg", str2);
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
        if ("1".equals(str)) {
            return;
        }
        ToastUtil.s(l.a(R.string.gkh), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleVideoDownloadSuccessfully(SendMsg sendMsg, Handler handler, String str, String str2) {
        String str3;
        Bundle bundle = new Bundle();
        bundle.putInt("code", 0);
        bundle.putString("msg", "success");
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
        RFWSaveUtil.insertMedia(BaseApplication.getContext(), str2, new g());
        if (!TextUtils.isEmpty(str2) && str2.contains(Environment.DIRECTORY_DCIM)) {
            str3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSaveToPhone", "\u89c6\u9891\u5df2\u4fdd\u5b58\u81f3\u624b\u673a\u76f8\u518c");
        } else {
            str3 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSaveToSDCard", "\u89c6\u9891\u5df2\u4fdd\u5b58\u81f3SD\u5361") + str2 + l.a(R.string.v0h);
        }
        if ("1".equals(str)) {
            return;
        }
        ToastUtil.s(str3, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleVideoDownload$0(final String str, final String str2, final SendMsg sendMsg, final Handler handler, final String str3, final int i3, final String str4) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.qzone.common.webplugin.WebPluginHandleLogic.7
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 != 0) {
                    WebPluginHandleLogic.this.handleVideoDownloadFailed(sendMsg, handler, str3, i16, str4);
                    return;
                }
                BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
                if (!com.qzone.reborn.configx.g.f53821a.b().M()) {
                    WebPluginHandleLogic.this.handleVideoDownloadSuccessfully(sendMsg, handler, str3, str);
                } else {
                    h.O(BaseApplication.getContext(), str, str2, true);
                }
            }
        });
    }

    private ArrayList<ImageInfo> toImageInfos(ArrayList<String> arrayList) {
        ArrayList<ImageInfo> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new ImageInfo(it.next()));
            }
        }
        return arrayList2;
    }

    @ServiceCmd(RemoteHandleConst.CMD_WEBVIEW_GDT_REPORT)
    public void advReoprtFromWebViewPlugin(SendMsg sendMsg) {
        Bundle extraData = sendMsg.getExtraData();
        ArrayList arrayList = (ArrayList) extraData.getSerializable(RemoteHandleConst.PARAM_FEED_DATA_COOKIE);
        int i3 = extraData.getInt(RemoteHandleConst.PARAM_REPORT_POSITION);
        int i16 = extraData.getInt(RemoteHandleConst.PARAM_ACTION_EXPECTATION);
        long j3 = extraData.getLong("costTime");
        long j16 = extraData.getLong("error_code");
        QZoneWriteOperationService.v0().K((Map) arrayList.get(0), i3, 0, 0, 0, i16, true, false, null, null, 0L, false, false, null, true, j3, null, j16);
    }

    @ServiceCmd(RemoteHandleConst.CMD_TROOP_CANCEL_DOWNLOAD_PHOTO)
    public void cancleDownLoadTroopbPhoto(SendMsg sendMsg) {
        String string = sendMsg.getExtraData().getString(ark.ARKMETADATA_JSON);
        String md5 = MD5Utils.toMD5(string);
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "cancleDownLoadTroopbPhoto:" + md5 + "," + string);
        }
        com.qzone.misc.web.a aVar = this.downLoadStateHashMap.get(md5);
        if (QZLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("cancleDownLoadTroopbPhoto:state==null:");
            sb5.append(aVar == null);
            QZLog.d(TAG, 2, sb5.toString());
        }
        if (aVar != null) {
            aVar.a();
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_VIDEO_DELETE_TEMP_VIDEO)
    public void deleteTempVideo(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_VIDEO_DELETE_TEMP_VIDEO");
        }
        String string = sendMsg.getExtraData().getString(RemoteHandleConst.PARAM_RECORD_TEMP_VIDEO_PATH);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        new File(string).delete();
    }

    @ServiceCmd(RemoteHandleConst.CMD_DELETE_TIMER_SHUOSHUO)
    public void deleteTimerShuoShuo(SendMsg sendMsg) {
        EventCenter.getInstance().post("TimerShuoShuo", 2, (Object[]) null);
    }

    @ServiceCmd(RemoteHandleConst.CMD_TROOP_DOWNLOAD_PHOTO)
    public void downloadTroopPhoto(SendMsg sendMsg, Handler handler) {
        String string = sendMsg.getExtraData().getString(ark.ARKMETADATA_JSON);
        String md5 = MD5Utils.toMD5(string);
        if (QZLog.isColorLevel() && QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "downloadTroopPhoto:" + md5 + "," + string);
        }
        if (this.downLoadStateHashMap.get(md5) != null) {
            return;
        }
        com.qzone.misc.web.a aVar = new com.qzone.misc.web.a(string, new d(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).getLooper(), handler, sendMsg, md5));
        this.downLoadStateHashMap.put(md5, aVar);
        aVar.b();
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_HISTORY_EVENT_TAG)
    public void getHistoryEventTag(SendMsg sendMsg, Handler handler) {
        y5.a H = y5.a.H();
        if (H != null) {
            H.F(sendMsg, handler);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_WEBVIEW_GET_PROXY_DATA)
    public void getProxyData(SendMsg sendMsg, Handler handler) {
        String string = sendMsg.getExtraData().getString("url");
        int i3 = sendMsg.getExtraData().getInt("web_hash_code");
        QZLog.d(QZLog.WNS_HTML, 2, "WebPluginHandleLogic getProxyData url:" + string);
        Message.obtain(handler, sendMsg.getRequestId());
        WebSoService.j().l(string, new c(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.RealTimeThread), i3, handler, sendMsg));
    }

    @ServiceCmd(RemoteHandleConst.CDM_GET_QUICK_MAKE_DYNAMIC_STATUS)
    public void getQuickMakeDynamicStatus(SendMsg sendMsg, Handler handler) {
        Bundle bundle = new Bundle();
        bundle.putInt("status", com.qzone.feed.utils.c.d());
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_DELETE_PREPOST_DYNAMIC_ALBUM)
    public void handleDeletePrePostDynamicAlbum(SendMsg sendMsg, Handler handler) {
        String h06 = u5.b.h0("key_dynamic_mgz_id", "null");
        if (!h06.equals("null")) {
            new QZoneTask(new QzoneDeleteDynamicAlbumRequest(h06, null), null, new b(), 0).run();
        }
        u5.b.v0("key_dynamic_share_url", "null");
        u5.b.v0("key_dynamic_mgz_id", "null");
        u5.b.v0("key_dynamic_client_ket", "null");
        u5.b.v0("key_dynamic_share_cover_url", "null");
    }

    @ServiceCmd(RemoteHandleConst.CMD_DYNAMIC_DESTORY)
    public void handleDynamicPageDestroy(SendMsg sendMsg, Handler handler) {
        com.qzone.album.base.Service.e.e().s(false);
    }

    @ServiceCmd(RemoteHandleConst.CMD_ENABLE_UPLOAD_FIRST_DYNAMIC_PHOTO)
    public void handleEnableUploadFirstDynamicPhoto(SendMsg sendMsg, Handler handler) {
        u5.b.o0("key_is_dynamicalbum_need_preload", true);
    }

    @ServiceCmd(RemoteHandleConst.CMD_VIDEO_GET_FAKE_FEED_COVER)
    public void handleGetFakeVideoCover(SendMsg sendMsg, Handler handler) {
        int i3;
        String str;
        int i16;
        PictureUrl pictureUrl;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "handleGetFakeVideoCover");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        String string = extraData.getString(RemoteHandleConst.PARAM_VIDEO_CLIENT_KEY);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        VideoInfo I0 = i.H().I0(string);
        if (I0 == null || (pictureUrl = I0.coverUrl) == null) {
            i3 = 0;
            str = null;
            i16 = 0;
        } else {
            str = pictureUrl.url;
            i3 = pictureUrl.width;
            i16 = pictureUrl.height;
        }
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_VIDEO_COVER_PATH, str);
        bundle.putInt(RemoteHandleConst.PARAM_VIDEO_COVER_WIDTH, i3);
        bundle.putInt(RemoteHandleConst.PARAM_VIDEO_COVER_HEIGHT, i16);
        bundle.putString(RemoteHandleConst.PARAM_VIDEO_CLIENT_KEY, string);
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_VIDEO_GET_LOCAL_PROXY_URL)
    public void handleGetVideoLocalProxyUrl(SendMsg sendMsg, Handler handler) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "handleGetVideoLocalProxyUrl");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        ArrayList<String> arrayList = (ArrayList) VideoManager.getInstance().getUrl(extraData.getStringArrayList(RemoteHandleConst.PARAM_VIDEO_REMOTE_URLS));
        ArrayList<String> stringArrayList = extraData.getStringArrayList(RemoteHandleConst.PARAM_VIDEO_ID);
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(RemoteHandleConst.PARAM_VIDEO_LOCAL_URLS, arrayList);
        bundle.putStringArrayList(RemoteHandleConst.PARAM_VIDEO_ID, stringArrayList);
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_VIDEO_SET_STATE)
    public void handleSetVideoState(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "handleSetVideoState");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        ArrayList<String> stringArrayList = extraData.getStringArrayList(RemoteHandleConst.PARAM_VIDEO_REMOTE_URLS);
        ArrayList<String> stringArrayList2 = extraData.getStringArrayList(RemoteHandleConst.PARAM_VIDEO_STATES);
        if (stringArrayList == null || stringArrayList2 == null || stringArrayList.size() != stringArrayList2.size()) {
            return;
        }
        for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
            BaseVideoManager.getFeedVideoManager().J(stringArrayList.get(i3), stringArrayList2.get(i3));
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_DISCOVER_SHOW_TAB)
    public void handleShowDiscoverTab(SendMsg sendMsg) {
        String str;
        DiscoverTab discoverTab = (DiscoverTab) sendMsg.getExtraData().getParcelable("tab");
        if (discoverTab != null) {
            u5.b.v0("selectTab", discoverTab.name);
            RedTouchExtendButton.RedInfo redInfo = discoverTab.redInfo;
            boolean z16 = redInfo != null && redInfo.isNew;
            if (z16) {
                QZoneFeedAlertService.getInstance().clearSingleUnreadCount(discoverTab.entranceId);
                String str2 = discoverTab.qbossTrace;
                if (!TextUtils.isEmpty(str2)) {
                    ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClick(str2, null);
                }
            }
            String valueOf = String.valueOf(discoverTab.entranceId);
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            ClickReport.m("449", valueOf, str);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_SYNC_WECHAT_WITH_SIGNIN)
    public void handleSyncWithSignIn(SendMsg sendMsg) {
        Bundle bundle;
        int i3;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(RemoteHandleConst.PARAM_TEXT_CONTENT);
        String string2 = bundle.getString(RemoteHandleConst.PARAM_SIGNIN_PICTURE_URL);
        String string3 = bundle.getString(RemoteHandleConst.PARAM_FONT_ID);
        String string4 = bundle.getString(RemoteHandleConst.PARAM_FONT_URL);
        try {
            i3 = Integer.parseInt(string3);
        } catch (Exception e16) {
            QZLog.e(TAG, e16.getMessage());
            i3 = 0;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("diy_font_id", string3);
        hashMap.put("diy_font_url", string4);
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "content is " + string + ", url is " + string2);
        }
        ClickReport.q(PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE, "1", "2", true);
        a aVar = new a(string, hashMap, string2);
        if (i3 > 0) {
            if (QzoneFontManager.f().g(i3, string4, aVar) != null) {
                aVar.a(null);
                return;
            }
            return;
        }
        aVar.a(null);
    }

    @ServiceCmd(RemoteHandleConst.CMD_UPDATE_DYNAMIC_ALBUM_INFO)
    public void handleUpdateDynamicAlbumInfo(SendMsg sendMsg, Handler handler) {
        Bundle bundle = sendMsg.extraData;
        String string = bundle.getString("music_id");
        String string2 = bundle.getString(QZoneJsConstants.DYNAMIC_ALBUM_LRC_ID);
        String string3 = bundle.getString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_START);
        String string4 = bundle.getString(QZoneJsConstants.DYNAMIC_ALBUM_CLIMAX_ENDURE);
        u5.b.v0("key_dynamicalbum_music_id", string);
        u5.b.v0("key_dynamicalbum_lrc_id", string2);
        u5.b.v0("key_dynamicalbum_climax_start", string3);
        u5.b.v0("key_dynamicalbum_climax_endure", string4);
    }

    @ServiceCmd(RemoteHandleConst.CMD_UPLOAD_FIRST_DYNAMIC_PHOTO)
    public void handleUploadFirstDynamicPhoto(SendMsg sendMsg, Handler handler) {
        if (u5.b.D("key_is_dynamicalbum_need_preload", false)) {
            u5.b.o0("key_is_dynamicalbum_need_preload", false);
            if (sendMsg == null || handler == null) {
                return;
            }
            Bundle bundle = sendMsg.extraData;
            u5.b.v0("key_dynamic_share_url", "null");
            u5.b.v0("key_dynamic_mgz_id", "null");
            u5.b.v0("key_dynamic_client_ket", "null");
            u5.b.v0("key_dynamic_share_cover_url", "null");
            if (bundle.getBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_ALBUM, false)) {
                new QZoneUploadFirstDynamicPhotoTask(bundle.getString(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST_ALBUMID), bundle.getString(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST_LLOC), bundle.getString(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST), true, bundle.getInt(RemoteHandleConst.PARAM_DYNAMIC_TOTAL_PHOTO_SIZE)).run();
            } else {
                new QZoneUploadFirstDynamicPhotoTask(bundle.getString(RemoteHandleConst.PARAM_FIRST_DYNAMIC_PHOTO_PATH), bundle.getInt(RemoteHandleConst.PARAM_DYNAMIC_TOTAL_PHOTO_SIZE)).run();
            }
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_VIDEO_DOWNLOAD)
    public void handleVideoDownload(final SendMsg sendMsg, final Handler handler) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "handleVideoDownload");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        final String string = extraData.getString(RemoteHandleConst.PARAM_VIDEO_REMOTE_URLS);
        final String string2 = extraData.getString(RemoteHandleConst.FORBIDDEN_TOAST);
        if (TextUtils.isEmpty(string)) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastVideoLoadingError", "\u89c6\u9891\u4e0b\u8f7d\u53c2\u6570\u9519\u8bef"), 4);
            return;
        }
        if (!"1".equals(string2)) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastVideoLoadingStart", "\u89c6\u9891\u5f00\u59cb\u4e0b\u8f7d"), 3);
        }
        MobileQQ.getMobileQQ().waitAppRuntime(null);
        String str = QZoneFilePath.DCIM_CAMERA_PATH;
        if (!new File(str).exists()) {
            str = QZoneFilePath.DCIMDir;
        }
        final String cameraPath = PhotoUtils.getCameraPath(str + File.separator, "QQ\u7a7a\u95f4\u89c6\u9891_", ".mp4");
        if (string.startsWith("https://qqcircle_aipainting_native_export.qq.com/local_files")) {
            ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).downloadAiPaintVideo(string, cameraPath, new IQQWinkEditorResAPI.DownloadAiPaintVideoListener() { // from class: com.qzone.common.webplugin.a
                @Override // com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI.DownloadAiPaintVideoListener
                public final void onDownloaded(int i3, String str2) {
                    WebPluginHandleLogic.this.lambda$handleVideoDownload$0(cameraPath, string, sendMsg, handler, string2, i3, str2);
                }
            });
        } else if (com.qzone.reborn.configx.g.f53821a.b().M()) {
            h.k(BaseApplication.getContext(), string, true);
        } else {
            com.qzone.misc.network.downloader.i.u().s(string, cameraPath, new f(sendMsg, handler, string2, cameraPath), null);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_CANCEL_KILL_PICTURE_PROCESS)
    public void handlerCancelKillPictureProcess(SendMsg sendMsg) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QZoneAppInterface) {
            ((QZoneAppInterface) runtime).cancelKillPictureProcess();
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_DYNAMIC_CLOUD_PHOTO)
    public void handlerGetCloudDynamicPhoto(SendMsg sendMsg, Handler handler) {
        QZLog.d("dynamic.Album", 4, " WebPluginHandleLogic handlerGetDynamicPhoto cmd.getDynamicCloudPhoto - start!");
        if (sendMsg == null || handler == null) {
            return;
        }
        boolean f16 = com.qzone.album.base.Service.e.e().f();
        QZLog.d("dynamic.Album", 4, " WebPluginHandleLogic handlerGetDynamicPhoto cmd.getDynamicCloudPhoto - isFromAlbum:" + f16);
        if (f16) {
            return;
        }
        Bundle bundle = new Bundle();
        ArrayList<QzonePhotoInfo> c16 = com.qzone.album.base.Service.e.e().c();
        if (c16 != null && c16.size() != 0) {
            bundle.putParcelableArrayList(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST, c16);
            bundle.putInt(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOCOUNT, com.qzone.album.base.Service.e.e().j());
            bundle.putString(RemoteHandleConst.PARAM_CLOUD_DYNAMIC_CMD, sendMsg.extraData.getString(RemoteHandleConst.PARAM_CLOUD_DYNAMIC_CMD));
            QZLog.d("dynamic.Album", 4, " WebPluginHandleLogic handlerGetDynamicPhoto cmd.getDynamicCloudPhoto - done and send Msg!");
            Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
            obtainMessage.obj = bundle;
            handler.sendMessage(obtainMessage);
            return;
        }
        QZLog.e("dynamic.Album", "cloudPhotoList == null || cloudPhotoList.size() == 0 ");
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_DYNAMIC_PHOTO)
    public void handlerGetDynamicPhoto(SendMsg sendMsg, Handler handler) {
        QZLog.d("dynamic.Album", 4, " WebPluginHandleLogic handlerGetDynamicPhoto cmd.getDynamicPhoto - start!");
        if (sendMsg == null || handler == null) {
            return;
        }
        boolean f16 = com.qzone.album.base.Service.e.e().f();
        boolean n3 = com.qzone.album.base.Service.e.e().n();
        QZLog.d("dynamic.Album", 4, " args isFromAlbum:" + f16 + " isFromBlog:" + n3);
        boolean g16 = com.qzone.album.base.Service.e.e().g();
        Bundle bundle = new Bundle();
        ArrayList<QzonePhotoInfo> c16 = com.qzone.album.base.Service.e.e().c();
        ArrayList<String> h16 = com.qzone.album.base.Service.e.e().h();
        if (f16) {
            bundle.putParcelableArrayList(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST, c16);
            bundle.putInt(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOCOUNT, com.qzone.album.base.Service.e.e().j());
            bundle.putString(RemoteHandleConst.PARAM_CLOUD_DYNAMIC_CMD, sendMsg.extraData.getString(RemoteHandleConst.PARAM_CLOUD_DYNAMIC_CMD));
        } else {
            bundle.putStringArrayList(RemoteHandleConst.PARAM_DYNAMIC_PHOTOLIST, h16);
            bundle.putInt(RemoteHandleConst.PARAM_DYNAMIC_PHOTOCOUNT, com.qzone.album.base.Service.e.e().k());
            bundle.putString(RemoteHandleConst.PARAM_DYNAMIC_CMD, sendMsg.extraData.getString(RemoteHandleConst.PARAM_DYNAMIC_CMD));
        }
        bundle.putBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_ALBUM, f16);
        bundle.putBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_MAKE_BLOG, n3);
        bundle.putString(QZoneHelper.QZonePersonalAlbumContants.KEY_ALBUM_ID, com.qzone.album.base.Service.e.e().a());
        bundle.putInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_THEME, com.qzone.album.base.Service.e.e().b());
        bundle.putInt(QZoneHelper.QZoneAlbumConstants.QZ_ALBUM_SORT_TYPE, com.qzone.album.base.Service.e.e().i());
        bundle.putBoolean(RemoteHandleConst.PARAM_DYNAMIC_IS_FROM_ALBUM_SHARE_PANEL, g16);
        QZLog.d("dynamic.Album", 4, " WebPluginHandleLogic handlerGetDynamicPhoto cmd.getDynamicPhoto - done and send Msg!");
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_NOTIFY_PLAYLIST_CHANGE)
    public void handlerNotifyPlayListChange(SendMsg sendMsg) {
        e8.f.a().b().h();
    }

    @ServiceCmd(RemoteHandleConst.CMD_PAUSE_PLAY)
    public void handlerPausePlay(SendMsg sendMsg) {
        e8.f.a().b().pauseMusic();
    }

    @ServiceCmd(RemoteHandleConst.CMD_RESUME_PLAY)
    public void handlerResumePlay(SendMsg sendMsg) {
        e8.f.a().b().b();
    }

    @ServiceCmd(RemoteHandleConst.CMD_STOP_PLAY)
    public void handlerStopPlay(SendMsg sendMsg) {
        e8.f.a().b().a();
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_BARRAG_EEFFECT_CHANGED)
    public void notifyBarrageEffectChanged(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_FONT_CHANGED");
        }
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_BARRAGE_EFFECT_ENABLED, sendMsg.getExtraData().getBoolean("value"));
        FontManager.notifyCacheBarrageEnableExpired();
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_UPDATE_CUSTOM_BROWSER_INFO)
    public void notifyCustomBrowserInfoChanged(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_UPDATE_CUSTOM_BROWSER_INFO");
        }
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_FEED_CUSTOM_BROWSER_DECO_SWITCH, sendMsg.getExtraData().getBoolean("value"));
        com.qzone.personalize.business.b.n().B();
    }

    @ServiceCmd(RemoteHandleConst.CMD_SET_CUSTOM_TRACK)
    public void notifyCustomTrackDataChange(SendMsg sendMsg) {
        QZLog.i(TAG, "notifyCustomTrackDataChange ");
        EventCenter.getInstance().post("Personalize", 24, (Object[]) null);
    }

    @ServiceCmd(RemoteHandleConst.CMD_SET_QZONE_DIY_DATA)
    public void notifyDIYDataChange(SendMsg sendMsg) {
        String string = sendMsg.getExtraData().getString(QZoneJsConstants.KEY_DIY_LAYOUT_JSON);
        if (QZLog.isColorLevel()) {
            QZLog.i(TAG, 2, " notifyDIYDataChange QzoneDIY layout json = " + string);
        }
        HashMap hashMap = new HashMap(1);
        UserFacadeInfo userFacadeInfo = new UserFacadeInfo();
        userFacadeInfo.code = 0;
        userFacadeInfo.layout = string;
        userFacadeInfo.checksum = "";
        hashMap.put(Long.valueOf(LoginData.getInstance().getUin()), QzoneDIYData.createQzoneDIYData(LoginData.getInstance().getUin(), userFacadeInfo));
        QzoneDIYService.L().Q(hashMap);
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_FEED_SKIN_SWITCH_CHANGED)
    public void notifyFeedSkinSwitchChanged(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_FONT_CHANGED");
        }
        com.qzone.personalize.business.a.b().e();
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_FONT_CHANGED)
    public void notifyFontChanged(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_FONT_CHANGED");
        }
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_FONT_ENABLED, sendMsg.getExtraData().getBoolean("value"));
        FontManager.notifyCacheFontEnableExpired();
    }

    @ServiceCmd(RemoteHandleConst.CMD_SET_RESPONSIVE_LIKE)
    public void notifyHighFiveDataChange(SendMsg sendMsg) {
        Bundle extraData = sendMsg.getExtraData();
        int i3 = extraData.getInt("itemId");
        String string = extraData.getString(QZoneJsConstants.KEY_HIGH_FIVE_URL);
        String string2 = extraData.getString(QZoneJsConstants.KEY_HIGH_FIVE_TEXT);
        CustomHighFiveData customHighFiveData = new CustomHighFiveData();
        customHighFiveData.uin = LoginData.getInstance().getUin();
        customHighFiveData.itemId = i3;
        customHighFiveData.strHighFiveResUrl = string;
        customHighFiveData.strHighFiveText = string2;
        QZLog.i(TAG, 4, " notifyHighFiveDataChange h5 set id = " + i3 + " url = " + string + " text = " + string2);
        com.qzone.personalize.business.b.n().z(customHighFiveData);
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_SUPERFONT_CHANGED)
    public void notifySuperFontChanged(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_FONT_CHANGED");
        }
        LocalMultiProcConfig.putBool(LocalMultiProcConfig.QZONE_SUPER_FONT_ENABLED, sendMsg.getExtraData().getBoolean("value"));
        FontManager.notifyCacheSuperFontEnableExpired();
    }

    @ServiceCmd(RemoteHandleConst.CMD_RESERVE_ADVERTISE)
    public void notifyUpdateButtonUI(SendMsg sendMsg) {
        String string = sendMsg.getExtraData().getString("orderid");
        if (QZLog.isColorLevel()) {
            QZLog.i(TAG, 2, "notifyUpdateButtonUI  @orderAdv orderid " + string);
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).addReportId(string);
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_YELOOWDIAMOND_REDPOCKET)
    public void notifyYellowDiamondRedpocket(SendMsg sendMsg) {
        String string = sendMsg.getExtraData().getString(RemoteHandleConst.PARAM_YELLOWDIAMOND_REDPOCKET_UGCKEY);
        QZLog.d(TAG, 4, "ugckey =" + string);
        Object[] objArr = {string, null, null};
        if (TextUtils.isEmpty(string)) {
            return;
        }
        EventCenter.getInstance().post("WriteOperation", 55, objArr);
    }

    @ServiceCmd(RemoteHandleConst.CMD_PRE_GET_PASSIVE_FEEDS)
    public void pregetPassiveFeeds(SendMsg sendMsg, Handler handler) {
        this.innerHandler = new e(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BusinessThread).getLooper(), sendMsg, handler);
        QZLog.i(TAG, 1, "pregetPassiveFeeds" + this.innerHandler);
        BaseApplicationImpl.getApplication().waitAppRuntime(null);
        QZoneFeedService.b0(false).p0(this.innerHandler);
    }

    @ServiceCmd(RemoteHandleConst.CMD_PUBLISH_MIXMOOD)
    public void publishMixMood(SendMsg sendMsg) {
        HashMap<String, String> hashMap;
        PublishEventTag publishEventTag;
        PublishEventTag publishEventTag2;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "publishMixMood...");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        String string = extraData.getString("param.content");
        if (string == null) {
            string = "";
        }
        HashMap<String, String> hashMap2 = (HashMap) extraData.get(RemoteHandleConst.PARAM_EXTRA);
        ArrayList<String> stringArrayList = extraData.getStringArrayList(RemoteHandleConst.PARAM_IMAGES);
        extraData.getInt(RemoteHandleConst.PARAM_QUALITY, 0);
        int i3 = extraData.getInt("param.priv", 1);
        ArrayList<String> stringArrayList2 = extraData.getStringArrayList("param.privList");
        long j3 = extraData.getLong(RemoteHandleConst.PARAM_TIME);
        Map<String, String> map = (Map) extraData.get(RemoteHandleConst.PARAM_EXTEND_INFO);
        if (map == null) {
            map = new HashMap<>();
        }
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < stringArrayList.size(); i16++) {
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = stringArrayList.get(i16);
            localMediaInfo.mMimeType = MimeTypesTools.getMimeType(BaseApplication.getContext(), localMediaInfo.path);
            arrayList.add(localMediaInfo);
        }
        LbsDataV2.PoiInfo poiInfo = (LbsDataV2.PoiInfo) extraData.getParcelable(RemoteHandleConst.PARAM_POI_INFO);
        boolean z16 = extraData.getInt(RemoteHandleConst.PARAM_SYNCWEIBO) == 1;
        HashMap<String, String> hashMap3 = (HashMap) extraData.get(RemoteHandleConst.PARAM_STOREEXTENDINFO);
        if (hashMap3 == null || !hashMap3.containsKey(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG)) {
            hashMap = hashMap3;
            publishEventTag = null;
        } else {
            PublishEventTag publishEventTag3 = new PublishEventTag();
            String str = hashMap3.get(QZonePublishMoodRequest.EXT_INFO_KEY_EVENT_TAG);
            publishEventTag3.f45887protocol = str;
            if (QZLog.isColorLevel()) {
                publishEventTag2 = publishEventTag3;
                hashMap = hashMap3;
                QZLog.d(TAG, 2, "has event_tags :", str);
            } else {
                publishEventTag2 = publishEventTag3;
                hashMap = hashMap3;
            }
            publishEventTag = publishEventTag2;
        }
        boolean equals = RemoteHandleConst.VALUE_SOURCE_FROM_VIDEO_SIGN.equals(extraData.getString("param.source"));
        com.qzone.publish.ui.model.c cVar = new com.qzone.publish.ui.model.c();
        cVar.f51934b = string;
        cVar.f51936c = stringArrayList;
        cVar.f51940e = arrayList;
        cVar.f51942f = hashMap2;
        cVar.f51954p = map;
        cVar.f51957s = j3;
        cVar.f51959u = i3;
        cVar.f51960v = stringArrayList2;
        cVar.f51964z = 35;
        cVar.J = false;
        cVar.f51949k = z16;
        cVar.f51950l = false;
        cVar.f51956r = 2;
        cVar.f51948j = poiInfo;
        cVar.E = hashMap;
        cVar.C = publishEventTag;
        cVar.f51933a0 = equals;
        QZoneWriteOperationService.v0().R1(BaseApplication.getContext(), cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fa  */
    @ServiceCmd(RemoteHandleConst.CMD_PUBLISH_MOOD)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void publishMood(SendMsg sendMsg) {
        PublishEventTag publishEventTag;
        LbsDataV2.PoiInfo fromJsonString;
        String string;
        int i3;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "publishMood");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        String string2 = extraData.getString("param.content");
        String str = "";
        if (string2 == null) {
            string2 = "";
        }
        if (string2.length() > 10000) {
            string2 = string2.substring(0, 9997) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        String str2 = string2;
        String string3 = extraData.getString(RemoteHandleConst.PARAM_TAG_TITLE);
        if (TextUtils.isEmpty(string3)) {
            publishEventTag = null;
        } else {
            PublishEventTag publishEventTag2 = new PublishEventTag();
            publishEventTag2.title = string3;
            publishEventTag2.f45887protocol = String.valueOf(LoginData.getInstance().getUin()) + "_0_" + string3;
            publishEventTag = publishEventTag2;
        }
        HashMap<String, String> hashMap = (HashMap) extraData.get(RemoteHandleConst.PARAM_EXTRA);
        ArrayList<String> stringArrayList = extraData.getStringArrayList(RemoteHandleConst.PARAM_IMAGES);
        int i16 = extraData.getInt(RemoteHandleConst.PARAM_QUALITY, 0);
        int i17 = extraData.getInt("param.priv", 1);
        ArrayList<String> stringArrayList2 = extraData.getStringArrayList("param.privList");
        long j3 = extraData.getLong(RemoteHandleConst.PARAM_TIME);
        HashMap hashMap2 = (HashMap) extraData.getSerializable("param.extMap");
        String str3 = hashMap2 != null ? (String) hashMap2.get("ext_poi") : null;
        if (!TextUtils.isEmpty(str3)) {
            try {
                fromJsonString = fromJsonString(str3);
            } catch (Throwable th5) {
                QZLog.w(TAG, "publishmood->poiInfo", th5);
            }
            int i18 = extraData.getInt(RemoteHandleConst.PARAM_SUBTYPE);
            string = extraData.getString("param.source");
            if (!"value.sourceFromQqQuickShoot".equals(string)) {
                str = "qqQuickShoot";
            } else if (RemoteHandleConst.VALUE_SOURCE_FROM_PERSONAL_SIGN.equals(string)) {
                str = "qqPersonalSign";
                i3 = 29;
                QZLog.d(TAG, 2, "content=" + str2);
                QZoneWriteOperationService.v0().P1(str2, stringArrayList, null, hashMap, null, null, null, fromJsonString, false, false, 0, null, hashMap2, null, i16, j3, 0L, i17, stringArrayList2, "", null, "", i3, false, null, publishEventTag, null, null, null, null, null, i18, null, str);
            }
            i3 = 0;
            QZLog.d(TAG, 2, "content=" + str2);
            QZoneWriteOperationService.v0().P1(str2, stringArrayList, null, hashMap, null, null, null, fromJsonString, false, false, 0, null, hashMap2, null, i16, j3, 0L, i17, stringArrayList2, "", null, "", i3, false, null, publishEventTag, null, null, null, null, null, i18, null, str);
        }
        fromJsonString = null;
        int i182 = extraData.getInt(RemoteHandleConst.PARAM_SUBTYPE);
        string = extraData.getString("param.source");
        if (!"value.sourceFromQqQuickShoot".equals(string)) {
        }
        i3 = 0;
        QZLog.d(TAG, 2, "content=" + str2);
        QZoneWriteOperationService.v0().P1(str2, stringArrayList, null, hashMap, null, null, null, fromJsonString, false, false, 0, null, hashMap2, null, i16, j3, 0L, i17, stringArrayList2, "", null, "", i3, false, null, publishEventTag, null, null, null, null, null, i182, null, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0229  */
    @ServiceCmd(RemoteHandleConst.CMD_PUBLISH_MOOD_FOR_ALL)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void publishMoodForAll(SendMsg sendMsg) {
        String str;
        int i3;
        ArrayList<String> arrayList;
        boolean z16;
        String str2;
        DefaultSuperFontInfo defaultSuperFont;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "publishMood");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        String string = extraData.getString("param.content");
        if (string == null) {
            string = "";
        }
        if (string.length() > 10000) {
            string = string.substring(0, 9997) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        HashMap<String, String> hashMap = (HashMap) extraData.get(RemoteHandleConst.PARAM_EXTRA);
        ArrayList<String> stringArrayList = extraData.getStringArrayList(RemoteHandleConst.PARAM_IMAGES);
        int i16 = extraData.getInt(RemoteHandleConst.PARAM_QUALITY, 0);
        int i17 = extraData.getInt("param.priv", 1);
        ArrayList<String> stringArrayList2 = extraData.getStringArrayList("param.privList");
        long j3 = extraData.getLong(RemoteHandleConst.PARAM_TIME);
        HashMap hashMap2 = new HashMap();
        if (extraData.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID)) {
            DefaultFontInfo defaultFontInfo = new DefaultFontInfo();
            defaultFontInfo.fontId = extraData.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID);
            defaultFontInfo.formatType = extraData.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE);
            String string2 = extraData.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
            defaultFontInfo.fontUrl = string2;
            if (defaultFontInfo.fontId > 0 && !TextUtils.isEmpty(string2)) {
                hashMap2.put("diy_font_id", defaultFontInfo.fontId + "");
                hashMap2.put("diy_font_type", defaultFontInfo.formatType + "");
                hashMap2.put("diy_font_url", defaultFontInfo.fontUrl);
            }
            int i18 = defaultFontInfo.fontId;
            if (i18 >= 0) {
                if (i18 != 0) {
                    str = TAG;
                } else {
                    IFontManager iFontManager = (IFontManager) QRoute.api(IFontManager.class);
                    LoginData loginData = LoginData.getInstance();
                    str = TAG;
                    DefaultFontInfo defaultFont = iFontManager.getDefaultFont(loginData.getUin());
                    if (defaultFont != null && defaultFont.fontId > 0) {
                        i3 = i17;
                        arrayList = stringArrayList2;
                        PersonalFontService.K().U(LoginData.getInstance().getUin(), null);
                        ((IFontManager) QRoute.api(IFontManager.class)).setDefaultFont(LoginData.getInstance().getUin(), defaultFontInfo);
                        if (extraData.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO)) {
                            DefaultSuperFontInfo defaultSuperFontInfo = new DefaultSuperFontInfo();
                            defaultSuperFontInfo.fontId = extraData.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID);
                            String string3 = extraData.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
                            defaultSuperFontInfo.jsonStr = string3;
                            if (defaultSuperFontInfo.fontId > 0 && !TextUtils.isEmpty(string3)) {
                                hashMap2.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, defaultSuperFontInfo.fontId + "");
                                hashMap2.put("sparkle_json", defaultSuperFontInfo.jsonStr);
                            }
                            int i19 = defaultSuperFontInfo.fontId;
                            if (i19 >= 0) {
                                if (i19 == 0 && (defaultSuperFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultSuperFont(LoginData.getInstance().getUin())) != null && defaultSuperFont.fontId > 0) {
                                    QzoneSuperPersonalFontService.F().N(LoginData.getInstance().getUin(), null);
                                    VasCommonReporter.newReport("qzone_super_font").setValue1("publishMoodForAll set default " + defaultSuperFontInfo.fontId).report(false);
                                }
                                ((IFontManager) QRoute.api(IFontManager.class)).setDefaultSuperFont(LoginData.getInstance().getUin(), defaultSuperFontInfo);
                            }
                        }
                        boolean z17 = extraData.getBoolean(RemoteHandleConst.PARAM_IS_SYNC_VIDEO_TO_QQSTORY, false);
                        z16 = extraData.getBoolean(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SET_TIMER_DELETE);
                        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = (QzoneVerticalVideoTopicInfo) extraData.getParcelable(RemoteHandleConst.PARAM_QZONE_TOPIC);
                        String str3 = str;
                        QZLog.d(str3, 2, "isTimerDelete=" + z16);
                        if (z16) {
                            hashMap2.put(QZonePublishMoodRequest.EXT_INFO_KEY_DELETE_TIME, String.valueOf(86400L));
                        }
                        if (!"value.sourceFromQqQuickShoot".equals(extraData.getString("param.source"))) {
                            str2 = "";
                        } else {
                            str2 = "qqQuickShoot";
                        }
                        QZLog.d(str3, 2, "content=" + string);
                        com.qzone.publish.ui.model.c cVar = new com.qzone.publish.ui.model.c();
                        cVar.f51934b = string;
                        cVar.f51936c = stringArrayList;
                        cVar.f51942f = hashMap;
                        cVar.f51954p = hashMap2;
                        cVar.f51956r = i16;
                        cVar.f51957s = j3;
                        cVar.f51959u = i3;
                        cVar.f51960v = arrayList;
                        cVar.f51964z = 35;
                        cVar.I = str2;
                        cVar.J = z17;
                        cVar.K = qzoneVerticalVideoTopicInfo;
                        QZoneWriteOperationService.v0().O1(cVar);
                    }
                }
                i3 = i17;
                arrayList = stringArrayList2;
                ((IFontManager) QRoute.api(IFontManager.class)).setDefaultFont(LoginData.getInstance().getUin(), defaultFontInfo);
                if (extraData.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO)) {
                }
                boolean z172 = extraData.getBoolean(RemoteHandleConst.PARAM_IS_SYNC_VIDEO_TO_QQSTORY, false);
                z16 = extraData.getBoolean(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SET_TIMER_DELETE);
                QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo2 = (QzoneVerticalVideoTopicInfo) extraData.getParcelable(RemoteHandleConst.PARAM_QZONE_TOPIC);
                String str32 = str;
                QZLog.d(str32, 2, "isTimerDelete=" + z16);
                if (z16) {
                }
                if (!"value.sourceFromQqQuickShoot".equals(extraData.getString("param.source"))) {
                }
                QZLog.d(str32, 2, "content=" + string);
                com.qzone.publish.ui.model.c cVar2 = new com.qzone.publish.ui.model.c();
                cVar2.f51934b = string;
                cVar2.f51936c = stringArrayList;
                cVar2.f51942f = hashMap;
                cVar2.f51954p = hashMap2;
                cVar2.f51956r = i16;
                cVar2.f51957s = j3;
                cVar2.f51959u = i3;
                cVar2.f51960v = arrayList;
                cVar2.f51964z = 35;
                cVar2.I = str2;
                cVar2.J = z172;
                cVar2.K = qzoneVerticalVideoTopicInfo2;
                QZoneWriteOperationService.v0().O1(cVar2);
            }
        }
        str = TAG;
        i3 = i17;
        arrayList = stringArrayList2;
        if (extraData.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO)) {
        }
        boolean z1722 = extraData.getBoolean(RemoteHandleConst.PARAM_IS_SYNC_VIDEO_TO_QQSTORY, false);
        z16 = extraData.getBoolean(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SET_TIMER_DELETE);
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo22 = (QzoneVerticalVideoTopicInfo) extraData.getParcelable(RemoteHandleConst.PARAM_QZONE_TOPIC);
        String str322 = str;
        QZLog.d(str322, 2, "isTimerDelete=" + z16);
        if (z16) {
        }
        if (!"value.sourceFromQqQuickShoot".equals(extraData.getString("param.source"))) {
        }
        QZLog.d(str322, 2, "content=" + string);
        com.qzone.publish.ui.model.c cVar22 = new com.qzone.publish.ui.model.c();
        cVar22.f51934b = string;
        cVar22.f51936c = stringArrayList;
        cVar22.f51942f = hashMap;
        cVar22.f51954p = hashMap2;
        cVar22.f51956r = i16;
        cVar22.f51957s = j3;
        cVar22.f51959u = i3;
        cVar22.f51960v = arrayList;
        cVar22.f51964z = 35;
        cVar22.I = str2;
        cVar22.J = z1722;
        cVar22.K = qzoneVerticalVideoTopicInfo22;
        QZoneWriteOperationService.v0().O1(cVar22);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0297 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0298  */
    @ServiceCmd(RemoteHandleConst.CMD_PUBLISH_VIDEO_MOOD)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void publishVideoMood(SendMsg sendMsg) {
        int i3;
        String str;
        boolean z16;
        final ShuoshuoVideoInfo q16;
        DefaultSuperFontInfo defaultSuperFont;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "publishVideoMood");
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        String string = extraData.getString("param.content");
        if (string == null) {
            string = "";
        }
        if (string.length() > 10000) {
            string = string.substring(0, 9997) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        int i16 = extraData.getInt("param.priv");
        ArrayList<String> stringArrayList = extraData.getStringArrayList("param.privList");
        String string2 = extraData.getString(RemoteHandleConst.VIDEO_PARAM_VIDEOPATH);
        long j3 = extraData.getLong(RemoteHandleConst.VIDEO_PARAM_VIDEOSIZE);
        int i17 = extraData.getInt(RemoteHandleConst.VIDEO_PARAM_VIDEOTYPE);
        String string3 = extraData.getString(RemoteHandleConst.VIDEO_PARAM_THUMBNAILPATH);
        int i18 = extraData.getInt(RemoteHandleConst.VIDEO_PARAM_THUMBNAILHEIGHT);
        int i19 = extraData.getInt(RemoteHandleConst.VIDEO_PARAM_THUMBNAILWIDTH);
        long j16 = extraData.getLong(RemoteHandleConst.VIDEO_PARAM_STARTTIME);
        long j17 = extraData.getLong("param.duration");
        long j18 = extraData.getLong(RemoteHandleConst.VIDEO_PARAM_TOTALDURATION);
        boolean z17 = extraData.getBoolean(RemoteHandleConst.VIDEO_PARAM_NEEDPROCESS);
        boolean z18 = extraData.getBoolean(RemoteHandleConst.VIDEO_PARAM_ISUPLOADORIGIN);
        Bundle bundle = extraData.getBundle(RemoteHandleConst.VIDEO_PARAM_EXTRAS);
        String string4 = extraData.getString(RemoteHandleConst.VIDEO_PARAM_TOPIC_ID);
        boolean z19 = extraData.getBoolean(RemoteHandleConst.VIDEO_PARAM_TOPIC_SYNC_QZONE, false);
        String string5 = extraData.getString(RemoteHandleConst.VIDEO_PARAM_NEW_FAKE_VID);
        String string6 = extraData.getString("param.source");
        String str2 = string;
        boolean z26 = extraData.getBoolean(RemoteHandleConst.VIDEO_PARAM_IS_GENERATE_GIF, false);
        boolean z27 = extraData.getBoolean(RemoteHandleConst.VIDEO_PARAM_IS_TIMER_DELETE, false);
        boolean z28 = extraData.getBoolean(RemoteHandleConst.PARAM_IS_SYNC_VIDEO_TO_QQSTORY, false);
        QzoneVerticalVideoTopicInfo qzoneVerticalVideoTopicInfo = (QzoneVerticalVideoTopicInfo) extraData.getParcelable(RemoteHandleConst.PARAM_QZONE_TOPIC);
        boolean z29 = extraData.getBoolean(RemoteHandleConst.PARAM_FROM_AIO, false);
        int i26 = extraData.getInt(RemoteHandleConst.VIDEO_PARAM_ENTRANCE_SOURCE, 0);
        int i27 = extraData.getInt("param.uploadEntrance", 0);
        boolean z36 = extraData.getBoolean(RemoteHandleConst.VIDEO_PARAM_IS_MAKE_VIDEO, false);
        int i28 = "value.sourceFromQqQuickShoot".equals(string6) ? 212 : i27;
        HashMap hashMap = new HashMap();
        if (extraData.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID)) {
            DefaultFontInfo defaultFontInfo = new DefaultFontInfo();
            defaultFontInfo.fontId = extraData.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_ID);
            defaultFontInfo.formatType = extraData.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_FORMAT_TYPE);
            String string7 = extraData.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_FONT_URL);
            defaultFontInfo.fontUrl = string7;
            i3 = i28;
            if (defaultFontInfo.fontId > 0 && !TextUtils.isEmpty(string7)) {
                hashMap.put("diy_font_id", defaultFontInfo.fontId + "");
                hashMap.put("diy_font_type", defaultFontInfo.formatType + "");
                hashMap.put("diy_font_url", defaultFontInfo.fontUrl);
            }
            int i29 = defaultFontInfo.fontId;
            if (i29 >= 0) {
                if (i29 == 0) {
                    z16 = z19;
                    DefaultFontInfo defaultFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultFont(LoginData.getInstance().getUin());
                    if (defaultFont == null || defaultFont.fontId <= 0) {
                        str = string4;
                    } else {
                        str = string4;
                        PersonalFontService.K().U(LoginData.getInstance().getUin(), null);
                    }
                } else {
                    str = string4;
                    z16 = z19;
                }
                ((IFontManager) QRoute.api(IFontManager.class)).setDefaultFont(LoginData.getInstance().getUin(), defaultFontInfo);
                if (extraData.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO)) {
                    DefaultSuperFontInfo defaultSuperFontInfo = new DefaultSuperFontInfo();
                    defaultSuperFontInfo.fontId = extraData.getInt(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_ID);
                    String string8 = extraData.getString(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO);
                    defaultSuperFontInfo.jsonStr = string8;
                    if (defaultSuperFontInfo.fontId > 0 && !TextUtils.isEmpty(string8)) {
                        hashMap.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, defaultSuperFontInfo.fontId + "");
                        hashMap.put("sparkle_json", defaultSuperFontInfo.jsonStr);
                    }
                    int i36 = defaultSuperFontInfo.fontId;
                    if (i36 >= 0) {
                        if (i36 == 0 && (defaultSuperFont = ((IFontManager) QRoute.api(IFontManager.class)).getDefaultSuperFont(LoginData.getInstance().getUin())) != null && defaultSuperFont.fontId > 0) {
                            QzoneSuperPersonalFontService.F().N(LoginData.getInstance().getUin(), null);
                            VasCommonReporter.newReport("qzone_super_font").setValue1("publishVideoMood set default " + defaultSuperFontInfo.fontId).report();
                        }
                        ((IFontManager) QRoute.api(IFontManager.class)).setDefaultSuperFont(LoginData.getInstance().getUin(), defaultSuperFontInfo);
                    }
                }
                q16 = ag.q(string2, j3, i17, string3, i18, i19, j16, j17, j18, z17, bundle);
                if (q16 != null) {
                    return;
                }
                q16.mIsUploadOrigin = z18;
                if (!TextUtils.isEmpty(str)) {
                    q16.mIsNew = 104;
                    q16.topicId = str;
                    q16.topicSyncQzone = z16;
                }
                q16.fakeVid = string5;
                QZonePreUploadInfo qZonePreUploadInfo = new QZonePreUploadInfo();
                qZonePreUploadInfo.preUploadedPaths = null;
                qZonePreUploadInfo.preUploadingRequest = null;
                qZonePreUploadInfo.preUploadType = 0;
                QZLog.d(TAG, 2, "content=" + str2);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.common.webplugin.WebPluginHandleLogic.6
                    @Override // java.lang.Runnable
                    public void run() {
                        long uin = LoginData.getInstance().getUin();
                        ShuoshuoVideoInfo shuoshuoVideoInfo = q16;
                        boolean z37 = shuoshuoVideoInfo.mNeedProcess;
                        long j19 = shuoshuoVideoInfo.mSize;
                        int networkType = NetworkState.getNetworkType();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("extra_network_type", networkType + "");
                        hashMap2.put("extra_file_size", j19 + "");
                        hashMap2.put("extra_quality", (z37 ? 1 : 0) + "");
                        q16.perfKey = UUID.randomUUID().toString();
                        QzoneVideoPerfReport.a(q16.perfKey, 0).c(uin, "event_extra", hashMap2);
                    }
                });
                QZLog.d(TAG, 2, "isTimerDelete=" + z27);
                if (z27) {
                    hashMap.put(QZonePublishMoodRequest.EXT_INFO_KEY_DELETE_TIME, String.valueOf(86400L));
                }
                com.qzone.publish.ui.model.c cVar = new com.qzone.publish.ui.model.c();
                cVar.f51934b = str2;
                cVar.f51946h = q16;
                cVar.f51953o = qZonePreUploadInfo;
                cVar.f51954p = hashMap;
                cVar.f51956r = 0;
                cVar.f51959u = i16;
                cVar.f51960v = stringArrayList;
                cVar.f51964z = i3;
                cVar.Q = z36;
                cVar.A = z26;
                cVar.H = 2;
                cVar.I = "shuoshuoOther";
                cVar.J = z28;
                cVar.K = qzoneVerticalVideoTopicInfo;
                cVar.O = z29;
                QZoneWriteOperationService.v0().O1(cVar);
                Intent intent = new Intent(QZoneHelper.Constants.ACTION_SEND_MOOD_FINISH);
                intent.putExtra(RemoteHandleConst.VIDEO_PARAM_ENTRANCE_SOURCE, i26);
                BaseApplicationImpl.getApplication().sendBroadcast(intent);
                return;
            }
        } else {
            i3 = i28;
        }
        str = string4;
        z16 = z19;
        if (extraData.containsKey(QZoneHelper.QzoneFeedActionPanelConstants.EXTRA_KEY_SUPER_FONT_INFO)) {
        }
        q16 = ag.q(string2, j3, i17, string3, i18, i19, j16, j17, j18, z17, bundle);
        if (q16 != null) {
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_REFRESH_DECO_CUSTOM)
    public void refeshDecoCustom(SendMsg sendMsg) {
        QZLog.i(TAG, "@bannershow refeshDecoCustom");
        EventCenter.getInstance().post("Personalize", 21, (Object[]) null);
    }

    @ServiceCmd(RemoteHandleConst.CDM_SET_QUICK_MAKE_DYNAMIC_STATUS)
    public void setQuickMakeDynamicStatus(SendMsg sendMsg) {
        com.qzone.feed.utils.c.i(sendMsg.getExtraData().getInt("status", 0));
    }

    @ServiceCmd(RemoteHandleConst.CMD_SHOW_TOAST)
    public void showToast(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, UIJsPlugin.EVENT_SHOW_TOAST);
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        CharSequence charSequence = extraData.getCharSequence(RemoteHandleConst.PARAM_TOAST_TEXT);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        ToastUtil.r(charSequence);
    }

    @ServiceCmd(RemoteHandleConst.CMD_DISCOVER_START_WNS_PROXY_RERQUEST)
    public void startWnsProxyRequestWithCheck(SendMsg sendMsg) {
        DiscoverTab discoverTab = (DiscoverTab) sendMsg.getExtraData().getParcelable("tab");
        if (discoverTab != null) {
            WebSoService.j().G(discoverTab.url, null);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_UPDATE_CUSTOM_PRAISE)
    public void updateCustomPraise(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_UPDATE_CUSTOM_PRAISE");
        }
        QzoneCustomPraiseService.i().p(CustomPraiseData.createFrom(LoginData.getInstance().getUin(), sendMsg.getExtraData().getString(RemoteHandleConst.PARAM_CUSTOM_PRAISE_DATA)));
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_UPDATE_FONT_LIST)
    public void updateFontList(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_UPDATE_CUSTOM_PRAISE");
        }
        VipMMKV.getCommon().encodeBool("qzone_font_panel_request_key", true);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        PersonalFontService.K().I(peekAppRuntime.getLongAccountUin(), null);
    }

    @ServiceCmd(RemoteHandleConst.CMD_UPDATE_FRIEND_SETTING)
    public void updateFriendSetting(SendMsg sendMsg) {
        Bundle extraData = sendMsg.getExtraData();
        if (extraData == null) {
            return;
        }
        EventCenter.getInstance().post("WebPlugin", 1, extraData);
    }

    @ServiceCmd(RemoteHandleConst.CMD_QZONE_UPDATE_PLOYMORPHIC_PRAISE)
    public void updatePloyPraise(SendMsg sendMsg) {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_QZONE_UPDATE_PLOYMORPHIC_PRAISE");
        }
        QzonePolymorphicPraiseService.getInstance().updatePolyPraiseCache(com.qzone.feed.utils.d.a(sendMsg.getExtraData().getString(RemoteHandleConst.PARAM_PLOYMORPHIC_PRAISE_DATA)));
        QzonePolymorphicPraiseService.getInstance().refreshLocalCache(LoginData.getInstance().getUin());
    }

    @ServiceCmd(RemoteHandleConst.CMD_UPLOAD_TROOP_PHOTOS)
    public void uploadTroopPhotos(SendMsg sendMsg, Handler handler) {
        Bundle extraData = sendMsg.getExtraData();
        String string = extraData.getString(QZoneHelper.Constants.KEY_QUN_ID);
        extraData.getString("qzone_uin");
        extraData.getString(QZoneHelper.Constants.KEY_QUN_NAME);
        String string2 = extraData.getString("UploadPhoto.key_album_id");
        String string3 = extraData.getString("UploadPhoto.key_album_name");
        int i3 = extraData.getInt(QZoneHelper.QZoneAlbumConstants.KEY_QUALITY);
        ArrayList<String> stringArrayList = extraData.getStringArrayList("PhotoConst.PHOTO_PATHS");
        String string4 = extraData.getString(QZoneHelper.QZoneUploadPhotoConstants.KEY_UPLOAD_IMAGES_CLIENT_KEY);
        String string5 = extraData.getString("refer");
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(TextUtils.isEmpty(string2) ? "" : string2);
        if (TextUtils.isEmpty(string2)) {
            string3 = l.a(R.string.vjv);
        }
        businessAlbumInfo.mTitle = string3;
        PublishQueueService.f51080m.add(string4);
        QZoneWriteOperationService.v0().s2(1, toImageInfos(stringArrayList), string, businessAlbumInfo, null, i3, null, string5, string4, 41);
    }

    @ServiceCmd(RemoteHandleConst.CMD_VIDEO_UPLOAD_FOR_H5)
    public void uploadVideoForH5(SendMsg sendMsg) {
        String jSONObject;
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 2, "CMD_VIDEO_UPLOAD_FOR_H5");
        }
        String string = sendMsg.getExtraData().getString(RemoteHandleConst.PARAM_VIDEO_FOR_H5_JSON);
        if (TextUtils.isEmpty(string)) {
            QZLog.e(TAG, "uploadVideoForH5 json is empty");
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(string);
            JSONObject jSONObject3 = jSONObject2.getJSONObject("video_info");
            ShuoshuoVideoInfo shuoshuoVideoInfo = new ShuoshuoVideoInfo();
            shuoshuoVideoInfo.mVideoPath = jSONObject3.optString("videoPath");
            shuoshuoVideoInfo.mVideoType = jSONObject3.optInt("videoType");
            shuoshuoVideoInfo.mDescription = jSONObject3.optString("content");
            shuoshuoVideoInfo.mSize = jSONObject3.optLong(QZonePublishMoodRequest.EXT_INFO_KEY_VIDEO_SIZE);
            shuoshuoVideoInfo.mCoverUrl = jSONObject3.optString("thumbnailPath");
            shuoshuoVideoInfo.mDuration = jSONObject3.optLong("duration");
            shuoshuoVideoInfo.mTotalDuration = jSONObject3.optLong("totalDuration");
            shuoshuoVideoInfo.mStartTime = 0L;
            shuoshuoVideoInfo.mEndTime = shuoshuoVideoInfo.mDuration;
            shuoshuoVideoInfo.mNeedProcess = jSONObject3.optBoolean("needProcess", true);
            shuoshuoVideoInfo.topicSyncQzone = jSONObject3.optBoolean("syncQzone");
            shuoshuoVideoInfo.fakeVid = jSONObject3.optString("fakeVid");
            JSONObject optJSONObject = jSONObject3.optJSONObject("encodeExtras");
            shuoshuoVideoInfo.mExtras = new Bundle();
            if (optJSONObject != null) {
                Iterator keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    shuoshuoVideoInfo.mExtras.putInt(str, optJSONObject.optInt(str));
                }
            }
            String uuid = UUID.randomUUID().toString();
            JSONObject optJSONObject2 = jSONObject2.optJSONObject(ReportDataBuilder.KEY_EXTEND_INFO);
            long currentTimeMillis = System.currentTimeMillis();
            if (optJSONObject2 == null) {
                jSONObject = "";
            } else {
                jSONObject = optJSONObject2.toString();
            }
            QZonePublishQueue.w().b(new QZoneUploadH5VideoTask(29, shuoshuoVideoInfo, "H5Video", currentTimeMillis, uuid, jSONObject));
        } catch (JSONException e16) {
            QZLog.e(TAG, "uploadVideoForH5 error.", e16);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_DYNAMIC_CLOUD_PHOTO_SEND_SUCCESS)
    public void handlerSendDynamicPhotoSucc(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        ArrayList parcelableArrayList;
        QZLog.d(TAG, 4, "handlerSendDynamicPhotoSucc start!");
        if (sendMsg == null || handler == null || (bundle = sendMsg.extraData) == null || (parcelableArrayList = bundle.getParcelableArrayList(RemoteHandleConst.PARAM_DYNAMIC_CLOUD_PHOTOLIST)) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = parcelableArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(((QzonePhotoInfo) it.next()).mBigUrl);
        }
        EventCenter.getInstance().post("QzoneAlbum", 20);
        EventCenter.getInstance().post("PHOTOUPLOADACTION", 1, arrayList.toArray());
    }

    @ServiceCmd(RemoteHandleConst.CMD_REFRESH_PASSIVE_FEEDS)
    public void refreshPassiveFeeds(SendMsg sendMsg) {
        QZoneFeedService.b0(false).L(new Handler(Looper.getMainLooper()), null);
    }

    @ServiceCmd(RemoteHandleConst.CMD_ALUMB_THEME)
    public void handlerAlumbThemeChange(SendMsg sendMsg) {
        if (sendMsg != null) {
            try {
                Bundle bundle = sendMsg.extraData;
                if (bundle != null) {
                    bundle.getLong("param.uin", 0L);
                    AlbumThemeSkin albumThemeSkin = (AlbumThemeSkin) bundle.getSerializable(RemoteHandleConst.PARAM_ALBUM_THEME_DATA_RANDOM);
                    if (albumThemeSkin != null) {
                        if (albumThemeSkin.iItemId == -1) {
                            AlbumPersonalizeManager.L().N();
                            AlbumPersonalizeManager.L().O();
                        } else {
                            AlbumPersonalizeManager.L().T(albumThemeSkin);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_PLAY_AUDIO_LIST)
    public void handlerAudioList(SendMsg sendMsg) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong("param.uin", 0L);
        int i3 = bundle.getInt(RemoteHandleConst.PARAM_PALY_ORIGIN);
        int i16 = bundle.getInt("param.index");
        int i17 = bundle.getInt(RemoteHandleConst.PARAM_PLAY_MODE, 102);
        int i18 = i17 == 0 ? 102 : i17;
        ArrayList arrayList = (ArrayList) bundle.getSerializable(RemoteHandleConst.PARAM_SONG_LIST);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (i3 == 1 && arrayList.size() > 0) {
            e8.f.a().b().l((SongInfo) arrayList.get(0));
            return;
        }
        if (i3 != 2) {
            e8.f.a().b().k(arrayList, i16, arrayList.size(), j3, i18, i3);
            return;
        }
        x6.a g16 = z5.a.f().g(j3);
        if (g16 != null) {
            i18 = HomepageMusicPlayerBar.J(g16.bgVoiceType, g16.playMode, g16.loopPlaybackType);
        }
        e8.f.a().b().k(arrayList, i16, arrayList.size(), j3, i18, i3);
    }

    @ServiceCmd(RemoteHandleConst.CMD_PLAY_FM_BROADCAST_LIST)
    public void handlerPlayFMBroadCastList(SendMsg sendMsg) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong("param.uin", 0L);
        int i3 = bundle.getInt(RemoteHandleConst.PARAM_PALY_ORIGIN);
        int i16 = bundle.getInt("param.index");
        ArrayList arrayList = (ArrayList) bundle.getSerializable(RemoteHandleConst.PARAM_SONG_LIST);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        e8.f.a().b().d(arrayList, i16, arrayList.size(), j3, 102, i3);
    }

    @ServiceCmd(RemoteHandleConst.CMD_PLAY_MUSIC_LIST)
    public void handlerPlayMusicList(SendMsg sendMsg) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        long j3 = bundle.getLong("param.uin", 0L);
        int i3 = bundle.getInt(RemoteHandleConst.PARAM_PALY_ORIGIN);
        int i16 = bundle.getInt("param.index");
        x6.a g16 = z5.a.f().g(j3);
        byte J = g16 != null ? HomepageMusicPlayerBar.J(g16.bgVoiceType, g16.playMode, g16.loopPlaybackType) : (byte) 103;
        ArrayList arrayList = (ArrayList) bundle.getSerializable(RemoteHandleConst.PARAM_SONG_LIST);
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() == 1 && TextUtils.isEmpty(((SongInfo) arrayList.get(0)).f251870h)) {
            e8.f.a().b().l((SongInfo) arrayList.get(0));
        } else if ((i3 == 1 || i3 == 6) && arrayList.size() > 0) {
            e8.f.a().b().l((SongInfo) arrayList.get(0));
        } else {
            e8.f.a().b().n(arrayList, i16, arrayList.size(), j3, J);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_SAVE_PLAY_MODE)
    public void handlerSavePlayMode(SendMsg sendMsg) {
        Bundle bundle;
        if (sendMsg == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        bundle.getLong("param.uin", 0L);
        e8.f.a().b().j(bundle.getInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, 0), bundle.getInt(RemoteHandleConst.PARAM_PLAY_MODE_AUTO, 0), bundle.getInt(RemoteHandleConst.PARAM_PLAY_MODE_LOOP, 0));
    }

    @ServiceCmd(RemoteHandleConst.CMD_SELECT_EVENT_TAG)
    public void selectEventTag(SendMsg sendMsg) {
        if (sendMsg == null || sendMsg.getExtraData() == null) {
            return;
        }
        Bundle extraData = sendMsg.getExtraData();
        PublishEventTag publishEventTag = new PublishEventTag();
        publishEventTag.title = extraData.getString("title");
        publishEventTag.picUrl = extraData.getString("picUrl");
        publishEventTag.f45886id = extraData.getString("id");
        publishEventTag.desc = extraData.getString("desc");
        publishEventTag.f45887protocol = extraData.getString("uin") + "_102_" + publishEventTag.title;
        String string = extraData.getString(QZoneEventTagJsPlugin.TRUNCATE_NUM);
        if (string != null) {
            publishEventTag.descTruncateNum = string.length();
        } else {
            publishEventTag.descTruncateNum = 0;
        }
        publishEventTag.uin = extraData.getString("uin");
        publishEventTag.time = extraData.getString("time");
        Object[] objArr = {publishEventTag};
        if (TextUtils.isEmpty(publishEventTag.f45886id)) {
            EventCenter.getInstance().post("WriteOperation", 63, (Object[]) null);
        } else {
            EventCenter.getInstance().post("WriteOperation", 63, objArr);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_SET_HISTORY_EVENT_TAG)
    public void setHistoryEventTag(SendMsg sendMsg) {
        if (sendMsg == null || sendMsg.getExtraData() == null) {
            return;
        }
        Bundle extraData = sendMsg.getExtraData();
        if (extraData.getString("uin") != null) {
            PublishEventTag publishEventTag = new PublishEventTag();
            publishEventTag.title = extraData.getString("title");
            publishEventTag.picUrl = extraData.getString("picUrl");
            publishEventTag.f45886id = extraData.getString("id");
            publishEventTag.desc = extraData.getString("desc");
            publishEventTag.f45887protocol = extraData.getString("uin") + "_102_" + publishEventTag.title;
            String string = extraData.getString(QZoneEventTagJsPlugin.TRUNCATE_NUM);
            if (string != null) {
                publishEventTag.descTruncateNum = string.length();
            } else {
                publishEventTag.descTruncateNum = 0;
            }
            publishEventTag.uin = extraData.getString("uin");
            publishEventTag.time = extraData.getString("time");
            EventCenter.getInstance().post("WriteOperation", 64, publishEventTag);
            return;
        }
        y5.a H = y5.a.H();
        if (H != null) {
            H.C();
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_REFRESH_WEISHI_MEDAL_STATUS)
    public void switchWeishiMedal(SendMsg sendMsg) {
        if (sendMsg == null || sendMsg.getExtraData() == null) {
            return;
        }
        Bundle extraData = sendMsg.getExtraData();
        long j3 = extraData.getLong("uin", -1L);
        int i3 = extraData.getInt("isHide");
        if (j3 > 0) {
            EventCenter.getInstance().post("Feed", 30, Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    public static LbsDataV2.PoiInfo fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        LbsDataV2.PoiInfo poiInfo = new LbsDataV2.PoiInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            poiInfo.poiId = jSONObject.optString("poiId");
            poiInfo.poiName = jSONObject.optString("poiName");
            poiInfo.poiType = jSONObject.optInt("poiType");
            poiInfo.poiTypeName = jSONObject.optString("poiTypeName");
            poiInfo.address = jSONObject.optString("address");
            poiInfo.districtCode = jSONObject.optInt("districtCode");
            poiInfo.distance = jSONObject.optInt(Element.ELEMENT_NAME_DISTANCE);
            poiInfo.hotValue = jSONObject.optInt("hotValue");
            poiInfo.phoneNumber = jSONObject.optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
            poiInfo.poiDefaultName = jSONObject.optString("poiDefaultName");
            poiInfo.poiNum = jSONObject.optInt("poiNum");
            JSONObject optJSONObject = jSONObject.optJSONObject("gpsInfo");
            poiInfo.gpsInfo = new LbsDataV2.GpsInfo(optJSONObject.optInt("latitude"), optJSONObject.optInt("longtitude"), optJSONObject.optInt("altitude"), optJSONObject.optInt("gpsType"), 0);
            poiInfo.dianPingId = jSONObject.getString("dianPingId");
        } catch (JSONException e16) {
            QZLog.w(TAG, "poiInfo fromJsonString.", e16);
        }
        return poiInfo;
    }

    @ServiceCmd(RemoteHandleConst.CMD_DOWNLOADGIFT)
    public void handlerDownloadGift(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || handler == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTID);
        String string2 = bundle.getString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTURL);
        String string3 = bundle.getString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTMD5);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            return;
        }
        QzoneGiftDownloadService.i().g(string, string2, string3, sendMsg.getRequestId(), handler);
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_DEVICE_INFOS)
    public void handlerGetDeviceInfos(SendMsg sendMsg, Handler handler) {
        if (sendMsg == null || handler == null) {
            return;
        }
        new f8.a().a(LoginData.getInstance().getUin(), sendMsg.getRequestId(), handler);
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_DYNAMIC_SELNUM)
    public void handlerGetDynamicSelnum(SendMsg sendMsg, Handler handler) {
        if (sendMsg == null || handler == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(RemoteHandleConst.PARAM_DYNAMIC_CMD, sendMsg.extraData.getString(RemoteHandleConst.PARAM_DYNAMIC_CMD));
        bundle.putInt(RemoteHandleConst.PARAM_DYNAMIC_MIN, com.qzone.album.base.Service.e.e().m());
        bundle.putInt(RemoteHandleConst.PARAM_DYNAMIC_MAX, com.qzone.album.base.Service.e.e().l());
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_LIVING_INFO)
    public void handlerGetLivingInfo(SendMsg sendMsg, Handler handler) {
        e.a currentState;
        if (sendMsg == null || handler == null || (currentState = e8.f.a().b().getCurrentState()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", currentState.f395853c);
        bundle.putParcelable(RemoteHandleConst.PARAM_SONG, currentState.f395852b);
        bundle.putInt(RemoteHandleConst.PARAM_CURREN_TTIME, currentState.f395859i);
        bundle.putInt("param.duration", currentState.f395858h);
        bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, currentState.f395861k);
        bundle.putInt(RemoteHandleConst.PARAM_STATE, currentState.f395854d);
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_PLAY_MODE)
    public void handlerGetPlayMode(SendMsg sendMsg, Handler handler) {
        if (sendMsg == null || handler == null) {
            return;
        }
        Bundle bundle = new Bundle();
        x6.a g16 = z5.a.f().g(LoginData.getInstance().getUin());
        if (g16 != null) {
            bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_AUTO, g16.wifiAutoPlayFlag);
            bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, g16.playMode);
            bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_LOOP, g16.loopPlaybackType);
        } else {
            bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_AUTO, 0);
            bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, 0);
            bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_LOOP, 0);
        }
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_GET_PLAYING_SONG)
    public void handlerGetPlayingSong(SendMsg sendMsg, Handler handler) {
        e.a currentState;
        if (sendMsg == null || handler == null || (currentState = e8.f.a().b().getCurrentState()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", currentState.f395853c);
        bundle.putParcelable(RemoteHandleConst.PARAM_SONG, currentState.f395852b);
        bundle.putInt(RemoteHandleConst.PARAM_CURREN_TTIME, currentState.f395859i);
        bundle.putInt(RemoteHandleConst.PARAM_PALY_ORIGIN, currentState.f395851a);
        bundle.putInt("param.duration", currentState.f395858h);
        bundle.putInt(RemoteHandleConst.PARAM_PLAY_MODE_RANDOM, currentState.f395861k);
        bundle.putInt(RemoteHandleConst.PARAM_STATE, currentState.f395854d);
        Message obtainMessage = handler.obtainMessage(sendMsg.getRequestId());
        obtainMessage.obj = bundle;
        handler.sendMessage(obtainMessage);
    }

    @ServiceCmd(RemoteHandleConst.CMD_DOWNLOAD_PASSIVE_PRAISE)
    public void handlerPassivePraise(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || handler == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        bundle.getString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTID);
        String string = bundle.getString(RemoteHandleConst.PARAM_FULLSCREEN_GIFTURL);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        QzoneZipDownloadService.k().h(string, sendMsg.getRequestId(), handler);
    }

    @ServiceCmd(RemoteHandleConst.CMD_INIT_USERINFO)
    public void initUserInfo(SendMsg sendMsg, Handler handler) {
        if (sendMsg == null || handler == null) {
            return;
        }
        z5.a f16 = z5.a.f();
        if (f16.g(LoginData.getInstance().getUin()) == null) {
            f16.q(LoginData.getInstance().getUin(), null);
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_SET_USER_TAIL)
    public void handlerSetUserTail(SendMsg sendMsg, Handler handler) {
        Bundle bundle;
        if (sendMsg == null || handler == null || (bundle = sendMsg.extraData) == null) {
            return;
        }
        String string = bundle.getString(RemoteHandleConst.PARAM_DEVICESTRDIYDEMO);
        String string2 = bundle.getString(RemoteHandleConst.PARAM_DEVICESTRDEVICETAIL);
        String string3 = bundle.getString(RemoteHandleConst.PARAM_DEVICESTRDEVICEICON);
        String string4 = bundle.getString(RemoteHandleConst.PARAM_DEVICESTRIDENTIFYSQUA);
        if (TextUtils.isEmpty(string3)) {
            string3 = "[em]e10005[/em]";
        }
        int i3 = !TextUtils.isEmpty(string) ? 1 : 0;
        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3) || TextUtils.isEmpty(string4)) {
            return;
        }
        u5.b.v0(f8.a.f397982d + "_" + LoginData.getInstance().getUin(), string + string2);
        u5.b.v0(f8.a.f397983e + "_" + LoginData.getInstance().getUin(), string3);
        u5.b.v0(f8.a.f397984f + "_" + LoginData.getInstance().getUin(), ah.F());
        new f8.b().a(string4, string, i3, sendMsg.getRequestId(), handler);
        QZLog.i("UserTail", 1, " strIdentifySqua:" + string4 + " strDiyDemo:" + string + " mDiyTag" + i3 + " strDeviceTail" + string2 + " model:" + ah.F());
    }

    /* loaded from: classes39.dex */
    class f implements i.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SendMsg f46155a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Handler f46156b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f46157c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f46158d;

        f(SendMsg sendMsg, Handler handler, String str, String str2) {
            this.f46155a = sendMsg;
            this.f46156b = handler;
            this.f46157c = str;
            this.f46158d = str2;
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void A(String str, int i3, String str2) {
            WebPluginHandleLogic.this.handleVideoDownloadFailed(this.f46155a, this.f46156b, this.f46157c, i3, str2);
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void y(ArrayList<String> arrayList) {
            WebPluginHandleLogic.this.handleVideoDownloadSuccessfully(this.f46155a, this.f46156b, this.f46157c, this.f46158d);
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void x(String str) {
        }

        @Override // com.qzone.misc.network.downloader.i.f
        public void z(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements Consumer<RFWSaveMediaResultBean> {
        g() {
        }

        @Override // androidx.core.util.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(RFWSaveMediaResultBean rFWSaveMediaResultBean) {
        }
    }

    @ServiceCmd(RemoteHandleConst.CMD_VIDEO_STOP_ALL)
    public void handleVideoStopAll(SendMsg sendMsg) {
    }

    @ServiceCmd(RemoteHandleConst.CMD_QUN_VIDEO_PLAY)
    public void qunVideoPlay(SendMsg sendMsg) {
    }
}
