package com.tencent.mobileqq.guild.activity;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.aio.activity.GuildChatActivityAbility;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import i12.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0014J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\"\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/activity/GuildChatActivity;", "Lcom/tencent/mobileqq/app/BaseActivity;", "", "setUpOrientation", "Landroid/os/Bundle;", "outState", "removeFragmentState", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "doOnDestroy", "Landroid/content/Intent;", "intent", "doOnNewIntent", "", "keyCode", "Landroid/view/KeyEvent;", "event", "doOnKeyDown", "doOnBackPressed", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "doOnActivityResult", "onPostThemeChanged", "onSaveInstanceState", "Lcom/tencent/guild/aio/activity/GuildChatActivityAbility;", "a0", "Lcom/tencent/guild/aio/activity/GuildChatActivityAbility;", "guildChatActivityInject", "isGProNotReady", "()Z", "<init>", "()V", "b0", "a", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildChatActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private GuildChatActivityAbility guildChatActivityInject;

    private final boolean isGProNotReady() {
        return ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isGProNotReady();
    }

    private final void setUpOrientation() {
        setRequestedOrientation(AppSetting.o(this) ? -1 : 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int resultCode, Intent data) {
        GuildChatActivityAbility guildChatActivityAbility = this.guildChatActivityInject;
        if (guildChatActivityAbility != null) {
            if (guildChatActivityAbility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatActivityInject");
                guildChatActivityAbility = null;
            }
            guildChatActivityAbility.c(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        GuildChatActivityAbility guildChatActivityAbility = this.guildChatActivityInject;
        if (guildChatActivityAbility != null) {
            if (guildChatActivityAbility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatActivityInject");
                guildChatActivityAbility = null;
            }
            if (guildChatActivityAbility.k(this)) {
                return;
            }
        }
        super.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        setUpOrientation();
        this.mActNeedImmersive = false;
        super.doOnCreate(savedInstanceState);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        if (isGProNotReady()) {
            QLog.i("GuildChatActivityAbility", 1, "isGProNotReady");
            beginTransaction.replace(R.id.content, ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getGProWaitLogicFragment(), "GProWaitLogicFragment").commitAllowingStateLoss();
        } else {
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag("GProWaitLogicFragment");
            if (findFragmentByTag != null) {
                QLog.e("GuildChatActivityAbility", 1, "has gProWaitLogicFragment");
                beginTransaction.remove(findFragmentByTag).commitAllowingStateLoss();
            }
            GuildChatActivityAbility guildChatActivityAbility = new GuildChatActivityAbility();
            guildChatActivityAbility.l(this);
            this.guildChatActivityInject = guildChatActivityAbility;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        GuildChatActivityAbility guildChatActivityAbility = this.guildChatActivityInject;
        if (guildChatActivityAbility != null) {
            if (guildChatActivityAbility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatActivityInject");
                guildChatActivityAbility = null;
            }
            guildChatActivityAbility.m(this);
        }
        b.f407029a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int keyCode, KeyEvent event) {
        GuildChatActivityAbility guildChatActivityAbility = this.guildChatActivityInject;
        if (guildChatActivityAbility != null) {
            if (guildChatActivityAbility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatActivityInject");
                guildChatActivityAbility = null;
            }
            if (guildChatActivityAbility.n(keyCode, event, this)) {
                return true;
            }
        }
        return super.doOnKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        GuildChatActivityAbility guildChatActivityAbility = this.guildChatActivityInject;
        if (guildChatActivityAbility != null) {
            if (guildChatActivityAbility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatActivityInject");
                guildChatActivityAbility = null;
            }
            guildChatActivityAbility.o(intent, this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        GuildChatActivityAbility guildChatActivityAbility = this.guildChatActivityInject;
        if (guildChatActivityAbility != null) {
            if (guildChatActivityAbility == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildChatActivityInject");
                guildChatActivityAbility = null;
            }
            guildChatActivityAbility.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        removeFragmentState(outState);
        removeFragmentState(outState.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key"));
    }

    private final void removeFragmentState(Bundle outState) {
        if (outState != null) {
            outState.remove("android:viewHierarchyState");
            outState.remove("android:fragments");
            outState.remove("android:support:fragments");
        }
    }
}
