package com.tencent.gamematrix.gmcg.webrtc.gamepad.hidusb;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes6.dex */
public class HIDKeyTracking {
    private static final String TAG = "HIDKeyTracking";
    private static long mDiffRecordTime;
    private static StringBuilder mSbTimes;
    private static StringBuilder mSbx;
    private static StringBuilder mSby;

    HIDKeyTracking() {
    }

    public static void trackBegin() {
        Log.d(TAG, "track begin!");
        StringBuilder sb5 = mSbTimes;
        if (sb5 != null) {
            sb5.setLength(0);
        } else {
            mSbTimes = new StringBuilder();
        }
        StringBuilder sb6 = mSbx;
        if (sb6 != null) {
            sb6.setLength(0);
        } else {
            mSbx = new StringBuilder();
        }
        StringBuilder sb7 = mSby;
        if (sb7 != null) {
            sb7.setLength(0);
        } else {
            mSby = new StringBuilder();
        }
        mDiffRecordTime = System.currentTimeMillis();
        StringBuilder sb8 = mSbTimes;
        if (sb8 != null) {
            sb8.append("times = [");
        }
        StringBuilder sb9 = mSbx;
        if (sb9 != null) {
            sb9.append("x = [");
        }
        StringBuilder sb10 = mSby;
        if (sb10 != null) {
            sb10.append("y = [");
        }
    }

    public static void trackEnd() {
        Log.d(TAG, "track end!");
        StringBuilder sb5 = mSbTimes;
        if (sb5 != null) {
            sb5.append("]");
            Log.d(TAG, mSbTimes.toString());
        }
        StringBuilder sb6 = mSbx;
        if (sb6 != null) {
            sb6.append("]");
            Log.d(TAG, mSbx.toString());
        }
        StringBuilder sb7 = mSby;
        if (sb7 != null) {
            sb7.append("]");
            Log.d(TAG, mSby.toString());
        }
        mDiffRecordTime = 0L;
        mSbTimes = null;
        mSbx = null;
        mSby = null;
    }

    public static void trackUpdate(int i3, int i16) {
        StringBuilder sb5 = mSbTimes;
        if (sb5 != null) {
            sb5.append(System.currentTimeMillis() - mDiffRecordTime);
            mSbTimes.append(";");
        }
        StringBuilder sb6 = mSbx;
        if (sb6 != null) {
            sb6.append(i3);
            mSbx.append(";");
        }
        StringBuilder sb7 = mSby;
        if (sb7 != null) {
            sb7.append(i16);
            mSby.append(";");
        }
    }
}
