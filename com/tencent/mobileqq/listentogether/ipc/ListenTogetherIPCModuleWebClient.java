package com.tencent.mobileqq.listentogether.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class ListenTogetherIPCModuleWebClient extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<b> f240980d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f240981e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static ListenTogetherIPCModuleWebClient f240985a = new ListenTogetherIPCModuleWebClient();
    }

    /* loaded from: classes15.dex */
    public interface b {
        void n(JSONObject jSONObject);
    }

    ListenTogetherIPCModuleWebClient() {
        super("ListenTogetherIPCModuleWebClient");
        this.f240980d = new ArrayList<>();
        this.f240981e = false;
    }

    public static void b(final JSONObject jSONObject, final String str, final EIPCResultCallback eIPCResultCallback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.listentogether.ipc.ListenTogetherIPCModuleWebClient.1
            @Override // java.lang.Runnable
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("data", JSONObject.this.toString());
                QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", str, bundle, eIPCResultCallback);
            }
        }, 32, null, true);
    }

    public static void c(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        bundle.putString("data", jSONObject.toString());
        QIPCClientHelper.getInstance().getClient().callServer("ListenTogetherIPCModuleMainServer", "action_status_changed", bundle, null);
    }

    public static ListenTogetherIPCModuleWebClient d() {
        return a.f240985a;
    }

    private EIPCResult f(String str, Bundle bundle, int i3) {
        JSONObject jSONObject;
        if ("action_status_changed".equals(str) && bundle != null) {
            try {
                jSONObject = new JSONObject(bundle.getString("data"));
            } catch (JSONException e16) {
                QLog.i("ListenTogetherIPCModuleWebClient", 1, "statusChanged error:" + e16.getMessage());
                jSONObject = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ListenTogetherIPCModuleWebClient", 2, "statusChanged action:" + str + " data=" + jSONObject);
            }
            if (jSONObject != null) {
                synchronized (this.f240980d) {
                    Iterator<b> it = this.f240980d.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        if (next != null) {
                            next.n(jSONObject);
                        }
                    }
                }
                EIPCResult eIPCResult = new EIPCResult();
                eIPCResult.code = 0;
                return eIPCResult;
            }
        }
        return null;
    }

    public void e(b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleWebClient", 2, "register callback:" + bVar);
        }
        if (this.f240980d.contains(bVar)) {
            return;
        }
        if (this.f240980d.isEmpty()) {
            try {
                QIPCClientHelper.getInstance().register(d());
                this.f240981e = true;
                if (QLog.isColorLevel()) {
                    QLog.d("ListenTogetherIPCModuleWebClient", 2, "register real");
                }
            } catch (Exception e16) {
                QLog.e("ListenTogetherIPCModuleWebClient", 1, "register ipc module error.", e16);
            }
        }
        synchronized (this.f240980d) {
            this.f240980d.add(bVar);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleWebClient", 2, "register mListenTogetherClient2WebCallbacks.size:" + this.f240980d.size());
        }
    }

    public void g(b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister callback:" + bVar + " mHasRegistered:" + this.f240981e);
        }
        if (this.f240980d.contains(bVar)) {
            synchronized (this.f240980d) {
                this.f240980d.remove(bVar);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister mListenTogetherClient2WebCallbacks.size:" + this.f240980d.size());
        }
        if (this.f240980d.isEmpty() && this.f240981e) {
            try {
                if (QIPCClientHelper.getInstance().getClient() != null) {
                    QIPCClientHelper.getInstance().getClient().unRegisterModule(d());
                    this.f240981e = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("ListenTogetherIPCModuleWebClient", 2, "unregister real");
                    }
                }
            } catch (Exception e16) {
                QLog.e("ListenTogetherIPCModuleWebClient", 1, "unregister ipc module error.", e16);
            }
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherIPCModuleWebClient", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        if (bundle == null) {
            QLog.i("ListenTogetherIPCModuleWebClient", 1, "onCall, param is null, action=" + str + ", callBackId=" + i3);
            return null;
        }
        if (!"action_status_changed".equals(str)) {
            return null;
        }
        return f(str, bundle, i3);
    }
}
