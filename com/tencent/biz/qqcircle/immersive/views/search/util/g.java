package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.views.search.feed.QFSSearchFeedResultItemView;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g implements View.OnClickListener, e80.c, QFSSearchVideoPlayHelper.b {

    /* renamed from: d, reason: collision with root package name */
    private final ImageView f91259d;

    /* renamed from: e, reason: collision with root package name */
    private final e80.g f91260e;

    /* renamed from: f, reason: collision with root package name */
    private int f91261f = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f91262h;

    public g(ImageView imageView, e80.g gVar) {
        this.f91259d = imageView;
        this.f91260e = gVar;
    }

    private void d() {
        e80.g gVar = this.f91260e;
        if (gVar instanceof QFSSearchFeedResultItemView) {
            ((QFSSearchFeedResultItemView) gVar).y0(a());
        }
        e80.g gVar2 = this.f91260e;
        if (gVar2 instanceof k80.d) {
            ((k80.d) gVar2).s1(a());
        }
    }

    private void g(int i3) {
        this.f91261f = i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    this.f91259d.setImageResource(R.drawable.ntn);
                    this.f91259d.setOnClickListener(this);
                    return;
                }
                return;
            }
            this.f91259d.setImageResource(R.drawable.common_loading2);
            this.f91259d.setOnClickListener(null);
            return;
        }
        this.f91259d.setImageResource(R.drawable.nto);
        this.f91259d.setOnClickListener(this);
    }

    public int a() {
        int i3 = this.f91261f;
        if (i3 == 1) {
            return 2;
        }
        if (i3 != 2) {
            return 1;
        }
        return 0;
    }

    public void b() {
        this.f91259d.setVisibility(8);
    }

    public boolean c() {
        if (this.f91261f != 0) {
            return true;
        }
        return false;
    }

    public void e() {
        this.f91259d.setOnClickListener(this);
        this.f91262h = false;
    }

    public void f(boolean z16) {
        this.f91262h = z16;
    }

    public void h() {
        g(0);
    }

    public void i() {
        this.f91259d.setVisibility(0);
    }

    @Override // e80.c
    public boolean l() {
        return this.f91262h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.b("QFSSearchPlayIconHelper", 500L)) {
            d();
            if (this.f91260e.isPlaying()) {
                this.f91260e.stop();
                h();
                this.f91262h = true;
            } else {
                this.f91260e.play();
                setStatusPlay();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.b
    public void setStatusLoading() {
        g(1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.b
    public void setStatusPlay() {
        g(2);
    }
}
