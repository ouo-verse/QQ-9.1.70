package al2;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0003%&'B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nJ\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0014\u001a\u00020\u00052\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010\"\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lal2/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lal2/b$c;", "", "textContent", "", "q0", "Landroid/widget/TextView;", "correlationView", "o0", "", "labelList", "r0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "n0", "holder", "position", "l0", "getItemCount", "", "Lal2/b$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "textItemList", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "value", "D", "Lal2/b$b;", "p0", "(Lal2/b$b;)V", "selectTextItem", "<init>", "()V", "a", "b", "c", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b extends RecyclerView.Adapter<c> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView correlationView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TextItem selectTextItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<TextItem> textItemList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lal2/b$a;", "", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lal2/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "textContent", "b", "Z", "()Z", "c", "(Z)V", "isSelected", "<init>", "(Ljava/lang/String;Z)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: al2.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class TextItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String textContent;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isSelected;

        public TextItem(@NotNull String textContent, boolean z16) {
            Intrinsics.checkNotNullParameter(textContent, "textContent");
            this.textContent = textContent;
            this.isSelected = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getTextContent() {
            return this.textContent;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final void c(boolean z16) {
            this.isSelected = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TextItem)) {
                return false;
            }
            TextItem textItem = (TextItem) other;
            if (Intrinsics.areEqual(this.textContent, textItem.textContent) && this.isSelected == textItem.isSelected) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.textContent.hashCode() * 31;
            boolean z16 = this.isSelected;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "TextItem(textContent=" + this.textContent + ", isSelected=" + this.isSelected + ")";
        }

        public /* synthetic */ TextItem(String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? false : z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\f"}, d2 = {"Lal2/b$c;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "textView", "Landroid/view/View;", "itemView", "<init>", "(Lal2/b;Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public final class c extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final TextView textView;
        final /* synthetic */ b F;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull b bVar, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.F = bVar;
            View findViewById = itemView.findViewById(R.id.k6s);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_content)");
            this.textView = (TextView) findViewById;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final TextView getTextView() {
            return this.textView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"al2/b$d", "Lx05/b;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class d extends x05.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TextView f26269e;

        d(TextView textView) {
            this.f26269e = textView;
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(@NotNull Editable s16) {
            Intrinsics.checkNotNullParameter(s16, "s");
            b.j0(b.this);
            b.this.q0(this.f26269e.getText().toString());
        }
    }

    public static final /* synthetic */ a j0(b bVar) {
        bVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(b this$0, TextItem currentItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(currentItem, "$currentItem");
        this$0.p0(currentItem);
        TextView textView = this$0.correlationView;
        if (textView != null) {
            textView.setText(currentItem.getTextContent());
            if (textView instanceof EditText) {
                EditText editText = (EditText) textView;
                if (editText.isFocused()) {
                    editText.setSelection(editText.getText().length());
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p0(TextItem textItem) {
        TextItem textItem2 = this.selectTextItem;
        if (textItem2 != null) {
            textItem2.c(false);
        }
        if (textItem != null) {
            textItem.c(true);
        }
        this.selectTextItem = textItem;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(String textContent) {
        for (TextItem textItem : this.textItemList) {
            if (Intrinsics.areEqual(textContent, textItem.getTextContent())) {
                p0(textItem);
                return;
            }
        }
        p0(null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.textItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull c holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final TextItem textItem = this.textItemList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: al2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.m0(b.this, textItem, view);
            }
        });
        holder.getTextView().setText(textItem.getTextContent());
        holder.getTextView().setSelected(textItem.getIsSelected());
        if (textItem.getIsSelected()) {
            holder.getTextView().setBackgroundResource(R.drawable.kc5);
            holder.getTextView().setTextColor(MobileQQ.sMobileQQ.getResources().getColor(R.color.cix));
        } else {
            holder.getTextView().setBackgroundResource(R.drawable.f161512kc4);
            holder.getTextView().setTextColor(MobileQQ.sMobileQQ.getResources().getColor(R.color.qui_common_text_secondary));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fyj, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        return new c(this, itemView);
    }

    public final void o0(@NotNull TextView correlationView) {
        Intrinsics.checkNotNullParameter(correlationView, "correlationView");
        this.correlationView = correlationView;
        correlationView.addTextChangedListener(new d(correlationView));
    }

    public final void r0(@NotNull List<String> labelList) {
        String str;
        int collectionSizeOrDefault;
        CharSequence text;
        Intrinsics.checkNotNullParameter(labelList, "labelList");
        this.textItemList.clear();
        DefaultConstructorMarker defaultConstructorMarker = null;
        p0(null);
        TextView textView = this.correlationView;
        if (textView != null && (text = textView.getText()) != null) {
            str = text.toString();
        } else {
            str = null;
        }
        List<TextItem> list = this.textItemList;
        List<String> list2 = labelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str2 : list2) {
            TextItem textItem = new TextItem(str2, false, 2, defaultConstructorMarker);
            if (Intrinsics.areEqual(str2, str)) {
                p0(textItem);
                textItem.c(true);
            }
            arrayList.add(textItem);
        }
        list.addAll(arrayList);
        notifyDataSetChanged();
    }
}
