package com.tencent.mobileqq.qcircle.api.utils;

import android.net.Uri;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    @NonNull
    private static JSONObject a(View view, boolean z16, int[] iArr) throws JSONException {
        int i3;
        int i16;
        int measuredWidth;
        int measuredHeight;
        JSONObject jSONObject = new JSONObject();
        if (z16) {
            i3 = (iArr[0] + (view.getMeasuredWidth() / 2)) - 1;
        } else {
            i3 = iArr[0];
        }
        if (z16) {
            i16 = (iArr[1] + (view.getMeasuredHeight() / 2)) - 1;
        } else {
            i16 = iArr[1];
        }
        if (z16) {
            measuredWidth = i3 + 2;
        } else {
            measuredWidth = iArr[0] + view.getMeasuredWidth();
        }
        if (z16) {
            measuredHeight = i16 + 2;
        } else {
            measuredHeight = view.getMeasuredHeight() + iArr[1];
        }
        jSONObject.put("left", i3);
        jSONObject.put("top", i16);
        jSONObject.put("right", measuredWidth);
        jSONObject.put("bottom", measuredHeight);
        return jSONObject;
    }

    public static String b(String str, View view, long j3, String str2, boolean z16) {
        if (str.isEmpty()) {
            return str;
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        c(buildUpon, str2, view, z16);
        if (j3 > 0) {
            buildUpon.appendQueryParameter(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(j3));
        }
        return buildUpon.build().toString();
    }

    private static void c(Uri.Builder builder, String str, View view, boolean z16) {
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        try {
            JSONObject a16 = a(view, z16, iArr);
            if (str != null) {
                builder.appendQueryParameter(QCircleSchemeAttr.Detail.COVER_CACHE_PATH, str);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("visibleRect", a16);
            builder.appendQueryParameter(QCircleSchemeAttr.Detail.NATIVE_POSITION, jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("QFSJumpLayerHelper", 1, "rebuildActionUrl error" + e16);
        }
    }
}
