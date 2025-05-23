package com.tencent.mobileqq.guild.feed.presenter;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedMediaSizeUtils;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDefaultInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCommThirdVideoInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStRichTextContent;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProThirdPlatform;
import kotlin.Pair;

/* compiled from: P */
/* loaded from: classes13.dex */
public class k extends GuildBaseFeedChildPresenter<ij1.g> {
    private RoundCornerLayout F;
    private TextView G;
    private ImageView H;
    private View I;
    private TextView J;
    private ImageView K;

    public k(GuildFeedDefaultInitBean guildFeedDefaultInitBean) {
        super(guildFeedDefaultInitBean);
    }

    private void B(GProStFeed gProStFeed, int i3, int i16) {
        i(gProStFeed, i3, i16);
    }

    private void u() {
        if (this.F != null) {
            float dpToPx = ViewUtils.dpToPx(6.0f);
            this.F.setRadius(dpToPx, dpToPx, dpToPx, dpToPx);
        }
    }

    private void v(String str, int i3, int i16) {
        QLog.i("GuildFeedChildThirdVideoPresenter", 1, "bindVideoCover url=" + str + "measuredWidth=" + i3 + "measuredHeight" + i16);
        String d16 = com.tencent.mobileqq.guild.picload.e.d(str);
        String str2 = (String) this.H.getTag(R.id.wbe);
        if (!TextUtils.isEmpty(d16) && !d16.equals(str2)) {
            this.H.setTag(R.id.wbe, d16);
            com.tencent.mobileqq.guild.picload.e.a().e(new Option().setTargetView(this.H).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawable(this.H.getContext().getDrawable(R.drawable.f162601b70)).setUrl(str).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565));
        }
    }

    private void w(GProThirdPlatform gProThirdPlatform) {
        if (gProThirdPlatform != null) {
            this.I.setVisibility(0);
            this.J.setText(gProThirdPlatform.name);
            com.tencent.mobileqq.guild.picload.e.a().e(new Option().setTargetView(this.K).setUrl(gProThirdPlatform.icon).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565));
            return;
        }
        this.I.setVisibility(8);
    }

    private void x(ij1.g gVar, int i3) {
        int measuredWidth = this.F.getMeasuredWidth();
        if (measuredWidth == 0) {
            measuredWidth = GuildSplitViewUtils.f235370a.i(true, this.F.getContext());
        }
        Pair<Integer, Integer> a16 = GuildFeedMediaSizeUtils.f219296d.a(this.F, measuredWidth, (measuredWidth * 300) / TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END);
        GProStRichTextContent y16 = y(gVar);
        if (y16 == null) {
            QLog.i("GuildFeedChildThirdVideoPresenter", 1, "urlContent is empty");
            this.F.setVisibility(8);
            return;
        }
        GProCommThirdVideoInfo gProCommThirdVideoInfo = y16.urlContent.thirdVideoInfo;
        if (gProCommThirdVideoInfo != null) {
            this.G.setText(ax.k(gProCommThirdVideoInfo.duration));
            v(gProCommThirdVideoInfo.cover, a16.getFirst().intValue(), a16.getSecond().intValue());
            w(y16.urlContent.thirdPlatform);
            this.F.setVisibility(0);
            this.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.presenter.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    k.this.z(view);
                }
            });
        }
    }

    private GProStRichTextContent y(ij1.g gVar) {
        if (gVar != null && gVar.b() != null) {
            for (GProStRichTextContent gProStRichTextContent : gVar.b().contents.contents) {
                if (gProStRichTextContent.type == 3 && gProStRichTextContent.urlContent.thirdVideoInfo != null) {
                    return gProStRichTextContent;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        B(((ij1.g) this.f222800d).b(), 6, 1);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void k(ij1.g gVar, int i3) {
        super.k(gVar, i3);
        if (this.F != null) {
            x(gVar, i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void o(@NonNull View view) {
        super.o(view);
        gj1.a.a().d().requestPreloadViewForViewStub((ViewStub) view.findViewById(R.id.wbg), this);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter, com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader.RequestPreloadViewListener
    public void onPreloadResult(View view) {
        super.onPreloadResult(view);
        this.F = (RoundCornerLayout) view.findViewById(R.id.wbf);
        u();
        this.G = (TextView) view.findViewById(R.id.wbh);
        this.H = (ImageView) view.findViewById(R.id.wbe);
        this.I = view.findViewById(R.id.f165518wf3);
        this.J = (TextView) view.findViewById(R.id.f165519wf4);
        this.K = (ImageView) view.findViewById(R.id.f165517wf2);
    }

    @Override // com.tencent.mobileqq.guild.feed.presenter.GuildBaseFeedChildPresenter
    public void n() {
    }
}
