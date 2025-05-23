package com.tencent.gamecenter.wadl.api.impl;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlParamsExt;
import com.tencent.gamecenter.wadl.biz.entity.WadlParamsPageInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.i;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameAutoDownloadTask$PreDownloadInfo;
import tencent.im.qqgame.QQGameAutoUpdateTask$PreUpdateInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameDLReportServiceImpl implements IQQGameDLReportService {
    private static final HashSet<Integer> EVENT_FILTER;
    static String TAG = "Wadl_QQGameDLReportServiceImpl";

    static {
        HashSet<Integer> hashSet = new HashSet<>();
        EVENT_FILTER = hashSet;
        hashSet.add(1006);
        hashSet.add(1008);
        hashSet.add(1005);
        hashSet.add(1007);
        hashSet.add(2002);
    }

    private com.tencent.gamecenter.wadl.biz.entity.d createAttaReport(WadlParams wadlParams) {
        boolean z16;
        Object obj;
        String str;
        String str2;
        String str3;
        String str4;
        com.tencent.gamecenter.wadl.biz.entity.d dVar = new com.tencent.gamecenter.wadl.biz.entity.d();
        boolean z17 = false;
        if (!wadlParams.getFlagEnable(65536) && wadlParams.isDirectUseDualWay != 1) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str5 = "0";
        String str6 = "1";
        if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).hasSimCard()) {
            obj = "0";
        } else {
            obj = "1";
        }
        if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isFlowSwitchOn()) {
            str = "0";
        } else {
            str = "1";
        }
        if (z16 && "1".equals(obj) && "1".equals(str)) {
            z17 = true;
        }
        com.tencent.gamecenter.wadl.biz.entity.d j3 = dVar.k(wadlParams.appId).d(wadlParams.adtag).l(wadlParams.appName).r(wadlParams.packageName).j(1, String.valueOf(wadlParams.downloadType)).j(3, wadlParams.apkUrl).j(4, wadlParams.apkChannel);
        if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard()) {
            str2 = "0";
        } else {
            str2 = "1";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j16 = j3.j(6, str2);
        if (!z17) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j17 = j16.j(7, str3);
        if (!AppNetConnInfo.isWifiConn()) {
            str5 = "1";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j18 = j17.j(8, str5).j(11, String.valueOf(wadlParams.versionCode));
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(BaseApplication.getContext())) {
            str4 = "1";
        } else {
            str4 = "2";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j19 = j18.j(14, str4);
        if (!GameCenterUtil.checkInstallPermission()) {
            str6 = "2";
        }
        j19.j(15, str6).j(24, String.valueOf(wadlParams.dualSwitch)).j(25, String.valueOf(getUseDynamicSectionValue()));
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 1, "createAttaReport isDirectUseDualWay:" + wadlParams.isDirectUseDualWay + ",isFlowSwitchOn:" + str);
        }
        WadlParamsPageInfo wadlParamsPageInfo = wadlParams.wadlParamsPageInfo;
        if (wadlParamsPageInfo != null) {
            dVar.p(wadlParamsPageInfo.f106739d).q(wadlParams.wadlParamsPageInfo.f106740e).m(wadlParams.wadlParamsPageInfo.f106741f).n(wadlParams.wadlParamsPageInfo.f106742h).u(wadlParams.wadlParamsPageInfo.f106743i).v(wadlParams.wadlParamsPageInfo.f106744m).g(wadlParams.wadlParamsPageInfo.C).f(wadlParams.wadlParamsPageInfo.D).s(wadlParams.wadlParamsPageInfo.E);
        }
        WadlParamsExt wadlParamsExt = wadlParams.wadlParamsExt;
        if (wadlParamsExt != null) {
            dVar.t(wadlParamsExt.f106737i).c(wadlParams.wadlParamsExt.C).i(wadlParams.wadlParamsExt.f106738m).j(2, wadlParams.wadlParamsExt.f106736h).j(16, wadlParams.wadlParamsExt.E).j(17, wadlParams.wadlParamsExt.F).j(18, wadlParams.wadlParamsExt.G).j(19, wadlParams.wadlParamsExt.H).j(20, wadlParams.wadlParamsExt.I).j(23, wadlParams.wadlParamsExt.D);
        }
        return dVar;
    }

    private static int getUseDynamicSectionValue() {
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF, "");
        if (!TextUtils.isEmpty(loadAsString)) {
            try {
                JSONObject optJSONObject = new JSONObject(loadAsString).optJSONObject("dual");
                if (optJSONObject != null) {
                    return optJSONObject.optInt("use_dynamic_section", 0);
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "getUseDynamicSectionValue exception", e16);
            }
        }
        return 0;
    }

    private void onDownloadComplete(int i3, WadlResult wadlResult, com.tencent.gamecenter.wadl.biz.entity.d dVar) {
        dVar.j(9, "");
        dVar.j(10, String.valueOf(wadlResult.speed));
        if (i3 == 1) {
            dVar.o("2000899");
            dVar.h("download_success");
            return;
        }
        if (i3 == 2) {
            dVar.o("2000905");
            dVar.q("page_auto_download_virtual_page");
            dVar.h("download_success");
        } else if (i3 == 3) {
            dVar.o("2000917");
            dVar.h("update_success");
        } else if (i3 == 4) {
            dVar.o("2000911");
            dVar.q("page_auto_update_virtual_page");
            dVar.h("update_success");
        } else if (i3 == 5) {
            dVar.o("2000923");
            dVar.q("page_auto_update_check");
            dVar.h("interrupt_success");
        }
    }

    private void onDownloadDelete(int i3, com.tencent.gamecenter.wadl.biz.entity.d dVar) {
        if (i3 == 1) {
            dVar.o("2000950");
            dVar.h("download_delete");
            return;
        }
        if (i3 == 2) {
            dVar.o("2000951");
            dVar.q("page_auto_download_virtual_page");
            dVar.h("download_delete");
        } else if (i3 == 3) {
            dVar.o("2000953");
            dVar.h("update_delete");
        } else if (i3 == 4) {
            dVar.o("2000952");
            dVar.q("page_auto_update_virtual_page");
            dVar.h("update_delete");
        } else if (i3 == 5) {
            dVar.o("2000954");
            dVar.q("page_auto_update_check");
            dVar.h("interrupt_delete");
        }
    }

    private void onDownloadFail(int i3, WadlResult wadlResult, com.tencent.gamecenter.wadl.biz.entity.d dVar) {
        dVar.j(9, String.valueOf(wadlResult.errCode));
        if (i3 == 1) {
            dVar.o("2000901");
            dVar.h("download_fail");
            return;
        }
        if (i3 == 2) {
            dVar.o("2000907");
            dVar.q("page_auto_download_virtual_page");
            dVar.h("download_fail");
        } else if (i3 == 3) {
            dVar.o("2000919");
            dVar.h("update_fail");
        } else if (i3 == 4) {
            dVar.o("2000913");
            dVar.q("page_auto_update_virtual_page");
            dVar.h("update_fail");
        } else if (i3 == 5) {
            dVar.o("2000924");
            dVar.q("page_auto_update_check");
            dVar.h("interrupt_fail");
        }
    }

    private void onDownloadPause(int i3, WadlResult wadlResult, com.tencent.gamecenter.wadl.biz.entity.d dVar) {
        if (i3 == 1) {
            dVar.o("2000900");
            dVar.h("download_pause");
        } else if (i3 == 2) {
            dVar.o("2000906");
            dVar.q("page_auto_download_virtual_page");
            dVar.h("download_pause");
        } else if (i3 == 3) {
            dVar.o("2000918");
            dVar.h("update_pause");
        } else if (i3 == 4) {
            dVar.o("2000912");
            dVar.q("page_auto_update_virtual_page");
            dVar.h("update_pause");
        } else if (i3 == 5) {
            dVar.o("2000925");
            dVar.q("page_auto_update_check");
            dVar.h("interrupt_pause");
        }
        dVar.j(5, wadlResult.wadlParams.sceneId);
    }

    private void onInstallSuccess(int i3, String str, com.tencent.gamecenter.wadl.biz.entity.d dVar) {
        if (i3 == 1) {
            dVar.o("2000903");
            dVar.h("install_success");
        } else if (i3 == 2) {
            dVar.o("2000909");
            dVar.q("page_auto_download_virtual_page");
            dVar.h("install_success");
        } else if (i3 == 3) {
            dVar.o("2000921");
            dVar.h("update_install_success");
        } else if (i3 == 4) {
            dVar.o("2000915");
            dVar.q("page_auto_update_virtual_page");
            dVar.h("update_install_success");
        } else if (i3 == 5) {
            dVar.o("2000927");
            dVar.q("page_auto_update_check");
            dVar.h("interrupt_install_success");
        }
        dVar.j(5, GameCenterUtil.getFileChannel(GameCenterUtil.getApkSourceDir(str)));
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onAutoDownloadStart(WadlParams wadlParams) {
        createAttaReport(wadlParams).q("page_auto_download_check").o("2000937").h("aotu_6").b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onAutoUpdateStart(WadlParams wadlParams) {
        createAttaReport(wadlParams).o("2000942").h("yuyuegengxin_5").q("page_auto_update_check").j(1, "4").b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onDeleteLowVersionTask(WadlParams wadlParams, WadlParams wadlParams2) {
        String str;
        if (wadlParams == null) {
            return;
        }
        com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlParams);
        int i3 = wadlParams2.downloadType;
        if (i3 == 2) {
            str = "page_auto_download_virtual_page";
        } else if (i3 == 4) {
            str = "page_auto_update_virtual_page";
        } else {
            str = "";
        }
        createAttaReport.q(str).o("2001210").h("delete_wrong_downloadtask").b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onDownloadStatusChange(int i3, WadlResult wadlResult) {
        if (wadlResult == null || wadlResult.wadlParams == null || !EVENT_FILTER.contains(Integer.valueOf(i3))) {
            return;
        }
        WadlParams wadlParams = wadlResult.wadlParams;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDownloadStatusChange event=" + i3 + ", downloadType=" + wadlParams.downloadType);
        }
        com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlParams);
        if (i3 != 2002) {
            switch (i3) {
                case 1005:
                    onDownloadFail(wadlParams.downloadType, wadlResult, createAttaReport);
                    break;
                case 1006:
                    onDownloadPause(wadlParams.downloadType, wadlResult, createAttaReport);
                    break;
                case 1007:
                    onDownloadDelete(wadlParams.downloadType, createAttaReport);
                    break;
                case 1008:
                    onDownloadComplete(wadlParams.downloadType, wadlResult, createAttaReport);
                    break;
            }
        } else {
            onInstallSuccess(wadlParams.downloadType, wadlParams.packageName, createAttaReport);
        }
        if (!TextUtils.isEmpty(createAttaReport.f106768b)) {
            createAttaReport.b();
            return;
        }
        QLog.w(TAG, 1, "onDownloadStatusChange report fail wadlParams=" + createAttaReport);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onFilterExpireTask(WadlParams wadlParams) {
        String str;
        if (wadlParams == null) {
            return;
        }
        com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlParams);
        int i3 = wadlParams.downloadType;
        if (i3 == 2) {
            str = "page_auto_download_virtual_page";
        } else if (i3 == 4) {
            str = "page_auto_update_virtual_page";
        } else {
            str = "";
        }
        createAttaReport.q(str).o("2001230").h("delete_outofdate_downloadtask").b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onGetAutoDownloadInfo(QQGameAutoDownloadTask$PreDownloadInfo qQGameAutoDownloadTask$PreDownloadInfo) {
        if (qQGameAutoDownloadTask$PreDownloadInfo == null) {
            return;
        }
        com.tencent.gamecenter.wadl.biz.entity.d dVar = new com.tencent.gamecenter.wadl.biz.entity.d();
        dVar.o("2000935").h("aotu_4");
        dVar.q("page_auto_download_check").k(qQGameAutoDownloadTask$PreDownloadInfo.appid.get()).l(qQGameAutoDownloadTask$PreDownloadInfo.app_name.get()).r(qQGameAutoDownloadTask$PreDownloadInfo.package_name.get()).j(1, "2").j(3, qQGameAutoDownloadTask$PreDownloadInfo.url.get()).j(4, qQGameAutoDownloadTask$PreDownloadInfo.apk_channel.get()).j(11, String.valueOf(qQGameAutoDownloadTask$PreDownloadInfo.version_code.get()));
        dVar.b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onGetAutoUpdateInfo(QQGameAutoUpdateTask$PreUpdateInfo qQGameAutoUpdateTask$PreUpdateInfo) {
        if (qQGameAutoUpdateTask$PreUpdateInfo == null) {
            return;
        }
        com.tencent.gamecenter.wadl.biz.entity.d dVar = new com.tencent.gamecenter.wadl.biz.entity.d();
        dVar.o("2000940").h("yuyuegengxin_3").q("page_auto_download_check");
        dVar.k(qQGameAutoUpdateTask$PreUpdateInfo.appid.get()).l(qQGameAutoUpdateTask$PreUpdateInfo.app_name.get()).r(qQGameAutoUpdateTask$PreUpdateInfo.pkg_name.get()).j(1, "4").j(3, qQGameAutoUpdateTask$PreUpdateInfo.apk_url.get()).j(4, qQGameAutoUpdateTask$PreUpdateInfo.apk_channel.get()).j(11, String.valueOf(qQGameAutoUpdateTask$PreUpdateInfo.version_code.get()));
        dVar.b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onNotificationClick(ArrayList<WadlResult> arrayList) {
        int i3;
        String str;
        String str2;
        String str3;
        boolean j3 = i.j(BaseApplication.getContext());
        String str4 = TAG;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onNotificationClick isScreenLock=");
        sb5.append(j3);
        sb5.append(", wadlResults size=");
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        QLog.d(str4, 1, sb5.toString());
        if (arrayList != null && arrayList.size() >= 1) {
            Iterator<WadlResult> it = arrayList.iterator();
            while (it.hasNext()) {
                WadlResult next = it.next();
                WadlParams wadlParams = next.wadlParams;
                if (wadlParams != null) {
                    com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlParams);
                    if (next.taskStatus == 6) {
                        str = "em_download_progress_finish";
                        str2 = "2001456";
                    } else if (j3) {
                        str = "em_download_progress_downloading_lockscreen";
                        str2 = "2001454";
                    } else {
                        str = "em_download_progress_downloading_unlockscreen";
                        str2 = "2001476";
                    }
                    createAttaReport.j(24, String.valueOf(next.floatProgress));
                    com.tencent.gamecenter.wadl.biz.entity.d h16 = createAttaReport.o(str2).h("click");
                    if (j3) {
                        str3 = "1";
                    } else {
                        str3 = "0";
                    }
                    h16.j(22, str3);
                    createAttaReport.q("page_lock_screen_download_progress").g(str).f(str);
                    createAttaReport.b();
                }
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onNotificationShow(WadlResult wadlResult, int i3) {
        String str;
        String str2;
        String str3;
        if (wadlResult == null) {
            return;
        }
        boolean j3 = i.j(BaseApplication.getContext());
        QLog.d(TAG, 1, "onNotificationShow isScreenLock=" + j3 + ", wadlResult=" + wadlResult.toSimpleString());
        com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlResult.wadlParams);
        if (i3 == 6) {
            str = "em_download_progress_finish";
            str2 = "2001455";
        } else {
            str = "em_download_progress_downloading";
            str2 = "2001453";
        }
        createAttaReport.j(24, String.valueOf(wadlResult.floatProgress));
        if (j3) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        createAttaReport.j(22, str3);
        createAttaReport.o(str2).h("expose");
        createAttaReport.q("page_lock_screen_download_progress").g(str).f(str);
        createAttaReport.b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onPreAutoDownloadCheck(String str, String str2, String str3, int i3, boolean z16, boolean z17, boolean z18, boolean z19, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        com.tencent.gamecenter.wadl.biz.entity.d dVar = new com.tencent.gamecenter.wadl.biz.entity.d();
        dVar.q("page_auto_download_check").o("2000936").h("aotu_5");
        com.tencent.gamecenter.wadl.biz.entity.d j3 = dVar.k(str).l(str3).r(str2).j(1, "2");
        String str9 = "1";
        if (z16) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j16 = j3.j(6, str5);
        if (z17) {
            str6 = "1";
        } else {
            str6 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j17 = j16.j(7, str6);
        if (z18) {
            str7 = "1";
        } else {
            str7 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j18 = j17.j(8, str7).j(11, String.valueOf(i3));
        if (z19) {
            str8 = "1";
        } else {
            str8 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j19 = j18.j(12, str8);
        if (!ql0.e.h()) {
            str9 = "0";
        }
        j19.j(13, str9);
        if (z18) {
            dVar.j(4, str4);
        }
        dVar.b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onPreAutoUpdateCheck(String str, String str2, String str3, int i3, boolean z16, boolean z17, boolean z18, boolean z19, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        com.tencent.gamecenter.wadl.biz.entity.d dVar = new com.tencent.gamecenter.wadl.biz.entity.d();
        dVar.o("2000941").h("yuyuegengxin_4").q("page_auto_update_check");
        com.tencent.gamecenter.wadl.biz.entity.d j3 = dVar.k(str).l(str3).r(str2).j(1, "4");
        String str9 = "1";
        if (z16) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j16 = j3.j(6, str5);
        if (z17) {
            str6 = "1";
        } else {
            str6 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j17 = j16.j(7, str6);
        if (z18) {
            str7 = "1";
        } else {
            str7 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j18 = j17.j(8, str7).j(11, String.valueOf(i3));
        if (z19) {
            str8 = "1";
        } else {
            str8 = "0";
        }
        com.tencent.gamecenter.wadl.biz.entity.d j19 = j18.j(12, str8);
        if (!ql0.e.h()) {
            str9 = "0";
        }
        j19.j(13, str9);
        if (z18) {
            dVar.j(4, str4);
        }
        dVar.b();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onReceivePush(int i3, String str) {
        com.tencent.gamecenter.wadl.biz.entity.d dVar = new com.tencent.gamecenter.wadl.biz.entity.d();
        dVar.k(str);
        if (i3 == 0) {
            dVar.o("2000934").q("page_auto_download_check").b();
        } else if (i3 == 1) {
            dVar.o("2000939").q("page_auto_update_check").b();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onRequestInstall(WadlParams wadlParams, boolean z16) {
        String str;
        com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlParams);
        QLog.d(TAG, 1, "onRequestInstall downloadType=" + wadlParams.downloadType + ",appId=" + wadlParams.appId + ",isForeground=" + z16);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        createAttaReport.j(5, str);
        int i3 = wadlParams.downloadType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            createAttaReport.o("2000926");
                            createAttaReport.q("page_auto_update_check");
                            createAttaReport.h("interrupt_install_request");
                        }
                    } else {
                        createAttaReport.o("2000914");
                        createAttaReport.q("page_auto_update_virtual_page");
                        createAttaReport.h("update_install_request");
                    }
                } else {
                    createAttaReport.o("2000920");
                    createAttaReport.h("update_install_request");
                }
            } else {
                createAttaReport.o("2000908");
                createAttaReport.q("page_auto_download_virtual_page");
                createAttaReport.h("install_request");
            }
        } else {
            createAttaReport.o("2000902");
            createAttaReport.h("install_request");
        }
        if (!TextUtils.isEmpty(createAttaReport.f106768b)) {
            createAttaReport.b();
            return;
        }
        QLog.w(TAG, 1, "onRequestInstall report fail wadlParams=" + createAttaReport);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onResumeAction(WadlParams wadlParams) {
        if (wadlParams == null) {
            return;
        }
        com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlParams);
        QLog.d(TAG, 1, "onResumeDownload downloadType=" + wadlParams.downloadType + ",isDirectUseDualWay:" + wadlParams.isDirectUseDualWay);
        int i3 = wadlParams.downloadType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        createAttaReport.o("2000930");
                        createAttaReport.q("page_auto_update_virtual_page");
                        createAttaReport.h("update_continue");
                    }
                } else {
                    createAttaReport.o("2000931");
                    createAttaReport.h("update_continue");
                }
            } else {
                createAttaReport.o("2000929");
                createAttaReport.q("page_auto_download_virtual_page");
                createAttaReport.h("download_continue");
            }
        } else {
            createAttaReport.o("2000928");
            createAttaReport.h("download_continue");
        }
        if (!TextUtils.isEmpty(createAttaReport.f106768b)) {
            createAttaReport.b();
            return;
        }
        QLog.w(TAG, 1, "onResumeAction report fail wadlParams=" + createAttaReport);
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameDLReportService
    public void onStartDownload(WadlParams wadlParams) {
        if (wadlParams == null) {
            return;
        }
        com.tencent.gamecenter.wadl.biz.entity.d createAttaReport = createAttaReport(wadlParams);
        QLog.d(TAG, 1, "onStartDownload downloadType=" + wadlParams.downloadType);
        int i3 = wadlParams.downloadType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            createAttaReport.o("2000922");
                            createAttaReport.q("page_auto_update_check");
                            createAttaReport.h("interrupt_start");
                        }
                    } else {
                        createAttaReport.o("2000910");
                        createAttaReport.q("page_auto_update_virtual_page");
                        createAttaReport.h("update_start");
                    }
                } else {
                    createAttaReport.o("2000916");
                    createAttaReport.h("update_start");
                }
            } else {
                createAttaReport.o("2000904");
                createAttaReport.q("page_auto_download_virtual_page");
                createAttaReport.h("download_start");
            }
        } else {
            createAttaReport.o("2000898");
            createAttaReport.h("download_start");
        }
        if (!TextUtils.isEmpty(createAttaReport.f106768b)) {
            createAttaReport.b();
            return;
        }
        QLog.w(TAG, 1, "onStartDownload report fail wadlParams=" + createAttaReport);
    }
}
