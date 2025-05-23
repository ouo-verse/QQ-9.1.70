package com.tencent.mobileqq.teamwork.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.SparseArray;
import com.heytap.databaseengine.utils.DateUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocConvertConfigProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocFormKeyWordsProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.config.business.tendoc.TencentDocPreviewConfigProcessor;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IQQFileDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocsListFragment;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFileImportHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.qipc.TDFileQIPCModule;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.util.URLUtil;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xae9.online_docs$DocId;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkUtilsImpl implements ITeamWorkUtils {
    private static final String IMAGE_BASE64_PREFIX_GIF = "data:image/gif;base64,";
    private static final String IMAGE_BASE64_PREFIX_JPEG = "data:image/jpeg;base64,";
    private static final String IMAGE_BASE64_PREFIX_JPG = "data:image/jpg;base64,";
    private static final String IMAGE_BASE64_PREFIX_PNG = "data:image/png;base64,";
    private static final int MIN_DELAY_TIME = 1000;
    private static final String TAG = "TeamWorkUtils";
    private static final SparseArray<Pair<Integer, String>> WX_H5_SHARE_TYPE_ICON_MAP;
    private static final SparseArray<Pair<Integer, String>> WX_MINI_SHARE_TYPE_ICON_MAP;
    private static final Map<String, Integer> WX_SHARE_TYPE_MAP;
    private static long lastClickTime;
    private static volatile int mLastMsgSeq;
    public final String TODAY = HardCodeUtil.qqStr(R.string.u0v);
    public final String YESTERDAY = HardCodeUtil.qqStr(R.string.u0g);
    public final String THIS_WEEK = HardCodeUtil.qqStr(R.string.u1k);

    static {
        HashMap<String, String> hashMap = ITeamWorkUtils.MINIAPP_CONFIG_TYPE_MAP;
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_MSG);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MY_FILE);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_YINDAO, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MY_FILE);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_BANNER, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MY_FILE);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_MENU_CREATE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_TEMPLATELIST);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_GRPFILE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_TROOP_FILE);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_AIO_GREY, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_GRAY_BAR);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_AIO_EDIT, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_EDIT);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_BOTTOM_EDIT);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_FILE_SHARE_EDIT, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MENU_EDIT);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_ONLINE_PREVIEW, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_ONLINE_PREVIEW);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_OCR_SAVE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_OCR_SAVE);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_URL_2_DOC, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_URL_2_DOC);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING, ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING);
        hashMap.put(ITeamWorkUtils.TD_SOURCE_QQ_AIO_ARK_H5, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_ARK_H5);
        Map<Integer, String> map = ITeamWorkUtils.ENTRANCE_TO_AD_TAG_MAP;
        map.put(9, ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING);
        map.put(12, ITeamWorkUtils.TD_SOURCE_QQ_URL_2_DOC);
        HashMap hashMap2 = new HashMap();
        WX_SHARE_TYPE_MAP = hashMap2;
        SparseArray<Pair<Integer, String>> sparseArray = new SparseArray<>();
        WX_MINI_SHARE_TYPE_ICON_MAP = sparseArray;
        SparseArray<Pair<Integer, String>> sparseArray2 = new SparseArray<>();
        WX_H5_SHARE_TYPE_ICON_MAP = sparseArray2;
        hashMap2.put(FileReaderHelper.DOCX_EXT, 1);
        hashMap2.put("sheet", 2);
        hashMap2.put("form", 3);
        hashMap2.put(WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, 4);
        hashMap2.put(FileReaderHelper.PDF_EXT, 5);
        sparseArray.put(1, new Pair<>(Integer.valueOf(R.drawable.dgf), "static://DefaultTeamWorkMiniShareDoc"));
        sparseArray.put(2, new Pair<>(Integer.valueOf(R.drawable.f162438dh2), "static://DefaultTeamWorkMiniShareSheet"));
        sparseArray.put(3, new Pair<>(Integer.valueOf(R.drawable.dgy), "static://DefaultTeamWorkMiniShareForm"));
        sparseArray.put(4, new Pair<>(Integer.valueOf(R.drawable.f162440dh4), "static://DefaultTeamWorkMiniShareSlide"));
        sparseArray.put(5, new Pair<>(Integer.valueOf(R.drawable.f162436dh0), "static://DefaultTeamWorkMiniSharePdf"));
        sparseArray2.put(1, new Pair<>(Integer.valueOf(R.drawable.dge), "static://DefaultTeamWorkH5ShareDoc"));
        sparseArray2.put(2, new Pair<>(Integer.valueOf(R.drawable.f162437dh1), "static://DefaultTeamWorkH5ShareSheet"));
        sparseArray2.put(3, new Pair<>(Integer.valueOf(R.drawable.dgx), "static://DefaultTeamWorkH5ShareForm"));
        sparseArray2.put(4, new Pair<>(Integer.valueOf(R.drawable.f162439dh3), "static://DefaultTeamWorkH5ShareSlide"));
        sparseArray2.put(5, new Pair<>(Integer.valueOf(R.drawable.dgz), "static://DefaultTeamWorkH5SharePdf"));
        lastClickTime = 0L;
        mLastMsgSeq = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateTdDocTitle$0(FileManagerEntity fileManagerEntity, AppInterface appInterface, Object obj) {
        if (!(obj instanceof JSONObject)) {
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        try {
            if (jSONObject.getInt("retcode") == 0) {
                String str = (String) ((JSONObject) jSONObject.get("doc_meta")).get("title");
                if (!fileManagerEntity.fileName.equals(str)) {
                    fileManagerEntity.fileName = str;
                    ((IQQFileDataCenter) appInterface.getRuntimeService(IQQFileDataCenter.class, "all")).updateFileEntity(fileManagerEntity);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private Bitmap obtainShareBitmap(SparseArray<Pair<Integer, String>> sparseArray, int i3, String str, int i16) {
        Pair<Integer, String> pair;
        if (sparseArray != null && (pair = sparseArray.get(i16)) != null) {
            str = (String) pair.second;
            i3 = ((Integer) pair.first).intValue();
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null && (f16 = com.tencent.mobileqq.util.j.h(MobileQQ.sMobileQQ.getResources(), i3)) != null) {
            imageCacheHelper.i(str, f16, Business.AIO);
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTdDocTitle(String str, final AppInterface appInterface, final FileManagerEntity fileManagerEntity) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TeamWorkHandlerUtils.l(str, appInterface.getCurrentAccountUin(), new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.api.impl.ap
            @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
            public final void a(Object obj) {
                TeamWorkUtilsImpl.lambda$updateTdDocTitle$0(FileManagerEntity.this, appInterface, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void checkDirectShareChangePolicy(int i3, int i16, Intent intent, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (i3 == 2865 && i16 == -1) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "direct share done, try change policy");
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime instanceof AppInterface) {
                AppInterface appInterface = (AppInterface) waitAppRuntime;
                if (((ITeamWorkFileImportHandler) appInterface.getBusinessHandler(((ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class)).getImportHandlerName())) != null && teamWorkFileImportInfo != null) {
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("uin");
                    extras.getInt("uintype", 0);
                    if (teamWorkFileImportInfo.f292069c0 != null) {
                        new ArrayList(1).add(string);
                        final String str = teamWorkFileImportInfo.f292069c0;
                        if (!TextUtils.isEmpty(str)) {
                            final String currentAccountUin = appInterface.getCurrentAccountUin();
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsImpl.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    String[] split = str.split("\\$");
                                    if (split.length == 2) {
                                        TeamWorkHandlerUtils.q(currentAccountUin, split[0], split[1], 1, null);
                                    }
                                }
                            }, 128, null, false);
                        }
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean clickWebTDDoc(String str, Context context) {
        return clickWebTDDocAndUpdateTitle(str, context, -1, null, null);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean clickWebTDDocAndUpdateTitle(final String str, Context context, int i3, final FileManagerEntity fileManagerEntity, final AppInterface appInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "TencentDoc clickWeb url = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (fileManagerEntity != null && appInterface != null) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.teamwork.api.impl.TeamWorkUtilsImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    TeamWorkUtilsImpl.this.updateTdDocTitle(str, appInterface, fileManagerEntity);
                }
            }, null, true);
        }
        String trim = str.trim();
        if (!isDocsUrl(trim)) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", trim);
        bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG);
        bundle.putInt(ITeamWorkUtils.TD_SOURCE_TAB, i3);
        ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(context, bundle, false);
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public Bitmap decodeBase64ToBitmap(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            byte[] decode = Base64.decode(str.split(",")[1], 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Texture: cannot decode base64: " + QLog.getStackTraceString(e16));
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String excelColIndexToStr(int i3) {
        if (i3 <= 0) {
            return null;
        }
        int i16 = i3 - 1;
        String str = "";
        do {
            if (str.length() > 0) {
                i16--;
            }
            StringBuilder sb5 = new StringBuilder();
            int i17 = i16 % 26;
            sb5.append((char) (i17 + 65));
            sb5.append(str);
            str = sb5.toString();
            i16 = (i16 - i17) / 26;
        } while (i16 > 0);
        return str;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public TeamWorkFileImportInfo generateTencentDocImportInfo(FileManagerEntity fileManagerEntity, boolean z16) {
        if (fileManagerEntity == null) {
            return null;
        }
        TeamWorkFileImportInfo teamWorkFileImportInfo = new TeamWorkFileImportInfo();
        teamWorkFileImportInfo.N = false;
        teamWorkFileImportInfo.f292074f = fileManagerEntity.fileName;
        teamWorkFileImportInfo.f292078h0 = fileManagerEntity.fileSize;
        teamWorkFileImportInfo.f292077h = fileManagerEntity.getFilePath();
        teamWorkFileImportInfo.R = fileManagerEntity.nFileType;
        teamWorkFileImportInfo.K = z16;
        teamWorkFileImportInfo.f292071d0 = fileManagerEntity.WeiYunFileId;
        teamWorkFileImportInfo.f292073e0 = fileManagerEntity.Uuid;
        teamWorkFileImportInfo.f292075f0 = fileManagerEntity.bSend;
        if (!TextUtils.isEmpty(fileManagerEntity.peerUin)) {
            teamWorkFileImportInfo.f292070d = fileManagerEntity.peerType;
            teamWorkFileImportInfo.f292072e = fileManagerEntity.peerUin;
            teamWorkFileImportInfo.F = String.valueOf(fileManagerEntity.TroopUin);
            teamWorkFileImportInfo.D = fileManagerEntity.busId;
            teamWorkFileImportInfo.C = fileManagerEntity.strTroopFilePath;
            teamWorkFileImportInfo.f292079i = fileManagerEntity.uniseq;
            if (fileManagerEntity.status != 16) {
                teamWorkFileImportInfo.I = true;
            }
        }
        return teamWorkFileImportInfo;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String getCloudFileTime(long j3) {
        try {
            String listDate = toListDate(new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(Long.valueOf(j3)));
            if (listDate.equals(this.TODAY)) {
                return this.TODAY + " " + new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(Long.valueOf(j3));
            }
            if (listDate.equals(this.YESTERDAY)) {
                return this.YESTERDAY + " " + new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR).format(Long.valueOf(j3));
            }
            return new SimpleDateFormat("MM-dd HH:mm").format(Long.valueOf(j3));
        } catch (ParseException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public online_docs$DocId getDocId(long j3, String str) {
        online_docs$DocId online_docs_docid = new online_docs$DocId();
        online_docs_docid.pad_id.set(ByteStringMicro.copyFromUtf8(str));
        online_docs_docid.domain_id.set(j3);
        return online_docs_docid;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String getNoDotExtension(String str) {
        String j3 = com.tencent.mobileqq.filemanager.util.q.j(str);
        if (TextUtils.isEmpty(j3)) {
            return null;
        }
        return j3.toLowerCase().replace(".", "");
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String getNoParamUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split("\\?");
        if (split != null && split.length > 0) {
            return split[0];
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1  */
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getPadInfoUrl(String str, int i3) {
        String[] split;
        boolean z16;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        String[] split2 = str.split("\\?");
        if (split2 != null && split2.length > 0) {
            boolean z17 = false;
            sb5 = new StringBuilder(split2[0]);
            if (split2.length > 1 && (split = split2[1].split(ContainerUtils.FIELD_DELIMITER)) != null) {
                boolean z18 = false;
                for (String str3 : split) {
                    String[] split3 = str3.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3 != null && split3.length == 2) {
                        if (split3[0].equals("type")) {
                            if (!z18) {
                                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                            }
                            if (z18) {
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                            }
                            str2 = "type=" + split3[1];
                        } else if (split3[0].equals("_wv")) {
                            if (!z18) {
                                sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                            }
                            if (z18) {
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                            }
                            str2 = "_wv=" + split3[1];
                        } else {
                            z16 = z18;
                            str2 = null;
                            if (str2 != null) {
                                sb5.append(str2);
                            }
                            z18 = z16;
                        }
                        z16 = true;
                        if (str2 != null) {
                        }
                        z18 = z16;
                    }
                }
                z17 = z18;
            }
            if (!z17 && (i3 == 1 || i3 == 2)) {
                sb5.append("?type=");
                sb5.append(i3);
                sb5.append("&_wv=1");
            }
        }
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public Bitmap getShareBitMapBase64(String str) {
        try {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "getTeamWorkForWXMiniProShareBitMap mMiniProgramImageUrl = " + str);
            }
            if (TextUtils.isEmpty(str) || !isBase64ImgFormatData(str)) {
                return null;
            }
            return decodeBase64ToBitmap(str);
        } catch (IllegalArgumentException e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String getTDDocFileThumbUrl(String str) {
        if (com.tencent.mobileqq.filemanager.data.e.a(str)) {
            return "https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.doc.png";
        }
        if (com.tencent.mobileqq.filemanager.data.e.f(str)) {
            return "https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.sheet.png";
        }
        if (com.tencent.mobileqq.filemanager.data.e.b(str)) {
            return "https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.form.png";
        }
        if (com.tencent.mobileqq.filemanager.data.e.e(str)) {
            return "https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.slide.png";
        }
        if (com.tencent.mobileqq.filemanager.data.e.d(str)) {
            return "https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-pdf.png";
        }
        if (com.tencent.mobileqq.filemanager.data.e.c(str)) {
            return "https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.mind.png";
        }
        return "";
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public QIPCModule getTDIPCModule() {
        return new TDFileQIPCModule();
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public Bitmap getTeamWorkForH5ShareBitMap(int i3) {
        return obtainShareBitmap(WX_H5_SHARE_TYPE_ICON_MAP, R.drawable.dge, "static://DefaultTeamWorkH5ShareDoc", i3);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public Bitmap getTeamWorkForShareBitMap(int i3) {
        return obtainShareBitmap(WX_MINI_SHARE_TYPE_ICON_MAP, R.drawable.dgf, "static://DefaultTeamWorkMiniShareDoc", i3);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String getTencentDocSourceAdtagStrUrl(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String str3 = "?tdsourcetag=" + str2;
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str3 = "&tdsourcetag=" + str2;
            }
            String str4 = str + str3;
            lr2.a.i(null, lr2.a.g(str), "0X8009EA0", str2, lr2.a.h(str), "");
            lr2.a.l(TAG, ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, str2);
            return str4;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String getTencentDocWithEditedUrl(String str, String str2) {
        try {
            String encode = URLEncoder.encode(str2, "UTF-8");
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str3 = "?edited_url=" + encode;
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str3 = "&edited_url=" + encode;
            }
            return str + str3;
        } catch (UnsupportedEncodingException e16) {
            QLog.e(TAG, 1, e16.getLocalizedMessage(), e16);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String getTencentDocWithReadOnlyParam(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str2 = "&m_readonly=1";
            } else {
                str2 = "?m_readonly=1";
            }
            return str + str2;
        }
        return "";
    }

    public String getTime8(String str) {
        Matcher matcher = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]").matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005a A[Catch: Exception -> 0x00eb, TryCatch #0 {Exception -> 0x00eb, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0020, B:9:0x0028, B:10:0x002c, B:12:0x005a, B:13:0x007f, B:15:0x0085, B:18:0x009e, B:19:0x00b3), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0085 A[Catch: Exception -> 0x00eb, TryCatch #0 {Exception -> 0x00eb, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0020, B:9:0x0028, B:10:0x002c, B:12:0x005a, B:13:0x007f, B:15:0x0085, B:18:0x009e, B:19:0x00b3), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009e A[Catch: Exception -> 0x00eb, TryCatch #0 {Exception -> 0x00eb, blocks: (B:3:0x0007, B:5:0x0019, B:7:0x0020, B:9:0x0028, B:10:0x002c, B:12:0x005a, B:13:0x007f, B:15:0x0085, B:18:0x009e, B:19:0x00b3), top: B:2:0x0007 }] */
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean gotoAIOTencentDocListWebH5(AppInterface appInterface, Activity activity, String str, int i3, String str2) {
        String a16;
        String encode;
        String str3;
        long j3;
        TroopInfo a17;
        try {
            a16 = ta1.d.a();
            encode = URLEncoder.encode(str2, "UTF-8");
            str3 = "";
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (i3 == 1) {
            str3 = "group_aio";
            if ((appInterface instanceof BaseQQAppInterface) && (a17 = com.tencent.mobileqq.imcore.proxy.troop.a.a((BaseQQAppInterface) appInterface, str)) != null) {
                j3 = a17.dwGroupClassExt;
                String str4 = a16 + "?toUin=" + str + "&uinType=" + String.valueOf(i3) + "&remarkName=" + encode;
                if (a16.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str4 = a16 + "&toUin=" + str + "&uinType=" + String.valueOf(i3) + "&remarkName=" + encode;
                }
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str4 + "&create_from=" + str3;
                }
                if (j3 != -1) {
                    str4 = str4 + "&group_type=" + j3;
                }
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, RouterConstants.UI_ROUTE_BROWSER);
                activityURIRequest.extra().putString("url", str4);
                activityURIRequest.extra().putString("toUin", str);
                activityURIRequest.extra().putInt("uinType", i3);
                activityURIRequest.extra().putString("big_brother_source_key", IWeiyunHelper.SOURCE_ID);
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
                return true;
            }
        }
        j3 = -1;
        String str42 = a16 + "?toUin=" + str + "&uinType=" + String.valueOf(i3) + "&remarkName=" + encode;
        if (a16.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
        }
        if (!TextUtils.isEmpty(str3)) {
        }
        if (j3 != -1) {
        }
        ActivityURIRequest activityURIRequest2 = new ActivityURIRequest(activity, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest2.extra().putString("url", str42);
        activityURIRequest2.extra().putString("toUin", str);
        activityURIRequest2.extra().putInt("uinType", i3);
        activityURIRequest2.extra().putString("big_brother_source_key", IWeiyunHelper.SOURCE_ID);
        QRoute.startUri(activityURIRequest2, (com.tencent.mobileqq.qroute.route.o) null);
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean gotoTeamWorkListWebH5(AppInterface appInterface, Activity activity) {
        String e16;
        try {
            if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().e())) {
                e16 = "https://docs.qq.com/desktop/m/index.html?_from=1";
            } else {
                e16 = TencentDocConvertConfigProcessor.a().e();
            }
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, RouterConstants.UI_ROUTE_BROWSER);
            activityURIRequest.extra().putString("big_brother_source_key", IWeiyunHelper.SOURCE_ID);
            activityURIRequest.extra().putString("url", e16);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            return true;
        } catch (Exception e17) {
            e17.printStackTrace();
            return true;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean gotoTeamWorkWebH5(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
            activityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_file");
            activityURIRequest.extra().putString("url", str);
            QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return true;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isBase64ImgFormatData(String str) {
        if (!str.startsWith(IMAGE_BASE64_PREFIX_JPG) && !str.startsWith(IMAGE_BASE64_PREFIX_PNG) && !str.startsWith(IMAGE_BASE64_PREFIX_JPEG) && !str.startsWith(IMAGE_BASE64_PREFIX_GIF)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isCollectionNotEmpty(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isDocOrXLS(String str, String str2) {
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                str2 = file.getName();
            }
        }
        String j3 = com.tencent.mobileqq.filemanager.util.q.j(str2);
        if (!TextUtils.isEmpty(j3) && ITeamWorkUtils.FILE_WORD_XLS.indexOf(j3.toLowerCase()) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isDocsFile(String str) {
        return ITeamWorkUtils.FILE_WORD_XLS.contains(str);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isDocsFormUrl(String str) {
        String path;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.contains("docs.qq.com/form") && !str.contains("docx.qq.com/form")) {
            return false;
        }
        try {
            path = new URL(str).getPath();
        } catch (Exception e16) {
            QLog.e("docHome", 1, " detect docHome error: " + e16.toString());
        }
        if (TextUtils.isEmpty(path) || path.equals("/") || path.equals("/index.html") || path.equals("/mobile.html")) {
            return false;
        }
        if (path.equals("/login.html")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isDocsSupport(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                str2 = file.getName();
            }
        }
        String j3 = com.tencent.mobileqq.filemanager.util.q.j(str2);
        if (!TextUtils.isEmpty(j3) && str3.indexOf(j3.toLowerCase()) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isDocsUrl(String str) {
        String path;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.contains(ITeamWorkHandler.DOCS_DOMAIN) && !str.contains("docx.qq.com")) {
            return false;
        }
        try {
            path = new URL(str).getPath();
        } catch (Exception e16) {
            QLog.e("docHome", 1, " detect docHome error: " + e16.toString());
        }
        if (TextUtils.isEmpty(path) || path.equals("/") || path.equals("/index.html") || path.equals("/mobile.html")) {
            return false;
        }
        if (path.equals("/login.html")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isDocsUrlForPreLoad(String str) {
        if (!TextUtils.isEmpty(str) && (str.contains("docs.qq.com/doc/") || str.contains("docs.qq.com/sheet/") || str.contains("docs.qq.com/form/fill/") || str.contains("docs.qq.com/form/edit/"))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean isFastClick() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime >= 1000) {
            z16 = false;
        } else {
            z16 = true;
        }
        lastClickTime = currentTimeMillis;
        return z16;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public synchronized boolean isPushMessageDuplicated(int i3) {
        boolean z16;
        if (mLastMsgSeq == i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        mLastMsgSeq = i3;
        return z16;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void jumpToTencentDocIndex(Activity activity, String str, int i3) {
        String e16;
        try {
            if (TextUtils.isEmpty(TencentDocConvertConfigProcessor.a().e())) {
                e16 = "https://docs.qq.com/desktop/m/index.html?_from=1";
            } else {
                e16 = TencentDocConvertConfigProcessor.a().e();
            }
            String tencentDocSourceAdtagStrUrl = getTencentDocSourceAdtagStrUrl(e16, str);
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, RouterConstants.UI_ROUTE_BROWSER);
            activityURIRequest.extra().putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, str);
            activityURIRequest.extra().putString("big_brother_source_key", "biz_src_jc_file");
            activityURIRequest.extra().putString("fragment_class", ((ITeamWorkDocsListFragment) QRoute.api(ITeamWorkDocsListFragment.class)).getCanonicalName());
            activityURIRequest.extra().putString("url", tencentDocSourceAdtagStrUrl);
            if (TextUtils.equals(str, ITeamWorkUtils.TD_SOURCE_QQ_HISTORY_TAB)) {
                str = ITeamWorkUtils.TD_SOURCE_QQ_MYFILE;
            }
            if (!((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openDocsMiniApp(activity, tencentDocSourceAdtagStrUrl, str)) {
                if (i3 >= 0) {
                    activityURIRequest.setRequestCode(i3);
                }
                QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
            }
        } catch (Exception e17) {
            QLog.i(TAG, 1, e17.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0086, code lost:
    
        if (r18 == 3) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00aa  */
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openGroupPadTemplateListUrl(AppInterface appInterface, Activity activity, int i3, String str, long j3, long j16) {
        String str2;
        String valueOf = String.valueOf(j3);
        int i16 = 3;
        if (i3 == 1) {
            str2 = "https://docs.qq.com/mall/m/index/doc?padtype=0&_wv=2&_wwv=512&from_page=s_qq_grpfile&group_code=" + valueOf + "&group_type=" + j16 + "&create_from=" + str;
        } else if (i3 == 2) {
            str2 = "https://docs.qq.com/mall/m/index/sheet?padtype=1&_wv=2&_wwv=512&from_page=s_qq_grpfile&group_code=" + valueOf + "&group_type=" + j16 + "&create_from=" + str;
        } else if (i3 != 3) {
            str2 = "";
        } else {
            str2 = "https://docs.qq.com/mall/m/index/form/collect?padtype=2&_wv=2&_wwv=512&from_page=s_qq_grpfile&group_code=" + valueOf + "&group_type=" + j16 + "&create_from=" + str;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                i16 = 2;
            }
            Bundle bundle = new Bundle();
            bundle.putString("url", str2);
            bundle.putString("title", activity.getString(R.string.hyl));
            bundle.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, i16);
            if (appInterface instanceof BaseQQAppInterface) {
                TroopInfo a16 = com.tencent.mobileqq.imcore.proxy.troop.a.a((BaseQQAppInterface) appInterface, String.valueOf(j3));
                if (a16 != null && !TextUtils.isEmpty(a16.troopname)) {
                    bundle.putString("troop_name", a16.troopname);
                } else {
                    bundle.putString("troop_name", "" + j3);
                }
            }
            ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(activity, bundle, true);
        }
        i16 = 1;
        Bundle bundle2 = new Bundle();
        bundle2.putString("url", str2);
        bundle2.putString("title", activity.getString(R.string.hyl));
        bundle2.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, i16);
        if (appInterface instanceof BaseQQAppInterface) {
        }
        ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(activity, bundle2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012a  */
    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openGroupPadTemplatePreviewUrl(AppInterface appInterface, Activity activity, String str, long j3, GroupPadTemplateInfo groupPadTemplateInfo) {
        String str2;
        String str3;
        int i3;
        int i16;
        String str4;
        boolean z16;
        if (groupPadTemplateInfo == null) {
            str2 = "";
            str3 = str2;
            i3 = 1;
            i16 = 0;
        } else {
            i3 = groupPadTemplateInfo.docOrSheetType;
            i16 = groupPadTemplateInfo.templateID;
            str3 = String.valueOf(groupPadTemplateInfo.groupCode);
            str2 = groupPadTemplateInfo.templateUrl;
        }
        if (TextUtils.isEmpty(str2)) {
            str4 = "";
        } else {
            str4 = "https:" + str2;
            if (URLUtil.isValidUrl(str4)) {
                z16 = false;
                int i17 = 2;
                if (z16) {
                    if (i3 == 1) {
                        str4 = "https://" + appInterface.getCurrentAccountUin() + "." + String.format("docs.qq.com/template/preview?padtype=doc&tid=%s&pdid=null", Integer.valueOf(i16)) + "&group_code=" + str3;
                    } else if (i3 == 2) {
                        str4 = "https://" + appInterface.getCurrentAccountUin() + "." + String.format("docs.qq.com/template/preview?padtype=sheet&tid=%s&pdid=null", Integer.valueOf(i16)) + "&group_code=" + str3;
                    }
                }
                if (!TextUtils.isEmpty(str) && j3 != -1 && !TextUtils.isEmpty(str4)) {
                    if (!str4.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                        str4 = str4 + "&group_type=" + j3 + "&create_from=" + str;
                    } else {
                        str4 = str4 + "?group_type=" + j3 + "&create_from=" + str;
                    }
                }
                if (i3 != 1 || i3 != 2) {
                    i17 = 1;
                }
                Bundle bundle = new Bundle();
                bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_GRPFILE);
                bundle.putString("url", str4);
                bundle.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, i17);
                if (appInterface instanceof BaseQQAppInterface) {
                    TroopInfo a16 = com.tencent.mobileqq.imcore.proxy.troop.a.a((BaseQQAppInterface) appInterface, str3);
                    if (a16 != null && !TextUtils.isEmpty(a16.troopname)) {
                        bundle.putString("troop_name", a16.troopname);
                    } else {
                        bundle.putString("troop_name", "" + str3);
                    }
                }
                ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(activity, bundle, true);
            }
        }
        z16 = true;
        int i172 = 2;
        if (z16) {
        }
        if (!TextUtils.isEmpty(str)) {
            if (!str4.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            }
        }
        if (i3 != 1) {
        }
        i172 = 1;
        Bundle bundle2 = new Bundle();
        bundle2.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_GRPFILE);
        bundle2.putString("url", str4);
        bundle2.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, i172);
        if (appInterface instanceof BaseQQAppInterface) {
        }
        ((ITeamWorkDocEditBrowserProxy) QRoute.api(ITeamWorkDocEditBrowserProxy.class)).openTeamWorkDocEditBrowserActivity(activity, bundle2, true);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean openTroopFormMiniApp(Context context, String str, String str2) {
        QLog.d(TAG, 1, "troopFormLog openTroopFormMiniApp =" + str);
        try {
            String str3 = ITeamWorkUtils.TROOP_FORM_MIMI_ENTRY;
            String str4 = "";
            if (!TextUtils.isEmpty(str)) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(ITeamWorkUtils.TROOP_FORM_MIMI_ENTRY);
                sb5.append("?url=");
                sb5.append(URLEncoder.encode(str, "utf-8"));
                if (!TextUtils.isEmpty(str2)) {
                    str4 = ContainerUtils.FIELD_DELIMITER + str2;
                }
                sb5.append(str4);
                str3 = sb5.toString();
                str4 = "url=" + str;
            }
            String str5 = str3;
            String str6 = str4;
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(context, ITeamWorkUtils.TROOP_FORM_MIMI_APPID, str5, str6, "", "", 0, null);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "openTroopFormMiniApp:open :scene = 0miniAppId = " + ITeamWorkUtils.TROOP_FORM_MIMI_APPID + "entryPath = " + str5 + "navigateExtData = " + str6);
            }
            return true;
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "openTroopFormMiniApp " + e16.getMessage());
            }
            return false;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public DocsGrayTipsInfo paseDocsGrayTipsInfoFromJson(String str, String str2, String str3) {
        DocsGrayTipsInfo docsGrayTipsInfo;
        DocsGrayTipsInfo docsGrayTipsInfo2 = null;
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 2, " gray tips jason null");
            return null;
        }
        try {
            docsGrayTipsInfo = new DocsGrayTipsInfo();
        } catch (Exception e16) {
            e = e16;
        }
        try {
            docsGrayTipsInfo.f291464d = str2;
            docsGrayTipsInfo.f291465e = str3;
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("type")) {
                docsGrayTipsInfo.f291466f = jSONObject.getString("type");
            }
            if (jSONObject.has("optType")) {
                docsGrayTipsInfo.f291467h = jSONObject.getString("optType");
            }
            if (jSONObject.has("authTips")) {
                docsGrayTipsInfo.f291468i = jSONObject.getString("authTips");
            }
            if (jSONObject.has("highlightText")) {
                docsGrayTipsInfo.f291469m = jSONObject.getString("highlightText");
            }
            if (jSONObject.has("setpolicy")) {
                docsGrayTipsInfo.D = jSONObject.getString("setpolicy");
            }
            if (jSONObject.has("setflag")) {
                docsGrayTipsInfo.C = jSONObject.getString("setflag");
            }
            if (jSONObject.has("setonly")) {
                docsGrayTipsInfo.E = jSONObject.getString("setonly");
            }
            if (jSONObject.has("sucResult")) {
                docsGrayTipsInfo.F = jSONObject.getString("sucResult");
            }
            if (jSONObject.has("failResult")) {
                docsGrayTipsInfo.G = jSONObject.getString("failResult");
            }
            if (jSONObject.has("netFailResult")) {
                docsGrayTipsInfo.H = jSONObject.getString("netFailResult");
            }
            if (jSONObject.has("policy")) {
                docsGrayTipsInfo.I = jSONObject.getString("policy");
            }
            if (jSONObject.has("privilege")) {
                docsGrayTipsInfo.J = jSONObject.getString("privilege");
            }
            if (jSONObject.has("member_number")) {
                docsGrayTipsInfo.K = jSONObject.getString("member_number");
            }
            if (jSONObject.has("exp_remain_time")) {
                docsGrayTipsInfo.L = jSONObject.getString("exp_remain_time");
            }
            if (jSONObject.has("exp_set_time")) {
                docsGrayTipsInfo.M = jSONObject.getString("exp_set_time");
            }
            if (jSONObject.has("bNeedSetTime")) {
                docsGrayTipsInfo.N = jSONObject.getString("bNeedSetTime");
            }
            if (jSONObject.has("tiptype")) {
                docsGrayTipsInfo.P = jSONObject.getString("tiptype");
            }
            if (jSONObject.has("tipurl")) {
                docsGrayTipsInfo.Q = jSONObject.getString("tipurl");
                return docsGrayTipsInfo;
            }
            return docsGrayTipsInfo;
        } catch (Exception e17) {
            e = e17;
            docsGrayTipsInfo2 = docsGrayTipsInfo;
            QLog.e(TAG + com.tencent.mobileqq.teamwork.t.f292405j, 1, " paseDocsGrayTipsInfoFromJson e =" + e.toString());
            return docsGrayTipsInfo2;
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void report(AppInterface appInterface, String str) {
        ReportController.o(appInterface, "CliOper", "", "", str, str, 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void reportClickWithTroopType(AppInterface appInterface, String str, String str2) {
        String str3;
        TroopInfo a16;
        if (appInterface != null && !TextUtils.isEmpty(str2)) {
            if (!(appInterface instanceof BaseQQAppInterface) || (a16 = com.tencent.mobileqq.imcore.proxy.troop.a.a((BaseQQAppInterface) appInterface, str2)) == null) {
                str3 = "";
            } else {
                str3 = "" + a16.dwGroupClassExt;
            }
            ReportController.o(appInterface, "CliOper", "", "", str, str, 0, 0, "", "", str3, "");
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void reportOnlinePreview(Bundle bundle, String str) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(TeamWorkUtilsImpl.class.getClassLoader());
        if (bundle.getParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO) instanceof TeamWorkFileImportInfo) {
            reportOnlinePreview((TeamWorkFileImportInfo) bundle.getParcelable(AppConstants.KEY_TEAM_WORK_FILE_IMPORT_INFO), bundle.getString("url"), str);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean supportTencentDoc(Map<String, Long> map, String str, String str2, long j3) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                str2 = file.getName();
            }
        }
        String noDotExtension = getNoDotExtension(str2);
        if (TextUtils.isEmpty(noDotExtension) || !map.containsKey(noDotExtension) || map.get(noDotExtension).longValue() <= j3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean supportTencentDocForEdit(String str, String str2, long j3) {
        return supportTencentDoc(TencentDocConvertConfigProcessor.a().l(), str, str2, j3);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean supportTencentDocForLocalCooperation(String str, String str2, long j3) {
        return supportTencentDoc(TencentDocLocalCooperationProcessor.c().f435703e, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean supportTencentDocForPreview(String str, String str2, long j3) {
        return supportTencentDoc(TencentDocPreviewConfigProcessor.c().a(), str, str2, j3);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public boolean targetTencentDocFormKeyWords(String str, String str2, long j3) {
        ta1.i c16 = TencentDocFormKeyWordsProcessor.c();
        if (c16 != null) {
            boolean supportTencentDoc = supportTencentDoc(c16.f435687e, str, str2, j3);
            if (supportTencentDoc) {
                return c16.a(str2);
            }
            return supportTencentDoc;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public String toListDate(String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        String time8 = getTime8(str);
        String format = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date());
        Date parse = simpleDateFormat.parse(time8);
        Date parse2 = simpleDateFormat.parse(format);
        if (parse2.getTime() - parse.getTime() == 0) {
            return this.TODAY;
        }
        if (parse2.getTime() - parse.getTime() > 0 && parse2.getTime() - parse.getTime() <= 86400000) {
            return this.YESTERDAY;
        }
        if (parse2.getTime() - parse.getTime() > 0 && parse2.getTime() - parse.getTime() <= 604800000) {
            return this.THIS_WEEK;
        }
        return str.substring(0, 4) + HardCodeUtil.qqStr(R.string.u1b) + str.substring(5, 7) + HardCodeUtil.qqStr(R.string.u0e);
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void tryOpenWithTencentDoc(AppInterface appInterface, Context context, String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (appInterface != null && teamWorkFileImportInfo != null) {
            teamWorkFileImportInfo.J = 7;
            com.tencent.mobileqq.teamwork.u.r(appInterface, context, str, teamWorkFileImportInfo, null);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "appInterface == null || info == null");
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void tryReportHistoryTab(Intent intent, String str) {
        int i3;
        if (intent != null && !TextUtils.isEmpty(str)) {
            String stringExtra = intent.getStringExtra(ITeamWorkUtils.TD_SOURCE_TYPE);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (stringExtra.contains("1")) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(null, "dc00898", "", "", str, str, i3, 0, "", "", ITeamWorkUtils.TD_SOURCE_QQ_HISTORY_TAB, stringExtra.substring(0, stringExtra.length() - 1));
        }
    }

    @Override // com.tencent.mobileqq.teamwork.api.ITeamWorkUtils
    public void reportOnlinePreview(TeamWorkFileImportInfo teamWorkFileImportInfo, String str, String str2) {
        if (teamWorkFileImportInfo == null || !teamWorkFileImportInfo.c() || TextUtils.isEmpty(str2)) {
            return;
        }
        lr2.a.i(null, teamWorkFileImportInfo.X, str2, getNoDotExtension(teamWorkFileImportInfo.f292074f), String.valueOf(str != null && str.contains(ITeamWorkUtils.TD_READ_ONLY)), String.valueOf(teamWorkFileImportInfo.f292078h0));
    }
}
