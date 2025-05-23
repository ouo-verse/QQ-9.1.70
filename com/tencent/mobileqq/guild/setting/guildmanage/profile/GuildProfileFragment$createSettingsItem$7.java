package com.tencent.mobileqq.guild.setting.guildmanage.profile;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ltz1/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", DownloadInfo.spKey_Config, "", "invoke", "(Ltz1/b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFragment$createSettingsItem$7 extends Lambda implements Function1<tz1.b<x.b.d>, Unit> {
    final /* synthetic */ QUIListItemAdapter $adapter;
    final /* synthetic */ GuildProfileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFragment$createSettingsItem$7(GuildProfileFragment guildProfileFragment, QUIListItemAdapter qUIListItemAdapter) {
        super(1);
        this.this$0 = guildProfileFragment;
        this.$adapter = qUIListItemAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildProfileFragment this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.mi();
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(tz1.b<x.b.d> bVar) {
        invoke2(bVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final tz1.b<x.b.d> config) {
        GuildProfileViewModel guildProfileViewModel;
        Intrinsics.checkNotNullParameter(config, "config");
        final GuildProfileFragment guildProfileFragment = this.this$0;
        config.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileFragment$createSettingsItem$7.c(GuildProfileFragment.this, view);
            }
        });
        guildProfileViewModel = this.this$0.viewModel;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        MutableLiveData<GuildProfileViewModel.ItemContent> c26 = guildProfileViewModel.c2();
        LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
        final GuildProfileFragment guildProfileFragment2 = this.this$0;
        final QUIListItemAdapter qUIListItemAdapter = this.$adapter;
        final Function1<GuildProfileViewModel.ItemContent, Unit> function1 = new Function1<GuildProfileViewModel.ItemContent, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$createSettingsItem$7.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildProfileViewModel.ItemContent itemContent) {
                invoke2(itemContent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildProfileViewModel.ItemContent itemContent) {
                if (TextUtils.isEmpty(itemContent.getContent())) {
                    x.c.g O = config.O();
                    String string = guildProfileFragment2.getString(R.string.f146930vi);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_is_set_no)");
                    O.h(string);
                } else {
                    x.c.g O2 = config.O();
                    QQText qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(itemContent.getContent(), 20);
                    Intrinsics.checkNotNullExpressionValue(qQText, "api(IGuildEmotionCodecAp\u2026(itemContent.content, 20)");
                    O2.h(qQText);
                }
                qUIListItemAdapter.l0(config);
            }
        };
        c26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.u
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFragment$createSettingsItem$7.d(Function1.this, obj);
            }
        });
    }
}
