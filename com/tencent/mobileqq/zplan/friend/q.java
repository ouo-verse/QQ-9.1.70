package com.tencent.mobileqq.zplan.friend;

import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.friend.changerole.view.ZPlanChangeRoleFragment;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/q;", "Li74/a;", "", DomainData.DOMAIN_NAME, "e", "j", "", "l", "()Ljava/lang/String;", "logicName", "<init>", "()V", tl.h.F, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q extends i74.a {
    private final void n() {
        k().getWindow().clearFlags(67108864);
        k().getWindow().addFlags(Integer.MIN_VALUE);
        k().getWindow().setStatusBarColor(-1);
        k().getWindow().getDecorView().setSystemUiVisibility(k().getWindow().getDecorView().getSystemUiVisibility() | 8192);
    }

    @Override // i74.a
    public void e() {
        super.e();
        k().setContentView(R.layout.dcd);
        k().findViewById(R.id.pvw).setFitsSystemWindows(true);
        FragmentTransaction beginTransaction = k().getSupportFragmentManager().beginTransaction();
        ZPlanChangeRoleFragment zPlanChangeRoleFragment = new ZPlanChangeRoleFragment();
        zPlanChangeRoleFragment.setArguments(k().getIntent().getExtras());
        Unit unit = Unit.INSTANCE;
        beginTransaction.add(R.id.pvw, zPlanChangeRoleFragment).commit();
    }

    @Override // i74.a
    public void j() {
        super.j();
        n();
    }

    @Override // i74.a
    /* renamed from: l */
    protected String getLogicName() {
        return "ZPlanFriendLogic";
    }
}
