package com.tencent.mobileqq.guild.feed.qqgame.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class GuildGameFeedsView extends BaseGuildGameFeedsView implements View.OnClickListener {
    private LinearLayout C;
    private TextView D;
    private LinearLayout E;

    /* renamed from: i, reason: collision with root package name */
    private RFWRoundImageView f223226i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f223227m;

    public GuildGameFeedsView(@NonNull Context context, on1.d dVar) {
        super(context, dVar);
    }

    private void n() {
        com.tencent.xaction.log.b.a("GuildGameFeedsView", 1, "fillFeedsContent");
        u.k(this.f223226i, this.f223216e.f423215c, bi.b(30), bi.b(30), null);
        this.f223227m.setText(this.f223216e.f423214b);
        this.D.setText(this.f223216e.f423216d);
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    int c() {
        return R.layout.eof;
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void d(Map<String, String> map, on1.b bVar) {
        super.d(map, bVar);
        com.tencent.xaction.log.b.a("GuildGameFeedsView", 1, "initView");
        this.f223226i = (RFWRoundImageView) findViewById(R.id.y0h);
        this.f223227m = (TextView) findViewById(R.id.mbu);
        this.C = (LinearLayout) findViewById(R.id.tm7);
        this.D = (TextView) findViewById(R.id.f111856mc);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f901751r);
        this.E = linearLayout;
        linearLayout.setClickable(false);
        n();
        o(this.E);
        setOnClickListener(this);
        this.C.setOnClickListener(this);
        l(101);
        b(this.f223227m);
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void g() {
        com.tencent.xaction.log.b.a("GuildGameFeedsView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void i(boolean z16) {
        com.tencent.xaction.log.b.a("GuildGameFeedsView", 1, "onVisibleChanged visible=" + z16);
    }

    abstract void o(@NonNull LinearLayout linearLayout);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.tm7) {
            m(view);
            k(view, "em_sgrp_feed_section_ad_feedback");
        } else {
            e(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
