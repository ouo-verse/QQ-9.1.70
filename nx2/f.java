package nx2;

import android.animation.Animator;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import px2.e;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f extends c {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends e.a {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.g(false, true);
            f.this.f421525b.setTranslationX(0.0f);
        }
    }

    public f(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        g(false, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // nx2.c
    protected mx2.d c() {
        return new mx2.e(this.f421525b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nx2.c
    /* renamed from: e */
    public void i(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
        super.i(tVideoChannelList$VideoChannelData);
        px2.e.n(this.f421525b, new a());
    }

    @Override // nx2.c
    protected String f() {
        return "vertical";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nx2.c
    public void h() {
        super.h();
        this.f421524a.setOnClickListener(new View.OnClickListener() { // from class: nx2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.q(view);
            }
        });
    }
}
