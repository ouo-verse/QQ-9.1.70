package com.tencent.mobileqq.hotpic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.hotpic.s;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes9.dex */
public class NTHotPicRecyclerView extends FooterRecyclerView implements s.a {
    static IPatchRedirector $redirector_;
    public static boolean E;
    c C;
    boolean D;

    /* renamed from: e, reason: collision with root package name */
    int f236998e;

    /* renamed from: f, reason: collision with root package name */
    int[] f236999f;

    /* renamed from: h, reason: collision with root package name */
    boolean f237000h;

    /* renamed from: i, reason: collision with root package name */
    b f237001i;

    /* renamed from: m, reason: collision with root package name */
    s f237002m;

    /* loaded from: classes9.dex */
    class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTHotPicRecyclerView.this);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            b bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) recyclerView, i3);
                return;
            }
            if (i3 == 0) {
                AbstractGifImage.resumeAll();
                NTHotPicRecyclerView.this.d();
            } else {
                NTHotPicRecyclerView.this.e();
                AbstractGifImage.pauseAll();
            }
            if (i3 == 2) {
                NTHotPicRecyclerView.this.f237002m.b(true);
            } else {
                NTHotPicRecyclerView.this.f237002m.b(false);
            }
            if (i3 == 0) {
                NTHotPicRecyclerView nTHotPicRecyclerView = NTHotPicRecyclerView.this;
                if (nTHotPicRecyclerView.f236998e == 2) {
                    ((StaggeredGridLayoutManager) nTHotPicRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPositions(NTHotPicRecyclerView.this.f236999f);
                    NTHotPicRecyclerView nTHotPicRecyclerView2 = NTHotPicRecyclerView.this;
                    if (nTHotPicRecyclerView2.f236999f[0] == 0 && (bVar = nTHotPicRecyclerView2.f237001i) != null) {
                        bVar.onPullDown();
                    }
                }
            }
            NTHotPicRecyclerView.this.f236998e = i3;
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(i3), Integer.valueOf(i16));
            } else if (i16 > 0) {
                NTHotPicRecyclerView.this.f237002m.a(i16);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onPullDown();

        void onPullUp();
    }

    /* loaded from: classes9.dex */
    public interface c {
        void onScrollEnd();

        void onScrollStart();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51581);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            E = false;
        }
    }

    public NTHotPicRecyclerView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // com.tencent.mobileqq.hotpic.s.a
    public void a(boolean z16) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        if (z16 && (bVar = this.f237001i) != null && NTHotPicPageView.f236975c0) {
            bVar.onPullUp();
        }
        this.f237002m.b(false);
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        c cVar = this.C;
        if (cVar != null) {
            cVar.onScrollEnd();
        }
        this.D = false;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.D) {
            return;
        }
        this.D = true;
        c cVar = this.C;
        if (cVar != null) {
            cVar.onScrollStart();
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onScrollChanged(i3, i16, i17, i18);
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) motionEvent)).booleanValue();
        }
        NTHotPicPageView.f236975c0 = true;
        if (motionEvent.getAction() == 1) {
            ((StaggeredGridLayoutManager) getLayoutManager()).findFirstCompletelyVisibleItemPositions(this.f236999f);
            if (this.f236999f[0] == 0 && (bVar = this.f237001i) != null) {
                bVar.onPullDown();
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e16) {
            QLog.e("HotPicRecyclerView", 1, "onTouchEvent error: " + e16);
            return true;
        }
    }

    public void setScrollStatusChengedListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            this.C = cVar;
        }
    }

    public NTHotPicRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f236998e = 0;
        this.f236999f = new int[3];
        this.f237000h = false;
        this.f237002m = new s(200, this);
        this.D = false;
        setOnScrollListener(new a());
    }
}
