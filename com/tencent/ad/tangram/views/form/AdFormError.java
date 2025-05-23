package com.tencent.ad.tangram.views.form;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public class AdFormError {
    public static final int ERROR_COMMIT = 4;
    public static final int ERROR_DUPLICATE = 7;
    public static final int ERROR_REGEX = 6;
    public static final int ERROR_REQUIRED = 5;
    public static final int ERROR_UNKNOWN = 3;
    public static final int SUCCESS_COMMIT = 1;
    public static final int SUCCESS_EDIT = 2;
    private static final String TAG = "AdFormError";
    public int index;
    public String title;
    public int type;

    public AdFormError(int i3, int i16, String str) {
        this.type = i3;
        this.index = i16;
        this.title = str;
    }

    @Nullable
    public String toString() {
        if (TextUtils.isEmpty(this.title)) {
            AdLog.e(TAG, "toString error");
            return null;
        }
        int i3 = this.type;
        if (i3 != 5) {
            if (i3 != 6) {
                AdLog.e(TAG, "toString error");
                return null;
            }
            return "\u8bf7\u586b\u5199\u6b63\u786e\u7684" + this.title;
        }
        return "\u8bf7\u586b\u5199" + this.title;
    }
}
