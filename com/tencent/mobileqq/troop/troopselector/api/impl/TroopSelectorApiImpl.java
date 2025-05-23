package com.tencent.mobileqq.troop.troopselector.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorFragment;
import com.tencent.mobileqq.troop.troopselector.api.ITroopSelectorApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/api/impl/TroopSelectorApiImpl;", "Lcom/tencent/mobileqq/troop/troopselector/api/ITroopSelectorApi;", "()V", "openNewTroopSelector", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "troopSelectorConfig", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "requestCode", "", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopSelectorApiImpl implements ITroopSelectorApi {
    @Override // com.tencent.mobileqq.troop.troopselector.api.ITroopSelectorApi
    public void openNewTroopSelector(Context context, Intent intent, TroopSelectorConfig troopSelectorConfig, int requestCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(troopSelectorConfig, "troopSelectorConfig");
        intent.putExtra("selectorConfig", troopSelectorConfig);
        QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, TroopSelectorFragment.class, requestCode);
    }
}
