package com.tencent.mobileqq.guild.feed.gallery;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004\u001a;\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00020\n\u001a\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010\u001a(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u001a4\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0002\u001a4\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0002\u001a\f\u0010\u001d\u001a\u00020\u0004*\u0004\u0018\u00010\u001c\u001a\u001c\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` *\u0004\u0018\u00010\u001c\u001a\f\u0010\"\u001a\u00020\u0004*\u0004\u0018\u00010\u0015\u001a\f\u0010#\u001a\u00020\u0004*\u0004\u0018\u00010\u0015\" \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006("}, d2 = {"", "url", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "i", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "info", "hasLoadOrigin", "f", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "hasCache", "function", "g", "", "w", h.F, "k", "showSource", "Lcom/tencent/libra/request/Option;", "b", "option", "showWidth", "showHeight", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "l", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "Lkotlin/collections/ArrayList;", "d", "j", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "HAS_LOADED_SOURCE_URL_HASHCODE_MAP", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<Integer, Integer> f219565a = new ConcurrentHashMap<>(64);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int i3;
            int i16;
            int compareValues;
            GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) t16;
            if (guildFeedRichMediaData.getType() == 0) {
                i3 = guildFeedRichMediaData.getImage().displayIndex;
            } else {
                i3 = guildFeedRichMediaData.getVideo().displayIndex;
            }
            Integer valueOf = Integer.valueOf(i3);
            GuildFeedRichMediaData guildFeedRichMediaData2 = (GuildFeedRichMediaData) t17;
            if (guildFeedRichMediaData2.getType() == 0) {
                i16 = guildFeedRichMediaData2.getImage().displayIndex;
            } else {
                i16 = guildFeedRichMediaData2.getVideo().displayIndex;
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(i16));
            return compareValues;
        }
    }

    @NotNull
    public static final Option b(@NotNull String url, int i3, int i16, boolean z16) {
        Intrinsics.checkNotNullParameter(url, "url");
        Option option = Option.obtain().setUrl(url).setLoadingDrawableId(R.drawable.f162601b70).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565).setFailDrawable(d30.a.b(R.drawable.naw));
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(option, "option");
            o(option, i3, i16, 0, 0, 24, null);
        } else {
            Intrinsics.checkNotNullExpressionValue(option, "option");
            q(option, i3, i16, 0, 0, 24, null);
        }
        option.setLocalPath(e.a().c(option));
        return option;
    }

    public static /* synthetic */ Option c(String str, int i3, int i16, boolean z16, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            z16 = false;
        }
        return b(str, i3, i16, z16);
    }

    @NotNull
    public static final ArrayList<GuildFeedRichMediaData> d(@Nullable GProStFeed gProStFeed) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        if (gProStFeed == null) {
            return new ArrayList<>();
        }
        ArrayList<GuildFeedRichMediaData> arrayList = new ArrayList<>();
        ArrayList<GProStImage> images = gProStFeed.images;
        Intrinsics.checkNotNullExpressionValue(images, "images");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(images, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (GProStImage gProStImage : images) {
            GuildFeedRichMediaData guildFeedRichMediaData = new GuildFeedRichMediaData();
            guildFeedRichMediaData.setImage(gProStImage);
            guildFeedRichMediaData.setType(0);
            arrayList2.add(guildFeedRichMediaData);
        }
        arrayList.addAll(arrayList2);
        ArrayList<GProStVideo> videos = gProStFeed.videos;
        Intrinsics.checkNotNullExpressionValue(videos, "videos");
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(videos, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        for (GProStVideo gProStVideo : videos) {
            GuildFeedRichMediaData guildFeedRichMediaData2 = new GuildFeedRichMediaData();
            guildFeedRichMediaData2.setVideo(gProStVideo);
            guildFeedRichMediaData2.setType(1);
            arrayList3.add(guildFeedRichMediaData2);
        }
        arrayList.addAll(arrayList3);
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new a());
        }
        return arrayList;
    }

    public static final boolean e(@Nullable Option option) {
        Animatable animatable;
        if (option != null) {
            animatable = option.getAnimatable();
        } else {
            animatable = null;
        }
        if (animatable != null && (option.getAnimatable() instanceof Drawable)) {
            return true;
        }
        return false;
    }

    public static final boolean f(@NotNull GProStImage info, boolean z16) {
        Intrinsics.checkNotNullParameter(info, "info");
        Option obtain = Option.obtain();
        String str = info.picUrl;
        obtain.setUrl(str);
        if (info.isOrig) {
            if (i(str)) {
                z16 = true;
            }
        } else {
            z16 = false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildFeedGalleryExt", "[hasFeedImageCache] [hasCache] res:" + z16 + ", url:" + str.hashCode());
        }
        return z16;
    }

    public static final void g(@NotNull final GProStImage info, final boolean z16, @NotNull final Function1<? super Boolean, Unit> function) {
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(function, "function");
        if (!info.isOrig) {
            function.invoke(Boolean.FALSE);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.h(GProStImage.this, z16, function);
                }
            }, 64, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GProStImage info, boolean z16, Function1 function) {
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(function, "$function");
        if (info.isOrig) {
            Option obtain = Option.obtain();
            String str = info.picUrl;
            obtain.setUrl(str);
            if (new File(e.a().c(obtain)).exists()) {
                m(str);
                z16 = true;
            }
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildFeedGalleryExt", "[hasFeedImageCacheAsync] [hasCache] res:" + z16 + ", url:" + str.hashCode());
            }
            function.invoke(Boolean.valueOf(z16));
        }
    }

    public static final boolean i(@Nullable String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        return f219565a.containsKey(Integer.valueOf(str.hashCode()));
    }

    public static final boolean j(@Nullable Option option) {
        Bitmap bitmap;
        if (option != null) {
            bitmap = option.getResultBitMap();
        } else {
            bitmap = null;
        }
        if (bitmap != null && !option.getResultBitMap().isRecycled()) {
            return true;
        }
        return false;
    }

    public static final boolean k(int i3, int i16) {
        if (i3 / i16 < 0.33333334f) {
            return true;
        }
        return false;
    }

    public static final boolean l(@Nullable GProStFeed gProStFeed) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (gProStFeed == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[isValidStFeed] stFeed is Null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedGalleryExt", 1, (String) it.next(), null);
            }
            return false;
        }
        ArrayList<GProStImage> stImages = gProStFeed.images;
        if (stImages != null && stImages.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ArrayList<GProStVideo> arrayList = gProStFeed.videos;
            if (arrayList != null && arrayList.isEmpty()) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                Logger logger2 = Logger.f235387a;
                Logger.b bVar2 = new Logger.b();
                bVar2.a().add("[isValidStFeed] no any image or video!");
                Iterator<T> it5 = bVar2.a().iterator();
                while (it5.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedGalleryExt", 1, (String) it5.next(), null);
                }
                return false;
            }
        }
        if (stImages != null && (!stImages.isEmpty())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            Intrinsics.checkNotNullExpressionValue(stImages, "stImages");
            if (!(stImages instanceof Collection) || !stImages.isEmpty()) {
                for (GProStImage it6 : stImages) {
                    Intrinsics.checkNotNullExpressionValue(it6, "it");
                    if (bm.t(it6)) {
                        z18 = true;
                        break;
                    }
                }
            }
            z18 = false;
            if (z18) {
                Logger logger3 = Logger.f235387a;
                Logger.b bVar3 = new Logger.b();
                bVar3.a().add("[isValidStFeed] no gallery url & pic url!");
                Iterator<T> it7 = bVar3.a().iterator();
                while (it7.hasNext()) {
                    Logger.f235387a.d().e("GuildFeedGalleryExt", 1, (String) it7.next(), null);
                }
                return false;
            }
        }
        return true;
    }

    public static final void m(@Nullable String str) {
        if (str != null) {
            f219565a.put(Integer.valueOf(str.hashCode()), 0);
        }
    }

    private static final void n(Option option, int i3, int i16, int i17, int i18) {
        int coerceAtMost;
        int coerceAtMost2;
        option.setDecodeMode(0);
        if (i3 > 0 && i16 > 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, i17 * 3);
            Option requestWidth = option.setRequestWidth(coerceAtMost);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(i16, i18 * 3);
            requestWidth.setRequestHeight(coerceAtMost2);
            return;
        }
        option.setRequestWidth(i17).setRequestHeight(i18);
    }

    static /* synthetic */ void o(Option option, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 8) != 0) {
            i17 = ViewUtils.getScreenWidth();
        }
        if ((i19 & 16) != 0) {
            i18 = ViewUtils.getScreenHeight();
        }
        n(option, i3, i16, i17, i18);
    }

    private static final void p(Option option, int i3, int i16, int i17, int i18) {
        if (i3 > 0 && i16 > 0) {
            if (i3 <= i17 && i16 <= i18) {
                option.setRequestWidth(i3).setRequestHeight(i16);
            } else if (i3 > i16) {
                option.setRequestWidth(i17).setRequestHeight((int) (i16 * (i17 / i3)));
            } else {
                option.setRequestHeight(i18).setRequestWidth((int) (i3 * (i18 / i16)));
            }
        } else {
            option.setRequestWidth(i17).setRequestHeight(i18);
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildFeedGalleryExt", "[buildFeedImageCommonOption] w:" + i3 + ", h:" + i16 + ", showWidth:" + i17 + " ,showHeight:" + i18 + ", requestWidth:" + option.getRequestWidth() + ", requestHeight:" + option.getRequestHeight());
        }
    }

    static /* synthetic */ void q(Option option, int i3, int i16, int i17, int i18, int i19, Object obj) {
        if ((i19 & 8) != 0) {
            i17 = ViewUtils.getScreenWidth();
        }
        if ((i19 & 16) != 0) {
            i18 = ViewUtils.getScreenHeight();
        }
        p(option, i3, i16, i17, i18);
    }
}
