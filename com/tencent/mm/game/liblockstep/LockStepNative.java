package com.tencent.mm.game.liblockstep;

import android.util.Log;
import androidx.annotation.Keep;
import java.util.HashMap;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class LockStepNative {
    public static int INIT_ERROR = -1002;
    public static int NEW_LOCKSTEP_ERROR = -1000;
    public static int REPEAT_INIT_ERROR = -1001;
    public static String TAG = "LockStepNative";
    private boolean initCallBackFlag = false;
    volatile long mNativeInst;

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public interface ILockStepListener {
        @Keep
        void onCallBack(long j3, String str);
    }

    /* compiled from: P */
    @Keep
    /* loaded from: classes9.dex */
    public interface ILockStepReportListener {
        @Keep
        int getNetworkType();

        @Keep
        void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3);

        @Keep
        void onKvStat(int i3, String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements ILockStepListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILockStepListener f151688a;

        public a(ILockStepListener iLockStepListener) {
            this.f151688a = iLockStepListener;
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepListener
        public void onCallBack(long j3, String str) {
            this.f151688a.onCallBack(j3, str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements ILockStepReportListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ILockStepReportListener f151690a;

        public b(ILockStepReportListener iLockStepReportListener) {
            this.f151690a = iLockStepReportListener;
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
        public int getNetworkType() {
            return this.f151690a.getNetworkType();
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
        public void onIdKeyStat(int[] iArr, int[] iArr2, int[] iArr3) {
            this.f151690a.onIdKeyStat(iArr, iArr2, iArr3);
        }

        @Override // com.tencent.mm.game.liblockstep.LockStepNative.ILockStepReportListener
        public void onKvStat(int i3, String str) {
            this.f151690a.onKvStat(i3, str);
        }
    }

    @Keep
    public LockStepNative(long j3, long j16, long j17) {
        this.mNativeInst = 0L;
        this.mNativeInst = initBindingLockStep(j3, j16, j17);
    }

    private native void destoryBindingLockStep(long j3);

    private native long initBindingLockStep(long j3, long j16, long j17);

    private native int initCallBack(long j3, ILockStepListener iLockStepListener, ILockStepReportListener iLockStepReportListener);

    private static native void initConfigLockStep(long j3, HashMap<String, String> hashMap);

    public static native void test();

    private native void testLockStepBinding(long j3);

    private native void updateNativeUdpInterface(long j3, long j16);

    @Keep
    public void destoryLockStep() {
        if (this.mNativeInst != -1 && this.initCallBackFlag) {
            this.initCallBackFlag = false;
            destoryBindingLockStep(this.mNativeInst);
            this.mNativeInst = -1L;
        }
    }

    @Keep
    public void initConfig(HashMap<String, String> hashMap) {
        if (this.mNativeInst == -1) {
            return;
        }
        initConfigLockStep(this.mNativeInst, hashMap);
    }

    @Keep
    public int setCallback(ILockStepListener iLockStepListener, ILockStepReportListener iLockStepReportListener) {
        if (this.mNativeInst == -1) {
            return NEW_LOCKSTEP_ERROR;
        }
        if (!this.initCallBackFlag) {
            int initCallBack = initCallBack(this.mNativeInst, new a(iLockStepListener), new b(iLockStepReportListener));
            if (initCallBack == 0) {
                this.initCallBackFlag = true;
                return initCallBack;
            }
            return INIT_ERROR;
        }
        return REPEAT_INIT_ERROR;
    }

    public void testLockStepBinding() {
        if (this.mNativeInst == -1) {
            return;
        }
        testLockStepBinding(this.mNativeInst);
    }

    @Keep
    public void updateNativeInterface(long j3) {
        Log.i(TAG, "mmudp updateNativeInterface mNativeInst:" + this.mNativeInst + ",locksteplogicId:" + j3);
        if (this.mNativeInst == -1) {
            return;
        }
        updateNativeUdpInterface(this.mNativeInst, j3);
    }
}
