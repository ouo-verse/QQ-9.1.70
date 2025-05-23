package com.tencent.mobileqq.troop.troopcard.reborn.essence;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.troopmanage.ITroopManageApi;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\f\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceTabBaseFragment;", "Landroid/view/View;", "view", "", "th", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "ph", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "D", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "troopBasicInfoViewModel", "<init>", "()V", "E", "a", "b", "c", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopEssenceGuideTabFragment extends TroopEssenceTabBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopBasicInfoViewModel troopBasicInfoViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceGuideTabFragment$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment;Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public final class b extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        final /* synthetic */ TroopEssenceGuideTabFragment E;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull TroopEssenceGuideTabFragment troopEssenceGuideTabFragment, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.E = troopEssenceGuideTabFragment;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopEssenceGuideTabFragment, (Object) itemView);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u001c\u0010\r\u001a\u00020\f2\n\u0010\n\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment$b;", "Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "", "i0", "<init>", "(Lcom/tencent/mobileqq/troop/troopcard/reborn/essence/TroopEssenceGuideTabFragment;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    private final class c extends RecyclerView.Adapter<b> {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopEssenceGuideTabFragment.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: getItemCount */
        public int getNUM_BACKGOURND_ICON() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NotNull b holder, int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) holder, position);
            } else {
                Intrinsics.checkNotNullParameter(holder, "holder");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NotNull
        /* renamed from: j0, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent, viewType);
            }
            Intrinsics.checkNotNullParameter(parent, "parent");
            return new b(TroopEssenceGuideTabFragment.this, new View(parent.getContext()));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57029);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopEssenceGuideTabFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void th(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.troopBasicInfoViewModel;
        if (troopBasicInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopBasicInfoViewModel");
            troopBasicInfoViewModel = null;
        }
        intent.putExtra("troop_uin", troopBasicInfoViewModel.K2());
        intent.putExtra("from", 1);
        QPublicFragmentActivity.start(activity, intent, ((ITroopManageApi) QRoute.api(ITroopManageApi.class)).getTroopSubManageInformationFragmentClz());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceTabBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.h5z, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceTabBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopBasicInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopBasicInfoViewModel::class.java)");
        this.troopBasicInfoViewModel = (TroopBasicInfoViewModel) viewModel;
        TextView textView = (TextView) view.findViewById(R.id.zyr);
        TroopCardDtHelper.f299952a.l(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcard.reborn.essence.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TroopEssenceGuideTabFragment.this.th(view2);
            }
        });
    }

    @Override // com.tencent.mobileqq.troop.troopcard.reborn.essence.TroopEssenceTabBaseFragment
    @NotNull
    public RecyclerView.Adapter<?> ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (RecyclerView.Adapter) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new c();
    }
}
