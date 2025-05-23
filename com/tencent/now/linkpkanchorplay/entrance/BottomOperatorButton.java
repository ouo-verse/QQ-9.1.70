package com.tencent.now.linkpkanchorplay.entrance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import com.tencent.now.linkpkanchorplay.entrance.b;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.qqlive.common.api.AegisLogger;
import om3.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BottomOperatorButton extends FrameLayout {
    private Size C;
    private v0.a D;

    /* renamed from: d, reason: collision with root package name */
    private Eventor f338152d;

    /* renamed from: e, reason: collision with root package name */
    private LinkPKHeadImageView f338153e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f338154f;

    /* renamed from: h, reason: collision with root package name */
    private DisplayImageOptions f338155h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.now.linkpkanchorplay.entrance.b f338156i;

    /* renamed from: m, reason: collision with root package name */
    private Size f338157m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements OnEvent<d.StateChangeEvent> {
        a() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(d.StateChangeEvent stateChangeEvent) {
            om3.d oldState = stateChangeEvent.getOldState();
            om3.d curState = stateChangeEvent.getCurState();
            AegisLogger.i("PK_Biz|BottomOperatorButton", "\u6309\u94ae\u6536\u5230\u72b6\u6001 oldState: " + oldState + ", curState: " + curState);
            BottomOperatorButton.this.p(oldState, curState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements OnEvent<d.LinkScreenDisabled> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(d.LinkScreenDisabled linkScreenDisabled) {
            BottomOperatorButton.this.setEnabled(!linkScreenDisabled.getDisabled());
            if (!linkScreenDisabled.getDisabled()) {
                BottomOperatorButton.this.p(null, linkScreenDisabled.getCurState());
            } else if (BottomOperatorButton.this.f338153e.getVisibility() == 0) {
                BottomOperatorButton.this.f338153e.setImageResource(R.drawable.ogo);
            } else {
                BottomOperatorButton.this.setBackgroundResource(R.drawable.ogo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class c extends v0.a {
        c() {
        }

        @Override // v0.a
        public void a(Drawable drawable) {
            super.a(drawable);
            AegisLogger.i("PK_Biz|BottomOperatorButton", "\u5f00\u59cb\u64ad\u653e\u52a8\u753b: w=" + drawable.getIntrinsicWidth() + ", h=" + drawable.getIntrinsicHeight());
            BottomOperatorButton.this.f338154f.setVisibility(0);
            BottomOperatorButton.this.k();
        }
    }

    public BottomOperatorButton(@NonNull Context context) {
        super(context);
        this.f338152d = new Eventor();
        this.f338153e = null;
        this.f338154f = null;
        this.D = new c();
        m();
        l();
    }

    private void f() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        frameLayout.removeView(this.f338154f);
        frameLayout.addView(this.f338154f);
        this.f338154f.setVisibility(4);
    }

    @NonNull
    private FrameLayout.LayoutParams g() {
        int dimensionPixelSize;
        int dimensionPixelSize2;
        Size size = this.f338157m;
        if (size != null) {
            dimensionPixelSize = size.getWidth();
            dimensionPixelSize2 = this.f338157m.getHeight();
        } else {
            dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.f159089ck0);
            dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.f159089ck0);
        }
        return new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
    }

    @NonNull
    private FrameLayout.LayoutParams h() {
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.c5h);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(R.dimen.c5h);
        Size size = this.C;
        if (size != null) {
            dimensionPixelSize = size.getWidth();
            dimensionPixelSize2 = this.C.getHeight();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    private DisplayImageOptions i() {
        if (this.f338155h == null) {
            this.f338155h = new DisplayImageOptions.Builder().showImageForEmptyUri(R.drawable.msa).showImageOnFail(R.drawable.msa).cacheInMemory(false).cacheOnDisk(true).considerExifParams(false).bitmapConfig(Bitmap.Config.ARGB_8888).delayBeforeLoading(1).displayer(new SimpleBitmapDisplayer()).build();
        }
        return this.f338155h;
    }

    private boolean j(ViewGroup viewGroup, View view) {
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            if (getChildAt(i3) == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        setBackground(null);
        this.f338153e.setVisibility(8);
    }

    private void l() {
        this.f338152d.addOnEvent(new a());
        this.f338152d.addOnEvent(new b());
    }

    private void m() {
        setBackgroundResource(R.drawable.ogn);
        LinkPKHeadImageView linkPKHeadImageView = new LinkPKHeadImageView(getContext());
        this.f338153e = linkPKHeadImageView;
        linkPKHeadImageView.setVisibility(8);
        if (!j(this, this.f338153e)) {
            addView(this.f338153e);
        }
        ImageView imageView = new ImageView(getContext());
        this.f338154f = imageView;
        imageView.setVisibility(8);
        this.f338156i = new com.tencent.now.linkpkanchorplay.entrance.b(this.f338153e, this.f338154f);
    }

    private void n() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        frameLayout.removeView(this.f338154f);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
        marginLayoutParams.rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.c5k);
        marginLayoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.c5j);
        frameLayout.setLayoutParams(marginLayoutParams);
    }

    private void o() {
        LinkPKHeadImageView linkPKHeadImageView = this.f338153e;
        if (linkPKHeadImageView != null && linkPKHeadImageView.getParent() != null) {
            this.f338153e.setVisibility(8);
            removeAllViews();
        }
        setBackgroundResource(R.drawable.ogn);
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(@Nullable om3.d dVar, om3.d dVar2) {
        if (dVar2 instanceof d.c) {
            o();
        }
        if (dVar2 instanceof d.InvitationSent) {
            q(((d.InvitationSent) dVar2).getAnchorInfo().f395729a.f395738d, false);
        }
        if (dVar2 instanceof d.C10927d) {
            q(((d.C10927d) dVar2).getInviteMsg().f401296b.f395729a.f395738d, false);
        }
        if (dVar2 instanceof d.InLinkScreen) {
            d.InLinkScreen inLinkScreen = (d.InLinkScreen) dVar2;
            String str = inLinkScreen.getAnchorInfo().f395729a.f395738d;
            if (dVar != null && (dVar instanceof d.InMatch)) {
                q(str, true);
                f();
                this.f338156i.h(new b.InterfaceC9243b() { // from class: com.tencent.now.linkpkanchorplay.entrance.BottomOperatorButton.3
                    @Override // com.tencent.now.linkpkanchorplay.entrance.b.InterfaceC9243b
                    public void a() {
                        BottomOperatorButton.this.f338153e.setVisibility(0);
                    }

                    @Override // com.tencent.now.linkpkanchorplay.entrance.b.InterfaceC9243b
                    public void onAnimEnd() {
                        ThreadCenter.postDefaultUITask(new Runnable() { // from class: com.tencent.now.linkpkanchorplay.entrance.BottomOperatorButton.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BottomOperatorButton.this.q("https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEImhtWXHOIyjHuJ3icQU0ncKNfnQ2jRf8eAsD8dgNPoJMA/", false);
                            }
                        });
                    }
                });
            } else if (this.f338156i.getMatchSuccessAnimDone()) {
                s(inLinkScreen);
            }
        }
        if (dVar2 instanceof d.InMatch) {
            r(dVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str, boolean z16) {
        this.f338153e.f(z16);
        this.f338153e.setLayoutParams(g());
        ImageLoader.getInstance().displayImage(str, this.f338153e, i());
        setBackground(null);
        this.f338153e.setVisibility(0);
        if (!j(this, this.f338153e)) {
            addView(this.f338153e);
        }
        n();
    }

    private void r(om3.d dVar) {
        FrameLayout frameLayout = (FrameLayout) getParent();
        frameLayout.removeView(this.f338154f);
        FrameLayout.LayoutParams h16 = h();
        this.f338154f.setLayoutParams(h16);
        frameLayout.addView(this.f338154f);
        this.f338154f.setVisibility(4);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) frameLayout.getLayoutParams();
        marginLayoutParams.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.c5f);
        frameLayout.setLayoutParams(marginLayoutParams);
        this.f338154f.setLayoutParams(h16);
        if (dVar instanceof d.InMatch) {
            this.f338156i.g(this.D);
        }
    }

    private void s(d.InLinkScreen inLinkScreen) {
        String str;
        FrameLayout frameLayout = (FrameLayout) getParent();
        frameLayout.removeView(this.f338154f);
        frameLayout.addView(this.f338154f);
        this.f338154f.setVisibility(4);
        if ((inLinkScreen instanceof d.InLinkScreen) && inLinkScreen.getIsInPK()) {
            str = "https://nowpic.gtimg.com/feeds_pic/PiajxSqBRaEImhtWXHOIyjHuJ3icQU0ncKNfnQ2jRf8eAsD8dgNPoJMA/";
        } else {
            str = "https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLDFpicpTDA7hjyFfK46CxCTic7uYqlrYNZ7enpxSLYgwDDg/";
        }
        q(str, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f338152d.removeAll();
        this.f338156i.b();
    }

    public void setSizeParams(Size size, Size size2) {
        this.f338157m = size;
        this.C = size;
    }

    public BottomOperatorButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f338152d = new Eventor();
        this.f338153e = null;
        this.f338154f = null;
        this.D = new c();
        m();
    }

    public BottomOperatorButton(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f338152d = new Eventor();
        this.f338153e = null;
        this.f338154f = null;
        this.D = new c();
        m();
    }
}
