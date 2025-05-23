package com.tencent.mobileqq.vas.font.api.impl;

import androidx.annotation.NonNull;
import com.etrump.mixlayout.ETEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.business.FontSoBusiness;
import com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener;
import com.tencent.mobileqq.vas.util.VasSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FontSoLoaderAdapterImpl implements IFontSoLoaderAdapter {
    private static final String TAG = "FontSoLoaderAdapterImpl";
    private static AtomicBoolean sIsVipFontSoLoaded = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements IDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AppRuntime f309131a;

        a(AppRuntime appRuntime) {
            this.f309131a = appRuntime;
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
            ((IFontManagerService) this.f309131a.getRuntimeService(IFontManagerService.class, "")).onSoDownloadCompleted(1, updateListenerParams.mErrorCode);
        }

        @Override // com.tencent.mobileqq.vas.updatesystem.callback.IDownLoadListener
        public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
            ((IFontManagerService) this.f309131a.getRuntimeService(IFontManagerService.class, "")).onSoDownloadCompleted(1, 0);
        }
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter
    public boolean isVipFontSoDownloaded() {
        boolean isEnable = VasNormalToggle.VAS_BUG_113136377.isEnable(true);
        if (!isEnable) {
            isEnable = VasMMKV.getFontSo(BaseApplication.getContext()).getBoolean("vip_font_so_downloaded", false);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "VipFontData in sp: vip_font_so_downloaded=" + isEnable);
            }
        }
        if (!isEnable) {
            return false;
        }
        return new File(VasSoUtils.getSoDir(1) + File.separator + FontSoBusiness.HY_FONT_SO_NAME).exists();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter
    public boolean isVipFontSoLoaded() {
        return sIsVipFontSoLoaded.get();
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter
    public boolean loadSo() {
        String str;
        if (BaseApplicationImpl.getApplication() == null) {
            return false;
        }
        int loadLibrary = VasSoUtils.loadLibrary(VasSoUtils.getSoDir(1), FontSoBusiness.HY_FONT_SO_NAME);
        if (loadLibrary != 0) {
            if (loadLibrary == 1) {
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime instanceof QQAppInterface) {
                    QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                    FontSoBusiness.instance.startDownloadSo(VasUpdateConstants.SCID_HYFONT_SO, new a(runtime));
                    NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(qQAppInterface.getAccount()), TAG);
                    if (vasSimpleInfoWithUid != null && 0 != vasSimpleInfoWithUid.uVipFont && vasSimpleInfoWithUid.vipFontType == 1) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    ReportController.o(qQAppInterface, "CliOper", "", "", "Font_Mall", "0X80072C8", 0, 0, "1", str, "", "");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "VipFontReport: early download start, restartDownload=true, type=" + str);
                    }
                    return false;
                }
            }
            return false;
        }
        ETEngine.isSOLoaded.set(true);
        sIsVipFontSoLoaded.set(true);
        VasMMKV.getFontSo(BaseApplication.getContext()).edit().putBoolean("vip_font_so_downloaded", true).commit();
        return true;
    }

    @Override // com.tencent.mobileqq.vas.font.api.IFontSoLoaderAdapter
    public void setVipFontSoLoad(boolean z16) {
        sIsVipFontSoLoaded.set(z16);
    }
}
