package com.tencent.mobileqq.zootopia.download.proxy;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ab;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import dc3.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0016\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0019\u001a\u00020\u0018R\u0014\u0010\u001d\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R,\u0010*\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0(0'0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010!\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/proxy/ZPlanResProxyDownloader;", "", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "param", "Lqb3/a;", "listener", "", "r", "Lkotlin/Function1;", "Lqb3/b;", "action", "p", "Lkotlin/Function0;", "callback", "k", "requestParam", "", "fullUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "fullDownloadUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "logMsg", "o", DomainData.DOMAIN_NAME, "", "skipLog", "i", "b", "Ljava/lang/String;", "downloadFolderPath", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "downloadUrlMap", "Ldc3/e;", "d", "Ldc3/e;", "resGatherLoader", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "e", "downloadListenerMap", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanResProxyDownloader {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String downloadFolderPath;

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanResProxyDownloader f328186a = new ZPlanResProxyDownloader();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ZPlanResDownloadUrlRsp> downloadUrlMap = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final e resGatherLoader = new e();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, CopyOnWriteArrayList<WeakReference<qb3.b>>> downloadListenerMap = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/download/proxy/ZPlanResProxyDownloader$a", "Lqb3/a;", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "urlInfoRsp", "", "b", "", "errorCode", "", "errorMessage", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements qb3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f328191a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ qb3.a f328192b;

        a(String str, qb3.a aVar) {
            this.f328191a = str;
            this.f328192b = aVar;
        }

        @Override // qb3.a
        public void a(int errorCode, String errorMessage) {
            qb3.a aVar = this.f328192b;
            if (aVar != null) {
                aVar.a(errorCode, errorMessage);
            }
        }

        @Override // qb3.a
        public void b(ZPlanResDownloadUrlRsp urlInfoRsp) {
            Intrinsics.checkNotNullParameter(urlInfoRsp, "urlInfoRsp");
            ZPlanResProxyDownloader.downloadUrlMap.put(this.f328191a, urlInfoRsp);
            qb3.a aVar = this.f328192b;
            if (aVar != null) {
                aVar.b(urlInfoRsp);
            }
        }
    }

    static {
        String path;
        BaseApplication context = BaseApplication.getContext();
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir == null || (path = externalFilesDir.getPath()) == null) {
            path = context.getFilesDir().getPath();
        }
        downloadFolderPath = path + File.separator + "QQShowDownload";
    }

    ZPlanResProxyDownloader() {
    }

    private final void k(final Function0<Unit> callback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            callback.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.proxy.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanResProxyDownloader.l(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String m(ZPlanResDownloadReq requestParam, String fullUrl) {
        boolean startsWith$default;
        String path = requestParam.getPath();
        String q16 = q(fullUrl);
        String d16 = ab.INSTANCE.d();
        String str = downloadFolderPath;
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, separator, false, 2, null);
        return str + separator + d16 + separator + "Game" + (startsWith$default ? "" : separator) + path + q16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String logMsg) {
        QLog.e("ZPlanResProxyDownload_", 1, logMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String logMsg) {
        QLog.i("ZPlanResProxyDownload_", 1, logMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final ZPlanResDownloadReq param, final Function1<? super qb3.b, Unit> action) {
        k(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader$notifyAllExtraListeners$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                ConcurrentHashMap concurrentHashMap;
                String uniqueKey = ZPlanResDownloadReq.this.getUniqueKey();
                ArrayList arrayList = new ArrayList();
                concurrentHashMap = ZPlanResProxyDownloader.downloadListenerMap;
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) concurrentHashMap.get(uniqueKey);
                if (copyOnWriteArrayList != null) {
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        qb3.b bVar = (qb3.b) ((WeakReference) it.next()).get();
                        if (bVar != null) {
                            arrayList.add(bVar);
                        }
                    }
                }
                Function1<qb3.b, Unit> function1 = action;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((qb3.b) it5.next());
                }
            }
        });
    }

    private final String q(String fullDownloadUrl) {
        boolean endsWith$default;
        String substringAfterLast$default;
        boolean contains$default;
        endsWith$default = StringsKt__StringsJVMKt.endsWith$default(fullDownloadUrl, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, null);
        if (endsWith$default) {
            fullDownloadUrl = StringsKt__StringsKt.substringBeforeLast$default(fullDownloadUrl, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, (String) null, 2, (Object) null);
        }
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(fullDownloadUrl, ".", (String) null, 2, (Object) null);
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) substringAfterLast$default, (CharSequence) separator, false, 2, (Object) null);
        if (contains$default) {
            substringAfterLast$default = "pak";
        }
        return "." + substringAfterLast$default;
    }

    private final void r(ZPlanResDownloadReq param, qb3.a listener) {
        String uniqueKey = param.getUniqueKey();
        if (!TextUtils.isEmpty(param.getUrl())) {
            ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp = new ZPlanResDownloadUrlRsp(param.getUrl(), param.getMd5(), param.getPath());
            downloadUrlMap.put(uniqueKey, zPlanResDownloadUrlRsp);
            if (listener != null) {
                listener.b(zPlanResDownloadUrlRsp);
                return;
            }
            return;
        }
        ConcurrentHashMap<String, ZPlanResDownloadUrlRsp> concurrentHashMap = downloadUrlMap;
        if (concurrentHashMap.containsKey(uniqueKey)) {
            ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp2 = concurrentHashMap.get(uniqueKey);
            if (listener != null) {
                if (zPlanResDownloadUrlRsp2 == null) {
                    zPlanResDownloadUrlRsp2 = new ZPlanResDownloadUrlRsp("", "", "");
                }
                listener.b(zPlanResDownloadUrlRsp2);
                return;
            }
            return;
        }
        resGatherLoader.v(param, new a(uniqueKey, listener));
    }

    public final void i(ZPlanResDownloadReq param, final qb3.b listener, boolean skipLog) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (TextUtils.isEmpty(param.getPath())) {
            QLog.e("ZPlanResProxyDownload_", 1, "downloadResByPath - path empty!!!", new Throwable(""));
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.proxy.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanResProxyDownloader.j(qb3.b.this);
                }
            }, 16, null, false);
            return;
        }
        if (TextUtils.isEmpty(param.getUrl()) && !skipLog) {
            o("downloadResByPath - ZPlanResDownloadReq@" + param.hashCode() + ", containsUrl= false");
        }
        r(param, new ZPlanResProxyDownloader$downloadResByPath$2(skipLog, param, listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(qb3.b bVar) {
        if (bVar != null) {
            bVar.a(-999801, "path is empty");
        }
    }
}
