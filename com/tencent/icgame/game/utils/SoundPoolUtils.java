package com.tencent.icgame.game.utils;

import android.media.SoundPool;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class SoundPoolUtils {

    /* renamed from: f, reason: collision with root package name */
    private static SoundPool.OnLoadCompleteListener f116081f;

    /* renamed from: g, reason: collision with root package name */
    private static SoundPool.OnLoadCompleteListener f116082g;

    /* renamed from: h, reason: collision with root package name */
    private static SoundPool.OnLoadCompleteListener f116083h;

    /* renamed from: i, reason: collision with root package name */
    private static SoundPool f116084i;

    /* renamed from: j, reason: collision with root package name */
    private static SoundPool f116085j;

    /* renamed from: k, reason: collision with root package name */
    private static SoundPool f116086k;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Object> f116076a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Object> f116077b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Object> f116078c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<Integer, String> f116079d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private static HashMap<Integer, String> f116080e = new HashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private static boolean f116087l = true;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f116088m = true;

    /* renamed from: n, reason: collision with root package name */
    private static ArrayList<Object> f116089n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    private static boolean f116090o = false;

    /* renamed from: p, reason: collision with root package name */
    private static boolean f116091p = false;

    /* renamed from: q, reason: collision with root package name */
    private static Runnable f116092q = new Runnable() { // from class: com.tencent.icgame.game.utils.SoundPoolUtils.4
        @Override // java.lang.Runnable
        public void run() {
            if (SoundPoolUtils.f116084i != null) {
                SoundPoolUtils.f116084i.release();
                SoundPoolUtils.f116082g = null;
                SoundPoolUtils.f116084i = null;
            }
            if (SoundPoolUtils.f116085j != null) {
                SoundPoolUtils.f116085j.release();
                SoundPoolUtils.f116083h = null;
                SoundPoolUtils.f116085j = null;
            }
            if (SoundPoolUtils.f116086k != null) {
                SoundPoolUtils.f116086k.release();
                SoundPoolUtils.f116081f = null;
                SoundPoolUtils.f116086k = null;
            }
        }
    };
}
