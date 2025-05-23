package com.tencent.mobileqq.qqlive.record;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqlive.api.ipc.IQQLiveSdkIPCServerApi;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static Object f271430a;

    /* renamed from: b, reason: collision with root package name */
    private static QQLiveCurRoomInfo f271431b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56790);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f271430a = new Object();
            f271431b = null;
        }
    }

    private static void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putInt("key_process_id", MobileQQ.sProcessId);
        bundle.putInt("key_process_context_hash", MobileQQ.sMobileQQ.hashCode());
    }

    private static Bundle b(@NonNull String str, @Nullable Bundle bundle) {
        try {
            EIPCResult callServer = QIPCClientHelper.getInstance().callServer(IQQLiveSdkIPCServerApi.MODULE_NAME, str, bundle);
            if (callServer == null) {
                QLog.e("QQLive_IPC_RRM", 1, str + ", ipc result is null");
                return null;
            }
            if (!callServer.isSuccess()) {
                QLog.e("QQLive_IPC_RRM", 1, str + ", result is failed: " + callServer.code, callServer.f396321e);
                return null;
            }
            Bundle bundle2 = callServer.data;
            if (bundle2 == null) {
                QLog.e("QQLive_IPC_RRM", 1, str + ", result's data is null");
                return null;
            }
            return bundle2;
        } catch (Throwable th5) {
            QLog.e("QQLive_IPC_RRM", 1, th5, new Object[0]);
            return null;
        }
    }

    public static QQLiveCurRoomInfo c(@Nullable String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQLive_IPC_RRM", 1, "getCurRoomInfo, appId=" + str);
        }
        if (f()) {
            return e(str);
        }
        return d(str);
    }

    private static QQLiveCurRoomInfo d(@Nullable String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQLive_IPC_RRM", 1, "getCurRoomInfoIPC, appId=" + str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_app_id", str);
        a(bundle);
        Bundle b16 = b("action_room_record_get", bundle);
        if (b16 == null) {
            return null;
        }
        return (QQLiveCurRoomInfo) b16.getParcelable("key_room_record_info");
    }

    private static QQLiveCurRoomInfo e(@Nullable String str) {
        if (QLog.isColorLevel()) {
            QLog.d("QQLive_IPC_RRM", 1, "getCurRoomInfoInMainProcess, appId=" + str);
        }
        return f271431b;
    }

    public static boolean f() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLive_IPC_RRM", 1, "processId: " + MobileQQ.sProcessId);
        }
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    public static void g(@Nullable String str, QQLiveCurRoomInfo qQLiveCurRoomInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("QQLive_IPC_RRM", 1, "recordCurRoomInfo, appId=" + str);
        }
        if (f()) {
            l(str, qQLiveCurRoomInfo);
        } else {
            k(str, qQLiveCurRoomInfo);
        }
    }

    public static void h(@Nullable String str, long j3) {
        QLog.i("QQLive_IPC_RRM", 1, "removeCurRoomInfo, appId=" + str + ", roomId:" + j3);
        if (f()) {
            j(str, j3);
        } else {
            i(str, j3);
        }
    }

    private static void i(@Nullable String str, long j3) {
        QLog.d("QQLive_IPC_RRM", 1, "removeCurRoomInfoIPC, appId=" + str + ", roomId:" + j3);
        Bundle bundle = new Bundle();
        bundle.putString("key_app_id", str);
        bundle.putLong("key_room_id", j3);
        a(bundle);
        b("action_room_record_remove", bundle);
    }

    private static void j(@Nullable String str, long j3) {
        QLog.i("QQLive_IPC_RRM", 1, "removeCurRoomInfoInMainProcess, appId=" + str + ", roomId:" + j3);
        synchronized (f271430a) {
            QQLiveCurRoomInfo qQLiveCurRoomInfo = f271431b;
            if (qQLiveCurRoomInfo == null) {
                QLog.w("QQLive_IPC_RRM", 1, "removeCurRoomRecord, curRoomInfo is null, appId:" + str);
                return;
            }
            if (j3 == -1) {
                f271431b = null;
                QLog.w("QQLive_IPC_RRM", 1, "roomId is -1, clear");
            } else {
                if (qQLiveCurRoomInfo.roomId != j3) {
                    QLog.w("QQLive_IPC_RRM", 1, "removeCurRoomRecord, roomId diff, cur=" + f271431b.roomId + ", target=" + j3);
                    return;
                }
                f271431b = null;
            }
        }
    }

    private static void k(@Nullable String str, QQLiveCurRoomInfo qQLiveCurRoomInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("QQLive_IPC_RRM", 1, "setCurRoomInfoIPC, appId=" + str);
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_app_id", str);
        bundle.putParcelable("key_room_record_info", qQLiveCurRoomInfo);
        a(bundle);
        b("action_room_record_set", bundle);
    }

    private static void l(@Nullable String str, QQLiveCurRoomInfo qQLiveCurRoomInfo) {
        String qQLiveCurRoomInfo2;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setCurRoomInfoInMainProcess, appId=");
            sb5.append(str);
            sb5.append(", info:");
            if (qQLiveCurRoomInfo == null) {
                qQLiveCurRoomInfo2 = "null";
            } else {
                qQLiveCurRoomInfo2 = qQLiveCurRoomInfo.toString();
            }
            sb5.append(qQLiveCurRoomInfo2);
            QLog.d("QQLive_IPC_RRM", 1, sb5.toString());
        }
        synchronized (f271430a) {
            QQLiveCurRoomInfo qQLiveCurRoomInfo3 = f271431b;
            if (qQLiveCurRoomInfo3 != null && !qQLiveCurRoomInfo3.isConditionEquals(qQLiveCurRoomInfo)) {
                QLog.e("QQLive_IPC_RRM", 1, "recordCurRoomInfo, curRoomInfo not null");
            }
            f271431b = qQLiveCurRoomInfo;
        }
    }
}
