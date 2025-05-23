package com.tencent.hippy.qq.update.sso;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class BundleInfo {
    private static final int MAX_PRE_DOWNLOAD_FAILED_CNT = 2;
    private static final String TAG = "BundleInfo";
    public String bundleMd5;
    public String bundleName;
    public long bundleSize;
    public int bundleVersion;
    public String diffPkgMd5;
    public long diffPkgSize;
    public String diffPkgUrl;
    public String diffQarFileMd5;
    public String downloadUrl;
    public boolean isUsePreDownload;
    public int maxPreDownloadFailedCnt;

    private boolean checkData() {
        if (!TextUtils.isEmpty(this.bundleName) && this.bundleVersion >= 0 && !TextUtils.isEmpty(this.bundleMd5) && !TextUtils.isEmpty(this.downloadUrl)) {
            return true;
        }
        return false;
    }

    public static BundleInfo fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        BundleInfo bundleInfo = new BundleInfo();
        bundleInfo.bundleName = jSONObject.optString("bundleName");
        bundleInfo.bundleVersion = jSONObject.optInt(HippyQQConstants.KEY_BUNDLE_VERSION, -1);
        bundleInfo.bundleMd5 = jSONObject.optString("bundleMd5");
        bundleInfo.downloadUrl = jSONObject.optString("downloadUrl");
        bundleInfo.bundleSize = jSONObject.optLong("bundleSize");
        bundleInfo.maxPreDownloadFailedCnt = jSONObject.optInt("maxFailedCnt", 2);
        boolean z16 = false;
        if (jSONObject.optInt("isUsePreDownload", 0) == 1) {
            z16 = true;
        }
        bundleInfo.isUsePreDownload = z16;
        JSONObject optJSONObject = jSONObject.optJSONObject("stDiffPkg");
        if (optJSONObject != null) {
            bundleInfo.diffPkgSize = optJSONObject.optLong("iSize");
            bundleInfo.diffPkgMd5 = optJSONObject.optString("sMd5");
            bundleInfo.diffQarFileMd5 = optJSONObject.optString("sTotalPkgMd5");
            bundleInfo.diffPkgUrl = optJSONObject.optString("sUrl");
        }
        if (!bundleInfo.checkData()) {
            return null;
        }
        return bundleInfo;
    }

    public static ArrayList<BundleInfo> parseBundleList(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 2, "[parseBundleInfo] json is empty.");
            return null;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("bundleList");
            if (optJSONArray == null) {
                QLog.i(TAG, 2, "[parseBundleInfo] array is null.");
                return null;
            }
            ArrayList<BundleInfo> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                BundleInfo fromJson = fromJson(optJSONArray.getJSONObject(i3));
                if (fromJson != null) {
                    arrayList.add(fromJson);
                }
            }
            return arrayList;
        } catch (Throwable th5) {
            QLog.i(TAG, 2, "[parseBundleInfo] e:" + th5);
            return null;
        }
    }

    public boolean canDiffUpdate(int i3) {
        if (i3 > 0 && hasDiffPkg()) {
            return HippyQQFileUtil.getJsBundleZipFile(this.bundleName, i3).exists();
        }
        return false;
    }

    public boolean checkMd5(String str, boolean z16) {
        String str2;
        if (str == null) {
            return false;
        }
        if (z16) {
            str2 = this.diffPkgMd5;
        } else {
            str2 = this.bundleMd5;
        }
        return str.equals(str2);
    }

    public File getDownloadFile(boolean z16) {
        if (z16) {
            return HippyQQFileUtil.getDiffPkgFile(this.bundleName, this.bundleVersion);
        }
        return HippyQQFileUtil.getJsBundleZipFile(this.bundleName, this.bundleVersion);
    }

    public boolean hasDiffPkg() {
        if (this.diffPkgSize > 0 && !TextUtils.isEmpty(this.diffPkgMd5) && !TextUtils.isEmpty(this.diffQarFileMd5) && !TextUtils.isEmpty(this.diffPkgUrl)) {
            return true;
        }
        return false;
    }
}
