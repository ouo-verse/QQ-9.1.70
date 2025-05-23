package com.tencent.timi.game.liveroom.impl.room.fansgroup.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kj4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class FansGroupGiftTipView extends FrameLayout {
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private long f377617d;

    /* renamed from: e, reason: collision with root package name */
    private long f377618e;

    /* renamed from: f, reason: collision with root package name */
    private String f377619f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f377620h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f377621i;

    /* renamed from: m, reason: collision with root package name */
    private RoundImageView f377622m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            kj4.a.e(FansGroupGiftTipView.this.getContext(), FansGroupGiftTipView.this.f377618e, FansGroupGiftTipView.this.f377617d, 4, 1);
            if ("\u52a0\u5165\u7c89\u4e1d\u56e2".compareTo(FansGroupGiftTipView.this.f377620h.getText().toString()) == 0) {
                b.f();
            } else {
                b.j();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public FansGroupGiftTipView(Context context) {
        this(context, null);
    }

    private boolean d(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public void e(boolean z16) {
        if (z16 != this.C) {
            this.C = z16;
            b.e(z16);
        }
    }

    public void f(boolean z16) {
        boolean z17;
        if (z16 && this.f377620h.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 == this.D) {
            return;
        }
        this.D = z17;
        if ("\u52a0\u5165\u7c89\u4e1d\u56e2".compareTo(this.f377620h.getText().toString()) == 0) {
            b.g(z17);
        } else {
            b.k(z17);
        }
    }

    public void g(boolean z16) {
        int i3;
        TextView textView = this.f377620h;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        textView.setVisibility(i3);
    }

    public void setFansGroupTitleText(String str) {
        this.f377621i.setText(str);
    }

    public void setJoinFansGroupText(String str) {
        this.f377620h.setText(str);
        this.f377620h.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.f377620h.getPaint().getTextSize() * this.f377620h.getText().length(), 0.0f, Color.parseColor("#ffff7dcb"), Color.parseColor("#ffd07dff"), Shader.TileMode.CLAMP));
        this.f377620h.invalidate();
    }

    public void setParam(long j3, long j16, String str) {
        this.f377617d = j3;
        this.f377618e = j16;
        if (!TextUtils.isEmpty(str)) {
            this.f377619f = str;
            this.f377622m.setImageDrawable(URLDrawable.getDrawable(str));
        }
    }

    public FansGroupGiftTipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FansGroupGiftTipView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.D = false;
        View.inflate(context, R.layout.h_i, this);
        this.f377622m = (RoundImageView) findViewById(R.id.snp);
        this.f377620h = (TextView) findViewById(R.id.ya7);
        this.f377621i = (TextView) findViewById(R.id.v0j);
        this.f377620h.setOnClickListener(new a());
        if (d(getContext())) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(Color.parseColor("#191912"));
        }
    }
}
