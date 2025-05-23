package com.tencent.mobileqq.app;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes11.dex */
public class TroopQZoneUploadAlbumHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;
    private volatile int C;
    private final LinkedBlockingQueue<Integer> D;
    private volatile boolean E;
    private bd F;
    private bc G;
    private volatile boolean H;
    private ServiceConnection I;

    /* renamed from: d, reason: collision with root package name */
    Handler f195151d;

    /* renamed from: e, reason: collision with root package name */
    Messenger f195152e;

    /* renamed from: f, reason: collision with root package name */
    Messenger f195153f;

    /* renamed from: h, reason: collision with root package name */
    SparseArray<e> f195154h;

    /* renamed from: i, reason: collision with root package name */
    private final ArrayList<d> f195155i;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f195156m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f195157a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Looper looper, QQAppInterface qQAppInterface) {
            super(looper);
            this.f195157a = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopQZoneUploadAlbumHandler.this, looper, qQAppInterface);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 1000) {
                    if (i3 != 1001) {
                        switch (i3) {
                            case 1003:
                                if (QLog.isColorLevel()) {
                                    QLog.d("UploadPhoto", 2, "Get Message failed. clientKey= " + message.arg1 + " arg2=" + message.arg2);
                                }
                                TroopQZoneUploadAlbumHandler.this.M2(message.what, message.arg1, message.arg2);
                                return;
                            case 1004:
                                if (QLog.isColorLevel()) {
                                    QLog.d("UploadPhoto", 2, "Get Message no task. clientKey= " + message.arg1 + " arg2=" + message.arg2);
                                }
                                TroopQZoneUploadAlbumHandler.this.M2(message.what, message.arg1, message.arg2);
                                TroopQZoneUploadAlbumHandler.this.f195154h.clear();
                                return;
                            case 1005:
                                if (QLog.isColorLevel()) {
                                    QLog.d("UploadPhoto", 2, "Get Message task removed. clientKey= " + message.arg1 + " arg2=" + message.arg2);
                                }
                                int i16 = message.arg1;
                                TroopQZoneUploadAlbumHandler.this.M2(message.what, i16, message.arg2);
                                TroopQZoneUploadAlbumHandler.this.f195154h.remove(i16);
                                return;
                            default:
                                return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("UploadPhoto", 2, "Get Message Progress. clientKey= " + message.arg1 + " progress=" + message.arg2);
                    }
                    TroopQZoneUploadAlbumHandler.this.M2(message.what, message.arg1, message.arg2);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("UploadPhoto", 2, "Get Message Finished. clientKey= " + message.arg1 + " arg2=" + message.arg2);
                }
                TroopQZoneUploadAlbumHandler.this.M2(message.what, message.arg1, message.arg2);
                return;
            }
            Object[] objArr = (Object[]) message.obj;
            int intValue = ((Integer) objArr[0]).intValue();
            e eVar = (e) objArr[1];
            int intValue2 = ((Integer) objArr[2]).intValue();
            int intValue3 = ((Integer) objArr[3]).intValue();
            TroopQZoneUploadAlbumHandler.this.L2(eVar.f195162a, intValue2, intValue3);
            TroopQZoneUploadAlbumHandler.this.Q2(this.f195157a, intValue, eVar.f195163b, eVar.f195162a, intValue2, intValue3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements ServiceConnection {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopQZoneUploadAlbumHandler.this);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                TroopQZoneUploadAlbumHandler.this.C = 2;
                TroopQZoneUploadAlbumHandler.this.E = false;
                if (QLog.isColorLevel()) {
                    QLog.d("UploadPhoto", 2, "onServiceConnected()...");
                }
                TroopQZoneUploadAlbumHandler.this.f195152e = new Messenger(iBinder);
                TroopQZoneUploadAlbumHandler.this.f195153f = new Messenger(TroopQZoneUploadAlbumHandler.this.f195151d);
                TroopQZoneUploadAlbumHandler.this.J2();
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentName, (Object) iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) componentName);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("UploadPhoto", 2, "onServiceDisconnected()...");
            }
            TroopQZoneUploadAlbumHandler troopQZoneUploadAlbumHandler = TroopQZoneUploadAlbumHandler.this;
            troopQZoneUploadAlbumHandler.f195152e = null;
            troopQZoneUploadAlbumHandler.C = 4;
            TroopQZoneUploadAlbumHandler.this.f195154h.clear();
            TroopQZoneUploadAlbumHandler troopQZoneUploadAlbumHandler2 = TroopQZoneUploadAlbumHandler.this;
            troopQZoneUploadAlbumHandler2.f195153f = null;
            troopQZoneUploadAlbumHandler2.E = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface c {
        void a(View view, long j3, int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        WeakReference<View> f195160a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference<c> f195161b;

        public c a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (c) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f195161b.get();
        }

        public View b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f195160a.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f195162a;

        /* renamed from: b, reason: collision with root package name */
        public String f195163b;
    }

    TroopQZoneUploadAlbumHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195152e = null;
        this.f195153f = null;
        this.f195154h = new SparseArray<>();
        this.f195155i = new ArrayList<>();
        this.C = 0;
        this.D = new LinkedBlockingQueue<>();
        this.E = false;
        this.H = false;
        this.I = new b();
        this.f195156m = qQAppInterface;
        this.f195151d = new a(Looper.getMainLooper(), qQAppInterface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J2() {
        if (this.F == null) {
            bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("UploadPhoto", 5);
            this.F = newHandlerRecycleThread;
            this.G = newHandlerRecycleThread.b();
        }
        this.G.post(new Runnable() { // from class: com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopQZoneUploadAlbumHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int intValue;
                Messenger messenger;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                while (!TroopQZoneUploadAlbumHandler.this.E) {
                    try {
                        intValue = ((Integer) TroopQZoneUploadAlbumHandler.this.D.take()).intValue();
                        messenger = TroopQZoneUploadAlbumHandler.this.f195152e;
                    } catch (RemoteException e16) {
                        QLog.e("UploadPhoto", 1, e16, new Object[0]);
                    } catch (InterruptedException e17) {
                        TroopQZoneUploadAlbumHandler.this.E = true;
                        QLog.e("UploadPhoto", 1, e17, new Object[0]);
                    }
                    if (messenger != null && messenger.getBinder() != null && TroopQZoneUploadAlbumHandler.this.f195152e.getBinder().isBinderAlive() && TroopQZoneUploadAlbumHandler.this.f195152e.getBinder().pingBinder()) {
                        Message obtain = Message.obtain(null, 998, intValue, 0);
                        TroopQZoneUploadAlbumHandler troopQZoneUploadAlbumHandler = TroopQZoneUploadAlbumHandler.this;
                        if (troopQZoneUploadAlbumHandler.f195153f == null) {
                            troopQZoneUploadAlbumHandler.f195153f = new Messenger(TroopQZoneUploadAlbumHandler.this.f195151d);
                        }
                        TroopQZoneUploadAlbumHandler troopQZoneUploadAlbumHandler2 = TroopQZoneUploadAlbumHandler.this;
                        obtain.replyTo = troopQZoneUploadAlbumHandler2.f195153f;
                        troopQZoneUploadAlbumHandler2.f195152e.send(obtain);
                    }
                    QLog.i("UploadPhoto", 1, "\u9700\u8981\u91cd\u65b0\u521b\u5efa\u8fde\u63a5");
                    TroopQZoneUploadAlbumHandler.this.P2();
                    TroopQZoneUploadAlbumHandler.this.doBindService();
                    TroopQZoneUploadAlbumHandler.this.D.offer(Integer.valueOf(intValue));
                    TroopQZoneUploadAlbumHandler.this.E = true;
                }
            }
        });
    }

    private void K2(int i3) {
        this.f195154h.remove(i3);
        if (this.f195154h.size() == 0) {
            O2();
            return;
        }
        if (this.f195152e == null) {
            return;
        }
        try {
            this.f195152e.send(Message.obtain(null, 999, i3, 0));
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    private void N2(int i3, e eVar, int i16, int i17) {
        Message obtainMessage = this.f195151d.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = new Object[]{Integer.valueOf(i3), eVar, Integer.valueOf(i16), Integer.valueOf(i17)};
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doBindService() {
        if (this.C != 2 && this.C != 1) {
            if (this.H) {
                if (QLog.isColorLevel()) {
                    QLog.w("UploadPhoto", 2, "TroopQZoneUploadAlbumHandler \u5df2\u7ecf\u88ab\u9500\u6bc1\uff0c\u4e0d\u80fddoBindService");
                }
            } else {
                this.C = 1;
                QZoneHelper.bindQzonePublishQueueService(this.f195156m, this.I);
            }
        }
    }

    void L2(long j3, int i3, int i16) {
        int i17 = 0;
        while (i17 < this.f195155i.size()) {
            d dVar = this.f195155i.get(i17);
            View b16 = dVar.b();
            c a16 = dVar.a();
            if (b16 != null && a16 != null) {
                a16.a(b16, j3, i3, i16);
            } else {
                this.f195155i.remove(i17);
                i17--;
            }
            i17++;
        }
    }

    protected void M2(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        e eVar = this.f195154h.get(i16, null);
        if (eVar == null) {
            return;
        }
        N2(i16, eVar, i3, i17);
    }

    public boolean O2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        P2();
        try {
            QZoneHelper.stopQzonePublishQueueService(this.f195156m.getApp());
            this.f195154h.clear();
            return true;
        } catch (Exception e16) {
            QLog.i("UploadPhoto", 1, "", e16);
            return false;
        }
    }

    public void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            if (this.C == 3) {
                return;
            }
            BaseApplication.getContext().unbindService(this.I);
            this.C = 3;
        }
    }

    public void Q2(QQAppInterface qQAppInterface, int i3, String str, long j3, int i16, int i17) {
        StructMsgForGeneralShare structMsgForGeneralShare;
        StructMsgForGeneralShare structMsgForGeneralShare2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, Integer.valueOf(i3), str, Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        MessageRecord P = qQAppInterface.getMessageFacade().P(str, 1, j3);
        if (P == null) {
            K2(i3);
            return;
        }
        if (P.msgtype == -2011) {
            AbsStructMsg absStructMsg = ((MessageForStructing) P).structingMsg;
            if (absStructMsg instanceof StructMsgForGeneralShare) {
                structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg;
                structMsgForGeneralShare2 = structMsgForGeneralShare;
                if (structMsgForGeneralShare2 == null && structMsgForGeneralShare2.getProgress() >= 0) {
                    if (i16 == 1001 && P.extraflag != 32768) {
                        structMsgForGeneralShare2.setSummary(BaseApplication.getContext().getResources().getString(R.string.a2h));
                        structMsgForGeneralShare2.setProgress(i17);
                        return;
                    }
                    String string = BaseApplication.getContext().getResources().getString(R.string.a2i);
                    int i18 = 32772;
                    if (i16 != 1000 && i16 != 1004) {
                        if (i16 == 1003) {
                            string = BaseApplication.getContext().getResources().getString(R.string.a2g);
                            i18 = 32768;
                        } else if (i16 == 1005) {
                            string = BaseApplication.getContext().getResources().getString(R.string.a2f);
                            structMsgForGeneralShare2.mMsgActionData = "";
                            structMsgForGeneralShare2.mMsg_A_ActionData = "";
                            i18 = 32770;
                        }
                    } else {
                        string = BaseApplication.getContext().getResources().getString(R.string.a2i);
                    }
                    structMsgForGeneralShare2.setProgress(100);
                    structMsgForGeneralShare2.setSummary(string);
                    structMsgForGeneralShare2.mMsgBrief = HardCodeUtil.qqStr(R.string.up_) + string;
                    qQAppInterface.getMsgCache().G1(str, 1, j3);
                    qQAppInterface.getMessageFacade().Z0(str, 1, j3, i18, 0);
                    qQAppInterface.getMessageFacade().Y0(str, 1, j3, structMsgForGeneralShare2.getBytes());
                    notifyUI(999, true, str);
                    return;
                }
                K2(i3);
            }
        }
        structMsgForGeneralShare = null;
        structMsgForGeneralShare2 = structMsgForGeneralShare;
        if (structMsgForGeneralShare2 == null) {
        }
        K2(i3);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Class) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return dg.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UploadPhoto", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.H = true;
        this.E = true;
        this.f195154h.clear();
        O2();
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
