package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IGetExternalInterface extends QRouteApi {
    public static final String TIM_GROUP_TM_REDDOT = "TIM_GROUP_TM_REDDOT";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(List list);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(StringBuilder sb5);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void a(String str);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface d {
        void a(Object obj);
    }

    Dialog actionSheetHelperCreateDialog(Context context, View view);

    void addAioParamForSystem(Intent intent);

    void addAioParamForX5(Intent intent);

    void addMessage(AppInterface appInterface, MessageRecord messageRecord, String str);

    void checkFormCache(JSONObject jSONObject, String str, d dVar);

    MessageRecord createMsgRecordByMsgType(int i3);

    void endUrlLoad(Intent intent, String str);

    void fileManagerUtilOpenUrl(Context context, String str);

    void forwardTencentDocs(AppRuntime appRuntime, Activity activity, List<FileManagerEntity> list, a aVar);

    String getBuddyName(AppInterface appInterface, String str, boolean z16);

    boolean getCommonConfigBooleanValue(Context context, String str, String str2, boolean z16);

    Intent getFileBrowserActivityClassIntent(Activity activity);

    int getFileType(String str);

    long getGroupUin(Context context);

    boolean getPreloadWebProcess();

    void getPsKey(String str, c cVar);

    boolean getReportPerformance();

    long getWebAcceleratorCostTime();

    WebResourceResponse getWebResponse(String str);

    String getWebViewUAForQQ(String str, String str2, boolean z16);

    void importFormWithLocalFile(JSONObject jSONObject, String str, String str2, d dVar);

    void importFormWithUrl(JSONObject jSONObject, String str, d dVar);

    boolean isInstanceGroupTeamWorkListActivity(Context context);

    boolean isInstanceMessageForFile(MessageRecord messageRecord);

    boolean isInstanceTeamWorkDocEditBrowserFragment(Object obj);

    boolean isQQAppInterface(AppInterface appInterface);

    boolean isTroopAdmin(AppInterface appInterface, long j3, String str);

    void jumpTimLogin(Bundle bundle, AppInterface appInterface);

    void paramInitFinish(Intent intent);

    MessageRecord queryMsgItemByUniseq(AppInterface appInterface, String str, int i3, long j3);

    void sendDocsDataBack(String str, TouchWebView touchWebView);

    void sendServiceIpcReq(Bundle bundle);

    void setRedDotForTimGroupTMShow(AppInterface appInterface, Context context, String str, String str2, boolean z16);

    void soLibraryCheckerExecute(Context context);

    String soLibraryCheckerGetSoPath(Context context);

    boolean soLibraryCheckerSoLibExists(Context context);

    void webAcceleratorSmartSchedule();
}
