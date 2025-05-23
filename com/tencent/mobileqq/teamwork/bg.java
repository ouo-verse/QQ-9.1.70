package com.tencent.mobileqq.teamwork;

import android.os.Bundle;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileExportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bg extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static bg f292091d;

    bg() {
        super("TeamWorkModule");
    }

    public static bg b() {
        if (f292091d == null) {
            synchronized (bg.class) {
                if (f292091d == null) {
                    f292091d = new bg();
                }
            }
        }
        return f292091d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("TeamWorkModule", 2, "[onCall] action = " + str + ", params = " + bundle + ", callbackId=" + i3);
        }
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (!QQAppInterface.class.isInstance(runtime)) {
            if (QLog.isColorLevel()) {
                QLog.e("TeamWorkModule", 2, "[onCall] get app failed.");
            }
            return null;
        }
        if ("send_to_chat_msg".equals(str)) {
            AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(bundle);
            int i16 = bundle.getInt(IPublicAccountBrowser.KEY_UIN_TYPE);
            String string = bundle.getString("to_uin");
            String string2 = bundle.getString("docs_gray_tips_info_json");
            String string3 = bundle.getString("detail_url");
            if (runtime != null && e16 != null) {
                e16.mExtraData = "aioPlusPanelTencentDoc";
                ShareMsgHelper.c((QQAppInterface) runtime, string, i16, e16, null, string2, string3);
            }
        } else if ("action_download_export_file".equals(str)) {
            boolean z16 = bundle.getBoolean("isSuccess");
            String string4 = bundle.getString("docUrl");
            ITeamWorkFileExportHandler iTeamWorkFileExportHandler = (ITeamWorkFileExportHandler) ((QQAppInterface) runtime).getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_FILE_EXPORT_HANDLER);
            if (z16) {
                iTeamWorkFileExportHandler.notifyUI(2, true, new Object[]{bundle.getString("url"), bundle.getString(WadlProxyConsts.PARAM_FILENAME), string4, bundle.getString("cookie")});
            } else {
                iTeamWorkFileExportHandler.notifyUI(1, true, new Object[]{HardCodeUtil.qqStr(R.string.u0t), string4});
            }
        } else if ("action_start_export_file".equals(str)) {
            QLog.d("TeamWorkModule", 1, "downloadExportedFile QBaseActivity.sTopActivity =  " + QBaseActivity.sTopActivity);
            String string5 = bundle.getString(WadlProxyConsts.PARAM_FILENAME);
            FileManagerEntity fileManagerEntity = new FileManagerEntity();
            fileManagerEntity.fileName = string5;
            fileManagerEntity.nFileType = FileManagerUtil.getFileType(string5);
            fileManagerEntity.nFileType = ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getFileType(fileManagerEntity.fileName);
            fileManagerEntity.nSessionId = b.a().longValue();
            fileManagerEntity.cloudType = 9;
            Bundle bundle2 = new Bundle();
            bundle.putBoolean(ITeamWorkUtils.FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM, true);
            com.tencent.mobileqq.filemanager.openbrowser.d dVar = new com.tencent.mobileqq.filemanager.openbrowser.d((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), fileManagerEntity);
            dVar.S(bundle2);
            ((IFileBrowserService) QRoute.api(IFileBrowserService.class)).browserFile(BaseApplication.getContext(), dVar, new com.tencent.mobileqq.filemanager.openbrowser.c().d(0));
        }
        return null;
    }
}
