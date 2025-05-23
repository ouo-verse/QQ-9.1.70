package com.tencent.mobileqq.perf.receiver;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.perf.config.QQPerfConfigLoader;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u0007\u001a\u00020\u00042\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/perf/receiver/c;", "", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "countReceivers", "c", "Landroid/os/Looper;", "looper", "", "d", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "I", "lastTotalNum", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/perf/receiver/c$a;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f257962a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int lastTotalNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<a> listeners;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&J4\u0010\f\u001a\u00020\u00062\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\t2\u0006\u0010\u000b\u001a\u00020\u0004H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/perf/receiver/c$a;", "", "Lkotlin/Pair;", "", "", "receiverAndCount", "", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "countReceivers", "total", "b", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void a(@NotNull Pair<String, Integer> receiverAndCount);

        void b(@NotNull HashMap<String, Integer> countReceivers, int total);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/perf/receiver/c$b", "Lcom/tencent/mobileqq/perf/tracker/callback/a;", "", "onProcessForeground", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.perf.tracker.callback.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Handler handler = c.handler;
                Handler handler2 = null;
                if (handler == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("handler");
                    handler = null;
                }
                handler.removeMessages(1);
                Handler handler3 = c.handler;
                if (handler3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("handler");
                } else {
                    handler2 = handler3;
                }
                handler2.sendEmptyMessageDelayed(1, QQPerfConfigLoader.f257603a.b().f().a());
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f257962a = new c();
            listeners = new CopyOnWriteArrayList<>();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int c(HashMap<String, Integer> countReceivers) {
        int i3 = 0;
        for (Map.Entry<String, Integer> entry : countReceivers.entrySet()) {
            String key = entry.getKey();
            int intValue = entry.getValue().intValue();
            i3 += intValue;
            if (intValue > QQPerfConfigLoader.f257603a.b().f().e()) {
                QLog.e("ReceiverMonitor", 1, "toSingleReceiver. name: " + key + ", num: " + intValue + '.');
                f.f257970a.h(new Pair<>(key, Integer.valueOf(intValue)));
                Iterator<T> it = listeners.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).a(new Pair<>(key, Integer.valueOf(intValue)));
                }
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(Message it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HashMap<String, Integer> a16 = com.tencent.mobileqq.perf.receiver.a.f257954a.a();
        int c16 = f257962a.c(a16);
        Handler handler2 = null;
        if (c16 == lastTotalNum && !SceneTracker.j()) {
            Handler handler3 = handler;
            if (handler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handler");
                handler3 = null;
            }
            handler3.removeMessages(1);
        }
        lastTotalNum = c16;
        if (c16 > QQPerfConfigLoader.f257603a.b().f().f()) {
            f.f257970a.f(a16, c16);
            Iterator<T> it5 = listeners.iterator();
            while (it5.hasNext()) {
                ((a) it5.next()).b(a16, c16);
            }
            QLog.e("ReceiverMonitor", 1, "toManyReceiver. total num: " + c16 + '.');
        } else {
            QLog.i("ReceiverMonitor", 2, "receiver num: " + c16);
        }
        Handler handler4 = handler;
        if (handler4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("handler");
        } else {
            handler2 = handler4;
        }
        handler2.sendEmptyMessageDelayed(1, QQPerfConfigLoader.f257603a.b().f().a());
        return true;
    }

    public final void d(@NotNull Looper looper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) looper);
            return;
        }
        Intrinsics.checkNotNullParameter(looper, "looper");
        if (AppSetting.isPublicVersion()) {
            QLog.e("ReceiverMonitor", 1, "\u5916\u53d1\u7248\u672c\u6682\u4e0d\u5f00\u653e.");
            return;
        }
        QQPerfConfigLoader qQPerfConfigLoader = QQPerfConfigLoader.f257603a;
        if (!qQPerfConfigLoader.b().f().b()) {
            QLog.e("ReceiverMonitor", 1, "\u5f00\u5173\u6ca1\u6253\u5f00\uff0c\u4e0d\u5f00\u653e.");
            return;
        }
        if (Intrinsics.areEqual(looper, Looper.getMainLooper())) {
            QLog.e("ReceiverMonitor", 1, "don't use mainLooper. receiver analyze will consume 1~10 ms.");
            return;
        }
        if (!com.tencent.mobileqq.perf.receiver.a.f257954a.c()) {
            QLog.e("ReceiverMonitor", 1, "ReceiverMonitor init failed. Because of CountReceiversUtil init failed.");
            return;
        }
        Handler handler2 = new Handler(looper, new Handler.Callback() { // from class: com.tencent.mobileqq.perf.receiver.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean e16;
                e16 = c.e(message);
                return e16;
            }
        });
        handler = handler2;
        handler2.sendEmptyMessageDelayed(1, qQPerfConfigLoader.b().f().a());
        SceneTracker.f258213d.l(new b());
        QLog.e("ReceiverMonitor", 2, "init success.");
    }
}
