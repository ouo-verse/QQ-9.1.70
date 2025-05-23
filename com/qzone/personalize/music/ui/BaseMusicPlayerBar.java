package com.qzone.personalize.music.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.qzone.common.event.EventCenter;
import com.qzone.personalize.music.business.QusicService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.music.BroadcastMusicInfo;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import e8.e;

/* loaded from: classes39.dex */
public abstract class BaseMusicPlayerBar extends FrameLayout implements e {
    protected TextView C;
    protected ImageView D;
    protected ImageView E;
    protected View F;
    protected ProgressBar G;
    protected View H;
    protected int I;
    protected int J;
    protected int K;
    public long L;

    /* renamed from: d, reason: collision with root package name */
    protected int f49389d;

    /* renamed from: e, reason: collision with root package name */
    protected int f49390e;

    /* renamed from: f, reason: collision with root package name */
    protected SongInfo f49391f;

    /* renamed from: h, reason: collision with root package name */
    protected BroadcastMusicInfo f49392h;

    /* renamed from: i, reason: collision with root package name */
    protected TextView f49393i;

    /* renamed from: m, reason: collision with root package name */
    protected ImageView f49394m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseMusicPlayerBar.this.b();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseMusicPlayerBar.this.d();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            BaseMusicPlayerBar.this.c();
            EventCenter.getInstance().post("MusicPlayer", 1);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public BaseMusicPlayerBar(Context context) {
        super(context);
        this.f49390e = 0;
        this.f49391f = new SongInfo();
        this.f49392h = new BroadcastMusicInfo();
        e();
    }

    private void o(int i3, int i16) {
        this.I = i3;
        this.J = i16;
    }

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected void e() {
        f();
        setOnClickListener(new a());
        this.H = findViewById(R.id.gu8);
        View findViewById = findViewById(R.id.f166644gu3);
        findViewById.setOnClickListener(new b());
        this.f49394m = (ImageView) findViewById;
        this.f49393i = (TextView) findViewById(R.id.f166643gu2);
        this.C = (TextView) findViewById(R.id.gu6);
        View findViewById2 = findViewById(R.id.gtz);
        findViewById2.setOnClickListener(new c());
        this.D = (ImageView) findViewById2;
        this.E = (ImageView) findViewById(R.id.f166641gu0);
        this.F = findViewById(R.id.gu5);
        this.G = (ProgressBar) findViewById(R.id.f166642gu1);
        q(4);
        QusicService.O().A(this, true);
    }

    protected abstract void f();

    protected boolean g() {
        return true;
    }

    protected abstract boolean m(int i3, long j3);

    protected abstract void n(e.a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(int i3) {
        Object parent = getParent();
        if (parent instanceof View) {
            ((View) parent).setVisibility(i3);
        }
    }

    protected abstract void q(int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        String str;
        SongInfo songInfo = this.f49391f;
        if (songInfo != null) {
            str = songInfo.f251871i;
        } else {
            str = "";
        }
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TextViewPlayingMusic", "\u6b63\u5728\u64ad\u653e\u6b4c\u66f2");
        TextView textView = this.f49393i;
        if (TextUtils.isEmpty(str)) {
            str = config;
        }
        textView.setText(str);
        r();
    }

    @Override // e8.e
    public void a(e.a aVar) {
        SongInfo songInfo;
        SongInfo songInfo2;
        BroadcastMusicInfo broadcastMusicInfo;
        if (aVar != null && aVar.f395856f != 0 && (songInfo = aVar.f395852b) != null && !songInfo.J) {
            int i3 = aVar.f395851a;
            this.K = i3;
            if (!m(i3, aVar.f395853c)) {
                q(4);
                return;
            }
            int i16 = aVar.f395854d;
            if (i16 != this.f49389d && i16 == 2) {
                wo.a.b(3);
            }
            q(aVar.f395854d);
            SongInfo songInfo3 = aVar.f395852b;
            if (songInfo3 != null && !this.f49391f.equals(songInfo3) && (songInfo2 = aVar.f395852b) != null) {
                this.f49391f = songInfo2;
                if (songInfo2.I == 9 && (broadcastMusicInfo = songInfo2.K) != null) {
                    this.f49392h = broadcastMusicInfo;
                }
            }
            n(aVar);
            int i17 = aVar.f395854d;
            if (i17 == 1) {
                i();
            } else if (i17 == 2) {
                k(aVar.f395859i, aVar.f395858h);
            } else if (i17 == 3) {
                j();
            } else if (i17 != 4) {
                h();
            } else {
                l();
            }
            o(aVar.f395855e, aVar.f395857g);
            return;
        }
        if (g()) {
            setVisibility(8);
            p(8);
        }
        q(4);
        l();
    }

    public BaseMusicPlayerBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f49390e = 0;
        this.f49391f = new SongInfo();
        this.f49392h = new BroadcastMusicInfo();
        e();
    }

    public BaseMusicPlayerBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f49390e = 0;
        this.f49391f = new SongInfo();
        this.f49392h = new BroadcastMusicInfo();
        e();
    }

    protected void h() {
    }

    protected void i() {
    }

    protected void j() {
    }

    protected void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
    }

    protected void k(int i3, int i16) {
    }
}
