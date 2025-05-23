package com.tencent.mobileqq.guild.feed.util;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImageUrl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0005\u001a\u00020\u0000*\u0004\u0018\u00010\u0004\u001a\f\u0010\u0006\u001a\u00020\u0004*\u0004\u0018\u00010\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lcom/tencent/mobileqq/guild/feed/util/n;", "b", "c", "", "a", "d", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m {
    @NotNull
    public static final GProStFeed a(@Nullable byte[] bArr) {
        try {
            com.tencent.qqnt.kernel.api.o c16 = l.c();
            if (c16 != null) {
                if (bArr == null) {
                    bArr = new byte[0];
                }
                GProStFeed decodeStFeed = c16.decodeStFeed(bArr);
                if (decodeStFeed != null) {
                    return decodeStFeed;
                }
            }
            return new GProStFeed();
        } catch (Exception unused) {
            return new GProStFeed();
        }
    }

    @NotNull
    public static final n b(@NotNull GProStFeed gProStFeed) {
        boolean z16;
        String str;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        GProStImage cover = gProStFeed.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        String str2 = pl1.a.h(cover).url;
        Intrinsics.checkNotNullExpressionValue(str2, "cover.getLevelTwoDisplayPicInfo().url");
        int i27 = 0;
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            GProStImage cover2 = gProStFeed.cover;
            Intrinsics.checkNotNullExpressionValue(cover2, "cover");
            GProStImageUrl h16 = pl1.a.h(cover2);
            str = h16.url;
            Intrinsics.checkNotNullExpressionValue(str, "info.url");
            i26 = h16.width;
            i19 = h16.height;
        } else {
            if (gProStFeed.images.size() > 0) {
                boolean z17 = gProStFeed.images.get(0).isGif;
                GProStImage gProStImage = gProStFeed.images.get(0);
                Intrinsics.checkNotNullExpressionValue(gProStImage, "images[0]");
                GProStImageUrl h17 = pl1.a.h(gProStImage);
                String str3 = h17.url;
                Intrinsics.checkNotNullExpressionValue(str3, "info.url");
                i18 = h17.width;
                i16 = h17.height;
                i3 = gProStFeed.images.get(0).displayIndex;
                i17 = z17 ? 1 : 0;
                str = str3;
            } else {
                str = "";
                i3 = -1;
                i16 = 0;
                i17 = 0;
                i18 = 0;
            }
            if (gProStFeed.videos.size() > 0 && (gProStFeed.videos.get(0).displayIndex < i3 || i3 == -1)) {
                GProStImage gProStImage2 = gProStFeed.videos.get(0).cover;
                Intrinsics.checkNotNullExpressionValue(gProStImage2, "videos[0].cover");
                GProStImageUrl h18 = pl1.a.h(gProStImage2);
                str = h18.url;
                Intrinsics.checkNotNullExpressionValue(str, "info.url");
                i26 = h18.width;
                i19 = h18.height;
                i27 = 2;
            } else {
                i19 = i16;
                i27 = i17;
                i26 = i18;
            }
        }
        return new n(str, i27, i26, i19);
    }

    @NotNull
    public static final n c(@NotNull GProStFeed gProStFeed) {
        boolean z16;
        String str;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        Intrinsics.checkNotNullParameter(gProStFeed, "<this>");
        GProStImage cover = gProStFeed.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        String str2 = pl1.a.e(cover).url;
        Intrinsics.checkNotNullExpressionValue(str2, "cover.getLevelThreeDisplayPicInfo().url");
        int i27 = 0;
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            GProStImage cover2 = gProStFeed.cover;
            Intrinsics.checkNotNullExpressionValue(cover2, "cover");
            GProStImageUrl e16 = pl1.a.e(cover2);
            str = e16.url;
            Intrinsics.checkNotNullExpressionValue(str, "info.url");
            i26 = e16.width;
            i19 = e16.height;
        } else {
            if (gProStFeed.images.size() > 0) {
                boolean z17 = gProStFeed.images.get(0).isGif;
                GProStImage gProStImage = gProStFeed.images.get(0);
                Intrinsics.checkNotNullExpressionValue(gProStImage, "images[0]");
                GProStImageUrl e17 = pl1.a.e(gProStImage);
                String str3 = e17.url;
                Intrinsics.checkNotNullExpressionValue(str3, "info.url");
                i18 = e17.width;
                i16 = e17.height;
                i3 = gProStFeed.images.get(0).displayIndex;
                i17 = z17 ? 1 : 0;
                str = str3;
            } else {
                str = "";
                i3 = -1;
                i16 = 0;
                i17 = 0;
                i18 = 0;
            }
            if (gProStFeed.videos.size() > 0 && (gProStFeed.videos.get(0).displayIndex < i3 || i3 == -1)) {
                GProStImage gProStImage2 = gProStFeed.videos.get(0).cover;
                Intrinsics.checkNotNullExpressionValue(gProStImage2, "videos[0].cover");
                GProStImageUrl e18 = pl1.a.e(gProStImage2);
                str = e18.url;
                Intrinsics.checkNotNullExpressionValue(str, "info.url");
                i26 = e18.width;
                i19 = e18.height;
                i27 = 2;
            } else {
                i19 = i16;
                i27 = i17;
                i26 = i18;
            }
        }
        return new n(str, i27, i26, i19);
    }

    @NotNull
    public static final byte[] d(@Nullable GProStFeed gProStFeed) {
        try {
            com.tencent.qqnt.kernel.api.o c16 = l.c();
            if (c16 != null) {
                if (gProStFeed == null) {
                    gProStFeed = new GProStFeed();
                }
                byte[] encodeStFeed = c16.encodeStFeed(gProStFeed);
                if (encodeStFeed != null) {
                    return encodeStFeed;
                }
            }
            return new byte[0];
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
