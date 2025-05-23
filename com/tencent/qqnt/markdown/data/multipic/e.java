package com.tencent.qqnt.markdown.data.multipic;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/e;", "Lcom/tencent/qqnt/markdown/a;", "Lcom/tencent/qqnt/markdown/data/multipic/MultiPicRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "f", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/markdown/data/b;", "data", "Landroid/view/View;", "d", "e", "<init>", "()V", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e extends com.tencent.qqnt.markdown.a<MultiPicRecyclerView> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/markdown/data/multipic/e$a;", "", "", "MAX_PIC_COUNT", "I", "", "STATUS_LOADING", "Ljava/lang/String;", "TAG", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.data.multipic.e$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/markdown/data/multipic/e$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f359392a;

        b(List<String> list) {
            this.f359392a = list;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, position)).intValue();
            }
            if ((position != 1 || this.f359392a.size() <= 2) && position != 2) {
                return 2;
            }
            return 1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34965);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f(RecyclerView recyclerView) {
        int itemDecorationCount = recyclerView.getItemDecorationCount();
        for (int i3 = 0; i3 < itemDecorationCount; i3++) {
            recyclerView.removeItemDecorationAt(i3);
        }
    }

    @Override // com.tencent.qqnt.markdown.a
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public View a(@NotNull Context context, @NotNull com.tencent.qqnt.markdown.data.b data, @NotNull MultiPicRecyclerView recyclerView) {
        int i3;
        int i16;
        List<String> list;
        RecyclerView.ItemDecoration hVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, context, data, recyclerView);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        com.tencent.qqnt.markdown.data.c c16 = data.c();
        if (c16 == null) {
            return null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("MultiPicRender", 4, "[render]");
        }
        int a16 = c16.a();
        if (a16 == 0) {
            i3 = ViewUtils.dpToPx(12.0f);
        } else {
            i3 = 0;
        }
        int b16 = data.b();
        if (a16 == 0) {
            i16 = ((data.b() - ViewUtils.dpToPx(4.0f)) / 2) + i3;
        } else {
            i16 = -2;
        }
        recyclerView.setLayoutParams(new ConstraintLayout.LayoutParams(b16, i16));
        List<String> b17 = c16.b();
        if (b17.size() > 5) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(b17.subList(0, 5));
            list = arrayList;
        } else {
            list = b17;
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, c16.c());
        if (a16 == 0) {
            gridLayoutManager.setSpanSizeLookup(new b(list));
        }
        gridLayoutManager.setOrientation(a16);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(new com.tencent.qqnt.markdown.data.multipic.b(list, b17, b16, i16 - i3, a16, c16.c()));
        f(recyclerView);
        if (a16 == 0) {
            hVar = new a(ViewUtils.dpToPx(4.0f));
        } else {
            hVar = new h(ViewUtils.dpToPx(4.0f), c16.c());
        }
        recyclerView.addItemDecoration(hVar);
        recyclerView.setPadding(0, i3, 0, 0);
        return recyclerView;
    }

    @Override // com.tencent.qqnt.markdown.a
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MultiPicRecyclerView b(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MultiPicRecyclerView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return new MultiPicRecyclerView(context);
    }
}
