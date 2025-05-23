package com.tencent.aelight.camera.struct.camera.material;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEMaterialCategory implements Cloneable {
    public ArrayList<MetaCategory> D;

    /* renamed from: d, reason: collision with root package name */
    public List<AEMaterialMetaData> f69044d;

    /* renamed from: e, reason: collision with root package name */
    public int f69045e;

    /* renamed from: f, reason: collision with root package name */
    public String f69046f;

    /* renamed from: h, reason: collision with root package name */
    public String f69047h;

    /* renamed from: i, reason: collision with root package name */
    public int f69048i = 2;

    /* renamed from: m, reason: collision with root package name */
    public boolean f69049m = false;
    public boolean C = true;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PlayShowLayout {
    }

    public AEMaterialCategory() {
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AEMaterialCategory clone() {
        AEMaterialCategory aEMaterialCategory = new AEMaterialCategory();
        aEMaterialCategory.f69047h = this.f69047h;
        aEMaterialCategory.f69045e = this.f69045e;
        aEMaterialCategory.f69046f = this.f69046f;
        aEMaterialCategory.f69048i = this.f69048i;
        aEMaterialCategory.f69049m = this.f69049m;
        ArrayList arrayList = new ArrayList();
        aEMaterialCategory.f69044d = arrayList;
        arrayList.addAll(this.f69044d);
        return aEMaterialCategory;
    }

    public int hashCode() {
        int hashCode;
        List<AEMaterialMetaData> list = this.f69044d;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        return 31 + hashCode;
    }

    public String toString() {
        return "AEMaterialCategory{categoryName='" + this.f69047h + "'}";
    }

    public AEMaterialCategory(String str) {
        this.f69047h = str;
    }
}
