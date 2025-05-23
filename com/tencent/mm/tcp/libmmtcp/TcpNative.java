package com.tencent.mm.tcp.libmmtcp;

import android.util.Log;
import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class TcpNative {
    public static int INIT_ERROR = -1002;
    public static int NEW_TCP_ERROR = -1000;
    public static int REPEAT_INIT_ERROR = -1001;
    public static int SEND_BUFFER_ERROR = -1003;
    public static String TAG = "TcpNative";
    private boolean initCallBackFlag = false;
    volatile long mNativeInst;

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public interface NativeCallBackInterface {
        @Keep
        void onCallBack(long j3, String str);
    }

    @Keep
    public TcpNative(long j3, long j16, long j17) {
        this.mNativeInst = 0L;
        Log.i(TAG, "TcpNative isolate:" + j3 + ",context:" + j16 + ",uvloop:" + j17);
        this.mNativeInst = initBindingTcp(j3, j16, j17);
    }

    private native void destoryBindingTcp(long j3);

    private native long initBindingTcp(long j3, long j16, long j17);

    private native int initCallBack(long j3, NativeCallBackInterface nativeCallBackInterface);

    private native void serviceReceive(String str, int i3, String str2);

    private native void testBindingTcp(long j3);

    private native void testBindingTcp2(long j3);

    private native void testBindingTcpServer(long j3);

    private native void updateNativeInterface(long j3, long j16);

    @Keep
    public void destoryTcp() {
        if (this.mNativeInst != -1 && this.initCallBackFlag) {
            this.initCallBackFlag = false;
            destoryBindingTcp(this.mNativeInst);
            this.mNativeInst = -1L;
        }
    }

    @Keep
    public int setCallBack(final NativeCallBackInterface nativeCallBackInterface) {
        if (this.mNativeInst == -1) {
            return NEW_TCP_ERROR;
        }
        if (!this.initCallBackFlag) {
            int initCallBack = initCallBack(this.mNativeInst, new NativeCallBackInterface() { // from class: com.tencent.mm.tcp.libmmtcp.TcpNative.1
                @Override // com.tencent.mm.tcp.libmmtcp.TcpNative.NativeCallBackInterface
                @Keep
                public void onCallBack(long j3, String str) {
                    nativeCallBackInterface.onCallBack(j3, str);
                }
            });
            if (initCallBack == 0) {
                this.initCallBackFlag = true;
                return initCallBack;
            }
            return INIT_ERROR;
        }
        return REPEAT_INIT_ERROR;
    }

    public void testBind() {
        if (this.mNativeInst == -1) {
            return;
        }
        testBindingTcp(this.mNativeInst);
    }

    public void testBind2() {
        if (this.mNativeInst == -1) {
            return;
        }
        testBindingTcp(this.mNativeInst);
    }

    public void testBindServer() {
        if (this.mNativeInst == -1) {
            return;
        }
        testBindingTcpServer(this.mNativeInst);
    }

    public void testServiceReceive(String str, int i3, String str2) {
        if (this.mNativeInst == -1) {
            return;
        }
        serviceReceive(str, i3, str2);
    }

    @Keep
    public void update(long j3) {
        if (this.mNativeInst == -1) {
            return;
        }
        updateNativeInterface(this.mNativeInst, j3);
    }
}
