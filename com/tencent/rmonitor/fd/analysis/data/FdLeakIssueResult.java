package com.tencent.rmonitor.fd.analysis.data;

import a14.c;
import com.tencent.rmonitor.fd.data.FdBaseResult;
import com.tencent.rmonitor.fd.data.FdCountable;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdLeakIssueResult extends FdBaseResult {
    public static final String TAG = "RMonitor_FdLeak_Result";
    private final Map<String, FdLeakIssue> fdAnalyzeResult = new HashMap();
    private final int fdCount;
    private List<FdLeakDumpResult> fdDumpList;
    private final int fdType;

    public FdLeakIssueResult(int i3, int i16) {
        this.fdType = i3;
        this.fdCount = i16;
    }

    private void a(String str, FdLeakIssue fdLeakIssue, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (FdCountable fdCountable : fdLeakIssue.getFeatures()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(fdCountable.getItem(), fdCountable.getCount());
                jSONArray.mo162put(jSONObject2);
            }
            jSONObject.put(str, jSONArray);
        } catch (JSONException e16) {
            c.b(TAG, "toJsonString failed: " + e16.getMessage());
        }
    }

    private void b(String str, FdLeakIssue fdLeakIssue, JSONArray jSONArray) {
        List<FdCountable> gcPaths = fdLeakIssue.getGcPaths();
        if (gcPaths == null) {
            return;
        }
        try {
            for (FdCountable fdCountable : gcPaths) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("call_stack", fdCountable.getItem());
                jSONObject.put("count", fdCountable.getCount());
                jSONObject.put("fd_issue_type", str);
                jSONArray.mo162put(jSONObject);
            }
        } catch (JSONException e16) {
            c.b(TAG, "toJsonString failed: " + e16.getMessage());
        }
    }

    public void addAnalyzeData(FdLeakIssue fdLeakIssue) {
        if (fdLeakIssue != null) {
            this.fdAnalyzeResult.put(fdLeakIssue.getIssueType(), fdLeakIssue);
        }
    }

    public Map<String, FdLeakIssue> getFdAnalyzeResult() {
        return this.fdAnalyzeResult;
    }

    public int getFdCount() {
        return this.fdCount;
    }

    public List<FdLeakDumpResult> getFdDumpList() {
        return this.fdDumpList;
    }

    public JSONObject getFdIssueContentJson() {
        JSONObject jSONObject = new JSONObject();
        for (String str : this.fdAnalyzeResult.keySet()) {
            FdLeakIssue fdLeakIssue = this.fdAnalyzeResult.get(str);
            if (fdLeakIssue != null) {
                a(str, fdLeakIssue, jSONObject);
            }
        }
        return jSONObject;
    }

    public int getFdType() {
        return this.fdType;
    }

    public JSONObject getStacksJson() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : this.fdAnalyzeResult.keySet()) {
            FdLeakIssue fdLeakIssue = this.fdAnalyzeResult.get(str);
            if (fdLeakIssue != null) {
                b(str, fdLeakIssue, jSONArray);
            }
        }
        try {
            jSONObject.put("ref_stacks", jSONArray);
        } catch (JSONException e16) {
            c.b(TAG, "getStacksJson failed: " + e16.getMessage());
        }
        return jSONObject;
    }

    public void setFdDumpList(List<FdLeakDumpResult> list) {
        this.fdDumpList = list;
    }

    public String toString() {
        return "FdLeakIssueResult{fdType=" + this.fdType + ", fdCount=" + this.fdCount + ", fdAnalyzeResult=" + getFdIssueContentJson() + ", " + getStacksJson() + "}";
    }
}
