package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import tencent.im.cs.smartptt.Smartptt$PttUpReq;
import tencent.im.cs.smartptt.Smartptt$ReqBody;

/* loaded from: classes19.dex */
public class SmartPttTranHelper {
    static IPatchRedirector $redirector_;

    /* loaded from: classes19.dex */
    public static class PttSliceInfoBean {
        static IPatchRedirector $redirector_;
        public int chatType;
        public int encodeType;
        public String filePath;
        public boolean isLast;
        public boolean isfirst;
        public String md5;
        public int offset;
        public int vegNum;
        public int vegPos;
        public String voiceId;

        public PttSliceInfoBean() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "PttSliceInfoBean{encodeType=" + this.encodeType + ", isfirst=" + this.isfirst + ", isLast=" + this.isLast + ", voiceId='" + this.voiceId + "', offset=" + this.offset + ", vegPos='" + this.vegPos + "', md5='" + this.md5 + "', chatType='" + this.chatType + "'}";
        }
    }

    public SmartPttTranHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Smartptt$ReqBody getSmartPttReqBody(PttSliceInfoBean pttSliceInfoBean) {
        Smartptt$ReqBody smartptt$ReqBody = new Smartptt$ReqBody();
        smartptt$ReqBody.uint32_sub_cmd.set(3);
        Smartptt$PttUpReq smartptt$PttUpReq = new Smartptt$PttUpReq();
        smartptt$PttUpReq.uint32_bits_per_sample.set(16);
        smartptt$PttUpReq.uint32_voice_file_type.set(1);
        smartptt$PttUpReq.uint32_voice_encode_type.set(pttSliceInfoBean.encodeType);
        smartptt$PttUpReq.uint32_samples_per_sec.set(16000);
        smartptt$PttUpReq.str_voice_id.set(pttSliceInfoBean.voiceId);
        smartptt$PttUpReq.uint32_is_first.set(pttSliceInfoBean.isfirst ? 1 : 0);
        smartptt$PttUpReq.uint32_is_end.set(pttSliceInfoBean.isLast ? 1 : 0);
        smartptt$PttUpReq.uint32_offset.set(pttSliceInfoBean.offset);
        smartptt$PttUpReq.str_Filemd5.set(pttSliceInfoBean.md5);
        smartptt$PttUpReq.uint32_chat_type.set(pttSliceInfoBean.chatType);
        smartptt$PttUpReq.uint32_service_id.set(1);
        smartptt$PttUpReq.uint32_voice_num.set(pttSliceInfoBean.vegNum);
        smartptt$PttUpReq.uint32_voice_offset.set(pttSliceInfoBean.vegPos);
        smartptt$ReqBody.msg_ptt_up_req.set(smartptt$PttUpReq);
        return smartptt$ReqBody;
    }
}
