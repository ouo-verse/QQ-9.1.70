package com.tencent.now.pkgame.linkandpkobserver.audience;

import android.os.SystemClock;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.now.pkgame.linkandpkobserver.PollQueryPKMsgModel;
import com.tencent.now.pkgame.linkandpkobserver.audience.b;
import com.tencent.now.pkgame.linkandpkobserver.repository.LinkScreenAndPkServiceImpl;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.as;
import g55.at;
import g55.au;
import g55.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or4.g;
import or4.j;
import or4.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qo3.SeiConfig;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 42\u00020\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u0017R\u0016\u00101\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0017\u00a8\u00065"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/audience/a;", "Lcom/tencent/now/pkgame/linkandpkobserver/b;", "", "u", ReportConstant.COSTREPORT_PREFIX, "t", "Lg55/au;", "pkMsg", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lor4/g;", "data", "p", "v", "w", "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "pkGameModel", "a", "Lcom/tencent/now/pkgame/linkandpkobserver/a;", "callback", "c", "b", "", "J", "roomId", VasLiveIPCModule.KEY_ANCHOR_UIN, "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b;", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b;", "seiInfoChecker", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel;", "d", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel;", "queryPKMsgModel", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/LinkScreenAndPkServiceImpl;", "e", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/LinkScreenAndPkServiceImpl;", "linkScreenAndPkApi", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/c;", "f", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/c;", "linkScreenAndPkPushApi", "g", "Lcom/tencent/now/pkgame/linkandpkobserver/a;", "observerResultCallback", h.F, "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "i", "currentTimeMs", "j", "curPkId", "<init>", "(JJLcom/tencent/now/pkgame/linkandpkobserver/audience/b;)V", "k", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements com.tencent.now.pkgame.linkandpkobserver.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long anchorUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.pkgame.linkandpkobserver.audience.b seiInfoChecker;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PollQueryPKMsgModel queryPKMsgModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkScreenAndPkServiceImpl linkScreenAndPkApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.pkgame.linkandpkobserver.repository.c linkScreenAndPkPushApi;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.now.pkgame.linkandpkobserver.a observerResultCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.now.pkgame.pkgame.pklib.model.e pkGameModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long currentTimeMs;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private long curPkId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/audience/a$b", "Lko3/c;", "Lor4/g;", "data", "", "a", "", "code", "", "msg", "fail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ko3.c<g> {
        b() {
        }

        @Override // ko3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable g data) {
            AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "getLinkMicInfo success, start check in LinkScreen");
            a.this.p(data);
        }

        @Override // ko3.c
        public void fail(int code, @Nullable String msg2) {
            AegisLogger.INSTANCE.e("PK_Biz|AudiencePKObserver", "getLinkMicInfo", "error code: " + code + ", msg: " + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/audience/a$c", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/b;", "Lh55/b;", "anchorSwitchMic", "", "b", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements com.tencent.now.pkgame.linkandpkobserver.repository.b<h55.b> {
        c() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.repository.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull h55.b anchorSwitchMic) {
            Intrinsics.checkNotNullParameter(anchorSwitchMic, "anchorSwitchMic");
            h55.d dVar = anchorSwitchMic.f404402b;
            int i3 = dVar.f404410c.f404405a;
            int i16 = dVar.f404409b.f404412a;
            int i17 = anchorSwitchMic.f404401a;
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("PK_Biz|AudiencePKObserver", "handleReceivedData, bizId: " + i3 + ", modelType: " + i16 + ", linkMicStatus: " + i17);
            if (i17 == 0) {
                companion.i("PK_Biz|AudiencePKObserver", "receive push: onLinkMicOff roomId: " + a.this.roomId);
                com.tencent.now.pkgame.linkandpkobserver.a aVar = a.this.observerResultCallback;
                if (aVar != null) {
                    aVar.a();
                }
                a.this.w();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/audience/a$d", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/b;", "Lg55/au;", "data", "", "b", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements com.tencent.now.pkgame.linkandpkobserver.repository.b<au> {
        d() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.repository.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull au data) {
            Intrinsics.checkNotNullParameter(data, "data");
            a.this.r(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/audience/a$e", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b$b;", "Lqo3/a;", "seiConfig", "", "b", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements b.InterfaceC9251b {
        e() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.audience.b.InterfaceC9251b
        public void a() {
            AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "onSeiLinkEnd, onLinkMicOff roomId: " + a.this.roomId);
            com.tencent.now.pkgame.linkandpkobserver.a aVar = a.this.observerResultCallback;
            if (aVar != null) {
                aVar.a();
            }
            a.this.w();
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.audience.b.InterfaceC9251b
        public void b(@NotNull SeiConfig seiConfig) {
            Intrinsics.checkNotNullParameter(seiConfig, "seiConfig");
            if (a.this.observerResultCallback != null) {
                com.tencent.now.pkgame.linkandpkobserver.a aVar = a.this.observerResultCallback;
                if (aVar != null) {
                    aVar.b(seiConfig);
                }
                if (!a.this.queryPKMsgModel.k() && seiConfig.e() && SystemClock.elapsedRealtime() - a.this.currentTimeMs >= 5000) {
                    a.this.currentTimeMs = SystemClock.elapsedRealtime();
                    a.this.q();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/audience/a$f", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$b;", "Lg55/q;", "rsp", "", "isInPK", "", "pkType", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class f implements PollQueryPKMsgModel.b {
        f() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.PollQueryPKMsgModel.b
        public void a(@NotNull q rsp, boolean isInPK, int pkType) {
            com.tencent.now.pkgame.pkgame.pklib.model.e eVar;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            int i3 = rsp.f401381d;
            if (i3 == 1) {
                com.tencent.now.pkgame.linkandpkobserver.a aVar = a.this.observerResultCallback;
                if (aVar != null) {
                    aVar.d();
                    return;
                }
                return;
            }
            com.tencent.now.linkscreengame.model.b bVar = com.tencent.now.linkscreengame.model.b.f338501a;
            if (bVar.e(i3) && (eVar = a.this.pkGameModel) != null) {
                eVar.v(true);
            }
            at atVar = rsp.f401379b;
            if (atVar != null && atVar.f401328d != null) {
                if (!isInPK) {
                    com.tencent.now.pkgame.linkandpkobserver.a aVar2 = a.this.observerResultCallback;
                    if (aVar2 != null) {
                        aVar2.d();
                        return;
                    }
                    return;
                }
                boolean g16 = bVar.g(atVar.f401325a, a.this.curPkId);
                AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "restart:" + g16 + "\uff0c pkType:" + rsp.f401383f);
                if (g16) {
                    a.this.curPkId = rsp.f401379b.f401325a;
                    com.tencent.now.pkgame.linkandpkobserver.a aVar3 = a.this.observerResultCallback;
                    if (aVar3 != null) {
                        aVar3.d();
                        return;
                    }
                    return;
                }
                a.this.curPkId = rsp.f401379b.f401325a;
                com.tencent.now.pkgame.linkandpkobserver.a aVar4 = a.this.observerResultCallback;
                if (aVar4 != null) {
                    int i16 = rsp.f401381d;
                    at atVar2 = rsp.f401379b;
                    aVar4.e(i16, atVar2.f401328d.f401358a, atVar2.f401325a, rsp.f401383f);
                    return;
                }
                return;
            }
            AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "startQueryPKMsg", "pkInfo\u4e3a\u7a7a,\u4e0d\u5904\u4e8ePK\u72b6\u6001\u3002");
        }
    }

    public a(long j3, long j16, @NotNull com.tencent.now.pkgame.linkandpkobserver.audience.b seiInfoChecker) {
        Intrinsics.checkNotNullParameter(seiInfoChecker, "seiInfoChecker");
        this.roomId = j3;
        this.anchorUin = j16;
        this.seiInfoChecker = seiInfoChecker;
        this.queryPKMsgModel = new PollQueryPKMsgModel();
        this.linkScreenAndPkApi = new LinkScreenAndPkServiceImpl();
        this.linkScreenAndPkPushApi = new com.tencent.now.pkgame.linkandpkobserver.repository.c(j3);
        AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "roomId: " + j3);
        u();
        s();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(g data) {
        boolean z16;
        int i3;
        if (data != null && this.observerResultCallback != null) {
            j jVar = data.f423493h;
            if (jVar != null) {
                l lVar = jVar.f423499b;
                if (lVar != null) {
                    i3 = lVar.f423519a;
                } else {
                    i3 = -1;
                }
                int i16 = jVar.f423500c.f423475a;
                AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "checkIsInLinkScreen, modeType:" + i3 + ", bizID:" + i16);
                if (com.tencent.now.linkscreengame.model.a.f338500a.b(i3, i16)) {
                    v();
                    return;
                }
                return;
            }
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        boolean z17 = true;
        if (data == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.observerResultCallback != null) {
            z17 = false;
        }
        companion.e("PK_Biz|AudiencePKObserver", "checkIsInLinkScreen", "data == null : " + z16 + ", observerResultCallback == null : " + z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        this.linkScreenAndPkApi.b(this.roomId, this.anchorUin, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(au pkMsg) {
        com.tencent.now.linkscreengame.model.b bVar = com.tencent.now.linkscreengame.model.b.f338501a;
        if (bVar.i(pkMsg) && this.seiInfoChecker.getLinkMicBean().e()) {
            boolean h16 = bVar.h(pkMsg, this.curPkId);
            AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "Audience start PK, restartPK:" + h16 + ", pkType:" + pkMsg.f401341f);
            if (h16) {
                this.curPkId = pkMsg.f401339d.f401312a;
                com.tencent.now.pkgame.linkandpkobserver.a aVar = this.observerResultCallback;
                if (aVar != null) {
                    aVar.d();
                    return;
                }
                return;
            }
            as asVar = pkMsg.f401339d;
            long j3 = asVar.f401312a;
            this.curPkId = j3;
            com.tencent.now.pkgame.linkandpkobserver.a aVar2 = this.observerResultCallback;
            if (aVar2 != null) {
                aVar2.e(asVar.f401313b, asVar.f401315d, j3, pkMsg.f401341f);
                return;
            }
            return;
        }
        if (bVar.b(pkMsg)) {
            AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "Audience abort PK");
            com.tencent.now.pkgame.linkandpkobserver.a aVar3 = this.observerResultCallback;
            if (aVar3 != null) {
                aVar3.d();
            }
        }
    }

    private final void s() {
        this.linkScreenAndPkPushApi.e(new c());
    }

    private final void t() {
        this.linkScreenAndPkPushApi.f(new d());
    }

    private final void u() {
        this.seiInfoChecker.h(new e(), false);
        this.seiInfoChecker.d();
    }

    private final void v() {
        this.queryPKMsgModel.n(this.roomId, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        AegisLogger.INSTANCE.i("PK_Biz|AudiencePKObserver", "stopQueryPKMsg roomId: " + this.roomId);
        this.queryPKMsgModel.o();
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.b
    public void a(@NotNull com.tencent.now.pkgame.pkgame.pklib.model.e pkGameModel) {
        Intrinsics.checkNotNullParameter(pkGameModel, "pkGameModel");
        this.pkGameModel = pkGameModel;
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.b
    public void b() {
        w();
        this.seiInfoChecker.i();
        this.linkScreenAndPkPushApi.g();
        this.observerResultCallback = null;
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.b
    public void c(@NotNull com.tencent.now.pkgame.linkandpkobserver.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.observerResultCallback = callback;
    }
}
