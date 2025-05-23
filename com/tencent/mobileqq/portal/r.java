package com.tencent.mobileqq.portal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class r {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    static HashMap<Integer, Bitmap> f259397j;

    /* renamed from: a, reason: collision with root package name */
    int f259398a;

    /* renamed from: b, reason: collision with root package name */
    int f259399b;

    /* renamed from: c, reason: collision with root package name */
    float[] f259400c;

    /* renamed from: d, reason: collision with root package name */
    float f259401d;

    /* renamed from: e, reason: collision with root package name */
    Bitmap f259402e;

    /* renamed from: f, reason: collision with root package name */
    double f259403f;

    /* renamed from: g, reason: collision with root package name */
    float f259404g;

    /* renamed from: h, reason: collision with root package name */
    float f259405h;

    /* renamed from: i, reason: collision with root package name */
    float f259406i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73660);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f259397j = new HashMap<>();
        }
    }

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r a(Bitmap bitmap, float f16, float f17, Resources resources) {
        r rVar = new r();
        int f18 = (int) (BaseAIOUtils.f(8.0f, resources) + (((float) Math.random()) * BaseAIOUtils.f(3.0f, resources)));
        rVar.f259398a = f18;
        rVar.f259399b = (int) ((bitmap.getHeight() / bitmap.getWidth()) * f18);
        rVar.f259400c = r1;
        float[] fArr = {f16, f17};
        rVar.f259401d = (((float) Math.random()) * BaseAIOUtils.f(90.0f, resources)) - BaseAIOUtils.f(45.0f, resources);
        double random = ((Math.random() * 2.0d) * 3.141592653589793d) - 3.141592653589793d;
        rVar.f259403f = random;
        if (random >= 0.0d) {
            rVar.f259404g = BaseAIOUtils.f(10.0f, resources) + (((float) Math.random()) * BaseAIOUtils.f(200.0f, resources));
        } else {
            rVar.f259404g = (-BaseAIOUtils.f(10.0f, resources)) - (((float) Math.random()) * BaseAIOUtils.f(200.0f, resources));
        }
        rVar.f259405h = (float) (rVar.f259404g * Math.cos(rVar.f259403f));
        rVar.f259406i = (float) (rVar.f259404g * Math.sin(rVar.f259403f));
        Bitmap bitmap2 = f259397j.get(Integer.valueOf(rVar.f259398a));
        rVar.f259402e = bitmap2;
        if (bitmap2 == null) {
            rVar.f259402e = Bitmap.createScaledBitmap(bitmap, rVar.f259398a, rVar.f259399b, true);
            f259397j.put(Integer.valueOf(rVar.f259398a), rVar.f259402e);
        }
        return rVar;
    }
}
