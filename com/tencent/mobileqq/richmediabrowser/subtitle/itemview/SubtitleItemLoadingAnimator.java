package com.tencent.mobileqq.richmediabrowser.subtitle.itemview;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubtitleItemLoadingAnimator {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f281883g = {".    ", "  . .    ", "    . . .    ", " "};

    /* renamed from: e, reason: collision with root package name */
    private a f281888e;

    /* renamed from: b, reason: collision with root package name */
    private final int f281885b = 200;

    /* renamed from: c, reason: collision with root package name */
    private int f281886c = 0;

    /* renamed from: d, reason: collision with root package name */
    private String f281887d = ".";

    /* renamed from: f, reason: collision with root package name */
    private final Runnable f281889f = new Runnable() { // from class: com.tencent.mobileqq.richmediabrowser.subtitle.itemview.SubtitleItemLoadingAnimator.1
        @Override // java.lang.Runnable
        public void run() {
            SubtitleItemLoadingAnimator.this.g();
            SubtitleItemLoadingAnimator.this.f281884a.postDelayed(this, 200L);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final MqqHandler f281884a = ThreadManager.getUIHandler();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        int i3 = this.f281886c;
        this.f281886c = i3 + 1;
        String[] strArr = f281883g;
        this.f281887d = strArr[(i3 / strArr.length) % strArr.length];
        a aVar = this.f281888e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public String c() {
        return this.f281887d;
    }

    public void d(a aVar) {
        this.f281888e = aVar;
    }

    public void e() {
        this.f281884a.postDelayed(this.f281889f, 200L);
    }

    public void f() {
        this.f281887d = "";
        this.f281888e.a();
        this.f281884a.removeCallbacks(this.f281889f);
        this.f281886c = 0;
    }
}
