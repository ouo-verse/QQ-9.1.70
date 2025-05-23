package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0084\u0001\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\f\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a>\u0010\u0017\u001a\u00020\u0013*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a\"\u0010\u001c\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004\u001a\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u000b*\u00020\u001dH\u0002\"\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006$"}, d2 = {"Landroid/widget/ImageView;", "", "picUrl", "Lkotlin/Pair;", "", "targetSize", "imageGroupKey", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "Ljava/lang/Class;", "Lr01/a;", "Landroid/graphics/Bitmap;", "preferDecoder", "", "ignoreTag", "enableRegionDecode", "needSetColorFilter", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "picLoadListener", "", "f", "c", "Landroid/util/Pair;", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "video", "coverWidth", "coverHeight", tl.h.F, "Lcom/tencent/libra/request/Option;", "d", "a", "I", "URL_TAG", "b", "THUMBNAIL_TAG", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedListImageExKt {

    /* renamed from: a */
    private static final int f219282a = 1149783787;

    /* renamed from: b */
    private static final int f219283b = 1825630663;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedListImageExKt$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e */
        final /* synthetic */ IPicLoadStateListener f219284e;

        /* renamed from: f */
        final /* synthetic */ ImageView f219285f;

        /* renamed from: h */
        final /* synthetic */ boolean f219286h;

        /* renamed from: i */
        final /* synthetic */ String f219287i;

        /* renamed from: m */
        final /* synthetic */ String f219288m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(IPicLoadStateListener iPicLoadStateListener, ImageView imageView, boolean z16, String str, String str2) {
            super(false);
            this.f219284e = iPicLoadStateListener;
            this.f219285f = imageView;
            this.f219286h = z16;
            this.f219287i = str;
            this.f219288m = str2;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@Nullable LoadState state, @Nullable Option option) {
            Bitmap d16;
            IPicLoadStateListener iPicLoadStateListener = this.f219284e;
            if (iPicLoadStateListener != null) {
                iPicLoadStateListener.onStateChange(state, option);
            }
            if (state == LoadState.STATE_SUCCESS) {
                ImageView imageView = this.f219285f;
                if (this.f219286h) {
                    ImageViewPorterDuffUtils.f235385a.c(imageView);
                }
                if (this.f219287i != null && option != null && (d16 = GuildFeedListImageExKt.d(option)) != null) {
                    Logger logger = Logger.f235387a;
                    String str = this.f219287i;
                    String str2 = this.f219288m;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildFeedListImageEx", 1, "loadFeedListImage: load success, save to cache with key = " + str + ", url: " + str2);
                    }
                    ImageCacheHelper.f98636a.j(this.f219287i, d16, Business.Guild, null, imageView);
                }
            }
        }
    }

    @Nullable
    public static final Drawable c(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (imageView.getContext() == null) {
            return null;
        }
        return new ColorDrawable(imageView.getContext().getColor(R.color.qui_common_fill_standard_primary));
    }

    public static final Bitmap d(Option option) {
        if (option.getResultBitMap() != null) {
            return option.getResultBitMap();
        }
        if (option.getAnimatable() == null || !(option.getAnimatable() instanceof GifDrawable)) {
            return null;
        }
        Animatable animatable = option.getAnimatable();
        Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type com.tencent.libra.extension.gif.GifDrawable");
        return ((GifDrawable) animatable).b();
    }

    public static final void e(@NotNull ImageView imageView, @Nullable String str, @NotNull Pair<Integer, Integer> targetSize, @Nullable String str2, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        g(imageView, str, r.a(targetSize), str2, drawable, null, false, false, false, null, w.CTRL_INDEX, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void f(@NotNull ImageView imageView, @Nullable String str, @NotNull kotlin.Pair<Integer, Integer> targetSize, @Nullable String str2, @Nullable Drawable drawable, @Nullable Class<? extends r01.a<Bitmap>> cls, boolean z16, boolean z17, boolean z18, @Nullable IPicLoadStateListener iPicLoadStateListener) {
        boolean z19;
        String str3;
        boolean z26;
        boolean isBlank;
        boolean isBlank2;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(targetSize, "targetSize");
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z19 = false;
                if (!z19) {
                    return;
                }
                int i3 = f219282a;
                Object tag = imageView.getTag(i3);
                Bitmap bitmap = null;
                if (tag instanceof String) {
                    str3 = (String) tag;
                } else {
                    str3 = null;
                }
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildFeedListImageEx", 1, "actual loadFeedListImage: sameFeedIdentify: " + str2 + ", url: hash: " + str.hashCode() + " -> " + str + ", urlInTag: " + str3);
                }
                if (!z16) {
                    if (str3 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                        if (!isBlank) {
                            z26 = false;
                            if (!z26) {
                                GuildFeedListImageEx guildFeedListImageEx = GuildFeedListImageEx.f219278d;
                                if (guildFeedListImageEx.g(str3, str)) {
                                    if (QLog.isColorLevel()) {
                                        logger.d().d("GuildFeedListImageEx", 1, "loadFeedListImage: same pic url, skip load, key: " + ((Object) guildFeedListImageEx.e().invoke(str)) + ", url: " + str);
                                        return;
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    z26 = true;
                    if (!z26) {
                    }
                }
                com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
                Option obtain = Option.obtain();
                obtain.setRequestWidth(targetSize.getFirst().intValue());
                obtain.setRequestHeight(targetSize.getSecond().intValue());
                obtain.setUrl(str);
                obtain.setTargetView(imageView);
                if (z18) {
                    obtain.getTargetView().setColorFilter((ColorFilter) null);
                }
                if (str2 != null) {
                    bitmap = ImageCacheHelper.f98636a.f(str2);
                }
                if (bitmap != null) {
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildFeedListImageEx", 1, "loadFeedListImage: loading drawable from cache, key: " + str2 + ", url: " + str);
                    }
                    Resources resources = imageView.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "resources");
                    obtain.setLoadingDrawable(new BitmapDrawable(resources, bitmap));
                } else {
                    if (QLog.isColorLevel()) {
                        logger.d().d("GuildFeedListImageEx", 1, "loadFeedListImage: set loading drawable, key: " + str2 + ", drawable: " + drawable);
                    }
                    if (drawable == null) {
                        obtain.setNeedShowLoadingDrawable(false);
                    } else {
                        obtain.setLoadingDrawable(drawable);
                    }
                }
                if (z17 && targetSize.getFirst().intValue() > 0 && targetSize.getSecond().intValue() > 0) {
                    obtain.setDecodeMode(1);
                    obtain.setRegionScaleType(ImageView.ScaleType.CENTER_CROP);
                }
                obtain.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
                if (cls != null) {
                    obtain.setPreferDecoder(cls);
                }
                a16.f(obtain, new a(iPicLoadStateListener, imageView, z18, str2, str));
                imageView.setTag(i3, str);
                return;
            }
        }
        z19 = true;
        if (!z19) {
        }
    }

    public static /* synthetic */ void g(ImageView imageView, String str, kotlin.Pair pair, String str2, Drawable drawable, Class cls, boolean z16, boolean z17, boolean z18, IPicLoadStateListener iPicLoadStateListener, int i3, Object obj) {
        String str3;
        Drawable drawable2;
        Class cls2;
        boolean z19;
        boolean z26;
        boolean z27;
        IPicLoadStateListener iPicLoadStateListener2;
        if ((i3 & 4) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i3 & 8) != 0) {
            drawable2 = null;
        } else {
            drawable2 = drawable;
        }
        if ((i3 & 16) != 0) {
            cls2 = null;
        } else {
            cls2 = cls;
        }
        if ((i3 & 32) != 0) {
            z19 = false;
        } else {
            z19 = z16;
        }
        if ((i3 & 64) != 0) {
            z26 = true;
        } else {
            z26 = z17;
        }
        if ((i3 & 128) != 0) {
            z27 = false;
        } else {
            z27 = z18;
        }
        if ((i3 & 256) != 0) {
            iPicLoadStateListener2 = null;
        } else {
            iPicLoadStateListener2 = iPicLoadStateListener;
        }
        f(imageView, str, pair, str3, drawable2, cls2, z19, z26, z27, iPicLoadStateListener2);
    }

    public static final void h(@NotNull ImageView imageView, @NotNull GProStVideo video, int i3, int i16) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(video, "video");
        if (Intrinsics.areEqual(imageView.getTag(f219283b), video.playUrl)) {
            return;
        }
        if (!RFWFileUtils.isLocalPath(video.playUrl)) {
            Logger.f235387a.d().w("GuildFeedListImageEx", 1, "loadLocalThumbnail: not local path, url: " + video.playUrl);
            return;
        }
        if (RFWFileUtils.fileExists(video.playUrl)) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ae.a().a()), null, null, new GuildFeedListImageExKt$loadLocalThumbnail$1$3(video, i3, i16, imageView, null), 3, null);
            return;
        }
        Logger.f235387a.d().w("GuildFeedListImageEx", 1, "loadLocalThumbnail: file not exists, url: " + video.playUrl);
    }
}
