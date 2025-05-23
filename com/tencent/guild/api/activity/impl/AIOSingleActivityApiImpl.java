package com.tencent.guild.api.activity.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.guild.api.activity.IAIOSingleActivityApi;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.b;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/guild/api/activity/impl/AIOSingleActivityApiImpl;", "Lcom/tencent/guild/api/activity/IAIOSingleActivityApi;", "()V", "getAIOSingleActivityClass", "Ljava/lang/Class;", "isGuildAIOSingleTaskActivity", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "launchQFragmentStandard", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "fragmentCls", "Landroidx/fragment/app/Fragment;", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class AIOSingleActivityApiImpl implements IAIOSingleActivityApi {
    @Override // com.tencent.guild.api.activity.IAIOSingleActivityApi
    @NotNull
    public Class<?> getAIOSingleActivityClass() {
        return ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).getAIOSingleActivityClass();
    }

    @Override // com.tencent.guild.api.activity.IAIOSingleActivityApi
    public boolean isGuildAIOSingleTaskActivity(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).isGuildAIOSingleTaskActivity(activity);
    }

    @Override // com.tencent.guild.api.activity.IAIOSingleActivityApi
    public void launchQFragmentStandard(@NotNull Context context, @NotNull Bundle bundle, @NotNull Class<? extends Fragment> fragmentCls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(fragmentCls, "fragmentCls");
        i.e(context, bundle, fragmentCls, new b().e(false).g(false).h(LaunchMode.standard).a());
    }
}
