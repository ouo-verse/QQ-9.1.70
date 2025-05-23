package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.multimsg.api.IMultiMsg;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.pic.operator.multipic.c;
import com.tencent.mobileqq.pic.q;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$NotOnlineImage;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends b implements RichProtoProc.RichProtoCallback {
    static IPatchRedirector $redirector_;
    boolean E;
    MessageRecord F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a extends AsyncTask<Void, Void, Void> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            d dVar = d.this;
            f.b(dVar.f258763e, dVar.f258762d, "uploadNotExistFiles start");
            StringBuilder sb5 = null;
            for (int i3 = 0; i3 < d.this.f258765h.size(); i3++) {
                l lVar = d.this.f258766i.get(i3);
                q qVar = d.this.f258765h.get(i3);
                if (qVar.f258790a == -2) {
                    String p16 = d.this.p(lVar);
                    boolean z16 = true;
                    if (p16 != null) {
                        d dVar2 = d.this;
                        f.c(dVar2.f258763e, dVar2.f258762d, "uploadForwardMultiMsgPics.uploadFiles", "Upload [" + i3 + "]mLocalPath \uff1d " + p16);
                        TransferRequest transferRequest = new TransferRequest();
                        transferRequest.needSendMsg = false;
                        transferRequest.mSelfUin = d.this.f258764f.get().getAccount();
                        d dVar3 = d.this;
                        MessageRecord messageRecord = dVar3.F;
                        transferRequest.mPeerUin = messageRecord.frienduin;
                        transferRequest.mSecondId = messageRecord.senderuin;
                        transferRequest.mUinType = messageRecord.istroop;
                        transferRequest.mFileType = 1;
                        transferRequest.mUniseq = messageRecord.uniseq + i3;
                        ITransFileController iTransFileController = (ITransFileController) dVar3.f258764f.get().getRuntimeService(ITransFileController.class, "");
                        while (iTransFileController.containsProcessor(transferRequest.mPeerUin, transferRequest.mUniseq)) {
                            transferRequest.mUniseq += 100;
                        }
                        transferRequest.mIsUp = true;
                        transferRequest.mBusiType = lVar.f258731f.f258712f;
                        transferRequest.mLocalPath = p16;
                        TransferRequest.PicUpExtraInfo picUpExtraInfo = new TransferRequest.PicUpExtraInfo();
                        int i16 = lVar.f258734m;
                        if (i16 < 0) {
                            picUpExtraInfo.mIsRaw = false;
                        } else {
                            if (i16 != 2) {
                                z16 = false;
                            }
                            picUpExtraInfo.mIsRaw = z16;
                        }
                        transferRequest.mExtraObj = picUpExtraInfo;
                        d dVar4 = d.this;
                        transferRequest.mUpCallBack = new com.tencent.mobileqq.pic.operator.multipic.a(dVar4.f258767m, dVar4.f258764f, i3, p16);
                        ((ITransFileController) d.this.f258764f.get().getRuntimeService(ITransFileController.class, "")).transferAsync(transferRequest);
                    } else {
                        qVar.f258790a = -1;
                        m.a aVar = new m.a();
                        qVar.f258791b = aVar;
                        aVar.f258737b = "Get target pic filepath of [" + i3 + "] failed";
                        int i17 = lVar.f258732h.f258713h;
                        if (i17 != 1 && i17 != 3000) {
                            qVar.f258793d = d.this.h(null, null, i3);
                        } else {
                            qVar.f258793d = d.this.f(null, null, i3);
                        }
                        if (QLog.isColorLevel()) {
                            if (sb5 == null) {
                                sb5 = new StringBuilder();
                            }
                            sb5.append("Upload [");
                            sb5.append(i3);
                            sb5.append("] failed, errDec \uff1d ");
                            sb5.append(qVar.f258791b.f258737b);
                            sb5.append("\n");
                        }
                        d.this.k();
                        if (d.this.i() == 0) {
                            d.this.j();
                        }
                    }
                }
            }
            if (sb5 != null) {
                d dVar5 = d.this;
                f.e(dVar5.f258763e, dVar5.f258762d, "uploadForwardMultiMsgPics.uploadFiles", sb5.toString());
            }
            return null;
        }
    }

    public d(c.a aVar, MessageRecord messageRecord, WeakReference<AppInterface> weakReference) {
        super(aVar, weakReference);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, aVar, messageRecord, weakReference);
        } else {
            this.E = false;
            this.F = messageRecord;
        }
    }

    private boolean n(l lVar) {
        if (lVar != null) {
            f.c(this.f258763e, this.f258762d, "checkFowardPicInfo", "info:" + lVar);
            v vVar = lVar.f258731f;
            if (vVar == null) {
                lVar.a("PicFowardInfo.check", "upInfo == null");
                return false;
            }
            int i3 = vVar.f258713h;
            if ((i3 == 1000 || i3 == 1020 || i3 == 1004) && vVar.C == null) {
                lVar.a("PicFowardInfo.check", "secondId invalid,uinType:" + lVar.f258731f.f258713h + ",secondId:" + lVar.f258731f.C);
                return false;
            }
            if (vVar.Q == -1) {
                lVar.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + lVar.f258731f.Q);
                return false;
            }
            if (p(lVar) != null) {
                return true;
            }
            lVar.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
            return false;
        }
        f.e(this.f258763e, this.f258762d, "checkFowardPicInfo", "info == null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String p(l lVar) {
        boolean z16;
        String str;
        String str2;
        String str3;
        v vVar = lVar.f258731f;
        if (vVar.f258818d0 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (lVar.f258734m >= 0) {
            return vVar.K;
        }
        String str4 = null;
        if (FileUtils.fileExistsAndNotEmpty(vVar.K)) {
            CompressInfo compressInfo = new CompressInfo(lVar.f258731f.K, 0, 1009);
            ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
            str = compressInfo.H;
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + str);
        } else {
            str = null;
        }
        if (str == null) {
            URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(lVar, 1, (String) null);
            if (url != null) {
                str2 = AbsDownloader.getFilePath(url.toString());
            } else {
                str2 = null;
            }
            if (FileUtils.fileExistsAndNotEmpty(str2)) {
                f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + str2);
                return str2;
            }
            if (z16) {
                URL url2 = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(lVar, 131075, (String) null);
                if (url2 != null) {
                    str3 = AbsDownloader.getFilePath(url2.toString());
                } else {
                    str3 = null;
                }
                if (FileUtils.fileExistsAndNotEmpty(str3)) {
                    CompressInfo compressInfo2 = new CompressInfo(str3, 0);
                    compressInfo2.f258515e = 1009;
                    ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo2);
                    str = compressInfo2.H;
                    f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + str);
                }
            }
            if (str == null) {
                URL url3 = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(lVar, 65537, (String) null);
                if (url3 != null) {
                    str4 = AbsDownloader.getFilePath(url3.toString());
                }
                if (FileUtils.fileExistsAndNotEmpty(str4)) {
                    f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + str4);
                    return str4;
                }
                return str;
            }
            return str;
        }
        return str;
    }

    private void u() {
        new a().execute(new Void[0]);
    }

    protected void o(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] need upload [" + i3 + "] pictures");
        }
        boolean z16 = false;
        for (int i16 = 0; i16 < this.f258765h.size(); i16++) {
            l lVar = this.f258766i.get(i16);
            q qVar = this.f258765h.get(i16);
            if (QLog.isColorLevel()) {
                QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + lVar.f258731f.K);
            }
            if (qVar.f258790a == -2 && !n(lVar)) {
                lVar.f258731f.K = ((IMultiMsg) QRoute.api(IMultiMsg.class)).getPicDefaultPath();
                v vVar = lVar.f258731f;
                vVar.J = FileUtils.calcMd5(vVar.K);
                v vVar2 = lVar.f258731f;
                vVar2.f258818d0 = 1;
                vVar2.f258815a0 = 242;
                vVar2.f258816b0 = 192;
                vVar2.f258817c0 = ((IMultiMsg) QRoute.api(IMultiMsg.class)).getPicDefaultSize();
                v vVar3 = lVar.f258731f;
                vVar3.L = vVar3.K;
                vVar3.N = 192;
                vVar3.M = 242;
                lVar.f258732h.J = vVar3.J;
                qVar.f258795f = true;
                if (QLog.isColorLevel()) {
                    QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] miao mIsChange  info.upInfo.localPath =  " + lVar.f258731f.K);
                }
                z16 = true;
            }
        }
        if (z16 && !this.E) {
            this.E = true;
            this.f258767m.doInBackground(new Void[0]);
        } else {
            this.E = false;
            u();
        }
    }

    @Override // com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onBusiProtoResp", "start,remiao:" + this.E);
        if (QLog.isColorLevel() && richProtoResp != null) {
            QLog.d("MultiPicsOperator", 2, "onBusiProtoResp miao size =  [" + richProtoResp.resps.size());
        }
        if (richProtoReq != null && richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                l lVar = this.f258766i.get(i3);
                q qVar = this.f258765h.get(i3);
                RichProto.RichProtoResp.RespCommon respCommon = richProtoResp.resps.get(i3);
                if (respCommon instanceof RichProto.RichProtoResp.C2CPicUpResp) {
                    s(richProtoReq, i3, lVar, qVar, (RichProto.RichProtoResp.C2CPicUpResp) respCommon);
                } else if (respCommon instanceof RichProto.RichProtoResp.GroupPicUpResp) {
                    t(richProtoReq, i3, lVar, qVar, (RichProto.RichProtoResp.GroupPicUpResp) respCommon);
                } else {
                    f.e(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onBusiProtoResp", "Unkown response type[" + i3 + "] " + respCommon.getClass().getSimpleName());
                }
            }
        }
        int i16 = i();
        if (i16 > 0) {
            o(i16);
        } else {
            j();
        }
    }

    protected void s(RichProto.RichProtoReq richProtoReq, int i3, l lVar, q qVar, RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, richProtoReq, Integer.valueOf(i3), lVar, qVar, c2CPicUpResp);
            return;
        }
        f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onBusiProtoResp", "C2CPicUpResp[" + i3 + "]," + c2CPicUpResp.toString());
        if (c2CPicUpResp.result == 0 && c2CPicUpResp.isExist) {
            im_msg_body$NotOnlineImage h16 = h((RichProto.RichProtoReq.PicUpReq) richProtoReq.reqs.get(i3), c2CPicUpResp, i3);
            int i16 = lVar.f258732h.f258713h;
            if (i16 != 1 && i16 != 3000) {
                if (h16 != null) {
                    qVar.f258790a = 0;
                    qVar.f258793d = h16;
                    k();
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + i3 + "] success, picture is exsit");
                        return;
                    }
                    return;
                }
                return;
            }
            f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2CustomFace for [" + i3 + "] ");
            im_msg_body$CustomFace d16 = d(h16);
            if (d16 != null) {
                qVar.f258790a = 0;
                qVar.f258793d = d16;
                k();
                if (QLog.isColorLevel()) {
                    QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + i3 + "] success, picture is exsit");
                }
            }
        }
    }

    protected void t(RichProto.RichProtoReq richProtoReq, int i3, l lVar, q qVar, RichProto.RichProtoResp.GroupPicUpResp groupPicUpResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, richProtoReq, Integer.valueOf(i3), lVar, qVar, groupPicUpResp);
            return;
        }
        f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onBusiProtoResp", "GroupPicUpResp[" + i3 + "]," + groupPicUpResp.toString());
        if (groupPicUpResp.result == 0 && groupPicUpResp.isExist) {
            im_msg_body$CustomFace f16 = f((RichProto.RichProtoReq.PicUpReq) richProtoReq.reqs.get(i3), groupPicUpResp, i3);
            int i16 = lVar.f258732h.f258713h;
            if (i16 != 1 && i16 != 3000) {
                f.c(this.f258763e, this.f258762d, "uploadForwardMultiMsgPics.onBusiProtoResp", "convert2NotOnlineImage for [" + i3 + "] ");
                im_msg_body$NotOnlineImage e16 = e(f16);
                if (e16 != null) {
                    qVar.f258790a = 0;
                    qVar.f258793d = e16;
                    k();
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + i3 + "] success, picture is exsit");
                        return;
                    }
                    return;
                }
                return;
            }
            if (f16 != null) {
                qVar.f258790a = 0;
                qVar.f258793d = f16;
                k();
                if (QLog.isColorLevel()) {
                    QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] upload [" + i3 + "] success, picture is exsit");
                }
            }
        }
    }
}
