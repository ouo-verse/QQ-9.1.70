package g05;

import com.tencent.qphone.base.util.BaseApplication;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d f401054b;

    /* renamed from: a, reason: collision with root package name */
    private c f401055a = new c(BaseApplication.getContext());

    d() {
    }

    public static d b() {
        if (f401054b == null) {
            synchronized (d.class) {
                if (f401054b == null) {
                    f401054b = new d();
                }
            }
        }
        return f401054b;
    }

    public void a(DownloadInfo downloadInfo) {
        this.f401055a.c(downloadInfo.s());
    }

    public List<DownloadInfo> c() {
        return this.f401055a.d();
    }

    public boolean d(DownloadInfo downloadInfo) {
        return this.f401055a.e(downloadInfo);
    }
}
