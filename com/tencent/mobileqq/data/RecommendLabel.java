package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RecommendLabel implements Serializable, Cloneable {
    public String bytes_name = null;
    public int edging_color;
    public int text_color;
    public int uint32_label_type;

    public static List<RecommendLabel> convertToRecommendLabel(List<? extends RecommendLabel> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RecommendLabel m173clone() {
        try {
            return (RecommendLabel) super.clone();
        } catch (CloneNotSupportedException e16) {
            QLog.w("RecommendLabel", 1, "clone error " + e16);
            return this;
        }
    }
}
