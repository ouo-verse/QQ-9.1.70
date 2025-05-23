package com.tencent.minibox.business;

import android.os.Bundle;
import com.tencent.minibox.business.api.AsyncCallback;
import com.tencent.minibox.common.thread.ThreadManager;
import com.tencent.minibox.contract.IMiniBoxPluginCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/minibox/business/MiniBoxEngine$stopApp$1", "Lcom/tencent/minibox/contract/IMiniBoxPluginCallback$Stub;", "onResult", "", "bundle", "Landroid/os/Bundle;", "MiniBoxBusiness_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes9.dex */
public final class MiniBoxEngine$stopApp$1 extends IMiniBoxPluginCallback.Stub {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AsyncCallback f151598d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniBoxEngine$stopApp$1(AsyncCallback asyncCallback) {
        this.f151598d = asyncCallback;
    }

    @Override // com.tencent.minibox.contract.IMiniBoxPluginCallback
    public void onResult(@NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "bundle");
        long j3 = bundle.getLong("key_delay_time", 0L);
        if (j3 <= 0) {
            AsyncCallback asyncCallback = this.f151598d;
            if (asyncCallback != null) {
                asyncCallback.onResult("stop success");
                return;
            }
            return;
        }
        ThreadManager.get().executeDelay(new Runnable() { // from class: com.tencent.minibox.business.MiniBoxEngine$stopApp$1$onResult$1
            @Override // java.lang.Runnable
            public final void run() {
                AsyncCallback asyncCallback2 = MiniBoxEngine$stopApp$1.this.f151598d;
                if (asyncCallback2 != null) {
                    asyncCallback2.onResult("stop success by delay");
                }
            }
        }, j3);
    }
}
