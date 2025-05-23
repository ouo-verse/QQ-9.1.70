package com.tencent.mobileqq.aio.animation;

import android.content.res.Configuration;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.animation.AIOAnimationEvent;
import com.tencent.mobileqq.aio.animation.AIOAnimationState;
import com.tencent.mobileqq.aio.animation.a;
import com.tencent.mobileqq.aio.animation.api.IAioAnimationApi;
import com.tencent.mobileqq.aio.event.AIOMsgEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.event.TitleTabEvent;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.edit.d;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.aio.msg.service.AIOMsgService;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001,\u0018\u0000 \b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001?B\u000f\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0019\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J \u0010 \u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R&\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020,030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00101\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/AIOAnimationVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/animation/a;", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationState;", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "D", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "t", "r", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "", "height", "G", "deltaY", "y", "H", "", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "v", "offsetY", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/animation/data/b;", TabPreloadItem.TAB_NAME_MESSAGE, "", "forceUpdateMsgSeq", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", DKHippyEvent.EVENT_STOP, "isFullScreenMode", "w", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/animation/data/h;", "e", "Lcom/tencent/mobileqq/aio/animation/data/h;", "animationContainer", "com/tencent/mobileqq/aio/animation/AIOAnimationVM$d", "f", "Lcom/tencent/mobileqq/aio/animation/AIOAnimationVM$d;", "mAction", tl.h.F, "I", "mCurOrientation", "Lkotlin/Pair;", "", "i", "Ljava/util/List;", "mMessageList", "Lcom/tencent/mobileqq/aio/animation/data/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/animation/data/d;", SessionDbHelper.SESSION_ID, "previousBounceY", "<init>", "(Lcom/tencent/mobileqq/aio/animation/data/h;)V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOAnimationVM extends com.tencent.qqnt.aio.baseVM.a<a, AIOAnimationState> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int previousBounceY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.aio.animation.data.h animationContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mCurOrientation;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, d>> mMessageList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.animation.data.d session;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/AIOAnimationVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.AIOAnimationVM$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/animation/AIOAnimationVM$b", "Lcom/tencent/aio/api/runtime/emitter/b;", "Landroid/content/res/Configuration;", "configuration", "", "onConfigurationChanged", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.aio.api.runtime.emitter.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOAnimationVM.this);
            }
        }

        @Override // com.tencent.aio.api.runtime.emitter.b
        public void onConfigurationChanged(@NotNull Configuration configuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) configuration);
                return;
            }
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            if (configuration.orientation != AIOAnimationVM.this.mCurOrientation) {
                QLog.d("AIOAnimationVM", 1, "[onConfigurationChanged] orientation changed, after=" + configuration.orientation + ", before=" + AIOAnimationVM.this.mCurOrientation);
                AIOAnimationVM.this.updateUI(AIOAnimationState.StopAnimation.f187783d);
                AIOAnimationVM.this.mCurOrientation = configuration.orientation;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/aio/animation/AIOAnimationVM$c", "Lu71/c;", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements u71.c {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/animation/AIOAnimationVM$d", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOAnimationVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOAnimationVM.this.E(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43938);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOAnimationVM(@NotNull com.tencent.mobileqq.aio.animation.data.h animationContainer) {
        List<Pair<String, d>> listOf;
        Intrinsics.checkNotNullParameter(animationContainer, "animationContainer");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animationContainer);
            return;
        }
        this.animationContainer = animationContainer;
        d dVar = new d();
        this.mAction = dVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOAnimationEvent.OnUpdateMsg.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgEvent.OnDisplayUnreadMsg.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ListScrolled.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ListBounced.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LifeCycleEvent.OnStop.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(TitleTabEvent.OnFeedTabSelected.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleContainerMsgIntent.NotifyTitleHeight.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(InputAtMsgIntent.OnShowDialog.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.BottomLayoutHeightChange.class)), dVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.SetFullScreenMode.class)), dVar)});
        this.mMessageList = listOf;
    }

    static /* synthetic */ void A(AIOAnimationVM aIOAnimationVM, List list, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        aIOAnimationVM.z(list, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(BaseQQAppInterface appInterface, List msgList, AIOAnimationVM this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        Intrinsics.checkNotNullParameter(msgList, "$msgList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IAioAnimationApi iAioAnimationApi = (IAioAnimationApi) QRoute.api(IAioAnimationApi.class);
        com.tencent.mobileqq.aio.animation.data.d dVar = this$0.session;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(SessionDbHelper.SESSION_ID);
            dVar = null;
        }
        iAioAnimationApi.handleNewMsg(appInterface, msgList, dVar, this$0.animationContainer, z16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    private final void D() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(AIOMsgService.f190196a.q(), new AIOAnimationVM$setupMsgStatusListener$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof AIOAnimationEvent.OnUpdateMsg) {
            A(this, ((AIOAnimationEvent.OnUpdateMsg) intent).a(), false, 2, null);
            return;
        }
        if (intent instanceof AIOMsgEvent.OnDisplayUnreadMsg) {
            v(((AIOMsgEvent.OnDisplayUnreadMsg) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.ListScrolled) {
            y(((AIOMsgListEvent.ListScrolled) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.ListBounced) {
            x((int) ((AIOMsgListEvent.ListBounced) intent).a());
            return;
        }
        if (intent instanceof InputAtMsgIntent.OnShowDialog) {
            onStop();
            return;
        }
        if (intent instanceof TitleTabEvent.OnFeedTabSelected) {
            onStop();
            return;
        }
        if (intent instanceof LifeCycleEvent.OnStop) {
            onStop();
            return;
        }
        if (intent instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            w(((FullScreenMsgIntent.OnFullScreenModeChanged) intent).a());
            return;
        }
        if (intent instanceof FullScreenMsgIntent.SetFullScreenMode) {
            w(((FullScreenMsgIntent.SetFullScreenMode) intent).a());
        } else if (intent instanceof AIOTitleContainerMsgIntent.NotifyTitleHeight) {
            H(((AIOTitleContainerMsgIntent.NotifyTitleHeight) intent).a());
        } else if (intent instanceof AIOMsgListEvent.BottomLayoutHeightChange) {
            G(((AIOMsgListEvent.BottomLayoutHeightChange) intent).a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F() {
        Iterator<T> it = this.mMessageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((com.tencent.aio.api.runtime.a) getMContext()).e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    private final void G(int height) {
        updateUI(new AIOAnimationState.UpdateBottomHeight(height));
    }

    private final void H(int height) {
        updateUI(new AIOAnimationState.UpdateTitleHeight(height));
    }

    private final void onStop() {
        updateUI(AIOAnimationState.StopAnimation.f187783d);
    }

    private final void q(com.tencent.aio.api.runtime.a context) {
        this.mCurOrientation = BaseApplication.context.getResources().getConfiguration().orientation;
        ml3.a a16 = context.b().a(com.tencent.aio.api.runtime.emitter.b.class);
        b bVar = new b();
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        a16.b(bVar, d16);
    }

    private final void r() {
        IAioAnimationApi iAioAnimationApi = (IAioAnimationApi) QRoute.api(IAioAnimationApi.class);
        iAioAnimationApi.setMsgDelegate(null);
        iAioAnimationApi.setTroopInfoDelegate(null);
    }

    private final void t() {
        QRouteApi api = QRoute.api(IAioAnimationApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAioAnimationApi::class.java)");
        IAioAnimationApi iAioAnimationApi = (IAioAnimationApi) api;
        iAioAnimationApi.setMsgDelegate(new c());
        iAioAnimationApi.setTroopInfoDelegate(new u71.a() { // from class: com.tencent.mobileqq.aio.animation.AIOAnimationVM$initAioAnimationDelegate$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // u71.a
            public boolean a(@NotNull String troopUin) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopUin)).booleanValue();
                }
                Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                return false;
            }

            @Override // u71.a
            public void b(@NotNull String memberUin, @NotNull String troopUin, @NotNull final Function1<? super Boolean, Unit> callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, memberUin, troopUin, callback);
                    return;
                }
                Intrinsics.checkNotNullParameter(memberUin, "memberUin");
                Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                Intrinsics.checkNotNullParameter(callback, "callback");
                com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(callback) { // from class: com.tencent.mobileqq.aio.animation.AIOAnimationVM$initAioAnimationDelegate$2$getDragonKingInfo$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Function1<Boolean, Unit> $callback;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                        this.$callback = callback;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            this.$callback.invoke(Boolean.TRUE);
                        } else {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                    }
                });
            }

            @Override // u71.a
            public boolean c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
                }
                return true;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean u() {
        e.a aVar;
        com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        if (k3 instanceof e.a) {
            aVar = (e.a) k3;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    private final void v(List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        A(this, s.f188155a.c(msgItemList), false, 2, null);
    }

    private final void w(boolean isFullScreenMode) {
        if (isFullScreenMode) {
            updateUI(AIOAnimationState.StopAnimation.f187783d);
        }
    }

    private final void x(int offsetY) {
        int i3 = this.previousBounceY - offsetY;
        this.previousBounceY = offsetY;
        updateUI(new AIOAnimationState.ListScrolled(i3));
    }

    private final void y(int deltaY) {
        updateUI(new AIOAnimationState.ListScrolled(deltaY));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(final List<? extends com.tencent.mobileqq.aio.animation.data.b> msgList, final boolean forceUpdateMsgSeq) {
        final BaseQQAppInterface baseQQAppInterface;
        if (msgList.isEmpty() || u() || !Foreground.isCurrentProcessForeground()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.d
            @Override // java.lang.Runnable
            public final void run() {
                AIOAnimationVM.B(BaseQQAppInterface.this, msgList, this, forceUpdateMsgSeq);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        F();
        r();
        ((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).cleanup();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.c) {
            com.tencent.mvi.base.route.k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new AIOMsgListEvent.GetListItemRect(7));
            Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.MsgListResult.GetMsgRectResult");
            ((a.c) intent).b(((z.g) k3).a());
            return;
        }
        if (intent instanceof a.b) {
            com.tencent.mvi.base.route.k k16 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(InputEvent.GetInputBarHeight.f188570d);
            Intrinsics.checkNotNull(k16, "null cannot be cast to non-null type com.tencent.mobileqq.aio.input.edit.AIOInputMsgResult.GetInputBarHeightResult");
            ((a.b) intent).b(((d.c) k16).a());
        } else if (!(intent instanceof a.C7232a)) {
            QLog.i("AIOAnimationVM", 1, "unhandled intent, intent=" + intent);
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.session = ((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).convertSession(context.g().r());
        C();
        t();
        D();
        q(context);
    }
}
