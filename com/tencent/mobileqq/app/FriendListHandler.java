package com.tencent.mobileqq.app;

import GeneralSettings.Setting;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ProfSmpInfoRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import QQService.BindUin;
import QQService.DeviceItemDes;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.device_lock_confirm_auth$DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth$ReqBody;
import com.tencent.ims.device_lock_recommend_auth$ReqBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.aio.tips.GatherContactsTipsHelper;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.addfriend.api.IDelFriendService;
import com.tencent.mobileqq.app.friendlist.receiver.FriendGroupReceiver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.pymk.api.IPYMKSwitchAGuideApi;
import com.tencent.mobileqq.pymk.api.IQQRecommendFriendApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.ReportPlugin;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RemarkParams;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.state.data.SquareJSConst;
import cooperation.qzone.remote.ServiceConst;
import friendlist.DelGroupResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import kotlin.jvm.internal.ShortCompanionObject;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager;
import org.slf4j.Marker;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1$ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1$ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1$SetFriendIdReq;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6$ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6$SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6$SnsUpdateItem;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4$GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4$GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4$OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4$ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4$RspBody;
import tencent.im.oidb.cmd0x7c6.cmd0x7c6$ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7$ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df$FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df$ReqBody;
import tencent.im.oidb.cmd0x972.oidb_0x972$ReqBody;
import tencent.im.oidb.cmd0x972.oidb_0x972$RootSearcherRequest;
import tencent.im.oidb.cmd0xaed.cmd0xaed$ReqBody;
import tencent.im.oidb.cmd0xaed.cmd0xaed$RspBody;
import tencent.im.oidb.cmd0xc83$ReqBody;
import tencent.im.oidb.cmd0xc85$ReqBody;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0$ReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$DeleteReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$GetListReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69$ReqBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72$ReqBody;
import tencent.im.oidb.oidb_0xc26$ReqBody;
import tencent.im.oidb.oidb_0xc35$ExposeItem;
import tencent.im.oidb.oidb_0xc35$ReqBody;
import tencent.im.oidb.oidb_0xc36$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11e.SubMsgType0x11e$MsgBody;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FriendListHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;
    public static final String ACTION_GATHER_RESP = "action_gather_resp";
    public static final int BOTH_DONGTAI = 3;
    public static final int CONNECTIONS_GET_DATA_MAX_COUNT = 50;
    private static final long DIFF_TIME_ZONE = 28800000;
    public static final short FIELD_0X49D_NICK = 20002;
    private static final short FRIENDNICK_MAX_COUNT = 500;
    private static final long GET_FRIEND_INFO_CHECK_INTERVAL_TIME = 60000;
    private static final long GET_FRIEND_INFO_EXPIRED_TIME = 1800000;
    private static final long GET_FRIEND_INFO_LIMIT_COUNT = 8;
    private static final long GET_FRIEND_INFO_TIMEOUT = 5000;
    private static final int GET_FRIEND_NUM = 200;
    private static final int GET_GROUP_NUM = 100;
    private static final long INTERVAL_ONE_DAY = 86400000;
    public static final String KEY_IS_GATHER = "key_is_gather";
    public static final String KEY_IS_SUC = "key_is_suc";
    public static final String KEY_SAFETY_FLAG = "safety_flag";
    private static final String KEY_STATUS_ENTRY = "StatusEntry";
    public static final String KEY_UIN = "uin";
    public static final String KEY_UIN_LIST = "key_uin_list";
    private static int MAX_COUNT_REQ_GETHER_MEMBER = 0;
    private static final int MAX_MOVE_FRI = 15;
    public static final long MIN_INTERVAL_GET_ONLINE = 15000;
    public static final int NOT_ADD_TMP_SESSION_TYPE = -1;
    public static final int NOT_ALLOWED_SEE_MY_DONGTAI = 1;
    public static final int OIDB_0X5D1_CONST_IS_BLACK = 4090;
    public static final int OIDB_0X5D1_CONST_IS_BLACKED = 4092;
    public static final int OIDB_0X5D1_CONST_OP_CLEAR = 2;
    public static final int OIDB_0X5D1_CONST_OP_SET = 1;
    public static final int OIDB_0X5D1_CONST_SHIELD = 4051;
    public static final int OIDB_IS_HIDE_BIG_CLUB = 42275;
    public static final String PARAMS_FRIEND_START_INDEX = "friendStartIndex";
    public static final String PARAMS_FRIEND_TOTAL_COUNT = "friendTotalCount";
    public static final String PARAM_CHAT_TYPES = "param_chat_types";
    public static final String PARAM_IS_SET_SWITCHES_OF_A_PERSON = "param_is_set_switches_of_a_person";
    public static final String PARAM_NOTIFY_PLUGIN = "param_notify_plugin";
    public static final String PARAM_RECOMMEND_TRACE_ID = "param_recommend_trace_id";
    public static final String PARAM_RING_IDS = "param_ring_ids";
    public static final String PARAM_SPECIAL_CARE_OPEN = "param_special_care_open";
    public static final String PARAM_STATUS_ITEM_LIST = "param_status_item_list";
    public static final String PARAM_SWITCH_STATE = "param_switch_state";
    public static final String PARAM_TYPE = "param_type";
    public static final String PARAM_UIN = "param_uin";
    public static final String PARAM_UINS = "param_uins";
    public static final int PUSH_UPDATE_0X210_0X11E_ALL = 1;
    public static final int PUSH_UPDATE_0X210_0X11E_INCREMENT = 2;
    private static final String QQ_HEAD_FLH = "Q.qqhead.flh";
    public static final int REPORT_RECEIVE_MSGBOX = 4;
    public static final int SHIELD_HIS_DONGTAI = 2;
    public static final int SIG_TYPE_CIRCLE = 1;
    public static final int SIG_TYPE_FRIEND = 0;
    public static final int SIG_TYPE_FRIEND_LIST = 3;
    public static final int SIG_TYPE_STRANGER = 2;
    public static final byte SRC_TYPE_CONTACT_TAB = 1;
    public static final byte SRC_TYPE_DEFAULT = 0;
    public static final byte SRC_TYPE_QCALL_LIST = 2;
    public static final byte SRC_TYPE_SPECIAL_CARE = 3;
    public static final String TAG = "FriendListHandler";
    public static final String TAG_GET_TROOP_MEMBER = "get_troop_member";
    public static final int TYPE_GLOBAL = 1;
    public static final int TYPE_NOTIFICATION_PREVIEW = 1;
    public static final int TYPE_NOTIFICATION_SOUND = 2;
    public static final int TYPE_NOTIFICATION_VIBRATE = 3;
    public static final int TYPE_QZONE = 3;
    public static final int TYPE_SPECIAL_RING = 2;
    public static final int UIN_SAFETY_SERVICE_TYPE_146 = 146;
    public static int getSpecialRecommendStat;
    private static final boolean ignoreHandlingSpecialCareSound;
    private static final boolean ignoreHandlingSpecialCareSoundRingId;
    public QQAppInterface app;
    private long failedStartTime;
    private int friendCountGeted;
    private Hashtable<String, FriendInfoDuplicate> friendInfoDuplicateTable;
    private long getOnlineFriendLastTimeStamp;
    private List<com.tencent.mobileqq.app.friendlist.receiver.a> handlerReceivers;
    public long intervalGetOnlineInfo;
    private boolean isSetOfflineDefaultValue;
    private boolean isSyncingAllFriendsRichStatus;
    private long lastFriendListUpdateTime;
    private long lastGreetingTime;
    private com.tencent.mobileqq.relationx.batchAdd.b mBatchAddFriendData;
    private Boolean mEnableOfflineTipsConfig;
    private int mFriendListFailedCount;
    private HashMap<String, com.tencent.mobileqq.app.handler.b> mGreetingDataMap;
    private final Object mGreetingLock;
    private HashMap<Long, String> mOfflineTips;
    private ArrayList<oidb_0x7df$FriendScore> mRecommendList;
    private final Object mRecommendLock;
    private volatile int mShowPcIcon;
    private int mStatusEntry;
    private int retryTotalCount;
    private short shBatchSeqTypeField;
    private long timeGetOnlineInfo;
    private String[] updateSignatureList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class FriendInfoDuplicate {
        static IPatchRedirector $redirector_;
        public long count;
        public long expiredTime;
        public long startTime;

        FriendInfoDuplicate() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.startTime = 0L;
            this.count = 0L;
            this.expiredTime = 0L;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 111)) {
            redirector.redirect((short) 111);
            return;
        }
        ignoreHandlingSpecialCareSound = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ignore_handling_special_care_sound_910", true);
        ignoreHandlingSpecialCareSoundRingId = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("ignore_handling_special_care_sound_ring_id_910", false);
        MAX_COUNT_REQ_GETHER_MEMBER = 100;
        getSpecialRecommendStat = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FriendListHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.mFriendListFailedCount = 0;
        this.failedStartTime = 0L;
        this.retryTotalCount = 0;
        this.friendCountGeted = 0;
        this.handlerReceivers = new ArrayList();
        this.mStatusEntry = -1;
        this.mShowPcIcon = -1;
        this.friendInfoDuplicateTable = new Hashtable<>();
        this.updateSignatureList = null;
        this.lastFriendListUpdateTime = 0L;
        this.getOnlineFriendLastTimeStamp = 0L;
        this.mGreetingDataMap = new HashMap<>(10);
        this.mGreetingLock = new Object();
        this.lastGreetingTime = 0L;
        this.isSetOfflineDefaultValue = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103073", true);
        this.shBatchSeqTypeField = (short) 20002;
        this.isSyncingAllFriendsRichStatus = false;
        this.intervalGetOnlineInfo = 15000L;
        this.timeGetOnlineInfo = 0L;
        this.mEnableOfflineTipsConfig = null;
        this.mRecommendList = new ArrayList<>();
        this.mRecommendLock = new Object();
        this.mBatchAddFriendData = null;
        this.app = qQAppInterface;
        init();
        registerHandlerReceivers();
    }

    private String convertUin(long j3) {
        if (j3 < 0) {
            j3 += 4294967296L;
        }
        return String.valueOf(j3);
    }

    public static void decodePush0x210_0x11e(QQAppInterface qQAppInterface, byte[] bArr) {
        if (bArr != null) {
            try {
                SubMsgType0x111$MsgBody subMsgType0x111$MsgBody = new SubMsgType0x111$MsgBody();
                subMsgType0x111$MsgBody.mergeFrom(bArr);
                long j3 = subMsgType0x111$MsgBody.uint64_type.has() ? subMsgType0x111$MsgBody.uint64_type.get() : -1L;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "decodePush0x210_0x111,type = " + j3);
                }
                FriendListHandler friendListHandler = (FriendListHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                if (j3 == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "decodePush0x210_0x111 update list");
                    }
                    friendListHandler.handleMayKnowRecommendPush((int) j3, null);
                    return;
                }
                if (j3 == 1) {
                    ArrayList arrayList = new ArrayList();
                    if (subMsgType0x111$MsgBody.rpt_msg_add_recommend_persons.has()) {
                        arrayList.addAll(MayKnowRecommend.covServerPushDataToLocal(subMsgType0x111$MsgBody.rpt_msg_add_recommend_persons.get(), System.currentTimeMillis()));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "decodePush0x210_0x111 add " + arrayList);
                    }
                    friendListHandler.handleMayKnowRecommendPush((int) j3, arrayList);
                    return;
                }
                if (j3 == 2) {
                    ArrayList arrayList2 = new ArrayList();
                    if (subMsgType0x111$MsgBody.rpt_uint64_del_uins.has()) {
                        arrayList2.addAll(subMsgType0x111$MsgBody.rpt_uint64_del_uins.get());
                    }
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        long longValue = ((Long) it.next()).longValue();
                        if (longValue > 0) {
                            arrayList3.add(String.valueOf(longValue));
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "decodePush0x210_0x111 del " + arrayList3);
                    }
                    friendListHandler.handleMayKnowRecommendPush((int) j3, arrayList3);
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.i(TAG, 1, "decodePush0x210_0x111 decode error, e=" + e16.toString());
                return;
            }
        }
        QLog.i(TAG, 1, "decodePush0x210_0x111 pbData = null");
    }

    private void doGetRichStatus(String[] strArr, int i3, int i16, Bundle bundle, boolean z16) {
        if (i3 >= strArr.length) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doGetRichStatus uinArray.lenth = " + strArr.length + " reqType = " + i16 + "pos = " + i3);
        }
        int min = Math.min(50, strArr.length - i3);
        String[] strArr2 = new String[min];
        System.arraycopy(strArr, i3, strArr2, 0, min);
        int i17 = i3 + min;
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_GETSIGNATURE);
        createToServiceMsg.extraData.putStringArray("totalArray", strArr);
        createToServiceMsg.extraData.putInt("nextStartPos", i17);
        createToServiceMsg.extraData.putStringArray("sendArray", strArr2);
        createToServiceMsg.extraData.putInt("reqType", i16);
        createToServiceMsg.extraData.putBoolean("showDateNickname", z16);
        createToServiceMsg.extraData.putBundle("circleBundle", bundle);
        send(createToServiceMsg);
    }

    private boolean enableOfflineTipsConfig() {
        Boolean bool = this.mEnableOfflineTipsConfig;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("contact_offline_status_tips_switch", false));
        this.mEnableOfflineTipsConfig = valueOf;
        return valueOf.booleanValue();
    }

    private List<String> getLoginUinList() {
        ArrayList arrayList = new ArrayList();
        List<SimpleAccount> allAccounts = MobileQQ.sMobileQQ.getAllAccounts();
        if (allAccounts != null && !allAccounts.isEmpty()) {
            for (SimpleAccount simpleAccount : new ArrayList(allAccounts)) {
                if (!TextUtils.isEmpty(simpleAccount.getUin())) {
                    arrayList.add(simpleAccount.getUin());
                }
            }
        }
        return arrayList;
    }

    private void handleAddBatchTroopMembers(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        com.tencent.mobileqq.relationx.batchAdd.b bVar = this.mBatchAddFriendData;
        if (bVar == null) {
            return;
        }
        bVar.e(this, toServiceMsg, fromServiceMsg, obj);
    }

    private boolean handleCheckUpdateItem(com.tencent.mobileqq.service.profile.a aVar, RespItem respItem) {
        if (aVar == null || respItem == null) {
            return false;
        }
        try {
            aVar.l2(respItem);
        } catch (OutOfMemoryError e16) {
            QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 1, String.format("encounter OutOfMemoryError when handleCheckUpdateItem() sId=%d ret=%d ex=%s \n%s", Integer.valueOf(respItem.eServiceID), Byte.valueOf(respItem.cResult), e16.getMessage(), Log.getStackTraceString(e16)));
        } catch (Throwable th5) {
            QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 1, th5.getMessage(), th5);
        }
        return true;
    }

    private void handleFriendRichStatus(ToServiceMsg toServiceMsg, Object obj) {
        ArrayList<ResRichSigInfo> arrayList;
        GetRichSigRes getRichSigRes = (GetRichSigRes) obj;
        if (getRichSigRes != null && getRichSigRes.cResult == 0 && (arrayList = getRichSigRes.vstSigInfo) != null && arrayList.size() != 0) {
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2 = new ArrayList<>(getRichSigRes.vstSigInfo.size());
            ArrayList arrayList3 = new ArrayList();
            IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Iterator<ResRichSigInfo> it = getRichSigRes.vstSigInfo.iterator();
            while (it.hasNext()) {
                ResRichSigInfo next = it.next();
                String l3 = Long.toString(next.lUin);
                if (next.cStatus == 1) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(iRelationNTUinAndUidApi.getUidFromUin(l3), l3);
                    dVar.M();
                    if (dVar.t() != next.dwTime || !Arrays.equals(dVar.s(), next.vbSigInfo)) {
                        com.tencent.mobileqq.richstatus.c.m(dVar, next.vbSigInfo, next.dwTime);
                        dVar.N(Boolean.valueOf(SignatureManager.m(this.app, l3, com.tencent.mobileqq.richstatus.c.h(dVar))));
                        if (QLog.isDebugVersion()) {
                            QLog.d(TAG, 2, "insertSignMsgIfNeeded from FriendList uin = " + l3 + " result = " + dVar.y());
                        }
                        arrayList2.add(dVar);
                        arrayList3.add(l3);
                    }
                }
            }
            if (arrayList3.size() > 0) {
                String[] strArr = new String[arrayList3.size()];
                arrayList3.toArray(strArr);
                notifyUI(2, true, strArr);
                iFriendsInfoService.accurateUpdateNTFriendSimpleInfo(arrayList2, TAG, (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
            }
            if (toServiceMsg.extraData.getInt("reqType") == 3 && this.isSyncingAllFriendsRichStatus && toServiceMsg.extraData.getStringArray("totalArray").length == toServiceMsg.extraData.getInt("nextStartPos")) {
                this.app.getPreferences().edit().putLong("inccheckupdatetimeStamp13", this.lastFriendListUpdateTime).commit();
                this.isSyncingAllFriendsRichStatus = false;
            }
            relayGetRichStatus(toServiceMsg);
            return;
        }
        if (toServiceMsg.extraData.getInt("reqType") == 3) {
            this.isSyncingAllFriendsRichStatus = false;
        }
        relayGetRichStatus(toServiceMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleGatherContactsResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18 = true;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z19 = toServiceMsg.extraData.getBoolean("isGather", true);
        boolean z26 = toServiceMsg.extraData.getBoolean("needNotifyPlugin", false);
        ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList("friendUinList");
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                    ArrayList<String> arrayList = new ArrayList<>();
                    IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        arrayList.add(iRelationNTUinAndUidApi.getUidFromUin(it.next()));
                    }
                    if (z19) {
                        iFriendsInfoService.normal2UnComUsed(TAG, arrayList, null);
                    } else {
                        iFriendsInfoService.doUnComUsed2Normal(TAG, arrayList, new hx3.b<Boolean>(stringArrayList) { // from class: com.tencent.mobileqq.app.FriendListHandler.12
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ ArrayList val$friendUinList;

                            {
                                this.val$friendUinList = stringArrayList;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListHandler.this, (Object) stringArrayList);
                                }
                            }

                            @Override // hx3.b
                            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                } else {
                                    GatherContactsTipsHelper.c(FriendListHandler.this.app, this.val$friendUinList);
                                }
                            }
                        });
                    }
                } else {
                    int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleGatherContactsResp fail: resultCode = " + i3);
                    }
                }
                z16 = z17;
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleGatherContactsResp,error: " + e16.getMessage());
                }
                z16 = false;
                if (z19) {
                }
                if (z26) {
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleGatherContactsResp,error: " + e17.getMessage());
                }
                z16 = false;
                if (z19) {
                }
                if (z26) {
                }
            }
        }
        if (z19) {
            notifyUI(86, z16, stringArrayList);
        } else {
            notifyUI(87, z16, stringArrayList);
        }
        if (z26) {
            Intent intent = new Intent(ACTION_GATHER_RESP);
            intent.putStringArrayListExtra(KEY_UIN_LIST, stringArrayList);
            intent.putExtra(KEY_IS_SUC, z16);
            if (!z19 ? z16 : !z16) {
                z18 = false;
            }
            intent.putExtra(KEY_IS_GATHER, z18);
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27, types: [boolean] */
    private void handleGetGatheredContactsList(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        char c16 = 2;
        if (fromServiceMsg.getResultCode() != 1000) {
            Boolean bool = Boolean.FALSE;
            notifyUI(75, false, new Object[]{bool, bool});
            return;
        }
        int i16 = toServiceMsg.extraData.getInt("startIndex");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException unused) {
        }
        if (!oidb_sso_oidbssopkg.uint32_result.has()) {
            Boolean bool2 = Boolean.FALSE;
            notifyUI(75, false, new Object[]{bool2, bool2});
            return;
        }
        int i17 = oidb_sso_oidbssopkg.uint32_result.get();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleGetGatheredContactsList result " + i17);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        if (i17 == 0) {
            cmd0x7c4$RspBody cmd0x7c4_rspbody = new cmd0x7c4$RspBody();
            try {
                cmd0x7c4_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                cmd0x7c4$GetSNFrdListRsp cmd0x7c4_getsnfrdlistrsp = cmd0x7c4_rspbody.msg_get_sn_frd_list_rsp.get();
                int i18 = cmd0x7c4_getsnfrdlistrsp.uint32_sequence.get();
                int i19 = cmd0x7c4_getsnfrdlistrsp.uint32_over.get();
                if (cmd0x7c4_rspbody.rpt_msg_recommend_reason.has()) {
                    ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).x0(cmd0x7c4_rspbody.rpt_msg_recommend_reason.get());
                }
                List<cmd0x7c4$OneFrdData> list = cmd0x7c4_getsnfrdlistrsp.rpt_msg_one_frd_data.get();
                FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
                IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                if (list != null) {
                    ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> arrayList = new ArrayList<>();
                    for (cmd0x7c4$OneFrdData cmd0x7c4_onefrddata : list) {
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.c();
                        String valueOf = String.valueOf(cmd0x7c4_onefrddata.uint64_frd_id.get());
                        cVar.w0(valueOf);
                        cVar.v0(iRelationNTUinAndUidApi.getUidFromUin(valueOf));
                        cVar.V(cmd0x7c4_onefrddata.uint32_ages.get());
                        cVar.q0((byte) cmd0x7c4_onefrddata.uint32_gender.get());
                        int i26 = cmd0x7c4_onefrddata.uint32_reason_id.get();
                        cVar.l0(friendsManager.N(i26));
                        arrayList.add(cVar);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb6 = new StringBuilder();
                            try {
                                sb6.append("handleGetGatheredContactsList Gather List : ");
                                sb6.append(cVar.x());
                                sb6.append(" ; resonId = ");
                                sb6.append(i26);
                                sb6.append(" ; f.recommReason =  ");
                                sb6.append(cVar.q());
                                sb6.append(" ; f.age = ");
                                sb6.append(cVar.b());
                                sb6.append(" ; f.gender = ");
                                sb6.append(cVar.v());
                                QLog.i(TAG, 2, sb6.toString());
                            } catch (Exception unused2) {
                                i3 = 2;
                                Object[] objArr = new Object[i3];
                                Boolean bool3 = Boolean.FALSE;
                                objArr[0] = bool3;
                                objArr[1] = bool3;
                                notifyUI(75, false, objArr);
                            }
                        }
                        c16 = 2;
                    }
                    if (friendsManager != null) {
                        friendsManager.t0(arrayList, i16);
                    }
                }
                if (cmd0x7c4_getsnfrdlistrsp.uint32_recommend_frd_count.has()) {
                    int i27 = cmd0x7c4_getsnfrdlistrsp.uint32_recommend_frd_count.get();
                    sb5.append("|recommend cnt=");
                    sb5.append(i27);
                } else {
                    sb5.append("|no recommend field");
                }
                boolean has = cmd0x7c4_rspbody.msg_box.has();
                this.app.getHandler(Conversation.class);
                if (has) {
                    if (QLog.isColorLevel()) {
                        try {
                            QLog.i(TAG, 2, "handleGetGatheredContactsList  has MsgBox. ");
                        } catch (Exception unused3) {
                            i3 = 2;
                            Object[] objArr2 = new Object[i3];
                            Boolean bool32 = Boolean.FALSE;
                            objArr2[0] = bool32;
                            objArr2[1] = bool32;
                            notifyUI(75, false, objArr2);
                        }
                    }
                    SharedPreferences sharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
                    boolean z16 = sharedPreferences.getBoolean("hasPulledRecomGathered", false);
                    sharedPreferences.edit().putBoolean("hasMsgBox", true).commit();
                    sb5.append("|has no MsgBox hasPulled=");
                    sb5.append(z16);
                    i3 = "|has no MsgBox hasPulled=";
                } else {
                    sb5.append("|has no MsgBox");
                    i3 = "|has no MsgBox";
                }
                try {
                    if (i19 == 0) {
                        int i28 = cmd0x7c4_getsnfrdlistrsp.uint32_next_start_idx.get();
                        sb5.append("|not Completed. continue to get. startIndex =");
                        sb5.append(i28);
                        getGatheredContactsList(i28);
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Boolean.FALSE;
                        objArr3[1] = Boolean.TRUE;
                        notifyUI(75, true, objArr3);
                    } else {
                        sb5.append("|not Completed. continue to get. Completed.");
                        this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putInt("GetFrdListReq_seq", i18).commit();
                        Object[] objArr4 = new Object[2];
                        Boolean bool4 = Boolean.TRUE;
                        objArr4[0] = bool4;
                        objArr4[1] = bool4;
                        notifyUI(75, true, objArr4);
                        if (friendsManager != null) {
                            friendsManager.k();
                        }
                    }
                    i3 = QLog.isColorLevel();
                    if (i3 != 0) {
                        try {
                            QLog.i(TAG, 2, sb5.toString());
                        } catch (Exception unused4) {
                            i3 = 2;
                            Object[] objArr22 = new Object[i3];
                            Boolean bool322 = Boolean.FALSE;
                            objArr22[0] = bool322;
                            objArr22[1] = bool322;
                            notifyUI(75, false, objArr22);
                        }
                    }
                } catch (Exception unused5) {
                }
            } catch (Exception unused6) {
                i3 = c16;
            }
        } else if (i17 == 1) {
            notifyUI(75, true, new Object[]{Boolean.TRUE, Boolean.FALSE});
        } else {
            Boolean bool5 = Boolean.FALSE;
            notifyUI(75, false, new Object[]{bool5, bool5});
        }
    }

    private void handleGetStrangerInfo(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        HashSet hashSet;
        boolean z18;
        int i3;
        boolean z19;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        hx3.c<NTVasSimpleInfo> cVar = null;
        if (!z16) {
            notifyUI(62, false, null);
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
            if (mergeFrom != null && mergeFrom.uint32_result.get() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                notifyUI(62, false, null);
                return;
            }
            ArrayList<NTVasSimpleInfo> arrayList = new ArrayList<>();
            HashSet hashSet2 = new HashSet();
            if (mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                ByteBuffer wrap = ByteBuffer.wrap(mergeFrom.bytes_bodybuffer.get().toByteArray());
                if (wrap.getInt() == -1) {
                    short s16 = wrap.getShort();
                    IVasInfoService iVasInfoService = (IVasInfoService) QRoute.api(IVasInfoService.class);
                    IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
                    int i16 = 0;
                    while (i16 < s16) {
                        long P = Utils.P(wrap.getInt());
                        NTVasSimpleInfo nTVasSimpleInfo = new NTVasSimpleInfo(iRelationNTUinAndUidApi.getUidFromUin(String.valueOf(P)), String.valueOf(P));
                        nTVasSimpleInfo.c();
                        short s17 = wrap.getShort();
                        if (s17 > 0) {
                            int i17 = 0;
                            z19 = false;
                            while (i17 < s17) {
                                short s18 = wrap.getShort();
                                z19 = z19 | com.tencent.mobileqq.app.friendlist.a.g(wrap, nTVasSimpleInfo, s18) | com.tencent.mobileqq.app.friendlist.a.j(wrap, nTVasSimpleInfo, s18) | com.tencent.mobileqq.app.friendlist.a.i(wrap, nTVasSimpleInfo, s18);
                                com.tencent.mobileqq.app.friendlist.a.h(this.app, wrap, P, s18);
                                i17++;
                                s17 = s17;
                            }
                        } else {
                            z19 = false;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "handleGetStrangerInfo, uin=" + P + ", pendant=" + nTVasSimpleInfo.pendantId + ",font=" + nTVasSimpleInfo.uVipFont + ", fontType = " + nTVasSimpleInfo.vipFontType);
                        }
                        if (z19) {
                            nTVasSimpleInfo.timestamp = System.currentTimeMillis();
                            arrayList.add(nTVasSimpleInfo);
                            hashSet2.add(nTVasSimpleInfo.getUin());
                        }
                        i16++;
                        cVar = null;
                    }
                    iVasInfoService.accurateUpdateVasSimpleInfo(arrayList, TAG, cVar);
                }
            }
            if (hashSet2.size() == 0) {
                z18 = true;
                i3 = 62;
                hashSet = null;
            } else {
                hashSet = hashSet2;
                z18 = true;
                i3 = 62;
            }
            notifyUI(i3, z18, hashSet);
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.STRANGER_INFO, 2, "handleGetStrangerInfo. addonId size : " + arrayList.size());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            notifyUI(62, false, null);
            if (QLog.isColorLevel()) {
                QLog.w(LogTag.STRANGER_INFO, 2, e16.getMessage());
            }
        }
    }

    private void handleSetHiddenChatResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "FriendListHandler.handleSetHiddenChatResp(). res=" + fromServiceMsg + ", data=" + obj);
        }
        String[] stringArray = toServiceMsg.extraData.getStringArray(PARAM_UINS);
        int[] intArray = toServiceMsg.extraData.getIntArray(PARAM_CHAT_TYPES);
        boolean[] booleanArray = toServiceMsg.extraData.getBooleanArray(PARAM_SWITCH_STATE);
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "parse oidb_sso.OIDBSSOPkg failed.");
                }
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                int i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "ssoPkg.uint32_result=" + i3);
                }
                if (i3 == 0) {
                    for (int i16 = 0; i16 < stringArray.length; i16++) {
                        String str = stringArray[i16];
                        boolean z17 = booleanArray[i16];
                        int i17 = intArray[i16];
                        FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(str, ProfileContants.FIELD_HIDDEN_CHAT_SWITCH, 21);
                        if (z17) {
                            updateFriendStatusItem.e(new byte[1]);
                        } else {
                            updateFriendStatusItem.e(null);
                        }
                        FriendsStatusUtil.h(this.app, updateFriendStatusItem, null);
                    }
                    z16 = true;
                    notifyUI(121, z16, new Object[]{stringArray, booleanArray});
                }
            }
        }
        z16 = false;
        notifyUI(121, z16, new Object[]{stringArray, booleanArray});
    }

    private void handleSetMessageNotificationSettingResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_MSG_NOTIFICATION, 2, "FriendListHandler.handleSetMessageNotificationSettingResp(). res=" + fromServiceMsg + ", data=" + obj);
        }
        MessageNotificationSettingManager l3 = MessageNotificationSettingManager.l(this.app);
        int i3 = toServiceMsg.extraData.getInt("param_type");
        String[] stringArray = toServiceMsg.extraData.getStringArray(PARAM_UINS);
        boolean[] booleanArray = toServiceMsg.extraData.getBooleanArray(PARAM_SWITCH_STATE);
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "parse oidb_sso.OIDBSSOPkg failed.");
                }
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                int i16 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, "ssoPkg.uint32_result=" + i16);
                }
                if (i16 == 0) {
                    for (int i17 = 0; i17 < stringArray.length; i17++) {
                        l3.T(stringArray[i17], i3, booleanArray[i17]);
                    }
                    z16 = true;
                    notifyUI(122, z16, new Object[]{stringArray, booleanArray, Integer.valueOf(i3)});
                }
            }
        }
        z16 = false;
        notifyUI(122, z16, new Object[]{stringArray, booleanArray, Integer.valueOf(i3)});
    }

    private void handleSetSpecialCareSwitchResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        int b16;
        FriendListHandler friendListHandler = this;
        int i16 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCH, 2, "FriendListHandler.handleSetSpecialCareSwitchResp(). res=" + fromServiceMsg + ", data=" + obj);
        }
        int i17 = toServiceMsg.extraData.getInt("param_type");
        String[] stringArray = toServiceMsg.extraData.getStringArray(PARAM_UINS);
        boolean[] booleanArray = toServiceMsg.extraData.getBooleanArray(PARAM_SWITCH_STATE);
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCH, 2, "parse oidb_sso.OIDBSSOPkg failed.");
                }
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                int i18 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCH, 2, "ssoPkg.uint32_result=" + i18);
                }
                if (i18 == 0) {
                    int i19 = 0;
                    while (i19 < stringArray.length) {
                        String str = stringArray[i19];
                        boolean z16 = booleanArray[i19];
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                        com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c();
                        cVar.m();
                        dVar.M();
                        String friendUidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(str);
                        if (i17 != 1) {
                            if (i17 != i16) {
                                if (i17 == 3) {
                                    dVar.w0(str);
                                    dVar.v0(friendUidFromUin);
                                    dVar.t0(Boolean.valueOf(z16));
                                    QLog.i(TAG, 1, "[setSpecialCareSwitch] type qzone, uin=" + str + ", isSwitchOn=" + z16);
                                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, TAG, new hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>(true, i17, stringArray, booleanArray) { // from class: com.tencent.mobileqq.app.FriendListHandler.5
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ boolean val$finalIsSuccess;
                                        final /* synthetic */ boolean[] val$switchState;
                                        final /* synthetic */ int val$type;
                                        final /* synthetic */ String[] val$uins;

                                        {
                                            this.val$finalIsSuccess = r6;
                                            this.val$type = i17;
                                            this.val$uins = stringArray;
                                            this.val$switchState = booleanArray;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                iPatchRedirector.redirect((short) 1, this, FriendListHandler.this, Boolean.valueOf(r6), Integer.valueOf(i17), stringArray, booleanArray);
                                            }
                                        }

                                        @Override // hx3.c
                                        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                                FriendListHandler.this.notifySpecialCareUI(this.val$finalIsSuccess, this.val$type, this.val$uins, this.val$switchState);
                                            } else {
                                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                            }
                                        }
                                    });
                                }
                                i3 = i19;
                            } else {
                                cVar.u(str);
                                cVar.t(friendUidFromUin);
                                cVar.q(z16 ? 1 : 0);
                                QLog.i(TAG, 1, "[setSpecialCareSwitch] type special ring, uin=" + str + ", isSwitchOn=" + z16);
                                i3 = i19;
                                ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(cVar, TAG, new hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>(z16, str, true, i17, stringArray, booleanArray) { // from class: com.tencent.mobileqq.app.FriendListHandler.4
                                    static IPatchRedirector $redirector_;
                                    final /* synthetic */ boolean val$finalIsSuccess;
                                    final /* synthetic */ boolean val$finalIsSwitchOn;
                                    final /* synthetic */ String val$finalUin;
                                    final /* synthetic */ boolean[] val$switchState;
                                    final /* synthetic */ int val$type;
                                    final /* synthetic */ String[] val$uins;

                                    {
                                        this.val$finalIsSwitchOn = z16;
                                        this.val$finalUin = str;
                                        this.val$finalIsSuccess = r8;
                                        this.val$type = i17;
                                        this.val$uins = stringArray;
                                        this.val$switchState = booleanArray;
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                            iPatchRedirector.redirect((short) 1, this, FriendListHandler.this, Boolean.valueOf(z16), str, Boolean.valueOf(r8), Integer.valueOf(i17), stringArray, booleanArray);
                                        }
                                    }

                                    @Override // hx3.c
                                    public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar) {
                                        IPatchRedirector iPatchRedirector = $redirector_;
                                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                            return;
                                        }
                                        if (this.val$finalIsSwitchOn) {
                                            com.tencent.mobileqq.activity.specialcare.e.t(this.val$finalUin, "1", FriendListHandler.this.app);
                                        }
                                        FriendListHandler.this.notifySpecialCareUI(this.val$finalIsSuccess, this.val$type, this.val$uins, this.val$switchState);
                                    }
                                });
                            }
                        } else {
                            i3 = i19;
                            dVar.w0(str);
                            dVar.v0(friendUidFromUin);
                            cVar.u(str);
                            cVar.t(friendUidFromUin);
                            dVar.s0(Boolean.valueOf(z16));
                            dVar.t0(Boolean.valueOf(z16));
                            cVar.q(z16 ? 1 : 0);
                            int a16 = com.tencent.mobileqq.notification.util.a.a(str);
                            if (a16 == 0 && z16 && (b16 = com.tencent.mobileqq.notification.util.a.b(friendListHandler.app, str)) != -1) {
                                cVar.p(b16);
                            }
                            QLog.i(TAG, 1, "[setSpecialCareSwitch] type global, uin=" + str + ", isSwitchOn=" + z16 + ", ringId=" + a16);
                            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, TAG, new hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>(cVar, z16, str, true, i17, stringArray, booleanArray) { // from class: com.tencent.mobileqq.app.FriendListHandler.3
                                static IPatchRedirector $redirector_;
                                final /* synthetic */ boolean val$finalIsSuccess;
                                final /* synthetic */ boolean val$finalIsSwitchOn;
                                final /* synthetic */ String val$finalUin;
                                final /* synthetic */ com.tencent.qqnt.ntrelation.otherinfo.bean.c val$ntOtherSimpleInfo;
                                final /* synthetic */ boolean[] val$switchState;
                                final /* synthetic */ int val$type;
                                final /* synthetic */ String[] val$uins;

                                {
                                    this.val$ntOtherSimpleInfo = cVar;
                                    this.val$finalIsSwitchOn = z16;
                                    this.val$finalUin = str;
                                    this.val$finalIsSuccess = r9;
                                    this.val$type = i17;
                                    this.val$uins = stringArray;
                                    this.val$switchState = booleanArray;
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                        iPatchRedirector.redirect((short) 1, this, FriendListHandler.this, cVar, Boolean.valueOf(z16), str, Boolean.valueOf(r9), Integer.valueOf(i17), stringArray, booleanArray);
                                    }
                                }

                                @Override // hx3.c
                                public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
                                    IPatchRedirector iPatchRedirector = $redirector_;
                                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                    } else {
                                        ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(this.val$ntOtherSimpleInfo, FriendListHandler.TAG, new hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>() { // from class: com.tencent.mobileqq.app.FriendListHandler.3.1
                                            static IPatchRedirector $redirector_;

                                            {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                                }
                                            }

                                            @Override // hx3.c
                                            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar2) {
                                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar2);
                                                    return;
                                                }
                                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                                if (anonymousClass3.val$finalIsSwitchOn) {
                                                    com.tencent.mobileqq.activity.specialcare.e.t(anonymousClass3.val$finalUin, "1", FriendListHandler.this.app);
                                                }
                                                AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                                FriendListHandler.this.notifySpecialCareUI(anonymousClass32.val$finalIsSuccess, anonymousClass32.val$type, anonymousClass32.val$uins, anonymousClass32.val$switchState);
                                            }
                                        });
                                    }
                                }
                            });
                        }
                        i19 = i3 + 1;
                        i16 = 2;
                        friendListHandler = this;
                    }
                }
            }
            return;
        }
        notifySpecialCareUI(false, i17, stringArray, booleanArray);
    }

    private void handleSetSpecialCareSwitchesOfAPersonResp(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Boolean bool;
        String[] strArr;
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCHES_OF_A_PERSON, 2, "FriendListHandler.handleSetSpecialCareSwitchesOfAPersonResp(). res=" + fromServiceMsg + ", data=" + obj);
        }
        String string = toServiceMsg.extraData.getString("param_uin");
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(string);
        int[] intArray = toServiceMsg.extraData.getIntArray("param_type");
        boolean[] booleanArray = toServiceMsg.extraData.getBooleanArray(PARAM_SWITCH_STATE);
        String[] stringArray = toServiceMsg.extraData.getStringArray(PARAM_RING_IDS);
        if (toServiceMsg.extraData.containsKey(PARAM_SPECIAL_CARE_OPEN)) {
            bool = Boolean.valueOf(toServiceMsg.extraData.getBoolean(PARAM_SPECIAL_CARE_OPEN));
        } else {
            bool = null;
        }
        Boolean bool2 = bool;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCHES_OF_A_PERSON, 2, "parse oidb_sso.OIDBSSOPkg failed.");
                }
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg.uint32_result.has()) {
                int i16 = oidb_sso_oidbssopkg.uint32_result.get();
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCHES_OF_A_PERSON, 2, "ssoPkg.uint32_result=" + i16);
                }
                if (i16 == 0) {
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d();
                    com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c();
                    dVar.M();
                    cVar.m();
                    dVar.w0(string);
                    dVar.v0(uidFromUin);
                    cVar.u(string);
                    cVar.t(uidFromUin);
                    if (bool2 != null) {
                        dVar.s0(bool2);
                    }
                    if (booleanArray != null && intArray != null && stringArray != null && booleanArray.length >= intArray.length && stringArray.length >= intArray.length) {
                        int i17 = 0;
                        while (i17 < intArray.length) {
                            int i18 = intArray[i17];
                            boolean z16 = booleanArray[i17];
                            String str = stringArray[i17];
                            if (i18 != 1) {
                                if (i18 != i3) {
                                    if (i18 != 3) {
                                        strArr = stringArray;
                                    } else {
                                        dVar.t0(Boolean.valueOf(z16));
                                        strArr = stringArray;
                                        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, TAG, new hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>(i16, true, string, intArray, booleanArray, strArr) { // from class: com.tencent.mobileqq.app.FriendListHandler.9
                                            static IPatchRedirector $redirector_;
                                            final /* synthetic */ boolean val$finalIsSuccess3;
                                            final /* synthetic */ int val$finalResult3;
                                            final /* synthetic */ String[] val$ringIds;
                                            final /* synthetic */ boolean[] val$switchState;
                                            final /* synthetic */ int[] val$types;
                                            final /* synthetic */ String val$uin;

                                            {
                                                this.val$finalResult3 = i16;
                                                this.val$finalIsSuccess3 = r7;
                                                this.val$uin = string;
                                                this.val$types = intArray;
                                                this.val$switchState = booleanArray;
                                                this.val$ringIds = strArr;
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                    iPatchRedirector.redirect((short) 1, this, FriendListHandler.this, Integer.valueOf(i16), Boolean.valueOf(r7), string, intArray, booleanArray, strArr);
                                                }
                                            }

                                            @Override // hx3.c
                                            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
                                                IPatchRedirector iPatchRedirector = $redirector_;
                                                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                                                    FriendListHandler.this.notifyFriendsUI(this.val$finalResult3, this.val$finalIsSuccess3, this.val$uin, this.val$types, this.val$switchState, this.val$ringIds);
                                                } else {
                                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                                }
                                            }
                                        });
                                    }
                                } else {
                                    strArr = stringArray;
                                    cVar.q(z16 ? 1 : 0);
                                    ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(cVar, TAG, new hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>(z16, string, str, i16, true, intArray, booleanArray, strArr) { // from class: com.tencent.mobileqq.app.FriendListHandler.8
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ boolean val$finalIsSuccess2;
                                        final /* synthetic */ boolean val$finalIsSwitchOn;
                                        final /* synthetic */ int val$finalResult2;
                                        final /* synthetic */ String val$finalRingId;
                                        final /* synthetic */ String[] val$ringIds;
                                        final /* synthetic */ boolean[] val$switchState;
                                        final /* synthetic */ int[] val$types;
                                        final /* synthetic */ String val$uin;

                                        {
                                            this.val$finalIsSwitchOn = z16;
                                            this.val$uin = string;
                                            this.val$finalRingId = str;
                                            this.val$finalResult2 = i16;
                                            this.val$finalIsSuccess2 = r10;
                                            this.val$types = intArray;
                                            this.val$switchState = booleanArray;
                                            this.val$ringIds = strArr;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                iPatchRedirector.redirect((short) 1, this, FriendListHandler.this, Boolean.valueOf(z16), string, str, Integer.valueOf(i16), Boolean.valueOf(r10), intArray, booleanArray, strArr);
                                            }
                                        }

                                        @Override // hx3.c
                                        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar) {
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                                return;
                                            }
                                            if (this.val$finalIsSwitchOn) {
                                                com.tencent.mobileqq.activity.specialcare.e.a(this.val$uin, this.val$finalRingId, FriendListHandler.this.app);
                                            }
                                            FriendListHandler.this.notifyFriendsUI(this.val$finalResult2, this.val$finalIsSuccess2, this.val$uin, this.val$types, this.val$switchState, this.val$ringIds);
                                        }
                                    });
                                }
                            } else {
                                strArr = stringArray;
                                if (z16) {
                                    dVar.p0("0");
                                    dVar.t0(Boolean.FALSE);
                                    dVar.s0(Boolean.TRUE);
                                    cVar.q(0);
                                    cVar.s(0L);
                                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, TAG, new hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>(cVar, string, i16, true, intArray, booleanArray, strArr) { // from class: com.tencent.mobileqq.app.FriendListHandler.6
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ boolean val$finalIsSuccess;
                                        final /* synthetic */ int val$finalResult;
                                        final /* synthetic */ com.tencent.qqnt.ntrelation.otherinfo.bean.c val$ntOtherSimpleInfo;
                                        final /* synthetic */ String[] val$ringIds;
                                        final /* synthetic */ boolean[] val$switchState;
                                        final /* synthetic */ int[] val$types;
                                        final /* synthetic */ String val$uin;

                                        {
                                            this.val$ntOtherSimpleInfo = cVar;
                                            this.val$uin = string;
                                            this.val$finalResult = i16;
                                            this.val$finalIsSuccess = r9;
                                            this.val$types = intArray;
                                            this.val$switchState = booleanArray;
                                            this.val$ringIds = strArr;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                iPatchRedirector.redirect((short) 1, this, FriendListHandler.this, cVar, string, Integer.valueOf(i16), Boolean.valueOf(r9), intArray, booleanArray, strArr);
                                            }
                                        }

                                        @Override // hx3.c
                                        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                            } else {
                                                ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(this.val$ntOtherSimpleInfo, FriendListHandler.TAG, new hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>() { // from class: com.tencent.mobileqq.app.FriendListHandler.6.1
                                                    static IPatchRedirector $redirector_;

                                                    {
                                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                                                        }
                                                    }

                                                    @Override // hx3.c
                                                    public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar2) {
                                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar2);
                                                            return;
                                                        }
                                                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                                        com.tencent.mobileqq.activity.specialcare.e.t(anonymousClass6.val$uin, "1", FriendListHandler.this.app);
                                                        AnonymousClass6 anonymousClass62 = AnonymousClass6.this;
                                                        FriendListHandler.this.notifyFriendsUI(anonymousClass62.val$finalResult, anonymousClass62.val$finalIsSuccess, anonymousClass62.val$uin, anonymousClass62.val$types, anonymousClass62.val$switchState, anonymousClass62.val$ringIds);
                                                    }
                                                });
                                            }
                                        }
                                    });
                                } else {
                                    dVar.p0("0");
                                    Boolean bool3 = Boolean.FALSE;
                                    dVar.t0(bool3);
                                    dVar.s0(bool3);
                                    cVar.q(0);
                                    cVar.s(0L);
                                    ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, TAG, new hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>(cVar, i16, true, string, intArray, booleanArray, strArr) { // from class: com.tencent.mobileqq.app.FriendListHandler.7
                                        static IPatchRedirector $redirector_;
                                        final /* synthetic */ boolean val$finalIsSuccess1;
                                        final /* synthetic */ int val$finalResult1;
                                        final /* synthetic */ com.tencent.qqnt.ntrelation.otherinfo.bean.c val$ntOtherSimpleInfo;
                                        final /* synthetic */ String[] val$ringIds;
                                        final /* synthetic */ boolean[] val$switchState;
                                        final /* synthetic */ int[] val$types;
                                        final /* synthetic */ String val$uin;

                                        {
                                            this.val$ntOtherSimpleInfo = cVar;
                                            this.val$finalResult1 = i16;
                                            this.val$finalIsSuccess1 = r8;
                                            this.val$uin = string;
                                            this.val$types = intArray;
                                            this.val$switchState = booleanArray;
                                            this.val$ringIds = strArr;
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                                iPatchRedirector.redirect((short) 1, this, FriendListHandler.this, cVar, Integer.valueOf(i16), Boolean.valueOf(r8), string, intArray, booleanArray, strArr);
                                            }
                                        }

                                        @Override // hx3.c
                                        public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar) {
                                            IPatchRedirector iPatchRedirector = $redirector_;
                                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                                            } else {
                                                ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(this.val$ntOtherSimpleInfo, FriendListHandler.TAG, new hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>() { // from class: com.tencent.mobileqq.app.FriendListHandler.7.1
                                                    static IPatchRedirector $redirector_;

                                                    {
                                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                                                        }
                                                    }

                                                    @Override // hx3.c
                                                    public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> eVar2) {
                                                        IPatchRedirector iPatchRedirector2 = $redirector_;
                                                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar2);
                                                        } else {
                                                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                                            FriendListHandler.this.notifyFriendsUI(anonymousClass7.val$finalResult1, anonymousClass7.val$finalIsSuccess1, anonymousClass7.val$uin, anonymousClass7.val$types, anonymousClass7.val$switchState, anonymousClass7.val$ringIds);
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                            }
                            i17++;
                            stringArray = strArr;
                            i3 = 2;
                        }
                        return;
                    }
                    notifyFriendsUI(i16, true, string, intArray, booleanArray, stringArray);
                    return;
                }
                notifyFriendsUI(i16, false, string, intArray, booleanArray, stringArray);
                return;
            }
            notifyFriendsUI(-1, false, string, intArray, booleanArray, stringArray);
            return;
        }
        notifyFriendsUI(-1, false, string, intArray, booleanArray, stringArray);
    }

    private void handleStrangerRichStatus(ToServiceMsg toServiceMsg, Object obj) {
        ArrayList<ResRichSigInfo> arrayList;
        GetRichSigRes getRichSigRes = (GetRichSigRes) obj;
        String[] stringArray = toServiceMsg.extraData.getStringArray("sendArray");
        if (getRichSigRes != null && getRichSigRes.cResult == 0 && (arrayList = getRichSigRes.vstSigInfo) != null && arrayList.size() != 0) {
            HashMap hashMap = new HashMap(stringArray.length);
            Iterator<ResRichSigInfo> it = getRichSigRes.vstSigInfo.iterator();
            while (it.hasNext()) {
                ResRichSigInfo next = it.next();
                hashMap.put(Long.toString(next.lUin), RichStatus.parseStatus(next.vbSigInfo));
            }
            notifyUI(61, true, new Object[]{stringArray, hashMap});
            relayGetRichStatus(toServiceMsg);
            return;
        }
        notifyUI(61, false, new Object[]{stringArray, null});
        relayGetRichStatus(toServiceMsg);
    }

    public static void initSpecialCareInfo(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar, int i3, String str, com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar) {
        if (i3 == 13568) {
            QLog.i(TAG, 1, "[initSpecialCareInfo] update special care sound, type = " + i3 + ", value = " + str);
            if (!ignoreHandlingSpecialCareSound) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        cVar.q(0);
                        return;
                    } else {
                        if (Pattern.compile("[0-9]*").matcher(str).matches()) {
                            if (ignoreHandlingSpecialCareSoundRingId) {
                                dVar.p0(str);
                            }
                            cVar.q(1);
                            return;
                        }
                        return;
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "initSpecialCareInfo|exception = ", e16);
                    }
                    cVar.q(1);
                    return;
                }
            }
            return;
        }
        if (i3 == 13573) {
            try {
                if (TextUtils.isEmpty(str)) {
                    dVar.s0(Boolean.FALSE);
                } else {
                    dVar.s0(Boolean.TRUE);
                }
                return;
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "initSpecialCareInfo|exception = ", e17);
                    return;
                }
                return;
            }
        }
        if (i3 == 13572) {
            try {
                if (TextUtils.isEmpty(str)) {
                    dVar.s0(Boolean.FALSE);
                } else {
                    dVar.s0(Boolean.TRUE);
                }
            } catch (Exception e18) {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 2, "initSpecialCareInfo|exception = ", e18);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setRemarkName$0(IOperateCallback iOperateCallback, boolean z16, String str, String str2, int i3, String str3) {
        boolean z17;
        QLog.i(TAG, 2, "setRemarkName onResult: " + i3 + " ,errMsg: " + str3);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str3);
        }
        if (z16) {
            Intent intent = new Intent(ProfileContants.ACTION_SET_REMARK_FOR_PLUGIN);
            intent.putExtra("uin", str);
            intent.putExtra("remark", str2);
            if (i3 == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            intent.putExtra(ProfileContants.KEY_IS_SUC, z17);
            BaseApplication.getContext().sendBroadcast(intent);
        }
    }

    private Map<String, Integer> makeGrneralPathMap(ArrayList<Setting> arrayList) {
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Setting setting = arrayList.get(i3);
                hashMap.put(setting.Path, Integer.valueOf(Integer.parseInt(setting.Value)));
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFriendsUI(int i3, boolean z16, String str, int[] iArr, boolean[] zArr, String[] strArr) {
        notifyUI(96, z16, new Object[]{Integer.valueOf(i3), str, iArr, zArr, strArr});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifySpecialCareUI(boolean z16, int i3, String[] strArr, boolean[] zArr) {
        Object[] objArr = {Integer.valueOf(i3), strArr, zArr};
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    notifyUI(94, z16, objArr);
                    return;
                }
                return;
            }
            notifyUI(93, z16, objArr);
            return;
        }
        notifyUI(92, z16, objArr);
    }

    public static oidb_sso$OIDBSSOPkg parseSSOPkg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
                }
            }
            if (oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                return oidb_sso_oidbssopkg;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + oidb_sso_oidbssopkg.uint32_result.get());
            }
        }
        return null;
    }

    private void relayGetRichStatus(ToServiceMsg toServiceMsg) {
        doGetRichStatus(toServiceMsg.extraData.getStringArray("totalArray"), toServiceMsg.extraData.getInt("nextStartPos"), toServiceMsg.extraData.getInt("reqType"), toServiceMsg.extraData.getBundle("circleBundle"), toServiceMsg.extraData.getBoolean("showDateNickname"));
    }

    private void saveToFriendDetailInfo(ProfSmpInfoRes profSmpInfoRes) {
        if (CrmUtils.s(profSmpInfoRes.cSpecialFlag) && !QidianManager.O(profSmpInfoRes.cSpecialFlag)) {
            return;
        }
        String valueOf = String.valueOf(profSmpInfoRes.dwUin);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(valueOf);
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "saveFriendInfoByUin uin=" + valueOf + ", cSpecialFlag=" + ((int) profSmpInfoRes.cSpecialFlag));
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(uidFromUin, valueOf);
        dVar.M();
        dVar.k0(profSmpInfoRes.strNick);
        byte b16 = profSmpInfoRes.cSex;
        if (b16 == 0) {
            i3 = 1;
        } else if (b16 != 1) {
            i3 = 0;
        }
        dVar.q0(i3);
        dVar.g0(System.currentTimeMillis());
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).accurateUpdateNTFriendSimpleInfo(dVar, TAG, (hx3.c<com.tencent.qqnt.ntrelation.friendsinfo.bean.d>) null);
    }

    private boolean shouldReqXMan(String str) {
        boolean z16;
        boolean equals = str.equals(this.app.getCurrentAccountUin());
        if (equals) {
            Context applicationContext = this.app.getApp().getApplicationContext();
            Card q16 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(str);
            long b16 = com.tencent.mobileqq.utils.z.b(applicationContext, str) + 28800000;
            long currentTimeMillis = System.currentTimeMillis() + 28800000;
            long j3 = q16.iXManScene1DelayTime * 1000;
            long j16 = b16 / 86400000;
            long j17 = currentTimeMillis / 86400000;
            if (j16 != j17 && Math.abs(currentTimeMillis - b16) > 28800000 && currentTimeMillis % 86400000 >= j3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("shouldReqXMan toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s lastReqDay=%s currentDay=%s lastReqInterval=%s time=%s", Boolean.valueOf(z16), Long.valueOf(b16), Long.valueOf(currentTimeMillis), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(Math.abs(currentTimeMillis - b16)), Long.valueOf(currentTimeMillis % 86400000)));
            }
            return z16;
        }
        return equals;
    }

    private boolean shouldReqXManScene2(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("shouldReqXManScene2 friendUin=%s", str));
        }
        boolean equals = str.equals(this.app.getCurrentAccountUin());
        if (equals) {
            Context applicationContext = this.app.getApp().getApplicationContext();
            Card q16 = ((FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(str);
            long a16 = com.tencent.mobileqq.utils.z.a(applicationContext, str);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = q16.iXManScene2DelayTime * 1000;
            if (j3 >= 0 && Math.abs(currentTimeMillis - a16) > j3) {
                equals = true;
            } else {
                equals = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("shouldReqXManScene2 toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s", Boolean.valueOf(equals), Long.valueOf(a16), Long.valueOf(currentTimeMillis), Long.valueOf(j3)));
            }
        }
        return equals;
    }

    public void addBatchQIMFriends(List<QIMNotifyAddFriend> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this, (Object) list);
            return;
        }
        cmd0xaed$ReqBody cmd0xaed_reqbody = new cmd0xaed$ReqBody();
        cmd0xaed_reqbody.uint64_qq_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
        StringBuilder sb5 = new StringBuilder("addBatchQIMFriends ");
        for (QIMNotifyAddFriend qIMNotifyAddFriend : list) {
            cmd0xaed_reqbody.rpt_uint64_add_qim_uins.add(Long.valueOf(qIMNotifyAddFriend.uin));
            if (QLog.isColorLevel()) {
                sb5.append(", ");
                sb5.append(qIMNotifyAddFriend.uin);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.QIM", 2, sb5.toString());
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2797);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xaed_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xaed_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void addFriendGroup(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, this, Byte.valueOf(b16), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "AddFriendGroup :" + str);
        }
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).addFriendGroup(b16, str);
    }

    public void addFriendTipsMr(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "----------addFriendTipsMr friendUin: " + str + ", sourceId=" + i3);
        }
        if (i3 == 2007 || i3 == 3007 || i3 == 4007 || i3 == 2017 || i3 == 3017) {
            this.app.getAVNotifyCenter().A0(Long.valueOf(str).longValue(), true, i3);
        }
        if (!TextUtils.isEmpty(str)) {
            IceBreakingUtil.y(this.app, str);
            synchronized (this.mGreetingLock) {
                com.tencent.mobileqq.app.handler.b bVar = this.mGreetingDataMap.get(str);
                if (bVar != null) {
                    addGreetingMsg(bVar.f195679d, bVar.f195680e, bVar.f195676a, bVar.f195678c, bVar.f195677b, bVar.f195681f, bVar.f195682g, bVar.f195683h);
                }
            }
        }
    }

    public boolean addFriendToFriendList(String str, int i3, int i16, String str2, boolean z16, boolean z17, long j3) {
        IPhoneContactService iPhoneContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return ((Boolean) iPatchRedirector.redirect((short) 70, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3))).booleanValue();
        }
        QLog.d(TAG, 1, "addFriendToFriendList " + str + ", " + i3 + ", " + i16 + ", " + str2 + ", " + z16);
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).isRobotUin(str) && (iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")) != null) {
            iPhoneContactService.onFriendListChanged();
        }
        return friendsManager.f(str, i3, z17, new hx3.c(str, friendsManager, i16) { // from class: com.tencent.mobileqq.app.FriendListHandler.11
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$addUin;
            final /* synthetic */ FriendsManager val$fmi;
            final /* synthetic */ int val$srcId;

            {
                this.val$addUin = str;
                this.val$fmi = friendsManager;
                this.val$srcId = i16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, FriendListHandler.this, str, friendsManager, Integer.valueOf(i16));
                }
            }

            @Override // hx3.c
            public void onUpdateResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                boolean booleanValue;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                ArrayList b16 = eVar.b();
                if (b16.isEmpty()) {
                    booleanValue = false;
                } else {
                    booleanValue = ((Boolean) b16.get(0)).booleanValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.d(FriendListHandler.TAG, 2, "FriendListHandler addFriendToFriendList flag = " + booleanValue);
                }
                if (booleanValue) {
                    FriendListHandler.this.app.getMessageFacade().Q(this.val$addUin, 0);
                    if (!((IFriendHandlerService) FriendListHandler.this.app.getRuntimeService(IFriendHandlerService.class)).isRequestingFriendList()) {
                        FriendListHandler.this.notifyUI(1, true, Boolean.TRUE);
                    }
                    if (((ITroopRobotService) FriendListHandler.this.app.getRuntimeService(ITroopRobotService.class)).isRobotUin(this.val$addUin)) {
                        ((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).setRobotSafeGrayTipAdded(this.val$addUin, false);
                    }
                    FriendListHandler.this.notifyUI(59, true, this.val$addUin);
                    com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) FriendListHandler.this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                    if (bVar != null) {
                        bVar.c().put("" + this.val$addUin, 1);
                    }
                    FriendListHandler.this.getFriendDetailInfo(this.val$addUin);
                    this.val$fmi.y0(this.val$addUin, false);
                    if (QidianManager.P(FriendListHandler.this.app, this.val$addUin) || (!CrmUtils.t(FriendListHandler.this.app, this.val$addUin) && !CrmUtils.r(FriendListHandler.this.app, this.val$addUin))) {
                        FriendListHandler.this.addFriendTipsMr(this.val$addUin, this.val$srcId);
                    }
                    com.tencent.mobileqq.app.friendlist.a.k(CrmUtils.t(FriendListHandler.this.app, this.val$addUin), FriendListHandler.this.app);
                }
                AddFrdStateMng y16 = this.val$fmi.y();
                if (y16 != null) {
                    y16.g(this.val$addUin);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.val$addUin);
                ChatActivityFacade.M(FriendListHandler.this.app, BaseApplication.getContext(), arrayList);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0208 A[Catch: all -> 0x03a9, TryCatch #1 {all -> 0x03a9, blocks: (B:34:0x010d, B:43:0x0208, B:50:0x02a4, B:52:0x02aa, B:54:0x032d, B:56:0x0333, B:58:0x034c, B:60:0x0367, B:61:0x036d, B:63:0x0375, B:64:0x037a, B:65:0x03a2, B:91:0x03a7, B:69:0x0122, B:71:0x015a, B:72:0x0161, B:75:0x0173, B:77:0x0192, B:78:0x0194, B:80:0x01a3, B:82:0x01af, B:85:0x01bc, B:88:0x037f), top: B:20:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02aa A[Catch: all -> 0x03a9, TryCatch #1 {all -> 0x03a9, blocks: (B:34:0x010d, B:43:0x0208, B:50:0x02a4, B:52:0x02aa, B:54:0x032d, B:56:0x0333, B:58:0x034c, B:60:0x0367, B:61:0x036d, B:63:0x0375, B:64:0x037a, B:65:0x03a2, B:91:0x03a7, B:69:0x0122, B:71:0x015a, B:72:0x0161, B:75:0x0173, B:77:0x0192, B:78:0x0194, B:80:0x01a3, B:82:0x01af, B:85:0x01bc, B:88:0x037f), top: B:20:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x032d A[Catch: all -> 0x03a9, TryCatch #1 {all -> 0x03a9, blocks: (B:34:0x010d, B:43:0x0208, B:50:0x02a4, B:52:0x02aa, B:54:0x032d, B:56:0x0333, B:58:0x034c, B:60:0x0367, B:61:0x036d, B:63:0x0375, B:64:0x037a, B:65:0x03a2, B:91:0x03a7, B:69:0x0122, B:71:0x015a, B:72:0x0161, B:75:0x0173, B:77:0x0192, B:78:0x0194, B:80:0x01a3, B:82:0x01af, B:85:0x01bc, B:88:0x037f), top: B:20:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x034c A[Catch: all -> 0x03a9, TryCatch #1 {all -> 0x03a9, blocks: (B:34:0x010d, B:43:0x0208, B:50:0x02a4, B:52:0x02aa, B:54:0x032d, B:56:0x0333, B:58:0x034c, B:60:0x0367, B:61:0x036d, B:63:0x0375, B:64:0x037a, B:65:0x03a2, B:91:0x03a7, B:69:0x0122, B:71:0x015a, B:72:0x0161, B:75:0x0173, B:77:0x0192, B:78:0x0194, B:80:0x01a3, B:82:0x01af, B:85:0x01bc, B:88:0x037f), top: B:20:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0367 A[Catch: all -> 0x03a9, TryCatch #1 {all -> 0x03a9, blocks: (B:34:0x010d, B:43:0x0208, B:50:0x02a4, B:52:0x02aa, B:54:0x032d, B:56:0x0333, B:58:0x034c, B:60:0x0367, B:61:0x036d, B:63:0x0375, B:64:0x037a, B:65:0x03a2, B:91:0x03a7, B:69:0x0122, B:71:0x015a, B:72:0x0161, B:75:0x0173, B:77:0x0192, B:78:0x0194, B:80:0x01a3, B:82:0x01af, B:85:0x01bc, B:88:0x037f), top: B:20:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0375 A[Catch: all -> 0x03a9, TryCatch #1 {all -> 0x03a9, blocks: (B:34:0x010d, B:43:0x0208, B:50:0x02a4, B:52:0x02aa, B:54:0x032d, B:56:0x0333, B:58:0x034c, B:60:0x0367, B:61:0x036d, B:63:0x0375, B:64:0x037a, B:65:0x03a2, B:91:0x03a7, B:69:0x0122, B:71:0x015a, B:72:0x0161, B:75:0x0173, B:77:0x0192, B:78:0x0194, B:80:0x01a3, B:82:0x01af, B:85:0x01bc, B:88:0x037f), top: B:20:0x00a7 }] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addGreetingMsg(String str, String str2, long j3, String str3, long j16, int i3, int i16, long j17) {
        ?? r17;
        Object obj;
        boolean z16;
        String str4;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean a16;
        boolean deletePhoneContactAddInfo;
        String str5 = str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, str, str2, Long.valueOf(j3), str5, Long.valueOf(j16), Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j17));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addGreetingMsg | uin is empty");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            r17 = 5;
            QLog.d(TAG, 2, String.format(Locale.getDefault(), "addGreetingMsg uin=%s, mobile=%s, addationMsg=%s, sourceid=%s, subSourceid=%s, requin=%s", str, str2, str5, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j17)));
        }
        Object obj2 = this.mGreetingLock;
        synchronized (obj2) {
            try {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                if (j16 != this.lastGreetingTime) {
                    if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG)) {
                        List<MessageRecord> Q = this.app.getMessageFacade().Q(str, 0);
                        if (Q != null && Q.size() > 0) {
                            z16 = false;
                            obj = obj2;
                            com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, this.app.getCurrentUin(), this.app.getApp().getString(R.string.f170324mb), 0, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 655362, j16);
                            MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                            messageForUniteGrayTip.initGrayTipMsg(this.app, gVar);
                            com.tencent.mobileqq.graytip.f.a(this.app, messageForUniteGrayTip);
                            z17 = true;
                        } else {
                            z16 = false;
                            obj = obj2;
                            ((INewFriendService) this.app.getRuntimeService(INewFriendService.class, "")).saveNewFriend2Cache(str);
                            MessageForText messageForText = (MessageForText) com.tencent.mobileqq.service.message.q.d(-1000);
                            messageForText.frienduin = str;
                            String string = this.app.getApp().getString(R.string.f170325md);
                            if (j17 == this.app.getLongAccountUin()) {
                                str5 = HardCodeUtil.qqStr(R.string.o2f);
                            }
                            String str6 = str5;
                            String currentAccountUin = this.app.getCurrentAccountUin();
                            if (TextUtils.isEmpty(str6)) {
                                str4 = string;
                            } else {
                                str4 = str6;
                            }
                            messageForText.init(currentAccountUin, str, str, str4, j16, -1000, 0, j16);
                            messageForText.isread = true;
                            if (j3 != -1) {
                                messageForText.vipBubbleID = j3;
                            }
                            this.app.getMsgHandler().I2(messageForText);
                            if (!TextUtils.isEmpty(str6) && j17 != this.app.getLongAccountUin()) {
                                String y16 = com.tencent.mobileqq.utils.ac.y(this.app, str);
                                if (TextUtils.isEmpty(y16)) {
                                    y16 = str;
                                }
                                MessageForGrayTips messageForGrayTips = (MessageForGrayTips) com.tencent.mobileqq.service.message.q.d(-1013);
                                z17 = true;
                                messageForGrayTips.init(this.app.getCurrentAccountUin(), str, str, String.format(HardCodeUtil.qqStr(R.string.o2o), y16), j16, -1013, 0, j16);
                                messageForGrayTips.isread = true;
                                this.app.getMsgHandler().I2(messageForGrayTips);
                            } else {
                                z17 = true;
                            }
                        }
                        if (i3 != 2093 && i3 != 3093) {
                            z18 = z16;
                            if (z18) {
                                String qqStr = HardCodeUtil.qqStr(R.string.o2p);
                                String qqStr2 = HardCodeUtil.qqStr(R.string.o2k);
                                String qqStr3 = HardCodeUtil.qqStr(R.string.o2n);
                                com.tencent.mobileqq.graytip.g gVar2 = new com.tencent.mobileqq.graytip.g(str, this.app.getCurrentUin(), qqStr, 0, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 135179, j16);
                                gVar2.f213683f = qqStr;
                                Bundle bundle = new Bundle();
                                bundle.putInt("key_action", 14);
                                bundle.putString("key_action_DATA", "from_batch_add_frd_for_troop");
                                gVar2.b(qqStr.indexOf(qqStr2), qqStr.indexOf(qqStr2) + qqStr2.length(), bundle);
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt("key_action", 13);
                                bundle2.putString("key_action_DATA", "from_batch_add_frd_for_troop");
                                gVar2.b(qqStr.indexOf(qqStr3), qqStr.indexOf(qqStr3) + qqStr3.length(), bundle2);
                                MessageForUniteGrayTip messageForUniteGrayTip2 = new MessageForUniteGrayTip();
                                messageForUniteGrayTip2.initGrayTipMsg(this.app, gVar2);
                                com.tencent.mobileqq.graytip.f.a(this.app, messageForUniteGrayTip2);
                            }
                            if (i3 != 3078 && i3 != 3079) {
                                z19 = z16;
                                a16 = friendlist.a.a(i3);
                                if (z19) {
                                    MessageForGrayTips messageForGrayTips2 = (MessageForGrayTips) com.tencent.mobileqq.service.message.q.d(-1013);
                                    messageForGrayTips2.init(this.app.getCurrentAccountUin(), str, str, this.app.getApp().getString(R.string.f170323ma), j16, -1013, 3, j16);
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putInt("key_action", 14);
                                    messageForGrayTips2.addHightlightItem(18, 22, bundle3);
                                    Bundle bundle4 = new Bundle();
                                    bundle4.putInt("key_action", 13);
                                    messageForGrayTips2.addHightlightItem(23, 27, bundle4);
                                    messageForGrayTips2.isread = true;
                                    this.app.getMsgHandler().I2(messageForGrayTips2);
                                    ReportController.o(this.app, "dc00898", "", "", "0X8007978", "0X8007978", 0, 0, "", "", "", "");
                                }
                                if (a16 && !TextUtils.isEmpty(str2)) {
                                    deletePhoneContactAddInfo = ((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).deletePhoneContactAddInfo(str2);
                                    if (QLog.isColorLevel()) {
                                        QLog.d(TAG, 2, "addGreetingMsg | deleted = " + deletePhoneContactAddInfo);
                                    }
                                    if (deletePhoneContactAddInfo) {
                                        notifyUI(124, true, str2);
                                    }
                                }
                                if (this.mGreetingDataMap.get(str) != null) {
                                    this.mGreetingDataMap.remove(str);
                                }
                                this.lastGreetingTime = j16;
                            }
                            z19 = true;
                            a16 = friendlist.a.a(i3);
                            if (z19) {
                            }
                            if (a16) {
                                deletePhoneContactAddInfo = ((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).deletePhoneContactAddInfo(str2);
                                if (QLog.isColorLevel()) {
                                }
                                if (deletePhoneContactAddInfo) {
                                }
                            }
                            if (this.mGreetingDataMap.get(str) != null) {
                            }
                            this.lastGreetingTime = j16;
                        }
                        z18 = z17;
                        if (z18) {
                        }
                        if (i3 != 3078) {
                            z19 = z16;
                            a16 = friendlist.a.a(i3);
                            if (z19) {
                            }
                            if (a16) {
                            }
                            if (this.mGreetingDataMap.get(str) != null) {
                            }
                            this.lastGreetingTime = j16;
                        }
                        z19 = true;
                        a16 = friendlist.a.a(i3);
                        if (z19) {
                        }
                        if (a16) {
                        }
                        if (this.mGreetingDataMap.get(str) != null) {
                        }
                        this.lastGreetingTime = j16;
                    } else {
                        obj = obj2;
                        com.tencent.mobileqq.app.handler.b bVar = new com.tencent.mobileqq.app.handler.b();
                        bVar.f195679d = str;
                        bVar.f195678c = str5;
                        bVar.f195676a = j3;
                        bVar.f195677b = j16;
                        bVar.f195681f = i3;
                        bVar.f195682g = i16;
                        bVar.f195680e = str2;
                        bVar.f195683h = j17;
                        this.mGreetingDataMap.put(str, bVar);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                r17 = obj2;
                throw th;
            }
        }
    }

    public void agreeSuspiciousMsg(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            iPatchRedirector.redirect((short) 110, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "agreeSuspiciousMsg " + j3);
        }
        oidb_cmd0xd72$ReqBody oidb_cmd0xd72_reqbody = new oidb_cmd0xd72$ReqBody();
        oidb_cmd0xd72_reqbody.doubt_uin.set(j3);
        oidb_cmd0xd72_reqbody.uin.set(this.app.getLongAccountUin());
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd72", 3442, 0, oidb_cmd0xd72_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("toUin", Long.valueOf(j3));
        sendPbReq(makeOIDBPkg);
    }

    public boolean batchAddFriendForTroopMembers(String str, String str2, String str3, List<String> list, boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return ((Boolean) iPatchRedirector.redirect((short) 101, this, str, str2, str3, list, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18))).booleanValue();
        }
        if (this.mBatchAddFriendData == null) {
            this.mBatchAddFriendData = new com.tencent.mobileqq.relationx.batchAdd.b();
        }
        boolean f16 = this.mBatchAddFriendData.f(str, str2, str3, list, z16, i3, i16, i17, i18);
        if (f16) {
            this.mBatchAddFriendData.b(this);
        }
        return f16;
    }

    public void cancelMayKnowRecommend(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, (Object) str);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(str) { // from class: com.tencent.mobileqq.app.FriendListHandler.14
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$uin;

                {
                    this.val$uin = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendListHandler.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(FriendListHandler.TAG, 2, "cancelMayKnowRecommend|uin = " + this.val$uin);
                    }
                    ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).removeRecommendData(this.val$uin);
                    FriendListHandler.this.notifyUI(89, true, this.val$uin);
                    try {
                        oidb_0xc36$ReqBody oidb_0xc36_reqbody = new oidb_0xc36$ReqBody();
                        ArrayList arrayList = new ArrayList(1);
                        arrayList.add(Long.valueOf(Long.parseLong(this.val$uin)));
                        oidb_0xc36_reqbody.rpt_uint64_uins.set(arrayList);
                        ToServiceMsg makeOIDBPkg = FriendListHandler.this.makeOIDBPkg("OidbSvc.0xc36_0", 3126, 0, oidb_0xc36_reqbody.toByteArray());
                        makeOIDBPkg.extraData.putString("uin", this.val$uin);
                        FriendListHandler.this.sendPbReq(makeOIDBPkg);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d(FriendListHandler.TAG, 2, "cancelMayKnowRecommend", e16);
                        }
                    }
                }
            });
        }
    }

    public void changeFriendShieldFlag(long j3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, this, Long.valueOf(j3), Boolean.valueOf(z16));
        } else {
            send_oidb_0x5d1_0(j3, OIDB_0X5D1_CONST_SHIELD, z16);
        }
    }

    public void condtionalSearchFriendBy0x972(long j3, int i3, byte[] bArr, String str, int i16, int i17, int i18, String[] strArr, String[] strArr2, int i19, int i26, int i27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(j3), Integer.valueOf(i3), bArr, str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), strArr, strArr2, Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "condtionalSearchFriendBy0x972 seq = " + j3 + ",page = " + i3 + ",cookie = " + bArr);
        }
        oidb_0x972$ReqBody oidb_0x972_reqbody = new oidb_0x972$ReqBody();
        short s16 = (short) i17;
        short s17 = (short) i18;
        if (s16 < 0) {
            s16 = 0;
        }
        if (s16 > s17) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, String.format("handleCondSearchFriend [%s, %s]--[%s, %s]", Integer.valueOf(i17), Integer.valueOf(i18), Short.valueOf(s16), Short.valueOf(ShortCompanionObject.MAX_VALUE)));
            }
            s17 = Short.MAX_VALUE;
        }
        oidb_0x972_reqbody.key_word.set(ByteStringMicro.copyFromUtf8(str));
        oidb_0x972_reqbody.version.set(ByteStringMicro.copyFromUtf8(AppSetting.f99551k));
        oidb_0x972$RootSearcherRequest oidb_0x972_rootsearcherrequest = new oidb_0x972$RootSearcherRequest();
        oidb_0x972_rootsearcherrequest.page_size.set(25);
        if (bArr != null) {
            oidb_0x972_rootsearcherrequest.cookie.set(ByteStringMicro.copyFrom(bArr));
        }
        oidb_0x972_reqbody.search_request.set(oidb_0x972_rootsearcherrequest);
        oidb_0x972_reqbody.gander.set(i16);
        oidb_0x972_reqbody.start_age.set(s16);
        oidb_0x972_reqbody.end_age.set(s17);
        oidb_0x972_reqbody.constellation.set(i26);
        if (strArr != null && strArr.length >= 3) {
            oidb_0x972_reqbody.country_id.set(ConditionSearchManager.p(strArr[0]));
            oidb_0x972_reqbody.province_id.set(ConditionSearchManager.p(strArr[1]));
            oidb_0x972_reqbody.city_id.set(ConditionSearchManager.p(strArr[2]));
        }
        if (strArr2 != null && strArr2.length >= 3) {
            oidb_0x972_reqbody.h_country_id.set(ConditionSearchManager.p(strArr2[0]));
            oidb_0x972_reqbody.h_province_id.set(ConditionSearchManager.p(strArr2[1]));
            oidb_0x972_reqbody.h_city_id.set(ConditionSearchManager.p(strArr2[2]));
        }
        oidb_0x972_reqbody.career_id.set(i19);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x972_5", 2418, 5, oidb_0x972_reqbody.toByteArray());
        makeOIDBPkg.extraData.putLong("search_seq", j3);
        makeOIDBPkg.extraData.putInt("param_page", i3);
        makeOIDBPkg.extraData.putString("param_keyword", str);
        makeOIDBPkg.extraData.putInt("param_sex_index", i16);
        makeOIDBPkg.extraData.putInt("param_age_index1", i17);
        makeOIDBPkg.extraData.putInt("param_age_index2", i18);
        makeOIDBPkg.extraData.putStringArray("param_loc_code", strArr);
        makeOIDBPkg.extraData.putStringArray("param_home_code", strArr2);
        makeOIDBPkg.extraData.putInt("param_job_index", i19);
        makeOIDBPkg.extraData.putInt("param_xingzuo_index", i26);
        makeOIDBPkg.extraData.putInt("param_search_from", i27);
        sendPbReq(makeOIDBPkg);
    }

    public void confirmContactFriend(int i3, long j3, long j16, byte[] bArr, byte b16, String str, long j17, long j18) {
        long j19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), bArr, Byte.valueOf(b16), str, Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BumpSvc.ReqComfirmContactFriend");
        RespondQueryQQBindingStat selfBindInfo = ((IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
        if (selfBindInfo != null) {
            String str2 = selfBindInfo.nationCode + selfBindInfo.mobileNo;
            if (str2 != null && str2.length() > 0) {
                if (str2.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                    str2 = str2.substring(1);
                }
                j19 = Long.parseLong(str2);
                toServiceMsg.extraData.putInt("bType", i3);
                toServiceMsg.extraData.putLong("lToMID", j3);
                toServiceMsg.extraData.putLong("lFromMobile", j19);
                toServiceMsg.extraData.putLong("lToMobile", j16);
                toServiceMsg.extraData.putByteArray("vSig", bArr);
                toServiceMsg.extraData.putByte("bGroupId", b16);
                toServiceMsg.extraData.putString("strNickName", str);
                toServiceMsg.extraData.putLong("infotime", j17);
                toServiceMsg.extraData.putLong("dbid", j18);
                send(toServiceMsg);
            }
        }
        j19 = 0;
        toServiceMsg.extraData.putInt("bType", i3);
        toServiceMsg.extraData.putLong("lToMID", j3);
        toServiceMsg.extraData.putLong("lFromMobile", j19);
        toServiceMsg.extraData.putLong("lToMobile", j16);
        toServiceMsg.extraData.putByteArray("vSig", bArr);
        toServiceMsg.extraData.putByte("bGroupId", b16);
        toServiceMsg.extraData.putString("strNickName", str);
        toServiceMsg.extraData.putLong("infotime", j17);
        toServiceMsg.extraData.putLong("dbid", j18);
        send(toServiceMsg);
    }

    public void create0x5d6RequestPackage(int i3, ArrayList<FriendsStatusUtil.UpdateFriendStatusItem> arrayList, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), arrayList, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, " create0x5d6SendPackage serType=" + i3);
        }
        if (arrayList != null && arrayList.size() <= 20) {
            ArrayList arrayList2 = new ArrayList(1);
            for (int i17 = 0; i17 < arrayList.size(); i17++) {
                FriendsStatusUtil.UpdateFriendStatusItem updateFriendStatusItem = arrayList.get(i17);
                oidb_0x5d6$SnsUpateBuffer oidb_0x5d6_snsupatebuffer = new oidb_0x5d6$SnsUpateBuffer();
                oidb_0x5d6_snsupatebuffer.uint64_uin.set(Long.parseLong(updateFriendStatusItem.f196578d));
                ArrayList arrayList3 = new ArrayList(1);
                oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem = new oidb_0x5d6$SnsUpdateItem();
                oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(updateFriendStatusItem.f196580f);
                byte[] a16 = updateFriendStatusItem.a();
                if (a16 != null) {
                    oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom(a16));
                }
                arrayList3.add(oidb_0x5d6_snsupdateitem);
                oidb_0x5d6_snsupatebuffer.rpt_msg_sns_update_item.set(arrayList3);
                arrayList2.add(oidb_0x5d6_snsupatebuffer);
            }
            oidb_0x5d6$ReqBody oidb_0x5d6_reqbody = new oidb_0x5d6$ReqBody();
            oidb_0x5d6_reqbody.uint32_seq.set(0);
            oidb_0x5d6_reqbody.rpt_msg_update_buffer.set(arrayList2);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1494);
            oidb_sso_oidbssopkg.uint32_service_type.set(i3);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d6_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg(str);
            createToServiceMsg.extraData.putParcelableArrayList(PARAM_STATUS_ITEM_LIST, arrayList);
            createToServiceMsg.extraData.putInt("param_type", i3);
            createToServiceMsg.extraData.putBoolean(PARAM_NOTIFY_PLUGIN, z16);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder("create0x5d6SendPackage serType=");
            sb5.append(i3);
            sb5.append(" length=");
            if (arrayList != null) {
                i16 = arrayList.size();
            }
            sb5.append(i16);
            QLog.d(TAG, 4, sb5.toString());
        }
    }

    public void delAuthDev(String str, ArrayList<DeviceItemDes> arrayList, boolean z16, long j3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, str, arrayList, Boolean.valueOf(z16), Long.valueOf(j3), bArr);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_DEL_DEVLOGININFO);
        createToServiceMsg.extraData.putString("strAppName", str);
        createToServiceMsg.addAttribute("vecDeviceItemDes", arrayList);
        createToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
        createToServiceMsg.extraData.putInt("iDelType", 2);
        createToServiceMsg.extraData.putByteArray("devGuid", bArr);
        if (z16) {
            createToServiceMsg.extraData.putInt("iDelMe", 1);
        } else {
            createToServiceMsg.extraData.putInt("iDelMe", 0);
        }
        createToServiceMsg.extraData.putLong("iAppId", j3);
        send(createToServiceMsg);
    }

    @Deprecated
    public void delFriend(String str, String str2, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 53)) {
            delFriend(str, str2, b16, -1);
        } else {
            iPatchRedirector.redirect((short) 53, this, str, str2, Byte.valueOf(b16));
        }
    }

    public void delHistoryDev(String str, ArrayList<DeviceItemDes> arrayList, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, this, str, arrayList, bArr);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_DEL_DEVLOGININFO);
        createToServiceMsg.extraData.putString("strAppName", str);
        createToServiceMsg.addAttribute("vecDeviceItemDes", arrayList);
        createToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
        createToServiceMsg.extraData.putInt("iDelType", 1);
        createToServiceMsg.extraData.putByteArray("devGuid", bArr);
        send(createToServiceMsg);
    }

    public void delMultiClient(String str, ArrayList<DeviceItemDes> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, this, str, arrayList, Integer.valueOf(i3));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_DEL_DEVLOGININFO);
        createToServiceMsg.extraData.putString("strAppName", str);
        createToServiceMsg.addAttribute("vecDeviceItemDes", arrayList);
        createToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
        createToServiceMsg.extraData.putInt("index", i3);
        send(createToServiceMsg);
    }

    public void deleteAllSuspiciousMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "deleteAllSuspiciousMsg ");
        }
        oidb_cmd0xd69$ReqBody oidb_cmd0xd69_reqbody = new oidb_cmd0xd69$ReqBody();
        oidb_cmd0xd69_reqbody.cmd_type.set(4);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, oidb_cmd0xd69_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("cmd", 4);
        sendPbReq(makeOIDBPkg);
    }

    public void deleteFriendGroup(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, Byte.valueOf(b16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "DeleteFriendGroup :" + ((int) b16));
        }
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).deleteFriendGroup(b16);
    }

    public void deleteStrangerInfo(FriendsManager friendsManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) friendsManager);
            return;
        }
        Set<String> n3 = com.tencent.mobileqq.activity.specialcare.e.n(this.app);
        if (friendsManager != null && n3 != null && n3.size() > 0) {
            for (String str : n3) {
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), TAG)) {
                    com.tencent.mobileqq.activity.specialcare.e.b(str, this.app);
                    if (com.tencent.mobileqq.activity.specialcare.e.q(str, this.app)) {
                        com.tencent.mobileqq.activity.specialcare.e.d(str, this.app);
                    }
                }
            }
        }
    }

    public void deleteSuspiciousMsg(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "deleteSuspiciousMsg " + j3);
        }
        oidb_cmd0xd69$ReqBody oidb_cmd0xd69_reqbody = new oidb_cmd0xd69$ReqBody();
        oidb_cmd0xd69_reqbody.cmd_type.set(3);
        oidb_cmd0xd69$DeleteReqBody oidb_cmd0xd69_deletereqbody = new oidb_cmd0xd69$DeleteReqBody();
        oidb_cmd0xd69_deletereqbody.doubt_uin.set(j3);
        oidb_cmd0xd69_reqbody.msg_delete_body.set(oidb_cmd0xd69_deletereqbody);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, oidb_cmd0xd69_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("cmd", 3);
        makeOIDBPkg.addAttribute("uin", Long.valueOf(j3));
        sendPbReq(makeOIDBPkg);
    }

    public void fetchRichStatusIfNeed(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) arrayList);
            return;
        }
        if (!arrayList.isEmpty()) {
            String[] strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
            arrayList.clear();
            if (this.app.mAutomator.H2()) {
                getRichStatusForFriendList(strArr);
            } else {
                this.updateSignatureList = strArr;
            }
        }
    }

    public void gatherContacts(short s16, List<String> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 88)) {
            gatherContacts(s16, list, z16, false);
        } else {
            iPatchRedirector.redirect((short) 88, this, Short.valueOf(s16), list, Boolean.valueOf(z16));
        }
    }

    public void getAuthLoginAndOnlineDevList(long j3, String str, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, this, Long.valueOf(j3), str, Long.valueOf(j16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO);
        createToServiceMsg.extraData.putLong("iLoginType", 1L);
        createToServiceMsg.extraData.putLong("iNextItemIndex", j16);
        createToServiceMsg.extraData.putLong("iRequireMax", 20L);
        createToServiceMsg.extraData.putLong("iTimeStamp", j3);
        createToServiceMsg.extraData.putString("strAppName", str);
        createToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
        createToServiceMsg.extraData.putLong("iGetDevListType", 5L);
        send(createToServiceMsg);
    }

    public void getCheckUpdate(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCheckUpdate checkFirstTime = " + z16 + ",checkUpdateType = " + i3);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_CHECK_UPDATE_REQ);
        createToServiceMsg.addAttribute("CheckUpdateType", Integer.valueOf(i3));
        createToServiceMsg.addAttribute("isFirstTime", Boolean.valueOf(z16));
        send(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Set) iPatchRedirector.redirect((short) 49, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("friendlist.getFriendGroupList");
            this.allowCmdSet.add("friendlist.GetLastLoginInfoReq");
            this.allowCmdSet.add(ProfileContants.CMD_GETSIGNATURE);
            this.allowCmdSet.add(ProfileContants.CMD_GETSIMPLEINFO);
            this.allowCmdSet.add("OidbSvc.0xc83");
            this.allowCmdSet.add("OidbSvc.0xc85");
            this.allowCmdSet.add(ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO);
            this.allowCmdSet.add(ProfileContants.CMD_REQ_RES_DEL_DEVLOGININFO);
            this.allowCmdSet.add(ProfileContants.CMD_REQ_KICKOUT_DEV);
            this.allowCmdSet.add(ProfileContants.CMD_REQ_BINDUIN_STATE);
            this.allowCmdSet.add("friendlist.MovGroupMemReq");
            this.allowCmdSet.add("BumpSvc.ReqComfirmContactFriend");
            this.allowCmdSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
            this.allowCmdSet.add("friendlist.GetOnlineInfoReq");
            this.allowCmdSet.add("friendlist.delFriend");
            this.allowCmdSet.add("friendlist.SetGroupReq");
            this.allowCmdSet.add(ProfileContants.CMD_SETCOMMENT);
            this.allowCmdSet.add(ProfileContants.CMD_SETSIGNATURE);
            this.allowCmdSet.add("StatSvc.register");
            this.allowCmdSet.add(ProfileContants.CMD_CHECK_UPDATE_REQ);
            this.allowCmdSet.add("SummaryCard.ReqSearch");
            this.allowCmdSet.add("SummaryCard.ReqCondSearch");
            this.allowCmdSet.add("OidbSvc.0x972_5");
            this.allowCmdSet.add("OidbSvc.0x5d1_0");
            this.allowCmdSet.add("OidbSvc.0x4fc_30");
            this.allowCmdSet.add("DevLockAuthSvc.RecommendAuth");
            this.allowCmdSet.add("DevLockAuthSvc.ConfirmAuth");
            this.allowCmdSet.add("OidbSvc.0x476_146");
            this.allowCmdSet.add("OidbSvc.0x490_107");
            this.allowCmdSet.add("OidbSvc.0x491_107");
            this.allowCmdSet.add("OidbSvc.0x49d_107");
            this.allowCmdSet.add("OidbSvc.0x7c4_0");
            this.allowCmdSet.add("OidbSvc.0x4f4_5");
            this.allowCmdSet.add("OidbSvc.0x7c6_0");
            this.allowCmdSet.add("OidbSvc.0x7c7_0");
            this.allowCmdSet.add("OidbSvc.0x847_3");
            this.allowCmdSet.add("OidbSvc.0x53b_0");
            this.allowCmdSet.add("OidbSvc.0x7df_3");
            this.allowCmdSet.add("OidbSvc.0x5d6_7");
            this.allowCmdSet.add("OidbSvc.0x5d6_19");
            this.allowCmdSet.add("OidbSvc.0x5d6_18");
            this.allowCmdSet.add("OidbSvc.0x77c");
            this.allowCmdSet.add("OidbSvc.0x777");
            this.allowCmdSet.add("OidbSvc.0xc26_0");
            this.allowCmdSet.add("OidbSvc.0xc36_0");
            this.allowCmdSet.add("OidbSvc.0xcf0_0");
            this.allowCmdSet.add("OidbSvc.0xd69");
            this.allowCmdSet.add("OidbSvc.0xd72");
            this.allowCmdSet.add("OidbSvc.0x5d6_21");
        }
        return this.allowCmdSet;
    }

    public void getDongtaiPermission(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this, (Object) str, i3);
            return;
        }
        cmd0x7c7$ReqBody cmd0x7c7_reqbody = new cmd0x7c7$ReqBody();
        cmd0x7c7_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
        if (i3 == 1) {
            cmd0x7c7_reqbody.uint32_req_not_see_qzone.set(1);
        } else if (i3 == 2) {
            cmd0x7c7_reqbody.uint32_req_prevent_dynamic.set(1);
        } else if (i3 == 3) {
            cmd0x7c7_reqbody.uint32_req_not_see_qzone.set(1);
            cmd0x7c7_reqbody.uint32_req_prevent_dynamic.set(1);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1991);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x7c7_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x7c7_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        if (i3 == 1) {
            createToServiceMsg.extraData.putInt("key_permission_opcode", 1);
        } else if (i3 == 2) {
            createToServiceMsg.extraData.putInt("key_permission_opcode", 2);
        } else if (i3 == 3) {
            createToServiceMsg.extraData.putInt("key_permission_opcode", 3);
        }
        createToServiceMsg.setTimeout(10000L);
        sendPbReq(createToServiceMsg);
    }

    public void getFriendDetailInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestFriendInfo(str);
        }
    }

    public void getFriendGroupList(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            getFriendGroupList(z16, false);
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        }
    }

    public void getFriendInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 33)) {
            getFriendInfo(str, false);
        } else {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
        }
    }

    public void getFriendInfoBatch(ArrayList<String> arrayList, boolean z16) {
        QQAppInterface qQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        if (arrayList != null && !arrayList.isEmpty() && (qQAppInterface = this.app) != null) {
            String currentAccountUin = qQAppInterface.getCurrentAccountUin();
            String str = "";
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str2 = arrayList.get(size);
                if (str2 != null && str2.length() != 0 && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(str2, TAG) && isNeedSendGetFriendInfo(str2)) {
                    if (str2.equals(currentAccountUin)) {
                        str = currentAccountUin;
                    }
                } else {
                    arrayList.remove(size);
                }
            }
            if (arrayList.isEmpty()) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getFriendInfoBatch uinList is empty");
                    return;
                }
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 4, String.format(Locale.getDefault(), "getFriendInfoBatch size: %d, friendUin: %s", Integer.valueOf(arrayList.size()), str));
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_GETSIMPLEINFO);
            createToServiceMsg.extraData.putStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putBoolean("reqSelfLevel", shouldReqLevel(str));
            createToServiceMsg.extraData.putBoolean("reqXMan", shouldReqXMan(str));
            createToServiceMsg.extraData.putBoolean("reqDateNick", z16);
            createToServiceMsg.extraData.putBoolean(ProfileContants.CMD_PARAM_BATCH_DATA, true);
            send(createToServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getFriendInfoBatch uinList is empty or app is null");
        }
    }

    public boolean getFriendNickByBatch(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) arrayList)).booleanValue();
        }
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFriendNickByBatch|uinsize = " + arrayList.size() + " time=" + System.currentTimeMillis());
        }
        short size = (short) arrayList.size();
        if (size > 500) {
            return false;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1181);
        oidb_sso_oidbssopkg.uint32_service_type.set(107);
        ByteBuffer allocate = ByteBuffer.allocate((size * 4) + 7);
        allocate.put((byte) 0).putShort((short) 1).putShort(this.shBatchSeqTypeField).putShort(size);
        for (short s16 = 0; s16 < size; s16 = (short) (s16 + 1)) {
            try {
                allocate.putInt(Utils.O(Long.parseLong(arrayList.get(s16))));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getFriendNickByBatch parseLong err uin=" + arrayList.get(s16), e16);
                }
            }
        }
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x49d_107");
        createToServiceMsg.extraData.putStringArrayList("batchuin", arrayList);
        createToServiceMsg.extraData.putShort("uincount", size);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
        return true;
    }

    public void getFriendsHasBindPhone(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this, i3);
            return;
        }
        cmd0xcf0$ReqBody cmd0xcf0_reqbody = new cmd0xcf0$ReqBody();
        cmd0xcf0_reqbody.uint32_expect_bind_contacts_frd_num.set(i3);
        sendPbReq(makeOIDBPkg("OidbSvc.0xcf0_0", 3312, 0, cmd0xcf0_reqbody.toByteArray()));
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getFriendsHasBindPhone :" + i3);
        }
    }

    public void getFriendsInfo(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) strArr);
            return;
        }
        if (strArr != null && strArr.length >= 1) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(str, TAG) && isNeedSendGetFriendInfo(str)) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() < 1) {
                return;
            }
            String[] strArr2 = new String[arrayList.size()];
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                strArr2[i3] = arrayList.get(i3);
            }
            getRichStatus(strArr2);
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_GETSIMPLEINFO);
            createToServiceMsg.extraData.putStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putBoolean(ProfileContants.CMD_PARAM_BATCH_DATA, true);
            send(createToServiceMsg);
        }
    }

    public void getGatheredContactsList(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this, i3);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x7c4_0");
        createToServiceMsg.extraData.putInt("startIndex", i3);
        cmd0x7c4$ReqBody cmd0x7c4_reqbody = new cmd0x7c4$ReqBody();
        String account = this.app.getAccount();
        cmd0x7c4$GetSNFrdListReq cmd0x7c4_getsnfrdlistreq = new cmd0x7c4$GetSNFrdListReq();
        cmd0x7c4_getsnfrdlistreq.uint64_uin.set(Long.parseLong(account));
        int i16 = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
        cmd0x7c4_getsnfrdlistreq.uint32_sequence.set(i16);
        cmd0x7c4_getsnfrdlistreq.uint32_start_idx.set(i3);
        cmd0x7c4_getsnfrdlistreq.uint32_req_num.set(MAX_COUNT_REQ_GETHER_MEMBER);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "FriendListHandler getGatheredContactsList(). startIndex = " + i3 + " | seq = " + i16);
        }
        cmd0x7c4_reqbody.msg_get_sn_frd_list_req.set(cmd0x7c4_getsnfrdlistreq);
        cmd0x7c4_reqbody.uint32_client_ver.set(2);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1988);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x7c4_reqbody.toByteArray()));
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public boolean getLastLoginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return ((Boolean) iPatchRedirector.redirect((short) 62, (Object) this)).booleanValue();
        }
        if (this.app.getCurrentAccountUin() == null) {
            return false;
        }
        boolean e16 = com.tencent.mobileqq.utils.z.e(this.app.getApp().getApplicationContext(), this.app.getAccount());
        if (e16) {
            getLastLoginInfo(0L, 0L, 0L);
        }
        return e16;
    }

    public void getLoginDevList(long j3, String str, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, Long.valueOf(j3), str, Long.valueOf(j16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO);
        createToServiceMsg.extraData.putLong("iLoginType", 1L);
        createToServiceMsg.extraData.putLong("iNextItemIndex", j16);
        createToServiceMsg.extraData.putLong("iRequireMax", 20L);
        createToServiceMsg.extraData.putLong("iTimeStamp", j3);
        createToServiceMsg.extraData.putString("strAppName", str);
        createToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
        createToServiceMsg.extraData.putLong("iGetDevListType", 1L);
        send(createToServiceMsg);
    }

    public boolean getMayKnowRecommend(List<Long> list, List<Long> list2, int i3, Bundle bundle) {
        int i16;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            return ((Boolean) iPatchRedirector.redirect((short) 90, this, list, list2, Integer.valueOf(i3), bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getMayKnowRecommend, filterUins=");
            if (list != null) {
                obj = list;
            } else {
                obj = "";
            }
            sb5.append(obj);
            sb5.append(", entryType=");
            sb5.append(i3);
            QLog.i(TAG, 2, sb5.toString());
        }
        try {
            oidb_0xc26$ReqBody oidb_0xc26_reqbody = new oidb_0xc26$ReqBody();
            String generateTraceId = BaseRequest.generateTraceId();
            oidb_0xc26_reqbody.trace_id.set(ByteStringMicro.copyFrom(generateTraceId.getBytes()));
            if (!TextUtils.isEmpty(generateTraceId)) {
                ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).saveTraceId(generateTraceId);
            }
            PBUInt32Field pBUInt32Field = oidb_0xc26_reqbody.enabled_contact;
            if (PermissionChecker.h().f()) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            pBUInt32Field.set(i16);
            if (list != null) {
                oidb_0xc26_reqbody.rpt_filter_uins.set(list);
            }
            switch (i3) {
                case 1:
                    i17 = 1;
                    break;
                case 2:
                    i17 = 2;
                    break;
                case 3:
                    i17 = 3;
                    break;
                case 4:
                    break;
                case 5:
                    i17 = 5;
                    break;
                case 6:
                    i17 = 6;
                    break;
                default:
                    QLog.e(TAG, 1, "getMayKnowRecommend, unknown entry type");
                    i17 = -1;
                    break;
            }
            oidb_0xc26_reqbody.em_entry.set(i17);
            oidb_0xc26_reqbody.uint32_fetch_rgroup.set(1);
            oidb_0xc26_reqbody.not_req_pymk.set(1);
            if (list2 != null) {
                oidb_0xc26_reqbody.rpt_expected_uins.set(list2);
            }
            oidb_0xc26_reqbody.uint32_tab_id.set(23);
            oidb_0xc26_reqbody.uint32_want.set(50);
            oidb_0xc26_reqbody.uin32_undecide.set(1);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xc26_0", 3110, 0, oidb_0xc26_reqbody.toByteArray());
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(PARAM_RECOMMEND_TRACE_ID, generateTraceId);
            makeOIDBPkg.extraData.putBundle("EXTRA:OidbSvc.0xc26_0", bundle);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16, new Object[0]);
            }
        }
        return true;
    }

    public void getMultiClientList(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, this, Long.valueOf(j3), str);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO);
        createToServiceMsg.extraData.putLong("iLoginType", 1L);
        createToServiceMsg.extraData.putLong("iNextItemIndex", 0L);
        createToServiceMsg.extraData.putLong("iRequireMax", 20L);
        createToServiceMsg.extraData.putLong("iTimeStamp", j3);
        createToServiceMsg.extraData.putString("strAppName", str);
        createToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
        send(createToServiceMsg);
    }

    public String getOfflineTipsConfig(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (String) iPatchRedirector.redirect((short) 60, (Object) this, j3);
        }
        if (!enableOfflineTipsConfig()) {
            return null;
        }
        if (this.mOfflineTips == null) {
            String serverConfigValue = this.app.getServerConfigValue(ServerConfigManager.ConfigType.app, "offlineTips");
            this.mOfflineTips = new HashMap<>();
            if (serverConfigValue != null && serverConfigValue.length() > 0) {
                try {
                    for (String str : serverConfigValue.split(";")) {
                        String[] split = str.split(":");
                        this.mOfflineTips.put(Long.valueOf(Long.parseLong(split[0])), split[1]);
                    }
                } catch (Exception unused) {
                }
            } else if (this.isSetOfflineDefaultValue) {
                this.mOfflineTips.put(Long.valueOf(j3), this.app.getApp().getString(R.string.hps));
            }
        }
        HashMap<Long, String> hashMap = this.mOfflineTips;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(Long.valueOf(j3));
    }

    public void getOnlineFriend(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, this, str, Byte.valueOf(b16));
            return;
        }
        if (b16 != 0 && isGetOnlineListRecently()) {
            return;
        }
        this.getOnlineFriendLastTimeStamp = System.currentTimeMillis();
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str, "friendlist.GetSimpleOnlineFriendInfoReq");
        toServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
        toServiceMsg.setTimeout(120000L);
        toServiceMsg.extraData.putByte("ifShowTermType", (byte) 1);
        toServiceMsg.extraData.putByte("srcType", b16);
        send(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
        }
    }

    public void getOnlineInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, this, str, Boolean.valueOf(z16));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", str, "friendlist.GetOnlineInfoReq");
        if (z16) {
            toServiceMsg.extraData.putLong("dwReqType", 1L);
            toServiceMsg.extraData.putString("strMobile", str);
        } else {
            try {
                long g16 = com.tencent.av.utils.i.g(str);
                toServiceMsg.extraData.putLong("dwReqType", 0L);
                toServiceMsg.extraData.putLong("dwUin", g16);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getOnlineInfo parse big integer failed uin: " + str, e16);
                return;
            }
        }
        toServiceMsg.setTimeout(15000L);
        send(toServiceMsg);
    }

    public void getRecentLoginAndOnlineDevList(long j3, String str, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, this, Long.valueOf(j3), str, Long.valueOf(j16));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_RES_GET_DEVLOGININFO);
        createToServiceMsg.extraData.putLong("iLoginType", 1L);
        createToServiceMsg.extraData.putLong("iNextItemIndex", j16);
        createToServiceMsg.extraData.putLong("iRequireMax", 20L);
        createToServiceMsg.extraData.putLong("iTimeStamp", j3);
        createToServiceMsg.extraData.putString("strAppName", str);
        createToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
        createToServiceMsg.extraData.putLong("iGetDevListType", 3L);
        send(createToServiceMsg);
    }

    public void getRecommandAuthDeviceList(long j3, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Long.valueOf(j3), str, Integer.valueOf(i3));
            return;
        }
        device_lock_recommend_auth$ReqBody device_lock_recommend_auth_reqbody = new device_lock_recommend_auth$ReqBody();
        device_lock_recommend_auth_reqbody.uint64_uin.set(j3);
        device_lock_recommend_auth_reqbody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        device_lock_recommend_auth_reqbody.uint32_appid.set(this.app.getAppid());
        device_lock_recommend_auth_reqbody.uint32_subappid.set(i3);
        device_lock_recommend_auth_reqbody.bytes_appname.set(ByteStringMicro.copyFrom(str.getBytes()));
        device_lock_recommend_auth_reqbody.uint32_seq.set(1);
        ToServiceMsg createToServiceMsg = createToServiceMsg("DevLockAuthSvc.RecommendAuth");
        createToServiceMsg.putWupBuffer(device_lock_recommend_auth_reqbody.toByteArray());
        createToServiceMsg.setTimeout(4000L);
        sendPbReq(createToServiceMsg);
    }

    public ArrayList<oidb_0x7df$FriendScore> getRecommendList() {
        ArrayList<oidb_0x7df$FriendScore> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return (ArrayList) iPatchRedirector.redirect((short) 95, (Object) this);
        }
        synchronized (this.mRecommendLock) {
            arrayList = this.mRecommendList;
        }
        return arrayList;
    }

    public void getRichStatus(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) strArr);
        } else {
            doGetRichStatus(strArr, 0, 0, null, false);
        }
    }

    public void getRichStatusForFriendList(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) strArr);
        } else {
            doGetRichStatus(strArr, 0, 3, null, false);
            this.isSyncingAllFriendsRichStatus = true;
        }
    }

    public void getSelfXManInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin) && shouldReqXMan(currentAccountUin)) {
            getFriendInfo(currentAccountUin);
        }
    }

    public void getSelfXManInfoScene2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        String currentAccountUin = this.app.getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin) && shouldReqXManScene2(currentAccountUin) && ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(currentAccountUin, TAG) && isNeedSendGetFriendInfo(currentAccountUin)) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(currentAccountUin);
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_GETSIMPLEINFO);
            createToServiceMsg.extraData.putStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putBoolean("reqSelfLevel", false);
            createToServiceMsg.extraData.putBoolean("reqXMan", true);
            createToServiceMsg.extraData.putBoolean("reqDateNick", false);
            createToServiceMsg.extraData.putInt("getXManInfoScene", 2);
            send(createToServiceMsg);
        }
    }

    public boolean getShowPcOnlineIconConfig() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        if (this.mShowPcIcon == -1) {
            try {
                if (com.tencent.mobileqq.utils.z.d(this.app.getApp().getApplicationContext(), this.app.getAccount())) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                this.mShowPcIcon = i3;
            } catch (Exception unused) {
                this.mShowPcIcon = 0;
            }
        }
        if (this.mShowPcIcon != 1) {
            return false;
        }
        return true;
    }

    public boolean getSpecialCareRecommend(int i3, int i16, ArrayList<String> arrayList, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            return ((Boolean) iPatchRedirector.redirect((short) 94, this, Integer.valueOf(i3), Integer.valueOf(i16), arrayList, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "FriendListHandler.getSpecialCareRecommend: start: " + i3 + ", count: " + i16 + ", uinList: " + arrayList + ", isSort: " + z16 + ", reqNick: " + z17);
        }
        if ((arrayList != null && arrayList.size() > 0) || (i3 >= 0 && i16 > 0)) {
            oidb_0x7df$ReqBody oidb_0x7df_reqbody = new oidb_0x7df$ReqBody();
            oidb_0x7df_reqbody.uint32_seq.set(0);
            oidb_0x7df_reqbody.uint32_start_index.set(i3);
            oidb_0x7df_reqbody.uint32_req_num.set(i16);
            oidb_0x7df_reqbody.uint32_sort.set(z16 ? 1 : 0);
            oidb_0x7df_reqbody.uint32_nick.set(z17 ? 1 : 0);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2015);
            oidb_sso_oidbssopkg.uint32_service_type.set(3);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x7df_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x7df_3");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
            getSpecialRecommendStat = 3;
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "FriendListHandler.getSpecialCareRecommend: input invalid.");
        }
        return false;
    }

    public void getStrangerInfo(String[] strArr, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) strArr, (Object) iArr);
            return;
        }
        int length = strArr.length;
        long[] jArr = new long[length];
        for (int i3 = 0; i3 < length; i3++) {
            try {
                jArr[i3] = Long.parseLong(strArr[i3]);
            } catch (NumberFormatException unused) {
                jArr[i3] = 0;
            }
        }
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        getStrangerInfo(jArr, iArr);
    }

    public void getStrangerRichStatus(String[] strArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, strArr, Boolean.valueOf(z16));
        } else {
            doGetRichStatus(strArr, 0, 2, null, z16);
        }
    }

    public void getSuspiciousFriendsUnreadNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getSuspiciousFriendsUnreadNum");
        }
        oidb_cmd0xd69$ReqBody oidb_cmd0xd69_reqbody = new oidb_cmd0xd69$ReqBody();
        oidb_cmd0xd69_reqbody.cmd_type.set(2);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, oidb_cmd0xd69_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("cmd", 2);
        sendPbReq(makeOIDBPkg);
    }

    public void getSuspiciousMsgList(int i3, byte[] bArr, Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, this, Integer.valueOf(i3), bArr, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getSuspiciousMsgList ");
            sb5.append(i3);
            sb5.append(" ");
            if (bArr == null) {
                str = " no cookie ";
            } else {
                str = " has cookie ";
            }
            sb5.append(str);
            sb5.append(obj);
            QLog.i(TAG, 2, sb5.toString());
        }
        oidb_cmd0xd69$ReqBody oidb_cmd0xd69_reqbody = new oidb_cmd0xd69$ReqBody();
        oidb_cmd0xd69_reqbody.cmd_type.set(1);
        oidb_cmd0xd69$GetListReqBody oidb_cmd0xd69_getlistreqbody = new oidb_cmd0xd69$GetListReqBody();
        oidb_cmd0xd69_getlistreqbody.req_num.set(i3);
        if (bArr != null) {
            oidb_cmd0xd69_getlistreqbody.bytes_cookies.set(ByteStringMicro.copyFrom(bArr));
        }
        oidb_cmd0xd69_reqbody.msg_get_list_body.set(oidb_cmd0xd69_getlistreqbody);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, oidb_cmd0xd69_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("cmd", 1);
        makeOIDBPkg.addAttribute("exactData", obj);
        sendPbReq(makeOIDBPkg);
    }

    public VasFaceManager getVaseFaceManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (VasFaceManager) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return ((com.tencent.mobileqq.vas.ao) this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308429f;
    }

    public void getVisibilityForNetWorkStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1168);
        oidb_sso_oidbssopkg.uint32_service_type.set(107);
        String currentAccountUin = this.app.getCurrentAccountUin();
        ByteBuffer allocate = ByteBuffer.allocate(4);
        if (!TextUtils.isEmpty(currentAccountUin)) {
            try {
                allocate.putInt((int) Long.parseLong(currentAccountUin));
            } catch (NumberFormatException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "getVisibilityForNetWorkStatus e: " + e16.toString());
                }
            }
        }
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x490_107");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void handleAddBatchQIMFriends(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.QIM", 2, "handleAddBatchQIMFriends");
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom(fromServiceMsg.getWupBuffer());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
            if (oidb_sso_oidbssopkg != null && oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
                cmd0xaed$RspBody cmd0xaed_rspbody = new cmd0xaed$RspBody();
                try {
                    cmd0xaed_rspbody.mergeFrom(byteArray);
                    List<Long> list = cmd0xaed_rspbody.rpt_uint64_succ_qim_uins.get();
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder("handleAddBatchQIMFriends success ");
                        for (Long l3 : list) {
                            sb5.append(", ");
                            sb5.append(l3);
                        }
                        QLog.d("FriendListHandler.QIM", 2, sb5.toString());
                    }
                    notifyUI(106, false, list);
                    return;
                } catch (InvalidProtocolBufferMicroException e17) {
                    e17.printStackTrace();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler.QIM", 2, "handleAddBatchQIMFriends false ");
        }
        notifyUI(106, false, null);
    }

    public void handleCheckUpdate(CheckUpdateResp checkUpdateResp) {
        byte b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) checkUpdateResp);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("FriendListHandler, handleCheckUpdate, ");
        if (checkUpdateResp != null) {
            b16 = checkUpdateResp.result;
        } else {
            b16 = -1;
        }
        sb5.append((int) b16);
        QLog.i(ProfileContants.CMD_CHECK_UPDATE_REQ, 1, sb5.toString());
        if (checkUpdateResp != null && checkUpdateResp.result == 0) {
            Iterator<RespItem> it = checkUpdateResp.vecResPkg.iterator();
            com.tencent.mobileqq.service.profile.a aVar = null;
            RespItem respItem = null;
            while (it.hasNext()) {
                RespItem next = it.next();
                if (next != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(ProfileContants.CMD_CHECK_UPDATE_REQ, 2, "FriendListHandler::handleCheckUpdate item eServiceId = " + next.eServiceID + ",result=" + ((int) next.cResult));
                    }
                    com.tencent.mobileqq.service.profile.a D2 = this.app.mAutomator.D2(next.eServiceID);
                    if (next.eServiceID == 101) {
                        respItem = next;
                        aVar = D2;
                    } else {
                        handleCheckUpdateItem(D2, next);
                    }
                }
            }
            handleCheckUpdateItem(aVar, respItem);
        }
        this.app.mAutomator.J2();
    }

    public void handleDelGroupResp(DelGroupResp delGroupResp, boolean z16, GroupActionResp groupActionResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, delGroupResp, Boolean.valueOf(z16), groupActionResp);
            return;
        }
        if (z16) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).moveGroup(delGroupResp.cGroupid, 0, TAG, new hx3.b<Boolean>() { // from class: com.tencent.mobileqq.app.FriendListHandler.10
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendListHandler.this);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(FriendListHandler.TAG, 2, "handleDelGroupResp responseData.getCode :" + eVar.a());
                    }
                }
            });
        }
        notifyUI(21, z16, groupActionResp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0142, code lost:
    
        if (r10 != null) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleFriendInfo(ToServiceMsg toServiceMsg, ArrayList<String> arrayList, FromServiceMsg fromServiceMsg, ArrayList<ProfSmpInfoRes> arrayList2) {
        List<String> list;
        Iterator<ProfSmpInfoRes> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, toServiceMsg, arrayList, fromServiceMsg, arrayList2);
            return;
        }
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        EntityTransaction G = friendsManager.G();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        try {
            try {
                G.begin();
                List<String> loginUinList = getLoginUinList();
                Iterator<ProfSmpInfoRes> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    ProfSmpInfoRes next = it5.next();
                    String valueOf = String.valueOf(next.dwUin);
                    if (arrayList.contains(valueOf)) {
                        boolean equals = valueOf.equals(this.app.getCurrentAccountUin());
                        if (loginUinList != null && loginUinList.contains(valueOf)) {
                            z16 = z17;
                        }
                        com.tencent.mobileqq.app.friendlist.a.d(next, equals, z16, this.app, valueOf);
                        if (next.cSpecialFlag < 0) {
                            QLog.i(TAG, 1, "Info.cSpecialFlag is 0xFF");
                            next.cSpecialFlag = (byte) 0;
                        }
                        if (CrmUtils.s(next.cSpecialFlag) || QidianManager.O(next.cSpecialFlag)) {
                            arrayList3.add(valueOf);
                            com.tencent.mobileqq.app.friendlist.a.k(CrmUtils.s(next.cSpecialFlag), this.app);
                        }
                        saveToFriendDetailInfo(next);
                        Card q16 = friendsManager.q(valueOf);
                        com.tencent.mobileqq.app.friendlist.a.b(this.app, next, q16, valueOf, arrayList);
                        if (QLog.isColorLevel()) {
                            StringBuffer stringBuffer = new StringBuffer(200);
                            stringBuffer.append("Info.isShowXMan=");
                            stringBuffer.append(next.isShowXMan);
                            stringBuffer.append(";Info.dwLoginDay=");
                            list = loginUinList;
                            it = it5;
                            stringBuffer.append(next.dwLoginDay);
                            stringBuffer.append(";Info.dwPhoneQQXManDay=");
                            stringBuffer.append(next.dwPhoneQQXManDay);
                            stringBuffer.append(";card.allowClick=");
                            stringBuffer.append(q16.allowClick);
                            stringBuffer.append(";card.allowPeopleSee= ");
                            stringBuffer.append(q16.allowPeopleSee);
                            QLog.d(TAG, 2, stringBuffer.toString());
                        } else {
                            list = loginUinList;
                            it = it5;
                        }
                        friendsManager.p0(q16);
                        com.tencent.mobileqq.app.friendlist.a.c(this, toServiceMsg, next, arrayList4, valueOf);
                        com.tencent.mobileqq.app.friendlist.a.e(this.app, toServiceMsg, next);
                        com.tencent.mobileqq.app.friendlist.a.f(this.app, toServiceMsg, next);
                        notifyUI(3, true, valueOf);
                        loginUinList = list;
                        it5 = it;
                        z16 = false;
                        z17 = true;
                    }
                }
                G.commit();
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleFriendInfo err", e16);
                }
            }
            G.end();
            com.tencent.mobileqq.app.friendlist.a.a(this.app, arrayList3);
            com.tencent.mobileqq.app.friendlist.a.l(this.app, arrayList4);
            if (toServiceMsg.extraData.getBoolean(ProfileContants.CMD_PARAM_BATCH_DATA)) {
                notifyUI(63, true, arrayList2);
            }
        } catch (Throwable th5) {
            if (G != null) {
                G.end();
            }
            throw th5;
        }
    }

    public <T> void handleMayKnowRecommendPush(int i3, List<T> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, i3, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleMayKnowRecommendPush: " + list + ", opType: " + i3);
        }
        if (i3 != 0) {
            if (i3 != 2) {
                return;
            }
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.app.FriendListHandler.13
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendListHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i(FriendListHandler.TAG, 2, "decodePush0x210_0x111,do getMayKnowRecommend");
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("from", "push");
                    ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).removePYMKData();
                    ((IPYMKSwitchAGuideApi) QRoute.api(IPYMKSwitchAGuideApi.class)).reqGetPYMKSetting();
                    FriendListHandler.this.getMayKnowRecommend(null, null, 6, bundle);
                    ((IQQRecommendFriendApi) QRoute.api(IQQRecommendFriendApi.class)).fetchRecommendDataRemoteForceAll();
                }
            });
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "decodePush0x210_0x111, do del mayknow list");
        }
        try {
            notifyUI(109, false, list);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.app.FriendListHandler.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendListHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        com.tencent.mobileqq.friend.status.a.c();
                        FriendListHandler.this.getShowPcOnlineIconConfig();
                    }
                }
            }, 16, null, false);
        }
    }

    public boolean isGetOnlineListRecently() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Boolean) iPatchRedirector.redirect((short) 55, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.getOnlineFriendLastTimeStamp;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getOnlineFriend  | intervalTime = " + currentTimeMillis + " | sGetOnlineFriendDelay = " + QQAppInterface.sGetOnlineFriendDelay);
        }
        if (this.getOnlineFriendLastTimeStamp > 0 && (currentTimeMillis < QQAppInterface.sGetOnlineFriendDelay || currentTimeMillis > QQAppInterface.sNextGetOnlineFriendDelay - QQAppInterface.sGetOnlineFriendDelay)) {
            return true;
        }
        return false;
    }

    public boolean isNeedSendGetFriendInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, (Object) str)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.friendInfoDuplicateTable) {
            if (this.friendInfoDuplicateTable.containsKey(str)) {
                FriendInfoDuplicate friendInfoDuplicate = this.friendInfoDuplicateTable.get(str);
                long abs = Math.abs(currentTimeMillis - friendInfoDuplicate.startTime);
                long j3 = friendInfoDuplicate.expiredTime;
                if (j3 > 0) {
                    if (currentTimeMillis < j3) {
                        return false;
                    }
                    friendInfoDuplicate.expiredTime = 0L;
                    friendInfoDuplicate.startTime = currentTimeMillis;
                    friendInfoDuplicate.count = 1L;
                    return true;
                }
                if (abs < 5000) {
                    return false;
                }
                long j16 = friendInfoDuplicate.count + 1;
                friendInfoDuplicate.count = j16;
                if (j16 >= 8 && abs < 120000) {
                    friendInfoDuplicate.expiredTime = currentTimeMillis + 1800000;
                } else if (abs > 60000) {
                    friendInfoDuplicate.expiredTime = 0L;
                    friendInfoDuplicate.startTime = currentTimeMillis;
                    friendInfoDuplicate.count = 1L;
                }
            } else {
                if (this.friendInfoDuplicateTable.size() > 20) {
                    ArrayList arrayList = new ArrayList();
                    Enumeration<String> keys = this.friendInfoDuplicateTable.keys();
                    while (keys.hasMoreElements()) {
                        String nextElement = keys.nextElement();
                        FriendInfoDuplicate friendInfoDuplicate2 = this.friendInfoDuplicateTable.get(nextElement);
                        long j17 = friendInfoDuplicate2.expiredTime;
                        if (j17 == 0) {
                            if (currentTimeMillis - friendInfoDuplicate2.startTime <= 60000) {
                            }
                            arrayList.add(nextElement);
                        }
                        if (j17 > 0) {
                            if (currentTimeMillis <= j17) {
                            }
                            arrayList.add(nextElement);
                        }
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        this.friendInfoDuplicateTable.remove((String) arrayList.get(i3));
                    }
                }
                FriendInfoDuplicate friendInfoDuplicate3 = new FriendInfoDuplicate();
                friendInfoDuplicate3.startTime = currentTimeMillis;
                friendInfoDuplicate3.count = 1L;
                this.friendInfoDuplicateTable.put(str, friendInfoDuplicate3);
            }
            return true;
        }
    }

    public boolean isStatusEntryVisible() {
        String serverConfigValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return ((Boolean) iPatchRedirector.redirect((short) 61, (Object) this)).booleanValue();
        }
        if (this.mStatusEntry == -1 && (serverConfigValue = this.app.getServerConfigValue(ServerConfigManager.ConfigType.app, KEY_STATUS_ENTRY)) != null && serverConfigValue.length() > 0) {
            try {
                this.mStatusEntry = Integer.parseInt(serverConfigValue);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.richstatus.mate", 2, "isStatusEntryVisible " + this.mStatusEntry + ", " + e16.toString());
                }
            }
        }
        if (this.mStatusEntry == 1) {
            return true;
        }
        return false;
    }

    public boolean isSyncingAllFriendsRichStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return this.isSyncingAllFriendsRichStatus;
    }

    public void kickOutDev(long j3, byte b16, byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, Long.valueOf(j3), Byte.valueOf(b16), bArr, Integer.valueOf(i3));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_KICKOUT_DEV);
        createToServiceMsg.extraData.putLong("appid", j3);
        createToServiceMsg.extraData.putByte("cKeyType", b16);
        createToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.app.getAccount()));
        createToServiceMsg.extraData.putByteArray(IPublicAccountDetailReportUtil.KEY_SEARCH, bArr);
        createToServiceMsg.extraData.putInt("index", i3);
        createToServiceMsg.setIsSupportRetry(true);
        send(createToServiceMsg);
    }

    public void moveFriendToGroup(String str, byte b16, byte b17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, this, str, Byte.valueOf(b16), Byte.valueOf(b17));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.MovGroupMemReq");
        toServiceMsg.extraData.putByte("move_fri_type", (byte) 0);
        toServiceMsg.extraData.putString("uin", str);
        toServiceMsg.extraData.putByte("group_id", b16);
        toServiceMsg.extraData.putByte("away_group_id", b17);
        toServiceMsg.setTimeout(30000L);
        send(toServiceMsg);
    }

    public void moveFriendsToGroup(String[] strArr, byte b16, byte b17) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, this, strArr, Byte.valueOf(b16), Byte.valueOf(b17));
            return;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.MovGroupMemReq");
        toServiceMsg.extraData.putByte("move_fri_type", (byte) 1);
        toServiceMsg.extraData.putByte("group_id", b16);
        toServiceMsg.extraData.putByte("away_group_id", b17);
        for (int i16 = 0; i16 < strArr.length; i16 += 15) {
            if (strArr.length - i16 < 15) {
                i3 = strArr.length - i16;
            } else {
                i3 = 15;
            }
            String[] strArr2 = new String[i3];
            for (int i17 = 0; i17 < 15; i17++) {
                int i18 = i16 + i17;
                if (i18 >= strArr.length) {
                    break;
                }
                strArr2[i17] = strArr[i18];
            }
            toServiceMsg.extraData.putStringArray("uins", strArr2);
            send(toServiceMsg);
        }
    }

    public void notifySyncSignature() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        String[] strArr = this.updateSignatureList;
        if (strArr != null) {
            getRichStatusForFriendList(strArr);
            this.updateSignatureList = null;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            return (Class) iPatchRedirector.redirect((short) 79, (Object) this);
        }
        return com.tencent.mobileqq.friend.observer.b.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this);
        } else {
            super.onDestroy();
        }
    }

    public void onGetSpecialCareRecommend(List<oidb_0x7df$FriendScore> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            iPatchRedirector.redirect((short) 96, (Object) this, (Object) list);
            return;
        }
        synchronized (this.mRecommendLock) {
            this.mRecommendList.clear();
            this.mRecommendList.addAll(list);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<ProfSmpInfoRes> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "cmdfilter error=" + fromServiceMsg.getServiceCmd());
                return;
            }
            return;
        }
        for (com.tencent.mobileqq.app.friendlist.receiver.a aVar : this.handlerReceivers) {
            if (aVar.a(fromServiceMsg.getServiceCmd())) {
                aVar.d(toServiceMsg, fromServiceMsg, obj);
                return;
            }
        }
        if (fromServiceMsg.getServiceCmd().equals(ProfileContants.CMD_GETSIGNATURE)) {
            if (!fromServiceMsg.isSuccess()) {
                return;
            }
            int i3 = toServiceMsg.extraData.getInt("reqType", 0);
            if (i3 != 0 && i3 != 3) {
                handleStrangerRichStatus(toServiceMsg, obj);
                return;
            } else {
                handleFriendRichStatus(toServiceMsg, obj);
                return;
            }
        }
        if (ProfileContants.CMD_GETSIMPLEINFO.equals(fromServiceMsg.getServiceCmd())) {
            ArrayList<String> stringArrayList = toServiceMsg.extraData.getStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
            if (fromServiceMsg.isSuccess() && (arrayList = (ArrayList) obj) != null && stringArrayList != null) {
                handleFriendInfo(toServiceMsg, stringArrayList, fromServiceMsg, arrayList);
                return;
            }
            return;
        }
        if ("OidbSvc.0x4fc_30".equals(fromServiceMsg.getServiceCmd())) {
            handleGetStrangerInfo(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x7c4_0".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleGetGatheredContactsList(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x4f4_5".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            handleGatherContactsResp(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x5d6_7".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            if (toServiceMsg.extraData.getBoolean(PARAM_IS_SET_SWITCHES_OF_A_PERSON)) {
                handleSetSpecialCareSwitchesOfAPersonResp(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                handleSetSpecialCareSwitchResp(toServiceMsg, fromServiceMsg, obj);
                return;
            }
        }
        if ("OidbSvc.0x777".equals(fromServiceMsg.getServiceCmd())) {
            handleAddBatchTroopMembers(toServiceMsg, fromServiceMsg, obj);
        }
    }

    public void queryUinSafetyFlag(String str, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, str, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "send_oidb_0x476 " + j3 + i3);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(com.tencent.luggage.wxa.yh.c.CTRL_INDEX);
        oidb_sso_oidbssopkg.uint32_service_type.set(i3);
        ByteBuffer allocate = ByteBuffer.allocate(6);
        allocate.putShort((short) 1);
        allocate.putInt((int) j3);
        oidb_sso_oidbssopkg.bytes_bodybuffer.setHasFlag(true);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), str);
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        toServiceMsg.extraData.putLong("uin", j3);
        sendPbReq(toServiceMsg);
    }

    protected void registerHandlerReceivers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.handlerReceivers.add(new FriendGroupReceiver(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.f(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.e(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.g(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.m(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.h(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.b(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.c(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.o(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.p(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.n(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.d(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.i(this.app, this));
        this.handlerReceivers.add(new com.tencent.mobileqq.app.friendlist.receiver.q(this.app, this));
    }

    public void renameFriendGroup(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, this, Byte.valueOf(b16), str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "RenameFriendGroup :" + ((int) b16));
        }
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).renameFriendGroup(b16, str);
    }

    public void reportMayknowRecommendExplosure(ConcurrentHashMap<String, MayKnowExposure> concurrentHashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this, (Object) concurrentHashMap);
            return;
        }
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reportMayknowRecommendExplosure, needReportCnt=" + concurrentHashMap.size());
            }
            try {
                long parseLong = Long.parseLong(this.app.getCurrentAccountUin());
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, MayKnowExposure>> it = concurrentHashMap.entrySet().iterator();
                int i3 = 0;
                while (it.hasNext() && i3 < 99) {
                    MayKnowExposure value = it.next().getValue();
                    oidb_0xc35$ExposeItem oidb_0xc35_exposeitem = new oidb_0xc35$ExposeItem();
                    oidb_0xc35_exposeitem.uint64_friend.set(Long.parseLong(value.uin));
                    oidb_0xc35_exposeitem.uint32_action_id.set(value.actionId);
                    oidb_0xc35_exposeitem.uint32_entrance_Id.set(value.entranceId);
                    oidb_0xc35_exposeitem.uint32_expose_count.set(value.exposeCnt);
                    oidb_0xc35_exposeitem.uint32_expose_time.set(value.exposeTime);
                    oidb_0xc35_exposeitem.uint32_page_id.set(value.pageId);
                    byte[] bArr = value.acBuffer;
                    if (bArr != null) {
                        oidb_0xc35_exposeitem.bytes_algo_buffer.set(ByteStringMicro.copyFrom(bArr));
                    }
                    byte[] bArr2 = value.additive;
                    if (bArr2 != null) {
                        oidb_0xc35_exposeitem.bytes_addition.set(ByteStringMicro.copyFrom(bArr2));
                    }
                    arrayList.add(oidb_0xc35_exposeitem);
                    i3++;
                }
                oidb_0xc35$ReqBody oidb_0xc35_reqbody = new oidb_0xc35$ReqBody();
                oidb_0xc35_reqbody.uint64_uin.set(parseLong);
                oidb_0xc35_reqbody.rpt_msg_expose_info.set(arrayList);
                sendPbReq(makeOIDBPkg("OidbSvc.0xc35_0", 3125, 0, oidb_0xc35_reqbody.toByteArray()));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reportMayknowRecommendExplosure, realReportCnt=" + i3);
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reportMayknowRecommendExplosure", e16);
                }
            }
        }
    }

    public void reqLastChatTime(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("IceBreak.FriendListHandler", 2, String.format("reqLastChatTime frdUin=%s daysForward=%d", str, Integer.valueOf(i3)));
        }
        try {
            long parseLong = Long.parseLong(this.app.getCurrentAccountUin());
            cmd0xc85$ReqBody cmd0xc85_reqbody = new cmd0xc85$ReqBody();
            cmd0xc85_reqbody.uint64_from_uin.set(parseLong);
            cmd0xc85_reqbody.uint64_to_uin.set(Long.valueOf(str).longValue());
            cmd0xc85_reqbody.uint32_op.set(2);
            cmd0xc85_reqbody.uint32_interval_days.set(i3);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xc85", 3205, 0, cmd0xc85_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("selfUin", this.app.getCurrentAccountUin());
            makeOIDBPkg.extraData.putString("frdUin", str);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reqRecheckInHotReactive exception", e16);
            }
        }
    }

    public void reqRecheckInHotReactive(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FriendReactive.FriendListHandler", 2, "reqRecheckInHotReactive frdUin=" + str);
        }
        try {
            long parseLong = Long.parseLong(this.app.getCurrentAccountUin());
            cmd0xc83$ReqBody cmd0xc83_reqbody = new cmd0xc83$ReqBody();
            cmd0xc83_reqbody.uint64_from_uin.set(parseLong);
            cmd0xc83_reqbody.uint64_to_uin.set(Long.valueOf(str).longValue());
            cmd0xc83_reqbody.uint32_op.set(2);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xc83", 3203, 0, cmd0xc83_reqbody.toByteArray());
            makeOIDBPkg.extraData.putString("selfUin", this.app.getCurrentAccountUin());
            makeOIDBPkg.extraData.putString("frdUin", str);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reqRecheckInHotReactive exception", e16);
            }
        }
    }

    public void resortFriendGroup(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, (Object) bArr, (Object) bArr2);
        } else {
            ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).resortFriendGroup(bArr, bArr2);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public void saveShowPcIconIfNeccessary(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        ?? r16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, Byte.valueOf(b16));
            return;
        }
        if (b16 == 0 || b16 == 1) {
            if (b16 == 1) {
                r16 = 1;
            }
            if (r16 != getShowPcOnlineIconConfig()) {
                this.mShowPcIcon = r16;
                com.tencent.mobileqq.utils.z.j(this.app.getApp().getApplicationContext(), this.app.getAccount(), r16);
            }
        }
    }

    public void searchFriend(String str, String str2, int i3, int i16, int[] iArr, double d16, double d17, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Double.valueOf(d16), Double.valueOf(d17), Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("SummaryCard.ReqSearch");
        createToServiceMsg.extraData.putString("param_keyword", str);
        createToServiceMsg.extraData.putString("param_country_code", str2);
        createToServiceMsg.extraData.putInt("search_page", i16);
        createToServiceMsg.extraData.putIntArray("search_list", iArr);
        createToServiceMsg.extraData.putInt("search_version", i3);
        createToServiceMsg.extraData.putDouble("search_longtitude", d16);
        createToServiceMsg.extraData.putDouble("search_latitude", d17);
        createToServiceMsg.extraData.putBoolean("search_decode", z16);
        createToServiceMsg.extraData.putLong(ServiceConst.PARA_SESSION_ID, j3);
        send(createToServiceMsg);
    }

    public void searchFriendCondtional(long j3, int i3, long j16, String str, int i16, int i17, int i18, String[] strArr, String[] strArr2, int i19, int i26, int i27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), strArr, strArr2, Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("SummaryCard.ReqCondSearch");
        createToServiceMsg.extraData.putLong("search_seq", j3);
        createToServiceMsg.extraData.putInt("param_page", i3);
        createToServiceMsg.extraData.putLong("param_session_id", j16);
        createToServiceMsg.extraData.putString("param_keyword", str);
        createToServiceMsg.extraData.putInt("param_sex_index", i16);
        createToServiceMsg.extraData.putInt("param_age_index1", i17);
        createToServiceMsg.extraData.putInt("param_age_index2", i18);
        createToServiceMsg.extraData.putStringArray("param_loc_code", strArr);
        createToServiceMsg.extraData.putStringArray("param_home_code", strArr2);
        createToServiceMsg.extraData.putInt("param_job_index", i19);
        createToServiceMsg.extraData.putInt("param_xingzuo_index", i26);
        createToServiceMsg.extraData.putInt("param_search_from", i27);
        send(createToServiceMsg);
    }

    public void sendReadReportSuspicious() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            iPatchRedirector.redirect((short) 109, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "sendReadReportSuspicious ");
        }
        oidb_cmd0xd69$ReqBody oidb_cmd0xd69_reqbody = new oidb_cmd0xd69$ReqBody();
        oidb_cmd0xd69_reqbody.cmd_type.set(5);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, oidb_cmd0xd69_reqbody.toByteArray());
        makeOIDBPkg.addAttribute("cmd", 5);
        sendPbReq(makeOIDBPkg);
    }

    public void send_oidb_0x5d1_0(long j3, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, Long.valueOf(j3), Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (!z16) {
            i16 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + j3 + " setId:" + i3 + " isSet:" + z16);
        }
        Oidb_0x5d1$ReqBody oidb_0x5d1$ReqBody = new Oidb_0x5d1$ReqBody();
        oidb_0x5d1$ReqBody.uint32_cmd.set(i16);
        oidb_0x5d1$ReqBody.uint32_id.set(i3);
        long j16 = this.app.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.CONTACTS, 2, "FriendListHandler.send_oidb_0x5d1_0 " + j16);
        }
        if (z16) {
            Oidb_0x5d1$SetFriendIdReq oidb_0x5d1$SetFriendIdReq = new Oidb_0x5d1$SetFriendIdReq();
            oidb_0x5d1$SetFriendIdReq.uint32_if_check_seq.set(0);
            oidb_0x5d1$SetFriendIdReq.uint64_seq.set(j16);
            oidb_0x5d1$SetFriendIdReq.rpt_uint64_friends.add(Long.valueOf(j3));
            oidb_0x5d1$ReqBody.msg_set_friend_id.set(oidb_0x5d1$SetFriendIdReq);
        } else {
            Oidb_0x5d1$ClearFriendIdReq oidb_0x5d1$ClearFriendIdReq = new Oidb_0x5d1$ClearFriendIdReq();
            oidb_0x5d1$ClearFriendIdReq.uint32_if_check_seq.set(0);
            oidb_0x5d1$ClearFriendIdReq.uint64_seq.set(j16);
            oidb_0x5d1$ClearFriendIdReq.rpt_uint64_friends.add(Long.valueOf(j3));
            oidb_0x5d1$ReqBody.msg_clear_friend_id.set(oidb_0x5d1$ClearFriendIdReq);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1489);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d1$ReqBody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x5d1_0");
        createToServiceMsg.extraData.putLong("friendUin", j3);
        createToServiceMsg.extraData.putBoolean("isSet", z16);
        createToServiceMsg.extraData.putInt("setId", i3);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(30000L);
        sendPbReq(createToServiceMsg);
    }

    public void setBindUinStatus(byte b16, ArrayList<BindUin> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, this, Byte.valueOf(b16), arrayList);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_REQ_BINDUIN_STATE);
        createToServiceMsg.extraData.putByte("cCmd", b16);
        createToServiceMsg.addAttribute("vecBindUin", arrayList);
        send(createToServiceMsg);
    }

    public void setDongtaiPermission(boolean z16, String str, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
            return;
        }
        cmd0x7c6$ReqBody cmd0x7c6_reqbody = new cmd0x7c6$ReqBody();
        cmd0x7c6_reqbody.uint64_uin.set(Long.valueOf(str).longValue());
        if (i3 == 1) {
            cmd0x7c6_reqbody.uint32_not_see_qzone.set(z16 ? 1 : 0);
        } else if (i3 == 2) {
            cmd0x7c6_reqbody.uint32_prevent_dynamic.set(z16 ? 1 : 0);
        } else if (i3 == 3) {
            cmd0x7c6_reqbody.uint32_not_see_qzone.set(z16 ? 1 : 0);
            cmd0x7c6_reqbody.uint32_prevent_dynamic.set(z16 ? 1 : 0);
        } else if (i3 == 4) {
            PBUInt32Field pBUInt32Field = cmd0x7c6_reqbody.uint32_recv_msg_box;
            if (z16) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            pBUInt32Field.set(i16);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(SubAccountBindActivity.SUBACCOUNTBINDACTIVITY_CLOSE_DIALOG);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x7c6_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x7c6_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        if (i3 == 1) {
            createToServiceMsg.extraData.putInt("key_permission_opcode", 1);
        } else if (i3 == 2) {
            createToServiceMsg.extraData.putInt("key_permission_opcode", 2);
        } else if (i3 == 3) {
            createToServiceMsg.extraData.putInt("key_permission_opcode", 3);
        } else if (i3 == 4) {
            createToServiceMsg.extraData.putInt("key_permission_opcode", 4);
        }
        createToServiceMsg.extraData.putBoolean("key_dongtai_permission", z16);
        createToServiceMsg.setTimeout(10000L);
        sendPbReq(createToServiceMsg);
    }

    public void setFriendComment(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 75)) {
            setFriendComment(str, str2, z16, false);
        } else {
            iPatchRedirector.redirect((short) 75, this, str, str2, Boolean.valueOf(z16));
        }
    }

    public void setHiddenChat(String[] strArr, boolean[] zArr, int[] iArr) {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, strArr, zArr, iArr);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("FriendListHandler.setHiddenChat(). uin size=");
            int i3 = -1;
            if (strArr == null) {
                length = -1;
            } else {
                length = strArr.length;
            }
            sb5.append(length);
            sb5.append(", switch size=");
            if (zArr != null) {
                i3 = zArr.length;
            }
            sb5.append(i3);
            QLog.d(LogTag.TAG_HIDDEN_CHAT, 2, sb5.toString());
        }
        if (strArr != null && zArr != null && strArr.length != 0 && strArr.length == zArr.length) {
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < strArr.length; i16++) {
                String str = strArr[i16];
                boolean z16 = zArr[i16];
                oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem = new oidb_0x5d6$SnsUpdateItem();
                ArrayList arrayList2 = new ArrayList();
                if (z16) {
                    oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(ProfileContants.FIELD_HIDDEN_CHAT_SWITCH);
                    oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                    arrayList2.add(oidb_0x5d6_snsupdateitem);
                } else {
                    oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(ProfileContants.FIELD_HIDDEN_CHAT_SWITCH);
                    arrayList2.add(oidb_0x5d6_snsupdateitem);
                }
                oidb_0x5d6$SnsUpateBuffer oidb_0x5d6_snsupatebuffer = new oidb_0x5d6$SnsUpateBuffer();
                oidb_0x5d6_snsupatebuffer.uint64_uin.set(Long.parseLong(str));
                oidb_0x5d6_snsupatebuffer.rpt_msg_sns_update_item.set(arrayList2);
                arrayList.add(oidb_0x5d6_snsupatebuffer);
            }
            oidb_0x5d6$ReqBody oidb_0x5d6_reqbody = new oidb_0x5d6$ReqBody();
            oidb_0x5d6_reqbody.uint32_domain.set(1);
            oidb_0x5d6_reqbody.uint32_seq.set(0);
            oidb_0x5d6_reqbody.rpt_msg_update_buffer.set(arrayList);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1494);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(21);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d6_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x5d6_21");
            createToServiceMsg.extraData.putStringArray(PARAM_UINS, strArr);
            createToServiceMsg.extraData.putBooleanArray(PARAM_SWITCH_STATE, zArr);
            createToServiceMsg.extraData.putIntArray(PARAM_CHAT_TYPES, iArr);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
        }
    }

    public void setMessageNotificationSetting(int i3, String[] strArr, boolean[] zArr, com.tencent.qqnt.ntrelation.otherinfo.bean.a[] aVarArr) {
        char c16;
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = 4;
        char c18 = 5;
        int i16 = 3;
        int i17 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), strArr, zArr, aVarArr);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("FriendListHandler.setMessageNotificationSetting(). uin size=");
            int i18 = -1;
            if (strArr == null) {
                length = -1;
            } else {
                length = strArr.length;
            }
            sb5.append(length);
            sb5.append(", switch size=");
            if (zArr != null) {
                i18 = zArr.length;
            }
            sb5.append(i18);
            QLog.d(LogTag.TAG_MSG_NOTIFICATION, 2, sb5.toString());
        }
        if (strArr != null && zArr != null && strArr.length != 0 && strArr.length == zArr.length && strArr.length == aVarArr.length) {
            ArrayList arrayList = new ArrayList();
            int i19 = 0;
            boolean z16 = false;
            while (i19 < strArr.length) {
                String str = strArr[i19];
                com.tencent.qqnt.ntrelation.otherinfo.bean.a aVar = aVarArr[i19];
                if (aVar == null) {
                    c16 = c18;
                } else {
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[7];
                        objArr[0] = "setMessageNotificationSetting: invoked. ";
                        objArr[1] = " type: ";
                        objArr[i17] = Integer.valueOf(i3);
                        objArr[i16] = " uin: ";
                        objArr[c17] = str;
                        c16 = 5;
                        objArr[5] = " isSwitchOn: ";
                        objArr[6] = Boolean.valueOf(z16);
                        QLog.d(TAG, i17, objArr);
                    } else {
                        c16 = c18;
                    }
                    z16 = zArr[i19];
                    oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem = new oidb_0x5d6$SnsUpdateItem();
                    ArrayList arrayList2 = new ArrayList();
                    int G = aVar.G();
                    int N = aVar.N();
                    int M = aVar.M();
                    if (i3 == 1) {
                        G = !z16 ? 1 : 0;
                    } else if (i3 == i16) {
                        N = !z16 ? 1 : 0;
                    } else if (i3 == i17) {
                        M = !z16 ? 1 : 0;
                    }
                    byte[] Y = MessageNotificationSettingManager.Y(G, N, M);
                    oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(ReportPlugin.REPORT_EVENT_JS_EXCEPTION);
                    oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom(Y));
                    arrayList2.add(oidb_0x5d6_snsupdateitem);
                    oidb_0x5d6$SnsUpateBuffer oidb_0x5d6_snsupatebuffer = new oidb_0x5d6$SnsUpateBuffer();
                    oidb_0x5d6_snsupatebuffer.uint64_uin.set(Long.parseLong(str));
                    oidb_0x5d6_snsupatebuffer.rpt_msg_sns_update_item.set(arrayList2);
                    arrayList.add(oidb_0x5d6_snsupatebuffer);
                }
                i19++;
                c18 = c16;
                c17 = 4;
                i16 = 3;
                i17 = 2;
            }
            oidb_0x5d6$ReqBody oidb_0x5d6_reqbody = new oidb_0x5d6$ReqBody();
            oidb_0x5d6_reqbody.uint32_domain.set(1);
            oidb_0x5d6_reqbody.uint32_seq.set(0);
            oidb_0x5d6_reqbody.rpt_msg_update_buffer.set(arrayList);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1494);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(21);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d6_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x5d6_21");
            createToServiceMsg.extraData.putInt("param_type", i3);
            createToServiceMsg.extraData.putStringArray(PARAM_UINS, strArr);
            createToServiceMsg.extraData.putBooleanArray(PARAM_SWITCH_STATE, zArr);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
        }
    }

    public void setRemarkName(final String str, final String str2, final boolean z16, final IOperateCallback iOperateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, str, str2, Boolean.valueOf(z16), iOperateCallback);
            return;
        }
        com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
        if (b16 == null) {
            QLog.e(TAG, 1, "setRemarkName service is null");
        } else {
            b16.setBuddyRemark(new RemarkParams(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), str2, null), new IOperateCallback() { // from class: com.tencent.mobileqq.app.aq
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str3) {
                    FriendListHandler.lambda$setRemarkName$0(IOperateCallback.this, z16, str, str2, i3, str3);
                }
            });
        }
    }

    public void setShowBigClubSwitch(QQAppInterface qQAppInterface, boolean z16, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, this, qQAppInterface, Boolean.valueOf(z16), troopProtocolObserver);
            return;
        }
        try {
            byte[] bArr = new byte[13];
            PkgTools.dWord2Byte(bArr, 0, Long.parseLong(qQAppInterface.getCurrentAccountUin()));
            bArr[4] = 0;
            PkgTools.word2Byte(bArr, 5, (short) 1);
            PkgTools.dWordTo2Bytes(bArr, 7, 42275);
            PkgTools.word2Byte(bArr, 9, (short) 2);
            PkgTools.word2Byte(bArr, 11, (short) (!z16 ? 1 : 0));
            ProtoUtils.a(qQAppInterface, troopProtocolObserver, bArr, ProfileContants.CMD_SET_DETAIL_INFO, 1279, 9);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w(LogTag.DATING, 2, "send_oidb_0x4ff_9 error", e16);
            }
        }
    }

    public void setSpecialCareSwitch(int i3, String[] strArr, boolean[] zArr) {
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), strArr, zArr);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("FriendListHandler.setSpecialCareSwitch(). type=");
            sb5.append(i3);
            sb5.append(", uin size=");
            int i17 = -1;
            if (strArr == null) {
                length = -1;
            } else {
                length = strArr.length;
            }
            sb5.append(length);
            sb5.append(", switch size=");
            if (zArr != null) {
                i17 = zArr.length;
            }
            sb5.append(i17);
            QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCH, 2, sb5.toString());
        }
        if (i3 >= 1 && i3 <= 3 && strArr != null && zArr != null && strArr.length != 0 && strArr.length == zArr.length) {
            ArrayList arrayList = new ArrayList();
            int i18 = 0;
            while (i18 < strArr.length) {
                String str = strArr[i18];
                if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(str, TAG)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCH, 2, "uin is null");
                    }
                } else {
                    boolean z16 = zArr[i18];
                    oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem = new oidb_0x5d6$SnsUpdateItem();
                    ArrayList arrayList2 = new ArrayList();
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == i16) {
                                oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13572);
                                if (z16) {
                                    oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                                }
                                arrayList2.add(oidb_0x5d6_snsupdateitem);
                            }
                        } else {
                            oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13568);
                            if (z16) {
                                oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                            }
                            arrayList2.add(oidb_0x5d6_snsupdateitem);
                            oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem2 = new oidb_0x5d6$SnsUpdateItem();
                            oidb_0x5d6_snsupdateitem2.uint32_update_sns_type.set(13573);
                            oidb_0x5d6_snsupdateitem2.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                            arrayList2.add(oidb_0x5d6_snsupdateitem2);
                        }
                    } else if (z16) {
                        oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13573);
                        oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                        arrayList2.add(oidb_0x5d6_snsupdateitem);
                        oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem3 = new oidb_0x5d6$SnsUpdateItem();
                        oidb_0x5d6_snsupdateitem3.uint32_update_sns_type.set(13568);
                        oidb_0x5d6_snsupdateitem3.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                        arrayList2.add(oidb_0x5d6_snsupdateitem3);
                        oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem4 = new oidb_0x5d6$SnsUpdateItem();
                        oidb_0x5d6_snsupdateitem4.uint32_update_sns_type.set(13572);
                        oidb_0x5d6_snsupdateitem4.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                        arrayList2.add(oidb_0x5d6_snsupdateitem4);
                    } else {
                        oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13573);
                        arrayList2.add(oidb_0x5d6_snsupdateitem);
                        oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem5 = new oidb_0x5d6$SnsUpdateItem();
                        oidb_0x5d6_snsupdateitem5.uint32_update_sns_type.set(13568);
                        arrayList2.add(oidb_0x5d6_snsupdateitem5);
                        oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem6 = new oidb_0x5d6$SnsUpdateItem();
                        oidb_0x5d6_snsupdateitem6.uint32_update_sns_type.set(13572);
                        arrayList2.add(oidb_0x5d6_snsupdateitem6);
                    }
                    oidb_0x5d6$SnsUpateBuffer oidb_0x5d6_snsupatebuffer = new oidb_0x5d6$SnsUpateBuffer();
                    oidb_0x5d6_snsupatebuffer.uint64_uin.set(Long.parseLong(str));
                    oidb_0x5d6_snsupatebuffer.rpt_msg_sns_update_item.set(arrayList2);
                    arrayList.add(oidb_0x5d6_snsupatebuffer);
                }
                i18++;
                i16 = 3;
            }
            oidb_0x5d6$ReqBody oidb_0x5d6_reqbody = new oidb_0x5d6$ReqBody();
            oidb_0x5d6_reqbody.uint32_domain.set(1);
            oidb_0x5d6_reqbody.uint32_seq.set(0);
            oidb_0x5d6_reqbody.rpt_msg_update_buffer.set(arrayList);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1494);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(7);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d6_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x5d6_7");
            createToServiceMsg.extraData.putInt("param_type", i3);
            createToServiceMsg.extraData.putStringArray(PARAM_UINS, strArr);
            createToServiceMsg.extraData.putBooleanArray(PARAM_SWITCH_STATE, zArr);
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
        }
    }

    public void setSpecialCareSwitchesOfAPerson(String str, int[] iArr, boolean[] zArr, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            setSpecialCareSwitchesOfAPerson(str, iArr, zArr, strArr, true);
        } else {
            iPatchRedirector.redirect((short) 19, this, str, iArr, zArr, strArr);
        }
    }

    public void setVisibilityForNetWorkStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this, z16);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1169);
        oidb_sso_oidbssopkg.uint32_service_type.set(107);
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) (!z16 ? 1 : 0));
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x491_107");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putBoolean("key_show_to_friends", z16);
        createToServiceMsg.setTimeout(10000L);
        sendPbReq(createToServiceMsg);
    }

    public boolean shouldGetOnlineInfo() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.timeGetOnlineInfo;
        long j16 = this.intervalGetOnlineInfo;
        if (j3 < j16 && j3 > (-j16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.timeGetOnlineInfo = currentTimeMillis;
        }
        return z16;
    }

    public boolean shouldReqLevel(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str)).booleanValue();
        }
        boolean equals = str.equals(this.app.getCurrentAccountUin());
        if (equals) {
            long c16 = com.tencent.mobileqq.utils.z.c(this.app.getApp().getApplicationContext(), this.app.getCurrentAccountUin());
            if (Math.abs(System.currentTimeMillis() - c16) > 86400000) {
                equals = true;
            } else {
                equals = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "$shouldReqLevel | lastReqTime = " + c16 + " | currentTime = " + System.currentTimeMillis());
            }
        }
        return equals;
    }

    public void updateTrustDeviceList(long j3, int i3, String str, int i16, ArrayList<com.tencent.mobileqq.antiphing.b> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Long.valueOf(j3), Integer.valueOf(i3), str, Integer.valueOf(i16), arrayList);
            return;
        }
        device_lock_confirm_auth$ReqBody device_lock_confirm_auth_reqbody = new device_lock_confirm_auth$ReqBody();
        device_lock_confirm_auth_reqbody.uint64_uin.set(j3);
        device_lock_confirm_auth_reqbody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
        device_lock_confirm_auth_reqbody.uint32_appid.set(this.app.getAppid());
        device_lock_confirm_auth_reqbody.uint32_subappid.set(i3);
        device_lock_confirm_auth_reqbody.uint32_seq.set(i16);
        device_lock_confirm_auth_reqbody.bytes_appname.set(ByteStringMicro.copyFrom(str.getBytes()));
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        for (int i17 = 0; i17 < size; i17++) {
            device_lock_confirm_auth$DeviceInfo device_lock_confirm_auth_deviceinfo = new device_lock_confirm_auth$DeviceInfo();
            com.tencent.mobileqq.antiphing.b bVar = arrayList.get(i17);
            if (bVar != null) {
                device_lock_confirm_auth_deviceinfo.bytes_appname.set(ByteStringMicro.copyFrom(bVar.f194362d.getBytes()));
                device_lock_confirm_auth_deviceinfo.bytes_device_name.set(ByteStringMicro.copyFrom(bVar.f194359a.getBytes()));
                device_lock_confirm_auth_deviceinfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(bVar.f194360b.getBytes()));
                device_lock_confirm_auth_deviceinfo.bytes_guid.set(ByteStringMicro.copyFrom(bVar.f194361c));
                device_lock_confirm_auth_deviceinfo.uint32_appid.set(bVar.f194363e);
                device_lock_confirm_auth_deviceinfo.uint32_auth_status.set(bVar.f194365g);
                device_lock_confirm_auth_deviceinfo.uint32_subappid.set(i3);
                arrayList2.add(device_lock_confirm_auth_deviceinfo);
            }
        }
        if (arrayList2.size() > 0) {
            device_lock_confirm_auth_reqbody.rpt_msg_devicelist.set(arrayList2);
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("DevLockAuthSvc.ConfirmAuth");
        createToServiceMsg.putWupBuffer(device_lock_confirm_auth_reqbody.toByteArray());
        createToServiceMsg.setTimeout(4000L);
        sendPbReq(createToServiceMsg);
    }

    private long convertUin(String str) {
        long parseLong;
        if (str == null) {
            return 0L;
        }
        if (str.length() > 0) {
            try {
                parseLong = Long.parseLong(str);
                if (parseLong < 10000) {
                    return 0L;
                }
            } catch (NumberFormatException unused) {
                return 0L;
            }
        }
        return parseLong;
    }

    @Deprecated
    public void delFriend(String str, String str2, byte b16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, str, str2, Byte.valueOf(b16), Integer.valueOf(i3));
            return;
        }
        if (com.tencent.mobileqq.util.e.d()) {
            QLog.i(TAG, 1, "delFriend by nt");
            IDelFriendService iDelFriendService = (IDelFriendService) this.app.getRuntimeService(IDelFriendService.class);
            if (StringUtil.isEmpty(str)) {
                str = TAG;
            }
            iDelFriendService.delFriend(str, str2, b16, i3);
            return;
        }
        QLog.i(TAG, 1, "NO CRASH, JUST FOR GET INFO: " + QLog.getStackTraceString(new Throwable()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.delFriend");
        toServiceMsg.extraData.putString("uin", str2);
        toServiceMsg.extraData.putByte(PictureConst.KEY_DEL_TYPE, b16);
        if (i3 != -1) {
            toServiceMsg.extraData.putInt("not_shield_tmp_session", i3);
        }
        send(toServiceMsg);
    }

    public void gatherContacts(short s16, List<String> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, this, Short.valueOf(s16), list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (s16 <= 0 || list == null || s16 != list.size()) {
            return;
        }
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1268);
            oidb_sso_oidbssopkg.uint32_service_type.set(5);
            ByteBuffer allocate = ByteBuffer.allocate((z16 ? s16 * 12 : s16 * 9) + 2);
            allocate.putShort(s16);
            for (int i3 = 0; i3 < s16; i3++) {
                allocate.putInt(Utils.O(Long.parseLong(list.get(i3))));
                if (z16) {
                    allocate.putShort((short) 2);
                    allocate.putShort((short) 4060).put((byte) 1).putShort((short) 4057).put((byte) 0);
                } else {
                    allocate.putShort((short) 1);
                    allocate.putShort((short) 4060).put((byte) 0);
                }
            }
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x4f4_5");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.extraData.putBoolean("isGather", z16);
            createToServiceMsg.extraData.putStringArrayList("friendUinList", (ArrayList) list);
            createToServiceMsg.extraData.putBoolean("needNotifyPlugin", z17);
            createToServiceMsg.setTimeout(10000L);
            sendPbReq(createToServiceMsg);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "gatherContacts  Exception " + e16.getMessage());
            }
        }
    }

    public synchronized void getFriendGroupList(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getFriendGroupList| refresh: " + z16);
        }
        if (!z16) {
            ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isGetFriendListSuc(TAG, new hx3.b<Boolean>() { // from class: com.tencent.mobileqq.app.FriendListHandler.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FriendListHandler.this);
                    }
                }

                @Override // hx3.b
                public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<Boolean> eVar) {
                    ArrayList<Boolean> b16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                    } else if (eVar.a() == 0 && (b16 = eVar.b()) != null && b16.size() > 0 && b16.get(0).booleanValue()) {
                        FriendListHandler.this.notifyUI(1, true, null);
                    }
                }
            });
        } else {
            ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestFriendList(z17);
        }
    }

    public void getFriendInfo(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FetchInfoListManager", 2, "uin = " + str);
        }
        if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isValidUin(str, TAG) && isNeedSendGetFriendInfo(str)) {
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_GETSIMPLEINFO);
            createToServiceMsg.extraData.putStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            createToServiceMsg.extraData.putBoolean("reqSelfLevel", shouldReqLevel(str));
            createToServiceMsg.extraData.putBoolean("reqXMan", shouldReqXMan(str));
            createToServiceMsg.extraData.putBoolean("reqDateNick", z16);
            send(createToServiceMsg);
        }
    }

    public void setFriendComment(String str, String str2, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, str, str2, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z16) {
            ToServiceMsg createToServiceMsg = createToServiceMsg(ProfileContants.CMD_SETCOMMENT);
            createToServiceMsg.extraData.putString(ProfileContants.CMD_PARAM_COM_VALUE, str2);
            createToServiceMsg.extraData.putString("uin", str);
            createToServiceMsg.extraData.putBoolean(ProfileContants.CMD_PARAM_NOTIFY_PLUGIN, z17);
            createToServiceMsg.setTimeout(30000L);
            send(createToServiceMsg);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        FriendsManager friendsManager = (FriendsManager) this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card q16 = friendsManager.q(str);
        q16.strReMark = str2;
        friendsManager.p0(q16);
        friendsManager.s0(str, str2);
        ((n) this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).M(str, str2);
        ((ITroopMemberInfoService) this.app.getRuntimeService(ITroopMemberInfoService.class, "")).notifyFriendRemarkChange(str, str2);
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.app.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService != null) {
            iPhoneContactService.notifyContactChanged();
        }
    }

    public void setSpecialCareSwitchesOfAPerson(String str, int[] iArr, boolean[] zArr, String[] strArr, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, iArr, zArr, strArr, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("uin=");
            sb5.append(str);
            sb5.append(", type size=");
            sb5.append(iArr == null ? "" : Integer.valueOf(iArr.length));
            sb5.append(", switchState size=");
            sb5.append(zArr == null ? "null" : Integer.valueOf(zArr.length));
            sb5.append(", ringId size=");
            sb5.append(strArr != null ? Integer.valueOf(strArr.length) : "null");
            QLog.d(LogTag.TAG_SET_SPECIAL_CARE_SWITCHES_OF_A_PERSON, 2, sb5.toString());
        }
        if (StringUtil.isEmpty(str) || iArr == null || zArr == null || strArr == null || iArr.length != zArr.length || zArr.length != strArr.length) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        oidb_0x5d6$SnsUpateBuffer oidb_0x5d6_snsupatebuffer = new oidb_0x5d6$SnsUpateBuffer();
        oidb_0x5d6_snsupatebuffer.uint64_uin.set(Long.parseLong(str));
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int i16 = iArr[i3];
            boolean z17 = zArr[i3];
            String str2 = strArr[i3];
            oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem = new oidb_0x5d6$SnsUpdateItem();
            if (i16 != 1) {
                if (i16 == 2) {
                    oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13568);
                    if (z17) {
                        if (!StringUtil.isEmpty(str2)) {
                            oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom(str2.getBytes()));
                        } else {
                            throw new IllegalArgumentException("special ring id can not be empty!");
                        }
                    }
                    arrayList.add(oidb_0x5d6_snsupdateitem);
                    oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem2 = new oidb_0x5d6$SnsUpdateItem();
                    oidb_0x5d6_snsupdateitem2.uint32_update_sns_type.set(13573);
                    oidb_0x5d6_snsupdateitem2.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                    arrayList.add(oidb_0x5d6_snsupdateitem2);
                } else if (i16 == 3) {
                    oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13572);
                    if (z17) {
                        oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                    }
                    arrayList.add(oidb_0x5d6_snsupdateitem);
                }
            } else if (z17) {
                oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13573);
                oidb_0x5d6_snsupdateitem.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                arrayList.add(oidb_0x5d6_snsupdateitem);
                oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem3 = new oidb_0x5d6$SnsUpdateItem();
                oidb_0x5d6_snsupdateitem3.uint32_update_sns_type.set(13568);
                oidb_0x5d6_snsupdateitem3.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                arrayList.add(oidb_0x5d6_snsupdateitem3);
                oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem4 = new oidb_0x5d6$SnsUpdateItem();
                oidb_0x5d6_snsupdateitem4.uint32_update_sns_type.set(13572);
                oidb_0x5d6_snsupdateitem4.bytes_value.set(ByteStringMicro.copyFrom("1".getBytes()));
                arrayList.add(oidb_0x5d6_snsupdateitem4);
            } else {
                oidb_0x5d6_snsupdateitem.uint32_update_sns_type.set(13573);
                arrayList.add(oidb_0x5d6_snsupdateitem);
                oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem5 = new oidb_0x5d6$SnsUpdateItem();
                oidb_0x5d6_snsupdateitem5.uint32_update_sns_type.set(13568);
                arrayList.add(oidb_0x5d6_snsupdateitem5);
                oidb_0x5d6$SnsUpdateItem oidb_0x5d6_snsupdateitem6 = new oidb_0x5d6$SnsUpdateItem();
                oidb_0x5d6_snsupdateitem6.uint32_update_sns_type.set(13572);
                arrayList.add(oidb_0x5d6_snsupdateitem6);
            }
        }
        oidb_0x5d6_snsupatebuffer.rpt_msg_sns_update_item.set(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(oidb_0x5d6_snsupatebuffer);
        oidb_0x5d6$ReqBody oidb_0x5d6_reqbody = new oidb_0x5d6$ReqBody();
        oidb_0x5d6_reqbody.uint32_domain.set(1);
        oidb_0x5d6_reqbody.uint32_seq.set(0);
        oidb_0x5d6_reqbody.rpt_msg_update_buffer.set(arrayList2);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1494);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(7);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d6_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x5d6_7");
        createToServiceMsg.extraData.putString("param_uin", str);
        createToServiceMsg.extraData.putIntArray("param_type", iArr);
        createToServiceMsg.extraData.putBooleanArray(PARAM_SWITCH_STATE, zArr);
        createToServiceMsg.extraData.putStringArray(PARAM_RING_IDS, strArr);
        createToServiceMsg.extraData.putBoolean(PARAM_IS_SET_SWITCHES_OF_A_PERSON, true);
        createToServiceMsg.extraData.putBoolean(PARAM_SPECIAL_CARE_OPEN, z16);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    public void getLastLoginInfo(long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        long parseLong = Long.parseLong(this.app.getCurrentAccountUin());
        ToServiceMsg createToServiceMsg = createToServiceMsg("friendlist.GetLastLoginInfoReq");
        createToServiceMsg.extraData.putLong("uin", parseLong);
        createToServiceMsg.extraData.putLong("total_req_times", j3);
        createToServiceMsg.extraData.putLong("current_req_index", j16);
        createToServiceMsg.extraData.putLong("current_req_uin", j17);
        send(createToServiceMsg);
    }

    public void getStrangerInfo(long[] jArr, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) jArr, (Object) iArr);
            return;
        }
        if (jArr == null || iArr == null) {
            return;
        }
        int length = jArr.length;
        ByteBuffer allocate = ByteBuffer.allocate((iArr.length * 2) + 4 + (length * 4));
        allocate.putShort((short) iArr.length);
        for (int i3 : iArr) {
            allocate.putShort((short) i3);
        }
        allocate.putShort((short) length);
        for (long j3 : jArr) {
            allocate.putInt(Utils.O(j3));
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1276);
        oidb_sso_oidbssopkg.uint32_service_type.set(30);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(allocate.array()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x4fc_30");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(10000L);
        sendPbReq(createToServiceMsg);
    }

    public void searchFriend(String str, String str2, int i3, int i16, int[] iArr, double d16, double d17, boolean z16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), iArr, Double.valueOf(d16), Double.valueOf(d17), Boolean.valueOf(z16), Integer.valueOf(i17), Long.valueOf(j3));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("SummaryCard.ReqSearch");
        createToServiceMsg.extraData.putString("param_keyword", str);
        createToServiceMsg.extraData.putString("param_country_code", str2);
        createToServiceMsg.extraData.putInt("search_page", i16);
        createToServiceMsg.extraData.putIntArray("search_list", iArr);
        createToServiceMsg.extraData.putInt("search_version", i3);
        createToServiceMsg.extraData.putDouble("search_longtitude", d16);
        createToServiceMsg.extraData.putDouble("search_latitude", d17);
        createToServiceMsg.extraData.putBoolean("search_decode", z16);
        createToServiceMsg.extraData.putInt("filter_type", i17);
        createToServiceMsg.extraData.putLong(ServiceConst.PARA_SESSION_ID, j3);
        createToServiceMsg.extraData.putString("trace_id", SearchUtil.j());
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "search friend with filter:" + i17);
        }
        send(createToServiceMsg);
    }

    public void decodePush0x210_0x11e(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this, (Object) bArr);
            return;
        }
        if (bArr != null) {
            try {
                SubMsgType0x11e$MsgBody subMsgType0x11e$MsgBody = new SubMsgType0x11e$MsgBody();
                subMsgType0x11e$MsgBody.mergeFrom(bArr);
                long j3 = subMsgType0x11e$MsgBody.uint32_type.has() ? subMsgType0x11e$MsgBody.uint32_type.get() : -1L;
                String str = subMsgType0x11e$MsgBody.str_reason.has() ? subMsgType0x11e$MsgBody.str_reason.get() : null;
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "decodePush0x210_0x11e,type = " + j3 + " reason = " + str);
                }
                if (j3 == 1) {
                    getFriendGroupList(true);
                    return;
                } else {
                    if (j3 == 2) {
                        getCheckUpdate(true, 8);
                        return;
                    }
                    return;
                }
            } catch (Throwable th5) {
                QLog.i(TAG, 1, "decodePush0x210_0x11e decode error, e=" + th5.toString());
                return;
            }
        }
        QLog.i(TAG, 1, "decodePush0x210_0x11e pbData = null");
    }
}
