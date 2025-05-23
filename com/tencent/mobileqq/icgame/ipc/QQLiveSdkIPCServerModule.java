package com.tencent.mobileqq.icgame.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.icgame.api.ipc.IQQLiveSdkIPCServerApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import u32.a;

/* loaded from: classes15.dex */
public class QQLiveSdkIPCServerModule extends QIPCModule {
    public static final String ACTION_ROOM_RECORD_GET = "action_room_record_get";
    public static final String ACTION_ROOM_RECORD_REMOVE = "action_room_record_remove";
    public static final String ACTION_ROOM_RECORD_SET = "action_room_record_set";
    public static QQLiveSdkIPCServerModule INSTANCE = new QQLiveSdkIPCServerModule(IQQLiveSdkIPCServerApi.MODULE_NAME);
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_PROCESS_CONTEXT_HASH = "key_process_context_hash";
    public static final String KEY_PROCESS_ID = "key_process_id";
    public static final String KEY_ROOM_ID = "key_room_id";
    public static final String KEY_ROOM_RECORD_INFO = "key_room_record_info";
    private static final String TAG = "ICGame_IPC_SERVER";

    public QQLiveSdkIPCServerModule(String str) {
        super(str);
    }

    @NonNull
    private String getAccount() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return peekAppRuntime.getAccount();
        }
        return "";
    }

    private EIPCResult handleActionGetRoomRecord(int i3, int i16, String str) {
        QQLiveCurRoomInfo c16 = a.c(str);
        String account = getAccount();
        if (c16 != null && ((c16.processId == i3 && c16.processContextHashCode != i16) || (!TextUtils.isEmpty(account) && !TextUtils.equals(account, c16.account)))) {
            QLog.e(TAG, 1, "get roomInfo, process recreated!");
            a.h(str, -1L);
            c16 = null;
        }
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = 0;
        Bundle bundle = new Bundle();
        bundle.putString("key_app_id", str);
        bundle.putParcelable("key_room_record_info", c16);
        eIPCResult.data = bundle;
        return eIPCResult;
    }

    private EIPCResult handleActionRemoveRecord(Bundle bundle, String str) {
        if (bundle == null) {
            return EIPCResult.UNKNOW_RESULT;
        }
        long j3 = bundle.getLong("key_room_id");
        a.h(str, j3);
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = 0;
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_app_id", str);
        bundle2.putLong("key_room_id", j3);
        eIPCResult.data = bundle2;
        return eIPCResult;
    }

    private EIPCResult handleActionSetRoomRecord(Bundle bundle, int i3, int i16, String str) {
        if (bundle == null) {
            return EIPCResult.UNKNOW_RESULT;
        }
        QQLiveCurRoomInfo qQLiveCurRoomInfo = (QQLiveCurRoomInfo) bundle.getParcelable("key_room_record_info");
        qQLiveCurRoomInfo.account = getAccount();
        qQLiveCurRoomInfo.processId = i3;
        qQLiveCurRoomInfo.processContextHashCode = i16;
        a.g(str, qQLiveCurRoomInfo);
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = 0;
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_app_id", str);
        eIPCResult.data = bundle2;
        return eIPCResult;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        int i16;
        int i17;
        String string;
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        if (bundle != null) {
            try {
                i16 = bundle.getInt("key_process_id", 0);
                i17 = bundle.getInt("key_process_context_hash", 0);
                string = bundle.getString("key_app_id", null);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
        } else {
            i17 = 0;
            string = "";
            i16 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onCall, action:" + str + ", processId:" + i16 + ", processHash:" + i17 + ", appId:" + string);
        }
        if ("action_room_record_get".equals(str)) {
            return handleActionGetRoomRecord(i16, i17, string);
        }
        if ("action_room_record_set".equals(str)) {
            return handleActionSetRoomRecord(bundle, i16, i17, string);
        }
        if ("action_room_record_remove".equals(str)) {
            return handleActionRemoveRecord(bundle, string);
        }
        return EIPCResult.UNKNOW_RESULT;
    }
}
