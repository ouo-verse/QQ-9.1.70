package com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.delegate.ChooseQuestionAdapterDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.da;
import wf1.AnswerItem;
import wf1.JoinGuildChoiceQuestion;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/ChooseQuestionAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lwf1/c;", "Lwf1/b;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/ChooseQuestionAdapterDelegate$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "d", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "delegateListener", "<init>", "(Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;)V", "e", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class ChooseQuestionAdapterDelegate extends AbsListItemAdapterDelegate<JoinGuildChoiceQuestion, wf1.b, b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a.b delegateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/delegate/ChooseQuestionAdapterDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "u", "", "index", "E", "Lwf1/c;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "t", "", "", "payloads", "D", "Lvp1/da;", "Lvp1/da;", "getBinding", "()Lvp1/da;", "binding", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "delegateListener", "G", "Lwf1/c;", "data", "<init>", "(Lvp1/da;Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final da binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final a.b delegateListener;

        /* renamed from: G, reason: from kotlin metadata */
        private JoinGuildChoiceQuestion data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull da binding, @NotNull a.b delegateListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
            this.binding = binding;
            this.delegateListener = delegateListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void A(b this$0, CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z16) {
                this$0.binding.f442856b.setChecked(false);
                this$0.binding.f442859e.setChecked(false);
                this$0.binding.f442857c.setChecked(false);
                this$0.E(1);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void B(b this$0, CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z16) {
                this$0.binding.f442856b.setChecked(false);
                this$0.binding.f442858d.setChecked(false);
                this$0.binding.f442857c.setChecked(false);
                this$0.E(2);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void C(b this$0, CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z16) {
                this$0.binding.f442856b.setChecked(false);
                this$0.binding.f442858d.setChecked(false);
                this$0.binding.f442859e.setChecked(false);
                this$0.E(3);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        private final void E(int index) {
            JoinGuildChoiceQuestion joinGuildChoiceQuestion = this.data;
            JoinGuildChoiceQuestion joinGuildChoiceQuestion2 = null;
            if (joinGuildChoiceQuestion == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                joinGuildChoiceQuestion = null;
            }
            Iterator<T> it = joinGuildChoiceQuestion.c().iterator();
            while (it.hasNext()) {
                ((AnswerItem) it.next()).c(false);
            }
            JoinGuildChoiceQuestion joinGuildChoiceQuestion3 = this.data;
            if (joinGuildChoiceQuestion3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
                joinGuildChoiceQuestion3 = null;
            }
            joinGuildChoiceQuestion3.c().get(index).c(true);
            a.b bVar = this.delegateListener;
            JoinGuildChoiceQuestion joinGuildChoiceQuestion4 = this.data;
            if (joinGuildChoiceQuestion4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            } else {
                joinGuildChoiceQuestion2 = joinGuildChoiceQuestion4;
            }
            bVar.l0(joinGuildChoiceQuestion2);
        }

        private final void t(JoinGuildChoiceQuestion item) {
            boolean z16;
            int i3;
            boolean z17;
            int i16;
            boolean z18;
            int i17;
            if (item.c().size() > 3) {
                this.binding.f442863i.setText(item.c().get(3).getAnswerContent());
                this.binding.f442857c.setChecked(item.c().get(3).getIsSelected());
            }
            TextView textView = this.binding.f442863i;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.listTitleFour");
            boolean z19 = true;
            int i18 = 0;
            if (item.c().size() > 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
            if (item.c().size() > 2) {
                this.binding.f442865k.setText(item.c().get(2).getAnswerContent());
                this.binding.f442859e.setChecked(item.c().get(2).getIsSelected());
            }
            TextView textView2 = this.binding.f442865k;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.listTitleThird");
            if (item.c().size() > 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            textView2.setVisibility(i16);
            if (item.c().size() > 1) {
                this.binding.f442864j.setText(item.c().get(1).getAnswerContent());
                this.binding.f442858d.setChecked(item.c().get(1).getIsSelected());
            }
            TextView textView3 = this.binding.f442864j;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.listTitleSecond");
            if (item.c().size() > 1) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            textView3.setVisibility(i17);
            if (item.c().size() > 0) {
                this.binding.f442862h.setText(item.c().get(0).getAnswerContent());
                this.binding.f442856b.setChecked(item.c().get(0).getIsSelected());
            }
            TextView textView4 = this.binding.f442862h;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.listTitleFirst");
            if (item.c().size() <= 0) {
                z19 = false;
            }
            if (!z19) {
                i18 = 8;
            }
            textView4.setVisibility(i18);
        }

        private final void u() {
            this.binding.f442860f.setOnClickListener(new View.OnClickListener() { // from class: vf1.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseQuestionAdapterDelegate.b.v(ChooseQuestionAdapterDelegate.b.this, view);
                }
            });
            this.binding.f442867m.setOnClickListener(new View.OnClickListener() { // from class: vf1.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseQuestionAdapterDelegate.b.w(ChooseQuestionAdapterDelegate.b.this, view);
                }
            });
            this.binding.f442868n.setOnClickListener(new View.OnClickListener() { // from class: vf1.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseQuestionAdapterDelegate.b.x(ChooseQuestionAdapterDelegate.b.this, view);
                }
            });
            this.binding.f442861g.setOnClickListener(new View.OnClickListener() { // from class: vf1.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseQuestionAdapterDelegate.b.y(ChooseQuestionAdapterDelegate.b.this, view);
                }
            });
            this.binding.f442856b.setClickable(false);
            this.binding.f442856b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: vf1.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    ChooseQuestionAdapterDelegate.b.z(ChooseQuestionAdapterDelegate.b.this, compoundButton, z16);
                }
            });
            this.binding.f442858d.setClickable(false);
            this.binding.f442858d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: vf1.f
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    ChooseQuestionAdapterDelegate.b.A(ChooseQuestionAdapterDelegate.b.this, compoundButton, z16);
                }
            });
            this.binding.f442859e.setClickable(false);
            this.binding.f442859e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: vf1.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    ChooseQuestionAdapterDelegate.b.B(ChooseQuestionAdapterDelegate.b.this, compoundButton, z16);
                }
            });
            this.binding.f442857c.setClickable(false);
            this.binding.f442857c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: vf1.h
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    ChooseQuestionAdapterDelegate.b.C(ChooseQuestionAdapterDelegate.b.this, compoundButton, z16);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void v(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f442856b.setChecked(true);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f442858d.setChecked(true);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void x(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f442859e.setChecked(true);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void y(b this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.binding.f442857c.setChecked(true);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(b this$0, CompoundButton compoundButton, boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z16) {
                this$0.binding.f442858d.setChecked(false);
                this$0.binding.f442859e.setChecked(false);
                this$0.binding.f442857c.setChecked(false);
                this$0.E(0);
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }

        public final void D(@NotNull JoinGuildChoiceQuestion item, @NotNull List<Object> payloads) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
            this.data = item;
            this.binding.f442866l.setText(item.getQuestionHeadTips() + item.getQuestion());
            u();
            t(item);
        }
    }

    public ChooseQuestionAdapterDelegate(@NotNull a.b delegateListener) {
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        this.delegateListener = delegateListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull wf1.b item, @NotNull List<wf1.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof JoinGuildChoiceQuestion;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull JoinGuildChoiceQuestion item, @NotNull b holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.D(item, payloads);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        da g16 = da.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new b(g16, this.delegateListener);
    }
}
