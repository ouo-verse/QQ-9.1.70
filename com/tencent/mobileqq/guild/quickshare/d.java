package com.tencent.mobileqq.guild.quickshare;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.temp.model.GuildRecentUser;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002R \u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/quickshare/d;", "Lef1/b;", "", "N1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/guild/temp/model/GuildRecentUser;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_recentUserLiveData", "O1", "()Landroidx/lifecycle/MutableLiveData;", "recentUserLiveData", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<GuildRecentUser>> _recentUserLiveData = new MutableLiveData<>(new ArrayList());

    public d() {
        N1();
    }

    private final void N1() {
        List<GuildRecentUser> take;
        MutableLiveData<List<GuildRecentUser>> mutableLiveData = this._recentUserLiveData;
        ArrayList<GuildRecentUser> recentUsers = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).getRecentUsers(ch.m());
        Intrinsics.checkNotNullExpressionValue(recentUsers, "api(IGuildFeatureAdapter\u2026il.appRuntime()\n        )");
        take = CollectionsKt___CollectionsKt.take(recentUsers, 15);
        mutableLiveData.setValue(take);
    }

    @NotNull
    public final MutableLiveData<List<GuildRecentUser>> O1() {
        return this._recentUserLiveData;
    }
}
