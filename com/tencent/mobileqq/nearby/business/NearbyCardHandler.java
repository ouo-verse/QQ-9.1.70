package com.tencent.mobileqq.nearby.business;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.RespFavorite;
import SummaryCard.RespHead;
import SummaryCard.RespSummaryCard;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import appoint.define.appoint_define$CommonLabel;
import appoint.define.appoint_define$InterestItem;
import appoint.define.appoint_define$InterestTag;
import appoint.define.appoint_define$LBSInfo;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.jungle.nearby.nio.proto.nearby$Cmd0x1RspBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ay;
import com.tencent.mobileqq.app.bz;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.c;
import com.tencent.mobileqq.nearby.api.e;
import com.tencent.mobileqq.nearby.business.NearbyCardHandler;
import com.tencent.mobileqq.nearby.c;
import com.tencent.mobileqq.nearby.h;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagInfoUtils;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.newnearby.servlet.ServletObserver;
import com.tencent.mobileqq.newnearby.servlet.b;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.ExecSQLTransaction;
import com.tencent.mobileqq.persistence.transaction.FindTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistOrReplaceTransaction;
import com.tencent.mobileqq.persistence.transaction.QueryTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.profilecard.bussiness.achievement.processor.LifeAchievementBusinessProcessor;
import com.tencent.mobileqq.profilecard.servlet.ProfileCardServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.dc;
import com.tencent.mobileqq.utils.g;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.nowsummarycard.NowSummaryCard$ClientInfo;
import com.tencent.nowsummarycard.NowSummaryCard$GroupInfo;
import com.tencent.nowsummarycard.NowSummaryCard$LocationInfo;
import com.tencent.nowsummarycard.NowSummaryCard$NearbySummaryCardReq;
import com.tencent.nowsummarycard.NowSummaryCard$NearbySummaryCardRsp;
import com.tencent.nowsummarycard.NowSummaryCard$ReqNearbySummaryCard;
import com.tencent.nowsummarycard.NowSummaryCard$RespNearbySummaryCard;
import com.tencent.nowsummarycard.NowSummaryCard$VoteInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.encrypt.Base64;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernel.nativeinterface.TempChatPrepareInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l92.d;
import org.json.JSONArray;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList$HeadInfo;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList$ReqBody;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList$RichHead;
import tencent.im.oidb.cmd0x5ea.UpdatePhotoList$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b$ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b$RspBody;
import tencent.im.oidb.cmd0x686.Oidb_0x686$CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyRankConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686$RspBody;
import tencent.im.oidb.cmd0x9c5.cmd0x9c5$RspBody;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7$ReqBody;
import tencent.im.oidb.cmd0x9c8.cmd0x9c8$RspBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9$ReqBody;
import tencent.im.oidb.cmd0x9c9.cmd0x9c9$RspBody;
import tencent.im.oidb.cmd0xac5.cmd0xac5$NearbyNowData;
import tencent.im.oidb.cmd0xb5b.cmd0xb5b$RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6$RspBody;
import tencent.im.oidb.oidb_0x8e6.oidb_0x8e6$VoteResult;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7$RspBody;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7$UserZanInfo;
import tencent.im.oidb.oidb_0x8e7.oidb_0x8e7$ZanLimitInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes33.dex */
public class NearbyCardHandler extends BusinessHandler implements l92.a {

    /* renamed from: h, reason: collision with root package name */
    public static final String f252547h = "com.tencent.mobileqq.nearby.business.NearbyCardHandler";

    /* renamed from: d, reason: collision with root package name */
    protected Set<String> f252548d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f252549e;

