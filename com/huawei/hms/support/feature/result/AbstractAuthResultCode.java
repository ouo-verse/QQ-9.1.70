package com.huawei.hms.support.feature.result;

import android.text.TextUtils;
import com.huawei.hms.common.api.CommonStatusCodes;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class AbstractAuthResultCode extends CommonStatusCodes {
    public static final int RESULT_CODE_CANCELLED = 2012;
    public static final int RESULT_CODE_EXECUTING = 2013;
    public static final int RESULT_CODE_FAILED = 2014;
    public static final int SIGN_IN_JSONEXCEPTION = 2015;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, String> f37564a;

    static {
        HashMap hashMap = new HashMap();
        f37564a = hashMap;
        hashMap.put(2012, "Auth canceled by subscriber");
        hashMap.put(2013, "Auth executing");
        hashMap.put(2014, "An unrecoverable auth failure occurred");
    }

    public static String getResultDescription(int i3) {
        String str = f37564a.get(Integer.valueOf(i3));
        if (TextUtils.isEmpty(str)) {
            return "unknown status code: " + i3;
        }
        return str;
    }
}
