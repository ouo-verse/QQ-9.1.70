package com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar;

import android.os.Handler;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.GestureEvent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendRsp;
import com.tencent.qqnt.aio.assistedchat.topic.mvi.a;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bL\u0010MJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\u0010\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0#H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u0010\u0010)\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020(H\u0016R\u001b\u00100\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010-\u001a\u0004\b.\u0010/R\u001b\u00102\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010-\u001a\u0004\b1\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00107R\u0018\u0010;\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010:R\u0016\u0010>\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010?\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010=R\u0016\u0010@\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010=R\u0016\u0010H\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010=R\u001b\u0010K\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010-\u001a\u0004\b3\u0010J\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/topic/bottomsectionbar/RecommendTopicProcessor;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "B", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "U", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "P", "J", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/aio/event/GestureEvent$DispatchTouchEvent;", "event", ExifInterface.LATITUDE_SOUTH, "O", "Lcom/tencent/input/base/panelcontainer/keyboard/KeyboardMsgIntent$OnKeyboardStateChanged;", "intent", "M", "Lcom/tencent/input/base/panelcontainer/PanelContainerMsgIntent$OnPanelStateChangedMsgIntent;", "N", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$EditTextChangedMsgIntent;", "L", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnSettingSwitchChanged;", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "from", "T", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "E", "", "f", "e", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "Lcom/tencent/mvi/base/route/MsgIntent;", "", h.F, "Lol3/b;", "i", "j", "Lkotlin/Lazy;", "H", "()Z", "isExp", "I", "isLittleAssistant", "D", "Ljava/lang/Boolean;", "isSwitchOn", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "requestTopicRunnable", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "reqJob", "G", "Z", "isShowKeyboard", "isShowPanel", "isInputEmpty", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/b;", "currentShowModel", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "K", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommendContent", "resume", "firstResume", "Landroid/os/Handler;", "()Landroid/os/Handler;", "uiHandler", "<init>", "()V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class RecommendTopicProcessor extends BottomSectionBarBaseProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy isLittleAssistant;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Boolean isSwitchOn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Runnable requestTopicRunnable;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Job reqJob;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isShowKeyboard;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isShowPanel;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isInputEmpty;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.bottombar.sectionbar.model.b currentShowModel;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.assistedchat.model.c recommendContent;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean resume;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean firstResume;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isExp;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/topic/bottomsectionbar/RecommendTopicProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.RecommendTopicProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60150);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RecommendTopicProcessor() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.RecommendTopicProcessor$isExp$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendTopicProcessor.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    boolean isExperiment = ((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isExperiment(RecommendTopicProcessor.this.d().g().r().c().e());
                    QLog.i("RecommendTopicProcessor", 1, "initialize Experiment: " + isExperiment);
                    return Boolean.valueOf(isExperiment);
                }
            });
            this.isExp = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.RecommendTopicProcessor$isLittleAssistant$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendTopicProcessor.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return Boolean.valueOf(((IStrangerAssistantAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAssistantAdapterApi.class)).isLittleAssistant(RecommendTopicProcessor.this.d().g().r().c()));
                }
            });
            this.isLittleAssistant = lazy2;
            this.isInputEmpty = true;
            this.firstResume = true;
            lazy3 = LazyKt__LazyJVMKt.lazy(RecommendTopicProcessor$uiHandler$2.INSTANCE);
            this.uiHandler = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void A() {
        this.currentShowModel = null;
        this.recommendContent = null;
        p(new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(f(), new ArrayList()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.aio.bottombar.sectionbar.model.b B() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new com.tencent.qqnt.aio.bottombar.sectionbar.model.a(6, "", "", this.recommendContent));
        return new com.tencent.qqnt.aio.bottombar.sectionbar.model.b(6, arrayListOf);
    }

    private final void C() {
        F();
        Runnable runnable = this.requestTopicRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final Handler D() {
        return (Handler) this.uiHandler.getValue();
    }

    private final void E() {
        if (this.isSwitchOn == null) {
            Boolean valueOf = Boolean.valueOf(((IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class)).isSwitchOn(new AssistedChatSwitch(AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND, d().g().r().c().e())));
            this.isSwitchOn = valueOf;
            QLog.i("RecommendTopicProcessor", 1, "initSwitch isSwitchOn:" + valueOf);
        }
    }

    private final void F() {
        if (this.requestTopicRunnable == null) {
            this.requestTopicRunnable = new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.e
                @Override // java.lang.Runnable
                public final void run() {
                    RecommendTopicProcessor.G(RecommendTopicProcessor.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(RecommendTopicProcessor this$0) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.j()) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(this$0.g(), Dispatchers.getIO(), null, new RecommendTopicProcessor$initTaskRunnable$1$1(this$0, null), 2, null);
            this$0.reqJob = launch$default;
        }
    }

    private final boolean H() {
        return ((Boolean) this.isExp.getValue()).booleanValue();
    }

    private final boolean I() {
        return ((Boolean) this.isLittleAssistant.getValue()).booleanValue();
    }

    private final void J() {
        final String a16;
        com.tencent.qqnt.aio.assistedchat.model.c cVar = this.recommendContent;
        if (cVar != null && (a16 = cVar.a()) != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.d
                @Override // java.lang.Runnable
                public final void run() {
                    RecommendTopicProcessor.K(RecommendTopicProcessor.this, a16);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(RecommendTopicProcessor this$0, String text) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(text, "$text");
        AIOContact c16 = this$0.d().g().r().c();
        ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).syncSendText(c16.j(), c16.e(), text);
    }

    private final void L(InputEditTextMsgIntent.EditTextChangedMsgIntent intent) {
        boolean z16;
        if (intent.c().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isInputEmpty = z16;
    }

    private final void M(KeyboardMsgIntent.OnKeyboardStateChanged intent) {
        if (this.isShowKeyboard == intent.b()) {
            return;
        }
        boolean b16 = intent.b();
        this.isShowKeyboard = b16;
        if (b16) {
            z();
        } else {
            T("onKeyboardStateChanged");
        }
    }

    private final void N(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent intent) {
        if (this.isShowPanel == intent.b()) {
            return;
        }
        boolean b16 = intent.b();
        this.isShowPanel = b16;
        if (!b16) {
            T("onPanelStatusChange");
        }
    }

    private final void O() {
        this.resume = false;
        z();
    }

    private final void P() {
        this.resume = true;
        if (this.firstResume) {
            C();
            this.firstResume = false;
        } else {
            T("onResume");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        QLog.i("RecommendTopicProcessor", 1, "onSendMsgNotification.");
        A();
        T("onSendMsgNotification");
    }

    private final void R(AssistedChatMsgIntent.OnSettingSwitchChanged intent) {
        if (intent.b() != AssistedChatSwitchType.AUTO_TOPIC_RECOMMEND) {
            return;
        }
        QLog.i("RecommendTopicProcessor", 1, "onSettingSwitchChanged isSwitchOn:" + this.isSwitchOn + ", newValue:" + intent + ".switchOn");
        if (Intrinsics.areEqual(this.isSwitchOn, Boolean.valueOf(intent.a()))) {
            return;
        }
        this.isSwitchOn = Boolean.valueOf(intent.a());
        if (!intent.a()) {
            z();
            A();
        }
    }

    private final void S(GestureEvent.DispatchTouchEvent event) {
        if (this.currentShowModel == null && j()) {
            z();
            if (event.a().getActionMasked() == 1) {
                T("ACTION_UP");
            }
        }
    }

    private final void T(String from) {
        if (!j() || this.currentShowModel != null) {
            return;
        }
        QLog.i("RecommendTopicProcessor", 1, "postDelayTask from=" + from);
        F();
        Runnable runnable = this.requestTopicRunnable;
        if (runnable != null) {
            Handler D = D();
            D.removeCallbacks(runnable);
            D.postDelayed(runnable, com.tencent.qqnt.aio.assistedchat.config.a.INSTANCE.a().b().a() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object U(Continuation<? super com.tencent.qqnt.aio.assistedchat.panel.subpanel.d> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (AppNetConnInfo.isNetSupport()) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            AIOContact c16 = d().g().r().c();
            com.tencent.qqnt.aio.assistedchat.request.a.c(com.tencent.qqnt.aio.assistedchat.request.a.f349425a, c16.e(), c16.j(), 5, null, 0, null, 1, false, null, null, new Function3<Integer, String, AssistedChatPB$RecommendRsp, Unit>(cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.RecommendTopicProcessor$reqTopicData$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CancellableContinuation<com.tencent.qqnt.aio.assistedchat.panel.subpanel.d> $continuation;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                    this.$continuation = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                    invoke(num.intValue(), str, assistedChatPB$RecommendRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @Nullable String str, @Nullable AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, assistedChatPB$RecommendRsp);
                        return;
                    }
                    QLog.i("RecommendTopicProcessor", 1, "[reqTopicData] response code=" + i3 + " msg=" + str + " rsp=" + assistedChatPB$RecommendRsp);
                    if (i3 == 0 && assistedChatPB$RecommendRsp != null) {
                        int i16 = assistedChatPB$RecommendRsp.rsp_head.ret_code.get();
                        com.tencent.qqnt.aio.assistedchat.panel.subpanel.d b16 = com.tencent.qqnt.aio.assistedchat.protocolbuffer.a.b(assistedChatPB$RecommendRsp, 5, i16 == 0);
                        b16.l(i16);
                        this.$continuation.resume(b16, AnonymousClass1.INSTANCE);
                        return;
                    }
                    this.$continuation.resume(new com.tencent.qqnt.aio.assistedchat.panel.subpanel.d(false, null, null, 6, null), AnonymousClass2.INSTANCE);
                }
            }, 952, null);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return new com.tencent.qqnt.aio.assistedchat.panel.subpanel.d(false, null, null, 6, null);
    }

    private final void z() {
        Job job = this.reqJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            this.reqJob = null;
        }
        Runnable runnable = this.requestTopicRunnable;
        if (runnable != null) {
            D().removeCallbacks(runnable);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.LifeCycleEvent.OnResume");
        hashSet.add("com.tencent.mobileqq.aio.event.LifeCycleEvent.OnPause");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.GestureEvent.DispatchTouchEvent");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnSettingSwitchChanged");
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean h(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof LifeCycleEvent.OnResume) {
            P();
            return false;
        }
        if (intent instanceof LifeCycleEvent.OnPause) {
            O();
            return false;
        }
        if (intent instanceof GestureEvent.DispatchTouchEvent) {
            S((GestureEvent.DispatchTouchEvent) intent);
            return false;
        }
        if (intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            M((KeyboardMsgIntent.OnKeyboardStateChanged) intent);
            return true;
        }
        if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            L((InputEditTextMsgIntent.EditTextChangedMsgIntent) intent);
            return true;
        }
        if (intent instanceof AssistedChatMsgIntent.OnSettingSwitchChanged) {
            R((AssistedChatMsgIntent.OnSettingSwitchChanged) intent);
            return false;
        }
        if (intent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            N((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) intent);
            return false;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void i(@NotNull ol3.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C9465a) {
            J();
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        E();
        if (this.resume && !I() && c() && H() && Intrinsics.areEqual(this.isSwitchOn, Boolean.TRUE) && !this.isShowKeyboard && this.isInputEmpty) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.k();
            z();
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.l();
        if (!H()) {
            return;
        }
        FlowKt.launchIn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerSendMsgNotificationFlow(), new RecommendTopicProcessor$onInitData$1(this, null)), g());
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    @NotNull
    public List<String> m() {
        List<String> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (I()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<String> m3 = super.m();
        if (QLog.isDebugVersion()) {
            QLog.i("RecommendTopicProcessor", 1, "msgIntentList=" + m3);
        }
        return m3;
    }
}
