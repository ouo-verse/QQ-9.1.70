package com.tencent.now.linkpkanchorplay.invite.model;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel;
import com.tencent.now.linkpkanchorplay.sso.request.DisinvitationRequest;
import com.tencent.now.linkpkanchorplay.sso.request.InviteLinkAndPKRequest;
import com.tencent.now.linkpkanchorplay.sso.request.InviteLinkRequest;
import com.tencent.now.linkpkanchorplay.sso.request.InvitePKOnLinkRequest;
import com.tencent.now.linkpkanchorplay.sso.request.InviteRankPKRequest;
import com.tencent.now.linkpkanchorplay.sso.request.InviteRestartPKRequest;
import com.tencent.now.linkpkanchorplay.sso.request.QueryInviteRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.ad;
import g55.af;
import g55.ag;
import g55.am;
import g55.ax;
import g55.m;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001e2\u00020\u0001:\u0004!$(,B\u0007\u00a2\u0006\u0004\b4\u00105J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J \u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001d\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\u0006R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00102\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u0014\u00103\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010-\u00a8\u00066"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel;", "", "", "roomid", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$b;", "dataCallBack", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "roomID", "o", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$d;", "callBack", "u", "v", "t", "j", "", "inviteID", "", "code", "msg", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$c;", "g", "bizType", "roomId", "k", "p", "r", h.F, "i", "w", "a", "J", "queryReplyInterval", "b", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$d;", "queryInviteReplyCallBack", "", "c", "Z", "stopPolling", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "timeoutExecuteRunnable", "e", "pollQueryExecuteRunnable", "f", "queryReplyTimeoutTask", "pollingQueryReplyTask", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class InviteDataModel {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d queryInviteReplyCallBack;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean stopPolling;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable timeoutExecuteRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable pollQueryExecuteRunnable;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long queryReplyInterval = 2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable queryReplyTimeoutTask = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.invite.model.b
        @Override // java.lang.Runnable
        public final void run() {
            InviteDataModel.s(InviteDataModel.this);
        }
    };

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable pollingQueryReplyTask = new Runnable() { // from class: com.tencent.now.linkpkanchorplay.invite.model.c
        @Override // java.lang.Runnable
        public final void run() {
            InviteDataModel.q(InviteDataModel.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$b;", "", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$c;", "result", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(@NotNull InviteResult result);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0013\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "inviteID", "", "J", "getRoomid", "()J", "roomid", "c", "I", "()I", "code", "d", "msg", "<init>", "(Ljava/lang/String;JILjava/lang/String;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$c, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class InviteResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String inviteID;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long roomid;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int code;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String msg;

        public InviteResult(@NotNull String inviteID, long j3, int i3, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(inviteID, "inviteID");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.inviteID = inviteID;
            this.roomid = j3;
            this.code = i3;
            this.msg = msg2;
        }

        /* renamed from: a, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getInviteID() {
            return this.inviteID;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InviteResult)) {
                return false;
            }
            InviteResult inviteResult = (InviteResult) other;
            if (Intrinsics.areEqual(this.inviteID, inviteResult.inviteID) && this.roomid == inviteResult.roomid && this.code == inviteResult.code && Intrinsics.areEqual(this.msg, inviteResult.msg)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.inviteID.hashCode() * 31) + androidx.fragment.app.a.a(this.roomid)) * 31) + this.code) * 31) + this.msg.hashCode();
        }

        @NotNull
        public String toString() {
            return "InviteResult(inviteID=" + this.inviteID + ", roomid=" + this.roomid + ", code=" + this.code + ", msg=" + this.msg + ')';
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$d;", "", "Lg55/ag;", "inviteMsg", "", "a", "onTimeout", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface d {
        void a(@NotNull ag inviteMsg);

        void onTimeout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InviteResult g(long roomid, String inviteID, int code, String msg2) {
        return new InviteResult(inviteID, roomid, code, msg2);
    }

    private final void j(final d callBack) {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "internalSendQueryInviteReplyReq");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QueryInviteRequest(), new Function1<QQLiveResponse<ax>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$internalSendQueryInviteReplyReq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ax> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<ax> response) {
                long j3;
                Intrinsics.checkNotNullParameter(response, "response");
                ax rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    companion.i("PK_Biz|InviteDataMode", "internalSendQueryInviteReplyReq", "onResponse state:" + rsp.f401344a.f401301g + " opType:" + rsp.f401344a.f401299e);
                    ag agVar = rsp.f401344a;
                    int i3 = agVar.f401301g;
                    int i16 = agVar.f401299e;
                    InviteDataModel.this.queryReplyInterval = rsp.f401345b;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(" QueryInviteReply onResponse opType:");
                    sb5.append(i16);
                    sb5.append(" state:");
                    sb5.append(i3);
                    sb5.append(" queryReplyInterval:");
                    j3 = InviteDataModel.this.queryReplyInterval;
                    sb5.append(j3);
                    companion.i("PK_Biz|InviteDataMode", sb5.toString());
                    if (i3 != 2 && i3 != 3 && i3 != 5) {
                        InviteDataModel.this.t();
                        return;
                    }
                    InviteDataModel.d dVar = callBack;
                    if (dVar != null) {
                        ag agVar2 = rsp.f401344a;
                        Intrinsics.checkNotNullExpressionValue(agVar2, "rsp.msg");
                        dVar.a(agVar2);
                    }
                    InviteDataModel.this.i();
                    return;
                }
                AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "internalSendQueryInviteReplyReq", "onFailure code:" + response.getRetCode() + " msg:" + response.getErrMsg());
            }
        });
    }

    private final void l(final long roomid, final b dataCallBack) {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "send inviteLink, roomId:" + roomid);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new InviteLinkRequest(roomid), new Function1<QQLiveResponse<af>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$inviteLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<af> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<af> response) {
                InviteDataModel.InviteResult g16;
                InviteDataModel.InviteResult g17;
                Intrinsics.checkNotNullParameter(response, "response");
                af rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", " inviteLink", "onResponse inviteId " + rsp.f401294a);
                    InviteDataModel.b bVar = InviteDataModel.b.this;
                    if (bVar != null) {
                        InviteDataModel inviteDataModel = this;
                        long j3 = roomid;
                        String str = rsp.f401294a;
                        Intrinsics.checkNotNullExpressionValue(str, "rsp.inviteId");
                        g17 = inviteDataModel.g(j3, str, 0, "success");
                        bVar.a(g17);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "inviteLink", "onFailure code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                InviteDataModel.b bVar2 = InviteDataModel.b.this;
                if (bVar2 != null) {
                    InviteDataModel inviteDataModel2 = this;
                    long j16 = roomid;
                    int retCode = (int) response.getRetCode();
                    String errMsg = response.getErrMsg();
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    g16 = inviteDataModel2.g(j16, "", retCode, errMsg);
                    bVar2.a(g16);
                }
            }
        });
    }

    private final void m(final long roomid, final b dataCallBack) {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "send inviteLinkAndPK, roomId:" + roomid);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new InviteLinkAndPKRequest(roomid), new Function1<QQLiveResponse<ad>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$inviteLinkAndPK$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ad> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<ad> response) {
                InviteDataModel.InviteResult g16;
                InviteDataModel.InviteResult g17;
                Intrinsics.checkNotNullParameter(response, "response");
                ad rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "inviteLinkAndPK", "onResponse inviteId:" + rsp.f401292a);
                    InviteDataModel.b bVar = InviteDataModel.b.this;
                    if (bVar != null) {
                        InviteDataModel inviteDataModel = this;
                        long j3 = roomid;
                        String str = rsp.f401292a;
                        Intrinsics.checkNotNullExpressionValue(str, "rsp.inviteId");
                        g17 = inviteDataModel.g(j3, str, 0, "success");
                        bVar.a(g17);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "inviteLinkAndPK", "onFailure code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                InviteDataModel.b bVar2 = InviteDataModel.b.this;
                if (bVar2 != null) {
                    InviteDataModel inviteDataModel2 = this;
                    long j16 = roomid;
                    int retCode = (int) response.getRetCode();
                    String errMsg = response.getErrMsg();
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    g16 = inviteDataModel2.g(j16, "", retCode, errMsg);
                    bVar2.a(g16);
                }
            }
        });
    }

    private final void n(final long roomid, final b dataCallBack) {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "send invitePKOnLink, roomId:" + roomid);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new InvitePKOnLinkRequest(roomid), new Function1<QQLiveResponse<ad>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$invitePKOnLink$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ad> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<ad> response) {
                InviteDataModel.InviteResult g16;
                InviteDataModel.InviteResult g17;
                Intrinsics.checkNotNullParameter(response, "response");
                ad rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "invitePKOnLink", "onResponse inviteId:" + rsp.f401292a);
                    InviteDataModel.b bVar = InviteDataModel.b.this;
                    if (bVar != null) {
                        InviteDataModel inviteDataModel = this;
                        long j3 = roomid;
                        String str = rsp.f401292a;
                        Intrinsics.checkNotNullExpressionValue(str, "rsp.inviteId");
                        g17 = inviteDataModel.g(j3, str, 0, "success");
                        bVar.a(g17);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "invitePKOnLink", "onFailure code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                InviteDataModel.b bVar2 = InviteDataModel.b.this;
                if (bVar2 != null) {
                    InviteDataModel inviteDataModel2 = this;
                    long j16 = roomid;
                    int retCode = (int) response.getRetCode();
                    String errMsg = response.getErrMsg();
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    g16 = inviteDataModel2.g(j16, "", retCode, errMsg);
                    bVar2.a(g16);
                }
            }
        });
    }

    private final void o(final long roomID, final b dataCallBack) {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "send inviteRankPK, roomId:" + roomID);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new InviteRankPKRequest(roomID), new Function1<QQLiveResponse<ad>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$inviteRankPK$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<ad> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<ad> response) {
                InviteDataModel.InviteResult g16;
                InviteDataModel.InviteResult g17;
                Intrinsics.checkNotNullParameter(response, "response");
                ad rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "inviteRankPK", "onResponse inviteId:" + rsp.f401292a);
                    InviteDataModel.b bVar = InviteDataModel.b.this;
                    if (bVar != null) {
                        InviteDataModel inviteDataModel = this;
                        long j3 = roomID;
                        String str = rsp.f401292a;
                        Intrinsics.checkNotNullExpressionValue(str, "rsp.inviteId");
                        g17 = inviteDataModel.g(j3, str, 0, "success");
                        bVar.a(g17);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "inviteRankPK", "onFailure code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                InviteDataModel.b bVar2 = InviteDataModel.b.this;
                if (bVar2 != null) {
                    InviteDataModel inviteDataModel2 = this;
                    long j16 = roomID;
                    int retCode = (int) response.getRetCode();
                    String errMsg = response.getErrMsg();
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    g16 = inviteDataModel2.g(j16, "", retCode, errMsg);
                    bVar2.a(g16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(InviteDataModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.stopPolling) {
            this$0.j(this$0.queryInviteReplyCallBack);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(InviteDataModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "queryReplyTimeoutTask start");
        this$0.i();
        d dVar = this$0.queryInviteReplyCallBack;
        if (dVar != null) {
            dVar.onTimeout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.pollQueryExecuteRunnable = ThreadManagerV2.executeDelay(this.pollingQueryReplyTask, 16, null, true, this.queryReplyInterval * 1000);
    }

    private final void u(d callBack) {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "startTask");
        this.stopPolling = false;
        this.queryInviteReplyCallBack = callBack;
        t();
        v();
    }

    private final void v() {
        this.timeoutExecuteRunnable = ThreadManagerV2.executeDelay(this.queryReplyTimeoutTask, 16, null, true, 15000L);
    }

    public final void h(@NotNull final String inviteID, @Nullable final b dataCallBack) {
        Intrinsics.checkNotNullParameter(inviteID, "inviteID");
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "cancelInvite inviteID: " + inviteID);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new DisinvitationRequest(inviteID), new Function1<QQLiveResponse<m>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$cancelInvite$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<m> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<m> response) {
                InviteDataModel.InviteResult g16;
                InviteDataModel.InviteResult g17;
                Intrinsics.checkNotNullParameter(response, "response");
                m rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "cancelInvite", "onResponse inviteId:" + inviteID);
                    InviteDataModel.b bVar = InviteDataModel.b.this;
                    if (bVar != null) {
                        g17 = this.g(0L, inviteID, 0, "success");
                        bVar.a(g17);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "cancelInvite", "onFailure code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                InviteDataModel.b bVar2 = InviteDataModel.b.this;
                if (bVar2 != null) {
                    InviteDataModel inviteDataModel = this;
                    String str = inviteID;
                    int retCode = (int) response.getRetCode();
                    String errMsg = response.getErrMsg();
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    g16 = inviteDataModel.g(0L, str, retCode, errMsg);
                    bVar2.a(g16);
                }
            }
        });
    }

    public final void i() {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", " QueryInviteReply cancelQueryReplyTask");
        this.stopPolling = true;
        Runnable runnable = this.timeoutExecuteRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        Runnable runnable2 = this.pollQueryExecuteRunnable;
        if (runnable2 != null) {
            ThreadManagerV2.removeJob(runnable2, 16);
        }
        this.timeoutExecuteRunnable = null;
        this.pollQueryExecuteRunnable = null;
    }

    public final void k(int bizType, long roomId, @Nullable b dataCallBack) {
        if (bizType != 1) {
            if (bizType != 2) {
                if (bizType != 3) {
                    if (bizType != 4) {
                        if (bizType == 5) {
                            o(roomId, dataCallBack);
                            return;
                        }
                        return;
                    }
                    p(roomId, dataCallBack);
                    return;
                }
                m(roomId, dataCallBack);
                return;
            }
            n(roomId, dataCallBack);
            return;
        }
        l(roomId, dataCallBack);
    }

    public final void p(final long roomid, @Nullable final b dataCallBack) {
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "send inviteRestartPK, roomId:" + roomid);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new InviteRestartPKRequest(roomid), new Function1<QQLiveResponse<am>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel$inviteRestartPK$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<am> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<am> response) {
                InviteDataModel.InviteResult g16;
                InviteDataModel.InviteResult g17;
                Intrinsics.checkNotNullParameter(response, "response");
                am rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "inviteRestartPK", "onResponse inviteId:" + rsp.f401307a);
                    InviteDataModel.b bVar = InviteDataModel.b.this;
                    if (bVar != null) {
                        InviteDataModel inviteDataModel = this;
                        long j3 = roomid;
                        String str = rsp.f401307a;
                        Intrinsics.checkNotNullExpressionValue(str, "rsp.inviteId");
                        g17 = inviteDataModel.g(j3, str, 0, "success");
                        bVar.a(g17);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "inviteRestartPK", "onFailure code:" + response.getRetCode() + " msg:" + response.getErrMsg());
                InviteDataModel.b bVar2 = InviteDataModel.b.this;
                if (bVar2 != null) {
                    InviteDataModel inviteDataModel2 = this;
                    long j16 = roomid;
                    int retCode = (int) response.getRetCode();
                    String errMsg = response.getErrMsg();
                    if (errMsg == null) {
                        errMsg = "";
                    }
                    g16 = inviteDataModel2.g(j16, "", retCode, errMsg);
                    bVar2.a(g16);
                }
            }
        });
    }

    public final void r(@NotNull d callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        AegisLogger.INSTANCE.i("PK_Biz|InviteDataMode", "queryInviteReply");
        u(callBack);
    }

    public final void w() {
        i();
    }
}
