package com.tencent.mobileqq.applets;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$FollowExt;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$FollowReq;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes11.dex */
public class NewPublicAccountServlet extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f196699d;

    public NewPublicAccountServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f196699d = "com.tencent.mobileqq.applets.NewPublicAccountServlet";
        }
    }

    protected byte[] getResponseBytesData(FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this, (Object) fromServiceMsg);
        }
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            return fh.a(fromServiceMsg.getWupBuffer());
        }
        return null;
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f196699d, 2, "onReceive");
        }
        String stringExtra = intent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_CMD");
        byte[] responseBytesData = getResponseBytesData(fromServiceMsg);
        Bundle bundle = new Bundle();
        bundle.putByteArray("data", responseBytesData);
        bundle.putInt(IPublicAccountServlet.RESPONES_CODE, fromServiceMsg.getBusinessFailCode());
        if ("newFollow".equals(stringExtra)) {
            try {
                c cVar = (c) ((PublicAccountIntent) intent).a();
                if (fromServiceMsg.isSuccess()) {
                    oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                    try {
                        try {
                            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(responseBytesData);
                        } catch (Exception e16) {
                            QLog.w(this.f196699d, 4, e16.getMessage(), e16);
                        }
                    } catch (InvalidProtocolBufferMicroException e17) {
                        QLog.w(this.f196699d, 4, e17.getMessage(), e17);
                    }
                    if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has()) {
                        i3 = oidb_sso_oidbssopkg.uint32_result.get();
                        if (QLog.isColorLevel()) {
                            QLog.i(this.f196699d, 2, "handle OidbSvc.0xc96|OIDBSSOPke.result=" + i3);
                        }
                    } else {
                        i3 = -1;
                    }
                    if (i3 == 0 && oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                        oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                        super.getAppRuntime().runOnUiThread(new Runnable(cVar, responseBytesData) { // from class: com.tencent.mobileqq.applets.NewPublicAccountServlet.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ c f196700d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ byte[] f196701e;

                            {
                                this.f196700d = cVar;
                                this.f196701e = responseBytesData;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, NewPublicAccountServlet.this, cVar, responseBytesData);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    this.f196700d.onUpdate(4, true, this.f196701e);
                                }
                            }
                        });
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(this.f196699d, 2, "0xc96 fail");
                        }
                        super.getAppRuntime().runOnUiThread(new Runnable(cVar) { // from class: com.tencent.mobileqq.applets.NewPublicAccountServlet.2
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ c f196702d;

                            {
                                this.f196702d = cVar;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewPublicAccountServlet.this, (Object) cVar);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    this.f196702d.onUpdate(4, false, null);
                                }
                            }
                        });
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f196699d, 2, "handleGetAppletPublicAccount res.isSuccess=false   failCode: " + fromServiceMsg.getBusinessFailCode());
                    }
                    super.getAppRuntime().runOnUiThread(new Runnable(cVar) { // from class: com.tencent.mobileqq.applets.NewPublicAccountServlet.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ c f196703d;

                        {
                            this.f196703d = cVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NewPublicAccountServlet.this, (Object) cVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.f196703d.onUpdate(4, false, null);
                            }
                        }
                    });
                }
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f196699d, 2, "onReceive CMD_PUBLIC_ACCOUNT_FOLLOW fail,", e18.toString());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f196699d, 2, "onReceive exit");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f196699d, 2, "onSend");
        }
        intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_CMD");
        if (QLog.isColorLevel()) {
            QLog.d(this.f196699d, 2, "cmd=", stringExtra);
        }
        if ("newFollow".equals(stringExtra)) {
            PublicAccountIntent publicAccountIntent = (PublicAccountIntent) intent;
            try {
                QQAppInterface qQAppInterface = (QQAppInterface) super.getAppRuntime();
                c cVar = (c) publicAccountIntent.a();
                cVar.e(qQAppInterface);
                qQAppInterface.addObserver(cVar);
                e.c(qQAppInterface, publicAccountIntent.getBooleanExtra("BUNDLE_PUBLIC_ACCOUNT_IS_FOLLOW", false), publicAccountIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_UIN"), publicAccountIntent.getIntExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", 0));
                packet.setSSOCommand(null);
                return;
            } catch (ClassCastException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f196699d, 2, "ClassCastException e", e16.toString());
                }
                oidb_cmd0xc96$ReqBody oidb_cmd0xc96_reqbody = new oidb_cmd0xc96$ReqBody();
                oidb_cmd0xc96_reqbody.puin.set(Long.parseLong(publicAccountIntent.getStringExtra("BUNDLE_PUBLIC_ACCOUNT_UIN")));
                oidb_cmd0xc96$FollowExt oidb_cmd0xc96_followext = new oidb_cmd0xc96$FollowExt();
                oidb_cmd0xc96_followext.source_from.set(publicAccountIntent.getIntExtra("BUNDLE_PUBLIC_ACCOUNT_SOURCE", 0));
                oidb_cmd0xc96$FollowReq oidb_cmd0xc96_followreq = new oidb_cmd0xc96$FollowReq();
                oidb_cmd0xc96_followreq.ext.set(oidb_cmd0xc96_followext);
                oidb_cmd0xc96_reqbody.follow_req.set(oidb_cmd0xc96_followreq);
                oidb_cmd0xc96_reqbody.cmd_type.set(1);
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.uint32_command.set(3222);
                oidb_sso_oidbssopkg.uint32_result.set(0);
                oidb_sso_oidbssopkg.uint32_service_type.set(0);
                oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_cmd0xc96_reqbody.toByteArray()));
                byte[] byteArray = oidb_sso_oidbssopkg.toByteArray();
                packet.setSSOCommand("OidbSvc.0xc96");
                packet.putSendData(fh.b(byteArray));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.f196699d, 2, "onSend exit");
        }
    }
}
