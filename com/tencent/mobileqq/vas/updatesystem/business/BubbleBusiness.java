package com.tencent.mobileqq.vas.updatesystem.business;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasNtCommonReporter;
import com.tencent.mobileqq.vas.api.IVasAioData;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.bubble.report.VasBubbleReporter;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.vas.update.entity.BusinessItemInfo;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BubbleBusiness extends QQVasUpdateBusiness {
    public static final String AIO_USER_BG_NOR = "aio_user_bg_nor.9.png";
    public static final String AIO_USER_BG_NOR_OLD = "aio_user_bg_nor@2x.png";
    public static final String AIO_USER_PIC_NOR = "aio_user_pic_nor.9.png";
    public static final String AIO_USER_PIC_NOR_OLD = "aio_user_pic_nor@2x.png";
    public static final long BID = 2;
    private static final String BUBBLE_UNREAD1 = "unread1.png";
    private static final String BUBBLE_UNREAD2 = "unread2.png";
    private static final String BUBBLE_UNREAD3 = "unread3.png";
    public static final String CONFIG_FILE_NAME = ".config.json";
    public static final String OTHER_FILE_PACK_NAME = ".other.zip";
    public static final String SCID_BUBBLE_PASTER_PREFIX = "bubble.paster.";
    public static final String SCID_BUBBLE_PREFIX = "bubble.android.";
    public static final String SHOOT_BUBBLE_CONFIG_NAME = "xa.json";
    public static final String STATIC_FILE_PACK_NAME = ".static.zip";
    protected static final String TAG = "bubble_dir";
    private static final String UNREAD_NAME = "unread";
    private static boolean sEnableMergeRequest = ar.b("shouyouye", "2024-08-06", "vas_bubble_get_url_merge").isEnable(false);
    private static boolean sEnableCompatibleOldFormat = ar.b("shouyouye", "2024-08-07", "vas_bubble_compatible_old_format").isEnable(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f311169a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IDownLoadListener f311170b;

        a(int i3, IDownLoadListener iDownLoadListener) {
            this.f311169a = i3;
            this.f311170b = iDownLoadListener;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311170b.onLoadFail(updateListenerParams);
            BubbleBusiness.this.reportErrorCase(updateListenerParams, this.f311169a);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            if (BubbleBusiness.this.isFileExists(this.f311169a)) {
                this.f311170b.onLoadSuccess(updateListenerParams);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDownLoadListener f311172a;

        b(IDownLoadListener iDownLoadListener) {
            this.f311172a = iDownLoadListener;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311172a.onLoadFail(updateListenerParams);
            VasBubbleReporter.INSTANCE.report(VasBubbleReporter.ERROR_FILE_DOWNLOAD.replace("{id}", updateListenerParams.mBusinessUpdateParams.mScid).replace("{errorCode}", String.valueOf(updateListenerParams.mErrorCode)).replace("{httpCode}", String.valueOf(updateListenerParams.mHttpCode)));
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311172a.onLoadSuccess(updateListenerParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportErrorCase(@NonNull final UpdateListenerParams updateListenerParams, final int i3) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness.2
            @Override // java.lang.Runnable
            public void run() {
                String replace = VasBubbleReporter.ERROR_FILE_DOWNLOAD.replace("{id}", updateListenerParams.mBusinessUpdateParams.mScid).replace("{errorCode}", String.valueOf(updateListenerParams.mErrorCode)).replace("{httpCode}", String.valueOf(updateListenerParams.mHttpCode));
                if (updateListenerParams.mErrorCode == 24) {
                    IVasAioData.VasAioMsgData aioVasMsgData = ((IVasAioData) QRoute.api(IVasAioData.class)).getAioVasMsgData(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
                    if (aioVasMsgData.getBubbleId() == i3 || aioVasMsgData.getSubBubbleId() == i3) {
                        VasBubbleReporter.INSTANCE.report(replace);
                        return;
                    }
                    return;
                }
                VasBubbleReporter.INSTANCE.report(replace);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ThreadManagerV2.excute(runnable, 16, null, false);
        } else {
            runnable.run();
        }
    }

    public void addDownLoadDIYListener(int i3, IDownLoadListener iDownLoadListener) {
        addDownLoadListener("bubble.paster." + i3 + ".png", new b(iDownLoadListener));
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void addDownLoadListener(int i3, IDownLoadListener iDownLoadListener) {
        a aVar = new a(i3, iDownLoadListener);
        addDownLoadListener("bubble.android." + i3 + STATIC_FILE_PACK_NAME, aVar);
        addDownLoadListener("bubble.android." + i3 + ".other.zip", aVar);
        addDownLoadListener("bubble.android." + i3 + CONFIG_FILE_NAME, aVar);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean checkFileAvailable(String str, int i3) {
        if (!str.endsWith(STATIC_FILE_PACK_NAME)) {
            return true;
        }
        if (sEnableCompatibleOldFormat) {
            if (checkFileAvailableSelf(str, i3, new String[]{AIO_USER_BG_NOR, AIO_USER_PIC_NOR}) || checkFileAvailableSelf(str, i3, new String[]{AIO_USER_BG_NOR_OLD, AIO_USER_PIC_NOR_OLD})) {
                return true;
            }
            return false;
        }
        return super.checkFileAvailable(str, i3);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean checkFileAvailableAndReport(int i3) {
        if (!isFileExists(i3)) {
            return false;
        }
        return checkFileAvailable("bubble.android." + i3 + STATIC_FILE_PACK_NAME, 1);
    }

    public boolean checkFileAvailableSelf(String str, int i3, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        try {
            List asList = Arrays.asList(new File(getSavePath(str, false)).list());
            for (String str2 : strArr) {
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

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        return 2L;
    }

    public String getBubbleAnimPath(int i3) {
        return getSavePath("bubble.android." + i3 + ".other.zip");
    }

    public String getBubbleDiyPath(String str) {
        return getSavePath("bubble.paster." + str + ".png");
    }

    public String getBubbleJsonPath(int i3) {
        return getSavePath("bubble.android." + i3 + CONFIG_FILE_NAME);
    }

    public String getBubbleShootJsonPath(int i3) {
        return getBubbleAnimPath(i3) + File.separator + SHOOT_BUBBLE_CONFIG_NAME;
    }

    public String getBubbleStaticPath(int i3) {
        return getSavePath("bubble.android." + i3 + STATIC_FILE_PACK_NAME);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.callback.listener.IBusinessCallback
    public BusinessItemInfo getBusinessItemInfo(long j3, String str) {
        BusinessItemInfo businessItemInfo = super.getBusinessItemInfo(j3, str);
        if (str.endsWith(CONFIG_FILE_NAME)) {
            businessItemInfo.mSaveInDir = false;
        } else if (str.startsWith("bubble.paster.")) {
            businessItemInfo.mSaveInDir = false;
        }
        return businessItemInfo;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public QQVasUpdateBusiness.CustomBusinessItemInfo getCustomItemInfo(long j3, String str) {
        QQVasUpdateBusiness.CustomBusinessItemInfo customBusinessItemInfo = new QQVasUpdateBusiness.CustomBusinessItemInfo();
        if (str.endsWith(CONFIG_FILE_NAME)) {
            customBusinessItemInfo.mSaveInDir = false;
        } else if (str.startsWith("bubble.paster.")) {
            customBusinessItemInfo.mSaveInDir = false;
        }
        return customBusinessItemInfo;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public long getDownloadFileSize(int i3) {
        return getDownloadFileSize("bubble.android." + i3 + STATIC_FILE_PACK_NAME) + getDownloadFileSize("bubble.android." + i3 + ".other.zip") + getDownloadFileSize("bubble.android." + i3 + CONFIG_FILE_NAME);
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public String[] getNecessaryFiles() {
        return new String[]{AIO_USER_BG_NOR, AIO_USER_PIC_NOR};
    }

    public String getUnreadPath(int i3, long j3) {
        String str;
        if (j3 < 10) {
            str = BUBBLE_UNREAD1;
        } else if (j3 < 100) {
            str = BUBBLE_UNREAD2;
        } else {
            str = BUBBLE_UNREAD3;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getSavePath("bubble.android." + i3 + ".other.zip"));
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(UNREAD_NAME);
        sb5.append(str2);
        sb5.append(str);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableFileClean() {
        return true;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isFileExists(int i3) {
        if (isFileExist("bubble.android." + i3 + STATIC_FILE_PACK_NAME)) {
            if (isFileExist("bubble.android." + i3 + ".other.zip")) {
                if (isFileExist("bubble.android." + i3 + CONFIG_FILE_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public void startDownload(int i3) {
        if (sEnableMergeRequest) {
            ArrayList arrayList = new ArrayList();
            BusinessUpdateParams businessUpdateParams = new BusinessUpdateParams(getBid(), "bubble.android." + i3 + STATIC_FILE_PACK_NAME, getFrom());
            BusinessUpdateParams businessUpdateParams2 = new BusinessUpdateParams(getBid(), "bubble.android." + i3 + ".other.zip", getFrom());
            BusinessUpdateParams businessUpdateParams3 = new BusinessUpdateParams(getBid(), "bubble.android." + i3 + CONFIG_FILE_NAME, getFrom());
            arrayList.add(businessUpdateParams);
            arrayList.add(businessUpdateParams2);
            arrayList.add(businessUpdateParams3);
            startDownload(arrayList);
            return;
        }
        startDownload("bubble.android." + i3 + STATIC_FILE_PACK_NAME);
        startDownload("bubble.android." + i3 + ".other.zip");
        startDownload("bubble.android." + i3 + CONFIG_FILE_NAME);
    }

    public void startDownloadDiyBubble(int i3) {
        startDownload("bubble.paster." + i3 + ".png");
    }
}
