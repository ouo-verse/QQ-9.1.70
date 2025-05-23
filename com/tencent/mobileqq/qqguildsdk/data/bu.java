package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRolePermissionCategory;

/* compiled from: P */
/* loaded from: classes17.dex */
public class bu implements ek {

    /* renamed from: a, reason: collision with root package name */
    private final GProRolePermissionCategory f265781a;

    public bu(GProRolePermissionCategory gProRolePermissionCategory) {
        this.f265781a = gProRolePermissionCategory;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ek
    public int a() {
        return this.f265781a.getPackCount();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ek
    public String getName() {
        return this.f265781a.getName();
    }

    public String toString() {
        return "GProRolePermissionCategoryImpl{mCategory=" + this.f265781a + '}';
    }
}