    /* renamed from: f, reason: collision with root package name */
    private AppInterface f252550f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends ServletObserver {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ToServiceMsg f252551f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z16, ToServiceMsg toServiceMsg) {
            super(z16);
            this.f252551f = toServiceMsg;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0101  */
        @Override // com.tencent.mobileqq.newnearby.servlet.ServletObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            NowSummaryCard$RespNearbySummaryCard nowSummaryCard$RespNearbySummaryCard = new NowSummaryCard$RespNearbySummaryCard();
            if (i3 != 0) {
                QLog.e("NearbyCardHandler", 1, "NowSummaryCard error, code=" + i3);
                NearbyCardHandler.this.Z2(false, null, this.f252551f.extraData);
                return;
            }
            NowSummaryCard$NearbySummaryCardRsp nowSummaryCard$NearbySummaryCardRsp = new NowSummaryCard$NearbySummaryCardRsp();
            try {
                nowSummaryCard$NearbySummaryCardRsp.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.i("NearbyCardHandler", 1, "NowSummaryCard, merge error e=" + e16.toString(), e16);
            }
            if (nowSummaryCard$NearbySummaryCardRsp.err_msg.has()) {
                QLog.i("NearbyCardHandler", 1, "NowSummaryCard, err_msg=" + nowSummaryCard$NearbySummaryCardRsp.err_msg.get());
            }
            if (!nowSummaryCard$NearbySummaryCardRsp.ret_code.has()) {
                QLog.i("NearbyCardHandler", 1, "NowSummaryCard error, ret_code=" + nowSummaryCard$NearbySummaryCardRsp.ret_code.get());
                NearbyCardHandler.this.Z2(false, null, this.f252551f.extraData);
                return;
            }
            if (nowSummaryCard$NearbySummaryCardRsp.ret_code.get() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("NearbyCardHandler", 2, "NowSummaryCard rsp length=" + nowSummaryCard$NearbySummaryCardRsp.pb_data.get().toByteArray().length);
                }
                try {
                    nowSummaryCard$RespNearbySummaryCard.mergeFrom(nowSummaryCard$NearbySummaryCardRsp.pb_data.get().toByteArray());
                    z16 = true;
                } catch (InvalidProtocolBufferMicroException e17) {
                    QLog.i("NearbyCardHandler", 1, "NowSummaryCard, merge error e=" + e17.toString(), e17);
                }
                if (!z16) {
                    NearbyCardHandler.this.Z2(true, nowSummaryCard$RespNearbySummaryCard, this.f252551f.extraData);
                    return;
                } else {
                    NearbyCardHandler.this.Z2(false, null, this.f252551f.extraData);
                    return;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
    }

    public NearbyCardHandler(AppInterface appInterface) {
        super(appInterface);
        this.f252550f = appInterface;
        if (appInterface instanceof QQAppInterface) {
            this.f252549e = (QQAppInterface) appInterface;
        }
    }

    private NowSummaryCard$ClientInfo F2() {
        NowSummaryCard$ClientInfo nowSummaryCard$ClientInfo = new NowSummaryCard$ClientInfo();
        nowSummaryCard$ClientInfo.client_version.set(ByteStringMicro.copyFrom(AppSetting.n().getBytes()));
        nowSummaryCard$ClientInfo.platform.set(2);
        return nowSummaryCard$ClientInfo;
    }

    private NowSummaryCard$LocationInfo G2() {
        SosoLocation sosoLocation;
        NowSummaryCard$LocationInfo nowSummaryCard$LocationInfo = new NowSummaryCard$LocationInfo();
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("NearbyProtocolCoder.Encounter");
        if (cachedLbsInfo != null && (sosoLocation = cachedLbsInfo.mLocation) != null) {
            Long valueOf = Long.valueOf(Double.valueOf(sosoLocation.mLat02 * 1000000.0d).longValue());
            Long valueOf2 = Long.valueOf(Double.valueOf(sosoLocation.mLon02 * 1000000.0d).longValue());
            nowSummaryCard$LocationInfo.latitude.set(valueOf.longValue());
            nowSummaryCard$LocationInfo.longitude.set(valueOf2.longValue());
        }
        return nowSummaryCard$LocationInfo;
    }

    private void H2(long j3, int i3, int i16, long j16, String str, byte b16, ToServiceMsg toServiceMsg) {
        NowSummaryCard$ReqNearbySummaryCard nowSummaryCard$ReqNearbySummaryCard = new NowSummaryCard$ReqNearbySummaryCard();
        nowSummaryCard$ReqNearbySummaryCard.tiny_id.set(j16);
        try {
            nowSummaryCard$ReqNearbySummaryCard.uin.set(Long.valueOf(str).longValue());
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("NearbyCardHandler", 2, "getNearbySummaryCard, illegal uin: " + str);
            }
        }
        nowSummaryCard$ReqNearbySummaryCard.location.set(G2());
        nowSummaryCard$ReqNearbySummaryCard.client_info.set(F2());
        nowSummaryCard$ReqNearbySummaryCard.come_from.set(i16);
        NowSummaryCard$NearbySummaryCardReq nowSummaryCard$NearbySummaryCardReq = new NowSummaryCard$NearbySummaryCardReq();
        nowSummaryCard$NearbySummaryCardReq.f339115id.set(j3);
        nowSummaryCard$NearbySummaryCardReq.id_type.set(i3);
        nowSummaryCard$NearbySummaryCardReq.gender.set(1L);
        nowSummaryCard$NearbySummaryCardReq.pb_data.set(ByteStringMicro.copyFrom(nowSummaryCard$ReqNearbySummaryCard.toByteArray()));
        if (QLog.isColorLevel()) {
            QLog.e("NearbyCardHandler", 2, "start uin:" + str + ", tinyId:" + j16 + ", nowId:" + j3 + ", from:" + i16);
        }
        b.a(new a(false, toServiceMsg), nowSummaryCard$NearbySummaryCardReq.toByteArray(), "NowSummaryCard.NearbySummaryCardReq");
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_DELETE_AUTH_VIDEO, 2, "CardHandler.handleDeleteNearbyPeopleAuthVideo, isSuccess: " + fromServiceMsg.isSuccess());
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (isSuccess && obj != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null) {
                    r5 = mergeFrom.uint32_result.get() == 0;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_DELETE_AUTH_VIDEO, 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + mergeFrom.uint32_result.get());
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_DELETE_AUTH_VIDEO, 2, e16.toString());
                }
            }
        }
        notifyUI(49, r5, null);
    }

    private void M2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        mobile_sub_get_cover_rsp mobile_sub_get_cover_rspVar;
        boolean z16;
        String str = (String) toServiceMsg.getAttribute("uin");
        if (fromServiceMsg.isSuccess() && (obj instanceof mobile_sub_get_cover_rsp)) {
            mobile_sub_get_cover_rspVar = (mobile_sub_get_cover_rsp) obj;
            z16 = true;
        } else {
            mobile_sub_get_cover_rspVar = null;
            z16 = false;
        }
        notifyUI(40, z16, new Object[]{str, mobile_sub_get_cover_rspVar});
    }

    private void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_IMPORT_QZONE_PHOTOES, 2, "CardHandler.handleImportQzonePhotoes(), FromServiceMsg isSuccess: " + fromServiceMsg.isSuccess());
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z16 = false;
        Object[] objArr = null;
        if (isSuccess && obj != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.has()) {
                    boolean z17 = mergeFrom.uint32_result.get() == 0;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_IMPORT_QZONE_PHOTOES, 2, "oidbPkg.uint32_result = " + mergeFrom.uint32_result.get());
                        }
                        if (z17) {
                            UpdatePhotoList$RspBody mergeFrom2 = new UpdatePhotoList$RspBody().mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                            objArr = new Object[]{mergeFrom2.rpt_msg_headinfo.get(), Integer.valueOf(mergeFrom2.uint32_import_state.get()), Integer.valueOf(mergeFrom2.uint32_import_count.get()), Integer.valueOf(mergeFrom2.uint32_import_rest_count.get()), Integer.valueOf(mergeFrom2.uint32_rest_count_in_qzone.get())};
                        }
                        z16 = z17;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        z16 = z17;
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_IMPORT_QZONE_PHOTOES, 2, e.toString());
                        }
                        notifyUI(48, z16, objArr);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
        }
        notifyUI(48, z16, objArr);
    }

    private void U2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_QUERY_IMPORT_QZONE_PHOTOES_STATUS, 2, "CardHandler.handleQueryImportQzonePhotoesStatus(), FromServiceMsg isSuccess: " + fromServiceMsg.isSuccess());
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        boolean z16 = false;
        z16 = false;
        z16 = false;
        z16 = false;
        z16 = false;
        Object[] objArr = null;
        if (isSuccess && obj != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.has()) {
                    boolean z17 = mergeFrom.uint32_result.get() == 0;
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_QUERY_IMPORT_QZONE_PHOTOES_STATUS, 2, "CardHandler.handleQueryImportQzonePhotoesStatus(), oidbPkg.uint32_result = " + mergeFrom.uint32_result.get());
                        }
                        if (z17) {
                            UpdatePhotoList$RspBody mergeFrom2 = new UpdatePhotoList$RspBody().mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                            objArr = new Object[]{mergeFrom2.rpt_msg_headinfo.get(), Integer.valueOf(mergeFrom2.uint32_import_state.get()), Integer.valueOf(mergeFrom2.uint32_import_count.get()), Integer.valueOf(mergeFrom2.uint32_import_rest_count.get()), Integer.valueOf(mergeFrom2.uint32_rest_count_in_qzone.get())};
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("CardHandler.handleQueryImportQzonePhotoesStatus(), head_info = ");
                                Object obj2 = objArr[0];
                                if (obj2 != null) {
                                    List list = (List) obj2;
                                    for (int i3 = 0; i3 < list.size(); i3++) {
                                        UpdatePhotoList$HeadInfo updatePhotoList$HeadInfo = (UpdatePhotoList$HeadInfo) list.get(i3);
                                        sb5.append("head_id = ");
                                        sb5.append(updatePhotoList$HeadInfo.uint32_headid.get());
                                        sb5.append(", head_url = ");
                                        sb5.append(updatePhotoList$HeadInfo.str_headurl.get());
                                        sb5.append(", is_avatar = ");
                                        sb5.append(updatePhotoList$HeadInfo.uint32_is_curhead.get());
                                        sb5.append("|");
                                    }
                                }
                                sb5.append(", import_status = ");
                                sb5.append(objArr[1]);
                                sb5.append(", imported_count = ");
                                sb5.append(objArr[2]);
                                sb5.append(", rest_count = ");
                                sb5.append(objArr[3]);
                                sb5.append(", rest_count_in_old_photo_wall = ");
                                sb5.append(objArr[4]);
                                QLog.d(LogTag.TAG_QUERY_IMPORT_QZONE_PHOTOES_STATUS, 2, sb5.toString());
                            }
                        }
                        z16 = z17;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        z16 = z17;
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_QUERY_IMPORT_QZONE_PHOTOES_STATUS, 2, e.toString());
                        }
                        notifyUI(50, z16, objArr);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
            }
        }
        notifyUI(50, z16, objArr);
    }

    private void W2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_UPDATE_AUTH_VIDEO, 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo, isSuccess: " + fromServiceMsg.isSuccess());
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        UpdatePhotoList$HeadInfo updatePhotoList$HeadInfo = null;
        if (isSuccess && obj != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null) {
                    r6 = mergeFrom.uint32_result.get() == 0;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_UPDATE_AUTH_VIDEO, 2, "CardHandler.handleUpdateNearbyPeopleAuthVideo(), oidbPkg.uint32_result = " + mergeFrom.uint32_result.get());
                    }
                }
                if (r6) {
                    updatePhotoList$HeadInfo = new UpdatePhotoList$RspBody().mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray()).msg_verify_video_info.get();
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_UPDATE_AUTH_VIDEO, 2, e16.toString());
                }
            }
        }
        notifyUI(47, r6, updatePhotoList$HeadInfo);
    }

    private void X2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_UPDATE_PHOTO_LIST, 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), isSuccess: " + fromServiceMsg.isSuccess());
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (isSuccess && obj != null) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null) {
                    r5 = mergeFrom.uint32_result.get() == 0;
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_UPDATE_PHOTO_LIST, 2, "CardHandler.handleUpdateNearbyPeoplePhotoList(), oidbPkg.uint32_result = " + mergeFrom.uint32_result.get());
                    }
                }
                if (r5) {
                    NearbyCardManager.w(this.f252549e);
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_UPDATE_PHOTO_LIST, 2, e16.toString());
                }
            }
        }
        notifyUI(46, r5, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y2(int i3, String str) {
        QLog.i("NearbyCardHandler", 1, "prepareNearbyTempChatSignature, result=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(boolean z16, NowSummaryCard$RespNearbySummaryCard nowSummaryCard$RespNearbySummaryCard, Bundle bundle) {
        boolean z17;
        NearbyPeopleCard nearbyPeopleCard;
        Class cls;
        EntityManager entityManager;
        NearbyPeopleCard nearbyPeopleCard2;
        boolean z18;
        boolean z19;
        cmd0xac5$NearbyNowData cmd0xac5_nearbynowdata;
        boolean z26 = bundle.getBoolean("partlyRefresh");
        int i3 = bundle.getInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE);
        if (z16 && nowSummaryCard$RespNearbySummaryCard != null) {
            QLog.e("NearbyCardHandler", 1, "uin:" + nowSummaryCard$RespNearbySummaryCard.uin.get() + ", tinyId:" + nowSummaryCard$RespNearbySummaryCard.tiny_id.get() + ", nickName:" + nowSummaryCard$RespNearbySummaryCard.nick.get());
            EntityManager createEntityManager = this.f252549e.getEntityManagerFactory().createEntityManager();
            long j3 = bundle.getLong("tinyId", 0L);
            long j16 = bundle.getLong("nowId");
            int i16 = bundle.getInt("nowUserType");
            if (i16 == 0) {
                z17 = z26;
                nearbyPeopleCard = (NearbyPeopleCard) createEntityManager.doFindOperateByTransaction(new FindTransaction(NearbyPeopleCard.class, "tinyId=?", new String[]{String.valueOf(j3)}));
            } else {
                z17 = z26;
                nearbyPeopleCard = j16 > 0 ? (NearbyPeopleCard) createEntityManager.doFindOperateByTransaction(new FindTransaction(NearbyPeopleCard.class, "nowId=?", new String[]{String.valueOf(j16)})) : null;
            }
            if (nearbyPeopleCard == null) {
                nearbyPeopleCard2 = new NearbyPeopleCard();
                entityManager = createEntityManager;
                cls = NearbyPeopleCard.class;
            } else {
                int status = nearbyPeopleCard.getStatus();
                cls = NearbyPeopleCard.class;
                long id5 = nearbyPeopleCard.getId();
                NearbyPeopleCard nearbyPeopleCard3 = new NearbyPeopleCard();
                entityManager = createEntityManager;
                nearbyPeopleCard3.isForbidSendGiftMsg = nearbyPeopleCard.isForbidSendGiftMsg;
                nearbyPeopleCard3.isForbidSendGiftMsgForTribar = nearbyPeopleCard.isForbidSendGiftMsgForTribar;
                nearbyPeopleCard3.isForbidSendMsg = nearbyPeopleCard.isForbidSendMsg;
                nearbyPeopleCard3.maskMsgFlag = nearbyPeopleCard.maskMsgFlag;
                nearbyPeopleCard3.highScoreNum = nearbyPeopleCard.highScoreNum;
                nearbyPeopleCard3.isForbidSendMsgForTribar = nearbyPeopleCard.isForbidSendMsgForTribar;
                nearbyPeopleCard3.disableSendGiftBtnTips = nearbyPeopleCard.disableSendGiftBtnTips;
                nearbyPeopleCard3.disableSendGiftBtnTipsForTribar = nearbyPeopleCard.disableSendGiftBtnTipsForTribar;
                nearbyPeopleCard3.disableSendMsgBtnTips = nearbyPeopleCard.disableSendMsgBtnTips;
                nearbyPeopleCard3.disableSendMsgBtnTipsForTribar = nearbyPeopleCard.disableSendMsgBtnTipsForTribar;
                nearbyPeopleCard3.faceScoreWording = nearbyPeopleCard.faceScoreWording;
                nearbyPeopleCard3.faceScoreWordingColor = nearbyPeopleCard.faceScoreWordingColor;
                nearbyPeopleCard3.entryAbility = nearbyPeopleCard.entryAbility;
                nearbyPeopleCard3.faceScoreTailWordingColor = nearbyPeopleCard.faceScoreTailWordingColor;
                nearbyPeopleCard3.faceScoreTailWording = nearbyPeopleCard.faceScoreTailWording;
                nearbyPeopleCard3.faceScoreIconUrl = nearbyPeopleCard.faceScoreIconUrl;
                nearbyPeopleCard3.entryAbility = nearbyPeopleCard.entryAbility;
                nearbyPeopleCard3.setStatus(status);
                nearbyPeopleCard3.setId(id5);
                nearbyPeopleCard2 = nearbyPeopleCard3;
            }
            boolean z27 = i3 == 0;
            nearbyPeopleCard2.isHostSelf = z27;
            if (z27) {
                nearbyPeopleCard2.uin = this.f252549e.getCurrentAccountUin();
            } else if (nowSummaryCard$RespNearbySummaryCard.is_friend.get() == 1) {
                nearbyPeopleCard2.uin = String.valueOf(nowSummaryCard$RespNearbySummaryCard.uin.get());
            } else {
                nearbyPeopleCard2.uin = "0";
            }
            if (j3 > 0) {
                nearbyPeopleCard2.tinyId = j3;
            } else {
                try {
                    nearbyPeopleCard2.tinyId = Long.valueOf(nowSummaryCard$RespNearbySummaryCard.tiny_id.get()).longValue();
                } catch (Exception unused) {
                    nearbyPeopleCard2.tinyId = 0L;
                }
            }
            nearbyPeopleCard2.nowId = j16;
            nearbyPeopleCard2.nowUserType = i16;
            nearbyPeopleCard2.nickname = nowSummaryCard$RespNearbySummaryCard.nick.get();
            nearbyPeopleCard2.sign = nowSummaryCard$RespNearbySummaryCard.sign.get();
            nearbyPeopleCard2.xuanYan = nowSummaryCard$RespNearbySummaryCard.rich_sign.get().toByteArray();
            nearbyPeopleCard2.gender = (byte) nowSummaryCard$RespNearbySummaryCard.gender.get();
            nearbyPeopleCard2.age = nowSummaryCard$RespNearbySummaryCard.age.get();
            nearbyPeopleCard2.birthday = (int) nowSummaryCard$RespNearbySummaryCard.birthday.get();
            nearbyPeopleCard2.job = nowSummaryCard$RespNearbySummaryCard.profession.get();
            nearbyPeopleCard2.constellation = (byte) nowSummaryCard$RespNearbySummaryCard.constellation.get();
            nearbyPeopleCard2.distance = nowSummaryCard$RespNearbySummaryCard.distance.get();
            nearbyPeopleCard2.timeDiff = nowSummaryCard$RespNearbySummaryCard.elapse.get();
            nearbyPeopleCard2.company = nowSummaryCard$RespNearbySummaryCard.company.get();
            nearbyPeopleCard2.college = nowSummaryCard$RespNearbySummaryCard.school.get();
            nearbyPeopleCard2.maritalStatus = (byte) nowSummaryCard$RespNearbySummaryCard.marriage.get();
            nearbyPeopleCard2.collegeId = nowSummaryCard$RespNearbySummaryCard.school_id.get();
            nearbyPeopleCard2.nearbyInfo = nowSummaryCard$RespNearbySummaryCard.nearby_info.get().toByteArray();
            nearbyPeopleCard2.hometownCountry = ConditionSearchManager.n(nowSummaryCard$RespNearbySummaryCard.home_country.get());
            nearbyPeopleCard2.hometownProvice = ConditionSearchManager.n(nowSummaryCard$RespNearbySummaryCard.home_province.get());
            nearbyPeopleCard2.hometownCity = ConditionSearchManager.n(nowSummaryCard$RespNearbySummaryCard.home_city.get());
            nearbyPeopleCard2.hometownDistrict = ConditionSearchManager.n(nowSummaryCard$RespNearbySummaryCard.home_zone.get());
            nearbyPeopleCard2.lastUpdateNickTime = System.currentTimeMillis();
            nearbyPeopleCard2.vTempChatSig = nowSummaryCard$RespNearbySummaryCard.temp_chat_sig.get().toByteArray();
            nearbyPeopleCard2.isFriend = nowSummaryCard$RespNearbySummaryCard.is_friend.get() == 1;
            nearbyPeopleCard2.chatId = nowSummaryCard$RespNearbySummaryCard.chat_id.get();
            nearbyPeopleCard2.nearbyTag = nowSummaryCard$RespNearbySummaryCard.nearby_tag;
            nearbyPeopleCard2.commonTag = nowSummaryCard$RespNearbySummaryCard.common_tag;
            nearbyPeopleCard2.isVerified = nowSummaryCard$RespNearbySummaryCard.is_verified.get() != 0;
            NowSummaryCard$GroupInfo nowSummaryCard$GroupInfo = nowSummaryCard$RespNearbySummaryCard.group_info.get();
            nearbyPeopleCard2.recentlyJoinedGroup = new Pair<>(Long.valueOf(nowSummaryCard$GroupInfo.group_id.get()), nowSummaryCard$GroupInfo.group_name.get());
            nearbyPeopleCard2.favoriteSource = i3;
            byte[] bArr = nearbyPeopleCard2.vTempChatSig;
            if (bArr != null) {
                if (bArr.length == 0 && !nearbyPeopleCard2.isHostSelf) {
                    QQAppInterface qQAppInterface = this.f252549e;
                    ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_card_get_sig_length_0", 0, 0, qQAppInterface.getCurrentAccountUin(), String.valueOf(nearbyPeopleCard2.tinyId), "", "");
                }
                if (this.f252549e.getMsgCache().b0(String.valueOf(nearbyPeopleCard2.tinyId)) == null) {
                    this.f252549e.getMsgCache().d(String.valueOf(nearbyPeopleCard2.tinyId), nearbyPeopleCard2.vTempChatSig);
                }
                b3(nearbyPeopleCard2, nearbyPeopleCard2.vTempChatSig);
            } else {
                QQAppInterface qQAppInterface2 = this.f252549e;
                ReportController.o(qQAppInterface2, "dc00899", "grp_lbs", "", "nearby_chat", "nearby_card_get_sig_null", 0, 0, qQAppInterface2.getCurrentAccountUin(), String.valueOf(nearbyPeopleCard2.tinyId), "", "");
            }
            byte[] byteArray = nowSummaryCard$RespNearbySummaryCard.common_label.get().toByteArray();
            if (byteArray != null) {
                nearbyPeopleCard2.commonLabels = new ArrayList();
                appoint_define$CommonLabel appoint_define_commonlabel = new appoint_define$CommonLabel();
                try {
                    appoint_define_commonlabel.mergeFrom(byteArray);
                    List<ByteStringMicro> list = appoint_define_commonlabel.rpt_interst_name.get();
                    List<Integer> list2 = appoint_define_commonlabel.rpt_interst_type.get();
                    JSONArray jSONArray = new JSONArray();
                    if (list.size() == list2.size()) {
                        for (int i17 = 0; i17 < list.size(); i17++) {
                            String stringUtf8 = list.get(i17).toStringUtf8();
                            nearbyPeopleCard2.commonLabels.add(stringUtf8);
                            jSONArray.mo162put(stringUtf8);
                        }
                    }
                    nearbyPeopleCard2.commonLabelString = jSONArray.toString();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("NearbyCardHandler", 2, "commonLabel exception:" + e16.getMessage());
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 4, "collegeId=" + nowSummaryCard$RespNearbySummaryCard.school_id.get());
            }
            nearbyPeopleCard2.updateDisplayPicInfos(nowSummaryCard$RespNearbySummaryCard.date_face.get().toByteArray(), null, nearbyPeopleCard2.isHostSelf);
            long j17 = nearbyPeopleCard2.userFlag;
            if ((2 & j17) != 0) {
                z18 = true;
                nearbyPeopleCard2.switchQzone = true;
                z19 = false;
            } else {
                z18 = true;
                z19 = false;
                nearbyPeopleCard2.switchQzone = false;
            }
            if ((j17 & 4) != 0) {
                nearbyPeopleCard2.switchHobby = z18;
            } else {
                nearbyPeopleCard2.switchHobby = z19;
            }
            if (!nearbyPeopleCard2.isPhotoUseCache()) {
                nearbyPeopleCard2.qzonePicUrl_1 = "";
                nearbyPeopleCard2.qzonePicUrl_2 = "";
                nearbyPeopleCard2.qzonePicUrl_3 = "";
            }
            if (nowSummaryCard$RespNearbySummaryCard.interest_tag.has()) {
                long j18 = nowSummaryCard$RespNearbySummaryCard.interest_tag.flag.get();
                try {
                    cmd0x9c5$RspBody cmd0x9c5_rspbody = new cmd0x9c5$RspBody();
                    cmd0x9c5_rspbody.mergeFrom(nowSummaryCard$RespNearbySummaryCard.interest_tag.tag_info.get().toByteArray());
                    nearbyPeopleCard2.updateInterestTags(j18, cmd0x9c5_rspbody.msg_interest_tags.get());
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i("InterestTag", 2, e17.toString());
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "stInterestTag is null");
            }
            if (nowSummaryCard$RespNearbySummaryCard.gift_info.has()) {
                nearbyPeopleCard2.switchGiftVisible = nowSummaryCard$RespNearbySummaryCard.gift_info.get().open_flag.get();
                nearbyPeopleCard2.vGiftInfo = nowSummaryCard$RespNearbySummaryCard.gift_info.get().toByteArray();
            }
            if (nowSummaryCard$RespNearbySummaryCard.vote_info.has()) {
                NowSummaryCard$VoteInfo nowSummaryCard$VoteInfo = nowSummaryCard$RespNearbySummaryCard.vote_info.get();
                nearbyPeopleCard2.likeCount = nowSummaryCard$VoteInfo.vote_count.get();
                nearbyPeopleCard2.likeCountInc = nowSummaryCard$VoteInfo.latest_vote_count.get();
                if (QLog.isColorLevel()) {
                    QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "handleGetSummaryCard likeCount:" + nearbyPeopleCard2.likeCount + " newVoteCountInc:" + nearbyPeopleCard2.likeCountInc);
                }
            }
            if (nearbyPeopleCard2.nearbyInfo != null) {
                nearby$Cmd0x1RspBody nearby_cmd0x1rspbody = new nearby$Cmd0x1RspBody();
                try {
                    nearby_cmd0x1rspbody.mergeFrom(nearbyPeopleCard2.nearbyInfo);
                    if (i3 == 51) {
                        nearbyPeopleCard2.isForbidSendMsgForTribar = nearby_cmd0x1rspbody.uint32_if_mask_msg.get() == 1;
                        nearbyPeopleCard2.isForbidSendGiftMsgForTribar = nearby_cmd0x1rspbody.uint32_if_mask_gift.get() == 1;
                        nearbyPeopleCard2.disableSendMsgBtnTipsForTribar = nearby_cmd0x1rspbody.bytes_mask_msg_reason.get().toStringUtf8();
                        nearbyPeopleCard2.disableSendGiftBtnTipsForTribar = nearby_cmd0x1rspbody.bytes_mask_gift_reason.get().toStringUtf8();
                    } else {
                        int i18 = nearby_cmd0x1rspbody.uint32_if_mask_msg.get();
                        nearbyPeopleCard2.maskMsgFlag = i18;
                        nearbyPeopleCard2.isForbidSendMsg = i18 == 1;
                        nearbyPeopleCard2.isForbidSendGiftMsg = nearby_cmd0x1rspbody.uint32_if_mask_gift.get() == 1;
                        nearbyPeopleCard2.disableSendMsgBtnTips = nearby_cmd0x1rspbody.bytes_mask_msg_reason.get().toStringUtf8();
                        nearbyPeopleCard2.disableSendGiftBtnTips = nearby_cmd0x1rspbody.bytes_mask_gift_reason.get().toStringUtf8();
                    }
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 2, "handleGetSummaryCard, comeFromType=" + i3 + ", maskMsgFlag=" + nearby_cmd0x1rspbody.uint32_if_mask_msg.get() + ", maskMsgTip=" + nearby_cmd0x1rspbody.bytes_mask_msg_reason.get().toStringUtf8() + ", curUin=" + this.f252549e.getCurrentAccountUin());
                        } else {
                            QLog.d(LogTag.TAG_NEARBY_BIND_PHONE, 1, "handleGetSummaryCard, comeFromType=" + i3 + ", maskMsgFlag=" + nearby_cmd0x1rspbody.uint32_if_mask_msg.get() + ", maskMsgTip=" + nearby_cmd0x1rspbody.bytes_mask_msg_reason.get().toStringUtf8());
                        }
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            QLog.e("NearbyCardHandler", 2, "log exp:" + e18.toString());
                        }
                    }
                    nearbyPeopleCard2.highScoreNum = nearby_cmd0x1rspbody.uint32_high_score_num.get();
                    if (nearby_cmd0x1rspbody.bytes_face_score_config.has()) {
                        nearbyPeopleCard2.faceScoreIconUrl = nearby_cmd0x1rspbody.bytes_face_score_config.get().bytes_icon_url.get().toStringUtf8();
                        nearbyPeopleCard2.faceScoreTailWording = nearby_cmd0x1rspbody.bytes_face_score_config.get().bytes_tail_wording.get().toStringUtf8();
                        nearbyPeopleCard2.faceScoreTailWordingColor = nearby_cmd0x1rspbody.bytes_face_score_config.get().uint32_tail_wording_color.get();
                        nearbyPeopleCard2.faceScoreWording = nearby_cmd0x1rspbody.bytes_face_score_config.get().bytes_card_wording.get().toStringUtf8();
                        nearbyPeopleCard2.faceScoreWordingColor = nearby_cmd0x1rspbody.bytes_face_score_config.get().uint32_card_wording_color.get();
                        nearbyPeopleCard2.entryAbility = nearby_cmd0x1rspbody.bytes_face_score_config.get().uint32_entry_ability.get();
                    } else {
                        nearbyPeopleCard2.faceScoreIconUrl = "";
                        nearbyPeopleCard2.faceScoreTailWording = "";
                        nearbyPeopleCard2.faceScoreTailWordingColor = 0;
                        nearbyPeopleCard2.faceScoreWording = "";
                        nearbyPeopleCard2.faceScoreWordingColor = 0;
                        nearbyPeopleCard2.entryAbility = 0;
                    }
                    nearbyPeopleCard2.isSendMsgBtnDownloadAppOpen = nearby_cmd0x1rspbody.uint32_jump_app_open.get() == 1;
                    nearbyPeopleCard2.sendMsgBtnDownloadAppTips = nearby_cmd0x1rspbody.str_jump_app_result_msg.get();
                    nearbyPeopleCard2.tribeAppDownloadPageUrl = nearby_cmd0x1rspbody.str_jump_app_url.get();
                    nearbyPeopleCard2.addPicBtnDownloadAppTips = nearby_cmd0x1rspbody.str_plus_download_app_msg.get();
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.NEARBY_TRIBE_APP_DOWNLOAD, 2, "handleGetSummaryCard, uin=" + nearbyPeopleCard2.uin + ", isSendMsgBtnDownloadAppOpen=" + nearbyPeopleCard2.isSendMsgBtnDownloadAppOpen + ", isAddPicBtnDownloadAppOpen:" + nearbyPeopleCard2.isAddPicBtnDownloadAppOpen() + ", sendMsgBtnDownloadAppTips:" + nearbyPeopleCard2.sendMsgBtnDownloadAppTips + ", addPicBtnDownloadAppTips=" + nearbyPeopleCard2.addPicBtnDownloadAppTips + ", tribeAppDownloadPageUrl=" + nearbyPeopleCard2.tribeAppDownloadPageUrl);
                    }
                    nearbyPeopleCard2.firstOfficialMsg = nearby_cmd0x1rspbody.bytes_official_wording.get().toStringUtf8();
                    nearbyPeopleCard2.unverifyGrayTips = nearby_cmd0x1rspbody.bytes_aio_grey_tips_wording.get().toStringUtf8();
                    if (nearby_cmd0x1rspbody.nearby_popover_info.has()) {
                        nearbyPeopleCard2.guideAppNowTip = nearby_cmd0x1rspbody.nearby_popover_info.tip_content.get();
                        nearbyPeopleCard2.guideAppNowTipLeftBtn = nearby_cmd0x1rspbody.nearby_popover_info.tip_left_btn.get();
                        nearbyPeopleCard2.guideAppNowTipRightBtnInstalled = nearby_cmd0x1rspbody.nearby_popover_info.tip_right_btn_installed.get();
                        nearbyPeopleCard2.guideAppNowTipRightBtnNotInstalled = nearby_cmd0x1rspbody.nearby_popover_info.tip_right_btn_not_installed.get();
                        nearbyPeopleCard2.guideAppNowPackage = nearby_cmd0x1rspbody.nearby_popover_info.android_app_key.get();
                        nearbyPeopleCard2.guideAppNowJumpUri = nearby_cmd0x1rspbody.nearby_popover_info.jump_uri.get();
                        nearbyPeopleCard2.guideAppNowDownloadUrl = nearby_cmd0x1rspbody.nearby_popover_info.app_download_url.get();
                        nearbyPeopleCard2.guideVerifiedDialogTitle = nearby_cmd0x1rspbody.nearby_popover_info.tip_title.get();
                        nearbyPeopleCard2.guideVerifiedDialogRightBtnText = nearby_cmd0x1rspbody.nearby_popover_info.tip_right_btn.get();
                        if (QLog.isColorLevel()) {
                            QLog.i("NearbyCardHandler", 2, "nearby_popover_info=\nnearCard.guideAppNowTip=" + nearbyPeopleCard2.guideAppNowTip + "\nnearCard.guideAppNowTipLeftBtn=" + nearbyPeopleCard2.guideAppNowTipLeftBtn + "\nnearCard.guideAppNowTipRightBtnInstall=" + nearbyPeopleCard2.guideAppNowTipRightBtnInstalled + "\nnearCard.guideAppNowTipRightBtnNotInstalled=" + nearbyPeopleCard2.guideAppNowTipRightBtnNotInstalled + "\nnearCard.guideAppNowPackage=" + nearbyPeopleCard2.guideAppNowPackage + "\nnearCard.guideAppNowJumpUri=" + nearbyPeopleCard2.guideAppNowJumpUri + "\nnearCard.guideAppNowDownloadUrl=" + nearbyPeopleCard2.guideAppNowDownloadUrl + "\nnearCard.guideVerifiedDialogTitle=" + nearbyPeopleCard2.guideVerifiedDialogTitle + "\nnearCard.guideVerifiedDialogRightBtnText=" + nearbyPeopleCard2.guideVerifiedDialogRightBtnText + "\n");
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.i("NearbyCardHandler", 2, "(nearbyInfo.nearby_popover_info not has");
                    }
                } catch (InvalidProtocolBufferMicroException unused2) {
                    if (QLog.isColorLevel()) {
                        QLog.d("NearbyCardHandler", 2, "decode nearbyInfo failed!");
                    }
                }
            }
            nearbyPeopleCard2.nearbyNowDataBytes = nowSummaryCard$RespNearbySummaryCard.now_info.get().toByteArray();
            try {
                cmd0xac5$NearbyNowData cmd0xac5_nearbynowdata2 = new cmd0xac5$NearbyNowData();
                cmd0xac5_nearbynowdata2.mergeFrom(nearbyPeopleCard2.nearbyNowDataBytes);
                if (QLog.isColorLevel()) {
                    QLog.d("NearbyCardHandler", 2, "handleGetSummaryCard, hasMoreUrl=" + cmd0xac5_nearbynowdata2.bytes_more_video_url.has() + ", hasVideoList=" + cmd0xac5_nearbynowdata2.rpt_msg_now_video_feed.has() + ", hasAnchorList=" + cmd0xac5_nearbynowdata2.rpt_msg_now_follow_anchor.has());
                }
                cmd0xac5_nearbynowdata = cmd0xac5_nearbynowdata2;
            } catch (Exception e19) {
                if (QLog.isColorLevel()) {
                    QLog.w("NearbyCardHandler", 2, "handleGetSummaryCard, exp:" + e19.toString());
                }
                cmd0xac5_nearbynowdata = null;
            }
            nearbyPeopleCard2.nearbyNowData = cmd0xac5_nearbynowdata;
            notifyUI(51, true, (Object) nearbyPeopleCard2, z17);
            NearbyCardManager nearbyCardManager = (NearbyCardManager) this.f252549e.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
            if (i3 == 51) {
                nearbyCardManager.j(nearbyPeopleCard2.uin, SystemClock.elapsedRealtime());
            } else {
                nearbyCardManager.i(String.valueOf(nearbyPeopleCard2.tinyId), SystemClock.elapsedRealtime());
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("NearbyCardHandler", 4, " addProfileCardUpdateTime2Cache tinyId/time: " + nearbyPeopleCard2.tinyId + " " + SystemClock.elapsedRealtime());
            }
            FriendsManager friendsManager = (FriendsManager) this.f252549e.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (nearbyPeopleCard2.isHostSelf) {
                Card q16 = friendsManager.q(nearbyPeopleCard2.uin);
                q16.iVoteIncrement = nearbyPeopleCard2.likeCountInc;
                q16.lVoteCount = nearbyPeopleCard2.likeCount;
                e.v(this.f252549e.getAccount(), q16.lVoteCount, q16.iVoteIncrement);
                try {
                    friendsManager.p0(q16);
                    e.t(this.f252549e.getAccount(), INearbySPUtil.SP_KEY_SELF_SCHOOL_NAME, nearbyPeopleCard2.college);
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            if (nearbyPeopleCard2.isHostSelf && nearbyPeopleCard2.charmLevel > 0) {
                ((ay) this.f252549e.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(nearbyPeopleCard2.charmLevel);
            }
            friendsManager.G0(nearbyPeopleCard2);
            if (nearbyPeopleCard2.getStatus() == 1000) {
                EntityManager entityManager2 = entityManager;
                Cursor doQueryCursorOperateByTransaction = entityManager2.doQueryCursorOperateByTransaction(new QueryTransaction(false, cls.getSimpleName(), (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null, (String) null));
                ArrayList arrayList = new ArrayList();
                if (doQueryCursorOperateByTransaction != null) {
                    int count = doQueryCursorOperateByTransaction.getCount();
                    doQueryCursorOperateByTransaction.moveToFirst();
                    if (count > 200) {
                        while (true) {
                            int i19 = count - 1;
                            if (count <= 100) {
                                break;
                            }
                            doQueryCursorOperateByTransaction.moveToNext();
                            count = i19;
                        }
                        int i26 = doQueryCursorOperateByTransaction.getInt(doQueryCursorOperateByTransaction.getColumnIndex("_id"));
                        arrayList.add(new ExecSQLTransaction("delete from " + cls.getSimpleName() + " where _id < " + (i26 < 0 ? 0 : i26) + ";"));
                    }
                }
                arrayList.add(new PersistOrReplaceTransaction(nearbyPeopleCard2));
                entityManager2.doMultiDBOperateByTransaction(arrayList);
                if (doQueryCursorOperateByTransaction != null) {
                    doQueryCursorOperateByTransaction.close();
                    return;
                }
                return;
            }
            EntityManager entityManager3 = entityManager;
            if (nearbyPeopleCard2.getStatus() == 1001 || nearbyPeopleCard2.getStatus() == 1002) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new UpdateTransaction(nearbyPeopleCard2));
                entityManager3.doMultiDBOperateByTransaction(arrayList2);
                return;
            }
            return;
        }
        notifyUI(51, false, (Object) null, z26);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type update terminated with stack overflow, arg: (r14v21 ??), method size: 3822
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private void a3(boolean r33, java.lang.Object r34, android.os.Bundle r35, SummaryCard.RespHead r36) {
        /*
            Method dump skipped, instructions count: 3822
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.nearby.business.NearbyCardHandler.a3(boolean, java.lang.Object, android.os.Bundle, SummaryCard.RespHead):void");
    }

    private void b3(NearbyPeopleCard nearbyPeopleCard, byte[] bArr) {
        w msgService = ((IKernelService) this.f252550f.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.d("NearbyCardHandler", 1, "prepareNearbyTempChatSignature fail, IMsgService is null");
            return;
        }
        TempChatPrepareInfo tempChatPrepareInfo = new TempChatPrepareInfo(106, String.valueOf(nearbyPeopleCard.tinyId), nearbyPeopleCard.nickname, "", bArr, this.f252550f.getCurrentUid(), "", new TempChatGameSession());
        if (QLog.isDebugVersion()) {
            QLog.d("NearbyCardHandler", 4, "prepareNearbyTempChatSignature, uid=" + nearbyPeopleCard.tinyId + ", nick=" + nearbyPeopleCard.nickname + ", sig=" + Base64.encode(bArr));
        }
        msgService.prepareTempChat(tempChatPrepareInfo, new IOperateCallback() { // from class: l92.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                NearbyCardHandler.Y2(i3, str);
            }
        });
    }

    private long e3(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    @Override // l92.a
    public void A2(long j3, long j16, byte[] bArr, int i3, int i16, int i17) {
        if (QLog.isDevelopLevel()) {
            QLog.i(LogTag.PROFILE_CARD, 4, String.format("nearbyPeopleLike|%d|%d|likeSource=%d", Long.valueOf(j16), Integer.valueOf(i16), Integer.valueOf(i3)));
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(j3), "VisitorSvc.ReqFavorite");
        toServiceMsg.extraData.putLong("selfUin", j3);
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, j16);
        toServiceMsg.extraData.putByteArray("vCookies", bArr);
        toServiceMsg.extraData.putBoolean("nearby_people", true);
        toServiceMsg.extraData.putInt("favoriteSource", i3);
        toServiceMsg.extraData.putInt(FloatCacheData.ICOUNT, i16);
        toServiceMsg.extraData.putInt("from", i17);
        send(toServiceMsg);
    }

    @Override // l92.a
    public void G(Bundle bundle, ArrayList<Object> arrayList, Object[] objArr, boolean z16, boolean z17, boolean z18, boolean z19) {
        boolean z26;
        cmd0x9c7$ReqBody cmd0x9c7_reqbody;
        int i3;
        int i16;
        int i17;
        ToServiceMsg makeOIDBPkg;
        byte[] byteArray;
        UpdatePhotoList$RichHead updatePhotoList$RichHead;
        m92.a[] aVarArr = (m92.a[]) objArr;
        if (l92.b.f414007a && QLog.isColorLevel()) {
            QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "editProfileCard");
        }
        cmd0x9c9$ReqBody cmd0x9c9_reqbody = new cmd0x9c9$ReqBody();
        if (arrayList == null || arrayList.size() <= 0) {
            z26 = false;
        } else {
            UpdatePhotoList$ReqBody updatePhotoList$ReqBody = new UpdatePhotoList$ReqBody();
            Iterator<Object> it = arrayList.iterator();
            z26 = false;
            while (it.hasNext()) {
                PicInfo picInfo = (PicInfo) it.next();
                if (picInfo.f258916d >= 0) {
                    updatePhotoList$RichHead = new UpdatePhotoList$RichHead();
                    updatePhotoList$RichHead.uint32_headid.set(picInfo.f258916d);
                    if (!TextUtils.isEmpty(picInfo.C)) {
                        updatePhotoList$RichHead.str_video_id.set(picInfo.C);
                    }
                } else {
                    updatePhotoList$RichHead = null;
                }
                if (updatePhotoList$RichHead != null) {
                    updatePhotoList$ReqBody.rpt_msg_rich_headids.add(updatePhotoList$RichHead);
                    z26 = true;
                }
            }
            if (z26) {
                appoint_define$LBSInfo b16 = c.b(getClass().getSimpleName());
                if (b16 != null) {
                    updatePhotoList$ReqBody.msg_lbs_info.set(b16);
                }
                cmd0x9c9_reqbody.bytes_reqbody_5ea.set(ByteStringMicro.copyFrom(updatePhotoList$ReqBody.toByteArray()));
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "editProfileCard, photoList = " + arrayList + ", isHasNearbyAvatar = " + z26);
            }
        }
        if (aVarArr == null || aVarArr.length <= 0) {
            cmd0x9c7_reqbody = null;
        } else {
            cmd0x9c7_reqbody = new cmd0x9c7$ReqBody();
            cmd0x9c7_reqbody.uint32_set_mode.set(0);
            for (m92.a aVar : aVarArr) {
                if (aVar != null) {
                    cmd0x9c7_reqbody.rpt_msg_tags.add((appoint_define$InterestTag) ((IInterestTagUtils) QRoute.api(IInterestTagUtils.class)).convertTo(aVar));
                }
            }
            cmd0x9c9_reqbody.bytes_reqbody_9c7.set(ByteStringMicro.copyFrom(cmd0x9c7_reqbody.toByteArray()));
            if (l92.b.f414007a && QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                for (m92.a aVar2 : aVarArr) {
                    sb5.append(aVar2.toString());
                    sb5.append(",");
                }
                QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "editProfileCard, tags = " + sb5.toString());
            }
        }
        if (bundle != null) {
            if (bundle.containsKey("nick")) {
                String string = bundle.getString("nick");
                cmd0x9c9_reqbody.str_nick.set(string);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "str_nick|" + string);
                }
                i16 = 1;
            } else {
                i16 = 0;
            }
            if (bundle.containsKey("sex")) {
                i16++;
                int i18 = bundle.getByte("sex") + 1;
                cmd0x9c9_reqbody.uint32_gender.set(i18);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "uint32_gender|" + i18);
                }
            }
            if (bundle.containsKey(IProfileProtocolConst.KEY_COLLEGE)) {
                i16++;
                String string2 = bundle.getString(IProfileProtocolConst.KEY_COLLEGE);
                cmd0x9c9_reqbody.str_college.set(string2);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "str_college|" + string2);
                }
            }
            if (bundle.containsKey(IProfileProtocolConst.KEY_CONSTELLATION)) {
                i16++;
                int i19 = bundle.getInt(IProfileProtocolConst.KEY_CONSTELLATION);
                cmd0x9c9_reqbody.uint32_constellation.set(i19);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "uint32_constellation|" + i19);
                }
            }
            if (bundle.containsKey("birthday")) {
                i16++;
                int i26 = bundle.getInt("birthday");
                cmd0x9c9_reqbody.bytes_birthday.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(i26)));
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "bytes_birthday|" + i26);
                }
            }
            if (bundle.containsKey(IProfileProtocolConst.KET_INTERESTS) && (byteArray = bundle.getByteArray(IProfileProtocolConst.KET_INTERESTS)) != null) {
                cmd0x9c9_reqbody.bytes_reqbody_tag.set(ByteStringMicro.copyFrom(byteArray));
            }
            if (bundle.containsKey(IProfileProtocolConst.KEY_HOMETOWN)) {
                i16 += 2;
                byte[] bArr = new byte[12];
                String[] stringArray = bundle.getStringArray(IProfileProtocolConst.KEY_HOMETOWN);
                for (int i27 = 0; i27 < 3; i27++) {
                    PkgTools.copyData(bArr, i27 * 4, PkgTools.intToBytes2(ConditionSearchManager.p(stringArray[i27])), 4);
                }
                cmd0x9c9_reqbody.bytes_hometown.set(ByteStringMicro.copyFrom(bArr));
                cmd0x9c9_reqbody.bytes_hometown_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(ConditionSearchManager.p(stringArray[3]))));
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    for (String str : stringArray) {
                        sb6.append(str);
                        sb6.append(", ");
                    }
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "bytes_city_id|" + sb6.toString());
                }
            }
            if (bundle.containsKey("location")) {
                i16 += 2;
                byte[] bArr2 = new byte[12];
                String[] stringArray2 = bundle.getStringArray("location");
                for (int i28 = 0; i28 < 3; i28++) {
                    PkgTools.copyData(bArr2, i28 * 4, PkgTools.intToBytes2(ConditionSearchManager.p(stringArray2[i28])), 4);
                }
                cmd0x9c9_reqbody.bytes_location.set(ByteStringMicro.copyFrom(bArr2));
                cmd0x9c9_reqbody.bytes_location_district.set(ByteStringMicro.copyFrom(PkgTools.intToBytes2(ConditionSearchManager.p(stringArray2[3]))));
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    StringBuilder sb7 = new StringBuilder();
                    for (String str2 : stringArray2) {
                        sb7.append(str2);
                        sb7.append(", ");
                    }
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "bytes_location|" + sb7.toString());
                }
            }
            if (bundle.containsKey("age")) {
                i16++;
                cmd0x9c9_reqbody.uint32_age.set(bundle.getInt("age"));
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "set birthday|age = " + bundle.getInt("age"));
                }
            }
            if (bundle.containsKey(IProfileProtocolConst.KEY_COMPANY)) {
                i16++;
                String string3 = bundle.getString(IProfileProtocolConst.KEY_COMPANY);
                cmd0x9c9_reqbody.str_company.set(string3);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "str_company|" + string3);
                }
            }
            if (bundle.containsKey("key_new_nickname")) {
                i16++;
                String string4 = bundle.getString("key_new_nickname");
                cmd0x9c9_reqbody.str_stranger_nick.set(string4);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "str_stranger_nick|" + string4);
                }
            }
            if (bundle.containsKey("key_xuan_yan")) {
                i16++;
                byte[] byteArray2 = bundle.getByteArray("key_xuan_yan");
                if (byteArray2 != null) {
                    cmd0x9c9_reqbody.bytes_stranger_declare.set(ByteStringMicro.copyFrom(byteArray2));
                }
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("str_stranger_declare|");
                    sb8.append(byteArray2 == null ? "null" : Integer.valueOf(byteArray2.length));
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, sb8.toString());
                }
            }
            if (bundle.containsKey("key_marital_status")) {
                i16++;
                byte b17 = bundle.getByte("key_marital_status");
                cmd0x9c9_reqbody.uint32_love_status.set(b17);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "uint32_love_status|" + ((int) b17));
                }
            }
            if (bundle.containsKey(IProfileProtocolConst.KEY_PROFESSION)) {
                int i29 = bundle.getInt(IProfileProtocolConst.KEY_PROFESSION);
                if (NearbyProfileUtil.g(i29)) {
                    i16++;
                    cmd0x9c9_reqbody.uint32_profession.set(i29);
                }
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "uint32_profession|" + i29);
                }
            }
            if (bundle.containsKey("key_qzone_switch")) {
                i16++;
                short s16 = bundle.getShort("key_qzone_switch");
                cmd0x9c9_reqbody.uint32_qzone_visible.set(s16);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "uint32_qzone_visible|" + ((int) s16));
                }
            }
            if (bundle.containsKey("key_hobby_switch")) {
                i16++;
                short s17 = bundle.getShort("key_hobby_switch");
                cmd0x9c9_reqbody.uint32_interest_visible.set(s17);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "uint32_interest_visible|" + ((int) s17));
                }
            }
            if (bundle.containsKey("key_flower_visible_switch")) {
                i16++;
                short s18 = bundle.getShort("key_flower_visible_switch");
                cmd0x9c9_reqbody.uint32_gift_visible.set(s18);
                if (l92.b.f414007a && QLog.isColorLevel()) {
                    QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "uint32_gift_visible|" + ((int) s18));
                }
            }
            i3 = 1;
        } else {
            i3 = 1;
            i16 = 0;
        }
        int i36 = i16 + i3;
        cmd0x9c9_reqbody.uint32_stranger_profile_flag.set(i3);
        if (z26) {
            cmd0x9c9_reqbody.uint32_face_flag.set(i3);
        }
        cmd0x9c9_reqbody.uint32_guide_flag.set(0);
        if (l92.b.f414007a && QLog.isColorLevel()) {
            QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "fieldCount|" + i36);
        }
        if (z19) {
            makeOIDBPkg = makeOIDBPkg("OidbSvc.0x9c9_1", 2505, 1, cmd0x9c9_reqbody.toByteArray());
            i17 = 0;
        } else {
            i17 = 0;
            makeOIDBPkg = makeOIDBPkg("OidbSvc.0x9c9_0", 2505, 0, cmd0x9c9_reqbody.toByteArray());
        }
        if (bundle != null) {
            makeOIDBPkg.extraData.putAll(bundle);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            makeOIDBPkg.extraData.putParcelable("avatar_picinfo", (Parcelable) arrayList.get(i17));
        }
        makeOIDBPkg.extraData.putByteArray("9c7_body", cmd0x9c7_reqbody == null ? null : cmd0x9c7_reqbody.toByteArray());
        makeOIDBPkg.extraData.putBoolean("is_lost_god_flag", z16);
        makeOIDBPkg.extraData.putBoolean("is_head_changed", z17);
        makeOIDBPkg.extraData.putLong("startSaveTime", SystemClock.elapsedRealtime());
        sendPbReq(makeOIDBPkg);
    }

    public void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        Long l3;
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("NearbyCardHandler", 2, "handleGetRandomUserInfo");
        }
        Oidb_0x66b$RspBody oidb_0x66b$RspBody = new Oidb_0x66b$RspBody();
        if (OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x66b$RspBody) == 0) {
            oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
            if (oidb_0x66b$RspBody.bytes_rspbody_5eb.has()) {
                try {
                    oidb_0x5eb_rspbody.mergeFrom(oidb_0x66b$RspBody.bytes_rspbody_5eb.get().toByteArray());
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.has() && oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get().get(0);
                        l3 = Long.valueOf(oidb_0x5eb_udcuindata.uint64_uin.get());
                        str = oidb_0x5eb_udcuindata.bytes_stranger_nick.get().toStringUtf8();
                        i3 = oidb_0x5eb_udcuindata.uint32_gender.get();
                        i16 = oidb_0x5eb_udcuindata.uint32_age.get();
                    } else {
                        str = "";
                        l3 = null;
                        i3 = -1;
                        i16 = 0;
                    }
                    notifyUI(13, true, new Object[]{l3, str, Integer.valueOf(i3), Integer.valueOf(i16)});
                    if (QLog.isDevelopLevel()) {
                        QLog.d("NearbyCardHandler", 2, "handleGetRandomUserInfo---->uin =" + l3 + "nickName = " + str + " gender = " + i3 + "age =" + i16);
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("NearbyCardHandler", 2, "fail to decode 5eb_rspBody", e16);
                    }
                }
            }
        }
        notifyUI(13, false, new Object[]{-1, null, -1, -1});
    }

    public void T2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0xb5b$RspBody cmd0xb5b_rspbody = new cmd0xb5b$RspBody();
            OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xb5b_rspbody);
            QLog.i(LogTag.NEARBY_NOW, 1, "handleNotifyFaceChange code:" + cmd0xb5b_rspbody.result.get() + "   " + cmd0xb5b_rspbody.err_msg.get());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.NEARBY_NOW, 2, "handleNotifyFaceChange req == null || res == null");
        }
    }

    @Override // l92.a
    public void W1(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("NearbyCardHandler", 2, "getRandomUserInfo| uin = " + str);
        }
        Oidb_0x66b$ReqBody oidb_0x66b$ReqBody = new Oidb_0x66b$ReqBody();
        oidb_0x5eb$ReqBody oidb_0x5eb_reqbody = new oidb_0x5eb$ReqBody();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Long.valueOf(Long.parseLong(str)));
        oidb_0x5eb_reqbody.rpt_uint64_uins.set(arrayList);
        oidb_0x5eb_reqbody.uint32_req_nick.set(1);
        oidb_0x5eb_reqbody.uint32_req_stranger_nick.set(1);
        oidb_0x5eb_reqbody.uint32_req_gender.set(1);
        oidb_0x5eb_reqbody.uint32_req_god_flag.set(1);
        oidb_0x5eb_reqbody.uint32_req_age.set(1);
        oidb_0x66b$ReqBody.bytes_reqbody_5eb.set(ByteStringMicro.copyFrom(oidb_0x5eb_reqbody.toByteArray()));
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, oidb_0x66b$ReqBody.toByteArray());
        makeOIDBPkg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        send(makeOIDBPkg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.f252548d == null) {
            HashSet hashSet = new HashSet();
            this.f252548d = hashSet;
            hashSet.add(ProfileCardServlet.CMD_REQ_SUMMARY_CARD);
            this.f252548d.add("OidbSvc.0x9c8_0");
            this.f252548d.add("OidbSvc.0x9c5_0");
            this.f252548d.add("OidbSvc.0x9c9_0");
            this.f252548d.add("OidbSvc.0x9c9_1");
            this.f252548d.add("OidbSvc.0x9c7_0");
            this.f252548d.add("OidbSvc.0x682");
            this.f252548d.add(ProfileContants.CMD_REQ_NEARBY_CHARM_EVENT);
            this.f252548d.add(ProfileContants.CMD_UPDATE_NEARBY_PEOPLE_PHOTO_LIST);
            this.f252548d.add(ProfileContants.CMD_IMPORT_QZONE_PHOTOES);
            this.f252548d.add(ProfileContants.CMD_QUERY_IMPORT_QZONE_PHOTOES_STATUS);
            this.f252548d.add("SQQzoneSvc.getCover");
            this.f252548d.add(ProfileContants.CMD_SET_NEARBY_PEOPLE_VIDEO_ID);
            this.f252548d.add(ProfileContants.CMD_DELETE_NEARBY_PEOPLE_VIDEO_ID);
            this.f252548d.add("VisitorSvc.ReqFavorite");
            this.f252548d.add("OidbSvc.0x66b");
            this.f252548d.add("OidbSvc.0x66b");
            this.f252548d.add("OidbSvc.0x66b");
            this.f252548d.add("OidbSvc.0x8e6_1");
            this.f252548d.add("OidbSvc.0x8e7_1");
            this.f252548d.add("OidbSvc.0xb5b");
        }
        return this.f252548d;
    }

    @Override // l92.a
    public void h2(String str, String str2, int i3, long j3, byte b16, long j16, long j17, byte[] bArr, String str3, long j18, int i16, byte[] bArr2, long j19, boolean z16, boolean z17, long j26, boolean z18, long j27, int i17) {
        long j28;
        long j29;
        long e36 = e3(str);
        long e37 = e3(str2);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            j28 = e37;
            sb5.append("getSummaryCard()");
            sb5.append(",selfUin = ");
            sb5.append(str);
            sb5.append(",destUin = ");
            sb5.append(str2);
            sb5.append(",comeFromType = ");
            sb5.append(i3);
            sb5.append(",qzoneFeedTimeStamp = ");
            sb5.append(j3);
            sb5.append(",isFriend = ");
            sb5.append((int) b16);
            sb5.append(",troopCode = ");
            sb5.append(j16);
            sb5.append(",troopUin = ");
            sb5.append(j17);
            sb5.append(",vseed = ");
            sb5.append(bArr);
            sb5.append(",strSearchName = ");
            sb5.append(str3);
            sb5.append(",lGetControl = ");
            sb5.append(j18);
            sb5.append(",nAddFriendSource = ");
            j29 = e36;
            sb5.append(i16);
            sb5.append(", vSecureSig = ");
            sb5.append(bArr2);
            sb5.append(", tinyId = ");
            sb5.append(j19);
            sb5.append(", isNearbyPeopleCard = ");
            sb5.append(z16);
            sb5.append(",uLikeSource = ");
            sb5.append(j26);
            QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, sb5.toString());
        } else {
            j28 = e37;
            j29 = e36;
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(str), ProfileCardServlet.CMD_REQ_SUMMARY_CARD);
        toServiceMsg.extraData.putLong("selfUin", j29);
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TARGET_UIN, j28);
        toServiceMsg.extraData.putInt(IProfileProtocolConst.PARAM_COME_FROM_TYPE, i3);
        toServiceMsg.extraData.putLong("qzoneFeedTimeStamp", j3);
        toServiceMsg.extraData.putByte(IProfileProtocolConst.PARAM_IS_FRIEND, b16);
        toServiceMsg.extraData.putLong(IProfileProtocolConst.PARAM_TROOP_CODE, j16);
        toServiceMsg.extraData.putLong("troopUin", j17);
        toServiceMsg.extraData.putByteArray("vSeed", bArr);
        toServiceMsg.extraData.putString("strSearchName", str3);
        toServiceMsg.extraData.putLong("lGetControl", j18);
        toServiceMsg.extraData.putInt("bReqCommLabel", 1);
        toServiceMsg.extraData.putInt("EAddFriendSource", i16);
        toServiceMsg.extraData.putByteArray("vSecureSig", bArr2);
        toServiceMsg.extraData.putLong("tinyId", j19);
        toServiceMsg.extraData.putBoolean("isNearbyPeopleCard", z16);
        toServiceMsg.extraData.putBoolean("partlyRefresh", z17);
        toServiceMsg.extraData.putLong("startFetchTime", SystemClock.elapsedRealtime());
        toServiceMsg.extraData.putLong("likeSource", j26);
        toServiceMsg.extraData.putLong("nowId", j27);
        toServiceMsg.extraData.putInt("nowUserType", i17);
        if (z18) {
            send(toServiceMsg);
        } else {
            H2(j27, i17, i3, j19, str2, b16, toServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return d.class;
    }

    @Override // l92.a
    public void F0(String str, int i3) {
        notifyUI(10, true, new Object[]{str, Integer.valueOf(i3)});
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        bz.g(this, 9, toServiceMsg, fromServiceMsg, obj);
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        long j3;
        char c16;
        boolean z16;
        String str3;
        String str4;
        long j16;
        NearbyCardHandler nearbyCardHandler;
        boolean z17;
        String str5;
        long j17;
        boolean z18;
        if (toServiceMsg.extraData.getBoolean("nearby_people")) {
            Object attribute = fromServiceMsg.getAttribute("result");
            HashMap<String, String> hashMap = new HashMap<>();
            Bundle bundle = new Bundle();
            long j18 = toServiceMsg.extraData.getLong(IProfileProtocolConst.PARAM_TARGET_UIN);
            long j19 = toServiceMsg.extraData.getLong("selfUin");
            int i3 = toServiceMsg.extraData.getInt("favoriteSource");
            int i16 = toServiceMsg.extraData.getInt(FloatCacheData.ICOUNT);
            int i17 = toServiceMsg.extraData.getInt("from");
            bundle.putString(IProfileProtocolConst.PARAM_TARGET_UIN, Long.toString(j18));
            bundle.putString("selfUin", Long.toString(j19));
            bundle.putInt("favoriteSource", i3);
            bundle.putInt(FloatCacheData.ICOUNT, i16);
            bundle.putInt("from", i17);
            if (attribute == null || !(attribute instanceof RespFavorite)) {
                str = ",";
                if (!QLog.isColorLevel()) {
                    str2 = LogTag.PROFILE_CARD;
                    j3 = j18;
                    c16 = 2;
                    z16 = false;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("back reqFavorite| result = ");
                    z16 = false;
                    sb5.append(false);
                    sb5.append(str);
                    j3 = j18;
                    sb5.append(j3);
                    sb5.append(",obj is");
                    if (attribute != null) {
                        str5 = "not RespFavorite";
                    } else {
                        str5 = "null";
                    }
                    sb5.append(str5);
                    String sb6 = sb5.toString();
                    str2 = LogTag.PROFILE_CARD;
                    c16 = 2;
                    QLog.i(str2, 2, sb6);
                }
                if (attribute != null) {
                    str3 = "-201";
                } else {
                    str3 = "-202";
                }
                hashMap.put("param_FailCode", str3);
                str4 = str2;
                j16 = j3;
                nearbyCardHandler = this;
                StatisticCollector.getInstance(this.f252550f.getApp()).collectPerformance(String.valueOf(j19), "profileCardSendFavorite", false, 0L, 0L, hashMap, "", false);
                z17 = false;
            } else {
                RespFavorite respFavorite = (RespFavorite) attribute;
                if (respFavorite.stHeader.iReplyCode == 0) {
                    hashMap.put("param_FailCode", "0");
                    z18 = true;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.PROFILE_CARD, 2, "back reqFavorite| result = false," + j18 + ",replyCode=" + respFavorite.stHeader.iReplyCode);
                    }
                    hashMap.put("param_FailCode", String.valueOf(respFavorite.stHeader.iReplyCode));
                    z18 = false;
                }
                nearbyCardHandler = this;
                str = ",";
                StatisticCollector.getInstance(nearbyCardHandler.f252550f.getApp()).collectPerformance(String.valueOf(j19), "profileCardSendFavorite", z18, 0L, 0L, hashMap, "", false);
                z17 = z18;
                str4 = LogTag.PROFILE_CARD;
                j16 = j18;
            }
            if (z17) {
                j17 = j16;
                if (j17 > 0) {
                    EntityManager createEntityManager = nearbyCardHandler.f252549e.getEntityManagerFactory().createEntityManager();
                    NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{String.valueOf(j17)});
                    if (nearbyPeopleCard != null) {
                        nearbyPeopleCard.likeCount += i16;
                        nearbyPeopleCard.bVoted = (byte) 1;
                        short s16 = (short) (nearbyPeopleCard.bAvailVoteCnt - i16);
                        nearbyPeopleCard.bAvailVoteCnt = s16;
                        if (s16 < 0) {
                            nearbyPeopleCard.bAvailVoteCnt = (short) 0;
                        }
                        createEntityManager.update(nearbyPeopleCard);
                    }
                    dc.b(nearbyCardHandler.f252549e, j17, i16);
                }
            } else {
                j17 = j16;
            }
            if (QLog.isColorLevel()) {
                QLog.i(str4, 2, "back reqFavorite| result = " + z17 + str + j17 + str + i16);
            }
            nearbyCardHandler.notifyUI(32, z17, bundle);
        }
    }

    private void c3(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        Oidb_0x686$NearbyCharmNotify oidb_0x686$NearbyCharmNotify;
        try {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            int i3 = oidb_sso_oidbssopkg.uint32_result.get();
            boolean z16 = i3 == 0;
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.NEARBY, 2, "rspNearbyCharmEvent,result code\uff1a" + i3 + ",isSuccess:" + z16);
            }
            if (z16) {
                Oidb_0x686$RspBody oidb_0x686$RspBody = new Oidb_0x686$RspBody();
                int i16 = oidb_sso_oidbssopkg.uint32_service_type.get();
                oidb_0x686$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                if (oidb_0x686$RspBody.uint32_config_seq.has()) {
                    e.s(this.f252550f.getCurrentAccountUin(), INearbySPUtil.SP_FILE_NAME_NEWFRESH, 0, INearbySPUtil.TOPLIST_SP_HIDE_BOYGOD_SEQ, Integer.valueOf(oidb_0x686$RspBody.uint32_config_seq.get()));
                }
                if (oidb_0x686$RspBody.uint32_config_time.has()) {
                    e.s(this.f252550f.getCurrentAccountUin(), INearbySPUtil.SP_FILE_NAME_NEWFRESH, 0, INearbySPUtil.KEY_LAST_CONFIG_TIME, Integer.valueOf(oidb_0x686$RspBody.uint32_config_time.get()));
                }
                Oidb_0x686$CharmEvent oidb_0x686$CharmEvent = null;
                Oidb_0x686$NearbyRankConfig oidb_0x686$NearbyRankConfig = oidb_0x686$RspBody.msg_rank_config.has() ? oidb_0x686$RspBody.msg_rank_config.get() : null;
                Oidb_0x686$NearbyFeedConfig oidb_0x686$NearbyFeedConfig = oidb_0x686$RspBody.msg_feed_config.has() ? oidb_0x686$RspBody.msg_feed_config.get() : null;
                if (i16 == 2 && oidb_0x686$RspBody.msg_charm_event.has()) {
                    oidb_0x686$CharmEvent = oidb_0x686$RspBody.msg_charm_event.get();
                    oidb_0x686$NearbyCharmNotify = null;
                } else {
                    oidb_0x686$NearbyCharmNotify = (i16 == 1 && oidb_0x686$RspBody.msg_notify_event.has()) ? oidb_0x686$RspBody.msg_notify_event.get() : null;
                }
                h.b(this.f252549e).c(toServiceMsg.getUin(), oidb_0x686$NearbyRankConfig, oidb_0x686$NearbyFeedConfig, oidb_0x686$CharmEvent, oidb_0x686$NearbyCharmNotify);
                String str = "";
                if (oidb_0x686$CharmEvent != null && oidb_0x686$CharmEvent.uint32_pop_flag.get() == 1) {
                    int i17 = oidb_0x686$CharmEvent.uint32_old_charm.get();
                    int i18 = oidb_0x686$CharmEvent.uint32_old_charm_level.get();
                    int i19 = oidb_0x686$CharmEvent.uint32_new_charm.get();
                    int i26 = oidb_0x686$CharmEvent.uint32_new_charm_level.get();
                    int i27 = oidb_0x686$CharmEvent.uint32_cur_level_threshold.get();
                    int i28 = oidb_0x686$CharmEvent.uint32_next_level_threshold.get();
                    String str2 = oidb_0x686$CharmEvent.str_tips_content.get();
                    Object[] objArr = new Object[8];
                    objArr[0] = Boolean.FALSE;
                    objArr[1] = Integer.valueOf(i17);
                    objArr[2] = Integer.valueOf(i18);
                    objArr[3] = Integer.valueOf(i19);
                    objArr[4] = Integer.valueOf(i26);
                    objArr[5] = Integer.valueOf(i27);
                    objArr[6] = Integer.valueOf(i28);
                    if (str2 != null) {
                        str = str2;
                    }
                    objArr[7] = str;
                    notifyUI(60, true, objArr);
                    String str3 = "0X80052B1";
                    if (i19 - i17 < 0) {
                        str3 = "0X80052B2";
                    }
                    String str4 = str3;
                    g.a(this.f252550f, "CliOper", "", "", str4, str4, 0, 0, "", "", "", "");
                    return;
                }
                if (oidb_0x686$NearbyCharmNotify == null || oidb_0x686$NearbyCharmNotify.uint32_pop_flag.get() != 1) {
                    return;
                }
                int i29 = oidb_0x686$NearbyCharmNotify.uint32_old_charm.get();
                int i36 = oidb_0x686$NearbyCharmNotify.uint32_old_charm_level.get();
                int i37 = oidb_0x686$NearbyCharmNotify.uint32_new_charm.get();
                int i38 = oidb_0x686$NearbyCharmNotify.uint32_new_charm_level.get();
                int i39 = oidb_0x686$NearbyCharmNotify.uint32_cur_level_threshold.get();
                int i46 = oidb_0x686$NearbyCharmNotify.uint32_next_level_threshold.get();
                int i47 = oidb_0x686$NearbyCharmNotify.uint32_old_prof_percent.get();
                int i48 = oidb_0x686$NearbyCharmNotify.uint32_new_prof_percent.get();
                String str5 = oidb_0x686$NearbyCharmNotify.str_tips_content.get();
                Object[] objArr2 = new Object[9];
                objArr2[0] = Integer.valueOf(i29);
                objArr2[1] = Integer.valueOf(i36);
                objArr2[2] = Integer.valueOf(i37);
                objArr2[3] = Integer.valueOf(i38);
                objArr2[4] = Integer.valueOf(i39);
                objArr2[5] = Integer.valueOf(i46);
                objArr2[6] = Integer.valueOf(i47);
                objArr2[7] = Integer.valueOf(i48);
                if (str5 != null) {
                    str = str5;
                }
                objArr2[8] = str;
                notifyUI(61, true, objArr2);
                String str6 = "0X80052AE";
                if (i37 - i29 < 0) {
                    str6 = "0X80052AF";
                }
                String str7 = str6;
                g.a(this.f252550f, "CliOper", "", "", str7, str7, 0, 0, "", "", "", "");
            }
        } catch (Exception e16) {
            if (QLog.isDevelopLevel()) {
                QLog.e("NearbyCardHandler", 2, e16, new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x011f A[Catch: Exception -> 0x0168, TryCatch #1 {Exception -> 0x0168, blocks: (B:22:0x00fc, B:24:0x011f, B:41:0x0128, B:43:0x0132, B:44:0x013a, B:46:0x0142, B:47:0x0152), top: B:21:0x00fc }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void R2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        int i3;
        long j3;
        long j16;
        oidb_0x8e7$RspBody oidb_0x8e7_rspbody = new oidb_0x8e7$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x8e7_rspbody);
        String string = toServiceMsg.extraData.getString("uin", "");
        int i16 = toServiceMsg.extraData.getInt("from", 509);
        String str2 = "NearbyLikeLimitManager";
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "handleNearbyLikeLimitInfo, uin=" + string + ", ret=" + parseOIDBPkg);
        }
        if (parseOIDBPkg == 0) {
            try {
                c.C8137c c8137c = new c.C8137c();
                c8137c.f252567c = oidb_0x8e7_rspbody.bytes_recharge_url.get().toStringUtf8();
                c8137c.f252568d = oidb_0x8e7_rspbody.bytes_update_url.get().toStringUtf8();
                if (!oidb_0x8e7_rspbody.msg_zan_limit.has()) {
                    return;
                }
                oidb_0x8e7$ZanLimitInfo oidb_0x8e7_zanlimitinfo = oidb_0x8e7_rspbody.msg_zan_limit.get();
                c8137c.f252565a = (int) oidb_0x8e7_zanlimitinfo.uint64_level.get();
                c8137c.f252570f = (int) oidb_0x8e7_zanlimitinfo.uint64_can_free_zan_user_limit.get();
                c8137c.f252571g = (int) oidb_0x8e7_zanlimitinfo.uint64_free_zan_total_limit.get();
                c8137c.f252566b = (int) oidb_0x8e7_zanlimitinfo.uint64_price.get();
                c8137c.f252573i = (int) oidb_0x8e7_zanlimitinfo.uint64_free_zan_user.get();
                ArrayList arrayList = new ArrayList();
                if (oidb_0x8e7_zanlimitinfo.rpt_msg_user_zan_info.has()) {
                    Iterator<oidb_0x8e7$UserZanInfo> it = oidb_0x8e7_zanlimitinfo.rpt_msg_user_zan_info.get().iterator();
                    while (it.hasNext()) {
                        oidb_0x8e7$UserZanInfo next = it.next();
                        c.a aVar = new c.a();
                        try {
                            if (next.uint64_uin.has()) {
                                j16 = next.uint64_uin.get();
                            } else if (next.uint64_tinyid.has()) {
                                j16 = next.uint64_tinyid.get();
                            } else {
                                str = str2;
                                j3 = 0;
                                aVar.f252553a = j3;
                                Iterator<oidb_0x8e7$UserZanInfo> it5 = it;
                                aVar.f252554b = (int) next.uint64_free_zan.get();
                                aVar.f252555c = (int) next.uint64_pay_zan.get();
                                aVar.f252556d = (int) next.uint64_pay_stock.get();
                                if (j3 <= 0) {
                                    arrayList.add(aVar);
                                }
                                str2 = str;
                                it = it5;
                            }
                            aVar.f252553a = j3;
                            Iterator<oidb_0x8e7$UserZanInfo> it52 = it;
                            aVar.f252554b = (int) next.uint64_free_zan.get();
                            aVar.f252555c = (int) next.uint64_pay_zan.get();
                            aVar.f252556d = (int) next.uint64_pay_stock.get();
                            if (j3 <= 0) {
                            }
                            str2 = str;
                            it = it52;
                        } catch (Exception e16) {
                            e = e16;
                            i3 = 14;
                            notifyUI(i3, false, string);
                            if (QLog.isColorLevel()) {
                                return;
                            }
                            QLog.e(str, 2, "handleNearbyLikeLimitInfo, " + e.toString());
                            return;
                        }
                        str = str2;
                        j3 = j16;
                    }
                }
                str = str2;
                if (oidb_0x8e7_rspbody.msg_warn.has()) {
                    c8137c.f252569e = oidb_0x8e7_rspbody.msg_warn.get();
                }
                if (oidb_0x8e7_rspbody.msg_stock_rsp.has()) {
                    c8137c.f252572h = oidb_0x8e7_rspbody.msg_stock_rsp.get().int32_total.get();
                }
                ((com.tencent.mobileqq.nearby.c) this.f252549e.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).c(c8137c, arrayList, i16);
                i3 = 14;
                try {
                    notifyUI(14, true, string);
                } catch (Exception e17) {
                    e = e17;
                    notifyUI(i3, false, string);
                    if (QLog.isColorLevel()) {
                    }
                }
            } catch (Exception e18) {
                e = e18;
                str = str2;
            }
        } else {
            notifyUI(14, false, string);
        }
    }

    public void S2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList arrayList;
        int i3;
        int i16 = toServiceMsg.extraData.getInt("from", 0);
        oidb_0x8e6$RspBody oidb_0x8e6_rspbody = new oidb_0x8e6$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x8e6_rspbody);
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew, ret=" + parseOIDBPkg + ", from=" + i16);
        }
        ArrayList arrayList2 = new ArrayList();
        if (parseOIDBPkg == 0) {
            int i17 = oidb_0x8e6_rspbody.uint32_level.get();
            int i18 = oidb_0x8e6_rspbody.uint32_can_vote_free_user_count.get();
            int i19 = oidb_0x8e6_rspbody.uint32_can_vote_free_count.get();
            oidb_0x8e6_rspbody.uint32_remain_total.get();
            com.tencent.mobileqq.nearby.c cVar = (com.tencent.mobileqq.nearby.c) this.f252549e.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER);
            List<oidb_0x8e6$VoteResult> list = oidb_0x8e6_rspbody.rpt_vote_result.get();
            int size = list.size();
            int i26 = 0;
            while (i26 < size) {
                oidb_0x8e6$VoteResult oidb_0x8e6_voteresult = list.get(i26);
                c.b bVar = new c.b();
                bVar.f252558a = oidb_0x8e6_voteresult.uint32_ret.get();
                bVar.f252559b = oidb_0x8e6_voteresult.bytes_err_msg.get().toStringUtf8();
                int i27 = i17;
                bVar.f252560c = oidb_0x8e6_voteresult.uint64_uin.get();
                bVar.f252561d = oidb_0x8e6_voteresult.uint32_succ_free_vote_count.get();
                bVar.f252562e = oidb_0x8e6_voteresult.uint32_succ_pay_vote_count.get();
                bVar.f252563f = oidb_0x8e6_voteresult.uint32_vote_count.get();
                bVar.f252564g = (int) oidb_0x8e6_voteresult.uint64_pay_stock.get();
                arrayList2.add(bVar);
                int i28 = bVar.f252561d + bVar.f252562e;
                if (bVar.f252558a == 0) {
                    i3 = i18;
                    long j3 = bVar.f252560c;
                    if (j3 <= 0 || i28 <= 0) {
                        arrayList = arrayList2;
                    } else {
                        dc.b(this.f252549e, j3, i28);
                        EntityManager createEntityManager = this.f252549e.getEntityManagerFactory().createEntityManager();
                        arrayList = arrayList2;
                        NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{String.valueOf(bVar.f252560c)});
                        if (nearbyPeopleCard != null) {
                            nearbyPeopleCard.likeCount += i28;
                            nearbyPeopleCard.bVoted = (byte) 1;
                            short s16 = (short) (nearbyPeopleCard.bAvailVoteCnt - i28);
                            nearbyPeopleCard.bAvailVoteCnt = s16;
                            if (s16 < 0) {
                                nearbyPeopleCard.bAvailVoteCnt = (short) 0;
                            }
                            createEntityManager.update(nearbyPeopleCard);
                        }
                    }
                } else {
                    arrayList = arrayList2;
                    i3 = i18;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("NearbyLikeLimitManager", 2, "handleNearbyPeopleLikeNew: " + bVar);
                }
                cVar.a(bVar.f252560c + "", true);
                i26++;
                i17 = i27;
                i18 = i3;
                arrayList2 = arrayList;
            }
            cVar.b(i17, i18, i19);
            notifyUI(15, true, new Object[]{arrayList2, Integer.valueOf(i16)});
            return;
        }
        notifyUI(15, false, new Object[]{arrayList2, Integer.valueOf(i16)});
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0286  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        NearbyPeopleCard nearbyPeopleCard;
        boolean z16;
        EntityManager entityManager;
        if (l92.b.f414007a && QLog.isColorLevel()) {
            QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "handleEditProfileCard");
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            cmd0x9c9$RspBody cmd0x9c9_rspbody = new cmd0x9c9$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x9c9_rspbody);
            long elapsedRealtime = SystemClock.elapsedRealtime() - toServiceMsg.extraData.getLong("startSaveTime");
            boolean z17 = toServiceMsg.extraData.containsKey("is_head_changed") ? toServiceMsg.extraData.getBoolean("is_head_changed") : false;
            String str = "";
            if (parseOIDBPkg == 0) {
                QQAppInterface qQAppInterface = this.f252549e;
                EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory(qQAppInterface.getAccount()).createEntityManager();
                NearbyPeopleCard nearbyPeopleCard2 = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{this.f252549e.getCurrentAccountUin()});
                if (nearbyPeopleCard2 == null) {
                    nearbyPeopleCard2 = new NearbyPeopleCard();
                    nearbyPeopleCard2.uin = this.f252549e.getCurrentAccountUin();
                    if (QLog.isColorLevel()) {
                        QLog.i("NearbyCardHandler", 2, "handleEditProfileCard get nearbyCard from db is null.");
                    }
                }
                NearbyPeopleCard nearbyPeopleCard3 = nearbyPeopleCard2;
                if (toServiceMsg.extraData.getBoolean("is_lost_god_flag")) {
                    nearbyPeopleCard3.godFlag = false;
                }
                List<PicInfo> updateEditPicInfos = nearbyPeopleCard3.updateEditPicInfos(cmd0x9c9_rspbody.bytes_rspbody_5ea.has() ? cmd0x9c9_rspbody.bytes_rspbody_5ea.get().toByteArray() : null, (PicInfo) toServiceMsg.extraData.getParcelable("avatar_picinfo"));
                if (updateEditPicInfos != null && !updateEditPicInfos.isEmpty()) {
                    e.t(this.f252549e.getAccount(), INearbySPUtil.SP_KEY_UPLOAD_AVATAR_OK, 1);
                }
                byte[] byteArray = toServiceMsg.extraData.getByteArray("9c7_body");
                if (byteArray == null || byteArray.length <= 0) {
                    entityManager = createEntityManager;
                } else {
                    try {
                        cmd0x9c7$ReqBody cmd0x9c7_reqbody = new cmd0x9c7$ReqBody();
                        cmd0x9c7_reqbody.mergeFrom(byteArray);
                        entityManager = createEntityManager;
                        try {
                            nearbyPeopleCard3.updateInterestTags(nearbyPeopleCard3.tagFlag, cmd0x9c7_reqbody.rpt_msg_tags.get());
                        } catch (Exception e16) {
                            e = e16;
                            if (l92.b.f414007a && QLog.isColorLevel()) {
                                QLog.d(LogTag.NEARBY_PEOPLE_CARD, 2, "rsp_9c7" + e.getMessage());
                            }
                            if (toServiceMsg.extraData.containsKey("key_xuan_yan")) {
                            }
                            if (toServiceMsg.extraData.containsKey("key_new_nickname")) {
                            }
                            if (toServiceMsg.extraData.containsKey("key_marital_status")) {
                            }
                            if (toServiceMsg.extraData.containsKey("sex")) {
                            }
                            if (toServiceMsg.extraData.containsKey("birthday")) {
                            }
                            if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_PROFESSION)) {
                            }
                            if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_COMPANY)) {
                            }
                            if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_COLLEGE)) {
                            }
                            if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_HOMETOWN)) {
                            }
                            if (toServiceMsg.extraData.containsKey("key_qzone_switch")) {
                            }
                            if (toServiceMsg.extraData.containsKey("key_hobby_switch")) {
                            }
                            if (toServiceMsg.extraData.containsKey("key_flower_visible_switch")) {
                            }
                            if (nearbyPeopleCard3.getStatus() != 1000) {
                            }
                            nearbyPeopleCard = nearbyPeopleCard3;
                            z16 = true;
                            notifyUI(3, z16, new Object[]{nearbyPeopleCard, Boolean.valueOf(z17), str});
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("errorCode", String.valueOf(parseOIDBPkg));
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f252550f.getCurrentAccountUin(), "actEditNearbyProfile", z16, elapsedRealtime, 0L, hashMap, "");
                            l.c(LogTag.NEARBY_PEOPLE_CARD, "handle_oidb_0x9c9_0", Integer.valueOf(parseOIDBPkg), Boolean.valueOf(z16), nearbyPeopleCard, str);
                            return;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        entityManager = createEntityManager;
                    }
                }
                if (toServiceMsg.extraData.containsKey("key_xuan_yan")) {
                    nearbyPeopleCard3.xuanYan = toServiceMsg.extraData.getByteArray("key_xuan_yan");
                }
                if (toServiceMsg.extraData.containsKey("key_new_nickname")) {
                    nearbyPeopleCard3.nickname = toServiceMsg.extraData.getString("key_new_nickname");
                }
                if (toServiceMsg.extraData.containsKey("key_marital_status")) {
                    nearbyPeopleCard3.maritalStatus = toServiceMsg.extraData.getByte("key_marital_status");
                }
                if (toServiceMsg.extraData.containsKey("sex")) {
                    nearbyPeopleCard3.gender = toServiceMsg.extraData.getByte("sex");
                    NearbyCardManager nearbyCardManager = (NearbyCardManager) this.f252549e.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                    if (nearbyCardManager != null) {
                        nearbyCardManager.d(nearbyPeopleCard3.gender);
                    }
                }
                if (toServiceMsg.extraData.containsKey("birthday")) {
                    nearbyPeopleCard3.birthday = toServiceMsg.extraData.getInt("birthday");
                    nearbyPeopleCard3.age = toServiceMsg.extraData.getInt("age");
                    nearbyPeopleCard3.constellation = (byte) toServiceMsg.extraData.getInt(IProfileProtocolConst.KEY_CONSTELLATION);
                    NearbyCardManager nearbyCardManager2 = (NearbyCardManager) this.f252549e.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                    if (nearbyCardManager2 != null) {
                        nearbyCardManager2.a(nearbyPeopleCard3.age);
                    }
                }
                if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_PROFESSION)) {
                    nearbyPeopleCard3.job = toServiceMsg.extraData.getInt(IProfileProtocolConst.KEY_PROFESSION);
                }
                if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_COMPANY)) {
                    nearbyPeopleCard3.company = toServiceMsg.extraData.getString(IProfileProtocolConst.KEY_COMPANY);
                }
                if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_COLLEGE)) {
                    nearbyPeopleCard3.college = toServiceMsg.extraData.getString(IProfileProtocolConst.KEY_COLLEGE);
                    try {
                        e.t(this.f252549e.getCurrentAccountUin(), INearbySPUtil.SP_KEY_SELF_SCHOOL_NAME, nearbyPeopleCard3.college);
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                if (toServiceMsg.extraData.containsKey(IProfileProtocolConst.KEY_HOMETOWN)) {
                    String[] stringArray = toServiceMsg.extraData.getStringArray(IProfileProtocolConst.KEY_HOMETOWN);
                    nearbyPeopleCard3.hometownCountry = stringArray[0];
                    nearbyPeopleCard3.hometownProvice = stringArray[1];
                    nearbyPeopleCard3.hometownCity = stringArray[2];
                    nearbyPeopleCard3.hometownDistrict = stringArray[3];
                }
                if (toServiceMsg.extraData.containsKey("key_qzone_switch")) {
                    nearbyPeopleCard3.switchQzone = toServiceMsg.extraData.getShort("key_qzone_switch") == 0;
                }
                if (toServiceMsg.extraData.containsKey("key_hobby_switch")) {
                    nearbyPeopleCard3.switchHobby = toServiceMsg.extraData.getShort("key_hobby_switch") == 0;
                }
                if (toServiceMsg.extraData.containsKey("key_flower_visible_switch")) {
                    nearbyPeopleCard3.switchGiftVisible = toServiceMsg.extraData.getShort("key_flower_visible_switch") == 0 ? 0L : 1L;
                }
                if (nearbyPeopleCard3.getStatus() != 1000) {
                    entityManager.persistOrReplace(nearbyPeopleCard3);
                } else {
                    EntityManager entityManager2 = entityManager;
                    if (nearbyPeopleCard3.getStatus() == 1001 || nearbyPeopleCard3.getStatus() == 1002) {
                        entityManager2.update(nearbyPeopleCard3);
                    }
                }
                nearbyPeopleCard = nearbyPeopleCard3;
                z16 = true;
            } else {
                if (cmd0x9c9_rspbody.str_errorinfo.has()) {
                    str = cmd0x9c9_rspbody.str_errorinfo.get();
                }
                nearbyPeopleCard = null;
                z16 = false;
            }
            notifyUI(3, z16, new Object[]{nearbyPeopleCard, Boolean.valueOf(z17), str});
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("errorCode", String.valueOf(parseOIDBPkg));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f252550f.getCurrentAccountUin(), "actEditNearbyProfile", z16, elapsedRealtime, 0L, hashMap2, "");
            l.c(LogTag.NEARBY_PEOPLE_CARD, "handle_oidb_0x9c9_0", Integer.valueOf(parseOIDBPkg), Boolean.valueOf(z16), nearbyPeopleCard, str);
            return;
        }
        notifyUI(3, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f A[Catch: Exception -> 0x0085, TryCatch #0 {Exception -> 0x0085, blocks: (B:44:0x0080, B:28:0x0089, B:30:0x008f, B:33:0x00a6, B:41:0x00a0), top: B:43:0x0080 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        RespHead respHead;
        boolean z16;
        Object valueOf;
        if (toServiceMsg.extraData.getBoolean("isNearbyPeopleCard")) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - toServiceMsg.extraData.getLong("startFetchTime");
            if (QLog.isColorLevel()) {
                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, "handleGetSummaryCard() , resp.getResultCode() = " + fromServiceMsg.getResultCode());
            }
            long currentTimeMillis = QLog.isDevelopLevel() ? System.currentTimeMillis() : 0L;
            String valueOf2 = String.valueOf(fromServiceMsg.getResultCode());
            boolean z17 = true;
            boolean z18 = fromServiceMsg.isSuccess() && (obj instanceof RespSummaryCard);
            RespHead respHead2 = null;
            if (z18) {
                try {
                    respHead = (RespHead) decodePacket(fromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
                    if (respHead != null) {
                        try {
                            if (respHead.iResult == 0) {
                                if (QLog.isColorLevel()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("handleGetSummaryCard() , SummaryCard.RespHead.iResult = ");
                                    if (respHead == null) {
                                        valueOf = "null";
                                    } else {
                                        valueOf = Integer.valueOf(respHead.iResult);
                                    }
                                    sb5.append(valueOf);
                                    QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, sb5.toString());
                                }
                                z16 = z17;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            respHead2 = respHead;
                            if (QLog.isColorLevel()) {
                                QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 2, e.toString());
                            }
                            respHead = respHead2;
                            z16 = false;
                            a3(z16, obj, toServiceMsg.extraData, respHead);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("errorCode", valueOf2);
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f252550f.getCurrentAccountUin(), "actGetNearbySummaryCard", z16, elapsedRealtime, 0L, hashMap, "");
                            if (QLog.isDevelopLevel()) {
                            }
                        }
                    }
                    z17 = false;
                    if (QLog.isColorLevel()) {
                    }
                    z16 = z17;
                } catch (Exception e17) {
                    e = e17;
                }
            } else {
                respHead = null;
                z16 = z18;
            }
            a3(z16, obj, toServiceMsg.extraData, respHead);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("errorCode", valueOf2);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.f252550f.getCurrentAccountUin(), "actGetNearbySummaryCard", z16, elapsedRealtime, 0L, hashMap2, "");
            if (QLog.isDevelopLevel()) {
                return;
            }
            QLog.i(LifeAchievementBusinessProcessor.SUMMARY_CARD_TAG, 4, "handleGetSummaryCard, cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v11 */
    private void V2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        char c16;
        ?? r65;
        int i3;
        int i16;
        String string;
        String str;
        String str2;
        ArrayList arrayList;
        int i17;
        ArrayList arrayList2;
        String str3 = "";
        if (toServiceMsg == null) {
            c16 = 2;
            r65 = 0;
            i3 = 1;
            i16 = 8;
        } else {
            if (fromServiceMsg != null) {
                Bundle bundle = toServiceMsg.extraData;
                if (bundle == null) {
                    string = "";
                } else {
                    string = bundle.getString(QCircleSchemeAttr.Detail.KEY_WORD);
                }
                Bundle bundle2 = toServiceMsg.extraData;
                if (bundle2 != null) {
                    bundle2.getInt("tag_type");
                }
                Bundle bundle3 = toServiceMsg.extraData;
                int i18 = bundle3 == null ? -1 : bundle3.getInt("fetch_start");
                Bundle bundle4 = toServiceMsg.extraData;
                int i19 = bundle4 == null ? -1 : bundle4.getInt("person_flag");
                cmd0x9c8$RspBody cmd0x9c8_rspbody = new cmd0x9c8$RspBody();
                int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x9c8_rspbody);
                if (parseOIDBPkg == 0) {
                    int i26 = cmd0x9c8_rspbody.uint32_tag_type.has() ? cmd0x9c8_rspbody.uint32_tag_type.get() : -1;
                    int i27 = cmd0x9c8_rspbody.uint32_next_pos.has() ? cmd0x9c8_rspbody.uint32_next_pos.get() : -1;
                    List<appoint_define$InterestItem> list = cmd0x9c8_rspbody.rpt_msg_tag_list.has() ? cmd0x9c8_rspbody.rpt_msg_tag_list.get() : null;
                    List<appoint_define$InterestItem> list2 = cmd0x9c8_rspbody.rpt_msg_sel_list.has() ? cmd0x9c8_rspbody.rpt_msg_sel_list.get() : null;
                    QQAppInterface qQAppInterface = this.f252549e;
                    EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory(qQAppInterface.getAccount()).createEntityManager();
                    boolean z16 = i18 == 0 && TextUtils.isEmpty(string) && list != null && !list.isEmpty();
                    if (!z16) {
                        str = "handle_oidb_0x9c8_0";
                        str2 = LogTag.NEARBY_PEOPLE_CARD;
                    } else {
                        DBMethodProxy.execSQL(createEntityManager, "DELETE FROM " + InterestTagInfo.class.getSimpleName() + " WHERE tagType = " + i26 + ";");
                        SharedPreferences.Editor edit = this.f252549e.getApplication().getSharedPreferences("dating_pref" + this.f252549e.getCurrentAccountUin(), 0).edit();
                        str = "handle_oidb_0x9c8_0";
                        str2 = LogTag.NEARBY_PEOPLE_CARD;
                        edit.putLong("list_last_update_time_" + i26, NetConnInfoCenter.getServerTimeMillis());
                        edit.putInt("list_fetch_pos_" + i26, i27);
                        edit.commit();
                    }
                    if (list == null || list.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (int i28 = 0; i28 < list.size(); i28++) {
                            InterestTagInfo interestTagInfo = (InterestTagInfo) ((IInterestTagInfoUtils) QRoute.api(IInterestTagInfoUtils.class)).convertFrom(list.get(i28));
                            if (interestTagInfo != null) {
                                interestTagInfo.tagType = i26;
                                arrayList.add(interestTagInfo);
                                if (z16) {
                                    createEntityManager.persist(interestTagInfo);
                                }
                            }
                        }
                    }
                    createEntityManager.close();
                    if (list2 == null || list2.isEmpty()) {
                        i17 = 8;
                        arrayList2 = null;
                    } else {
                        arrayList2 = new ArrayList();
                        for (int i29 = 0; i29 < list2.size(); i29++) {
                            InterestTagInfo interestTagInfo2 = (InterestTagInfo) ((IInterestTagInfoUtils) QRoute.api(IInterestTagInfoUtils.class)).convertFrom(list2.get(i29));
                            if (interestTagInfo2 != null) {
                                arrayList2.add(interestTagInfo2);
                            }
                        }
                        i17 = 8;
                    }
                    Object[] objArr = new Object[i17];
                    objArr[0] = Integer.valueOf(i26);
                    objArr[1] = Integer.valueOf(i27);
                    objArr[2] = arrayList;
                    objArr[3] = arrayList2;
                    objArr[4] = string;
                    objArr[5] = Integer.valueOf(i18);
                    objArr[6] = Integer.valueOf(i19);
                    objArr[7] = null;
                    notifyUI(1, true, objArr);
                    l.c(str2, str, Integer.valueOf(parseOIDBPkg), Boolean.TRUE, Integer.valueOf(i26), Integer.valueOf(i27), arrayList, arrayList2, string, Integer.valueOf(i18), Integer.valueOf(i19));
                    return;
                }
                if (cmd0x9c8_rspbody.str_error.has()) {
                    str3 = cmd0x9c8_rspbody.str_error.get();
                }
                notifyUI(1, false, new Object[]{-1, -1, null, null, string, Integer.valueOf(i18), Integer.valueOf(i19), str3});
                l.c(LogTag.NEARBY_PEOPLE_CARD, "handle_oidb_0x9c8_0", Integer.valueOf(parseOIDBPkg), Boolean.FALSE, str3);
                return;
            }
            i16 = 8;
            c16 = 2;
            r65 = 0;
            i3 = 1;
        }
        Object[] objArr2 = new Object[i16];
        objArr2[r65] = -1;
        objArr2[i3] = -1;
        objArr2[c16] = null;
        objArr2[3] = null;
        objArr2[4] = "";
        objArr2[5] = -1;
        objArr2[6] = -1;
        objArr2[7] = HardCodeUtil.qqStr(R.string.oeq);
        notifyUI(i3, r65, objArr2);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg == null || fromServiceMsg == null || msgCmdFilter(fromServiceMsg.getServiceCmd())) {
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (ProfileCardServlet.CMD_REQ_SUMMARY_CARD.equals(fromServiceMsg.getServiceCmd())) {
            P2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x9c8_0".equals(serviceCmd)) {
            V2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if ("OidbSvc.0x9c5_0".equals(serviceCmd)) {
            L2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (!"OidbSvc.0x9c9_0".equals(serviceCmd) && !"OidbSvc.0x9c9_1".equals(serviceCmd)) {
            if ("OidbSvc.0x9c7_0".equals(serviceCmd)) {
                bz.i(this, 4, toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0x682".equals(serviceCmd)) {
                O2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (ProfileContants.CMD_REQ_NEARBY_CHARM_EVENT.equals(fromServiceMsg.getServiceCmd())) {
                c3(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (ProfileContants.CMD_UPDATE_NEARBY_PEOPLE_PHOTO_LIST.equals(fromServiceMsg.getServiceCmd())) {
                X2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (ProfileContants.CMD_IMPORT_QZONE_PHOTOES.equals(fromServiceMsg.getServiceCmd())) {
                Q2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (ProfileContants.CMD_SET_NEARBY_PEOPLE_VIDEO_ID.equals(fromServiceMsg.getServiceCmd())) {
                W2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (ProfileContants.CMD_DELETE_NEARBY_PEOPLE_VIDEO_ID.equals(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if (ProfileContants.CMD_QUERY_IMPORT_QZONE_PHOTOES_STATUS.equals(fromServiceMsg.getServiceCmd())) {
                U2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("SQQzoneSvc.getCover".equals(fromServiceMsg.getServiceCmd())) {
                M2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("VisitorSvc.ReqFavorite".equals(fromServiceMsg.getServiceCmd())) {
                K2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0x66b".equals(fromServiceMsg.getServiceCmd())) {
                N2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0x8e7_1".equals(fromServiceMsg.getServiceCmd())) {
                R2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("OidbSvc.0x8e6_1".equals(fromServiceMsg.getServiceCmd())) {
                S2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0xb5b".equals(fromServiceMsg.getServiceCmd())) {
                    T2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        J2(toServiceMsg, fromServiceMsg, obj);
    }

    private void L2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }
}
