package com.tencent.mobileqq.intervideo.yiqikan;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import tencent.aio.media.open.aio_media_open$ReqOpenIdentify;
import tencent.aio.media.open.aio_media_open$ReqOpenStart;
import tencent.aio.media.open.aio_media_open$ResultInfo;
import tencent.aio.media.open.aio_media_open$RspOpenIdentify;
import tencent.aio.media.open.aio_media_open$RspOpenStart;

/* compiled from: P */
/* loaded from: classes15.dex */
public class TogetherBusinessServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class ResultInfo implements Serializable {
        static IPatchRedirector $redirector_;
        public final String errorMsg;
        public final int resultCode;
        public final boolean showErrorMsg;

        public ResultInfo(int i3, String str, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
                return;
            }
            this.resultCode = i3;
            this.errorMsg = str;
            this.showErrorMsg = z16;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "ResultInfo=" + super.toString() + " resultCode=" + this.resultCode + " errorMsg=" + this.errorMsg + " showErrorMsg=" + this.showErrorMsg;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class RspOpenIdentify implements Serializable {
        static IPatchRedirector $redirector_;
        public final int businessType;
        public final String buttonText;
        public final String confirmText;
        public final ResultInfo resultInfo;

        public RspOpenIdentify(ResultInfo resultInfo, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, resultInfo, str, str2, Integer.valueOf(i3));
                return;
            }
            this.resultInfo = resultInfo;
            this.buttonText = str;
            this.confirmText = str2;
            this.businessType = i3;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "RspOpenIdentify=" + super.toString() + " buttonText=" + this.buttonText + " confirmText=" + this.confirmText + " resultInfo=" + this.resultInfo;
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class RspOpenStart implements Serializable {
        static IPatchRedirector $redirector_;
        public final int jumpType;
        public final String jumpUrl;
        public final ResultInfo resultInfo;

        public RspOpenStart(ResultInfo resultInfo, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, resultInfo, Integer.valueOf(i3), str);
                return;
            }
            this.resultInfo = resultInfo;
            this.jumpType = i3;
            this.jumpUrl = str;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "RspOpenStart=" + super.toString() + " jumpType=" + this.jumpType + " jumpUrl=" + this.jumpUrl + " resultInfo=" + this.resultInfo;
        }
    }

    public TogetherBusinessServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(Intent intent, FromServiceMsg fromServiceMsg) {
        String stringUtf8;
        ResultInfo resultInfo;
        int i3;
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                byte[] bArr = new byte[r15.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                aio_media_open$RspOpenIdentify aio_media_open_rspopenidentify = new aio_media_open$RspOpenIdentify();
                aio_media_open_rspopenidentify.mergeFrom(bArr);
                String str = "";
                if (!aio_media_open_rspopenidentify.bytes_button_text.has()) {
                    stringUtf8 = "";
                } else {
                    stringUtf8 = aio_media_open_rspopenidentify.bytes_button_text.get().toStringUtf8();
                }
                if (aio_media_open_rspopenidentify.bytes_confirm_text.has()) {
                    str = aio_media_open_rspopenidentify.bytes_confirm_text.get().toStringUtf8();
                }
                if (aio_media_open_rspopenidentify.msg_result.has()) {
                    resultInfo = c(aio_media_open_rspopenidentify.msg_result.get());
                } else {
                    resultInfo = null;
                }
                if (!aio_media_open_rspopenidentify.uint32_business_type.has()) {
                    i3 = 0;
                } else {
                    i3 = aio_media_open_rspopenidentify.uint32_business_type.get();
                }
                RspOpenIdentify rspOpenIdentify = new RspOpenIdentify(resultInfo, stringUtf8, str, i3);
                Bundle bundle = new Bundle();
                bundle.putSerializable("QQAIOMediaSvc.open_identify", rspOpenIdentify);
                if (QLog.isColorLevel() && QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessServlet", 2, "handleIdentifyPackage succsss=", rspOpenIdentify);
                }
                notifyObserver(intent, 12, true, bundle, null);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                notifyObserver(intent, 12, false, null, null);
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessServlet", 2, "handleIdentifyPackage error=", e16);
                    return;
                }
                return;
            }
        }
        notifyObserver(intent, 12, false, null, null);
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessServlet", 2, "handleIdentifyPackage not ok");
        }
    }

    private void b(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        String stringUtf8;
        ResultInfo resultInfo;
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                byte[] bArr = new byte[r14.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                aio_media_open$RspOpenStart aio_media_open_rspopenstart = new aio_media_open$RspOpenStart();
                aio_media_open_rspopenstart.mergeFrom(bArr);
                if (!aio_media_open_rspopenstart.enum_jump_type.has()) {
                    i3 = -1;
                } else {
                    i3 = aio_media_open_rspopenstart.enum_jump_type.get();
                }
                if (!aio_media_open_rspopenstart.bytes_jump_url.has()) {
                    stringUtf8 = "";
                } else {
                    stringUtf8 = aio_media_open_rspopenstart.bytes_jump_url.get().toStringUtf8();
                }
                if (aio_media_open_rspopenstart.msg_result.has()) {
                    resultInfo = c(aio_media_open_rspopenstart.msg_result.get());
                } else {
                    resultInfo = null;
                }
                RspOpenStart rspOpenStart = new RspOpenStart(resultInfo, i3, stringUtf8);
                Bundle bundle = new Bundle();
                bundle.putSerializable("QQAIOMediaSvc.open_start", rspOpenStart);
                if (QLog.isColorLevel() && QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessServlet", 2, "handleStartPackage succsss=", rspOpenStart);
                }
                if (intent.getBundleExtra("bundle") != null) {
                    bundle.putBundle("bundle", intent.getBundleExtra("bundle"));
                }
                notifyObserver(intent, 13, true, bundle, null);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                notifyObserver(intent, 13, false, null, null);
                if (QLog.isColorLevel()) {
                    QLog.d("TogetherBusinessServlet", 2, "handleStartPackage error=", e16);
                    return;
                }
                return;
            }
        }
        notifyObserver(intent, 13, false, null, null);
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessServlet", 2, "handleStartPackage not ok");
        }
    }

    private ResultInfo c(aio_media_open$ResultInfo aio_media_open_resultinfo) {
        int i3;
        boolean z16;
        String stringUtf8;
        if (!aio_media_open_resultinfo.uint32_result.has()) {
            i3 = -1;
        } else {
            i3 = aio_media_open_resultinfo.uint32_result.get();
        }
        if (!aio_media_open_resultinfo.bool_show_err.has()) {
            z16 = false;
        } else {
            z16 = aio_media_open_resultinfo.bool_show_err.get();
        }
        if (!aio_media_open_resultinfo.bytes_errmsg.has()) {
            stringUtf8 = "";
        } else {
            stringUtf8 = aio_media_open_resultinfo.bytes_errmsg.get().toStringUtf8();
        }
        return new ResultInfo(i3, stringUtf8, z16);
    }

    private void d(Intent intent, Packet packet) {
        Bundle bundleExtra = intent.getBundleExtra("bundle");
        String string = bundleExtra.getString("req_data", "");
        String string2 = bundleExtra.getString("req_sign", "");
        long j3 = bundleExtra.getLong("uin", -1L);
        int i3 = bundleExtra.getInt("session_type", -1);
        aio_media_open$ReqOpenIdentify aio_media_open_reqopenidentify = new aio_media_open$ReqOpenIdentify();
        aio_media_open_reqopenidentify.enum_aio_type.set(i3);
        aio_media_open_reqopenidentify.uint64_id.set(j3);
        aio_media_open_reqopenidentify.bytes_req_data.set(ByteStringMicro.copyFromUtf8(string));
        aio_media_open_reqopenidentify.bytes_req_sign.set(ByteStringMicro.copyFromUtf8(string2));
        byte[] byteArray = aio_media_open_reqopenidentify.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.setSSOCommand("QQAIOMediaSvc.open_identify");
        packet.putSendData(allocate.array());
    }

    public static void e(String str, QQAppInterface qQAppInterface, Bundle bundle, BusinessObserver businessObserver) {
        NewIntent newIntent = new NewIntent(qQAppInterface.getApplication(), TogetherBusinessServlet.class);
        newIntent.putExtra("cmd", str);
        newIntent.putExtra("bundle", bundle);
        newIntent.setObserver(businessObserver);
        qQAppInterface.startServlet(newIntent);
    }

    private void f(Intent intent, Packet packet) {
        Bundle bundleExtra = intent.getBundleExtra("bundle");
        String string = bundleExtra.getString("req_data", "");
        String string2 = bundleExtra.getString("req_sign", "");
        long j3 = bundleExtra.getLong("uin", -1L);
        int i3 = bundleExtra.getInt("session_type", -1);
        aio_media_open$ReqOpenStart aio_media_open_reqopenstart = new aio_media_open$ReqOpenStart();
        aio_media_open_reqopenstart.enum_aio_type.set(i3);
        aio_media_open_reqopenstart.uint64_id.set(j3);
        aio_media_open_reqopenstart.bytes_req_data.set(ByteStringMicro.copyFromUtf8(string));
        aio_media_open_reqopenstart.bytes_req_sign.set(ByteStringMicro.copyFromUtf8(string2));
        byte[] byteArray = aio_media_open_reqopenstart.toByteArray();
        ByteBuffer allocate = ByteBuffer.allocate(byteArray.length + 4);
        allocate.putInt(byteArray.length + 4);
        allocate.put(byteArray);
        packet.setSSOCommand("QQAIOMediaSvc.open_start");
        packet.putSendData(allocate.array());
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resp:");
            sb5.append(serviceCmd);
            sb5.append(" is ");
            if (isSuccess) {
                str = "";
            } else {
                str = "not";
            }
            sb5.append(str);
            sb5.append(" success");
            QLog.d("TogetherBusinessServlet", 2, sb5.toString());
        }
        if ("QQAIOMediaSvc.open_identify".equals(serviceCmd)) {
            a(intent, fromServiceMsg);
        } else if ("QQAIOMediaSvc.open_start".equals(serviceCmd)) {
            b(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        String stringExtra = intent.getStringExtra("cmd");
        if (QLog.isColorLevel()) {
            QLog.d("TogetherBusinessServlet", 2, "req:" + stringExtra);
        }
        if ("QQAIOMediaSvc.open_identify".equals(stringExtra)) {
            d(intent, packet);
        } else if ("QQAIOMediaSvc.open_start".equals(stringExtra)) {
            f(intent, packet);
        }
    }
}
