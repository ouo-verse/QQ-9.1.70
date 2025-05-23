package com.tencent.mobileqq.guild.setting.guildmanage.profile;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.search.api.impl.SearchGuildDaTongApiImpl;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/profile/GuildProfileFragment$createChannelNumberConfig$1", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "", "name", "", "status", "", "c0", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFragment$createChannelNumberConfig$1 extends com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> {

    /* renamed from: q, reason: collision with root package name */
    final /* synthetic */ GuildProfileFragment f234109q;

    /* renamed from: r, reason: collision with root package name */
    final /* synthetic */ QUIListItemAdapter f234110r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFragment$createChannelNumberConfig$1(final GuildProfileFragment guildProfileFragment, QUIListItemAdapter qUIListItemAdapter, x.b.d dVar, x.c.g gVar) {
        super(dVar, gVar);
        GuildProfileViewModel guildProfileViewModel;
        this.f234109q = guildProfileFragment;
        this.f234110r = qUIListItemAdapter;
        guildProfileViewModel = guildProfileFragment.viewModel;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        MutableLiveData<Pair<String, Integer>> e26 = guildProfileViewModel.e2();
        LifecycleOwner viewLifecycleOwner = guildProfileFragment.getViewLifecycleOwner();
        final Function1<Pair<String, Integer>, Unit> function1 = new Function1<Pair<String, Integer>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.GuildProfileFragment$createChannelNumberConfig$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<String, Integer> pair) {
                invoke2(pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Pair<String, Integer> pair) {
                if (pair == null) {
                    return;
                }
                GuildProfileFragment$createChannelNumberConfig$1 guildProfileFragment$createChannelNumberConfig$1 = GuildProfileFragment$createChannelNumberConfig$1.this;
                String str = pair.first;
                Intrinsics.checkNotNullExpressionValue(str, "pair.first");
                Integer num = pair.second;
                Intrinsics.checkNotNullExpressionValue(num, "pair.second");
                guildProfileFragment$createChannelNumberConfig$1.c0(str, num.intValue());
            }
        };
        e26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFragment$createChannelNumberConfig$1.Y(Function1.this, obj);
            }
        });
        x(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildProfileFragment$createChannelNumberConfig$1.Z(GuildProfileFragment.this, view);
            }
        });
        w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.profile.l
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GuildProfileFragment$createChannelNumberConfig$1.a0(GuildProfileFragment.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GuildProfileFragment this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v3, "v");
        this$0.oi();
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(GuildProfileFragment this$0, GuildProfileFragment$createChannelNumberConfig$1 this$1, View v3) {
        GuildProfileViewModel guildProfileViewModel;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Intrinsics.checkNotNullParameter(v3, "v");
        guildProfileViewModel = this$0.viewModel;
        if (guildProfileViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildProfileViewModel = null;
        }
        IGProGuildInfo value = guildProfileViewModel.b2().getValue();
        HashMap hashMap = new HashMap();
        if (value != null && value.getGuildNumber() != null) {
            str = value.getGuildNumber();
        } else {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (guildInfo == null ||\u2026lse guildInfo.guildNumber");
        hashMap.put(SearchGuildDaTongApiImpl.GUILD_CHANNEL_SCORE, str);
        VideoReport.setElementReuseIdentifier(this$1.i(), "em_sgrp_channel_code");
        bt.d(v3, "em_sgrp_channel_code", hashMap, null, null, null, 56, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(String name, int status) {
        QLog.i("Guild.mnr.GuildProfileFragment", 1, "[updateGuildIdStatus] name:" + name + ", status:" + status);
        if (!TextUtils.isEmpty(name)) {
            if (status == 1) {
                String str = this.f234109q.guildId;
                String str2 = null;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                    str = null;
                }
                if (ch.L(str) != null) {
                    x.c.g O = O();
                    String str3 = this.f234109q.guildId;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildId");
                    } else {
                        str2 = str3;
                    }
                    String guildNumber = ch.L(str2).getGuildNumber();
                    Intrinsics.checkNotNullExpressionValue(guildNumber, "getGuildInfo(guildId).guildNumber");
                    O.h(guildNumber);
                    this.f234110r.l0(this);
                }
            }
            O().h(name);
            this.f234110r.l0(this);
        }
    }
}
