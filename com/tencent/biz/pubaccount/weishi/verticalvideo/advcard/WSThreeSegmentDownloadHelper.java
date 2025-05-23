package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import android.app.Activity;
import android.app.Application;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.downloadnew.DownloadInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\u0007*\u0002.2\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00017B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\b\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0018\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR#\u0010\u0017\u001a\n \u0012*\u0004\u0018\u00010\f0\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010-\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010)\u001a\u0004\b!\u0010*\"\u0004\b+\u0010,R\u001b\u00101\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/biz/pubaccount/weishi/download/WSDownloadParams;", "params", "", "d", "j", "i", "k", DomainData.DOMAIN_NAME, "", "url", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$a;", "result", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "g", "()Ljava/lang/String;", "downloadUrl", "", "", "c", "Ljava/util/Map;", "downloadResultMap", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "activityWeakRef", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "e", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "f", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "p", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;)V", "currentStatus", "Lcom/tencent/open/downloadnew/DownloadInfo;", "Lcom/tencent/open/downloadnew/DownloadInfo;", "()Lcom/tencent/open/downloadnew/DownloadInfo;", "o", "(Lcom/tencent/open/downloadnew/DownloadInfo;)V", "currentDownloadInfo", "com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2$a", tl.h.F, "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2$a;", "wsSimpleActivityLifecycleCallbacks", "com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$c", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$c;", "downloadListenerWrapper", "<init>", "()V", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSThreeSegmentDownloadHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final WSThreeSegmentDownloadHelper f81856a = new WSThreeSegmentDownloadHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy downloadUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<a>> downloadResultMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Activity> activityWeakRef;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static WSDownloadStatus currentStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static DownloadInfo currentDownloadInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Lazy wsSimpleActivityLifecycleCallbacks;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final c downloadListenerWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$a;", "", "", "progress", "", "onProgress", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSDownloadStatus;", "status", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public interface a {
        void a(WSDownloadStatus status);

        void onProgress(int progress);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes32.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f81864a;

        static {
            int[] iArr = new int[WSDownloadStatus.values().length];
            try {
                iArr[WSDownloadStatus.Waiting.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WSDownloadStatus.Downloading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WSDownloadStatus.Pause.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WSDownloadStatus.Installing.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f81864a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$c", "Lcom/tencent/biz/pubaccount/weishi/download/a;", "Lcom/tencent/open/downloadnew/DownloadInfo;", "info", "", "onDownloadWait", "onDownloadPause", "", "infos", "onDownloadUpdate", "onDownloadFinish", "", "appid", "packageName", "installSucceed", "", "errorCode", "errorMsg", "state", "onDownloadError", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c extends com.tencent.biz.pubaccount.weishi.download.a {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.download.a, com.tencent.open.downloadnew.DownloadListener
        public void installSucceed(String appid, String packageName) {
            super.installSucceed(appid, packageName);
            x.i("WSThreeSegmentDownloadHelper", "installSucceed");
            WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = WSThreeSegmentDownloadHelper.f81856a;
            wSThreeSegmentDownloadHelper.p(WSDownloadStatus.Installed);
            List list = (List) WSThreeSegmentDownloadHelper.downloadResultMap.get(wSThreeSegmentDownloadHelper.g());
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(WSDownloadStatus.Installed);
                }
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.download.a, com.tencent.open.downloadnew.DownloadListener
        public void onDownloadError(DownloadInfo info, int errorCode, String errorMsg, int state) {
            WeakReference weakReference;
            Activity activity;
            super.onDownloadError(info, errorCode, errorMsg, state);
            x.i("WSThreeSegmentDownloadHelper", "onDownloadError errorCode:" + errorCode + ", errorMsg:" + errorMsg);
            if (errorCode != 6 || (weakReference = WSThreeSegmentDownloadHelper.activityWeakRef) == null || (activity = (Activity) weakReference.get()) == null) {
                return;
            }
            WSThreeSegmentDownloadHelper.d(activity, new WSDownloadParams());
        }

        @Override // com.tencent.biz.pubaccount.weishi.download.a, com.tencent.open.downloadnew.DownloadListener
        public void onDownloadFinish(DownloadInfo info) {
            List<a> list;
            super.onDownloadFinish(info);
            x.i("WSThreeSegmentDownloadHelper", "onDownloadFinish");
            WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = WSThreeSegmentDownloadHelper.f81856a;
            wSThreeSegmentDownloadHelper.o(info);
            wSThreeSegmentDownloadHelper.p(WSDownloadStatus.Installing);
            DownloadManagerV2.V().a0(info);
            if (info == null || (list = (List) WSThreeSegmentDownloadHelper.downloadResultMap.get(info.f341186f)) == null) {
                return;
            }
            for (a aVar : list) {
                aVar.onProgress(100);
                aVar.a(WSDownloadStatus.Installing);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.download.a, com.tencent.open.downloadnew.DownloadListener
        public void onDownloadPause(DownloadInfo info) {
            List list;
            super.onDownloadPause(info);
            x.i("WSThreeSegmentDownloadHelper", "onDownloadPause " + this);
            WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = WSThreeSegmentDownloadHelper.f81856a;
            wSThreeSegmentDownloadHelper.o(info);
            wSThreeSegmentDownloadHelper.p(WSDownloadStatus.Pause);
            if (info == null || (list = (List) WSThreeSegmentDownloadHelper.downloadResultMap.get(info.f341186f)) == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(WSDownloadStatus.Pause);
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.download.a, com.tencent.open.downloadnew.DownloadListener
        public void onDownloadUpdate(List<DownloadInfo> infos) {
            Object firstOrNull;
            super.onDownloadUpdate(infos);
            x.i("WSThreeSegmentDownloadHelper", "onDownloadUpdate " + this);
            WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = WSThreeSegmentDownloadHelper.f81856a;
            wSThreeSegmentDownloadHelper.p(WSDownloadStatus.Downloading);
            if (infos != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) infos);
                DownloadInfo downloadInfo = (DownloadInfo) firstOrNull;
                if (downloadInfo != null) {
                    wSThreeSegmentDownloadHelper.o(downloadInfo);
                    List<a> list = (List) WSThreeSegmentDownloadHelper.downloadResultMap.get(downloadInfo.f341186f);
                    if (list != null) {
                        for (a aVar : list) {
                            aVar.a(WSDownloadStatus.Downloading);
                            aVar.onProgress(downloadInfo.Q);
                        }
                    }
                }
            }
        }

        @Override // com.tencent.biz.pubaccount.weishi.download.a, com.tencent.open.downloadnew.DownloadListener
        public void onDownloadWait(DownloadInfo info) {
            List list;
            super.onDownloadWait(info);
            x.i("WSThreeSegmentDownloadHelper", "onDownloadWait " + this);
            WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = WSThreeSegmentDownloadHelper.f81856a;
            wSThreeSegmentDownloadHelper.o(info);
            wSThreeSegmentDownloadHelper.p(WSDownloadStatus.Waiting);
            if (info == null || (list = (List) WSThreeSegmentDownloadHelper.downloadResultMap.get(info.f341186f)) == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(WSDownloadStatus.Waiting);
            }
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper$downloadUrl$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return iz.a.g().j();
            }
        });
        downloadUrl = lazy;
        downloadResultMap = new LinkedHashMap();
        currentStatus = WSDownloadStatus.Download;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2.a>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2$a", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/g;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "onActivityResumed", "onActivityDestroyed", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes32.dex */
            public static final class a extends g {
                a() {
                }

                @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityDestroyed(activity);
                    x.i("WSThreeSegmentDownloadHelper", "onActivityDestroyed : " + activity);
                    WSThreeSegmentDownloadHelper.f81856a.n();
                }

                @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.g, android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    List list;
                    List list2;
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onActivityResumed(activity);
                    WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = WSThreeSegmentDownloadHelper.f81856a;
                    x.i("WSThreeSegmentDownloadHelper", "onActivityResumed :currentStatus:" + wSThreeSegmentDownloadHelper.f() + " activity:" + activity);
                    WeakReference weakReference = WSThreeSegmentDownloadHelper.activityWeakRef;
                    if (Intrinsics.areEqual(weakReference != null ? (Activity) weakReference.get() : null, activity)) {
                        WSDownloadStatus f16 = wSThreeSegmentDownloadHelper.f();
                        WSDownloadStatus wSDownloadStatus = WSDownloadStatus.Installed;
                        if (f16 == wSDownloadStatus || wSThreeSegmentDownloadHelper.f() == WSDownloadStatus.Installing || wSThreeSegmentDownloadHelper.f() == WSDownloadStatus.Completed) {
                            WSDownloadStatus f17 = wSThreeSegmentDownloadHelper.f();
                            WeakReference weakReference2 = WSThreeSegmentDownloadHelper.activityWeakRef;
                            x.i("WSThreeSegmentDownloadHelper", "onActivityResumed :currentStatus:" + f17 + " activity:" + (weakReference2 != null ? (Activity) weakReference2.get() : null));
                            if (!com.tencent.biz.qqstory.utils.l.c(activity)) {
                                wSThreeSegmentDownloadHelper.p(WSDownloadStatus.Completed);
                                DownloadInfo e16 = wSThreeSegmentDownloadHelper.e();
                                if (e16 == null || (list2 = (List) WSThreeSegmentDownloadHelper.downloadResultMap.get(e16.f341186f)) == null) {
                                    return;
                                }
                                Iterator it = list2.iterator();
                                while (it.hasNext()) {
                                    ((WSThreeSegmentDownloadHelper.a) it.next()).a(WSDownloadStatus.Completed);
                                }
                                return;
                            }
                            wSThreeSegmentDownloadHelper.p(wSDownloadStatus);
                            DownloadInfo e17 = wSThreeSegmentDownloadHelper.e();
                            if (e17 == null || (list = (List) WSThreeSegmentDownloadHelper.downloadResultMap.get(e17.f341186f)) == null) {
                                return;
                            }
                            Iterator it5 = list.iterator();
                            while (it5.hasNext()) {
                                ((WSThreeSegmentDownloadHelper.a) it5.next()).a(WSDownloadStatus.Installed);
                            }
                        }
                    }
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a();
            }
        });
        wsSimpleActivityLifecycleCallbacks = lazy2;
        downloadListenerWrapper = new c();
    }

    WSThreeSegmentDownloadHelper() {
    }

    @JvmStatic
    public static final void d(Activity activity, WSDownloadParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        activityWeakRef = new WeakReference<>(activity);
        if (com.tencent.biz.pubaccount.weishi.util.a.c(activity)) {
            com.tencent.biz.pubaccount.weishi.util.a.b(activity);
            return;
        }
        WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = f81856a;
        wSThreeSegmentDownloadHelper.k(activity);
        com.tencent.biz.pubaccount.weishi.download.b.d(activity, wSThreeSegmentDownloadHelper.g(), params, true, 1, downloadListenerWrapper);
        currentStatus = WSDownloadStatus.Waiting;
        List<a> list = downloadResultMap.get(wSThreeSegmentDownloadHelper.g());
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(WSDownloadStatus.Waiting);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String g() {
        return (String) downloadUrl.getValue();
    }

    private final WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2.a h() {
        return (WSThreeSegmentDownloadHelper$wsSimpleActivityLifecycleCallbacks$2.a) wsSimpleActivityLifecycleCallbacks.getValue();
    }

    @JvmStatic
    public static final void i(Activity activity) {
        List<a> list;
        activityWeakRef = new WeakReference<>(activity);
        f81856a.k(activity);
        currentStatus = WSDownloadStatus.Installing;
        DownloadManagerV2.V().a0(currentDownloadInfo);
        DownloadInfo downloadInfo = currentDownloadInfo;
        if (downloadInfo == null || (list = downloadResultMap.get(downloadInfo.f341186f)) == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(WSDownloadStatus.Installing);
        }
    }

    @JvmStatic
    public static final void j() {
        DownloadManagerV2.V().o0(f81856a.g());
    }

    public final DownloadInfo e() {
        return currentDownloadInfo;
    }

    public final WSDownloadStatus f() {
        return currentStatus;
    }

    public final void l(String url, a result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        Map<String, List<a>> map = downloadResultMap;
        if (map.get(url) == null) {
            map.put(url, new ArrayList());
        }
        List<a> list = map.get(url);
        if (list != null) {
            list.add(result);
        }
    }

    public final void n() {
        WSDownloadStatus wSDownloadStatus;
        Activity activity;
        Application application;
        DownloadManagerV2.V().D0(downloadListenerWrapper);
        DownloadManagerV2.V().x(g(), false);
        WeakReference<Activity> weakReference = activityWeakRef;
        if (weakReference != null && (activity = weakReference.get()) != null && (application = activity.getApplication()) != null) {
            application.unregisterActivityLifecycleCallbacks(h());
        }
        WeakReference<Activity> weakReference2 = activityWeakRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        }
        int i3 = b.f81864a[currentStatus.ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            wSDownloadStatus = WSDownloadStatus.Download;
        } else if (i3 != 4) {
            wSDownloadStatus = currentStatus;
        } else {
            wSDownloadStatus = WSDownloadStatus.Completed;
        }
        currentStatus = wSDownloadStatus;
    }

    public final void o(DownloadInfo downloadInfo) {
        currentDownloadInfo = downloadInfo;
    }

    public final void p(WSDownloadStatus wSDownloadStatus) {
        Intrinsics.checkNotNullParameter(wSDownloadStatus, "<set-?>");
        currentStatus = wSDownloadStatus;
    }

    public final void q(String url, a result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        List<a> list = downloadResultMap.get(url);
        if (list == null) {
            return;
        }
        list.remove(result);
    }

    private final void k(Activity activity) {
        Application application;
        if (activity == null || (application = activity.getApplication()) == null) {
            return;
        }
        WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper = f81856a;
        application.unregisterActivityLifecycleCallbacks(wSThreeSegmentDownloadHelper.h());
        application.registerActivityLifecycleCallbacks(wSThreeSegmentDownloadHelper.h());
    }

    public static /* synthetic */ void m(WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper, String downloadUrl2, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            downloadUrl2 = wSThreeSegmentDownloadHelper.g();
            Intrinsics.checkNotNullExpressionValue(downloadUrl2, "downloadUrl");
        }
        wSThreeSegmentDownloadHelper.l(downloadUrl2, aVar);
    }

    public static /* synthetic */ void r(WSThreeSegmentDownloadHelper wSThreeSegmentDownloadHelper, String downloadUrl2, a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            downloadUrl2 = wSThreeSegmentDownloadHelper.g();
            Intrinsics.checkNotNullExpressionValue(downloadUrl2, "downloadUrl");
        }
        wSThreeSegmentDownloadHelper.q(downloadUrl2, aVar);
    }
}
