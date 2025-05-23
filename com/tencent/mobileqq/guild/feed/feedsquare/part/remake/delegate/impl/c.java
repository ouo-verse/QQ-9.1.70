package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.delegate.impl;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J.\u0010\u000e\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\fH\u0014R\u0018\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/delegate/impl/c;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "tinyId", "", "e", "onMemberTopRoleChanged", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "onChannelPermissionChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;", "context", "Lvi1/a;", "Lvi1/a;", "concatAdapterApi", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "f", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "feedListAdapter", "", tl.h.F, "Ljava/lang/Boolean;", "hasFeedChannelContentPermission", "Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "b", "()Lcom/tencent/mobileqq/guild/data/IGuildParcelizeSimpleContact;", "contact", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/b;Lvi1/a;Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class c extends GPServiceObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<?> context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final vi1.a concatAdapterApi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AsyncListDifferDelegationAdapter<com.tencent.mobileqq.guild.feed.feedsquare.data.h> feedListAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean hasFeedChannelContentPermission;

    public c(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<?> context, @NotNull vi1.a concatAdapterApi, @NotNull AsyncListDifferDelegationAdapter<com.tencent.mobileqq.guild.feed.feedsquare.data.h> feedListAdapter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(concatAdapterApi, "concatAdapterApi");
        Intrinsics.checkNotNullParameter(feedListAdapter, "feedListAdapter");
        this.context = context;
        this.concatAdapterApi = concatAdapterApi;
        this.feedListAdapter = feedListAdapter;
    }

    private final IGuildParcelizeSimpleContact b() {
        return this.context.d().a();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void e(String guildId, String tinyId) {
        AppInterface appInterface;
        if (!TextUtils.isEmpty(guildId) && Intrinsics.areEqual(guildId, b().getGuildId())) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            Iterator<com.tencent.mobileqq.guild.feed.feedsquare.data.h> it = this.feedListAdapter.getItems().iterator();
            boolean z16 = false;
            while (it.hasNext()) {
                GProStFeed b16 = it.next().getBlockData().b();
                if (Intrinsics.areEqual(b16.poster.idd, tinyId) && iGPSService != null) {
                    GProStUser gProStUser = b16.poster;
                    Intrinsics.checkNotNullExpressionValue(gProStUser, "sourceData.poster");
                    if (com.tencent.mobileqq.guild.feed.nativeinterface.kt.b.b(gProStUser, iGPSService, guildId, b().getChannelId(), tinyId)) {
                        z16 = true;
                    }
                }
            }
            if (z16) {
                this.concatAdapterApi.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onChannelPermissionChanged(@Nullable String guildId, @Nullable HashSet<String> channelIds) {
        if (Intrinsics.areEqual(guildId, b().getGuildId())) {
            boolean z16 = false;
            if (channelIds != null && channelIds.contains(b().getChannelId())) {
                z16 = true;
            }
            if (z16) {
                this.concatAdapterApi.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx permission) {
        Boolean bool;
        if (!Intrinsics.areEqual(guildId, b().getGuildId())) {
            return;
        }
        if (permission != null) {
            bool = Boolean.valueOf(permission.a(30002));
        } else {
            bool = null;
        }
        if (!Intrinsics.areEqual(this.hasFeedChannelContentPermission, bool)) {
            this.hasFeedChannelContentPermission = bool;
            this.concatAdapterApi.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onMemberTopRoleChanged(@NotNull String guildId, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        super.onMemberTopRoleChanged(guildId, tinyId);
        e(guildId, tinyId);
    }
}
