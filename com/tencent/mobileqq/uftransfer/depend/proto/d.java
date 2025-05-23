package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.uftransfer.proto.h;
import com.tencent.mobileqq.uftransfer.proto.i;
import com.tencent.mobileqq.uftransfer.proto.j;
import com.tencent.xweb.FileReaderX5;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$ReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$ResendReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$ResendRspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$RspBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$UploadFileReqBody;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$UploadFileRspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g.d f305168d;

        a(g.d dVar) {
            this.f305168d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) dVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            String str = "";
            j jVar = null;
            if (i3 != 0) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop upload response is failed[" + i3 + "]");
                i16 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            } else {
                oidb_0x6d6$RspBody oidb_0x6d6_rspbody = new oidb_0x6d6$RspBody();
                try {
                    oidb_0x6d6_rspbody.mergeFrom(bArr);
                    if (!oidb_0x6d6_rspbody.upload_file_rsp.has()) {
                        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop upload response error. rspBody has not upload_file_rsp");
                        str = "no upload_file_rsp";
                    } else {
                        oidb_0x6d6$UploadFileRspBody oidb_0x6d6_uploadfilerspbody = oidb_0x6d6_rspbody.upload_file_rsp.get();
                        if (!oidb_0x6d6_uploadfilerspbody.int32_ret_code.has()) {
                            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop upload response error. no retCode");
                            str = "no upload_file_rsp retcode";
                        } else {
                            jVar = com.tencent.mobileqq.uftransfer.depend.proto.b.m(oidb_0x6d6_uploadfilerspbody);
                            i16 = 0;
                        }
                    }
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop upload response error. parse reponseContent excption");
                    str = "parse pbbuf fail";
                }
                i16 = -1;
            }
            if (jVar != null) {
                z16 = true;
            } else {
                jVar = new j();
                jVar.r(i16);
                jVar.s(str);
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "[CS Replay] troop upload response. bReqSuc:" + z16 + " " + jVar.toString());
            g.d dVar = this.f305168d;
            if (dVar != null) {
                dVar.a(z16, jVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g.d f305170d;

        b(g.d dVar) {
            this.f305170d = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) dVar);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            String str = "";
            j jVar = null;
            if (i3 != 0) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop reupload response is failed[" + i3 + "]");
                i16 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
            } else {
                oidb_0x6d6$RspBody oidb_0x6d6_rspbody = new oidb_0x6d6$RspBody();
                try {
                    oidb_0x6d6_rspbody.mergeFrom(bArr);
                    if (!oidb_0x6d6_rspbody.resend_file_rsp.has()) {
                        com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop reupload response error. rspBody has not upload_file_rsp");
                        str = "no resend_file_rsp";
                    } else {
                        oidb_0x6d6$ResendRspBody oidb_0x6d6_resendrspbody = oidb_0x6d6_rspbody.resend_file_rsp.get();
                        if (!oidb_0x6d6_resendrspbody.int32_ret_code.has()) {
                            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop reupload response error. no retCode");
                            str = "no resend_file_rsp retcode";
                        } else {
                            jVar = com.tencent.mobileqq.uftransfer.depend.proto.b.k(oidb_0x6d6_resendrspbody);
                            i16 = 0;
                        }
                    }
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "=_= ^! [CS Replay] troop reupload response error. parse reponseContent excption");
                    str = "parse pbbuf fail";
                }
                i16 = -1;
            }
            if (jVar != null) {
                z16 = true;
            } else {
                jVar = new j();
                jVar.r(i16);
                jVar.s(str);
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "[CS Replay] troop reupload response. bReqSuc:" + z16 + " " + jVar.toString());
            g.d dVar = this.f305170d;
            if (dVar != null) {
                dVar.a(z16, jVar);
            }
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Object d(AppRuntime appRuntime, String str, int i3, int i16, byte[] bArr, Bundle bundle, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        if (appRuntime == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "fail to send pb req. app=null");
            return null;
        }
        ITroopFileProtoReqMgr iTroopFileProtoReqMgr = (ITroopFileProtoReqMgr) appRuntime.getRuntimeService(ITroopFileProtoReqMgr.class, "");
        if (iTroopFileProtoReqMgr == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTTrpPbProtoRequestor", 1, "fail to send pb req. protoReqManager=null");
            return null;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(i3);
        oidb_sso_oidbssopkg.uint32_service_type.set(i16);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(bArr));
        oidb_sso_oidbssopkg.str_client_version.set(AppSetting.n());
        qb1.g createProtoReq = ((ITroopFileProtoReqMgr) appRuntime.getRuntimeService(ITroopFileProtoReqMgr.class, "")).createProtoReq();
        createProtoReq.a(str);
        createProtoReq.d(oidb_sso_oidbssopkg.toByteArray());
        createProtoReq.b(bundle);
        createProtoReq.c(troopProtocolObserver);
        iTroopFileProtoReqMgr.sendProtoRequest(createProtoReq);
        return createProtoReq;
    }

    public void a(AppRuntime appRuntime, Object obj) {
        ITroopFileProtoReqMgr iTroopFileProtoReqMgr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, obj);
        } else if (obj != null && (obj instanceof qb1.g) && (iTroopFileProtoReqMgr = (ITroopFileProtoReqMgr) appRuntime.getRuntimeService(ITroopFileProtoReqMgr.class, "")) != null) {
            iTroopFileProtoReqMgr.cancelRequest((qb1.g) obj);
        }
    }

    public Object b(AppRuntime appRuntime, h hVar, g.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, appRuntime, hVar, dVar);
        }
        oidb_0x6d6$ResendReqBody j3 = com.tencent.mobileqq.uftransfer.depend.proto.b.j(hVar);
        oidb_0x6d6$ReqBody oidb_0x6d6_reqbody = new oidb_0x6d6$ReqBody();
        oidb_0x6d6_reqbody.resend_file_req.set(j3);
        return d(appRuntime, "OidbSvc.0x6d6_1", 1750, 1, oidb_0x6d6_reqbody.toByteArray(), new Bundle(), new b(dVar));
    }

    public Object c(AppRuntime appRuntime, i iVar, g.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, appRuntime, iVar, dVar);
        }
        oidb_0x6d6$UploadFileReqBody l3 = com.tencent.mobileqq.uftransfer.depend.proto.b.l(iVar);
        oidb_0x6d6$ReqBody oidb_0x6d6_reqbody = new oidb_0x6d6$ReqBody();
        oidb_0x6d6_reqbody.upload_file_req.set(l3);
        return d(appRuntime, "OidbSvc.0x6d6_0", 1750, 0, oidb_0x6d6_reqbody.toByteArray(), new Bundle(), new a(dVar));
    }
}
