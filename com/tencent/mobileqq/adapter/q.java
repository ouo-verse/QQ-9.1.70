package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.cf;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProfileImgDownloader;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q extends BaseAdapter implements Handler.Callback {
    static IPatchRedirector $redirector_;
    boolean C;

    /* renamed from: d, reason: collision with root package name */
    Context f187233d;

    /* renamed from: e, reason: collision with root package name */
    int f187234e;

    /* renamed from: f, reason: collision with root package name */
    Drawable f187235f;

    /* renamed from: h, reason: collision with root package name */
    Drawable f187236h;

    /* renamed from: i, reason: collision with root package name */
    MqqHandler f187237i;

    /* renamed from: m, reason: collision with root package name */
    cf f187238m;

    public q(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = false;
        this.f187233d = context;
        this.f187234e = (int) context.getResources().getDimension(R.dimen.f159270z3);
        this.f187235f = context.getResources().getDrawable(R.drawable.h7n);
        this.f187236h = context.getResources().getDrawable(R.drawable.h7o);
        this.f187237i = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f187237i.removeMessages(1);
        }
    }

    public void b(cf.b bVar, View view) {
        Drawable drawable;
        URLDrawable drawable2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.PhotoWall", 2, "loadBigImage() path = " + bVar.f180641c);
        }
        if (view == null) {
            return;
        }
        try {
            e(view);
            URLDrawable drawable3 = URLDrawable.getDrawable(new URL(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_THUMB, (String) null, bVar.f180640b));
            URL url = new URL(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_BIG_FHD, (String) null, bVar.f180641c);
            boolean z16 = true;
            if (drawable3.getStatus() != 1) {
                z16 = false;
            }
            if (z16) {
                drawable2 = URLDrawable.getDrawable(url, drawable3, this.f187235f);
            } else {
                cf cfVar = this.f187238m;
                if (cfVar != null) {
                    drawable = cfVar.i();
                } else {
                    drawable = null;
                }
                if (drawable == null) {
                    drawable = this.f187236h;
                }
                drawable2 = URLDrawable.getDrawable(url, drawable, this.f187235f);
            }
            view.setTag(bVar.f180641c);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            if (imageView != null) {
                imageView.setImageDrawable(drawable2);
            }
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.PhotoWall", 2, e16.toString());
            }
            view.setTag(null);
        }
    }

    public void c(cf.b bVar, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar, (Object) view);
            return;
        }
        if (view == null) {
            return;
        }
        e(view);
        view.setTag(bVar.f180640b);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        if (imageView != null) {
            imageView.setImageDrawable(this.f187235f);
        }
    }

    public void d(cf.b bVar, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar, (Object) view);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.PhotoWall", 2, "loadThumbImage() path = " + bVar.f180640b);
        }
        try {
            Drawable drawable = null;
            URL url = new URL(ProfileImgDownloader.PROTOCOL_PROFILE_IMG_THUMB, (String) null, bVar.f180640b);
            cf cfVar = this.f187238m;
            if (cfVar != null) {
                drawable = cfVar.i();
            }
            if (drawable == null) {
                drawable = this.f187236h;
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(url, drawable, this.f187235f);
            view.setTag(bVar.f180640b);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            if (imageView != null) {
                imageView.setImageDrawable(drawable2);
            }
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.PhotoWall", 2, e16.toString());
            }
        }
    }

    public void e(View view) {
        ImageProgressCircle imageProgressCircle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
            return;
        }
        if (view != null && (imageProgressCircle = (ImageProgressCircle) view.findViewById(R.id.dea)) != null) {
            this.f187237i.removeMessages(1, imageProgressCircle);
            if (imageProgressCircle.getVisibility() != 4) {
                imageProgressCircle.setVisibility(4);
            }
        }
    }

    public void f(cf cfVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cfVar);
        } else {
            this.f187238m = cfVar;
        }
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        cf cfVar = this.f187238m;
        if (cfVar != null) {
            return cfVar.e();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        cf cfVar = this.f187238m;
        if (cfVar != null) {
            return cfVar.h(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f168207pg, (ViewGroup) null);
                ImageProgressCircle imageProgressCircle = (ImageProgressCircle) view.findViewById(R.id.dea);
                imageProgressCircle.setVisibility(4);
                ImageView imageView = (ImageView) view.findViewById(R.id.image);
                imageView.setMinimumWidth(this.f187234e);
                imageView.setMinimumHeight(this.f187234e);
                cf.b bVar = (cf.b) getItem(i3);
                if (bVar != null) {
                    if (this.C) {
                        cf cfVar = this.f187238m;
                        Drawable troopFaceDrawable = cfVar.f180638i.getTroopFaceDrawable(cfVar.f180634d, (byte) 1, false, false);
                        if (troopFaceDrawable == null) {
                            troopFaceDrawable = BaseImageUtil.getDefaultTroopFaceDrawable();
                        }
                        imageView.setImageDrawable(troopFaceDrawable);
                    } else {
                        int i16 = bVar.f180642d;
                        if (i16 == 6) {
                            b(bVar, view);
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.profilecard.PhotoWall", 2, i3 + "," + bVar.f180641c);
                            }
                        } else if (i16 != 3 && i16 != 4) {
                            imageView.setImageResource(R.drawable.h7o);
                        } else {
                            d(bVar, view);
                            if (QLog.isColorLevel()) {
                                QLog.d("Q.profilecard.PhotoWall", 2, "thumb: " + i3 + "," + bVar.f180640b);
                            }
                            if (bVar.f180644f) {
                                h(imageProgressCircle);
                            }
                        }
                    }
                }
                if (AppSetting.f99565y) {
                    imageView.setContentDescription(this.f187233d.getString(R.string.abe));
                }
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }

    public void h(ImageProgressCircle imageProgressCircle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) imageProgressCircle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.PhotoWall", 2, "showProgress() progressCircle = " + imageProgressCircle);
        }
        if (imageProgressCircle != null && !this.f187237i.hasMessages(1, imageProgressCircle)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = imageProgressCircle;
            this.f187237i.sendMessageDelayed(obtain, 550L);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1) {
            Object obj = message.obj;
            if (obj instanceof ImageProgressCircle) {
                ImageProgressCircle imageProgressCircle = (ImageProgressCircle) obj;
                if (imageProgressCircle.getVisibility() != 0) {
                    imageProgressCircle.setVisibility(0);
                }
            }
        }
        return true;
    }
}
