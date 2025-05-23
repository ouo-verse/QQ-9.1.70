package com.tencent.mobileqq.ocr.api.impl;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.api.IOCRService;
import com.tencent.mobileqq.ocr.c;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.ocr.data.b;
import com.tencent.mobileqq.ocr.e;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.bw;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsGROUPMASK;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OCRServiceImpl implements IOCRService {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_MMKV_MIGRATE_FLAG = "_migrate_flag_";
    public static final int MAX_SOUGOU_SEARCHKEY_LENGTH = 300;
    private static final String PREF_AIO_SUPPORT = "is_aio_support";
    private static final String PREF_AIO_TEXT = "ocr_aio_text";
    private static final String PREF_CHAT_FILE_SUPPORT = "is_chat_file_support";
    private static final String PREF_QUESTION_RESULT_ENTER = "question_result_enter";
    private static final String PREF_QUESTION_SCAN_ENTER = "question_scan_enter";
    private static final String PREF_QZONE_SUPPORT = "is_qzone_support";
    private static final String PREF_SCAN_SUPPORT = "is_scan_support";
    private static final String SP_OCR = "ocr";
    private static final String TAG = "Q.ocr.OCRServiceImpl";
    private Object lock;
    public AppInterface mApp;
    EntityManager mEntityManager;
    public OcrConfig mOcrConfig;
    c ocrObserver;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OCRServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.ocr.c
        public void a(boolean z16, String str, List<OCRTextSearchInfo.SougouSearchInfo> list) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, list);
                return;
            }
            OCRTextSearchInfo.c constructTextRearchResult = OCRServiceImpl.this.constructTextRearchResult(list);
            AppInterface appInterface = OCRServiceImpl.this.mApp;
            if (appInterface == null) {
                return;
            }
            OCRHandler oCRHandler = (OCRHandler) appInterface.getBusinessHandler(OCRHandler.f254678e);
            Object[] objArr = new Object[3];
            if (z16) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = str;
            objArr[2] = constructTextRearchResult;
            oCRHandler.notifyUI(3, z16, objArr);
        }
    }

    public OCRServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mApp = null;
        this.ocrObserver = new a();
        this.lock = new Object();
    }

    public static SharedPreferences getOcrSp(String str) {
        String str2 = str + SP_OCR;
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), str2, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(BaseApplication.getContext(), str2, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    public static boolean isSupportQuestionResultEnter(String str) {
        boolean z16 = getOcrSp(str).getBoolean(PREF_QUESTION_RESULT_ENTER, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSupportQuestionResultEnter:" + z16);
        }
        return z16;
    }

    public static boolean isSupportQuestionScanEnter(String str) {
        boolean z16 = getOcrSp(str).getBoolean(PREF_QUESTION_SCAN_ENTER, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSupportQuestionScanEnter:" + z16);
        }
        return z16;
    }

    public static void updateConfigToSp(String str, OcrConfig ocrConfig) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        SharedPreferences.Editor edit = getOcrSp(str).edit();
        boolean z27 = false;
        if (ocrConfig == null) {
            edit.putBoolean(PREF_AIO_SUPPORT, false);
            edit.putBoolean(PREF_CHAT_FILE_SUPPORT, false);
            edit.putBoolean(PREF_QZONE_SUPPORT, false);
            edit.putBoolean(PREF_SCAN_SUPPORT, false);
            edit.putBoolean(PREF_QUESTION_RESULT_ENTER, false);
            edit.putBoolean(PREF_QUESTION_SCAN_ENTER, false);
            edit.putString(PREF_AIO_TEXT, "");
        } else {
            if (ocrConfig.aioOcrOpen == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            edit.putBoolean(PREF_AIO_SUPPORT, z16);
            if (ocrConfig.chatFileOcrOpen == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            edit.putBoolean(PREF_CHAT_FILE_SUPPORT, z17);
            if (ocrConfig.qzoneOcrOpen == 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            edit.putBoolean(PREF_QZONE_SUPPORT, z18);
            if (ocrConfig.scanOcrOpen == 1) {
                z19 = true;
            } else {
                z19 = false;
            }
            edit.putBoolean(PREF_SCAN_SUPPORT, z19);
            if (!TextUtils.isEmpty(ocrConfig.iconText)) {
                edit.putString(PREF_AIO_TEXT, ocrConfig.aioText);
            }
            if (ocrConfig.questionResultOpen == 1) {
                z26 = true;
            } else {
                z26 = false;
            }
            edit.putBoolean(PREF_QUESTION_RESULT_ENTER, z26);
            if (ocrConfig.questionScanOpen == 1) {
                z27 = true;
            }
            edit.putBoolean(PREF_QUESTION_SCAN_ENTER, z27);
        }
        edit.commit();
    }

    public OCRTextSearchInfo.c constructTextRearchResult(List<OCRTextSearchInfo.SougouSearchInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (OCRTextSearchInfo.c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
        OCRTextSearchInfo.c cVar = new OCRTextSearchInfo.c();
        if (list != null && !list.isEmpty()) {
            cVar.f254553a = new ArrayList();
            OCRTextSearchInfo.a aVar = new OCRTextSearchInfo.a();
            aVar.f254548b = UfsGROUPMASK.GROUP_MASK_KANDIAN;
            aVar.f254547a = HardCodeUtil.qqStr(R.string.oxq);
            for (OCRTextSearchInfo.SougouSearchInfo sougouSearchInfo : list) {
                OCRTextSearchInfo.b bVar = new OCRTextSearchInfo.b();
                bVar.f254552a = sougouSearchInfo;
                aVar.f254551e.add(bVar);
            }
            cVar.f254553a.add(aVar);
        }
        return cVar;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public void doSougouSearch(String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Long.valueOf(j3));
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            AppInterface appInterface = this.mApp;
            if (appInterface == null) {
                return;
            }
            ((OCRHandler) appInterface.getBusinessHandler(OCRHandler.f254678e)).notifyUI(3, false, new Object[]{-2, str, null});
            return;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            if (str2.length() > 300) {
                str2 = str2.substring(0, 300);
            }
            AppInterface appInterface2 = this.mApp;
            if (appInterface2 != null) {
                ((OCRHandler) appInterface2.getBusinessHandler(OCRHandler.f254678e)).F2(str, str2, j3);
            }
        }
    }

    public OcrRecogResult findCache(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (OcrRecogResult) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        }
        OcrRecogResult find = OcrRecogResult.find(this.mEntityManager, str);
        if (find == null) {
            return null;
        }
        if (new File(str).lastModified() > find.saveTime) {
            OcrRecogResult.remove(this.mEntityManager, str);
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "findCache " + find);
        }
        return find;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public String generateTextSearchSessionID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return bw.a() + "_" + SystemClock.uptimeMillis();
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public String getAIOText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        String string = getOcrSp(str).getString(PREF_AIO_TEXT, "");
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_OCR, 2, "getAIOText " + string);
        }
        return string;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public int getConfigVersion() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        OcrConfig oCRConfig = getOCRConfig(true);
        if (oCRConfig == null) {
            i3 = 0;
        } else {
            i3 = oCRConfig.version;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getConfigVersion:" + i3);
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public OcrConfig getOCRConfig(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (OcrConfig) iPatchRedirector.redirect((short) 14, (Object) this, z16);
        }
        if (this.mOcrConfig == null && z16) {
            loadConfigFromFile();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getOCRConfig:" + this.mOcrConfig);
            }
        }
        return this.mOcrConfig;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public boolean isQZoneSupportOcr(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return isSupportOcr(str, 2);
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public boolean isSupportOcr(String str, int i3) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        SharedPreferences ocrSp = getOcrSp(str);
        if (i3 == 1) {
            z16 = ocrSp.getBoolean(PREF_AIO_SUPPORT, false);
        } else if (i3 == 2) {
            z16 = ocrSp.getBoolean(PREF_QZONE_SUPPORT, false);
        } else if (i3 == 0) {
            z16 = ocrSp.getBoolean(PREF_SCAN_SUPPORT, false);
        } else if (i3 == 7) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (b.a().f254746b == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_OCR, 2, "isSupportOcr, uin:" + str + "form:" + i3 + ",isSupport:" + z16 + ",dpcSwitch:" + z17 + ",sdcard:" + e.f254758d);
        }
        if (!z16 || !z17 || !e.f254758d) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public boolean isSupportOcrAutoTranslate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_pic_preview_ocr_auto_translate_switch", false);
        QLog.i(TAG, 4, "isSupportOcrAutoTranslate: " + isSwitchOn);
        return isSwitchOn;
    }

    public void loadConfigFromFile() {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        synchronized (this.lock) {
            if (this.mOcrConfig == null && (appInterface = this.mApp) != null) {
                this.mOcrConfig = OcrConfig.readFromFile(appInterface.getCurrentAccountUin());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "loadConfigFromFile,mOcrConfig =   " + this.mOcrConfig);
                }
                if (this.mOcrConfig != null) {
                    updateConfigToSp(this.mApp.getCurrentAccountUin(), this.mOcrConfig);
                }
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) appRuntime);
            return;
        }
        if (appRuntime instanceof AppInterface) {
            AppInterface appInterface = (AppInterface) appRuntime;
            this.mApp = appInterface;
            appInterface.addDefaultObservers(this.ocrObserver);
            this.mEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.ocr.api.impl.OCRServiceImpl.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) OCRServiceImpl.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        OCRServiceImpl.this.loadConfigFromFile();
                    }
                }
            }, 5, null, false);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.removeObserver(this.ocrObserver);
        }
        this.mOcrConfig = null;
    }

    @Override // com.tencent.mobileqq.ocr.api.IOCRService
    public synchronized void onGetOCRConfig(boolean z16, OcrConfig ocrConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), ocrConfig);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGetOCRConfig, isSucc=" + z16 + ", config = " + ocrConfig);
        }
        if (z16) {
            synchronized (this.lock) {
                this.mOcrConfig = ocrConfig;
                AppInterface appInterface = this.mApp;
                if (appInterface != null) {
                    updateConfigToSp(appInterface.getCurrentAccountUin(), this.mOcrConfig);
                }
            }
        }
        ThreadManagerV2.post(new Runnable(z16) { // from class: com.tencent.mobileqq.ocr.api.impl.OCRServiceImpl.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f254689d;

            {
                this.f254689d = z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, OCRServiceImpl.this, Boolean.valueOf(z16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                AppInterface appInterface2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(OCRServiceImpl.TAG, 2, "onGetOCRConfig ,excute runnable");
                }
                if (this.f254689d) {
                    OCRServiceImpl oCRServiceImpl = OCRServiceImpl.this;
                    if (oCRServiceImpl.mOcrConfig != null) {
                        synchronized (oCRServiceImpl.lock) {
                            OCRServiceImpl oCRServiceImpl2 = OCRServiceImpl.this;
                            OcrConfig ocrConfig2 = oCRServiceImpl2.mOcrConfig;
                            if (ocrConfig2 != null && (appInterface2 = oCRServiceImpl2.mApp) != null) {
                                ocrConfig2.saveToFile(appInterface2.getCurrentAccountUin());
                            }
                        }
                    }
                }
            }
        }, 8, null, false);
    }

    public void updateCache(OcrRecogResult ocrRecogResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) ocrRecogResult);
            return;
        }
        if (ocrRecogResult != null && !TextUtils.isEmpty(ocrRecogResult.filename)) {
            ocrRecogResult.saveTime = System.currentTimeMillis();
            OcrRecogResult.persistOrReplace(this.mEntityManager, ocrRecogResult);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateCache " + ocrRecogResult.filename);
            }
        }
    }
}
