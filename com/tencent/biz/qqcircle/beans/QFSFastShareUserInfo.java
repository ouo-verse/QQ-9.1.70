package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFastShareUserInfo {
    private static final int MAX_INDEX = 3;
    private static final int NAME_INDEX = 0;
    private static final String SPLIT_FLAG = ",";
    public static final String SP_KEY_FAST_SHARE_USER_INFO = "sp_key_fast_share_user_info";
    private static final String TAG = "QFSFastShareUserInfo";
    private static final int TYPE_INDEX = 2;
    private static final int UIN_INDEX = 1;
    private final String mDisplayName;
    private final int mType;
    private final String mUin;

    public QFSFastShareUserInfo(@NonNull String str, @NonNull String str2, int i3) {
        this.mDisplayName = str;
        this.mUin = str2;
        this.mType = i3;
    }

    public static QFSFastShareUserInfo transferShareInfoFromString(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split.length != 3) {
            return null;
        }
        try {
            i3 = Integer.parseInt(split[2]);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "transferShareInfoFromString error: " + e16);
            i3 = 0;
        }
        return new QFSFastShareUserInfo(split[0], split[1], i3);
    }

    public static String transferShareInfoToString(QFSFastShareUserInfo qFSFastShareUserInfo) {
        if (qFSFastShareUserInfo != null && !TextUtils.isEmpty(qFSFastShareUserInfo.getDisplayName())) {
            return qFSFastShareUserInfo.getDisplayName() + "," + qFSFastShareUserInfo.getUin() + "," + String.valueOf(qFSFastShareUserInfo.getType());
        }
        return "";
    }

    public String getDisplayName() {
        return this.mDisplayName;
    }

    public int getType() {
        return this.mType;
    }

    public String getUin() {
        return this.mUin;
    }
}
