package com.tencent.av.mediacodec.api.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.av.config.api.ICodecConfigParser;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.mediacodec.DeviceCheck;
import com.tencent.av.mediacodec.api.IAndroidCodecHelperApi;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.e;
import com.tencent.avcore.jni.codec.AndroidCodec;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.jni.codec.MediaCodecConstants;
import com.tencent.avcore.jni.codec.NativeCodec;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import du.a;
import du.b;
import java.util.ArrayList;
import java.util.Iterator;
import pu.d;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AndroidCodecHelperApiImpl implements IAndroidCodecHelperApi {
    private static final String TAG = "AndroidCodecHelperApiImpl";
    private boolean mGfLoaded = false;
    private boolean mIsSupportHwCodec1080P = false;
    private int mOutputFormatForReport = 0;

    public boolean checkMachinePower(String str, d.a aVar, HWCodecAbility hWCodecAbility) {
        long j3 = aVar.f427380a;
        if (j3 == 1) {
            if (DeviceCheck.i()) {
                hWCodecAbility.codecType = 2;
                printsDevelop(str, "H264 ENC SUCCESS");
                return true;
            }
            printsDevelop(str, "H264 ENC FAIL");
            return false;
        }
        if (j3 == 4) {
            if (DeviceCheck.l()) {
                hWCodecAbility.codecType = 8;
                printsDevelop(str, "H265 ENC SUCCESS");
                return true;
            }
            printsDevelop(str, "H265 ENC FAIL");
            return false;
        }
        if (j3 == 2) {
            if (DeviceCheck.g()) {
                hWCodecAbility.codecType = 1;
                printsDevelop(str, "H264 DEC SUCCESS");
                return true;
            }
            printsDevelop(str, "H264 DEC FAIL");
            return false;
        }
        if (j3 != 8) {
            return j3 != 0;
        }
        if (DeviceCheck.k()) {
            hWCodecAbility.codecType = 4;
            printsDevelop(str, "H265 DEC SUCCESS");
            return true;
        }
        printsDevelop(str, "H265 DEC FAIL");
        return false;
    }

    @Override // com.tencent.av.mediacodec.api.IAndroidCodecHelperApi
    public ArrayList<HWCodecAbility> checkSupportHWCodecAbility(String str, Context context) {
        if (!AndroidCodec.checkAPILevel21Valid(str)) {
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u4e0d\u662fAPI21");
            return null;
        }
        loadLibrary(this.mGfLoaded, context);
        if (!this.mGfLoaded) {
            QLog.w(str, 1, "checkSupportHWCodecAbility, lib\u5931\u8d25");
            return null;
        }
        ArrayList<HWCodecAbility> arrayList = new ArrayList<>();
        if (e.k()) {
            QLog.e(str, 1, "checkSupportHWCodecAbility start");
        }
        getDecoderAbility(str, context, arrayList);
        getEncoderAbility(str, context, arrayList);
        ArrayList<HWCodecAbility> arrayList2 = new ArrayList<>();
        getChipHWCodecAbility(str, arrayList2);
        ArrayList<HWCodecAbility> mergeMediaCodecConifgTwoList = mergeMediaCodecConifgTwoList(arrayList, arrayList2);
        this.mIsSupportHwCodec1080P = isSupportHwCodec1080P(mergeMediaCodecConifgTwoList);
        return mergeMediaCodecConifgTwoList;
    }

    public int checkSupportMediaCodecFeature(Context context) {
        ArrayList<HWCodecAbility> checkSupportHWCodecAbility = checkSupportHWCodecAbility("unknown", context);
        int i3 = 0;
        if (checkSupportHWCodecAbility != null && checkSupportHWCodecAbility.size() > 0) {
            Iterator<HWCodecAbility> it = checkSupportHWCodecAbility.iterator();
            while (it.hasNext()) {
                HWCodecAbility next = it.next();
                if (next.isHWCodec) {
                    i3 += next.codecType;
                }
            }
        }
        return i3;
    }

    public void getChipHWCodecAbility(String str, ArrayList<HWCodecAbility> arrayList) {
        d b16 = b.a().b();
        if (b16 == null || b16.e().isEmpty() || isApiLevelLowToKitKat()) {
            return;
        }
        Iterator<d.a> it = b16.e().iterator();
        while (it.hasNext()) {
            d.a next = it.next();
            if (next.f427381b) {
                HWCodecAbility hWCodecAbility = new HWCodecAbility();
                if (checkMachinePower(str, next, hWCodecAbility)) {
                    hWCodecAbility.isHWCodec = true;
                    hWCodecAbility.maxH = next.f427383d;
                    hWCodecAbility.maxW = next.f427382c;
                    arrayList.add(hWCodecAbility);
                }
            }
        }
    }

    public void getDecoderAbility(String str, Context context, ArrayList<HWCodecAbility> arrayList) {
        if (DeviceCheck.h()) {
            if (DeviceCheck.g()) {
                arrayList.add(new HWCodecAbility(1, true));
                if (e.k()) {
                    QLog.w(str, 1, "checkSupportHWCodecAbility, \u767d\u540d\u5355, \u652f\u6301H264\u89e3\u7801");
                    return;
                }
                return;
            }
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u767d\u540d\u5355, \u4e0d\u652f\u6301H264\u89e3\u7801");
            return;
        }
        IConfigParser b16 = a.b(context);
        ICodecConfigParser iCodecConfigParser = (ICodecConfigParser) QRoute.api(ICodecConfigParser.class);
        iCodecConfigParser.init(b16);
        HWCodecAbility aVCDecoderAbility = iCodecConfigParser.getAVCDecoderAbility();
        if (aVCDecoderAbility != null && aVCDecoderAbility.isHWCodec) {
            if (DeviceCheck.g()) {
                arrayList.add(aVCDecoderAbility);
                if (e.k()) {
                    QLog.w(str, 1, "checkSupportHWCodecAbility, \u652f\u6301H264\u89e3\u7801. maxW = " + aVCDecoderAbility.maxW + ", maxH = " + aVCDecoderAbility.maxH);
                }
            } else {
                QLog.w(str, 1, "checkSupportHWCodecAbility, \u4e0d\u652f\u6301H264\u89e3\u7801");
            }
        } else if (QLog.isDevelopLevel()) {
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u65e0H264\u89e3\u7801\u914d\u7f6e");
        }
        HWCodecAbility hevcDecoderAbility = iCodecConfigParser.getHevcDecoderAbility();
        if (hevcDecoderAbility != null && hevcDecoderAbility.isHWCodec) {
            if (DeviceCheck.k()) {
                arrayList.add(hevcDecoderAbility);
                if (e.k()) {
                    QLog.w(str, 1, "checkSupportHWCodecAbility, \u652f\u6301H265\u89e3\u7801. maxW = " + hevcDecoderAbility.maxW + ", maxH = " + hevcDecoderAbility.maxH);
                    return;
                }
                return;
            }
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u4e0d\u652f\u6301H265\u89e3\u7801");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u65e0H265\u89e3\u7801\u914d\u7f6e");
        }
    }

    public void getEncoderAbility(String str, Context context, ArrayList<HWCodecAbility> arrayList) {
        if (DeviceCheck.j()) {
            if (DeviceCheck.i()) {
                arrayList.add(new HWCodecAbility(2, true));
                if (e.k()) {
                    QLog.w(str, 1, "checkSupportHWCodecAbility, \u767d\u540d\u5355, \u652f\u6301H264\u7f16\u7801");
                    return;
                }
                return;
            }
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u767d\u540d\u5355, \u4e0d\u652f\u6301H264\u7f16\u7801");
            return;
        }
        IConfigParser b16 = a.b(context);
        ICodecConfigParser iCodecConfigParser = (ICodecConfigParser) QRoute.api(ICodecConfigParser.class);
        iCodecConfigParser.init(b16);
        HWCodecAbility aVCEncoderAbility = iCodecConfigParser.getAVCEncoderAbility();
        if (aVCEncoderAbility != null && aVCEncoderAbility.isHWCodec) {
            if (DeviceCheck.i()) {
                arrayList.add(aVCEncoderAbility);
                if (e.k()) {
                    QLog.w(str, 1, "checkSupportHWCodecAbility, \u652f\u6301H264\u7f16\u7801. maxW = " + aVCEncoderAbility.maxW + ", maxH = " + aVCEncoderAbility.maxH);
                }
            } else {
                QLog.w(str, 1, "checkSupportHWCodecAbility, \u4e0d\u652f\u6301H264\u7f16\u7801");
            }
        } else if (QLog.isDevelopLevel()) {
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u65e0H264\u7f16\u7801\u914d\u7f6e");
        }
        HWCodecAbility hevcEncoderAbility = iCodecConfigParser.getHevcEncoderAbility();
        if (hevcEncoderAbility != null && hevcEncoderAbility.isHWCodec) {
            if (DeviceCheck.l()) {
                arrayList.add(hevcEncoderAbility);
                if (e.k()) {
                    QLog.w(str, 1, "checkSupportHWCodecAbility, \u652f\u6301H265\u7f16\u7801. maxW = " + hevcEncoderAbility.maxW + ", maxH = " + hevcEncoderAbility.maxH);
                    return;
                }
                return;
            }
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u4e0d\u652f\u6301H265\u7f16\u7801");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(str, 1, "checkSupportHWCodecAbility, \u65e0H265\u7f16\u7801\u914d\u7f6e");
        }
    }

    public HWCodecAbility getHWCodecAbilityByCodecType(int i3, ArrayList<HWCodecAbility> arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator<HWCodecAbility> it = arrayList.iterator();
        while (it.hasNext()) {
            HWCodecAbility next = it.next();
            if (i3 == next.codecType && next.isHWCodec) {
                return next;
            }
        }
        return null;
    }

    @Override // com.tencent.av.mediacodec.api.IAndroidCodecHelperApi
    public int getHwDetectOutputFormatForReport() {
        return this.mOutputFormatForReport;
    }

    public boolean isApiLevelLowToKitKat() {
        return false;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecStatusCallback
    public boolean isSupportAsyncApi() {
        return DeviceCheck.m();
    }

    @Override // com.tencent.av.mediacodec.api.IAndroidCodecHelperApi
    public boolean isSupportHwCodec1080PFeature() {
        return this.mIsSupportHwCodec1080P;
    }

    public boolean loadCodecLibrarys() {
        if (!this.mGfLoaded) {
            try {
                loadLibrarysInternal();
                QLog.w(TAG, 1, "loadCodecLibrarys suc, ver[" + NativeCodec.getVersion() + "]");
                this.mGfLoaded = true;
            } catch (UnsatisfiedLinkError e16) {
                e16.printStackTrace();
                this.mGfLoaded = false;
            }
            if (!this.mGfLoaded) {
                QLog.w(TAG, 1, "loadCodecLibrarys fail");
            }
        }
        return this.mGfLoaded;
    }

    public void loadLibrarysInternal() {
        AVSoUtils.H();
    }

    public ArrayList<HWCodecAbility> mergeMediaCodecConifgTwoList(ArrayList<HWCodecAbility> arrayList, ArrayList<HWCodecAbility> arrayList2) {
        if (arrayList.isEmpty()) {
            return arrayList2;
        }
        if (arrayList2.isEmpty()) {
            return arrayList;
        }
        ArrayList<HWCodecAbility> arrayList3 = new ArrayList<>(4);
        for (int i3 = 0; i3 < 4; i3++) {
            int i16 = MediaCodecConstants.SUPPORT_POWER_LISTS[i3];
            boolean z16 = i16 == 8 || i16 == 4;
            HWCodecAbility hWCodecAbilityByCodecType = getHWCodecAbilityByCodecType(i16, arrayList);
            HWCodecAbility hWCodecAbilityByCodecType2 = getHWCodecAbilityByCodecType(i16, arrayList2);
            if (hWCodecAbilityByCodecType != null) {
                if (z16 && hWCodecAbilityByCodecType2 != null && hWCodecAbilityByCodecType2.maxW >= 1920 && hWCodecAbilityByCodecType2.maxH >= 1080) {
                    arrayList3.add(hWCodecAbilityByCodecType2);
                } else {
                    arrayList3.add(hWCodecAbilityByCodecType);
                }
            } else if (hWCodecAbilityByCodecType2 != null) {
                arrayList3.add(hWCodecAbilityByCodecType2);
            }
        }
        return arrayList3;
    }

    @Override // com.tencent.avcore.jni.codec.AndroidCodecStatusCallback
    public void onOutputFormatChange(int i3) {
        this.mOutputFormatForReport = i3;
    }

    public void printsDevelop(String str, String str2) {
        if (QLog.isDevelopLevel()) {
            QLog.w(str, 1, str2);
        }
    }

    public void loadLibrary(boolean z16, Context context) {
        if (z16 || !loadCodecLibrarys()) {
            return;
        }
        String str = (((("PRODUCT=" + Build.PRODUCT.toLowerCase() + ";") + "MODEL=" + DeviceInfoMonitor.getModel().toLowerCase() + ";") + "SDK=" + Build.VERSION.SDK_INT + ";") + "FINGERPRINT=" + Build.FINGERPRINT.toLowerCase() + ";") + "MANUFACTURER=" + Build.MANUFACTURER.toLowerCase() + ";";
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        NativeCodec.setDeviceInfo((str + "DATADIR=" + applicationInfo.dataDir + ";") + "LIBDIR=" + applicationInfo.nativeLibraryDir + ";");
    }

    public void checkDebug(ArrayList<HWCodecAbility> arrayList) {
        boolean z16 = 1 == e.e(33);
        boolean z17 = 1 == e.e(32);
        boolean z18 = 1 == e.e(31);
        boolean z19 = 1 == e.e(30);
        if (z16 || z17 || z19 || z18) {
            Iterator<HWCodecAbility> it = arrayList.iterator();
            boolean z26 = false;
            boolean z27 = false;
            boolean z28 = false;
            boolean z29 = false;
            while (it.hasNext()) {
                HWCodecAbility next = it.next();
                if (next.isHWCodec) {
                    int i3 = next.codecType;
                    if (i3 == 4) {
                        z27 = true;
                    } else if (i3 == 8) {
                        z26 = true;
                    } else if (i3 == 1) {
                        z29 = true;
                    } else if (i3 == 2) {
                        z28 = true;
                    }
                }
            }
            if (!z26 && z16) {
                arrayList.add(new HWCodecAbility(8, true));
            }
            if (!z27 && z17) {
                arrayList.add(new HWCodecAbility(4, true));
            }
            if (!z28 && z18) {
                arrayList.add(new HWCodecAbility(2, true));
            }
            if (!z29 && z19) {
                arrayList.add(new HWCodecAbility(1, true));
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("hw_debug", 4, String.format("checkDebug, h265_dec[%s, %s], h265_enc[%s, %s],h264_dec[%s, %s], h264_enc[%s, %s]", Boolean.valueOf(z17), Boolean.valueOf(z27), Boolean.valueOf(z16), Boolean.valueOf(z26), Boolean.valueOf(z19), Boolean.valueOf(z29), Boolean.valueOf(z18), Boolean.valueOf(z28)));
            }
        }
    }

    public boolean isSupportHwCodec1080P(ArrayList<HWCodecAbility> arrayList) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26 = false;
        if (arrayList == null || arrayList.size() <= 0) {
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
        } else {
            Iterator<HWCodecAbility> it = arrayList.iterator();
            z16 = false;
            z17 = false;
            z18 = false;
            z19 = false;
            while (it.hasNext()) {
                HWCodecAbility next = it.next();
                int i3 = next.codecType;
                if (i3 == 1 && next.isHWCodec && next.maxW >= 1920 && next.maxH >= 1080) {
                    z17 = true;
                } else if (i3 == 2 && next.isHWCodec && next.maxW >= 1920 && next.maxH >= 1080) {
                    z16 = true;
                } else if (i3 == 4 && next.isHWCodec && next.maxW >= 1920 && next.maxH >= 1080) {
                    z19 = true;
                } else if (i3 == 8 && next.isHWCodec && next.maxW >= 1920 && next.maxH >= 1080) {
                    z18 = true;
                }
            }
        }
        if ((z16 && z17) || (z18 && z19)) {
            z26 = true;
        }
        QLog.i("AndroidCodec", 1, "isSupportHwCodec1080P = " + z26);
        return z26;
    }
}
