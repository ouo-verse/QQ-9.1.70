package com.tencent.mobileqq.guild.feed.util;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class am {
    public static GuildFeedRichMediaData a(com.tencent.mobileqq.guild.feed.adapter.n nVar, String str) {
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        guildFeedRichMediaData.setImage(nVar.c());
        guildFeedRichMediaData.setPageId(str);
        guildFeedRichMediaData.setType(0);
        return guildFeedRichMediaData;
    }

    public static GuildFeedRichMediaData b(com.tencent.mobileqq.guild.feed.adapter.n nVar, String str) {
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        guildFeedRichMediaData.setVideo(nVar.d());
        guildFeedRichMediaData.setPageId(str);
        guildFeedRichMediaData.setType(1);
        return guildFeedRichMediaData;
    }

    public static List<GuildFeedRichMediaData> c(List<jn1.d> list) {
        int i3;
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        for (jn1.d dVar : list) {
            if (dVar != null) {
                GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
                int i17 = dVar.type;
                if (i17 == 0) {
                    guildFeedRichMediaData.setType(0);
                    GProStImage gProStImage = new GProStImage();
                    gProStImage.picId = dVar.fileId;
                    gProStImage.picUrl = dVar.imageUrl;
                    gProStImage.width = dVar.width;
                    gProStImage.height = dVar.height;
                    gProStImage.isOrig = dVar.isOriginal;
                    gProStImage.isGif = dVar.isGif;
                    gProStImage.origSize = dVar.originalSize;
                    gProStImage.vecImageUrlList = bm.q(dVar);
                    i3 = i16 + 1;
                    gProStImage.displayIndex = i16;
                    guildFeedRichMediaData.setImage(gProStImage);
                } else {
                    if (i17 == 1) {
                        guildFeedRichMediaData.setType(1);
                        GProStVideo gProStVideo = new GProStVideo();
                        String str = dVar.videoUrl;
                        String str2 = "";
                        if (!str.startsWith("http")) {
                            str = Uri.fromFile(new File(str)).toString();
                            gProStVideo.fileId = str.hashCode() + "";
                        } else {
                            gProStVideo.fileId = dVar.fileId;
                            GProStImage gProStImage2 = new GProStImage();
                            String str3 = dVar.coverUrl;
                            if (str3 != null) {
                                str2 = str3;
                            }
                            gProStImage2.picUrl = str2;
                            gProStImage2.width = dVar.width;
                            gProStImage2.height = dVar.height;
                            gProStVideo.cover = gProStImage2;
                        }
                        gProStVideo.playUrl = str;
                        gProStVideo.duration = dVar.duration;
                        gProStVideo.width = dVar.width;
                        gProStVideo.height = dVar.height;
                        i3 = i16 + 1;
                        gProStVideo.displayIndex = i16;
                        guildFeedRichMediaData.setVideo(gProStVideo);
                    }
                    arrayList.add(guildFeedRichMediaData);
                }
                i16 = i3;
                arrayList.add(guildFeedRichMediaData);
            }
        }
        return arrayList;
    }

    public static List<GuildFeedRichMediaData> d(List<com.tencent.mobileqq.guild.feed.adapter.n> list, String str) {
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.guild.feed.adapter.n nVar : list) {
            if (nVar.e() == 1) {
                arrayList.add(a(nVar, str));
            } else if (nVar.e() == 2) {
                arrayList.add(b(nVar, str));
            }
        }
        return arrayList;
    }

    public static GuildFeedRichMediaData e(GProStFeed gProStFeed, String str) {
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        guildFeedRichMediaData.setImage(gProStFeed.images.get(0));
        guildFeedRichMediaData.setPageId(str);
        guildFeedRichMediaData.setType(0);
        return guildFeedRichMediaData;
    }

    public static List<GuildFeedRichMediaData> f(GProStFeed gProStFeed, String str) {
        ArrayList arrayList = new ArrayList();
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        if (!gProStFeed.videos.isEmpty()) {
            guildFeedRichMediaData.setVideo(gProStFeed.videos.get(0));
        }
        guildFeedRichMediaData.setPageId(str);
        guildFeedRichMediaData.setType(1);
        arrayList.add(guildFeedRichMediaData);
        return arrayList;
    }

    public static GuildFeedGalleryInitBean g(GuildFeedGalleryInitBean guildFeedGalleryInitBean, LocalMediaInfo localMediaInfo, View view) {
        GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
        GProStImage gProStImage = new GProStImage();
        gProStImage.width = localMediaInfo.mediaWidth;
        gProStImage.height = localMediaInfo.mediaHeight;
        gProStImage.picUrl = localMediaInfo.path;
        guildFeedRichMediaData.setImage(gProStImage);
        guildFeedRichMediaData.setType(0);
        guildFeedGalleryInitBean.setRichMediaDataList(new ArrayList(Collections.singleton(guildFeedRichMediaData)));
        TransitionBean transitionBean = new TransitionBean();
        transitionBean.setEnterViewRect(view);
        transitionBean.setStImage(gProStImage.picUrl, gProStImage.width, gProStImage.height);
        if (view instanceof ImageView) {
            transitionBean.setScaleType(((ImageView) view).getScaleType());
        } else {
            transitionBean.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        guildFeedGalleryInitBean.setTransitionBean(transitionBean);
        guildFeedGalleryInitBean.setShowMoreIcon(false);
        return guildFeedGalleryInitBean;
    }
}
