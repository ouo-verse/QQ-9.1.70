package com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discovery.search.GuildSearchEntryController;
import com.tencent.mobileqq.guild.discovery.search.GuildSearchEntryView;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/guildblockdetail/newrecommend/t;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryView;", "searchView", "", "z9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "d", "Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryView;", "guildSearchEntryView", "<init>", "()V", "e", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class t extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildSearchEntryView guildSearchEntryView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(GuildSearchEntryController searchEntryController, t this$0, int i3, GuildAppReportSourceInfo reportSourceInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(searchEntryController, "$searchEntryController");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportSourceInfo, "$reportSourceInfo");
        searchEntryController.getSearchEntryView().e();
        String c16 = searchEntryController.getSearchEntryView().c();
        nh1.c cVar = nh1.c.f420140a;
        GuildSearchEntryView guildSearchEntryView = this$0.guildSearchEntryView;
        Intrinsics.checkNotNull(guildSearchEntryView);
        Context context = guildSearchEntryView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "guildSearchEntryView!!.context");
        cVar.a(context, c16, i3, false, reportSourceInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void z9(GuildSearchEntryView searchView) {
        final GuildAppReportSourceInfo guildAppReportSourceInfo;
        Bundle arguments;
        this.guildSearchEntryView = searchView;
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (arguments = hostFragment.getArguments()) != null) {
            guildAppReportSourceInfo = (GuildAppReportSourceInfo) arguments.getParcelable("GuildAppReportSourceInfo");
        } else {
            guildAppReportSourceInfo = null;
        }
        if (guildAppReportSourceInfo == null) {
            guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        }
        if (getHostFragment() == null) {
            QLog.d("guild.re.new.GuildRecommendSearchPart", 4, "initSearchView error");
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        Fragment hostFragment2 = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment2, "hostFragment");
        GuildSearchEntryView guildSearchEntryView = this.guildSearchEntryView;
        Intrinsics.checkNotNull(guildSearchEntryView);
        final int i3 = 1;
        final GuildSearchEntryController guildSearchEntryController = new GuildSearchEntryController(lifecycleOwner, hostFragment2, guildSearchEntryView, 1);
        guildSearchEntryController.getSearchEntryView().setCenterAlign();
        guildSearchEntryController.getSearchEntryView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.A9(GuildSearchEntryController.this, this, i3, guildAppReportSourceInfo, view);
            }
        });
        GuildSearchEntryView guildSearchEntryView2 = this.guildSearchEntryView;
        Intrinsics.checkNotNull(guildSearchEntryView2);
        guildSearchEntryView2.setIsUseTokenType(true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            View findViewById = rootView.findViewById(R.id.wzj);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_search_entry_view)");
            z9((GuildSearchEntryView) findViewById);
        }
    }
}
