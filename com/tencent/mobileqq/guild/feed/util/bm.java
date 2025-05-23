package com.tencent.mobileqq.guild.feed.util;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0006\u001a\n\u0010\n\u001a\u00020\u0003*\u00020\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u0003*\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u001a\u0016\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000f*\u00020\u0000\u001a&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000f*\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002\u001a\n\u0010\u0012\u001a\u00020\u0003*\u00020\u0000\u001a\u0012\u0010\u0014\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0003\u001a\u0010\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000b*\u00020\u0000\u001a\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b*\u00020\u0000\u001a\u0016\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000f*\u00020\u0000\u001a\n\u0010\u0019\u001a\u00020\u0003*\u00020\u0000\u001a\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a\u001a\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001b\u001a\u00020\u001dH\u0002\u001a\u000e\u0010 \u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001f\u001a\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150!2\u0006\u0010\u0013\u001a\u00020\u0003\u001a\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150!2\u0006\u0010$\u001a\u00020#\"\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010&\"\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010&\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "", "t", "", tl.h.F, "g", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "r", "Lcom/tencent/mobileqq/guild/feed/util/g;", "b", "i", "", "", "levelList", "o", "Landroid/util/Pair;", "j", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "thumbnailUrl", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImageUrl;", DomainData.DOMAIN_NAME, "a", "k", "c", "", "data", "d", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "e", "Lcom/tencent/mobileqq/guild/feed/adapter/n;", "f", "Ljava/util/ArrayList;", "p", "Ljn1/d;", "bean", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/List;", "NEW_GALLERY_LEVEL_LIST", "NEW_GALLERY_LEVEL_LIST_NOT_SHOW", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bm {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f223893a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<Integer> f223894b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((GProStImageUrl) t17).levelType), Integer.valueOf(((GProStImageUrl) t16).levelType));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((GProStImageUrl) t17).levelType), Integer.valueOf(((GProStImageUrl) t16).levelType));
            return compareValues;
        }
    }

    static {
        List<Integer> listOf;
        List<Integer> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{3, 2});
        f223893a = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 3});
        f223894b = listOf2;
    }

    @NotNull
    public static final List<String> a(@NotNull GProStImage gProStImage) {
        List<String> mutableListOf;
        List sortedWith;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        String str = gProStImage.picUrl;
        Intrinsics.checkNotNullExpressionValue(str, "this.picUrl");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str);
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new a());
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            String str2 = ((GProStImageUrl) it.next()).url;
            if (str2 != null) {
                mutableListOf.add(str2);
            }
        }
        return mutableListOf;
    }

    @NotNull
    public static final FeedCoverInfo b(@NotNull GProStFeed gProStFeed) {
        boolean z16;
        int i3;
        boolean z17;
        String str;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        GProStImage cover = gProStFeed.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        boolean z18 = false;
        if (h(cover).length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            GProStImage cover2 = gProStFeed.cover;
            Intrinsics.checkNotNullExpressionValue(cover2, "cover");
            str = h(cover2);
        } else {
            ArrayList<GProStImage> arrayList = gProStFeed.images;
            String str2 = "";
            if (arrayList != null && arrayList.size() > 0) {
                z17 = gProStFeed.images.get(0).isGif;
                if (gProStFeed.images.size() > 0) {
                    GProStImage gProStImage = gProStFeed.images.get(0);
                    Intrinsics.checkNotNullExpressionValue(gProStImage, "images[0]");
                    str2 = h(gProStImage);
                    i3 = gProStFeed.images.get(0).displayIndex;
                } else {
                    i3 = -1;
                }
            } else {
                i3 = -1;
                z17 = false;
            }
            ArrayList<GProStVideo> arrayList2 = gProStFeed.videos;
            if (arrayList2 != null && arrayList2.size() > 0 && (gProStFeed.videos.get(0).displayIndex < i3 || i3 == -1)) {
                GProStImage gProStImage2 = gProStFeed.videos.get(0).cover;
                Intrinsics.checkNotNullExpressionValue(gProStImage2, "video.cover");
                str = h(gProStImage2);
            } else {
                z18 = z17;
                str = str2;
            }
        }
        return new FeedCoverInfo(str, z18);
    }

    @NotNull
    public static final String c(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        String picUrl = gProStImage.picUrl;
        Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
        return picUrl;
    }

    @NotNull
    public static final String d(@NotNull Object data) {
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof GuildFeedRichMediaData)) {
            return "";
        }
        GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) data;
        if (guildFeedRichMediaData.getImage().isOrig && !guildFeedRichMediaData.getImage().isGif) {
            if (new File(e(guildFeedRichMediaData)).exists()) {
                GProStImage image = guildFeedRichMediaData.getImage();
                Intrinsics.checkNotNullExpressionValue(image, "data.image");
                return c(image);
            }
            boolean isLoadOriginal = guildFeedRichMediaData.isLoadOriginal();
            GProStImage image2 = guildFeedRichMediaData.getImage();
            Intrinsics.checkNotNullExpressionValue(image2, "data.image");
            if (isLoadOriginal) {
                return c(image2);
            }
            return g(image2);
        }
        GProStImage image3 = guildFeedRichMediaData.getImage();
        Intrinsics.checkNotNullExpressionValue(image3, "data.image");
        String c16 = c(image3);
        isBlank = StringsKt__StringsJVMKt.isBlank(c16);
        if (isBlank) {
            GProStImage image4 = guildFeedRichMediaData.getImage();
            Intrinsics.checkNotNullExpressionValue(image4, "data.image");
            c16 = g(image4);
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(c16);
        if (isBlank2) {
            GProStImage image5 = guildFeedRichMediaData.getImage();
            Intrinsics.checkNotNullExpressionValue(image5, "data.image");
            return h(image5);
        }
        return c16;
    }

    private static final String e(GuildFeedRichMediaData guildFeedRichMediaData) {
        Option option = new Option();
        GProStImage image = guildFeedRichMediaData.getImage();
        Intrinsics.checkNotNullExpressionValue(image, "data.image");
        option.setUrl(c(image));
        return com.tencent.mobileqq.guild.picload.e.a().c(option);
    }

    @NotNull
    public static final String f(@NotNull com.tencent.mobileqq.guild.feed.adapter.n data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.e() == 1) {
            GProStImage c16 = data.c();
            Intrinsics.checkNotNullExpressionValue(c16, "data.stImage");
            return h(c16);
        }
        String str = data.d().cover.picUrl;
        Intrinsics.checkNotNullExpressionValue(str, "{\n        data.stVideo.cover.picUrl\n    }");
        return str;
    }

    @NotNull
    public static final String g(@NotNull GProStImage gProStImage) {
        String str;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((GProStImageUrl) next).levelType != 3) {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(next);
            }
        }
        if (!arrayList2.isEmpty()) {
            str = ((GProStImageUrl) arrayList2.get(0)).url;
        } else {
            str = gProStImage.picUrl;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String h(@NotNull GProStImage gProStImage) {
        String str;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((GProStImageUrl) next).levelType != 2) {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(next);
            }
        }
        if (!arrayList2.isEmpty()) {
            GProStImageUrl gProStImageUrl = (GProStImageUrl) arrayList2.get(0);
            if (gProStImageUrl != null) {
                str = gProStImageUrl.url;
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = gProStImage.picUrl;
            }
        } else {
            str = gProStImage.picUrl;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String i(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        return o(gProStImage, f223893a);
    }

    @NotNull
    public static final Pair<Integer, Integer> j(@NotNull GProStImage gProStImage) {
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        return l(gProStImage, f223893a);
    }

    @NotNull
    public static final Pair<Integer, Integer> k(@NotNull GProStImage gProStImage) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((GProStImageUrl) obj).levelType == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GProStImageUrl gProStImageUrl = (GProStImageUrl) obj;
        if (gProStImageUrl != null) {
            return new Pair<>(Integer.valueOf(gProStImageUrl.width), Integer.valueOf(gProStImageUrl.height));
        }
        return new Pair<>(Integer.valueOf(gProStImage.width), Integer.valueOf(gProStImage.height));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Pair<Integer, Integer> l(GProStImage gProStImage, List<Integer> list) {
        boolean z16;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            ArrayList<GProStImageUrl> vecImageUrlList = gProStImage.vecImageUrlList;
            GProStImageUrl gProStImageUrl = null;
            if (vecImageUrlList != null) {
                Intrinsics.checkNotNullExpressionValue(vecImageUrlList, "vecImageUrlList");
                Iterator<T> it5 = vecImageUrlList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (((GProStImageUrl) next).levelType == intValue) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        gProStImageUrl = next;
                        break;
                    }
                }
                gProStImageUrl = gProStImageUrl;
            }
            if (gProStImageUrl != null) {
                return new Pair<>(Integer.valueOf(gProStImageUrl.width), Integer.valueOf(gProStImageUrl.height));
            }
        }
        return new Pair<>(Integer.valueOf(gProStImage.width), Integer.valueOf(gProStImage.height));
    }

    @NotNull
    public static final String m(@NotNull GProStImage gProStImage) {
        boolean z16;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = arrayList.iterator();
        while (true) {
            boolean z17 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((GProStImageUrl) next).levelType != 2) {
                z17 = false;
            }
            if (z17) {
                arrayList2.add(next);
            }
        }
        if (arrayList2.isEmpty()) {
            ArrayList<GProStImageUrl> arrayList3 = gProStImage.vecImageUrlList;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "this.vecImageUrlList");
            arrayList2 = new ArrayList();
            for (Object obj : arrayList3) {
                if (((GProStImageUrl) obj).levelType == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList2.add(obj);
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            String str = ((GProStImageUrl) arrayList2.get(0)).url;
            Intrinsics.checkNotNullExpressionValue(str, "{\n        list[0].url\n    }");
            return str;
        }
        return "";
    }

    @NotNull
    public static final List<GProStImageUrl> n(@NotNull GProStImage gProStImage) {
        List<GProStImageUrl> sortedWith;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
        return sortedWith;
    }

    @NotNull
    public static final String o(@NotNull GProStImage gProStImage, @NotNull List<Integer> levelList) {
        ArrayList arrayList;
        boolean z16;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        Intrinsics.checkNotNullParameter(levelList, "levelList");
        Iterator<T> it = levelList.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            ArrayList<GProStImageUrl> vecImageUrlList = gProStImage.vecImageUrlList;
            String str = null;
            boolean z17 = true;
            if (vecImageUrlList != null) {
                Intrinsics.checkNotNullExpressionValue(vecImageUrlList, "vecImageUrlList");
                arrayList = new ArrayList();
                for (Object obj : vecImageUrlList) {
                    if (((GProStImageUrl) obj).levelType == intValue) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            if (arrayList == null || !(!arrayList.isEmpty())) {
                z17 = false;
            }
            if (z17) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("StImageUtil", "[getThumbnailWithLevelList] level:" + intValue);
                }
                GProStImageUrl gProStImageUrl = (GProStImageUrl) arrayList.get(0);
                if (gProStImageUrl != null) {
                    str = gProStImageUrl.url;
                }
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "list[0]?.url ?: \"\"");
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("StImageUtil", "[getThumbnailWithLevelList] use source pic");
        }
        String picUrl = gProStImage.picUrl;
        Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
        return picUrl;
    }

    @NotNull
    public static final ArrayList<GProStImageUrl> p(@NotNull String thumbnailUrl) {
        ArrayList<GProStImageUrl> arrayListOf;
        Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
        GProStImageUrl gProStImageUrl = new GProStImageUrl();
        gProStImageUrl.levelType = 3;
        gProStImageUrl.url = thumbnailUrl;
        Unit unit = Unit.INSTANCE;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(gProStImageUrl);
        return arrayListOf;
    }

    @NotNull
    public static final ArrayList<GProStImageUrl> q(@NotNull jn1.d bean) {
        ArrayList<GProStImageUrl> arrayListOf;
        Intrinsics.checkNotNullParameter(bean, "bean");
        GProStImageUrl[] gProStImageUrlArr = new GProStImageUrl[1];
        GProStImageUrl gProStImageUrl = new GProStImageUrl();
        gProStImageUrl.levelType = 3;
        String str = bean.thumbnailUrl;
        if (str == null) {
            str = "";
        }
        gProStImageUrl.url = str;
        gProStImageUrl.width = bean.width;
        gProStImageUrl.height = bean.height;
        Unit unit = Unit.INSTANCE;
        gProStImageUrlArr[0] = gProStImageUrl;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(gProStImageUrlArr);
        if (bean.listThumbnailUrl != null) {
            GProStImageUrl gProStImageUrl2 = new GProStImageUrl();
            gProStImageUrl2.levelType = 2;
            gProStImageUrl2.url = bean.listThumbnailUrl;
            gProStImageUrl2.width = bean.showWidth;
            gProStImageUrl2.height = bean.showHeight;
            arrayListOf.add(gProStImageUrl2);
        }
        return arrayListOf;
    }

    public static final boolean r(@NotNull GProStFeed gProStFeed) {
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        Iterator<GProStVideo> it = gProStFeed.videos.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "this.videos.iterator()");
        while (it.hasNext()) {
            if (it.next().displayIndex == 0) {
                return true;
            }
        }
        return false;
    }

    public static final boolean s(@NotNull GProStImage gProStImage, @NotNull String thumbnailUrl) {
        boolean isBlank;
        boolean z16;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
        isBlank = StringsKt__StringsJVMKt.isBlank(thumbnailUrl);
        if (!isBlank) {
            ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((GProStImageUrl) it.next()).url, thumbnailUrl)) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean t(@NotNull GProStImage gProStImage) {
        String str;
        Object obj;
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(gProStImage, "<this>");
        ArrayList<GProStImageUrl> arrayList = gProStImage.vecImageUrlList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "this.vecImageUrlList");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((GProStImageUrl) obj).levelType == 3) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GProStImageUrl gProStImageUrl = (GProStImageUrl) obj;
        if (gProStImageUrl != null) {
            str = gProStImageUrl.url;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        String picUrl = gProStImage.picUrl;
        Intrinsics.checkNotNullExpressionValue(picUrl, "picUrl");
        if (picUrl.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }
}
