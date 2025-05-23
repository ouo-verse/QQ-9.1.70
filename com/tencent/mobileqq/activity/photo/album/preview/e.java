package com.tencent.mobileqq.activity.photo.album.preview;

import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class e<O extends OtherCommonData> implements com.tencent.mobileqq.activity.photo.album.preview.view.a, com.tencent.mobileqq.activity.photo.album.preview.presenter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public PeakFragmentActivity f184333d;

    /* renamed from: e, reason: collision with root package name */
    public PhotoCommonBaseData<O> f184334e;

    /* renamed from: f, reason: collision with root package name */
    public O f184335f;

    /* renamed from: h, reason: collision with root package name */
    public d f184336h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.mobileqq.activity.photo.album.preview.presenter.c f184337i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements OtherCommonData {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public e(PeakFragmentActivity peakFragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) peakFragmentActivity);
            return;
        }
        this.f184333d = peakFragmentActivity;
        PhotoCommonBaseData<O> photoCommonBaseData = (PhotoCommonBaseData<O>) PhotoCommonBaseData.getInstance(peakFragmentActivity.getIntent().getBooleanExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, true));
        this.f184334e = photoCommonBaseData;
        this.f184335f = (O) photoCommonBaseData.bindCommonData((PhotoCommonBaseData<O>) u());
        peakFragmentActivity.getIntent().putExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, false);
        this.f184334e.addHoldNember();
        this.f184336h = new d();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoPreviewCustomization new\uff0cactivity = " + peakFragmentActivity + ",PhotoCommonData = " + this.f184334e);
        }
    }

    public boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    protected OtherCommonData u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (OtherCommonData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    public com.tencent.mobileqq.activity.photo.album.preview.view.c v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.activity.photo.album.preview.view.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f184337i.f184340d;
    }
}
