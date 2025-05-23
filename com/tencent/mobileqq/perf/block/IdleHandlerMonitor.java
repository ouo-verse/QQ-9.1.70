package com.tencent.mobileqq.perf.block;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class IdleHandlerMonitor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "IdleHandlerMonitor";

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class ArrayListProxy extends ArrayList<MessageQueue.IdleHandler> {
        static IPatchRedirector $redirector_;
        Map<MessageQueue.IdleHandler, IdleHandlerProxy> map;

        ArrayListProxy(Collection<MessageQueue.IdleHandler> collection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) collection);
                return;
            }
            this.map = new HashMap();
            Iterator<MessageQueue.IdleHandler> it = collection.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
        }

        @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean remove(@NonNull Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof IdleHandlerProxy) {
                this.map.remove(((IdleHandlerProxy) obj).idleHandler);
                return super.remove(obj);
            }
            IdleHandlerProxy remove = this.map.remove(obj);
            if (remove != null) {
                return super.remove(remove);
            }
            return super.remove(obj);
        }

        @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean add(MessageQueue.IdleHandler idleHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) idleHandler)).booleanValue();
            }
            if (idleHandler instanceof IdleHandlerProxy) {
                return super.add((ArrayListProxy) idleHandler);
            }
            IdleHandlerProxy idleHandlerProxy = new IdleHandlerProxy(idleHandler);
            this.map.put(idleHandler, idleHandlerProxy);
            return super.add((ArrayListProxy) idleHandlerProxy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class IdleHandlerProxy implements MessageQueue.IdleHandler {
        static IPatchRedirector $redirector_;
        private long duration;
        private MessageQueue.IdleHandler idleHandler;

        IdleHandlerProxy(MessageQueue.IdleHandler idleHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) idleHandler);
            } else {
                this.duration = 400L;
                this.idleHandler = idleHandler;
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean queueIdle = this.idleHandler.queueIdle();
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (uptimeMillis2 > this.duration) {
                this.duration = uptimeMillis2;
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    str = "";
                } else {
                    str = peekAppRuntime.getCurrentUin();
                }
                HashMap hashMap = new HashMap();
                String name = this.idleHandler.getClass().getName();
                hashMap.put("cls", name);
                hashMap.put("block_time", uptimeMillis2 + "");
                QQBeaconReport.report(str, "idle_handler_block", hashMap);
                QLog.d(IdleHandlerMonitor.TAG, 1, name + " cost: " + uptimeMillis2);
            }
            return queueIdle;
        }
    }

    public IdleHandlerMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean start() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105977", false)) {
            return false;
        }
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = MessageQueue.class.getDeclaredField("mIdleHandlers");
            declaredField.setAccessible(true);
            synchronized (queue) {
                declaredField.set(queue, new ArrayListProxy((ArrayList) declaredField.get(queue)));
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return false;
        }
    }
}
