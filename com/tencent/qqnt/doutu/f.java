package com.tencent.qqnt.doutu;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.doutu.protocol.Doutu$GetImgInfoReq;
import com.tencent.qqnt.doutu.protocol.Doutu$GetImgInfoRsp;
import com.tencent.qqnt.doutu.protocol.Doutu$ImgInfo;
import com.tencent.qqnt.doutu.protocol.Doutu$ReqBody;
import com.tencent.qqnt.doutu.protocol.Doutu$RspBody;
import com.tencent.qqnt.doutu.protocol.DoutuRecommend$GetImgInfoReq;
import com.tencent.qqnt.doutu.protocol.DoutuRecommend$GetImgInfoRsp;
import com.tencent.qqnt.doutu.protocol.DoutuRecommend$ImgInfo;
import com.tencent.qqnt.doutu.protocol.DoutuRecommend$ReqBody;
import com.tencent.qqnt.doutu.protocol.DoutuRecommend$RspBody;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes24.dex */
public class f extends MSFServlet {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public List<DoutuData> a(List<Doutu$ImgInfo> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, i3);
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Doutu$ImgInfo doutu$ImgInfo : list) {
                DoutuData doutuData = new DoutuData();
                doutuData.picMd5 = doutu$ImgInfo.bytes_pic_md5.get().toStringUtf8();
                doutuData.picSize = doutu$ImgInfo.uint64_pic_size.get();
                doutuData.picHeight = doutu$ImgInfo.uint32_pic_height.get();
                doutuData.picWidth = doutu$ImgInfo.uint32_pic_width.get();
                doutuData.picDownUrl = doutu$ImgInfo.bytes_pic_down_url.get().toStringUtf8();
                doutuData.thumbMd5 = doutu$ImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
                doutuData.thumbSize = doutu$ImgInfo.uint64_thumb_size.get();
                doutuData.thumbHeight = doutu$ImgInfo.uint32_thumb_height.get();
                doutuData.thumbWidth = doutu$ImgInfo.uint32_thumb_width.get();
                doutuData.thumbDownUrl = doutu$ImgInfo.bytes_thumb_down_url.get().toStringUtf8();
                doutuData.suppliersName = doutu$ImgInfo.bytes_source_name.get().toStringUtf8();
                if (i3 > 0) {
                    doutuData.picType = i3;
                }
                arrayList.add(doutuData);
            }
            return arrayList;
        }
        return null;
    }

    public List<DoutuData> b(List<DoutuRecommend$ImgInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (DoutuRecommend$ImgInfo doutuRecommend$ImgInfo : list) {
                DoutuData doutuData = new DoutuData();
                doutuData.picMd5 = doutuRecommend$ImgInfo.bytes_pic_md5.get().toStringUtf8();
                doutuData.picSize = doutuRecommend$ImgInfo.uint64_pic_size.get();
                doutuData.picHeight = doutuRecommend$ImgInfo.uint32_pic_height.get();
                doutuData.picWidth = doutuRecommend$ImgInfo.uint32_pic_width.get();
                doutuData.picDownUrl = doutuRecommend$ImgInfo.bytes_pic_down_url.get().toStringUtf8();
                doutuData.thumbMd5 = doutuRecommend$ImgInfo.bytes_thumb_file_md5.get().toStringUtf8().toUpperCase();
                doutuData.thumbSize = doutuRecommend$ImgInfo.uint64_thumb_size.get();
                doutuData.thumbHeight = doutuRecommend$ImgInfo.uint32_thumb_height.get();
                doutuData.thumbWidth = doutuRecommend$ImgInfo.uint32_thumb_width.get();
                doutuData.thumbDownUrl = doutuRecommend$ImgInfo.bytes_thumb_down_url.get().toStringUtf8();
                doutuData.suppliersName = doutuRecommend$ImgInfo.bytes_source_name.get().toStringUtf8();
                arrayList.add(doutuData);
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0123, code lost:
    
        r7.handleGetDoutuList(false, null);
     */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean isSuccess;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        int i3 = -1;
        int intExtra = intent.getIntExtra("KEY_CMD", -1);
        long longExtra = intent.getLongExtra("key_sequence", 0L);
        if (QLog.isColorLevel()) {
            QLog.i("DoutuServlet", 2, "onReceive, cmd = " + intExtra + ", key:" + longExtra);
        }
        if (fromServiceMsg == null) {
            isSuccess = false;
        } else {
            isSuccess = fromServiceMsg.isSuccess();
        }
        IDoutuService iDoutuService = (IDoutuService) getAppRuntime().getRuntimeService(IDoutuService.class, "");
        if (isSuccess) {
            try {
                byte[] bArr = new byte[r13.getInt() - 4];
                ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
                if (intExtra != 1) {
                    if (intExtra != 5) {
                        if (intExtra == 6) {
                            DoutuRecommend$RspBody doutuRecommend$RspBody = new DoutuRecommend$RspBody();
                            doutuRecommend$RspBody.mergeFrom(bArr);
                            DoutuRecommend$GetImgInfoRsp doutuRecommend$GetImgInfoRsp = doutuRecommend$RspBody.msg_get_imginfo_rsp.get();
                            int i16 = doutuRecommend$GetImgInfoRsp.int32_result.get();
                            if (i16 == 0) {
                                iDoutuService.handleGetRecommendPicList(true, b(doutuRecommend$GetImgInfoRsp.rpt_msg_img_info.get()), longExtra);
                                return;
                            }
                            if (iDoutuService != null) {
                                iDoutuService.handleGetRecommendPicList(false, null, longExtra);
                            }
                            String stringUtf8 = doutuRecommend$GetImgInfoRsp.bytes_fail_msg.get().toStringUtf8();
                            if (QLog.isColorLevel()) {
                                QLog.i("DoutuServlet", 2, "onReceive recommend Failed result:" + i16 + ", errMsg:" + stringUtf8);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("DoutuServlet", 2, "onReceive CMD_REPORT_NEW  success .");
                        return;
                    }
                    return;
                }
                Doutu$RspBody doutu$RspBody = new Doutu$RspBody();
                doutu$RspBody.mergeFrom(bArr);
                Doutu$GetImgInfoRsp doutu$GetImgInfoRsp = doutu$RspBody.msg_get_imginfo_rsp.get();
                int i17 = doutu$GetImgInfoRsp.int32_result.get();
                if (i17 == 0) {
                    List<Doutu$ImgInfo> list = doutu$GetImgInfoRsp.rpt_msg_img_info.get();
                    if (list != null && list.size() != 0) {
                        iDoutuService.handleGetDoutuList(true, a(list, doutu$GetImgInfoRsp.uint32_rsp_type.get()));
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("DoutuServlet", 2, "onReceive: rpt_msg_img_info is null");
                        return;
                    }
                    return;
                }
                if (iDoutuService != null) {
                    iDoutuService.handleGetDoutuList(false, null);
                }
                String stringUtf82 = doutu$GetImgInfoRsp.bytes_fail_msg.get().toStringUtf8();
                if (stringUtf82 == null) {
                    stringUtf82 = "null";
                }
                if (QLog.isColorLevel()) {
                    QLog.i("DoutuServlet", 2, "onReceive : Failed ! result = " + i17 + ", errMsg = " + stringUtf82);
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("DoutuServlet", 2, e16, new Object[0]);
                    return;
                }
                return;
            }
        }
        if (fromServiceMsg != null) {
            i3 = fromServiceMsg.getResultCode();
        }
        if (intExtra != 1) {
            if (intExtra == 6 && iDoutuService != null) {
                iDoutuService.handleGetRecommendPicTimeOut(longExtra);
            }
        } else if (iDoutuService != null) {
            iDoutuService.handleGetDoutuList(false, null);
        }
        if (QLog.isColorLevel()) {
            QLog.i("DoutuServlet", 2, "onReceive : Failed, errCode:" + i3 + ", cmd:" + intExtra);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x020c  */
    @Override // mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSend(Intent intent, Packet packet) {
        byte[] b16;
        String str;
        byte[] bArr;
        String str2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int intExtra = intent.getIntExtra("KEY_CMD", -1);
        if (intExtra != 1) {
            if (intExtra != 5) {
                if (intExtra != 6) {
                    str2 = null;
                    bArr = null;
                } else {
                    DoutuRecommend$GetImgInfoReq doutuRecommend$GetImgInfoReq = new DoutuRecommend$GetImgInfoReq();
                    long longExtra = intent.getLongExtra("KEY_SRC_UIN", 0L);
                    long longExtra2 = intent.getLongExtra("KEY_TO_UIN", 0L);
                    String stringExtra = intent.getStringExtra("KEY_MD5");
                    byte byteExtra = intent.getByteExtra("KEY_AGE", (byte) 0);
                    short shortExtra = intent.getShortExtra("key_gender", (short) 0);
                    String stringExtra2 = intent.getStringExtra("key_url");
                    int intExtra2 = intent.getIntExtra("KEY_SESSION_TYPE", 0);
                    if (QLog.isColorLevel()) {
                        i3 = 2;
                        QLog.i("DoutuServlet", 2, "onSend,CMD_RECOMMEND, srcUin1:" + longExtra + ", md5Str:" + stringExtra + ", age = " + ((int) byteExtra) + ", gender:" + ((int) shortExtra));
                    } else {
                        i3 = 2;
                    }
                    doutuRecommend$GetImgInfoReq.uint64_src_uin.set(longExtra);
                    doutuRecommend$GetImgInfoReq.uint64_to_uin.set(longExtra2);
                    doutuRecommend$GetImgInfoReq.uint32_src_term.set(i3);
                    if (!TextUtils.isEmpty(stringExtra)) {
                        doutuRecommend$GetImgInfoReq.bytes_md5.set(ByteStringMicro.copyFrom(stringExtra.getBytes()));
                    }
                    if (intExtra2 == 1) {
                        doutuRecommend$GetImgInfoReq.chat_type.set(1);
                    } else if (intExtra2 == 2) {
                        doutuRecommend$GetImgInfoReq.chat_type.set(2);
                    } else {
                        doutuRecommend$GetImgInfoReq.chat_type.set(255);
                    }
                    if (!TextUtils.isEmpty(stringExtra2)) {
                        doutuRecommend$GetImgInfoReq.bytes_url.set(ByteStringMicro.copyFrom(stringExtra2.getBytes()));
                    }
                    doutuRecommend$GetImgInfoReq.uin32_gender.set(shortExtra);
                    doutuRecommend$GetImgInfoReq.uint32_age.set(byteExtra);
                    DoutuRecommend$ReqBody doutuRecommend$ReqBody = new DoutuRecommend$ReqBody();
                    doutuRecommend$ReqBody.msg_get_imginfo_req.set(doutuRecommend$GetImgInfoReq);
                    b16 = fh.b(doutuRecommend$ReqBody.toByteArray());
                    packet.setTimeout(3000L);
                    str = "ImageFightRecSvc.GetImage";
                }
            } else {
                bArr = fh.b(intent.getStringExtra("key_report_content").getBytes());
                if (QLog.isColorLevel()) {
                    String stringExtra3 = intent.getStringExtra("key_report_content");
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onSend,CMD_REPORT_NEW, REPORT_CONTENT :");
                    if (stringExtra3 == null) {
                        stringExtra3 = "null";
                    }
                    sb5.append(stringExtra3);
                    QLog.d("DoutuServlet", 2, sb5.toString());
                }
                str2 = "MQInference.CommonReport";
            }
            if (str2 == null && bArr != null) {
                packet.setSSOCommand(str2);
                packet.putSendData(bArr);
                return;
            } else {
                if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DoutuServlet", 2, "exception request!");
                        return;
                    }
                    return;
                }
                throw new RuntimeException("exception happened!");
            }
        }
        Doutu$GetImgInfoReq doutu$GetImgInfoReq = new Doutu$GetImgInfoReq();
        long longExtra3 = intent.getLongExtra("KEY_SRC_UIN", 0L);
        long longExtra4 = intent.getLongExtra("KEY_TO_UIN", 0L);
        int intExtra3 = intent.getIntExtra("KEY_SESSION_TYPE", 0);
        byte byteExtra2 = intent.getByteExtra("KEY_AGE", (byte) 0);
        short shortExtra2 = intent.getShortExtra("key_gender", (short) 0);
        doutu$GetImgInfoReq.uint64_src_uin.set(longExtra3);
        doutu$GetImgInfoReq.uint64_to_uin.set(longExtra4);
        doutu$GetImgInfoReq.uint32_age.set(byteExtra2);
        doutu$GetImgInfoReq.uint32_src_term.set(2);
        doutu$GetImgInfoReq.uin32_gender.set(shortExtra2);
        if (intExtra3 == 1) {
            doutu$GetImgInfoReq.chat_type.set(1);
        } else if (intExtra3 == 2) {
            doutu$GetImgInfoReq.chat_type.set(2);
        } else {
            doutu$GetImgInfoReq.chat_type.set(255);
        }
        if (QLog.isColorLevel()) {
            QLog.i("DoutuServlet", 2, "onSend, CMD_DOU_TU , src_uin = " + longExtra3 + ", age = " + ((int) byteExtra2) + ", gender:" + ((int) shortExtra2) + ", chatType:" + intExtra3 + ", toUin:" + longExtra4);
        }
        Doutu$ReqBody doutu$ReqBody = new Doutu$ReqBody();
        doutu$ReqBody.msg_get_imginfo_req.set(doutu$GetImgInfoReq);
        b16 = fh.b(doutu$ReqBody.toByteArray());
        str = "ImageFight.GetInfo";
        bArr = b16;
        str2 = str;
        if (str2 == null) {
        }
        if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
        }
    }
}
