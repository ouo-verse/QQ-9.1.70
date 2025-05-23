package fa0;

import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.f;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage;
import com.tencent.biz.qqcircle.widgets.QFSRichImageView;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.libra.request.Option;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d<T extends QCircleBaseResPackage> {

    /* renamed from: a, reason: collision with root package name */
    private final String f398032a;

    /* renamed from: c, reason: collision with root package name */
    private final T f398034c;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<a> f398036e;

    /* renamed from: f, reason: collision with root package name */
    protected Map<String, RFWMultiDownloadHelper.DownloadResult> f398037f;

    /* renamed from: g, reason: collision with root package name */
    private RFWMultiDownloadHelper.MultiDownloadResultListener f398038g;

    /* renamed from: b, reason: collision with root package name */
    private volatile RFWMultiDownloadHelper f398033b = null;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f398035d = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void A2();

        void h4();
    }

    public d(T t16) {
        this.f398034c = t16;
        this.f398032a = "QCircleResLoadManager_" + t16.getClass().getSimpleName();
        this.f398037f = f(t16);
        q();
    }

    private void d(RFWMultiDownloadHelper rFWMultiDownloadHelper, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(this.f398032a, 1, "QCircleRefreshPushEffect add task error config is empty");
        } else {
            rFWMultiDownloadHelper.addTask(new RFWMultiDownloadHelper.DownloadTask(str, l()));
        }
    }

    private void e(boolean z16) {
        a aVar;
        WeakReference<a> weakReference = this.f398036e;
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            if (z16) {
                aVar.A2();
            } else {
                aVar.h4();
            }
        }
    }

    private Map<String, RFWMultiDownloadHelper.DownloadResult> f(T t16) {
        RFWDownloader downloader = RFWDownloaderFactory.getDownloader(l());
        if (downloader != null && t16 != null) {
            List<String> preloadZipList = t16.getPreloadZipList();
            if (preloadZipList == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < preloadZipList.size(); i3++) {
                String str = preloadZipList.get(i3);
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put(str, new RFWMultiDownloadHelper.DownloadResult(str, true, downloader.getContentFilePath(str)));
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    private void h(String str, ImageView imageView) {
        Option obtain = Option.obtain();
        obtain.setUrl(str);
        obtain.setTargetView(imageView);
        obtain.setRequestWidth(imageView.getWidth());
        obtain.setRequestHeight(imageView.getHeight());
        obtain.setLoadingDrawableColor(0);
        obtain.setNeedShowLoadingDrawable(false);
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    private RFWMultiDownloadHelper k() {
        if (this.f398033b == null) {
            synchronized (d.class) {
                if (this.f398033b == null) {
                    QLog.d(this.f398032a, 1, "getDownloadHelper");
                    this.f398033b = p();
                }
            }
        }
        return this.f398033b;
    }

    private RFWDownloadStrategy l() {
        return f.r();
    }

    private RFWMultiDownloadHelper p() {
        RFWMultiDownloadHelper rFWMultiDownloadHelper = new RFWMultiDownloadHelper();
        List<String> preloadZipList = this.f398034c.getPreloadZipList();
        if (preloadZipList == null) {
            QLog.e(this.f398032a, 1, "download list is empty");
            return rFWMultiDownloadHelper;
        }
        for (String str : preloadZipList) {
            if (!TextUtils.isEmpty(str)) {
                d(rFWMultiDownloadHelper, str);
            }
        }
        RFWMultiDownloadHelper.MultiDownloadResultListener multiDownloadResultListener = new RFWMultiDownloadHelper.MultiDownloadResultListener() { // from class: fa0.c
            @Override // com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener
            public final void onDownloadResult(boolean z16, Map map) {
                d.this.s(z16, map);
            }
        };
        this.f398038g = multiDownloadResultListener;
        rFWMultiDownloadHelper.setListener(multiDownloadResultListener);
        return rFWMultiDownloadHelper;
    }

    private void q() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: fa0.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.t();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(boolean z16, Map map) {
        if (z16) {
            QLog.d(this.f398032a, 1, "load anim allSucceed ,isDefaultRes = " + this.f398034c.isDefaultRes);
            this.f398035d.set(true);
            e(true);
            return;
        }
        QLog.d(this.f398032a, 1, "load anim error,isDefaultRes = " + this.f398034c.isDefaultRes);
        this.f398035d.set(false);
        e(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t() {
        boolean r16 = r();
        QLog.d(this.f398032a, 1, "initDownloadStatus:" + r16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        if (r()) {
            QLog.d(this.f398032a, 1, "preLoadRes but status is download succeed");
            return;
        }
        QLog.d(this.f398032a, 1, "preLoadRes,isDefaultRes = " + this.f398034c.isDefaultRes);
        k().start();
    }

    public void g(String str, String str2, ImageView imageView) {
        if (!r()) {
            QLog.e(this.f398032a, 1, "displayImageByFileName isResDownloadSucceed return false");
            v();
            return;
        }
        String n3 = n(str, "iconRes", str2);
        if (TextUtils.isEmpty(n3)) {
            QLog.e(this.f398032a, 1, "displayImageFromUrl fileLocalPath == null");
        } else {
            h(n3, imageView);
        }
    }

    public void i(String str, ImageView imageView) {
        File y16;
        if (imageView == null || (y16 = y(str)) == null) {
            return;
        }
        h(y16.getAbsolutePath(), imageView);
    }

    public void j(String str, QFSRichImageView qFSRichImageView) {
        File y16;
        if (qFSRichImageView == null || (y16 = y(str)) == null) {
            return;
        }
        qFSRichImageView.U(y16.getAbsolutePath());
    }

    @RFWTestMock(id = "QFS_RES_DOWNLOAD_MOCK")
    public Map<String, RFWMultiDownloadHelper.DownloadResult> m() {
        return this.f398037f;
    }

    @RFWTestMock(id = "QFS_RES_DOWNLOAD_MOCK")
    public String n(String str, String str2, String str3) {
        String str4;
        RFWMultiDownloadHelper.DownloadResult downloadResult = this.f398037f.get(str);
        if (downloadResult == null) {
            QLog.e(this.f398032a, 1, "getLocalPath downloadResult == null");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = downloadResult.mFilePath;
        } else {
            str4 = downloadResult.mFilePath + str2 + File.separator;
        }
        return new File(str4, str3).getAbsolutePath();
    }

    public T o() {
        return this.f398034c;
    }

    public boolean r() {
        if (this.f398034c == null) {
            return false;
        }
        if (this.f398035d.get()) {
            return true;
        }
        List<String> preloadZipList = this.f398034c.getPreloadZipList();
        if (preloadZipList == null) {
            return false;
        }
        RFWDownloader downloader = RFWDownloaderFactory.getDownloader(l());
        if (downloader == null) {
            QLog.e(this.f398032a, 1, "isDownloadSucceed getDownloader is null");
            return false;
        }
        for (int i3 = 0; i3 < preloadZipList.size(); i3++) {
            String str = preloadZipList.get(i3);
            if (!TextUtils.isEmpty(str) && !downloader.isFileDownLoaded(str)) {
                return false;
            }
        }
        this.f398035d.set(true);
        return true;
    }

    public void v() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: fa0.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.u();
            }
        });
    }

    public boolean w() {
        return this.f398035d.compareAndSet(true, false);
    }

    public void x(a aVar) {
        if (aVar == null) {
            this.f398036e = null;
        } else if (r()) {
            aVar.A2();
        } else {
            this.f398036e = new WeakReference<>(aVar);
        }
    }

    @RFWTestMock(id = "QFS_RES_DOWNLOAD_MOCK")
    public File y(String str) {
        if (!r()) {
            QLog.e(this.f398032a, 1, "displayImageByResUrl isResDownloadSucceed return false");
            v();
            return null;
        }
        RFWMultiDownloadHelper.DownloadResult downloadResult = this.f398037f.get(str);
        if (downloadResult == null) {
            QLog.e(this.f398032a, 1, "displayImageByResUrl downloadResult == null");
            return null;
        }
        return new File(downloadResult.mFilePath);
    }
}
