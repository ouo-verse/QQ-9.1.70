package com.tencent.mobileqq.troop.homework.common.widget.pickersheet;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "r", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;", "g", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;", "pickerSheetData", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$a;", h.F, "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$a;", "p", "()Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$a;", "onSelectCallback", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$a;)V", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends com.tencent.mobileqq.widget.selectorview.h {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b pickerSheetData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceC8733a onSelectCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$a;", "", "", "onDismiss", "", "", "selectItems", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC8733a {
        void a(@NotNull List<Integer> selectItems);

        void onDismiss();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\u000e\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "", "b", "Ljava/util/List;", "()Ljava/util/List;", "dataMatrix", "selectedPositionList", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<List<String>> dataMatrix;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<Integer> selectedPositionList;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@Nullable String str, @NotNull List<? extends List<String>> dataMatrix, @NotNull List<Integer> selectedPositionList) {
            Intrinsics.checkNotNullParameter(dataMatrix, "dataMatrix");
            Intrinsics.checkNotNullParameter(selectedPositionList, "selectedPositionList");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, dataMatrix, selectedPositionList);
                return;
            }
            this.title = str;
            this.dataMatrix = dataMatrix;
            this.selectedPositionList = selectedPositionList;
        }

        @NotNull
        public final List<List<String>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.dataMatrix;
        }

        @NotNull
        public final List<Integer> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.selectedPositionList;
        }

        @Nullable
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.title, bVar.title) && Intrinsics.areEqual(this.dataMatrix, bVar.dataMatrix) && Intrinsics.areEqual(this.selectedPositionList, bVar.selectedPositionList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            String str = this.title;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return (((hashCode * 31) + this.dataMatrix.hashCode()) * 31) + this.selectedPositionList.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "PickerSheetData(title=" + this.title + ", dataMatrix=" + this.dataMatrix + ", selectedPositionList=" + this.selectedPositionList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$c", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements QPickerView.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return a.this.q().a().size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int column) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, column)).intValue();
            }
            return a.this.q().a().get(column).size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        @NotNull
        public String getText(int column, int row) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(column), Integer.valueOf(row));
            }
            return a.this.q().a().get(column).get(row);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$d", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d implements QActionSheet.f {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            ArrayList arrayList = new ArrayList();
            int size = a.this.q().a().size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(i3, Integer.valueOf(((com.tencent.mobileqq.widget.selectorview.h) a.this).f317413c.h(i3)));
            }
            a.this.p().a(arrayList);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a.this.p().onDismiss();
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @NotNull b pickerSheetData, @NotNull InterfaceC8733a onSelectCallback) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pickerSheetData, "pickerSheetData");
        Intrinsics.checkNotNullParameter(onSelectCallback, "onSelectCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, pickerSheetData, onSelectCallback);
            return;
        }
        this.pickerSheetData = pickerSheetData;
        this.onSelectCallback = onSelectCallback;
        r();
    }

    private final void r() {
        this.f317413c.j(new c());
        k(this.pickerSheetData.c());
        int size = this.pickerSheetData.b().size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f317413c.setSelection(i3, this.pickerSheetData.b().get(i3).intValue());
        }
        i(new d());
    }

    @NotNull
    public final InterfaceC8733a p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (InterfaceC8733a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.onSelectCallback;
    }

    @NotNull
    public final b q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pickerSheetData;
    }
}
