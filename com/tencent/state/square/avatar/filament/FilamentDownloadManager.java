package com.tencent.state.square.avatar.filament;

import com.tencent.state.square.SquareBaseKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J\u0016\u0010\u0011\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/avatar/filament/FilamentDownloadManager;", "", "()V", "taskList", "", "", "Lcom/tencent/state/square/avatar/filament/FilamentDownloadManager$DownTask;", "addTask", "", "url", "listener", "Lcom/tencent/state/square/avatar/filament/UnZipListener;", "errorTask", "", "errorCode", "", "errorMessage", "successTask", "moodConfig", "Lorg/json/JSONObject;", "Companion", "DownTask", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FilamentDownloadManager {
    private static final String TAG = "FilamentDownloadManager";
    private final Map<String, DownTask> taskList = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u001c\u0010\u000b\u001a\u00020\t2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\rJ\"\u0010\u000e\u001a\u00020\t2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\t0\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/state/square/avatar/filament/FilamentDownloadManager$DownTask;", "", "url", "", "(Ljava/lang/String;)V", "listeners", "", "Lcom/tencent/state/square/avatar/filament/UnZipListener;", "addListener", "", "listener", "errorListener", "block", "Lkotlin/Function1;", "successListener", "Lkotlin/Function2;", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class DownTask {
        private List<UnZipListener> listeners;

        public DownTask(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.listeners = new ArrayList();
        }

        public final void addListener(UnZipListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listeners.add(listener);
        }

        public final void errorListener(Function1<? super UnZipListener, Unit> block) {
            Object lastOrNull;
            Intrinsics.checkNotNullParameter(block, "block");
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) this.listeners);
            block.invoke(lastOrNull);
        }

        public final void successListener(Function2<? super Integer, ? super UnZipListener, Unit> block) {
            IntRange until;
            Object orNull;
            Intrinsics.checkNotNullParameter(block, "block");
            until = RangesKt___RangesKt.until(0, this.listeners.size());
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                Integer valueOf = Integer.valueOf(nextInt);
                orNull = CollectionsKt___CollectionsKt.getOrNull(this.listeners, nextInt);
                block.invoke(valueOf, orNull);
            }
        }
    }

    public final synchronized boolean addTask(String url, UnZipListener listener) {
        boolean z16;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DownTask downTask = this.taskList.get(url);
        if (downTask != null) {
            downTask.addListener(listener);
            SquareBaseKt.getSquareLog().i(TAG, "addTask: same=" + url);
            z16 = true;
        } else {
            DownTask downTask2 = new DownTask(url);
            downTask2.addListener(listener);
            this.taskList.put(url, downTask2);
            SquareBaseKt.getSquareLog().i(TAG, "addTask: new=" + url);
            z16 = false;
        }
        return z16;
    }

    public final synchronized void errorTask(String url, int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        FilamentZipFileUtils.INSTANCE.deleteCacheFile(url, new FilamentDownloadManager$errorTask$1(this, url, errorCode, errorMessage));
    }

    public final synchronized void successTask(String url, final JSONObject moodConfig) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(moodConfig, "moodConfig");
        DownTask downTask = this.taskList.get(url);
        if (downTask != null) {
            downTask.successListener(new Function2<Integer, UnZipListener, Unit>() { // from class: com.tencent.state.square.avatar.filament.FilamentDownloadManager$successTask$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, UnZipListener unZipListener) {
                    invoke(num.intValue(), unZipListener);
                    return Unit.INSTANCE;
                }

                public final void invoke(final int i3, final UnZipListener unZipListener) {
                    SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.avatar.filament.FilamentDownloadManager$successTask$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            UnZipListener unZipListener2 = unZipListener;
                            if (unZipListener2 != null) {
                                unZipListener2.onTaskSuccess(JSONObject.this);
                            }
                            SquareBaseKt.getSquareLog().i("FilamentDownloadManager", "successTask doListener: " + i3);
                        }
                    });
                }
            });
        }
        this.taskList.remove(url);
        SquareBaseKt.getSquareLog().i(TAG, "successTask: " + url);
    }
}
