package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.tencent.mobileqq.guild.discoveryv2.myguild.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryPageGuildsRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.bt;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001cJ,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/c;", "Lwh2/bt;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGetCategoryPageGuildsRsp;", "rsp", "", "rspBuf", "", "a", "", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/j;", "Ljava/util/List;", "addedGuilds", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/d;", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/d;", "fetchDataCallback", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "kotlin.jvm.PlatformType", "c", "Lmqq/util/WeakReference;", "myGuildFragmentRef", "myGuildFragment", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;Lcom/tencent/mobileqq/guild/discoveryv2/myguild/d;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements bt {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<MyGuildData> addedGuilds;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final d fetchDataCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<MyGuildFragment> myGuildFragmentRef;

    public c(@NotNull List<MyGuildData> addedGuilds, @NotNull MyGuildFragment myGuildFragment, @Nullable d dVar) {
        Intrinsics.checkNotNullParameter(addedGuilds, "addedGuilds");
        Intrinsics.checkNotNullParameter(myGuildFragment, "myGuildFragment");
        this.addedGuilds = addedGuilds;
        this.fetchDataCallback = dVar;
        this.myGuildFragmentRef = new WeakReference<>(myGuildFragment);
    }

    @Override // wh2.bt
    public void a(int result, @Nullable String errMsg, @Nullable IGProGetCategoryPageGuildsRsp rsp, @NotNull byte[] rspBuf) {
        Intrinsics.checkNotNullParameter(rspBuf, "rspBuf");
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            List<MyGuildRecommendData> l06 = myGuildFragment.getMyGuildAdapter().l0();
            if (rsp == null) {
                Logger.f235387a.d().i("Guild.discovery.MyGuildFragment", 1, "getDiscoverRecommendDetail response is null, return");
                d dVar = this.fetchDataCallback;
                if (dVar != null) {
                    dVar.a();
                    return;
                }
                return;
            }
            if (result == 0 && !rsp.getItems().isEmpty()) {
                Logger.f235387a.d().i("Guild.discovery.MyGuildFragment", 1, "getDiscoverRecommendDetail response success");
                if (!(this.fetchDataCallback instanceof f)) {
                    l06.clear();
                }
                String itemTraceId = rsp.getTraceId();
                ArrayList<IGProRecommendItem> items = rsp.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "rsp.items");
                Iterator<T> it = items.iterator();
                while (it.hasNext()) {
                    IGProRecommendChannelInfo channelInfo = ((IGProRecommendItem) it.next()).getChannelInfo();
                    if (channelInfo != null) {
                        Intrinsics.checkNotNullExpressionValue(channelInfo, "channelInfo");
                        String valueOf = String.valueOf(channelInfo.getGuildId());
                        String valueOf2 = String.valueOf(channelInfo.getChannelId());
                        String joinGuildSig = channelInfo.getJoinGuildSig();
                        Intrinsics.checkNotNullExpressionValue(joinGuildSig, "info.joinGuildSig");
                        String guildIcon = channelInfo.getGuildIcon();
                        Intrinsics.checkNotNullExpressionValue(guildIcon, "info.guildIcon");
                        String guildName = channelInfo.getGuildName();
                        Intrinsics.checkNotNullExpressionValue(guildName, "info.guildName");
                        String guildProfile = channelInfo.getGuildProfile();
                        Intrinsics.checkNotNullExpressionValue(guildProfile, "info.guildProfile");
                        e.Companion companion = e.INSTANCE;
                        String b16 = companion.b(channelInfo.getMedalInfoList());
                        List<String> c16 = companion.c(channelInfo.getTagList());
                        Intrinsics.checkNotNullExpressionValue(itemTraceId, "itemTraceId");
                        l06.add(new MyGuildRecommendData(valueOf, valueOf2, joinGuildSig, guildIcon, guildName, guildProfile, b16, c16, itemTraceId, ch.j0(String.valueOf(channelInfo.getGuildId()))));
                    }
                }
                com.tencent.mobileqq.guild.discoveryv2.content.base.f.k0(myGuildFragment.getLoadMoreAdapter(), false, rsp.getIsEnd(), null, 4, null);
                myGuildFragment.getMyGuildAdapter().q0(this.addedGuilds, l06, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.c();
                    }
                });
                d dVar2 = this.fetchDataCallback;
                if (dVar2 != null) {
                    dVar2.success();
                }
                myGuildFragment.di(myGuildFragment.getRefreshNum() + 1);
                return;
            }
            Logger.f235387a.d().i("Guild.discovery.MyGuildFragment", 1, "getDiscoverRecommendDetail response is failed | item is empty, return");
            d dVar3 = this.fetchDataCallback;
            if (dVar3 != null) {
                dVar3.a();
            }
            com.tencent.mobileqq.guild.discoveryv2.content.base.f.k0(myGuildFragment.getLoadMoreAdapter(), false, rsp.getIsEnd(), null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
    }
}
