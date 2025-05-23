package com.tencent.mobileqq.aio.input.draft;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.input.base.mvicompat.e;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.adorn.c;
import com.tencent.mobileqq.aio.input.d;
import com.tencent.mobileqq.aio.input.draft.InputDraftMsgIntent;
import com.tencent.mobileqq.aio.input.draft.InputDraftUIState;
import com.tencent.mobileqq.aio.input.draft.a;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.reply.InputReplyMsgIntent;
import com.tencent.mobileqq.aio.input.reply.a;
import com.tencent.mobileqq.aio.utils.o;
import com.tencent.mobileqq.aio.utils.x;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.InputChangeEvent;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001F\b\u0007\u0018\u0000 P2\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\u0002`\u00062\u00020\u00072\b\u0012\u0004\u0012\u00020\t0\b2\u00020\n:\u0001QB\u000f\u0012\u0006\u0010;\u001a\u00020\u0005\u00a2\u0006\u0004\bO\u0010:J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0016\u0010\u0014\u001a\u00020\u000e2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002JW\u0010\u001e\u001a\u00020\u000e2:\u0010\u001b\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u00160\u0015j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0016`\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010$\u001a\u00020#H\u0002J\u0018\u0010(\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\fH\u0016J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\b\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u0002H\u0016J\u000e\u00100\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020/J\b\u00101\u001a\u00020\u000eH\u0007J\u0010\u00103\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\tH\u0016J$\u00104\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0)0\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0)`\u001aH\u0016R\"\u0010;\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010GR\u0018\u0010L\u001a\u00060Ij\u0002`J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010KR\u0018\u0010N\u001a\u00060Ij\u0002`J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010K\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/aio/input/draft/InputDraftVMDelegate;", "Lcom/tencent/input/base/mvicompat/e;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mvi/base/route/g;", "aioContext", "", DomainData.DOMAIN_NAME, "", "t", "r", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, ReportConstant.COSTREPORT_PREFIX, "Ljava/util/ArrayList;", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/Deferred;", "", "Lkotlin/collections/ArrayList;", "pendingTextInsertions", "Landroid/text/SpannableStringBuilder;", "content", "o", "(Ljava/util/ArrayList;Landroid/text/SpannableStringBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasContent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "uid", "k", "context", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "p", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/aio/input/draft/a;", "d0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", "l", "Lcom/tencent/mvi/base/route/MsgIntent;", "j", DKHippyEvent.EVENT_STOP, "event", "onReceiveEvent", "getEventClass", "d", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "i", "()Lcom/tencent/mobileqq/aio/input/adorn/c;", "u", "(Lcom/tencent/mobileqq/aio/input/adorn/c;)V", "mHost", "e", "Z", "mIsDestroyed", "f", "Lcom/tencent/aio/api/runtime/a;", "mContext", "", h.F, "J", "mSaveDraftDelay", "com/tencent/mobileqq/aio/input/draft/InputDraftVMDelegate$b", "Lcom/tencent/mobileqq/aio/input/draft/InputDraftVMDelegate$b;", "mAction", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "runnableRecoverDraft", BdhLogUtil.LogTag.Tag_Conn, "runnableSaveDraft", "<init>", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class InputDraftVMDelegate implements e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c>, LifecycleObserver, SimpleEventReceiver<SimpleBaseEvent>, g {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnableSaveDraft;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean mIsDestroyed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mSaveDraftDelay;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable runnableRecoverDraft;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/aio/input/draft/InputDraftVMDelegate$a;", "", "", "KEY_SAVE_DRAFT_DELAY", "Ljava/lang/String;", "", "RECOVER_EMOJI_SIZE", "I", "", "SAVE_DRAFT_DEFAULT_DELAY", "J", "SHOW_KEYBOARD_DELAY", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/input/draft/InputDraftVMDelegate$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputDraftVMDelegate.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgIntent);
            } else {
                Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
                InputDraftVMDelegate.this.j(msgIntent);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54571);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InputDraftVMDelegate(@NotNull c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mSaveDraftDelay = Long.MIN_VALUE;
        this.mAction = new b();
        this.runnableRecoverDraft = new Runnable() { // from class: com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate$special$$inlined$Runnable$1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InputDraftVMDelegate.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    InputDraftVMDelegate.this.r();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
        this.runnableSaveDraft = new Runnable() { // from class: com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate$special$$inlined$Runnable$2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InputDraftVMDelegate.this);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    InputDraftVMDelegate.this.t();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        };
    }

    private final void k(CharSequence content, String uid) {
        String str;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        if (g16 == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.i("InputDraftVMDelegate", 1, "handleInputChangeDraft");
        }
        if (TextUtils.isEmpty(content) && !TextUtils.isEmpty(str) && Intrinsics.areEqual(str, uid)) {
            w(new InputDraftUIState.RecoverInputContent(""));
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar3;
            }
            aVar2.e().h(InputReplyMsgIntent.ClearReplyData.f189807d);
        }
    }

    private final void m(boolean hasContent) {
        Bundle bundle;
        Object obj;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        if (g16 != null) {
            bundle = g16.l();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            obj = bundle.get("key_from");
        } else {
            obj = null;
        }
        boolean areEqual = Intrinsics.areEqual(obj, "13");
        if (QLog.isColorLevel()) {
            QLog.i("InputDraftVMDelegate", 1, "invokeKeyboardIfNeeded isFromChatRecord = " + areEqual + ", hasContent = " + hasContent);
        }
        if (hasContent && !areEqual) {
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar3;
            }
            aVar2.e().h(new InputEditTextMsgIntent.ShowKeyboardMsgIntent(200L));
        }
    }

    private final boolean n(com.tencent.aio.api.runtime.a aioContext) {
        if (aioContext.g().r().c().e() == 2) {
            ITroopApi iTroopApi = (ITroopApi) QRoute.api(ITroopApi.class);
            AIOParam g16 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
            if (iTroopApi.isExitTroop(su3.c.b(g16))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(7:10|11|12|13|14|15|(2:17|(1:19)(5:21|13|14|15|(5:22|(1:24)|25|26|27)(0)))(0))(2:29|30))(4:31|32|15|(0)(0))))|34|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a9, code lost:
    
        com.tencent.qphone.base.util.QLog.e("InputDraftVMDelegate", 1, "recover draft task is cancelled");
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a A[Catch: CancellationException -> 0x00a9, TryCatch #0 {CancellationException -> 0x00a9, blocks: (B:11:0x0036, B:14:0x0087, B:15:0x0054, B:17:0x005a, B:22:0x0096, B:25:0x00a5, B:32:0x004d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096 A[Catch: CancellationException -> 0x00a9, TryCatch #0 {CancellationException -> 0x00a9, blocks: (B:11:0x0036, B:14:0x0087, B:15:0x0054, B:17:0x005a, B:22:0x0096, B:25:0x00a5, B:32:0x004d), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0083 -> B:13:0x003c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(ArrayList<Pair<Integer, Deferred<CharSequence>>> arrayList, SpannableStringBuilder spannableStringBuilder, Continuation<? super Unit> continuation) {
        InputDraftVMDelegate$mergeOpAndUpdateUI$1 inputDraftVMDelegate$mergeOpAndUpdateUI$1;
        Object coroutine_suspended;
        int i3;
        InputDraftVMDelegate inputDraftVMDelegate;
        Iterator<Pair<Integer, Deferred<CharSequence>>> it;
        int i16;
        if (continuation instanceof InputDraftVMDelegate$mergeOpAndUpdateUI$1) {
            inputDraftVMDelegate$mergeOpAndUpdateUI$1 = (InputDraftVMDelegate$mergeOpAndUpdateUI$1) continuation;
            int i17 = inputDraftVMDelegate$mergeOpAndUpdateUI$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                inputDraftVMDelegate$mergeOpAndUpdateUI$1.label = i17 - Integer.MIN_VALUE;
                Object obj = inputDraftVMDelegate$mergeOpAndUpdateUI$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = inputDraftVMDelegate$mergeOpAndUpdateUI$1.label;
                boolean z16 = false;
                if (i3 == 0) {
                    if (i3 == 1) {
                        int i18 = inputDraftVMDelegate$mergeOpAndUpdateUI$1.I$1;
                        int i19 = inputDraftVMDelegate$mergeOpAndUpdateUI$1.I$0;
                        it = (Iterator) inputDraftVMDelegate$mergeOpAndUpdateUI$1.L$2;
                        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) inputDraftVMDelegate$mergeOpAndUpdateUI$1.L$1;
                        inputDraftVMDelegate = (InputDraftVMDelegate) inputDraftVMDelegate$mergeOpAndUpdateUI$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        Object obj2 = obj;
                        int i26 = i19;
                        spannableStringBuilder = spannableStringBuilder2;
                        Iterator<Pair<Integer, Deferred<CharSequence>>> it5 = it;
                        Object obj3 = coroutine_suspended;
                        InputDraftVMDelegate$mergeOpAndUpdateUI$1 inputDraftVMDelegate$mergeOpAndUpdateUI$12 = inputDraftVMDelegate$mergeOpAndUpdateUI$1;
                        CharSequence charSequence = (CharSequence) obj2;
                        spannableStringBuilder.insert(i18 + i26, charSequence);
                        i16 = charSequence.length() + i26;
                        inputDraftVMDelegate$mergeOpAndUpdateUI$1 = inputDraftVMDelegate$mergeOpAndUpdateUI$12;
                        coroutine_suspended = obj3;
                        it = it5;
                        if (it.hasNext()) {
                            Pair<Integer, Deferred<CharSequence>> next = it.next();
                            int intValue = next.getFirst().intValue();
                            Deferred<CharSequence> second = next.getSecond();
                            inputDraftVMDelegate$mergeOpAndUpdateUI$1.L$0 = inputDraftVMDelegate;
                            inputDraftVMDelegate$mergeOpAndUpdateUI$1.L$1 = spannableStringBuilder;
                            inputDraftVMDelegate$mergeOpAndUpdateUI$1.L$2 = it;
                            inputDraftVMDelegate$mergeOpAndUpdateUI$1.I$0 = i16;
                            inputDraftVMDelegate$mergeOpAndUpdateUI$1.I$1 = intValue;
                            inputDraftVMDelegate$mergeOpAndUpdateUI$1.label = 1;
                            Object await = second.await(inputDraftVMDelegate$mergeOpAndUpdateUI$1);
                            if (await == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj2 = await;
                            i26 = i16;
                            i18 = intValue;
                            Iterator<Pair<Integer, Deferred<CharSequence>>> it52 = it;
                            Object obj32 = coroutine_suspended;
                            InputDraftVMDelegate$mergeOpAndUpdateUI$1 inputDraftVMDelegate$mergeOpAndUpdateUI$122 = inputDraftVMDelegate$mergeOpAndUpdateUI$1;
                            CharSequence charSequence2 = (CharSequence) obj2;
                            spannableStringBuilder.insert(i18 + i26, charSequence2);
                            i16 = charSequence2.length() + i26;
                            inputDraftVMDelegate$mergeOpAndUpdateUI$1 = inputDraftVMDelegate$mergeOpAndUpdateUI$122;
                            coroutine_suspended = obj32;
                            it = it52;
                            if (it.hasNext()) {
                                inputDraftVMDelegate.w(new InputDraftUIState.RecoverInputContent(spannableStringBuilder));
                                if (spannableStringBuilder.length() > 0) {
                                    z16 = true;
                                }
                                inputDraftVMDelegate.m(z16);
                                return Unit.INSTANCE;
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    inputDraftVMDelegate = this;
                    it = arrayList.iterator();
                    i16 = 0;
                    if (it.hasNext()) {
                    }
                }
            }
        }
        inputDraftVMDelegate$mergeOpAndUpdateUI$1 = new InputDraftVMDelegate$mergeOpAndUpdateUI$1(this, continuation);
        Object obj4 = inputDraftVMDelegate$mergeOpAndUpdateUI$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = inputDraftVMDelegate$mergeOpAndUpdateUI$1.label;
        boolean z162 = false;
        if (i3 == 0) {
        }
    }

    private final void q() {
        if (this.mSaveDraftDelay == Long.MIN_VALUE) {
            this.mSaveDraftDelay = NumberUtil.stringToLong(FreesiaWrapperImpl.INSTANCE.b().loadConfigAsString("102238", ""), 200L);
            if (QLog.isColorLevel()) {
                QLog.i("InputDraftVMDelegate", 1, "onEditTextChanged mSaveDraftDelay = " + this.mSaveDraftDelay);
            }
        }
        if (this.mSaveDraftDelay <= 0) {
            if (QLog.isColorLevel()) {
                QLog.i("InputDraftVMDelegate", 1, "onEditTextChanged return, mSaveDraftDelay = " + this.mSaveDraftDelay);
                return;
            }
            return;
        }
        if (this.runnableSaveDraft != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.runnableSaveDraft);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.runnableSaveDraft, this.mSaveDraftDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        x xVar = x.f194179a;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        xVar.k(o.b(aVar.g().r().c()), new Function1<ArrayList<MsgElement>, Unit>() { // from class: com.tencent.mobileqq.aio.input.draft.InputDraftVMDelegate$recoverDraft$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputDraftVMDelegate.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<MsgElement> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull ArrayList<MsgElement> getDrafts) {
                com.tencent.aio.api.runtime.a aVar2;
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) getDrafts);
                    return;
                }
                Intrinsics.checkNotNullParameter(getDrafts, "$this$getDrafts");
                if (!getDrafts.isEmpty()) {
                    z16 = InputDraftVMDelegate.this.mIsDestroyed;
                    if (!z16) {
                        InputDraftVMDelegate.this.s(getDrafts);
                        aVar2 = InputDraftVMDelegate.this.mContext;
                        if (aVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                            aVar2 = null;
                        }
                        aVar2.e().h(InputDraftMsgIntent.RecoverDraftCompletedMsgIntent.f189381d);
                    }
                }
                InputDraftVMDelegate.this.w(new InputDraftUIState.RecoverInputContent(""));
                aVar2 = InputDraftVMDelegate.this.mContext;
                if (aVar2 == null) {
                }
                aVar2.e().h(InputDraftMsgIntent.RecoverDraftCompletedMsgIntent.f189381d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(List<MsgElement> elements) {
        BuildersKt__Builders_commonKt.launch$default(getMHost().vmScope(), Dispatchers.getIO(), null, new InputDraftVMDelegate$recoverMsgElements$1(elements, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        a.C7282a c7282a;
        d dVar;
        d.C7264d c7264d;
        CharSequence a16;
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        k k3 = aVar.e().k(InputReplyMsgIntent.GetReplyData.f189808d);
        if (k3 instanceof a.C7282a) {
            c7282a = (a.C7282a) k3;
        } else {
            c7282a = null;
        }
        if (c7282a != null) {
            dVar = c7282a.a();
        } else {
            dVar = null;
        }
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar3 = null;
        }
        k k16 = aVar3.e().k(new InputEvent.GetInputString());
        if (k16 instanceof d.C7264d) {
            c7264d = (d.C7264d) k16;
        } else {
            c7264d = null;
        }
        if (c7264d != null && (a16 = c7264d.a()) != null) {
            if (!(a16 instanceof Spanned)) {
                QLog.i("InputDraftVMDelegate", 1, "saveDraft | be noticed! editContent isn't spanned");
                a16 = new SpannableStringBuilder(a16);
            }
            x xVar = x.f194179a;
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar4;
            }
            xVar.p(aVar2, (Spanned) a16, a16.toString(), dVar);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            e.a.a(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    @NotNull
    public Class<? extends at.a> d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(InputChangeEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Set) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.draft.InputDraftMsgIntent.RecoverMsgElements");
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Set) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public c getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    public final void j(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof InputDraftMsgIntent.RecoverMsgElements) {
            s(((InputDraftMsgIntent.RecoverMsgElements) intent).a());
        } else if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            q();
        }
    }

    @Override // com.tencent.input.base.mvicompat.e
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void J(@NotNull at.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7262a) {
            com.tencent.aio.api.runtime.a aVar = this.mContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar = null;
            }
            if (aVar.g().l().getBoolean("key_is_ignore_draft")) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.runnableRecoverDraft, 400L);
        }
    }

    @Override // com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar3 = this.mContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.d().getLifecycle().removeObserver(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.runnableRecoverDraft);
        if (this.runnableSaveDraft != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.runnableSaveDraft);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof InputChangeEvent) {
            InputChangeEvent inputChangeEvent = (InputChangeEvent) event;
            k(inputChangeEvent.getContent(), inputChangeEvent.getUid());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            aVar = null;
        }
        if (n(aVar)) {
            com.tencent.aio.api.runtime.a aVar3 = this.mContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
                aVar3 = null;
            }
            AIOParam g16 = aVar3.g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            QLog.i("InputDraftVMDelegate", 1, "is exit troop[" + su3.c.b(g16) + "], trigger deleteDrafts.");
            x xVar = x.f194179a;
            com.tencent.aio.api.runtime.a aVar4 = this.mContext;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                aVar2 = aVar4;
            }
            xVar.h(aVar2);
            return;
        }
        t();
    }

    @Override // com.tencent.input.base.mvicompat.f
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void b(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        com.tencent.aio.api.runtime.a aVar = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        context.e().f(this, this.mAction);
        com.tencent.aio.api.runtime.a aVar2 = this.mContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            aVar = aVar2;
        }
        aVar.d().getLifecycle().addObserver(this);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.mHost = cVar;
        }
    }

    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void w(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) inputUIState);
        } else {
            e.a.b(this, inputUIState);
        }
    }
}
