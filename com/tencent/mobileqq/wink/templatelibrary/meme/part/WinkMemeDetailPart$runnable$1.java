package com.tencent.mobileqq.wink.templatelibrary.meme.part;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/meme/part/WinkMemeDetailPart$runnable$1", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "I", HippyQQPagView.FunctionName.GET_PROGRESS, "()I", "a", "(I)V", "progress", "e", "incrementAmount", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemeDetailPart$runnable$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int progress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int incrementAmount = 1;
    final /* synthetic */ WinkMemeDetailPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkMemeDetailPart$runnable$1(WinkMemeDetailPart winkMemeDetailPart) {
        this.this$0 = winkMemeDetailPart;
    }

    public final void a(int i3) {
        this.progress = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        QCircleCommonLoadingDialog R9;
        int i3 = this.progress;
        if (i3 < 95) {
            this.progress = i3 + this.incrementAmount;
            R9 = this.this$0.R9();
            R9.setProgress(this.progress);
            ThreadManagerV2.getUIHandlerV2().postDelayed(this, 1000L);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this);
    }
}
