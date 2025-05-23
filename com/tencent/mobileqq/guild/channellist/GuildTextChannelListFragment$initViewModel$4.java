package com.tencent.mobileqq.guild.channellist;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildTextChannelListFragment$initViewModel$4 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ GuildTextChannelListFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTextChannelListFragment$initViewModel$4(GuildTextChannelListFragment guildTextChannelListFragment) {
        super(1);
        this.this$0 = guildTextChannelListFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildTextChannelListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.Vh(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean it) {
        ImageView rightImage = (ImageView) this.this$0.getTitleBarView().findViewById(R.id.ivTitleBtnRightImage);
        rightImage.setImageResource(R.drawable.guild_icon_settings);
        Context context = rightImage.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rightImage.context");
        rightImage.setImageDrawable(GuildUIUtils.y(context, R.drawable.guild_icon_settings, QQGuildUIUtil.i(rightImage.getContext(), R.color.qui_common_text_primary)));
        Intrinsics.checkNotNullExpressionValue(rightImage, "rightImage");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        rightImage.setVisibility(it.booleanValue() ? 0 : 8);
        final GuildTextChannelListFragment guildTextChannelListFragment = this.this$0;
        rightImage.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channellist.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildTextChannelListFragment$initViewModel$4.b(GuildTextChannelListFragment.this, view);
            }
        });
    }
}
