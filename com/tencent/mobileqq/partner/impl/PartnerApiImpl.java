package com.tencent.mobileqq.partner.impl;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.partner.IPartnerApi;
import com.tencent.mobileqq.partner.signin.PartnerSignInDialogFragment;
import com.tencent.mobileqq.partner.signin.drawer.a;
import com.tencent.mobileqq.partner.signin.i;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/partner/impl/PartnerApiImpl;", "Lcom/tencent/mobileqq/partner/IPartnerApi;", "Lkotlin/Pair;", "", "getPartnerSignInDelegate", "Lcom/tencent/mobileqq/partner/signin/i;", "param", "", "openPartnerSignInDialog", "<init>", "()V", "Companion", "a", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerApiImpl implements IPartnerApi {
    private static final String TAG = "PartnerApiImpl";

    @Override // com.tencent.mobileqq.partner.IPartnerApi
    public Pair<String, ?> getPartnerSignInDelegate() {
        return new Pair<>("PartnerSignInItemDelegate", new a());
    }

    @Override // com.tencent.mobileqq.partner.IPartnerApi
    public void openPartnerSignInDialog(i param) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.d(TAG, 1, "[openPartnerSignInDialog] friendUin=" + StringUtil.getSimpleUinForPrint(param.a()) + " mutualMarkId=" + param.b());
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null && !topActivity.isFinishing() && !topActivity.isDestroyed()) {
            FragmentActivity fragmentActivity = topActivity instanceof FragmentActivity ? (FragmentActivity) topActivity : null;
            if (fragmentActivity != null) {
                try {
                    new PartnerSignInDialogFragment(fragmentActivity, param).show(fragmentActivity.getSupportFragmentManager(), TAG);
                    return;
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "[openPartnerSignInDialog] show dialog fragment error,", e16);
                    return;
                }
            }
            return;
        }
        QLog.e(TAG, 1, "[openPartnerSignInDialog] top activity is invalid");
    }
}
