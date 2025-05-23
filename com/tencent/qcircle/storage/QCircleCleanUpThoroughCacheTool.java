package com.tencent.qcircle.storage;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qcircle/storage/QCircleCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class QCircleCleanUpThoroughCacheTool implements y {
    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        y.a.a(this);
        ((IQCircleRFWApi) QRoute.api(IQCircleRFWApi.class)).notifyClearQCircleCache();
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        return y.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        return y.a.c(this);
    }
}
