package com.tenpay.sdk.util;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.R;
import com.tencent.soter.core.SoterCore;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QWSoterConstans {
    public static final int BUSI_TYPE_FACE = 2;
    public static final int BUSI_TYPE_FINGER = 1;
    public static final String CGI_KEY_BUSI_TYPE = "busi_type";
    public static final String CGI_KEY_QPAYGATE_BUSI_TYPE = "soter_busi_type";
    private static SparseIntArray sBusiTypeToBiometricType;
    private static SparseIntArray sBusiTypeToFailedResId;
    private static SparseArray<String> sBusiTypeToNames;
    private static SparseIntArray sBusiTypeToResId;
    private static Set<Integer> sValidBusiTypes;

    static {
        HashSet hashSet = new HashSet();
        sValidBusiTypes = hashSet;
        hashSet.add(1);
        sValidBusiTypes.add(2);
        SparseArray<String> sparseArray = new SparseArray<>();
        sBusiTypeToNames = sparseArray;
        sparseArray.append(1, "\u6307\u7eb9");
        sBusiTypeToNames.append(2, "\u9762\u5bb9");
        SparseIntArray sparseIntArray = new SparseIntArray();
        sBusiTypeToResId = sparseIntArray;
        sparseIntArray.put(1, R.drawable.ht8);
        sBusiTypeToResId.put(2, R.drawable.ht6);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sBusiTypeToFailedResId = sparseIntArray2;
        sparseIntArray2.put(2, R.drawable.ht7);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        sBusiTypeToBiometricType = sparseIntArray3;
        sparseIntArray3.put(1, 1);
        sBusiTypeToBiometricType.put(2, 2);
    }

    public static int getAuthFailResId(int i3) {
        return sBusiTypeToFailedResId.get(i3);
    }

    public static int getAuthResIdByBusiType(int i3) {
        return sBusiTypeToResId.get(i3);
    }

    public static int getBiometricType(int i3) {
        return sBusiTypeToBiometricType.get(i3);
    }

    public static String getNameByBusiType(int i3) {
        return sBusiTypeToNames.get(i3);
    }

    public static boolean isSupportNativeAuth(Context context) {
        for (int i3 = 0; i3 < sBusiTypeToBiometricType.size(); i3++) {
            if (SoterCore.isSupportBiometric(context, sBusiTypeToBiometricType.valueAt(i3))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidBusiType(int i3) {
        return sValidBusiTypes.contains(Integer.valueOf(i3));
    }
}
