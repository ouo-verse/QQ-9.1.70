package com.tencent.mobileqq.qqvideoedit.editor.export;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\tB\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010\u000eB\u0019\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0004\u00a2\u0006\u0004\b)\u0010*J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\t\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010&\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\"\u001a\u0004\b\u0010\u0010#\"\u0004\b$\u0010%R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b'\u0010\u000e\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/export/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "j", "(I)V", "status", "b", "d", "i", "progress", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "c", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "g", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "localMediaInfo", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "errorMessage", "", "J", "()J", h.F, "(J)V", "processTime", "setProcessType", "processType", "<init>", "(II)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqvideoedit.editor.export.b, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class VideoExportProgress {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int progress;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LocalMediaInfo localMediaInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String errorMessage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long processTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int processType;

    public VideoExportProgress() {
        this(0, 1, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final LocalMediaInfo getLocalMediaInfo() {
        return this.localMediaInfo;
    }

    /* renamed from: b, reason: from getter */
    public final long getProcessTime() {
        return this.processTime;
    }

    /* renamed from: c, reason: from getter */
    public final int getProcessType() {
        return this.processType;
    }

    /* renamed from: d, reason: from getter */
    public final int getProgress() {
        return this.progress;
    }

    /* renamed from: e, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof VideoExportProgress) && this.status == ((VideoExportProgress) other).status) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable String str) {
        this.errorMessage = str;
    }

    public final void g(@Nullable LocalMediaInfo localMediaInfo) {
        this.localMediaInfo = localMediaInfo;
    }

    public final void h(long j3) {
        this.processTime = j3;
    }

    public int hashCode() {
        return this.status;
    }

    public final void i(int i3) {
        this.progress = i3;
    }

    public final void j(int i3) {
        this.status = i3;
    }

    @NotNull
    public String toString() {
        return "VideoExportProgress(status=" + this.status + ")";
    }

    public VideoExportProgress(int i3) {
        this.status = i3;
    }

    public /* synthetic */ VideoExportProgress(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1 : i3);
    }

    public VideoExportProgress(int i3, int i16) {
        this(0, 1, null);
        this.status = i3;
        this.processType = i16;
    }
}
