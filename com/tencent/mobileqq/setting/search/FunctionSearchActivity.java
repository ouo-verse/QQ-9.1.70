package com.tencent.mobileqq.setting.search;

import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.utils.ca;
import iq2.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/setting/search/FunctionSearchActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "", "doOnBackPressed", "Lcom/tencent/mobileqq/setting/search/FunctionSearchFragment;", "a0", "Lcom/tencent/mobileqq/setting/search/FunctionSearchFragment;", "getFragment", "()Lcom/tencent/mobileqq/setting/search/FunctionSearchFragment;", "setFragment", "(Lcom/tencent/mobileqq/setting/search/FunctionSearchFragment;)V", "fragment", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FunctionSearchActivity extends QBaseActivity {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FunctionSearchFragment fragment;

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        FunctionSearchFragment functionSearchFragment = this.fragment;
        if (functionSearchFragment != null) {
            boolean z16 = false;
            if (functionSearchFragment != null && !functionSearchFragment.finish()) {
                z16 = true;
            }
            if (!z16) {
                return;
            }
        }
        super.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            finish();
            return true;
        }
        getWindow().setSoftInputMode(16);
        getWindow().getDecorView().setSystemUiVisibility(1024);
        this.mActNeedImmersive = !c.g();
        ca.a(this);
        super.doOnCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.root);
        setContentView(frameLayout);
        FunctionSearchFragment functionSearchFragment = new FunctionSearchFragment();
        this.fragment = functionSearchFragment;
        functionSearchFragment.setArguments(getIntent().getExtras());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        FunctionSearchFragment functionSearchFragment2 = this.fragment;
        Intrinsics.checkNotNull(functionSearchFragment2);
        FragmentTransaction add = beginTransaction.add(R.id.root, functionSearchFragment2);
        FunctionSearchFragment functionSearchFragment3 = this.fragment;
        Intrinsics.checkNotNull(functionSearchFragment3);
        add.show(functionSearchFragment3).commitAllowingStateLoss();
        return true;
    }
}
