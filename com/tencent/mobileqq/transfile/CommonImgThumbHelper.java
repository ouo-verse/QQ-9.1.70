package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.inject.p;
import com.tencent.mobileqq.injector.aa;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class CommonImgThumbHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CommonImgThumbHelper";
    private static CommonImgThumbHelper mInstance;
    private static ArrayList mQQDpc_AutoGenClazzList_QAutoInjectTransform;
    private static int sImageDynamicMax;
    private static int sImageDynamicMin;
    private static int sImageMaxSize;
    private static int sImageMinSize;
    public static int sImageMinSizeForFileWidthAddedValue;
    private static boolean sSizeInited;
    private static int sThumbnailDynamicMax;
    private static int sThumbnailDynamicMin;
    private static int sThumbnailMax;
    private static int sThumbnailMin;

    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_QQDpc.yml", version = 1)
    p mQQDpc;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        mQQDpc_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(aa.class);
        sImageMinSizeForFileWidthAddedValue = 30;
        sImageMinSize = 45;
        sImageMaxSize = 135;
        sImageDynamicMin = 45;
        sImageDynamicMax = 135;
        sThumbnailMin = 45;
        sThumbnailMax = 135;
        sThumbnailDynamicMin = 45;
        sThumbnailDynamicMax = 135;
        sSizeInited = false;
    }

    public CommonImgThumbHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void ensureInitInject() {
        boolean z16;
        if (this.mQQDpc == null) {
            initQAutoInject();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[AutoInject] inject:");
            if (this.mQQDpc != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    public static int getImgThumbMaxDp(boolean z16) {
        initAioThumbSizeByDpc();
        if (z16) {
            return sImageDynamicMax;
        }
        return sImageMaxSize;
    }

    public static int getImgThumbMaxPx(boolean z16) {
        initAioThumbSizeByDpc();
        if (z16) {
            return sThumbnailDynamicMax;
        }
        return sThumbnailMax;
    }

    public static int getImgThumbMinDp(boolean z16) {
        initAioThumbSizeByDpc();
        if (z16) {
            return sImageDynamicMin;
        }
        return sImageMinSize;
    }

    public static int getImgThumbMinPx(boolean z16) {
        initAioThumbSizeByDpc();
        if (z16) {
            return sThumbnailDynamicMin;
        }
        return sThumbnailMin;
    }

    public static CommonImgThumbHelper getInstance() {
        if (mInstance == null) {
            synchronized (CommonImgThumbHelper.class) {
                if (mInstance == null) {
                    mInstance = new CommonImgThumbHelper();
                }
            }
        }
        return mInstance;
    }

    public static ThumbWidthHeightDP getThumbWidthHeightDP(boolean z16) {
        int imgThumbMinDp = getImgThumbMinDp(z16);
        int imgThumbMaxDp = getImgThumbMaxDp(z16);
        return new ThumbWidthHeightDP(imgThumbMinDp, imgThumbMinDp, imgThumbMaxDp, imgThumbMaxDp);
    }

    public static void initAioThumbSizeByDpc() {
        getInstance().initAioThumbSizeByDpcInner();
    }

    public synchronized void initAioThumbSizeByDpcInner() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (sSizeInited) {
            return;
        }
        ensureInitInject();
        p pVar = this.mQQDpc;
        if (pVar != null) {
            str = pVar.a();
        } else {
            str = IDPCApiConstant.AIO_PIC_THUMB_SIZE_DEFAULT;
        }
        String[] split = str.split("\\|");
        if (split.length == 2) {
            int intValue = Integer.valueOf(split[0]).intValue();
            if (intValue >= 45 && intValue <= 198) {
                sImageMaxSize = intValue;
            }
            int intValue2 = Integer.valueOf(split[1]).intValue();
            if (intValue2 >= 45 && intValue2 <= 198) {
                sImageDynamicMax = intValue2;
            }
        }
        BaseApplication.getContext();
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        if (f16 <= 0.0f) {
            f16 = 1.0f;
        }
        sThumbnailMax = (int) (sImageMaxSize * f16);
        sThumbnailDynamicMax = (int) (sImageDynamicMax * f16);
        sThumbnailMin = (int) (sImageMinSize * f16);
        sThumbnailDynamicMin = (int) (sImageDynamicMin * f16);
        sSizeInited = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "thumbMax:", Integer.valueOf(sThumbnailMax), ", thumbMin:", Integer.valueOf(sThumbnailDynamicMax));
        }
    }

    @QAutoInitMethod
    void initQAutoInject() {
        this.mQQDpc = (p) com.tencent.mobileqq.qroute.utils.b.a(mQQDpc_AutoGenClazzList_QAutoInjectTransform);
    }
}
