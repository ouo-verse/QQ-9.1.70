package com.tencent.sqshow.zootopia.player.preload;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.s;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import la4.f;
import la4.g;
import la4.i;
import la4.j;
import la4.k;
import la4.l;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eJ-\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00022\u0016\u0010\u0013\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0012\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001b\u001a\u00020\nJ\u0016\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eJ\u0016\u0010 \u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eJ\u0016\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eR$\u0010$\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010&\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R$\u0010(\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010#R$\u0010-\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010*0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/d;", "", "", "k", "Landroid/os/Handler$Callback;", "f", "", h.F, "Lcom/tencent/superplayer/api/ISPlayerPreDownloader$Listener;", "i", "", "p", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/player/f;", "options", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QQBrowserActivity.KEY_MSG_TYPE, "", "obj", "r", "(I[Ljava/lang/Object;)V", "", "vid", ReportConstant.COSTREPORT_PREFIX, "count", "t", "mustValid", "Lcom/tencent/sqshow/zootopia/player/preload/e;", "o", "Ljava/util/concurrent/ConcurrentSkipListMap;", DomainData.DOMAIN_NAME, "l", "j", "a", "Ljava/util/concurrent/ConcurrentSkipListMap;", "mPreloadMap", "b", "mPreloadHistoryMap", "c", "mNeedContinueMap", "Ljava/util/HashMap;", "Lla4/d;", "d", "Ljava/util/HashMap;", "MSG_PROCESS_MAP", "e", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader;", "preLoader", "Landroid/os/Handler;", "Landroid/os/Handler;", "preLoadHandler", "<init>", "()V", "g", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static int f372282h = 4;

    /* renamed from: i, reason: collision with root package name */
    private static d f372283i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentSkipListMap<Integer, e> mPreloadMap = new ConcurrentSkipListMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentSkipListMap<Integer, e> mPreloadHistoryMap = new ConcurrentSkipListMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentSkipListMap<Integer, e> mNeedContinueMap = new ConcurrentSkipListMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, la4.d> MSG_PROCESS_MAP;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ISPlayerPreDownloader preLoader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Handler preLoadHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0006R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0006R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0006R\u0014\u0010\u001b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0006R\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0006R\u0014\u0010\u001e\u001a\u00020\u001d8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/d$a;", "", "Lcom/tencent/sqshow/zootopia/player/preload/d;", "a", "", "sPreloadMaxCount", "I", "c", "()I", "e", "(I)V", "sInstance", "Lcom/tencent/sqshow/zootopia/player/preload/d;", "b", "()Lcom/tencent/sqshow/zootopia/player/preload/d;", "d", "(Lcom/tencent/sqshow/zootopia/player/preload/d;)V", "MSG_ADD_PRELOAD", "MSG_CANCEL_PRELOAD", "MSG_CHECK_PRELOAD_NUM", "MSG_CONTINUE_TO_DOWNLOAD", "MSG_EXCHANGE_URL", "MSG_FEED_SELECTED", "MSG_PRELOAD_ERROR", "MSG_PRELOAD_PROGRESS", "MSG_PRELOAD_SUCCESS", "MSG_STOP_ALL", "MSG_UPDATE_MAX_PRELOAD_COUNT", "PRELOAD_DURATION", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.player.preload.d$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            if (b() == null) {
                synchronized (d.class) {
                    Companion companion = d.INSTANCE;
                    if (companion.b() == null) {
                        companion.d(new d());
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            d b16 = b();
            Intrinsics.checkNotNull(b16);
            return b16;
        }

        public final d b() {
            return d.f372283i;
        }

        public final int c() {
            return d.f372282h;
        }

        public final void d(d dVar) {
            d.f372283i = dVar;
        }

        public final void e(int i3) {
            d.f372282h = i3;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J8\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\bH\u0016J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0015H\u0016\u00a8\u0006\u0017"}, d2 = {"com/tencent/sqshow/zootopia/player/preload/d$b", "Lcom/tencent/superplayer/api/ISPlayerPreDownloader$Listener;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "onPrepareSuccess", "moduleId", "errorCode", "", "extInfo", "onPrepareError", "playableDurationMS", "downloadSpeedKBs", "", "currentDownloadSizeByte", "totalFileSizeByte", "extraInfo", "onPrepareDownloadProgressUpdate", "what", "arg1", "arg2", "", "onInfo", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ISPlayerPreDownloader.Listener {
        b() {
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onInfo(int what, long arg1, long arg2, Object extInfo) {
            Intrinsics.checkNotNullParameter(extInfo, "extInfo");
            QLog.d("VideoPreDownloadManager", 1, "onInfo: " + what + "_" + arg1 + "_" + arg2 + "_" + extInfo);
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareDownloadProgressUpdate(int taskId, int playableDurationMS, int downloadSpeedKBs, long currentDownloadSizeByte, long totalFileSizeByte, String extraInfo) {
            Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
            QLog.d("VideoPreDownloadManager", 1, "onPrepareDownloadProgressUpdate: " + taskId + "_" + playableDurationMS + "_" + downloadSpeedKBs + "_" + currentDownloadSizeByte + "_" + totalFileSizeByte + "_" + extraInfo);
            d.this.r(6, Integer.valueOf(taskId));
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareError(int taskId, int moduleId, int errorCode, String extInfo) {
            Intrinsics.checkNotNullParameter(extInfo, "extInfo");
            QLog.d("VideoPreDownloadManager", 1, 1, "onPrepareError: " + taskId);
            d.this.r(4, Integer.valueOf(taskId));
        }

        @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
        public void onPrepareSuccess(int taskId) {
            QLog.d("VideoPreDownloadManager", 1, "onPrepareSuccess: " + taskId);
            d.this.r(5, Integer.valueOf(taskId));
        }
    }

    public d() {
        HashMap<Integer, la4.d> hashMap = new HashMap<>();
        this.MSG_PROCESS_MAP = hashMap;
        hashMap.put(0, new i());
        hashMap.put(1, new f());
        hashMap.put(2, new la4.c());
        hashMap.put(3, new la4.e());
        hashMap.put(4, new la4.h());
        hashMap.put(5, new la4.a());
        hashMap.put(6, new j());
        hashMap.put(7, new l());
        hashMap.put(8, new k());
        hashMap.put(9, new la4.b());
        hashMap.put(10, new g());
        this.preLoadHandler = s.f373299a.a("VideoPreDownloadManager", k(), f());
    }

    private final Handler.Callback f() {
        return new Handler.Callback() { // from class: com.tencent.sqshow.zootopia.player.preload.c
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean g16;
                g16 = d.g(d.this, message);
                return g16;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(d this$0, Message msg2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        la4.d dVar = this$0.MSG_PROCESS_MAP.get(Integer.valueOf(msg2.what));
        if (dVar == null) {
            QLog.i("VideoPreDownloadManager", 1, "not define");
        }
        Intrinsics.checkNotNull(dVar);
        return dVar.c(msg2);
    }

    private final synchronized void h() {
        if (this.preLoader != null) {
            return;
        }
        ISPlayerPreDownloader createPreDownloader = SuperPlayerFactory.createPreDownloader(MobileQQ.sMobileQQ.getApplicationContext(), 124);
        this.preLoader = createPreDownloader;
        if (createPreDownloader != null) {
            createPreDownloader.setOnPreDownloadListener(i());
        }
    }

    private final ISPlayerPreDownloader.Listener i() {
        return new b();
    }

    private final int k() {
        return Build.VERSION.SDK_INT >= 28 ? -10 : -2;
    }

    private final boolean p() {
        if (QQVideoPlaySDKManager.isSDKReady() && m() != null) {
            return true;
        }
        QLog.i("VideoPreDownloadManager", 1, "video sdk is not ready");
        return false;
    }

    public final ConcurrentSkipListMap<Integer, e> j() {
        return this.mNeedContinueMap;
    }

    public final ConcurrentSkipListMap<Integer, e> l() {
        return this.mPreloadHistoryMap;
    }

    public final ISPlayerPreDownloader m() {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            h();
        }
        return this.preLoader;
    }

    public final ConcurrentSkipListMap<Integer, e> n() {
        return this.mPreloadMap;
    }

    public final e o(String vid, boolean mustValid) {
        if (TextUtils.isEmpty(vid)) {
            return null;
        }
        QLog.d("VideoPreDownloadManager", 1, "getValidPreloadRecord | mPreloadHistoryMap size:" + this.mPreloadHistoryMap.size());
        Iterator<Map.Entry<Integer, e>> it = this.mPreloadHistoryMap.entrySet().iterator();
        while (it.hasNext()) {
            e value = it.next().getValue();
            if (Intrinsics.areEqual(vid, value != null ? value.g() : null)) {
                if (mustValid) {
                    boolean z16 = false;
                    if (value != null && !value.i()) {
                        z16 = true;
                    }
                    if (z16) {
                    }
                }
                return value;
            }
        }
        return null;
    }

    public final void q(com.tencent.sqshow.zootopia.player.f options) {
        Intrinsics.checkNotNullParameter(options, "options");
        r(0, options, Boolean.TRUE);
    }

    public final void r(int msgType, Object... obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Message obtain = Message.obtain();
        obtain.what = msgType;
        obtain.obj = obj;
        Handler handler = this.preLoadHandler;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public final void s(String vid) {
        if (p()) {
            r(7, vid);
        }
    }

    public final void t(int count) {
        r(9, Integer.valueOf(count));
    }
}
