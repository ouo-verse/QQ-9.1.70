package com.tencent.mobileqq.vip.diy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase;
import com.tencent.mobileqq.widget.ProfileNameView;

/* loaded from: classes20.dex */
public class ProfileTemplateNickNameContainer extends ViewGroup {
    static IPatchRedirector $redirector_;
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private ProfileNameView f312932d;

    /* renamed from: e, reason: collision with root package name */
    private int f312933e;

    /* renamed from: f, reason: collision with root package name */
    private String f312934f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f312935h;

    /* renamed from: i, reason: collision with root package name */
    private ProfileTemplateBase.b f312936i;

    /* renamed from: m, reason: collision with root package name */
    private int f312937m;

    public ProfileTemplateNickNameContainer(Context context, ProfileNameView profileNameView) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) profileNameView);
            return;
        }
        this.f312936i = new ProfileTemplateBase.b();
        this.f312932d = profileNameView;
        addView(profileNameView);
    }

    public ETTextViewPlus a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ETTextViewPlus) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f312932d.b();
    }

    protected URLDrawable b(@NonNull String str, DownloadParams.DecodeHandler decodeHandler) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) decodeHandler);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = false;
        if (decodeHandler != null) {
            obtain.mMemoryCacheKeySuffix = decodeHandler.toString();
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        drawable2.setDecodeHandler(decodeHandler);
        return drawable2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        int c16 = this.f312932d.c();
        int i19 = this.f312933e;
        int i26 = i19 + c16;
        int i27 = i17 - i3;
        if (i26 > i27) {
            i19 = Math.max(0, i17 - c16);
            i26 = i27;
        } else if (this.f312935h) {
            i19 = (i27 / 2) - ((i26 - i19) / 2);
            i26 = i19 + c16;
        }
        int i28 = i18 - i16;
        this.f312932d.layout(i19, 0, i26, i28);
        if (!TextUtils.isEmpty(this.f312934f)) {
            this.f312936i.a(i26 - i19, i28);
            URLDrawable b16 = b(this.f312934f, this.f312936i);
            ProfileTemplateBase.a.a(b16, this.f312932d);
            this.f312932d.setBackgroundDrawable(b16);
            return;
        }
        this.f312932d.setBackgroundDrawable(null);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        super.onMeasure(i3, i16);
        this.f312932d.measure(i16, i16);
        setMeasuredDimension(getMeasuredWidth(), this.f312932d.getMeasuredHeight());
    }

    public void setTextBgUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        this.f312934f = str;
        if (!TextUtils.isEmpty(str)) {
            double j3 = UIUtils.j(getContext());
            this.f312937m = (int) (0.005d * j3);
            this.C = (int) (j3 * 0.03d);
        } else {
            this.f312937m = 0;
            this.C = 0;
            this.f312932d.setBackgroundDrawable(null);
        }
        ETTextViewPlus b16 = this.f312932d.b();
        int i3 = this.C;
        int i16 = this.f312937m;
        b16.setPadding(i3, i16, i3, i16);
    }

    public void setTextCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.f312935h = true;
        }
    }

    public void setTextViewX(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f312933e = i3;
        }
    }
}
