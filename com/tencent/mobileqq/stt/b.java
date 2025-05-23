package com.tencent.mobileqq.stt;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.PttSliceUploadProcessor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.im.cs.cmd0x355.Stt$ReqBody;
import tencent.im.cs.cmd0x355.Stt$RspBody;
import tencent.im.cs.cmd0x355.Stt$TransC2CPttReq;
import tencent.im.cs.cmd0x355.Stt$TransGroupPttReq;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends MSFServlet {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String a(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String c(MessageForPtt messageForPtt) {
        if (messageForPtt.istroop == 0) {
            String str = messageForPtt.urlAtServer;
            if (str == null) {
                return "";
            }
            return str;
        }
        long j3 = messageForPtt.groupFileID;
        if (j3 == 0) {
            return "";
        }
        return String.valueOf(j3);
    }

    public static boolean d(MessageForPtt messageForPtt) {
        if ((messageForPtt.istroop == 0 && TextUtils.isEmpty(messageForPtt.urlAtServer)) || (messageForPtt.istroop != 0 && messageForPtt.groupFileID == 0 && TextUtils.isEmpty(messageForPtt.groupFileKeyStr))) {
            return true;
        }
        return false;
    }

    public static void e(AppRuntime appRuntime, MessageForPtt messageForPtt, String str, Long l3, int i3, int i16, Class<? extends BusinessObserver> cls) {
        messageForPtt.md5 = str;
        h(appRuntime, messageForPtt, l3, i3, i16, true, cls);
    }

    private static void f(MessageForPtt messageForPtt) {
        int i3;
        int i16;
        try {
            if (messageForPtt.istroop != 0) {
                i3 = 2000;
            } else {
                i3 = 1000;
            }
            if (messageForPtt.isSend()) {
                int i17 = i3 + 100;
                if (messageForPtt.fileSize > 0) {
                    i16 = i17 + 10;
                } else {
                    i16 = i17 + 20;
                }
            } else {
                i16 = i3 + 200;
            }
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            hashMap.put("param_FailCode", String.valueOf(i16));
            hashMap.put("sender", messageForPtt.senderuin);
            hashMap.put("receiver", messageForPtt.frienduin);
            hashMap.put("uinType", String.valueOf(messageForPtt.istroop));
            hashMap.put("uploadState", String.valueOf(messageForPtt.fileSize));
            hashMap.put("voiceType", String.valueOf(messageForPtt.voiceType));
            hashMap.put("url", String.valueOf(messageForPtt.url));
            statisticCollector.collectPerformance("", "PttSttErrRequest", false, 0L, 0L, hashMap, "");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void g(MessageForPtt messageForPtt) {
        String str;
        try {
            StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
            if (messageForPtt.istroop == 0) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("param_FailCode", str);
            hashMap.put("appversion", AppSetting.f99551k);
            statisticCollector.collectPerformance("", "PttSttRequestV2", false, 0L, 0L, hashMap, "");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void h(AppRuntime appRuntime, MessageForPtt messageForPtt, Long l3, int i3, int i16, boolean z16, Class<? extends BusinessObserver> cls) {
        int i17;
        NewIntent newIntent = new NewIntent(appRuntime.getApp(), b.class);
        int i18 = messageForPtt.voiceLength;
        if (i18 == 0) {
            i18 = ((IQQRecorderTempApi) QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(messageForPtt);
        }
        int i19 = messageForPtt.voiceType;
        newIntent.putExtra("k_observer_class", cls);
        newIntent.putExtra("k_stt_mode_version", i16);
        newIntent.putExtra("k_session", l3);
        newIntent.putExtra("k_sneder", Long.parseLong(messageForPtt.senderuin));
        newIntent.putExtra("k_receiver", Long.parseLong(messageForPtt.frienduin));
        newIntent.putExtra("k_size", messageForPtt.fileSize);
        newIntent.putExtra("k_ptt_time", i18);
        newIntent.putExtra("k_voice_type", i19);
        newIntent.putExtra("k_trans_type", i3);
        newIntent.putExtra("k_file_path", messageForPtt.groupFileKeyStr);
        newIntent.putExtra("k_md5", a(messageForPtt.md5));
        if (messageForPtt.autoToText >= 1) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        newIntent.putExtra("k_ptt_type", i17);
        if (z16) {
            newIntent.putExtra("k_is_caption", true);
        }
        if (messageForPtt.istroop == 0) {
            newIntent.putExtra("k_cmd", 1);
            newIntent.putExtra("k_file", a(messageForPtt.urlAtServer));
        } else {
            newIntent.putExtra("k_cmd", 2);
            newIntent.putExtra("k_file", messageForPtt.groupFileID);
        }
        QLog.d("SttServlet", 1, "translate length:" + messageForPtt.voiceLength + " from:" + messageForPtt.istroop + " issend:" + messageForPtt.isSend() + " format:" + messageForPtt.voiceType + " size:" + messageForPtt.fileSize + " friend uin:" + messageForPtt.frienduin + " url at server:" + messageForPtt.urlAtServer + " group file id:" + messageForPtt.groupFileID + " group file key:" + messageForPtt.groupFileKeyStr + " uuid:" + c(messageForPtt));
        newIntent.putExtra("k_retry", 0);
        boolean d16 = d(messageForPtt);
        newIntent.putExtra("k_n_uuid", d16);
        appRuntime.startServlet(newIntent);
        g(messageForPtt);
        if (!z16 && d16) {
            f(messageForPtt);
        }
    }

    Class<? extends BusinessObserver> b(@NonNull Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("k_observer_class");
        if (serializableExtra != null) {
            Class<? extends BusinessObserver> cls = (Class) serializableExtra;
            if (BusinessObserver.class.isAssignableFrom(cls)) {
                return cls;
            }
            return null;
        }
        return null;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        long j3;
        boolean z16;
        int i16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        int intExtra = intent.getIntExtra("k_cmd", 0);
        long j16 = 30000;
        String str2 = null;
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r15.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                Stt$RspBody stt$RspBody = new Stt$RspBody();
                stt$RspBody.mergeFrom(bArr);
                if (intExtra != 1) {
                    if (intExtra == 2) {
                        if (stt$RspBody.msg_group_ptt_resp.uint32_error_code.get() == 0) {
                            isSuccess = true;
                        } else {
                            isSuccess = false;
                        }
                        i16 = stt$RspBody.msg_group_ptt_resp.uint32_error_code.get();
                        j16 = stt$RspBody.msg_group_ptt_resp.uint32_waittime.get();
                        if (stt$RspBody.msg_group_ptt_resp.str_text.has()) {
                            str = stt$RspBody.msg_group_ptt_resp.str_text.get();
                            str2 = str;
                        }
                        if (QLog.isColorLevel() && str2 != null) {
                            QLog.d("SttServlet", 1, "onReceive  text =" + str2.length());
                        }
                        i3 = i16;
                    } else {
                        throw new RuntimeException("unknow cmd: " + intExtra);
                    }
                } else {
                    if (stt$RspBody.msg_c2c_ptt_resp.uint32_error_code.get() == 0) {
                        isSuccess = true;
                    } else {
                        isSuccess = false;
                    }
                    i16 = stt$RspBody.msg_c2c_ptt_resp.uint32_error_code.get();
                    j16 = stt$RspBody.msg_c2c_ptt_resp.uint32_waittime.get();
                    if (stt$RspBody.msg_c2c_ptt_resp.str_text.has()) {
                        str = stt$RspBody.msg_c2c_ptt_resp.str_text.get();
                        str2 = str;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("SttServlet", 1, "onReceive  text =" + str2.length());
                    }
                    i3 = i16;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                i3 = 2001;
                j3 = 30000;
                z16 = false;
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("SttServlet", 1, "onReceive  errormsg =" + fromServiceMsg.toString());
            }
            i3 = 0;
        }
        j3 = j16;
        z16 = isSuccess;
        int intExtra2 = intent.getIntExtra("k_retry", 0);
        boolean booleanExtra = intent.getBooleanExtra("k_n_uuid", false);
        QLog.d("SttServlet", 1, "onReceive " + z16 + " retry=" + intExtra2 + " nouuid=" + booleanExtra + " resultCode=" + i3);
        if (!z16 && !booleanExtra && i3 != 48 && (intExtra2 = intExtra2 + 1) < 3) {
            intent.putExtra("k_retry", intExtra2);
            getAppRuntime().startServlet((NewIntent) intent);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("k_session", intent.getLongExtra("k_session", 0L));
        bundle.putLong("k_time_out", j3);
        bundle.putInt("k_result_code", i3);
        bundle.putInt("k_retry", intExtra2);
        if (str2 != null) {
            bundle.putString("k_ptt_trans_txt", str2);
        }
        Class<? extends BusinessObserver> b16 = b(intent);
        if (b16 != null) {
            notifyObserver(intent, intExtra, z16, bundle, b16);
        } else {
            QLog.w("SttServlet", 1, "onReceive, observer class not found");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra;
        byte[] byteArrayExtra;
        Stt$ReqBody stt$ReqBody;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int intExtra = intent.getIntExtra("k_retry", 0);
        if (QLog.isColorLevel()) {
            QLog.d(PttSliceUploadProcessor.TAG, 2, "str_filemd5" + intent.getStringExtra("k_md5") + " uint32_msg_type=" + intent.getIntExtra("k_ptt_type", 0));
        }
        if (intExtra == 0) {
            int intExtra2 = intent.getIntExtra("k_cmd", 0);
            Stt$ReqBody stt$ReqBody2 = new Stt$ReqBody();
            if (intExtra2 != 1) {
                if (intExtra2 == 2) {
                    Stt$TransGroupPttReq stt$TransGroupPttReq = new Stt$TransGroupPttReq();
                    stt$TransGroupPttReq.uint64_sessionid.set(intent.getLongExtra("k_session", 0L));
                    stt$TransGroupPttReq.uint64_sender_uin.set(intent.getLongExtra("k_sneder", 0L));
                    stt$TransGroupPttReq.uint64_group_uin.set(intent.getLongExtra("k_receiver", 0L));
                    stt$TransGroupPttReq.uint32_fileid.set((int) intent.getLongExtra("k_file", 0L));
                    stt$TransGroupPttReq.str_filemd5.set(intent.getStringExtra("k_md5"));
                    stt$TransGroupPttReq.uint32_ptt_time.set(intent.getIntExtra("k_ptt_time", 0));
                    stt$TransGroupPttReq.uint32_filesize.set((int) intent.getLongExtra("k_size", 0L));
                    stt$TransGroupPttReq.uint32_ptt_format.set(intent.getIntExtra("k_voice_type", 0));
                    stt$TransGroupPttReq.uint32_event_type.set(intent.getIntExtra("k_trans_type", 1));
                    stt$TransGroupPttReq.uint32_msg_type.set(intent.getIntExtra("k_ptt_type", 0));
                    stt$TransGroupPttReq.is_caption.set(intent.getBooleanExtra("k_is_caption", false));
                    if (intent.getStringExtra("k_file_path") != null) {
                        stt$TransGroupPttReq.str_file_path.set(intent.getStringExtra("k_file_path"));
                    }
                    stt$ReqBody2.uint32_sub_cmd.set(1);
                    stt$ReqBody2.ptt_version.set(intent.getIntExtra("k_stt_mode_version", 1));
                    stt$ReqBody2.msg_group_ptt_req.set(stt$TransGroupPttReq);
                    stringExtra = "pttTrans.TransGroupPttReq";
                    stt$ReqBody = stt$ReqBody2;
                } else {
                    throw new RuntimeException("unknow cmd: " + intExtra2);
                }
            } else {
                Stt$TransC2CPttReq stt$TransC2CPttReq = new Stt$TransC2CPttReq();
                stt$TransC2CPttReq.uint64_sessionid.set(intent.getLongExtra("k_session", 0L));
                stt$TransC2CPttReq.uint64_sender_uin.set(intent.getLongExtra("k_sneder", 0L));
                stt$TransC2CPttReq.uint64_receiver_uin.set(intent.getLongExtra("k_receiver", 0L));
                stt$TransC2CPttReq.str_file_path.set(intent.getStringExtra("k_file"));
                stt$TransC2CPttReq.uint32_ptt_time.set(intent.getIntExtra("k_ptt_time", 0));
                stt$TransC2CPttReq.uint32_filesize.set((int) intent.getLongExtra("k_size", 0L));
                stt$TransC2CPttReq.uint32_ptt_format.set(intent.getIntExtra("k_voice_type", 0));
                stt$TransC2CPttReq.uint32_event_type.set(intent.getIntExtra("k_trans_type", 1));
                stt$TransC2CPttReq.str_filemd5.set(intent.getStringExtra("k_md5"));
                stt$TransC2CPttReq.uint32_msg_type.set(intent.getIntExtra("k_ptt_type", 0));
                stt$TransC2CPttReq.is_caption.set(intent.getBooleanExtra("k_is_caption", false));
                stt$ReqBody = stt$ReqBody2;
                stt$ReqBody.uint32_sub_cmd.set(2);
                stt$ReqBody.ptt_version.set(intent.getIntExtra("k_stt_mode_version", 1));
                stt$ReqBody.msg_c2c_ptt_req.set(stt$TransC2CPttReq);
                stt$TransC2CPttReq.str_file_path.get();
                stringExtra = "pttTrans.TransC2CPttReq";
            }
            intent.putExtra("k_sso_id", stringExtra);
            byte[] byteArray = stt$ReqBody.toByteArray();
            ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
            allocate.putInt(byteArray.length + 4).put(byteArray);
            byteArrayExtra = allocate.array();
            intent.putExtra("k_sso_data", byteArrayExtra);
            intent.putExtra("k_request_hash", byteArrayExtra.hashCode());
        } else {
            stringExtra = intent.getStringExtra("k_sso_id");
            byteArrayExtra = intent.getByteArrayExtra("k_sso_data");
        }
        packet.setSSOCommand(stringExtra);
        packet.putSendData(byteArrayExtra);
    }
}
