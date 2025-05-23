package com.tencent.mobileqq.zootopia.download.multidownloader;

import com.tencent.mobileqq.soload.api.SoLoadConstants;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.zootopia.download.multidownloader.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/multidownloader/f;", "", "Lcom/tencent/mobileqq/zootopia/download/multidownloader/a;", "listener", "", "b", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSoInited", "c", "isSoLoading", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listListener", "", "e", "Z", "isLastLoadError", "", "f", "I", "lastLoadErrCode", "", "g", "Ljava/lang/String;", "lastLoadErrMsg", "", h.F, "J", "lastLoadErrorTimeStamp", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isLastLoadError;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long lastLoadErrorTimeStamp;

    /* renamed from: a, reason: collision with root package name */
    public static final f f328127a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isSoInited = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isSoLoading = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<a> listListener = new CopyOnWriteArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int lastLoadErrCode = -1009901;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String lastLoadErrMsg = "";

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(long j3, int i3, LoadExtResult loadExtResult) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.i("ZPlanMultiDownloaderSoUtil", 1, "load resCode " + i3 + ", " + loadExtResult.getReportCode() + " cost: " + currentTimeMillis);
        boolean z16 = i3 == 0;
        boolean z17 = !z16;
        isLastLoadError = z17;
        lastLoadErrorTimeStamp = z17 ? System.currentTimeMillis() : -1L;
        lastLoadErrCode = i3;
        String reportStr = loadExtResult.getReportStr();
        Intrinsics.checkNotNullExpressionValue(reportStr, "result.reportStr");
        lastLoadErrMsg = reportStr;
        Iterator<T> it = listListener.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(z16, i3, loadExtResult.getReportStr());
        }
        listListener.clear();
        isSoLoading.set(false);
        isSoInited.set(z16);
    }

    public final void b(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (isSoInited.get()) {
            QLog.i("ZPlanMultiDownloaderSoUtil", 1, "so inited");
            a.C9108a.a(listener, true, 0, null, 6, null);
            return;
        }
        CopyOnWriteArrayList<a> copyOnWriteArrayList = listListener;
        copyOnWriteArrayList.add(listener);
        if (isSoLoading.get()) {
            return;
        }
        if (isLastLoadError && lastLoadErrorTimeStamp > 0 && System.currentTimeMillis() - lastLoadErrorTimeStamp <= 10000) {
            QLog.e("ZPlanMultiDownloaderSoUtil", 1, "load error and skip this time, lastLoadErrCode= " + lastLoadErrCode + ", lastLoadErrMsg= " + lastLoadErrMsg);
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(false, lastLoadErrCode, lastLoadErrMsg);
            }
            listListener.clear();
            return;
        }
        isSoLoading.set(true);
        final long currentTimeMillis = System.currentTimeMillis();
        SoLoadManager.getInstance().load(SoLoadConstants.SONAME_ZPLAN_MULTI_DOWNLOADER, new OnLoadListener() { // from class: com.tencent.mobileqq.zootopia.download.multidownloader.e
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                f.c(currentTimeMillis, i3, loadExtResult);
            }
        });
    }
}
