package com.tencent.mobileqq.picbrowser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.galleryactivity.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<PicBrowserImage> f258926a;

    /* renamed from: b, reason: collision with root package name */
    private int f258927b;

    /* renamed from: c, reason: collision with root package name */
    private Context f258928c;

    public c(Context context, List<PicInfo> list) {
        PicBrowserImage aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) list);
            return;
        }
        this.f258926a = new ArrayList<>();
        this.f258928c = context;
        if (list != null && !list.isEmpty()) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                PicInfo picInfo = list.get(i3);
                if (ShortVideoUtils.isVideoSoLibLoaded() && (!TextUtils.isEmpty(picInfo.f258920i) || !TextUtils.isEmpty(picInfo.f258921m))) {
                    aVar = new GalleryItemVideo(this.f258928c, picInfo);
                } else {
                    aVar = new a(this.f258928c, picInfo);
                }
                this.f258926a.add(aVar);
            }
        }
    }

    @Override // com.tencent.common.galleryactivity.e
    public void a(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        this.f258927b = i3;
        for (int i16 = 0; i16 < this.f258926a.size(); i16++) {
            PicBrowserImage picBrowserImage = this.f258926a.get(i16);
            if (i3 == i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            picBrowserImage.f(z16);
        }
    }

    @Override // com.tencent.common.galleryactivity.e
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public PicBrowserImage getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PicBrowserImage) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        if (i3 >= 0 && i3 < this.f258926a.size()) {
            return this.f258926a.get(i3);
        }
        return null;
    }

    @Override // com.tencent.common.galleryactivity.e
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public PicBrowserImage b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PicBrowserImage) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        int i3 = this.f258927b;
        if (i3 >= 0 && i3 < this.f258926a.size()) {
            return this.f258926a.get(this.f258927b);
        }
        return null;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = this.f258927b;
        if (i3 >= 0 && i3 < this.f258926a.size()) {
            this.f258926a.get(this.f258927b).e();
        }
    }

    @Override // com.tencent.common.galleryactivity.e
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f258926a.size();
    }

    @Override // com.tencent.common.galleryactivity.e
    public int getSelectedIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f258927b;
    }
}
