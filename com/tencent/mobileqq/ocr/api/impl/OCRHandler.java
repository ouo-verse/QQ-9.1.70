package com.tencent.mobileqq.ocr.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.c;
import com.tencent.mobileqq.ocr.data.TranslateResult;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.ServerAddr;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.cs.cmd0x6ff.subcmd0x533$HttpAROcrInfo;
import tencent.im.cs.cmd0x6ff.subcmd0x533$HttpCardV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533$HttpClientRequestBodyV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533$HttpDeviceV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533$HttpServerResponseBodyV2;
import tencent.im.cs.cmd0x6ff.subcmd0x533$ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x533$RspBody;
import tencent.im.msg.im_msg_head$Head;
import tencent.im.msg.im_msg_head$HttpConnHead;
import tencent.im.msg.im_msg_head$LoginSig;
import tencent.im.oidb.cmd0x990.oidb_0x990$BatchTranslateReq;
import tencent.im.oidb.cmd0x990.oidb_0x990$BatchTranslateRsp;
import tencent.im.oidb.cmd0x990.oidb_0x990$ReqBody;
import tencent.im.oidb.cmd0x990.oidb_0x990$RspBody;
import tencent.im.oidb.cmd0x990.oidb_0x990$TranslateRsp;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OCRHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final String f254678e;

    /* renamed from: f, reason: collision with root package name */
    public static String f254679f;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f254680h;

    /* renamed from: i, reason: collision with root package name */
    private static int f254681i;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f254682d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class BaseOCRReqBigDataListener implements INetEngineListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Intent f254683d;

        /* renamed from: e, reason: collision with root package name */
        private byte[] f254684e;

        /* renamed from: f, reason: collision with root package name */
        private String f254685f;

        public BaseOCRReqBigDataListener(Intent intent, byte[] bArr, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, OCRHandler.this, intent, bArr, str);
                return;
            }
            this.f254683d = intent;
            this.f254684e = bArr;
            this.f254685f = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) netResp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Q.ocr.OCRHandlerImpl", 2, "BaseOCRReqBigListener.onResp()");
            }
            ThreadManagerV2.post(new Runnable(netResp) { // from class: com.tencent.mobileqq.ocr.api.impl.OCRHandler.BaseOCRReqBigDataListener.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ NetResp f254687d;

                {
                    this.f254687d = netResp;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseOCRReqBigDataListener.this, (Object) netResp);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    byte[] bArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    NetResp netResp2 = this.f254687d;
                    if (netResp2 != null && netResp2.mResult == 0) {
                        i3 = 0;
                    } else {
                        if (netResp2 == null) {
                            if (QLog.isColorLevel()) {
                                QLog.i("Q.ocr.OCRHandlerImpl", 2, "BaseOCRReqBigListener.onResp(), resp is null");
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.i("Q.ocr.OCRHandlerImpl", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.f254687d.mResult + ",mErrCode=" + this.f254687d.mErrCode + ",mHttpCode=" + this.f254687d.mHttpCode + ",mErrDesc=" + this.f254687d.mErrDesc);
                        }
                        i3 = -10;
                    }
                    BaseOCRReqBigDataListener baseOCRReqBigDataListener = BaseOCRReqBigDataListener.this;
                    OCRHandler oCRHandler = OCRHandler.this;
                    Intent intent = baseOCRReqBigDataListener.f254683d;
                    NetResp netResp3 = this.f254687d;
                    if (netResp3 != null) {
                        bArr = netResp3.mRespData;
                    } else {
                        bArr = null;
                    }
                    oCRHandler.I2(i3, intent, bArr, BaseOCRReqBigDataListener.this.f254684e);
                }
            }, 8, null, true);
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18167);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        f254678e = OCRHandler.class.getName();
        f254679f = "OidbSvc.0x990";
        f254680h = false;
        f254681i = 0;
    }

    public OCRHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f254682d = appInterface;
        }
    }

    private static int G2() {
        int i3 = f254681i;
        f254681i = i3 + 1;
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList arrayList;
        int i3;
        Object[] objArr;
        int size;
        int size2;
        ArrayList arrayList2;
        List<ByteStringMicro> list;
        List<ByteStringMicro> list2;
        oidb_0x990$RspBody oidb_0x990_rspbody = new oidb_0x990$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x990_rspbody);
        ArrayList arrayList3 = null;
        String str = "";
        if (parseOIDBPkg == 0 && oidb_0x990_rspbody.msg_batch_translate_rsp.has()) {
            oidb_0x990$BatchTranslateRsp oidb_0x990_batchtranslatersp = oidb_0x990_rspbody.msg_batch_translate_rsp.get();
            if (oidb_0x990_batchtranslatersp != null) {
                i3 = oidb_0x990_batchtranslatersp.int32_error_code.get();
                if (i3 == 0) {
                    if (oidb_0x990_batchtranslatersp.rpt_src_bytes_text_list.has() && (list2 = oidb_0x990_batchtranslatersp.rpt_src_bytes_text_list.get()) != null && list2.size() > 0) {
                        arrayList2 = new ArrayList();
                        Iterator<ByteStringMicro> it = list2.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(it.next().toStringUtf8());
                        }
                    } else {
                        arrayList2 = null;
                    }
                    if (oidb_0x990_batchtranslatersp.rpt_dst_bytes_text_list.has() && (list = oidb_0x990_batchtranslatersp.rpt_dst_bytes_text_list.get()) != null && list.size() > 0) {
                        arrayList3 = new ArrayList();
                        Iterator<ByteStringMicro> it5 = list.iterator();
                        while (it5.hasNext()) {
                            arrayList3.add(it5.next().toStringUtf8());
                        }
                    }
                    arrayList = arrayList3;
                    arrayList3 = arrayList2;
                } else {
                    if (oidb_0x990_batchtranslatersp.bytes_error_msg.has()) {
                        str = oidb_0x990_batchtranslatersp.bytes_error_msg.get().toStringUtf8();
                    }
                    QLog.d("Q.ocr.OCRHandlerImpl", 1, "handleBatchTranslateResp translate error, errCode: %s, errMsg: %s", Integer.valueOf(i3), str);
                    arrayList = null;
                }
                if (QLog.isColorLevel()) {
                    if (arrayList3 == null) {
                        size = 0;
                    } else {
                        size = arrayList3.size();
                    }
                    if (arrayList == null) {
                        size2 = 0;
                    } else {
                        size2 = arrayList.size();
                    }
                    QLog.d("Q.ocr.OCRHandlerImpl", 2, String.format("handleBatchTranslateResp, result: %s, errCode: %s, errMsg: %s, scrTextSize: %s, dstTextSize: %s", Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3), str, Integer.valueOf(size), Integer.valueOf(size2)));
                }
                objArr = new Object[2];
                objArr[0] = 1;
                if (arrayList3 == null && arrayList != null) {
                    String string = toServiceMsg.extraData.getString("param_translate_src_lang");
                    String string2 = toServiceMsg.extraData.getString("param_translate_dst_lang");
                    TranslateResult translateResult = new TranslateResult(1);
                    translateResult.k(string, string2, arrayList3, arrayList);
                    objArr[1] = translateResult;
                    notifyUI(2, true, objArr);
                    return;
                }
                notifyUI(2, false, objArr);
            }
        } else {
            QLog.d("Q.ocr.OCRHandlerImpl", 1, String.format("handleBatchTranslateResp parse error, result: %s", Integer.valueOf(parseOIDBPkg)));
        }
        arrayList = null;
        i3 = 0;
        if (QLog.isColorLevel()) {
        }
        objArr = new Object[2];
        objArr[0] = 1;
        if (arrayList3 == null) {
        }
        notifyUI(2, false, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I2(int i3, Intent intent, byte[] bArr, byte[] bArr2) {
        long longExtra = intent.getLongExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0L);
        if (QLog.isColorLevel()) {
            QLog.i("Q.ocr.OCRHandlerImpl", 2, "handleReqBigDataRsp, errorCode=" + i3);
        }
        byte[] bArr3 = null;
        if (i3 == 0) {
            try {
                int length = bArr.length;
                if (bArr[0] == 40 && bArr[length - 1] == 41) {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
                    dataInputStream.readByte();
                    int readInt = dataInputStream.readInt();
                    int readInt2 = dataInputStream.readInt();
                    if (readInt <= length && readInt2 <= length) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Q.ocr.OCRHandlerImpl", 2, "handleReqBigDataRsp | headLen=" + readInt + " | bodyLen=" + readInt2);
                        }
                        if (readInt > 0) {
                            byte[] bArr4 = new byte[readInt];
                            dataInputStream.read(bArr4);
                            im_msg_head$Head im_msg_head_head = new im_msg_head$Head();
                            im_msg_head_head.mergeFrom(bArr4);
                            im_msg_head$HttpConnHead im_msg_head_httpconnhead = im_msg_head_head.msg_httpconn_head.get();
                            int i16 = im_msg_head_httpconnhead.uint32_error_code.get();
                            if (QLog.isDevelopLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("handleReqBigData,  RspHttpConnHead=");
                                sb5.append("uint64_uin=" + im_msg_head_httpconnhead.uint64_uin.get() + ", uint32_command=" + im_msg_head_httpconnhead.uint32_command.get() + ", uint32_sub_command=" + im_msg_head_httpconnhead.uint32_sub_command.get() + ", uint32_seq=" + im_msg_head_httpconnhead.uint32_seq.get() + ", uint32_version=" + im_msg_head_httpconnhead.uint32_version.get() + ", uint32_retry_times=" + im_msg_head_httpconnhead.uint32_retry_times.get() + ", uint32_client_type=" + im_msg_head_httpconnhead.uint32_client_type.get() + ", uint32_pub_no=" + im_msg_head_httpconnhead.uint32_pub_no.get() + ", uint32_local_id=" + im_msg_head_httpconnhead.uint32_local_id.get() + ", uint32_time_zone=" + im_msg_head_httpconnhead.uint32_time_zone.get() + ", uint32_client_ip=" + im_msg_head_httpconnhead.uint32_client_ip.get() + ", uint32_client_port=" + im_msg_head_httpconnhead.uint32_client_port.get() + ", uint32_qzhttp_ip=" + im_msg_head_httpconnhead.uint32_qzhttp_ip.get() + ", uint32_qzhttp_port=" + im_msg_head_httpconnhead.uint32_qzhttp_port.get() + ", uint32_spp_ip=" + im_msg_head_httpconnhead.uint32_spp_ip.get() + ", uint32_spp_port=" + im_msg_head_httpconnhead.uint32_spp_port.get() + ", uint32_flag=" + im_msg_head_httpconnhead.uint32_flag.get() + ", bytes_key=" + im_msg_head_httpconnhead.bytes_key.get() + ", uint32_compress_type=" + im_msg_head_httpconnhead.uint32_compress_type.get() + ", uint32_origin_size=" + im_msg_head_httpconnhead.uint32_origin_size.get() + ", uint32_error_code=" + im_msg_head_httpconnhead.uint32_error_code.get() + ", uint32_command_id=" + im_msg_head_httpconnhead.uint32_command_id.get() + ", uint32_service_cmdid=" + im_msg_head_httpconnhead.uint32_service_cmdid.get());
                                QLog.i("Q.ocr.OCRHandlerImpl", 4, sb5.toString());
                            }
                            i3 = i16;
                        }
                        if (readInt2 > 0 && i3 == 0) {
                            byte[] bArr5 = new byte[readInt2];
                            dataInputStream.read(bArr5);
                            bArr3 = new Cryptor().decrypt(bArr5, bArr2);
                        }
                    }
                    I2(-2, intent, null, null);
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.ocr.OCRHandlerImpl", 2, "handleReqBigDataRsp error, unexpected length, headLen=" + readInt + ", bodyLen=" + readInt2);
                        return;
                    }
                    return;
                }
                String obj = bArr.toString();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("unexpected body data, len=" + length + ", data=");
                if (obj.length() > 20) {
                    obj = obj.substring(0, 20);
                }
                sb6.append(obj);
                String sb7 = sb6.toString();
                I2(-2, intent, null, null);
                if (QLog.isColorLevel()) {
                    QLog.e("Q.ocr.OCRHandlerImpl", 2, "handleReqBigDataRsp error, errorMsg=" + sb7);
                    return;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.ocr.OCRHandlerImpl", 2, "handleReqBigDataRsp error", e16);
                }
                i3 = -10;
            }
        }
        if (longExtra == 2) {
            J2(i3, intent, bArr3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void J2(int i3, Intent intent, byte[] bArr) {
        String str;
        int i16;
        int i17;
        int i18;
        boolean z16;
        boolean z17;
        String str2;
        ArrayList arrayList = null;
        long j3 = 0;
        if (intent != null) {
            str = intent.getStringExtra("param_sougou_sessionid");
            j3 = intent.getLongExtra("param_starttime", 0L);
        } else {
            str = null;
        }
        int i19 = 1;
        int i26 = 0;
        if (i3 == 0) {
            try {
                subcmd0x533$RspBody subcmd0x533_rspbody = new subcmd0x533$RspBody();
                subcmd0x533_rspbody.mergeFrom(bArr);
                subcmd0x533$HttpServerResponseBodyV2 subcmd0x533_httpserverresponsebodyv2 = subcmd0x533_rspbody.msg_ocr_result.get().msg_sougou_rsp.get();
                i17 = -1;
                if (subcmd0x533_httpserverresponsebodyv2.has()) {
                    i16 = subcmd0x533_httpserverresponsebodyv2.int32_tencent_errorcode.get();
                } else {
                    i16 = -1;
                }
                try {
                    if (subcmd0x533_httpserverresponsebodyv2.has()) {
                        i17 = subcmd0x533_httpserverresponsebodyv2.int32_sougou_errorcode.get();
                    }
                    try {
                        if (i16 == 0 && i17 == 0) {
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                Iterator<subcmd0x533$HttpCardV2> it = subcmd0x533_httpserverresponsebodyv2.rpt_msg_cards.get().iterator();
                                while (it.hasNext()) {
                                    OCRTextSearchInfo.SougouSearchInfo a16 = OCRTextSearchInfo.a(it.next().rpt_msg_card_properties.get());
                                    if (!TextUtils.isEmpty(a16.title) || !TextUtils.isEmpty(a16.abstractStr)) {
                                        arrayList2.add(a16);
                                        if (QLog.isColorLevel()) {
                                            QLog.d("Q.ocr.OCRHandlerImpl", 2, "handleSougouReqBigDataRsp info, " + a16);
                                        }
                                    }
                                }
                                i18 = arrayList2.size();
                                arrayList = arrayList2;
                                z17 = true;
                            } catch (Exception e16) {
                                e = e16;
                                arrayList = arrayList2;
                                if (QLog.isColorLevel()) {
                                    QLog.e("Q.ocr.OCRHandlerImpl", 2, "handleSougouReqBigDataRsp error", e);
                                }
                                i18 = 0;
                                z16 = false;
                                notifyUI(1, z16, new Object[]{str, arrayList});
                                if (i3 == 0) {
                                }
                                HashMap<String, String> hashMap = new HashMap<>();
                                long elapsedRealtime = SystemClock.elapsedRealtime() - j3;
                                hashMap.put("interval_time", String.valueOf(elapsedRealtime));
                                if (i26 != 0) {
                                }
                                hashMap.put("param_FailCode", str2);
                                hashMap.put("failReason", Integer.toString(i26));
                                hashMap.put("errCodeType", Integer.toString(i19));
                                boolean z18 = z16;
                                StatisticCollector.getInstance(this.f254682d.getApplication()).collectPerformance(this.f254682d.getCurrentAccountUin(), "ocrTextSearch", z18, elapsedRealtime, 0L, hashMap, "");
                                if (!QLog.isColorLevel()) {
                                }
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.ocr.OCRHandlerImpl", 2, "handleSougouReqBigDataRsp error, tencentCode=" + i16 + ",sougouErrCode=" + i17 + ",tencentDes=" + subcmd0x533_httpserverresponsebodyv2.string_tencent_errormsg.get() + ",sougouErrDes=" + subcmd0x533_httpserverresponsebodyv2.string_sougou_errormsg.get());
                            }
                            i18 = 0;
                            z17 = false;
                        }
                        z16 = z17;
                    } catch (Exception e17) {
                        e = e17;
                    }
                } catch (Exception e18) {
                    e = e18;
                    i17 = 0;
                }
            } catch (Exception e19) {
                e = e19;
                i16 = 0;
                i17 = 0;
            }
        } else {
            i18 = 0;
            i16 = 0;
            i17 = 0;
            z16 = false;
        }
        notifyUI(1, z16, new Object[]{str, arrayList});
        if (i3 == 0) {
            i26 = i3;
        } else if (i16 != 0) {
            i19 = 2;
            i26 = i16;
        } else if (i17 != 0) {
            i19 = 3;
            i26 = i17;
        } else {
            i19 = 0;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - j3;
        hashMap2.put("interval_time", String.valueOf(elapsedRealtime2));
        if (i26 != 0) {
            str2 = Integer.toString(i26);
        } else {
            str2 = i19 + "_" + i26;
        }
        hashMap2.put("param_FailCode", str2);
        hashMap2.put("failReason", Integer.toString(i26));
        hashMap2.put("errCodeType", Integer.toString(i19));
        boolean z182 = z16;
        StatisticCollector.getInstance(this.f254682d.getApplication()).collectPerformance(this.f254682d.getCurrentAccountUin(), "ocrTextSearch", z182, elapsedRealtime2, 0L, hashMap2, "");
        if (!QLog.isColorLevel()) {
            QLog.d("Q.ocr.OCRHandlerImpl", 2, "handleSougouReqBigDataRsp,errCode:" + i3 + ", isSucc:" + z182 + ", failCodeStr:" + str2 + ", size=" + i18);
        }
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        oidb_0x990$RspBody oidb_0x990_rspbody = new oidb_0x990$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x990_rspbody);
        String str = "";
        if (parseOIDBPkg == 0 && oidb_0x990_rspbody.msg_translate_rsp.has()) {
            oidb_0x990$TranslateRsp oidb_0x990_translatersp = oidb_0x990_rspbody.msg_translate_rsp.get();
            i3 = oidb_0x990_translatersp.int32_ret_code.get();
            if (i3 == 0) {
                if (oidb_0x990_translatersp.bytes_trans_result.has()) {
                    str = oidb_0x990_translatersp.bytes_trans_result.get().toStringUtf8();
                }
            } else {
                QLog.d("Q.ocr.OCRHandlerImpl", 1, String.format("handleTranslateResp, errCode: %s", Integer.valueOf(i3)));
            }
        } else {
            QLog.d("Q.ocr.OCRHandlerImpl", 1, String.format("handleBatchTranslateResp parse error, result: %s", Integer.valueOf(parseOIDBPkg)));
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.OCRHandlerImpl", 2, String.format("handleTranslateResp, result: %s, errCode: %s, translateResult: %s", Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3), str));
        }
        Object[] objArr = new Object[2];
        objArr[0] = 0;
        if (parseOIDBPkg == 0 && i3 == 0) {
            TranslateResult translateResult = new TranslateResult(0);
            translateResult.l(toServiceMsg.extraData.getString("param_translate_src_lang"), toServiceMsg.extraData.getString("param_translate_dst_lang"), toServiceMsg.extraData.getString("param_translate_src_text"), str);
            objArr[1] = translateResult;
            notifyUI(2, true, objArr);
            return;
        }
        notifyUI(2, false, objArr);
    }

    private void L2(Intent intent) {
        boolean z16;
        long longExtra = intent.getLongExtra("param_uin", 0L);
        byte[] byteArrayExtra = intent.getByteArrayExtra("param_reqbody");
        long longExtra2 = intent.getLongExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0L);
        if (longExtra != 0 && byteArrayExtra != null) {
            String str = "";
            ArrayList arrayList = new ArrayList();
            ConfigManager configManager = ConfigManager.getInstance(this.f254682d.getApp().getBaseContext(), this.f254682d.getHwEngine());
            boolean z17 = true;
            if (configManager != null) {
                List<EndPoint> otherTypeIp = configManager.getOtherTypeIp(this.f254682d.getApp().getBaseContext(), 21, false);
                if (otherTypeIp != null && otherTypeIp.size() > 0) {
                    EndPoint endPoint = otherTypeIp.get(0);
                    str = "https://" + endPoint.host + ":" + endPoint.port + "/";
                }
                if (otherTypeIp != null && otherTypeIp.size() > 1) {
                    for (int i3 = 1; i3 < otherTypeIp.size(); i3++) {
                        EndPoint endPoint2 = otherTypeIp.get(i3);
                        ServerAddr serverAddr = new ServerAddr();
                        serverAddr.mIp = endPoint2.host;
                        serverAddr.port = endPoint2.port;
                        arrayList.add(serverAddr);
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = "https://sslv6.htdata.qq.com/";
            }
            byte[] sessionKey = SessionInfo.getInstance(getCurrentAccountUin()).getSessionKey();
            byte[] httpconn_sig_session = SessionInfo.getInstance(getCurrentAccountUin()).getHttpconn_sig_session();
            if (sessionKey == null || httpconn_sig_session == null) {
                synchronized (SessionInfo.class) {
                    if (SessionInfo.getInstance(this.f254682d.getCurrentUin()).getHttpconn_sig_session() != null) {
                        int length = SessionInfo.getInstance(this.f254682d.getCurrentUin()).getHttpconn_sig_session().length;
                        byte[] bArr = new byte[length];
                        System.arraycopy(SessionInfo.getInstance(this.f254682d.getCurrentUin()).getHttpconn_sig_session(), 0, bArr, 0, length);
                        httpconn_sig_session = bArr;
                    }
                    if (SessionInfo.getInstance(this.f254682d.getCurrentUin()).getSessionKey() != null) {
                        int length2 = SessionInfo.getInstance(this.f254682d.getCurrentUin()).getSessionKey().length;
                        byte[] bArr2 = new byte[length2];
                        System.arraycopy(SessionInfo.getInstance(this.f254682d.getCurrentUin()).getSessionKey(), 0, bArr2, 0, length2);
                        sessionKey = bArr2;
                    }
                }
            }
            if (sessionKey != null && !TextUtils.isEmpty(str) && httpconn_sig_session != null) {
                byte[] encrypt = new Cryptor().encrypt(byteArrayExtra, sessionKey);
                im_msg_head$Head im_msg_head_head = new im_msg_head$Head();
                im_msg_head_head.uint32_head_type.set(4);
                im_msg_head$LoginSig im_msg_head_loginsig = new im_msg_head$LoginSig();
                im_msg_head_loginsig.uint32_type.set(22);
                im_msg_head_loginsig.bytes_sig.set(ByteStringMicro.copyFrom(httpconn_sig_session));
                im_msg_head_head.msg_login_sig.set(im_msg_head_loginsig);
                im_msg_head$HttpConnHead im_msg_head_httpconnhead = new im_msg_head$HttpConnHead();
                im_msg_head_httpconnhead.uint64_uin.set(longExtra);
                im_msg_head_httpconnhead.uint32_command.set(1791);
                im_msg_head_httpconnhead.uint32_sub_command.set(gdt_analysis_event.CONFIG_REPORT_FOR_MSG);
                im_msg_head_httpconnhead.uint32_seq.set(G2());
                im_msg_head_httpconnhead.uint32_version.set(g.P1);
                im_msg_head_httpconnhead.uint32_flag.set(1);
                im_msg_head_httpconnhead.uint32_compress_type.set(0);
                im_msg_head_httpconnhead.uint32_error_code.set(0);
                im_msg_head_head.msg_httpconn_head.set(im_msg_head_httpconnhead);
                byte[] byteArray = im_msg_head_head.toByteArray();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.write(40);
                    dataOutputStream.writeInt(byteArray.length);
                    dataOutputStream.writeInt(encrypt.length);
                    dataOutputStream.write(byteArray);
                    dataOutputStream.write(encrypt);
                    dataOutputStream.write(41);
                    dataOutputStream.flush();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.ocr.OCRHandlerImpl", 2, "reqSouggouSearchBigData", e16);
                    }
                    I2(-10, intent, null, null);
                }
                String str2 = str + "cgi-bin/httpconn";
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                HttpNetReq httpNetReq = new HttpNetReq();
                httpNetReq.mSendData = byteArray2;
                httpNetReq.mCallback = new BaseOCRReqBigDataListener(intent, sessionKey, str);
                httpNetReq.mReqUrl = str2;
                httpNetReq.mHttpMethod = 1;
                httpNetReq.mFileType = 57;
                httpNetReq.mReqProperties.put("Accept-Encoding", "identity");
                httpNetReq.mContinuErrorLimit = 2;
                httpNetReq.mExcuteTimeLimit = 30000L;
                httpNetReq.mIsHttps = true;
                httpNetReq.mIsHostIP = true;
                httpNetReq.mHostForHttpsVerify = "sslv6.htdata.qq.com";
                if (!arrayList.isEmpty()) {
                    httpNetReq.mServerList = arrayList;
                }
                AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                if (waitAppRuntime instanceof AppInterface) {
                    ((IHttpEngineService) ((AppInterface) waitAppRuntime).getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.ocr.OCRHandlerImpl", 2, "reqSouggouSearchBigData send");
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("Q.ocr.OCRHandlerImpl", 2, "reqSouggouSearchBigData start, uin=" + longExtra + ",subType=" + longExtra2 + JefsClass.INDEX_URL + str2 + ",testserver=" + f254680h);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("reqSouggouSearchBigData, host=");
                sb5.append(str);
                sb5.append(",bkeyIsNull=");
                if (sessionKey == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(",bSignIsNull=");
                if (httpconn_sig_session != null) {
                    z17 = false;
                }
                sb5.append(z17);
                QLog.i("Q.ocr.OCRHandlerImpl", 2, sb5.toString());
            }
            I2(-1, intent, null, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.ocr.OCRHandlerImpl", 2, "reqSouggouSearchBigData, uin or reqBody is null");
        }
    }

    public void E2(List<String> list, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, list, str, str2);
            return;
        }
        oidb_0x990$ReqBody oidb_0x990_reqbody = new oidb_0x990$ReqBody();
        oidb_0x990$BatchTranslateReq oidb_0x990_batchtranslatereq = new oidb_0x990$BatchTranslateReq();
        if (list != null && list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                oidb_0x990_batchtranslatereq.rpt_src_bytes_text_list.add(ByteStringMicro.copyFromUtf8(it.next()));
            }
        }
        if (!TextUtils.isEmpty(str)) {
            oidb_0x990_batchtranslatereq.str_src_language.set(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            oidb_0x990_batchtranslatereq.str_dst_language.set(str2);
        }
        oidb_0x990_reqbody.msg_batch_translate_req.set(oidb_0x990_batchtranslatereq);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(f254679f, 2448, 2, oidb_0x990_reqbody.toByteArray());
        makeOIDBPkg.extraData.putInt("param_translate_type", 2);
        makeOIDBPkg.extraData.putString("param_translate_src_lang", str);
        makeOIDBPkg.extraData.putString("param_translate_dst_lang", str2);
        sendPbReq(makeOIDBPkg);
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.OCRHandlerImpl", 2, String.format("batchTranslate, srcLang: %s, dstLang: %s", str, str2));
        }
    }

    public void F2(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.ocr.OCRHandlerImpl", 2, "doSougouSearch start, sessionId=" + str);
        }
        subcmd0x533$HttpClientRequestBodyV2 subcmd0x533_httpclientrequestbodyv2 = new subcmd0x533$HttpClientRequestBodyV2();
        subcmd0x533$HttpDeviceV2 subcmd0x533_httpdevicev2 = new subcmd0x533$HttpDeviceV2();
        subcmd0x533_httpdevicev2.platform.set(1);
        subcmd0x533_httpclientrequestbodyv2.msg_device.set(subcmd0x533_httpdevicev2);
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str2);
        subcmd0x533_httpclientrequestbodyv2.rpt_string_sentences.set(arrayList);
        subcmd0x533_httpclientrequestbodyv2.uint32_timeout_ms.set(3000);
        subcmd0x533$HttpAROcrInfo subcmd0x533_httparocrinfo = new subcmd0x533$HttpAROcrInfo();
        subcmd0x533_httparocrinfo.uint64_ocr_recog_type.set(2L);
        subcmd0x533_httparocrinfo.msg_sougou_req.set(subcmd0x533_httpclientrequestbodyv2);
        subcmd0x533$ReqBody subcmd0x533_reqbody = new subcmd0x533$ReqBody();
        subcmd0x533_reqbody.string_session_id.set(str);
        subcmd0x533_reqbody.uint64_req_recog_type.set(16L);
        subcmd0x533_reqbody.uint32_business_type.set(0);
        subcmd0x533_reqbody.string_clt_version.set(String.valueOf(AppSetting.f()));
        subcmd0x533_reqbody.msg_ocr_info.set(subcmd0x533_httparocrinfo);
        Intent intent = new Intent();
        intent.putExtra("param_uin", Long.parseLong(this.f254682d.getCurrentAccountUin()));
        intent.putExtra("param_reqbody", subcmd0x533_reqbody.toByteArray());
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 2L);
        intent.putExtra("param_sougou_sessionid", str);
        intent.putExtra("param_starttime", j3);
        L2(intent);
    }

    public void batchTranslate(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("Q.ocr.OCRHandlerImpl", 1, "batchTranslate, texts is empty!");
            return;
        }
        String[] split = str.split("\n");
        ArrayList arrayList = new ArrayList();
        if (split != null && split.length > 0) {
            for (String str4 : split) {
                if (!TextUtils.isEmpty(str4.trim().replace("\n", ""))) {
                    arrayList.add(str4);
                }
            }
        }
        if (arrayList.size() > 0) {
            E2(arrayList, str2, str3);
        } else {
            QLog.d("Q.ocr.OCRHandlerImpl", 1, "batchTranslate, srcTextList is empty!");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(f254679f);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String string = toServiceMsg.extraData.getString("friendUin");
        if (string == null) {
            string = fromServiceMsg.getUin();
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        new Bundle().putString("uin", string);
        if (f254679f.equals(fromServiceMsg.getServiceCmd())) {
            int i3 = toServiceMsg.extraData.getInt("param_translate_type");
            if (i3 == 1) {
                K2(toServiceMsg, fromServiceMsg, obj);
            } else if (i3 == 2) {
                H2(toServiceMsg, fromServiceMsg, obj);
            } else {
                QLog.e("Q.ocr.OCRHandlerImpl", 1, String.format("onReceive, cmd = OidbSvc.0x990, serviceType error: %s", Integer.valueOf(i3)));
            }
        }
    }
}
