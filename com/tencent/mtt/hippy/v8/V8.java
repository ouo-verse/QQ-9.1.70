package com.tencent.mtt.hippy.v8;

import com.tencent.mtt.hippy.common.Callback;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes20.dex */
public class V8 {

    /* renamed from: a, reason: collision with root package name */
    private final long f337704a;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface NearHeapLimitCallback {
    }

    public V8(long j3) {
        this.f337704a = j3;
    }

    private native void addNearHeapLimitCallback(long j3, NearHeapLimitCallback nearHeapLimitCallback);

    private native boolean getHeapCodeStatistics(long j3, Callback<Object> callback) throws NoSuchMethodException;

    private native boolean getHeapSpaceStatistics(long j3, Callback<ArrayList<Object>> callback) throws NoSuchMethodException;

    private native boolean getHeapStatistics(long j3, Callback<Object> callback) throws NoSuchMethodException;

    private native void printCurrentStackTrace(long j3, Callback<String> callback);

    private native void requestInterrupt(long j3, Callback<Void> callback);

    private native boolean writeHeapSnapshot(long j3, String str, Callback<Integer> callback) throws NoSuchMethodException;
}
