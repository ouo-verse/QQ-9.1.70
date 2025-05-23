package com.tencent.mobileqq.guild.feed.nativepublish.fragment;

import android.view.View;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/fragment/FeedThirdPlatformVideoWebFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Landroid/view/View;", "contentView", "", "out", "", "ph", "onStart", DKHippyEvent.EVENT_STOP, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedThirdPlatformVideoWebFragment extends WebViewFragment {
    private final void ph(View contentView, boolean out) {
        GuildFeedDetailInitBean guildFeedDetailInitBean;
        GuildFeedBaseInitBean q16 = ax.q(getActivity());
        if (q16 == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        String str = null;
        if (q16 instanceof GuildFeedDetailInitBean) {
            guildFeedDetailInitBean = (GuildFeedDetailInitBean) q16;
        } else {
            guildFeedDetailInitBean = null;
        }
        if (guildFeedDetailInitBean != null) {
            str = guildFeedDetailInitBean.getFeedId();
        }
        if (str == null) {
            str = "";
        }
        VideoReport.setPageId(contentView, "pg_sgrp_forum_otherapp_viewer");
        VideoReport.setElementExposePolicy(contentView, ExposurePolicy.REPORT_ALL);
        hashMap.put("sgrp_content_id", str);
        hashMap.put("sgrp_user_type", q16.getUserType());
        hashMap.put("sgrp_channel_id", q16.getGuildId());
        hashMap.put("sgrp_sub_channel_id", q16.getChannelId());
        hashMap.put("sgrp_forum_viewer_enter_source", Integer.valueOf(q16.getImmersiveSource()));
        VideoReport.setPageParams(contentView, new PageParams(hashMap));
        if (out) {
            VideoReport.reportPgOut(contentView);
        } else {
            VideoReport.reportPgIn(contentView);
        }
        QLog.i("FeedThirdPlatformVideoWebFragment", 1, "dtPageReport out=" + out + " feedId=" + str + " userType=" + q16.getUserType() + " guildId=" + q16.getGuildId() + " channelId=" + q16.getChannelId() + " immersiveSource=" + q16.getImmersiveSource());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        WebBrowserViewContainerKt contentView = this.contentView;
        if (contentView != null) {
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            ph(contentView, false);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        WebBrowserViewContainerKt contentView = this.contentView;
        if (contentView != null) {
            Intrinsics.checkNotNullExpressionValue(contentView, "contentView");
            ph(contentView, true);
        }
    }
}
