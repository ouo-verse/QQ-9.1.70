package com.qzone.feed.ui.activity;

import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;

/* loaded from: classes39.dex */
public class NoticeBannerConfProxy {

    /* loaded from: classes39.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final NoticeBannerConfProxy f47288a = new NoticeBannerConfProxy();
    }

    /* loaded from: classes39.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f47289a;

        /* renamed from: b, reason: collision with root package name */
        public final String f47290b;

        /* renamed from: c, reason: collision with root package name */
        public final String f47291c;

        b(boolean z16, String str, String str2) {
            this.f47289a = z16;
            this.f47290b = str;
            this.f47291c = str2;
        }
    }

    /* loaded from: classes39.dex */
    public interface c {
        void a(b bVar);
    }

    NoticeBannerConfProxy() {
    }

    public static NoticeBannerConfProxy a() {
        return a.f47288a;
    }

    public void b(c cVar) {
        final WeakReference weakReference = new WeakReference(cVar);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.IpcProxyThread).post(new Runnable() { // from class: com.qzone.feed.ui.activity.NoticeBannerConfProxy.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle;
                EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_SHOW_PUSH_SETTING_BANNER, new Bundle());
                c cVar2 = (c) weakReference.get();
                if (cVar2 == null) {
                    QZLog.i("NoticeBannerConfProxy", "getNoticeBannerConf: null callback");
                    return;
                }
                if (callServer == null) {
                    QZLog.w("NoticeBannerConfProxy", "getNoticeBannerConf: null result");
                    cVar2.a(null);
                    return;
                }
                if (callServer.isSuccess() && (bundle = callServer.data) != null) {
                    boolean z16 = bundle.getBoolean(NodeProps.VISIBLE, false);
                    String string = bundle.getString("msg");
                    String string2 = bundle.getString("setting");
                    QZLog.i("NoticeBannerConfProxy", "getNoticeBannerConf: success " + z16 + " " + string + " " + string2);
                    cVar2.a(new b(z16, string, string2));
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getNoticeBannerConf: ipc request failed ");
                sb5.append(callServer.code);
                sb5.append(" ");
                sb5.append(callServer.data != null);
                QZLog.w("NoticeBannerConfProxy", sb5.toString());
                cVar2.a(null);
            }
        });
    }

    public void c() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.IpcProxyThread).post(new Runnable() { // from class: com.qzone.feed.ui.activity.NoticeBannerConfProxy.2
            @Override // java.lang.Runnable
            public void run() {
                EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_CLOSE_PUSH_SETTING_BANNER, new Bundle());
                if (callServer == null) {
                    QZLog.w("NoticeBannerConfProxy", "reportNoticeBannerClose: null result");
                    return;
                }
                if (!callServer.isSuccess()) {
                    QZLog.w("NoticeBannerConfProxy", "reportNoticeBannerClose: ipc request failed " + callServer.code);
                    return;
                }
                QZLog.i("NoticeBannerConfProxy", "reportNoticeBannerClose: success");
            }
        });
    }
}
