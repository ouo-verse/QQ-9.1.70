package com.tencent.mobileqq.vas.quickupdate;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasUpdateManager;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.ipc.QuickUpdateIPCModule;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import mqq.app.MobileQQ;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeUpdateBusiness extends QQVasUpdateBusiness {
    public static final long BID = 3;
    public static String SCID_THEME_ZIP_PREFIX = "theme.";
    public static String SCID_THEME_ZIP_PREFIX_VIDEO = "theme.video.";
    private static final Boolean SUPPORT_NEW_SCID;
    private static Boolean SUPPORT_NEW_SCID_TOOL = null;
    private static final int THEME_VIDEO_RES_RETRY_COUNT = 3;
    private static final IVasUpdateManager.a downloadInterceptor;
    private static final boolean isSupportRetryCount;
    private static ArrayList<String> sExcludeThemeIds;
    private static final UnitedProxy themeSupportNewScid;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements IVasUpdateManager.a {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.api.IVasUpdateManager.a
        public void a(String str) {
            if (str.startsWith(ThemeUpdateBusiness.SCID_THEME_ZIP_PREFIX) && ThemeUpdateBusiness.isSupportNewScid()) {
                p23.c.f424977a.e(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f310607a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f310608b;

        b(int i3, String str) {
            this.f310607a = i3;
            this.f310608b = str;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            QLog.i("VasUpdate_QQBusiness", 1, "onLoadFail: " + updateListenerParams.mBusinessUpdateParams.mItemId + " " + updateListenerParams.mErrorCode + " " + updateListenerParams.mErrorMessage + " tryCount: " + this.f310607a);
            if (ThemeUpdateBusiness.isSupportRetryCount) {
                ThemeUpdateBusiness.this.startDownloadVideoRes(this.f310608b, this.f310607a - 1);
            }
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            QLog.i("VasUpdate_QQBusiness", 1, "onLoadSuccess: " + updateListenerParams.mBusinessUpdateParams.mItemId + " " + updateListenerParams.mErrorCode + " " + updateListenerParams.mErrorMessage + " tryCount: " + this.f310607a);
        }
    }

    static {
        UnitedProxy b16 = ar.b("shouyouye", "2024-01-31", "vas_theme_support_new_scid");
        themeSupportNewScid = b16;
        Boolean valueOf = Boolean.valueOf(b16.isEnable(false));
        SUPPORT_NEW_SCID = valueOf;
        isSupportRetryCount = ar.b("shouyouye", "2024-09-27", "vas_theme_video_res_retry").isEnable(true);
        SUPPORT_NEW_SCID_TOOL = null;
        downloadInterceptor = new a();
        if (MobileQQ.sProcessId == 1) {
            VipMMKV.getCommon().encodeBool("vas_theme_support_new_scid", valueOf.booleanValue());
        }
    }

    public ThemeUpdateBusiness() {
        setStartDownloadInterceptor();
    }

    public static boolean checkFileInZip(String str, String str2, String str3) throws IOException {
        QZipInputStream qZipInputStream = new QZipInputStream(new FileInputStream(str));
        while (true) {
            try {
                ZipEntry nextEntry = qZipInputStream.getNextEntry();
                if (nextEntry != null) {
                    if (nextEntry.getName().startsWith(str2) && nextEntry.getName().endsWith(str3)) {
                        qZipInputStream.close();
                        return true;
                    }
                } else {
                    qZipInputStream.close();
                    return false;
                }
            } catch (Throwable th5) {
                try {
                    qZipInputStream.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    private boolean checkIsInExcludeThemeIds(String str) {
        if (sExcludeThemeIds == null) {
            sExcludeThemeIds = new ArrayList<>();
            JSONArray optJSONArray = themeSupportNewScid.getJson().optJSONArray("exclude_themes");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    sExcludeThemeIds.add("" + optJSONArray.optInt(i3));
                }
            }
        }
        return sExcludeThemeIds.contains(str);
    }

    private boolean hasRawRes(String str) {
        String[] list;
        File file = new File(str + "raw");
        if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
            for (String str2 : list) {
                if (str2.endsWith("mp4")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasRawResFromZip(String str) {
        ThemeLocator themeLocator = new ThemeLocator();
        themeLocator.setThemeId(str);
        themeLocator.init(BaseApplication.context, SCID_THEME_ZIP_PREFIX + str, "");
        try {
            return checkFileInZip(themeLocator.getZipPath(), "raw", ".mp4");
        } catch (IOException e16) {
            QLog.i("VasUpdate_QQBusiness", 1, "hasRawRes themeId:" + str + " file check error!", e16);
            return false;
        }
    }

    public static boolean isSupportNewScid() {
        if (MobileQQ.sProcessId == 1) {
            return SUPPORT_NEW_SCID.booleanValue();
        }
        if (SUPPORT_NEW_SCID_TOOL == null) {
            SUPPORT_NEW_SCID_TOOL = Boolean.valueOf(VipMMKV.getCommon().decodeBool("vas_theme_support_new_scid", false));
        }
        return SUPPORT_NEW_SCID_TOOL.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryToDownloadVideoRes$0(String str, String str2, int i3, String str3, String str4) {
        if (TextUtils.isEmpty(str4)) {
            boolean hasRawResFromZip = hasRawResFromZip(str);
            QLog.e("VasUpdate_QQBusiness", 1, "tryToDownloadVideoRes fetch md5 is empty, hasRawResFromZip: " + hasRawResFromZip);
            if (!hasRawResFromZip) {
                startDownloadVideoRes(str, 3);
                return;
            }
            return;
        }
        ThemeLocator themeLocator = new ThemeLocator();
        themeLocator.setThemeId(str);
        themeLocator.init(BaseApplication.context, SCID_THEME_ZIP_PREFIX + str, str4);
        String unzipPath = themeLocator.getUnzipPath();
        if (!hasRawRes(unzipPath)) {
            if (ThemeUtil.isAnimateTheme(unzipPath)) {
                QLog.i("VasUpdate_QQBusiness", 1, "tryToDownloadVideoRes animateTheme");
                startDownloadVideoRes(str, 3);
                return;
            }
            boolean isSuperTheme = ThemeUtil.isSuperTheme(unzipPath);
            QLog.i("VasUpdate_QQBusiness", 1, "tryToDownloadVideoRes superTheme:" + isSuperTheme);
            if (isSuperTheme) {
                startDownloadVideoRes(str, 3);
                return;
            }
            return;
        }
        VasCommonReporter.newReport("theme_new_scid").setValue1(str2).setValue2("noRawRes").report();
        QLog.i("VasUpdate_QQBusiness", 1, "tryToDownloadVideoRes unzip dir: " + unzipPath + " hasRawRes: true");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$tryToDownloadVideoRes$1(final String str) {
        final String iDFromSCID = ThemeUtil.getIDFromSCID(str);
        if (checkIsInExcludeThemeIds(iDFromSCID)) {
            QLog.i("VasUpdate_QQBusiness", 1, "tryToDownloadVideoRes true, themeId: " + iDFromSCID);
            return;
        }
        QuickUpdateIPCModule.queryItemVersion(3, str, true, new QueryItemCallback() { // from class: com.tencent.mobileqq.vas.quickupdate.e
            @Override // com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback
            public final void onQueryItemVer(int i3, String str2, String str3) {
                ThemeUpdateBusiness.this.lambda$tryToDownloadVideoRes$0(iDFromSCID, str, i3, str2, str3);
            }
        });
    }

    private void onThemeComplete(String str, String str2, int i3, int i16) {
        if (MobileQQ.sProcessId == 1) {
            ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).onThemeComplete(str, "", str2, i3, i16);
        }
    }

    private void reportNewScid(@NonNull UpdateListenerParams updateListenerParams) {
        if (MobileQQ.sProcessId == 1) {
            boolean optBoolean = themeSupportNewScid.getJson().optBoolean("report_sample", false);
            p23.c.f424977a.c(VasCommonReporter.newReport("theme_new_scid"), updateListenerParams.mBusinessUpdateParams.mScid, Integer.valueOf(updateListenerParams.mErrorCode), Integer.valueOf(updateListenerParams.mHttpCode), updateListenerParams.mErrorMessage, isSupportNewScid(), optBoolean, this);
        }
    }

    public static void setStartDownloadInterceptor() {
        try {
            List<IVasUpdateManager.a> list = IVasUpdateManager.INTERCEPTOR_LIST;
            IVasUpdateManager.a aVar = downloadInterceptor;
            if (!list.contains(aVar)) {
                list.add(aVar);
            }
        } catch (Exception e16) {
            QLog.i("VasUpdate_QQBusiness", 1, "setStartDownloadInterceptor >> ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDownloadVideoRes(String str, int i3) {
        if (i3 == 0) {
            return;
        }
        String str2 = SCID_THEME_ZIP_PREFIX_VIDEO + str;
        addDownLoadListener(str2, new b(i3, str));
        startDownload(str2);
    }

    private void tryToDownloadVideoRes(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.quickupdate.d
            @Override // java.lang.Runnable
            public final void run() {
                ThemeUpdateBusiness.this.lambda$tryToDownloadVideoRes$1(str);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void addDownLoadListener(int i3, IDownLoadListener iDownLoadListener) {
        super.addDownLoadListener(i3, iDownLoadListener);
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 3L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return "theme";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    public BusinessItemInfo getBusinessItemInfo(long j3, String str) {
        String iDFromSCID = ThemeUtil.getIDFromSCID(str);
        if (!TextUtils.isEmpty(iDFromSCID)) {
            BusinessItemInfo businessItemInfo = super.getBusinessItemInfo(j3, str);
            ThemeLocator themeId = new ThemeLocator().setThemeId(iDFromSCID);
            businessItemInfo.mSaveInDir = false;
            businessItemInfo.mSavePath = themeId.init(BaseApplication.getContext(), str, "").getZipPath();
            return businessItemInfo;
        }
        return null;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return "theme";
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String getSavePath(String str) {
        return new ThemeLocator().setThemeId(ThemeUtil.getIDFromSCID(str)).init(BaseApplication.getContext(), str, "").getBasePath(BaseApplication.getContext());
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getScidPrefix() {
        return SCID_THEME_ZIP_PREFIX;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExist(String str) {
        String cfgPath;
        String iDFromSCID = ThemeUtil.getIDFromSCID(str);
        if (!TextUtils.isEmpty(iDFromSCID)) {
            ThemeLocator themeId = new ThemeLocator().setThemeId(iDFromSCID);
            if (str.startsWith(SCID_THEME_ZIP_PREFIX)) {
                cfgPath = themeId.init(BaseApplication.getContext(), str, "").getZipPath();
            } else {
                cfgPath = themeId.getCfgPath(BaseApplication.getContext());
            }
            return new File(cfgPath).exists();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExists(int i3) {
        return super.isFileExists(i3);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        reportNewScid(updateListenerParams);
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        onThemeComplete(businessUpdateParams.mScid, businessUpdateParams.mFrom, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode);
        super.onLoadFail(updateListenerParams);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
        boolean z16;
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        String str = businessUpdateParams.mScid;
        onThemeComplete(str, businessUpdateParams.mFrom, updateListenerParams.mErrorCode, updateListenerParams.mHttpCode);
        if (str.startsWith(SCID_THEME_ZIP_PREFIX) && !str.startsWith(SCID_THEME_ZIP_PREFIX_VIDEO)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (isSupportNewScid() && z16) {
            reportNewScid(updateListenerParams);
            tryToDownloadVideoRes(str);
        } else if (str.startsWith(SCID_THEME_ZIP_PREFIX_VIDEO)) {
            reportNewScid(updateListenerParams);
        }
        super.onLoadSuccess(updateListenerParams);
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onProgress(@NonNull UpdateListenerParams updateListenerParams) {
        if (MobileQQ.sProcessId == 1) {
            ((IVasQuickUpdateAdapter) QRoute.api(IVasQuickUpdateAdapter.class)).onThemeProgress(updateListenerParams.mBusinessUpdateParams.mScid, updateListenerParams.mProgress, updateListenerParams.mProgressMax);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void startDownload(int i3) {
        super.startDownload(i3);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness
    public void startDownload(String str) {
        super.startDownload(str);
        if (isSupportNewScid()) {
            p23.c.f424977a.e(str);
        }
    }
}
