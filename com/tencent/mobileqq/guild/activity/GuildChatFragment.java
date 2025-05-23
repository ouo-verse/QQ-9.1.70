package com.tencent.mobileqq.guild.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.guild.api.IGuildStandalonePageOpenApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.g;
import com.tencent.mobileqq.qroute.QRoute;
import gn0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b)\u0010*J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/activity/GuildChatFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/pad/g;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "hidden", "", "onHiddenChanged", "qOnNewIntent", "", "from", "d5", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "qOnBackPressed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lgn0/a;", BdhLogUtil.LogTag.Tag_Conn, "Lgn0/a;", "guildChatFragmentAbility", "D", "I", "containerId", "E", "hideFrom", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "currentGuildId", "G", "currentChannelId", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildChatFragment extends Fragment implements g {

    /* renamed from: C, reason: from kotlin metadata */
    private final a guildChatFragmentAbility = new a();

    /* renamed from: D, reason: from kotlin metadata */
    private int containerId = View.generateViewId();

    /* renamed from: E, reason: from kotlin metadata */
    private int hideFrom;

    /* renamed from: F, reason: from kotlin metadata */
    private String currentGuildId;

    /* renamed from: G, reason: from kotlin metadata */
    private String currentChannelId;

    @Override // com.tencent.mobileqq.pad.g
    public void d5(int from) {
        this.hideFrom = from;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).isInSplitViewMode(getActivity())) {
            ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).onConfigurationChanged(newConfig);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (!isHidden()) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setGuildChatFragmentShow();
        }
        Intrinsics.checkNotNull(container);
        FrameLayout frameLayout = new FrameLayout(container.getContext());
        frameLayout.setId(this.containerId);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setGuildChatFragmentHide();
        a aVar = this.guildChatFragmentAbility;
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        aVar.c(requireArguments);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        this.guildChatFragmentAbility.d(hidden);
        if (!hidden) {
            ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setGuildChatFragmentShow();
            return;
        }
        ((IGuildStandalonePageOpenApi) QRoute.api(IGuildStandalonePageOpenApi.class)).setGuildChatFragmentHide();
        if (this.hideFrom != 2) {
            a aVar = this.guildChatFragmentAbility;
            Bundle requireArguments = requireArguments();
            Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
            aVar.c(requireArguments);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.currentGuildId = requireArguments().getString("guild_id");
        this.currentChannelId = requireArguments().getString("channel_id");
        a aVar = this.guildChatFragmentAbility;
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        aVar.e(requireArguments, childFragmentManager, this.containerId);
    }

    @Override // com.tencent.mobileqq.pad.f
    public boolean qOnBackPressed() {
        this.guildChatFragmentAbility.b();
        return false;
    }

    @Override // com.tencent.mobileqq.pad.f
    public void qOnNewIntent() {
        String string = requireArguments().getString("guild_id");
        String string2 = requireArguments().getString("channel_id");
        long j3 = requireArguments().getLong("navigate_msg_seq", 0L);
        if (Intrinsics.areEqual(string, this.currentGuildId) && Intrinsics.areEqual(string2, this.currentChannelId) && j3 == 0) {
            return;
        }
        this.currentGuildId = string;
        this.currentChannelId = string2;
        a aVar = this.guildChatFragmentAbility;
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        aVar.g(requireArguments, childFragmentManager, this.containerId);
    }
}
