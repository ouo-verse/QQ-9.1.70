package com.tencent.aelight.camera.aeeditor.manage;

import android.os.SystemClock;
import android.text.TextUtils;
import ar.d;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEEditorEffectConfigManager {

    /* renamed from: c, reason: collision with root package name */
    private static volatile AEEditorEffectConfigManager f66129c;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f66130d = new byte[0];

    /* renamed from: a, reason: collision with root package name */
    private a f66131a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f66132b;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
        void a(String str);
    }

    AEEditorEffectConfigManager() {
        ms.a.f("AEEditorEffectConfigManager", "AEEditorEffectConfigManager init.");
    }

    public static String d() {
        return d.f26770c + File.separator + "effect_group_list.json";
    }

    public static AEEditorEffectConfigManager f() {
        if (f66129c == null) {
            synchronized (AEEditorEffectConfigManager.class) {
                if (f66129c == null) {
                    f66129c = new AEEditorEffectConfigManager();
                }
            }
        }
        return f66129c;
    }

    private void g() {
        this.f66132b = new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(AEEditorEffectConfigManager.d())) {
                    return;
                }
                try {
                    synchronized (AEEditorEffectConfigManager.f66130d) {
                        if (new File(AEEditorEffectConfigManager.d()).exists()) {
                            if (AEEditorEffectConfigManager.this.f66131a != null) {
                                AEEditorEffectConfigManager.this.f66131a.a(AEEditorEffectConfigManager.d());
                            } else {
                                ms.a.c("AEEditorEffectConfigManager", "group list back is null.");
                            }
                        } else if (AEEditorEffectConfigManager.this.f66131a != null) {
                            ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(AEEditorEffectConfigManager.this.f66132b);
                            ThreadManager.getSubThreadHandler().postAtTime(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AEEditorEffectConfigManager.this.f66131a.a(null);
                                }
                            }, AEEditorEffectConfigManager.this.f66132b, SystemClock.uptimeMillis() + 5000);
                        } else {
                            ms.a.c("AEEditorEffectConfigManager", "group list back is null && data empty.");
                        }
                    }
                } catch (Exception e16) {
                    ms.a.c("AEEditorEffectConfigManager", e16.toString());
                }
            }
        };
        ThreadManager.getFileThreadHandler().post(this.f66132b);
    }

    public void e(a aVar) {
        this.f66131a = aVar;
        g();
    }

    public void h(final AEEditorEffectGroupListBean aEEditorEffectGroupListBean) {
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aeeditor.manage.AEEditorEffectConfigManager.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (AEEditorEffectConfigManager.f66130d) {
                    b.b(aEEditorEffectGroupListBean, AEEditorEffectConfigManager.d());
                    if (AEEditorEffectConfigManager.this.f66131a != null) {
                        AEEditorEffectConfigManager.this.f66131a.a(AEEditorEffectConfigManager.d());
                    }
                }
            }
        });
    }
}
