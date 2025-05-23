package com.tencent.mobileqq.qwallet.home.grid;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppGroup;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0017\u0018B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/a;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", "Lcom/tencent/mobileqq/qwallet/home/grid/a$c;", "", "groupList", "", "submitList", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "twoLineTitleMode", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a extends ListAdapter<QWalletHomePage$AppGroup, c> {

    @NotNull
    private static final C8467a D = new C8467a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean twoLineTitleMode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/home/grid/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", "oldItem", "newItem", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.grid.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8467a extends DiffUtil.ItemCallback<QWalletHomePage$AppGroup> {
        C8467a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull QWalletHomePage$AppGroup oldItem, @NotNull QWalletHomePage$AppGroup newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!c4.a.m(oldItem, newItem)) {
                return false;
            }
            List<QWalletHomePage$AppInfo> list = oldItem.apps.get();
            Intrinsics.checkNotNullExpressionValue(list, "oldItem.apps.get()");
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                QWalletHomePage$AppInfo appInfo = (QWalletHomePage$AppInfo) obj;
                Intrinsics.checkNotNullExpressionValue(appInfo, "appInfo");
                QWalletHomePage$AppInfo qWalletHomePage$AppInfo = newItem.apps.get().get(i3);
                Intrinsics.checkNotNullExpressionValue(qWalletHomePage$AppInfo, "newItem.apps.get()[index]");
                if (!c4.a.j(appInfo, qWalletHomePage$AppInfo)) {
                    return false;
                }
                i3 = i16;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull QWalletHomePage$AppGroup oldItem, @NotNull QWalletHomePage$AppGroup newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (!c4.a.m(oldItem, newItem)) {
                return false;
            }
            List<QWalletHomePage$AppInfo> list = oldItem.apps.get();
            Intrinsics.checkNotNullExpressionValue(list, "oldItem.apps.get()");
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                QWalletHomePage$AppInfo appInfo = (QWalletHomePage$AppInfo) obj;
                Intrinsics.checkNotNullExpressionValue(appInfo, "appInfo");
                QWalletHomePage$AppInfo qWalletHomePage$AppInfo = newItem.apps.get().get(i3);
                Intrinsics.checkNotNullExpressionValue(qWalletHomePage$AppInfo, "newItem.apps.get()[index]");
                if (!c4.a.n(appInfo, qWalletHomePage$AppInfo)) {
                    return false;
                }
                i3 = i16;
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0018\u001a\n \u0011*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n \u0011*\u0004\u0018\u00010\u00190\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/grid/a$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppGroup;", "appGroup", "", "l", "", "isLastItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "root", UserInfo.SEX_FEMALE, "Z", "twoLineTitleMode", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "G", "Landroid/widget/TextView;", "titleView", "Landroidx/recyclerview/widget/RecyclerView;", "H", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/View;", "I", "Landroid/view/View;", "divider", "<init>", "(Landroid/view/ViewGroup;Z)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final ViewGroup root;

        /* renamed from: F, reason: from kotlin metadata */
        private final boolean twoLineTitleMode;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView titleView;

        /* renamed from: H, reason: from kotlin metadata */
        private final RecyclerView recyclerView;

        /* renamed from: I, reason: from kotlin metadata */
        private final View divider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull ViewGroup root, boolean z16) {
            super(root);
            Intrinsics.checkNotNullParameter(root, "root");
            this.root = root;
            this.twoLineTitleMode = z16;
            this.titleView = (TextView) root.findViewById(R.id.stj);
            this.recyclerView = (RecyclerView) root.findViewById(R.id.stk);
            this.divider = root.findViewById(R.id.sth);
        }

        private final void l(QWalletHomePage$AppGroup appGroup) {
            List<QWalletHomePage$AppInfo> list = appGroup.apps.get();
            Intrinsics.checkNotNullExpressionValue(list, "appGroup.apps.get()");
            for (QWalletHomePage$AppInfo qWalletHomePage$AppInfo : list) {
                if (c4.a.u(qWalletHomePage$AppInfo)) {
                    c4.a.y(qWalletHomePage$AppInfo, "index.tuijian.show", "1", 0, 4, null);
                }
            }
        }

        public final void m(@NotNull QWalletHomePage$AppGroup appGroup, boolean isLastItem) {
            boolean z16;
            Intrinsics.checkNotNullParameter(appGroup, "appGroup");
            String str = appGroup.title.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                this.titleView.setVisibility(0);
                this.titleView.setText(appGroup.title.get());
                ol2.b.f(this.titleView, 15, false, 4, null);
            } else {
                this.titleView.setVisibility(8);
            }
            this.recyclerView.setClipChildren(false);
            GridAppRvAdapter gridAppRvAdapter = new GridAppRvAdapter(this.twoLineTitleMode, true);
            this.recyclerView.setAdapter(gridAppRvAdapter);
            this.recyclerView.setLayoutManager(new GridLayoutManager(this.root.getContext(), 4));
            gridAppRvAdapter.submitList(appGroup.apps.get());
            if (isLastItem) {
                this.divider.setVisibility(8);
            } else {
                this.divider.setVisibility(0);
            }
            if (QQTheme.isNowThemeIsNight()) {
                this.divider.setBackgroundColor(Color.parseColor("#0F1113"));
            } else {
                this.divider.setBackgroundColor(Color.parseColor("#F5F5F5"));
            }
            l(appGroup);
        }
    }

    public a() {
        super(D);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        QWalletHomePage$AppGroup item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        QWalletHomePage$AppGroup qWalletHomePage$AppGroup = item;
        boolean z16 = true;
        if (position != getNUM_BACKGOURND_ICON() - 1) {
            z16 = false;
        }
        holder.m(qWalletHomePage$AppGroup, z16);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.hih, parent, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return new c((ViewGroup) inflate, this.twoLineTitleMode);
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<QWalletHomePage$AppGroup> groupList) {
        ArrayList arrayList;
        boolean z16;
        boolean z17;
        if (ol2.a.c()) {
            if (groupList != null) {
                arrayList = new ArrayList();
                Iterator<T> it = groupList.iterator();
                while (it.hasNext()) {
                    List<QWalletHomePage$AppInfo> list = ((QWalletHomePage$AppGroup) it.next()).apps.get();
                    Intrinsics.checkNotNullExpressionValue(list, "it.apps.get()");
                    CollectionsKt__MutableCollectionsKt.addAll(arrayList, list);
                }
            } else {
                arrayList = null;
            }
            boolean z18 = false;
            if (arrayList != null) {
                ArrayList arrayList2 = arrayList;
                if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        if (((QWalletHomePage$AppInfo) it5.next()).name.get().length() > 4) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            z17 = true;
                            break;
                        }
                    }
                }
                z17 = false;
                if (z17) {
                    z18 = true;
                }
            }
            this.twoLineTitleMode = z18;
        }
        super.submitList(groupList);
    }
}
