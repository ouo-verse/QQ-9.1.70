package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$ReqAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$ReqBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$ReqItemInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$RspAppInfo;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$RspBody;
import com.tencent.pb.clubcontent.ClubContentUpdateInfoPb$RspItemInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ClubContentUpdateHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f194479d;

    /* renamed from: e, reason: collision with root package name */
    private DownloaderFactory f194480e;

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.vip.f f194481f;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends com.tencent.mobileqq.vip.f {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ClubContentUpdateHandler.this);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar);
                return;
            }
            super.onDone(gVar);
            Bundle h16 = gVar.h();
            if (h16.containsKey("version") && h16.containsKey("json_name")) {
                int i3 = h16.getInt("version", -1);
                String string = h16.getString("json_name");
                if (ClubContentJsonTask.WebViewCrashJSONTask.versionKey.equals(string)) {
                    File file = new File(ClubContentUpdateHandler.this.f194479d.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.WebViewCrashJSONTask.jsonName);
                    if (file.exists() && file.isFile()) {
                        try {
                            JSONObject jSONObject = new JSONObject(FileUtils.readFileContent(file));
                            if (Math.abs(i3 - (jSONObject.getLong("timestamp") / 1000)) <= 5) {
                                ClubContentJsonTask.setJsonVersion(ClubContentUpdateHandler.this.f194479d.getApplication().getApplicationContext(), string, i3);
                                if (QLog.isColorLevel()) {
                                    QLog.i("ClubContentUpdateHandler", 2, "json file update success!");
                                }
                                if (jSONObject.has("enableX5Report")) {
                                    z16 = jSONObject.getBoolean("enableX5Report");
                                    if (QLog.isColorLevel()) {
                                        QLog.i("ClubContentUpdateHandler", 2, "json file got isEnableX5Report: " + z16);
                                    }
                                } else {
                                    z16 = true;
                                }
                                com.tencent.mobileqq.webview.util.t j3 = com.tencent.mobileqq.webview.util.t.j();
                                j3.d("WebView_enable_X5_Report", Boolean.valueOf(z16));
                                j3.d(VasWebviewUtil.SP_PARSE_ASYNC_COOKIE, 0L);
                                j3.g();
                            } else if (QLog.isColorLevel()) {
                                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
                            }
                            ClubContentUpdateHandler.this.W2(jSONObject);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + e16.toString());
                            }
                        }
                    }
                }
            }
        }
    }

    ClubContentUpdateHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f194480e = null;
        this.f194481f = new a();
        this.f194479d = qQAppInterface;
    }

    public static void E2(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return;
        }
        ClubContentUpdateInfoPb$ReqBody clubContentUpdateInfoPb$ReqBody = new ClubContentUpdateInfoPb$ReqBody();
        String currentAccountUin = qQAppInterface.getCurrentAccountUin();
        clubContentUpdateInfoPb$ReqBody.int_protocolver.set(1);
        clubContentUpdateInfoPb$ReqBody.uint_clientplatid.set(109);
        clubContentUpdateInfoPb$ReqBody.str_clientver.set(AppSetting.f99554n);
        clubContentUpdateInfoPb$ReqBody.uint_uin.set(Long.parseLong(currentAccountUin));
        ArrayList arrayList = new ArrayList();
        int i3 = qQAppInterface.getApp().getSharedPreferences("sigResUpt", 0).getInt("sigTplCfgVer", 0);
        ArrayList arrayList2 = new ArrayList();
        ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo = new ClubContentUpdateInfoPb$ReqItemInfo();
        clubContentUpdateInfoPb$ReqItemInfo.str_name.set("signature_json");
        clubContentUpdateInfoPb$ReqItemInfo.uint_version.set(i3);
        arrayList2.add(clubContentUpdateInfoPb$ReqItemInfo);
        ClubContentUpdateInfoPb$ReqAppInfo clubContentUpdateInfoPb$ReqAppInfo = new ClubContentUpdateInfoPb$ReqAppInfo();
        clubContentUpdateInfoPb$ReqAppInfo.uint_appid.set(8);
        clubContentUpdateInfoPb$ReqAppInfo.rpt_msg_reqiteminfo.set(arrayList2);
        arrayList.add(clubContentUpdateInfoPb$ReqAppInfo);
        clubContentUpdateInfoPb$ReqBody.rpt_msg_reqappinfo.set(arrayList);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "ClubContentUpdate.Req");
        toServiceMsg.putWupBuffer(clubContentUpdateInfoPb$ReqBody.toByteArray());
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        qQAppInterface.sendToService(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i("ClubContentUpdateHandler", 2, "checkUpdateSigTpl called.");
        }
    }

    private void M2(ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo) {
        Iterator it = ((ArrayList) clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
        while (it.hasNext()) {
            ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = (ClubContentUpdateInfoPb$RspItemInfo) it.next();
            String str = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
            int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
            String str2 = clubContentUpdateInfoPb$RspItemInfo.str_extend.get();
            int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "handleGetIndividuationUrlsResponse, name=" + str + ", version=" + i3 + ", updateFlag=" + i16 + ",extStr=" + str2);
            }
            str.equals(ClubContentJsonTask.sIndividuationUrlTask.businessName);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W2(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("group_domain") && jSONObject.has("group_strategy")) {
            try {
                String string = jSONObject.getString("group_domain");
                String string2 = jSONObject.getString("group_strategy");
                if (QLog.isColorLevel()) {
                    QLog.i("ClubContentUpdateHandler", 2, "cdnCacheConfig, domain: " + string + ", strategys: " + string2);
                    return;
                }
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.w("ClubContentUpdateHandler", 2, "", e16);
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("ClubContentUpdateHandler", 2, "no cdnCacheConfig!");
        }
    }

    private void X2(String str, int i3, String str2, int i16, Map<String, Integer> map, boolean z16) {
        if (str.equals(ClubContentJsonTask.sEmoticonWordingTask.businessName)) {
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEmoticonWordingTask!");
            }
            Z2(i3, ClubContentJsonTask.sEmoticonWordingTask, z16);
            return;
        }
        if (str.equals(ClubContentJsonTask.sEPPromotionTask.businessName)) {
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "func updateEmojiJson, sEPPromotionTask!");
            }
            int jsonVersion = ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), ClubContentJsonTask.sEPPromotionTask.versionKey);
            if (i3 > jsonVersion) {
                this.f194479d.getApplication();
                ClubContentJsonTask.setJsonVersion(BaseApplication.getContext(), ClubContentJsonTask.sEPPromotionTask.versionKey, jsonVersion);
                SharedPreferences sharedPreferences = this.f194479d.getApp().getSharedPreferences("recommendEmotion_sp_name", 0);
                ((com.tencent.mobileqq.emosm.o) this.f194479d.getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).h();
                sharedPreferences.edit().putLong("last_get_recommendemotion_time_" + this.f194479d.getCurrentUin(), System.currentTimeMillis()).commit();
                return;
            }
            return;
        }
        if (str.contains("_json")) {
            if (QLog.isDevelopLevel()) {
                QLog.d("ClubContentUpdateHandler", 4, "func updateEmojiJson, name.contains(EmosmEmoticonConstant.EMOTICON_JSON_UPDATE_REQUEST_SUFFIX!");
            }
            if (com.tencent.mobileqq.core.util.a.h(i16)) {
                ((IEmoticonManagerService) this.f194479d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPackageKeywordJson(str.replace("_json", "").trim(), i3, str2, i16, 0);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ClubContentUpdateHandler", 4, "func updateEmojiJson, update emoji package!");
        }
        ((IEmoticonManagerService) this.f194479d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPkgUpdateStatus(str, i3, str2, i16, 0);
        map.put(str, Integer.valueOf(i16));
    }

    private void Y2(int i3, ClubContentJsonTask.TaskInfo taskInfo) {
        if (Math.abs(i3 - ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), taskInfo.versionKey)) > 5) {
            if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "New version json found!");
            }
            if (this.f194480e == null) {
                this.f194480e = (DownloaderFactory) this.f194479d.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
            }
            File file = new File(this.f194479d.getApplication().getApplicationContext().getFilesDir(), taskInfo.jsonName);
            Bundle bundle = new Bundle();
            bundle.putInt("version", i3);
            bundle.putString("json_name", taskInfo.versionKey);
            this.f194480e.u(1).startDownload(new com.tencent.mobileqq.vip.g(taskInfo.jsonUrl, file), this.f194481f, bundle);
        }
    }

    private boolean Z2(int i3, ClubContentJsonTask.TaskInfo taskInfo, boolean z16) {
        int jsonVersion = ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), taskInfo.versionKey);
        if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "updateResJson name = " + taskInfo.businessName + " localVersion = " + jsonVersion + " version = " + i3);
        }
        if (i3 > jsonVersion) {
            ClubContentJsonTask.updateJson(this.f194479d, taskInfo, i3, z16);
            return true;
        }
        return false;
    }

    private void a3(int i3, int i16, String str) {
        ((IEmoticonManagerService) this.f194479d.getRuntimeService(IEmoticonManagerService.class)).saveEmoticonPkgUpdateStatus(str, i3, "", i16, 0);
        if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "small emotion has update info.");
        }
        ClubContentJsonTask.setJsonVersion(this.f194479d.getApplication().getApplicationContext(), "small_emosm_update_flag" + str, i3);
    }

    protected ClubContentUpdateInfoPb$ReqAppInfo F2(ClubContentJsonTask.TaskInfo taskInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ClubContentUpdateInfoPb$ReqAppInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) taskInfo, i3);
        }
        ArrayList arrayList = new ArrayList();
        ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo = new ClubContentUpdateInfoPb$ReqItemInfo();
        clubContentUpdateInfoPb$ReqItemInfo.str_name.set(taskInfo.businessName);
        clubContentUpdateInfoPb$ReqItemInfo.uint_version.set(ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), taskInfo.versionKey));
        arrayList.add(clubContentUpdateInfoPb$ReqItemInfo);
        ClubContentUpdateInfoPb$ReqAppInfo clubContentUpdateInfoPb$ReqAppInfo = new ClubContentUpdateInfoPb$ReqAppInfo();
        clubContentUpdateInfoPb$ReqAppInfo.uint_appid.set(i3);
        clubContentUpdateInfoPb$ReqAppInfo.rpt_msg_reqiteminfo.set(arrayList);
        clubContentUpdateInfoPb$ReqAppInfo.setHasFlag(true);
        return clubContentUpdateInfoPb$ReqAppInfo;
    }

    protected ClubContentUpdateInfoPb$ReqAppInfo G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ClubContentUpdateInfoPb$ReqAppInfo) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        List<EmoticonPackage> syncGetTabEmoticonPackages = ((IEmoticonManagerService) this.f194479d.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(0);
        ArrayList arrayList = new ArrayList();
        if (syncGetTabEmoticonPackages != null) {
            for (EmoticonPackage emoticonPackage : syncGetTabEmoticonPackages) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("ClubContentUpdateHandler", 4, "BigEmojiId= " + emoticonPackage.epId + "status=" + emoticonPackage.status + "jobType=" + emoticonPackage.jobType + "updateFlag=" + emoticonPackage.updateFlag + "localVersion=" + emoticonPackage.localVersion);
                }
                if (emoticonPackage.jobType == 0 && emoticonPackage.status == 2 && !com.tencent.mobileqq.core.util.a.g(emoticonPackage.updateFlag)) {
                    ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo = new ClubContentUpdateInfoPb$ReqItemInfo();
                    clubContentUpdateInfoPb$ReqItemInfo.str_name.set(emoticonPackage.epId);
                    clubContentUpdateInfoPb$ReqItemInfo.uint_version.set(emoticonPackage.localVersion);
                    arrayList.add(clubContentUpdateInfoPb$ReqItemInfo);
                    ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo2 = new ClubContentUpdateInfoPb$ReqItemInfo();
                    clubContentUpdateInfoPb$ReqItemInfo2.str_name.set(emoticonPackage.epId + "_json");
                    int i3 = emoticonPackage.jsonVersion;
                    if (i3 == 0) {
                        i3 = emoticonPackage.localVersion;
                    }
                    clubContentUpdateInfoPb$ReqItemInfo2.uint_version.set(i3);
                    arrayList.add(clubContentUpdateInfoPb$ReqItemInfo2);
                }
            }
        }
        ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo3 = new ClubContentUpdateInfoPb$ReqItemInfo();
        clubContentUpdateInfoPb$ReqItemInfo3.str_name.set(ClubContentJsonTask.sEmoticonWordingTask.businessName);
        clubContentUpdateInfoPb$ReqItemInfo3.uint_version.set(ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), ClubContentJsonTask.sEmoticonWordingTask.versionKey));
        arrayList.add(clubContentUpdateInfoPb$ReqItemInfo3);
        ClubContentUpdateInfoPb$ReqAppInfo clubContentUpdateInfoPb$ReqAppInfo = new ClubContentUpdateInfoPb$ReqAppInfo();
        clubContentUpdateInfoPb$ReqAppInfo.uint_appid.set(1);
        clubContentUpdateInfoPb$ReqAppInfo.rpt_msg_reqiteminfo.set(arrayList);
        clubContentUpdateInfoPb$ReqAppInfo.setHasFlag(true);
        return clubContentUpdateInfoPb$ReqAppInfo;
    }

    protected ClubContentUpdateInfoPb$ReqAppInfo H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ClubContentUpdateInfoPb$ReqAppInfo) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        List<EmoticonPackage> syncGetTabEmoticonPackages = ((IEmoticonManagerService) this.f194479d.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(0);
        ArrayList arrayList = new ArrayList();
        if (syncGetTabEmoticonPackages != null) {
            for (EmoticonPackage emoticonPackage : syncGetTabEmoticonPackages) {
                QLog.d("ClubContentUpdateHandler", 2, "MagicEmojiId= " + emoticonPackage.epId + "status=" + emoticonPackage.status + "jobType=" + emoticonPackage.jobType + "updateFlag=" + emoticonPackage.updateFlag + "localVersion=" + emoticonPackage.localVersion);
                if (emoticonPackage.jobType == 3 && emoticonPackage.status == 2 && !com.tencent.mobileqq.core.util.a.g(emoticonPackage.updateFlag)) {
                    ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo = new ClubContentUpdateInfoPb$ReqItemInfo();
                    clubContentUpdateInfoPb$ReqItemInfo.str_name.set(emoticonPackage.epId);
                    clubContentUpdateInfoPb$ReqItemInfo.uint_version.set(emoticonPackage.localVersion);
                    arrayList.add(clubContentUpdateInfoPb$ReqItemInfo);
                    ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo2 = new ClubContentUpdateInfoPb$ReqItemInfo();
                    clubContentUpdateInfoPb$ReqItemInfo2.str_name.set(emoticonPackage.epId + "_json");
                    int i3 = emoticonPackage.jsonVersion;
                    if (i3 == 0) {
                        i3 = emoticonPackage.localVersion;
                    }
                    clubContentUpdateInfoPb$ReqItemInfo2.uint_version.set(i3);
                    arrayList.add(clubContentUpdateInfoPb$ReqItemInfo2);
                }
            }
        }
        ClubContentUpdateInfoPb$ReqAppInfo clubContentUpdateInfoPb$ReqAppInfo = new ClubContentUpdateInfoPb$ReqAppInfo();
        clubContentUpdateInfoPb$ReqAppInfo.uint_appid.set(1);
        clubContentUpdateInfoPb$ReqAppInfo.rpt_msg_reqiteminfo.set(arrayList);
        clubContentUpdateInfoPb$ReqAppInfo.setHasFlag(true);
        return clubContentUpdateInfoPb$ReqAppInfo;
    }

    protected ClubContentUpdateInfoPb$ReqAppInfo I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ClubContentUpdateInfoPb$ReqAppInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        List<EmoticonPackage> syncGetTabEmoticonPackages = ((IEmoticonManagerService) this.f194479d.getRuntimeService(IEmoticonManagerService.class)).syncGetTabEmoticonPackages(0);
        ArrayList arrayList = new ArrayList();
        if (syncGetTabEmoticonPackages != null) {
            for (EmoticonPackage emoticonPackage : syncGetTabEmoticonPackages) {
                if (QLog.isColorLevel()) {
                    QLog.d("ClubContentUpdateHandler", 2, "SmallEmojiId= " + emoticonPackage.epId + "status=" + emoticonPackage.status + "jobType=" + emoticonPackage.jobType + "updateFlag=" + emoticonPackage.updateFlag);
                }
                if (emoticonPackage.jobType == 4 && emoticonPackage.status == 2 && !com.tencent.mobileqq.core.util.a.g(emoticonPackage.updateFlag)) {
                    ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo = new ClubContentUpdateInfoPb$ReqItemInfo();
                    clubContentUpdateInfoPb$ReqItemInfo.str_name.set(emoticonPackage.epId);
                    clubContentUpdateInfoPb$ReqItemInfo.uint_version.set(emoticonPackage.localVersion);
                    arrayList.add(clubContentUpdateInfoPb$ReqItemInfo);
                }
            }
        }
        ClubContentUpdateInfoPb$ReqAppInfo clubContentUpdateInfoPb$ReqAppInfo = new ClubContentUpdateInfoPb$ReqAppInfo();
        clubContentUpdateInfoPb$ReqAppInfo.uint_appid.set(10);
        clubContentUpdateInfoPb$ReqAppInfo.rpt_msg_reqiteminfo.set(arrayList);
        clubContentUpdateInfoPb$ReqAppInfo.setHasFlag(true);
        return clubContentUpdateInfoPb$ReqAppInfo;
    }

    protected ClubContentUpdateInfoPb$ReqAppInfo J2(ClubContentJsonTask.TaskInfo taskInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ClubContentUpdateInfoPb$ReqAppInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) taskInfo, i3);
        }
        ArrayList arrayList = new ArrayList();
        ClubContentUpdateInfoPb$ReqItemInfo clubContentUpdateInfoPb$ReqItemInfo = new ClubContentUpdateInfoPb$ReqItemInfo();
        clubContentUpdateInfoPb$ReqItemInfo.str_name.set(taskInfo.businessName);
        clubContentUpdateInfoPb$ReqItemInfo.uint_version.set(ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), taskInfo.versionKey));
        arrayList.add(clubContentUpdateInfoPb$ReqItemInfo);
        ClubContentUpdateInfoPb$ReqAppInfo clubContentUpdateInfoPb$ReqAppInfo = new ClubContentUpdateInfoPb$ReqAppInfo();
        clubContentUpdateInfoPb$ReqAppInfo.uint_appid.set(i3);
        clubContentUpdateInfoPb$ReqAppInfo.rpt_msg_reqiteminfo.set(arrayList);
        clubContentUpdateInfoPb$ReqAppInfo.setHasFlag(true);
        return clubContentUpdateInfoPb$ReqAppInfo;
    }

    protected void K2(ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) clubContentUpdateInfoPb$RspAppInfo);
            return;
        }
        Iterator it = ((ArrayList) clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
        while (it.hasNext()) {
            ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = (ClubContentUpdateInfoPb$RspItemInfo) it.next();
            String str = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
            int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
            String str2 = clubContentUpdateInfoPb$RspItemInfo.str_extend.get();
            int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ClubContentUpdateHandler", 2, "name=" + str + ", version=" + i3 + ", updateFlag=" + i16 + ",extStr=" + str2);
                }
                if (str.equals(ClubContentJsonTask.sIndividuationTask.businessName)) {
                    if (i3 > ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), ClubContentJsonTask.sIndividuationTask.versionKey)) {
                        ClubContentJsonTask.updateJson(this.f194479d, ClubContentJsonTask.sIndividuationTask, i3, false);
                    }
                } else if (str.equals(ClubContentJsonTask.sFunnyPicTask.businessName)) {
                    if (i3 > ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), ClubContentJsonTask.sFunnyPicTask.versionKey)) {
                        ClubContentJsonTask.updateJson(this.f194479d, ClubContentJsonTask.sFunnyPicTask, i3, false);
                    }
                } else if (str.equals(ClubContentJsonTask.sFontInfoListJSONTask.businessName)) {
                    int jsonVersion = ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), ClubContentJsonTask.sFontInfoListJSONTask.versionKey);
                    if (QLog.isColorLevel()) {
                        QLog.d("ClubContentUpdateHandler", 2, "FontInfoList_json remoteVersion = " + i3 + " localVersion = " + jsonVersion);
                    }
                    if (i3 > jsonVersion) {
                        ClubContentJsonTask.updateJson(this.f194479d, ClubContentJsonTask.sFontInfoListJSONTask, i3, false);
                    }
                }
            }
        }
    }

    protected void L2(ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) clubContentUpdateInfoPb$RspAppInfo);
            return;
        }
        QLog.d("ClubContentUpdateHandler", 2, "handleEmosmResponse begins");
        ArrayList arrayList = (ArrayList) clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get();
        HashMap hashMap = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = (ClubContentUpdateInfoPb$RspItemInfo) it.next();
            String str2 = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
            int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
            String str3 = clubContentUpdateInfoPb$RspItemInfo.str_extend.get();
            int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
            String[] split = str3.split("\\|\\|");
            if (split.length > 0) {
                str = split[0];
            } else {
                str = "";
            }
            String str4 = str;
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "name=" + str2 + ", version=" + i3 + ", tip=" + str4 + ", updateFlag=" + i16 + ",extStr=" + str3);
            }
            X2(str2, i3, str4, i16, hashMap, false);
        }
    }

    public void N2(int i3, String str, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), str, Integer.valueOf(i16));
            return;
        }
        if (i3 != 1) {
            if (i3 != 5) {
                if (i3 != 7) {
                    if (i3 != 10) {
                        if (i3 != 113) {
                            if (i3 != 302) {
                                if (i3 == 401 && ClubContentJsonTask.sIndividuationUrlTask.businessName.equals(str) && QLog.isColorLevel()) {
                                    QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, update json for individuation url config");
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent, individuation mainpage, name=" + str);
                            }
                            str.equals(VasWebviewUtil.BUSINESS_NAME);
                            return;
                        }
                        if (ClubContentJsonTask.UrlInterceptJSONTask.businessName.equals(str)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent UrlInterceptJson");
                            }
                            Z2(i16, ClubContentJsonTask.UrlInterceptJSONTask, true);
                            return;
                        }
                        return;
                    }
                    int jsonVersion = ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), "small_emosm_update_flag" + str);
                    if (QLog.isColorLevel()) {
                        QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + str + ",version" + i16 + ",localVersion:" + jsonVersion);
                    }
                    if (jsonVersion < i16) {
                        a3(i16, 1, str);
                        return;
                    }
                    return;
                }
                if (ClubContentJsonTask.sIndividuationTask.businessName.equals(str)) {
                    Z2(i16, ClubContentJsonTask.sIndividuationTask, true);
                    return;
                }
                return;
            }
            if (ClubContentJsonTask.sFontInfoListJSONTask.businessName.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ClubContentUpdateHandler", 2, "saveQVIPResConfigContent FontInfoList");
                }
                Z2(i16, ClubContentJsonTask.sFontInfoListJSONTask, true);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "func handleSmallEmosmResponse, bigEmoji and magicEmoji");
        }
        X2(str, i16, "", 1, new HashMap(), true);
    }

    protected void O2(ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) clubContentUpdateInfoPb$RspAppInfo);
            return;
        }
        Iterator it = ((ArrayList) clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
        while (it.hasNext()) {
            ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = (ClubContentUpdateInfoPb$RspItemInfo) it.next();
            String str = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
            int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
            String str2 = clubContentUpdateInfoPb$RspItemInfo.str_extend.get();
            int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "handleIndividuationMainpageConfigResponse, name=" + str + ", version=" + i3 + ", updateFlag=" + i16 + ",extStr=" + str2);
            }
            str.equals(VasWebviewUtil.BUSINESS_NAME);
        }
    }

    protected void P2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ClubContentUpdateInfoPb$RspBody clubContentUpdateInfoPb$RspBody = new ClubContentUpdateInfoPb$RspBody();
            try {
                clubContentUpdateInfoPb$RspBody.mergeFrom((byte[]) obj);
                if (clubContentUpdateInfoPb$RspBody.int_result.get() != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ClubContentUpdateHandler", 2, "handleResponse, result=" + clubContentUpdateInfoPb$RspBody.int_result.get());
                    }
                    Q2();
                    return;
                }
                Iterator it = ((ArrayList) clubContentUpdateInfoPb$RspBody.rpt_msg_rspappinfo.get()).iterator();
                while (it.hasNext()) {
                    ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo = (ClubContentUpdateInfoPb$RspAppInfo) it.next();
                    int i3 = clubContentUpdateInfoPb$RspAppInfo.uint_appid.get();
                    if (i3 != 1) {
                        if (i3 != 5) {
                            if (i3 != 7) {
                                if (i3 != 105) {
                                    if (i3 != 113) {
                                        if (i3 != 302) {
                                            if (i3 != 401) {
                                                if (i3 != 10) {
                                                    if (i3 == 11) {
                                                        K2(clubContentUpdateInfoPb$RspAppInfo);
                                                    }
                                                } else {
                                                    R2(clubContentUpdateInfoPb$RspAppInfo);
                                                }
                                            } else {
                                                M2(clubContentUpdateInfoPb$RspAppInfo);
                                            }
                                        } else {
                                            O2(clubContentUpdateInfoPb$RspAppInfo);
                                        }
                                    } else {
                                        S2(clubContentUpdateInfoPb$RspAppInfo);
                                    }
                                } else {
                                    T2(clubContentUpdateInfoPb$RspAppInfo);
                                }
                            } else {
                                K2(clubContentUpdateInfoPb$RspAppInfo);
                            }
                        } else {
                            K2(clubContentUpdateInfoPb$RspAppInfo);
                        }
                    } else {
                        L2(clubContentUpdateInfoPb$RspAppInfo);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    protected void R2(ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) clubContentUpdateInfoPb$RspAppInfo);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse begins");
        }
        Iterator it = ((ArrayList) clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
        while (it.hasNext()) {
            ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = (ClubContentUpdateInfoPb$RspItemInfo) it.next();
            String str = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
            int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
            int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
            int jsonVersion = ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), "small_emosm_update_flag" + str);
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse, name:" + str + ",updateFlag:" + i16 + ",version" + i3 + ",localVersion:" + jsonVersion);
            }
            if (jsonVersion < i3) {
                a3(i3, i16, str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 4, "func handleSmallEmosmResponse ends");
        }
    }

    protected void S2(ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) clubContentUpdateInfoPb$RspAppInfo);
            return;
        }
        Iterator it = ((ArrayList) clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get()).iterator();
        while (it.hasNext()) {
            ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = (ClubContentUpdateInfoPb$RspItemInfo) it.next();
            String str = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
            int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
            String str2 = clubContentUpdateInfoPb$RspItemInfo.str_extend.get();
            int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "handleUrlInterceptJSONResponse name=" + str + ", version=" + i3 + ", updateFlag=" + i16 + ",extStr=" + str2);
            }
            if (str.equals(ClubContentJsonTask.UrlInterceptJSONTask.businessName)) {
                Z2(i3, ClubContentJsonTask.UrlInterceptJSONTask, false);
            }
        }
    }

    protected void T2(ClubContentUpdateInfoPb$RspAppInfo clubContentUpdateInfoPb$RspAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) clubContentUpdateInfoPb$RspAppInfo);
            return;
        }
        ArrayList arrayList = (ArrayList) clubContentUpdateInfoPb$RspAppInfo.rpt_msg_rspiteminfo.get();
        StringBuilder sb5 = new StringBuilder(arrayList.size() * 64);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ClubContentUpdateInfoPb$RspItemInfo clubContentUpdateInfoPb$RspItemInfo = (ClubContentUpdateInfoPb$RspItemInfo) it.next();
            String str = clubContentUpdateInfoPb$RspItemInfo.str_name.get();
            int i3 = clubContentUpdateInfoPb$RspItemInfo.uint_version.get();
            String str2 = clubContentUpdateInfoPb$RspItemInfo.str_extend.get();
            int i16 = clubContentUpdateInfoPb$RspItemInfo.uint_update_flag.get();
            if (QLog.isColorLevel()) {
                sb5.append("name=");
                sb5.append(str);
                sb5.append(", version=");
                sb5.append(i3);
                sb5.append(", updateFlag=");
                sb5.append(i16);
                sb5.append(", extStr=");
                sb5.append(str2);
            }
            if (str.equals(ClubContentJsonTask.WebViewCrashJSONTask.businessName) && i3 > ClubContentJsonTask.getJsonVersion(this.f194479d.getApplication().getApplicationContext(), ClubContentJsonTask.WebViewCrashJSONTask.versionKey)) {
                Y2(i3, ClubContentJsonTask.WebViewCrashJSONTask);
            }
        }
        if (QLog.isColorLevel() && !TextUtils.isEmpty(sb5.toString())) {
            QLog.d("ClubContentUpdateHandler", 2, sb5.toString());
        }
    }

    public void U2(QQAppInterface qQAppInterface, String str) {
        int i3;
        int i16;
        String string;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) qQAppInterface, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ClubContentUpdateHandler", 2, "func saveQVIPResConfigContent invoked!");
        }
        BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putString("qvip_res_push_cfg_txt.", str).commit();
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
            for (int i17 = 0; i17 < jSONArray.length(); i17++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i17);
                    i3 = jSONObject.getInt("version");
                    i16 = jSONObject.getInt("id");
                    string = jSONObject.getString("filename");
                } catch (Exception unused) {
                }
                if (string == null) {
                    return;
                }
                N2(i16, string, i3);
                if (ClubContentJsonTask.WebViewCrashJSONTask.businessName.equals(string)) {
                    Y2(i3, ClubContentJsonTask.WebViewCrashJSONTask);
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ClubContentUpdateHandler", 2, "name= saveQVIPResConfigContent ", e16);
            }
        }
    }

    public void V2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ClubContentUpdateInfoPb$ReqBody clubContentUpdateInfoPb$ReqBody = new ClubContentUpdateInfoPb$ReqBody();
        String currentAccountUin = this.f194479d.getCurrentAccountUin();
        clubContentUpdateInfoPb$ReqBody.int_protocolver.set(1);
        clubContentUpdateInfoPb$ReqBody.uint_clientplatid.set(109);
        clubContentUpdateInfoPb$ReqBody.str_clientver.set(AppSetting.f99554n);
        clubContentUpdateInfoPb$ReqBody.uint_uin.set(Long.parseLong(currentAccountUin));
        ArrayList arrayList = new ArrayList();
        arrayList.add(G2());
        arrayList.add(I2());
        arrayList.add(H2());
        arrayList.add(F2(ClubContentJsonTask.sIndividuationTask, 7));
        arrayList.add(J2(ClubContentJsonTask.WebViewCrashJSONTask, 105));
        arrayList.add(F2(ClubContentJsonTask.sFunnyPicTask, 11));
        arrayList.add(F2(ClubContentJsonTask.UrlInterceptJSONTask, 113));
        arrayList.add(F2(ClubContentJsonTask.sFontInfoListJSONTask, 5));
        clubContentUpdateInfoPb$ReqBody.rpt_msg_reqappinfo.set(arrayList);
        clubContentUpdateInfoPb$ReqBody.setHasFlag(true);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", currentAccountUin, "ClubContentUpdate.Req");
        toServiceMsg.putWupBuffer(clubContentUpdateInfoPb$ReqBody.toByteArray());
        sendPbReq(toServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.i("ClubContentUpdateHandler", 2, "sendPbReq called cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
    }

    public void checkJsonVersion(Context context) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
            return;
        }
        int i16 = 0;
        try {
            JSONArray jSONArray = new JSONObject(BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getString("qvip_res_push_cfg_txt.", "")).getJSONArray("data");
            while (true) {
                if (i16 >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject = jSONArray.getJSONObject(i16);
                if (ClubContentJsonTask.WebViewCrashJSONTask.jsonName.equals(jSONObject.getString("filename"))) {
                    String string = jSONObject.getString("version");
                    if (!TextUtils.isEmpty(string)) {
                        i3 = Integer.parseInt(string);
                    }
                } else {
                    i16++;
                }
            }
            i3 = -1;
            if (i3 != -1 && ClubContentJsonTask.getJsonVersion(context, ClubContentJsonTask.WebViewCrashJSONTask.versionKey) != i3) {
                Y2(i3, ClubContentJsonTask.WebViewCrashJSONTask);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("ClubContentUpdateHandler", 2, "Parse QVIP_RES_PUSH_CFG_TXT failed:" + e16.toString());
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("ClubContentUpdate.Req".equals(fromServiceMsg.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "onReceive called.");
            }
            P2(toServiceMsg, fromServiceMsg, obj);
        }
    }

    private void Q2() {
    }
}
