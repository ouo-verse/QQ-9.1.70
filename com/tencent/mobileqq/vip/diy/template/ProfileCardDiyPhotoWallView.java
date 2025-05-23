package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardPhotoWallView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vip.diy.template.ProfileTemplateBase;
import java.util.LinkedList;

/* loaded from: classes20.dex */
public class ProfileCardDiyPhotoWallView extends ProfileCardPhotoWallView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private int f312958d;

    /* renamed from: e, reason: collision with root package name */
    private int f312959e;

    /* renamed from: f, reason: collision with root package name */
    private String f312960f;

    public ProfileCardDiyPhotoWallView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f312958d = -16777216;
            this.f312959e = 10;
        }
    }

    protected URLDrawable a(String str, DownloadParams.DecodeHandler decodeHandler) throws IllegalArgumentException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) decodeHandler);
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

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardPhotoWallView
    public void genImg(LinkedList<ProfilePhotoWall> linkedList, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) linkedList, i3);
        } else {
            super.genImg(linkedList, i3);
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardPhotoWallView
    public ViewGroup getImageView(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ViewGroup) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        ViewGroup imageView = super.getImageView(i3, i16, i17);
        if (!TextUtils.isEmpty(this.f312960f) && this.f312960f.startsWith("http")) {
            imageView.setBackgroundDrawable(a(this.f312960f, new ProfileTemplateBase.b(i3 * 2, i16 * 2)));
        } else {
            imageView.setBackgroundColor(this.f312958d);
        }
        return imageView;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardPhotoWallView
    protected View getImageViewLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bez, (ViewGroup) null);
        int i3 = this.f312959e;
        inflate.setPadding(i3, i3, i3, i3);
        return inflate;
    }

    public void setBorderImgUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f312960f = str;
        }
    }

    public void setBorderWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f312959e = i3;
        }
    }

    public void setItemViewBorderColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f312958d = i3;
        }
    }

    public void setMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mMargin = i3;
        }
    }

    public ProfileCardDiyPhotoWallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f312958d = -16777216;
            this.f312959e = 10;
        }
    }
}
