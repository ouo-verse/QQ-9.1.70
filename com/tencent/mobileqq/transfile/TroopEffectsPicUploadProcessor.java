package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body$CustomFace;

/* loaded from: classes19.dex */
public class TroopEffectsPicUploadProcessor extends GroupPicUploadProcessor {
    static IPatchRedirector $redirector_;
    public im_msg_body$CustomFace customFace;

    public TroopEffectsPicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    protected void constructCustomFace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        im_msg_body$CustomFace im_msg_body_customface = new im_msg_body$CustomFace();
        im_msg_body_customface.uint32_file_id.set((int) this.mFileID);
        ArrayList<ServerAddr> arrayList = this.mIpList;
        if (arrayList != null && arrayList.size() > 0) {
            ServerAddr serverAddr = this.mIpList.get(0);
            im_msg_body_customface.uint32_server_ip.set(BaseUploadProcessor.ipToLong(serverAddr.mIp));
            im_msg_body_customface.uint32_server_port.set(serverAddr.port);
        }
        Integer num = 66;
        im_msg_body_customface.uint32_file_type.set(num.intValue());
        im_msg_body_customface.uint32_useful.set(1);
        SigInfo.fillCustomFaceSessionKey(this.app, im_msg_body_customface);
        im_msg_body_customface.bytes_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        im_msg_body_customface.str_file_path.set(this.mFileName);
        im_msg_body_customface.uint32_origin.set(this.mIsRawPic ? 1 : 0);
        im_msg_body_customface.uint32_width.set(this.mWidth);
        im_msg_body_customface.uint32_height.set(this.mHeight);
        im_msg_body_customface.uint32_size.set((int) this.mFileSize);
        im_msg_body_customface.uint32_source.set(200);
        this.customFace = im_msg_body_customface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    public void sendMsg() {
        if (this.mUiRequest.mUpCallBack != null) {
            constructCustomFace();
            ad.a aVar = new ad.a();
            aVar.f258601e = this.mFileSize;
            aVar.f258603g = this.mMd5Str;
            aVar.f258602f = this.mFileName;
            TransferRequest transferRequest = this.mUiRequest;
            aVar.f258600d = transferRequest.mLocalPath;
            aVar.f258604h = this.mFileID;
            aVar.f258608l = this.customFace;
            transferRequest.mUpCallBack.q(aVar);
            doReport(true);
        }
    }
}
