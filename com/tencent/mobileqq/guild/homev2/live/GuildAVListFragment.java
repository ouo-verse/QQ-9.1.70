package com.tencent.mobileqq.guild.homev2.live;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.heartbeatreport.impl.FacadeFragmentOnlineReportHelper;
import com.tencent.mobileqq.guild.homev2.live.part.GuildAVGuildStatePart;
import com.tencent.mobileqq.guild.homev2.live.part.GuildAVListContentPart;
import com.tencent.mobileqq.guild.homev2.live.part.GuildAVPermissionEntrancePart;
import com.tencent.mobileqq.guild.homev2.misc.d;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildSubscribePollingManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qw1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0010\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010(\u001a\u00020\u001d8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/GuildAVListFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "", "Gh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "rh", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "onBackEvent", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "T", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "mJumpGuildParam", "", "U", "Ljava/lang/String;", "mCategoryId", "V", "I", "mCategoryType", "W", "mSceneType", "getGuildId", "()Ljava/lang/String;", "guildId", "<init>", "()V", "X", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildAVListFragment extends QQGuildTokenTitleBarFragment implements d {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private JumpGuildParam mJumpGuildParam;

    /* renamed from: U, reason: from kotlin metadata */
    private String mCategoryId;

    /* renamed from: V, reason: from kotlin metadata */
    private int mCategoryType = 3;

    /* renamed from: W, reason: from kotlin metadata */
    private int mSceneType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007R\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/live/GuildAVListFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", "categoryId", "", "categoryType", "sceneType", "", "a", "SCENE_TYPE", "Ljava/lang/String;", "TAG", "TYPE_LIST_NORMAL", "I", "TYPE_LIST_ONLY_LIVED", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.homev2.live.GuildAVListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull JumpGuildParam param, @NotNull String categoryId, int categoryType, int sceneType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(categoryId, "categoryId");
            Intent intent = new Intent();
            intent.putExtra(JumpGuildParam.KEY_JUMP_GUILD_PARAM, (Parcelable) param);
            intent.putExtra("EXTRA_CATEGORY_ID", categoryId);
            intent.putExtra("EXTRA_CATEGORY_TYPE", categoryType);
            intent.putExtra("SCENE_TYPE", sceneType);
            b.r(intent, Reporters.f231995a.b().a("guild_live_page").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildAVListFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    public GuildAVListFragment() {
        GuildSubscribePollingManager.f235373a.a(this, m.b(this));
    }

    private final void Gh() {
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        int i3 = this.mCategoryType;
        if (i3 != 3) {
            if (i3 != 9) {
                str = "";
            } else {
                str = "pg_sgrp_voice_second";
            }
        } else {
            str = "pg_sgrp_stream_second";
        }
        VideoReport.setPageId(getView(), str);
        HashMap hashMap = new HashMap(com.tencent.mobileqq.guild.report.b.d());
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = getView();
        JumpGuildParam jumpGuildParam = this.mJumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJumpGuildParam");
            jumpGuildParam = null;
        }
        iGuildDTReportApi.setGuildPageParams(view, jumpGuildParam.guildId, hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        JumpGuildParam jumpGuildParam;
        String str;
        IPerformanceReportTask iPerformanceReportTask;
        String str2;
        List<Part> mutableListOf;
        Part[] partArr = new Part[3];
        JumpGuildParam jumpGuildParam2 = this.mJumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJumpGuildParam");
            jumpGuildParam = null;
        } else {
            jumpGuildParam = jumpGuildParam2;
        }
        int i3 = this.mCategoryType;
        String str3 = this.mCategoryId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryId");
            str = null;
        } else {
            str = str3;
        }
        int i16 = this.mSceneType;
        Bundle arguments = getArguments();
        if (arguments != null) {
            iPerformanceReportTask = b.g(arguments, null, 1, null);
        } else {
            iPerformanceReportTask = null;
        }
        partArr[0] = new GuildAVListContentPart(jumpGuildParam, i3, str, i16, iPerformanceReportTask);
        JumpGuildParam jumpGuildParam3 = this.mJumpGuildParam;
        if (jumpGuildParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJumpGuildParam");
            jumpGuildParam3 = null;
        }
        partArr[1] = new GuildAVGuildStatePart(jumpGuildParam3);
        JumpGuildParam jumpGuildParam4 = this.mJumpGuildParam;
        if (jumpGuildParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJumpGuildParam");
            jumpGuildParam4 = null;
        }
        String str4 = jumpGuildParam4.guildId;
        Intrinsics.checkNotNullExpressionValue(str4, "mJumpGuildParam.guildId");
        String str5 = this.mCategoryId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryId");
            str2 = null;
        } else {
            str2 = str5;
        }
        ImageView rightViewImg = this.G;
        Intrinsics.checkNotNullExpressionValue(rightViewImg, "rightViewImg");
        partArr[2] = new GuildAVPermissionEntrancePart(str4, str2, rightViewImg, this.mCategoryType, this.mSceneType);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Bundle g16 = GuildSplitViewUtils.f235370a.g(this);
        JumpGuildParam jumpGuildParam = (JumpGuildParam) g16.getParcelable(JumpGuildParam.KEY_JUMP_GUILD_PARAM);
        if (jumpGuildParam != null) {
            this.mJumpGuildParam = jumpGuildParam;
            String string = g16.getString("EXTRA_CATEGORY_ID");
            if (string != null) {
                this.mCategoryId = string;
                this.mCategoryType = g16.getInt("EXTRA_CATEGORY_TYPE");
                this.mSceneType = g16.getInt("SCENE_TYPE", 0);
                Logger.a d16 = Logger.f235387a.d();
                JumpGuildParam jumpGuildParam2 = this.mJumpGuildParam;
                String str = null;
                if (jumpGuildParam2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mJumpGuildParam");
                    jumpGuildParam2 = null;
                }
                String str2 = jumpGuildParam2.guildId;
                String str3 = this.mCategoryId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCategoryId");
                } else {
                    str = str3;
                }
                d16.a("GuildLiveListFragment", 1, "opened guildId:" + str2 + " categoryId:" + str + ", " + this.mCategoryType);
                return;
            }
            throw new IllegalStateException("GuildLiveListFragment param_category_id is null");
        }
        throw new IllegalStateException("GuildLiveListFragment param_facade_args_data is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.es5;
    }

    @Override // com.tencent.mobileqq.guild.homev2.misc.d
    @NotNull
    public String getGuildId() {
        JumpGuildParam jumpGuildParam = this.mJumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJumpGuildParam");
            jumpGuildParam = null;
        }
        String str = jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "mJumpGuildParam.guildId");
        return str;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FacadeFragmentOnlineReportHelper.h();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FacadeFragmentOnlineReportHelper.j(getGuildId());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int i3 = this.mCategoryType;
        if (i3 != 3) {
            if (i3 == 9) {
                setTitle(HardCodeUtil.qqStr(R.string.f142150il));
            }
        } else if (this.mSceneType == 1) {
            setTitle(HardCodeUtil.qqStr(R.string.f141580h2));
        } else {
            setTitle(HardCodeUtil.qqStr(R.string.f141560h0));
        }
        rh();
        GuildSplitViewUtils.f235370a.B(this.N);
        Gh();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (guildDefaultThemeNavBarCommon != null) {
            guildDefaultThemeNavBarCommon.a();
        }
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.J;
        if (guildDefaultThemeNavBarCommon2 != null) {
            guildDefaultThemeNavBarCommon2.setBackgroundResource(R.drawable.lvj);
        }
        if (QQTheme.isDefaultTheme() || QQTheme.isThemeSimpleDayUI(QQTheme.getCurrentThemeId())) {
            Logger.f235387a.d().c("GuildLiveListFragment", 1, "navbarApplyTokenStyle, specially tint page background!");
            Bh(R.drawable.qui_common_bg_bottom_light_bg);
            this.N.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
    }
}
