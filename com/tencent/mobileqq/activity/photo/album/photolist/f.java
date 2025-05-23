package com.tencent.mobileqq.activity.photo.album.photolist;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public abstract class f<O extends OtherCommonData> implements MediaScanner.OnMediaScannerListener, b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public PeakFragmentActivity f184309d;

    /* renamed from: e, reason: collision with root package name */
    public PhotoCommonBaseData<O> f184310e;

    /* renamed from: f, reason: collision with root package name */
    public O f184311f;

    /* renamed from: h, reason: collision with root package name */
    public e f184312h;

    /* renamed from: i, reason: collision with root package name */
    public PhotoListSceneBase f184313i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements OtherCommonData {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public f(PeakFragmentActivity peakFragmentActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) peakFragmentActivity);
            return;
        }
        this.f184309d = peakFragmentActivity;
        PhotoCommonBaseData<O> photoCommonBaseData = (PhotoCommonBaseData<O>) PhotoCommonBaseData.getInstance(peakFragmentActivity.getIntent().getBooleanExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, true));
        this.f184310e = photoCommonBaseData;
        this.f184311f = (O) photoCommonBaseData.bindCommonData((PhotoCommonBaseData<O>) x());
        peakFragmentActivity.getIntent().putExtra(PhotoCommonBaseData.NEED_NEW_PHOTO_COMMON_DATA, false);
        this.f184310e.addHoldNember();
        this.f184312h = new e();
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListCustomization new\uff0cactivity = " + peakFragmentActivity + ",PhotoCommonData = " + this.f184310e);
        }
        this.f184313i = v();
    }

    public abstract com.tencent.mobileqq.activity.photo.album.photolist.a A(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3);

    public abstract void B(Intent intent);

    public abstract void C(Intent intent);

    public abstract void D(Message message);

    public abstract void E(Intent intent);

    public abstract void F();

    public abstract void G(int i3, int i16, Intent intent);

    public void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
    }

    public abstract void I();

    public abstract void J(View view, int i3, CheckBox checkBox);

    public abstract void K(boolean z16, int i3, int i16);

    public abstract void L(View view);

    public abstract void M(CompoundButton compoundButton, boolean z16);

    public abstract boolean N(List<LocalMediaInfo> list);

    public abstract void O(View view);

    public abstract void P(View view);

    public abstract List<LocalMediaInfo> Q(Object... objArr);

    public abstract void R(Intent intent);

    public abstract void S(List<LocalMediaInfo> list, int i3);

    public abstract void T();

    public abstract boolean a(LocalMediaInfo localMediaInfo, boolean z16);

    public abstract void c(View view, int i3);

    public abstract Intent k(View view, int i3);

    public abstract void l(View view, int i3);

    public abstract void p(View view, int i3);

    public void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListCustomization close\uff0cactivity = " + this.f184309d + ",PhotoCommonData = " + this.f184310e);
        }
        this.f184310e.releaseCommonData();
    }

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void u(Intent intent);

    public PhotoListSceneBase v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PhotoListSceneBase) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new PhotoListSceneBase(this);
    }

    public abstract AbstractAlbumListFragment w();

    protected OtherCommonData x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (OtherCommonData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    public abstract com.tencent.mobileqq.activity.photo.album.photolist.a y(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3);

    public abstract com.tencent.mobileqq.activity.photo.album.photolist.a z(@NonNull com.tencent.mobileqq.activity.photo.album.photolist.a aVar, int i3);
}
