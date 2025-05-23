package com.tencent.biz.pubaccount.api.impl;

import KQQ.ReqItem;
import KQQ.RespItem;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFollowListReq;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead$StGetFollowListRsp;
import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.jce.GetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.accountdetail.jce.SetRecvMsgStateRsp;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountDynamicMsgProcessor;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.api.IPublicAccountStQWebServlet;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.jungle.weather.WeatherReportInfo$GetWeatherMessageReq;
import com.tencent.jungle.weather.WeatherReportInfo$GetWeatherMessageRsp;
import com.tencent.jungle.weather.WeatherReportInfo$PbReqMsgHead;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.z;
import com.tencent.mobileqq.biuGuide.SSOBiuGuide$RspBody;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.PublicRecommendAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.UinPair;
import com.tencent.mobileqq.mp.historyMsg$AioHistoryMsgRequest;
import com.tencent.mobileqq.mp.historyMsg$AioHistoryMsgResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$GetUserFollowListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$GetUserFollowListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$SendLBSInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$SendPreMessageStatusResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$SetMessageConfigurationResponse;
import com.tencent.mobileqq.mp.publicaccount_recommend$BusinessRecommendRequest;
import com.tencent.mobileqq.mp.publicaccount_recommend$BusinessRecommendResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.vaswebviewplugin.PublicAccountWebReport;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$PublicAccountInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28$FollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28$RspFollowList;
import tencent.im.s2c.msgtype0x210.submsgtype0x28.SubMsgType0x28$RspTypeList;

/* loaded from: classes32.dex */
public class PublicAccountHandlerImpl extends BusinessHandler implements IPublicAccountHandler {
    private static final String ARG_GET_FOLLOW_LIST_BEGIN = "get_user_follow_list_begin";
    private static final String ARG_GET_FOLLOW_LIST_DATA_SEQ = "get_user_follow_list_data_seq";
    private static final String ARG_GET_FOLLOW_LIST_FOLLOW_SEQ = "get_user_follow_list_follow_seq";
    private static final String ARG_GET_FOLLOW_LIST_FROM_SRC = "get_user_follow_list_from_src";
    private static final String ARG_GET_FOLLOW_LIST_IS_INCREMENT = "get_user_follow_list_is_increment";
    private static final String ARG_GET_FOLLOW_LIST_IS_NEW_SEQ_LOGIC = "get_user_follow_list_is_new_seq_logic";
    private static final String ARG_TIME_STAMP = "time_stamp";
    public static final String CMD_PUBLICACCOUNT_SVC_SEND_LBS = "PubAccountSvc.ReportLbs";
    public static final String CMD_PUBLICACCOUNT_WEATHER_INFO = "QQWeatherReport.getWeatherInfo";
    private static final int GET_USER_FOLLOW_LIST_LIMIT = 20;
    private static final String INDEX_DATA_SEQ = "PublicAccountDataSeq2";
    private static final String INDEX_FOLLOW_SEQ = "PublicAccountFollowSeq2";
    public static final String KEY_AIO_TIME = "aio_time";
    public static final String KEY_LIST_TIME = "list_time";
    public static final String KEY_LOCATION_TIME = "location_time";
    public static final String KEY_LOC_LAT = "loc_lat";
    public static final String KEY_LOC_LNG = "loc_lng";
    public static final String KEY_SETTING_RESULT_PRE = "setting_result_";
    public static final String KEY_SETTING_STATUS_PRE = "setting_status_";
    private static final String NAME_SEARCH_SWITCH = "PublicAccount_SearchSwitch";
    private static final String NAME_TOTAL_SWITCH = "PublicAccount_TotalSwitch";
    private static final String NEW_PROTOCOL_INDEX_DATA_SEQ = "NewProtocolPublicAccountDataSeq2";
    private static final String NEW_PROTOCOL_INDEX_FOLLOW_SEQ = "NewProtocolPublicAccountFollowSeq2";
    private static final String PREF_KEY_GET_FOLLOW_LIST_NEW_PROTOCOL_ATTACH_INFO = "NewProtocolGetFollowListAttachInfo";
    public static final String PREF_KEY_SETTING_STATUS_PREFIX = "public_account_detail_setting_status";
    private static final int STATUS_FOLLOW = 1;
    private static final int STATUS_INVALID = 3;
    private static final int STATUS_UNFOLLOW = 2;
    private static final int SUB_CMD_FOLLOWING = 1;
    private static final int SUB_CMD_SETTING = 2;
    private static final String TAG = "PublicAccountHandler";
    private static final int WEATHER_LIMIT_DURATION = 3600000;
    public static final int WEATHER_TYPE_AD = 1;
    public static final int WEATHER_TYPE_CHECK = 2;
    public static final int WEATHER_TYPE_OFFLINE = -1;
    public static final int WEATHER_TYPE_SWITCH = 4;
    public static final int WEATHER_TYPE_UNKOWN = 0;
    public static long currentFansMsgId = 0;
    public static long currentPublishMsgId = 0;
    public static long pUIN = 0;
    public static String publicAccountText = "";
    public static String sLocalIp;
    private QQAppInterface app;
    public List<UinPair> lbsUinList;
    public boolean loadAioHistroyMsg;
    public long loadHistoryMsgUin;
    private boolean mHasStepRequestFollowList;
    private boolean mIsNeedUpdate;
    private boolean mSearchSwitch;
    private boolean mTotalSwitch;
    private Map<Integer, IPublicAccountHandler.a> mWeatherInfos;

    /* loaded from: classes32.dex */
    private static class FolderRefreshRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QQAppInterface> f79393d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<PublicAccountDataManagerImpl> f79394e;

