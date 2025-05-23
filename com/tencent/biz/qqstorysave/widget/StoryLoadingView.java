package com.tencent.biz.qqstorysave.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes5.dex */
public class StoryLoadingView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    protected AnimationDrawable f94554d;

    public StoryLoadingView(Context context) {
        super(context);
        a();
    }

    private void a() {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        this.f94554d = animationDrawable;
        animationDrawable.addFrame(getResources().getDrawable(R.drawable.f161982fd3), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.f161983fd4), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fd5), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fd6), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fd7), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fd8), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fd9), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fd_), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fda), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdb), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdc), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdd), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fde), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdf), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdg), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdh), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdi), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdj), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdk), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdl), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdm), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdn), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdo), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdp), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdq), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdr), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fds), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdt), 50);
        this.f94554d.addFrame(getResources().getDrawable(R.drawable.fdu), 50);
        this.f94554d.setOneShot(false);
        super.setImageDrawable(this.f94554d);
        AnimationDrawable animationDrawable2 = this.f94554d;
        if (animationDrawable2 != null && !animationDrawable2.isRunning()) {
            this.f94554d.start();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        if (i3 == 0 && !this.f94554d.isRunning()) {
            this.f94554d.start();
        } else if (this.f94554d.isRunning()) {
            this.f94554d.stop();
        }
    }

    public StoryLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public StoryLoadingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
