package com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor;

import android.os.Handler;
import android.text.Spanned;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.helper.c;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
import com.tencent.qqnt.aio.assistedchat.polish.WriteWhilePolishingFrequencyHelper;
import com.tencent.qqnt.aio.assistedchat.polish.mvi.WriteWhilePolishingUIState;
import com.tencent.qqnt.aio.assistedchat.polish.mvi.a;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$RecommendRsp;
import com.tencent.qqnt.aio.bottombar.sectionbar.model.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u001b\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\"H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\u0007H\u0016R\u001b\u0010-\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010*\u001a\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0018\u00102\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/R\u001b\u00106\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010*\u001a\u0004\b4\u00105R\u001b\u0010:\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010*\u001a\u0004\b8\u00109R\u001b\u0010>\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010*\u001a\u0004\b<\u0010=R\u001f\u0010C\u001a\u00060?j\u0002`@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010*\u001a\u0004\bA\u0010BR\u001f\u0010E\u001a\u00060?j\u0002`@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010*\u001a\u0004\bD\u0010BR\u001b\u0010G\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010*\u001a\u0004\bF\u0010,R\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010IR\u0016\u0010K\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u0018R\u0016\u0010L\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010AR\u0018\u0010N\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010MR\u0018\u0010O\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010MR\u0016\u0010Q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010R\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010M\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006V"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/processor/WriteWhilePolishingProcessor;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$OnSettingSwitchChanged;", "intent", "", "U", "Lcom/tencent/input/base/panelcontainer/keyboard/KeyboardMsgIntent$OnKeyboardStateChanged;", "", "T", "Lcom/tencent/mobileqq/aio/input/edit/InputEditTextMsgIntent$EditTextChangedMsgIntent;", ExifInterface.LATITUDE_SOUTH, "D", "N", "G", "", "inputContent", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "W", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "inputString", "X", "needSetTextToEditText", BdhLogUtil.LogTag.Tag_Req, "V", "Z", "E", "Y", UserInfo.SEX_FEMALE, "", "newState", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "H", "f", "e", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lol3/b;", "i", "Lcom/tencent/mvi/base/route/MsgIntent;", h.F, "j", "Lkotlin/Lazy;", "O", "()Z", "isExp", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Boolean;", "isSwitchOn", "hasOpenSwitchGuideShow", "needShowOpenSwitchGuide", "Landroid/os/Handler;", "M", "()Landroid/os/Handler;", "uiHandler", "Lcom/tencent/qqnt/aio/assistedchat/config/b;", "K", "()Lcom/tencent/qqnt/aio/assistedchat/config/b;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/aio/assistedchat/polish/WriteWhilePolishingFrequencyHelper;", "L", "()Lcom/tencent/qqnt/aio/assistedchat/polish/WriteWhilePolishingFrequencyHelper;", "frequencyHelper", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "I", "()Ljava/lang/Runnable;", "automaticPolishRunnable", "J", "cancelFailStateRunnable", "P", "isLittleAssistant", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/Job;", "polishRequestJob", "isKeyboardShow", "curState", "Ljava/lang/String;", "currentPolishContent", "trace", "lastInputContent", "shouldIgnoreChange", "failedMessage", "<init>", "()V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class WriteWhilePolishingProcessor extends BottomSectionBarBaseProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Boolean isSwitchOn;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasOpenSwitchGuideShow;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Boolean needShowOpenSwitchGuide;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy config;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy frequencyHelper;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy automaticPolishRunnable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy cancelFailStateRunnable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy isLittleAssistant;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Job polishRequestJob;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isKeyboardShow;

    /* renamed from: N, reason: from kotlin metadata */
    private int curState;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private String currentPolishContent;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String trace;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private String lastInputContent;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean shouldIgnoreChange;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String failedMessage;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isExp;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/bottomsectionbar/processor/WriteWhilePolishingProcessor$a;", "", "", "POLISH_STATE_FAILED", "I", "POLISH_STATE_GUIDE_TO_OPEN", "POLISH_STATE_PROCESSING", "POLISH_STATE_REACHED_LIMIT", "POLISH_STATE_SUCCESS", "POLISH_STATE_UNKNOWN", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59976);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WriteWhilePolishingProcessor() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$isExp$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingProcessor.this);
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
                    boolean isExperiment = ((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isExperiment(WriteWhilePolishingProcessor.this.d().g().r().c().e());
                    QLog.i("WriteWhilePolishingProcessor", 1, "initialize Experiment: " + isExperiment);
                    return Boolean.valueOf(isExperiment);
                }
            });
            this.isExp = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(WriteWhilePolishingProcessor$uiHandler$2.INSTANCE);
            this.uiHandler = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(WriteWhilePolishingProcessor$config$2.INSTANCE);
            this.config = lazy3;
            lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<WriteWhilePolishingFrequencyHelper>() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$frequencyHelper$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingProcessor.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final WriteWhilePolishingFrequencyHelper invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new WriteWhilePolishingFrequencyHelper(WriteWhilePolishingProcessor.this.d().g().r().c().e()) : (WriteWhilePolishingFrequencyHelper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.frequencyHelper = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<Runnable>() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$automaticPolishRunnable$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingProcessor.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Runnable invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Runnable) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    final WriteWhilePolishingProcessor writeWhilePolishingProcessor = WriteWhilePolishingProcessor.this;
                    return new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$automaticPolishRunnable$2$invoke$$inlined$Runnable$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingProcessor.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                WriteWhilePolishingProcessor.this.G();
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    };
                }
            });
            this.automaticPolishRunnable = lazy5;
            lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<Runnable>() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$cancelFailStateRunnable$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingProcessor.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Runnable invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Runnable) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    final WriteWhilePolishingProcessor writeWhilePolishingProcessor = WriteWhilePolishingProcessor.this;
                    return new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$cancelFailStateRunnable$2$invoke$$inlined$Runnable$1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingProcessor.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            int i3;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                i3 = WriteWhilePolishingProcessor.this.curState;
                                if (i3 == 3) {
                                    WriteWhilePolishingProcessor.this.Q(0);
                                    return;
                                }
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    };
                }
            });
            this.cancelFailStateRunnable = lazy6;
            lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$isLittleAssistant$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingProcessor.this);
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
                    return Boolean.valueOf(((IStrangerAssistantAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IStrangerAssistantAdapterApi.class)).isLittleAssistant(WriteWhilePolishingProcessor.this.d().g().r().c()));
                }
            });
            this.isLittleAssistant = lazy7;
            this.failedMessage = "";
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void D() {
        Q(1);
        E();
        M().postDelayed(I(), 500L);
    }

    private final void E() {
        F();
        M().removeCallbacks(I());
    }

    private final void F() {
        Job job = this.polishRequestJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            this.polishRequestJob = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        Job launch$default;
        if (QLog.isDevelopLevel()) {
            QLog.i("WriteWhilePolishingProcessor", 1, "try automatic polish.");
        }
        F();
        String str = this.lastInputContent;
        if (str == null) {
            str = "";
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(g(), Dispatchers.getIO(), null, new WriteWhilePolishingProcessor$doAutomaticPolish$1(this, str, null), 2, null);
        this.polishRequestJob = launch$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H() {
        String str;
        String str2;
        boolean z16;
        ArrayList arrayListOf;
        int i3 = this.curState;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            str = "";
                            str2 = str;
                        } else {
                            str = "\u4f7f\u7528\u9ad8\u60c5\u5546\u56de\u590d\uff0c\u804a\u5929\u66f4\u6709\u8da3";
                            str2 = "\u53bb\u770b\u770b";
                        }
                    } else {
                        str = "\u5f00\u542f\u804a\u5929\u6da6\u8272\uff0c\u804a\u5929\u66f4\u6709\u8da3";
                        str2 = "\u5f00\u542f";
                    }
                } else {
                    str = this.failedMessage;
                }
            } else {
                str = this.currentPolishContent;
                if (str == null) {
                    str = "";
                }
                str2 = "\u66f4\u591a";
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("WriteWhilePolishingProcessor", 1, "emitModel curState=" + this.curState + ", content=" + str);
            }
            if (str.length() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                p(new b(7, new ArrayList()));
                return;
            }
            com.tencent.qqnt.aio.bottombar.sectionbar.model.a[] aVarArr = new com.tencent.qqnt.aio.bottombar.sectionbar.model.a[1];
            int i16 = this.curState;
            String str3 = this.trace;
            if (str3 == null) {
                str3 = "";
            }
            aVarArr[0] = new com.tencent.qqnt.aio.bottombar.sectionbar.model.a(7, "", "", new a(i16, str, str2, str3));
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aVarArr);
            p(new b(7, arrayListOf));
            return;
        }
        str = "\u6da6\u8272\u4e2d";
        str2 = "";
        if (QLog.isDevelopLevel()) {
        }
        if (str.length() != 0) {
        }
        if (!z16) {
        }
    }

    private final Runnable I() {
        return (Runnable) this.automaticPolishRunnable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable J() {
        return (Runnable) this.cancelFailStateRunnable.getValue();
    }

    private final com.tencent.qqnt.aio.assistedchat.config.b K() {
        return (com.tencent.qqnt.aio.assistedchat.config.b) this.config.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WriteWhilePolishingFrequencyHelper L() {
        return (WriteWhilePolishingFrequencyHelper) this.frequencyHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler M() {
        return (Handler) this.uiHandler.getValue();
    }

    private final void N() {
        Boolean bool = this.isSwitchOn;
        if (bool == null) {
            bool = Boolean.valueOf(((IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class)).isSwitchOn(new AssistedChatSwitch(AssistedChatSwitchType.AUTO_POLISH, d().g().r().c().e())));
        }
        this.isSwitchOn = bool;
    }

    private final boolean O() {
        return ((Boolean) this.isExp.getValue()).booleanValue();
    }

    private final boolean P() {
        return ((Boolean) this.isLittleAssistant.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int newState) {
        if (this.curState == newState) {
            return;
        }
        this.curState = newState;
        if (newState != 2) {
            this.currentPolishContent = null;
            this.trace = null;
        }
        if (newState != 1) {
            Y();
        }
        if (this.curState == 0) {
            M().removeCallbacks(J());
            E();
            q(WriteWhilePolishingUIState.ClearLastShowInfo.f349400d);
        }
        H();
    }

    private final void R(boolean needSetTextToEditText) {
        this.shouldIgnoreChange = true;
        if (needSetTextToEditText) {
            String str = this.currentPolishContent;
            if (str == null) {
                return;
            } else {
                d().e().h(new InputEditTextMsgIntent.SetTextToEditText(str, false));
            }
        }
        Q(0);
    }

    private final void S(InputEditTextMsgIntent.EditTextChangedMsgIntent intent) {
        if (QLog.isDevelopLevel()) {
            String str = this.lastInputContent;
            Spanned c16 = intent.c();
            QLog.i("WriteWhilePolishingProcessor", 1, "onEditTextChanged, lastInputContent=" + str + ", cur=" + ((Object) c16) + ", isSwitchOn=" + this.isSwitchOn + ", shouldIgnoreChange=" + this.shouldIgnoreChange);
        }
        if (!c()) {
            Q(0);
            return;
        }
        if (this.shouldIgnoreChange) {
            this.shouldIgnoreChange = false;
            return;
        }
        if (Intrinsics.areEqual(this.lastInputContent, intent.c().toString())) {
            return;
        }
        String obj = intent.c().toString();
        this.lastInputContent = obj;
        N();
        if (Intrinsics.areEqual(this.isSwitchOn, Boolean.TRUE)) {
            if (!c.f349087a.a(obj, K().f())) {
                Q(0);
                return;
            } else {
                Z();
                return;
            }
        }
        X(obj);
    }

    private final boolean T(KeyboardMsgIntent.OnKeyboardStateChanged intent) {
        boolean b16 = intent.b();
        this.isKeyboardShow = b16;
        if (b16 || this.curState != 1) {
            return true;
        }
        Q(0);
        return false;
    }

    private final void U(AssistedChatMsgIntent.OnSettingSwitchChanged intent) {
        if (intent.b() != AssistedChatSwitchType.AUTO_POLISH || Intrinsics.areEqual(this.isSwitchOn, Boolean.valueOf(intent.a()))) {
            return;
        }
        Boolean valueOf = Boolean.valueOf(intent.a());
        this.isSwitchOn = valueOf;
        QLog.i("WriteWhilePolishingProcessor", 1, "onSettingSwitchChanged, newSwitch=" + valueOf);
        Boolean bool = this.isSwitchOn;
        Boolean bool2 = Boolean.FALSE;
        if (Intrinsics.areEqual(bool, bool2)) {
            Q(0);
            L().k(K());
            this.needShowOpenSwitchGuide = bool2;
        }
    }

    private final void V() {
        List listOf;
        IAssistedChatSwitchAdapterApi iAssistedChatSwitchAdapterApi = (IAssistedChatSwitchAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatSwitchAdapterApi.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new AssistedChatSwitch(AssistedChatSwitchType.AUTO_POLISH, d().g().r().c().e()));
        IAssistedChatSwitchAdapterApi.a.a(iAssistedChatSwitchAdapterApi, listOf, 1, null, 4, null);
        this.isSwitchOn = Boolean.TRUE;
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object W(String str, Continuation<? super d> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        if (AppNetConnInfo.isNetSupport()) {
            intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
            cancellableContinuationImpl.initCancellability();
            AIOContact c16 = d().g().r().c();
            com.tencent.qqnt.aio.assistedchat.request.a aVar = com.tencent.qqnt.aio.assistedchat.request.a.f349425a;
            int e16 = c16.e();
            String j3 = c16.j();
            final int i3 = 7;
            com.tencent.qqnt.aio.assistedchat.request.a.c(aVar, e16, j3, 7, str, 0, null, 1, false, null, null, new Function3<Integer, String, AssistedChatPB$RecommendRsp, Unit>(i3, cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.polish.bottomsectionbar.processor.WriteWhilePolishingProcessor$reqPolishingData$2$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CancellableContinuation<d> $continuation;
                final /* synthetic */ int $scene;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                    this.$scene = i3;
                    this.$continuation = cancellableContinuationImpl;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) cancellableContinuationImpl);
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2, AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                    invoke(num.intValue(), str2, assistedChatPB$RecommendRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i16, @Nullable String str2, @Nullable AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i16), str2, assistedChatPB$RecommendRsp);
                        return;
                    }
                    QLog.i("WriteWhilePolishingProcessor", 1, "[reqPolishingData] response code=" + i16 + " msg=" + str2 + " rsp=" + assistedChatPB$RecommendRsp);
                    if (i16 == 0 && assistedChatPB$RecommendRsp != null) {
                        int i17 = assistedChatPB$RecommendRsp.rsp_head.ret_code.get();
                        d b16 = com.tencent.qqnt.aio.assistedchat.protocolbuffer.a.b(assistedChatPB$RecommendRsp, this.$scene, i17 == 0);
                        b16.l(i17);
                        this.$continuation.resume(b16, AnonymousClass1.INSTANCE);
                        return;
                    }
                    this.$continuation.resume(new d(false, null, null, 6, null), AnonymousClass2.INSTANCE);
                }
            }, 944, null);
            Object result = cancellableContinuationImpl.getResult();
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (result == coroutine_suspended) {
                DebugProbes.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return new d(false, null, null, 6, null);
    }

    private final void X(String inputString) {
        Boolean bool = this.needShowOpenSwitchGuide;
        if (bool == null) {
            bool = Boolean.valueOf(L().j(K()));
        }
        this.needShowOpenSwitchGuide = bool;
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("WriteWhilePolishingProcessor", 1, "needn't ShowGuide.");
            }
        } else if (!c.f349087a.a(inputString, K().f())) {
            Q(0);
        } else {
            Q(4);
        }
    }

    private final void Y() {
        q(WriteWhilePolishingUIState.StopLoadingAnimation.f349401d);
    }

    private final void Z() {
        if (L().m(K())) {
            D();
            return;
        }
        Q(0);
        j e16 = d().e();
        if (e16 != null) {
            e16.h(AssistedChatMsgIntent.OnAutoPolishTriggerUpperLimit.f348983d);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 8;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent.OnKeyboardStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnPanelRecommendItemClick");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnSettingSwitchChanged");
        hashSet.add("com.tencent.mobileqq.aio.event.LifeCycleEvent.OnPause");
        return hashSet;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
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
        if (!O()) {
            return false;
        }
        if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            S((InputEditTextMsgIntent.EditTextChangedMsgIntent) intent);
        } else {
            if (intent instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
                return T((KeyboardMsgIntent.OnKeyboardStateChanged) intent);
            }
            if (intent instanceof AssistedChatMsgIntent.OnPanelRecommendItemClick) {
                R(false);
            } else if (intent instanceof AssistedChatMsgIntent.OnSettingSwitchChanged) {
                U((AssistedChatMsgIntent.OnSettingSwitchChanged) intent);
            } else if ((intent instanceof LifeCycleEvent.OnPause) && this.curState == 1) {
                Q(0);
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void i(@NotNull ol3.b intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            this.hasOpenSwitchGuideShow = true;
        } else if (intent instanceof a.c) {
            V();
        } else if (intent instanceof a.C9460a) {
            R(true);
        }
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (!P() && O() && this.isKeyboardShow && this.curState != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.k();
        if (this.hasOpenSwitchGuideShow) {
            L().i();
        }
        q(WriteWhilePolishingUIState.ClearLastShowInfo.f349400d);
        M().removeCallbacks(J());
        Y();
        E();
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor
    @NotNull
    public List<String> m() {
        List<String> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (P()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        List<String> m3 = super.m();
        if (QLog.isDebugVersion()) {
            QLog.i("WriteWhilePolishingProcessor", 1, "msgIntentList=" + m3);
        }
        return m3;
    }
}
