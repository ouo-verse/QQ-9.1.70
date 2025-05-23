package cooperation.qqcircle;

import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import e20.a;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import qqcircle.QQCircleSwitch$SetCircleSwitchRsp;
import uq3.k;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleConfig {
    public static final String NEW_USER_GUIDE_VIDEO_URL = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8920/shaishai_guidevideo/guide_page_video_1080.mp4";
    private static final String TAG = "QCircleConfig";
    private static volatile Uri mNewUserGuideVideoPath;
    private static volatile QCircleConfig sInstance;
    private final a mConfigImpl = new a();
    private RFWDownloader.RFWDownloadListener mGetFileListener;
    private boolean mNeedShowSplash;

    QCircleConfig() {
    }

    public static boolean enablePushRocketSharePanel() {
        if (getInstance().getConfigValue("qqcircle", "qqcircle_push_rocket_pannel_share_enable", (Integer) 0).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static QCircleConfig getInstance() {
        if (sInstance == null) {
            synchronized (QCircleConfig.class) {
                if (sInstance == null) {
                    sInstance = new QCircleConfig();
                }
            }
        }
        return sInstance;
    }

    public static boolean getIsNeedAutoShowKeyboard() {
        if (getInstance().getConfigValue("qqcircle", "qqcircle_search_keyboard", (Integer) 0).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static SharedPreferences getQCircleSp() {
        return MobileQQ.sMobileQQ.getSharedPreferences("sp_qqcirlce_business" + MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), 0);
    }

    public static Long getWnsRequestCheckInterval() {
        return getInstance().getConfigValue("qqcircle", "qqcircle_check_request_strategy_interval", Long.valueOf(MiniBoxNoticeInfo.MIN_5));
    }

    public static String getWnsRequestStrategyConfig() {
        return getInstance().getConfigValue("qqcircle", "qqcircle_request_strategy_config", "");
    }

    public static boolean getWnsRequestStrategyEnable() {
        if (getInstance().getConfigValue("qqcircle", "qqcircle_check_request_strategy_enable", (Long) 0L, false).longValue() != 1) {
            return false;
        }
        return true;
    }

    public static void release() {
        QLog.d(TAG, 4, "release");
        sInstance = null;
    }

    public boolean checkIsNeedToShowGalleryNewUserGuideVideo() {
        return k.a().c("key_qcircle_gallery_new_user_guide_video", true);
    }

    public boolean checkNeedShowSplash() {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp == null) {
            return true;
        }
        return qCircleSp.getBoolean("show_splash_switch", true);
    }

    public String getConfigValue(String str, String str2) {
        return getConfigValue(str, str2, "");
    }

    public int getFuleCount() {
        return k.a().e("qcircle_fuel_count", 0);
    }

    public boolean getNeedShowSplash() {
        return this.mNeedShowSplash;
    }

    public Uri getNewUserGuideVideoPath() {
        String h16 = k.a().h("key_qcircle_gallery_new_user_video_uri", "");
        if (TextUtils.isEmpty(h16)) {
            QLog.e(TAG, 1, "video url is null");
            return null;
        }
        return Uri.parse(h16);
    }

    public void preloadSplash() {
        boolean z16;
        if (checkNeedShowSplash() && "1".equals(getInstance().getConfigValue("qqcircle", "qqcircle_splash_enable", "1"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mNeedShowSplash = z16;
    }

    public void saveFuleCount(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        RFWLog.i(TAG, RFWLog.USR, "[saveFuleCount] -> count = " + i3);
        k.a().m("qcircle_fuel_count", i3);
    }

    public void setGalleryNewUserGuideVideoNeedToShow(boolean z16) {
        k.a().j("key_qcircle_gallery_new_user_guide_video", z16);
    }

    public void setSplashNotShowAgain() {
        SharedPreferences qCircleSp = getQCircleSp();
        if (qCircleSp != null) {
            qCircleSp.edit().putBoolean("show_splash_switch", false).apply();
        }
        this.mNeedShowSplash = false;
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_splash_enable", "0"), new VSDispatchObserver.OnVSRspCallBack<QQCircleSwitch$SetCircleSwitchRsp>() { // from class: cooperation.qqcircle.QCircleConfig.1
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSwitch$SetCircleSwitchRsp qQCircleSwitch$SetCircleSwitchRsp) {
                QLog.i("QCircleFolderSplashPart", 1, "setSplashNotShowAgain isSuccess=" + z16 + ",retCode=" + j3 + ",errMsg=" + str);
                if (z16 && j3 == 0) {
                    QCircleConfig.this.updateOneConfig("qqcircle", "qqcircle_splash_enable", "0");
                }
            }
        });
    }

    public void tryGetNewUserGuideVideoAsync() {
        boolean z16;
        if (checkIsNeedToShowGalleryNewUserGuideVideo() && getNewUserGuideVideoPath() == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("tryGetSplashVideoAsync ");
            if (getNewUserGuideVideoPath() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(TAG, 1, sb5.toString());
            try {
                this.mGetFileListener = new RFWDownloader.RFWDownloadListener() { // from class: cooperation.qqcircle.QCircleConfig.2
                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void callEnd(Call call) {
                        v.a(this, call);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void callFailed(Call call, IOException iOException) {
                        v.b(this, call, iOException);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void callStart(Call call) {
                        v.c(this, call);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2) {
                        v.d(this, call, inetSocketAddress, proxy, protocol2);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol2, IOException iOException) {
                        v.e(this, call, inetSocketAddress, proxy, protocol2, iOException);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
                        v.f(this, call, inetSocketAddress, proxy);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void connectionAcquired(Call call, Connection connection) {
                        v.g(this, call, connection);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void connectionReleased(Call call, Connection connection) {
                        v.h(this, call, connection);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void dnsEnd(Call call, String str, List list) {
                        v.i(this, call, str, list);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void dnsStart(Call call, String str) {
                        v.j(this, call, str);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                    public void onRspCallback(boolean z17, String str) {
                        QLog.d(QCircleConfig.TAG, 1, "tryGetSplashVideoAsync onRspCallback " + z17 + ", " + str);
                        if (z17) {
                            File file = new File(str);
                            if (file.exists() && file.length() > 0) {
                                QCircleConfig.mNewUserGuideVideoPath = FileProvider.getUriForFile(BaseApplication.getContext(), "com.tencent.mobileqq.fileprovider", file);
                                QLog.d(QCircleConfig.TAG, 1, "tryGetSplashVideoAsync splashVideoPath: " + QCircleConfig.mNewUserGuideVideoPath);
                                k.a().p("key_qcircle_gallery_new_user_video_uri", String.valueOf(QCircleConfig.mNewUserGuideVideoPath));
                            }
                        }
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void requestBodyEnd(Call call, long j3) {
                        v.k(this, call, j3);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void requestBodyStart(Call call) {
                        v.l(this, call);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void requestHeadersEnd(Call call, Request request) {
                        v.m(this, call, request);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void requestHeadersStart(Call call) {
                        v.n(this, call);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void responseBodyEnd(Call call, long j3) {
                        v.o(this, call, j3);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void responseBodyStart(Call call) {
                        v.p(this, call);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void responseHeadersEnd(Call call, Response response) {
                        v.q(this, call, response);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void responseHeadersStart(Call call) {
                        v.r(this, call);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void secureConnectEnd(Call call, Handshake handshake) {
                        v.s(this, call, handshake);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                    public /* synthetic */ void secureConnectStart(Call call) {
                        v.t(this, call);
                    }

                    @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                    public void onDownloadProgress(float f16, long j3, long j16) {
                    }
                };
                RFWDownloaderFactory.getDownloader(vq3.a.a()).download(NEW_USER_GUIDE_VIDEO_URL, this.mGetFileListener);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "tryGetSplashVideoAsync error:", e16);
                return;
            }
        }
        QLog.d(TAG, 1, "new use guide video has been downloaded, return");
    }

    public void updateOneConfig(String str, String str2, String str3) {
        this.mConfigImpl.h(str, str2, str3);
    }

    public Integer getConfigValue(String str, String str2, Integer num) {
        return this.mConfigImpl.c(str, str2, num);
    }

    public Integer getConfigValue(String str, String str2, Integer num, boolean z16) {
        return this.mConfigImpl.d(str, str2, num, z16);
    }

    public String getConfigValue(String str, String str2, String str3) {
        return this.mConfigImpl.g(str, str2, str3);
    }

    public Boolean getConfigValue(String str, String str2, Boolean bool) {
        return this.mConfigImpl.a(str, str2, bool);
    }

    public Float getConfigValue(String str, String str2, Float f16) {
        return this.mConfigImpl.b(str, str2, f16);
    }

    public Long getConfigValue(String str, String str2, Long l3) {
        return this.mConfigImpl.e(str, str2, l3);
    }

    public Long getConfigValue(String str, String str2, Long l3, boolean z16) {
        return this.mConfigImpl.f(str, str2, l3, z16);
    }
}
