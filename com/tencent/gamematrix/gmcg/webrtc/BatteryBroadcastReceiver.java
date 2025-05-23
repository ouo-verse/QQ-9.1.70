package com.tencent.gamematrix.gmcg.webrtc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes6.dex */
public class BatteryBroadcastReceiver extends BroadcastReceiver {
    public int mBatteryChargeCounter;
    public int mBatteryCurrent;
    public int mBatteryCycleCount;
    public int mBatteryFullCharge;
    public int mBatteryHealth;
    public byte mBatteryLevel;
    public float mBatteryPct = 100.0f;
    public boolean mBatteryPresent;
    public int mBatteryScale;
    public byte mBatteryStatus;
    public String mBatteryTechnology;
    public int mBatteryTemperature;
    public int mBatteryVoltage;
    public byte mChargeType;
    public boolean mChargerAcOnline;
    public boolean mChargerUsbOnline;
    public boolean mChargerWirelessOnline;
    public int mMaxChargingCurrent;
    public int mMaxChargingVoltage;
    private OnBatteryListener mOnBatteryListener;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface OnBatteryListener {
        void onBatteryChanged(float f16);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.mChargeType = (byte) intent.getIntExtra("plugged", -1);
        this.mBatteryStatus = (byte) intent.getIntExtra("status", -1);
        this.mBatteryLevel = (byte) intent.getIntExtra("level", -1);
        int intExtra = intent.getIntExtra("scale", -1);
        this.mBatteryScale = intExtra;
        float f16 = (this.mBatteryLevel * 100) / intExtra;
        this.mBatteryPct = f16;
        OnBatteryListener onBatteryListener = this.mOnBatteryListener;
        if (onBatteryListener != null) {
            onBatteryListener.onBatteryChanged(f16);
        }
    }

    public void setOnBatteryListener(OnBatteryListener onBatteryListener) {
        this.mOnBatteryListener = onBatteryListener;
    }
}
