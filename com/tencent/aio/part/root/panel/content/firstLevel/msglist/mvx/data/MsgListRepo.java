package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 t2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001LB\u0017\u0012\u0006\u0010k\u001a\u00020f\u0012\u0006\u0010q\u001a\u00020l\u00a2\u0006\u0004\br\u0010sJ\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0018\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0006\u0010\u001c\u001a\u00020\u0012J\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\"J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\bH&J\b\u0010&\u001a\u00020\bH\u0016J\u0018\u0010+\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010*\u001a\u00020)J\u000e\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020'J\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u0016\u00102\u001a\u00020\b2\u0006\u00100\u001a\u00020\"2\u0006\u00101\u001a\u00020\"J\u000e\u00105\u001a\u00020\b2\u0006\u00104\u001a\u000203J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\"H\u0000\u00a2\u0006\u0004\b7\u00108J\u0006\u00109\u001a\u00020\bJ\u000e\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u00020\"J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\u0016J\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0=2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\f0=J\u0016\u0010@\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0006\u0010A\u001a\u00020\u0012J\n\u0010B\u001a\u0004\u0018\u00010\fH\u0016J\n\u0010C\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020DH\u0016J\b\u0010G\u001a\u00020\bH\u0017J*\u0010J\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001a2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016J*\u0010K\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u001a2\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010I\u001a\u0004\u0018\u00010HH\u0016R\u0018\u0010N\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010QR\u001a\u0010V\u001a\u00020R8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bJ\u0010S\u001a\u0004\bT\u0010UR\"\u0010Z\u001a\u00020R8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010S\u001a\u0004\bS\u0010U\"\u0004\bX\u0010YR\u0016\u0010\r\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010a\u001a\u00020]8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010^\u001a\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001a\u0010k\u001a\u00020f8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\u001a\u0010q\u001a\u00020l8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\u00a8\u0006u"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/e;", "Lws/a;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/i;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/c;", "flow", "msgListWithOpType", "", "U", "W", "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "t", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "msg", "u", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "displayModel", BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function1;", "msgCallback", ExifInterface.LATITUDE_SOUTH, "opType", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "N", "E", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/g;", "P", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/g;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgList;", "M", "", "O", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "c", "L", "", "event", "Lcom/tencent/mvi/base/route/a;", "action", "V", "source", "v", "w", HippyTKDListViewAdapter.X, "beginMsgSeq", "endMsgSeq", "y", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/f;", "delegate", "Y", "index", "B", "(J)V", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "msgSeq", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, DomainData.DOMAIN_NAME, "", "list", ReportConstant.COSTREPORT_PREFIX, "Z", UserInfo.SEX_FEMALE, "G", "H", "", "headElimination", "T", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/os/Bundle;", "extra", "d", "g", "a", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/f;", "msgRepoDelegate", "b", "Lkotlin/jvm/functions/Function1;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "", "I", "getDISABLE_ELIMINATION", "()I", "DISABLE_ELIMINATION", "e", "X", "(I)V", "msgLimitCnt", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgList;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/m;", "Lkotlin/Lazy;", "K", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/m;", "uiFocusHolder", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/b;", tl.h.F, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/b;", "msgListDispatcher", "Lcom/tencent/aio/api/runtime/a;", "i", "Lcom/tencent/aio/api/runtime/a;", "D", "()Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "j", "Lkotlinx/coroutines/CoroutineScope;", "J", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", "k", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class MsgListRepo implements IMsgListRepository, e, ws.a {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private f msgRepoDelegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function1<? super l, Unit> msgCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private a displayModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int DISABLE_ELIMINATION;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int msgLimitCnt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MsgList displayList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiFocusHolder;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final b msgListDispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a context;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo$a;", "", "", "LOADFIRSTPAGE_FROM_FIRSTSCREEN", "Ljava/lang/String;", "LOADFIRSTPAGE_FROM_NAVTOBOTTOM", "TAG", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46452);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 36)) {
            redirector.redirect((short) 36);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgListRepo(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) context, (Object) scope);
            return;
        }
        this.context = context;
        this.scope = scope;
        this.msgCallback = new Function1<l, Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo$msgCallback$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) MsgListRepo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(l lVar) {
                invoke2(lVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull l it) {
                b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                MsgListRepo msgListRepo = MsgListRepo.this;
                bVar = msgListRepo.msgListDispatcher;
                msgListRepo.U(bVar, new c(it, false, 2, null));
            }
        };
        this.displayModel = new a();
        this.DISABLE_ELIMINATION = -1;
        this.msgLimitCnt = -1;
        MsgList msgList = new MsgList();
        msgList.setFilter(new Function1<Collection<? extends com.tencent.aio.data.msglist.a>, Collection<? extends com.tencent.aio.data.msglist.a>>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo$$special$$inlined$apply$lambda$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MsgListRepo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Collection<com.tencent.aio.data.msglist.a> invoke(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Collection) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return MsgListRepo.this.s(it);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.displayList = msgList;
        lazy = LazyKt__LazyJVMKt.lazy(MsgListRepo$uiFocusHolder$2.INSTANCE);
        this.uiFocusHolder = lazy;
        this.msgListDispatcher = new b();
    }

    private final void C(c opType) {
        U(this.msgListDispatcher, opType);
    }

    private final m K() {
        return (m) this.uiFocusHolder.getValue();
    }

    private final void R(a displayModel) {
        f fVar = this.msgRepoDelegate;
        if (fVar != null) {
            fVar.j(displayModel);
        }
    }

    private final void S(Function1<? super l, Unit> msgCallback) {
        com.tencent.aio.base.log.a.f69187b.d("MsgListRepo", "onMsgCallbackInitInternal, callback: ");
        f fVar = this.msgRepoDelegate;
        if (fVar != null) {
            fVar.m(msgCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(i<c> flow, c msgListWithOpType) {
        Z(d.b(msgListWithOpType));
        R(this.displayModel);
        List<com.tencent.aio.data.msglist.a> N = N(d.c(msgListWithOpType), d.b(msgListWithOpType));
        MsgList msgList = this.displayList;
        if (msgList != N) {
            msgList.clear();
            this.displayList.addAll(N);
        }
        msgListWithOpType.c(u(new l(N, d.c(msgListWithOpType), msgListWithOpType.b().b(), d.a(msgListWithOpType))));
        flow.b(msgListWithOpType);
    }

    private final void W() {
        c();
    }

    private final List<com.tencent.aio.data.msglist.a> t(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List<com.tencent.aio.data.msglist.a> k3;
        f fVar = this.msgRepoDelegate;
        if (fVar == null || (k3 = fVar.k(displayList)) == null) {
            return k(displayList);
        }
        return k3;
    }

    private final l u(l msg2) {
        l n3;
        f fVar = this.msgRepoDelegate;
        if (fVar == null || (n3 = fVar.n(msg2)) == null) {
            return n(msg2);
        }
        return n3;
    }

    public final void A(long msgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, zs.b.a(Dispatchers.INSTANCE), null, new MsgListRepo$callNavigateToMsg$1(this, msgSeq, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, msgSeq);
        }
    }

    public final void B(long index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, index);
            return;
        }
        com.tencent.aio.base.log.a.f69187b.d("MsgListRepo", "updateFocusIndex " + index);
        K().b(index);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final com.tencent.aio.api.runtime.a D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 33, (Object) this);
        }
        return this.context;
    }

    @NotNull
    public final a E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.displayModel;
    }

    @NotNull
    public final a F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (a) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        this.displayList.assertThread$sdk_debug();
        return this.displayModel;
    }

    @Nullable
    public com.tencent.aio.data.msglist.a G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.displayModel.b();
    }

    @Nullable
    public com.tencent.aio.data.msglist.a H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.displayModel.d();
    }

    public final int I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.msgLimitCnt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final CoroutineScope J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (CoroutineScope) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.scope;
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @NotNull
    public final MsgList M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MsgList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.displayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public List<com.tencent.aio.data.msglist.a> N(@NotNull IMsgListRepository.MsgListRepoOpType opType, @NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) opType, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(opType, "opType");
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        int size = displayList.size();
        int i3 = this.msgLimitCnt;
        if (size > i3 && i3 != this.DISABLE_ELIMINATION) {
            int size2 = displayList.size();
            int i16 = j.f69545a[opType.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    return displayList;
                }
                ArrayList arrayList = new ArrayList(displayList.subList(0, this.msgLimitCnt));
                com.tencent.aio.base.log.a.f69187b.i("MsgListRepo", "msgElimination: delete " + (size2 - this.msgLimitCnt) + " at foot");
                T(false);
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(displayList.subList(displayList.size() - this.msgLimitCnt, displayList.size()));
            com.tencent.aio.base.log.a.f69187b.i("MsgListRepo", "msgElimination: delete " + (size2 - this.msgLimitCnt) + " at head");
            T(true);
            return arrayList2;
        }
        return displayList;
    }

    public final long O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return K().a();
    }

    @NotNull
    public final g<c> P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (g) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.msgListDispatcher;
    }

    public void Q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            L();
            W();
        }
    }

    public void T(boolean headElimination) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, headElimination);
        }
    }

    public final void V(@Nullable String event, @NotNull com.tencent.mvi.base.route.a action) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) event, (Object) action);
        } else {
            Intrinsics.checkNotNullParameter(action, "action");
            this.context.e().d(event, action);
        }
    }

    public final void X(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.msgLimitCnt = i3;
        }
    }

    public final void Y(@NotNull f delegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) delegate);
            return;
        }
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (Intrinsics.areEqual(this.msgRepoDelegate, delegate)) {
            return;
        }
        f fVar = this.msgRepoDelegate;
        this.msgRepoDelegate = delegate;
        Function1<? super l, Unit> function1 = this.msgCallback;
        if (function1 != null) {
            Intrinsics.checkNotNull(function1);
            S(function1);
        }
        f fVar2 = this.msgRepoDelegate;
        if (fVar2 != null) {
            fVar2.l(this.context, this.scope);
        }
        f fVar3 = this.msgRepoDelegate;
        if (fVar3 != null) {
            fVar3.c();
        }
        if (fVar != null) {
            fVar.onDestroy();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (r2 > ((com.tencent.aio.data.msglist.a) r0).getMsgSeq()) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0098, code lost:
    
        if (r2 < ((com.tencent.aio.data.msglist.a) r0).getMsgSeq()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Z(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        Object first;
        Object last;
        Object last2;
        Object first2;
        Object last3;
        Object first3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) displayList);
            return;
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        this.displayList.assertThread$sdk_debug();
        if (displayList.isEmpty()) {
            return;
        }
        if (this.displayModel.b() != null) {
            com.tencent.aio.data.msglist.a b16 = this.displayModel.b();
            Intrinsics.checkNotNull(b16);
            long msgSeq = b16.getMsgSeq();
            first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
        }
        a aVar = this.displayModel;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
        aVar.g((com.tencent.aio.data.msglist.a) first);
        com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("set firstMsg: ");
        com.tencent.aio.data.msglist.a b17 = this.displayModel.b();
        Intrinsics.checkNotNull(b17);
        sb5.append(b17.getMsgSeq());
        aVar2.d("MsgListRepo", sb5.toString());
        if (this.displayModel.d() != null) {
            com.tencent.aio.data.msglist.a d16 = this.displayModel.d();
            Intrinsics.checkNotNull(d16);
            long msgSeq2 = d16.getMsgSeq();
            last3 = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
        }
        a aVar3 = this.displayModel;
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
        aVar3.i((com.tencent.aio.data.msglist.a) last);
        com.tencent.aio.base.log.a aVar4 = com.tencent.aio.base.log.a.f69187b;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("set lastMsg: ");
        com.tencent.aio.data.msglist.a d17 = this.displayModel.d();
        Intrinsics.checkNotNull(d17);
        sb6.append(d17.getMsgSeq());
        aVar4.d("MsgListRepo", sb6.toString());
        a aVar5 = this.displayModel;
        last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) displayList);
        aVar5.k((com.tencent.aio.data.msglist.a) last2);
        a aVar6 = this.displayModel;
        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) displayList);
        aVar6.j((com.tencent.aio.data.msglist.a) first2);
    }

    public abstract void c();

    @Override // ws.a
    public void d(@NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, opType, list, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(opType, "opType");
        if (list == null) {
            list = M();
        }
        C(new c(new l(list, opType, null, extra, 4, null), false, 2, null));
    }

    @Override // ws.a
    public void g(@NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Bundle extra) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, opType, list, extra);
            return;
        }
        Intrinsics.checkNotNullParameter(opType, "opType");
        if (list == null) {
            list = M();
        }
        C(new c(new l(list, opType, null, extra, 4, null), true));
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public l n(@NotNull l msgListWithOpType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (l) iPatchRedirector.redirect((short) 21, (Object) this, (Object) msgListWithOpType);
        }
        Intrinsics.checkNotNullParameter(msgListWithOpType, "msgListWithOpType");
        return new l(t(msgListWithOpType.c()), msgListWithOpType.d(), msgListWithOpType.b(), msgListWithOpType.a());
    }

    @CallSuper
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        f fVar = this.msgRepoDelegate;
        if (fVar != null) {
            fVar.onDestroy();
        }
    }

    @NotNull
    public final Collection<com.tencent.aio.data.msglist.a> s(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Collection<com.tencent.aio.data.msglist.a> b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Collection) iPatchRedirector.redirect((short) 22, (Object) this, (Object) list);
        }
        Intrinsics.checkNotNullParameter(list, "list");
        f fVar = this.msgRepoDelegate;
        if (fVar == null || (b16 = fVar.b(list)) == null) {
            return b(list);
        }
        return b16;
    }

    public final void v(@NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) source);
        } else {
            Intrinsics.checkNotNullParameter(source, "source");
            BuildersKt__Builders_commonKt.launch$default(this.scope, zs.b.a(Dispatchers.INSTANCE), null, new MsgListRepo$callLoadFirstPage$1(this, source, null), 2, null);
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, zs.b.a(Dispatchers.INSTANCE), null, new MsgListRepo$callLoadNextPage$1(this, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, zs.b.a(Dispatchers.INSTANCE), null, new MsgListRepo$callLoadPrePage$1(this, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    public final void y(long beginMsgSeq, long endMsgSeq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, zs.b.a(Dispatchers.INSTANCE), null, new MsgListRepo$callLoadRangePage$1(this, beginMsgSeq, endMsgSeq, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(beginMsgSeq), Long.valueOf(endMsgSeq));
        }
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, zs.b.a(Dispatchers.INSTANCE), null, new MsgListRepo$callNavigateToBottom$1(this, null), 2, null);
        } else {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }
}
