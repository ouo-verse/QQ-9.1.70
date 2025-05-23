package com.tencent.mobileqq.guild.media.presenter;

import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/media/presenter/ImmersivePresenter$startMarkImmersiveGesture$1", "Ljava/util/TimerTask;", TencentLocation.RUN_MODE, "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ImmersivePresenter$startMarkImmersiveGesture$1 extends TimerTask {
    final /* synthetic */ ImmersivePresenter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmersivePresenter$startMarkImmersiveGesture$1(ImmersivePresenter immersivePresenter) {
        this.this$0 = immersivePresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ImmersivePresenter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final ImmersivePresenter immersivePresenter = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.presenter.k
            @Override // java.lang.Runnable
            public final void run() {
                ImmersivePresenter$startMarkImmersiveGesture$1.b(ImmersivePresenter.this);
            }
        });
    }
}
