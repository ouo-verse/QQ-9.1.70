package com.tencent.mobileqq.vip.diy.common;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.urldrawable.b;
import com.tencent.util.URLUtil;
import e15.f;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a extends f {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private String D;

    public a(String str, View view, @NonNull String str2) {
        super(str, view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, view, str2);
            return;
        }
        if (view != null && (view instanceof DIYImageView)) {
            this.C = ((DIYImageView) view).a();
        }
        this.D = str2;
    }

    private ImageView.ScaleType u(String str) {
        if (TextUtils.isEmpty(str)) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if ("center_crop".equals(str)) {
            return ImageView.ScaleType.CENTER_CROP;
        }
        if ("fit_center".equals(str)) {
            return ImageView.ScaleType.FIT_CENTER;
        }
        return ImageView.ScaleType.CENTER_CROP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.m();
        }
    }

    @Override // e15.f
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.p();
        View view = this.f395367e;
        if (view != null && this.C != null) {
            if (view.getParent() != null && (this.f395367e.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f395367e.getParent()).setClipChildren(false);
            }
            ViewGroup.LayoutParams layoutParams = this.f395367e.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.C.getLayoutParams();
            if (layoutParams != null && layoutParams2 != null) {
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.C.setLayoutParams(layoutParams2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            return;
        }
        super.q(str, str2);
        if (!(this.f395367e instanceof DIYImageView)) {
            AssertUtils.fail("JsonInflateViewModel current view type illegal!", new Object[0]);
        } else if ("content".equals(str)) {
            v(str2);
        } else if (DittoImageArea.SCALE_TYPE.equals(str)) {
            this.C.setScaleType(u(str2));
        }
    }

    protected void v(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (!str.startsWith("http")) {
            str = this.D + str;
        }
        if (!URLUtil.isValidUrl(str)) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        int i16 = this.f395369h;
        if (i16 > 0 && (i3 = this.f395370i) > 0) {
            obtain.mRequestWidth = i16;
            obtain.mRequestHeight = i3;
        }
        Drawable drawable = b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = false;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        if (drawable2 != null) {
            this.C.setImageDrawable(drawable2);
        }
    }
}
