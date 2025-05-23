package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class QCirclePolymerizeDetailBean extends QCircleInitBean {
    private static final String KEY_GROUP_UIN = "xsj_share_from_group_id";
    private static final String TAG = "QCirclePolymerizeDetailBean";
    private String mDstUin;
    private int mPageId = -1;
    private int mSourceType;
    private String mTransData;
    private QFSTransitionAnimBean mTransitionAnimBean;

    public String getDstUin() {
        if (this.mTransData == null) {
            return super.getUin();
        }
        String str = this.mDstUin;
        if (str == null || TextUtils.isEmpty(str)) {
            try {
                this.mDstUin = new JSONObject(this.mTransData).getString("dstuin");
            } catch (Exception e16) {
                this.mDstUin = "";
                e16.printStackTrace();
            }
        }
        return this.mDstUin;
    }

    public long getGroupId() {
        try {
            HashMap<String, String> hashMap = this.mSchemeAttrs;
            if (hashMap != null && hashMap.containsKey("xsj_share_from_group_id")) {
                String str = this.mSchemeAttrs.get("xsj_share_from_group_id");
                QLog.d(TAG, 1, "getGroupId:" + str);
                return Long.parseLong(str);
            }
            return 0L;
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0L;
        }
    }

    public int getPageId() {
        return this.mPageId;
    }

    public int getSourceType() {
        return this.mSourceType;
    }

    public String getTransData() {
        return this.mTransData;
    }

    public QFSTransitionAnimBean getTransitionAnimBean() {
        return this.mTransitionAnimBean;
    }

    public void setPageId(int i3) {
        this.mPageId = i3;
    }

    @Override // com.tencent.biz.qqcircle.beans.QCircleInitBean
    public void setSourceType(int i3) {
        this.mSourceType = i3;
    }

    public void setTransData(String str) {
        this.mTransData = str;
    }

    public void setTransitionAnimBean(QFSTransitionAnimBean qFSTransitionAnimBean) {
        this.mTransitionAnimBean = qFSTransitionAnimBean;
    }
}
