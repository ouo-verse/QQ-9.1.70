package com.tencent.mobileqq.profile.PersonalityLabel;

import android.annotation.TargetApi;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.profilecard.api.IProfileKoiLikeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.label.comm.PersonalityTagComm$LabelInfo;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0$ReqBody;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0$RspBody;
import tencent.im.oidb.cmd0x8f1.oidb_0x8f1$ReqBody;
import tencent.im.oidb.cmd0x8f1.oidb_0x8f1$RspBody;
import tencent.im.oidb.cmd0x8f3.oidb_0x8f3$ReqBody;
import tencent.im.oidb.cmd0x909.oidb_0x909$ReqBody;
import tencent.im.oidb.cmd0x90c.oidb_0x90c$ReqBody;
import tencent.im.oidb.cmd0x90c.oidb_0x90c$RspBody;
import tencent.im.oidb.cmd0x91d.cmd0x91d$LabelUpdateInfo;
import tencent.im.oidb.cmd0x91d.cmd0x91d$RspBody;

/* loaded from: classes16.dex */
public class PersonalityLabelHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f259896d;

    public PersonalityLabelHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f259896d = qQAppInterface;
        }
    }

    private void H2() {
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "handleDeleteLabel");
        }
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        if (toServiceMsg != null && fromServiceMsg != null) {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_0x90c$RspBody>() { // from class: tencent.im.oidb.cmd0x90c.oidb_0x90c$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x90c$RspBody.class);
            });
            String string = toServiceMsg.extraData.getString("key_uin", "");
            long j3 = toServiceMsg.extraData.getLong("label_id", 0L);
            long j16 = toServiceMsg.extraData.getLong("photo_id", 0L);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleDeletePhoto, result==0 ");
                if (parseOIDBPkg == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append(",");
                sb5.append(string);
                sb5.append(",");
                sb5.append(j16);
                sb5.append(",");
                sb5.append(j3);
                QLog.i("PersonalityLabelHandler", 2, sb5.toString());
            }
            if (parseOIDBPkg == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            notifyUI(4, z16, new Object[]{string, Long.valueOf(j3), Long.valueOf(j16)});
            return;
        }
        notifyUI(4, false, null);
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            oidb_0x8f1$RspBody oidb_0x8f1_rspbody = new oidb_0x8f1$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x8f1_rspbody);
            String string = toServiceMsg.extraData.getString("key_uin", "");
            long j3 = toServiceMsg.extraData.getLong("label_id", 0L);
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelPhotos : result = " + parseOIDBPkg + ", uin = " + string);
            }
            if (parseOIDBPkg == 0) {
                notifyUI(3, true, new Object[]{string, Long.valueOf(j3), PersonalityLabelInfo.convertFromPb(oidb_0x8f1_rspbody.msg_label_info.get()), Integer.valueOf(oidb_0x8f1_rspbody.uint32_complete_flag.get()), oidb_0x8f1_rspbody.bytes_label_cookie.get().toByteArray()});
                return;
            }
            notifyUI(3, false, new Object[]{string, Long.valueOf(j3), null, null, null});
            return;
        }
        notifyUI(3, false, null);
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "handleZan");
        }
    }

    private void N2(String str, String str2, long j3) {
        List<MessageRecord> D;
        boolean z16;
        q qVar = (q) this.f259896d.getManager(QQManagerFactory.BEANCURD_MANAGER);
        BeancurdMsg d16 = qVar.d(str2, 0, 3);
        if (d16 == null ? !((D = this.f259896d.getMessageFacade().D(str2, 0, new int[]{MessageRecord.MSG_TYPE_PL_NEWS})) == null || D.size() <= 0 || ((MessageForPLNews) D.get(D.size() - 1)).f203101ts < j3) : d16.originTime >= j3) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            try {
                BeancurdMsg beancurdMsg = new BeancurdMsg();
                beancurdMsg.frienduin = str2;
                beancurdMsg.busiid = 3;
                beancurdMsg.isNeedDelHistory = true;
                beancurdMsg.ispush = false;
                beancurdMsg.originTime = j3;
                beancurdMsg.startTime = e.K0();
                beancurdMsg.validTime = 2592000L;
                beancurdMsg.buffer = str;
                qVar.l(beancurdMsg);
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelHandler", 2, "handleAIOQQStoryFeedMessage: parse data to MessageRecord has error. Message: " + e16.getMessage());
                }
            }
        }
    }

    public void D2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "deleteLabel, labelId = " + j3);
        }
        oidb_0x8f3$ReqBody oidb_0x8f3_reqbody = new oidb_0x8f3$ReqBody();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j3));
        oidb_0x8f3_reqbody.rpt_uint64_labels.set(arrayList);
        sendPbReq(makeOIDBPkg("OidbSvc.0x8f3", 2291, 0, oidb_0x8f3_reqbody.toByteArray()));
    }

    public void E2(String str, long j3, long j16) {
        long j17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "deletePhoto, uin = " + str + ", labelId = " + j3 + ", photoId = " + j16);
        }
        try {
            j17 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            j17 = 0;
        }
        oidb_0x90c$ReqBody oidb_0x90c_reqbody = new oidb_0x90c$ReqBody();
        oidb_0x90c_reqbody.uint64_to.set(j17);
        oidb_0x90c_reqbody.uint64_labelid.set(j3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(j16));
        oidb_0x90c_reqbody.rpt_photoids.set(arrayList);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x90c", 2316, 0, oidb_0x90c_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("key_uin", str);
        makeOIDBPkg.extraData.putLong("label_id", j3);
        makeOIDBPkg.extraData.putLong("photo_id", j16);
        sendPbReq(makeOIDBPkg);
    }

    public void F2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabel:" + str);
        }
        try {
            long parseLong = Long.parseLong(str);
            cmd0x8f0$ReqBody cmd0x8f0_reqbody = new cmd0x8f0$ReqBody();
            cmd0x8f0_reqbody.uint64_req_uin.set(parseLong);
            cmd0x8f0_reqbody.uint32_req_digest.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x8f0", 2288, 0, cmd0x8f0_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("key_uin", str);
            makeOIDBPkg.extraData.putInt("flag", i3);
            makeOIDBPkg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
            send(makeOIDBPkg);
        } catch (NumberFormatException e16) {
            QLog.e("PersonalityLabelHandler", 1, e16, new Object[0]);
        }
    }

    public void G2(String str, long j3, int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3), Integer.valueOf(i3), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "getPersonalityLabelPhotos : uin = " + str + ", labelId = " + j3 + ", count = " + i3 + ", cookie = " + bArr);
        }
        oidb_0x8f1$ReqBody oidb_0x8f1_reqbody = new oidb_0x8f1$ReqBody();
        oidb_0x8f1_reqbody.uint64_req_uin.set(Long.valueOf(str).longValue());
        oidb_0x8f1_reqbody.uint64_label_id.set(j3);
        oidb_0x8f1_reqbody.uint32_req_num.set(i3);
        if (bArr != null) {
            oidb_0x8f1_reqbody.bytes_label_cookie.set(ByteStringMicro.copyFrom(bArr));
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x8f1", 2289, 0, oidb_0x8f1_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("key_uin", str);
        makeOIDBPkg.extraData.putLong("label_id", j3);
        sendPbReq(makeOIDBPkg);
    }

    @TargetApi(12)
    public void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0x8f0$RspBody cmd0x8f0_rspbody = new cmd0x8f0$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x8f0_rspbody);
            String string = toServiceMsg.extraData.getString("key_uin", "");
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleGetPersonalityLabel, result==0 ");
                if (parseOIDBPkg == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(",");
                sb5.append(string);
                QLog.i("PersonalityLabelHandler", 2, sb5.toString());
            }
            int i3 = toServiceMsg.extraData.getInt("flag", 0);
            if (parseOIDBPkg == 0) {
                ProfilePersonalityLabelInfo convertFromPb = ProfilePersonalityLabelInfo.convertFromPb(cmd0x8f0_rspbody);
                notifyUI(1, true, new Object[]{string, convertFromPb, ProfilePersonalityLabelInfo.convertToBytes(convertFromPb), Integer.valueOf(i3)});
                return;
            } else {
                notifyUI(1, false, new Object[]{string, null, null, Integer.valueOf(i3)});
                return;
            }
        }
        notifyUI(1, false, null);
    }

    public void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0x91d$RspBody cmd0x91d_rspbody = new cmd0x91d$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x91d_rspbody);
            String string = toServiceMsg.extraData.getString("key_uin", "0");
            long j16 = toServiceMsg.extraData.getLong("key_timestamp", 0L);
            long j17 = toServiceMsg.extraData.getLong("latestPLUpdateTimestamp", 0L);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleGetPersonalityLabelNews, result==0 ");
                if (parseOIDBPkg == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(",");
                sb5.append(string);
                QLog.i("PersonalityLabelHandler", 2, sb5.toString());
            }
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(String.valueOf(string));
            IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
            com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.a(uidFromUin, string);
            aVar.m();
            aVar.n0(System.currentTimeMillis() / 1000);
            cmd0x91d$LabelUpdateInfo cmd0x91d_labelupdateinfo = null;
            if (parseOIDBPkg == 0) {
                if (cmd0x91d_rspbody.uint64_last_time.has()) {
                    j3 = cmd0x91d_rspbody.uint64_last_time.get();
                } else {
                    j3 = 0;
                }
                if (j3 > j16 && cmd0x91d_rspbody.msg_update_info.has()) {
                    aVar.m0(j3);
                    aVar.m0(j3);
                    iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar)), "PersonalityLabelHandler", null);
                    if (cmd0x91d_rspbody.msg_update_info.has()) {
                        cmd0x91d_labelupdateinfo = cmd0x91d_rspbody.msg_update_info.get();
                    }
                    if (cmd0x91d_labelupdateinfo != null && cmd0x91d_labelupdateinfo.msg_label_info.has()) {
                        PersonalityTagComm$LabelInfo personalityTagComm$LabelInfo = cmd0x91d_labelupdateinfo.msg_label_info;
                        if (cmd0x91d_labelupdateinfo.uint32_upload_photos.has()) {
                            cmd0x91d_labelupdateinfo.uint32_upload_photos.get();
                        }
                        PersonalityLabelInfo convertFromPb = PersonalityLabelInfo.convertFromPb(personalityTagComm$LabelInfo);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("personalityTagId", convertFromPb.f259897id);
                            jSONObject.put("text", convertFromPb.text);
                            jSONObject.put("bgColor", convertFromPb.bgColor);
                            jSONObject.put("ts", j3);
                            String str = "";
                            if (O2((int) convertFromPb.f259897id)) {
                                if (convertFromPb.getSize() > 0) {
                                    str = convertFromPb.personalityLabelPhotos.get(0).url;
                                }
                                jSONObject.put("cover", str);
                            } else {
                                if (convertFromPb.getSize() > 0) {
                                    str = convertFromPb.personalityLabelPhotos.get(0).get128SizeUrl() + a.f259946d;
                                }
                                jSONObject.put("cover", str);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews insert gray msg");
                            }
                            N2(jSONObject.toString(), string, j3);
                            return;
                        } catch (JSONException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews", e16);
                                return;
                            }
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews update, no data");
                        return;
                    }
                    return;
                }
                aVar.o0(Math.max(j16, j3));
                iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar)), "PersonalityLabelHandler", null);
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews no update");
                    return;
                }
                return;
            }
            if (parseOIDBPkg == 1206) {
                aVar.m0(j17);
                aVar.o0(j16);
                iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar)), "PersonalityLabelHandler", null);
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews 1206 " + j17);
                    return;
                }
                return;
            }
            iOtherInfoService.accurateUpdateNTOtherDetailInfo(new ArrayList<>(Collections.singletonList(aVar)), "PersonalityLabelHandler", null);
            if (QLog.isColorLevel()) {
                QLog.i("PersonalityLabelHandler", 2, "handleGetPersonalityLabelNews failed");
            }
        }
    }

    public boolean O2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        if (!com.tencent.relation.common.config.toggle.c.f364708u.g(false)) {
            return false;
        }
        return ((IProfileKoiLikeApi) QRoute.api(IProfileKoiLikeApi.class)).isSpecialPersonalLabel(i3);
    }

    public void P2(String str, long j3) {
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabelHandler", 2, "zan");
        }
        try {
            j16 = Long.parseLong(str);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            j16 = 0;
        }
        oidb_0x909$ReqBody oidb_0x909_reqbody = new oidb_0x909$ReqBody();
        oidb_0x909_reqbody.uint64_to.set(j16);
        oidb_0x909_reqbody.uint64_labelid.set(j3);
        oidb_0x909_reqbody.int32_count.set(1);
        sendPbReq(makeOIDBPkg("OidbSvc.0x909", 2313, 0, oidb_0x909_reqbody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x8f0");
            this.allowCmdSet.add("OidbSvc.0x91d");
            this.allowCmdSet.add("OidbSvc.0x909");
            this.allowCmdSet.add("OidbSvc.0x90c");
            this.allowCmdSet.add("OidbSvc.0x8f3");
            this.allowCmdSet.add("OidbSvc.0x8f1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x8f0".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            J2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x91d".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            K2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x909".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x90c".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x8f3".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            H2();
        } else if ("OidbSvc.0x8f1".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            L2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
