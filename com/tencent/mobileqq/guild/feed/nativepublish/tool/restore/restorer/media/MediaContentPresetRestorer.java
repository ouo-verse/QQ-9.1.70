package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.media;

import android.graphics.BitmapFactory;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;
import com.tencent.biz.richframework.util.RFWMimeUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.guild.feed.data.datacenter.datastore.GuildFeedTempDataStore;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.a;
import com.tencent.mobileqq.shortvideo.util.d;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import fm1.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0002\u001b#B\u0011\u0012\b\b\u0002\u0010\u001f\u001a\u00020\n\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000bH\u0002J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\"\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J \u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001c\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u001f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/media/MediaContentPresetRestorer;", "Lpm1/b;", "Lorg/json/JSONObject;", "jsonObject", "Lom1/b;", "restoreResult", "", "j", "image", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", h.F, "", "path", "", "e", "imgPath", "Landroid/graphics/BitmapFactory$Options;", "d", "video", "i", "localMediaInfo", "k", "f", "Lom1/a;", "restoreInfo", "a", "", "g", "I", "traceId", "<init>", "(I)V", "b", "RestoreException", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MediaContentPresetRestorer implements pm1.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int traceId;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/restorer/media/MediaContentPresetRestorer$RestoreException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "errorCode", "", "errorMsg", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "getErrorCode", "()I", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class RestoreException extends IllegalArgumentException {
        private final int errorCode;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RestoreException(int i3, @NotNull String errorMsg, @Nullable Throwable th5) {
            super(errorMsg, th5);
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.errorCode = i3;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Integer) ((Pair) t16).getFirst(), (Integer) ((Pair) t17).getFirst());
            return compareValues;
        }
    }

    public MediaContentPresetRestorer(int i3) {
        this.traceId = i3;
    }

    private final BitmapFactory.Options d(String imgPath) {
        boolean z16;
        if (imgPath != null && imgPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("FeedEditor.PresetRestorer", 1, "[fixPicInfo]: traceId=" + this.traceId + ", imgPath is empty");
            return null;
        }
        if (new File(imgPath).exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(imgPath, options);
            return options;
        }
        QLog.d("FeedEditor.PresetRestorer", 1, "[fixPicInfo]: traceId=" + this.traceId + ", Error File does not exist, path=" + imgPath);
        return null;
    }

    private final long e(String path) {
        try {
            StructStat stat = Os.stat(path);
            if (stat != null) {
                return stat.st_size;
            }
            return 0L;
        } catch (ErrnoException e16) {
            throw new RestoreException(1, "illegal media, path=" + path, e16);
        }
    }

    private final void f(LocalMediaInfo localMediaInfo, JSONObject video) {
        c.h hVar = c.h.f220912a;
        if (video.has("width") && video.has("height") && video.has("duration")) {
            localMediaInfo.mediaWidth = video.optInt("width");
            localMediaInfo.mediaHeight = video.optInt("height");
            return;
        }
        d.a aVar = new d.a();
        d.a(localMediaInfo.path, aVar);
        int[] iArr = aVar.f288248a;
        localMediaInfo.mediaWidth = iArr[0];
        localMediaInfo.mediaHeight = iArr[1];
        localMediaInfo.mDuration = iArr[3];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, LocalMediaInfo> h(JSONObject image) {
        BitmapFactory.Options d16;
        c.d dVar = c.d.f220908a;
        Integer valueOf = Integer.valueOf(image.optInt("display_index"));
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        String string = image.getString("picUrl");
        if (string == null) {
            string = "";
        }
        localMediaInfo.path = string;
        if (!QAlbumUtil.isNetUrl(string)) {
            localMediaInfo.mediaWidth = image.optInt("width");
            localMediaInfo.mediaHeight = image.optInt("height");
            int i3 = AlbumThumbDownloader.THUMB_WIDHT;
            localMediaInfo.thumbWidth = i3;
            localMediaInfo.thumbHeight = i3;
            localMediaInfo.mMimeType = RFWMimeUtil.getMimeByMimeTool(localMediaInfo.path);
            localMediaInfo.isRwa = true;
            String path = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(path, "path");
            localMediaInfo.fileSize = e(path);
            if ((localMediaInfo.mediaHeight == 0 || localMediaInfo.mediaWidth == 0) && (d16 = d(localMediaInfo.path)) != null) {
                localMediaInfo.mediaWidth = d16.outWidth;
                localMediaInfo.mediaHeight = d16.outHeight;
                localMediaInfo.mMimeType = d16.outMimeType;
            }
            return TuplesKt.to(valueOf, localMediaInfo);
        }
        throw new IllegalArgumentException("net url is unsupported".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, LocalMediaInfo> i(JSONObject video) {
        c.h hVar = c.h.f220912a;
        Integer valueOf = Integer.valueOf(video.optInt("display_index"));
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = video.getString("playUrl");
        if (!QAlbumUtil.isNetUrl(r2)) {
            localMediaInfo.mDuration = video.optInt("duration");
            f(localMediaInfo, video);
            String mimeByMimeTool = RFWMimeUtil.getMimeByMimeTool(localMediaInfo.path);
            localMediaInfo.videoMimeType = mimeByMimeTool;
            localMediaInfo.mMimeType = mimeByMimeTool;
            String path = localMediaInfo.path;
            Intrinsics.checkNotNullExpressionValue(path, "path");
            localMediaInfo.fileSize = e(path);
            localMediaInfo.isSystemMeidaStore = false;
            k(video, localMediaInfo);
            return TuplesKt.to(valueOf, localMediaInfo);
        }
        throw new IllegalArgumentException("net url is unsupported".toString());
    }

    private final void j(JSONObject jsonObject, om1.b restoreResult) {
        int collectionSizeOrDefault;
        List<i> b16 = restoreResult.b();
        List<LocalMediaInfo> first = g(jsonObject).getFirst();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(first, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = first.iterator();
        while (it.hasNext()) {
            arrayList.add(new fm1.c((LocalMediaInfo) it.next(), a.f222223a.b()));
        }
        b16.addAll(arrayList);
    }

    private final void k(JSONObject video, LocalMediaInfo localMediaInfo) {
        String str;
        BitmapFactory.Options d16;
        boolean z16;
        JSONObject optJSONObject = video.optJSONObject("cover");
        if (optJSONObject != null) {
            str = optJSONObject.optString("picUrl");
        } else {
            str = null;
        }
        if (optJSONObject != null) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                c.d dVar = c.d.f220908a;
                localMediaInfo.thumbnailPath = optJSONObject.getString("picUrl");
                localMediaInfo.thumbWidth = optJSONObject.optInt("width");
                localMediaInfo.thumbHeight = optJSONObject.optInt("height");
                if ((localMediaInfo.thumbWidth != 0 || localMediaInfo.thumbHeight == 0) && (d16 = d(localMediaInfo.thumbnailPath)) != null) {
                    localMediaInfo.thumbWidth = d16.outWidth;
                    localMediaInfo.thumbHeight = d16.outHeight;
                }
                return;
            }
        }
        QLog.w("FeedEditor.PresetRestorer", 1, "[supplyVideoCoverAnyway]: traceId=" + this.traceId + " video of " + localMediaInfo.path + " doesn't has cover");
        if (localMediaInfo.thumbWidth != 0) {
        }
        localMediaInfo.thumbWidth = d16.outWidth;
        localMediaInfo.thumbHeight = d16.outHeight;
    }

    @Override // pm1.b
    public void a(@NotNull JSONObject jsonObject, @NotNull om1.b restoreResult, @Nullable RestoreInfo restoreInfo) {
        Object obj;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(restoreResult, "restoreResult");
        if (restoreInfo == null) {
            return;
        }
        String string = restoreInfo.a().h().getExtra().getString("local_media_info_list");
        if (string == null) {
            string = "";
        }
        jj1.b c16 = jj1.b.c();
        Intrinsics.checkNotNullExpressionValue(c16, "getInstance()");
        GuildFeedTempDataStore.b bVar = (GuildFeedTempDataStore.b) c16.getData("GuildFeedTempDataStore", string);
        Object obj2 = null;
        if (bVar != null) {
            obj = bVar.getValue();
        } else {
            obj = null;
        }
        if (obj != null) {
            c16.removeDataByKey("GuildFeedTempDataStore", string);
        }
        if (obj instanceof List) {
            obj2 = obj;
        }
        List list = (List) obj2;
        if (list == null) {
            j(jsonObject, restoreResult);
            return;
        }
        List<i> b16 = restoreResult.b();
        List list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new fm1.c((LocalMediaInfo) it.next(), a.f222223a.b()));
        }
        b16.addAll(arrayList);
    }

    @NotNull
    public final Pair<List<LocalMediaInfo>, Integer> g(@NotNull JSONObject jsonObject) {
        int i3;
        int collectionSizeOrDefault;
        String stackTraceToString;
        String stackTraceToString2;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        ArrayList arrayList = new ArrayList();
        c.C7754c c7754c = c.C7754c.f220907a;
        JSONArray optJSONArray = jsonObject.optJSONArray("images");
        int i16 = 1;
        if (optJSONArray != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(IMAGES)");
            if (QLog.isDevelopLevel()) {
                QLog.d("FeedEditor.PresetRestorer", 4, "[restore]: images.size=" + optJSONArray.length());
            }
            int length = optJSONArray.length();
            int i17 = 0;
            i3 = 0;
            while (i17 < length) {
                try {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i17);
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "images.getJSONObject(index)");
                    arrayList.add(h(jSONObject));
                } catch (RestoreException e16) {
                    i3 = e16.getErrorCode();
                    QLog.e("FeedEditor.PresetRestorer", 1, "[runCatchingTargetException]: traceId=" + this.traceId + ", " + e16.getMessage() + ", cause=" + e16.getCause());
                } catch (NullPointerException e17) {
                    throw e17;
                } catch (Exception e18) {
                    int i18 = this.traceId;
                    stackTraceToString2 = ExceptionsKt__ExceptionsKt.stackTraceToString(e18);
                    QLog.e("FeedEditor.PresetRestorer", i16, "[runCatchingTargetException]: traceId=" + i18 + ",  " + stackTraceToString2);
                }
                i17++;
                i16 = 1;
            }
        } else {
            i3 = 0;
        }
        JSONArray optJSONArray2 = jsonObject.optJSONArray("videos");
        if (optJSONArray2 != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(VIDEOS)");
            if (QLog.isDevelopLevel()) {
                QLog.d("FeedEditor.PresetRestorer", 4, "[restore]: videos.size=" + optJSONArray2.length());
            }
            int length2 = optJSONArray2.length();
            for (int i19 = 0; i19 < length2; i19++) {
                try {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i19);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "videos.getJSONObject(index)");
                    arrayList.add(i(jSONObject2));
                } catch (RestoreException e19) {
                    i3 = e19.getErrorCode();
                    QLog.e("FeedEditor.PresetRestorer", 1, "[runCatchingTargetException]: traceId=" + this.traceId + ", " + e19.getMessage() + ", cause=" + e19.getCause());
                } catch (NullPointerException e26) {
                    throw e26;
                } catch (Exception e27) {
                    int i26 = this.traceId;
                    stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(e27);
                    QLog.e("FeedEditor.PresetRestorer", 1, "[runCatchingTargetException]: traceId=" + i26 + ",  " + stackTraceToString);
                }
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new b());
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add((LocalMediaInfo) ((Pair) it.next()).getSecond());
        }
        return TuplesKt.to(arrayList2, Integer.valueOf(i3));
    }

    public /* synthetic */ MediaContentPresetRestorer(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }
}
