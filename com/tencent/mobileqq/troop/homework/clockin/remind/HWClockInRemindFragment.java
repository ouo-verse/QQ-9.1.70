package com.tencent.mobileqq.troop.homework.clockin.remind;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.remind.vm.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.utils.l;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0016\u0018\u0000 T2\u00020\u00012\u00020\u0002:\u0001UB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000fH\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010$\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0007H\u0016R\u0014\u0010\u0015\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010.\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010@\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00109R\u0016\u0010C\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u00109R\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/HWClockInRemindFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "initUI", "Fh", "Mh", "", "clickable", "Th", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b;", "status", "Vh", "", "Gh", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;", "unCheckedInfo", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g;", "Ih", "Landroid/content/Context;", "context", "fragmentData", "com/tencent/mobileqq/troop/homework/clockin/remind/HWClockInRemindFragment$b", "Hh", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;)Lcom/tencent/mobileqq/troop/homework/clockin/remind/HWClockInRemindFragment$b;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Dialog;", "onCreateDialog", "onLoadMoreStart", "hasMore", "onLoadMoreEnd", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;", "D", "Lkotlin/Lazy;", "Jh", "()Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g;", "viewModel", "Landroid/widget/RelativeLayout;", "E", "Landroid/widget/RelativeLayout;", "contentViewGroup", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "remindBtn", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "H", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "selectAllCheckBox", "I", "selectAllTextView", "J", "Landroid/view/View;", "closeBtn", "K", "titleTextView", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/adapter/a;", "L", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/adapter/a;", "listAdapter", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "M", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "concatAdapter", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "N", "Lcom/tencent/mobileqq/troop/homework/notice/common/a;", "loadMoreAdapter", "<init>", "(Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;)V", "P", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWClockInRemindFragment extends BottomSheetDialogFragment implements ILoadMoreProvider$LoadMoreListener {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.clockin.remind.data.a fragmentData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private RelativeLayout contentViewGroup;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView remindBtn;

    /* renamed from: H, reason: from kotlin metadata */
    private QUICheckBox selectAllCheckBox;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView selectAllTextView;

    /* renamed from: J, reason: from kotlin metadata */
    private View closeBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView titleTextView;

    /* renamed from: L, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.clockin.remind.adapter.a listAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.homework.notice.common.a loadMoreAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/HWClockInRemindFragment$a;", "", "", "FRAGMENT_MAX_HEIGHT_DP", "I", "HEADER_AND_FOOTER_HEIGHT", "RECYCLERVIEW_ITEM_HEIGHT_DP", "RECYCLERVIEW_MAX_HEIGHT_DP", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/homework/clockin/remind/HWClockInRemindFragment$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements ViewModelProvider.Factory {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f296494a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.homework.clockin.remind.data.a f296495b;

        b(Context context, com.tencent.mobileqq.troop.homework.clockin.remind.data.a aVar) {
            this.f296494a = context;
            this.f296495b = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (T) iPatchRedirector.redirect((short) 2, (Object) this, (Object) modelClass);
            }
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            T newInstance = modelClass.getConstructor(Context.class, com.tencent.mobileqq.troop.homework.clockin.remind.data.a.class).newInstance(this.f296494a, this.f296495b);
            Intrinsics.checkNotNullExpressionValue(newInstance, "modelClass.getConstructo\u2026ce(context, fragmentData)");
            return newInstance;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWClockInRemindFragment(@NotNull com.tencent.mobileqq.troop.homework.clockin.remind.data.a fragmentData) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(fragmentData, "fragmentData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fragmentData);
            return;
        }
        this.fragmentData = fragmentData;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<com.tencent.mobileqq.troop.homework.clockin.remind.vm.g>() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$viewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWClockInRemindFragment.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.troop.homework.clockin.remind.vm.g invoke() {
                com.tencent.mobileqq.troop.homework.clockin.remind.data.a aVar;
                com.tencent.mobileqq.troop.homework.clockin.remind.vm.g Ih;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.troop.homework.clockin.remind.vm.g) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                HWClockInRemindFragment hWClockInRemindFragment = HWClockInRemindFragment.this;
                aVar = hWClockInRemindFragment.fragmentData;
                Ih = hWClockInRemindFragment.Ih(aVar);
                return Ih;
            }
        });
        this.viewModel = lazy;
    }

    private final void Fh() {
        com.tencent.mobileqq.troop.homework.clockin.remind.adapter.a aVar = new com.tencent.mobileqq.troop.homework.clockin.remind.adapter.a();
        aVar.setHasStableIds(true);
        this.listAdapter = aVar;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar2 = new com.tencent.mobileqq.troop.homework.notice.common.a();
        aVar2.setHasStableIds(true);
        aVar2.registerLoadMoreListener(this);
        aVar2.setLoadState(false, true);
        this.loadMoreAdapter = aVar2;
        RFWConcatAdapter.Config build = new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build();
        RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[2];
        com.tencent.mobileqq.troop.homework.clockin.remind.adapter.a aVar3 = this.listAdapter;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar4 = null;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
            aVar3 = null;
        }
        adapterArr[0] = aVar3;
        com.tencent.mobileqq.troop.homework.notice.common.a aVar5 = this.loadMoreAdapter;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
        } else {
            aVar4 = aVar5;
        }
        adapterArr[1] = aVar4;
        this.concatAdapter = new RFWConcatAdapter(build, (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
    }

    private final int Gh() {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.fragmentData.b().size() * 56, 357);
        return coerceAtMost;
    }

    private final b Hh(Context context, com.tencent.mobileqq.troop.homework.clockin.remind.data.a fragmentData) {
        return new b(context, fragmentData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.homework.clockin.remind.vm.g Ih(com.tencent.mobileqq.troop.homework.clockin.remind.data.a unCheckedInfo) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ViewModel viewModel = new ViewModelProvider(this, Hh(requireContext, unCheckedInfo)).get(com.tencent.mobileqq.troop.homework.clockin.remind.vm.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026indViewModel::class.java)");
        return (com.tencent.mobileqq.troop.homework.clockin.remind.vm.g) viewModel;
    }

    private final com.tencent.mobileqq.troop.homework.clockin.remind.vm.g Jh() {
        return (com.tencent.mobileqq.troop.homework.clockin.remind.vm.g) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(HWClockInRemindFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(HWClockInRemindFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.homework.clockin.remind.vm.g Jh = this$0.Jh();
        QUICheckBox qUICheckBox = this$0.selectAllCheckBox;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
            qUICheckBox = null;
        }
        Jh.f2(qUICheckBox.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Mh() {
        LiveData<List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b>> Z1 = Jh().Z1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends com.tencent.mobileqq.troop.homework.clockin.remind.data.b>, Unit> function1 = new Function1<List<? extends com.tencent.mobileqq.troop.homework.clockin.remind.data.b>, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$observeLiveData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInRemindFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.troop.homework.clockin.remind.data.b> list) {
                invoke2((List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> list) {
                com.tencent.mobileqq.troop.homework.clockin.remind.adapter.a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                    return;
                }
                aVar = HWClockInRemindFragment.this.listAdapter;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
                    aVar = null;
                }
                aVar.setItems(list);
            }
        };
        Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInRemindFragment.Qh(Function1.this, obj);
            }
        });
        LiveData<Boolean> g26 = Jh().g2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$observeLiveData$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInRemindFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                com.tencent.mobileqq.troop.homework.notice.common.a aVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                aVar = HWClockInRemindFragment.this.loadMoreAdapter;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
                    aVar = null;
                }
                aVar.setLoadState(false, !bool.booleanValue());
            }
        };
        g26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInRemindFragment.Rh(Function1.this, obj);
            }
        });
        LiveData<Integer> a26 = Jh().a2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$observeLiveData$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInRemindFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                TextView textView;
                TextView textView2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                TextView textView3 = null;
                if (num != null && num.intValue() == 0) {
                    textView2 = HWClockInRemindFragment.this.titleTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                    } else {
                        textView3 = textView2;
                    }
                    textView3.setText("\u5168\u90e8\u5b66\u751f\u5df2\u6253\u5361");
                    return;
                }
                textView = HWClockInRemindFragment.this.titleTextView;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleTextView");
                } else {
                    textView3 = textView;
                }
                textView3.setText(num + "\u4eba\u672a\u6253\u5361");
            }
        };
        a26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInRemindFragment.Sh(Function1.this, obj);
            }
        });
        LiveData<Boolean> W1 = Jh().W1();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$observeLiveData$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInRemindFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean clickable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) clickable);
                    return;
                }
                HWClockInRemindFragment hWClockInRemindFragment = HWClockInRemindFragment.this;
                Intrinsics.checkNotNullExpressionValue(clickable, "clickable");
                hWClockInRemindFragment.Th(clickable.booleanValue());
            }
        };
        W1.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInRemindFragment.Nh(Function1.this, obj);
            }
        });
        LiveData<g.b> X1 = Jh().X1();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<g.b, Unit> function15 = new Function1<g.b, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$observeLiveData$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInRemindFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(g.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(g.b status) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) status);
                    return;
                }
                HWClockInRemindFragment hWClockInRemindFragment = HWClockInRemindFragment.this;
                Intrinsics.checkNotNullExpressionValue(status, "status");
                hWClockInRemindFragment.Vh(status);
            }
        };
        X1.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInRemindFragment.Oh(Function1.this, obj);
            }
        });
        LiveData<Boolean> U1 = Jh().U1();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function16 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.HWClockInRemindFragment$observeLiveData$6
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) HWClockInRemindFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    HWClockInRemindFragment.this.getParentFragmentManager().beginTransaction().remove(HWClockInRemindFragment.this).commit();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                }
            }
        };
        U1.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWClockInRemindFragment.Ph(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(boolean clickable) {
        TextView textView = null;
        if (clickable) {
            TextView textView2 = this.remindBtn;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
                textView2 = null;
            }
            TextView textView3 = this.remindBtn;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
                textView3 = null;
            }
            textView2.setBackground(ContextCompat.getDrawable(textView3.getContext(), R.drawable.lwy));
            TextView textView4 = this.remindBtn;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
                textView4 = null;
            }
            TextView textView5 = this.remindBtn;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
                textView5 = null;
            }
            textView4.setTextColor(textView5.getContext().getColor(R.color.qui_button_text_primary_default));
            TextView textView6 = this.remindBtn;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
            } else {
                textView = textView6;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HWClockInRemindFragment.Uh(HWClockInRemindFragment.this, view);
                }
            });
            return;
        }
        TextView textView7 = this.remindBtn;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
            textView7 = null;
        }
        TextView textView8 = this.remindBtn;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
            textView8 = null;
        }
        textView7.setBackground(ContextCompat.getDrawable(textView8.getContext(), R.drawable.lwz));
        TextView textView9 = this.remindBtn;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
            textView9 = null;
        }
        TextView textView10 = this.remindBtn;
        if (textView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
            textView10 = null;
        }
        textView9.setTextColor(textView10.getContext().getColor(R.color.qui_button_text_primary_disable));
        TextView textView11 = this.remindBtn;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindBtn");
            textView11 = null;
        }
        textView11.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(HWClockInRemindFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Jh().c2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(g.b status) {
        TextView textView = null;
        if (status instanceof g.b.C8717b) {
            QUICheckBox qUICheckBox = this.selectAllCheckBox;
            if (qUICheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
                qUICheckBox = null;
            }
            qUICheckBox.setChecked(true);
            QUICheckBox qUICheckBox2 = this.selectAllCheckBox;
            if (qUICheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
                qUICheckBox2 = null;
            }
            qUICheckBox2.setEnabled(true);
            TextView textView2 = this.selectAllTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
                textView2 = null;
            }
            TextView textView3 = this.selectAllTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
            } else {
                textView = textView3;
            }
            textView2.setTextColor(textView.getContext().getColor(R.color.qui_common_text_primary));
            return;
        }
        if (status instanceof g.b.c) {
            QUICheckBox qUICheckBox3 = this.selectAllCheckBox;
            if (qUICheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
                qUICheckBox3 = null;
            }
            qUICheckBox3.setChecked(false);
            QUICheckBox qUICheckBox4 = this.selectAllCheckBox;
            if (qUICheckBox4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
                qUICheckBox4 = null;
            }
            qUICheckBox4.setEnabled(true);
            TextView textView4 = this.selectAllTextView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
                textView4 = null;
            }
            TextView textView5 = this.selectAllTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
            } else {
                textView = textView5;
            }
            textView4.setTextColor(textView.getContext().getColor(R.color.qui_common_text_primary));
            return;
        }
        if (status instanceof g.b.a) {
            QUICheckBox qUICheckBox5 = this.selectAllCheckBox;
            if (qUICheckBox5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
                qUICheckBox5 = null;
            }
            qUICheckBox5.setChecked(false);
            QUICheckBox qUICheckBox6 = this.selectAllCheckBox;
            if (qUICheckBox6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
                qUICheckBox6 = null;
            }
            qUICheckBox6.setEnabled(false);
            TextView textView6 = this.selectAllTextView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
                textView6 = null;
            }
            TextView textView7 = this.selectAllTextView;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectAllTextView");
            } else {
                textView = textView7;
            }
            textView6.setTextColor(textView.getContext().getColor(R.color.qui_button_text_secondary_disable));
        }
    }

    private final void initUI() {
        Window window;
        ViewGroup viewGroup;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null && (viewGroup = (ViewGroup) window.findViewById(R.id.ugk)) != null) {
            viewGroup.setBackgroundResource(17170445);
        }
        Fh();
        RecyclerView recyclerView = this.recyclerView;
        QUICheckBox qUICheckBox = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setOverScrollMode(2);
        recyclerView.setItemAnimator(null);
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        if (rFWConcatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            rFWConcatAdapter = null;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        layoutParams.height = l.b(Gh());
        recyclerView.setLayoutParams(layoutParams);
        View view = this.closeBtn;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWClockInRemindFragment.Kh(HWClockInRemindFragment.this, view2);
            }
        });
        QUICheckBox qUICheckBox2 = this.selectAllCheckBox;
        if (qUICheckBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectAllCheckBox");
        } else {
            qUICheckBox = qUICheckBox2;
        }
        qUICheckBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HWClockInRemindFragment.Lh(HWClockInRemindFragment.this, view2);
            }
        });
        Th(false);
        Jh().initData();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Dialog) iPatchRedirector.redirect((short) 4, (Object) this, (Object) savedInstanceState);
        }
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        aVar.getBehavior().setHideable(false);
        aVar.setCanceledOnTouchOutside(false);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            rootView = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            rootView = inflater.inflate(R.layout.g09, container, false);
            View findViewById = rootView.findViewById(R.id.i4m);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.recycler_view)");
            this.recyclerView = (RecyclerView) findViewById;
            View findViewById2 = rootView.findViewById(R.id.f72783rs);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.remind_btn)");
            this.remindBtn = (TextView) findViewById2;
            View findViewById3 = rootView.findViewById(R.id.az7);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.close_btn)");
            this.closeBtn = findViewById3;
            View findViewById4 = rootView.findViewById(R.id.title);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.title)");
            this.titleTextView = (TextView) findViewById4;
            View findViewById5 = rootView.findViewById(R.id.u8n);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.content_view_group)");
            this.contentViewGroup = (RelativeLayout) findViewById5;
            View findViewById6 = rootView.findViewById(R.id.awy);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.check_box)");
            this.selectAllCheckBox = (QUICheckBox) findViewById6;
            View findViewById7 = rootView.findViewById(R.id.f82014fq);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.select_all_textview)");
            this.selectAllTextView = (TextView) findViewById7;
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, hasMore);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            Jh().h2();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI();
        Mh();
    }
}
