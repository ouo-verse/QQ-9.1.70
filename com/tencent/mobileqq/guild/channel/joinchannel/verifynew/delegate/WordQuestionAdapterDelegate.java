package com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.OnKeyboardClosedEvent;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.WordQuestionAdapterDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import h53.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.de;
import wf1.JoinGuildWordQuestion;
import wf1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J&\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006H\u0014J.\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\t\u001a\u00020\bH\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/WordQuestionAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lwf1/f;", "Lwf1/b;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/WordQuestionAdapterDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "g", h.F, "i", "", "payloads", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "d", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "delegateListener", "<init>", "(Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class WordQuestionAdapterDelegate extends AbsListItemAdapterDelegate<JoinGuildWordQuestion, b, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b delegateListener;

    public WordQuestionAdapterDelegate(@NotNull a.b delegateListener) {
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        this.delegateListener = delegateListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.g(holder);
        if (holder instanceof a) {
            SimpleEventBus.getInstance().registerReceiver((SimpleEventReceiver) holder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.h(holder);
        if (holder instanceof a) {
            SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver) holder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void i(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.i(holder);
        if (holder instanceof a) {
            SimpleEventBus.getInstance().unRegisterReceiver((SimpleEventReceiver) holder);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull b item, @NotNull List<b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof JoinGuildWordQuestion;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull JoinGuildWordQuestion item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull JoinGuildWordQuestion item, @NotNull a holder, @NotNull List<Object> payloads, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.n(item, payloads, position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        de g16 = de.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new a(g16, this.delegateListener);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b&\u0010'J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00110\u0010H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/WordQuestionAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/OnKeyboardClosedEvent;", "Lwf1/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "payloads", "", "position", "", DomainData.DOMAIN_NAME, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lvp1/de;", "E", "Lvp1/de;", "p", "()Lvp1/de;", "binding", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "delegateListener", "G", "Lwf1/f;", "data", "Lh53/q;", "H", "Lh53/q;", "inputViewWatcher", "<init>", "(Lvp1/de;Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends RecyclerView.ViewHolder implements SimpleEventReceiver<OnKeyboardClosedEvent> {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final de binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final a.b delegateListener;

        /* renamed from: G, reason: from kotlin metadata */
        private JoinGuildWordQuestion data;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final q inputViewWatcher;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull de binding, @NotNull a.b delegateListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
            this.binding = binding;
            this.delegateListener = delegateListener;
            this.inputViewWatcher = new C7683a();
            binding.f442883b.setStyle(1);
            binding.f442883b.setShowBottomLine(false);
            binding.f442883b.setMaxWordCount(10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f442883b.z();
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<OnKeyboardClosedEvent>> getEventClass() {
            ArrayList<Class<OnKeyboardClosedEvent>> arrayList = new ArrayList<>();
            arrayList.add(OnKeyboardClosedEvent.class);
            return arrayList;
        }

        public final void n(@NotNull JoinGuildWordQuestion item, @NotNull List<Object> payloads, int position) {
            boolean isBlank;
            int i3;
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            this.data = item;
            TextView textView = this.binding.f442885d;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.questionView");
            isBlank = StringsKt__StringsJVMKt.isBlank(item.getQuestion());
            if (!isBlank) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            this.binding.f442885d.setText(item.getQuestionHeadTips() + item.getQuestion());
            this.binding.f442883b.setHint(item.getHint());
            if (position == 1) {
                this.binding.f442883b.q();
                this.binding.f442883b.postDelayed(new Runnable() { // from class: vf1.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        WordQuestionAdapterDelegate.a.o(WordQuestionAdapterDelegate.a.this);
                    }
                }, 100L);
            }
            this.binding.f442883b.setInputViewWatcher(this.inputViewWatcher);
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            if (event instanceof OnKeyboardClosedEvent) {
                this.binding.f442883b.clearFocus();
            }
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final de getBinding() {
            return this.binding;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final a.b getDelegateListener() {
            return this.delegateListener;
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/WordQuestionAdapterDelegate$a$a", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.WordQuestionAdapterDelegate$a$a, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C7683a implements q {
            C7683a() {
            }

            @Override // h53.k
            public void afterTextChanged(@Nullable Editable s16) {
                JoinGuildWordQuestion joinGuildWordQuestion = a.this.data;
                JoinGuildWordQuestion joinGuildWordQuestion2 = null;
                if (joinGuildWordQuestion == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                    joinGuildWordQuestion = null;
                }
                joinGuildWordQuestion.g(String.valueOf(a.this.getBinding().f442883b.d()));
                a.b delegateListener = a.this.getDelegateListener();
                JoinGuildWordQuestion joinGuildWordQuestion3 = a.this.data;
                if (joinGuildWordQuestion3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                    joinGuildWordQuestion3 = null;
                }
                JoinGuildWordQuestion joinGuildWordQuestion4 = a.this.data;
                if (joinGuildWordQuestion4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                } else {
                    joinGuildWordQuestion2 = joinGuildWordQuestion4;
                }
                delegateListener.f1(joinGuildWordQuestion3, joinGuildWordQuestion2.getAnswer());
            }

            @Override // h53.k
            public void f8(boolean z16) {
                q.a.a(this, z16);
            }

            @Override // h53.q
            public void A4(@Nullable String title) {
            }

            @Override // h53.k
            public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            }

            @Override // h53.k
            public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            }
        }
    }
}
