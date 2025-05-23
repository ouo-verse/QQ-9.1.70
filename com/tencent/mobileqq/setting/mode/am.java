package com.tencent.mobileqq.setting.mode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.pad.f;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.cx;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.minorsmode.MinorsModeKnowType;
import com.tencent.mobileqq.minorsmode.api.IMinorsModeApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.JumpKidModeMgr;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.l;
import com.tencent.mobileqq.studymode.pwdverify.PwdVerifySuccess;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u00103\u001a\u00020/\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0018\u001a\u00020\u0003J\u000e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020\u0003J \u0010!\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0004J&\u0010(\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fJ\u0012\u0010*\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010.\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020,0+j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020,`-H\u0016R\u0017\u00103\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u00100\u001a\u0004\b1\u00102R\u001a\u00107\u001a\u00020\"8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u00108R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010G\u001a\u00020A8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/setting/mode/am;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "j", "", "targetMode", "oldMode", "r", "g", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", HippyTKDListViewAdapter.X, "y", "", "isSuc", "isJumpToStudyPwdVerify", "w", "finalBPref", "e", "t", "Lcom/tencent/mobileqq/app/QQAppInterface;", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "currentMode", "u", tl.h.F, "requestCode", "l", "p", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "i", "", "o", "targetType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "bSwitchElsePref", "isColor", "f", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/content/Context;", "Landroid/content/Context;", DomainData.DOMAIN_NAME, "()Landroid/content/Context;", "context", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "I", "mFrom", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "getKidModeObserver", "()Lcom/tencent/mobileqq/studymode/KidModeObserver;", "setKidModeObserver", "(Lcom/tencent/mobileqq/studymode/KidModeObserver;)V", "kidModeObserver", "Lcom/tencent/mobileqq/app/cx;", "Lcom/tencent/mobileqq/app/cx;", "getMSecSvcObserver", "()Lcom/tencent/mobileqq/app/cx;", "setMSecSvcObserver", "(Lcom/tencent/mobileqq/app/cx;)V", "mSecSvcObserver", "<init>", "(Landroid/content/Context;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class am implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int mFrom;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private KidModeObserver kidModeObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private cx mSecSvcObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/setting/mode/am$a", "Lcom/tencent/mobileqq/theme/DarkModeManager$e;", "", "onConfirm", "onCancel", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements DarkModeManager.e {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f286664b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f286665c;

        a(int i3, int i16) {
            this.f286664b = i3;
            this.f286665c = i16;
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            am.this.e(this.f286664b, this.f286665c);
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            am.this.e(this.f286664b, this.f286665c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/setting/mode/am$b", "Lcom/tencent/mobileqq/studymode/KidModeObserver;", "Lcom/tencent/mobileqq/studymode/KidModeObserver$QueryPasswordStateResult;", "result", "", "c", "Lcom/tencent/mobileqq/studymode/KidModeObserver$VerifyPasswordResult;", "j", "Lcom/tencent/mobileqq/studymode/KidModeObserver$SetNewPasswordResult;", "i", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "g", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends KidModeObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void g(boolean isSuccess, Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            super.g(isSuccess, bundle);
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void i(KidModeObserver.SetNewPasswordResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            super.i(result);
            if (result.errCode != 0) {
                QQToast.makeText(am.this.getContext(), "set password fail", 0);
            } else {
                QQToast.makeText(am.this.getContext(), "set password success", 0);
            }
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void j(KidModeObserver.VerifyPasswordResult result) {
            super.j(result);
        }

        @Override // com.tencent.mobileqq.studymode.KidModeObserver
        public void c(KidModeObserver.QueryPasswordStateResult result) {
            if (result == null) {
                QLog.i("KidModeObserver", 1, "onQueryPasswordState result == null");
                return;
            }
            super.c(result);
            QLog.i("KidModeObserver", 1, "onQueryPasswordState errCode=" + result.errCode + ",State=" + result.passwordState + ",salt=" + com.tencent.mobileqq.studymode.f.b(result.salt));
            if (result.errCode == 0) {
                StudyModeManager.N(result.passwordState, result.salt);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/setting/mode/am$c", "Lcom/tencent/mobileqq/app/cx;", "", "isSuccess", "Landroid/os/Bundle;", "data", "", "c", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends cx {
        c() {
        }

        @Override // com.tencent.mobileqq.app.cx
        public void c(boolean isSuccess, Bundle data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (QLog.isColorLevel()) {
                QLog.i("SecSvcObserver", 2, "JumpKidModeMgr:onGetPhoneUnityInfo isSuccess: " + isSuccess);
            }
            String string = data.getString("phone");
            StudyModeManager.K(StringUtil.isEmpty(string) ? 1 : 0, string, data.getString("mibao_set_url"));
        }
    }

    public am(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.TAG = "YouthModeChoiceHandler";
        this.mFrom = 1;
        this.kidModeObserver = new b();
        this.mSecSvcObserver = new c();
    }

    private final void g(int oldMode, int targetMode) {
        QQAppInterface d16 = d();
        if (d16 != null) {
            int e16 = com.tencent.mobileqq.studymode.r.e(d16, false);
            com.tencent.mobileqq.studymode.l lVar = (com.tencent.mobileqq.studymode.l) d16.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
            if (lVar == null) {
                QLog.i(this.TAG, 1, "manager is null, changeToElderMode failed!!! ");
                return;
            } else if (lVar.o()) {
                QLog.i(this.TAG, 1, "manager is switching, changeToElderMode failed!!! ");
                return;
            } else if (lVar.e(oldMode, targetMode, e16, true) != null) {
                return;
            }
        }
        QLog.i(this.TAG, 1, "app is null, changeToElderMode failed!!!");
        Unit unit = Unit.INSTANCE;
    }

    private final void j() {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        final WeakReference weakReference = new WeakReference((QBaseActivity) context);
        BaseApplication context2 = BaseApplication.getContext();
        if (context2 != null) {
            com.tencent.common.config.pad.f.p(context2, new f.d() { // from class: com.tencent.mobileqq.setting.mode.al
                @Override // com.tencent.common.config.pad.f.d
                public final void a(int i3, int i16, String str) {
                    am.k(am.this, weakReference, i3, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(am this$0, WeakReference activityWR, int i3, int i16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activityWR, "$activityWR");
        if (i16 == 100) {
            QLog.i(this$0.TAG, 1, "checkDeviceConfirmEnterAdavanceSetting success");
            Activity activity = (Activity) activityWR.get();
            if (activity == null) {
                return;
            }
            ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragment(activity, false, null);
        }
    }

    private final void r(final int targetMode, final int oldMode) {
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            com.tencent.common.config.pad.f.p(context, new f.d() { // from class: com.tencent.mobileqq.setting.mode.ak
                @Override // com.tencent.common.config.pad.f.d
                public final void a(int i3, int i16, String str) {
                    am.s(oldMode, targetMode, this, i3, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(int i3, int i16, am this$0, int i17, int i18, String str) {
        MinorsModeKnowType minorsModeKnowType;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i18 == 100) {
            MinorsModeKnowType minorsModeKnowType2 = MinorsModeKnowType.INVALID;
            if (i3 == 2) {
                if (i16 == 3) {
                    minorsModeKnowType = MinorsModeKnowType.CLOSE_ALONE_TO_ELDER;
                } else {
                    minorsModeKnowType = MinorsModeKnowType.CLOSE_ALONE;
                }
                StudyModeManager.Q(false);
                if (i16 != 3) {
                    this$0.g(i3, i16);
                }
                minorsModeKnowType2 = minorsModeKnowType;
            }
            QLog.i(this$0.TAG, 1, "NubiaDeviceUtil.RESULT_SUCCEEDED oldMode=" + i3 + ", targetMode=" + i16 + ", fragmentType=" + minorsModeKnowType2);
            IMinorsModeApi iMinorsModeApi = (IMinorsModeApi) QRoute.api(IMinorsModeApi.class);
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            iMinorsModeApi.startMinorsModeKnowFragment(context, minorsModeKnowType2, null);
        }
    }

    private final void t() {
        KidModeServlet.m(d());
    }

    private final void y(int resultCode, Intent data) {
        int i3;
        int i16;
        boolean h16 = JumpKidModeMgr.b().h();
        int d16 = JumpKidModeMgr.b().d();
        int c16 = JumpKidModeMgr.b().c();
        if (data != null) {
            i16 = data.getIntExtra("ExtraTargetAction", -1);
            i3 = data.getIntExtra("extra_source", -1);
        } else {
            i3 = -1;
            i16 = -1;
        }
        QLog.i(this.TAG, 1, "doOnActivityResult REQ_CHANGE_STUDY_MODEL_SWITCH resultCode=" + resultCode + ",lastTargetMode=" + d16 + ",lastOldMode=" + c16 + ",isJumpToStudyPwdVerify=" + h16 + ", action=" + i16 + ", src=" + i3);
        if (d16 == -1 || c16 == -1) {
            return;
        }
        if (resultCode == -1 && StudyModeManager.z(i16, i3)) {
            return;
        }
        w(resultCode == -1, d16, c16, h16);
    }

    public final QQAppInterface d() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        QLog.i(this.TAG, 1, "YouthModeChoiceHandler QQAppInterface is null--- ");
        return null;
    }

    public final void f(int targetMode, int finalBPref, boolean bSwitchElsePref, boolean isColor) {
        QQAppInterface d16 = d();
        Manager manager = d16 != null ? d16.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER) : null;
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.studymode.ModeSwitchManager");
        com.tencent.mobileqq.studymode.l lVar = (com.tencent.mobileqq.studymode.l) manager;
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        boolean o16 = lVar.o();
        l.b f16 = lVar.f((QBaseActivity) context, targetMode, finalBPref, bSwitchElsePref);
        if (f16.c()) {
            QLog.d(this.TAG, 1, "changeMode switchingStatus.isSwitching : true , mode : " + f16.b());
            if (o16) {
                QQToast.makeText(BaseApplication.getContext(), 0, "\u6b63\u5728\u5207\u6362\u4e2d\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\u3002", 0).show();
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "changeMode switchingStatus.isSwitching : false , mode : " + f16.a());
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(PwdVerifySuccess.class);
        return arrayList;
    }

    public final void h(int targetMode) {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        if (JumpKidModeMgr.b().f(targetMode, 2, d(), (QBaseActivity) context, 2)) {
            return;
        }
        QLog.i(this.TAG, 1, "changeModeFromYouthMode failured ");
    }

    public final void i(int requestCode, int resultCode, Intent data) {
        if (data != null && com.tencent.mobileqq.studymode.p.f(data.getIntExtra("extra_source", -1))) {
            QLog.d(this.TAG, 1, "doOnActivityResult is from OuterBizToCheckPwd, return directly");
            return;
        }
        if (requestCode == 2) {
            y(resultCode, data);
            return;
        }
        if (requestCode == 3) {
            QLog.i(this.TAG, 1, "doOnActivityResult elder resultCode=" + resultCode);
            return;
        }
        if (requestCode == 4) {
            x(resultCode, data);
            return;
        }
        if (requestCode != 5) {
            if (requestCode == 6 && resultCode == -1 && com.tencent.common.config.pad.f.m()) {
                if (data == null) {
                    QLog.i(this.TAG, 1, "doOnActivityResult REQ_CHANGE_STUDY_MODEL_SWITCH_ON_DEVICE_LINK params exception, data is null");
                    return;
                } else {
                    r(data.getIntExtra("extra_target_mode", -1), data.getIntExtra("extra_old_mode", -1));
                    return;
                }
            }
            if (requestCode == 7 && resultCode == -1 && com.tencent.common.config.pad.f.m()) {
                j();
                return;
            }
            return;
        }
        if (data == null) {
            QLog.i(this.TAG, 1, "doOnActivityResult REQ_ENTER_ADVANCED_SETTINGS_PAGE params exception, data is null");
            return;
        }
        int intExtra = data.getIntExtra("extra_target_mode", -1);
        int intExtra2 = data.getIntExtra("extra_old_mode", -1);
        int intExtra3 = data.getIntExtra("extra_source", -1);
        QLog.i(this.TAG, 1, "doOnActivityResult REQ_ENTER_ADVANCED_SETTINGS_PAGE resultCode=" + resultCode + ", data: " + data + ", targetMode: " + intExtra + ", oldMode: " + intExtra2 + ", src: " + intExtra3);
        if (intExtra == -1 || intExtra2 == -1 || intExtra3 == -1 || resultCode != -1 || intExtra3 != 5) {
            return;
        }
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        JumpKidModeMgr.b().i(intExtra, intExtra2, (QBaseActivity) context, intExtra3, this.mFrom == 1 ? 1 : 2, false);
    }

    public final void l(int requestCode, int resultCode, Intent data) {
        i(requestCode, resultCode, data);
    }

    /* renamed from: n, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        QQAppInterface d16 = d();
        if (d16 != null) {
            d16.unRegistObserver(this.kidModeObserver);
        }
        QQAppInterface d17 = d();
        if (d17 != null) {
            d17.removeObserver(this.mSecSvcObserver);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof PwdVerifySuccess) {
            boolean h16 = JumpKidModeMgr.b().h();
            int d16 = JumpKidModeMgr.b().d();
            int c16 = JumpKidModeMgr.b().c();
            QLog.i(this.TAG, 1, "onReceiveEvent, pwd verify suc, targetMode=" + d16 + ",oldMode=" + c16 + ",isJumpToStudyPwdVerify=" + h16);
            if (d16 == -1 || c16 == -1) {
                return;
            }
            w(true, d16, c16, h16);
        }
    }

    public final void p() {
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QBaseActivity qBaseActivity = (QBaseActivity) context;
        if (!com.tencent.common.config.pad.f.o()) {
            JumpKidModeMgr.b().l(-1, -1, 1, d(), qBaseActivity, 2);
        } else if (StudyModeManager.l() == 2) {
            JumpKidModeMgr.b().k(-1, -1, 1, d(), 7, qBaseActivity, 2);
        } else {
            j();
        }
    }

    public final void q() {
        SimpleEventBus.getInstance().registerReceiver(this);
        QQAppInterface d16 = d();
        if (d16 != null) {
            d16.registObserver(this.kidModeObserver);
        }
        QQAppInterface d17 = d();
        if (d17 != null) {
            d17.addObserver(this.mSecSvcObserver);
        }
        t();
    }

    public final void v(int oldMode) {
        JumpKidModeMgr b16 = JumpKidModeMgr.b();
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        b16.i(2, oldMode, (QBaseActivity) context, 1, 1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(int targetMode, int finalBPref) {
        f(targetMode, finalBPref, true, false);
    }

    private final void w(boolean isSuc, int targetMode, int oldMode, boolean isJumpToStudyPwdVerify) {
        if (isSuc) {
            Context context = this.context;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            QBaseActivity qBaseActivity = (QBaseActivity) context;
            if (targetMode == 2 && !isJumpToStudyPwdVerify) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragmentForResult(qBaseActivity, true, 5);
                return;
            }
            if (targetMode != 2) {
                String o16 = o(targetMode);
                if (!Intrinsics.areEqual(o16, "\u5df2\u5f00\u542f\u4f53\u9a8c\u6a21\u5f0f")) {
                    QQToast.makeText(BaseApplication.getContext(), 2, o16, 0).show();
                }
            }
            m(oldMode, targetMode);
        }
    }

    private final void x(int resultCode, Intent data) {
        if (data == null) {
            QLog.i(this.TAG, 1, "doOnActivityResult REQ_ENTER_STUDY_MODEL_FRONT_PAGE params exception, data is null");
            return;
        }
        Context context = this.context;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QBaseActivity qBaseActivity = (QBaseActivity) context;
        int intExtra = data.getIntExtra("extra_target_mode", -1);
        int intExtra2 = data.getIntExtra("extra_old_mode", -1);
        int intExtra3 = data.getIntExtra("extra_source", -1);
        boolean booleanExtra = data.getBooleanExtra("key_is_jump_to_next", false);
        boolean booleanExtra2 = data.getBooleanExtra("extra_mode_change_success", false);
        QLog.i(this.TAG, 1, "doOnActivityResult REQ_ENTER_STUDY_MODEL_FRONT_PAGE resultCode=" + resultCode + ", targetMode: " + intExtra + ", oldMode: " + intExtra2 + ", src: " + intExtra3 + ", jumpToNext: " + booleanExtra + ", modeChangeSuc:" + booleanExtra2);
        if (intExtra == -1 || intExtra2 == -1 || intExtra3 == -1) {
            return;
        }
        if (intExtra3 == 5 && !booleanExtra2) {
            ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragment(qBaseActivity, false, null);
            return;
        }
        if (intExtra == 2 && resultCode == -1 && booleanExtra2) {
            QQToast.makeText(BaseApplication.getContext(), 2, "\u5df2\u5f00\u542f\u672a\u6210\u5e74\u4eba\u6a21\u5f0f", 0).show();
            if (booleanExtra) {
                ((IMinorsModeApi) QRoute.api(IMinorsModeApi.class)).startKidModeAdvanceSettingFragmentForResult(qBaseActivity, true, 5);
            } else {
                JumpKidModeMgr.b().i(intExtra2, intExtra, qBaseActivity, intExtra3, this.mFrom == 1 ? 1 : 2, false);
            }
        }
    }

    protected final void m(int oldMode, int targetType) {
        boolean z16 = targetType == 1;
        ThemeUtil.isNowThemeIsNight(d(), false, null);
        int e16 = com.tencent.mobileqq.studymode.r.e(d(), z16);
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("elder_to_simple_mode_8990_116300199", true) && oldMode == 3 && targetType == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i(this.TAG, 1, "appRuntime is null, can not update bPref for ModeConstantsKt.MODE_TYPE_ELDER");
            } else {
                if (!QQTheme.isThemeSimpleUI(ElderModeManager.f(peekAppRuntime))) {
                    QLog.i(this.TAG, 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + oldMode + " -> targetType:" + targetType + ", but lastThemeId is not SimpleTheme");
                } else {
                    e16 = (int) Math.max(SimpleUIUtil.getPrefByThemeId(r3), 0.0d);
                    QLog.i(this.TAG, 1, "update bPref for ModeConstantsKt.MODE_TYPE_ELDER, bPref:" + e16 + ", oldMode:" + oldMode + " -> targetType:" + targetType);
                }
            }
        }
        if (z16) {
            String themeId = SimpleUIUtil.getThemeId(e16);
            Context context = this.context;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
            if (DarkModeManager.w((QBaseActivity) context, themeId, new a(targetType, e16))) {
                return;
            }
            e(targetType, e16);
            return;
        }
        e(targetType, e16);
    }

    public final String o(int targetMode) {
        if (targetMode == 0) {
            return "\u5df2\u5f00\u542f\u666e\u901a\u6a21\u5f0f";
        }
        if (targetMode == 1) {
            return "\u5df2\u5f00\u542f\u4f53\u9a8c\u6a21\u5f0f";
        }
        if (targetMode != 3) {
            return "";
        }
        return "\u5df2\u5f00\u542f\u5173\u6000\u6a21\u5f0f";
    }

    public final boolean u(int currentMode, int targetMode) {
        BaseApplicationImpl application;
        AppRuntime runtime;
        if (currentMode != 2 && targetMode != 2) {
            return false;
        }
        int l3 = StudyModeManager.l();
        if (l3 != 1 && l3 != 3 && l3 != 2 && (application = BaseApplicationImpl.getApplication()) != null && (runtime = application.getRuntime()) != null && (runtime instanceof QQAppInterface)) {
            KidModeServlet.m((QQAppInterface) runtime);
        }
        if (l3 == 2) {
            Intent intent = new Intent();
            intent.putExtra("ExtraTargetAction", 6);
            intent.putExtra("extra_target_mode", targetMode);
            intent.putExtra("extra_old_mode", currentMode);
            intent.putExtra("extra_source", 2);
            intent.putExtra("extra_source_for_report", -1);
            IMinorsModeApi iMinorsModeApi = (IMinorsModeApi) QRoute.api(IMinorsModeApi.class);
            Context context = this.context;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            iMinorsModeApi.startStudyPwdVerifyFragment((Activity) context, intent, 6);
        } else {
            r(targetMode, currentMode);
        }
        return true;
    }
}
