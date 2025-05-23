package com.tencent.mobileqq.pic;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements RichProtoProc.RichProtoCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f258708d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f258709e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PhotoSendParams f258710f;

        a(String str, String str2, PhotoSendParams photoSendParams) {
            this.f258708d = str;
            this.f258709e = str2;
            this.f258710f = photoSendParams;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, photoSendParams);
            }
        }

        @Override // com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
        public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
                return;
            }
            for (int i16 = 0; i16 < richProtoResp.resps.size(); i16++) {
                RichProto.RichProtoResp.RespCommon respCommon = richProtoResp.resps.get(i16);
                if (respCommon instanceof RichProto.RichProtoResp.GroupPicUpResp) {
                    i3 = ((RichProto.RichProtoResp.GroupPicUpResp) respCommon).result;
                } else if (respCommon instanceof RichProto.RichProtoResp.C2CPicUpResp) {
                    i3 = ((RichProto.RichProtoResp.C2CPicUpResp) respCommon).result;
                } else {
                    i3 = -1;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess request Result, resultCode:" + i3 + ", selfUin:" + this.f258708d + ", friendUin:" + this.f258709e + ", md5:" + this.f258710f.rawMd5 + ", commonInfo:" + respCommon.toString());
                }
            }
        }
    }

    private static void a(String str) {
        if (QLog.isColorLevel()) {
            QLog.e("PicAioQzonePreSendMgr", 2, str);
        }
    }

    public static void b(QQAppInterface qQAppInterface, Bundle bundle) {
        RichProto.RichProtoReq.PicUpReq picUpReq;
        String str;
        if (bundle != null && qQAppInterface != null) {
            bundle.setClassLoader(PhotoSendParams.class.getClassLoader());
            PhotoSendParams photoSendParams = (PhotoSendParams) bundle.getParcelable(PeakConstants.PHOTO_SEND_QZONE_PIC_PARAMS);
            String string = bundle.getString("uin");
            String currentUin = qQAppInterface.getCurrentUin();
            bundle.getString("troop_uin");
            int i3 = bundle.getInt("uintype", 1003);
            if (photoSendParams != null && !TextUtils.isEmpty(photoSendParams.rawMd5) && !TextUtils.isEmpty(photoSendParams.thumbPath) && FileUtils.fileExistsAndNotEmpty(photoSendParams.thumbPath) && !TextUtils.isEmpty(photoSendParams.rawDownloadUrl) && !TextUtils.isEmpty(string)) {
                if (QLog.isColorLevel()) {
                    QLog.i("PicAioQzonePreSendMgr", 2, "picPreSendProcess params friendUin:" + string + ", uinType:" + i3 + ", sendParams:" + photoSendParams.toString());
                }
                RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
                if (i3 != 1 && i3 != 3000) {
                    picUpReq = new RichProto.RichProtoReq.PicUpReq();
                    picUpReq.selfUin = currentUin;
                    picUpReq.peerUin = string;
                    picUpReq.secondUin = currentUin;
                    picUpReq.fileSize = photoSendParams.fileSize;
                    picUpReq.md5 = HexUtil.hexStr2Bytes(photoSendParams.rawMd5);
                    picUpReq.fileName = photoSendParams.rawMd5 + ".jpg";
                    picUpReq.width = photoSendParams.rawWidth;
                    picUpReq.height = photoSendParams.rawHeight;
                    picUpReq.picType = 1000;
                    picUpReq.typeHotPic = 3;
                    picUpReq.transferUrl = photoSendParams.rawDownloadUrl;
                    str = RichProtoProc.C2C_PIC_UP;
                } else {
                    picUpReq = new RichProto.RichProtoReq.PicUpReq();
                    picUpReq.selfUin = currentUin;
                    picUpReq.peerUin = string;
                    picUpReq.secondUin = currentUin;
                    picUpReq.fileSize = photoSendParams.fileSize;
                    picUpReq.md5 = HexUtil.hexStr2Bytes(photoSendParams.rawMd5);
                    picUpReq.fileName = photoSendParams.rawMd5 + ".jpg";
                    picUpReq.width = photoSendParams.rawWidth;
                    picUpReq.height = photoSendParams.rawHeight;
                    picUpReq.picType = 1000;
                    picUpReq.busiType = 1045;
                    picUpReq.uinType = 1;
                    picUpReq.typeHotPic = 3;
                    picUpReq.transferUrl = photoSendParams.rawDownloadUrl;
                    str = RichProtoProc.GRP_PIC_UP;
                }
                if (TextUtils.isEmpty(str)) {
                    a("picPreSendProcess protoKey=null!");
                    return;
                }
                richProtoReq.reqs.add(picUpReq);
                richProtoReq.protoKey = str;
                richProtoReq.protoReqMgr = (IProtoReqManager) qQAppInterface.getRuntimeService(IProtoReqManager.class, "");
                richProtoReq.callback = new a(currentUin, string, photoSendParams);
                RichProtoProc.procRichProtoReq(richProtoReq);
                return;
            }
            a("picPreSendProcess sendParams error, friendUin:" + string);
            return;
        }
        a("picPreSendProcess bundle=null!");
    }
}
