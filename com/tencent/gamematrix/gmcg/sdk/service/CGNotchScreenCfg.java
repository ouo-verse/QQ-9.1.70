package com.tencent.gamematrix.gmcg.sdk.service;

import android.graphics.Rect;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGNotchScreenCfg {
    public List<CGRect> boundingRects;
    public int rotation;
    public CGRect safeInsets;
    public int screenHeight;
    public int screenWidth;

    CGNotchScreenCfg(int i3, int i16, int i17, CGRect cGRect, List<CGRect> list) {
        this.screenWidth = i3;
        this.screenHeight = i16;
        this.rotation = i17;
        this.safeInsets = cGRect;
        this.boundingRects = list;
    }

    @Nullable
    public static CGNotchScreenCfg from(int i3, int i16, int i17, int i18, int i19, int i26, int i27, List<Rect> list) {
        int i28;
        if (i18 <= 0 && i19 <= 0 && i26 <= 0 && i27 <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (Rect rect : list) {
                arrayList.add(new CGRect(rect.left, rect.top, rect.right, rect.bottom));
            }
        }
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    i28 = 0;
                } else {
                    i28 = 270;
                }
            } else {
                i28 = 180;
            }
        } else {
            i28 = 90;
        }
        return new CGNotchScreenCfg(i3, i16, i28, new CGRect(i18, i19, i26, i27), arrayList);
    }

    public String flattenToJson() {
        return CGJsonUtil.toJson(this);
    }
}
