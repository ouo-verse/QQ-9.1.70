package com.tencent.qqlive.module.videoreport.sample;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SampleRateUtil {
    private static final char[] HEX_CHAR_ARR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String KEY_SAMPLE_DEVICE_ID = "key_sample_device_id";
    private static final String KEY_SAMPLE_RANDOM = "key_sample_random";
    public static final int SEED = 1313;
    private static final String SYSTEM_FLAG = "0";
    private static final int TOTAL_RANGE = 10000;
    private static String deviceSampleStr = "";

    public static String bytesToHex(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            int i3 = 0;
            for (byte b16 : bArr) {
                int i16 = i3 + 1;
                char[] cArr2 = HEX_CHAR_ARR;
                cArr[i3] = cArr2[(b16 >>> 4) & 15];
                i3 = i16 + 1;
                cArr[i16] = cArr2[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return "";
    }

    private static String createDeviceSampleStr(Context context) {
        SecureRandom secureRandom;
        String str = (String) SPUtils.get(context, KEY_SAMPLE_DEVICE_ID, "");
        if (TextUtils.isEmpty(str)) {
            try {
                secureRandom = SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused) {
                secureRandom = new SecureRandom();
            }
            byte[] bArr = new byte[8];
            secureRandom.nextBytes(bArr);
            str = bytesToHex(bArr) + String.valueOf(System.currentTimeMillis()) + "0";
            SPUtils.put(context, KEY_SAMPLE_DEVICE_ID, str);
        }
        String valueOf = String.valueOf(getBKDRHashCode(str) % 10000);
        SPUtils.put(context, KEY_SAMPLE_RANDOM, valueOf);
        return valueOf;
    }

    public static long getBKDRHashCode(String str) {
        long j3 = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        for (int i3 = 0; i3 != str.length(); i3++) {
            j3 = (j3 * 1313) + str.charAt(i3);
        }
        return j3 & TTL.MAX_VALUE;
    }

    private static int getRandomNumber() {
        Context context = ReportUtils.getContext();
        if (context == null) {
            return 0;
        }
        if (TextUtils.isEmpty(deviceSampleStr)) {
            deviceSampleStr = createDeviceSampleStr(context);
        }
        try {
            return Integer.parseInt(deviceSampleStr);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static boolean isHit(double d16) {
        if (getRandomNumber() <= ((int) (d16 * 10000.0d))) {
            return true;
        }
        return false;
    }
}
