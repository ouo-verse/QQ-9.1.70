package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QIMNotifyAddFriend extends Entity {
    public int age;
    public String coverStory;
    public int gender;
    public String nickName;
    public long pushTime;
    public long qqUin;
    public long storyTotalNum;

    @unique
    public long uin;
    public String videoInfoPacked;
    public String wording;
    public boolean hasShowToast = false;
    public boolean hasRead = false;

    @notColumn
    public List<VideoInfo> videoInfos = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class VideoInfo {
        public String coverUrl;
        public String videoVid;

        public String toString() {
            return "VideoInfo{coverUrl='" + this.coverUrl + "', videoVid='" + this.videoVid + "'}";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.uin == ((QIMNotifyAddFriend) obj).uin) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j3 = this.uin;
        return (int) (j3 ^ (j3 >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.postRead();
        if (!TextUtils.isEmpty(this.videoInfoPacked)) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.videoInfoPacked);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i3);
                    VideoInfo videoInfo = new VideoInfo();
                    videoInfo.coverUrl = jSONObject.optString("coverUrl");
                    videoInfo.videoVid = jSONObject.optString("videoVid");
                    arrayList.add(videoInfo);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.videoInfos = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        super.prewrite();
        if (this.videoInfos.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (VideoInfo videoInfo : this.videoInfos) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("coverUrl", videoInfo.coverUrl);
                    jSONObject.put("videoVid", videoInfo.videoVid);
                    jSONArray.mo162put(jSONObject);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            this.videoInfoPacked = jSONArray.toString();
        }
    }

    public String toString() {
        return "QIMNotifyAddFriend{uin=" + this.uin + "qqUin=" + this.qqUin + ", storyTotalNum=" + this.storyTotalNum + ", nickName='" + this.nickName + "', wording='" + this.wording + "', coverStory='" + this.coverStory + "', gender=" + this.gender + ", age=" + this.age + ", pushTime=" + this.pushTime + ", hasShowToast=" + this.hasShowToast + ", hasRead=" + this.hasRead + ", videoInfos=" + this.videoInfos + '}';
    }
}
