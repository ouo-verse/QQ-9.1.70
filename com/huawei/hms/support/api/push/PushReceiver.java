package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.h;
import com.huawei.hms.push.s;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.push.v;
import com.huawei.hms.push.w;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class PushReceiver extends BroadcastReceiver {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Context f37558a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f37559b;

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.f37559b.getPackage());
            try {
                JSONObject b16 = PushReceiver.b(this.f37559b);
                String string = JsonUtil.getString(b16, "moduleName", "");
                int i3 = JsonUtil.getInt(b16, QQBrowserActivity.KEY_MSG_TYPE, 0);
                int i16 = JsonUtil.getInt(b16, "status", 0);
                if (ErrorEnum.SUCCESS.getInternalCode() != i16) {
                    i16 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                }
                Bundle bundle = new Bundle();
                if (AegisLogger.PUSH.equals(string) && i3 == 1) {
                    bundle.putString(RemoteMessageConst.MSGTYPE, "delivery");
                    bundle.putString("message_id", JsonUtil.getString(b16, "msgId", ""));
                    bundle.putInt("error", i16);
                    bundle.putString(CommonCode.MapKey.TRANSACTION_ID, JsonUtil.getString(b16, "transactionId", ""));
                } else {
                    if (this.f37559b.getExtras() != null) {
                        bundle.putAll(this.f37559b.getExtras());
                    }
                    bundle.putString(RemoteMessageConst.MSGTYPE, "received_message");
                    bundle.putString("message_id", this.f37559b.getStringExtra("msgIdStr"));
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, this.f37559b.getByteArrayExtra("msg_data"));
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, w.a(this.f37559b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));
                    bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
                    bundle.putString("message_proxy_type", this.f37559b.getStringExtra("message_proxy_type"));
                }
                if (new h().a(this.f37558a, bundle, intent)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("receive ");
                    sb5.append(this.f37559b.getAction());
                    sb5.append(" and start service success");
                    HMSLog.i("PushReceiver", sb5.toString());
                    return;
                }
                StringBuilder sb6 = new StringBuilder();
                sb6.append("receive ");
                sb6.append(this.f37559b.getAction());
                sb6.append(" and start service failed");
                HMSLog.e("PushReceiver", sb6.toString());
            } catch (RuntimeException unused) {
                HMSLog.e("PushReceiver", "handle push message occur exception.");
            }
        }

        public a(Context context, Intent intent) {
            this.f37558a = context;
            this.f37559b = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Context f37560a;

        /* renamed from: b, reason: collision with root package name */
        public Intent f37561b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.f37561b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("receive a push token: ");
                    sb5.append(this.f37560a.getPackageName());
                    HMSLog.i("PushReceiver", sb5.toString());
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.f37561b.getPackage());
                    Bundle bundle = new Bundle();
                    bundle.putString(RemoteMessageConst.MSGTYPE, "new_token");
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, w.a(byteArrayExtra));
                    bundle.putString(CommonCode.MapKey.TRANSACTION_ID, this.f37561b.getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
                    bundle.putString("subjectId", this.f37561b.getStringExtra("subjectId"));
                    bundle.putInt("error", this.f37561b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
                    bundle.putString("belongId", this.f37561b.getStringExtra("belongId"));
                    if (!new h().a(this.f37560a, bundle, intent)) {
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("receive ");
                        sb6.append(this.f37561b.getAction());
                        sb6.append(" and start service failed");
                        HMSLog.e("PushReceiver", sb6.toString());
                        return;
                    }
                    return;
                }
                HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.e("PushReceiver", "handle push token error");
            }
        }

        public b(Context context, Intent intent) {
            this.f37560a = context;
            this.f37561b = intent;
        }
    }

    public final void b(Context context, Intent intent) {
        try {
            if (intent.hasExtra(RemoteMessageConst.DEVICE_TOKEN)) {
                v.a().execute(new b(context, intent));
            } else {
                HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                    b(context, intent);
                } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                    a(context, intent);
                } else {
                    HMSLog.i("PushReceiver", "message can't be recognised.");
                }
            } catch (Exception unused) {
                HMSLog.e("PushReceiver", "intent has some error");
            }
        }
    }

    public final void a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                v.a().execute(new a(context, intent));
            } else {
                HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    public static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    public static JSONObject a(byte[] bArr) {
        try {
            return new JSONObject(w.a(bArr));
        } catch (JSONException unused) {
            HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    public static JSONObject b(Intent intent) throws RuntimeException {
        JSONObject a16 = a(intent.getByteArrayExtra("msg_data"));
        JSONObject a17 = a(a16);
        String string = JsonUtil.getString(a17, "data", null);
        if (s.a(a17, b(a17), string)) {
            return a16;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
