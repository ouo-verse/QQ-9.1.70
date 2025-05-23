package com.tencent.mobileqq.qwallet.hb.panel;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.panel.viewholder.BottomTextLinkViewHolder;
import com.tencent.mobileqq.qwallet.hb.panel.viewholder.EntryViewHolder;
import com.tencent.mobileqq.qwallet.hb.panel.viewholder.LimitedRecommendViewHolder;
import com.tencent.mobileqq.qwallet.hb.panel.viewholder.RecommendViewHolder;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.qwallet.hb.send.PanelTabData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000256B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0004\u001a\u00020\u0003H\u0003J\u001a\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0014\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u001c\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bJ\u0016\u0010\u0013\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00100 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qwallet/hb/panel/viewholder/a;", "", "m0", "", "layoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "j0", "", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelEntryData;", "list", "o0", "displayType", "Lcom/tencent/mobileqq/qwallet/pb/a;", "p0", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "n0", "position", "i0", "getItemViewType", "viewType", "l0", "holder", "k0", "getItemCount", "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/hb/panel/a;", "panelHost", "", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "dataSumList", "D", "hbEntryList", "E", "I", UserInfo.SEX_FEMALE, "recommendList", "Lcom/tencent/mobileqq/qwallet/hb/panel/c$b;", "G", "Lcom/tencent/mobileqq/qwallet/hb/panel/c$b;", "bottomTextLinkData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "H", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRefreshing", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/panel/a;)V", "a", "b", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends RecyclerView.Adapter<com.tencent.mobileqq.qwallet.hb.panel.viewholder.a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<Object> dataSumList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<PanelEntryData> hbEntryList;

    /* renamed from: E, reason: from kotlin metadata */
    private int displayType;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.qwallet.pb.a> recommendList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b bottomTextLinkData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final AtomicBoolean isRefreshing;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a panelHost;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/c$b;", "", "", "Lcom/tencent/mobileqq/qwallet/hb/send/PanelTabData;", "a", "Ljava/util/List;", "()Ljava/util/List;", "b", "(Ljava/util/List;)V", "list", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private List<PanelTabData> list;

        @Nullable
        public final List<PanelTabData> a() {
            return this.list;
        }

        public final void b(@Nullable List<PanelTabData> list) {
            this.list = list;
        }
    }

    public c(@NotNull a panelHost) {
        Intrinsics.checkNotNullParameter(panelHost, "panelHost");
        this.panelHost = panelHost;
        this.dataSumList = new ArrayList();
        this.hbEntryList = new ArrayList();
        this.recommendList = new ArrayList();
        this.bottomTextLinkData = new b();
        this.isRefreshing = new AtomicBoolean(false);
    }

    private final View j0(@LayoutRes int layoutId, ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf\u2026(layoutId, parent, false)");
        return inflate;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void m0() {
        Object first;
        boolean z16 = true;
        if (this.isRefreshing.compareAndSet(false, true)) {
            this.dataSumList.clear();
            this.dataSumList.addAll(this.hbEntryList);
            if (!this.recommendList.isEmpty()) {
                int i3 = this.displayType;
                if (i3 == 0) {
                    this.dataSumList.add(new SkinHeaderData(""));
                    this.dataSumList.addAll(this.recommendList);
                } else if (i3 == 1) {
                    List<Object> list = this.dataSumList;
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.recommendList);
                    list.add(first);
                }
            }
            List<PanelTabData> a16 = this.bottomTextLinkData.a();
            if (a16 != null && !a16.isEmpty()) {
                z16 = false;
            }
            if (!z16) {
                this.dataSumList.add(this.bottomTextLinkData);
            }
            notifyDataSetChanged();
            this.isRefreshing.set(false);
            return;
        }
        QLog.w("PanelPagerAdapter", 1, "refreshItemsInList fail", new IllegalStateException());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.dataSumList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        Object obj = this.dataSumList.get(position);
        if (obj instanceof PanelEntryData) {
            return 0;
        }
        if (obj instanceof SkinHeaderData) {
            return 1;
        }
        if (obj instanceof com.tencent.mobileqq.qwallet.pb.a) {
            int i3 = this.displayType;
            if (i3 != 0) {
                if (i3 == 1) {
                    return 3;
                }
            } else {
                return 2;
            }
        } else if (obj instanceof b) {
            return 4;
        }
        return 5;
    }

    public final int i0(int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 0) {
            return 4;
        }
        if (itemViewType != 1) {
            if (itemViewType == 2) {
                return 3;
            }
            if (itemViewType != 3 && itemViewType != 4) {
                return 12;
            }
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.mobileqq.qwallet.hb.panel.viewholder.a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.n(this.dataSumList.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.qwallet.hb.panel.viewholder.a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1) {
                if (viewType != 2) {
                    if (viewType != 3) {
                        if (viewType != 4) {
                            return new com.tencent.mobileqq.qwallet.hb.panel.viewholder.c(this.panelHost, new View(parent.getContext()));
                        }
                        return new BottomTextLinkViewHolder(this.panelHost, j0(R.layout.hjo, parent));
                    }
                    return new LimitedRecommendViewHolder(this.panelHost, j0(R.layout.hjq, parent));
                }
                return new RecommendViewHolder(this.panelHost, j0(R.layout.hjr, parent));
            }
            return new com.tencent.mobileqq.qwallet.hb.panel.viewholder.b(this.panelHost, j0(R.layout.hju, parent));
        }
        return new EntryViewHolder(this.panelHost, j0(R.layout.hjp, parent));
    }

    public final void n0(@Nullable List<PanelTabData> list) {
        this.bottomTextLinkData.b(list);
        m0();
    }

    public final void o0(@NotNull List<PanelEntryData> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.hbEntryList.clear();
        this.hbEntryList.addAll(list);
        m0();
    }

    public final void p0(int displayType, @NotNull List<? extends com.tencent.mobileqq.qwallet.pb.a> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.displayType = displayType;
        this.recommendList.clear();
        this.recommendList.addAll(list);
        m0();
    }
}
