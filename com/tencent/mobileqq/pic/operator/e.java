package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.CommonImgThumbHelper;
import cooperation.peak.PeakConstants;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends a {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int[] k(AppInterface appInterface) {
        String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.picCompressArgConfig.name(), IDPCApiConstant.SEND_PHOTO_COMPRESS_ARG_DEFAULT);
        com.tencent.mobileqq.pic.f.b("CompressPicOperator", "getCompressConfigFromServer", "compressConfig = " + featureValue);
        if (!TextUtils.isEmpty(featureValue)) {
            try {
                Integer[] numArr = new Integer[10];
                Arrays.fill((Object[]) numArr, (Object) 0);
                int parseComplexParamsByStringToIntParser = ((IDPCApi) QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(featureValue, numArr);
                String currentUin = appInterface.getCurrentUin();
                if (!TextUtils.isEmpty(currentUin) && parseComplexParamsByStringToIntParser >= 10) {
                    if (Integer.parseInt(String.valueOf(currentUin.charAt(currentUin.length() - 1))) <= numArr[0].intValue()) {
                        if (numArr[1].intValue() >= 960) {
                            com.tencent.mobileqq.pic.compress.a.f258671d = numArr[1].intValue();
                        }
                        if (numArr[2].intValue() >= 960) {
                            com.tencent.mobileqq.pic.compress.a.f258672e = numArr[2].intValue();
                        }
                        if (numArr[3].intValue() >= 960) {
                            com.tencent.mobileqq.pic.compress.a.f258673f = numArr[3].intValue();
                        }
                        if (numArr[4].intValue() >= 960) {
                            com.tencent.mobileqq.pic.compress.a.f258674g = numArr[4].intValue();
                        }
                        if (numArr[5].intValue() >= 960) {
                            com.tencent.mobileqq.pic.compress.a.f258675h = numArr[5].intValue();
                        }
                        if (numArr[6].intValue() >= 960) {
                            com.tencent.mobileqq.pic.compress.a.f258676i = numArr[6].intValue();
                        }
                        if (numArr[7].intValue() > 0 && numArr[7].intValue() <= 100) {
                            com.tencent.mobileqq.pic.compress.a.f258668a = numArr[7].intValue();
                        }
                        if (numArr[8].intValue() > 0 && numArr[8].intValue() <= 100) {
                            com.tencent.mobileqq.pic.compress.a.f258669b = numArr[8].intValue();
                        }
                        if (numArr[9].intValue() > 0 && numArr[9].intValue() <= 100) {
                            com.tencent.mobileqq.pic.compress.a.f258670c = numArr[9].intValue();
                        }
                    } else {
                        com.tencent.mobileqq.pic.f.b("CompressPicOperator", "getCompressConfigFromServer", "current uin do not match");
                    }
                }
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            }
        }
        int[] iArr = {com.tencent.mobileqq.pic.compress.a.f258671d, com.tencent.mobileqq.pic.compress.a.f258672e, com.tencent.mobileqq.pic.compress.a.f258673f, com.tencent.mobileqq.pic.compress.a.f258674g, com.tencent.mobileqq.pic.compress.a.f258675h, com.tencent.mobileqq.pic.compress.a.f258676i, com.tencent.mobileqq.pic.compress.a.f258668a, com.tencent.mobileqq.pic.compress.a.f258669b, com.tencent.mobileqq.pic.compress.a.f258670c};
        com.tencent.mobileqq.pic.f.b("CompressPicOperator", "getCompressConfigFromServer", "result = " + Arrays.toString(iArr));
        return iArr;
    }

    @Override // com.tencent.mobileqq.pic.operator.a
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        p pVar = this.f258751f;
        CompressInfo compressInfo = pVar.f258787i;
        com.tencent.mobileqq.pic.compress.c.d(compressInfo);
        com.tencent.mobileqq.activity.aio.photo.j jVar = pVar.M;
        if (jVar != null) {
            if (compressInfo.f258516f) {
                jVar.o1(compressInfo);
            } else {
                jVar.P4(compressInfo);
            }
            jVar.k2(compressInfo);
        }
        CommonImgThumbHelper.initAioThumbSizeByDpc();
    }

    public CompressInfo l(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CompressInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        int intExtra = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0);
        return new CompressInfo(intent.getStringExtra(PeakConstants.PHOTO_SEND_PATH), ((ICompressOperator) QRoute.api(ICompressOperator.class)).transformQuality(intExtra), intent.getIntExtra(PeakConstants.SEND_BUSINESS_TYPE, -1));
    }
}
