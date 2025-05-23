package com.tencent.mobileqq.listentogether.lyrics;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
public class FloatTextLayout extends FloatBaseLayout implements e, View.OnClickListener {
    public c K;
    boolean L;
    View M;

    public FloatTextLayout(Context context) {
        super(context);
        this.L = true;
        v();
    }

    private void v() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.caq, (ViewGroup) null);
        this.M = inflate;
        c cVar = (c) inflate.findViewById(R.id.ei7);
        this.K = cVar;
        cVar.setStrokeColor(-1);
        this.K.setStrokeWidth(BaseAIOUtils.f(1.5f, getResources()));
        ((TextView) this.K).setTextColor(-8293377);
        ((TextView) this.K).getPaint().setFakeBoldText(true);
        ((TextView) this.K).setTextSize(1, 18.0f);
        ((TextView) this.K).setOnClickListener(this);
        ((TextView) this.K).setContentDescription(HardCodeUtil.qqStr(R.string.mlr));
        this.f240988f = BaseAIOUtils.f(40.0f, getResources());
        int min = (int) (Math.min(getResources().getDisplayMetrics().widthPixels * 0.85f, r1 - BaseAIOUtils.f(16.0f, getResources())) - ((int) getResources().getDimension(R.dimen.b6f)));
        this.f240987e = min;
        this.K.setLineMaxWidth(min);
        addView(this.M, new FrameLayout.LayoutParams(-2, this.f240988f));
        this.K.setOnSizeChangeListener(this);
        WindowManager.LayoutParams layoutParams = this.f240990i;
        layoutParams.width = this.f240987e;
        layoutParams.height = this.f240988f;
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.e
    public void a(int i3, int i16) {
        a aVar;
        if (i3 == this.f240987e || (aVar = this.f240986d) == null) {
            return;
        }
        aVar.d(i3, i16);
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
    public void destroy() {
        super.destroy();
        c cVar = this.K;
        if (cVar != null) {
            cVar.setOnSizeChangeListener(null);
            this.K.stop();
        }
    }

    @Override // com.tencent.mobileqq.listentogether.lyrics.FloatBaseLayout
    public boolean l() {
        boolean l3 = super.l();
        c cVar = this.K;
        if (cVar != null) {
            cVar.stop();
        }
        return l3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar = this.f240986d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public c s() {
        return this.K;
    }

    public void setFloatWidth(int i3) {
        this.f240987e = i3;
        this.f240990i.width = i3;
    }

    public int t(b bVar) {
        if (bVar.f241053e) {
            return bVar.f241049a + (bVar.f241051c / 2);
        }
        return (bVar.f241049a - (bVar.f241051c / 2)) - this.f240987e;
    }

    public int u(b bVar) {
        return bVar.f241050b - (this.f240988f / 2);
    }

    public void w() {
        int min = (int) (Math.min(getResources().getDisplayMetrics().widthPixels * 0.85f, r1 - BaseAIOUtils.f(16.0f, getResources())) - ((int) getResources().getDimension(R.dimen.b6f)));
        this.f240987e = min;
        this.K.setLineMaxWidth(min);
        this.f240990i.width = this.f240987e;
    }

    public void x(b bVar) {
        int i3;
        Paint.Align align;
        if (bVar == null) {
            return;
        }
        if (bVar.f241059k && !bVar.f241060l && !bVar.f241054f) {
            if (!bVar.f241056h) {
                this.K.setAlign(Paint.Align.CENTER);
            } else {
                if (bVar.f241053e) {
                    align = Paint.Align.RIGHT;
                } else {
                    align = Paint.Align.LEFT;
                }
                this.K.setAlign(align);
            }
        }
        this.L = bVar.f241053e;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.M.getLayoutParams();
        int i16 = layoutParams.gravity;
        if (bVar.f241056h) {
            i3 = this.L ? 5 : 3;
        } else {
            i3 = 1;
        }
        if (i16 != i3) {
            layoutParams.gravity = i3;
            this.M.setLayoutParams(layoutParams);
        }
    }

    public boolean y(b bVar) {
        boolean l3;
        if (bVar == null) {
            return false;
        }
        if (bVar.f241059k && !bVar.f241060l && !bVar.f241054f) {
            l3 = q();
        } else {
            l3 = l();
        }
        return !l3;
    }
}
