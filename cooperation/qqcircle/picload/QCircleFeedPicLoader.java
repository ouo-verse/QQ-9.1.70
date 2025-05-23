package cooperation.qqcircle.picload;

import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.LibraPicLoaderFactory;
import com.tencent.libra.cache.ICache;
import com.tencent.libra.cache.b;
import com.tencent.libra.cache.i;
import com.tencent.libra.extension.gif.h;
import com.tencent.libra.listener.ILoaderResultListener;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.IpConnectConfig;
import com.tencent.libra.request.Option;
import com.tencent.libra.resource.IResourceDrawableFactory;
import com.tencent.libra.strategy.ILibraGlobalStrategy;
import com.tencent.libra.strategy.ILibraLibraryStrategy;
import com.tencent.libra.thread.ITaskExecutor;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleResDrawableApi;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qcircle.picload.listener.RFWPicLoaderResultListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import cooperation.qqcircle.picload.recycle.QCirclePicLoaderRecycleManager;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import g11.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.Nullable;
import uq3.c;

/* loaded from: classes28.dex */
public class QCircleFeedPicLoader {
    public static final String TAG = "QCircle]-LibraPicLoader";
    private static volatile QCircleFeedPicLoader sInstance;
    private final IPicLoader mPicLoader;
    private final QCirclePicLoaderRecycleManager mQCircleRecycleManager;
    private static final boolean SUPPORT_REUSE_OPTION = c.z3();
    private static final Map<String, String> sKeyHashMap = new ConcurrentHashMap();

