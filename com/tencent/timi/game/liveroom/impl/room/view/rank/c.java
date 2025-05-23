package com.tencent.timi.game.liveroom.impl.room.view.rank;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqlive.data.room.LiveAudienceInfo;
import d55.j;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c {
    public static int a(Context context, int i3) {
        int i16;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i16 = R.color.bvq;
                } else {
                    i16 = R.color.bvp;
                }
            } else {
                i16 = R.color.bvo;
            }
        } else {
            i16 = R.color.bvn;
        }
        return context.getResources().getColor(i16);
    }

    public static String b(long j3) {
        if (j3 > SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
            try {
                return new BigDecimal(j3).movePointLeft(8).setScale(1, 4) + "\u4ebf";
            } catch (Exception unused) {
                return String.valueOf(j3);
            }
        }
        if (j3 > 10000) {
            return String.format("%.1f\u4e07", Float.valueOf(((float) j3) / 10000.0f));
        }
        return String.valueOf(j3);
    }

    public static long c(j jVar) {
        d55.a[] aVarArr;
        if (jVar != null && (aVarArr = jVar.f393088a) != null) {
            return Math.max(aVarArr.length, jVar.f393089b);
        }
        return 0L;
    }

    public static int d(String str) {
        int length;
        if (TextUtils.isEmpty(str) || (length = str.length()) == 1) {
            return 21;
        }
        if (length == 2) {
            return 16;
        }
        return 14;
    }

    public static List<LiveAudienceInfo> e(j jVar, int i3) {
        List subList;
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        if (jVar != null) {
            Collections.addAll(arrayList, jVar.f393088a);
        }
        if (i3 > 0 && arrayList.size() > i3) {
            subList = arrayList.subList(0, i3);
        } else {
            subList = arrayList.subList(0, arrayList.size());
        }
        ArrayList arrayList2 = new ArrayList();
        if (subList != null) {
            for (int i16 = 0; i16 < subList.size(); i16++) {
                d55.a aVar = (d55.a) subList.get(i16);
                LiveAudienceInfo liveAudienceInfo = new LiveAudienceInfo();
                liveAudienceInfo.contribution = aVar.f393050b;
                liveAudienceInfo.headUrl = aVar.f393052d;
                liveAudienceInfo.nick = aVar.f393053e;
                liveAudienceInfo.sex = aVar.f393054f;
                liveAudienceInfo.uid = aVar.f393049a;
                arrayList2.add(liveAudienceInfo);
            }
        }
        return arrayList2;
    }
}
