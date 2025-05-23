package com.tencent.biz.qqcircle.comment.effect;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.download.RFWDownloader;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.v;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.global.QFSCommentEffectConfig;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import qqcircle.QQCircleEnvHub$CommentActivityInfo;
import qqcircle.QQCircleEnvHub$CommentEffectInfo;
import uq3.k;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentEffectUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<QQCircleEnvHub$CommentActivityInfo, AtomicInteger> f83535a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f83536b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCircleEnvHub$CommentActivityInfo f83537d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f83538e;

        a(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str) {
            this.f83537d = qQCircleEnvHub$CommentActivityInfo;
            this.f83538e = str;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess()) {
                QFSCommentEffectUtil.m(this.f83537d, this.f83538e);
            }
        }
    }

    public static void c(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        if (!l(qQCircleEnvHub$CommentActivityInfo)) {
            return;
        }
        String k3 = k(qQCircleEnvHub$CommentActivityInfo);
        int e16 = k.a().e(k3, 0);
        RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "addTriggerCount lastTriggerCount=", Integer.valueOf(e16));
        k.a().m(k3, e16 + 1);
    }

    public static boolean d(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        AtomicInteger atomicInteger = f83535a.get(qQCircleEnvHub$CommentActivityInfo);
        if (atomicInteger != null && atomicInteger.get() == h(qQCircleEnvHub$CommentActivityInfo)) {
            return true;
        }
        return false;
    }

    private static boolean e(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = qQCircleEnvHub$CommentActivityInfo.startTime.get();
        long j16 = qQCircleEnvHub$CommentActivityInfo.endTime.get();
        if (currentTimeMillis >= j3 && currentTimeMillis <= j16) {
            return true;
        }
        RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "checkTimeValid false: time invalid, currentTime=", Long.valueOf(currentTimeMillis), ",startTime=", Long.valueOf(j3), ",endTime=", Long.valueOf(j16));
        return false;
    }

    public static boolean f(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        if (!l(qQCircleEnvHub$CommentActivityInfo)) {
            return true;
        }
        int e16 = k.a().e(k(qQCircleEnvHub$CommentActivityInfo), 0);
        int i3 = qQCircleEnvHub$CommentActivityInfo.triggerLimit.get();
        RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "checkTriggerCountValid lastTriggerCount=", Integer.valueOf(e16), ",limit=", Integer.valueOf(i3));
        if (e16 < i3) {
            return true;
        }
        return false;
    }

    public static QQCircleEnvHub$CommentActivityInfo g(@NonNull String str, boolean z16, List<String> list) {
        QQCircleEnvHub$CommentEffectInfo commentEffectInfo = QFSCommentEffectConfig.getCommentEffectInfo();
        if (commentEffectInfo == null) {
            RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "getCommentActivityInfo false: commentEffectInfo = null");
            return null;
        }
        for (QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo : commentEffectInfo.activityInfo.get()) {
            if (!e(qQCircleEnvHub$CommentActivityInfo)) {
                RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "getCommentActivityInfo false: time invalid");
            } else if (!f(qQCircleEnvHub$CommentActivityInfo)) {
                RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "getCommentActivityInfo false: triggerCount invalid");
            } else if (q20.e.b(qQCircleEnvHub$CommentActivityInfo, str, z16, list)) {
                return qQCircleEnvHub$CommentActivityInfo;
            }
        }
        return null;
    }

    private static int h(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        return j(qQCircleEnvHub$CommentActivityInfo).size() + i(qQCircleEnvHub$CommentActivityInfo).size();
    }

    @NonNull
    private static List<String> i(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        ArrayList arrayList = new ArrayList();
        if (qQCircleEnvHub$CommentActivityInfo.activityStyle.get() == 0) {
            String str = qQCircleEnvHub$CommentActivityInfo.keyWordHighLightInfo.keywordHighlightResURL.get();
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @NonNull
    private static List<String> j(@NonNull QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        ArrayList arrayList = new ArrayList();
        for (String str : qQCircleEnvHub$CommentActivityInfo.expressionURLs.get()) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        String str2 = qQCircleEnvHub$CommentActivityInfo.entrancePicURL.get();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        return arrayList;
    }

    private static String k(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        return "key_comment_effect_trigger_time" + qQCircleEnvHub$CommentActivityInfo.activityID.get();
    }

    private static boolean l(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo) {
        if (qQCircleEnvHub$CommentActivityInfo.triggerLimit.get() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str) {
        Map<QQCircleEnvHub$CommentActivityInfo, AtomicInteger> map = f83535a;
        AtomicInteger atomicInteger = map.get(qQCircleEnvHub$CommentActivityInfo);
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger();
            map.put(qQCircleEnvHub$CommentActivityInfo, atomicInteger);
        }
        atomicInteger.getAndIncrement();
        RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "preloadImageInternal success activityId=", qQCircleEnvHub$CommentActivityInfo.activityID.get(), ",totalSize=", Integer.valueOf(h(qQCircleEnvHub$CommentActivityInfo)), ",currentSize=", Integer.valueOf(atomicInteger.get()), ",imageUrl=", str);
    }

    public static void n() {
        if (f83536b) {
            RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "preloadImage return: hasPreload");
        } else {
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.effect.QFSCommentEffectUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "preloadImage");
                    QFSCommentEffectUtil.o();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        QQCircleEnvHub$CommentEffectInfo commentEffectInfo = QFSCommentEffectConfig.getCommentEffectInfo();
        if (commentEffectInfo == null) {
            RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "preloadImageInternal false: commentEffectInfo = null");
            return;
        }
        f83536b = true;
        for (QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo : commentEffectInfo.activityInfo.get()) {
            if (!e(qQCircleEnvHub$CommentActivityInfo)) {
                RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "preloadImageInternal continue: time invalid");
            } else if (!f(qQCircleEnvHub$CommentActivityInfo)) {
                RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "preloadImageInternal continue: triggerCount invalid");
            } else {
                for (String str : j(qQCircleEnvHub$CommentActivityInfo)) {
                    QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str), new a(qQCircleEnvHub$CommentActivityInfo, str));
                }
                for (String str2 : i(qQCircleEnvHub$CommentActivityInfo)) {
                    RFWDownloaderFactory.getDownloader(vq3.a.a()).download(str2, new b(qQCircleEnvHub$CommentActivityInfo, str2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements RFWDownloader.RFWDownloadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCircleEnvHub$CommentActivityInfo f83539d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f83540e;

        b(QQCircleEnvHub$CommentActivityInfo qQCircleEnvHub$CommentActivityInfo, String str) {
            this.f83539d = qQCircleEnvHub$CommentActivityInfo;
            this.f83540e = str;
        }

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
        public /* synthetic */ void dnsEnd(Call call, String str, List list) {
            v.i(this, call, str, list);
        }

        @Override // com.tencent.biz.richframework.download.RFWOkHttpEventListener
        public /* synthetic */ void dnsStart(Call call, String str) {
            v.j(this, call, str);
        }

        @Override // com.tencent.biz.richframework.download.RFWDownloader.RFWDownloadListener
        public void onRspCallback(boolean z16, String str) {
            RFWLog.d("QFSCommentEffectUtil", RFWLog.USR, "preloadImageInternal isSuccess=", Boolean.valueOf(z16), " activityId=", this.f83539d.activityID.get(), ",pagImageUrl=", this.f83540e);
            if (z16) {
                QFSCommentEffectUtil.m(this.f83539d, this.f83540e);
            }
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
    }
}
