package com.tencent.mobileqq.vashealth.honorstep;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hihonor.cloudservice.support.account.request.SignInOptions;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.entity.auth.Scope;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.vashealth.StepCounterPermissionUtils;
import com.tencent.mobileqq.vashealth.step.k;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vashealth/honorstep/HonorStepAuthFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "ph", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "TAG", "D", "AUTH_SUCCESS_TOAST", "E", "AUTH_FAIL_TOAST", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class HonorStepAuthFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "HuaWeiStepAuthFragment";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String AUTH_SUCCESS_TOAST = "\u6388\u6743\u6210\u529f";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String AUTH_FAIL_TOAST = "\u6388\u6743\u5931\u8d25";

    private final void ph() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            return;
        }
        QQToast.makeText(qBaseActivity, 1, this.AUTH_FAIL_TOAST, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e_a;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QLog.d(this.TAG, 1, "resolveAuthResult requestCode " + requestCode + " resultCode " + resultCode);
        if (resultCode == -1 && requestCode == 1001) {
            com.hihonor.cloudservice.tasks.f<SignInAccountInfo> c16 = c2.a.c(data);
            if (c16.b()) {
                SignInAccountInfo a16 = c16.a();
                g gVar = g.f312292a;
                String a17 = a16.a();
                Intrinsics.checkNotNullExpressionValue(a17, "signInAccountInfo.authorizationCode");
                String str = a16.f36234d;
                Intrinsics.checkNotNullExpressionValue(str, "signInAccountInfo.openId");
                gVar.r(a17, str, "220711583");
                String a18 = a16.a();
                Intrinsics.checkNotNullExpressionValue(a18, "signInAccountInfo.authorizationCode");
                gVar.f(a18, false);
                QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
                if (qBaseActivity != null) {
                    QQToast.makeText(qBaseActivity, 2, this.AUTH_SUCCESS_TOAST, 0).show();
                }
                StepCounterPermissionUtils.n(true);
                k.f312340a.k();
            }
        } else {
            ph();
        }
        requireActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Scope scope = new Scope("https://www.hihonor.com/healthkit/step.read");
        ArrayList arrayList = new ArrayList();
        arrayList.add(scope);
        SignInOptions a16 = new e2.a(SignInOptions.M).b("220711583").f(arrayList).a();
        Intrinsics.checkNotNullExpressionValue(a16, "SignInOptionBuilder(Sign\u2026          .createParams()");
        Intent signInIntent = c2.a.a(getActivity(), a16).getSignInIntent();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.startActivityFromChild(activity, signInIntent, 1001);
        }
    }
}
