package com.tenpay.form.queryaccount;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.compat.f;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.face.FaceVerifyErr;
import com.tenpay.face.QWalletFaceProxyFragment;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J'\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0016J\"\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J5\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052%\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004J\\\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052%\u0010\u0013\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00042%\u0010\u0014\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004R-\u0010\u0003\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R-\u0010\n\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/tenpay/form/queryaccount/IdQueryBaseFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "()V", "checkFaceFailAction", "Lkotlin/Function1;", "Lcom/tenpay/face/FaceVerifyBean;", "Lkotlin/ParameterName;", "name", "faceVerifyBean", "", "checkFaceSuccessAction", "getFaceVerifySuccessAction", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "startCheckFace", "onCheckFaceSuccess", "onCheckFaceFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class IdQueryBaseFragment extends QWalletBaseFragment {

    @Nullable
    private Function1<? super FaceVerifyBean, Unit> checkFaceFailAction;

    @Nullable
    private Function1<? super FaceVerifyBean, Unit> checkFaceSuccessAction;

    @Nullable
    public Function1<FaceVerifyBean, Unit> getFaceVerifySuccessAction() {
        return this.checkFaceSuccessAction;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Integer num;
        String str;
        FaceVerifyBean faceVerifyBean;
        boolean z16;
        QLog.i(QPublicBaseFragment.TAG, 1, "face verify callback: " + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
        if (1 == requestCode && resultCode == -1) {
            if (data != null) {
                num = Integer.valueOf(data.getIntExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_CODE, FaceVerifyErr.ERROR_CANCEL.getRetCode()));
            } else {
                num = null;
            }
            if (data != null) {
                str = data.getStringExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_MSG);
            } else {
                str = null;
            }
            if (data != null) {
                faceVerifyBean = (FaceVerifyBean) data.getParcelableExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_FACE_BEAN);
            } else {
                faceVerifyBean = null;
            }
            int retCode = FaceVerifyErr.OK.getRetCode();
            if (num != null && num.intValue() == retCode && faceVerifyBean != null) {
                Function1<FaceVerifyBean, Unit> faceVerifySuccessAction = getFaceVerifySuccessAction();
                if (faceVerifySuccessAction != null) {
                    faceVerifySuccessAction.invoke(faceVerifyBean);
                }
                this.checkFaceSuccessAction = null;
            } else {
                boolean z17 = false;
                if (str != null) {
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                if (z17) {
                    QQToastUtil.showQQToast(1, str);
                    Function1<? super FaceVerifyBean, Unit> function1 = this.checkFaceFailAction;
                    if (function1 != null) {
                        function1.invoke(faceVerifyBean);
                    }
                }
            }
            QLog.w(QPublicBaseFragment.TAG, 1, "face proxy fail: " + num + " " + str);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    public final void startCheckFace(@NotNull FaceVerifyBean faceVerifyBean, @Nullable Function1<? super FaceVerifyBean, Unit> onCheckFaceSuccess) {
        Intrinsics.checkNotNullParameter(faceVerifyBean, "faceVerifyBean");
        startCheckFace(faceVerifyBean, onCheckFaceSuccess, null);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public final void startCheckFace(@NotNull FaceVerifyBean faceVerifyBean, @Nullable Function1<? super FaceVerifyBean, Unit> onCheckFaceSuccess, @Nullable Function1<? super FaceVerifyBean, Unit> onCheckFaceFail) {
        Intrinsics.checkNotNullParameter(faceVerifyBean, "faceVerifyBean");
        this.checkFaceSuccessAction = onCheckFaceSuccess;
        this.checkFaceFailAction = onCheckFaceFail;
        QWalletFaceProxyFragment.Companion companion = QWalletFaceProxyFragment.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.start(requireContext, faceVerifyBean, 1);
    }
}
