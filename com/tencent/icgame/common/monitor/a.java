package com.tencent.icgame.common.monitor;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/icgame/common/monitor/a;", "Lcom/tencent/icgame/common/monitor/j;", "", "b", "e", "com/tencent/icgame/common/monitor/a$a", "Lcom/tencent/icgame/common/monitor/a$a;", "simpleNetInfoHandler", "<init>", "()V", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a extends j {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C5827a simpleNetInfoHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/icgame/common/monitor/a$a", "Lcom/tencent/icgame/common/monitor/k;", "", "onNetMobile2None", "ic-game-common-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.common.monitor.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C5827a extends k {
        C5827a() {
        }

        @Override // com.tencent.icgame.common.monitor.k, com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            a.this.d();
        }
    }

    public a() {
        super(null);
        this.simpleNetInfoHandler = new C5827a();
    }

    @Override // com.tencent.icgame.common.monitor.j
    public void b() {
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.simpleNetInfoHandler);
    }

    @Override // com.tencent.icgame.common.monitor.j
    public void e() {
        AppNetConnInfo.unregisterNetInfoHandler(this.simpleNetInfoHandler);
    }
}
