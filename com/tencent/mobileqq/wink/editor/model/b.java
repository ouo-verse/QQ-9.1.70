package com.tencent.mobileqq.wink.editor.model;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<MetaCategory> f320589a;

    /* renamed from: b, reason: collision with root package name */
    private final List<MetaMaterial> f320590b;

    /* renamed from: c, reason: collision with root package name */
    private List<MetaMaterial> f320591c;

    public b(List<MetaCategory> list, List<MetaMaterial> list2) {
        this.f320589a = list;
        this.f320590b = list2;
    }

    public List<MetaCategory> a() {
        return this.f320589a;
    }

    public List<MetaMaterial> b() {
        return this.f320590b;
    }

    public List<MetaMaterial> c() {
        return this.f320591c;
    }

    public b(List<MetaCategory> list, List<MetaMaterial> list2, List<MetaMaterial> list3) {
        this.f320589a = list;
        this.f320590b = list2;
        this.f320591c = list3;
    }
}
