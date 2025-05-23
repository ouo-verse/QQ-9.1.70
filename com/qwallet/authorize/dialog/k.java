package com.qwallet.authorize.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import com.qwallet.authorize.AuthorizePhoneData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002'(B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0016J\u0006\u0010\u0011\u001a\u00020\fJ\"\u0010\u0010\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/qwallet/authorize/dialog/k;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "Lcom/qwallet/authorize/dialog/l;", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "o0", "holder", "position", "", "m0", "", "list", "submitList", "j0", "Ljava/lang/Runnable;", "commitCallback", "l0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "getSelectPhone", "()I", "p0", "(I)V", "selectPhone", "Lcom/qwallet/authorize/dialog/k$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qwallet/authorize/dialog/k$c;", "getSelectedPhoneCallback", "()Lcom/qwallet/authorize/dialog/k$c;", "q0", "(Lcom/qwallet/authorize/dialog/k$c;)V", "selectedPhoneCallback", "<init>", "()V", "D", "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class k extends ListAdapter<AuthorizePhoneData, l> {

    @NotNull
    private static final a E = new a();

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c selectedPhoneCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int selectPhone;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/qwallet/authorize/dialog/k$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qwallet/authorize/AuthorizePhoneData;", "oldItem", "newItem", "", "b", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class a extends DiffUtil.ItemCallback<AuthorizePhoneData> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull AuthorizePhoneData oldItem, @NotNull AuthorizePhoneData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull AuthorizePhoneData oldItem, @NotNull AuthorizePhoneData newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem == newItem) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/qwallet/authorize/dialog/k$c;", "", "Lcom/qwallet/authorize/AuthorizePhoneData;", "authorPhoneData", "", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public interface c {
        void a(@Nullable AuthorizePhoneData authorPhoneData);
    }

    public k() {
        super(E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(k this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.selectPhone = i3;
        this$0.j0();
        this$0.notifyDataSetChanged();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void j0() {
        c cVar = this.selectedPhoneCallback;
        if (cVar != null) {
            cVar.a(l0());
        }
    }

    @Nullable
    public final AuthorizePhoneData k0() {
        if (getCurrentList().isEmpty() || this.selectPhone >= getCurrentList().size() || this.selectPhone < 0) {
            return null;
        }
        return getCurrentList().get(this.selectPhone);
    }

    @Nullable
    public final AuthorizePhoneData l0() {
        List<AuthorizePhoneData> currentList = getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "currentList");
        if (!currentList.isEmpty()) {
            int size = currentList.size();
            int i3 = this.selectPhone;
            if (size > i3) {
                return currentList.get(i3);
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull l holder, final int position) {
        boolean z16;
        Intrinsics.checkNotNullParameter(holder, "holder");
        AuthorizePhoneData item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        AuthorizePhoneData authorizePhoneData = item;
        if (position == this.selectPhone) {
            z16 = true;
        } else {
            z16 = false;
        }
        holder.l(authorizePhoneData, z16);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k.n0(k.this, position, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public l onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hhx, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new l(view);
    }

    public final void p0(int i3) {
        this.selectPhone = i3;
    }

    public final void q0(@Nullable c cVar) {
        this.selectedPhoneCallback = cVar;
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<AuthorizePhoneData> list) {
        List<AuthorizePhoneData> list2 = list;
        this.selectPhone = list2 == null || list2.isEmpty() ? 0 : RangesKt___RangesKt.coerceIn(this.selectPhone, 0, list.size() - 1);
        super.submitList(list);
        j0();
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<AuthorizePhoneData> list, @Nullable Runnable commitCallback) {
        List<AuthorizePhoneData> list2 = list;
        this.selectPhone = list2 == null || list2.isEmpty() ? 0 : RangesKt___RangesKt.coerceIn(this.selectPhone, 0, list.size() - 1);
        super.submitList(list, commitCallback);
        j0();
    }
}
