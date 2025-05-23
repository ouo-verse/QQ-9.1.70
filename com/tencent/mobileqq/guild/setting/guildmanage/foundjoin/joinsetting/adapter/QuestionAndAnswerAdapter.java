package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.adapter;

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
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestionItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import h53.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000ej\b\u0012\u0004\u0012\u00020\u0006`\u000fJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/QuestionAndAnswerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/QuestionAndAnswerAdapter$a;", "", "m0", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/GWGProJoinGuildWordQuestionItem;", "items", "", "setItems", "j0", "", "position", "p0", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "o0", "holder", "n0", "getItemCount", "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "l0", "()Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;", "viewModel", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mItems", "<init>", "(Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/q;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QuestionAndAnswerAdapter extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<GWGProJoinGuildWordQuestionItem> mItems;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/QuestionAndAnswerAdapter$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "E", "Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "o", "()Lcom/tencent/mobileqq/widget/inputview/QUISingleLineInputView;", "question", UserInfo.SEX_FEMALE, "l", "answer", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "questionText", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "delete", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
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
        private final TextView questionText;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final ImageView delete;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.h29);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.question)");
            QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) findViewById;
            this.question = qUISingleLineInputView;
            View findViewById2 = itemView.findViewById(R.id.f164343sq4);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.answer)");
            QUISingleLineInputView qUISingleLineInputView2 = (QUISingleLineInputView) findViewById2;
            this.answer = qUISingleLineInputView2;
            View findViewById3 = itemView.findViewById(R.id.f657339q);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.question_text)");
            this.questionText = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.bfl);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.delete)");
            this.delete = (ImageView) findViewById4;
            qUISingleLineInputView.setPaddingHorizontal(0);
            qUISingleLineInputView2.setPaddingHorizontal(0);
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
        public final QUISingleLineInputView getQuestion() {
            return this.question;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final TextView getQuestionText() {
            return this.questionText;
        }
    }

    public QuestionAndAnswerAdapter(@NotNull q viewModel) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        GWGProJoinGuildWordQuestionItem gWGProJoinGuildWordQuestionItem = new GWGProJoinGuildWordQuestionItem();
        gWGProJoinGuildWordQuestionItem.setQuestion("");
        gWGProJoinGuildWordQuestionItem.setCorrectAnswer("");
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(gWGProJoinGuildWordQuestionItem);
        this.mItems = arrayListOf;
    }

    private final boolean m0() {
        if (this.mItems.size() <= 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItems.size();
    }

    public final void j0() {
        boolean z16;
        boolean z17 = false;
        if (this.mItems.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        List<GWGProJoinGuildWordQuestionItem> list = this.mItems;
        GWGProJoinGuildWordQuestionItem gWGProJoinGuildWordQuestionItem = new GWGProJoinGuildWordQuestionItem();
        gWGProJoinGuildWordQuestionItem.setQuestion("");
        gWGProJoinGuildWordQuestionItem.setCorrectAnswer("");
        list.add(gWGProJoinGuildWordQuestionItem);
        if (this.mItems.size() == 1) {
            z17 = true;
        }
        if (z16 != z17) {
            notifyDataSetChanged();
        } else {
            notifyItemInserted(this.mItems.size() - 1);
        }
    }

    @NotNull
    public final ArrayList<GWGProJoinGuildWordQuestionItem> k0() {
        Collection collection;
        collection = CollectionsKt___CollectionsKt.toCollection(this.mItems, new ArrayList());
        return (ArrayList) collection;
    }

    @NotNull
    /* renamed from: l0, reason: from getter */
    public final q getViewModel() {
        return this.viewModel;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.setIsRecyclable(false);
        holder.getQuestionText().setText(holder.getQuestionText().getContext().getString(R.string.f147120w1) + (position + 1));
        holder.getQuestion().setContentText(this.mItems.get(position).getQuestion());
        holder.getAnswer().setContentText(this.mItems.get(position).getCorrectAnswer());
        holder.getQuestion().setInputViewWatcher(new b(holder));
        holder.getAnswer().setInputViewWatcher(new c(holder));
        if (position == 0 && m0()) {
            holder.getDelete().setImageResource(R.drawable.guild_token_feedback_error_delete_light_disable);
        } else {
            holder.getDelete().setImageResource(R.drawable.guild_delete_light_selector);
        }
        kotlin.b.b(holder.getDelete(), new QuestionAndAnswerAdapter$onBindViewHolder$3(this, holder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evj, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(view);
    }

    public final void p0(int position) {
        this.mItems.remove(position);
        notifyDataSetChanged();
        this.viewModel.Z1(this.mItems);
    }

    public final void setItems(@NotNull List<? extends GWGProJoinGuildWordQuestionItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.isEmpty()) {
            return;
        }
        this.mItems.clear();
        this.mItems.addAll(items);
        notifyDataSetChanged();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/QuestionAndAnswerAdapter$b", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements h53.q {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f233894e;

        b(a aVar) {
            this.f233894e = aVar;
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            ((GWGProJoinGuildWordQuestionItem) QuestionAndAnswerAdapter.this.mItems.get(this.f233894e.getAdapterPosition())).setQuestion(String.valueOf(s16));
            QuestionAndAnswerAdapter.this.getViewModel().Z1(QuestionAndAnswerAdapter.this.mItems);
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
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u000fH\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/foundjoin/joinsetting/adapter/QuestionAndAnswerAdapter$c", "Lh53/q;", "", "title", "", "A4", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements h53.q {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f233896e;

        c(a aVar) {
            this.f233896e = aVar;
        }

        @Override // h53.k
        public void afterTextChanged(@Nullable Editable s16) {
            ((GWGProJoinGuildWordQuestionItem) QuestionAndAnswerAdapter.this.mItems.get(this.f233896e.getAdapterPosition())).setCorrectAnswer(String.valueOf(s16));
            QuestionAndAnswerAdapter.this.getViewModel().Z1(QuestionAndAnswerAdapter.this.mItems);
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
