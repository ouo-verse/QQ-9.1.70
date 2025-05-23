package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.config.business.AIOPicThumbSizeProcessor;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AIOImgThumbHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AIOImgThumbHelper";
    private static float density;
    private static AIOImgThumbHelper mInstance;
    private static int sAioImageDynamicMax;
    private static int sAioImageDynamicMin;
    private static int sAioImageMaxSize;
    private static int sAioImageMaxSizeUnderLimit;
    private static int sAioImageMinSize;
    private static int sAioImageMinSizeUnderLimit;
    private static int sAioImageMinSizeUnderLimitForFileWidth;
    private static int sPicSizeLimit;
    private static boolean sSizeInited;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        sPicSizeLimit = 650;
        sSizeInited = false;
        density = -1.0f;
    }

    public AIOImgThumbHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getAioThumbMaxDp(boolean z16, boolean z17, int i3) {
        if (z17) {
            initAioThumbSize();
            if (z16) {
                return sAioImageDynamicMax;
            }
            if (i3 > sPicSizeLimit) {
                return sAioImageMaxSize;
            }
            return sAioImageMaxSizeUnderLimit;
        }
        return CommonImgThumbHelper.getImgThumbMaxDp(z16);
    }

    public static int getAioThumbMaxPx(boolean z16, boolean z17, int i3) {
        return (int) (getAioThumbMaxDp(z16, z17, i3) * getDensity());
    }

    public static int getAioThumbMinDp(boolean z16, boolean z17, int i3) {
        if (z17) {
            initAioThumbSize();
            if (z16) {
                return sAioImageDynamicMin;
            }
            if (i3 > sPicSizeLimit) {
                return sAioImageMinSize;
            }
            return sAioImageMinSizeUnderLimit;
        }
        return CommonImgThumbHelper.getImgThumbMinDp(z16);
    }

    public static int getAioThumbMinDpForFileWidth(int i3) {
        initAioThumbSize();
        if (i3 > sPicSizeLimit) {
            return Math.max(sAioImageMinSize, sAioImageMinSizeUnderLimitForFileWidth);
        }
        return sAioImageMinSizeUnderLimitForFileWidth;
    }

    public static int getAioThumbMinPx(boolean z16, boolean z17, int i3) {
        return (int) (getAioThumbMinDp(z16, z17, i3) * getDensity());
    }

    public static int getAioThumbMinPxForFileWidth(int i3) {
        return (int) (getAioThumbMinDpForFileWidth(i3) * getDensity());
    }

    public static float getDensity() {
        if (density == -1.0f) {
            float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
            density = f16;
            if (f16 <= 0.0f) {
                density = 1.0f;
            }
        }
        return density;
    }

    public static AIOImgThumbHelper getInstance() {
        if (mInstance == null) {
            synchronized (AIOImgThumbHelper.class) {
                if (mInstance == null) {
                    mInstance = new AIOImgThumbHelper();
                }
            }
        }
        return mInstance;
    }

    public static ThumbWidthHeightDP getThumbWidthHeightDP(MessageForPic messageForPic, boolean z16) {
        if (messageForPic.thumbWidthHeightDP == null) {
            boolean z17 = !((IPicHelper) QRoute.api(IPicHelper.class)).isEmotion(messageForPic);
            int max = (int) Math.max(messageForPic.width, messageForPic.height);
            if (messageForPic.istroop == 10014 && !((IPicHelper) QRoute.api(IPicHelper.class)).isEmotion(messageForPic)) {
                messageForPic.thumbWidthHeightDP = ((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getThumbWidthHeightDPForGuildPicMsg();
            } else {
                messageForPic.thumbWidthHeightDP = getThumbWidthHeightDPForPicMsg(z16, z17, max);
            }
        }
        return messageForPic.thumbWidthHeightDP;
    }

    public static ThumbWidthHeightDP getThumbWidthHeightDPForFileMsg(int i3) {
        int aioThumbMinDp = getAioThumbMinDp(false, true, i3);
        int aioThumbMaxDp = getAioThumbMaxDp(false, true, i3);
        return new ThumbWidthHeightDP(getAioThumbMinDpForFileWidth(i3), aioThumbMinDp, aioThumbMaxDp, aioThumbMaxDp);
    }

    public static ThumbWidthHeightDP getThumbWidthHeightDPForPicMsg(boolean z16, boolean z17, int i3) {
        if (!z17) {
            return CommonImgThumbHelper.getThumbWidthHeightDP(z16);
        }
        int aioThumbMinDp = getAioThumbMinDp(z16, z17, i3);
        int aioThumbMaxDp = getAioThumbMaxDp(z16, z17, i3);
        return new ThumbWidthHeightDP(aioThumbMinDp, aioThumbMinDp, aioThumbMaxDp, aioThumbMaxDp);
    }

    public static void initAioThumbSize() {
        getInstance().initAioThumbSizeInner();
    }

    public synchronized void initAioThumbSizeInner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (sSizeInited) {
            return;
        }
        AIOPicThumbSizeProcessor.a b16 = AIOPicThumbSizeProcessor.b();
        if (b16 != null && b16.f202415a) {
            updateByConfig(b16);
        } else {
            sAioImageMinSize = CommonImgThumbHelper.getImgThumbMinDp(false);
            sAioImageMaxSize = CommonImgThumbHelper.getImgThumbMaxDp(false);
            sAioImageDynamicMin = CommonImgThumbHelper.getImgThumbMinDp(true);
            sAioImageDynamicMax = CommonImgThumbHelper.getImgThumbMaxDp(true);
            int i3 = sAioImageMinSize;
            sAioImageMinSizeUnderLimit = i3;
            sAioImageMaxSizeUnderLimit = sAioImageMaxSize;
            sAioImageMinSizeUnderLimitForFileWidth = i3 + CommonImgThumbHelper.sImageMinSizeForFileWidthAddedValue;
        }
        sSizeInited = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "thumbMax:", Integer.valueOf(sAioImageMaxSize), ", thumbMin:", Integer.valueOf(sAioImageMinSize));
        }
    }

    public synchronized void updateByConfig(AIOPicThumbSizeProcessor.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        sAioImageMinSize = aVar.f202421g;
        sAioImageMaxSize = aVar.f202420f;
        sAioImageDynamicMin = aVar.f202425k;
        sAioImageDynamicMax = aVar.f202424j;
        int i3 = aVar.f202423i;
        sAioImageMinSizeUnderLimit = i3;
        sAioImageMaxSizeUnderLimit = aVar.f202422h;
        sAioImageMinSizeUnderLimitForFileWidth = i3 + CommonImgThumbHelper.sImageMinSizeForFileWidthAddedValue;
        sPicSizeLimit = aVar.f202419e;
        QLog.d(TAG, 1, "updateByConfig maxRatio:", Double.valueOf(aVar.f202416b), ", minRatio:", Double.valueOf(aVar.f202417c), ", picSizeLimit:", Integer.valueOf(sPicSizeLimit));
    }
}
