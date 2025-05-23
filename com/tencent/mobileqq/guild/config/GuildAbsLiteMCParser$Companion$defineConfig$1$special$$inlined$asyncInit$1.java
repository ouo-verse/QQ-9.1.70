package com.tencent.mobileqq.guild.config;

import androidx.lifecycle.MutableLiveData;
import com.tencent.freesia.IConfigData;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0004"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/guild/util/ThreadUtils$executeOnWorkThread$1", "com/tencent/mobileqq/guild/base/extension/LiveDataKt$asyncInit$$inlined$executeOnWorkThread$1"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes13.dex */
public final class GuildAbsLiteMCParser$Companion$defineConfig$1$special$$inlined$asyncInit$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableLiveData f216042d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f216043e;

    @Override // java.lang.Runnable
    public final void run() {
        MutableLiveData mutableLiveData = this.f216042d;
        IConfigData loadConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(this.f216043e);
        Intrinsics.reifiedOperationMarker(1, "T");
        mutableLiveData.postValue(loadConfig);
    }
}
