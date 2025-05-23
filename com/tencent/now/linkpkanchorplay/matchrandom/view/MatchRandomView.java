package com.tencent.now.linkpkanchorplay.matchrandom.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.component.appx.utils.AppUtils;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.linkpkanchorplay.base.LinkPKHeadImageView;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.MatchRandomViewModel;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import u0.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MatchRandomView extends LinearLayout implements ThreadCenter.HandlerKeyable {
    private long C;
    private UIEvent.PKType D;
    private MatchRandomViewModel E;
    private AnimatorSet F;
    private e G;

    /* renamed from: d, reason: collision with root package name */
    private View f338366d;

    /* renamed from: e, reason: collision with root package name */
    private Button f338367e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f338368f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f338369h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f338370i;

    /* renamed from: m, reason: collision with root package name */
    private LinkPKHeadImageView f338371m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a
        public void a(e55.c cVar) {
            MatchRandomView.this.o(cVar);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a
        public void b(String str, boolean z16) {
            MatchRandomView.this.n(str, z16);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a
        public void c() {
            MatchRandomView.this.n("onMatchTimeout", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a {
        b() {
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a
        public void a(e55.c cVar) {
            MatchRandomView.this.o(cVar);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a
        public void b(String str, boolean z16) {
            MatchRandomView.this.n(str, z16);
        }

        @Override // com.tencent.now.linkpkanchorplay.matchrandom.viewmodel.a
        public void c() {
            MatchRandomView.this.n("onMatchTimeout", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MatchRandomView.this.g();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface e {
        void onHide(boolean z16);
    }

    public MatchRandomView(@NonNull Context context) {
        super(context);
        j();
    }

    private void f() {
        AnimatorSet animatorSet = this.F;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.F = null;
        }
        this.f338371m.clearAnimation();
    }

    private void h() {
        ThreadCenter.postDelayedUITask(this, new Runnable() { // from class: com.tencent.now.linkpkanchorplay.matchrandom.view.MatchRandomView.4
            @Override // java.lang.Runnable
            public void run() {
                if (MatchRandomView.this.G != null) {
                    MatchRandomView.this.G.onHide(false);
                }
            }
        }, 1000L);
    }

    private void i() {
        MatchRandomViewModel matchRandomViewModel = this.E;
        if (matchRandomViewModel == null) {
            return;
        }
        if (matchRandomViewModel.a2()) {
            AegisLogger.i("PK_Biz|MatchRandomView", "already in matching...");
        } else if (k()) {
            this.E.c2(this.C, this.D, new a());
        } else {
            this.E.b2(this.C, this.D, new b());
        }
        this.f338367e.setOnClickListener(new c());
    }

    private boolean k() {
        UIEvent.PKType pKType = this.D;
        if (pKType != UIEvent.PKType.Rank_Link_PK && pKType != UIEvent.PKType.Rank_Normal_PK) {
            return false;
        }
        return true;
    }

    private void l() {
        u0.a.h().loadImage("https://dlied5.qq.com/now/qq-live/images/random_match_pk_anim.png", new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, boolean z16) {
        tm3.b.f436626a.a(3, null);
        AegisLogger.i("PK_Biz|MatchRandomView", "hasCancelMatch: " + this.E.Z1() + ", errMsg:" + str + ", msgFromServer:" + z16);
        if (!this.E.Z1()) {
            if (z16 && !TextUtils.isEmpty(str)) {
                UIUtil.g(str, false);
            } else {
                UIUtil.e(R.string.f1643825o, false);
            }
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(e55.c cVar) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onMatchSucceed, anchorInfo is null? ");
        if (cVar == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        AegisLogger.i("PK_Biz|MatchRandomView", sb5.toString());
        this.f338368f.setText("\u5339\u914d\u6210\u529f");
        this.f338369h.setText(cVar.f395737c);
        this.f338369h.setVisibility(0);
        this.f338367e.setVisibility(8);
        this.f338370i.setVisibility(8);
        this.f338371m.setVisibility(0);
        if (!TextUtils.isEmpty(cVar.f395738d)) {
            int b16 = com.tencent.misc.utils.a.b(this.f338371m.getContext(), 52.0f);
            ImageLoader.getInstance().displayImage(cVar.f395738d, this.f338371m, new ImageSize(b16, b16));
            p();
        }
        h();
    }

    private void p() {
        if (!isAttachedToWindow()) {
            return;
        }
        f();
        LinkPKHeadImageView linkPKHeadImageView = this.f338371m;
        AnimatorSet animatorSet = new AnimatorSet();
        this.F = animatorSet;
        animatorSet.setInterpolator(new OvershootInterpolator());
        this.F.setDuration(500L);
        this.F.playTogether(ObjectAnimator.ofFloat(linkPKHeadImageView, BasicAnimation.KeyPath.SCALE_X, 0.45f, 1.0f), ObjectAnimator.ofFloat(linkPKHeadImageView, BasicAnimation.KeyPath.SCALE_Y, 0.45f, 1.0f), ObjectAnimator.ofFloat(linkPKHeadImageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bitmap bitmap) {
        float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
        DisplayMetrics screenMetrics = AppUtils.UI.getScreenMetrics();
        ViewGroup.LayoutParams layoutParams = this.f338370i.getLayoutParams();
        if (bitmap.getWidth() >= 0 && bitmap.getHeight() >= 0) {
            int i3 = screenMetrics.widthPixels;
            layoutParams.height = (int) ((i3 * 1.0f) / width);
            layoutParams.width = i3;
        } else {
            layoutParams.height = 0;
            layoutParams.width = 0;
        }
        this.f338370i.setLayoutParams(layoutParams);
    }

    public void g() {
        if (k()) {
            this.E.T1(this.D);
        } else {
            this.E.S1();
        }
        e eVar = this.G;
        if (eVar != null) {
            eVar.onHide(true);
        }
    }

    public void j() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fek, (ViewGroup) this, true);
        this.f338366d = inflate;
        this.f338367e = (Button) inflate.findViewById(R.id.yy4);
        this.f338369h = (TextView) this.f338366d.findViewById(R.id.yy5);
        this.f338368f = (TextView) this.f338366d.findViewById(R.id.f98175md);
        LinkPKHeadImageView linkPKHeadImageView = (LinkPKHeadImageView) this.f338366d.findViewById(R.id.f166193yy3);
        this.f338371m = linkPKHeadImageView;
        linkPKHeadImageView.f(true);
        this.f338370i = (ImageView) this.f338366d.findViewById(R.id.f166192yy2);
        l();
    }

    public void m() {
        ThreadCenter.clear(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public void setListener(e eVar) {
        this.G = eVar;
    }

    public void setPKInfo(long j3, UIEvent.PKType pKType) {
        this.C = j3;
        this.D = pKType;
    }

    public void setViewModelStoreOwner(ViewModelStoreOwner viewModelStoreOwner) {
        if (this.E == null && viewModelStoreOwner != null) {
            this.E = (MatchRandomViewModel) new ViewModelProvider(viewModelStoreOwner).get(MatchRandomViewModel.class);
            i();
        }
    }

    public MatchRandomView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        j();
    }

    public MatchRandomView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements ImageLoadingListener {
        d() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            AegisLogger.i("PK_Biz|MatchRandomView", "onLoadingComplete Bitmap \u5c3a\u5bf8:" + bitmap.getWidth() + ", " + bitmap.getHeight());
            MatchRandomView.this.q(bitmap);
            u0.a.h().c("https://dlied5.qq.com/now/qq-live/images/random_match_pk_anim.png", MatchRandomView.this.f338370i, new a.c(0, true, true));
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingStarted(String str, View view) {
        }

        @Override // com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
        }
    }
}
