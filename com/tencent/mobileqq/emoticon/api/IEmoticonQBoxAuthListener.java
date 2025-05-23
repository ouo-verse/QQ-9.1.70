package com.tencent.mobileqq.emoticon.api;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IEmoticonQBoxAuthListener {

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface AuthResultCode {
        public static final int RESULT_CODE_AUTH_DENY = 2;
        public static final int RESULT_CODE_AUTH_OK = 1;
    }

    void onGetAuthResult(int i3, String str);
}
