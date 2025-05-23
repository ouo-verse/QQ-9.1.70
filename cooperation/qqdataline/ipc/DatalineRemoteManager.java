package cooperation.qqdataline.ipc;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.ipc.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DatalineRemoteManager implements Observer {

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f390536d;

    /* renamed from: e, reason: collision with root package name */
    cooperation.qqdataline.ipc.a f390537e;

    /* renamed from: f, reason: collision with root package name */
    boolean f390538f = false;

    /* renamed from: h, reason: collision with root package name */
    ArrayList<Bundle> f390539h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    boolean f390540i = false;

    /* renamed from: m, reason: collision with root package name */
    private ServiceConnection f390541m = new a();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            DatalineRemoteManager datalineRemoteManager = DatalineRemoteManager.this;
            datalineRemoteManager.f390538f = false;
            datalineRemoteManager.f390537e = a.AbstractBinderC10109a.j(iBinder);
            if (QLog.isColorLevel()) {
                QLog.d("DatalineRemoteManager", 2, "mDatalineService connected");
            }
            RegisterProxySvcPackHandler registerProxySvcPackHandler = (RegisterProxySvcPackHandler) DatalineRemoteManager.this.f390536d.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
            DatalineRemoteManager.this.i(registerProxySvcPackHandler.P2(), registerProxySvcPackHandler.Q2(), registerProxySvcPackHandler.R2(), registerProxySvcPackHandler.S2(), registerProxySvcPackHandler.T2());
            DatalineRemoteManager.this.h();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            DatalineRemoteManager.this.f390536d.getApplication().unbindService(DatalineRemoteManager.this.f390541m);
            DatalineRemoteManager datalineRemoteManager = DatalineRemoteManager.this;
            datalineRemoteManager.f390537e = null;
            datalineRemoteManager.f390538f = false;
            if (QLog.isColorLevel()) {
                QLog.d("DatalineRemoteManager", 2, "mDatalineService disconnected");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b extends RemoteCommand {
        b(String str) {
            super(str);
        }

        @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
        public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
            if (bundle == null) {
                return null;
            }
            bundle.setClassLoader(getClass().getClassLoader());
            Bundle f16 = DatalineRemoteManager.this.f(bundle);
            if (f16 != null) {
                f16.setClassLoader(getClass().getClassLoader());
            }
            if (onInvokeFinishLinstener != null) {
                onInvokeFinishLinstener.onInvokeFinish(f16);
            }
            return f16;
        }
    }

    public DatalineRemoteManager(QQAppInterface qQAppInterface) {
        this.f390536d = qQAppInterface;
        qQAppInterface.getMessageFacade().addObserver(this);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle f(Bundle bundle) {
        if (bundle.getString("invoke_cmd").equals("BusinessHandler_makeSureProxyServiceStart")) {
            l();
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DatalineRemoteManager", 2, "OnRemoteInvoke unknow invokeCmd");
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Bundle bundle) {
        String str;
        if (bundle != null) {
            str = bundle.getString("notify_cmd");
        } else {
            str = "";
        }
        if (str.equals("onReceiveRegisterProxySvcPack")) {
            Iterator<Bundle> it = this.f390539h.iterator();
            while (it.hasNext()) {
                Bundle next = it.next();
                if (next.getString("notify_cmd").equals("onReceiveRegisterProxySvcPack")) {
                    this.f390539h.remove(next);
                    return;
                }
            }
            return;
        }
        if (str.equals("UpdateUnreadMsgsNum")) {
            Iterator<Bundle> it5 = this.f390539h.iterator();
            while (it5.hasNext()) {
                Bundle next2 = it5.next();
                if (next2.getString("notify_cmd").equals("UpdateUnreadMsgsNum")) {
                    this.f390539h.remove(next2);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f390539h.isEmpty()) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (Thread.currentThread() != mainLooper.getThread()) {
            new Handler(mainLooper).post(new Runnable() { // from class: cooperation.qqdataline.ipc.DatalineRemoteManager.3
                @Override // java.lang.Runnable
                public void run() {
                    Bundle remove;
                    while (!DatalineRemoteManager.this.f390539h.isEmpty() && (remove = DatalineRemoteManager.this.f390539h.remove(0)) != null) {
                        String string = remove.getString("notify_cmd");
                        try {
                            remove.setClassLoader(getClass().getClassLoader());
                            if (QLog.isColorLevel()) {
                                QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + string);
                            }
                            DatalineRemoteManager.this.f390537e.a("com.qqdataline.action.notify", remove);
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + string);
                            }
                        }
                    }
                }
            });
            return;
        }
        while (!this.f390539h.isEmpty()) {
            Bundle remove = this.f390539h.remove(0);
            String str = "";
            if (remove != null) {
                try {
                    str = remove.getString("notify_cmd");
                    remove.setClassLoader(getClass().getClassLoader());
                } catch (RemoteException e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + str);
                    }
                }
            }
            this.f390537e.a("com.qqdataline.action.notify", remove);
            if (QLog.isColorLevel()) {
                QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + str);
            }
        }
    }

    private void j(final Bundle bundle, boolean z16) {
        String str;
        if (bundle != null) {
            str = bundle.getString("notify_cmd");
        } else {
            str = "";
        }
        if (this.f390537e == null) {
            if (str.equals("onReceive")) {
                if (QLog.isColorLevel()) {
                    QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + str + " no need cached");
                    return;
                }
                return;
            }
            if (z16) {
                l();
            }
            if (QLog.isColorLevel()) {
                QLog.d("DatalineRemoteManager", 2, "postRemoteNotify mDatalineService not started strNotifyCmd:" + str + " cached");
            }
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable() { // from class: cooperation.qqdataline.ipc.DatalineRemoteManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DatalineRemoteManager.this.g(bundle);
                        DatalineRemoteManager.this.f390539h.add(bundle);
                    }
                });
                return;
            } else {
                g(bundle);
                this.f390539h.add(bundle);
                return;
            }
        }
        h();
        if (bundle != null) {
            try {
                bundle.setClassLoader(getClass().getClassLoader());
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send failed strNotifyCmd:" + str);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("DatalineRemoteManager", 2, "postRemoteNotify send success strNotifyCmd:" + str);
        }
        this.f390537e.a("com.qqdataline.action.notify", bundle);
    }

    private void k() {
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (pluginCommunicationHandler == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DatalineRemoteManager", 2, "registerRemoteCommand PluginCommunicationHandler.getInstance failed");
            }
        } else if (!pluginCommunicationHandler.containsCmd("dataline.remotecall")) {
            pluginCommunicationHandler.register(new b("dataline.remotecall"));
        }
    }

    private void l() {
        if (this.f390537e == null && !this.f390538f) {
            this.f390538f = true;
            if (QLog.isColorLevel()) {
                QLog.d("DatalineRemoteManager", 2, "mDatalineService start service");
            }
            DatalineProxyService.a(this.f390536d, this.f390541m);
        }
    }

    private void m() {
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (pluginCommunicationHandler == null) {
            if (QLog.isColorLevel()) {
                QLog.d("DatalineRemoteManager", 2, "unregisterRemoteCommand PluginCommunicationHandler.getInstance failed");
            }
        } else if (pluginCommunicationHandler.containsCmd("dataline.remotecall")) {
            pluginCommunicationHandler.unregister("dataline.remotecall");
        }
    }

    public void e() {
        if (this.f390536d.getMessageFacade() != null) {
            this.f390536d.getMessageFacade().deleteObserver(this);
        }
        m();
    }

    public void i(int i3, int i16, int i17, int i18, long j3) {
        Bundle bundle = new Bundle();
        bundle.putString("notify_cmd", "onReceiveRegisterProxySvcPack");
        bundle.putInt("iPcOnlineStatus", i3);
        bundle.putInt("iIsSupportDataLine", i16);
        bundle.putInt("iIsSupportPrintable", i17);
        bundle.putInt("iIsSupportViewPCFile", i18);
        bundle.putLong("iPcVersion", j3);
        j(bundle, false);
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        QQMessageFacade messageFacade = this.f390536d.getMessageFacade();
        if (messageFacade != null) {
            int H1 = messageFacade.H1();
            Bundle bundle = new Bundle();
            bundle.putString("notify_cmd", "UpdateUnreadMsgsNum");
            bundle.putInt("unread", H1);
            j(bundle, false);
        }
    }
}
