package com.tencent.mobileqq.guild.discoveryv2.myguild;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.widget.GuildSmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.ca;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/an;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/AutoRefreshFetchDataCallback;", "", "success", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "myGuildFragment", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class an extends AutoRefreshFetchDataCallback {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(@NotNull MyGuildFragment myGuildFragment) {
        super(myGuildFragment);
        Intrinsics.checkNotNullParameter(myGuildFragment, "myGuildFragment");
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.AutoRefreshFetchDataCallback, com.tencent.mobileqq.guild.discoveryv2.myguild.d
    public void a() {
        ca binding;
        GuildSmartRefreshLayout guildSmartRefreshLayout;
        super.a();
        MyGuildFragment myGuildFragment = b().get();
        if (myGuildFragment != null && (binding = myGuildFragment.getBinding()) != null && (guildSmartRefreshLayout = binding.f442666d) != null) {
            guildSmartRefreshLayout.finishRefresh();
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.myguild.AutoRefreshFetchDataCallback, com.tencent.mobileqq.guild.discoveryv2.myguild.d
    public void success() {
        RecyclerView recyclerView;
        GuildSmartRefreshLayout guildSmartRefreshLayout;
        super.success();
        MyGuildFragment myGuildFragment = b().get();
        if (myGuildFragment != null) {
            ca binding = myGuildFragment.getBinding();
            if (binding != null && (guildSmartRefreshLayout = binding.f442666d) != null) {
                guildSmartRefreshLayout.finishRefresh();
            }
            ca binding2 = myGuildFragment.getBinding();
            if (binding2 != null && (recyclerView = binding2.f442664b) != null) {
                recyclerView.scrollToPosition(0);
            }
        }
    }
}
