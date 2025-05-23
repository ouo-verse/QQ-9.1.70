package com.tencent.mobileqq.guild.profile.me;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.guild.sign.config.GuildSignAndWalletConfig;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$d;", "kotlin.jvm.PlatformType", DownloadInfo.spKey_Config, "", "invoke", "(Lcom/tencent/mobileqq/guild/sign/config/GuildSignAndWalletConfig$d;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileBannerLayout$setupLiveDataInfo$2$4 extends Lambda implements Function1<GuildSignAndWalletConfig.GuildWalletEntranceConfig, Unit> {
    final /* synthetic */ GuildProfileBannerLayout this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileBannerLayout$setupLiveDataInfo$2$4(GuildProfileBannerLayout guildProfileBannerLayout) {
        super(1);
        this.this$0 = guildProfileBannerLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildProfileBannerLayout this$0, GuildSignAndWalletConfig.GuildWalletEntranceConfig guildWalletEntranceConfig, View it) {
        boolean z16;
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.d1(it, "em_sgrp_wallet_entrance");
        String jumpUrl = guildWalletEntranceConfig.getJumpUrl();
        if (jumpUrl != null && jumpUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            Context context = this$0.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                ch.i1(activity, guildWalletEntranceConfig.getJumpUrl());
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildSignAndWalletConfig.GuildWalletEntranceConfig guildWalletEntranceConfig) {
        invoke2(guildWalletEntranceConfig);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        r0 = r3.this$0.mWalletIcon;
     */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invoke2(final GuildSignAndWalletConfig.GuildWalletEntranceConfig guildWalletEntranceConfig) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        imageView = this.this$0.mWalletIcon;
        boolean z16 = false;
        if (imageView != null) {
            imageView.setVisibility(guildWalletEntranceConfig.getIsShow() ? 0 : 8);
        }
        imageView2 = this.this$0.mWalletIcon;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            z16 = true;
        }
        if (z16 && imageView4 != null) {
            this.this$0.e1(imageView4, "em_sgrp_wallet_entrance");
        }
        imageView3 = this.this$0.mWalletIcon;
        if (imageView3 != null) {
            final GuildProfileBannerLayout guildProfileBannerLayout = this.this$0;
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.me.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildProfileBannerLayout$setupLiveDataInfo$2$4.b(GuildProfileBannerLayout.this, guildWalletEntranceConfig, view);
                }
            });
        }
    }
}
