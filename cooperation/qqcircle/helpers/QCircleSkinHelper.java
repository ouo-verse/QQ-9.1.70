package cooperation.qqcircle.helpers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import androidx.core.view.LayoutInflaterCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.skin.loader.SkinManager;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.richframework.transform.RFWSkinResTransformHelper;
import cooperation.qqcircle.factory.QCircleSkinFactory2;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleFileUtils;
import feedcloud.FeedCloudCommon$Entry;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import uq3.k;
import uq3.o;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleSkinHelper {
    private static final int LOAD_SKIN_PACKAGE_DELAYED = 3000;
    public static final String QECOMMERCE_SKIN_PREFIX = "qecommerce_skin";
    public static final String QFS_BUSINESS_TAG = "qfs_skin";
    public static final String QVIDEO_SKIN_PREFIX = "qvideo_skin";
    public static final String SKIN = "skin_";
    public static final String SKIN_ASSERT_PACKAGE_NAME = "darkmode.skin";
    public static final String SKIN_ASSERT_PACKAGE_PATH;
    public static final String SKIN_BUSINESS_PREFIX = "qfs";
    public static final String SKIN_CONFIG_FILE_NAME = "config.ini";
    public static final String SKIN_DARK_MODE_TAG = "darkmode";
    public static final String SKIN_DEFAULT_MODE_CONFIG_PATH;
    public static final String SKIN_DEFAULT_MODE_TAG = "defaultmode";
    public static final String SKIN_IMAGE_URL_SECTION = "ImageURL";
    public static final String SKIN_PACKAGE_PATH_SP_KEY = "qcircle_skin_package_path";
    private static final String TAG = "QCircleSkinHelper";
    private static final String URL_PREFIX = "https://";
    private static volatile QCircleSkinHelper sHelper;
    private Context mContext;
    private QCircleIniFile mDefaultIniFile;
    private RFWDownloader.RFWDownloadListener mDownLoadListener;
    private Runnable mLoadSkinPackageDelayedTask;
    private long mStartDownloadTime;
    private long mStartLoadTime;
    private boolean isDefaultMode = true;
    private String mGetColorStateErrorMsgPrint = "";
    private String mGetColorErrorMsgPrint = "";
    private boolean mNeedReloadSkin = true;
    private int mDefaultBgColor = 0;
    private AtomicBoolean mIsPackageLoadingAtomic = new AtomicBoolean(true);
    private QCircleSkinFactory2 mQCircleSkinFactory2 = new QCircleSkinFactory2(QFS_BUSINESS_TAG);

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface SkinDownLoadLister {
        void onRspCallback(boolean z16, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class SkinDownloadListener implements SkinDownLoadLister {
        SkinDownloadListener() {
        }

        @Override // cooperation.qqcircle.helpers.QCircleSkinHelper.SkinDownLoadLister
        public void onRspCallback(boolean z16, final String str) {
            if (QCircleSkinHelper.needChangeSkin(z16, str)) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: cooperation.qqcircle.helpers.QCircleSkinHelper.SkinDownloadListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d(QCircleSkinHelper.TAG, 1, "start update theme skinPath = " + str);
                        QCircleSkinHelper.getInstance().loadSkin(str);
                    }
                });
            }
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("qfsdefaultmode");
        String str = File.separator;
        sb5.append(str);
        sb5.append(SKIN_CONFIG_FILE_NAME);
        SKIN_DEFAULT_MODE_CONFIG_PATH = sb5.toString();
        SKIN_ASSERT_PACKAGE_PATH = "qfsdarkmode" + str + SKIN_ASSERT_PACKAGE_NAME;
    }

    QCircleSkinHelper() {
    }

    private String convertUrl(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!SkinManager.g(QFS_BUSINESS_TAG).useDefaultTheme(context) && str.contains(SKIN)) {
            if (str.contains(SKIN_DEFAULT_MODE_TAG)) {
                return str.replace(SKIN_DEFAULT_MODE_TAG, SKIN_DARK_MODE_TAG);
            }
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return str;
            }
            return str.substring(0, lastIndexOf) + "_dark" + str.substring(lastIndexOf);
        }
        return str;
    }

    private boolean currentThemeIsDarkMode() {
        return QQTheme.isColorDark(getCurrentBgColor());
    }

    private int getCurrentBgColor() {
        return ie0.a.f().g(RFWApplication.getApplication(), R.color.qui_common_bg_bottom_standard, 1000);
    }

    public static QCircleSkinHelper getInstance() {
        if (sHelper == null) {
            synchronized (QCircleSkinHelper.class) {
                if (sHelper == null) {
                    sHelper = new QCircleSkinHelper();
                }
            }
        }
        return sHelper;
    }

    private long getSkinPackageVersion(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("darkmode-v(\\d+).skin").matcher(str);
        String str2 = "";
        while (matcher.find()) {
            try {
                str2 = matcher.group(1);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getSkinPackageVersion error" + e16.getMessage());
                return 0L;
            }
        }
        return Long.parseLong(str2);
    }

    private int getThemeNewObtainColorRes(Context context, int i3) {
        SkinManager g16 = SkinManager.g(QFS_BUSINESS_TAG);
        if (TextUtils.isEmpty(g16.getPackageName(RFWApplication.getApplication()))) {
            return this.mContext.getResources().getColor(i3);
        }
        if (g16.getResourceIdAndNameMap() == null) {
            return this.mContext.getResources().getColor(i3);
        }
        String str = g16.getResourceIdAndNameMap().get(String.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            return this.mContext.getResources().getColor(i3);
        }
        return g16.getColor(context, str);
    }

    private Drawable getUrlDrawable(String str, Option option) {
        if (option == null) {
            option = Option.obtain();
        }
        option.setUrl(str);
        return d30.b.f(option);
    }

    private String getUrlFromIniFile(QCircleIniFile qCircleIniFile, String str) {
        if (qCircleIniFile != null && !TextUtils.isEmpty(str)) {
            Object obj = qCircleIniFile.get(SKIN_IMAGE_URL_SECTION, str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleDownloadCallBack(boolean z16, String str, String str2, SkinDownLoadLister skinDownLoadLister, String str3) {
        String str4;
        QLog.d(TAG, 1, "downloadSkinPackage  onRspCallback isSuccess = " + z16 + "filePath = " + str);
        if (z16) {
            str4 = "0";
        } else {
            str4 = "-1";
        }
        reportDownLoadSkinEvent(str2, str4, ((float) (System.currentTimeMillis() - this.mStartDownloadTime)) / 1000.0f);
        if (skinDownLoadLister != null) {
            skinDownLoadLister.onRspCallback(z16, str);
        }
        if (!z16) {
            return;
        }
        File file = new File(str3);
        if (new File(str).exists()) {
            if (!file.exists() || file.delete()) {
                k.a().p(SKIN_PACKAGE_PATH_SP_KEY, str);
            }
        }
    }

    private boolean hasThemeChange() {
        if (this.mDefaultBgColor != getCurrentBgColor()) {
            return true;
        }
        return false;
    }

    private void initIniFile() {
        ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).executeOnSubThread(new Runnable() { // from class: cooperation.qqcircle.helpers.QCircleSkinHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    QCircleSkinHelper.this.mDefaultIniFile.load(QCircleSkinHelper.this.mContext.getAssets().open(QCircleSkinHelper.SKIN_DEFAULT_MODE_CONFIG_PATH));
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSkinPackage$0() {
        this.mIsPackageLoadingAtomic.set(false);
    }

    private void loadDarkMode() {
        if (getInstance().isSkinPackageExist("https://downv6.qq.com/video_story/qcircle/skin/debug/darkmode-v241225144809.skin")) {
            getInstance().loadSkin(RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath("https://downv6.qq.com/video_story/qcircle/skin/debug/darkmode-v241225144809.skin"));
            return;
        }
        getInstance().downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/debug/darkmode-v241225144809.skin", new SkinDownloadListener());
        String str = com.tencent.mobileqq.qcircle.api.constant.a.f261580e + SKIN_ASSERT_PACKAGE_NAME;
        QLog.d(TAG, 1, "installLocalSkinPackage start time = " + System.currentTimeMillis());
        QLog.d(TAG, 1, "installLocalSkinPackage end time = " + System.currentTimeMillis() + "success = " + getInstance().installLocalSkinPackage(str));
        getInstance().loadSkin(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadSkinPackage(String str) {
        QLog.d(TAG, 1, "loadSkinPackage skinPath = " + str);
        this.mIsPackageLoadingAtomic.set(true);
        this.mStartLoadTime = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        arrayList.add(QVIDEO_SKIN_PREFIX);
        arrayList.add(QECOMMERCE_SKIN_PREFIX);
        boolean loadSkinResource = SkinManager.g(QFS_BUSINESS_TAG).loadSkinResource(str, this.isDefaultMode, arrayList);
        boolean l06 = uq3.c.l0();
        if (l06) {
            if (loadSkinResource && o.Q1()) {
                SkinManager.g(QFS_BUSINESS_TAG).setResourceIdMap(RFWSkinResTransformHelper.g().getResourceIdMap());
                SkinManager.g(QFS_BUSINESS_TAG).setResourceIdAndNameMap(RFWSkinResTransformHelper.g().getResourceIdAndNameMap());
            } else {
                SkinManager.g(QFS_BUSINESS_TAG).setResourceIdMap(RFWSkinResTransformHelper.g().getResourceIdMap());
                SkinManager.g(QFS_BUSINESS_TAG).setResourceIdAndNameMap(RFWSkinResTransformHelper.g().getResourceIdAndNameMap());
            }
        }
        QLog.d(TAG, RFWLog.USR, "[loadSkinPackage] isLoadSuccess: " + loadSkinResource + " | enableSkinResourceMapping: " + l06);
        if (o.b1()) {
            if (this.mLoadSkinPackageDelayedTask != null) {
                RFWThreadManager.getInstance().remove(this.mLoadSkinPackageDelayedTask);
            }
            this.mLoadSkinPackageDelayedTask = new Runnable() { // from class: cooperation.qqcircle.helpers.a
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleSkinHelper.this.lambda$loadSkinPackage$0();
                }
            };
            RFWThreadManager.getInstance().execOnSubThread(this.mLoadSkinPackageDelayedTask, 3000L);
        } else {
            this.mIsPackageLoadingAtomic.set(false);
        }
        reportLoadSkinEvent("0", ((float) (System.currentTimeMillis() - this.mStartLoadTime)) / 1000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needChangeSkin(boolean z16, String str) {
        if (z16 && !getInstance().isOldSkinPackageExist() && new File(str).exists()) {
            return true;
        }
        return false;
    }

    private void reportDownLoadSkinEvent(String str, String str2, double d16) {
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_SKIN_PACKAGE_DOWNLOAD_EVENT, (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("ret_code", str2), QCircleReportHelper.newEntry("time_cost", String.valueOf(d16)), QCircleReportHelper.newEntry("url", str)));
    }

    private void reportLoadSkinEvent(String str, double d16) {
        QCircleQualityReporter.reportQualityEvent(QCircleQualityReporter.KEY_SKIN_PACKAGE_LOAD_EVENT, (List<FeedCloudCommon$Entry>) Arrays.asList(QCircleReportHelper.newEntry("ret_code", str), QCircleReportHelper.newEntry("time_cost", String.valueOf(d16))));
    }

    public void downloadSkinPackage(final String str, final SkinDownLoadLister skinDownLoadLister) {
        QLog.d(TAG, 1, "downloadSkinPackage url = " + str + "skinDownLoadLister = " + skinDownLoadLister);
        String defaultSavePath = RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(str);
        final String h16 = k.a().h(SKIN_PACKAGE_PATH_SP_KEY, "");
        if (getSkinPackageVersion(defaultSavePath) < getSkinPackageVersion(h16)) {
            return;
        }
        if (defaultSavePath.equals(h16)) {
            if (skinDownLoadLister != null) {
                skinDownLoadLister.onRspCallback(true, defaultSavePath);
            }
        } else {
            if (new File(defaultSavePath).exists() && skinDownLoadLister != null) {
                skinDownLoadLister.onRspCallback(true, defaultSavePath);
            }
            this.mStartDownloadTime = System.currentTimeMillis();
            this.mDownLoadListener = new RFWDownloader.RFWDownloadListener() { // from class: cooperation.qqcircle.helpers.QCircleSkinHelper.2
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
                public /* synthetic */ void dnsEnd(Call call, String str2, List list) {
                    v.i(this, call, str2, list);
                }

                @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
                public /* synthetic */ void dnsStart(Call call, String str2) {
                    v.j(this, call, str2);
                }

                @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
                public void onRspCallback(boolean z16, String str2) {
                    QCircleSkinHelper.this.handleDownloadCallBack(z16, str2, str, skinDownLoadLister, h16);
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
            RFWDownloaderFactory.getDownloader(vq3.a.a()).download(str, this.mDownLoadListener);
        }
    }

    public int getColor(int i3) {
        return getColor((Context) null, i3);
    }

    public ColorStateList getColorStateList(int i3) {
        return getColorStateList(null, i3);
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDefaultModeUrl(String str) {
        return getUrlFromIniFile(this.mDefaultIniFile, str);
    }

    public Drawable getDrawable(Context context, int i3) {
        try {
            if (SkinManager.g(QFS_BUSINESS_TAG).useDefaultTheme(context)) {
                return this.mContext.getResources().getDrawable(i3, null);
            }
            return SkinManager.g(QFS_BUSINESS_TAG).getDrawable(context, i3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getDrawable  error" + e16.getMessage());
            e16.printStackTrace();
            return null;
        }
    }

    public String getOldSkinPath() {
        return k.a().h(SKIN_PACKAGE_PATH_SP_KEY, "");
    }

    public QCircleSkinFactory2 getQCircleSkinFactory2() {
        return this.mQCircleSkinFactory2;
    }

    public String getUrl(Context context, String str) {
        String urlFromIniFile = getUrlFromIniFile(this.mDefaultIniFile, str);
        if (TextUtils.isEmpty(urlFromIniFile) && str.startsWith("https://")) {
            return convertUrl(context, str);
        }
        return convertUrl(context, urlFromIniFile);
    }

    public void init(Context context) {
        setContext(context);
        this.mDefaultIniFile = new QCircleIniFile();
        initIniFile();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean installLocalSkinPackage(String str) {
        FileOutputStream fileOutputStream;
        QLog.d(TAG, 1, "installLocalSkinPackage  installPath = " + str);
        InputStream inputStream = null;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                return false;
            }
            InputStream open = this.mContext.getAssets().open(SKIN_ASSERT_PACKAGE_PATH);
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e16) {
                fileOutputStream = null;
                inputStream = open;
                e = e16;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
            }
            try {
                QCircleFileUtils.copyStream(open, fileOutputStream);
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
                try {
                    fileOutputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
                return true;
            } catch (Exception e19) {
                inputStream = open;
                e = e19;
                try {
                    e.printStackTrace();
                    QLog.e(TAG, 1, "installLocalSkinPackage ", e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th6) {
                    th = th6;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e28) {
                            e28.printStackTrace();
                        }
                    }
                    if (fileOutputStream == null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (IOException e29) {
                            e29.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = open;
                th = th;
                if (inputStream != null) {
                }
                if (fileOutputStream == null) {
                }
            }
        } catch (Exception e36) {
            e = e36;
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
        }
    }

    public boolean isDarkMode() {
        return !this.isDefaultMode;
    }

    public boolean isExistsColorRes(int i3) {
        try {
            return !TextUtils.isEmpty(RFWApplication.getApplication().getResources().getResourceEntryName(i3));
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isOldSkinPackageExist() {
        return new File(getOldSkinPath()).exists();
    }

    public boolean isPackageLoading() {
        return this.mIsPackageLoadingAtomic.get();
    }

    public boolean isSkinPackageExist(String str) {
        return new File(RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(str)).exists();
    }

    public void loadResource() {
        QLog.d(TAG, 1, "[loadResource] mNeedReloadSkin = " + this.mNeedReloadSkin + ", hasThemeChange = " + hasThemeChange() + ", isDefaultMode = " + this.isDefaultMode);
        if (this.mNeedReloadSkin || hasThemeChange()) {
            this.mDefaultBgColor = getCurrentBgColor();
            this.isDefaultMode = !currentThemeIsDarkMode();
            loadDarkMode();
            getInstance().setNeedReloadSkin(false);
        }
    }

    public void loadSkin(final String str) {
        File file = new File(str);
        QLog.d(TAG, 1, "loadSkin :skinPath = " + str + " isDefaultMode = " + this.isDefaultMode + " skinPath exist = " + new File(str).exists() + " mNeedReloadSkin = " + this.mNeedReloadSkin);
        if (!file.exists()) {
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_load_skin_res_sub_thread", true)) {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: cooperation.qqcircle.helpers.QCircleSkinHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    QCircleSkinHelper.this.loadSkinPackage(str);
                }
            });
        } else {
            loadSkinPackage(str);
        }
    }

    public void release() {
        QCircleSkinFactory2 qCircleSkinFactory2 = this.mQCircleSkinFactory2;
        if (qCircleSkinFactory2 != null) {
            qCircleSkinFactory2.release();
        }
    }

    public void resetDefaultSkin() {
        QLog.d(TAG, 1, "loadSkinPackage isDefaultMode = " + this.isDefaultMode);
        if (this.isDefaultMode) {
            return;
        }
        try {
            SkinManager.g(QFS_BUSINESS_TAG).restoreDefaultTheme();
            this.isDefaultMode = true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "resetDefaultSkin error : " + e16.getMessage());
            e16.printStackTrace();
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
        SkinManager.setContext(context);
    }

    public void setNeedReloadSkin(boolean z16) {
        this.mNeedReloadSkin = z16;
    }

    public void setSkinFactory(Context context) {
        LayoutInflaterCompat.setFactory2(LayoutInflater.from(context), this.mQCircleSkinFactory2);
    }

    public int getColor(Context context, int i3) {
        try {
            if (SkinManager.g(QFS_BUSINESS_TAG).useDefaultTheme(context)) {
                return this.mContext.getResources().getColor(i3);
            }
            if (o.v1()) {
                return getThemeNewObtainColorRes(context, i3);
            }
            return SkinManager.g(QFS_BUSINESS_TAG).getColor(context, i3);
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (!TextUtils.equals(this.mGetColorErrorMsgPrint, message)) {
                QLog.e(TAG, 1, "getColor  error" + message);
                this.mGetColorErrorMsgPrint = message;
            }
            th5.printStackTrace();
            return 0;
        }
    }

    public ColorStateList getColorStateList(Context context, int i3) {
        try {
            if (SkinManager.g(QFS_BUSINESS_TAG).useDefaultTheme(context)) {
                return this.mContext.getResources().getColorStateList(i3);
            }
            return SkinManager.g(QFS_BUSINESS_TAG).getColorStateList(context, i3);
        } catch (Exception e16) {
            String message = e16.getMessage();
            if (!TextUtils.equals(this.mGetColorStateErrorMsgPrint, message)) {
                QLog.e(TAG, 1, "getColor  error" + message);
                this.mGetColorStateErrorMsgPrint = message;
            }
            e16.printStackTrace();
            return new ColorStateList((int[][]) Array.newInstance((Class<?>) Integer.TYPE, 1, 1), new int[]{0});
        }
    }

    public String getUrl(String str) {
        return getUrl(null, str);
    }

    public Drawable getDrawable(int i3) {
        return getDrawable((Context) null, i3);
    }

    public Drawable getDrawable(String str) {
        return getDrawable(str, (Option) null);
    }

    public Drawable getDrawable(String str, Option option) {
        return getDrawable(null, str, option);
    }

    public Drawable getDrawable(Context context, String str, Option option) {
        Integer num = RFWSkinResTransformHelper.g().getResourceNameAndIdMap().get(str);
        if (num == null) {
            return getUrlDrawable(getUrl(str), option);
        }
        if (SkinManager.g(QFS_BUSINESS_TAG).useDefaultTheme(context)) {
            return this.mContext.getResources().getDrawable(num.intValue(), null);
        }
        return SkinManager.g(QFS_BUSINESS_TAG).getDrawable(context, num.intValue());
    }

    public int getColor(Context context, String str) {
        Integer num = RFWSkinResTransformHelper.g().getResourceNameAndIdMap().get(str);
        if (num == null) {
            return 0;
        }
        if (SkinManager.g(QFS_BUSINESS_TAG).useDefaultTheme(context)) {
            return this.mContext.getResources().getColor(num.intValue());
        }
        return SkinManager.g(QFS_BUSINESS_TAG).getColor(context, num.intValue());
    }

    public int getColor(String str) {
        return getColor((Context) null, str);
    }
}
