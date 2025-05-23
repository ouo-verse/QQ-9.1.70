package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFloatValue(Object obj, String str, int i3) {
        if (!this.map.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap<String, float[]> hashMap = this.map.get(obj);
        if (!hashMap.containsKey(str)) {
            return Float.NaN;
        }
        float[] fArr = hashMap.get(str);
        if (fArr.length <= i3) {
            return Float.NaN;
        }
        return fArr[i3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFloatValue(Object obj, String str, int i3, float f16) {
        if (!this.map.containsKey(obj)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            float[] fArr = new float[i3 + 1];
            fArr[i3] = f16;
            hashMap.put(str, fArr);
            this.map.put(obj, hashMap);
            return;
        }
        HashMap<String, float[]> hashMap2 = this.map.get(obj);
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[i3 + 1];
            fArr2[i3] = f16;
            hashMap2.put(str, fArr2);
            this.map.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = hashMap2.get(str);
        if (fArr3.length <= i3) {
            fArr3 = Arrays.copyOf(fArr3, i3 + 1);
        }
        fArr3[i3] = f16;
        hashMap2.put(str, fArr3);
    }
}
