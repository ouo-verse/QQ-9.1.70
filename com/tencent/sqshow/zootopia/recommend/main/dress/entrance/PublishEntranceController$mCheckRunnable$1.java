package com.tencent.sqshow.zootopia.recommend.main.dress.entrance;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.recommend.main.dress.entrance.PublishEntranceController;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$mCheckRunnable$1", "Lcom/tencent/sqshow/zootopia/recommend/main/dress/entrance/PublishEntranceController$MyRunnable;", "", "param", "", "a", TencentLocation.RUN_MODE, "d", "I", "getVerticalOffset", "()I", "setVerticalOffset", "(I)V", "verticalOffset", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PublishEntranceController$mCheckRunnable$1 implements PublishEntranceController.MyRunnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int verticalOffset;
    final /* synthetic */ PublishEntranceController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PublishEntranceController$mCheckRunnable$1(PublishEntranceController publishEntranceController) {
        this.this$0 = publishEntranceController;
    }

    public void a(int param) {
        this.verticalOffset = param;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i3;
        QLog.i("PublishEntranceController_", 4, "mCheckRunnable :: start check");
        int i16 = this.verticalOffset;
        i3 = this.this$0.verticalOffset;
        if (i16 == i3) {
            QLog.i("PublishEntranceController_", 4, "mCheckRunnable :: check success");
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.this$0.mAutoShowTask, 1000L);
        }
    }
}
