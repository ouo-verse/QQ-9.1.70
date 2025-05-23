package com.tencent.qqnt.aio.assistedchat.helper;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.GestureEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.g;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.a;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatSwitchAdapterApi;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitch;
import com.tencent.qqnt.aio.assistedchat.model.AssistedChatSwitchType;
import com.tencent.qqnt.aio.assistedchat.model.d;
import com.tencent.qqnt.aio.assistedchat.panel.j;
import com.tencent.qqnt.aio.assistedchat.protocolbuffer.AssistedChatPB$AssistedSwitchRsp;
import com.tencent.qqnt.aio.assistedchat.reply_suggestion.ReplySuggestionFrequencyHelper;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.nativeinterface.AdelieRecommendedMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bb\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0003SVZ\b\u0007\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001nB\u0007\u00a2\u0006\u0004\bl\u0010mJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J!\u0010\u0019\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0013\u0010\u001e\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001cJ\u0013\u0010\u001f\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u001cJ\u000e\u0010\"\u001a\u0004\u0018\u00010!*\u00020 H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\u0018\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\fH\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+H\u0002J\b\u0010.\u001a\u00020'H\u0016J\b\u0010/\u001a\u00020\fH\u0016J\b\u00101\u001a\u000200H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\u0010\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020'H\u0016R\u0018\u0010:\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010KR\u001b\u0010P\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010D\u001a\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010@R\u0014\u0010U\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010\\\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010[R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010^R\u001b\u0010c\u001a\u00020`8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010D\u001a\u0004\ba\u0010bR\u001b\u0010f\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010D\u001a\u0004\bW\u0010eR\u0014\u0010i\u001a\u00020'8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bQ\u0010j\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006o"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "G", "Lcom/tencent/mvi/base/route/k;", "H", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "w", "", "from", "U", "M", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "switchItem", "J", "Landroid/view/MotionEvent;", "motionEvent", "K", "", "Lcom/tencent/qqnt/msg/d;", TabPreloadItem.TAB_NAME_MESSAGE, "N", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HippyTKDListViewAdapter.X, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "u", "B", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/AdelieRecommendedMsgElement;", "D", "Landroid/view/View;", "itemView", "P", "O", "", "iconType", "msg", "T", "Lcom/tencent/qqnt/aio/assistedchat/AssistedChatMsgIntent$ShowAssistedChatPanelIntent;", "msgIntent", "I", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "Lcom/tencent/qqnt/aio/assistedchat/panel/j;", "e", "Lcom/tencent/qqnt/aio/assistedchat/panel/j;", "showPanelParam", "f", "Ljava/lang/Boolean;", "canShowReplySuggestionTail", "Landroid/os/Handler;", h.F, "Lkotlin/Lazy;", UserInfo.SEX_FEMALE, "()Landroid/os/Handler;", "uiHandler", "Lcom/tencent/qqnt/aio/assistedchat/reply_suggestion/ReplySuggestionFrequencyHelper;", "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/qqnt/aio/assistedchat/reply_suggestion/ReplySuggestionFrequencyHelper;", "frequencyHelper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L", "()Z", "isReplySuggestionExp", BdhLogUtil.LogTag.Tag_Conn, "isPeerAIServiceEnable", "com/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$b", "Lcom/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$b;", "action", "com/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$c", "E", "Lcom/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$c;", "actionR", "com/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$d", "Lcom/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$d;", "switchChangedListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "showReplySuggestionTailTask", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatAdapterApi;", "y", "()Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatAdapterApi;", "assistedChatAdapterApi", "Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatSwitchAdapterApi;", "()Lcom/tencent/qqnt/aio/assistedchat/adapter/IAssistedChatSwitchAdapterApi;", "switchAdapterApi", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()I", "chatType", "()Ljava/lang/String;", "peerUid", "<init>", "()V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatAIOHelper implements com.tencent.aio.main.businesshelper.h, g {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Boolean isPeerAIServiceEnable;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final c actionR;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final d switchChangedListener;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Runnable showReplySuggestionTailTask;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy assistedChatAdapterApi;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy switchAdapterApi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.main.businesshelper.b helperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j showPanelParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean canShowReplySuggestionTail;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy frequencyHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy isReplySuggestionExp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.helper.AssistedChatAIOHelper$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatAIOHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AssistedChatAIOHelper.this.G(i3);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "Lcom/tencent/mvi/base/route/k;", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatAIOHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public k call(@NotNull MsgIntent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            }
            Intrinsics.checkNotNullParameter(intent, "intent");
            return AssistedChatAIOHelper.this.H(intent);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/assistedchat/helper/AssistedChatAIOHelper$d", "Lwu3/a;", "Lcom/tencent/qqnt/aio/assistedchat/model/d;", "switchItem", "", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements wu3.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatAIOHelper.this);
            }
        }

        @Override // wu3.a
        public void a(@NotNull com.tencent.qqnt.aio.assistedchat.model.d switchItem) {
            com.tencent.aio.api.runtime.a a16;
            com.tencent.mvi.base.route.j e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) switchItem);
                return;
            }
            Intrinsics.checkNotNullParameter(switchItem, "switchItem");
            if (switchItem.a().b().getBindChatType() && switchItem.a().a() != AssistedChatAIOHelper.this.z()) {
                return;
            }
            QLog.d("AssistedChatAIOHelper", 1, "onSettingSwitchChanged " + switchItem);
            AssistedChatAIOHelper.this.J(switchItem);
            com.tencent.aio.main.businesshelper.b bVar = AssistedChatAIOHelper.this.helperParam;
            if (bVar != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
                e16.h(new AssistedChatMsgIntent.OnSettingSwitchChanged(switchItem.a().b(), switchItem.b()));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58618);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatAIOHelper() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(AssistedChatAIOHelper$uiHandler$2.INSTANCE);
            this.uiHandler = lazy;
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
            lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ReplySuggestionFrequencyHelper>() { // from class: com.tencent.qqnt.aio.assistedchat.helper.AssistedChatAIOHelper$frequencyHelper$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatAIOHelper.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final ReplySuggestionFrequencyHelper invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new ReplySuggestionFrequencyHelper(AssistedChatAIOHelper.this.z(), AssistedChatAIOHelper.this.C(), com.tencent.qqnt.aio.assistedchat.config.a.INSTANCE.a().f()) : (ReplySuggestionFrequencyHelper) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.frequencyHelper = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.assistedchat.helper.AssistedChatAIOHelper$isReplySuggestionExp$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatAIOHelper.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Boolean invoke() {
                    IAssistedChatAdapterApi y16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    y16 = AssistedChatAIOHelper.this.y();
                    boolean isReplySuggestionExperiment = y16.isReplySuggestionExperiment(AssistedChatAIOHelper.this.z());
                    QLog.i("AssistedChatAIOHelper", 1, "init isReplySuggestionExp chatType=" + AssistedChatAIOHelper.this.z() + ", exp=" + isReplySuggestionExperiment);
                    return Boolean.valueOf(isReplySuggestionExperiment);
                }
            });
            this.isReplySuggestionExp = lazy3;
            this.action = new b();
            this.actionR = new c();
            this.switchChangedListener = new d();
            this.showReplySuggestionTailTask = new Runnable() { // from class: com.tencent.qqnt.aio.assistedchat.helper.b
                @Override // java.lang.Runnable
                public final void run() {
                    AssistedChatAIOHelper.S(AssistedChatAIOHelper.this);
                }
            };
            lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AssistedChatAIOHelper$assistedChatAdapterApi$2.INSTANCE);
            this.assistedChatAdapterApi = lazy4;
            lazy5 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) AssistedChatAIOHelper$switchAdapterApi$2.INSTANCE);
            this.switchAdapterApi = lazy5;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final ReplySuggestionFrequencyHelper A() {
        return (ReplySuggestionFrequencyHelper) this.frequencyHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object B(Continuation<? super Boolean> continuation) {
        AssistedChatAIOHelper$getPeerAIServiceSwitch$1 assistedChatAIOHelper$getPeerAIServiceSwitch$1;
        Object coroutine_suspended;
        int i3;
        Boolean bool;
        AssistedChatAIOHelper assistedChatAIOHelper;
        if (continuation instanceof AssistedChatAIOHelper$getPeerAIServiceSwitch$1) {
            assistedChatAIOHelper$getPeerAIServiceSwitch$1 = (AssistedChatAIOHelper$getPeerAIServiceSwitch$1) continuation;
            int i16 = assistedChatAIOHelper$getPeerAIServiceSwitch$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                assistedChatAIOHelper$getPeerAIServiceSwitch$1.label = i16 - Integer.MIN_VALUE;
                Object obj = assistedChatAIOHelper$getPeerAIServiceSwitch$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = assistedChatAIOHelper$getPeerAIServiceSwitch$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        assistedChatAIOHelper = (AssistedChatAIOHelper) assistedChatAIOHelper$getPeerAIServiceSwitch$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    bool = this.isPeerAIServiceEnable;
                    if (bool == null) {
                        assistedChatAIOHelper$getPeerAIServiceSwitch$1.L$0 = this;
                        assistedChatAIOHelper$getPeerAIServiceSwitch$1.label = 1;
                        obj = R(assistedChatAIOHelper$getPeerAIServiceSwitch$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        assistedChatAIOHelper = this;
                    }
                    return Boxing.boxBoolean(bool.booleanValue());
                }
                bool = (Boolean) obj;
                assistedChatAIOHelper.isPeerAIServiceEnable = Boxing.boxBoolean(bool.booleanValue());
                return Boxing.boxBoolean(bool.booleanValue());
            }
        }
        assistedChatAIOHelper$getPeerAIServiceSwitch$1 = new AssistedChatAIOHelper$getPeerAIServiceSwitch$1(this, continuation);
        Object obj2 = assistedChatAIOHelper$getPeerAIServiceSwitch$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = assistedChatAIOHelper$getPeerAIServiceSwitch$1.label;
        if (i3 == 0) {
        }
        bool = (Boolean) obj2;
        assistedChatAIOHelper.isPeerAIServiceEnable = Boxing.boxBoolean(bool.booleanValue());
        return Boxing.boxBoolean(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String C() {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar == null || (a16 = bVar.a()) == null || (g16 = a16.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return "";
        }
        return j3;
    }

    private final AdelieRecommendedMsgElement D(MsgRecord msgRecord) {
        ArrayList<MsgElement> auxiliaryElements = msgRecord.auxiliaryElements;
        Intrinsics.checkNotNullExpressionValue(auxiliaryElements, "auxiliaryElements");
        Iterator<T> it = auxiliaryElements.iterator();
        while (it.hasNext()) {
            AdelieRecommendedMsgElement adelieRecommendedMsgElement = ((MsgElement) it.next()).recommendedMsgElement;
            if (adelieRecommendedMsgElement != null) {
                return adelieRecommendedMsgElement;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAssistedChatSwitchAdapterApi E() {
        return (IAssistedChatSwitchAdapterApi) this.switchAdapterApi.getValue();
    }

    private final Handler F() {
        return (Handler) this.uiHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(MsgIntent intent) {
        if (intent instanceof AssistedChatMsgIntent.ShowAssistedChatPanelIntent) {
            I((AssistedChatMsgIntent.ShowAssistedChatPanelIntent) intent);
            return;
        }
        if (intent instanceof GestureEvent.DispatchTouchEvent) {
            K(((GestureEvent.DispatchTouchEvent) intent).a());
        } else if (intent instanceof AssistedChatMsgIntent.OnReplySuggestionTailShow) {
            P(((AssistedChatMsgIntent.OnReplySuggestionTailShow) intent).a());
        } else if (intent instanceof AssistedChatMsgIntent.OnReplySuggestionTailClick) {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k H(MsgIntent intent) {
        if (intent instanceof AssistedChatMsgIntent.GetAndRemoveShowPanelParamIntent) {
            j jVar = this.showPanelParam;
            this.showPanelParam = null;
            return new a.c(jVar);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void I(AssistedChatMsgIntent.ShowAssistedChatPanelIntent msgIntent) {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        QLog.d("AssistedChatAIOHelper", 1, "handleShowAssistedChatPanel source=" + msgIntent.a() + " subPanelId=" + msgIntent.b());
        this.showPanelParam = new j(msgIntent.a(), msgIntent.b());
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
            e16.h(new PanelContainerMsgIntent.ShowPanelMsgIntent(msgIntent.a(), 1014, false, 0, 12, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(com.tencent.qqnt.aio.assistedchat.model.d switchItem) {
        com.tencent.aio.main.businesshelper.b bVar;
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        if (switchItem.a().b() != AssistedChatSwitchType.AI_SERVICE && switchItem.a().b() != AssistedChatSwitchType.REPLY_SUGGESTION) {
            return;
        }
        if (switchItem.b() && M() && (bVar = this.helperParam) != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
            e16.h(AssistedChatMsgIntent.HideReplySuggestionSwitchTailIntent.f348982d);
        }
        U("onSettingSwitchChanged");
    }

    private final void K(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            U("ACTION_UP");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L() {
        return ((Boolean) this.isReplySuggestionExp.getValue()).booleanValue();
    }

    private final boolean M() {
        boolean isSwitchOn = E().isSwitchOn(new AssistedChatSwitch(AssistedChatSwitchType.REPLY_SUGGESTION, z()));
        boolean isSwitchOn2 = E().isSwitchOn(new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, 0));
        if (!isSwitchOn || !isSwitchOn2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object N(List<? extends com.tencent.qqnt.msg.d> list, Continuation<? super Unit> continuation) {
        MsgRecord msgRecord;
        Object coroutine_suspended;
        int size = list.size();
        while (true) {
            size--;
            if (-1 < size) {
                msgRecord = list.get(size).a();
                if (msgRecord.chatType == z() && Intrinsics.areEqual(msgRecord.peerUid, C()) && Intrinsics.areEqual(msgRecord.senderUid, C())) {
                    break;
                }
            } else {
                msgRecord = null;
                break;
            }
        }
        if (msgRecord != null && D(msgRecord) == null) {
            Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new AssistedChatAIOHelper$onReceiveMsg$2(this, null), continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (withContext == coroutine_suspended) {
                return withContext;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void O() {
        Context context;
        com.tencent.aio.api.runtime.a a16;
        Fragment c16;
        List<AssistedChatSwitch> listOf;
        com.tencent.aio.api.runtime.a a17;
        Fragment c17;
        Context context2;
        String string;
        boolean isSwitchOn = E().isSwitchOn(new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, z()));
        QLog.i("AssistedChatAIOHelper", 1, "[onReplySuggestionTailClick] aiServiceOn=" + isSwitchOn);
        if (!AppNetConnInfo.isNetSupport()) {
            com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
            if (bVar != null && (a17 = bVar.a()) != null && (c17 = a17.c()) != null && (context2 = c17.getContext()) != null && (string = context2.getString(R.string.cib)) != null) {
                T(2, string);
                return;
            }
            return;
        }
        if (isSwitchOn) {
            IAssistedChatSwitchAdapterApi E = E();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new AssistedChatSwitch(AssistedChatSwitchType.REPLY_SUGGESTION, z()));
            E.reqSetSwitch(listOf, 1, AssistedChatAIOHelper$onReplySuggestionTailClick$2.INSTANCE);
            T(2, "\u5df2\u5f00\u542f");
            return;
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.helperParam;
        FragmentActivity fragmentActivity = null;
        if (bVar2 != null && (a16 = bVar2.a()) != null && (c16 = a16.c()) != null) {
            context = c16.getContext();
        } else {
            context = null;
        }
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        }
        if (fragmentActivity != null) {
            IAssistedChatApi iAssistedChatApi = (IAssistedChatApi) QRoute.api(IAssistedChatApi.class);
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
            com.tencent.aio.main.businesshelper.b bVar3 = this.helperParam;
            Intrinsics.checkNotNull(bVar3);
            iAssistedChatApi.showPermissionFragmentDialog(supportFragmentManager, "AssistedChatAIOHelper", bVar3.a(), new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.helper.AssistedChatAIOHelper$onReplySuggestionTailClick$3$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AssistedChatAIOHelper.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    List<AssistedChatSwitch> listOf2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new AssistedChatSwitch[]{new AssistedChatSwitch(AssistedChatSwitchType.REPLY_SUGGESTION, AssistedChatAIOHelper.this.z()), new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, 0)});
                    AssistedChatAIOHelper.this.E().reqSetSwitch(listOf2, 1, AnonymousClass1.INSTANCE);
                    AssistedChatAIOHelper.this.T(2, "\u5df2\u5f00\u542f");
                }
            });
        }
    }

    private final void P(View itemView) {
        com.tencent.aio.api.runtime.a a16;
        this.canShowReplySuggestionTail = Boolean.FALSE;
        A().k();
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar != null && (a16 = bVar.a()) != null) {
            y().setDtReportPageInfo(itemView, a16);
        }
    }

    private final void Q() {
        U("onResume");
    }

    private final Object R(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        boolean z16;
        List<AssistedChatSwitch> listOf;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        int z17 = z();
        if (z17 != 1) {
            if (z17 == 104 || z17 == 119) {
                com.tencent.qqnt.aio.assistedchat.request.a.f349425a.g(z(), C(), new Function3<Integer, String, AssistedChatPB$AssistedSwitchRsp, Unit>(cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.helper.AssistedChatAIOHelper$reqPeerAIServiceSwitch$2$3
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation<Boolean> $coroutine;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                        this.$coroutine = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, AssistedChatPB$AssistedSwitchRsp assistedChatPB$AssistedSwitchRsp) {
                        invoke(num.intValue(), str, assistedChatPB$AssistedSwitchRsp);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, @Nullable String str, @Nullable AssistedChatPB$AssistedSwitchRsp assistedChatPB$AssistedSwitchRsp) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, assistedChatPB$AssistedSwitchRsp);
                            return;
                        }
                        if (i3 == 0 && assistedChatPB$AssistedSwitchRsp != null) {
                            int i16 = assistedChatPB$AssistedSwitchRsp.rsp_head.ret_code.get();
                            if (i16 != 0) {
                                QLog.i("AssistedChatAIOHelper", 1, "[reqPeerAIServiceSwitch] response ret_code=" + i16);
                            }
                            boolean z18 = assistedChatPB$AssistedSwitchRsp.enable_ai_assistant.get();
                            QLog.i("AssistedChatAIOHelper", 1, "[reqPeerAIServiceSwitch] response result=" + z18);
                            this.$coroutine.resume(Boolean.valueOf(z18), AnonymousClass1.INSTANCE);
                            return;
                        }
                        QLog.e("AssistedChatAIOHelper", 1, "[reqPeerAIServiceSwitch] error, code=" + i3 + ", msg=" + str);
                        this.$coroutine.resume(Boolean.FALSE, AnonymousClass2.INSTANCE);
                    }
                });
            }
        } else {
            String uinFromUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getUinFromUid(C());
            if (uinFromUid != null && uinFromUid.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                IAssistedChatSwitchAdapterApi E = E();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(new AssistedChatSwitch(AssistedChatSwitchType.AI_SERVICE, 0));
                E.reqGetSwitch(uinFromUid, listOf, new Function1<List<? extends com.tencent.qqnt.aio.assistedchat.model.d>, Unit>(cancellableContinuationImpl) { // from class: com.tencent.qqnt.aio.assistedchat.helper.AssistedChatAIOHelper$reqPeerAIServiceSwitch$2$2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ CancellableContinuation<Boolean> $coroutine;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                        this.$coroutine = cancellableContinuationImpl;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cancellableContinuationImpl);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends d> list) {
                        invoke2((List<d>) list);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull List<d> switchItemList) {
                        Object firstOrNull;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) switchItemList);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(switchItemList, "switchItemList");
                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) switchItemList);
                        d dVar = (d) firstOrNull;
                        Boolean valueOf = dVar != null ? Boolean.valueOf(dVar.b()) : null;
                        QLog.i("AssistedChatAIOHelper", 1, "[reqPeerAIServiceSwitch] switchOn=" + valueOf);
                        this.$coroutine.resume(Boolean.valueOf(valueOf != null ? valueOf.booleanValue() : false), AnonymousClass1.INSTANCE);
                    }
                });
            } else {
                QLog.i("AssistedChatAIOHelper", 1, "[reqPeerAIServiceSwitch] getUinFromUid failed.");
                cancellableContinuationImpl.resume(Boxing.boxBoolean(false), AssistedChatAIOHelper$reqPeerAIServiceSwitch$2$1.INSTANCE);
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(AssistedChatAIOHelper this$0) {
        com.tencent.aio.main.businesshelper.b bVar;
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.w() && !this$0.M() && (bVar = this$0.helperParam) != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
            e16.h(AssistedChatMsgIntent.ShowReplySuggestionSwitchTailIntent.f348996d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(int iconType, String msg2) {
        com.tencent.aio.api.runtime.a a16;
        Fragment c16;
        Context context;
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (c16 = a16.c()) != null && (context = c16.getContext()) != null) {
            QQToast.makeText(context, iconType, msg2, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(String from) {
        F().removeCallbacks(this.showReplySuggestionTailTask);
        QLog.i("AssistedChatAIOHelper", 1, "post ShowOpenSwitchGuideTask, from=" + from);
        F().postDelayed(this.showReplySuggestionTailTask, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            A().j();
            ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(peekAppRuntime, LocalGrayTip.LocalGrayTipBuilder.i(new LocalGrayTip.LocalGrayTipBuilder(C(), z(), 10463L, 0, false, false, null, 120, null), "\u5bf9\u65b9\u672a\u5f00\u542fAI\u670d\u52a1\uff0c\u65e0\u6cd5\u4e3a\u4f60\u63d0\u4f9b\u56de\u590d\u63a8\u8350\u3002", 0, 2, null).m(), new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.qqnt.aio.assistedchat.helper.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                public final void onResult(int i3, long j3) {
                    AssistedChatAIOHelper.v(i3, j3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(int i3, long j3) {
        QLog.i("AssistedChatAIOHelper", 1, "addLocalGrayTip " + i3 + ", msgId=" + j3);
    }

    private final boolean w() {
        boolean c16;
        Boolean bool = this.canShowReplySuggestionTail;
        if (bool != null) {
            c16 = bool.booleanValue();
        } else {
            c16 = A().c();
            QLog.i("AssistedChatAIOHelper", 1, "canShowReplySuggestionTail by frequency=" + c16);
            this.canShowReplySuggestionTail = Boolean.valueOf(c16);
        }
        if (c16 && L()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object x(Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        if (A().i()) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new AssistedChatAIOHelper$checkAddLocalGrayTip$2(this, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAssistedChatAdapterApi y() {
        return (IAssistedChatAdapterApi) this.assistedChatAdapterApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int z() {
        com.tencent.aio.api.runtime.a a16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            return c16.e();
        }
        return 0;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 52;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.ShowAssistedChatPanelIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.GestureEvent.DispatchTouchEvent");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnReplySuggestionTailShow");
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.OnReplySuggestionTailClick");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent.GetAndRemoveShowPanelParamIntent");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AssistedChatAIOHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        com.tencent.aio.api.runtime.a a16;
        LifecycleOwner d16;
        Lifecycle lifecycle;
        LifecycleCoroutineScope coroutineScope;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.helperParam = param;
        com.tencent.mvi.base.route.j e16 = param.a().e();
        e16.f(this, this.action);
        e16.l(this, this.actionR);
        E().addSwitchChangedListener(this.switchChangedListener);
        E().preRequestSwitch();
        y().reportExpExposure(z());
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (d16 = a16.d()) != null && (lifecycle = d16.getLifecycle()) != null && (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) != null) {
            FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerReceiveMsgNotificationFlow(), new AssistedChatAIOHelper$onCreate$2$1(this, null)), Dispatchers.getIO()), coroutineScope);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.main.businesshelper.b bVar = this.helperParam;
        if (bVar != null && (a16 = bVar.a()) != null && (e16 = a16.e()) != null) {
            e16.i(this, this.action);
            e16.e(this);
        }
        F().removeCallbacks(this.showReplySuggestionTailTask);
        E().removeSwitchChangedListener(this.switchChangedListener);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
        } else if (state == 3) {
            Q();
        }
    }
}
