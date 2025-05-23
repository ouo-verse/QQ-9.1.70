package com.tencent.mobileqq.panel;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.hotpic.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class g extends RecyclerView.OnScrollListener implements s.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private s f257176d;

    /* renamed from: e, reason: collision with root package name */
    private int f257177e;

    /* renamed from: f, reason: collision with root package name */
    private EmotionPanelListView.PullAndFastScrollListener f257178f;

    public g(EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pullAndFastScrollListener);
            return;
        }
        this.f257176d = new s(200, this);
        this.f257177e = 0;
        this.f257178f = pullAndFastScrollListener;
    }

    @Override // com.tencent.mobileqq.hotpic.s.a
    public void a(boolean z16) {
        EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else if (z16 && (pullAndFastScrollListener = this.f257178f) != null) {
            pullAndFastScrollListener.onPullUp();
            this.f257176d.b(false);
        }
    }

    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) recyclerView, (Object) motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f257176d.b(true);
            return false;
        }
        if (action == 1 && ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0 && (pullAndFastScrollListener = this.f257178f) != null) {
            pullAndFastScrollListener.onPullDown();
            return false;
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
        EmotionPanelListView.PullAndFastScrollListener pullAndFastScrollListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, i3);
            return;
        }
        if (i3 == 0) {
            AbstractGifImage.resumeAll();
        } else {
            AbstractGifImage.pauseAll();
        }
        if (i3 == 0 && this.f257177e == 2 && ((GridLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition() == 0 && (pullAndFastScrollListener = this.f257178f) != null) {
            pullAndFastScrollListener.onPullDown();
        }
        this.f257177e = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
        } else if (i16 > 0) {
            this.f257176d.a(i16);
        }
    }
}
