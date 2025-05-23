package com.tencent.mobileqq.zplan.card.impl.view.smallhome.data;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import tl.h;
import zu4.f;
import zu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \f2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b%\u0010&J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\u0006\u0010\u0010\u001a\u00020\u0007J\u0014\u0010\u0011\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0012\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0013\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0015\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0014\u0010\u0016\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b;", "Lcom/tencent/mobileqq/zplan/card/impl/view/smallhome/data/a;", "", "type", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/h;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "result", "r", "g", "", "a", "b", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "p", "j", "o", "i", "Landroidx/lifecycle/MutableLiveData;", "Lzu4/f;", "c", "Landroidx/lifecycle/MutableLiveData;", h.F, "()Landroidx/lifecycle/MutableLiveData;", "mBubblesLiveData", "d", "J", "mVisitLoadMoreTag", "e", "mLeaveMsgLoadMoreTag", "f", "mLikeLoadMoreTag", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<f> mBubblesLiveData = new MutableLiveData<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mVisitLoadMoreTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mLeaveMsgLoadMoreTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mLikeLoadMoreTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9158b implements e<zu4.h> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f332355d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference<e<zu4.h>> f332356e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f332357f;

        C9158b(long j3, WeakReference<e<zu4.h>> weakReference, b bVar) {
            this.f332355d = j3;
            this.f332356e = weakReference;
            this.f332357f = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(zu4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("SmallHomeDataHelper", 1, "processSmallHomeDataLoadMore onResultSuccess type:" + this.f332355d);
            e<zu4.h> eVar = this.f332356e.get();
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
            this.f332357f.r(this.f332355d, result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("SmallHomeDataHelper", 1, "processSmallHomeDataLoadMore type:" + this.f332355d + " fail error:" + error + ", message:" + message);
            e<zu4.h> eVar = this.f332356e.get();
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e<zu4.h> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f332358d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference<e<zu4.h>> f332359e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ b f332360f;

        c(long j3, WeakReference<e<zu4.h>> weakReference, b bVar) {
            this.f332358d = j3;
            this.f332359e = weakReference;
            this.f332360f = bVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(zu4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("SmallHomeDataHelper", 1, "processSmallHomeDataRefresh onResultSuccess type:" + this.f332358d);
            e<zu4.h> eVar = this.f332359e.get();
            if (eVar != null) {
                eVar.onResultSuccess(result);
            }
            this.f332360f.r(this.f332358d, result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("SmallHomeDataHelper", 1, "processSmallHomeDataRefresh type:" + this.f332358d + " fail error:" + error + ", message:" + message);
            e<zu4.h> eVar = this.f332359e.get();
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/card/impl/view/smallhome/data/b$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lzu4/f;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements e<f> {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(f result) {
            Intrinsics.checkNotNullParameter(result, "result");
            b.this.h().postValue(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("SmallHomeDataHelper", 1, "refreshBubbles fail error:" + error + ", message:" + message);
        }
    }

    private final void l(long type, e<zu4.h> callback) {
        g gVar = new g();
        gVar.f453436a = type;
        gVar.f453437b = g(type);
        qf3.a.d(qf3.a.f428889a, gVar, new C9158b(type, new WeakReference(callback), this), 0, 4, null);
    }

    private final void m(long type, e<zu4.h> callback) {
        g gVar = new g();
        gVar.f453436a = type;
        gVar.f453437b = 0L;
        qf3.a.d(qf3.a.f428889a, gVar, new c(type, new WeakReference(callback), this), 0, 4, null);
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.a
    public String a() {
        return "SmallHomeDataHelper";
    }

    @Override // com.tencent.mobileqq.zplan.card.impl.view.smallhome.data.a
    public void b() {
        n();
    }

    public final MutableLiveData<f> h() {
        return this.mBubblesLiveData;
    }

    public final void i(e<zu4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SmallHomeDataHelper", 1, "loadMoreSmallHomeLeaveMsgData");
        l(19L, callback);
    }

    public final void j(e<zu4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SmallHomeDataHelper", 1, "loadMoreSmallHomeLikeData");
        l(15L, callback);
    }

    public final void k(e<zu4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SmallHomeDataHelper", 1, "loadMoreSmallHomeVisitData");
        l(17L, callback);
    }

    public final void n() {
        qf3.a.b(qf3.a.f428889a, new zu4.e(), new d(), 0, 4, null);
    }

    public final void o(e<zu4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SmallHomeDataHelper", 1, "refreshSmallHomeLeaveMsgData");
        m(19L, callback);
    }

    public final void p(e<zu4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SmallHomeDataHelper", 1, "refreshSmallHomeLikeData");
        m(15L, callback);
    }

    public final void q(e<zu4.h> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("SmallHomeDataHelper", 1, "refreshSmallHomeVisitData");
        m(17L, callback);
    }

    private final long g(long type) {
        if (type == 17) {
            return this.mVisitLoadMoreTag;
        }
        if (type == 15) {
            return this.mLikeLoadMoreTag;
        }
        if (type == 19) {
            return this.mLeaveMsgLoadMoreTag;
        }
        return this.mVisitLoadMoreTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(long type, zu4.h result) {
        if (type == 17) {
            this.mVisitLoadMoreTag = result.f453441c;
            return;
        }
        if (type == 15) {
            this.mLikeLoadMoreTag = result.f453441c;
            return;
        }
        if (type == 19) {
            this.mLeaveMsgLoadMoreTag = result.f453441c;
            return;
        }
        QLog.i("SmallHomeDataHelper", 1, "updateLoadMoreTag else type:" + type);
    }
}
