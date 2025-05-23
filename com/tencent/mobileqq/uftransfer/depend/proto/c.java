package com.tencent.mobileqq.uftransfer.depend.proto;

import android.os.Bundle;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.uftransfer.proto.f;
import com.tencent.mobileqq.uftransfer.proto.g;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqlive.tvkplayer.tools.config.TVKConfigSystem;
import com.tencent.xweb.FileReaderX5;
import mqq.app.AppRuntime;
import tencent.im.cs.cmd0x345.cmd0x345$ReqBody;
import tencent.im.cs.cmd0x345.cmd0x345$RspBody;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x346.cmd0x346$RspBody;
import tencent.im.cs.cmd0x346.cmd0x346$UploadSuccRsp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f305156a;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g.a f305157d;

        a(g.a aVar) {
            this.f305157d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] response V2");
            Bundle bundle = new Bundle();
            boolean z16 = false;
            com.tencent.mobileqq.uftransfer.proto.d dVar = null;
            if (!c.this.b(protoResp, bundle)) {
                i3 = bundle.getInt("retCode");
                str = bundle.getString("retMsg");
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V2 error. parse reponseContent excption");
                    str = "parse pbbuf fail";
                }
                if (!cmd0x346_rspbody.msg_apply_upload_rsp_v2.has()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V2 error. rspBody has not hasMsgApplyUploadRsp");
                    str = "no msg_apply_upload_rsp_v2 ";
                    i3 = 9045;
                } else {
                    dVar = com.tencent.mobileqq.uftransfer.depend.proto.b.e(cmd0x346_rspbody.msg_apply_upload_rsp_v2.get());
                    dVar.r(wupBuffer);
                    str = "";
                    i3 = 0;
                }
            }
            if (dVar != null) {
                z16 = true;
            } else {
                dVar = new com.tencent.mobileqq.uftransfer.proto.d();
                dVar.D(i3);
                dVar.E(str);
            }
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = i3;
            statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] response V2. bReqSuc:" + z16 + " " + dVar.toString());
            g.a aVar = this.f305157d;
            if (aVar != null) {
                aVar.a(z16, dVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g.a f305159d;

        b(g.a aVar) {
            this.f305159d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) aVar);
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] response V2 Hit");
            Bundle bundle = new Bundle();
            boolean z16 = false;
            com.tencent.mobileqq.uftransfer.proto.d dVar = null;
            if (!c.this.b(protoResp, bundle)) {
                i3 = bundle.getInt("retCode");
                str = bundle.getString("retMsg");
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V2 Hit error. parse reponseContent excption");
                    str = "parse pbbuf fail";
                }
                if (!cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.has()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V2 Hit error. rspBody has not hasMsgApplyUploadRsp");
                    str = "no msg_apply_upload_hit_rsp_v2 ";
                    i3 = 9045;
                } else {
                    dVar = com.tencent.mobileqq.uftransfer.depend.proto.b.f(cmd0x346_rspbody.msg_apply_upload_hit_rsp_v2.get());
                    dVar.r(wupBuffer);
                    str = "";
                    i3 = 0;
                }
            }
            if (dVar != null) {
                z16 = true;
            } else {
                dVar = new com.tencent.mobileqq.uftransfer.proto.d();
                dVar.D(i3);
                dVar.E(str);
            }
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = i3;
            statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] response V3. bReqSuc:" + z16 + " " + dVar.toString());
            g.a aVar = this.f305159d;
            if (aVar != null) {
                aVar.a(z16, dVar);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.uftransfer.depend.proto.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    class C8868c implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ cmd0x346$ReqBody f305161d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g.a f305162e;

        C8868c(cmd0x346$ReqBody cmd0x346_reqbody, g.a aVar) {
            this.f305161d = cmd0x346_reqbody;
            this.f305162e = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, c.this, cmd0x346_reqbody, aVar);
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            String str;
            int i3;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] response V3");
            Bundle bundle = new Bundle();
            boolean z17 = false;
            com.tencent.mobileqq.uftransfer.proto.d dVar = null;
            if (!c.this.b(protoResp, bundle)) {
                i3 = bundle.getInt("retCode");
                str = bundle.getString("retMsg");
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V3 error. parse reponseContent excption");
                    str = "parse pbbuf fail";
                }
                if (!cmd0x346_rspbody.msg_apply_upload_rsp_v3.has()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] response V3 error. rspBody has not hasMsgApplyUploadRsp");
                    str = "no msg_apply_upload_rsp_v3 ";
                    i3 = 9045;
                } else {
                    if (cmd0x346_rspbody.uint32_flag_use_media_platform.has()) {
                        if (cmd0x346_rspbody.uint32_flag_use_media_platform.get() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] response V3: bUseMediaPlatform " + z16);
                    } else {
                        if (this.f305161d.uint32_flag_support_mediaplatform.get() == 1) {
                            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] response V3: uint32_flag_use_media_platform is false !!!");
                        }
                        z16 = false;
                    }
                    dVar = com.tencent.mobileqq.uftransfer.depend.proto.b.g(cmd0x346_rspbody.msg_apply_upload_rsp_v3.get(), z16);
                    dVar.r(wupBuffer);
                    dVar.w(2);
                    str = "";
                    i3 = 0;
                }
            }
            if (dVar != null) {
                z17 = true;
            } else {
                dVar = new com.tencent.mobileqq.uftransfer.proto.d();
                dVar.D(i3);
                dVar.E(str);
            }
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = i3;
            statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] response V3. bReqSuc:" + z17 + " " + dVar.toString());
            g.a aVar = this.f305162e;
            if (aVar != null) {
                aVar.a(z17, dVar);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class d implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g.b f305164d;

        d(g.b bVar) {
            this.f305164d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] setc2cuploadsuc");
            Bundle bundle = new Bundle();
            boolean z16 = false;
            z16 = false;
            int i16 = 0;
            if (!c.this.b(protoResp, bundle)) {
                i3 = bundle.getInt("retCode");
                str = bundle.getString("retMsg");
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x346$RspBody cmd0x346_rspbody = new cmd0x346$RspBody();
                try {
                    cmd0x346_rspbody.mergeFrom(wupBuffer);
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] setc2cuploadsuc error. parse reponseContent excption");
                    str = "parse pbbuf fail";
                }
                if (!cmd0x346_rspbody.msg_upload_succ_rsp.has()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] setc2cuploadsuc error. rspBody has not hasMsgApplyUploadRsp");
                    str = "no msg_upload_succ_rsp ";
                    i3 = 9045;
                } else {
                    cmd0x346$UploadSuccRsp cmd0x346_uploadsuccrsp = cmd0x346_rspbody.msg_upload_succ_rsp.get();
                    if (cmd0x346_uploadsuccrsp.int32_ret_code.has()) {
                        i16 = cmd0x346_uploadsuccrsp.int32_ret_code.get();
                    }
                    if (cmd0x346_uploadsuccrsp.str_ret_msg.has()) {
                        str = cmd0x346_uploadsuccrsp.str_ret_msg.get();
                    } else {
                        str = "";
                    }
                    i3 = i16;
                    z16 = true;
                }
            }
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = i3;
            statictisInfo.retryCount = protoResp.freeRunnalbleIndex;
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] setc2cuploadsuc. bReqSuc:" + z16 + " retCode:" + i3 + " retMsg:" + str);
            g.b bVar = this.f305164d;
            if (bVar != null) {
                bVar.a(z16, i3, str);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class e implements ProtoReqManagerImpl.IProtoRespBack {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ g.c f305166d;

        e(g.c cVar) {
            this.f305166d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) cVar);
            }
        }

        @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
        public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) protoResp, (Object) protoReq);
                return;
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^> [CS Replay] requestDiscUpload");
            Bundle bundle = new Bundle();
            boolean z16 = false;
            f fVar = null;
            if (!c.this.b(protoResp, bundle)) {
                i3 = bundle.getInt("retCode");
                str = bundle.getString("retMsg");
            } else {
                byte[] wupBuffer = protoResp.resp.getWupBuffer();
                cmd0x345$RspBody cmd0x345_rspbody = new cmd0x345$RspBody();
                try {
                    cmd0x345_rspbody.mergeFrom(wupBuffer);
                    if (cmd0x345_rspbody.uint32_return_code.has()) {
                        i3 = cmd0x345_rspbody.uint32_return_code.get();
                    } else {
                        i3 = 0;
                    }
                } catch (InvalidProtocolBufferMicroException unused) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] requestDiscUpload error. parse reponseContent excption");
                    str = "parse pbbuf fail";
                }
                if (!cmd0x345_rspbody.msg_subcmd_0x1_rsp_body.has()) {
                    com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! [CS Replay] requestDiscUpload error. rspBody has not hasMsgApplyUploadRsp");
                    str = "no msg_subcmd_0x1_rsp_body ";
                    i3 = 9045;
                } else {
                    fVar = com.tencent.mobileqq.uftransfer.depend.proto.b.i(cmd0x345_rspbody.msg_subcmd_0x1_rsp_body.get());
                    str = fVar.e();
                    fVar.n(i3);
                }
            }
            if (fVar != null) {
                z16 = true;
            } else {
                fVar = new f();
                fVar.n(i3);
                fVar.o(str);
            }
            com.tencent.mobileqq.uftransfer.depend.c.c("[UFTTransfer] UFTPbProtoRequestor", 1, "[CS Replay] requestDiscUpload. bReqSuc:" + z16 + " retCode:" + i3 + " retMsg:" + str);
            g.c cVar = this.f305166d;
            if (cVar != null) {
                cVar.a(z16, fVar);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25174);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f305156a = 0;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ProtoReqManagerImpl.ProtoResp protoResp, Bundle bundle) {
        String str;
        int i3;
        boolean z16;
        int i16 = FileReaderX5.ERR_CODE_NOT_SUPPORT;
        if (protoResp != null && protoResp.resp != null) {
            if (d(protoResp)) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! proto rsp  is timeout[" + protoResp.resp.getResultCode() + "]");
                i16 = FileMsg.RESULT_CODE_MSF_TIMEOUT;
                str = "msf timeout";
            } else if (protoResp.resp.getResultCode() != 1000) {
                com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! proto rsp  is failed[" + protoResp.resp.getResultCode() + "]");
                str = " req resp is 1000 OK";
            } else {
                z16 = false;
                str = "";
                i3 = 0;
                if (z16 && bundle != null) {
                    bundle.putInt("retCode", i3);
                    bundle.putString("retMsg", str);
                }
                return !z16;
            }
        } else {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "=_= ^! proto rsp is null");
            str = "proto rsp is null";
        }
        i3 = i16;
        z16 = true;
        if (z16) {
            bundle.putInt("retCode", i3);
            bundle.putString("retMsg", str);
        }
        return !z16;
    }

    private cmd0x346$ReqBody c(int i3, com.tencent.mobileqq.uftransfer.proto.b bVar) {
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(i3);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        PBUInt32Field pBUInt32Field = cmd0x346_reqbody.uint32_seq;
        int i16 = f305156a;
        f305156a = i16 + 1;
        pBUInt32Field.set(i16);
        if (bVar.f()) {
            cmd0x346_reqbody.uint32_flag_support_mediaplatform.set(1);
        }
        if (bVar.a() > 0) {
            cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
            cmd0x346_extensionreq.uint64_id.set(3L);
            cmd0x346_extensionreq.uint64_type.set(bVar.a());
            if (bVar.b() != null && bVar.b().length > 0) {
                cmd0x346_extensionreq.bytes_sig.set(ByteStringMicro.copyFrom(bVar.b()));
            }
            if (bVar.c() != null && bVar.c().length() > 0) {
                cmd0x346_extensionreq.str_dst_phonenum.set(bVar.c());
            }
            cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
        }
        return cmd0x346_reqbody;
    }

    private boolean d(ProtoReqManagerImpl.ProtoResp protoResp) {
        if (protoResp.resp.getResultCode() != 1002 && protoResp.resp.getResultCode() != 1013) {
            return false;
        }
        return true;
    }

    private boolean i(AppRuntime appRuntime, ProtoReqManagerImpl.ProtoReq protoReq) {
        if (appRuntime == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "fail to send pb req. app=null");
            return false;
        }
        IProtoReqManager iProtoReqManager = (IProtoReqManager) appRuntime.getRuntimeService(IProtoReqManager.class, "");
        if (iProtoReqManager == null) {
            com.tencent.mobileqq.uftransfer.depend.c.b("[UFTTransfer] UFTPbProtoRequestor", 1, "fail to send pb req. protoReqManager=null");
            return false;
        }
        iProtoReqManager.sendProtoReq(protoReq);
        return true;
    }

    private boolean j(AppRuntime appRuntime, String str, byte[] bArr, com.tencent.mobileqq.uftransfer.depend.proto.a aVar, ProtoReqManagerImpl.IProtoRespBack iProtoRespBack) {
        ProtoReqManagerImpl.ProtoReq protoReq = new ProtoReqManagerImpl.ProtoReq();
        protoReq.ssoCmd = str;
        protoReq.reqBody = bArr;
        protoReq.busiData = aVar;
        protoReq.callback = iProtoRespBack;
        return i(appRuntime, protoReq);
    }

    public boolean e(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.c cVar, g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, cVar, aVar)).booleanValue();
        }
        cmd0x346$ReqBody c16 = c(1600, cVar);
        c16.msg_apply_upload_req_v2.set(com.tencent.mobileqq.uftransfer.depend.proto.b.a(cVar));
        return j(appRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V2-1600", c16.toByteArray(), null, new a(aVar));
    }

    public boolean f(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.c cVar, g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, appRuntime, cVar, aVar)).booleanValue();
        }
        cmd0x346$ReqBody c16 = c(TVKConfigSystem.REQUEST_ONLINE_CONFIG_MIN_INTERVAL_SEC, cVar);
        c16.msg_apply_upload_hit_req_v2.set(com.tencent.mobileqq.uftransfer.depend.proto.b.b(cVar));
        return j(appRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_HIT_V2-1800", c16.toByteArray(), null, new b(aVar));
    }

    public boolean g(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.c cVar, g.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appRuntime, cVar, aVar)).booleanValue();
        }
        cmd0x346$ReqBody c16 = c(FSUploadConst.ERR_FILE_NOT_EXIST, cVar);
        c16.msg_apply_upload_req_v3.set(com.tencent.mobileqq.uftransfer.depend.proto.b.c(cVar));
        return j(appRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_APPLY_UPLOAD_V3-1700", c16.toByteArray(), null, new C8868c(c16, aVar));
    }

    public boolean h(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.e eVar, g.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, appRuntime, eVar, cVar)).booleanValue();
        }
        cmd0x345$ReqBody cmd0x345_reqbody = new cmd0x345$ReqBody();
        cmd0x345_reqbody.msg_subcmd_0x1_req_body.set(com.tencent.mobileqq.uftransfer.depend.proto.b.h(eVar));
        cmd0x345_reqbody.uint32_sub_cmd.set(1);
        return j(appRuntime, "GTalkFileAppSvr.CMD_DISCUSS_FILE", cmd0x345_reqbody.toByteArray(), null, new e(cVar));
    }

    public boolean k(AppRuntime appRuntime, com.tencent.mobileqq.uftransfer.proto.a aVar, g.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, appRuntime, aVar, bVar)).booleanValue();
        }
        cmd0x346$ReqBody c16 = c(800, aVar);
        c16.msg_upload_succ_req.set(com.tencent.mobileqq.uftransfer.depend.proto.b.d(aVar));
        return j(appRuntime, "OfflineFilleHandleSvr.pb_ftn_CMD_REQ_UPLOAD_SUCC-800", c16.toByteArray(), null, new d(bVar));
    }
}
