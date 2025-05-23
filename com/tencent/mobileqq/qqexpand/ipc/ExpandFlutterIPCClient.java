package com.tencent.mobileqq.qqexpand.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes35.dex */
public class ExpandFlutterIPCClient extends QIPCModule implements EIPCResultCallback {

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicInteger f263809f = new AtomicInteger(0);

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f263810h = false;

    /* renamed from: i, reason: collision with root package name */
    private static volatile ExpandFlutterIPCClient f263811i;

    /* renamed from: d, reason: collision with root package name */
    private final Handler f263812d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList<a> f263813e;

    ExpandFlutterIPCClient(String str) {
        super(str);
        this.f263813e = new ArrayList<>();
        this.f263812d = new Handler(Looper.getMainLooper());
    }

    public static ExpandFlutterIPCClient g() {
        if (f263811i == null) {
            synchronized (ExpandFlutterIPCClient.class) {
                if (f263811i == null) {
                    f263811i = new ExpandFlutterIPCClient("ExpandFlutterIPCClient");
                }
            }
        }
        return f263811i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(long j3, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("expand.ExpandFlutterIPCClient", 2, "handlePushEvent pushType=" + j3);
        }
        Iterator<a> it = this.f263813e.iterator();
        while (it.hasNext()) {
            it.next().f(j3, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3) {
        QLog.d("expand.ExpandFlutterIPCClient", 4, "handleRedPointEvent redPointNumber=" + i3);
        Iterator<a> it = this.f263813e.iterator();
        while (it.hasNext()) {
            it.next().g(i3);
        }
    }

    public boolean e(String str, int i3, int i16, int i17, int i18, int i19, int i26, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putString("match_uin", str);
        bundle.putInt("from_page", i3);
        bundle.putInt("match_type", i16);
        bundle.putInt("accost_type", i17);
        bundle.putInt("is_passive", i18);
        bundle.putInt("choose_condition", i19);
        bundle.putInt("dating_purpose", i26);
        bundle.putByteArray(PreloadTRTCPlayerParams.KEY_SIG, bArr);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ExpandFlutterIPCServer", "notifyOpenAio", bundle);
        if (callServer == null) {
            QLog.e("expand.ExpandFlutterIPCClient", 1, "callFlutterOpenAio: res is null!");
            return EIPCResult.UNKNOW_RESULT.isSuccess();
        }
        return callServer.isSuccess();
    }

    public Bundle f(String str, Bundle bundle) {
        return BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ExpandFlutterIPCServer", str, bundle).data;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, final Bundle bundle, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("expand.ExpandFlutterIPCClient", 4, "onCall, action[" + str + "]");
        }
        if ("notifyPushEvent".equals(str)) {
            this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.1
                @Override // java.lang.Runnable
                public void run() {
                    ExpandFlutterIPCClient.this.h(bundle.getLong("pushType"), bundle.getByteArray("data"));
                }
            });
        }
        if ("notifyRedPointEvent".equals(str)) {
            this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.2
                @Override // java.lang.Runnable
                public void run() {
                    ExpandFlutterIPCClient.this.i(bundle.getInt("redPointNum"));
                }
            });
        }
        if ("notifyGetExtendFriendInfoResponse".equals(str)) {
            this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.3
                @Override // java.lang.Runnable
                public void run() {
                    String string = bundle.getString("data");
                    int i16 = bundle.getInt(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM);
                    QLog.d("expand.ExpandFlutterIPCClient", 4, "handleUpdateExtendFriendInfo " + string);
                    Iterator it = ExpandFlutterIPCClient.this.f263813e.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).d(string, i16);
                    }
                }
            });
            return null;
        }
        if ("notifyGetOnLineStateResponse".equals(str)) {
            this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.4
                @Override // java.lang.Runnable
                public void run() {
                    String string = bundle.getString("data");
                    int i16 = bundle.getInt(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM);
                    QLog.d("expand.ExpandFlutterIPCClient", 4, "onGetOnLineStateResponse " + string);
                    Iterator it = ExpandFlutterIPCClient.this.f263813e.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).e(string, i16);
                    }
                }
            });
            return null;
        }
        if ("notifyUpdateOnlineState".equals(str)) {
            this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.5
                @Override // java.lang.Runnable
                public void run() {
                    String string = bundle.getString("response");
                    Iterator it = ExpandFlutterIPCClient.this.f263813e.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).h(string);
                    }
                }
            });
            return null;
        }
        if ("notifyConversationUpdate".equals(str)) {
            this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.6
                @Override // java.lang.Runnable
                public void run() {
                    String string = bundle.getString("response");
                    Iterator it = ExpandFlutterIPCClient.this.f263813e.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).c(string);
                    }
                }
            });
            return null;
        }
        if ("notifyConversationDelete".equals(str)) {
            this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.7
                @Override // java.lang.Runnable
                public void run() {
                    String string = bundle.getString("response");
                    Iterator it = ExpandFlutterIPCClient.this.f263813e.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).a(string);
                    }
                }
            });
            return null;
        }
        if (!"notifyConversationRefresh".equals(str)) {
            return null;
        }
        this.f263812d.post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient.8
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ExpandFlutterIPCClient.this.f263813e.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).b();
                }
            }
        });
        return null;
    }

    @Override // eipc.EIPCResultCallback
    public void onCallback(EIPCResult eIPCResult) {
    }
}
