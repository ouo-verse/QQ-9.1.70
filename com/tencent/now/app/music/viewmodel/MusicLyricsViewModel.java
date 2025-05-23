package com.tencent.now.app.music.viewmodel;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.component.core.log.LogUtil;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.lyric.util.d;
import com.tencent.lyric.widget.LyricViewController;
import com.tencent.mobileqq.R;
import com.tencent.now.app.music.model.data.MusicItem;
import com.tencent.now.app.music.model.manager.MusicPlayMgr;
import com.tencent.now.app.music.view.FloatLyricsView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicLyricsViewModel implements ThreadCenter.HandlerKeyable {
    private Runnable C;
    private MusicItem D;
    private boolean E = true;
    private MusicPlayMgr F;

    /* renamed from: d, reason: collision with root package name */
    private FloatLyricsView f338068d;

    /* renamed from: e, reason: collision with root package name */
    private Context f338069e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.lyric.data.a f338070f;

    /* renamed from: h, reason: collision with root package name */
    private LyricViewController f338071h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.now.app.music.controller.b f338072i;

    /* renamed from: m, reason: collision with root package name */
    private Runnable f338073m;

    public MusicLyricsViewModel(Context context, FloatLyricsView floatLyricsView) {
        this.f338069e = context;
        this.f338068d = floatLyricsView;
        d();
    }

    public void b() {
        ThreadCenter.clear(this);
    }

    public void c() {
        this.f338068d.E.setVisibility(8);
    }

    public void d() {
        this.f338068d.D.setIsDealTouchEvent(false);
        LyricViewController lyricViewController = new LyricViewController(this.f338068d.D);
        this.f338071h = lyricViewController;
        lyricViewController.n(2);
        this.f338073m = new Runnable() { // from class: com.tencent.now.app.music.viewmodel.MusicLyricsViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                MusicLyricsViewModel.this.f338068d.E.setVisibility(8);
            }
        };
        this.C = new Runnable() { // from class: com.tencent.now.app.music.viewmodel.MusicLyricsViewModel.2
            @Override // java.lang.Runnable
            public void run() {
                MusicLyricsViewModel.this.f338068d.D.setVisibility(4);
            }
        };
    }

    public void e() {
        this.f338071h.p(0);
    }

    public void f(int i3) {
        this.f338071h.p(i3);
    }

    public void g(int i3) {
        int c16 = i3 - this.f338071h.c();
        LogUtil.i("MusicLyricsViewModel", "seekLyrics position:" + i3 + " dif:" + c16, new Object[0]);
        if (c16 > 1000 || c16 < 1000) {
            this.f338071h.j(i3);
        }
    }

    public void h() {
        this.f338068d.D.setVisibility(0);
    }

    public void i(MusicItem musicItem) {
        this.D = musicItem;
        this.f338068d.D.setVisibility(0);
        if (musicItem != null && !TextUtils.isEmpty(musicItem.songLyric)) {
            com.tencent.lyric.data.a a16 = com.tencent.lyric.util.c.a(musicItem.songLyric, false);
            this.f338070f = a16;
            this.f338071h.l(null, a16, null);
            this.f338071h.m(AppUtils.UI.dip2px(2.0f), AppUtils.UI.dip2px(0.0f), AppUtils.UI.dip2px(1.0f), Color.parseColor("#7AFFFFFF"));
            k(false);
            return;
        }
        com.tencent.lyric.data.a a17 = com.tencent.lyric.util.c.a("[00:00:00]\u672c\u6b4c\u66f2\u6682\u65e0\u6b4c\u8bcd", false);
        this.f338070f = a17;
        this.f338071h.l(null, a17, null);
        this.f338071h.k(d.f147091a);
        k(false);
        ThreadCenter.postDelayedUITask(this, this.C, 3000L);
    }

    public void j() {
        SpannableString spannableString = new SpannableString("\u6b4c\u66f2\u52a0\u8f7d\u5931\u8d25\uff0c\u70b9\u51fb\u91cd\u8bd5");
        spannableString.setSpan(new ForegroundColorSpan(this.f338069e.getResources().getColor(R.color.bi5)), 7, 11, 33);
        this.f338068d.E.setClickable(true);
        this.f338068d.E.setVisibility(0);
        this.f338068d.E.setTextSize(0, com.tencent.misc.utils.a.b(this.f338069e, 14.0f));
        this.f338068d.E.setText(spannableString);
        ThreadCenter.removeUITask(this, this.f338073m);
    }

    public void k(boolean z16) {
        this.E = z16;
    }

    public void l(com.tencent.now.app.music.controller.b bVar) {
        this.f338072i = bVar;
    }

    public void m(MusicPlayMgr musicPlayMgr) {
        this.F = musicPlayMgr;
    }

    public void n() {
        this.f338068d.D.setVisibility(8);
    }

    public void o(String str, boolean z16) {
        this.f338068d.E.setClickable(false);
        this.f338068d.E.setVisibility(0);
        this.f338068d.E.setTextSize(0, com.tencent.misc.utils.a.b(this.f338069e, 12.0f));
        this.f338068d.E.setText(str);
        ThreadCenter.removeUITask(this, this.f338073m);
        if (!z16) {
            ThreadCenter.postDelayedUITask(this, this.f338073m, 3000L);
        }
    }

    public void p() {
        this.f338071h.q();
    }
}
