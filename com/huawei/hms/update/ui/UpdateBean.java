package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UpdateBean implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37649a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37650b;

    /* renamed from: c, reason: collision with root package name */
    private String f37651c;

    /* renamed from: d, reason: collision with root package name */
    private int f37652d;

    /* renamed from: e, reason: collision with root package name */
    private String f37653e;

    /* renamed from: f, reason: collision with root package name */
    private String f37654f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList f37655g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f37656h = true;

    public String getClientAppId() {
        return (String) a(this.f37653e);
    }

    public String getClientAppName() {
        return (String) a(this.f37654f);
    }

    public String getClientPackageName() {
        return (String) a(this.f37651c);
    }

    public int getClientVersionCode() {
        return ((Integer) a(Integer.valueOf(this.f37652d))).intValue();
    }

    public boolean getResolutionInstallHMS() {
        return this.f37650b;
    }

    public ArrayList getTypeList() {
        return (ArrayList) a(this.f37655g);
    }

    public boolean isHmsOrApkUpgrade() {
        return ((Boolean) a(Boolean.valueOf(this.f37649a))).booleanValue();
    }

    public boolean isNeedConfirm() {
        return ((Boolean) a(Boolean.valueOf(this.f37656h))).booleanValue();
    }

    public void setClientAppId(String str) {
        this.f37653e = str;
    }

    public void setClientAppName(String str) {
        this.f37654f = str;
    }

    public void setClientPackageName(String str) {
        this.f37651c = str;
    }

    public void setClientVersionCode(int i3) {
        this.f37652d = i3;
    }

    public void setHmsOrApkUpgrade(boolean z16) {
        this.f37649a = z16;
    }

    public void setNeedConfirm(boolean z16) {
        this.f37656h = z16;
    }

    public void setResolutionInstallHMS(boolean z16) {
        this.f37650b = z16;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f37655g = arrayList;
    }

    private static <T> T a(T t16) {
        return t16;
    }
}
