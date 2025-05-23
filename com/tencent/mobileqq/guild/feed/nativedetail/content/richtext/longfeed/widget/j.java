package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.part.GuildFeedGalleryPreloadPart;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J6\u0010\u0012\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0007JM\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/j;", "", "Landroid/widget/ImageView;", "view", "Landroid/graphics/drawable/Drawable;", "a", "", "url", "imageView", "", "d", "rawFeed", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "enterMedia", "", "businessType", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "feedPublishInfo", "b", "Landroid/view/View;", "v", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "enterVideo", "immersiveSource", "", "topicId", "c", "(Landroid/view/View;Ljava/lang/Object;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;ILjava/lang/Integer;Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;Ljava/lang/Long;)V", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f221614a = new j();

    j() {
    }

    private final Drawable a(ImageView view) {
        GifDrawable gifDrawable;
        Drawable drawable = view.getDrawable();
        if (drawable instanceof GifDrawable) {
            gifDrawable = (GifDrawable) drawable;
        } else {
            gifDrawable = null;
        }
        if (gifDrawable != null) {
            return new BitmapDrawable(view.getResources(), gifDrawable.b());
        }
        return view.getDrawable();
    }

    private final void d(String url, ImageView imageView) {
        Drawable a16 = a(imageView);
        if (a16 != null) {
            GuildFeedGalleryPreloadPart.J9(com.tencent.mobileqq.guild.picload.e.d(url), ImageUtil.drawableToBitmap(a16));
        }
    }

    @JvmOverloads
    public final void b(@Nullable ImageView view, @Nullable Object rawFeed, @NotNull GProStImage enterMedia, int businessType, @Nullable GuildFeedPublishInfo feedPublishInfo) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(enterMedia, "enterMedia");
        GProStFeed gProStFeed = rawFeed instanceof GProStFeed ? (GProStFeed) rawFeed : null;
        if (gProStFeed == null) {
            return;
        }
        Intent intent = new Intent();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setFeed(gProStFeed);
        guildFeedGalleryInitBean.setFeedId(gProStFeed.idd);
        Long valueOf = Long.valueOf(gProStFeed.groupCode);
        boolean z16 = true;
        if (!Boolean.valueOf(valueOf.longValue() > 0).booleanValue()) {
            valueOf = null;
        }
        guildFeedGalleryInitBean.setTroopUin(valueOf != null ? valueOf.toString() : null);
        Long valueOf2 = Long.valueOf(guildFeedGalleryInitBean.getFeed().channelInfo.sign.guildId);
        if (!Boolean.valueOf(valueOf2.longValue() > 0).booleanValue()) {
            valueOf2 = null;
        }
        guildFeedGalleryInitBean.setGuildId(valueOf2 != null ? valueOf2.toString() : null);
        Long valueOf3 = Long.valueOf(guildFeedGalleryInitBean.getFeed().channelInfo.sign.channelId);
        if (!Boolean.valueOf(valueOf3.longValue() > 0).booleanValue()) {
            valueOf3 = null;
        }
        guildFeedGalleryInitBean.setChannelId(valueOf3 != null ? valueOf3.toString() : null);
        guildFeedGalleryInitBean.setRichMediaDataList(am.d(com.tencent.mobileqq.guild.feed.adapter.n.m(gProStFeed), "pg_channel_forum_page"));
        List<GuildFeedRichMediaData> richMediaDataList = guildFeedGalleryInitBean.getRichMediaDataList();
        Intrinsics.checkNotNullExpressionValue(richMediaDataList, "richMediaDataList");
        Iterator<T> it = richMediaDataList.iterator();
        while (it.hasNext()) {
            ((GuildFeedRichMediaData) it.next()).setVideoScreenPlay(false);
        }
        List<GuildFeedRichMediaData> richMediaDataList2 = guildFeedGalleryInitBean.getRichMediaDataList();
        Intrinsics.checkNotNullExpressionValue(richMediaDataList2, "richMediaDataList");
        Iterator<GuildFeedRichMediaData> it5 = richMediaDataList2.iterator();
        int i3 = 0;
        while (true) {
            if (!it5.hasNext()) {
                i3 = -1;
                break;
            } else {
                if (it5.next().getImage().displayIndex == enterMedia.displayIndex) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 0);
        guildFeedGalleryInitBean.setEnterPos(coerceAtLeast);
        guildFeedGalleryInitBean.setShowMoreIcon(false);
        guildFeedGalleryInitBean.setShowCloseIcon(false);
        guildFeedGalleryInitBean.setShowPageIndex(true);
        guildFeedGalleryInitBean.setOpenType(2);
        guildFeedGalleryInitBean.setBusinessType(businessType);
        guildFeedGalleryInitBean.setLongPresPopMoreDialog(true);
        guildFeedGalleryInitBean.setGuildFeedPublishInfo(feedPublishInfo);
        if (view != null) {
            j jVar = f221614a;
            jVar.d(pl1.a.d(enterMedia), view);
            TransitionAnimUtil.saveCoverDrawable(jVar.a(view));
            TransitionHelper.TransitionBeanCreator transitionBeanCreator = (TransitionHelper.TransitionBeanCreator) yl1.n.s(view, TransitionHelper.TransitionBeanCreator.class);
            if (transitionBeanCreator != null) {
                guildFeedGalleryInitBean.setTransitionBean(transitionBeanCreator.generateTransitionBean(enterMedia.displayIndex));
                guildFeedGalleryInitBean.setTransitionBeanCreatorKey(TransitionHelper.g().registerTransitionBeanCreator(transitionBeanCreator));
                guildFeedGalleryInitBean.setNeedTransitionAnim(true);
                guildFeedGalleryInitBean.setNeedOpenTransitionAnim(true);
            }
            AnimationParams a16 = AnimationParams.INSTANCE.a(view);
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type android.os.Parcelable");
            intent.putExtra("feed_detail_animation_params", (Parcelable) a16);
        }
        List<GuildFeedRichMediaData> richMediaDataList3 = guildFeedGalleryInitBean.getRichMediaDataList();
        if (richMediaDataList3 != null && !richMediaDataList3.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        GuildFeedLauncher.H(BaseApplication.getContext(), guildFeedGalleryInitBean, intent);
    }

    public final void c(@NotNull View v3, @Nullable Object rawFeed, @NotNull GProStVideo enterVideo, int businessType, @Nullable Integer immersiveSource, @Nullable GuildFeedPublishInfo feedPublishInfo, @Nullable Long topicId) {
        GProStFeed gProStFeed;
        boolean z16;
        String str;
        boolean z17;
        String str2;
        boolean z18;
        String str3;
        int coerceAtLeast;
        int i3;
        ImageView imageView;
        boolean z19;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(enterVideo, "enterVideo");
        Drawable drawable = null;
        if (rawFeed instanceof GProStFeed) {
            gProStFeed = (GProStFeed) rawFeed;
        } else {
            gProStFeed = null;
        }
        if (gProStFeed == null) {
            return;
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setFeed(gProStFeed);
        guildFeedGalleryInitBean.setFeedId(gProStFeed.idd);
        Long valueOf = Long.valueOf(gProStFeed.groupCode);
        long j3 = 0;
        boolean z26 = true;
        if (valueOf.longValue() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!Boolean.valueOf(z16).booleanValue()) {
            valueOf = null;
        }
        if (valueOf != null) {
            str = valueOf.toString();
        } else {
            str = null;
        }
        guildFeedGalleryInitBean.setTroopUin(str);
        Long valueOf2 = Long.valueOf(guildFeedGalleryInitBean.getFeed().channelInfo.sign.guildId);
        if (valueOf2.longValue() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!Boolean.valueOf(z17).booleanValue()) {
            valueOf2 = null;
        }
        if (valueOf2 != null) {
            str2 = valueOf2.toString();
        } else {
            str2 = null;
        }
        guildFeedGalleryInitBean.setGuildId(str2);
        Long valueOf3 = Long.valueOf(guildFeedGalleryInitBean.getFeed().channelInfo.sign.channelId);
        if (valueOf3.longValue() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!Boolean.valueOf(z18).booleanValue()) {
            valueOf3 = null;
        }
        if (valueOf3 != null) {
            str3 = valueOf3.toString();
        } else {
            str3 = null;
        }
        guildFeedGalleryInitBean.setChannelId(str3);
        guildFeedGalleryInitBean.setRichMediaDataList(am.d(com.tencent.mobileqq.guild.feed.adapter.n.m(gProStFeed), "pg_channel_forum_page"));
        List<GuildFeedRichMediaData> richMediaDataList = guildFeedGalleryInitBean.getRichMediaDataList();
        Intrinsics.checkNotNullExpressionValue(richMediaDataList, "richMediaDataList");
        Iterator<T> it = richMediaDataList.iterator();
        while (it.hasNext()) {
            ((GuildFeedRichMediaData) it.next()).setVideoScreenPlay(false);
        }
        List<GuildFeedRichMediaData> richMediaDataList2 = guildFeedGalleryInitBean.getRichMediaDataList();
        Intrinsics.checkNotNullExpressionValue(richMediaDataList2, "richMediaDataList");
        Iterator<GuildFeedRichMediaData> it5 = richMediaDataList2.iterator();
        int i16 = 0;
        while (true) {
            if (it5.hasNext()) {
                if (it5.next().getVideo().displayIndex == enterVideo.displayIndex) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i16 = -1;
                break;
            }
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i16, 0);
        guildFeedGalleryInitBean.setEnterPos(coerceAtLeast);
        TransitionBean transitionBean = new TransitionBean();
        GProStImage gProStImage = enterVideo.cover;
        Intrinsics.checkNotNullExpressionValue(gProStImage, "enterVideo.cover");
        String h16 = bm.h(gProStImage);
        GProStImage gProStImage2 = enterVideo.cover;
        transitionBean.setStImage(h16, gProStImage2.width, gProStImage2.height);
        transitionBean.setEnterViewRect(v3);
        transitionBean.setScaleType(ImageView.ScaleType.FIT_CENTER);
        guildFeedGalleryInitBean.setTransitionBean(transitionBean);
        guildFeedGalleryInitBean.setBusinessType(businessType);
        guildFeedGalleryInitBean.setFromPage(1);
        if (immersiveSource != null) {
            i3 = immersiveSource.intValue();
        } else {
            i3 = 6;
        }
        guildFeedGalleryInitBean.setImmersiveSource(i3);
        guildFeedGalleryInitBean.setGuildFeedPublishInfo(feedPublishInfo);
        if (topicId != null) {
            j3 = topicId.longValue();
        }
        guildFeedGalleryInitBean.setTopicId(j3);
        if (v3 instanceof ImageView) {
            imageView = (ImageView) v3;
        } else {
            imageView = null;
        }
        if (imageView != null) {
            drawable = imageView.getDrawable();
        }
        TransitionAnimUtil.saveCoverDrawable(drawable);
        List<GuildFeedRichMediaData> richMediaDataList3 = guildFeedGalleryInitBean.getRichMediaDataList();
        if (richMediaDataList3 != null && !richMediaDataList3.isEmpty()) {
            z26 = false;
        }
        if (z26) {
            return;
        }
        GuildFeedLauncher.z(v3.getContext(), guildFeedGalleryInitBean, v3);
    }
}
