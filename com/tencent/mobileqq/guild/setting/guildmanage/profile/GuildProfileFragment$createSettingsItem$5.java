package com.tencent.mobileqq.guild.setting.guildmanage.profile;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileViewModel;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
public final class GuildProfileFragment$createSettingsItem$5 extends Lambda implements Function1<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d>, Unit> {
    final /* synthetic */ QUIListItemAdapter $adapter;
    final /* synthetic */ GuildProfileFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFragment$createSettingsItem$5(GuildProfileFragment guildProfileFragment, QUIListItemAdapter qUIListItemAdapter) {
        super(1);
        this.this$0 = guildProfileFragment;
        this.$adapter = qUIListItemAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildProfileFragment this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.ki();
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> xVar) {
        invoke2(xVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.d> config) {
        GuildProfileViewModel guildProfileViewModel;
        Intrinsics.checkNotNullParameter(config, "config");
        final GuildProfileFragment guildProfileFragment = this.this$0;
        config.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileFragment$createSettingsItem$5.c(GuildProfileFragment.this, view);
            }
        });
        x.c.d O = config.O();
        String string = this.this$0.getString(R.string.f146930vi);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_is_set_no)");
        O.h(string);
        final GuildProfileFragment guildProfileFragment2 = this.this$0;
        config.T(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$createSettingsItem$5.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ImageView imageView, @NotNull String s16) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(s16, "s");
                GuildProfileFragment.this.vi(imageView, s16);
            }
        });
        guildProfileViewModel = this.this$0.viewModel;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        MutableLiveData<GuildProfileViewModel.ItemContent> a26 = guildProfileViewModel.a2();
        LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
        final GuildProfileFragment guildProfileFragment3 = this.this$0;
        final QUIListItemAdapter qUIListItemAdapter = this.$adapter;
        final Function1<GuildProfileViewModel.ItemContent, Unit> function1 = new Function1<GuildProfileViewModel.ItemContent, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$createSettingsItem$5.3
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
                String content = itemContent.getContent();
                config.O().j(content);
                if (TextUtils.isEmpty(content)) {
                    x.c.d O2 = config.O();
                    String string2 = guildProfileFragment3.getString(R.string.f146930vi);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.guild_is_set_no)");
                    O2.h(string2);
                } else {
                    config.O().h("");
                }
                qUIListItemAdapter.l0(config);
            }
        };
        a26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFragment$createSettingsItem$5.d(Function1.this, obj);
            }
        });
    }
}
