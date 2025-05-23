package com.tencent.qqnt.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.voicechange.IVoiceChangeManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ChangeVoiceView extends RelativeLayout {
    static IPatchRedirector $redirector_;
    public static String L;
    private TextView C;
    public int D;
    public int E;
    public int F;
    private int G;
    private boolean H;
    private a I;
    public com.tencent.mobileqq.voicechange.c J;
    private long K;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f349549d;

    /* renamed from: e, reason: collision with root package name */
    ImageView f349550e;

    /* renamed from: f, reason: collision with root package name */
    ImageView f349551f;

    /* renamed from: h, reason: collision with root package name */
    private CircleProgressView f349552h;

    /* renamed from: i, reason: collision with root package name */
    private VolumeIndicateSquareView f349553i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f349554m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f349555a;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChangeVoiceView.this);
            } else {
                this.f349555a = 0;
            }
        }

        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.f349555a = i3;
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            boolean z16 = true;
            if (this.f349555a != 1) {
                z16 = false;
            }
            accessibilityNodeInfoCompat.setSelected(z16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            L = HardCodeUtil.qqStr(R.string.kaz);
        }
    }

    public ChangeVoiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.F = 0;
        this.G = 0;
        this.H = false;
        this.K = 0L;
    }

    private void g(int i3) {
        if (i3 == 2) {
            setContentDescription(L);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        int i16 = this.J.f313149e;
        if (i16 != 1) {
            if (i16 == 2) {
                sb5.append("\u70ed ");
            }
        } else {
            sb5.append("\u65b0 ");
        }
        int i17 = this.J.f313150f;
        if (i17 != 4) {
            if (i17 == 5) {
                sb5.append("SVIP ");
            }
        } else {
            sb5.append("VIP ");
        }
        sb5.append(this.J.f313147c);
        setContentDescription(sb5.toString());
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        if (this.J == null) {
            return;
        }
        if (AppSetting.f99565y) {
            if (this.I == null) {
                a aVar = new a();
                this.I = aVar;
                ViewCompat.setAccessibilityDelegate(this, aVar);
            }
            this.I.a(i3);
        }
        this.f349552h.setProgress(0);
        g(i3);
        if (this.F == i3) {
            return;
        }
        this.F = i3;
        if (i3 == 0) {
            this.f349552h.setVisibility(8);
            this.f349554m.setVisibility(8);
            this.f349553i.setVisibility(8);
            this.C.setBackgroundResource(R.drawable.c4o);
            if (this.J.f313148d == 1) {
                this.C.setTextColor(2137417318);
            } else {
                this.C.setTextColor(getContext().getResources().getColor(R.color.qui_common_text_primary));
            }
        } else if (i3 == 1) {
            this.f349552h.setVisibility(8);
            this.f349554m.setVisibility(8);
            this.f349553i.setVisibility(8);
            if (this.H) {
                this.C.setBackgroundResource(R.drawable.fyu);
                this.C.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary));
            } else {
                this.C.setBackgroundResource(R.drawable.c4p);
                this.C.setTextColor(getContext().getResources().getColor(R.color.qui_common_on_brand_primary));
            }
        } else if (i3 == 2) {
            this.f349552h.setVisibility(0);
            this.f349554m.setVisibility(0);
            this.f349553i.b();
            this.f349553i.setVisibility(0);
            if (this.H) {
                this.C.setBackgroundResource(R.drawable.fyu);
                this.C.setTextColor(getContext().getResources().getColor(R.color.qui_button_text_primary));
            } else {
                this.C.setBackgroundResource(R.drawable.c4p);
                this.C.setTextColor(getContext().getResources().getColor(R.color.qui_common_on_brand_primary));
            }
        }
        TextView textView = this.C;
        int i16 = this.G;
        textView.setPadding(i16, 0, i16, 0);
    }

    public void b(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.f349552h.setProgress(i3);
        if (this.K == 0) {
            this.K = SystemClock.uptimeMillis();
        } else if (SystemClock.uptimeMillis() - this.K < 75) {
            return;
        }
        this.K = SystemClock.uptimeMillis();
        StringBuilder sb5 = new StringBuilder();
        int i18 = i16 / 1000;
        int i19 = i18 / 60;
        int i26 = i18 % 60;
        sb5.append(i19);
        sb5.append(":");
        if (i26 < 10) {
            sb5.append("0");
        }
        sb5.append(i26);
        if (!sb5.equals(this.f349554m.getText())) {
            this.f349554m.setText(sb5);
        }
        this.f349553i.c(i17);
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.F;
    }

    public TextView d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TextView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.C;
    }

    public void e(com.tencent.mobileqq.voicechange.c cVar) {
        boolean z16;
        Drawable drawable;
        String tagIconURL;
        URLDrawable uRLDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
            return;
        }
        int i3 = 0;
        if (cVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        super.setEnabled(z16);
        this.f349551f = (ImageView) super.findViewById(R.id.cco);
        this.f349550e = (ImageView) super.findViewById(R.id.flag_new);
        this.f349549d = (ImageView) super.findViewById(R.id.atc);
        this.C = (TextView) super.findViewById(R.id.ate);
        CircleProgressView circleProgressView = (CircleProgressView) super.findViewById(R.id.atd);
        this.f349552h = circleProgressView;
        circleProgressView.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createCircleProcessViewPresenter(this.f349552h));
        this.f349554m = (TextView) super.findViewById(R.id.ath);
        this.f349553i = (VolumeIndicateSquareView) super.findViewById(R.id.ati);
        if (cVar == null) {
            this.f349549d.setBackgroundDrawable(null);
            this.f349549d.setVisibility(4);
            this.C.setText((CharSequence) null);
            super.setContentDescription(null);
            this.f349550e.setVisibility(8);
            this.f349551f.setVisibility(8);
            this.f349552h.setVisibility(8);
            this.f349554m.setVisibility(8);
            this.f349553i.setVisibility(8);
            this.C.setBackgroundResource(R.drawable.c4o);
            return;
        }
        this.G = com.tencent.mobileqq.util.x.c(getContext(), 4.0f);
        this.D = cVar.f313145a;
        this.f349552h.setStrokeWidth(4);
        this.J = cVar;
        this.f349549d.setVisibility(0);
        int i16 = cVar.f313151g.f313154c;
        if (i16 > 0) {
            this.f349549d.setBackgroundResource(i16);
        } else {
            Resources resources = super.getResources();
            try {
                String str = cVar.f313151g.f313152a;
                if (!TextUtils.isEmpty(str)) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mFailedDrawable = resources.getDrawable(R.drawable.apn);
                    obtain.mLoadingDrawable = resources.getDrawable(R.drawable.apn);
                    File file = new File(((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).getVoiceChangeRootDir() + str.substring(str.lastIndexOf("/") + 1));
                    if (file.exists() && file.isFile()) {
                        drawable = URLDrawable.getDrawable(file, obtain);
                    } else {
                        drawable = URLDrawable.getDrawable(str, obtain);
                    }
                } else {
                    QLog.d("ChangeVoiceView", 2, "init drawable url = null, name=" + cVar.f313146b + ",type=" + cVar.f313145a);
                    drawable = resources.getDrawable(R.drawable.apn);
                }
            } catch (Exception unused) {
                drawable = resources.getDrawable(R.drawable.apn);
            }
            if (drawable instanceof URLDrawable) {
                URLDrawable uRLDrawable2 = (URLDrawable) drawable;
                if (uRLDrawable2.getStatus() == 2) {
                    uRLDrawable2.restartDownload();
                }
            }
            if (cVar.f313148d == 1) {
                drawable.setAlpha(127);
            } else {
                drawable.setAlpha(255);
            }
            cVar.f313151g.f313155d = drawable;
            this.f349549d.setBackgroundDrawable(drawable);
        }
        if (cVar.f313149e != 0) {
            this.f349550e.setVisibility(0);
            if (cVar.f313149e == 1) {
                this.f349550e.setImageResource(R.drawable.frx);
            } else {
                this.f349550e.setImageResource(R.drawable.frw);
            }
        } else {
            this.f349550e.setVisibility(8);
        }
        if (cVar.f313150f != 1) {
            this.f349551f.setVisibility(0);
            int i17 = cVar.f313150f;
            if (i17 == 4) {
                tagIconURL = ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).getTagIconURL(0);
            } else if (i17 == 5) {
                tagIconURL = ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).getTagIconURL(1);
            } else {
                tagIconURL = ((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).getTagIconURL(2);
            }
            if (!TextUtils.isEmpty(tagIconURL)) {
                File file2 = new File(((IVoiceChangeManager) QRoute.api(IVoiceChangeManager.class)).getVoiceChangeRootDir() + tagIconURL.substring(tagIconURL.lastIndexOf("/") + 1));
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                if (file2.exists() && file2.isFile()) {
                    uRLDrawable = URLDrawable.getDrawable(file2, obtain2);
                } else {
                    uRLDrawable = URLDrawable.getDrawable(tagIconURL, obtain2);
                }
            } else {
                uRLDrawable = null;
            }
            this.f349551f.setImageDrawable(uRLDrawable);
        } else {
            this.f349551f.setVisibility(8);
        }
        String str2 = cVar.f313146b;
        if (str2 != null && str2.length() > 4) {
            str2 = str2.substring(0, 3) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        this.C.setText(str2);
        super.setContentDescription(cVar.f313147c);
        if (cVar.f313145a == this.E) {
            i3 = 1;
        }
        this.F = i3 + 1;
        a(i3);
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.H = true;
        CircleProgressView circleProgressView = this.f349552h;
        if (circleProgressView != null) {
            circleProgressView.setRingWidth(10);
            this.f349552h.setRingColor(getResources().getColor(R.color.skin_audio_panel_ring_color));
        }
    }
}
