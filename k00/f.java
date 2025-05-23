package k00;

import UserGrowth.stSimpleMetaFeed;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.WSNumUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private Animation f411340a;

    /* renamed from: b, reason: collision with root package name */
    private Animation f411341b;

    /* renamed from: c, reason: collision with root package name */
    private Animation f411342c;

    /* renamed from: d, reason: collision with root package name */
    private Animation f411343d;

    /* renamed from: e, reason: collision with root package name */
    private Animation f411344e;

    /* renamed from: f, reason: collision with root package name */
    private AnimationSet f411345f;

    /* renamed from: g, reason: collision with root package name */
    private AnimationSet f411346g;

    /* renamed from: h, reason: collision with root package name */
    private View f411347h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f411348i;

    /* renamed from: j, reason: collision with root package name */
    private View f411349j;

    /* renamed from: k, reason: collision with root package name */
    private stSimpleMetaFeed f411350k;

    private void g(boolean z16) {
        View view = this.f411347h;
        if (view == null || this.f411349j == null) {
            return;
        }
        if (z16) {
            view.setSelected(true);
            this.f411349j.setVisibility(0);
            if (this.f411340a == null) {
                this.f411340a = AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154861so);
            }
            if (this.f411342c == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154863sq);
                this.f411342c = loadAnimation;
                loadAnimation.setStartOffset(40L);
            }
            if (this.f411341b == null) {
                Animation loadAnimation2 = AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154862sp);
                this.f411341b = loadAnimation2;
                loadAnimation2.setStartOffset(250L);
            }
            if (this.f411343d == null) {
                Animation loadAnimation3 = AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154864sr);
                this.f411343d = loadAnimation3;
                loadAnimation3.setStartOffset(290L);
            }
            if (this.f411345f == null) {
                AnimationSet animationSet = new AnimationSet(true);
                this.f411345f = animationSet;
                animationSet.addAnimation(this.f411340a);
                this.f411345f.addAnimation(this.f411342c);
            }
            if (this.f411346g == null) {
                AnimationSet animationSet2 = new AnimationSet(true);
                this.f411346g = animationSet2;
                animationSet2.addAnimation(this.f411341b);
                this.f411346g.addAnimation(this.f411343d);
            }
            this.f411347h.startAnimation(this.f411345f);
            this.f411349j.startAnimation(this.f411346g);
            return;
        }
        view.setSelected(false);
        this.f411349j.setVisibility(8);
        if (this.f411344e == null) {
            this.f411344e = AnimationUtils.loadAnimation(BaseApplication.getContext(), R.anim.f154865ss);
        }
        this.f411347h.startAnimation(this.f411344e);
    }

    public void a(stSimpleMetaFeed stsimplemetafeed, View view, View view2, TextView textView, int i3, boolean z16) {
        this.f411350k = stsimplemetafeed;
        this.f411347h = view;
        this.f411348i = textView;
        this.f411349j = view2;
        h(z16, i3);
        g(z16);
    }

    public stSimpleMetaFeed b() {
        return this.f411350k;
    }

    public View c() {
        return this.f411349j;
    }

    public View d() {
        return this.f411347h;
    }

    public TextView e() {
        return this.f411348i;
    }

    public void f() {
        AnimationSet animationSet = this.f411345f;
        if (animationSet != null) {
            animationSet.cancel();
            this.f411345f = null;
        }
        AnimationSet animationSet2 = this.f411346g;
        if (animationSet2 != null) {
            animationSet2.cancel();
            this.f411346g = null;
        }
        Animation animation = this.f411344e;
        if (animation != null) {
            animation.cancel();
            this.f411344e = null;
        }
    }

    public void h(boolean z16, int i3) {
        View view = this.f411347h;
        if (view != null) {
            view.setSelected(z16);
        }
        View view2 = this.f411349j;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        TextView textView = this.f411348i;
        if (textView != null) {
            if (i3 > 0) {
                WSNumUtil.d(textView, i3, "0");
            } else {
                textView.setText(HardCodeUtil.qqStr(R.string.acw));
            }
        }
    }
}
