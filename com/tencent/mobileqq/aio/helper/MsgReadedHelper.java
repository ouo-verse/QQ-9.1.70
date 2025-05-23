package com.tencent.mobileqq.aio.helper;

import android.os.Looper;
import android.os.Message;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgReadEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.aio.utils.AIOSwitchUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOAnimationApi;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tribe.async.log.SLog;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0004\n\u0002\b\n*\u0002/3\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0002:;B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J$\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0014H\u0016R\u0016\u0010 \u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010'R\u0016\u0010*\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u001b\u0010.\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/MsgReadedHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "g", "j", "i", tl.h.F, "Lcom/tencent/mvi/base/route/MsgIntent;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "k", "Lcom/tencent/mobileqq/aio/helper/MsgReadedHelper$ReadedScorce;", "from", "", SLog.LOG_TAG, "forceRead", "o", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "I", "chatType", "e", "Lcom/tencent/aio/main/businesshelper/b;", "f", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioBottomMsg", "latestAioMsg", "Z", "emptyMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "reportWhenMsgLoaded", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "()Z", "setReadAsyncSwitch", "com/tencent/mobileqq/aio/helper/MsgReadedHelper$b", "D", "Lcom/tencent/mobileqq/aio/helper/MsgReadedHelper$b;", "action", "com/tencent/mobileqq/aio/helper/MsgReadedHelper$c", "E", "Lcom/tencent/mobileqq/aio/helper/MsgReadedHelper$c;", "uiHandler", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "ReadedScorce", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class MsgReadedHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy setReadAsyncSwitch;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c uiHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int chatType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem aioBottomMsg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AIOMsgItem latestAioMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean emptyMsg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean reportWhenMsgLoaded;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/MsgReadedHelper$ReadedScorce;", "", "(Ljava/lang/String;I)V", "READED_FROM_SCROLLEVNET", "READED_FROM_CREATE", "READED_FROM_PAUSE", "READED_FROM_AIOEXIT", "READED_FROM_NAVI_CALLBACK", "READED_FROM_MSG_LOADED", "aio_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class ReadedScorce {
        private static final /* synthetic */ ReadedScorce[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final ReadedScorce READED_FROM_AIOEXIT;
        public static final ReadedScorce READED_FROM_CREATE;
        public static final ReadedScorce READED_FROM_MSG_LOADED;
        public static final ReadedScorce READED_FROM_NAVI_CALLBACK;
        public static final ReadedScorce READED_FROM_PAUSE;
        public static final ReadedScorce READED_FROM_SCROLLEVNET;

        private static final /* synthetic */ ReadedScorce[] $values() {
            return new ReadedScorce[]{READED_FROM_SCROLLEVNET, READED_FROM_CREATE, READED_FROM_PAUSE, READED_FROM_AIOEXIT, READED_FROM_NAVI_CALLBACK, READED_FROM_MSG_LOADED};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50884);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            READED_FROM_SCROLLEVNET = new ReadedScorce("READED_FROM_SCROLLEVNET", 0);
            READED_FROM_CREATE = new ReadedScorce("READED_FROM_CREATE", 1);
            READED_FROM_PAUSE = new ReadedScorce("READED_FROM_PAUSE", 2);
            READED_FROM_AIOEXIT = new ReadedScorce("READED_FROM_AIOEXIT", 3);
            READED_FROM_NAVI_CALLBACK = new ReadedScorce("READED_FROM_NAVI_CALLBACK", 4);
            READED_FROM_MSG_LOADED = new ReadedScorce("READED_FROM_MSG_LOADED", 5);
            $VALUES = $values();
        }

        ReadedScorce(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static ReadedScorce valueOf(String str) {
            return (ReadedScorce) Enum.valueOf(ReadedScorce.class, str);
        }

        public static ReadedScorce[] values() {
            return (ReadedScorce[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/MsgReadedHelper$a;", "", "", "SET_READ_WHEN_OPEN", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.MsgReadedHelper$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/MsgReadedHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgReadedHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                MsgReadedHelper.this.n(i3);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/MsgReadedHelper$c", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends MqqHandler {
        static IPatchRedirector $redirector_;

        c(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgReadedHelper.this, (Object) looper);
            }
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(@NotNull Message msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 267387172) {
                MsgReadedHelper.p(MsgReadedHelper.this, ReadedScorce.READED_FROM_CREATE, false, false, 6, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50905);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MsgReadedHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(MsgReadedHelper$setReadAsyncSwitch$2.INSTANCE);
            this.setReadAsyncSwitch = lazy;
            this.action = new b();
            this.uiHandler = new c(Looper.getMainLooper());
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void g() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().f(this, this.action);
        this.reportWhenMsgLoaded = false;
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        int e16 = bVar2.a().g().r().c().e();
        this.chatType = e16;
        if (e16 != 2) {
            this.uiHandler.sendEmptyMessageDelayed(267387172, 500L);
        }
    }

    private final void h() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().i(this, this.action);
        if (this.chatType != 2) {
            this.uiHandler.removeMessages(267387172);
        }
        this.aioBottomMsg = null;
        this.latestAioMsg = null;
        this.reportWhenMsgLoaded = false;
        this.emptyMsg = false;
    }

    private final void i() {
        if (this.chatType != 2) {
            this.uiHandler.removeMessages(267387172);
        }
        p(this, ReadedScorce.READED_FROM_PAUSE, m(), false, 4, null);
    }

    private final String k(AIOMsgItem msgItem) {
        Long l3;
        Long l16 = null;
        if (msgItem != null) {
            l3 = Long.valueOf(msgItem.getMsgId());
        } else {
            l3 = null;
        }
        if (msgItem != null) {
            l16 = Long.valueOf(msgItem.getMsgSeq());
        }
        return "msgId:" + l3 + " msgSeq:" + l16;
    }

    private final boolean m() {
        return ((Boolean) this.setReadAsyncSwitch.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MsgIntent i3) {
        long j3;
        AIOMsgItem aIOMsgItem;
        if (i3 instanceof AIOMsgListEvent.MsgListScrollEvent) {
            AIOMsgItem aIOMsgItem2 = this.aioBottomMsg;
            long j16 = 0;
            if (aIOMsgItem2 != null) {
                j3 = aIOMsgItem2.getMsgId();
            } else {
                j3 = 0;
            }
            AIOMsgItem aIOMsgItem3 = this.latestAioMsg;
            if (aIOMsgItem3 != null) {
                aIOMsgItem3.getMsgId();
            }
            AIOMsgItem aIOMsgItem4 = this.aioBottomMsg;
            AIOMsgItem aIOMsgItem5 = this.latestAioMsg;
            AIOMsgListEvent.MsgListScrollEvent msgListScrollEvent = (AIOMsgListEvent.MsgListScrollEvent) i3;
            if (msgListScrollEvent.a() != null) {
                this.aioBottomMsg = msgListScrollEvent.a();
            }
            if (msgListScrollEvent.c() != null) {
                this.latestAioMsg = msgListScrollEvent.c();
            }
            if (AIOSwitchUtil.b() && ((aIOMsgItem4 == null || aIOMsgItem5 == null) && this.aioBottomMsg != null && this.latestAioMsg != null)) {
                p(this, ReadedScorce.READED_FROM_MSG_LOADED, false, false, 6, null);
            }
            AIOMsgItem aIOMsgItem6 = this.aioBottomMsg;
            if (aIOMsgItem6 != null) {
                j16 = aIOMsgItem6.getMsgId();
            }
            if (j3 == j16 && (aIOMsgItem = this.latestAioMsg) != null) {
                aIOMsgItem.getMsgId();
                return;
            }
            return;
        }
        if (i3 instanceof MsgItemExternalRefreshEvent.EnterAIOAnimationStart) {
            if (((MsgItemExternalRefreshEvent.EnterAIOAnimationStart) i3).a() == IAIOAnimationApi.AnimationScene.AIO_EXIT) {
                p(this, ReadedScorce.READED_FROM_AIOEXIT, m(), false, 4, null);
                QLog.i("MsgReadedHelper", 1, "EnterAIOAnimationStart: AIO_EXIT");
                return;
            }
            return;
        }
        if (i3 instanceof AIOMsgReadEvent.SendMsgReadEvent) {
            p(this, ReadedScorce.READED_FROM_NAVI_CALLBACK, false, true, 2, null);
        } else if (i3 instanceof AIOMsgListEvent.EmptyMsgList) {
            this.emptyMsg = true;
        }
    }

    private final void o(final ReadedScorce from, boolean async, boolean forceRead) {
        AIOMsgItem aIOMsgItem;
        if (!forceRead && (((aIOMsgItem = this.aioBottomMsg) == null || this.latestAioMsg == null) && !this.emptyMsg)) {
            this.reportWhenMsgLoaded = true;
            QLog.i("MsgReadedHelper", 1, "setReadedAndReport aioBottomMsg: " + k(aIOMsgItem) + " latestAioMsg: " + k(this.latestAioMsg) + " from: " + from);
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        final int e16 = bVar.a().g().r().c().e();
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar2 = null;
        }
        final String j3 = bVar2.a().g().r().c().j();
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        final String f16 = bVar3.a().g().r().c().f();
        QLog.i("MsgReadedHelper", 1, "setReadedAndReport from" + from);
        if (async) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.helper.ak
                @Override // java.lang.Runnable
                public final void run() {
                    MsgReadedHelper.q(e16, j3, f16, from);
                }
            }, 16, null, false);
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(e16, j3, f16), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.helper.al
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    MsgReadedHelper.s(j3, from, i3, str);
                }
            });
        }
    }

    static /* synthetic */ void p(MsgReadedHelper msgReadedHelper, ReadedScorce readedScorce, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        msgReadedHelper.o(readedScorce, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(int i3, final String peerUid, String guildId, final ReadedScorce from) {
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(from, "$from");
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(new Contact(i3, peerUid, guildId), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.helper.am
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str) {
                MsgReadedHelper.r(peerUid, from, i16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(String peerUid, ReadedScorce from, int i3, String str) {
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(from, "$from");
        QLog.i("MsgReadedHelper", 1, "setMsgReadAndReport setMsgRead peerUid:" + peerUid + " result = " + i3 + ", errMsg = " + str + " from: " + from);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String peerUid, ReadedScorce from, int i3, String str) {
        Intrinsics.checkNotNullParameter(peerUid, "$peerUid");
        Intrinsics.checkNotNullParameter(from, "$from");
        QLog.i("MsgReadedHelper", 1, "setMsgReadAndReport setMsgRead peerUid:" + peerUid + " result = " + i3 + ", errMsg = " + str + " from: " + from);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MsgListScrollEvent");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.EnterAIOAnimationStart");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgReadEvent.SendMsgReadEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.EmptyMsgList");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MsgReadedHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 3, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
        } else {
            Intrinsics.checkNotNullParameter(param, "param");
            this.param = param;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
            return;
        }
        if (state != 0) {
            if (state != 3) {
                if (state != 8) {
                    if (state == 12) {
                        h();
                        return;
                    }
                    return;
                }
                i();
                return;
            }
            j();
            return;
        }
        g();
    }

    private final void j() {
    }
}
