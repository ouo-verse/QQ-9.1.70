package com.tencent.mobileqq.guild.feed.widget.sort;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.viewmodel.j;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\b\u0010\f\u001a\u00020\u0006H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/widget/sort/g;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "", "N7", VasPerfReportUtils.WHILE_UPDATE_ITEM, "Lcom/tencent/mobileqq/guild/feed/viewmodel/j;", "viewModel", "b2", "destroy", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface g extends View.OnClickListener {
    void N7(@NotNull View rootView, @Nullable GuildFeedBaseInitBean initBean);

    void b2(@Nullable j viewModel);

    void destroy();

    void updateView();
}
