package com.tencent.mobileqq.guild.discoveryv2.fragment;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.guild.discoveryv2.fragment.f;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\t\"\u0017\u0010\u0005\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0007\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\b\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0002\u001a\u0004\b\u0001\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/fragment/f;", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/f;", "c", "()Lcom/tencent/mobileqq/guild/discoveryv2/fragment/f;", "sourceTabViewConfig", "b", "publicAccountConfig", "myFeedsConfig", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final f f217434a = new c();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final f f217435b = new b();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final f f217436c = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/fragment/g$a", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/f;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements f {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart.b
        public void a(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            ViewExtKt.f(recyclerView, bi.b(9));
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart.b
        public void b(@NotNull SmartRefreshLayout smartRefreshLayout) {
            f.a.c(this, smartRefreshLayout);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart.b
        public boolean c() {
            return f.a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/fragment/g$b", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/f;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements f {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart.b
        public void a(@NotNull RecyclerView recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            ViewExtKt.f(recyclerView, bi.b(16));
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart.b
        public void b(@NotNull SmartRefreshLayout smartRefreshLayout) {
            f.a.c(this, smartRefreshLayout);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart.b
        public boolean c() {
            return f.a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/fragment/g$c", "Lcom/tencent/mobileqq/guild/discoveryv2/fragment/f;", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements f {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.part.ContentPart.b
        public void a(@NotNull RecyclerView recyclerView) {
            f.a.b(this, recyclerView);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart.b
        public void b(@NotNull SmartRefreshLayout smartRefreshLayout) {
            f.a.c(this, smartRefreshLayout);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.content.refresh.RefreshPart.b
        public boolean c() {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_mvp_feeds_content_lock_enable", true);
        }
    }

    @NotNull
    public static final f a() {
        return f217436c;
    }

    @NotNull
    public static final f b() {
        return f217435b;
    }

    @NotNull
    public static final f c() {
        return f217434a;
    }
}
