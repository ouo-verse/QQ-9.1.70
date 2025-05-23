package com.tencent.biz.pubaccount.persistence.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.impl.VasQQSettingMeImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PAAdPreloadTask extends Entity {
    public static final int NETWORK_TYPE_4G = 2;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int PRELOAD_STATE_FAILED = 4;
    public static final int PRELOAD_STATE_FINISH = 3;
    public static final int PRELOAD_STATE_LOADING = 2;
    public static final int PRELOAD_STATE_NEW = 1;
    public static final int SOURCE_PRELOAD_CONFIG = 1;
    public static final int SOURCE_PRELOAD_MESSAGE = 2;
    public static final int SOURCE_PRELOAD_PLAY = 3;
    public static final String TABLE_NAME = "PAAdPreloadTask";
    public String mUserUin = null;
    public String mTaskId = null;
    public String mMsgId = null;
    public String mVideoVid = null;
    public int mSource = 0;
    public long mReceiveTime = 0;
    public long mExpireTime = 0;
    public int mPreloadState = 0;
    public int mNetworkType = 1;

    public static int checkNetworkType(int i3) {
        if (i3 < 1 || i3 > 3) {
            return 1;
        }
        return i3;
    }

    public static ArrayList<PAAdPreloadTask> parserConfigTask(String str, String str2) {
        JSONObject jSONObject;
        long serverTimeMillis;
        long j3;
        ArrayList<PAAdPreloadTask> arrayList = new ArrayList<>();
        try {
            jSONObject = new JSONObject(str2);
            serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            j3 = jSONObject.getLong(VasQQSettingMeImpl.EXPIRE_TIME);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (j3 <= serverTimeMillis) {
            return arrayList;
        }
        String string = jSONObject.getString("task_id");
        int i3 = jSONObject.getInt("network_type");
        JSONArray jSONArray = jSONObject.getJSONArray("video_list");
        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
            PAAdPreloadTask pAAdPreloadTask = new PAAdPreloadTask();
            pAAdPreloadTask.mUserUin = str;
            pAAdPreloadTask.mTaskId = string;
            pAAdPreloadTask.mVideoVid = jSONObject2.getString("vid");
            pAAdPreloadTask.mSource = 1;
            pAAdPreloadTask.mReceiveTime = serverTimeMillis;
            pAAdPreloadTask.mExpireTime = j3;
            pAAdPreloadTask.mPreloadState = 1;
            pAAdPreloadTask.mNetworkType = checkNetworkType(i3);
            arrayList.add(pAAdPreloadTask);
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PAAdPreloadTask pAAdPreloadTask = (PAAdPreloadTask) obj;
        if (TextUtils.isEmpty(this.mUserUin) || !this.mUserUin.equals(pAAdPreloadTask.mUserUin)) {
            return false;
        }
        return this.mVideoVid.equals(pAAdPreloadTask.mVideoVid);
    }

    public int hashCode() {
        return (((this.mUserUin.hashCode() * 31) + this.mVideoVid.hashCode()) * 31) + this.mNetworkType;
    }

    public boolean isExpire() {
        if (this.mExpireTime < NetConnInfoCenter.getServerTimeMillis()) {
            return true;
        }
        return false;
    }

    public boolean isNetworkValid() {
        if ((this.mNetworkType & 1) != 0 && NetworkUtil.isWifiConnected(null)) {
            return true;
        }
        if ((this.mNetworkType & 2) != 0 && NetworkUtil.getSystemNetwork(BaseApplication.getContext()) == 4) {
            return true;
        }
        return false;
    }
}
