package com.tencent.mobileqq.qcoroutine.framework;

import android.os.Message;
import com.tencent.mobileqq.qcoroutine.api.a;
import com.tencent.mobileqq.qcoroutine.api.g;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012,\u0010\u001e\u001a(\u0012\u0004\u0012\u00020\u0001\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\b0\u001a\u00a2\u0006\u0002\b\u001d\u00a2\u0006\u0004\b\u001f\u0010 J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qcoroutine/framework/QHandler;", "Lcom/tencent/mobileqq/qcoroutine/api/c;", "Landroid/os/Message;", "msg", "", "delay", "", "isSerial", "", "i", "f", "e", h.F, "", "what", "d", "", "Lcom/tencent/mobileqq/qcoroutine/api/g;", "Ljava/util/Map;", "g", "()Ljava/util/Map;", "taskPool", "", "nameAndGroupId", "Lcom/tencent/mobileqq/qcoroutine/api/i;", "type", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "handleMessage", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qcoroutine/api/i;Lkotlin/jvm/functions/Function2;)V", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class QHandler extends com.tencent.mobileqq.qcoroutine.api.c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Message, g> taskPool;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qcoroutine/framework/QHandler$a", "Lcom/tencent/mobileqq/qcoroutine/api/a;", "", "b", "QCoroutine_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes16.dex */
    public static final class a implements com.tencent.mobileqq.qcoroutine.api.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Message f261790b;

        a(Message message) {
            this.f261790b = message;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) QHandler.this, (Object) message);
            }
        }

        @Override // com.tencent.mobileqq.qcoroutine.api.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                a.C8281a.a(this);
            }
        }

        @Override // com.tencent.mobileqq.qcoroutine.api.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                QHandler.this.g().remove(this.f261790b);
            }
        }

        @Override // com.tencent.mobileqq.qcoroutine.api.a
        public void onTaskStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                a.C8281a.b(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QHandler(@NotNull String nameAndGroupId, @NotNull i type, @NotNull Function2<? super com.tencent.mobileqq.qcoroutine.api.c, ? super Message, Unit> handleMessage) {
        super(handleMessage, nameAndGroupId, type);
        Intrinsics.checkNotNullParameter(nameAndGroupId, "nameAndGroupId");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(handleMessage, "handleMessage");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, nameAndGroupId, type, handleMessage);
        } else {
            this.taskPool = new ConcurrentHashMap();
        }
    }

    @Override // com.tencent.mobileqq.qcoroutine.api.c
    public void d(int what) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, what);
            return;
        }
        synchronized (this.taskPool) {
            Iterator<Map.Entry<Message, g>> it = this.taskPool.entrySet().iterator();
            while (it.hasNext()) {
                Message key = it.next().getKey();
                if (key.what == what) {
                    h(key);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.qcoroutine.api.c
    public void e(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            i(msg2, 0L, false);
        }
    }

    @Override // com.tencent.mobileqq.qcoroutine.api.c
    public void f(@NotNull Message msg2, long delay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msg2, Long.valueOf(delay));
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            i(msg2, delay, false);
        }
    }

    @NotNull
    public final Map<Message, g> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Map) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.taskPool;
    }

    public void h(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        g gVar = this.taskPool.get(msg2);
        if (gVar != null) {
            QTaskPoolKt.a(gVar);
        }
        this.taskPool.remove(msg2);
    }

    public void i(@NotNull final Message msg2, long delay, boolean isSerial) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, msg2, Long.valueOf(delay), Boolean.valueOf(isSerial));
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        g gVar = new g(a() + util.base64_pad_url + msg2.what, c(), new Runnable(msg2) { // from class: com.tencent.mobileqq.qcoroutine.framework.QHandler$sendMessage$runnable$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Message f261791d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f261791d = msg2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) QHandler.this, (Object) msg2);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                } else {
                    QHandler.this.b().invoke(QHandler.this, this.f261791d);
                }
            }
        });
        if (isSerial || delay <= 0) {
            gVar.m(a());
        }
        if (delay > 0) {
            gVar.h(delay);
        }
        gVar.g(new a(msg2));
        this.taskPool.put(msg2, gVar);
        QTaskPool e16 = d.f261833c.e(c());
        if (e16 != null) {
            e16.c(gVar);
        }
    }
}
