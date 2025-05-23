package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.lottie;

import android.animation.Animator;
import android.content.Context;
import android.text.TextUtils;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.ecommerce.richtext.utils.e;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.adapter.BaseHttpAdapter;
import com.tencent.qphone.base.util.QLog;
import dk0.c;
import fk0.d;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jk0.b;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ECHRLottieView extends LottieAnimationView implements nk0.a {
    public ECHRLottieView(Context context) {
        super(context);
    }

    private dk0.c q() {
        dk0.c b16 = d.c().b();
        return b16 == null ? new BaseHttpAdapter() : b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str, String str2) {
        LottieComposition.Factory.fromJsonString(str, new b(str2));
    }

    @Override // nk0.a
    public void c(boolean z16) {
        loop(z16);
    }

    @Override // nk0.a
    public void d(final String str, final b.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("http:") && !str.startsWith("https:")) {
            try {
                LottieComposition.Factory.fromJsonString(str, new a(cVar));
                return;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("KdLottieView", 2, "v_setAnimation exception", e16);
                    return;
                }
                return;
            }
        }
        d.c().d(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.lottie.ECHRLottieView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty("")) {
                    File file = new File("");
                    if (file.exists()) {
                        String v3 = e.v(file);
                        if (!TextUtils.isEmpty(v3)) {
                            ECHRLottieView.this.r(v3, str);
                            b.c cVar2 = cVar;
                            if (cVar2 != null) {
                                cVar2.onResult(true);
                                return;
                            }
                            return;
                        }
                        ECHRLottieView.this.t(str, cVar);
                        return;
                    }
                    ECHRLottieView.this.t(str, cVar);
                    return;
                }
                ECHRLottieView.this.t(str, cVar);
            }
        });
    }

    @Override // nk0.a
    public void g() {
        playAnimation();
    }

    @Override // nk0.a
    public void j(Animator.AnimatorListener animatorListener) {
        addAnimatorListener(animatorListener);
    }

    public void t(String str, b.c cVar) {
        dk0.a aVar = new dk0.a();
        aVar.f394018b = str;
        aVar.f394019c = "GET";
        aVar.f394021e = 5000;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);
        aVar.f394017a = hashMap;
        q().sendRequest(aVar, new c(str, cVar), true);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements OnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b.c f262623a;

        a(b.c cVar) {
            this.f262623a = cVar;
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            if (lottieComposition != null) {
                ECHRLottieView.this.setComposition(lottieComposition);
                b.c cVar = this.f262623a;
                if (cVar != null) {
                    cVar.onResult(true);
                    return;
                }
                return;
            }
            b.c cVar2 = this.f262623a;
            if (cVar2 != null) {
                cVar2.onResult(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements OnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f262625a;

        b(String str) {
            this.f262625a = str;
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            if (lottieComposition != null) {
                ECHRLottieView.this.setImageAssetsFolder(this.f262625a);
                ECHRLottieView.this.setComposition(lottieComposition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f262627a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.c f262628b;

        c(String str, b.c cVar) {
            this.f262627a = str;
            this.f262628b = cVar;
        }

        @Override // dk0.c.a
        public void onHttpFinish(dk0.b bVar) {
            boolean z16;
            if (Integer.parseInt(bVar.f394022a) == 200) {
                try {
                    byte[] bArr = bVar.f394023b;
                    if (bArr != null) {
                        ECHRLottieView.this.r(new String(bArr, "utf-8"), this.f262627a);
                        z16 = true;
                        this.f262628b.onResult(z16);
                    }
                } catch (Exception unused) {
                    return;
                }
            }
            z16 = false;
            this.f262628b.onResult(z16);
        }

        @Override // dk0.c.a
        public void onHttpStart() {
        }

        @Override // dk0.c.a
        public void onHeadersReceived(int i3, Map<String, List<String>> map) {
        }
    }
}
