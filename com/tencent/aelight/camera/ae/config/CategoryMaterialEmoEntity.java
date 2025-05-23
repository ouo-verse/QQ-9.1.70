package com.tencent.aelight.camera.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.BubbleData;
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
public class CategoryMaterialEmoEntity extends Entity {
    public String additionalFields;
    public String bigId;
    public String bigName;
    public String bigThumbUrl;
    public String bubbleId;
    public String bubbleText;

    /* renamed from: id, reason: collision with root package name */
    public String f63473id;
    public String packageUrl;
    public int thumbHeight;
    public String thumbUrl;
    public int thumbWidth;

    public static List<CategoryMaterialEmoEntity> buildCategoryMaterialEntity(GetCategoryMaterialRsp getCategoryMaterialRsp) {
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator<MetaCategory> it = getCategoryMaterialRsp.Categories.iterator();
        while (it.hasNext()) {
            MetaCategory next = it.next();
            Iterator<MetaMaterial> it5 = next.materials.iterator();
            while (it5.hasNext()) {
                MetaMaterial next2 = it5.next();
                CategoryMaterialEmoEntity categoryMaterialEmoEntity = new CategoryMaterialEmoEntity();
                categoryMaterialEmoEntity.bigId = next.f30532id;
                categoryMaterialEmoEntity.bigName = next.name;
                categoryMaterialEmoEntity.bigThumbUrl = next.thumbUrl;
                BubbleData bubbleData = getCategoryMaterialRsp.BubbleData;
                String str2 = "";
                if (bubbleData == null || !bubbleData.Id.endsWith(next2.f30533id)) {
                    str = "";
                } else {
                    str = getCategoryMaterialRsp.BubbleData.Id;
                }
                categoryMaterialEmoEntity.bubbleId = str;
                BubbleData bubbleData2 = getCategoryMaterialRsp.BubbleData;
                if (bubbleData2 != null && bubbleData2.Id.endsWith(next2.f30533id)) {
                    str2 = getCategoryMaterialRsp.BubbleData.DisplayText;
                }
                categoryMaterialEmoEntity.bubbleText = str2;
                categoryMaterialEmoEntity.f63473id = next2.f30533id;
                categoryMaterialEmoEntity.thumbUrl = next2.thumbUrl;
                categoryMaterialEmoEntity.thumbWidth = next2.thumbWidth;
                categoryMaterialEmoEntity.thumbHeight = next2.thumbHeight;
                categoryMaterialEmoEntity.packageUrl = next2.packageUrl;
                categoryMaterialEmoEntity.additionalFields = mapToJson(next2.additionalFields);
                arrayList.add(categoryMaterialEmoEntity);
            }
        }
        return arrayList;
    }

    private static String mapToJson(Map<String, String> map) {
        return new Gson().toJson(map);
    }

    public String toString() {
        return "CategoryMaterialEmoEntity{bigId='" + this.bigId + "', bigName='" + this.bigName + "', bigThumbUrl='" + this.bigThumbUrl + "', id='" + this.f63473id + "', thumbUrl='" + this.thumbUrl + "', thumbWidth=" + this.thumbWidth + ", thumbHeight=" + this.thumbHeight + ", packageUrl='" + this.packageUrl + "', additionalFields='" + this.additionalFields + "', bubbleId='" + this.bubbleId + "', bubbleText='" + this.bubbleText + "'}";
    }
}
