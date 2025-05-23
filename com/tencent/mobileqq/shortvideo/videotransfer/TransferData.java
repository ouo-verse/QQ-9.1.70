package com.tencent.mobileqq.shortvideo.videotransfer;

import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TransferData {
    public static final String KEY_CONFIG_DATA = "config_data";
    public static final String KEY_POSITION_LIST = "pos_list";
    public static final String KEY_REVERSE_SHIFT = "reverse_shift";
    public TransferConfig.ConfigData mConfigData = new TransferConfig.ConfigData();
    private ArrayList<Long> mPositionList = new ArrayList<>();
    private long mReverseShift = -100;

    public TransferData() {
        setConfigData(null);
        setPositions(null);
    }

    public void fromJSONObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.mConfigData.fromJSONObject(jSONObject.optString(KEY_CONFIG_DATA));
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_POSITION_LIST);
            this.mPositionList.clear();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    this.mPositionList.add(Long.valueOf(optJSONArray.getLong(i3)));
                }
            }
            this.mReverseShift = jSONObject.optLong(KEY_REVERSE_SHIFT);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public ArrayList<Long> getPositions() {
        return this.mPositionList;
    }

    public long getReverseShift() {
        return this.mReverseShift;
    }

    public void setConfigData(TransferConfig.ConfigData configData) {
        if (configData != null) {
            TransferConfig.ConfigData configData2 = this.mConfigData;
            configData2.mID = configData.mID;
            configData2.mVerShader = configData.mVerShader;
            configData2.mFragShader = configData.mFragShader;
            configData2.shaderList.clear();
            this.mConfigData.shaderList.addAll(configData.shaderList);
            TransferConfig.ConfigData configData3 = this.mConfigData;
            configData3.mDuration = configData.mDuration;
            configData3.mCommonFloat1 = configData.mCommonFloat1;
            configData3.mCommonFloat2 = configData.mCommonFloat2;
            configData3.mCommonFloat3 = configData.mCommonFloat3;
            configData3.mCommonFloat4 = configData.mCommonFloat4;
            configData3.mLevelEffectShader = configData.mLevelEffectShader;
            return;
        }
        this.mConfigData.mID = -1;
    }

    public void setPositions(ArrayList<Long> arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            this.mPositionList.addAll(arrayList);
            Collections.sort(this.mPositionList);
        } else {
            this.mPositionList.clear();
        }
    }

    public void setReverseShift(long j3) {
        this.mReverseShift = j3;
    }

    public String toJSONObject() {
        ArrayList<Long> arrayList = this.mPositionList;
        if (arrayList == null || arrayList.size() == 0 || !this.mConfigData.isValid()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(KEY_CONFIG_DATA, this.mConfigData.toJSONObject());
            jSONObject.put(KEY_REVERSE_SHIFT, this.mReverseShift);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.mPositionList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            jSONObject.put(KEY_POSITION_LIST, jSONArray);
            return jSONObject.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public TransferData(TransferConfig.ConfigData configData) {
        setConfigData(configData);
        setPositions(null);
    }

    public TransferData(ArrayList<Long> arrayList) {
        setPositions(arrayList);
        setConfigData(null);
    }
}
