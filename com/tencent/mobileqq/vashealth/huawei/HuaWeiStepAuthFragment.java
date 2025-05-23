package com.tencent.mobileqq.vashealth.huawei;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.hihealth.HuaweiHiHealth;
import com.huawei.hms.hihealth.SettingController;
import com.huawei.hms.hihealth.data.Scopes;
import com.huawei.hms.hihealth.result.HealthKitAuthResult;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.mobileqq.vashealth.step.k;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\"\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/vashealth/huawei/HuaWeiStepAuthFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "rh", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/huawei/hms/hihealth/SettingController;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/huawei/hms/hihealth/SettingController;", "mSettingController", "", "D", "Ljava/lang/String;", "TAG", "E", "AUTH_SUCCESS_TOAST", UserInfo.SEX_FEMALE, "AUTH_FAIL_TOAST", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "G", "Landroidx/activity/result/ActivityResultLauncher;", "resultLauncher", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HuaWeiStepAuthFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private SettingController mSettingController;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "HuaWeiStepAuthFragment";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String AUTH_SUCCESS_TOAST = "\u6388\u6743\u6210\u529f";

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String AUTH_FAIL_TOAST = "\u6388\u6743\u5931\u8d25";

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ActivityResultLauncher<Intent> resultLauncher;

    public HuaWeiStepAuthFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.tencent.mobileqq.vashealth.huawei.a
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HuaWeiStepAuthFragment.qh(HuaWeiStepAuthFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul\u2026Activity().finish()\n    }");
        this.resultLauncher = registerForActivityResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(HuaWeiStepAuthFragment this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.TAG, 1, "resolveAuthResult " + activityResult.getResultCode());
        if (activityResult.getResultCode() == -1) {
            SettingController settingController = this$0.mSettingController;
            if (settingController != null) {
                HealthKitAuthResult parseHealthKitAuthResultFromIntent = settingController.parseHealthKitAuthResultFromIntent(activityResult.getData());
                if (parseHealthKitAuthResultFromIntent != null && parseHealthKitAuthResultFromIntent.isSuccess()) {
                    QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                    if (qBaseActivity != null) {
                        QQToast.makeText(qBaseActivity, 2, this$0.AUTH_SUCCESS_TOAST, 0).show();
                    }
                    StepCounterPermissionUtils.p(true);
                    k.f312340a.n();
                } else {
                    QLog.d(this$0.TAG, 1, "resolveAuthResult fail: result is null");
                    this$0.rh();
                }
            }
        } else {
            this$0.rh();
        }
        this$0.requireActivity().finish();
    }

    private final void rh() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        QQToast.makeText(qBaseActivity, 1, this.AUTH_FAIL_TOAST, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e_b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        SettingController settingController;
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (getHostActivity() == null) {
            QLog.e(this.TAG, 1, "sTopActivity is null");
            settingController = HuaweiHiHealth.getSettingController(MobileQQ.sMobileQQ);
        } else {
            settingController = HuaweiHiHealth.getSettingController(getHostActivity());
        }
        this.mSettingController = settingController;
        String[] strArr = {Scopes.HEALTHKIT_STEP_READ};
        if (settingController != null) {
            intent = settingController.requestAuthorizationIntent(strArr, true);
        } else {
            intent = null;
        }
        this.resultLauncher.launch(intent);
    }
}
