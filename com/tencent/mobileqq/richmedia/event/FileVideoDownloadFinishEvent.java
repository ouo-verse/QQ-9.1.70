package com.tencent.mobileqq.richmedia.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/richmedia/event/FileVideoDownloadFinishEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "mediaId", "", "(Ljava/lang/String;)V", "getMediaId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final /* data */ class FileVideoDownloadFinishEvent extends SimpleBaseEvent {

    @Nullable
    private final String mediaId;

    public FileVideoDownloadFinishEvent(@Nullable String str) {
        this.mediaId = str;
    }

    public static /* synthetic */ FileVideoDownloadFinishEvent copy$default(FileVideoDownloadFinishEvent fileVideoDownloadFinishEvent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = fileVideoDownloadFinishEvent.mediaId;
        }
        return fileVideoDownloadFinishEvent.copy(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMediaId() {
        return this.mediaId;
    }

    @NotNull
    public final FileVideoDownloadFinishEvent copy(@Nullable String mediaId) {
        return new FileVideoDownloadFinishEvent(mediaId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof FileVideoDownloadFinishEvent) && Intrinsics.areEqual(this.mediaId, ((FileVideoDownloadFinishEvent) other).mediaId)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getMediaId() {
        return this.mediaId;
    }

    public int hashCode() {
        String str = this.mediaId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "FileVideoDownloadFinishEvent(mediaId=" + this.mediaId + ")";
    }
}
