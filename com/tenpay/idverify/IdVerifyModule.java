package com.tenpay.idverify;

import android.content.Context;
import android.content.Intent;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.activity.BindBankActivity;
import com.tenpay.sdk.activity.IdVerifyActivity;
import com.tenpay.sdk.activity.TenpayUtilActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\"\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/idverify/IdVerifyModule;", "", "()V", "TAG", "", "startFromApiGotoView", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startFromBindBank", "fragment", "Lcom/tenpay/sdk/activity/BindBankActivity;", "showTrueName", "", RealNameSource.EXTRA_KEY_SOURCE, "Lcom/tenpay/realname/RealNameSource;", "startFromFakeUrl", "startFromForgetPwd", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "requestCode", "", "startFromHb", "Lcom/tenpay/sdk/activity/TenpayUtilActivity;", "startFromQWallet", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyModule {

    @NotNull
    public static final IdVerifyModule INSTANCE = new IdVerifyModule();

    @NotNull
    private static final String TAG = "IdVerifyModule";

    IdVerifyModule() {
    }

    @JvmStatic
    public static final void startFromApiGotoView(@Nullable Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(IdVerifyEntryFragment.EXTRA_ID_VERIFY_TYPE, EnumIdVerifyType.IdCard);
        com.tencent.mobileqq.base.c.f(context, intent, IdVerifyEntryFragment.class, false, 8, null);
        QLog.d(TAG, 1, "startFromApiGotoView");
    }

    @JvmStatic
    public static final void startFromBindBank(@NotNull BindBankActivity fragment, boolean showTrueName, @Nullable RealNameSource realNameSource) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent putExtra = new Intent().putExtra("show_true_name", showTrueName);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(\"show_true_name\", showTrueName)");
        putExtra.putExtra(RealNameSource.EXTRA_KEY_SOURCE, realNameSource);
        putExtra.putExtra(IdVerifyEntryFragment.EXTRA_ID_VERIFY_TYPE, EnumIdVerifyType.IdCard);
        fragment.launchFragment(putExtra, IdVerifyEntryFragment.class);
        QLog.d(TAG, 1, "startFromBindBank");
    }

    @JvmStatic
    public static final void startFromFakeUrl(@Nullable Context context) {
        Intent intent = new Intent();
        intent.putExtra(IdVerifyEntryFragment.EXTRA_ID_VERIFY_TYPE, EnumIdVerifyType.IdCard);
        com.tencent.mobileqq.base.c.f(context, intent, IdVerifyEntryFragment.class, false, 8, null);
        QLog.d(TAG, 1, "startFromFakeUrl");
    }

    @JvmStatic
    public static final void startFromForgetPwd(@NotNull QWalletBaseFragment fragment, @NotNull Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(intent, "intent");
        fragment.launchFragmentForResult(intent, IdVerifyActivity.class, requestCode);
        QLog.d(TAG, 1, "startFromForgetPwd");
    }

    @JvmStatic
    public static final void startFromHb(@NotNull TenpayUtilActivity fragment, int requestCode, @Nullable RealNameSource realNameSource) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intent putExtra = new Intent().putExtra("from_hb", true);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent().putExtra(\"from_hb\", true)");
        putExtra.putExtra(RealNameSource.EXTRA_KEY_SOURCE, realNameSource);
        putExtra.putExtra(IdVerifyEntryFragment.EXTRA_ID_VERIFY_TYPE, EnumIdVerifyType.IdCard);
        fragment.launchFragmentForResult(putExtra, IdVerifyEntryFragment.class, requestCode);
        QLog.d(TAG, 1, "startFromHb");
    }

    @JvmStatic
    public static final void startFromQWallet(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("uin", QWalletUtils.h());
        intent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, new RealNameSource("1"));
        intent.putExtra(IdVerifyEntryFragment.EXTRA_ID_VERIFY_TYPE, EnumIdVerifyType.IdCard);
        com.tencent.mobileqq.base.c.f(context, intent, IdVerifyEntryFragment.class, false, 8, null);
        QLog.d(TAG, 1, "startFromQWallet");
    }
}
