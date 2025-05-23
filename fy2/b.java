package fy2;

import androidx.lifecycle.MutableLiveData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001$B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00060\fj\b\u0012\u0004\u0012\u00020\u0006`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001a0!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0006\u00a2\u0006\f\n\u0004\b'\u0010#\u001a\u0004\b(\u0010%R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0006\u00a2\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b\u000e\u0010%\u00a8\u0006."}, d2 = {"Lfy2/b;", "", "", "duration", "", "e", "Lfy2/a;", "playRecordItem", "g", "f", "b", "Lfy2/a;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "playRecords", "d", "I", "currentVideoDuration", "()I", "setLaunchVV", "(I)V", "launchVV", "setLaunchDuration", "launchDuration", "Lfy2/b$a;", "Lfy2/b$a;", "getCurrentVideoInfo", "()Lfy2/b$a;", "setCurrentVideoInfo", "(Lfy2/b$a;)V", "currentVideoInfo", "Landroidx/lifecycle/MutableLiveData;", h.F, "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "currentVideoDurationLiveData", "i", "getLaunchVVLiveData", "launchVVLiveData", "j", "launchDurationLiveData", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static TVideoPlayRecordItem playRecordItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int currentVideoDuration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int launchVV;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int launchDuration;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f400938a = new b();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<TVideoPlayRecordItem> playRecords = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CurrentVideoInfo currentVideoInfo = new CurrentVideoInfo("", 0);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<CurrentVideoInfo> currentVideoDurationLiveData = new MutableLiveData<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Integer> launchVVLiveData = new MutableLiveData<>();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MutableLiveData<Integer> launchDurationLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0010\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lfy2/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "vid", "b", "I", "()I", "(I)V", "duration", "<init>", "(Ljava/lang/String;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fy2.b$a, reason: from toString */
    /* loaded from: classes19.dex */
    public static final /* data */ class CurrentVideoInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String vid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int duration;

        public CurrentVideoInfo(@NotNull String vid, int i3) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            this.vid = vid;
            this.duration = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        public final void b(int i3) {
            this.duration = i3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CurrentVideoInfo)) {
                return false;
            }
            CurrentVideoInfo currentVideoInfo = (CurrentVideoInfo) other;
            if (Intrinsics.areEqual(this.vid, currentVideoInfo.vid) && this.duration == currentVideoInfo.duration) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.vid.hashCode() * 31) + this.duration;
        }

        @NotNull
        public String toString() {
            return "CurrentVideoInfo(vid=" + this.vid + ", duration=" + this.duration + ")";
        }
    }

    b() {
    }

    @NotNull
    public final MutableLiveData<CurrentVideoInfo> a() {
        return currentVideoDurationLiveData;
    }

    public final int b() {
        return launchDuration;
    }

    @NotNull
    public final MutableLiveData<Integer> c() {
        return launchDurationLiveData;
    }

    public final int d() {
        return launchVV;
    }

    public final synchronized void e(int duration) {
        TVideoPlayRecordItem tVideoPlayRecordItem = playRecordItem;
        if (tVideoPlayRecordItem == null) {
            QLog.e("TVideoPlayRecordRepository", 1, "increasePlayTime recordItem is null!");
            return;
        }
        Intrinsics.checkNotNull(tVideoPlayRecordItem);
        tVideoPlayRecordItem.d(tVideoPlayRecordItem.getDuration() + duration);
        currentVideoDuration += duration;
        launchDuration += duration;
        CurrentVideoInfo currentVideoInfo2 = currentVideoInfo;
        currentVideoInfo2.b(currentVideoInfo2.getDuration() + duration);
        currentVideoDurationLiveData.postValue(currentVideoInfo);
        launchDurationLiveData.postValue(Integer.valueOf(launchDuration));
    }

    public final synchronized void f() {
        playRecordItem = null;
        playRecords.clear();
        currentVideoDuration = 0;
        launchVV = 0;
        launchDuration = 0;
        CurrentVideoInfo currentVideoInfo2 = new CurrentVideoInfo("", 0);
        currentVideoInfo = currentVideoInfo2;
        currentVideoDurationLiveData.postValue(currentVideoInfo2);
        launchVVLiveData.postValue(0);
        launchDurationLiveData.postValue(0);
    }

    public final synchronized void g(@NotNull TVideoPlayRecordItem playRecordItem2) {
        int size;
        Intrinsics.checkNotNullParameter(playRecordItem2, "playRecordItem");
        QLog.i("TVideoPlayRecordRepository", 1, "startNewVideo vid=" + playRecordItem2.getVid());
        playRecordItem = playRecordItem2;
        currentVideoDuration = 0;
        for (int size2 = playRecords.size() - 1; -1 < size2 && Intrinsics.areEqual(playRecords.get(size2).getLaunchId(), playRecordItem2.getLaunchId()); size2--) {
            if (Intrinsics.areEqual(playRecords.get(size2).getVid(), playRecordItem2.getVid())) {
                currentVideoDuration += playRecords.get(size2).getDuration();
            }
        }
        currentVideoInfo.b(currentVideoDuration);
        currentVideoDurationLiveData.postValue(currentVideoInfo);
        MutableLiveData<Integer> mutableLiveData = launchVVLiveData;
        int i3 = launchVV + 1;
        launchVV = i3;
        mutableLiveData.postValue(Integer.valueOf(i3));
        int i16 = 500;
        if (playRecords.size() >= 500 && 500 <= (size = playRecords.size())) {
            while (true) {
                playRecords.remove(0);
                QLog.i("TVideoPlayRecordRepository", 1, "startNewVideo remove oldest items done, size=" + playRecords.size());
                if (i16 == size) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        TVideoPlayRecordItem tVideoPlayRecordItem = playRecordItem;
        if (tVideoPlayRecordItem != null) {
            playRecords.add(tVideoPlayRecordItem);
        }
    }
}
