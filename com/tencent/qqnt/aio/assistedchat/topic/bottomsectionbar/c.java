package com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.AssistedChatMsgIntent;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.assistedchat.topic.mvi.a;
import com.tencent.qqnt.aio.utils.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0002\u0015\tB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/topic/bottomsectionbar/c;", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "recommend", "", "", "p", "", "c", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", "holder", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/model/a;", "model", "", "f", "<init>", "()V", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c extends com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/topic/bottomsectionbar/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lp81/d;", "E", "Lp81/d;", "l", "()Lp81/d;", "binding", "<init>", "(Lp81/d;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final p81.d binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull p81.d binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) binding);
                return;
            }
            this.binding = binding;
            int b16 = l.b(5);
            AIOUtil.f194084a.e(binding.f425725e, b16, b16, b16, b16);
            TextView textView = binding.f425725e;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.showMore");
            xu3.b.b(textView);
        }

        @NotNull
        public final p81.d l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (p81.d) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/topic/bottomsectionbar/c$b;", "", "", "ELEM_ID_MORE_BTN", "Ljava/lang/String;", "ELEM_ID_RECOMMEND_TOPIC", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.c$b, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60099);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, String> p(com.tencent.qqnt.aio.assistedchat.model.c recommend) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("relation_content", recommend.a()), TuplesKt.to("recom_trace_id", recommend.e()));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(RecyclerView.ViewHolder holder, c this$0, com.tencent.qqnt.aio.assistedchat.model.c recommend, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recommend, "$recommend");
        a aVar = (a) holder;
        CharSequence text = aVar.l().f425724d.getText();
        if (text != null && text.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this$0.k(a.C9465a.f349463d);
            AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
            ConstraintLayout root = aVar.l().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "holder.binding.root");
            assistedChatPanelDtReporter.a("em_kl_temporary_topic_recommend", root, this$0.p(recommend));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(c this$0, RecyclerView.ViewHolder holder, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.j(new AssistedChatMsgIntent.ShowAssistedChatPanelIntent("bottom_bar_topic", 1));
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        TextView textView = ((a) holder).l().f425725e;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.showMore");
        AssistedChatPanelDtReporter.b(assistedChatPanelDtReporter, "em_kl_temporary_topic_recommend_more", textView, null, 4, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 7;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    public void f(@NotNull final RecyclerView.ViewHolder holder, @NotNull com.tencent.qqnt.aio.bottombar.sectionbar.model.a model) {
        final com.tencent.qqnt.aio.assistedchat.model.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) holder, (Object) model);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(model, "model");
        if (!(holder instanceof a)) {
            return;
        }
        ((a) holder).l().getRoot().setBackground(com.tencent.qqnt.aio.bottombar.sectionbar.viewholder.a.INSTANCE.a(ContextCompat.getColorStateList(holder.itemView.getContext(), R.color.qui_common_fill_light_secondary), ContextCompat.getColorStateList(holder.itemView.getContext(), R.color.qui_common_overlay_standard_primary)));
        Object a16 = model.a();
        if (a16 instanceof com.tencent.qqnt.aio.assistedchat.model.c) {
            cVar = (com.tencent.qqnt.aio.assistedchat.model.c) a16;
        } else {
            cVar = null;
        }
        if (cVar == null) {
            return;
        }
        a aVar = (a) holder;
        aVar.l().f425724d.setText(cVar.a());
        aVar.l().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.q(RecyclerView.ViewHolder.this, this, cVar, view);
            }
        });
        aVar.l().f425725e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.topic.bottomsectionbar.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.r(c.this, holder, view);
            }
        });
        AssistedChatPanelDtReporter assistedChatPanelDtReporter = AssistedChatPanelDtReporter.f349138a;
        ConstraintLayout root = aVar.l().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "holder.binding.root");
        assistedChatPanelDtReporter.c("em_kl_temporary_topic_recommend", root, p(cVar));
        TextView textView = aVar.l().f425725e;
        Intrinsics.checkNotNullExpressionValue(textView, "holder.binding.showMore");
        AssistedChatPanelDtReporter.d(assistedChatPanelDtReporter, "em_kl_temporary_topic_recommend_more", textView, null, 4, null);
    }

    @Override // com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b
    @NotNull
    public RecyclerView.ViewHolder g(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        p81.d g16 = p81.d.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026      false\n            )");
        return new a(g16);
    }
}
