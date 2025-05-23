package com.tencent.guild.aio.msglist.giphy;

import androidx.collection.LruCache;
import com.giphy.sdk.core.models.Media;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.tencent.guild.aio.msglist.giphy.util.b;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/msglist/giphy/GuildGiphyCacheManager;", "", "", "id", "Lcom/giphy/sdk/core/models/Media;", QAdVrReportParams.ParamKey.MEDIA, "", "b", "", "forceUpdate", "c", "d", "Ljava/lang/String;", "TAG", "Landroidx/collection/LruCache;", "Landroidx/collection/LruCache;", "cache", "cacheLocalPath", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildGiphyCacheManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildGiphyCacheManager f111286a = new GuildGiphyCacheManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "GiphyCacheManager";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, Media> cache = new LruCache<>(200);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String cacheLocalPath;

    static {
        String absolutePath = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        String str = File.separator;
        cacheLocalPath = absolutePath + str + "giphy" + str;
    }

    GuildGiphyCacheManager() {
    }

    public final void b(@NotNull String id5, @NotNull Media media) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(media, "media");
        c(id5, media, false);
    }

    public final void c(@NotNull String id5, @NotNull Media media, boolean forceUpdate) {
        CoroutineScope f16;
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(media, "media");
        if ((cache.put(id5, media) == null || forceUpdate) && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e)) != null) {
            CorountineFunKt.e(f16, TAG + "_addCache", null, null, null, new GuildGiphyCacheManager$addCache$1$1(media, null), 14, null);
        }
    }

    @Nullable
    public final Media d(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        LruCache<String, Media> lruCache = cache;
        Media media = lruCache.get(id5);
        if (media != null) {
            return media;
        }
        File file = new File(cacheLocalPath + id5);
        if (file.exists()) {
            try {
                Media media2 = (Media) new Gson().fromJson(b.b(file), Media.class);
                lruCache.put(id5, media2);
                return media2;
            } catch (JsonSyntaxException e16) {
                QLog.e(TAG, 4, e16, new Object[0]);
                return null;
            }
        }
        return null;
    }
}
