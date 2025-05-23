package com.tencent.mobileqq.guild.channel.joinchannel.verifynew;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.ChooseQuestionAdapterDelegate;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.HeadContentAdapterDelegate;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.SubmitBtnAdapterDelegate;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.WordQuestionAdapterDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lwf1/b;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel;", "I", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel;", "k0", "()Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel;", "viewModel", "com/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$c", "J", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$c;", "delegateListener", "<init>", "(Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel;)V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<wf1.b> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final JoinGuildVerifyViewModel viewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final c delegateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lwf1/b;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C7682a extends DiffUtil.ItemCallback<wf1.b> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull wf1.b oldItem, @NotNull wf1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull wf1.b oldItem, @NotNull wf1.b newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem == newItem) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "", "Lwf1/b;", "question", "", "content", "", "f1", "l0", "k", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface b {
        void f1(@NotNull wf1.b question, @NotNull String content);

        void k();

        void l0(@NotNull wf1.b question);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$c", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "Lwf1/b;", "question", "", "content", "", "f1", "l0", "k", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a.b
        public void f1(@NotNull wf1.b question, @NotNull String content) {
            Intrinsics.checkNotNullParameter(question, "question");
            Intrinsics.checkNotNullParameter(content, "content");
            a.this.getViewModel().f1(question, content);
        }

        @Override // com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a.b
        public void k() {
            a.this.getViewModel().k();
        }

        @Override // com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a.b
        public void l0(@NotNull wf1.b question) {
            Intrinsics.checkNotNullParameter(question, "question");
            a.this.getViewModel().l0(question);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull JoinGuildVerifyViewModel viewModel) {
        super(new C7682a());
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        c cVar = new c();
        this.delegateListener = cVar;
        this.f236209m.c(new HeadContentAdapterDelegate());
        this.f236209m.c(new WordQuestionAdapterDelegate(cVar));
        this.f236209m.c(new ChooseQuestionAdapterDelegate(cVar));
        this.f236209m.c(new SubmitBtnAdapterDelegate(cVar));
    }

    @NotNull
    /* renamed from: k0, reason: from getter */
    public final JoinGuildVerifyViewModel getViewModel() {
        return this.viewModel;
    }
}
