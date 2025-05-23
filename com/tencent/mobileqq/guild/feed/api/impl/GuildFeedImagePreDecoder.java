package com.tencent.mobileqq.guild.feed.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.cache.api.util.Priority;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.libra.LoadState;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.ComputedKt;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J(\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010\u0012\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016R\u0014\u0010\u0015\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\r\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR \u0010 \u001a\n \u0018*\u0004\u0018\u00010\u00030\u0003*\u00020\u00038BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/api/impl/GuildFeedImagePreDecoder;", "Lcom/tencent/mobileqq/guild/feed/api/IGuildFeedImagePreDecoder;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "key", "Landroid/graphics/Bitmap;", "innerGet", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "innerPut", "", CoverDBCacheData.URLS, "decode", "account", "onAccountChanged", "allUrlList", "Landroid/graphics/drawable/Drawable;", "drawable", "putIfAbsent", "Landroid/graphics/drawable/BitmapDrawable;", "get", "TAG", "Ljava/lang/String;", "", "kotlin.jvm.PlatformType", "IGNORE_PIC_LEVEL$delegate", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/a;", "getIGNORE_PIC_LEVEL", "()Ljava/lang/Boolean;", "IGNORE_PIC_LEVEL", "getFilterKey", "(Ljava/lang/String;)Ljava/lang/String;", "filterKey", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedImagePreDecoder implements IGuildFeedImagePreDecoder, com.tencent.mobileqq.guild.base.repository.a {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(GuildFeedImagePreDecoder.class, "IGNORE_PIC_LEVEL", "getIGNORE_PIC_LEVEL()Ljava/lang/Boolean;", 0))};

    /* renamed from: IGNORE_PIC_LEVEL$delegate, reason: from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.feed.feedsquare.utils.a IGNORE_PIC_LEVEL;

    @NotNull
    public static final GuildFeedImagePreDecoder INSTANCE;

    @NotNull
    private static final String TAG = "GuildFeedImagePreDecoder";

    @NotNull
    private static String account;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/api/impl/GuildFeedImagePreDecoder$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f218006e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f218007f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.BooleanRef booleanRef, String str) {
            super(false);
            this.f218006e = booleanRef;
            this.f218007f = str;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            Bitmap resultBitMap = option.getResultBitMap();
            if (resultBitMap != null && !resultBitMap.isRecycled() && !this.f218006e.element) {
                GuildFeedImagePreDecoder.INSTANCE.innerPut(this.f218007f, resultBitMap);
                QLog.i(GuildFeedImagePreDecoder.TAG, 1, "putCache from libra " + this.f218007f + " " + resultBitMap);
                this.f218006e.element = true;
            }
        }
    }

    static {
        final GuildFeedImagePreDecoder guildFeedImagePreDecoder = new GuildFeedImagePreDecoder();
        INSTANCE = guildFeedImagePreDecoder;
        account = "";
        AccountChangedNotifier.f214789d.a(guildFeedImagePreDecoder);
        IGNORE_PIC_LEVEL = new com.tencent.mobileqq.guild.feed.feedsquare.utils.a(new MutablePropertyReference0Impl(guildFeedImagePreDecoder) { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder$IGNORE_PIC_LEVEL$2
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                String str;
                str = GuildFeedImagePreDecoder.account;
                return str;
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(@Nullable Object obj) {
                GuildFeedImagePreDecoder.account = (String) obj;
            }
        }, ComputedKt.a(), new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder$IGNORE_PIC_LEVEL$3
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(@NotNull String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Boolean isSwitchOn = ((IUnitedConfig) QRoute.api(IUnitedConfig.class)).isSwitchOn("ignore_pic_level", Boolean.TRUE);
                QLog.i("GuildFeedImagePreDecoder", 1, "obtain ignore_pic_level: " + isSwitchOn);
                return isSwitchOn;
            }
        });
    }

    GuildFeedImagePreDecoder() {
    }

    private final void decode(final String key, List<String> urls, Bitmap bitmap) {
        int collectionSizeOrDefault;
        if (bitmap != null) {
            QLog.i(TAG, 1, "putCache from bitmap " + key + " " + bitmap);
            innerPut(key, bitmap);
            return;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        List<String> list = urls;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList<Option> arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Option.obtain().setUrl((String) it.next()));
        }
        for (Option option : arrayList) {
            final String c16 = com.tencent.mobileqq.guild.picload.e.a().c(option);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedImagePreDecoder.decode$lambda$6$lambda$5(c16, key, booleanRef);
                }
            }, 64, null, false);
            com.tencent.mobileqq.guild.picload.e.a().f(option, new a(booleanRef, key));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void decode$lambda$6$lambda$5(String str, String key, Ref.BooleanRef alreadyPut) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(key, "$key");
        Intrinsics.checkNotNullParameter(alreadyPut, "$alreadyPut");
        GuildFeedImagePreDecoder guildFeedImagePreDecoder = INSTANCE;
        try {
            Result.Companion companion = Result.INSTANCE;
            Bitmap safeDecode = SafeBitmapFactory.safeDecode(str, new SafeBitmapFactory.SafeDecodeOption());
            if (safeDecode != null) {
                guildFeedImagePreDecoder.innerPut(key, safeDecode);
                QLog.i(TAG, 1, "putCache from file " + key + " " + safeDecode);
                alreadyPut.element = true;
            }
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e(TAG, 1, "decode error " + str, m479exceptionOrNullimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFilterKey(String str) {
        if (!RFWFileUtils.isLocalPath(str)) {
            Boolean IGNORE_PIC_LEVEL2 = getIGNORE_PIC_LEVEL();
            Intrinsics.checkNotNullExpressionValue(IGNORE_PIC_LEVEL2, "IGNORE_PIC_LEVEL");
            if (IGNORE_PIC_LEVEL2.booleanValue()) {
                str = StringsKt__StringsKt.substringBeforeLast$default(str, "/", (String) null, 2, (Object) null);
            }
            return com.tencent.mobileqq.guild.picload.e.d(str);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap innerGet(String key) {
        return ImageCacheHelper.f98636a.f(key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void innerPut(String key, Bitmap bitmap) {
        ImageCacheHelper.f98636a.k(key, bitmap, Business.Guild, Priority.High, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder
    public /* bridge */ /* synthetic */ Drawable get(List list) {
        return get((List<String>) list);
    }

    public final Boolean getIGNORE_PIC_LEVEL() {
        return (Boolean) IGNORE_PIC_LEVEL.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account2) {
        Intrinsics.checkNotNullParameter(account2, "account");
        account = account2;
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder
    public void putIfAbsent(@NotNull List<String> allUrlList, @Nullable Drawable drawable) {
        Bitmap bitmap;
        Sequence asSequence;
        Sequence map;
        Sequence distinct;
        Sequence<String> filter;
        Intrinsics.checkNotNullParameter(allUrlList, "allUrlList");
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof GifDrawable) {
            bitmap = ((GifDrawable) drawable).b();
        } else {
            bitmap = null;
        }
        asSequence = CollectionsKt___CollectionsKt.asSequence(allUrlList);
        map = SequencesKt___SequencesKt.map(asSequence, new Function1<String, String>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder$putIfAbsent$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(@NotNull String it) {
                String filterKey;
                Intrinsics.checkNotNullParameter(it, "it");
                filterKey = GuildFeedImagePreDecoder.INSTANCE.getFilterKey(it);
                return filterKey;
            }
        });
        distinct = SequencesKt___SequencesKt.distinct(map);
        filter = SequencesKt___SequencesKt.filter(distinct, new Function1<String, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder$putIfAbsent$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(String it) {
                boolean isBlank;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                isBlank = StringsKt__StringsJVMKt.isBlank(it);
                return Boolean.valueOf(!isBlank);
            }
        });
        for (String it : filter) {
            GuildFeedImagePreDecoder guildFeedImagePreDecoder = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            guildFeedImagePreDecoder.decode(it, allUrlList, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder
    @Nullable
    public BitmapDrawable get(@NotNull List<String> allUrlList) {
        Sequence asSequence;
        Sequence mapNotNull;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(allUrlList, "allUrlList");
        asSequence = CollectionsKt___CollectionsKt.asSequence(allUrlList);
        mapNotNull = SequencesKt___SequencesKt.mapNotNull(asSequence, new Function1<String, Bitmap>() { // from class: com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder$get$1
            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Bitmap invoke(@NotNull String it) {
                String filterKey;
                Bitmap innerGet;
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedImagePreDecoder guildFeedImagePreDecoder = GuildFeedImagePreDecoder.INSTANCE;
                filterKey = guildFeedImagePreDecoder.getFilterKey(it);
                Intrinsics.checkNotNullExpressionValue(filterKey, "it.filterKey");
                innerGet = guildFeedImagePreDecoder.innerGet(filterKey);
                return innerGet;
            }
        });
        firstOrNull = SequencesKt___SequencesKt.firstOrNull(mapNotNull);
        Bitmap bitmap = (Bitmap) firstOrNull;
        if (bitmap != null) {
            return new BitmapDrawable(MobileQQ.sMobileQQ.getResources(), bitmap);
        }
        return null;
    }
}
