package com.tencent.mobileqq.guild.discoveryv2.content.recommend.section;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.RecommendReportHelperKt;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendVideoMixData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b;
import com.tencent.mobileqq.guild.discoveryv2.util.ExtKt;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.MVPFeedsFeedVideoView;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0015B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0014J\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0013H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010$\u001a\u00020\u001f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ba;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/ar;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendVideoMixData;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/section/b;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "t", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView;", ReportConstant.COSTREPORT_PREFIX, "", DomainData.DOMAIN_NAME, "a", NodeProps.VISIBLE, "onVisibleChanged", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mCover", "f", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/MVPFeedsFeedVideoView;", "videoView", "", tl.h.F, "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "i", "()I", "playPriority", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ba extends ar<RecommendVideoMixData> implements b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mCover;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MVPFeedsFeedVideoView videoView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String type = "VideoFeed";

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public boolean a() {
        MVPFeedsFeedVideoView mVPFeedsFeedVideoView = this.videoView;
        if (mVPFeedsFeedVideoView != null) {
            MVPFeedsFeedVideoView mVPFeedsFeedVideoView2 = null;
            if (mVPFeedsFeedVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
                mVPFeedsFeedVideoView = null;
            }
            mVPFeedsFeedVideoView.s();
            MVPFeedsFeedVideoView mVPFeedsFeedVideoView3 = this.videoView;
            if (mVPFeedsFeedVideoView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoView");
            } else {
                mVPFeedsFeedVideoView2 = mVPFeedsFeedVideoView3;
            }
            VideoReport.unbindVideoPlayerInfo(mVPFeedsFeedVideoView2);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    @NotNull
    public String getType() {
        return this.type;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.w5w};
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public int i() {
        return this.mPosition;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public void l() {
        b.a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.guild.discoveryv2.content.recommend.section.b
    public boolean n() {
        Map<String, ?> mapOf;
        if (ExtKt.c(getStubView(R.id.w5w)) <= 0.5d) {
            a();
            return false;
        }
        GProStVideo gproStVideo = ((RecommendVideoMixData) this.mData).getGproStVideo();
        if (gproStVideo == null) {
            return false;
        }
        MVPFeedsFeedVideoView s16 = s();
        s16.setPlayLevel(25);
        MVPFeedsFeedVideoView.setStVideo$default(s16, gproStVideo, 0, 2, null);
        s16.t();
        VideoEntity.Builder videoDuration = new VideoEntity.Builder().setContentId(gproStVideo.fileId).setContentType(2).setPage((Object) ci1.a.c()).setVideoView((View) s16).setVideoDuration(gproStVideo.duration);
        T mData = this.mData;
        Intrinsics.checkNotNullExpressionValue(mData, "mData");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_eid", RecommendReportHelperKt.b((com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l) mData)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, ((RecommendVideoMixData) this.mData).getRecommendExtData().getTraceId()), TuplesKt.to("sgrp_rank", Integer.valueOf(this.mPosition)), TuplesKt.to("sgrp_video_id", ((RecommendVideoMixData) this.mData).getIdd()), TuplesKt.to("sgrp_channel_id", Long.valueOf(((RecommendVideoMixData) this.mData).getRecommendItem().getGuildInfo().getGuildId())), TuplesKt.to("sgrp_sub_channel_id", Long.valueOf(((RecommendVideoMixData) this.mData).getRecommendItem().getGuildInfo().getChannelId())));
        VideoReport.bindVideoPlayerInfo(s16, videoDuration.addCustomParams(mapOf).build());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w5v);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026very_v2_feed_video_cover)");
        this.mCover = (ImageView) findViewById;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        if (visible) {
            q().g().a(this);
        } else {
            q().g().b(this);
        }
    }

    @NotNull
    public final MVPFeedsFeedVideoView s() {
        if (this.videoView == null) {
            View stubView = getStubView(R.id.w5w);
            Intrinsics.checkNotNull(stubView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) stubView;
            Context context = this.mRootView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
            MVPFeedsFeedVideoView mVPFeedsFeedVideoView = new MVPFeedsFeedVideoView(context, null, 0, 0, 14, null);
            this.videoView = mVPFeedsFeedVideoView;
            ImageView imageView = this.mCover;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCover");
                imageView = null;
            }
            viewGroup.addView(mVPFeedsFeedVideoView, viewGroup.indexOfChild(imageView) + 1, new FrameLayout.LayoutParams(-1, -1));
        }
        MVPFeedsFeedVideoView mVPFeedsFeedVideoView2 = this.videoView;
        if (mVPFeedsFeedVideoView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoView");
            return null;
        }
        return mVPFeedsFeedVideoView2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r12 != false) goto L18;
     */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindData(@NotNull RecommendVideoMixData data, int position, @Nullable List<Object> payload) {
        boolean z16;
        boolean isBlank;
        String str;
        ImageView imageView;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(data, "data");
        List<Object> list = payload;
        boolean z17 = false;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        String mediaCoverURL = data.getMediaCoverURL();
        isBlank = StringsKt__StringsJVMKt.isBlank(mediaCoverURL);
        if (!isBlank) {
            str = mediaCoverURL;
        } else {
            str = null;
        }
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
        }
        z17 = true;
        if (z17) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "onBindData cover is null " + data;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("RecommendMixVideoSection", 1, (String) it.next(), null);
            }
            return;
        }
        com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
        ImageView imageView2 = this.mCover;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCover");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        dVar.b(imageView, str, q().b(), q().h(), true);
    }
}
