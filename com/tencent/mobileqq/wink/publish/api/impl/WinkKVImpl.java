package com.tencent.mobileqq.wink.publish.api.impl;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.wink.publish.api.IWinkKV;
import com.tencent.qphone.base.util.QLog;
import ga3.p;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkKVImpl implements IWinkKV {
    private static final String NAME = "wink_common_store";
    private static final String PATH = RFWApplication.getApplication().getApplicationContext().getFilesDir().getAbsolutePath() + "/wink_kv";
    private static final String TAG = "WinkKVImpl";
    private final p winkKV = new p.a(PATH, NAME).a();

    private void timeCostReport(long j3, String str, int i3) {
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public Map<String, Object> getAll() {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, Object> v3 = this.winkKV.v();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkkv_getall", v3.size());
        QLog.i(TAG, 1, "[putAll] timeCost: " + currentTimeMillis2 + "ms");
        return v3;
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public boolean getBoolean(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean x16 = this.winkKV.x(str);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_delete");
        QLog.i(TAG, 1, "[getBoolean] timeCost: " + currentTimeMillis2 + "ms");
        return x16;
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public double getDouble(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        double z16 = this.winkKV.z(str);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_delete");
        QLog.i(TAG, 1, "[getDouble] timeCost: " + currentTimeMillis2 + "ms");
        return z16;
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public float getFloat(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        float B = this.winkKV.B(str);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_delete");
        QLog.i(TAG, 1, "[getFloat] timeCost: " + currentTimeMillis2 + "ms");
        return B;
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public int getInt(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int D = this.winkKV.D(str);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_delete");
        QLog.i(TAG, 1, "[getInt] timeCost: " + currentTimeMillis2 + "ms");
        return D;
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public String getString(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        String H = this.winkKV.H(str);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_delete");
        QLog.i(TAG, 1, "[getString] timeCost: " + currentTimeMillis2 + "ms");
        return H;
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public void putAll(Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.winkKV.T(map);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            timeCostReport(currentTimeMillis2, "key_winkkv_getall", map.size());
            QLog.i(TAG, 1, "[putAll] timeCost: " + currentTimeMillis2 + "ms");
        }
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public void putBoolean(String str, boolean z16) {
        long currentTimeMillis = System.currentTimeMillis();
        this.winkKV.W(str, z16);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_add");
        QLog.i(TAG, 1, "[putBoolean] timeCost: " + currentTimeMillis2 + "ms");
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public void putDouble(String str, double d16) {
        long currentTimeMillis = System.currentTimeMillis();
        this.winkKV.X(str, d16);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_add");
        QLog.i(TAG, 1, "[putDouble] timeCost: " + currentTimeMillis2 + "ms");
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public void putFloat(String str, float f16) {
        long currentTimeMillis = System.currentTimeMillis();
        this.winkKV.Y(str, f16);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_add");
        QLog.i(TAG, 1, "[putFloat] timeCost: " + currentTimeMillis2 + "ms");
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public void putInt(String str, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        this.winkKV.Z(str, i3);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_add");
        QLog.i(TAG, 1, "[putInt] timeCost: " + currentTimeMillis2 + "ms");
    }

    @Override // com.tencent.mobileqq.wink.publish.api.IWinkKV
    public void putString(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        this.winkKV.d0(str, str2);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        timeCostReport(currentTimeMillis2, "key_winkdb_add");
        QLog.i(TAG, 1, "[putString] timeCost: " + currentTimeMillis2 + "ms");
    }

    private void timeCostReport(long j3, String str) {
        timeCostReport(j3, str, 1);
    }
}
