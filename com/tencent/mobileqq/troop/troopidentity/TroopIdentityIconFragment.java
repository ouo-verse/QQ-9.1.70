package com.tencent.mobileqq.troop.troopidentity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityAppIconPart;
import com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityEmptyStatePart;
import com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityIconBasePart;
import com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityInteractivePart;
import com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityPreviewPart;
import com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityTitleCustomPart;
import com.tencent.mobileqq.troop.troopidentity.parts.TroopIdentityTitleHostPart;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R&\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0018j\b\u0012\u0004\u0012\u00020\u000e`\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initNavBar", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "contentView", "onViewCreatedAfterPartInit", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "ph", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "needImmersive", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "partList", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recycleView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "G", "Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconVM;", "viewModel", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopIdentityIconFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Part> partList;

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISettingsRecyclerView recycleView;

    /* renamed from: F, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: G, reason: from kotlin metadata */
    private TroopIdentityIconVM viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopidentity/TroopIdentityIconFragment$a;", "", "", "MEMBER_UIN", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57700);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopIdentityIconFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.partList = new ArrayList<>();
        }
    }

    private final void initNavBar() {
        View view = this.rootView;
        String str = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        QUISecNavBar qUISecNavBar = (QUISecNavBar) view.findViewById(R.id.jo9);
        TroopIdentityIconVM troopIdentityIconVM = this.viewModel;
        if (troopIdentityIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityIconVM = null;
        }
        if (troopIdentityIconVM.k2()) {
            Context context = getContext();
            if (context != null) {
                str = context.getString(R.string.f2342779i);
            }
            qUISecNavBar.setCenterText(str);
        } else {
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.f2342679h);
            }
            qUISecNavBar.setCenterText(str);
        }
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.troopidentity.TroopIdentityIconFragment$initNavBar$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopIdentityIconFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view2, BaseAction baseAction) {
                invoke2(view2, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view2, @NotNull BaseAction baseAction) {
                FragmentActivity activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2, (Object) baseAction);
                    return;
                }
                Intrinsics.checkNotNullParameter(view2, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                if (baseAction != BaseAction.ACTION_LEFT_BUTTON || (activity = TroopIdentityIconFragment.this.getActivity()) == null) {
                    return;
                }
                activity.finish();
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            qUISecNavBar.R(activity);
        }
        qUISecNavBar.findViewById(R.id.f81564ei).setAlpha(0.0f);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        this.partList.add(new TroopIdentityPreviewPart());
        TroopIdentityIconVM troopIdentityIconVM = this.viewModel;
        if (troopIdentityIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityIconVM = null;
        }
        if (troopIdentityIconVM.k2()) {
            this.partList.add(new TroopIdentityTitleHostPart());
        } else {
            this.partList.add(new TroopIdentityTitleCustomPart());
        }
        this.partList.add(new TroopIdentityInteractivePart());
        this.partList.add(new TroopIdentityAppIconPart());
        this.partList.add(new com.tencent.mobileqq.troop.troopidentity.parts.d());
        this.partList.add(new TroopIdentityEmptyStatePart());
        return this.partList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(TroopIdentityIconVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopIdentityIconVM::class.java)");
        TroopIdentityIconVM troopIdentityIconVM = (TroopIdentityIconVM) viewModel;
        this.viewModel = troopIdentityIconVM;
        if (troopIdentityIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityIconVM = null;
        }
        Bundle arguments = getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        troopIdentityIconVM.init(arguments);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            view = (View) iPatchRedirector.redirect((short) 3, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.hzg, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026layout, container, false)");
            this.rootView = inflate;
            initNavBar();
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            View findViewById = view2.findViewById(R.id.f102135x3);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ntity_icon_recycler_view)");
            this.recycleView = (QUISettingsRecyclerView) findViewById;
            this.adapter = new QUIListItemAdapter(null, false, false, 7, null);
            QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
            if (qUISettingsRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                qUISettingsRecyclerView = null;
            }
            QUIListItemAdapter qUIListItemAdapter = this.adapter;
            if (qUIListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                qUIListItemAdapter = null;
            }
            qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
            TroopIdentityIconVM troopIdentityIconVM = this.viewModel;
            if (troopIdentityIconVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                troopIdentityIconVM = null;
            }
            troopIdentityIconVM.X1().f(true);
            view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        TroopIdentityIconVM troopIdentityIconVM = this.viewModel;
        TroopIdentityIconVM troopIdentityIconVM2 = null;
        if (troopIdentityIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityIconVM = null;
        }
        troopIdentityIconVM.X1().f(false);
        TroopIdentityIconVM troopIdentityIconVM3 = this.viewModel;
        if (troopIdentityIconVM3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            troopIdentityIconVM2 = troopIdentityIconVM3;
        }
        troopIdentityIconVM2.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onResume();
        TroopIdentityIconVM troopIdentityIconVM = this.viewModel;
        if (troopIdentityIconVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopIdentityIconVM = null;
        }
        troopIdentityIconVM.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) contentView, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        ArrayList arrayList = new ArrayList();
        for (Part part : this.partList) {
            if (part instanceof TroopIdentityIconBasePart) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((TroopIdentityIconBasePart) part).E9());
            }
        }
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            qUIListItemAdapter = null;
        }
        Object[] array = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array;
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
    }

    @NotNull
    public final QUISettingsRecyclerView ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (QUISettingsRecyclerView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            return null;
        }
        return qUISettingsRecyclerView;
    }
}
