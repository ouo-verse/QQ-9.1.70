package com.tencent.mobileqq.activity.aio.intimate.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.e;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.friendclue.c;
import com.tencent.mobileqq.relationx.friendclue.d;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes10.dex */
public class IntimateContentItemClueView extends IntimateContentItemBaseView {
    private TextView F;
    private Boolean G;
    c H;

    public IntimateContentItemClueView(Context context) {
        this(context, null);
    }

    private Activity s() {
        Context context = this.f179219d;
        if (context instanceof Activity) {
            return (Activity) context;
        }
        return Foreground.getTopActivity();
    }

    private void t() {
        if (this.H == null) {
            this.H = new c();
        }
        a();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        if (this.H == null) {
            this.H = new c();
            this.G = Boolean.valueOf(c.a());
        } else {
            this.G = Boolean.valueOf(c.a());
        }
        if (e.e(this.f179224m)) {
            this.G = Boolean.FALSE;
        }
        return this.G.booleanValue();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        TextView textView = (TextView) LayoutInflater.from(this.f179219d).inflate(R.layout.fcr, (ViewGroup) this, true).findViewById(R.id.ver);
        this.F = textView;
        textView.setOnClickListener(this);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(View view) {
        Activity s16;
        if (view.getId() == R.id.ver) {
            t();
            if (this.H != null && (s16 = s()) != null && !s16.isFinishing()) {
                this.H.b(s16, this.f179220e);
                d.a(1);
                ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).reportItemEvent("dt_clck", "pg_aio_swipleft", "em_bas_friend_clue", ((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).getPgTagDetailData(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void f() {
        super.f();
        t();
        if (this.G.booleanValue()) {
            d.b(1);
        }
    }

    public IntimateContentItemClueView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IntimateContentItemClueView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = Boolean.FALSE;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(IntimateInfo intimateInfo, int i3) {
    }
}
