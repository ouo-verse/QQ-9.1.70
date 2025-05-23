package com.tencent.mobileqq.wink.editor.music.lyric;

import android.text.TextUtils;
import android.util.LruCache;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static LruCache<String, ArrayList<Double>> f320883a = new LruCache<>(10);

    /* renamed from: b, reason: collision with root package name */
    private static ArrayList<Double> f320884b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        if (f320883a != null && !TextUtils.isEmpty(str) && f320883a.get(str) != null) {
            f320884b = f320883a.get(str);
            return;
        }
        int min = Math.min(i3, 10000);
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i16 = 0; i16 < min; i16++) {
            arrayList.add(Double.valueOf(b()));
        }
        LruCache<String, ArrayList<Double>> lruCache = f320883a;
        if (lruCache != null) {
            lruCache.put(str, arrayList);
        }
        f320884b = arrayList;
    }

    private static double b() {
        double random = Math.random();
        if (random < 0.1d) {
            return random + 0.10000000149011612d;
        }
        return random;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double c(int i3) {
        ArrayList<Double> arrayList = f320884b;
        if (arrayList == null) {
            ms.a.a("WinkMusicWaveRandomGenerator", "obtainRandomValue() mRandoms == null.");
            return b();
        }
        if (i3 == arrayList.size()) {
            ms.a.a("WinkMusicWaveRandomGenerator", "obtainRandomValue() index == mRandoms.size().");
            double b16 = b();
            f320884b.add(i3, Double.valueOf(b16));
            return b16;
        }
        if (i3 < 0) {
            ms.a.a("WinkMusicWaveRandomGenerator", "obtainRandomValue() index < 0.");
            return b();
        }
        if (i3 > f320884b.size()) {
            ms.a.a("WinkMusicWaveRandomGenerator", "obtainRandomValue() index > mRandoms.size().");
            double b17 = b();
            for (int size = f320884b.size(); size <= i3; size++) {
                b17 = b();
                f320884b.add(size, Double.valueOf(b17));
            }
            return b17;
        }
        return f320884b.get(i3).doubleValue();
    }
}
