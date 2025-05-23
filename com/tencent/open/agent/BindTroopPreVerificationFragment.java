package com.tencent.open.agent;

import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Set;

/* loaded from: classes22.dex */
public class BindTroopPreVerificationFragment extends TroopAbilityPreVerificationFragment {
    private static final Integer W = 16;

    @Override // com.tencent.open.agent.TroopAbilityPreVerificationFragment
    protected void Ah(boolean z16) {
        U7();
        if (z16) {
            Intent intent = new Intent();
            intent.putExtra("key_params", this.G);
            PublicFragmentActivity.b.a(this.D, intent, PublicFragmentActivity.class, BindGroupFragment.class);
            this.D.finish();
            return;
        }
        showFailToast(HardCodeUtil.qqStr(R.string.k1z));
        this.D.finish();
    }

    @Override // com.tencent.open.agent.TroopAbilityPreVerificationFragment
    protected boolean vh(Set<Integer> set) {
        if (set != null && !set.isEmpty()) {
            return set.contains(W);
        }
        return false;
    }
}
