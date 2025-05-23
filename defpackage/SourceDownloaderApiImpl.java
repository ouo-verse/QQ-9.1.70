package defpackage;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.mobileqq.zootopia.download.normal.f;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import yg3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0006*\u0001-\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010!R0\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060#j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0006`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010(R\u001a\u0010,\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010.\u00a8\u00062"}, d2 = {"LSourceDownloaderApiImpl;", "Lyg3/c;", "Lcom/tencent/mobileqq/zootopia/download/normal/f;", "task", "", "i", "", "sourceUrl", "", "needDelete", h.F, "url", "absFilePath", "k", "f", "path", "j", "a", "getFilePath", "Ljava/io/File;", "b", "c", "e", "", "I", "getCategory", "()I", "category", "", "Ljava/util/Map;", "absFilePathMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lyg3/c$a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "sourceDownloadListenerList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "prefixMap", "Ljava/lang/String;", "prefix", "g", "()Ljava/lang/String;", "TAG", "SourceDownloaderApiImpl$a", "LSourceDownloaderApiImpl$a;", "downloadListener", "<init>", "(I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SourceDownloaderApiImpl implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int category;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, String> absFilePathMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<c.a> sourceDownloadListenerList = new CopyOnWriteArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, String> prefixMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String prefix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final a downloadListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"SourceDownloaderApiImpl$a", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a extends ah {
        a() {
            super(null, 1, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            super.c(task);
            if (task instanceof f) {
                SourceDownloaderApiImpl.this.i((f) task);
            }
        }
    }

    public SourceDownloaderApiImpl(int i3) {
        this.category = i3;
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.prefixMap = hashMap;
        this.prefix = "";
        this.TAG = "SourceDownloaderApiImpl";
        a aVar = new a();
        this.downloadListener = aVar;
        FileDownloadManager.f328148a.f(aVar);
        hashMap.put(Integer.valueOf(ZPlanFileCategory.IMAGE.getValue()), "ZPLAN_IMAGE_");
        hashMap.put(Integer.valueOf(ZPlanFileCategory.PAG.getValue()), "ZPLAN_PAG_");
        hashMap.put(Integer.valueOf(ZPlanFileCategory.MP3_RES.getValue()), "ZPLAN_MP3_");
    }

    private final String f(String url) {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(url, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(f task) {
        QLog.i(this.TAG, 4, "onComplete :: url == " + task.getUrl() + " , filePath == " + task.getFilePath() + " , fileName == " + task.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.PARAM_FILENAME java.lang.String());
        String str = task.getFilePath() + File.separator + task.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.PARAM_FILENAME java.lang.String();
        this.absFilePathMap.put(e() + task.getUrl(), str);
        k(e() + task.getUrl(), str);
        j(task.getUrl(), str);
    }

    private final void j(String url, String path) {
        Iterator<T> it = this.sourceDownloadListenerList.iterator();
        while (it.hasNext()) {
            ((c.a) it.next()).a(url, path);
        }
    }

    private final void k(String url, String absFilePath) {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(url, absFilePath);
    }

    @Override // yg3.c
    public void a(String sourceUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        String c16 = c(sourceUrl);
        if (c16.length() > 0) {
            return;
        }
        if (new File(c16).exists()) {
            QLog.i(this.TAG, 4, "downloadSource :: file exist , absFilePath == " + c16);
            return;
        }
        h(sourceUrl, true);
    }

    @Override // yg3.c
    public File b(String sourceUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        String c16 = c(sourceUrl);
        if (c16.length() > 0) {
            return null;
        }
        File file = new File(c16);
        if (file.exists()) {
            QLog.i(this.TAG, 4, "getFileByUrl :: file exist , absFilePath == " + c16);
            return file;
        }
        h(sourceUrl, false);
        return null;
    }

    @Override // yg3.c
    public String c(String sourceUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        String str = this.absFilePathMap.get(e() + sourceUrl);
        if (str == null || str.length() == 0) {
            str = f(e() + sourceUrl);
        }
        if (new File(str).exists()) {
            QLog.i(this.TAG, 4, "isSourceExit :: sourceUrl == " + sourceUrl + ", return file path");
            return str;
        }
        QLog.i(this.TAG, 4, "isSourceExit :: sourceUrl == " + sourceUrl + ", file is deleted");
        return "";
    }

    public String e() {
        boolean z16 = true;
        if (this.prefix.length() == 0) {
            String str = this.prefixMap.get(Integer.valueOf(this.category));
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                this.prefix = String.valueOf(this.prefixMap.get(Integer.valueOf(this.category)));
            }
        }
        return this.prefix;
    }

    /* renamed from: g, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    @Override // yg3.c
    public String getFilePath(String sourceUrl) {
        Intrinsics.checkNotNullParameter(sourceUrl, "sourceUrl");
        String c16 = c(sourceUrl);
        if (c16.length() > 0) {
            return "";
        }
        File file = new File(c16);
        if (file.exists()) {
            QLog.i(this.TAG, 4, "getFilePath :: file exist , absFilePath == " + c16);
            return file.getAbsolutePath();
        }
        h(sourceUrl, true);
        return null;
    }

    private final void h(final String sourceUrl, boolean needDelete) {
        QLog.i(this.TAG, 4, "sourceUrl -> " + sourceUrl + ", needDelete -> " + needDelete);
        final FileDownloadParams fileDownloadParams = new FileDownloadParams(this.category, sourceUrl, null, null, null, null, null, null, null, false, 1020, null);
        if (needDelete) {
            FileDownloadManager.f328148a.l(fileDownloadParams, new Function0<Unit>() { // from class: SourceDownloaderApiImpl$handleDownload$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QLog.i(SourceDownloaderApiImpl.this.getTAG(), 4, "deleteTask & reDownload -> " + sourceUrl);
                    FileDownloadManager.f328148a.y(fileDownloadParams);
                }
            });
            return;
        }
        QLog.i(this.TAG, 4, "download, url == " + sourceUrl);
        FileDownloadManager.f328148a.y(new FileDownloadParams(this.category, sourceUrl, null, null, null, null, null, null, null, false, 1020, null));
    }
}
