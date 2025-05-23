package com.tencent.biz.qqcircle.immersive.part.window;

import android.app.ActivityManager;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.part.window.QQLiveRemoteFloatWindowHelper;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qqlive.api.room.QQLiveFloatWindowEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0005R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0010R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/window/QQLiveRemoteFloatWindowHelper;", "Lcom/tencent/biz/qqcircle/immersive/part/window/a;", "", "e", "f", "", h.F, "c", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/immersive/part/window/QQLiveRemoteFloatWindowHelper$a;", "l", "b", "j", "i", "Z", "remoteAudienceFloatWindowShow", "requestWindowState", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Lazy;", "d", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "statusChangeListenerList", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QQLiveRemoteFloatWindowHelper extends com.tencent.biz.qqcircle.immersive.part.window.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QQLiveRemoteFloatWindowHelper f88336d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean remoteAudienceFloatWindowShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean requestWindowState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy statusChangeListenerList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/window/QQLiveRemoteFloatWindowHelper$a;", "", "", "isAudienceFloatWindowShow", "", "changed", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface a {
        void changed(boolean isAudienceFloatWindowShow);
    }

    static {
        Lazy lazy;
        QQLiveRemoteFloatWindowHelper qQLiveRemoteFloatWindowHelper = new QQLiveRemoteFloatWindowHelper();
        f88336d = qQLiveRemoteFloatWindowHelper;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CopyOnWriteArrayList<a>>() { // from class: com.tencent.biz.qqcircle.immersive.part.window.QQLiveRemoteFloatWindowHelper$statusChangeListenerList$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CopyOnWriteArrayList<QQLiveRemoteFloatWindowHelper.a> invoke() {
                return new CopyOnWriteArrayList<>();
            }
        });
        statusChangeListenerList = lazy;
        qQLiveRemoteFloatWindowHelper.e();
    }

    QQLiveRemoteFloatWindowHelper() {
    }

    private final CopyOnWriteArrayList<a> d() {
        return (CopyOnWriteArrayList) statusChangeListenerList.getValue();
    }

    private final void e() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void f() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.window.b
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveRemoteFloatWindowHelper.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g() {
        Iterator<T> it = f88336d.d().iterator();
        while (it.hasNext()) {
            ((a) it.next()).changed(remoteAudienceFloatWindowShow);
        }
    }

    public final void b(@NotNull a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
    }

    public final boolean h() {
        return false;
    }

    public final boolean i() {
        if (TextUtils.isEmpty("com.tencent.mobileqq:tool")) {
            return false;
        }
        Object systemService = QCircleApplication.APP.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) systemService);
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual("com.tencent.mobileqq:tool", it.next().processName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void j(@NotNull a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QLog.i("QQLiveRemoteFloatWindowHelper", 1, "onReceiveEvent: " + event);
        if (event != null && (event instanceof QQLiveFloatWindowEvent)) {
            remoteAudienceFloatWindowShow = ((QQLiveFloatWindowEvent) event).isHasAudienceFloat();
            requestWindowState = false;
            f();
        }
    }

    public final void c() {
    }
}
