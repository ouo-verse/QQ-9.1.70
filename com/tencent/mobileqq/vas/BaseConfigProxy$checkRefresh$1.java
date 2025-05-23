package com.tencent.mobileqq.vas;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.vas.BaseConfigProxy;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseConfigProxy$checkRefresh$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final BaseConfigProxy$checkRefresh$1 f307820d = new BaseConfigProxy$checkRefresh$1();

    @Override // java.lang.Runnable
    public final void run() {
        BaseConfigProxy.Companion companion = BaseConfigProxy.INSTANCE;
        if (companion.getRefreshDataTasks().isEmpty()) {
            return;
        }
        Iterator<Map.Entry<String, Function0<Unit>>> it = companion.getRefreshDataTasks().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().invoke();
        }
        BaseConfigProxy.INSTANCE.getRefreshDataTasks().clear();
    }
}
