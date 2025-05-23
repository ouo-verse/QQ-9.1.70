package com.tencent.mobileqq.reminder.chats.notifycard.rv;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0016J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0014\u0010\u0015\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014J\u0016\u0010\u0017\u001a\u00020\r2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/NotifyGuestUserItemVH;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/a;", "Lcom/tencent/mobileqq/reminder/chats/notifycard/model/d;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "vh", "position", "", "i0", "data", "", "isChecked", "k0", "l0", "", "setData", "listener", "m0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "mData", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/reminder/chats/notifycard/rv/a;", "mItemListener", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends RecyclerView.Adapter<NotifyGuestUserItemVH> implements a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> mItemListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.reminder.chats.notifycard.model.d> mData;

    public b() {
        List<com.tencent.mobileqq.reminder.chats.notifycard.model.d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.mData = emptyList;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mData.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull NotifyGuestUserItemVH vh5, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) vh5, position);
        } else {
            Intrinsics.checkNotNullParameter(vh5, "vh");
            vh5.p(this.mData.get(position), position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public NotifyGuestUserItemVH onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (NotifyGuestUserItemVH) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        NotifyGuestUserItemVH a16 = NotifyGuestUserItemVH.INSTANCE.a(parent);
        a16.r(this);
        return a16;
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.rv.a
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void g0(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.d data, int position, boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, data, Integer.valueOf(position), Boolean.valueOf(isChecked));
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> aVar = this.mItemListener;
        if (aVar != null) {
            aVar.g0(data, position, isChecked);
        }
    }

    @Override // com.tencent.mobileqq.reminder.chats.notifycard.rv.a
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void L(@NotNull com.tencent.mobileqq.reminder.chats.notifycard.model.d data, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) data, position);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> aVar = this.mItemListener;
        if (aVar != null) {
            aVar.L(data, position);
        }
    }

    public final void m0(@Nullable a<com.tencent.mobileqq.reminder.chats.notifycard.model.d> listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) listener);
        } else {
            this.mItemListener = listener;
        }
    }

    public final void setData(@NotNull List<com.tencent.mobileqq.reminder.chats.notifycard.model.d> data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            this.mData = data;
        }
    }
}
