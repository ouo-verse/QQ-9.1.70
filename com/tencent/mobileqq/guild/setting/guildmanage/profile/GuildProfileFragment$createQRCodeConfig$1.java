package com.tencent.mobileqq.guild.setting.guildmanage.profile;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", DownloadInfo.spKey_Config, "", "invoke", "(Lcom/tencent/mobileqq/widget/listitem/x;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFragment$createQRCodeConfig$1 extends Lambda implements Function1<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d>, Unit> {
    final /* synthetic */ GuildProfileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFragment$createQRCodeConfig$1(GuildProfileFragment guildProfileFragment) {
        super(1);
        this.this$0 = guildProfileFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildProfileFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!QQGuildUIUtil.v()) {
            GuildSettingQRCodeFragment.Companion companion = GuildSettingQRCodeFragment.INSTANCE;
            Context context = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            String str = this$0.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            companion.a(context, str);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.zi(it, "em_sgrp_channel_code_qr");
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> xVar) {
        invoke2(xVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> config) {
        Intrinsics.checkNotNullParameter(config, "config");
        config.T(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$createQRCodeConfig$1.1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String str) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                if (imageView.getId() == R.id.f66253a5) {
                    ViewUtils viewUtils = ViewUtils.f352270a;
                    imageView.setPadding(viewUtils.a(16.0f), viewUtils.a(8.0f), 0, viewUtils.a(8.0f));
                    Drawable drawable = imageView.getContext().getDrawable(R.drawable.guild_token_qrcode_icon);
                    if (drawable != null) {
                        drawable.setColorFilter(new PorterDuffColorFilter(imageView.getContext().getResources().getColor(R.color.qui_common_icon_secondary), PorterDuff.Mode.SRC_IN));
                    }
                    imageView.setImageDrawable(drawable);
                }
            }
        });
        final GuildProfileFragment guildProfileFragment = this.this$0;
        config.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileFragment$createQRCodeConfig$1.b(GuildProfileFragment.this, view);
            }
        });
    }
}
