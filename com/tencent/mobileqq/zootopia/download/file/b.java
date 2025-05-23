package com.tencent.mobileqq.zootopia.download.file;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import gc3.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R4\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00120\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/file/b;", "", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lgc3/c;", "callback", "", "c", "f", "", "category", "url", "", "needProgressCallback", "d", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "remoteCallbackMap", "com/tencent/mobileqq/zootopia/download/file/b$a", "Lcom/tencent/mobileqq/zootopia/download/file/b$a;", "progressCallbackProxy", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f328050a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ArrayList<c>> remoteCallbackMap = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final a progressCallbackProxy = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/zootopia/download/file/b$a", "Lgc3/c;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "errorCode", "", "onFinalCallback", "", "progress", "", "receivedBytes", "totalBytes", "onProgress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements c {
        a() {
        }

        @Override // gc3.c
        public void onFinalCallback(String taskId, int downloadStatus, int errorCode) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            QLog.i("ZPlanFileDownloadProgressIPCHelper", 1, "progressCallbackProxy onFinalCallback - " + downloadStatus + " -" + errorCode + " - " + taskId);
            ArrayList arrayList = (ArrayList) b.remoteCallbackMap.get(taskId);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onFinalCallback(taskId, downloadStatus, errorCode);
                }
            }
            b.f328050a.f(taskId);
        }

        @Override // gc3.c
        public void onProgress(String taskId, float progress, long receivedBytes, long totalBytes) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            ArrayList arrayList = (ArrayList) b.remoteCallbackMap.get(taskId);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onProgress(taskId, progress, receivedBytes, totalBytes);
                }
            }
        }
    }

    b() {
    }

    private final void c(String taskId, c callback) {
        if (TextUtils.isEmpty(taskId)) {
            return;
        }
        ConcurrentHashMap<String, ArrayList<c>> concurrentHashMap = remoteCallbackMap;
        ArrayList<c> arrayList = concurrentHashMap.get(taskId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            concurrentHashMap.put(taskId, arrayList);
        }
        if (arrayList.contains(callback)) {
            return;
        }
        arrayList.add(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String taskId) {
        remoteCallbackMap.remove(taskId);
    }

    public final void d(int category, String url, boolean needProgressCallback, c callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String h16 = FileDownloadManager.f328148a.h(category, url);
        if (needProgressCallback) {
            QLog.i("ZPlanFileDownloadProgressIPCHelper", 1, "bindFileDownloadProgress needProgressCallback - " + h16 + " -- " + callback);
            c(h16, callback);
        }
        gc3.b bVar = (gc3.b) i.INSTANCE.a(gc3.b.class);
        if (needProgressCallback) {
            callback = null;
        }
        bVar.bindFileDownloadProgress(h16, needProgressCallback, callback);
    }

    public final c e() {
        return progressCallbackProxy;
    }
}
