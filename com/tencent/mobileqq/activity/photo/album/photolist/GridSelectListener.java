package com.tencent.mobileqq.activity.photo.album.photolist;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PhotoGridView;

/* compiled from: P */
/* loaded from: classes10.dex */
public class GridSelectListener implements PhotoGridView.OnSelectListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    PhotoListSceneBase f184269a;

    /* renamed from: b, reason: collision with root package name */
    boolean f184270b;

    /* renamed from: c, reason: collision with root package name */
    int f184271c;

    /* renamed from: d, reason: collision with root package name */
    int f184272d;

    /* renamed from: e, reason: collision with root package name */
    Handler f184273e;

    public GridSelectListener(PhotoListSceneBase photoListSceneBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) photoListSceneBase);
        } else {
            this.f184273e = new Handler(Looper.getMainLooper());
            this.f184269a = photoListSceneBase;
        }
    }

    private boolean b(int i3, int i16) {
        if (i16 < i3) {
            int i17 = this.f184272d;
            this.f184272d = Math.min(i16, i17);
            if (i16 < i17) {
                if (this.f184270b && this.f184269a.f184279i.f184300k) {
                    return true;
                }
                for (int i18 = i17 - 1; i18 >= i16; i18--) {
                    a().a(this.f184269a.Q.m0(i18), this.f184270b);
                    if (this.f184270b && this.f184269a.f184279i.f184300k) {
                        a().T();
                        this.f184269a.Q.notifyDataSetChanged();
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        int i19 = this.f184271c;
        this.f184271c = Math.max(i16, i19);
        if (i16 > i19) {
            if (this.f184270b && this.f184269a.f184279i.f184300k) {
                return true;
            }
            for (int i26 = i19 + 1; i26 <= i16; i26++) {
                PhotoListSceneBase photoListSceneBase = this.f184269a;
                photoListSceneBase.f184278h.a(photoListSceneBase.Q.m0(i26), this.f184270b);
                if (this.f184270b) {
                    PhotoListSceneBase photoListSceneBase2 = this.f184269a;
                    if (photoListSceneBase2.f184279i.f184300k) {
                        photoListSceneBase2.f184278h.T();
                        this.f184269a.Q.notifyDataSetChanged();
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    f<? extends OtherCommonData> a() {
        PhotoListSceneBase photoListSceneBase = this.f184269a;
        if (photoListSceneBase != null) {
            return photoListSceneBase.f184278h;
        }
        return null;
    }

    @Override // com.tencent.widget.PhotoGridView.OnSelectListener
    public void onSelectBegin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (a().f184310e.isSingleMode) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onSelectBegin beginIndex:" + i3);
        }
        PhotoListSceneBase photoListSceneBase = this.f184269a;
        boolean z16 = false;
        photoListSceneBase.f184279i.f184300k = false;
        this.f184270b = false;
        this.f184272d = i3;
        this.f184271c = i3;
        LocalMediaInfo m06 = photoListSceneBase.Q.m0(i3);
        if (m06.selectStatus == 2) {
            z16 = true;
        }
        this.f184270b = z16;
        if (this.f184269a.f184278h.a(m06, z16)) {
            this.f184269a.f184278h.T();
            this.f184269a.Q.notifyItemChanged(i3);
        }
    }

    @Override // com.tencent.widget.PhotoGridView.OnSelectListener
    public void onSelectChanged(int i3, int i16) {
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (a().f184310e.isSingleMode) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onSelectChanged beginIndex:" + i3 + " selectIndex:" + i16);
        }
        int min = Math.min(i3, i16);
        int max = Math.max(i3, i16);
        if (b(i3, i16)) {
            return;
        }
        for (int i18 = this.f184272d; i18 < min; i18++) {
            PhotoListSceneBase photoListSceneBase = this.f184269a;
            photoListSceneBase.f184278h.a(photoListSceneBase.Q.m0(i18), !this.f184270b);
        }
        int i19 = max + 1;
        while (true) {
            i17 = this.f184271c;
            if (i19 > i17) {
                break;
            }
            PhotoListSceneBase photoListSceneBase2 = this.f184269a;
            photoListSceneBase2.f184278h.a(photoListSceneBase2.Q.m0(i19), !this.f184270b);
            i19++;
        }
        if (i16 < i3) {
            this.f184272d = i16;
            if (i17 > i3) {
                this.f184271c = i3;
            }
        } else {
            this.f184271c = i16;
            if (this.f184272d < i3) {
                this.f184272d = i3;
            }
        }
        this.f184269a.f184278h.T();
        this.f184273e.post(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.photolist.GridSelectListener.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GridSelectListener.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    GridSelectListener.this.f184269a.Q.notifyDataSetChanged();
                }
            }
        });
    }

    @Override // com.tencent.widget.PhotoGridView.OnSelectListener
    public void onSelectEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a().K(this.f184270b, this.f184271c, this.f184272d);
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "onSelectEnd");
        }
    }
}
