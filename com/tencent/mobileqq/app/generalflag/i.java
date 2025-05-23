package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.qzone.album.UploadParam;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i implements IGeneralFlagProvider {
    static IPatchRedirector $redirector_;

    public i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr) {
        if ((messageRecord instanceof MessageForPic) && messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_IS_SYNC_QZONE).equals("1")) {
            generalflags_resvattr.uint32_upload_image_to_qzone_flag.set(1);
            try {
                UploadParam uploadParam = new UploadParam();
                uploadParam.bytes_qzone_albumid.set(ByteStringMicro.copyFromUtf8(messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_ALBUM_ID)));
                uploadParam.uint64_batchid.set(Long.valueOf(messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_ID)).longValue());
                uploadParam.uint32_full_image.set(Integer.valueOf(messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_IS_RAW)).intValue());
                uploadParam.uint64_image_number.set(Long.valueOf(messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_COUNT)).longValue());
                uploadParam.uint64_image_number_index.set(Long.valueOf(messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_PHOTO_INDEX)).longValue());
                generalflags_resvattr.bytes_upload_image_to_qzone_param.set(ByteStringMicro.copyFrom(uploadParam.toByteArray()));
                if (QLog.isColorLevel()) {
                    QLog.d(MessageHandlerUtils.TAG, 2, "general syncQzoneAlbum : albumid = " + messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_ALBUM_ID) + ", batchid = " + messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_ID) + ", isRaw = " + messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_IS_RAW) + ", imgCount = " + messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_BATCH_COUNT) + ", imgIndex = " + messageRecord.getExtInfoFromExtStr(IPicBus.MSG_EXTRA_KEY_QZONE_PHOTO_INDEX));
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.mobileqq.app.generalflag.IGeneralFlagProvider
    public boolean[] getGeneralFlagElemFromMsg(AppInterface appInterface, boolean z16, boolean z17, MessageRecord messageRecord, generalflags$ResvAttr generalflags_resvattr, msg_svc$PbSendMsgReq msg_svc_pbsendmsgreq, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (boolean[]) iPatchRedirector.redirect((short) 2, this, appInterface, Boolean.valueOf(z16), Boolean.valueOf(z17), messageRecord, generalflags_resvattr, msg_svc_pbsendmsgreq, im_msg_body_generalflags);
        }
        a(messageRecord, generalflags_resvattr);
        return new boolean[]{z16, z17};
    }
}
