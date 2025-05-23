package com.tencent.qqnt.chathistory.ui.date.adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chathistory.util.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\b\u0000\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B?\u00126\u0010\u001a\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\n0\u0011\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u0005H\u0017J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0014\u0010\u0010\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rRD\u0010\u001a\u001a2\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\n0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/chathistory/ui/date/adapter/b;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "l0", "holder", "position", "", "k0", "getItemCount", "", "Lcom/tencent/qqnt/chathistory/ui/date/data/model/b;", "newData", "m0", "Lkotlin/Function2;", "Lcom/tencent/qqnt/datepicker/b;", "Lkotlin/ParameterName;", "name", "dateParam", "Landroid/view/View;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function2;", "listener", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "datas", "D", "Lcom/tencent/qqnt/datepicker/b;", "dateMonthParam", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "E", "a", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends RecyclerView.Adapter<com.tencent.qqnt.chathistory.ui.date.adapter.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chathistory.ui.date.data.model.b> datas;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.datepicker.b dateMonthParam;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function2<com.tencent.qqnt.datepicker.b, View, Unit> listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/date/adapter/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chathistory.ui.date.adapter.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/chathistory/ui/date/adapter/a$b", "Lcom/tencent/qqnt/datepicker/a;", "Lcom/tencent/qqnt/datepicker/b;", "param", "", "c", "a", "", "b", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.qqnt.datepicker.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.chathistory.ui.date.adapter.b f353393b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.chathistory.ui.date.data.model.b f353394c;

        b(com.tencent.qqnt.chathistory.ui.date.adapter.b bVar, com.tencent.qqnt.chathistory.ui.date.data.model.b bVar2) {
            this.f353393b = bVar;
            this.f353394c = bVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, bVar, bVar2);
            }
        }

        @Override // com.tencent.qqnt.datepicker.a
        @NotNull
        public com.tencent.qqnt.datepicker.b a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.datepicker.b) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            if (this.f353394c.f().a() != null) {
                return com.tencent.qqnt.datepicker.b.INSTANCE.a(this.f353394c.f().c(), this.f353394c.f().b(), this.f353394c.f().a().intValue());
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        @Override // com.tencent.qqnt.datepicker.a
        public boolean b(@NotNull com.tencent.qqnt.datepicker.b param) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) param)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(param, "param");
            return this.f353394c.g().get(param.a()).booleanValue();
        }

        @Override // com.tencent.qqnt.datepicker.a
        public void c(@NotNull com.tencent.qqnt.datepicker.b param) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
                return;
            }
            Intrinsics.checkNotNullParameter(param, "param");
            a.this.dateMonthParam = param;
            com.tencent.qqnt.datepicker.utils.a.f355927a.a("HistoryDateAdapter", "onDateSelected " + param);
            a.this.notifyDataSetChanged();
            a.this.listener.invoke(param, this.f353393b.m());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function2<? super com.tencent.qqnt.datepicker.b, ? super View, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
            this.datas = new ArrayList();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.datas.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"UseCompatLoadingForColorStateLists"})
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull com.tencent.qqnt.chathistory.ui.date.adapter.b holder, @SuppressLint({"RecyclerView"}) int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.qqnt.chathistory.ui.date.data.model.b bVar = this.datas.get(position);
        d.f354054a.a("HistoryDateAdapter", "year " + bVar.h().c() + " month " + bVar.h().b() + " ");
        holder.m().setData(bVar.h().c(), bVar.h().b(), new b(holder, bVar), this.dateMonthParam);
        holder.o().setText(String.valueOf(bVar.h().b()));
        if (bVar.h().c() == Calendar.getInstance().get(1)) {
            holder.l().setEnabled(true);
            holder.p().setText("\u6708");
            holder.p().setTextColor(BaseApplication.getContext().getResources().getColorStateList(R.color.qui_common_text_primary));
            holder.o().setTextColor(BaseApplication.getContext().getResources().getColorStateList(R.color.qui_common_text_primary));
            return;
        }
        holder.p().setText("\u6708/" + bVar.h().c() + "\u5e74");
        holder.l().setEnabled(false);
        holder.p().setTextColor(BaseApplication.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
        holder.o().setTextColor(BaseApplication.getContext().getResources().getColorStateList(R.color.qui_common_text_secondary));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public com.tencent.qqnt.chathistory.ui.date.adapter.b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chathistory.ui.date.adapter.b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = View.inflate(parent.getContext(), R.layout.dr_, null);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new com.tencent.qqnt.chathistory.ui.date.adapter.b(itemView);
    }

    public final void m0(@NotNull Collection<com.tencent.qqnt.chathistory.ui.date.data.model.b> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.datas.clear();
        this.datas.addAll(newData);
        notifyDataSetChanged();
    }
}
