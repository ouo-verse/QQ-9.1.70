package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.os.SystemClock;
import appoint.define.appoint_define$PublisherInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.StrangerInfo;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearpeople.mytab.NearbyMyTabCard;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.now.ilive_feeds_near_anchor$GetNearAnchorRsp;
import com.tencent.pb.now.ilive_nearby_user_control$EnterNearbyUserContrlRsp;
import com.tencent.protobuf.nearbyReportSvr.NearbyReportSvr$TempChatRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x4f0.cmd0x4f0$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b$RspBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b$RspConfigItem;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b$RspLikeInfo;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b$RspPansocialInfo;
import tencent.im.oidb.cmd0xada.oidb_0xada$RspBody;
import tencent.sso.accretion.flower_info$SFlowerInfoRsp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class NearbyHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    INearbyAppInterface f194886d;

    /* JADX WARN: Multi-variable type inference failed */
    public NearbyHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else if (appInterface instanceof INearbyAppInterface) {
            this.f194886d = (INearbyAppInterface) appInterface;
        }
    }

    @Nullable
    private ArrayList<StrangerInfo> E2(cmd0x4f0$RspBody cmd0x4f0_rspbody) {
        List<appoint_define$PublisherInfo> list;
        ArrayList<StrangerInfo> arrayList = null;
        if (cmd0x4f0_rspbody.rpt_msg_vistor_info.has()) {
            list = cmd0x4f0_rspbody.rpt_msg_vistor_info.get();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            arrayList = new ArrayList<>();
            Iterator<appoint_define$PublisherInfo> it = list.iterator();
            while (it.hasNext()) {
                StrangerInfo convertFrom = StrangerInfo.convertFrom(it.next());
                if (convertFrom != null) {
                    arrayList.add(convertFrom);
                }
            }
        }
        return arrayList;
    }

    private void G2(Oidb_0x66b$RspBody oidb_0x66b$RspBody, oidb_0x5eb$RspBody oidb_0x5eb_rspbody, NearbyMyTabCard nearbyMyTabCard) {
        if (oidb_0x66b$RspBody.bytes_rspbody_5eb.has()) {
            try {
                oidb_0x5eb_rspbody.mergeFrom(oidb_0x66b$RspBody.bytes_rspbody_5eb.get().toByteArray());
                if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                    oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0);
                    nearbyMyTabCard.uin = Long.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
                    nearbyMyTabCard.nickName = oidb_0x5eb_udcuindata.bytes_stranger_nick.get().toStringUtf8();
                    nearbyMyTabCard.carrier = oidb_0x5eb_udcuindata.uint32_profession.get();
                    int i3 = oidb_0x5eb_udcuindata.uint32_gender.get();
                    nearbyMyTabCard.gender = i3;
                    if (i3 == 1 || i3 == 2) {
                        ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(nearbyMyTabCard.uin + "", INearbySPUtil.SP_KEY_SELF_GENDER, Integer.valueOf(nearbyMyTabCard.gender));
                    }
                    nearbyMyTabCard.age = oidb_0x5eb_udcuindata.uint32_age.get();
                    nearbyMyTabCard.godFlag = oidb_0x5eb_udcuindata.uint32_god_flag.get();
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("NewNearbyMyTab", 2, "fail to decode 5eb_rspBody", e16);
                }
            }
        }
    }

    private void I2(Oidb_0x66b$RspBody oidb_0x66b$RspBody, NearbyMyTabCard nearbyMyTabCard) {
        if (oidb_0x66b$RspBody.stConfigList.has()) {
            boolean[] zArr = {false, false};
            for (Oidb_0x66b$RspConfigItem oidb_0x66b$RspConfigItem : oidb_0x66b$RspBody.stConfigList.get()) {
                if (oidb_0x66b$RspConfigItem.uint32_id.has() && oidb_0x66b$RspConfigItem.uint32_id.get() == 10001) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.NEARBY, 2, "handleGetNearbyMyTab|shield date entrance");
                    }
                } else {
                    NearbyMyTabCard.NearbyMyTabConfig nearbyMyTabConfig = new NearbyMyTabCard.NearbyMyTabConfig();
                    nearbyMyTabConfig.configId = oidb_0x66b$RspConfigItem.uint32_id.get();
                    nearbyMyTabConfig.strName = oidb_0x66b$RspConfigItem.str_name.get();
                    nearbyMyTabConfig.strUrl = oidb_0x66b$RspConfigItem.str_url.get();
                    nearbyMyTabConfig.iconUrl = oidb_0x66b$RspConfigItem.str_picurl.get();
                    nearbyMyTabConfig.tips = oidb_0x66b$RspConfigItem.str_tips.get();
                    nearbyMyTabCard.configList.add(nearbyMyTabConfig);
                }
            }
            boolean z16 = false;
            for (int i3 = 0; i3 < 2; i3++) {
                z16 |= this.f194886d.getNearbyProcManager().f(i3, zArr[i3]);
            }
            if (z16) {
                notifyUI(12, true, null);
            }
        }
    }

    private void J2(NearbyMyTabCard nearbyMyTabCard) {
        if (QLog.isDevelopLevel()) {
            String str = "";
            for (int i3 = 0; i3 < nearbyMyTabCard.configList.size(); i3++) {
                str = str + nearbyMyTabCard.configList.get(i3).configId + nearbyMyTabCard.configList.get(i3).strName + nearbyMyTabCard.configList.get(i3).strUrl + "\n";
            }
            QLog.d("NewNearbyMyTab", 2, "handleGetNearbyMyTab---->uin =" + nearbyMyTabCard.uin + "nickName = " + nearbyMyTabCard.nickName + " profression = " + nearbyMyTabCard.carrier + " gender = " + nearbyMyTabCard.gender + "age =" + nearbyMyTabCard.age + " likeTotalNum = " + nearbyMyTabCard.likeTotalNum + "likeNewNum = " + nearbyMyTabCard.newLikeNum + "charmVale =" + nearbyMyTabCard.charmValue + "charmLevel =" + nearbyMyTabCard.charmLevel + "charmCurrent =" + nearbyMyTabCard.currentCharm + "charmNext" + nearbyMyTabCard.nextCharm + " giftNum = " + nearbyMyTabCard.giftNum + "config = " + str);
        }
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        long j3;
        long j16;
        long j17;
        long j18;
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0x4f0$RspBody cmd0x4f0_rspbody = new cmd0x4f0$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x4f0_rspbody);
            boolean z16 = toServiceMsg.extraData.getBoolean("is_first_page");
            String str = "";
            byte[] bArr = null;
            if (parseOIDBPkg == 0) {
                if (cmd0x4f0_rspbody.bytes_cookie.has()) {
                    bArr = cmd0x4f0_rspbody.bytes_cookie.get().toByteArray();
                }
                byte[] bArr2 = bArr;
                if (cmd0x4f0_rspbody.uint32_completed.has()) {
                    i3 = cmd0x4f0_rspbody.uint32_completed.get();
                } else {
                    i3 = 0;
                }
                if (cmd0x4f0_rspbody.uint32_total_visitor.has()) {
                    j3 = cmd0x4f0_rspbody.uint32_total_visitor.get();
                } else {
                    j3 = 0;
                }
                if (cmd0x4f0_rspbody.uint32_unread_visitor.has()) {
                    j16 = cmd0x4f0_rspbody.uint32_unread_visitor.get();
                } else {
                    j16 = 0;
                }
                long j19 = j3 - j16;
                ArrayList<StrangerInfo> E2 = E2(cmd0x4f0_rspbody);
                long j26 = j16;
                long j27 = j3;
                R2(bArr2, i3, j3, j26, j19, E2);
                if (z16 && E2 != null && !E2.isEmpty()) {
                    EntityManager createEntityManager = this.f194886d.getEntityManagerFactory().createEntityManager();
                    DBMethodProxy.execSQL(createEntityManager, "DELETE FROM " + StrangerInfo.class.getSimpleName() + ";");
                    Iterator<StrangerInfo> it = E2.iterator();
                    while (it.hasNext()) {
                        createEntityManager.persist(it.next());
                    }
                    SharedPreferences.Editor edit = ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getSharedPreferences(INearbySPUtil.NEARBY_VISITOR_FILE, this.f194886d.getAccount(), 0).edit();
                    j18 = j27;
                    if (j18 > 0) {
                        edit.putLong(INearbySPUtil.SP_KEY_TOTAL_VISITOR, j18);
                        j17 = j26;
                        if (j17 > 0) {
                            edit.putLong(INearbySPUtil.SP_KEY_NEW_VISITOR, j17);
                        }
                        if (j19 > 0) {
                            edit.putLong(INearbySPUtil.SP_KEY_HIS_VISITOR, j19);
                        }
                        edit.commit();
                    } else {
                        j17 = j26;
                    }
                } else {
                    j17 = j26;
                    j18 = j27;
                }
                notifyUI(11, true, new Object[]{E2, bArr2, Integer.valueOf(i3), Long.valueOf(j18), "", Boolean.valueOf(z16), Long.valueOf(j17), Long.valueOf(j19)});
                return;
            }
            if (cmd0x4f0_rspbody.str_error_tips.has()) {
                str = cmd0x4f0_rspbody.str_error_tips.get();
            }
            String str2 = str;
            notifyUI(11, false, new Object[]{null, null, -1, -1L, str2, Boolean.valueOf(z16), -1L, -1L});
            if (QLog.isColorLevel()) {
                QLog.i("NearbyHandler", 2, "handleGetRecentVisitors: result is: " + parseOIDBPkg + " errorTips: " + str2);
            }
        }
    }

    private void M2(Oidb_0x66b$RspBody oidb_0x66b$RspBody, NearbyMyTabCard nearbyMyTabCard) {
        if (oidb_0x66b$RspBody.bytes_rspbody_gift.has()) {
            byte[] byteArray = oidb_0x66b$RspBody.bytes_rspbody_gift.get().toByteArray();
            flower_info$SFlowerInfoRsp flower_info_sflowerinforsp = new flower_info$SFlowerInfoRsp();
            try {
                flower_info_sflowerinforsp.mergeFrom(byteArray);
            } catch (InvalidProtocolBufferMicroException e16) {
                nearbyMyTabCard.giftNum = 0;
                if (QLog.isColorLevel()) {
                    QLog.e("NewNearbyMyTab", 2, "fail to decode SFlowerInfoRsp", e16);
                }
            }
            nearbyMyTabCard.giftNum = flower_info_sflowerinforsp.num.get();
        }
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            NearbyReportSvr$TempChatRsp nearbyReportSvr$TempChatRsp = new NearbyReportSvr$TempChatRsp();
            try {
                nearbyReportSvr$TempChatRsp.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("NearbyIMReport", 2, "InvalidProtocolBufferMicroException e = " + e16.getMessage());
                }
            }
            if (nearbyReportSvr$TempChatRsp.ret_code.get() != 0 && QLog.isColorLevel()) {
                QLog.e("NearbyIMReport", 2, "get failed,code =  " + nearbyReportSvr$TempChatRsp.ret_code.get() + " msg:" + nearbyReportSvr$TempChatRsp.ret_msg.get());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("NearbyIMReport", 2, "handleNearbyIMReport req == null || res == null || data == null");
        }
    }

    private void P2(Oidb_0x66b$RspBody oidb_0x66b$RspBody, NearbyMyTabCard nearbyMyTabCard) {
        if (oidb_0x66b$RspBody.stLikeInfo.has()) {
            Oidb_0x66b$RspLikeInfo oidb_0x66b$RspLikeInfo = oidb_0x66b$RspBody.stLikeInfo.get();
            int i3 = oidb_0x66b$RspLikeInfo.uint32_total.get();
            int i16 = oidb_0x66b$RspLikeInfo.uint32_new.get();
            nearbyMyTabCard.likeTotalNum = i3;
            nearbyMyTabCard.newLikeNum = i16;
            this.f194886d.writeVoteRedDotState(0);
        }
    }

    private void Q2(Oidb_0x66b$RspBody oidb_0x66b$RspBody, NearbyMyTabCard nearbyMyTabCard) {
        if (oidb_0x66b$RspBody.stPansocialInfo.has()) {
            Oidb_0x66b$RspPansocialInfo oidb_0x66b$RspPansocialInfo = oidb_0x66b$RspBody.stPansocialInfo.get();
            nearbyMyTabCard.charmValue = oidb_0x66b$RspPansocialInfo.uint32_charm.get();
            nearbyMyTabCard.charmLevel = oidb_0x66b$RspPansocialInfo.uint32_charmlevel.get();
            nearbyMyTabCard.currentCharm = oidb_0x66b$RspPansocialInfo.uint32_charmlevelvalue.get();
            nearbyMyTabCard.nextCharm = oidb_0x66b$RspPansocialInfo.uint32_nextcharmlevelvalue.get();
        }
    }

    private void R2(byte[] bArr, int i3, long j3, long j16, long j17, ArrayList<StrangerInfo> arrayList) {
        int length;
        String obj;
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.NEARBY_VISITOR, 2, "handleGetRecentVisitors|c");
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleGetRecentVisitors|cookie lenght: ");
            int i16 = 0;
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            sb5.append(length);
            sb5.append(",compleFlag: ");
            sb5.append(i3);
            sb5.append(",totalVisitor: ");
            sb5.append(j3);
            sb5.append(",newVisitor:");
            sb5.append(j16);
            sb5.append(",hisVisitor:");
            sb5.append(j17);
            sb5.append(",visitorCount: ");
            if (arrayList != null) {
                i16 = arrayList.size();
            }
            sb5.append(i16);
            sb5.append(",visitor info is: ");
            if (arrayList == null) {
                obj = null;
            } else {
                obj = arrayList.toString();
            }
            sb5.append(obj);
            QLog.i(LogTag.NEARBY_VISITOR, 2, sb5.toString());
        }
    }

    public boolean D2(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.HOT_CHAT_DISTANCE, 2, "NearbyHandler.checkIn,  lat=" + i3 + ", lon=" + i16);
        }
        if (i3 != 0 && i16 != 0) {
            return true;
        }
        return false;
    }

    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
            try {
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xada_rspbody);
                QLog.d(LogTag.TAG_NEARBY_CHECK_AUTH, 1, "handlNearbyUserCheckAuth oidbRet=" + parseOIDBPkg);
                if (parseOIDBPkg != 0) {
                    notifyUI(21, false, new Object[]{-2, ""});
                    return;
                }
                if (!oidb_0xada_rspbody.busi_buf.has()) {
                    QLog.w(LogTag.TAG_NEARBY_CHECK_AUTH, 1, "handlNearbyUserCheckAuth rspBody.busi_buf is null");
                    notifyUI(21, false, new Object[]{-3, ""});
                    return;
                }
                ilive_nearby_user_control$EnterNearbyUserContrlRsp ilive_nearby_user_control_enternearbyusercontrlrsp = new ilive_nearby_user_control$EnterNearbyUserContrlRsp();
                ilive_nearby_user_control_enternearbyusercontrlrsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                int i3 = ilive_nearby_user_control_enternearbyusercontrlrsp.check_ret.get();
                String str = ilive_nearby_user_control_enternearbyusercontrlrsp.check_msg.get();
                notifyUI(21, true, new Object[]{Integer.valueOf(i3), str});
                QLog.d(LogTag.TAG_NEARBY_CHECK_AUTH, 1, "handlNearbyUserCheckAuth checkRet=" + i3 + ", checkMsg=" + str);
                return;
            } catch (Exception e16) {
                QLog.e(LogTag.TAG_NEARBY_CHECK_AUTH, 1, "handlNearbyUserCheckAuth exp=" + e16.toString());
                notifyUI(21, false, new Object[]{-4, ""});
                return;
            }
        }
        notifyUI(21, false, new Object[]{-1, ""});
        if (QLog.isColorLevel()) {
            QLog.w(LogTag.TAG_NEARBY_CHECK_AUTH, 2, "handlNearbyUserCheckAuth req == null || res == null");
        }
    }

    public void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
        } else if (QLog.isColorLevel()) {
            QLog.i("NewNearbyMyTab", 2, "handleClearRedTouch| isSuccess = " + fromServiceMsg.isSuccess());
        }
    }

    public void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NewNearbyMyTab", 2, "handleGetNearbyMyTab");
        }
        Oidb_0x66b$RspBody oidb_0x66b$RspBody = new Oidb_0x66b$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x66b$RspBody);
        boolean z16 = false;
        if (parseOIDBPkg == 0) {
            oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
            NearbyMyTabCard nearbyMyTabCard = new NearbyMyTabCard();
            G2(oidb_0x66b$RspBody, oidb_0x5eb_rspbody, nearbyMyTabCard);
            P2(oidb_0x66b$RspBody, nearbyMyTabCard);
            Q2(oidb_0x66b$RspBody, nearbyMyTabCard);
            M2(oidb_0x66b$RspBody, nearbyMyTabCard);
            I2(oidb_0x66b$RspBody, nearbyMyTabCard);
            J2(nearbyMyTabCard);
        } else {
            notifyUI(3, false, null);
        }
        if (parseOIDBPkg == 0) {
            z16 = true;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str = "0";
        } else {
            str = "-1";
        }
        hashMap.put("param_FailCode", str);
        hashMap.put(ReportConstant.KEY_NET_TYPE, String.valueOf(NetworkUtil.getSystemNetwork(BaseApplication.getContext())));
        hashMap.put("param_DeviceType", String.valueOf(com.tencent.mobileqq.utils.ah.u()));
        long uptimeMillis = SystemClock.uptimeMillis() - toServiceMsg.extraData.getLong("request_start_time");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(getCurrentAccountUin(), "actGetNearbyMyTab", z16, uptimeMillis, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.i("NearbyHandler", 2, "handleGetNearbyMyTab, isSuccess=" + z16 + ",duration=" + uptimeMillis);
        }
    }

    public void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            oidb_0xada$RspBody oidb_0xada_rspbody = new oidb_0xada$RspBody();
            OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xada_rspbody);
            if (!oidb_0xada_rspbody.busi_buf.has()) {
                QLog.i("NearbyHandler", 1, "handleLiveFeedNearbyAnchor rspBody.busi_buf is null");
                notifyUI(19, false, new Object[]{null});
                return;
            }
            ilive_feeds_near_anchor$GetNearAnchorRsp ilive_feeds_near_anchor_getnearanchorrsp = new ilive_feeds_near_anchor$GetNearAnchorRsp();
            try {
                ilive_feeds_near_anchor_getnearanchorrsp.mergeFrom(oidb_0xada_rspbody.busi_buf.get().toByteArray());
                if (ilive_feeds_near_anchor_getnearanchorrsp.ret.get() == 0 && ilive_feeds_near_anchor_getnearanchorrsp.anchor_infos.size() > 0) {
                    notifyUI(19, true, new Object[]{ilive_feeds_near_anchor_getnearanchorrsp.anchor_infos.get()});
                } else {
                    notifyUI(19, false, new Object[]{null});
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("NearbyHandler", 1, "handleLiveFeedNearbyAnchor InvalidProtocolBufferMicroException", e16);
                notifyUI(19, false, new Object[]{null});
                return;
            }
        }
        notifyUI(19, false, new Object[]{null});
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.NEARBY_NOW, 2, "handleLiveFeedNearbyAnchor req == null || res == null");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x8dd");
            this.allowCmdSet.add("RoamClientSvr.GetQualify");
            this.allowCmdSet.add("OidbSvc.0x66b");
            this.allowCmdSet.add("NeighborSvc.ReqGetPoint");
            this.allowCmdSet.add("OidbSvc.0x9c7_0");
            this.allowCmdSet.add(ProfileContants.CMD_REQ_NEARBY_CHARM_EVENT);
            this.allowCmdSet.add("OidbSvc.0x4f0_0");
            this.allowCmdSet.add("OidbSvc.0x6be");
            this.allowCmdSet.add("OidbSvc.0xafc_1");
            this.allowCmdSet.add("OidbSvc.0xafc_2");
            this.allowCmdSet.add("OidbSvc.0xafc_3");
            this.allowCmdSet.add("OidbSvc.0xada_0");
            this.allowCmdSet.add("MQ_nearby_sso_proxy.0x3e8_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Class) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return ca.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("msgCmdFilter", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        BusinessHandlerUtil.checkReportErrorToMM(fromServiceMsg, getCurrentAccountUin());
        if ("OidbSvc.0x66b".equals(serviceCmd)) {
            K2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("NeighborSvc.ReqGetPoint".equals(serviceCmd)) {
            if (toServiceMsg.extraData.getBoolean("req_street_view")) {
                i3 = 5;
            } else {
                i3 = 6;
            }
            bz.e(this, i3, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x9c7_0".equals(serviceCmd)) {
            bz.i(this, 10, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (ProfileContants.CMD_REQ_NEARBY_CHARM_EVENT.equals(serviceCmd)) {
            bz.l(this, 8, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x4f0_0".equals(serviceCmd)) {
            L2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x6be".equals(serviceCmd)) {
            H2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0xada_0".equals(serviceCmd)) {
            String str = (String) toServiceMsg.getAttribute("innerReq", "");
            if (QLog.isColorLevel()) {
                QLog.d("NearbyHandler", 2, "NearbyHandler onReceive oxada, innerReq=" + str);
            }
            if ("ilive_feeds_near_anchor".equals(str)) {
                N2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("ilive_nearby_user_control".equals(str)) {
                    F2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if ("MQ_nearby_sso_proxy.0x3e8_1".equals(serviceCmd)) {
            O2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
