package com.tencent.av.zplan;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import com.tencent.av.service.i;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final RemoteCallbackList<i> f77357a = new RemoteCallbackList<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f77358a = new d();
    }

    d() {
    }

    public static d a() {
        return a.f77358a;
    }

    private void b(boolean z16, String str) {
        synchronized (this.f77357a) {
            int beginBroadcast = this.f77357a.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                try {
                    i broadcastItem = this.f77357a.getBroadcastItem(i3);
                    if (broadcastItem != null) {
                        broadcastItem.a5(z16, str);
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
        this.f77357a.finishBroadcast();
    }

    private void d(i iVar) {
        synchronized (this.f77357a) {
            this.f77357a.register(iVar);
        }
    }

    private void e(i iVar) {
        synchronized (this.f77357a) {
            this.f77357a.unregister(iVar);
        }
    }

    public void c(String str, Bundle bundle, i iVar) {
        QLog.d("VideoActionIPCHelper", 1, "onCallVideoAction " + str);
        if ("tencent.video.z2v.enter_zplan_home".equals(str)) {
            QAVControllerForZplan.p().r();
            return;
        }
        if ("tencent.video.z2v.exit_zplan_home".equals(str)) {
            boolean z16 = false;
            if (bundle != null) {
                z16 = bundle.getBoolean("isFromZPlanSmallHomeMod", false);
            }
            QAVControllerForZplan.p().s(z16);
            return;
        }
        String str2 = "";
        if ("tencent.video.z2v.start_qq_audio_call".equals(str)) {
            if (bundle != null) {
                str2 = bundle.getString("target_uin", "");
            }
            QAVControllerForZplan.p().S(BaseApplication.getContext(), str2);
            return;
        }
        if ("tencent.video.z2v.accept_audio_call".equals(str)) {
            QAVControllerForZplan.p().h(BaseApplication.getContext());
            return;
        }
        if ("tencent.video.z2v.accept_gaudio_call".equals(str)) {
            QAVControllerForZplan.p().g(BaseApplication.getContext());
            return;
        }
        if ("tencent.video.z2v.refuse_gaudio_call".equals(str)) {
            QAVControllerForZplan.p().K();
            return;
        }
        if ("tencent.video.z2v.refuse_audio_call".equals(str)) {
            QAVControllerForZplan.p().L();
            return;
        }
        if ("tencent.video.z2v.back_to_audio".equals(str)) {
            if (bundle != null) {
                str2 = bundle.getString("visitUin");
            }
            QAVControllerForZplan.p().i(BaseApplication.getContext(), true, str2);
        } else {
            if ("tencent.video.v2z.is_c2c".equals(str)) {
                boolean v3 = QAVControllerForZplan.p().v();
                d(iVar);
                b(v3, null);
                e(iVar);
                return;
            }
            if ("tencent.video.v2z.get_call_list".equals(str)) {
                QAVControllerForZplan.p().m();
                return;
            }
            QLog.w("VideoActionIPCHelper", 4, "Action not equals :" + str);
        }
    }
}
