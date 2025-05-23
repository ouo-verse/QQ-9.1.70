package com.huawei.hms.hihealth.data;

import android.os.Parcelable;
import com.huawei.hms.health.aabq;
import com.huawei.hms.health.aabv;
import com.huawei.hms.health.aabw;
import com.huawei.hms.health.aaby;
import java.util.List;

/* loaded from: classes2.dex */
public class SamplePointValueDetail extends aabq {
    public static final Parcelable.Creator<SamplePointValueDetail> CREATOR = new aabq.aab(SamplePointValueDetail.class);
    private static final String TAG = "SamplePointValueDetail";

    @aaby(id = 5)
    private String mFieldName;

    @aaby(id = 2)
    private double mFloatValue;

    @aaby(id = 1)
    private int mIntegerValue;

    @aaby(id = 4)
    private List<MapValue> mMapValueInfoList;

    @aaby(id = 3)
    private String mStringValue;

    @aabw
    public SamplePointValueDetail(@aabv(id = 1) int i3, @aabv(id = 2) double d16, @aabv(id = 3) String str, @aabv(id = 4) List<MapValue> list, @aabv(id = 5) String str2) {
        this.mIntegerValue = i3;
        this.mFloatValue = d16;
        this.mStringValue = str;
        this.mMapValueInfoList = list;
        this.mFieldName = str2;
    }

    public double getDoubleValue() {
        return this.mFloatValue;
    }

    public String getFieldName() {
        return this.mFieldName;
    }

    public int getIntegerValue() {
        return this.mIntegerValue;
    }

    public List<MapValue> getMapValue() {
        return this.mMapValueInfoList;
    }

    public String getStringValue() {
        return this.mStringValue;
    }

    public void setFieldName(String str) {
        this.mFieldName = str;
    }

    public void setFloatValue(double d16) {
        this.mFloatValue = d16;
    }

    public void setIntegerValue(int i3) {
        this.mIntegerValue = i3;
    }

    public void setMapValueInfo(MapValue mapValue) {
        this.mMapValueInfoList.add(mapValue);
    }

    public void setStringValue(String str) {
        this.mStringValue = str;
    }

    public SamplePointValueDetail(int i3, List<MapValue> list, double d16, String str, String str2) {
        this.mIntegerValue = i3;
        this.mFloatValue = d16;
        this.mStringValue = str;
        this.mMapValueInfoList = list;
        this.mFieldName = str2;
    }
}
