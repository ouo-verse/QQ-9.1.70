package com.tencent.mobileqq.guild.inbox.centerpanel.notice;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.inbox.centerpanel.notice.c;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.menu.BaseMenuEntry;
import com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0004\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0014\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u000e\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/GuildNoticeViewHolder;", "viewHolder", "com/tencent/mobileqq/guild/inbox/centerpanel/notice/c$b", "k0", "(Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/GuildNoticeViewHolder;)Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/c$b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "m0", "holder", "position", "", "l0", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/x;", "cb", "o0", "getItemCount", "", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "guildNotices", "setItems", "n0", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/y;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/y;", "mCallback", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mGuildNotices", "D", "Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/x;", "guildNoticeCallback", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/centerpanel/notice/y;)V", "E", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends RecyclerView.Adapter<GuildNoticeViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<? extends co> mGuildNotices;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private x guildNoticeCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final y mCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/inbox/centerpanel/notice/c$b", "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper$b;", "Lcom/tencent/mobileqq/guild/widget/menu/GuildSwipeMenuItemHelper;", "menuHelper", "Landroid/view/View;", "menuView", "Lcom/tencent/mobileqq/guild/widget/menu/BaseMenuEntry;", "menuEntry", "hostItemView", "", "position", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements GuildSwipeMenuItemHelper.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildNoticeViewHolder f226181a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f226182b;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes13.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f226183a;

            static {
                int[] iArr = new int[BaseMenuEntry.MenuEntryType.values().length];
                try {
                    iArr[BaseMenuEntry.MenuEntryType.DELETE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f226183a = iArr;
            }
        }

        b(GuildNoticeViewHolder guildNoticeViewHolder, c cVar) {
            this.f226181a = guildNoticeViewHolder;
            this.f226182b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(c this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            x xVar = this$0.guildNoticeCallback;
            if (xVar != null) {
                xVar.a(i3);
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
        public void a(@NotNull GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, @NotNull View view, int i3) {
            GuildSwipeMenuItemHelper.b.a.b(this, guildSwipeMenuItemHelper, view, i3);
        }

        @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
        public void b(@NotNull GuildSwipeMenuItemHelper menuHelper, @NotNull View menuView, @NotNull BaseMenuEntry menuEntry, @NotNull View hostItemView, int position) {
            Intrinsics.checkNotNullParameter(menuHelper, "menuHelper");
            Intrinsics.checkNotNullParameter(menuView, "menuView");
            Intrinsics.checkNotNullParameter(menuEntry, "menuEntry");
            Intrinsics.checkNotNullParameter(hostItemView, "hostItemView");
            if (a.f226183a[menuEntry.getEntryType().ordinal()] == 1) {
                this.f226181a.getMSwipeMenuHelper().q();
                final int layoutPosition = this.f226181a.getLayoutPosition();
                if (layoutPosition != -1 && layoutPosition < this.f226182b.mGuildNotices.size()) {
                    Logger logger = Logger.f235387a;
                    c cVar = this.f226182b;
                    logger.d().d("Guild.C2C.GuildNoticeAdapter", 1, "[onMenuClick]--type:" + menuEntry.getEntryType() + ", position:" + layoutPosition + ",noticeId:" + ((co) cVar.mGuildNotices.get(layoutPosition)).f265885a);
                    View view = this.f226181a.itemView;
                    final c cVar2 = this.f226182b;
                    view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.inbox.centerpanel.notice.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.b.e(c.this, layoutPosition);
                        }
                    }, 200L);
                    return;
                }
                Logger logger2 = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "[onMenuClick]--out of range, position:" + layoutPosition;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.C2C.GuildNoticeAdapter", 1, (String) it.next(), null);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.widget.menu.GuildSwipeMenuItemHelper.b
        public void c(@NotNull GuildSwipeMenuItemHelper guildSwipeMenuItemHelper, @NotNull View view, int i3) {
            GuildSwipeMenuItemHelper.b.a.a(this, guildSwipeMenuItemHelper, view, i3);
        }
    }

    public c(@NotNull y mCallback) {
        List<? extends co> emptyList;
        Intrinsics.checkNotNullParameter(mCallback, "mCallback");
        this.mCallback = mCallback;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mGuildNotices = emptyList;
    }

    private final b k0(GuildNoticeViewHolder viewHolder) {
        return new b(viewHolder, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mGuildNotices.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull GuildNoticeViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.z(this.mGuildNotices.get(position), position);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.C2C.GuildNoticeAdapter", "pos:" + position + " " + this.mGuildNotices.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public GuildNoticeViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.eus, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026tice_item, parent, false)");
        GuildNoticeViewHolder guildNoticeViewHolder = new GuildNoticeViewHolder(inflate, this.mCallback);
        guildNoticeViewHolder.getMSwipeMenuHelper().g(k0(guildNoticeViewHolder));
        return guildNoticeViewHolder;
    }

    public final void n0(int position) {
        List mutableList;
        List<? extends co> list;
        if (position >= 0 && position < this.mGuildNotices.size()) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.mGuildNotices);
            mutableList.remove(position);
            list = CollectionsKt___CollectionsKt.toList(mutableList);
            this.mGuildNotices = list;
            notifyItemRemoved(position);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.GuildNoticeAdapter", 1, "removeItem position=" + position);
                return;
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "removeItem position=" + position + " out of range";
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.C2C.GuildNoticeAdapter", 1, (String) it.next(), null);
        }
    }

    public final void o0(@NotNull x cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.guildNoticeCallback = cb5;
    }

    public final void setItems(@NotNull List<? extends co> guildNotices) {
        Intrinsics.checkNotNullParameter(guildNotices, "guildNotices");
        this.mGuildNotices = guildNotices;
        notifyDataSetChanged();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.GuildNoticeAdapter", 2, "setItems mGuildNotices size=" + getItemCount());
        }
    }
}
