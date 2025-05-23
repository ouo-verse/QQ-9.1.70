package dc3;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J*\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\nH\u0002J&\u0010\u0012\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0010H&J\u001e\u0010\u0016\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0004J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010\"\u001a\u0012\u0012\u0004\u0012\u00028\u00000\tj\b\u0012\u0004\u0012\u00028\u0000`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$\u00a8\u0006*"}, d2 = {"Ldc3/d;", "RequestData", "CallBackData", "", "", "fromSource", "", "j", "e", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "requestParams", "", "o", "", "requestList", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "g", "params", "", "fromLoop", "k", "", h.F, "", "i", DomainData.DOMAIN_NAME, "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "handler", "b", "Ljava/util/HashSet;", "leftNeedRequestParams", "c", "Z", "requesting", "d", "waitingPostDelay", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class d<RequestData, CallBackData> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Handler handler = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private HashSet<RequestData> leftNeedRequestParams = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean requesting;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean waitingPostDelay;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"dc3/d$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "result", "", "onResultSuccess", "(Ljava/lang/Object;)V", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.api.e<CallBackData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d<RequestData, CallBackData> f393594d;

        a(d<RequestData, CallBackData> dVar) {
            this.f393594d = dVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e(this.f393594d.n(), 1, "sendGatherRequest - onError - " + error + ", " + message);
            this.f393594d.e();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultSuccess(CallBackData result) {
            QLog.i(this.f393594d.n(), 1, "sendGatherRequest - onSuccess");
            this.f393594d.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.handler.post(new Runnable() { // from class: dc3.c
            @Override // java.lang.Runnable
            public final void run() {
                d.f(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requesting = false;
        if (this$0.leftNeedRequestParams.size() > 0) {
            this$0.k(new ArrayList(this$0.leftNeedRequestParams), true);
        }
    }

    private final void j(String fromSource) {
        List<RequestData> o16 = o(this.leftNeedRequestParams);
        if (o16.size() == 0) {
            this.requesting = false;
            return;
        }
        QLog.i(n(), 1, "requestData#PENDING, startGatherRequest from " + fromSource + ", size = " + o16.size());
        this.requesting = true;
        g(o16, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final d this$0, long j3, List params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(params, "$params");
        QLog.i(this$0.n(), 1, "requestData# RUN, startTimeStamp_" + j3 + ", requesting= " + this$0.requesting + ", waitingPostDelay= " + this$0.waitingPostDelay);
        for (Object obj : params) {
            if (!this$0.leftNeedRequestParams.contains(obj)) {
                this$0.leftNeedRequestParams.add(obj);
            }
        }
        if (this$0.leftNeedRequestParams.size() != 0) {
            if (this$0.leftNeedRequestParams.size() >= this$0.h()) {
                this$0.j("reachMaxLimit");
                return;
            }
            if (this$0.waitingPostDelay) {
                return;
            }
            this$0.waitingPostDelay = true;
            final long currentTimeMillis = System.currentTimeMillis();
            QLog.i(this$0.n(), 1, "requestData# RUN, startTimeStamp_" + j3 + ", postDelay_" + currentTimeMillis);
            this$0.handler.postDelayed(new Runnable() { // from class: dc3.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.m(d.this, currentTimeMillis);
                }
            }, this$0.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.waitingPostDelay = false;
        this$0.j("postDelay_" + j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.withIndex(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<RequestData> o(HashSet<RequestData> requestParams) {
        Set set;
        Iterable<IndexedValue> withIndex;
        ArrayList arrayList = new ArrayList();
        int h16 = h();
        if (requestParams != null && withIndex != null) {
            for (IndexedValue indexedValue : withIndex) {
                if (indexedValue.getIndex() < h16) {
                    arrayList.add(indexedValue.getValue());
                }
            }
        }
        if (requestParams != null) {
            set = CollectionsKt___CollectionsKt.toSet(arrayList);
            requestParams.removeAll(set);
        }
        return arrayList;
    }

    public abstract void g(List<? extends RequestData> requestList, com.tencent.mobileqq.zootopia.api.e<CallBackData> callback);

    public int h() {
        return 200;
    }

    public long i() {
        return 800L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(final List<? extends RequestData> params, boolean fromLoop) {
        Intrinsics.checkNotNullParameter(params, "params");
        final long currentTimeMillis = System.currentTimeMillis();
        QLog.i(n(), 1, "requestData# INSize= " + params.size() + ", leftSize= " + this.leftNeedRequestParams.size() + ", fromLoop= " + fromLoop + ", startTimeStamp_" + currentTimeMillis);
        this.handler.post(new Runnable() { // from class: dc3.a
            @Override // java.lang.Runnable
            public final void run() {
                d.l(d.this, currentTimeMillis, params);
            }
        });
    }

    public abstract String n();
}
