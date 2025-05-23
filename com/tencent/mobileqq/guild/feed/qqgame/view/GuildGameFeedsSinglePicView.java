package com.tencent.mobileqq.guild.feed.qqgame.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.component.RoundImageView;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.util.Pair;
import java.util.Map;

/* loaded from: classes13.dex */
public class GuildGameFeedsSinglePicView extends GuildGameFeedsView {
    private RoundImageView F;

    public GuildGameFeedsSinglePicView(@NonNull Context context, on1.d dVar) {
        super(context, dVar);
        this.F = null;
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsView, com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void d(Map<String, String> map, on1.b bVar) {
        super.d(map, bVar);
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsView, com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void g() {
        com.tencent.xaction.log.b.a("GuildGameFeedsSinglePicView", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.BaseGuildGameFeedsView
    public void h() {
        com.tencent.xaction.log.b.a("GuildGameFeedsSinglePicView", 1, "onDisplayChanged mSinglePicView=" + this.F);
        if (this.F != null) {
            Pair<Integer, Integer> a16 = on1.c.a(this.f223216e.f423217e);
            com.tencent.xaction.log.b.a("GuildGameFeedsSinglePicView", 1, "onDisplayChanged w=" + a16.first + ",h=" + a16.second);
            this.F.setLayoutParams(new LinearLayout.LayoutParams(a16.first.intValue(), a16.second.intValue()));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.qqgame.view.GuildGameFeedsView
    public void o(@NonNull LinearLayout linearLayout) {
        Pair<Integer, Integer> a16 = on1.c.a(this.f223216e.f423217e);
        com.tencent.xaction.log.b.a("GuildGameFeedsSinglePicView", 1, "initSubContainer guildGameFeedsData=" + this.f223216e + ",w=" + a16.first + ",h=" + a16.second);
        RoundImageView roundImageView = new RoundImageView(getContext());
        this.F = roundImageView;
        roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.F.setRadius(bi.b(6));
        this.F.setLayoutParams(new LinearLayout.LayoutParams(a16.first.intValue(), a16.second.intValue()));
        e.a().f(Option.obtain().setTargetView(this.F).setUrl(this.f223216e.f423218f).setRequestWidth(a16.first.intValue()).setRequestHeight(a16.second.intValue()).setPredecode(true), null);
        linearLayout.addView(this.F);
    }
}
