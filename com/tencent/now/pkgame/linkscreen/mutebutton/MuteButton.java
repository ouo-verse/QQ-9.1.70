package com.tencent.now.pkgame.linkscreen.mutebutton;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.util.x;
import com.tencent.now.pkgame.linkscreen.mutebutton.MuteButton;
import com.tencent.now.pkgame.linkscreen.mutebutton.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MuteButton extends AppCompatImageView implements do3.a {
    private Runnable C;

    /* renamed from: m, reason: collision with root package name */
    private final f f338921m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.now.pkgame.linkscreen.mutebutton.MuteButton$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    public class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(boolean z16) {
            MuteButton.this.w(z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3) {
            MuteButton.this.y(i3);
        }

        @Override // java.lang.Runnable
        public void run() {
            MuteButton.this.f338921m.k(new f.b() { // from class: com.tencent.now.pkgame.linkscreen.mutebutton.d
                @Override // com.tencent.now.pkgame.linkscreen.mutebutton.f.b
                public final void a(boolean z16) {
                    MuteButton.AnonymousClass1.this.c(z16);
                }
            }, new f.c() { // from class: com.tencent.now.pkgame.linkscreen.mutebutton.e
                @Override // com.tencent.now.pkgame.linkscreen.mutebutton.f.c
                public final void a(int i3) {
                    MuteButton.AnonymousClass1.this.d(i3);
                }
            });
        }
    }

    public MuteButton(Context context, long j3, boolean z16, fo3.b bVar) {
        super(context);
        this.C = new AnonymousClass1();
        r();
        this.f338921m = new f(z16, j3, bVar);
        post(this.C);
    }

    private void r() {
        setScaleType(ImageView.ScaleType.FIT_XY);
        int c16 = x.c(getContext(), 0.0f);
        setPadding(c16, c16, c16, c16);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.now.pkgame.linkscreen.mutebutton.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MuteButton.this.t(view);
            }
        });
        x("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDOiaZBu9WgKrLlwXlQOvkq3U74kArFmicckv8gLOh0Xq3w/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        this.f338921m.g();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(String str) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        setImageDrawable(URLDrawable.getDrawable(str, obtain));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(int i3) {
        setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z16) {
        String str;
        if (z16) {
            str = "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLCUtia9Juc8geC4a6cOOMKO49rU5rMricvTzGsWHiawcFKPw/";
        } else {
            str = "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDOiaZBu9WgKrLlwXlQOvkq3U74kArFmicckv8gLOh0Xq3w/";
        }
        x(str);
    }

    private void x(final String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.now.pkgame.linkscreen.mutebutton.c
            @Override // java.lang.Runnable
            public final void run() {
                MuteButton.this.u(str);
            }
        });
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(x.c(getContext(), 24.0f), x.c(getContext(), 24.0f));
    }

    public void setSeiInfoSubs(com.tencent.now.pkgame.linkandpkobserver.audience.b bVar) {
        this.f338921m.o(bVar);
    }

    @Override // do3.a
    public void unInit() {
        removeCallbacks(this.C);
        this.f338921m.s();
    }

    public void y(final int i3) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.now.pkgame.linkscreen.mutebutton.a
            @Override // java.lang.Runnable
            public final void run() {
                MuteButton.this.v(i3);
            }
        });
    }
}
