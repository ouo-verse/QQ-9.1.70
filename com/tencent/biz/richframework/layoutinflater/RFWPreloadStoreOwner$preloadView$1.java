package com.tencent.biz.richframework.layoutinflater;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.map.geolocation.TencentLocation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 1})
/* loaded from: classes5.dex */
final class RFWPreloadStoreOwner$preloadView$1 implements Runnable {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $count;
    final /* synthetic */ Class $viewClass;
    final /* synthetic */ RFWPreloadStoreOwner this$0;

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Constructor declaredConstructor = this.$viewClass.getDeclaredConstructor(Context.class);
            ArrayList arrayList = new ArrayList();
            int i3 = this.$count;
            for (int i16 = 0; i16 < i3; i16++) {
                Object newInstance = declaredConstructor.newInstance(this.$context);
                if (newInstance != null) {
                    arrayList.add((View) newInstance);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
            }
            this.this$0.storePreloadView(arrayList);
        } catch (Exception e16) {
            RFWLog.e("RFWPreloadContextHelper", RFWLog.USR, e16);
        }
    }
}
