package com.tencent.mobileqq.emosm.favroaming;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface l {
    Drawable a(Drawable drawable, int i3);

    int b();

    boolean c(EmoticonFromGroupEntity emoticonFromGroupEntity);

    void d(List<EmoticonFromGroupEntity> list);

    String e(String str, int i3, String str2);

    Map<String, List<EmoticonFromGroupEntity>> f(List<EmoticonFromGroupEntity> list);

    void g();

    boolean h(List<CustomEmotionData> list, EmoticonFromGroupEntity emoticonFromGroupEntity);

    void i(List<EmoticonFromGroupEntity> list);

    Drawable j(EmoticonFromGroupEntity emoticonFromGroupEntity, int i3, int i16, Drawable drawable);
}
