package com.tencent.mobileqq.config.business.qfile;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QFileFileReaderConfigBean implements rb1.a<String>, IQFileFileReaderConfigBean {
    public static final String KEY_BAR_SHOW_SWITCH = "barShowSwitch";
    public static final String TAG = "QFileFileReaderConfigBean<QFile>";
    public boolean isShowReaderBar = false;
    public String strConfigContent = "{}";

    @Override // com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean
    public boolean getIsShowReaderBar() {
        return this.isShowReaderBar;
    }

    @Override // com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean
    public void setIsShowReaderBar(boolean z16) {
        this.isShowReaderBar = z16;
    }

    @Override // rb1.a
    public void onParse(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "onParse: but configContent is null!");
        } else {
            this.strConfigContent = str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(KEY_BAR_SHOW_SWITCH)) {
                this.isShowReaderBar = jSONObject.getBoolean(KEY_BAR_SHOW_SWITCH);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, QLog.getStackTraceString(e16));
        }
    }
}
