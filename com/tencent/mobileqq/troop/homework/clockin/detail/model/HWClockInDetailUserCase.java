package com.tencent.mobileqq.troop.homework.clockin.detail.model;

import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.detail.vm.a;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditFoldView;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u0016B`\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0$\u0012!\u0010,\u001a\u001d\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040'\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J \u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0007J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0004R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001c\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010%R/\u0010,\u001a\u001d\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010+R\u001a\u00101\u001a\u00020-8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b.\u00100R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00103R\u001c\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010%R\u001c\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailUserCase;", "", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/i;", "result", "", tl.h.F, "", "text", "", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "k", "j", "", "isTeacher", "", "authorUin", "height", "f", "i", "count", "l", "e", "a", "Ljava/lang/String;", "troopUin", "b", "clockInId", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a;", "d", "Landroidx/lifecycle/MutableLiveData;", "uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_isTeacher", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function1;", "detailCallback", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/c;", "g", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/c;", "()Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/c;", "mediaEditManager", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailRepo;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailRepo;", "repo", "_authorUin", "_mediaContentHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlinx/coroutines/CoroutineScope;Landroidx/lifecycle/MutableLiveData;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInDetailUserCase {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String clockInId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Boolean> _isTeacher;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<GroupSchoolTaskData, Unit> detailCallback;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.c mediaEditManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HWClockInDetailRepo repo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Long> _authorUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableStateFlow<Integer> _mediaContentHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/HWClockInDetailUserCase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailUserCase$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41764);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInDetailUserCase(@NotNull String troopUin, @NotNull String clockInId, @NotNull CoroutineScope scope, @NotNull MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState, @NotNull MutableStateFlow<Boolean> _isTeacher, @NotNull Function1<? super GroupSchoolTaskData, Unit> detailCallback) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(clockInId, "clockInId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(_isTeacher, "_isTeacher");
        Intrinsics.checkNotNullParameter(detailCallback, "detailCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, clockInId, scope, uiState, _isTeacher, detailCallback);
            return;
        }
        this.troopUin = troopUin;
        this.clockInId = clockInId;
        this.scope = scope;
        this.uiState = uiState;
        this._isTeacher = _isTeacher;
        this.detailCallback = detailCallback;
        this.mediaEditManager = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.c(troopUin, scope, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.detail.model.HWClockInDetailUserCase$mediaEditManager$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInDetailUserCase.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                MutableStateFlow mutableStateFlow;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                } else {
                    mutableStateFlow = HWClockInDetailUserCase.this._mediaContentHeight;
                    mutableStateFlow.setValue(Integer.valueOf(i3));
                }
            }
        });
        this.repo = new HWClockInDetailRepo();
        this._authorUin = StateFlowKt.MutableStateFlow(null);
        this._mediaContentHeight = StateFlowKt.MutableStateFlow(null);
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f(boolean isTeacher, long authorUin, int height) {
        String str;
        if (QLog.isDebugVersion()) {
            QLog.d("HW.ClockIn.DETAIL.HWClockInDetailUserCase", 4, "getMediaContentFoldState, " + isTeacher + "-" + authorUin + "-" + height);
        }
        if (height < HWMediaEditFoldView.C) {
            return false;
        }
        if (!isTeacher) {
            String valueOf = String.valueOf(authorUin);
            AppInterface e16 = bg.e();
            if (e16 != null) {
                str = e16.getCurrentAccountUin();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual(valueOf, str)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(i result) {
        GroupSchoolTaskData b16;
        if (result.a() != 10009) {
            GroupSchoolTaskData b17 = result.b();
            boolean z16 = false;
            if (b17 != null && b17.status == 2) {
                z16 = true;
            }
            if (!z16) {
                if (!result.c()) {
                    String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(result.a());
                    if (a16 == null) {
                        k("\u6682\u65e0\u5185\u5bb9", 8);
                        return;
                    } else {
                        k(a16, 16);
                        QQToastUtil.showQQToastInUiThread(1, a16);
                        return;
                    }
                }
                if (!result.c()) {
                    result = null;
                }
                if (result != null && (b16 = result.b()) != null) {
                    this.mediaEditManager.x(b16);
                    this._authorUin.setValue(Long.valueOf(b16.authorUin));
                    this.detailCallback.invoke(b16);
                    return;
                }
                return;
            }
        }
        k("\u6253\u5361\u5df2\u88ab\u5220\u9664\uff0c\u8bf7\u8054\u7cfb\u8001\u5e08\u6216\u7ba1\u7406\u5458", 16);
        QQToastUtil.showQQToastInUiThread(1, "\u6253\u5361\u4efb\u52a1\u5df2\u88ab\u5220\u9664");
    }

    private final void j() {
        FlowKt.launchIn(FlowKt.onCompletion(FlowKt.onStart(FlowKt.onEach(FlowKt.distinctUntilChanged(FlowKt.combine(FlowKt.filterNotNull(this._isTeacher), FlowKt.filterNotNull(this._authorUin), FlowKt.filterNotNull(this._mediaContentHeight), new HWClockInDetailUserCase$updateDetailFoldState$1(this, null))), new HWClockInDetailUserCase$updateDetailFoldState$2(this, null)), new HWClockInDetailUserCase$updateDetailFoldState$3(null)), new HWClockInDetailUserCase$updateDetailFoldState$4(null)), this.scope);
    }

    private final void k(String text, int imageType) {
        this.uiState.postValue(new a.j(text, imageType));
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mediaEditManager.i();
        }
    }

    @NotNull
    public final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.c g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mediaEditManager;
    }

    @ExperimentalCoroutinesApi
    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            FlowKt.launchIn(FlowKt.onCompletion(FlowKt.m2026catch(FlowKt.onEach(this.repo.a(this.troopUin, this.clockInId), new HWClockInDetailUserCase$initData$1(this, null)), new HWClockInDetailUserCase$initData$2(null)), new HWClockInDetailUserCase$initData$3(null)), this.scope);
        }
    }

    public final void l(int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, count);
        } else {
            this.mediaEditManager.D(count);
        }
    }
}
