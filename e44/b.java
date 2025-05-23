package e44;

import a44.RequireData;
import a44.RequireFunction;
import a44.RequireList;
import a44.StyleData;
import a44.StyleFunction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.api.ability.d;
import com.tencent.robot.draw.vb.delegate.DrawListUIState;
import com.tencent.robot.draw.vb.e;
import com.tencent.robot.write.view.SelectData;
import com.tencent.robot.write.view.SelectListView;
import d44.b;
import e44.a;
import g74.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001\u0017B\u000f\u0012\u0006\u0010\"\u001a\u00020\u0004\u00a2\u0006\u0004\b8\u0010!J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\u0010\u001a\u00020\t2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\"\u0010\u0014\u001a\u00020\u00132\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\tH\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00180\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0003H\u0016R\"\u0010\"\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010*R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006:"}, d2 = {"Le44/b;", "Lcom/tencent/input/base/mvicompat/c;", "Le44/a;", "Lcom/tencent/robot/draw/vb/delegate/DrawListUIState;", "Lcom/tencent/robot/draw/vb/c;", "Lcom/tencent/robot/draw/vb/e;", "Lcom/tencent/robot/draw/vb/IDrawListVBDelegate;", "La44/a;", "data", "", h.F, "", "La44/b;", "requireData", "", "buttonName", "k", DomainData.DOMAIN_NAME, "selectedRequireData", "", "f", "binding", "j", "a", "Ljava/lang/Class;", "getObserverStates", "state", "i", "d", "Lcom/tencent/robot/draw/vb/c;", "g", "()Lcom/tencent/robot/draw/vb/c;", "o", "(Lcom/tencent/robot/draw/vb/c;)V", "mHost", "e", "Lcom/tencent/robot/draw/vb/e;", "mBinding", "Landroid/view/View;", "Landroid/view/View;", "mContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mStyleText", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mStyleList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mRequireText", "Lcom/tencent/robot/write/view/SelectListView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/write/view/SelectListView;", "mScaleSelectListView", "D", "La44/b;", "mSelectedRequireData", "<init>", "E", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements com.tencent.input.base.mvicompat.c<a, DrawListUIState, com.tencent.robot.draw.vb.c, e> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private SelectListView mScaleSelectListView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private RequireData mSelectedRequireData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.robot.draw.vb.c mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mStyleText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView mStyleList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mRequireText;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"e44/b$b", "Ld44/b$a;", "La44/f;", "data", "Ld44/b$c;", "holder", "", "position", "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e44.b$b, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C10219b implements b.a {
        C10219b() {
        }

        @Override // d44.b.a
        public void a(@Nullable StyleData data, @Nullable b.c holder, int position) {
            String str;
            b bVar = b.this;
            String str2 = null;
            if (data != null) {
                str = data.getStyleName();
            } else {
                str = null;
            }
            if (data != null) {
                str2 = data.getStyle();
            }
            bVar.m(new a.OnStyleListItemClick(str, str2));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"e44/b$c", "Lcom/tencent/robot/write/view/a;", "Lcom/tencent/robot/write/view/b;", "selectedData", "", "position", "", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c implements com.tencent.robot.write.view.a {
        c() {
        }

        @Override // com.tencent.robot.write.view.a
        public void a(@NotNull SelectData<?> selectedData, int position) {
            RequireData requireData;
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            Object b16 = selectedData.b();
            if (b16 instanceof RequireData) {
                requireData = (RequireData) b16;
            } else {
                requireData = null;
            }
            if (requireData == null) {
                return;
            }
            b.this.m(new a.OnRequireListItemClick(requireData.getName(), requireData.getData()));
            b.this.mSelectedRequireData = requireData;
        }

        @Override // com.tencent.robot.write.view.a
        public void b(@NotNull SelectData<?> selectedData, int position) {
            Intrinsics.checkNotNullParameter(selectedData, "selectedData");
            b.this.m(new a.OnRequireListItemClick(null, null));
            b.this.mSelectedRequireData = null;
        }
    }

    public b(@NotNull com.tencent.robot.draw.vb.c mHost) {
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        this.mHost = mHost;
    }

    private final int f(List<RequireData> requireData, RequireData selectedRequireData) {
        boolean z16;
        List<RequireData> list = requireData;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && selectedRequireData != null) {
            Iterator<RequireData> it = requireData.iterator();
            int i3 = -1;
            while (it.hasNext()) {
                i3++;
                if (Intrinsics.areEqual(it.next().getName(), selectedRequireData.getName())) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private final void h(a44.a data) {
        boolean z16;
        boolean z17;
        if (data != null && this.mContainer != null) {
            this.mSelectedRequireData = null;
            StyleFunction styleFunction = data.getStyleFunction();
            if (styleFunction != null) {
                TextView textView = this.mStyleText;
                if (textView != null) {
                    textView.setText(styleFunction.getTitle());
                }
                List<StyleData> a16 = styleFunction.a();
                if (a16 != null && !a16.isEmpty()) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    List<StyleData> a17 = styleFunction.a();
                    Intrinsics.checkNotNull(a17);
                    d44.b bVar = new d44.b(a17);
                    bVar.m0(new C10219b());
                    RecyclerView recyclerView = this.mStyleList;
                    if (recyclerView != null) {
                        recyclerView.setAdapter(bVar);
                    }
                }
            }
            RequireFunction requireFunction = data.getRequireFunction();
            if (requireFunction != null) {
                TextView textView2 = this.mRequireText;
                if (textView2 != null) {
                    textView2.setText(requireFunction.getTitle());
                }
                for (RequireList requireList : requireFunction.a()) {
                    if (Intrinsics.areEqual("size", requireList.getType())) {
                        List<RequireData> b16 = requireList.b();
                        if (b16 != null && !b16.isEmpty()) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            k(requireList.b(), requireList.getButtonName());
                        }
                    }
                }
            }
        }
    }

    private final void k(List<RequireData> requireData, String buttonName) {
        List<? extends SelectData<?>> emptyList;
        int collectionSizeOrDefault;
        String str;
        n();
        SelectListView selectListView = this.mScaleSelectListView;
        if (selectListView != null) {
            selectListView.setPlaceHolder(buttonName);
        }
        int f16 = f(requireData, this.mSelectedRequireData);
        if (f16 >= 0) {
            RequireData requireData2 = this.mSelectedRequireData;
            String str2 = null;
            if (requireData2 != null) {
                str = requireData2.getName();
            } else {
                str = null;
            }
            RequireData requireData3 = this.mSelectedRequireData;
            if (requireData3 != null) {
                str2 = requireData3.getData();
            }
            m(new a.OnRequireListItemClick(str, str2));
            SelectListView selectListView2 = this.mScaleSelectListView;
            if (selectListView2 != null) {
                selectListView2.setSelectedIndex(f16);
            }
        }
        SelectListView selectListView3 = this.mScaleSelectListView;
        if (selectListView3 != null) {
            selectListView3.setOnSelectedListener(new c());
        }
        SelectListView selectListView4 = this.mScaleSelectListView;
        if (selectListView4 != null) {
            if (requireData == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            } else {
                List<RequireData> list = requireData;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                emptyList = new ArrayList<>(collectionSizeOrDefault);
                for (RequireData requireData4 : list) {
                    emptyList.add(new SelectData(requireData4.getName(), requireData4));
                }
            }
            selectListView4.k(emptyList);
        }
    }

    private final void n() {
        a.GetAnchorViewIntent getAnchorViewIntent = new a.GetAnchorViewIntent(null, 1, null);
        m(getAnchorViewIntent);
        View anchorView = getAnchorViewIntent.getAnchorView();
        if (anchorView != null) {
            SelectListView selectListView = this.mScaleSelectListView;
            if (selectListView != null) {
                selectListView.setBubbleLocationStrategy(new a.c(anchorView));
                return;
            }
            return;
        }
        SelectListView selectListView2 = this.mScaleSelectListView;
        if (selectListView2 != null) {
            selectListView2.l();
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull DrawListUIState drawListUIState) {
        c.a.a(this, drawListUIState);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        c.a.e(this, bVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: g, reason: from getter */
    public com.tencent.robot.draw.vb.c getMHost() {
        return this.mHost;
    }

    @Override // com.tencent.mvi.api.ability.c
    @MainThread
    @Nullable
    public Bundle generateVBState(@NotNull d dVar) {
        return c.a.c(this, dVar);
    }

    @Override // com.tencent.input.base.mvicompat.c
    @NotNull
    public List<Class<? extends DrawListUIState>> getObserverStates() {
        List<Class<? extends DrawListUIState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(DrawListUIState.SubmitListUIState.class);
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull DrawListUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof DrawListUIState.SubmitListUIState) {
            h(((DrawListUIState.SubmitListUIState) state).getData());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull e binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        View container = binding.getContainer();
        this.mContainer = container;
        if (container != null) {
            container.setBackgroundColor(container.getContext().getColor(R.color.qui_common_bg_middle_light));
            this.mStyleText = (TextView) container.findViewById(R.id.f898850z);
            this.mStyleList = (RecyclerView) container.findViewById(R.id.f898650x);
            this.mRequireText = (TextView) container.findViewById(R.id.f73613u1);
            SelectListView selectListView = (SelectListView) container.findViewById(R.id.f795049y);
            this.mScaleSelectListView = selectListView;
            if (selectListView != null) {
                selectListView.setImageResource(R.drawable.qui_chevron_down_icon_secondary);
            }
            RecyclerView recyclerView = this.mStyleList;
            if (recyclerView != null) {
                recyclerView.addItemDecoration(new b.C10159b(com.tencent.qqnt.base.utils.c.f353052a.b(6)));
            }
        }
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull a aVar) {
        c.a.f(this, aVar);
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.robot.draw.vb.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<set-?>");
        this.mHost = cVar;
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        c.a.d(this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
    }
}
