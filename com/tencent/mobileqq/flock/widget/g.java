package com.tencent.mobileqq.flock.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.selectorview.QActionSheet;
import com.tencent.mobileqq.widget.selectorview.QPickerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0004\u001e\u001f !B+\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/flock/widget/g;", "Lcom/tencent/mobileqq/widget/selectorview/h;", "", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "id", "Landroid/content/res/ColorStateList;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/flock/widget/g$d;", "g", "Lcom/tencent/mobileqq/flock/widget/g$d;", "u", "()Lcom/tencent/mobileqq/flock/widget/g$d;", "selectData", "Lcom/tencent/mobileqq/flock/widget/g$c;", tl.h.F, "Lcom/tencent/mobileqq/flock/widget/g$c;", "t", "()Lcom/tencent/mobileqq/flock/widget/g$c;", "onSelectCallback", "Lcom/tencent/mobileqq/flock/widget/g$a;", "i", "Lcom/tencent/mobileqq/flock/widget/g$a;", "bottomConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/flock/widget/g$d;Lcom/tencent/mobileqq/flock/widget/g$c;Lcom/tencent/mobileqq/flock/widget/g$a;)V", "j", "a", "b", "c", "d", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g extends com.tencent.mobileqq.widget.selectorview.h {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d selectData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c onSelectCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a bottomConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/g$a;", "", "", "a", "", "b", "", "c", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface a {
        boolean a();

        int b();

        void c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/g$b;", "", "", "BOTTOM_BTN_TEXT_SIZE", UserInfo.SEX_FEMALE, "BOTTOM_BTN_VER_PADDING", "BOTTOM_GAP_HEIGHT", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.widget.g$b, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/g$c;", "", "", "onDismiss", "", "", "selectItems", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public interface c {
        void a(@NotNull List<Integer> selectItems);

        void onDismiss();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J;\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\n\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00040\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/flock/widget/g$d;", "", "", "title", "", "selectDataSet", "", "defaultItems", "a", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "c", "f", "(Ljava/util/List;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final /* data */ class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<List<String>> selectDataSet;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<Integer> defaultItems;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@Nullable String str, @NotNull List<? extends List<String>> selectDataSet, @NotNull List<Integer> defaultItems) {
            Intrinsics.checkNotNullParameter(selectDataSet, "selectDataSet");
            Intrinsics.checkNotNullParameter(defaultItems, "defaultItems");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, selectDataSet, defaultItems);
                return;
            }
            this.title = str;
            this.selectDataSet = selectDataSet;
            this.defaultItems = defaultItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ d b(d dVar, String str, List list, List list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = dVar.title;
            }
            if ((i3 & 2) != 0) {
                list = dVar.selectDataSet;
            }
            if ((i3 & 4) != 0) {
                list2 = dVar.defaultItems;
            }
            return dVar.a(str, list, list2);
        }

        @NotNull
        public final d a(@Nullable String title, @NotNull List<? extends List<String>> selectDataSet, @NotNull List<Integer> defaultItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (d) iPatchRedirector.redirect((short) 10, this, title, selectDataSet, defaultItems);
            }
            Intrinsics.checkNotNullParameter(selectDataSet, "selectDataSet");
            Intrinsics.checkNotNullParameter(defaultItems, "defaultItems");
            return new d(title, selectDataSet, defaultItems);
        }

        @NotNull
        public final List<Integer> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (List) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.defaultItems;
        }

        @NotNull
        public final List<List<String>> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.selectDataSet;
        }

        @Nullable
        public final String e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.title;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof d)) {
                return false;
            }
            d dVar = (d) other;
            if (Intrinsics.areEqual(this.title, dVar.title) && Intrinsics.areEqual(this.selectDataSet, dVar.selectDataSet) && Intrinsics.areEqual(this.defaultItems, dVar.defaultItems)) {
                return true;
            }
            return false;
        }

        public final void f(@NotNull List<Integer> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            } else {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.defaultItems = list;
            }
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            String str = this.title;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return (((hashCode * 31) + this.selectDataSet.hashCode()) * 31) + this.defaultItems.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            return "SelectData(title=" + this.title + ", selectDataSet=" + this.selectDataSet + ", defaultItems=" + this.defaultItems + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/flock/widget/g$e", "Lcom/tencent/mobileqq/widget/selectorview/QPickerView$e;", "", "getColumnCount", "column", "getRowCount", "row", "", "getText", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class e implements QPickerView.e {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getColumnCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return g.this.u().d().size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        public int getRowCount(int column) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, column)).intValue();
            }
            return g.this.u().d().get(column).size();
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QPickerView.e
        @NotNull
        public String getText(int column, int row) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(column), Integer.valueOf(row));
            }
            return g.this.u().d().get(column).get(row);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/flock/widget/g$f", "Lcom/tencent/mobileqq/widget/selectorview/QActionSheet$f;", "", "onDismiss", "t", "onConfirm", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class f implements QActionSheet.f {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
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
            int size = g.this.u().d().size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(i3, Integer.valueOf(((com.tencent.mobileqq.widget.selectorview.h) g.this).f317413c.h(i3)));
            }
            g.this.t().a(arrayList);
        }

        @Override // com.tencent.mobileqq.widget.selectorview.QActionSheet.f
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                g.this.t().onDismiss();
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50230);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ g(Context context, d dVar, c cVar, a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, dVar, cVar, (i3 & 8) != 0 ? null : aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, dVar, cVar, aVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.a() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void q() {
        boolean z16;
        a aVar = this.bottomConfig;
        if (aVar != null) {
            z16 = true;
        }
        z16 = false;
        if (!z16) {
            return;
        }
        View view = new View(this.f317411a);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, ViewUtils.dip2px(12.0f)));
        view.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard);
        TextView textView = new TextView(this.f317411a);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        int dip2px = ViewUtils.dip2px(16.0f);
        textView.setPadding(0, dip2px, 0, dip2px);
        textView.setTextColor(s(R.color.qui_common_text_primary));
        textView.setTextSize(0, ViewUtils.dip2px(17.0f));
        QUIListItemBackgroundType qUIListItemBackgroundType = QUIListItemBackgroundType.NoneRound;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setBackground(qUIListItemBackgroundType.getBackground(context, 1000));
        textView.setText(this.f317411a.getResources().getText(this.bottomConfig.b()));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.widget.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g.r(g.this, view2);
            }
        });
        ViewGroup b06 = this.f317412b.b0();
        b06.addView(view);
        b06.addView(textView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bottomConfig.c();
        this$0.f317412b.onBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final ColorStateList s(int id5) {
        ColorStateList colorStateList = this.f317411a.getResources().getColorStateList(id5, null);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "mContext.resources.getColorStateList(id, null)");
        return colorStateList;
    }

    private final void v() {
        this.f317413c.j(new e());
        k(this.selectData.e());
        int size = this.selectData.c().size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f317413c.setSelection(i3, this.selectData.c().get(i3).intValue());
        }
        i(new f());
        q();
    }

    @NotNull
    public final c t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.onSelectCallback;
    }

    @NotNull
    public final d u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.selectData;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull Context context, @NotNull d selectData, @NotNull c onSelectCallback, @Nullable a aVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(selectData, "selectData");
        Intrinsics.checkNotNullParameter(onSelectCallback, "onSelectCallback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, selectData, onSelectCallback, aVar);
            return;
        }
        this.selectData = selectData;
        this.onSelectCallback = onSelectCallback;
        this.bottomConfig = aVar;
        v();
    }
}
