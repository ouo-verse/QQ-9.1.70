package com.tencent.mobileqq.guild.home.parts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.home.views.GuildHomeSubFeedContentLayout;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import cooperation.qzone.QzoneIPCModule;
import defpackage.FeedSectionTabLaunchParam;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFeedSectionPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "d", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "e", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "f", "loadTabTimeCostReportTask", "Landroid/os/Bundle;", tl.h.F, "Landroid/os/Bundle;", "fragmentArguments", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFeedContentLayout;", "i", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeSubFeedContentLayout;", "contentLayout", "Landroidx/fragment/app/Fragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Landroid/os/Bundle;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubFeedSectionPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JumpGuildParam jumpGuildParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask reportTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IPerformanceReportTask loadTabTimeCostReportTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle fragmentArguments;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildHomeSubFeedContentLayout contentLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Fragment fragment;

    public GuildHomeSubFeedSectionPart(@NotNull JumpGuildParam jumpGuildParam, @NotNull IPerformanceReportTask reportTask, @NotNull IPerformanceReportTask loadTabTimeCostReportTask, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        Intrinsics.checkNotNullParameter(reportTask, "reportTask");
        Intrinsics.checkNotNullParameter(loadTabTimeCostReportTask, "loadTabTimeCostReportTask");
        this.jumpGuildParam = jumpGuildParam;
        this.reportTask = reportTask;
        this.loadTabTimeCostReportTask = loadTabTimeCostReportTask;
        this.fragmentArguments = bundle;
    }

    private final void C9() {
        boolean z16;
        boolean z17 = false;
        Bundle bundleOf = BundleKt.bundleOf(new Pair[0]);
        bundleOf.putAll(this.jumpGuildParam.extras);
        bundleOf.putAll(this.fragmentArguments);
        qw1.b.u(bundleOf, this.reportTask, null, 2, null);
        qw1.b.t(bundleOf, this.loadTabTimeCostReportTask, "_extra_param_report_task_view_pager_tab");
        if (this.fragment != null) {
            Logger.f235387a.d().i("Guild.NewHome.content.GuildHomeContentFeedPart", 1, "onInitView fragment recreated!");
            return;
        }
        if (this.fragmentArguments == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onInitView fragmentArguments == null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.content.GuildHomeContentFeedPart", 1, (String) it.next(), null);
            }
            return;
        }
        String str = this.jumpGuildParam.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
        String string = this.fragmentArguments.getString("channelId");
        String str2 = "";
        if (string == null) {
            string = "";
        }
        String string2 = this.fragmentArguments.getString("EXTRA_CATEGORY_NAME");
        if (string2 != null) {
            str2 = string2;
        }
        FeedSectionTabLaunchParam feedSectionTabLaunchParam = new FeedSectionTabLaunchParam(str, string, str2, this.jumpGuildParam.getJoinInfoParam());
        if (feedSectionTabLaunchParam.getChannelId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("onInitView fragmentArguments.channelId isEmpty");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.content.GuildHomeContentFeedPart", 1, (String) it5.next(), null);
            }
        }
        if (feedSectionTabLaunchParam.getSectionName().length() == 0) {
            z17 = true;
        }
        if (z17) {
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("onInitView fragmentArguments.sectionName isEmpty");
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("Guild.NewHome.content.GuildHomeContentFeedPart", 1, (String) it6.next(), null);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this), null, null, new GuildHomeSubFeedSectionPart$prepareFeedFragment$5(this, feedSectionTabLaunchParam, null), 3, null);
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
        C9();
    }
}
