package com.tencent.now.od.ui.game.meleegame.widget.scorebar.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import ao3.ScoreBean;
import bo3.b;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.od.common.util.a;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class WholeScoreBarView extends ConstraintLayout {
    private ImageView C;
    private ScoreBean D;
    private b E;

    /* renamed from: d, reason: collision with root package name */
    private View f338596d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f338597e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f338598f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f338599h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f338600i;

    /* renamed from: m, reason: collision with root package name */
    private ScoreBar f338601m;

    public WholeScoreBarView(Context context) {
        this(context, null);
    }

    private void initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dzv, this);
        this.f338596d = inflate;
        ScoreBar scoreBar = (ScoreBar) inflate.findViewById(R.id.f80174ar);
        this.f338601m = scoreBar;
        scoreBar.H0();
        this.f338597e = (TextView) this.f338596d.findViewById(R.id.yhm);
        this.f338598f = (TextView) this.f338596d.findViewById(R.id.ygv);
        this.f338599h = (TextView) this.f338596d.findViewById(R.id.f74883xg);
        this.f338600i = (TextView) this.f338596d.findViewById(R.id.f74463wb);
        a.a(this.f338597e);
        a.a(this.f338598f);
        a.a(this.f338599h);
        a.a(this.f338600i);
        this.C = (ImageView) findViewById(R.id.f165124uz3);
        ImageLoader.getInstance().displayImage(pn3.a.f426501a.b(), this.C, un3.a.f439281b);
        a.a(this.f338598f);
        a.a(this.f338600i);
        A0(new ScoreBean(0L, 0L));
    }

    public void A0(ScoreBean scoreBean) {
        long leftScore = scoreBean.getLeftScore();
        long rightScore = scoreBean.getRightScore();
        ScoreBean scoreBean2 = this.D;
        if (scoreBean2 != null) {
            long leftScore2 = scoreBean2.getLeftScore();
            long rightScore2 = this.D.getRightScore();
            if (leftScore2 < leftScore) {
                this.f338598f.setText(Marker.ANY_NON_NULL_MARKER + (leftScore - leftScore2));
            }
            if (rightScore2 < rightScore) {
                this.f338600i.setText(Marker.ANY_NON_NULL_MARKER + (rightScore - rightScore2));
            }
        }
        this.f338601m.M0(leftScore, rightScore);
        this.f338597e.setText(String.valueOf(leftScore));
        this.f338599h.setText(String.valueOf(rightScore));
        this.D = scoreBean;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.E.a();
    }

    public WholeScoreBarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WholeScoreBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public WholeScoreBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.E = new b();
        initView();
        z0();
    }

    public void z0() {
    }
}
