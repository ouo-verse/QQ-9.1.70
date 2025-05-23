package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u000f\u0018\u0000 L2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ \u0010\t\u001a\u00020\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000eH\u0016J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016R)\u0010(\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\"0\"0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R0\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u0010>\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R0\u0010C\u001a\u0010\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\b\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00101\u001a\u0004\bA\u00103\"\u0004\bB\u00105R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/qqnt/aio/assistedchat/model/c;", "items", "Ljava/lang/Runnable;", "commitCallback", "", "u0", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "emptyData", "s0", "v0", "", "subPanelId", "t0", "", "m0", "n0", "position", "", "getItemId", "getItemCount", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "onCreateViewHolder", "holder", "onBindViewHolder", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/e;", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "j0", "()Landroidx/recyclerview/widget/AsyncListDiffer;", "differ", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashSet;", "hasImpReportSet", "Lkotlin/Function1;", "D", "Lkotlin/jvm/functions/Function1;", "k0", "()Lkotlin/jvm/functions/Function1;", "p0", "(Lkotlin/jvm/functions/Function1;)V", "itemClickListener", "Lkotlin/Function0;", "E", "Lkotlin/jvm/functions/Function0;", "l0", "()Lkotlin/jvm/functions/Function0;", "q0", "(Lkotlin/jvm/functions/Function0;)V", "retryClickListener", "", UserInfo.SEX_FEMALE, "getGuideClickListener", "o0", "guideClickListener", "G", "Ljava/lang/Integer;", "getSubPanelId", "()Ljava/lang/Integer;", "r0", "(Ljava/lang/Integer;)V", "<init>", "()V", "H", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatSubPanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final HashSet<String> hasImpReportSet;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Function1<? super com.tencent.qqnt.aio.assistedchat.model.c, Unit> itemClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> retryClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function1<? super CharSequence, Unit> guideClickListener;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Integer subPanelId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy differ;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelAdapter$a;", "", "", "VIEW_TYPE_EMPTY", "I", "VIEW_TYPE_ITEM", "VIEW_TYPE_LOADING", "VIEW_TYPE_POLISH_GUIDE", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelAdapter$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59598);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AssistedChatSubPanelAdapter() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<AsyncListDiffer<e>>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelAdapter$differ$2
                static IPatchRedirector $redirector_;

                @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/assistedchat/panel/subpanel/AssistedChatSubPanelAdapter$differ$2$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/e;", "oldItem", "newItem", "", "b", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes23.dex */
                public static final class a extends DiffUtil.ItemCallback<e> {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public boolean areContentsTheSame(@NotNull e oldItem, @NotNull e newItem) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                        }
                        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                        Intrinsics.checkNotNullParameter(newItem, "newItem");
                        if (newItem.c() == 4 || newItem.c() == 2 || oldItem.c() != newItem.c() || !Intrinsics.areEqual(oldItem.b(), newItem.b())) {
                            return false;
                        }
                        return true;
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public boolean areItemsTheSame(@NotNull e oldItem, @NotNull e newItem) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
                        }
                        Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                        Intrinsics.checkNotNullParameter(newItem, "newItem");
                        if (oldItem.c() == newItem.c() && Intrinsics.areEqual(oldItem.b(), newItem.b())) {
                            return true;
                        }
                        return false;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatSubPanelAdapter.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final AsyncListDiffer<e> invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new AsyncListDiffer<>(AssistedChatSubPanelAdapter.this, new a()) : (AsyncListDiffer) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.differ = lazy;
            this.hasImpReportSet = new HashSet<>();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final AsyncListDiffer<e> j0() {
        return (AsyncListDiffer) this.differ.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return j0().getCurrentList().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this, position)).longValue();
        }
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, position)).intValue();
        }
        return j0().getCurrentList().get(position).c();
    }

    @Nullable
    public final Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function1) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.itemClickListener;
    }

    @Nullable
    public final Function0<Unit> l0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Function0) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.retryClickListener;
    }

    public final boolean m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        List<e> currentList = j0().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "differ.currentList");
        Iterator<T> it = currentList.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).c() == 1) {
                return false;
            }
        }
        return true;
    }

    public final boolean n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (j0().getCurrentList().size() != 1 || j0().getCurrentList().get(0).c() != 3) {
            return false;
        }
        return true;
    }

    public final void o0(@Nullable Function1<? super CharSequence, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) function1);
        } else {
            this.guideClickListener = function1;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<e> currentList = j0().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "differ.currentList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(currentList, position);
        e eVar = (e) orNull;
        if (eVar != null && (holder instanceof f)) {
            ((f) holder).l(eVar, position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 19, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType != 3) {
                    if (viewType == 4) {
                        Context context = parent.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                        c cVar = new c(context);
                        cVar.p(this.guideClickListener);
                        return cVar;
                    }
                    throw new IllegalArgumentException("illegal viewType " + viewType);
                }
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                return new l(context2);
            }
            Context context3 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
            h hVar = new h(context3);
            hVar.r(new Function0<Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelAdapter$onCreateViewHolder$2$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatSubPanelAdapter.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Function0<Unit> l06 = AssistedChatSubPanelAdapter.this.l0();
                    if (l06 != null) {
                        l06.invoke();
                    }
                }
            });
            return hVar;
        }
        Context context4 = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
        k kVar = new k(context4);
        kVar.v(new Function2<View, com.tencent.qqnt.aio.assistedchat.model.c, Boolean>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelAdapter$onCreateViewHolder$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatSubPanelAdapter.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Boolean invoke(@NotNull View view, @NotNull com.tencent.qqnt.aio.assistedchat.model.c recommend) {
                HashSet hashSet;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) recommend);
                }
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(recommend, "recommend");
                hashSet = AssistedChatSubPanelAdapter.this.hasImpReportSet;
                return Boolean.valueOf(hashSet.add(recommend.a()));
            }
        });
        kVar.u(new Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit>() { // from class: com.tencent.qqnt.aio.assistedchat.panel.subpanel.AssistedChatSubPanelAdapter$onCreateViewHolder$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AssistedChatSubPanelAdapter.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.qqnt.aio.assistedchat.model.c cVar2) {
                invoke2(cVar2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.qqnt.aio.assistedchat.model.c recommend) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) recommend);
                    return;
                }
                Intrinsics.checkNotNullParameter(recommend, "recommend");
                Function1<com.tencent.qqnt.aio.assistedchat.model.c, Unit> k06 = AssistedChatSubPanelAdapter.this.k0();
                if (k06 != null) {
                    k06.invoke(recommend);
                }
            }
        });
        kVar.w(this.subPanelId);
        return kVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (holder instanceof f) {
            ((f) holder).m();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof f) {
            ((f) holder).o();
        }
    }

    public final void p0(@Nullable Function1<? super com.tencent.qqnt.aio.assistedchat.model.c, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function1);
        } else {
            this.itemClickListener = function1;
        }
    }

    public final void q0(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) function0);
        } else {
            this.retryClickListener = function0;
        }
    }

    public final void r0(@Nullable Integer num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) num);
        } else {
            this.subPanelId = num;
        }
    }

    public final void s0(@Nullable a emptyData) {
        List<e> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) emptyData);
            return;
        }
        AsyncListDiffer<e> j06 = j0();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new e(2, null, emptyData));
        j06.submitList(listOf);
    }

    public final void t0(int subPanelId) {
        List<e> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, subPanelId);
        } else if (subPanelId == 2) {
            AsyncListDiffer<e> j06 = j0();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new e(4, null, null, 6, null));
            j06.submitList(listOf);
        }
    }

    public final void u0(@NotNull List<com.tencent.qqnt.aio.assistedchat.model.c> items, @Nullable Runnable commitCallback) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) items, (Object) commitCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        AsyncListDiffer<e> j06 = j0();
        List<com.tencent.qqnt.aio.assistedchat.model.c> list = items;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new e(1, (com.tencent.qqnt.aio.assistedchat.model.c) it.next(), null, 4, null));
        }
        j06.submitList(arrayList, commitCallback);
    }

    public final void v0() {
        List<e> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        AsyncListDiffer<e> j06 = j0();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new e(3, null, null, 6, null));
        j06.submitList(listOf);
    }
}
