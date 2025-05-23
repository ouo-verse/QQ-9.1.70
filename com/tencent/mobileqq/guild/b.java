package com.tencent.mobileqq.guild;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import wh2.ck;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\\\u0010\t\u001a\u00020\b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/b;", "Lwh2/ck;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lkotlin/collections/ArrayList;", "createdGuilds", "managedGuilds", "joinedGuilds", "", "onGetGuildsInContact", "", "a", "I", "getFrom", "()I", "from", "", "b", "Ljava/lang/String;", "account", "Lmqq/util/WeakReference;", "Landroidx/fragment/app/Fragment;", "kotlin.jvm.PlatformType", "c", "Lmqq/util/WeakReference;", "guildContactFragmentRef", "guildListFragment", "<init>", "(Landroidx/fragment/app/Fragment;ILjava/lang/String;)V", "d", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b implements ck {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int from;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String account;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Fragment> guildContactFragmentRef;

    public b(Fragment guildListFragment, int i3, String account) {
        Intrinsics.checkNotNullParameter(guildListFragment, "guildListFragment");
        Intrinsics.checkNotNullParameter(account, "account");
        this.from = i3;
        this.account = account;
        this.guildContactFragmentRef = new WeakReference<>(guildListFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b this$0, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Fragment fragment = this$0.guildContactFragmentRef.get();
        if (fragment == null) {
            fragment = null;
        } else if (fragment instanceof GuildContactFragment) {
            GuildContactFragment guildContactFragment = (GuildContactFragment) fragment;
            guildContactFragment.Ph(this$0.account, arrayList, arrayList2, arrayList3);
            if (2 == this$0.from) {
                guildContactFragment.Qh(true);
            }
        } else if (fragment instanceof GuildTestFragment) {
            ((GuildTestFragment) fragment).sh(this$0.account, arrayList, arrayList2, arrayList3);
        }
        if (fragment == null) {
            QLog.i("GuildContactFragment", 1, "runOnUI, guildListFragment is null");
        }
    }

    @Override // wh2.ck
    public void onGetGuildsInContact(final ArrayList<IGProGuildInfo> createdGuilds, final ArrayList<IGProGuildInfo> managedGuilds, final ArrayList<IGProGuildInfo> joinedGuilds) {
        Fragment fragment = this.guildContactFragmentRef.get();
        if (fragment != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.b(b.this, createdGuilds, managedGuilds, joinedGuilds);
                }
            });
        } else {
            fragment = null;
        }
        if (fragment == null) {
            QLog.i("GuildContactFragment", 1, "guildListFragment is null");
        }
    }
}
