package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITeamWorkFileImportHandler extends QRouteApi {
    public static final int MSG_FILE_CHECK_ERROR = 8005;
    public static final int MSG_FILE_CHECK_SUCCESS = 8004;
    public static final int MSG_FILE_IMPORTING = 8003;
    public static final int MSG_FILE_IMPORT_ERROR = 8002;
    public static final int MSG_FILE_IMPORT_SUCCESS = 8001;
    public static final int OBSERVER_FILE_IMPORT_FAILED = 2;
    public static final int OBSERVER_FILE_IMPORT_GET_DOT = 3;
    public static final int OBSERVER_FILE_IMPORT_IS_NEW_TENCENT_DOC = 5;
    public static final int OBSERVER_FILE_IMPORT_STARTED = 4;
    public static final int OBSERVER_FILE_IMPORT_SUCCESS = 1;
    public static final int OBSERVER_FILE_IS_IMPORTED = 6;
    public static final int OBSERVER_FILE_IS_NO_CACHE = 7;
    public static final int RETCODE_CGI_NOT_RETURN = -1000;
    public static final int RETCODE_CGI_NO_PUBLIC_CACHE = 20003;
    public static final int RETCODE_CGI_NO_USER_CACHE = 20004;
    public static final int RETCODE_CGI_NO_USER_CACHE_FOR_DISCUSS = 20005;
    public static final String TAG = "TeamWorkFileImportHandler";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(int i3, String str, Object obj);
    }

    void addFileImportJob(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void addToConvertedMap(TeamWorkFileImportInfo teamWorkFileImportInfo, String str);

    void addToFileImportingMap(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void checkFormCache(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo);

    void createGrayTips(TeamWorkFileImportInfo teamWorkFileImportInfo, String str);

    void fileImportFromLocalFile(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void fileImportFromLocalFileForDataLine(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void fileImportFromLocalFileForH5(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void fileImportFromUrl(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, int i3);

    void fileImportFromUrl2Doc(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void fileImportFromUrlForH5(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo, int i3);

    void getLocalFileImportInfo(TeamWorkFileImportInfo teamWorkFileImportInfo, a aVar);

    void getTencentDocReddot(String str);

    String getUrlFromConvertedMap(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void importFormWithLocalFile(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo);

    void importFormWithUrl(JSONObject jSONObject, TeamWorkFileImportInfo teamWorkFileImportInfo);

    boolean isFileImporting(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void notifyUIError(TeamWorkFileImportInfo teamWorkFileImportInfo);

    boolean parseFileImportResultForH5(String str, TeamWorkFileImportInfo teamWorkFileImportInfo);

    void removeFileImporting(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void removeFromConvertedMap(TeamWorkFileImportInfo teamWorkFileImportInfo);

    void setIsNeedToast(boolean z16);

    boolean updateFileImporting(TeamWorkFileImportInfo teamWorkFileImportInfo, boolean z16);
}
