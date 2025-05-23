package com.tencent.mobileqq.music;

import android.R;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.IColorNoteHelper;
import com.tencent.mobileqq.colornote.smallscreen.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements com.tencent.mobileqq.colornote.f, g {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IColorNoteController f251873d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f251874e;

    /* renamed from: f, reason: collision with root package name */
    private o f251875f;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.music.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8121a implements o {
        static IPatchRedirector $redirector_;

        C8121a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.colornote.smallscreen.o
        public void onServiceSyncSucc(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else if (a.this.f251874e && a.this.f251873d != null && !a.this.f251873d.isColorNoteExist() && QQPlayerService.s0()) {
                a.this.f251873d.insertColorNote();
            }
        }
    }

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f251874e = true;
        this.f251875f = new C8121a();
        IColorNoteController iColorNoteController = (IColorNoteController) QRoute.api(IColorNoteController.class);
        this.f251873d = iColorNoteController;
        iColorNoteController.init(context, false, false);
        this.f251873d.setServiceInfo(this);
        this.f251873d.disableToast();
        this.f251873d.setServiceSyncListener(this.f251875f);
        this.f251873d.registerBroadcast();
        QQPlayerService.R(this);
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f251873d.onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ColorNote) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        SongInfo b06 = QQPlayerService.b0();
        byte[] bArr = null;
        if (b06 == null) {
            return null;
        }
        String str = b06.D;
        if (str != null) {
            bArr = str.getBytes();
        }
        return new ColorNote.a().g(R.style.Animation).i("music_color_note_only_one").d(b06.f251871i).h(b06.F).e(b06.C).f(bArr).a();
    }

    @Override // com.tencent.mobileqq.music.g
    public String getToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return QQPlayerService.o0();
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlaySongChanged(SongInfo songInfo) {
        ColorNote colorNote;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) songInfo);
            return;
        }
        if (songInfo == null || !this.f251874e || (colorNote = getColorNote()) == null) {
            return;
        }
        colorNote.mMainTitle = songInfo.f251871i;
        colorNote.mSubTitle = songInfo.F;
        colorNote.mPicUrl = songInfo.C;
        this.f251873d.updateColorNote(colorNote);
    }

    @Override // com.tencent.mobileqq.music.g
    public void onPlayStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        if (i3 != 2 && i3 != 1) {
            this.f251873d.deleteColorNote();
            return;
        }
        if (((IColorNoteHelper) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IColorNoteHelper.class, "all")).isColorNoteExit(R.style.Animation, "music_color_note_only_one")) {
            this.f251873d.deleteColorNote();
        }
        if (QQPlayerService.v0(QQPlayerService.b0()) && this.f251873d.shouldDisplayColorNote() && i3 == 2) {
            this.f251873d.insertColorNote();
        }
    }
}