    /* loaded from: classes28.dex */
    private static class GlobalPicLoadStrategy implements ILibraGlobalStrategy {
        GlobalPicLoadStrategy() {
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ICache getCustomCache() {
            return a.a(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDecoder() {
            return a.b(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDownloaders() {
            return a.c(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IResourceDrawableFactory getDrawableFactory() {
            return a.d(this);
        }

        @Override // com.tencent.libra.strategy.ILibraGlobalStrategy
        public Looper getErrorLooper() {
            return ThreadManagerV2.getQQCommonThreadLooper();
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ILoaderResultListener getGlobalResultListener() {
            return a.e(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IpConnectConfig getIpConnectConfig(String str) {
            return a.f(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ w01.a getLibraIpStrategyBean() {
            return a.g(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ITaskExecutor getTaskExecutor() {
            return a.h(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ String getUniKeyFromUrl(String str) {
            return a.i(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return a.j(this);
        }
    }

    /* loaded from: classes28.dex */
    private static class QCirclePicLoadStrategy implements ILibraLibraryStrategy {
        private static final String BUSINESS_NAME_TAG = "qcircle";

        QCirclePicLoadStrategy() {
        }

        @Override // com.tencent.libra.strategy.ILibraLibraryStrategy
        public String getBusinessName() {
            return "qcircle";
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ICache getCustomCache() {
            return new i(new com.tencent.libra.cache.c() { // from class: cooperation.qqcircle.picload.QCircleFeedPicLoader.QCirclePicLoadStrategy.1
                @Override // com.tencent.libra.cache.c
                public Business getBusiness(Option option) {
                    return Business.QCircle;
                }

                @Override // com.tencent.libra.cache.c
                @JvmDefault
                @Nullable
                public /* bridge */ /* synthetic */ PageHierarchy getSubBusiness(@Nullable Option option) {
                    return b.b(this, option);
                }
            });
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public List<r01.a<?>> getCustomDecoder() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new z01.b());
            arrayList.add(new com.tencent.libra.extension.avif.b());
            arrayList.add(new h());
            return arrayList;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ List getCustomDownloaders() {
            return a.c(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public IResourceDrawableFactory getDrawableFactory() {
            return new QCircleResourceDrawableFactory();
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public ILoaderResultListener getGlobalResultListener() {
            return new RFWPicLoaderResultListener("3");
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ IpConnectConfig getIpConnectConfig(String str) {
            return a.f(this, str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NonNull
        public w01.a getLibraIpStrategyBean() {
            w01.a aVar = new w01.a();
            aVar.g(LibraConfigUtil.INSTANCE.enableIpFailBlacklist());
            return aVar;
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ ITaskExecutor getTaskExecutor() {
            return a.h(this);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        @NonNull
        public String getUniKeyFromUrl(@NonNull String str) {
            return QCircleFeedPicLoader.getUniKeyFromUrl(str);
        }

        @Override // com.tencent.libra.strategy.ILibraBaseStrategy
        public /* synthetic */ Boolean isSupportActiveResources() {
            return a.j(this);
        }
    }

    /* loaded from: classes28.dex */
    private static class QCircleResourceDrawableFactory implements IResourceDrawableFactory {
        private IQCircleResDrawableApi mCircleResDrawableApi = (IQCircleResDrawableApi) QRoute.api(IQCircleResDrawableApi.class);

        @Override // com.tencent.libra.resource.IResourceDrawableFactory
        public Drawable getDrawable(int i3) {
            IQCircleResDrawableApi iQCircleResDrawableApi = this.mCircleResDrawableApi;
            if (iQCircleResDrawableApi == null) {
                return null;
            }
            return iQCircleResDrawableApi.getDrawable(i3);
        }
    }

    QCircleFeedPicLoader() {
        LibraPicLoaderFactory.setGlobalPicLoadStrategy(new GlobalPicLoadStrategy());
        IPicLoader picLoader = LibraPicLoaderFactory.getPicLoader(new QCirclePicLoadStrategy());
        this.mPicLoader = picLoader;
        this.mQCircleRecycleManager = new QCirclePicLoaderRecycleManager(picLoader);
    }

    public static QCircleFeedPicLoader g() {
        if (sInstance == null) {
            synchronized (QCircleFeedPicLoader.class) {
                if (sInstance == null) {
                    sInstance = new QCircleFeedPicLoader();
                }
            }
        }
        return sInstance;
    }

    public static String getUniKeyFromUrl(@NonNull String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            Map<String, String> map = sKeyHashMap;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            int indexOf = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            if (indexOf != -1) {
                str2 = str.substring(indexOf + 3);
            } else {
                str2 = str;
            }
            int indexOf2 = str2.indexOf("/");
            if (indexOf2 != -1) {
                str2 = str2.substring(indexOf2);
            }
            int lastIndexOf = str2.lastIndexOf("#");
            if (lastIndexOf != -1) {
                str2 = str2.substring(0, lastIndexOf);
            }
            int indexOf3 = str2.indexOf("tm=");
            if (indexOf3 != -1) {
                str2 = str2.substring(0, indexOf3);
            }
            int indexOf4 = str2.indexOf("ek=1");
            if (indexOf4 != -1) {
                str2 = str2.substring(0, indexOf4);
            }
            map.put(str, str2);
            return str2;
        }
        return "";
    }

    public static Option setViewWidthHeight(Option option, View view) {
        if (option == null) {
            option = new Option();
        }
        if (view != null && view.getLayoutParams() != null) {
            option.setRequestHeight(view.getLayoutParams().height);
            option.setRequestWidth(view.getLayoutParams().width);
        }
        return option;
    }

    private void tryEnableQuic(Option option) {
        com.tencent.libra.util.a.f118813a.y(option, ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_pic_download_quic", false));
    }

    public void cancel(@NonNull Option option) {
        this.mPicLoader.cancelDownload(option);
    }

    public void deleteSdCacheIfNeed() {
        this.mPicLoader.deleteSdCacheIfNeed();
    }

    @RFWTestMock(id = "QFS_PIC_LOAD_IMAGE_MOCK")
    public void download(@NonNull Option option, IPicLoadStateListener iPicLoadStateListener) {
        this.mPicLoader.download(option, iPicLoadStateListener);
    }

    public String getCacheKey(Option option) {
        return this.mPicLoader.getRequestKey(option).toString();
    }

    public String getDownloadRootPath() {
        return this.mPicLoader.getDownloadRootPath();
    }

    public IPicLoader getPicLoader() {
        return this.mPicLoader;
    }

    public String getPicLocalPath(@NonNull Option option) {
        return this.mPicLoader.getPicLocalPath(option);
    }

    public void handlerMemoryClear() {
        this.mQCircleRecycleManager.onHandlerMemoryClear();
    }

    public void handlerMemoryRestore() {
        this.mQCircleRecycleManager.onHandlerMemoryRestore();
    }

    public void loadImage(@NonNull Option option) {
        loadImage(option, null);
    }

    public void release() {
        this.mPicLoader.release();
        sKeyHashMap.clear();
    }

    public void removeCache(@NonNull Option option) {
        this.mPicLoader.removeCache(option);
        this.mQCircleRecycleManager.removeCache(option);
    }

    public void updateOptionTargetView(Option option, ImageView imageView) {
        if (imageView != null && option != null) {
            try {
                option.setTargetView(imageView);
                this.mQCircleRecycleManager.registerOption(option);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "[updateOptionTargetView] ex: ", th5);
            }
        }
    }

    @RFWTestMock(id = "QFS_PIC_LOAD_IMAGE_MOCK")
    public void loadImage(@NonNull Option option, QCirclePicStateListener qCirclePicStateListener) {
        if (c.o6() && QCircleDeviceInfoUtils.isLowDevice() && option.getTargetView() != null) {
            option.setRegionScaleType(option.getTargetView().getScaleType());
            option.setDecodeMode(1);
        }
        option.setReuseOption(SUPPORT_REUSE_OPTION);
        if (!c.m6()) {
            option.disableHardwareDecode();
        }
        tryEnableQuic(option);
        if (option.enableAutoDeleteLocalCache() && !TextUtils.isEmpty(option.getUrl()) && (option.getUrl().contains(".cdn-go.cn/") || option.getUrl().startsWith("https://downv6.qq.com/"))) {
            option.setEnableAutoDeleteLocalCache(false);
        }
        if (qCirclePicStateListener == null) {
            qCirclePicStateListener = new QCirclePicStateListener();
        }
        this.mPicLoader.loadImage(option, qCirclePicStateListener);
        this.mQCircleRecycleManager.registerOption(option);
    }
}
