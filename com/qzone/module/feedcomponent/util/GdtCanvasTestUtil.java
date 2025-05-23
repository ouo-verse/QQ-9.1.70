package com.qzone.module.feedcomponent.util;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.tencent.ditto.DittoAreaView;
import com.tencent.ditto.area.DittoArea;
import com.tencent.ditto.area.DittoAreaGroup;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GdtCanvasTestUtil {
    public static String areas2Json(Map<DittoArea, String> map) {
        String str;
        JSONArray jSONArray = new JSONArray();
        try {
            for (Map.Entry<DittoArea, String> entry : map.entrySet()) {
                DittoArea key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(value)) {
                    str = "root:" + key.getId();
                } else {
                    str = value + ":" + key.getId();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("hashcode", key.hashCode());
                jSONObject.put("id", str);
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 : getTrueBorder(key)) {
                    jSONArray2.put(i3);
                }
                jSONObject.put("border", jSONArray2);
                jSONArray.mo162put(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONArray.toString();
    }

    public static Map<DittoArea, String> getAllVisibleCanvasArea(FeedView feedView) {
        HashMap hashMap = new HashMap();
        getAllVisibleCanvasAreaForView(feedView, hashMap);
        return hashMap;
    }

    static Map<DittoArea, String> getAllVisibleCanvasAreaForCanvas(DittoArea dittoArea, Map<DittoArea, String> map, String str) {
        if (isVisible(dittoArea)) {
            map.put(dittoArea, str);
        }
        if (dittoArea instanceof DittoAreaGroup) {
            int i3 = 0;
            while (true) {
                DittoAreaGroup dittoAreaGroup = (DittoAreaGroup) dittoArea;
                if (i3 >= dittoAreaGroup.getChildCount()) {
                    break;
                }
                DittoArea childAt = dittoAreaGroup.getChildAt(i3);
                if (childAt != null) {
                    getAllVisibleCanvasAreaForCanvas(childAt, map, str + ":" + dittoArea.getId());
                }
                i3++;
            }
        }
        return map;
    }

    static int[] getTrueBorder(DittoArea dittoArea) {
        int i3;
        int i16;
        int[] iArr = new int[4];
        if (dittoArea.getHost() instanceof View) {
            i3 = 0;
            i16 = 0;
            for (View view = (View) dittoArea.getHost(); view != null && !(view instanceof FeedView); view = (View) view.getParent()) {
                i3 += view.getTop();
                i16 += view.getLeft();
            }
        } else {
            i3 = 0;
            i16 = 0;
        }
        for (DittoArea parent = dittoArea.getParent(); parent != null; parent = parent.getParent()) {
            i3 += parent.getTop();
            i16 += parent.getLeft();
        }
        iArr[0] = dittoArea.getLeft() + i16;
        iArr[1] = dittoArea.getTop() + i3;
        iArr[2] = i16 + dittoArea.getRight();
        iArr[3] = i3 + dittoArea.getBottom();
        return iArr;
    }

    static Map<DittoArea, String> getAllVisibleCanvasAreaForView(View view, Map<DittoArea, String> map) {
        int i3 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i3 >= viewGroup.getChildCount()) {
                return map;
            }
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                if (childAt instanceof DittoAreaView) {
                    getAllVisibleCanvasAreaForCanvas(((DittoAreaView) childAt).getCanvasArea(), map, "");
                } else if (childAt instanceof ViewGroup) {
                    getAllVisibleCanvasAreaForView(childAt, map);
                }
            }
            i3++;
        }
    }

    private static boolean isVisible(DittoArea dittoArea) {
        if (dittoArea == null || dittoArea.getVisibility() != 0) {
            return false;
        }
        int[] trueBorder = getTrueBorder(dittoArea);
        return (trueBorder[2] - trueBorder[0]) * (trueBorder[3] - trueBorder[1]) != 0;
    }
}
