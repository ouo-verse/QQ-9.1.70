package com.qzone.widget.util;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qzone.module.feedcomponent.ui.PublicAccountContainerAdapter;
import com.qzone.module.feedcomponent.ui.canvasui.CanvasPublicAccountContainerView;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import eipc.EIPCResult;
import java.util.LinkedHashMap;

/* loaded from: classes37.dex */
public class QZoneQQCircleFollowProxy implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private final LinkedHashMap<String, a> f61096d = new LinkedHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private Handler f61097e = new Handler(this);

    /* renamed from: f, reason: collision with root package name */
    private boolean f61098f = false;

    /* loaded from: classes37.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f61100a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f61101b;

        a(String str, boolean z16) {
            this.f61100a = str;
            this.f61101b = z16;
        }
    }

    /* loaded from: classes37.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final QZoneQQCircleFollowProxy f61102a = new QZoneQQCircleFollowProxy();
    }

    QZoneQQCircleFollowProxy() {
    }

    public static QZoneQQCircleFollowProxy c() {
        return b.f61102a;
    }

    public boolean b(String str, boolean z16) {
        QZLog.i("QZoneQQCircleFollowProx", "doFollow: " + str + " " + z16);
        if (this.f61096d.containsKey(str)) {
            return false;
        }
        this.f61096d.put(str, new a(str, z16));
        this.f61097e.sendEmptyMessage(1001);
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        String str;
        int i3 = message.what;
        if (i3 < 1001 || i3 > 1003) {
            return false;
        }
        QZLog.i("QZoneQQCircleFollowProx", "handleMessage: " + message.what + " " + message.obj);
        int i16 = message.what;
        if (i16 == 1003) {
            a aVar = (a) message.obj;
            StringBuilder sb5 = new StringBuilder();
            if (aVar.f61101b) {
                str = "\u5173\u6ce8";
            } else {
                str = "\u53d6\u6d88\u5173\u6ce8";
            }
            sb5.append(str);
            sb5.append("\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u91cd\u8bd5");
            ToastUtil.s(sb5.toString(), 4);
            CanvasPublicAccountContainerView.addCircleCache(aVar.f61100a, !aVar.f61101b);
            PublicAccountContainerAdapter publicAccountContainerAdapter = PublicAccountContainerAdapter.CIRCLE_RECOMM_ADAPTER_REF.get();
            if (publicAccountContainerAdapter != null) {
                publicAccountContainerAdapter.notifyDataSetChanged();
            }
            this.f61098f = false;
            this.f61096d.remove(aVar.f61100a);
        } else if (i16 == 1002) {
            a aVar2 = (a) message.obj;
            this.f61098f = false;
            this.f61096d.remove(aVar2.f61100a);
        }
        if (!this.f61098f && !this.f61096d.isEmpty()) {
            this.f61098f = true;
            final a value = this.f61096d.entrySet().iterator().next().getValue();
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.IpcProxyThread).post(new Runnable() { // from class: com.qzone.widget.util.QZoneQQCircleFollowProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    Bundle bundle = new Bundle();
                    bundle.putString("circle_uin", value.f61100a);
                    bundle.putBoolean("circle_follow", value.f61101b);
                    EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QzoneIPCModule", QzoneIPCModule.ACTION_QZONE_FLOW_QQ_CIRCLE, bundle);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("run: ");
                    if (callServer == null) {
                        str2 = "null";
                    } else {
                        str2 = "" + callServer.code;
                    }
                    sb6.append(str2);
                    QZLog.i("QZoneQQCircleFollowProx", sb6.toString());
                    if (callServer == null) {
                        return;
                    }
                    if (callServer.isSuccess()) {
                        Message.obtain(QZoneQQCircleFollowProxy.this.f61097e, 1002, value).sendToTarget();
                        return;
                    }
                    Bundle bundle2 = callServer.data;
                    QZLog.i("QZoneQQCircleFollowProx", "run: request failed " + (bundle2 != null ? bundle2.getInt("code") : -100));
                    Message.obtain(QZoneQQCircleFollowProxy.this.f61097e, 1003, value).sendToTarget();
                }
            });
        }
        return true;
    }
}
