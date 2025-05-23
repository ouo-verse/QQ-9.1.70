package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.q;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestionItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import h53.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eJ\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0002J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter$a;", "Landroid/content/Context;", "context", "", "isActive", "", "n0", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildChoiceQuestionItem;", "items", "", "setItems", "", "getItems", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "l0", "holder", "position", "k0", "m0", "getItemCount", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "j0", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "viewModel", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mItems", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildJoinTestAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<GWGProJoinGuildChoiceQuestionItem> mItems;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b\"\u0010#R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "E", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "r", "()Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "question", UserInfo.SEX_FEMALE, "l", "answer", "G", "o", "errorAnswer1", "H", "p", "errorAnswer2", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "errorAnswer3", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/TextView;", "questionText", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "delete", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final QUISingleLineInputView question;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final QUISingleLineInputView answer;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final QUISingleLineInputView errorAnswer1;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final QUISingleLineInputView errorAnswer2;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final QUISingleLineInputView errorAnswer3;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final TextView questionText;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final ImageView delete;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.h29);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.question)");
            this.question = (QUISingleLineInputView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.f164343sq4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.answer)");
            this.answer = (QUISingleLineInputView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.uwm);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.error_answer1)");
            this.errorAnswer1 = (QUISingleLineInputView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.uwn);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.error_answer2)");
            this.errorAnswer2 = (QUISingleLineInputView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.uwo);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.error_answer3)");
            this.errorAnswer3 = (QUISingleLineInputView) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f657339q);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.question_text)");
            this.questionText = (TextView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.bfl);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.delete)");
            this.delete = (ImageView) findViewById7;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final QUISingleLineInputView getAnswer() {
            return this.answer;
        }

        @NotNull
        /* renamed from: m, reason: from getter */
        public final ImageView getDelete() {
            return this.delete;
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final QUISingleLineInputView getErrorAnswer1() {
            return this.errorAnswer1;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final QUISingleLineInputView getErrorAnswer2() {
            return this.errorAnswer2;
        }

        @NotNull
        /* renamed from: q, reason: from getter */
        public final QUISingleLineInputView getErrorAnswer3() {
            return this.errorAnswer3;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final QUISingleLineInputView getQuestion() {
            return this.question;
        }

        @NotNull
        /* renamed from: s, reason: from getter */
        public final TextView getQuestionText() {
            return this.questionText;
        }
    }

    public GuildJoinTestAdapter(@NotNull q viewModel) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem = new GWGProJoinGuildChoiceQuestionItem();
        gWGProJoinGuildChoiceQuestionItem.setQuestion("");
        gWGProJoinGuildChoiceQuestionItem.setCorrectAnswer("");
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(gWGProJoinGuildChoiceQuestionItem);
        this.mItems = arrayListOf;
    }

    private final int n0(Context context, boolean isActive) {
        if (isActive) {
            return QQGuildUIUtil.i(context, R.color.qui_common_feedback_error);
        }
        return GuildUIUtils.f235378a.v(QQGuildUIUtil.i(context, R.color.qui_common_feedback_error), 0.3f, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItems.size();
    }

    @NotNull
    public final List<GWGProJoinGuildChoiceQuestionItem> getItems() {
        return this.mItems;
    }

    @NotNull
    /* renamed from: j0, reason: from getter */
    public final q getViewModel() {
        return this.viewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int i3 = 0;
        holder.setIsRecyclable(false);
        holder.getQuestionText().setText(holder.getQuestionText().getContext().getString(R.string.f147120w1) + (position + 1));
        GWGProJoinGuildChoiceQuestionItem gWGProJoinGuildChoiceQuestionItem = this.mItems.get(position);
        holder.getQuestion().setContentText(gWGProJoinGuildChoiceQuestionItem.getQuestion());
        holder.getAnswer().setContentText(gWGProJoinGuildChoiceQuestionItem.getCorrectAnswer());
        ArrayList<String> answers = gWGProJoinGuildChoiceQuestionItem.getAnswers();
        Intrinsics.checkNotNullExpressionValue(answers, "item.answers");
        for (Object obj : answers) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        holder.getErrorAnswer3().setContentText(str);
                    }
                } else {
                    holder.getErrorAnswer2().setContentText(str);
                }
            } else {
                holder.getErrorAnswer1().setContentText(str);
            }
            i3 = i16;
        }
        holder.getQuestion().setInputViewWatcher(new b(holder));
        holder.getAnswer().setInputViewWatcher(new c(holder));
        holder.getErrorAnswer1().setInputViewWatcher(new d(holder));
        holder.getErrorAnswer2().setInputViewWatcher(new e(holder));
        holder.getErrorAnswer3().setInputViewWatcher(new f(holder));
        kotlin.b.b(holder.getDelete(), new GuildJoinTestAdapter$onBindViewHolder$7(this, holder));
        m0(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evm, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }

    public final void m0(@NotNull a holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        boolean z16 = true;
        if (this.mItems.size() <= 1) {
            z16 = false;
        }
        ImageView delete = holder.getDelete();
        Context context = holder.getDelete().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "holder.delete.context");
        Context context2 = holder.getDelete().getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "holder.delete.context");
        delete.setImageDrawable(GuildUIUtils.y(context, R.drawable.qui_delete_light, n0(context2, z16)));
    }

    public final void setItems(@NotNull List<? extends GWGProJoinGuildChoiceQuestionItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.isEmpty()) {
            return;
        }
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter$b", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements h53.q {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f233883e;

        b(a aVar) {
            this.f233883e = aVar;
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            ((GWGProJoinGuildChoiceQuestionItem) GuildJoinTestAdapter.this.mItems.get(this.f233883e.getAdapterPosition())).setQuestion(String.valueOf(s16));
            GuildJoinTestAdapter.this.getViewModel().X1(GuildJoinTestAdapter.this.mItems);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter$c", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements h53.q {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f233885e;

        c(a aVar) {
            this.f233885e = aVar;
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            ((GWGProJoinGuildChoiceQuestionItem) GuildJoinTestAdapter.this.mItems.get(this.f233885e.getAdapterPosition())).setCorrectAnswer(String.valueOf(s16));
            jz1.a.a((GWGProJoinGuildChoiceQuestionItem) GuildJoinTestAdapter.this.mItems.get(this.f233885e.getAdapterPosition()), 0, String.valueOf(s16));
            GuildJoinTestAdapter.this.getViewModel().X1(GuildJoinTestAdapter.this.mItems);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter$d", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements h53.q {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f233887e;

        d(a aVar) {
            this.f233887e = aVar;
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            jz1.a.a((GWGProJoinGuildChoiceQuestionItem) GuildJoinTestAdapter.this.mItems.get(this.f233887e.getAdapterPosition()), 1, String.valueOf(s16));
            GuildJoinTestAdapter.this.getViewModel().X1(GuildJoinTestAdapter.this.mItems);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter$e", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements h53.q {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f233889e;

        e(a aVar) {
            this.f233889e = aVar;
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            jz1.a.a((GWGProJoinGuildChoiceQuestionItem) GuildJoinTestAdapter.this.mItems.get(this.f233889e.getAdapterPosition()), 2, String.valueOf(s16));
            GuildJoinTestAdapter.this.getViewModel().X1(GuildJoinTestAdapter.this.mItems);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/GuildJoinTestAdapter$f", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f implements h53.q {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f233891e;

        f(a aVar) {
            this.f233891e = aVar;
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            jz1.a.a((GWGProJoinGuildChoiceQuestionItem) GuildJoinTestAdapter.this.mItems.get(this.f233891e.getAdapterPosition()), 3, String.valueOf(s16));
            GuildJoinTestAdapter.this.getViewModel().X1(GuildJoinTestAdapter.this.mItems);
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
