package com.tencent.mobileqq.qqlive.sail.ui.more;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.more.g;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.room.bottombtn.RedPointIconView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/g;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$a;", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$b;", "listener", "", "k0", "", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/h;", "newData", "setData", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "i0", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "data", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$b;", "<init>", "()V", "a", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g extends RecyclerView.Adapter<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private b listener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<h> data;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "o", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/h;", "btn", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$b;", "E", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$b;", "listener", "Lcom/tencent/timi/game/liveroom/impl/room/bottombtn/RedPointIconView;", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/liveroom/impl/room/bottombtn/RedPointIconView;", "icon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "name", "H", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/h;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$b;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private final b listener;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private RedPointIconView icon;

        /* renamed from: G, reason: from kotlin metadata */
        @Nullable
        private TextView name;

        /* renamed from: H, reason: from kotlin metadata */
        @Nullable
        private h btn;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView, @Nullable b bVar) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) bVar);
                return;
            }
            this.listener = bVar;
            this.name = (TextView) itemView.findViewById(R.id.t_b);
            this.icon = (RedPointIconView) itemView.findViewById(R.id.t_a);
            itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g.a.m(g.a.this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(a this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            b bVar = this$0.listener;
            if (bVar != null) {
                bVar.Y6(this$0.btn);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        private final void o() {
            boolean isBlank;
            String str;
            h hVar = this.btn;
            if (hVar != null) {
                QQLiveDaTongParams qQLiveDaTongParams = new QQLiveDaTongParams();
                qQLiveDaTongParams.R("em_qqlive_morefunction_entrance");
                qQLiveDaTongParams.u(hVar.e());
                isBlank = StringsKt__StringsJVMKt.isBlank(hVar.d());
                if (!isBlank) {
                    str = "em_qqlive_commercial";
                } else {
                    int f16 = hVar.f();
                    if (f16 == R.string.zfu) {
                        str = "em_qqlive_share";
                    } else if (f16 == R.string.zfp) {
                        str = "em_qqlive_clarity_change";
                    } else {
                        str = "";
                    }
                }
                String str2 = str;
                com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                com.tencent.mobileqq.qqlive.sail.report.a.c(aVar, itemView, str2, qQLiveDaTongParams.a(), false, null, 24, null);
            }
        }

        public final void n(@NotNull h btn) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) btn);
                return;
            }
            Intrinsics.checkNotNullParameter(btn, "btn");
            this.btn = btn;
            if (btn.f() > 0) {
                TextView textView = this.name;
                if (textView != null) {
                    Context context = this.itemView.getContext();
                    if (context != null) {
                        str = context.getString(btn.f());
                    } else {
                        str = null;
                    }
                    textView.setText(str);
                }
            } else {
                TextView textView2 = this.name;
                if (textView2 != null) {
                    textView2.setText(btn.e());
                }
            }
            if (btn.b() > 0) {
                RedPointIconView redPointIconView = this.icon;
                if (redPointIconView != null) {
                    redPointIconView.A0(true, btn.b(), false);
                }
            } else {
                RedPointIconView redPointIconView2 = this.icon;
                if (redPointIconView2 != null) {
                    redPointIconView2.B0(true, btn.c(), false);
                }
            }
            o();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/g$b;", "", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/h;", "btn", "", "Y6", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void Y6(@Nullable h btn);
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.data = new ArrayList();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
        } else {
            Intrinsics.checkNotNullParameter(holder, "holder");
            holder.n(this.data.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.htl, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new a(itemView, this.listener);
    }

    public final void k0(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void setData(@NotNull List<h> newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.data.clear();
        this.data.addAll(newData);
        notifyDataSetChanged();
    }
}
