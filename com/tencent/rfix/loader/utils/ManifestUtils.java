package com.tencent.rfix.loader.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.rfix.loader.log.RFixLog;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ManifestUtils {
    private static final String TAG = "RFix.ManifestUtils";
    private static String patchId;

    public static String getDefaultPatchId(Context context) {
        try {
            return (String) Class.forName(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).packageName + ".BuildConfig").getField(RFixConstants.DEFAULT_PATCH_ID).get(null);
        } catch (ClassNotFoundException unused) {
            RFixLog.w(TAG, "getDefaultPatchId BuildConfig not exist!");
            return null;
        } catch (NoSuchFieldException unused2) {
            RFixLog.w(TAG, "getDefaultPatchId BuildConfig.DEFAULT_PATCH_ID not exist!");
            return null;
        } catch (Exception e16) {
            RFixLog.e(TAG, "getDefaultPatchId fail!", e16);
            return null;
        }
    }

    public static String getManifestMetaData(Context context, String str) {
        Object obj;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return String.valueOf(obj);
        } catch (Exception e16) {
            RFixLog.e(TAG, "getManifestMetaData fail!", e16);
            return null;
        }
    }

    public static String getManifestPatchId(Context context) {
        String str = patchId;
        if (str != null) {
            return str;
        }
        String manifestMetaData = getManifestMetaData(context, RFixConstants.PATCH_ID);
        patchId = manifestMetaData;
        if (manifestMetaData == null) {
            patchId = getDefaultPatchId(context);
        }
        RFixLog.d(TAG, String.format("getManifestPatchID patchId=%s", patchId));
        return patchId;
    }
}
