package com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.c;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.a;
import com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.ui.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 L2\u00020\u0001:\u0002MNB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007R\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8\u0006\u00a2\u0006\f\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#R$\u0010/\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010,R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00109\u001a\u000606R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0017\u0010?\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R*\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00105\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0013\u0010I\u001a\u0004\u0018\u00010F8F\u00a2\u0006\u0006\u001a\u0004\bG\u0010H\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel;", "Landroidx/lifecycle/ViewModel;", "", "b2", "onCleared", "Lcom/tencent/common/app/AppInterface;", "app", "", "troopUin", "Z1", "newName", "Lkotlin/Function0;", "onEditFinish", "c2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/ui/h;", "i", "Landroidx/lifecycle/MutableLiveData;", "_uiState", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "uiState", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", BdhLogUtil.LogTag.Tag_Conn, "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_errorToastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "D", "Lkotlinx/coroutines/flow/SharedFlow;", "Q1", "()Lkotlinx/coroutines/flow/SharedFlow;", "errorToastEvent", "E", "_setDefaultAvatarEvent", UserInfo.SEX_FEMALE, "S1", "setDefaultAvatarEvent", "<set-?>", "G", "Ljava/lang/String;", "U1", "()Ljava/lang/String;", "tmpTroopName", "H", "originTroopName", "I", "Lcom/tencent/common/app/AppInterface;", "J", "Lkotlin/jvm/functions/Function0;", "Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel$b;", "K", "Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel$b;", "modifyInfoObserver", "Lcom/tencent/mobileqq/troop/avatar/TroopPhotoController$d;", "L", "Lcom/tencent/mobileqq/troop/avatar/TroopPhotoController$d;", "T1", "()Lcom/tencent/mobileqq/troop/avatar/TroopPhotoController$d;", "setDefaultAvatarObserver", "M", "R1", "()Lkotlin/jvm/functions/Function0;", "d2", "(Lkotlin/jvm/functions/Function0;)V", "onSetDefaultAvatarSucceed", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "W1", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "<init>", "()V", "N", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopModifyBaseInfoViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableSharedFlow<Integer> _errorToastEvent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<Integer> errorToastEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableSharedFlow<Integer> _setDefaultAvatarEvent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final SharedFlow<Integer> setDefaultAvatarEvent;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String tmpTroopName;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private String originTroopName;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final AppInterface app;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onEditFinish;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final b modifyInfoObserver;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TroopPhotoController.d setDefaultAvatarObserver;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onSetDefaultAvatarSucceed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<h> _uiState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<h> uiState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.viewmodel.TroopModifyBaseInfoViewModel$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel$b;", "Lcom/tencent/mobileqq/troop/api/observer/c;", "", "isSuccess", "", "troopUin", "newName", "errorMsg", "", QzoneIPCModule.RESULT_CODE, "", "b", "<init>", "(Lcom/tencent/mobileqq/troop/troopsetting/modules/modifyinfo/viewmodel/TroopModifyBaseInfoViewModel;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b extends c {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoViewModel.this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
        @Override // com.tencent.mobileqq.troop.api.observer.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean isSuccess, @Nullable String troopUin, @Nullable String newName, @Nullable String errorMsg, int resultCode) {
            boolean z16;
            boolean isBlank;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), troopUin, newName, errorMsg, Integer.valueOf(resultCode));
                return;
            }
            QLog.d("TroopModifyBaseInfoViewModel", 1, "modifyTroopName: isSucceed: " + isSuccess + ", newTroopName: " + newName);
            if (isSuccess) {
                if (newName != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(newName);
                    if (!isBlank) {
                        z16 = false;
                        if (!z16) {
                            TroopInfo W1 = TroopModifyBaseInfoViewModel.this.W1();
                            if (W1 != null) {
                                TroopModifyBaseInfoViewModel troopModifyBaseInfoViewModel = TroopModifyBaseInfoViewModel.this;
                                W1.troopname = newName;
                                W1.hasSetNewTroopName = true;
                                W1.isNewTroop = false;
                                troopModifyBaseInfoViewModel._uiState.setValue(new h(false, W1));
                            }
                            Function0 function0 = TroopModifyBaseInfoViewModel.this.onEditFinish;
                            if (function0 != null) {
                                function0.invoke();
                                return;
                            }
                            return;
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
            TroopModifyBaseInfoViewModel.this.b2();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60371);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopModifyBaseInfoViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<h> mutableLiveData = new MutableLiveData<>();
        this._uiState = mutableLiveData;
        this.uiState = mutableLiveData;
        MutableSharedFlow<Integer> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._errorToastEvent = MutableSharedFlow$default;
        this.errorToastEvent = MutableSharedFlow$default;
        MutableSharedFlow<Integer> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._setDefaultAvatarEvent = MutableSharedFlow$default2;
        this.setDefaultAvatarEvent = MutableSharedFlow$default2;
        this.tmpTroopName = "";
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        this.app = appInterface;
        b bVar = new b();
        this.modifyInfoObserver = bVar;
        this.setDefaultAvatarObserver = new TroopPhotoController.d() { // from class: com.tencent.mobileqq.troop.troopsetting.modules.modifyinfo.viewmodel.TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopModifyBaseInfoViewModel.this);
                }
            }

            @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
            public void B2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
            public void C1(int pos) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this, pos);
                }
            }

            @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
            public void H1(@Nullable a info, @NotNull TroopUploadingThread.b state) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) info, (Object) state);
                } else {
                    Intrinsics.checkNotNullParameter(state, "state");
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(TroopModifyBaseInfoViewModel.this), null, null, new TroopModifyBaseInfoViewModel$setDefaultAvatarObserver$1$onUpdateItem$1(state, TroopModifyBaseInfoViewModel.this, null), 3, null);
                }
            }

            @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
            public void Z(@Nullable a info) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) info);
                }
            }

            @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController.d
            public void c0(@Nullable a info) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) info);
                }
            }
        };
        appInterface.addObserver(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2() {
        h hVar;
        MutableLiveData<h> mutableLiveData = this._uiState;
        h value = this.uiState.getValue();
        if (value != null) {
            hVar = h.b(value, false, null, 2, null);
        } else {
            hVar = null;
        }
        mutableLiveData.postValue(hVar);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopModifyBaseInfoViewModel$postErrorState$1(this, null), 3, null);
    }

    @NotNull
    public final SharedFlow<Integer> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.errorToastEvent;
    }

    @Nullable
    public final Function0<Unit> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Function0) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.onSetDefaultAvatarSucceed;
    }

    @NotNull
    public final SharedFlow<Integer> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (SharedFlow) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.setDefaultAvatarEvent;
    }

    @NotNull
    public final TroopPhotoController.d T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopPhotoController.d) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.setDefaultAvatarObserver;
    }

    @NotNull
    public final String U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.tmpTroopName;
    }

    @Nullable
    public final TroopInfo W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        h value = this.uiState.getValue();
        if (value != null) {
            return value.c();
        }
        return null;
    }

    @NotNull
    public final LiveData<h> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.uiState;
    }

    public final void Z1(@NotNull AppInterface app, @NotNull String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) app, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IRuntimeService runtimeService = app.getRuntimeService(ITroopInfoService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        TroopInfo it = ((ITroopInfoService) runtimeService).getTroopInfo(troopUin);
        MutableLiveData<h> mutableLiveData = this._uiState;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableLiveData.setValue(new h(false, it, 1, null));
        this.originTroopName = it.troopname;
    }

    public final void a2(@NotNull String newName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) newName);
            return;
        }
        Intrinsics.checkNotNullParameter(newName, "newName");
        TroopInfo W1 = W1();
        if (W1 != null && !Intrinsics.areEqual(newName, this.originTroopName)) {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyGroupName(W1.troopuin, newName, null, "TroopModifyBaseInfoViewModel", null);
            return;
        }
        Function0<Unit> function0 = this.onEditFinish;
        if (function0 != null) {
            function0.invoke();
        }
        MutableLiveData<h> mutableLiveData = this._uiState;
        h value = this.uiState.getValue();
        h hVar = null;
        if (value != null) {
            hVar = h.b(value, false, null, 2, null);
        }
        mutableLiveData.setValue(hVar);
    }

    public final void c2(@NotNull String newName, @NotNull Function0<Unit> onEditFinish) {
        String str;
        h hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) newName, (Object) onEditFinish);
            return;
        }
        Intrinsics.checkNotNullParameter(newName, "newName");
        Intrinsics.checkNotNullParameter(onEditFinish, "onEditFinish");
        TroopInfo W1 = W1();
        if (W1 != null) {
            str = W1.getTroopUin();
        } else {
            str = null;
        }
        boolean z16 = true;
        QLog.d("TroopModifyBaseInfoViewModel", 1, "requestEditTroopInfo troopUin: " + str + ", troopName: " + newName);
        this.tmpTroopName = newName;
        MutableLiveData<h> mutableLiveData = this._uiState;
        h value = this.uiState.getValue();
        if (value != null) {
            hVar = h.b(value, true, null, 2, null);
        } else {
            hVar = null;
        }
        mutableLiveData.setValue(hVar);
        this.onEditFinish = onEditFinish;
        TroopInfo W12 = W1();
        if (W12 == null || W12.hasSetNewTroopHead) {
            z16 = false;
        }
        if (z16) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TroopModifyBaseInfoViewModel$requestEditTroopInfo$1(this, null), 3, null);
        } else {
            a2(newName);
        }
    }

    public final void d2(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) function0);
        } else {
            this.onSetDefaultAvatarSucceed = function0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onCleared();
            this.app.removeObserver(this.modifyInfoObserver);
        }
    }
}
