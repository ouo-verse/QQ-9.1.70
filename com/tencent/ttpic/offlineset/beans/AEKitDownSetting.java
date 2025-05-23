package com.tencent.ttpic.offlineset.beans;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.tencent.ttpic.util.GsonUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AEKitDownSetting {
    public List<DownResInfo> AEKitSDKSetting;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class DownResInfo {
        public String maxAppVer;
        public String md5;
        public String minAppVer;
        public String res_id;
        public String url;
        public String ver;

        public DownResInfo() {
        }

        public String getDownResInfoString(String str) {
            if (!AEKitDownSetting.needUpdate(str, this)) {
                return null;
            }
            return GsonUtils.obj2Json(this, new TypeToken<DownResInfo>() { // from class: com.tencent.ttpic.offlineset.beans.AEKitDownSetting.DownResInfo.1
            }.getType());
        }

        public String getResInfo(String str, String str2, String str3, String str4) {
            if (!AEKitDownSetting.needUpdate(str, this)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, this.url);
                jSONObject.put(str3, this.md5);
                jSONObject.put(str4, this.ver);
                return jSONObject.toString();
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027 A[LOOP:0: B:9:0x000d->B:16:0x0027, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0026 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean compareArr(int[] iArr, int[] iArr2, boolean z16) {
        if (iArr != null && iArr2 != null) {
            if (iArr.length != iArr2.length) {
                return false;
            }
            for (int i3 = 0; i3 < iArr.length; i3++) {
                if (z16) {
                    if (iArr[i3] < iArr2[i3]) {
                        return false;
                    }
                    if (iArr[i3] == iArr2[i3]) {
                        return true;
                    }
                } else {
                    if (iArr[i3] > iArr2[i3]) {
                        return false;
                    }
                    if (iArr[i3] == iArr2[i3]) {
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needUpdate(String str, DownResInfo downResInfo) {
        int[] parseVer;
        if (downResInfo == null || str == null || (parseVer = parseVer(str)) == null) {
            return false;
        }
        int[] parseVer2 = parseVer(downResInfo.minAppVer);
        int[] parseVer3 = parseVer(downResInfo.maxAppVer);
        if (!compareArr(parseVer, parseVer2, true) || !compareArr(parseVer, parseVer3, false)) {
            return false;
        }
        return true;
    }

    private static int[] parseVer(String str) {
        int[] iArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split != null && split.length >= 3) {
            int length = split.length;
            iArr = new int[length];
            for (int i3 = 0; i3 < length && i3 < split.length; i3++) {
                try {
                    iArr[i3] = Integer.parseInt(split[i3]);
                } catch (Throwable unused) {
                }
            }
        }
        return iArr;
    }

    public DownResInfo getDownResInfo(String str, String str2) {
        List<DownResInfo> list;
        DownResInfo downResInfo;
        if (str == null || str2 == null || (list = this.AEKitSDKSetting) == null) {
            return null;
        }
        Iterator<DownResInfo> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                downResInfo = it.next();
                if (downResInfo != null && str.equals(downResInfo.res_id)) {
                    break;
                }
            } else {
                downResInfo = null;
                break;
            }
        }
        if (!needUpdate(str2, downResInfo) || !needUpdate(str2, downResInfo)) {
            return null;
        }
        return downResInfo;
    }

    public String getResInfo(String str, String str2, String str3, String str4, String str5) {
        DownResInfo downResInfo = getDownResInfo(str, str2);
        if (downResInfo != null) {
            return downResInfo.getResInfo(str2, str3, str4, str5);
        }
        return null;
    }
}
