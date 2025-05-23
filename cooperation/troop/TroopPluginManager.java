package cooperation.troop;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.manager.Manager;

/* loaded from: classes28.dex */
public class TroopPluginManager implements Manager {

    /* renamed from: h, reason: collision with root package name */
    public static final String f390884h = "cooperation.troop.TroopPluginManager";

    /* renamed from: d, reason: collision with root package name */
    protected WeakReference<QQAppInterface> f390885d;

    /* renamed from: e, reason: collision with root package name */
    public ConcurrentLinkedQueue<String> f390886e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    Handler f390887f = new a(Looper.getMainLooper());

    /* renamed from: cooperation.troop.TroopPluginManager$1, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f390888d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ at2.a f390889e;
        final /* synthetic */ TroopPluginManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            QQAppInterface qQAppInterface = this.this$0.f390885d.get();
            if (qQAppInterface == null) {
                return;
            }
            if (((IPluginManager) qQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN)).isPlugininstalled(this.f390888d)) {
                Message obtainMessage = this.this$0.f390887f.obtainMessage(1001);
                obtainMessage.obj = this.f390889e;
                obtainMessage.arg1 = 0;
                obtainMessage.sendToTarget();
                return;
            }
            if (this.this$0.f390886e.contains(this.f390888d)) {
                Message obtainMessage2 = this.this$0.f390887f.obtainMessage(1001);
                obtainMessage2.obj = this.f390889e;
                obtainMessage2.arg1 = 1;
                obtainMessage2.sendToTarget();
            }
            this.this$0.f390886e.add(this.f390888d);
            ThreadManagerV2.post(new InstallRunable(this.f390889e, this.f390888d), 8, null, true);
        }
    }

    /* loaded from: classes28.dex */
    class InstallRunable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        at2.a f390890d;

        /* renamed from: e, reason: collision with root package name */
        String f390891e;

        /* renamed from: f, reason: collision with root package name */
        Handler f390892f = new a(Looper.getMainLooper());

        /* loaded from: classes28.dex */
        class a extends Handler {
            a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                at2.a aVar;
                int i3 = message.what;
                if (i3 != 1001) {
                    if (i3 == 1002 && (aVar = InstallRunable.this.f390890d) != null) {
                        aVar.onInstallFinish(2);
                        return;
                    }
                    return;
                }
                at2.a aVar2 = InstallRunable.this.f390890d;
                if (aVar2 != null) {
                    aVar2.onInstallFinish(0);
                }
            }
        }

        /* loaded from: classes28.dex */
        class b extends OnPluginInstallListener.Stub {
            b() {
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallBegin(String str) throws RemoteException {
                if (QLog.isColorLevel()) {
                    QLog.d(TroopPluginManager.f390884h, 2, "Troop plugin onInstallBegin...  pluginId = " + InstallRunable.this.f390891e);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallDownloadProgress(String str, int i3, int i16) throws RemoteException {
                if (QLog.isColorLevel()) {
                    QLog.d(TroopPluginManager.f390884h, 2, "Troop plugin onInstallDownloadProgress... pluginId = " + InstallRunable.this.f390891e);
                }
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallError(String str, int i3) throws RemoteException {
                if (QLog.isColorLevel()) {
                    QLog.d(TroopPluginManager.f390884h, 2, "Troop plugin onInstallError... = " + InstallRunable.this.f390891e);
                }
                TroopPluginManager.this.f390886e.remove(str);
                InstallRunable.this.f390892f.sendEmptyMessage(1002);
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 1, null, null, null, null);
            }

            @Override // com.tencent.mobileqq.pluginsdk.OnPluginInstallListener
            public void onInstallFinish(String str) throws RemoteException {
                if (QLog.isColorLevel()) {
                    QLog.d(TroopPluginManager.f390884h, 2, "Troop plugin onInstallFinish...   pluginId = " + InstallRunable.this.f390891e);
                }
                TroopPluginManager.this.f390886e.remove(str);
                InstallRunable.this.f390892f.sendEmptyMessage(1001);
                ReportController.o(null, "P_CliOper", "BizTechReport", "", "troop_plugin", "install_plugin", 0, 0, null, null, null, null);
            }
        }

        public InstallRunable(at2.a aVar, String str) {
            this.f390890d = aVar;
            this.f390891e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPluginManager iPluginManager;
            QQAppInterface qQAppInterface = TroopPluginManager.this.f390885d.get();
            if (qQAppInterface == null || (iPluginManager = (IPluginManager) qQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN)) == null) {
                return;
            }
            iPluginManager.installPlugin(this.f390891e, new b());
        }
    }

    /* loaded from: classes28.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                ((at2.a) message.obj).onInstallFinish(message.arg1);
            }
        }
    }

    public TroopPluginManager(QQAppInterface qQAppInterface) {
        this.f390885d = new WeakReference<>(qQAppInterface);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (pluginCommunicationHandler != null) {
            pluginCommunicationHandler.unregister("troop.troopmemcard.get_app_interface_data");
            pluginCommunicationHandler.unregister("troop.manage.get_app_interface_data");
        }
        this.f390887f.removeMessages(1001);
        WeakReference<QQAppInterface> weakReference = this.f390885d;
        if (weakReference != null) {
            weakReference.clear();
        }
    }
}
