package com.tencent.mobileqq.springhb.interactive.helper;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.emitter.a;
import com.tencent.aio.frame.api.DrawerFrameScrollMsgIntent;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgEvent;
import com.tencent.mobileqq.aio.event.TitleTabEvent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.input.fullscreen.e;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.entry.model.DragonCardConfigData;
import com.tencent.mobileqq.springhb.interactive.api.InteractiveRecord;
import com.tencent.mobileqq.springhb.interactive.api.b;
import com.tencent.mobileqq.springhb.interactive.config.c;
import com.tencent.mobileqq.springhb.interactive.ui.InteractivePopManager;
import com.tencent.mobileqq.springhb.interactive.ui.e;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuildTroopApi;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.msg.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a5\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\b*\u0001P\b\u0000\u0018\u0000 V2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001.B\u000f\u0012\u0006\u00103\u001a\u000200\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0016\u0010\u0018\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u001c\u0010\"\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u000f0\u001f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001f*\b\u0012\u0004\u0012\u00020\u000f0\u001fH\u0003J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\b\u0010*\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020$H\u0016J\b\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\nH\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001c\u00107\u001a\b\u0012\u0004\u0012\u00020\u001d048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001d\u0010B\u001a\u0004\u0018\u00010=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010;R\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020K8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bL\u0010?\u001a\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/helper/InteractiveAnimationHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mobileqq/springhb/interactive/ui/e;", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "", "r", "", "reason", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/springhb/interactive/api/InteractiveRecord;", "msg", "w", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "p", "", "Lcom/tencent/aio/data/msglist/a;", "msgItemList", "t", "Lcom/tencent/qqnt/msg/d;", "msgRecord", "k", "(Lcom/tencent/qqnt/msg/d;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/app/Activity;", "j", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", ReportConstant.COSTREPORT_PREFIX, "v", "", "getId", "getTag", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "onBackEvent", "a", "call", "Lcom/tencent/mobileqq/springhb/interactive/api/b;", "d", "Lcom/tencent/mobileqq/springhb/interactive/api/b;", "provider", "Ljava/lang/ref/WeakReference;", "e", "Ljava/lang/ref/WeakReference;", "weakActivity", "f", "Lcom/tencent/aio/api/runtime/a;", h.F, "I", "lifeState", "Lcom/tencent/mobileqq/springhb/interactive/api/a;", "i", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/springhb/interactive/api/a;", "frequencyController", "curScrollX", BdhLogUtil.LogTag.Tag_Conn, "Z", "guildTroop", "", "D", "J", "easterEggMsgSeq", "Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;", "E", "o", "()Lcom/tencent/mobileqq/springhb/interactive/ui/InteractivePopManager;", "popManager", "com/tencent/mobileqq/springhb/interactive/helper/InteractiveAnimationHelper$b", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/springhb/interactive/helper/InteractiveAnimationHelper$b;", "mAction", "<init>", "(Lcom/tencent/mobileqq/springhb/interactive/api/b;)V", "G", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class InteractiveAnimationHelper implements com.tencent.aio.main.businesshelper.h, a, com.tencent.mvi.base.route.a, e {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean guildTroop;

    /* renamed from: D, reason: from kotlin metadata */
    private long easterEggMsgSeq;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy popManager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.springhb.interactive.api.b provider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Activity> weakActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lifeState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy frequencyController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int curScrollX;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/helper/InteractiveAnimationHelper$a;", "", "Lcom/tencent/mobileqq/springhb/interactive/config/b;", "msg", "", "ext3", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.springhb.interactive.helper.InteractiveAnimationHelper$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable com.tencent.mobileqq.springhb.interactive.config.b msg2, @NotNull String ext3) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2, (Object) ext3);
                return;
            }
            Intrinsics.checkNotNullParameter(ext3, "ext3");
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ext4", "8");
            hashMap.put("ext3", ext3);
            if (msg2 != null) {
                String d16 = msg2.d();
                hashMap.put("ext2", msg2.e());
                hashMap.put("ext6", msg2.getSessionId());
                hashMap.put("ext49", InteractiveRecord.INSTANCE.a(msg2.getChatType()));
                str = d16;
            } else {
                str = "";
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(str, "8", "1069", "9514", "951401", "915872", "", hashMap);
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/springhb/interactive/helper/InteractiveAnimationHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InteractiveAnimationHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                InteractiveAnimationHelper.this.p(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public InteractiveAnimationHelper(@NotNull com.tencent.mobileqq.springhb.interactive.api.b provider) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(provider, "provider");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) provider);
            return;
        }
        this.provider = provider;
        this.lifeState = -2147483647;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<com.tencent.mobileqq.springhb.interactive.api.a>() { // from class: com.tencent.mobileqq.springhb.interactive.helper.InteractiveAnimationHelper$frequencyController$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InteractiveAnimationHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final com.tencent.mobileqq.springhb.interactive.api.a invoke() {
                b bVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.springhb.interactive.api.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                bVar = InteractiveAnimationHelper.this.provider;
                return bVar.d();
            }
        });
        this.frequencyController = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) InteractiveAnimationHelper$popManager$2.INSTANCE);
        this.popManager = lazy2;
        this.mAction = new b();
    }

    private final Activity j() {
        boolean z16;
        WeakReference<Activity> weakReference = this.weakActivity;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("weakActivity");
            weakReference = null;
        }
        Activity activity = weakReference.get();
        boolean z17 = true;
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (activity == null || !activity.isDestroyed()) {
                z17 = false;
            }
            if (!z17) {
                return activity;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object k(d dVar, Continuation<? super InteractiveRecord> continuation) {
        com.tencent.mobileqq.springhb.interactive.config.d dVar2;
        DragonCardConfigData b16;
        if (!this.provider.e(this.aioContext, dVar) || !this.provider.c(dVar) || (b16 = (dVar2 = com.tencent.mobileqq.springhb.interactive.config.d.f289234a).b()) == null || !dVar2.a(b16)) {
            return null;
        }
        InteractiveRecord a16 = this.provider.a(dVar);
        a16.u(b16);
        return a16.s(continuation);
    }

    private final void m(String reason) {
        if (o().m()) {
            o().o(reason);
        }
    }

    private final com.tencent.mobileqq.springhb.interactive.api.a n() {
        return (com.tencent.mobileqq.springhb.interactive.api.a) this.frequencyController.getValue();
    }

    private final InteractivePopManager o() {
        return (InteractivePopManager) this.popManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(MsgIntent intent) {
        if (intent instanceof AIOMsgEvent.OnDisplayUnreadMsg) {
            t(((AIOMsgEvent.OnDisplayUnreadMsg) intent).a());
        }
    }

    private final void q(com.tencent.aio.main.businesshelper.b param) {
        com.tencent.aio.api.runtime.a aVar;
        LifecycleOwner d16;
        if (param.a().g().r().c().e() == 2) {
            boolean isGuildTroop = ((IGuildTroopApi) QRoute.api(IGuildTroopApi.class)).isGuildTroop(param.a().g().r().c().j());
            this.guildTroop = isGuildTroop;
            QLog.d("InteractiveAnimationHelper", 1, "guildTroop " + isGuildTroop);
            if (this.guildTroop && (aVar = this.aioContext) != null && (d16 = aVar.d()) != null) {
                param.a().e().c(TitleTabEvent.OnFeedTabSelected.class.getCanonicalName(), this, d16);
            }
        }
    }

    private final boolean r() {
        k kVar;
        j e16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        e.a aVar2 = null;
        if (aVar != null && (e16 = aVar.e()) != null) {
            kVar = e16.k(FullScreenMsgIntent.GetFullScreenMode.f189578d);
        } else {
            kVar = null;
        }
        if (kVar instanceof e.a) {
            aVar2 = (e.a) kVar;
        }
        if (aVar2 != null) {
            return aVar2.a();
        }
        return false;
    }

    private final void s(Flow<? extends InteractiveRecord> flow, com.tencent.aio.api.runtime.a aVar) {
        LifecycleOwner d16;
        if (aVar != null && (d16 = aVar.d()) != null) {
            FlowKt.launchIn(FlowKt.flowOn(v(FlowKt.flowOn(flow, Dispatchers.getDefault())), Dispatchers.getMain()), LifecycleOwnerKt.getLifecycleScope(d16));
        }
    }

    private final void t(List<? extends com.tencent.aio.data.msglist.a> msgItemList) {
        if (QLog.isDevelopLevel()) {
            QLog.i("InteractiveAnimationHelper", 1, "[onDisplayUnreadMsg],msg.size:" + msgItemList.size());
        }
        if (msgItemList != null && !msgItemList.isEmpty()) {
            s(FlowKt.flowOn(FlowKt.flow(new InteractiveAnimationHelper$onDisplayUnreadMsg$1(msgItemList, this, null)), Dispatchers.getIO()), this.aioContext);
        }
    }

    private final void u() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null) {
            j e16 = aVar.e();
            String canonicalName = DrawerFrameScrollMsgIntent.class.getCanonicalName();
            LifecycleOwner d16 = aVar.d();
            Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
            e16.c(canonicalName, this, d16);
        }
    }

    @MainThread
    private final Flow<InteractiveRecord> v(Flow<? extends InteractiveRecord> flow) {
        return FlowKt.flow(new InteractiveAnimationHelper$showPop$$inlined$transform$1(flow, null, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(InteractiveRecord msg2) {
        com.tencent.aio.api.runtime.a aVar;
        Fragment fragment;
        k kVar;
        j e16;
        if (((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isLoadingShowing()) {
            QLog.d("InteractiveAnimationHelper", 1, "webLoading !!");
            return;
        }
        if (!a()) {
            QLog.d("InteractiveAnimationHelper", 1, "helper not active ");
            return;
        }
        QLog.d("InteractiveAnimationHelper", 1, "showPop ");
        if (o().m()) {
            QLog.d("InteractiveAnimationHelper", 1, "popManager isShow ");
            INSTANCE.a(msg2, "5");
            return;
        }
        if (r()) {
            QLog.d("InteractiveAnimationHelper", 1, "isFullScreenMode limit!! ");
            INSTANCE.a(msg2, "8");
            return;
        }
        if (n() != null) {
            com.tencent.mobileqq.springhb.interactive.api.a n3 = n();
            Intrinsics.checkNotNull(n3);
            if (!n3.a(msg2)) {
                QLog.d("InteractiveAnimationHelper", 1, "frequency limit!! ");
                INSTANCE.a(msg2, "6");
                return;
            }
        }
        if (this.curScrollX != 0) {
            QLog.d("InteractiveAnimationHelper", 1, "panelScroll limit!! ");
            return;
        }
        if (this.guildTroop) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 != null && (e16 = aVar2.e()) != null) {
                kVar = e16.k(TitleTabEvent.GetTitleTabStatusEvent.f188716d);
            } else {
                kVar = null;
            }
            if ((kVar instanceof m.g) && ((m.g) kVar).a()) {
                QLog.d("InteractiveAnimationHelper", 1, "Group Feed Selected limit!! ");
                return;
            }
        }
        if (j() != null && (aVar = this.aioContext) != null && (fragment = aVar.c()) != null) {
            Intrinsics.checkNotNullExpressionValue(fragment, "fragment");
            c a16 = c.INSTANCE.a(msg2);
            if (a16 != null) {
                com.tencent.mobileqq.springhb.interactive.api.a n16 = n();
                if (n16 != null) {
                    n16.b(msg2);
                }
                o().t(fragment, a16, this, InteractiveAnimationHelper$showPop$1$1$1$1.INSTANCE);
            }
        }
    }

    @Override // com.tencent.mobileqq.springhb.interactive.ui.e
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        int i3 = this.lifeState;
        if (i3 < 0 || i3 >= 8) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof DrawerFrameScrollMsgIntent) {
            DrawerFrameScrollMsgIntent drawerFrameScrollMsgIntent = (DrawerFrameScrollMsgIntent) intent;
            if (drawerFrameScrollMsgIntent.b() != 0) {
                m("panelScroll");
            }
            this.curScrollX = drawerFrameScrollMsgIntent.b();
            return;
        }
        if (intent instanceof TitleTabEvent.OnFeedTabSelected) {
            m("OnFeedTabSelected");
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.f350651l1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "InteractiveAnimationHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0, 3, 4, 12, 8, 9};
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        m("onBackEvent");
        return a.C0623a.a(this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        j e16;
        ml3.b b16;
        ml3.a a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.aioContext = param.a();
        this.weakActivity = new WeakReference<>(param.a().c().requireActivity());
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (b16 = aVar.b()) != null && (a16 = b16.a(com.tencent.aio.api.runtime.emitter.a.class)) != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            Intrinsics.checkNotNull(aVar2);
            LifecycleOwner d16 = aVar2.d();
            Intrinsics.checkNotNullExpressionValue(d16, "aioContext!!.lifecycleOwner");
            a16.b(this, d16);
        }
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 != null && (e16 = aVar3.e()) != null) {
            e16.d(Reflection.getOrCreateKotlinClass(AIOMsgEvent.OnDisplayUnreadMsg.class).getQualifiedName(), this.mAction);
        }
        q(param);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(AIOMsgEvent.OnDisplayUnreadMsg.class).getQualifiedName(), this.mAction);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
            return;
        }
        this.lifeState = state;
        if (state == 8 || state == 9 || state == 12) {
            o().o("lifeChange" + state);
            this.curScrollX = 0;
        }
        if (state == 3) {
            this.curScrollX = 0;
        }
        if (state == 4) {
            u();
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return a.C9235a.a(this);
    }
}
