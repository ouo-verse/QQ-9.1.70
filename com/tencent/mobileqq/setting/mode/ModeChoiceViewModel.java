package com.tencent.mobileqq.setting.mode;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.mode.ModeChoiceViewModel;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.NightModeLogic;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\b\t*\u000259\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J(\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0002J\u0016\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\u0019\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0005R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020 8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0006\u00a2\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0006\u00a2\u0006\f\n\u0004\b,\u0010\"\u001a\u0004\b-\u0010$R\u001b\u00104\u001a\u00020/8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/setting/mode/ModeChoiceViewModel;", "Landroidx/lifecycle/ViewModel;", "", "targetMode", "finalBPref", "", "N1", "", "bSwitchElsePref", "isColor", "O1", "index", "", "S1", "e2", "d2", "modeType", "f2", "Q1", "oldMode", "targetType", "R1", "W1", "U1", "c2", "i2", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "M1", SemanticAttributes.DbSystemValues.H2, "g2", "P1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "currentModeData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b2", "simpleModeID", BdhLogUtil.LogTag.Tag_Conn, "X1", "nightFollowSysSwitch", "D", ICustomDataEditor.STRING_ARRAY_PARAM_2, "nightModeStatus", "Lcom/tencent/mobileqq/vas/theme/NightModeLogic;", "E", "Lkotlin/Lazy;", "Z1", "()Lcom/tencent/mobileqq/vas/theme/NightModeLogic;", "nightModeLogic", "com/tencent/mobileqq/setting/mode/ModeChoiceViewModel$c", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/setting/mode/ModeChoiceViewModel$c;", "modeChangeList", "com/tencent/mobileqq/setting/mode/ModeChoiceViewModel$d", "G", "Lcom/tencent/mobileqq/setting/mode/ModeChoiceViewModel$d;", "nightChangeObserver", "<init>", "()V", "H", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ModeChoiceViewModel extends ViewModel {

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy nightModeLogic;

    /* renamed from: F, reason: from kotlin metadata */
    private final c modeChangeList;

    /* renamed from: G, reason: from kotlin metadata */
    private final d nightChangeObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> currentModeData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Integer> simpleModeID = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> nightFollowSysSwitch = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> nightModeStatus = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/setting/mode/ModeChoiceViewModel$b", "Lcom/tencent/mobileqq/theme/DarkModeManager$e;", "", "onConfirm", "onCancel", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements DarkModeManager.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f286635b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f286636c;

        b(int i3, int i16) {
            this.f286635b = i3;
            this.f286636c = i16;
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            ModeChoiceViewModel.this.N1(this.f286635b, this.f286636c);
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            ModeChoiceViewModel.this.i2();
            ModeChoiceViewModel.this.N1(this.f286635b, this.f286636c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/setting/mode/ModeChoiceViewModel$c", "Lcom/tencent/mobileqq/studymode/l$a;", "", "targetType", "oldType", "", "Aa", "", "isSuccess", "", "message", "j7", "W1", "ed", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements l.a {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(boolean z16, String message, ModeChoiceViewModel this$0) {
            Intrinsics.checkNotNullParameter(message, "$message");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z16) {
                if (message.length() > 0) {
                    QQToast.makeText(BaseApplication.getContext(), 2, message, 0).show();
                }
                this$0.T1().postValue(Integer.valueOf(com.tencent.mobileqq.studymode.g.a()));
                QLog.d("ModeChoiceViewModel", 2, "currentModeData : " + com.tencent.mobileqq.studymode.g.a() + ", " + message);
            } else {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.hhx, 0).show();
                QLog.d("ModeChoiceViewModel", 2, "currentModeData : " + com.tencent.mobileqq.studymode.g.a());
                this$0.T1().postValue(Integer.valueOf(com.tencent.mobileqq.studymode.g.a()));
            }
            if (com.tencent.mobileqq.studymode.g.a() == 1) {
                this$0.b2().postValue(Integer.valueOf(this$0.W1()));
                this$0.a2().postValue(Boolean.valueOf(this$0.P1()));
            }
        }

        @Override // com.tencent.mobileqq.studymode.l.a
        public void Aa(int targetType, int oldType) {
            QLog.d("ModeChoiceViewModel", 1, "onModeChangeStart targetType: " + targetType + ", oldType: " + oldType);
        }

        @Override // com.tencent.mobileqq.studymode.l.a
        public void C6(boolean z16, Object obj) {
            l.a.C8630a.a(this, z16, obj);
        }

        @Override // com.tencent.mobileqq.studymode.l.a
        public void W1(int targetType, int oldType) {
            QLog.d("ModeChoiceViewModel", 1, "onSelectModeRecover target:  " + targetType + ", oldType: " + oldType);
        }

        @Override // com.tencent.mobileqq.studymode.l.a
        public void ed(int targetType, int oldType) {
            QLog.d("ModeChoiceViewModel", 1, "onModeSwitching target:  " + targetType + ", oldType: " + oldType);
        }

        @Override // com.tencent.mobileqq.studymode.l.a
        public void j7(final boolean isSuccess, int targetType, int oldType, final String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            QLog.d("ModeChoiceViewModel", 1, "onModeChangeComplete isSuccess: " + isSuccess + ", target:  " + targetType + ", oldType: " + oldType);
            MqqHandler uIHandler = ThreadManager.getUIHandler();
            final ModeChoiceViewModel modeChoiceViewModel = ModeChoiceViewModel.this;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.setting.mode.aj
                @Override // java.lang.Runnable
                public final void run() {
                    ModeChoiceViewModel.c.b(isSuccess, message, modeChoiceViewModel);
                }
            });
            ElderModeManager.m(isSuccess, targetType, oldType, QBaseActivity.sTopActivity);
        }

        @Override // com.tencent.mobileqq.studymode.l.a
        public void wa(boolean z16, boolean z17, boolean z18, int i3) {
            l.a.C8630a.b(this, z16, z17, z18, i3);
        }
    }

    public ModeChoiceViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<NightModeLogic>() { // from class: com.tencent.mobileqq.setting.mode.ModeChoiceViewModel$nightModeLogic$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NightModeLogic invoke() {
                return new NightModeLogic(MobileQQ.sMobileQQ.peekAppRuntime());
            }
        });
        this.nightModeLogic = lazy;
        this.modeChangeList = new c();
        this.nightChangeObserver = new d();
    }

    private final void O1(int targetMode, int finalBPref, boolean bSwitchElsePref, boolean isColor) {
        com.tencent.mobileqq.studymode.l lVar = (com.tencent.mobileqq.studymode.l) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        if (lVar == null) {
            QLog.i("ModeChoiceViewModel", 1, "manager is null, changeMode targetMode: " + targetMode + ", finalBPref: " + finalBPref + ", bSwitchElsePref:" + bSwitchElsePref + ", isColor" + isColor + " failed!!! stack:" + QLog.getStackTraceString(new Throwable()));
            return;
        }
        if (lVar.o()) {
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f173120hi3, 0).show();
            QLog.d("ModeChoiceViewModel", 2, "changeMode isSwitching!!!");
            return;
        }
        QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
        Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
        l.b f16 = lVar.f(sTopActivity, targetMode, finalBPref, bSwitchElsePref);
        if (f16.c()) {
            QLog.d("ModeChoiceViewModel", 1, "changeMode switchingStatus.isSwitching : true , mode : " + f16.b());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ModeChoiceViewModel", 2, "changeMode switchingStatus.isSwitching : false , mode : " + f16.a());
        }
        this.currentModeData.postValue(Integer.valueOf(com.tencent.mobileqq.studymode.g.a()));
        QLog.d("ModeChoiceViewModel", 2, "changeMode error post currentModeData" + com.tencent.mobileqq.studymode.g.a());
    }

    public final void M1(boolean isOpen) {
        QLog.d("ModeChoiceViewModel", 1, "changeDarkModeSwitch isOpen: " + isOpen);
        DarkModeManager.v(isOpen);
        if (isOpen) {
            DarkModeManager.u(null);
        }
        i2();
        this.nightModeStatus.postValue(Boolean.valueOf(P1()));
    }

    public final boolean P1() {
        return Z1().getNightModeStatus() == 1;
    }

    public final int Q1() {
        return com.tencent.mobileqq.studymode.g.a();
    }

    public final void R1(int oldMode, int targetType) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = targetType == 1;
        ThemeUtil.isNowThemeIsNight(peekAppRuntime, false, null);
        int e16 = com.tencent.mobileqq.studymode.r.e(peekAppRuntime, z16);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("elder_to_simple_mode_8990_116300199", true) && oldMode == 3 && targetType == 1) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 == null) {
                QLog.i("ModeChoiceViewModel", 1, "appRuntime is null, can not update bPref for ModeConstantsKt.MODE_TYPE_ELDER");
            } else {
                if (!QQTheme.isThemeSimpleUI(ElderModeManager.f(peekAppRuntime2))) {
                    QLog.i("ModeChoiceViewModel", 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + oldMode + " -> targetType:" + targetType + ", but lastThemeId is not SimpleTheme");
                } else {
                    e16 = (int) Math.max(SimpleUIUtil.getPrefByThemeId(r1), 0.0d);
                    QLog.i("ModeChoiceViewModel", 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + oldMode + " -> targetType:" + targetType);
                }
            }
        }
        if (z16) {
            if (DarkModeManager.w(QBaseActivity.sTopActivity, SimpleUIUtil.getThemeId(e16), new b(targetType, e16))) {
                return;
            }
            N1(targetType, e16);
            return;
        }
        N1(targetType, e16);
    }

    public final MutableLiveData<Integer> T1() {
        return this.currentModeData;
    }

    public final String U1() {
        return S1(W1());
    }

    public final int W1() {
        return com.tencent.mobileqq.studymode.r.e(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.studymode.g.a() == 1);
    }

    public final MutableLiveData<Boolean> X1() {
        return this.nightFollowSysSwitch;
    }

    public final NightModeLogic Z1() {
        return (NightModeLogic) this.nightModeLogic.getValue();
    }

    public final MutableLiveData<Boolean> a2() {
        return this.nightModeStatus;
    }

    public final MutableLiveData<Integer> b2() {
        return this.simpleModeID;
    }

    public final void c2(int index) {
        QLog.d("ModeChoiceViewModel", 2, "handleSimpleColorCheck index: " + index + ", current: " + W1());
        if (index == W1()) {
            QLog.e("ModeChoiceViewModel", 1, "handleSimpleColorCheck same color!!!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.simpleui.SimpleUIHandler");
        if (((SimpleUIHandler) businessHandler).h3(true, index, false)) {
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f173120hi3, 0).show();
    }

    public final void d2() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        Manager manager = ((AppInterface) peekAppRuntime).getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.studymode.ModeSwitchManager");
        ((com.tencent.mobileqq.studymode.l) manager).d(this.modeChangeList);
        this.currentModeData.postValue(Integer.valueOf(com.tencent.mobileqq.studymode.g.a()));
        QLog.d("ModeChoiceViewModel", 2, "initCurrentMode currentModeData :" + com.tencent.mobileqq.studymode.g.a());
        if (com.tencent.mobileqq.studymode.g.a() == 1) {
            this.simpleModeID.postValue(Integer.valueOf(W1()));
        }
        i2();
        Z1().registerModeCallbacks(this.nightChangeObserver, true);
        this.nightModeStatus.postValue(Boolean.valueOf(P1()));
    }

    public final void e2() {
        Z1().onPostThemeChanged();
    }

    public final void f2(int modeType) {
        R1(com.tencent.mobileqq.studymode.g.a(), modeType);
    }

    public final void g2() {
        Z1().startNightMode(QBaseActivity.sTopActivity);
    }

    public final void h2() {
        Z1().startNightMode(QBaseActivity.sTopActivity);
    }

    public final void onDestroy() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        Manager manager = ((AppInterface) peekAppRuntime).getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.studymode.ModeSwitchManager");
        ((com.tencent.mobileqq.studymode.l) manager).v(this.modeChangeList);
        Z1().registerModeCallbacks(this.nightChangeObserver, false);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/setting/mode/ModeChoiceViewModel$d", "Lcom/tencent/mobileqq/vas/theme/NightModeLogic$NightModeCallback;", "Landroid/os/Bundle;", "result", "", "onRespComplete", "onRespError", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements NightModeLogic.NightModeCallback {
        d() {
        }

        @Override // com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback
        public void onRespError(Bundle result) {
            QLog.d("ModeChoiceViewModel", 1, "nightChange onRespError is night: " + ModeChoiceViewModel.this.P1());
            ModeChoiceViewModel.this.a2().postValue(Boolean.valueOf(ModeChoiceViewModel.this.P1()));
        }

        @Override // com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback
        public void onRespComplete(Bundle result) {
            Integer valueOf = result != null ? Integer.valueOf(result.getInt("start_status")) : null;
            if (valueOf != null && valueOf.intValue() == 2) {
                QLog.d("ModeChoiceViewModel", 1, "onRespComplete is night:" + ModeChoiceViewModel.this.P1());
                ModeChoiceViewModel.this.a2().postValue(Boolean.valueOf(ModeChoiceViewModel.this.P1()));
            }
        }
    }

    public final void i2() {
        QLog.d("ModeChoiceViewModel", 1, "updateDarkModeUISwitch");
        this.nightFollowSysSwitch.postValue(Boolean.valueOf(DarkModeManager.m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N1(int targetMode, int finalBPref) {
        O1(targetMode, finalBPref, true, false);
    }

    private final String S1(int index) {
        if (index < 0 || index >= ThemeConstants.THEME_ID_IMAGE_LIST_MAME.length) {
            index = 0;
        }
        String text = ThemeConstants.THEME_ID_IMAGE_LIST_MAME[index];
        if (FontSettingManager.isFontSizeLarge()) {
            Intrinsics.checkNotNullExpressionValue(text, "text");
            text = text.substring(0, text.length() - 1);
            Intrinsics.checkNotNullExpressionValue(text, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        Intrinsics.checkNotNullExpressionValue(text, "text");
        return text;
    }
}
