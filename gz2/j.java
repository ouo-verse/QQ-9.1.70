package gz2;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lgz2/j;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "posId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "g", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j extends com.tencent.mobileqq.widget.selectorview.h {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final List<String> f403930h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final HashMap<String, String> f403931i;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R0\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lgz2/j$a;", "", "", "", "sPosIdList", "Ljava/util/List;", "a", "()Ljava/util/List;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sPosIdTextMap", "Ljava/util/HashMap;", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gz2.j$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<String> a() {
            return j.f403930h;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"gz2/j$b", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
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
            return j.INSTANCE.a().size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        @NotNull
        public String getText(int column, int row) {
            String str = (String) j.f403931i.get(j.INSTANCE.a().get(row));
            if (str == null) {
                return "";
            }
            return str;
        }
    }

    static {
        List<String> mutableListOf;
        HashMap<String, String> hashMapOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("1082214467882419", "6011195015998218", "5099373422087196", "5121394530341950");
        f403930h = mutableListOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("1082214467882419", "\u8fd0\u52a8\u5e7f\u544a\u4f4d"), TuplesKt.to("6011195015998218", "\u5929\u6c14\u5e7f\u544a\u4f4d"), TuplesKt.to("5099373422087196", "\u8d2d\u7269\u5e7f\u544a\u4f4d"), TuplesKt.to("5121394530341950", "\u9891\u9053\u5e7f\u544a\u4f4d"));
        f403931i = hashMapOf;
    }

    public j(@Nullable Context context) {
        super(context);
        this.f317413c.j(new b());
        this.f317413c.setSelection(0, 0);
        this.f317413c.m(0);
    }

    @NotNull
    public final String q() {
        return f403930h.get(this.f317413c.h(0));
    }
}
