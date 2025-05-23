package com.tencent.mobileqq.textpreview;

import android.app.Activity;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tts.ITtsController;
import com.tencent.mobileqq.tts.data.i;
import com.tencent.qqnt.textpreview.inject.f;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d implements f {

    /* renamed from: a, reason: collision with root package name */
    ITtsController f292782a = (ITtsController) QRoute.api(ITtsController.class);

    @Override // com.tencent.qqnt.textpreview.inject.f
    public void a(String str, String str2, int i3) {
        this.f292782a.init(i3);
    }

    @Override // com.tencent.qqnt.textpreview.inject.f
    public void b(Activity activity, boolean z16) {
        QQAudioUtils.i(activity, z16);
    }

    @Override // com.tencent.qqnt.textpreview.inject.f
    public void c(f.a aVar) {
        this.f292782a.setTtsListener(new a(aVar));
    }

    @Override // com.tencent.qqnt.textpreview.inject.f
    public void destroy() {
        this.f292782a.destroy();
    }

    @Override // com.tencent.qqnt.textpreview.inject.f
    public boolean isWorking() {
        return this.f292782a.isWorking();
    }

    @Override // com.tencent.qqnt.textpreview.inject.f
    public void speak(String str, String str2) {
        this.f292782a.speak(str, str2);
    }

    @Override // com.tencent.qqnt.textpreview.inject.f
    public void stop() {
        this.f292782a.stop();
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements xt2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f.a f292783a;

        a(f.a aVar) {
            this.f292783a = aVar;
        }

        @Override // xt2.a
        public void a() {
            this.f292783a.a();
        }

        @Override // xt2.a
        public void b() {
            this.f292783a.b();
        }

        @Override // xt2.a
        public void c() {
            this.f292783a.c();
        }

        @Override // xt2.a
        public void e(String str) {
            this.f292783a.e(str);
        }

        @Override // xt2.a
        public void f(i iVar) {
            this.f292783a.onPlayStart(iVar.e());
        }

        @Override // xt2.a
        public void h() {
            this.f292783a.e("");
        }

        @Override // xt2.a
        public void onError(int i3, String str) {
            this.f292783a.onError(i3, str);
        }

        @Override // xt2.a
        public void d() {
        }

        @Override // xt2.a
        public void g() {
        }
    }
}
