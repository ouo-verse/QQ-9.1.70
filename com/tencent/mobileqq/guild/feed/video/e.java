package com.tencent.mobileqq.guild.feed.video;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.report.GuildPublishQualityReporter;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/video/e;", "", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "", "currentIndex", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "sourceInitBean", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "video", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f223991a = new e();

    e() {
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedGalleryInitBean a(@NotNull View view, @NotNull GProStFeed feed, int currentIndex, @NotNull GuildFeedBaseInitBean sourceInitBean) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(feed, "feed");
        Intrinsics.checkNotNullParameter(sourceInitBean, "sourceInitBean");
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setRichMediaDataList(am.f(feed, "pg_channel_forum_page")).setEnterPos(currentIndex);
        guildFeedGalleryInitBean.setBusinessType(sourceInitBean.getBusinessType());
        if (guildFeedGalleryInitBean.getBusinessType() == 7) {
            guildFeedGalleryInitBean.setTroopUin(sourceInitBean.getTroopUin());
            guildFeedGalleryInitBean.setTroopRole(sourceInitBean.getTroopRole());
        }
        guildFeedGalleryInitBean.setTopicId(sourceInitBean.getTopicId());
        guildFeedGalleryInitBean.setFeed(feed);
        TransitionBean transitionBean = new TransitionBean();
        transitionBean.setEnterViewRect(view);
        Intrinsics.checkNotNullExpressionValue(feed.videos, "feed.videos");
        if (!r4.isEmpty()) {
            GProStImage gProStImage = feed.videos.get(0).cover;
            Intrinsics.checkNotNullExpressionValue(gProStImage, "feed.videos[0].cover");
            String coverUrl = gProStImage.picUrl;
            Intrinsics.checkNotNullExpressionValue(coverUrl, "coverUrl");
            if (coverUrl.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                List<GProStImageUrl> n3 = bm.n(gProStImage);
                if (!n3.isEmpty()) {
                    transitionBean.setStImage(n3.get(0).url, n3.get(0).width, n3.get(0).height);
                } else {
                    QLog.w("GuildFeedListVideoItemWidgetView", 1, "openVideo thumbnailUrlList is empty");
                }
            } else {
                transitionBean.setStImage(gProStImage.picUrl, gProStImage.width, gProStImage.height);
            }
        }
        transitionBean.setScaleType(ImageView.ScaleType.FIT_CENTER);
        guildFeedGalleryInitBean.setTransitionBean(transitionBean);
        guildFeedGalleryInitBean.setFromPage(2);
        String str = sourceInitBean.getJumpExtraInfo().getReportInfoMap().get("sgrp_stream_pgin_source_name");
        if (str == null) {
            str = "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_stream_pgin_source_name", str);
        String b16 = GuildPublishQualityReporter.b();
        Intrinsics.checkNotNullExpressionValue(b16, "getTraceId()");
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, b16);
        guildFeedGalleryInitBean.getJumpExtraInfo().addReportItems(hashMap);
        guildFeedGalleryInitBean.setJoinInfoParam(sourceInitBean.getJoinInfoParam());
        return guildFeedGalleryInitBean;
    }

    @Nullable
    public final String b(@Nullable GProStVideo video) {
        if (video == null) {
            return "";
        }
        if (!TextUtils.isEmpty(video.fileId)) {
            return video.fileId;
        }
        return video.playUrl;
    }
}
