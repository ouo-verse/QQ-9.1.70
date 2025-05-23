package com.tencent.mobileqq.vas.pay.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.vas.pay.api.IVasPayRenewalPage;
import com.tencent.mobileqq.vas.pay.newcustomer.QVipNewCustomerPage;
import com.tencent.mobileqq.vas.pay.newcustomer.e;
import com.tencent.mobileqq.vas.pay.page.VipExpiredPayPage;
import com.tencent.mobileqq.vas.pay.page.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/pay/api/impl/VasPayRenewalPageImpl;", "Lcom/tencent/mobileqq/vas/pay/api/IVasPayRenewalPage;", "()V", "getNewCustomerPageParserClass", "Ljava/lang/Class;", "getRenewalParserClass", "open", "", "context", "Landroid/content/Context;", "source", "", "openNewCustomerPage", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasPayRenewalPageImpl implements IVasPayRenewalPage {
    @Override // com.tencent.mobileqq.vas.pay.api.IVasPayRenewalPage
    @NotNull
    public Class<?> getNewCustomerPageParserClass() {
        return e.class;
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasPayRenewalPage
    @NotNull
    public Class<?> getRenewalParserClass() {
        return k.class;
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasPayRenewalPage
    public void open(@NotNull Context context, @NotNull String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intent intent = new Intent();
        intent.putExtra("extra_source", source);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, VipExpiredPayPage.class);
    }

    @Override // com.tencent.mobileqq.vas.pay.api.IVasPayRenewalPage
    public void openNewCustomerPage(@NotNull Context context, @NotNull String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        Intent intent = new Intent();
        intent.putExtra("extra_source", source);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        QPublicFragmentActivity.start(context, intent, QVipNewCustomerPage.class);
    }
}
