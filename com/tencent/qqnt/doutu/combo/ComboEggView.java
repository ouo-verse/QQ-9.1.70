package com.tencent.qqnt.doutu.combo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.AvatarSizeType;
import com.tencent.qqnt.avatar.b;
import com.tencent.qqnt.base.widget.RoundRectImageView;
import com.tencent.qqnt.doutu.CustomFrameAnimationDrawable;
import java.io.File;
import kotlinx.coroutines.GlobalScope;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes24.dex */
public class ComboEggView extends RelativeLayout implements CustomFrameAnimationDrawable.a {
    static IPatchRedirector $redirector_;
    public static final int[] D;
    public static final float[] E;
    a C;

    /* renamed from: d, reason: collision with root package name */
    private MqqHandler f356045d;

    /* renamed from: e, reason: collision with root package name */
    private BaseQQAppInterface f356046e;

    /* renamed from: f, reason: collision with root package name */
    CustomFrameAnimationDrawable f356047f;

    /* renamed from: h, reason: collision with root package name */
    ImageView f356048h;

    /* renamed from: i, reason: collision with root package name */
    RoundRectImageView f356049i;

    /* renamed from: m, reason: collision with root package name */
    private b f356050m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31296);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            D = new int[]{8, 18, 88, 888};
            E = new float[]{0.27866668f, 0.17066666f, 0.17066666f, 0.09066667f};
        }
    }

    public ComboEggView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public static final boolean b(int i3) {
        int i16 = 0;
        while (true) {
            int[] iArr = D;
            if (i16 >= iArr.length) {
                return false;
            }
            if (i3 == iArr[i16]) {
                return true;
            }
            i16++;
        }
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f356047f.v();
        this.f356047f.w(this);
        this.f356048h.setImageDrawable(this.f356047f);
        this.f356047f.x();
    }

    public void c(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewGroup);
            return;
        }
        if (viewGroup != null) {
            CustomFrameAnimationDrawable customFrameAnimationDrawable = this.f356047f;
            if (customFrameAnimationDrawable != null) {
                customFrameAnimationDrawable.stop();
                this.f356047f.j();
            }
            viewGroup.removeView(this);
        }
        this.f356045d.removeCallbacksAndMessages(null);
    }

    public void d(b bVar, BaseQQAppInterface baseQQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) baseQQAppInterface);
            return;
        }
        this.f356046e = baseQQAppInterface;
        this.f356049i = (RoundRectImageView) findViewById(R.id.f164110jw);
        this.f356048h = (ImageView) findViewById(R.id.f164109jv);
        this.f356045d = new MqqHandler(ThreadManagerV2.getFileThreadLooper());
        this.f356050m = bVar;
        this.C = new a(null, 0L, 0);
    }

    public boolean e(a aVar) {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar)).booleanValue();
        }
        this.C = aVar;
        int i3 = 0;
        while (true) {
            int[] iArr = D;
            if (i3 < iArr.length) {
                if (aVar.f356081b == iArr[i3]) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            return false;
        }
        int i16 = getContext().getResources().getDisplayMetrics().widthPixels;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f356049i.getLayoutParams();
        float f16 = i16;
        layoutParams.setMargins((int) (E[i3] * f16), 0, 0, 0);
        int i17 = (int) (f16 * 0.15733333f);
        layoutParams.width = i17;
        layoutParams.height = i17;
        if (!TextUtils.isEmpty(aVar.f356080a) && this.f356049i.getVisibility() == 0) {
            b.a aVar2 = new b.a();
            aVar2.g(AvatarSizeType.SMALL);
            aVar2.b(Integer.valueOf(R.drawable.f160830com));
            this.f356049i.setCornerRadiusAndMode(layoutParams.width / 2, 1);
            com.tencent.qqnt.avatar.a.a(getContext()).b(this.f356049i).e(aVar2.a()).d(aVar.f356080a, aVar.f356083d.longValue(), GlobalScope.INSTANCE);
        }
        File[] e16 = ComboResource.e(aVar.f356081b);
        if (e16 == null) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 1;
        options.inMutable = true;
        try {
            bitmap = BaseImageUtil.decodeFileWithBufferedStream(e16[0].getAbsolutePath(), options);
        } catch (OutOfMemoryError unused) {
            if (QLog.isColorLevel()) {
                QLog.d("ComboUIManager", 2, " ComboEggView play first bmp oom");
            }
            bitmap = null;
        }
        if (bitmap == null) {
            return false;
        }
        this.f356047f = new CustomFrameAnimationDrawable(this.f356046e.getApp().getResources(), bitmap, this.f356045d);
        for (int i18 = 1; i18 < e16.length; i18++) {
            this.f356047f.i(i18 - 1, 77, e16[i18].getAbsolutePath());
        }
        return true;
    }

    @Override // com.tencent.qqnt.doutu.CustomFrameAnimationDrawable.a
    public void onEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f356050m != null) {
            this.f356047f.j();
            this.f356050m.h(this);
        }
        this.f356045d.removeCallbacksAndMessages(null);
    }
}
