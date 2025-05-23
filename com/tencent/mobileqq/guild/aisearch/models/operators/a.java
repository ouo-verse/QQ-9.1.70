package com.tencent.mobileqq.guild.aisearch.models.operators;

import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/operators/a;", "", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "", "b", "", "count", "dataTimestamp", "a", "", "c", "Lkotlin/collections/ArrayDeque;", "Lcom/tencent/mobileqq/guild/aisearch/models/operators/a$a;", "Lkotlin/collections/ArrayDeque;", "counts", "I", "windowSizeMs", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayDeque<CountEntry> counts = new ArrayDeque<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int windowSizeMs = 5000;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/aisearch/models/operators/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "count", "", "b", "J", "()J", "timestamp", "<init>", "(IJ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.aisearch.models.operators.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class CountEntry {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int count;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timestamp;

        public CountEntry(int i3, long j3) {
            this.count = i3;
            this.timestamp = j3;
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: b, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CountEntry)) {
                return false;
            }
            CountEntry countEntry = (CountEntry) other;
            if (this.count == countEntry.count && this.timestamp == countEntry.timestamp) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.count * 31) + androidx.fragment.app.a.a(this.timestamp);
        }

        @NotNull
        public String toString() {
            return "CountEntry(count=" + this.count + ", timestamp=" + this.timestamp + ")";
        }
    }

    private final void b(long currentTime) {
        while (this.counts.size() > 5 && currentTime - this.counts.first().getTimestamp() > this.windowSizeMs) {
            this.counts.removeFirst();
        }
    }

    public final void a(int count, long dataTimestamp) {
        this.counts.addLast(new CountEntry(count, dataTimestamp));
        b(dataTimestamp);
    }

    public final float c() {
        if (this.counts.isEmpty()) {
            return 0.0f;
        }
        Iterator<CountEntry> it = this.counts.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().getCount();
        }
        long timestamp = this.counts.last().getTimestamp() - this.counts.first().getTimestamp();
        if (timestamp >= 0) {
            return (i3 * 1000.0f) / ((float) Math.max(timestamp, 1000L));
        }
        s.e("AIChatRepository", "getSpeed: spans is negative, " + this.counts + " ", new IllegalStateException());
        return 0.0f;
    }
}
