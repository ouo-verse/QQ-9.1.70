package com.tencent.mobileqq.zplan.friend;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.friend.a;
import cooperation.qzone.gift.QZoneCheckSendGiftServlet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001f\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/friend/b;", "Lcom/tencent/mobileqq/zplan/friend/a;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "", "Lcom/tencent/mobileqq/zplan/friend/c;", QZoneCheckSendGiftServlet.PARAM_FRINED_LIST, "", "k0", "l0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "", "getItemCount", "holder", "position", "j0", "(Lcom/tencent/mobileqq/zplan/friend/a;I)V", "Lcom/tencent/mobileqq/zplan/friend/e;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zplan/friend/e;", "binder", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "i0", "()Ljava/util/List;", "setFriendList", "(Ljava/util/List;)V", "<init>", "(Lcom/tencent/mobileqq/zplan/friend/e;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class b<T extends a> extends RecyclerView.Adapter<T> {

    /* renamed from: C, reason: from kotlin metadata */
    private List<FriendInfo> friendList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final e binder;

    public b(e binder) {
        List<FriendInfo> emptyList;
        Intrinsics.checkNotNullParameter(binder, "binder");
        this.binder = binder;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.friendList = emptyList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.friendList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<FriendInfo> i0() {
        return this.friendList;
    }

    public void j0(T holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.binder.c(this.friendList.get(position), holder);
    }

    public final void k0(List<FriendInfo> friendList) {
        Intrinsics.checkNotNullParameter(friendList, "friendList");
        this.friendList = friendList;
        notifyDataSetChanged();
    }

    public final void l0(List<FriendInfo> friendList) {
        Intrinsics.checkNotNullParameter(friendList, "friendList");
        List<FriendInfo> list = this.friendList;
        this.friendList = friendList;
        if (!list.isEmpty() && !this.friendList.isEmpty()) {
            DiffUtil.calculateDiff(new h(list, friendList)).dispatchUpdatesTo(this);
        } else {
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.binder.b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.binder.d();
    }
}
