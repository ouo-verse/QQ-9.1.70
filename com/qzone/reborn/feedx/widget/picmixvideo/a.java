package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<Integer, HashMap<Integer, Pair<Integer, Integer>>> f56489a = new HashMap<>();

    public static void a(Context context, String str, int i3, int i16) {
        if (context == null || TextUtils.isEmpty(str)) {
            QLog.e("QZoneFeedXPicWHSaveUtils", 1, "addPicWidthHeight  error, context = " + context + " | picUrl = " + str);
            return;
        }
        if (i3 > 0 && i16 > 0) {
            int hashCode = context.hashCode();
            HashMap<Integer, Pair<Integer, Integer>> hashMap = f56489a.get(Integer.valueOf(hashCode));
            if (hashMap == null) {
                hashMap = new HashMap<>();
                f56489a.put(Integer.valueOf(hashCode), hashMap);
            }
            int hashCode2 = str.hashCode();
            hashMap.put(Integer.valueOf(hashCode2), new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16)));
            QLog.i("QZoneFeedXPicWHSaveUtils", 1, "addPicWidthHeight   | context = " + context + " | picUrl = " + str + " | contextHash = " + hashCode + " | picUrlHash = " + hashCode2 + " | width = " + i3 + " | height = " + i16);
            return;
        }
        QLog.e("QZoneFeedXPicWHSaveUtils", 1, "addPicWidthHeight  error,  width = " + i3 + " | height = " + i16);
    }

    public static void b(Context context) {
        if (context == null) {
            QLog.e("QZoneFeedXPicWHSaveUtils", 1, "clearPicWidthHeightData  error, context = null");
            return;
        }
        QLog.i("QZoneFeedXPicWHSaveUtils", 1, "clearPicWidthHeightData   | context = " + context + " | contextHash = " + context.hashCode());
        f56489a.remove(Integer.valueOf(context.hashCode()));
    }

    public static Pair<Integer, Integer> c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            int hashCode = context.hashCode();
            HashMap<Integer, Pair<Integer, Integer>> hashMap = f56489a.get(Integer.valueOf(hashCode));
            if (hashMap == null) {
                return null;
            }
            int hashCode2 = str.hashCode();
            Pair<Integer, Integer> pair = hashMap.get(Integer.valueOf(hashCode2));
            QLog.d("QZoneFeedXPicWHSaveUtils", 1, "getPicWidthHeight   | context = " + context + " | picUrl = " + str + " | contextHash = " + hashCode + " | picUrlHash = " + hashCode2 + " | pair = " + pair);
            return pair;
        }
        QLog.e("QZoneFeedXPicWHSaveUtils", 1, "getPicWidthHeight  error, context = " + context + " | picUrl = " + str);
        return null;
    }
}
