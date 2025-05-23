package com.tencent.now.linkscreengame.model;

import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.now.sso.request.GetLinkMicInfoRequest;
import com.tencent.now.sso.request.QQLiveGetStreamRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import or4.g;
import or4.i;
import or4.j;
import or4.n;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\r\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0002R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/now/linkscreengame/model/LinkScreenModel;", "Lcom/tencent/component/core/thread/ThreadCenter$HandlerKeyable;", "", "f", "l", "Lhn3/a;", "anchorInfo", h.F, "", "Lor4/n;", "items", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lhn3/a;[Lor4/n;)V", "k", "([Lor4/n;)V", "", "bizID", "", "i", "j", DomainData.DOMAIN_NAME, "", "d", "J", "roomId", "e", "g", "()J", "anchorId", "Lin3/b;", "Lin3/b;", "pushApi", "Ljn3/a;", "Ljn3/a;", "linkScreenStateMgr", "<init>", "(JJ)V", "a", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class LinkScreenModel implements ThreadCenter.HandlerKeyable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long anchorId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final in3.b pushApi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final jn3.a linkScreenStateMgr = new jn3.b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/now/linkscreengame/model/LinkScreenModel$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lor4/i;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ILiveNetRequest.Callback<i> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinkScreenAnchorInfo f338497b;

        b(LinkScreenAnchorInfo linkScreenAnchorInfo) {
            this.f338497b = linkScreenAnchorInfo;
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<i> response) {
            n[] nVarArr;
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isFailed()) {
                AegisLogger.INSTANCE.e("PK_Biz|PKWithOBS|LinkScreenModel", "GetStream error", "ret:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                return;
            }
            LinkScreenModel linkScreenModel = LinkScreenModel.this;
            i rsp = response.getRsp();
            n[] nVarArr2 = null;
            if (rsp != null) {
                nVarArr = rsp.f423497a;
            } else {
                nVarArr = null;
            }
            linkScreenModel.k(nVarArr);
            LinkScreenModel linkScreenModel2 = LinkScreenModel.this;
            LinkScreenAnchorInfo linkScreenAnchorInfo = this.f338497b;
            i rsp2 = response.getRsp();
            if (rsp2 != null) {
                nVarArr2 = rsp2.f423497a;
            }
            linkScreenModel2.m(linkScreenAnchorInfo, nVarArr2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkscreengame/model/LinkScreenModel$c", "Lin3/a;", "Lh55/b;", "anchorSwitchMic", "", "b", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements in3.a<h55.b> {
        c() {
        }

        @Override // in3.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull h55.b anchorSwitchMic) {
            Intrinsics.checkNotNullParameter(anchorSwitchMic, "anchorSwitchMic");
            int i3 = anchorSwitchMic.f404402b.f404410c.f404405a;
            int i16 = anchorSwitchMic.f404401a;
            AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkScreenModel", "receiveData EndLinkScreen, bizId: " + i3 + ", linkMicStatus: " + i16 + ", anchorId:" + anchorSwitchMic.f404403c);
            if (LinkScreenModel.this.i(i3) && i16 == 0) {
                EventCenter.post(new LinkScreenEvent(2, null, 2, null));
                LinkScreenModel.this.linkScreenStateMgr.c();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkscreengame/model/LinkScreenModel$d", "Lin3/a;", "Lh55/a;", "anchorAllowMic", "", "b", "qq-live-linkscreen-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements in3.a<h55.a> {
        d() {
        }

        @Override // in3.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull h55.a anchorAllowMic) {
            Intrinsics.checkNotNullParameter(anchorAllowMic, "anchorAllowMic");
            int i3 = anchorAllowMic.f404393g.f404410c.f404405a;
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("PK_Biz|PKWithOBS|LinkScreenModel", "receiveData StartLinkScreen 105, bizId: " + i3 + ", fansRoomId: " + anchorAllowMic.f404394h + ", uid: " + anchorAllowMic.f404387a + ", nick:" + anchorAllowMic.f404389c + ",liveType:" + anchorAllowMic.f404400n);
            if (LinkScreenModel.this.i(i3)) {
                long j3 = anchorAllowMic.f404394h;
                long j16 = anchorAllowMic.f404387a;
                String str = anchorAllowMic.f404389c;
                Intrinsics.checkNotNullExpressionValue(str, "anchorAllowMic.nickName");
                String str2 = anchorAllowMic.f404390d;
                Intrinsics.checkNotNullExpressionValue(str2, "anchorAllowMic.logoUrl");
                LinkScreenAnchorInfo linkScreenAnchorInfo = new LinkScreenAnchorInfo(j3, j16, str, str2, anchorAllowMic.f404400n);
                if (!com.tencent.now.linkscreengame.model.c.f338502a.a(anchorAllowMic.f404400n)) {
                    LinkScreenModel.this.m(linkScreenAnchorInfo, null);
                } else {
                    companion.i("PK_Biz|PKWithOBS|LinkScreenModel", "\u6ce8\u610f\uff0c\u6709\u4e00\u65b9\u4e3aOBS\u4e3b\u64ad");
                    LinkScreenModel.this.h(linkScreenAnchorInfo);
                }
            }
        }
    }

    public LinkScreenModel(long j3, long j16) {
        this.roomId = j3;
        this.anchorId = j16;
        this.pushApi = new in3.b(j3);
        f();
        l();
    }

    private final void f() {
        if (this.linkScreenStateMgr.getIsInLinkScreen()) {
            return;
        }
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetLinkMicInfoRequest(this.roomId, this.anchorId), new Function1<QQLiveResponse<g>, Unit>() { // from class: com.tencent.now.linkscreengame.model.LinkScreenModel$checkIsInLinkScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                LinkScreenAnchorInfo a16;
                j jVar;
                or4.b bVar;
                Intrinsics.checkNotNullParameter(response, "response");
                g rsp = response.getRsp();
                if (!response.isFailed()) {
                    if (!LinkScreenModel.this.i((rsp == null || (jVar = rsp.f423493h) == null || (bVar = jVar.f423500c) == null) ? 0 : bVar.f423475a) || (a16 = a.f338500a.a(LinkScreenModel.this.getAnchorId(), rsp)) == null) {
                        return;
                    }
                    LinkScreenModel linkScreenModel = LinkScreenModel.this;
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    companion.i("PK_Biz|PKWithOBS|LinkScreenModel", "checkIsInLinkScreen", "inLinkScreen, \u62c9\u8d77\u53cc\u5c4f: " + a16);
                    if (!c.f338502a.a(a16.getLiveType())) {
                        linkScreenModel.m(a16, null);
                    } else {
                        companion.i("PK_Biz|PKWithOBS|LinkScreenModel", "\u68c0\u6d4b\u6062\u590d\u8fde\u5c4f\uff0c\u6ce8\u610f\uff0c\u6709\u4e00\u65b9\u4e3aOBS\u4e3b\u64ad");
                        linkScreenModel.h(a16);
                    }
                    linkScreenModel.linkScreenStateMgr.a(a16);
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|PKWithOBS|LinkScreenModel", "checkIsInLinkScreen", "fail, code: " + response.getRetCode() + ", msg: " + response.getErrMsg());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(LinkScreenAnchorInfo anchorInfo) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetStreamRequest(new long[]{this.anchorId, anchorInfo.getUin()}), new b(anchorInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(int bizID) {
        if (bizID != 8 && bizID != 6) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(n[] items) {
        if (items != null) {
            for (n nVar : items) {
                AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkScreenModel", "OBS\u8fde\u9ea6\u573a\u666f, anchorUid:" + nVar.f423524a);
                or4.a[] aVarArr = nVar.f423525b.f423527b.f423483a;
                Intrinsics.checkNotNullExpressionValue(aVarArr, "it.stream.frame.addresses");
                for (or4.a aVar : aVarArr) {
                    AegisLogger.INSTANCE.i("PK_Biz|PKWithOBS|LinkScreenModel", "\u6d41\u4fe1\u606f\uff1a " + aVar.f423474b + " - " + aVar.f423473a);
                }
            }
        }
    }

    private final void l() {
        this.pushApi.e(new c());
        this.pushApi.g(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(LinkScreenAnchorInfo anchorInfo, n[] items) {
        LinkScreenEvent linkScreenEvent = new LinkScreenEvent(1, anchorInfo);
        linkScreenEvent.d(items);
        EventCenter.post(linkScreenEvent);
        this.linkScreenStateMgr.a(anchorInfo);
    }

    /* renamed from: g, reason: from getter */
    public final long getAnchorId() {
        return this.anchorId;
    }

    public final boolean j() {
        return this.linkScreenStateMgr.getIsInLinkScreen();
    }

    public final void n() {
        this.pushApi.h();
    }
}
