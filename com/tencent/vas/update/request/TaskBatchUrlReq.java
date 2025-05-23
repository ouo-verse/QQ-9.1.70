package com.tencent.vas.update.request;

import android.text.TextUtils;
import com.tencent.vas.update.entity.Constants;
import com.tencent.vas.update.entity.UpdateUrlInfoPtr;
import com.tencent.vas.update.entity.db.ItemUpdateVerPtr;
import com.tencent.vas.update.util.CommonUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vw4.a;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TaskBatchUrlReq {
    private static final String TAG = "VasUpdate_TaskBatchUrlReq";
    private int mCurrentCookieId;
    private HashMap<String, a> mTaskMaps = new HashMap<>();

    private String getRequestContent(ArrayList<ItemUpdateVerPtr> arrayList, String str) {
        this.mCurrentCookieId = CommonUtil.generateCookieId();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cookie", this.mCurrentCookieId);
            jSONObject.put("delta_mode", 1);
            jSONObject.put("storage_mode", 1);
            jSONObject.put("compress_mode", 1);
            jSONObject.put("from", str);
            if (Constants.UpdateFrom.SILENT_UPDATE.equalsIgnoreCase(str)) {
                jSONObject.put(FileReaderHelper.OPEN_FILE_FROM_FORCE, 2);
            } else {
                jSONObject.put(FileReaderHelper.OPEN_FILE_FROM_FORCE, 1);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<ItemUpdateVerPtr> it = arrayList.iterator();
            while (it.hasNext()) {
                ItemUpdateVerPtr next = it.next();
                if (next != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    long sParseBidId = CommonUtil.sParseBidId(next.mItemId);
                    String sParseScid = CommonUtil.sParseScid(next.mItemId);
                    jSONObject2.put("bid", sParseBidId);
                    jSONObject2.put("scid", sParseScid);
                    jSONObject2.put("srcMd5", next.mSrcMd5);
                    jSONObject2.put("dstMd5", next.mDstMd5);
                    jSONArray.mo162put(jSONObject2);
                }
            }
            jSONObject.put("item_list", jSONArray);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (VasUpdateWrapper.getLog().isColorLevel()) {
            VasUpdateWrapper.getLog().d(TAG, "batchGetUrl request content = " + jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public void addTask(String str, a aVar) {
        VasUpdateWrapper.getLog().i(TAG, "addTask itemId = " + str);
        this.mTaskMaps.put(str, aVar);
    }

    public int getCookieId() {
        return this.mCurrentCookieId;
    }

    public String getRequest() {
        a value;
        ItemUpdateVerPtr h16;
        ArrayList<ItemUpdateVerPtr> arrayList = new ArrayList<>();
        String str = "";
        for (Map.Entry<String, a> entry : this.mTaskMaps.entrySet()) {
            if (entry != null && entry.getValue() != null && (h16 = (value = entry.getValue()).h()) != null) {
                if (!TextUtils.isEmpty(h16.mSrcMd5)) {
                    if (value.g(h16.mSrcMd5)) {
                        h16.mSrcMd5 = "";
                        VasUpdateWrapper.getLog().i(TAG, "getRequest item[" + h16.mItemId + "] need Redownload , reset md5");
                    } else {
                        VasUpdateWrapper.getLog().i(TAG, "getRequest item[" + h16.mItemId + "] file has downloaded , check update status");
                    }
                }
                str = h16.mFrom;
                arrayList.add(h16);
            }
        }
        return getRequestContent(arrayList, str);
    }

    public int getTaskCount() {
        return this.mTaskMaps.size();
    }

    public void handlePbResponse(int i3, TaskBatchUrlRsp taskBatchUrlRsp) {
        ArrayList<UpdateUrlInfoPtr> arrayList;
        if (taskBatchUrlRsp != null && (arrayList = taskBatchUrlRsp.mUpdateList) != null && arrayList.size() > 0) {
            Iterator<UpdateUrlInfoPtr> it = taskBatchUrlRsp.mUpdateList.iterator();
            while (it.hasNext()) {
                UpdateUrlInfoPtr next = it.next();
                if (next != null) {
                    a aVar = this.mTaskMaps.get(next.mItemId);
                    if (aVar != null) {
                        aVar.o(i3, next);
                    } else {
                        VasUpdateWrapper.getLog().i(TAG, "batch req handle pb response no match , itemId = " + next.mItemId);
                    }
                }
            }
        } else {
            if (taskBatchUrlRsp != null && taskBatchUrlRsp.mUpdateList != null) {
                VasUpdateWrapper.getLog().e(TAG, "handlePbResponse mUpdateList is empty");
            }
            for (Map.Entry<String, a> entry : this.mTaskMaps.entrySet()) {
                if (entry != null && entry.getValue() != null) {
                    entry.getValue().o(-1, null);
                }
            }
        }
        this.mTaskMaps.clear();
    }

    public boolean hasContainsTask(String str) {
        return this.mTaskMaps.containsKey(str);
    }

    public void onSendPbMsgError() {
        for (Map.Entry<String, a> entry : this.mTaskMaps.entrySet()) {
            if (entry != null && entry.getValue() != null) {
                entry.getValue().w();
            }
        }
    }
}
