package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends UploadPicOperator {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public v.a A(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (v.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
        }
        PhotoSendParams photoSendParams = (PhotoSendParams) intent.getParcelableExtra(PeakConstants.PHOTO_SEND_QZONE_PIC_PARAMS);
        if (!L(photoSendParams)) {
            return null;
        }
        v.a A = super.A(intent);
        A.v(null);
        A.w(photoSendParams.rawMd5);
        A.p(photoSendParams.fileSize);
        return A;
    }

    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public v B(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (v) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        }
        v B = super.B(intent);
        PhotoSendParams photoSendParams = (PhotoSendParams) intent.getParcelableExtra(PeakConstants.PHOTO_SEND_QZONE_PIC_PARAMS);
        if (B != null) {
            B.f258830p0 = true;
            B.f258829o0 = photoSendParams;
        }
        return B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    @NotNull
    public TransferRequest D(p pVar, v vVar, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TransferRequest) iPatchRedirector.redirect((short) 7, this, pVar, vVar, messageRecord);
        }
        TransferRequest D = super.D(pVar, vVar, messageRecord);
        if (pVar.f258784e == 1045) {
            D.isQzonePic = vVar.f258830p0;
            D.photoSendParams = vVar.f258829o0;
        }
        return D;
    }

    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    void K(v vVar, MessageForPic messageForPic) {
        PhotoSendParams photoSendParams = vVar.f258829o0;
        messageForPic.width = photoSendParams.rawWidth;
        messageForPic.height = photoSendParams.rawHeight;
        messageForPic.imageType = 1000;
    }

    protected boolean L(PhotoSendParams photoSendParams) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) photoSendParams)).booleanValue();
        }
        if (photoSendParams != null && !TextUtils.isEmpty(photoSendParams.rawMd5) && !TextUtils.isEmpty(photoSendParams.thumbPath) && FileUtils.fileExistsAndNotEmpty(photoSendParams.thumbPath) && !TextUtils.isEmpty(photoSendParams.rawDownloadUrl)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            String str2 = this.f258750e;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("AioQzonePicOperator checkParams:");
            if (photoSendParams != null) {
                str = photoSendParams.toString();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.e(str2, 2, sb5.toString());
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.BasePicOperator
    public void o(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ((IPicHelper) QRoute.api(IPicHelper.class)).getDrawable(messageForPic, 65537, null, null).downloadImediatly();
        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "preload thumb", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    protected void p(MessageForPic messageForPic, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) messageForPic, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    String s(String str) {
        return this.f258751f.C.f258829o0.rawMd5;
    }

    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    protected boolean u(v vVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) vVar)).booleanValue();
        }
        if (vVar != null) {
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "checkPicUploadInfo", "info:" + vVar);
            PhotoSendParams photoSendParams = vVar.f258829o0;
            if (!L(photoSendParams)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("qzone md5 invalid, md5:");
                if (photoSendParams != null) {
                    str = photoSendParams.rawMd5;
                } else {
                    str = "";
                }
                sb5.append(str);
                vVar.a("checkPicInfo", sb5.toString());
                return false;
            }
            int i3 = vVar.f258713h;
            String str2 = vVar.C;
            if ((i3 == 1000 || i3 == 1020 || i3 == 1004) && str2 == null) {
                vVar.a("checkPicInfo", "secondId invalid,uinType:" + i3 + ",secondId:" + str2);
                return false;
            }
            return true;
        }
        com.tencent.mobileqq.pic.f.e(this.f258750e, this.f258749d, "checkPicUploadInfo", "info == null");
        return false;
    }

    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    protected v v(v vVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (v) iPatchRedirector.redirect((short) 6, (Object) this, (Object) vVar);
        }
        CompressInfo compressInfo = new CompressInfo(vVar.f258829o0.thumbPath, 0);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo);
        String str = compressInfo.H;
        if (str != null) {
            vVar.L = str;
            vVar.M = compressInfo.I;
            vVar.N = compressInfo.J;
        }
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pic.operator.UploadPicOperator
    public void w(MessageForPic messageForPic, v vVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageForPic, (Object) vVar);
            return;
        }
        super.w(messageForPic, vVar);
        boolean z16 = vVar.f258830p0;
        messageForPic.isQzonePic = z16;
        String str2 = com.tencent.mobileqq.service.message.i.f286275r;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        messageForPic.saveExtInfoToExtStr(str2, str);
        messageForPic.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286276s, vVar.f258829o0.rawDownloadUrl);
        messageForPic.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286277t, String.valueOf(vVar.f258829o0.fileSize));
    }
}
