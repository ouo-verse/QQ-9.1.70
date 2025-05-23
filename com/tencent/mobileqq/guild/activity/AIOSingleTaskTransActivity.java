package com.tencent.mobileqq.guild.activity;

import android.R;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.guild.aio.article.launcher.GuildBaseFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/activity/AIOSingleTaskTransActivity;", "Lcom/tencent/mobileqq/app/BaseActivity;", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "F2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onBackPressed", "a0", "Lcom/tencent/guild/aio/article/launcher/GuildBaseFragment;", "mFragment", "<init>", "()V", "b0", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class AIOSingleTaskTransActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private GuildBaseFragment mFragment;

    private final GuildBaseFragment F2() {
        try {
            Object newInstance = Class.forName(getIntent().getStringExtra("public_fragment_class")).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.guild.aio.article.launcher.GuildBaseFragment");
            GuildBaseFragment guildBaseFragment = (GuildBaseFragment) newInstance;
            guildBaseFragment.setArguments(getIntent().getExtras());
            return guildBaseFragment;
        } catch (Exception e16) {
            QLog.e("AIOSingleTaskTransActivity", 1, "create fragment error", e16);
            return null;
        }
    }

    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        GuildBaseFragment guildBaseFragment = this.mFragment;
        boolean z16 = false;
        if (guildBaseFragment != null && guildBaseFragment.onBackEvent()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        this.mActNeedImmersive = false;
        super.onCreate(savedInstanceState);
        this.mFragment = F2();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "this.supportFragmentManager.beginTransaction()");
        if (getIntent().getBooleanExtra("disable_custom_anim", false)) {
            beginTransaction.setCustomAnimations(0, 0);
        }
        GuildBaseFragment guildBaseFragment = this.mFragment;
        Intrinsics.checkNotNull(guildBaseFragment);
        beginTransaction.replace(R.id.content, guildBaseFragment);
        beginTransaction.commitAllowingStateLoss();
    }
}
