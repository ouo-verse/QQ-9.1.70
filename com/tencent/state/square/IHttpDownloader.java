package com.tencent.state.square;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/state/square/IHttpDownloader;", "", "download", "", "task", "Lcom/tencent/state/square/IHttpDownloader$Task;", "listener", "Lcom/tencent/state/square/IDownloadListener;", "getIp", "", "getReplaceHost", "needIpConnect", "", "Task", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface IHttpDownloader {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/state/square/IHttpDownloader$Task;", "", "url", "", "savePath", "(Ljava/lang/String;Ljava/lang/String;)V", "getSavePath", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "square_base_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final /* data */ class Task {

        @NotNull
        private final String savePath;

        @NotNull
        private final String url;

        public Task(@NotNull String url, @NotNull String savePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(savePath, "savePath");
            this.url = url;
            this.savePath = savePath;
        }

        public static /* synthetic */ Task copy$default(Task task, String str, String str2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = task.url;
            }
            if ((i3 & 2) != 0) {
                str2 = task.savePath;
            }
            return task.copy(str, str2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getSavePath() {
            return this.savePath;
        }

        @NotNull
        public final Task copy(@NotNull String url, @NotNull String savePath) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(savePath, "savePath");
            return new Task(url, savePath);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Task) {
                    Task task = (Task) other;
                    if (!Intrinsics.areEqual(this.url, task.url) || !Intrinsics.areEqual(this.savePath, task.savePath)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final String getSavePath() {
            return this.savePath;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            int i3;
            String str = this.url;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = i3 * 31;
            String str2 = this.savePath;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            return i17 + i16;
        }

        @NotNull
        public String toString() {
            return "Task(url=" + this.url + ", savePath=" + this.savePath + ")";
        }
    }

    void download(@NotNull Task task, @NotNull IDownloadListener listener);

    @Nullable
    String getIp();

    @NotNull
    String getReplaceHost();

    boolean needIpConnect();
}
