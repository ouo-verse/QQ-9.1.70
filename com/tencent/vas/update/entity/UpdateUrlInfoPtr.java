package com.tencent.vas.update.entity;

import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class UpdateUrlInfoPtr {
    private static final String TAG = "VasUpdate_UpdateUrlInfoPtr";
    public String mAppVersion;
    public long mBid;
    public int mCode;
    public int mCompressMode;
    public int mDeltaMode;
    public String mFileContent;
    public long mFileSize;
    public int mStorageMode;
    public String mUrl;
    public String mItemId = "";
    public String mScid = "";
    public String mDstMd5 = "";
    public String mSrcMd5 = "";
    public boolean isIgnoreDownload = false;

    public static UpdateUrlInfoPtr parseUpdateInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            UpdateUrlInfoPtr updateUrlInfoPtr = new UpdateUrlInfoPtr();
            updateUrlInfoPtr.mBid = jSONObject.optInt("bid");
            String optString = jSONObject.optString("scid");
            updateUrlInfoPtr.mScid = optString;
            updateUrlInfoPtr.mItemId = CommonUtil.sComposeItemId(updateUrlInfoPtr.mBid, optString);
            updateUrlInfoPtr.mDstMd5 = jSONObject.optString("dst_version");
            updateUrlInfoPtr.mSrcMd5 = jSONObject.optString("src_version");
            updateUrlInfoPtr.mDeltaMode = jSONObject.optInt("delta_mode");
            updateUrlInfoPtr.mStorageMode = jSONObject.optInt("storage_mode");
            updateUrlInfoPtr.mCompressMode = jSONObject.optInt("compress_mode");
            updateUrlInfoPtr.mUrl = jSONObject.optString("url");
            updateUrlInfoPtr.mFileSize = jSONObject.optLong("fileSize");
            updateUrlInfoPtr.mCode = jSONObject.optInt("code");
            updateUrlInfoPtr.mFileContent = jSONObject.optString("filecontent");
            updateUrlInfoPtr.mAppVersion = jSONObject.optString("appVersion");
            return updateUrlInfoPtr;
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "parseJsonToUpdateUrlInfoPtr error data = " + jSONObject.toString());
            return null;
        }
    }
}
