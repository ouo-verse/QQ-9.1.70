package com.tencent.superplayer.utils;

import android.content.SharedPreferences;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import com.tencent.thumbplayer.api.capability.TPVCodecCapabilityForGet;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile SharedPreferences f374003a;

    /* renamed from: b, reason: collision with root package name */
    private static final List<b> f374004b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<Float> f374005c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        int f374006a;

        /* renamed from: b, reason: collision with root package name */
        int f374007b;

        b(int i3, int i16) {
            this.f374006a = i3;
            this.f374007b = i16;
        }
    }

    static {
        LinkedList linkedList = new LinkedList();
        f374004b = linkedList;
        LinkedList linkedList2 = new LinkedList();
        f374005c = linkedList2;
        linkedList.add(new b(2160, 3480));
        int i3 = 1080;
        linkedList.add(new b(i3, 1920));
        linkedList.add(new b(720, i3));
        int i16 = 480;
        linkedList.add(new b(i16, TVKTPCapability.HD_WIDTH));
        linkedList.add(new b(270, i16));
        linkedList2.add(Float.valueOf(120.0f));
        linkedList2.add(Float.valueOf(60.0f));
        linkedList2.add(Float.valueOf(30.0f));
    }

    private static void a() {
        if (f374003a == null) {
            synchronized (e.class) {
                if (f374003a == null) {
                    f374003a = SuperPlayerSDKMgr.getContext().getSharedPreferences("SuperCapabilityUtils", 0);
                }
            }
        }
    }

    private static String b(int i3, int i16) {
        return "VCodecCapability" + i3 + i16;
    }

    public static TPVCodecCapabilityForGet c(int i3) throws TPLoadLibraryException {
        if (SuperPlayerSDKMgr.getContext() == null) {
            return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
        }
        a();
        String b16 = b(i3, -1);
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return e(b16);
        }
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return e(b16);
        }
        for (Float f16 : f374005c) {
            for (b bVar : f374004b) {
                if (TPDecoderCapability.getVideoDecoderCapability(i3, bVar.f374006a, bVar.f374007b, f16.floatValue()) == 1) {
                    TPVCodecCapabilityForGet tPVCodecCapabilityForGet = new TPVCodecCapabilityForGet(-1, bVar.f374006a, bVar.f374007b, f16.intValue());
                    f(b16, tPVCodecCapabilityForGet);
                    return tPVCodecCapabilityForGet;
                }
            }
        }
        return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
    }

    public static TPVCodecCapabilityForGet d(int i3, int i16) throws TPLoadLibraryException {
        if (SuperPlayerSDKMgr.getContext() == null) {
            return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
        }
        a();
        String b16 = b(i3, i16);
        if (!TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            return e(b16);
        }
        for (Float f16 : f374005c) {
            for (b bVar : f374004b) {
                if (TPDecoderCapability.getVideoDecoderCapability(i3, i16, bVar.f374006a, bVar.f374007b, f16.floatValue()) == 1) {
                    TPVCodecCapabilityForGet tPVCodecCapabilityForGet = new TPVCodecCapabilityForGet(-1, bVar.f374006a, bVar.f374007b, f16.intValue());
                    f(b16, tPVCodecCapabilityForGet);
                    return tPVCodecCapabilityForGet;
                }
            }
        }
        return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
    }

    private static TPVCodecCapabilityForGet e(String str) {
        return new TPVCodecCapabilityForGet(f374003a.getInt(str + "maxLumaSamples", -1), f374003a.getInt(str + "maxProfile", -1), f374003a.getInt(str + "maxLevel", -1), f374003a.getInt(str + "maxFramerate", -1));
    }

    private static void f(String str, TPVCodecCapabilityForGet tPVCodecCapabilityForGet) {
        f374003a.edit().putInt(str + "maxLumaSamples", tPVCodecCapabilityForGet.getMaxLumaSamples()).putInt(str + "maxProfile", tPVCodecCapabilityForGet.getMaxProfile()).putInt(str + "maxLevel", tPVCodecCapabilityForGet.getMaxLevel()).putInt(str + "maxFramerate", tPVCodecCapabilityForGet.getMaxFramerateFormaxLumaSamples()).apply();
    }
}
