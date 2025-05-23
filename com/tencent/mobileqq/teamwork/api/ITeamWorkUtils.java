package com.tencent.mobileqq.teamwork.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import tencent.im.oidb.cmd0xae9.online_docs$DocId;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ITeamWorkUtils extends QRouteApi {
    public static final long DOCS_APPID = 101458937;
    public static final String DOCS_LIST_KEY = "docs.qq.com/desktop/m";
    public static final String DOCS_LIST_URL = "https://docs.qq.com/desktop/m/index.html?_wv=2097154";
    public static final String DOCS_LIST_WEB_URL = "https://docs.qq.com/desktop/m/index.html?_wv=2";
    public static final String DOCS_SOURCE_ICON_URL = "https://docs.qq.com/desktop/favicon.ico";
    public static final String FILE_BROWSER_PARAMS_KEY_MINI_PROGRAM = "isMiniProgram";
    public static final String FILE_WORD_XLS = ".doc|.docx|.xls|.xlsx|";
    public static final String KEY_DOCS_CGI_ENV_ID = "key_tencent_docs_cgi_env_id";
    public static final String KEY_DOCS_WEB_CGI_FD = "key_tencent_docs_env_fd";
    public static final String KEY_DOCS_WEB_CGI_ID = "key_tencent_docs_env_id";
    public static final String KEY_DOCS_WEB_CGI_RTX = "key_tencent_docs_env_rtx";
    public static final String KEY_DOCS_WEB_CGI_SWITCH = "key_tencent_docs_env_enable";
    public static final String TD_READ_ONLY = "m_readonly";
    public static final String TD_SOURCE_QQ_ADTAG = "tdsourcetag";
    public static final String TD_SOURCE_QQ_AIOMSG = "s_qq_aiomsg";
    public static final String TD_SOURCE_QQ_AIO_ARK_H5 = "s_qq_aio_ark_h5";
    public static final String TD_SOURCE_QQ_AIO_EDIT = "s_qq_aio_edit";
    public static final String TD_SOURCE_QQ_AIO_GREY = "s_qq_aio_grey";
    public static final String TD_SOURCE_QQ_DRAWER = "s_qq_drawer";
    public static final String TD_SOURCE_QQ_FILE_EDIT = "s_qq_file_edit";
    public static final String TD_SOURCE_QQ_FILE_SHARE_EDIT = "s_QQ_file_share_edit";
    public static final String TD_SOURCE_QQ_GRPFILE = "s_qq_grpfile";
    public static final String TD_SOURCE_QQ_HISTORY_TAB = "s_qq_history_tab";
    public static final String TD_SOURCE_QQ_MINI_IMPORTING = "s_qq_mini_importing";
    public static final String TD_SOURCE_QQ_MYFILE = "s_qq_myfile";
    public static final String TD_SOURCE_QQ_MYFILE_BANNER = "s_qq_myfile_banner";
    public static final String TD_SOURCE_QQ_MYFILE_MENU_CREATE = "s_qq_myfile_menu_create";
    public static final String TD_SOURCE_QQ_MYFILE_YINDAO = "s_qq_myfile_yindao";
    public static final String TD_SOURCE_QQ_OCR_SAVE = "s_qq_ocr_save";
    public static final String TD_SOURCE_QQ_ONLINE_PREVIEW = "s_qq_file_preview";
    public static final String TD_SOURCE_QQ_URL_2_DOC = "s_qq_url_2_doc";
    public static final String TD_SOURCE_TAB = "tdsourcetab";
    public static final String TD_SOURCE_TYPE = "tdsourcetype";
    public static final String TENCENT_DOC_MIMI_APPID = "1108338344";
    public static final String TROOP_FORM_GREY_PATTERN = "<([^>])+";
    public static final String TROOP_FORM_GREY_TAG_LINK = "isLink";
    public static final String TROOP_FORM_GREY_TAG_TEXT = "text";
    public static final String TROOP_FORM_GREY_TAG_UIN = "uin";
    public static final String TROOP_FORM_MIMI_APPID = "1108961705";
    public static final String TROOP_FORM_MIMI_ENTRY = "pages/detail/detail";
    public static final String TROOP_FORM_GREY_NICKNAME = HardCodeUtil.qqStr(R.string.f172757u02);
    public static final HashMap<String, String> MINIAPP_CONFIG_TYPE_MAP = new HashMap<>();
    public static final Map<Integer, String> ENTRANCE_TO_AD_TAG_MAP = new HashMap();

    void checkDirectShareChangePolicy(int i3, int i16, Intent intent, TeamWorkFileImportInfo teamWorkFileImportInfo);

    boolean clickWebTDDoc(String str, Context context);

    boolean clickWebTDDocAndUpdateTitle(String str, Context context, int i3, FileManagerEntity fileManagerEntity, AppInterface appInterface);

    Bitmap decodeBase64ToBitmap(String str);

    String excelColIndexToStr(int i3);

    TeamWorkFileImportInfo generateTencentDocImportInfo(FileManagerEntity fileManagerEntity, boolean z16);

    String getCloudFileTime(long j3);

    online_docs$DocId getDocId(long j3, String str);

    String getNoDotExtension(String str);

    String getNoParamUrl(String str);

    String getPadInfoUrl(String str, int i3);

    Bitmap getShareBitMapBase64(String str);

    String getTDDocFileThumbUrl(String str);

    QIPCModule getTDIPCModule();

    Bitmap getTeamWorkForH5ShareBitMap(int i3);

    Bitmap getTeamWorkForShareBitMap(int i3);

    String getTencentDocSourceAdtagStrUrl(String str, String str2);

    String getTencentDocWithEditedUrl(String str, String str2);

    String getTencentDocWithReadOnlyParam(String str);

    boolean gotoAIOTencentDocListWebH5(AppInterface appInterface, Activity activity, String str, int i3, String str2);

    boolean gotoTeamWorkListWebH5(AppInterface appInterface, Activity activity);

    boolean gotoTeamWorkWebH5(Context context, String str);

    boolean isBase64ImgFormatData(String str);

    boolean isCollectionNotEmpty(Collection collection);

    boolean isDocOrXLS(String str, String str2);

    boolean isDocsFile(String str);

    boolean isDocsFormUrl(String str);

    boolean isDocsSupport(String str, String str2, String str3);

    boolean isDocsUrl(String str);

    boolean isDocsUrlForPreLoad(String str);

    boolean isFastClick();

    boolean isPushMessageDuplicated(int i3);

    void jumpToTencentDocIndex(Activity activity, String str, int i3);

    void openGroupPadTemplateListUrl(AppInterface appInterface, Activity activity, int i3, String str, long j3, long j16);

    void openGroupPadTemplatePreviewUrl(AppInterface appInterface, Activity activity, String str, long j3, GroupPadTemplateInfo groupPadTemplateInfo);

    boolean openTroopFormMiniApp(Context context, String str, String str2);

    DocsGrayTipsInfo paseDocsGrayTipsInfoFromJson(String str, String str2, String str3);

    void report(AppInterface appInterface, String str);

    void reportClickWithTroopType(AppInterface appInterface, String str, String str2);

    void reportOnlinePreview(Bundle bundle, String str);

    void reportOnlinePreview(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, String str2);

    boolean supportTencentDoc(Map<String, Long> map, String str, String str2, long j3);

    boolean supportTencentDocForEdit(String str, String str2, long j3);

    boolean supportTencentDocForLocalCooperation(String str, String str2, long j3);

    boolean supportTencentDocForPreview(String str, String str2, long j3);

    boolean targetTencentDocFormKeyWords(String str, String str2, long j3);

    String toListDate(String str) throws ParseException;

    void tryOpenWithTencentDoc(AppInterface appInterface, Context context, String str, TeamWorkFileImportInfo teamWorkFileImportInfo);

    void tryReportHistoryTab(Intent intent, String str);
}
