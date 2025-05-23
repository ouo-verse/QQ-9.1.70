package com.tencent.guildmedia.api;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.fragment.app.FragmentManager;
import com.tencent.guild.aio.component.combinestyle.af;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import et0.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import us0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JJ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH&J\b\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J2\u0010\u001a\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0006H&\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guildmedia/api/IGuildMediaAioApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "containerId", "Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "", "guildId", "channelId", "Landroid/os/Bundle;", "extra", "Let0/a;", "aioListener", "Landroid/util/SparseArray;", "Lcom/tencent/guild/aio/component/combinestyle/af;", "components", "Lus0/b;", "initAIOFragment", "getMediaAioFactoryName", "getMediaAnnounceDetailFactoryName", "Landroid/content/Context;", "context", "", "firstCanShowSeq", "selfTinyId", "", "jumpToAnnounceDetail", "aio-guild-media-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildMediaAioApi extends QRouteApi {
    @NotNull
    String getMediaAioFactoryName();

    @NotNull
    String getMediaAnnounceDetailFactoryName();

    @NotNull
    b initAIOFragment(int containerId, @NotNull FragmentManager supportFragmentManager, @NotNull String guildId, @NotNull String channelId, @Nullable Bundle extra, @Nullable a aioListener, @NotNull SparseArray<af> components);

    void jumpToAnnounceDetail(@Nullable Context context, @NotNull String guildId, @NotNull String channelId, long firstCanShowSeq, @NotNull String selfTinyId);
}
