package com.tencent.mobileqq.richmedia;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.util.BinderWarpper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {

    /* renamed from: i, reason: collision with root package name */
    static volatile g f281578i;

    /* renamed from: a, reason: collision with root package name */
    Messenger f281579a;

    /* renamed from: b, reason: collision with root package name */
    Messenger f281580b;

    /* renamed from: c, reason: collision with root package name */
    HandlerThread f281581c;

    /* renamed from: d, reason: collision with root package name */
    c f281582d;

    /* renamed from: e, reason: collision with root package name */
    h f281583e;

    /* renamed from: f, reason: collision with root package name */
    ServiceConnection f281584f;

    /* renamed from: g, reason: collision with root package name */
    com.tencent.mobileqq.richmedia.b f281585g;

    /* renamed from: h, reason: collision with root package name */
    AtomicBoolean f281586h = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.a("PTV.RichmediaClient", "onServiceConnected");
            g.this.f281580b = new Messenger(iBinder);
            Message obtain = Message.obtain((Handler) null, 1);
            obtain.replyTo = g.this.f281579a;
            BinderWarpper binderWarpper = new BinderWarpper(g.this.f281585g.asBinder());
            Bundle bundle = new Bundle();
            bundle.putParcelable("ICallBack_BinderWrapper", binderWarpper);
            obtain.setData(bundle);
            try {
                g.this.f281580b.send(obtain);
            } catch (RemoteException e16) {
                d.b("PTV.RichmediaClient", "MSG_C2S_REGISTER_CLIENT send failed. e = " + e16);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            g.this.f281580b = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends b.a {
        b() {
        }

        @Override // com.tencent.mobileqq.richmedia.b
        public void A4(CompressInfo compressInfo) throws RemoteException {
            d.a("PTV.RichmediaClient", "ICallBack.Stub() compress start. info.src = " + compressInfo.D + ",uuid = " + compressInfo.f258514d);
            ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ICallBack.Stub() compress finish. info = ");
            sb5.append(compressInfo);
            d.a("PTV.RichmediaClient", sb5.toString());
        }

        @Override // com.tencent.mobileqq.richmedia.b
        public Bundle C1(int i3, Bundle bundle) throws RemoteException {
            IBinder iBinder;
            Bundle bundle2 = new Bundle();
            if (i3 == 16) {
                d.a("PTV.RichmediaClient", "ICallBack.Stub() getData start. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER");
                PresendPicMgr f16 = PresendPicMgr.f();
                if (f16 != null && f16.f258576g) {
                    iBinder = new Messenger(f16.f258573d).getBinder();
                    d.a("PTV.RichmediaClient", "ICallBack.Stub() getData. ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER , b = " + iBinder);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("PTV.RichmediaClient", 2, "ICALLBACK_CMD_GET_PRESEND_MGR_HANDLER failed, presendMgr is null or disable preCompress,presendMgr = " + f16);
                    }
                    iBinder = null;
                }
                if (iBinder != null) {
                    bundle2.putParcelable(PeakConstants.KEY_PRESEND_MGR_HANDLER, new BinderWarpper(iBinder));
                    bundle2.putInt(PeakConstants.PHOTO_COUNT, f16.h());
                }
            }
            return bundle2;
        }

        @Override // com.tencent.mobileqq.richmedia.b
        public void M4(int i3, Bundle bundle) throws RemoteException {
            int[] intArray;
            d.a("PTV.RichmediaClient", "sendRequest. cmd = " + i3 + ",data = " + bundle);
            if (bundle != null) {
                bundle.setClassLoader(getClass().getClassLoader());
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 == 6 && (intArray = bundle.getIntArray(PeakConstants.KEY_COMPRESS_CONFIG)) != null && intArray.length >= 9) {
                                    com.tencent.mobileqq.pic.compress.a.f258671d = intArray[0];
                                    com.tencent.mobileqq.pic.compress.a.f258672e = intArray[1];
                                    com.tencent.mobileqq.pic.compress.a.f258673f = intArray[2];
                                    com.tencent.mobileqq.pic.compress.a.f258674g = intArray[3];
                                    com.tencent.mobileqq.pic.compress.a.f258675h = intArray[4];
                                    com.tencent.mobileqq.pic.compress.a.f258676i = intArray[5];
                                    com.tencent.mobileqq.pic.compress.a.f258668a = intArray[6];
                                    com.tencent.mobileqq.pic.compress.a.f258669b = intArray[7];
                                    com.tencent.mobileqq.pic.compress.a.f258670c = intArray[8];
                                    if (QLog.isColorLevel()) {
                                        QLog.d("PTV.RichmediaClient", 2, "ICALLBACK_CMD_INIT_COMPRESS_CONFIG, compressConfig = " + Arrays.toString(intArray));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            int i16 = bundle.getInt(PeakConstants.KEY_PRESEND_CANCEL_TYPE);
                            PresendPicMgr f16 = PresendPicMgr.f();
                            if (f16 != null) {
                                f16.a(i16);
                                f16.l();
                                return;
                            }
                            return;
                        }
                        String string = bundle.getString(PeakConstants.KEY_PRESEND_PATH);
                        int i17 = bundle.getInt(PeakConstants.KEY_PRESEND_CANCEL_TYPE);
                        PresendPicMgr f17 = PresendPicMgr.f();
                        if (string != null && f17 != null) {
                            f17.b(string, i17);
                            return;
                        }
                        return;
                    }
                    String string2 = bundle.getString(PeakConstants.KEY_PRESEND_PATH);
                    int i18 = bundle.getInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0);
                    PresendPicMgr f18 = PresendPicMgr.f();
                    if (string2 != null && f18 != null) {
                        f18.k(string2, 1052, i18);
                        return;
                    }
                    return;
                }
                BinderWarpper binderWarpper = (BinderWarpper) bundle.getParcelable(PeakConstants.BINDER_PRESENDSERVICE);
                if (binderWarpper != null) {
                    PresendPicMgr f19 = PresendPicMgr.f();
                    if (f19 != null) {
                        f19.l();
                    }
                    d.a("PTV.RichmediaClient", "ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  presendMgr = " + PresendPicMgr.i(e.a.j(binderWarpper.binder)));
                    return;
                }
                d.a("PTV.RichmediaClient", "ICALLBACK_CMD_INIT_PRESEND_PIC_MGR  failed, bw is null ! ");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference<g> f281589a;

        public c(Looper looper, g gVar) {
            super(looper);
            this.f281589a = new WeakReference<>(gVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            d.a("PTV.RichmediaClient", "handleMessage, msg.what = " + message.what);
            g gVar = this.f281589a.get();
            if (gVar == null) {
                return;
            }
            if (message.getData() != null) {
                message.getData().getInt("msg_sub_cmd");
            }
            int i3 = message.what;
            if (i3 != 300) {
                switch (i3) {
                    case 1000:
                        d.a("PTV.RichmediaClient", "handleMessage MSG_S2C_TEST");
                        return;
                    case 1001:
                        return;
                    case 1002:
                        d.a("PTV.RichmediaClient", "handleMessage MSG_S2C_VIDEO_SLICE_UPLOAD_FINISH");
                        Bundle data = message.getData();
                        if (data != null) {
                            gVar.c().a(data.getString("vidoe_record_uniseq"));
                            return;
                        }
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
            com.tencent.mobileqq.activity.aio.photo.b.d().e(message.getData());
        }
    }

    g() {
        d.a("PTV.RichmediaClient", "RichmediaClient");
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RichmediaClientWorkerThread");
        this.f281581c = baseHandlerThread;
        baseHandlerThread.start();
        this.f281582d = new c(this.f281581c.getLooper(), this);
        this.f281579a = new Messenger(this.f281582d);
        this.f281584f = new a();
        this.f281585g = new b();
    }

    public static g b() {
        d.a("PTV.RichmediaClient", "getInstance");
        if (f281578i == null) {
            synchronized (g.class) {
                if (f281578i == null) {
                    f281578i = new g();
                }
            }
        }
        return f281578i;
    }

    public void a(Context context) {
        d.a("PTV.RichmediaClient", "bindService");
        if (this.f281586h.compareAndSet(false, true)) {
            try {
                context.bindService(new Intent(context, (Class<?>) RichmediaService.class), this.f281584f, 1);
            } catch (SecurityException e16) {
                d.b("PTV.RichmediaClient", "bindService failed. e = " + e16);
            }
            d.a("PTV.RichmediaClient", "bindService,bingding");
        }
    }

    public h c() {
        if (this.f281583e == null) {
            this.f281583e = new h();
        }
        return this.f281583e;
    }

    public boolean d(int i3, int i16, Bundle bundle) {
        d.a("PTV.RichmediaClient", "sendToService,msgCode = " + i3 + ",subCmd = " + i16 + ",data = " + bundle);
        if (this.f281580b == null) {
            d.b("PTV.RichmediaClient", "sendToService failed. mService is null ");
            return false;
        }
        Message obtain = Message.obtain((Handler) null, i3);
        if (bundle != null) {
            bundle.putInt("msg_sub_cmd", i16);
        }
        obtain.setData(bundle);
        try {
            this.f281580b.send(obtain);
            return true;
        } catch (RemoteException e16) {
            d.b("PTV.RichmediaClient", "sendToService failed. e = " + e16);
            return false;
        }
    }

    public void e(Context context) {
        d.a("PTV.RichmediaClient", "unbindService");
        if (this.f281586h.compareAndSet(true, false)) {
            try {
                try {
                    d(2, -1, null);
                    context.unbindService(this.f281584f);
                } catch (Exception e16) {
                    QLog.e("PTV.RichmediaClient", 1, "unbindService error.", e16);
                }
            } finally {
                this.f281580b = null;
            }
        }
    }
}
