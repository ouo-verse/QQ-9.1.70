package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.SoLibraryChecker;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.webview.api.IDocxApi;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GetExternalInterfaceImpl implements IGetExternalInterface {
    private static final String TAG = "GetExternalInterfaceImpl";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f291664a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.c f291665b;

        a(String str, IGetExternalInterface.c cVar) {
            this.f291664a = str;
            this.f291665b = cVar;
        }

        @Override // sd2.a
        public void onFail(@NonNull String str) {
            QLog.i(GetExternalInterfaceImpl.TAG, 1, "--- pskey async failed ---  " + str + ", domain: " + this.f291664a);
            this.f291665b.a(null);
        }

        @Override // sd2.a
        public void onSuccess(@NonNull Map<String, String> map) {
            if (QLog.isColorLevel()) {
                QLog.i(GetExternalInterfaceImpl.TAG, 2, "--- pskey async done ---  ");
            }
            String str = map.get(this.f291664a);
            if (TextUtils.isEmpty(str)) {
                QLog.i(GetExternalInterfaceImpl.TAG, 1, "pskey async is empty, domain: " + this.f291664a);
            }
            this.f291665b.a(str);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public Dialog actionSheetHelperCreateDialog(Context context, View view) {
        return ActionSheetHelper.createDialog(context, view);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void addAioParamForSystem(Intent intent) {
        com.tencent.mobileqq.webview.swift.utils.c.a(intent, TbsDownloadConfig.TbsConfigKey.KEY_USE_X5, "2");
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void addAioParamForX5(Intent intent) {
        com.tencent.mobileqq.webview.swift.utils.c.a(intent, TbsDownloadConfig.TbsConfigKey.KEY_USE_X5, "1");
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void addMessage(AppInterface appInterface, MessageRecord messageRecord, String str) {
        if (appInterface instanceof QQAppInterface) {
            ((QQAppInterface) appInterface).getMessageFacade().c(messageRecord, str);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void checkFormCache(JSONObject jSONObject, String str, IGetExternalInterface.d dVar) {
        TeamWorkHandlerUtils.b(jSONObject, str, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public MessageRecord createMsgRecordByMsgType(int i3) {
        return com.tencent.mobileqq.service.message.q.d(i3);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void endUrlLoad(Intent intent, String str) {
        com.tencent.mobileqq.webview.swift.utils.c.h(intent, str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void fileManagerUtilOpenUrl(Context context, String str) {
        FileManagerUtil.openUrl(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void forwardTencentDocs(AppRuntime appRuntime, Activity activity, List<FileManagerEntity> list, IGetExternalInterface.a aVar) {
        boolean z16;
        byte[] bArr;
        if (appRuntime != null) {
            ReportController.o(appRuntime, "dc00898", "", "", "0X800A082", "0X800A082", 0, 0, "", "", "", "");
        }
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                FileManagerEntity fileManagerEntity = list.get(0);
                try {
                    bArr = fileManagerEntity.bombData;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (bArr != null) {
                    String str = new String(bArr);
                    ArkAppMessage arkAppMessage = new ArkAppMessage();
                    if (arkAppMessage.fromAppXml(str)) {
                        Intent intent = new Intent();
                        intent.putExtra("forward_type", 27);
                        intent.putExtra("is_ark_display_share", false);
                        intent.putExtra("forward_ark_app_name", arkAppMessage.appName);
                        intent.putExtra("forward_ark_app_view", arkAppMessage.appView);
                        intent.putExtra("forward_ark_app_ver", arkAppMessage.appMinVersion);
                        intent.putExtra("forward_ark_app_prompt", arkAppMessage.promptText);
                        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, arkAppMessage.config);
                        intent.putExtra("forward_ark_app_meta", arkAppMessage.metaList);
                        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, "");
                        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
                        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
                        z16 = true;
                        if (z16) {
                            try {
                                Bundle bundle = new Bundle();
                                bundle.putInt("forward_type", -1);
                                bundle.putString(AppConstants.Key.FORWARD_TEXT, String.format("\u3010\u817e\u8baf\u6587\u6863\u3011\u9080\u8bf7\u4f60\u4e00\u8d77\u67e5\u770b\u6587\u6863\u300a%s\u300b\n%s", fileManagerEntity.fileName, fileManagerEntity.Uuid));
                                bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                                Intent intent2 = new Intent();
                                intent2.putExtras(bundle);
                                RouteUtils.startActivityForResult(activity, intent2, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
                                return;
                            } catch (Exception e17) {
                                e17.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                }
                z16 = false;
                if (z16) {
                }
            } else {
                try {
                    StringBuilder sb5 = new StringBuilder();
                    for (FileManagerEntity fileManagerEntity2 : list) {
                        sb5.append("\u300a");
                        sb5.append(fileManagerEntity2.fileName);
                        sb5.append("\u300b");
                        sb5.append("\n");
                        sb5.append(fileManagerEntity2.Uuid);
                        sb5.append("\n");
                        sb5.append("\n");
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("forward_type", -1);
                    bundle2.putString(AppConstants.Key.FORWARD_TEXT, String.format("\u3010\u817e\u8baf\u6587\u6863\u3011\u9080\u8bf7\u4f60\u4e00\u8d77\u67e5\u770b%s\u4e2a\u6587\u6863\n%s", Integer.valueOf(list.size()), sb5));
                    bundle2.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                    bundle2.putBoolean("forward _key_nojump", true);
                    Intent intent3 = new Intent();
                    intent3.putExtra("isFromShare", true);
                    intent3.putExtras(bundle2);
                    RouteUtils.startActivityForResult(activity, intent3, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, -1);
                } catch (Exception e18) {
                    e18.printStackTrace();
                }
            }
        } else if (aVar != null) {
            aVar.a(new ArrayList());
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public String getBuddyName(AppInterface appInterface, String str, boolean z16) {
        if (appInterface instanceof QQAppInterface) {
            return com.tencent.mobileqq.utils.ac.g((QQAppInterface) appInterface, str, z16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean getCommonConfigBooleanValue(Context context, String str, String str2, boolean z16) {
        return ea.A(context, str, str2, z16);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public Intent getFileBrowserActivityClassIntent(Activity activity) {
        return new Intent(activity, (Class<?>) FileBrowserActivity.class);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public int getFileType(String str) {
        return FileManagerUtil.getFileType(str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public long getGroupUin(Context context) {
        if (isInstanceGroupTeamWorkListActivity(context)) {
            return ((GroupTeamWorkListActivity) context).G0;
        }
        return 0L;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean getPreloadWebProcess() {
        return SwiftBrowserStatistics.f314343h1;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void getPsKey(String str, IGetExternalInterface.c cVar) {
        ((IPskeyManager) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPskeyManager.class, "")).getPskey(new String[]{str}, new a(str, cVar));
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean getReportPerformance() {
        return SwiftBrowserStatistics.f314346k1;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public long getWebAcceleratorCostTime() {
        return 0L;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public WebResourceResponse getWebResponse(String str) {
        return (WebResourceResponse) ((IPublicAccountH5AbilityPlugin) QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebResponse(str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public String getWebViewUAForQQ(String str, String str2, boolean z16) {
        return com.tencent.mobileqq.webview.swift.utils.i.n(str, str2, z16);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void importFormWithLocalFile(JSONObject jSONObject, String str, String str2, IGetExternalInterface.d dVar) {
        TeamWorkHandlerUtils.n(jSONObject, str, str2, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void importFormWithUrl(JSONObject jSONObject, String str, IGetExternalInterface.d dVar) {
        TeamWorkHandlerUtils.o(jSONObject, str, dVar);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean isInstanceGroupTeamWorkListActivity(Context context) {
        return context instanceof GroupTeamWorkListActivity;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean isInstanceMessageForFile(MessageRecord messageRecord) {
        return messageRecord instanceof MessageForFile;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean isInstanceTeamWorkDocEditBrowserFragment(Object obj) {
        return obj instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean isQQAppInterface(AppInterface appInterface) {
        return appInterface instanceof QQAppInterface;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean isTroopAdmin(AppInterface appInterface, long j3, String str) {
        if (appInterface instanceof QQAppInterface) {
            return TroopUtils.a((QQAppInterface) appInterface, j3, str);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void jumpTimLogin(Bundle bundle, AppInterface appInterface) {
        if (appInterface != null) {
            ((com.tencent.mobileqq.managers.k) appInterface.getManager(QQManagerFactory.TIM_JUMP_LOGIN_MANAGER)).c(bundle);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void paramInitFinish(Intent intent) {
        com.tencent.mobileqq.webview.swift.utils.c.l(intent);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public MessageRecord queryMsgItemByUniseq(AppInterface appInterface, String str, int i3, long j3) {
        if (appInterface instanceof QQAppInterface) {
            return ((QQAppInterface) appInterface).getMessageFacade().w0(str, i3, j3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void sendDocsDataBack(String str, TouchWebView touchWebView) {
        ((IDocxApi) QRoute.api(IDocxApi.class)).sendDocsDataBack(str, touchWebView);
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void sendServiceIpcReq(Bundle bundle) {
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_convert_team_work_url_2_doc", "", -1, bundle));
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void setRedDotForTimGroupTMShow(AppInterface appInterface, Context context, String str, String str2, boolean z16) {
        if (appInterface != null) {
            ((com.tencent.mobileqq.model.d) appInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).f(context, str, str2, z16);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void soLibraryCheckerExecute(Context context) {
        new SoLibraryChecker(context, "3171", "libWXVoice.so", "WXVoice").k();
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public String soLibraryCheckerGetSoPath(Context context) {
        return SoLibraryChecker.m(context, "libWXVoice.so");
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public boolean soLibraryCheckerSoLibExists(Context context) {
        return SoLibraryChecker.n(context, "libWXVoice.so");
    }

    @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface
    public void webAcceleratorSmartSchedule() {
        Bundle bundle = new Bundle();
        bundle.putInt("_accelerator_mode_", 3);
        if (SwiftReuseTouchWebView.I == 0) {
            SwiftWebAccelerator.h().k(bundle);
        }
    }
}
