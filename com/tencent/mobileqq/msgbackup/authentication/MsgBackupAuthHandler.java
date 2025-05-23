package com.tencent.mobileqq.msgbackup.authentication;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.a;
import com.tencent.mobileqq.msgbackup.data.d;
import com.tencent.mobileqq.msgbackup.data.g;
import com.tencent.mobileqq.msgbackup.util.d;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$ConfirmQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$ConfirmQrRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$GetQrReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$GetQrRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$QueryStateReq;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$QueryStateRsp;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$ReqBody;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$RspBody;
import tencent.im.oidb.cmd0xcdd.oidb_cmd0xcdd$UserData;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde$GetDecryptKeyReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde$GetDecryptKeyRsp;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde$GetEncrptkeyReq;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde$GetEncryptKeyRsp;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde$ReqBody;
import tencent.im.oidb.cmd0xcde.oidb_cmd0xcde$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsgBackupAuthHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public MsgBackupAuthHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void G2(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        int i3;
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processConfirmQrRsp result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_cmd0xcdd$RspBody oidb_cmd0xcdd_rspbody = new oidb_cmd0xcdd$RspBody();
            try {
                oidb_cmd0xcdd_rspbody.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e16.getMessage(), e16);
            } catch (Exception e17) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e17.getMessage(), e17);
            }
            if (oidb_cmd0xcdd_rspbody.confirm_qr_rsp.has()) {
                a.C8110a c8110a = new a.C8110a();
                oidb_cmd0xcdd$ConfirmQrRsp oidb_cmd0xcdd_confirmqrrsp = oidb_cmd0xcdd_rspbody.confirm_qr_rsp.get();
                if (oidb_cmd0xcdd_confirmqrrsp.token.has()) {
                    c8110a.d(oidb_cmd0xcdd_confirmqrrsp.token.get().toStringUtf8());
                }
                if (oidb_cmd0xcdd_confirmqrrsp.encrypt_key.has()) {
                    c8110a.c(oidb_cmd0xcdd_confirmqrrsp.encrypt_key.get().toStringUtf8());
                }
                if (oidb_cmd0xcdd_confirmqrrsp.user_data.has()) {
                    c8110a.e(E2(oidb_cmd0xcdd_confirmqrrsp.user_data.get()));
                }
                if (oidb_cmd0xcdd_confirmqrrsp.biz_type.has()) {
                    c8110a.b(oidb_cmd0xcdd_confirmqrrsp.biz_type.get());
                }
                com.tencent.mobileqq.msgbackup.data.a a16 = c8110a.a();
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "processGetQrRsp getQrResponse= " + a16);
                }
                d.b();
                com.tencent.mobileqq.msgbackup.util.c cVar = d.f251402a;
                cVar.f251373c = true;
                cVar.f251374d = 0;
                notifyUI(2, true, a16);
                return;
            }
            return;
        }
        d.b();
        com.tencent.mobileqq.msgbackup.util.c cVar2 = d.f251402a;
        cVar2.f251373c = false;
        cVar2.f251374d = i3;
        notifyUI(2, false, Integer.valueOf(i3));
    }

    private void H2(String str, oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        int i3;
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyReq result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_cmd0xcde$RspBody oidb_cmd0xcde_rspbody = new oidb_cmd0xcde$RspBody();
            try {
                oidb_cmd0xcde_rspbody.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e16.getMessage(), e16);
            } catch (Exception e17) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e17.getMessage(), e17);
            }
            if (oidb_cmd0xcde_rspbody.get_decrypt_key_rsp.has()) {
                oidb_cmd0xcde$GetDecryptKeyRsp oidb_cmd0xcde_getdecryptkeyrsp = oidb_cmd0xcde_rspbody.get_decrypt_key_rsp.get();
                if (oidb_cmd0xcde_getdecryptkeyrsp.dncrypt_key.has()) {
                    String stringUtf8 = oidb_cmd0xcde_getdecryptkeyrsp.dncrypt_key.get().toStringUtf8();
                    MsgBackupManager.G.put(str, stringUtf8);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MsgBackup.MsgBackupAuthHandler", 4, "GetDecryptKeyReq decryptKey=" + stringUtf8 + "encrytKey = " + oidb_cmd0xcde_rspbody.get_encrypt_key_rsp);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyRsp has no dncrypt_key!");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyRsp has no get_decrypt_key_rsp!");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetDecryptKeyRsp error ");
        }
    }

    private void I2(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        int i3;
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_cmd0xcde$RspBody oidb_cmd0xcde_rspbody = new oidb_cmd0xcde$RspBody();
            try {
                oidb_cmd0xcde_rspbody.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e16.getMessage(), e16);
            } catch (Exception e17) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e17.getMessage(), e17);
            }
            if (oidb_cmd0xcde_rspbody.get_encrypt_key_rsp.has()) {
                oidb_cmd0xcde$GetEncryptKeyRsp oidb_cmd0xcde_getencryptkeyrsp = oidb_cmd0xcde_rspbody.get_encrypt_key_rsp.get();
                if (oidb_cmd0xcde_getencryptkeyrsp.encrypt_key.has()) {
                    String stringUtf8 = oidb_cmd0xcde_getencryptkeyrsp.encrypt_key.get().toStringUtf8();
                    MsgBackupManager.E = stringUtf8;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MsgBackup.MsgBackupAuthHandler", 4, "GetEncryptKeyRsp encryptKey=" + stringUtf8);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp has no encrypt_key!");
                }
                if (oidb_cmd0xcde_getencryptkeyrsp.file_meta.has()) {
                    String stringUtf82 = oidb_cmd0xcde_getencryptkeyrsp.file_meta.get().toStringUtf8();
                    MsgBackupManager.D = stringUtf82;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MsgBackup.MsgBackupAuthHandler", 4, "GetEncryptKeyRsp fileMeta=" + stringUtf82);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp has no file_meta!");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp has no get_encrypt_key_rsp!");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcde|OIDBSSOPke. GetEncryptKeyRsp error ");
        }
    }

    private void J2(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        int i3;
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processGetQrRsp result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_cmd0xcdd$RspBody oidb_cmd0xcdd_rspbody = new oidb_cmd0xcdd$RspBody();
            try {
                oidb_cmd0xcdd_rspbody.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e16.getMessage(), e16);
            } catch (Exception e17) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e17.getMessage(), e17);
            }
            if (oidb_cmd0xcdd_rspbody.get_qr_rsp.has()) {
                d.a aVar = new d.a();
                oidb_cmd0xcdd$GetQrRsp oidb_cmd0xcdd_getqrrsp = oidb_cmd0xcdd_rspbody.get_qr_rsp.get();
                if (oidb_cmd0xcdd_getqrrsp.qr_sig.has()) {
                    aVar.d(oidb_cmd0xcdd_getqrrsp.qr_sig.get().toStringUtf8());
                }
                if (oidb_cmd0xcdd_getqrrsp.token.has()) {
                    aVar.e(oidb_cmd0xcdd_getqrrsp.token.get().toStringUtf8());
                }
                if (oidb_cmd0xcdd_getqrrsp.encrypt_key.has()) {
                    aVar.c(oidb_cmd0xcdd_getqrrsp.encrypt_key.get().toStringUtf8());
                }
                if (oidb_cmd0xcdd_getqrrsp.user_data.has()) {
                    aVar.f(E2(oidb_cmd0xcdd_getqrrsp.user_data.get()));
                }
                if (oidb_cmd0xcdd_getqrrsp.biz_type.has()) {
                    aVar.b(oidb_cmd0xcdd_getqrrsp.biz_type.get());
                }
                com.tencent.mobileqq.msgbackup.data.d a16 = aVar.a();
                if (QLog.isColorLevel()) {
                    QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "processGetQrRsp getQrResponse= " + a16);
                }
                com.tencent.mobileqq.msgbackup.util.d.b();
                com.tencent.mobileqq.msgbackup.util.c cVar = com.tencent.mobileqq.msgbackup.util.d.f251402a;
                cVar.f251373c = true;
                cVar.f251374d = 0;
                notifyUI(1, true, a16);
                return;
            }
            return;
        }
        com.tencent.mobileqq.msgbackup.util.d.b();
        com.tencent.mobileqq.msgbackup.util.c cVar2 = com.tencent.mobileqq.msgbackup.util.d.f251402a;
        cVar2.f251373c = false;
        cVar2.f251374d = i3;
        notifyUI(1, false, Integer.valueOf(i3));
    }

    private void K2(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        int i3;
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processQueryStateRsp result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            oidb_cmd0xcdd$RspBody oidb_cmd0xcdd_rspbody = new oidb_cmd0xcdd$RspBody();
            try {
                oidb_cmd0xcdd_rspbody.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e16.getMessage(), e16);
            } catch (Exception e17) {
                QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e17.getMessage(), e17);
            }
            if (oidb_cmd0xcdd_rspbody.query_state_rsp.has()) {
                g.a aVar = new g.a();
                oidb_cmd0xcdd$QueryStateRsp oidb_cmd0xcdd_querystatersp = oidb_cmd0xcdd_rspbody.query_state_rsp.get();
                if (oidb_cmd0xcdd_querystatersp.state.has()) {
                    int i16 = oidb_cmd0xcdd_querystatersp.state.get();
                    aVar.d(i16);
                    if (i16 == 2) {
                        if (oidb_cmd0xcdd_querystatersp.token.has()) {
                            aVar.e(oidb_cmd0xcdd_querystatersp.token.get().toStringUtf8());
                        }
                        if (oidb_cmd0xcdd_querystatersp.encrypt_key.has()) {
                            aVar.c(oidb_cmd0xcdd_querystatersp.encrypt_key.get().toStringUtf8());
                        }
                        if (oidb_cmd0xcdd_querystatersp.user_data.has()) {
                            aVar.f(E2(oidb_cmd0xcdd_querystatersp.user_data.get()));
                        }
                        if (oidb_cmd0xcdd_querystatersp.biz_type.has()) {
                            aVar.b(oidb_cmd0xcdd_querystatersp.biz_type.get());
                        }
                    }
                }
                notifyUI(4, true, aVar.a());
                return;
            }
            notifyUI(4, false, null);
        }
    }

    private void L2(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        int i3;
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processRejectQrRsp result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0) {
            notifyUI(5, true, null);
        } else {
            notifyUI(5, false, null);
        }
    }

    private void M2(oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg) {
        int i3;
        if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "handle OidbSvc.0xcdd|OIDBSSOPke. processVerifyTokenRsp result=" + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0) {
            notifyUI(3, true, null);
        } else {
            notifyUI(3, false, null);
        }
    }

    public void D2(MsgBackupUserData msgBackupUserData, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, msgBackupUserData, str, Integer.valueOf(i3));
            return;
        }
        oidb_cmd0xcdd$ReqBody oidb_cmd0xcdd_reqbody = new oidb_cmd0xcdd$ReqBody();
        oidb_cmd0xcdd$ConfirmQrReq oidb_cmd0xcdd_confirmqrreq = new oidb_cmd0xcdd$ConfirmQrReq();
        oidb_cmd0xcdd_confirmqrreq.qr_sig.set(ByteStringMicro.copyFromUtf8(str));
        oidb_cmd0xcdd$UserData oidb_cmd0xcdd_userdata = new oidb_cmd0xcdd$UserData();
        oidb_cmd0xcdd_userdata.f435990ip.set(ByteStringMicro.copyFromUtf8(msgBackupUserData.b()));
        oidb_cmd0xcdd_userdata.port.set(msgBackupUserData.f());
        if (msgBackupUserData.g() != null) {
            oidb_cmd0xcdd_userdata.ssid.set(ByteStringMicro.copyFromUtf8(msgBackupUserData.g()));
        }
        if (msgBackupUserData.a() != null) {
            oidb_cmd0xcdd_userdata.bssid.set(ByteStringMicro.copyFromUtf8(msgBackupUserData.a()));
        }
        oidb_cmd0xcdd_userdata.platform.set(msgBackupUserData.e());
        oidb_cmd0xcdd_confirmqrreq.user_data.set(oidb_cmd0xcdd_userdata);
        oidb_cmd0xcdd_confirmqrreq.biz_type.set(i3);
        oidb_cmd0xcdd_reqbody.confirm_qr_req.set(oidb_cmd0xcdd_confirmqrreq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3293);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xcdd_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xcdd");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public MsgBackupUserData E2(oidb_cmd0xcdd$UserData oidb_cmd0xcdd_userdata) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MsgBackupUserData) iPatchRedirector.redirect((short) 12, (Object) this, (Object) oidb_cmd0xcdd_userdata);
        }
        MsgBackupUserData.b bVar = new MsgBackupUserData.b();
        if (oidb_cmd0xcdd_userdata.f435990ip.has()) {
            bVar.c(oidb_cmd0xcdd_userdata.f435990ip.get().toStringUtf8());
        }
        if (oidb_cmd0xcdd_userdata.port.has()) {
            bVar.f(oidb_cmd0xcdd_userdata.port.get());
        }
        if (oidb_cmd0xcdd_userdata.ssid.has()) {
            bVar.g(oidb_cmd0xcdd_userdata.ssid.get().toStringUtf8());
        }
        if (oidb_cmd0xcdd_userdata.bssid.has()) {
            bVar.b(oidb_cmd0xcdd_userdata.bssid.get().toStringUtf8());
        }
        if (oidb_cmd0xcdd_userdata.is_nt.has()) {
            bVar.d(oidb_cmd0xcdd_userdata.is_nt.get());
        }
        return bVar.a();
    }

    public void F2(MsgBackupUserData msgBackupUserData, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, msgBackupUserData, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "getQrRequest called: userdata = " + msgBackupUserData + ", ispush = " + z16);
        }
        oidb_cmd0xcdd$ReqBody oidb_cmd0xcdd_reqbody = new oidb_cmd0xcdd$ReqBody();
        oidb_cmd0xcdd$GetQrReq oidb_cmd0xcdd_getqrreq = new oidb_cmd0xcdd$GetQrReq();
        oidb_cmd0xcdd_getqrreq.push.set(z16);
        oidb_cmd0xcdd$UserData oidb_cmd0xcdd_userdata = new oidb_cmd0xcdd$UserData();
        oidb_cmd0xcdd_userdata.f435990ip.set(ByteStringMicro.copyFromUtf8(msgBackupUserData.b()));
        oidb_cmd0xcdd_userdata.port.set(msgBackupUserData.f());
        String g16 = msgBackupUserData.g();
        PBBytesField pBBytesField = oidb_cmd0xcdd_userdata.ssid;
        String str = "";
        if (g16 == null) {
            g16 = "";
        }
        pBBytesField.set(ByteStringMicro.copyFromUtf8(g16));
        String a16 = msgBackupUserData.a();
        PBBytesField pBBytesField2 = oidb_cmd0xcdd_userdata.bssid;
        if (a16 != null) {
            str = a16;
        }
        pBBytesField2.set(ByteStringMicro.copyFromUtf8(str));
        oidb_cmd0xcdd_userdata.platform.set(msgBackupUserData.e());
        oidb_cmd0xcdd_getqrreq.user_data.set(oidb_cmd0xcdd_userdata);
        oidb_cmd0xcdd_getqrreq.biz_type.set(i3);
        oidb_cmd0xcdd_reqbody.get_qr_req.set(oidb_cmd0xcdd_getqrreq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3293);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xcdd_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xcdd");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.addAttribute("MsgBackup_request_type", 1);
        sendPbReq(createToServiceMsg);
    }

    public void N2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        oidb_cmd0xcdd$ReqBody oidb_cmd0xcdd_reqbody = new oidb_cmd0xcdd$ReqBody();
        oidb_cmd0xcdd$QueryStateReq oidb_cmd0xcdd_querystatereq = new oidb_cmd0xcdd$QueryStateReq();
        oidb_cmd0xcdd_querystatereq.qr_sig.set(ByteStringMicro.copyFromUtf8(str));
        oidb_cmd0xcdd_reqbody.query_state_req.set(oidb_cmd0xcdd_querystatereq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3293);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(4);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xcdd_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xcdd");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void O2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        oidb_cmd0xcde$ReqBody oidb_cmd0xcde_reqbody = new oidb_cmd0xcde$ReqBody();
        oidb_cmd0xcde$GetDecryptKeyReq oidb_cmd0xcde_getdecryptkeyreq = new oidb_cmd0xcde$GetDecryptKeyReq();
        oidb_cmd0xcde_getdecryptkeyreq.file_meta.set(ByteStringMicro.copyFromUtf8(str));
        oidb_cmd0xcde_reqbody.get_decrypt_key_req.set(oidb_cmd0xcde_getdecryptkeyreq);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3294);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(2);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xcde_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xcde");
        createToServiceMsg.extraData.putString("req_key_file_meta", str);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(15000L);
        sendPbReq(createToServiceMsg);
    }

    public void P2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        oidb_cmd0xcde$ReqBody oidb_cmd0xcde_reqbody = new oidb_cmd0xcde$ReqBody();
        oidb_cmd0xcde_reqbody.get_encrypt_key_req.set(new oidb_cmd0xcde$GetEncrptkeyReq());
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3294);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xcde_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xcde");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xcdd");
            this.allowCmdSet.add("OidbSvc.0xcde");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "MsgBackupAuthHandler cmd=" + fromServiceMsg.getServiceCmd() + ", isSuccess = " + fromServiceMsg.isSuccess() + ", resultcode = " + fromServiceMsg.getResultCode());
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupAuthHandler", 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        if ("OidbSvc.0xcdd".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) || "OidbSvc.0xcde".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (fromServiceMsg.isSuccess()) {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                try {
                    oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e16.getMessage(), e16);
                } catch (Exception e17) {
                    QLog.w("MsgBackup.MsgBackupAuthHandler", 4, e17.getMessage(), e17);
                }
                int i3 = oidb_sso_oidbssopkg.uint32_service_type.get();
                if ("OidbSvc.0xcdd".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                    if (i3 == 1) {
                        J2(oidb_sso_oidbssopkg);
                        return;
                    }
                    if (i3 == 2) {
                        G2(oidb_sso_oidbssopkg);
                        return;
                    }
                    if (i3 == 3) {
                        M2(oidb_sso_oidbssopkg);
                        return;
                    } else if (i3 == 4) {
                        K2(oidb_sso_oidbssopkg);
                        return;
                    } else {
                        if (i3 == 5) {
                            L2(oidb_sso_oidbssopkg);
                            return;
                        }
                        return;
                    }
                }
                if ("OidbSvc.0xcde".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                    if (i3 == 1) {
                        I2(oidb_sso_oidbssopkg);
                        return;
                    } else {
                        if (i3 == 2) {
                            H2(toServiceMsg.extraData.getString("req_key_file_meta"), oidb_sso_oidbssopkg);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            Object attribute = toServiceMsg.getAttribute("MsgBackup_request_type");
            if (attribute instanceof Integer) {
                int intValue = ((Integer) attribute).intValue();
                if ("OidbSvc.0xcdd".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
                    if (intValue == 1) {
                        J2(null);
                        return;
                    }
                    return;
                }
                "OidbSvc.0xcde".equalsIgnoreCase(fromServiceMsg.getServiceCmd());
            }
        }
    }
}
