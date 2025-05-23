package com.tencent.gamecenter.wadl.api.impl;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$AccountInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$AppInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$EventInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$ExpeEventReportReq;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$ExpeInfo;
import com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$UserActionInfo;
import com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy$AttaItem;
import com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy$AttaValue;
import com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy$ReportAttaListReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcAttaProxy$ReportAttaReq;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport$DcRecord;
import com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport$DcReportRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport$KV;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerRsp;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.gamecenter.trpcprotocol.QQGameInstallActionReport$InstallActionReportReq;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameDownloadSpeedReporter$GameDownloadInfo;
import tencent.im.qqgame.QQGameDownloadSpeedReporter$ReportDownloadSpeedReq;
import tencent.im.qqgame.QQGameGcSpkTaskDye;
import tencent.im.qqgame.QQGameQfsSubscribe;
import tencent.im.qqgame.QQGameSubscribe$GameVersion;
import tencent.im.qqgame.QQGameSubscribe$SubscribeNewVersionReq;
import tencent.im.qqgame.QQGameSubscribe$SubscribeUpComingGameReq;
import tencent.im.qqgame.UserGameVersionPB$QueryGameChannelReq;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameTrpcServiceImpl implements IQQGameTrpcService {
    private static final String MMKV_KEY_USE_CANARY_ENV = "gc_trpc_use_canary_env";
    private static final String TAG = "Wadl_QQGameTrpcServiceImpl";
    private CopyOnWriteArrayList<WeakReference<WadlTrpcListener>> trpcListeners = new CopyOnWriteArrayList<>();

    private TrpcAttaProxy$AttaValue createAttaValue(String str, String str2) {
        if (str2 == null) {
            QLog.w(TAG, 1, "createAttaValue key=" + str + ",value is null");
            str2 = "";
        }
        TrpcAttaProxy$AttaValue trpcAttaProxy$AttaValue = new TrpcAttaProxy$AttaValue();
        trpcAttaProxy$AttaValue.key.set(str);
        trpcAttaProxy$AttaValue.value.set(str2);
        return trpcAttaProxy$AttaValue;
    }

    private WadlTrpcReport$KV createDcRecord(String str, String str2) {
        if (str2 == null) {
            QLog.w(TAG, 1, "createDcRecord key=" + str + ",value is null");
            str2 = "";
        }
        WadlTrpcReport$KV wadlTrpcReport$KV = new WadlTrpcReport$KV();
        wadlTrpcReport$KV.key.set(str);
        wadlTrpcReport$KV.value.set(str2);
        return wadlTrpcReport$KV;
    }

    private WadlTrpcReport$DcReportRequest getDcReportReq(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONObject("req").optJSONArray(WadlReportBuilder.KEY_REPORT_LIST);
        WadlTrpcReport$DcReportRequest wadlTrpcReport$DcReportRequest = new WadlTrpcReport$DcReportRequest();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                if (optJSONObject2 == null) {
                    QLog.w(TAG, 1, "requestTrpc data is null");
                } else {
                    WadlTrpcReport$DcRecord wadlTrpcReport$DcRecord = new WadlTrpcReport$DcRecord();
                    wadlTrpcReport$DcRecord.dcId.set(optJSONObject.optString(WadlReportBuilder.KEY_DC_ID));
                    Iterator keys = optJSONObject2.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        wadlTrpcReport$DcRecord.data.add(createDcRecord(str, optJSONObject2.optString(str)));
                    }
                    wadlTrpcReport$DcReportRequest.record.add(wadlTrpcReport$DcRecord);
                }
            }
        }
        return wadlTrpcReport$DcReportRequest;
    }

    private void notifyListeners(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        Iterator<WeakReference<WadlTrpcListener>> it = this.trpcListeners.iterator();
        while (it.hasNext()) {
            WeakReference<WadlTrpcListener> next = it.next();
            WadlTrpcListener wadlTrpcListener = next.get();
            if (wadlTrpcListener != null) {
                HashSet<String> filterCmds = wadlTrpcListener.getFilterCmds();
                if (filterCmds == null || filterCmds.contains(str)) {
                    wadlTrpcListener.onTrpcRsp(intent, str, j3, trpcInovkeRsp);
                }
            } else {
                this.trpcListeners.remove(next);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void addListener(WadlTrpcListener wadlTrpcListener) {
        if (wadlTrpcListener == null) {
            return;
        }
        Iterator<WeakReference<WadlTrpcListener>> it = this.trpcListeners.iterator();
        while (it.hasNext()) {
            WadlTrpcListener wadlTrpcListener2 = it.next().get();
            if (wadlTrpcListener2 != null && wadlTrpcListener2 == wadlTrpcListener) {
                return;
            }
        }
        QLog.d(TAG, 1, "addListener listener=" + wadlTrpcListener + " succ");
        this.trpcListeners.add(new WeakReference<>(wadlTrpcListener));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void checkInstallChannel(int i3, int i16, String str, WadlParams wadlParams) {
        if (str == null) {
            str = "";
        }
        QLog.d(TAG, 1, "checkInstallChannel from=" + i3 + ",source=" + i16 + ",wadlParams=" + wadlParams + ",channelId=" + str);
        if (wadlParams == null || TextUtils.isEmpty(wadlParams.appId)) {
            return;
        }
        UserGameVersionPB$QueryGameChannelReq userGameVersionPB$QueryGameChannelReq = new UserGameVersionPB$QueryGameChannelReq();
        userGameVersionPB$QueryGameChannelReq.appid.set(wadlParams.appId);
        userGameVersionPB$QueryGameChannelReq.channel_id.set(str);
        userGameVersionPB$QueryGameChannelReq.source.set(i16);
        Bundle bundle = new Bundle();
        bundle.putString("appid", wadlParams.appId);
        bundle.putString(WadlProxyConsts.CHANNEL, str);
        bundle.putParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO, wadlParams);
        bundle.putInt("actionFrom", i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL, false, userGameVersionPB$QueryGameChannelReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        requestTrpc(trpcListReq, bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public TrpcProxy.TrpcInovkeReq createTrpcInvokeReq(String str, boolean z16, byte[] bArr) {
        TrpcProxy.TrpcMsg trpcMsg = new TrpcProxy.TrpcMsg();
        trpcMsg.clientRPCName.set(str);
        TrpcProxy.TrpcOptions trpcOptions = new TrpcProxy.TrpcOptions();
        trpcOptions.currentSerializationType.set(4);
        trpcOptions.serializationType.set(0);
        if (z16) {
            trpcOptions.requestType.set(1);
        }
        ArrayList arrayList = new ArrayList();
        TrpcProxy.TrpcMetaData trpcMetaData = new TrpcProxy.TrpcMetaData();
        trpcMetaData.key.set("platform");
        trpcMetaData.value.set(ByteStringMicro.copyFrom("Android".getBytes()));
        arrayList.add(trpcMetaData);
        trpcOptions.metaData2.set(arrayList);
        TrpcProxy.TrpcInovkeReq trpcInovkeReq = new TrpcProxy.TrpcInovkeReq();
        trpcInovkeReq.f106730msg.set(trpcMsg);
        trpcInovkeReq.data.set(ByteStringMicro.copyFrom(bArr));
        trpcInovkeReq.options.set(trpcOptions);
        return trpcInovkeReq;
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void destroy() {
        QLog.d(TAG, 1, "destroy trpcListeners=" + this.trpcListeners.size());
        this.trpcListeners.clear();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void dyeUser(String str, String str2, String str3, int i3, int i16, QQGameGcSpkTaskDye.SubscribeReq subscribeReq, String str4, String str5) {
        try {
            int parseInt = Integer.parseInt(str3);
            QQGameGcSpkTaskDye.GetDyedReq getDyedReq = new QQGameGcSpkTaskDye.GetDyedReq();
            if (!TextUtils.isEmpty(str)) {
                getDyedReq.task_key.set(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                getDyedReq.channel_id.set(str2);
            }
            getDyedReq.appid.set(parseInt);
            getDyedReq.source_type.set(i3);
            getDyedReq.f436034op.set(i16);
            if (!TextUtils.isEmpty(str4)) {
                getDyedReq.dye_from.set(str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                getDyedReq.mini_world_content_id.set(str5);
            }
            if (subscribeReq != null) {
                getDyedReq.subscribe_req.set(subscribeReq);
            }
            getDyedReq.plat.set(1);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_GAME_DYE_USER, false, getDyedReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putString("appid", str3);
            bundle.putInt("type", i16);
            requestTrpc(trpcListReq, bundle);
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void getGameList() {
        QLog.d(TAG, 1, "getGameList");
        QQGameQfsSubscribe.GetGameListReq getGameListReq = new QQGameQfsSubscribe.GetGameListReq();
        getGameListReq.game_id.set("");
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_GET_GAME_LIST, false, getGameListReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        requestTrpc(trpcListReq, null);
    }

    protected String getNetWorkType() {
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType < 0 || netWorkType >= AppConstants.NET_TYPE_NAME.length) {
            netWorkType = 0;
        }
        return AppConstants.NET_TYPE_NAME[netWorkType];
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public boolean isUseCanaryEnv() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c4  */
    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onRespTrpcSso(Intent intent, boolean z16, int i3, int i16, byte[] bArr) {
        boolean z17;
        List<TrpcProxy.TrpcInovkeRsp> list;
        String[] stringArrayExtra;
        Object obj;
        boolean z18;
        int i17;
        TrpcProxy.TrpcInovkeRsp trpcInovkeRsp;
        int i18;
        WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp;
        if (intent == null) {
            return;
        }
        if (z16 && i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        long j3 = -1;
        if (z17 && bArr != null) {
            try {
                webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(bArr);
                j3 = webSSOAgent$UniSsoServerRsp.ret.get();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onRespTrpcSso err:" + e16.getMessage());
            }
            if (j3 == 0) {
                TrpcProxy.TrpcListRsp trpcListRsp = new TrpcProxy.TrpcListRsp();
                trpcListRsp.mergeFrom(webSSOAgent$UniSsoServerRsp.pbRsqData.get().toByteArray());
                j3 = trpcListRsp.ret.get();
                list = trpcListRsp.list.get();
                stringArrayExtra = intent.getStringArrayExtra(WadlProxyConsts.PARAM_TRPCSSO_CMD_IDS);
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                if (z17 || j3 != 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onRespTrpcSso cmdArray=");
                    sb5.append(stringArrayExtra.toString());
                    sb5.append("sSucc=");
                    sb5.append(z17);
                    sb5.append(",ret=");
                    sb5.append(j3);
                    sb5.append(",trpcRspRetCode=");
                    sb5.append(i3);
                    sb5.append(",trpcRspFuncRetCode=");
                    sb5.append(i16);
                    sb5.append(",rspList size=");
                    if (list == null) {
                        obj = Integer.valueOf(list.size());
                    } else {
                        obj = "is null";
                    }
                    sb5.append(obj);
                    QLog.d(TAG, 1, sb5.toString());
                }
                if (list == null && list.size() == stringArrayExtra.length) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                for (i17 = 0; i17 < stringArrayExtra.length; i17++) {
                    String str = stringArrayExtra[i17];
                    if (z18) {
                        trpcInovkeRsp = list.get(i17);
                    } else {
                        trpcInovkeRsp = null;
                    }
                    if (trpcInovkeRsp != null) {
                        i18 = trpcInovkeRsp.ret.get();
                    } else {
                        i18 = -1;
                    }
                    notifyListeners(intent, str, i18, trpcInovkeRsp);
                }
            }
        }
        list = null;
        stringArrayExtra = intent.getStringArrayExtra(WadlProxyConsts.PARAM_TRPCSSO_CMD_IDS);
        if (stringArrayExtra == null) {
        }
        if (z17) {
        }
        StringBuilder sb52 = new StringBuilder();
        sb52.append("onRespTrpcSso cmdArray=");
        sb52.append(stringArrayExtra.toString());
        sb52.append("sSucc=");
        sb52.append(z17);
        sb52.append(",ret=");
        sb52.append(j3);
        sb52.append(",trpcRspRetCode=");
        sb52.append(i3);
        sb52.append(",trpcRspFuncRetCode=");
        sb52.append(i16);
        sb52.append(",rspList size=");
        if (list == null) {
        }
        sb52.append(obj);
        QLog.d(TAG, 1, sb52.toString());
        if (list == null) {
        }
        z18 = false;
        while (i17 < stringArrayExtra.length) {
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void querySubscribeStatus(String str, String str2, Bundle bundle) {
        QQGameQfsSubscribe.GetUserGameStatusReq getUserGameStatusReq = new QQGameQfsSubscribe.GetUserGameStatusReq();
        if (!TextUtils.isEmpty(str)) {
            getUserGameStatusReq.appID.set(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            getUserGameStatusReq.channelID.set(str2);
        }
        getUserGameStatusReq.f436040tt.set(1);
        getUserGameStatusReq.needGameInfo.set(true);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS, false, getUserGameStatusReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        requestTrpc(trpcListReq, bundle);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void removeListener(WadlTrpcListener wadlTrpcListener) {
        if (wadlTrpcListener == null) {
            return;
        }
        Iterator<WeakReference<WadlTrpcListener>> it = this.trpcListeners.iterator();
        while (it.hasNext()) {
            WeakReference<WadlTrpcListener> next = it.next();
            WadlTrpcListener wadlTrpcListener2 = next.get();
            if (wadlTrpcListener2 != null && wadlTrpcListener2 == wadlTrpcListener) {
                QLog.d(TAG, 1, "removeListener listener=" + wadlTrpcListener + " " + this.trpcListeners.remove(next));
                return;
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void reportAtta(JSONObject jSONObject) {
        JSONArray jSONArray;
        String str;
        TrpcAttaProxy$ReportAttaListReq trpcAttaProxy$ReportAttaListReq;
        int i3;
        int i16;
        JSONObject jSONObject2;
        String str2 = TAG;
        int i17 = 1;
        if (jSONObject != null && jSONObject.has(WadlReportBuilder.KEY_REPORT_LIST)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(WadlReportBuilder.KEY_REPORT_LIST);
            TrpcAttaProxy$ReportAttaListReq trpcAttaProxy$ReportAttaListReq2 = new TrpcAttaProxy$ReportAttaListReq();
            int length = optJSONArray.length();
            int i18 = 0;
            int i19 = 0;
            while (i19 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i19);
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        QLog.w(str2, i17, "reportAtta data is null");
                    } else {
                        TrpcAttaProxy$AttaItem trpcAttaProxy$AttaItem = new TrpcAttaProxy$AttaItem();
                        trpcAttaProxy$AttaItem.attaId.set(optJSONObject.optString(WadlReportBuilder.KEY_DC_ID));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("uin", GameCenterUtil.getUin()));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.TIME_STAMP, String.valueOf(NetConnInfoCenter.getServerTime())));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("domain", "1"));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.GAMECENTER_VER, ""));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.GAMECENTER_VER_TYPE, "2"));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("device_type", Build.BRAND));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("net_type", getNetWorkType()));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("resolution", GameCenterUtil.getDeceiveMetrics()));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.IS_RED_POINT, "0"));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.IS_NEW_STATUS, "0"));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.GAMECENTER_SRC, "1"));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.RET_ID, String.valueOf(optJSONObject2.optInt(WadlReportBuilder.TableElem.RET_ID, i18))));
                        String optString = optJSONObject2.optString(WadlReportBuilder.TableElem.OPER_MOUDLE);
                        String optString2 = optJSONObject2.optString(WadlReportBuilder.TableElem.OPER_ID);
                        String optString3 = optJSONObject2.optString(WadlReportBuilder.TableElem.GAME_APPID);
                        String optString4 = optJSONObject2.optString(WadlReportBuilder.TableElem.TIANJI_REPORT_STR);
                        jSONArray = optJSONArray;
                        i3 = length;
                        String optString5 = optJSONObject2.optString(WadlReportBuilder.TableElem.APK_VOLUME);
                        str = str2;
                        i16 = i19;
                        String optString6 = optJSONObject2.optString(WadlReportBuilder.TableElem.EXT_MODULE);
                        TrpcAttaProxy$ReportAttaListReq trpcAttaProxy$ReportAttaListReq3 = trpcAttaProxy$ReportAttaListReq2;
                        String optString7 = optJSONObject2.optString(WadlReportBuilder.TableElem.EXT_SUB_MODULE);
                        if (!TextUtils.isEmpty(optString)) {
                            jSONObject2 = optJSONObject2;
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.OPER_MOUDLE, optString));
                        } else {
                            jSONObject2 = optJSONObject2;
                        }
                        if (!TextUtils.isEmpty(optString2)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.OPER_ID, optString2));
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.GAME_APPID, optString3));
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.TIANJI_REPORT_STR, optString4));
                        }
                        if (!TextUtils.isEmpty(optString5)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.APK_VOLUME, optString5));
                        }
                        if (!TextUtils.isEmpty(optString6)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.EXT_MODULE, optString6));
                        }
                        if (!TextUtils.isEmpty(optString7)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.EXT_SUB_MODULE, optString7));
                        }
                        int i26 = 1;
                        while (i26 <= WadlReportBuilder.MAX_EXT_SIZE) {
                            String str3 = "ext" + i26;
                            JSONObject jSONObject3 = jSONObject2;
                            if (jSONObject3.has(str3)) {
                                trpcAttaProxy$AttaItem.valueList.add(createAttaValue(str3, jSONObject3.optString(str3)));
                            }
                            i26++;
                            jSONObject2 = jSONObject3;
                        }
                        trpcAttaProxy$ReportAttaListReq = trpcAttaProxy$ReportAttaListReq3;
                        trpcAttaProxy$ReportAttaListReq.attaList.add(trpcAttaProxy$AttaItem);
                        i19 = i16 + 1;
                        trpcAttaProxy$ReportAttaListReq2 = trpcAttaProxy$ReportAttaListReq;
                        optJSONArray = jSONArray;
                        length = i3;
                        str2 = str;
                        i17 = 1;
                        i18 = 0;
                    }
                }
                jSONArray = optJSONArray;
                str = str2;
                trpcAttaProxy$ReportAttaListReq = trpcAttaProxy$ReportAttaListReq2;
                i3 = length;
                i16 = i19;
                i19 = i16 + 1;
                trpcAttaProxy$ReportAttaListReq2 = trpcAttaProxy$ReportAttaListReq;
                optJSONArray = jSONArray;
                length = i3;
                str2 = str;
                i17 = 1;
                i18 = 0;
            }
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_TRPC_ATTA_REPORT, true, trpcAttaProxy$ReportAttaListReq2.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            requestTrpc(trpcListReq, null);
            return;
        }
        QLog.w(TAG, 1, "reportAtta params error, reportData=" + jSONObject);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void reportAtta157(JSONObject jSONObject) {
        JSONArray jSONArray;
        int i3;
        int i16 = 1;
        if (jSONObject != null && jSONObject.has(WadlReportBuilder.KEY_REPORT_LIST)) {
            JSONArray optJSONArray = jSONObject.optJSONArray(WadlReportBuilder.KEY_REPORT_LIST);
            TrpcAttaProxy$ReportAttaListReq trpcAttaProxy$ReportAttaListReq = new TrpcAttaProxy$ReportAttaListReq();
            int length = optJSONArray.length();
            int i17 = 0;
            int i18 = 0;
            while (i18 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i18);
                if (optJSONObject != null) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        QLog.w(TAG, i16, "reportAtta data is null");
                    } else {
                        TrpcAttaProxy$AttaItem trpcAttaProxy$AttaItem = new TrpcAttaProxy$AttaItem();
                        trpcAttaProxy$AttaItem.attaId.set(optJSONObject.optString(WadlReportBuilder.KEY_DC_ID));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("uin", GameCenterUtil.getUin()));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.TIME_STAMP, String.valueOf(NetConnInfoCenter.getServerTime())));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(TPReportKeys.LiveExKeys.LIVE_EX_NET_TYPE, getNetWorkType()));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("domain", "1"));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue("devicetype", Build.BRAND));
                        trpcAttaProxy$AttaItem.valueList.add(createAttaValue(WadlReportBuilder.TableElem.RET_ID, String.valueOf(optJSONObject2.optInt(WadlReportBuilder.TableElem.RET_ID, i17))));
                        String optString = optJSONObject2.optString("page");
                        String optString2 = optJSONObject2.optString("business");
                        String optString3 = optJSONObject2.optString(WadlReportBuilder.TableElem.OPER_MOUDLE);
                        String optString4 = optJSONObject2.optString(WadlReportBuilder.TableElem.OPER_ID);
                        String optString5 = optJSONObject2.optString("logicId");
                        jSONArray = optJSONArray;
                        String optString6 = optJSONObject2.optString("opertype");
                        if (!TextUtils.isEmpty(optString)) {
                            i3 = length;
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue("page", optString));
                        } else {
                            i3 = length;
                        }
                        if (!TextUtils.isEmpty(optString2)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue("business", optString2));
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue("opermodule", optString3));
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue("operid", optString4));
                        }
                        if (!TextUtils.isEmpty(optString5)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue("logicid", optString5));
                        }
                        if (!TextUtils.isEmpty(optString6)) {
                            trpcAttaProxy$AttaItem.valueList.add(createAttaValue("opertype", optString6));
                        }
                        if (optJSONObject2.has("ext1")) {
                            String optString7 = optJSONObject2.optString("ext1");
                            if (!StringUtil.isEmpty(optString7)) {
                                trpcAttaProxy$AttaItem.valueList.add(createAttaValue("moduletype", optString7));
                            }
                        }
                        for (int i19 = 1; i19 <= 7; i19++) {
                            String str = "ext" + i19;
                            if (optJSONObject2.has(str)) {
                                trpcAttaProxy$AttaItem.valueList.add(createAttaValue(str, optJSONObject2.optString(str)));
                            }
                        }
                        trpcAttaProxy$ReportAttaListReq.attaList.add(trpcAttaProxy$AttaItem);
                        i18++;
                        optJSONArray = jSONArray;
                        length = i3;
                        i16 = 1;
                        i17 = 0;
                    }
                }
                jSONArray = optJSONArray;
                i3 = length;
                i18++;
                optJSONArray = jSONArray;
                length = i3;
                i16 = 1;
                i17 = 0;
            }
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_TRPC_ATTA_REPORT, true, trpcAttaProxy$ReportAttaListReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            requestTrpcForSpring(trpcListReq, null);
            return;
        }
        QLog.w(TAG, 1, "reportAtta params error, reportData=" + jSONObject);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void reportAttaV2(JSONObject jSONObject) {
        String str;
        if (jSONObject != null && jSONObject.has("data")) {
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "reportAttaV2 reportData=" + jSONObject);
            }
            TrpcAttaProxy$ReportAttaReq trpcAttaProxy$ReportAttaReq = new TrpcAttaProxy$ReportAttaReq();
            trpcAttaProxy$ReportAttaReq.f106729id.set(jSONObject.optString(WadlReportBuilder.KEY_DC_ID));
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            try {
                str = o.c();
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "get QIMEI fail");
                }
                str = "";
            }
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("uin", GameCenterUtil.getUin()));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("event_timestamp", String.valueOf(NetConnInfoCenter.getServerTime())));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("mq_ver", AppSetting.f99551k));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("device_number", str));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("device_rom", Build.VERSION.RELEASE));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("device_brand", Build.BRAND));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("device_model", DeviceInfoMonitor.getModel()));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("platform", "android"));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("net_type", getNetWorkType()));
            trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue("resolution", GameCenterUtil.getDeceiveMetrics()));
            Iterator keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                if (!TextUtils.isEmpty(str2)) {
                    String optString = optJSONObject.optString(str2);
                    if (!TextUtils.isEmpty(optString)) {
                        trpcAttaProxy$ReportAttaReq.attaValue.add(createAttaValue(str2, optString));
                    }
                }
            }
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_TRPC_ATTA_NEW_REPORT, true, trpcAttaProxy$ReportAttaReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            requestTrpc(trpcListReq, null);
            return;
        }
        QLog.w(TAG, 1, "reportAttaV2 params error, reportData=" + jSONObject);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void reportInstallAction(String str, String str2, int i3) {
        if (str2 == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "reportInstallAction params error,versionCode:" + i3 + "pkgName:" + str + "channelId:" + str2);
            return;
        }
        QLog.d(TAG, 1, "reportInstallAction versionCode=" + i3 + ",pkgName=" + str + ",channelId=" + str2);
        QQGameInstallActionReport$InstallActionReportReq qQGameInstallActionReport$InstallActionReportReq = new QQGameInstallActionReport$InstallActionReportReq();
        qQGameInstallActionReport$InstallActionReportReq.pkg_name.set(str);
        qQGameInstallActionReport$InstallActionReportReq.channel_id.set(str2);
        qQGameInstallActionReport$InstallActionReportReq.local_version.set(i3);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_REPORT_INSTALL_CHANNEL, false, qQGameInstallActionReport$InstallActionReportReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        requestTrpc(trpcListReq, null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void reportRealDownloadSpeed(long j3, QQGameDownloadSpeedReporter$GameDownloadInfo qQGameDownloadSpeedReporter$GameDownloadInfo) {
        QQGameDownloadSpeedReporter$ReportDownloadSpeedReq qQGameDownloadSpeedReporter$ReportDownloadSpeedReq = new QQGameDownloadSpeedReporter$ReportDownloadSpeedReq();
        qQGameDownloadSpeedReporter$ReportDownloadSpeedReq.current_rate.set(j3);
        qQGameDownloadSpeedReporter$ReportDownloadSpeedReq.game_download_info.set(qQGameDownloadSpeedReporter$GameDownloadInfo);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_REPORT_REAL_DOWNLOAD_SPEED, false, qQGameDownloadSpeedReporter$ReportDownloadSpeedReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        requestTrpc(trpcListReq, null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void reportTianJi(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        QLog.d(TAG, 1, "reportTianJi appId=" + str + ",eventId=" + str3 + ",eventType=" + str4 + ",eventType2=" + str5 + ",eventType3=" + str6 + ",eventResult=" + str7 + ",eventErrCode=" + str8 + ",expeSysTransfer=" + str2);
        ExpeDataAcc$AppInfo expeDataAcc$AppInfo = new ExpeDataAcc$AppInfo();
        expeDataAcc$AppInfo.appid.set(str);
        ExpeDataAcc$AccountInfo expeDataAcc$AccountInfo = new ExpeDataAcc$AccountInfo();
        expeDataAcc$AccountInfo.accountType.set(1L);
        expeDataAcc$AccountInfo.uid.set(GameCenterUtil.getUin());
        ExpeDataAcc$ExpeInfo expeDataAcc$ExpeInfo = new ExpeDataAcc$ExpeInfo();
        expeDataAcc$ExpeInfo.expeSysTransfer.set(str2);
        ExpeDataAcc$EventInfo expeDataAcc$EventInfo = new ExpeDataAcc$EventInfo();
        expeDataAcc$EventInfo.eventId.set(str3);
        expeDataAcc$EventInfo.eventType.set(str4);
        expeDataAcc$EventInfo.eventType2.set(str5);
        expeDataAcc$EventInfo.eventType3.set(str6);
        expeDataAcc$EventInfo.eventErrCode.set(str8);
        expeDataAcc$EventInfo.eventResult.set(str7);
        ExpeDataAcc$UserActionInfo expeDataAcc$UserActionInfo = new ExpeDataAcc$UserActionInfo();
        expeDataAcc$UserActionInfo.appInfo.set(expeDataAcc$AppInfo);
        expeDataAcc$UserActionInfo.accountInfo.set(expeDataAcc$AccountInfo);
        expeDataAcc$UserActionInfo.expeInfo.set(expeDataAcc$ExpeInfo);
        expeDataAcc$UserActionInfo.eventInfo.set(expeDataAcc$EventInfo);
        ExpeDataAcc$ExpeEventReportReq expeDataAcc$ExpeEventReportReq = new ExpeDataAcc$ExpeEventReportReq();
        expeDataAcc$ExpeEventReportReq.noNeedRsp.set(1);
        expeDataAcc$ExpeEventReportReq.actionInfos.add(expeDataAcc$UserActionInfo);
        TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_TRPC_TIANJI_REPORT, true, expeDataAcc$ExpeEventReportReq.toByteArray());
        TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
        trpcListReq.list.add(createTrpcInvokeReq);
        requestTrpc(trpcListReq, null);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void reportToDcByTrpc(JSONObject jSONObject) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w(TAG, 1, "reportToDcByTrpc params error appRuntime:" + peekAppRuntime);
            return;
        }
        if (jSONObject != null && jSONObject.optJSONObject("req") != null && jSONObject.optJSONObject("req").optJSONArray(WadlReportBuilder.KEY_REPORT_LIST) != null) {
            WadlTrpcReport$DcReportRequest dcReportReq = getDcReportReq(jSONObject);
            NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, WadlProxyConsts.CMD_TRPC_DC_REPORT);
            newIntent.putExtra(WadlProxyConsts.PARAM_WEBSSO_REQ, dcReportReq.toByteArray());
            newIntent.putExtra(WadlProxyConsts.KEY_SSO_TYPE, 2);
            peekAppRuntime.startServlet(newIntent);
            return;
        }
        QLog.w(TAG, 1, "reportToDcByTrpc params error reportData= " + jSONObject);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void requestTrpc(TrpcProxy.TrpcListReq trpcListReq, Bundle bundle) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && trpcListReq != null) {
            try {
                if (isUseCanaryEnv()) {
                    for (int i3 = 0; i3 < trpcListReq.list.size(); i3++) {
                        TrpcProxy.TrpcInovkeReq trpcInovkeReq = trpcListReq.list.get(i3);
                        TrpcProxy.TrpcMetaData trpcMetaData = new TrpcProxy.TrpcMetaData();
                        trpcMetaData.key.set("trpc-canary");
                        trpcMetaData.value.set(ByteStringMicro.copyFrom("1".getBytes()));
                        trpcInovkeReq.options.metaData2.add(trpcMetaData);
                    }
                }
                WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
                webSSOAgent$UniSsoServerReqComm.platform.set(109L);
                webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
                webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99554n);
                WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
                webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
                webSSOAgent$UniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(trpcListReq.toByteArray()));
                NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                List<TrpcProxy.TrpcInovkeReq> list = trpcListReq.list.get();
                int size = list.size();
                String[] strArr = new String[size];
                for (int i16 = 0; i16 < size; i16++) {
                    strArr[i16] = list.get(i16).f106730msg.clientRPCName.get();
                }
                bundle.putInt(WadlProxyConsts.KEY_SSO_TYPE, 1);
                bundle.putStringArray(WadlProxyConsts.PARAM_TRPCSSO_CMD_IDS, strArr);
                bundle.putByteArray(WadlProxyConsts.PARAM_WEBSSO_REQ, webSSOAgent$UniSsoServerReq.toByteArray());
                newIntent.putExtras(bundle);
                if (bundle.getBoolean(WadlProxyConsts.PARAM_WEBSSO_IS_WITHOUT_LOGIN)) {
                    newIntent.withouLogin = true;
                }
                peekAppRuntime.startServlet(newIntent);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "requestTrpc exception=", e16);
                return;
            }
        }
        QLog.w(TAG, 1, "requestTrpc params error, trpcListReq=" + trpcListReq + ",extra=" + bundle + ",appRuntime=" + peekAppRuntime);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void requestTrpcForSpring(TrpcProxy.TrpcListReq trpcListReq, Bundle bundle) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && trpcListReq != null) {
            try {
                WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
                webSSOAgent$UniSsoServerReqComm.platform.set(109L);
                webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
                webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99554n);
                WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
                webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
                webSSOAgent$UniSsoServerReq.pbReqData.set(ByteStringMicro.copyFrom(trpcListReq.toByteArray()));
                NewIntent newIntent = new NewIntent(MobileQQ.sMobileQQ, com.tencent.gamecenter.wadl.biz.b.class);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                List<TrpcProxy.TrpcInovkeReq> list = trpcListReq.list.get();
                int size = list.size();
                String[] strArr = new String[size];
                for (int i3 = 0; i3 < size; i3++) {
                    strArr[i3] = list.get(i3).f106730msg.clientRPCName.get();
                }
                bundle.putInt(WadlProxyConsts.KEY_SSO_TYPE, 3);
                bundle.putStringArray(WadlProxyConsts.PARAM_TRPCSSO_CMD_IDS, strArr);
                bundle.putByteArray(WadlProxyConsts.PARAM_WEBSSO_REQ, webSSOAgent$UniSsoServerReq.toByteArray());
                newIntent.putExtras(bundle);
                peekAppRuntime.startServlet(newIntent);
                return;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "requestTrpc exception=", e16);
                return;
            }
        }
        QLog.w(TAG, 1, "requestTrpc params error, trpcListReq=" + trpcListReq + ",extra=" + bundle + ",appRuntime=" + peekAppRuntime);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void setUseCanaryEnv(boolean z16) {
        p03.a.m(null).h(MMKV_KEY_USE_CANARY_ENV, z16);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void subscribe(String str, String str2, String str3, int i3, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            QQGameSubscribe$SubscribeUpComingGameReq qQGameSubscribe$SubscribeUpComingGameReq = new QQGameSubscribe$SubscribeUpComingGameReq();
            qQGameSubscribe$SubscribeUpComingGameReq.appID.set(str);
            qQGameSubscribe$SubscribeUpComingGameReq.source.set(str2);
            qQGameSubscribe$SubscribeUpComingGameReq.channelID.set(str3);
            qQGameSubscribe$SubscribeUpComingGameReq.subscribeType.set(i3);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_GAME_SUBSCRIBE, false, qQGameSubscribe$SubscribeUpComingGameReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            requestTrpc(trpcListReq, bundle);
            return;
        }
        QLog.e(TAG, 1, "[subscribe] params error,appId:" + str + ",source:" + str2 + ",channelId:" + str3);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void subscribeNewVersionReq(String str, String str2, String str3, Bundle bundle) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            QQGameSubscribe$SubscribeNewVersionReq qQGameSubscribe$SubscribeNewVersionReq = new QQGameSubscribe$SubscribeNewVersionReq();
            QQGameSubscribe$GameVersion qQGameSubscribe$GameVersion = new QQGameSubscribe$GameVersion();
            qQGameSubscribe$GameVersion.appid.set(str);
            qQGameSubscribe$SubscribeNewVersionReq.version.set(qQGameSubscribe$GameVersion);
            qQGameSubscribe$SubscribeNewVersionReq.source.set(str2);
            qQGameSubscribe$SubscribeNewVersionReq.channel_id.set(str3);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_GAME_SUBSCRIBE_NEW_VERSION, false, qQGameSubscribe$SubscribeNewVersionReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            requestTrpc(trpcListReq, bundle);
            return;
        }
        QLog.e(TAG, 1, "[SubscribeNewVersionReq] params error,appId:" + str + ",source:" + str2 + ",channelId:" + str3);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameTrpcService
    public void checkInstallChannel(int i3, int i16, String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QLog.d(TAG, 1, "checkInstallChannel from=" + i3 + ",source=" + i16 + ",appId=" + str + ",pkgName=" + str2 + ",channelId=" + str3);
            UserGameVersionPB$QueryGameChannelReq userGameVersionPB$QueryGameChannelReq = new UserGameVersionPB$QueryGameChannelReq();
            userGameVersionPB$QueryGameChannelReq.appid.set(str);
            userGameVersionPB$QueryGameChannelReq.channel_id.set(str3);
            userGameVersionPB$QueryGameChannelReq.source.set(i16);
            Bundle bundle = new Bundle();
            bundle.putString("appid", str);
            bundle.putString("packageName", str2);
            bundle.putString(WadlProxyConsts.CHANNEL, str3);
            bundle.putInt("actionFrom", i3);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = createTrpcInvokeReq(WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL, false, userGameVersionPB$QueryGameChannelReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            requestTrpc(trpcListReq, bundle);
            return;
        }
        QLog.e(TAG, 1, "[checkInstallChannel] params error,appId:" + str + "pkgName:" + str2 + "channelId:" + str3);
    }
}
