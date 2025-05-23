package com.tencent.mobileqq.troop.teamup.publish;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\u0004\b\u0001\u0010\u00032\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004B=\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014\u0012\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e0\u001c\u00a2\u0006\u0004\b\u001f\u0010 J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u001e\u0010\u000f\u001a\u00020\u000e2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\r\u001a\u00020\bH\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/a;", "Landroid/view/View;", "V", "D", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/teamup/publish/b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "Ljava/lang/Class;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Class;", "viewClass", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "Lkotlin/Function2;", "Lkotlin/jvm/functions/Function2;", "binder", "<init>", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a<V extends View, D> extends RecyclerView.Adapter<b<V>> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private List<? extends D> data;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function2<V, D, Unit> binder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<V> viewClass;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Class<V> viewClass, @NotNull List<? extends D> data, @NotNull Function2<? super V, ? super D, Unit> binder) {
        Intrinsics.checkNotNullParameter(viewClass, "viewClass");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(binder, "binder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, viewClass, data, binder);
            return;
        }
        this.viewClass = viewClass;
        this.data = data;
        this.binder = binder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull b<V> holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            this.binder.invoke(holder.getView(), this.data.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public b<V> onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (b) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        V newInstance = this.viewClass.getConstructor(Context.class).newInstance(parent.getContext());
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type V of com.tencent.mobileqq.troop.teamup.publish.NormalAdapter");
        return new b<>(newInstance);
    }
}
