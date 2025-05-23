package com.tencent.open.agent;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;

/* loaded from: classes22.dex */
public class JoinTroopPreVerificationFragment extends TroopAbilityPreVerificationFragment {
    private com.tencent.mobileqq.troop.api.observer.e W = new a();

    /* loaded from: classes22.dex */
    class a extends com.tencent.mobileqq.troop.api.observer.e {
        a() {
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onGetJoinTroopTokenForThirdApp(boolean z16, String str, String str2) {
            JoinTroopPreVerificationFragment.this.U7();
            QLog.i("TroopAbility.PreVerification", 1, "onGetJoinTroopTokenForThirdApp, isSuccess: " + z16 + " token: " + str + ", troopUin: " + str2);
            if (z16) {
                Bundle b16 = aq.b(String.valueOf(str2), 32);
                b16.putString("authSig", str);
                b16.putString("appid", JoinTroopPreVerificationFragment.this.J);
                b16.putBoolean("fromThirdAppByOpenSDK", true);
                b16.putInt("action", 3);
                b16.putString("pkg_name", JoinTroopPreVerificationFragment.this.K);
                b16.putString("app_name", JoinTroopPreVerificationFragment.this.H);
                TroopUtils.I(JoinTroopPreVerificationFragment.this.D, b16, 2);
                JoinTroopPreVerificationFragment.this.D.finish();
                return;
            }
            JoinTroopPreVerificationFragment.this.showFailToast(HardCodeUtil.qqStr(R.string.nia));
            JoinTroopPreVerificationFragment.this.D.finish();
        }
    }

    @Override // com.tencent.open.agent.TroopAbilityPreVerificationFragment
    protected void Ah(boolean z16) {
        if (z16) {
            ((com.tencent.mobileqq.troop.api.handler.j) this.C.getBusinessHandler(BusinessHandlerFactory.TROOP_TOKEN_HANDLER)).G1(Integer.valueOf(this.J).intValue(), Integer.valueOf(this.N).intValue());
            return;
        }
        U7();
        showFailToast(HardCodeUtil.qqStr(R.string.nib));
        this.D.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.TroopAbilityPreVerificationFragment
    public void Bh() {
        super.Bh();
        this.C.removeObserver(this.W);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.open.agent.TroopAbilityPreVerificationFragment
    public void th() {
        super.th();
        this.C.addObserver(this.W);
    }

    @Override // com.tencent.open.agent.TroopAbilityPreVerificationFragment
    protected boolean vh(Set<Integer> set) {
        if (set != null && !set.isEmpty()) {
            return set.contains(15);
        }
        return false;
    }
}
