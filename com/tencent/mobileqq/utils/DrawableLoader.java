package com.tencent.mobileqq.utils;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.OCRBottomTabView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DrawableLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f306943a = new Handler(ThreadManagerV2.getQQCommonThreadLooper());

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OCRBottomTabView f306947a;

        a(OCRBottomTabView oCRBottomTabView) {
            this.f306947a = oCRBottomTabView;
        }

        @Override // com.tencent.mobileqq.utils.DrawableLoader.b
        public void a(Drawable drawable) {
            this.f306947a.setTabImage(drawable);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(Drawable drawable);
    }

    public static void a(final int i3, final b bVar) {
        f306943a.post(new Runnable() { // from class: com.tencent.mobileqq.utils.DrawableLoader.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final Drawable drawable = MobileQQ.sMobileQQ.getApplicationContext().getResources().getDrawable(i3, null);
                    if (drawable != null) {
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.utils.DrawableLoader.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.a(drawable);
                            }
                        });
                    }
                } catch (Exception e16) {
                    QLog.e("DrawableLoader", 1, "asyncLoad exception", e16);
                }
            }
        });
    }

    public static void b(int i3, OCRBottomTabView oCRBottomTabView) {
        a(i3, new a(oCRBottomTabView));
    }
}
