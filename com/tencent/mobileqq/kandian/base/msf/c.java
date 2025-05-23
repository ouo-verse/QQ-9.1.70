package com.tencent.mobileqq.kandian.base.msf;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class c {
    public static ToServiceMsg a(String str) {
        return new ToServiceMsg("mobileqq.service", com.tencent.mobileqq.kandian.base.utils.b.a(), str);
    }

    public static ToServiceMsg b(String str, int i3, int i16, byte[] bArr) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        return d(str, oidb_sso_oidbssopkg.toByteArray());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int c(FromServiceMsg fromServiceMsg, Object obj, MessageMicro messageMicro) {
        int resultCode = fromServiceMsg.getResultCode();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = null;
        StringBuilder sb5 = QLog.isDevelopLevel() ? new StringBuilder() : null;
        if (resultCode == 1000) {
            if (obj != null) {
                try {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = new oidb_sso$OIDBSSOPkg();
                    try {
                        oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2.mergeFrom((byte[]) obj);
                    } catch (Exception e16) {
                        e = e16;
                        oidb_sso_oidbssopkg = oidb_sso_oidbssopkg2;
                        if (sb5 != null) {
                            sb5.append("parseOIDBPkg, oidb_sso, parseFrom byte ");
                            sb5.append(e.toString());
                        }
                        e.printStackTrace();
                        if (oidb_sso_oidbssopkg != null) {
                        }
                        if (oidb_sso_oidbssopkg != null) {
                            try {
                                messageMicro.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                            } catch (Exception e17) {
                                if (sb5 != null) {
                                    sb5.append(e17.toString());
                                }
                            }
                        }
                        if (sb5 != null) {
                            QLog.isDevelopLevel();
                        }
                        return resultCode;
                    }
                } catch (Exception e18) {
                    e = e18;
                }
            } else if (sb5 != null) {
                sb5.append("parseOIDBPkg, data is null");
            }
            if (oidb_sso_oidbssopkg != null) {
                resultCode = oidb_sso_oidbssopkg.uint32_result.get();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null && messageMicro != null) {
                messageMicro.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
            }
        } else if (sb5 != null) {
            sb5.append("parseOIDBPkg, sso result: ");
            sb5.append(resultCode);
        }
        if (sb5 != null && sb5.length() > 0) {
            QLog.isDevelopLevel();
        }
        return resultCode;
    }

    public static ToServiceMsg d(String str, byte[] bArr) {
        ToServiceMsg a16 = a(str);
        a16.putWupBuffer(bArr);
        a16.setTimeout(15000L);
        return a16;
    }
}
