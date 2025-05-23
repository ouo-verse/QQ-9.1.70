package com.tencent.mobileqq.guild.feed.morepanel;

import android.app.Activity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\u0006\fB\u001f\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005\u00a2\u0006\u0004\b&\u0010'R'\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\f\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\b\u0010!\u001a\u0004\b\u0013\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/k;", "", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "a", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "e", "()Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "panelContext", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "b", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "f", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;)V", "itemClickListener", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;", "c", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;", "d", "()Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;", "i", "(Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;)V", "operationListProvider", "Lcom/tencent/mobileqq/sharepanel/j;", "Lcom/tencent/mobileqq/sharepanel/j;", "()Lcom/tencent/mobileqq/sharepanel/j;", "g", "(Lcom/tencent/mobileqq/sharepanel/j;)V", "newItemClickListener", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;", "()Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;", tl.h.F, "(Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;)V", "newSharePanelItemProvider", "<init>", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PanelContext<Activity, vk1.b> panelContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheet.c itemClickListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a operationListProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.j newItemClickListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public b newSharePanelItemProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/k$a;", "", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "a", "()Ljava/util/List;", "operations", "b", "secondaryPaths", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        @NotNull
        List<ShareActionSheetBuilder.ActionSheetItem> a();

        @NotNull
        List<ShareActionSheetBuilder.ActionSheetItem> b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/k$b;", "", "Lcom/tencent/mobileqq/sharepanel/f;", "sharePanel", "", "b", "a", "e", "d", "", "c", "Lcom/tencent/mobileqq/sharepanel/model/d;", "getReportParams", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public static final class a {
            public static void a(@NotNull b bVar, @NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
                Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
            }

            public static void b(@NotNull b bVar, @NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
                Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
            }

            public static void c(@NotNull b bVar, @NotNull com.tencent.mobileqq.sharepanel.f sharePanel) {
                Intrinsics.checkNotNullParameter(sharePanel, "sharePanel");
            }
        }

        void a(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel);

        void b(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel);

        @NotNull
        String c();

        void d(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel);

        void e(@NotNull com.tencent.mobileqq.sharepanel.f sharePanel);

        @NotNull
        com.tencent.mobileqq.sharepanel.model.d getReportParams();
    }

    public k(@NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        this.panelContext = panelContext;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final ShareActionSheet.c getItemClickListener() {
        return this.itemClickListener;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final com.tencent.mobileqq.sharepanel.j getNewItemClickListener() {
        return this.newItemClickListener;
    }

    @NotNull
    public final b c() {
        b bVar = this.newSharePanelItemProvider;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("newSharePanelItemProvider");
        return null;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final a getOperationListProvider() {
        return this.operationListProvider;
    }

    @NotNull
    public final PanelContext<Activity, vk1.b> e() {
        return this.panelContext;
    }

    public final void f(@Nullable ShareActionSheet.c cVar) {
        this.itemClickListener = cVar;
    }

    public final void g(@Nullable com.tencent.mobileqq.sharepanel.j jVar) {
        this.newItemClickListener = jVar;
    }

    public final void h(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.newSharePanelItemProvider = bVar;
    }

    public final void i(@Nullable a aVar) {
        this.operationListProvider = aVar;
    }
}
