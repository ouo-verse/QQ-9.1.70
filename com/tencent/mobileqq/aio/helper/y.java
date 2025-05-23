package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
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
import com.tencent.mobileqq.aio.menu.EmoReplyAnimationUtil;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001/\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0019\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u0006\u0010*\u001a\u00020\u0003J\u0006\u0010+\u001a\u00020\u001bJ\u001e\u0010.\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010-\u001a\u00020,R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R&\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020/030\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00104R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/y;", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/b;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "v", HippyTKDListViewAdapter.X, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/MotionEvent;", "event", "o", "Landroid/view/View;", "targetView", "animationView", "w", "Landroid/content/Context;", "context", "contentView", "Landroid/widget/PopupWindow;", "j", "Lcom/tencent/aio/data/msglist/a;", "msg", "t", "", TabPreloadItem.TAB_NAME_MESSAGE, "r", "", "p", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnRevokeEvent;", ReportConstant.COSTREPORT_PREFIX, "a", tl.h.F, "g", "msgIntent", DomainData.DOMAIN_NAME, "", "getId", "", "getTag", "b", "onBackEvent", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/aio/emoreply/h;", "emoReplyAnimationInfo", "u", "com/tencent/mobileqq/aio/helper/y$b", "f", "Lcom/tencent/mobileqq/aio/helper/y$b;", "action", "Lkotlin/Pair;", "Ljava/util/List;", "messageList", "i", "Landroid/content/Context;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/PopupWindow;", "popupWindow", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "<init>", "(Lcom/tencent/aio/main/businesshelper/b;Lcom/tencent/mvi/base/route/MsgIntent;)V", "D", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class y extends com.tencent.mobileqq.aio.helper.LateInitHelper.b implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> messageList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord msgRecord;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/y$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.y$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/y$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) y.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                y.this.m(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50175);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@NotNull com.tencent.aio.main.businesshelper.b helperParam, @Nullable MsgIntent msgIntent) {
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
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(GestureEvent.DispatchTouchEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.DismissEmoReplyAnimationEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnReceiveMsgs.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.MsgOnRevokeEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnMsgTailChanged.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LifeCycleEvent.OnPause.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.EmoReplyAnimationEvent.class)), bVar)});
        this.messageList = listOf;
    }

    private final PopupWindow j(Context context, View contentView) {
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setFocusable(false);
        popupWindow.setTouchable(false);
        popupWindow.setSoftInputMode(1);
        popupWindow.setInputMethodMode(2);
        popupWindow.setWidth(-1);
        popupWindow.setHeight(-1);
        popupWindow.setAnimationStyle(0);
        popupWindow.setClippingEnabled(false);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(contentView);
        popupWindow.setContentView(frameLayout);
        return popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(MsgIntent intent) {
        if (intent instanceof GestureEvent.DispatchTouchEvent) {
            o(((GestureEvent.DispatchTouchEvent) intent).a());
            return;
        }
        if (intent instanceof LifeCycleEvent.OnPause) {
            k();
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnReceiveMsgs) {
            r(((AIOMsgListEvent.OnReceiveMsgs) intent).a());
            return;
        }
        if (intent instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            s((AIOMsgSendEvent.MsgOnRevokeEvent) intent);
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnMsgTailChanged) {
            t(((AIOMsgListEvent.OnMsgTailChanged) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.DismissEmoReplyAnimationEvent) {
            k();
            return;
        }
        if (intent instanceof AIOMsgListEvent.EmoReplyAnimationEvent) {
            Context context = this.context;
            if (context == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context = null;
            }
            AIOMsgListEvent.EmoReplyAnimationEvent emoReplyAnimationEvent = (AIOMsgListEvent.EmoReplyAnimationEvent) intent;
            u(context, emoReplyAnimationEvent.b(), emoReplyAnimationEvent.a());
        }
    }

    private final void o(MotionEvent event) {
        if (event.getActionMasked() == 0) {
            EmoReplyAnimationUtil emoReplyAnimationUtil = EmoReplyAnimationUtil.f189971a;
            Object obj = this.context;
            FragmentActivity fragmentActivity = null;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                obj = null;
            }
            if (obj instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) obj;
            }
            emoReplyAnimationUtil.n(fragmentActivity);
        }
    }

    private final boolean p() {
        AIOMsgListEvent.GetCurFocusIndex getCurFocusIndex = new AIOMsgListEvent.GetCurFocusIndex(0L, 1, null);
        c().a().e().h(getCurFocusIndex);
        if (getCurFocusIndex.a() == -1) {
            return true;
        }
        return false;
    }

    private final void r(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String str;
        AIOSession r16;
        AIOContact c16;
        if (!q() || msgList.isEmpty() || !p()) {
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
                k();
                return;
            }
        }
    }

    private final void s(AIOMsgSendEvent.MsgOnRevokeEvent intent) {
        MsgRecord msgRecord;
        if (q() && (msgRecord = this.msgRecord) != null) {
            long msgId = msgRecord.getMsgId();
            if (msgId == intent.a()) {
                QLog.i("EmoReplyAnimationHelper", 1, "[onMsgRevoke]: dismiss menu, msgId is " + msgId);
                k();
            }
        }
    }

    private final void v() {
        Iterator<T> it = this.messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c().a().e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        c().a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }

    private final void w(View targetView, View animationView) {
        QLog.d("EmoReplyAnimationHelper", 1, "showPopupWindow");
        Context context = targetView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "targetView.context");
        PopupWindow j3 = j(context, animationView);
        j3.showAtLocation(targetView, 0, 0, 0);
        this.popupWindow = j3;
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
        QLog.i("EmoReplyAnimationHelper", 1, OperateCustomButton.OPERATE_CREATE);
        Context requireContext = c().a().c().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "helperParam.aioContext.fragment.requireContext()");
        this.context = requireContext;
        if (e() != null) {
            n(e());
        }
        v();
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.i("EmoReplyAnimationHelper", 1, "destroy");
        x();
        k();
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
        return 5;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "EmoReplyAnimationHelper";
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!q()) {
            return;
        }
        QLog.i("EmoReplyAnimationHelper", 1, "dismiss");
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.popupWindow = null;
    }

    public void n(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            m(msgIntent);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        try {
            if (q()) {
                k();
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.i("EmoReplyAnimationHelper", 1, "onBackEvent:" + e16);
            throw new IllegalStateException("EmoReplyAnimationHelper, call OnBackEvent from illegal thread, isMainThread " + Looper.getMainLooper().isCurrentThread());
        }
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow != null) {
            return popupWindow.isShowing();
        }
        return false;
    }

    public final void u(@NotNull Context context, @NotNull com.tencent.aio.data.msglist.a msg2, @NotNull com.tencent.qqnt.aio.emoreply.h emoReplyAnimationInfo) {
        FragmentActivity fragmentActivity;
        String joinToString$default;
        String joinToString$default2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, context, msg2, emoReplyAnimationInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(emoReplyAnimationInfo, "emoReplyAnimationInfo");
        QLog.i("EmoReplyAnimationHelper", 1, "playAnimation, emoReplyAnimationInfo:" + emoReplyAnimationInfo);
        Unit unit = null;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(emoReplyAnimationInfo.f(), (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            joinToString$default2 = ArraysKt___ArraysKt.joinToString$default(emoReplyAnimationInfo.c(), (CharSequence) ", ", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
            QLog.i("EmoReplyAnimationHelper", 1, "parabolaAnimation startLocation:" + joinToString$default + ", endLocation:" + joinToString$default2);
            View m3 = EmoReplyAnimationUtil.f189971a.m(fragmentActivity, emoReplyAnimationInfo, ((AIOMsgItem) msg2).getMsgRecord());
            View g16 = emoReplyAnimationInfo.g();
            if (g16 != null) {
                w(g16, m3);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.i("EmoReplyAnimationHelper", 1, "playAnimation failed, emoReplyAnimationInfo:" + emoReplyAnimationInfo);
            }
        }
    }

    private final void t(com.tencent.aio.data.msglist.a msg2) {
    }
}
