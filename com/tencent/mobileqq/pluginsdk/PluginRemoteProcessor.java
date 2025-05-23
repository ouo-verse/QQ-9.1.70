package com.tencent.mobileqq.pluginsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.tencent.mobileqq.pluginsdk.ipc.PluginRemoteService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes16.dex */
public class PluginRemoteProcessor {
    static IPatchRedirector $redirector_;
    private static PluginRemoteProcessor sInstance;
    private Handler mHandler;
    private volatile boolean mProcessing;
    private LinkedList<WrappedServiceConnection> mQueue;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public class WrappedServiceConnection implements ServiceConnection {
        static IPatchRedirector $redirector_;
        private int mBinderType;
        private Context mContext;
        private ServiceConnection mWrappedConnection;

        public WrappedServiceConnection(ServiceConnection serviceConnection, Context context, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, PluginRemoteProcessor.this, serviceConnection, context, Integer.valueOf(i3));
                return;
            }
            this.mWrappedConnection = serviceConnection;
            this.mContext = context;
            this.mBinderType = i3;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            WrappedServiceConnection wrappedServiceConnection;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName, (Object) iBinder);
                return;
            }
            try {
                this.mContext.getApplicationContext().unbindService(this);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 2, "unbindService, " + this);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "onServiceConnected, " + this);
            }
            this.mWrappedConnection.onServiceConnected(componentName, iBinder);
            synchronized (PluginRemoteProcessor.this.mQueue) {
                wrappedServiceConnection = (WrappedServiceConnection) PluginRemoteProcessor.this.mQueue.poll();
            }
            if (wrappedServiceConnection == null) {
                PluginRemoteProcessor.this.mProcessing = false;
                if (QLog.isColorLevel()) {
                    QLog.i("plugin_tag", 2, "queue empty");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "continue process");
            }
            PluginRemoteProcessor.this.processInnerDelay(wrappedServiceConnection, 300);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, "onServiceDisconnected, " + this);
            }
            this.mWrappedConnection.onServiceDisconnected(componentName);
        }
    }

    PluginRemoteProcessor() {
        Looper looper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mQueue = new LinkedList<>();
        IPluginAdapterProxy proxy = IPluginAdapterProxy.getProxy();
        if (proxy != null) {
            looper = proxy.getSubThreadLooper();
        } else {
            looper = null;
        }
        this.mHandler = new Handler(looper == null ? Looper.getMainLooper() : looper);
    }

    public static PluginRemoteProcessor get() {
        if (sInstance == null) {
            synchronized (PluginRemoteProcessor.class) {
                if (sInstance == null) {
                    sInstance = new PluginRemoteProcessor();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processInner(WrappedServiceConnection wrappedServiceConnection) {
        Class cls;
        int i3 = wrappedServiceConnection.mBinderType;
        if (i3 != 0) {
            if (i3 != 1) {
                cls = null;
            } else {
                cls = PluginRemoteService.Sub2.class;
            }
        } else {
            cls = PluginRemoteService.Sub1.class;
        }
        if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "processInner, " + wrappedServiceConnection + ", " + cls);
        }
        if (cls == null) {
            return;
        }
        Context applicationContext = wrappedServiceConnection.mContext.getApplicationContext();
        Intent intent = new Intent(applicationContext, (Class<?>) cls);
        intent.putExtra(PluginConst.KEY_BINDER_TYPE, wrappedServiceConnection.mBinderType);
        try {
            applicationContext.bindService(intent, wrappedServiceConnection, 1);
        } catch (SecurityException e16) {
            QLog.i("plugin_tag", 1, "processInner", e16);
            wrappedServiceConnection.onServiceDisconnected(new ComponentName(wrappedServiceConnection.mContext, cls.getCanonicalName()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processInnerDelay(WrappedServiceConnection wrappedServiceConnection, int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "processInnerDelay. " + i3 + ", " + wrappedServiceConnection);
        }
        this.mHandler.postDelayed(new Runnable(wrappedServiceConnection) { // from class: com.tencent.mobileqq.pluginsdk.PluginRemoteProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ WrappedServiceConnection val$wrapped;

            {
                this.val$wrapped = wrappedServiceConnection;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PluginRemoteProcessor.this, (Object) wrappedServiceConnection);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    PluginRemoteProcessor.this.processInner(this.val$wrapped);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, i3);
    }

    public void cancel(ServiceConnection serviceConnection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serviceConnection);
            return;
        }
        synchronized (this.mQueue) {
            Iterator<WrappedServiceConnection> it = this.mQueue.iterator();
            while (it.hasNext()) {
                WrappedServiceConnection next = it.next();
                try {
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                if (next.mWrappedConnection == serviceConnection) {
                    next.mContext.unbindService(next);
                    break;
                }
                continue;
            }
        }
    }

    public void process(Context context, ServiceConnection serviceConnection, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, serviceConnection, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("plugin_tag", 2, "PluginRemoteProcessor.process, " + i3);
        }
        WrappedServiceConnection wrappedServiceConnection = new WrappedServiceConnection(serviceConnection, context, i3);
        if (this.mProcessing) {
            if (QLog.isColorLevel()) {
                QLog.i("plugin_tag", 2, SemanticAttributes.MessagingDestinationKindValues.QUEUE);
            }
            synchronized (this.mQueue) {
                this.mQueue.offer(wrappedServiceConnection);
            }
            return;
        }
        this.mProcessing = true;
        processInnerDelay(wrappedServiceConnection, 0);
    }
}
