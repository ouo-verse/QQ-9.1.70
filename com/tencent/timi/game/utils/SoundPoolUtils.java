package com.tencent.timi.game.utils;

import android.media.SoundPool;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes26.dex */
public class SoundPoolUtils {

    /* renamed from: f, reason: collision with root package name */
    private static SoundPool.OnLoadCompleteListener f380278f;

    /* renamed from: g, reason: collision with root package name */
    private static SoundPool.OnLoadCompleteListener f380279g;

    /* renamed from: h, reason: collision with root package name */
    private static SoundPool.OnLoadCompleteListener f380280h;

    /* renamed from: i, reason: collision with root package name */
    private static SoundPool f380281i;

    /* renamed from: j, reason: collision with root package name */
    private static SoundPool f380282j;

    /* renamed from: k, reason: collision with root package name */
    private static SoundPool f380283k;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f380273a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Object> f380274b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Object> f380275c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<Integer, String> f380276d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<Integer, String> f380277e = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private static boolean f380284l = true;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f380285m = true;

    /* renamed from: n, reason: collision with root package name */
    private static ArrayList<Object> f380286n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    private static boolean f380287o = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f380288p = false;

    /* renamed from: q, reason: collision with root package name */
    private static Runnable f380289q = new Runnable() { // from class: com.tencent.timi.game.utils.SoundPoolUtils.4
        @Override // java.lang.Runnable
        public void run() {
            if (SoundPoolUtils.f380281i != null) {
                SoundPoolUtils.f380281i.release();
                SoundPoolUtils.f380279g = null;
                SoundPoolUtils.f380281i = null;
            }
            if (SoundPoolUtils.f380282j != null) {
                SoundPoolUtils.f380282j.release();
                SoundPoolUtils.f380280h = null;
                SoundPoolUtils.f380282j = null;
            }
            if (SoundPoolUtils.f380283k != null) {
                SoundPoolUtils.f380283k.release();
                SoundPoolUtils.f380278f = null;
                SoundPoolUtils.f380283k = null;
            }
        }
    };
}
