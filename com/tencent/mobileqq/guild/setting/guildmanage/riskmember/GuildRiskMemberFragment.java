package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskBatchHandlePart;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskListPart;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskSearchListPart;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.part.RiskSearchModePart;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberFragment;", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "", "initViewModel", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Lpz1/c;", BdhLogUtil.LogTag.Tag_Conn, "Lpz1/c;", "viewModel", "Lpz1/e;", "D", "Lpz1/e;", "searchViewModel", "", "E", "Ljava/lang/String;", "guildId", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildRiskMemberFragment extends BasePartFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private pz1.c viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private pz1.e searchViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberFragment$a;", "", "", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberFragment;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildRiskMemberFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildRiskMemberFragment a(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Bundle bundle = new Bundle();
            bundle.putString("extra_guild_id", guildId);
            GuildRiskMemberFragment guildRiskMemberFragment = new GuildRiskMemberFragment();
            guildRiskMemberFragment.setArguments(bundle);
            return guildRiskMemberFragment;
        }

        Companion() {
        }
    }

    private final void initViewModel() {
        String str;
        Bundle arguments = getArguments();
        pz1.c cVar = null;
        if (arguments != null) {
            str = arguments.getString("extra_guild_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        ViewModel viewModel = getViewModel(pz1.c.class);
        pz1.c cVar2 = (pz1.c) viewModel;
        cVar2.k2(this.guildId);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GuildRiskMe\u2026ragment.guildId\n        }");
        this.viewModel = cVar2;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar2 = null;
        }
        cn<cf1.b> toastEvent = cVar2.getToastEvent();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<cf1.b, Unit> function1 = new Function1<cf1.b, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildRiskMemberFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cf1.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cf1.b bVar) {
                if (GuildRiskMemberFragment.this.getActivity() == null || bVar == null) {
                    return;
                }
                GuildRiskMemberFragment guildRiskMemberFragment = GuildRiskMemberFragment.this;
                if (bVar.f30775b == 0) {
                    ch.u1(guildRiskMemberFragment.getActivity(), bVar.f30774a);
                } else {
                    ch.r1(guildRiskMemberFragment.requireActivity(), bVar.f30775b, bVar.f30774a, bVar.f30776c);
                }
            }
        };
        toastEvent.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildRiskMemberFragment.rh(Function1.this, obj);
            }
        });
        pz1.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            cVar = cVar3;
        }
        cVar.initData();
        ViewModel viewModel2 = getViewModel(pz1.e.class);
        pz1.e eVar = (pz1.e) viewModel2;
        eVar.S1(this.guildId);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(GuildRiskSe\u2026ragment.guildId\n        }");
        this.searchViewModel = eVar;
    }

    private final void qh(View rootView) {
        if (rootView == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(rootView, "pg_sgrp_danger_user_list");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(rootView, this.guildId, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[4];
        pz1.c cVar = this.viewModel;
        pz1.e eVar = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar = null;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        partArr[0] = new RiskListPart(R.id.eap, cVar, viewLifecycleOwner);
        pz1.c cVar2 = this.viewModel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar2 = null;
        }
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        partArr[1] = new RiskBatchHandlePart(R.id.t5f, cVar2, viewLifecycleOwner2);
        pz1.c cVar3 = this.viewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar3 = null;
        }
        pz1.e eVar2 = this.searchViewModel;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
            eVar2 = null;
        }
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        partArr[2] = new RiskSearchModePart(cVar3, eVar2, viewLifecycleOwner3);
        pz1.c cVar4 = this.viewModel;
        if (cVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            cVar4 = null;
        }
        pz1.e eVar3 = this.searchViewModel;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchViewModel");
        } else {
            eVar = eVar3;
        }
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        partArr[3] = new RiskSearchListPart(R.id.f81054d5, cVar4, eVar, viewLifecycleOwner4);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f4q;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        initViewModel();
        qh(onCreateView);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }
}
