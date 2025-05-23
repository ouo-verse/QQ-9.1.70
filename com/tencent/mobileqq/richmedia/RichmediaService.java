package com.tencent.mobileqq.richmedia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BinderWarpper;
import com.tencent.util.WeakReferenceHandler;
import cooperation.peak.PeakConstants;
import java.lang.ref.WeakReference;
import mqq.app.AppService;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RichmediaService extends AppService implements Handler.Callback {

    /* renamed from: i, reason: collision with root package name */
    static volatile RichmediaService f281316i;

    /* renamed from: m, reason: collision with root package name */
    static volatile WeakReferenceHandler f281317m;

    /* renamed from: d, reason: collision with root package name */
    Messenger f281318d;

    /* renamed from: e, reason: collision with root package name */
    Messenger f281319e;

    /* renamed from: f, reason: collision with root package name */
    a f281320f;

    /* renamed from: h, reason: collision with root package name */
    volatile b f281321h;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<RichmediaService> f281324a;

        public a(Looper looper, RichmediaService richmediaService) {
            super(looper);
            this.f281324a = new WeakReference<>(richmediaService);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            BinderWarpper binderWarpper;
            RichmediaService richmediaService = this.f281324a.get();
            if (richmediaService == null) {
                return;
            }
            Bundle data = message.getData();
            if (data != null) {
                data.setClassLoader(getClass().getClassLoader());
                data.getInt("msg_sub_cmd");
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 2) {
                    d.a("RichmediaService", "handleMessage MSG_C2S_UNREGISTER_CLIENT");
                    richmediaService.f281319e = null;
                    richmediaService.f281321h = null;
                    return;
                }
                return;
            }
            d.a("RichmediaService", "handleMessage MSG_C2S_REGISTER_CLIENT");
            richmediaService.f281319e = message.replyTo;
            if (data != null && (binderWarpper = (BinderWarpper) data.getParcelable("ICallBack_BinderWrapper")) != null) {
                richmediaService.f281321h = b.a.j(binderWarpper.binder);
                Bundle bundle = new Bundle();
                try {
                    bundle.putIntArray(PeakConstants.KEY_COMPRESS_CONFIG, ((ICompressOperator) QRoute.api(ICompressOperator.class)).getCompressConfigFromServer((QQAppInterface) ((AppService) richmediaService).app));
                    richmediaService.f281321h.M4(6, bundle);
                } catch (RemoteException e16) {
                    d.a("RichmediaService", "ICALLBACK_CMD_INIT_COMPRESS_CONFIG remote error:" + e16);
                    e16.printStackTrace();
                }
            }
        }
    }

    public static boolean A(CompressInfo compressInfo) {
        d.a("RichmediaService", "startCompress start . compressInfo.localUUID = " + compressInfo.f258514d + ",compressInfo.srcPath = " + compressInfo.D);
        RichmediaService richmediaService = f281316i;
        boolean z16 = true;
        if (richmediaService != null) {
            b bVar = richmediaService.f281321h;
            if (bVar != null) {
                try {
                    d.a("RichmediaService", "startCompress cb.compress start . compressInfo.localUUID = " + compressInfo.f258514d + ",compressInfo.srcPath = " + compressInfo.D);
                    bVar.A4(compressInfo);
                    d.a("RichmediaService", "startCompress cb.compress finish. compressInfo.localUUID = " + compressInfo.f258514d + ",compressInfo.dstPath = " + compressInfo.H);
                    z16 = false;
                } catch (Exception e16) {
                    d.a("RichmediaService", "startCompress cb.compress ipc fail,compressInfo.localUUID = " + compressInfo.f258514d + ",compress in main process, RemoteException : " + e16.getMessage());
                }
            } else {
                d.a("RichmediaService", "startCompress service.mClientCallBack is null,compressInfo.localUUID = " + compressInfo.f258514d + ",compress in main process");
            }
        } else {
            d.a("RichmediaService", "startCompress Richmedia Service is null,compressInfo.localUUID = " + compressInfo.f258514d + ",compress in main process");
        }
        if (z16) {
            d.a("RichmediaService", "startCompress compressInMainProcess start . compressInfo.localUUID = " + compressInfo.f258514d + ",compressInfo.srcPath = " + compressInfo.D);
            ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
            d.a("RichmediaService", "startCompress compressInMainProcess finish. compressInfo.localUUID = " + compressInfo.f258514d + ",compressInfo.dstPath = " + compressInfo.H);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean s(Intent intent) {
        Bundle bundle;
        boolean z16;
        d.a("RichmediaService", "addPresendMgrHandlerToIntent start .");
        RichmediaService richmediaService = f281316i;
        if (richmediaService != null) {
            b bVar = richmediaService.f281321h;
            if (bVar != null) {
                try {
                    d.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData start . ");
                    bundle = bVar.C1(16, null);
                } catch (RemoteException e16) {
                    e = e16;
                    bundle = null;
                }
                try {
                    d.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData finish. ");
                } catch (RemoteException e17) {
                    e = e17;
                    d.a("RichmediaService", "addPresendMgrHandlerToIntent cb.getData ipc fail, RemoteException : " + e.getMessage());
                    if (bundle != null) {
                    }
                    z16 = false;
                    d.a("RichmediaService", "addPresendMgrHandlerToIntent.result = " + z16);
                    return z16;
                }
                if (bundle != null) {
                    bundle.setClassLoader(RichmediaService.class.getClassLoader());
                    BinderWarpper binderWarpper = (BinderWarpper) bundle.getParcelable(PeakConstants.KEY_PRESEND_MGR_HANDLER);
                    if (binderWarpper != null) {
                        int i3 = bundle.getInt(PeakConstants.PHOTO_COUNT);
                        int intExtra = intent.getIntExtra(PeakConstants.PHOTO_COUNT, -1);
                        d.a("RichmediaService", "presend req count = " + i3 + ", send count = " + intExtra);
                        if (i3 != intExtra) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt(PeakConstants.KEY_PRESEND_CANCEL_TYPE, 1022);
                            if (f281317m != null) {
                                f281317m.removeCallbacksAndMessages(null);
                            }
                            t(bundle2);
                        } else {
                            intent.putExtra("presend_handler", binderWarpper);
                            z16 = true;
                            d.a("RichmediaService", "addPresendMgrHandlerToIntent.result = " + z16);
                            return z16;
                        }
                    }
                }
                z16 = false;
                d.a("RichmediaService", "addPresendMgrHandlerToIntent.result = " + z16);
                return z16;
            }
            d.a("RichmediaService", "addPresendMgrHandlerToIntent service.mClientCallBack is null");
        } else {
            d.a("RichmediaService", "addPresendMgrHandlerToIntent Richmedia Service is null");
        }
        bundle = null;
        if (bundle != null) {
        }
        z16 = false;
        d.a("RichmediaService", "addPresendMgrHandlerToIntent.result = " + z16);
        return z16;
    }

    public static void t(Bundle bundle) {
        d.a("RichmediaService", "cancelAllPresendPic. ");
        y(5, bundle);
    }

    public static void u(Bundle bundle) {
        d.a("RichmediaService", "cancelPresendPic. ");
        y(4, bundle);
    }

    public static RichmediaService v() {
        return f281316i;
    }

    public static void w(Bundle bundle) {
        d.a("RichmediaService", "initPresend. ");
        y(2, bundle);
    }

    public static void x(Bundle bundle) {
        d.a("RichmediaService", "presendPic. ");
        y(3, bundle);
    }

    static void y(final int i3, final Bundle bundle) {
        d.a("RichmediaService", "sendICallBackRequest start . cmd = " + i3 + ",data = " + bundle);
        WeakReferenceHandler weakReferenceHandler = f281317m;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.post(new Runnable() { // from class: com.tencent.mobileqq.richmedia.RichmediaService.1
                @Override // java.lang.Runnable
                public void run() {
                    if (RichmediaService.f281316i != null) {
                        b bVar = RichmediaService.f281316i.f281321h;
                        if (bVar != null) {
                            try {
                                d.a("RichmediaService", "sendICallBackRequest cb.sendRequest start . ");
                                bVar.M4(i3, bundle);
                                d.a("RichmediaService", "sendICallBackRequest cb.sendRequest finish. ");
                                return;
                            } catch (RemoteException e16) {
                                d.a("RichmediaService", "sendICallBackRequest cb.sendRequest ipc fail, RemoteException : " + e16.getMessage());
                                return;
                            }
                        }
                        d.a("RichmediaService", "sendICallBackRequest service.mClientCallBack is null");
                        return;
                    }
                    d.a("RichmediaService", "sendICallBackRequest Richmedia Service is null");
                }
            });
        } else {
            d.a("RichmediaService", "sendICallBackRequest subHandler is null");
        }
    }

    @Override // mqq.app.AppService
    public String getModuleId() {
        return "peak";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // mqq.app.AppService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.i("PreUploadVideo", 2, "[onBind]");
        }
        return this.f281318d.getBinder();
    }

    @Override // mqq.app.AppService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f281320f = new a(ThreadManagerV2.getSubThreadLooper(), this);
        this.f281318d = new Messenger(this.f281320f);
        f281316i = this;
        f281317m = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        if (QLog.isColorLevel()) {
            QLog.i("PreUploadVideo", 2, "[onCreate]");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f281320f = null;
        f281316i = null;
        f281317m = null;
        if (QLog.isColorLevel()) {
            QLog.i("PreUploadVideo", 2, "[onDestroy]");
        }
    }

    public boolean z(int i3, int i16, Bundle bundle) {
        d.a("RichmediaService", "sendToClient,msgCode = " + i3 + ",subCmd = " + i16 + ",data = " + bundle);
        if (this.f281319e == null) {
            d.b("RichmediaService", "sendToClient failed. mClient is null");
            return false;
        }
        Message obtain = Message.obtain((Handler) null, i3);
        if (bundle != null) {
            bundle.putInt("msg_sub_cmd", i16);
        }
        obtain.setData(bundle);
        try {
            this.f281319e.send(obtain);
            return true;
        } catch (Exception e16) {
            d.b("RichmediaService", "sendToClient failed. e = " + e16);
            return false;
        }
    }
}
