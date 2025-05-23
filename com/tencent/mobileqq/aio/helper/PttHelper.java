package com.tencent.mobileqq.aio.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.toast.QUIStatusToast;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttAudioPlayerManager;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttUtil;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\t*\u000247\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u000fH\u0002J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010-R2\u00103\u001a\u001e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00150/j\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0015`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/PttHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", tl.h.F, "j", "i", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", DomainData.DOMAIN_NAME, "msgIntent", "Lcom/tencent/mvi/base/route/k;", "o", "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$PttSetExpandStatus;", "p", "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$PttGetExpandStatus;", "Lcom/tencent/mobileqq/aio/msglist/z$h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "", "k", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "interestedIn", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "e", "Z", "needHeadsetToast", "Lcom/tencent/biz/qui/toast/QUIStatusToast;", "f", "Lcom/tencent/biz/qui/toast/QUIStatusToast;", "lowVolumeDialog", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "expandMsgMap", "com/tencent/mobileqq/aio/helper/PttHelper$b", "Lcom/tencent/mobileqq/aio/helper/PttHelper$b;", "action", "com/tencent/mobileqq/aio/helper/PttHelper$c", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/helper/PttHelper$c;", "mActionR", "<init>", "()V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class PttHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final c mActionR;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needHeadsetToast;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIStatusToast lowVolumeDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Handler handler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Long, Boolean> expandMsgMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/PttHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.PttHelper$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/PttHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PttHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                PttHelper.this.n(i3);
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/PttHelper$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PttHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return PttHelper.this.o(i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PttHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.expandMsgMap = new HashMap<>();
        this.action = new b();
        this.mActionR = new c();
    }

    private final void h() {
        this.needHeadsetToast = true;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().f(this, this.action);
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        } else {
            bVar2 = bVar3;
        }
        bVar2.a().e().l(this, this.mActionR);
    }

    private final void i() {
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        bVar.a().e().i(this, this.action);
        this.expandMsgMap.clear();
    }

    private final void j() {
        AIOPttAudioPlayerManager aIOPttAudioPlayerManager = AIOPttAudioPlayerManager.f191706d;
        if (AIOPttAudioPlayerManager.p(aIOPttAudioPlayerManager, null, 0L, 3, null)) {
            aIOPttAudioPlayerManager.u(true);
        }
    }

    private final Function1<Boolean, Unit> k(Activity activity) {
        return new PttHelper$getPhoneLowVolumeListener$onLowVolume$1(this, activity);
    }

    private final z.h m(AIOMsgListEvent.PttGetExpandStatus intent) {
        Boolean bool;
        if (this.expandMsgMap.containsKey(Long.valueOf(intent.a()))) {
            bool = this.expandMsgMap.get(Long.valueOf(intent.a()));
        } else {
            bool = Boolean.FALSE;
        }
        return new z.h(Intrinsics.areEqual(bool, Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.PttToastHeadset) {
            AIOMsgListEvent.PttToastHeadset pttToastHeadset = (AIOMsgListEvent.PttToastHeadset) intent;
            if (pttToastHeadset.a() == null && !this.needHeadsetToast) {
                return;
            }
            this.needHeadsetToast = false;
            com.tencent.aio.main.businesshelper.b bVar = this.param;
            Context context = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
                bVar = null;
            }
            Fragment c16 = bVar.a().c();
            if (c16 != null) {
                context = c16.getContext();
            }
            if (context == null) {
                return;
            }
            AIOPttUtil.f191743a.k(context, pttToastHeadset.a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.PttSetExpandStatus) {
            p((AIOMsgListEvent.PttSetExpandStatus) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k o(MsgIntent msgIntent) {
        if (msgIntent instanceof AIOMsgListEvent.PttGetExpandStatus) {
            return m((AIOMsgListEvent.PttGetExpandStatus) msgIntent);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    private final void p(AIOMsgListEvent.PttSetExpandStatus intent) {
        if (intent.b()) {
            this.expandMsgMap.put(Long.valueOf(intent.a()), Boolean.TRUE);
        } else {
            this.expandMsgMap.remove(Long.valueOf(intent.a()));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 39;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.PttToastHeadset");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.PttSetExpandStatus");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.PttGetExpandStatus");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "PttHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new int[]{0, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
        this.handler = new Handler(Looper.getMainLooper());
        Fragment c16 = param.a().c();
        Activity activity = null;
        if (c16 != null) {
            context = c16.getContext();
        } else {
            context = null;
        }
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null) {
            AIOPttAudioPlayerManager.f191706d.A(k(activity));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        h.a.b(this);
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        AIOPttAudioPlayerManager.f191706d.A(null);
        QUIStatusToast qUIStatusToast = this.lowVolumeDialog;
        if (qUIStatusToast != null) {
            qUIStatusToast.dismiss();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, state);
            return;
        }
        if (state != 0) {
            if (state != 8) {
                if (state == 12) {
                    i();
                    return;
                }
                return;
            }
            j();
            return;
        }
        h();
    }
}
