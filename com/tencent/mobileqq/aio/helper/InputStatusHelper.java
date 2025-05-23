package com.tencent.mobileqq.aio.helper;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.input.draft.InputDraftMsgIntent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.inputstatus.api.IInputStatusConfigApi;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001L\b\u0007\u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0002WXB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0016\u0010\u0018\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010.\u001a\u00020\u000bH\u0016J\b\u0010/\u001a\u00020\rH\u0016J\b\u00101\u001a\u000200H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0016J\u0010\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000bH\u0016J\u000e\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u001bJ\b\u00109\u001a\u00020\u0005H\u0016R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010?R\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010(R\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010HR\u0016\u0010J\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010?R\u0016\u0010K\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010?R\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010PR\u0014\u0010!\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010S\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/InputStatusHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "u", "w", "", "text", "v", "", "eventType", "", "toUid", "G", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, DomainData.DOMAIN_NAME, "", ViewStickEventHelper.IS_SHOW, "finalStatusText", "M", "D", "Liv3/a;", "inputStateShowSwitchListener", "r", ReportConstant.COSTREPORT_PREFIX, "o", BdhLogUtil.LogTag.Tag_Conn, "p", "sendTextMsg", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "sendVoiceMsg", "K", "t", "L", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "isOn", "E", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "e", "Z", "mIsShowingInputStatus", "f", "mHasSentTextMessage", tl.h.F, "mHasSentVoiceMessage", "", "i", "mTimeStamp", "Ljava/lang/String;", "sendVoiceToUid", "mMyOnlineStatus", "mInputStatusSwitch", "com/tencent/mobileqq/aio/helper/InputStatusHelper$c", "Lcom/tencent/mobileqq/aio/helper/InputStatusHelper$c;", "action", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mSpeakTask", "Lcom/tencent/mobileqq/aio/helper/InputStatusHelper$b;", "Lcom/tencent/mobileqq/aio/helper/InputStatusHelper$b;", "<init>", "()V", "H", "a", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class InputStatusHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mMyOnlineStatus;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mInputStatusSwitch;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c action;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Runnable mSpeakTask;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b inputStateShowSwitchListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowingInputStatus;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mHasSentTextMessage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mHasSentVoiceMessage;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mTimeStamp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String sendVoiceToUid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/InputStatusHelper$a;", "", "", "PTT_INPUT_STATUS_SWITCH", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.InputStatusHelper$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/InputStatusHelper$b;", "Liv3/a;", "", "isOn", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/helper/InputStatusHelper;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "getWeak", "()Ljava/lang/ref/WeakReference;", "weak", "self", "<init>", "(Lcom/tencent/mobileqq/aio/helper/InputStatusHelper;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements iv3.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<InputStatusHelper> weak;

        public b(@NotNull InputStatusHelper self) {
            Intrinsics.checkNotNullParameter(self, "self");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) self);
            } else {
                this.weak = new WeakReference<>(self);
            }
        }

        @Override // iv3.a
        public void a(boolean isOn) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, isOn);
                return;
            }
            InputStatusHelper inputStatusHelper = this.weak.get();
            if (inputStatusHelper != null) {
                inputStatusHelper.E(isOn);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/InputStatusHelper$c", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InputStatusHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                InputStatusHelper.this.u(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InputStatusHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sendVoiceToUid = "";
        this.action = new c();
        this.mSpeakTask = new Runnable() { // from class: com.tencent.mobileqq.aio.helper.ac
            @Override // java.lang.Runnable
            public final void run() {
                InputStatusHelper.B(InputStatusHelper.this);
            }
        };
        this.inputStateShowSwitchListener = new b(this);
    }

    private final void A() {
        QLog.d("InputStatusHelper", 1, "listenerMsgSendInputStatus sendMsgCallBack");
        com.tencent.aio.api.runtime.a aVar = null;
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.w(), new InputStatusHelper$listenerMsgSendInputStatus$1(this, null)), zs.b.a(Dispatchers.INSTANCE));
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "aioContext.lifecycleOwner.lifecycle");
        FlowKt.launchIn(flowOn, LifecycleKt.getCoroutineScope(lifecycle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(InputStatusHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G(com.tencent.mobileqq.aio.utils.inputstatus.a.INSTANCE.c(), this$0.getSendVoiceToUid());
    }

    private final void C() {
        r(this.inputStateShowSwitchListener);
        this.mMyOnlineStatus = s();
        F();
        this.mIsShowingInputStatus = false;
        y();
        A();
        z();
    }

    private final void D() {
        int a16 = com.tencent.mobileqq.aio.utils.inputstatus.a.INSTANCE.a();
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        G(a16, aVar.g().r().c().j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        QLog.d("InputStatusHelper", 1, "resetReportInputStatus");
        K(false);
        J(false);
    }

    private final void G(int eventType, String toUid) {
        if (o()) {
            QLog.d("InputStatusHelper", 1, "sendInputStatusReq eventType:" + eventType + ", toUid:" + toUid);
            ((IMsgService) QRoute.api(IMsgService.class)).sendInputStatusReq(1, eventType, toUid, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.helper.ab
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    InputStatusHelper.H(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(int i3, String str) {
        QLog.d("InputStatusHelper", 1, "sendInputStatusReq resultCode=" + i3 + " errorMsg=" + str);
    }

    private final void I(String toUid) {
        QLog.d("InputStatusHelper", 1, "sendVoiceInputStatus");
        if (!q() && o()) {
            QLog.d("InputStatusHelper", 1, "sendVoiceInputStatus getAllowReportInputStatus is true");
            K(true);
            L(toUid);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.mSpeakTask, com.tencent.mobileqq.aio.utils.inputstatus.a.INSTANCE.d());
        }
    }

    private final void J(boolean sendTextMsg) {
        this.mHasSentTextMessage = sendTextMsg;
    }

    private final void K(boolean sendVoiceMsg) {
        this.mHasSentVoiceMessage = sendVoiceMsg;
    }

    private final void L(String toUid) {
        this.sendVoiceToUid = toUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(boolean isShow, String finalStatusText) {
        this.mIsShowingInputStatus = isShow;
        com.tencent.aio.api.runtime.a aVar = null;
        if (isShow) {
            com.tencent.mobileqq.aio.title.ai aiVar = new com.tencent.mobileqq.aio.title.ai(null, null, null, finalStatusText, "4");
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar2;
            }
            aVar.e().h(new AIOTitleEvent.SubTitleResponseEvent(aiVar));
        } else {
            com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            } else {
                aVar = aVar3;
            }
            aVar.e().h(new AIOTitleEvent.SubTitleRequestEvent(0));
        }
        QLog.d("InputStatusHelper", 1, "showInputStatus, isShow:" + isShow + ", subTitleData:" + Unit.INSTANCE);
    }

    private final void m(int eventType, String toUid) {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mSpeakTask);
        G(eventType, toUid);
    }

    private final void n() {
        this.mIsShowingInputStatus = false;
        M(false, "");
    }

    private final boolean o() {
        if (this.mInputStatusSwitch && this.mMyOnlineStatus) {
            return true;
        }
        return false;
    }

    /* renamed from: p, reason: from getter */
    private final boolean getMHasSentTextMessage() {
        return this.mHasSentTextMessage;
    }

    private final boolean q() {
        boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_ptt_input_status_9065_124314053", false);
        if (!this.mHasSentVoiceMessage || !isSwitchOn) {
            return false;
        }
        return true;
    }

    private final void r(iv3.a inputStateShowSwitchListener) {
        ((IInputStatusConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IInputStatusConfigApi.class)).getInputStatusSwitch(inputStateShowSwitchListener);
    }

    private final boolean s() {
        return !((IInputStatusConfigApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IInputStatusConfigApi.class)).getMyOnlineStatus();
    }

    /* renamed from: t, reason: from getter */
    private final String getSendVoiceToUid() {
        return this.sendVoiceToUid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(MsgIntent intent) {
        if (intent instanceof InputEvent.ClearInputStatusEvent) {
            InputEvent.ClearInputStatusEvent clearInputStatusEvent = (InputEvent.ClearInputStatusEvent) intent;
            m(clearInputStatusEvent.a(), clearInputStatusEvent.b());
        } else if (intent instanceof InputEvent.SendVoiceInputStatusEvent) {
            I(((InputEvent.SendVoiceInputStatusEvent) intent).a());
        } else if (intent instanceof InputDraftMsgIntent.RecoverDraftCompletedMsgIntent) {
            w();
        } else if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            v(((InputEditTextMsgIntent.EditTextChangedMsgIntent) intent).c());
        }
    }

    private final void v(CharSequence text) {
        com.tencent.aio.api.runtime.a aVar = null;
        if (!TextUtils.isEmpty(text)) {
            if (!getMHasSentTextMessage()) {
                J(true);
                int b16 = com.tencent.mobileqq.aio.utils.inputstatus.a.INSTANCE.b();
                com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                } else {
                    aVar = aVar2;
                }
                G(b16, aVar.g().r().c().j());
                return;
            }
            return;
        }
        int a16 = com.tencent.mobileqq.aio.utils.inputstatus.a.INSTANCE.a();
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar3;
        }
        m(a16, aVar.g().r().c().j());
    }

    private final void w() {
        Pair pair = new Pair(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.EditTextChangedMsgIntent.class)), this.action);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(List<MsgRecord> msgList) {
        Object last;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        ArrayList arrayList = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        String j3 = aVar.g().r().c().j();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : msgList) {
            if (TextUtils.equals(((MsgRecord) obj).peerUid, j3)) {
                arrayList2.add(obj);
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList);
            long j16 = ((MsgRecord) last).msgTime;
            QLog.d("InputStatusHelper", 1, "handlerRecMsg " + arrayList.size() + ", msgTime: " + j16 + ", mTimeStamp: " + this.mTimeStamp);
            if (j16 >= this.mTimeStamp && this.mIsShowingInputStatus) {
                QLog.d("InputStatusHelper", 1, "handlerRecMsg, clearInputStatusAfterMessageArrived");
                n();
            }
        }
    }

    private final void y() {
        QLog.d("InputStatusHelper", 1, "listenerInputStatus");
        com.tencent.aio.api.runtime.a aVar = null;
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).getOnInputStatusPush(), new InputStatusHelper$listenerInputStatus$1(this, null)), Dispatchers.getIO());
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "aioContext.lifecycleOwner.lifecycle");
        FlowKt.launchIn(flowOn, LifecycleKt.getCoroutineScope(lifecycle));
    }

    private final void z() {
        QLog.d("InputStatusHelper", 1, "listenerMsgRecInputStatus receiveMsgCallBack");
        com.tencent.aio.api.runtime.a aVar = null;
        Flow flowOn = FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.p(), new InputStatusHelper$listenerMsgRecInputStatus$1(this, null)), zs.b.a(Dispatchers.INSTANCE));
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "aioContext.lifecycleOwner.lifecycle");
        FlowKt.launchIn(flowOn, LifecycleKt.getCoroutineScope(lifecycle));
    }

    public final void E(boolean isOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isOn);
            return;
        }
        this.mInputStatusSwitch = isOn;
        QLog.d("InputStatusHelper", 1, "onInjectSwitch, getInputStatusSwitch(): " + isOn);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 30;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.ClearInputStatusEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.InputEvent.SendVoiceInputStatusEvent");
        hashSet.add("com.tencent.mobileqq.aio.input.draft.InputDraftMsgIntent.RecoverDraftCompletedMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
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
        return "InputStatusHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        a16.e().f(this, this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        D();
        h.a.b(this);
        F();
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().i(this, this.action);
        Pair pair = new Pair(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(InputEditTextMsgIntent.EditTextChangedMsgIntent.class)), this.action);
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        aVar2.e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        this.mHasSentTextMessage = false;
        this.mHasSentVoiceMessage = false;
        this.sendVoiceToUid = "";
        this.mMyOnlineStatus = false;
        this.mInputStatusSwitch = false;
        this.mIsShowingInputStatus = false;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
        } else if (state == 4) {
            C();
        }
    }
}
