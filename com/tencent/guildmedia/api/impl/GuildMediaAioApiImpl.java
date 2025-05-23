package com.tencent.guildmedia.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guild.api.activity.IAIOSingleActivityApi;
import com.tencent.guildmedia.aio.excellentdetail.launch.GuildMediaAnnounceDetailFragment;
import com.tencent.guildmedia.aio.factory.a;
import com.tencent.guildmedia.aio.factory.b;
import com.tencent.guildmedia.api.IGuildMediaAioApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJJ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J2\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guildmedia/api/impl/GuildMediaAioApiImpl;", "Lcom/tencent/guildmedia/api/IGuildMediaAioApi;", "", "containerId", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "", "guildId", "channelId", "Landroid/os/Bundle;", "extra", "Let0/a;", "aioListener", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "components", "Lus0/b;", "initAIOFragment", "getMediaAioFactoryName", "getMediaAnnounceDetailFactoryName", "Landroid/content/Context;", "context", "", "firstCanShowSeq", "selfTinyId", "", "jumpToAnnounceDetail", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaAioApiImpl implements IGuildMediaAioApi {
    @Override // com.tencent.guildmedia.api.IGuildMediaAioApi
    @NotNull
    public String getMediaAioFactoryName() {
        String name = a.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildMediaAioFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.guildmedia.api.IGuildMediaAioApi
    @NotNull
    public String getMediaAnnounceDetailFactoryName() {
        String name = b.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildMediaAnnounceDetail\u2026oFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.guildmedia.api.IGuildMediaAioApi
    @NotNull
    public us0.b initAIOFragment(int containerId, @NotNull FragmentManager supportFragmentManager, @NotNull String guildId, @NotNull String channelId, @Nullable Bundle extra, @Nullable et0.a aioListener, @NotNull SparseArray<af> components) {
        Intrinsics.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(components, "components");
        String factoryName = a.class.getName();
        com.tencent.aio.api.factory.b.INSTANCE.a(new a(new WeakReference(aioListener), components));
        AIOContact aIOContact = new AIOContact(4, channelId, guildId, "");
        Bundle bundle = new Bundle();
        bundle.putInt("extra_channel_category", 2);
        if (extra != null) {
            bundle.putAll(extra);
        }
        AIOParam.a aVar = new AIOParam.a();
        Intrinsics.checkNotNullExpressionValue(factoryName, "factoryName");
        return new us0.a(com.tencent.aio.main.engine.b.d(com.tencent.aio.main.engine.b.f69377a, aVar.e(factoryName).h(new AIOSession(aIOContact)).d(0).a(bundle).c(), supportFragmentManager, containerId, null, 8, null));
    }

    @Override // com.tencent.guildmedia.api.IGuildMediaAioApi
    public void jumpToAnnounceDetail(@Nullable Context context, @NotNull String guildId, @NotNull String channelId, long firstCanShowSeq, @NotNull String selfTinyId) {
        FragmentActivity fragmentActivity;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("LAUNCHER_FROM_KEY", 2);
        intent.putExtra("guild_chosen_guild_id", guildId);
        intent.putExtra("guild_chosen_channel_id", channelId);
        intent.putExtra("guild_chosen_myself_tinyid", selfTinyId);
        intent.putExtra("guild_chosen_first_can_show_seq", firstCanShowSeq);
        intent.setClass(fragmentActivity, ((IAIOSingleActivityApi) QRoute.api(IAIOSingleActivityApi.class)).getAIOSingleActivityClass());
        intent.putExtra("public_fragment_class", GuildMediaAnnounceDetailFragment.class.getName());
        fragmentActivity.startActivityForResult(intent, 0);
    }
}
