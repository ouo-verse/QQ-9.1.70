package pj;

import android.text.TextUtils;
import com.tencent.biz.richframework.download.RFWDownloadStrategy;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final RFWMultiDownloadHelper f426308a = new RFWMultiDownloadHelper();

    /* renamed from: b, reason: collision with root package name */
    protected final Map<String, RFWMultiDownloadHelper.DownloadResult> f426309b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private RFWMultiDownloadHelper.MultiDownloadResultListener f426310c;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    public interface a {
        void onLoadError();

        void onLoadSucceed();
    }

    private RFWDownloadStrategy b() {
        return new u6.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(a aVar, boolean z16, Map map) {
        this.f426309b.clear();
        if (z16) {
            QLog.d("QZoneIntimateResLoadManager", 1, "load allSucceed");
            if (map != null) {
                this.f426309b.putAll(map);
            } else {
                QLog.e("QZoneIntimateResLoadManager", 1, "downloadResults is null");
            }
            if (aVar != null) {
                aVar.onLoadSucceed();
                return;
            }
            return;
        }
        QLog.e("QZoneIntimateResLoadManager", 1, "load error");
        if (aVar != null) {
            aVar.onLoadError();
        }
    }

    public String c(String str) {
        if (RFSafeMapUtils.isEmpty(this.f426309b)) {
            QLog.e("QZoneIntimateResLoadManager", 1, "[getResLocalPath] mFilePathResult is empty, url = " + str);
            return "";
        }
        RFWMultiDownloadHelper.DownloadResult downloadResult = this.f426309b.containsKey(str) ? this.f426309b.get(str) : null;
        if (downloadResult == null) {
            QLog.e("QZoneIntimateResLoadManager", 1, "[getResLocalPath] downloadResult is null, url = " + str);
            return "";
        }
        return downloadResult.mFilePath;
    }

    public void e(List<String> list, final a aVar) {
        QLog.d("QZoneIntimateResLoadManager", 1, "startLoad");
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.e("QZoneIntimateResLoadManager", 1, "[startLoad] download list is empty");
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                this.f426308a.addTask(new RFWMultiDownloadHelper.DownloadTask(str, b()));
            }
        }
        RFWMultiDownloadHelper.MultiDownloadResultListener multiDownloadResultListener = new RFWMultiDownloadHelper.MultiDownloadResultListener() { // from class: pj.i
            @Override // com.tencent.biz.richframework.download.RFWMultiDownloadHelper.MultiDownloadResultListener
            public final void onDownloadResult(boolean z16, Map map) {
                j.this.d(aVar, z16, map);
            }
        };
        this.f426310c = multiDownloadResultListener;
        this.f426308a.setListener(multiDownloadResultListener);
        this.f426308a.start();
    }
}
