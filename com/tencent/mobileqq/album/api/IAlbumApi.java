package com.tencent.mobileqq.album.api;

import android.content.Context;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.qbasealbum.filter.MediaFilter;
import com.tencent.qqnt.qbasealbum.inject.QBaseAlbumCustomize;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&JC\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2'\u0010\u0015\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u000fH&JA\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172'\u0010\u0015\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u000fH&JA\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172'\u0010\u0015\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\b0\u000fH&J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0011H&J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH&J \u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001fH&J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/album/api/IAlbumApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "", "initUrlDrawable", "Lcom/tencent/qqnt/qbasealbum/inject/QBaseAlbumCustomize;", "customize", "", "initAlbum", "preloadMedia", "Lkotlinx/coroutines/CoroutineScope;", "vmScope", "Lcom/tencent/qqnt/qbasealbum/filter/MediaFilter;", "mediaFilter", "Lkotlin/Function1;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "Lkotlin/ParameterName;", "name", "data", "callback", "queryMediaTask", "", "chatType", "queryMediaFromCache", "info", "Ljava/net/URL;", "generateAlbumThumbURL", "", "time", "", "formatTimeToString", "path", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "targetPath", "Lcom/tencent/mobileqq/album/media/a;", "copyMediaToInternal", "needToBlockVideo", "album_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IAlbumApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public static final class a {
        public static /* synthetic */ void a(IAlbumApi iAlbumApi, CoroutineScope coroutineScope, MediaFilter mediaFilter, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    MediaFilter.Companion companion = MediaFilter.INSTANCE;
                    mediaFilter = new MediaFilter.a().a();
                }
                iAlbumApi.queryMediaTask(coroutineScope, mediaFilter, (Function1<? super List<LocalMediaInfo>, Unit>) function1);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMediaTask");
        }
    }

    @NotNull
    com.tencent.mobileqq.album.media.a copyMediaToInternal(@NotNull String path, @NotNull Uri uri, @NotNull String targetPath);

    @NotNull
    String formatTimeToString(long time);

    @NotNull
    URL generateAlbumThumbURL(@NotNull LocalMediaInfo info);

    void initAlbum(@NotNull Context context, boolean initUrlDrawable, @NotNull QBaseAlbumCustomize customize);

    boolean needToBlockVideo(int chatType);

    void preloadMedia();

    void queryMediaFromCache(@NotNull CoroutineScope vmScope, int chatType, @NotNull Function1<? super List<LocalMediaInfo>, Unit> callback);

    void queryMediaTask(@NotNull CoroutineScope vmScope, int chatType, @NotNull Function1<? super List<LocalMediaInfo>, Unit> callback);

    void queryMediaTask(@NotNull CoroutineScope vmScope, @NotNull MediaFilter mediaFilter, @NotNull Function1<? super List<LocalMediaInfo>, Unit> callback);
}
