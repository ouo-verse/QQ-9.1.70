package com.tencent.qqlive.common.monitor;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqlive/common/monitor/b;", "Lcom/tencent/qqlive/common/monitor/j;", "", "b", "e", "com/tencent/qqlive/common/monitor/b$a", "Lcom/tencent/qqlive/common/monitor/b$a;", "simpleNetInfoHandler", "<init>", "()V", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b extends j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a simpleNetInfoHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqlive/common/monitor/b$a", "Lcom/tencent/qqlive/common/monitor/k;", "", "p0", "", "onNetMobile2Wifi", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a extends k {
        a() {
        }

        @Override // com.tencent.qqlive.common.monitor.k, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(@Nullable String p06) {
            b.this.d();
        }
    }

    public b() {
        super(null);
        this.simpleNetInfoHandler = new a();
    }

    @Override // com.tencent.qqlive.common.monitor.j
    public void b() {
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.simpleNetInfoHandler);
    }

    @Override // com.tencent.qqlive.common.monitor.j
    public void e() {
        AppNetConnInfo.unregisterNetInfoHandler(this.simpleNetInfoHandler);
    }
}
