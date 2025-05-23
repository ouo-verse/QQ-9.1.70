package com.tencent.tmdownloader;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d extends Handler {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    protected static d f380621a = null;

    /* renamed from: b, reason: collision with root package name */
    protected static HandlerThread f380622b = null;

    /* renamed from: c, reason: collision with root package name */
    protected static boolean f380623c = true;

    /* renamed from: d, reason: collision with root package name */
    private static long f380624d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11800);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    d(Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f380621a == null || !f380623c) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread(e.b.f380464b.name());
                f380622b = baseHandlerThread;
                baseHandlerThread.start();
                f380623c = true;
                d dVar2 = new d(f380622b.getLooper());
                f380621a = dVar2;
                dVar2.sendEmptyMessageDelayed(5, 30000L);
            }
            f380624d = System.currentTimeMillis();
            dVar = f380621a;
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) message);
            return;
        }
        super.handleMessage(message);
        if (message.what != 5) {
            removeMessages(5);
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            long currentTimeMillis = System.currentTimeMillis();
                            synchronized (d.class) {
                                if (currentTimeMillis - f380624d < 15000.0d) {
                                    sendEmptyMessageDelayed(5, 15000L);
                                } else {
                                    f380623c = false;
                                    f380622b.quit();
                                }
                            }
                            return;
                        }
                    } else {
                        k kVar = (k) message.obj;
                        byte[] bArr = (byte[]) kVar.f380477a;
                        ArrayList arrayList = (ArrayList) kVar.f380478b;
                        if (arrayList != null) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                com.tencent.tmassistantsdk.a.b.a aVar = (com.tencent.tmassistantsdk.a.b.a) it.next();
                                if (aVar != null) {
                                    aVar.onActionResult(bArr);
                                }
                            }
                        }
                    }
                } else {
                    k kVar2 = (k) message.obj;
                    TMAssistantDownloadClient tMAssistantDownloadClient = (TMAssistantDownloadClient) kVar2.f380477a;
                    ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener) kVar2.f380478b;
                    if (iTMAssistantDownloadClientListener != null) {
                        iTMAssistantDownloadClientListener.onDwonloadSDKServiceInvalid(tMAssistantDownloadClient);
                    }
                }
            } else {
                k kVar3 = (k) message.obj;
                TMAssistantDownloadClient tMAssistantDownloadClient2 = (TMAssistantDownloadClient) kVar3.f380477a;
                ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener2 = (ITMAssistantDownloadClientListener) kVar3.f380478b;
                Bundle data = message.getData();
                String string = data.getString("url");
                long j3 = data.getLong("receiveDataLen");
                long j16 = data.getLong("totalDataLen");
                if (iTMAssistantDownloadClientListener2 != null) {
                    iTMAssistantDownloadClientListener2.onDownloadSDKTaskProgressChanged(tMAssistantDownloadClient2, string, j3, j16);
                }
            }
        } else {
            k kVar4 = (k) message.obj;
            TMAssistantDownloadClient tMAssistantDownloadClient3 = (TMAssistantDownloadClient) kVar4.f380477a;
            ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener3 = (ITMAssistantDownloadClientListener) kVar4.f380478b;
            Bundle data2 = message.getData();
            String string2 = data2.getString("url");
            int i16 = data2.getInt("state");
            int i17 = data2.getInt("errorCode");
            String string3 = data2.getString("errorMsg");
            if (iTMAssistantDownloadClientListener3 != null) {
                iTMAssistantDownloadClientListener3.onDownloadSDKTaskStateChanged(tMAssistantDownloadClient3, string2, i16, i17, string3);
            }
        }
        sendEmptyMessageDelayed(5, 30000L);
    }

    public void a(TMAssistantDownloadClient tMAssistantDownloadClient, ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener, String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tMAssistantDownloadClient, iTMAssistantDownloadClientListener, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            return;
        }
        if (iTMAssistantDownloadClientListener == null || tMAssistantDownloadClient == null) {
            return;
        }
        Message obtainMessage = a().obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.obj = new k(tMAssistantDownloadClient, iTMAssistantDownloadClientListener);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("state", i3);
        bundle.putInt("errorCode", i16);
        bundle.putString("errorMsg", str2);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public void a(TMAssistantDownloadClient tMAssistantDownloadClient, ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener, String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, tMAssistantDownloadClient, iTMAssistantDownloadClientListener, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (iTMAssistantDownloadClientListener != null && tMAssistantDownloadClient != null) {
            Message obtainMessage = a().obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.obj = new k(tMAssistantDownloadClient, iTMAssistantDownloadClientListener);
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putLong("receiveDataLen", j3);
            bundle.putLong("totalDataLen", j16);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
            return;
        }
        r.b("TMAssistantDownloadSDKMessageThread", "listenr:" + iTMAssistantDownloadClientListener + " === sdkClient" + tMAssistantDownloadClient);
    }

    public void a(TMAssistantDownloadClient tMAssistantDownloadClient, ITMAssistantDownloadClientListener iTMAssistantDownloadClientListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) tMAssistantDownloadClient, (Object) iTMAssistantDownloadClientListener);
            return;
        }
        if (iTMAssistantDownloadClientListener == null || tMAssistantDownloadClient == null) {
            return;
        }
        Message obtainMessage = a().obtainMessage();
        obtainMessage.what = 3;
        obtainMessage.obj = new k(tMAssistantDownloadClient, iTMAssistantDownloadClientListener);
        obtainMessage.sendToTarget();
    }

    public void a(byte[] bArr, ArrayList<com.tencent.tmassistantsdk.a.b.a> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bArr, (Object) arrayList);
            return;
        }
        if (bArr == null || arrayList == null) {
            return;
        }
        Message obtainMessage = a().obtainMessage();
        obtainMessage.what = 4;
        obtainMessage.obj = new k(bArr, arrayList);
        obtainMessage.sendToTarget();
    }
}
