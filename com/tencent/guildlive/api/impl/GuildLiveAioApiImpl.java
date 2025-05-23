package com.tencent.guildlive.api.impl;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.api.perf.a;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.guildlive.api.IGuildLiveAioApi;
import com.tencent.qphone.base.util.QLog;
import fn0.c;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJR\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J*\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a8\u0006\""}, d2 = {"Lcom/tencent/guildlive/api/impl/GuildLiveAioApiImpl;", "Lcom/tencent/guildlive/api/IGuildLiveAioApi;", "", "containerId", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "", "guildId", "channelId", "Landroid/os/Bundle;", "extra", "Lts0/a;", "liveAIOListener", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "components", "Lfn0/c;", "liveAioMsgReceiveCallback", "Lxr0/a;", "initAIOFragment", "factoryName", "", "removeAIOFactory", "getLiveAioFactoryName", "getLiveAioDetailFactoryName", "Landroid/content/Context;", "context", "", "firstCanShowSeq", "jumpToExcellentMsgDetail", "<init>", "()V", "Companion", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAioApiImpl implements IGuildLiveAioApi {

    @NotNull
    private static final String TAG = "GuildLiveAioApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guildlive/api/impl/GuildLiveAioApiImpl$b", "Lcom/tencent/aio/api/perf/a;", "", "time", "", "c", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.aio.api.perf.a
        public void a(@NotNull a.b bVar) {
            a.C0622a.a(this, bVar);
        }

        @Override // com.tencent.aio.api.perf.a
        public void c(long time) {
            QLog.i(GuildLiveAioApiImpl.TAG, 1, "[startUpCost] time:" + time);
        }
    }

    @Override // com.tencent.guildlive.api.IGuildLiveAioApi
    @NotNull
    public String getLiveAioDetailFactoryName() {
        String name = com.tencent.guildlive.aio.factory.b.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildLiveAnnounceDetailAioFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.guildlive.api.IGuildLiveAioApi
    @NotNull
    public String getLiveAioFactoryName() {
        String name = com.tencent.guildlive.aio.factory.a.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildLiveAioFactory::class.java.name");
        return name;
    }

    @Override // com.tencent.guildlive.api.IGuildLiveAioApi
    @NotNull
    public xr0.a initAIOFragment(int containerId, @NotNull FragmentManager supportFragmentManager, @NotNull String guildId, @NotNull String channelId, @Nullable Bundle extra, @NotNull ts0.a liveAIOListener, @NotNull SparseArray<af> components, @Nullable c liveAioMsgReceiveCallback) {
        Intrinsics.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(liveAIOListener, "liveAIOListener");
        Intrinsics.checkNotNullParameter(components, "components");
        String factoryName = com.tencent.guildlive.aio.factory.a.class.getName();
        com.tencent.aio.api.factory.b.INSTANCE.a(new com.tencent.guildlive.aio.factory.a(new WeakReference(liveAIOListener), components));
        AIOContact aIOContact = new AIOContact(4, channelId, guildId, "");
        Bundle bundle = new Bundle();
        bundle.putInt("extra_channel_category", 5);
        if (extra != null) {
            bundle.putAll(extra);
        }
        AIOParam.a aVar = new AIOParam.a();
        Intrinsics.checkNotNullExpressionValue(factoryName, "factoryName");
        us.a c16 = com.tencent.aio.main.engine.b.f69377a.c(aVar.e(factoryName).h(new AIOSession(aIOContact)).d(0).a(bundle).i(true).c(), supportFragmentManager, containerId, new b());
        if (liveAioMsgReceiveCallback != null) {
            zr0.a.f453068a.b(liveAioMsgReceiveCallback);
        }
        return new ss0.a(c16);
    }

    @Override // com.tencent.guildlive.api.IGuildLiveAioApi
    public void jumpToExcellentMsgDetail(@Nullable Context context, @NotNull String guildId, @NotNull String channelId, long firstCanShowSeq) {
        FragmentActivity fragmentActivity;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        FragmentActivity fragmentActivity2 = fragmentActivity;
        if (fragmentActivity2 != null) {
            bs0.a.f29030a.a(fragmentActivity2, guildId, channelId, 2, firstCanShowSeq);
        }
    }

    @Override // com.tencent.guildlive.api.IGuildLiveAioApi
    public void removeAIOFactory(@NotNull String factoryName) {
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        com.tencent.aio.api.factory.b.INSTANCE.c(factoryName);
    }
}
