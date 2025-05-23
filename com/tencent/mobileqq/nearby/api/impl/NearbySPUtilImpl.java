package com.tencent.mobileqq.nearby.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.api.e;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

/* loaded from: classes33.dex */
public class NearbySPUtilImpl implements INearbySPUtil {
    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean checkPreload(String str) {
        return e.b(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public void clearCornerRedDot(String str) {
        e.c(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean contains(String str, String str2) {
        return e.d(str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean getDatingSessionSwitch(String str) {
        return e.f(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean getLocVisiblityForPeople(String str) {
        return e.g(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public SosoLbsInfo getNearbyLastLocation(String str) {
        return e.h(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public SharedPreferences getSharedPreferences(String str, String str2, int i3) {
        return e.i(str, str2, i3);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public int getUnreadCount(String str, String str2) {
        return e.j(str, str2);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public Object getValue(String str, String str2, Object obj) {
        return e.m(str, str2, obj);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean isObtainLocAllowed(String str) {
        return e.n(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public void preloadNearbyProcessSuc(String str) {
        e.o(str);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public void setNearbyLastLocation(String str, SosoLbsInfo sosoLbsInfo) {
        e.p(str, sosoLbsInfo);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean setObtainLocAllowed(String str, boolean z16) {
        return e.q(str, z16);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean setValue(String str, String str2, Object obj) {
        return e.t(str, str2, obj);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean setVisibilityForPeople(String str, boolean z16) {
        return e.u(str, z16);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean setVoteInfo(String str, long j3, int i3) {
        return e.v(str, j3, i3);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean contains(String str, String str2, int i3, String str3) {
        return e.e(str, str2, i3, str3);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public Object getValue(String str, String str2, int i3, String str3, Object obj) {
        return e.l(str, str2, i3, str3, obj);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean setValue(String str, String str2, int i3, String str3, Object obj) {
        return e.s(str, str2, i3, str3, obj);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public Object getValue(SharedPreferences sharedPreferences, String str, Object obj) {
        return e.k(sharedPreferences, str, obj);
    }

    @Override // com.tencent.mobileqq.nearby.api.INearbySPUtil
    public boolean setValue(SharedPreferences sharedPreferences, String str, Object obj) {
        return e.r(sharedPreferences, str, obj);
    }
}
