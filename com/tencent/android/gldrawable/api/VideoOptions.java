package com.tencent.android.gldrawable.api;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/android/gldrawable/api/VideoOptions;", "Lcom/tencent/android/gldrawable/api/GLDrawableOptions;", "()V", "filePath", "", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "isLoop", "", "()Z", "setLoop", "(Z)V", "needThumbnail", "getNeedThumbnail", "setNeedThumbnail", "videoType", "", "getVideoType", "()I", "setVideoType", "(I)V", "toBundle", "Landroid/os/Bundle;", "Companion", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class VideoOptions implements GLDrawableOptions {

    @NotNull
    public static final String NAME = "VideoDrawable";
    public static final int TYPE_ALPHA = 1;
    public static final int TYPE_ALPHA2 = 2;
    public static final int TYPE_NORMAL = 0;
    private int videoType;

    @NotNull
    private String filePath = "";
    private boolean needThumbnail = true;
    private boolean isLoop = true;

    @NotNull
    public final String getFilePath() {
        return this.filePath;
    }

    public final boolean getNeedThumbnail() {
        return this.needThumbnail;
    }

    public final int getVideoType() {
        return this.videoType;
    }

    /* renamed from: isLoop, reason: from getter */
    public final boolean getIsLoop() {
        return this.isLoop;
    }

    public final void setFilePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.filePath = str;
    }

    public final void setLoop(boolean z16) {
        this.isLoop = z16;
    }

    public final void setNeedThumbnail(boolean z16) {
        this.needThumbnail = z16;
    }

    public final void setVideoType(int i3) {
        this.videoType = i3;
    }

    @Override // com.tencent.android.gldrawable.api.GLDrawableOptions
    @NotNull
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("type_flag", NAME);
        bundle.putString("filePath", this.filePath);
        bundle.putBoolean("needThumbnail", this.needThumbnail);
        bundle.putInt("videoType", this.videoType);
        bundle.putBoolean("isLoop", this.isLoop);
        return bundle;
    }
}
