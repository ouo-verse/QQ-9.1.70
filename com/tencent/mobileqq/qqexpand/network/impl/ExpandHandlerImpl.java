package com.tencent.mobileqq.qqexpand.network.impl;

import QC.ExtendFriend;
import QC.UniBusinessItem;
import QC.UniSetExtFriendReq;
import QC.UniSetExtFriendRsp;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.ProcessorDispatcherInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.bean.chat.b;
import com.tencent.mobileqq.qqexpand.bean.feed.b;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.e;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.extfriend.api.IVasAdExtendFriendApi;
import com.tencent.mobileqq.vas.api.IJce;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo$GPS;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo$LBSInfo;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo$ReqBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo$RspBody;
import com.tencent.pb.extendfriend.ExtendFriendSquareInfo$StrangerInfo;
import com.tencent.pb.extendfriend.GetExtendFriendInfo$ReqBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo$RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo$schoolInfo;
import com.tencent.pb.personal.PersonalInfo$ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo$ReqBody;
import com.tencent.pb.profilecard.EditExtendFriendInfo$RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.LogUtil;
import msf.msgsvc.msg_svc$PbC2CReadedReportReq;
import msf.msgsvc.msg_svc$PbMsgReadedReportReq;
import org.apache.httpcore.message.TokenParser;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5$ReqBody;
import tencent.im.oidb.cmd0xcb5.cmd0xcb5$RspBody;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1$RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$GPS;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$LBSInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$MatchInfo;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$MatchUinData;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$ReqBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$RspBody;
import tencent.im.oidb.cmd0xe03.oidb_0xe03$TagInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09$OnlineInfo;
import tencent.im.oidb.cmd0xe09.oidb_0xe09$ReqBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09$RspBody;
import tencent.im.oidb.cmd0xe09.oidb_0xe09$reqItem;
import tencent.im.oidb.cmd0xe52.oidb_0xe52$RspBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67$GPS;
import tencent.im.oidb.cmd0xe67.oidb_0xe67$LBSInfo;
import tencent.im.oidb.cmd0xe67.oidb_0xe67$ReqBody;
import tencent.im.oidb.cmd0xe67.oidb_0xe67$RspBody;
import tencent.im.oidb.cmd0xeae.oidb_0xeae$ReqBody;
import tencent.im.oidb.cmd0xeae.oidb_0xeae$RspBody;
import tencent.im.oidb.oidb_0xe51$ReqBody;
import tencent.im.oidb.oidb_0xe51$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import vg2.c;
import vg2.d;
import vg2.f;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandHandlerImpl extends BusinessHandler implements e {

    /* renamed from: f, reason: collision with root package name */
    public static AtomicInteger f263974f = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f263975d;

    /* renamed from: e, reason: collision with root package name */
    private final AppInterface f263976e;

    public ExpandHandlerImpl(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.f263975d = qQAppInterface;
        this.f263976e = qQAppInterface;
    }

    private void E2(oidb_0xe03$MatchUinData oidb_0xe03_matchuindata, com.tencent.mobileqq.qqexpand.bean.chat.a aVar) {
        if (oidb_0xe03_matchuindata != null && aVar != null) {
            aVar.f263445b = oidb_0xe03_matchuindata.uint32_age.has() ? oidb_0xe03_matchuindata.uint32_age.get() + "" : "";
            aVar.f263446c = oidb_0xe03_matchuindata.bytes_constellation.has() ? oidb_0xe03_matchuindata.bytes_constellation.get().toStringUtf8() : "";
            aVar.f263447d = oidb_0xe03_matchuindata.bytes_city.has() ? oidb_0xe03_matchuindata.bytes_city.get().toStringUtf8() : "";
            aVar.f263448e = oidb_0xe03_matchuindata.bytes_school.has() ? oidb_0xe03_matchuindata.bytes_school.get().toStringUtf8() : "";
            aVar.f263450g = oidb_0xe03_matchuindata.bytes_company.has() ? oidb_0xe03_matchuindata.bytes_company.get().toStringUtf8() : "";
            aVar.f263452i = oidb_0xe03_matchuindata.bytes_declaration.has() ? oidb_0xe03_matchuindata.bytes_declaration.get().toStringUtf8() : "";
            aVar.f263453j = oidb_0xe03_matchuindata.bytes_voice_url.has() ? oidb_0xe03_matchuindata.bytes_voice_url.get().toStringUtf8() : "";
            aVar.f263454k = oidb_0xe03_matchuindata.uint32_voice_duration.has() ? oidb_0xe03_matchuindata.uint32_voice_duration.get() : 0;
            byte[] byteArray = oidb_0xe03_matchuindata.bytes_long_nick.has() ? oidb_0xe03_matchuindata.bytes_long_nick.get().toByteArray() : null;
            if (byteArray != null) {
                aVar.f263455l = RichStatus.parseStatus(byteArray).getPlainText();
            }
            if (oidb_0xe03_matchuindata.uint32_sex.has()) {
                aVar.f263451h = oidb_0xe03_matchuindata.uint32_sex.get();
            } else {
                aVar.f263451h = 0;
                QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, "mGender  is null. set 0  ");
            }
            aVar.f263459p = oidb_0xe03_matchuindata.uint32_popularity.has() ? oidb_0xe03_matchuindata.uint32_popularity.get() : 0L;
            ArrayList<b> arrayList = new ArrayList<>();
            if (oidb_0xe03_matchuindata.rpt_school_info.has()) {
                for (int i3 = 0; i3 < oidb_0xe03_matchuindata.rpt_school_info.size(); i3++) {
                    if (oidb_0xe03_matchuindata.rpt_school_info.get(i3).str_school_name.has()) {
                        b bVar = new b(oidb_0xe03_matchuindata.rpt_school_info.get(i3).str_school_id.get(), oidb_0xe03_matchuindata.rpt_school_info.get(i3).str_school_name.get(), oidb_0xe03_matchuindata.rpt_school_info.get(i3).uint64_state.get());
                        arrayList.add(bVar);
                        if (QLog.isColorLevel()) {
                            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "schoolInfo. " + bVar.toString());
                        }
                    }
                }
            }
            aVar.f263460q = arrayList;
            ArrayList<vg2.e> arrayList2 = new ArrayList<>();
            if (oidb_0xe03_matchuindata.rpt_tag.has()) {
                for (int i16 = 0; i16 < oidb_0xe03_matchuindata.rpt_tag.size(); i16++) {
                    if (oidb_0xe03_matchuindata.rpt_tag.get(i16).bytes_tag.has()) {
                        int i17 = oidb_0xe03_matchuindata.rpt_tag.get(i16).uint32_same_flag.get();
                        String stringUtf8 = oidb_0xe03_matchuindata.rpt_tag.get(i16).bytes_tag.get().toStringUtf8();
                        vg2.e eVar = new vg2.e();
                        eVar.f441616a = i17;
                        eVar.f441617b = stringUtf8;
                        arrayList2.add(eVar);
                    }
                }
            }
            aVar.f263449f = arrayList2;
            aVar.f263461r = oidb_0xe03_matchuindata.uint32_distance.has() ? oidb_0xe03_matchuindata.uint32_distance.get() : -1;
            aVar.f263462s = oidb_0xe03_matchuindata.uint32_match_pool.has() ? oidb_0xe03_matchuindata.uint32_match_pool.get() : -1;
            aVar.f263463t = oidb_0xe03_matchuindata.str_from_city_name.has() ? oidb_0xe03_matchuindata.str_from_city_name.get() : "";
            aVar.f263464u = oidb_0xe03_matchuindata.str_to_city_name.has() ? oidb_0xe03_matchuindata.str_to_city_name.get() : "";
            if (QLog.isColorLevel()) {
                QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "ChatFriendInfo. " + aVar.toString());
                return;
            }
            return;
        }
        QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, "msg_match_uin_data || info is null. ");
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_0xe52$RspBody>() { // from class: tencent.im.oidb.cmd0xe52.oidb_0xe52$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint32_verify_result"}, new Object[]{0}, oidb_0xe52$RspBody.class);
            public final PBUInt32Field uint32_verify_result = PBField.initUInt32(0);
        });
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, "handleCertificateConfirmSchool,result = " + parseOIDBPkg);
        }
    }

    private void J2(FromServiceMsg fromServiceMsg, oidb_0xdb1$RspBody oidb_0xdb1_rspbody) {
        W2(new Object[]{Integer.valueOf((int) oidb_0xdb1_rspbody.uint64_black_times.get()), Integer.valueOf((int) oidb_0xdb1_rspbody.uint64_be_blacked_times.get()), Long.valueOf(oidb_0xdb1_rspbody.uint64_left_punish_time.get()), oidb_0xdb1_rspbody.str_black_times_tips.get(), oidb_0xdb1_rspbody.str_black_times_used_up_tips.get(), oidb_0xdb1_rspbody.str_black_times_used_up_title.get(), oidb_0xdb1_rspbody.str_be_black_tips.get(), oidb_0xdb1_rspbody.str_punish_tips.get(), Boolean.valueOf(oidb_0xdb1_rspbody.uint32_show_gray_tips.get() == 1)}, fromServiceMsg.getServiceCmd());
    }

    private void K2(FromServiceMsg fromServiceMsg, oidb_0xe03$RspBody oidb_0xe03_rspbody) {
        W2(new Object[]{Integer.valueOf((int) oidb_0xe03_rspbody.uint64_black_times.get()), Integer.valueOf((int) oidb_0xe03_rspbody.uint64_be_blacked_times.get()), Long.valueOf(oidb_0xe03_rspbody.uint64_left_punish_time.get()), oidb_0xe03_rspbody.str_black_times_tips.get(), oidb_0xe03_rspbody.str_black_times_used_up_tips.get(), oidb_0xe03_rspbody.str_black_times_used_up_title.get(), oidb_0xe03_rspbody.str_be_black_tips.get(), null, Boolean.valueOf(oidb_0xe03_rspbody.uint32_show_gray_tips.get() == 1)}, fromServiceMsg.getServiceCmd());
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        try {
            oidb_0xe67$RspBody oidb_0xe67_rspbody = new oidb_0xe67$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe67_rspbody);
            int i3 = toServiceMsg.extraData.getInt("uint32_action", -1);
            int i16 = oidb_0xe67_rspbody.uint32_flare_switch.has() ? oidb_0xe67_rspbody.uint32_flare_switch.get() : -1;
            if (i3 == 1 && i16 == 1) {
                try {
                    if (((com.tencent.mobileqq.qqexpand.manager.e) this.f263975d.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).u()) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    ReportController.o(null, "dc00898", "", "", "0X800AE9B", "0X800AE9B", 0, 0, "", str, "", "");
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("ExpandHandlerImpl", 1, "handleExtendFriendEnterAndQuitReport() fail.", e);
                    return;
                }
            }
            QLog.i("ExpandHandlerImpl", 2, "handleExtendFriendEnterAndQuit  result=" + parseOIDBPkg + "[0is exit] type:" + i3 + " signalSwitch:" + i16);
        } catch (Exception e17) {
            e = e17;
        }
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_0xdb1$RspBody oidb_0xdb1_rspbody = new oidb_0xdb1$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xdb1_rspbody);
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, "handleGetCampusCertificateStatusResponse. result = ", Integer.valueOf(parseOIDBPkg));
        }
        if (parseOIDBPkg == 0) {
            ExpandManager expandManager = (ExpandManager) this.f263976e.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (expandManager != null) {
                expandManager.E0(toServiceMsg, fromServiceMsg, oidb_0xdb1_rspbody);
            }
            z16 = true;
        } else {
            z16 = false;
        }
        notifyUI(20, z16, new Object[]{1});
        if (parseOIDBPkg == 0) {
            J2(fromServiceMsg, oidb_0xdb1_rspbody);
        }
    }

    private void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            oidb_0xe51$RspBody oidb_0xe51_rspbody = new oidb_0xe51$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe51_rspbody);
            String string = toServiceMsg.extraData.getString("selfUin");
            String string2 = toServiceMsg.extraData.getString("friendUin");
            String string3 = toServiceMsg.extraData.getString("friendNick");
            if (parseOIDBPkg == 0) {
                byte[] byteArray = oidb_0xe51_rspbody.bytes_sig.get().toByteArray();
                QQAppInterface qQAppInterface = this.f263975d;
                if (qQAppInterface == null || qQAppInterface.getMsgCache() == null) {
                    return;
                }
                this.f263975d.getMsgCache().w(string2, string, byteArray, false);
                if (QLog.isColorLevel()) {
                    QLog.d("ExpandHandlerImpl", 2, "handleGetSigByOxb4cCode() success -> addMatchChatSessionKey");
                }
                notifyUI(21, true, new Object[]{string2, string3});
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ExpandHandlerImpl", 2, "handleGetSigByOxb4cCode() fail result=" + parseOIDBPkg);
            }
            notifyUI(21, false, new Object[]{string2, Integer.valueOf(parseOIDBPkg)});
        } catch (Exception e16) {
            QLog.e("ExpandHandlerImpl", 1, "handleGetSigByOxb4cCode() fail.", e16);
        }
    }

    private void V2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<EditExtendFriendInfo$RspBody>() { // from class: com.tencent.pb.profilecard.EditExtendFriendInfo$RspBody
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], EditExtendFriendInfo$RspBody.class);
        });
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, "handleUpdateExtendFriendCampusSchoolInfo,result = " + parseOIDBPkg);
        }
        boolean z16 = false;
        if (parseOIDBPkg == 0) {
            com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.f263976e.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (eVar != null) {
                int i3 = toServiceMsg.extraData.getInt("idx", 0);
                String string = toServiceMsg.extraData.getString(INearbySPUtil.SP_KEY_SCHOOL_NAME, "");
                String string2 = toServiceMsg.extraData.getString("school_id", "");
                int i16 = toServiceMsg.extraData.getInt("school_category", 0);
                eVar.V(toServiceMsg.extraData.getInt("school_certi_status", 0), 1);
                eVar.j(i3, string, string2, i16);
            }
            z16 = true;
        }
        notifyUI(22, z16, null);
    }

    private Card Y2(String str, String str2, String str3, int i3, long j3, int i16) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ExpandHandlerImpl", 1, "saveExtendFriendInfo uin is null");
            return null;
        }
        FriendsManager friendsManager = (FriendsManager) this.f263975d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card q16 = friendsManager.q(str);
        q16.declaration = str2;
        q16.voiceUrl = str3;
        if (i3 != 0) {
            q16.popularity = i3;
        }
        q16.updateTime = j3;
        q16.extendFriendVoiceDuration = i16;
        friendsManager.p0(q16);
        QLog.e("ExpandHandlerImpl", 1, "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d", str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        return q16;
    }

    private Card Z2(String str, String str2, String str3, int i3, long j3, int i16, int i17, int i18, int i19, String str4, String str5, long j16, int i26, int i27) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ExpandHandlerImpl", 1, "saveExtendFriendInfo uin is null");
            return null;
        }
        FriendsManager friendsManager = (FriendsManager) this.f263975d.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card q16 = friendsManager.q(str);
        q16.declaration = str2;
        q16.voiceUrl = str3;
        q16.fontId = i17;
        q16.fontType = i18;
        q16.clothesId = i19;
        if (i3 != 0) {
            q16.popularity = i3;
        }
        q16.updateTime = j3;
        q16.extendFriendVoiceDuration = i16;
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str5)) {
            q16.schoolName = str5;
            q16.schoolId = str4;
            q16.authState = j16;
            q16.idx = i26;
            q16.category = i27;
            friendsManager.p0(q16);
            QLog.e("ExpandHandlerImpl", 1, "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d schoolId=%s schoolName=%s authState=%d idx=%d category=%d", str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str4, str5, Long.valueOf(j16), Integer.valueOf(i26), Integer.valueOf(i27));
            return q16;
        }
        q16.schoolName = "";
        q16.schoolId = "";
        q16.authState = -1L;
        q16.idx = -1;
        q16.category = -1;
        friendsManager.p0(q16);
        QLog.e("ExpandHandlerImpl", 1, "saveExtendFriendInfo uin=%s declaration=%s voiceUrl=%s popularity=%d updateTime=%ld extendFriendVoiceDuration=%d schoolId=%s schoolName=%s authState=%d idx=%d category=%d", str, str2, str3, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str4, str5, Long.valueOf(j16), Integer.valueOf(i26), Integer.valueOf(i27));
        return q16;
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void C0(String str, String str2, String str3, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        QLog.i("ExpandHandlerImpl", 1, String.format("editExtendFriendInfo uin=%s, declaration=%s, url=%s, duration=%d", str, str2, str3, Integer.valueOf(i3)));
        if (!NetworkState.isNetworkConnected(this.f263975d.getApp())) {
            QQToast.makeText(this.f263975d.getApp(), 1, R.string.f171137ci2, 0).show();
            notifyUI(1, false, null);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            i19 = 0;
            i26 = 0;
        } else {
            i19 = i16;
            i26 = i18;
        }
        VasUtil.getService().getJceRequset().build("QC.UniBusinessLogicServer.UniBusinessLogicObj", "QCUniBusinessLogic.UniSetExtFriend").request("UniSetExtFriend", new UniSetExtFriendReq(IJce.Util.getLoginInfo(), new UniBusinessItem(304, i26, ""), new ExtendFriend(i19)), new UniSetExtFriendRsp(), new a(str, i26, i19), true);
        try {
            EditExtendFriendInfo$ReqBody editExtendFriendInfo$ReqBody = new EditExtendFriendInfo$ReqBody();
            editExtendFriendInfo$ReqBody.uint64_uin.set(Long.parseLong(str));
            editExtendFriendInfo$ReqBody.bytes_declaration.set(ByteStringMicro.copyFromUtf8(str2));
            editExtendFriendInfo$ReqBody.bytes_voice_url.set(ByteStringMicro.copyFromUtf8(str3));
            editExtendFriendInfo$ReqBody.uint32_voice_duration.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xb4b", 2891, 0, editExtendFriendInfo$ReqBody.toByteArray());
            makeOIDBPkg.extraData.putString("uin", str);
            makeOIDBPkg.extraData.putString("declaration", str2);
            makeOIDBPkg.extraData.putString("url", str3);
            makeOIDBPkg.extraData.putInt("duration", i3);
            makeOIDBPkg.setTimeout(10000L);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("ExpandHandlerImpl", 1, "editExtendFriendInfo exception:" + e16.getMessage());
        }
    }

    public boolean F2(vg2.b bVar) {
        try {
            oidb_0xe67$ReqBody oidb_0xe67_reqbody = new oidb_0xe67$ReqBody();
            oidb_0xe67_reqbody.uint32_action.set(1);
            if (bVar != null) {
                oidb_0xe67$LBSInfo oidb_0xe67_lbsinfo = new oidb_0xe67$LBSInfo();
                oidb_0xe67$GPS oidb_0xe67_gps = new oidb_0xe67$GPS();
                oidb_0xe67_gps.int32_lon.set(bVar.f441598b);
                oidb_0xe67_gps.int32_lat.set(bVar.f441597a);
                oidb_0xe67_gps.int32_alt.set(bVar.f441599c);
                oidb_0xe67_gps.int32_type.set(bVar.f441600d);
                oidb_0xe67_lbsinfo.msg_gps.set(oidb_0xe67_gps);
                oidb_0xe67_reqbody.msg_lbs_info.set(oidb_0xe67_lbsinfo);
                QLog.i("ExpandHandlerImpl", 1, "EnterExtendFriend. with msg_lbs_info info ");
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, oidb_0xe67_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("uint32_action", 1);
            sendPbReq(makeOIDBPkg);
            return true;
        } catch (NumberFormatException e16) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "EnterExtendFriend. error = " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void G0(String str, byte[] bArr, int i3, String str2, long j3, String str3, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, String.format("getSquareStrangerList uin=%s reqCookies=%s reqCount=%s searchKey=%s ts=%d isConfigTag:%b", str, bArr, Integer.valueOf(i3), str2, Long.valueOf(j3), Boolean.valueOf(z16)));
        }
        try {
            ExtendFriendSquareInfo$ReqBody extendFriendSquareInfo$ReqBody = new ExtendFriendSquareInfo$ReqBody();
            extendFriendSquareInfo$ReqBody.uint64_uin.set(Long.parseLong(str));
            if (bArr != null) {
                extendFriendSquareInfo$ReqBody.bytes_req_page_cookies.set(ByteStringMicro.copyFrom(bArr));
            }
            String trim = str2 == null ? null : str2.trim();
            if (!TextUtils.isEmpty(trim) && !str3.equals(trim)) {
                extendFriendSquareInfo$ReqBody.str_keyword.set(ByteStringMicro.copyFromUtf8(trim));
            }
            extendFriendSquareInfo$ReqBody.uint32_req_num.set(i3);
            extendFriendSquareInfo$ReqBody.bytes_req_buff.set(ByteStringMicro.copyFrom(((IVasAdExtendFriendApi) QRoute.api(IVasAdExtendFriendApi.class)).getDeviceInfoByteArray()));
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xb4c", 2892, 0, extendFriendSquareInfo$ReqBody.toByteArray());
            makeOIDBPkg.setTimeout(10000L);
            makeOIDBPkg.extraData.putLong("reqTs", j3);
            if (!TextUtils.isEmpty(str2)) {
                makeOIDBPkg.extraData.putString("searchKey", str2);
            }
            SosoLbsInfo canUsedLbsInfoCache = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).getCanUsedLbsInfoCache(3600000L, false, 0, true);
            if (canUsedLbsInfoCache != null) {
                ExtendFriendSquareInfo$LBSInfo extendFriendSquareInfo$LBSInfo = new ExtendFriendSquareInfo$LBSInfo();
                ExtendFriendSquareInfo$GPS extendFriendSquareInfo$GPS = new ExtendFriendSquareInfo$GPS();
                SosoLocation sosoLocation = canUsedLbsInfoCache.mLocation;
                if (sosoLocation != null) {
                    extendFriendSquareInfo$GPS.int32_lon.set((int) (sosoLocation.mLon02 * 1000000.0d));
                    extendFriendSquareInfo$GPS.int32_lat.set((int) (canUsedLbsInfoCache.mLocation.mLat02 * 1000000.0d));
                    extendFriendSquareInfo$GPS.int32_type.set(1);
                }
                extendFriendSquareInfo$LBSInfo.msg_gps.set(extendFriendSquareInfo$GPS);
                extendFriendSquareInfo$ReqBody.msg_lbs_info.set(extendFriendSquareInfo$LBSInfo);
            }
            sendPbReq(makeOIDBPkg);
            if (!TextUtils.isEmpty(str3) && str3.equals(trim)) {
                return;
            }
            ReportController.o(this.f263975d, "dc00898", "", "", "0X8009423", "0X8009423", z16 ? 1 : 2, 0, "", "", str2, "");
        } catch (Exception e16) {
            QLog.e("ExpandHandlerImpl", 1, "getSquareStrangerList fail.", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void H() {
        if (!MatchChatMsgUtil.e(this.f263975d)) {
            if (QLog.isColorLevel()) {
                QLog.i("ExpandHandlerImpl", 2, "calcMatchChatBoxUnreadCount isMatchChatRedPointSwitchOn false");
                return;
            }
            return;
        }
        updateRedPoint();
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void H0(String str, String str2, String str3, byte[] bArr) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("ExpandHandlerImpl", 2, "getSigBy0xb4cCode() friendUin= " + str2 + " selfUin= " + str + " _0xb4cCode =" + bArr);
            }
            oidb_0xe51$ReqBody oidb_0xe51_reqbody = new oidb_0xe51$ReqBody();
            oidb_0xe51_reqbody.uint64_from_uin.set(Long.parseLong(str));
            oidb_0xe51_reqbody.uint64_to_uin.set(Long.parseLong(str2));
            oidb_0xe51_reqbody.bytes_code.set(ByteStringMicro.copyFrom(bArr));
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe51", 3665, 1, oidb_0xe51_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("selfUin", str);
            makeOIDBPkg.extraData.putString("friendUin", str2);
            makeOIDBPkg.extraData.putString("friendNick", str3);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            notifyUI(21, false, new Object[]{str2, -1});
            QLog.e("ExpandHandlerImpl", 1, "getSigBy0xb4cCode() fail.", e16);
        }
    }

    public boolean H2(String str, String str2, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "getUnlimitMatchUserInfo. uin = " + str + " matchUin:" + str2 + " uinType:" + i3);
        }
        try {
            oidb_0xe03$ReqBody oidb_0xe03_reqbody = new oidb_0xe03$ReqBody();
            oidb_0xe03_reqbody.uint64_uin.set(b3(str, "getUnlimitMatchUserInfo"));
            oidb_0xe03_reqbody.uint64_match_uin.set(b3(str2, "getUnlimitMatchUserInfo"));
            oidb_0xe03_reqbody.enum_matchopcode.set(5);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, oidb_0xe03_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("match_op", 5);
            makeOIDBPkg.extraData.putString("match_uin", str2);
            makeOIDBPkg.extraData.putInt(IPublicAccountBrowser.KEY_UIN_TYPE, i3);
            sendPbReq(makeOIDBPkg);
            return true;
        } catch (NumberFormatException e16) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "requestMatch. error = " + e16);
            return false;
        }
    }

    public void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String stringForLog;
        boolean z16;
        if (fromServiceMsg.getResultCode() == 1000) {
            Y2(toServiceMsg.extraData.getString("uin"), toServiceMsg.extraData.getString("declaration"), toServiceMsg.extraData.getString("url"), 0, NetConnInfoCenter.getServerTimeMillis(), toServiceMsg.extraData.getInt("duration"));
            stringForLog = "success";
            z16 = true;
        } else {
            stringForLog = fromServiceMsg.getStringForLog();
            z16 = false;
        }
        QLog.i("ExpandHandlerImpl", 1, String.format("handleEditExtendFriendInfo %s", stringForLog));
        notifyUI(1, z16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        String str;
        int i3;
        int i16;
        ExtendFriendSquareInfo$RspBody extendFriendSquareInfo$RspBody = new ExtendFriendSquareInfo$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, extendFriendSquareInfo$RspBody);
        long j16 = toServiceMsg.extraData.getLong("reqTs", 0L);
        String string = toServiceMsg.extraData.getString("searchKey", null);
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, String.format("handleGetSquareStrangerList resultCode=%s searchKey=%s ts=%d", Integer.valueOf(parseOIDBPkg), string, Long.valueOf(j16)));
        }
        if (parseOIDBPkg == 0) {
            try {
                boolean z16 = extendFriendSquareInfo$RspBody.uint32_over.get() == 1;
                byte[] byteArray = extendFriendSquareInfo$RspBody.bytes_rsp_page_cookies.get().toByteArray();
                boolean z17 = extendFriendSquareInfo$RspBody.uint32_is_profile_complete.get() == 1;
                boolean z18 = extendFriendSquareInfo$RspBody.uint32_is_show_card.get() == 1;
                int i17 = extendFriendSquareInfo$RspBody.uint32_friend_max_votes.get();
                List<ExtendFriendSquareInfo$StrangerInfo> list = extendFriendSquareInfo$RspBody.rpt_msg_stranger_info.get();
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    Iterator<ExtendFriendSquareInfo$StrangerInfo> it = list.iterator();
                    while (it.hasNext()) {
                        ExtendFriendSquareInfo$StrangerInfo next = it.next();
                        com.tencent.mobileqq.qqexpand.bean.feed.b bVar = new com.tencent.mobileqq.qqexpand.bean.feed.b();
                        Iterator<ExtendFriendSquareInfo$StrangerInfo> it5 = it;
                        bVar.mUin = String.valueOf(next.uint64_uin.get());
                        bVar.mNickName = next.bytes_nick.get().toStringUtf8();
                        bVar.mGender = next.uint32_gender.get();
                        str = string;
                        try {
                            bVar.mLiked = next.uint32_is_my_like.get() == 1;
                            bVar.mAvailLikeCount = next.uint32_my_left_like_count.get();
                            bVar.mAddFriendVerified = next.uint32_addfri_status.get() == 1;
                            bVar.mPopularity = next.uint32_popularity.get();
                            bVar.mDeclaration = next.bytes_declaration.get().toStringUtf8();
                            bVar.mVoiceUrl = next.bytes_voice_url.get().toStringUtf8();
                            bVar.mVoiceDuration = next.uint32_voice_duration.get();
                            bVar.mbAllowStrangerVote = next.uint32_vote_switch.get() == 0;
                            bVar.mStrRecomTrace = next.str_recom_trace.get();
                            bVar.voiceCode = next.bytes_voice_code.get().toByteArray();
                            PersonalInfo$ReqBody personalInfo$ReqBody = new PersonalInfo$ReqBody();
                            personalInfo$ReqBody.mergeFrom(next.bytes_personalization.get().toByteArray());
                            bVar.fontId = personalInfo$ReqBody.fontid.get();
                            bVar.fontType = personalInfo$ReqBody.fonttype.get();
                            bVar.clothesId = personalInfo$ReqBody.itemid.get();
                            if (TextUtils.isEmpty(bVar.mDeclaration)) {
                                j3 = j16;
                            } else {
                                j3 = j16;
                                try {
                                    String replace = bVar.mDeclaration.replace('\n', TokenParser.SP);
                                    bVar.mDeclaration = replace;
                                    bVar.mDeclaration = replace.trim();
                                } catch (Exception e16) {
                                    e = e16;
                                    if (QLog.isColorLevel()) {
                                        i3 = 2;
                                    } else {
                                        i3 = 2;
                                        QLog.i("ExpandHandlerImpl", 2, e.getMessage(), e);
                                    }
                                    Object[] objArr = new Object[i3];
                                    objArr[0] = Long.valueOf(j3);
                                    objArr[1] = str;
                                    notifyUI(i3, false, objArr);
                                    ExtendFriendReport.a().l(fromServiceMsg.isSuccess(), fromServiceMsg.getResultCode());
                                }
                            }
                            bVar.mVipHide = next.uint32_show_vip_info_flag.get() == 0;
                            bVar.mBigVipHide = next.uint32_bigvip_open.get() == 0;
                            bVar.mBigVipLevel = next.uint32_bigvip_level.get();
                            bVar.mVipType = next.uint32_vip_flag.get();
                            bVar.mVipLevel = next.uint32_svip_level.get();
                            bVar.mTemplateId = next.uint32_vipicon_id.get();
                            bVar.mAlumbasicdata = next.bytes_ad_content.has() ? AlumBasicData.createFrombyte(next.bytes_ad_content.get().toByteArray()) : null;
                            bVar.mAge = next.uint32_age.get();
                            bVar.mLabelInfos = new ArrayList();
                            if (next.rpt_label_info.has()) {
                                int i18 = 0;
                                while (i18 < next.rpt_label_info.get().size()) {
                                    b.a aVar = new b.a();
                                    boolean z19 = z18;
                                    aVar.f263486a = next.rpt_label_info.get().get(i18).uint64_label_id.get();
                                    aVar.f263487b = next.rpt_label_info.get().get(i18).str_label_name.has() ? next.rpt_label_info.get().get(i18).str_label_name.get() : null;
                                    bVar.mLabelInfos.add(aVar);
                                    i18++;
                                    z18 = z19;
                                }
                            }
                            boolean z26 = z18;
                            bVar.mSchoolInfos = new ArrayList();
                            if (next.rpt_school_info.has()) {
                                int i19 = 0;
                                while (i19 < next.rpt_school_info.get().size()) {
                                    b.C8313b c8313b = new b.C8313b();
                                    c8313b.f263488a = next.rpt_school_info.get().get(i19).str_school_id.get();
                                    c8313b.f263489b = next.rpt_school_info.get().get(i19).uint64_state.get();
                                    c8313b.f263490c = next.rpt_school_info.get().get(i19).str_school_name.has() ? next.rpt_school_info.get().get(i19).str_school_name.get() : null;
                                    if (QLog.isColorLevel()) {
                                        StringBuilder sb5 = new StringBuilder();
                                        sb5.append("handleGetSquareStrangerList: schoolId ");
                                        sb5.append(c8313b.f263488a);
                                        sb5.append(" schoolName ");
                                        sb5.append(c8313b.f263490c);
                                        sb5.append(" authState ");
                                        i16 = i17;
                                        sb5.append(c8313b.f263489b);
                                        QLog.d("ExpandHandlerImpl", 2, sb5.toString());
                                    } else {
                                        i16 = i17;
                                    }
                                    bVar.mSchoolInfos.add(c8313b);
                                    i19++;
                                    i17 = i16;
                                }
                            }
                            int i26 = i17;
                            if (QLog.isColorLevel()) {
                                QLog.d("ExpandHandlerImpl", 2, "handleGetSquareStrangerList: " + bVar.mUin + " " + next.uint32_vip_flag.get() + " " + next.uint32_svip_level.get());
                            }
                            if (TextUtils.isEmpty(bVar.mNickName) && bVar.mAlumbasicdata == null) {
                                if (QLog.isColorLevel()) {
                                    QLog.w("ExpandHandlerImpl", 2, String.format("handleGetSquareStrangerList nick name is empty, uin=%s", bVar.mUin));
                                }
                                z18 = z26;
                                it = it5;
                                string = str;
                                j16 = j3;
                                i17 = i26;
                            }
                            arrayList.add(bVar);
                            z18 = z26;
                            it = it5;
                            string = str;
                            j16 = j3;
                            i17 = i26;
                        } catch (Exception e17) {
                            e = e17;
                            j3 = j16;
                            if (QLog.isColorLevel()) {
                            }
                            Object[] objArr2 = new Object[i3];
                            objArr2[0] = Long.valueOf(j3);
                            objArr2[1] = str;
                            notifyUI(i3, false, objArr2);
                            ExtendFriendReport.a().l(fromServiceMsg.isSuccess(), fromServiceMsg.getResultCode());
                        }
                    }
                }
                j3 = j16;
                str = string;
                boolean z27 = z18;
                int i27 = i17;
                c cVar = new c();
                cVar.f441601d = extendFriendSquareInfo$RspBody.uint32_match_count.get();
                cVar.f441602e = extendFriendSquareInfo$RspBody.uint32_match_time.get();
                cVar.f441604h = extendFriendSquareInfo$RspBody.uint32_online_num.get();
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i28 = 12;
                if (size <= 12) {
                    arrayList2.addAll(arrayList);
                } else {
                    Random random = new Random();
                    for (int i29 = 0; i29 < size; i29++) {
                        if (random.nextInt(size - i29) < i28) {
                            arrayList2.add((com.tencent.mobileqq.qqexpand.bean.feed.b) arrayList.get(i29));
                            i28--;
                        }
                    }
                }
                for (int i36 = 0; i36 < arrayList2.size(); i36++) {
                    cVar.f441603f.add(((com.tencent.mobileqq.qqexpand.bean.feed.b) arrayList2.get(i36)).mUin);
                }
                QQAppInterface qQAppInterface = this.f263975d;
                if (qQAppInterface != null) {
                    ((com.tencent.mobileqq.qqexpand.manager.c) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).w(true, cVar);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, String.format("handleGetSquareStrangerList isOver=%s cookies=%s isProfileComplete=%s isShowCard=%s maxLikeCount=%s resultCount=%d matchCount=%d limitDuration=%d onlineNum=%d", Boolean.valueOf(z16), byteArray, Boolean.valueOf(z17), Boolean.valueOf(z27), Integer.valueOf(i27), Integer.valueOf(arrayList.size()), Integer.valueOf(cVar.f441601d), Integer.valueOf(cVar.f441602e), Integer.valueOf(cVar.f441604h)));
                }
                notifyUI(2, true, new Object[]{Long.valueOf(j3), str, Boolean.valueOf(z16), byteArray, Boolean.valueOf(z17), Boolean.valueOf(z27), Integer.valueOf(i27), arrayList, cVar});
            } catch (Exception e18) {
                e = e18;
                j3 = j16;
                str = string;
            }
        } else {
            notifyUI(2, false, new Object[]{Long.valueOf(j16), string});
        }
        ExtendFriendReport.a().l(fromServiceMsg.isSuccess(), fromServiceMsg.getResultCode());
    }

    public void S2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<cmd0xcb5$RspBody>() { // from class: tencent.im.oidb.cmd0xcb5.cmd0xcb5$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0xcb5$RspBody.class);
            });
            if (QLog.isColorLevel()) {
                QLog.d("ExpandHandlerImpl", 2, "handleReportUserResponse, result = " + parseOIDBPkg);
                return;
            }
            return;
        }
        QLog.d("ExpandHandlerImpl", 1, "handleReportUserResponse error!");
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public boolean T1(String str, int i3, int i16) {
        QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, "request Unlimit Match. uin = " + LogUtil.wrapLogUin(str) + " Type= " + i3 + " tag:" + i16);
        try {
            oidb_0xe03$ReqBody oidb_0xe03_reqbody = new oidb_0xe03$ReqBody();
            oidb_0xe03_reqbody.uint64_uin.set(b3(str, "requestUnlimitMatch"));
            oidb_0xe03_reqbody.enum_matchopcode.set(1);
            oidb_0xe03_reqbody.uint32_tag_id.set(i16);
            oidb_0xe03_reqbody.uint32_sex.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, oidb_0xe03_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("match_op", 1);
            sendPbReq(makeOIDBPkg);
            return true;
        } catch (NumberFormatException e16) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "requestMatch. error = " + e16);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void U2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        oidb_0xe03$RspBody oidb_0xe03_rspbody;
        char c16;
        int i16;
        int i17;
        int i18;
        long j3;
        int i19;
        char c17;
        oidb_0xe03$RspBody oidb_0xe03_rspbody2;
        int i26;
        boolean z16;
        int i27;
        long j16;
        boolean z17;
        int i28;
        if (toServiceMsg == null) {
            QLog.e("ExpandHandlerImpl", 2, " handleUnLimitResponse request null");
            return;
        }
        String uin = toServiceMsg.getUin();
        String currentAccountUin = getCurrentAccountUin();
        int i29 = toServiceMsg.extraData.getInt("match_op");
        int a36 = a3(i29);
        if (!TextUtils.equals(currentAccountUin, uin)) {
            QLog.e("ExpandHandlerImpl", 2, " handleUnLimitResponse Wrong uin");
            return;
        }
        if (fromServiceMsg == null) {
            notifyUI(a36, false, null);
            return;
        }
        oidb_0xe03$RspBody oidb_0xe03_rspbody3 = new oidb_0xe03$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe03_rspbody3);
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse. uin = " + uin + " match_op = " + i29 + " result = " + parseOIDBPkg);
        }
        if (oidb_0xe03_rspbody3.enum_matchopcode.has()) {
            i29 = oidb_0xe03_rspbody3.enum_matchopcode.get();
        }
        int a37 = a3(i29);
        if (parseOIDBPkg != 0) {
            notifyUI(a37, false, null);
            if (QLog.isColorLevel()) {
                QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_UPDATE_MATCH_INFO false result\uff1a" + parseOIDBPkg);
                return;
            }
            return;
        }
        if (a37 == 11 || a37 == 15) {
            i3 = i29;
            int i36 = toServiceMsg.extraData.getInt(IPublicAccountBrowser.KEY_UIN_TYPE, 1044);
            oidb_0xe03_rspbody = oidb_0xe03_rspbody3;
            int i37 = oidb_0xe03_rspbody.enum_matchopretcode.has() ? oidb_0xe03_rspbody.enum_matchopretcode.get() : -1;
            String stringUtf8 = oidb_0xe03_rspbody.bytes_match_fail_wording.has() ? oidb_0xe03_rspbody.bytes_match_fail_wording.get().toStringUtf8() : "";
            ExpandManager expandManager = (ExpandManager) this.f263976e.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (expandManager != null) {
                expandManager.O0(oidb_0xe03_rspbody);
            }
            if (oidb_0xe03_rspbody.msg_match_info.has()) {
                oidb_0xe03$MatchInfo oidb_0xe03_matchinfo = oidb_0xe03_rspbody.msg_match_info.get();
                d dVar = new d();
                dVar.f441605a = String.valueOf(oidb_0xe03_rspbody.uint64_uin.get());
                dVar.f441606b = oidb_0xe03_matchinfo.bytes_sig.get().toByteArray();
                dVar.f441607c = oidb_0xe03_matchinfo.uint64_match_uin.has() ? String.valueOf(oidb_0xe03_matchinfo.uint64_match_uin.get()) : "0";
                dVar.f441608d = oidb_0xe03_matchinfo.bytes_tips_wording.has() ? oidb_0xe03_matchinfo.bytes_tips_wording.get().toStringUtf8() : "";
                if (oidb_0xe03_matchinfo.uint64_time_stamp.has()) {
                    i18 = a37;
                    j3 = oidb_0xe03_matchinfo.uint64_time_stamp.get();
                } else {
                    i18 = a37;
                    j3 = -1;
                }
                dVar.f441609e = j3;
                dVar.f441610f = oidb_0xe03_matchinfo.uint32_match_expired_time.has() ? oidb_0xe03_matchinfo.uint32_match_expired_time.get() : 30;
                dVar.f441611g = oidb_0xe03_matchinfo.bytes_nick.has() ? oidb_0xe03_matchinfo.bytes_nick.get().toStringUtf8() : "";
                String str = oidb_0xe03_matchinfo.string_report_id.has() ? oidb_0xe03_matchinfo.string_report_id.get() : "";
                if (TextUtils.isEmpty(str)) {
                    QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "string_report_id EMPTY");
                    str = "0";
                }
                dVar.f441612h = str;
                if (oidb_0xe03_rspbody.msg_match_info.msg_tag.has()) {
                    if (oidb_0xe03_rspbody.msg_match_info.msg_tag.uint32_tag_id.has()) {
                        dVar.f441613i = oidb_0xe03_rspbody.msg_match_info.msg_tag.uint32_tag_id.get();
                    } else {
                        QLog.e("ExpandHandlerImpl", 2, "msg_tag pi pei zhu ti  ID IS NULL");
                    }
                    if (oidb_0xe03_rspbody.msg_match_info.msg_tag.bytes_tag.has()) {
                        dVar.f441614j = oidb_0xe03_rspbody.msg_match_info.msg_tag.bytes_tag.get().toStringUtf8();
                    }
                } else {
                    QLog.e("ExpandHandlerImpl", 2, "msg_tag pi pei zhu ti   not has");
                }
                if (oidb_0xe03_rspbody.msg_match_info.msg_match_uin_data.has()) {
                    if (dVar.f441615k == null) {
                        com.tencent.mobileqq.qqexpand.bean.chat.a aVar = new com.tencent.mobileqq.qqexpand.bean.chat.a();
                        dVar.f441615k = aVar;
                        aVar.f263444a = dVar.f441607c;
                    }
                    E2(oidb_0xe03_rspbody.msg_match_info.msg_match_uin_data, dVar.f441615k);
                } else {
                    QLog.e("ExpandHandlerImpl", 2, "msg_match_uin_data  not has");
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("handleMatchResponse type =");
                    i19 = i18;
                    sb5.append(i19);
                    Object[] objArr = {sb5.toString(), " uin = ", uin, ", match_op = ", Integer.valueOf(i3), " retCode = ", Integer.valueOf(i37), " matchInfo = ", dVar.toString(), " errMsg = ", stringUtf8};
                    c17 = 2;
                    QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, objArr);
                } else {
                    i19 = i18;
                    c17 = 2;
                }
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(i37);
                objArr2[1] = dVar;
                objArr2[c17] = Integer.valueOf(i36);
                objArr2[3] = stringUtf8;
                notifyUI(i19, true, objArr2);
                i16 = 1;
                i17 = 3;
            } else {
                if (QLog.isColorLevel()) {
                    Object[] objArr3 = {"handleMatchResponse type =" + a37, " uin = ", uin, ", match_op = ", Integer.valueOf(i3), " retCode = ", Integer.valueOf(i37), " errMsg = ", stringUtf8};
                    c16 = 2;
                    QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, objArr3);
                } else {
                    c16 = 2;
                }
                Object[] objArr4 = new Object[4];
                objArr4[0] = Integer.valueOf(i37);
                i16 = 1;
                objArr4[1] = null;
                objArr4[c16] = Integer.valueOf(i36);
                i17 = 3;
                objArr4[3] = stringUtf8;
                notifyUI(a37, true, objArr4);
            }
        } else if (a37 == 12) {
            int i38 = oidb_0xe03_rspbody3.enum_matchopretcode.has() ? oidb_0xe03_rspbody3.enum_matchopretcode.get() : -1;
            if (QLog.isColorLevel()) {
                QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse TYPE_CANCLE_UNLIMIT_MATCH. uin = ", uin, ", match_op = ", Integer.valueOf(i29), " retCode = ", Integer.valueOf(i38));
            }
            notifyUI(12, i38 == 0, null);
            i3 = i29;
            oidb_0xe03_rspbody = oidb_0xe03_rspbody3;
            i17 = 3;
            i16 = 1;
        } else {
            if (a37 == 13) {
                int i39 = oidb_0xe03_rspbody3.uint32_switch.has() ? oidb_0xe03_rspbody3.uint32_switch.get() : 0;
                ArrayList arrayList = new ArrayList();
                if (oidb_0xe03_rspbody3.rpt_tag.has()) {
                    for (int i46 = 0; i46 < oidb_0xe03_rspbody3.rpt_tag.size(); i46++) {
                        f fVar = new f();
                        oidb_0xe03$TagInfo oidb_0xe03_taginfo = oidb_0xe03_rspbody3.rpt_tag.get(i46);
                        fVar.f441618a = oidb_0xe03_taginfo.uint32_tag_id.get();
                        fVar.f441619b = oidb_0xe03_taginfo.bytes_tag.has() ? oidb_0xe03_taginfo.bytes_tag.get().toStringUtf8() : "";
                        fVar.f441620c = oidb_0xe03_taginfo.uint32_hot_flag.has() ? oidb_0xe03_taginfo.uint32_hot_flag.get() : 0;
                        arrayList.add(fVar);
                    }
                }
                int i47 = oidb_0xe03_rspbody3.uint32_count.has() ? oidb_0xe03_rspbody3.uint32_count.get() : 1212432;
                ArrayList arrayList2 = new ArrayList();
                if (oidb_0xe03_rspbody3.uint64_uin_list.has()) {
                    for (int i48 = 0; i48 < oidb_0xe03_rspbody3.uint64_uin_list.size(); i48++) {
                        arrayList2.add(oidb_0xe03_rspbody3.uint64_uin_list.get(i48).toString());
                    }
                }
                boolean z18 = i39 != 0;
                long j17 = oidb_0xe03_rspbody3.uint64_voice_match_flag.has() ? oidb_0xe03_rspbody3.uint64_voice_match_flag.get() : -1L;
                if (oidb_0xe03_rspbody3.uint32_flare_switch.has()) {
                    i27 = i29;
                    j16 = oidb_0xe03_rspbody3.uint32_flare_switch.get();
                } else {
                    i27 = i29;
                    j16 = -1;
                }
                boolean z19 = j17 == 1;
                oidb_0xe03_rspbody2 = oidb_0xe03_rspbody3;
                if (j16 == 1) {
                    i28 = 5;
                    z17 = true;
                } else {
                    z17 = false;
                    i28 = 5;
                }
                Object[] objArr5 = new Object[i28];
                objArr5[0] = arrayList;
                objArr5[1] = Boolean.valueOf(z18);
                objArr5[2] = Integer.valueOf(i47);
                objArr5[3] = arrayList2;
                objArr5[4] = Boolean.valueOf(z17);
                notifyUI(13, true, objArr5);
                com.tencent.mobileqq.qqexpand.manager.c.B(this.f263975d, Boolean.valueOf(z18));
                com.tencent.mobileqq.qqexpand.manager.c.D(this.f263975d, Boolean.valueOf(z19));
                com.tencent.mobileqq.qqexpand.manager.c.C(this.f263975d, arrayList);
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    i3 = i27;
                    sb6.append(i3);
                    sb6.append(" tagList  :");
                    sb6.append(arrayList.toString());
                    sb6.append(" \u52ff\u6270 switch:");
                    sb6.append(z18);
                    sb6.append(" voiceMatchF: ");
                    sb6.append(j17);
                    sb6.append(" bSingalBombFlagOpen");
                    sb6.append(j16);
                    sb6.append(" uinList size");
                    sb6.append(arrayList2.size());
                    QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_GET_UNLIMIT_TAG uin = ", uin, ", match_op = ", sb6.toString());
                } else {
                    i3 = i27;
                }
            } else {
                i3 = i29;
                oidb_0xe03_rspbody2 = oidb_0xe03_rspbody3;
                if (a37 == 14) {
                    boolean z26 = toServiceMsg.extraData.getBoolean("open", false);
                    if (QLog.isColorLevel()) {
                        z16 = 1;
                        QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_SET_UNLIMIT_SWITCH uin = ", uin, ", open = ", Boolean.valueOf(z26));
                    } else {
                        z16 = 1;
                    }
                    com.tencent.mobileqq.qqexpand.manager.c.B(this.f263975d, Boolean.valueOf(z26));
                    notifyUI(14, z16, null);
                    i26 = z16;
                } else {
                    i26 = 1;
                    if (a37 == 15) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_GET_UNLIMIT_FRIEND_INFO uin = ", uin, ", match_op = ", Integer.valueOf(i3));
                        }
                    } else if (a37 == 24) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_OPEN_SIGNAL_BOMB    match_op = ", Integer.valueOf(i3));
                        }
                    } else if (a37 == 25) {
                        ((com.tencent.mobileqq.qqexpand.manager.e) this.f263976e.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).Q();
                        if (QLog.isColorLevel()) {
                            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "handleMatchResponse. TYPE_CLOSE_SIGNAL_BOMB   match_op = ", Integer.valueOf(i3));
                        }
                    }
                }
                i16 = i26;
                oidb_0xe03_rspbody = oidb_0xe03_rspbody2;
                i17 = 3;
            }
            oidb_0xe03_rspbody = oidb_0xe03_rspbody2;
            i17 = 3;
            i16 = 1;
        }
        if (i3 == i16 || i3 == i17 || i3 == 5) {
            K2(fromServiceMsg, oidb_0xe03_rspbody);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void X(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i("ExpandHandlerImpl", 1, String.format("reqThrowToColdPalace uin=%s uinType=%d", str, Integer.valueOf(i3)));
        try {
            oidb_0xeae$ReqBody oidb_0xeae_reqbody = new oidb_0xeae$ReqBody();
            oidb_0xeae_reqbody.uint64_black_uin.set(Long.parseLong(str));
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xeae", 3758, 1, oidb_0xeae_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("uin", str);
            makeOIDBPkg.extraData.putInt("uinType", i3);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("ExpandHandlerImpl", 1, "reqThrowToColdPalace exception:" + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void d1(MessageRecord messageRecord) {
        boolean z16 = false;
        if (messageRecord != null && (messageRecord instanceof MessageForLimitChatConfirm)) {
            MessageForLimitChatConfirm messageForLimitChatConfirm = (MessageForLimitChatConfirm) messageRecord;
            com.tencent.mobileqq.qqexpand.match.d dVar = new com.tencent.mobileqq.qqexpand.match.d();
            dVar.f263938c = messageForLimitChatConfirm.bEnterMsg;
            dVar.f263939d = messageForLimitChatConfirm.leaveChatType;
            dVar.f263941f = messageForLimitChatConfirm.timeStamp;
            dVar.f263936a = messageForLimitChatConfirm.frienduin;
            dVar.f263937b = messageForLimitChatConfirm.SenderNickName;
            dVar.f263943h = messageForLimitChatConfirm.c2cExpiredTime;
            dVar.f263940e = messageForLimitChatConfirm.leftChatTime;
            dVar.f263944i = messageForLimitChatConfirm.tipsWording;
            dVar.f263942g = messageForLimitChatConfirm.matchExpiredTime;
            dVar.f263945j = messageForLimitChatConfirm.readyTs;
            QLog.i("ExpandHandlerImplExtendFriendLimitChat", 2, "HandleC2CConfirmOrCancelMsg  info\uff1a" + dVar.toString());
            if (!com.tencent.mobileqq.service.message.remote.a.c(messageForLimitChatConfirm.issend)) {
                long j3 = messageForLimitChatConfirm.time;
                try {
                    long longValue = Long.valueOf(messageForLimitChatConfirm.frienduin).longValue();
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("HandleC2CConfirmMsg,uin: %s,  id: %d", Long.valueOf(longValue), Long.valueOf(j3)));
                    }
                    if (j3 == -1 || j3 == 0 || longValue == -1) {
                        return;
                    }
                    msg_svc$PbC2CReadedReportReq.UinPairReadInfo uinPairReadInfo = new msg_svc$PbC2CReadedReportReq.UinPairReadInfo();
                    uinPairReadInfo.peer_uin.set(longValue);
                    uinPairReadInfo.last_read_time.set((int) j3);
                    msg_svc$PbC2CReadedReportReq msg_svc_pbc2creadedreportreq = new msg_svc$PbC2CReadedReportReq();
                    msg_svc_pbc2creadedreportreq.pair_info.add(uinPairReadInfo);
                    byte[] F0 = this.f263975d.getMsgHandler().Y2().F0();
                    if (F0 != null) {
                        msg_svc_pbc2creadedreportreq.sync_cookie.set(ByteStringMicro.copyFrom(F0));
                    }
                    msg_svc$PbMsgReadedReportReq msg_svc_pbmsgreadedreportreq = new msg_svc$PbMsgReadedReportReq();
                    msg_svc_pbmsgreadedreportreq.c2c_read_report.set(msg_svc_pbc2creadedreportreq);
                    this.f263975d.getMsgHandler().getProcessor(ProcessorDispatcherInterface.PROCESSOR_KEY_C2C).w(msg_svc_pbmsgreadedreportreq);
                } catch (NumberFormatException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.msg.HandleC2CConfirmMsg sendReadConfirm_PB", 2, e16, new Object[0]);
                        return;
                    }
                    return;
                }
            }
            z16 = true;
        }
        if (z16) {
            return;
        }
        QLog.e("ExpandHandlerImplExtendFriendLimitChat", 2, "HandleC2CConfirmMsg failed");
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xb4b");
            this.allowCmdSet.add("OidbSvc.0xb4b_6");
            this.allowCmdSet.add("OidbSvc.0xb4c");
            this.allowCmdSet.add("OidbSvc.0xb51");
            this.allowCmdSet.add("OidbSvc.0xcb5");
            this.allowCmdSet.add("OidbSvc.0xdb1_2");
            this.allowCmdSet.add("OidbSvc.0xe52_3");
            this.allowCmdSet.add("OidbSvc.0xe03");
            this.allowCmdSet.add("OidbSvc.0xe09");
            this.allowCmdSet.add("OidbSvc.0xe51");
            this.allowCmdSet.add("OidbSvc.0xe67");
            this.allowCmdSet.add("OidbSvc.0xeae");
            this.allowCmdSet.add("OidbSvc.0xeaf");
            this.allowCmdSet.add("OidbSvc.0x1004");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public boolean k0(String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "setUnlimitMatchStatus. uin = " + str + " bopen: " + z16);
        }
        try {
            oidb_0xe03$ReqBody oidb_0xe03_reqbody = new oidb_0xe03$ReqBody();
            oidb_0xe03_reqbody.uint64_uin.set(b3(str, "setUnlimitMatchStatus"));
            if (z16) {
                oidb_0xe03_reqbody.uint32_switch.set(1);
            } else {
                oidb_0xe03_reqbody.uint32_switch.set(0);
            }
            oidb_0xe03_reqbody.enum_matchopcode.set(4);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, oidb_0xe03_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("match_op", 4);
            makeOIDBPkg.extraData.putBoolean("open", z16);
            sendPbReq(makeOIDBPkg);
            return true;
        } catch (NumberFormatException e16) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "requestMatch. error = " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public boolean k1(String str) {
        vg2.b w3;
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "getUnlimitMatchBaseInfo. uin = " + str);
        }
        try {
            oidb_0xe03$ReqBody oidb_0xe03_reqbody = new oidb_0xe03$ReqBody();
            oidb_0xe03_reqbody.uint64_uin.set(b3(str, "getUnlimitMatchBaseInfo"));
            oidb_0xe03_reqbody.enum_matchopcode.set(3);
            oidb_0xe03_reqbody.uint64_client_version.set(833L);
            ExpandManager expandManager = (ExpandManager) this.f263976e.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (expandManager != null && (w3 = expandManager.w()) != null) {
                oidb_0xe03$GPS oidb_0xe03_gps = new oidb_0xe03$GPS();
                oidb_0xe03_gps.int32_lon.set(w3.f441598b);
                oidb_0xe03_gps.int32_lat.set(w3.f441597a);
                oidb_0xe03_gps.int32_alt.set(w3.f441599c);
                oidb_0xe03_gps.int32_type.set(w3.f441600d);
                oidb_0xe03$LBSInfo oidb_0xe03_lbsinfo = new oidb_0xe03$LBSInfo();
                oidb_0xe03_lbsinfo.msg_gps.set(oidb_0xe03_gps);
                oidb_0xe03_reqbody.msg_lbs_info.set(oidb_0xe03_lbsinfo);
                QLog.d("ExpandHandlerImpl", 1, "getUnlimitMatchBaseInfo. with msg_lbs_info info ");
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, oidb_0xe03_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("match_op", 3);
            sendPbReq(makeOIDBPkg);
            return true;
        } catch (NumberFormatException e16) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "requestMatch. error = " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public boolean m1(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "cancleUnlimitMatch. uin = " + str);
        }
        try {
            oidb_0xe03$ReqBody oidb_0xe03_reqbody = new oidb_0xe03$ReqBody();
            oidb_0xe03_reqbody.uint64_uin.set(b3(str, "cancleUnlimitMatch"));
            oidb_0xe03_reqbody.enum_matchopcode.set(2);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe03", 3587, 0, oidb_0xe03_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("match_op", 2);
            sendPbReq(makeOIDBPkg);
            return true;
        } catch (NumberFormatException e16) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "requestMatch. error = " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ExpandObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        if ("OidbSvc.0xb4b".equals(fromServiceMsg.getServiceCmd())) {
            L2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xb4c".equals(fromServiceMsg.getServiceCmd())) {
            R2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xb51".equals(fromServiceMsg.getServiceCmd())) {
            O2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xcb5".equals(fromServiceMsg.getServiceCmd())) {
            S2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xdb1_2".equals(fromServiceMsg.getServiceCmd())) {
            N2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xe52_3".equals(fromServiceMsg.getServiceCmd())) {
            I2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xb4b_6".equals(fromServiceMsg.getServiceCmd())) {
            V2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xe03".equals(fromServiceMsg.getServiceCmd())) {
            U2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xe09".equals(fromServiceMsg.getServiceCmd())) {
            P2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xe51".equals(fromServiceMsg.getServiceCmd())) {
            Q2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xe67".equals(fromServiceMsg.getServiceCmd())) {
            M2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0xeae".equals(fromServiceMsg.getServiceCmd())) {
            T2(toServiceMsg, fromServiceMsg, obj);
        } else {
            "OidbSvc.0xeaf".equals(fromServiceMsg.getServiceCmd());
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void updateRedPoint() {
        notifyUI(17, true, Integer.valueOf(MatchChatMsgUtil.d(this.f263975d)));
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void y2(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, "reportUser, uin: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.d("ExpandHandlerImpl", 1, "reportUser, uin is empty!");
            return;
        }
        try {
            cmd0xcb5$ReqBody cmd0xcb5_reqbody = new cmd0xcb5$ReqBody();
            cmd0xcb5_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
            cmd0xcb5_reqbody.uint32_report_type.set(0);
            cmd0xcb5_reqbody.str_report_conent.set("");
            cmd0xcb5_reqbody.uint64_report_time.set(NetConnInfoCenter.getServerTimeMillis());
            sendPbReq(makeOIDBPkg("OidbSvc.0xcb5", 3253, 0, cmd0xcb5_reqbody.toByteArray()));
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.d("ExpandHandlerImpl", 1, "reportUser exception:", e16);
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public int z1() {
        return f263974f.incrementAndGet();
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f263977d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f263978e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f263979f;

        a(String str, int i3, int i16) {
            this.f263977d = str;
            this.f263978e = i3;
            this.f263979f = i16;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16) {
                FriendsManager friendsManager = (FriendsManager) ExpandHandlerImpl.this.f263975d.getManager(QQManagerFactory.FRIENDS_MANAGER);
                Card q16 = friendsManager.q(this.f263977d);
                q16.clothesId = this.f263978e;
                q16.fontId = this.f263979f;
                q16.updateTime = NetConnInfoCenter.getServerTimeMillis();
                friendsManager.p0(q16);
                ExpandHandlerImpl.this.notifyUI(1, z16, null);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public boolean U1(List<Long> list) {
        return w1(list, 0);
    }

    public boolean X2() {
        vg2.b w3;
        try {
            oidb_0xe67$ReqBody oidb_0xe67_reqbody = new oidb_0xe67$ReqBody();
            oidb_0xe67_reqbody.uint32_action.set(0);
            com.tencent.mobileqq.qqexpand.manager.e eVar = (com.tencent.mobileqq.qqexpand.manager.e) this.f263976e.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
            if (eVar != null && (w3 = eVar.w()) != null) {
                oidb_0xe67$LBSInfo oidb_0xe67_lbsinfo = new oidb_0xe67$LBSInfo();
                oidb_0xe67$GPS oidb_0xe67_gps = new oidb_0xe67$GPS();
                oidb_0xe67_gps.int32_lon.set(w3.f441598b);
                oidb_0xe67_gps.int32_lat.set(w3.f441597a);
                oidb_0xe67_gps.int32_alt.set(w3.f441599c);
                oidb_0xe67_gps.int32_type.set(w3.f441600d);
                oidb_0xe67_lbsinfo.msg_gps.set(oidb_0xe67_gps);
                oidb_0xe67_reqbody.msg_lbs_info.set(oidb_0xe67_lbsinfo);
                QLog.d("ExpandHandlerImpl", 1, "QuitExtendFriend. with msg_lbs_info info ");
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe67", 3687, 1, oidb_0xe67_reqbody.toByteArray());
            makeOIDBPkg.extraData.putInt("uint32_action", 0);
            sendPbReq(makeOIDBPkg);
            return true;
        } catch (NumberFormatException e16) {
            QLog.d("ExpandHandlerImplExtendFriendLimitChat", 2, "QuitExtendFriend. error = " + e16);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public int l1(String str, boolean z16) {
        QLog.i("ExpandHandlerImpl", 1, String.format("getExtendFriendInfo uin=%s", str));
        int incrementAndGet = f263974f.incrementAndGet();
        try {
            GetExtendFriendInfo$ReqBody getExtendFriendInfo$ReqBody = new GetExtendFriendInfo$ReqBody();
            getExtendFriendInfo$ReqBody.uint64_uin.set(Long.parseLong(str));
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xb51", 2897, 0, getExtendFriendInfo$ReqBody.toByteArray());
            makeOIDBPkg.extraData.putString("uin", str);
            makeOIDBPkg.extraData.putBoolean("onlyStrangerInfo", z16);
            makeOIDBPkg.extraData.putInt("getStrangerInfoSeq", incrementAndGet);
            makeOIDBPkg.setTimeout(10000L);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("ExpandHandlerImpl", 1, "getExtendFriendInfo exception:" + e16.getMessage());
        }
        return incrementAndGet;
    }

    private long b3(String str, String str2) {
        if (str2 == null) {
            str2 = "unknown";
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e16) {
            QLog.e("ExpandHandlerImpl", 2, str2 + " parse err " + e16.toString());
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList arrayList;
        try {
            oidb_0xe09$RspBody oidb_0xe09_rspbody = new oidb_0xe09$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe09_rspbody);
            if (parseOIDBPkg == 0) {
                arrayList = new ArrayList();
                try {
                    if (oidb_0xe09_rspbody.rpt_online_info.has()) {
                        for (oidb_0xe09$OnlineInfo oidb_0xe09_onlineinfo : oidb_0xe09_rspbody.rpt_online_info.get()) {
                            if (oidb_0xe09_onlineinfo.uint64_friend_uin.has()) {
                                arrayList.add(Long.valueOf(oidb_0xe09_onlineinfo.uint64_friend_uin.get()));
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ExpandHandlerImpl", 2, String.format("handleGetExtendFriendOnlineState size=%s", Integer.valueOf(arrayList.size())));
                    }
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("ExpandHandlerImpl", 1, "handleGetExtendFriendOnlineState fail.", e);
                    if (toServiceMsg == null) {
                    }
                }
            } else {
                QLog.e("ExpandHandlerImpl", 1, String.format("handleGetExtendFriendOnlineState result=%s", Integer.valueOf(parseOIDBPkg)));
                arrayList = null;
            }
        } catch (Exception e17) {
            e = e17;
            arrayList = null;
        }
        if (toServiceMsg == null) {
            try {
                List<Long> list = (ArrayList) toServiceMsg.getAttribute("reqList");
                int intValue = ((Integer) toServiceMsg.getAttribute("startIndex")).intValue();
                int intValue2 = ((Integer) toServiceMsg.getAttribute("count")).intValue();
                Integer num = (Integer) toServiceMsg.getAttribute("reqTag");
                List<Long> list2 = (ArrayList) toServiceMsg.getAttribute("resultList");
                if (list2 == null) {
                    list2 = new ArrayList<>();
                }
                List<Long> list3 = list2;
                if (arrayList != null && !arrayList.isEmpty()) {
                    list3.addAll(arrayList);
                }
                int i3 = intValue + intValue2;
                if (i3 < (list == null ? 0 : list.size())) {
                    G2(list, i3, intValue2, list3, num.intValue());
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ExpandHandlerImpl", 2, String.format("handleGetExtendFriendOnlineState request finished. resultList=%s", list3));
                }
                notifyUI(19, true, new Object[]{list3, num, list});
            } catch (Exception e18) {
                QLog.e("ExpandHandlerImpl", 1, "handleGetExtendFriendOnlineState fail.", e18);
                notifyUI(19, false, null);
            }
        }
    }

    private void T2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String string = toServiceMsg.extraData.getString("uin", "");
        int i3 = toServiceMsg.extraData.getInt("uinType", 0);
        oidb_0xeae$RspBody oidb_0xeae_rspbody = new oidb_0xeae$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xeae_rspbody);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("uin");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(string);
        sb5.append("|");
        sb5.append("uinType");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(i3);
        sb5.append("|");
        sb5.append("result");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(parseOIDBPkg);
        sb5.append("|");
        if (parseOIDBPkg != 0 && parseOIDBPkg != 33) {
            notifyUI(26, false, new Object[]{string, Integer.valueOf(i3), Boolean.FALSE});
        } else {
            int i16 = (int) oidb_0xeae_rspbody.uint64_black_times.get();
            String str = oidb_0xeae_rspbody.str_black_times_used_up_title.get();
            String str2 = oidb_0xeae_rspbody.str_black_times_used_up_tips.get();
            String str3 = oidb_0xeae_rspbody.str_black_times_tips.get();
            ColdPalaceHelper b16 = ColdPalaceHelper.b(this.f263975d);
            b16.q(1, str);
            b16.q(2, str2);
            b16.q(0, str3);
            b16.u(i16);
            boolean z16 = parseOIDBPkg == 33;
            sb5.append("isUsedUp");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(z16);
            sb5.append("|");
            sb5.append("skillTimesLeft");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(i16);
            sb5.append("|");
            sb5.append("skillUseUpTitle");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str);
            sb5.append("|");
            sb5.append("skillUseUpWording");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str2);
            sb5.append("|");
            sb5.append("skillUseTip");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(str3);
            sb5.append("|");
            if (parseOIDBPkg == 0) {
                this.f263975d.getMessageFacade().X1(AppConstants.MATCH_CHAT_UIN, i3, string, this.f263975d.getCurrentAccountUin());
            }
            notifyUI(26, parseOIDBPkg == 0, new Object[]{string, Integer.valueOf(i3), Boolean.valueOf(z16)});
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 1, "handleThrowToColdPalace," + sb5.toString());
        }
    }

    private void W2(Object[] objArr, String str) {
        if ((objArr instanceof Object[]) && objArr.length == 9) {
            int intValue = ((Integer) objArr[0]).intValue();
            int intValue2 = ((Integer) objArr[1]).intValue();
            long longValue = ((Long) objArr[2]).longValue();
            String str2 = (String) objArr[3];
            String str3 = (String) objArr[4];
            String str4 = (String) objArr[5];
            String str5 = (String) objArr[6];
            String str6 = (String) objArr[7];
            boolean booleanValue = ((Boolean) objArr[8]).booleanValue();
            ColdPalaceHelper b16 = ColdPalaceHelper.b(this.f263975d);
            b16.u(intValue);
            b16.r(intValue2);
            b16.t(longValue, NetConnInfoCenter.getServerTime());
            b16.s(booleanValue);
            b16.q(0, str2);
            b16.q(2, str3);
            b16.q(1, str4);
            b16.q(3, str5);
            if (str6 != null) {
                b16.q(4, str6);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ExpandHandlerImpl", 2, "onGetColdPalaceData from" + ContainerUtils.KEY_VALUE_DELIMITER + str + "[\nshowGrayTipEntry" + ContainerUtils.KEY_VALUE_DELIMITER + booleanValue + "|\nskillTimesLeft" + ContainerUtils.KEY_VALUE_DELIMITER + intValue + "|\nmeInColdPalaceTimes" + ContainerUtils.KEY_VALUE_DELIMITER + intValue2 + "|\npunishLeftTime" + ContainerUtils.KEY_VALUE_DELIMITER + longValue + "|\nstrSkillUseTip" + ContainerUtils.KEY_VALUE_DELIMITER + str2 + "|\nstrSkillUseupTip" + ContainerUtils.KEY_VALUE_DELIMITER + str3 + "|\nstrSkillUseupTitle" + ContainerUtils.KEY_VALUE_DELIMITER + str4 + "|\nstrMeInColdPalaceTip" + ContainerUtils.KEY_VALUE_DELIMITER + str5 + "|\nstrForbbidenExtendTip" + ContainerUtils.KEY_VALUE_DELIMITER + str6 + "|\n]");
            }
            notifyUI(28, true, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0371  */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.os.Bundle, android.os.BaseBundle] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v33, types: [com.tencent.mobileqq.qqexpand.bean.feed.b] */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.os.Bundle, android.os.BaseBundle] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.os.Bundle, android.os.BaseBundle] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        char c16;
        int i3;
        ?? r56;
        ToServiceMsg toServiceMsg2;
        boolean z16;
        Card card;
        BusinessHandler businessHandler;
        String str;
        ?? r26;
        Card card2;
        boolean z17;
        boolean z18;
        Card card3;
        String stringUtf8;
        String str2;
        String str3;
        long j3;
        int i16;
        int i17;
        int resultCode = fromServiceMsg.getResultCode();
        QLog.i("ExpandHandlerImpl", 1, String.format("handleGetExtendFriendInfo resultCode=%d", Integer.valueOf(resultCode)));
        Card card4 = null;
        if (resultCode == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                z17 = oidb_sso_oidbssopkg.uint32_result.get() == 0;
                QLog.i("ExpandHandlerImpl", 1, "handleGetExtendFriendInfo isSuccess=" + z17);
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                str = "ExpandHandlerImpl";
            }
            if (z17 && oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                GetExtendFriendInfo$RspBody getExtendFriendInfo$RspBody = new GetExtendFriendInfo$RspBody();
                getExtendFriendInfo$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                String string = toServiceMsg.extraData.getString("uin");
                if (getExtendFriendInfo$RspBody.uint64_uin.has() && String.valueOf(getExtendFriendInfo$RspBody.uint64_uin.get()).equals(string)) {
                    if (getExtendFriendInfo$RspBody.bytes_declaration.has()) {
                        try {
                            stringUtf8 = getExtendFriendInfo$RspBody.bytes_declaration.get().toStringUtf8();
                        } catch (InvalidProtocolBufferMicroException e17) {
                            e = e17;
                            str = "ExpandHandlerImpl";
                            r26 = 0;
                            i3 = 2;
                            e.printStackTrace();
                            c16 = 1;
                            QLog.e(str, 1, "handleGetExtendFriendInfo exception:" + e.getMessage());
                            z16 = false;
                            card2 = r26;
                            card = card4;
                            r56 = 0;
                            card4 = card2;
                            toServiceMsg2 = toServiceMsg;
                            if (toServiceMsg2.extraData.getBoolean("onlyStrangerInfo", r56)) {
                            }
                            int i18 = toServiceMsg2.extraData.getInt("getStrangerInfoSeq", r56);
                            Object[] objArr = new Object[i3];
                            objArr[r56] = card4;
                            objArr[c16] = Integer.valueOf(i18);
                            businessHandler.notifyUI(9, z16, objArr);
                        }
                    } else {
                        stringUtf8 = null;
                    }
                    String stringUtf82 = getExtendFriendInfo$RspBody.bytes_voice_url.has() ? getExtendFriendInfo$RspBody.bytes_voice_url.get().toStringUtf8() : null;
                    int i19 = getExtendFriendInfo$RspBody.uint32_popularity.has() ? getExtendFriendInfo$RspBody.uint32_popularity.get() : 0;
                    long j16 = getExtendFriendInfo$RspBody.uint64_update_time.has() ? getExtendFriendInfo$RspBody.uint64_update_time.get() : 0L;
                    int i26 = getExtendFriendInfo$RspBody.uint32_voice_duration.has() ? getExtendFriendInfo$RspBody.uint32_voice_duration.get() : 0;
                    PersonalInfo$ReqBody personalInfo$ReqBody = new PersonalInfo$ReqBody();
                    personalInfo$ReqBody.mergeFrom(getExtendFriendInfo$RspBody.bytes_personalization.get().toByteArray());
                    int i27 = personalInfo$ReqBody.fontid.get();
                    int i28 = personalInfo$ReqBody.fonttype.get();
                    int i29 = personalInfo$ReqBody.itemid.get();
                    if (getExtendFriendInfo$RspBody.rpt_school_info.has() && getExtendFriendInfo$RspBody.rpt_school_info.get().get(0).has()) {
                        GetExtendFriendInfo$schoolInfo getExtendFriendInfo$schoolInfo = getExtendFriendInfo$RspBody.rpt_school_info.get().get(0);
                        String str4 = getExtendFriendInfo$schoolInfo.str_school_id.get();
                        String str5 = getExtendFriendInfo$schoolInfo.str_school_name.get();
                        long j17 = getExtendFriendInfo$schoolInfo.uint64_state.get();
                        int i36 = getExtendFriendInfo$schoolInfo.uint32_idx.get();
                        j3 = j17;
                        i17 = getExtendFriendInfo$schoolInfo.uint32_category.get();
                        i16 = i36;
                        str3 = str5;
                        str2 = str4;
                    } else {
                        str2 = null;
                        str3 = null;
                        j3 = -1;
                        i16 = -1;
                        i17 = -1;
                    }
                    int i37 = i26;
                    int i38 = i19;
                    String str6 = stringUtf82;
                    String str7 = stringUtf8;
                    z18 = z17;
                    String str8 = str2;
                    String str9 = str3;
                    try {
                        Card Z2 = Z2(string, stringUtf8, stringUtf82, i38, j16, i37, i27, i28, i29, str8, str9, j3, i16, i17);
                        r26 = new com.tencent.mobileqq.qqexpand.bean.feed.b();
                        try {
                            r26.mUin = string;
                            r26.mDeclaration = str7;
                            r26.mVoiceUrl = str6;
                            r26.mPopularity = i38;
                            r26.mVoiceDuration = i37;
                            r26.mGender = getExtendFriendInfo$RspBody.uint32_gender.get();
                            r26.mNickName = getExtendFriendInfo$RspBody.str_nick.get();
                            r26.mVipHide = getExtendFriendInfo$RspBody.uint32_show_vip_info_flag.get() == 0;
                            r26.mBigVipHide = getExtendFriendInfo$RspBody.uint32_bigvip_open.get() == 0;
                            r26.mBigVipLevel = getExtendFriendInfo$RspBody.uint32_bigvip_level.get();
                            r26.mVipType = getExtendFriendInfo$RspBody.uint32_vip_flag.get();
                            r26.mVipLevel = getExtendFriendInfo$RspBody.uint32_svip_level.get();
                            r26.mTemplateId = getExtendFriendInfo$RspBody.uint32_vipicon_id.get();
                            if (!TextUtils.isEmpty(str9) || !TextUtils.isEmpty(str8)) {
                                r26.mSchoolInfos = new ArrayList();
                                b.C8313b c8313b = new b.C8313b();
                                c8313b.f263490c = str9;
                                c8313b.f263488a = str8;
                                c8313b.f263489b = j3;
                            }
                            r26.mLabelInfos = new ArrayList();
                            if (getExtendFriendInfo$RspBody.rpt_label_info.has()) {
                                for (int i39 = 0; i39 < getExtendFriendInfo$RspBody.rpt_label_info.get().size(); i39++) {
                                    b.a aVar = new b.a();
                                    aVar.f263486a = getExtendFriendInfo$RspBody.rpt_label_info.get().get(i39).uint64_label_id.get();
                                    aVar.f263487b = getExtendFriendInfo$RspBody.rpt_label_info.get().get(i39).str_label_name.has() ? getExtendFriendInfo$RspBody.rpt_label_info.get().get(i39).str_label_name.get() : null;
                                    r26.mLabelInfos.add(aVar);
                                }
                            }
                            if (QLog.isColorLevel()) {
                                str = "ExpandHandlerImpl";
                                i3 = 2;
                                try {
                                    QLog.d(str, 2, "handleGetExtendFriendInfo: " + r26.mUin + " " + getExtendFriendInfo$RspBody.uint32_show_vip_info_flag.get() + " " + getExtendFriendInfo$RspBody.uint32_vip_flag.get() + " " + getExtendFriendInfo$RspBody.uint32_svip_level.get());
                                } catch (InvalidProtocolBufferMicroException e18) {
                                    e = e18;
                                    e.printStackTrace();
                                    c16 = 1;
                                    QLog.e(str, 1, "handleGetExtendFriendInfo exception:" + e.getMessage());
                                    z16 = false;
                                    card2 = r26;
                                    card = card4;
                                    r56 = 0;
                                    card4 = card2;
                                    toServiceMsg2 = toServiceMsg;
                                    if (toServiceMsg2.extraData.getBoolean("onlyStrangerInfo", r56)) {
                                    }
                                    int i182 = toServiceMsg2.extraData.getInt("getStrangerInfoSeq", r56);
                                    Object[] objArr2 = new Object[i3];
                                    objArr2[r56] = card4;
                                    objArr2[c16] = Integer.valueOf(i182);
                                    businessHandler.notifyUI(9, z16, objArr2);
                                }
                            } else {
                                i3 = 2;
                            }
                            card4 = Z2;
                            card3 = r26;
                            z16 = z18;
                            c16 = 1;
                            card2 = card3;
                        } catch (InvalidProtocolBufferMicroException e19) {
                            e = e19;
                            str = "ExpandHandlerImpl";
                            r26 = r26;
                            i3 = 2;
                            e.printStackTrace();
                            c16 = 1;
                            QLog.e(str, 1, "handleGetExtendFriendInfo exception:" + e.getMessage());
                            z16 = false;
                            card2 = r26;
                            card = card4;
                            r56 = 0;
                            card4 = card2;
                            toServiceMsg2 = toServiceMsg;
                            if (toServiceMsg2.extraData.getBoolean("onlyStrangerInfo", r56)) {
                            }
                            int i1822 = toServiceMsg2.extraData.getInt("getStrangerInfoSeq", r56);
                            Object[] objArr22 = new Object[i3];
                            objArr22[r56] = card4;
                            objArr22[c16] = Integer.valueOf(i1822);
                            businessHandler.notifyUI(9, z16, objArr22);
                        }
                    } catch (InvalidProtocolBufferMicroException e26) {
                        e = e26;
                        str = "ExpandHandlerImpl";
                        i3 = 2;
                        r26 = 0;
                        e.printStackTrace();
                        c16 = 1;
                        QLog.e(str, 1, "handleGetExtendFriendInfo exception:" + e.getMessage());
                        z16 = false;
                        card2 = r26;
                        card = card4;
                        r56 = 0;
                        card4 = card2;
                        toServiceMsg2 = toServiceMsg;
                        if (toServiceMsg2.extraData.getBoolean("onlyStrangerInfo", r56)) {
                        }
                        int i18222 = toServiceMsg2.extraData.getInt("getStrangerInfoSeq", r56);
                        Object[] objArr222 = new Object[i3];
                        objArr222[r56] = card4;
                        objArr222[c16] = Integer.valueOf(i18222);
                        businessHandler.notifyUI(9, z16, objArr222);
                    }
                    card = card4;
                    r56 = 0;
                    card4 = card2;
                    toServiceMsg2 = toServiceMsg;
                }
            }
            z18 = z17;
            i3 = 2;
            card3 = null;
            z16 = z18;
            c16 = 1;
            card2 = card3;
            card = card4;
            r56 = 0;
            card4 = card2;
            toServiceMsg2 = toServiceMsg;
        } else {
            c16 = 1;
            i3 = 2;
            r56 = 0;
            QLog.e("ExpandHandlerImpl", 1, String.format("handleGetExtendFriendInfo errMsg=%s", fromServiceMsg.getStringForLog()));
            toServiceMsg2 = toServiceMsg;
            z16 = false;
            card = null;
        }
        if (toServiceMsg2.extraData.getBoolean("onlyStrangerInfo", r56)) {
            businessHandler = this;
        } else {
            if (z16 && card == null) {
                z16 = r56;
            }
            int i46 = toServiceMsg2.extraData.getInt("getStrangerInfoSeq", r56);
            Object[] objArr3 = new Object[i3];
            objArr3[r56] = card;
            objArr3[c16] = Integer.valueOf(i46);
            businessHandler = this;
            businessHandler.notifyUI(3, z16, objArr3);
        }
        int i182222 = toServiceMsg2.extraData.getInt("getStrangerInfoSeq", r56);
        Object[] objArr2222 = new Object[i3];
        objArr2222[r56] = card4;
        objArr2222[c16] = Integer.valueOf(i182222);
        businessHandler.notifyUI(9, z16, objArr2222);
    }

    private int a3(int i3) {
        switch (i3) {
            case 1:
                return 11;
            case 2:
                return 12;
            case 3:
                return 13;
            case 4:
                return 14;
            case 5:
                return 15;
            case 6:
                return 24;
            case 7:
                return 25;
            default:
                QLog.e("ExpandHandlerImpl", 2, "un known op type" + i3);
                return 11;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public boolean w1(List<Long> list, int i3) {
        if (list != null) {
            return G2(list, 0, 50, null, i3);
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    private boolean G2(List<Long> list, int i3, int i16, List<Long> list2, int i17) {
        ?? r26;
        com.tencent.mobileqq.service.message.e eVar;
        String str;
        String str2;
        int size = list == null ? 0 : list.size();
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            QLog.d("ExpandHandlerImpl", 2, String.format("getExtendFriendOnlineState reqListSize=%s startIndex=%s count=%s", Integer.valueOf(size), Integer.valueOf(i3), Integer.valueOf(i16)));
        }
        try {
            QQAppInterface qQAppInterface = this.f263975d;
            if (qQAppInterface != null) {
                eVar = qQAppInterface.getMsgCache();
                str = this.f263975d.getCurrentUin();
            } else {
                eVar = null;
                str = null;
            }
            if (size != 0 && i3 < size && i16 > 0 && eVar != null) {
                int min = Math.min(size - i3, i16);
                if (QLog.isColorLevel()) {
                    QLog.d("ExpandHandlerImpl", 2, String.format("getExtendFriendOnlineState fixed count=%s", Integer.valueOf(min)));
                }
                oidb_0xe09$ReqBody oidb_0xe09_reqbody = new oidb_0xe09$ReqBody();
                for (Long l3 : list.subList(i3, i3 + min)) {
                    byte[] G0 = eVar.G0(String.valueOf(l3), str);
                    if (G0 == null) {
                        G0 = eVar.H0(String.valueOf(l3), str, false);
                    }
                    if (G0 != null) {
                        oidb_0xe09$reqItem oidb_0xe09_reqitem = new oidb_0xe09$reqItem();
                        str2 = str;
                        try {
                            oidb_0xe09_reqitem.uint64_uin.set(l3.longValue());
                            oidb_0xe09_reqitem.bytes_sig.set(ByteStringMicro.copyFrom(G0));
                            oidb_0xe09_reqbody.rpt_item.add(oidb_0xe09_reqitem);
                        } catch (Exception e16) {
                            e = e16;
                            r26 = 1;
                            QLog.e("ExpandHandlerImpl", (int) r26, "getExtendFriendOnlineState fail.", e);
                            return r26;
                        }
                    } else {
                        str2 = str;
                        try {
                            QLog.w("ExpandHandlerImpl", 1, String.format("getExtendFriendOnlineState get match chat sig fail. uin=%s", l3));
                        } catch (Exception e17) {
                            e = e17;
                            r26 = 1;
                            QLog.e("ExpandHandlerImpl", (int) r26, "getExtendFriendOnlineState fail.", e);
                            return r26;
                        }
                    }
                    str = str2;
                    z16 = true;
                }
                try {
                    ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xe09", 3593, 1, oidb_0xe09_reqbody.toByteArray());
                    makeOIDBPkg.addAttribute("reqList", list);
                    makeOIDBPkg.addAttribute("startIndex", Integer.valueOf(i3));
                    makeOIDBPkg.addAttribute("count", Integer.valueOf(min));
                    makeOIDBPkg.addAttribute("resultList", list2);
                    makeOIDBPkg.addAttribute("reqTag", Integer.valueOf(i17));
                    sendPbReq(makeOIDBPkg);
                    return true;
                } catch (Exception e18) {
                    e = e18;
                    r26 = 1;
                    QLog.e("ExpandHandlerImpl", (int) r26, "getExtendFriendOnlineState fail.", e);
                    return r26;
                }
            }
            r26 = 1;
        } catch (Exception e19) {
            e = e19;
            r26 = z16;
        }
        try {
            QLog.e("ExpandHandlerImpl", 1, "getExtendFriendOnlineState invalid param.");
            return false;
        } catch (Exception e26) {
            e = e26;
            QLog.e("ExpandHandlerImpl", (int) r26, "getExtendFriendOnlineState fail.", e);
            return r26;
        }
    }

    @Override // com.tencent.mobileqq.qqexpand.network.e
    public void q1(boolean z16) {
    }
}
