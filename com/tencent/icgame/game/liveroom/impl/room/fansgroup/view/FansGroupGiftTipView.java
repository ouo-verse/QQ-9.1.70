package com.tencent.icgame.game.liveroom.impl.room.fansgroup.view;

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
import cw0.b;

/* compiled from: P */
/* loaded from: classes7.dex */
public class FansGroupGiftTipView extends FrameLayout {
    private boolean C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private long f115226d;

    /* renamed from: e, reason: collision with root package name */
    private long f115227e;

    /* renamed from: f, reason: collision with root package name */
    private String f115228f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f115229h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f115230i;

    /* renamed from: m, reason: collision with root package name */
    private RoundImageView f115231m;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cw0.a.c(FansGroupGiftTipView.this.getContext(), FansGroupGiftTipView.this.f115227e, FansGroupGiftTipView.this.f115226d, 4);
            if ("\u52a0\u5165\u7c89\u4e1d\u56e2".compareTo(FansGroupGiftTipView.this.f115229h.getText().toString()) == 0) {
                b.c();
            } else {
                b.e();
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
            b.b(z16);
        }
    }

    public void f(boolean z16) {
        boolean z17;
        if (z16 && this.f115229h.getVisibility() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 == this.D) {
            return;
        }
        this.D = z17;
        if ("\u52a0\u5165\u7c89\u4e1d\u56e2".compareTo(this.f115229h.getText().toString()) == 0) {
            b.d(z17);
        } else {
            b.f(z17);
        }
    }

    public void g(boolean z16) {
        int i3;
        TextView textView = this.f115229h;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        textView.setVisibility(i3);
    }

    public void setFansGroupTitleText(String str) {
        this.f115230i.setText(str);
    }

    public void setJoinFansGroupText(String str) {
        this.f115229h.setText(str);
        this.f115229h.getPaint().setShader(new LinearGradient(0.0f, 0.0f, this.f115229h.getPaint().getTextSize() * this.f115229h.getText().length(), 0.0f, Color.parseColor("#ffff7dcb"), Color.parseColor("#ffd07dff"), Shader.TileMode.CLAMP));
        this.f115229h.invalidate();
    }

    public void setParam(long j3, long j16, String str) {
        this.f115226d = j3;
        this.f115227e = j16;
        if (!TextUtils.isEmpty(str)) {
            this.f115228f = str;
            this.f115231m.setImageDrawable(URLDrawable.getDrawable(str));
        }
    }

    public FansGroupGiftTipView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public FansGroupGiftTipView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.D = false;
        View.inflate(context, R.layout.fap, this);
        this.f115231m = (RoundImageView) findViewById(R.id.snp);
        this.f115229h = (TextView) findViewById(R.id.ya7);
        this.f115230i = (TextView) findViewById(R.id.v0j);
        this.f115229h.setOnClickListener(new a());
        if (d(getContext())) {
            setBackgroundColor(0);
        } else {
            setBackgroundColor(Color.parseColor("#191912"));
        }
    }
}
