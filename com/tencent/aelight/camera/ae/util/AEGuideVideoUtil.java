package com.tencent.aelight.camera.ae.util;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEGuideVideoUtil {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Set<String>> f65750a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        protected static final AEGuideVideoUtil f65753a = new AEGuideVideoUtil();
    }

    private void a(String str) {
        if (this.f65750a.containsKey(str)) {
            return;
        }
        Set<String> b16 = AECameraPrefsUtil.f().b(str, null, 0);
        if (b16 == null) {
            b16 = new HashSet<>();
        }
        this.f65750a.put(str, b16);
    }

    public static AEGuideVideoUtil b() {
        return a.f65753a;
    }

    public boolean c(String str, String str2) {
        a(str);
        return this.f65750a.get(str).contains(str2);
    }

    public void d(final String str, String str2) {
        if (c(str, str2)) {
            return;
        }
        final Set<String> set = this.f65750a.get(str);
        set.add(str2);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.util.AEGuideVideoUtil.1
            @Override // java.lang.Runnable
            public void run() {
                AECameraPrefsUtil.f().k(str, set, 0);
            }
        });
    }
}
