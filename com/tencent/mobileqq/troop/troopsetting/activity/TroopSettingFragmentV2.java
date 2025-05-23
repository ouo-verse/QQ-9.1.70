package com.tencent.mobileqq.troop.troopsetting.activity;

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
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingAppPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingBlockSearchMsgPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatConversationPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingChatGroupPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingGroupInfoPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingManageGroupPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingMemberInfoPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingMngObserverPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingPersonalAndOtherPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingQuitOrDisbandPart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingSmallHomePart;
import com.tencent.mobileqq.troop.troopsetting.part.TroopSettingTitlePart;
import com.tencent.mobileqq.troop.troopsetting.part.av;
import com.tencent.mobileqq.troop.troopsetting.part.bc;
import com.tencent.mobileqq.troop.troopsetting.part.h;
import com.tencent.mobileqq.troop.troopsetting.part.l;
import com.tencent.mobileqq.troop.troopsetting.part.o;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0013J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020 H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/activity/TroopSettingFragmentV2;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/d;", "", "ph", "", "Lcom/tencent/biz/richframework/part/Part;", "qh", "vh", "rh", "sh", "uh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "assembleParts", "contentView", "onViewCreatedAfterPartInit", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "th", "getRootView", "onStart", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDetach", "", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "needImmersive", "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopsetting/vm/TroopSettingViewModel;", "troopSettingViewModel", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recycleView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "G", "Ljava/util/List;", "parts", "<init>", "()V", "H", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingFragmentV2 extends QPublicBaseFragment implements com.tencent.mobileqq.pad.d {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TroopSettingViewModel troopSettingViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUISettingsRecyclerView recycleView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<Part> parts;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/activity/TroopSettingFragmentV2$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingFragmentV2$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60057);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingFragmentV2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.parts = new ArrayList();
        }
    }

    private final void ph() {
        ArrayList arrayList = new ArrayList();
        for (Part part : this.parts) {
            if (part instanceof h) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((h) part).G9());
            }
        }
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            Object[] array = arrayList.toArray(new Group[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Group[] groupArr = (Group[]) array;
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
        }
    }

    private final List<Part> qh() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new bc(), new TroopSettingMngObserverPart(), new com.tencent.mobileqq.troop.troopsetting.part.f(), new TroopSettingTitlePart(), new l());
        return mutableListOf;
    }

    private final List<Part> rh() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopSettingGroupInfoPart(), new TroopSettingAppPart(), new TroopSettingBlockSearchMsgPart(), new TroopSettingQuitOrDisbandPart(), new o());
        return mutableListOf;
    }

    private final List<Part> sh() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopSettingGroupInfoPart(), new TroopSettingMemberInfoPart(), new TroopSettingChatGroupPart(), new TroopSettingAppPart(), uh(), new TroopSettingSmallHomePart(), new TroopSettingChatConversationPart(), new TroopSettingPersonalAndOtherPart(), new av(), new TroopSettingQuitOrDisbandPart(), new o());
        return mutableListOf;
    }

    private final Part uh() {
        TroopSettingViewModel troopSettingViewModel = this.troopSettingViewModel;
        if (troopSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel = null;
        }
        if (troopSettingViewModel.T2().isOwnerOrAdim()) {
            return new TroopSettingManageGroupPart();
        }
        return new h();
    }

    private final List<Part> vh() {
        TroopSettingViewModel troopSettingViewModel = this.troopSettingViewModel;
        if (troopSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel = null;
        }
        if (troopSettingViewModel.S2().isNeedInterceptOnBlockTroop()) {
            return rh();
        }
        return sh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(qh());
        arrayList.addAll(vh());
        this.parts = arrayList;
        return arrayList;
    }

    @NotNull
    public final View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        QBaseActivity qBaseActivity;
        Unit unit;
        QBaseActivity qBaseActivity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(TroopSettingViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopSettingViewModel::class.java)");
        this.troopSettingViewModel = (TroopSettingViewModel) viewModel;
        FragmentActivity activity = getActivity();
        TroopSettingViewModel troopSettingViewModel = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            qBaseActivity.mActNeedImmersive = false;
            qBaseActivity.mNeedStatusTrans = false;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            TroopSettingViewModel troopSettingViewModel2 = this.troopSettingViewModel;
            if (troopSettingViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
                troopSettingViewModel2 = null;
            }
            FragmentActivity activity3 = getActivity();
            if (activity3 instanceof QBaseActivity) {
                qBaseActivity2 = (QBaseActivity) activity3;
            } else {
                qBaseActivity2 = null;
            }
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
            if (!troopSettingViewModel2.k3(qBaseActivity2, activity2, arguments)) {
                TroopSettingViewModel troopSettingViewModel3 = this.troopSettingViewModel;
                if (troopSettingViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
                } else {
                    troopSettingViewModel = troopSettingViewModel3;
                }
                QLog.i("TroopSettingFragmentV2", 2, "onCreate, illegal param, troopUin = " + troopSettingViewModel.S2().getTroopUin());
                a.f301056a.h(activity2);
                return;
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            return;
        }
        com.tencent.mobileqq.troop.troopsetting.report.c cVar = com.tencent.mobileqq.troop.troopsetting.report.c.f301449a;
        TroopSettingViewModel troopSettingViewModel4 = this.troopSettingViewModel;
        if (troopSettingViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel4 = null;
        }
        cVar.e(troopSettingViewModel4.T2());
        TroopSettingViewModel troopSettingViewModel5 = this.troopSettingViewModel;
        if (troopSettingViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
        } else {
            troopSettingViewModel = troopSettingViewModel5;
        }
        troopSettingViewModel.onCreate();
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
            View inflate = inflater.inflate(R.layout.hzm, container, false);
            inflate.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026om_standard_bg)\n        }");
            this.rootView = inflate;
            View findViewById = inflate.findViewById(R.id.f10361613);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(co\u2026op_setting_recycler_view)");
            this.recycleView = (QUISettingsRecyclerView) findViewById;
            this.adapter = new QUIListItemAdapter(null, false, true, 3, null);
            QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
            if (qUISettingsRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                qUISettingsRecyclerView = null;
            }
            qUISettingsRecyclerView.setAdapter(this.adapter);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        TroopSettingViewModel troopSettingViewModel = this.troopSettingViewModel;
        QBaseActivity qBaseActivity = null;
        if (troopSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel = null;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        }
        troopSettingViewModel.p3(qBaseActivity);
        a.f301056a.f();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onDetach();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            TroopSettingViewModel troopSettingViewModel = this.troopSettingViewModel;
            if (troopSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
                troopSettingViewModel = null;
            }
            Bundle arguments = getArguments();
            if (arguments == null) {
                arguments = new Bundle();
            }
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: Bundle()");
            troopSettingViewModel.m2(activity, arguments);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onPause();
        TroopSettingViewModel troopSettingViewModel = this.troopSettingViewModel;
        if (troopSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel = null;
        }
        troopSettingViewModel.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.onResume();
        TroopSettingViewModel troopSettingViewModel = this.troopSettingViewModel;
        if (troopSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel = null;
        }
        troopSettingViewModel.onResume();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStart();
        TroopSettingViewModel troopSettingViewModel = this.troopSettingViewModel;
        QBaseActivity qBaseActivity = null;
        if (troopSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel = null;
        }
        FragmentActivity activity = getActivity();
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        }
        troopSettingViewModel.t3(qBaseActivity);
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
        ph();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        View view = this.rootView;
        TroopSettingViewModel troopSettingViewModel = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        TroopSettingViewModel troopSettingViewModel2 = this.troopSettingViewModel;
        if (troopSettingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
            troopSettingViewModel2 = null;
        }
        c.b(requireActivity, view, troopSettingViewModel2.T2());
        TroopSettingViewModel troopSettingViewModel3 = this.troopSettingViewModel;
        if (troopSettingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("troopSettingViewModel");
        } else {
            troopSettingViewModel = troopSettingViewModel3;
        }
        troopSettingViewModel.n4();
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return false;
    }

    @NotNull
    public final QUISettingsRecyclerView th() {
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
