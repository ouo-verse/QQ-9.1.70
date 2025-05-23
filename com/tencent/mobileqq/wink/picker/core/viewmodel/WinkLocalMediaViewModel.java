package com.tencent.mobileqq.wink.picker.core.viewmodel;

import android.content.Intent;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.repository.a;
import com.tencent.richframework.data.base.UIStateData;
import common.config.service.QzoneConfig;
import e93.QZoneAlbumInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 Y2\u00020\u0001:\u0002Z[B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0006H\u0002J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0006H\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u001c\u0010\u001e\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001d\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\nH\u0016J\"\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J\"\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0\u00192\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0016\u0010(\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020#0&H\u0016J\u0012\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010+\u001a\u00020\u0004H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0004H\u0014R\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u00103\u001a\u00020\n8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010:R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R \u0010A\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020#0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR,\u0010C\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010BR,\u0010D\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010BR,\u0010E\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010BR&\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR&\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010GR&\u0010I\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010GR\u0016\u0010J\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0006\u00a2\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bO\u0010QR\u0017\u0010S\u001a\u00020R8\u0006\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/BaseWinkMediaViewModel;", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "", "onQueryFinish", "", "isFirstFetch", "processMediaRepoData", "locked", "", "invokeMethod", "updateLock", "needNotifyUI", "updateMediaUIStateLiveData", "updateVideosUIStateLiveData", "updateImagesUIStateLiveData", "notifyMediaUpdate", "notifyVideoUpdate", "notifyImageUpdate", "postFirstFetchDone", "reportFetchDone", "Landroid/content/Intent;", "intent", "setIntent", "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/data/QQAlbumInfo;", "curSelectedAlbumId", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "observeAlbumChange", "getLogTag", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getMediaUIStateLiveData", "getMediaUIState", "", "selectedMedia", "onMediaInit", "albumId", "switchAlbum", "fetchFirstPageMedia", "loadMoreMedia", "needLoadMore", "onCleared", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "Lcom/tencent/mobileqq/wink/picker/core/repository/h;", "localMediaRepository", "Lcom/tencent/mobileqq/wink/picker/core/repository/h;", "currentAlbumId", "Ljava/lang/String;", "getCurrentAlbumId", "()Ljava/lang/String;", "setCurrentAlbumId", "(Ljava/lang/String;)V", "isAlbumChangeObserved", "Z", "isFirstFetchInvoked", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel$c;", "albumIdToLoadingStatus", "Ljava/util/concurrent/ConcurrentHashMap;", "", "mediaPathToLocalMedia", "Ljava/util/Map;", "albumIdToMediaUIStateData", "albumIdToVideosUIStateData", "albumIdToImagesUIStateData", "mediaMediatorLiveData", "Landroidx/lifecycle/MediatorLiveData;", "videosMediatorLiveData", "imagesMediatorLiveData", "hostFragmentIntent", "Landroid/content/Intent;", "Landroidx/lifecycle/MutableLiveData;", "_isFirstFetchDoneLiveData", "Landroidx/lifecycle/MutableLiveData;", "isFirstFetchDoneLiveData", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "<init>", "(Lcom/tencent/mobileqq/wink/picker/MediaType;)V", "Companion", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkLocalMediaViewModel extends BaseWinkMediaViewModel {

    @NotNull
    private static final String FIRST_PAGE_KEY = "firstPageFlag";
    private static final int FIRST_PAGE_MEDIA_SIZE = 100;

    @NotNull
    private static final String FIRST_QUERY_DONE_EMPTY = "-20002";

    @NotNull
    private static final String FIRST_QUERY_DONE_FAILURE = "-20001";

    @NotNull
    public static final String FIRST_QUERY_DONE_NO_PERMISSION = "-20003";

    @NotNull
    private static final String FIRST_QUERY_DONE_SUCCESS = "0";
    private static final int FIRST_SCREEN_MEDIA_SIZE = 15;
    public static final int MEDIA_SIZE_MOST_LEFT = 10000;
    private static final int MEDIA_SIZE_MOST_RIGHT = 11000;
    private static final int NEXT_PAGE_MEDIA_SIZE = 1000;

    @NotNull
    private static final String TAG = "WinkLocalMediaViewModel";

    @NotNull
    private static final String TIMES_OF_QUERY = "timesOfQuery";

    @NotNull
    private final MutableLiveData<String> _isFirstFetchDoneLiveData;

    @NotNull
    private final Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToImagesUIStateData;

    @NotNull
    private final ConcurrentHashMap<String, LoadingStatus> albumIdToLoadingStatus;

    @NotNull
    private final Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToMediaUIStateData;

    @NotNull
    private final Map<String, UIStateData<List<LocalMediaInfo>>> albumIdToVideosUIStateData;

    @NotNull
    private String currentAlbumId;

    @NotNull
    private Intent hostFragmentIntent;

    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> imagesMediatorLiveData;
    private boolean isAlbumChangeObserved;

    @NotNull
    private final LiveData<String> isFirstFetchDoneLiveData;
    private boolean isFirstFetchInvoked;

    @NotNull
    private final com.tencent.mobileqq.wink.picker.core.repository.h localMediaRepository;

    @NotNull
    private final ReentrantLock lock;

    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediaMediatorLiveData;

    @NotNull
    private final Map<String, LocalMediaInfo> mediaPathToLocalMedia;

    @NotNull
    private final MediaType mediaType;

    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> videosMediatorLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel$a", "Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "Le93/j;", "qZoneAlbumInfo", "", "a", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements a.b {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void a(@NotNull QZoneAlbumInfo qZoneAlbumInfo) {
            Intrinsics.checkNotNullParameter(qZoneAlbumInfo, "qZoneAlbumInfo");
        }

        @Override // com.tencent.mobileqq.wink.picker.core.repository.a.b
        public void b(@NotNull com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
            Intrinsics.checkNotNullParameter(mediaRepoData, "mediaRepoData");
            WinkLocalMediaViewModel.this.onQueryFinish(mediaRepoData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkLocalMediaViewModel$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "d", "(Z)V", "needLoadMore", "b", "c", "e", "isQuerying", "I", "()I", "f", "(I)V", WinkLocalMediaViewModel.TIMES_OF_QUERY, "<init>", "(ZZI)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalMediaViewModel$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class LoadingStatus {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean needLoadMore;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isQuerying;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int timesOfQuery;

        public LoadingStatus(boolean z16, boolean z17, int i3) {
            this.needLoadMore = z16;
            this.isQuerying = z17;
            this.timesOfQuery = i3;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedLoadMore() {
            return this.needLoadMore;
        }

        /* renamed from: b, reason: from getter */
        public final int getTimesOfQuery() {
            return this.timesOfQuery;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getIsQuerying() {
            return this.isQuerying;
        }

        public final void d(boolean z16) {
            this.needLoadMore = z16;
        }

        public final void e(boolean z16) {
            this.isQuerying = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadingStatus)) {
                return false;
            }
            LoadingStatus loadingStatus = (LoadingStatus) other;
            if (this.needLoadMore == loadingStatus.needLoadMore && this.isQuerying == loadingStatus.isQuerying && this.timesOfQuery == loadingStatus.timesOfQuery) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            this.timesOfQuery = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.needLoadMore;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.isQuerying;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i16 + i3) * 31) + this.timesOfQuery;
        }

        @NotNull
        public String toString() {
            return "LoadingStatus(needLoadMore=" + this.needLoadMore + ", isQuerying=" + this.isQuerying + ", timesOfQuery=" + this.timesOfQuery + ")";
        }

        public /* synthetic */ LoadingStatus(boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? false : z16, z17, (i16 & 4) != 0 ? 1 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324805a;

        static {
            int[] iArr = new int[MediaType.values().length];
            try {
                iArr[MediaType.LOCAL_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaType.LOCAL_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaType.LOCAL_IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f324805a = iArr;
        }
    }

    public WinkLocalMediaViewModel(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        this.mediaType = mediaType;
        com.tencent.mobileqq.wink.picker.core.repository.h hVar = new com.tencent.mobileqq.wink.picker.core.repository.h(mediaType, com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getQueryMediaFilter());
        this.localMediaRepository = hVar;
        this.currentAlbumId = QAlbumCustomAlbumConstants.RECENT_ALBUM_ID;
        this.albumIdToLoadingStatus = new ConcurrentHashMap<>();
        this.mediaPathToLocalMedia = new LinkedHashMap();
        this.albumIdToMediaUIStateData = new LinkedHashMap();
        this.albumIdToVideosUIStateData = new LinkedHashMap();
        this.albumIdToImagesUIStateData = new LinkedHashMap();
        this.mediaMediatorLiveData = new MediatorLiveData<>();
        this.videosMediatorLiveData = new MediatorLiveData<>();
        this.imagesMediatorLiveData = new MediatorLiveData<>();
        this.hostFragmentIntent = new Intent();
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._isFirstFetchDoneLiveData = mutableLiveData;
        this.isFirstFetchDoneLiveData = mutableLiveData;
        this.lock = new ReentrantLock();
        hVar.mediaQueryListener = new a();
    }

    private final boolean isFirstFetch(com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
        Object obj;
        Map<String, Object> f16 = mediaRepoData.f();
        Boolean bool = null;
        if (f16 != null) {
            obj = f16.get(FIRST_PAGE_KEY);
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        }
        return Intrinsics.areEqual(bool, Boolean.TRUE);
    }

    private final void notifyImageUpdate() {
        UIStateData<List<LocalMediaInfo>> uIStateData = this.albumIdToImagesUIStateData.get(this.currentAlbumId);
        if (uIStateData != null) {
            this.imagesMediatorLiveData.postValue(uIStateData);
        }
    }

    private final void notifyMediaUpdate() {
        UIStateData<List<LocalMediaInfo>> uIStateData = this.albumIdToMediaUIStateData.get(this.currentAlbumId);
        if (uIStateData != null) {
            this.mediaMediatorLiveData.postValue(uIStateData);
        }
    }

    private final void notifyVideoUpdate() {
        UIStateData<List<LocalMediaInfo>> uIStateData = this.albumIdToVideosUIStateData.get(this.currentAlbumId);
        if (uIStateData != null) {
            this.videosMediatorLiveData.postValue(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observeAlbumChange$lambda$0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void onQueryFinish(com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
        boolean z16;
        boolean z17;
        Map<String, Object> mutableMapOf;
        w53.b.f(TAG, "onQueryFinish: mediaRepoData[" + mediaRepoData + "]");
        boolean isFirstFetch = isFirstFetch(mediaRepoData);
        postFirstFetchDone(isFirstFetch, mediaRepoData);
        ConcurrentHashMap<String, LoadingStatus> concurrentHashMap = this.albumIdToLoadingStatus;
        String albumId = mediaRepoData.getAlbumId();
        LoadingStatus loadingStatus = concurrentHashMap.get(albumId);
        if (loadingStatus == null) {
            w53.b.c(TAG, "onQueryFinish exception: " + mediaRepoData.getAlbumId() + " not in " + this.albumIdToLoadingStatus);
            loadingStatus = new LoadingStatus(false, true, 0, 4, null);
            LoadingStatus putIfAbsent = concurrentHashMap.putIfAbsent(albumId, loadingStatus);
            if (putIfAbsent != null) {
                loadingStatus = putIfAbsent;
            }
        }
        LoadingStatus loadingStatus2 = loadingStatus;
        if (mediaRepoData.getIsSuccess() && mediaRepoData.getHasMore()) {
            z16 = true;
        } else {
            z16 = false;
        }
        loadingStatus2.d(z16);
        if (!Intrinsics.areEqual(mediaRepoData.getAlbumId(), this.currentAlbumId)) {
            loadingStatus2.e(false);
        }
        com.tencent.mobileqq.wink.picker.core.repository.b processMediaRepoData = processMediaRepoData(isFirstFetch, mediaRepoData);
        if (mediaRepoData.getIsSuccess() && !isFirstFetch && loadingStatus2.getNeedLoadMore()) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            w53.b.f(TAG, "onQueryFinish: needNotifyUI, isSuccess=" + mediaRepoData.getIsSuccess() + ", isFirstFetch=" + isFirstFetch + ", needLoadMore=" + loadingStatus2);
        }
        updateMediaUIStateLiveData(processMediaRepoData, z17);
        updateVideosUIStateLiveData(processMediaRepoData, z17);
        updateImagesUIStateLiveData(processMediaRepoData, z17);
        if (processMediaRepoData.getHasMore() && Intrinsics.areEqual(mediaRepoData.getAlbumId(), this.currentAlbumId)) {
            loadingStatus2.f(loadingStatus2.getTimesOfQuery() + 1);
            com.tencent.mobileqq.wink.picker.core.repository.h hVar = this.localMediaRepository;
            String str = this.currentAlbumId;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(TIMES_OF_QUERY, Integer.valueOf(loadingStatus2.getTimesOfQuery())));
            hVar.a(str, 1000, mutableMapOf);
        } else if (Intrinsics.areEqual(this.currentAlbumId, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID) && this.hostFragmentIntent.getBooleanExtra(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, false) && QzoneConfig.isShowWinkTemplateLibrary()) {
            v83.b.f441239a.k(this.mediaPathToLocalMedia);
        }
        reportFetchDone(mediaRepoData);
    }

    private final void postFirstFetchDone(boolean isFirstFetch, com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
        String str;
        if (isFirstFetch) {
            if (mediaRepoData.getIsSuccess()) {
                if (mediaRepoData.e().isEmpty()) {
                    str = FIRST_QUERY_DONE_EMPTY;
                } else {
                    str = "0";
                }
            } else {
                str = FIRST_QUERY_DONE_FAILURE;
            }
            com.tencent.mobileqq.wink.picker.h.f324861a.d(str);
            this._isFirstFetchDoneLiveData.postValue(str);
        }
    }

    @WorkerThread
    private final com.tencent.mobileqq.wink.picker.core.repository.b processMediaRepoData(boolean isFirstFetch, com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List<LocalMediaInfo> list;
        if (isFirstFetch) {
            updateLock(true, "processMediaRepoData");
        }
        if (this.mediaPathToLocalMedia.isEmpty()) {
            Iterator<T> it = mediaRepoData.e().iterator();
            while (it.hasNext()) {
                updateLocalMediaInfo((LocalMediaInfo) it.next());
            }
            list = mediaRepoData.e();
        } else {
            List<LocalMediaInfo> e16 = mediaRepoData.e();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo localMediaInfo : e16) {
                LocalMediaInfo localMediaInfo2 = this.mediaPathToLocalMedia.get(localMediaInfo.path);
                if (localMediaInfo2 == null) {
                    Map<String, LocalMediaInfo> map = this.mediaPathToLocalMedia;
                    String str = localMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str, "mediaInList.path");
                    map.put(str, localMediaInfo);
                } else {
                    localMediaInfo = localMediaInfo2;
                }
                arrayList.add(localMediaInfo);
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                arrayList2.add(updateLocalMediaInfo((LocalMediaInfo) it5.next()));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList2);
        }
        List<LocalMediaInfo> list2 = list;
        if (isFirstFetch) {
            updateLock(false, "processMediaRepoData");
        }
        return com.tencent.mobileqq.wink.picker.core.repository.b.b(mediaRepoData, null, list2, false, false, null, 29, null);
    }

    private final void reportFetchDone(com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData) {
        Integer num;
        Integer num2;
        List<LocalMediaInfo> data;
        List<LocalMediaInfo> data2;
        List<LocalMediaInfo> data3;
        if (mediaRepoData.getHasMore() || !Intrinsics.areEqual(mediaRepoData.getAlbumId(), QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
            return;
        }
        com.tencent.mobileqq.wink.picker.h hVar = com.tencent.mobileqq.wink.picker.h.f324861a;
        UIStateData<List<LocalMediaInfo>> value = this.mediaMediatorLiveData.getValue();
        Integer num3 = null;
        if (value != null && (data3 = value.getData()) != null) {
            num = Integer.valueOf(data3.size());
        } else {
            num = null;
        }
        UIStateData<List<LocalMediaInfo>> value2 = this.imagesMediatorLiveData.getValue();
        if (value2 != null && (data2 = value2.getData()) != null) {
            num2 = Integer.valueOf(data2.size());
        } else {
            num2 = null;
        }
        UIStateData<List<LocalMediaInfo>> value3 = this.videosMediatorLiveData.getValue();
        if (value3 != null && (data = value3.getData()) != null) {
            num3 = Integer.valueOf(data.size());
        }
        hVar.c(num, num2, num3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        if (r3 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateImagesUIStateLiveData(com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData, boolean needNotifyUI) {
        boolean z16;
        MediaType mediaType = this.mediaType;
        if (mediaType == MediaType.LOCAL_IMAGE || mediaType == MediaType.LOCAL_ALL) {
            UIStateData<List<LocalMediaInfo>> mediaUIStateLiveData = getMediaUIStateLiveData(this.albumIdToImagesUIStateData, mediaRepoData);
            int size = mediaUIStateLiveData.getData().size();
            List<LocalMediaInfo> data = mediaUIStateLiveData.getData();
            List<LocalMediaInfo> e16 = mediaRepoData.e();
            ArrayList arrayList = new ArrayList();
            for (Object obj : e16) {
                if (e93.i.G((LocalMediaInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            data.addAll(arrayList);
            boolean z17 = false;
            if (mediaUIStateLiveData.getData().isEmpty()) {
                mediaUIStateLiveData.setState(0);
            }
            if (!needNotifyUI) {
                if (size >= 0 && size < 16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int size2 = mediaUIStateLiveData.getData().size();
                    if (10000 <= size2 && size2 < 11001) {
                        z17 = true;
                    }
                }
            }
            this.imagesMediatorLiveData.postValue(mediaUIStateLiveData);
            if (!mediaRepoData.getHasMore()) {
                w53.b.f(TAG, "query images end: currentAlbumId=" + this.currentAlbumId + ", size=" + mediaUIStateLiveData.getData().size());
            }
        }
    }

    static /* synthetic */ void updateImagesUIStateLiveData$default(WinkLocalMediaViewModel winkLocalMediaViewModel, com.tencent.mobileqq.wink.picker.core.repository.b bVar, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            winkLocalMediaViewModel.updateImagesUIStateLiveData(bVar, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateImagesUIStateLiveData");
    }

    private final void updateLock(boolean locked, String invokeMethod) {
        try {
            if (locked) {
                this.lock.lock();
            } else {
                this.lock.unlock();
            }
            w53.b.f(TAG, "updateLock ==>> locked:" + locked + ", invokeMethod=" + invokeMethod + ", thread=" + Thread.currentThread().getName());
        } catch (Exception e16) {
            w53.b.d(TAG, "updateLock ==>> locked:" + locked + ", invokeMethod=" + invokeMethod, e16);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        if (r2 != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateMediaUIStateLiveData(com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData, boolean needNotifyUI) {
        if (this.mediaType != MediaType.LOCAL_ALL) {
            return;
        }
        UIStateData<List<LocalMediaInfo>> mediaUIStateLiveData = getMediaUIStateLiveData(this.albumIdToMediaUIStateData, mediaRepoData);
        mediaUIStateLiveData.getData().addAll(mediaRepoData.e());
        boolean z16 = false;
        if (mediaUIStateLiveData.getData().isEmpty()) {
            mediaUIStateLiveData.setState(0);
        }
        if (!needNotifyUI) {
            int size = mediaUIStateLiveData.getData().size();
            if (10000 <= size && size < 11001) {
                z16 = true;
            }
        }
        this.mediaMediatorLiveData.postValue(mediaUIStateLiveData);
        if (!mediaRepoData.getHasMore()) {
            w53.b.f(TAG, "query media end: currentAlbumId=" + this.currentAlbumId + ", size=" + mediaUIStateLiveData.getData().size());
        }
    }

    static /* synthetic */ void updateMediaUIStateLiveData$default(WinkLocalMediaViewModel winkLocalMediaViewModel, com.tencent.mobileqq.wink.picker.core.repository.b bVar, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            winkLocalMediaViewModel.updateMediaUIStateLiveData(bVar, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateMediaUIStateLiveData");
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x007a, code lost:
    
        if (r3 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateVideosUIStateLiveData(com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData, boolean needNotifyUI) {
        boolean z16;
        MediaType mediaType = this.mediaType;
        if (mediaType == MediaType.LOCAL_VIDEO || mediaType == MediaType.LOCAL_ALL) {
            UIStateData<List<LocalMediaInfo>> mediaUIStateLiveData = getMediaUIStateLiveData(this.albumIdToVideosUIStateData, mediaRepoData);
            int size = mediaUIStateLiveData.getData().size();
            List<LocalMediaInfo> data = mediaUIStateLiveData.getData();
            List<LocalMediaInfo> e16 = mediaRepoData.e();
            ArrayList arrayList = new ArrayList();
            for (Object obj : e16) {
                if (e93.i.I((LocalMediaInfo) obj)) {
                    arrayList.add(obj);
                }
            }
            data.addAll(arrayList);
            boolean z17 = false;
            if (mediaUIStateLiveData.getData().isEmpty()) {
                mediaUIStateLiveData.setState(0);
            }
            if (!needNotifyUI) {
                if (size >= 0 && size < 16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    int size2 = mediaUIStateLiveData.getData().size();
                    if (10000 <= size2 && size2 < 11001) {
                        z17 = true;
                    }
                }
            }
            this.videosMediatorLiveData.postValue(mediaUIStateLiveData);
            if (!mediaRepoData.getHasMore()) {
                w53.b.f(TAG, "query videos end: currentAlbumId=" + this.currentAlbumId + ", size=" + mediaUIStateLiveData.getData().size());
            }
        }
    }

    static /* synthetic */ void updateVideosUIStateLiveData$default(WinkLocalMediaViewModel winkLocalMediaViewModel, com.tencent.mobileqq.wink.picker.core.repository.b bVar, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            winkLocalMediaViewModel.updateVideosUIStateLiveData(bVar, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateVideosUIStateLiveData");
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public void fetchFirstPageMedia() {
        Map<String, Object> mutableMapOf;
        if (this.isFirstFetchInvoked) {
            return;
        }
        if (!com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getAlreadySelectedMedia().isEmpty()) {
            updateLock(true, "fetchFirstPageMedia");
        }
        this.isFirstFetchInvoked = true;
        this.albumIdToLoadingStatus.put(this.currentAlbumId, new LoadingStatus(false, true, 0, 4, null));
        com.tencent.mobileqq.wink.picker.core.repository.h hVar = this.localMediaRepository;
        String str = this.currentAlbumId;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(FIRST_PAGE_KEY, Boolean.TRUE));
        hVar.a(str, 100, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String getCurrentAlbumId() {
        return this.currentAlbumId;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    @NotNull
    public LiveData<UIStateData<List<LocalMediaInfo>>> getMediaUIState(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return getMediaUIStateLiveData(mediaType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    @NotNull
    public MediatorLiveData<UIStateData<List<LocalMediaInfo>>> getMediaUIStateLiveData(@NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        int i3 = d.f324805a[mediaType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return this.mediaMediatorLiveData;
                }
                return this.imagesMediatorLiveData;
            }
            return this.videosMediatorLiveData;
        }
        return this.mediaMediatorLiveData;
    }

    @NotNull
    public final LiveData<String> isFirstFetchDoneLiveData() {
        return this.isFirstFetchDoneLiveData;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public void loadMoreMedia() {
        if (needLoadMore()) {
            int i3 = d.f324805a[this.mediaType.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    notifyMediaUpdate();
                    notifyVideoUpdate();
                    notifyImageUpdate();
                    return;
                }
                notifyImageUpdate();
                return;
            }
            notifyVideoUpdate();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public boolean needLoadMore() {
        LoadingStatus loadingStatus = this.albumIdToLoadingStatus.get(this.currentAlbumId);
        if (loadingStatus == null) {
            return false;
        }
        w53.b.f(TAG, "needLoadMore: " + this.currentAlbumId + ", " + loadingStatus);
        return loadingStatus.getNeedLoadMore();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void observeAlbumChange(@NotNull LiveData<QQAlbumInfo> curSelectedAlbumId, @NotNull MediaType mediaType) {
        Intrinsics.checkNotNullParameter(curSelectedAlbumId, "curSelectedAlbumId");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        if (this.isAlbumChangeObserved) {
            return;
        }
        this.isAlbumChangeObserved = true;
        getMediaUIStateLiveData(mediaType).removeSource(curSelectedAlbumId);
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediaUIStateLiveData = getMediaUIStateLiveData(mediaType);
        final Function1<QQAlbumInfo, Unit> function1 = new Function1<QQAlbumInfo, Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.WinkLocalMediaViewModel$observeAlbumChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQAlbumInfo qQAlbumInfo) {
                invoke2(qQAlbumInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(QQAlbumInfo qQAlbumInfo) {
                WinkLocalMediaViewModel.this.switchAlbum(qQAlbumInfo.f203112id);
            }
        };
        mediaUIStateLiveData.addSource(curSelectedAlbumId, new Observer() { // from class: com.tencent.mobileqq.wink.picker.core.viewmodel.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkLocalMediaViewModel.observeAlbumChange$lambda$0(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        w53.b.f(TAG, "onCleared");
        com.tencent.mobileqq.wink.picker.core.repository.h hVar = this.localMediaRepository;
        hVar.mediaQueryListener = null;
        hVar.j();
        UIStateData<List<LocalMediaInfo>> obtainEmpty = UIStateData.obtainEmpty();
        this.mediaMediatorLiveData.setValue(obtainEmpty);
        this.videosMediatorLiveData.setValue(obtainEmpty);
        this.imagesMediatorLiveData.setValue(obtainEmpty);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public void onMediaInit(@NotNull List<? extends LocalMediaInfo> selectedMedia) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        ArrayList arrayList = new ArrayList();
        for (Object obj : selectedMedia) {
            if (!e93.i.E((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Map<String, LocalMediaInfo> map = this.mediaPathToLocalMedia;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((LocalMediaInfo) obj2).path, obj2);
            }
            map.putAll(linkedHashMap);
        }
        if (this.lock.isLocked()) {
            updateLock(false, "onMediaInit");
        }
    }

    protected final void setCurrentAlbumId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentAlbumId = str;
    }

    public final void setIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.hostFragmentIntent = intent;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.BaseWinkMediaViewModel
    public void switchAlbum(@Nullable String albumId) {
        boolean z16;
        UIStateData<List<LocalMediaInfo>> uIStateData;
        Map<String, Object> mutableMapOf;
        Map<String, Object> mutableMapOf2;
        w53.b.f(TAG, "switchAlbum: albumId=" + albumId);
        if (albumId != null && albumId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            UIStateData<List<LocalMediaInfo>> obtainEmpty = UIStateData.obtainEmpty();
            this.mediaMediatorLiveData.setValue(obtainEmpty);
            this.videosMediatorLiveData.setValue(obtainEmpty);
            this.imagesMediatorLiveData.setValue(obtainEmpty);
            return;
        }
        if (Intrinsics.areEqual(this.currentAlbumId, albumId)) {
            return;
        }
        this.currentAlbumId = albumId;
        int i3 = d.f324805a[this.mediaType.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                uIStateData = this.albumIdToMediaUIStateData.get(this.currentAlbumId);
            } else {
                uIStateData = this.albumIdToImagesUIStateData.get(this.currentAlbumId);
            }
        } else {
            uIStateData = this.albumIdToVideosUIStateData.get(this.currentAlbumId);
        }
        if (uIStateData == null) {
            this.albumIdToLoadingStatus.put(this.currentAlbumId, new LoadingStatus(false, true, 0, 4, null));
            com.tencent.mobileqq.wink.picker.core.repository.h hVar = this.localMediaRepository;
            String str = this.currentAlbumId;
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(new Pair(FIRST_PAGE_KEY, Boolean.TRUE));
            hVar.a(str, 100, mutableMapOf2);
            return;
        }
        this.mediaMediatorLiveData.setValue(uIStateData);
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediatorLiveData = this.videosMediatorLiveData;
        UIStateData<List<LocalMediaInfo>> uIStateData2 = this.albumIdToVideosUIStateData.get(this.currentAlbumId);
        if (uIStateData2 == null) {
            uIStateData2 = UIStateData.obtainEmpty();
        }
        mediatorLiveData.setValue(uIStateData2);
        MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediatorLiveData2 = this.imagesMediatorLiveData;
        UIStateData<List<LocalMediaInfo>> uIStateData3 = this.albumIdToImagesUIStateData.get(this.currentAlbumId);
        if (uIStateData3 == null) {
            uIStateData3 = UIStateData.obtainEmpty();
        }
        mediatorLiveData2.setValue(uIStateData3);
        LoadingStatus loadingStatus = this.albumIdToLoadingStatus.get(this.currentAlbumId);
        if (loadingStatus != null && loadingStatus.getNeedLoadMore() && !loadingStatus.getIsQuerying()) {
            w53.b.f(TAG, "switchAlbum trigger queryMediaNext");
            loadingStatus.f(loadingStatus.getTimesOfQuery() + 1);
            com.tencent.mobileqq.wink.picker.core.repository.h hVar2 = this.localMediaRepository;
            String str2 = this.currentAlbumId;
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(TIMES_OF_QUERY, Integer.valueOf(loadingStatus.getTimesOfQuery())));
            hVar2.a(str2, 1000, mutableMapOf);
        }
    }
}
