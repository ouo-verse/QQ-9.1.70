package com.tencent.minibox.dynamic.api;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import androidx.annotation.Keep;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/minibox/dynamic/api/IDynamicApiManager;", "", "getActivityImpl", "Lcom/tencent/minibox/dynamic/api/IActivityDelegate;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/minibox/dynamic/api/BaseDelegatorActivity;", "getMiniBoxCore", "Lcom/tencent/minibox/dynamic/api/IMiniBoxCore;", "getProviderImpl", "Lcom/tencent/minibox/dynamic/api/IProviderDelegate;", "provider", "Landroid/content/ContentProvider;", "getReceiverImpl", "Lcom/tencent/minibox/dynamic/api/IReceiverDelegate;", "receiver", "Landroid/content/BroadcastReceiver;", "getServiceImpl", "Lcom/tencent/minibox/dynamic/api/IServiceDelegate;", "service", "Landroid/app/Service;", "MiniBoxDynamicApi_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public interface IDynamicApiManager {
    @Nullable
    IActivityDelegate getActivityImpl(@NotNull BaseDelegatorActivity activity);

    @NotNull
    IMiniBoxCore getMiniBoxCore();

    @Nullable
    IProviderDelegate getProviderImpl(@NotNull ContentProvider provider);

    @Nullable
    IReceiverDelegate getReceiverImpl(@NotNull BroadcastReceiver receiver);

    @Nullable
    IServiceDelegate getServiceImpl(@NotNull Service service);
}
