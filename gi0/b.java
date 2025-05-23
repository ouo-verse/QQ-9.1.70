package gi0;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.refreshview.RecyclerViewHeaderViewAdapter;
import com.tencent.ecommerce.biz.orders.address.f;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\nB#\u0012\u0006\u0010-\u001a\u00020,\u0012\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040'\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\"\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\t0\t0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0013R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u000f\u0010\u001aR6\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b\n\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010+\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lgi0/b;", "Landroid/widget/PopupWindow;", "", "title", "", "c", "Landroid/view/View;", "contentView", "setContentView", "Lcom/tencent/ecommerce/biz/orders/address/f;", "a", "Lcom/tencent/ecommerce/biz/orders/address/f;", "dataAdapter", "Lcom/tencent/ecommerce/base/ui/refreshview/RecyclerViewHeaderViewAdapter;", "kotlin.jvm.PlatformType", "b", "Lcom/tencent/ecommerce/base/ui/refreshview/RecyclerViewHeaderViewAdapter;", "adapter", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "value", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "", "Lgi0/b$a;", "e", "Ljava/util/List;", "getItemDataList", "()Ljava/util/List;", "(Ljava/util/List;)V", "itemDataList", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lkotlin/Function1;", "", "g", "Lkotlin/jvm/functions/Function1;", "itemClickCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b extends PopupWindow {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f dataAdapter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final RecyclerViewHeaderViewAdapter<f> adapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<ItemData> itemDataList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Function1<Integer, Unit> itemClickCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context context, Function1<? super Integer, Unit> function1) {
        super(context);
        List<ItemData> emptyList;
        this.itemClickCallback = function1;
        f fVar = new f(function1);
        this.dataAdapter = fVar;
        this.adapter = new RecyclerViewHeaderViewAdapter<>(fVar);
        TextView textView = new TextView(context);
        textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6421i));
        textView.setTextSize(1, 14.0f);
        textView.setPadding(e.c(14.0f), e.c(8.0f), e.c(14.0f), e.c(8.0f));
        Unit unit = Unit.INSTANCE;
        this.textView = textView;
        this.title = "";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.itemDataList = emptyList;
        setBackgroundDrawable(new ColorDrawable(0));
        setContentView(LayoutInflater.from(context).inflate(R.layout.f167343ct1, (ViewGroup) null));
    }

    private final void c(String title) {
        if (title.length() == 0) {
            if (this.adapter.getHeaderCount() > 0) {
                this.adapter.q0(this.textView);
                RecyclerView recyclerView = this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                }
                ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
                if (layoutParams != null) {
                    ((ConstraintLayout.LayoutParams) layoutParams).matchConstraintMaxHeight = e.c(232.0f);
                    this.adapter.notifyItemRemoved(0);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            return;
        }
        this.textView.setText(title);
        if (this.adapter.getHeaderCount() == 0) {
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            }
            ViewGroup.LayoutParams layoutParams2 = recyclerView2.getLayoutParams();
            if (layoutParams2 != null) {
                ((ConstraintLayout.LayoutParams) layoutParams2).matchConstraintMaxHeight = e.c(260.0f);
                this.adapter.m0(this.textView);
                this.adapter.notifyItemInserted(0);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
    }

    public final void a(List<ItemData> list) {
        this.dataAdapter.setData(list);
        this.itemDataList = list;
    }

    public final void b(String str) {
        c(str);
        this.title = str;
    }

    @Override // android.widget.PopupWindow
    public void setContentView(View contentView) {
        super.setContentView(contentView);
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.o8n);
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        Unit unit = Unit.INSTANCE;
        this.recyclerView = recyclerView;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\n\u001a\u0004\b\t\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lgi0/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "title", "b", "()Ljava/lang/String;", "desc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: gi0.b$a, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class ItemData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String desc;

        public ItemData(String str, String str2) {
            this.title = str;
            this.desc = str2;
        }

        /* renamed from: a, reason: from getter */
        public final String getDesc() {
            return this.desc;
        }

        public int hashCode() {
            String str = this.title;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.desc;
            return hashCode + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ItemData(title=" + this.title + ", desc=" + this.desc + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ItemData)) {
                return false;
            }
            ItemData itemData = (ItemData) other;
            return Intrinsics.areEqual(this.title, itemData.title) && Intrinsics.areEqual(this.desc, itemData.desc);
        }
    }
}
