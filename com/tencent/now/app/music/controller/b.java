package com.tencent.now.app.music.controller;

import android.app.Activity;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface b {
    void a();

    int b();

    void c();

    void d(boolean z16);

    void e(String str);

    void f(MusicItem musicItem);

    MusicItem g();

    void h();

    void i(MusicItem musicItem);

    void j(boolean z16);

    a k();

    void l(boolean z16);

    void m();

    Activity o();

    void onProgressUpdate(int i3, int i16);

    void p();

    void q();

    void r(int i3, String str);

    void s();

    void setMusicPlayMgr(MusicPlayMgr musicPlayMgr);

    void setNoLyricsMode();
}
