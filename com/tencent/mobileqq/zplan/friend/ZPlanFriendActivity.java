package com.tencent.mobileqq.zplan.friend;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.Unit;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\b\u001a\u00020\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/ZPlanFriendActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "", "beforeDoOnCreate", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "doOnResume", "<init>", "()V", "a0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanFriendActivity extends QBaseActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void beforeDoOnCreate() {
        super.beforeDoOnCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null) {
            systemBarComp.setStatusBarColor(-1);
        }
        super.doOnCreate(savedInstanceState);
        setContentView(R.layout.dcd);
        View findViewById = findViewById(R.id.pvw);
        findViewById.setFitsSystemWindows(true);
        findViewById.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        ZPlanFriendSelectFragment zPlanFriendSelectFragment = new ZPlanFriendSelectFragment();
        zPlanFriendSelectFragment.setArguments(getIntent().getExtras());
        Unit unit = Unit.INSTANCE;
        beginTransaction.add(R.id.pvw, zPlanFriendSelectFragment).commit();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        ImmersiveUtils.setStatusTextColor(true, getWindow());
    }
}
