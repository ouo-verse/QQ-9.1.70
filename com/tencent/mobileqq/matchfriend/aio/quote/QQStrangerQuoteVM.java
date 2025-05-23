package com.tencent.mobileqq.matchfriend.aio.quote;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteEvent;
import com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteUIState;
import com.tencent.mobileqq.matchfriend.aio.quote.d;
import com.tencent.mobileqq.matchfriend.aio.quote.e;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.i;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\r*\u0003;>A\b\u0007\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001LB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u0018\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010*\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00101\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0016\u00103\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00106\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00105R\u001b\u0010:\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b8\u00109R\u0014\u0010\u0012\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010BR\u0014\u0010F\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020\"8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bG\u0010H\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/d;", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteUIState;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "D", "intent", "Lcom/tencent/mvi/base/route/k;", UserInfo.SEX_FEMALE, "J", "H", "K", "Lcom/tencent/mobileqq/matchfriend/aio/quote/c;", "data", "Lcom/tencent/mobileqq/matchfriend/aio/quote/a;", "action", "L", "", "clip", "", "padding", "M", "needAnim", "w", "y", "Lcom/tencent/aio/api/runtime/a;", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, BdhLogUtil.LogTag.Tag_Conn, "", "d", "Ljava/lang/String;", "feedId", "e", "Lkotlin/Lazy;", "G", "()Z", "isQuoteEnable", "f", "Z", "hasQuoteInit", tl.h.F, "isQuoteShow", "i", "isPanelShow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isKeyboardShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isSendingMsg", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteRepo;", "B", "()Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteRepo;", "repo", "com/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$b", "E", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$b;", "com/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$c", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$c;", "actionR", "com/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$d", "Lcom/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$d;", "msgListener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()I", "chatType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/String;", "peerUid", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerQuoteVM extends com.tencent.aio.base.mvvm.b<com.tencent.mobileqq.matchfriend.aio.quote.d, QQStrangerQuoteUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private AtomicBoolean isSendingMsg;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy repo;

    /* renamed from: E, reason: from kotlin metadata */
    private final b action;

    /* renamed from: F, reason: from kotlin metadata */
    private final c actionR;

    /* renamed from: G, reason: from kotlin metadata */
    private final d msgListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String feedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy isQuoteEnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean hasQuoteInit;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isQuoteShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isKeyboardShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            QQStrangerQuoteVM.this.D(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        public k call(MsgIntent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return QQStrangerQuoteVM.this.F(intent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/matchfriend/aio/quote/QQStrangerQuoteVM$d", "Lcom/tencent/qqnt/msg/i;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "onAddSendMsg", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d extends i {
        d() {
        }

        @Override // com.tencent.qqnt.msg.i, com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(MsgRecord msgRecord) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            if (msgRecord.chatType == QQStrangerQuoteVM.this.z() && Intrinsics.areEqual(msgRecord.peerUid, QQStrangerQuoteVM.this.A()) && QQStrangerQuoteVM.this.isQuoteShow) {
                QQStrangerQuoteVM.this.updateUI(new QQStrangerQuoteUIState.RemoveQuoteView(false));
            }
        }
    }

    public QQStrangerQuoteVM() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$isQuoteEnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(b.f243941a.b(QQStrangerQuoteVM.this.z()));
            }
        });
        this.isQuoteEnable = lazy;
        this.isSendingMsg = new AtomicBoolean(false);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerQuoteRepo>() { // from class: com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteVM$repo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerQuoteRepo invoke() {
                return new QQStrangerQuoteRepo();
            }
        });
        this.repo = lazy2;
        this.action = new b();
        this.actionR = new c();
        this.msgListener = new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final String A() {
        AIOSession r16;
        AIOContact c16;
        String j3;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        return (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) ? "" : j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQStrangerQuoteRepo B() {
        return (QQStrangerQuoteRepo) this.repo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(MsgIntent msgIntent) {
        if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            this.isPanelShow = ((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent).b();
            x(this, false, 1, null);
        } else if (msgIntent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            this.isKeyboardShow = ((KeyboardMsgIntent.OnKeyboardStateChanged) msgIntent).b();
            w(false);
        } else if (msgIntent instanceof AIOMsgListEvent.BottomLayoutHeightChange) {
            updateUI(new QQStrangerQuoteUIState.UpdateBottomMargin(((AIOMsgListEvent.BottomLayoutHeightChange) msgIntent).a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k F(MsgIntent intent) {
        return e.a.f243959a;
    }

    private final boolean G() {
        return ((Boolean) this.isQuoteEnable.getValue()).booleanValue();
    }

    private final void J() {
        if (!G()) {
            this.hasQuoteInit = true;
            K();
        } else {
            K();
            BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getIO(), null, new QQStrangerQuoteVM$requestQuoteData$1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void K() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new QQStrangerQuoteEvent.OnQuoteStateChanged(this.hasQuoteInit, this.isQuoteShow));
    }

    private final void L(QQStrangerQuoteData data, QQStrangerQuoteAction action) {
        BuildersKt__Builders_commonKt.launch$default(vmScope(), Dispatchers.getIO(), null, new QQStrangerQuoteVM$sendQuoteMsg$1(this, action, data, null), 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M(boolean clip, int padding) {
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        if (e16 != null) {
            e16.h(new AIOMsgListEvent.SetClipMode(clip, padding));
        }
    }

    private final void w(boolean needAnim) {
        updateUI(new QQStrangerQuoteUIState.ChangeQuoteViewState((this.isPanelShow || this.isKeyboardShow) ? false : true, needAnim));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int y() {
        int z16 = z();
        return (z16 == 104 || z16 != 119) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int z() {
        AIOSession r16;
        AIOContact c16;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        if (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) {
            return 0;
        }
        return c16.e();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void handleIntent(com.tencent.mobileqq.matchfriend.aio.quote.d intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof d.b) {
            J();
            return;
        }
        if (intent instanceof d.c) {
            d.c cVar = (d.c) intent;
            L(cVar.getData(), cVar.getAction());
        } else if (intent instanceof d.C8004d) {
            d.C8004d c8004d = (d.C8004d) intent;
            M(c8004d.getClip(), c8004d.getPadding());
        } else if (intent instanceof d.a) {
            H();
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.BottomLayoutHeightChange");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.matchfriend.aio.quote.QQStrangerQuoteEvent.GetQuoteState");
        return hashSet;
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(com.tencent.aio.api.runtime.a context, boolean reuse) {
        Bundle l3;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        AIOParam g16 = context.g();
        this.feedId = (g16 == null || (l3 = g16.l()) == null) ? null : l3.getString("quote_feed_id");
        if (G()) {
            j e16 = context.e();
            if (e16 != null) {
                e16.f(this, this.action);
                e16.l(this, this.actionR);
            }
            w e17 = com.tencent.qqnt.msg.f.e();
            if (e17 != null) {
                e17.addMsgListener(this.msgListener);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        if (G()) {
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e16 != null) {
                e16.i(this, this.action);
                e16.e(this);
            }
            w e17 = com.tencent.qqnt.msg.f.e();
            if (e17 != null) {
                e17.removeMsgListener(this.msgListener);
            }
        }
    }

    private final void H() {
        this.isQuoteShow = false;
        K();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void x(QQStrangerQuoteVM qQStrangerQuoteVM, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        qQStrangerQuoteVM.w(z16);
    }
}
