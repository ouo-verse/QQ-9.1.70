package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.vas.GXHSettingFragment;
import com.tencent.mobileqq.vas.api.IVasFragment;
import com.tencent.mobileqq.vip.KingCardActivationFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasFragmentImpl;", "Lcom/tencent/mobileqq/vas/api/IVasFragment;", "()V", "startGHXSetting", "", "context", "Landroid/content/Context;", "title", "", "startKingCard", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasFragmentImpl implements IVasFragment {
    @Override // com.tencent.mobileqq.vas.api.IVasFragment
    public void startGHXSetting(@NotNull Context context, @NotNull String title) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.putExtra("setting_search_title", title);
        QPublicFragmentActivity.start(context, intent, GXHSettingFragment.class);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasFragment
    public void startKingCard(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, KingCardActivationFragment.class);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasFragment
    public void startGHXSetting(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setFlags(268435456);
        QPublicFragmentActivity.start(context, intent, GXHSettingFragment.class);
    }
}
