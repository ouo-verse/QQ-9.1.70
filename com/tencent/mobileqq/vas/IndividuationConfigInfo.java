package com.tencent.mobileqq.vas;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class IndividuationConfigInfo {
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isLaterVersion(String str, String str2) {
        int parseInt;
        int parseInt2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int max = Math.max(split.length, split2.length);
            for (int i3 = 0; i3 < max; i3++) {
                if (i3 < split.length) {
                    try {
                        parseInt = Integer.parseInt(split[i3]);
                    } catch (Exception unused) {
                    }
                    if (i3 < split2.length) {
                        try {
                            parseInt2 = Integer.parseInt(split2[i3]);
                        } catch (Exception unused2) {
                        }
                        if (i3 != max - 1) {
                            if (parseInt2 > parseInt) {
                                return true;
                            }
                            if (parseInt2 < parseInt) {
                                return false;
                            }
                        } else {
                            if (parseInt2 >= parseInt) {
                                return true;
                            }
                            if (parseInt2 < parseInt) {
                                return false;
                            }
                        }
                    }
                    parseInt2 = 0;
                    if (i3 != max - 1) {
                    }
                }
                parseInt = 0;
                if (i3 < split2.length) {
                }
                parseInt2 = 0;
                if (i3 != max - 1) {
                }
            }
        }
        return false;
    }
}
