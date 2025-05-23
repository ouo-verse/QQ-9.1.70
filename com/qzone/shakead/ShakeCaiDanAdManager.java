package com.qzone.shakead;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qzone.homepage.ui.Facade.FacadeVideoDownLoaderManager;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.shakead.ShakeAdCaiDan;
import com.tencent.mobileqq.app.ThreadManager;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ShakeCaiDanAdManager {

    /* renamed from: d, reason: collision with root package name */
    private static ShakeCaiDanAdManager f59710d;

    /* renamed from: a, reason: collision with root package name */
    private ShakeAdCaiDan f59711a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f59712b = false;

    /* renamed from: c, reason: collision with root package name */
    private ShakeAdCaiDan.d f59713c = new a();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ShakeAdCaiDan.d {
        a() {
        }

        @Override // com.qzone.shakead.ShakeAdCaiDan.d
        public void onHide() {
            ShakeCaiDanAdManager.this.f();
        }
    }

    public static ShakeCaiDanAdManager c() {
        if (f59710d == null) {
            synchronized (ShakeCaiDanAdManager.class) {
                if (f59710d == null) {
                    f59710d = new ShakeCaiDanAdManager();
                }
            }
        }
        return f59710d;
    }

    public void d(View view, Context context, Activity activity, BusinessFeedData businessFeedData, int i3) {
        if (this.f59712b) {
            ShakeAdCaiDan shakeAdCaiDan = this.f59711a;
            if (shakeAdCaiDan == null || !shakeAdCaiDan.h()) {
                this.f59711a = new ShakeAdCaiDan(context, activity, this.f59713c);
                if (view.getRootView() instanceof FrameLayout) {
                    this.f59711a.j((FrameLayout) view.getRootView(), businessFeedData, i3);
                }
            }
        }
    }

    public void e(boolean z16) {
        this.f59712b = z16;
    }

    public void g() {
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.shakead.ShakeCaiDanAdManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (ShakeCaiDanAdManager.this.f59711a != null) {
                    ShakeCaiDanAdManager.this.f59711a.f();
                }
            }
        }, 500L);
    }

    public void h(String str) {
        FacadeVideoDownLoaderManager.e().b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f59711a = null;
    }
}
