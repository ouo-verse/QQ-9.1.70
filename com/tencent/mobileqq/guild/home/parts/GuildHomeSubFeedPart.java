package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel;
import com.tencent.mobileqq.guild.home.views.GuildHomeSubFeedContentLayout;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ba;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 /2\u00020\u0001:\u00010B'\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0006\u0010\u000f\u001a\u00020\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFeedPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartPause", "onPartStop", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "d", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "e", "Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;", "guildHomePermissionViewModel", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "f", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", tl.h.F, "loadTabTimeCostReportTask", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFeedContentLayout;", "i", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFeedContentLayout;", "contentLayout", "Landroidx/fragment/app/Fragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "fragment", BdhLogUtil.LogTag.Tag_Conn, "Z", "hasPaused", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;Lcom/tencent/mobileqq/guild/home/viewmodels/permission/GuildHomePermissionViewModel;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubFeedPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasPaused;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam jumpGuildParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildHomePermissionViewModel guildHomePermissionViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask reportTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask loadTabTimeCostReportTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildHomeSubFeedContentLayout contentLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Fragment fragment;

    public GuildHomeSubFeedPart(@NotNull JumpGuildParam jumpGuildParam, @NotNull GuildHomePermissionViewModel guildHomePermissionViewModel, @NotNull IPerformanceReportTask reportTask, @NotNull IPerformanceReportTask loadTabTimeCostReportTask) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        Intrinsics.checkNotNullParameter(guildHomePermissionViewModel, "guildHomePermissionViewModel");
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        Intrinsics.checkNotNullParameter(loadTabTimeCostReportTask, "loadTabTimeCostReportTask");
        this.jumpGuildParam = jumpGuildParam;
        this.guildHomePermissionViewModel = guildHomePermissionViewModel;
        this.reportTask = reportTask;
        this.loadTabTimeCostReportTask = loadTabTimeCostReportTask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9() {
        Bundle arguments;
        try {
            Logger.f235387a.d().i("Guild.NewHome.content.GuildHomeContentFeedPart", 1, "setPauseFlag");
            Fragment fragment = this.fragment;
            if (fragment != null && (arguments = fragment.getArguments()) != null) {
                arguments.putBoolean("key_has_parent_paused", this.hasPaused);
            }
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "setPauseFlag err " + e16.getMessage();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.content.GuildHomeContentFeedPart", 1, (String) it.next(), null);
            }
        }
    }

    public final void D9() {
        ba.Companion companion = com.tencent.mobileqq.guild.util.ba.INSTANCE;
        String str = this.jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to(JumpGuildParam.KEY_JOIN_INFO_PARAM, this.jumpGuildParam.getJoinInfoParam()), TuplesKt.to(JumpGuildParam.EXTRA_SETTING_ENTRANCE_VISIBLE, this.guildHomePermissionViewModel.c2().getValue()), TuplesKt.to(JumpGuildParam.EXTRA_FEED_HOME_CATEGORY_LOCATE_TYPE, Integer.valueOf(companion.d(str))), TuplesKt.to(JumpGuildParam.EXTRA_FEED_HOME_SELECTED_HOT_TAB, Boolean.valueOf(this.jumpGuildParam.extras.getBoolean(JumpGuildParam.EXTRA_FEED_HOME_SELECTED_HOT_TAB, false))), TuplesKt.to(JumpGuildParam.KEY_DETAIL_PAGE_JUMP_INFO, this.jumpGuildParam.getDetailPageJumpInfo()));
        bundleOf.putAll(this.jumpGuildParam.extras);
        qw1.b.u(bundleOf, this.reportTask, null, 2, null);
        qw1.b.t(bundleOf, this.loadTabTimeCostReportTask, "_extra_param_report_task_view_pager_tab");
        IGProChannelInfo B = com.tencent.mobileqq.guild.util.ch.B(this.jumpGuildParam.getChannelId());
        if (B != null && B.getType() == 7) {
            bundleOf.putString("channelId", this.jumpGuildParam.getChannelId());
        }
        if (this.fragment == null) {
            BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this), null, null, new GuildHomeSubFeedPart$updateGuild$2(this, bundleOf, null), 3, null);
        } else {
            Logger.f235387a.d().i("Guild.NewHome.content.GuildHomeContentFeedPart", 1, "onInitView fragment recreated!");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = this.fragment;
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        BasePartFragment basePartFragment;
        Logger.f235387a.d().i("Guild.NewHome.content.GuildHomeContentFeedPart", 1, "onBackEvent id:" + com.tencent.mobileqq.guild.base.extension.m.a(this));
        if (super.onBackEvent()) {
            return true;
        }
        Fragment fragment = this.fragment;
        if (fragment instanceof BasePartFragment) {
            basePartFragment = (BasePartFragment) fragment;
        } else {
            basePartFragment = null;
        }
        if (basePartFragment == null) {
            return false;
        }
        return basePartFragment.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Logger.f235387a.d().i("Guild.NewHome.content.GuildHomeContentFeedPart", 1, "onInitView id:" + System.identityHashCode(this));
        View findViewById = rootView.findViewById(R.id.b9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_layout)");
        this.contentLayout = (GuildHomeSubFeedContentLayout) findViewById;
        D9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        this.hasPaused = true;
        C9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        super.onPartStop(activity);
        this.hasPaused = true;
        C9();
    }
}
