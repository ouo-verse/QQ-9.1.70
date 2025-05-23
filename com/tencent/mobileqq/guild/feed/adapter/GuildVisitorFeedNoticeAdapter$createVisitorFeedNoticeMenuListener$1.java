package com.tencent.mobileqq.guild.feed.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.x;
import com.tencent.mobileqq.guild.widget.menu.BaseMenuEntry;
import com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper;
import com.tencent.widget.ActionSheet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/adapter/GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1", "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper$b;", "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper;", "menuHelper", "Landroid/view/View;", "menuView", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", "menuEntry", "hostItemView", "", "position", "", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1 implements GuildSwipeMenuItemHelper.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ GuildVisitorFeedNoticeAdapter f217929a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1(GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter) {
        this.f217929a = guildVisitorFeedNoticeAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildVisitorFeedNoticeAdapter this$0, int i3) {
        x xVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        xVar = this$0.guildNoticeCallback;
        if (xVar != null) {
            xVar.a(i3);
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
    public void a(@NotNull GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, @NotNull View view, int i3) {
        GuildSwipeMenuItemHelper.b.a.b(this, guildSwipeMenuItemHelper, view, i3);
    }

    @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
    public void b(@NotNull GuildSwipeMenuItemHelper menuHelper, @NotNull View menuView, @NotNull BaseMenuEntry menuEntry, @NotNull View hostItemView, final int position) {
        x xVar;
        Fragment fragment;
        Intrinsics.checkNotNullParameter(menuHelper, "menuHelper");
        Intrinsics.checkNotNullParameter(menuView, "menuView");
        Intrinsics.checkNotNullParameter(menuEntry, "menuEntry");
        Intrinsics.checkNotNullParameter(hostItemView, "hostItemView");
        if (menuEntry instanceof BaseMenuEntry.b) {
            menuHelper.q();
            final GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter = this.f217929a;
            hostItemView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.adapter.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1.e(GuildVisitorFeedNoticeAdapter.this, position);
                }
            }, 200L);
        } else if (menuEntry instanceof BaseMenuEntry.c) {
            menuHelper.q();
            if (((BaseMenuEntry.c) menuEntry).getReceiveNotification()) {
                xVar = this.f217929a.guildNoticeCallback;
                if (xVar != null) {
                    xVar.b(position, true);
                    return;
                }
                return;
            }
            ui1.e eVar = ui1.e.f439033a;
            fragment = this.f217929a.parentFragment;
            Map<String, ? extends Object> g16 = menuEntry.g();
            final GuildVisitorFeedNoticeAdapter guildVisitorFeedNoticeAdapter2 = this.f217929a;
            eVar.d(fragment, g16, new Function2<View, ActionSheet, Unit>() { // from class: com.tencent.mobileqq.guild.feed.adapter.GuildVisitorFeedNoticeAdapter$createVisitorFeedNoticeMenuListener$1$onMenuClick$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, ActionSheet actionSheet) {
                    invoke2(view, actionSheet);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View v3, @NotNull ActionSheet actionSheet) {
                    x xVar2;
                    Intrinsics.checkNotNullParameter(v3, "v");
                    Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
                    xVar2 = GuildVisitorFeedNoticeAdapter.this.guildNoticeCallback;
                    if (xVar2 != null) {
                        xVar2.b(position, false);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
    public void c(@NotNull GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, @NotNull View view, int i3) {
        GuildSwipeMenuItemHelper.b.a.a(this, guildSwipeMenuItemHelper, view, i3);
    }
}
