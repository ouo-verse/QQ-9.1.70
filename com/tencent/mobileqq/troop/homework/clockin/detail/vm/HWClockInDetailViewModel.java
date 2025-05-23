package com.tencent.mobileqq.troop.homework.clockin.detail.vm;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.clockin.HWClockInDetailEvent;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailMoreActionUseCase;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailUserCase;
import com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.b;
import com.tencent.mobileqq.troop.homework.clockin.submit.HWSubmitClockInFragment;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.base.mvi.BaseViewModel;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import com.tencent.qqnt.troopmemberlist.g;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 L2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001MB\u000f\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KJ\u0018\u0010\n\u001a\u00020\t2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0003H\u0017J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050 `!H\u0016J\b\u0010#\u001a\u00020\tH\u0014R\u001a\u0010)\u001a\u00020$8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010/\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0017\u00105\u001a\u0002008\u0006\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u001c\u00108\u001a\n 6*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010,R\u001c\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010G\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel;", "Lcom/tencent/qqnt/base/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "logicParentViewRef", "", "f2", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/widget/date/data/a;", "date", "c2", "d2", "g2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "data", "e2", "", "uin", "", "U1", "(Ljava/lang/Long;)Z", SemanticAttributes.DbSystemValues.H2, "userIntent", "b2", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "Z1", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onCleared", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/b$e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/b$e;", "X1", "()Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/b$e;", "mNoneValueIntent", "", "D", "Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "E", "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "W1", "()Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "from", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "clockInId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "G", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_isTeacher", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailUserCase;", "H", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailUserCase;", "detailUserCase", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/e;", "I", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/e;", "listUseCase", "J", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "detailData", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "K", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailViewModel extends BaseViewModel<a, com.tencent.mobileqq.troop.homework.clockin.detail.vm.b> implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b.e mNoneValueIntent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final IHWTroopUIApi.DetailPageFrom from;

    /* renamed from: F, reason: from kotlin metadata */
    private final String clockInId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Boolean> _isTeacher;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final HWClockInDetailUserCase detailUserCase;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private e listUseCase;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private GroupSchoolTaskData detailData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/detail/vm/HWClockInDetailViewModel$b", "Lcom/tencent/qqnt/troopmemberlist/g;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "selfInfo", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements g {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInDetailViewModel.this);
            }
        }

        @Override // com.tencent.qqnt.troopmemberlist.g
        public void a(@Nullable TroopMemberInfo selfInfo) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MutableStateFlow mutableStateFlow = HWClockInDetailViewModel.this._isTeacher;
                boolean z18 = true;
                if (selfInfo != null && selfInfo.getHWIdentity() == 332) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (selfInfo != null && selfInfo.getHWIdentity() == 333) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        z18 = false;
                    }
                }
                mutableStateFlow.setValue(Boolean.valueOf(z18));
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) selfInfo);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42670);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInDetailViewModel(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.mNoneValueIntent = b.e.f296414a;
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWClockInArgKey.TROOP_UIN, \"\")");
        this.troopUin = string;
        Serializable serializable = bundle.getSerializable("detail_from");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi.DetailPageFrom");
        this.from = (IHWTroopUIApi.DetailPageFrom) serializable;
        String clockInId = bundle.getString("clock_in_id", "");
        this.clockInId = clockInId;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._isTeacher = MutableStateFlow;
        Intrinsics.checkNotNullExpressionValue(clockInId, "clockInId");
        this.detailUserCase = new HWClockInDetailUserCase(string, clockInId, ViewModelKt.getViewModelScope(this), getMUiState(), MutableStateFlow, new Function1<GroupSchoolTaskData, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.vm.HWClockInDetailViewModel$detailUserCase$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInDetailViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupSchoolTaskData groupSchoolTaskData) {
                invoke2(groupSchoolTaskData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GroupSchoolTaskData it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    HWClockInDetailViewModel.this.e2(it);
                }
            }
        });
        SimpleEventBus.getInstance().registerReceiver(this);
        h2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U1(Long uin) {
        String str;
        String str2 = null;
        if (uin != null) {
            str = uin.toString();
        } else {
            str = null;
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str2 = e16.getCurrentAccountUin();
        }
        return Intrinsics.areEqual(str, str2);
    }

    private final void c2(com.tencent.mobileqq.troop.homework.clockin.detail.widget.date.data.a date) {
        e eVar = this.listUseCase;
        if (eVar != null) {
            e.b.a(eVar, date.f(), null, 2, null);
        }
    }

    private final void d2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new HWClockInDetailViewModel$handleOnNotifyClockIn$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(GroupSchoolTaskData data) {
        QLog.i("HW.ClockIn.DETAIL.", 1, "SchoolPartner Notice list page checkin data loading complete");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HWClockInDetailViewModel$handleTaskData$2(this, data, null), 3, null);
    }

    private final void f2(WeakReference<View> logicParentViewRef) {
        e eVar = this.listUseCase;
        if (eVar != null) {
            long a16 = eVar.a();
            boolean d16 = com.tencent.mobileqq.troop.homework.clockin.c.f296281a.d(a16);
            HWSubmitClockInFragment.Companion companion = HWSubmitClockInFragment.INSTANCE;
            String str = this.troopUin;
            String clockInId = this.clockInId;
            Intrinsics.checkNotNullExpressionValue(clockInId, "clockInId");
            HWSubmitClockInFragment.Companion.b(companion, str, clockInId, a16, !d16, null, logicParentViewRef, 16, null);
        }
    }

    private final void g2() {
        e eVar = this.listUseCase;
        if (eVar != null) {
            eVar.b(eVar.a(), Boolean.TRUE);
        }
    }

    private final void h2() {
        AppInterface e16 = bg.e();
        if (e16 == null) {
            return;
        }
        TroopMemberListRepo.INSTANCE.fetchTroopMemberInfoWithExtInfo(this.troopUin, e16.getCurrentAccountUin(), false, null, "HWClockInDetailViewModel", new b());
    }

    @NotNull
    public final IHWTroopUIApi.DetailPageFrom W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IHWTroopUIApi.DetailPageFrom) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.from;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @NotNull
    /* renamed from: X1, reason: merged with bridge method [inline-methods] */
    public b.e getMNoneValueIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b.e) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mNoneValueIntent;
    }

    @NotNull
    public final f Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (f) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.detailUserCase.g();
    }

    @NotNull
    public final String a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopUin;
    }

    @Override // com.tencent.qqnt.base.mvi.BaseViewModel
    @ExperimentalCoroutinesApi
    /* renamed from: b2, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.troop.homework.clockin.detail.vm.b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof b.c) {
            this.detailUserCase.i();
            return;
        }
        if (userIntent instanceof b.d) {
            e eVar = this.listUseCase;
            if (eVar != null) {
                eVar.loadMore();
                return;
            }
            return;
        }
        if (userIntent instanceof b.C8708b) {
            f2(((b.C8708b) userIntent).a());
            return;
        }
        if (userIntent instanceof b.g) {
            new HWClockInDetailMoreActionUseCase(((b.g) userIntent).a(), this.troopUin, this.detailData, getMUiState()).n();
        } else if (userIntent instanceof b.a) {
            c2(((b.a) userIntent).a());
        } else if (userIntent instanceof b.f) {
            d2();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWClockInDetailEvent.SubmitClockInSuc.class, HWClockInDetailEvent.UpdateUnClockInCount.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.base.mvi.BaseViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onCleared();
        this.detailUserCase.e();
        com.tencent.mobileqq.troop.homework.utils.b.a();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
        } else if (event instanceof HWClockInDetailEvent.SubmitClockInSuc) {
            g2();
        } else if (event instanceof HWClockInDetailEvent.UpdateUnClockInCount) {
            this.detailUserCase.l(((HWClockInDetailEvent.UpdateUnClockInCount) event).getCount());
        }
    }
}
