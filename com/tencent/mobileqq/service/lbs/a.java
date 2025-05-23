package com.tencent.mobileqq.service.lbs;

import EncounterSvc.UserData;
import NeighborSvc.ReqGetSwitches;
import NeighborSvc.ReqHeader;
import NeighborSvc.ReqSetStateSwitch;
import NeighborSvc.RespGetSwitches;
import NeighborSvc.RespSetStateSwitch;
import QQService.FaceInfo;
import QQService.ReqDelFace;
import QQService.ReqDeleteVisitorRecord;
import QQService.ReqGetCardSwitch;
import QQService.ReqGetFavoriteList;
import QQService.ReqGetVoterList;
import QQService.ReqPicSafetyCheck;
import QQService.ReqSetCard;
import QQService.ReqSetCardSwitch;
import QQService.RespDelFace;
import QQService.RespDeleteVisitorRecord;
import QQService.RespGetCardSwitch;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.UserCntlData;
import SummaryCard.CondFitUser;
import SummaryCard.ReqCondSearch;
import SummaryCard.ReqHead;
import SummaryCard.ReqSearch;
import SummaryCard.ReqSummaryCard;
import SummaryCard.RespCondSearch;
import SummaryCard.RespSearch;
import SummaryCard.RespSummaryCard;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardLikeIt;
import SummaryCardTaf.SSummaryCardSetLabel;
import addcontacts.AccountSearchPb$Location;
import addcontacts.AccountSearchPb$ResultItem;
import addcontacts.AccountSearchPb$record;
import addcontacts.AccountSearchPb$search;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.bz;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.bussiness.achievement.processor.LifeAchievementBusinessProcessor;
import com.tencent.mobileqq.profilecard.entity.BusinessReqBuffer;
import com.tencent.mobileqq.profilecard.servlet.ProfileCardServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.pb.profilecard.SummaryCardBusiEntry$comm;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.ShortCompanionObject;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a extends BaseProtocolCoder {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static String[] f286141h;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<AppInterface> f286142d;

    /* renamed from: e, reason: collision with root package name */
    public UserData[] f286143e;

    /* renamed from: f, reason: collision with root package name */
    private byte[] f286144f;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74933);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f286141h = new String[]{"NeighborSvc", "KQQFS", "MCardSvc", "MobileQQ", "EncounterSvc", "VisitorSvc", Global.TRACKING_LOCATION, "SummaryCard", "NearbyGroup", "NeighborRecommender"};
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f286143e = new UserData[2];
        this.f286144f = new byte[0];
        this.f286142d = new WeakReference<>((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null));
    }

    private boolean A(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        try {
            SSummaryCardLikeIt sSummaryCardLikeIt = new SSummaryCardLikeIt();
            sSummaryCardLikeIt.cmd = 3;
            sSummaryCardLikeIt.uin = toServiceMsg.extraData.getLong("selfUin");
            sSummaryCardLikeIt.likeuin = toServiceMsg.extraData.getLong("destUin");
            sSummaryCardLikeIt.label = toServiceMsg.extraData.getLong("labelId");
            sSummaryCardLikeIt.platform = 109L;
            sSummaryCardLikeIt.version = AppSetting.f99551k;
            uniPacket.setServantName("SummaryCard");
            uniPacket.setFuncName("LikeIt");
            uniPacket.put("SSummaryCardLikeIt", sSummaryCardLikeIt);
            toServiceMsg.setTimeout(10000L);
            toServiceMsg.setServiceCmd("SummaryCard.LikeIt");
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean B(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 2;
        reqHeader.lMID = BaseProtocolCoder.createUserId(Long.parseLong(toServiceMsg.getUin()));
        reqHeader.iAppID = AppSetting.f();
        ReqSetStateSwitch reqSetStateSwitch = new ReqSetStateSwitch(reqHeader, toServiceMsg.extraData.getBoolean("k_be_share", false) ? (byte) 1 : (byte) 0);
        uniPacket.setServantName("NeighborObj");
        uniPacket.setFuncName("CMD_SET_STATE_SWITCH");
        uniPacket.put("ReqSetStateSwitch", reqSetStateSwitch);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("NeighborSvc.ReqSetStateSwitch");
        return true;
    }

    public static boolean C(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqHead reqHead = new ReqHead();
        reqHead.iVersion = 2;
        uniPacket.setServantName("SummaryCardServantObj");
        uniPacket.setFuncName("ReqSummaryCard");
        uniPacket.put("ReqHead", reqHead);
        uniPacket.put("ReqSummaryCard", a(toServiceMsg));
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setServiceCmd(ProfileCardServlet.CMD_REQ_SUMMARY_CARD);
        return true;
    }

    private boolean D(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        toServiceMsg.extraData.getLong("selfUin");
        long j3 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        long j16 = toServiceMsg.extraData.getLong("nextMid");
        int i3 = toServiceMsg.extraData.getInt("pageSize");
        QQService.ReqHead reqHead = new QQService.ReqHead(j3, (short) 1, uniPacket.getRequestId(), (byte) 1, (byte) 0, null);
        UserCntlData userCntlData = new UserCntlData(j16, new byte[0]);
        if (i3 >= 54) {
            i3 = 30;
        }
        ReqGetVoterList reqGetVoterList = new ReqGetVoterList(reqHead, userCntlData, i3);
        uniPacket.setServantName("VisitorSvc");
        uniPacket.setFuncName("ReqGetVoterList");
        uniPacket.put("ReqGetVoterList", reqGetVoterList);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("VisitorSvc.ReqGetVoterList");
        return true;
    }

    public static ReqSummaryCard a(ToServiceMsg toServiceMsg) {
        byte b16;
        int i3;
        int i16;
        ToServiceMsg toServiceMsg2 = toServiceMsg;
        long j3 = toServiceMsg2.extraData.getLong("selfUin");
        long j16 = toServiceMsg2.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN, 0L);
        int i17 = toServiceMsg2.extraData.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE, 0);
        long j17 = toServiceMsg2.extraData.getLong("qzoneFeedTimeStamp", 0L);
        byte b17 = toServiceMsg2.extraData.getByte(IProfileProtocolConst.PARAM_IS_FRIEND);
        long j18 = toServiceMsg2.extraData.getLong(IProfileProtocolConst.PARAM_TROOP_CODE, 0L);
        long j19 = toServiceMsg2.extraData.getLong("troopUin", 0L);
        String string = toServiceMsg2.extraData.getString("strSearchName");
        long j26 = toServiceMsg2.extraData.getLong("lGetControl");
        int i18 = toServiceMsg2.extraData.getInt("bReqCommLabel");
        int i19 = toServiceMsg2.extraData.getInt("EAddFriendSource");
        long j27 = toServiceMsg2.extraData.getLong("tinyId");
        long j28 = toServiceMsg2.extraData.getLong("likeSource");
        byte b18 = toServiceMsg2.extraData.getByte("bReqExtendCard");
        ArrayList parcelableArrayList = toServiceMsg2.extraData.getParcelableArrayList("busiList");
        if (parcelableArrayList == null) {
            parcelableArrayList = new ArrayList();
        }
        ArrayList arrayList = parcelableArrayList;
        byte[] byteArray = toServiceMsg2.extraData.getByteArray("vSeed");
        if (byteArray == null) {
            b16 = 0;
            byteArray = new byte[]{0};
        } else {
            b16 = 0;
        }
        byte[] bArr = byteArray;
        byte[] byteArray2 = toServiceMsg2.extraData.getByteArray("vSecureSig");
        if (byteArray2 == null) {
            byteArray2 = new byte[1];
            byteArray2[b16] = b16;
        }
        byte[] bArr2 = byteArray2;
        byte b19 = toServiceMsg2.extraData.getByte("bReqMedalWallInfo");
        ArrayList<Integer> integerArrayList = toServiceMsg2.extraData.getIntegerArrayList("req0x5ebFieldIdList");
        byte[] byteArray3 = toServiceMsg2.extraData.getByteArray("vReqTemplateInfo");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(AppSetting.f99551k);
        sb5.append(".");
        String str = AppSetting.f99542b;
        sb5.append(str);
        String sb6 = sb5.toString();
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, e16.toString());
            }
            i3 = 0;
        }
        ArrayList arrayList2 = new ArrayList();
        if (j16 > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BusinessReqBuffer businessReqBuffer = (BusinessReqBuffer) it.next();
                SummaryCardBusiEntry$comm summaryCardBusiEntry$comm = new SummaryCardBusiEntry$comm();
                Iterator it5 = it;
                byte b26 = b17;
                summaryCardBusiEntry$comm.ver.set(1);
                summaryCardBusiEntry$comm.seq.set(toServiceMsg.getAppSeq());
                summaryCardBusiEntry$comm.fromuin.set(j3);
                summaryCardBusiEntry$comm.touin.set(j16);
                summaryCardBusiEntry$comm.service.set(businessReqBuffer.getBusinessType());
                summaryCardBusiEntry$comm.platform.set(2);
                summaryCardBusiEntry$comm.qqver.set(sb6);
                summaryCardBusiEntry$comm.build.set(i3);
                if (businessReqBuffer.getBusinessType() == 17 || businessReqBuffer.getBusinessType() == 19 || businessReqBuffer.getBusinessType() == 18 || businessReqBuffer.getBusinessType() == 20 || businessReqBuffer.getBusinessType() == 24) {
                    summaryCardBusiEntry$comm.msg_login_sig.setHasFlag(true);
                    summaryCardBusiEntry$comm.msg_login_sig.uint32_type.set(8);
                    summaryCardBusiEntry$comm.msg_login_sig.uint32_appid.set(16);
                    String string2 = toServiceMsg2.extraData.getString("msg_login_sig");
                    if (!TextUtils.isEmpty(string2) && !HexUtil.emptybytes.equals(string2)) {
                        summaryCardBusiEntry$comm.msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8(string2));
                    } else {
                        QLog.d("LBSService", 1, "MiniAppSummaryCard buildReqSummaryCard SummaryCardBusiEntry.MINI_APP_SERVICE set A2 failed");
                    }
                }
                byte[] byteArray4 = summaryCardBusiEntry$comm.toByteArray();
                int length = byteArray4.length;
                if (businessReqBuffer.getBuffer() != null) {
                    i16 = businessReqBuffer.getBuffer().length;
                } else {
                    i16 = 0;
                }
                long j29 = j3;
                byte[] bArr3 = new byte[length + 9 + i16 + 1];
                bArr3[0] = 40;
                long j36 = j17;
                PkgTools.dWord2Byte(bArr3, 1, length);
                PkgTools.dWord2Byte(bArr3, 5, i16);
                PkgTools.copyData(bArr3, 9, byteArray4, length);
                int length2 = 9 + byteArray4.length;
                if (businessReqBuffer.getBuffer() != null) {
                    PkgTools.copyData(bArr3, length2, businessReqBuffer.getBuffer(), businessReqBuffer.getBuffer().length);
                    length2 += businessReqBuffer.getBuffer().length;
                }
                bArr3[length2] = 41;
                arrayList2.add(bArr3);
                toServiceMsg2 = toServiceMsg;
                it = it5;
                j3 = j29;
                b17 = b26;
                j17 = j36;
            }
        }
        return new ReqSummaryCard(j16, i17, j17, b17, j18, j19, bArr, string, j26, i19, bArr2, null, byteArray3, null, arrayList2, j27, j28, null, b19, integerArrayList, (byte) 1, (byte) i18, b18, null, 1L);
    }

    private Object b(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        ArrayList<CondFitUser> arrayList;
        RespCondSearch respCondSearch = (RespCondSearch) decodePacket(fromServiceMsg.getWupBuffer(), "RespCondSearch", new RespCondSearch());
        if (respCondSearch != null && (arrayList = respCondSearch.vUserList) != null && !arrayList.isEmpty()) {
            for (int i3 = 0; i3 < respCondSearch.vUserList.size(); i3++) {
                CondFitUser condFitUser = respCondSearch.vUserList.get(i3);
                condFitUser.locDesc = ((ConditionSearchManager) getApp().getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).Q(new String[]{ConditionSearchManager.n(condFitUser.dwCountry), ConditionSearchManager.n(condFitUser.dwProvince), ConditionSearchManager.n(condFitUser.dwCity), "0"});
            }
        }
        return respCondSearch;
    }

    private void c(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespDeleteVisitorRecord respDeleteVisitorRecord = (RespDeleteVisitorRecord) decodePacket(fromServiceMsg.getWupBuffer(), "RespDeleteVisitorRecord", new RespDeleteVisitorRecord());
        if (respDeleteVisitorRecord.stHeader.iReplyCode != 0) {
            fromServiceMsg.setMsgFail();
        } else {
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.getAttributes().put("result", respDeleteVisitorRecord);
        }
    }

    private void d(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespGetFavoriteList respGetFavoriteList = (RespGetFavoriteList) decodePacket(fromServiceMsg.getWupBuffer(), "RespGetFavoriteList", new RespGetFavoriteList());
        if (respGetFavoriteList.stHeader.iReplyCode != 0) {
            fromServiceMsg.setMsgFail();
        } else {
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.getAttributes().put("result", respGetFavoriteList);
        }
    }

    private Object e(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        return (RespGetCardSwitch) decodePacket(fromServiceMsg.getWupBuffer(), "RespGetCardSwitch", new RespGetCardSwitch());
    }

    private Object f(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespGetSwitches respGetSwitches = (RespGetSwitches) decodePacket(fromServiceMsg.getWupBuffer(), "RespGetSwitches", new RespGetSwitches());
        if (respGetSwitches != null) {
            return respGetSwitches;
        }
        return null;
    }

    private Object g(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespSearch respSearch = (RespSearch) decodePacket(fromServiceMsg.getWupBuffer(), "RespSearch", new RespSearch());
        int i3 = toServiceMsg.extraData.getInt("search_version");
        if (i3 == 2) {
            return respSearch;
        }
        if (i3 == 3) {
            boolean z16 = toServiceMsg.extraData.getBoolean("search_decode");
            String string = toServiceMsg.extraData.getString("trace_id", "");
            if (QLog.isColorLevel()) {
                QLog.d("LBSService", 2, "decodeSearchFriend | needDecode = " + z16);
            }
            if (z16) {
                return h(respSearch.vvRespServices, string);
            }
            return respSearch.vvRespServices;
        }
        return respSearch;
    }

    private AppInterface getApp() {
        WeakReference<AppInterface> weakReference = this.f286142d;
        if (weakReference == null || weakReference.get() == null) {
            this.f286142d = new WeakReference<>((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null));
        }
        return this.f286142d.get();
    }

    public static ArrayList<un2.a> h(ArrayList<byte[]> arrayList, String str) {
        int length;
        int i3;
        boolean z16;
        List<AccountSearchPb$ResultItem> list;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<un2.a> arrayList2 = new ArrayList<>(6);
            int size = arrayList.size();
            for (int i16 = 0; i16 < size; i16++) {
                byte[] bArr = arrayList.get(i16);
                if (bArr == null) {
                    length = 0;
                } else {
                    length = bArr.length;
                }
                if (length > 10) {
                    int i17 = 1;
                    int longData = (int) PkgTools.getLongData(bArr, 1);
                    int longData2 = (int) PkgTools.getLongData(bArr, 5);
                    if (longData > 0 && (i3 = 9 + longData) < length) {
                        byte[] bArr2 = new byte[longData];
                        PkgTools.copyData(bArr2, 0, bArr, 9, longData);
                        SummaryCardBusiEntry$comm summaryCardBusiEntry$comm = new SummaryCardBusiEntry$comm();
                        try {
                            summaryCardBusiEntry$comm.mergeFrom(bArr2);
                            int i18 = summaryCardBusiEntry$comm.result.get();
                            if (i18 == 0) {
                                int i19 = summaryCardBusiEntry$comm.service.get();
                                byte[] bArr3 = new byte[longData2];
                                PkgTools.copyData(bArr3, 0, bArr, i3, longData2);
                                AccountSearchPb$search accountSearchPb$search = new AccountSearchPb$search();
                                accountSearchPb$search.mergeFrom(bArr3);
                                un2.a aVar = new un2.a();
                                aVar.f439268a = i19;
                                aVar.f439269b = accountSearchPb$search.start.get();
                                if (accountSearchPb$search.end.get() == 1) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                aVar.f439270c = z16;
                                aVar.f439272e = accountSearchPb$search.list.get();
                                aVar.f439271d = accountSearchPb$search.highlight.get();
                                aVar.f439274g = accountSearchPb$search.article_more_url.get();
                                aVar.f439273f = accountSearchPb$search.hotword_record.get();
                                aVar.f439276i = accountSearchPb$search.result_items.get();
                                aVar.f439277j = accountSearchPb$search.bool_keyword_suicide.get();
                                aVar.f439278k = accountSearchPb$search.bool_exact_search.get();
                                aVar.f439279l = str;
                                List<AccountSearchPb$record> list2 = aVar.f439272e;
                                if ((list2 != null && list2.size() > 0) || (((list = aVar.f439276i) != null && list.size() > 0) || aVar.f439277j)) {
                                    arrayList2.add(aVar);
                                    if (i19 == 80000000) {
                                        for (AccountSearchPb$record accountSearchPb$record : accountSearchPb$search.list.get()) {
                                            if (accountSearchPb$record.sign.get() != null) {
                                                accountSearchPb$record.richStatus = RichStatus.parseStatus(accountSearchPb$record.sign.get().toByteArray());
                                            }
                                        }
                                    } else if (i19 == 80000001 && accountSearchPb$search.bool_location_group.has()) {
                                        if (!accountSearchPb$search.bool_location_group.get()) {
                                            i17 = 2;
                                        }
                                        aVar.f439275h = i17;
                                    }
                                }
                            } else if (QLog.isDevelopLevel()) {
                                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 4, "busi entry, [" + summaryCardBusiEntry$comm.service.get() + "," + i18 + "," + summaryCardBusiEntry$comm.err_msg.get());
                            }
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, e16.toString());
                            }
                        }
                    }
                }
            }
            return arrayList2;
        }
        return null;
    }

    private Object i(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        return (RespSetCard) decodePacket(fromServiceMsg.getWupBuffer(), "RespSetCard", new RespSetCard());
    }

    private Object j(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        return (SSummaryCardLableRsp) decodePacket(fromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
    }

    private Object k(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        return (RespSetCardSwitch) decodePacket(fromServiceMsg.getWupBuffer(), "RespSetCardSwitch", new RespSetCardSwitch());
    }

    private Object l(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        return (SSummaryCardLableRsp) decodePacket(fromServiceMsg.getWupBuffer(), "SSummaryCardLableRsp", new SSummaryCardLableRsp());
    }

    private Object m(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespSetStateSwitch respSetStateSwitch = (RespSetStateSwitch) decodePacket(fromServiceMsg.getWupBuffer(), "RespSetStateSwitch", new RespSetStateSwitch());
        if (respSetStateSwitch != null) {
            return respSetStateSwitch;
        }
        return null;
    }

    private Object n(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        return (RespSummaryCard) decodePacket(fromServiceMsg.getWupBuffer(), "RespSummaryCard", new RespSummaryCard());
    }

    private void o(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        RespGetVoterList respGetVoterList = (RespGetVoterList) decodePacket(fromServiceMsg.getWupBuffer(), "RespGetVoterList", new RespGetVoterList());
        if (respGetVoterList.stHeader.iReplyCode != 0) {
            fromServiceMsg.setMsgFail();
        } else {
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.getAttributes().put("result", respGetVoterList);
        }
    }

    private boolean p(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        int i3;
        short s16;
        int i16 = toServiceMsg.extraData.getInt("param_page");
        long j3 = toServiceMsg.extraData.getLong("param_session_id");
        String string = toServiceMsg.extraData.getString("param_keyword");
        int i17 = toServiceMsg.extraData.getInt("param_sex_index");
        int i18 = toServiceMsg.extraData.getInt("param_age_index1");
        int i19 = toServiceMsg.extraData.getInt("param_age_index2");
        int i26 = toServiceMsg.extraData.getInt("param_job_index");
        int i27 = toServiceMsg.extraData.getInt("param_xingzuo_index");
        String[] stringArray = toServiceMsg.extraData.getStringArray("param_loc_code");
        String[] stringArray2 = toServiceMsg.extraData.getStringArray("param_home_code");
        ByteBuffer allocate = ByteBuffer.allocate(16);
        if (stringArray != null && stringArray.length == 4) {
            allocate.putInt(ConditionSearchManager.p(stringArray[0]));
            allocate.putInt(ConditionSearchManager.p(stringArray[1]));
            allocate.putInt(ConditionSearchManager.p(stringArray[2]));
            allocate.putInt(ConditionSearchManager.p(stringArray[3]));
        } else {
            allocate.putInt(0).putInt(0).putInt(0).putInt(0);
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(16);
        if (stringArray2 != null && stringArray2.length == 4) {
            allocate2.putInt(ConditionSearchManager.p(stringArray2[0]));
            allocate2.putInt(ConditionSearchManager.p(stringArray2[1]));
            allocate2.putInt(ConditionSearchManager.p(stringArray2[2]));
            allocate2.putInt(ConditionSearchManager.p(stringArray2[3]));
        } else {
            allocate2.putInt(0).putInt(0).putInt(0).putInt(0);
        }
        short s17 = (short) i18;
        short s18 = (short) i19;
        if (s17 < 0) {
            s17 = 0;
        }
        if (s17 > s18) {
            if (QLog.isColorLevel()) {
                i3 = 2;
                QLog.i("LBSService", 2, String.format("handleCondSearchFriend [%s, %s]--[%s, %s]", Integer.valueOf(i18), Integer.valueOf(i19), Short.valueOf(s17), Short.valueOf(ShortCompanionObject.MAX_VALUE)));
            } else {
                i3 = 2;
            }
            s16 = Short.MAX_VALUE;
        } else {
            i3 = 2;
            s16 = s18;
        }
        ReqCondSearch reqCondSearch = new ReqCondSearch(i16, j3, 1L, string, (byte) i17, allocate.array(), (short) 255, allocate2.array(), (byte) i27, i26, s17, s16);
        ReqHead reqHead = new ReqHead();
        reqHead.iVersion = i3;
        uniPacket.setServantName("SummaryCardServantObj");
        uniPacket.setFuncName("ReqCondSearch");
        uniPacket.put("ReqHead", reqHead);
        uniPacket.put("ReqCondSearch", reqCondSearch);
        toServiceMsg.setTimeout(15000L);
        toServiceMsg.setServiceCmd("SummaryCard.ReqCondSearch");
        return true;
    }

    private boolean q(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3 = toServiceMsg.extraData.getLong("selfUin");
        ReqDeleteVisitorRecord reqDeleteVisitorRecord = new ReqDeleteVisitorRecord(new QQService.ReqHead(j3, (short) 1, uniPacket.getRequestId(), (byte) 1, (byte) 0, null), toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN), toServiceMsg.extraData.getInt("type"));
        uniPacket.setServantName("VisitorSvc");
        uniPacket.setFuncName("ReqDeleteVisitorRecord");
        uniPacket.put("ReqDeleteVisitorRecord", reqDeleteVisitorRecord);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("VisitorSvc.ReqDeleteVisitorRecord");
        return true;
    }

    private boolean r(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
        long j16 = toServiceMsg.extraData.getLong("nextMid");
        int i3 = toServiceMsg.extraData.getInt("pageSize");
        QQService.ReqHead reqHead = new QQService.ReqHead(j3, (short) 1, uniPacket.getRequestId(), (byte) 1, (byte) 0, null);
        UserCntlData userCntlData = new UserCntlData(j16, new byte[0]);
        if (i3 >= 54) {
            i3 = 30;
        }
        ReqGetFavoriteList reqGetFavoriteList = new ReqGetFavoriteList(reqHead, userCntlData, i3);
        uniPacket.setServantName("VisitorSvc");
        uniPacket.setFuncName("ReqGetFavoriteList");
        uniPacket.put("ReqGetFavoriteList", reqGetFavoriteList);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("VisitorSvc.ReqGetFavoriteList");
        return true;
    }

    private boolean s(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        QQService.ReqHead reqHead = new QQService.ReqHead();
        reqHead.shVersion = (short) 2;
        reqHead.iSeq = uniPacket.getRequestId();
        reqHead.lUIN = Long.parseLong(toServiceMsg.getUin());
        ReqGetCardSwitch reqGetCardSwitch = new ReqGetCardSwitch(reqHead);
        uniPacket.setServantName("MCardSvc");
        uniPacket.setFuncName("ReqGetCardSwitch");
        uniPacket.put("ReqGetCardSwitch", reqGetCardSwitch);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("MCardSvc.ReqGetCardSwitch");
        return true;
    }

    private boolean t(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 2;
        reqHeader.lMID = BaseProtocolCoder.createUserId(Long.parseLong(toServiceMsg.getUin()));
        reqHeader.iAppID = AppSetting.f();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(64);
        ReqGetSwitches reqGetSwitches = new ReqGetSwitches(reqHeader, arrayList);
        uniPacket.setServantName("NeighborObj");
        uniPacket.setFuncName("CMD_GET_SWITCHES");
        uniPacket.put("ReqGetSwitches", reqGetSwitches);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("NeighborSvc.ReqGetSwitches");
        return true;
    }

    private boolean u(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3 = toServiceMsg.extraData.getLong("lToUIN");
        ReqPicSafetyCheck reqPicSafetyCheck = new ReqPicSafetyCheck(new QQService.ReqHead(j3, (short) 1, uniPacket.getRequestId(), (byte) 1, (byte) 0, null), j3, toServiceMsg.extraData.getInt("iScene"));
        uniPacket.setServantName("MCardSvc");
        uniPacket.setFuncName("ReqPicSafetyCheck");
        uniPacket.put("ReqPicSafetyCheck", reqPicSafetyCheck);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("MCardSvc.ReqPicSafetyCheck");
        return true;
    }

    private boolean v(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        long j3 = toServiceMsg.extraData.getLong("selfuin");
        byte[] byteArray = toServiceMsg.extraData.getByteArray("filekey");
        long j16 = toServiceMsg.extraData.getLong("timestamp");
        QQService.ReqHead reqHead = new QQService.ReqHead(j3, (short) 1, uniPacket.getRequestId(), (byte) 0, (byte) 0, null);
        FaceInfo faceInfo = new FaceInfo(byteArray, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(faceInfo);
        ReqDelFace reqDelFace = new ReqDelFace(reqHead, (int) j16, arrayList);
        uniPacket.setServantName("MCardSvc");
        uniPacket.setFuncName("ReqDelFace");
        uniPacket.put("ReqDelFace", reqDelFace);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("MCardSvc.ReqDelFace");
        return true;
    }

    private boolean w(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        String str;
        int i3;
        ArrayList arrayList;
        int i16;
        String string = toServiceMsg.extraData.getString("param_keyword");
        String string2 = toServiceMsg.extraData.getString("param_country_code");
        double d16 = toServiceMsg.extraData.getDouble("search_longtitude");
        double d17 = toServiceMsg.extraData.getDouble("search_latitude");
        int[] intArray = toServiceMsg.extraData.getIntArray("search_list");
        int i17 = toServiceMsg.extraData.getInt("search_page");
        int i18 = toServiceMsg.extraData.getInt("search_version");
        int i19 = toServiceMsg.extraData.getInt("filter_type", 0);
        String string3 = toServiceMsg.extraData.getString("trace_id", "");
        if (i18 != 2 && i18 == 3) {
            arrayList = new ArrayList();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(AppSetting.f99551k);
            sb5.append(".");
            String str2 = AppSetting.f99542b;
            sb5.append(str2);
            String sb6 = sb5.toString();
            try {
                i16 = Integer.parseInt(str2);
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, e16.toString());
                }
                i16 = 0;
            }
            int length = intArray.length;
            int i26 = 0;
            while (i26 < length) {
                int i27 = length;
                SummaryCardBusiEntry$comm summaryCardBusiEntry$comm = new SummaryCardBusiEntry$comm();
                String str3 = string2;
                int i28 = i18;
                summaryCardBusiEntry$comm.ver.set(1);
                summaryCardBusiEntry$comm.seq.set(toServiceMsg.getAppSeq());
                summaryCardBusiEntry$comm.service.set(intArray[i26]);
                ArrayList arrayList2 = arrayList;
                if (intArray[i26] == 80000004) {
                    summaryCardBusiEntry$comm.msg_login_sig.setHasFlag(true);
                    summaryCardBusiEntry$comm.msg_login_sig.uint32_type.set(64);
                    TicketManager ticketManager = (TicketManager) getApp().getManager(2);
                    if (ticketManager != null) {
                        if (!ticketManager.useAsyncTicketInterface()) {
                            String a26 = ticketManager.getA2(getApp().getCurrentAccountUin());
                            if (!TextUtils.isEmpty(a26) && !HexUtil.emptybytes.equals(a26)) {
                                summaryCardBusiEntry$comm.msg_login_sig.bytes_sig.set(ByteStringMicro.copyFromUtf8(a26));
                            }
                        } else {
                            QLog.d("LBSService", 1, "QZONE_SEARCH encodeReqMsg without A2");
                        }
                    }
                }
                summaryCardBusiEntry$comm.platform.set(2);
                summaryCardBusiEntry$comm.qqver.set(sb6);
                summaryCardBusiEntry$comm.build.set(i16);
                byte[] byteArray = summaryCardBusiEntry$comm.toByteArray();
                int length2 = byteArray.length;
                AccountSearchPb$search accountSearchPb$search = new AccountSearchPb$search();
                int i29 = i16;
                accountSearchPb$search.start.set(i17);
                int i36 = intArray[i26];
                String str4 = sb6;
                int[] iArr = intArray;
                if (i36 == 80000001) {
                    accountSearchPb$search.count.set(4);
                } else if (i36 == 80000003) {
                    accountSearchPb$search.count.set(8);
                }
                accountSearchPb$search.keyword.set(string);
                accountSearchPb$search.highlight.add(string);
                accountSearchPb$search.trace_id.set(string3);
                AccountSearchPb$Location accountSearchPb$Location = new AccountSearchPb$Location();
                accountSearchPb$Location.double_longitude.set(d16);
                accountSearchPb$Location.double_latitude.set(d17);
                accountSearchPb$search.msg_user_location.set(accountSearchPb$Location);
                accountSearchPb$search.filtertype.set(i19);
                if (QLog.isDevelopLevel()) {
                    QLog.d("LBSService", 4, "request has set filtertype " + i19);
                }
                byte[] byteArray2 = accountSearchPb$search.toByteArray();
                int length3 = byteArray2.length;
                byte[] bArr = new byte[length2 + 9 + length3 + 1];
                bArr[0] = 40;
                double d18 = d16;
                PkgTools.dWord2Byte(bArr, 1, length2);
                PkgTools.dWord2Byte(bArr, 5, length3);
                PkgTools.copyData(bArr, 9, byteArray, length2);
                int length4 = 9 + byteArray.length;
                PkgTools.copyData(bArr, length4, byteArray2, length3);
                bArr[length4 + length3] = 41;
                arrayList2.add(bArr);
                i26++;
                arrayList = arrayList2;
                length = i27;
                string2 = str3;
                i18 = i28;
                i16 = i29;
                sb6 = str4;
                intArray = iArr;
                d16 = d18;
                d17 = d17;
            }
            str = string2;
            i3 = i18;
        } else {
            str = string2;
            i3 = i18;
            arrayList = null;
        }
        ReqSearch reqSearch = new ReqSearch(string, str, i3, arrayList);
        ReqHead reqHead = new ReqHead();
        reqHead.iVersion = 2;
        uniPacket.setServantName("SummaryCardServantObj");
        uniPacket.setFuncName("ReqSearch");
        uniPacket.put("ReqHead", reqHead);
        uniPacket.put("ReqSearch", reqSearch);
        toServiceMsg.setTimeout(30000L);
        toServiceMsg.setServiceCmd("SummaryCard.ReqSearch");
        return true;
    }

    private boolean x(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        QQService.ReqHead reqHead = new QQService.ReqHead();
        reqHead.shVersion = (short) 2;
        reqHead.iSeq = uniPacket.getRequestId();
        reqHead.lUIN = Long.parseLong(toServiceMsg.getUin());
        int i3 = toServiceMsg.extraData.getInt("eSubCmd");
        byte b16 = toServiceMsg.extraData.getByte("bIsSingle");
        byte[] byteArray = toServiceMsg.extraData.getByteArray("vBackground");
        byte[] byteArray2 = toServiceMsg.extraData.getByteArray("vReqSetTemplate");
        try {
            arrayList = (ArrayList) new ObjectInputStream(new ByteArrayInputStream(toServiceMsg.extraData.getByteArray("vTagsID"))).readObject();
            try {
                arrayList2 = (ArrayList) new ObjectInputStream(new ByteArrayInputStream(toServiceMsg.extraData.getByteArray("vDelTags"))).readObject();
                try {
                    arrayList3 = (ArrayList) new ObjectInputStream(new ByteArrayInputStream(toServiceMsg.extraData.getByteArray("vAddTags"))).readObject();
                } catch (Exception e16) {
                    e = e16;
                    e.printStackTrace();
                    arrayList3 = null;
                    ReqSetCard reqSetCard = new ReqSetCard(reqHead, i3, b16, arrayList, byteArray, arrayList2, arrayList3, byteArray2);
                    uniPacket.setServantName("MCardSvc");
                    uniPacket.setFuncName("ReqSetCard");
                    uniPacket.put("ReqSetCard", reqSetCard);
                    toServiceMsg.setTimeout(10000L);
                    toServiceMsg.setServiceCmd("MCardSvc.ReqSetCard");
                    return true;
                }
            } catch (Exception e17) {
                e = e17;
                arrayList2 = null;
            }
        } catch (Exception e18) {
            e = e18;
            arrayList = null;
            arrayList2 = null;
        }
        ReqSetCard reqSetCard2 = new ReqSetCard(reqHead, i3, b16, arrayList, byteArray, arrayList2, arrayList3, byteArray2);
        uniPacket.setServantName("MCardSvc");
        uniPacket.setFuncName("ReqSetCard");
        uniPacket.put("ReqSetCard", reqSetCard2);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("MCardSvc.ReqSetCard");
        return true;
    }

    private boolean y(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        try {
            List list = (List) toServiceMsg.extraData.getSerializable("labels");
            if (list != null) {
                SSummaryCardSetLabel sSummaryCardSetLabel = new SSummaryCardSetLabel();
                sSummaryCardSetLabel.cmd = 4;
                sSummaryCardSetLabel.uin = Long.parseLong(getApp().getCurrentAccountUin());
                sSummaryCardSetLabel.version = AppSetting.f99551k;
                sSummaryCardSetLabel.platform = 109L;
                sSummaryCardSetLabel.labels = new ArrayList<>();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    sSummaryCardSetLabel.labels.add((Long) it.next());
                }
                uniPacket.setServantName("SummaryCard");
                uniPacket.setFuncName("SetLabel");
                uniPacket.put("SSummaryCardSetLabel", sSummaryCardSetLabel);
                toServiceMsg.setTimeout(10000L);
                toServiceMsg.setServiceCmd("SummaryCard.SetLabel");
                return true;
            }
            return false;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private boolean z(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        ReqSetCardSwitch reqSetCardSwitch;
        QQService.ReqHead reqHead = new QQService.ReqHead();
        reqHead.shVersion = (short) 2;
        reqHead.iSeq = uniPacket.getRequestId();
        reqHead.lUIN = Long.parseLong(toServiceMsg.getUin());
        boolean z16 = toServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
        long j3 = toServiceMsg.extraData.getLong("target_value");
        if (z16) {
            reqSetCardSwitch = new ReqSetCardSwitch(reqHead, j3, 2L);
        } else {
            reqSetCardSwitch = new ReqSetCardSwitch(reqHead, 2L, j3);
        }
        uniPacket.setServantName("MCardSvc");
        uniPacket.setFuncName("ReqSetCardSwitch");
        uniPacket.put("ReqSetCardSwitch", reqSetCardSwitch);
        toServiceMsg.setTimeout(10000L);
        toServiceMsg.setServiceCmd("MCardSvc.ReqSetCardSwitch");
        return true;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public String[] cmdHeaderPrefix() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f286141h;
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public Object decode(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
        }
        if ("MCardSvc.ReqDelFace".equals(fromServiceMsg.getServiceCmd())) {
            return (RespDelFace) decodePacket(fromServiceMsg.getWupBuffer(), "RespDelFace", new RespDelFace());
        }
        if ("MCardSvc.ReqSetCard".equals(fromServiceMsg.getServiceCmd())) {
            return i(fromServiceMsg, toServiceMsg);
        }
        if ("SummaryCard.SetLabel".equals(fromServiceMsg.getServiceCmd())) {
            return j(fromServiceMsg, toServiceMsg);
        }
        if ("SummaryCard.LikeIt".equals(fromServiceMsg.getServiceCmd())) {
            return l(fromServiceMsg, toServiceMsg);
        }
        if ("MCardSvc.ReqGetCardSwitch".equals(fromServiceMsg.getServiceCmd())) {
            return e(fromServiceMsg, toServiceMsg);
        }
        if ("MCardSvc.ReqSetCardSwitch".equals(fromServiceMsg.getServiceCmd())) {
            return k(fromServiceMsg, toServiceMsg);
        }
        if (ProfileCardServlet.CMD_REQ_SUMMARY_CARD.equals(fromServiceMsg.getServiceCmd())) {
            return n(fromServiceMsg, toServiceMsg);
        }
        if ("NeighborSvc.ReqSetStateSwitch".equals(fromServiceMsg.getServiceCmd())) {
            return m(fromServiceMsg, toServiceMsg);
        }
        if ("NeighborSvc.ReqGetSwitches".equals(fromServiceMsg.getServiceCmd())) {
            return f(fromServiceMsg, toServiceMsg);
        }
        if ("NeighborSvc.ReqGetPoint".equals(fromServiceMsg.getServiceCmd())) {
            return bz.b(this, fromServiceMsg, toServiceMsg);
        }
        if ("SummaryCard.ReqSearch".equals(fromServiceMsg.getServiceCmd())) {
            return g(fromServiceMsg, toServiceMsg);
        }
        if ("SummaryCard.ReqCondSearch".equals(fromServiceMsg.getServiceCmd())) {
            return b(fromServiceMsg, toServiceMsg);
        }
        return super.decode(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public void decodeRespMsg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if ("VisitorSvc.ReqGetVoterList".equals(fromServiceMsg.getServiceCmd())) {
            o(fromServiceMsg, toServiceMsg);
            return;
        }
        if ("VisitorSvc.ReqGetFavoriteList".equals(fromServiceMsg.getServiceCmd())) {
            d(fromServiceMsg, toServiceMsg);
            return;
        }
        if (!"MCardSvc.ReqPicSafetyCheck".equals(fromServiceMsg.getServiceCmd())) {
            if ("VisitorSvc.ReqDeleteVisitorRecord".equals(fromServiceMsg.getServiceCmd())) {
                c(fromServiceMsg, toServiceMsg);
            } else if ("VisitorSvc.ReqFavorite".equals(fromServiceMsg.getServiceCmd())) {
                bz.a(fromServiceMsg, toServiceMsg);
            }
        }
    }

    @Override // com.tencent.common.app.BaseProtocolCoder
    public boolean encodeReqMsg(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        if (toServiceMsg.getServiceCmd().equals("MCardSvc.ReqDelFace")) {
            return v(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCard")) {
            return x(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("SummaryCard.SetLabel")) {
            return y(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("SummaryCard.LikeIt")) {
            return A(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("MCardSvc.ReqGetCardSwitch")) {
            return s(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("MCardSvc.ReqSetCardSwitch")) {
            return z(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetVoterList")) {
            return D(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("VisitorSvc.ReqGetFavoriteList")) {
            return r(toServiceMsg, uniPacket);
        }
        if (toServiceMsg.getServiceCmd().equals("VisitorSvc.ReqDeleteVisitorRecord")) {
            return q(toServiceMsg, uniPacket);
        }
        if ("MCardSvc.ReqPicSafetyCheck".equals(toServiceMsg.getServiceCmd())) {
            return u(toServiceMsg, uniPacket);
        }
        if (ProfileCardServlet.CMD_REQ_SUMMARY_CARD.equals(toServiceMsg.getServiceCmd())) {
            return C(toServiceMsg, uniPacket);
        }
        if ("VisitorSvc.ReqFavorite".equals(toServiceMsg.getServiceCmd())) {
            return bz.h(toServiceMsg, uniPacket);
        }
        if ("NeighborSvc.ReqSetStateSwitch".equals(toServiceMsg.getServiceCmd())) {
            return B(toServiceMsg, uniPacket);
        }
        if ("NeighborSvc.ReqGetSwitches".equals(toServiceMsg.getServiceCmd())) {
            return t(toServiceMsg, uniPacket);
        }
        if ("NeighborSvc.ReqGetPoint".equals(toServiceMsg.getServiceCmd())) {
            return bz.f(this, toServiceMsg, uniPacket);
        }
        if ("SummaryCard.ReqSearch".equals(toServiceMsg.getServiceCmd())) {
            return w(toServiceMsg, uniPacket);
        }
        if ("SummaryCard.ReqCondSearch".equals(toServiceMsg.getServiceCmd())) {
            return p(toServiceMsg, uniPacket);
        }
        return false;
    }
}