        @Override // java.lang.Runnable
        public void run() {
            QQAppInterface qQAppInterface = this.f79393d.get();
            PublicAccountDataManagerImpl publicAccountDataManagerImpl = this.f79394e.get();
            if (qQAppInterface == null || publicAccountDataManagerImpl == null) {
                return;
            }
            TroopBarAssistantManager.n().D(qQAppInterface, (List) publicAccountDataManagerImpl.getPublicAccountEqqInfoList());
            TroopBarAssistantManager.n().E(qQAppInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends LbsManagerServiceOnLocationChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f79395a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f79396b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f79397c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f79398d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z16, int i3, int i16, int i17, int i18) {
            super(str, z16);
            this.f79395a = i3;
            this.f79396b = i16;
            this.f79397c = i17;
            this.f79398d = i18;
        }

        @Override // com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("errCode \uff1a");
                sb5.append(i3);
                sb5.append(" info is null ---> ");
                sb5.append(sosoLbsInfo == null);
                QLog.d(PublicAccountHandlerImpl.TAG, 2, sb5.toString());
            }
            PublicAccountHandlerImpl publicAccountHandlerImpl = PublicAccountHandlerImpl.this;
            int i16 = this.f79395a;
            int i17 = this.f79396b;
            int i18 = this.f79397c;
            int i19 = this.f79398d;
            if (i3 != 0) {
                sosoLbsInfo = null;
            }
            publicAccountHandlerImpl.sendWeatherLocRequest(i16, i17, i18, i19, sosoLbsInfo);
        }
    }

    /* loaded from: classes32.dex */
    public class b implements com.tencent.mobileqq.service.profile.a {
        public b() {
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public ReqItem d2(int i3) {
            ReqItem reqItem = new ReqItem();
            reqItem.cOperType = (byte) 0;
            reqItem.eServiceID = 102;
            boolean isGetFollowListUseNewProtocol = PublicAccountConfigUtilImpl.isGetFollowListUseNewProtocol();
            long preFollowSeq = PublicAccountHandlerImpl.this.getPreFollowSeq(isGetFollowListUseNewProtocol);
            long preDataSeq = PublicAccountHandlerImpl.this.getPreDataSeq(isGetFollowListUseNewProtocol);
            String preAttachInfoForNewProtocol = PublicAccountHandlerImpl.this.getPreAttachInfoForNewProtocol();
            if (isGetFollowListUseNewProtocol) {
                CertifiedAccountRead$StGetFollowListReq certifiedAccountRead$StGetFollowListReq = new CertifiedAccountRead$StGetFollowListReq();
                certifiedAccountRead$StGetFollowListReq.seq.set(Utils.O(preFollowSeq));
                certifiedAccountRead$StGetFollowListReq.count.set(Utils.O(1L));
                if (!TextUtils.isEmpty(preAttachInfoForNewProtocol)) {
                    certifiedAccountRead$StGetFollowListReq.attach_info.set(preAttachInfoForNewProtocol);
                }
                PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
                stQWebReq.Seq.set(-1L);
                stQWebReq.qua.set(QUA.getQUA3());
                stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
                stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(certifiedAccountRead$StGetFollowListReq.toByteArray()));
                String traceId = ze0.a.getTraceId();
                if (!TextUtils.isEmpty(traceId)) {
                    stQWebReq.traceid.set(traceId);
                }
                byte[] byteArray = stQWebReq.toByteArray();
                if (byteArray == null) {
                    byteArray = new byte[4];
                }
                reqItem.vecParam = fh.b(byteArray);
            } else {
                mobileqq_mp$GetUserFollowListRequest mobileqq_mp_getuserfollowlistrequest = new mobileqq_mp$GetUserFollowListRequest();
                mobileqq_mp_getuserfollowlistrequest.follow_seqno.set((int) preFollowSeq);
                mobileqq_mp_getuserfollowlistrequest.public_account_seqno.set((int) preDataSeq);
                mobileqq_mp_getuserfollowlistrequest.begin.set(0);
                mobileqq_mp_getuserfollowlistrequest.limit.set(1);
                mobileqq_mp_getuserfollowlistrequest.version.set(1);
                mobileqq_mp_getuserfollowlistrequest.is_increment.set(true);
                reqItem.vecParam = fh.b(mobileqq_mp_getuserfollowlistrequest.toByteArray());
            }
            return reqItem;
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public void l2(RespItem respItem) {
            if (respItem.eServiceID == 102 && respItem.cResult == 0) {
                QLog.d(PublicAccountHandlerImpl.TAG, 1, "CheckUpdateItemData Set Not Update");
                PublicAccountHandlerImpl.this.setNotNeedUpdate();
            }
        }

        @Override // com.tencent.mobileqq.service.profile.a
        public int w0() {
            return 1;
        }
    }

    public PublicAccountHandlerImpl() {
        super(null);
        this.lbsUinList = null;
        this.mWeatherInfos = new HashMap();
        this.loadAioHistroyMsg = false;
        this.loadHistoryMsgUin = 0L;
        this.mHasStepRequestFollowList = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPreAttachInfoForNewProtocol() {
        return this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getString(PREF_KEY_GET_FOLLOW_LIST_NEW_PROTOCOL_ATTACH_INFO, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPreDataSeq(boolean z16) {
        String str;
        SharedPreferences sharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
        if (z16) {
            str = NEW_PROTOCOL_INDEX_DATA_SEQ;
        } else {
            str = INDEX_DATA_SEQ;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPreFollowSeq(boolean z16) {
        String str;
        SharedPreferences sharedPreferences = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
        if (z16) {
            str = NEW_PROTOCOL_INDEX_FOLLOW_SEQ;
        } else {
            str = INDEX_FOLLOW_SEQ;
        }
        return sharedPreferences.getLong(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getWeatherLBSInfo(final int i3) {
        ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new SosoInterfaceOnLocationListener(0, true, true, 60000L, true, false, TAG) { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.2
            @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
            public void onLocationFinish(int i16, SosoLbsInfo sosoLbsInfo) {
                SosoLocation sosoLocation;
                if (i16 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                    PublicAccountHandlerImpl.this.sendLocRequest(i3, (int) (sosoLocation.mLat02 * 1000000.0d), (int) (sosoLocation.mLon02 * 1000000.0d), 0);
                } else {
                    ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            PublicAccountHandlerImpl.this.sendLocRequest(i3, 0, 0, 0);
                        }
                    });
                }
            }
        });
    }

    private void handleGetUserFollowListInnerLogic2(boolean z16, IPublicAccountObserver.b bVar, long j3, long j16, boolean z17, CertifiedAccountRead$StGetFollowListRsp certifiedAccountRead$StGetFollowListRsp, boolean z18, long j17, String str, boolean z19, int i3) {
        boolean z26;
        PublicAccountHandlerImpl publicAccountHandlerImpl;
        List<oidb_cmd0xcf8$PublicAccountInfo> list = certifiedAccountRead$StGetFollowListRsp.account_list.get();
        long size = list.size();
        List<PublicAccountInfo> createPublicAccountInfoListCf8 = PublicAccountInfo.createPublicAccountInfoListCf8(list, j3);
        bVar.f79356d = createPublicAccountInfoListCf8;
        bVar.f79355c = !z18;
        bVar.f79354b = size;
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        savePublicAccountInfos(createPublicAccountInfoListCf8, j3, z17, bVar.f79355c, z19, i3);
        handleGetUserFollowListRetmIsFinish(bVar, (PublicAccountDataManagerImpl) iPublicAccountDataManager);
        if (bVar.f79355c) {
            z26 = z16;
            publicAccountHandlerImpl = this;
            publicAccountHandlerImpl.saveCurFollowSeq(j17, z26);
            publicAccountHandlerImpl.saveAttachInfoForNewProtocol(str);
        } else {
            if (z17) {
                publicAccountHandlerImpl = this;
                publicAccountHandlerImpl.getUserFollowList(j17, 0L, 0L, 20L, j3, true, true, str, z19, i3);
            } else {
                publicAccountHandlerImpl = this;
                publicAccountHandlerImpl.getUserFollowList(j17, 0L, j16 + 20, 20L, j3, false, true, str, z19, i3);
            }
            z26 = z16;
        }
        publicAccountHandlerImpl.setCurDataSeq(0L, z26);
    }

    private void handleGetUserFollowListInnerLogic3(boolean z16, IPublicAccountObserver.b bVar, long j3, long j16, boolean z17, long j17, long j18, PublicAccountDataManagerImpl publicAccountDataManagerImpl, boolean z18, int i3) {
        if (bVar.f79355c) {
            TroopBarAssistantManager.n().D(this.app, (List) publicAccountDataManagerImpl.getPublicAccountEqqInfoList());
            TroopBarAssistantManager.n().E(this.app);
        }
        if (bVar.f79355c) {
            saveCurFollowSeq(j17, z16);
        } else if (z17) {
            getUserFollowList(j17, j18, 0L, 20L, j3, true, z16, null, z18, i3);
        } else {
            getUserFollowList(j17, j18, j16 + 20, 20L, j3, false, z16, null, z18, i3);
        }
    }

    private void handleGetUserFollowListQLogErrCode(String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, str + i3);
        }
    }

    private void handleGetUserFollowListQLogHasnext(mobileqq_mp$GetUserFollowListResponse mobileqq_mp_getuserfollowlistresponse, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetUserFollowList        errCode: " + i3 + "    has_next: " + (mobileqq_mp_getuserfollowlistresponse.has_next.has() ? mobileqq_mp_getuserfollowlistresponse.has_next.get() : false));
        }
    }

    private void handleGetUserFollowListQLogPreFollowData(long j3, long j16, long j17, long j18) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetUserFollowList time:  " + j3 + "  begin: " + j16 + "  preFollowSeq: " + j17 + "  preDataSeq: " + j18);
        }
    }

    private void handleGetUserFollowListQLogRefresh(boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetUserFollowList      refresh: " + z16 + "    has_next: " + z17);
        }
    }

    private void handleGetUserFollowListRetmIsFinish(IPublicAccountObserver.b bVar, PublicAccountDataManagerImpl publicAccountDataManagerImpl) {
        if (bVar.f79355c) {
            TroopBarAssistantManager.n().D(this.app, (List) publicAccountDataManagerImpl.getPublicAccountEqqInfoList());
            TroopBarAssistantManager.n().E(this.app);
        }
    }

    private void handlePushMessageFollowList(SubMsgType0x28$RspFollowList subMsgType0x28$RspFollowList) {
        List<SubMsgType0x28$FollowList> list = subMsgType0x28$RspFollowList.rpt_msg_followlist.get();
        long parseLong = Long.parseLong(this.app.getCurrentAccountUin());
        boolean z16 = false;
        boolean z17 = false;
        IPublicAccountObserver.a aVar = null;
        for (SubMsgType0x28$FollowList subMsgType0x28$FollowList : list) {
            if (parseLong == subMsgType0x28$FollowList.uint64_uin.get()) {
                String valueOf = String.valueOf(subMsgType0x28$FollowList.uint64_puin.get());
                int i3 = subMsgType0x28$FollowList.uint32_type.get();
                if (i3 == 1) {
                    getUserFollowList();
                    z17 = true;
                } else if (i3 == 2 || i3 == 3) {
                    IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
                    iPublicAccountDataManager.delPublicAccountInfo(valueOf);
                    iPublicAccountDataManager.delAccountDetailInfoCache(valueOf);
                    aVar = new IPublicAccountObserver.a();
                    aVar.f79351a = iPublicAccountDataManager.getAccountInfo(parseLong + "");
                    if (subMsgType0x28$FollowList.uint32_disable_cancel_chat.get() != 1) {
                        this.app.getMessageFacade().q(valueOf, 1008);
                    }
                    TroopBarAssistantManager.n().D(this.app, (List) iPublicAccountDataManager.getPublicAccountEqqInfoList());
                    z16 = true;
                }
            }
        }
        if (z16) {
            notifyUI(103, true, null);
            notifyUI(102, true, aVar);
        }
        if (z17) {
            notifyUI(101, true, null);
        }
    }

    private void handleSubscribeStatusGet(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        mobileqq_mp$GetMessageConfigurationResponse mobileqq_mp_getmessageconfigurationresponse = new mobileqq_mp$GetMessageConfigurationResponse();
        long longExtra = intent.getLongExtra("uin", 0L);
        QLog.d(TAG, 1, "handleSubscribesStatusResp, uin : " + longExtra);
        try {
            if (obj != null) {
                mobileqq_mp_getmessageconfigurationresponse.mergeFrom((byte[]) obj);
                if (mobileqq_mp_getmessageconfigurationresponse.ret_info.has() && mobileqq_mp_getmessageconfigurationresponse.ret_info.ret_code.has()) {
                    int i3 = mobileqq_mp_getmessageconfigurationresponse.ret_info.ret_code.get();
                    if (i3 == 0) {
                        if (mobileqq_mp_getmessageconfigurationresponse.type.has()) {
                            int i16 = mobileqq_mp_getmessageconfigurationresponse.type.get();
                            HashMap hashMap = new HashMap();
                            hashMap.put("uin", Long.valueOf(longExtra));
                            hashMap.put("status", Integer.valueOf(i16));
                            notifyUI(111, true, hashMap);
                            QLog.d(TAG, 1, "result:" + i16);
                            return;
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "request Kandian status fail code:" + i3);
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "request Kandian status wrong resp");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "request Kandian status fail data null");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        notifyUI(111, false, null);
    }

    private void saveAttachInfoForNewProtocol(String str) {
        SharedPreferences.Editor edit = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
        edit.putString(PREF_KEY_GET_FOLLOW_LIST_NEW_PROTOCOL_ATTACH_INFO, str);
        edit.commit();
    }

    private void saveCurFollowSeq(long j3, boolean z16) {
        String str;
        SharedPreferences.Editor edit = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
        if (z16) {
            str = NEW_PROTOCOL_INDEX_FOLLOW_SEQ;
        } else {
            str = INDEX_FOLLOW_SEQ;
        }
        edit.putLong(str, j3);
        edit.commit();
    }

    private void setCurDataSeq(long j3, boolean z16) {
        String str;
        SharedPreferences.Editor edit = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
        if (z16) {
            str = NEW_PROTOCOL_INDEX_DATA_SEQ;
        } else {
            str = INDEX_DATA_SEQ;
        }
        edit.putLong(str, j3);
        edit.commit();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void clearPublicAccountSeq() {
        QLog.d(TAG, 1, "clearPublicAccountSeq");
        setCurDataSeq(0L, true);
        setCurDataSeq(0L, false);
        saveCurFollowSeq(0L, true);
        saveCurFollowSeq(0L, false);
        saveAttachInfoForNewProtocol("");
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void clearWeatherInfoListener() {
        Map<Integer, IPublicAccountHandler.a> map = this.mWeatherInfos;
        if (map != null) {
            map.clear();
        }
    }

    public void getAIOHistoryMsg(String str, long j3, int i3, BusinessObserver businessObserver) {
        NewIntent newIntent = new NewIntent(this.app.getApp(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_PULL_AIO_HISTORY_MSG);
        historyMsg$AioHistoryMsgRequest historymsg_aiohistorymsgrequest = new historyMsg$AioHistoryMsgRequest();
        historymsg_aiohistorymsgrequest.puin.set(Long.parseLong(str));
        historymsg_aiohistorymsgrequest.msg_id.set(j3);
        historymsg_aiohistorymsgrequest.msg_cnt.set(i3);
        newIntent.putExtra("data", historymsg_aiohistorymsgrequest.toByteArray());
        if (businessObserver != null) {
            newIntent.setObserver(businessObserver);
        } else {
            ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).configNeedHandler(newIntent);
        }
        this.app.startServlet(newIntent);
        ReportController.o(this.app, "CliOper", "", "", "0X8006502", "0X8006502", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public int getRecommendList(Object obj) {
        SosoLocation sosoLocation;
        String str;
        SosoLbsInfo sosoLbsInfo = (SosoLbsInfo) obj;
        NewIntent newIntent = new NewIntent(this.app.getApp(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_RECOMMEND_LIST);
        publicaccount_recommend$BusinessRecommendRequest publicaccount_recommend_businessrecommendrequest = new publicaccount_recommend$BusinessRecommendRequest();
        publicaccount_recommend_businessrecommendrequest.recomend_count.set(20);
        if (sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
            if (sosoLocation == null || (str = sosoLocation.address) == null) {
                str = "";
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getRecommendList() latitude=" + sosoLbsInfo.mLocation.mLat02 + " longitude=" + sosoLbsInfo.mLocation.mLon02 + ", address=" + str);
            }
            publicaccount_recommend_businessrecommendrequest.latitude.set(String.valueOf(sosoLbsInfo.mLocation.mLat02));
            publicaccount_recommend_businessrecommendrequest.longitude.set(String.valueOf(sosoLbsInfo.mLocation.mLon02));
            publicaccount_recommend_businessrecommendrequest.city_info.set(str);
        }
        publicaccount_recommend_businessrecommendrequest.platform.set(109);
        newIntent.putExtra("data", publicaccount_recommend_businessrecommendrequest.toByteArray());
        ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).configNeedHandler(newIntent);
        this.app.startServlet(newIntent);
        return 0;
    }

    public boolean getSearchSwitch() {
        return this.mSearchSwitch;
    }

    public boolean getTotalSwitch() {
        return this.mTotalSwitch;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public int getUserFollowList() {
        return getUserFollowList(false, 0);
    }

    public void handleAIOHistoryMsg(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = fromServiceMsg.isSuccess() && obj != null;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleAIOHistoryMsg onReceive :" + z16);
        }
        if (z16) {
            try {
                historyMsg$AioHistoryMsgResponse historymsg_aiohistorymsgresponse = new historyMsg$AioHistoryMsgResponse();
                historymsg_aiohistorymsgresponse.mergeFrom((byte[]) obj);
                int i3 = historymsg_aiohistorymsgresponse.ret_info.ret_code.get();
                boolean z17 = i3 == 0;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "result: " + i3);
                }
                notifyUI(105, true, Integer.valueOf(!historymsg_aiohistorymsgresponse.msg_infos.has() ? 2 : 0));
                if (z17 && historymsg_aiohistorymsgresponse.msg_infos.has() && historymsg_aiohistorymsgresponse.puin.has()) {
                    long j3 = historymsg_aiohistorymsgresponse.puin.get();
                    ArrayList arrayList = new ArrayList();
                    List<ByteStringMicro> list = historymsg_aiohistorymsgresponse.msg_infos.get();
                    int size = list == null ? 0 : list.size();
                    if (size <= 0) {
                        return;
                    }
                    for (int i16 = 0; i16 < size; i16++) {
                        byte[] byteArray = list.get(i16).toByteArray();
                        msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
                        msg_comm_msg.mergeFrom(PluginBaseInfoHelper.Base64Helper.decode(byteArray, 0));
                        arrayList.add(msg_comm_msg);
                    }
                    if (arrayList.size() == 0) {
                        return;
                    }
                    this.loadAioHistroyMsg = true;
                    this.loadHistoryMsgUin = j3;
                    IPublicAccountDynamicMsgProcessor iPublicAccountDynamicMsgProcessor = (IPublicAccountDynamicMsgProcessor) QRoute.api(IPublicAccountDynamicMsgProcessor.class);
                    QQAppInterface qQAppInterface = this.app;
                    iPublicAccountDynamicMsgProcessor.init(qQAppInterface, qQAppInterface.getMsgHandler()).processHistoryMsg(j3, arrayList);
                    return;
                }
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "handleGetRecommendList onReceive fail: ", e16);
                    return;
                }
                return;
            }
        }
        notifyUI(105, true, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void handleGetGuideFriends(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        boolean z16 = (!fromServiceMsg.isSuccess() || obj == null) ? 0 : 1;
        if (z16 != 0) {
            SSOBiuGuide$RspBody sSOBiuGuide$RspBody = new SSOBiuGuide$RspBody();
            try {
                sSOBiuGuide$RspBody.mergeFrom((byte[]) obj);
                if (sSOBiuGuide$RspBody.ret_info.has()) {
                    int i16 = sSOBiuGuide$RspBody.ret_info.ret_code.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "handleGetGuideFriends ret:", Integer.valueOf(i16));
                    }
                    if (i16 == 0) {
                        try {
                            if (!sSOBiuGuide$RspBody.rpt_msg_uin_info.isEmpty()) {
                                while (i3 < sSOBiuGuide$RspBody.rpt_msg_uin_info.size()) {
                                    arrayList.add(Long.valueOf(sSOBiuGuide$RspBody.rpt_msg_uin_info.get(i3).uint64_uin.get()));
                                    i3++;
                                }
                            }
                            i3 = 1;
                        } catch (Exception e16) {
                            e = e16;
                            i3 = 1;
                            QLog.d(TAG, 1, "handleGetGuideFriends fail:", e);
                            z16 = i3;
                            notifyUI(110, z16, arrayList);
                        }
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
            z16 = i3;
        }
        notifyUI(110, z16, arrayList);
    }

    public void handleGetRecvMsgState(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return;
        }
        long longExtra = intent.getLongExtra("uin", 0L);
        QLog.d(TAG, 1, "handleGetRecvMsgState, uin = " + longExtra + ",resp.isSuccess() = " + fromServiceMsg.isSuccess());
        if (fromServiceMsg.isSuccess()) {
            try {
                Object decodePacket = Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new GetRecvMsgStateRsp());
                if (decodePacket instanceof GetRecvMsgStateRsp) {
                    GetRecvMsgStateRsp getRecvMsgStateRsp = (GetRecvMsgStateRsp) decodePacket;
                    this.app.getApp().getSharedPreferences(PREF_KEY_SETTING_STATUS_PREFIX, 0).edit().putInt(KEY_SETTING_RESULT_PRE + longExtra + "_" + this.app.getCurrentAccountUin(), getRecvMsgStateRsp.result).putInt(KEY_SETTING_STATUS_PRE + longExtra + "_" + this.app.getCurrentAccountUin(), getRecvMsgStateRsp.state).commit();
                    MqqHandler handler = this.app.getHandler(AccountDetailGroupListContainer.class);
                    if (handler != null) {
                        handler.sendEmptyMessage(1000);
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public void handleKandianSubscribe(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16 = false;
        boolean z17 = fromServiceMsg.isSuccess() && obj != null;
        int intExtra = intent.getIntExtra("kandian_seq", 0);
        long longExtra = intent.getLongExtra("uin", 0L);
        if (z17) {
            mobileqq_mp$SetMessageConfigurationResponse mobileqq_mp_setmessageconfigurationresponse = new mobileqq_mp$SetMessageConfigurationResponse();
            try {
                mobileqq_mp_setmessageconfigurationresponse.mergeFrom((byte[]) obj);
                if (mobileqq_mp_setmessageconfigurationresponse.ret_info.has() && mobileqq_mp_setmessageconfigurationresponse.ret_info.ret_code.has()) {
                    int i3 = mobileqq_mp_setmessageconfigurationresponse.ret_info.ret_code.get();
                    if (i3 == 0) {
                        z16 = true;
                    } else {
                        QLog.d(TAG, 1, "handleKandianSubscribe fail code:" + i3);
                    }
                }
            } catch (Exception e16) {
                QLog.d(TAG, 1, "handleKandianSubscribe fail:", e16);
            }
        } else {
            z16 = z17;
        }
        QLog.d(TAG, 1, "handleSetKandianSubscribeStatusRsp: " + longExtra + ", seq : " + intExtra);
        HashMap hashMap = new HashMap();
        hashMap.put("uin", Long.valueOf(longExtra));
        hashMap.put("seq", Integer.valueOf(intExtra));
        notifyUI(108, z16, hashMap);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public boolean hasStepRequestFollowList() {
        return this.mHasStepRequestFollowList;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public boolean isNeedUpdate() {
        return this.mIsNeedUpdate;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public Object newPublicAccountCheckUpdateItem() {
        return new b();
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends com.tencent.mobileqq.app.BusinessObserver> observerClass() {
        return PublicAccountObserverImpl.class;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void onFollowPublicAccount(Object obj) {
        IPublicAccountObserver.a aVar = new IPublicAccountObserver.a();
        aVar.f79352b = 0;
        long uptimeMillis = SystemClock.uptimeMillis();
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        boolean z16 = obj instanceof PublicAccountDetailImpl;
        if (z16) {
            aVar.f79351a = PublicAccountInfo.createPublicAccount((IPublicAccountDetail) obj, uptimeMillis);
            PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) obj;
            iPublicAccountDataManager.saveAccountDetailInfoCache(publicAccountDetailImpl);
            if (publicAccountDetailImpl.followType == 1) {
                iPublicAccountDataManager.savePublicAccountInfo((PublicAccountInfo) aVar.f79351a);
            }
        } else if (obj instanceof EqqDetail) {
            aVar.f79351a = PublicAccountInfo.createPublicAccount((EqqDetail) obj, uptimeMillis);
        }
        if (!z16) {
            iPublicAccountDataManager.savePublicAccountInfo((PublicAccountInfo) aVar.f79351a);
        }
        TroopBarAssistantManager.n().D(this.app, (List) iPublicAccountDataManager.getPublicAccountEqqInfoList());
        notifyUI(101, true, aVar);
    }

    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg, Object obj) {
        String stringExtra = intent.getStringExtra("cmd");
        byte[] bArr = (byte[]) obj;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<<---onReceive " + stringExtra);
        }
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_GET_FOLLOW_LIST)) {
            handleGetUserFollowList(intent, fromServiceMsg, bArr, false);
            return;
        }
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_GET_FOLLOW_LIST_NEW)) {
            handleGetUserFollowList(intent, fromServiceMsg, bArr, true);
            return;
        }
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_SEC_MSG_CONFIGS)) {
            return;
        }
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_GET_RECOMMEND_LIST)) {
            handleGetRecommendList(intent, fromServiceMsg, bArr);
            return;
        }
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_PRE_SEND_MSG_INFO)) {
            handlePreSendMsg(intent, fromServiceMsg, bArr);
            return;
        }
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_PULL_AIO_HISTORY_MSG)) {
            handleAIOHistoryMsg(intent, fromServiceMsg, obj);
            return;
        }
        if (stringExtra.equals(IPublicAccountManager.SSO_COMMAND_ACCOUNT_DETAIL_DYNAMIC_LIST)) {
            return;
        }
        if (stringExtra.equals(IPublicAccountConfigUtil.SSO_COMMOND_NET_CONNECT_INFO)) {
            PublicAccountWebReport.handlereportPublicAccountNetInfoResponse(intent, fromServiceMsg, obj);
            return;
        }
        if (TextUtils.equals(stringExtra, IPublicAccountManager.SSO_COMMAND_SEND_SET_SUBSCRIBE)) {
            handleKandianSubscribe(intent, fromServiceMsg, obj);
            return;
        }
        if (TextUtils.equals(stringExtra, IPublicAccountManager.SSO_COMMAND_GET_GUIDE_FRIENDS)) {
            handleGetGuideFriends(intent, fromServiceMsg, obj);
            return;
        }
        if (TextUtils.equals(stringExtra, IPublicAccountManager.SSO_COMMAND_SEND_GET_SUBSCRIBE)) {
            handleSubscribeStatusGet(intent, fromServiceMsg, obj);
        } else if (TextUtils.equals(stringExtra, IPublicAccountManager.CMD_GET_RECVMSG_STATE)) {
            handleGetRecvMsgState(intent, fromServiceMsg);
        } else if (TextUtils.equals(stringExtra, IPublicAccountManager.CMD_SET_RECVMSG_STATE)) {
            handleSetRecvMsgState(fromServiceMsg);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void onReceivePushMessage(long j3, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<<---onReceivePushMessage subMsgTye = " + Integer.toHexString((int) j3));
        }
        if (((int) j3) == 40) {
            try {
                SubMsgType0x28$MsgBody mergeFrom = new SubMsgType0x28$MsgBody().mergeFrom(bArr);
                int i3 = mergeFrom.uint32_sub_cmd.get();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "<<---onReceivePushMessage subCmd = " + i3);
                }
                if (i3 == 1) {
                    handlePushMessageFollowList(mergeFrom.msg_rsp_followlist.get());
                } else if (i3 != 2) {
                } else {
                    handlePushMessageTypeList(mergeFrom.msg_rsp_typelist.get());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void onUnfollowPublicAccount(Object obj) {
        z zVar;
        IPublicAccountObserver.a aVar = new IPublicAccountObserver.a();
        aVar.f79352b = 0;
        long uptimeMillis = SystemClock.uptimeMillis();
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (obj instanceof PublicAccountDetailImpl) {
            PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) obj;
            aVar.f79351a = PublicAccountInfo.createPublicAccount(publicAccountDetailImpl, uptimeMillis);
            iPublicAccountDataManager.delAccountDetailInfoCache(publicAccountDetailImpl.uin);
        } else if (obj instanceof EqqDetail) {
            aVar.f79351a = PublicAccountInfo.createPublicAccount((EqqDetail) obj, uptimeMillis);
        }
        iPublicAccountDataManager.delPublicAccountInfo(((PublicAccountInfo) aVar.f79351a).getUin());
        if ((obj instanceof EqqDetail) && (zVar = (z) this.app.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)) != null) {
            zVar.a((EqqDetail) obj);
        }
        TroopBarAssistantManager.n().D(this.app, (List) iPublicAccountDataManager.getPublicAccountEqqInfoList());
        notifyUI(102, true, aVar);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void reportClickPublicAccountEvent(AppInterface appInterface, String str, String str2, String str3, String str4) {
        reportClickPublicAccountEventInner(appInterface, str, str2, str3, str4);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void sendLBSInfo(String str, double d16, double d17, String str2) {
        try {
            long longValue = Long.valueOf(str).longValue();
            mobileqq_mp$SendLBSInfoRequest mobileqq_mp_sendlbsinforequest = new mobileqq_mp$SendLBSInfoRequest();
            mobileqq_mp_sendlbsinforequest.luin.set(longValue);
            mobileqq_mp_sendlbsinforequest.latitude.set(d16);
            mobileqq_mp_sendlbsinforequest.longitude.set(d17);
            mobileqq_mp_sendlbsinforequest.cityinfo.set(str2);
            ToServiceMsg createToServiceMsg = createToServiceMsg("PubAccountSvc.ReportLbs");
            createToServiceMsg.putWupBuffer(mobileqq_mp_sendlbsinforequest.toByteArray());
            sendPbReq(createToServiceMsg);
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void sendLocRequest(int i3, int i16, int i17, int i18) {
        QQAppInterface qQAppInterface = this.app;
        if ((qQAppInterface == null || qQAppInterface.isBackgroundStop) ? false : true) {
            ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).startLocation(new a("qq_weather", false, i3, i16, i17, i18));
        } else {
            sendWeatherLocRequest(i3, i16, i17, i18, ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("qq_weather"));
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void setLocalIp(String str) {
        sLocalIp = str;
    }

    public static void reportClickPublicAccountEventInner(AppInterface appInterface, String str, String str2, String str3, String str4) {
        ReportController.o(appInterface instanceof QQAppInterface ? (QQAppInterface) appInterface : null, "P_CliOper", str2, "", str3, str4, 0, 0, str, "", "", "");
    }

    private void savePublicAccountInfos(List<PublicAccountInfo> list, long j3, boolean z16, boolean z17, boolean z18, int i3) {
        List list2 = (List) ((IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all")).savePublicAccountInfos(list, j3, z16, z17, z18, i3);
        ProxyManager proxyManager = this.app.getProxyManager();
        Iterator it = list2.iterator();
        boolean z19 = false;
        while (it.hasNext()) {
            RecentUser findRecentUser = proxyManager.m().findRecentUser(((PublicAccountInfo) it.next()).getUin(), 1008);
            if (findRecentUser != null) {
                proxyManager.m().delRecentUser(findRecentUser);
                z19 = true;
            }
        }
        MqqHandler handler = this.app.getHandler(Conversation.class);
        if (!z19 || handler == null) {
            return;
        }
        handler.sendEmptyMessage(1009);
    }

    public int getUserFollowList(boolean z16, int i3) {
        boolean isGetFollowListUseNewProtocol = PublicAccountConfigUtilImpl.isGetFollowListUseNewProtocol();
        long preFollowSeq = getPreFollowSeq(isGetFollowListUseNewProtocol);
        long preDataSeq = getPreDataSeq(isGetFollowListUseNewProtocol);
        String preAttachInfoForNewProtocol = getPreAttachInfoForNewProtocol();
        long uptimeMillis = SystemClock.uptimeMillis();
        if (i3 == 1) {
            this.mHasStepRequestFollowList = true;
        }
        return getUserFollowList(preFollowSeq, preDataSeq, 0L, 20L, uptimeMillis, true, isGetFollowListUseNewProtocol, preAttachInfoForNewProtocol, z16, i3);
    }

    public void handlePreSendMsg(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        if (intent != null && fromServiceMsg != null && fromServiceMsg.isSuccess() && bArr != null) {
            try {
                mobileqq_mp$SendPreMessageStatusResponse mobileqq_mp_sendpremessagestatusresponse = new mobileqq_mp$SendPreMessageStatusResponse();
                mobileqq_mp_sendpremessagestatusresponse.mergeFrom(bArr);
                int i3 = (mobileqq_mp_sendpremessagestatusresponse.ret_info.has() && mobileqq_mp_sendpremessagestatusresponse.ret_info.get().ret_code.has()) ? mobileqq_mp_sendpremessagestatusresponse.ret_info.get().ret_code.get() : -1;
                if (i3 != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handlePreSendMsg error, errcode: " + i3);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handlePreSendMsg success: package size is " + bArr.length + " Byte");
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handlePreSendMsg  failed!");
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void reportClickPublicAccountEvent(AppInterface appInterface, String str, String str2, String str3, String str4, int i3) {
        ReportController.o(appInterface instanceof QQAppInterface ? (QQAppInterface) appInterface : null, "P_CliOper", str2, "", str3, str4, i3, 0, str, "", "", "");
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void setNotNeedUpdate() {
        this.mIsNeedUpdate = false;
    }

    private void handleGetUserFollowListNeedNotify(IPublicAccountObserver.b bVar, boolean z16, boolean z17, int i3) {
        if (z16) {
            notifyUI(i3, z17, bVar);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void getWeatherInfo(Context context, final int i3, IPublicAccountHandler.a aVar) {
        if (aVar != null) {
            this.mWeatherInfos.put(Integer.valueOf(i3), aVar);
        }
        if (i3 == 1) {
            sendLocRequest(i3, 0, 0, 0);
            return;
        }
        if (i3 == 2) {
            final AppActivity appActivity = (AppActivity) context;
            if (appActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
                QQPermissionFactory.getQQPermission(appActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_PUBLIC_ACCOUNT, QQPermissionConstants.Business.SCENE.GET_WEATHER_INFO)).requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 2, new QQPermission.BasePermissionsListener() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.1
                    @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                    public void onAllGranted() {
                        super.onAllGranted();
                        QLog.d(PublicAccountHandlerImpl.TAG, 1, "User requestPermissions grant...");
                        PublicAccountHandlerImpl.this.getWeatherLBSInfo(i3);
                    }

                    @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
                    public void onDenied(List<String> list, List<Integer> list2) {
                        super.onDenied(list, list2);
                        QLog.d(PublicAccountHandlerImpl.TAG, 1, "User requestPermissions denied...");
                        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                PublicAccountHandlerImpl.this.sendLocRequest(i3, 0, 0, 0);
                            }
                        });
                        String[] strArr = new String[list.size()];
                        int[] iArr = new int[list2.size()];
                        for (int i16 = 0; i16 < list.size(); i16++) {
                            strArr[i16] = list.get(i16);
                        }
                        for (int i17 = 0; i17 < list2.size(); i17++) {
                            iArr[i17] = list2.get(i17).intValue();
                        }
                        DialogUtil.showPermissionSettingDialog2(appActivity, strArr, iArr);
                    }
                });
            } else {
                getWeatherLBSInfo(i3);
            }
        }
    }

    private boolean handleGetUserFollowListResendMsg(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null || fromServiceMsg.getResultCode() != 2901 || intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra(AppConstants.KEY_RESEND_COUNT, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleGetUserFollowListk_resend_cnt" + intExtra);
        }
        if (intExtra >= 2) {
            return false;
        }
        intent.putExtra(AppConstants.KEY_RESEND_COUNT, intExtra + 1);
        this.app.startServlet((NewIntent) intent);
        return true;
    }

    public void handleSetRecvMsgState(FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleSetRecvMsgState resp.isSuccess() = " + fromServiceMsg.isSuccess());
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (isSuccess) {
            try {
                notifyUI(112, isSuccess, Packet.decodePacket(fromServiceMsg.getWupBuffer(), "rsp", new SetRecvMsgStateRsp()));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    private boolean handleGetUserFollowListIsResSuccess(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        return (intent == null || fromServiceMsg == null || !fromServiceMsg.isSuccess() || bArr == null) ? false : true;
    }

    public static void reportClickPublicAccountEvent(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        ReportController.o(appInterface instanceof QQAppInterface ? (QQAppInterface) appInterface : null, "P_CliOper", str2, "", str3, str4, 0, 0, str, str5, str6, "");
    }

    public void onGetPublicAccount() {
        notifyUI(103, true, null);
    }

    PublicAccountHandlerImpl(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        this.lbsUinList = null;
        this.mWeatherInfos = new HashMap();
        this.loadAioHistroyMsg = false;
        this.loadHistoryMsgUin = 0L;
        this.mHasStepRequestFollowList = false;
        this.app = qQAppInterface;
        this.mIsNeedUpdate = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(21:2|3|4|(18:8|9|10|(1:12)|13|14|15|(1:17)(2:74|(1:76)(1:77))|18|(1:20)|21|22|(4:49|50|(4:53|(2:54|(2:56|(1:66)(3:61|62|63))(0))|64|51)|69)|24|25|(6:34|35|36|(3:38|39|40)|45|44)(1:27)|28|(2:30|31)(1:33))|85|10|(0)|13|14|15|(0)(0)|18|(0)|21|22|(0)|24|25|(0)(0)|28|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00d8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00d9, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009f A[Catch: JSONException -> 0x00d8, TryCatch #3 {JSONException -> 0x00d8, blocks: (B:15:0x0098, B:17:0x009f, B:18:0x00b9, B:21:0x00d4, B:76:0x00a8, B:77:0x00ae), top: B:14:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sendWeatherLocRequest(int i3, int i16, int i17, int i18, SosoLbsInfo sosoLbsInfo) {
        int i19;
        String str;
        String str2;
        int i26;
        String jSONObject;
        SosoLocation sosoLocation;
        String currentAccountUin = this.app.getCurrentAccountUin();
        try {
            long parseLong = Long.parseLong(currentAccountUin);
            if (sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                try {
                    i19 = Integer.parseInt(sosoLocation.cityCode);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, th5, new Object[0]);
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "LocalInfo" + i19);
                }
                String str3 = AppSetting.f99551k;
                str = "";
                String replaceAll = str3.replaceAll("\\.", "");
                WeatherReportInfo$PbReqMsgHead weatherReportInfo$PbReqMsgHead = new WeatherReportInfo$PbReqMsgHead();
                weatherReportInfo$PbReqMsgHead.uint32_platform_type.set(1);
                weatherReportInfo$PbReqMsgHead.uint32_version.set(Integer.parseInt(replaceAll));
                WeatherReportInfo$GetWeatherMessageReq weatherReportInfo$GetWeatherMessageReq = new WeatherReportInfo$GetWeatherMessageReq();
                weatherReportInfo$GetWeatherMessageReq.pbReqMsgHead.set(weatherReportInfo$PbReqMsgHead);
                weatherReportInfo$GetWeatherMessageReq.uin.set(parseLong);
                weatherReportInfo$GetWeatherMessageReq.lat.set(i16);
                weatherReportInfo$GetWeatherMessageReq.lng.set(i17);
                weatherReportInfo$GetWeatherMessageReq.fore_flag.set(0);
                weatherReportInfo$GetWeatherMessageReq.area_id.set(i18);
                weatherReportInfo$GetWeatherMessageReq.adcode_from_mapsdk.set(i19);
                JSONObject jSONObject2 = new JSONObject();
                if (i3 != 0) {
                    weatherReportInfo$GetWeatherMessageReq.source.set(2);
                } else if (i3 == -1) {
                    weatherReportInfo$GetWeatherMessageReq.source.set(1);
                } else {
                    jSONObject2.put("cmd", i3);
                    weatherReportInfo$GetWeatherMessageReq.source.set(0);
                }
                jSONObject2.put("platform", 109);
                jSONObject2.put("version", str3);
                jSONObject = jSONObject2.toString();
                PBStringField pBStringField = weatherReportInfo$GetWeatherMessageReq.extra;
                if (TextUtils.isEmpty(jSONObject)) {
                    jSONObject = "";
                }
                pBStringField.set(jSONObject);
                str2 = sLocalIp;
                if (TextUtils.isEmpty(str2)) {
                    try {
                        Enumeration<NetworkInterface> networkInterfaces = NetworkMonitor.getNetworkInterfaces();
                        while (networkInterfaces.hasMoreElements()) {
                            Enumeration<InetAddress> inetAddresses = NetworkMonitor.getInetAddresses(networkInterfaces.nextElement());
                            while (true) {
                                if (inetAddresses.hasMoreElements()) {
                                    InetAddress nextElement = inetAddresses.nextElement();
                                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                                        str2 = nextElement.getHostAddress().toString();
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                str = str2;
                if (TextUtils.isEmpty(str)) {
                    try {
                        i26 = 0;
                        for (String str4 : str.split(Pattern.quote("."))) {
                            try {
                                i26 <<= 8;
                                i26 |= Integer.parseInt(str4);
                            } catch (Exception e17) {
                                e = e17;
                                e.printStackTrace();
                                sLocalIp = str;
                                weatherReportInfo$GetWeatherMessageReq.f116934ip.set(i26);
                                ToServiceMsg createToServiceMsg = createToServiceMsg(CMD_PUBLICACCOUNT_WEATHER_INFO);
                                createToServiceMsg.putWupBuffer(weatherReportInfo$GetWeatherMessageReq.toByteArray());
                                sendPbReq(createToServiceMsg);
                                if (QLog.isColorLevel()) {
                                }
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                        i26 = 0;
                    }
                    sLocalIp = str;
                } else {
                    i26 = 0;
                }
                weatherReportInfo$GetWeatherMessageReq.f116934ip.set(i26);
                ToServiceMsg createToServiceMsg2 = createToServiceMsg(CMD_PUBLICACCOUNT_WEATHER_INFO);
                createToServiceMsg2.putWupBuffer(weatherReportInfo$GetWeatherMessageReq.toByteArray());
                sendPbReq(createToServiceMsg2);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, String.format("send tianqi lat=%d, lng=%d, type=%d, areaid = %d", Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i3), Integer.valueOf(i18)));
                    return;
                }
                return;
            }
            i19 = 0;
            if (QLog.isColorLevel()) {
            }
            String str32 = AppSetting.f99551k;
            str = "";
            String replaceAll2 = str32.replaceAll("\\.", "");
            WeatherReportInfo$PbReqMsgHead weatherReportInfo$PbReqMsgHead2 = new WeatherReportInfo$PbReqMsgHead();
            weatherReportInfo$PbReqMsgHead2.uint32_platform_type.set(1);
            weatherReportInfo$PbReqMsgHead2.uint32_version.set(Integer.parseInt(replaceAll2));
            WeatherReportInfo$GetWeatherMessageReq weatherReportInfo$GetWeatherMessageReq2 = new WeatherReportInfo$GetWeatherMessageReq();
            weatherReportInfo$GetWeatherMessageReq2.pbReqMsgHead.set(weatherReportInfo$PbReqMsgHead2);
            weatherReportInfo$GetWeatherMessageReq2.uin.set(parseLong);
            weatherReportInfo$GetWeatherMessageReq2.lat.set(i16);
            weatherReportInfo$GetWeatherMessageReq2.lng.set(i17);
            weatherReportInfo$GetWeatherMessageReq2.fore_flag.set(0);
            weatherReportInfo$GetWeatherMessageReq2.area_id.set(i18);
            weatherReportInfo$GetWeatherMessageReq2.adcode_from_mapsdk.set(i19);
            JSONObject jSONObject22 = new JSONObject();
            if (i3 != 0) {
            }
            jSONObject22.put("platform", 109);
            jSONObject22.put("version", str32);
            jSONObject = jSONObject22.toString();
            PBStringField pBStringField2 = weatherReportInfo$GetWeatherMessageReq2.extra;
            if (TextUtils.isEmpty(jSONObject)) {
            }
            pBStringField2.set(jSONObject);
            str2 = sLocalIp;
            if (TextUtils.isEmpty(str2)) {
            }
            str = str2;
            if (TextUtils.isEmpty(str)) {
            }
            weatherReportInfo$GetWeatherMessageReq2.f116934ip.set(i26);
            ToServiceMsg createToServiceMsg22 = createToServiceMsg(CMD_PUBLICACCOUNT_WEATHER_INFO);
            createToServiceMsg22.putWupBuffer(weatherReportInfo$GetWeatherMessageReq2.toByteArray());
            sendPbReq(createToServiceMsg22);
            if (QLog.isColorLevel()) {
            }
        } catch (Exception e19) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("can't get uin, parse uin failed uin: ");
            sb5.append(currentAccountUin);
            sb5.append(" uinIsNull: ");
            sb5.append(currentAccountUin == null);
            QLog.e(TAG, 1, sb5.toString(), e19);
        }
    }

    private void handleGetRecommendList(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        if (intent != null && fromServiceMsg != null && fromServiceMsg.isSuccess() && bArr != null) {
            try {
                publicaccount_recommend$BusinessRecommendResponse publicaccount_recommend_businessrecommendresponse = new publicaccount_recommend$BusinessRecommendResponse();
                publicaccount_recommend_businessrecommendresponse.mergeFrom(bArr);
                if (((publicaccount_recommend_businessrecommendresponse.ret_info.has() && publicaccount_recommend_businessrecommendresponse.ret_info.get().ret_code.has()) ? publicaccount_recommend_businessrecommendresponse.ret_info.get().ret_code.get() : -1) != 0) {
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleGetRecommendList(): package size is " + bArr.length + " Byte");
                }
                if (publicaccount_recommend_businessrecommendresponse.business.has()) {
                    ((IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all")).refreshPublicRecommendList(PublicRecommendAccountInfo.createPublicRecommendAccountInfoList(publicaccount_recommend_businessrecommendresponse.business.get()));
                    notifyUI(104, true, null);
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        notifyUI(104, false, null);
    }

    private int getUserFollowList(long j3, long j16, long j17, long j18, long j19, boolean z16, boolean z17, String str, boolean z18, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getUserFollowList() isNewProtocol: " + z17 + "   followSeqNo: " + j3 + "   publicAccountSeqNo: " + j16 + " isNewSeqLogic: " + z18);
        }
        if (z17) {
            NewIntent newIntent = new NewIntent(this.app.getApp(), ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountStQWebServlet.class));
            newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_FOLLOW_LIST_NEW);
            CertifiedAccountRead$StGetFollowListReq certifiedAccountRead$StGetFollowListReq = new CertifiedAccountRead$StGetFollowListReq();
            certifiedAccountRead$StGetFollowListReq.seq.set(Utils.O(j3));
            certifiedAccountRead$StGetFollowListReq.count.set(Utils.O(j18));
            if (!TextUtils.isEmpty(str)) {
                certifiedAccountRead$StGetFollowListReq.attach_info.set(str);
            }
            if (z18) {
                COMM.Entry entry = new COMM.Entry();
                entry.key.set("inc");
                entry.value.set("1");
                certifiedAccountRead$StGetFollowListReq.extInfo.setHasFlag(true);
                certifiedAccountRead$StGetFollowListReq.extInfo.mapInfo.add(entry);
            }
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(-1L);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(certifiedAccountRead$StGetFollowListReq.toByteArray()));
            String traceId = ze0.a.getTraceId();
            if (!TextUtils.isEmpty(traceId)) {
                stQWebReq.traceid.set(traceId);
            }
            byte[] byteArray = stQWebReq.toByteArray();
            if (byteArray == null) {
                byteArray = new byte[4];
            }
            newIntent.putExtra("traceid", traceId);
            newIntent.putExtra("data", byteArray);
            newIntent.putExtra(ARG_GET_FOLLOW_LIST_BEGIN, j17);
            newIntent.putExtra(ARG_GET_FOLLOW_LIST_FOLLOW_SEQ, j3);
            newIntent.putExtra(ARG_GET_FOLLOW_LIST_DATA_SEQ, j16);
            newIntent.putExtra(ARG_TIME_STAMP, j19);
            newIntent.putExtra(ARG_GET_FOLLOW_LIST_IS_INCREMENT, z16);
            newIntent.putExtra(ARG_GET_FOLLOW_LIST_IS_NEW_SEQ_LOGIC, z18);
            newIntent.putExtra(ARG_GET_FOLLOW_LIST_FROM_SRC, i3);
            ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).configNeedHandler(newIntent);
            this.app.startServlet(newIntent);
            return 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getUserFollowList");
        }
        NewIntent newIntent2 = new NewIntent(this.app.getApp(), PublicAccountServletImpl.class);
        newIntent2.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_FOLLOW_LIST);
        mobileqq_mp$GetUserFollowListRequest mobileqq_mp_getuserfollowlistrequest = new mobileqq_mp$GetUserFollowListRequest();
        mobileqq_mp_getuserfollowlistrequest.follow_seqno.set(Utils.O(j3));
        mobileqq_mp_getuserfollowlistrequest.public_account_seqno.set(Utils.O(j16));
        mobileqq_mp_getuserfollowlistrequest.begin.set(Utils.O(j17));
        mobileqq_mp_getuserfollowlistrequest.limit.set(Utils.O(j18));
        mobileqq_mp_getuserfollowlistrequest.version.set(1);
        mobileqq_mp_getuserfollowlistrequest.is_increment.set(z16);
        newIntent2.putExtra("data", mobileqq_mp_getuserfollowlistrequest.toByteArray());
        newIntent2.putExtra(ARG_GET_FOLLOW_LIST_BEGIN, j17);
        newIntent2.putExtra(ARG_GET_FOLLOW_LIST_FOLLOW_SEQ, j3);
        newIntent2.putExtra(ARG_GET_FOLLOW_LIST_DATA_SEQ, j16);
        newIntent2.putExtra(ARG_TIME_STAMP, j19);
        newIntent2.putExtra(ARG_GET_FOLLOW_LIST_IS_INCREMENT, z16);
        ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).configNeedHandler(newIntent2);
        this.app.startServlet(newIntent2);
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x01b4: MOVE (r0 I:??[OBJECT, ARRAY]) = (r28 I:??[OBJECT, ARRAY]), block:B:90:0x01b1 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v23 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r20v0, types: [long] */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v3 */
    /* JADX WARN: Type inference failed for: r29v0, types: [com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl] */
    private void handleGetUserFollowList(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr, boolean z16) {
        IPublicAccountObserver.b bVar;
        IPublicAccountObserver.b bVar2;
        int i3;
        ?? r18;
        IPublicAccountObserver.b bVar3;
        IPublicAccountObserver.b bVar4;
        IPublicAccountObserver.b bVar5;
        boolean z17;
        IPublicAccountObserver.b bVar6;
        IPublicAccountObserver.b bVar7;
        IPublicAccountObserver.b bVar8;
        IPublicAccountObserver.b bVar9;
        IPublicAccountObserver.b bVar10;
        boolean z18;
        PublicAccountHandlerImpl publicAccountHandlerImpl = this;
        IPublicAccountObserver.b bVar11 = new IPublicAccountObserver.b();
        if (handleGetUserFollowListResendMsg(intent, fromServiceMsg)) {
            return;
        }
        boolean z19 = true;
        boolean z26 = false;
        if (handleGetUserFollowListIsResSuccess(intent, fromServiceMsg, bArr)) {
            bVar11.f79353a = 0;
            long longExtra = intent.getLongExtra(ARG_TIME_STAMP, 0L);
            long longExtra2 = intent.getLongExtra(ARG_GET_FOLLOW_LIST_BEGIN, 0L);
            long longExtra3 = intent.getLongExtra(ARG_GET_FOLLOW_LIST_FOLLOW_SEQ, 0L);
            ?? longExtra4 = intent.getLongExtra(ARG_GET_FOLLOW_LIST_DATA_SEQ, 0L);
            boolean booleanExtra = intent.getBooleanExtra(ARG_GET_FOLLOW_LIST_IS_INCREMENT, true);
            boolean booleanExtra2 = intent.getBooleanExtra(ARG_GET_FOLLOW_LIST_IS_NEW_SEQ_LOGIC, false);
            int intExtra = intent.getIntExtra(ARG_GET_FOLLOW_LIST_FROM_SRC, 0);
            handleGetUserFollowListQLogPreFollowData(longExtra, longExtra2, longExtra3, longExtra4);
            try {
                if (z16) {
                    try {
                        CertifiedAccountRead$StGetFollowListRsp certifiedAccountRead$StGetFollowListRsp = new CertifiedAccountRead$StGetFollowListRsp();
                        certifiedAccountRead$StGetFollowListRsp.mergeFrom(bArr);
                        boolean z27 = certifiedAccountRead$StGetFollowListRsp.refresh.get() == 1;
                        boolean z28 = certifiedAccountRead$StGetFollowListRsp.has_next.get() == 1;
                        long j3 = certifiedAccountRead$StGetFollowListRsp.seq.get();
                        String str = certifiedAccountRead$StGetFollowListRsp.attach_info.get();
                        publicAccountHandlerImpl.handleGetUserFollowListQLogRefresh(z27, z28);
                        try {
                            if (z27) {
                                try {
                                    getUserFollowList(0L, 0L, 0L, 20L, SystemClock.uptimeMillis(), false, true, str, booleanExtra2, intExtra);
                                    bVar5 = bVar11;
                                    z19 = false;
                                    z17 = false;
                                } catch (Exception unused) {
                                    publicAccountHandlerImpl = this;
                                    r18 = 0;
                                    i3 = -1;
                                    bVar = bVar11;
                                    bVar.f79353a = i3;
                                    bVar.f79355c = true;
                                    z19 = true;
                                    z26 = r18;
                                    publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                                }
                            } else {
                                handleGetUserFollowListInnerLogic2(z16, bVar11, longExtra, longExtra2, booleanExtra, certifiedAccountRead$StGetFollowListRsp, z28, j3, str, booleanExtra2, intExtra);
                                bVar5 = bVar11;
                                bVar5.f79353a = 0;
                                z19 = true;
                                z17 = true;
                            }
                            longExtra4 = bVar5;
                            publicAccountHandlerImpl = this;
                            bVar6 = longExtra4;
                        } catch (Exception unused2) {
                            i3 = -1;
                            r18 = 0;
                            publicAccountHandlerImpl = this;
                            bVar = longExtra4;
                        }
                    } catch (Exception unused3) {
                        bVar3 = bVar11;
                        bVar4 = null;
                        i3 = -1;
                        bVar = bVar3;
                        bVar2 = bVar4;
                        publicAccountHandlerImpl = this;
                        r18 = bVar2;
                        bVar.f79353a = i3;
                        bVar.f79355c = true;
                        z19 = true;
                        z26 = r18;
                        publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                    }
                } else {
                    bVar3 = bVar11;
                    try {
                        mobileqq_mp$GetUserFollowListResponse mobileqq_mp_getuserfollowlistresponse = new mobileqq_mp$GetUserFollowListResponse();
                        mobileqq_mp_getuserfollowlistresponse.mergeFrom(bArr);
                        int i16 = (mobileqq_mp_getuserfollowlistresponse.ret_info.has() && mobileqq_mp_getuserfollowlistresponse.ret_info.get().ret_code.has()) ? mobileqq_mp_getuserfollowlistresponse.ret_info.get().ret_code.get() : 0;
                        bVar3.f79353a = i16;
                        try {
                            handleGetUserFollowListQLogHasnext(mobileqq_mp_getuserfollowlistresponse, i16);
                            try {
                                if (i16 != 0) {
                                    z19 = true;
                                    bVar3.f79355c = true;
                                    z17 = false;
                                    bVar6 = bVar3;
                                    publicAccountHandlerImpl = this;
                                } else {
                                    long P = Utils.P(mobileqq_mp_getuserfollowlistresponse.follow_seqno.has() ? mobileqq_mp_getuserfollowlistresponse.follow_seqno.get() : 0);
                                    long P2 = Utils.P(mobileqq_mp_getuserfollowlistresponse.public_account_seqno.has() ? mobileqq_mp_getuserfollowlistresponse.public_account_seqno.get() : 0);
                                    try {
                                        if (P > longExtra3 && longExtra3 != 0) {
                                            try {
                                                getUserFollowList(P, P2, 0L, 20L, SystemClock.uptimeMillis(), false, z16, null, false, intExtra);
                                                publicAccountHandlerImpl = this;
                                                z19 = false;
                                                z17 = false;
                                                bVar6 = bVar3;
                                            } catch (Exception unused4) {
                                                bVar7 = null;
                                                i3 = -1;
                                                bVar4 = bVar7;
                                                bVar = bVar3;
                                                bVar2 = bVar4;
                                                publicAccountHandlerImpl = this;
                                                r18 = bVar2;
                                                bVar.f79353a = i3;
                                                bVar.f79355c = true;
                                                z19 = true;
                                                z26 = r18;
                                                publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                                            }
                                        } else {
                                            bVar7 = null;
                                            try {
                                                long P3 = Utils.P(mobileqq_mp_getuserfollowlistresponse.total_count.has() ? mobileqq_mp_getuserfollowlistresponse.total_count.get() : 0);
                                                List<PublicAccountInfo> createPublicAccountInfoList = PublicAccountInfo.createPublicAccountInfoList(mobileqq_mp_getuserfollowlistresponse.info.get(), longExtra);
                                                bVar3 = bVar3;
                                                try {
                                                    bVar3.f79356d = createPublicAccountInfoList;
                                                    try {
                                                        try {
                                                            if (mobileqq_mp_getuserfollowlistresponse.has_next.has()) {
                                                                try {
                                                                    if (mobileqq_mp_getuserfollowlistresponse.has_next.get()) {
                                                                        z18 = false;
                                                                        bVar3.f79355c = z18;
                                                                        bVar3.f79354b = P3;
                                                                        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
                                                                        savePublicAccountInfos(createPublicAccountInfoList, longExtra, booleanExtra, bVar3.f79355c, booleanExtra2, intExtra);
                                                                        bVar8 = bVar3;
                                                                        publicAccountHandlerImpl = this;
                                                                        handleGetUserFollowListInnerLogic3(z16, bVar3, longExtra, longExtra2, booleanExtra, P, P2, (PublicAccountDataManagerImpl) iPublicAccountDataManager, false, intExtra);
                                                                        publicAccountHandlerImpl.setCurDataSeq(P2, z16);
                                                                        z19 = true;
                                                                        z17 = true;
                                                                        bVar6 = bVar8;
                                                                    }
                                                                } catch (Exception unused5) {
                                                                    i3 = -1;
                                                                    bVar4 = bVar7;
                                                                    bVar = bVar3;
                                                                    bVar2 = bVar4;
                                                                    publicAccountHandlerImpl = this;
                                                                    r18 = bVar2;
                                                                    bVar.f79353a = i3;
                                                                    bVar.f79355c = true;
                                                                    z19 = true;
                                                                    z26 = r18;
                                                                    publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                                                                }
                                                            }
                                                            handleGetUserFollowListInnerLogic3(z16, bVar3, longExtra, longExtra2, booleanExtra, P, P2, (PublicAccountDataManagerImpl) iPublicAccountDataManager, false, intExtra);
                                                            publicAccountHandlerImpl.setCurDataSeq(P2, z16);
                                                            z19 = true;
                                                            z17 = true;
                                                            bVar6 = bVar8;
                                                        } catch (Exception unused6) {
                                                            bVar = bVar8;
                                                            bVar9 = bVar7;
                                                            i3 = -1;
                                                            r18 = bVar9;
                                                            bVar.f79353a = i3;
                                                            bVar.f79355c = true;
                                                            z19 = true;
                                                            z26 = r18;
                                                            publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                                                        }
                                                        IPublicAccountDataManager iPublicAccountDataManager2 = (IPublicAccountDataManager) this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
                                                        savePublicAccountInfos(createPublicAccountInfoList, longExtra, booleanExtra, bVar3.f79355c, booleanExtra2, intExtra);
                                                        bVar8 = bVar3;
                                                        publicAccountHandlerImpl = this;
                                                    } catch (Exception unused7) {
                                                        bVar8 = bVar3;
                                                        publicAccountHandlerImpl = this;
                                                    }
                                                    z18 = true;
                                                    bVar3.f79355c = z18;
                                                    bVar3.f79354b = P3;
                                                } catch (Exception unused8) {
                                                    bVar8 = bVar3;
                                                    publicAccountHandlerImpl = this;
                                                    bVar = bVar8;
                                                    bVar9 = bVar7;
                                                    i3 = -1;
                                                    r18 = bVar9;
                                                    bVar.f79353a = i3;
                                                    bVar.f79355c = true;
                                                    z19 = true;
                                                    z26 = r18;
                                                    publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                                                }
                                            } catch (Exception unused9) {
                                                publicAccountHandlerImpl = this;
                                                bVar = bVar3;
                                                bVar9 = bVar7;
                                                i3 = -1;
                                                r18 = bVar9;
                                                bVar.f79353a = i3;
                                                bVar.f79355c = true;
                                                z19 = true;
                                                z26 = r18;
                                                publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                                            }
                                        }
                                    } catch (Exception unused10) {
                                        i3 = -1;
                                        publicAccountHandlerImpl = this;
                                        bVar = bVar10;
                                        r18 = longExtra3;
                                        bVar.f79353a = i3;
                                        bVar.f79355c = true;
                                        z19 = true;
                                        z26 = r18;
                                        publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
                                    }
                                }
                            } catch (Exception unused11) {
                                r18 = 0;
                                bVar = bVar3;
                                i3 = -1;
                                publicAccountHandlerImpl = this;
                            }
                        } catch (Exception unused12) {
                            bVar7 = null;
                            bVar8 = bVar3;
                            publicAccountHandlerImpl = this;
                        }
                    } catch (Exception unused13) {
                        bVar7 = null;
                    }
                }
                bVar = bVar6;
                z26 = z17;
            } catch (Exception unused14) {
                bVar2 = bVar11;
                bVar = publicAccountHandlerImpl;
                i3 = -1;
            }
        } else {
            bVar = bVar11;
            bVar.f79353a = -1;
            bVar.f79355c = true;
            publicAccountHandlerImpl.handleGetUserFollowListQLogErrCode("<<---handleGetUserFollowList ", -1);
        }
        publicAccountHandlerImpl.handleGetUserFollowListNeedNotify(bVar, z19, z26, 100);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountHandler
    public void getAIOHistoryMsg(String str, long j3, int i3) {
        getAIOHistoryMsg(str, j3, i3, null);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String serviceCmd;
        if (fromServiceMsg == null || (serviceCmd = fromServiceMsg.getServiceCmd()) == null || serviceCmd.length() == 0) {
            return;
        }
        if ("PubAccountSvc.ReportLbs".equalsIgnoreCase(serviceCmd)) {
            fromServiceMsg.isSuccess();
            return;
        }
        if (CMD_PUBLICACCOUNT_WEATHER_INFO.equals(serviceCmd) && fromServiceMsg.isSuccess() && obj != null) {
            WeatherReportInfo$GetWeatherMessageRsp weatherReportInfo$GetWeatherMessageRsp = new WeatherReportInfo$GetWeatherMessageRsp();
            try {
                weatherReportInfo$GetWeatherMessageRsp.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException unused) {
            }
            int i3 = weatherReportInfo$GetWeatherMessageRsp.cmd.get();
            String str = weatherReportInfo$GetWeatherMessageRsp.string_msg.get();
            if (i3 == 1 || i3 == 2) {
                IPublicAccountHandler.a aVar = this.mWeatherInfos.get(Integer.valueOf(i3));
                if (aVar != null) {
                    aVar.onComplete(str);
                }
                this.mWeatherInfos.remove(Integer.valueOf(i3));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "type = " + i3 + " msg =" + str);
            }
        }
    }

    private void handlePushMessageTypeList(SubMsgType0x28$RspTypeList subMsgType0x28$RspTypeList) {
    }
}
