package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.emosm.api.IEmoticonAIManagerService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.xweb.FileReaderHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\nH\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/emosm/api/impl/EmoticonAIManagerServiceImpl;", "Lcom/tencent/mobileqq/emosm/api/IEmoticonAIManagerService;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "setForceRequest", "", "timeStep", "getForceRequest", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "setLastRefreshTimeStamp", "Ljava/util/concurrent/atomic/AtomicBoolean;", "forceRequest", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicLong;", "lastRefreshTimeStamp", "Ljava/util/concurrent/atomic/AtomicLong;", "<init>", "()V", "Companion", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class EmoticonAIManagerServiceImpl implements IEmoticonAIManagerService {

    @NotNull
    public static final String TAG = "EmoticonAIManager";

    @NotNull
    private final AtomicBoolean forceRequest = new AtomicBoolean(true);

    @NotNull
    private final AtomicLong lastRefreshTimeStamp = new AtomicLong(0);

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonAIManagerService
    public boolean getForceRequest(long timeStep) {
        boolean z16 = this.forceRequest.get();
        if (!z16 && System.currentTimeMillis() - this.lastRefreshTimeStamp.get() > timeStep) {
            QLog.i(TAG, 1, "getForceRequest. Timed trigger request");
            return true;
        }
        return z16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonAIManagerService
    public void setForceRequest(boolean force) {
        this.forceRequest.set(force);
    }

    @Override // com.tencent.mobileqq.emosm.api.IEmoticonAIManagerService
    public void setLastRefreshTimeStamp(long timeStamp) {
        this.lastRefreshTimeStamp.set(timeStamp);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
