package com.tencent.mobileqq.guild.live.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.z;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.RoundRectImageView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001\u0006B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b&\u0010*B#\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010,\u001a\u00020+\u00a2\u0006\u0004\b&\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/live/widget/GuildLiveProgramSourceBarLayout;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "view", "", "b", "a", "", "sourceDataJson", "setVideoSourceData", "sourceIconUrl", "setVideoSourceIconUrl", "anchorName", "liveTitle", "setVideoSourceInfo", "", "bShow", "c", "Landroid/view/View$OnClickListener;", "listener", "setVideoSelectClickedListener", "Lcom/tencent/widget/RoundRectImageView;", "d", "Lcom/tencent/widget/RoundRectImageView;", "sourceIconView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "sourceTitleView", "f", "sourceAnchorNameView", tl.h.F, "Landroid/view/View;", "sourceDivider", "i", "sourceSelectView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveProgramSourceBarLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RoundRectImageView sourceIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView sourceTitleView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView sourceAnchorNameView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View sourceDivider;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View sourceSelectView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildLiveProgramSourceBarLayout(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void a() {
        ch.f235509b.setElementExposureAndClickParams(this.sourceSelectView, "em_sgrp_stream_show_list_icon", null);
    }

    private final void b(View view) {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        IGProChannelInfo channelInfo = gLiveChannelCore.s().getChannelInfo();
        IGProGuildInfo guildInfo = gLiveChannelCore.s().getGuildInfo();
        if (channelInfo != null && guildInfo != null) {
            HashMap<String, Object> b16 = new z(channelInfo, guildInfo).b();
            w.a(b16);
            VideoReport.setPageId(view, "pg_sgrp_stream_aio");
            ch.f235509b.setChannelPageParams(view, channelInfo, b16);
        }
    }

    public final void c(boolean bShow) {
        int i3;
        View view = this.sourceSelectView;
        if (bShow) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public final void setVideoSelectClickedListener(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.sourceSelectView.setOnClickListener(listener);
    }

    public final void setVideoSourceData(@NotNull String sourceDataJson) {
        Intrinsics.checkNotNullParameter(sourceDataJson, "sourceDataJson");
        QLog.d("GuildLiveProgramSourceBarLayout", 1, "setVideoSourceData: url[" + sourceDataJson + "]");
        if (TextUtils.isEmpty(sourceDataJson)) {
            return;
        }
        try {
            uq1.d dVar = (uq1.d) new Gson().fromJson(sourceDataJson, uq1.d.class);
            if (!TextUtils.isEmpty(dVar.logo)) {
                String str = dVar.logo;
                Intrinsics.checkNotNullExpressionValue(str, "sourceDataJson.logo");
                setVideoSourceIconUrl(str);
            }
            String str2 = dVar.anchorName;
            Intrinsics.checkNotNullExpressionValue(str2, "sourceDataJson.anchorName");
            String str3 = dVar.liveName;
            Intrinsics.checkNotNullExpressionValue(str3, "sourceDataJson.liveName");
            setVideoSourceInfo(str2, str3);
        } catch (Exception e16) {
            QLog.d("GuildLiveProgramSourceBarLayout", 1, "setVideoSourceData: error[" + e16.getMessage() + "]");
        }
    }

    public final void setVideoSourceIconUrl(@NotNull String sourceIconUrl) {
        Intrinsics.checkNotNullParameter(sourceIconUrl, "sourceIconUrl");
        QLog.d("GuildLiveProgramSourceBarLayout", 1, "setVideoSourceIconUrl: url[" + sourceIconUrl + "]");
        if (TextUtils.isEmpty(sourceIconUrl)) {
            this.sourceIconView.setVisibility(8);
        } else {
            this.sourceIconView.setVisibility(0);
        }
        com.tencent.mobileqq.guild.picload.e.a().e(new Option().setUrl(sourceIconUrl).setTargetView(this.sourceIconView));
    }

    public final void setVideoSourceInfo(@NotNull String anchorName, @NotNull String liveTitle) {
        Intrinsics.checkNotNullParameter(anchorName, "anchorName");
        Intrinsics.checkNotNullParameter(liveTitle, "liveTitle");
        QLog.i("GuildLiveProgramSourceBarLayout", 1, "setVideoSourceInfo: anchor[" + anchorName + "] title[" + liveTitle + "]");
        if (!TextUtils.isEmpty(anchorName)) {
            this.sourceAnchorNameView.setVisibility(0);
            this.sourceDivider.setVisibility(0);
            this.sourceAnchorNameView.setText(anchorName);
        } else {
            this.sourceAnchorNameView.setVisibility(8);
            this.sourceDivider.setVisibility(8);
        }
        if (!TextUtils.isEmpty(liveTitle)) {
            this.sourceTitleView.setVisibility(0);
            this.sourceTitleView.setText(liveTitle);
        } else {
            this.sourceTitleView.setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildLiveProgramSourceBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLiveProgramSourceBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.f168121ex3, this);
        View findViewById = findViewById(R.id.wn6);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_live_source_icon)");
        RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById;
        this.sourceIconView = roundRectImageView;
        roundRectImageView.setCornerRadiusAndMode(x.c(context, 2.0f), 1);
        View findViewById2 = findViewById(R.id.wn7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_live_source_live_title)");
        this.sourceTitleView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f165559wn4);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_live_source_anchor_name)");
        this.sourceAnchorNameView = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.wn5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.guild_live_source_divider)");
        this.sourceDivider = findViewById4;
        View findViewById5 = findViewById(R.id.wn8);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.guild_live_source_select)");
        this.sourceSelectView = findViewById5;
        b(findViewById5);
        a();
    }
}
