package com.tencent.guild.api.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0003H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/api/activity/IAIOSingleActivityApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAIOSingleActivityClass", "Ljava/lang/Class;", "isGuildAIOSingleTaskActivity", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "launchQFragmentStandard", "", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "fragmentCls", "Landroidx/fragment/app/Fragment;", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IAIOSingleActivityApi extends QRouteApi {
    @NotNull
    Class<?> getAIOSingleActivityClass();

    boolean isGuildAIOSingleTaskActivity(@NotNull Activity activity);

    void launchQFragmentStandard(@NotNull Context context, @NotNull Bundle bundle, @NotNull Class<? extends Fragment> fragmentCls);
}
