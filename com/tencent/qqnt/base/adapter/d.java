package com.tencent.qqnt.base.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.base.adapter.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u000f\u0012\u0006\u0010\u0013\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00028\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/base/adapter/d;", "Lcom/tencent/qqnt/base/adapter/b;", "Item", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "l", "(Lcom/tencent/qqnt/base/adapter/b;)V", "", "", "payloads", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/qqnt/base/adapter/b;Ljava/util/List;)V", "E", "Landroidx/viewbinding/ViewBinding;", "o", "()Landroidx/viewbinding/ViewBinding;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "ntui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class d<Item extends b, VB extends ViewBinding> extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final VB binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull VB binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding);
        } else {
            this.binding = binding;
        }
    }

    public abstract void l(@NotNull Item item);

    public void m(@NotNull Item item, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (payloads.isEmpty()) {
            l(item);
        }
    }

    @NotNull
    public final VB o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VB) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.binding;
    }
}
