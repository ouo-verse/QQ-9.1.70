package com.tencent.mobileqq.guild.discoveryv2.myguild;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014R\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/u;", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "onGuildListUpdated", "", "guildId", "onDestoryGuild", "onRemoveGuild", "", "black", "onBeKickFromGuild", "onGuildInfoUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "securityResult", "onSecurityResult", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "myGuildFragmentRef", "myGuildFragment", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class u extends GPServiceObserver {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<MyGuildFragment> myGuildFragmentRef;

    public u(@NotNull MyGuildFragment myGuildFragment) {
        Intrinsics.checkNotNullParameter(myGuildFragment, "myGuildFragment");
        this.myGuildFragmentRef = new WeakReference<>(myGuildFragment);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onBeKickFromGuild(@NotNull String guildId, int black) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("Guild.discovery.MyGuildFragment", 1, "onBeKickFromGuild: guild: " + guildId + " black: " + black);
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.fi();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("guildId", guildId);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(black);
        hashMap.put("black", sb5.toString());
        com.tencent.mobileqq.guild.performance.report.m.INSTANCE.a().e("Guild.MF.Lt.GuildLeftBarViewModelonBeKickFromGuild", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onDestoryGuild(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.w("Guild.discovery.MyGuildFragment", 1, "onDestroy Guild:" + guildId);
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.fi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onGuildInfoUpdated(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        super.onGuildInfoUpdated(guildId);
        QLog.i("Guild.discovery.MyGuildFragment", 1, "onGuildInfoUpdated: guild: " + guildId);
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.fi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onGuildListUpdated() {
        QLog.w("Guild.discovery.MyGuildFragment", 1, "onGuildListUpdated");
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.fi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onRemoveGuild(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("Guild.discovery.MyGuildFragment", 1, "onRemoveGuild: guild: " + guildId);
        MyGuildFragment myGuildFragment = this.myGuildFragmentRef.get();
        if (myGuildFragment != null) {
            myGuildFragment.fi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onSecurityResult(@NotNull IGProSecurityResult securityResult) {
        Intrinsics.checkNotNullParameter(securityResult, "securityResult");
        ch.c1(securityResult);
    }
}
