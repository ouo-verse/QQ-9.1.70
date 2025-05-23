package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import c01.c;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GalleryCardData {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GalleryCardData.class, PhotoCategorySummaryInfo.AVATAR_URL, "getAvatarUrl()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GalleryCardData.class, "transformScale", "getTransformScale()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GalleryCardData.class, "transformTranslateX", "getTransformTranslateX()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GalleryCardData.class, "opacity", "getOpacity()F", 0)};
    public final ReadWriteProperty avatarUrl$delegate = c.a("");
    public final ReadWriteProperty transformScale$delegate = c.a(Float.valueOf(0.75f));
    public final ReadWriteProperty transformTranslateX$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty opacity$delegate = c.a(Float.valueOf(1.0f));

    public final float getTransformTranslateX() {
        return ((Number) this.transformTranslateX$delegate.getValue(this, $$delegatedProperties[2])).floatValue();
    }
}
