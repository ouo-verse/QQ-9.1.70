package ke1;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\u0018\u001a\u00020\t2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\""}, d2 = {"Lke1/a;", "Lje1/a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/qqnt/chats/core/adapter/holder/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "k1", "Landroid/view/View;", "child", "", "m1", "Landroid/widget/FrameLayout;", "j1", "", "originalList", "l1", "", "viewType", "L0", "view", "i1", "list", "", "isGuild", "S0", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "gameCardView", "Lcom/tencent/qqnt/chats/core/data/a;", "mBuilder", "<init>", "(Lcom/tencent/qqnt/chats/core/data/a;)V", "T", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends je1.a {

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private View gameCardView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.qqnt.chats.core.data.a mBuilder) {
        super(mBuilder);
        Intrinsics.checkNotNullParameter(mBuilder, "mBuilder");
    }

    private final FrameLayout j1(ViewGroup parent) {
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return frameLayout;
    }

    private final com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> k1(ViewGroup parent) {
        ViewGroup viewGroup;
        View view = this.gameCardView;
        if (view == null) {
            view = j1(parent);
        }
        this.gameCardView = view;
        Intrinsics.checkNotNull(view);
        ViewParent parent2 = view.getParent();
        if (parent2 instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent2;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            View view2 = this.gameCardView;
            Intrinsics.checkNotNull(view2);
            m1(viewGroup, view2);
        }
        View view3 = this.gameCardView;
        Intrinsics.checkNotNull(view3);
        return new k(view3);
    }

    private final List<com.tencent.qqnt.chats.core.adapter.itemdata.b> l1(List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> originalList) {
        List<com.tencent.qqnt.chats.core.adapter.itemdata.b> mutableList;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (Object obj : originalList) {
            if (((com.tencent.qqnt.chats.core.adapter.itemdata.b) obj).e() == -5) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                arrayList.add(obj);
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        if (this.gameCardView != null) {
            mutableList.add(Math.min(5, mutableList.size()), j.f412121c);
        }
        return mutableList;
    }

    private final void m1(ViewGroup parent, View child) {
        try {
            parent.removeView(child);
            parent.endViewTransition(child);
            child.clearAnimation();
        } catch (Throwable th5) {
            QLog.e("GameBoxChatsListAdapter", 1, "removeViewFromParent error:", th5);
        }
    }

    @Override // com.tencent.qqnt.chats.core.adapter.ChatsListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: L0 */
    public com.tencent.qqnt.chats.core.adapter.holder.b<com.tencent.qqnt.chats.core.adapter.itemdata.b> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType == -5) {
            return k1(parent);
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override // com.tencent.qqnt.chats.core.adapter.ChatsListAdapter
    public void S0(@Nullable List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> list, boolean isGuild) {
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        super.S0(l1(list), isGuild);
    }

    @Override // je1.a
    public void i1(@Nullable View view) {
        this.gameCardView = view;
        submitList(z0());
    }
}
