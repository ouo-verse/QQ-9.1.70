package com.tencent.mobileqq.teamwork.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITeamWorkHttpUtils extends QRouteApi {
    public static final String DEFAULT_TENCENT_DOC_IMPORT_FORM = "https://qqandroid.docs.qq.com/cgi-go/imp/import_form_file";
    public static final String DEFAULT_TENCENT_DOC_TEMPLATES_URL = "https://docs.qq.com/mall/m/index?padtype=0&_wv=2&_wwv=512&from_page=s_qq_myfile_menu_create";

    void checkIfExist(String str, String str2, IGetExternalInterface.d dVar);

    String getFileMD5(String str);

    void getTencentDocReddot(String str, String str2, IGetExternalInterface.d dVar);

    void ocrExportUploadImage(AppInterface appInterface, String str, String str2, IGetExternalInterface.d dVar);

    void sendHttpsGet(String str, String str2, String str3, IGetExternalInterface.d dVar);

    void sendHttpsGet(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar);

    void sendHttpsGet(String str, String str2, String str3, String str4, boolean z16, IGetExternalInterface.d dVar);

    void sendHttpsPost(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar);

    void sendHttpsPost(String str, String str2, String str3, String str4, String str5, Map<String, String> map, boolean z16, IGetExternalInterface.d dVar);

    void sendHttpsPost(JSONObject jSONObject, String str, String str2, String str3, IGetExternalInterface.d dVar);

    void sendHttpsPost(JSONObject jSONObject, String str, String str2, String str3, String str4, IGetExternalInterface.d dVar);

    void sendHttpsPut(String str, String str2, String str3, String str4, IGetExternalInterface.d dVar);

    void uploadFile(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar);

    boolean uploadFile2Cos(File file, String str);

    void uploadFileForH5(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar);

    void uploadFileInfo(JSONObject jSONObject, String str, AppInterface appInterface, IGetExternalInterface.d dVar);

    void uploadFileInfoForH5(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar);

    void uploadFileWithParam(JSONObject jSONObject, String str, String str2, String str3, IGetExternalInterface.d dVar);

    void url2Doc(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, IGetExternalInterface.d dVar);
}
