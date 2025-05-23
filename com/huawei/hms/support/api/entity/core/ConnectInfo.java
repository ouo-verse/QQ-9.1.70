package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ConnectInfo implements IMessageEntity {

    /* renamed from: a, reason: collision with root package name */
    @Packed
    private List<String> f37539a;

    /* renamed from: b, reason: collision with root package name */
    @Packed
    private List<Scope> f37540b;

    /* renamed from: c, reason: collision with root package name */
    @Packed
    private String f37541c;

    /* renamed from: d, reason: collision with root package name */
    @Packed
    private String f37542d;

    public ConnectInfo() {
    }

    public List<String> getApiNameList() {
        return this.f37539a;
    }

    public String getFingerprint() {
        return this.f37541c;
    }

    public List<Scope> getScopeList() {
        return this.f37540b;
    }

    public String getSubAppID() {
        return this.f37542d;
    }

    public void setApiNameList(List<String> list) {
        this.f37539a = list;
    }

    public void setFingerprint(String str) {
        this.f37541c = str;
    }

    public void setScopeList(List<Scope> list) {
        this.f37540b = list;
    }

    public void setSubAppID(String str) {
        this.f37542d = str;
    }

    public ConnectInfo(List<String> list, List<Scope> list2, String str, String str2) {
        this.f37539a = list;
        this.f37540b = list2;
        this.f37541c = str;
        this.f37542d = str2;
    }
}
