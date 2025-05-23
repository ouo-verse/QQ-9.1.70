package com.tencent.qzonehub.api.impl;

import com.qzone.reborn.util.i;
import com.qzone.util.ac;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QZoneMMKVApiImpl implements IQZoneMMKVApi {
    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public boolean getBooleanValue(String str, boolean z16) {
        return i.b().d(str, z16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public byte[] getBytes(String str, byte[] bArr) {
        return i.b().e(str, bArr);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public float getFloatValue(String str, float f16) {
        return i.b().f(str, f16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public int getIntValue(String str, int i3) {
        return i.b().g(str, i3);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public long getLongValue(String str, long j3) {
        return i.b().h(str, j3);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public String getStringValue(String str, String str2) {
        return i.b().j(str, str2);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public void handleSaveFeatureSwitch(Map<Integer, Boolean> map, String str) {
        ac.a(map, str);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public void saveBoolean(String str, boolean z16) {
        i.b().l(str, z16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public void saveBytes(String str, byte[] bArr) {
        i.b().m(str, bArr);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public void saveFloat(String str, float f16) {
        i.b().n(str, f16);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public void saveInt(String str, int i3) {
        i.b().o(str, i3);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public void saveLong(String str, long j3) {
        i.b().p(str, j3);
    }

    @Override // com.tencent.qzonehub.api.IQZoneMMKVApi
    public void saveString(String str, String str2) {
        i.b().r(str, str2);
    }
}
