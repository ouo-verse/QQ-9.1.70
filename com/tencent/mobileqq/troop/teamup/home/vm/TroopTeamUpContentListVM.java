package com.tencent.mobileqq.troop.teamup.home.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.teamup.home.data.TroopTeamUpData;
import com.tencent.mobileqq.troop.teamup.member.event.TroopTeamUpUpdateEvent;
import com.tencent.mobileqq.troop.utils.p;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 R2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002STB\u0007\u00a2\u0006\u0004\bP\u0010QJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J.\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u0004H\u0014J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010 \u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0\u001dj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e`\u001fH\u0016R-\u0010&\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u001dj\b\u0012\u0004\u0012\u00020\u0012`\u001f0!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020'0!8\u0006\u00a2\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020'0!8\u0006\u00a2\u0006\f\n\u0004\b+\u0010#\u001a\u0004\b,\u0010%R%\u00101\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010'0'0!8\u0006\u00a2\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b0\u0010%R0\u00109\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010?\u001a\u00020'2\u0006\u0010:\u001a\u00020'8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR$\u0010I\u001a\u00020D2\u0006\u0010:\u001a\u00020D8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010N\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "k2", "m2", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTeamDetail;", "teamUpTeamDetail", "j2", "", "teamUpId", "f2", "i2", SemanticAttributes.DbSystemValues.H2, "g2", "errorTag", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/troop/teamup/home/data/TroopTeamUpData;", "doCreateNew", "W1", "Landroid/os/Bundle;", "arguments", "c2", "e2", FeedManager.LOAD_MORE, "onCleared", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Landroidx/lifecycle/MutableLiveData;", "teamUpDataList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d2", "isLoading", BdhLogUtil.LogTag.Tag_Conn, "X1", "showingEmptyView", "kotlin.jvm.PlatformType", "D", "Z1", "showingErrorView", "Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM$b;", "E", "Lkotlin/jvm/functions/Function1;", "getUiActionReceiver", "()Lkotlin/jvm/functions/Function1;", "l2", "(Lkotlin/jvm/functions/Function1;)V", "uiActionReceiver", "<set-?>", UserInfo.SEX_FEMALE, "Z", "getHasMore", "()Z", "hasMore", "", "G", "I", "type", "", "H", "J", "b2", "()J", "troopId", "Lcom/tencent/mobileqq/troop/teamup/home/repo/a;", "Lcom/tencent/mobileqq/troop/teamup/home/repo/a;", "repo", "", "[B", "currentCookie", "<init>", "()V", "K", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpContentListVM extends ViewModel implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String L;

    @NotNull
    private static final ArrayList<Class<SimpleBaseEvent>> M;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> showingEmptyView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> showingErrorView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super b, Unit> uiActionReceiver;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasMore;

    /* renamed from: G, reason: from kotlin metadata */
    private int type;

    /* renamed from: H, reason: from kotlin metadata */
    private long troopId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.teamup.home.repo.a repo;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private byte[] currentCookie;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<ArrayList<TroopTeamUpData>> teamUpDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isLoading;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR0\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM$a;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "EVENT_LISTEN_CLASSES", "Ljava/util/ArrayList;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b6\u0018\u00002\u00020\u0001B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/vm/TroopTeamUpContentListVM$b;", "", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55912);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        INSTANCE = new Companion(null);
        L = "TroopTeamUpListVM";
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(TroopTeamUpUpdateEvent.DeleteTeamUp.class);
        arrayList.add(TroopTeamUpUpdateEvent.StopTimeTeamUp.class);
        arrayList.add(TroopTeamUpUpdateEvent.ApplyTeamUpSuccess.class);
        arrayList.add(TroopTeamUpUpdateEvent.UpdateTeamUp.class);
        arrayList.add(TroopTeamUpUpdateEvent.UpdateJoinTeamUp.class);
        M = arrayList;
    }

    public TroopTeamUpContentListVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        k2();
        this.teamUpDataList = new MutableLiveData<>();
        Boolean bool = Boolean.FALSE;
        this.isLoading = new MutableLiveData<>(bool);
        this.showingEmptyView = new MutableLiveData<>(bool);
        this.showingErrorView = new MutableLiveData<>(bool);
        this.repo = new com.tencent.mobileqq.troop.teamup.home.repo.a();
    }

    private final void W1(String teamUpId, String errorTag, Function1<? super TroopTeamUpData, TroopTeamUpData> doCreateNew) {
        Object orNull;
        ArrayList<TroopTeamUpData> value = this.teamUpDataList.getValue();
        if (value != null) {
            ArrayList<TroopTeamUpData> arrayList = new ArrayList<>(value);
            Iterator<TroopTeamUpData> it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().f(), teamUpId)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, i3);
            TroopTeamUpData troopTeamUpData = (TroopTeamUpData) orNull;
            if (troopTeamUpData == null) {
                com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d(L, errorTag + " " + teamUpId + ", but not found");
                return;
            }
            TroopTeamUpData invoke = doCreateNew.invoke(troopTeamUpData);
            if (invoke == null) {
                arrayList.remove(i3);
            } else {
                arrayList.set(i3, invoke);
            }
            this.teamUpDataList.postValue(arrayList);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.d(L, errorTag + " " + teamUpId + ", teamUpDataList.value is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f2(String teamUpId) {
        W1(teamUpId, "onApplySuccess", TroopTeamUpContentListVM$onApplySuccess$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(String teamUpId) {
        W1(teamUpId, "onDeleteTeamUp", TroopTeamUpContentListVM$onDeleteTeamUp$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(String teamUpId) {
        W1(teamUpId, "onStopTeamUp", TroopTeamUpContentListVM$onStopTeamUp$1.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2(final TeamUpTeamDetail teamUpTeamDetail) {
        String str = teamUpTeamDetail.teamId;
        Intrinsics.checkNotNullExpressionValue(str, "teamUpTeamDetail.teamId");
        W1(str, "onUpdateJoinCnt", new Function1<TroopTeamUpData, TroopTeamUpData>() { // from class: com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM$onUpdateJoinCnt$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TeamUpTeamDetail.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final TroopTeamUpData invoke(@NotNull TroopTeamUpData it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (TroopTeamUpData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                return TroopTeamUpData.b(it, null, null, null, null, TeamUpTeamDetail.this.joinedCnt, 0, false, null, false, 495, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j2(final TeamUpTeamDetail teamUpTeamDetail) {
        if (teamUpTeamDetail == null) {
            return;
        }
        String str = teamUpTeamDetail.teamId;
        Intrinsics.checkNotNullExpressionValue(str, "teamUpTeamDetail.teamId");
        W1(str, "onUpdateTeamUpDetail", new Function1<TroopTeamUpData, TroopTeamUpData>(teamUpTeamDetail) { // from class: com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM$onUpdateTeamUpDetail$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TeamUpTeamDetail $teamUpTeamDetail;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$teamUpTeamDetail = teamUpTeamDetail;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopTeamUpContentListVM.this, (Object) teamUpTeamDetail);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final TroopTeamUpData invoke(@NotNull TroopTeamUpData it) {
                com.tencent.mobileqq.troop.teamup.home.repo.a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (TroopTeamUpData) iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                }
                Intrinsics.checkNotNullParameter(it, "it");
                aVar = TroopTeamUpContentListVM.this.repo;
                TeamUpTeamDetail teamUpTeamDetail2 = this.$teamUpTeamDetail;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String account = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
                if (account == null) {
                    account = "";
                }
                return aVar.f(teamUpTeamDetail2, account);
            }
        });
    }

    private final void k2() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void m2() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @NotNull
    public final MutableLiveData<Boolean> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.showingEmptyView;
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.showingErrorView;
    }

    @NotNull
    public final MutableLiveData<ArrayList<TroopTeamUpData>> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.teamUpDataList;
    }

    public final long b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this)).longValue();
        }
        return this.troopId;
    }

    public final void c2(@NotNull Bundle arguments) {
        Long longOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) arguments);
            return;
        }
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.type = arguments.getInt("type", 0);
        String string = arguments.getString("troop_id", "");
        Intrinsics.checkNotNullExpressionValue(string, "arguments.getString(\n   \u2026\n            \"\"\n        )");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string);
        if (longOrNull != null) {
            this.troopId = longOrNull.longValue();
            e2();
        } else {
            QQToastUtil.showQQToastInUiThread(1, "\u7fa4\u4e0d\u5b58\u5728");
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.isLoading;
    }

    public final void e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a(L, "loadFirstPage");
        this.isLoading.postValue(Boolean.TRUE);
        this.showingEmptyView.postValue(Boolean.FALSE);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopTeamUpContentListVM$loadFirstPage$1(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ArrayList) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return M;
    }

    public final boolean getHasMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.hasMore;
    }

    public final void l2(@Nullable Function1<? super b, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) function1);
        } else {
            this.uiActionReceiver = function1;
        }
    }

    public final void loadMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a aVar = com.tencent.mobileqq.troop.teamup.home.common.a.f298968a;
        String str = L;
        aVar.a(str, FeedManager.LOAD_MORE);
        this.isLoading.postValue(Boolean.TRUE);
        byte[] bArr = this.currentCookie;
        if (bArr != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopTeamUpContentListVM$loadMore$1(this, bArr, null), 3, null);
        } else {
            aVar.a(str, "loadMore but cookie is null ,return");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onCleared();
            m2();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) event);
            return;
        }
        com.tencent.mobileqq.troop.teamup.home.common.a.f298968a.a(L, "onReceiveEvent:" + event);
        p.f302196a.b(new Function0<Unit>(this) { // from class: com.tencent.mobileqq.troop.teamup.home.vm.TroopTeamUpContentListVM$onReceiveEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopTeamUpContentListVM this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SimpleBaseEvent.this, (Object) this);
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
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                SimpleBaseEvent simpleBaseEvent = SimpleBaseEvent.this;
                if (simpleBaseEvent instanceof TroopTeamUpUpdateEvent.StopTimeTeamUp) {
                    this.this$0.h2(((TroopTeamUpUpdateEvent.StopTimeTeamUp) simpleBaseEvent).getTeamUpId());
                    return;
                }
                if (simpleBaseEvent instanceof TroopTeamUpUpdateEvent.DeleteTeamUp) {
                    this.this$0.g2(((TroopTeamUpUpdateEvent.DeleteTeamUp) simpleBaseEvent).getTeamUpId());
                    return;
                }
                if (simpleBaseEvent instanceof TroopTeamUpUpdateEvent.ApplyTeamUpSuccess) {
                    this.this$0.f2(((TroopTeamUpUpdateEvent.ApplyTeamUpSuccess) simpleBaseEvent).getTeamUpId());
                } else if (simpleBaseEvent instanceof TroopTeamUpUpdateEvent.UpdateTeamUp) {
                    this.this$0.j2(((TroopTeamUpUpdateEvent.UpdateTeamUp) simpleBaseEvent).getTeamUpTeamDetail());
                } else if (simpleBaseEvent instanceof TroopTeamUpUpdateEvent.UpdateJoinTeamUp) {
                    this.this$0.i2(((TroopTeamUpUpdateEvent.UpdateJoinTeamUp) simpleBaseEvent).getTeamUpTeamDetail());
                }
            }
        });
    }
}
