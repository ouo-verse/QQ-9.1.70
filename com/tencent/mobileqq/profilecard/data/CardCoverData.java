package com.tencent.mobileqq.profilecard.data;

import com.tencent.mobileqq.profilecard.utils.ModelUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class CardCoverData {
    public static final int TYPE_DEFAULT = 3;
    public static final int TYPE_FILEPATH = 2;
    public static final int TYPE_URL = 1;
    public String text;
    public Integer type;

    public CardCoverData(int i3, String str) {
        this.type = Integer.valueOf(i3);
        this.text = str;
    }

    public static CardCoverData fromMap(Map map) {
        return (CardCoverData) ModelUtils.mapToObject(map, CardCoverData.class);
    }

    public static Map toMap(CardCoverData cardCoverData) {
        return ModelUtils.objectToMap(cardCoverData);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CardCoverData{type=");
        sb5.append(this.type);
        sb5.append(", text='");
        String str = this.text;
        if (str == null) {
            str = "null";
        }
        sb5.append(str);
        sb5.append('\'');
        sb5.append('}');
        return sb5.toString();
    }
}
