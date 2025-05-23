package com.tencent.mobileqq.troop.shortcut.vm;

import a54.a;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.actions.TroopShortcutAction;
import com.tencent.mobileqq.troop.shortcut.aio.ShortcutMessage;
import com.tencent.mobileqq.troop.shortcut.api.impl.TroopShortcutApiImpl;
import com.tencent.mobileqq.troop.shortcut.data.TroopShortcutInfo;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutRepository;
import com.tencent.mobileqq.troop.shortcut.repo.TroopShortcutSettingCache;
import com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM;
import com.tencent.mobileqq.troop.troopapps.event.UpdateBindGuildEvent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.e;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ab;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.relation.api.IRobotRelationService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\t*\u0005CGKOR\u0018\u0000 X2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0018\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0019\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00170\u0016j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0017`\u0018H\u0016J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aJ\"\u0010!\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001fJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\u001dR-\u0010*\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020%0\u0016j\b\u0012\u0004\u0012\u00020%`\u00180$8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R%\u0010.\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u001d0\u001d0$8\u0006\u00a2\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R*\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010B\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "R1", "", "b2", "", "S1", "Lcom/tencent/mvi/base/route/j;", "messenger", ICustomDataEditor.STRING_ARRAY_PARAM_2, "c2", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/robot/relation/api/IRobotRelationService;", "P1", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "T1", "", "forceNet", "Lkotlin/Function0;", "callback", "X1", "destroy", "W1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/shortcut/data/TroopShortcutInfo;", "i", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "shortCutListLiveData", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "U1", "isSettingEnabled", "Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutRepository;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/shortcut/repo/TroopShortcutRepository;", "repo", "D", "Ljava/util/HashSet;", "cachedShownRobotUin", "E", "Lcom/tencent/aio/api/runtime/a;", "N1", "()Lcom/tencent/aio/api/runtime/a;", "setAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", UserInfo.SEX_FEMALE, "J", "O1", "()J", "setGroupId", "(J)V", "groupId", "com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$troopObserver$1", "G", "Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$troopObserver$1;", "troopObserver", "com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$robotObserver$1", "H", "Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$robotObserver$1;", "robotObserver", "com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$d", "I", "Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$d;", "troopInfoObserver", "com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$c", "Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$c;", "settingCacheObserver", "com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$b", "K", "Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$b;", "messageAction", "<init>", "()V", "L", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopShortcutVM extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TroopShortcutRepository repo;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private HashSet<String> cachedShownRobotUin;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: F, reason: from kotlin metadata */
    private long groupId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TroopShortcutVM$troopObserver$1 troopObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final TroopShortcutVM$robotObserver$1 robotObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final d troopInfoObserver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final c settingCacheObserver;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b messageAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<TroopShortcutInfo>> shortCutListLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isSettingEnabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            ArrayList<TroopShortcutInfo> value;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
                return;
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof ShortcutMessage.OnSubmenuShown) {
                ArrayList<TroopShortcutInfo> value2 = TroopShortcutVM.this.Q1().getValue();
                if (value2 == null) {
                    return;
                }
                for (TroopShortcutInfo troopShortcutInfo : value2) {
                    if (troopShortcutInfo == ((ShortcutMessage.OnSubmenuShown) i3).a()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    troopShortcutInfo.i(z16);
                }
                TroopShortcutVM.this.Q1().postValue(value2);
                return;
            }
            if (!(i3 instanceof ShortcutMessage.OnSubmenuHide) || (value = TroopShortcutVM.this.Q1().getValue()) == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : value) {
                if (((TroopShortcutInfo) obj).h()) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((TroopShortcutInfo) it.next()).i(false);
            }
            TroopShortcutVM.this.Q1().postValue(value);
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
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$c", "Lkotlin/Function1;", "", "", "troopUin", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements Function1<Long, Unit> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutVM.this);
            }
        }

        public void a(long troopUin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, troopUin);
            } else {
                if (troopUin != TroopShortcutVM.this.O1()) {
                    return;
                }
                TroopShortcutVM.this.U1().postValue(Boolean.valueOf(!TroopShortcutSettingCache.INSTANCE.a().d(troopUin)));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
            a(l3.longValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/troop/shortcut/vm/TroopShortcutVM$d", "Lcom/tencent/qqnt/troop/ab;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "a", "", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "e", "(Ljava/lang/Long;)V", "cachedGroupType", "", "b", "Z", "getGroupExitOrBlocked", "()Z", "setGroupExitOrBlocked", "(Z)V", "groupExitOrBlocked", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements ab {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Long cachedGroupType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean groupExitOrBlocked;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopShortcutVM.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(TroopInfo troopInfo, d this$0, TroopShortcutVM this$1) {
            boolean z16;
            Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!troopInfo.isExited() && !troopInfo.isTroopBlocked) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (this$0.groupExitOrBlocked != z16) {
                TroopShortcutVM.Z1(this$1, true, null, 2, null);
                this$0.groupExitOrBlocked = z16;
                return;
            }
            Long l3 = this$0.cachedGroupType;
            long j3 = troopInfo.dwGroupClassExt;
            if (l3 != null && l3.longValue() == j3) {
                QLog.i("TroopShortcutVM", 1, "group type not changed: " + this$1.O1() + " is " + this$0.c());
                return;
            }
            QLog.i("TroopShortcutVM", 1, "group type changed: " + this$1.O1() + " from " + this$0.c() + " to " + troopInfo.dwGroupClassExt);
            this$0.cachedGroupType = Long.valueOf(troopInfo.dwGroupClassExt);
            TroopShortcutVM.Z1(this$1, false, null, 2, null);
        }

        @Override // com.tencent.qqnt.troop.ab
        public void a(@NotNull final TroopInfo troopInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) troopInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            if (!Intrinsics.areEqual(troopInfo.getTroopUin(), String.valueOf(TroopShortcutVM.this.O1()))) {
                return;
            }
            final TroopShortcutVM troopShortcutVM = TroopShortcutVM.this;
            e.i(new Runnable() { // from class: com.tencent.mobileqq.troop.shortcut.vm.c
                @Override // java.lang.Runnable
                public final void run() {
                    TroopShortcutVM.d.d(TroopInfo.this, this, troopShortcutVM);
                }
            });
        }

        @Nullable
        public final Long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Long) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.cachedGroupType;
        }

        public final void e(@Nullable Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) l3);
            } else {
                this.cachedGroupType = l3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55362);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM$troopObserver$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM$robotObserver$1] */
    public TroopShortcutVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.shortCutListLiveData = new MutableLiveData<>(new ArrayList());
        this.isSettingEnabled = new MutableLiveData<>(Boolean.TRUE);
        this.troopObserver = new com.tencent.mobileqq.troop.api.observer.e() { // from class: com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM$troopObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopShortcutVM.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.api.observer.e
            protected void onDeleteTroopMember(boolean isSuccess, int errorCode, @Nullable ArrayList<String> uinList, @Nullable String troopUin) {
                int collectionSizeOrDefault;
                boolean any;
                HashSet R1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(errorCode), uinList, troopUin);
                    return;
                }
                if (isSuccess && Intrinsics.areEqual(troopUin, String.valueOf(TroopShortcutVM.this.O1())) && uinList != null) {
                    TroopShortcutVM troopShortcutVM = TroopShortcutVM.this;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(uinList, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (String str : uinList) {
                        R1 = troopShortcutVM.R1();
                        arrayList.add(Boolean.valueOf(R1.contains(str)));
                    }
                    any = CollectionsKt___CollectionsKt.any(arrayList);
                    Boolean valueOf = Boolean.valueOf(any);
                    final TroopShortcutVM troopShortcutVM2 = TroopShortcutVM.this;
                    au.b(valueOf, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM$troopObserver$1$onDeleteTroopMember$2
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) TroopShortcutVM.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                TroopShortcutVM.Z1(TroopShortcutVM.this, true, null, 2, null);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        };
        this.robotObserver = new a54.a() { // from class: com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM$robotObserver$1
            @Override // a54.a
            public void a(@NotNull String str) {
                a.C0013a.e(this, str);
            }

            @Override // a54.a
            public void b(@NotNull String str) {
                a.C0013a.d(this, str);
            }

            @Override // a54.a
            public void c(@NotNull String str) {
                a.C0013a.a(this, str);
            }

            @Override // a54.a
            public void d(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
                a.C0013a.c(this, str, str2, obj);
            }

            @Override // a54.a
            public void e(@NotNull String str, @NotNull String str2, @Nullable Object obj) {
                a.C0013a.b(this, str, str2, obj);
            }

            @Override // a54.a
            public void f(@NotNull String robotUin, @NotNull String troopUin) {
                HashSet R1;
                Intrinsics.checkNotNullParameter(robotUin, "robotUin");
                Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                a.C0013a.f(this, robotUin, troopUin);
                if (TroopShortcutVM.this.N1() != null && Intrinsics.areEqual(troopUin, String.valueOf(TroopShortcutVM.this.O1()))) {
                    R1 = TroopShortcutVM.this.R1();
                    Boolean valueOf = Boolean.valueOf(R1.contains(robotUin));
                    final TroopShortcutVM troopShortcutVM = TroopShortcutVM.this;
                    au.b(valueOf, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.shortcut.vm.TroopShortcutVM$robotObserver$1$onRemoveRobotFromTroopSuccess$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            TroopShortcutVM.Z1(TroopShortcutVM.this, true, null, 2, null);
                        }
                    });
                }
            }
        };
        this.troopInfoObserver = new d();
        this.settingCacheObserver = new c();
        this.messageAction = new b();
    }

    private final IRobotRelationService P1(AppInterface app) {
        IRuntimeService runtimeService = app.getRuntimeService(IRobotRelationService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        return (IRobotRelationService) runtimeService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<String> R1() {
        HashSet<String> hashSet;
        TroopShortcutAction a16;
        HashSet<String> hashSet2 = this.cachedShownRobotUin;
        if (hashSet2 == null) {
            ArrayList<TroopShortcutInfo> value = this.shortCutListLiveData.getValue();
            if (value == null) {
                QLog.e("TroopShortcutVM", 1, "value in live data is null");
                return new HashSet<>();
            }
            Intrinsics.checkNotNullExpressionValue(value, "shortCutListLiveData.val\u2026hashSetOf()\n            }");
            ArrayList arrayList = new ArrayList();
            for (TroopShortcutInfo troopShortcutInfo : value) {
                String str = null;
                if (troopShortcutInfo.g() == TroopShortcutInfo.AppType.TYPE_ROBOT && (a16 = troopShortcutInfo.a()) != null) {
                    str = a16.c();
                }
                if (str != null) {
                    arrayList.add(str);
                }
            }
            hashSet = CollectionsKt___CollectionsKt.toHashSet(arrayList);
            this.cachedShownRobotUin = hashSet;
            return hashSet;
        }
        return hashSet2;
    }

    private final long S1() {
        String str;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        try {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
                str = "0";
            }
            return Long.parseLong(str);
        } catch (Exception e16) {
            QLog.e("TroopShortcutVM", 1, "getTroopUinNoEmpty is Exception:" + e16);
            return 0L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Z1(TroopShortcutVM troopShortcutVM, boolean z16, Function0 function0, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        troopShortcutVM.X1(z16, function0);
    }

    private final void a2(j messenger) {
        AppInterface appInterface;
        messenger.d(Reflection.getOrCreateKotlinClass(ShortcutMessage.OnSubmenuShown.class).getQualifiedName(), this.messageAction);
        messenger.d(Reflection.getOrCreateKotlinClass(ShortcutMessage.OnSubmenuHide.class).getQualifiedName(), this.messageAction);
        SimpleEventBus.getInstance().registerReceiver(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        appInterface.addObserver(this.troopObserver);
        P1(appInterface).addRelationObserver(this.robotObserver);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).registerTroopInfoChangedObserver(null, this.troopInfoObserver);
        TroopShortcutSettingCache.INSTANCE.a().c().add(this.settingCacheObserver);
    }

    private final void b2() {
        Long l3 = null;
        this.cachedShownRobotUin = null;
        this.groupId = S1();
        TroopShortcutRepository troopShortcutRepository = new TroopShortcutRepository(this.groupId);
        this.repo = troopShortcutRepository;
        d dVar = this.troopInfoObserver;
        if (troopShortcutRepository.e() != null) {
            l3 = Long.valueOf(r1.intValue());
        }
        dVar.e(l3);
    }

    private final void c2() {
        AppInterface appInterface;
        j e16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(ShortcutMessage.OnSubmenuShown.class).getQualifiedName(), this.messageAction);
            e16.b(Reflection.getOrCreateKotlinClass(ShortcutMessage.OnSubmenuHide.class).getQualifiedName(), this.messageAction);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        appInterface.removeObserver(this.troopObserver);
        P1(appInterface).removeRelationObserver(this.robotObserver);
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).unregisterTroopInfoChangedObserver(this.troopInfoObserver);
        TroopShortcutSettingCache.INSTANCE.a().c().remove(this.settingCacheObserver);
    }

    @Nullable
    public final com.tencent.aio.api.runtime.a N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.api.runtime.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.aioContext;
    }

    public final long O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.groupId;
    }

    @NotNull
    public final MutableLiveData<ArrayList<TroopShortcutInfo>> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.shortCutListLiveData;
    }

    public final void T1(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.aioContext = aioContext;
        b2();
        j e16 = aioContext.e();
        Intrinsics.checkNotNullExpressionValue(e16, "aioContext.messenger");
        a2(e16);
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a("TroopShortcutVM", "init for group: " + this.groupId);
    }

    @NotNull
    public final MutableLiveData<Boolean> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.isSettingEnabled;
    }

    public final boolean W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        ArrayList<TroopShortcutInfo> value = this.shortCutListLiveData.getValue();
        Object obj = null;
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((TroopShortcutInfo) next).h()) {
                    obj = next;
                    break;
                }
            }
            obj = (TroopShortcutInfo) obj;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    public final void X1(boolean forceNet, @Nullable Function0<Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(forceNet), callback);
            return;
        }
        TroopShortcutRepository troopShortcutRepository = this.repo;
        if (troopShortcutRepository == null) {
            QLog.e("TroopShortcutVM", 1, "repo not init");
        } else {
            troopShortcutRepository.h(true, forceNet, new TroopShortcutVM$loadData$1(this, callback));
        }
    }

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            c2();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateBindGuildEvent.class, TroopShortcutApiImpl.ShortcutUpdateEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) event);
            return;
        }
        if (event instanceof UpdateBindGuildEvent) {
            Z1(this, true, null, 2, null);
            return;
        }
        if (event instanceof TroopShortcutApiImpl.ShortcutUpdateEvent) {
            TroopShortcutApiImpl.ShortcutUpdateEvent shortcutUpdateEvent = (TroopShortcutApiImpl.ShortcutUpdateEvent) event;
            Long troopUin = shortcutUpdateEvent.getTroopUin();
            long j3 = this.groupId;
            if ((troopUin == null || troopUin.longValue() != j3) && shortcutUpdateEvent.getTroopUin() != null) {
                return;
            }
            Z1(this, true, null, 2, null);
            return;
        }
        QLog.e("TroopShortcutVM", 1, "unknown event: " + event);
    }
}
