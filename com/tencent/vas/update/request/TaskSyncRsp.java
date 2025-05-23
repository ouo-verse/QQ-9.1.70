package com.tencent.vas.update.request;

import android.text.TextUtils;
import com.tencent.vas.update.entity.db.Preload;
import com.tencent.vas.update.entity.db.SyncItemRecord;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TaskSyncRsp {
    public int mContinueFlag;
    public int mPollTime;
    public Preload mPreaload;
    public long mSeq;
    public int mSyncSwitch;
    public ArrayList<SyncItemRecord> mVcrList;

    public static TaskSyncRsp parseResponseJson(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            TaskSyncRsp taskSyncRsp = new TaskSyncRsp();
            JSONObject jSONObject = new JSONObject(str);
            taskSyncRsp.mSeq = jSONObject.optLong("seq");
            taskSyncRsp.mPollTime = jSONObject.optInt("polltime");
            taskSyncRsp.mSyncSwitch = jSONObject.optInt("syncSwitch");
            taskSyncRsp.mContinueFlag = jSONObject.optInt("continueFlag");
            taskSyncRsp.mVcrList = SyncItemRecord.parseVcrList(jSONObject.optJSONArray("vcr_list"));
            taskSyncRsp.mPreaload = Preload.parseJsonToPreaload(jSONObject.optJSONObject("preload"));
            return taskSyncRsp;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String toString() {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("TaskSyncRsp{mSeq=");
        sb5.append(this.mSeq);
        sb5.append(", mPollTime=");
        sb5.append(this.mPollTime);
        sb5.append(", mSyncSwitch=");
        sb5.append(this.mSyncSwitch);
        sb5.append(", mContinueFlag=");
        sb5.append(this.mContinueFlag);
        sb5.append(", mVcrListSize=");
        ArrayList<SyncItemRecord> arrayList = this.mVcrList;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        sb5.append(i3);
        sb5.append('}');
        return sb5.toString();
    }
}
