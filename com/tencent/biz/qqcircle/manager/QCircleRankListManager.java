package com.tencent.biz.qqcircle.manager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleRankListManager {
    private static final String TAG = "RANK-QCircleRankListManager";

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class UserMedalBean {
        public String backgroundUrl;
        public String describe;
        public String iconUrl;
        public boolean isChecked;
        public boolean isHighLight;
        public boolean isNew;
        public String jumpUrl;
        public String medalID;
        public String medalName;
        public int rank;
        public int type;

        public String getBackgroundUrl() {
            return this.backgroundUrl;
        }

        public String getDescribe() {
            return this.describe;
        }

        public String getIconUrl() {
            return this.iconUrl;
        }

        public String getJumpUrl() {
            return this.jumpUrl;
        }

        public String getMedalID() {
            return this.medalID;
        }

        public String getMedalName() {
            return this.medalName;
        }

        public int getRank() {
            return this.rank;
        }

        public int getType() {
            return this.type;
        }

        public boolean isChecked() {
            return this.isChecked;
        }

        public boolean isHighLight() {
            return this.isHighLight;
        }

        public boolean isNew() {
            return this.isNew;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class UserMedalListBean {
        public List<UserMedalBean> medalInfos;

        public List<UserMedalBean> getMedalInfos() {
            return this.medalInfos;
        }
    }

    public static List<UserMedalBean> parseUserMedalSource(String str) {
        try {
            UserMedalListBean userMedalListBean = (UserMedalListBean) new Gson().fromJson(str, new TypeToken<UserMedalListBean>() { // from class: com.tencent.biz.qqcircle.manager.QCircleRankListManager.1
            }.getType());
            if (userMedalListBean == null) {
                return null;
            }
            return userMedalListBean.getMedalInfos();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[parseUserMedalSource] handle fail, error:", th5);
            return null;
        }
    }
}
