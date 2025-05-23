package com.tencent.aelight.camera.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetCategoryMaterialRsp;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CategoryMaterialStoryEntity extends Entity {
    public String additionalFields;
    public String bigId;
    public String bigName;
    public String bigThumbUrl;

    /* renamed from: id, reason: collision with root package name */
    public String f63474id;
    public String packageUrl;
    public int thumbHeight;
    public String thumbUrl;
    public int thumbWidth;

    public static List<CategoryMaterialStoryEntity> buildCategoryMaterialEntity(GetCategoryMaterialRsp getCategoryMaterialRsp) {
        ArrayList arrayList = new ArrayList();
        Iterator<MetaCategory> it = getCategoryMaterialRsp.Categories.iterator();
        while (it.hasNext()) {
            MetaCategory next = it.next();
            Iterator<MetaMaterial> it5 = next.materials.iterator();
            while (it5.hasNext()) {
                MetaMaterial next2 = it5.next();
                CategoryMaterialStoryEntity categoryMaterialStoryEntity = new CategoryMaterialStoryEntity();
                categoryMaterialStoryEntity.bigId = next.f30532id;
                categoryMaterialStoryEntity.bigName = next.name;
                categoryMaterialStoryEntity.bigThumbUrl = next.thumbUrl;
                categoryMaterialStoryEntity.f63474id = next2.f30533id;
                categoryMaterialStoryEntity.thumbUrl = next2.thumbUrl;
                categoryMaterialStoryEntity.thumbWidth = next2.thumbWidth;
                categoryMaterialStoryEntity.thumbHeight = next2.thumbHeight;
                categoryMaterialStoryEntity.packageUrl = next2.packageUrl;
                categoryMaterialStoryEntity.additionalFields = mapToJson(next2.additionalFields);
                arrayList.add(categoryMaterialStoryEntity);
            }
        }
        return arrayList;
    }

    private static String mapToJson(Map<String, String> map) {
        return new Gson().toJson(map);
    }

    public String toString() {
        return "CategoryMaterialStoryEntity{bigId='" + this.bigId + "', bigName='" + this.bigName + "', bigThumbUrl='" + this.bigThumbUrl + "', id='" + this.f63474id + "', thumbUrl='" + this.thumbUrl + "', thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", packageUrl='" + this.packageUrl + "', additionalFields='" + this.additionalFields + "'}";
    }
}
