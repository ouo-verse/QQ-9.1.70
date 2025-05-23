package com.tencent.mobileqq.ark.api.silk;

import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ArrayList<WeakReference<ArkSilkAudioPlayerWrapper>> f199158a = new ArrayList<>();

    public static void a(ArkSilkAudioPlayerWrapper arkSilkAudioPlayerWrapper) {
        f199158a.add(new WeakReference<>(arkSilkAudioPlayerWrapper));
    }

    public static void b() {
        Iterator<WeakReference<ArkSilkAudioPlayerWrapper>> it = f199158a.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
    }

    public static void c() {
        Iterator<WeakReference<ArkSilkAudioPlayerWrapper>> it = f199158a.iterator();
        while (it.hasNext()) {
            ArkSilkAudioPlayerWrapper arkSilkAudioPlayerWrapper = it.next().get();
            if (arkSilkAudioPlayerWrapper != null && arkSilkAudioPlayerWrapper.a()) {
                arkSilkAudioPlayerWrapper.f(5);
                arkSilkAudioPlayerWrapper.d();
            }
        }
    }
}
