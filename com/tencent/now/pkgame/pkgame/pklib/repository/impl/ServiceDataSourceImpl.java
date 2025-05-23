package com.tencent.now.pkgame.pkgame.pklib.repository.impl;

import com.tencent.component.core.event.EventCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.pkgame.sso.request.GetAnchorPKRankInfoRequest;
import com.tencent.now.pkgame.sso.request.GetContribRankInfoRequest;
import com.tencent.now.sso.request.GetAnchorPKInfoRequest;
import com.tencent.now.sso.request.GetLinkMicInfoRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.q;
import g55.s;
import hn3.PKEvent;
import java.util.Iterator;
import java.util.List;
import ko3.b;
import ko3.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import or4.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J&\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\rH\u0016J0\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\rH\u0016J&\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00160\rH\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/pklib/repository/impl/ServiceDataSourceImpl;", "Lko3/b;", "", "Lcom/tencent/now/pkgame/pkgame/pklib/model/a;", "pkGameInfoGetListListener", "", "d", "Lho3/a;", "pkInfoMemento", "b", "", "roomId", "anchorId", "Lko3/c;", "Lor4/g;", "callback", "c", "Lg55/q;", "e", "", "start", "count", "Lg55/s;", "f", "a", "Lho3/a;", "Ljava/util/List;", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class ServiceDataSourceImpl implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ho3.a pkInfoMemento;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends com.tencent.now.pkgame.pkgame.pklib.model.a> pkGameInfoGetListListener;

    @Override // ko3.b
    public void a(long roomId, int count, @NotNull final c<s> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetAnchorPKRankInfoRequest(roomId), new Function1<QQLiveResponse<s>, Unit>() { // from class: com.tencent.now.pkgame.pkgame.pklib.repository.impl.ServiceDataSourceImpl$fetchPkResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<s> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<s> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                s rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|ServiceDataSourceImpl", "fetchPkResult success");
                    callback.success(rsp);
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|ServiceDataSourceImpl", "fetchPkResult", "failed, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                callback.fail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }

    @Override // ko3.b
    public void b(@NotNull ho3.a pkInfoMemento) {
        Intrinsics.checkNotNullParameter(pkInfoMemento, "pkInfoMemento");
        this.pkInfoMemento = pkInfoMemento;
    }

    @Override // ko3.b
    public void c(long roomId, long anchorId, @NotNull final c<g> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetLinkMicInfoRequest(roomId, anchorId), new Function1<QQLiveResponse<g>, Unit>() { // from class: com.tencent.now.pkgame.pkgame.pklib.repository.impl.ServiceDataSourceImpl$getLinkMicInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<g> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<g> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                g rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    callback.success(rsp);
                } else {
                    callback.fail((int) response.getRetCode(), response.getErrMsg());
                }
            }
        });
    }

    @Override // ko3.b
    public void d(@NotNull List<? extends com.tencent.now.pkgame.pkgame.pklib.model.a> pkGameInfoGetListListener) {
        Intrinsics.checkNotNullParameter(pkGameInfoGetListListener, "pkGameInfoGetListListener");
        this.pkGameInfoGetListListener = pkGameInfoGetListListener;
    }

    @Override // ko3.b
    public void e(long roomId, @NotNull final c<q> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetAnchorPKInfoRequest(roomId), new Function1<QQLiveResponse<q>, Unit>() { // from class: com.tencent.now.pkgame.pkgame.pklib.repository.impl.ServiceDataSourceImpl$fetchPkGameInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<q> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<q> response) {
                ho3.a aVar;
                ho3.a aVar2;
                ho3.a aVar3;
                List list;
                Intrinsics.checkNotNullParameter(response, "response");
                q rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    companion.i("PK_Biz|ServiceDataSourceImpl", "fetchPkGameInfo success");
                    if (!com.tencent.now.linkscreengame.model.b.f338501a.d(rsp)) {
                        EventCenter.post(new PKEvent(2, 0, null, 0L, 0, 30, null));
                        return;
                    }
                    callback.success(rsp);
                    aVar = this.pkInfoMemento;
                    if (aVar != null) {
                        aVar.d(rsp);
                    }
                    aVar2 = this.pkInfoMemento;
                    if (aVar2 != null) {
                        aVar3 = this.pkInfoMemento;
                        Intrinsics.checkNotNull(aVar3);
                        if (aVar3.a()) {
                            list = this.pkGameInfoGetListListener;
                            if (list != null) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    ((com.tencent.now.pkgame.pkgame.pklib.model.a) it.next()).a(rsp);
                                }
                                return;
                            }
                            return;
                        }
                    }
                    companion.e("PK_Biz|ServiceDataSourceImpl", "PkGameInfoGetRsp", "data is invalid!");
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|ServiceDataSourceImpl", "fetchPkGameInfo", "failed, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                callback.fail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }

    @Override // ko3.b
    public void f(long roomId, int start, int count, @Nullable final c<s> callback) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetContribRankInfoRequest(roomId, start, count), new Function1<QQLiveResponse<s>, Unit>() { // from class: com.tencent.now.pkgame.pkgame.pklib.repository.impl.ServiceDataSourceImpl$fetchRankLinkPKContribList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<s> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<s> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                s rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|ServiceDataSourceImpl", "fetchRankLinkPKContribList success");
                    c<s> cVar = callback;
                    if (cVar != null) {
                        cVar.success(rsp);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|ServiceDataSourceImpl", "fetchRankLinkPKContribList", "failed, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                c<s> cVar2 = callback;
                if (cVar2 != null) {
                    cVar2.fail((int) response.getRetCode(), response.getErrMsg());
                }
            }
        });
    }
}
