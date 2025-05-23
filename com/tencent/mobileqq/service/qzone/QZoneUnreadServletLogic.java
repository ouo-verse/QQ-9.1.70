package com.tencent.mobileqq.service.qzone;

import BOSSStrategyCenter.tAdvDesc;
import NS_QBOSS_GATEWAY_PROTO.QbossGateWayRsp;
import NS_QMALL_COVER.PassiveFeedsPush;
import NS_QMALL_COVER.QzmallCustomBubbleSkin;
import NS_UNDEAL_COUNT.count_info;
import NS_UNDEAL_COUNT.entrance_cfg;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.master_info;
import NS_UNDEAL_COUNT.mobile_count_req;
import NS_UNDEAL_COUNT.mobile_count_rsp_new;
import NS_UNDEAL_COUNT.operat_data;
import NS_UNDEAL_COUNT.single_count;
import NS_UNDEAL_COUNT.stMomentInfo;
import NS_UNDEAL_COUNT.stNuanNuanComment;
import NS_UNDEAL_COUNT.stPlusRecomInfo;
import NS_UNDEAL_COUNT.stSoftInfo;
import NS_UNDEAL_COUNT.stVerticalVideoDisplay;
import NS_UNDEAL_COUNT.yellow_info;
import QZONE_OPERATION_ENTRANCE.OperEntranceInfo;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qzone.publish.business.protocol.QZonePublishMoodRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.servlet.QZoneNotifyServlet;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import com.tencent.qzonehub.api.IQzoneMixApi;
import com.tencent.qzonehub.api.IQzoneUndealCountApi;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import cooperation.qzone.UndealCount.QZoneCountUserInfo;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import cooperation.qzone.util.JceUtils;
import cooperation.qzone.util.PhotoUtils;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneTeenOnlineTimeHelper;
import cooperation.vip.manager.i;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QZoneUnreadServletLogic {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<Integer, HashMap<Integer, QZoneCountInfo>> f286396a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75014);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f286396a = new HashMap<>();
        }
    }

    private static void A(mobile_count_rsp_new mobile_count_rsp_newVar) {
        Map<String, String> map;
        if (mobile_count_rsp_newVar != null && (map = mobile_count_rsp_newVar.holidayInfo) != null) {
            a.f286399a.h(map);
        } else {
            RFWLog.i("UndealCount.QZoneUnreadServletLogic", RFWLog.USR, "handleHolidayInfo holidayInfo is null");
        }
    }

    public static void B(mobile_count_rsp_new mobile_count_rsp_newVar, String str) {
        if (mobile_count_rsp_newVar != null && str != null) {
            QZoneIntimateEntranceManager.p(mobile_count_rsp_newVar, str);
        }
    }

    private static void C(@NonNull mobile_count_rsp_new mobile_count_rsp_newVar) {
        count_info count_infoVar;
        single_count single_countVar;
        if (!((IQzoneUndealCountApi) QRoute.api(IQzoneUndealCountApi.class)).isShowQZoneIntimateSpaceEntrance()) {
            RFWLog.i("UndealCount.QZoneUnreadServletLogic", RFWLog.USR, "intimate entrance is closed, don't care intimate passive");
            return;
        }
        Map<Integer, count_info> map = mobile_count_rsp_newVar.stMapCountInfo;
        if (map != null && map.get(73) != null && (count_infoVar = mobile_count_rsp_newVar.stMapCountInfo.get(73)) != null && (single_countVar = count_infoVar.stCount) != null && single_countVar.uCount > 0) {
            ((IQzoneUndealCountApi) QRoute.api(IQzoneUndealCountApi.class)).recordQZoneShowIntimateSpaceMessageTab();
        }
    }

    public static void D(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        master_info master_infoVar;
        if (mobile_count_rsp_newVar == null || (master_infoVar = mobile_count_rsp_newVar.stMasterInfo) == null || qQAppInterface == null) {
            return;
        }
        a0(master_infoVar.iLevel, master_infoVar.strMessage, qQAppInterface);
        b0(mobile_count_rsp_newVar.stMasterInfo.host_unimbitmap, qQAppInterface);
    }

    private static void E(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        ArrayList<entrance_cfg> arrayList;
        if (mobile_count_rsp_newVar == null) {
            return;
        }
        LocalMultiProcConfig.putInt4Uin("navigator_bar_style", mobile_count_rsp_newVar.isShowNewStyles, qQAppInterface.getLongAccountUin());
        Map<Integer, ArrayList<entrance_cfg>> map = mobile_count_rsp_newVar.mapEntranceCfg;
        if (map == null || map.size() == 0 || (arrayList = mobile_count_rsp_newVar.mapEntranceCfg.get(2)) == null || arrayList.size() == 0) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "handleNavigatorBarInfo rsp entracesize is:" + arrayList.size());
        }
        ThreadManagerV2.post(new Runnable(arrayList) { // from class: com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ArrayList f286398e;

            {
                this.f286398e = arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAppInterface.this, (Object) arrayList);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Manager manager;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QQAppInterface qQAppInterface2 = QQAppInterface.this;
                if (qQAppInterface2 == null || (manager = qQAppInterface2.getManager(QQManagerFactory.QZONE_MANAGER)) == null || !(manager instanceof QZoneManagerImp)) {
                    return;
                }
                QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) manager;
                if (qZoneManagerImp.C == null) {
                    qZoneManagerImp.C = new ArrayList<>();
                }
                if (qZoneManagerImp.C.size() == 0) {
                    com.tencent.common.config.provider.b.d(QQAppInterface.this.getCurrentAccountUin(), qZoneManagerImp.C);
                }
                if (!QZoneUnreadServletLogic.f(this.f286398e, qZoneManagerImp.C)) {
                    ArrayList<entrance_cfg> arrayList2 = qZoneManagerImp.C;
                    if (arrayList2 != null) {
                        arrayList2.clear();
                        qZoneManagerImp.C.addAll(this.f286398e);
                    }
                    try {
                        py3.b.e(BaseApplication.getContext().getContentResolver(), com.tencent.common.config.provider.d.D3, null, null);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("UndealCount.QZoneUnreadServletLogic", 2, "getNavigatorConfigs error:" + e16.getMessage(), e16);
                        }
                    }
                    com.tencent.common.config.provider.b.h(QQAppInterface.this.getCurrentAccountUin(), this.f286398e);
                }
            }
        }, 8, null, false);
    }

    public static void F(mobile_count_rsp_new mobile_count_rsp_newVar, QbossGateWayRsp qbossGateWayRsp, QQAppInterface qQAppInterface) {
        Map<String, String> map = mobile_count_rsp_newVar.mapExtendinfo;
        if (map != null && "CLEARALL".equalsIgnoreCase(map.get("appid_2585"))) {
            LocalMultiProcConfig.putString4Uin("friendplusmenudata", "", qQAppInterface.getLongAccountUin());
            QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handlePlusMenuData:clearAll");
            return;
        }
        Map<Integer, ArrayList<tAdvDesc>> map2 = qbossGateWayRsp.mapAdv;
        if (map2 != null && map2.get(2585) != null) {
            ArrayList<tAdvDesc> arrayList = qbossGateWayRsp.mapAdv.get(2585);
            if (arrayList.size() > 0) {
                String[] u16 = u(arrayList);
                String str = u16[0];
                String str2 = u16[1];
                b("friendplusmenudata", str, qQAppInterface);
                b("friendplusmenudatanew", str2, qQAppInterface);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "handlePlusMenuData advDescs.size() = 0");
            }
        }
    }

    private static void G(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        stPlusRecomInfo stplusrecominfo = mobile_count_rsp_newVar.plusRecom;
        if (stplusrecominfo == null) {
            if (QLog.isColorLevel()) {
                QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusRecom null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "plusRecom.status=" + stplusrecominfo.status + "  plusRecom.strMinProgramJson=" + stplusrecominfo.strMinProgramJson);
        }
        int i3 = stplusrecominfo.status;
        if (i3 == -1) {
            LocalMultiProcConfig.putString4Uin("friendplusmenurecom", "", qQAppInterface.getLongAccountUin());
        } else if (i3 == 1) {
            LocalMultiProcConfig.putString4Uin("friendplusmenurecom", stplusrecominfo.strMinProgramJson, qQAppInterface.getLongAccountUin());
        }
    }

    private static void H(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        if (mobile_count_rsp_newVar != null && qQAppInterface != null) {
            QZonePlusSignInfoManager.d(mobile_count_rsp_newVar, qQAppInterface.getAccount());
        }
    }

    private static void I(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        if (mobile_count_rsp_newVar != null && qQAppInterface != null) {
            Map<Integer, Boolean> map = mobile_count_rsp_newVar.featureSwitch;
            if (map != null && !map.isEmpty()) {
                ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).handleSaveFeatureSwitch(mobile_count_rsp_newVar.featureSwitch, qQAppInterface.getAccount());
            } else {
                QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "qzone feature switch map is null or empty");
            }
        }
    }

    private static void J(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        if (mobile_count_rsp_newVar != null && qQAppInterface != null) {
            stMomentInfo stmomentinfo = mobile_count_rsp_newVar.momentInfo;
            if (stmomentinfo == null) {
                QLog.e("UndealCount.QZoneUnreadServletLogic", 2, "qzone moment info is null");
            } else {
                b.m(stmomentinfo, qQAppInterface.getAccount());
            }
        }
    }

    public static void K(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        boolean z16;
        if (mobile_count_rsp_newVar == null) {
            return;
        }
        QbossGateWayRsp qbossGateWayRsp = new QbossGateWayRsp();
        Map<String, byte[]> map = mobile_count_rsp_newVar.mapTransData;
        if (map != null) {
            byte[] bArr = map.get("QbossAdv");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleSurpriseData:rsp.mapTransData != null,data == null ? ");
            if (bArr == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, sb5.toString());
            if (bArr != null) {
                try {
                    JceInputStream jceInputStream = new JceInputStream(bArr);
                    jceInputStream.setServerEncoding("utf-8");
                    qbossGateWayRsp.readFrom(jceInputStream);
                } catch (Throwable th5) {
                    QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "handleSurpriseData error:", th5);
                }
            }
        } else {
            QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "handleSurpriseData rsp.mapTransData: null");
        }
        Q(mobile_count_rsp_newVar, qbossGateWayRsp, qQAppInterface);
        F(mobile_count_rsp_newVar, qbossGateWayRsp, qQAppInterface);
    }

    public static void L(mobile_count_rsp_new mobile_count_rsp_newVar) {
        Map<Integer, count_info> map;
        if (mobile_count_rsp_newVar != null && (map = mobile_count_rsp_newVar.stMapCountInfo) != null && !map.isEmpty()) {
            ((IQzoneUndealCountApi) QRoute.api(IQzoneUndealCountApi.class)).handleRecommendPhotoConfig(map);
        }
    }

    public static void M(mobile_count_rsp_new mobile_count_rsp_newVar, long j3) {
        Map<Integer, String> map;
        if (mobile_count_rsp_newVar != null && (map = mobile_count_rsp_newVar.extendinfo) != null && map.containsKey(1010)) {
            String str = mobile_count_rsp_newVar.extendinfo.get(1010);
            QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "handleRenZhenghaoInfo certified_puin:" + str);
            if (!TextUtils.isEmpty(str)) {
                LocalMultiProcConfig.putString4Uin(QZonePublishMoodRequest.EXT_INFO_KEY_SYNC_TO_RENZHENHAO, str, j3);
            } else {
                LocalMultiProcConfig.putString4Uin(QZonePublishMoodRequest.EXT_INFO_KEY_SYNC_TO_RENZHENHAO, "0", j3);
            }
        }
    }

    private static void N(QQAppInterface qQAppInterface, byte[] bArr, QZoneNotifyServlet qZoneNotifyServlet) {
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "inform QZONE_GET_UNREAD isSuccess false");
        }
        if (qZoneNotifyServlet != null) {
            qZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
        }
        if (qQAppInterface != null) {
            String str = "|wufbuf: " + HexUtil.bytes2HexStr(bArr);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(9045));
            hashMap.put(ReportConstant.KEY_ERR_DESC, str);
            StatisticCollector.getInstance(qQAppInterface.getApp()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.QZONE_GETUNREAD_TAG, false, QZoneNotifyServlet.D - QZoneNotifyServlet.C, 0L, hashMap, "");
        }
    }

    public static void O(QQAppInterface qQAppInterface, Intent intent, FromServiceMsg fromServiceMsg, QZoneNotifyServlet qZoneNotifyServlet) {
        if (QLog.isColorLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "inform QZONE_GET_UNREAD isSuccess false");
        }
        if (qZoneNotifyServlet != null) {
            qZoneNotifyServlet.notifyObserver(null, 1000, false, new Bundle(), QZoneObserver.class);
        }
        if (qQAppInterface != null) {
            String str = "|resultcode: " + fromServiceMsg.getResultCode() + "|reason: " + BaseMessageHandler.getTimeoutReason(fromServiceMsg);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(AppConstants.RichMediaErrorCode.ERROR_REQEUST_TIMEOUT));
            hashMap.put(ReportConstant.KEY_ERR_DESC, str);
            StatisticCollector.getInstance(qQAppInterface.getApp()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.QZONE_GETUNREAD_TAG, false, QZoneNotifyServlet.D - QZoneNotifyServlet.C, 0L, hashMap, "");
        }
    }

    public static void P(Intent intent, FromServiceMsg fromServiceMsg, QQAppInterface qQAppInterface, QZoneNotifyServlet qZoneNotifyServlet) {
        JceStruct b16;
        mobile_count_rsp_new mobile_count_rsp_newVar;
        QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "handleResponseSucess");
        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
        if (wupBuffer == null || (b16 = QZoneFeedCountPackeger.b(wupBuffer, qQAppInterface, "getUndealCount")) == null || !(b16 instanceof mobile_count_rsp_new) || (mobile_count_rsp_newVar = (mobile_count_rsp_new) b16) == null) {
            return;
        }
        VasLogReporter.getQzoneVip().reportLow("receive: rsp has data");
        com.tencent.mobileqq.qzone.picload.b.f279315a.d();
        j0(mobile_count_rsp_newVar.mapLastGetTime, Long.valueOf(qQAppInterface.getCurrentAccountUin()));
        com.tencent.mobileqq.model.c cVar = (com.tencent.mobileqq.model.c) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        if (cVar != null) {
            cVar.b1(0);
        }
        Map<Integer, count_info> map = mobile_count_rsp_newVar.stMapCountInfo;
        if (map != null && map.get(1) != null) {
            W(mobile_count_rsp_newVar.stMapCountInfo.get(1));
        }
        LocalMultiProcConfig.putInt4Uin("qzone_preget_passive_open", mobile_count_rsp_newVar.isPreLoad, qQAppInterface.getLongAccountUin());
        B(mobile_count_rsp_newVar, qQAppInterface.getAccount());
        S(wupBuffer, mobile_count_rsp_newVar, qQAppInterface, qZoneNotifyServlet);
        T(mobile_count_rsp_newVar, qQAppInterface);
        D(mobile_count_rsp_newVar, qQAppInterface);
        z(mobile_count_rsp_newVar, qZoneNotifyServlet);
        E(mobile_count_rsp_newVar, qQAppInterface);
        I(mobile_count_rsp_newVar, qQAppInterface);
        J(mobile_count_rsp_newVar, qQAppInterface);
        K(mobile_count_rsp_newVar, qQAppInterface);
        j(mobile_count_rsp_newVar.vecOperateInfo, qQAppInterface.getCurrentAccountUin());
        Z(mobile_count_rsp_newVar.isSetMemorySeal, qQAppInterface);
        Y(mobile_count_rsp_newVar.grayOperateMask, qQAppInterface);
        U(mobile_count_rsp_newVar, qQAppInterface);
        y(mobile_count_rsp_newVar);
        c0(mobile_count_rsp_newVar, qQAppInterface);
        M(mobile_count_rsp_newVar, qQAppInterface.getLongAccountUin());
        G(mobile_count_rsp_newVar, qQAppInterface);
        H(mobile_count_rsp_newVar, qQAppInterface);
        L(mobile_count_rsp_newVar);
        x(mobile_count_rsp_newVar.cancellation_status, qQAppInterface.getLongAccountUin());
        R(mobile_count_rsp_newVar.isTeenagerModelActFeedRestriction, qQAppInterface.getLongAccountUin());
        C(mobile_count_rsp_newVar);
        A(mobile_count_rsp_newVar);
    }

    public static void Q(mobile_count_rsp_new mobile_count_rsp_newVar, QbossGateWayRsp qbossGateWayRsp, QQAppInterface qQAppInterface) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        Map<String, String> map = mobile_count_rsp_newVar.mapExtendinfo;
        if (map != null && "CLEARALL".equalsIgnoreCase(map.get("appid_2595"))) {
            LocalMultiProcConfig.putString4Uin("surprise_config", "", qQAppInterface.getLongAccountUin());
            QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "handleSurpriseData:clearAll");
            return;
        }
        Map<Integer, ArrayList<tAdvDesc>> map2 = qbossGateWayRsp.mapAdv;
        if (map2 != null && map2.get(2595) != null) {
            String string4Uin = LocalMultiProcConfig.getString4Uin("surprise_config", "", qQAppInterface.getLongAccountUin());
            if (TextUtils.isEmpty(string4Uin)) {
                jSONArray2 = new JSONArray();
            } else {
                try {
                    jSONArray = new JSONArray(string4Uin);
                } catch (Exception e16) {
                    jSONArray = new JSONArray();
                    QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "parse local advDesc.res_data error,catch an exception", e16);
                }
                jSONArray2 = jSONArray;
            }
            Iterator<tAdvDesc> it = qbossGateWayRsp.mapAdv.get(2595).iterator();
            while (it.hasNext()) {
                tAdvDesc next = it.next();
                if (!TextUtils.isEmpty(next.res_data)) {
                    try {
                        m0(jSONArray2, new JSONObject(next.res_data));
                    } catch (Throwable th5) {
                        QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "parse advDesc.res_data error,catch an exception", th5);
                    }
                }
            }
            LocalMultiProcConfig.putString4Uin("surprise_config", jSONArray2.toString(), qQAppInterface.getLongAccountUin());
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "all configs:" + jSONArray2.toString());
        }
    }

    public static void R(int i3, long j3) {
        if (!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return;
        }
        QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "handleTeenOnlineTimeLimitStatus uin=" + j3 + ", limitStatus=" + i3);
        LocalMultiProcConfig.putInt4Uin(QZoneTeenOnlineTimeHelper.KEY_TEEN_TIME_LIMIT_STATUS, i3, j3);
    }

    private static void S(byte[] bArr, mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface, QZoneNotifyServlet qZoneNotifyServlet) {
        int i3;
        HashMap<Integer, QZoneCountInfo> hashMap = new HashMap<>();
        boolean V = V(mobile_count_rsp_newVar, hashMap, qQAppInterface);
        if (V && qQAppInterface != null) {
            i3 = RemoteHandleManager.getInstance().getSender().pregetPassiveFeeds(qQAppInterface.getLongAccountUin());
        } else {
            i3 = 0;
        }
        boolean checkIsNeedToBatchDeleteCountInfo = ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).checkIsNeedToBatchDeleteCountInfo(hashMap);
        if (hashMap.size() != 0) {
            if (!V) {
                if (qQAppInterface == null) {
                    return;
                }
                Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
                if (manager != null && (manager instanceof QZoneManagerImp)) {
                    ((QZoneManagerImp) manager).v(hashMap, checkIsNeedToBatchDeleteCountInfo);
                    if (QLog.isColorLevel()) {
                        QLog.d(LogTag.TAG_LEBA_NEW, 2, "qzone redtypeinfo:recive undealcount rsp");
                    }
                }
            } else {
                f286396a.put(Integer.valueOf(i3), hashMap);
            }
            X(qQAppInterface, mobile_count_rsp_newVar);
            return;
        }
        N(qQAppInterface, bArr, qZoneNotifyServlet);
    }

    private static void T(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        if (mobile_count_rsp_newVar == null) {
            return;
        }
        if (mobile_count_rsp_newVar.stYellowInfo != null) {
            if (qQAppInterface != null && !TextUtils.isEmpty(qQAppInterface.getCurrentAccountUin())) {
                VasLogReporter.getQzoneVip().reportLow("iYellowType|iYellowLevel|isAnnualVip| " + mobile_count_rsp_newVar.stYellowInfo.iYellowType + "|" + mobile_count_rsp_newVar.stYellowInfo.iYellowLevel + "|" + ((int) mobile_count_rsp_newVar.stYellowInfo.isAnnualVip) + "|");
                i r16 = i.r();
                yellow_info yellow_infoVar = mobile_count_rsp_newVar.stYellowInfo;
                r16.d0(yellow_infoVar.iYellowType, yellow_infoVar.iYellowLevel, yellow_infoVar.isAnnualVip, mobile_count_rsp_newVar.stuStarInfo, mobile_count_rsp_newVar.stuCombineDiamondInfo);
                return;
            }
            return;
        }
        VasLogReporter.getQzoneVip().reportLow("no stYellowInfo");
    }

    private static void U(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        stVerticalVideoDisplay stverticalvideodisplay;
        int i3;
        if (mobile_count_rsp_newVar != null && (stverticalvideodisplay = mobile_count_rsp_newVar.vertVideoDisplay) != null && (i3 = stverticalvideodisplay.iType) != 0 && qQAppInterface != null) {
            LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_type", i3, qQAppInterface.getLongAccountUin());
            LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_ratio", mobile_count_rsp_newVar.vertVideoDisplay.iFeedAspectRatio, qQAppInterface.getLongAccountUin());
            LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_width", mobile_count_rsp_newVar.vertVideoDisplay.iAspectRatioWidth, qQAppInterface.getLongAccountUin());
            LocalMultiProcConfig.putInt4Uin("qzone_vertical_video_display_height", mobile_count_rsp_newVar.vertVideoDisplay.iAspectRatioHeight, qQAppInterface.getLongAccountUin());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2 */
    public static boolean V(mobile_count_rsp_new mobile_count_rsp_newVar, HashMap<Integer, QZoneCountInfo> hashMap, QQAppInterface qQAppInterface) {
        int i3;
        PassiveFeedsPush passiveFeedsPush;
        int i16;
        QzmallCustomBubbleSkin qzmallCustomBubbleSkin;
        byte[] bArr;
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponse");
        }
        if (mobile_count_rsp_newVar == null) {
            return false;
        }
        if (mobile_count_rsp_newVar.extendinfo != null && qQAppInterface != null) {
            g0(qQAppInterface.getCurrentUin(), mobile_count_rsp_newVar.extendinfo);
        }
        Map<String, byte[]> map = mobile_count_rsp_newVar.mapTransData;
        if (map != null && qQAppInterface != null && map.containsKey("unreadCountBanner")) {
            k0(qQAppInterface.getCurrentUin(), mobile_count_rsp_newVar.mapTransData.get("unreadCountBanner"));
        }
        Map<String, byte[]> map2 = mobile_count_rsp_newVar.mapTransData;
        if (map2 != null && qQAppInterface != null && map2.containsKey("frdBirthRecom")) {
            e0(qQAppInterface.getCurrentUin(), mobile_count_rsp_newVar.mapTransData.get("frdBirthRecom"));
        }
        if (mobile_count_rsp_newVar.mapAutoTransData != null && qQAppInterface != null) {
            h0(qQAppInterface.getCurrentUin(), mobile_count_rsp_newVar.mapAutoTransData);
        }
        Map<Integer, count_info> map3 = mobile_count_rsp_newVar.stMapCountInfo;
        if (map3 == null || map3.size() == 0 || hashMap == null) {
            return false;
        }
        int i17 = 1;
        boolean z16 = 0;
        int i18 = 1;
        while (i18 < 1029) {
            count_info count_infoVar = mobile_count_rsp_newVar.stMapCountInfo.get(Integer.valueOf(i18));
            if (count_infoVar != null) {
                QZoneCountInfo qZoneCountInfo = new QZoneCountInfo();
                single_count single_countVar = count_infoVar.stCount;
                z16 = z16;
                if (single_countVar != null) {
                    qZoneCountInfo.uCount = single_countVar.uCount;
                    qZoneCountInfo.iControl = single_countVar.iControl;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponse unread cout: " + count_infoVar.stCount.uCount + "unread type: " + i18);
                        QLog.d(LogTag.TAG_LEBA_NEW, 2, "qzone redtypeinfo:onResponse unread cout: " + count_infoVar.stCount.uCount + "unread type: " + i18);
                    }
                    QLog.d("UndealCount.QZoneUnreadServletLogic", i17, "response unread count id is " + i18 + " count is " + count_infoVar.stCount.uCount + " message is " + count_infoVar.strShowMsg);
                    z16 = z16;
                    if (i18 == i17) {
                        z16 = z16;
                        z16 = z16;
                        if (qZoneCountInfo.uCount > 0 && qQAppInterface != null) {
                            z16 = z16;
                            if (mobile_count_rsp_newVar.isPreLoad == i17) {
                                z16 = z16;
                                if (!TextUtils.isEmpty(mobile_count_rsp_newVar.undealCountTime)) {
                                    z16 = z16;
                                    if (!LocalMultiProcConfig.getString4Uin("qzone_passive_undealtime", "", qQAppInterface.getLongAccountUin()).equals(mobile_count_rsp_newVar.undealCountTime)) {
                                        z16 = i17;
                                    }
                                }
                            }
                        }
                    }
                }
                Map<String, byte[]> map4 = mobile_count_rsp_newVar.mapTransData;
                if (map4 != null && (bArr = map4.get("PassiveFeedsPush")) != null) {
                    passiveFeedsPush = (PassiveFeedsPush) JceUtils.decodeWup(PassiveFeedsPush.class, bArr);
                } else {
                    passiveFeedsPush = null;
                }
                ArrayList<feed_host_info> arrayList = count_infoVar.vecUinList;
                if (arrayList != null && arrayList.size() > 0) {
                    int i19 = 0;
                    while (i19 < count_infoVar.vecUinList.size()) {
                        QZoneCountUserInfo qZoneCountUserInfo = new QZoneCountUserInfo();
                        qZoneCountUserInfo.uin = count_infoVar.vecUinList.get(i19).uUin;
                        if (count_infoVar.vecUinList.get(i19).OpuinYellowInfo != null) {
                            qZoneCountUserInfo.iYellowType = count_infoVar.vecUinList.get(i19).OpuinYellowInfo.iYellowType;
                            qZoneCountUserInfo.iYellowLevel = count_infoVar.vecUinList.get(i19).OpuinYellowInfo.iYellowLevel;
                            qZoneCountUserInfo.isAnnualVip = count_infoVar.vecUinList.get(i19).OpuinYellowInfo.isAnnualVip;
                        }
                        qZoneCountUserInfo.vec_feedInfos = count_infoVar.vecUinList.get(i19).vec_feedInfos;
                        qZoneCountUserInfo.nickName = count_infoVar.vecUinList.get(i19).nickname;
                        if (passiveFeedsPush != null && (qzmallCustomBubbleSkin = passiveFeedsPush.stBubbleSkin) != null) {
                            i16 = i18;
                            if (qZoneCountUserInfo.uin == qzmallCustomBubbleSkin.lUin) {
                                qZoneCountUserInfo.pushData = passiveFeedsPush;
                            }
                        } else {
                            i16 = i18;
                        }
                        qZoneCountInfo.friendList.add(qZoneCountUserInfo);
                        i19++;
                        i18 = i16;
                    }
                    i3 = i18;
                    qZoneCountInfo.friendMsg = count_infoVar.vecUinList.get(0).actiondesc;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "onResponse unread list first uin: " + count_infoVar.vecUinList.get(0).uUin + ",actiondesc: " + count_infoVar.vecUinList.get(0).actiondesc);
                    }
                } else {
                    i3 = i18;
                }
                qZoneCountInfo.trace_info = count_infoVar.trace_info;
                qZoneCountInfo.countId = count_infoVar.iSubCountID;
                qZoneCountInfo.actPageAttach = count_infoVar.actPageAttach;
                qZoneCountInfo.strShowMsg = count_infoVar.strShowMsg;
                qZoneCountInfo.reportValue = count_infoVar.strReportValue;
                qZoneCountInfo.iconUrl = count_infoVar.strIconUrl;
                qZoneCountInfo.cTime = count_infoVar.cTime;
                qZoneCountInfo.tianshuTrans = count_infoVar.tianshuTrans;
                qZoneCountInfo.expireTime = count_infoVar.expireTime;
                qZoneCountInfo.ext = count_infoVar.ext;
                hashMap.put(Integer.valueOf(i3), qZoneCountInfo);
            } else {
                i3 = i18;
            }
            i18 = i3 + 1;
            i17 = 1;
            z16 = z16;
        }
        return z16;
    }

    private static void W(count_info count_infoVar) {
        if (count_infoVar != null && count_infoVar.vecUinList != null) {
            QLog.i("UndealCount.QZoneUnreadServletLogic", 1, "recv Qzone Unread Push: Feed\u5b9e\u65f6\u66f4\u65b0\u672a\u8bfb");
            Intent intent = new Intent("com.qzone.push_feed_unread");
            intent.putExtra("feeds_unread", count_infoVar);
            BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        }
    }

    private static void X(QQAppInterface qQAppInterface, mobile_count_rsp_new mobile_count_rsp_newVar) {
        if (qQAppInterface != null) {
            long currentTimeMillis = System.currentTimeMillis();
            StatisticCollector.getInstance(qQAppInterface.getApp()).collectPerformance(qQAppInterface.getCurrentAccountUin(), StatisticCollector.QZONE_GETUNREAD_TAG, true, currentTimeMillis - QZoneNotifyServlet.C, 0L, new HashMap<>(), "");
            com.tencent.mobileqq.service.report.b.f(mobile_count_rsp_newVar);
        }
    }

    public static void Y(int i3, QQAppInterface qQAppInterface) {
        String account;
        boolean z16;
        if (qQAppInterface != null && (account = qQAppInterface.getAccount()) != null) {
            LocalMultiProcConfig.putInt4Uin("qzone_feed_gray_mask", i3, Long.valueOf(account).longValue());
            PhotoUtils.clearNewPicRuleMapCache();
            com.tencent.mobileqq.model.c cVar = (com.tencent.mobileqq.model.c) qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
            if ((i3 & 128) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            cVar.B1(z16);
            QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "saveGrayOperate: " + i3);
        }
    }

    private static void Z(int i3, QQAppInterface qQAppInterface) {
        String account;
        String str;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("saveHasUserArchieveMemoryFlag:");
            if (i3 == 0) {
                str = "\u672a\u4f7f\u7528\u8fc7\u8bb0\u5fc6\u5c01\u5b58";
            } else {
                str = "\u5df2\u7ecf\u4f7f\u7528\u8fc7\u8bb0\u5fc6\u5c01\u5b58";
            }
            sb5.append(str);
            QLog.d("ArchiveMemorySettingGuide", 2, sb5.toString());
        }
        if (qQAppInterface != null && (account = qQAppInterface.getAccount()) != null) {
            LocalMultiProcConfig.putInt4Uin("qzone_memory_seal_key", i3, Long.valueOf(account).longValue());
        }
    }

    public static void a0(int i3, String str, QQAppInterface qQAppInterface) {
        String account;
        if (qQAppInterface != null && (account = qQAppInterface.getAccount()) != null) {
            LocalMultiProcConfig.putInt4Uin("creditlevel", i3, Long.valueOf(account).longValue());
            LocalMultiProcConfig.putString4Uin("creditmessage", str, Long.valueOf(account).longValue());
            QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "creditlevel:" + i3 + " message:" + str);
        }
    }

    private static void b(String str, String str2, QQAppInterface qQAppInterface) {
        String str3;
        if (str == "friendplusmenudata") {
            str3 = "plusMenuData:";
        } else {
            str3 = "plusMenuDataNew:";
        }
        if (!TextUtils.isEmpty(str2)) {
            if (!str2.equals(LocalMultiProcConfig.getString4Uin(str, "", qQAppInterface.getLongAccountUin()))) {
                LocalMultiProcConfig.putString4Uin(str, str2, qQAppInterface.getLongAccountUin());
            }
            if (QLog.isColorLevel()) {
                QLog.i("UndealCount.QZoneUnreadServletLogic", 2, str3 + str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UndealCount.QZoneUnreadServletLogic", 2, str3 + ": null");
        }
    }

    public static void b0(long j3, QQAppInterface qQAppInterface) {
        String account;
        if (qQAppInterface != null && (account = qQAppInterface.getAccount()) != null) {
            LocalMultiProcConfig.putInt4Uin("qzone_jinyan", (int) (j3 & 32768), Long.valueOf(account).longValue());
        }
    }

    public static void c(QQAppInterface qQAppInterface, int i3, Long l3) {
        Manager manager;
        if (qQAppInterface != null && (manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER)) != null && (manager instanceof QZoneManagerImp)) {
            HashMap<Integer, QZoneCountInfo> hashMap = f286396a.get(Integer.valueOf(i3));
            f286396a.remove(Integer.valueOf(i3));
            if (hashMap != null && !hashMap.isEmpty()) {
                if (l3.longValue() != -1 && hashMap.get(1) != null) {
                    QZoneCountInfo qZoneCountInfo = hashMap.get(1);
                    qZoneCountInfo.uCount = l3.longValue();
                    hashMap.put(1, qZoneCountInfo);
                }
                ((QZoneManagerImp) manager).v(hashMap, false);
            }
        }
    }

    private static void c0(mobile_count_rsp_new mobile_count_rsp_newVar, QQAppInterface qQAppInterface) {
        byte[] bArr = mobile_count_rsp_newVar.mapTransData.get("OperEntrance");
        if (bArr != null && bArr.length > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "saveMoreEntranceResConfig updateConfig");
            }
            JceUtils.decodeWup(new OperEntranceInfo(), bArr);
            LocalMultiProcConfig.putString4Uin("key_plus_menu_config", Base64.encodeToString(bArr, 0), qQAppInterface.getLongAccountUin());
            Bundle bundle = new Bundle();
            bundle.putByteArray("data", bArr);
            QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:qzone", "PlusMenuDecorates", "updateConfig", bundle, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("UndealCount.QZoneUnreadServletLogic", 2, "saveMoreEntranceResConfig no Config update");
        }
    }

    private static boolean d(long j3) {
        ArrayList<String> arrayList;
        String string4Uin = LocalMultiProcConfig.getString4Uin("qzone_dual_warm_comment_info", "", j3);
        if (TextUtils.isEmpty(string4Uin)) {
            return true;
        }
        try {
            stNuanNuanComment stnuannuancomment = (stNuanNuanComment) h(stNuanNuanComment.class, PluginBaseInfoHelper.Base64Helper.decode(string4Uin, 0));
            if (stnuannuancomment == null || (arrayList = stnuannuancomment.vcOtherComments) == null) {
                return true;
            }
            if (arrayList.size() <= 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void d0(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            LocalMultiProcConfig.putString("ACTPAGE_ATTACH" + str, str2);
            return;
        }
        LocalMultiProcConfig.putString("ACTPAGE_ATTACH" + str, "");
    }

    private static boolean e(entrance_cfg entrance_cfgVar, entrance_cfg entrance_cfgVar2) {
        if (entrance_cfgVar == null && entrance_cfgVar2 == null) {
            return true;
        }
        if (entrance_cfgVar != null && entrance_cfgVar2 != null && i(entrance_cfgVar, entrance_cfgVar2)) {
            return true;
        }
        return false;
    }

    public static void e0(String str, byte[] bArr) {
        if (bArr != null) {
            LocalMultiProcConfig.putString("BIRTHRECOM_INFO" + str, Base64.encodeToString(bArr, 2));
            return;
        }
        LocalMultiProcConfig.putString("BIRTHRECOM_INFO" + str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(ArrayList<entrance_cfg> arrayList, ArrayList<entrance_cfg> arrayList2) {
        if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size() || arrayList.size() == 0) {
            return false;
        }
        int i3 = 0;
        boolean z16 = true;
        while (i3 < arrayList.size()) {
            entrance_cfg entrance_cfgVar = arrayList.get(i3);
            if (z16 && g(arrayList2, entrance_cfgVar)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            i3++;
        }
        if (i3 != arrayList.size()) {
            return false;
        }
        return true;
    }

    public static void f0(String str, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            LocalMultiProcConfig.putString("redPointTianshuTrans" + str, Base64.encodeToString(bArr, 2));
            return;
        }
        LocalMultiProcConfig.putString("redPointTianshuTrans" + str, "");
    }

    private static boolean g(ArrayList<entrance_cfg> arrayList, entrance_cfg entrance_cfgVar) {
        if (arrayList == null || entrance_cfgVar == null) {
            return false;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (e(entrance_cfgVar, arrayList.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public static void g0(String str, Map<Integer, String> map) {
        String a16 = f.a(map);
        QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "setExtendInfo uin:" + str + " extend_info:" + a16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("EXTEND_INFO");
        sb5.append(str);
        LocalMultiProcConfig.putString(sb5.toString(), a16);
    }

    private static <T extends JceStruct> T h(Class<T> cls, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            JceInputStream jceInputStream = new JceInputStream(bArr);
            jceInputStream.setServerEncoding("utf8");
            newInstance.readFrom(jceInputStream);
            return newInstance;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void h0(String str, Map<String, byte[]> map) {
        if (map != null && map.size() != 0) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, byte[]> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), Base64.encodeToString(entry.getValue(), 2));
            }
            try {
                LocalMultiProcConfig.putString("MAPAUTOTRANS_DATA" + str, new JSONObject(hashMap).toString());
                return;
            } catch (Exception unused) {
                QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "setMapAutoTransData failed, null keys exist in the map");
                return;
            }
        }
        LocalMultiProcConfig.putString("MAPAUTOTRANS_DATA" + str, "");
    }

    public static boolean i(entrance_cfg entrance_cfgVar, entrance_cfg entrance_cfgVar2) {
        if (entrance_cfgVar.iEntranceId == entrance_cfgVar2.iEntranceId && TextUtils.equals(entrance_cfgVar.sEntranceAction, entrance_cfgVar2.sEntranceAction) && TextUtils.equals(entrance_cfgVar.sEntranceName, entrance_cfgVar2.sEntranceName) && TextUtils.equals(entrance_cfgVar.sEntranceIcon, entrance_cfgVar2.sEntranceIcon) && TextUtils.equals(entrance_cfgVar.sQbossEntranceIcon, entrance_cfgVar2.sQbossEntranceIcon) && entrance_cfgVar.isCanNotShowOnTeenagerMod == entrance_cfgVar2.isCanNotShowOnTeenagerMod) {
            return true;
        }
        return false;
    }

    public static void i0(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            LocalMultiProcConfig.putString("redPointCountId" + str, str2);
            return;
        }
        LocalMultiProcConfig.putString("redPointCountId" + str, "");
    }

    public static void j(ArrayList<operat_data> arrayList, String str) {
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "QZoneFeedCountPackeger execCmds");
        }
        if (arrayList != null) {
            Iterator<operat_data> it = arrayList.iterator();
            while (it.hasNext()) {
                operat_data next = it.next();
                if (next != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "QZoneFeedCountPackeger operat_data cmd: " + next.cmd);
                        QLog.d("UndealCount.QZoneUnreadServletLogic", 4, "QZoneFeedCountPackeger operat_data desc: " + next.desc);
                    }
                    HashMap hashMap = new HashMap();
                    Map<String, String> map = next.mapExt;
                    if (map != null && map.size() > 0) {
                        hashMap.putAll(next.mapExt);
                    }
                    hashMap.put("key_desc", next.desc);
                    ((IQzoneMixApi) QRoute.api(IQzoneMixApi.class)).execCtrlCommand(str, next.cmd, hashMap);
                }
            }
        }
    }

    public static void j0(Map<Long, Long> map, Long l3) {
        if (map != null && map.size() != 0) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key", entry.getKey());
                    jSONObject.put("value", entry.getValue());
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "setMapLastGetTime JSONException", e16);
                    return;
                }
            }
            if (jSONArray.length() > 0) {
                String jSONArray2 = jSONArray.toString();
                LocalMultiProcConfig.putString4Uin(IQzoneUndealCountApi.UNDEALCOUNT_FEEDALERT_LAST_GET_TIME, jSONArray2, l3.longValue());
                QLog.i("UndealCount.QZoneUnreadServletLogic", 1, "setUdealCountLastGetTime: " + jSONArray2);
            }
        }
    }

    public static String k(String str) {
        return LocalMultiProcConfig.getString("ACTPAGE_ATTACH" + str, "");
    }

    public static void k0(String str, byte[] bArr) {
        if (bArr != null) {
            LocalMultiProcConfig.putString("BANNER_INFO" + str, Base64.encodeToString(bArr, 2));
            return;
        }
        LocalMultiProcConfig.putString("BANNER_INFO" + str, "");
    }

    public static byte[] l(String str) {
        return Base64.decode(LocalMultiProcConfig.getString("BIRTHRECOM_INFO" + str, ""), 2);
    }

    public static Map<Integer, Long> l0(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                try {
                    hashMap.put(Integer.valueOf(URLDecoder.decode(split[0], "UTF-8")), Long.valueOf(URLDecoder.decode(split[1], "UTF-8")));
                } catch (UnsupportedEncodingException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, e16.toString());
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("UndealCount.QZoneUnreadServletLogic", 2, th5.toString());
                    }
                }
            }
        }
        return hashMap;
    }

    public static byte[] m(String str) {
        String string = LocalMultiProcConfig.getString("redPointTianshuTrans" + str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Base64.decode(string, 2);
    }

    private static void m0(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray != null && jSONObject != null) {
            int length = jSONArray.length();
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.optString("priority", "0").equalsIgnoreCase(jSONObject.optString("priority", "0"))) {
                        QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "find one,oldData:" + jSONObject2.toString() + " ,newData:" + jSONObject.toString());
                        jSONArray.put(i3, jSONObject);
                        break;
                    }
                    i3++;
                } catch (Throwable th5) {
                    QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "updateSurpriseData error:", th5);
                    return;
                }
            }
            if (i3 == length) {
                jSONArray.mo162put(jSONObject);
                QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "add newData:" + jSONObject.toString());
            }
        }
    }

    public static Map<Integer, Long> n(long j3) {
        Map<Integer, Long> l06 = l0(LocalMultiProcConfig.getString("CTIME_MAP" + j3, ""));
        if (!l06.containsKey(0)) {
            l06.put(0, 0L);
        }
        return l06;
    }

    public static int o(long j3) {
        int int4Uin = LocalMultiProcConfig.getInt4Uin("cancellation_status", 0, j3);
        QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "getCancellationStatus:" + int4Uin);
        return int4Uin;
    }

    public static Map<Integer, String> p(long j3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getExtendInfo uin:");
        sb5.append(j3);
        sb5.append(" extend_info:");
        sb5.append(LocalMultiProcConfig.getString("EXTEND_INFO" + j3, ""));
        QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, sb5.toString());
        Map<Integer, String> b16 = f.b(LocalMultiProcConfig.getString("EXTEND_INFO" + j3, ""));
        if (d(j3)) {
            b16.put(1003, "0");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin()) {
            String currentUid = peekAppRuntime.getCurrentUid();
            if (!TextUtils.isEmpty(currentUid)) {
                b16.put(1020, currentUid);
            }
        }
        return b16;
    }

    public static byte[] q(long j3, String str, int i3, int i16, int i17, int i18, Map<Integer, count_info> map, String str2, Map<Long, Long> map2) {
        if (j3 == 0) {
            return null;
        }
        mobile_count_req mobile_count_reqVar = new mobile_count_req();
        mobile_count_reqVar.iRelationType = 1;
        mobile_count_reqVar.iVisitQZoneType = i17;
        mobile_count_reqVar.mapTimeStamp = n(j3);
        mobile_count_reqVar.mapLastGetTime = v(Long.valueOf(j3));
        mobile_count_reqVar.stMapCountInfo = map;
        mobile_count_reqVar.extendinfo = p(j3);
        mobile_count_reqVar.lastUndealCountTime = str2;
        mobile_count_reqVar.mapDyncShowTime = map2;
        mobile_count_reqVar.lastClickPlusButtonTime = QZonePlusSignInfoManager.b();
        return QZoneFeedCountPackeger.c(mobile_count_reqVar, "getUndealCount", j3, i3, i16, i18);
    }

    public static String[] r(long j3) {
        String string = LocalMultiProcConfig.getString("KUOLIE_HOTTAGS" + j3, "");
        QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "getKuolieHotTags uin:" + j3 + " getKuolieHotTags:" + string);
        if (!TextUtils.isEmpty(string)) {
            return string.split(",");
        }
        return null;
    }

    public static Map<String, byte[]> s(String str) {
        HashMap hashMap = new HashMap();
        String string = LocalMultiProcConfig.getString("MAPAUTOTRANS_DATA" + str, "");
        if (!"".equals(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap.put(str2, Base64.decode(jSONObject.getString(str2), 2));
                }
            } catch (JSONException unused) {
                QZLog.d("UndealCount.QZoneUnreadServletLogic", 1, "getMapAutoTransData failed: " + str + " jsonString = " + string);
            }
        }
        return hashMap;
    }

    public static List<Integer> t(Map<Integer, QZoneCountInfo> map) {
        Set<Integer> keySet;
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        if (map != null && map.size() > 0 && (keySet = map.keySet()) != null) {
            for (Integer num : keySet) {
                if (num.intValue() >= 1006) {
                    arrayList.add(num);
                }
            }
        }
        return arrayList;
    }

    private static String[] u(ArrayList<tAdvDesc> arrayList) {
        String[] strArr = new String[2];
        String str = "";
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3) != null) {
                str = arrayList.get(i3).res_data;
            }
            if (str.contains("jianjie")) {
                strArr[1] = str;
            } else {
                strArr[0] = str;
            }
        }
        return strArr;
    }

    public static Map<Long, Long> v(Long l3) {
        HashMap hashMap = new HashMap();
        String string4Uin = LocalMultiProcConfig.getString4Uin(IQzoneUndealCountApi.UNDEALCOUNT_FEEDALERT_LAST_GET_TIME, "", l3.longValue());
        QLog.i("UndealCount.QZoneUnreadServletLogic", 1, "getUdealCountLastGetTime: " + string4Uin);
        if (!TextUtils.isEmpty(string4Uin)) {
            try {
                JSONArray jSONArray = (JSONArray) new JSONTokener(string4Uin).nextValue();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    hashMap.put(Long.valueOf(jSONObject.getLong("key")), Long.valueOf(jSONObject.getLong("value")));
                }
            } catch (JSONException e16) {
                QLog.e("UndealCount.QZoneUnreadServletLogic", 1, "getMapLastGetTime JSONException", e16);
            }
        }
        return hashMap;
    }

    public static byte[] w(String str) {
        return Base64.decode(LocalMultiProcConfig.getString("BANNER_INFO" + str, ""), 2);
    }

    public static void x(int i3, long j3) {
        QLog.d("UndealCount.QZoneUnreadServletLogic", 1, "handleCancellationStatus status:" + i3);
        LocalMultiProcConfig.putInt4Uin("cancellation_status", i3, j3);
    }

    public static void y(mobile_count_rsp_new mobile_count_rsp_newVar) {
        ArrayList<stSoftInfo> arrayList;
        if (mobile_count_rsp_newVar != null && (arrayList = mobile_count_rsp_newVar.vec_soft_infos) != null && arrayList.size() != 0) {
            QLog.w("UndealCount.QZoneUnreadServletLogic", 1, "get FeedSoft command, " + mobile_count_rsp_newVar.snnComment.iStatus + "timestamp " + System.currentTimeMillis());
            ArrayList<stSoftInfo> arrayList2 = mobile_count_rsp_newVar.vec_soft_infos;
            JceOutputStream jceOutputStream = new JceOutputStream();
            jceOutputStream.setServerEncoding("utf8");
            jceOutputStream.write((Collection) arrayList2, 1);
            LocalMultiProcConfig.putString("qzone_soft_infos", PluginBaseInfoHelper.Base64Helper.encodeToString(jceOutputStream.toByteArray(), 0));
        }
    }

    private static void z(mobile_count_rsp_new mobile_count_rsp_newVar, QZoneNotifyServlet qZoneNotifyServlet) {
        if (mobile_count_rsp_newVar == null || qZoneNotifyServlet == null) {
            return;
        }
        int i3 = mobile_count_rsp_newVar.iNextTimeout;
        if (i3 > 0) {
            qZoneNotifyServlet.f286456d = i3 * 1000;
            if (QLog.isColorLevel()) {
                QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "onReceive getFeedInterval:" + qZoneNotifyServlet.f286456d);
            }
        }
        if (mobile_count_rsp_newVar.switchTimeout > 0) {
            qZoneNotifyServlet.f286457e = r7 * 1000;
            if (QLog.isColorLevel()) {
                QLog.d("UndealCount.QZoneUnreadServletLogic", 2, "onReceive getActiveAppInterval:" + qZoneNotifyServlet.f286457e);
            }
        }
    }
}
