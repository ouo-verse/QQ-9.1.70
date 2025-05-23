package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.x;
import com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0010B\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002J0\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0016R\u001c\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/t;", "Lcom/tencent/mobileqq/guild/feed/morepanel/handler/x;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "c", "", "id", "a", "Lmqq/util/WeakReference;", "Lcom/tencent/biz/richframework/part/PartManager;", "Lmqq/util/WeakReference;", "partManagerRef", "partManager", "<init>", "(Lcom/tencent/biz/richframework/part/PartManager;)V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class t implements x {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<PartManager> partManagerRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u0002`\u0005H\u0002R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/t$a;", "", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lvk1/b;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "Lcom/tencent/mobileqq/guild/feed/share/c;", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.t$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final com.tencent.mobileqq.guild.feed.share.c b(PanelContext<Activity, vk1.b> panelContext) {
            GProStFeed gProStFeed;
            String str;
            com.tencent.mobileqq.guild.feed.share.c cVar = new com.tencent.mobileqq.guild.feed.share.c();
            Object a16 = panelContext.j().a();
            Object obj = null;
            if (a16 instanceof GProStFeed) {
                gProStFeed = (GProStFeed) a16;
            } else {
                gProStFeed = null;
            }
            cVar.l(gProStFeed);
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            if (gProStFeed != null) {
                str = gProStFeed.idd;
            } else {
                str = null;
            }
            String str2 = "convert2ShareInfo feedRawDataIdd:" + str;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("guild.share.GuildFeedSaveMediaHandler", 1, (String) it.next(), null);
            }
            cVar.k(panelContext.h().hashCode());
            Object n3 = panelContext.j().n();
            if (n3 instanceof GuildFeedRichMediaData) {
                obj = n3;
            }
            cVar.o((GuildFeedRichMediaData) obj);
            cVar.n(String.valueOf(panelContext.j().getGuildId()));
            cVar.j(String.valueOf(panelContext.j().getChannelId()));
            cVar.q(panelContext.j().r());
            cVar.m(panelContext.getExtra().getInt("EXTRA_KEY_FROM_PAGE", 0));
            cVar.i(panelContext.getExtra().getInt("src_business_type", 0));
            return cVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/morepanel/handler/t$b", "Lcom/tencent/mobileqq/guild/feed/share/GuildFeedRichMediaDownLoadManager$c;", "", "a", "", "success", "onStatusChange", "", "progress", "onProgress", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildFeedRichMediaDownLoadManager.c {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void a() {
            PartManager partManager = (PartManager) t.this.partManagerRef.get();
            if (partManager != null) {
                partManager.broadcastMessage("rich_media_download_show", null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void onProgress(int progress) {
            PartManager partManager = (PartManager) t.this.partManagerRef.get();
            if (partManager != null) {
                partManager.broadcastMessage("rich_meida_download_progress", Integer.valueOf(progress));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.share.GuildFeedRichMediaDownLoadManager.c
        public void onStatusChange(boolean success) {
            PartManager partManager = (PartManager) t.this.partManagerRef.get();
            if (partManager != null) {
                partManager.broadcastMessage("rich_media_download_status", Boolean.valueOf(success));
            }
        }
    }

    public t(@Nullable PartManager partManager) {
        this.partManagerRef = new WeakReference<>(partManager);
    }

    private final boolean e(PanelContext<Activity, vk1.b> panelContext) {
        com.tencent.mobileqq.guild.feed.share.b bVar = new com.tencent.mobileqq.guild.feed.share.b();
        bVar.d(panelContext.h());
        bVar.e(INSTANCE.b(panelContext));
        bVar.p(new b());
        bVar.o();
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean a(@NotNull String id5, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        return e(panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.y
    public boolean b(@NotNull String str, @NotNull PanelContext<Activity, vk1.b> panelContext) {
        return x.a.c(this, str, panelContext);
    }

    @Override // com.tencent.mobileqq.guild.feed.morepanel.handler.x
    public boolean c(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull PanelContext<Activity, vk1.b> panelContext, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        Logger.f235387a.d().i("guild.share.GuildFeedSaveMediaHandler", 1, "handle Save");
        shareActionSheet.dismiss();
        return e(panelContext);
    }

    public /* synthetic */ t(PartManager partManager, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : partManager);
    }
}
