package com.tencent.mobileqq.vas.social.service;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.api.ISquareOnlineStatusService;
import com.tencent.state.square.api.OnlineStatusListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0010\u0018\u0000 \u001a2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/social/service/b;", "Lcom/tencent/state/square/api/ISquareOnlineStatusService;", "", "init", "Lcom/tencent/state/square/api/OnlineStatusListener;", "listener", "registerListener", "unRegisterListener", "", "onlineStatus", "updateOnlineStatus", "destroy", "Ljava/util/concurrent/CopyOnWriteArrayList;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "observers", "com/tencent/mobileqq/vas/social/service/b$b", "b", "Lcom/tencent/mobileqq/vas/social/service/b$b;", "onlineStatusObserver", "Lcom/tencent/common/app/AppInterface;", "c", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "()V", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b implements ISquareOnlineStatusService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<OnlineStatusListener> observers = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final C8926b onlineStatusObserver = new C8926b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AppInterface app;

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void destroy() {
        this.observers.clear();
        AppInterface appInterface = this.app;
        if (appInterface != null) {
            appInterface.removeObserver(this.onlineStatusObserver);
        }
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void init() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        this.app = appInterface;
        if (appInterface != null) {
            appInterface.addObserver(this.onlineStatusObserver);
        }
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void registerListener(OnlineStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<OnlineStatusListener> copyOnWriteArrayList = this.observers;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.addIfAbsent(listener);
        }
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void unRegisterListener(OnlineStatusListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<OnlineStatusListener> copyOnWriteArrayList = this.observers;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(listener);
        }
    }

    @Override // com.tencent.state.square.api.ISquareOnlineStatusService
    public void updateOnlineStatus(int onlineStatus) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) runtimeService;
        if (AppRuntime.Status.build(onlineStatus) == null) {
            iOnlineStatusService.updateOnlineStatus(AppRuntime.Status.online, onlineStatus, 1);
        } else {
            iOnlineStatusService.updateOnlineStatus(AppRuntime.Status.build(onlineStatus), 0L, 1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/social/service/b$b", "Lcom/tencent/mobileqq/onlinestatus/av;", "", "isSuccess", "Landroid/os/Bundle;", "data", "", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.social.service.b$b, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8926b extends av {
        C8926b() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean isSuccess, Bundle data) {
            int i3 = data != null ? (int) data.getLong("onlineStatus", 0L) : 0;
            QLog.i("SquareOnlineStatusServiceImpl", 1, "onSetOnlineStatus, " + isSuccess + ", " + i3);
            Iterator it = b.this.observers.iterator();
            while (it.hasNext()) {
                ((OnlineStatusListener) it.next()).onStatusChange(isSuccess, i3);
            }
        }
    }
}
