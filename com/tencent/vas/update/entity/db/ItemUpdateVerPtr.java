package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public class ItemUpdateVerPtr {
    private static final String TAG = "VasUpdate_ItemUpdateVerPtr";
    public String mAppVersion = "";
    public String mDstMd5;
    public String mFrom;
    public String mItemId;
    public long mLastRunTime;
    public int mRunCount;
    public String mSrcMd5;

    public static String convertItemUpdateVerPrtToJson(ItemUpdateVerPtr itemUpdateVerPtr) {
        if (itemUpdateVerPtr == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("itemId", itemUpdateVerPtr.mItemId);
            jSONObject.put("srcMd5", itemUpdateVerPtr.mSrcMd5);
            jSONObject.put("dstMd5", itemUpdateVerPtr.mDstMd5);
            jSONObject.put("from", itemUpdateVerPtr.mFrom);
            jSONObject.put("nLastRunTime", itemUpdateVerPtr.mLastRunTime);
            jSONObject.put("nRunCount", itemUpdateVerPtr.mRunCount);
            jSONObject.put("appVersion", itemUpdateVerPtr.mAppVersion);
        } catch (Exception e16) {
            e16.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "node ItemUpdate error ", e16);
        }
        return jSONObject.toString();
    }

    public static ItemUpdateVerPtr parseJsonToItemUpdateVerPrt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ItemUpdateVerPtr itemUpdateVerPtr = new ItemUpdateVerPtr();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.opt("nodeList") != null) {
                return null;
            }
            itemUpdateVerPtr.mItemId = jSONObject.optString("itemId");
            itemUpdateVerPtr.mSrcMd5 = jSONObject.optString("srcMd5");
            itemUpdateVerPtr.mDstMd5 = jSONObject.optString("dstMd5");
            itemUpdateVerPtr.mFrom = jSONObject.optString("from");
            itemUpdateVerPtr.mLastRunTime = jSONObject.optLong("nLastRunTime");
            itemUpdateVerPtr.mRunCount = jSONObject.optInt("nRunCount");
            itemUpdateVerPtr.mAppVersion = jSONObject.optString("appVersion");
            return itemUpdateVerPtr;
        } catch (Exception e16) {
            e16.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "node ItemUpdate error ", e16);
            return null;
        }
    }

    public boolean checkItemIsCurrentVersion() {
        String appVersion = VasUpdateWrapper.getCommonManager().getAppVersion();
        VasUpdateWrapper.getLog().e(TAG, "checkItemIsCurrentVersion itemId = " + this.mItemId + " localVersion = " + appVersion + " itemVersion = " + this.mAppVersion);
        if (TextUtils.isEmpty(this.mAppVersion) || appVersion == null || appVersion.compareTo(this.mAppVersion) >= 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return " itemId = " + this.mItemId + " mLastRunTime = " + this.mLastRunTime + " count = " + this.mRunCount + " from = " + this.mFrom;
    }
}
