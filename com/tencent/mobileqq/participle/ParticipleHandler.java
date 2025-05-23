package com.tencent.mobileqq.participle;

import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79$ReqBody;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79$RspBody;
import tencent.im.oidb.cmd0xd79.Oidb_0xd79$content;

/* loaded from: classes16.dex */
public class ParticipleHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f257196d;

    public ParticipleHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f257196d = new AtomicInteger();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0083 A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #0 {Exception -> 0x009a, blocks: (B:3:0x0005, B:5:0x001c, B:7:0x0036, B:9:0x0040, B:11:0x0046, B:12:0x0053, B:14:0x0059, B:17:0x006d, B:24:0x0076, B:25:0x007d, B:27:0x0083, B:33:0x007a), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void D2(FromServiceMsg fromServiceMsg, Object obj) {
        List<ByteStringMicro> list;
        boolean z16;
        try {
            Oidb_0xd79$RspBody oidb_0xd79$RspBody = new Oidb_0xd79$RspBody();
            OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xd79$RspBody);
            int i3 = oidb_0xd79$RspBody.uint32_ret.get();
            if (oidb_0xd79$RspBody.uint32_compress_flag.get() == 0) {
                Oidb_0xd79$content oidb_0xd79$content = new Oidb_0xd79$content();
                oidb_0xd79$content.mergeFrom(oidb_0xd79$RspBody.bytes_raw_content.get().toByteArray());
                if (oidb_0xd79$content.bytes_slice_content.has()) {
                    list = oidb_0xd79$content.bytes_slice_content.get();
                    if (list == null && list.size() > 0) {
                        ArrayList arrayList = new ArrayList(list.size());
                        Iterator<ByteStringMicro> it = list.iterator();
                        while (it.hasNext()) {
                            String E2 = E2(it.next().toStringUtf8());
                            if (!TextUtils.isEmpty(E2)) {
                                arrayList.add(E2);
                            }
                        }
                        if (i3 == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        notifyUI(1, z16, arrayList);
                    } else {
                        notifyUI(1, false, null);
                    }
                    if (!QLog.isColorLevel()) {
                        QLog.d("ParticipleHandler", 2, "handleParticipleTheContent : ret -> " + i3);
                        return;
                    }
                    return;
                }
            }
            list = null;
            if (list == null) {
            }
            notifyUI(1, false, null);
            if (!QLog.isColorLevel()) {
            }
        } catch (Exception e16) {
            QLog.d("ParticipleHandler", 1, e16, new Object[0]);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0040, code lost:
    
        if (r5 != r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0042, code lost:
    
        return r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String E2(String str) {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        char[] charArray = str.toCharArray();
        int length = str.length() - 1;
        int i3 = 0;
        while (i3 <= length && (c16 = charArray[i3]) <= ' ' && c16 != 20) {
            i3++;
        }
        int i16 = length;
        while (i16 >= i3 && charArray[i16] <= ' ' && (i16 == 0 || charArray[i16 - 1] != 20)) {
            i16--;
        }
        return str.substring(i3, i16 + 1);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if (fromServiceMsg.isSuccess() && TextUtils.equals(fromServiceMsg.getServiceCmd(), AECameraConstants.CMD_PARTICIPLE)) {
            D2(fromServiceMsg, obj);
        }
    }

    public void participleTheContent(AppInterface appInterface, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, str, str2);
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d("ParticipleHandler", 2, "participleTheContent senderUin -> " + str2);
            }
            Oidb_0xd79$ReqBody oidb_0xd79$ReqBody = new Oidb_0xd79$ReqBody();
            oidb_0xd79$ReqBody.uint64_seq.set(this.f257196d.incrementAndGet());
            oidb_0xd79$ReqBody.uint64_uin.set(Long.parseLong(appInterface.getCurrentUin()));
            oidb_0xd79$ReqBody.uint32_compress_flag.set(0);
            oidb_0xd79$ReqBody.bytes_content.set(ByteStringMicro.copyFrom(str.getBytes()));
            if (!TextUtils.isEmpty(str2)) {
                oidb_0xd79$ReqBody.uint64_sender_uin.set(Long.parseLong(str2));
            }
            oidb_0xd79$ReqBody.bytes_qua.set(ByteStringMicro.copyFrom(("and_" + AppSetting.f() + "_" + AppSetting.f99551k).getBytes()));
            sendPbReq(makeOIDBPkg(AECameraConstants.CMD_PARTICIPLE, 3449, 1, oidb_0xd79$ReqBody.toByteArray()));
        } catch (Exception e16) {
            QLog.d("ParticipleHandler", 1, e16, new Object[0]);
        }
    }
}
