package com.tencent.mobileqq.vas.updatesystem.business;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.report.VasFontReporter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.util.AbiUtil;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FontSoBusiness {
    public static final String FZ_COLOR_FONT_SO_NAME = "libFounderColorFontEngine.so";
    public static final String HY_FONT_SO_NAME = "libvipfont8953.so";
    public static final boolean IS_CPU_64_BIT;
    public static final String SCID_COLORFONT_SO;
    public static final String SCID_HYFONT_SO;
    public static final String TAG = "font_so_info";
    public static final FontSoBusiness instance;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDownLoadListener f311179a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f311180b;

        a(IDownLoadListener iDownLoadListener, String str) {
            this.f311179a = iDownLoadListener;
            this.f311180b = str;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311179a.onLoadFail(updateListenerParams);
            VasFontReporter.INSTANCE.report(VasFontReporter.ERROR_FILE_DOWNLOAD.replace("{id}", this.f311180b).replace("{errorCode}", String.valueOf(updateListenerParams.mErrorCode)).replace("{httpCode}", String.valueOf(updateListenerParams.mHttpCode)));
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            this.f311179a.onLoadSuccess(updateListenerParams);
        }
    }

    static {
        String str;
        String str2;
        boolean isArm64Runtime = AbiUtil.isArm64Runtime(MobileQQ.sMobileQQ);
        IS_CPU_64_BIT = isArm64Runtime;
        if (isArm64Runtime) {
            str = "libColorFont_818_64";
        } else {
            str = "libColorFont_818";
        }
        SCID_COLORFONT_SO = str;
        if (isArm64Runtime) {
            str2 = "libVipFont_8417_64";
        } else {
            str2 = "libVipFont_8417";
        }
        SCID_HYFONT_SO = str2;
        instance = new FontSoBusiness();
    }

    public String getFontSoSavePath(String str) {
        ZipDownloadBusiness zipDownloadBusiness = (ZipDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ZipDownloadBusiness.class);
        if (SCID_HYFONT_SO.equals(str)) {
            return zipDownloadBusiness.getSavePath(ZipDownloadBusiness.ID_HY_FONT_SO);
        }
        if (SCID_COLORFONT_SO.equals(str)) {
            return zipDownloadBusiness.getSavePath(ZipDownloadBusiness.ID_FZ_FONT_SO);
        }
        return "";
    }

    public String getSoPath(String str) {
        if (SCID_HYFONT_SO.equals(str)) {
            return getFontSoSavePath(str) + File.separator + HY_FONT_SO_NAME;
        }
        if (SCID_COLORFONT_SO.equals(str)) {
            return getFontSoSavePath(str) + File.separator + FZ_COLOR_FONT_SO_NAME;
        }
        return "";
    }

    public void startDownloadSo(String str, IDownLoadListener iDownLoadListener) {
        a aVar;
        if (iDownLoadListener != null) {
            aVar = new a(iDownLoadListener, str);
        } else {
            aVar = null;
        }
        ZipDownloadBusiness zipDownloadBusiness = (ZipDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ZipDownloadBusiness.class);
        if (SCID_HYFONT_SO.equals(str)) {
            if (aVar != null) {
                zipDownloadBusiness.addDownLoadListener(ZipDownloadBusiness.ID_HY_FONT_SO, aVar);
            }
            zipDownloadBusiness.startDownload(ZipDownloadBusiness.ID_HY_FONT_SO);
        } else if (SCID_COLORFONT_SO.equals(str)) {
            if (aVar != null) {
                zipDownloadBusiness.addDownLoadListener(ZipDownloadBusiness.ID_FZ_FONT_SO, aVar);
            }
            zipDownloadBusiness.startDownload(ZipDownloadBusiness.ID_FZ_FONT_SO);
        }
    }
}
