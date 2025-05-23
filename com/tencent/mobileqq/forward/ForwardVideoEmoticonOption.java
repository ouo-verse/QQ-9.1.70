package com.tencent.mobileqq.forward;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.transfile.RegionalThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardVideoEmoticonOption extends ForwardShortVideoOption {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a extends ForwardShortVideoOption.b {
        static IPatchRedirector $redirector_;

        protected a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public void b(Drawable drawable, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, drawable, Boolean.valueOf(z16));
                return;
            }
            this.f210901b.setVisibility(0);
            this.f210900a.setVisibility(0);
            if (drawable == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardShortVideoOption", 2, "setPreviewImage null");
                }
                this.f210900a.setImageResource(R.drawable.aio_image_fail_round);
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f210900a.setLayoutParams(layoutParams);
            this.f210900a.setAdjustViewBounds(true);
            this.f210900a.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.f210900a.setImageDrawable(drawable);
            if (z16) {
                this.f210900a.setMaxWidth(ViewUtils.dip2px(120.0f));
                this.f210900a.setMaxHeight(ViewUtils.dip2px(120.0f));
            } else {
                this.f210900a.setMaxWidth(ViewUtils.dip2px(140.0f));
                this.f210900a.setMaxHeight(ViewUtils.dip2px(140.0f));
            }
        }
    }

    public ForwardVideoEmoticonOption(Intent intent) {
        super(intent);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardShortVideoOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View inflate = LayoutInflater.from(this.mActivity).inflate(R.layout.f167851jj, (ViewGroup) null);
        int dip2px = ViewUtils.dip2px(15.0f);
        inflate.setPadding(0, dip2px, 0, dip2px);
        a aVar = new a();
        this.f210888d = aVar;
        aVar.f210900a = (ImageView) inflate.findViewById(R.id.cla);
        ForwardShortVideoOption.b bVar = this.f210888d;
        ((ChatThumbView) bVar.f210900a).f179329f = false;
        bVar.f210901b = new ForwardShortVideoOption.PressDarkImageView(this.mActivity);
        this.f210888d.f210901b.setImageDrawable(this.mActivity.getResources().getDrawable(R.drawable.mng));
        ForwardShortVideoOption.b bVar2 = this.f210888d;
        bVar2.f210901b.f210898d = bVar2.f210900a;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.cl_);
        int dip2px2 = ViewUtils.dip2px(24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px2, dip2px2);
        int dip2px3 = ViewUtils.dip2px(8.0f);
        layoutParams.leftMargin = dip2px3;
        layoutParams.topMargin = dip2px3;
        relativeLayout.addView(this.f210888d.f210901b, layoutParams);
        inflate.findViewById(R.id.cl_).setVisibility(0);
        n();
        this.f210888d.f210901b.setContentDescription(HardCodeUtil.qqStr(R.string.mqw));
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f8 A[ADDED_TO_REGION] */
    @Override // com.tencent.mobileqq.forward.ForwardShortVideoOption
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void n() {
        URL url;
        Rect rect;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Rect rect2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        URL url2 = null;
        if (TextUtils.isEmpty(this.mForwardThumb)) {
            this.f210888d.a(null);
            return;
        }
        boolean z16 = false;
        if (this.mExtraData.getBoolean("isFromFavorite", false)) {
            String str = AppConstants.S_DCARD_COLLECTION + "pic/" + this.mIntent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5) + "_0";
            String str2 = this.mForwardThumb;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !new File(str2).exists() && new File(str).exists()) {
                FileUtils.copyFile(str, str2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage " + this.mForwardThumb);
        }
        if (com.tencent.mobileqq.activity.aio.item.i.f179472c) {
            File file = new File(this.mForwardThumb);
            try {
                rect = NativeGifImage.getImageSize(file, false);
                try {
                    url2 = file.toURI().toURL();
                    z16 = true;
                } catch (IOException e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "getImageSize " + e);
                    }
                    Rect rect3 = rect;
                    url = url2;
                    rect2 = rect3;
                    if (!z16) {
                    }
                    o();
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    if (QLog.isColorLevel()) {
                        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "getImageSize oom " + e);
                    }
                    Rect rect32 = rect;
                    url = url2;
                    rect2 = rect32;
                    if (!z16) {
                    }
                    o();
                }
            } catch (IOException e18) {
                e = e18;
                rect = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
                rect = null;
            }
            Rect rect322 = rect;
            url = url2;
            rect2 = rect322;
        } else {
            url = null;
        }
        if (!z16 && rect2 != null && url != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImagePath load gif start " + url);
            }
            int width = rect2.width();
            int height = rect2.height();
            float f16 = this.mActivity.getResources().getDisplayMetrics().densityDpi / 160;
            int i3 = (int) (width * f16);
            int i16 = (int) (height * f16);
            try {
                URLDrawable drawable = URLDrawableHelper.getDrawable(url, i3, i16, new com.tencent.mobileqq.drawable.b(i3, i16), BaseURLDrawableHelper.getFailedDrawable(), true);
                ForwardShortVideoOption.b bVar = this.f210888d;
                if (bVar instanceof a) {
                    ((a) bVar).b(drawable, true);
                    return;
                }
                return;
            } catch (OutOfMemoryError e26) {
                if (QLog.isColorLevel()) {
                    QLog.d("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage_getDrawable oom " + e26);
                    return;
                }
                return;
            }
        }
        o();
    }

    protected void o() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            URL generateURLForNew = RegionalThumbDownloader.generateURLForNew(this.mForwardThumb, ScreenUtil.dip2px(100.0f), ScreenUtil.dip2px(300.0f));
            if (generateURLForNew != null) {
                str = generateURLForNew.toString();
            } else {
                str = null;
            }
            URLDrawable drawable = URLDrawable.getDrawable(str);
            drawable.setBounds(0, 0, ScreenUtil.dip2px(248.0f), ScreenUtil.dip2px(248.0f));
            ThreadManagerV2.excute(new Runnable(drawable) { // from class: com.tencent.mobileqq.forward.ForwardVideoEmoticonOption.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ URLDrawable f210940d;

                {
                    this.f210940d = drawable;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ForwardVideoEmoticonOption.this, (Object) drawable);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        URLDrawableHelper.decodeLocalImage(this.f210940d, null, false);
                        ForwardVideoEmoticonOption.this.mActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardVideoEmoticonOption.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                URLDrawable uRLDrawable = AnonymousClass1.this.f210940d;
                                uRLDrawable.setBounds(0, 0, uRLDrawable.getIntrinsicWidth(), AnonymousClass1.this.f210940d.getIntrinsicHeight());
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                ForwardVideoEmoticonOption.this.f210888d.a(anonymousClass1.f210940d);
                            }
                        });
                    }
                }
            }, 16, null, false);
        } catch (OutOfMemoryError e16) {
            QLog.e("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage omm!", e16);
            this.f210888d.a(null);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onPause();
            AbstractGifImage.pauseAll();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onResume();
            AbstractGifImage.resumeAll();
        }
    }
}
