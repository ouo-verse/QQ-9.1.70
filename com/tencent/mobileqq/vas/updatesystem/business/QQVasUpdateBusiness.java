package com.tencent.mobileqq.vas.updatesystem.business;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.VasTempConstant;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateBridge;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.updatesystem.callback.RemoteVasUpdateListener;
import com.tencent.mobileqq.vas.updatesystem.entity.VasUpdateParcelableParams;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class QQVasUpdateBusiness<T extends BaseUpdateBusiness> extends BaseUpdateBusiness {
    public static final long ERROR_BID = 1000000;
    protected static final String TAG = "VasUpdate_QQBusiness";
    private static final boolean fileExistsFeature;
    private IUpdateListener mUpdateListener;
    private static final boolean enableRemoveSame = VasNtToggle.VAS_DOWNLOAD_REMOVE_SAME_SWITCH_NEW.isEnable(true);
    private static final boolean enableToolDownloading = VasNtToggle.VAS_DOWNLOADING_TIME_SWITCH.isEnable(true);
    protected static final boolean fixBugs122584537 = ar.b("shouyouye", "2024-04-30", "vas_bug_122584537").isEnable(true);
    private static final boolean enableRemoveSameMergeReq = ar.b("shouyouye", "2024-08-07", "vas_vas_download_remove_same_switch_merge").isEnable(true);
    private static final boolean removeFunCheckFileAvailable = ar.b("shouyouye", "2024-08-08", "vas_remove_fun_check_file_available").isEnable(true);
    private static final String VAS_ROOT_DIR = VasTempConstant.INTERNAL_VAS_MATERIAL_FOLDER_DIR;
    protected ConcurrentHashMap<String, Long> downloadingStatus = new ConcurrentHashMap<>();
    protected CopyOnWriteArrayList<String> downloadedStatus = new CopyOnWriteArrayList<>();
    protected ConcurrentHashMap<String, Long> downloadLimits = new ConcurrentHashMap<>();
    protected final ArrayList<String> readScidHistory = new ArrayList<>();
    private Object mLock = new Object();
    private Map<String, List<IDownLoadListener>> listenerMap = new HashMap();
    private RemoteVasUpdateListener mRemoteVasUpdateListener = new b();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class CustomBusinessItemInfo {
        public boolean mIsCanUpdate = true;
        public String mSavePath = "";
        public boolean mSaveInDir = true;
        public boolean ignoreUncompressMode = false;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b extends RemoteVasUpdateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.RemoteVasUpdateListener, com.tencent.mobileqq.vas.updatesystem.callback.IRemoteVasUpdateListener
        public void onLoadFail(VasUpdateParcelableParams vasUpdateParcelableParams) {
            if (QQVasUpdateBusiness.this.mUpdateListener != null) {
                QQVasUpdateBusiness.this.mUpdateListener.onLoadFail(VasCommonUtils.INSTANCE.convertToBusinessParams(vasUpdateParcelableParams));
            }
            QQVasUpdateBusiness.this.onLoadFail(VasCommonUtils.INSTANCE.convertToBusinessParams(vasUpdateParcelableParams));
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.RemoteVasUpdateListener, com.tencent.mobileqq.vas.updatesystem.callback.IRemoteVasUpdateListener
        public void onLoadSuccess(VasUpdateParcelableParams vasUpdateParcelableParams) {
            if (QQVasUpdateBusiness.this.mUpdateListener != null) {
                QQVasUpdateBusiness.this.mUpdateListener.onLoadSuccess(VasCommonUtils.INSTANCE.convertToBusinessParams(vasUpdateParcelableParams));
            }
            QQVasUpdateBusiness.this.onLoadSuccess(VasCommonUtils.INSTANCE.convertToBusinessParams(vasUpdateParcelableParams));
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.RemoteVasUpdateListener, com.tencent.mobileqq.vas.updatesystem.callback.IRemoteVasUpdateListener
        public void onProgress(VasUpdateParcelableParams vasUpdateParcelableParams) {
            if (QQVasUpdateBusiness.this.mUpdateListener != null) {
                QQVasUpdateBusiness.this.mUpdateListener.onProgress(VasCommonUtils.INSTANCE.convertToBusinessParams(vasUpdateParcelableParams));
            }
            QQVasUpdateBusiness.this.onProgress(VasCommonUtils.INSTANCE.convertToBusinessParams(vasUpdateParcelableParams));
        }
    }

    static {
        qw4.a.f430257a = VasNtToggle.VAS_UPDATE_CAN_CALLBACK_FILTER_TASK.isEnable(true);
        qw4.a.f430258b = VasNtToggle.VAS_UPDATE_USE_MMKV_REPLACE_FILE.isEnable(true);
        qw4.a.f430260d = VasNtToggle.VAS_NEED_DELETE_UPDATE_TASK_10_COUNT_FAIL.isEnable(false);
        qw4.a.f430261e = ar.b("shouyouye", "2024-03-13", "vas_is_delete_old_dir_when_un_zip").isEnable(true);
        qw4.a.f430262f = ar.b("shouyouye", "2024-05-29", "vas_update_system_is_update_from").isEnable(true);
        fileExistsFeature = VasNtToggle.UPDATE_BUSINESS_EXIST.isEnable(true);
    }

    public static <X extends QQVasUpdateBusiness> X getBusiness(Class<X> cls) {
        return (X) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(cls);
    }

    public static String getVasRootDir() {
        String str = VAS_ROOT_DIR;
        if (str == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("files");
            sb5.append(str2);
            sb5.append("vas_material_folder/");
            return sb5.toString();
        }
        return str;
    }

    public static boolean isEnableFileCheck(long j3) {
        UnitedProxy unitedProxy = VasNtToggle.VAS_UPDATE_BUSINESS_MIGRATION;
        if (!unitedProxy.isEnable(false)) {
            return false;
        }
        for (String str : unitedProxy.getJson().optString("file_check_black", "").split(",")) {
            if (str.equals("" + j3)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNeedDownload(String str) {
        Long l3 = this.downloadLimits.get(str);
        if (l3 == null || l3.longValue() < SystemClock.uptimeMillis()) {
            return true;
        }
        return false;
    }

    public static Boolean isUseUpdateBusinessMigration(long j3) {
        UnitedProxy unitedProxy = VasNtToggle.VAS_UPDATE_BUSINESS_MIGRATION;
        if (!unitedProxy.isEnable(true)) {
            return Boolean.FALSE;
        }
        for (String str : unitedProxy.getJson().optString("black", "").split(",")) {
            if (str.equals("" + j3)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$0(BusinessUpdateParams businessUpdateParams) {
        if (enableRemoveSame && !isNeedDownload(businessUpdateParams.mScid)) {
            if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                VasLogNtReporter.getFrequency().reportLow("scid " + businessUpdateParams.mScid + " remove same download");
                return;
            }
            return;
        }
        this.downloadLimits.put(businessUpdateParams.mScid, Long.valueOf(SystemClock.uptimeMillis() + 5000));
        super.startDownload(businessUpdateParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDownload$2(List list) {
        startRemoteDownload((List<BusinessUpdateParams>) list);
    }

    private void onLoadCall(UpdateListenerParams updateListenerParams, boolean z16) {
        String str = updateListenerParams.mBusinessUpdateParams.mScid;
        synchronized (this.mLock) {
            List<IDownLoadListener> remove = this.listenerMap.remove(str);
            if (remove != null) {
                for (IDownLoadListener iDownLoadListener : remove) {
                    if (z16) {
                        iDownLoadListener.onLoadSuccess(updateListenerParams);
                    } else {
                        iDownLoadListener.onLoadFail(updateListenerParams);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startRemoteDownload, reason: merged with bridge method [inline-methods] */
    public void lambda$startDownload$1(String str) {
        if (enableToolDownloading) {
            this.downloadingStatus.put(str, Long.valueOf(SystemClock.uptimeMillis() + 5000));
        }
        ((IVasUpdateBridge) QRoute.api(IVasUpdateBridge.class)).startRemoteDownload(getClass(), str, getFrom(), this.mRemoteVasUpdateListener);
    }

    public void addDownLoadListener(String str, IDownLoadListener iDownLoadListener) {
        synchronized (this.mLock) {
            List<IDownLoadListener> list = this.listenerMap.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.listenerMap.put(str, list);
            }
            list.add(iDownLoadListener);
        }
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness
    public void addUpdateListener(IUpdateListener iUpdateListener) {
        super.addUpdateListener(iUpdateListener);
        this.mUpdateListener = iUpdateListener;
    }

    public boolean checkFileAvailable(String str) {
        return checkFileAvailable(str, 1);
    }

    public boolean checkFileAvailableAndReport(int i3) {
        if (!isFileExists(i3)) {
            return false;
        }
        return checkFileAvailable(getScid(i3), 1);
    }

    protected abstract String getBusinessDir();

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public BusinessItemInfo getBusinessItemInfo(long j3, String str) {
        CustomBusinessItemInfo customBusinessItemInfo;
        String str2;
        BusinessItemInfo businessItemInfo = new BusinessItemInfo();
        if (VasNtToggle.VAS_UPDATE_BUSINESS_INFO_OPTIMIZE.isEnable(true)) {
            customBusinessItemInfo = getCustomItemInfo(j3, str);
        } else {
            customBusinessItemInfo = null;
        }
        if (customBusinessItemInfo == null) {
            businessItemInfo.mSaveInDir = true;
            businessItemInfo.mSavePath = getSavePath(str, false);
        } else {
            businessItemInfo.mIsCanUpdate = customBusinessItemInfo.mIsCanUpdate;
            businessItemInfo.ignoreUncompressMode = customBusinessItemInfo.ignoreUncompressMode;
            businessItemInfo.mSaveInDir = customBusinessItemInfo.mSaveInDir;
            if (TextUtils.isEmpty(customBusinessItemInfo.mSavePath)) {
                str2 = getSavePath(str, false);
            } else {
                str2 = customBusinessItemInfo.mSavePath;
            }
            businessItemInfo.mSavePath = str2;
        }
        if (VasNtToggle.UPDATE_SYSTEM_CHECK_MD5.isEnable(true)) {
            businessItemInfo.checkFileMd5 = true;
        }
        return businessItemInfo;
    }

    public CustomBusinessItemInfo getCustomItemInfo(long j3, String str) {
        CustomBusinessItemInfo customBusinessItemInfo = new CustomBusinessItemInfo();
        customBusinessItemInfo.mIsCanUpdate = true;
        customBusinessItemInfo.mSaveInDir = true;
        customBusinessItemInfo.mSavePath = getSavePath(str, false);
        return customBusinessItemInfo;
    }

    public long getDownloadFileSize(int i3) {
        return getDownloadFileSize(getScid(i3));
    }

    @Deprecated
    public String getFrequencyId(String str) {
        return "";
    }

    public String[] getNecessaryFiles() {
        return null;
    }

    public ArrayList<String> getReadHistory() {
        ArrayList<String> arrayList;
        synchronized (this.readScidHistory) {
            arrayList = new ArrayList<>(this.readScidHistory.size());
            for (int i3 = 0; i3 < this.readScidHistory.size(); i3++) {
                arrayList.add(getSavePath(this.readScidHistory.get(i3), false));
            }
            arrayList.remove(getSavePath("", false));
        }
        return arrayList;
    }

    public String getSavePath(String str) {
        return getSavePath(str, true);
    }

    public String getScid(int i3) {
        return getScidPrefix() + i3;
    }

    protected String getScidPrefix() {
        return "";
    }

    public boolean isDownloadingOrUnpacking(String str) {
        Long l3;
        boolean z16 = false;
        if (this.downloadedStatus.contains(str) || (l3 = this.downloadingStatus.get(str)) == null) {
            return false;
        }
        if (l3.longValue() > SystemClock.uptimeMillis()) {
            z16 = true;
        }
        if (!z16 && com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            VasLogNtReporter.getFrequency().reportLow("scid " + str + " downloading");
        }
        return z16;
    }

    public boolean isEnableCheckFile() {
        return false;
    }

    public boolean isEnableFileClean() {
        return false;
    }

    public boolean isFileExist(String str) {
        BusinessItemInfo businessItemInfo;
        if (isDownloadingOrUnpacking(str)) {
            return false;
        }
        if (fileExistsFeature) {
            businessItemInfo = getBusinessItemInfo(getBid(), str);
        } else {
            businessItemInfo = new BusinessItemInfo();
            businessItemInfo.mSavePath = getSavePath(str, false);
        }
        boolean isFileExist = isFileExist(null, businessItemInfo);
        if (removeFunCheckFileAvailable) {
            return isFileExist;
        }
        if (!isFileExist) {
            return false;
        }
        return checkFileAvailable(str);
    }

    public boolean isFileExists(int i3) {
        if (fileExistsFeature) {
            return isFileExist(getScid(i3));
        }
        if (isDownloadingOrUnpacking(getScid(i3)) || !new File(getSavePath(i3)).exists()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        onLoadCall(updateListenerParams, false);
        super.onLoadFail(updateListenerParams);
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
        if (fixBugs122584537) {
            if (!this.downloadedStatus.contains(updateListenerParams.mBusinessUpdateParams.mScid)) {
                this.downloadedStatus.add(updateListenerParams.mBusinessUpdateParams.mScid);
            }
        } else {
            this.downloadedStatus.add(updateListenerParams.mBusinessUpdateParams.mScid);
        }
        onLoadCall(updateListenerParams, true);
        super.onLoadSuccess(updateListenerParams);
    }

    public void startDownload(int i3) {
        startDownload(getScid(i3));
    }

    public static QQVasUpdateBusiness getBusiness(long j3) {
        return ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(Long.valueOf(j3));
    }

    public boolean checkFileAvailable(String str, int i3) {
        String[] necessaryFiles = getNecessaryFiles();
        if (necessaryFiles == null || necessaryFiles.length == 0) {
            return true;
        }
        try {
            List asList = Arrays.asList(new File(getSavePath(str, false)).list());
            for (String str2 : necessaryFiles) {
                if (!asList.contains(str2)) {
                    String str3 = getBid() + "_" + str;
                    if (i3 == 1) {
                        VasNtCommonReporter.getFileAvailableCheck().setValue2(str3).setNum1(i3).reportEveryDay(str3);
                    } else {
                        VasNtCommonReporter.getFileAvailableCheck2().setValue2(str3).setNum1(i3).reportEveryDay(str3);
                    }
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public long getDownloadFileSize(String str) {
        String str2;
        BusinessItemInfo businessItemInfo = getBusinessItemInfo(getBid(), str);
        if (businessItemInfo.mSaveInDir) {
            str2 = businessItemInfo.mSavePath + "/" + getBid() + "_" + str + ".sge";
        } else {
            str2 = businessItemInfo.mSavePath;
        }
        File file = new File(str2);
        if (file.exists() && file.isFile()) {
            return file.length();
        }
        return 0L;
    }

    public String getSavePath(int i3) {
        return getSavePath(getScid(i3));
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness
    public final void startDownload(final BusinessUpdateParams businessUpdateParams) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.business.c
            @Override // java.lang.Runnable
            public final void run() {
                QQVasUpdateBusiness.this.lambda$startDownload$0(businessUpdateParams);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getSavePath(String str, boolean z16) {
        if (z16 && isEnableFileClean()) {
            synchronized (this.readScidHistory) {
                if (!this.readScidHistory.contains(str)) {
                    this.readScidHistory.add(str);
                }
            }
        }
        return new File(getVasRootDir() + getBusinessDir(), str).getAbsolutePath();
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness
    public void startDownload(final String str) {
        if (!VasCommonUtils.INSTANCE.isMainProcess()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread() && VasNtToggle.VAS_UPDATE_TOOL_START_DOWNLOAD_THREAD.isEnable(true)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.business.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQVasUpdateBusiness.this.lambda$startDownload$1(str);
                    }
                }, 16, null, false);
                return;
            } else {
                lambda$startDownload$1(str);
                return;
            }
        }
        if (VasUpdateWrapper.getLog() == null) {
            QLog.e(TAG, 1, "update system hasn't init");
        } else {
            this.downloadingStatus.put(str, Long.valueOf(SystemClock.uptimeMillis() + 5000));
            super.startDownload(str);
        }
    }

    private void startRemoteDownload(List<BusinessUpdateParams> list) {
        if (enableToolDownloading) {
            Iterator<BusinessUpdateParams> it = list.iterator();
            while (it.hasNext()) {
                this.downloadingStatus.put(it.next().mScid, Long.valueOf(SystemClock.uptimeMillis() + 5000));
            }
        }
        ((IVasUpdateBridge) QRoute.api(IVasUpdateBridge.class)).startRemoteDownload(getClass(), list, getFrom(), this.mRemoteVasUpdateListener);
    }

    public void addDownLoadListener(int i3, IDownLoadListener iDownLoadListener) {
        addDownLoadListener(getScid(i3), iDownLoadListener);
    }

    public void addDownLoadListener(int i3, Runnable runnable) {
        addDownLoadListener(getScid(i3), runnable);
    }

    public void addDownLoadListener(String str, Runnable runnable) {
        addDownLoadListener(str, new a(runnable));
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness
    public void startDownload(final List<BusinessUpdateParams> list) {
        if (!VasCommonUtils.INSTANCE.isMainProcess()) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread() && VasNtToggle.VAS_UPDATE_TOOL_START_DOWNLOAD_THREAD.isEnable(true)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.business.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQVasUpdateBusiness.this.lambda$startDownload$2(list);
                    }
                }, 16, null, false);
                return;
            } else {
                startRemoteDownload(list);
                return;
            }
        }
        if (VasUpdateWrapper.getLog() == null) {
            QLog.e(TAG, 1, "update system hasn't init");
            return;
        }
        Iterator<BusinessUpdateParams> it = list.iterator();
        while (it.hasNext()) {
            this.downloadingStatus.put(it.next().mScid, Long.valueOf(SystemClock.uptimeMillis() + 5000));
        }
        if (enableRemoveSameMergeReq) {
            ArrayList arrayList = new ArrayList();
            for (BusinessUpdateParams businessUpdateParams : list) {
                if (!isNeedDownload(businessUpdateParams.mScid)) {
                    if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
                        VasLogNtReporter.getFrequency().reportLow("scid " + businessUpdateParams.mScid + " remove same download");
                    }
                    arrayList.add(businessUpdateParams);
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
            Iterator<BusinessUpdateParams> it5 = list.iterator();
            while (it5.hasNext()) {
                this.downloadLimits.put(it5.next().mScid, Long.valueOf(SystemClock.uptimeMillis() + 5000));
            }
        }
        super.startDownload(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f311182a;

        a(Runnable runnable) {
            this.f311182a = runnable;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311182a.run();
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        }
    }
}
