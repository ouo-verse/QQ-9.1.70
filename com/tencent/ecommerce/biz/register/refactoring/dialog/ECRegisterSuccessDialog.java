package com.tencent.ecommerce.biz.register.refactoring.dialog;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.ecommerce.biz.register.a;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECRegisterSuccessDialog;", "Lcom/tencent/ecommerce/base/ui/ECBaseDialogFragment;", "Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECRegisterSuccessDialog$RegisterSuccessResult;", "", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "<init>", "()V", "G", "a", "RegisterSuccessResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRegisterSuccessDialog extends ECBaseDialogFragment<RegisterSuccessResult> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b6\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECRegisterSuccessDialog$RegisterSuccessResult;", "Landroid/os/Parcelable;", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static abstract class RegisterSuccessResult implements Parcelable {
        RegisterSuccessResult() {
        }
    }

    @Override // com.tencent.ecommerce.base.ui.ECBaseDialogFragment
    public int getContentLayoutId() {
        return R.layout.cqy;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        a.f103962b.k();
    }
}
