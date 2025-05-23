package com.tencent.mobileqq.pic.api.impl;

import com.tencent.mobileqq.data.Avif2JpgResult;
import com.tencent.mobileqq.pic.api.IPicConvertForNativeApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.mobileqq.transfile.PicConvertUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeResult;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeStep;

/* loaded from: classes16.dex */
public class PicConvertForNativeApiImpl implements IPicConvertForNativeApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "avif_PicConvertForNative";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f258632a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17996);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Avif2JpgResult.ConvertToJpg.values().length];
            f258632a = iArr;
            try {
                iArr[Avif2JpgResult.ConvertToJpg.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.FAIL_WITH_DEBUG_EXCEPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.PATH_INVALID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.SRC_FILE_NOT_EXIST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.SRC_FILE_NOT_AVIF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.AVIF_SO_NOT_LOADED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.YUV_SIZE_INVALID.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.YUV_FAIL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.FAIL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.FAIL_WITH_EXCEPTION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.FAIL_WITH_OOM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.SUCCESS_BY_YUV.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f258632a[Avif2JpgResult.ConvertToJpg.SUCCESS_BY_RGB.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public PicConvertForNativeApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private AvifTranscodeResult convertResult(Avif2JpgResult avif2JpgResult) {
        boolean z16;
        if (avif2JpgResult.getGenerateThumb() == Avif2JpgResult.GenerateThumb.SUCCESS) {
            z16 = true;
        } else {
            z16 = false;
        }
        AvifTranscodeStep avifTranscodeStep = AvifTranscodeStep.KUNKNOWN;
        switch (a.f258632a[avif2JpgResult.getConvertToJpg().ordinal()]) {
            case 3:
            case 4:
            case 5:
                avifTranscodeStep = AvifTranscodeStep.KISNOTAVIF;
                break;
            case 6:
                avifTranscodeStep = AvifTranscodeStep.KLOADSOFAILED;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                avifTranscodeStep = AvifTranscodeStep.KAVIFDECODEFAIL;
                break;
            case 11:
                avifTranscodeStep = AvifTranscodeStep.KOOM;
                break;
            case 12:
            case 13:
                avifTranscodeStep = AvifTranscodeStep.KSUCFINISHED;
                break;
        }
        AvifTranscodeResult avifTranscodeResult = new AvifTranscodeResult(avifTranscodeStep, 0, Boolean.valueOf(z16));
        QLog.d(TAG, 1, "upper Avif2JpgResult: " + avif2JpgResult + " --> \n ntsdk AvifTranscodeResult: " + avifTranscodeResult);
        return avifTranscodeResult;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicConvertForNativeApi
    public AvifTranscodeResult convertAvif2Jpg(int i3, AvifTranscodeInfo avifTranscodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AvifTranscodeResult) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) avifTranscodeInfo);
        }
        if (avifTranscodeInfo == null) {
            QLog.d(TAG, 1, "transcodeInfo is null, return");
            return new AvifTranscodeResult();
        }
        QLog.d(TAG, 1, "convertAvif2Jpg:::transcodeInfo: " + avifTranscodeInfo);
        return convertResult(PicConvertUtil.convertAvif2Jpg(i3, avifTranscodeInfo.getAvifPath(), avifTranscodeInfo.getDstJpgPath(), avifTranscodeInfo.getAioPath(), AIOImgThumbHelper.getThumbWidthHeightDPForPicMsg(false, true, (int) Math.max(avifTranscodeInfo.getPicWidth(), avifTranscodeInfo.getPicHeight())), 0));
    }
}
