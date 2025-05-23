package com.tencent.mobileqq.ark.dict;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.config.qqmc.AIDictParser;
import com.tencent.mobileqq.ark.util.NativeLibLoader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkAiDictMgr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f199381a = false;

    /* renamed from: b, reason: collision with root package name */
    private static String f199382b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements WordSegment.ILogCallback {
        a() {
        }

        @Override // com.tencent.wordsegment.WordSegment.ILogCallback
        public void OnLog(String str, String str2) {
            QLog.i("ArkDict.DictMgr.WordSegment." + str, 1, str2);
        }
    }

    static String[] f(String str, int i3) {
        if (str.length() < i3) {
            return WordSegment.segment(str);
        }
        ArrayList arrayList = new ArrayList();
        e eVar = new e(str);
        String a16 = eVar.a(i3);
        while (!TextUtils.isEmpty(a16)) {
            String[] segment = WordSegment.segment(a16);
            if (segment != null) {
                arrayList.addAll(Arrays.asList(segment));
            }
            a16 = eVar.a(i3);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(String str) {
        return h() + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        return h91.a.d().i() + "/WordData/";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean i(AppRuntime appRuntime) {
        if (appRuntime == null) {
            return true;
        }
        d91.a d16 = AIDictParser.d();
        if (d16 != null && d16.c() != null) {
            String str = d16.c().f199443c;
            if (str != null) {
                QLog.i("ArkDict.DictMgr", 1, String.format("getWordInitState, wordInitState=%s", str));
                return !str.equals("false");
            }
            QLog.i("ArkDict.DictMgr", 1, "getWordInitState, ark_dict_init is empty");
            return true;
        }
        QLog.i("ArkDict.DictMgr", 1, "getWordInitState, confBean is empty");
        return true;
    }

    public static void j(AppRuntime appRuntime) {
        if (k()) {
            QLog.i("ArkDict.DictMgr", 1, "initWordData, already inited.");
            return;
        }
        new File(h()).mkdirs();
        if (!f199381a) {
            ArkRecommendLogic.b().c(new Runnable() { // from class: com.tencent.mobileqq.ark.dict.ArkAiDictMgr.1
                @Override // java.lang.Runnable
                public void run() {
                    ArkAiDictMgr.m();
                }
            });
        }
        n(appRuntime);
    }

    public static boolean k() {
        if (f199381a && !TextUtils.isEmpty(f199382b)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void m() {
        synchronized (ArkAiDictMgr.class) {
            if (h91.b.f404591a && !f199381a) {
                f199381a = NativeLibLoader.b(BaseApplication.getContext(), "WordSegment");
                QLog.i("ArkDict.DictMgr", 1, String.format("loadWordSegmentSo, result=%s", Boolean.toString(f199381a)));
                if (f199381a) {
                    WordSegment.setLogCallback(new a());
                }
            }
        }
    }

    public static void n(final AppRuntime appRuntime) {
        if (!f199381a) {
            QLog.i("ArkDict.DictMgr", 1, "reloadWordData, sIsSoLoaded is false");
        } else {
            ArkRecommendLogic.a().post(new Runnable() { // from class: com.tencent.mobileqq.ark.dict.ArkAiDictMgr.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ArkAiDictMgr.i(AppRuntime.this)) {
                            String F = ArkAiDictUpdateMgr.F();
                            if (F == null) {
                                QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "reloadWordData, local dict config not available", new Object[0]));
                                return;
                            }
                            if (ArkAiDictMgr.f199382b != null && ArkAiDictMgr.f199382b.equals(F)) {
                                QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "reloadWordData, dict already loaded, dict-id=%s", ArkAiDictMgr.f199382b));
                                return;
                            }
                            String g16 = ArkAiDictMgr.g(F);
                            if (!new File(g16).exists()) {
                                QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "reloadWordData, local dict file not available, dict-id=%s", F));
                                return;
                            }
                            WordSegment.uninit();
                            int init = WordSegment.init(g16 + '/');
                            if (init != 0) {
                                Locale locale = Locale.CHINA;
                                QLog.i("ArkDict.DictMgr", 1, String.format(locale, String.format(locale, "reloadWordData failed, dict-id=%s, ret=%d", F, Integer.valueOf(init)), new Object[0]));
                                return;
                            } else {
                                QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, String.format("reloadWordData success, dict-id=%s", F), new Object[0]));
                                ArkAiDictMgr.f199382b = F;
                                return;
                            }
                        }
                        QLog.i("ArkDict.DictMgr", 1, String.format("reloadWordData,\u00a0dict flag\u00a0is\u00a0off", new Object[0]));
                    } catch (UnsatisfiedLinkError e16) {
                        QLog.i("ArkDict.DictMgr", 1, "reloadWordData, UnsatisfiedLinkError, err:" + e16.getMessage());
                    }
                }
            });
        }
    }

    public static g o(final AppRuntime appRuntime, final String str) {
        final g gVar = new g();
        gVar.f199460b = str;
        ArkRecommendLogic.b().c(new Runnable() { // from class: com.tencent.mobileqq.ark.dict.ArkAiDictMgr.3
            @Override // java.lang.Runnable
            public void run() {
                ArkAiDictMgr.j(AppRuntime.this);
                if (ArkAiDictMgr.k()) {
                    g gVar2 = gVar;
                    gVar2.f199459a = true;
                    gVar2.f199461c = ArkAiDictMgr.f(str, 100);
                }
            }
        });
        return gVar;
    }

    public void e() {
        QLog.i("ArkDict.DictMgr", 1, "clearDict");
    }

    public void l() {
        if (!f199381a) {
            QLog.i("ArkDict.DictMgr", 1, "loadTestDict, sIsSoLoaded is false");
        } else {
            ArkRecommendLogic.a().post(new Runnable() { // from class: com.tencent.mobileqq.ark.dict.ArkAiDictMgr.5
                @Override // java.lang.Runnable
                public void run() {
                    String str = h91.a.d().g() + "/";
                    WordSegment.uninit();
                    int init = WordSegment.init(str);
                    if (init == 0) {
                        ArkAiDictMgr.f199382b = str;
                    } else {
                        QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "initWordData failed, ret=%d", Integer.valueOf(init)));
                    }
                }
            });
        }
    }
}
