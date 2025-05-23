package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class eq extends com.tencent.mobileqq.utils.ax {
    static IPatchRedirector $redirector_;

    public eq(QQAppInterface qQAppInterface, Context context) {
        super(qQAppInterface, context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        Intent intent;
        Bundle extras;
        ArrayList<WadlResult> notificationTask;
        IQQGameNoticeService iQQGameNoticeService;
        IQQGameNoticeService iQQGameNoticeService2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Context context = this.f307437b;
        if (!(context instanceof Activity) || (intent = ((Activity) context).getIntent()) == null || (extras = intent.getExtras()) == null) {
            return true;
        }
        int i3 = extras.getInt("key_event_id", 0);
        QLog.d("WadlAction", 1, "doAction eventId=" + i3);
        if (i3 == 0) {
            String string = extras.getString(WadlProxyConsts.KEY_LOCAL_APK_PATH);
            String string2 = extras.getString("sourceId");
            QLog.d("WadlAction", 1, "gamecenter installApk, pkgName=" + this.f307444i + ",localAPKPath=" + string + ",sourceId=" + string2);
            if (!TextUtils.isEmpty(string)) {
                Intent openApkIntent = FileProvider7Helper.openApkIntent(this.f307437b, string);
                if (TextUtils.isEmpty(string2)) {
                    string2 = "biz_src_zf_games";
                }
                openApkIntent.putExtra("big_brother_source_key", string2);
                this.f307437b.startActivity(openApkIntent);
            }
            return true;
        }
        IQQGameNoticeService iQQGameNoticeService3 = null;
        ArrayList<WadlResult> arrayList = null;
        ArrayList<WadlResult> arrayList2 = null;
        if (i3 == 3) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iQQGameNoticeService2 = (IQQGameNoticeService) peekAppRuntime.getRuntimeService(IQQGameNoticeService.class, "all");
            } else {
                iQQGameNoticeService2 = null;
            }
            if (iQQGameNoticeService2 != null) {
                arrayList = iQQGameNoticeService2.getNotificationTask();
            }
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onNotificationClick(arrayList);
            GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, extras.getString(WadlProxyConsts.KEY_JUMP_URL));
            return true;
        }
        if (i3 == 1) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 != null) {
                iQQGameNoticeService = (IQQGameNoticeService) peekAppRuntime2.getRuntimeService(IQQGameNoticeService.class, "all");
            } else {
                iQQGameNoticeService = null;
            }
            if (iQQGameNoticeService != null) {
                arrayList2 = iQQGameNoticeService.getNotificationTask();
            }
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onNotificationClick(arrayList2);
            String string3 = extras.getString(WadlProxyConsts.KEY_JUMP_URL);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<WadlResult> it = arrayList2.iterator();
                while (it.hasNext()) {
                    WadlResult next = it.next();
                    if (!next.isDownloadComplete()) {
                        WadlProxyServiceUtil.getProxyService().doResumeAction(4, 0, next.wadlParams.appId);
                    }
                }
            }
            GameCenterUtil.jumpUrlOrSchema(MobileQQ.sMobileQQ, string3);
            QQToast.makeText(this.f307437b, 0, "\u6062\u590d\u4e0b\u8f7d\u6210\u529f\uff01", 1).show();
            return true;
        }
        if (i3 == 2) {
            GameCenterUtil.sendUseRemoveNotice();
            WadlResult wadlResult = (WadlResult) extras.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_RESULT);
            QLog.d("WadlAction", 1, "doAction EVENT_ID_SCHEME_INSTALL_APK wadlResult=" + wadlResult);
            if (wadlResult != null && !TextUtils.isEmpty(wadlResult.downloadFilePath) && !TextUtils.isEmpty(wadlResult.wadlParams.packageName)) {
                ArrayList<WadlResult> arrayList3 = new ArrayList<>();
                arrayList3.add(wadlResult);
                ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onNotificationClick(arrayList3);
                AppRuntime peekAppRuntime3 = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime3 != null) {
                    iQQGameNoticeService3 = (IQQGameNoticeService) peekAppRuntime3.getRuntimeService(IQQGameNoticeService.class, "all");
                }
                if (iQQGameNoticeService3 != null && (notificationTask = iQQGameNoticeService3.getNotificationTask()) != null && notificationTask.size() > 1) {
                    WadlParams wadlParams = wadlResult.wadlParams;
                    GameCenterUtil.goToInstallWithJump(wadlParams.appId, wadlParams.packageName, wadlResult.downloadFilePath, "biz_src_zf_games", "notification", false);
                    return true;
                }
                WadlParams wadlParams2 = wadlResult.wadlParams;
                GameCenterUtil.goToInstall(wadlParams2.appId, wadlParams2.packageName, wadlResult.downloadFilePath, "biz_src_zf_games", "notification", false);
            }
        }
        return true;
    }
}
