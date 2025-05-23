package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o extends MSFServlet {
    static IPatchRedirector $redirector_;

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private byte[] a(String[] strArr, String[] strArr2) {
        String[] strArr3 = strArr2;
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1274);
        oidb_sso_oidbssopkg.uint32_service_type.set(7);
        ByteBuffer allocate = ByteBuffer.allocate((strArr.length * 2) + 4 + (strArr3.length * 4));
        int length = strArr.length;
        byte[] bArr = {(byte) ((length >> 8) & 255), (byte) (length & 255)};
        byte[] bArr2 = new byte[strArr.length * 2];
        int i3 = 0;
        for (String str : strArr) {
            long parseLong = Long.parseLong(str);
            bArr2[i3] = (byte) ((parseLong >> 8) & 255);
            bArr2[i3 + 1] = (byte) (255 & parseLong);
            i3 += 2;
        }
        int length2 = strArr3.length;
        int i16 = 0;
        byte[] bArr3 = {(byte) ((length2 >> 8) & 255), (byte) (length2 & 255)};
        byte[] bArr4 = new byte[length2 * 4];
        int length3 = strArr3.length;
        int i17 = 0;
        while (i16 < length3) {
            long parseLong2 = Long.parseLong(strArr3[i16]);
            bArr4[i17 + 3] = (byte) (parseLong2 & 255);
            bArr4[i17 + 2] = (byte) ((parseLong2 >> 8) & 255);
            bArr4[i17 + 1] = (byte) ((parseLong2 >> 16) & 255);
            bArr4[i17] = (byte) ((parseLong2 >> 24) & 255);
            i17 += 4;
            i16++;
            strArr3 = strArr2;
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = oidb_sso_oidbssopkg;
        allocate.put(bArr).put(bArr2).put(bArr3).put(bArr4);
        oidb_sso_oidbssopkg2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        byte[] byteArray = oidb_sso_oidbssopkg2.toByteArray();
        ByteBuffer allocate2 = ByteBuffer.allocate(byteArray.length + 4);
        allocate2.putInt(byteArray.length + 4);
        allocate2.put(byteArray);
        return allocate2.array();
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        int intExtra = intent.getIntExtra("key_cmd", -1);
        fromServiceMsg.isSuccess();
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        if (intExtra == 0) {
            try {
                ByteBuffer wrap = ByteBuffer.wrap(fromServiceMsg.getWupBuffer());
                byte[] bArr = new byte[wrap.getInt() - 4];
                wrap.get(bArr);
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom(bArr);
                if (mergeFrom.uint32_result.get() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ByteBuffer wrap2 = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray());
                if (z16) {
                    byte[] bArr2 = new byte[2];
                    wrap2.get(bArr2);
                    short c16 = Utils.c(bArr2, 0);
                    for (int i3 = 0; i3 < c16; i3++) {
                        byte[] bArr3 = new byte[4];
                        wrap2.get(bArr3);
                        arrayList2.add(String.valueOf(Utils.d(bArr3, 0)));
                        byte[] bArr4 = new byte[2];
                        wrap2.get(bArr4);
                        Utils.c(bArr4, 0);
                        byte[] bArr5 = new byte[2];
                        wrap2.get(bArr5);
                        Utils.c(bArr5, 0);
                        byte[] bArr6 = new byte[2];
                        wrap2.get(bArr6);
                        byte[] bArr7 = new byte[Utils.c(bArr6, 0)];
                        wrap2.get(bArr7);
                        arrayList.add(new String(bArr7, "utf-8"));
                    }
                }
                bundle.putStringArrayList("nickname_list", arrayList);
                bundle.putStringArrayList("uin_list", arrayList2);
                notifyObserver(intent, intExtra, z16, bundle, QRDisplayActivity.ab.class);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent.getIntExtra("key_cmd", -1) != 0) {
            str = null;
        } else {
            packet.putSendData(a(intent.getStringArrayExtra("field_id"), intent.getStringArrayExtra("uin_list")));
            str = "OidbSvc.0x4fa_7";
        }
        if (str != null) {
            packet.setSSOCommand(str);
        }
    }
}
