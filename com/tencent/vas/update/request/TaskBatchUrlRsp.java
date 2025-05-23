package com.tencent.vas.update.request;

import android.text.TextUtils;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TaskBatchUrlRsp {
    public int mCookie;
    public ArrayList<UpdateUrlInfoPtr> mUpdateList;

    public static TaskBatchUrlRsp parseResponse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            TaskBatchUrlRsp taskBatchUrlRsp = new TaskBatchUrlRsp();
            JSONObject jSONObject = new JSONObject(str);
            taskBatchUrlRsp.mCookie = jSONObject.optInt("cookie");
            ArrayList<UpdateUrlInfoPtr> arrayList = new ArrayList<>();
            if (jSONObject.has("update_list")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("update_list");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    UpdateUrlInfoPtr parseUpdateInfo = UpdateUrlInfoPtr.parseUpdateInfo(optJSONArray.getJSONObject(i3));
                    if (parseUpdateInfo != null) {
                        arrayList.add(parseUpdateInfo);
                    }
                }
            }
            taskBatchUrlRsp.mUpdateList = arrayList;
            return taskBatchUrlRsp;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }
}
