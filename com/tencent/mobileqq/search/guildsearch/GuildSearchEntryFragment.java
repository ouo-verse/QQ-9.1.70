package com.tencent.mobileqq.search.guildsearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchActivationPart;
import com.tencent.mobileqq.search.guildsearch.parts.GuildSearchRelativeWordsPart;
import com.tencent.mobileqq.search.guildsearch.parts.f;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/GuildSearchEntryFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", "contentView", "", "ph", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/search/guildsearch/GuildSearchEntryViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/search/guildsearch/GuildSearchEntryViewModel;", "viewModel", "<init>", "()V", "D", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class GuildSearchEntryFragment extends QPublicBaseFragment {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private GuildSearchEntryViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/guildsearch/GuildSearchEntryFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", "DT_PAGE_ID", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.guildsearch.GuildSearchEntryFragment$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).shouldLaunchInSplitViewMode(context)) {
                i.e(context, new Bundle(), GuildSearchEntryFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).h(LaunchMode.standard).a());
            } else if (context instanceof Activity) {
                QPublicFragmentActivity.start(context, intent, GuildSearchEntryFragment.class);
            } else {
                intent.addFlags(268435456);
                QPublicFragmentActivity.start(BaseApplication.getContext(), intent, GuildSearchEntryFragment.class);
            }
        }

        Companion() {
        }
    }

    private final void ph(View contentView) {
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("pageId", "pg_sgrp_search_activation");
        VideoReport.setPageId(contentView, "pg_sgrp_search_activation");
        VideoReport.setPageParams(contentView, new PageParams(hashMap));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new f(), new GuildSearchActivationPart(), new GuildSearchRelativeWordsPart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.h2s;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().i("QQSearch.Local.Guild.GuildSearchEntryFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Logger.f235387a.d().i("QQSearch.Local.Guild.GuildSearchEntryFragment", 1, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED);
        ViewModel viewModel = getViewModel("GuildSearchEntryViewModel", GuildSearchEntryViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(\"GuildSearc\u2026tryViewModel::class.java)");
        this.viewModel = (GuildSearchEntryViewModel) viewModel;
        ph(view);
    }
}
