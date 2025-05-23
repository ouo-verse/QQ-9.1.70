package com.tencent.mm.websocket.libwcwss;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class WcwssNative {
    public static int INIT_ERROR = -1002;
    public static int NEW_WCWSS_ERROR = -1000;
    public static int REPEAT_INIT_ERROR = -1001;
    public static String TAG = "WcwssNative";
    private volatile long mNativeInst = 0;
    private volatile String mStrNativeInst = "0";
    private volatile boolean initCallBackFlag = false;

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public interface IWcWssReportListener {
        @Keep
        int getNetworkType();

        @Keep
        void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3);

        @Keep
        void onKvStat(int i3, String str);
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public interface IWcWssWebSocketListener {

        /* compiled from: P */
        @Keep
        /* loaded from: classes9.dex */
        public static class BindAndDnsReturn {
            public String hostIpStr;
            public int resultCode;
        }

        @Keep
        BindAndDnsReturn bindSocketToCellularAndDnsByCellular(int i3, String str);

        @Keep
        int doCertificateVerify(String str, long j3, String str2, byte[][] bArr);

        @Keep
        void onStateChange(String str, long j3, int i3);
    }

    private native void destoryBindingWcwss(long j3);

    private native void doOnRunningStateWcwss(String str, long j3);

    private native long initBindingWcwss(long j3, long j16, long j17);

    private native int initCallBack(long j3, IWcWssWebSocketListener iWcWssWebSocketListener, IWcWssReportListener iWcWssReportListener);

    private native void initConfigWcwss(String str, long j3, HashMap<String, String> hashMap);

    private native void initConfigWhiteBlackList(String str, long j3, ArrayList<String> arrayList, ArrayList<String> arrayList2);

    private native void testBindingWcwss(long j3);

    private native void updateNativeInterface(String str, long j3, long j16, int i3);

    @Keep
    public void destoryWcwss() {
        Log.i(TAG, "WcwssNative MMWcWss destoryWcwss mNativeInst:" + this.mNativeInst);
        if (this.mNativeInst != -1 && this.initCallBackFlag) {
            this.initCallBackFlag = false;
            destoryBindingWcwss(this.mNativeInst);
            this.mNativeInst = -1L;
        }
    }

    @Keep
    public void doOnRunningState() {
        doOnRunningStateWcwss(this.mStrNativeInst, this.mNativeInst);
    }

    @Keep
    public void initConfig(HashMap<String, String> hashMap) {
        initConfigWcwss(this.mStrNativeInst, this.mNativeInst, hashMap);
    }

    @Keep
    public void initConfigWhiteBlack(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        initConfigWhiteBlackList(this.mStrNativeInst, this.mNativeInst, arrayList, arrayList2);
    }

    @Keep
    public String initWcwss(long j3, long j16, long j17) {
        this.mNativeInst = initBindingWcwss(j3, j16, j17);
        this.mStrNativeInst = String.valueOf(this.mNativeInst);
        Log.i(TAG, "WcwssNative MMWcWss initWcwss str_contextId:" + this.mStrNativeInst);
        return this.mStrNativeInst;
    }

    @Keep
    public int setCallback(IWcWssWebSocketListener iWcWssWebSocketListener, IWcWssReportListener iWcWssReportListener) {
        if (this.mNativeInst == -1) {
            return NEW_WCWSS_ERROR;
        }
        if (!this.initCallBackFlag) {
            int initCallBack = initCallBack(this.mNativeInst, iWcWssWebSocketListener, iWcWssReportListener);
            if (initCallBack == 0) {
                this.initCallBackFlag = true;
                return initCallBack;
            }
            return INIT_ERROR;
        }
        return REPEAT_INIT_ERROR;
    }

    public void testBindWcwss(String str) {
        long parseLong = Long.parseLong(str);
        Log.e(TAG, "WcwssNative MMWcWss destoryWcwss contextId:" + str);
        Log.e(TAG, "WcwssNative MMWcWss destoryWcwss lcontextId:" + parseLong);
        testBindingWcwss(parseLong);
    }

    @Keep
    public void updateInterface(long j3, int i3) {
        updateNativeInterface(this.mStrNativeInst, this.mNativeInst, j3, i3);
    }
}
