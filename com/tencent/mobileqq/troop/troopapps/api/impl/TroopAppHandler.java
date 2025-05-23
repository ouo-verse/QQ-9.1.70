package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.os.Bundle;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAppService;
import com.tencent.mobileqq.utils.j;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x9ab.oidb_0x9ab$GroupTabList;
import tencent.im.oidb.cmd0x9ab.oidb_0x9ab$RspBody;
import tencent.im.oidb.cmd0x9ab.oidb_0x9ab$TabItem;
import tencent.im.oidb.cmd0xb70.oidb_0xb70$RspBody;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e$ClientInfo;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e$ReqBody;
import tencent.im.oidb.cmd0xe2e.oidb_0xe2e$RspBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$ClientInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$ReqBody;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$RspBody;
import tencent.im.oidb.cmd0xece.oidb_0xece$ClientInfo;
import tencent.im.oidb.cmd0xece.oidb_0xece$ReqBody;
import tencent.im.oidb.cmd0xece.oidb_0xece$RspBody;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02$AppInfo;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02$ReqBody;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02$Result;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02$RspBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04$AppInfo;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04$ReqBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04$RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05$AppInfo;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05$ReqBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05$Result;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAppHandler extends TroopBaseHandler implements com.tencent.mobileqq.troop.troopapps.api.a {
    static IPatchRedirector $redirector_;

    public TroopAppHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void H2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        ArrayList<Integer> integerArrayList = toServiceMsg.extraData.getIntegerArrayList("appids");
        int i3 = toServiceMsg.extraData.getInt(NotifyMsgApiImpl.KEY_GROUP_TYPE);
        if (obj != null && fromServiceMsg.isSuccess()) {
            cmd0xca05$RspBody cmd0xca05_rspbody = new cmd0xca05$RspBody();
            try {
                cmd0xca05_rspbody.mergeFrom((byte[]) obj);
                int i16 = cmd0xca05_rspbody.uint32_res.get();
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "handleClearTroopAppRedPoint, retCode:" + i16);
                }
                if (i16 == 0) {
                    List<cmd0xca05$Result> list = cmd0xca05_rspbody.rpt_result.get();
                    ITroopAppService iTroopAppService = (ITroopAppService) this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
                    ITroopAioAppService iTroopAioAppService = (ITroopAioAppService) this.appRuntime.getRuntimeService(ITroopAioAppService.class, "");
                    if (iTroopAppService != null) {
                        iTroopAppService.saveAppListTimestamp(cmd0xca05_rspbody.uint32_timestamp.get(), i3);
                        for (int i17 = 0; i17 < integerArrayList.size(); i17++) {
                            iTroopAppService.clearLocalTroopAppRedPoint(integerArrayList.get(i17).intValue());
                            iTroopAioAppService.clearRedDotInCacheAndDb(integerArrayList.get(i17).intValue());
                        }
                        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299365h, true, new Object[]{integerArrayList, list});
                        return;
                    }
                    return;
                }
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299365h, false, null);
                return;
            } catch (Exception unused) {
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299365h, false, new Object[]{integerArrayList, null});
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "Exception, handleClearTroopAppRedPoint");
                    return;
                }
                return;
            }
        }
        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299365h, false, new Object[]{integerArrayList, null});
    }

    private void I2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        if (toServiceMsg != null && fromServiceMsg != null) {
            Bundle bundle = toServiceMsg.extraData;
            if (bundle != null) {
                j3 = bundle.getLong("troopUin");
            } else {
                j3 = 0;
            }
            oidb_0xece$RspBody oidb_0xece_rspbody = new oidb_0xece$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xece_rspbody);
            if (parseOIDBPkg == 0) {
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.C, true, new Object[]{Long.valueOf(j3), oidb_0xece_rspbody, Integer.valueOf(parseOIDBPkg)});
                return;
            }
            QLog.i("TroopAppHandler", 2, "handleGetAddTroopAppRemindInfo failed result:" + parseOIDBPkg);
            notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.C, false, new Object[]{Long.valueOf(j3), oidb_0xece_rspbody, Integer.valueOf(parseOIDBPkg)});
            return;
        }
        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.C, false, new Object[]{0, null, -1});
    }

    private void J2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            oidb_0xe2e$RspBody oidb_0xe2e_rspbody = new oidb_0xe2e$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xe2e_rspbody);
            if (parseOIDBPkg == 0) {
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299367m, true, new Object[]{toServiceMsg.extraData, oidb_0xe2e_rspbody, Integer.valueOf(parseOIDBPkg)});
                return;
            }
            QLog.i("TroopAppHandler", 2, "handleGetShortcutTroopApps failed result:" + parseOIDBPkg);
            notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299367m, false, new Object[]{toServiceMsg.extraData, oidb_0xe2e_rspbody, Integer.valueOf(parseOIDBPkg)});
            return;
        }
        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299367m, false, new Object[]{0, null, -1});
    }

    private void K2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        List<Integer> list;
        if (obj != null && fromServiceMsg.isSuccess()) {
            int i3 = toServiceMsg.extraData.getInt("readType");
            int i16 = toServiceMsg.extraData.getInt(NotifyMsgApiImpl.KEY_GROUP_TYPE);
            boolean z16 = toServiceMsg.extraData.getBoolean("appListChangedFromWebOperate");
            if (i3 != 2 && i3 != 1) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppHandler.troop.troop_app", 2, "handleGetTroopAppList(), readType: ", Integer.valueOf(i3), " ,groupType: ", Integer.valueOf(i16));
            }
            cmd0xca02$RspBody cmd0xca02_rspbody = new cmd0xca02$RspBody();
            try {
                cmd0xca02_rspbody.mergeFrom((byte[]) obj);
                if (cmd0xca02_rspbody.uint32_res.get() == 0) {
                    ITroopAppService iTroopAppService = (ITroopAppService) this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
                    if (iTroopAppService == null) {
                        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299363e, false, new Object[]{null});
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopAppHandler.troop.troop_app", 2, "handleGetTroopAppList==>troopAppMgr == null");
                            return;
                        }
                        return;
                    }
                    if (z16) {
                        iTroopAppService.setAppListChangedFromWebOperate(false);
                    }
                    iTroopAppService.saveAppListTimestamp(cmd0xca02_rspbody.uint32_timestamp.get(), i16);
                    iTroopAppService.setCheckedUpdateAfterLogined(true, i16);
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopAppHandler.troop.troop_app", 2, "handleGetTroopAppList==>appListTimestamp:" + cmd0xca02_rspbody.uint32_timestamp.get());
                    }
                    List<cmd0xca02$Result> list2 = cmd0xca02_rspbody.rpt_result.get();
                    ArrayList<TroopAIOAppInfo> arrayList = new ArrayList<>();
                    if (i3 == 1) {
                        list = new ArrayList<>();
                    } else {
                        list = null;
                    }
                    List<Integer> arrayList2 = new ArrayList<>();
                    for (cmd0xca02$Result cmd0xca02_result : list2) {
                        if (cmd0xca02_result.uint32_id.get() > 0) {
                            if (cmd0xca02_result.uint32_res.get() == 2) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("TroopAppHandler.troop.troop_app", 2, "result.uint32_res.get() == 2|appid:" + cmd0xca02_result.uint32_id.get() + "|appName:" + cmd0xca02_result.string_name.get().toStringUtf8());
                                }
                                iTroopAppService.removeTroopAppByAppid(cmd0xca02_result.uint32_id.get(), i16);
                            } else {
                                TroopAIOAppInfo troopAIOAppInfo = new TroopAIOAppInfo();
                                S2(troopAIOAppInfo, cmd0xca02_result);
                                troopAIOAppInfo.groupType = i16;
                                if (i3 == 1) {
                                    troopAIOAppInfo = M2(i16, list, arrayList2, troopAIOAppInfo);
                                }
                                arrayList.add(troopAIOAppInfo);
                            }
                        }
                    }
                    L2(i3, i16, cmd0xca02_rspbody, arrayList, list, arrayList2);
                    return;
                }
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299363e, false, new Object[]{null});
                return;
            } catch (Exception unused) {
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299363e, false, new Object[]{null});
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "Exception, handleGetTroopAppList");
                    return;
                }
                return;
            }
        }
        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299363e, false, new Object[]{null});
    }

    private void L2(int i3, int i16, cmd0xca02$RspBody cmd0xca02_rspbody, ArrayList<TroopAIOAppInfo> arrayList, List<Integer> list, List<Integer> list2) {
        ITroopAppService iTroopAppService = (ITroopAppService) this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
        if (i3 == 1) {
            iTroopAppService.update0xca02Info(cmd0xca02_rspbody.all_app_wording.get());
        }
        iTroopAppService.updateAppInfoCalendarDay(i16);
        if (i3 == 1) {
            if (iTroopAppService.makeAppidsInOrder(list2, i16) && list.isEmpty()) {
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299363e, true, new Object[]{null});
            }
            if (!list.isEmpty()) {
                G2(2, i16, list, false);
                return;
            }
            return;
        }
        iTroopAppService.addTroopAppInfos(arrayList, i16);
        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299363e, true, new Object[]{null});
    }

    private TroopAIOAppInfo M2(int i3, List<Integer> list, List<Integer> list2, TroopAIOAppInfo troopAIOAppInfo) {
        String troopAIOAppInfo2;
        list2.add(Integer.valueOf(troopAIOAppInfo.appid));
        if (!list.contains(Integer.valueOf(troopAIOAppInfo.appid))) {
            ITroopAppService iTroopAppService = (ITroopAppService) this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
            if (iTroopAppService.needRequestDetail(troopAIOAppInfo)) {
                iTroopAppService.ensureAppInfoExist(troopAIOAppInfo);
                list.add(Integer.valueOf(troopAIOAppInfo.appid));
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.TAG_TROOP_APP, 2, "troopAppInfo need detail:" + troopAIOAppInfo.toString());
                }
            } else {
                troopAIOAppInfo = iTroopAppService.getAppInfo(troopAIOAppInfo.appid, i3);
                j.b(troopAIOAppInfo);
                if (QLog.isColorLevel()) {
                    if (("troopAppInfo not need detail:" + troopAIOAppInfo) == null) {
                        troopAIOAppInfo2 = "null";
                    } else {
                        troopAIOAppInfo2 = troopAIOAppInfo.toString();
                    }
                    QLog.d(LogTag.TAG_TROOP_APP, 2, troopAIOAppInfo2);
                }
            }
        }
        return troopAIOAppInfo;
    }

    private void N2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str = (String) toServiceMsg.extraData.get("troopUin");
        boolean z16 = toServiceMsg.extraData.getBoolean("isProfileAppListChangedFromWebOperate");
        if (!fromServiceMsg.isSuccess()) {
            ReportController.o(this.appRuntime, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, -1, str, "", "", "");
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            int i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i3 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TroopAppHandler.troop.troop_app", 2, "mGetTroopAppListObserver: result = " + i3);
                    return;
                }
                return;
            }
            oidb_0xe83$RspBody oidb_0xe83_rspbody = new oidb_0xe83$RspBody();
            byte[] byteArray = oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray();
            int i16 = oidb_sso_oidbssopkg.uint32_service_type.get();
            ((ITroopManagerService) this.appRuntime.getRuntimeService(ITroopManagerService.class, "")).setTroopAppListData(str, byteArray);
            if (z16) {
                ((ITroopAppService) this.appRuntime.getRuntimeService(ITroopAppService.class, "all")).setProfileAppListChangedFromWebOperate(false, str);
            }
            oidb_0xe83_rspbody.mergeFrom(byteArray);
            notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299366i, true, new Object[]{oidb_0xe83_rspbody, Integer.valueOf(i16)});
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopAppHandler.troop.troop_app", 2, "mGetTroopAppListObserver: " + e16.getMessage());
            }
        }
    }

    private void O2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj != null && fromServiceMsg.isSuccess()) {
            ArrayList<Integer> integerArrayList = toServiceMsg.extraData.getIntegerArrayList("appidList2sort");
            cmd0xca04$RspBody cmd0xca04_rspbody = new cmd0xca04$RspBody();
            try {
                cmd0xca04_rspbody.mergeFrom((byte[]) obj);
                int i3 = cmd0xca04_rspbody.uint32_res.get();
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "onrecive, cmd_troop_sort_app_list, re:" + i3);
                }
                if (i3 == 0) {
                    ITroopAppService iTroopAppService = (ITroopAppService) this.appRuntime.getRuntimeService(ITroopAppService.class, "all");
                    if (iTroopAppService == null) {
                        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299364f, false, null);
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopAppHandler.troop.troop_app", 2, "troopAppMgr == null");
                            return;
                        }
                        return;
                    }
                    iTroopAppService.saveAppListTimestamp(cmd0xca04_rspbody.uint32_timestamp.get(), 0);
                    iTroopAppService.makeAppidsInOrder(integerArrayList, 0);
                    notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299364f, true, null);
                    ((TroopAppHandler) this.appRuntime.getBusinessHandler(TroopAppHandler.class.getName())).G2(2, 0, toServiceMsg.extraData.getIntegerArrayList("appidToAdd"), false);
                    return;
                }
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299364f, false, null);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "sort troop apps falied, rspBody.uint32_res:" + i3);
                    return;
                }
                return;
            } catch (Exception unused) {
                notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299364f, false, null);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "Exception, handleSortTroopAppList");
                    return;
                }
                return;
            }
        }
        notifyUI(com.tencent.mobileqq.troop.troopapps.api.b.f299364f, false, null);
    }

    private void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, new MessageMicro<oidb_0xb70$RspBody>() { // from class: tencent.im.oidb.cmd0xb70.oidb_0xb70$RspBody
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xb70$RspBody.class);
            });
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppHandler", 2, "handleTroopAppFeedsReaded retCode = " + parseOIDBPkg + "troopUin = " + toServiceMsg.extraData.getString("troopUin") + " appId = " + toServiceMsg.extraData.getLong("appId"));
            }
        } catch (Exception e16) {
            QLog.e("TroopAppHandler", 1, "handleTroopAppFeedsReaded failed!", e16);
        }
    }

    private void S2(TroopAIOAppInfo troopAIOAppInfo, cmd0xca02$Result cmd0xca02_result) {
        troopAIOAppInfo.appid = cmd0xca02_result.uint32_id.get();
        troopAIOAppInfo.name = cmd0xca02_result.string_name.get().toStringUtf8();
        troopAIOAppInfo.canRemove = cmd0xca02_result.bool_can_remove.get();
        troopAIOAppInfo.hashVal = cmd0xca02_result.string_hash_val.get().toStringUtf8();
        troopAIOAppInfo.redPoint = cmd0xca02_result.bool_red_point.get();
        troopAIOAppInfo.iconUrl = cmd0xca02_result.string_icon.get().toStringUtf8();
        troopAIOAppInfo.url = cmd0xca02_result.string_url.get().toStringUtf8();
        if (cmd0xca02_result.msg_app_info.get().plat_type.get() == 2) {
            troopAIOAppInfo.minVersion = cmd0xca02_result.msg_app_info.get().str_app_version.get();
        }
        if (!TroopAIOAppInfo.checkVersion(troopAIOAppInfo.minVersion)) {
            troopAIOAppInfo.minVersion = "0";
        }
        troopAIOAppInfo.identifyMask = cmd0xca02_result.uint32_identify_visibilty.get();
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

    public void F2(ArrayList<Integer> arrayList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList, i3);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopAppHandler.troop.troop_app", 2, "getTroopAppList: start");
            }
            cmd0xca05$ReqBody cmd0xca05_reqbody = new cmd0xca05$ReqBody();
            cmd0xca05_reqbody.uint32_type.set(0);
            cmd0xca05$AppInfo cmd0xca05_appinfo = new cmd0xca05$AppInfo();
            cmd0xca05_appinfo.plat_type.set(2);
            cmd0xca05_appinfo.str_app_version.set(AppSetting.f99551k);
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                Integer num = arrayList.get(i16);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "redPoint appid:" + num);
                }
                cmd0xca05_reqbody.rpt_app_ids.add(Long.valueOf(num.intValue() + 0));
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg("GroupOpen.ClearRedPoint");
            createToServiceMsg.putWupBuffer(cmd0xca05_reqbody.toByteArray());
            createToServiceMsg.extraData.putIntegerArrayList("appids", arrayList);
            createToServiceMsg.extraData.putInt(NotifyMsgApiImpl.KEY_GROUP_TYPE, i3);
            sendPbReq(createToServiceMsg);
        }
    }

    public void G2(int i3, int i16, List<Integer> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), list, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppHandler.troop.troop_app", 2, "getTroopAppList: start", "readType: ", Integer.valueOf(i3), " ,groupType: ", Integer.valueOf(i16));
        }
        cmd0xca02$ReqBody cmd0xca02_reqbody = new cmd0xca02$ReqBody();
        cmd0xca02_reqbody.uint32_type.set(i3);
        cmd0xca02$AppInfo cmd0xca02_appinfo = new cmd0xca02$AppInfo();
        cmd0xca02_appinfo.plat_type.set(2);
        cmd0xca02_appinfo.str_app_version.set(AppSetting.f99551k);
        cmd0xca02_reqbody.msg_app_info.set(cmd0xca02_appinfo);
        if (i16 != 0) {
            cmd0xca02_reqbody.uint32_group_type.set(i16);
        }
        if (i3 == 2) {
            if (list != null && !list.isEmpty()) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    cmd0xca02_reqbody.rpt_app_ids.add(it.next());
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler.troop.troop_app", 2, "invaliedAppids.isEmpty");
                    return;
                }
                return;
            }
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("GroupOpen.ReadAppList");
        createToServiceMsg.putWupBuffer(cmd0xca02_reqbody.toByteArray());
        createToServiceMsg.extraData.putInt("readType", i3);
        createToServiceMsg.extraData.putBoolean("appListChangedFromWebOperate", z16);
        createToServiceMsg.extraData.putInt(NotifyMsgApiImpl.KEY_GROUP_TYPE, i16);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.a
    public void N1(long j3, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        oidb_0xe2e$ReqBody oidb_0xe2e_reqbody = new oidb_0xe2e$ReqBody();
        oidb_0xe2e$ClientInfo oidb_0xe2e_clientinfo = new oidb_0xe2e$ClientInfo();
        oidb_0xe2e_clientinfo.platform.set(2);
        oidb_0xe2e_clientinfo.version.set(AppSetting.f99551k + "." + AppSetting.f99542b);
        oidb_0xe2e_reqbody.client.set(oidb_0xe2e_clientinfo);
        oidb_0xe2e_reqbody.group_id.set(j3);
        oidb_0xe2e_reqbody.group_type.set(i3);
        oidb_0xe2e_reqbody.redpoint.set(1);
        oidb_0xe2e_reqbody.page.set(i16);
        oidb_0xe2e_reqbody.num.set(i17);
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            oidb_0xe2e_reqbody.mode.set(1);
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3630);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xe2e_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xe2e_1");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(5000L);
        createToServiceMsg.extraData.putLong("troopuin", j3);
        createToServiceMsg.extraData.putInt("page", i16);
        createToServiceMsg.extraData.putInt(WidgetCacheConstellationData.NUM, i17);
        createToServiceMsg.extraData.putInt("from", i18);
        sendPbReq(createToServiceMsg);
    }

    public void Q2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.getResultCode() == 1000) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null) {
                    int i3 = mergeFrom.uint32_result.get();
                    if (QLog.isDevelopLevel()) {
                        QLog.i("Q.troopgetnews..troop.notification_center", 4, "handle_oidb_0xf110_1|oidb_sso.OIDBSSOPkg.result = " + i3);
                    }
                }
                if (mergeFrom != null && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    byte[] byteArray = mergeFrom.bytes_bodybuffer.get().toByteArray();
                    try {
                        oidb_0x9ab$RspBody oidb_0x9ab_rspbody = new oidb_0x9ab$RspBody();
                        oidb_0x9ab_rspbody.mergeFrom(byteArray);
                        oidb_0x9ab$GroupTabList oidb_0x9ab_grouptablist = oidb_0x9ab_rspbody.list.get();
                        List<oidb_0x9ab$TabItem> list = oidb_0x9ab_grouptablist.rpt_tab_list.get();
                        long j3 = oidb_0x9ab_grouptablist.uint32_curr_tab_id.get();
                        if (j3 == 4) {
                            new String(list.get((int) j3).byt_tab_wording.get().toByteArray());
                            ((ITroopAppService) this.appRuntime.getRuntimeService(ITroopAppService.class, "all")).getTroopAppList(true, 0);
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.troopgetnews..troop.notification_center", 4, "handle_oidb_0xf110 | oidb_sso parseFrom byte " + e16.toString());
                }
            }
        }
    }

    public void R2(int i3, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), arrayList, arrayList2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppHandler.troop.troop_app", 2, "modifyTroopAppList, start==>appListTimestamp:" + i3);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            cmd0xca04$ReqBody cmd0xca04_reqbody = new cmd0xca04$ReqBody();
            cmd0xca04_reqbody.uint32_timestamp.set(i3);
            cmd0xca04$AppInfo cmd0xca04_appinfo = new cmd0xca04$AppInfo();
            cmd0xca04_appinfo.plat_type.set(2);
            cmd0xca04_appinfo.str_app_version.set(AppSetting.f99551k);
            cmd0xca04_reqbody.msg_app_info.set(cmd0xca04_appinfo);
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (next.intValue() > 0) {
                    cmd0xca04_reqbody.rpt_uint32_appids.add(next);
                }
            }
            ToServiceMsg createToServiceMsg = createToServiceMsg("GroupOpen.SortAppList");
            createToServiceMsg.putWupBuffer(cmd0xca04_reqbody.toByteArray());
            createToServiceMsg.extraData.putIntegerArrayList("appidList2sort", arrayList);
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                createToServiceMsg.extraData.putIntegerArrayList("appidToAdd", arrayList2);
            }
            sendPbReq(createToServiceMsg);
        }
    }

    public void T2(int i3, ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) arrayList);
        } else {
            R2(i3, arrayList, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.a
    public void Z1(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, j3);
            return;
        }
        oidb_0xece$ReqBody oidb_0xece_reqbody = new oidb_0xece$ReqBody();
        oidb_0xece$ClientInfo oidb_0xece_clientinfo = new oidb_0xece$ClientInfo();
        oidb_0xece_clientinfo.platform.set(2);
        oidb_0xece_clientinfo.version.set(AppSetting.f99551k + "." + AppSetting.f99542b);
        oidb_0xece_reqbody.client_info.set(oidb_0xece_clientinfo);
        oidb_0xece_reqbody.from.set(2);
        oidb_0xece_reqbody.group_id.set(j3);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3790);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0xece_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTcp.0xece_1");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.setTimeout(5000L);
        createToServiceMsg.extraData.putLong("troopUin", j3);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("GroupOpen.ReadAppList");
            this.allowCmdSet.add("GroupOpen.SortAppList");
            this.allowCmdSet.add("GroupOpen.ClearRedPoint");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0x91fe");
            this.allowCmdSet.add("OidbSvc.0xb70_1");
            this.allowCmdSet.add("OidbSvc.0xe2e_1");
            this.allowCmdSet.add("OidbSvcTcp.0xece_1");
            this.allowCmdSet.add("OidbSvc.0x9ab_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopAppHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.troop.troopapps.api.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopAppHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("GroupOpen.ReadAppList".equals(fromServiceMsg.getServiceCmd())) {
                K2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("GroupOpen.SortAppList".equals(fromServiceMsg.getServiceCmd())) {
                O2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("GroupOpen.ClearRedPoint".equals(fromServiceMsg.getServiceCmd())) {
                H2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvcTrpcTcp.0x91fe".equals(fromServiceMsg.getServiceCmd())) {
                N2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0xb70_1".equals(fromServiceMsg.getServiceCmd())) {
                P2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("OidbSvc.0xe2e_1".equals(fromServiceMsg.getServiceCmd())) {
                J2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("OidbSvcTcp.0xece_1".equals(fromServiceMsg.getServiceCmd())) {
                I2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("OidbSvc.0x9ab_1".equals(fromServiceMsg.getServiceCmd())) {
                    Q2(toServiceMsg, fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopAppHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopapps.api.a
    public void x1(String str, boolean z16, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        long convertUin = convertUin(str);
        if (convertUin == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopAppHandler.troop.troop_app", 2, "getNewTroopAppList troopUin invalid. str=", str);
                return;
            }
            return;
        }
        oidb_0xe83$ClientInfo oidb_0xe83_clientinfo = new oidb_0xe83$ClientInfo();
        oidb_0xe83_clientinfo.platform.set(2);
        oidb_0xe83_clientinfo.version.set(AppSetting.f99551k);
        oidb_0xe83$ReqBody oidb_0xe83_reqbody = new oidb_0xe83$ReqBody();
        oidb_0xe83_reqbody.group_id.set(convertUin);
        oidb_0xe83_reqbody.client_info.set(oidb_0xe83_clientinfo);
        oidb_0xe83_reqbody.last_game_dynamic_ts.set(i3);
        if (i17 > 0) {
            oidb_0xe83_reqbody.mode.set(i17);
        }
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvcTrpcTcp.0x91fe", 37374, i16, oidb_0xe83_reqbody.toByteArray());
        makeOIDBPkg.extraData.putString("troopUin", str);
        makeOIDBPkg.extraData.putBoolean("isProfileAppListChangedFromWebOperate", z16);
        if (QLog.isColorLevel()) {
            QLog.i("TroopAppHandler", 1, "getNewTroopAppList. troopUin = " + str + ", isProfileAppListChangedFromWebOperate = " + z16 + ", time=" + i3);
        }
        sendPbReq(makeOIDBPkg);
    }
}
