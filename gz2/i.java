package gz2;

import android.content.Context;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lgz2/i;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "p", "()I", "adStyle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "g", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class i extends com.tencent.mobileqq.widget.selectorview.h {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f403928h;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lgz2/i$a;", "", "", "", "sAdStyleList", "Ljava/util/List;", "a", "()Ljava/util/List;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gz2.i$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<Integer> a() {
            return i.f403928h;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"gz2/i$b", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements QPickerView.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int column) {
            return i.INSTANCE.a().size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        @NotNull
        public String getText(int column, int row) {
            return String.valueOf(i.INSTANCE.a().get(row).intValue());
        }
    }

    static {
        List<Integer> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(0, 1, 2, 3, 4, 5, 6);
        f403928h = mutableListOf;
    }

    public i(@Nullable Context context) {
        super(context);
        this.f317413c.j(new b());
        this.f317413c.setSelection(0, 0);
        this.f317413c.m(0);
    }

    public final int p() {
        return this.f317413c.h(0);
    }
}
