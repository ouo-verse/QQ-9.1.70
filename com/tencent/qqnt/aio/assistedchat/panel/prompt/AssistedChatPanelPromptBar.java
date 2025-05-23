package com.tencent.qqnt.aio.assistedchat.panel.prompt;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.report.EmotionDaTongReportUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.panel.AssistedChatPanelDtReporter;
import com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPanelPromptBar;
import com.tencent.qqnt.aio.assistedchat.panel.prompt.b;
import com.tencent.qqnt.aio.utils.l;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002#\u0016B%\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R2\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar;", "Landroid/widget/LinearLayout;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "dataList", "", "setData", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "labelTv", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$PromptBarAdapter;", "e", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$PromptBarAdapter;", "promptBarAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlin/Function1;", h.F, "Lkotlin/jvm/functions/Function1;", "a", "()Lkotlin/jvm/functions/Function1;", "setOnPromptSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "onPromptSelectedListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PromptBarAdapter", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPanelPromptBar extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView labelTv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PromptBarAdapter promptBarAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.aio.assistedchat.model.a, Unit> onPromptSelectedListener;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0010\u00a2\u0006\u0004\b$\u0010%J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016R$\u0010\u0014\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R)\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00040\u00040\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c*\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$PromptBarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/b;", "", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$a;", "dataList", "", "setData", "", "getItemCount", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "position", "o0", "holder", "m0", "Lkotlin/Function1;", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "onPromptClickListener", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "j0", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "", "", "k0", "()Ljava/util/Map;", "refreshReportParam", "l0", "(Lcom/tencent/qqnt/aio/assistedchat/model/a;)Ljava/util/Map;", "reportParam", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class PromptBarAdapter extends RecyclerView.Adapter<com.tencent.qqnt.aio.assistedchat.panel.prompt.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final Lazy differ;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final Function1<com.tencent.qqnt.aio.assistedchat.model.a, Unit> onPromptClickListener;

        /* JADX WARN: Multi-variable type inference failed */
        public PromptBarAdapter(@Nullable Function1<? super com.tencent.qqnt.aio.assistedchat.model.a, Unit> function1) {
            Lazy lazy;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) function1);
                return;
            }
            this.onPromptClickListener = function1;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AsyncListDiffer<a>>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPanelPromptBar$PromptBarAdapter$differ$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$PromptBarAdapter$differ$2$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$a;", "oldItem", "newItem", "", "b", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes23.dex */
                public static final class a extends DiffUtil.ItemCallback<AssistedChatPanelPromptBar.a> {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public boolean areContentsTheSame(@NotNull AssistedChatPanelPromptBar.a oldItem, @NotNull AssistedChatPanelPromptBar.a newItem) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                        }
                        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                        Intrinsics.checkNotNullParameter(newItem, "newItem");
                        return Intrinsics.areEqual(oldItem.a(), newItem.a());
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public boolean areItemsTheSame(@NotNull AssistedChatPanelPromptBar.a oldItem, @NotNull AssistedChatPanelPromptBar.a newItem) {
                        String str;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                        }
                        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                        Intrinsics.checkNotNullParameter(newItem, "newItem");
                        com.tencent.qqnt.aio.assistedchat.model.a a16 = oldItem.a();
                        String str2 = null;
                        if (a16 != null) {
                            str = a16.c();
                        } else {
                            str = null;
                        }
                        com.tencent.qqnt.aio.assistedchat.model.a a17 = newItem.a();
                        if (a17 != null) {
                            str2 = a17.c();
                        }
                        return Intrinsics.areEqual(str, str2);
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPanelPromptBar.PromptBarAdapter.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AsyncListDiffer<AssistedChatPanelPromptBar.a> invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AsyncListDiffer<>(AssistedChatPanelPromptBar.PromptBarAdapter.this, new a()) : (AsyncListDiffer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.differ = lazy;
        }

        private final AsyncListDiffer<a> j0() {
            return (AsyncListDiffer) this.differ.getValue();
        }

        private final Map<String, String> k0() {
            Map<String, String> mapOf;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(EmotionDaTongReportUtil.EM_PARAMS_TAB_TYPE, "2"));
            return mapOf;
        }

        private final Map<String, String> l0(com.tencent.qqnt.aio.assistedchat.model.a aVar) {
            Map<String, String> mapOf;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, aVar.d()));
            return mapOf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n0(PromptBarAdapter this$0, com.tencent.qqnt.aio.assistedchat.model.a aVar, TextView textView, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(textView, "$textView");
            Function1<com.tencent.qqnt.aio.assistedchat.model.a, Unit> function1 = this$0.onPromptClickListener;
            if (function1 != null) {
                function1.invoke(aVar);
            }
            if (aVar == null) {
                AssistedChatPanelDtReporter.f349138a.a("em_kl_refresh", textView, this$0.k0());
            } else {
                AssistedChatPanelDtReporter.f349138a.a("em_kl_agent_style", textView, this$0.l0(aVar));
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return j0().getCurrentList().size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull com.tencent.qqnt.aio.assistedchat.panel.prompt.b holder, int position) {
            final TextView textView;
            Object orNull;
            final com.tencent.qqnt.aio.assistedchat.model.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) holder, position);
                return;
            }
            Intrinsics.checkNotNullParameter(holder, "holder");
            View view = holder.itemView;
            if (view instanceof TextView) {
                textView = (TextView) view;
            } else {
                textView = null;
            }
            if (textView == null) {
                return;
            }
            List<a> currentList = j0().getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "differ.currentList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(currentList, position);
            a aVar2 = (a) orNull;
            if (aVar2 != null) {
                aVar = aVar2.a();
            } else {
                aVar = null;
            }
            if (aVar == null) {
                textView.setText("\u968f\u673a\u6362");
                Drawable drawable = ContextCompat.getDrawable(textView.getContext(), R.drawable.qui_refresh);
                if (drawable != null) {
                    drawable.setBounds(0, 0, l.b(12), l.b(12));
                }
                textView.setCompoundDrawables(drawable, null, null, null);
            } else {
                textView.setText(aVar.b());
                textView.setCompoundDrawables(null, null, null, null);
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.panel.prompt.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AssistedChatPanelPromptBar.PromptBarAdapter.n0(AssistedChatPanelPromptBar.PromptBarAdapter.this, aVar, textView, view2);
                }
            });
            if (aVar == null) {
                AssistedChatPanelDtReporter.f349138a.c("em_kl_refresh", textView, k0());
            } else {
                AssistedChatPanelDtReporter.f349138a.c("em_kl_agent_style", textView, l0(aVar));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: o0, reason: merged with bridge method [inline-methods] */
        public com.tencent.qqnt.aio.assistedchat.panel.prompt.b onCreateViewHolder(@NotNull ViewGroup parent, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (com.tencent.qqnt.aio.assistedchat.panel.prompt.b) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, position);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            b.Companion companion = com.tencent.qqnt.aio.assistedchat.panel.prompt.b.INSTANCE;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new com.tencent.qqnt.aio.assistedchat.panel.prompt.b(companion.a(context));
        }

        public final void setData(@NotNull List<a> dataList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) dataList);
            } else {
                Intrinsics.checkNotNullParameter(dataList, "dataList");
                j0().submitList(dataList);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$a;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "a", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "()Lcom/tencent/qqnt/aio/assistedchat/model/a;", "prompt", "<init>", "(Lcom/tencent/qqnt/aio/assistedchat/model/a;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final com.tencent.qqnt.aio.assistedchat.model.a prompt;

        public a() {
            this(null, 1, 0 == true ? 1 : 0);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Nullable
        public final com.tencent.qqnt.aio.assistedchat.model.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.aio.assistedchat.model.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.prompt;
        }

        public a(@Nullable com.tencent.qqnt.aio.assistedchat.model.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.prompt = aVar;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            }
        }

        public /* synthetic */ a(com.tencent.qqnt.aio.assistedchat.model.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : aVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/prompt/AssistedChatPanelPromptBar$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.set(0, 0, l.b(8), 0);
        }
    }

    public /* synthetic */ AssistedChatPanelPromptBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    @Nullable
    public final Function1<com.tencent.qqnt.aio.assistedchat.model.a, Unit> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Function1) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.onPromptSelectedListener;
    }

    public final void setData(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.a> dataList) {
        List<a> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dataList);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new a(null));
        Iterator<T> it = dataList.iterator();
        while (it.hasNext()) {
            mutableListOf.add(new a((com.tencent.qqnt.aio.assistedchat.model.a) it.next()));
        }
        this.promptBarAdapter.setData(mutableListOf);
    }

    public final void setOnPromptSelectedListener(@Nullable Function1<? super com.tencent.qqnt.aio.assistedchat.model.a, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) function1);
        } else {
            this.onPromptSelectedListener = function1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatPanelPromptBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = l.b(16);
        layoutParams.rightMargin = l.b(8);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(12.0f);
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        textView.setText("\u8c03\u6574\u98ce\u683c:");
        this.labelTv = textView;
        PromptBarAdapter promptBarAdapter = new PromptBarAdapter(new Function1<com.tencent.qqnt.aio.assistedchat.model.a, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.prompt.AssistedChatPanelPromptBar$promptBarAdapter$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatPanelPromptBar.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.aio.assistedchat.model.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.qqnt.aio.assistedchat.model.a aVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVar);
                    return;
                }
                Function1<com.tencent.qqnt.aio.assistedchat.model.a, Unit> a16 = AssistedChatPanelPromptBar.this.a();
                if (a16 != null) {
                    a16.invoke(aVar);
                }
            }
        });
        this.promptBarAdapter = promptBarAdapter;
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutParams(new LinearLayout.LayoutParams(-1, l.b(32)));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new b());
        recyclerView.setAdapter(promptBarAdapter);
        this.recyclerView = recyclerView;
        setOrientation(1);
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) l.a(0.5f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColorStateList(context, R.color.qui_common_border_light));
        view.setBackground(gradientDrawable);
        addView(view);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, l.b(48)));
        linearLayout.setGravity(16);
        linearLayout.addView(textView);
        linearLayout.addView(recyclerView);
        addView(linearLayout);
    }
}
