package li1;

import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.inbox.startpanel.d;
import com.tencent.mobileqq.guild.inbox.startpanel.p;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0013\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0006R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lli1/b;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/d;", "", "position", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "k0", "getItemViewType", "", "uiDataList", "Ljava/lang/Runnable;", "runnable", "p0", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "inboxListView", "o0", "j0", "Lki1/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lki1/a;", "boxSelectHelper", "Lcom/tencent/mobileqq/guild/inbox/startpanel/d$b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/inbox/startpanel/d$b;", "mNodeCallback", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "D", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "mDragHost", "E", "Ljava/util/List;", "mUIDataList", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "mInboxListView", "<init>", "(Lki1/a;Lcom/tencent/mobileqq/guild/inbox/startpanel/d$b;Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;)V", "G", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends ListAdapter<p, d> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d.b mNodeCallback;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final DragFrameLayout mDragHost;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<? extends p> mUIDataList;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private OverScrollRecyclerViewWithHeaderFooter mInboxListView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ki1.a boxSelectHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"li1/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/p;", "oldItem", "newItem", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends DiffUtil.ItemCallback<p> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull p oldItem, @NotNull p newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            boolean areEqual = Intrinsics.areEqual(oldItem, newItem);
            if (QLog.isDevelopLevel() && !areEqual) {
                QLog.d("GuildInboxC2CAdapterV2", 2, "isNotSame!! old: ", oldItem, " new: ", newItem);
            }
            return areEqual;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull p oldItem, @NotNull p newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem != newItem && !TextUtils.equals(oldItem.f226296e, newItem.f226296e)) {
                return false;
            }
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull ki1.a boxSelectHelper, @NotNull d.b mNodeCallback, @NotNull DragFrameLayout mDragHost) {
        super(new a());
        Intrinsics.checkNotNullParameter(boxSelectHelper, "boxSelectHelper");
        Intrinsics.checkNotNullParameter(mNodeCallback, "mNodeCallback");
        Intrinsics.checkNotNullParameter(mDragHost, "mDragHost");
        this.boxSelectHelper = boxSelectHelper;
        this.mNodeCallback = mNodeCallback;
        this.mDragHost = mDragHost;
        this.mUIDataList = new ArrayList();
    }

    private final void m0(final int position) {
        if (position >= 0 && position < getNUM_BACKGOURND_ICON()) {
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.mInboxListView;
            if (overScrollRecyclerViewWithHeaderFooter != null) {
                RecyclerView.LayoutManager layoutManager = overScrollRecyclerViewWithHeaderFooter.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (position > findFirstVisibleItemPosition && position < findLastVisibleItemPosition) {
                    return;
                }
                overScrollRecyclerViewWithHeaderFooter.postDelayed(new Runnable() { // from class: li1.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.n0(LinearLayoutManager.this, position);
                    }
                }, 200L);
                return;
            }
            return;
        }
        QLog.e("GuildInboxC2CAdapterV2", 4, "scrollToTargetPos err pos: " + position);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(LinearLayoutManager layoutManager, int i3) {
        Intrinsics.checkNotNullParameter(layoutManager, "$layoutManager");
        layoutManager.scrollToPosition(i3);
        if (QLog.isColorLevel()) {
            QLog.i("GuildInboxC2CAdapterV2", 2, "scrollToTargetPos pos:" + i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).f226295d;
    }

    public final void j0() {
        String str;
        String selKey = this.boxSelectHelper.getMSelItem().getSelKey();
        int size = this.mUIDataList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            p pVar = this.mUIDataList.get(i3);
            if (pVar != null) {
                str = pVar.f226296e;
            } else {
                str = null;
            }
            if (TextUtils.equals(str, selKey)) {
                m0(i3);
                break;
            }
            i3++;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildInboxC2CAdapterV2", 2, "jumpToCurSelInboxItem but no targetPos");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull d holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        p item = getItem(position);
        QLog.d("GuildInboxC2CAdapterV2", 4, "onBindViewHolder pos: ", Integer.valueOf(position), " data: ", item);
        long uptimeMillis = SystemClock.uptimeMillis();
        holder.t(item);
        QLog.d("GuildInboxC2CAdapterV2", 4, "onBindViewHolder pos: ", Integer.valueOf(position), " cost: ", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), "ms");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.euo, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026_c2c_item, parent, false)");
        d dVar = new d(inflate, this.mNodeCallback, this.mDragHost);
        dVar.E(true);
        return dVar;
    }

    public final void o0(@NotNull OverScrollRecyclerViewWithHeaderFooter inboxListView) {
        Intrinsics.checkNotNullParameter(inboxListView, "inboxListView");
        this.mInboxListView = inboxListView;
    }

    public final void p0(@NotNull List<? extends p> uiDataList, @Nullable Runnable runnable) {
        Intrinsics.checkNotNullParameter(uiDataList, "uiDataList");
        this.mUIDataList = uiDataList;
        submitList(uiDataList, runnable);
        VideoReport.traversePage(this.mInboxListView);
    }
}
