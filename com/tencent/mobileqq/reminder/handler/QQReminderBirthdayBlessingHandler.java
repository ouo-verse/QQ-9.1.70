package com.tencent.mobileqq.reminder.handler;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cm2.b;
import cm2.c;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.impl.FaceIdentificationEnablePrePageApiImpl;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.reminder.pb.BirthdayBlessingPB$ReserveReq;
import com.tencent.mobileqq.reminder.pb.BirthdayBlessingPB$ReserveRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQReminderBirthdayBlessingHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, SoftReference<b>> f281059d;

    protected QQReminderBirthdayBlessingHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f281059d = new ConcurrentHashMap();
        }
    }

    private void E2(ToServiceMsg toServiceMsg, final boolean z16, final int i3, final String str, final Object obj) {
        boolean z17;
        if (toServiceMsg == null) {
            return;
        }
        String str2 = (String) toServiceMsg.getAttribute(FaceIdentificationEnablePrePageApiImpl.CALLBACK_KEY, "");
        if (TextUtils.isEmpty(str2)) {
            QLog.d("QQReminderBirthdayBlessingHandler", 1, "callback key empty! No callback!");
            return;
        }
        final b I2 = I2(str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("doReqCallback key: ");
        sb5.append(str2);
        sb5.append(" callback is null: ");
        if (I2 == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        QLog.d("QQReminderBirthdayBlessingHandler", 1, sb5.toString());
        if (I2 != null) {
            if ((I2 instanceof c) && Looper.getMainLooper() != Looper.myLooper()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.reminder.handler.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.i(z16, i3, str, obj);
                    }
                });
            } else {
                I2.i(z16, i3, str, obj);
            }
        }
    }

    private String F2(@NonNull ToServiceMsg toServiceMsg, @NonNull b bVar) {
        return toServiceMsg.getServiceCmd() + "_" + bVar.hashCode() + "_" + toServiceMsg.hashCode();
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            try {
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<BirthdayBlessingPB$ReserveRsp>() { // from class: com.tencent.mobileqq.reminder.pb.BirthdayBlessingPB$ReserveRsp
                    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], BirthdayBlessingPB$ReserveRsp.class);
                });
                String string = fromServiceMsg.extraData.getString("str_error_msg", fromServiceMsg.getBusinessFailMsg());
                if (fromServiceMsg.isSuccess() && (parseOIDBPkg == 1000 || parseOIDBPkg == 0)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                QLog.d("QQReminderBirthdayBlessingHandler", 1, "handleSendFriendUins isSuccess = " + z16 + " code = " + parseOIDBPkg + " msg = " + string);
                E2(toServiceMsg, z16, parseOIDBPkg, string, null);
                return;
            } catch (Exception e16) {
                QLog.e("QQReminderBirthdayBlessingHandler", 1, "receive: " + e16);
                return;
            }
        }
        QLog.d("QQReminderBirthdayBlessingHandler", 1, "handleSendFriendUins res: " + fromServiceMsg + " req: " + toServiceMsg + " data: " + obj);
        E2(toServiceMsg, false, -1, "", null);
    }

    @Nullable
    private String J2(ToServiceMsg toServiceMsg, b bVar) {
        if (toServiceMsg != null && bVar != null) {
            String F2 = F2(toServiceMsg, bVar);
            this.f281059d.put(F2, new SoftReference<>(bVar));
            toServiceMsg.addAttribute(FaceIdentificationEnablePrePageApiImpl.CALLBACK_KEY, F2);
            QLog.d("QQReminderBirthdayBlessingHandler", 1, "save callback key: " + F2);
            return F2;
        }
        return null;
    }

    @Nullable
    public b I2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SoftReference<b> remove = this.f281059d.remove(str);
        if (remove == null) {
            QLog.d("QQReminderBirthdayBlessingHandler", 1, "popCallback key: " + str + " not found!");
            return null;
        }
        QLog.d("QQReminderBirthdayBlessingHandler", 1, "pop callback key: " + str);
        return remove.get();
    }

    public String K2(List<Long> list, int i3, @Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, list, Integer.valueOf(i3), bVar);
        }
        if (list != null && list.size() != 0) {
            QLog.i("QQReminderBirthdayBlessingHandler", 1, "sendBlessingFriendUins size: " + list.size() + ", source: " + i3);
            BirthdayBlessingPB$ReserveReq birthdayBlessingPB$ReserveReq = new BirthdayBlessingPB$ReserveReq();
            birthdayBlessingPB$ReserveReq.uins.set(list);
            birthdayBlessingPB$ReserveReq.source.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x91d3_0", 37331, 0, birthdayBlessingPB$ReserveReq.toByteArray());
            makeOIDBPkg.setTimeout(5000L);
            String J2 = J2(makeOIDBPkg, bVar);
            sendPbReq(makeOIDBPkg);
            return J2;
        }
        QLog.e("QQReminderBirthdayBlessingHandler", 1, "sendBlessingFriendUins list is null");
        if (bVar != null) {
            bVar.i(false, -1, "list is null", null);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x91d3_0");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            if ("OidbSvcTrpcTcp.0x91d3_0".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
            }
        } else {
            QLog.e("QQReminderBirthdayBlessingHandler", 1, "req: " + toServiceMsg + " res: " + fromServiceMsg);
        }
    }
}
