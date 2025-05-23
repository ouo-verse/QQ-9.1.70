package jm3;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel;
import com.tencent.now.linkpkanchorplay.invite.model.d;
import com.tencent.now.linkpkanchorplay.linkscreen.view.AnchorOperateLinkDialog;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.ag;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import om3.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006*\u0004HKNQ\u0018\u0000 \u000b2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J.\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\u0004R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00107R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010ER\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010GR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010IR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010LR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010R\u00a8\u0006V"}, d2 = {"Ljm3/a;", "", "", "bizType", "", "t", "Le55/a;", "anchorInfo", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "replyState", ReportConstant.COSTREPORT_PREFIX, "Lg55/ag;", "inviteMsg", "p", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$c;", "inviteResult", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "reportReplyFlag", "r", "Landroid/content/Context;", "context", "Landroidx/lifecycle/ViewModelProvider;", "viewModelProvider", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lom3/e;", "linkMicStateMgr", "Lcom/tencent/now/linkpkanchorplay/event/b;", "eventTrigger", "j", "u", "o", DomainData.DOMAIN_NAME, "v", "", "a", "J", "roomId", "Landroidx/fragment/app/FragmentManager;", "b", "Landroidx/fragment/app/FragmentManager;", "fm", "c", "Landroid/content/Context;", "d", "Landroidx/lifecycle/ViewModelProvider;", "e", "Lom3/e;", "Lcom/tencent/component/core/event/Eventor;", "f", "Lcom/tencent/component/core/event/Eventor;", "eventor", "g", "I", tl.h.F, "inviteSource", "i", "Landroidx/lifecycle/LifecycleOwner;", "Le55/a;", "curInvitingAnchorInfo", "", "Ljava/lang/String;", "curInviteID", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel;", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel;", "inviteDataModel", "Lcom/tencent/now/linkpkanchorplay/invite/model/d;", "Lcom/tencent/now/linkpkanchorplay/invite/model/d;", "inviteMsgPushModel", "Lcom/tencent/now/linkpkanchorplay/event/b;", "jm3/a$h", "Ljm3/a$h;", "inviteResultObserver", "jm3/a$b", "Ljm3/a$b;", "cancelInviteResultObserver", "jm3/a$g", "Ljm3/a$g;", "inviteReplyObserver", "jm3/a$f", "Ljm3/a$f;", "inviteIPushCallback", "<init>", "(JLandroidx/fragment/app/FragmentManager;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FragmentManager fm;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewModelProvider viewModelProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private om3.e linkMicStateMgr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int bizType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int inviteSource;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e55.a curInvitingAnchorInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curInviteID;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InviteDataModel inviteDataModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.now.linkpkanchorplay.invite.model.d inviteMsgPushModel;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private com.tencent.now.linkpkanchorplay.event.b eventTrigger;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h inviteResultObserver;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b cancelInviteResultObserver;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g inviteReplyObserver;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f inviteIPushCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jm3/a$b", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$b;", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$c;", "result", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements InviteDataModel.b {
        b() {
        }

        @Override // com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel.b
        public void a(@NotNull InviteDataModel.InviteResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            om3.e eVar = a.this.linkMicStateMgr;
            com.tencent.now.linkpkanchorplay.event.b bVar = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
                eVar = null;
            }
            eVar.c(true);
            if (result.getCode() == 0) {
                Context context = a.this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context = null;
                }
                Object[] objArr = new Object[1];
                Context context2 = a.this.context;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context2 = null;
                }
                objArr[0] = fn3.c.d(context2, a.this.bizType);
                UIUtil.h(context.getString(R.string.f224996kf, objArr), false, 1);
                EventCenter.post(d.f.f338187a);
                if (!fn3.a.a(a.this.bizType)) {
                    com.tencent.now.linkpkanchorplay.event.b bVar2 = a.this.eventTrigger;
                    if (bVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("eventTrigger");
                    } else {
                        bVar = bVar2;
                    }
                    bVar.t1(new UIEvent.c());
                    return;
                }
                return;
            }
            UIUtil.h(result.getMsg(), false, 1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jm3/a$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lym3/a;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements OnEvent<ym3.a> {
        c() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull ym3.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            try {
                a.this.t(event.b());
                a.this.inviteSource = event.c();
                a aVar = a.this;
                e55.a a16 = event.a();
                Intrinsics.checkNotNullExpressionValue(a16, "event.anchorInfo");
                aVar.k(a16);
            } catch (NumberFormatException e16) {
                AegisLogger.INSTANCE.i("PK_Biz|InviteOperateController", "inviteAnchor NumberFormatException: " + e16.getMessage());
                e16.printStackTrace();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jm3/a$d", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$e;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements OnEvent<d.ResponseInviteEvent> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ om3.e f410631a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f410632b;

        d(om3.e eVar, a aVar) {
            this.f410631a = eVar;
            this.f410632b = aVar;
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.ResponseInviteEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getOpType() == 3 || event.getOpType() == 5) {
                om3.e eVar = this.f410631a;
                int i3 = this.f410632b.bizType;
                e55.a aVar = event.getInviteMsg().f401296b;
                Intrinsics.checkNotNullExpressionValue(aVar, "event.inviteMsg.from");
                eVar.e(false, i3, aVar);
            }
            if (event.getOpType() == 2) {
                om3.e eVar2 = this.f410631a;
                int i16 = this.f410632b.bizType;
                e55.a aVar2 = event.getInviteMsg().f401296b;
                Intrinsics.checkNotNullExpressionValue(aVar2, "event.inviteMsg.from");
                eVar2.e(true, i16, aVar2);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jm3/a$e", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$a;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements OnEvent<d.a> {
        e() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.a event) {
            Intrinsics.checkNotNullParameter(event, "event");
            a.this.m();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jm3/a$f", "Lcom/tencent/now/linkpkanchorplay/invite/model/d$b;", "Lg55/ag;", "msg", "", "b", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class f implements d.b<ag> {
        f() {
        }

        @Override // com.tencent.now.linkpkanchorplay.invite.model.d.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ag msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AegisLogger.INSTANCE.i("PK_Biz|InviteOperateController", "receive Invite Push opType: " + msg2.f401299e + " state\uff1a" + msg2.f401301g);
            a.this.n(msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"jm3/a$g", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$d;", "Lg55/ag;", "inviteMsg", "", "a", "onTimeout", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class g implements InviteDataModel.d {
        g() {
        }

        @Override // com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel.d
        public void a(@NotNull ag inviteMsg) {
            Intrinsics.checkNotNullParameter(inviteMsg, "inviteMsg");
            a.this.o(inviteMsg);
        }

        @Override // com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel.d
        public void onTimeout() {
            Context context = a.this.context;
            om3.e eVar = null;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            UIUtil.h(context.getString(R.string.f161331xf), false, 1);
            om3.e eVar2 = a.this.linkMicStateMgr;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
            } else {
                eVar = eVar2;
            }
            eVar.c(true);
            EventCenter.post(d.f.f338187a);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jm3/a$h", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$b;", "Lcom/tencent/now/linkpkanchorplay/invite/model/InviteDataModel$c;", "result", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class h implements InviteDataModel.b {
        h() {
        }

        @Override // com.tencent.now.linkpkanchorplay.invite.model.InviteDataModel.b
        public void a(@NotNull InviteDataModel.InviteResult result) {
            boolean z16;
            String str;
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.getCode() == 0) {
                a.this.l(result);
                return;
            }
            if (result.getMsg().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                str = result.getMsg();
            } else {
                str = "error happen!";
            }
            UIUtil.h(str, false, 1);
        }
    }

    public a(long j3, @NotNull FragmentManager fm5) {
        Intrinsics.checkNotNullParameter(fm5, "fm");
        this.roomId = j3;
        this.fm = fm5;
        this.eventor = new Eventor();
        this.bizType = 3;
        this.inviteSource = -1;
        this.curInvitingAnchorInfo = new e55.a();
        this.curInviteID = "";
        this.inviteDataModel = new InviteDataModel();
        this.inviteMsgPushModel = new com.tencent.now.linkpkanchorplay.invite.model.d(j3);
        this.inviteResultObserver = new h();
        this.cancelInviteResultObserver = new b();
        this.inviteReplyObserver = new g();
        this.inviteIPushCallback = new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(e55.a anchorInfo) {
        this.curInvitingAnchorInfo = anchorInfo;
        this.inviteDataModel.k(this.bizType, anchorInfo.f395729a.f395736b, this.inviteResultObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(InviteDataModel.InviteResult inviteResult) {
        this.curInviteID = inviteResult.getInviteID();
        om3.e eVar = this.linkMicStateMgr;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
            eVar = null;
        }
        eVar.h(this.curInvitingAnchorInfo, this.bizType, inviteResult.getInviteID());
        u();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        if (this.curInvitingAnchorInfo != null) {
            this.inviteDataModel.h(this.curInviteID, this.cancelInviteResultObserver);
        }
    }

    private final void p(ag inviteMsg) {
        int i3 = inviteMsg.f401299e;
        com.tencent.now.linkpkanchorplay.event.b bVar = null;
        if (i3 == 1) {
            om3.e eVar = this.linkMicStateMgr;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
                eVar = null;
            }
            eVar.g(inviteMsg);
        } else if (i3 == 4) {
            om3.e eVar2 = this.linkMicStateMgr;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
                eVar2 = null;
            }
            eVar2.c(false);
        }
        com.tencent.now.linkpkanchorplay.event.b bVar2 = this.eventTrigger;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventTrigger");
        } else {
            bVar = bVar2;
        }
        bVar.t1(new UIEvent.ShowReceiveInviteUI(inviteMsg));
    }

    private final void q() {
        this.inviteDataModel.r(this.inviteReplyObserver);
    }

    private final void r(int reportReplyFlag) {
        String str;
        Long l3;
        e55.c cVar;
        int i3 = this.inviteSource;
        if (i3 != 0) {
            if (i3 != 1) {
                str = "ev_qqlive_lp_search_anchor_button";
                if (i3 != 2 && i3 != 3) {
                    str = i3 != 4 ? i3 != 8 ? "" : "ev_qqlive_lp_restart_pk_button" : "ev_qqlive_pwpk_ok_button";
                }
            } else {
                str = "ev_qqlive_lppk_recommend_anchor_button";
            }
        } else {
            str = "ev_qqlive_lp_recommend_anchor_button";
        }
        AegisLogger.INSTANCE.i("PK_Biz|InviteOperateController", "reportInviteReply eventName: " + str + " reportReplyFlag: " + reportReplyFlag);
        HashMap hashMap = new HashMap();
        hashMap.put("qqlive_lp_ok_button", String.valueOf(reportReplyFlag));
        e55.a aVar = this.curInvitingAnchorInfo;
        if (aVar != null && (cVar = aVar.f395729a) != null) {
            l3 = Long.valueOf(cVar.f395735a);
        } else {
            l3 = null;
        }
        hashMap.put("qqlive_lp_anchor_id", String.valueOf(l3));
        com.tencent.report.a.f364907a.h(str, hashMap);
    }

    private final void s(int replyState) {
        boolean z16;
        om3.e eVar = this.linkMicStateMgr;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
            eVar = null;
        }
        if (replyState == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        eVar.e(z16, this.bizType, this.curInvitingAnchorInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(int bizType) {
        this.bizType = bizType;
    }

    public final void j(@NotNull Context context, @NotNull ViewModelProvider viewModelProvider, @NotNull LifecycleOwner lifecycleOwner, @NotNull om3.e linkMicStateMgr, @NotNull com.tencent.now.linkpkanchorplay.event.b eventTrigger) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(linkMicStateMgr, "linkMicStateMgr");
        Intrinsics.checkNotNullParameter(eventTrigger, "eventTrigger");
        this.context = context;
        this.viewModelProvider = viewModelProvider;
        this.lifecycleOwner = lifecycleOwner;
        this.linkMicStateMgr = linkMicStateMgr;
        this.eventTrigger = eventTrigger;
        this.eventor.addOnEvent(new c()).addOnEvent(new d(linkMicStateMgr, this)).addOnEvent(new e());
        this.inviteMsgPushModel.c(this.inviteIPushCallback);
    }

    public final void n(@NotNull ag inviteMsg) {
        Intrinsics.checkNotNullParameter(inviteMsg, "inviteMsg");
        int i3 = inviteMsg.f401299e;
        if (i3 != 2 && i3 != 3 && i3 != 5) {
            p(inviteMsg);
        } else {
            this.inviteDataModel.i();
            o(inviteMsg);
        }
    }

    public final void o(@NotNull ag inviteMsg) {
        Intrinsics.checkNotNullParameter(inviteMsg, "inviteMsg");
        om3.e eVar = this.linkMicStateMgr;
        Context context = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
            eVar = null;
        }
        if (!(eVar.getCurrentState() instanceof d.InvitationSent)) {
            return;
        }
        s(inviteMsg.f401301g);
        int i3 = inviteMsg.f401301g;
        int i16 = 2;
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 5) {
                    AegisLogger.INSTANCE.i("PK_Biz|InviteOperateController", "processInviteReply cmd = OpCancel");
                }
            } else {
                AegisLogger.INSTANCE.i("PK_Biz|InviteOperateController", "processInviteReply cmd = OpRefuse");
                Context context2 = this.context;
                if (context2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context = context2;
                }
                UIUtil.h(fn3.c.g(context, this.bizType), false, 1);
                EventCenter.post(new d.InviteReceiveReplyEvent(inviteMsg));
            }
        } else {
            AegisLogger.INSTANCE.i("PK_Biz|InviteOperateController", "processInviteReply cmd = Accepted");
            Context context3 = this.context;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context3 = null;
            }
            Object[] objArr = new Object[1];
            Context context4 = this.context;
            if (context4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
            } else {
                context = context4;
            }
            objArr[0] = fn3.c.d(context, this.bizType);
            UIUtil.h(context3.getString(R.string.f161301xc, objArr), false, 1);
            EventCenter.post(new d.InviteReceiveReplyEvent(inviteMsg));
            i16 = 1;
        }
        r(i16);
    }

    public final void u() {
        om3.e eVar;
        ViewModelProvider viewModelProvider;
        long j3 = this.roomId;
        e55.a aVar = this.curInvitingAnchorInfo;
        om3.e eVar2 = this.linkMicStateMgr;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linkMicStateMgr");
            eVar = null;
        } else {
            eVar = eVar2;
        }
        ViewModelProvider viewModelProvider2 = this.viewModelProvider;
        if (viewModelProvider2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelProvider");
            viewModelProvider = null;
        } else {
            viewModelProvider = viewModelProvider2;
        }
        new AnchorOperateLinkDialog(j3, aVar, eVar, viewModelProvider).show(this.fm, "wait_invite_reply");
    }

    public final void v() {
        this.eventor.removeAll();
        this.inviteMsgPushModel.d();
        this.inviteDataModel.w();
    }
}
