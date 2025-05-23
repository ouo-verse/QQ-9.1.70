package jl3;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Ljl3/a;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "r", "Ljl3/a$b;", "g", "Ljl3/a$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljl3/a$b;", "selectData", "Ljl3/a$a;", h.F, "Ljl3/a$a;", "p", "()Ljl3/a$a;", "onSelectCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljl3/a$b;Ljl3/a$a;)V", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends com.tencent.mobileqq.widget.selectorview.h {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final SelectData selectData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final InterfaceC10597a onSelectCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\b"}, d2 = {"Ljl3/a$a;", "", "", "onDismiss", "", "", "selectResult", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jl3.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public interface InterfaceC10597a {
        void a(List<Integer> selectResult);

        void onDismiss();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"jl3/a$c", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements QPickerView.e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            return a.this.getSelectData().b().size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int column) {
            return a.this.getSelectData().b().get(column).length;
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public String getText(int column, int row) {
            return a.this.getSelectData().b().get(column)[row];
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, SelectData selectData, InterfaceC10597a onSelectCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectData, "selectData");
        Intrinsics.checkNotNullParameter(onSelectCallback, "onSelectCallback");
        this.selectData = selectData;
        this.onSelectCallback = onSelectCallback;
        r();
    }

    private final void r() {
        this.f317413c.j(new c());
        k(this.selectData.getTitle());
        int length = this.selectData.getDefaultData().length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f317413c.setSelection(i3, this.selectData.getDefaultData()[i3].intValue());
        }
        i(new d());
    }

    /* renamed from: p, reason: from getter */
    public final InterfaceC10597a getOnSelectCallback() {
        return this.onSelectCallback;
    }

    /* renamed from: q, reason: from getter */
    public final SelectData getSelectData() {
        return this.selectData;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\t\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Ljl3/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "selectDataList", "[Ljava/lang/Integer;", "()[Ljava/lang/Integer;", "defaultData", "<init>", "(Ljava/lang/String;Ljava/util/List;[Ljava/lang/Integer;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: jl3.a$b, reason: from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class SelectData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final List<String[]> selectDataList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final Integer[] defaultData;

        public SelectData(String str, List<String[]> selectDataList, Integer[] defaultData) {
            Intrinsics.checkNotNullParameter(selectDataList, "selectDataList");
            Intrinsics.checkNotNullParameter(defaultData, "defaultData");
            this.title = str;
            this.selectDataList = selectDataList;
            this.defaultData = defaultData;
        }

        /* renamed from: a, reason: from getter */
        public final Integer[] getDefaultData() {
            return this.defaultData;
        }

        public final List<String[]> b() {
            return this.selectDataList;
        }

        /* renamed from: c, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            return ((((str == null ? 0 : str.hashCode()) * 31) + this.selectDataList.hashCode()) * 31) + Arrays.hashCode(this.defaultData);
        }

        public String toString() {
            return "SelectData(title=" + this.title + ", selectDataList=" + this.selectDataList + ", defaultData=" + Arrays.toString(this.defaultData) + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectData)) {
                return false;
            }
            SelectData selectData = (SelectData) other;
            return Intrinsics.areEqual(this.title, selectData.title) && Intrinsics.areEqual(this.selectDataList, selectData.selectDataList) && Intrinsics.areEqual(this.defaultData, selectData.defaultData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"jl3/a$d", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements QActionSheet.f {
        d() {
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            ArrayList arrayList = new ArrayList();
            int size = a.this.getSelectData().b().size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(i3, Integer.valueOf(((com.tencent.mobileqq.widget.selectorview.h) a.this).f317413c.h(i3)));
            }
            a.this.getOnSelectCallback().a(arrayList);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            a.this.getOnSelectCallback().onDismiss();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
        }
    }
}
