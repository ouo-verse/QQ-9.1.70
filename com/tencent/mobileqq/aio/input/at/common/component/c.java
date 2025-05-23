package com.tencent.mobileqq.aio.input.at.common.component;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.at.common.CancelSelectItemEvent;
import com.tencent.mobileqq.aio.input.at.common.MultiSelectModeEvent;
import com.tencent.mobileqq.aio.input.at.common.SelectItemEvent;
import com.tencent.mobileqq.aio.input.at.common.SubmitListEvent;
import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.aio.input.at.common.component.a;
import com.tencent.mobileqq.aio.input.at.common.j;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\b*\u00012\u0018\u0000 8*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u0004:\u0001\u0014B\u0015\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\u00a2\u0006\u0004\b6\u00107J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001a0\u0019H\u0016R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00028\u0000028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/component/c;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "Lcom/tencent/mobileqq/aio/input/at/common/component/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", VideoTemplateParser.ITEM_LIST, "", "l", "i", "itemData", "g", h.F, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "k", "", "a", "j", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "d", "Lcom/tencent/mobileqq/aio/input/at/common/j;", "mDialogContext", "e", "Ljava/util/List;", "mItemList", "", "", "f", "Ljava/util/Set;", "mSelectedIdSet", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/a;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/a;", "mRecyclerViewAdapter", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mCanNotifyPreLoad", "com/tencent/mobileqq/aio/input/at/common/component/c$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/aio/input/at/common/component/c$b;", "mScrollListener", "<init>", "(Lcom/tencent/mobileqq/aio/input/at/common/j;)V", "D", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c<T extends com.tencent.mobileqq.aio.input.at.common.c> implements a, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b mScrollListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j<T> mDialogContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> mItemList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<String> mSelectedIdSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.aio.input.at.common.list.data.a<T> mRecyclerViewAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mCanNotifyPreLoad;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/component/c$a;", "", "", "PRE_LOAD_BUFF", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.at.common.component.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/input/at/common/component/c$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "", "onScrolled", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c<T> f189275d;

        b(c<T> cVar) {
            this.f189275d = cVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, recyclerView, Integer.valueOf(dx5), Integer.valueOf(dy5));
                return;
            }
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            com.tencent.mobileqq.aio.input.at.common.list.data.a aVar = ((c) this.f189275d).mRecyclerViewAdapter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRecyclerViewAdapter");
                aVar = null;
            }
            if (aVar.getNUM_BACKGOURND_ICON() - findLastVisibleItemPosition < 10 && ((c) this.f189275d).mCanNotifyPreLoad) {
                ((c) this.f189275d).mCanNotifyPreLoad = false;
                ((c) this.f189275d).mDialogContext.d().c();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53422);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull j<T> mDialogContext) {
        Intrinsics.checkNotNullParameter(mDialogContext, "mDialogContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mDialogContext);
            return;
        }
        this.mDialogContext = mDialogContext;
        this.mItemList = new ArrayList();
        this.mSelectedIdSet = new HashSet();
        this.mCanNotifyPreLoad = true;
        this.mScrollListener = new b(this);
    }

    private final void g(com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
        this.mSelectedIdSet.add(itemData.c());
        l(this.mItemList);
    }

    private final void h(com.tencent.mobileqq.aio.input.at.common.list.data.b itemData) {
        this.mSelectedIdSet.remove(itemData.c());
        l(this.mItemList);
    }

    private final void i() {
        l(this.mItemList);
    }

    private final void l(List<? extends com.tencent.mobileqq.aio.input.at.common.list.data.b> itemList) {
        this.mCanNotifyPreLoad = true;
        ArrayList arrayList = new ArrayList(itemList);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mobileqq.aio.input.at.common.list.data.b a16 = ((com.tencent.mobileqq.aio.input.at.common.list.data.b) arrayList.get(i3)).a();
            a16.i(this.mDialogContext.g());
            a16.h(this.mSelectedIdSet.contains(a16.c()));
            arrayList.set(i3, a16);
        }
        this.mItemList = arrayList;
        com.tencent.mobileqq.aio.input.at.common.list.data.a<T> aVar = this.mRecyclerViewAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRecyclerViewAdapter");
            aVar = null;
        }
        aVar.submitList(this.mItemList);
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public int a() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.mItemList.size() < this.mDialogContext.b().d()) {
            size = this.mDialogContext.b().d();
        } else {
            size = this.mItemList.size();
        }
        return size * this.mDialogContext.b().b();
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public void b(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            a.C7254a.c(this, z16);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(SubmitListEvent.class);
        arrayList.add(MultiSelectModeEvent.class);
        arrayList.add(SelectItemEvent.class);
        arrayList.add(CancelSelectItemEvent.class);
        return arrayList;
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @NotNull
    public View k(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        RecyclerView recyclerView = new RecyclerView(this.mDialogContext.c());
        recyclerView.setId(R.id.f82244gc);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mDialogContext.c(), 1, false));
        com.tencent.mobileqq.aio.input.at.common.list.data.a<T> aVar = new com.tencent.mobileqq.aio.input.at.common.list.data.a<>(this.mDialogContext);
        this.mRecyclerViewAdapter = aVar;
        recyclerView.setAdapter(aVar);
        recyclerView.addOnScrollListener(this.mScrollListener);
        recyclerView.setBackgroundDrawable(this.mDialogContext.c().getDrawable(R.drawable.j5p));
        this.mRecyclerView = recyclerView;
        return recyclerView;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.component.a
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) event);
            return;
        }
        if (event instanceof SubmitListEvent) {
            l(((SubmitListEvent) event).getItemList());
            return;
        }
        if (event instanceof MultiSelectModeEvent) {
            i();
        } else if (event instanceof SelectItemEvent) {
            g(((SelectItemEvent) event).getItemData());
        } else if (event instanceof CancelSelectItemEvent) {
            h(((CancelSelectItemEvent) event).getItemData());
        }
    }
}
