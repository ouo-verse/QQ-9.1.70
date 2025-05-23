package com.tencent.guildlive.api;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import fn0.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xr0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JV\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0017\u001a\u00020\u0006H&J\b\u0010\u0018\u001a\u00020\u0006H&J*\u0010\u001d\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/guildlive/api/IGuildLiveAioApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "containerId", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "", "guildId", "channelId", "Landroid/os/Bundle;", "extra", "Lts0/a;", "liveAIOListener", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "components", "Lfn0/c;", "liveAioMsgReceiveCallback", "Lxr0/a;", "initAIOFragment", "factoryName", "", "removeAIOFactory", "getLiveAioFactoryName", "getLiveAioDetailFactoryName", "Landroid/content/Context;", "context", "", "firstCanShowSeq", "jumpToExcellentMsgDetail", "aio-guild-live-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildLiveAioApi extends QRouteApi {
    @NotNull
    String getLiveAioDetailFactoryName();

    @NotNull
    String getLiveAioFactoryName();

    @NotNull
    a initAIOFragment(int containerId, @NotNull FragmentManager supportFragmentManager, @NotNull String guildId, @NotNull String channelId, @Nullable Bundle extra, @NotNull ts0.a liveAIOListener, @NotNull SparseArray<af> components, @Nullable c liveAioMsgReceiveCallback);

    void jumpToExcellentMsgDetail(@Nullable Context context, @NotNull String guildId, @NotNull String channelId, long firstCanShowSeq);

    void removeAIOFactory(@NotNull String factoryName);
}
