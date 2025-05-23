package com.tencent.mobileqq.aio.input.at.common.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.common.InitIndexEvent;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.aio.input.at.common.component.a;
import com.tencent.mobileqq.aio.input.at.common.j;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.at.widget.IndexBar;
import com.tencent.qqnt.aio.at.widget.IndexBarTipsLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001;\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u0006B\u0015\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000 \u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001e0\u001dH\u0016R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010$R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u00101R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R*\u0010:\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000b07\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/component/b;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Lcom/tencent/mobileqq/aio/input/at/common/component/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/qqnt/aio/at/widget/IndexBar$a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "f", "", "a", "", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "isHalf", "b", "", "letter", "action", "", com.tencent.luggage.wxa.c8.c.G, "p1", "touching", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "d", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "Landroid/view/View;", "mRootView", "Landroid/view/ViewGroup;", "mIndexRoot", "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", h.F, "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", "mIndexBar", "Lcom/tencent/qqnt/aio/at/widget/IndexBarTipsLayout;", "i", "Lcom/tencent/qqnt/aio/at/widget/IndexBarTipsLayout;", "mTipsLayout", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mSelectedIndexStr", "", "Lkotlin/Pair;", "D", "Ljava/util/List;", "mAlphabetIndex", "com/tencent/mobileqq/aio/input/at/common/component/b$a", "E", "Lcom/tencent/mobileqq/aio/input/at/common/component/b$a;", "mScrollListener", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b<T extends com.tencent.mobileqq.aio.input.at.common.c> implements com.tencent.mobileqq.aio.input.at.common.component.a, SimpleEventReceiver<SimpleBaseEvent>, IndexBar.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String mSelectedIndexStr;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private List<Pair<String, Integer>> mAlphabetIndex;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private a mScrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j<T> mDialogContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mRootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mIndexRoot;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IndexBar mIndexBar;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private IndexBarTipsLayout mTipsLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/input/at/common/component/b$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b<T> f189268d;

        a(b<T> bVar) {
            this.f189268d = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Object last;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            List list = ((b) this.f189268d).mAlphabetIndex;
            if (list != null) {
                b<T> bVar = this.f189268d;
                if (list.isEmpty()) {
                    return;
                }
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager2).findLastVisibleItemPosition();
                last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                IndexBar indexBar = null;
                if (findFirstVisibleItemPosition >= ((Number) ((Pair) last).getSecond()).intValue()) {
                    IndexBar indexBar2 = ((b) bVar).mIndexBar;
                    if (indexBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mIndexBar");
                    } else {
                        indexBar = indexBar2;
                    }
                    indexBar.setChooseIndex(list.size() - 1);
                    return;
                }
                int size = list.size() - 1;
                for (int i3 = 0; i3 < size; i3++) {
                    if (findFirstVisibleItemPosition == ((Number) ((Pair) list.get(i3)).getSecond()).intValue() || (findFirstVisibleItemPosition > ((Number) ((Pair) list.get(i3)).getSecond()).intValue() && findLastVisibleItemPosition < ((Number) ((Pair) list.get(i3 + 1)).getSecond()).intValue())) {
                        IndexBar indexBar3 = ((b) bVar).mIndexBar;
                        if (indexBar3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mIndexBar");
                        } else {
                            indexBar = indexBar3;
                        }
                        indexBar.setChooseIndex(i3);
                        return;
                    }
                }
            }
        }
    }

    public b(@NotNull j<T> mDialogContext) {
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext);
            return;
        }
        this.mDialogContext = mDialogContext;
        this.mSelectedIndexStr = "";
        this.mScrollListener = new a(this);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public void b(boolean isHalf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isHalf);
            return;
        }
        ViewGroup viewGroup = null;
        if (isHalf) {
            ViewGroup viewGroup2 = this.mIndexRoot;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexRoot");
            } else {
                viewGroup = viewGroup2;
            }
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup3 = this.mIndexRoot;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndexRoot");
        } else {
            viewGroup = viewGroup3;
        }
        viewGroup.setVisibility(0);
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a.C7254a.a(this);
        IndexBar indexBar = this.mIndexBar;
        RecyclerView recyclerView = null;
        if (indexBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIndexBar");
            indexBar = null;
        }
        indexBar.setOnIndexBarTouchListener(this);
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.addOnScrollListener(this.mScrollListener);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @NotNull
    public View f(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(this.mDialogContext.c()).inflate(R.layout.dua, parent, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(mDialogContext.getC\u2026ent_layout, parent, true)");
        this.mRootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.llv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.index_layout)");
        this.mIndexRoot = (ViewGroup) findViewById;
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.djh);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.index_view)");
        this.mIndexBar = (IndexBar) findViewById2;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.dji);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.indexbar_tips_view)");
        this.mTipsLayout = (IndexBarTipsLayout) findViewById3;
        View findViewById4 = parent.findViewById(R.id.f82244gc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "parent.findViewById(R.id\u2026elect_item_recycler_view)");
        this.mRecyclerView = (RecyclerView) findViewById4;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            return null;
        }
        return view3;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(InitIndexEvent.class);
        return arrayList;
    }

    @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
    public void m(boolean touching) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 8;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, touching);
            return;
        }
        if (!touching) {
            this.mSelectedIndexStr = "";
        }
        IndexBarTipsLayout indexBarTipsLayout = this.mTipsLayout;
        if (indexBarTipsLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipsLayout");
            indexBarTipsLayout = null;
        }
        if (touching) {
            i3 = 0;
        }
        indexBarTipsLayout.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        a.C7254a.b(this);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
            recyclerView = null;
        }
        recyclerView.removeOnScrollListener(this.mScrollListener);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event);
            return;
        }
        if (event instanceof InitIndexEvent) {
            InitIndexEvent initIndexEvent = (InitIndexEvent) event;
            this.mAlphabetIndex = initIndexEvent.getAlphabetIndex();
            IndexBar indexBar = this.mIndexBar;
            if (indexBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIndexBar");
                indexBar = null;
            }
            List<Pair<String, Integer>> alphabetIndex = initIndexEvent.getAlphabetIndex();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(alphabetIndex, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = alphabetIndex.iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Pair) it.next()).getFirst());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            indexBar.setLetters((String[]) array);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.qqnt.aio.at.widget.IndexBar.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p1(@NotNull String letter, int action, float pos) {
        Integer num;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, letter, Integer.valueOf(action), Float.valueOf(pos));
            return;
        }
        Intrinsics.checkNotNullParameter(letter, "letter");
        IndexBarTipsLayout indexBarTipsLayout = this.mTipsLayout;
        RecyclerView recyclerView = null;
        if (indexBarTipsLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipsLayout");
            indexBarTipsLayout = null;
        }
        indexBarTipsLayout.setText(letter, pos);
        if (!Intrinsics.areEqual(this.mSelectedIndexStr, letter)) {
            this.mSelectedIndexStr = letter;
            List<Pair<String, Integer>> list = this.mAlphabetIndex;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((Pair) obj).getFirst(), letter)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                Pair pair = (Pair) obj;
                if (pair != null) {
                    num = (Integer) pair.getSecond();
                    if (num == null) {
                        RecyclerView recyclerView2 = this.mRecyclerView;
                        if (recyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
                        } else {
                            recyclerView = recyclerView2;
                        }
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        if (linearLayoutManager != null) {
                            linearLayoutManager.scrollToPositionWithOffset(num.intValue(), 0);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            num = null;
            if (num == null) {
            }
        }
    }
}
