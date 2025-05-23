package com.tencent.mobileqq.settings.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.settings.IQQSettingApi;
import com.tencent.mobileqq.settings.fragment.GuildPermissionFragment;
import com.tencent.mobileqq.settings.fragment.OperationNotificationSettingFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/settings/impl/QQSettingApiImpl;", "Lcom/tencent/mobileqq/settings/IQQSettingApi;", "()V", "launcherGuildPermissionSetting", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "launcherOperationNotificationSetting", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQSettingApiImpl implements IQQSettingApi {
    @Override // com.tencent.mobileqq.settings.IQQSettingApi
    public void launcherGuildPermissionSetting(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, intent, GuildPermissionFragment.class);
    }

    @Override // com.tencent.mobileqq.settings.IQQSettingApi
    public void launcherOperationNotificationSetting(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QPublicFragmentActivity.start(context, OperationNotificationSettingFragment.class);
    }
}
