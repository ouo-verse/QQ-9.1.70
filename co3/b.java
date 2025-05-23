package co3;

import android.content.Context;
import co3.c;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.od.logic.core.NetworkManager;
import com.tencent.now.pkgame.linkandpkobserver.PollQueryPKMsgModel;
import com.tencent.now.pkgame.pkgame.pklib.model.PKEndObserver;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.as;
import g55.at;
import g55.au;
import g55.q;
import hn3.LinkScreenEvent;
import hn3.PKEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 @2\u00020\u0001:\u0001\u0016B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0017R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010<\u00a8\u0006A"}, d2 = {"Lco3/b;", "Lcom/tencent/now/pkgame/linkandpkobserver/b;", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "roomId", ReportConstant.COSTREPORT_PREFIX, "t", "r", "Lg55/au;", "pkMsg", "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "pkGameModel", "a", "u", "Lcom/tencent/now/pkgame/linkandpkobserver/a;", "callback", "c", "b", "J", VasLiveIPCModule.KEY_ANCHOR_UIN, "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/component/core/event/Eventor;", "d", "Lcom/tencent/component/core/event/Eventor;", "event", "Lco3/d;", "e", "Lco3/d;", "currentPKInfoMode", "Lco3/c;", "f", "Lco3/c;", "rankPkChecker", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel;", "g", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel;", "queryPKMsgModel", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/c;", h.F, "Lcom/tencent/now/pkgame/linkandpkobserver/repository/c;", "linkScreenAndPkPushApi", "i", "curPkId", "j", "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "k", "Lcom/tencent/now/pkgame/linkandpkobserver/a;", "observerResultCallback", "Lcom/tencent/now/pkgame/pkgame/pklib/model/PKEndObserver;", "l", "Lcom/tencent/now/pkgame/pkgame/pklib/model/PKEndObserver;", "pkEndObserver", "Lcom/tencent/now/od/logic/core/NetworkManager$b;", "Lcom/tencent/now/od/logic/core/NetworkManager$b;", "networkChangeListener", "<init>", "(JJLandroid/content/Context;)V", DomainData.DOMAIN_NAME, "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements com.tencent.now.pkgame.linkandpkobserver.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long anchorUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor event;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private co3.d currentPKInfoMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final co3.c rankPkChecker;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PollQueryPKMsgModel queryPKMsgModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.pkgame.linkandpkobserver.repository.c linkScreenAndPkPushApi;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long curPkId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.now.pkgame.pkgame.pklib.model.e pkGameModel;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.now.pkgame.linkandpkobserver.a observerResultCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private PKEndObserver pkEndObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NetworkManager.b networkChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"co3/b$a", "Lco3/c$b;", "", "pkType", "", "isInPK", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements c.b {
        a() {
        }

        @Override // co3.c.b
        public void a(int pkType, boolean isInPK) {
            if (pkType == 1 && isInPK) {
                b bVar = b.this;
                bVar.s(bVar.roomId);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"co3/b$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/b;", "event", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements OnEvent<LinkScreenEvent> {
        c() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull LinkScreenEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("PK_Biz|AnchorPKObserver", "rev LinkScreenEvent: " + event);
            int type = event.getType();
            if (type == 1) {
                co3.d dVar = b.this.currentPKInfoMode;
                Intrinsics.checkNotNull(dVar);
                dVar.e();
                b bVar = b.this;
                bVar.s(bVar.roomId);
                return;
            }
            if (type == 2) {
                co3.d dVar2 = b.this.currentPKInfoMode;
                Intrinsics.checkNotNull(dVar2);
                dVar2.d();
                co3.d dVar3 = b.this.currentPKInfoMode;
                Intrinsics.checkNotNull(dVar3);
                if (!dVar3.c()) {
                    b.this.t();
                } else {
                    companion.i("PK_Biz|AnchorPKObserver", "InRankPK, do not stop poll.");
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"co3/b$d", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/c;", "event", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements OnEvent<hn3.c> {
        d() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull hn3.c event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AegisLogger.INSTANCE.i("PK_Biz|AnchorPKObserver", "MatchSuccessEvent startPollQueryPKMsg");
            b bVar = b.this;
            bVar.s(bVar.roomId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"co3/b$e", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/b;", "Lg55/au;", "data", "", "b", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements com.tencent.now.pkgame.linkandpkobserver.repository.b<au> {
        e() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.repository.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull au data) {
            Intrinsics.checkNotNullParameter(data, "data");
            b.this.o(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"co3/b$f", "Lcom/tencent/now/pkgame/linkandpkobserver/PollQueryPKMsgModel$b;", "Lg55/q;", "rsp", "", "isInPK", "", "pkType", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class f implements PollQueryPKMsgModel.b {
        f() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.PollQueryPKMsgModel.b
        public void a(@NotNull q rsp, boolean isInPK, int pkType) {
            com.tencent.now.pkgame.pkgame.pklib.model.e eVar;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            com.tencent.now.linkscreengame.model.b bVar = com.tencent.now.linkscreengame.model.b.f338501a;
            if (bVar.e(rsp.f401381d) && (eVar = b.this.pkGameModel) != null) {
                eVar.v(true);
            }
            at atVar = rsp.f401379b;
            if (atVar != null && atVar.f401328d != null) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                companion.i("PK_Biz|AnchorPKObserver", "pollQuery rsp: isInPK:" + isInPK + ", pkType:" + pkType);
                if (isInPK) {
                    boolean g16 = bVar.g(rsp.f401379b.f401325a, b.this.curPkId);
                    companion.i("PK_Biz|AnchorPKObserver", "restart:" + g16 + "\uff0c pkType:" + rsp.f401383f);
                    if (g16) {
                        b.this.curPkId = rsp.f401379b.f401325a;
                        co3.d dVar = b.this.currentPKInfoMode;
                        Intrinsics.checkNotNull(dVar);
                        int i3 = rsp.f401381d;
                        at atVar2 = rsp.f401379b;
                        dVar.g(new PKEvent(3, i3, atVar2.f401328d.f401358a, atVar2.f401325a, rsp.f401383f));
                        return;
                    }
                    b.this.curPkId = rsp.f401379b.f401325a;
                    co3.d dVar2 = b.this.currentPKInfoMode;
                    Intrinsics.checkNotNull(dVar2);
                    int i16 = rsp.f401381d;
                    at atVar3 = rsp.f401379b;
                    dVar2.g(new PKEvent(1, i16, atVar3.f401328d.f401358a, atVar3.f401325a, rsp.f401383f));
                    return;
                }
                companion.i("PK_Biz|AnchorPKObserver", "not in pk:" + isInPK + ", pkType:" + pkType);
                co3.d dVar3 = b.this.currentPKInfoMode;
                Intrinsics.checkNotNull(dVar3);
                int i17 = rsp.f401381d;
                at atVar4 = rsp.f401379b;
                dVar3.h(new PKEvent(2, i17, atVar4.f401328d.f401358a, atVar4.f401325a, rsp.f401383f));
                if (rsp.f401383f == 1) {
                    companion.i("PK_Biz|AnchorPKObserver", "rank normal pk has end,stop the polling");
                    b.this.t();
                    return;
                }
                return;
            }
            AegisLogger.INSTANCE.i("PK_Biz|AnchorPKObserver", "startPollQueryPKMsg", "pkInfo\u4e3a\u7a7a,\u4e0d\u5904\u4e8ePK\u72b6\u6001.");
        }
    }

    public b(long j3, long j16, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.roomId = j3;
        this.anchorUin = j16;
        this.context = context;
        this.event = new Eventor();
        co3.c cVar = new co3.c(j3);
        this.rankPkChecker = cVar;
        this.queryPKMsgModel = new PollQueryPKMsgModel();
        this.linkScreenAndPkPushApi = new com.tencent.now.pkgame.linkandpkobserver.repository.c(j3);
        this.networkChangeListener = new NetworkManager.b() { // from class: co3.a
            @Override // com.tencent.now.od.logic.core.NetworkManager.b
            public final void a(int i3) {
                b.n(b.this, i3);
            }
        };
        AegisLogger.INSTANCE.i("PK_Biz|AnchorPKObserver", "roomId: " + j3);
        p();
        q();
        r();
        cVar.a(new a());
    }

    private final boolean m(au pkMsg) {
        e55.c cVar = pkMsg.f401339d.f401322k;
        if (cVar == null || this.roomId != cVar.f395736b) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            this$0.queryPKMsgModel.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(au pkMsg) {
        com.tencent.now.linkscreengame.model.b bVar = com.tencent.now.linkscreengame.model.b.f338501a;
        if (bVar.i(pkMsg)) {
            boolean h16 = bVar.h(pkMsg, this.curPkId);
            AegisLogger.INSTANCE.i("PK_Biz|AnchorPKObserver", "Anchor start PK, restartPK:" + h16 + ", pkType:" + pkMsg.f401341f);
            if (h16) {
                this.curPkId = pkMsg.f401339d.f401312a;
                co3.d dVar = this.currentPKInfoMode;
                Intrinsics.checkNotNull(dVar);
                as asVar = pkMsg.f401339d;
                dVar.g(new PKEvent(3, asVar.f401313b, asVar.f401315d, asVar.f401312a, pkMsg.f401341f));
                return;
            }
            this.curPkId = pkMsg.f401339d.f401312a;
            co3.d dVar2 = this.currentPKInfoMode;
            Intrinsics.checkNotNull(dVar2);
            as asVar2 = pkMsg.f401339d;
            dVar2.g(new PKEvent(1, asVar2.f401313b, asVar2.f401315d, this.curPkId, pkMsg.f401341f));
            return;
        }
        if (bVar.b(pkMsg)) {
            AegisLogger.INSTANCE.i("PK_Biz|AnchorPKObserver", "Anchor abort PK");
            if (pkMsg.f401339d.f401322k != null && !m(pkMsg)) {
                UIUtil.h(this.context.getString(R.string.f2316072a), false, 1);
            }
            co3.d dVar3 = this.currentPKInfoMode;
            Intrinsics.checkNotNull(dVar3);
            as asVar3 = pkMsg.f401339d;
            dVar3.h(new PKEvent(2, asVar3.f401313b, asVar3.f401315d, this.curPkId, pkMsg.f401341f));
            return;
        }
        AegisLogger.INSTANCE.e("PK_Biz|AnchorPKObserver", "processRevPKMsg", "\u672a\u8bc6\u522b\u7684PKMsg, " + pkMsg);
    }

    private final void p() {
        this.event.addOnEvent(new c());
        NetworkManager.d().c(this.networkChangeListener);
    }

    private final void q() {
        this.event.addOnEvent(new d());
    }

    private final void r() {
        this.linkScreenAndPkPushApi.f(new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(long roomId) {
        this.queryPKMsgModel.n(roomId, new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        AegisLogger.INSTANCE.i("PK_Biz|AnchorPKObserver", "stopPollQueryPKMsg.");
        this.queryPKMsgModel.o();
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.b
    public void a(@NotNull com.tencent.now.pkgame.pkgame.pklib.model.e pkGameModel) {
        Intrinsics.checkNotNullParameter(pkGameModel, "pkGameModel");
        this.pkGameModel = pkGameModel;
        this.currentPKInfoMode = pkGameModel.i();
        com.tencent.now.pkgame.pkgame.pklib.time.a m3 = pkGameModel.m();
        Intrinsics.checkNotNullExpressionValue(m3, "pkGameModel.pkTimer");
        co3.d i3 = pkGameModel.i();
        Intrinsics.checkNotNullExpressionValue(i3, "pkGameModel.currentPKInfoMode");
        this.pkEndObserver = new PKEndObserver(m3, i3);
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.b
    public void b() {
        u();
    }

    @Override // com.tencent.now.pkgame.linkandpkobserver.b
    public void c(@NotNull com.tencent.now.pkgame.linkandpkobserver.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.observerResultCallback = callback;
        co3.d dVar = this.currentPKInfoMode;
        Intrinsics.checkNotNull(dVar);
        dVar.f(callback);
    }

    public final void u() {
        this.event.removeAll();
        NetworkManager.d().g(this.networkChangeListener);
        this.linkScreenAndPkPushApi.g();
        t();
        this.observerResultCallback = null;
    }
}
