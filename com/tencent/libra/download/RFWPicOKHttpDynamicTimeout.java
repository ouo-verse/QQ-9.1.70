package com.tencent.libra.download;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes7.dex */
public class RFWPicOKHttpDynamicTimeout implements Interceptor {
    private static final int MAX_TIME_OUT = 120;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("RFWPicOKHttpDynamicTimeout");
    private static final int TIME_OUT_INTERVAL = 15;
    private volatile int mDynamicTimeOut = 0;

    public int getTimeOut() {
        return this.mDynamicTimeOut;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        int i3 = this.mDynamicTimeOut;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return chain.withReadTimeout(i3, timeUnit).withWriteTimeout(this.mDynamicTimeOut, timeUnit).proceed(request);
    }

    public synchronized void upDateTimeOut(boolean z16, int i3) {
        if (z16) {
            this.mDynamicTimeOut = Math.min(120, this.mDynamicTimeOut + 15);
        } else {
            this.mDynamicTimeOut = Math.max(15, this.mDynamicTimeOut - 15);
        }
        LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, i3, "[upDateTimeOut] isTimeOut:", Boolean.valueOf(z16), ",currentTimeOutConfig:", Integer.valueOf(this.mDynamicTimeOut));
    }
}
