package bl3;

import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoParamInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import com.tencent.qphone.base.util.QLog;
import dv4.g;
import dv4.i;
import dv4.j;
import dv4.k;
import dv4.l;
import dv4.m;
import dv4.n;
import dv4.o;
import dv4.p;
import dv4.q;
import dv4.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\n\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\tJ\u001c\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tJ\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tJ\u0016\u0010\u0012\u001a\u00020\u000b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tJ4\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00180\tJ\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a\u00a8\u0006\u001f"}, d2 = {"Lbl3/a;", "", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "playInfo", "Ldv4/r;", "a", "", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", "videoInfoList", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "", h.F, "d", "", "e", "c", "Lcom/tencent/mobileqq/zplan/video/api/bean/d;", "g", "", "cid", "vid", "", "roomType", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "f", "Ldv4/e;", "result", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28625a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"bl3/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldv4/n;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bl3.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0134a implements com.tencent.mobileqq.zootopia.api.e<n> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Boolean> f28626d;

        C0134a(com.tencent.mobileqq.zootopia.api.e<Boolean> eVar) {
            this.f28626d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(n result) {
            Intrinsics.checkNotNullParameter(result, "result");
            com.tencent.mobileqq.zootopia.api.e<Boolean> eVar = this.f28626d;
            if (eVar != null) {
                eVar.onResultSuccess(Boolean.TRUE);
            }
            QLog.i("LiveStreamDataFetcher", 1, "requestCloseStream :: success , result == true");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            com.tencent.mobileqq.zootopia.api.e<Boolean> eVar = this.f28626d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            QLog.i("LiveStreamDataFetcher", 1, "requestCloseStream :: failed  error == " + error + " , message == " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"bl3/a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldv4/e;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<dv4.e> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoPlayInfo f28627d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<TXVideoInfo> f28628e;

        b(VideoPlayInfo videoPlayInfo, com.tencent.mobileqq.zootopia.api.e<TXVideoInfo> eVar) {
            this.f28627d = videoPlayInfo;
            this.f28628e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(dv4.e result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (a.f28625a.b(result)) {
                VideoMediaInfo.Companion companion = VideoMediaInfo.INSTANCE;
                j jVar = result.f395026a;
                Intrinsics.checkNotNullExpressionValue(jVar, "result.streamInfo");
                VideoMediaInfo a16 = companion.a(jVar);
                String cidUrl = result.f395028c;
                String vidUrl = result.f395029d;
                Intrinsics.checkNotNullExpressionValue(cidUrl, "cidUrl");
                Intrinsics.checkNotNullExpressionValue(vidUrl, "vidUrl");
                this.f28628e.onResultSuccess(new TXVideoInfo(this.f28627d, a16, new VideoParamInfo(cidUrl, vidUrl, result.f395027b)));
                QLog.i("LiveStreamDataFetcher", 1, "requestEnterRoom :: success , response == " + result);
                return;
            }
            this.f28628e.onResultFailure(-1, "response is invalid");
            QLog.e("LiveStreamDataFetcher", 1, "requestEnterRoom :: response is invalid, response == " + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f28628e.onResultFailure(error, message);
            QLog.e("LiveStreamDataFetcher", 1, "requestEnterRoom :: failed, error == " + error + " , message == " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"bl3/a$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldv4/l;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<l> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Boolean> f28629d;

        c(com.tencent.mobileqq.zootopia.api.e<Boolean> eVar) {
            this.f28629d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(l result) {
            Intrinsics.checkNotNullParameter(result, "result");
            com.tencent.mobileqq.zootopia.api.e<Boolean> eVar = this.f28629d;
            if (eVar != null) {
                eVar.onResultSuccess(Boolean.TRUE);
            }
            QLog.i("LiveStreamDataFetcher", 1, "requestLeaveRoom :: success , result == true");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            com.tencent.mobileqq.zootopia.api.e<Boolean> eVar = this.f28629d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
            QLog.i("LiveStreamDataFetcher", 1, "requestLeaveRoom :: failed  error == " + error + " , message == " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"bl3/a$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldv4/p;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<p> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<VideoMediaInfo> f28630d;

        d(com.tencent.mobileqq.zootopia.api.e<VideoMediaInfo> eVar) {
            this.f28630d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(p result) {
            Intrinsics.checkNotNullParameter(result, "result");
            VideoMediaInfo.Companion companion = VideoMediaInfo.INSTANCE;
            j jVar = result.f395047a;
            Intrinsics.checkNotNullExpressionValue(jVar, "result.streamInfo");
            this.f28630d.onResultSuccess(companion.a(jVar));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f28630d.onResultFailure(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"bl3/a$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldv4/g;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<g> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<VideoParamInfo> f28631d;

        e(com.tencent.mobileqq.zootopia.api.e<VideoParamInfo> eVar) {
            this.f28631d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(g result) {
            Intrinsics.checkNotNullParameter(result, "result");
            String vidUrl = result.f395032c;
            String cidUrl = result.f395031b;
            int i3 = result.f395030a;
            Intrinsics.checkNotNullExpressionValue(cidUrl, "cidUrl");
            Intrinsics.checkNotNullExpressionValue(vidUrl, "vidUrl");
            VideoParamInfo videoParamInfo = new VideoParamInfo(cidUrl, vidUrl, i3);
            com.tencent.mobileqq.zootopia.api.e<VideoParamInfo> eVar = this.f28631d;
            if (eVar != null) {
                eVar.onResultSuccess(videoParamInfo);
            }
            QLog.i("LiveStreamDataFetcher", 1, "requestWebUrlInfo :: success , result == " + result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("LiveStreamDataFetcher", 1, "requestWebUrlInfo :: failed , error == " + error + " , message == " + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"bl3/a$f", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldv4/i;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class f implements com.tencent.mobileqq.zootopia.api.e<i> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<List<TXVideoInfo>> f28632d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<TXVideoInfo> f28633e;

        f(com.tencent.mobileqq.zootopia.api.e<List<TXVideoInfo>> eVar, List<TXVideoInfo> list) {
            this.f28632d = eVar;
            this.f28633e = list;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(i result) {
            Object obj;
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.d("LiveStreamDataFetcher", 1, "sendLiveSteamHeartBeat :: success , result == " + result);
            ArrayList arrayList = new ArrayList();
            q[] qVarArr = result.f395034a;
            Intrinsics.checkNotNullExpressionValue(qVarArr, "result.tvInfoList");
            List<TXVideoInfo> list = this.f28633e;
            for (q qVar : qVarArr) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((TXVideoInfo) obj).getPlayInfo().getComponentId(), qVar.f395050a.f395036b.f395014a)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                TXVideoInfo tXVideoInfo = (TXVideoInfo) obj;
                TXVideoInfo b16 = tXVideoInfo != null ? TXVideoInfo.b(tXVideoInfo, null, null, null, 7, null) : null;
                if (b16 != null) {
                    VideoMediaInfo.Companion companion = VideoMediaInfo.INSTANCE;
                    j jVar = qVar.f395050a;
                    Intrinsics.checkNotNullExpressionValue(jVar, "streamTVInfo.streamInfo");
                    b16.f(companion.a(jVar));
                    arrayList.add(b16);
                }
            }
            com.tencent.mobileqq.zootopia.api.e<List<TXVideoInfo>> eVar = this.f28632d;
            if (eVar != null) {
                eVar.onResultSuccess(arrayList);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("LiveStreamDataFetcher", 1, "sendLiveSteamHeartBeat :: failed , error == " + error + " , message == " + message);
            com.tencent.mobileqq.zootopia.api.e<List<TXVideoInfo>> eVar = this.f28632d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    a() {
    }

    private final r a(VideoPlayInfo playInfo) {
        r rVar = new r();
        rVar.f395053a = playInfo.getOpenId();
        rVar.f395054b = playInfo.getHostOpenId();
        rVar.f395055c = 1;
        dv4.a aVar = new dv4.a();
        aVar.f395014a = playInfo.getComponentId();
        aVar.f395015b = 1;
        rVar.f395056d = aVar;
        return rVar;
    }

    public final boolean b(dv4.e result) {
        Intrinsics.checkNotNullParameter(result, "result");
        String str = result.f395028c;
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = result.f395029d;
        return ((str2 == null || str2.length() == 0) || result.f395027b <= 0 || result.f395026a == null) ? false : true;
    }

    public final void c(VideoPlayInfo playInfo, com.tencent.mobileqq.zootopia.api.e<Boolean> callback) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        m mVar = new m();
        mVar.f395042a = a(playInfo);
        QLog.i("LiveStreamDataFetcher", 1, "requestCloseStream :: start , req == " + mVar);
        bl3.b.j(bl3.b.f28634a, mVar, new C0134a(callback), 0, 4, null);
    }

    public final void d(VideoPlayInfo playInfo, com.tencent.mobileqq.zootopia.api.e<TXVideoInfo> callback) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        dv4.d dVar = new dv4.d();
        dVar.f395025a = a(playInfo);
        QLog.i("LiveStreamDataFetcher", 1, "requestEnterRoom :: start , req == " + dVar);
        bl3.b.b(bl3.b.f28634a, dVar, new b(playInfo, callback), 0, 4, null);
    }

    public final void e(VideoPlayInfo playInfo, com.tencent.mobileqq.zootopia.api.e<Boolean> callback) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        k kVar = new k();
        kVar.f395041a = a(playInfo);
        QLog.i("LiveStreamDataFetcher", 1, "requestLeaveRoom :: start , req == " + kVar);
        bl3.b.h(bl3.b.f28634a, kVar, new c(callback), 0, 4, null);
    }

    public final void f(VideoPlayInfo playInfo, String cid, String vid, int roomType, com.tencent.mobileqq.zootopia.api.e<VideoMediaInfo> callback) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(vid, "vid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("LiveStreamDataFetcher", 1, "requestSwitchVid :: start , playInfo == " + playInfo + " , cid == " + cid + " , vid == " + vid + " , roomType == " + roomType);
        o oVar = new o();
        oVar.f395043a = a(playInfo);
        bl3.b.l(bl3.b.f28634a, oVar, new d(callback), 0, 4, null);
    }

    public final void g(com.tencent.mobileqq.zootopia.api.e<VideoParamInfo> callback) {
        dv4.f fVar = new dv4.f();
        QLog.i("LiveStreamDataFetcher", 1, "requestWebUrlInfo :: start ");
        bl3.b.d(bl3.b.f28634a, fVar, new e(callback), 0, 4, null);
    }

    public final void h(List<TXVideoInfo> videoInfoList, com.tencent.mobileqq.zootopia.api.e<List<TXVideoInfo>> callback) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(videoInfoList, "videoInfoList");
        dv4.h hVar = new dv4.h();
        List<TXVideoInfo> list = videoInfoList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(f28625a.a(((TXVideoInfo) it.next()).getPlayInfo()));
        }
        Object[] array = arrayList.toArray(new r[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        hVar.f395033a = (r[]) array;
        QLog.i("LiveStreamDataFetcher", 1, "sendLiveSteamHeartBeat :: start , req == " + hVar);
        bl3.b.f(bl3.b.f28634a, hVar, new f(callback, videoInfoList), 0, 4, null);
    }
}
