package com.tencent.mobileqq.qqexpand.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.bean.feed.b;
import com.tencent.mobileqq.qqexpand.feed.LabelInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes35.dex */
public class h {
    public static LabelInfo a(com.tencent.mobileqq.qqexpand.bean.feed.b bVar, Context context) {
        String valueOf;
        Drawable drawable;
        String str;
        String str2;
        if (bVar == null) {
            return null;
        }
        int i3 = bVar.mGender;
        if (i3 != 1 && i3 != 2 && bVar.mAge == -1) {
            return null;
        }
        LabelInfo labelInfo = new LabelInfo();
        labelInfo.f263546a = bVar.mGender == 2 ? 0 : 1;
        int i16 = bVar.mAge;
        if (i16 == -1) {
            valueOf = "";
        } else {
            valueOf = String.valueOf(i16);
        }
        labelInfo.f263547b = valueOf;
        int i17 = bVar.mGender;
        if (i17 == 1 || i17 == 2) {
            if (i17 == 2) {
                drawable = context.getResources().getDrawable(R.drawable.f161744ne2);
            } else {
                drawable = context.getResources().getDrawable(R.drawable.f161745ne3);
            }
            labelInfo.f263550e = drawable;
            int i18 = bVar.mGender;
            if (i18 == 2) {
                str = "#FF80BF";
            } else {
                str = "#02B2DD";
            }
            labelInfo.f263548c = str;
            if (i18 == 2) {
                str2 = "#33FF80BF";
            } else {
                str2 = "#3300CAFC";
            }
            labelInfo.f263549d = str2;
        }
        return labelInfo;
    }

    public static List<LabelInfo> b(com.tencent.mobileqq.qqexpand.bean.feed.b bVar, Context context) {
        List<b.a> list;
        if (bVar == null || (list = bVar.mLabelInfos) == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] stringArray = context.getResources().getStringArray(R.array.f155231cc);
        String[] stringArray2 = context.getResources().getStringArray(R.array.f155230cb);
        for (int i3 = 0; i3 < bVar.mLabelInfos.size(); i3++) {
            LabelInfo labelInfo = new LabelInfo();
            labelInfo.f263550e = null;
            labelInfo.f263546a = 3;
            String str = bVar.mLabelInfos.get(i3).f263487b;
            labelInfo.f263547b = str;
            if (!TextUtils.isEmpty(str)) {
                char charAt = TextUtils.isEmpty(labelInfo.f263547b) ? (char) 0 : labelInfo.f263547b.charAt(0);
                labelInfo.f263548c = stringArray[charAt % stringArray.length];
                labelInfo.f263549d = stringArray2[charAt % stringArray2.length];
                arrayList.add(labelInfo);
            }
        }
        return arrayList;
    }

    public static LabelInfo c(com.tencent.mobileqq.qqexpand.bean.feed.b bVar, Context context) {
        if (bVar == null) {
            return null;
        }
        LabelInfo labelInfo = new LabelInfo();
        labelInfo.f263546a = 2;
        labelInfo.f263547b = String.valueOf(bVar.mPopularity);
        labelInfo.f263548c = "#8173FF";
        labelInfo.f263549d = "#338173FF";
        labelInfo.f263550e = context.getResources().getDrawable(R.drawable.f161746ne4);
        return labelInfo;
    }
}
