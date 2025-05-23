package com.tencent.mobileqq.troop.troopblacklist.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopblacklist.model.a;
import com.tencent.mobileqq.troop.troopblacklist.model.b;
import com.tencent.mobileqq.troop.troopblacklist.model.c;
import com.tencent.mobileqq.troop.troopblacklist.model.d;
import com.tencent.mobileqq.troop.troopblacklist.model.e;
import com.tencent.mobileqq.troop.troopblacklist.viewmodel.TroopBlackListViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.at.widget.IndexBar;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001@B\u001f\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010.\u001a\u00020)\u00a2\u0006\u0004\b=\u0010>J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0014\u001a\u00020\u0010R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00107\u001a\u0004\u0018\u00010/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00109R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/view/adapter/TroopBlackListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "q0", "", "m0", "Lcom/tencent/mobileqq/troop/troopblacklist/model/e;", "uiModel", "p0", "isRemoveState", "r0", "isReachMaxSelectCount", "o0", "", "indexString", "", "k0", "firstVisiblePos", "n0", "position", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "viewHolder", "onBindViewHolder", "getItemCount", "Lcom/tencent/mobileqq/troop/troopblacklist/model/a;", "l0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/at/widget/IndexBar;", "indexBar", "Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;", "D", "Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;", "viewModel", "Lcom/tencent/mobileqq/troop/troopblacklist/model/d;", "E", "Lkotlin/Lazy;", "j0", "()Lcom/tencent/mobileqq/troop/troopblacklist/model/d;", "headerTipModel", UserInfo.SEX_FEMALE, "i0", "footerTipModel", "G", "Z", "H", "I", "Lcom/tencent/mobileqq/troop/troopblacklist/model/e;", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/aio/at/widget/IndexBar;Lcom/tencent/mobileqq/troop/troopblacklist/viewmodel/TroopBlackListViewModel;)V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"NotifyDataSetChanged"})
/* loaded from: classes19.dex */
public final class TroopBlackListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IndexBar indexBar;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TroopBlackListViewModel viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy headerTipModel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy footerTipModel;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isRemoveState;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isReachMaxSelectCount;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private e uiModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopblacklist/view/adapter/TroopBlackListAdapter$a;", "", "", "INDEX_VIEW_VISIBLE_MIN_MEMBER_COUNT", "I", "VIEW_TYPE_INDEX", "VIEW_TYPE_MEMBER", "VIEW_TYPE_TIP", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopblacklist.view.adapter.TroopBlackListAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56925);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopBlackListAdapter(@NotNull Context context, @NotNull IndexBar indexBar, @NotNull TroopBlackListViewModel viewModel) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(indexBar, "indexBar");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, indexBar, viewModel);
            return;
        }
        this.context = context;
        this.indexBar = indexBar;
        this.viewModel = viewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.troop.troopblacklist.view.adapter.TroopBlackListAdapter$headerTipModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopBlackListAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                String string = TroopBlackListAdapter.this.getContext().getString(R.string.f2325974z);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026roop_black_list_top_tips)");
                return new d(string);
            }
        });
        this.headerTipModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(TroopBlackListAdapter$footerTipModel$2.INSTANCE);
        this.footerTipModel = lazy2;
        this.uiModel = new e(null, null, 3, null);
    }

    private final d i0() {
        return (d) this.footerTipModel.getValue();
    }

    private final d j0() {
        return (d) this.headerTipModel.getValue();
    }

    private final boolean m0() {
        Iterator<T> it = this.uiModel.b().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((a) it.next()) instanceof c) {
                i3++;
            }
            if (i3 > 10) {
                return true;
            }
        }
        return false;
    }

    private final void q0() {
        if (!m0()) {
            this.indexBar.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.uiModel.a().iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Character) it.next()).charValue()));
        }
        this.indexBar.setVisibility(0);
        IndexBar indexBar = this.indexBar;
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        indexBar.setLetters((String[]) array);
        this.indexBar.setChooseIndex(0);
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.uiModel.b().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, position)).intValue();
        }
        a l06 = l0(position);
        if (l06 instanceof d) {
            return 0;
        }
        if (l06 instanceof b) {
            return 1;
        }
        return 2;
    }

    public final int k0(@NotNull String indexString) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) indexString)).intValue();
        }
        Intrinsics.checkNotNullParameter(indexString, "indexString");
        int i3 = 0;
        for (Object obj : this.uiModel.b()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            a aVar = (a) obj;
            if ((aVar instanceof b) && Intrinsics.areEqual(String.valueOf(((b) aVar).b()), indexString)) {
                return i3;
            }
            i3 = i16;
        }
        return 0;
    }

    @Nullable
    public final a l0(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (a) iPatchRedirector.redirect((short) 13, (Object) this, position);
        }
        if (position >= 0 && position < getNUM_BACKGOURND_ICON()) {
            return this.uiModel.b().get(position);
        }
        return null;
    }

    public final void n0(int firstVisiblePos) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, firstVisiblePos);
            return;
        }
        String[] c16 = this.indexBar.c();
        if (c16 == null) {
            return;
        }
        int length = c16.length;
        boolean z16 = false;
        if (firstVisiblePos < 0) {
            this.indexBar.setChooseIndex(0);
            return;
        }
        if (firstVisiblePos >= getNUM_BACKGOURND_ICON()) {
            this.indexBar.setChooseIndex(length - 1);
            return;
        }
        a l06 = l0(firstVisiblePos);
        if (l06 instanceof b) {
            String[] c17 = this.indexBar.c();
            Intrinsics.checkNotNullExpressionValue(c17, "indexBar.letters");
            i3 = ArraysKt___ArraysKt.indexOf(c17, String.valueOf(((b) l06).b()));
        } else if (l06 instanceof c) {
            String[] c18 = this.indexBar.c();
            Intrinsics.checkNotNullExpressionValue(c18, "indexBar.letters");
            i3 = ArraysKt___ArraysKt.indexOf(c18, String.valueOf(((c) l06).a()));
        } else {
            i3 = -1;
        }
        if (i3 >= 0 && i3 < length) {
            z16 = true;
        }
        if (z16) {
            this.indexBar.setChooseIndex(i3);
        }
    }

    public final void o0(boolean isReachMaxSelectCount) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isReachMaxSelectCount);
        } else if (this.isReachMaxSelectCount != isReachMaxSelectCount) {
            this.isReachMaxSelectCount = isReachMaxSelectCount;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        a l06 = l0(position);
        if ((viewHolder instanceof com.tencent.mobileqq.troop.troopblacklist.view.viewholder.e) && (l06 instanceof d)) {
            ((com.tencent.mobileqq.troop.troopblacklist.view.viewholder.e) viewHolder).l((d) l06);
            return;
        }
        if ((viewHolder instanceof com.tencent.mobileqq.troop.troopblacklist.view.viewholder.a) && (l06 instanceof b)) {
            ((com.tencent.mobileqq.troop.troopblacklist.view.viewholder.a) viewHolder).l((b) l06);
        } else if ((viewHolder instanceof com.tencent.mobileqq.troop.troopblacklist.view.viewholder.d) && (l06 instanceof c)) {
            ((com.tencent.mobileqq.troop.troopblacklist.view.viewholder.d) viewHolder).n((c) l06, this.isRemoveState, this.viewModel);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 10, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 0) {
            if (viewType != 1) {
                View inflate = LayoutInflater.from(this.context).inflate(R.layout.hyo, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026list_item, parent, false)");
                return new com.tencent.mobileqq.troop.troopblacklist.view.viewholder.d(inflate, this.context);
            }
            View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.hyn, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "from(context).inflate(R.\u2026ist_index, parent, false)");
            return new com.tencent.mobileqq.troop.troopblacklist.view.viewholder.a(inflate2);
        }
        View inflate3 = LayoutInflater.from(this.context).inflate(R.layout.hyp, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "from(context).inflate(R.\u2026t_top_tip, parent, false)");
        return new com.tencent.mobileqq.troop.troopblacklist.view.viewholder.e(inflate3);
    }

    public final void p0(@NotNull e uiModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) uiModel);
            return;
        }
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        this.uiModel = uiModel;
        uiModel.b().add(0, j0());
        d i06 = i0();
        if (i06 != null) {
            uiModel.b().add(i06);
        }
        q0();
        notifyDataSetChanged();
    }

    public final void r0(boolean isRemoveState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isRemoveState);
        } else if (this.isRemoveState != isRemoveState) {
            this.isRemoveState = isRemoveState;
            notifyDataSetChanged();
        }
    }
}
