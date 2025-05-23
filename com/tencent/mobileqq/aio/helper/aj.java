package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.GestureEvent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMoreApi;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001%\b\u0007\u0018\u0000 G2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0019\u0012\u0006\u0010D\u001a\u00020C\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R&\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020%0)0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/aj;", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/b;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "w", HippyTKDListViewAdapter.X, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "o", "Landroid/view/MotionEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$ShowEmoReplyMoreMenuEvent;", "k", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/data/msglist/a;", "msg", "v", "", TabPreloadItem.TAB_NAME_MESSAGE, "t", "", "r", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnRevokeEvent;", "u", ReportConstant.COSTREPORT_PREFIX, "a", tl.h.F, "g", "msgIntent", "p", "", "getId", "", "getTag", "b", "onBackEvent", "com/tencent/mobileqq/aio/helper/aj$b", "f", "Lcom/tencent/mobileqq/aio/helper/aj$b;", "action", "Lkotlin/Pair;", "Ljava/util/List;", "messageList", "Landroid/content/Context;", "i", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "showMenuMainThread", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel$Source;", "D", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel$Source;", "source", "Landroid/view/View;", "E", "Landroid/view/View;", "anchorView", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel;", UserInfo.SEX_FEMALE, "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel;", "emoReplyMorePanel", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "<init>", "(Lcom/tencent/aio/main/businesshelper/b;Lcom/tencent/mvi/base/route/MsgIntent;)V", "G", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class aj extends com.tencent.mobileqq.aio.helper.LateInitHelper.b implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private MsgRecord msgRecord;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IAIOEmoReplyMorePanel.Source source;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View anchorView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IAIOEmoReplyMorePanel emoReplyMorePanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean showMenuMainThread;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/aj$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.aj$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/aj$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aj.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                aj.this.o(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50864);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(@NotNull com.tencent.aio.main.businesshelper.b helperParam, @Nullable MsgIntent msgIntent) {
        super(helperParam, msgIntent);
        List<Pair<String, b>> listOf;
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helperParam, (Object) msgIntent);
            return;
        }
        b bVar = new b();
        this.action = bVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(GestureEvent.DispatchTouchEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ShowEmoReplyMoreMenuEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnReceiveMsgs.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.MsgOnRevokeEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnMsgTailChanged.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LifeCycleEvent.OnPause.class)), bVar)});
        this.messageList = listOf;
        this.showMenuMainThread = true;
    }

    private final void k(AIOMsgListEvent.ShowEmoReplyMoreMenuEvent intent) {
        if (this.source == intent.f() && Intrinsics.areEqual(this.anchorView, intent.a())) {
            IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel = this.emoReplyMorePanel;
            boolean z16 = false;
            if (iAIOEmoReplyMorePanel != null && iAIOEmoReplyMorePanel.isShowing()) {
                z16 = true;
            }
            if (z16) {
                n();
                return;
            }
        }
        n();
        this.source = intent.f();
        this.anchorView = intent.a();
        IAIOEmoReplyMorePanel createPanel = ((IAIOEmoReplyMoreApi) QRoute.api(IAIOEmoReplyMoreApi.class)).createPanel();
        this.emoReplyMorePanel = createPanel;
        if (createPanel != null) {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            IAIOEmoReplyMorePanel.a.a(createPanel, context, intent.d(), intent.a(), intent.e(), intent.c(), intent.f(), 0, intent.b(), 64, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m() {
        com.tencent.qqnt.aio.anisticker.view.h.f348873a.e();
    }

    private final void n() {
        IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel;
        IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel2 = this.emoReplyMorePanel;
        boolean z16 = false;
        if (iAIOEmoReplyMorePanel2 != null && iAIOEmoReplyMorePanel2.isShowing()) {
            z16 = true;
        }
        if (z16 && (iAIOEmoReplyMorePanel = this.emoReplyMorePanel) != null) {
            iAIOEmoReplyMorePanel.dismiss();
        }
        this.emoReplyMorePanel = null;
        this.anchorView = null;
        this.source = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(MsgIntent intent) {
        if (intent instanceof GestureEvent.DispatchTouchEvent) {
            q(((GestureEvent.DispatchTouchEvent) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.ShowEmoReplyMoreMenuEvent) {
            k((AIOMsgListEvent.ShowEmoReplyMoreMenuEvent) intent);
            return;
        }
        if (intent instanceof LifeCycleEvent.OnPause) {
            n();
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnReceiveMsgs) {
            t(((AIOMsgListEvent.OnReceiveMsgs) intent).a());
        } else if (intent instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            u((AIOMsgSendEvent.MsgOnRevokeEvent) intent);
        } else if (intent instanceof AIOMsgListEvent.OnMsgTailChanged) {
            v(((AIOMsgListEvent.OnMsgTailChanged) intent).a());
        }
    }

    private final void q(MotionEvent event) {
        if (event.getActionMasked() == 0) {
            IAIOEmoReplyMorePanel.Source source = this.source;
            if (source == IAIOEmoReplyMorePanel.Source.EMO_REPLY_MORE) {
                n();
            } else if (source != IAIOEmoReplyMorePanel.Source.EMO_REPLY_ADD || !s(event)) {
                n();
            }
        }
    }

    private final boolean r() {
        AIOMsgListEvent.GetCurFocusIndex getCurFocusIndex = new AIOMsgListEvent.GetCurFocusIndex(0L, 1, null);
        c().a().e().h(getCurFocusIndex);
        if (getCurFocusIndex.a() == -1) {
            return true;
        }
        return false;
    }

    private final boolean s(MotionEvent event) {
        boolean z16;
        boolean z17;
        View view = this.anchorView;
        if (view == null) {
            return false;
        }
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = iArr[0] + view.getWidth();
        int height = iArr[1] + view.getHeight();
        if (iArr[0] <= rawX && rawX <= width) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (iArr[1] <= rawY && rawY <= height) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            return false;
        }
        return true;
    }

    private final void t(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String str;
        AIOSession r16;
        AIOContact c16;
        IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel = this.emoReplyMorePanel;
        boolean z16 = false;
        if (iAIOEmoReplyMorePanel != null && iAIOEmoReplyMorePanel.isShowing()) {
            z16 = true;
        }
        if (!z16 || msgList.isEmpty() || !r()) {
            return;
        }
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            AIOParam g16 = c().a().g();
            if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                str = c16.j();
            } else {
                str = null;
            }
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            if (Intrinsics.areEqual(str, ((AIOMsgItem) aVar).getMsgRecord().peerUid)) {
                n();
                return;
            }
        }
    }

    private final void u(AIOMsgSendEvent.MsgOnRevokeEvent intent) {
        MsgRecord msgRecord;
        IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel = this.emoReplyMorePanel;
        boolean z16 = false;
        if (iAIOEmoReplyMorePanel != null && iAIOEmoReplyMorePanel.isShowing()) {
            z16 = true;
        }
        if (z16 && (msgRecord = this.msgRecord) != null) {
            long msgId = msgRecord.getMsgId();
            if (msgId == intent.a()) {
                QLog.i("MoreEmoReplyMenuHelper", 1, "[onMsgRevoke]: dismiss menu, msgId is " + msgId);
                n();
            }
        }
    }

    private final void v(com.tencent.aio.data.msglist.a msg2) {
        String str;
        AIOSession r16;
        AIOContact c16;
        IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel = this.emoReplyMorePanel;
        boolean z16 = false;
        if (iAIOEmoReplyMorePanel != null && iAIOEmoReplyMorePanel.isShowing()) {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        AIOParam g16 = c().a().g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        } else {
            str = null;
        }
        Intrinsics.checkNotNull(msg2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
        if (Intrinsics.areEqual(str, ((AIOMsgItem) msg2).getMsgRecord().peerUid)) {
            n();
        }
    }

    private final void w() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c().a().e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        c().a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }

    private final void x() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c().a().e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        c().a().b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("MoreEmoReplyMenuHelper", 1, OperateCustomButton.OPERATE_CREATE);
        Context requireContext = c().a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "helperParam.aioContext.fragment.requireContext()");
        this.context = requireContext;
        if (e() != null) {
            p(e());
        }
        w();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.ai
            @Override // java.lang.Runnable
            public final void run() {
                aj.m();
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("MoreEmoReplyMenuHelper", 1, "destroy");
        x();
        n();
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "MoreEmoReplyMenuHelper";
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        try {
            IAIOEmoReplyMorePanel iAIOEmoReplyMorePanel = this.emoReplyMorePanel;
            if (iAIOEmoReplyMorePanel != null && iAIOEmoReplyMorePanel.isShowing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            n();
            return true;
        } catch (Exception e16) {
            QLog.i("MoreEmoReplyMenuHelper", 1, "onBackEvent:" + e16);
            throw new IllegalStateException("MoreEmoReplyMenuHelper, call OnBackEvent from illegal thread, isMainThread " + Looper.getMainLooper().isCurrentThread() + ", showMenuMainThread " + this.showMenuMainThread);
        }
    }

    public void p(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            o(msgIntent);
        }
    }
}
