package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class dh extends MSFServlet {
    static IPatchRedirector $redirector_;

    public dh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private byte[] a(byte b16, String str, String str2) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1372);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        ByteBuffer allocate = ByteBuffer.allocate(9);
        Long valueOf = Long.valueOf(Long.parseLong(str));
        Long valueOf2 = Long.valueOf(Long.parseLong(str2));
        allocate.put(new byte[]{(byte) ((valueOf.longValue() >> 24) & 255), (byte) ((valueOf.longValue() >> 16) & 255), (byte) ((valueOf.longValue() >> 8) & 255), (byte) (valueOf.longValue() & 255)}).put(new byte[]{(byte) ((valueOf2.longValue() >> 24) & 255), (byte) ((valueOf2.longValue() >> 16) & 255), (byte) ((valueOf2.longValue() >> 8) & 255), (byte) (valueOf2.longValue() & 255)}).put(b16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
        ByteBuffer allocate2 = ByteBuffer.allocate(byteArray.length + 4);
        allocate2.putInt(byteArray.length + 4);
        allocate2.put(byteArray);
        return allocate2.array();
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        boolean z16;
        ByteBuffer wrap;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        int intExtra = intent.getIntExtra("command", -1);
        boolean isSuccess = fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        if (intExtra == 0) {
            isSuccess = false;
            try {
                ByteBuffer wrap2 = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                byte[] bArr = new byte[wrap2.getInt() - 4];
                wrap2.get(bArr);
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
                i3 = mergeFrom.uint32_result.get();
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("set_troop_admin", 2, "resultCode: " + i3);
                }
                wrap = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray());
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (z16) {
                byte[] bArr2 = new byte[4];
                wrap.get(bArr2);
                String valueOf = String.valueOf(Utils.d(bArr2, 0));
                byte[] bArr3 = new byte[4];
                wrap.get(bArr3);
                String valueOf2 = String.valueOf(Utils.d(bArr3, 0));
                byte b16 = wrap.get();
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("set troop admin response. troopCode: ");
                    sb5.append(valueOf);
                    sb5.append(" memberUin: ");
                    sb5.append(valueOf2);
                    sb5.append(" operation: ");
                    if (b16 == 0) {
                        str = "delete";
                    } else if (b16 == 1) {
                        str = "add";
                    } else {
                        str = "unkonwn";
                    }
                    sb5.append(str);
                    QLog.d("set_troop_admin", 2, sb5.toString());
                }
                if (valueOf != null && valueOf.length() > 0 && valueOf2 != null && valueOf2.length() > 0) {
                    bundle.putString(AppConstants.Key.TROOP_CODE, valueOf);
                    bundle.putString("troop_member_uin", valueOf2);
                    bundle.putByte(QCircleDaTongConstant.ElementParamValue.OPERATION, b16);
                    isSuccess = z16;
                }
            } else {
                bundle.putInt("error_code", i3);
                notifyObserver(intent, intExtra, z16, bundle, com.tencent.mobileqq.troop.api.observer.e.class);
            }
        }
        z16 = isSuccess;
        notifyObserver(intent, intExtra, z16, bundle, com.tencent.mobileqq.troop.api.observer.e.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent.getIntExtra("command", -1) != 0) {
            str = null;
        } else {
            byte byteExtra = intent.getByteExtra(QCircleDaTongConstant.ElementParamValue.OPERATION, (byte) 0);
            String stringExtra = intent.getStringExtra(AppConstants.Key.TROOP_CODE);
            String stringExtra2 = intent.getStringExtra("troop_member_uin");
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("request set troop admin. troopCode: ");
                sb5.append(stringExtra);
                sb5.append(" memberUin: ");
                sb5.append(stringExtra2);
                sb5.append(" operation: ");
                if (byteExtra == 0) {
                    str2 = "delete";
                } else if (byteExtra == 1) {
                    str2 = "add";
                } else {
                    str2 = "unkonwn";
                }
                sb5.append(str2);
                QLog.d("set_troop_admin", 2, sb5.toString());
            }
            packet.putSendData(a(byteExtra, stringExtra, stringExtra2));
            str = "OidbSvc.0x55c_1";
        }
        if (str != null) {
            packet.setSSOCommand(str);
        }
    }
}
