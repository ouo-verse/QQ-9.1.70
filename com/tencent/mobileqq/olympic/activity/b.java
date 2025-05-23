package com.tencent.mobileqq.olympic.activity;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.av.u;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.e;
import com.tencent.mobileqq.ar.ARPromotionMgr.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    static final String f255193h;

    /* renamed from: a, reason: collision with root package name */
    private Activity f255194a;

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC8180b f255195b;

    /* renamed from: c, reason: collision with root package name */
    private ViewGroup f255196c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f255197d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f255198e;

    /* renamed from: f, reason: collision with root package name */
    private LottieDrawable f255199f;

    /* renamed from: g, reason: collision with root package name */
    boolean f255200g;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements OnCompositionLoadedListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f255201a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f255202b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f255203c;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.olympic.activity.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        class C8179a implements ImageAssetDelegate {
            static IPatchRedirector $redirector_;

            C8179a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
                }
            }

            @Override // com.airbnb.lottie.ImageAssetDelegate
            public Bitmap fetchBitmap(LottieImageAsset lottieImageAsset) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieImageAsset);
                }
                String str = a.this.f255201a + "guide_images" + File.separator + lottieImageAsset.getFileName();
                try {
                    a aVar = a.this;
                    return u.a(str, aVar.f255202b, aVar.f255203c);
                } catch (Exception e16) {
                    if (QQAudioHelper.j()) {
                        QLog.w(b.f255193h, 1, "PromotionGuide Exception, imagePath[" + str + "]", e16);
                    }
                    return null;
                }
            }
        }

        a(String str, int i3, int i16) {
            this.f255201a = str;
            this.f255202b = i3;
            this.f255203c = i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, b.this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            }
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(@Nullable LottieComposition lottieComposition) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) lottieComposition);
                return;
            }
            LottieDrawable lottieDrawable = new LottieDrawable();
            lottieDrawable.setImageAssetDelegate(new C8179a());
            lottieDrawable.setComposition(lottieComposition);
            lottieDrawable.loop(true);
            lottieDrawable.playAnimation();
            b.this.f255198e.setImageDrawable(lottieDrawable);
            b.this.f255199f = lottieDrawable;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.olympic.activity.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC8180b {
        PromotionConfigInfo.a g();

        boolean p();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73422);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f255193h = f.f196950a + "_Guide";
    }

    public b(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
            return;
        }
        this.f255199f = null;
        this.f255200g = false;
        this.f255194a = activity;
        this.f255196c = (ViewGroup) activity.findViewById(R.id.f167130l53);
        this.f255197d = (TextView) this.f255194a.findViewById(R.id.f167131l54);
        this.f255198e = (ImageView) this.f255194a.findViewById(R.id.f167129l52);
    }

    private boolean d() {
        InterfaceC8180b interfaceC8180b = this.f255195b;
        if (interfaceC8180b != null && (interfaceC8180b == null || interfaceC8180b.p())) {
            return false;
        }
        return true;
    }

    public void c(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface);
            return;
        }
        this.f255194a = null;
        ImageView imageView = this.f255198e;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        LottieDrawable lottieDrawable = this.f255199f;
        if (lottieDrawable != null) {
            lottieDrawable.cancelAnimation();
            this.f255199f = null;
        }
    }

    public void e(PromotionConfigInfo.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        String str = f255193h;
        QLog.w(str, 1, "loadRes, hadLoad[" + this.f255200g + "]");
        if (d() || this.f255200g) {
            return;
        }
        this.f255200g = true;
        Resources resources = this.f255194a.getResources();
        int i3 = resources.getDisplayMetrics().densityDpi;
        int i16 = resources.getDisplayMetrics().densityDpi;
        String d16 = e.d(aVar);
        if (TextUtils.isEmpty(d16)) {
            QLog.w(str, 1, "PromotionGuide, path is null");
            return;
        }
        if (!new File(d16).exists()) {
            QLog.w(str, 1, "PromotionGuide, file not exist");
            return;
        }
        try {
            LottieComposition.Factory.fromInputStream(new FileInputStream(d16 + "guide.json"), new a(d16, i3, i16));
        } catch (Exception e16) {
            QLog.i(f255193h, 2, "loadWorldCupGuideAnimation failed. err = " + e16.getMessage());
        }
    }

    public void f(InterfaceC8180b interfaceC8180b) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) interfaceC8180b);
        } else {
            this.f255195b = interfaceC8180b;
        }
    }

    public void g(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        ImageView imageView = this.f255198e;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        if (z16) {
            this.f255196c.setVisibility(0);
        } else {
            this.f255196c.setVisibility(this.f255197d.getVisibility());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        boolean z16 = true;
        if (d()) {
            QLog.w(f255193h, 1, "showText, isDestroyed, textIndex[" + i3 + "]");
            return;
        }
        InterfaceC8180b interfaceC8180b = this.f255195b;
        if (interfaceC8180b == null) {
            QLog.w(f255193h, 1, "showText, mPromotionRes\u4e3anull, textIndex[" + i3 + "]");
            return;
        }
        PromotionConfigInfo.a g16 = interfaceC8180b.g();
        if (g16 != null) {
            String d16 = g16.d(i3);
            if (!TextUtils.isEmpty(d16)) {
                this.f255197d.setText(d16);
                TextView textView = this.f255197d;
                if (!z16) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                textView.setVisibility(i16);
                if (!z16) {
                    this.f255196c.setVisibility(0);
                    return;
                } else {
                    this.f255196c.setVisibility(this.f255198e.getVisibility());
                    return;
                }
            }
        }
        z16 = false;
        TextView textView2 = this.f255197d;
        if (!z16) {
        }
        textView2.setVisibility(i16);
        if (!z16) {
        }
    }
}
