package com.tencent.mobileqq.guild.discoveryv2.content.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendAbsFeedData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendGroupData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendRobotData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendSchemeData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendVideoMixData;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.k;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.l;
import com.tencent.mobileqq.guild.discoveryv2.dialog.RecommendFeedbackDialog;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedStat;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProImage;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTopicContent;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProThumbImage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.IRobotAIORouteApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\f*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J$\u0010\u0016\u001a\u00020\u00042\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ*\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ*\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tJ\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010 \u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u0007J\u001e\u0010%\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020#2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\nR\u0017\u0010)\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/d;", "", "", "sourceType", "", "a", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendAbsFeedData;", "Landroid/view/View;", "cardView", "Lkotlin/Pair;", "", "joinSource", "Landroid/content/Intent;", "b", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "e", "data", "", h.F, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/l;", "v", "position", "i", "j", "d", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendVideoMixData;", "o", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendGroupData;", "g", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendRobotData;", "k", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/RecommendSchemeData;", "l", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMVPTopicContent;", "traceId", DomainData.DOMAIN_NAME, "I", "f", "()I", "source", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int source;

    public d(int i3) {
        this.source = i3;
    }

    private final boolean a(int sourceType) {
        if (sourceType != 3 && sourceType != 4 && sourceType != 5) {
            return false;
        }
        return true;
    }

    private final Intent b(RecommendAbsFeedData recommendAbsFeedData, View view, Pair<String, String> pair) {
        Intent intent = new Intent();
        intent.putExtra("last_Modified_Time", recommendAbsFeedData.getRecommendItem().getLastModifiedTime());
        intent.putExtra("recommend_feed_detail_data", recommendAbsFeedData.getRecommendItem());
        intent.putExtra("join_info_param", (Parcelable) new JumpGuildParam.JoinInfoParam(String.valueOf(recommendAbsFeedData.getGuildInfo().getChannelId()), recommendAbsFeedData.getGuildInfo().getJoinGuildSig(), pair.getFirst(), pair.getSecond()));
        AnimationParams e16 = e(view);
        Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type android.os.Parcelable");
        intent.putExtra("feed_detail_animation_params", (Parcelable) e16);
        intent.putExtra("trace_Id", recommendAbsFeedData.getRecommendExtData().getTraceId());
        intent.putExtra("feed_immersive_source", ci1.a.e(this.source, pair.getFirst()));
        return intent;
    }

    private final AnimationParams e(View cardView) {
        View view = (ImageView) cardView.findViewById(R.id.w5l);
        if (view == null) {
            view = cardView;
        }
        view.getLocationOnScreen(new int[2]);
        return new AnimationParams(r1[0], r1[1], view.getWidth(), view.getHeight(), cardView.getHeight());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h(View cardView, RecommendAbsFeedData data) {
        List mutableListOf;
        List<String> listOf;
        Drawable drawable = null;
        if (data instanceof k) {
            ImageView imageView = (ImageView) cardView.findViewById(R.id.w5l);
            if (imageView != null) {
                drawable = imageView.getDrawable();
            }
            IGuildFeedImagePreDecoder iGuildFeedImagePreDecoder = (IGuildFeedImagePreDecoder) QRoute.api(IGuildFeedImagePreDecoder.class);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(((k) data).getMediaCoverURL());
            iGuildFeedImagePreDecoder.putIfAbsent(listOf, drawable);
            return;
        }
        QRouteApi api = QRoute.api(IGuildFeedImagePreDecoder.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedImagePreDecoder::class.java)");
        IGuildFeedImagePreDecoder iGuildFeedImagePreDecoder2 = (IGuildFeedImagePreDecoder) api;
        ArrayList<IGProThumbImage> thumbImages = data.getImage().getThumbImages();
        Intrinsics.checkNotNullExpressionValue(thumbImages, "data.image.thumbImages");
        String url = data.getImage().getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "data.image.url");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(url);
        List list = mutableListOf;
        Iterator<T> it = thumbImages.iterator();
        while (it.hasNext()) {
            String url2 = ((IGProThumbImage) it.next()).getUrl();
            if (url2 != null) {
                list.add(url2);
            }
        }
        IGuildFeedImagePreDecoder.a.a(iGuildFeedImagePreDecoder2, list, null, 2, null);
    }

    public final void c(@NotNull RecommendAbsFeedData data, @NotNull View v3, @NotNull Pair<String, String> joinSource) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(joinSource, "joinSource");
        if (!o.c("fastClickGuard")) {
            QRouteApi api = QRoute.api(IGuildFeedNativeDetailApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedNativeDetailApi::class.java)");
            IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi = (IGuildFeedNativeDetailApi) api;
            if (iGuildFeedNativeDetailApi.needOpenNativeDetailPage(data)) {
                h(v3, data);
                com.tencent.mobileqq.guild.discoveryv2.util.d dVar = com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a;
                IGProImage image = data.getImage();
                Intrinsics.checkNotNullExpressionValue(image, "data.image");
                dVar.e(com.tencent.mobileqq.guild.discoveryv2.util.e.c(image), data.getImage().getWidth(), data.getImage().getHeight());
                Intent b16 = b(data, v3, joinSource);
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                String valueOf = String.valueOf(data.getGuildInfo().getGuildId());
                String valueOf2 = String.valueOf(data.getGuildInfo().getChannelId());
                String idd = data.getIdd();
                Intrinsics.checkNotNullExpressionValue(idd, "data.idd");
                iGuildFeedNativeDetailApi.openFeedNativeDetailPage(context, valueOf, valueOf2, idd, 17, b16, false);
                return;
            }
            com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
            QRouteApi api2 = QRoute.api(IGuildFeedLauncherApi.class);
            Intrinsics.checkNotNullExpressionValue(api2, "api(T::class.java)");
            ((IGuildFeedLauncherApi) api2).launchGuildFeedDetailActivity(v3, data, data.getRecommendExtData().getTraceId(), joinSource.getFirst(), joinSource.getSecond(), this.source);
        }
    }

    public boolean d(@NotNull RecommendAbsFeedData data, @NotNull View v3, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (a(this.source)) {
            return true;
        }
        return j(data, v3, position);
    }

    /* renamed from: f, reason: from getter */
    public final int getSource() {
        return this.source;
    }

    public final void g(@NotNull RecommendGroupData data, @NotNull View v3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.c("fastClickGuard")) {
            com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
            QRouteApi api = QRoute.api(ITroopUtilApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
            ((ITroopUtilApi) api).openTroopInfoActivity(v3.getContext(), aq.d(String.valueOf(data.getGroupCode()), data.getJoinGroupAuth(), 1017), 2);
        }
    }

    public boolean i(@NotNull l<?> data, @NotNull View v3, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.c("fastClickGuard")) {
            RecommendFeedbackDialog recommendFeedbackDialog = RecommendFeedbackDialog.f217414a;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            RecommendFeedbackDialog.e(recommendFeedbackDialog, context, recommendFeedbackDialog.c(data, position), data, null, 8, null);
            return true;
        }
        return true;
    }

    public final boolean j(@NotNull RecommendAbsFeedData data, @NotNull View v3, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.c("fastClickGuard")) {
            RecommendFeedbackDialog recommendFeedbackDialog = RecommendFeedbackDialog.f217414a;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            Map<String, Object> c16 = recommendFeedbackDialog.c(data, position);
            String idd = data.getIdd();
            Intrinsics.checkNotNullExpressionValue(idd, "data.idd");
            recommendFeedbackDialog.d(context, c16, data, recommendFeedbackDialog.b(idd, data));
            return true;
        }
        return true;
    }

    public final void k(@NotNull RecommendRobotData data, @NotNull View v3) {
        Activity activity;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.c("fastClickGuard")) {
            QLog.i("RecommendRobotData", 1, "robotSectionOnClick, data=" + data);
            Context context = v3.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            Activity activity2 = activity;
            if (activity2 == null) {
                return;
            }
            ((IRobotAIORouteApi) QRoute.api(IRobotAIORouteApi.class)).fetchAndRouteToRobotAIO(new RobotAIORouteArgs(activity2, String.valueOf(data.getRobotUin()), null, "29", null, false, null, null, null, 500, null));
        }
    }

    public final void l(@NotNull RecommendSchemeData data, @NotNull View v3) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.c("fastClickGuard")) {
            com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
            QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
            String jumpUrl = data.getJumpUrl();
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "data.jumpUrl");
            ((IGuildFeedLauncherApi) api).launchByScheme(jumpUrl);
        }
    }

    public final void m(@NotNull RecommendAbsFeedData data, @NotNull View v3, @NotNull Pair<String, String> joinSource) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(joinSource, "joinSource");
        if (!o.c("fastClickGuard")) {
            com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
            QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
            ((IGuildFeedLauncherApi) api).launchGuildFeedDetailActivity(v3, data, data.getRecommendExtData().getTraceId(), joinSource.getFirst(), joinSource.getSecond(), this.source);
        }
    }

    public final void n(@NotNull IGProMVPTopicContent data, @NotNull View v3, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        if (!o.c("fastClickGuard")) {
            com.tencent.mobileqq.guild.base.extension.o oVar = com.tencent.mobileqq.guild.base.extension.o.f214742a;
            QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(T::class.java)");
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            ((IGuildFeedLauncherApi) api).launchTopicFeeds(context, data.getTopicId(), data.getTopicName(), traceId);
        }
    }

    public final void o(@NotNull RecommendVideoMixData data, @NotNull View v3, @NotNull Pair<String, String> joinSource) {
        View view;
        long j3;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(joinSource, "joinSource");
        if (!o.c("fastClickGuard")) {
            ImageView imageView = (ImageView) v3.findViewById(R.id.w5v);
            if (imageView == null) {
                view = v3;
            } else {
                Intrinsics.checkNotNullExpressionValue(imageView, "v.findViewById<ImageView\u2026v2_feed_video_cover) ?: v");
                view = imageView;
            }
            IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            String c16 = ci1.a.c();
            int b16 = ci1.a.b(this.source);
            int mUpVoteStatus = data.getMUpVoteStatus();
            long mUpVoteCount = data.getMUpVoteCount();
            IGProFeedStat feedStat = data.getFeedStat();
            if (feedStat != null) {
                j3 = feedStat.getTotalCommentCount();
            } else {
                j3 = 0;
            }
            iGuildFeedLauncherApi.launchGuildFeedGalleryActivity(context, data, c16, b16, mUpVoteStatus, mUpVoteCount, j3, data.getRecommendExtData().getTraceId(), joinSource.getFirst(), joinSource.getSecond(), ci1.a.e(this.source, joinSource.getFirst()), view);
        }
    }
}
