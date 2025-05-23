package com.tencent.mobileqq.utils.abtest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QConReqExtraInfo;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.l;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: classes20.dex */
public class ExpMgrListProcessor extends l<ExpMgrListData> {
    public static final int CONFIG_ID = 742;
    public static final String KEY_MGRTYPEID = "mgrTypeId";
    public static final String KEY_TABEXPRID = "tabExprId";
    public static final String TAG = "QQExpListProcessor";
    private static final ConcurrentHashMap<Integer, String> qqExpManageMapItems = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<Integer, String> getExpMapInfo() {
        return qqExpManageMapItems;
    }

    protected static void updateExpListConfiguration() {
        ExpMgrListData expMgrListData = (ExpMgrListData) am.s().x(CONFIG_ID);
        if (expMgrListData != null) {
            expMgrListData.parseExpListConf();
        }
        if (qqExpManageMapItems.isEmpty() && MobileQQ.sProcessId == 1) {
            ABTestUtil.log(TAG, "start Update ExpListConf on main process");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new QConReqExtraInfo(CONFIG_ID, true));
            am.i(arrayList);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<ExpMgrListData> clazz() {
        return ExpMgrListData.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        ABTestUtil.log(TAG, "onReqFailed code:" + i3);
    }

    @Override // com.tencent.mobileqq.config.l
    public String tabExperimentId() {
        return super.tabExperimentId();
    }

    @Override // com.tencent.mobileqq.config.l
    public String tabGroupId() {
        return super.tabGroupId();
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return CONFIG_ID;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.config.l
    @NonNull
    public ExpMgrListData migrateOldOrDefaultContent(int i3) {
        return new ExpMgrListData();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.config.l
    @Nullable
    public ExpMgrListData onParsed(ai[] aiVarArr) {
        if (aiVarArr == null || aiVarArr.length <= 0) {
            return null;
        }
        ABTestUtil.log(TAG, "onParsed conf length:" + aiVarArr.length);
        ai aiVar = aiVarArr[0];
        ExpMgrListData expMgrListData = new ExpMgrListData(aiVar.f202267a, aiVar.f202268b);
        expMgrListData.parseExpListConf();
        ABTestUtil.log(TAG, "onParsed expListContent:" + expMgrListData.toStr());
        return expMgrListData;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onUpdate(ExpMgrListData expMgrListData) {
        if (expMgrListData != null) {
            expMgrListData.parseExpListConf();
        }
        ABTestUtil.log("updateEntityInfoList by 742#onUpdate");
    }

    /* loaded from: classes20.dex */
    public static final class ExpMgrListData {
        public String content;
        public int taskId;

        public ExpMgrListData(int i3, String str) {
            this.taskId = i3;
            this.content = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseExpListConf() {
            if (TextUtils.isEmpty(this.content)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(this.content);
                int length = jSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    int optInt = jSONObject.optInt(ExpMgrListProcessor.KEY_MGRTYPEID);
                    ExpMgrListProcessor.qqExpManageMapItems.put(Integer.valueOf(optInt), jSONObject.optString(ExpMgrListProcessor.KEY_TABEXPRID));
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            ABTestUtil.log(ExpMgrListProcessor.TAG, ExpMgrListProcessor.qqExpManageMapItems.toString());
        }

        public String toStr() {
            return String.format("[taskId:%s, content:%s]", Integer.valueOf(this.taskId), this.content);
        }

        public ExpMgrListData() {
            this.taskId = -1;
            this.content = "";
        }
    }
}
