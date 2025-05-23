package com.tencent.mobileqq.qqshop.publicaccount.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00019BR\u0012\u0016\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000203j\b\u0012\u0004\u0012\u00020\u0002`4\u0012\u0006\u0010\u001e\u001a\u00020\n\u0012\u0006\u0010!\u001a\u00020\r\u0012!\u0010+\u001a\u001d\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060\"\u00a2\u0006\u0004\b6\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016J\"\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0003H\u0016R\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R2\u0010+\u001a\u001d\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060\"8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u001dR2\u00102\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030.j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003`/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/HeadCardAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/AdCardHolder;", "", "list", "", "submitList", "Ljava/lang/Runnable;", "commitCallback", "", "position", "n0", "", "stop", "p0", "o0", "getItemViewType", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "holder", "l0", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "q0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "headPosition", BdhLogUtil.LogTag.Tag_Conn, "Z", "isLastMsg", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "msgId", "D", "Lkotlin/jvm/functions/Function1;", "k0", "()Lkotlin/jvm/functions/Function1;", "deleteListener", "E", "selectItem", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "holderMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "adCardModels", "<init>", "(Ljava/util/ArrayList;IZLkotlin/jvm/functions/Function1;)V", "G", "b", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class HeadCardAdapter extends ListAdapter<p, AdCardHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final a H;

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean isLastMsg;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<Long, Unit> deleteListener;

    /* renamed from: E, reason: from kotlin metadata */
    private int selectItem;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private HashMap<Integer, AdCardHolder> holderMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int headPosition;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqshop/publicaccount/adapter/HeadCardAdapter$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/p;", "oldItem", "newItem", "", "b", "a", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends DiffUtil.ItemCallback<p> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull p oldItem, @NotNull p newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull p oldItem, @NotNull p newItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) oldItem, (Object) newItem)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            if (oldItem == newItem) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/HeadCardAdapter$b;", "", "", "DEFAULT_AD_CARD", "I", "com/tencent/mobileqq/qqshop/publicaccount/adapter/HeadCardAdapter$a", "ITEM_CALLBACK", "Lcom/tencent/mobileqq/qqshop/publicaccount/adapter/HeadCardAdapter$a;", "", "TAG", "Ljava/lang/String;", "VERTICAL_AD_CARD", "VERTICAL_VIDEO_AD_CARD", "VIDEO_AD_CARD", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqshop.publicaccount.adapter.HeadCardAdapter$b, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
            H = new a();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeadCardAdapter(@NotNull ArrayList<p> adCardModels, int i3, boolean z16, @NotNull Function1<? super Long, Unit> deleteListener) {
        super(H);
        Intrinsics.checkNotNullParameter(adCardModels, "adCardModels");
        Intrinsics.checkNotNullParameter(deleteListener, "deleteListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, adCardModels, Integer.valueOf(i3), Boolean.valueOf(z16), deleteListener);
            return;
        }
        this.headPosition = i3;
        this.isLastMsg = z16;
        this.deleteListener = deleteListener;
        this.selectItem = -1;
        this.holderMap = new HashMap<>();
        submitList(adCardModels);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(HeadCardAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.holderMap.clear();
        this$0.selectItem = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(HeadCardAdapter this$0, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.holderMap.clear();
        this$0.selectItem = -1;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, position)).intValue();
        }
        p item = getItem(position);
        if (item.m().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !AdVideoCardHolder.INSTANCE.c()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (item.p()) {
            if (z17) {
                return 3;
            }
            return 2;
        }
        if (z17) {
            return 1;
        }
        return 0;
    }

    @NotNull
    public final Function1<Long, Unit> k0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function1) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.deleteListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull AdCardHolder holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        p adCardModel = getItem(position);
        Intrinsics.checkNotNullExpressionValue(adCardModel, "adCardModel");
        holder.B(adCardModel, this.headPosition);
        holder.J(new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.HeadCardAdapter$onBindViewHolder$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HeadCardAdapter.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    HeadCardAdapter.this.k0().invoke(Long.valueOf(j3));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                }
            }
        });
        this.holderMap.put(Integer.valueOf(position), holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public AdCardHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        AdCardHolder adVideoCardHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (AdCardHolder) iPatchRedirector.redirect((short) 9, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                if (viewType != 3) {
                    View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.h4n, parent, false);
                    Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
                    adVideoCardHolder = new AdCardHolder((ViewGroup) inflate);
                } else {
                    View inflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.h4o, parent, false);
                    Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
                    adVideoCardHolder = new AdVerticalVideoCardHolder((ViewGroup) inflate2);
                }
            } else {
                View inflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.h4o, parent, false);
                Intrinsics.checkNotNull(inflate3, "null cannot be cast to non-null type android.view.ViewGroup");
                adVideoCardHolder = new AdVerticalCardHolder((ViewGroup) inflate3);
            }
        } else {
            View inflate4 = LayoutInflater.from(parent.getContext()).inflate(R.layout.h4n, parent, false);
            Intrinsics.checkNotNull(inflate4, "null cannot be cast to non-null type android.view.ViewGroup");
            adVideoCardHolder = new AdVideoCardHolder((ViewGroup) inflate4);
        }
        adVideoCardHolder.L(this.isLastMsg);
        return adVideoCardHolder;
    }

    public final void n0(int position) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, position);
            return;
        }
        if (position != this.selectItem) {
            QLog.d("HeadCardAdapter", 4, "onPageSelected headPosition=" + this.headPosition + " position=" + position + " isLastMsg=" + this.isLastMsg);
            for (Map.Entry<Integer, AdCardHolder> entry : this.holderMap.entrySet()) {
                int intValue = entry.getKey().intValue();
                AdCardHolder value = entry.getValue();
                if (intValue == position) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                value.M(z16);
            }
            this.selectItem = position;
        }
    }

    public final void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<Map.Entry<Integer, AdCardHolder>> it = this.holderMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().E();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) recyclerView);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.setOverScrollMode(2);
    }

    public final void p0(boolean stop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, stop);
            return;
        }
        Iterator<Map.Entry<Integer, AdCardHolder>> it = this.holderMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().H(stop);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(@NotNull AdCardHolder holder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) holder);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        holder.I();
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<p> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            super.submitList(list, new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.o
                @Override // java.lang.Runnable
                public final void run() {
                    HeadCardAdapter.r0(HeadCardAdapter.this);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
        }
    }

    @Override // androidx.recyclerview.widget.ListAdapter
    public void submitList(@Nullable List<p> list, @Nullable final Runnable commitCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            super.submitList(list, new Runnable() { // from class: com.tencent.mobileqq.qqshop.publicaccount.adapter.n
                @Override // java.lang.Runnable
                public final void run() {
                    HeadCardAdapter.s0(HeadCardAdapter.this, commitCallback);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list, (Object) commitCallback);
        }
    }
}
